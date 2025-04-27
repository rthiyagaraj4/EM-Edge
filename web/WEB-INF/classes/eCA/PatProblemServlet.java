/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;

import eCA.PatProblem.*;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PatProblemServlet extends HttpServlet
{
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		HttpSession httpsession = httpservletrequest.getSession(false);
	
        
        String invoker = httpservletrequest.getParameter("Invoking_Function");
        if(invoker == null)
            invoker = "";
        try
        {
            out = httpservletresponse.getWriter();
			
            String s = httpservletrequest.getParameter("function_name");

            if(s.equals("insert"))
                insertPatProblem(httpservletrequest, httpservletresponse, httpsession, out);
            else if(s.equals("modify"))
                modifyPatProblem(httpservletrequest, httpservletresponse, httpsession, out);
            else if(invoker.equals("CV"))
                fromCompleteVisit(httpservletrequest, httpservletresponse, httpsession, out);
        }
        catch(Exception exception)
        {
            out.println("Exception Occured-->" + exception.toString());
            exception.printStackTrace();
        }
    }

    private void modifyPatProblem(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, HttpSession httpsession, PrintWriter out)
    {
		String x_locn_type = "";
		String x_locn_code = "";
	    String x_facility_id = "";
		int x_srl_no = 0;
		String temp_x_srl_no = "";
		String x_diag_code = "";
		String x_diag_desc = "";
		String x_primary_yn = "";
		String x_close_date = "";
		String x_close_practitioner_id = "";
		String x_close_locn_code = "";
		String x_close_locn_type = "";
		long x_close_encounter_id = 0L;
		String temp_x_close_encounter_id = "";
		String x_problem_status = "";
		String eid = "";
		String client_ip_address = "";
		String x_patient_id = "";
		String x_Sec_Hdg_Code = "";
		String x_context = "";
		String x_diag_stage = "";
		String x_significant_yn = "";
		String x_logical_seq_no = "";
		String x_remarks = "";
		String x_diag_type = "";
		String x_accession_num = "";
		String x_authorize = "";
		String x_recordedby_id = "";
		String x_reviwedby_id = "";
		String x_authorizepract_id = "";
		String x_associate_codes = "";
		String x_practitioner_id = "";
		String modal_yn = "";
		String x_include_enc = "";
		String called_from_ip = "";
		long   x_encounter_id = 0L;
		String locale = "";

		Properties p = null;

		try
        {
			x_facility_id = (String)httpsession.getValue("facility_id");
			p = (Properties)httpsession.getValue("jdbc");
			locale				= (String) p.getProperty("LOCALE");
			client_ip_address = p.getProperty("client_ip_address");

            called_from_ip = httpservletrequest.getParameter("called_from_ip");
            if(called_from_ip == null)
                called_from_ip = "";

			

			modal_yn	 = httpservletrequest.getParameter("modal_yn")==null?"":httpservletrequest.getParameter("modal_yn");
			modal_yn=modal_yn;
			x_locn_code = httpservletrequest.getParameter("locn_code")==null?"":httpservletrequest.getParameter("locn_code");
			x_locn_type = httpservletrequest.getParameter("locn_type")==null?"":httpservletrequest.getParameter("locn_type");
			String x_enc_id = httpservletrequest.getParameter("encounter_id");
			if(x_enc_id!=null)
					x_encounter_id	= Long.parseLong(x_enc_id);

			x_encounter_id=x_encounter_id;

            String s = "";
            s = httpservletrequest.getParameter("errorRemarks") != null ? httpservletrequest.getParameter("errorRemarks") : "";
            x_patient_id = httpservletrequest.getParameter("patient_id");
            x_srl_no = Integer.parseInt(httpservletrequest.getParameter("srl_no_from_table"));
			temp_x_srl_no=x_srl_no+"";
            x_diag_code = httpservletrequest.getParameter("code");
            x_close_date = httpservletrequest.getParameter("close")==null?"":httpservletrequest.getParameter("close");
			x_close_date	= com.ehis.util.DateUtils.convertDate(x_close_date,"DMY",locale,"en");

            x_practitioner_id = (String) httpsession.getValue("ca_practitioner_id") == null ? "" : (String) httpsession.getValue("ca_practitioner_id");
            x_close_practitioner_id = httpservletrequest.getParameter("practitioner_id");
            if(x_close_practitioner_id == null || x_close_practitioner_id.equals("null"))
                x_close_practitioner_id = "";
            x_close_locn_code = httpservletrequest.getParameter("locn_code");
            if(x_close_locn_code == null || x_close_locn_code.equals("null"))
                x_close_locn_code = "";
            x_close_locn_type = httpservletrequest.getParameter("locn_type");
            if(x_close_locn_type == null || x_close_locn_type.equals("null"))
                x_close_locn_type = "";
            eid = httpservletrequest.getParameter("encounter_id");
            if(eid.equals("null") || eid.length() == 4)
                eid = "";
            else
                x_close_encounter_id = Long.parseLong(eid);
			temp_x_close_encounter_id=x_close_encounter_id+"";
            x_problem_status = httpservletrequest.getParameter("problem_status")==null?"":httpservletrequest.getParameter("problem_status");

			
			x_diag_desc = httpservletrequest.getParameter("Description")==null?"":httpservletrequest.getParameter("Description");
            x_Sec_Hdg_Code = httpservletrequest.getParameter("Sec_Hdg_Code")==null?"":httpservletrequest.getParameter("Sec_Hdg_Code");
            x_context = httpservletrequest.getParameter("context") != null ? httpservletrequest.getParameter("context") : "";
            if(x_context.equals("IP_Q"))
                x_diag_stage = httpservletrequest.getParameter("diag_stage")==null?"":httpservletrequest.getParameter("diag_stage");
            else
                x_diag_stage = "";



            x_logical_seq_no = httpservletrequest.getParameter("logical_seq_no") != null ? httpservletrequest.getParameter("logical_seq_no") : "";
            x_remarks = httpservletrequest.getParameter("remarks") != null ? httpservletrequest.getParameter("remarks") : "";

            x_diag_type = httpservletrequest.getParameter("diag_type") != null ? httpservletrequest.getParameter("diag_type") : "";
            x_authorize = httpservletrequest.getParameter("authorizeCheck") != null ? httpservletrequest.getParameter("authorizeCheck") : "N";
            x_recordedby_id = httpservletrequest.getParameter("recordedbyid") != null ? httpservletrequest.getParameter("recordedbyid") : "";
            x_reviwedby_id = httpservletrequest.getParameter("reviwedbyid") != null ? httpservletrequest.getParameter("reviwedbyid") : "";
            x_authorizepract_id = httpservletrequest.getParameter("authorizepractid") != null ? httpservletrequest.getParameter("authorizepractid") : "";
            if(x_Sec_Hdg_Code == null || x_Sec_Hdg_Code.equals("null"))
                x_Sec_Hdg_Code = "";
            x_primary_yn = httpservletrequest.getParameter("primary") != null ? httpservletrequest.getParameter("primary") : "N";
            x_significant_yn = httpservletrequest.getParameter("significant") != null ? httpservletrequest.getParameter("significant") : "N";
            x_accession_num = httpservletrequest.getParameter("accession_num") != null ? httpservletrequest.getParameter("accession_num") : "";
            x_associate_codes = httpservletrequest.getParameter("associate_codes") != null ? httpservletrequest.getParameter("associate_codes") : "";
            x_associate_codes = URLDecoder.decode(x_associate_codes);

			 x_include_enc = httpservletrequest.getParameter("include_enc")==null?"N":httpservletrequest.getParameter("include_enc");

			/*InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup("java:comp/env/PatProblemManager");
            PatProblemManagerHome patproblemmanagerhome = (PatProblemManagerHome)PortableRemoteObject.narrow(obj, eCA.PatProblem.PatProblemManagerHome.class);
            PatProblemManagerRemote patproblemmanagerremote = patproblemmanagerhome.create();
            HashMap hashmap = patproblemmanagerremote.updatePatProblem
			(p, x_patient_id, x_srl_no, x_close_date, x_close_practitioner_id, 
			x_close_locn_code, x_close_locn_type, x_close_encounter_id, 
			x_problem_status, client_ip_address, x_facility_id, x_diag_desc, 
			x_Sec_Hdg_Code, x_logical_seq_no, x_remarks, 
			x_diag_type, x_primary_yn, x_significant_yn, 
			x_diag_stage, s, x_accession_num, x_authorize, 
			x_recordedby_id, x_reviwedby_id, 
			x_authorizepract_id, 
			x_associate_codes, x_diag_code);*/
			
			boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatProblemManager",PatProblemManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[29];
		argArray[0] = p;
		argArray[1] = x_patient_id;
		argArray[2] = temp_x_srl_no;
		argArray[3] = x_close_date;
		argArray[4] = x_close_practitioner_id;
		argArray[5] = x_close_locn_code;
		argArray[6] = x_close_locn_type;
		argArray[7] = temp_x_close_encounter_id;
		argArray[8] = x_problem_status;
		argArray[9] = client_ip_address;
		argArray[10] = x_facility_id;
		//argArray[11] = x_diag_desc;
		//argArray[12] =x_Sec_Hdg_Code;
		//argArray[13] =x_logical_seq_no;
		argArray[11] =x_remarks;
		argArray[12] =x_diag_type;
		argArray[13] =x_primary_yn;
		argArray[14] =x_significant_yn;
		argArray[15] =x_diag_stage;
		argArray[16] =s;
		argArray[17] =x_accession_num;
		argArray[18] =x_authorize;
		argArray[19] =x_recordedby_id;
		argArray[20] =x_reviwedby_id;
		argArray[21] =x_authorizepract_id;
		argArray[22] =x_associate_codes;
		argArray[23] =x_diag_code;
		argArray[24] =x_practitioner_id;
		argArray[25] =x_locn_code;
		argArray[26] =x_locn_type;
		argArray[27] =x_include_enc; 
		argArray[28] =locale;

		Class [] paramArray = new Class[29];
		paramArray[0] = p.getClass();
		paramArray[1] = x_patient_id.getClass();
		paramArray[2] = temp_x_srl_no.getClass();
		paramArray[3] = x_close_date.getClass();
		paramArray[4] =  x_close_practitioner_id.getClass();
		paramArray[5] = x_close_locn_code.getClass();
		paramArray[6] = x_close_locn_type.getClass();
		paramArray[7] = temp_x_close_encounter_id.getClass();
		paramArray[8] =  x_problem_status.getClass();
		paramArray[9] = client_ip_address.getClass();
		paramArray[10] = x_facility_id.getClass();
		//paramArray[11] = x_diag_desc.getClass();
		//paramArray[12] = x_Sec_Hdg_Code.getClass();
		//paramArray[13] = x_logical_seq_no.getClass();
		paramArray[11] = x_remarks.getClass();
		paramArray[12] = x_diag_type.getClass();
		paramArray[13] = x_primary_yn.getClass();
		paramArray[14] = x_significant_yn.getClass();
		paramArray[15] = x_diag_stage.getClass();
		paramArray[16] = s.getClass();
		paramArray[17] = x_accession_num.getClass();
		paramArray[18] = x_authorize.getClass();
		paramArray[19] = x_recordedby_id.getClass();
		paramArray[20] = x_reviwedby_id.getClass();
		paramArray[21] = x_authorizepract_id.getClass();
		paramArray[22] = x_associate_codes.getClass();
		paramArray[23] = x_diag_code.getClass();
		paramArray[24] = x_practitioner_id.getClass();
		paramArray[25] = x_locn_code.getClass();
		paramArray[26] = x_locn_type.getClass();
		paramArray[27] = x_include_enc.getClass();
		paramArray[28] = locale.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updatePatProblem",
		paramArray)).invoke(busObj,argArray);
	
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            boolean flag = ((Boolean)results.get("status")).booleanValue();

            String s1 = (String)results.get("error");

