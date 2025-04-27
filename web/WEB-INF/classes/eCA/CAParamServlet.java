/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
11/11/2015		IN057113			Karthi L							 					ML-MMOH-CRF-0335 - IN057113
28/07/2016		IN052053		Krishna Gowtham	J											AAKH-CRF-0062
13/07/2016		IN061885		Krishna Gowtham		13/07/2017		Ramesh G				ML-MMOH-CRF-0537
01/11/2018  		IN063285     	       	prathyusha                          						ML-MMOH-CRF-0757
22/01/2018  		IN062606        	Sharanraj           	01/02/2018      	Ramesh G
15/03/2018		IN066119			Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
08/05/2018		IN066237	  	 Prakash C 			08/05/2018		Ramesh G	MMS-DM-CRF-0123
10/05/2018      IN065341        Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
11/03/2019		IN069852		Raja S			11/03/2019  Ramesh G		JD-CRF-0206
29/03/2019		IN069244		SIVABAGYAM M			29/03/2019  Ramesh G		MMS-KH-CRF-0005.1
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
29/01/2020  IN069384	SIVABAGYAM	M	29/01/2020		RAMESH G		AAKH-CRF-0097.1
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
02/06/2022	31884			Ramesh Goli			02/06/2022	Ramesh G 	MMS=DM-CRF-0208
28/10/2022  37743           SREENADH M         	01/10/2022      Ramesh G        	ML-MMOH-CRF-1654
26/05/2023  37743       RANJITH P R      29/05/2023      RAMESH G       AAKH-CRF-0164
--------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;

public class CAParamServlet extends javax.servlet.http.HttpServlet	
{

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			insertCAParam(req, res);
		} 
		catch(Exception e) 
		{
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
		}
}

