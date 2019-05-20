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
//            System.out.println("Добавление записи клиента");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            ClientEntity client = new ClientEntity();
            client.setName("TestName1");
            client.setSurname("TestSurname1");
            client.setEmail("TestMail1@gmail.com");
            client.setFired(false);
            session.save(client);
            tx.commit();
            logger.info("------------- Customer saved successfully... ------------");
            System.out.println("Запись клиента добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save customer..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void createPlan() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи плана");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            PlanEntity plan = new PlanEntity();
            plan.setClientId(0);
            plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
            plan.setPlanDateEnd(new Date(dateFormat.parse("02/03/1999").getTime()));
            session.save(plan);
            System.out.println("Запись плана добавлена");
            tx.commit();

        } catch (Exception e) {
            logger.error("-------------- Failed to save customer..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void createPlanTask() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи заданий плана");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            PlanTasksEntity planTasks = new PlanTasksEntity();
            planTasks.setPlanId(0);
            planTasks.setPlanTasksDateEnd(new Date(dateFormat.parse("01/02/1999").getTime()));
            planTasks.setPlanTasksDescription("TestDescription1");
            planTasks.setPriority("High");
            session.save(planTasks);
            System.out.println("Запись заданий плана добавлена");
            tx.commit();

        } catch (Exception e) {
            logger.error("-------------- Failed to save customer..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void createTasksList() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи Tasks List");
            tx = session.beginTransaction();

            TasksListEntity tasksList = new TasksListEntity();
            tasksList.setPlanTaskId(0);
            tasksList.setTaskDescription("85% - процент покрытия на основе отчета (описание задачи)");
            tasksList.setTaskIsDone(true);
            session.save(tasksList);

            tx.commit();

            logger.info("------------- tasks list save save successfully... ------------");
            System.out.println("tasks list добавлен и заполнен");

        } catch (Exception e) {
            logger.error("-------------- Failed to save tasks list..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private void createMembersList() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Создание members-листа");
            tx = session.beginTransaction();

            MembersListEntity membersList = new MembersListEntity();
            membersList.setPlanTasksList(0);
            membersList.setRequirements("Все должно быть сделано на уровне mvp: Шоб работало");

            session.save(membersList);
            tx.commit();

            logger.info("------------- members list save save successfully... ------------");
            System.out.println("members list создан и добавлен в базу");

        } catch (Exception e) {
            logger.error("-------------- Failed to save members list..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

//    private void wireMembersListToSpecificClient() {
//        Transaction tx;
//        Session session = getSession();
//        try {
//            System.out.println("Связывание members-листа и клиента");
//            tx = session.beginTransaction();
//
//
//            ClientEntity specificClient = (ClientEntity) session.get(ClientEntity.class, 0);
//            MembersListEntity membersList = (MembersListEntity) session.get(MembersListEntity.class, 0);
//
//            specificClient.addMembersListToClient(membersList);
//
//            session.update(specificClient);
//            tx.commit();
//
//            logger.info("------------- members wired with specific client successfully... ------------");
//            System.out.println("client добавлен в members list, таблица m2m пополнилась на одну связь");
//
//        } catch (Exception e) {
//            logger.error("-------------- Failed to wire members list and specific client..." + e + "----------------");
//            System.out.println(e.getMessage());
//        } finally {
//            session.close();
//        }
//    }

    private void deleteSpecificClientWithCascadeEffect() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Удаление клиентаи каскадное удаление всех связных таблиц");
            tx = session.beginTransaction();


            ClientEntity specificClient = (ClientEntity) session.get(ClientEntity.class, 0);

            session.delete(specificClient);

            tx.commit();

            logger.info("------------- client was removed frpm db with connected entities .. ------------");
            System.out.println("client был удален со всеми связынми сущностями");

        } catch (Exception e) {
            logger.error("-------------- Failed to delete specific client..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public Main() {
//        createClient();
        createPlan();
//        createPlanTask();
//        createTasksList();
//        createMembersList();
//        wireMembersListToSpecificClient();
        //deleteSpecificClientWithCascadeEffect();
    }
}
