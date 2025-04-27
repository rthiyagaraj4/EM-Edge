/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This servlet is used to add the Practitioner based on Nursing Unit or Services.
@author - 
@version - V3
*/
package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.RecordSet;
import eIP.IPNursUnitPract.*;
import eCommon.SingleTabHandler.*;

public class NursUnitPractServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId ;
	String sStyle;
	String client_ip_address ;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		this.out = res.getWriter();
		
		//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

		java.util.HashMap tabdata=new java.util.HashMap();
		session								= req.getSession(false);
		this.p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId						= (String) session.getValue( "facility_id" ) ;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address					= p.getProperty("client_ip_address");
		try
		{
			RecordSet  	PractNursRecordSet  =	null;
			//String	from					=	"",	  to	=	"";
			String removeCode = "";
			String search_by    = req.getParameter("search_by") ;
		    if(search_by == null || search_by.equals("null")) search_by="";

		    String search_txt   = req.getParameter("search_txt") ;
		    if(search_txt == null || search_txt.equals("null")) search_txt="";

			PractNursRecordSet				=	(webbeans.eCommon.RecordSet) session.getAttribute("PractNursRecordSet");

			//from							=   (req.getParameter("from")  ==null)? "0" : req.getParameter("from");
			//to								=   (req.getParameter("to")    ==null)	? "0" : req.getParameter("to");
			String start							=   (req.getParameter("start")  ==null)? "0" : req.getParameter("start");
			String end								=   (req.getParameter("end")    ==null)	? "0" : req.getParameter("end");
			String isOnApply						=   (req.getParameter("isOnApply")    ==null)	? "N" : req.getParameter("isOnApply");
			String isSimplifyPractNursUnit			=   (req.getParameter("isSimplifyPractNursUnit") == null)	? "false" : req.getParameter("isSimplifyPractNursUnit");
			
			String delete_id	=	"";
			//String insert_id    =   "";
			int insertCount = 0;
			String slCount = "0";
			boolean first_time_delete = true;
			if(isSimplifyPractNursUnit.equals("true")){
				String a_codes = "";
				String c_codes = "";
				HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("PractForNurseUnit"));
				if(map != null){
					
					for(int i = 1; i <= Integer.parseInt(map.get("page")); i++){
						if(i == 1){
							a_codes = map.get("a_clinic_id"+i); 
							c_codes = map.get("c_clinic_id"+i);  
						}else{
							// added for ML-MMOH-SCF-3045 start
							if(c_codes.equals("")){ 
							c_codes = map.get("c_clinic_id"+i); 	
							}else{
							c_codes = c_codes+","+map.get("c_clinic_id"+i); 
							} 
							// added for ML-MMOH-SCF-3045 end
							a_codes = a_codes+","+map.get("a_clinic_id"+i); 
						 }					
					}
					
					String a_codes_arr [] = a_codes.split(",");
					if(!c_codes.equals("")){  // Added for ML-MMOH-SCF-3045
					String c_codes_arr [] = c_codes.split(",");
					
					for(int i = 0; i < c_codes_arr.length; i++){
						tabdata.put(("select_yn"+i),c_codes_arr[i]);
					}
					slCount		 =	""+c_codes_arr.length;
					}
					for(int i = 0; i < a_codes_arr.length; i++){
						if(i==0){
							a_codes = "'"+a_codes_arr[i]+"'";
						}else{
							a_codes =a_codes + ",'"+a_codes_arr[i]+"'";
						}
					}
					
				}
				tabdata.put("delete_id",a_codes);	
			}else{
				if(start != null && end != null)
				{
					start							=	start.trim();
					end								=	end.trim();
	
					for(int i=(Integer.parseInt(start))+1; i<=(Integer.parseInt(end)); i++)
					{
						removeCode = checkForNull(req.getParameter("removeCode"+(i)));
						String Code = req.getParameter("Code"+(i));
						
	
							if(first_time_delete)
								delete_id = delete_id+"'"+Code+"'";
							else
								delete_id = delete_id+",'"+Code+"'";
	
							first_time_delete = false;
	
						if(removeCode.equals("N"))
						{
							tabdata.put(("select_yn"+insertCount),Code);
							insertCount ++;						
						}
					}
				}
				tabdata.put("delete_id",delete_id);	
				slCount		 =	""+insertCount;	
			}
			tabdata.put("Function",req.getParameter("Function"));
			tabdata.put("function_code",req.getParameter("function_code") == null ? "" : req.getParameter("function_code"));
			String addedById				= p.getProperty( "login_user" ) ;
			String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String modifiedById				= addedById ;
			String modifiedFacilityId		= facilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;

			java.sql.Date added_date1		= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date		= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			tabdata.put("facilityId",facilityId);
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("search_by",search_by);
			tabdata.put("search_txt",search_txt);

			tabdata.put("modified_date",new java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );
			tabdata.put("delete_id",delete_id);	

			p = (java.util.Properties) session.getValue( "jdbc" ) ;

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPNursUnitPract",IPNursUnitPractHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tabdata;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("InsDelIPNursUnitPract",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted							= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error								= (String) results.get("error") ;
		String error_value							= "";

		tabdata.clear();
		results.clear();
		if(inserted)
		{
			if(isSimplifyPractNursUnit.equals("true")){
				
				session.removeAttribute("PractForNurseUnit");
				error_value = "1";				
				out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error,"UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
				
			}else{
				if(isOnApply.equals("Y"))
				{
					out.println("<script>parent.frames[1].frames[2].reloadresultPageOfNurseUnitPract('C');</script>"); 				
				}
				else
				{
					error_value = "1";				
					out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error,"UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
				}
			}
			
		}
		else
		{
			error_value = "0";
			out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error,"UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Added by Sridhar R on 8 July 2005.. thesse functions will chk for null value & return empty String...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}
}

