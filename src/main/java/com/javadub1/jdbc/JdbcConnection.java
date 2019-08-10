package com.javadub1.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnection {

    private JdbcSettings jdbcSettings;

    public JdbcConnection() throws IOException{
        this.jdbcSettings = new JdbcSettings();
    }
    public MysqlDataSource getDataSource() {
        //stworzenie polaczenia bazodanowego
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName(jdbcSettings.getJdbcHost());
        mysqlDataSource.setPort(Integer.parseInt(jdbcSettings.getJdbcPort()));
        mysqlDataSource.setUser(jdbcSettings.getJdbcUsername());
        mysqlDataSource.setPassword(jdbcSettings.getJdbcPassword());
        mysqlDataSource.setDatabaseName(jdbcSettings.getJdbcDatabaseName());

        try {
            mysqlDataSource.setUseSSL(false);  //szyfrowanie, wlaczamy
            mysqlDataSource.setServerTimezone("UTC");  // strefa czasowa, ustawiamy
            mysqlDataSource.setAllowPublicKeyRetrieval(true);
        } catch (SQLException e) {
            System.err.println("Error, unable to set ssl/timezone!");

            JOptionPane.showMessageDialog(null, "Unaable to connect. ");
            System.exit(1);
            //status 1- blad polaczenia bazodanowego
        }
        return mysqlDataSource;

    }
    public Connection getConnection () throws SQLException {
        Connection mysqlConnection = getDataSource().getConnection();
        return mysqlConnection;
    }
    }
