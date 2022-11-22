package jdbcPractice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtilty {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() { // Method1 -> Database ile baglanti olustur

        String url = "jdbc:postgresql://localhost:5432/techproed";
        String user = "postgres";
        String password = "690101";
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//method1 son


    public static List<Object> getColumnData(String query, String column) { // method2 -> bir sutundaki tum verileri al

        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;

    }//method2 son

    public static void executeQuery(String query) { // method3

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }//method3 son

    public static List<String> getColumnNames(String query) { // method4 -> tablodaki sutun isimlerini ver

        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;

    }//method4 son
}//class
