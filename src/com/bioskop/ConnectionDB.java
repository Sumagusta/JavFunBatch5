package com.bioskop;

import java.sql.Connection;

public class ConnectionDB {
        
        public String jdbc = "com.mysql.cj.jdbc.Driver";
        public String url = "jdbc:mysql://localhost:3306/bioskop";
        public String user = "root";
        public String password = "kodehive2020";
        public Connection con = null;
}
