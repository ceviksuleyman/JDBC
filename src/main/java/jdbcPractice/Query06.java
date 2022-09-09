package jdbcPractice;

import static jdbcPractice.DatabaseUtilty.*;

public class Query06 {

    public static void main(String[] args) {

        createConnection(); // Database ile baglanti kuruldu


        String query = "SELECT * FROM ogrenciler";
        System.out.println("Tablodaki Sutun isimleri : " + getColumnNames(query));


        System.out.println("Okul NO : " + getColumnData(query, "okul_no"));
        System.out.println("Ogrenci isimleri : " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("Sinif : " + getColumnData(query, "sinif"));
        System.out.println("Cinsiyet : " + getColumnData(query, "cinsiyet"));

    }
}
