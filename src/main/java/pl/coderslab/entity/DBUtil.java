package pl.coderslab.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    String query1 = "create database workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";
    String query2 = "create table users (id int(11) not null auto_increment, email varchar(255) not null unique, username varchar(255) not null, password varchar(60) not null, primary key (id))";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
