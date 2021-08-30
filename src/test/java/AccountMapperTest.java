/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Account;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try{
            con = DBConnector.connection();
            String sql = "use startcode_test;\n"
                       + "drop table if exists usertable ;\n"
                       + "create table usertable(\n"
                       + "id int primary key auto_increment,\n"
                       + "fname varchar(30),\n"
                       + "lname varchar(30),\n"
                       + "pw varchar(50),\n"
                       + "phone varchar(11),\n"
                       + "address varchar(50)\n"
                       + ");\n"
                       + "insert into usertable (fname, lname, pw, phone, address)\n"
                       + "values "
                       + "(\"Henning\",\"Dahl\",\"sdfw333\",\"+4540949403\",\"Rolighedsvej 22, 2100 Kbh Ø\"),\n"
                       + "(\"Hannah\",\"Dinesen\",\"fsdkk653kk\",\"+4540546754\",\"Rolighedsvej 67, 2100 Kbh Ø\"),\n"
                       + "(\"Amin\",\"Kotchic\",\"lkjnnn443\",\"+4540345469\",\"Rolighedsvej 90, 2100 Kbh Ø\"),\n"
                       + "(\"Harun\",\"Dupsmith\",\"kothis55\",\"+4540677667\",\"Rolighedsvej 104, 2100 Kbh Ø\");";
            con.prepareStatement(sql).executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("damn");
        }
        accountMapper = new AccountMapper();
        accounts = accountMapper.getAllAccountsFromDB();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDBConnection() throws SQLException{
        assertTrue(con.isValid(0));
    }
    
    @Test
    public void testGetHenning(){
        assertEquals("Henning", accounts.get(0).getFirstName());
    }
    
    @Test
    public void testGetPhoneHannah(){
        assertEquals("+4540546754", accounts.get(1).getPhone());
    }    
}













