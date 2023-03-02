/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacyjava.AccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dikshant
 */
public class Company_AccessLayer 
{
    Connection Con =null;
    Statement St =null;
    ResultSet Rs=null;
    public void add(String Compid,String Compname,String Compad,String Compexp,String Compphone)
    {
          try
         {
                     Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                     
                   PreparedStatement add=Con.prepareStatement("insert into COMPANYTBL values(?,?,?,?,?)");
                   add.setInt(1,Integer.valueOf(Compid));
                   add.setString(2,Compname);
                    add.setString(3,Compad);
                   add.setInt(4,Integer.valueOf(Compexp));
                   add.setString(5,Compphone);
                 
                      
                   int row=add.executeUpdate();
                   Con.close();
                   
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
    }
    
    public void delete(String Compid)
    {
         try {
                 Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                 String Id=Compid;
                 String Query="Delete from User1.COMPANYTBL where COMPID="+Id;
                 Statement Add=Con.createStatement();
                 Add.executeUpdate(Query);
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
    }
    public void update(String Compid,String Compname,String Compad,String Compexp,String Compphone)
    {
         try
         {
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");        
            String UpdateQuery="UPDATE User1.COMPANYTBL set COMPNAME ='"+Compname+"',COMPAD ='"+Compad+"',COMPEXP ="+Compexp+",COMPPHONE ='"+Compphone+"'where COMPID ="+Compid+"";
            Statement Add=Con.createStatement();
            Add.executeUpdate(UpdateQuery);
         }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
    }
}
