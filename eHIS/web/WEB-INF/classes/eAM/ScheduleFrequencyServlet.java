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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eAM.ScheduleFreq.*;

public class ScheduleFrequencyServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	

	 String           freq_code;
	 String           admin_facility_id;
		
	


	String facilityId ;
	String client_ip_address ;
	//String serviceURL;


	String addedById			= "";
	String addedFacilityId		= "";
	//String modifiedFacilityId	= "";
	String addedAtWorkstation	= "";
	//String modifiedAtWorkstation= "";

	//java.sql.Date modified_date=  null ;

	HashMap tabdata			= null;

	String mode					 = "";
	
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
		System.out.println("client_ip_address"+client_ip_address);
		//serviceURL=(String) session.getValue("serviceURL");

		//modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		//modifiedDate = dateFormat.format( new java.util.Date());
		//modifiedFacilityId		= (this.facilityId==null)?"":this.facilityId;
		//modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;

		tabdata=new HashMap();

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");

			if (mode.trim().equals("1"))   insert(req, res);
			if (mode.trim().equals("2"))   modify(req, res);

		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

/***************************************************************************/
/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
	try{
			this.out = res.getWriter();
			res.setContentType("text/html");
	}catch(Exception e)	{	}
}*/
/***************************************insert**********************************************/
private void  insert(HttpServletRequest req, HttpServletResponse res){
	try{
		
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedFacilityId		= (this.facilityId==null)?"":this.facilityId;
		addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;

		 tabdata=new HashMap();

		freq_code			=req.getParameter("freq_code")	;
		System.out.println("freq_code"+freq_code);
		admin_facility_id	=req.getParameter("admin_facility_id");
		System.out.println("admin_facility_id"+admin_facility_id);
		String durationType	=req.getParameter("durationType");
		System.out.println("durationType"+durationType);

		if(durationType.trim().equalsIgnoreCase("W"))
			tabdata.put("admin_day_or_time","D");
		else if(durationType.trim().equalsIgnoreCase("L"))
			tabdata.put("admin_day_or_time","M");
		else
			tabdata.put("admin_day_or_time","H");


		tabdata.put("freq_code",freq_code);
		tabdata.put("admin_facility_id",admin_facility_id);
		tabdata.put("mode",mode);

		int counter = 0;
        int repeatCount=1;
	/*	for(int i=1 ; i <= 7 ; i++){
			String tempValues	= checkNull(req.getParameter("daySM"+i));
			out.println("tempValues="+tempValues);
			if(!tempValues.trim().equals("")){
				counter++ ;
				tabdata.put("admin_day"+counter,tempValues);
			}
		}*/


	//	tabdata.put("dayCount",new Integer(counter));
        String repeat="";
		repeat	=  req.getParameter("repeat");
		System.out.println("req148"+req);
		System.out.println("repeat"+repeat);
		if(repeat!=null&& repeat!=""&&!repeat.isEmpty())
		{			
		repeatCount =  Integer.parseInt(repeat.trim());
		}
		System.out.println("repeatCount146"+repeatCount);
		String max_no_of_cycle="";
		max_no_of_cycle	= checkNull(req.getParameter("max_no_of_cycle"));
        System.out.println("max_no_of_cycle148"+max_no_of_cycle);
		counter = 1 ;

		if(max_no_of_cycle.equals("")){
		for(int j=1 ; j <= repeatCount ; j++){
			System.out.println("1");
			String tempTime	= checkNull(req.getParameter("time"+j));
			if(!tempTime.trim().equals("")){
				//counter++ ;
				tabdata.put("admin_time"+counter,tempTime);
				
			}
			String tempDay = checkNull(req.getParameter("repeat_"+j));
			if(!tempDay.trim().equals("")){
			//	counter++ ;
				tabdata.put("admin_day"+counter,tempDay);
				}
				counter++;
			}
		}else{ //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2 - START
		    System.out.println("167");
			int max_cycle=0;
			if(max_no_of_cycle!=null&&max_no_of_cycle!=""&&!max_no_of_cycle.isEmpty())
			{
			max_cycle = Integer.parseInt(max_no_of_cycle.trim());
			}
			System.out.println("max_cycle169"+max_cycle);
			for(int j=1 ; j <= max_cycle ; j++){
				for(int k=1 ; k <= repeatCount ; k++){
					String tempTime	= checkNull(req.getParameter("row_"+j+"_time_"+k));
					if(!tempTime.trim().equals("")){
						tabdata.put("admin_time"+counter,tempTime);
					}
					if(durationType.equalsIgnoreCase("D")){
					String tempDay = checkNull(req.getParameter("repeat_D"+j));
					if(!tempDay.trim().equals(""))
					tabdata.put("admin_day"+counter,tempDay);
				}
				else if(durationType.equalsIgnoreCase("W")){
					String tempDay  = checkNull(req.getParameter("repeat_D"+j));
					String tempWeek = checkNull(req.getParameter("repeat_W"+j));
					if(!tempDay.trim().equals(""))
					tabdata.put("admin_day"+counter,tempDay);
					if(!tempWeek.trim().equals(""))
					tabdata.put("admin_week"+counter,tempWeek);
				}
				else if(durationType.equalsIgnoreCase("L")){
					String tempDay  = checkNull(req.getParameter("repeat_D"+j));
					String tempMonth = checkNull(req.getParameter("repeat_L"+j));
					if(!tempDay.trim().equals(""))
					tabdata.put("admin_day"+counter,tempDay);
					if(!tempMonth.trim().equals(""))
					tabdata.put("admin_month"+counter,tempMonth);
				}
			counter++;
				}
			}
		}
		tabdata.put("max_no_of_cycle",max_no_of_cycle);
		tabdata.put("durationType",durationType);

		tabdata.put("timeCount",new Integer(counter-1));

		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("added_facility_id", addedFacilityId);
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("modified_by_id",addedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_facility_id",addedFacilityId);
		tabdata.put("modified_at_ws_no",addedAtWorkstation );


		/*Context context =  new InitialContext();
		Object homeObject = context.lookup("java:comp/env/ScheduleFreq");
		ScheduleFreqHome scheduleFreqHome=(ScheduleFreqHome)PortableRemoteObject.narrow(homeObject,ScheduleFreqHome.class);
		final ScheduleFreqRemote sFMngr = scheduleFreqHome.create();
//		ScheduleFrequencyManager sFMngr =new  ScheduleFrequencyManager();
		final java.util.Hashtable results = sFMngr.insert(p,tabdata);*/


		
			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ScheduleFreq",ScheduleFreqHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
			hmParams.put("tabdata",tabdata);
			argArray[0] = hmParams;			
			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;


			String error = (String) results.get("error") ;
			String error_value = "0" ;

		if ( inserted ){
			 error_value = "1" ;
			
			}else{
			 error = (String) results.get("error") ;
			  
			}
            System.out.println("259");
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) +"&err_value="+error_value);

            hmParams.clear();
			results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}


	}

/***************************************modify**********************************************/

private void modify(HttpServletRequest req, HttpServletResponse res){
	try{
	insert(req,res);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
/***************************************Checks the request paramtere for the null values*****************************************************/
	public String checkNull(String str) {//flag is true for null feilds
		return (str==null)?"":str ;
	}
}
