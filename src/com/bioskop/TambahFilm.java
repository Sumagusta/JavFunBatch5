package com.bioskop;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TambahFilm {
    Scanner scan = new Scanner(System.in);

    public void insertFilm() throws SQLException {
        ConnectionDB connection = new ConnectionDB();
        connection.con = DriverManager.getConnection(connection.url, connection.user, connection.password);

        Menu clear = new Menu();

        try {
            Class.forName(connection.jdbc);

            if (connection.con == null) {
                System.out.println("Connection cannot be established");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        PreparedStatement state = null;

        List<String> namaFilm = new ArrayList<String>();
        List<String> genre = new ArrayList<String>();
        List<Integer> hargaTiket = new ArrayList<Integer>();
        List<String> casting = new ArrayList<String>();

        List<Date> tanggalTayang = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Time> jamTayang = new ArrayList<Time>();
        String inputTime;
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");

        String sql = "insert into film "
                + "(nama_film, genre, harga_tiket, casting, tanggal_tayang, jam_tayang) values (?,?,?,?,?,?)";

        int i = 0;
        String input = "";

        do {

            try {
                System.out.print("Nama Film : ");
                namaFilm.add(scan.nextLine());

                System.out.print("Genre : ");
                genre.add(scan.nextLine());
                // genre.get(i).equals(scan.nextLine());

                System.out.print("Casting : ");
                casting.add(scan.nextLine());
                // casting.get(i).equals(scan.nextLine());

                System.out.print("Tanggal Tayang (yyyy-mm-dd) : ");
                String dataTanggal = scan.next();

                java.util.Date sqlDate = sdf.parse(dataTanggal);
                Date convertDateSQL = new Date(sqlDate.getTime());
                tanggalTayang.add(convertDateSQL);
                // tanggalTayang.get(i).equals();

                System.out.print("Jam Tayang (hh:mm:ss) : ");
                inputTime = scan.next();
                LocalTime time = LocalTime.parse(inputTime, parseFormat);
                Time convertTimeSQL = Time.valueOf(time);
                jamTayang.add(convertTimeSQL);
                // jamTayang.get(i).equals(time.format(parseFormat));

                System.out.print("Harga Tiket : ");
                hargaTiket.add(scan.nextInt());
                // hargaTiket.get(i).equals(scan.nextInt());

                state = (connection.con).prepareStatement(sql);

                // set param
                state.setString(1, namaFilm.get(i));
                state.setString(2, genre.get(i));
                state.setInt(3, hargaTiket.get(i));
                state.setString(4, casting.get(i));
                state.setDate(5, tanggalTayang.get(i));
                state.setTime(6, jamTayang.get(i));
                //state.addBatch();

                // 3. execute SQL
                state.executeUpdate();

                System.out.print("Ketik \"SELESAI\" untuk berhenti, ketik \"APA SAJA\" untuk lanjut : ");
                input = scan.next();
                scan.nextLine();

                if (!input.toLowerCase().equals("selesai")) {
                    clear.clearConsole();
                }else if (input.toLowerCase().equals("selesai")) {
                    clear.clearConsole();                    
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            i++;
        } while (!input.toLowerCase().equals("selesai"));

    }
}
