package jdbc;

import java.sql.Connection;

public class C08_DBMain {

    public static void main(String[] args) {

        // DBWork objesini olustur
        C07_DBWork dbWork = new C07_DBWork();


        // connection fonksiyonu cagir
        Connection con = dbWork.connect_to_db("techproed", "postgres", "690101");

        // tablo olustur
        dbWork.createTable(con, "employees");
    }
}
