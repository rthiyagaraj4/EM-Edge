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
 * Class used to update Data Element cross reference Table values
 */
public class DataElementCrossRefTableValuesServlet extends HttpServlet
{
	
	/**
	 * Do post method which implements the functionalities  of Data Element cross reference Table values
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
	{
		HttpSession session = req.getSession(false);
		PrintWriter out=res.getWriter();
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
		
		CallableStatement oraclecallablestatement = null;
		Connection con = null;
		
		String status="";
		String sStyle = "";
       
		try
        {
           out.println("<head>");
           sStyle =
           (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
           out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
           out.println("</head>");
           out.println("<body class='MESSAGE'>");      
        }
        catch(Exception exq)
        {
			 System.out.println("Error in dopost method of dataelementcrossreftablevaluesservlet :"+exq.toString());
		    exq.printStackTrace(System.err); 
		 
        }
		
		try
		{
			con = ConnectionManager.getConnection();
			XHMasterCodeControllerBean	xhBean=XHMasterCodeControllerBean.getBean(XHMasterCodeControllerBean.strBeanName,req,session);
			xhBean.action(req,con);
			
			String strData[][]= xhBean.getDatabaseData();
			ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
			xhBean.action(req,con);
			MessageManager mm=new MessageManager();

			
			for(int i=0;i<strData.length;i++)
	        {
			
			oraclecallablestatement = con.prepareCall("{call XHMAST.data_element_cross_ref_code(?,?,?,?,?,?,?,?,?,?,?,?)}");

			 String  usr_added_by_id=(String)arrAudit.get(0);
			 String  usr_added_at_ws_no=(String)arrAudit.get(1);
			 String  usr_added_by_facility_id=(String)arrAudit.get(2);

			 oraclecallablestatement.setString(1,strData[i][0]);
			 oraclecallablestatement.setString(2,strData[i][1]);
			 oraclecallablestatement.setString(3,strData[i][2]);
		     oraclecallablestatement.setString(4,strData[i][3]);
		     oraclecallablestatement.setString(5,strData[i][4]);
		     oraclecallablestatement.setString(6,strData[i][5]);
		     oraclecallablestatement.setString(7,strData[i][6]);
             
			 oraclecallablestatement.setString(8,usr_added_by_id);
			 oraclecallablestatement.setString(9,usr_added_at_ws_no);
			 oraclecallablestatement.setString(10,usr_added_by_facility_id);
            
			 oraclecallablestatement.registerOutParameter(11,java.sql.Types.VARCHAR);
		     oraclecallablestatement.registerOutParameter(12,java.sql.Types.VARCHAR);
			 

		
            oraclecallablestatement.execute();
           	status = oraclecallablestatement.getString(11);
			//err_text =oraclecallablestatement.getString(12); 
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
			
			ConnectionManager.returnConnection(con);
		    
			}catch(Exception ex){
               System.out.println("Error in calling db related statements in dopost method of dataelementcrossreftablevaluesservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
		 	}
	}// end of do post
}//end of class
