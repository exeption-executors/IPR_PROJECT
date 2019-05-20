import entity.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.text.SimpleDateFormat;
import java.sql.Date;

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

    private void recordClient() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи клиента");
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

    private void recordPlan() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи плана");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            PlanEntity plan = new PlanEntity();
           plan.setClientId(1);
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
    private void recordPlanTask() {
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи заданий плана");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();
            PlanTasksEntity planTasks = new PlanTasksEntity();
            planTasks.setPlanId(1);
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

    private  void recordTasksList(){
        Transaction tx;
        Session session = getSession();
        try{
            System.out.println("Добавление записи Tasks List");
            tx = session.beginTransaction();

            TasksListEntity tasksList = new TasksListEntity();
            tasksList.setPlanTaskId(1);
            tasksList.setTaskDescription("85% - процент покрытия на основе отчета (описание задачи)");
            tasksList.setTaskIsDone(true);
            session.save(tasksList);

            tx.commit();

            logger.info("------------- tasks list save save successfully... ------------");
            System.out.println("tasks list добавлен и заполнен");

        } catch (Exception e){
            logger.error("-------------- Failed to save tasks list..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public Main() {
        //recordClient();
       // recordPlan();
        //recordPlanTask();
        recordTasksList();

    }
}
