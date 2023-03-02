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
public class Sellin_AccessLayer {
    Connection Con =null;
    public void update(int newQty, int Medid)
    {
         try {
                     Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                       
                     String UpdateQuery="UPDATE User1.MEDICINETBL set MEDQTY ="+newQty+"where MEDID ="+Medid+"";
                       
                    Statement Add=Con.createStatement();
                    Add.executeUpdate(UpdateQuery);
               
                   // JOptionPane.showMessageDialog(this, "Medicine Updated Successfully");
                 
                   } 
                   catch (SQLException e)
                   {
                       e.printStackTrace();
                   }
    }
    
    public void addbill(int i,String Medtext,String Qty, int price,int sumTotal,String billtext, String tempDate)
    {
        if(i==1)
        {
              //--------------------------------------
              try
                  {
                     Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                     
                   PreparedStatement add=Con.prepareStatement("insert into BILLHISTORY values(?,?,?,?,?,?,?)");
                   add.setString(1,billtext);
                   add.setString(2, tempDate);
                   add.setInt(3,i);
                   add.setString(4,Medtext);
                   add.setInt(5,Integer.valueOf(Qty));
                   add.setInt(6,price);
                   add.setInt(7, sumTotal);
                      
                   int row=add.executeUpdate();
                    Con.close();
                  }
                  catch(SQLException e)
                    {
                         e.printStackTrace();
                    }
              //------------------------------------
        }
        else
        {
          try
            {
                Con=DriverManager.getConnection("jdbc:derby://localhost:1527/pharmadb","User1","User1");
                PreparedStatement add=Con.prepareStatement("insert into BILLHISTORY values(?,?,?,?,?,?,?)");
                add.setString(1," ");
                add.setString(2, " ");
                add.setInt(3,i);
                add.setString(4,Medtext);
                add.setInt(5,Integer.valueOf(Qty));
                add.setInt(6,price);
                add.setInt(7, sumTotal);
                int row=add.executeUpdate();
                Con.close();
            }
        catch(SQLException e)
           {
                e.printStackTrace();
           }
        }
    }
}