private void insertCAParam(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		
		String pin_valid_req_yn 	= "";
		String errorMsg				= "";
		String error_value			= "";
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
		String auto_ref_time		= "";//IN052053
		String pend_dis_sum_grac_prd = "";//IN061885
		String finacial_dtl_req_yn="N";//added for IN063285
		int time_dur_my_ref=0;// IN062606
		String self_note_ref_time	="";// IN066237
		String centralsed_default_dayss="";//IN065341
		 
		String cln_hist_default_mode="";//IN066119
		String ackVitalsYN = "N";//IN069852
		String chartId="";//IN069244
		
		String  specimen_wise="";//IN070032
		String thirdPartyDataView="";//IN069384
		String condflds[]={};
		String hideBedNo="";//6451
		String suspInacPatYN="N";//31884
		HashMap dupflds=new HashMap();
		java.util.HashMap results = new HashMap();
		
		String chiefComplaintMandYN="N"; // 37743
		String chiefRemarksYN="N";  // 37743
		String ackthirdpartyvitalsDC_YN="N";//32411
		String ackthirdpartyvitalsEM_YN="N";//32411
		String ackthirdpartyvitalsIP_YN="N";//32411
		String ackthirdpartyvitalsOP_YN="N";//32411

		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		mode							= req.getParameter("mode") == null?"":req.getParameter("mode");
		pin_valid_req_yn				= req.getParameter("conf_pin_req_yn")==null?"":req.getParameter("conf_pin_req_yn")   ;
		auto_ref_time					= req.getParameter("sum_menu_auto_ref")  ;	//IN052053
		pend_dis_sum_grac_prd			= req.getParameter("pend_dis_summ_grace_period"); //IN061885
		finacial_dtl_req_yn				= req.getParameter("finacial_dtl_req_yn")==null?"N":req.getParameter("finacial_dtl_req_yn")   ;
		time_dur_my_ref=Integer.parseInt(req.getParameter("Time_frm_durn"))  ;	//IN062606
		cln_hist_default_mode       =req.getParameter("cln_hist_default_mode")   ;//IN066119
		self_note_ref_time				= req.getParameter("self_note_auto_ref")==null?"":req.getParameter("self_note_auto_ref");//IN066237
		centralsed_default_dayss		= req.getParameter("central_default_days")==null?"30":req.getParameter("central_default_days");//IN065341
		ackVitalsYN						= req.getParameter("ackThirdPartyVitals")==null?"N":req.getParameter("ackThirdPartyVitals");//IN069852
		chartId							= req.getParameter("THIRDPARTY_VITALS_CHART_ID")==null?"":req.getParameter("THIRDPARTY_VITALS_CHART_ID");//IN069244
		specimen_wise 				= req.getParameter("specimen_wise")==null?"S":req.getParameter("specimen_wise");//IN070032
		thirdPartyDataView 				= req.getParameter("third_party_vitals_view")==null?"T":req.getParameter("third_party_vitals_view");//IN069384
		hideBedNo=req.getParameter("bed_hide")==null?"N":req.getParameter("bed_hide");//GHL-CRF-0623
		suspInacPatYN				= req.getParameter("suspInacPatYN")==null?"N":req.getParameter("suspInacPatYN");//31884
		
		chiefComplaintMandYN=req.getParameter("chiefComplaintMandYN")==null?"N":req.getParameter("chiefComplaintMandYN");  // 37743 
		chiefRemarksYN=req.getParameter("chiefRemarksYN")==null?"N":req.getParameter("chiefRemarksYN");   // 37743 
		ackthirdpartyvitalsDC_YN=req.getParameter("ackthirdpartyvitalsDC_YN")==null?"N":req.getParameter("ackthirdpartyvitalsDC_YN");//32411
		ackthirdpartyvitalsEM_YN=req.getParameter("ackthirdpartyvitalsEM_YN")==null?"N":req.getParameter("ackthirdpartyvitalsEM_YN");//32411
		ackthirdpartyvitalsIP_YN=req.getParameter("ackthirdpartyvitalsIP_YN")==null?"N":req.getParameter("ackthirdpartyvitalsIP_YN");//32411
		ackthirdpartyvitalsOP_YN=req.getParameter("ackthirdpartyvitalsOP_YN")==null?"N":req.getParameter("ackthirdpartyvitalsOP_YN");//32411
		
		if("".equals(pin_valid_req_yn) || pin_valid_req_yn == null){
			pin_valid_req_yn = "N";
		}
		out = res.getWriter();
		
		try 
		{
					String addedById			= p.getProperty( "login_user" ) ;
					String modifiedById			= addedById ;
					String addedFacilityId		= facilityId;
					String modifiedFacilityId	= facilityId ;
					String addedAtWorkstation	= client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation ;
					
					HashMap tabdata=new HashMap();

					tabdata.put("conf_pin_req_yn",pin_valid_req_yn);
					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", addedFacilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					tabdata.put("sum_menu_auto_ref",auto_ref_time);//IN052053
					tabdata.put("PEND_DISCHRG_SUMM_DAYS",pend_dis_sum_grac_prd);//IN061885
					tabdata.put("finacial_dtl_req_yn",finacial_dtl_req_yn);//added for IN063285
					tabdata.put("TIME_DURATION_MY_REF",time_dur_my_ref);//IN062606
					tabdata.put("cln_hist_default_mode",cln_hist_default_mode);//IN066119
					tabdata.put("SELF_NOTES_AUTO_REF",self_note_ref_time);//IN066237
					tabdata.put("CENTRALSED_DEFAULT_DAYS",centralsed_default_dayss);//IN065341
					tabdata.put("ACK_THIRDPARTY_VITALS_YN",ackVitalsYN);//IN069852
					tabdata.put("THIRDPARTY_VITALS_CHART_ID",chartId);//IN069244
					tabdata.put("specimen_wise",specimen_wise);//IN070032
					tabdata.put("THIRDPARTY_VITALS_VIEW",thirdPartyDataView);//IN069384
					tabdata.put("HIDE_BED_NO_LISTBYLOCA_YN",hideBedNo);//GHL-CRF-0623
					tabdata.put("SUSP_INACT_PAT_YN",suspInacPatYN); //31884
					tabdata.put("CHIEF_COMPLAINT_MAND_YN",chiefComplaintMandYN); //37743
					tabdata.put("CHIEF_REMARKS_MAND_YN",chiefRemarksYN); //37743
					tabdata.put("ACK_THIRDPARTY_VITALS_DC_YN",ackthirdpartyvitalsDC_YN);//32411
					tabdata.put("ACK_THIRDPARTY_VITALS_EM_YN",ackthirdpartyvitalsEM_YN);//32411
			        tabdata.put("ACK_THIRDPARTY_VITALS_IP_YN",ackthirdpartyvitalsIP_YN);//32411
					tabdata.put("ACK_THIRDPARTY_VITALS_OP_YN",ackthirdpartyvitalsOP_YN);//32411
				
					
					dupflds.put("module_id","CA");
					
					boolean local_ejbs = false;
					String table_data = "CA_PARAM";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;

		if(mode.equals("insert"))
			argArray[2] = condflds;
		else  if(mode.equals("update"))
			argArray[2] = dupflds;

		argArray[3] = table_data ;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		if(mode.equals("insert"))
			paramArray[2] = condflds.getClass();
		else if (mode.equals("update"))
			paramArray[2] = dupflds.getClass();

		paramArray[3] = table_data.getClass();
		
		if(mode.equals("insert"))
				results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		else if(mode.equals("update"))
				results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			dupflds.clear();
			tabdata.clear();
			argArray = null;
			paramArray = null;

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			errorMsg = (String) results.get("error") ;
			
			results.clear();
			error_value = "0" ;
			
			if ( inserted ) 
				error_value = "1" ;
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception in Insert Block :"+e.getMessage());common-icn-0181
			//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
}
