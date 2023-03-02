/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacyjava.AccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pharmacyjava_modelLayer.AgentSelling;

/**
 *
 * @author Dikshant
 */
public class AgentLogin_AccessLayer 
{  
    Connection Con =null;
    Statement St =null;
    ResultSet Rs=null;
    public int login(String UID, String PWD)
    {
        String query="select * from User1.AGENTTBL where ANAME = '"+UID+"' and APASS = '"+PWD+"'";
        try 
        {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
            St = Con.createStatement();
           
            Rs = St.executeQuery(query);
            if(Rs.next())
            {
               return 1;
            }
            else
            {
                return 0;
            }
       }   
       catch (SQLException e)
       {
           e.printStackTrace();
       }
        return 0;
    }
    
}
