package jdbcPractice;

import java.sql.*;

public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "6901");

        //Statement st = con.createStatement();


        // NOTE : DB'de trafigi rahatlatmak icin PreparedStatement Statement'e gore daha iyidir.

        PreparedStatement pSt = con.prepareStatement("INSERT INTO ogrenciler VALUES(?, ?, ?, ?)");

        pSt.setInt(1, 205);
        pSt.setString(2, "Veli Can");
        pSt.setString(3, "12");
        pSt.setString(4, "E");

        System.out.println(pSt.executeUpdate() + " veri girisi yapildi."); // 1 veri girisi yapildi.

        con.close();
        pSt.close();

    }
}
