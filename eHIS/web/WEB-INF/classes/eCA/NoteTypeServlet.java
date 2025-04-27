/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100         ?           	created
06/02/2013		IN037675	Dinesh T		IN037675
04/03/2013	IN037676		Dinesh T		Signing the addendum is controlled by the note type parameter
-----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
26/08/2016	  IN059489		 Raja S											Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class NoteTypeServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8 ");
			out = res.getWriter();
			String mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");

			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			if (mode.trim().equalsIgnoreCase("update"))   modify(req, res, out);
			if (mode.trim().equalsIgnoreCase("delete"))   delete(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}/**********************************************************************************************/

	private void extractData(HttpServletRequest req)
	{
			String note_groupid_update="";
			String note_group_id="";
			String note_type="";
			String note_type_desc="";
			String event_class="";
			String disclaimer_desc="";
			String inpatient_yn="";
			String outpatient_yn="";
			String serv_facl_spec_yn="";
			String doc_link_note="";
			String dc_yn = "";
			String em_yn = "";
			String patient="";
			String publish_level="";
			String banner_ind="";
			String ammendment_type="";

			String event_type_caption="";
			String event_date_caption="";
			String event_status_caption="";
			String event_title_caption="";
			String event_perf_by_caption="";
			String event_auth_by_caption="";

			String eff_status	="";
			String conf_yn="";
			String beforeUpdateEff_status= "";
//			String print_header_logo="";
			String report_header_desc="";
			String note_header_desc="";
			String footer_header_desc="";
			String print_logo_header = "";
			String print_txtlogo_header = "";	//[IN032210]
			String print = "";
			

			String mode					 = (req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			 HttpSession session	= null;
			 session = req.getSession(false);
				
			beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req); 
			
			eff_status				= checkNull("eff_status", req); 
			eff_status  			=(eff_status.equals(""))?"D":eff_status ;
							
			if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
			{
				note_type			= checkNull("note_type_update",req);
				event_class			= checkNull("event_class_update", req);           
				note_groupid_update = checkNull("note_groupid_update",req);

			}
			else
			{
				note_type			= checkNull("note_type",req);
				event_class			= checkNull("event_class", req);                                     
			}
				
				note_group_id			= checkNull("note_group_id",req);   
				note_type_desc			= checkNull("note_type_desc",req);        
				disclaimer_desc			= checkNull("disclaimer_desc",req);
				
				inpatient_yn			= checkNull("inpatient_yn", req);          
				outpatient_yn			= checkNull("outpatient_yn", req);         
				serv_facl_spec_yn		= checkNull("serv_facl_spec_yn", req);  
				doc_link_note			= checkNull("doc_link_note", req); 

				
				report_header_desc		= checkNull("report_header_desc", req);
				note_header_desc		= checkNull("note_header_desc", req);
				footer_header_desc		= checkNull("footer_header_desc", req);
				print_logo_header		= checkNull("print_logo_header", req);
				print_txtlogo_header	= checkNull("print_txtlogo_header", req);  //[IN032210]
				print		            = checkNull("print", req);

				inpatient_yn			=(inpatient_yn.equals(""))?"N":inpatient_yn ;
				outpatient_yn			=(outpatient_yn.equals(""))?"N":outpatient_yn ;
				serv_facl_spec_yn		=(serv_facl_spec_yn.equals(""))?"N":serv_facl_spec_yn ;
				doc_link_note			=(doc_link_note.equals(""))?"N":doc_link_note ;
				print_logo_header		=(print_logo_header.equals(""))?"N":print_logo_header ;
				                          
				publish_level			= checkNull("publish_level", req);         
				banner_ind				= checkNull("banner_ind", req);            
				ammendment_type			= checkNull("ammendment_type", req);       
				conf_yn					= checkNull("conf_yn", req); 
				
				event_type_caption		= checkNull("event_type_caption", req);    
				event_date_caption		= checkNull("event_date_caption", req);    
				event_status_caption	= checkNull("event_status_caption", req);  
				event_title_caption		= checkNull("event_title_caption", req);   
				event_perf_by_caption	= checkNull("event_perf_by_caption", req); 
				event_auth_by_caption	= checkNull("event_auth_by_caption", req); 
				
				dc_yn					= checkNull("DC", req); 
				em_yn					= checkNull("EM", req); 
				patient					= checkNull("patient", req); 
				dc_yn					= (dc_yn.equals(""))?"N":dc_yn ;
				em_yn					= (em_yn.equals(""))?"N":em_yn ;
				patient					= (patient.equals(""))?"N":patient ;			
		}

	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}

 /**********************************************Pouplates the hashtable with the values*******************/

	public HashMap populateHashMap(HttpServletRequest req)
	{
			
			java.util.Properties p;

			String note_groupid_update="";
			String note_group_id="";
			String note_type="";
			String note_type_desc="";
			String event_class="";
			String disclaimer_desc="";
			String inpatient_yn="";
			String outpatient_yn="";
			String serv_facl_spec_yn="";
			String doc_link_note="";
			String dc_yn = "";
			String em_yn = "";
			String patient="";
			String publish_level="";
			String banner_ind="";
			String ammendment_type="";

			String event_type_caption="";
			String event_date_caption="";
			String event_status_caption="";
			String event_title_caption="";
			String event_perf_by_caption="";
			String event_auth_by_caption="";

			String eff_status	="";
			String conf_yn="";
//			String print_header_logo="";
			String report_header_desc="";
			String note_header_desc="";
			String footer_header_desc="";
			String print_logo_header = "";
			String print_txtlogo_header = ""; //[IN032210]
			String header_margin_note = "";//[IN031116]
			String footer_margin_not = "";//[IN031116]
			String waterMark_YN =""; //IN059489
			String print = "";
			

			HashMap tabdata			= null;
			String mode				= (req.getParameter("mode")==null)?"":req.getParameter("mode");
			String beforeUpdateEff_status= "";
			

			String facilityId ;
			String client_ip_address ;
			String addedById			= "";
			String modifiedById			= "";
			String addedAtWorkstation	= "";
			String modifiedAtWorkstation= "";

			String practitioner_level = "";//IN037675
			String speciality_level = "";//IN037675
			String l_sign_addendum_oth = "";//IN037675
			 HttpSession session	= null;
			 session = req.getSession(false);
			 p = (java.util.Properties) session.getValue( "jdbc" ) ;
			 //String locale = (String) p.getProperty("LOCALE");
			 facilityId = (String) session.getValue( "facility_id" ) ;
			 client_ip_address = p.getProperty("client_ip_address");
			 modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
			 addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			 addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
			 tabdata=new HashMap();
			
			 beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req); 
				
				eff_status				= checkNull("eff_status", req); 
				eff_status  			=(eff_status.equals(""))?"D":eff_status ;
								
				if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
				{
					note_type			= checkNull("note_type_update",req);
					event_class			= checkNull("event_class_update", req);           
					note_groupid_update = checkNull("note_groupid_update",req);
				}
				else
				{
					note_type			= checkNull("note_type",req);
					event_class			= checkNull("event_class", req);                                     
				}
				
				note_group_id			= checkNull("note_group_id",req);   
				note_type_desc			= checkNull("note_type_desc",req);        
				disclaimer_desc			= checkNull("disclaimer_desc",req);
				
				inpatient_yn			= checkNull("inpatient_yn", req);          
				outpatient_yn			= checkNull("outpatient_yn", req);         
				serv_facl_spec_yn		= checkNull("serv_facl_spec_yn", req);  
				doc_link_note			= checkNull("doc_link_note", req); 

				inpatient_yn			=(inpatient_yn.equals(""))?"N":inpatient_yn ;
				outpatient_yn			=(outpatient_yn.equals(""))?"N":outpatient_yn ;
				serv_facl_spec_yn		=(serv_facl_spec_yn.equals(""))?"N":serv_facl_spec_yn ;
				doc_link_note			=(doc_link_note.equals(""))?"N":doc_link_note ;
				                          
				publish_level			= checkNull("publish_level", req);         
				banner_ind				= checkNull("banner_ind", req);            
				ammendment_type			= checkNull("ammendment_type", req);       
				conf_yn					= checkNull("conf_yn", req); 
				
				event_type_caption		= checkNull("event_type_caption", req);    
				event_date_caption		= checkNull("event_date_caption", req);    
				event_status_caption	= checkNull("event_status_caption", req);  
				event_title_caption		= checkNull("event_title_caption", req);   
				event_perf_by_caption	= checkNull("event_perf_by_caption", req); 
				event_auth_by_caption	= checkNull("event_auth_by_caption", req); 
