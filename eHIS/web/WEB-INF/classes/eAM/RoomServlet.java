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
 *		FileName : RoomServlet.java
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
import eCommon.SingleTabHandler.*;

public class RoomServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String longdesc ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	//String serviceURL;
	//String objectName;
	String roomnum;
	String roomtype;
	String residentstayyn="N";
	String smokingyn;
	String shortdesc;
	String bldngcode;
	String floorcode;
	String telnum;
	String extnum;
	String oxygen;
	String ivpump;
	String suction;
	String eeg;
	String ecg;
	String vitalsign;
	String infusionpump;
	String ventilator;
	String facility="";
	String privacylevel;
	String infdiseaseyn;
 	String radimplantpatientsyn;

/* Added No Of Beds Max on 06/02/04 by Sridhar */
	String maxbed;
/*********** End of Addition ************/
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		
		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )	insertRoom(req, res);
			if ( operation.equals("modify"))    modifyRoom(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/


private void modifyRoom(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			facility = req.getParameter("facility");
				if(facility == null) facility="";

			if(req.getParameter("room_num") == null)
			   roomnum="null";
			else
			   roomnum=req.getParameter("room_num");

			if(req.getParameter("locn_type")== null)
				roomtype="null";
			else
				roomtype=req.getParameter("locn_type");

			residentstayyn=req.getParameter("resident_stay_yn") ;
			if (residentstayyn==null)
				residentstayyn="N";
			if (req.getParameter("bldng_code") == null)
				bldngcode="null";
			else
				bldngcode=req.getParameter("bldng_code");

           	if (req.getParameter("flor_code") == null)
				floorcode="null";
			else
				floorcode=req.getParameter("flor_code");

/* Added No Of Beds Max on 06/02/04 by Sridhar */
/*			if (req.getParameter("min_bed") == null)
				minbed="null";
			else
				minbed = req.getParameter("min_bed");*/

			if (req.getParameter("maxi_bed") == null)
				maxbed="null";
			else
				maxbed = req.getParameter("maxi_bed");
/*********** End of Addition ************/

			telnum=req.getParameter("tel_num");
			if(telnum==null) telnum="N" ;

			extnum=req.getParameter("ext_num");
			if(extnum==null) extnum="N";


			oxygen=req.getParameter("oxygen");
			if(oxygen==null)
			   oxygen="N";
			ivpump=req.getParameter("ivpump");
			if(ivpump==null)
			   ivpump="N";
			suction=req.getParameter("suction");
			if(suction==null)
			   suction="N";
			eeg=req.getParameter("eeg");
			if(eeg==null)
			   eeg="N";
			ecg=req.getParameter("ecg");
			if(ecg==null)
			   ecg="N";
			vitalsign=req.getParameter("vitalsign");
			if(vitalsign==null)
			   vitalsign="N";
			infusionpump=req.getParameter("infusionpump");
			if(infusionpump==null)
			   infusionpump="N";
			ventilator=req.getParameter("ventilator");
			if(ventilator==null)
			   ventilator="N";
			privacylevel=req.getParameter("privacy_level");
			if(privacylevel==null)
			   privacylevel="N";
			infdiseaseyn=req.getParameter("inf_disease_yn");
			if(infdiseaseyn==null)
			   infdiseaseyn="N";
			radimplantpatientsyn=req.getParameter("rad_implant_patients_yn");
			if(radimplantpatientsyn==null)
			   radimplantpatientsyn="N";

			smokingyn=req.getParameter("smoking_yn");
			if(smokingyn==null) {
			   smokingyn="N";
		   }
			if(req.getParameter("long_desc")==null)
				longdesc = "null";
			else
				longdesc = req.getParameter("long_desc");

			if(req.getParameter("short_desc")==null)
				shortdesc = "null";
			else
				shortdesc = req.getParameter("short_desc");

			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				 effectiveStatus="D";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
				tabdata.put("room_type",roomtype  );
				tabdata.put("bldng_code",bldngcode);
				tabdata.put("floor_code",floorcode);
				tabdata.put("resident_stay_yn",residentstayyn );
				tabdata.put("inf_disease_yn",infdiseaseyn );
				tabdata.put("ext_num",extnum );
				tabdata.put("tel_num",telnum );
				tabdata.put("smoking_yn",smokingyn );
				tabdata.put("rad_implant_patients_yn",radimplantpatientsyn );
				tabdata.put("smoking_yn",smokingyn );
				tabdata.put("long_desc",longdesc );
				tabdata.put("short_desc",shortdesc );
				tabdata.put("privacy_level",privacylevel );
				tabdata.put("eqpt_type_1",oxygen );
				tabdata.put("eqpt_type_2",suction );
				tabdata.put("eqpt_type_3",vitalsign );
				tabdata.put("eqpt_type_4",infusionpump );
				tabdata.put("eqpt_type_5",ivpump );
				tabdata.put("eqpt_type_6",eeg );
				tabdata.put("eqpt_type_7",ecg );
				tabdata.put("eqpt_type_8",ventilator );

/* Added No Of Beds Max on 06/02/04 by Sridhar */
//				tabdata.put("no_of_beds_min",minbed );
				tabdata.put("no_of_beds_max",maxbed );
/***************** End of Addition **************/ 

				shortdesc = req.getParameter("short_desc");
				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
				condflds.put("room_num",roomnum);
				condflds.put("operating_facility_id",facility);

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_facility_room");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[1];
			String table_name="am_facility_room";
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
				String table_name="am_facility_room";
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
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
			    error = (String) results.get("error") ;
			    out.println("room_type"+roomtype  );
				out.println("bldng_code"+bldngcode);
				out.println("floor_code"+floorcode);
				out.println("resident_stay_yn"+residentstayyn );
				out.println("inf_disease_yn"+infdiseaseyn );
				out.println("ext_num"+extnum );
				out.println("tel_num"+telnum );
				out.println("smoking_yn"+smokingyn );
				out.println("rad_implant_patients_yn"+radimplantpatientsyn );
				out.println("smoking_yn"+smokingyn );
				out.println("privacy_level"+privacylevel );
				out.println("eqpt_type_1"+oxygen );
				out.println("eqpt_type_2"+suction );
				out.println("eqpt_type_3"+vitalsign );
				out.println("eqpt_type_4"+infusionpump );
				out.println("eqpt_type_5"+ivpump );
				out.println("eqpt_type_6"+eeg );
				out.println("eqpt_type_7"+ecg );
				out.println("eqpt_type_8"+ventilator );

/********** Added No Of Beds Max on 06/02/04 by Sridhar ***************/
//				out.println("no_of_beds_min"+minbed);
				out.println("no_of_beds_max"+maxbed);
/*********************** End of Addition ************************/ 

				out.println("eff_status"+effectiveStatus);
				//out.println("added_by_id"+addedById);
				out.println("modified_by_id"+modifiedById);
				out.println("modified_date"+modified_date);
				out.println("modified_facility_id"+modifiedFacilityId);
				out.println("modified_at_ws_no"+modifiedAtWorkstation );
				out.println("room_num"+roomnum );
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
			tabdata.clear();
			condflds.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( roomnum+ " "+roomtype+""+residentstayyn+" "+longdesc + " "+shortdesc + " "+ effectiveStatus );
		}
	}

