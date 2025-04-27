/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
/**
 *		FileName : UserForOpertorStationServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eAM.UserForOperator.* ;
import webbeans.eCommon.*;
import com.ehis.util.*;


public class UserForOperatorStationServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;
Statement  stmt=null;
Connection con=null;
ResultSet rs=null;
String userid;
String  station;
String facilityId;
String client_ip_address ;
String fac;
String effectiveDateFrom;
String effectiveDateTo;
///java.util.Hashtable env;
//String serviceURL;
//String objectName;
String fromchk;

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
	System.out.println("test");
  	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

		
	try
	{
		this.out = res.getWriter();
		String operation = req.getParameter("function1");
		System.out.println("operation"+operation);				
		if ( operation.equals("insert"))
			insertUFO(req, res);	
		if ( operation.equals("modify"))
			 modifyUFO(req, res);
		if(operation.equals("delete"))
			deleteUFO(req,res);
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
}
/*public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try
	{
		this.out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/NamePrefix.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}
	catch(Exception e)	
	{}
}*/

private void modifyUFO(HttpServletRequest req, HttpServletResponse res)	{
	String olddate="";
	try 
	{
		res.setContentType("text/html");
		userid=req.getParameter("userid");
		System.out.println("userid");
		station= req.getParameter("oprstn");
		System.out.println("station :"+station);
		fac=req.getParameter("facility");
		System.out.println("fac :"+fac);
		effectiveDateFrom = req.getParameter("eff_date_from1");
		System.out.println("effectiveDateFrom :"+effectiveDateFrom);
		effectiveDateTo = req.getParameter("eff_date_to1");
		System.out.println("effectiveDateTo :"+effectiveDateTo);
		olddate=req.getParameter("eff_date_fromold");
		System.out.println("olddate :"+olddate);
		fromchk=(String)req.getParameter("fromcheck");
		System.out.println("fromchk :"+fromchk);
		
		String locale = p.getProperty("LOCALE");

			effectiveDateFrom=DateUtils.convertDate(effectiveDateFrom,"DMY",locale,"en");
			System.out.println("effectiveDateFrom :"+effectiveDateFrom);
			effectiveDateTo=DateUtils.convertDate(effectiveDateTo,"DMY",locale,"en");
			System.out.println("effectiveDateTo :"+effectiveDateTo);
			
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("userid",userid);
			hashmap.put("station",station);
			hashmap.put("fac",fac);
			hashmap.put("effectiveDateFrom",effectiveDateFrom);
			hashmap.put("effectiveDateTo",effectiveDateTo);
			hashmap.put("facilityId",fac);
			hashmap.put("client_ip_address",client_ip_address);
			hashmap.put("olddate",olddate);
			hashmap.put("fromchk",fromchk);




				boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserForOperatorManager",UserForOperatorManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[1];
			argArray[0] =hashmap;	
		
			Class [] paramArray = new Class[1];
			
			paramArray[0] = hashmap.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyOperator",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;






		    System.out.println(inserted);
			if ( inserted )
			{
			     error_value = "1" ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) ); //+ "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}

			hashmap.clear();
			results.clear();
	}
		catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
							out.println("date:"+olddate);
			out.println(  userid+ " "+station+ " "+fac);
			e.printStackTrace();
			}
	}


