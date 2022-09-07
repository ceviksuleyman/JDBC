package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres", "690101");

        Statement st = con.createStatement();

        // TASK-1 : ogrenciler tablosuna yeni bir kayit ekleyin (300, 'Sena Can', '12', 'K')
        //int s1 = st.executeUpdate("INSERT INTO ogrenciler VALUES(301, 'Sena Can', '12', 'K')");
        //System.out.println(s1 + " satir database'e eklendi"); // 1 satir database'e eklendi


        // TASK-2 : ogrenciler tablosuna birden fazla veri ekleyin

        // 1.YONTEM
        //String[] data = {"INSERT INTO ogrenciler VALUES(404, 'Murtaza Can', '11', 'E')",
        //        "INSERT INTO ogrenciler VALUES(402, 'Murtaza Can', '10', 'E')",
        //        "INSERT INTO ogrenciler VALUES(403, 'Murtaza Can', '12', 'E')"};

        //int count = 0;
        //for (String w : data) {
        //    count += st.executeUpdate(w);
        //}
        //System.out.println(count + " data girisi saglandi.");

        // 2.YONTEM
        String[] data2 = {"INSERT INTO ogrenciler VALUES(505, 'Sena Can', '11', 'K')",
                "INSERT INTO ogrenciler VALUES(506, 'Sena Can', '10', 'K')",
                "INSERT INTO ogrenciler VALUES(507, 'Sena Can', '12', 'K')"};

        for (String w : data2) {
            st.addBatch(w); // yukaridaki datalarin hepsini birlestiriyor
        }
        st.executeBatch(); // datalari tek seferde gonderdi.

        con.close();
        st.close();
    }
}
