package pl.coderslab.entity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
//    to są wywołania z warsztatu z SQL, teraz będą inne
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
//    private static final String DB_USER = "root";
//    private static final String DB_PASS = "coderslab";
//
//    String query1 = "create database workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";
//    String query2 = "create table users (id int(11) not null auto_increment, email varchar(255) not null unique, username varchar(255) not null, password varchar(60) not null, primary key (id))";
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//    }
//
//    public static void main(String[] args) throws SQLException {
//        getConnection();
//    }
//    koniec części zmienianej
    private static DataSource dataSource;
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context)initContext.lookup("java:/comp/env");
                dataSource = (DataSource)envContext.lookup("jdbc/users");
            } catch (NamingException e) { e.printStackTrace(); }
        }
        return dataSource;
    }

    public static void main(String[] args) throws SQLException{
        Connection conn = getConnection();
    }
}
