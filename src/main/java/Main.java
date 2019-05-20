import entity.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final Logger logger = LogManager.getLogger(Main.class);

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            logger.info("------------   Hibernate Registry builder created ---------------");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            logger.info("---------- SessionFactory creation failed ------------");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        new Main();
        System.exit(0);
    }

    private void createClient() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи в Client");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            Client client = new Client();

            client.setName("TestName1");
            client.setSurname("TestSurname1");
            client.setEmail("TestMail1@gmail.com");
            client.setFired(false);

            session.save(client);
            logger.info("------------- Client saved successfully... ------------");

            tx.commit();
            System.out.println("Запись в Client добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save Client..." + e + "----------------");
            System.out.println(e.getMessage());

        } finally {
            session.close();
        }
    }

    private void createPlan() {
        Transaction tx;
        try (Session session = getSession()) {
            System.out.println("Добавление записи в Plan");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            Plan plan = new Plan();
            Client specificClient = session.get(Client.class, 0);

            plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
            plan.setPlanDateEnd(new Date(dateFormat.parse("02/03/1999").getTime()));

            specificClient.addPlanEntity(plan);
//            session.save(plan);
            session.save(specificClient);
            logger.info("------------- Plan saved successfully... ------------");

            tx.commit();
            System.out.println("Запись в Plan добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save Plan.." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void createPlanTask() {
        Transaction tx;
        try (Session session = getSession()) {
            System.out.println("Добавление записи в Plan Task");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            PlanTasks planTasks = new PlanTasks();
            Plan specificPlan = session.get(Plan.class, 0);

            planTasks.setPlanTasksDateEnd(new Date(dateFormat.parse("01/02/1999").getTime()));
            planTasks.setPlanTasksDescription("TestDescription1");
            planTasks.setPriority("High");
            specificPlan.addPlanTasksEntity(planTasks);
//            session.save(planTasks);
            session.save(specificPlan);
            logger.info("------------- Plan Task saved successfully... ------------");
            tx.commit();
            System.out.println("Запись в Plan Task добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save Plan Tasks..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void createTasksList() {
        Transaction tx;
        try (Session session = getSession()) {
            System.out.println("Добавление записи в Tasks List");
            tx = session.beginTransaction();
            TasksList tasksList = new TasksList();
            PlanTasks specificPlanTask = session.get(PlanTasks.class, 0);

            tasksList.setTaskDescription("Test Task List Description1");
            tasksList.setTaskIsDone(true);
            specificPlanTask.addTasksListEntity(tasksList);
//            session.save(tasksList);
            session.save(specificPlanTask);
            logger.info("------------- Tasks List saved successfully... ------------");

            tx.commit();
            System.out.println("Запись в Tasks List добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save TasksList..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    private void createMembersList() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи в Members List");
            tx = session.beginTransaction();
            MembersList membersList = new MembersList();
            PlanTasks specificalPlanTask = session.get(PlanTasks.class, 0);
            membersList.setRequirements("Test Members List Requirements ");
            specificalPlanTask.addMembersListEntity(membersList);
//            session.save(membersList);
            session.save(specificalPlanTask);
            logger.info("------------- Members List saved successfully... ------------");

            tx.commit();
            System.out.println("Запись в Members List добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save Members list..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void wireMembersListToSpecificClient() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Связывание members-листа и клиента");
            tx = session.beginTransaction();

            Client specificClient = session.get(Client.class, 0);
            MembersList membersList = session.get(MembersList.class, 0);

            specificClient.addMembersListToClient(membersList);

            session.update(specificClient);
            tx.commit();

            logger.info("------------- members wired with specific client successfully... ------------");
            System.out.println("client добавлен в members list, таблица m2m пополнилась на одну связь");

        } catch (Exception e) {
            logger.error("-------------- Failed to wire members list and specific client..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void deleteSpecificClientWithCascadeEffect() {
        Transaction tx;
        try (Session session = getSession()) {
            System.out.println("Удаление клиента и каскадное удаление всех связных таблиц");
            tx = session.beginTransaction();


            Client specificClient = session.get(Client.class, 0);

            session.delete(specificClient);

            tx.commit();

            logger.info("------------- client was removed frpm db with connected entities .. ------------");
            System.out.println("client был удален со всеми связынми сущностями");

        } catch (Exception e) {
            logger.error("-------------- Failed to delete specific client..." + e + "----------------");
            System.out.println(e.getMessage());
        }
    }

    public Main() {
//        createClient();
//        createPlan();
//        createPlanTask();
//        createTasksList();
//        createMembersList();
//        wireMembersListToSpecificClient();
        deleteSpecificClientWithCascadeEffect();
    }
}
