/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

package eMO;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import com.ehis.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eCommon.SingleTabHandler.*;
import eMO.ManageDeceased.*;
import webbeans.eCommon.*;

public class MOManageDeceasedAssignAreaServlet extends HttpServlet {
	//MOMDAssignAreaServlet
	PrintWriter		out;
	String			facilityId;
	HttpSession		session;
	Connection		con		= null;
	Properties		p;
	boolean			inserted= false;
	String locale;
	String client_ip_address            ="";         
	String addedById			        ="";
	String registration			        ="";
	String pmstatus				        ="";
	String endPM				        ="";
	String cancelPM			 	        ="";
	String startPM				        ="";
	String area_code			        ="";
	String bed_no				        ="";
	String assign_tmt_area_time	        ="";
	String RFID_Tag	        ="";
	String modifiedById                 = "";
	String modifiedDate                 = "";
	String modifiedFacilityId           ="";
	String post_perf_pract1             =""; 
	String post_perf_role1              ="";
	String modifiedAtWorkstation        = "";
    String desig1="";
    String desig2="";
     String patient_id="";
	 String  donatedorgan                = "";              
	 String  pract13                     = "";              
	 String  tissue_proc_date            = "";         
	 String  tissue_procured_by          = "";    
	 String  tissue_procure_performed_date= "";
	 String  registration_no             = "";
	 String PM_PURPOSE                   = "";          
	 String pract1                       = "";                      
	 String pract2                       = "";                 
	 String pract3                       = "";            
	 String pract4                       = "";       
	 String pract5                       = "";  
	 String role1                        = "";
	 String role2                        = "";
	 String role3                        = "";
	 String role4                        = "";
	 String role5                        = "";
	 String pract6                       = "";
	 String pract7                       = ""; 
	 String desi1                        = "";
	 String desi2                        = "";
	 String pm_start_date_time           = "";
	 String pm_end_date_time             = "";
	 String diagscheme                   = "";
	 String pract14                      = "";
	 String pract9                       = ""; 
	 String mr_diagnosis_code            = "";
	 String mr_diagnosis_code1           = "";
	 String mr_diagnosis_code2           = "";
	 String mr_diagnosis_code3           = "";
	 String mr_diagnosis_code4           = "";
	 String mr_diagnosis_code5           = "";
	 String mr_diagnosis_code6           = "";		// BRU-HIMS-CRF-270
	 String mr_diagnosis_code7           = "";		// BRU-HIMS-CRF-270
	 String mr_diagnosis_desc            = "";
	 String mr_diagnosis_desc1           = "";
	 String mr_diagnosis_desc2           = "";
	 String mr_diagnosis_desc3           = "";
	 String mr_diagnosis_desc4           = "";
	 String mr_diagnosis_desc5           = "";
	 String mr_diagnosis_desc6           = "";		// BRU-HIMS-CRF-270
	 String mr_diagnosis_desc7           = "";		// BRU-HIMS-CRF-270

	 String onset_date1                  = "";
	 String onset_date2                  = "";
	 String onset_date3                  = "";
	 String onset_date4                  = "";
	 String onset_date5                  = "";
	 String onset_date6                  = "";
	 String onset_date7                  = "";		// BRU-HIMS-CRF-270
	 String onset_date8                  = "";		// BRU-HIMS-CRF-270
	 String cause_remarks1				 = "";		// BRU-HIMS-CRF-270
	 String cause_remarks2				 = "";		// BRU-HIMS-CRF-270
	 String cause_remarks3				 = "";		// BRU-HIMS-CRF-270
	 String cause_remarks4				 = "";		// BRU-HIMS-CRF-270
	 String cause_remarks5				 = "";		// BRU-HIMS-CRF-270
	 String cause_remarks6				 = "";		// BRU-HIMS-CRF-270
	 String manner_of_death              = "";
	 String postmortem_findings          = "";
	 String speci_desc1                  = "";
	 String speci_desc2                  = "";
	 String speci_desc3                  = "";
	 String speci_desc4                  = "";
	 String speci_desc5                  = "";
	 String speci_desc6                  = "";
	 String speci_type1                  = "";
	 String speci_type2                  = "";
	 String speci_type3                  = "";
	 String speci_type4                  = "";
	 String speci_type5                  = "";
	 String speci_type6                  = "";
	 String anotomical_site_code1        = "";
	 String anotomical_site_code2        = "";
	 String anotomical_site_code3        = "";
	 String anotomical_site_code4        = "";
	 String anotomical_site_code5        = "";
	 String anotomical_site_code6        = "";
	 String collection_time1             = "";
	 String collection_time2             = "";
	 String collection_time3             = "";
	 String collection_time4             = "";
	 String collection_time5             = "";
	 String collection_time6             = "";
	 String spec_collected_by            = "";
	 String spec_handed_over_to          = "";
	 String spec_handed_over_date        = "";
	 String desig3	                     ="";  
/*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/	 
     String death_after_potmrtm          ="";  
/* below line added by Mano aganist ML-MMOH-CRF-0791 */	 
     String examination_type             = "";	 

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session           		= req.getSession(false) ;
		out               		= res.getWriter() ;
		this.facilityId			= (String) session.getValue( "facility_id" ) ;
		this.p					= (java.util.Properties)session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		addedById			    = p.getProperty( "login_user" ) ;
		locale					= p.getProperty("LOCALE");

		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		modifiedById			= addedById ;
		modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		modifiedAtWorkstation= addedAtWorkstation ;
		registration = req.getParameter("registration");
		if ((registration == null)|| (registration.equals("null")))
		registration = "";
		pmstatus = req.getParameter("pmstatus");
		if ((pmstatus == null)|| (pmstatus.equals("null")))
		pmstatus = "";
		endPM= req.getParameter("endPM");
		endPM = (endPM==null) ? "" :endPM;
		cancelPM= req.getParameter("cancelPM");
		cancelPM = (cancelPM==null) ? "" :cancelPM;
		startPM= req.getParameter("startPM");
		startPM = (startPM==null) ? "" :startPM;
		examination_type = req.getParameter("examination_type");      //Added by mano aganist crf-791
		examination_type = (examination_type==null) ? "" :examination_type; //added by Mano againstcrf-0791
		area_code = req.getParameter("area_code");
		if ((area_code == null)|| (area_code.equals("null")))
		area_code = "";
		bed_no = req.getParameter("bed_no");

