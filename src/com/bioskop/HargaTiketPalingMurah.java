package com.bioskop;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HargaTiketPalingMurah {

    public void hargaTiketPalingMurah() throws SQLException {
        ConnectionDB connection = new ConnectionDB();
        connection.con = DriverManager.getConnection(connection.url, connection.user, connection.password);
// sebelum data
// data : nama, genre
        try {
            Class.forName(connection.jdbc);

            if (connection.con == null) {
                System.out.println("Connection cannot be established");
            }

            Statement state = connection.con.createStatement();

            String sql = "SELECT f.nama_film, f.genre, f.casting, f.tanggal_tayang, f.jam_tayang, MIN(f.harga_tiket) as harga_termurah FROM film f group by f.nama_film limit 3";

            ResultSet rs = state.executeQuery(sql);

            int i = 0;
            System.out.println();
            String header = "Harga tiket paling murah (3 film)";
            System.out.println(header.toUpperCase() + "\n");
            while (rs.next()) {
                i++;
                System.out.println(i + " " + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
                System.out.println("------------------------------------------");

            }

            // System.out.println("1. Back");
            // System.out.println("2. Exit");

            // int input = scan.nextInt();
            // if (input==1) {
            // Menu menu = new Menu();
            // menu.menuUtama();
            // } else {
            // scan.close();
            // connection.con.close();
            // }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
