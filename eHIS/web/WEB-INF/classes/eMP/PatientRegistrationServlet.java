/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP; 
import eBL.BLReportIdMapper;
import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;
import com.ehis.util.DateUtils;
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream; 
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import eCommon.Common.CommonBean;
import eBL.BLInsuranceImageBean;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import eCommon.XSSRequestWrapper;
public class PatientRegistrationServlet extends HttpServlet
    implements SingleThreadModel
{

    public PatientRegistrationServlet()
    {
        out = null;
        appt_ref_no = "";
        bkg_ref_no = "";
        booking_ref_no = "";
        func_act = "";
        pat_name_as_multipart_yn = "";
		gcc="N";
        facility_id = "";
        biometric_reason="";			//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
        fun_id="";			//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
        patient_id = "";
        alt_id1_no = "";
        alt_id1_db = "";
        val_len = 0;
        mother_patient_id = "";
        multi_birth = "";
        parent_details = "";
        numberofbirth = "";
        numberofbaby = "";
        noOfBirths = 0;
        numOfbaby = 0;
        AddedFacilityID = "";
        AddedAtWsNo = "";
        addedById = "";
        sStyle = "";
        outputValue = "";
        errorValue = "";
        bl_success_msg = "";
        err_value = "0";
        tabdata = null;
        httpResponse = null;
        httpRequest = null;
        con = null;
        stmt = null;
        rset = null;
        messages = "";
        function_id = "";
        pat_ser_short_desc = "";
        q_booking_type = "";
        p = null;
        create_file_at_pat_regn_yn = "N";
        appt_yn = "";
        locale = "";
        alt_ind = 1;
		common_labels = null;
		FAMILY_ORG_ID_ACCEPT_YN="N";
		dla_image = "";
		pat_photo="";
		dla_image_yn = "";
		called_from = "";

    }
    public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
       
        httpservletrequest.setCharacterEncoding("UTF-8");
        httpservletresponse.setContentType("text/html;charset=UTF-8");
        boolean flag = false;
        tabdata = new HashMap();
		httpservletrequest= new XSSRequestWrapper(httpservletrequest);
		httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
		httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
        httpRequest = httpservletrequest;
        httpResponse = httpservletresponse;
        HttpSession httpsession = httpservletrequest.getSession(false);
        out = httpservletresponse.getWriter();
        facility_id = (String)httpsession.getValue("facility_id");
        biometric_reason		= (String) httpsession.getValue( "biometric_reason" ) ; //added by himanshu
        p = (Properties)httpsession.getValue("jdbc");
        locale = p.getProperty("LOCALE");
		String modifiedAtWsNo = p.getProperty("client_ip_address");
        String  modifiedById = p.getProperty("login_user");
		dla_image = (String)httpsession.getAttribute("dla_image");
		pat_photo = (String)httpsession.getAttribute("pat_photo");		
		//image_yn = (String)httpsession.getAttribute("dla_image_yn");
		dla_image_yn = httpservletrequest.getParameter("dla_image_yn")==null?"": 				httpservletrequest.getParameter("dla_image_yn");
		called_from = httpservletrequest.getParameter("called_from")==null?"": 					httpservletrequest.getParameter("called_from");
		if(called_from.equals("Rapid_Regn")){
			fun_id="MP_RAP_REG";
		}else if(called_from.equals("AE")){
			fun_id="MP_REG_EMER_PAT";
		}else{
			fun_id="MP_PAT_REG";
		}
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		String s = httpservletrequest.getParameter("operation") != null ? httpservletrequest.getParameter("operation") : "";
        sStyle = httpservletrequest.getParameter("sStyle") != null ? httpservletrequest.getParameter("sStyle") : "IeStyle.css";
        func_act = httpservletrequest.getParameter("func_act") != null ? httpservletrequest.getParameter("func_act") : "";
        function_id = httpservletrequest.getParameter("function_id");  // added this line by Abirami - Bru-HIMS-CRF-313
        appt_ref_no = httpservletrequest.getParameter("appt_ref_no") != null ? httpservletrequest.getParameter("appt_ref_no") : "";
        bkg_ref_no = httpservletrequest.getParameter("booking_ref_no") != null ? httpservletrequest.getParameter("booking_ref_no") : "";
        q_booking_type = httpservletrequest.getParameter("q_booking_type") != null ? httpservletrequest.getParameter("q_booking_type") : "";
        create_file_at_pat_regn_yn = httpservletrequest.getParameter("create_file_at_pat_regn_yn") != null ? httpservletrequest.getParameter("create_file_at_pat_regn_yn") : "N";
        appt_yn = httpservletrequest.getParameter("appt_yn") != null ? httpservletrequest.getParameter("appt_yn") : "N";
		FAMILY_ORG_ID_ACCEPT_YN = httpservletrequest.getParameter("family_org_id_accept_yn") != null ? httpservletrequest.getParameter("family_org_id_accept_yn") : "N";

		dftNationalId = httpservletrequest.getParameter("dftNationalId") != null ? httpservletrequest.getParameter("dftNationalId") : "";
        if(func_act.equals("null"))
            func_act = "";
        if(appt_ref_no.equals("null"))
            appt_ref_no = "";
        if(bkg_ref_no.equals("null"))
            bkg_ref_no = "";
        messages = "";
        try
        {
		
            con = ConnectionManager.getConnection(httpservletrequest);
        	// code changed by Vedesh A D for Edge Conversion
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callPatientRegistrationHTML() { ");
    		isNatIdAltIdMandVisaType	= CommonBean.isSiteSpecific(con, "MP","MP_VAL_VISA_TYPE");	
            if(s.equals("updateRelatedData"))
			{
				if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
				{
					try
					{
						patient_id = httpservletrequest.getParameter("patient_id") != null ? httpservletrequest.getParameter("patient_id") : "";
						String s1 = httpservletrequest.getParameter("nw_alt_id1_no") != null ? httpservletrequest.getParameter("nw_alt_id1_no") : "";
						String s5 = httpservletrequest.getParameter("related_pat_ids") != null ? httpservletrequest.getParameter("related_pat_ids") : "";
						String s9 = httpservletrequest.getParameter("changed_val") != null ? httpservletrequest.getParameter("changed_val") : "";
						StringTokenizer stringtokenizer = new StringTokenizer(s5, "|");
						String s13 = "";
						String s14 = "";
						String s15 = "";
						String s16 = "select family_org_sub_id, family_org_id, patient_id from mp_patient where family_org_membership='1' and alt_id1_no = '" + s1 + "'";
						if(s9.equals("alt_id1_no"))
						{
							Statement statement = con.createStatement();
							ResultSet resultset = statement.executeQuery(s16);
							if(resultset != null && resultset.next())
							{
								s15 = resultset.getString("patient_id");
								s14 = resultset.getString("family_org_id");
								s13 = resultset.getString("family_org_sub_id");
							}
							if(resultset != null)
								resultset.close();
							if(statement != null)
								statement.close();
						} else
						{
							s14 = httpservletrequest.getParameter("org_id") != null ? httpservletrequest.getParameter("org_id") : "";
							s13 = httpservletrequest.getParameter("sub_organization") != null ? httpservletrequest.getParameter("sub_organization") : "";
						}
						if(stringtokenizer != null)
						{
							String s12;
							if(s9.equals("alt_id1_no"))
								s12 = "Update mp_patient set alt_id1_no=?, family_link_no=?, family_org_id=?, family_org_sub_id=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where patient_id=?";
							else
								s12 = "Update mp_patient set family_link_no=?,family_org_id=?, family_org_sub_id=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where patient_id=?";
							stmt = con.prepareStatement(s12);
							int i;
							for(i = 0; stringtokenizer.hasMoreElements(); i = stmt.executeUpdate())
							{
								String s18 = (String)stringtokenizer.nextElement();
								if(s9.equals("alt_id1_no"))
								{
									stmt.setString(1, s1);
									stmt.setString(2, s15);
									stmt.setString(3, s14);
									stmt.setString(4, s13);
									stmt.setString(5, modifiedById);
									stmt.setString(6, modifiedAtWsNo);
									stmt.setString(7, facility_id);
									stmt.setString(8, s18);
								} else
								{
									stmt.setString(1, patient_id);
									stmt.setString(2, s14);
									stmt.setString(3, s13);
									stmt.setString(4, modifiedById);
									stmt.setString(5, modifiedAtWsNo);
									stmt.setString(6, facility_id);
									stmt.setString(7, s18);
								}
							}

							if(i > 0)
							{
								con.commit();
								httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value=1");
							} else
							{
								con.rollback();
								httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value=0");
							}
						}
					}
					catch(Exception exception)
					{
						
						exception.printStackTrace();
					}

			}
		}
 
            if(s.equals("Generate_File"))
            {
                flag = true;
                if(validateFields(locale))
                {
                    s = promptFileGen();
                } else
                {
                    out.println("parent.multipleclicks = 'false';\n var msg =''");
                    String s2 = "";
                    String s6 = httpservletrequest.getParameter("nat_id_prompt");
                    if(alt_ind == 1)
                        s2 = httpservletrequest.getParameter("altId1Desc");
                    if(alt_ind == 2)
                        s2 = httpservletrequest.getParameter("altId2Desc");
                    if(alt_ind == 3)
                        s2 = httpservletrequest.getParameter("altId3Desc");
                    if(alt_ind == 4)
                        s2 = httpservletrequest.getParameter("altId4Desc");
                    out.println("var frameBody = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];");
                    out.println("if(frameBody)");
                    out.println("frameBody = frameBody.contentWindow; ");
                    out.println("else ");
                    out.println("frameBody = parent ;");
                    out.println("if(\"" + messages + "\" == 'ALT_ID_EXPIRED' && " + alt_ind + " == 1){");
                    out.println("var msg = frameBody.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                    out.println("msg = msg.replace('$','" + s2 + "')");
                    out.println("}else{");
                    out.println("msg = frameBody.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                    out.println("msg = msg.replace('$','" + s2 + "') }");
                    out.println("msg = msg.replace('@','" + val_len + "')");
                    out.println("msg = msg.replace('@','" + val_len + "')");
                    out.println("msg = msg.replace('#','" + s6 + "')");
                    out.println("msg = msg.replace('~','" + pat_ser_short_desc + "') ");
                    out.println("frameBody.enableFields()");
                    if(func_act.equals("Visitreg") || func_act.equals("REF_SEARCH") || func_act.equals("DuplicateRegistration") || appt_yn.equals("Appt"))
                        out.println("setTimeout('parent.frames[1].frames[1].disableButtons()',1000); document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);  parent.frames[1].frames[1].disableButtons();)");
                    else
                        out.println("document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg); ");
                }
            }
            if(s.equals("insert"))
            {
                if(!flag)
                {
                    if(validateFields(locale))
                    {
                        if(setData(httpservletrequest, locale))
                        {
                            outputValue = "";
                            insertPatientDetails(httpservletrequest, httpservletresponse, locale);
                        }
                    } else
                    {
                        out.println("parent.multipleclicks = 'false';\n var msg =''");
                        String s3 = "";
                        String s7 = httpservletrequest.getParameter("nat_id_prompt");
                        if(alt_ind == 1)
                            s3 = httpservletrequest.getParameter("altId1Desc");
                        if(alt_ind == 2)
                            s3 = httpservletrequest.getParameter("altId2Desc");
                        if(alt_ind == 3)
                            s3 = httpservletrequest.getParameter("altId3Desc");
                        if(alt_ind == 4)
                            s3 = httpservletrequest.getParameter("altId4Desc");
                        out.println("if(\"" + messages + "\" == 'ALT_ID_EXPIRED' && " + alt_ind + " == 1){");
                        out.println("var msg = parent.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                        out.println("msg = msg.replace('$','" + s3 + "')");
                        out.println("}else{");
                        out.println("msg = parent.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                        out.println("msg = msg.replace('$','" + s3 + "') }");
                        out.println("msg = msg.replace('@','" + val_len + "')");
                        out.println("msg = msg.replace('@','" + val_len + "')");
                        out.println("msg = msg.replace('#','" + s7 + "')");
                        out.println("msg = msg.replace('~','" + pat_ser_short_desc + "') ");
                        out.println("parent.enableFields();");
                        if(func_act.equals("Visitreg") || func_act.equals("REF_SEARCH") || func_act.equals("DuplicateRegistration") || appt_yn.equals("Appt"))
                            out.println("setTimeout('parent.frames[1].frames[1].disableButtons()',1000); document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);  parent.frames[1].frames[1].disableButtons();)");
                        else
                            out.println("document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg) ;");
                    }
                } else
                if(setData(httpservletrequest, locale))
                {
                    outputValue = "";
                    insertPatientDetails(httpservletrequest, httpservletresponse, locale);
                }

            } else
            if(s.equals("modify"))
            {
                outputValue = "";
                if(validateFields(locale))
                {
                    if(setData(httpservletrequest, locale))
                    {
                        function_id = httpservletrequest.getParameter("function_id");
                        outputValue = "";
                        modifyPatientDetails(httpservletrequest, locale);
                    }
                } else
                {
                    function_id = httpservletrequest.getParameter("function_id");
                    out.println("parent.multipleclicks = 'false';\n var msg =''");
                    String s4 = "";
                    String s8 = httpservletrequest.getParameter("nat_id_prompt");
                    if(alt_ind == 1)
                        s4 = httpservletrequest.getParameter("altId1Desc");
                    if(alt_ind == 2)
                        s4 = httpservletrequest.getParameter("altId2Desc");
                    if(alt_ind == 3)
                        s4 = httpservletrequest.getParameter("altId3Desc");
                    if(alt_ind == 4)
                        s4 = httpservletrequest.getParameter("altId4Desc");
                    out.println("var frameBody = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];");
                    out.println("if(frameBody)");
                    out.println("frameBody = frameBody.contentWindow; ");
                    out.println("else ");
                    out.println("frameBody = parent;");
                    out.println("if(\"" + messages + "\" == 'ALT_ID_EXPIRED' && " + alt_ind + " == 1){");
                    out.println("msg = frameBody.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                    out.println("msg = msg.replace('$','" + s4 + "')");
                    out.println("}else{");
                    out.println("msg = frameBody.f_query_add_mod.patient_sub.getMessage('" + messages + "','MP')");
                    out.println("msg = msg.replace('$','" + s4 + "') }");
                    out.println("msg = msg.replace('@','" + val_len + "')");
                    out.println("msg = msg.replace('@','" + val_len + "')");
                    out.println("msg = msg.replace('#','" + s8 + "')");
                    out.println("msg = msg.replace('~','" + pat_ser_short_desc + "') ");
                    out.println("frameBody.enableFields()");
                    if(function_id.equals(""))
                    {
                        out.println("frameBody.messageFrame.document.location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);");
                    } else
                    {
                        String s10 = "frameBody.messageFrame.document.writeln(msg);" + " frameBody.commontoolbarFrame.location.href ='../eMP/jsp/ChangepatdocsToolBar.jsp';";
                        out.println(s10);

                    }
                }
            } else if (s.equals("update_phone_no")) {
				updatePhoneNumber(httpservletrequest, httpservletresponse);
			} else if (s.equals("update_file_no"))
				updateFileNumber(httpservletrequest, locale);
			tabdata.clear();
			rset = null;
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			out.println("} callPatientRegistrationHTML ();</script></body></html>");	
			out = null;
		} catch (Exception exception1) {
			exception1.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, httpservletrequest);
		}
	}

    private void insertPatientDetails(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, String s)
    {    
        HttpSession httpsession = httpservletrequest.getSession(false);
        try
        {
        	tabdata.put("fun_id", fun_id);//added for AAKH-CRF-0175
            String s1 = httpservletrequest.getParameter("org_id") != null ? httpservletrequest.getParameter("org_id") : "";
            String s2 = httpservletrequest.getParameter("sub_organization") != null ? httpservletrequest.getParameter("sub_organization") : "";
            String s3 = httpservletrequest.getParameter("family_org_membership") != null ? httpservletrequest.getParameter("family_org_membership") : "";
            addedById = p.getProperty("login_user");
            boolean flag = false;
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;

			
            Object obj = ServiceLocator.getInstance().getHome("java:comp/env/PatientRegistration", eMP.PatientRegistration.PatientRegistrationHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[2];
            aobj[0] = p;
            aobj[1] = tabdata;
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            HashMap hashmap = (HashMap)obj1.getClass().getMethod("insertPatient", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
            errorValue = String.valueOf((StringBuffer)hashmap.get("error_buf"));
            String s4 = (String)hashmap.get("MRNPrompt") != null ? (String)hashmap.get("MRNPrompt") : "";
			bl_success_msg = (String)hashmap.get("bl_success_msg");
			
			
// venkat S 
            if(errorValue.length() > 0)
            {
				if(errorValue.equals("**NO RECORD IN MP_REL_FOR_PAT_SER_GRP"))
				{
				java.util.Hashtable message = MessageManager.getMessage( locale, "MP_PARAM_NOT_FOUND","MP" ) ;
				errorValue = (String) message.get("message");
				}

                outputValue = errorValue;
            } else
            {
                outputValue = String.valueOf((StringBuffer)hashmap.get("Message"));
                err_value = "1";
            }

			if(((Boolean)hashmap.get("Transaction_Completed")).booleanValue())
            {
				patient_id = (String)hashmap.get("patient_id");

               	String bl_install_yn = httpservletrequest.getParameter("bl_install_yn") == null?"":httpservletrequest.getParameter("bl_install_yn");

				if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
				{

					int i = 0;
					String s8 = "Select Count(*) count from mp_patient where alt_id1_no=? and  FAMILY_ORG_MEMBERSHIP!=1 and   FAMILY_ORG_ID = ? and FAMILY_ORG_SUB_ID = ?";
					stmt = con.prepareStatement(s8);
					stmt.setString(1, alt_id1_no);
					stmt.setString(2, s1);
					stmt.setString(3, s2);
					rset = stmt.executeQuery();
					if(rset != null && rset.next())
						i = rset.getInt("count");
					if(s3.equals("1") && i > 0)
					{
						String s9 = "var enter_yn ; var dialogHeight    = '25' ;\t var dialogWidth = '40' ;\tvar dialogTop = '175' ;\t var center    = '1'  ;\t var arguments =   ''; var getUrl  = '../eMP/jsp/RelatedFamilyMembersFrameSet.jsp?alt_id1_no=" + alt_id1_no + "&FAMILY_ORG_ID_ACCEPT_YN=" + FAMILY_ORG_ID_ACCEPT_YN + "&FAMILY_ORG_ID=" + s1 + "&FAMILY_ORG_SUB_ID=" + s2 + "&FAMILY_ORG_MEMBERSHIP=" + s3 + "&patient_id=" + patient_id + "&nw_alt_id1_no=&changed_val='; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;var retVal = await window.showModalDialog(getUrl,arguments,features);";
						out.println(s9);
					}
					if(rset != null)
						rset.close();
					if(stmt != null)
						stmt.close();

				}

				
				if (bl_install_yn.equals("Y")) {
					
					String billdoctype = (String) hashmap.get("billdoctype");
					String billdocnum = (String) hashmap.get("billdocnum");
					String billgenlater = (String) hashmap.get("billgenlater");
					String billAlreadyPrinted = "N";
					String blnggrp = httpservletrequest.getParameter("billing_group") != null ? httpservletrequest.getParameter("billing_group") : "";
						//Added By suganya 
					String allowCloseRegnBillGeneration = BLReportIdMapper.allowCloseRegnBillGeneration(facility_id);

					function_id = httpservletrequest.getParameter("function_id");

					String str_bill_prt_format_YN = (String) hashmap.get("bill_prt_format_YN");	
					if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
					String str_bill_prt_format_vals = (String) hashmap.get("bill_prt_format_vals");	
					if(str_bill_prt_format_vals==null || (("null").equals(str_bill_prt_format_vals))) str_bill_prt_format_vals="";
						
						if(str_bill_prt_format_YN.equals("Y") && !(("").equals(str_bill_prt_format_vals)))
					{
						try
						{
							String pgm_id = (String) hashmap.get("pgm_id");	
							if(pgm_id == null) pgm_id="";
						
							String session_id = (String) hashmap.get("session_id");	
							if(session_id == null) session_id="";
							//System.err.println("session_id:"+session_id);
							String pgm_date = (String) hashmap.get("pgm_date");	
							if(pgm_date == null) pgm_date="";
							//System.err.println("pgm_date:"+pgm_date);
							String mpi_id_rep = (String) hashmap.get("mpi_id_rep");	
							if(mpi_id_rep == null) mpi_id_rep="";
							//System.err.println("mpi_id_rep:"+mpi_id_rep);
							
							String reportId="BLRBLPRT"; 
							
							try{
								/* BLReportIdMapper.getReportId function used in other modules also
								 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
								 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
								 * eMP - PatientRegistrationServlet.java
								 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
								 */
								reportId=BLReportIdMapper.getReportId(con, locale,reportId, facility_id); //Added facility_id By Subha for MMS-DM-CRF-131.1
								System.out.println("PatientRegistrationServlet for Report ID "+reportId);
								
							}catch(Exception e)
							{
								e.printStackTrace();
								reportId="BLRBLPRT";
								System.err.println("Exception in PatientRegistrationServlet for reportID "+e);
							}
							
							
							
							
							
							
							
							
							/*Added by Rajesh V for ML-MMOH-CRF-0753*/
							PreparedStatement pstmtBill = null;;
							ResultSet rsBill = null;
							Boolean printRequired = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");
							String bill_print_reqd = "";
							int docNum = 0;
							if(printRequired){
								try{
									pstmtBill = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
									docNum = Integer.parseInt(billdocnum);
									pstmtBill.setString(1,facility_id);							
									pstmtBill.setString (2,billdoctype);
									pstmtBill.setInt(3,docNum);
									rsBill = pstmtBill.executeQuery();
									 if(rsBill != null && rsBill.next()){
										 bill_print_reqd = rsBill.getString(1);
									   }
									 if("Y".equals(bill_print_reqd)) {
										 OnlineReport onlinereportParam = new OnlineReport(facility_id, "BL", reportId);
											onlinereportParam.addParameter("p_facility_id",facility_id);
											onlinereportParam.addParameter("p_pgm_date",pgm_date);
											onlinereportParam.addParameter("p_pgm_id",pgm_id);
											onlinereportParam.addParameter("p_Session_id",session_id);
											//System.err.println("Online Report onlinereportParam:"+onlinereportParam);
											OnlineReports onlinereports = new OnlineReports();
											onlinereports.add(onlinereportParam);
											//System.err.println("Online Report Added:"+onlinereports);
											
				 /*This line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report */
											//String strResults =  onlinereports.execute(httpservletrequest,httpservletresponse);
											
											/*This is line was added by Venkatesh.S anginst checkstyle report error clearing */
											onlinereports.execute(httpservletrequest,httpservletresponse);
											onlinereportParam = null;
											onlinereports = null;	
											billAlreadyPrinted = "Y";
									}
									}
									 catch (Exception e) {
											e.printStackTrace();
										}
										finally{
											pstmtBill = null;
											rsBill = null;
										}
							}
							else{
								OnlineReport onlinereportParam = new OnlineReport(facility_id, "BL", reportId);
								onlinereportParam.addParameter("p_facility_id",facility_id);
								onlinereportParam.addParameter("p_pgm_date",pgm_date);
								onlinereportParam.addParameter("p_pgm_id",pgm_id);
								onlinereportParam.addParameter("p_Session_id",session_id);
								//System.err.println("Online Report onlinereportParam:"+onlinereportParam);
								OnlineReports onlinereports = new OnlineReports();
								onlinereports.add(onlinereportParam);
								//System.err.println("Online Report Added:"+onlinereports);
								
	 /*This line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report */
								//String strResults =  onlinereports.execute(httpservletrequest,httpservletresponse);
								
								/*This is line was added by Venkatesh.S anginst checkstyle report error clearing */
								onlinereports.execute(httpservletrequest,httpservletresponse);
								onlinereportParam = null;
								onlinereports = null;	
							}
							/*Added by Rajesh V for ML-MMOH-CRF-0753*/
							
														
						}
						catch (Exception e)
						{   e.printStackTrace();
							System.err.println("Error while submitting Print Job to Report Server:"+e);
						}
					}

					String htmlFor1 = "var arr = new Array(); var dialogHeight = '400px'; var dialogWidth = '700px';	var dialogTop = '100' ;	var center = '1'; var arguments =  ''; var features  = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';"
					+ "var getUrl  = '../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?patient_id="+patient_id
					+"&billgenlater="
					+ billgenlater
					+"&function_id="
					+ function_id
					+"&module_id=MP"
					+"&bill_doc_type_code="
					+ billdoctype
					+"&bill_doc_num="
					+ billdocnum
					+"&blng_grp="
					+blnggrp
					+"&call_disc_function_yn="
					+billgenlater
					+"&episode_type=R"
					+"&called_frm=OTH_MOD"
					+"&billAlreadyPrinted="
					+ billAlreadyPrinted
					+"';"
				//	added by suganya AMRI-CRF-338
				/* below in else block Added by PalaniNarayanan against AMS-CRF-0256 */
					+ "  var retVal; "
					+" if('"+allowCloseRegnBillGeneration+"' == 'N'){ "
					+" do{ retVal =await window.showModalDialog(getUrl,arguments,features);}while(retVal == undefined || retVal == 'undefined');   "
					+" } else{ "
					//+" retVal = window.showModalDialog(getUrl,arguments,features); "
					+" do{ retVal =await window.showModalDialog(getUrl,arguments,features);}while(retVal == undefined || retVal == 'undefined');   "
					+" }";
						//Added By suganya 
					//	+"retVal = window.showModalDialog(getUrl,arguments,features);</script></body></html>";
					out.println(htmlFor1);
				}
                if(s4 != "")
                {
                    out.println(s4);
                    String s6 = httpservletrequest.getParameter("old_file_no");
                    if(s6==null)
                        s6 = "";
                } else
                {

                    String s10 = "";
                    String s11 = "";
                    dispVal(true, httpservletrequest, patient_id, s10, s11, s);
                }
				
				if (httpsession.getAttribute("financial_details") != null )
				{
					httpsession.removeAttribute("financial_details");
				}
				/*Added for the CRF - MMS-QH-CRF-0066 - start*/
				if (bl_install_yn.equals("Y")) {
					try
					{
						String bean_id		= "bl_blinsuranceimagebean" ;
						String bean_name	= "eBL.BLInsuranceImageBean";
						BLInsuranceImageBean bean = (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, httpservletrequest ) ;
						bean.insertInsuranceDBvalues(patient_id);  
					}
					catch(Exception e)
					{
						System.out.println("Exception while calling BLInsuranceImageBean:::: "+e);
					}
				}
				/*Added for the CRF - MMS-QH-CRF-0066 - End*/
            } else
            if(!((Boolean)hashmap.get("tableUpdated")).booleanValue())
            {
				String s7 = (String)hashmap.get("tableUpdatedMsg");
                out.println("document.location.href=\"../eCommon/jsp/error.jsp?err_num=" + s7 + "&err_value=1\";");
            } else
            {
				dispVal(false, httpservletrequest, "", "", "", s);
            }
            hashmap.clear();
        }
        catch(Exception exception)
        {
            
			exception.printStackTrace();
        }
		finally{
			/*
			if (httpsession.getAttribute("financial_details") != null )
			{
				httpsession.removeAttribute("financial_details");
			}
			*/
			if (httpsession.getAttribute("dla_image") != null )
			{
				httpsession.removeAttribute("dla_image");
			}
			if (httpsession.getAttribute("pat_photo") != null )
			{
				httpsession.removeAttribute("pat_photo");
			}
			
			/*
			if (httpsession.getAttribute("dla_image_yn") != null )
			{
				httpsession.removeAttribute("dla_image_yn");
			}
			*/
		}
    }

    private void modifyPatientDetails(HttpServletRequest httpservletrequest, String s)
    {
		String photo_fun_id = httpservletrequest.getParameter("function_id");
		tabdata.put("fun_id", "MP_CHNG_PAT_REG");//added for AAKH-CRF-0175
		HttpSession httpsession = httpservletrequest.getSession(false);
		String locale1 = p.getProperty("LOCALE");
		String regnb="";
		java.util.Locale loc = new java.util.Locale(locale1);
		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
		regnb = mp_labels.getString("eMP.RegNewBorn.label");
        try
        {
			addedById = p.getProperty("login_user");

            boolean flag = false;
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;
            Object obj = ServiceLocator.getInstance().getHome("java:comp/env/PatientRegistration", eMP.PatientRegistration.PatientRegistrationHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[2];
            aobj[0] = p;
            aobj[1] = tabdata;
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            HashMap hashmap = (HashMap)obj1.getClass().getMethod("updatePatient", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			if(((Boolean)hashmap.get("Transaction_Completed")).booleanValue())
            {
				String bl_install_yn = httpservletrequest.getParameter("bl_install_yn") == null?"":httpservletrequest.getParameter("bl_install_yn");

			if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
			{

                String s1 = httpservletrequest.getParameter("org_id") != null ? httpservletrequest.getParameter("org_id") : "";
                String s2 = httpservletrequest.getParameter("sub_organization") != null ? httpservletrequest.getParameter("sub_organization") : "";
                String s3 = httpservletrequest.getParameter("family_org_membership") != null ? httpservletrequest.getParameter("family_org_membership") : "";
                String s4 = "";
                String s5 = "";
                int i = 0;
                String s6 = "Select Count(*) count from mp_patient where alt_id1_no=? and  FAMILY_ORG_MEMBERSHIP!=1";
                stmt = con.prepareStatement(s6);
                if(s3.equals("1"))
                {
                    stmt.setString(1, alt_id1_db);
                    if(!alt_id1_db.equals(alt_id1_no))
                    {
                        s4 = "alt_id1_no";
                        s5 = alt_id1_no;
                        alt_id1_no = alt_id1_db;
                    }
                    rset = stmt.executeQuery();
                    if(rset != null && rset.next())
                        i = rset.getInt("count");
                    if(stmt != null)
                        stmt.close();
                    if(i > 0)
                    {
                        String s7 = "var enter_yn ; var dialogHeight    = '25' ;\t var dialogWidth = '40' ;\tvar dialogTop = '175' ;\t var center    = '1'  ;\t var arguments =   ''; var getUrl  = '../eMP/jsp/RelatedFamilyMembersFrameSet.jsp?alt_id1_no=" + alt_id1_no + "&FAMILY_ORG_ID_ACCEPT_YN=" + FAMILY_ORG_ID_ACCEPT_YN + "&FAMILY_ORG_ID=" + s1 + "&FAMILY_ORG_SUB_ID=" + s2 + "&FAMILY_ORG_MEMBERSHIP=" + s3 + "&patient_id=" + patient_id + "&nw_alt_id1_no=" + s5 + "&changed_val=" + s4 + "'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;var retVal = await window.showModalDialog(getUrl,arguments,features);";
                        out.println(s7);
                    }
                }
			}
				if (bl_install_yn.equals("Y")) {
					
					String billdoctype = (String) hashmap.get("billdoctype");
					String billdocnum = (String) hashmap.get("billdocnum");
					String billgenlater = (String) hashmap.get("billgenlater");

String allowCloseRegnBillGeneration = BLReportIdMapper.allowCloseRegnBillGeneration(facility_id);

					String blnggrp = httpservletrequest.getParameter("billing_group") != null ? httpservletrequest.getParameter("billing_group") : "";

					//function_id = httpservletrequest.getParameter("function_id");

					String htmlFor1 = "var arr = new Array(); var dialogHeight = '0vh'; var dialogWidth = '0vw';	var dialogTop = '-100vh' ;	 var arguments =  ''; var features  = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;';"
					+ "var getUrl  = '../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?patient_id="+patient_id
					+"&billgenlater="
					+ billgenlater
					+"&function_id="
					+ photo_fun_id
					+"&module_id=MP"
					+"&bill_doc_type_code="
					+ billdoctype
					+"&bill_doc_num="
					+ billdocnum
					+"&blng_grp="
					+blnggrp
					+"&call_disc_function_yn="
					+billgenlater
					
					+"&episode_type=R"
					+"&called_frm=OTH_MOD"
					+"';"
					+ "  var retVal; "
					+" if('"+allowCloseRegnBillGeneration+"' == 'Y'){ "
					+" do{ retVal = await window.showModalDialog(getUrl,arguments,features); }while(retVal == undefined || retVal == 'undefined');   "
				
					+" } else{ "
					+" retVal = await window.showModalDialog(getUrl,arguments,features); "
					+"  }";

						//Added By suganya 
					//+"retVal = window.showModalDialog(getUrl,arguments,features);</script></body></html>";
					
					out.println(htmlFor1);
				}

                outputValue = String.valueOf((StringBuffer)hashmap.get("Message"));

			    if(function_id.equals("") || function_id.equals("CHG_PAT_DTLS"))
                {
                    //outputValue = outputValue.substring(0, outputValue.indexOf("<br>"));
                    out.println("alert('" + outputValue + "');");
                    

                }
                if(function_id.equals("") || function_id.equals("CHG_PAT_DTLS")) {
					
                    try
                    {
                        if(rset != null)
                            rset.close();
                        if(stmt != null)
                            stmt.close();
                        String s8 = "";
                        String s9 = httpservletrequest.getParameter("maintain_doc_or_file");
                        if(s9.equals("F"))
                        {
                            stmt = con.prepareStatement("SELECT FILE_NO FROM MR_PAT_FILE_INDEX where patient_id ='" + patient_id + "' and facility_id='" + facility_id + "'");
                            rset = stmt.executeQuery();
                            if(rset != null && rset.next())
                            {
                                s8 = rset.getString(1);
                                if(s8 == null || s8.equals("null"))
                                    s8 = "";
                            }
                        }


                        String s10 = httpservletrequest.getParameter("pat_ser_grp_code") != null ? httpservletrequest.getParameter("pat_ser_grp_code") : "";
                        String s11 = "p_patient_id,p_file_no";
                        String s12 = "" + patient_id + "," + s8 + "";
                        String s13 = "";
                        if(!s8.equals(""))
                            s13 = "select distinct A.report_id, B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '" + s10 + "' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'" + facility_id + "')='" + facility_id + "' and A.report_id in ('MPBWBLBL', 'MPBFLLBL', 'MPBFRNST', 'MPBIDLBL','MPBPTLBL','MPBIDLBG') and B.language_id = '" + s + "' order by 2";
                        else
                            s13 = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '" + s10 + "' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'" + facility_id + "')='" + facility_id + "' and A.report_id in ('MPBWBLBL', 'MPBFRNST', 'MPBIDLBL','MPBPTLBL','MPBIDLBG') and B.language_id = '" + s + "' order by 2";
                        String s14 = "";
                        s14 = s14 + "  var dialogHeight    = '300px' ;";
                        s14 = s14 + " var dialogWidth = '700px' ;";
                        s14 = s14 + "  var arguments =   ''; ";
						String capture_photo_yn="";
						if(txtSmart_fn_name.equals("06")){
							capture_photo_yn="N";	
						}
						else{
							capture_photo_yn="Y";
						}
                        s14 = s14 + "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=CHG_PAT_DTLS&capture_photo_yn="+capture_photo_yn+"&step=1&sqlString=" + java.net.URLEncoder.encode(s13, "UTF-8") + "&Patient_ID=" + patient_id + "&reportParamNames=" + s11 + "&reportParamValues=" + s12 + "';"; //Modified by abirami - Bru-HIMS-CRF-313 
                        //s14 = s14 + "  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?capture_photo_yn=Y&step=1&sqlString=" + java.net.URLEncoder.encode(s13, "UTF-8") + "&Patient_ID=" + patient_id + "&reportParamNames=" + s11 + "&reportParamValues=" + s12 + "';";
                        s14 = s14 + " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
                        s14 = s14 + " if(top.window.document.getElementById('dialog-body')) {";
                        s14 = s14 + "  retVal            =  await top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow.frames[1].showModalDialog(getUrl,arguments,features); }";
                        s14 = s14 + " else {";
                        s14 = s14 + "  retVal            =  await window.showModalDialog(getUrl,arguments,features);} ";
                        out.println(s14);
						 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){ 
							 insertPatDocImage(httpservletrequest, patient_id,"",function_id);
                         } 
                         if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                             updateScanDetails(httpservletrequest,patient_id);
                              }

						if(function_id.equals("CHG_PAT_DTLS")) {
							//out.println("<script>top.returnValue=true;top.window.close();</script>");\
							out.println("var ret=true;");
							out.println("if(top.content.frames[1].frames[0].document.forms[0].patient_id){");
							out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.value = '"+patient_id+"';");
							out.println("if(ret){");
							out.println("if(top.content.frames[1].frames[0].document.forms[0].national_id_no && top.content.frames[1].frames[0].document.forms[0].national_id_no.value!=''){");
							out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.value = '"+patient_id+"';");
							out.println("if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!='')");
							out.println("top.content.frames[1].frames[0].searchPatient(top.content.frames[1].frames[0].document.forms[0].patient_id)");
							out.println("else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!='')");
							out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();");
							out.println("}else{");
							out.println("if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!='')");
							out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();");
							out.println("else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!='')");
							out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();");
							out.println("}");	
							out.println("}else{");
							out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.value='';");
							out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.focus();");
							out.println("}");
							out.println(" top.content.frames[2].location.href = '../eCommon/jsp/error.jsp?err_num=';}");
							//Added by arun
							out.println("else if(top.content.frames[1].frames[1].document.forms[0].pat_id1){");
							out.println("if( ret != null){");
							out.println("top.content.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
							out.println("top.content.frames[1].frames[1].document.forms[0].srch_code.click();");
							out.println("top.content.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
							out.println("}else{");
							out.println("parent.frames[0].document.getElementById('reset').click();");
							out.println("};");
							out.println("}");
							
							out.println(" top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = ret; top.window.document.querySelectorAll('#dialog_tag')[top.window.document.querySelectorAll('#dialog_tag').length-1].close();");
						} else {
							//out.println("<script>async function toHoldTheInternalReportDia(){ var retVal=await toCallInternalReportsPrint(); window.location.href='../eCommon/jsp/error.jsp?err_num= ';parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';</script></body></html>");
							out.println("    window.location.href = '../eCommon/jsp/error.jsp?err_num=';");
							out.println("    parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';");
						}
                    }
                    catch(Exception exception1)
                    {
                        out.println("Error here");
						exception1.printStackTrace();
                    }
				} else if(function_id.equals("NEWBORN_REG")) {
					
                    mother_patient_id = httpservletrequest.getParameter("mother_patient_id") != null ? httpservletrequest.getParameter("mother_patient_id") : "";
                    multi_birth = httpservletrequest.getParameter("multi_birth") != null ? httpservletrequest.getParameter("multi_birth") : "";
                    parent_details = httpservletrequest.getParameter("parent_details") != null ? httpservletrequest.getParameter("parent_details") : "";
                    numberofbirth = httpservletrequest.getParameter("noOfBirths") != null ? httpservletrequest.getParameter("noOfBirths") : "";
                    if(numberofbirth != null)
                        noOfBirths = Integer.parseInt(numberofbirth);
                    if(numberofbaby != null)
                        numberofbaby = httpservletrequest.getParameter("numOfbaby") != null ? httpservletrequest.getParameter("numOfbaby") : "";
                    numOfbaby = Integer.parseInt(numberofbaby);
                   // outputValue = outputValue.substring(0, outputValue.indexOf("<br>"));
                    out.println("alert('" + outputValue + "');top.returnValue=true;");
                    out.println("self.location.href='../eCommon/jsp/error.jsp';");
                    if(multi_birth.equals("Y"))
                    {
                        if(noOfBirths - numOfbaby >= 1)
                        {
                            out.println("var rtval = confirm(parent.frames[1].frames[1].getMessage('WANT_TO_PROCEED', 'MP'));");
                            out.println("if (rtval){");
                            out.println("parent.location.href='../eMP/jsp/NewbornRegistration.jsp?Patient_ID=" + mother_patient_id + "&parent_details=" + java.net.URLEncoder.encode(parent_details, "UTF-8") + "&function_id=NEWBORN_REG&function_name="+regnb+"&access=NYYNYN&multi_birth=Y'}");
                            out.println("else { ");
                            out.println("self.location.href='../eCommon/jsp/error.jsp?err_num='");
                            out.println("parent.location.href='../eMP/jsp/NewbornRegistration.jsp?function_id=NEWBORN_REG&function_name="+regnb+"&access=NYYNYN'}");
                        } else
                        {
                            out.println("parent.location.href='../eMP/jsp/NewbornRegistration.jsp?function_id=NEWBORN_REG&function_name="+regnb+"&access=NYYNYN'");
                        }
                    } else
                    {
                        out.println("parent.location.href='../eMP/jsp/NewbornRegistration.jsp?function_id=NEWBORN_REG&function_name="+regnb+"&access=NYYNYN';");
                    }
                } else
                {
                  //  outputValue = outputValue.substring(0, outputValue.indexOf("<br>"));
				 
                    out.println("alert('" + outputValue + "');top.returnValue=true;top.window.close();");
                }

				if (httpsession.getAttribute("financial_details") != null )
				{
					httpsession.removeAttribute("financial_details");
				}
				/*Added for the CRF - MMS-QH-CRF-0066 - start*/
				if (bl_install_yn.equals("Y")) {
					try
					{
						String bean_id		= "bl_blinsuranceimagebean" ;
						String bean_name	= "eBL.BLInsuranceImageBean";
						BLInsuranceImageBean bean = (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, httpservletrequest ) ;
						bean.insertInsuranceDBvalues(patient_id);  
					}
					catch(Exception e)
					{
						System.out.println("Exception while calling BLInsuranceImageBean:::: "+e);
						e.printStackTrace();
					}
				}
				/*Added for the CRF - MMS-QH-CRF-0066 - End*/
            } else
            {
                errorValue = String.valueOf((StringBuffer)hashmap.get("error_buf"));
                outputValue = errorValue;
                err_value = "0";
                out.println(" window.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(outputValue, "UTF-8") + "&err_value=" + err_value + "';");
            }
            hashmap.clear();
        }
        catch(Exception exception)
        {

			exception.printStackTrace();
        }
		finally{
			/*
			if (httpsession.getAttribute("financial_details") != null )
			{
				httpsession.removeAttribute("financial_details");
			}
			*/
			if (httpsession.getAttribute("dla_image") != null )
			{
				httpsession.removeAttribute("dla_image");
			}
			if (httpsession.getAttribute("pat_photo") != null )
			{
				httpsession.removeAttribute("pat_photo");
			}
			

			/*
			if (httpsession.getAttribute("dla_image_yn") != null )
			{
				httpsession.removeAttribute("dla_image_yn");
			}
			*/
		}
    }

    private void updateFileNumber(HttpServletRequest httpservletrequest, String s)
    {
        String s1 = httpservletrequest.getParameter("old_file_no") != null ? httpservletrequest.getParameter("old_file_no") : "";
        if(s1.equals("null") || s1.equals(" "))
            s1 = "";
        String s2 = httpservletrequest.getParameter("fs_locn_code");
        if(s2 == null)
            s2 = "";
        if(s2.equals("null") || s2.equals(" "))
            s2 = "";
        String s3 = httpservletrequest.getParameter("patient_id");
        dispVal(true, httpservletrequest, s3, s1, s2, s);
    }

    private void dispVal(boolean flag, HttpServletRequest httpservletrequest, String s, String s1, String s2, String s3)
    {System.out.println("httpservletrequest = " + httpservletrequest);


        if(s2.equals(null) || s2.equals("undefined"))
            s2 = "";
		
		
        if(flag)
        {
			


            if(appt_ref_no.equals("") && booking_ref_no.equals("") && func_act.equals(""))
            {				
                out.println("parent.window.multipleclicks='false';");
                String function_id = httpservletrequest.getParameter("function_id"); // // added this line by Abirami - Bru-HIMS-CRF-313
                if("".equalsIgnoreCase(function_id)) 
                	function_id = "PAT_REG";
                String s4 = httpservletrequest.getParameter("pat_ser_grp_code") != null ? httpservletrequest.getParameter("pat_ser_grp_code") : "";
                String s5 = "p_patient_id,p_file_no";
                String s6 = "" + s + "," + s1 + "";
                String s7 = "";
				//String national_id_no= httpservletrequest.getParameter("national_id_no");
				//Added by Maheshwaran K for AAKH-CRF-0168
				String  national_id_no = httpservletrequest.getParameter("national_id_no") != null ? httpservletrequest.getParameter("national_id_no") : "";	
				if(dftNationalId.equals(national_id_no) && isNatIdAltIdMandVisaType==true)
				{
				national_id_no="";
				}
				String Photo_upload_yn=httpservletrequest.getParameter("Photo_upload_yn");
                if(!s1.equals(""))
                    s7 = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '" + s4 + "' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'" + facility_id + "')='" + facility_id + "' and A.report_id in ('MPBWBLBL', 'MPBFLLBL', 'MPBFRNST', 'MPBIDLBL','MPBPTLBL','MPBIDLBG') and B.language_id = '" + s3 + "' order by 2";
                else
                    s7 = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '" + s4 + "' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'" + facility_id + "')='" + facility_id + "' and A.report_id in ('MPBWBLBL', 'MPBFRNST', 'MPBIDLBL','MPBPTLBL','MPBIDLBG') and B.language_id = '" + s3 + "' order by 2";

                String s8 = "";
                s8 = s8 + "  var dialogHeight    = '300px' ;";
                s8 = s8 + " var dialogWidth = '700px' ;";
                s8 = s8 + "  var arguments =   ''; ";
				String capture_photo_yn="";
				if(txtSmart_fn_name.equals("06")){
					capture_photo_yn="N";	
				}
				else{
					capture_photo_yn="Y";
				}
                //s8 = s8 + "  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?capture_photo_yn=Y&step=1&sqlString=" + URLEncoder.encode(s7) + "&Patient_ID=" + s + "&reportParamNames=" + s5 + "&reportParamValues=" + s6 + "';";
                s8 = s8 + "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=" + function_id + "&capture_photo_yn="+capture_photo_yn+"&national_id_no="+national_id_no+"&Photo_upload_yn="+Photo_upload_yn+"&step=1&sqlString=" + URLEncoder.encode(s7) + "&Patient_ID=" + s + "&reportParamNames=" + s5 + "&reportParamValues=" + s6 + "';"; // modified by Abirami for Bru-HIMS-CRF-313 [Passing function id in this Query String]  
                s8 = s8 + " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
                //s8 = s8 + "  retVal            =   await window.showModalDialog(getUrl,arguments,features); ";
                s8 = s8 + " if(top.window.document.getElementById('dialog-body')) {";
                s8 = s8 + "  retVal            =  await top.window.document.getElementById('dialog-body').contentWindow.frames[1].showModalDialog(getUrl,arguments,features); }";
                s8 = s8 + " else {";
                s8 = s8 + "  retVal            =  await window.showModalDialog(getUrl,arguments,features);} ";
                out.println(s8);
                //String s9 = "";
                //String s9 = " select PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,'') PATIENT_NAME_LOC_LANG, sex , calculate_age_hours(to_char(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) b_year,calculate_age_hours(to_char(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) b_month,calculate_age_hours(to_char(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) b_days,calculate_age_hours(to_char(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) b_hours,MP_GET_AGE_YMDH(date_of_birth,DECEASED_DATE) age from mp_patient where patient_id ='" + s + "' ";
                String s9 = " select PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,'') PATIENT_NAME_LOC_LANG, sex , MP_GET_AGE_YMDH(date_of_birth,DECEASED_DATE) p_age from mp_patient where patient_id ='" + s + "' ";
                try
                {
					String age_value = "";
					String pat_age = "";
                    PreparedStatement preparedstatement = con.prepareStatement(s9);
                    ResultSet resultset = preparedstatement.executeQuery();
                    resultset.next();
                    Hashtable hashtable = MessageManager.getMessage(s3, "PAT_ID_SUCCESS", "MP");
					String sex = resultset.getString("sex");
					switch (sex.charAt(0))
					{
						case 'M' : sex = common_labels.getString("Common.male.label");
									 break;
						case 'F' : sex = common_labels.getString("Common.female.label");
									 break;
						case 'U' : sex = common_labels.getString("Common.unknown.label");
									 break;
					}
                    String s12 = (String)hashtable.get("message");
                    String s11 = s12 + " <B><FONT SIZE=4>" + s + "</B></FONT>, ";
                    s11 = s11 + resultset.getString("PATIENT_NAME") + ", ";
					if (resultset.getString("PATIENT_NAME_LOC_LANG") != null )
					{
	                    s11 = s11 + resultset.getString("PATIENT_NAME_LOC_LANG") + ", ";
					}


                    s11 = s11 + sex + ", ";
					//s11 = s11 + resultset.getString("p_age");
					pat_age = resultset.getString("p_age")==null?"":resultset.getString("p_age");

					if(!pat_age.equals("")) {

						StringTokenizer st = new StringTokenizer(pat_age," ");

						while ( st.hasMoreTokens() ) {

								String date_elmnt = st.nextToken();

								char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);

								String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));

								if(ymdh_char=='Y') {
									if(!ymdh_elmnt.equals("0"))
										age_value = age_value+ymdh_elmnt+"Y ";
								} else if (ymdh_char=='M') {
									if(!ymdh_elmnt.equals("0"))
										age_value = age_value+ymdh_elmnt+"M ";
								} else if (ymdh_char=='D') {
									if(!ymdh_elmnt.equals("0"))
										age_value = age_value+ymdh_elmnt+"D ";
								} else if (ymdh_char=='H') {
									if(!ymdh_elmnt.equals("0"))
										age_value = age_value+ymdh_elmnt+"H ";
								}
						}

					}

					s11 = s11 + age_value;

					Hashtable hashtable1 = MessageManager.getMessage(s3, "FILE_NO_SUCCESS", "MP");
                    String fileAsig = (String)hashtable1.get("message");
					fileAsig=fileAsig.replace("%",s2);
                    if(!s1.equals(""))
					{
                     //   s11 = s11 + "<br>APP-MP0078 File No <font size=4><b>" + s2 + "</b></font> is assigned<br> ";
                        s11 = s11+"<br>"+fileAsig;
					}
					
					
			
			
			
				 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
					 
						if(!bl_success_msg.equals("")){
							s11 = "<B><U>"+bl_success_msg+"</U></B><br>"+s11;
						}
					
					 insertPatDocImage(httpservletrequest, patient_id,s11,func_act);
				 } 
                 if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                            if(!bl_success_msg.equals("")){
                            s11 = "<B><U>"+bl_success_msg+"</U></B><br>"+s11;
                        }
                             updateScanDetails(httpservletrequest,patient_id);
                            
                              }
			
					
                    /*	 Included the IF and Else part for Incident 17918 on 07/01/2010 by Suresh.
						 On successful the registration screen, the 2nd line of the patient file no generated detail is getting cut so can not see that detail in MessageFrame.
					 */
					if(bl_success_msg.equals("")){
						out.println("parent.f_query_add_mod.window.location.href='../eCommon/html/blank.html';window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLEncoder.encode("<B><U>"+bl_success_msg+"</U></B>"+s11, "UTF-8") + "&err_value=1';");
					} else {
						out.println("parent.f_query_add_mod.window.location.href='../eCommon/html/blank.html';window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLEncoder.encode("<B><U>"+bl_success_msg+"</U></B><BR>"+s11, "UTF-8") + "&err_value=1';");
					}
                    if(preparedstatement != null)
                        preparedstatement.close();
                    if(resultset != null)
                        resultset.close();
                }
                catch(Exception exception)
                {

					exception.printStackTrace();
                }
            } else
            if(func_act.equals("Visitreg") || func_act.equals("REF_SEARCH"))
			{				
				
		
		
		
				 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
					 insertPatDocImage(httpservletrequest, patient_id,s,func_act);
                    }
                if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals(""))
                    {
                        
                             updateScanDetails(httpservletrequest,patient_id);
                 
                              }
                /* Code Added by Vedesh A D for Edge Conversion */
				out.println(" parent.frames[2].location.href='../eCommon/jsp/error.jsp?&err_value=1';");
     			out.println("var dialogTagFrame = undefined; var dialogBodyFrame = undefined; const diagElement = top.document.getElementsByTagName('dialog');");
                out.println("var i = 0; var j = 0;");
                out.println("for (i = 0; i < diagElement.length; i++){");
                out.println("for (j = 0; j < diagElement[i].children.length; j++){");
                out.println("var element = diagElement[i].children[j];");
                out.println("let dialogSrc = element.src;");
                out.println("if (typeof dialogSrc !== 'undefined'){ ");
             	out.println("if (dialogSrc.includes('ModelPatientSearch.jsp') ){");
             	out.println("dialogTagFrame = diagElement[i];");
             	out.println("dialogBodyFrame = element;}" );
             	out.println("if (dialogSrc.includes('PatientRegistrationMain.jsp') ){");
             	out.println("diagElement[i].close();");
             	out.println("}}}}");
     			out.println("if(dialogTagFrame == undefined && dialogBodyFrame == undefined){");
                out.println("dialogTagFrame = parent.parent.document.getElementById('dialog_tag');");
                out.println("dialogBodyFrame = parent.parent.document.getElementById('dialog-body');}");
                out.println("dialogBodyFrame.contentWindow.returnValue = '" + s + "';");
                out.println("dialogTagFrame.close();");
                 /* end */
//				out.flush();
			}
            else{			
				
				
				
				 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
					 insertPatDocImage(httpservletrequest, patient_id,s,func_act);
                 }
                 if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                             updateScanDetails(httpservletrequest,patient_id);
                 
                              }
                 out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?&err_value=1';");				
                 /* Code Added by Vedesh A D for Edge Conversion */
      			 out.println("var dialogTagFrame = undefined; var dialogBodyFrame = undefined; const diagElement = top.document.getElementsByTagName('dialog');");
                 out.println("var i = 0; var j = 0;");
                 out.println("for (i = 0; i < diagElement.length; i++){");
                 out.println("for (j = 0; j < diagElement[i].children.length; j++){");
                 out.println("var element = diagElement[i].children[j];");
                 out.println("let dialogSrc = element.src;");
                 out.println("if (typeof dialogSrc !== 'undefined'){ ");
              	 out.println("if (dialogSrc.includes('ModelPatientSearch.jsp') ){");
              	 out.println("dialogTagFrame = diagElement[i];");
              	 out.println("dialogBodyFrame = element;}" );
              	 out.println("if (dialogSrc.includes('PatientRegistrationMain.jsp') ){");
              	 out.println("diagElement[i].close();");
              	 out.println("}}}}");
      			 out.println("if(dialogTagFrame == undefined && dialogBodyFrame == undefined){");
                 out.println("dialogTagFrame = parent.parent.document.getElementById('dialog_tag');");
                 out.println("dialogBodyFrame = parent.parent.document.getElementById('dialog-body');}");
                 out.println("dialogBodyFrame.contentWindow.returnValue = '" + s + "';");
                 out.println("dialogTagFrame.close();");
                   /* end */
                 
                 System.out.print("line -->1231");
                //out.println("parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + s + "';parent.parent.close();");				
				
			}
        } else
        if(func_act.equals("Visitreg"))
        if(called_from.equals("AE"))
		{			
		
		
		
		 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
			 insertPatDocImage(httpservletrequest, patient_id,outputValue,func_act);
         }
          if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
               updateScanDetails(httpservletrequest,patient_id);
                 
                              }
		out.println("alert('" + outputValue + "');parent.frames[1].frames[1].eRegistration1();");				
		}
		else
		{			
			
			
			
			 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
				insertPatDocImage(httpservletrequest, patient_id,outputValue,func_act);
            } 
            if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                             updateScanDetails(httpservletrequest,patient_id);
                 
                              }
			out.println("parent.parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(outputValue) + "&err_value=1';parent.parent.parent.frames[1].window.location.href='../eMP/jsp/PatRegLoad.jsp?func_act=Visitreg';");				
		}
        else
        if(appt_ref_no.equals("") && booking_ref_no.equals("") && func_act.equals(""))
        {			
			
			
			
			 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
				 insertPatDocImage(httpservletrequest, patient_id,outputValue,func_act);
             } 
             if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                             updateScanDetails(httpservletrequest,patient_id);
                 
                              }
            out.println("parent.multipleclicks='false';window.location.href='../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(outputValue) + "&err_value=0';");
			
        } else
        {
			
            outputValue = outputValue.replace('\n', ' ');
            outputValue = outputValue.replace('\'', ' ');
			
			
			
		   if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){
			   insertPatDocImage(httpservletrequest, patient_id,outputValue,func_act);
           } 
           if(!document_id1.equals("") || !document_id2.equals("") || !document_id3.equals("") || !document_id4.equals("")){
                             updateScanDetails(httpservletrequest,patient_id);
                 
                              }
            out.println("alert('" + outputValue + "');parent.parent.document.getElementById('dialog_tag').close();");
        }
    }

    private boolean setData(HttpServletRequest httpservletrequest, String s)
    {
	/*	java.util.Map paramMap = httpRequest.getParameterMap();

		for (Iterator paramItr = paramMap.keySet().iterator();paramItr.hasNext();)
		{
			String key = (String)paramItr.next();
			out.println(key+"  "+httpRequest.getParameter(key)+"<br>") ;
		}
		out.flush();

		if (true)
		{
			return false;
		}
*/
		boolean flag = true;
        try
        {
			httpservletrequest.setCharacterEncoding("UTF-8");
		    HttpSession httpsession = httpservletrequest.getSession(false);
            pat_name_as_multipart_yn = httpservletrequest.getParameter("pat_name_as_multipart_yn");
			//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
			 gcc =( httpservletrequest.getParameter("gcc") != null )? httpservletrequest.getParameter("gcc") : "N";
            if(pat_name_as_multipart_yn == null)
                pat_name_as_multipart_yn = "N";
            String s3 = httpservletrequest.getParameter("sflag") != null ? httpservletrequest.getParameter("sflag") : "N";
            String s4 = httpservletrequest.getParameter("family_name") != null ? httpservletrequest.getParameter("family_name") : "";
            String s5 = httpservletrequest.getParameter("patient_name") != null ? httpservletrequest.getParameter("patient_name") : "";

            String s6 = httpservletrequest.getParameter("names_in_oth_lang") != null ? httpservletrequest.getParameter("names_in_oth_lang") : "N";
			
			//Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1
			String uploaded_pat_yn = httpservletrequest.getParameter("uploaded_pat_yn") != null ? httpservletrequest.getParameter("uploaded_pat_yn") : "N";
			
			txtSmart_fn_name = httpservletrequest.getParameter("txtSmart_fn_name") != null ? httpservletrequest.getParameter("txtSmart_fn_name") : "";
			doc1image = httpservletrequest.getParameter("doc1image")!= null?httpservletrequest.getParameter("doc1image"):"";
			doc2image = httpservletrequest.getParameter("doc2image")!= null?httpservletrequest.getParameter("doc2image"):"";
			doc3image = httpservletrequest.getParameter("doc3image")!= null?httpservletrequest.getParameter("doc3image"):"";
			doc4image = httpservletrequest.getParameter("doc4image")!= null?httpservletrequest.getParameter("doc4image"):"";
  /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
          document_id1 = httpservletrequest.getParameter("document_id1")!= null?httpservletrequest.getParameter("document_id1"):"";
          document_id2 = httpservletrequest.getParameter("document_id2")!= null?httpservletrequest.getParameter("document_id2"):"";
          document_id3 = httpservletrequest.getParameter("document_id3")!= null?httpservletrequest.getParameter("document_id3"):"";
          document_id4 = httpservletrequest.getParameter("document_id4")!= null?httpservletrequest.getParameter("document_id4"):"";
          if((httpservletrequest.getParameter("iDocFolderOption")!=null )&& (!(httpservletrequest.getParameter("iDocFolderOption")).equals(""))){
          iDocFolderOption = Integer.parseInt(httpservletrequest.getParameter("iDocFolderOption"));
          }
          /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
               
			try
            {
                try
                {
                    if(s6.equals("Y") && s5.equals(""))
                        s5 = httpservletrequest.getParameter("patient_name_loc_lang") != null ? httpservletrequest.getParameter("patient_name_loc_lang") : "";
                }
                catch(Exception exception1)
                {
                    
					exception1.printStackTrace();
                }
                String s7 = httpservletrequest.getParameter("sex");
                String s2 = httpservletrequest.getParameter("details_unknown") != null ? httpservletrequest.getParameter("details_unknown") : "N";
                String s9 = httpservletrequest.getParameter("function_id");
                if(s9 == null)
                    s9 = "";
					
				//Modified against HSA-CRF-0153	-Start
				boolean bDaysrlFunction = false;
					
                if(s9.equals("EMERG_REG") && s3.equals("Y") && s2.equals("Y"))
                {
					// Getting sitespecific parameter for the function UNKWN_PAT_DISP_FORMAT 
					bDaysrlFunction = CommonBean.isSiteSpecific(con, "MP","UNKWN_PAT_DISP_FORMAT");	
					String sDaySrlFunction = "N";
					//If DaySrlFunction is enabled in sm_function_control
					if(bDaysrlFunction)
					sDaySrlFunction = "Y";
					
                    CallableStatement callablestatement = con.prepareCall("{call MP_EMER_PAT_GEN_SLNO(?,?,?)}");
                    callablestatement.setString(1, s7); //Sex
					callablestatement.setString(2, sDaySrlFunction); //Indicator for generating Day Srl No. 
                    callablestatement.registerOutParameter(3,  12);
                    callablestatement.execute();
                    s4 = callablestatement.getString(3);
                    if(bDaysrlFunction)
                    {
                		s5 = s4;
                    }else
                    {
                    	if(pat_name_as_multipart_yn.equals("N"))
                    		s5 = s4;
                    }
					//Modified against HSA-CRF-0153	-End
                    if(callablestatement != null)
                        callablestatement.close();
                } else
                {
                    String s11 = httpservletrequest.getParameter("pat_name") != null ? httpservletrequest.getParameter("pat_name") : "";
                    String s13 = s5;
                    String s15 = "";
                    if(s11.length() > 7)
                        s15 = s11.substring(0, 7);
				    if(s2.equals("Y") && s11.toLowerCase().contains("unknown")){
			 			if(s13.toLowerCase().contains("unknown")){
							s2 = "Y";
						}else{
							s2 = "N";
						}
					}
                }
                tabdata.put("pat_name_as_multipart_yn", pat_name_as_multipart_yn != null ? ((Object) (pat_name_as_multipart_yn)) : "N");
                tabdata.put("func_act", func_act != null ? ((Object) (func_act)) : "");
                tabdata.put("appt_ref_no", appt_ref_no != null ? ((Object) (appt_ref_no)) : "");
                tabdata.put("Appt_Val", httpservletrequest.getParameter("appt_yn") != null ? ((Object) (httpservletrequest.getParameter("appt_yn"))) : "");
                tabdata.put("bkg_ref_no", bkg_ref_no != null ? ((Object) (bkg_ref_no)) : "");
                tabdata.put("q_booking_type", q_booking_type);
                patient_id = httpservletrequest.getParameter("patient_id") != null ? httpservletrequest.getParameter("patient_id") : "";
                tabdata.put("patient_id", patient_id != null ? ((Object) (patient_id)) : "");
                tabdata.put("pat_ser_grp_code", httpservletrequest.getParameter("pat_ser_grp_code") != null ? ((Object) (httpservletrequest.getParameter("pat_ser_grp_code"))) : "");
                tabdata.put("pat_dtls_unknown_yn", s2);
				if(s5.length()>100){
					s5=s5.substring(0,100);
				}
                tabdata.put("patient_name", s5);
                tabdata.put("family_name", s4);
				tabdata.put("txtSmart_fn_name", txtSmart_fn_name);
				tabdata.put("uploaded_pat_yn", uploaded_pat_yn); //Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1
				//Added by Maheshwaran K for AAKH-CRF-0168
				String  national_id_no = httpservletrequest.getParameter("national_id_no") != null ? httpservletrequest.getParameter("national_id_no") : "";	
				if(dftNationalId.equals(national_id_no) && isNatIdAltIdMandVisaType==true)
				{
				//If national_id_no and Default national_id_no in MP Param are same, 
				//then national_id_no is empty and national_id_no_dft should be entered national id value
				tabdata.put("national_id_no", "");
				tabdata.put("national_id_no_dft", national_id_no);
				}
				else {
                tabdata.put("national_id_no", httpservletrequest.getParameter("national_id_no") != null ? ((Object) (httpservletrequest.getParameter("national_id_no"))) : "");
				tabdata.put("national_id_no_dft", "");
				}
				//Maheshwaran K added for the TH-KW-CRF-0019 
				String d10="";
				String d11="";
			//	System.err.println("1389====================");
			//	System.err.println("httpservletrequest.getParameter(national_id_no)===================="+httpservletrequest.getParameter("national_id_no"));
			//	System.err.println("httpservletrequest.getParameter(nat_id_exp_date)===================="+httpservletrequest.getParameter("nat_id_exp_date"));
				if(httpservletrequest.getParameter("national_id_no") != null)
				{
				d10 = httpservletrequest.getParameter("national_id_no");
				d11 = httpservletrequest.getParameter("nat_id_exp_date") != null ? httpservletrequest.getParameter("nat_id_exp_date") : "";
				}
				if(httpservletrequest.getParameter("nat_id_exp_date")!=null)
					{
						if (!d11.equals(""))
						{
							if(!locale.equals("en"))
							{
								d11= DateUtils.convertDate(d11,"DMY",locale,"en");
							}
						}
						tabdata.put("nat_id_exp_date", d11 != null ? ((Object) (d11)) : "");
					//tabdata.put("nat_id_exp_date", d11+" 00:00:00");
					}
				//Ends TH-KW-CRF-0019 
                tabdata.put("pref_facility_id", httpservletrequest.getParameter("pref_facility_id") != null ? ((Object) (httpservletrequest.getParameter("pref_facility_id"))) : ((Object) (facility_id)));
                tabdata.put("appt_yn", httpservletrequest.getParameter("appt_yn") != null ? ((Object) (httpservletrequest.getParameter("appt_yn"))) : "");
                tabdata.put("family_link_no", httpservletrequest.getParameter("family_link_no") != null ? ((Object) (httpservletrequest.getParameter("family_link_no"))) : "");
                tabdata.put("relationship_to_head", httpservletrequest.getParameter("relationship_to_head") != null ? ((Object) (httpservletrequest.getParameter("relationship_to_head"))) : "");

				tabdata.put("relationship_level", httpservletrequest.getParameter("relationship_level") == null ? "" : ((Object) (httpservletrequest.getParameter("relationship_level"))));

				tabdata.put("combined_rel_level_code", httpservletrequest.getParameter("relationship_level1_code") != null ? ((Object) (httpservletrequest.getParameter("relationship_level1_code"))) : "");

                tabdata.put("name_prefix", httpservletrequest.getParameter("name_prefix") != null ? ((Object) (httpservletrequest.getParameter("name_prefix"))) : "");
                tabdata.put("first_name", httpservletrequest.getParameter("first_name") != null ? ((Object) (httpservletrequest.getParameter("first_name"))) : "");

				String primaryMember = httpservletrequest.getParameter("primaryMember") != null ? httpservletrequest.getParameter("primaryMember") : "";
				tabdata.put("primary_nuhdeek_yn" , primaryMember);
				
				String nuhdeekReady = httpservletrequest.getParameter("nuhdeekReady") != null ? httpservletrequest.getParameter("nuhdeekReady") : "N";
				tabdata.put("nuhdeek_ready_yn" , nuhdeekReady);
				
                
				String known_allergy_yn = httpservletrequest.getParameter("known_allergy_yn") != null ? httpservletrequest.getParameter("known_allergy_yn") : "U";
				tabdata.put("known_allergy_yn" , known_allergy_yn);
				// Added the below two field for RUT-CRF-0016 IN023399 on 23.09.2010 by Suresh M
				String eye_indicator = httpservletrequest.getParameter("eye_indicator") != null ? httpservletrequest.getParameter("eye_indicator") : "";
				String Photo_upload_yn = httpservletrequest.getParameter("Photo_upload_yn") != null ? httpservletrequest.getParameter("Photo_upload_yn") : "";
				tabdata.put("eye_indicator" , eye_indicator);

				String myhix_consent = httpservletrequest.getParameter("myhix_consent") != null ? httpservletrequest.getParameter("myhix_consent") : "";
				tabdata.put("myhix_consent" , myhix_consent); //Added for MYHIX integration ML-MMOH-CRF-0507.1
				String abha_pat_id = httpservletrequest.getParameter("abha_pat_id") != null
						? httpservletrequest.getParameter("abha_pat_id")
						: "";
				tabdata.put("abha_pat_id", abha_pat_id);  //Added for ABHA integration GHL-CRF-0657.1
				tabdata.put("gcc" , gcc);//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022

				tabdata.put("Photo_upload_yn" , Photo_upload_yn);
				String deceased_yn =  httpservletrequest.getParameter("deceased_yn") != null ?  httpservletrequest.getParameter("deceased_yn") : "N";
				if(deceased_yn == "" || deceased_yn == null)
					deceased_yn="N";
				tabdata.put("deceased_yn",deceased_yn);


				 String deceased_date =  ( httpservletrequest.getParameter("deceased_date") != null ?  httpservletrequest.getParameter("deceased_date") : "" );
				if (!deceased_date.equals(""))
				{
					if(!locale.equals("en"))
					{
						deceased_date= DateUtils.convertDate(deceased_date,"DMY",locale,"en");
					}
				}
				tabdata.put("deceased_date",deceased_date);

				
				tabdata.put("dla_image",dla_image);
				tabdata.put("pat_photo",pat_photo);
				
				tabdata.put("image_yn",dla_image_yn);
				//tabdata.put("image_yn","Y");
				String patient_name_long =httpservletrequest.getParameter("patient_name_long") != null ? ( (httpservletrequest.getParameter("patient_name_long"))) : "";
				String patient_name_loc_lang_long =httpservletrequest.getParameter("patient_name_loc_lang_long") != null ? ((httpservletrequest.getParameter("patient_name_loc_lang_long"))) : "";
				
				if(patient_name_long.length()>300){
					patient_name_long=patient_name_long.substring(0,300);
				}
				
				if(patient_name_loc_lang_long.length()>300){
					patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
				}
				tabdata.put("patient_name_long", patient_name_long);
				tabdata.put("patient_name_loc_lang_long",patient_name_loc_lang_long);


            }
            catch(Exception exception2)
            {
                
				exception2.printStackTrace();
            }

            tabdata.put("operation", httpservletrequest.getParameter("operation") != null ? ((Object) (httpservletrequest.getParameter("operation"))) : ""); /*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12*/
            tabdata.put("second_name", httpservletrequest.getParameter("second_name") != null ? ((Object) (httpservletrequest.getParameter("second_name"))) : "");
            tabdata.put("third_name", httpservletrequest.getParameter("third_name") != null ? ((Object) (httpservletrequest.getParameter("third_name"))) : "");
            tabdata.put("name_suffix", httpservletrequest.getParameter("name_suffix") != null ? ((Object) (httpservletrequest.getParameter("name_suffix"))) : "");
            String s8 = httpservletrequest.getParameter("name_prefix_oth_lang") != null ? httpservletrequest.getParameter("name_prefix_oth_lang") : "";
            if(s8.equals("null"))
                s8 = "";

            String s10 = httpservletrequest.getParameter("first_name_oth_lang") != null ? httpservletrequest.getParameter("first_name_oth_lang") : "";
            String s12 = httpservletrequest.getParameter("family_name_oth_lang") != null ? httpservletrequest.getParameter("family_name_oth_lang") : "";
            String s14 = httpservletrequest.getParameter("second_name_oth_lang") != null ? httpservletrequest.getParameter("second_name_oth_lang") : "";
            String s16 = httpservletrequest.getParameter("third_name_oth_lang") != null ? httpservletrequest.getParameter("third_name_oth_lang") : "";
            String s17 = httpservletrequest.getParameter("patient_name_loc_lang") != null ? httpservletrequest.getParameter("patient_name_loc_lang") : "";
            String s18 = httpservletrequest.getParameter("name_suffix_oth_lang") != null ? httpservletrequest.getParameter("name_suffix_oth_lang") : "";

            if(s18.equals("null"))
                s18 = "";
          String greg_date_of_birth = httpservletrequest.getParameter("Birth_Date") != null ? httpservletrequest.getParameter("Birth_Date") : "";
           
		   if (!greg_date_of_birth.equals(""))
			{
				if(!locale.equals("en"))
				{
					greg_date_of_birth= DateUtils.convertDate(greg_date_of_birth,"DMYHMS",locale,"en");
				}
			}
			if(s17.length()>100){
				s17=s17.substring(0,100);
			}
			//Below line added for this incident  [IN:045958]
			s17=s17.trim();
			
			
            tabdata.put("name_prefix_loc_lang", s8 != null ? ((Object) (s8)) : "");
            tabdata.put("first_name_loc_lang", s10 != null ? ((Object) (s10)) : "");
            tabdata.put("second_name_loc_lang", s14 != null ? ((Object) (s14)) : "");
            tabdata.put("third_name_loc_lang", s16 != null ? ((Object) (s16)) : "");
            tabdata.put("family_name_loc_lang", s12 != null ? ((Object) (s12)) : "");
            tabdata.put("name_suffix_loc_lang", s18 != null ? ((Object) (s18)) : "");
            tabdata.put("patient_name_loc_lang", s17 != null ? ((Object) (s17)) : "");
            tabdata.put("sex", httpservletrequest.getParameter("sex"));
            tabdata.put("date_of_birth", greg_date_of_birth);
            tabdata.put("age_or_dob", httpservletrequest.getParameter("age_or_dob") != null ? ((Object) (httpservletrequest.getParameter("age_or_dob"))) : "N");
            tabdata.put("blood_donor", httpservletrequest.getParameter("blood_donor") != null ? ((Object) (httpservletrequest.getParameter("blood_donor"))) : "N");//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
            tabdata.put("visa_type", httpservletrequest.getParameter("visa_type") != null ? ((Object) (httpservletrequest.getParameter("visa_type"))) : "");//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
            tabdata.put("b_age", httpservletrequest.getParameter("b_age") != null ? ((Object) (httpservletrequest.getParameter("b_age"))) : "");
            tabdata.put("b_months", httpservletrequest.getParameter("b_months") != null ? ((Object) (httpservletrequest.getParameter("b_months"))) : "");
            tabdata.put("b_days", httpservletrequest.getParameter("b_days") != null ? ((Object) (httpservletrequest.getParameter("b_days"))) : "");
            tabdata.put("b_hours", httpservletrequest.getParameter("b_days") != null ? ((Object) (httpservletrequest.getParameter("b_hours"))) : "");

			tabdata.put("blood_group", httpservletrequest.getParameter("blood_group") != null ? ((Object) (httpservletrequest.getParameter("blood_group"))) : "");
			tabdata.put("rf_code", httpservletrequest.getParameter("rf_code") != null ? ((Object) (httpservletrequest.getParameter("rf_code"))) : "");

            tabdata.put("maintain_doc_or_file", httpservletrequest.getParameter("maintain_doc_or_file") != null ? ((Object) (httpservletrequest.getParameter("maintain_doc_or_file"))) : "F");
            String s19 = httpservletrequest.getParameter("place_of_birth_desc") != null ? httpservletrequest.getParameter("place_of_birth_desc") : "";
            if(s19.equals(""))
                tabdata.put("birth_place_code", "");
            else
                tabdata.put("birth_place_code", httpservletrequest.getParameter("place_of_birth_code") != null ? ((Object) (httpservletrequest.getParameter("place_of_birth_code"))) : "");
            tabdata.put("place_of_birth", httpservletrequest.getParameter("place_of_birth") != null ? ((Object) (httpservletrequest.getParameter("place_of_birth"))) : "");
            tabdata.put("mar_status_code", httpservletrequest.getParameter("mar_status_code") != null ? ((Object) (httpservletrequest.getParameter("mar_status_code"))) : "");
            tabdata.put("alias_name", httpservletrequest.getParameter("alias_name") != null ? ((Object) (httpservletrequest.getParameter("alias_name"))) : "");
            tabdata.put("household_monthly_income", httpservletrequest.getParameter("household_monthly_income") != null ? ((Object) (httpservletrequest.getParameter("household_monthly_income"))) : ""); //Added by Suji Keerthi for ML-MMOH-CRF-1527
            tabdata.put("mother_maiden_name", httpservletrequest.getParameter("mother_maiden_name") != null ? ((Object) (httpservletrequest.getParameter("mother_maiden_name"))) : "");
            tabdata.put("relgn_code", httpservletrequest.getParameter("relgn_code") != null ? ((Object) (httpservletrequest.getParameter("relgn_code"))) : "");

			tabdata.put("language_code", httpservletrequest.getParameter("language_code") != null ? ((Object) (httpservletrequest.getParameter("language_code"))) : "");
            tabdata.put("upt_contact_dtls_oa_yn", httpservletrequest.getParameter("upt_contact_dtls_oa_yn") != null ? ((Object) (httpservletrequest.getParameter("upt_contact_dtls_oa_yn"))) : "N");//added changes for HSA-CRF-0226 [IN:050599]
            tabdata.put("upd_pat_dtls_referral_yn", httpservletrequest.getParameter("upd_pat_dtls_referral_yn") != null ? ((Object) (httpservletrequest.getParameter("upd_pat_dtls_referral_yn"))) : "N");//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
			

			tabdata.put("race_code", httpservletrequest.getParameter("race_code") != null ? ((Object) (httpservletrequest.getParameter("race_code"))) : "");
			tabdata.put("a_race_code", httpservletrequest.getParameter("a_race_code") != null ? ((Object) (httpservletrequest.getParameter("a_race_code"))) : ""); //Added by Suji Keerthi for ML-MMOH-CRF-1527
            tabdata.put("pat_cat_code", httpservletrequest.getParameter("pat_cat_code") != null ? ((Object) (httpservletrequest.getParameter("pat_cat_code"))) : "");
            tabdata.put("ref_source_code", httpservletrequest.getParameter("ref_source_code") != null ? ((Object) (httpservletrequest.getParameter("ref_source_code"))) : "");
            tabdata.put("nationality_code", httpservletrequest.getParameter("nationality_code") != null ? ((Object) (httpservletrequest.getParameter("nationality_code"))) : "");
            tabdata.put("family_org_id", httpservletrequest.getParameter("org_id") != null ? ((Object) (httpservletrequest.getParameter("org_id"))) : "");
            tabdata.put("family_org_sub_id", httpservletrequest.getParameter("sub_organization") != null ? ((Object) (httpservletrequest.getParameter("sub_organization"))) : "");
            tabdata.put("family_org_membership", httpservletrequest.getParameter("family_org_membership") != null ? ((Object) (httpservletrequest.getParameter("family_org_membership"))) : "");
			String pat_cat_code_exp_date = ( (httpservletrequest.getParameter("pat_cat_code_exp_date") != null) ? httpservletrequest.getParameter("pat_cat_code_exp_date") : "");
			if (!pat_cat_code_exp_date.equals(""))
			{
				if(!locale.equals("en"))
				{
					pat_cat_code_exp_date= DateUtils.convertDate(pat_cat_code_exp_date,"DMY",locale,"en");
				}
			}
            tabdata.put("pat_cat_code_exp_date", pat_cat_code_exp_date);
            function_id = httpservletrequest.getParameter("function_id");
			
            if(function_id == null)
                function_id = "";
			tabdata.put("calling_function_id", function_id);
			if(function_id.equals("EMERG_REG"))
			{
				function_id = "Y";
			}
			else if(function_id.equals("RAPID_REG"))
			{
				function_id = "R";
			}
			else
			{
				function_id = "N";
			}
            tabdata.put("emeg_regn_yn", function_id);
            //tabdata.put("emeg_regn_yn", function_id.equals("EMERG_REG") ? "Y" : "N");
            tabdata.put("fromNewBorn", function_id.equals("NEWBORN_REG") ? "Y" : "N");
            tabdata.put("sStyle", sStyle);
            String s20 = "";
            String s21 = "";
            String s22 = "";
            String s23 = "";
            String s24 = "";
            String s25 = "";
            String s26 = "";
            String s27 = "";
			
			
			
			
            tabdata.put("res_addr_line1", httpservletrequest.getParameter("r_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("r_addr_line1"))) : "");
            tabdata.put("res_addr_line2", httpservletrequest.getParameter("r_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("r_addr_line2"))) : "");
            tabdata.put("res_addr_line3", httpservletrequest.getParameter("r_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("r_addr_line3"))) : "");
            tabdata.put("res_addr_line4", httpservletrequest.getParameter("r_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("r_addr_line4"))) : "");
            tabdata.put("res_postal_code", httpservletrequest.getParameter("r_postal_code") != null ? ((Object) (httpservletrequest.getParameter("r_postal_code"))) : "");
            tabdata.put("res_country_code", httpservletrequest.getParameter("r_country_code") != null ? ((Object) (httpservletrequest.getParameter("r_country_code"))) : "");
            tabdata.put("res_area_code", httpservletrequest.getParameter("r_area") != null ? ((Object) (httpservletrequest.getParameter("r_area"))) : "");
            tabdata.put("res_town_code", httpservletrequest.getParameter("r_town") != null ? ((Object) (httpservletrequest.getParameter("r_town"))) : "");
            tabdata.put("res_region_code", httpservletrequest.getParameter("r_region") != null ? ((Object) (httpservletrequest.getParameter("r_region"))) : "");
            tabdata.put("res_invalid_yn", httpservletrequest.getParameter("r_invalid_yn") != null ? ((Object) (httpservletrequest.getParameter("r_invalid_yn"))) : "N");
            tabdata.put("res_contact_name", httpservletrequest.getParameter("r_contact_name") != null ? ((Object) (httpservletrequest.getParameter("r_contact_name"))) : "");
            tabdata.put("res_town_desc", httpservletrequest.getParameter("town_desc") != null ? ((Object) (httpservletrequest.getParameter("town_desc"))) : "");
            tabdata.put("mail_addr_line1", httpservletrequest.getParameter("m_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("m_addr_line1"))) : "");
            tabdata.put("mail_addr_line2", httpservletrequest.getParameter("m_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("m_addr_line2"))) : "");
            tabdata.put("mail_addr_line3", httpservletrequest.getParameter("m_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("m_addr_line3"))) : "");
            tabdata.put("mail_addr_line4", httpservletrequest.getParameter("m_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("m_addr_line4"))) : "");
            tabdata.put("mail_postal_code", httpservletrequest.getParameter("m_postal_code") != null ? ((Object) (httpservletrequest.getParameter("m_postal_code"))) : "");
            tabdata.put("mail_country_code", httpservletrequest.getParameter("m_country_code") != null ? ((Object) (httpservletrequest.getParameter("m_country_code"))) : "");
            tabdata.put("mail_town_code", httpservletrequest.getParameter("m_town") != null ? ((Object) (httpservletrequest.getParameter("m_town"))) : "");
            tabdata.put("mail_area_code", httpservletrequest.getParameter("m_area") != null ? ((Object) (httpservletrequest.getParameter("m_area"))) : "");
            tabdata.put("mail_region_code", httpservletrequest.getParameter("m_region") != null ? ((Object) (httpservletrequest.getParameter("m_region"))) : "");
            tabdata.put("res_area2_code", httpservletrequest.getParameter("m_area") != null ? ((Object) (httpservletrequest.getParameter("m_area"))) : "");
            tabdata.put("res_town2_code", httpservletrequest.getParameter("m_town") != null ? ((Object) (httpservletrequest.getParameter("m_town"))) : "");
            tabdata.put("region2_code", httpservletrequest.getParameter("m_region") != null ? ((Object) (httpservletrequest.getParameter("m_region"))) : "");
            tabdata.put("mail_contact_name", httpservletrequest.getParameter("m_contact_name") != null ? ((Object) (httpservletrequest.getParameter("m_contact_name"))) : "");
            tabdata.put("next_contact_relation", httpservletrequest.getParameter("next_contact_relation") != null ? ((Object) (httpservletrequest.getParameter("next_contact_relation"))) : "");
            tabdata.put("next_job_title", httpservletrequest.getParameter("next_job_title") != null ? ((Object) (httpservletrequest.getParameter("next_job_title"))) : "");
            tabdata.put("next_addr_line1", httpservletrequest.getParameter("next_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("next_addr_line1"))) : "");
            tabdata.put("next_addr_line2", httpservletrequest.getParameter("next_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("next_addr_line2"))) : "");
            tabdata.put("next_addr_line3", httpservletrequest.getParameter("next_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("next_addr_line3"))) : "");
            tabdata.put("next_addr_line4", httpservletrequest.getParameter("next_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("next_addr_line4"))) : "");
            tabdata.put("next_postal_code", httpservletrequest.getParameter("next_postal_code") != null ? ((Object) (httpservletrequest.getParameter("next_postal_code"))) : "");
            tabdata.put("next_country_code", httpservletrequest.getParameter("next_country_code") != null ? ((Object) (httpservletrequest.getParameter("next_country_code"))) : "");
            tabdata.put("contact1_res_area_code", httpservletrequest.getParameter("n_area") != null ? ((Object) (httpservletrequest.getParameter("n_area"))) : "");
            tabdata.put("contact1_region_code", httpservletrequest.getParameter("n_region") != null ? ((Object) (httpservletrequest.getParameter("n_region"))) : "");
            tabdata.put("contact1_res_town_code", httpservletrequest.getParameter("n_town") != null ? ((Object) (httpservletrequest.getParameter("n_town"))) : "");
            //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
            tabdata.put("n_next_addr_line1", httpservletrequest.getParameter("n_next_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("n_next_addr_line1"))) : "");
			tabdata.put("n_ma_addr_line2", httpservletrequest.getParameter("n_ma_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("n_ma_addr_line2"))) : "");
			tabdata.put("n_ma_addr_line3", httpservletrequest.getParameter("n_ma_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("n_ma_addr_line3"))) : "");
			tabdata.put("n_ma_addr_line4", httpservletrequest.getParameter("n_ma_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("n_ma_addr_line4"))) : "");
			tabdata.put("n_contact_ma_town_code", httpservletrequest.getParameter("nkma_town") != null ? ((Object) (httpservletrequest.getParameter("nkma_town"))) : "");
			tabdata.put("n_contac_region_code", httpservletrequest.getParameter("contact1_region") != null ? ((Object) (httpservletrequest.getParameter("contact1_region"))) : "");
			tabdata.put("n_contact_ma_area_code", httpservletrequest.getParameter("nkma_area") != null ? ((Object) (httpservletrequest.getParameter("nkma_area"))) : "");
			tabdata.put("n_ma_postal_code", httpservletrequest.getParameter("n_ma_postal_code") != null ? ((Object) (httpservletrequest.getParameter("n_ma_postal_code"))) : "");
			tabdata.put("nkin_m_country_desc", httpservletrequest.getParameter("nkin_mail_country_code") != null ? ((Object) (httpservletrequest.getParameter("nkin_mail_country_code"))) : "");
			tabdata.put("resadd_contact_name", httpservletrequest.getParameter("ra_contact_name") != null ? ((Object) (httpservletrequest.getParameter("ra_contact_name"))) : "");
			tabdata.put("mailadd_contact_name", httpservletrequest.getParameter("ma_contact_name") != null ? ((Object) (httpservletrequest.getParameter("ma_contact_name"))) : "");
            
			tabdata.put("fton_mail_addr_line1", httpservletrequest.getParameter("fton_mail_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("fton_mail_addr_line1"))) : "");
			tabdata.put("fton_mail_addr_line2", httpservletrequest.getParameter("fton_mail_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("fton_mail_addr_line2"))) : "");
			tabdata.put("fton_mail_addr_line3", httpservletrequest.getParameter("fton_mail_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("fton_mail_addr_line3"))) : "");
			tabdata.put("fton_mail_addr_line4", httpservletrequest.getParameter("fton_mail_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("fton_mail_addr_line4"))) : "");
			tabdata.put("fst_to_no_ma_town_code", httpservletrequest.getParameter("contact2_res_town") != null ? ((Object) (httpservletrequest.getParameter("contact2_res_town"))) : "");
			tabdata.put("fst_to_no_ma_reg_cod", httpservletrequest.getParameter("contact2_region") != null ? ((Object) (httpservletrequest.getParameter("contact2_region"))) : "");
			tabdata.put("fst_to_no_ma_area_code", httpservletrequest.getParameter("contact2_res_area") != null ? ((Object) (httpservletrequest.getParameter("contact2_res_area"))) : "");
			tabdata.put("fst_no_ma_pos_cod", httpservletrequest.getParameter("fst_no_ma_pos_cod") != null ? ((Object) (httpservletrequest.getParameter("fst_no_ma_pos_cod"))) : "");
            tabdata.put("fton_m_country_desc", httpservletrequest.getParameter("first_mail_country_code") != null ? ((Object) (httpservletrequest.getParameter("first_mail_country_code"))) : "");
			tabdata.put("fton_resadd_contact_name", httpservletrequest.getParameter("fton_ra_contact_name") != null ? ((Object) (httpservletrequest.getParameter("fton_ra_contact_name"))) : "");
			tabdata.put("fton_mailadd_contact_name", httpservletrequest.getParameter("fton_ma_contact_name") != null ? ((Object) (httpservletrequest.getParameter("fton_ma_contact_name"))) : "");
            //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
            tabdata.put("contact1_new_nat_id_no", httpservletrequest.getParameter("contact1_new_nat_id_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_new_nat_id_no"))) : "");
            tabdata.put("contact1_alt_id1_type", httpservletrequest.getParameter("contact1_alt_id1_type") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id1_type"))) : "");
            tabdata.put("contact1_alt_id1_no", httpservletrequest.getParameter("contact1_alt_id1_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id1_no"))) : "");
            tabdata.put("contact1_alt_id2_type", httpservletrequest.getParameter("contact1_alt_id2_type") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id2_type"))) : "");
            tabdata.put("contact1_alt_id2_no", httpservletrequest.getParameter("contact1_alt_id2_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id2_no"))) : "");
            tabdata.put("contact1_alt_id3_type", httpservletrequest.getParameter("contact1_alt_id3_type") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id3_type"))) : "");
            tabdata.put("contact1_alt_id3_no", httpservletrequest.getParameter("contact1_alt_id3_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id3_no"))) : "");
            tabdata.put("contact1_alt_id4_type", httpservletrequest.getParameter("contact1_alt_id4_type") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id4_type"))) : "");
            tabdata.put("contact1_alt_id4_no", httpservletrequest.getParameter("contact1_alt_id4_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_alt_id4_no"))) : "");
            tabdata.put("contact1_oth_alt_id_type", httpservletrequest.getParameter("contact1_oth_alt_id_type") != null ? ((Object) (httpservletrequest.getParameter("contact1_oth_alt_id_type"))) : "");
            tabdata.put("contact1_oth_alt_id_no", httpservletrequest.getParameter("contact1_oth_alt_id_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_oth_alt_id_no"))) : "");
            tabdata.put("notify_oth_alt_id_type", httpservletrequest.getParameter("notify_oth_alt_id_type") != null ? ((Object) (httpservletrequest.getParameter("notify_oth_alt_id_type"))) : "");
            tabdata.put("notify_oth_alt_id_text", httpservletrequest.getParameter("notify_oth_alt_id_text") != null ? ((Object) (httpservletrequest.getParameter("notify_oth_alt_id_text"))) : "");
			String contact1_birth_date =  ( httpservletrequest.getParameter("contact1_birth_date") != null ?  httpservletrequest.getParameter("contact1_birth_date") : "" );
			if (!contact1_birth_date.equals(""))
			{
				if(!locale.equals("en"))
				{
					contact1_birth_date= DateUtils.convertDate(contact1_birth_date,"DMY",locale,"en");
				}
			}
            tabdata.put("contact1_birth_date",contact1_birth_date);
            tabdata.put("next_res_tel_no", httpservletrequest.getParameter("next_res_tel_no") != null ? ((Object) (httpservletrequest.getParameter("next_res_tel_no"))) : "");
            tabdata.put("next_off_tel_no", httpservletrequest.getParameter("next_off_tel_no") != null ? ((Object) (httpservletrequest.getParameter("next_off_tel_no"))) : "");
            tabdata.put("contact1_mob_tel_no", httpservletrequest.getParameter("contact1_mob_tel_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_mob_tel_no"))) : "");
            //Added by Ajay Hatwate for ML-MMOH-CRF-1930
            tabdata.put("CONTACT1_MOB_COUNTRY_CODE", httpservletrequest.getParameter("CountryCodeNxtOfKin") != null ? ((Object) (httpservletrequest.getParameter("CountryCodeNxtOfKin"))) : "");
            tabdata.put("contact1_email_id", httpservletrequest.getParameter("contact1_email_id") != null ? ((Object) (httpservletrequest.getParameter("contact1_email_id"))) : "");
            tabdata.put("next_contact_name", httpservletrequest.getParameter("next_contact_name") != null ? ((Object) (httpservletrequest.getParameter("next_contact_name"))) : "");
			//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US007
            tabdata.put("rel_alias_name", httpservletrequest.getParameter("rel_alias_name") != null ? ((Object) (httpservletrequest.getParameter("rel_alias_name"))) : ""); 
            tabdata.put("rel_nationality_code", httpservletrequest.getParameter("rel_nationality_code") != null ? ((Object) (httpservletrequest.getParameter("rel_nationality_code"))) : "");
            tabdata.put("rel_race_code", httpservletrequest.getParameter("rel_race_code") != null ? ((Object) (httpservletrequest.getParameter("rel_race_code"))) : "");
			//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US007
            tabdata.put("first_contact_relation", httpservletrequest.getParameter("first_contact_relation") != null ? ((Object) (httpservletrequest.getParameter("first_contact_relation"))) : "");
            tabdata.put("first_contact_name", httpservletrequest.getParameter("first_contact_name") != null ? ((Object) (httpservletrequest.getParameter("first_contact_name"))) : "");
            tabdata.put("occ_class", httpservletrequest.getParameter("occ_class") != null ? ((Object) (httpservletrequest.getParameter("occ_class"))) : "");
            tabdata.put("legal_yn", httpservletrequest.getParameter("legal_yn") != null ? ((Object) (httpservletrequest.getParameter("legal_yn"))) : "Y");
            tabdata.put("citizen_yn", httpservletrequest.getParameter("citizen_yn") != null ? ((Object) (httpservletrequest.getParameter("citizen_yn"))) : "Y");
            tabdata.put("ethnic_group", httpservletrequest.getParameter("ethnic_group") != null ? ((Object) (httpservletrequest.getParameter("ethnic_group"))) : "");
            tabdata.put("first_job_title", httpservletrequest.getParameter("first_job_title") != null ? ((Object) (httpservletrequest.getParameter("first_job_title"))) : "");
            tabdata.put("first_addr_line1", httpservletrequest.getParameter("first_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("first_addr_line1"))) : "");
            tabdata.put("first_addr_line2", httpservletrequest.getParameter("first_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("first_addr_line2"))) : "");
            tabdata.put("first_addr_line3", httpservletrequest.getParameter("first_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("first_addr_line3"))) : "");
            tabdata.put("first_addr_line4", httpservletrequest.getParameter("first_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("first_addr_line4"))) : "");
            tabdata.put("contact2_mob_tel_no", httpservletrequest.getParameter("contact2_mob_tel_no") != null ? ((Object) (httpservletrequest.getParameter("contact2_mob_tel_no"))) : "");
            tabdata.put("contact2_email_id", httpservletrequest.getParameter("contact2_email_id") != null ? ((Object) (httpservletrequest.getParameter("contact2_email_id"))) : "");
            tabdata.put("contact2_res_area_code", httpservletrequest.getParameter("f_area") != null ? ((Object) (httpservletrequest.getParameter("f_area"))) : "");
            tabdata.put("contact2_region_code", httpservletrequest.getParameter("f_region") != null ? ((Object) (httpservletrequest.getParameter("f_region"))) : "");
            tabdata.put("contact2_res_town_code", httpservletrequest.getParameter("f_town") != null ? ((Object) (httpservletrequest.getParameter("f_town"))) : "");
            tabdata.put("first_country_code", httpservletrequest.getParameter("first_country_code") != null ? ((Object) (httpservletrequest.getParameter("first_country_code"))) : "");
            tabdata.put("first_postal_code", httpservletrequest.getParameter("first_postal_code") != null ? ((Object) (httpservletrequest.getParameter("first_postal_code"))) : "");
            tabdata.put("first_res_tel_no", httpservletrequest.getParameter("first_res_tel_no") != null ? ((Object) (httpservletrequest.getParameter("first_res_tel_no"))) : "");
            tabdata.put("first_off_tel_no", httpservletrequest.getParameter("first_off_tel_no") != null ? ((Object) (httpservletrequest.getParameter("first_off_tel_no"))) : "");
            tabdata.put("contact2_nat_id_no", httpservletrequest.getParameter("contact2_nat_id_no") != null ? ((Object) (httpservletrequest.getParameter("contact2_nat_id_no"))) : "");
            tabdata.put("empyr_contact_relation", httpservletrequest.getParameter("empyr_contact_relation") != null ? ((Object) (httpservletrequest.getParameter("empyr_contact_relation"))) : "");
            tabdata.put("empyr_contact_name", httpservletrequest.getParameter("empyr_contact_name") != null ? ((Object) (httpservletrequest.getParameter("empyr_contact_name"))) : "");
            tabdata.put("empyr_job_title", httpservletrequest.getParameter("empyr_job_title") != null ? ((Object) (httpservletrequest.getParameter("empyr_job_title"))) : "");
            tabdata.put("empyr_ocpn_code", httpservletrequest.getParameter("empyr_ocpn_code") != null ? ((Object) (httpservletrequest.getParameter("empyr_ocpn_code"))) : "");
            tabdata.put("other_alt_id", httpservletrequest.getParameter("other_alt_id") != null ? ((Object) (httpservletrequest.getParameter("other_alt_id"))) : "");
            tabdata.put("other_alt_Id_text", httpservletrequest.getParameter("other_alt_Id_text") != null ? ((Object) (httpservletrequest.getParameter("other_alt_Id_text"))) : "");
            tabdata.put("empyr_eid", httpservletrequest.getParameter("empyr_eid") != null ? ((Object) (httpservletrequest.getParameter("empyr_eid"))) : "");
            tabdata.put("empyr_employment_status", httpservletrequest.getParameter("empyr_employment_status") != null ? ((Object) (httpservletrequest.getParameter("empyr_employment_status"))) : "");
            tabdata.put("empyr_ocpn_desc", httpservletrequest.getParameter("empyr_ocpn_desc") != null ? ((Object) (httpservletrequest.getParameter("empyr_ocpn_desc"))) : "");
            tabdata.put("employ_addr_line1", httpservletrequest.getParameter("employ_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("employ_addr_line1"))) : "");
            tabdata.put("employ_addr_line2", httpservletrequest.getParameter("employ_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("employ_addr_line2"))) : "");
            tabdata.put("employ_addr_line3", httpservletrequest.getParameter("employ_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("employ_addr_line3"))) : "");
            tabdata.put("employ_addr_line4", httpservletrequest.getParameter("employ_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("employ_addr_line4"))) : "");
            tabdata.put("employ_postal_code", httpservletrequest.getParameter("employ_postal_code") != null ? ((Object) (httpservletrequest.getParameter("employ_postal_code"))) : "");
            tabdata.put("empyr_country_code", httpservletrequest.getParameter("empyr_country_code") != null ? ((Object) (httpservletrequest.getParameter("empyr_country_code"))) : "");
            tabdata.put("contact3_res_area_code", httpservletrequest.getParameter("e_area") != null ? ((Object) (httpservletrequest.getParameter("e_area"))) : "");
            tabdata.put("contact3_res_town_code", httpservletrequest.getParameter("e_town") != null ? ((Object) (httpservletrequest.getParameter("e_town"))) : "");
            tabdata.put("contact3_region_code", httpservletrequest.getParameter("e_region") != null ? ((Object) (httpservletrequest.getParameter("e_region"))) : "");
            tabdata.put("organization_name", httpservletrequest.getParameter("organization_name") != null ? ((Object) (httpservletrequest.getParameter("organization_name"))) : "");
            tabdata.put("res3_tel_no", httpservletrequest.getParameter("res3_tel_no") != null ? ((Object) (httpservletrequest.getParameter("res3_tel_no"))) : "");
            tabdata.put("occ_of_per", httpservletrequest.getParameter("occ_of_per") != null ? ((Object) (httpservletrequest.getParameter("occ_of_per"))) : "");
            tabdata.put("occu_of_per_desc", httpservletrequest.getParameter("occu_of_per_desc") != null ? ((Object) (httpservletrequest.getParameter("occu_of_per_desc"))) : "");
            tabdata.put("empyr_off_tel_no", httpservletrequest.getParameter("empyr_off_tel_no") != null ? ((Object) (httpservletrequest.getParameter("empyr_off_tel_no"))) : "");
            tabdata.put("empyr_off_fax_no", httpservletrequest.getParameter("empyr_off_fax_no") != null ? ((Object) (httpservletrequest.getParameter("empyr_off_fax_no"))) : "");
            tabdata.put("email_id", httpservletrequest.getParameter("email") != null ? ((Object) (httpservletrequest.getParameter("email"))) : "");
            tabdata.put("blood_grp", httpservletrequest.getParameter("blood_grp") != null ? ((Object) (httpservletrequest.getParameter("blood_grp"))) : "");
            tabdata.put("rh_factor", httpservletrequest.getParameter("rh_factor") != null ? ((Object) (httpservletrequest.getParameter("rh_factor"))) : "");
            tabdata.put("living_dependency", httpservletrequest.getParameter("living_dependency") != null ? ((Object) (httpservletrequest.getParameter("living_dependency"))) : "UN");
            tabdata.put("living_arrangement", httpservletrequest.getParameter("living_arrangement") != null ? ((Object) (httpservletrequest.getParameter("living_arrangement"))) : "U");
            tabdata.put("education_level", httpservletrequest.getParameter("education_level") != null ? ((Object) (httpservletrequest.getParameter("education_level"))) : "");
            tabdata.put("education_level", httpservletrequest.getParameter("education_level") != null ? ((Object) (httpservletrequest.getParameter("education_level"))) : "");
            tabdata.put("regn_informant", httpservletrequest.getParameter("regn_informant") != null ? ((Object) (httpservletrequest.getParameter("regn_informant"))) : "");
            tabdata.put("regn_comments", httpservletrequest.getParameter("regn_comments") != null ? ((Object) (httpservletrequest.getParameter("regn_comments"))) : "");
            tabdata.put("general_remarks", httpservletrequest.getParameter("general_remarks") != null ? ((Object) (httpservletrequest.getParameter("general_remarks"))) : "");
            tabdata.put("photo_file_name", httpservletrequest.getParameter("photo_file_name") != null ? ((Object) (httpservletrequest.getParameter("photo_file_name"))) : "");
            String s28 = httpservletrequest.getParameter("age_or_dob") != null ? httpservletrequest.getParameter("age_or_dob") : "N";
            tabdata.put("calculated_age_yn", s28);
			
			/*Below line added for this CRF ML-MMOH-CRF-0860.2*/
			tabdata.put("alt_addr_line1", httpservletrequest.getParameter("a_addr_line1") != null ? ((Object) (httpservletrequest.getParameter("a_addr_line1"))) : "");
            tabdata.put("alt_addr_line2", httpservletrequest.getParameter("a_addr_line2") != null ? ((Object) (httpservletrequest.getParameter("a_addr_line2"))) : "");
            tabdata.put("alt_addr_line3", httpservletrequest.getParameter("a_addr_line3") != null ? ((Object) (httpservletrequest.getParameter("a_addr_line3"))) : "");
            tabdata.put("alt_addr_line4", httpservletrequest.getParameter("a_addr_line4") != null ? ((Object) (httpservletrequest.getParameter("a_addr_line4"))) : "");
            tabdata.put("alt_postal_code", httpservletrequest.getParameter("alt_postal_code") != null ? ((Object) (httpservletrequest.getParameter("alt_postal_code"))) : "");
            tabdata.put("alt_country_code", httpservletrequest.getParameter("a_country_code") != null ? ((Object) (httpservletrequest.getParameter("a_country_code"))) : "");
            tabdata.put("alt_area_code", httpservletrequest.getParameter("a_area") != null ? ((Object) (httpservletrequest.getParameter("a_area"))) : "");
            tabdata.put("alt_town_code", httpservletrequest.getParameter("a_town") != null ? ((Object) (httpservletrequest.getParameter("a_town"))) : "");
            tabdata.put("alt_region_code", httpservletrequest.getParameter("a_region") != null ? ((Object) (httpservletrequest.getParameter("a_region"))) : "");
            tabdata.put("alt_invalid_yn", httpservletrequest.getParameter("a_invalid_yn") != null ? ((Object) (httpservletrequest.getParameter("a_invalid_yn"))) : "N");
            tabdata.put("alt_contact_name", httpservletrequest.getParameter("a_contact_name") != null ? ((Object) (httpservletrequest.getParameter("a_contact_name"))) : ""); 			
			//End ML-MMOH-CRF-0860.2 			
			
            String s29 = "";
            String s30 = "";
            String s31 = "";
            String s32 = "";
            String s33 = "";
            String s34 = "";
            String s35 = "";
            String s36 = "";
            String s37 = httpservletrequest.getParameter("alt_id1_type") != null ? httpservletrequest.getParameter("alt_id1_type") : "";
            if(httpservletrequest.getParameter("alt_id1_no") != null)
            {
                alt_id1_no = httpservletrequest.getParameter("alt_id1_no");
                s29 = httpservletrequest.getParameter("alt_id1_exp_date") != null ? httpservletrequest.getParameter("alt_id1_exp_date") : "";
				if (!s29.equals(""))
				{
					if(!locale.equals("en"))
					{
						s29= DateUtils.convertDate(s29,"DMY",locale,"en");
					}
				}
            } else
            {
                alt_id1_no = "";
                s29 = "";
            }
            if(alt_id1_no.equals(""))
                s37 = "";
            if(httpservletrequest.getParameter("alt_id1_db") != null)
                s36 = httpservletrequest.getParameter("alt_id1_db");
            tabdata.put("alt_id1_type", s37 != null ? ((Object) (s37)) : "");
            tabdata.put("alt_id1_no", alt_id1_no != null ? ((Object) (alt_id1_no)) : "");
            tabdata.put("alt_id1_db", s36 != null ? ((Object) (s36)) : "");
            tabdata.put("alt_id1_exp_date", s29 != null ? ((Object) (s29)) : "");
            String s38 = httpservletrequest.getParameter("alt_id2_type") != null ? httpservletrequest.getParameter("alt_id2_type") : "";
            if(httpservletrequest.getParameter("alt_id2_no") != null)
            {
                s30 = httpservletrequest.getParameter("alt_id2_no");
                s31 = httpservletrequest.getParameter("alt_id2_exp_date") != null ? httpservletrequest.getParameter("alt_id2_exp_date") : "";
				if (!s31.equals(""))
				{
					if(!locale.equals("en"))
					{
						s31= DateUtils.convertDate(s31,"DMY",locale,"en");
					}
				}
            } else
            {
                s30 = "";
                s31 = "";
            }
            if(s30.equals(""))
                s38 = "";
            tabdata.put("alt_id2_type", s38 != null ? ((Object) (s38)) : "");
            tabdata.put("alt_id2_no", s30 != null ? ((Object) (s30)) : "");
            tabdata.put("alt_id2_exp_date", s31 != null ? ((Object) (s31)) : "");
            String s39 = httpservletrequest.getParameter("alt_id3_type") != null ? httpservletrequest.getParameter("alt_id3_type") : "";
            if(httpservletrequest.getParameter("alt_id3_no") != null)
            {
                s32 = httpservletrequest.getParameter("alt_id3_no");
                s33 = httpservletrequest.getParameter("alt_id3_exp_date") != null ? httpservletrequest.getParameter("alt_id3_exp_date") : "";
				if (!s33.equals(""))
				{
					if(!locale.equals("en"))
					{
						s33= DateUtils.convertDate(s33,"DMY",locale,"en");
					}
				}
            }
            if(s32.equals(""))
            {
                s39 = "";
                s33 = "";
            }
            tabdata.put("alt_id3_type", s39);
            tabdata.put("alt_id3_no", s32 != null ? ((Object) (s32)) : "");
            tabdata.put("alt_id3_exp_date", s33 != null ? ((Object) (s33)) : "");

			tabdata.put("form_60_yn", httpservletrequest.getParameter("formno60") != null ? ((Object) (httpservletrequest.getParameter("formno60"))) : "N");
			


            String s40 = httpservletrequest.getParameter("alt_id4_type") != null ? httpservletrequest.getParameter("alt_id4_type") : "";
            if(httpservletrequest.getParameter("alt_id4_no") != null)
            {
                s34 = httpservletrequest.getParameter("alt_id4_no");
                s35 = httpservletrequest.getParameter("alt_id4_exp_date") != null ? httpservletrequest.getParameter("alt_id4_exp_date") : "";
				if (!s35.equals(""))
				{
					if(!locale.equals("en"))
					{
						s35= DateUtils.convertDate(s35,"DMY",locale,"en");
					}
				}
            }
            if(s34.equals(""))
            {
                s40 = "";
                s35 = "";
            }
            tabdata.put("alt_id4_type", s40);
            tabdata.put("alt_id4_no", s34 != null ? ((Object) (s34)) : "");
            tabdata.put("alt_id4_exp_date", s35 != null ? ((Object) (s35)) : "");
            if(httpservletrequest.getParameter("contact1_no") != null)
                s23 = httpservletrequest.getParameter("contact1_no");
            tabdata.put("contact1_no", s23 != null ? ((Object) (s23)) : "");
            if(httpservletrequest.getParameter("contact2_no") != null)
                s24 = httpservletrequest.getParameter("contact2_no");
            tabdata.put("contact2_no", s24 != null ? ((Object) (s24)) : "");
            if(httpservletrequest.getParameter("contact3_mode") != null)
            {
                s25 = httpservletrequest.getParameter("contact3_no");
                s20 = httpservletrequest.getParameter("contact3_mode");
            }
            tabdata.put("contact3_mode", s25 != null ? ((Object) (s20)) : "");
            tabdata.put("contact3_no", s25 != null ? ((Object) (s25)) : "");
            if(httpservletrequest.getParameter("contact4_mode") != null)
            {
                s26 = httpservletrequest.getParameter("contact4_no");
                s21 = httpservletrequest.getParameter("contact4_mode");
            }
            tabdata.put("contact4_mode", s26 != null ? ((Object) (s21)) : "");
            tabdata.put("contact4_no", s26 != null ? ((Object) (s26)) : "");
            if(httpservletrequest.getParameter("contact5_mode") != null)
            {
                s27 = httpservletrequest.getParameter("contact5_no");
                s22 = httpservletrequest.getParameter("contact5_mode");
            }
            tabdata.put("contact5_mode", s27 != null ? ((Object) (s22)) : "");
            tabdata.put("contact5_no", s27 != null ? ((Object) (s27)) : "");
			//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
            if(httpservletrequest.getParameter("nk_contact3_mode") != null)
            {
                s25 = httpservletrequest.getParameter("nk_contact3_no");
                s20 = httpservletrequest.getParameter("nk_contact3_mode");
            }
            tabdata.put("nk_contact3_mode", s25 != null ? ((Object) (s20)) : "");
            tabdata.put("nk_contact3_no", s25 != null ? ((Object) (s25)) : "");
            if(httpservletrequest.getParameter("nk_contact4_mode") != null)
            {
                s26 = httpservletrequest.getParameter("nk_contact4_no");
                s21 = httpservletrequest.getParameter("nk_contact4_mode");
            }
            tabdata.put("nk_contact4_mode", s26 != null ? ((Object) (s21)) : "");
            tabdata.put("nk_contact4_no", s26 != null ? ((Object) (s26)) : "");
            if(httpservletrequest.getParameter("nk_contact5_mode") != null)
            {
                s27 = httpservletrequest.getParameter("nk_contact5_no");
                s22 = httpservletrequest.getParameter("nk_contact5_mode");
            }
            tabdata.put("nk_contact5_mode", s27 != null ? ((Object) (s22)) : "");
            tabdata.put("nk_contact5_no", s27 != null ? ((Object) (s27)) : "");

			if(httpservletrequest.getParameter("fton_contact3_mode") != null)
            {
                s25 = httpservletrequest.getParameter("fton_contact3_no");
                s20 = httpservletrequest.getParameter("fton_contact3_mode");
            }
            tabdata.put("fton_contact3_mode", s25 != null ? ((Object) (s20)) : "");
            tabdata.put("fton_contact3_no", s25 != null ? ((Object) (s25)) : "");
            if(httpservletrequest.getParameter("fton_contact4_mode") != null)
            {
                s26 = httpservletrequest.getParameter("fton_contact4_no");
                s21 = httpservletrequest.getParameter("fton_contact4_mode");
            }
            tabdata.put("fton_contact4_mode", s26 != null ? ((Object) (s21)) : "");
            tabdata.put("fton_contact4_no", s26 != null ? ((Object) (s26)) : "");
            if(httpservletrequest.getParameter("fton_contact5_mode") != null)
            {
                s27 = httpservletrequest.getParameter("fton_contact5_no");
                s22 = httpservletrequest.getParameter("fton_contact5_mode");
            }
            tabdata.put("fton_contact5_mode", s27 != null ? ((Object) (s22)) : "");
            tabdata.put("fton_contact5_no", s27 != null ? ((Object) (s27)) : "");
			//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
            tabdata.put("res_invalid_yn", httpservletrequest.getParameter("r_invalid_yn") != null ? ((Object) (httpservletrequest.getParameter("r_invalid_yn"))) : "N");
            tabdata.put("mail_invalid_yn", httpservletrequest.getParameter("m_invalid_yn") != null ? ((Object) (httpservletrequest.getParameter("m_invalid_yn"))) : "N");
            tabdata.put("data_source", httpservletrequest.getParameter("datasource_id") != null ? ((Object) (httpservletrequest.getParameter("datasource_id"))) : "");
            tabdata.put("pat_no_gen_yn", httpservletrequest.getParameter("pat_no_gen_yn"));
            tabdata.put("prime_language", httpservletrequest.getParameter("prime_language") != null ? ((Object) (httpservletrequest.getParameter("prime_language"))) : "");
            tabdata.put("doc1_type", httpservletrequest.getParameter("doc_id1") != null ? ((Object) (httpservletrequest.getParameter("doc_id1"))) : "");
            doc_id1=httpservletrequest.getParameter("doc_id1")!= null?((String) (httpservletrequest.getParameter("doc_id1"))) : ""; /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
			String doc_exp_dt1 = httpservletrequest.getParameter("doc_exp_dt1") != null ? httpservletrequest.getParameter("doc_exp_dt1") : "";
			if (!doc_exp_dt1.equals(""))
			{
				if(!locale.equals("en"))
				{
					doc_exp_dt1= DateUtils.convertDate(doc_exp_dt1,"DMY",locale,"en");
				}
			}
            tabdata.put("doc1_exp_date", doc_exp_dt1);
            tabdata.put("doc1_place_of_issue", httpservletrequest.getParameter("place_of_issue1") != null ? ((Object) (httpservletrequest.getParameter("place_of_issue1"))) : "");
			String issue_date1 = httpservletrequest.getParameter("issue_date1") != null ? httpservletrequest.getParameter("issue_date1") : "";
			if (!issue_date1.equals(""))
			{
				if(!locale.equals("en"))
				{
					issue_date1= DateUtils.convertDate(issue_date1,"DMY",locale,"en");
				}
			}
            tabdata.put("doc1_iss_date",issue_date1);
            tabdata.put("doc1_num", httpservletrequest.getParameter("doc_num1") != null ? ((Object) (httpservletrequest.getParameter("doc_num1"))) : "");
            tabdata.put("doc2_type", httpservletrequest.getParameter("doc_id2") != null ? ((Object) (httpservletrequest.getParameter("doc_id2"))) : "");
            doc_id2=httpservletrequest.getParameter("doc_id2") != null ? ((String) (httpservletrequest.getParameter("doc_id2"))) : ""; /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
			String doc_exp_dt2 = httpservletrequest.getParameter("doc_exp_dt2") != null ? httpservletrequest.getParameter("doc_exp_dt2") : "";
			if (!doc_exp_dt2.equals(""))
			{
				if(!locale.equals("en"))
				{
					doc_exp_dt2= DateUtils.convertDate(doc_exp_dt2,"DMY",locale,"en");
				}
			}
            tabdata.put("doc2_exp_date",doc_exp_dt2);
            tabdata.put("doc2_place_of_issue", httpservletrequest.getParameter("place_of_issue2") != null ? ((Object) (httpservletrequest.getParameter("place_of_issue2"))) : "");
			String issue_date2 = httpservletrequest.getParameter("issue_date2") != null ? httpservletrequest.getParameter("issue_date2") : "";
			if ( !issue_date2.equals("") )
			{
				if(!locale.equals("en"))
				{
					issue_date2= DateUtils.convertDate(issue_date2,"DMY",locale,"en");
				}
			}
            tabdata.put("doc2_iss_date",issue_date2);
            tabdata.put("doc2_num", httpservletrequest.getParameter("doc_num2") != null ? ((Object) (httpservletrequest.getParameter("doc_num2"))) : "");
            tabdata.put("doc3_type", httpservletrequest.getParameter("doc_id3") != null ? ((Object) (httpservletrequest.getParameter("doc_id3"))) : "");
            doc_id3=httpservletrequest.getParameter("doc_id3") != null ? ((String) (httpservletrequest.getParameter("doc_id3"))) : ""; /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
			String doc_exp_dt3 = httpservletrequest.getParameter("doc_exp_dt3") != null ? httpservletrequest.getParameter("doc_exp_dt3") : "";
			if ( !doc_exp_dt3.equals("") )
			{
				if(!locale.equals("en"))
				{
					doc_exp_dt3= DateUtils.convertDate(doc_exp_dt3,"DMY",locale,"en");
				}
			}
            tabdata.put("doc3_exp_date", doc_exp_dt3);
            tabdata.put("doc3_place_of_issue", httpservletrequest.getParameter("place_of_issue3") != null ? ((Object) (httpservletrequest.getParameter("place_of_issue3"))) : "");
			String issue_date3 = httpservletrequest.getParameter("issue_date3") != null ? httpservletrequest.getParameter("issue_date3") : "";
			if ( !issue_date3.equals("") )
			{
				if(!locale.equals("en"))
				{
					issue_date3= DateUtils.convertDate(issue_date3,"DMY",locale,"en");
				}
			}
            tabdata.put("doc3_iss_date",issue_date3);
            tabdata.put("doc3_num", httpservletrequest.getParameter("doc_num3") != null ? ((Object) (httpservletrequest.getParameter("doc_num3"))) : "");
            tabdata.put("doc4_type", httpservletrequest.getParameter("doc_id4") != null ? ((Object) (httpservletrequest.getParameter("doc_id4"))) : "");

            doc_id4=httpservletrequest.getParameter("doc_id4") != null ? ((String) (httpservletrequest.getParameter("doc_id4"))) : ""; /*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
			String doc_exp_dt4 = httpservletrequest.getParameter("doc_exp_dt4") != null ? httpservletrequest.getParameter("doc_exp_dt4") : "";
			if ( !doc_exp_dt4.equals("") )
			{
				if(!locale.equals("en"))
				{
					doc_exp_dt4= DateUtils.convertDate(doc_exp_dt4,"DMY",locale,"en");
				}
			}
            tabdata.put("doc4_exp_date",doc_exp_dt4);
            tabdata.put("doc4_place_of_issue", httpservletrequest.getParameter("place_of_issue4") != null ? ((Object) (httpservletrequest.getParameter("place_of_issue4"))) : "");
			String issue_date4 = httpservletrequest.getParameter("issue_date4") != null ? httpservletrequest.getParameter("issue_date4") : "";
			if ( !doc_exp_dt4.equals("") )
			{
				if(!locale.equals("en"))
				{
					issue_date4= DateUtils.convertDate(issue_date4,"DMY",locale,"en");
				}
			}
            tabdata.put("doc4_iss_date",issue_date4);
            tabdata.put("doc4_num", httpservletrequest.getParameter("doc_num4") != null ? ((Object) (httpservletrequest.getParameter("doc_num4"))) : "");
            tabdata.put("addl_field1", httpservletrequest.getParameter("addl_field1") != null ? ((Object) (httpservletrequest.getParameter("addl_field1"))) : "");
            tabdata.put("addl_field2", httpservletrequest.getParameter("addl_field2") != null ? ((Object) (httpservletrequest.getParameter("addl_field2"))) : "");
            tabdata.put("addl_field3", httpservletrequest.getParameter("addl_field3") != null ? ((Object) (httpservletrequest.getParameter("addl_field3"))) : "");
            tabdata.put("addl_field4", httpservletrequest.getParameter("addl_field4") != null ? ((Object) (httpservletrequest.getParameter("addl_field4"))) : "");
            tabdata.put("addl_field5", httpservletrequest.getParameter("addl_field5") != null ? ((Object) (httpservletrequest.getParameter("addl_field5"))) : "");
            AddedFacilityID = facility_id;
            if(httpservletrequest.getParameter("client_ip_address") == null)
                AddedAtWsNo = p.getProperty("client_ip_address");
            else
                AddedAtWsNo = httpservletrequest.getParameter("client_ip_address");
            addedById = p.getProperty("login_user");
			HashMap fin_dtls=(HashMap)httpsession.getAttribute("financial_details");
            String s41 = httpservletrequest.getParameter("billing_group") != null ? httpservletrequest.getParameter("billing_group") : "";
            String s42 = httpservletrequest.getParameter("dflt_pat_regn_blng_class") != null ? httpservletrequest.getParameter("dflt_pat_regn_blng_class") : "";
            tabdata.put("dflt_pat_regn_blng_class", s42);
            if(!s41.equals(""))
            {
                tabdata.put("billing_group", s41);
				if ( fin_dtls!=null )
				{
					tabdata.put("fin_dtls",(HashMap)fin_dtls);
				}
            }
			String s84 = httpservletrequest.getParameter("bl_operation");
                if(s84 == null)
                    s84 = "N";
            tabdata.put("bl_operation", s84);
            tabdata.put("added_facility_id", AddedFacilityID);
            tabdata.put("facility_id", facility_id);
            tabdata.put("biometric_reason", biometric_reason);
            tabdata.put("added_by_id", addedById);
            tabdata.put("added_at_ws_no", AddedAtWsNo);
            tabdata.put("session_id", httpsession.getId());
            tabdata.put("locale", s);
            String s44 = httpservletrequest.getParameter("generate_file");
			/*Added by Rameswar on 29-Sep-15 for Leap Year issue Start*/
			String disas_regn_date_time = httpservletrequest.getParameter("disas_regn_date_time");
			if(!locale.equals("en"))
				{
					disas_regn_date_time= DateUtils.convertDate(disas_regn_date_time,"DMYHM",locale,"en");
			
				}
			/*Added by Rameswar on 29-Sep-15 for Leap Year issue End*/
            if(s44 == null)
                s44 = "";
            tabdata.put("generate_file", s44);
            tabdata.put("referral_id", httpservletrequest.getParameter("referral_id") != null ? ((Object) (httpservletrequest.getParameter("referral_id"))) : "");
            tabdata.put("refrlAappt", httpservletrequest.getParameter("refrlAappt") != null ? ((Object) (httpservletrequest.getParameter("refrlAappt"))) : "");
            tabdata.put("refIDValue", httpservletrequest.getParameter("refIDValue") != null ? ((Object) (httpservletrequest.getParameter("refIDValue"))) : "");
            tabdata.put("date_of_birth_hj", httpservletrequest.getParameter("date_of_birth_hj") != null ? ((Object) (httpservletrequest.getParameter("date_of_birth_hj"))) : ""); //  crf MMS-QH-CRF-0145

			/*Below line Added for this CRF GDOH-CRF-0029 [IN:048764]*/
			
			tabdata.put("disas_regn_date_time", disas_regn_date_time != null ? ((Object) (disas_regn_date_time)) : ""); //Added by Rameswar on 29-Sep-15 for Leap Year issue
	
			/*tabdata.put("disas_regn_date_time", httpservletrequest.getParameter("disas_regn_date_time") != null ? ((Object) (httpservletrequest.getParameter("disas_regn_date_time"))) : ""); */ //Commented by Rameswar on 29-Sep-15 for Leap Year issue
			
			tabdata.put("old_regn_datetime", httpservletrequest.getParameter("old_regn_datetime") != null ? ((Object) (httpservletrequest.getParameter("old_regn_datetime"))) : ""); 
			// added by mujafar for KDAH-CRF-370.1  start
			if((httpservletrequest.getParameter("chkPanValidate")).equals("true"))
			{
				tabdata.put("pan_holder_name", httpservletrequest.getParameter("pan_holder_name") != null ? ((Object) (httpservletrequest.getParameter("pan_holder_name"))) : "");
				tabdata.put("pan_status", httpservletrequest.getParameter("pan_status") != null ? ((Object) (httpservletrequest.getParameter("pan_status"))) : "");
				tabdata.put("pan_trans_id", httpservletrequest.getParameter("pan_trans_id") != null ? ((Object) (httpservletrequest.getParameter("pan_trans_id"))) : ""); 
				tabdata.put("pan_rel_mem", httpservletrequest.getParameter("pan_rel_mem") != null ? ((Object) (httpservletrequest.getParameter("pan_rel_mem"))) : "");
				tabdata.put("chkPanValidate", httpservletrequest.getParameter("chkPanValidate") != null ? ((Object) (httpservletrequest.getParameter("chkPanValidate"))) : "");
				
			}
			// added by mujafar for KDAH-CRF-370.1  end 
			
            
			//End GDOH-CRF-0029 [IN:048764]
            //Added by prithivi on 14/04/2017 for KDAH-CRF-0362
			
			if((httpservletrequest.getParameter("chkAadhaarValidate")).equals("true"))
			{

				tabdata.put("aadhaarStatus", httpservletrequest.getParameter("aadhaarStatus") != null ? ((Object) (httpservletrequest.getParameter("aadhaarStatus"))) : "N");
				tabdata.put("aadhaarTransId", httpservletrequest.getParameter("aadhaarTransId") != null ? ((Object) (httpservletrequest.getParameter("aadhaarTransId"))) : "");
				tabdata.put("aadharPatPhotoStr", httpservletrequest.getParameter("aadharPatPhotoStr") != null ? ((Object) (httpservletrequest.getParameter("aadharPatPhotoStr"))) : ""); 
				tabdata.put("chkAadhaarValidate", httpservletrequest.getParameter("chkAadhaarValidate") != null ? ((Object) (httpservletrequest.getParameter("chkAadhaarValidate"))) : "");
				
			}
			//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
			tabdata.put("emp_service_no", httpservletrequest.getParameter("emp_service_no") != null ? ((Object) (httpservletrequest.getParameter("emp_service_no"))) : ""); 
			//Added by Kamatchi S for ML-MMOH-CRF-1930 US004 - start
			tabdata.put("telephone", httpservletrequest.getParameter("telephone") != null ? ((Object) (httpservletrequest.getParameter("telephone"))) : ""); 
			tabdata.put("countryC", httpservletrequest.getParameter("countryC") != null ? ((Object) (httpservletrequest.getParameter("countryC"))) : ""); 
			tabdata.put("contact1_mob_tel_no", httpservletrequest.getParameter("contact1_mob_tel_no") != null ? ((Object) (httpservletrequest.getParameter("contact1_mob_tel_no"))) : ""); 
			tabdata.put("contact1_mob_country_code", httpservletrequest.getParameter("contact1_mob_country_code") != null ? ((Object) (httpservletrequest.getParameter("contact1_mob_country_code"))) : ""); 
			tabdata.put("isVirtualConsultation", httpservletrequest.getParameter("isVirtualConsultation") != null ? ((Object) (httpservletrequest.getParameter("isVirtualConsultation"))) : ""); 
			//ML-MMOH-CRF-1930 US004 - end 
			
            if(flag)
            {
                Set set = tabdata.keySet();
                for(Iterator iterator = set.iterator(); iterator.hasNext();)
                {
                    String s48 = (String)iterator.next();
					if(!(s48.equals("fin_dtls")))
					{
                    String s50 = (String)tabdata.get(s48);
                    if(s50 == null)
                        s50 = "";
					/*
                    StringBuffer stringbuffer = new StringBuffer(s50);
                    int i = 0;
                    int j = 0;
                    while(s50.indexOf('\'', i) != -1)
                    {
                        i = s50.indexOf('\'', i);
                        stringbuffer.insert(i + j, "'");
                        tabdata.put(s48, stringbuffer.toString());
                        i++;
                        j++;
                    }
					*/
					tabdata.put(s48, s50.replaceAll("'","''"));
                }
                }
            }
        }
        catch(Exception exception)
        {
            
            flag = false;
			exception.printStackTrace();
        }
        return flag;
    }

    private boolean validateFields(String s)
    {
        boolean flag = false;
        if(validateNationalID() && validateAlternateID())
            flag = validateHeadPatient(s);
        return flag;
    }

    private boolean validateNationalID()
    {
        boolean flag = true;
        try
        {
            String s = httpRequest.getParameter("national_id_no");
            String nat_id_accept_alphanumeric_yn = httpRequest.getParameter("nat_id_accept_alphanumeric_yn");
            if(s == null)
                s = "";
            String s2 = httpRequest.getParameter("operation");
            if(s2.equals("modify"))
            {
                String s3 = httpRequest.getParameter("national_id_no_dup");
                if(s3.equals(s))
                    flag = false;
            }
            if(!s.equals("") && flag )
            {

                    if(Character.isDigit(s.charAt(0)) || nat_id_accept_alphanumeric_yn.equals("Y"))
                    {
                            String s8 = "select 1 from mp_patient where national_id_no = '" + s + "'";
                            if(rset != null)
                                rset.close();
                            if(stmt != null)
                                stmt.close();
                            stmt = con.prepareStatement(s8);
                            rset = stmt.executeQuery();
                            if(rset != null)
                                if(!rset.next())
                                {
                                    flag = true;
                                } 
								else if(dftNationalId.equals(s) && isNatIdAltIdMandVisaType==true)
									{
									  flag = true;	
									}
								else
									{
                                    flag = false;
                                    messages = messages + "DUP_NAT_ID";
                                }
                    } else
                    {
                        flag = false;
                        messages = messages + "INVALID_NAT_ID";
                    }
            } else
            {
                flag = true;
            }
        }
        catch(Exception exception)
        {
            out.println("validateNationalID:" + exception.toString());
            flag = false;
			exception.printStackTrace();
        }
        return flag;
}





    private boolean validateAlternateID()
    {
        String s = httpRequest.getParameter("Alt_id1_Valid_data");
        if(s == null)
            s = "";
        String s1 = httpRequest.getParameter("Alt_id2_Valid_data");
        if(s1 == null)
            s1 = "";
        String s2 = httpRequest.getParameter("Alt_id3_Valid_data");
        if(s2 == null)
            s2 = "";
        String s3 = httpRequest.getParameter("Alt_id4_Valid_data");
        if(s3 == null)
            s3 = "";
        boolean flag = true;
        String s4 = httpRequest.getParameter("alt_id1_no");
        String s10 = "";
        String s11 = httpRequest.getParameter("operation");
        String s12 = httpRequest.getParameter("alt_id1_accept_alphanumeric_yn");
        String s13 = httpRequest.getParameter("alt_id1_accept_oth_pat_ser_yn");
        String s14 = httpRequest.getParameter("family_org_id_accept_yn");
        alt_id1_db = httpRequest.getParameter("alt_id1_db") != null ? httpRequest.getParameter("alt_id1_db") : "";
        if(s12 == null)
            s12 = "N";
        if(s13 == null)
            s13 = "N";
        if(s14 == null)
            s14 = "N";
        boolean flag1 = false;
        messages = "";
        try
        {
            if(s4 == null)
                s4 = "";
            if(!s.equals("") && !s4.equals(""))
                if(flag)
                {
                    alt_ind = 1;
                    StringTokenizer stringtokenizer = new StringTokenizer(s, "`");
                    String s18 = "";
                    String s22 = "";
                    if(stringtokenizer.hasMoreTokens())
                        s18 = stringtokenizer.nextToken();
                    if(stringtokenizer.hasMoreTokens())
                        s22 = stringtokenizer.nextToken();
                    if(stringtokenizer.hasMoreTokens())
                        val_len = Integer.parseInt(stringtokenizer.nextToken());
                    if(stringtokenizer.hasMoreTokens())
                        s10 = stringtokenizer.nextToken();
                    if(s22.equals("Y") && s4.length() != val_len)
                    {
                        flag = false;
                        messages = messages + "ALT_ID_CHARS";
                    }
                    if(s18.indexOf("checkAlternateIdForUnique") != -1 && flag && !s11.equals("modify") && s14.equals("N"))
                    {
                        String s6 = "select 1 from mp_patient where alt_id1_no ='" + s4 + "'";
                        if(rset != null)
                            rset.close();
                        if(stmt != null)
                            stmt.close();
                        stmt = con.prepareStatement(s6);
                        rset = stmt.executeQuery();
                        if(rset.next())
                        {
                            flag = false;
                            messages = messages + "DUP_ALT_ID";
                        }
                    }
                    if(s10 == null)
                        s10 = "";
                    if(s12.equals("N"))
                    {
                        String s26 = "0123456789";
                        int i1 = 0;
                        do
                        {
                            if(i1 >= s4.length())
                                break;
                            if(s26.indexOf(s4.charAt(i1)) == -1)
                            {
                                flag = false;
                                messages = messages + "ALT_ID_NO";
                                break;
                            }
                            i1++;
                        } while(true);
                    }
                    if(!s10.equals("") && !s10.equals("null") && flag)
                    {
                        int i = 0;
                        do
                        {
                            if(i >= s4.length())
                                break;
                            if(Character.isLetter(s4.charAt(i)))
                            {
                                flag = false;
                                messages = messages + "ALT_ID_NO";
                                break;
                            }
                            i++;
                        } while(true);
                        if(flag && !chkDigitScheme(s10, s4).equals("TRUE"))
                        {
                            flag = false;
                            messages = messages + "INVALID_ALT_ID";
                        }
                    }
                    String s27 = httpRequest.getParameter("alt_id1_exp_date");
                    if(s27 == null)
                        s27 = "";
                    String s31 = httpRequest.getParameter("alt_exp_date_fromHCS");
                    if(s31 == null)
                        s31 = "N";
                    if(s31.equals("N") && !s27.equals("") && flag)
                        flag = chkExpiryDate(1, s27);
                } else
                if(flag1)
                    flag = true;
            s4 = httpRequest.getParameter("alt_id2_no");
            if(s4 == null)
                s4 = "";
            if(!s1.equals("") && !s4.equals(""))
            {
                if(s11.equals("modify") && flag)
                {
                    String s15 = httpRequest.getParameter("alt_id2_no_dup");
                    if(s15.equals(s4))
                    {
                        flag = false;
                        flag1 = true;
                    }
                }
                if(flag)
                {
                    alt_ind = 2;
                    flag1 = false;
                    StringTokenizer stringtokenizer1 = new StringTokenizer(s1, "`");
                    String s19 = "";
                    String s23 = "";
                    if(stringtokenizer1.hasMoreTokens())
                        s19 = stringtokenizer1.nextToken();
                    if(stringtokenizer1.hasMoreTokens())
                        s23 = stringtokenizer1.nextToken();
                    if(stringtokenizer1.hasMoreTokens())
                        val_len = Integer.parseInt(stringtokenizer1.nextToken());
                    if(stringtokenizer1.hasMoreTokens())
                        s10 = stringtokenizer1.nextToken();
                    if(s23.equals("Y") && s4.length() != val_len)
                    {
                        flag = false;
                        messages = messages + "ALT_ID_CHARS";
                    }
                    if(s19.indexOf("checkAlternateIdForUnique") != -1 && flag)
                    {
                        String s7 = "select 1 from mp_patient where alt_id2_no ='" + s4 + "'";
                        if(rset != null)
                            rset.close();
                        if(stmt != null)
                            stmt.close();
                        stmt = con.prepareStatement(s7);
                        rset = stmt.executeQuery();
                        if(rset.next())
                        {
                            messages = messages + "DUP_ALT_ID";
                            flag = false;
                        }
                    }
                    s10 = s10 != null ? s10 : "";
                    if(!s10.equals("") && !s10.equals("null") && flag)
                    {
                        int j = 0;
                        do
                        {
                            if(j >= s4.length())
                                break;
                            if(Character.isLetter(s4.charAt(j)))
                            {
                                flag = false;
                                messages = messages + "ALT_ID_NO";
                                break;
                            }
                            j++;
                        } while(true);
                        if(flag && !chkDigitScheme(s10, s4).equals("TRUE"))
                        {
                            flag = false;
                            messages = messages + "INVALID_ALT_ID";
                        }
                    }
                    String s28 = httpRequest.getParameter("alt_id2_exp_date");
                    if(s28 == null)
                        s28 = "";
                    if(!s28.equals("") && flag)
                        flag = chkExpiryDate(2, s28);
                } else
                if(flag1)
                    flag = true;
            }
            s4 = httpRequest.getParameter("alt_id3_no");
            if(s4 == null)
                s4 = "";
            if(!s2.equals("") && !s4.equals(""))
            {
                if(s11.equals("modify") && flag)
                {
                    String s16 = httpRequest.getParameter("alt_id3_no_dup");
                    if(s16 == null)
                        s16 = "";
                    if(s16.equals(s4))
                    {
                        flag = false;
                        flag1 = true;
                    }
                }
                if(flag)
                {
                    alt_ind = 3;
                    flag1 = false;
                    StringTokenizer stringtokenizer2 = new StringTokenizer(s2, "`");
                    String s20 = "";
                    String s24 = "";
                    if(stringtokenizer2.hasMoreTokens())
                        s20 = stringtokenizer2.nextToken();
                    if(stringtokenizer2.hasMoreTokens())
                        s24 = stringtokenizer2.nextToken();
                    if(stringtokenizer2.hasMoreTokens())
                        val_len = Integer.parseInt(stringtokenizer2.nextToken());
                    if(stringtokenizer2.hasMoreTokens())
                        s10 = stringtokenizer2.nextToken();
                    if(s24.equals("Y") && s4.length() != val_len)
                    {
                        flag = false;
                        messages = messages + "ALT_ID_CHARS";
                    }
                    if(s20.indexOf("checkAlternateIdForUnique") != -1 && flag)
                    {
                        String s8 = "select 1 from mp_patient where alt_id3_no ='" + s4 + "'";
                        if(rset != null)
                            rset.close();
                        if(stmt != null)
                            stmt.close();
                        stmt = con.prepareStatement(s8);
                        rset = stmt.executeQuery();
                        if(rset.next())
                        {
                            messages = messages + "DUP_ALT_ID";
                            flag = false;
                        }
                    }
                    s10 = s10 != null ? s10 : "";
                    if(!s10.equals("") && !s10.equals("null") && flag)
                    {
                        int k = 0;
                        do
                        {
                            if(k >= s4.length())
                                break;
                            if(Character.isLetter(s4.charAt(k)))
                            {
                                flag = false;
                                messages = messages + "ALT_ID_NO";
                                break;
                            }
                            k++;
                        } while(true);
                        if(flag && !chkDigitScheme(s10, s4).equals("TRUE"))
                        {
                            flag = false;
                            messages = messages + "INVALID_ALT_ID";
                        }
                    }
                    String s29 = httpRequest.getParameter("alt_id3_exp_date");
                    if(s29 == null)
                        s29 = "";
                    if(!s29.equals("") && flag)
                        flag = chkExpiryDate(3, s29);
                } else
                if(flag1)
                    flag = true;
            }
            s4 = httpRequest.getParameter("alt_id4_no");
            if(s4 == null)
                s4 = "";
            if(!s3.equals("") && !s4.equals(""))
            {
                if(s11.equals("modify") && flag)
                {
                    String s17 = httpRequest.getParameter("alt_id2_no_dup");
                    if(s17 == null)
                        s17 = "";
                    if(s17.equals(s4))
                    {
                        flag = false;
                        flag1 = true;
                    }
                }
                if(flag)
                {
                    alt_ind = 4;
                    flag1 = false;
                    StringTokenizer stringtokenizer3 = new StringTokenizer(s3, "`");
                    String s21 = "";
                    String s25 = "";
                    if(stringtokenizer3.hasMoreTokens())
                        s21 = stringtokenizer3.nextToken();
                    if(stringtokenizer3.hasMoreTokens())
                        s25 = stringtokenizer3.nextToken();
                    if(stringtokenizer3.hasMoreTokens())
                        val_len = Integer.parseInt(stringtokenizer3.nextToken());
                    if(stringtokenizer3.hasMoreTokens())
                        s10 = stringtokenizer3.nextToken();
                    if(s25.equals("Y") && s4.length() != val_len)
                    {
                        flag = false;
                        messages = messages + "ALT_ID_CHARS";
                    }
                    if(s21.indexOf("checkAlternateIdForUnique") != -1 && flag)
                    {
                        String s9 = "select 1 from mp_patient where alt_id4_no ='" + val_len + "'";
                        if(rset != null)
                            rset.close();
                        if(stmt != null)
                            stmt.close();
                        stmt = con.prepareStatement(s9);
                        rset = stmt.executeQuery();
                        if(rset.next())
                        {
                            messages = messages + "DUP_ALT_ID";
                            flag = false;
                        }
                    }
                    s10 = s10 != null ? s10 : "";
                    if(!s10.equals("") && !s10.equals("null") && flag)
                    {
                        int l = 0;
                        do
                        {
                            if(l >= s4.length())
                                break;
                            if(Character.isLetter(s4.charAt(l)))
                            {
                                flag = false;
                                messages = messages + "ALT_ID_NO";
                                break;
                            }
                            l++;
                        } while(true);
                        if(flag && !chkDigitScheme(s10, s4).equals("TRUE"))
                        {
                            flag = false;
                            messages = messages + "INVALID_ALT_ID";
                        }
                    }
                    String s30 = httpRequest.getParameter("alt_id4_exp_date");
                    if(s30 == null)
                        s30 = "";
                    if(!s30.equals("") && flag)
                        flag = chkExpiryDate(4, s30);
                } else
                if(flag1)
                    flag = true;
            }
        }
        catch(Exception exception)
        {
            out.println("ValidateAlternateID:" + exception.toString());
            flag = false;
			exception.printStackTrace();
        }
        return flag;
    }

    private String chkDigitScheme(String s, String s1)
    {
        String s2 = "FALSE";
        try
        {
            String s3 = "select program_name from mp_check_digit_scheme where scheme_id='" + s + "'";
            if(rset != null)
                rset.close();
            if(stmt != null)
                stmt.close();
            stmt = con.prepareStatement(s3);
            rset = stmt.executeQuery();
            if(rset.next())
                s = rset.getString(1);
            if(rset != null)
                rset.close();
            if(stmt != null)
                stmt.close();
            s3 = "select " + s + "('" + s1 + "') from dual";
            stmt = con.prepareStatement(s3);
            rset = stmt.executeQuery();
            rset.next();
            s2 = rset.getString(1);
            if(rset != null)
                rset.close();
        }
        catch(Exception exception)
        {
            out.println("chkDigitScheme:" + exception.toString());
            s2 = "FALSE";
			exception.printStackTrace();
        }
        return s2;
    }

    private boolean chkExpiryDate(int i, String s)
    {
        boolean flag = true;
        java.sql.Date date = null;
        String s1 = "";
        int j = 0;
        java.sql.Date date2 = null;
        String s4 = "";
		String sDate = s;
			if ( !sDate.equals("") )
			{
				if(!locale.equals("en"))
				{
					sDate= DateUtils.convertDate(sDate,"DMY",locale,"en");
				}
			}
        try
        {
            if(i == 1)
                s4 = "Select alt_id1_exp_warn_yn,alt_id1_exp_grace_days, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id_adv_alert_days,to_date('" + sDate + "','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,";
            if(i == 2)
                s4 = "Select alt_id2_exp_warn_yn,alt_id2_exp_grace_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days,0) alt_id_adv_alert_days,to_date('" + sDate + "','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,";
            if(i == 3)
                s4 = "Select alt_id3_exp_warn_yn,alt_id3_exp_grace_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days,0) alt_id_adv_alert_days,to_date('" + sDate + "','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,";
            if(i == 4)
                s4 = "Select alt_id4_exp_warn_yn,alt_id4_exp_grace_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days,0) alt_id_adv_alert_days,to_date('" + sDate + "','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,";
            s4 = s4 + " trunc(sysdate),to_date( '" + s + "','dd/mm/yyyy') from mp_param";
            if(rset != null)
                rset.close();
            if(stmt != null)
                stmt.close();
            stmt = con.prepareStatement(s4);
            rset = stmt.executeQuery();
            if(rset.next())
            {
                s1 = rset.getString(1);
                if(s1 == null)
                    s1 = "";
                j = rset.getInt(2);
                String s3 = rset.getString(3);
                if(s3 == null)
                    s3 = "";
                date = rset.getDate(6);
                date2 = rset.getDate(7);
            }
            if(s1.equals("Y"))
            {
                Date date1 = new Date(date2.getTime());
                date1.setDate(date2.getDate() + j);
                if(date2.compareTo(date) < 0 && date1.compareTo(date) < 0)
                {
                    flag = true;
                    messages = messages + "ALT_ID_EXPIRED";
                }
            }
        }
        catch(Exception exception)
        {
            out.println("Expiry:" + i + "," + exception.toString());
            flag = false;
			exception.printStackTrace();
        }
        return flag;
    }

    boolean validateHeadPatient(String s)
    {
        boolean flag = false;
        try
        {
            String s1 = httpRequest.getParameter("family_link_no");
            if(s1 == null)
                s1 = "";
            if(!s1.equals(""))
            {
                String s2 = "select nvl(ALLOW_FAMILY_NO_YN,'N')ALLOW_FAMILY_NO_YN, short_desc from mp_pat_ser_grp_lang_vw where pat_ser_grp_code = (select pat_ser_grp_code from mp_patient where patient_id ='" + s1 + "')  AND language_id = '" + s + "' ";
                String s3 = "";
                if(rset != null)
                    rset.close();
                if(stmt != null)
                    stmt.close();
                stmt = con.prepareStatement(s2);
                rset = stmt.executeQuery();
                if(rset != null && rset.next())
                {
                    s3 = rset.getString("allow_family_no_yn");
                    pat_ser_short_desc = rset.getString("short_desc");
                }
                if(s3.equals("Y"))
                    flag = true;
                else
                    messages = messages + "HEAD_PATIENT_NOT_ALLOWED";
            } else
            {
                flag = true;
            }
        }
        catch(Exception exception)
        {
            flag = false;
            out.println("validateHeadPatient:" + exception.toString());
			exception.printStackTrace();
        }
        return flag;
    }

    private String promptFileGen()
    {
        String s = "";
        try
        {
       /*     String s1 = "select pat_no_ctrl from mp_pat_ser_grp where pat_ser_grp_code ='" + httpRequest.getParameter("pat_ser_grp_code") + "'";
            String s3 = "";
            if(rset != null)
                rset.close();
            if(stmt != null)
                stmt.close();
            stmt = con.prepareStatement(s1);
            rset = stmt.executeQuery();
            if(rset.next())
                s3 = rset.getString("pat_no_ctrl") != null ? rset.getString("pat_no_ctrl") : "";
            if(!s3.equals("U") && s3.equals("Z"))
            {
                if(rset != null)
                    rset.close();
                String s2 = "select site_id from sm_site_param";
                if(rset != null)
                    rset.close();
                if(stmt != null)
                    stmt.close();
                stmt = con.prepareStatement(s2);
                rset = stmt.executeQuery();
            }
            if(rset != null)
                rset.close();   */

            if(create_file_at_pat_regn_yn.equals("Y"))
            {
            	//modified by abirami for passing functionId-  Bru-HIMS-CRF-313 
                String s4 = "var HTMLVal = `<form name='f' method='post' action='../servlet/eMP.PatientRegistrationServlet?function_id=" + function_id + "'>";
                String s5;
                String s6;
                for(Enumeration enumeration = httpRequest.getParameterNames(); enumeration.hasMoreElements(); s4 = s4 + "<input type='hidden' name='" + s5 + "' id='" + s5 + "' value=\"" + s6 + "\"> \n")
                {
                    s5 = (String)enumeration.nextElement();
                    s6 = httpRequest.getParameter(s5);
                    if(s6 == null)
                        s6 = "";
                    if(s5.indexOf("loc_lang") == -1 && s5.indexOf("oth_lang") == -1)
                        continue;
                    if(s6 == null)
                        s6 = "";
                }
                s4 = s4 + "<input type='hidden' name='generate_file' id='generate_file' value='Y'> \n";
                s4 = s4 + "<input type='hidden' name='client_ip_address' id='client_ip_address' value='" + p.getProperty("client_ip_address") + "'> \n";
                s4 = s4 + " </form>`;" 
                		+ "self.document.write(HTMLVal);" 
                		+"document.getElementById('generate_file').value='Y'; \n" + "document.getElementById('operation').value='insert';self.document.f.submit();await new Promise(resolve => setTimeout(resolve, 1000));";
                out.println(s4);
                s = "";
            } else
            {
                s = "insert";
            }
            if(rset != null)
                rset.close();
            if(stmt != null)
                stmt.close();
        }
        catch(Exception exception)
        {
            out.println(exception);
			exception.printStackTrace();
        }
        return s;
    }
	 private boolean insertPatDocImage(HttpServletRequest httpservletrequest, String pat,String output,String func_act)
    {
		 if(!doc1image.equals("") || !doc2image.equals("") || !doc3image.equals("") || !doc4image.equals("")){			
			 out.println("parent.frames[1].frames[1].document.forms[0].funCall.value='"+func_act+"';parent.frames[1].frames[1].document.forms[0].upload_patient_id.value='"+pat+"';parent.frames[1].frames[1].document.forms[0].output.value=encodeURIComponent('"+output+"','UTF-8');parent.frames[1].frames[1].document.forms[0].encoding = 'multipart/form-data';parent.frames[1].frames[1].document.forms[0].action='../../servlet/eMP.DocUploadServlet';parent.frames[1].frames[1].document.forms[0].submit(); await new Promise(resolve => setTimeout(resolve, 1000)); parent.f_query_add_mod.window.location.href='../eCommon/html/blank.html';");	
			 		 
		 }
		
		 
		return true;
    }
   /* end PMG2012-CRF-0006 [IN034693] */ 

   /*Added by Rameswar on  17-03-2016 for MMS-DM-CRF-0035*/
   private void updateScanDetails(HttpServletRequest httpservletrequest, String patient_id)
    {   String tempsql="";
        StringBuffer updSql  = new StringBuffer();
       
        
        String sDoc1Path="";         String sDoc1extn = "";    
        String sDoc2Path="";         String sDoc2extn = "";    
        String sDoc3Path="";         String sDoc3extn = "";    
        String sDoc4Path="";         String sDoc4extn = "";    
        Statement statement =null;
        ResultSet resultset =null; 
        PreparedStatement stmt=null;
        
        try{ 
           


           

                if(doc1image.equals("")&&!doc_id1.equals("")){
               
                    tempsql="select DOC_FILE_TYPE,DOC_FILE_PATH from  EM_SCAN_DOCUMENT_TEMP where DOC_ID = '"+document_id1+"'";
                             statement = con.createStatement();
                             resultset = statement.executeQuery(tempsql);
                            if(resultset != null && resultset.next())
                            {   
                                sDoc1Path = resultset.getString("DOC_FILE_PATH");
                                sDoc1extn = resultset.getString("DOC_FILE_TYPE");

                             }
                            
                            
                             
                            if(resultset != null)
                                resultset.close();
                            if(statement != null)
                                statement.close();
                            tempsql="";
                            
                }
                 if(doc2image.equals("")&&!doc_id2.equals("")){
                    
                   tempsql="select DOC_FILE_TYPE,DOC_FILE_PATH from  EM_SCAN_DOCUMENT_TEMP where DOC_ID = '"+document_id2+"'";
                             statement = con.createStatement();
                             resultset = statement.executeQuery(tempsql);
                            if(resultset != null && resultset.next())
                            {
                                sDoc2Path = resultset.getString("DOC_FILE_PATH");
                                sDoc2extn = resultset.getString("DOC_FILE_TYPE");
                             }
                            

                            if(resultset != null)
                                resultset.close();
                            if(statement != null)
                                statement.close();
                            tempsql="";
                            
                }
                 if(doc3image.equals("")&&!doc_id3.equals("")){
               
                   tempsql="select DOC_FILE_TYPE,DOC_FILE_PATH from  EM_SCAN_DOCUMENT_TEMP where DOC_ID = '"+document_id3+"'";
                             statement = con.createStatement();
                             resultset = statement.executeQuery(tempsql);
                            if(resultset != null && resultset.next())
                            {
                                sDoc3Path = resultset.getString("DOC_FILE_PATH");
                                 sDoc3extn = resultset.getString("DOC_FILE_TYPE");
                             }
                           

                            if(resultset != null)
                                resultset.close();
                            if(statement != null)
                                statement.close();
                            tempsql="";
                            
                }
                 if(doc4image.equals("")&&!doc_id4.equals("")){
              
                   tempsql="select DOC_FILE_TYPE,DOC_FILE_PATH from  EM_SCAN_DOCUMENT_TEMP where DOC_ID = '"+document_id4+"'";
                             statement = con.createStatement();
                             resultset = statement.executeQuery(tempsql);
                            if(resultset != null && resultset.next())
                            {
                                sDoc4Path = resultset.getString("DOC_FILE_PATH");
                                 sDoc4extn = resultset.getString("DOC_FILE_TYPE");
                             }
                       

                            if(resultset != null)
                                resultset.close();
                            if(statement != null)
                                statement.close();
                            tempsql="";
                           
                }
               /* updSql="UPDATE MP_PAT_DOCUMENTS set DOC1_IMAGE_PATH='"+sDoc1Path+"' ,DOC1_IMAGE_TYPE='"+sDoc1extn+"',DOC2_IMAGE_PATH='"+sDoc2Path+"' ,DOC2_IMAGE_TYPE='"+sDoc2extn+"',DOC3_IMAGE_PATH='"+sDoc3Path+"', DOC3_IMAGE_TYPE='"+sDoc3extn+"',DOC4_IMAGE_PATH='"+sDoc4Path+"', DOC4_IMAGE_TYPE='"+sDoc4extn+"' WHERE PATIENT_ID='"+patient_id+"'"; */
               if(iDocFolderOption==0){

                if (!sDoc1extn.equals("")||!sDoc2extn.equals("")||!sDoc3extn.equals("")||!sDoc4extn.equals("")) {
                    
                updSql.append("UPDATE MP_PAT_DOCUMENTS set DOC_DB_FLAG='"+iDocFolderOption+"' ,");
                if(!sDoc1extn.equals("")){
                       updSql.append(" doc1_image = (SELECT doc_file FROM em_scan_document_temp             WHERE doc_id = '"+document_id1+"') ,DOC1_IMAGE_TYPE='"+sDoc1extn+"' , DOC1_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc2extn.equals("")){
                    if(!sDoc1extn.equals("")) updSql.append(" ,");
                       updSql.append(" doc2_image = (SELECT doc_file FROM em_scan_document_temp                WHERE doc_id = '"+document_id2+"') ,DOC2_IMAGE_TYPE='"+sDoc2extn+"' , DOC2_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc3extn.equals("")){
                    if(!sDoc1extn.equals("")||!sDoc2extn.equals("")) updSql.append(" ,");
                       updSql.append(" doc3_image = (SELECT doc_file FROM em_scan_document_temp                 WHERE doc_id = '"+document_id3+"') ,DOC3_IMAGE_TYPE='"+sDoc3extn+"' , DOC3_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc4extn.equals("")){
                    if(!sDoc1extn.equals("")||!sDoc2extn.equals("")||!sDoc3extn.equals("")) updSql.append(" ,");
                       updSql.append(" doc4_image = (SELECT doc_file FROM em_scan_document_temp                WHERE doc_id = '"+document_id4+"') ,DOC4_IMAGE_TYPE='"+sDoc4extn+"' , DOC4_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }

                 updSql.append("  WHERE PATIENT_ID='"+patient_id+"'");
             }

               }
                else if(iDocFolderOption==1){

                if (!sDoc1Path.equals("")||!sDoc2Path.equals("")||!sDoc3Path.equals("")||!sDoc4Path.equals("")) {
                    
                updSql.append("UPDATE MP_PAT_DOCUMENTS set DOC_DB_FLAG='"+iDocFolderOption+"' ,");
                if(!sDoc1Path.equals("")){
                       updSql.append(" DOC1_IMAGE_PATH='"+sDoc1Path+"' ,DOC1_IMAGE_TYPE='"+sDoc1extn+"' , DOC1_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc2Path.equals("")){
                    if(!sDoc1Path.equals("")) updSql.append(" ,");
                       updSql.append(" DOC2_IMAGE_PATH='"+sDoc2Path+"' ,DOC2_IMAGE_TYPE='"+sDoc2extn+"' , DOC2_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc3Path.equals("")){
                    if(!sDoc1Path.equals("")||!sDoc2Path.equals("")) updSql.append(" ,");
                       updSql.append(" DOC3_IMAGE_PATH='"+sDoc3Path+"' ,DOC3_IMAGE_TYPE='"+sDoc3extn+"' , DOC3_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }
                if(!sDoc4Path.equals("")){
                    if(!sDoc1Path.equals("")||!sDoc2Path.equals("")||!sDoc3Path.equals("")) updSql.append(" ,");
                       updSql.append(" DOC4_IMAGE_PATH='"+sDoc4Path+"' ,DOC4_IMAGE_TYPE='"+sDoc4extn+"' , DOC4_UPLOAD_FLAG='"+iDocFolderOption+"'"); 
                }

                 updSql.append("  WHERE PATIENT_ID='"+patient_id+"'");
                }
                
                }
                if((updSql.length())!=0 ){
                    stmt=con.prepareStatement(updSql.toString());
                    int updated = stmt.executeUpdate();
                    if (stmt != null) stmt.close();
                                                           
                    con.commit();
                }               
				
            } catch(Exception e)    {     
			
			           e.printStackTrace();
	        }                        
	
	 }
	 
	/* Added by Santhosh for ML-MMOH-CRF-1957 */
	private void updatePhoneNumber(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) {

		String contact1_no = httpservletrequest.getParameter("contact1_no") != null ? httpservletrequest.getParameter("contact1_no") : "";
		String contact2_no = httpservletrequest.getParameter("contact2_no") != null ? httpservletrequest.getParameter("contact2_no") : "";
		String Patient_id = httpservletrequest.getParameter("Patient_id") != null ? httpservletrequest.getParameter("Patient_id") : "";
		String function_id = httpservletrequest.getParameter("function_id") != null ? httpservletrequest.getParameter("function_id") : "";

		HashMap tabdata = new HashMap();
		tabdata.put("function_id", function_id);
		tabdata.put("contact1_no", contact1_no);
		tabdata.put("contact2_no", contact2_no);
		tabdata.put("Patient_id", Patient_id);
		
		outputValue = "";
		
		HttpSession httpsession = httpservletrequest.getSession(false);
		String locale1 = p.getProperty("LOCALE");
		java.util.Locale loc = new java.util.Locale(locale1);
		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle("eMP.resources.Labels", loc);
		
		try {
			addedById = p.getProperty("login_user");
			boolean flag = false;
			
			if (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null
					&& getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
				flag = true;
			
			Object obj = ServiceLocator.getInstance().getHome("java:comp/env/PatientRegistration",
					eMP.PatientRegistration.PatientRegistrationHome.class, flag);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = p;
			aobj[1] = tabdata;

			Class aclass[] = new Class[2];
			aclass[0] = p.getClass();
			aclass[1] = tabdata.getClass();
			HashMap hashmap = (HashMap) obj1.getClass().getMethod("updatePatient", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			
			if (((Boolean) hashmap.get("Transaction_Completed")).booleanValue()) {
				err_value = "1";
				outputValue = "APP-MP0202 Patient record is successfully updated";
				out.println("alert('"+outputValue+"');");
				out.println("window.location.href='../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(outputValue, "UTF-8") + "&err_value=" + err_value + "';");
			} else {
				errorValue = String.valueOf((StringBuffer) hashmap.get("error_buf"));
				outputValue = errorValue;
				err_value = "0";
				out.println("window.location.href='../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(outputValue, "UTF-8") + "&err_value=" + err_value + "';");
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

	}
   /*Added by Rameswar on  17-03-2016 for MMS-DM-CRF-0035*/

    PrintWriter out;
    String appt_ref_no;
    String bkg_ref_no;
    String booking_ref_no;
    String func_act;
    String pat_name_as_multipart_yn;
	String gcc;
	String facility_id;
  //added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 Starts
    String biometric_reason="";
    String fun_id="";
  //added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 Ends
	String patient_id;
	String alt_id1_no;
	String alt_id1_db;
	int val_len;
	String mother_patient_id;
	String multi_birth;
	String parent_details;
	String numberofbirth;
	String numberofbaby;
	int noOfBirths;
	int numOfbaby;
	String AddedFacilityID;
	String AddedAtWsNo;
	String addedById;
	String sStyle;
	String outputValue;
	String errorValue;
	String bl_success_msg;
	String err_value;
	HashMap tabdata;
	HttpServletResponse httpResponse;
	HttpServletRequest httpRequest;
	Connection con;
	PreparedStatement stmt;
	ResultSet rset;
	String messages;
	String function_id;
	String pat_ser_short_desc;
	String q_booking_type;
	Properties p;
	String create_file_at_pat_regn_yn;
	String appt_yn;
	String locale;
	String FAMILY_ORG_ID_ACCEPT_YN;
    int alt_ind;
	java.util.ResourceBundle common_labels;
	String dla_image;
	String pat_photo;
	String dla_image_yn;
	String called_from;
	/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
	String doc1image;
	String doc2image;
	String doc3image;
	String doc4image;
   /* end PMG2012-CRF-0006 [IN034693] */
   /*Added by Rameswar on  21-03-2016 for MMS-DM-CRF-0035 */
    String document_id1;
    String document_id2;
    String document_id3;
    String document_id4;
    int iDocFolderOption=0;
    String doc_id1="";
    String doc_id2="";
    String doc_id3="";
    String doc_id4=""; 
	boolean isNatIdAltIdMandVisaType=false;
	String dftNationalId="";
	String txtSmart_fn_name="";
   /*Added by Rameswar on  21-03-2016 for  MMS-DM-CRF-0035*/
}