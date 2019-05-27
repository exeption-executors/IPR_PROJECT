import configuration.IprConfiguration;
import entity.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.ClientRepository;
import service.ClientService;
import service.impl.ClientServiceImpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final Logger logger = LogManager.getLogger(Main.class);

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            logger.info("------------ Hibernate Registry builder created ---------------");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            logger.info("---------- SessionFactory creation failed ------------");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        new Main();
        System.exit(0);
        //        ClientServiceImpl newclient = new ClientServiceImpl();
//        newclient.addClient("testname", "testsurname","testemail@mail.ru", false);
    }
private static  ClientService  setContext() {
    ApplicationContext context = new AnnotationConfigApplicationContext(IprConfiguration.class);
    ClientService clientService = context.getBean(ClientService.class);
    return context.getBean(ClientService.class);

}
private static void getIdByName(ClientService clientService, String name){
    List<Integer> testClient = clientService.getIdByName(name);
//    System.out.println(Stream.as);
    testClient.forEach(System.out::println);
    }

    private void saveClient(String name, String surname, String email, boolean fired) {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to save Client... ------------");

            tx = session.beginTransaction();

            Client client = new Client();

            client.setName(name);
            client.setSurname(surname);
            client.setEmail(email);
            client.setFired(fired);

            session.save(client);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to save Client..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void savePlan() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to save Plan... ------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();

            Plan plan = new Plan();

            plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
            plan.setPlanDateEnd(new Date(dateFormat.parse("02/03/1999").getTime()));

            Client specificClient = session.get(Client.class, 0);

            specificClient.addPlanEntity(plan);
            session.save(specificClient);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to save Plan..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void savePlanTasks() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to save Plan Tasks... ------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();

            PlanTasks planTasks = new PlanTasks();

            planTasks.setPlanTasksDateEnd(new Date(dateFormat.parse("01/02/1999").getTime()));
            planTasks.setPlanTasksDescription("TestDescription1");
            planTasks.setPriority("High");

            Plan specificPlan = session.get(Plan.class, 0);

            specificPlan.addPlanTasksEntity(planTasks);
            session.update(specificPlan);
            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to save Plan Tasks..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }


    private void saveTasksList() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to save Tasks List... ------------");

            tx = session.beginTransaction();

            TasksList tasksList = new TasksList();

            tasksList.setTaskDescription("Test Task List Description1");
            tasksList.setTaskIsDone(true);

            PlanTasks specificPlanTask = session.get(PlanTasks.class, 0);

            specificPlanTask.addTasksList(tasksList);
            session.update(specificPlanTask);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to save Tasks List..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void saveMembersList() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to save Members List... ------------");

            tx = session.beginTransaction();

            MembersList membersList = new MembersList();

            membersList.setRequirements("Test Members List Requirements ");

            PlanTasks specificPlanTask = session.get(PlanTasks.class, 0);

            specificPlanTask.setMembersList(membersList);
            session.update(specificPlanTask);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to save Members list..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void wireMembersListToSpecificClient() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to wire Members List and specific Client... ------------");

            tx = session.beginTransaction();

            Client specificClient = session.get(Client.class, 0);
            MembersList membersList = session.get(MembersList.class, 0);

            specificClient.addMembersListToClient(membersList);
            session.update(specificClient);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to wire members list and specific Client..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void deleteSpecificClientWithCascadeEffect() {
        Transaction tx;
        try (Session session = getSession()) {
            logger.info("------------- attempt to delete a client and cascade delete all related tables... ------------");

            tx = session.beginTransaction();

            Client specificClient = session.get(Client.class, 0);

            session.delete(specificClient);

            tx.commit();
        } catch (Exception e) {
            logger.error("-------------- Failed to delete specific client..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

//    private void test() {
//
//        ClientServiceImpl clientService = new ClientServiceImpl();
//        Client client =  clientService.getByName("TestName1");
//        System.out.println(client.getName());

//    }

    public Main() {
//        saveClient("Mark", "Bryzgalov", "mark@raiffeisen.ru", false);
//        saveClient("Andrey", "Lev", "Andrey@raiffeisen.ru", false);
//        saveClient("Evgeny", "Davidov", "Evgen@raiffeisen.ru", false);
        getIdByName(setContext(), "Andrey");





//       ----- тест добавления пользователя--------
//        setContext();
//        Transaction tx;
//        try(Session session = getSession()) {
//            logger.info("------добавляем клиента-----");
//            tx = session.beginTransaction();
//            Client client = new Client();
//            client.setName("Mark");
//            client.setSurname("Bryzgalov");
//            client.setEmail("Mark@mail.ru");
//            client.setFired(false);
//            Client newClient = setContext().addClient(client);
//            session.save(newClient);
//            tx.commit();
//        }catch (Exception e) {
//            logger.error("Ошибка добавления нового клиента");
//        }




//        ------------------------------
//        savePlan();
//        savePlanTasks();
//        saveTasksList();
//        saveMembersList();
//        wireMembersListToSpecificClient();
//        deleteSpecificClientWithCascadeEffect();
//        test();
    }
}