/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author olive
 */
public class AccountMapper {
    
    public ArrayList<Account> getAllAccountsFromDB(){
        
        ArrayList<Account> accounts = new ArrayList<>();
        
        try{
            Connection con = DBConnector.connection();
            String sql = "SELECT `usertable`.`id`,\n"
                       + "    `usertable`.`fname`,\n"
                       + "    `usertable`.`lname`,\n"
                       + "    `usertable`.`pw`,\n"
                       + "    `usertable`.`phone`,\n"
                       + "    `usertable`.`address`\n"
                       + "FROM `startcode`.`usertable`;";
            
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String fName = rs.getString("fname");
                String lName = rs.getString("lname");
                String password = rs.getString("pw");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                accounts.add(new Account(id,fName,lName,phone,address,password));
            }
        } catch(SQLException | ClassNotFoundException e){
        }
        return accounts;
    }
}
