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

import eAM.Referral.* ;
//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

public class ReferralServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;

java.util.Properties p;
//String chkStatus;
//String facilityid;
String referralCode ;
String longDesc ;
String shortDesc ;
//String longName ;
String healthCareSettingType;
String orgType;
String sourceUseAtRegnYn;
String sourceUseAtVisitYn;
String sourceUseAtAdmYn;
String destUseAtConclYn;
String destUseAtDischYn;
String addLn1;
String addLn2;
String addLn3;
String addLn4;

String addregion;
String addtown;
String addarea;

String addPostalCode;
String addCountryCode;
String telNo;
String faxNo;
String emailId;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String facilityId ;
String client_ip_address ;

//java.util.Hashtable env			;
//String serviceURL				;
//String objectName				;


String applicability_for_direct_ord	= "";
String linked_facility_id   = "";
String source_use_at_lb_ord_yn   = "";
String source_use_at_rd_ord_yn   = "";
String source_use_at_ph_ord_yn   = "";
String source_pat_prefix   = "";
String ext_pat_ser_grp_code   = "";
String contact_name    = "";
String contact_name_title   = "";
String applicability_for_tissue_coll  = "";
String source_donor_prefix   = "";
String donor_ser_grp_code   = "";




public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
				req.setCharacterEncoding("UTF-8");


	HttpSession session = req.getSession(false);	
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

	/*env		= (java.util.Hashtable) session.getValue( "env" ) ;
	serviceURL 	= (String) session.getValue( "serviceURL" ) ;
	objectName 	= "/test/ReferralManager" ;*/


	try 
	{
		this.out = res.getWriter();
		String operation = req.getParameter("function1");

		if ( operation.equals("insert") )
			insertReferral(req, res);
		if ( operation.equals("modify"))
			modifyReferral(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		e.printStackTrace();
		}
	}
