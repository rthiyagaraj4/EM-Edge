/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class FrequencyServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	//Connection con=null;


	String freq_code="";
	String freq_desc="";
	String freq_desc1="";
	String freq_desc2="";
	String freq_desc_loc_lang="";
	String	 freq_nature;
	String repeat_value="";
	String repeat_durn_type="";
	String interval_value="";
	String interval_durn_type="";
	String scheduled_yn="";
	String start_time_assign="";
	String start_time_round="";
	String max_no_of_cycle=""; //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2

	String eff_status	="";

	String facilityId ;
	String client_ip_address ;
	//String serviceURL;
	//String objectName;
	//String effectiveDateFrom ;
	//String effectiveDateTo ;

	String addedById			= "";
	//String addedDate			= "" ;
	String modifiedById			= "";
	//String modifiedDate			= "";
	//String addedFacilityId		= "";
	//String modifiedFacilityId	= "";
	String addedAtWorkstation	= "";
	String modifiedAtWorkstation= "";

	//java.sql.Date added_date1   = null;
	//java.sql.Date modified_date1= null;

	//java.sql.Date added_date =    null;
	//java.sql.Date modified_date=  null ;

	HashMap tabdata			= null;

	String mode					 = "";
	String beforeUpdateEff_status= "";

	HttpSession session;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = req.getRemoteAddr() ;
		//serviceURL=(String) session.getValue("serviceURL");

		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
	//	modifiedDate = dateFormat.format( new java.util.Date());
		//modifiedFacilityId		= (this.facilityId==null)?"":this.facilityId;
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
		tabdata=new HashMap();

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");


			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res);
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res);

		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	{	}
	}*/
/**********************************************************************************************/

	private void extractData(HttpServletRequest req)
	{
				beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req);

				eff_status				= checkNull("enable", req);
				eff_status  			=(eff_status.equals(""))?"D":"E" ;

				if(mode.trim().equalsIgnoreCase("modify"))
				{
					freq_code			= checkNull("code",req);
					freq_desc			= checkNull("freq_desc", req);
					freq_desc1			= checkNull("freq_desc1", req);
					freq_desc2			= checkNull("freq_desc2", req);

				}
				else
				{
					freq_code			= checkNull("code",req);
					freq_desc			= checkNull("freq_desc", req);
					freq_desc1			= checkNull("freq_desc1", req);
					freq_desc2			= checkNull("freq_desc2", req);
				}


			//	freq_desc_loc_lang			= checkNull("freq_desc_loc_lang",req);
				freq_desc_loc_lang			= "";
				freq_nature		        = req.getParameter("freq_nature");
				repeat_value			= checkNull("repeat", req);
				repeat_durn_type		= checkNull("repeatC", req);

				interval_value			= checkNull("every", req);
				interval_durn_type		= checkNull("repeatC", req);

				scheduled_yn			= checkNull("scheduled_yn", req);
		
				start_time_assign		= checkNull("start_time_assign", req);

				max_no_of_cycle		    = checkNull("MaxCycle", req); //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2



				if(freq_nature.equals("I")){
					start_time_assign		= checkNull("start_time_assign_temp", req);
					}
				start_time_round		= checkNull("round_to", req);



		}
	/***************************************Checks the request paramtere for the null values*****************************************************/

	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}

 /**********************************************Pouplates the hashtable with the values*******************/

	public void populateHashTable()
	{
				
			if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
				{
					tabdata.put("FREQ_CODE", freq_code);
					tabdata.put("EFF_STATUS",eff_status);
					tabdata.put("MODIFIED_BY_ID",modifiedById);
					tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("MODIFIED_FACILITY_ID",this.facilityId);
					tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
					return ;
				}

				tabdata.put("FREQ_CODE",freq_code);
				tabdata.put("FREQ_DESC",freq_desc);
				tabdata.put("PRINT_DESC_1",freq_desc1);
				tabdata.put("PRINT_DESC_2",freq_desc2);
				tabdata.put("FREQ_DESC_LOC_LANG",freq_desc_loc_lang);
				tabdata.put("FREQ_NATURE",(String)freq_nature);
				tabdata.put("REPEAT_VALUE",repeat_value);
				tabdata.put("REPEAT_DURN_TYPE",repeat_durn_type);
				tabdata.put("INTERVAL_VALUE",interval_value);
				tabdata.put("INTERVAL_DURN_TYPE",interval_durn_type);
				tabdata.put("SCHEDULED_YN",scheduled_yn);
				tabdata.put("START_TIME_ASSIGN",start_time_assign);
				tabdata.put("START_TIME_ROUND",start_time_round);
				tabdata.put("EFF_STATUS",eff_status);
				tabdata.put("MAX_NO_OF_CYCLE",max_no_of_cycle); //Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2


			if (mode.equalsIgnoreCase("insert"))
			{

				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", this.facilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);

			}

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",this.facilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );


			return ;

	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		//	addedDate = dateFormat.format( new java.util.Date() ) ;

			//addedFacilityId		= (this.facilityId==null)?"":this.facilityId;
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;

			//added_date1	 = java.sql.Date.valueOf( addedDate ) ;
			//modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			//added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			//modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			extractData(req) ;
			populateHashTable(); //FILL THE HASHTABLE

			String dupflds[]={"FREQ_CODE"};

			/*Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_frequency");*/

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			/*Object argArray[] = new Object[1];
			String table_name="am_frequency";

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("dupflds",dupflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/

				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_frequency";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

					
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;

			
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			if ( inserted )
			{
			 error_value = "1" ;
			}

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) +"&err_value="+error_value);
			//out.println(error);

			}
			catch ( Exception e )
			{
						out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
						e.printStackTrace();

			}
	}

	/***************************************modify**********************************************/


	private void modify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			extractData(req) ;
			populateHashTable(); //FILL THE HASHTABLE
			HashMap condflds=new HashMap();
			condflds.put("freq_code",freq_code);

			/*Context context =  new InitialContext() ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,
			SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_frequency");*/

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			/*Object argArray[] = new Object[4];
			String table_name="am_frequency";

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("condflds",condflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
			String table_name="am_frequency";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
            condflds.clear();

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( modified )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;

						}
       	error = (String) results.get("error") ;
   		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) +"&err_value="+error_value);
        
		results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}


/***************************************Delete**********************************************/



}
