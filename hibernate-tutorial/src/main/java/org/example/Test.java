package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class Test {
    public static void main( String[] args ) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user="hbstudent";
        String pass ="Arifa@786";
        try{
            System.out.println("Connecting to DB : "+jdbcUrl);
            Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection Successfull !!");

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

}
