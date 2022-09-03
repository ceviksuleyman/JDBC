package jdbc;

import java.sql.*;

public class C06_CallableStatement {
      /*
     Java'da method'lar return type sahibi olsa da,void olsa da method olarak adlandirilir.

     SQL'de ise data return ediyorsa "function" denir.

     Return yapmiyorsa "procedure" diye anlandirilir.
     */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "690101");

        Statement st = con.createStatement();

        // TASK-1 : İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        // 1.ADIM : Fonksiyon kodunu yaz.
        String sql1 = "CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC,y NUMERIC) \n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$";

        // 2.ADIM : FOnksiyonu calistir.
        st.execute(sql1);

        // 3.ADIM : Fonksiyonu cagir.
        CallableStatement callSt1 = con.prepareCall("{? = call toplamaF(?,?)}");

        // 4.ADIM : Return icin registerOutParameter() method'unu, parametreler icin set() method'larindan uygun olanlari kullan
        callSt1.registerOutParameter(1, Types.NUMERIC);
        callSt1.setInt(2, 14);
        callSt1.setInt(3, 25);

        // 5.ADIM : Calistirmak icin execute() method'unu kullan.
        callSt1.execute();

        // 6.ADIM : Sonucu cagirmak icin return data tipine gore "get" method'larindan uygun olani kullan
        System.out.println(callSt1.getBigDecimal(1));


        //---------------------------------------------------------------------------------------------------------


        // TASK-2 : Koninin hacmini hesaplayan bir function yazın.
        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC,h NUMERIC) \n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN 3.14 * r * r * h / 3;\n" +
                "\n" +
                "END\n" +
                "$$";

        st.execute(sql2);

        CallableStatement callSt2 = con.prepareCall("{? = call koniHacmi(?,?)}");

        callSt2.registerOutParameter(1, Types.NUMERIC);
        callSt2.setInt(2, 3);
        callSt2.setInt(3, 4);

        callSt2.execute();

        System.out.println(callSt2.getBigDecimal(1));
    }

}
