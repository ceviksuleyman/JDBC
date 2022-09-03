package jdbc;

import java.sql.*;

public class C04_ExecuteUpdate {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "690101");

        Statement st = con.createStatement();


        // TASK-2: number_of_employees degeri, ortalama calisan sayisindan az olan number_of_employees degerlerini 16000 olarak UPDATE edin.

        String sql1 = "UPDATE companies\n" +
                "SET number_of_employees = 16000\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees)\n" +
                "                             FROM companies)";

        int updateSatirSayisi = st.executeUpdate(sql1); // update edilen satir sayisini return eder.

        System.out.println("updateSatirSayisi = " + updateSatirSayisi);

        String sql2 = "SELECT * FROM companies";

        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + " -> " + result1.getString(2) + " -> " + result1.getInt(3));
        }

        con.close();
        st.close();
        result1.close();
    }
}
