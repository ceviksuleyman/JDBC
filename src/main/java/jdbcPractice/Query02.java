package jdbcPractice;

import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "6901");

        Statement st = con.createStatement();

        // TASK-1 : ogrenciler tablosundan erkek ogrencileri siralayiniz

        String query = "SELECT * FROM ogrenciler WHERE cinsiyet = 'E'";

        ResultSet data = st.executeQuery(query);

        System.out.println("OKUL NO  OGRENCI ISIM  SINIF   CINSIYET");
        while (data.next()) {

            System.out.printf("%-8d %-15.15s %-8s %-8s\n",
                    data.getInt(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4));

        }
        con.close();
        st.close();
        data.close();

    }
}
