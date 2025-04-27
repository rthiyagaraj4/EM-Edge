/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eMP.RegPatReferral.* ;
import java.sql.* ;
import javax.naming.*;
import webbeans.eCommon.*;
import com.ehis.eslp.*;
import java.util.*;
import com.ehis.util.*;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class RegPatReferralServlet extends javax.servlet.http.HttpServlet   {

public void init(ServletConfig config) throws ServletException  {
    super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{

	HttpSession session			= null;
	String facilityId			= "";
	String operationtype		= "";
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	//Added by Kamatchi S for security issue against COMMON-ICN-0187
	req = new XSSRequestWrapper(req);
	res.addHeader("X-XSS-Protection", "1; mode=block");
	res.addHeader("X-Content-Type-Options", "nosniff");
	//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
	session						= req.getSession(false);
    facilityId					= (String)session.getValue("facility_id") ;

	try {
		 operationtype			= checkForNull(req.getParameter("operation_type"));
        
		if(operationtype.equals("insert") || operationtype.equals("RegisterMoreReferral"))
			insertRegPatReferral( req, res) ;

		else if(operationtype.equals("modify"))
			updateRegPatReferral( req, res) ;

		if(operationtype.equals("print"))
		{
			printRegPatReferral(req,res,facilityId);
		}

       }
        catch (Exception e){
      		
			e.printStackTrace();
        }
		
    }

   private void insertRegPatReferral(HttpServletRequest req, HttpServletResponse res ) throws IOException
    {
		PrintWriter out				= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		/*Below three line was commeted by Venkatesh.S,Reason is this variable not used inside this method ,while generate checkstyle report */
		/*Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;*/
		String facilityId			= "";
		String locale				= "";
		String sStyle				= "";
		String outTextStart			= "";
		String outTextEnd			= "";
		String tospecialitycode		= "";
		String toservicecode		= "";
		String referralid_insert	= "";
		String referralid_patid		= "";
		String calling_from			= "";
		String patientid			= "";
		String name_prefix_loc_lang	= "";
		String alt_id1_exp_date		= "";
		String alt_id2_exp_date		= "";
		String alt_id3_exp_date		= "";
		String alt_id4_exp_date		= "";
		String status				= "";
		String order_catalog_code   = "";
		String toreftype			= "L";
		String fromhcaresettingtype = "";
		String fromrefcode			= "";
		String hcare_type			= "";
		String fromreftype			= "";
		String frompractDesc		= "";
		String  frompractname_ext	= "";
		String regtrd_yn			= "";
		String frompractname		= "";
		String referral_date		= "";
		String preferred_date		= "";
		String received_date		= "";
		String tofacilityid			= "";
		String client_ip_address	= "";
		String referral_id			= "";
		String entitlement_by_pat_cat_yn	= "";
		out							= res.getWriter();
  	    session						= req.getSession(false);
		facilityId					= (String)session.getValue("facility_id") ;
		p							= (java.util.Properties) session.getValue("jdbc") ;
		locale						= p.getProperty("LOCALE");
		sStyle						=
	    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		/*outTextStart				= "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+
                "<BODY CLASS='MESSAGE'>";
	    
		outTextEnd					= "</body></html>";*/
		client_ip_address			= p.getProperty("client_ip_address");
		try
        {

			res.setContentType("text/html");
		    status="O";
		    
		 // code changed by PrasannaKumari Ilayaraja Edge Conversion
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callRegPatReferralHTML() { ");

			// Entitlement function calling starts here
			String refe_date=checkForNull(req.getParameter("referral_date"));
			entitlement_by_pat_cat_yn = checkForNull(req.getParameter("entitlement_by_pat_cat_yn"));
			tospecialitycode		= checkForNull(req.getParameter("to_speciality_code"));
			toservicecode			= checkForNull(req.getParameter("to_service_code"));
		    calling_from			= checkForNull(req.getParameter("calling_from"));
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc			= checkForNull(req.getParameter("smartCardFunc"));
			if(smartCardFunc.equals("01")) {
			biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends	
			String status_flag		=	entitle_ment_validation(req,patientid,refe_date,facilityId,checkForNull(req.getParameter("locationT0")),checkForNull(req.getParameter("to_locn_hid")),tospecialitycode,entitlement_by_pat_cat_yn);
			// Ends here..
			order_catalog_code		= req.getParameter("order_catalog");
			if(order_catalog_code == null) order_catalog_code="";
			tofacilityid			= facilityId;
			//fromrefcode = checkForNull(req.getParameter("referral_source"));
			fromrefcode				= checkForNull(req.getParameter("referral_source_lkp_id"));  //changed  for CRF 508

			hcare_type				= checkForNull(req.getParameter("hcare_type"));
			patientid				= checkForNull(req.getParameter("patient_id"));
			int i					= fromrefcode.indexOf("~");
			if(i>0)
			{

				fromhcaresettingtype = fromrefcode.substring(0,i);
				fromrefcode			= fromrefcode.substring(i+1,fromrefcode.length());
			}

			if(fromhcaresettingtype == null || fromhcaresettingtype.equals("null") || fromhcaresettingtype.equals(""))
			{
				fromhcaresettingtype= "";
			}
			if(fromhcaresettingtype.equals(""))
			{
				fromhcaresettingtype= hcare_type;
			}

			fromreftype				= checkForNull(req.getParameter("referral_type"));

			/*	if (fromreftype.equals("X"))
			frompractname = checkForNull(req.getParameter("from_practitioner_id"));
			else
			frompractname = checkForNull(req.getParameter("from_practitioner"));  */

			if(fromreftype.equals("X"))
			{
				frompractname		= checkForNull(req.getParameter("from_practitioner"));
				frompractDesc		= checkForNull(req.getParameter("from_practitioner_id"));
				frompractname_ext	= checkForNull(req.getParameter("from_ext_practitioner_id"));
				if(frompractDesc.equals("")) 
				{
					frompractname   = frompractname_ext; 
					regtrd_yn		= "N"; 						
				}else{
					regtrd_yn		= "Y"; 
				}
					
				  
			}else{
				frompractname		= checkForNull(req.getParameter("from_practitioner")); 			         

			}
			referral_id				= checkForNull(req.getParameter("referral_id"));
			if(status_flag.equals("0"))
			{

			HashMap tabdata = new HashMap();
			tabdata.put("facilityId",facilityId);
			tabdata.put("client_ip_address",client_ip_address);
			tabdata.put("referral_id",referral_id);

			referral_date=checkForNull(req.getParameter("referral_date"));
			preferred_date=checkForNull(req.getParameter("preferred_date"));
			received_date=checkForNull(req.getParameter("received_date"));

			if(!locale.equals("en"))
			{
				if(!referral_date.equals(""))
				referral_date= DateUtils.convertDate(referral_date,"DMYHM",locale,"en");
				if(!preferred_date.equals(""))
				preferred_date= DateUtils.convertDate(preferred_date,"DMY",locale,"en");
				if(!received_date.equals(""))
				received_date= DateUtils.convertDate(received_date,"DMYHM",locale,"en");
			}
			tabdata.put("referraldate",referral_date);
			tabdata.put("referralletterno",checkForNull(req.getParameter("ref_letter_no")));
			tabdata.put("preferredtreatmentdate",preferred_date);
			tabdata.put("receiveddate",received_date);
			tabdata.put("fromreftype",fromreftype);
			tabdata.put("fromrefcode",fromrefcode);
			tabdata.put("fromhcaresettingtype",fromhcaresettingtype);
			tabdata.put("fromlocntype",checkForNull(req.getParameter("location0")));
			tabdata.put("fromlocndesc",checkForNull(req.getParameter("from_locn_hid")));
			tabdata.put("frompractname",frompractname);
			tabdata.put("from_speciality_code",checkForNull(req.getParameter("speciality")));
			tabdata.put("toreftype",toreftype);
			tabdata.put("tofacilityid",tofacilityid);
			tabdata.put("tohcaresettingtype",checkForNull(req.getParameter("to_hcare_setting_type_code")));
			tabdata.put("tospecialitycode",tospecialitycode);
			tabdata.put("tolocationtype",checkForNull(req.getParameter("locationT0")));
			tabdata.put("tolocationcode",checkForNull(req.getParameter("to_locn_hid")));
			tabdata.put("toservicecode",toservicecode);
			tabdata.put("topractid",checkForNull(req.getParameter("to_practitioner")));
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("patientid",patientid);
			tabdata.put("nameprefix",checkForNull(req.getParameter("name_prefix1")));
			tabdata.put("firstname",checkForNull(req.getParameter("first_name")));
			tabdata.put("secondname",checkForNull(req.getParameter("second_name")));
			tabdata.put("thirdname",checkForNull(req.getParameter("third_name")));
			tabdata.put("familyname",checkForNull(req.getParameter("family_name")));
			tabdata.put("namesuffix",checkForNull(req.getParameter("name_suffix1")));
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			tabdata.put("smartCardFunc",checkForNull(req.getParameter("smartCardFunc")));
			tabdata.put("biometric_reason",checkForNull(req.getParameter("biometric_reason")));
			//Ends
			String patient_name=checkForNull(req.getParameter("patient_name"));
			if(patient_name !=null && patient_name.length()>100){
				patient_name=patient_name.substring(0,100);
			}
			tabdata.put("patientname",patient_name);
			
			tabdata.put("sex",checkForNull(req.getParameter("sex")));
			String date_of_birth = checkForNull(req.getParameter("date_of_birth"));
			if (!date_of_birth.equals("") )
			{
				if (!locale.equals("en"))
				{
					date_of_birth = DateUtils.convertDate(date_of_birth,"DMY",locale,"en");
				}
			}

			String patient_name_long=checkForNull(req.getParameter("patient_name_long"));
			if(patient_name_long !=null && patient_name_long.length()>300){
				patient_name_long=patient_name_long.substring(0,300);
			}

			String patient_name_loc_lang_long=checkForNull(req.getParameter("patient_name_loc_lang_long"));
			if(patient_name_loc_lang_long !=null && patient_name_loc_lang_long.length()>300){
				patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
			}
	
			tabdata.put("patient_name_long",patient_name_long);
			tabdata.put("patient_name_loc_lang_long",patient_name_loc_lang_long);

			tabdata.put("dateofbirth",date_of_birth);
			tabdata.put("nationalitycode",checkForNull(req.getParameter("nationality_code1")));
			tabdata.put("priority",checkForNull(req.getParameter("priority")));
			
			tabdata.put("refnotes",checkForNull(req.getParameter("referral_notes")));
			
			tabdata.put("status",status);
			tabdata.put("currentyear",checkForNull(req.getParameter("current_year")));
			tabdata.put("b_days",checkForNull(req.getParameter("b_days")));
			tabdata.put("b_month",checkForNull(req.getParameter("b_month")));
			tabdata.put("b_age",checkForNull(req.getParameter("b_age")));
			tabdata.put("national_id_no",checkForNull(req.getParameter("national_id_no")));
			tabdata.put("alt_id1_no",checkForNull(req.getParameter("alt_id1_no")));
			tabdata.put("alt_id2_no",checkForNull(req.getParameter("alt_id2_no")));
			tabdata.put("alt_id3_no",checkForNull(req.getParameter("alt_id3_no")));
			tabdata.put("alt_id4_no",checkForNull(req.getParameter("alt_id4_no")));

			alt_id1_exp_date=checkForNull(req.getParameter("alt_id1_exp_date"));
			alt_id2_exp_date=checkForNull(req.getParameter("alt_id2_exp_date"));
			alt_id3_exp_date=checkForNull(req.getParameter("alt_id3_exp_date"));
			alt_id4_exp_date=checkForNull(req.getParameter("alt_id4_exp_date"));

			if(!alt_id1_exp_date.equals(""))
			{
				alt_id1_exp_date= DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");
			}
			if(!alt_id2_exp_date.equals(""))
			{
				alt_id2_exp_date= DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");
			}
			if(!alt_id3_exp_date.equals(""))
			{
				alt_id3_exp_date= DateUtils.convertDate(alt_id3_exp_date,"DMY",locale,"en");
			}
			if(!alt_id4_exp_date.equals(""))
			{
				alt_id4_exp_date= DateUtils.convertDate(alt_id4_exp_date,"DMY",locale,"en");
			}



			tabdata.put("alt_id1_exp_date",alt_id1_exp_date);
			tabdata.put("alt_id2_exp_date",alt_id2_exp_date);
			tabdata.put("alt_id3_exp_date",alt_id3_exp_date);
			tabdata.put("alt_id4_exp_date",alt_id4_exp_date);
			tabdata.put("other_alt_type",checkForNull(req.getParameter("other_alt_type")));
			tabdata.put("other_alt_Id",checkForNull(req.getParameter("other_alt_Id")));
			tabdata.put("addr_line1",checkForNull(req.getParameter("addr_line1")));
			tabdata.put("addr_line2",checkForNull(req.getParameter("addr_line2")));
			tabdata.put("addr_line3",checkForNull(req.getParameter("addr_line3")));
			tabdata.put("addr_line4",checkForNull(req.getParameter("addr_line4")));
			tabdata.put("res_town_code",checkForNull(req.getParameter("res_town_code")));
			tabdata.put("res_area_code",checkForNull(req.getParameter("res_area_code")));
			tabdata.put("country_code",checkForNull(req.getParameter("country_code")));
			tabdata.put("postal_code",checkForNull(req.getParameter("postal_code")));
			tabdata.put("mail_addr_line1",checkForNull(req.getParameter("mail_addr_line1")));
			tabdata.put("mail_addr_line2",checkForNull(req.getParameter("mail_addr_line2")));
			tabdata.put("mail_addr_line3",checkForNull(req.getParameter("mail_addr_line3")));
			tabdata.put("mail_addr_line4",checkForNull(req.getParameter("mail_addr_line4")));
			tabdata.put("mail_res_town_code",checkForNull(req.getParameter("mail_res_town_code")));
			tabdata.put("mail_res_area_code",checkForNull(req.getParameter("mail_res_area_code")));
			tabdata.put("mail_country_code",checkForNull(req.getParameter("mail_country_code")));
			tabdata.put("mail_postal_code",checkForNull(req.getParameter("mail_postal_code")));
			tabdata.put("mail_region_code",checkForNull(req.getParameter("mail_region_code")));
			tabdata.put("contact1_no",checkForNull(req.getParameter("contact1_no")));
			tabdata.put("contact2_no",checkForNull(req.getParameter("contact2_no")));
			tabdata.put("email",checkForNull(req.getParameter("email")));
			tabdata.put("tel_no",checkForNull(req.getParameter("tel_no")));
			tabdata.put("mobile_no",checkForNull(req.getParameter("mobile_no")));
			tabdata.put("pager_no",checkForNull(req.getParameter("pager_no")));
			tabdata.put("referral_reason_code",checkForNull(req.getParameter("referral_reason_code")));
			tabdata.put("other_doc_att",checkForNull(req.getParameter("other_doc_att")));
			tabdata.put("exm_clinical_find",checkForNull(req.getParameter("exm_clinical_find")));
			tabdata.put("diagnosis",checkForNull(req.getParameter("diagnosis")));
			tabdata.put("treatment",checkForNull(req.getParameter("treatment")));
			tabdata.put("race_code",checkForNull(req.getParameter("race_code")));
			tabdata.put("citizen_yn",checkForNull(req.getParameter("citizenvalue")));
			
			
			tabdata.put("legal_yn",checkForNull(req.getParameter("illegalvalue")));
			tabdata.put("region_code",checkForNull(req.getParameter("region_code")));
			tabdata.put("referred_for_ip",checkForNull(req.getParameter("referred_for_ip")));
			tabdata.put("Birth_place_code",checkForNull(req.getParameter("Birth_place_code")));
			tabdata.put("birth_place_desc",checkForNull(req.getParameter("place_of_birth")));
			tabdata.put("ethnic_grp_code",checkForNull(req.getParameter("race_code1")));

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			tabdata.put("altAddrLine1",checkForNull(req.getParameter("alt_addr_line1")));
			tabdata.put("altAddrLine2",checkForNull(req.getParameter("alt_addr_line2")));
			tabdata.put("altAddrLine3",checkForNull(req.getParameter("alt_addr_line3")));
			tabdata.put("altAddrLine4",checkForNull(req.getParameter("alt_addr_line4")));
			tabdata.put("altTownCode",checkForNull(req.getParameter("alt_town_code")));
			tabdata.put("altAreaCode",checkForNull(req.getParameter("alt_area_code")));
			tabdata.put("altRegionCode",checkForNull(req.getParameter("alt_region_code")));
			tabdata.put("altPostalCode",checkForNull(req.getParameter("alt_postal_code")));
			tabdata.put("altCountryCode",checkForNull(req.getParameter("alt_country_code")));
			tabdata.put("transfer_case_yn",req.getParameter("transfer_case_yn")==null?"N":req.getParameter("transfer_case_yn")); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
			
			/*End*/

			tabdata.put("family_name_loc_lang",checkForNull(req.getParameter("family_name_oth_lang")));
			tabdata.put("third_name_loc_lang",checkForNull(req.getParameter("third_name_oth_lang")));
			tabdata.put("second_name_loc_lang",checkForNull(req.getParameter("second_name_oth_lang")));
			tabdata.put("first_name_loc_lang",checkForNull(req.getParameter("first_name_oth_lang")));

			name_prefix_loc_lang=checkForNull(req.getParameter("name_prefix_oth_lang"));

		/*	if(!name_prefix_loc_lang.equals(""))
            {
                StringTokenizer stringtokenizer1 = new StringTokenizer(name_prefix_loc_lang, "$");
                if(stringtokenizer1.hasMoreTokens())
                    name_prefix_loc_lang = stringtokenizer1.nextToken();
            }*/

			tabdata.put("name_prefix_loc_lang",name_prefix_loc_lang);
			tabdata.put("name_suffix_loc_lang",checkForNull(req.getParameter("name_suffix_oth_lang")));
			String patient_name_local_lang=checkForNull(req.getParameter("patient_name_local_lang"));
			if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
				patient_name_local_lang=patient_name_local_lang.substring(0,100);
			}
			tabdata.put("patient_name_loc_lang",patient_name_local_lang);
			tabdata.put("regtrd_yn",regtrd_yn);



			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RegPatReferral",RegPatReferralHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertRegPatReferral",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			out.println(outTextStart);
			String queryString = (String) session.getValue( "queryString" ) ;
			if ( queryString == null ) queryString = "" ;

			//out.println( "<script language='JavaScript'>if(parent.commontoolbarFrame) parent.commontoolbarFrame.location.href='../eCommon/jsp/commonToolbar.jsp?" + queryString + "&home_required_yn=Y';</script>" ) ;
		
			if(inserted)
			{
				referralid_insert = (String) results.get("referralid") ;
				doOnlineReports(req,res,referralid_insert,sStyle,locale,patientid);
				error_value="1";
				 
				/*Introduced the below code for IN023145 by Suresh M on 09-08-2010*/ 

				if(!patientid.equals(null) || !patientid.equals(""))
					referralid_patid = referralid_insert+"%"+patientid;
				/*Code Ends*/

				if (calling_from.equals("SEARCH"))
				{
					
				 out.println("alert('"+error.substring(0,error.length())+" "+referralid_insert+"');");
				 out.println("if(top.window.document.getElementById('dialog-body')){");
				 out.println("	top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = '"+referralid_patid+"';");
				 out.println("top.window.document.querySelectorAll('#dialog_tag')[top.window.document.querySelectorAll('#dialog_tag').length-1].close();}");
				 out.println("else {");
				 out.println("parent.document.getElementById('dialog-body').contentWindow.returnValue = '"+referralid_patid+"';");
				 out.println("parent.document.getElementById('dialog_tag').close();}  ");
				}
				else
				{
					System.out.println(error);
					//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
					//out.println("var msg='" + error.substring(0, error.length()) + "'<B>&nbsp;<FONT SIZE=4>" + referralid_insert + "</FONT></B>");
					out.println("var msg='" + error.substring(0, error.length()) + "' + '<B>&nbsp;<FONT SIZE=4>' + '" + referralid_insert + "' + '</FONT></B>';");
				out.println("parent.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);");
				out.println("parent.f_query_add_mod.onSuccess('"+referralid_insert+"','"+toservicecode+"','"+tospecialitycode+"');");
				}
			}
			else{
				out.println("error"+error);
				}
				argArray = null;
				paramArray = null;
				tabdata.clear();
				results.clear();
			}else if(status_flag.equals("1"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
		 		String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("2"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("3"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("4"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}

			out.println("} callRegPatReferralHTML();</script><body></body></html>");
        } catch ( Exception e ) {
            /*out.println(outTextStart);
            out.println("Exception in insertRegPatReferral "+e.toString());
			out.println(outTextEnd);*/
			e.printStackTrace();
        }
    }


  private void updateRegPatReferral(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
       PrintWriter out				= null;
	   java.util.Properties p		= null;
	   HttpSession session			= null;
	   session						= req.getSession(false);
	   p							= (java.util.Properties) session.getValue( "jdbc" ) ;
	   out							= res.getWriter();
	   String outTextStart			= "";
	   String outTextEnd			= "";
	   String locale				= "";
	   String patientid				= "";
	   String calling_from			= "";
	   String referral_id			= "";
	   String sStyle				= "";
	   String status				= "";
	   String facilityId			= "";
	   String client_ip_address		= "";
	   String tospecialitycode		= "";
	   String referral_date			= "";
	   String preferred_date		= "";
	   String received_date			= "";
	   String fromreftype			= "";
	   String fromrefcode			= "";
	   String fromhcaresettingtype	= "";
	   String frompractname			= "";
	   String frompractDesc			= "";
	   String frompractname_ext		= "";
	   String regtrd_yn				= "";
	   String tofacilityid			= "";
	   String toservicecode			= "";
	   String order_catalog_code	= "";
	   String toreftype				= "L";
	   String action				= "";
	   String reason_code			= "";
	   String remarks				= "";
	   String apptNo				= "";
	   String name_prefix_loc_lang	= "";
	   String entitlement_by_pat_cat_yn	= "";
	   		String hcare_type			= "";
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";

	   locale						= p.getProperty("LOCALE");
	   facilityId					= (String)session.getValue("facility_id") ;
	   sStyle						=
	    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  
		patientid					= checkForNull(req.getParameter("patient_id"));
		calling_from				= checkForNull(req.getParameter("calling_from"));
		referral_id					= checkForNull(req.getParameter("referral_id"));
		client_ip_address			= p.getProperty("client_ip_address");
		tospecialitycode			= checkForNull(req.getParameter("to_speciality_code"));
		toservicecode				= checkForNull(req.getParameter("to_service_code"));
		fromreftype					= checkForNull(req.getParameter("referral_type"));
		fromrefcode					= checkForNull(req.getParameter("referral_source_lkp_id"));
		order_catalog_code			= req.getParameter("order_catalog");
		action						= req.getParameter("action");
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		smartCardFunc			= checkForNull(req.getParameter("smartCardFunc"));
		if(smartCardFunc.equals("01")) {
		biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
		session.removeAttribute("biometric_reason");
		}
		//Ends	
		if(action == null) action ="";

		reason_code					= req.getParameter("reason_code");
		if(reason_code == null) reason_code="";

		remarks						= req.getParameter("remarks");
			 if(remarks == null) remarks="";

		apptNo						= req.getParameter("apptNo");
		if(apptNo == null) apptNo="";

		tofacilityid				= facilityId;
	   try
       {
			
			res.setContentType("text/html");
			if(action.equals("RR"))
			status="X";
			else
			status="O";
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callRegPatReferralHTML() { ");
			// Entitlement function calling starts here
			String refe_date		= checkForNull(req.getParameter("referral_date"));
			entitlement_by_pat_cat_yn = checkForNull(req.getParameter("entitlement_by_pat_cat_yn"));
			String status_flag		=	entitle_ment_validation(req,patientid,refe_date,facilityId,checkForNull(req.getParameter("locationT0")),checkForNull(req.getParameter("to_locn_hid")),tospecialitycode,entitlement_by_pat_cat_yn);

			// Ends here..

			int i					= fromrefcode.indexOf("~");
			if(i>0)
			{

				fromhcaresettingtype = fromrefcode.substring(0,i);
				fromrefcode			= fromrefcode.substring(i+1,fromrefcode.length());
			}

			/*Added By Dharma Start*/
			hcare_type				= checkForNull(req.getParameter("hcare_type"));

			if(fromhcaresettingtype == null || fromhcaresettingtype.equals("null") || fromhcaresettingtype.equals(""))
			{
				fromhcaresettingtype= "";
			}
			if(fromhcaresettingtype.equals(""))
			{
				fromhcaresettingtype= hcare_type;
			}
			/*Added By Dharma End*/


			if(fromreftype.equals("X"))
			{
				frompractname		= checkForNull(req.getParameter("from_practitioner"));
				frompractDesc		= checkForNull(req.getParameter("from_practitioner_id"));
				frompractname_ext	= checkForNull(req.getParameter("from_ext_practitioner_id"));
				if(frompractDesc.equals("")) 
				{
					frompractname   = frompractname_ext; 
					regtrd_yn		= "N"; 						
				}else{
					regtrd_yn		= "Y"; 
				}
					
				  
			}else{
				frompractname		= checkForNull(req.getParameter("from_practitioner")); 			         

			}

			if(status_flag.equals("0"))
			{
			HashMap tabdata = new HashMap();
			tabdata.put("facilityId",facilityId);
			tabdata.put("client_ip_address",client_ip_address);
			tabdata.put("referral_id",referral_id);
			//tabdata.put("referraldate",checkForNull(req.getParameter("referral_date")));
			referral_date=checkForNull(req.getParameter("referral_date"));
			if(!locale.equals("en"))
			{
			if(!referral_date.equals(""))
				referral_date= DateUtils.convertDate(referral_date,"DMYHM",locale,"en");
			}
	        tabdata.put("referraldate",referral_date); tabdata.put("referralletterno",checkForNull(req.getParameter("ref_letter_no")));
			//tabdata.put("preferredtreatmentdate",checkForNull(req.getParameter("preferred_date")));
			preferred_date=checkForNull(req.getParameter("preferred_date"));
            if(!locale.equals("en"))
			{
			if(!preferred_date.equals(""))
				preferred_date= DateUtils.convertDate(preferred_date,"DMY",locale,"en");
			}
		    tabdata.put("preferredtreatmentdate",preferred_date);
			//tabdata.put("receiveddate",checkForNull(req.getParameter("received_date")));
			received_date=checkForNull(req.getParameter("received_date"));
			if(!locale.equals("en"))
			{
			if(!received_date.equals(""))
				received_date= DateUtils.convertDate(received_date,"DMYHM",locale,"en");
			}
            tabdata.put("receiveddate",received_date);
			tabdata.put("fromreftype",fromreftype);
			tabdata.put("fromrefcode",fromrefcode);
			tabdata.put("fromhcaresettingtype",fromhcaresettingtype);
			tabdata.put("fromlocntype",checkForNull(req.getParameter("location0")));
			tabdata.put("fromlocndesc",checkForNull(req.getParameter("from_locn_hid")));
			tabdata.put("frompractname",frompractname);
			tabdata.put("from_speciality_code",checkForNull(req.getParameter("speciality")));
			tabdata.put("toreftype",toreftype);
			tabdata.put("tofacilityid",tofacilityid);
			tabdata.put("tohcaresettingtype",checkForNull(req.getParameter("to_hcare_setting_type_code")));
			tabdata.put("tospecialitycode",tospecialitycode);
			tabdata.put("tolocationtype",checkForNull(req.getParameter("locationT0")));
			tabdata.put("tolocationcode",checkForNull(req.getParameter("to_locn_hid")));
			tabdata.put("toservicecode",toservicecode);
			tabdata.put("topractid",checkForNull(req.getParameter("to_practitioner")));
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("reason_code",reason_code);
			tabdata.put("remarks",remarks);
			tabdata.put("apptNo",apptNo);
			tabdata.put("action",action);
			tabdata.put("patientid",patientid);
			tabdata.put("nameprefix",checkForNull(req.getParameter("name_prefix1")));
			tabdata.put("firstname",checkForNull(req.getParameter("first_name")));
			tabdata.put("secondname",checkForNull(req.getParameter("second_name")));
			tabdata.put("thirdname",checkForNull(req.getParameter("third_name")));
			tabdata.put("familyname",checkForNull(req.getParameter("family_name")));
			tabdata.put("namesuffix",checkForNull(req.getParameter("name_suffix1")));
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			tabdata.put("smartCardFunc",checkForNull(req.getParameter("smartCardFunc")));
			tabdata.put("biometric_reason",checkForNull(req.getParameter("biometric_reason")));
			//Ends
			String patient_name=checkForNull(req.getParameter("patient_name"));
			if(patient_name !=null && patient_name.length()>100){
				patient_name=patient_name.substring(0,100);
			}

			String patient_name_long=checkForNull(req.getParameter("patient_name_long"));
			if(patient_name_long !=null && patient_name_long.length()>300){
				patient_name_long=patient_name_long.substring(0,300);
			}

			String patient_name_loc_lang_long=checkForNull(req.getParameter("patient_name_loc_lang_long"));
			if(patient_name_loc_lang_long !=null && patient_name_loc_lang_long.length()>300){
				patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
			}
	
			tabdata.put("patientname",patient_name);
			tabdata.put("patient_name_long",patient_name_long);
			tabdata.put("patient_name_loc_lang_long",patient_name_loc_lang_long);
			tabdata.put("sex",checkForNull(req.getParameter("sex")));
			String date_of_birth = checkForNull(req.getParameter("date_of_birth"));
			if (!date_of_birth.equals("") )
			{
				if (!locale.equals("en"))
				{
					date_of_birth = DateUtils.convertDate(date_of_birth,"DMY",locale,"en");
				}
			}
			tabdata.put("dateofbirth",date_of_birth);
			tabdata.put("nationalitycode",checkForNull(req.getParameter("nationality_code1")));
			tabdata.put("priority",checkForNull(req.getParameter("priority")));
			
			tabdata.put("refnotes",checkForNull(req.getParameter("referral_notes")));
			tabdata.put("status",status);
			tabdata.put("currentyear",checkForNull(req.getParameter("current_year")));
			tabdata.put("b_days",checkForNull(req.getParameter("b_days")));
			tabdata.put("b_month",checkForNull(req.getParameter("b_month")));
			tabdata.put("b_age",checkForNull(req.getParameter("b_age")));
			tabdata.put("national_id_no",checkForNull(req.getParameter("national_id_no")));
			tabdata.put("alt_id1_no",checkForNull(req.getParameter("alt_id1_no")));
			tabdata.put("alt_id2_no",checkForNull(req.getParameter("alt_id2_no")));
			tabdata.put("alt_id3_no",checkForNull(req.getParameter("alt_id3_no")));
			tabdata.put("alt_id4_no",checkForNull(req.getParameter("alt_id4_no")));
			tabdata.put("alt_id1_exp_date",checkForNull(req.getParameter("alt_id1_exp_date")));
			tabdata.put("alt_id2_exp_date",checkForNull(req.getParameter("alt_id2_exp_date")));
			tabdata.put("alt_id3_exp_date",checkForNull(req.getParameter("alt_id3_exp_date")));
			tabdata.put("alt_id4_exp_date",checkForNull(req.getParameter("alt_id4_exp_date")));
			tabdata.put("other_alt_type",checkForNull(req.getParameter("other_alt_type")));
			tabdata.put("other_alt_Id",checkForNull(req.getParameter("other_alt_Id")));
			tabdata.put("addr_line1",checkForNull(req.getParameter("addr_line1")));
			tabdata.put("addr_line2",checkForNull(req.getParameter("addr_line2")));
			tabdata.put("addr_line3",checkForNull(req.getParameter("addr_line3")));
			tabdata.put("addr_line4",checkForNull(req.getParameter("addr_line4")));
			tabdata.put("res_town_code",checkForNull(req.getParameter("res_town_code")));
			tabdata.put("res_area_code",checkForNull(req.getParameter("res_area_code")));
			tabdata.put("country_code",checkForNull(req.getParameter("country_code")));
			tabdata.put("postal_code",checkForNull(req.getParameter("postal_code")));
			tabdata.put("mail_addr_line1",checkForNull(req.getParameter("mail_addr_line1")));
			tabdata.put("mail_addr_line2",checkForNull(req.getParameter("mail_addr_line2")));
			tabdata.put("mail_addr_line3",checkForNull(req.getParameter("mail_addr_line3")));
			tabdata.put("mail_addr_line4",checkForNull(req.getParameter("mail_addr_line4")));
			tabdata.put("mail_res_town_code",checkForNull(req.getParameter("mail_res_town_code")));
			tabdata.put("mail_res_area_code",checkForNull(req.getParameter("mail_res_area_code")));
			tabdata.put("mail_country_code",checkForNull(req.getParameter("mail_country_code")));
			tabdata.put("mail_postal_code",checkForNull(req.getParameter("mail_postal_code")));
			tabdata.put("mail_region_code",checkForNull(req.getParameter("mail_region_code")));
			tabdata.put("contact1_no",checkForNull(req.getParameter("contact1_no")));
			tabdata.put("contact2_no",checkForNull(req.getParameter("contact2_no")));
			tabdata.put("email",checkForNull(req.getParameter("email")));
			tabdata.put("tel_no",checkForNull(req.getParameter("tel_no")));
			tabdata.put("mobile_no",checkForNull(req.getParameter("mobile_no")));
			tabdata.put("pager_no",checkForNull(req.getParameter("pager_no")));
			tabdata.put("referral_reason_code",checkForNull(req.getParameter("referral_reason_code")));
			tabdata.put("other_doc_att",checkForNull(req.getParameter("other_doc_att")));
			tabdata.put("exm_clinical_find",checkForNull(req.getParameter("exm_clinical_find")));
			tabdata.put("diagnosis",checkForNull(req.getParameter("diagnosis")));
			tabdata.put("treatment",checkForNull(req.getParameter("treatment")));
			tabdata.put("race_code",checkForNull(req.getParameter("race_code")));
			tabdata.put("citizen_yn",checkForNull(req.getParameter("citizenvalue")));
		
			
			tabdata.put("legal_yn",checkForNull(req.getParameter("illegalvalue")));
			tabdata.put("region_code",checkForNull(req.getParameter("region_code")));
			tabdata.put("referred_for_ip",checkForNull(req.getParameter("referred_for_ip")));
			tabdata.put("Birth_place_code",checkForNull(req.getParameter("Birth_place_code")));
			tabdata.put("birth_place_desc",checkForNull(req.getParameter("place_of_birth")));
			tabdata.put("ethnic_grp_code",checkForNull(req.getParameter("race_code1")));
			tabdata.put("family_name_loc_lang",checkForNull(req.getParameter("family_name_oth_lang")));
			tabdata.put("third_name_loc_lang",checkForNull(req.getParameter("third_name_oth_lang")));
			tabdata.put("second_name_loc_lang",checkForNull(req.getParameter("second_name_oth_lang")));
			tabdata.put("first_name_loc_lang",checkForNull(req.getParameter("first_name_oth_lang")));
			name_prefix_loc_lang=checkForNull(req.getParameter("name_prefix_oth_lang"));

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			tabdata.put("altAddrLine1",checkForNull(req.getParameter("alt_addr_line1")));
			tabdata.put("altAddrLine2",checkForNull(req.getParameter("alt_addr_line2")));
			tabdata.put("altAddrLine3",checkForNull(req.getParameter("alt_addr_line3")));
			tabdata.put("altAddrLine4",checkForNull(req.getParameter("alt_addr_line4")));
			tabdata.put("altTownCode",checkForNull(req.getParameter("alt_town_code")));
			tabdata.put("altAreaCode",checkForNull(req.getParameter("alt_area_code")));
			tabdata.put("altRegionCode",checkForNull(req.getParameter("alt_region_code")));
			tabdata.put("altPostalCode",checkForNull(req.getParameter("alt_postal_code")));
			tabdata.put("altCountryCode",checkForNull(req.getParameter("alt_country_code")));
			tabdata.put("transfer_case_yn",req.getParameter("transfer_case_yn")==null?"N":req.getParameter("transfer_case_yn")); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
			
			/*End*/

			/*if(!name_prefix_loc_lang.equals(""))
            {
                StringTokenizer stringtokenizer1 = new StringTokenizer(name_prefix_loc_lang, "$");
                if(stringtokenizer1.hasMoreTokens())
                    name_prefix_loc_lang = stringtokenizer1.nextToken();
            }*/

			tabdata.put("name_prefix_loc_lang",name_prefix_loc_lang);
			tabdata.put("name_suffix_loc_lang",checkForNull(req.getParameter("name_suffix_oth_lang")));
			
			String patient_name_local_lang=checkForNull(req.getParameter("patient_name_local_lang"));
			if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
				patient_name_local_lang=patient_name_local_lang.substring(0,100);
			}
			
			tabdata.put("patient_name_loc_lang",patient_name_local_lang);
			tabdata.put("regtrd_yn",regtrd_yn);



			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RegPatReferral",RegPatReferralHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateRegPatReferral",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean updated = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			String queryString = (String) session.getValue( "queryString" ) ;
			if ( queryString == null ) queryString = "" ;

			
			out.println( "parent.commontoolbarFrame.location.href='../eCommon/jsp/commonToolbar.jsp?" + queryString + "&home_required_yn=Y';" ) ;
			
			if(updated)
			{


				//out.println( "<script language='JavaScript'>parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'</script>" ) ;
				//doOnlineReports(req,referral_id,sStyle);

				doOnlineReports(req,res,referral_id,sStyle,locale,patientid);

				error="FROM_UPDATE_REFERRAL";
				out.println("var msg=''");
				out.println("parent.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);");
				out.println("parent.f_query_add_mod.onSuccess('"+referral_id+"','','L','"+calling_from+"','"+patientid+"','"+error+"','"+error_value+"');");



			}
			else
			{
			    out.println("error"+error);
			}
			argArray = null;
			paramArray = null;
			tabdata.clear();
			results.clear();
			}else if(status_flag.equals("1"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
		 		String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("2"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("3"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}else if(status_flag.equals("4"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
 				String msg = ((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg , "UTF-8") );
				message.clear();
			}
			out.println("} callRegPatReferralHTML();</script><body></body></html>");
	   } catch ( Exception e ) {
            /*out.println(outTextStart);
            out.println("Exception in insertRegPatReferral "+e.toString());
            out.println(outTextEnd);*/
			e.printStackTrace();
        }
    }


	public void printRegPatReferral(HttpServletRequest req, HttpServletResponse res,String facilityId) throws IOException
	{
		PrintWriter out				= null;
		out							= res.getWriter();
		String appt_ref_no = req.getParameter("appt_ref_no")==null?"":req.getParameter("appt_ref_no");
		String referralid = checkForNull(req.getParameter("referral_id"));
		String locncode = req.getParameter("locn_code")==null?"":req.getParameter("locn_code");
		String locntype = req.getParameter("locn_type")==null?"":req.getParameter("locn_type");
		String reportid = req.getParameter("report_id")==null?"":req.getParameter("report_id");
		String module_id = req.getParameter("module_id")==null?"":req.getParameter("module_id");

		res.setContentType("text/html");
			try
			{
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport onlinereport    = new ecis.utils.OnlineReport( facilityId, module_id, reportid,locntype, locncode) ;
				onlinereport.addParameter( "p_referral_id", referralid ) ;
				onlinereport.addParameter( "p_facility_id", facilityId ) ;
				onlinereport.addParameter( "P_APPT_REF_NO", appt_ref_no ) ;
				onlineReports.add( onlinereport) ;
				onlineReports.execute( req, res );
			}
			catch ( Exception e )
			{
				//out.println("Encountered error while Processing Online Reports "+e.toString());
				e.printStackTrace();
			}
	}


  private void doOnlineReports(HttpServletRequest req,HttpServletResponse res, String refid,String sStylerep,String locale,String patientid) throws ServletException, IOException, SQLException
    {
		 PrintWriter out				= null;
		out								= res.getWriter();
		StringBuffer htmlFor	= new StringBuffer();
		htmlFor.setLength(0);
		String sqlString	 	= "";
		String referralid_insert= "";
		sqlString				= " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OP' AND REPORT_ID = 'OPRFLETR' AND language_id='"+locale+"'";
		String referralid		= refid;
		String p_locn_code		= req.getParameter("locn_code")==null?"":req.getParameter("locn_code");
		String locn_type		= req.getParameter("locn_type")==null?"":req.getParameter("locn_type");
		if(referralid.equals("") || referralid==null) referralid=referralid_insert;
		String p_encounter_id	= "";
		String reportParamNames = "p_referral_id";
		String reportParamValues = ""+referralid+"";
		if(patientid==null) patientid = "";
       /* htmlFor.append( " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStylerep+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append( "<script language = 'JavaScript'>") ;*/
        htmlFor.append( " var dialogHeight    = '50vh' ;");
        htmlFor.append( " var dialogWidth = '50vw' ;");
        htmlFor.append(  "var dialogTop = 65;" );
        htmlFor.append( "  var arguments =   ''; ");
        htmlFor.append( "  var retVal =   ''; ");
        htmlFor.append( "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+p_encounter_id+"&dest_locn_type="+locn_type+"&dest_locn_code="+p_locn_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patientid+"';");
        htmlFor.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append( " if(top.window.document.getElementById('dialog-body')) {");	
        htmlFor.append( " var showModalFrame = top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow.frames[0];");
        htmlFor.append( " 	retVal            =  await  showModalFrame.window.showModalDialog(getUrl,arguments,features); }");
        htmlFor.append( " else ");
        htmlFor.append( " {	retVal            =  await  window.showModalDialog(getUrl,arguments,features);}");
        //htmlFor.append("  retVal            =  await  top.window.showModalDialog(getUrl,arguments,features); return true } ");
        //htmlFor.append("   } toCallInternalReportsPrint (); </script>"  );
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public String entitle_ment_validation(HttpServletRequest req,String patientid,String refe_date,String facilityId,String to_locn_type,String to_locn_code,String tospecialitycode,String entitlement_by_pat_cat_yn)
	{
		//String entitlement_check_yn="";
		Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		String success_flag			= "0";
		/*
			try{
			pstmt=con.prepareStatement("select ENTITLEMENT_BY_PAT_CAT_YN  from mp_param" );
			rset =pstmt.executeQuery();
			if(rset != null)
			 {
				 if(rset.next())
				 {
					  entitlement_check_yn=rset.getString(1);
					  if(entitlement_check_yn == null) entitlement_check_yn="N";
				 }
			 }
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}
		*/


		if(entitlement_by_pat_cat_yn.equals("Y") && !patientid.equals(""))
		{
			try
			{
			 con							= ConnectionManager.getConnection(req);
			 pstmt=con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy'),?,?,?,'OP',?,'') from dual");
			 pstmt.setString(1,patientid);
			 pstmt.setString(2,refe_date.substring(0,10));
			 pstmt.setString(3,facilityId);
			 pstmt.setString(4,to_locn_type);
			 pstmt.setString(5,to_locn_code);
			 pstmt.setString(6,tospecialitycode);
			 rset=pstmt.executeQuery();
			 if(rset != null)
			  {
				 if(rset.next())
				  {
					success_flag=rset.getString(1);
					if(success_flag == null) success_flag="";
				  }
			  }
			 if(pstmt != null) pstmt.close();
			 if(rset != null) rset.close();



			}catch(Exception e)
			{
			  
			  e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,req);
			}
		}

		return success_flag;

	}

}




