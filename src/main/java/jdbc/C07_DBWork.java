package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C07_DBWork {

    public Connection connect_to_db(String dbName, String user, String password) { // PostgreSQL baglantisi methodu

        Connection con = null;
        try {

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);

            if (con != null) System.out.println("Baglanti Saglandi");
            else System.out.println("Baglanti Saglanamadi");

        } catch (Exception e) {

            System.out.println(e);
        }

        return con;

    }//method son

    public void createTable(Connection con, String tableName) { // Yeni table olusturma method'u

        // Statement objesi olustur
        Statement statement;

        try {

            String query = "CREATE TABLE " + tableName + "(emp_id SERIAL, name VARCHAR(100), email VARCHAR(100), salary INT, PRIMARY KEY(emp_id))";

            statement = con.createStatement();

            statement.executeUpdate(query);

            System.out.println(tableName + " table olusturuldu");


        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