//				print_header_logo		= checkNull("print_header_logo",req);
				report_header_desc		= checkNull("report_header_desc",req);
				note_header_desc		= checkNull("note_header_desc",req);
				footer_header_desc		= checkNull("footer_header_desc",req);
				print_logo_header		= checkNull("print_logo_header",req);
				print_txtlogo_header	= checkNull("print_txtlogo_header",req); //[IN032210]
				print		            = checkNull("print",req);
				print_logo_header		= (print_logo_header.equals(""))?"N":print_logo_header ;
				print_txtlogo_header	= (print_txtlogo_header.equals(""))?"N":print_txtlogo_header ; //[IN032210]
				header_margin_note		= checkNull("header_margin_note",req);//[IN031116]
				footer_margin_not		= checkNull("footer_margin_note",req);//[IN031116]
				practitioner_level = checkNull("pracLevelChk",req);//IN037675
				speciality_level = checkNull("specLevelChk",req);//IN037675
				l_sign_addendum_oth = checkNull("sign_addendum_yn",req);//IN037675
				l_sign_addendum_oth = l_sign_addendum_oth.equals("")?"N":l_sign_addendum_oth;//IN037675
				waterMark_YN			= checkNull("water_mark",req); //IN059489
				waterMark_YN			= waterMark_YN.equals("")?"N":waterMark_YN;//IN059489

				dc_yn					= checkNull("DC", req); 
				em_yn					= checkNull("EM", req); 
				patient					= checkNull("patient", req); 
				dc_yn					= (dc_yn.equals(""))?"N":dc_yn ;
				em_yn					= (em_yn.equals(""))?"N":em_yn ;
				patient					= (patient.equals(""))?"N":patient ;			

				if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
				{	
					tabdata.put("NOTE_TYPE", note_type);
					tabdata.put("EFF_STATUS",eff_status);
					tabdata.put("MODIFIED_BY_ID",modifiedById);
					tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("MODIFIED_FACILITY_ID",facilityId);
					tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
					//tabdata.put("LOCALE",locale ); //Commented by shaiju Locale should not pass to SingleTabHandler ejb
					return tabdata;
				}
 
			
			tabdata.put("NOTE_TYPE", note_type);
			tabdata.put("NOTE_TYPE_DESC",note_type_desc);
			tabdata.put("EVENT_CLASS",event_class);
			tabdata.put("DISCLIMER_CODE",disclaimer_desc);
			
			
			tabdata.put("INPATIENT_YN",	inpatient_yn);
			tabdata.put("OUTPATIENT_YN",outpatient_yn);
			tabdata.put("DAYCARE_YN",	dc_yn);
			tabdata.put("EMERGENCY_YN",em_yn);
			tabdata.put("SERV_FACL_SPEC_YN",serv_facl_spec_yn);	
			tabdata.put("DOC_LINKED_NOTE_YN",doc_link_note);	
			tabdata.put("PATIENT_SPECIFIC_YN",patient);	
											                        
			tabdata.put("PUBLISH_LEVEL",publish_level);
			tabdata.put("BANNER_IND" ,banner_ind);
			tabdata.put("AMMENDMENT_TYPE",ammendment_type);
			tabdata.put("SECURITY_LEVEL","");
			tabdata.put("EVENT_TYPE_CAPTION",event_type_caption);
			tabdata.put("EVENT_DATE_CAPTION",event_date_caption);
			tabdata.put("EVENT_STATUS_CAPTION",event_status_caption);
			tabdata.put("EVENT_TITLE_CAPTION",event_title_caption) ;
			tabdata.put("EVENT_PERF_BY_CAPTION",event_perf_by_caption);
			tabdata.put("EVENT_AUTH_BY_CAPTION",event_auth_by_caption);
			tabdata.put("PRIVILEGE_TYPE","");
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("CONFIDENTIAL_YN",conf_yn);
//			tabdata.put("note_logo_id ",print_header_logo);
			tabdata.put("REPORT_HEADER_CODE ",report_header_desc);
			tabdata.put("NOTE_HEADER_CODE ",note_header_desc);
			tabdata.put("FOOTER_CODE ",footer_header_desc);
			tabdata.put("PRINT_LOGO_HEADER_YN",print_logo_header);
			tabdata.put("PRINT_TEXT_HDR_YN",print_txtlogo_header); //[IN032210]
			tabdata.put("PRINT_NOTES_ON_SIGN",print);
			tabdata.put("HDR_MARGIN_IN_INCH",header_margin_note);//[IN031116]
			tabdata.put("FT_MARGIN_IN_INCH",footer_margin_not);//[IN031116]
			tabdata.put("FWD_PRACT_IND",practitioner_level);//IN037675
			tabdata.put("FWD_SPLTY_IND",speciality_level);//IN037675
			tabdata.put("SIGN_ADDENM_OTH_YN",l_sign_addendum_oth);//IN037675
			tabdata.put("WATERMARK_YN",waterMark_YN); //IN059489
			
			
			
			if (mode.equalsIgnoreCase("insert"))
			{
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("note_group_id", note_group_id);					
			}
			else
				tabdata.put("NOTE_GROUP_ID",note_groupid_update);
			
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",facilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			return tabdata;
	
	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		HashMap tabdata			= null;

		String facilityId ;
		String client_ip_address ;
		String addedById			= "";
		String addedAtWorkstation	= "";

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		tabdata=new HashMap();
		
		try
		{
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
								                                              
			extractData(req) ;

			tabdata = populateHashMap(req); //FILL THE HASHMAP
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 

			String dupflds[]={"NOTE_TYPE"};

			boolean local_ejbs = false;
			String tabname="ca_note_type";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( inserted )
				error_value = "1" ;

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}


	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		HashMap tabdata			= null;
		//String beforeUpdateEff_status= "";

		String note_type = checkNull("note_type_update",req);
		String facilityId ;
		String client_ip_address ;
		String modifiedById			= "";
		String modifiedAtWorkstation= "";

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		tabdata=new HashMap();
		try
		{
			extractData(req) ;
			tabdata = populateHashMap(req); //FILL THE HASHMap
			HashMap condflds=new HashMap();
			condflds.put("note_type",note_type);
			
			boolean local_ejbs = false;
			String tabname="ca_note_type";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( modified )
				 error_value = "1" ;

			results.clear();
   			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}


/***************************************Delete**********************************************/


	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		String note_type= checkNull("note_type_update",req);

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		try
		{
			extractData(req) ;
			HashMap condflds=new HashMap();
			condflds.put("note_type",note_type);

			boolean local_ejbs = false;
			String tabname="ca_note_type";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = condflds;
			argArray[2] = tabname;

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = condflds.getClass();
			paramArray[2] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( modified )
				error_value = "1" ;

			results.clear();
      	
			if(!modified)
      			error = getMessage(locale,"NOTE_IN_USE","CA");
		  
      		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8")+"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());common-icn-0181
			e.printStackTrace();
		}
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }
}
