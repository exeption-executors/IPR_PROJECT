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
/*        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();*/
    }

    private void recordsClient() {
        Transaction tx;
        Session session = getSession();
        try {
//            System.out.println("Добавление записи клиента");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();

//            ClientEntity client = new ClientEntity();
//            client.setName("Ez");
//            client.setSurname("Eez");
//            client.setEmail("Eeez@gmail.com");
//            client.setFired(false);
////
//            PlanEntity plan = new PlanEntity();
//            plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
//            plan.setPlanDateEnd(new Date(dateFormat.parse("01/04/1999").getTime()));
//            plan.setClientId(1);

//            PlanEntity plan;
//            plan =  (PlanEntity) session.get(PlanEntity.class, 3);
//            System.out.println("--------------------");
//            System.out.println(plan.getId());

//            TasksListEntity tasksList = new TasksListEntity();
//            tasksList.setTaskDescription("adfsaf");
//            tasksList.setTaskIsDone(true);
//////
//////
//             PlanTasksEntity planTasks =  (PlanTasksEntity) session.get(PlanTasksEntity.class, 0);
//////
//            tasksList.setPlanTasksByPlanTasksId(planTasks);
//            session.save(tasksList);


//            ClientEntity client =  (ClientEntity) session.get(ClientEntity.class, 0);
//            System.out.println("--------------------------");
//            System.out.println(client.getId());
//            MembersListEntity membersList = (MembersListEntity) session.get(MembersListEntity.class, 0);
//            client.addMembersListToClient(membersList);




//
//            PlanTasksEntity planTasksList = new PlanTasksEntity();
//            planTasksList.setPlanTasksDateEnd(new Date(dateFormat.parse("01/02/1999").getTime()));
//            planTasksList.setPlanTasksDescription("asdcsvsdv");
//            planTasksList.setPriority("4");
//            planTasksList.setPlanId(1);


//            plan.addPlanTasksList(planTasksList);

//            System.out.println(plan.getId());
//            planTasksList.setPlanTasksDescription("adfsdfa");
//            planTasksList.setPlanTasksDateEnd(new Date(dateFormat.parse("01/04/1999").getTime()));
//            plan.addPlanTasksList(planTasksList);
//            session.save(planTasksList);


//
//            MembersListEntity membersList = new MembersListEntity();
//            membersList.setRequirements("sdfsfdsfs");
//            membersList.setPlanTasksList(0);
//
//            ClientEntity client =  new ClientEntity();
//
//            client.setName("Ezsdfsf");
//            client.setSurname("Eeqwqwdz");
//            client.setEmail("Eeesdsfz@gmail.com");
//            client.setFired(false);
//
//            client.addMembersListToClient(membersList);
            ClientEntity client =  (ClientEntity) session.get(ClientEntity.class, 1);

            MembersListEntity membersList = (MembersListEntity) session.get(MembersListEntity.class, 0);
            client.addMembersListToClient(membersList);
//
            session.update(client);

            tx.commit();
            logger.info("------------- Customer saved successfully... ------------");
            System.out.println("Запись добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save customer..." + e + "----------------");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

//    private void recordsPlan() {
//        Transaction tx;
//        Session session = getSession();
//        try {
////            System.out.println("Добавление записи плана");
////            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////            tx = session.beginTransaction();
//////
//////            PlanEntity plan = new PlanEntity();
//////            PlanTasksEntity planTasks = new PlanTasksEntity();
//////            planTasks.setPlanTasksDescription("Superhero plan");
//////
//////            MembersListEntity membersList = new MembersListEntity();
////         /*   ClientEntity client;
////            client =  (ClientEntity) session.get(ClientEntity.class, 2);*/
////
//////            plan.setClientId(31);
//////            plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
//////            plan.setPlanDateEnd(new Date(dateFormat.parse("02/03/1999").getTime()));
////
////
////
////
//////            session.save();
////
////            tx.commit();
////            logger.info("------------- Customer saved successfully... ------------");
////            System.out.println("Запись добавлена");
//
//        } catch (Exception e) {
//            logger.error("-------------- Failed to save customer..." + e + "----------------");
//            System.out.println(e.getMessage());
//        } finally {
//            session.close();
//        }
//    }

    public Main() {
        recordsClient();
        //recordsPlan();

    }
}
