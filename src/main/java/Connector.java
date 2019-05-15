import java.sql.*;

public class Connector {
    public static void main(String... args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ipr", "postgres", "postgres")) {
            System.out.println("Connected to PostgreSQL database!");

            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO client (name, surname , email, vacation_date_from, vacation_date_to) " +
                    "VALUES ('tqwe','This','out.gmail.com', '2015-01-01', '2015-01-02')";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table client");

            String sql1 = "INSERT INTO plan (client_id, plan_description)" + "VALUES ('7', 'TESTTESTTEST2')";
            stmt.executeUpdate(sql1);
            System.out.println("Inserted records into the table plan");

            String sql2 = "INSERT INTO plan_tasks_list (plan_id)" + "VALUES ('5')";
            stmt.executeUpdate(sql2);
            System.out.println("Inserted records into the table plan");

            String sql3 = "INSERT INTO task (plan_tasks_list_id, task_description)" + "VALUES ('6', 'TASKTEST3')";
            stmt.executeUpdate(sql3);
            System.out.println("Inserted records into the table plan");



        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