//            String s3 = "0";

            if(called_from_ip.equals("Y"))
            {
				if(flag)
                {
					results.clear();
                   // s1 = s1.substring(0, s1.indexOf("<br>"));
                    out.println("<script>alert('" + s1 + "')</script>");
                } else
                {
                    out.println("<script>alert('" + s1 + "')</script>");
                }
                out.println("<script>parent.window.close();</script>");
            }
			else
			{
				if(flag)
				{

					String s4 = "1";
					results.clear();


					httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?called_from_ip=" + called_from_ip + "&err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s4 + "&" + httpservletrequest.getQueryString());
				}
				else
				{
					String s2 = (String)results.get("error");


					results.clear();

					httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?called_from_ip=" + called_from_ip + "&err_num=" + URLEncoder.encode(s2,"UTF-8") + "&" + httpservletrequest.getQueryString());
				}
			}
        }
        catch(Exception exception)
        {
            //out.println("Error Check =>" + exception.getMessage() + "<br>");//common-icn-0181
            
            exception.printStackTrace();
        }
    }

    private void insertPatProblem(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, HttpSession httpsession, PrintWriter out)
    {
		String x_locn_type = "";
		String x_locn_code = "";
	    String x_facility_id = "";
		String x_diag_code = "";
		String x_record_type = "";
		String x_cause_indicator = "";
		String x_diag_code_scheme = "";
		String x_diag_desc = "";
		String x_tab_list_no = "";
		String x_analysis_code = "";
		String x_primary_yn = "";
		String x_notifiable_yn = "";
		String x_sensitive_yn = "";
		String x_onset_date = "";
		String x_onset_practitioner_id = "";
		String x_onset_locn_code = "";
		String x_onset_locn_type = "";
		long x_onset_encounter_id = 0L;
		String temp_x_onset_encounter_id = "";
		String x_problem_status = "";
		String eid = "";
		String client_ip_address = "";
		String x_patient_id = "";
		String x_term_id = "";
		String x_Sec_Hdg_Code = "";
		String x_context = "";
		String x_diag_stage = "";
		String x_significant_yn = "";
		String x_logical_seq_no = "";
		String x_remarks = "";
		String x_diag_type = "";
		String x_accession_num = "";
		String x_authorize = "";
		String x_recordedby_id = "";
		String x_reviwedby_id = "";
		String x_authorizepract_id = "";
		String x_associate_codes = "";
		String x_practitioner_id = "";
		String modal_yn = "";
		String called_from_ip = "";
		long x_encounter_id = 0L;
		String x_oper_num="";
		String locale = "";

		Properties p = null;

        try
        {
			x_facility_id = (String)httpsession.getValue("facility_id");
			p = (Properties)httpsession.getValue("jdbc");
			locale				= (String) p.getProperty("LOCALE");
			client_ip_address = p.getProperty("client_ip_address");

           called_from_ip = httpservletrequest.getParameter("called_from_ip");
            if(called_from_ip == null)
                called_from_ip = "";
			modal_yn	 = httpservletrequest.getParameter("modal_yn")==null?"":httpservletrequest.getParameter("modal_yn");
			modal_yn=modal_yn;
			x_locn_code = httpservletrequest.getParameter("locn_code")==null?"":httpservletrequest.getParameter("locn_code");
			x_locn_type = httpservletrequest.getParameter("locn_type")==null?"":httpservletrequest.getParameter("locn_type");
			String x_enc_id = httpservletrequest.getParameter("encounter_id");
			
			if(x_enc_id!=null)
					x_encounter_id	= Long.parseLong(x_enc_id);

			x_encounter_id=x_encounter_id;
			x_oper_num=httpservletrequest.getParameter("oper_num")==null?"":httpservletrequest.getParameter("oper_num");

           called_from_ip = httpservletrequest.getParameter("called_from_ip");
            
			if(called_from_ip == null)
                called_from_ip = "";
            
			x_patient_id = httpservletrequest.getParameter("patient_id");
            x_diag_code = httpservletrequest.getParameter("code");
            x_record_type = httpservletrequest.getParameter("record_type");
            x_cause_indicator = httpservletrequest.getParameter("cause_indicator");
            x_diag_code_scheme = httpservletrequest.getParameter("scheme");
            x_diag_desc = httpservletrequest.getParameter("Description");
            x_tab_list_no = httpservletrequest.getParameter("tab_list_no");
            x_analysis_code = httpservletrequest.getParameter("analysis_code");
            x_primary_yn = httpservletrequest.getParameter("primary") != null ? httpservletrequest.getParameter("primary") : "N";
            x_notifiable_yn = httpservletrequest.getParameter("notifiable_yn") != null ? httpservletrequest.getParameter("notifiable_yn") : "";
            x_sensitive_yn = httpservletrequest.getParameter("sensitive_yn") != null ? httpservletrequest.getParameter("sensitive_yn") : "";
            x_onset_date = httpservletrequest.getParameter("onset")==null?"":httpservletrequest.getParameter("onset");
			x_onset_date	= com.ehis.util.DateUtils.convertDate(x_onset_date,"DMY",locale,"en");
            x_associate_codes = httpservletrequest.getParameter("associate_codes") != null ? httpservletrequest.getParameter("associate_codes") : "";
            x_associate_codes = URLDecoder.decode(x_associate_codes);
            x_authorize = httpservletrequest.getParameter("authorizeCheck") != null ? httpservletrequest.getParameter("authorizeCheck") : "N";
            x_significant_yn = httpservletrequest.getParameter("significant") != null ? httpservletrequest.getParameter("significant") : "N";
            x_onset_practitioner_id = httpservletrequest.getParameter("practitioner_id");
            
			if(x_onset_practitioner_id == null || x_onset_practitioner_id.equals("null"))
                x_onset_practitioner_id = "";
            
			x_onset_locn_code = httpservletrequest.getParameter("locn_code");

			if(x_onset_locn_code == null || x_onset_locn_code.equals("null"))
                x_onset_locn_code = "";
            
			x_onset_locn_type = httpservletrequest.getParameter("locn_type");
            
			if(x_onset_locn_type == null || x_onset_locn_type.equals("null"))
                x_onset_locn_type = "";
            
			eid = httpservletrequest.getParameter("encounter_id");
            x_context = httpservletrequest.getParameter("context") != null ? httpservletrequest.getParameter("context") : "";
            
			if(x_context.equals("IP_Q"))
                x_diag_stage = httpservletrequest.getParameter("diag_stage")==null?"":httpservletrequest.getParameter("diag_stage");
			else
                x_diag_stage = "";

           if(eid.equals("null") || eid.length() == 4)
                eid = "";
            else
                x_onset_encounter_id = Long.parseLong(eid);
				temp_x_onset_encounter_id=x_onset_encounter_id+"";	
					
            x_problem_status = "A";
            x_term_id = httpservletrequest.getParameter("term_id");
            x_Sec_Hdg_Code = httpservletrequest.getParameter("Sec_Hdg_Code");
            if(x_Sec_Hdg_Code == null || x_Sec_Hdg_Code.equals("null"))
                x_Sec_Hdg_Code = "";
            if(x_notifiable_yn == null)
                x_notifiable_yn = "N";
            if(x_notifiable_yn.equals("null"))
                x_notifiable_yn = "N";
            if(x_notifiable_yn.equals(""))
                x_notifiable_yn = "N";
            if(x_sensitive_yn == null)
                x_sensitive_yn = "N";
            if(x_sensitive_yn.equals("null"))
                x_sensitive_yn = "N";
            if(x_sensitive_yn.equals(""))
                x_sensitive_yn = "N";
            if(x_cause_indicator == null || x_cause_indicator.equals("null"))
                x_cause_indicator = "";
            if(x_analysis_code == null || x_analysis_code.equals("null"))
                x_analysis_code = "";
            if(x_record_type == null || x_record_type.equals("null"))
                x_record_type = "";
            if(x_term_id == null || x_term_id.equals("null"))
                x_term_id = "";
            if(x_tab_list_no == null || x_tab_list_no.equals("null"))
                x_tab_list_no = "";
            x_logical_seq_no = httpservletrequest.getParameter("logical_seq_no") != null ? httpservletrequest.getParameter("logical_seq_no") : "";
            x_remarks = httpservletrequest.getParameter("remarks") != null ? httpservletrequest.getParameter("remarks") : "";
            x_diag_type = httpservletrequest.getParameter("diag_type") != null ? httpservletrequest.getParameter("diag_type") : "";
            x_accession_num = httpservletrequest.getParameter("accession_num") != null ? httpservletrequest.getParameter("accession_num") : "";
            x_recordedby_id = httpservletrequest.getParameter("recordedbyid") != null ? httpservletrequest.getParameter("recordedbyid") : "";
            x_reviwedby_id = httpservletrequest.getParameter("reviwedbyid") != null ? httpservletrequest.getParameter("reviwedbyid") : "";
            x_authorizepract_id = httpservletrequest.getParameter("authorizepractid") != null ? httpservletrequest.getParameter("authorizepractid") : "";
            
		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatProblemManager",PatProblemManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[36];
		argArray[0] = p;
		argArray[1] = x_patient_id;
		argArray[2] = x_diag_code;
		argArray[3] = x_record_type;
		argArray[4] = x_cause_indicator;
		argArray[5] = x_diag_code_scheme;
		argArray[6] = x_diag_desc;
		argArray[7] = x_tab_list_no;
		argArray[8] =  x_analysis_code;
		argArray[9] = x_primary_yn;
		argArray[10] = x_notifiable_yn;
		argArray[11] = x_sensitive_yn;
		argArray[12] =x_onset_date;
		argArray[13] =x_onset_practitioner_id;
		argArray[14] =x_onset_locn_code;
		argArray[15] =x_onset_locn_type;
		argArray[16] =temp_x_onset_encounter_id;
		argArray[17] =x_problem_status;
		argArray[18] =client_ip_address;
		argArray[19] =x_facility_id;
		argArray[20] =x_term_id;
		argArray[21] =x_diag_stage;
		argArray[22] =x_remarks;
		argArray[23] =x_diag_type;
		argArray[24] =x_significant_yn;
		argArray[25] =x_accession_num;
		argArray[26] =x_authorize;
		argArray[27] =x_recordedby_id;
		argArray[28] =x_reviwedby_id;
		argArray[29] =x_authorizepract_id;
		argArray[30] =x_associate_codes;
		argArray[31] =x_practitioner_id;
		argArray[32] =x_locn_code;
		argArray[33] =x_locn_type;
		argArray[34] =x_oper_num;
		argArray[35] =locale;

		Class [] paramArray = new Class[36];
		paramArray[0] = p.getClass();
		paramArray[1] = x_patient_id.getClass();
		paramArray[2] = x_diag_code.getClass();
		paramArray[3] = x_record_type.getClass();
		paramArray[4] = x_cause_indicator.getClass();
		paramArray[5] = x_diag_code_scheme.getClass();
		paramArray[6] = x_diag_desc.getClass();
		paramArray[7] = x_tab_list_no.getClass();
		paramArray[8] =  x_analysis_code.getClass();
		paramArray[9] = x_primary_yn.getClass();
		paramArray[10] = x_notifiable_yn.getClass();
		paramArray[11] = x_sensitive_yn.getClass();
		paramArray[12] =x_onset_date.getClass();
		paramArray[13] =x_onset_practitioner_id.getClass();
		paramArray[14] =x_onset_locn_code.getClass();
		paramArray[15] =x_onset_locn_type.getClass();
		paramArray[16] =temp_x_onset_encounter_id.getClass();
		paramArray[17] =x_problem_status.getClass();
		paramArray[18] =client_ip_address.getClass();
		paramArray[19] =x_facility_id.getClass();
		paramArray[20] =x_term_id.getClass();
		paramArray[21] =x_diag_stage.getClass();
		paramArray[22] =x_remarks.getClass();
		paramArray[23] =x_diag_type.getClass();
		paramArray[24] =x_significant_yn.getClass();
		paramArray[25] =x_accession_num.getClass();
		paramArray[26] =x_authorize.getClass();
		paramArray[27] =x_recordedby_id.getClass();
		paramArray[28] =x_reviwedby_id.getClass();
		paramArray[29] =x_authorizepract_id.getClass();
		paramArray[30] =x_associate_codes.getClass();
		paramArray[31] =x_practitioner_id.getClass();
		paramArray[32] =x_locn_code.getClass();
		paramArray[33] =x_locn_type.getClass();
		paramArray[34] =x_oper_num.getClass();
		paramArray[35] =locale.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertPatProblem",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean flag = ((Boolean)results.get("status")).booleanValue();
			
		String s1 = (String)results.get("error");

        if(called_from_ip.equals("Y"))
        {
           out.flush();
        
		   if(flag)
           {
				results.clear();
//				s1 = s1.substring(0, s1.indexOf("<br>"));
				out.println("<script>alert('" + s1 + "');</script>");
			} 
			else
			{
				results.clear();
                out.println("<script>alert('" + s1 + "');</script>");
            }
            
			out.println("<script>parent.window.close();</script>");
         }
			

			if(flag && !called_from_ip.equals("Y"))
            {
                String s4 = "1";
				results.clear();
                httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?called_from_ip=" + called_from_ip + "&err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s4 + "&" + httpservletrequest.getQueryString());
            } else
            {
                String s2 = (String)results.get("error");
				results.clear();
				
                httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?called_from_ip=" + called_from_ip + "&err_num=" + URLEncoder.encode(s2,"UTF-8") + "&" + httpservletrequest.getQueryString());
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            
        }

    }

    private void fromCompleteVisit(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, HttpSession httpsession, PrintWriter out)
    {
		String x_patient_id = "";
		String x_onset_practitioner_id = "";
		String x_onset_locn_code = "";
		String x_onset_locn_type = "";
		String eid = "";
		String x_facility_id = "";
		String client_ip_address = "";
		String called_from_ip = "";
		String locale= "" ;

		Properties p = null;

        try
        {
			x_facility_id = (String)httpsession.getValue("facility_id");
			p = (Properties)httpsession.getValue("jdbc");
			locale				= (String) p.getProperty("LOCALE");
			client_ip_address = p.getProperty("client_ip_address");

            x_patient_id = httpservletrequest.getParameter("patient_id");
            x_patient_id = httpservletrequest.getParameter("called_from_ip");
            x_onset_practitioner_id = httpservletrequest.getParameter("practitioner_id");
            x_onset_locn_code = httpservletrequest.getParameter("locn_code");
            x_onset_locn_type = httpservletrequest.getParameter("locn_type");
            eid = httpservletrequest.getParameter("encounter_id");
            long l = Long.parseLong(eid);
			String temp_l=l+"";
            /*InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup("java:comp/env/PatProblemManager");
            PatProblemManagerHome patproblemmanagerhome = (PatProblemManagerHome)PortableRemoteObject.narrow(obj, eCA.PatProblem.PatProblemManagerHome.class);
            PatProblemManagerRemote patproblemmanagerremote = patproblemmanagerhome.create();
            HashMap hashmap = patproblemmanagerremote.FromCompleteVisit(p, x_patient_id, x_facility_id, l, client_ip_address);*/
            
			boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatProblemManager",PatProblemManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[6];
		argArray[0] = p;
		argArray[1] = x_patient_id;
		argArray[2] = x_facility_id;
		argArray[3] = temp_l;
		argArray[4] = client_ip_address;
		argArray[5] = locale;
		

		Class [] paramArray = new Class[6]; //27
		paramArray[0] = p.getClass();
		paramArray[1] = x_patient_id.getClass();
		paramArray[2] = x_facility_id.getClass();
		paramArray[3] =  temp_l.getClass();
		paramArray[4] =  client_ip_address.getClass();
		paramArray[5] =  locale.getClass();
		

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("FromCompleteVisit",
		paramArray)).invoke(busObj,argArray);
	
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			
			boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s = (String)results.get("error");
            String s2 = "0";
            if(flag)
            {
                s2 = "1";
				results.clear();
                httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?called_from_ip=" + called_from_ip + "&err_num=" + URLEncoder.encode(s,"UTF-8") + "&err_value=" + s2);
            } else
            {
                String s1 = (String)results.get("error");
				results.clear();
                httpservletresponse.sendRedirect("../eCA/jsp/PatProblemerror.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
            }
        }
        catch(Exception exception)
        {
           // out.println(exception.getMessage());//common-icn-0181
            
            exception.printStackTrace();
        }
    }
}
