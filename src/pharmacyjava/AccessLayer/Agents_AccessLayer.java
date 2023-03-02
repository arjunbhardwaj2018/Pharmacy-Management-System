/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacyjava.AccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dikshant
 */
public class Agents_AccessLayer 
{
    Connection Con =null;
    public void add(String Aid,String Aname,String Aage ,String Aphone,String Apass,String gender)
    {
        try
         {
                     Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                     
                   PreparedStatement add=Con.prepareStatement("insert into AGENTTBL values(?,?,?,?,?,?)");
                   add.setInt(1,Integer.valueOf(Aid));
                   add.setString(2,Aname);
                   add.setInt(3,Integer.valueOf(Aage));
                   add.setString(4,Aphone);
                    add.setString(5,Apass);
                   add.setString(6,gender);
                      
                   int row=add.executeUpdate();
                   Con.close();             
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
    }
    
    public void Delete(String Aid)
    {
         try {
                 Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                 String Id=Aid;
                 String Query="Delete from User1.AGENTTBL where AID="+Id;
                 Statement Add=Con.createStatement();
                 Add.executeUpdate(Query);
                } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
    }
    
    public void update(String Aid,String Aname,String Aage ,String Aphone,String Apass,String gender)
    {
        try
         {
                     Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                     
                  String UpdateQuery="UPDATE User1.AGENTTBL set ANAME ='"+Aname+"',AAGE ="+Aage+",APHONE ='"+Aphone+"',APASS ='"+Apass+"',AGENDER ='"+gender+"'where AID ="+Aid+"";
                      
                 Statement Add=Con.createStatement();
                 Add.executeUpdate(UpdateQuery);
                 Con.close();             
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
    }
    
}
