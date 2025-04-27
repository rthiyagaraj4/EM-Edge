/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
/**
 * Class used to update Data Element cross reference Application Usage Element values
 */
public class DataElementCrossRefSearchServlet extends HttpServlet
{
	/**
	 * Do post method which implements the functionalities  of Data Element cross reference Application Usage Element values
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

public void doPost (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
{
	

	HttpSession session = req.getSession(false);
	Properties p;
	
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    String appliction_value="";
    String appliction_Mode="";
String Dervation_type="";
String Conditional_Expression="";
String Expected_value="";
String Expected_value2="";
String Excution_order="";
String Position_value="";
String Element_id="";
	req.setCharacterEncoding("UTF-8");
   	res.setContentType("text/html;charset=UTF-8");
	PrintWriter out=res.getWriter();
	CallableStatement oraclecallablestatement = null;
	Connection con = null;
	MessageManager mm=new MessageManager();
	String status="";
    String sStyle = "";
	int count;
    try 
    {
     out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>");      
   
	}
    catch(Exception exception)
    {
         System.out.println("Error in dopost method od dataelementcrossrefapplicationusageservlet:"+exception.toString());
		exception.printStackTrace(System.err); 
		
    }
	
	try
    {
		count=Integer.parseInt(req.getParameter("count"));

	//	System.out.println("count"+count);
        appliction_Mode=req.getParameter("action_type");
        con = ConnectionManager.getConnection();
     //   XHApplicationDerivationSetupControllerBean xhBean=XHApplicationDerivationSetupControllerBean.getBean(XHApplicationDerivationSetupControllerBean.strBeanName,req,session);
      //  xhBean.action(req,con);
		//String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		//xhBean.action(req,con);
        String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
		for(int i=0;i<count;i++)
		 {
			appliction_value=req.getParameter(i+"Application_ID");
Element_id=req.getParameter(i+"Element_ID");


Dervation_type=req.getParameter(i+"Dervation_ID");
Conditional_Expression=req.getParameter(i+"_C/E");
Expected_value=req.getParameter(i+"_EV");
Expected_value2=req.getParameter(i+"_EV2");
Excution_order=req.getParameter(i+"_EO1");
Position_value=req.getParameter(i+"_PO");
       /* 	    System.out.println("Mode"+appliction_Mode);
	  
	    System.out.println("element_id"+Element_id);
		System.out.println("app_id"+appliction_value);
	    System.out.println("d_type"+Dervation_type);
        System.out.println("con_exphdbshbs"+Conditional_Expression);
	  	System.out.println("expe_value"+Expected_value);
		System.out.println("expe_ord"+Excution_order);
	    System.out.println("exp_value2"+Expected_value2);
		System.out.println("pos"+Position_value);
		System.out.println("usr_added_by_id"+usr_added_by_id);
	    System.out.println("usr_added_at_ws_no"+usr_added_at_ws_no); */
	    oraclecallablestatement =con.prepareCall("{ CALL Xg_prc.xh_appl_derivation_rules(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
        oraclecallablestatement.setString(1,appliction_Mode);
               oraclecallablestatement.setString(2,Element_id);
        oraclecallablestatement.setString(3,Dervation_type);
	    oraclecallablestatement.setString(4,Conditional_Expression);
        oraclecallablestatement.setString(5,Expected_value);
	    oraclecallablestatement.setString(6,Excution_order);
    	oraclecallablestatement.setString(7,Expected_value2);
        oraclecallablestatement.setString(8,Position_value);
		oraclecallablestatement.setString(9,usr_added_by_id);
		oraclecallablestatement.setString(10,usr_added_at_ws_no);
	    oraclecallablestatement.registerOutParameter(11,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(12,java.sql.Types.VARCHAR);
		oraclecallablestatement.setString(13,appliction_value);		
		/*oraclecallablestatement.setString(2,strData[i][1]);
		oraclecallablestatement.setString(4,strData[i][3]);
	    oraclecallablestatement.setString(5,strData[i][4]);
		oraclecallablestatement.setString(9,appliction_value);*/
		//oraclecallablestatement.registerOutParameter(12,java.sql.Types.VARCHAR);
		//oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
        oraclecallablestatement.execute();
    	status = oraclecallablestatement.getString(11);
		if(oraclecallablestatement!=null) oraclecallablestatement.close();
        if("0".equals(status))
		{
                con.commit();
			    final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
        }
		else
		{
			  con.rollback();
              final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 			  status = ((String) mesg.get("message"));
 			 mesg.clear();
		}

	  }
     out.println("");
     out.println(status);
       out.println("");
       out.println("</body>"); 
       
       arrAudit.clear();
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of dataelementcrossrefapplicationusageservlet :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		      
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of dataelementcrossrefapplicationusageservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 

		}
	}// end of do post
}//end of class
