package jdbc;

import java.sql.*;

public class C05_PreparedStatement {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "6901");

        Statement st = con.createStatement();

        // TASK-3: Prepared statement kullanarak company adi IBM olan number_of_employees degerini 9999 olarak guncelleyin.

        // 1.ADIM : Prepared statement query'sini olustur.
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        // 2.ADIM : preparedStatement objesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);

        // 3.ADIM : set..() method'lari ile ?(soru isaretleri) icin deger gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        // 4.ADIM : Execute Query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " Satir Guncellendi");

        String sql2 = "SELECT * FROM companies";

        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + " -> " + result1.getString(2) + " -> " + result1.getInt(3));
        }


        // GOOGLE icin degisiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");

        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2 + " Satir Guncellendi");

        String sql3 = "SELECT * FROM companies";

        ResultSet result2 = st.executeQuery(sql3);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + " -> " + result2.getString(2) + " -> " + result2.getInt(3));
        }


        //TASK-4 : "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        System.out.println("~~~~~~~~~~~~~~~~~~");
        read_data(con, "countries");

        con.close();
        st.close();
        result2.close();
        result1.close();


    }//main

    //Bir tablonun istenilen datasini prepared statement ile cagirmak icin kullanilan method.
    public static void read_data(Connection con, String tableName) { // method

        try {
            String query = String.format("SELECT * FROM %s", tableName);// format(), dinamik String olusturmak icin

            Statement statement = con.createStatement();

            // SQL query'i calistir.
            ResultSet resultSet = statement.executeQuery(query); // datayi cagirip resultSet konteynirina koyuyuoruz.

            while (resultSet.next()) { // tum datayi cagir

                System.out.println(resultSet.getString(1) + " -> " +
                        resultSet.getString(2) + " -> " +
                        resultSet.getInt(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//methos son

}//class
