/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountMapper;
import model.DBConnector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olive
 */
public class AccountMapperTest {
    
    static Connection con;
    static AccountMapper accountMapper;
    static ArrayList<Account> accounts = new ArrayList<>();
    
    public AccountMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/startcode_test?serverTimezone=Europe/Rome", "dev", "ax2");
            
            String sqlDrop = "drop table if exists usertable;";
            String sqlCreate = "create table usertable("
                        + "id int primary key auto_increment,"
                        + "fname varchar(30),"
                        + "lname varchar(30),"
                        + "pw varchar(50),"
                        + "phone varchar(11),"
                        + "address varchar(50)"
                        + ");";
            String sqlInsert = "insert into usertable (fname, lname, pw, phone, address)"
                        + "values (\"Henning\",\"Dahl\",\"sdfw333\",\"+4540949403\",\"Rolighedsvej 22, 2100 Kbh Ø\"),"
                        + "(\"Hannah\",\"Dinesen\",\"fsdkk653kk\",\"+4540546754\",\"Rolighedsvej 67, 2100 Kbh Ø\"),"
                        + "(\"Amin\",\"Kotchic\",\"lkjnnn443\",\"+4540345469\",\"Rolighedsvej 90, 2100 Kbh Ø\"),"
                        + "(\"Harun\",\"Dupsmith\",\"kothis55\",\"+4540677667\",\"Rolighedsvej 104, 2100 Kbh Ø\");";
            con.prepareStatement(sqlDrop).executeUpdate();
            con.prepareStatement(sqlCreate).executeUpdate();
            con.prepareStatement(sqlInsert).executeUpdate();
            accountMapper = new AccountMapper(con);
            accounts = accountMapper.getAllAccountsFromDB();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("damn");
        }
    }
    
    @After
    public void tearDown() {
    }
    
    /* My tests */
    
    @Test
    public void testGetHenning(){
        assertEquals("Henning", accounts.get(0).getFirstName());
    }
    
    @Test
    public void testGetPhoneHannah(){
        assertEquals("+4540546754", accounts.get(1).getPhone());
    }    
}













