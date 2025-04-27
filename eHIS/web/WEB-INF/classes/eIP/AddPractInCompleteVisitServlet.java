/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AddPractInCompleteVisitServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	StringBuffer sb=new StringBuffer();
	String locale;
	String facilityId ;
	String client_ip_address ;
	String encounterid;
	String practitionerid;
	String practitionerrole;
	String role_Start_Time;
	String role_End_Time;
	String error_value ;
	String error;
	String srl_no;
	String table_name	;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

public void init(ServletConfig config) throws ServletException
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = checkForNull((String) session.getValue( "facility_id" )) ;
	client_ip_address = p.getProperty("client_ip_address");
	locale = p.getProperty("LOCALE");
	try
	{
		this.out = res.getWriter();

		String operation = checkForNull(req.getParameter("functionmod"));

		sb.append(operation);
		if ( operation.equals("insert"))	insertCompleteVisit(req,res);
		if ( operation.equals("modify"))    modifyCompleteVisit(req);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	try
	{  
		doPost(req,res);		
	}
	catch(Exception e)	{	}
}

private void insertCompleteVisit(HttpServletRequest req,HttpServletResponse res)
{
	
	Connection con		= null;

	ResultSet roleRS	= null;
	Statement roleStmt	= null;
	ResultSet srlRS		= null;
	Statement srlStmt	= null;
    

	try
	{
		con					=	ConnectionManager.getConnection(req);
		encounterid			=	checkForNull(req.getParameter("encounter_id"));
		practitionerid		=	checkForNull(req.getParameter("practitioner_id"));
		practitionerrole	=	checkForNull(req.getParameter("consulting"));

		
		role_Start_Time		=	checkForNull(req.getParameter("RoleStartTime"));
		role_Start_Time		= DateUtils.convertDate(role_Start_Time,"DMYHM",locale,"en"); 	
		
		/// CONDN to CHECK Role of Practioner with his ID...
		StringBuffer roleSql = new StringBuffer();
		roleSql.append("SELECT count(*) FROM pr_encounter_pract WHERE operating_facility_id='"+facilityId+"' AND encounter_id = '"+encounterid+"' AND practitioner_id = '"+practitionerid+"' AND practitioner_role in('2','3','4') AND role_end_time is null ");

		int count = 0;
		roleStmt = con.createStatement() ;
		roleRS	= roleStmt.executeQuery(roleSql.toString()) ;

		if( roleRS !=null )
		{
			while(roleRS.next())
			{
				count	= roleRS.getInt(1);
			}
		}
			if(roleStmt != null) roleStmt.close();
			if(roleRS != null) roleRS.close();

		if(count > 0)
			error_value = "0" ;
		else
			error_value = "1" ;

	if(error_value.equals("0"))
	{   MessageManager mm = new MessageManager();
		final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_ALREADY_EXISTS","SM") ;
		String         msg1=(String)mesg.get("message");
		
		out.println("<script>alert('"+msg1+"');</script>");
		error_value = "0" ;
		mesg.clear();
	}
	else
	{
		int SRL_NO = 0;
		StringBuffer srlSql = new StringBuffer();
		srlSql.append(" SELECT NVL(MAX(SRL_NO),0)+1 FROM PR_ENCOUNTER_PRACT WHERE OPERATING_FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID='"+encounterid+"' AND PRACTITIONER_ID='"+practitionerid+"' AND PRACTITIONER_ROLE='"+practitionerrole+"' ");

		srlStmt = con.createStatement() ;
		srlRS	= srlStmt.executeQuery(srlSql.toString()) ;

		if( srlRS !=null )
		{
			while(srlRS.next())
			{
				SRL_NO	= srlRS.getInt(1);
			}
		}
			if(srlStmt != null) srlStmt.close();
			if(srlRS != null)	srlRS.close();

		Integer I_SRL_NO				= new Integer(SRL_NO);
		String Str_Srl_No				= I_SRL_NO.toString();

		String modifiedById				= p.getProperty( "login_user" ) ;
		String addedDate				= dateFormat.format( new java.util.Date() ) ;
		String addedFacilityId			= facilityId;
		String addedAtWorkstation		= client_ip_address;
		String IPval 					= checkForNull(req.getParameter("IPval"));
		java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;

		HashMap tabdata = new HashMap();
		tabdata.put("operating_facility_id",facilityId );
		tabdata.put("encounter_id",encounterid );
		tabdata.put("practitioner_id",practitionerid  );
		tabdata.put("practitioner_role",practitionerrole  );
		tabdata.put("specialty_code",checkForNull(req.getParameter("speciality_code")));
		tabdata.put("team_id",checkForNull(req.getParameter("team_id")));
		tabdata.put("Remarks",checkForNull(req.getParameter("Remarks")));
		tabdata.put("SRL_NO",Str_Srl_No);
		tabdata.put("NURSING_UNIT_CODE",checkForNull(req.getParameter("hddNursingUnitCode")));

		if (role_Start_Time != null && !role_Start_Time.equals(""))
		{
			String strStartTime = role_Start_Time.substring(role_Start_Time.indexOf(" "),role_Start_Time.length());

			role_Start_Time = role_Start_Time.substring(0,role_Start_Time.indexOf(" "));
			
			StringTokenizer startToken = new StringTokenizer(role_Start_Time,"/");
			String StartArr[] =new String[3] ;
			for( int i=0;i<3;i++ )
			{        
				if(startToken.hasMoreTokens()) 
				{
					StartArr[i] = startToken.nextToken();
				}
			}
			role_Start_Time			= StartArr[2] + "-" + StartArr[1] + "-" + StartArr[0];
			role_Start_Time			= role_Start_Time+strStartTime+":00";
			Timestamp start_time	= Timestamp.valueOf(role_Start_Time);
			tabdata.put("ROLE_START_TIME",start_time);
			
		}

		tabdata.put("added_by_id",modifiedById);
		tabdata.put("added_date",added_date);
		tabdata.put("added_facility_id", facilityId);
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",added_date);
		tabdata.put("modified_facility_id",addedFacilityId);
		tabdata.put("modified_at_ws_no",addedAtWorkstation );
		/*Monday, May 10, 2010 , SRL_NO added in dupflds for SRR20056-SCF-4462 , 21235 */
		String dupflds[]={"operating_facility_id","encounter_id","practitioner_id","practitioner_role","SRL_NO"};

	
		table_name			= "pr_encounter_pract";
		boolean local_ejbs	= false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();
		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		
		error = (String) results.get("error") ;
	
	
		if(IPval.equals("ip"))
		{
//			error = error.substring(0,error.lastIndexOf("<br>")) ;
			out.println( "<script>alert(\" "+ error +" \");</script>" ) ;
			if(inserted)
			{
				out.println("<script>parent.frames[1].frames[2].onSuccess();</script>");
			}
		}
	tabdata.clear();
	results.clear();
	}

	if(srlRS != null)	srlRS	= null;
	if(srlStmt != null)	srlStmt = null;
	if(roleRS != null)	roleRS	= null;
	if(roleStmt != null)roleStmt= null;
	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null)  ConnectionManager.returnConnection(con,req);
	}
}

