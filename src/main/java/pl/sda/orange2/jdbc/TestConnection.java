package pl.sda.orange2.jdbc;

import pl.sda.orange2.jdbc.config.H2Config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) {
        String className = TestConnection.class.getName();

        String query = """
                SELECT * 
                FROM TEST
                """;


        ResultSet queryResult = null;

        try {
            var one = "one";
            var h2Connection = DriverManager.getConnection(H2Config.DB_URL,
                    H2Config.USER,
                    H2Config.PASSWORD);
            System.out.println("got connection: " + (h2Connection != null));

            Statement queryStatment = h2Connection.createStatement();
            queryResult = queryStatment.executeQuery(query);

            queryResult.next();
            System.out.println(queryResult.getInt(1));
            System.out.println(queryResult.getString(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finally I Know It");
            if (queryResult!=null){
                try {
                    queryResult.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("The End");

    }
}
