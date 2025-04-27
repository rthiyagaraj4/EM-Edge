/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;


public class DiagTransmissionServlet extends HttpServlet {
	PrintWriter out;
	Properties p;

	String trans_by_id = "";
	String trans_date = "";
	String trans_desig = "";
	String call_function = "";

	String conf_by_id = ""; 
	String conf_date = "";	
	String conf_desig = "";	
	String srl_no = "";
	String patient_id = "";
	int trn_srl_no = 0;
	//String record_type = "";
	String cause_indicator = "";
	String trn_Str_Srl_No = "";
	String diag_code_scheme = "";
	//<!--removed comment for diag_code_scheme for SCR 4943-->
	String diag_code = "";
	String Encounter_Id = "";
	String facilityId;
	String client_ip_address;
	//Hashtable env;
	String location = "";
	String sStyle="";
	String locale="";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
					throws javax.servlet.ServletException,IOException 
	{
		 res.setContentType("text/html");
		HttpSession session = req.getSession(false);
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
		
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		call_function = req.getParameter("call_function");
		this.out = res.getWriter();
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		// code changed by Vedesh A D for Edge Conversion
		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
		out.println("async function callDiagTransmissionHTML() { ");
		if(call_function.equals("TRANSMIT_NOTIFY_REP"))
		{
			try {
			this.out = res.getWriter();
			insertDiagTransmission(req);		
			}
			catch (Exception e)	
			{
				//  out.println(e.toString());
				e.printStackTrace();
			}
		}else if (call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{
			try {
			this.out = res.getWriter();
			updateDiagTransmission(req);		
			}
			catch (Exception e)	
			{
				  //out.println(e.toString());
				  
				  e.printStackTrace();
			}

		}
		out.println("} callDiagTransmissionHTML ();</script></body></html>");	
		out.flush();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/TerminalDigit.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{ /*out.println(e.toString()); */ e.printStackTrace();	}
	}

	private void insertDiagTransmission(HttpServletRequest req)	
	{	
		Connection con =null;
		try {
			con = ConnectionManager.getConnection(req);
			HashMap tabdata=new HashMap();			
			Statement str_stmt	= null;
			ResultSet str_rs	= null;
			trans_by_id = req.getParameter("trm_name")==null?"":req.getParameter("trm_name");
			conf_by_id = req.getParameter("com_name")==null?"":req.getParameter("com_name");
			trans_desig = req.getParameter("trm_desig")==null?"":req.getParameter("trm_desig");
			conf_desig = req.getParameter("com_desig")==null?"":req.getParameter("com_desig");
			trans_date = req.getParameter("trm_datetime")==null?"":req.getParameter("trm_datetime");
			if(!trans_date.equals(""))
				trans_date = DateUtils.convertDate(trans_date,"DMYHM",locale,"en");
			conf_date = req.getParameter("conf_datetime")==null?"":req.getParameter("conf_datetime");
			if(!conf_date.equals(""))
				conf_date = DateUtils.convertDate(conf_date,"DMYHM",locale,"en");
			diag_code = req.getParameter("diag_code")==null?"":req.getParameter("diag_code");	
			diag_code_scheme = req.getParameter("diag_code_scheme")==null?"":req.getParameter("diag_code_scheme");
			//<!--removed comment for diag_code_scheme for SCR 4943-->
			Encounter_Id = req.getParameter("Encounter_Id")==null?"":req.getParameter("Encounter_Id");	
			location = req.getParameter("trm_location")==null?"":req.getParameter("trm_location");	
			/*if (diag_code_scheme.equals("2"))
			{
				record_type = "2";
				cause_indicator = "";
			}else{
				record_type = "";
				cause_indicator = "";
			}*/
			srl_no = req.getParameter("srl_no")==null?"":req.getParameter("srl_no");	
			patient_id = req.getParameter("patient_id")==null?"":req.getParameter("patient_id");	
			String term_set_id = req.getParameter("term_set_id")==null?"":req.getParameter("term_set_id");	
			String term_code = req.getParameter("term_code")==null?"":req.getParameter("term_code");	
			String occur_srl_no = req.getParameter("occur_srl_no")==null?"":req.getParameter("occur_srl_no");	

			try
			{
				String str_sql=" SELECT NVL(MAX(TRN_SRL_NO),0)+1 FROM MR_DIAG_TRANSMISSION ";
				str_stmt = con.createStatement() ;
				str_rs	= str_stmt.executeQuery(str_sql) ;
				if( str_rs !=null ) 
				{
					while(str_rs.next()) 
					{
						trn_srl_no	= str_rs.getInt(1);
					}
					str_rs.close();
					str_stmt.close();
				}
				Integer Int_SRL_NO	= new Integer(trn_srl_no);
				trn_Str_Srl_No	= Int_SRL_NO.toString();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			if(!trans_date.equals("")){
				StringTokenizer preparetoks = new StringTokenizer (trans_date," ") ;
				StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(),"/") ;
				String prepareArr[] =new String[3] ;
				for ( int p=0;p<3;p++ )	
					prepareArr[p] = preparetok1.nextToken() ;
				trans_date = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"  ;
				Timestamp marked_date_stamp= Timestamp.valueOf(trans_date);
				tabdata.put("TRANS_DATE",marked_date_stamp);
			}else{
				tabdata.put("TRANS_DATE","");
			}
			if(!conf_date.equals("")) 
			{
				StringTokenizer preparetoks2 = new StringTokenizer (conf_date," ") ;
				StringTokenizer preparetok2 = new StringTokenizer (preparetoks2.nextToken(),"/") ;
				String prepareArr1[] =new String[3] ;
				for( int q=0;q<3;q++ )
						prepareArr1[q] = preparetok2.nextToken() ;
				conf_date = prepareArr1[2] +"-"+prepareArr1[1]+"-"+prepareArr1[0]+" "+preparetoks2.nextToken()+":00"  ;
				Timestamp confirm_date_stamp= Timestamp.valueOf(conf_date);
				tabdata.put("CONF_DATE",confirm_date_stamp);
			}else{
				tabdata.put("CONF_DATE","");
			}
			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			tabdata.put("PATIENT_ID",patient_id);
			tabdata.put("TERM_SET_ID",term_set_id);
			tabdata.put("TERM_CODE",term_code);
			tabdata.put("OCCUR_SRL_NO",occur_srl_no);
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("ENCOUNTER_ID",Encounter_Id);
			tabdata.put("SRL_NO",trn_srl_no);
			tabdata.put("TRANS_BY_ID",trans_by_id);
			//tabdata.put("TRANS_DATE",patient_id);
			tabdata.put("TRANS_JOB_TITLE",trans_desig);
			tabdata.put("LOCATION",location);
			tabdata.put("CONF_BY_ID",conf_by_id);
			tabdata.put("CONF_JOB_TITLE",conf_desig);
			//tabdata.put("CONF_DATE",patient_id);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			String primaryKeys[]={"PATIENT_ID","TERM_SET_ID","TERM_CODE","OCCUR_SRL_NO","FACILITY_ID","ENCOUNTER_ID","SRL_NO"};
			/*tabdata.put("trans_by_id",trans_by_id);
			tabdata.put("conf_by_id",conf_by_id);
			tabdata.put("TRN_SRL_NO",trn_Str_Srl_No);
			tabdata.put("SRL_NO",srl_no);
			tabdata.put("SRL_NO",trn_srl_no);
			tabdata.put("DIAG_CODE",diag_code);
			//tabdata.put("RECORD_TYPE",record_type);
			tabdata.put("CAUSE_INDICATOR",cause_indicator);
			tabdata.put("DIAG_CODE_SCHEME",diag_code_scheme);
			//<!--removed comment for diag_code_scheme for SCR 4943-->
			tabdata.put("ONSET_FACILITY_ID",facilityId); 
			tabdata.put("ONSET_ENCOUNTER_ID",Encounter_Id);
			tabdata.put("LOCATION",location);
			tabdata.put("CONF_JOB_TITLE",conf_desig);
			tabdata.put("TRANS_JOB_TITLE",trans_desig);
			String primaryKeys[]={"TRN_SRL_NO"};
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );*/
			String tableName = "MR_DIAG_TRANSMISSION";
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = primaryKeys;
			argArray[3] = tableName;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = primaryKeys.getClass();
			paramArray[3] = tableName.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;	
			if ( inserted ) {
				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED" ,"SM") ;
				error = (String) message.get("message") ;
				if ( message != null ) message.clear();
			} else	{
				error = (String) results.get("error") ;				
			}
			//error= error.substring(0,error.indexOf("<br>")) ;
			out.println("alert(\""+error+"\");") ;			
			//out.println("parent.window.close();");
			out.println("parent.parent.document.getElementById('dialog_tag').close();");   
		   if (tabdata != null) tabdata.clear();
			if (results != null) results.clear();			
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
}

private void updateDiagTransmission(HttpServletRequest req)	
	{	
		Connection con =null;
		try 
		{
			con = ConnectionManager.getConnection(req);
			
			HashMap tabdata=new HashMap();			
			HashMap tabdata1 = new HashMap();
			Statement str_stmt	= null;
			ResultSet str_rs	= null;
				
			conf_by_id = req.getParameter("com_name")==null?"":req.getParameter("com_name");
			conf_desig = req.getParameter("com_desig")==null?"":req.getParameter("com_desig");
			conf_date = req.getParameter("conf_datetime")==null?"":req.getParameter("conf_datetime");	
			diag_code = req.getParameter("diag_code")==null?"":req.getParameter("diag_code");	
			Encounter_Id = req.getParameter("Encounter_Id")==null?"":req.getParameter("Encounter_Id");	
			srl_no = req.getParameter("srl_no")==null?"":req.getParameter("srl_no");	
			patient_id = req.getParameter("patient_id")==null?"":req.getParameter("patient_id");	

			String term_set_id = req.getParameter("term_set_id")==null?"":req.getParameter("term_set_id");	
			String term_code = req.getParameter("term_code")==null?"":req.getParameter("term_code");	
			String occur_srl_no = req.getParameter("occur_srl_no")==null?"":req.getParameter("occur_srl_no");	

			
		try
		{
			String str_sql=" SELECT SRL_NO FROM MR_DIAG_TRANSMISSION WHERE PATIENT_ID = '"+patient_id+"' and ENCOUNTER_ID = '"+Encounter_Id+"' and TERM_SET_ID = '"+term_set_id+"' and TERM_CODE = '"+term_code+"' and OCCUR_SRL_NO = '"+occur_srl_no+"'";


			str_stmt = con.createStatement() ;
			str_rs	= str_stmt.executeQuery(str_sql) ;
			if( str_rs !=null )
			{
				while(str_rs.next())
				{
					trn_srl_no	= str_rs.getInt(1);
				}
				str_rs.close();
				str_stmt.close();
			}
		Integer Int_SRL_NO		= new Integer(trn_srl_no);
		trn_Str_Srl_No	= Int_SRL_NO.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if(!conf_date.equals("")) {
		StringTokenizer preparetoks2 = new StringTokenizer (conf_date," ") ;
		StringTokenizer preparetok2 = new StringTokenizer (preparetoks2.nextToken(),"/") ;

		String prepareArr1[] =new String[3] ;
		for( int q=0;q<3;q++ )
				prepareArr1[q] = preparetok2.nextToken() ;

		conf_date = prepareArr1[2] +"-"+prepareArr1[1]+"-"+ prepareArr1[0]+" "+preparetoks2.nextToken()+":00" ;
		Timestamp confirm_date_stamp= Timestamp.valueOf(conf_date);
				
		tabdata.put("CONF_DATE",confirm_date_stamp);
		}else
		{
			tabdata.put("CONF_DATE","");
		}

			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
		
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
            
			tabdata.put("conf_by_id",conf_by_id);
			tabdata1.put("SRL_NO",trn_Str_Srl_No);			
			tabdata.put("CONF_JOB_TITLE",conf_desig);
	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		
			String tableName = "MR_DIAG_TRANSMISSION";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = tabdata1;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = tabdata1.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;			
			
			String error = (String) results.get("error") ;		

			if ( inserted )
			{
				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				error = (String) message.get("message") ;
				if (message != null) message.clear();			
			}
			else
			{
				error = (String) results.get("error") ;
				error = "Errors Encountered..";
			}
		//error= error.substring(0,error.indexOf("<br>")) ;
		out.println("<script>alert(\""+error+"\");</script>") ;			
		out.println("<script>parent.window.close();</script>");
		if (tabdata1 != null) tabdata1.clear();	
		if (tabdata != null) tabdata.clear();			
		if (results != null) results.clear();			

		}
		catch ( Exception e )
		{
			/*out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());	 */
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

}