private void modifyCompleteVisit(HttpServletRequest req)
{
	
	try
	{	
		encounterid		=	checkForNull(req.getParameter("encounter_id"));
		practitionerid	=	checkForNull(req.getParameter("practitioner_id"));
		practitionerrole=	checkForNull(req.getParameter("consulting"));
        String IPval 	=	checkForNull(req.getParameter("IPval"));
		
		role_Start_Time	=	checkForNull(req.getParameter("RoleStartTime"));
		role_Start_Time	= DateUtils.convertDate(role_Start_Time,"DMYHM",locale,"en"); 	
		
		role_End_Time	=	checkForNull(req.getParameter("RoleEndTime"));
		role_End_Time	= DateUtils.convertDate(role_End_Time,"DMYHM",locale,"en"); 	
		
		srl_no			=	checkForNull(req.getParameter("SRL_NO"));

		String modifiedById				= p.getProperty( "login_user" ) ;
		String addedDate				= dateFormat.format( new java.util.Date() ) ;
		String addedFacilityId			= facilityId;
		String addedAtWorkstation		= client_ip_address;
		java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;
		
		HashMap tabdata=new HashMap();
		
		
		
		if (role_End_Time != null && !role_End_Time.equals(""))
		{
			String strEndTime = role_End_Time.substring(role_End_Time.indexOf(" "),role_End_Time.length());
			role_End_Time = role_End_Time.substring(0,role_End_Time.indexOf(" "));
			
			StringTokenizer Alt2token = new StringTokenizer(role_End_Time,"/");
			String Alt2Arr[] =new String[3] ;
			for( int b=0;b<3;b++ )
			{        
				if(Alt2token.hasMoreTokens()) 
				{
					Alt2Arr[b] = Alt2token.nextToken();
				}
			}
			role_End_Time = Alt2Arr[2] + "-" + Alt2Arr[1] + "-" + Alt2Arr[0];
			role_End_Time = role_End_Time+strEndTime+":00";
			Timestamp end_time = Timestamp.valueOf(role_End_Time);
			tabdata.put("ROLE_END_TIME",end_time);
		}
		
	
		tabdata.put("Remarks",checkForNull(req.getParameter("Remarks")));
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",added_date);
		tabdata.put("modified_facility_id",addedFacilityId);
		tabdata.put("modified_at_ws_no",addedAtWorkstation );
		tabdata.put("team_id",checkForNull(req.getParameter("team_id")) );
		tabdata.put("SPECIALTY_CODE",checkForNull(req.getParameter("speciality_code")));

		HashMap condflds=new HashMap();

		condflds.put("practitioner_id",practitionerid);
		condflds.put("practitioner_role",practitionerrole);
		condflds.put("operating_facility_id",facilityId );
		condflds.put("encounter_id",encounterid );
		condflds.put("srl_no",srl_no );
			
		
		table_name			= "pr_encounter_pract";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		error = (String) results.get("error") ;

		

		if(IPval.equals("ip"))
		{
				
				if(error.indexOf("<br>")!=-1)
					error = error.substring(0,error.lastIndexOf("<br>")) ;
				out.println( "<script>alert(\" "+ error +" \");</script>" ) ;
				
			if (inserted)
			{
				out.println("<script>parent.frames[1].frames[2].onSuccess();</script>");
			}
		}

	tabdata.clear();
	condflds.clear();
	results.clear();
	
	}catch ( Exception e )
	{
		e.printStackTrace();
	}
}
	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
		public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}

}/// E.O class
	
