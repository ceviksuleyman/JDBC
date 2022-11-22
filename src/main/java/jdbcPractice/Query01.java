package jdbcPractice;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver Yukle
        Class.forName("org.postgresql.Driver");

        // 2) Database'e Baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "690101");

        // 3) Statement Olustur
        Statement st = con.createStatement();

        // 4) ResulSet
        ResultSet rst1 = st.executeQuery("SELECT * FROM ogrenciler");


        System.out.println("OKUL NO  OGRENCI ISIM  SINIF   CINSIYET");

        while (rst1.next()) {

            // index kullanarak
            //System.out.println(rst1.getInt(1) + "-> " +
            //        rst1.getString(2) + "-> " +
            //        rst1.getString(3) + "-> " +
            //        rst1.getString(4));

            System.out.printf("%-8d %-15.15s %-8s %-8s\n",
                    rst1.getInt(1),
                    rst1.getString(2),
                    rst1.getString(3),
                    rst1.getString(4));


            // sutun ismi kullanarak
            //System.out.println(rst1.getInt("okul_no") + "-> " +
            //        rst1.getString("ogrenci_ismi") + "-> " +
            //        rst1.getString("sinif") + "-> " +
            //        rst1.getString("cinsiyet"));
        }

        con.close();
        st.close();
        rst1.close();

    }
}
