package jdbc;

import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "6901");

        Statement st = con.createStatement();


        // TASK-1: companies tablosundan en yuksek ikinci number_of_employees degeri olan company ve number_of_employees degerlerini cagirin.

        // 1.YONTEM , OFFSET ve FETCH NEXT
        String sql1 = "SELECT company,number_of_employees\n" +
                "FROM companies\n" +
                "ORDER BY number_of_employees DESC\n" +
                "OFFSET 1 ROW\n" +
                "FETCH NEXT 1 ROW ONLY";

        ResultSet rs1 = st.executeQuery(sql1);

        while (rs1.next()) {

            System.out.println("1.YOL, OFFSET ve FETCH NEXT\n" +
                    rs1.getString("company") + " -> " +
                    rs1.getInt("number_of_employees"));
        }

        // 2.YONTEM , SUBQUERIES
        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees = (SELECT MAX(number_of_employees)\n" +
                "                             FROM companies\n" +
                "                             WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "                             FROM companies))";

        ResultSet rs2 = st.executeQuery(sql2);

        while (rs2.next()) {

            System.out.println("2.YOL, SUBQUERIES\n" +
                    rs2.getString("company") + " -> " +
                    rs2.getInt("number_of_employees"));
        }

        con.close();
        st.close();
        rs1.close();
        rs2.close();

    }
}