private void insertUFO(HttpServletRequest req, HttpServletResponse res)	
{
	try
	{
	res.setContentType("text/html");
	userid=req.getParameter("userid");
	station= req.getParameter("oprstn");
	fac=req.getParameter("facility");
	effectiveDateFrom = req.getParameter("eff_date_from1");
	effectiveDateTo = req.getParameter("eff_date_to1");

	String locale = p.getProperty("LOCALE");



			effectiveDateFrom=DateUtils.convertDate(effectiveDateFrom,"DMY",locale,"en");
			effectiveDateTo=DateUtils.convertDate(effectiveDateTo,"DMY",locale,"en");



		String eff_date_to="",error ="";
		boolean flag=true;
		String error_value = "" ;
		//String flag2="N";

		int recordcount = 0;
		con=ConnectionManager.getConnection(p);	
		stmt = con.createStatement();

		String sql="select to_char(EFF_DATE_TO,'dd/mm/yyyy')EFF_DATE_TO  FROM  AM_USER_FOR_OPER_STN  WHERE FACILITY_ID='"+fac+"'  AND APPL_USER_ID='"+userid+"'  AND (EFF_DATE_TO IS NULL OR EFF_DATE_TO >= SYSDATE)";

		rs = stmt.executeQuery(sql);
		
		if(rs!=null && rs.next())
		{
		recordcount = 1;
		 eff_date_to=rs.getString("EFF_DATE_TO");
		 if(eff_date_to ==null) eff_date_to="";
		 
		}else
		{
		recordcount = 0;
		}
		if(rs ==null) rs.close();
		if(stmt!=null)stmt.close();

	/*	String date_chk=" select (CASE WHEN To_Date('"+eff_date_to+"','dd/mm/yyyy')>= sysdate  THEN 'Y' ELSE 'N' END) xx  from dual";
		rs = stmt.executeQuery(date_chk);
		

		if(rs!=null && rs.next())
		{
		
		 flag2=rs.getString("xx");
		 
		}

		

		//if((eff_date_to.equals("") || flag2.equals("Y") ))	
		if((recordcount != 0 && eff_date_to.equals("") && flag2.equals("N") ) || (!eff_date_to.equals("") && flag2.equals("Y")))
		{
			flag=false;
				//error ="APP-AM0008 Effective dates overlaps with existing set up" ;
				java.util.Hashtable message = MessageManager.getMessage(locale, "OVERLAP_USER_OPER_STN", "AM");
				String error1 = ((String) message.get("message"));

				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error1,"UTF-8"  ) );
		}else
		{
			flag=true;
		}*/



		if(recordcount == 0 || flag==true)
		{
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserForOperatorManager",UserForOperatorManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("userid",userid);
			hashmap.put("station",station);
			hashmap.put("fac",fac);
			hashmap.put("effectiveDateFrom",effectiveDateFrom);
			hashmap.put("effectiveDateTo",effectiveDateTo);
			hashmap.put("facilityId",facilityId);
			hashmap.put("client_ip_address",client_ip_address);
			
			argArray[0] =hashmap;		

			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertUserForOperator",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			    boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			     error = (String) results.get("error") ;
			     error_value = "0" ;
		        System.out.println(inserted);
			    if ( inserted )
			    {
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )); //+ "&err_value=" + error_value );
			    }
			    else
			    {
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			    }
				hashmap.clear();
			    results.clear();
		}
		 

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( station+ " "+fac + " "+userid );
			e.printStackTrace();
		}
		finally 
		{ 
			ConnectionManager.returnConnection(con,p);
		}
	}


	private void deleteUFO(HttpServletRequest req, HttpServletResponse res)	{
		try {
		res.setContentType("text/html");
			userid=req.getParameter("userid");
			effectiveDateFrom = req.getParameter("eff_date_from1");
			fac=req.getParameter("facility");
			String locale = p.getProperty("LOCALE");

			effectiveDateFrom=DateUtils.convertDate(effectiveDateFrom,"DMY",locale,"en");

			

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/UserForOperatorManager");
			final UserForOperatorManagerHome userForOperatorManagerHome = (UserForOperatorManagerHome) PortableRemoteObject.narrow(homeObject ,UserForOperatorManagerHome.class);
			final UserForOperatorManagerRemote userForOperatorManagerRemote = userForOperatorManagerHome.create();
			final java.util.Hashtable results = userForOperatorManagerRemote.deleteUserForOperator(p,userid,facilityId,effectiveDateFrom) ;*/
			
			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserForOperatorManager",UserForOperatorManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("userid",userid);	
			hashmap.put("fac",fac);
			hashmap.put("effectiveDateFrom",effectiveDateFrom);
			argArray[0] =hashmap;	
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();
			
						
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteUserForOperator",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			
			if ( inserted )
			{
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) );//+ "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
				hashmap.clear();
				results.clear();

			} catch ( Exception e ) 
			{
				out.println(e.getMessage());
				out.println(e.toString());
				e.printStackTrace();
			}
	}
	}
