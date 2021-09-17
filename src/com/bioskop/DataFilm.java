package com.bioskop;

import java.sql.SQLException;
import java.util.Scanner;

public class DataFilm {
    Scanner scan = new Scanner(System.in);

    // data film tidak bisa diakses diluar package
    protected void dataFilm() throws SQLException {
        int pilih = 0;
        Menu clear = new Menu();
                

        do {
            
            System.out.println("======== Data Film ========");
            System.out.println("1. Tambah Film");
            System.out.println("2. Daftar Film");
            System.out.println("3. Tanggal Tayang Paling Terakhir - Paling Awal");
            System.out.println("4. Harga Tiket Film Paling Murah (Max 3 Film)");
            System.out.println("5. Back");
            System.out.println("======================");
            System.out.print("Pilih Data (1/2/3/4/5) : ");
            pilih = scan.nextInt();

            if (pilih == 5) {
                Menu back = new Menu();
                clear.clearConsole();
                back.menuUtama();
            }else if (pilih == 1) {
                TambahFilm tambah = new TambahFilm();
                clear.clearConsole();
                tambah.insertFilm();
            }else if (pilih == 2) {
                DaftarFilm daftar = new DaftarFilm();
                clear.clearConsole();
                daftar.listFilm();
            }else if (pilih == 3) {
                DaftarTayangPalingAwal daftar = new DaftarTayangPalingAwal();
                clear.clearConsole();
                daftar.daftarTayangAwal();
            }else if (pilih == 4) {
                HargaTiketPalingMurah ticketPrice = new HargaTiketPalingMurah();
                clear.clearConsole();
                ticketPrice.hargaTiketPalingMurah();
            }
            
        } while (pilih != 5);

    }
}
