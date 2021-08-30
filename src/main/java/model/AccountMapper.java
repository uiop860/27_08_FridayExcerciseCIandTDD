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
    
    private Connection con;

    public AccountMapper() {
        try {
            this.con = DBConnector.connection();
        } catch (ClassNotFoundException | SQLException ex) {
            this.con = null;
        }
    }
    
    public AccountMapper(Connection con)  {
        this.con = con;
    }
    
    public ArrayList<Account> getAllAccountsFromDB(){
        
        ArrayList<Account> accounts = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM usertable";
            
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
            con.close();
        } catch(SQLException e){
        }
        return accounts;
    }
}
