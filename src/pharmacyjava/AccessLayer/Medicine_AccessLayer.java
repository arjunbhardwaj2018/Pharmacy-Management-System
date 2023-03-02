/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacyjava.AccessLayer;
import java.util.*;
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
public class Medicine_AccessLayer {
    
    Connection Con =null;
    Statement St =null;
    ResultSet Rs=null;
    
    public void getComp(ArrayList<String> ar) {
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
            St = Con.createStatement();
            String query="select * from User1.COMPANYTBL";
            Rs = St.executeQuery(query);
            while(Rs.next())
            {
                String Mycomp=Rs.getString("COMPNAME");
                ar.add(Mycomp);
            }
       }   
       catch (SQLException e)
       {
           e.printStackTrace();
       }
        return;
    }
    
    public int add(String MedID,String MedName,String MedPrice, String MedQty,String ExpDate,String MfgDate,String Company) {
        try
         {
                   Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");  
                   PreparedStatement add=Con.prepareStatement("insert into MEDICINETBL values(?,?,?,?,?,?,?)");
                   add.setInt(1,Integer.parseInt(MedID));
                   add.setString(2,MedName);
                   add.setInt(3,Integer.parseInt(MedPrice));
                   add.setInt(4,Integer.parseInt(MedQty));
                   add.setString(5,ExpDate);
                   add.setString(6, MfgDate);
                   add.setString(7,Company);   
                   int row=add.executeUpdate();
                   Con.close();
                 return 1;
         }
         catch(SQLException e)
         {
             return 0;
         }
    }
    
    public int delete(String MedID)
    {
         try
         {
                Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                String Id=MedID;
                //String query="select MEDID from User1.MEDICINETBLE where MEDID = "+Id;
                //Statement Add=Con.createStatement();
                St = Con.createStatement();
                //Rs = St.executeQuery(query);
                String Query="Delete from User1.MEDICINETBL where MEDID="+Id;
                St.executeUpdate(Query);
                 return 1; 
         }
            catch (SQLException e) 
            {
                return 0;
            }
    }
    public int update(String MedID,String MedName,String MedPrice, String MedQty,String ExpDate,String MfgDate,String Company)
    {
         try 
         {
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
            String UpdateQuery="UPDATE User1.MEDICINETBL set MEDNAME ='"+MedName+"',MEDPRICE ="+MedPrice+",MEDQTY ="+MedQty+",MEDMFG ='"+MfgDate+"',MEDEXP ='"+ExpDate+"',MEDCOMP ='"+Company+"'where MEDID ="+MedID+"";
            Statement Add=Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            return 1;
         }
         catch (SQLException e)
         {
            return 0;
         }
                  
    }
}