public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
		req.setCharacterEncoding("UTF-8");
	this.out = res.getWriter();
	res.setContentType("text/html");
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;

	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script src='../eCommon/js/common.js' language='javascript'></script><script  language='javascript' src='../eAM/js/Referral.js'></script></head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'> </iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe></html> ");
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	}
private void modifyReferral(HttpServletRequest req, HttpServletResponse res)	{
	try {

//	facilityid=req.getParameter("facility_id");
    String change_val="";
	String longName="";

	change_val=checkForNull(req.getParameter("change_val"));
	
	referralCode = req.getParameter("referral_code");
	longDesc = req.getParameter("long_desc");
 longName = checkForNull(req.getParameter("long_name"));
	/*if (longName == null )
		longName="";*/


	shortDesc = req.getParameter("short_desc");
	
	healthCareSettingType = req.getParameter("healthcare_setting_type");
	orgType = req.getParameter("org_type");
	//chkStatus=req.getParameter("chkstatus");

	effectiveStatus = req.getParameter("eff_status");
		if ( effectiveStatus == null )
		effectiveStatus="D";

	if( healthCareSettingType.equals("Hospital"))
		healthCareSettingType="H";
	else if( healthCareSettingType.equals("Primary Health Care"))
		healthCareSettingType="P";
	else if( healthCareSettingType.equals("Others"))
		healthCareSettingType="O";
	else if( healthCareSettingType.equals("None"))
		healthCareSettingType="N";

	if(effectiveStatus.equals("D"))
	{
		sourceUseAtRegnYn=req.getParameter("source_use_at_regn_yn");
		if(sourceUseAtRegnYn == null || sourceUseAtRegnYn.equals(""))
					sourceUseAtRegnYn="N";

		sourceUseAtVisitYn=req.getParameter("source_use_at_visit_yn");
		if(sourceUseAtVisitYn == null || sourceUseAtVisitYn.equals(""))
					sourceUseAtVisitYn="N";

		sourceUseAtAdmYn=req.getParameter("source_use_at_adm_yn");
		if(sourceUseAtAdmYn == null || sourceUseAtAdmYn.equals(""))
					sourceUseAtAdmYn="N";

		destUseAtConclYn=req.getParameter("dest_use_at_concl_yn");
		if(destUseAtConclYn == null || destUseAtConclYn.equals(""))
					destUseAtConclYn="N";

		destUseAtDischYn=req.getParameter("dest_use_at_disch_yn");
		if(destUseAtDischYn == null || destUseAtDischYn.equals(""))
					destUseAtDischYn="N";

	}
	if(effectiveStatus.equals("E"))
	{
		sourceUseAtRegnYn=req.getParameter("source_use_at_regn_yn");
		if(sourceUseAtRegnYn == null)
			sourceUseAtRegnYn="N";

		sourceUseAtVisitYn=req.getParameter("source_use_at_visit_yn");
		if(sourceUseAtVisitYn == null)
			sourceUseAtVisitYn="N";

		sourceUseAtAdmYn=req.getParameter("source_use_at_adm_yn");
		if(sourceUseAtAdmYn == null)
			sourceUseAtAdmYn="N";

		destUseAtConclYn=req.getParameter("dest_use_at_concl_yn");
		if(destUseAtConclYn == null)
			destUseAtConclYn="N";

		destUseAtDischYn=req.getParameter("dest_use_at_disch_yn");
		if(destUseAtDischYn == null)
			destUseAtDischYn="N";

	}

	addLn1=checkForNull(req.getParameter("add_ln1"));
	addLn2=checkForNull(req.getParameter("add_ln2"));
	addLn3=checkForNull(req.getParameter("add_ln3"));
	addLn4=checkForNull(req.getParameter("add_ln4"));
	

	addtown=checkForNull(req.getParameter("m_town"));
	addarea=checkForNull(req.getParameter("m_area"));
	addregion=checkForNull(req.getParameter("m_region"));

	addPostalCode=req.getParameter("m_postal_code");
	if ( addPostalCode == null )		addPostalCode="";


	//addPostalCode=checkForNull(req.getParameter("add_postal_code"));
	addCountryCode=checkForNull(req.getParameter("add_country_code"));
	telNo=checkForNull(req.getParameter("tel_no"));
	faxNo=checkForNull(req.getParameter("fax_no"));
	emailId=checkForNull(req.getParameter("email_id"));
	effectiveDateFrom = checkForNull(req.getParameter("eff_date_from"));
	effectiveDateTo =checkForNull(req.getParameter("eff_date_to"));

applicability_for_direct_ord	= checkForNull(req.getParameter("applicability1"));
linked_facility_id				= checkForNull(req.getParameter("associated_ref_facility"));

source_use_at_lb_ord_yn			= checkForNull(req.getParameter("laboratory"));
if(source_use_at_lb_ord_yn.equals("") || source_use_at_lb_ord_yn == null)
	source_use_at_lb_ord_yn = "N";


source_use_at_rd_ord_yn			= checkForNull(req.getParameter("radiology"));
if(source_use_at_rd_ord_yn.equals("") || source_use_at_rd_ord_yn == null)
	source_use_at_rd_ord_yn = "N";


source_use_at_ph_ord_yn			= checkForNull(req.getParameter("pharmacy"));
if(source_use_at_ph_ord_yn.equals("") || source_use_at_ph_ord_yn == null)
	source_use_at_ph_ord_yn = "N";



source_pat_prefix				= checkForNull(req.getParameter("pat_prefix"));
ext_pat_ser_grp_code			= checkForNull(req.getParameter("patient_no"));
contact_name					= checkForNull(req.getParameter("contact_name"));
contact_name_title				= checkForNull(req.getParameter("contact_title"));
applicability_for_tissue_coll	= checkForNull(req.getParameter("applicability2"));
source_donor_prefix				= checkForNull(req.getParameter("donor_prefix"));
donor_ser_grp_code				= checkForNull(req.getParameter("donor_no"));


	

	/*InitialContext context = new InitialContext();
	Object homeObject = context.lookup("java:comp/env/ReferralManager");
	final ReferralManagerHome referralManagerHome = (ReferralManagerHome) PortableRemoteObject.narrow(homeObject ,ReferralManagerHome.class);
	final ReferralManagerRemote referralManagerRemote = referralManagerHome.create();
	final java.util.HashMap results = referralManagerRemote.updateReferral(	p,
//						facilityid, 	referralCode,
						referralCode,
						longDesc, 		shortDesc,
						healthCareSettingType, orgType,	sourceUseAtRegnYn,
						sourceUseAtVisitYn,		sourceUseAtAdmYn,
						destUseAtConclYn,		destUseAtDischYn,
						addLn1,			addLn2,
						addLn3,			addLn4,
						addPostalCode,	addCountryCode,
						telNo,			faxNo,
						emailId,		effectiveDateFrom,
						effectiveDateTo,	effectiveStatus,
						facilityId, client_ip_address,applicability_for_direct_ord	,
					linked_facility_id   ,
					source_use_at_lb_ord_yn   ,
					source_use_at_rd_ord_yn   ,
					source_use_at_ph_ord_yn   ,
					source_pat_prefix   ,
					ext_pat_ser_grp_code   ,
					contact_name    ,
					contact_name_title   ,
					applicability_for_tissue_coll  ,
					source_donor_prefix   ,
					donor_ser_grp_code ) ;*/
					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReferralManager",ReferralManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					HashMap hashmap = new HashMap();
					hashmap.put("p",p);
					hashmap.put("referralCode",referralCode);
						hashmap.put("longDesc",longDesc);
						
						hashmap.put("shortDesc",shortDesc);
					
						hashmap.put("healthCareSettingType",healthCareSettingType);
						hashmap.put("orgType",orgType);
						hashmap.put("sourceUseAtRegnYn",sourceUseAtRegnYn);
						hashmap.put("sourceUseAtVisitYn",sourceUseAtVisitYn);
						hashmap.put("sourceUseAtAdmYn",sourceUseAtAdmYn);

						hashmap.put("destUseAtConclYn",destUseAtConclYn);
						hashmap.put("destUseAtDischYn",destUseAtDischYn);
						hashmap.put("addLn1",addLn1);
						hashmap.put("addLn2",addLn2);
						hashmap.put("addLn3",addLn3);
						hashmap.put("addLn4",addLn4);

						hashmap.put("addtown",addtown);
						hashmap.put("addarea",addarea);
						hashmap.put("addregion",addregion);

						hashmap.put("addPostalCode",addPostalCode);
						hashmap.put("addCountryCode",addCountryCode);

						hashmap.put("telNo",telNo);
						hashmap.put("faxNo",faxNo);
						hashmap.put("emailId",emailId);
						hashmap.put("effectiveDateFrom",effectiveDateFrom);
						hashmap.put("effectiveDateTo",effectiveDateTo);
						hashmap.put("effectiveStatus",effectiveStatus);
						hashmap.put("addedFacilityId",facilityId);
						hashmap.put("addedAtWorkstation",client_ip_address);
						hashmap.put("applicability_for_direct_ord",applicability_for_direct_ord);
						hashmap.put("linked_facility_id",linked_facility_id);
						hashmap.put("source_use_at_lb_ord_yn",source_use_at_lb_ord_yn);
						hashmap.put("source_use_at_rd_ord_yn",source_use_at_rd_ord_yn);
						hashmap.put("source_use_at_ph_ord_yn",source_use_at_ph_ord_yn);
						hashmap.put("source_pat_prefix",source_pat_prefix);
						hashmap.put("ext_pat_ser_grp_code",ext_pat_ser_grp_code);
						hashmap.put("contact_name",contact_name);
						hashmap.put("contact_name_title",contact_name_title);
						hashmap.put("applicability_for_tissue_coll",applicability_for_tissue_coll);
						hashmap.put("source_donor_prefix",source_donor_prefix);
						hashmap.put("donor_ser_grp_code",donor_ser_grp_code);
						hashmap.put("change_val",change_val);
						hashmap.put("longName",longName);
						
						
					
					
					Object argArray[] = new Object[1];
							
							argArray[0]=hashmap;
							
						

					Class [] paramArray = new Class[1];
						paramArray[0] = hashmap.getClass();


				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateReferral",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
        String error = (String) results.get("error") ;
		String error_value = "0" ;
		if ( inserted )
		{
			error_value = "1" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
		}
		hashmap.clear();
	    results.clear();

		} catch ( Exception e ) 
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(" addCountryCode "+addCountryCode);
			e.printStackTrace() ;

		}
	}


