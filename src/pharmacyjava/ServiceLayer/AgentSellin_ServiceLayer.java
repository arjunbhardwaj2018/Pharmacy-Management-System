/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacyjava.ServiceLayer;
import pharmacyjava.AccessLayer.AgentSellin_AccessLayer;


/**
 *
 * @author Dikshant
 */
public class AgentSellin_ServiceLayer {
    public void update(int oldQty,int nqty,int Medid)
    {
        int newQty=oldQty-nqty;
        AgentSellin_AccessLayer sa=new AgentSellin_AccessLayer();
        sa.update(newQty, Medid);       
    }
    public void add(int i,String Medtext,String Qty, int price,int sumTotal,String billtext, String tempDate)
    {
         AgentSellin_AccessLayer sa=new AgentSellin_AccessLayer();
         sa.addbill(i, Medtext, Qty, price, sumTotal,billtext,tempDate);
    }
}
