package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // ---------- 1.ADIM => Driver'a KAYDOL --------------
        Class.forName("org.postgresql.Driver");


        // ---------- 2.ADIM => Database'e BAGLAN ------------
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "6901");


        // ---------- 3.ADIM => Statement OLUSTUR ------------
        Statement st = con.createStatement();


        // ---------- 4.ADIM => Query CALISTIR ----------------

        // TASK-1 : "workers" adında bir table olusturup "worker_id, worker_name, worker_salary" sutunlarini ekleyin.

        String sql1 = "CREATE TABLE workers (workers_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";

        boolean result = st.execute(sql1);

        //System.out.println(result); // false return eder, data cagrilmadi icin

        // TASK-2 : workers table'a worker_address sutunu ekleyerek alter yapin.

        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";

        st.execute(sql2);


        // TASK-3 : Drop workers table

        String sql3 = "DROP TABLE workers";

        st.execute(sql3);


        // ------------ 5.ADIM => Baglanti ve Statement'i KAPAT --------------

        con.close(); // guvenlik amacli kapatilir.
        st.close();


    }
}
