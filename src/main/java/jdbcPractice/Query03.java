package jdbcPractice;

import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "6901");

        //Statement st = con.createStatement();

        PreparedStatement pStatement = con.prepareStatement("SELECT * FROM ogrenciler");

        ResultSet rSet = pStatement.executeQuery();

        ResultSetMetaData rsmd = rSet.getMetaData();

        System.out.println("Tablodaki sutun sayisi : " + rsmd.getColumnCount());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("1.sutun ismi : " + rsmd.getColumnName(1));
        System.out.println("2.sutun ismi : " + rsmd.getColumnName(2));
        System.out.println("3.sutun ismi : " + rsmd.getColumnName(3));
        System.out.println("4.sutun ismi : " + rsmd.getColumnName(4));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("1.Sutunun Data Tipi : " + rsmd.getColumnTypeName(1));
        System.out.println("2.Sutunun Data Tipi : " + rsmd.getColumnTypeName(2));
        System.out.println("3.Sutunun Data Tipi : " + rsmd.getColumnTypeName(3));
        System.out.println("4.Sutunun Data Tipi : " + rsmd.getColumnTypeName(4));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Tablo ismi : " + rsmd.getTableName(3));

        con.close();
        pStatement.close();
        rSet.close();

    }
}
