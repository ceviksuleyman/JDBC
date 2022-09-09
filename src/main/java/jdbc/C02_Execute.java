package jdbc;

import java.sql.*;

public class C02_Execute {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "6901");

        Statement st = con.createStatement();


        // TASK-1 :  region_id'si 1 olan "country name" degerlerini cagirin.
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";

        // NOTE => record'lari gormek icin executeQuery() method'u kullanmaliyiz.

        ResultSet rs1 = st.executeQuery(sql1);

        while (rs1.next()) {
            System.out.println(rs1.getString("country_name"));
        }


        // TASK-2 : "region_id" nin 2'den buyuk oldugu "country_id" ve "country_name" degerlerini cagirin.
        String sql2 = "SELECT country_id, country_name FROM countries WHERE region_id > 2";

        ResultSet rs2 = st.executeQuery(sql2);

        while (rs2.next()) {
            System.out.println(rs2.getString("country_id") + " => " + rs2.getString("country_name"));
        }


        // TASK-3 : "number_of_employees" degeri en dusuk olan satirin tum degerlerini cagirin.
        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";

        ResultSet rs3 = st.executeQuery(sql3);

        while (rs3.next()) {
            System.out.println(rs3.getInt("company_id") + " => " +
                    rs3.getString("company") + " -> " +
                    rs3.getInt("number_of_employees"));
        }


        con.close();
        st.close();

    }
}
