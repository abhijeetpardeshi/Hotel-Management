import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con_class {
    public Connection connection;
    public Statement statement;

    public con_class() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Connect to MySQL
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotelms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root",
                    "Abhijeet"
            );
            System.out.println("Connection established.");

            // Create statement
            statement = (Statement) connection.createStatement();
            System.out.println("Statement created.");

        } catch (Exception e) {
            System.out.println("Error in con_class constructor:");
            e.printStackTrace();  // Shows the actual line & cause
        }
    }
}