		if ((bed_no == null)|| (bed_no.equals("null")))
		bed_no = "";
		assign_tmt_area_time = req.getParameter("assign_tmt_area_time");
		if ((assign_tmt_area_time == null)|| (assign_tmt_area_time.equals("null")))
		assign_tmt_area_time	=	"";
		RFID_Tag = req.getParameter("RFID_Tag")==null?"":req.getParameter("RFID_Tag");
				
		
		if (area_code!="" || assign_tmt_area_time!="")
		{
			modifyReassignArea(req,res);
		}
		
		if (pmstatus.equalsIgnoreCase("S"))
		{
			pmstatus = "S";
			modifyPMstatusStartArea(req,res);
		}
		if (pmstatus.equalsIgnoreCase("S")&& endPM.equalsIgnoreCase("E"))
		{
			pmstatus="E";
			modifyPMstatusEndArea(req,res);
		}
		if (pmstatus.equalsIgnoreCase("S")&& cancelPM.equalsIgnoreCase("C"))
		{
			pmstatus="C";
			modifyPMstatusCancelArea(req,res);
		}
         //Postmortem request to take place  if OR is not Instaled 
		if( pmstatus.equalsIgnoreCase("R")&&cancelPM.equalsIgnoreCase("NO"))
		{
			//pmstatus="C";
			modifyPMstatusCancelArea(req,res);
		}

	}//end of doPost

	public void  modifyReassignArea(HttpServletRequest req, HttpServletResponse res)
	{	
		
		
	 try	
	  { 
		 
		con = ConnectionManager.getConnection(req);
		session           			= req.getSession(false) ;
		out               			= res.getWriter() ;
		this.facilityId				= (String) session.getValue( "facility_id" ) ;
		this.p						= (java.util.Properties)session.getValue( "jdbc" ) ;
		this.client_ip_address		= p.getProperty("client_ip_address");
		addedById					= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		modifiedById			= addedById ;
		modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		modifiedAtWorkstation= addedAtWorkstation ;
		 registration_no = req.getParameter("registration_no");
		if ((registration_no == null)|| (registration_no.equals("null")))
			registration_no = "";
		
        String old_bed_no = req.getParameter("old_bed_no");
		if ((old_bed_no == null)|| (old_bed_no.equals("null")))
		old_bed_no = "";

		 patient_id = req.getParameter("patient_id");
		if ((patient_id == null)|| (patient_id.equals("null")))
			patient_id = "";

		
		if(assign_tmt_area_time!=null && !assign_tmt_area_time.equals(""))
			assign_tmt_area_time = DateUtils.convertDate(assign_tmt_area_time,"DMYHM",locale,"en"); 
		
		

		StringTokenizer receivetoks = new StringTokenizer (assign_tmt_area_time," ") ;
		StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
		String receiveArr[] =new String[3] ;
		for( int q=0;q<3;q++ )
		receiveArr[q] = receivetok1.nextToken() ;
		assign_tmt_area_time = receiveArr[0] +"/"+receiveArr[1]+"/"+ receiveArr[2]+" "+receivetoks.nextToken()   ;
		//Timestamp receiveTimestamp= Timestamp.valueOf(assign_tmt_area_time);

		
		HashMap tabdata=new HashMap();
		tabdata.put("AREA_CODE",area_code);
		tabdata.put("BED_NO",bed_no);
		tabdata.put("old_bed_no",old_bed_no);
		tabdata.put("ASSIGN_DATE_TIME",assign_tmt_area_time );
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modifiedDate);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("REGISTRATION_NO",registration_no);
		tabdata.put("OCCUPYING_PATIENT_ID",patient_id);	
		tabdata.put("RFID_Tag",RFID_Tag);	
		

		boolean local_ejbs = false;


		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ManageDeceased",MOManageDeceasedHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tabdata;
		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
         

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyReassignArea",paramArray)).invoke(busObj,argArray);
		

		inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

	    String error = (String) results.get("error") ;
	
	 if(error.lastIndexOf("<br>")>=0)
	 error=error.substring(0,error.lastIndexOf("<br>"));
   
	 if (inserted)
     { doOnlineReports(facilityId,registration_no);
	     if(error.lastIndexOf("<br>")>=0)
	 	 error=error.substring(0,error.lastIndexOf("<br>"));

      out.println("<script>alert('"+error+"'); parent.window.close();</script>");
      
    
	}else
 {
   if(error.lastIndexOf("<br>")>=0)
   error=error.substring(0,error.lastIndexOf("<br>"));
   out.println("<script>alert('"+error+"'); </script>");
   out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num=&err_value=0';</script>");   

 }

tabdata.clear();
results.clear();
}
	  catch(Exception e)
	  {
		 e.printStackTrace();
	  } 
	  finally
	 {
		  ConnectionManager.returnConnection(con,req);
	 }
	 }//end of modifyReassignArea 

	/*private String getMessage(String msg)
	{
		java.util.Hashtable message = MessageManager.getMessage( con, msg ) ;
		return((String) message.get("message")) ;
	}*/

	
	
	
	
	
	private void doOnlineReports(String facility_id,String registration_no) throws ServletException, IOException, SQLException
    {
		StringBuffer htmlFor =new StringBuffer();
		String sqlString="";
		htmlFor.setLength(0);
		if(area_code.equals(""))
		{
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in('MOBLABEL')";		
		}else{
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in('MOBLABEL','MOBFREEZ')";		
		}
	
		String reportParamNames = "p_facility_id,P_FM_REGISTRATION_NO,P_TO_REGISTRATION_NO";
		String reportParamValues = ""+facility_id+","+registration_no+","+registration_no+"";
	  
	    htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		 htmlFor.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append("<script language = 'JavaScript'> async function doOnlineReport(){" );
        htmlFor.append("  var dialogHeight    = '30' ;");
        htmlFor.append( " var dialogWidth = '70' ;");
        htmlFor.append( "var dialogTop = '65';" );
        htmlFor.append( "  var arguments =   ''; ");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MO_REGISTER_DECEASED&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_id+"';");

        htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");

        htmlFor.append("  retVal            =   await window.showModalDialog(getUrl,arguments,features); } ");
        htmlFor.append(" doOnlineReport();</script>"  );
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
 }
	
	public void  modifyPMstatusStartArea(HttpServletRequest request, HttpServletResponse response)
	{

		
	try	
	{ 
		collectPostMortemDetails(request); 
		session           		= request.getSession(false) ;
		out               		= response.getWriter() ;
		this.facilityId			= (String) session.getValue( "facility_id" ) ;
		this.p					= (java.util.Properties)session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		addedById			= p.getProperty( "login_user" ) ;
		modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		modifiedAtWorkstation= addedAtWorkstation ;
		HashMap tabdata=new HashMap();
		tabdata.put("PM_PURPOSE",PM_PURPOSE);
		tabdata.put("PM_CONDUCTED_BY_PRACT_ID1",pract1);
		tabdata.put("PM_CONDUCTED_BY_PRACT_ID2",pract2);
		tabdata.put("PM_CONDUCTED_BY_PRACT_ID3",pract3);
		tabdata.put("PM_CONDUCTED_BY_PRACT_ID4",pract4);
		tabdata.put("PM_CONDUCTED_BY_PRACT_ID5",pract5);
		tabdata.put("pm_requested_by",pract14);
		tabdata.put("PRACT_ID1_ROLE1",role1);
		tabdata.put("PRACT_ID2_ROLE2",role2);
		tabdata.put("PRACT_ID3_ROLE3",role3);
		tabdata.put("PRACT_ID4_ROLE4",role4);
		tabdata.put("PRACT_ID5_ROLE5",role5);
		tabdata.put("WITNESS1",pract6);
		tabdata.put("WITNESS2",pract7);
		tabdata.put("WITNESSDESI1",desi1);
		tabdata.put("WITNESSDESI2",desi2);
		tabdata.put("POSTMORTEM_START_DATE_TIME",pm_start_date_time);
		tabdata.put("POSTMORTEM_END_DATE_TIME",pm_end_date_time);
		tabdata.put("PM_CERTIFIED_BY",pract9);
		tabdata.put("diagscheme",diagscheme);
		tabdata.put("donatedorgan",donatedorgan);
		tabdata.put("pract13",pract13);
		tabdata.put("tissue_proc_date",tissue_proc_date);
		tabdata.put("mr_diagnosis_code",mr_diagnosis_code);
		tabdata.put("mr_diagnosis_code1",mr_diagnosis_code1);
		tabdata.put("mr_diagnosis_code2",mr_diagnosis_code2);
		tabdata.put("mr_diagnosis_code3",mr_diagnosis_code3);
		tabdata.put("mr_diagnosis_code4",mr_diagnosis_code4);
		tabdata.put("mr_diagnosis_code5",mr_diagnosis_code5);
		tabdata.put("mr_diagnosis_code6",mr_diagnosis_code6);		// BRU-HIMS-CRF-270
		tabdata.put("mr_diagnosis_code7",mr_diagnosis_code7);		// BRU-HIMS-CRF-270
	
		tabdata.put("mr_diagnosis_desc",mr_diagnosis_desc);
		tabdata.put("mr_diagnosis_desc1",mr_diagnosis_desc1);
		tabdata.put("mr_diagnosis_desc2",mr_diagnosis_desc2);
		tabdata.put("mr_diagnosis_desc3",mr_diagnosis_desc3);
		tabdata.put("mr_diagnosis_desc4",mr_diagnosis_desc4);
		tabdata.put("mr_diagnosis_desc5",mr_diagnosis_desc5);
		tabdata.put("mr_diagnosis_desc6",mr_diagnosis_desc6);		// BRU-HIMS-CRF-270
		tabdata.put("mr_diagnosis_desc7",mr_diagnosis_desc7);		// BRU-HIMS-CRF-270
		tabdata.put("onset_date1",onset_date1);
		tabdata.put("onset_date2",onset_date2);
		tabdata.put("onset_date3",onset_date3);
		tabdata.put("onset_date4",onset_date4);
		tabdata.put("onset_date5",onset_date5);
		tabdata.put("onset_date6",onset_date6);
		// BRU-HIMS-CRF-270
		tabdata.put("onset_date7",onset_date7);						
		tabdata.put("onset_date8",onset_date8);						
		tabdata.put("cause_remarks1",cause_remarks1);				
		tabdata.put("cause_remarks2",cause_remarks2);				
		tabdata.put("cause_remarks3",cause_remarks3);				
		tabdata.put("cause_remarks4",cause_remarks4);				
		tabdata.put("cause_remarks5",cause_remarks5);				
		tabdata.put("cause_remarks6",cause_remarks6);	
		// BRU-HIMS-CRF-270 END HERE
		tabdata.put("manner_of_death",manner_of_death);
		tabdata.put("postmortem_findings",postmortem_findings);
		tabdata.put("speci_desc1",speci_desc1);
		tabdata.put("speci_desc2",speci_desc2);
		tabdata.put("speci_desc3",speci_desc3);
		tabdata.put("speci_desc4",speci_desc4);
		tabdata.put("speci_desc5",speci_desc5);
		tabdata.put("speci_desc6",speci_desc6);
		tabdata.put("speci_type1",speci_type1);
		tabdata.put("speci_type2",speci_type2);
		tabdata.put("speci_type3",speci_type3);
		tabdata.put("speci_type4",speci_type4);
		tabdata.put("speci_type5",speci_type5);
		tabdata.put("speci_type6",speci_type6);
		tabdata.put("speci_type1",speci_type1);
		tabdata.put("speci_type2",speci_type2);
		tabdata.put("speci_type3",speci_type3);
		tabdata.put("speci_type4",speci_type4);
		tabdata.put("speci_type5",speci_type5);
		tabdata.put("speci_type6",speci_type6);
		tabdata.put("anotomical_site_code1",anotomical_site_code1);
		tabdata.put("anotomical_site_code2",anotomical_site_code2);
		tabdata.put("anotomical_site_code3",anotomical_site_code3);
		tabdata.put("anotomical_site_code4",anotomical_site_code4);
		tabdata.put("anotomical_site_code5",anotomical_site_code5);
		tabdata.put("anotomical_site_code6",anotomical_site_code6);
		tabdata.put("collection_time1",collection_time1);
		tabdata.put("collection_time2",collection_time2);
		tabdata.put("collection_time3",collection_time3);
		tabdata.put("collection_time4",collection_time4);
		tabdata.put("collection_time5",collection_time5);
		tabdata.put("collection_time6",collection_time6);
		tabdata.put("tissue_procured_by",tissue_procured_by);
		tabdata.put("tissue_procure_performed_date",tissue_procure_performed_date);
		tabdata.put("spec_collected_by",spec_collected_by);
		tabdata.put("spec_handed_over_to",spec_handed_over_to);
		tabdata.put("spec_handed_over_date",spec_handed_over_date);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("FACILITY_ID",facilityId); 
		tabdata.put("REGISTRATION_NO",registration_no);
        tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("FACILITY_ID",facilityId); 
		tabdata.put("REGISTRATION_NO",registration_no);
		tabdata.put("PM_PERFORMED_BY",modifiedFacilityId);
		tabdata.put("FACILITY_ID",facilityId); 
		tabdata.put("REGISTRATION_NO",registration_no);
		tabdata.put("PM_PERFORMED_BY",post_perf_pract1); 
		tabdata.put("ROLE_FOR_PRACTITIONER",post_perf_role1);
		tabdata.put("ROLE_FOR_PRACTITIONER",post_perf_role1);
		tabdata.put("desig1",desig1);
        tabdata.put("desig2",desig2);
        tabdata.put("desig3",desig3); 
/*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/		
		tabdata.put("death_after_potmrtm",death_after_potmrtm);  
		tabdata.put("examination_type",examination_type); //Added by Mano aganist CRF-0791
	
		
        
        
		boolean local_ejbs = false;
	    if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ManageDeceased",MOManageDeceasedHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tabdata;
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
    	paramArray[1] = tabdata.getClass();
	    java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyPMstatusStartArea",paramArray)).invoke(busObj,argArray);
	    inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
    	String error = (String) results.get("error") ;
        if(error.lastIndexOf("<br>")>=0)
	    error=error.substring(0,error.lastIndexOf("<br>"));
    	out.println("<script>alert('"+error+"');parent.window.close();parent.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='</script>");
	tabdata.clear();
	results.clear();
	}catch(Exception e)
	{
		 e.printStackTrace();
	} 
	finally
	 {
		  ConnectionManager.returnConnection(con,request);
	 }
  }





   public void collectPostMortemDetails(HttpServletRequest request)
	{
    donatedorgan                       =request.getParameter("donatedorgan")==null?"":request.getParameter("donatedorgan");
	pract13                            =request.getParameter("pract13")==null?"":request.getParameter("pract13");
	tissue_proc_date                   =request.getParameter("tissue_proc_date")==null?"":request.getParameter("tissue_proc_date");
	tissue_procured_by                 =request.getParameter("pract13")==null?"":request.getParameter("pract13");
	tissue_procure_performed_date      =request.getParameter("tissue_proc_date")==null?"":request.getParameter("tissue_proc_date");
	registration_no                    =request.getParameter("registration_no")==null?"":request.getParameter("registration_no");
	PM_PURPOSE                         =request.getParameter("PM_PURPOSE")==null?"":request.getParameter("PM_PURPOSE");
	pract1                             =request.getParameter("pract1")==null?"":request.getParameter("pract1");
	pract2                             =request.getParameter("pract2")==null?"":request.getParameter("pract2");
	pract3                             =request.getParameter("pract_desc3")==null?"":request.getParameter("pract_desc3");
	pract4                             =request.getParameter("pract_desc4")==null?"":request.getParameter("pract_desc4");
	pract5                             =request.getParameter("pract_desc5")==null?"":request.getParameter("pract_desc5");
	role1                              =request.getParameter("role1")==null?"":request.getParameter("role1");
	role2                              =request.getParameter("role2")==null?"":request.getParameter("role2");
	role3                              =request.getParameter("role3")==null?"":request.getParameter("role3");
	role4                              =request.getParameter("role4")==null?"":request.getParameter("role4");
	role5                              =request.getParameter("role5")==null?"":request.getParameter("role5");
	pract6                             =request.getParameter("pract6")==null?"":request.getParameter("pract6");
	pract7                             =request.getParameter("pract7")==null?"":request.getParameter("pract7");
	desi1                              =request.getParameter("desi1")==null?"":request.getParameter("desi1");
	desi2                              =request.getParameter("desi2")==null?"":request.getParameter("desi2");
	pm_start_date_time                 =request.getParameter("pm_start_date_time")==null?"":request.getParameter("pm_start_date_time");
	pm_end_date_time                   =request.getParameter("pm_end_date_time")==null?"":request.getParameter("pm_end_date_time");
	diagscheme                         =request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	pract14                            =request.getParameter("pract14")==null?"":request.getParameter("pract14");
	pract9                             =request.getParameter("pract9")==null?"":request.getParameter("pract9");
	mr_diagnosis_code                  =request.getParameter("mr_diagnosis_code")==null?"":request.getParameter("mr_diagnosis_code");
	mr_diagnosis_code1                 =request.getParameter("mr_diagnosis_code1")==null?"":request.getParameter("mr_diagnosis_code1");
	mr_diagnosis_code2                 =request.getParameter("mr_diagnosis_desc2")==null?"":request.getParameter("mr_diagnosis_desc2");
	mr_diagnosis_code3                 =request.getParameter("mr_diagnosis_desc3")==null?"":request.getParameter("mr_diagnosis_desc3");
	mr_diagnosis_code4                 =request.getParameter("mr_diagnosis_code4")==null?"":request.getParameter("mr_diagnosis_code4");
	mr_diagnosis_code5                 =request.getParameter("mr_diagnosis_code5")==null?"":request.getParameter("mr_diagnosis_code5");
	mr_diagnosis_code6                 =request.getParameter("mr_diagnosis_code6")==null?"":request.getParameter("mr_diagnosis_code6"); // BRU-HIMS-CRF-270
	mr_diagnosis_code7                 =request.getParameter("mr_diagnosis_code7")==null?"":request.getParameter("mr_diagnosis_code7");// BRU-HIMS-CRF-270
	onset_date1                        =request.getParameter("onset_date1")==null?"":request.getParameter("onset_date1");
	onset_date2                        =request.getParameter("onset_date2")==null?"":request.getParameter("onset_date2");
	onset_date3                        =request.getParameter("onset_date3")==null?"":request.getParameter("onset_date3");
	onset_date4                        =request.getParameter("onset_date4")==null?"":request.getParameter("onset_date4");
	onset_date5                        =request.getParameter("onset_date5")==null?"":request.getParameter("onset_date5");
	onset_date6                        =request.getParameter("onset_date6")==null?"":request.getParameter("onset_date6");
	// BRU-HIMS-CRF-270
	onset_date7                        =request.getParameter("onset_date7")==null?"":request.getParameter("onset_date7");
	onset_date8                        =request.getParameter("onset_date8")==null?"":request.getParameter("onset_date8");
	cause_remarks1                        =request.getParameter("cause_remarks1")==null?"":request.getParameter("cause_remarks1");
	cause_remarks2                        =request.getParameter("cause_remarks2")==null?"":request.getParameter("cause_remarks2");
	cause_remarks3                        =request.getParameter("cause_remarks3")==null?"":request.getParameter("cause_remarks3");
	cause_remarks4                        =request.getParameter("cause_remarks4")==null?"":request.getParameter("cause_remarks4");
	cause_remarks5                        =request.getParameter("cause_remarks5")==null?"":request.getParameter("cause_remarks5");
	cause_remarks6                        =request.getParameter("cause_remarks6")==null?"":request.getParameter("cause_remarks6");	
	// BRU-HIMS-CRF-270 END HERE
	manner_of_death                    =request.getParameter("manner_of_death")==null?"":request.getParameter("manner_of_death");
	postmortem_findings                =request.getParameter("postmortem_findings")==null?"":request.getParameter("postmortem_findings");
	speci_desc1                        =request.getParameter("speci_desc1")==null?"":request.getParameter("speci_desc1");
	speci_desc2                        =request.getParameter("speci_desc2")==null?"":request.getParameter("speci_desc2");
	speci_desc3                        =request.getParameter("speci_desc3")==null?"":request.getParameter("speci_desc3");
	speci_desc4                        =request.getParameter("speci_desc4")==null?"":request.getParameter("speci_desc4");
	speci_desc5                        =request.getParameter("speci_desc5")==null?"":request.getParameter("speci_desc5");
	speci_desc6                        =request.getParameter("speci_desc6")==null?"":request.getParameter("speci_desc6");
	speci_type1                        =request.getParameter("speci_type1")==null?"":request.getParameter("speci_type1");
	speci_type2                        =request.getParameter("speci_type2")==null?"":request.getParameter("speci_type2");
	speci_type3                        =request.getParameter("speci_type3")==null?"":request.getParameter("speci_type3");
	speci_type4                        =request.getParameter("speci_type4")==null?"":request.getParameter("speci_type4");
	speci_type5                        =request.getParameter("speci_type5")==null?"":request.getParameter("speci_type5");
	speci_type6                        =request.getParameter("speci_type6")==null?"":request.getParameter("speci_type6");
	anotomical_site_code1              =request.getParameter("anotomical_site_code1")==null?"":request.getParameter("anotomical_site_code1");;
	anotomical_site_code2              =request.getParameter("anotomical_site_code2")==null?"":request.getParameter("anotomical_site_code2");;
	anotomical_site_code3              =request.getParameter("anotomical_site_code3")==null?"":request.getParameter("anotomical_site_code3");;
	anotomical_site_code4              =request.getParameter("anotomical_site_code4")==null?"":request.getParameter("anotomical_site_code4");
	anotomical_site_code5              =request.getParameter("anotomical_site_code5")==null?"":request.getParameter("anotomical_site_code5");
	anotomical_site_code6              =request.getParameter("anotomical_site_code6")==null?"":request.getParameter("anotomical_site_code6");
	collection_time1                   =request.getParameter("collection_time1")==null?"":request.getParameter("collection_time1");
	collection_time2                   =request.getParameter("collection_time2")==null?"":request.getParameter("collection_time2");
	collection_time3                   =request.getParameter("collection_time3")==null?"":request.getParameter("collection_time3");
	collection_time4                   =request.getParameter("collection_time4")==null?"":request.getParameter("collection_time4");
	collection_time5                   =request.getParameter("collection_time5")==null?"":request.getParameter("collection_time5");
	collection_time6                   =request.getParameter("collection_time6")==null?"":request.getParameter("collection_time6");
	spec_collected_by                  =request.getParameter("pract12")==null?"":request.getParameter("pract12");
	spec_handed_over_to                =request.getParameter("spec_handed_over_to")==null?"":request.getParameter("spec_handed_over_to");
	spec_handed_over_date              =request.getParameter("spec_handed_over_date")==null?"":request.getParameter("spec_handed_over_date");
    post_perf_pract1                   =request.getParameter("post_perf_pract1")==null?"":request.getParameter("post_perf_pract1");
	post_perf_role1                    = request.getParameter("post_perf_role1")==null?"":request.getParameter("post_perf_role1");
	desig1                             = request.getParameter("desig_desc4")==null?"":request.getParameter("desig_desc4");
	desig2                             = request.getParameter("desig_desc5")==null?"":request.getParameter("desig_desc5");
	desig3                             = request.getParameter("desig_desc3")==null?"":request.getParameter("desig_desc3");

	mr_diagnosis_desc                  =request.getParameter("mr_diagnosis_desc")==null?"":request.getParameter("mr_diagnosis_desc");
	mr_diagnosis_desc1                 =request.getParameter("mr_diagnosis_desc1")==null?"":request.getParameter("mr_diagnosis_desc1");
	mr_diagnosis_desc2                 =request.getParameter("mr_diagnosis_desc2")==null?"":request.getParameter("mr_diagnosis_desc2");
	mr_diagnosis_desc3                 =request.getParameter("mr_diagnosis_desc3")==null?"":request.getParameter("mr_diagnosis_desc3");
	mr_diagnosis_desc4                 =request.getParameter("mr_diagnosis_desc4")==null?"":request.getParameter("mr_diagnosis_desc4");
	mr_diagnosis_desc5                 =request.getParameter("mr_diagnosis_desc5")==null?"":request.getParameter("mr_diagnosis_desc5");
	mr_diagnosis_desc6                 =request.getParameter("mr_diagnosis_desc6")==null?"":request.getParameter("mr_diagnosis_desc6");// BRU-HIMS-CRF-270
	mr_diagnosis_desc7                 =request.getParameter("mr_diagnosis_desc7")==null?"":request.getParameter("mr_diagnosis_desc7");// BRU-HIMS-CRF-270
    /*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
	death_after_potmrtm                =request.getParameter("manner_of_death_after_potmrtm")==null?"":request.getParameter("manner_of_death_after_potmrtm"); 
	
	
	if(pm_start_date_time!=null && !pm_start_date_time.equals(""))
		pm_start_date_time = DateUtils.convertDate(pm_start_date_time,"DMYHM",locale,"en");
	

	
	if(pm_end_date_time!=null && !pm_end_date_time.equals(""))
		pm_end_date_time = DateUtils.convertDate(pm_end_date_time,"DMYHM",locale,"en");
	
	
	if(tissue_proc_date!=null && !tissue_proc_date.equals(""))
		tissue_proc_date = DateUtils.convertDate(tissue_proc_date,"DMYHM",locale,"en");
	

	
	if(tissue_procure_performed_date!=null && !tissue_procure_performed_date.equals(""))
		tissue_procure_performed_date = DateUtils.convertDate(tissue_procure_performed_date,"DMYHM",locale,"en");
	

	
	if(onset_date1!=null && !onset_date1.equals(""))
		onset_date1 = DateUtils.convertDate(onset_date1,"DMYHM",locale,"en");


	
	if(onset_date2!=null && !onset_date2.equals(""))
		onset_date2 = DateUtils.convertDate(onset_date2,"DMYHM",locale,"en");
	

	
	if(onset_date3!=null && !onset_date3.equals(""))
		onset_date3 = DateUtils.convertDate(onset_date3,"DMYHM",locale,"en");
	
	if(onset_date4!=null && !onset_date4.equals(""))
		onset_date4 = DateUtils.convertDate(onset_date4,"DMYHM",locale,"en");
	
	if(onset_date5!=null && !onset_date5.equals(""))
		onset_date5 = DateUtils.convertDate(onset_date5,"DMYHM",locale,"en");
	

	
	if(onset_date6!=null && !onset_date6.equals(""))
		onset_date6 = DateUtils.convertDate(onset_date6,"DMYHM",locale,"en");
	// BRU-HIMS-CRF-270
	if(onset_date7!=null && !onset_date7.equals(""))
		onset_date7 = DateUtils.convertDate(onset_date7,"DMYHM",locale,"en");
	
	if(onset_date8!=null && !onset_date8.equals(""))
		onset_date8 = DateUtils.convertDate(onset_date8,"DMYHM",locale,"en");
	// BRU-HIMS-CRF-270 END HERE
	if(collection_time1!=null && !collection_time1.equals(""))
		collection_time1 = DateUtils.convertDate(collection_time1,"DMYHM",locale,"en");
	
	
	if(collection_time2!=null && !collection_time2.equals(""))
		collection_time2 = DateUtils.convertDate(collection_time2,"DMYHM",locale,"en");
	
	
	if(collection_time3!=null && !collection_time3.equals(""))
		collection_time3 = DateUtils.convertDate(collection_time3,"DMYHM",locale,"en");
	

	
	if(collection_time4!=null && !collection_time4.equals(""))
		collection_time4 = DateUtils.convertDate(collection_time4,"DMYHM",locale,"en");
	


	if(collection_time5!=null && !collection_time5.equals(""))
		collection_time5 = DateUtils.convertDate(collection_time5,"DMYHM",locale,"en");
	

	
	if(collection_time6!=null && !collection_time6.equals(""))
		collection_time6 = DateUtils.convertDate(collection_time6,"DMYHM",locale,"en");
	
	
	if(spec_handed_over_date!=null && !spec_handed_over_date.equals(""))
		spec_handed_over_date = DateUtils.convertDate(spec_handed_over_date,"DMYHM",locale,"en");
	




	}


	public void  modifyPMstatusEndArea(HttpServletRequest req, HttpServletResponse res)
	{

		
 	try	
		{
	String pm_finding = req.getParameter("pm_finding");
	pm_finding = (pm_finding==null) ? "" :pm_finding;
	String end_date_time = req.getParameter("end_date_time");
	end_date_time = (end_date_time==null) ? "" :end_date_time;
	StringTokenizer receivetoks = new StringTokenizer (end_date_time," ") ;
	StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
	String receiveArr[] =new String[3] ;
	for( int q=0;q<3;q++ )
	receiveArr[q] = receivetok1.nextToken() ;
    end_date_time = receiveArr[0] +"/"+receiveArr[1]+"/"+ receiveArr[2]+" "+receivetoks.nextToken();
    //Timestamp receiveTimestamp= Timestamp.valueOf(end_date_time);
	session           		= req.getSession(false) ;
	out               		= res.getWriter() ;
	this.facilityId			= (String) session.getValue( "facility_id" ) ;
	this.p					= (java.util.Properties)session.getValue( "jdbc" ) ;
	this.client_ip_address	= p.getProperty("client_ip_address");
	addedById			= p.getProperty( "login_user" ) ;
	String addedDate			= dateFormat.format( new java.util.Date() ) ;
	modifiedById			= addedById ;
	modifiedDate			= addedDate ;
	String addedFacilityId		= facilityId;
	modifiedFacilityId	= addedFacilityId ;
	String addedAtWorkstation	= client_ip_address;
	modifiedAtWorkstation= addedAtWorkstation ;
	//added_date1	= java.sql.Date.valueOf( addedDate ) ;
	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
	HashMap tabdata=new HashMap();
	tabdata.put("POSTMORTEM_STATUS",pmstatus);
	tabdata.put("POSTMORTEM_FINDING",pm_finding);
	tabdata.put("POSTMORTEM_END_DATE_TIME",end_date_time);
	tabdata.put("MODIFIED_BY_ID",modifiedById);
	tabdata.put("MODIFIED_DATE",modified_date);
	tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
	tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
	tabdata.put("FACILITY_ID",facilityId);
	tabdata.put("REGISTRATION_NO",registration);

	
	
	boolean local_ejbs = false;
	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ManageDeceased",MOManageDeceasedHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[2];
	argArray[0] = p;
	argArray[1] = tabdata;
	

	Class [] paramArray = new Class[2];
	paramArray[0] = p.getClass();
	paramArray[1] = tabdata.getClass();
	

	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyPMstatusEndArea",paramArray)).invoke(busObj,argArray);
	inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

	String error = (String) results.get("error") ;
	if(error.lastIndexOf("<br>")>=0)
		 error=error.substring(0,error.lastIndexOf("<br>"));

	out.println("<script>parent.window.close();alert('"+error+"');parent.window.close();parent.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='</script>");
	
	out.println("<script> parent.window.close();alert('"+error+"');</script>");
	tabdata.clear();
	results.clear();
	}
	catch(Exception e)
	{
		 e.printStackTrace();
	} 
	finally
	 {
		  ConnectionManager.returnConnection(con,req);
	 }
}
	public void modifyPMstatusCancelArea(HttpServletRequest req, HttpServletResponse res)
	{

		
	try	
	{

	session           		= req.getSession(false) ;
	out               		= res.getWriter() ;
	this.facilityId			= (String) session.getValue( "facility_id" ) ;
	this.p					= (java.util.Properties)session.getValue( "jdbc" ) ;
	this.client_ip_address	= p.getProperty("client_ip_address");

	addedById				= p.getProperty( "login_user" ) ;
	String addedDate			= dateFormat.format( new java.util.Date() ) ;
	modifiedById			= addedById ;
	modifiedDate			= addedDate ;
	String addedFacilityId		= facilityId;
	modifiedFacilityId	= addedFacilityId ;
	String addedAtWorkstation	= client_ip_address;
	modifiedAtWorkstation= addedAtWorkstation ;

	//added_date1	= java.sql.Date.valueOf( addedDate ) ;
	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

	HashMap tabdata=new HashMap();

	tabdata.put("POSTMORTEM_STATUS",pmstatus);
	tabdata.put("MODIFIED_BY_ID",modifiedById);
	tabdata.put("MODIFIED_DATE",modified_date);
	tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
	tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
	tabdata.put("FACILITY_ID",facilityId);
	tabdata.put("REGISTRATION_NO",registration);
	boolean local_ejbs = false;

	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ManageDeceased",MOManageDeceasedHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[2];
	argArray[0] = p;
	argArray[1] = tabdata;
	

	Class [] paramArray = new Class[2];
	paramArray[0] = p.getClass();
	paramArray[1] = tabdata.getClass();
	

	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyPMstatusCancelArea",paramArray)).invoke(busObj,argArray);
	inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

	String error = (String) results.get("error") ;
	if(error.lastIndexOf("<br>")>=0)
		 error=error.substring(0,error.lastIndexOf("<br>"));
      if (inserted)
{
	if(error.lastIndexOf("<br>")>=0)
	error=error.substring(0,error.lastIndexOf("<br>"));

     out.println("<script>alert('"+error+"'); parent.window.close();</script>");

}
   tabdata.clear();
   results.clear();
				
		      
	//out.println("<script>alert('"+error+"');parent.window.close();parent.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='</script>");
	}catch(Exception e)
	{
		 e.printStackTrace();
	} 
	finally
	 {
		  ConnectionManager.returnConnection(con,req);
	 }
  }

}
 

