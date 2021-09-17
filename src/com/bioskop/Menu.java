package com.bioskop;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void menuUtama() throws SQLException {
        ConnectionDB connection = new ConnectionDB();
        connection.con = DriverManager.getConnection(connection.url, connection.user, connection.password);
        Scanner scan = new Scanner(System.in);
        Menu clear = new Menu();

        int pilih = 0;
        do {
            try {
                Class.forName(connection.jdbc);
                if (connection.con == null) {
                    System.out.println("Koneksi tidak stabil");
                }
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }

            System.out.println("======== MENU ========");
            System.out.println("1. Data Film");
            System.out.println("2. Exit");
            System.out.println("======================");
    
            System.out.print("Pilih 1 / 2 : ");
            pilih = scan.nextInt();
    
            if (pilih == 1) {
                DataFilm df = new DataFilm();
                clear.clearConsole();
                df.dataFilm();
            } else if (pilih==2) {
                clear.clearConsole();
                System.out.println("Terima kasih telah menggunakan aplikasi \"Bioskop\" Kodehive");
            } else {
                clear.clearConsole();
                System.out.println("Maaf pilihan anda tidak terdaftar, silahkan pilih kembali!");
            }
        } while (pilih !=2 );

        //scan.close();
    }

    public final void clearConsole()  
    {  
        try  
        {  
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {}
        }  
        catch (final Exception e)  
        {  
            e.printStackTrace();  
        }  
    }

    public static void main(String[] args) throws SQLException {
        Menu menuUtama = new Menu();
        menuUtama.menuUtama();
    }
}
