/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eQA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*; 
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
public class QADataCollectionForClinIndServlet extends javax.servlet.http.HttpServlet 
{
   public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		//PrintWriter out;
		HttpSession session=req.getSession(true);
		res.setContentType("text/html");
		//out=res.getWriter();
        //System.out.println("outside: QADataCollectionForClinIndServlet");
		String client_ip_address="";
		String login_user="";
		String facility_id = "";
		String startIPDate="";
		String endIPDate="";
		String startEMDate="";
		String endEMDate="";
		String startOPDate="";
		String endOPDate="";
		String startDCDate="";
		String endDCDate="";
    	String query="";
		String status="";
		int job_result= 0;
	    String ipgenerate=req.getParameter("ipgenerate")==null?"":req.getParameter("ipgenerate");   	
        //String opgenerate=req.getParameter("opgenerate")==null?"":req.getParameter("opgenerate"); 
	    //String dcgenerate=req.getParameter("dcgenerate")==null?"":req.getParameter("dcgenerate") ;
		//String emgenerate=req.getParameter("emgenerate")==null?"":req.getParameter("emgenerate"); 
		java.util.Properties p  = null;
		facility_id = (String)session.getValue("facility_id") ;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		login_user = p.getProperty( "login_user" ) ;
		Connection con = ConnectionManager.getConnection(req);		
		CallableStatement csstmt = null;
		//out = res.getWriter();
		

