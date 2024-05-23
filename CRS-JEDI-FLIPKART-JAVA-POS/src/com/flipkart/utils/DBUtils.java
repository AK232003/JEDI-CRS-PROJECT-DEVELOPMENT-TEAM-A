package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author JEDI-Group-C Praneet, Rishabh, Akhil, Manan, Nidhi, Shivanshu, Divyansh
 * Interface for Admin Dao Operations
 *
 */
public class DBUtils {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/crs_database";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "priyanshmehta61";
    private static Connection connection = null;

    /**
     * Constructor to return singleton connection
     * @return Connection
     */
    public static Connection getConnection()
    {
        if (connection != null)
        {
            try
            {
                if (connection.isClosed())
                {
                    connection = null;
                    return getConnection();
                }
                else
                {
                    return connection;
                }
            }
            catch (SQLException e)
            {
                return getConnection();
            }
        }
        else
        {
            try
            {
//                Properties prop = new Properties();
////                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
////                prop.load(inputStream);
//                String driver = prop.getProperty(JDBC_DRIVER);
//                String url = prop.getProperty(DB_URL);
//                String user = prop.getProperty(USER);
//                String password = prop.getProperty(PASS);
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connection established");
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
