/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.sql.*;


/**
 *
 * @author Administrator
 */
public class ConnectDB {
    private static Connection con = null;
     private static String url = "jdbc:sqlserver://";
     private static String serverName= "localhost";
     private static String portNumber = "1433";
     private static String databaseName= "LogTime";
     private static String userName = "sa";
     private static String passWord= "123456";

     public ConnectDB()
     {}
     
     public static String getConnectionUrl()
     {
         return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + ";userName="+userName+";passWord="+passWord+"; integratedSecurity=false";
     }

     public static Connection getConnection()
     {
          try
          {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
               con = DriverManager.getConnection(getConnectionUrl());
          }
          catch(Exception e)
          {
              con = null;
          }
          return con;
      }

     public static void closeConnection()
     {
          try
          {
               if(con!=null)
                    con.close();
               con=null;
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
     }
    
}
