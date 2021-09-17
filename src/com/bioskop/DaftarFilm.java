package com.bioskop;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaftarFilm {

    public void listFilm() throws SQLException {
        ConnectionDB connection = new ConnectionDB();
        connection.con = DriverManager.getConnection(connection.url, connection.user, connection.password);

        try {
            Class.forName(connection.jdbc);

            if (connection.con == null) {
                System.out.println("Connection cannot be established");
            }

            Statement state = connection.con.createStatement();

            String sql = "SELECT f.nama_film, f.genre, f.harga_tiket, f.casting, f.tanggal_tayang, f.jam_tayang FROM film f";

            ResultSet rs = state.executeQuery(sql);
            
            // sebelum data (ResultSet)
            //data nama

            int i = 0;
            String header = "daftar semua film";
            System.out.println(header.toUpperCase()+"\n");
            
            // next() = memindahkan kursor maju satu line, dari posisi sekarang. 
            // Karna kursor resultset posisi awalnya sebelum baris pertama. 
            // Saat kita lakukan next maka ia akan masuk ke baris pertama untuk panggilan pertama.
            while (rs.next()) {  
                i++;
                System.out.println(i + " " + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
                        + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
                System.out.println("------------------------------------------");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