		try 
		{
			if(ipgenerate.equals("Y"))
			{

			startIPDate=req.getParameter("PROC_DATE_IP_FROM");
			endIPDate=req.getParameter("PROC_DATE_IP_TO");
// Note: double single quoates are required.
			//String allpack="qabpatbt.main(''" + startIPDate + "'',''"+endIPDate+"'',''";
			String allpack="qabpatbt.main('" + startIPDate + "','"+endIPDate+"','";
			allpack=allpack + login_user + "','" + client_ip_address + "','"+ facility_id + "');"; 
			//allpack=allpack + login_user + "'',''" + client_ip_address + "'',''"+ facility_id + "'');"; 
		//	allpack=allpack 
			//System.out.println("allpack:"+ allpack);
			//query="{call DBMS_JOB.SUBMIT(?,?)}";
			//System.out.println("before preparecall:");
//			csstmt=con.prepareCall("{call DBMS_JOB.SUBMIT(?,?)}");
//			csstmt=con.prepareCall("{call  QA_JOB_SUBMIT_PROC(?,?,sysdate)}");
			csstmt=con.prepareCall("{call  QA_JOB_SUBMIT_PROC(?,?,?,?,?,?,?)}");
			csstmt.registerOutParameter(1,Types.INTEGER);
			csstmt.setString( 2, startIPDate);
			csstmt.setString( 3, endIPDate);
			csstmt.setString( 4, login_user);
			csstmt.setString( 5, client_ip_address);
			csstmt.setString( 6, facility_id);
			csstmt.registerOutParameter(7,Types.VARCHAR);
			//csstmt.setString( 3, "SYSDATE");
			//csstmt.setInt(3,1000);
			
			//System.out.println("before execute:");
			csstmt.execute();
			job_result=csstmt.getInt(1);
		//	System.out.println("before execute:");
			status=csstmt.getString(7);

		//	System.out.println("status:"+ status);
		/* 	query="{call QABPATHS.MAIN(?,?,?,?,?,?)}";
			callableStatement=con.prepareCall(query);
			callableStatement.setString(1,"IP");
			callableStatement.setString(2,startIPDate);
			callableStatement.setString(3,endIPDate);
			callableStatement.setString(4,login_user);
			callableStatement.setString(5,client_ip_address);
			callableStatement.setString(6,facility_id);
			
			callableStatement.executeUpdate(); 
			
		//	con.commit();
          
		 callableStatement.close();
		 
			}
			
			if(emgenerate.equals("Y"))
			{
		startEMDate=req.getParameter("PROC_DATE_EM_FROM");
		endEMDate=req.getParameter("PROC_DATE_EM_TO");

			String empack="qabpatip.main('" + startEMDate + "','"+endEMDate+"','";
			empack=empack + login_user + "','" + client_ip_address + "','"+ facility_id + "','";
			
			query="{call DBMS_JOB.SUBMIT(?,?)}";
			callableStatement=con.prepareCall(query);
			callableStatement.registerOutParameter(1,Types.NUMERIC);
			callableStatement.setString( 2, empack);
			callableStatement.execute();


		/* 
		query="{call QABPATHS.MAIN(?,?,?,?,?,?)}";
		callableStatement=con.prepareCall(query);

		callableStatement.setString(1,"EM");
		callableStatement.setString(2,startEMDate);
		callableStatement.setString(3,endEMDate);
		callableStatement.setString(4,login_user);
		callableStatement.setString(5,client_ip_address);
		callableStatement.setString(6,facility_id);
		callableStatement.executeUpdate(); 
		
		//con.commit();		
		
		callableStatement.close();
		
			}
			if(dcgenerate.equals("Y"))
			{
		startDCDate=req.getParameter("PROC_DATE_DC_FROM");
		endDCDate=req.getParameter("PROC_DATE_DC_TO");

			String dcpack="qabpatip.main('" + startDCDate + "','"+endDCDate+"','";
			dcpack=dcpack + login_user + "','" + client_ip_address + "','"+ facility_id + "','";
			
			query="{call DBMS_JOB.SUBMIT(?,?)}";
			callableStatement=con.prepareCall(query);
			callableStatement.registerOutParameter(1,Types.NUMERIC);
			callableStatement.setString( 2, dcpack);
			callableStatement.execute();
		
	/* 	query="{call QABPATHS.MAIN(?,?,?,?,?,?)}";
		callableStatement=con.prepareCall(query);
		callableStatement.setString(1,"DC");
		callableStatement.setString(2,startDCDate);
		callableStatement.setString(3,endDCDate);
		callableStatement.setString(4,login_user);
		callableStatement.setString(5,client_ip_address);
		callableStatement.setString(6,facility_id);
		callableStatement.executeUpdate(); 
		
		//con.commit();	
		
		callableStatement.close();
		
			}
		
		if(opgenerate.equals("Y"))
			{
		startOPDate=req.getParameter("PROC_DATE_OP_FROM");
		endOPDate=req.getParameter("PROC_DATE_OP_TO");

		String oppack="qabpatip.main('" + startOPDate + "','"+endOPDate+"','";
		oppack=oppack + login_user + "','" + client_ip_address + "','"+ facility_id + "','";
		query="{call DBMS_JOB.SUBMIT(?,?)}";
		callableStatement=con.prepareCall(query);
		callableStatement.registerOutParameter(1,Types.NUMERIC);
		callableStatement.setString( 2, oppack);
		callableStatement.execute();
		/* query="{call QABPATHS.MAIN(?,?,?,?,?,?)}";
		callableStatement=con.prepareCall(query);
		callableStatement.setString(1,"OP");
		callableStatement.setString(2,startOPDate);
		callableStatement.setString(3,endOPDate);
		callableStatement.setString(4,login_user);
		callableStatement.setString(5,client_ip_address);
		callableStatement.setString(6,facility_id);
		callableStatement.executeUpdate(); */
	
		}
		con.commit();			
	
		csstmt.close();
	
//		String error = "APP-SM0001 Operation Completed Successfully ....";
		String error = status;
		String error_value = "1" ;
		 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );                  
		}
		catch(Exception e)
		{	
	//	  e.printStackTrace();
		   try
		   {
			 csstmt.close();
			 con.rollback();
			 String error = "Error Found:"+e;
		     String error_value = "0" ;
		   	 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );                  
		 	 ConnectionManager.returnConnection(con, req);
	 	   }
		   catch(Exception e1)
		   {
			 String error = "Error ...."+e1;
		     String error_value = "0" ;
			 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );                  
			}	
		}finally
		{
		if (con != null) 
		  ConnectionManager.returnConnection(con,p);
		
		
		}
    }
}
