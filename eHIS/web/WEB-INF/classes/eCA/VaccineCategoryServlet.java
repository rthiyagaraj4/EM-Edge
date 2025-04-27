/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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
public class VaccineCategoryServlet extends javax.servlet.http.HttpServlet
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
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//PrintWriter out = null; commented by ksihore kumar N, on 09-Nov-09
		try
		{
			//out = res.getWriter(); commented by ksihore kumar N, on 09-Nov-09
			doPost(req,res);
		}
		catch(Exception e)
		{			
			e.printStackTrace();
		}
	}
	private void extractData(HttpServletRequest req)
	{

			String vaccine_Category_id="";
			String vaccine_long_desc="";
			String vaccine_short_desc="";
			String age_group="";
			String multiple_yn="";
			String adh_yn="";
			String eff_status	="";
			String beforeUpdateEff_status="";
			String adhocAgeSpecificYN = "";

			String mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");

			 HttpSession session	= null;
			 session = req.getSession(false);

			beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req);

			eff_status				= checkNull("eff_status", req);
			eff_status  			=(eff_status.equals(""))?"D":eff_status ;

			if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
			{
				vaccine_Category_id			= checkNull("vaccine_Category_id_update",req);
			}
			else
			{
				vaccine_Category_id			= checkNull("vaccine_Category_id",req);
			}
			vaccine_long_desc			= checkNull("vaccine_long_desc",req);
			vaccine_short_desc			= checkNull("vaccine_short_desc",req);
			age_group			        = checkNull("age_group",req);
			multiple_yn				    = checkNull("multiple_yn", req);
			adh_yn					    = checkNull("adh_yn", req);
			adhocAgeSpecificYN			= checkNull("adhocAgeSpecificYN", req)== ""?"N":checkNull("adhocAgeSpecificYN", req);
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

			String vaccine_Category_id="";
			String vaccine_long_desc="";
			String vaccine_short_desc="";
			String age_group="";
			String multiple_yn="";
			String adh_yn="";
			String eff_status	="";
			String adhocAgeSpecificYN = "";

			HashMap tabdata			= null;
			String mode				= (req.getParameter("mode")==null)?"":req.getParameter("mode");
			String beforeUpdateEff_status= "";


			String facilityId ;
			String client_ip_address    ;
			String addedById			= "";
			String modifiedById			= "";
			String addedAtWorkstation	= "";
			String modifiedAtWorkstation= "";

			 HttpSession session	= null;
			 session = req.getSession(false);
			 p = (java.util.Properties) session.getValue( "jdbc" ) ;
			 //String locale = (String) p.getProperty("LOCALE");
			 facilityId = (String) session.getValue( "facility_id" ) ;
			 client_ip_address = p.getProperty("client_ip_address");
			 modifiedById =(p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			 modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
			 addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			 addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;
			 tabdata=new HashMap();

			 beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req);

			eff_status				= checkNull("eff_status", req);
			eff_status  			=(eff_status.equals(""))?"D":eff_status ;

			if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
			{
				vaccine_Category_id			= checkNull("vaccine_Category_id_update",req);
			}
			else
			{
				vaccine_Category_id			= checkNull("vaccine_Category_id",req);
			}


			vaccine_long_desc		= checkNull("vaccine_long_desc",req);
			vaccine_short_desc	    = checkNull("vaccine_short_desc",req);
			age_group	            = checkNull("age_group",req);
			adh_yn	                = checkNull("adh_yn",req);
			multiple_yn	            = checkNull("multiple_yn",req);
			adhocAgeSpecificYN		= checkNull("ageSpecificYN", req)== ""?"N":checkNull("ageSpecificYN", req);


			if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
			{
				tabdata.put("VACC_CATEG_ID", vaccine_Category_id);
				tabdata.put("EFF_STATUS",eff_status);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("MODIFIED_FACILITY_ID",facilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				tabdata.put("AGE_SPECIFIC_YN",adhocAgeSpecificYN);
				//tabdata.put("LOCALE",locale ); //Commented by shaiju Locale should not pass to SingleTabHandler ejb
				return tabdata;
			}

			tabdata.put("VACC_CATEG_ID", vaccine_Category_id);
			tabdata.put("LONG_DESC",vaccine_long_desc);
			tabdata.put("SHORT_DESC",vaccine_short_desc);
			tabdata.put("AGE_GROUP_CODE",age_group);
			tabdata.put("ALLOW_MULTIPLE_YN",multiple_yn);
			tabdata.put("ADHOC_YN",adh_yn);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("AGE_SPECIFIC_YN",adhocAgeSpecificYN);

			if (mode.equalsIgnoreCase("insert"))
			{
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			}
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

			//extractData(req) ; commented by ksihore kumar N, on 09-Nov-09 , the set of lines  covered in populateHashMap(req)

			tabdata = populateHashMap(req); //FILL THE HASHMAP
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;

			String dupflds[]={"VACC_CATEG_ID"};

			boolean local_ejbs = false;
			String tabname="CA_IM_VAC_CATEG ";

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
			e.printStackTrace();
		}
	}


	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		HashMap tabdata			= null;


		String vaccine_Category_id = checkNull("vaccine_Category_id_update",req);
		String facilityId ;
		String client_ip_address ;
		String modifiedById			= "";
		String modifiedAtWorkstation= "";

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
		tabdata=new HashMap();
		try
		{
			//extractData(req) ; commented by ksihore kumar N, on 09-Nov-09 , the set of lines  covered in populateHashMap(req)
			tabdata = populateHashMap(req); //FILL THE HASHMap
			HashMap condflds=new HashMap();
			condflds.put("VACC_CATEG_ID",vaccine_Category_id);

			boolean local_ejbs = false;
			String tabname="CA_IM_VAC_CATEG ";

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
			e.printStackTrace();
		}
	}


/***************************************Delete**********************************************/


	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;

		String vaccine_Category_id= checkNull("vaccine_Category_id_update",req);

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		try
		{
			//extractData(req) ; commented by ksihore kumar N, on 09-Nov-09 , the set of lines  covered in populateHashMap(req)
			HashMap condflds=new HashMap();
			condflds.put("VACC_CATEG_ID",vaccine_Category_id);

			boolean local_ejbs = false;
			String tabname="CA_IM_VAC_CATEG ";

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








