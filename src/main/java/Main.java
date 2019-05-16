import Entity.ClientEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.sql.Date;

import javax.persistence.metamodel.EntityType;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Map;

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
    private void recordsClient(){
        Transaction tx;
        Session session = getSession();
        try {
            System.out.println("Добавление записи");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tx = session.beginTransaction();

            ClientEntity client = new ClientEntity();
            client.setName("Ez");
            client.setSurname("Eez");
            client.setEmail("Eeez@gmail.com");
            client.setVacationDateFrom(new Date(dateFormat.parse("01/02/1999").getTime()));
            client.setVacationDateTo(new Date(dateFormat.parse("02/03/1999").getTime()));

            session.save(client);

            tx.commit();
            logger.info("------------- Customer saved successfully... ------------");
            System.out.println("Запись добавлена");

        } catch (Exception e) {
            logger.error("-------------- Failed to save customer..." + e + "----------------");
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
    }

    public Main(){
        recordsClient();
        }

    }