private void insertRoom(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			facility=req.getParameter("facility");

			if(req.getParameter("room_num") == null)
				   roomnum="null";
			else
				   roomnum=req.getParameter("room_num");

			if(req.getParameter("locn_type")== null)
					roomtype="null";
			else
					roomtype=req.getParameter("locn_type");

			residentstayyn=req.getParameter("resident_stay_yn") ;
			if (residentstayyn==null)
				residentstayyn="N";
			if (req.getParameter("bldng_code") == null)
				bldngcode="null";
			else
				bldngcode=req.getParameter("bldng_code");

			if (req.getParameter("floor_code") == null)
				floorcode="null";
			else
				floorcode=req.getParameter("floor_code");

/* Added No Of Beds Max on 06/02/04 by Sridhar  */
/*			if (req.getParameter("min_bed") == null)
				minbed="null";
			else
				minbed = req.getParameter("min_bed");*/

			if (req.getParameter("max_bed") == null)
				maxbed="null";
			else
				maxbed = req.getParameter("max_bed");
/********************* End Of Addition ****************/

			telnum=req.getParameter("tel_num");
			if(telnum==null)
			   telnum="";

			extnum=req.getParameter("ext_num");
			if(extnum==null) extnum="";

			oxygen=req.getParameter("oxygen");
			if(oxygen==null)
			   oxygen="N";

			ivpump=req.getParameter("ivpump");
			if(ivpump==null)
			   ivpump="N";

			suction=req.getParameter("suction");
			if(suction==null)
			   suction="N";

			eeg=req.getParameter("eeg");
			if(eeg==null)
			   eeg="N";

			ecg=req.getParameter("ecg");
			if(ecg==null)
			   ecg="N";

			vitalsign=req.getParameter("vitalsign");
			if(vitalsign==null)
			   vitalsign="N";

			infusionpump=req.getParameter("infusionpump");
			if(infusionpump==null)
			   infusionpump="N";

			ventilator=req.getParameter("ventilator");
			if(ventilator==null)
			   ventilator="N";

			privacylevel=req.getParameter("privacy_level");
			if(privacylevel==null)
			   privacylevel="N";

			infdiseaseyn=req.getParameter("inf_disease_yn");
			if(infdiseaseyn==null)
			   infdiseaseyn="N";

			radimplantpatientsyn=req.getParameter("rad_implant_patients_yn");

			if(radimplantpatientsyn==null)
			   radimplantpatientsyn="N";

			smokingyn=req.getParameter("smoking_yn");
			if(smokingyn==null)
			   smokingyn="N";

			if(req.getParameter("long_desc")==null)
				longdesc = "null";
			else
				longdesc = req.getParameter("long_desc");

			if(req.getParameter("short_desc")==null)
				shortdesc = "null";
			else
				shortdesc = req.getParameter("short_desc");

			effectiveStatus = req.getParameter("eff_status");

			if ( effectiveStatus == null )
				 effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
				tabdata.put("operating_facility_id",facility );
				tabdata.put("room_num",roomnum );
				tabdata.put("room_type",roomtype  );
				tabdata.put("resident_stay_yn",residentstayyn);
				tabdata.put("long_desc",longdesc);
				tabdata.put("short_desc",shortdesc);
				tabdata.put("bldng_code",bldngcode);
				tabdata.put("floor_code",floorcode);
				tabdata.put("tel_num",telnum);
				tabdata.put("ext_num",extnum);
				tabdata.put("privacy_level",privacylevel);
				tabdata.put("inf_disease_yn",infdiseaseyn);
				tabdata.put("rad_implant_patients_yn",radimplantpatientsyn);
				tabdata.put("smoking_yn",smokingyn );
				tabdata.put("eqpt_type_1",oxygen );
				tabdata.put("eqpt_type_2",suction );
				tabdata.put("eqpt_type_3",vitalsign );
				tabdata.put("eqpt_type_4",infusionpump );
				tabdata.put("eqpt_type_5",ivpump );
				tabdata.put("eqpt_type_6",eeg );
				tabdata.put("eqpt_type_7",ecg );
				tabdata.put("eqpt_type_8",ventilator );

/* Added No Of Beds Max on 06/02/04 by Sridhar  */
//				tabdata.put("no_of_beds_min",minbed);
				tabdata.put("no_of_beds_max",maxbed);
/***************** End of Addition **************/ 

				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"operating_facility_id","room_num"};

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_facility_room");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[1];
			String table_name="am_facility_room";

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
				String table_name="am_facility_room";
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

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			
			String error_value = "0" ;
			if ( inserted )
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
			tabdata.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( roomnum+ " "+longdesc + " "+shortdesc +" "+floorcode+" "+ bldngcode+" "+ effectiveStatus );
		}
	}
}
