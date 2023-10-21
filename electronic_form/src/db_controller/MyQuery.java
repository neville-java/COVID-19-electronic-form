/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_controller;

import db_controller.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class MyQuery {

    public Connection getConnection() {
        Connection con = null;
        String URL = "jdbc:mysql://localhost:3306/tracking_register_db";
        String User = "root";
        String Password = " ";

        try {
            con = DriverManager.getConnection(URL, User, Password);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<Product2> BindTable() {
        ArrayList<Product2> list = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select ID,FirstName,LastName,Contact,Age,Address,Email,Temperature,answer1,Answer2 from event_participants");

            Product2 p;
            while (rs.next()) {
                p = new Product2(
                        rs.getInt("ID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Contact"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getDouble("Temperature"),
                        rs.getString("answer1"),
                        rs.getString("answer2")
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