private void insertReferral(HttpServletRequest req, HttpServletResponse res)	
{
	try
	{

	//facilityid=req.getParameter("facility_id");

	referralCode = req.getParameter("referral_code");
	longDesc = req.getParameter("long_desc");
	shortDesc = req.getParameter("short_desc");
	String longName = checkForNull(req.getParameter("long_name"));
	/*if ( longName == null )
		longName="";*/
	healthCareSettingType = req.getParameter("healthcare_setting_type");

	if( healthCareSettingType.equals("Hospital"))
			healthCareSettingType="H";
		else if( healthCareSettingType.equals("Primary Health Care"))
			healthCareSettingType="P";
		else if( healthCareSettingType.equals("Others"))
			healthCareSettingType="O";
		else if( healthCareSettingType.equals("None"))
			healthCareSettingType="N";

	orgType = req.getParameter("org_type");
	sourceUseAtRegnYn=req.getParameter("source_use_at_regn_yn");
	if(sourceUseAtRegnYn == null)
		sourceUseAtRegnYn="N";

	sourceUseAtVisitYn=req.getParameter("source_use_at_visit_yn");
	if(sourceUseAtVisitYn == null)
		sourceUseAtVisitYn="N";

	sourceUseAtAdmYn=req.getParameter("source_use_at_adm_yn");
	if(sourceUseAtAdmYn == null)
		sourceUseAtAdmYn="N";

	destUseAtConclYn=req.getParameter("dest_use_at_concl_yn");
	if(destUseAtConclYn == null)
		destUseAtConclYn="N";

	destUseAtDischYn=req.getParameter("dest_use_at_disch_yn");
	if(destUseAtDischYn == null)
		destUseAtDischYn="N";

	addLn1=req.getParameter("add_ln1");
	addLn2=req.getParameter("add_ln2");
	addLn3=req.getParameter("add_ln3");
	addLn4=req.getParameter("add_ln4");
		

	addtown=req.getParameter("m_town");
	addarea=req.getParameter("m_area");
	addregion=req.getParameter("m_region");

	addPostalCode=req.getParameter("m_postal_code");
	if ( addPostalCode == null )		addPostalCode="";

	addCountryCode=req.getParameter("add_country_code");
	telNo=req.getParameter("tel_no");
	faxNo=req.getParameter("fax_no");
	emailId=req.getParameter("email_id");
	effectiveDateFrom = req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status");
	if ( effectiveStatus == null )
		effectiveStatus="D";


	


applicability_for_direct_ord	= checkForNull(req.getParameter("applicability1"));
linked_facility_id				= checkForNull(req.getParameter("associated_ref_facility"));

source_use_at_lb_ord_yn			= checkForNull(req.getParameter("laboratory"));
if(source_use_at_lb_ord_yn.equals("") || source_use_at_lb_ord_yn == null)
	source_use_at_lb_ord_yn = "N";

source_use_at_rd_ord_yn			= checkForNull(req.getParameter("radiology"));
if(source_use_at_rd_ord_yn.equals("") || source_use_at_rd_ord_yn == null)
	source_use_at_rd_ord_yn = "N";

source_use_at_ph_ord_yn			= checkForNull(req.getParameter("pharmacy"));
if(source_use_at_ph_ord_yn.equals("") || source_use_at_ph_ord_yn == null)
	source_use_at_ph_ord_yn = "N";



source_pat_prefix				= checkForNull(req.getParameter("pat_prefix"));
ext_pat_ser_grp_code			= checkForNull(req.getParameter("patient_no"));
contact_name					= checkForNull(req.getParameter("contact_name"));
contact_name_title				= checkForNull(req.getParameter("contact_title"));
applicability_for_tissue_coll	= checkForNull(req.getParameter("applicability2"));
source_donor_prefix				= checkForNull(req.getParameter("donor_prefix"));
donor_ser_grp_code				= checkForNull(req.getParameter("donor_no"));




//InitialContext context = new InitialContext();
//Object homeObject = context.lookup("java:comp/env/ReferralManager");
//final ReferralManagerHome referralManagerHome = (ReferralManagerHome) PortableRemoteObject.narrow(homeObject ,ReferralManagerHome.class);
//final ReferralManagerRemote referralManagerRemote = referralManagerHome.create();

//final java.util.Hashtable results = referralManagerRemote.insertReferral(	p,
//						facilityid, 	referralCode,



	boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReferralManager",ReferralManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					

					HashMap hashmap = new HashMap();
					hashmap.put("p",p);
					hashmap.put("referralCode",referralCode);
						hashmap.put("longDesc",longDesc);
						hashmap.put("shortDesc",shortDesc);
						hashmap.put("healthCareSettingType",healthCareSettingType);
						hashmap.put("orgType",orgType);
						hashmap.put("sourceUseAtRegnYn",sourceUseAtRegnYn);
						hashmap.put("sourceUseAtVisitYn",sourceUseAtVisitYn);
						hashmap.put("sourceUseAtAdmYn",sourceUseAtAdmYn);

						hashmap.put("destUseAtConclYn",destUseAtConclYn);
						hashmap.put("destUseAtDischYn",destUseAtDischYn);
						hashmap.put("addLn1",addLn1);
						hashmap.put("addLn2",addLn2);
						hashmap.put("addLn3",addLn3);
						hashmap.put("addLn4",addLn4);

						hashmap.put("addtown",addtown);
						hashmap.put("addarea",addarea);
						hashmap.put("addregion",addregion);
						
						hashmap.put("addPostalCode",addPostalCode);
						hashmap.put("addCountryCode",addCountryCode);

						hashmap.put("telNo",telNo);
						hashmap.put("faxNo",faxNo);
						hashmap.put("emailId",emailId);
						hashmap.put("effectiveDateFrom",effectiveDateFrom);
						hashmap.put("effectiveDateTo",effectiveDateTo);
						hashmap.put("effectiveStatus",effectiveStatus);
						hashmap.put("addedFacilityId",facilityId);
						hashmap.put("addedAtWorkstation",client_ip_address);
						hashmap.put("applicability_for_direct_ord",applicability_for_direct_ord);
						hashmap.put("linked_facility_id",linked_facility_id);
						hashmap.put("source_use_at_lb_ord_yn",source_use_at_lb_ord_yn);
						hashmap.put("source_use_at_rd_ord_yn",source_use_at_rd_ord_yn);
						hashmap.put("source_use_at_ph_ord_yn",source_use_at_ph_ord_yn);
						hashmap.put("source_pat_prefix",source_pat_prefix);
						hashmap.put("ext_pat_ser_grp_code",ext_pat_ser_grp_code);
						hashmap.put("contact_name",contact_name);
						hashmap.put("contact_name_title",contact_name_title);
						hashmap.put("applicability_for_tissue_coll",applicability_for_tissue_coll);
						hashmap.put("source_donor_prefix",source_donor_prefix);
						hashmap.put("donor_ser_grp_code",donor_ser_grp_code);
						hashmap.put("longName",longName);
					
					Object argArray[] = new Object[1];
							
							argArray[0]=hashmap;
							
						

					Class [] paramArray = new Class[1];
						paramArray[0] = hashmap.getClass();



			
				

	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertReferral",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



/*	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

	if ( inserted ) {

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=AP001-Record Inserted&clear=referral_code|long_desc|short_desc|add_ln1|add_ln2|eff_date_from1|eff_date_to1" );


	} else {
		String error = (String) results.get("error") ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );
	}
*/
	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	String error = (String) results.get("error") ;
	String error_value = "0" ;

	if ( inserted ) error_value = "1" ;
	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );

	hashmap.clear();
    results.clear();

	} catch ( Exception e ) {
	out.println(e.getMessage());
	out.println(e.toString());
	e.printStackTrace();
	}

}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

}
