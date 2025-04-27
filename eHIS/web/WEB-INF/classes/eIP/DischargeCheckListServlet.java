/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public class DischargeCheckListServlet extends HttpServlet
{
	PrintWriter out;
    Properties p;
    String facilityid;
    String facilityId;
    String client_ip_address;
    HttpSession session;
    SimpleDateFormat dateFormat;
	String locale;
    public DischargeCheckListServlet()
    {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        session			= request.getSession(false);
		this.facilityId = (String) session.getValue("facility_id" ) ;

        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        try
        {
            request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
			String operation = request.getParameter("operation")==null?"":request.getParameter("operation");

			if(operation.equals("insert"))
				insertData(request);
			else if(operation.equals("modify"))
				modifyData(request);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	try
	{			
		doPost(request,response);
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=DischargeChkList' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}catch(Exception exception) 
	{ 
	} 
}

private void insertData(HttpServletRequest request)
{
	java.sql.Connection connection = null;
	//Statement stmt			= null; //Commented by Suji Keerthi for Checkstyle
	//ResultSet rs			= null; //Commented by Suji Keerthi for Checkstyle
	try
	{
		connection = ConnectionManager.getConnection(request);
		facilityid = request.getParameter("facility_id");
		String encounter_id = request.getParameter("encounter_id");
		String login_user = p.getProperty("login_user");
		String s1 = dateFormat.format(new java.util.Date());
		String s3 = s1;
		String s6 = client_ip_address;
		String s7 = s6;
		java.sql.Date date = java.sql.Date.valueOf(s1);
		java.sql.Date date1 = java.sql.Date.valueOf(s3);

		HashMap hashtable = new HashMap();
		hashtable.put("facility_id", facilityid);
		hashtable.put("encounter_id", encounter_id);
		hashtable.put("patient_id", checkForNull(request.getParameter("patient_id")));
		/*
			commented by mujafar for ML-MMOH-SCF-1032
			
		int referralCount = 0;
		int ApptCount = 0;

	try
	{
		StringBuffer RefCountSql = new StringBuffer();
		if(RefCountSql.length() > 0) RefCountSql.delete(0,RefCountSql.length());
		RefCountSql.append(" SELECT COUNT (*) FROM pr_referral_register WHERE to_ref_type = 'L' AND to_facility_id = '"+facilityid+"' AND from_encounter_id = '"+encounter_id+"' ");

		stmt	= connection.createStatement();
		rs		= stmt.executeQuery(RefCountSql.toString());	

		if((rs != null) && (rs.next()))
		{
			referralCount = rs.getInt(1);
		}
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();

		StringBuffer ApptCountSql = new StringBuffer();
		if(ApptCountSql.length() > 0) ApptCountSql.delete(0,ApptCountSql.length());
		ApptCountSql.append(" SELECT COUNT (*) FROM oa_appt WHERE facility_id = '"+facilityid+"' AND referral_id IN ( SELECT referral_id FROM pr_referral_register WHERE to_ref_type = 'L' AND to_facility_id = '"+facilityid+"' AND from_encounter_id = '"+encounter_id+"') ");

		stmt	= connection.createStatement();
		rs		= stmt.executeQuery(ApptCountSql.toString());	

		if((rs != null) && (rs.next()))
		{
			ApptCount = rs.getInt(1);
		}

		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();


		if(referralCount == ApptCount)
			hashtable.put("DISCH_CHKLIST_STATUS","1");
		else
			hashtable.put("DISCH_CHKLIST_STATUS","0");

	}catch(Exception exp)
	{
		exp.printStackTrace();
	}
	*/
		
		hashtable.put("DISCH_CHKLIST_STATUS","1");

		hashtable.put("DISCHARGE_MEDICATION_YN", checkForNull(request.getParameter("h_dis_medication")));
		hashtable.put("DISCH_SUMMARY_SIGNED_YN", checkForNull(request.getParameter("h_dis_summ_prep")));
		hashtable.put("DISCH_SUMMARY_PREP_BY_ID", checkForNull(request.getParameter("h_dis_summ_prep_by")));
	
		String informed_to = request.getParameter("h_informed_to");
		if(!informed_to.equals(""))
			hashtable.put("INFORMED_YN","Y");
		else
			hashtable.put("INFORMED_YN","N");

		String cert_no = checkForNull(request.getParameter("h_cert_no"));
		if(cert_no.equals("Y"))
			hashtable.put("MEDICAL_CERT_AVAIL_YN","Y");
		else
			hashtable.put("MEDICAL_CERT_AVAIL_YN","N");

		hashtable.put("REM_ITEM01_YN", checkForNull(request.getParameter("h_iv_catheters_chk")));
		hashtable.put("REM_ITEM01_REMOVED_BY", checkForNull(request.getParameter("h_iv_removed_by")));

		String h_iv_removed_dt =	checkForNull(request.getParameter("h_iv_removed_dt"));
		if(!h_iv_removed_dt.equals(""))
			hashtable.put("REM_ITEM01_REMOVED_DATE",setDateValue(h_iv_removed_dt));
		else
			hashtable.put("REM_ITEM01_REMOVED_DATE","");
		h_iv_removed_dt = DateUtils.convertDate(h_iv_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM02_YN", checkForNull(request.getParameter("h_tubes_chk")));
		hashtable.put("REM_ITEM02_REMOVED_BY", checkForNull(request.getParameter("h_tubes_removed_by")));

		String h_tubes_removed_dt =	checkForNull(request.getParameter("h_tubes_removed_dt"));
		if(!h_tubes_removed_dt.equals(""))
			hashtable.put("REM_ITEM02_REMOVED_DATE",setDateValue(h_tubes_removed_dt));
		else
			hashtable.put("REM_ITEM02_REMOVED_DATE","");
		h_tubes_removed_dt = DateUtils.convertDate(h_tubes_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM03_YN", checkForNull(request.getParameter("h_drg_chk")));
		hashtable.put("REM_ITEM03_REMOVED_BY", checkForNull(request.getParameter("h_drg_removed_by")));

		String h_drg_removed_dt =	checkForNull(request.getParameter("h_drg_removed_dt"));
		if(!h_drg_removed_dt.equals(""))
			hashtable.put("REM_ITEM03_REMOVED_DATE",setDateValue(h_drg_removed_dt));
		else
			hashtable.put("REM_ITEM03_REMOVED_DATE","");
		h_drg_removed_dt = DateUtils.convertDate(h_drg_removed_dt,"DMYHM",locale,"en");
		

		hashtable.put("REM_ITEM04_YN", checkForNull(request.getParameter("h_ngt_tube_chk")));
		hashtable.put("REM_ITEM04_REMOVED_BY", checkForNull(request.getParameter("h_ngt_tube_removed_by")));

		String h_ngt_tube_removed_dt =	checkForNull(request.getParameter("h_ngt_tube_removed_dt"));
		if(!h_ngt_tube_removed_dt.equals(""))
			hashtable.put("REM_ITEM04_REMOVED_DATE",setDateValue(h_ngt_tube_removed_dt));
		else
			hashtable.put("REM_ITEM04_REMOVED_DATE","");
		h_ngt_tube_removed_dt = DateUtils.convertDate(h_ngt_tube_removed_dt,"DMYHM",locale,"en");
		

		hashtable.put("REM_ITEM05_YN", checkForNull(request.getParameter("h_cngt_tube_chk")));
		hashtable.put("REM_ITEM05_REMOVED_BY", checkForNull(request.getParameter("h_cngt_tube_removed_by")));

		String h_cngt_tube_removed_dt =	checkForNull(request.getParameter("h_cngt_tube_removed_dt"));
		if(!h_cngt_tube_removed_dt.equals(""))
			hashtable.put("REM_ITEM05_REMOVED_DATE",setDateValue(h_cngt_tube_removed_dt));
		else
			hashtable.put("REM_ITEM05_REMOVED_DATE","");
		h_cngt_tube_removed_dt = DateUtils.convertDate(h_cngt_tube_removed_dt,"DMYHM",locale,"en");

		
	   
		hashtable.put("REM_ITEM06_YN", checkForNull(request.getParameter("h_urn_chk")));
		hashtable.put("REM_ITEM06_REMOVED_BY", checkForNull(request.getParameter("h_urn_removed_by")));

		String h_urn_removed_dt =	checkForNull(request.getParameter("h_urn_removed_dt"));
		if(!h_urn_removed_dt.equals(""))
			hashtable.put("REM_ITEM06_REMOVED_DATE",setDateValue(h_urn_removed_dt));
		else
			hashtable.put("REM_ITEM06_REMOVED_DATE","");
		h_urn_removed_dt = DateUtils.convertDate(h_urn_removed_dt,"DMYHM",locale,"en");

		

		hashtable.put("REM_ITEM07_YN", checkForNull(request.getParameter("h_curn_chk")));
		hashtable.put("REM_ITEM07_REMOVED_BY", checkForNull(request.getParameter("h_curn_removed_by")));

		String h_curn_removed_dt =	checkForNull(request.getParameter("h_curn_removed_dt"));
		if(!h_curn_removed_dt.equals(""))
			hashtable.put("REM_ITEM07_REMOVED_DATE",setDateValue(h_curn_removed_dt));
		else
			hashtable.put("REM_ITEM07_REMOVED_DATE","");
		h_curn_removed_dt = DateUtils.convertDate(h_curn_removed_dt,"DMYHM",locale,"en");

		
		hashtable.put("REM_ITEM08_YN", checkForNull(request.getParameter("h_sto_chk")));
		hashtable.put("REM_ITEM08_REMOVED_BY", checkForNull(request.getParameter("h_sto_removed_by")));

		String h_sto_removed_dt =	checkForNull(request.getParameter("h_sto_removed_dt"));
		if(!h_sto_removed_dt.equals(""))
			hashtable.put("REM_ITEM08_REMOVED_DATE",setDateValue(h_sto_removed_dt));
		else
			hashtable.put("REM_ITEM08_REMOVED_DATE","");
		h_sto_removed_dt = DateUtils.convertDate(h_sto_removed_dt,"DMYHM",locale,"en");

		

		hashtable.put("REM_ITEM09_YN", checkForNull(request.getParameter("h_dressing_chk")));
		hashtable.put("REM_ITEM09_REMOVED_BY", checkForNull(request.getParameter("h_dressing_removed_by")));


		String h_dressing_removed_dt =	checkForNull(request.getParameter("h_dressing_removed_dt"));
		if(!h_dressing_removed_dt.equals(""))
			hashtable.put("REM_ITEM09_REMOVED_DATE",setDateValue(h_dressing_removed_dt));
		else
			hashtable.put("REM_ITEM09_REMOVED_DATE","");
		h_dressing_removed_dt = DateUtils.convertDate(h_dressing_removed_dt,"DMYHM",locale,"en");

		

		hashtable.put("BELONGINGS_RETN_YN", checkForNull(request.getParameter("h_blng_returned")));

		String h_blng_returned_dt =	checkForNull(request.getParameter("h_blng_returned_dt"));
		if(!h_blng_returned_dt.equals(""))
			hashtable.put("BELONGINGS_RETN_DATE",setDateValue(h_blng_returned_dt));
		else
			hashtable.put("BELONGINGS_RETN_DATE","");
		h_blng_returned_dt = DateUtils.convertDate(h_blng_returned_dt,"DMYHM",locale,"en");

		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		hashtable.put("REM_ITEM01_REMOVE_YN", checkForNull(request.getParameter("h_iv_remove_chk")));
		hashtable.put("REM_ITEM01_REMARKS", checkForNull(request.getParameter("h_iv_remarks")));
		hashtable.put("REM_ITEM02_REMOVE_YN", checkForNull(request.getParameter("h_tubes_remove_chk")));
		hashtable.put("REM_ITEM02_REMARKS", checkForNull(request.getParameter("h_tubes_remarks")));
		hashtable.put("REM_ITEM03_REMOVE_YN", checkForNull(request.getParameter("h_drg_remove_chk")));
		hashtable.put("REM_ITEM03_REMARKS", checkForNull(request.getParameter("h_drg_remarks")));
		hashtable.put("REM_ITEM04_REMOVE_YN", checkForNull(request.getParameter("h_ngt_remove_chk")));
		hashtable.put("REM_ITEM04_REMARKS", checkForNull(request.getParameter("h_ngt_remarks")));
		hashtable.put("REM_ITEM06_REMOVE_YN", checkForNull(request.getParameter("h_urn_remove_chk")));
		hashtable.put("REM_ITEM06_REMARKS", checkForNull(request.getParameter("h_urn_remarks")));
		hashtable.put("REM_ITEM08_REMOVE_YN", checkForNull(request.getParameter("h_sto_remove_chk")));
		hashtable.put("REM_ITEM08_REMARKS", checkForNull(request.getParameter("h_sto_remarks")));
		hashtable.put("REM_ITEM09_REMOVE_YN", checkForNull(request.getParameter("h_dressing_remove_chk")));
		hashtable.put("REM_ITEM09_REMARKS", checkForNull(request.getParameter("h_dressing_remarks")));
		/*End ML-MMOH-CRF-1142*/

		/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
		hashtable.put("REM_ITEM10_YN", checkForNull(request.getParameter("h_itemloan_chk")));
		hashtable.put("REM_ITEM10_REMOVED_BY", checkForNull(request.getParameter("h_itemloan_removed_by")));

		String h_itemloan_removed_dt =	checkForNull(request.getParameter("h_itemloan_removed_dt"));
		if(!h_itemloan_removed_dt.equals(""))
			hashtable.put("REM_ITEM10_REMOVED_DATE",setDateValue(h_itemloan_removed_dt));
		else
			hashtable.put("REM_ITEM10_REMOVED_DATE","");
		h_itemloan_removed_dt = DateUtils.convertDate(h_itemloan_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM10_REMOVE_YN", checkForNull(request.getParameter("h_itemloan_remove_chk")));
		hashtable.put("REM_ITEM10_REMARKS", checkForNull(request.getParameter("h_itemloan_remarks")));

		hashtable.put("REM_ITEM11_YN", checkForNull(request.getParameter("h_others_chk")));
		hashtable.put("REM_ITEM11_REMOVED_BY", checkForNull(request.getParameter("h_others_removed_by")));

		String h_others_removed_dt =	checkForNull(request.getParameter("h_others_removed_dt"));
		if(!h_others_removed_dt.equals(""))
			hashtable.put("REM_ITEM11_REMOVED_DATE",setDateValue(h_others_removed_dt));
		else
			hashtable.put("REM_ITEM11_REMOVED_DATE","");
		h_others_removed_dt = DateUtils.convertDate(h_others_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM11_REMOVE_YN", checkForNull(request.getParameter("h_others_remove_chk")));
		hashtable.put("REM_ITEM11_REMARKS", checkForNull(request.getParameter("h_others_remarks")));
		/*End ML-MMOH-CRF-1218*/
	  
		hashtable.put("BELONGINGS_REMARKS", checkForNull(request.getParameter("h_blng_remarks")));
		hashtable.put("VALUABLES_RETN_YN", checkForNull(request.getParameter("h_vlb_returned")));
		hashtable.put("VALUABLES_RETN_BY_ID", checkForNull(request.getParameter("h_vlb_user")));
		hashtable.put("VALUABLES_WITNESS_ID", checkForNull(request.getParameter("h_witness_id")));
		hashtable.put("TRANSPORT_ARRANGED_YN", checkForNull(request.getParameter("h_tp_arranged")));

		String h_tp_returned_dt =	checkForNull(request.getParameter("h_tp_returned_dt"));
		if(!h_tp_returned_dt.equals(""))
			hashtable.put("TRANSPORT_ARRANGED_DATE",setDateValue(h_tp_returned_dt));
		else
			hashtable.put("TRANSPORT_ARRANGED_DATE","");
		h_tp_returned_dt = DateUtils.convertDate(h_tp_returned_dt,"DMYHM",locale,"en");

		
		hashtable.put("TRANSPORT_REMARKS", checkForNull(request.getParameter("h_tp_remarks")));
		String h_adv_cnt_parent = checkForNull(request.getParameter("h_adv_cnt_parent"));
		String h_adv_cnt_guardian = checkForNull(request.getParameter("h_adv_cnt_guardian"));
		if(h_adv_cnt_parent.equals("Y") && h_adv_cnt_guardian.equals("Y"))
			hashtable.put("HED_ADVICE_GIVEN_TO","2"); 
		else if(h_adv_cnt_parent.equals("N") && h_adv_cnt_guardian.equals("Y"))
			hashtable.put("HED_ADVICE_GIVEN_TO","1"); 
		else if(h_adv_cnt_parent.equals("Y") && h_adv_cnt_guardian.equals("N"))
			hashtable.put("HED_ADVICE_GIVEN_TO","0");
		else 
			hashtable.put("HED_ADVICE_GIVEN_TO","");
		
		hashtable.put("HED_ITEM01_YN", checkForNull(request.getParameter("h_wc_chk")));
		hashtable.put("HED_ITEM01_GIVEN_BY", checkForNull(request.getParameter("h_wc_given_by")));

		String h_wc_given_dt =	checkForNull(request.getParameter("h_wc_given_dt"));
		if(!h_wc_given_dt.equals(""))
			hashtable.put("HED_ITEM01_DATE",setDateValue(h_wc_given_dt));
		else
			hashtable.put("HED_ITEM01_DATE","");
		h_wc_given_dt = DateUtils.convertDate(h_wc_given_dt,"DMYHM",locale,"en");
		
		
		hashtable.put("HED_ITEM02_YN", checkForNull(request.getParameter("h_nu_chk")));
		hashtable.put("HED_ITEM02_GIVEN_BY", checkForNull(request.getParameter("h_nu_given_by")));

		String h_nu_given_dt =	checkForNull(request.getParameter("h_nu_given_dt"));
		if(!h_nu_given_dt.equals(""))
			hashtable.put("HED_ITEM02_DATE",setDateValue(h_nu_given_dt));
		else
			hashtable.put("HED_ITEM02_DATE","");
		h_nu_given_dt = DateUtils.convertDate(h_nu_given_dt,"DMYHM",locale,"en");
			

		hashtable.put("HED_ITEM03_YN", checkForNull(request.getParameter("h_mc_chk")));
		hashtable.put("HED_ITEM03_GIVEN_BY", checkForNull(request.getParameter("h_mc_given_by")));

		String h_mc_given_dt =	checkForNull(request.getParameter("h_mc_given_dt"));
		if(!h_mc_given_dt.equals(""))
			hashtable.put("HED_ITEM03_DATE",setDateValue(h_mc_given_dt));
		else
			hashtable.put("HED_ITEM03_DATE","");
		h_mc_given_dt = DateUtils.convertDate(h_mc_given_dt,"DMYHM",locale,"en");

		
		
		hashtable.put("HED_ITEM04_YN", checkForNull(request.getParameter("h_ph_chk")));
		hashtable.put("HED_ITEM04_GIVEN_BY", checkForNull(request.getParameter("h_ph_given_by")));

		String h_ph_given_dt =	checkForNull(request.getParameter("h_ph_given_dt"));
		if(!h_ph_given_dt.equals(""))
			hashtable.put("HED_ITEM04_DATE",setDateValue(h_ph_given_dt));
		else
			hashtable.put("HED_ITEM04_DATE","");
		h_ph_given_dt = DateUtils.convertDate(h_ph_given_dt,"DMYHM",locale,"en");

		

		hashtable.put("HED_ITEM05_YN", checkForNull(request.getParameter("h_cop_chk")));
		hashtable.put("HED_ITEM05_GIVEN_BY", checkForNull(request.getParameter("h_cop_given_by")));

		String h_cop_given_dt =	checkForNull(request.getParameter("h_cop_given_dt"));
		if(!h_cop_given_dt.equals(""))
			hashtable.put("HED_ITEM05_DATE",setDateValue(h_cop_given_dt));
		else
			hashtable.put("HED_ITEM05_DATE","");
		h_cop_given_dt = DateUtils.convertDate(h_cop_given_dt,"DMYHM",locale,"en");

		

		hashtable.put("HED_ITEM06_YN", checkForNull(request.getParameter("h_coc_chk")));

		hashtable.put("HED_ITEM06_GIVEN_BY", checkForNull(request.getParameter("h_coc_given_by")));

		String h_coc_given_dt =	checkForNull(request.getParameter("h_coc_given_dt"));
		if(!h_coc_given_dt.equals(""))
			hashtable.put("HED_ITEM06_DATE",setDateValue(h_coc_given_dt));
		else
			hashtable.put("HED_ITEM06_DATE","");
		h_coc_given_dt = DateUtils.convertDate(h_coc_given_dt,"DMYHM",locale,"en");

		

		hashtable.put("HED_ITEM07_YN", checkForNull(request.getParameter("h_cot_chk")));
		hashtable.put("HED_ITEM07_GIVEN_BY", checkForNull(request.getParameter("h_cot_given_by")));

		String h_cot_given_dt =	checkForNull(request.getParameter("h_cot_given_dt"));
		if(!h_cot_given_dt.equals(""))
			hashtable.put("HED_ITEM07_DATE",setDateValue(h_cot_given_dt));
		else
			hashtable.put("HED_ITEM07_DATE","");
		h_cot_given_dt = DateUtils.convertDate(h_cot_given_dt,"DMYHM",locale,"en");

		

		hashtable.put("HED_OTHERS_YN", checkForNull(request.getParameter("h_oth_he_chk")));
		hashtable.put("HED_OTHERS", checkForNull(request.getParameter("h_oth_text")));
		hashtable.put("HED_OTHERS_GIVEN_BY", checkForNull(request.getParameter("h_oth_given_by")));

		String h_oth_given_dt =	checkForNull(request.getParameter("h_oth_given_dt"));
		if(!h_oth_given_dt.equals(""))
			hashtable.put("HED_OTHERS_DATE",setDateValue(h_oth_given_dt));
		else
			hashtable.put("HED_OTHERS_DATE","");
		h_oth_given_dt = DateUtils.convertDate(h_oth_given_dt,"DMYHM",locale,"en");

		

		hashtable.put("PHG_ITEM01_YN", checkForNull(request.getParameter("h_top_to_toe_chk")));
		hashtable.put("PHG_ITEM02_YN", checkForNull(request.getParameter("h_co_umb_stmp_chk")));
		hashtable.put("PHG_ITEM03_YN", checkForNull(request.getParameter("h_care_of_skin_chk")));
		hashtable.put("PHG_ITEM04_YN", checkForNull(request.getParameter("h_care_of_eye_chk")));
		hashtable.put("NUTR_ITEM01_YN", checkForNull(request.getParameter("h_expr_br_mlk_chk")));
		hashtable.put("NUTR_ITEM02_YN", checkForNull(request.getParameter("h_tube_feed_chk")));
		hashtable.put("NUTR_ITEM03_YN", checkForNull(request.getParameter("h_gst_feed_chk")));
		hashtable.put("NUTR_ITEM04_YN", checkForNull(request.getParameter("h_frm_milk_chk")));
		hashtable.put("NUTR_ITEM05_YN", checkForNull(request.getParameter("h_imn_sch_chk")));
		hashtable.put("NUTR_ITEM06_YN", checkForNull(request.getParameter("h_care_of_stoma_chk")));
		hashtable.put("NUTR_ITEM07_YN", checkForNull(request.getParameter("h_anl_dil_chk")));
		hashtable.put("NUTR_ITEM08_YN", checkForNull(request.getParameter("h_pop_chk")));
		hashtable.put("NUTR_ITEM09_YN", checkForNull(request.getParameter("h_fever_chk")));
		hashtable.put("NUTR_ITEM10_YN", checkForNull(request.getParameter("h_sz_chk")));
		hashtable.put("NUTR_ITEM11_YN", checkForNull(request.getParameter("h_jnd_chk")));
		hashtable.put("NUTR_ITEM12_YN", checkForNull(request.getParameter("h_gpd_chk")));
		hashtable.put("NUTR_ITEM13_YN", checkForNull(request.getParameter("h_stlc_chk")));
		hashtable.put("NUTR_ITEM14_YN", checkForNull(request.getParameter("h_stlf_chk")));
		hashtable.put("NUTR_ITEM15_YN", checkForNull(request.getParameter("h_coptb_chk")));
		hashtable.put("NUTR_ITEM16_YN", checkForNull(request.getParameter("h_oth_ph_chk")));
		hashtable.put("PLET_ITEM01_YN", checkForNull(request.getParameter("h_bfd_chk")));
		hashtable.put("PLET_ITEM02_YN", checkForNull(request.getParameter("h_stm_cr_chk")));
		hashtable.put("PLET_ITEM03_YN", checkForNull(request.getParameter("h_oper_chk")));
		hashtable.put("PLET_ITEM04_YN", checkForNull(request.getParameter("h_pop_care_chk")));
		hashtable.put("PLET_ITEM05_YN", checkForNull(request.getParameter("h_dn_given_chk")));
		hashtable.put("PLET_ITEM06_YN", checkForNull(request.getParameter("h_db_given_chk")));
		hashtable.put("PLET_OTHERS", checkForNull(request.getParameter("h_oth_pamphlets")));
		hashtable.put("APF_ITEM01", checkForNull(request.getParameter("h_oth_app_fix_item1")));
		hashtable.put("APF_ITEM01_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item1_given1")));

		String h_oth_app_fix_item1_dt1 =	checkForNull(request.getParameter("h_oth_app_fix_item1_dt1"));
		if(!h_oth_app_fix_item1_dt1.equals(""))
			hashtable.put("APF_ITEM01_DATE",setDateValue(h_oth_app_fix_item1_dt1));
		else
			hashtable.put("APF_ITEM01_DATE","");
		h_oth_app_fix_item1_dt1 = DateUtils.convertDate(h_oth_app_fix_item1_dt1,"DMYHM",locale,"en");
		
		
		
		hashtable.put("APF_ITEM02", checkForNull(request.getParameter("h_oth_app_fix_item2")));
		hashtable.put("APF_ITEM02_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item2_given2")));

		String h_oth_app_fix_item2_dt2 =	checkForNull(request.getParameter("h_oth_app_fix_item2_dt2"));
		if(!h_oth_app_fix_item2_dt2.equals(""))
			hashtable.put("APF_ITEM02_DATE",setDateValue(h_oth_app_fix_item2_dt2));
		else
			hashtable.put("APF_ITEM02_DATE","");
		h_oth_app_fix_item2_dt2 = DateUtils.convertDate(h_oth_app_fix_item2_dt2,"DMYHM",locale,"en");

		

		hashtable.put("APF_ITEM03", checkForNull(request.getParameter("h_oth_app_fix_item3")));
		hashtable.put("APF_ITEM03_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item3_given3")));

		String h_oth_app_fix_item3_dt3 =	checkForNull(request.getParameter("h_oth_app_fix_item3_dt3"));
		if(!h_oth_app_fix_item3_dt3.equals(""))
			hashtable.put("APF_ITEM03_DATE",setDateValue(h_oth_app_fix_item3_dt3));
		else
			hashtable.put("APF_ITEM03_DATE","");
		h_oth_app_fix_item3_dt3 = DateUtils.convertDate(h_oth_app_fix_item3_dt3,"DMYHM",locale,"en");

		

		hashtable.put("APF_ITEM04", checkForNull(request.getParameter("h_oth_app_fix_item4")));
		hashtable.put("APF_ITEM04_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item4_given4")));

		String h_oth_app_fix_item4_dt4 =	checkForNull(request.getParameter("h_oth_app_fix_item4_dt4"));
		if(!h_oth_app_fix_item4_dt4.equals(""))
			hashtable.put("APF_ITEM04_DATE",setDateValue(h_oth_app_fix_item4_dt4));
		else
			hashtable.put("APF_ITEM04_DATE","");
		h_oth_app_fix_item4_dt4 = DateUtils.convertDate(h_oth_app_fix_item4_dt4,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM05", checkForNull(request.getParameter("h_oth_app_fix_item5")));
		hashtable.put("APF_ITEM05_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item5_given5")));

		String h_oth_app_fix_item5_dt5 =	checkForNull(request.getParameter("h_oth_app_fix_item5_dt5"));
		if(!h_oth_app_fix_item5_dt5.equals(""))
			hashtable.put("APF_ITEM05_DATE",setDateValue(h_oth_app_fix_item5_dt5));
		else
			hashtable.put("APF_ITEM05_DATE","");
		h_oth_app_fix_item5_dt5 = DateUtils.convertDate(h_oth_app_fix_item5_dt5,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM06", checkForNull(request.getParameter("h_oth_app_fix_item6")));
		hashtable.put("APF_ITEM06_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item6_given6")));

		String h_oth_app_fix_item6_dt6 =	checkForNull(request.getParameter("h_oth_app_fix_item6_dt6"));
		if(!h_oth_app_fix_item6_dt6.equals(""))
			hashtable.put("APF_ITEM06_DATE",setDateValue(h_oth_app_fix_item6_dt6));
		else
			hashtable.put("APF_ITEM06_DATE","");
		h_oth_app_fix_item6_dt6 = DateUtils.convertDate(h_oth_app_fix_item6_dt6,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM07", checkForNull(request.getParameter("h_oth_app_fix_item7")));
		hashtable.put("APF_ITEM07_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item7_given7")));

		String h_oth_app_fix_item7_dt7 =	checkForNull(request.getParameter("h_oth_app_fix_item7_dt7"));
		if(!h_oth_app_fix_item7_dt7.equals(""))
			hashtable.put("APF_ITEM07_DATE",setDateValue(h_oth_app_fix_item7_dt7));
		else
			hashtable.put("APF_ITEM07_DATE","");
		h_oth_app_fix_item7_dt7 = DateUtils.convertDate(h_oth_app_fix_item7_dt7,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM08", checkForNull(request.getParameter("h_oth_app_fix_item8")));
		hashtable.put("APF_ITEM08_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item8_given8")));

		String h_oth_app_fix_item8_dt8 =	checkForNull(request.getParameter("h_oth_app_fix_item8_dt8"));
		if(!h_oth_app_fix_item8_dt8.equals(""))
			hashtable.put("APF_ITEM08_DATE",setDateValue(h_oth_app_fix_item8_dt8));
		else
			hashtable.put("APF_ITEM08_DATE","");
		h_oth_app_fix_item8_dt8 = DateUtils.convertDate(h_oth_app_fix_item8_dt8,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM09", checkForNull(request.getParameter("h_oth_app_fix_item9")));
		hashtable.put("APF_ITEM09_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item9_given9")));

		String h_oth_app_fix_item9_dt9 =	checkForNull(request.getParameter("h_oth_app_fix_item9_dt9"));
		if(!h_oth_app_fix_item9_dt9.equals(""))
			hashtable.put("APF_ITEM09_DATE",setDateValue(h_oth_app_fix_item9_dt9));
		else
			hashtable.put("APF_ITEM09_DATE","");
		h_oth_app_fix_item9_dt9 = DateUtils.convertDate(h_oth_app_fix_item9_dt9,"DMYHM",locale,"en");

		
		hashtable.put("APF_ITEM10", checkForNull(request.getParameter("h_oth_app_fix_item10")));
		hashtable.put("APF_ITEM10_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item10_given10")));

		String h_oth_app_fix_item10_dt10 =	checkForNull(request.getParameter("h_oth_app_fix_item10_dt10"));
		if(!h_oth_app_fix_item10_dt10.equals(""))
			hashtable.put("APF_ITEM10_DATE",setDateValue(h_oth_app_fix_item10_dt10));
		else
			hashtable.put("APF_ITEM10_DATE","");
		h_oth_app_fix_item10_dt10 = DateUtils.convertDate(h_oth_app_fix_item10_dt10,"DMYHM",locale,"en");

		
		hashtable.put("ODC_REF_LTR_YN", checkForNull(request.getParameter("h_ref_ltr_chk")));
		hashtable.put("ODC_REF_LTR_CONF_YN", checkForNull(request.getParameter("h_confirm_chk")));
		hashtable.put("ODC_ITEM01_YN", checkForNull(request.getParameter("h_rep_ltr_chk")));
		hashtable.put("ODC_ITEM01_DETAIL1", checkForNull(request.getParameter("h_rep_dtl_txt")));
		hashtable.put("ODC_ITEM01_DETAIL2", checkForNull(request.getParameter("h_rep_cnf_txt")));
		hashtable.put("ODC_ITEM02_YN", checkForNull(request.getParameter("h_cln_doc_chk")));
		hashtable.put("ODC_ITEM02_DETAIL1", checkForNull(request.getParameter("h_cln_dtl_txt")));
		hashtable.put("ODC_ITEM02_DETAIL2", checkForNull(request.getParameter("h_cln_cnf_txt")));
		hashtable.put("ODC_OTHERS_YN", checkForNull(request.getParameter("h_oth_doc_chk")));
		hashtable.put("ODC_OTHERS_DESC", checkForNull(request.getParameter("h_oth_doc_txt")));
		hashtable.put("ODC_OTHERS_DETAIL1", checkForNull(request.getParameter("h_oth_dtl_txt1")));
		hashtable.put("ODC_OTHERS_DETAIL2", checkForNull(request.getParameter("h_oth_cnf_txt1")));
		hashtable.put("LWA_RELATIONSHIP", checkForNull(request.getParameter("h_relationship")));
		
		String h_rel_date_time =	checkForNull(request.getParameter("h_rel_date_time"));
		
		if(!h_rel_date_time.equals(""))
			hashtable.put("LWA_DATE",setDateValue(h_rel_date_time));
		else
			hashtable.put("LWA_DATE","");
		h_rel_date_time = DateUtils.convertDate(h_rel_date_time,"DMYHM",locale,"en");
		
				
		hashtable.put("LWA_REMARKS", checkForNull(request.getParameter("h_rem_lv_ward")));
		hashtable.put("SCH_PATIENT_NAME", checkForNull(request.getParameter("h_name_of_patient")));
		hashtable.put("SCH_MOTHERS_NRIC", checkForNull(request.getParameter("h_mot_ic_no")));

		hashtable.put("SCH_R_NURSE", checkForNull(request.getParameter("h_rn_txt")));
		hashtable.put("SCH_WARD", checkForNull(request.getParameter("h_ward_txt")));

		String h_discharge_date =	checkForNull(request.getParameter("h_discharge_date"));
		if(!h_discharge_date.equals(""))
			hashtable.put("SCH_DATE_OF_DISCH",setDateValue(h_discharge_date));
		else
			hashtable.put("SCH_DATE_OF_DISCH","");
		h_discharge_date = DateUtils.convertDate(h_discharge_date,"DMYHM",locale,"en");

		
		hashtable.put("SCH_WEIGHT", checkForNull(request.getParameter("h_weight_txt")));
		hashtable.put("SCH_LENGTH", checkForNull(request.getParameter("h_length_txt")));
		hashtable.put("SCH_HEAD_CIR", checkForNull(request.getParameter("h_head_circum")));
		hashtable.put("SCH_ADVICE_GIVEN_TO", checkForNull(request.getParameter("h_adv_given")));
		hashtable.put("SCH_RELATIONSHIP", checkForNull(request.getParameter("h_relationship_txt")));

		hashtable.put("SCH_MOTHERS_NAME", checkForNull(request.getParameter("h_mother_name")));
		hashtable.put("SCH_MOTHERS_NRIC", checkForNull(request.getParameter("h_mother_no")));
		hashtable.put("SCH_FATHERS_NAME", checkForNull(request.getParameter("h_father_name")));
		hashtable.put("SCH_FATHERS_NRIC", checkForNull(request.getParameter("h_father_no")));
		hashtable.put("SCH_OTHER", checkForNull(request.getParameter("h_Remarks")));

		hashtable.put("DISCH_CHKLIST_PREPARED_BY",login_user);
		hashtable.put("DISCH_CHKLIST_CONFIRMED_BY",login_user);                       
		hashtable.put("ADDED_BY_ID", login_user);
		hashtable.put("ADDED_DATE",date );
		hashtable.put("ADDED_FACILITY_ID", facilityId);
		hashtable.put("ADDED_AT_WS_NO", s6);
		hashtable.put("MODIFIED_BY_ID", login_user);
		hashtable.put("MODIFIED_DATE", date1);
		hashtable.put("MODIFIED_FACILITY_ID", facilityId);
		hashtable.put("MODIFIED_AT_WS_NO", s7);

		//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
		String  cert_num = checkForNull(request.getParameter("cert_num"));
		hashtable.put("CERTIFICATE_NUM", cert_num);

		String cert_from_date =	checkForNull(request.getParameter("cert_from_date"));
		if(!cert_from_date.equals(""))
			hashtable.put("CERT_FROM_DATE",setDateValueDMY(cert_from_date));
		else
			hashtable.put("CERT_FROM_DATE","");
		cert_from_date = DateUtils.convertDate(cert_from_date,"DMY",locale,"en");

		String cert_to_date =	checkForNull(request.getParameter("cert_to_date"));
		if(!cert_to_date.equals(""))
			hashtable.put("CERT_TO_DATE",setDateValueDMY(cert_to_date));
		else
			hashtable.put("CERT_TO_DATE","");
		cert_to_date = DateUtils.convertDate(cert_to_date,"DMY",locale,"en");

		String  duration = checkForNull(request.getParameter("duration"));
		hashtable.put("DURATION", duration);

		String  duration_dmy = checkForNull(request.getParameter("duration_dmy"));
		if(!duration.equals(""))
		hashtable.put("DURATION_DMY", duration_dmy);
		//end ML-MMOH-CRF-0620
		//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050
        String  deli_cert_num = checkForNull(request.getParameter("deli_cert_num"));
		hashtable.put("DELI_CERT_NUM", deli_cert_num);
		String chargeable_medn_yn =checkForNull(request.getParameter("h_chargeable_item_yn"));//Adding start by chandra for MMS-KH-CRF-0052.1
		if(chargeable_medn_yn.equals(""))
			chargeable_medn_yn="N";
		hashtable.put("CHARGEABLE_ITEM_YN", chargeable_medn_yn);//Adding end for MMS-KH-CRF-0052.1
		
		String as[] = {	"facility_id","encounter_id"};
		String  informed_date = checkForNull(request.getParameter("h_informed_date"));

		informed_date = DateUtils.convertDate(informed_date,"DMYHM",locale,"en");

		String tableName = "IP_DISCHARGE_CHECKLIST";
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = hashtable;
		argArray[2] = as;
		argArray[3] = tableName;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = hashtable.getClass();
		paramArray[2] = as.getClass();
		paramArray[3] = tableName.getClass();

		java.util.HashMap hashtable1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean flag	= ( ((Boolean) hashtable1.get( "status" )).booleanValue() ) ;
		String error = (String)hashtable1.get("error");
		if(flag)
		{
			PreparedStatement pstmt = null;
			String modified_inform_to  = checkForNull(request.getParameter("h_inform_to"));
			String modified_informed_date  = informed_date;
			String modified_informed_name  = checkForNull(request.getParameter("h_informed_name"));
			String patient_id  = checkForNull(request.getParameter("patient_id"));
			int result = 0;
			
			try
			{

				if(!modified_inform_to.equals(""))
				{
					String updateSql =" update IP_DISCHARGE_ADVICE set INFORMED_TO = ?, INFORMED_NAME = ?, INFORMED_DATE_TIME = to_date(?,'dd/mm/rrrr hh24:mi'), MODIFIED_BY_ID= '"+login_user+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+s7+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where  FACILITY_ID = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? and  DIS_ADV_STATUS in ('0','1') ";

					pstmt = connection.prepareStatement(updateSql);
					pstmt.setString	( 1, modified_inform_to ) ;
					pstmt.setString	( 2, modified_informed_name);
					pstmt.setString	( 3, modified_informed_date ) ;
					pstmt.setString	( 4, facilityid ) ;
					pstmt.setString	( 5, encounter_id ) ;
					pstmt.setString	( 6, patient_id ) ;

					result = pstmt.executeUpdate() ;
					if(result > 0)
						flag = true ;
					else
						flag = false;
					if(pstmt != null) pstmt.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

			if(flag)
			{
				connection.commit();
				Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
				error = (String)hashtable2.get("message");
				hashtable2.clear();
			}
			else
			{
				error = "record not modified...Error in updation";
			}

		} else
		{                
			error = (String)hashtable1.get("error");                
		}

		if(error.lastIndexOf("<br>")>=0)
		error = error.substring(0, error.indexOf("<br>"));
		//out.println("<script>alert(\" " + error + "\");parent.window.close();</script>");
		out.println("<script>alert(\"" + error + "\");const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();</script>");

		hashtable.clear();
		hashtable1.clear();
		
	}
	catch(Exception exception)
	{
		exception.printStackTrace();           
	}
	finally{
		if(connection != null)
				ConnectionManager.returnConnection(connection, request);
	}
}

private void modifyData(HttpServletRequest request)
{

	java.sql.Connection connection = null;
	//Statement stmt			= null; //Commented by Suji Keerthi for Checkstyle
	//ResultSet rs			= null; //Commented by Suji Keerthi for Checkstyle

	try
	{
		connection = ConnectionManager.getConnection(request);	
		facilityid = request.getParameter("facility_id");
		String encounter_id = request.getParameter("encounter_id");
		String login_user = p.getProperty("login_user");
		String s1 = dateFormat.format(new java.util.Date());
		String s3 = s1;
		String s6 = client_ip_address;
		String s7 = s6;
		java.sql.Date date1 = java.sql.Date.valueOf(s3);

		HashMap hashtable = new HashMap();
		hashtable.put("DISCHARGE_MEDICATION_YN", checkForNull(request.getParameter("h_dis_medication")));
		hashtable.put("DISCH_SUMMARY_SIGNED_YN", checkForNull(request.getParameter("h_dis_summ_prep")));
		hashtable.put("DISCH_SUMMARY_PREP_BY_ID", checkForNull(request.getParameter("h_dis_summ_prep_by")));
		String chargeable_medn_yn =checkForNull(request.getParameter("h_chargeable_item_yn"));//Adding start by chandra for MMS-KH-CRF-0052.1
		if(chargeable_medn_yn.equals(""))
			chargeable_medn_yn="N";
		hashtable.put("CHARGEABLE_ITEM_YN", chargeable_medn_yn);//Adding end for MMS-KH-CRF-0052.1
		
		String informed_to = checkForNull(request.getParameter("h_informed_to"));
		
		if(!informed_to.equals(""))
			hashtable.put("INFORMED_YN","Y");
		else
			hashtable.put("INFORMED_YN","N");

	/*
		commented by mujafar for ML-MMOH-SCF-1032
		
		int referralCount = 0;
		int ApptCount = 0;
	
	try
	{
		
		StringBuffer RefCountSql = new StringBuffer();
		if(RefCountSql.length() > 0) RefCountSql.delete(0,RefCountSql.length());
		RefCountSql.append(" SELECT COUNT (*)  FROM pr_referral_register WHERE to_ref_type = 'L' AND to_facility_id = '"+facilityid+"' AND from_encounter_id = '"+encounter_id+"' ");

		stmt	= connection.createStatement();
		rs		= stmt.executeQuery(RefCountSql.toString());	

		if((rs != null) && (rs.next()))
		{
			referralCount = rs.getInt(1);
		}
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();

		StringBuffer ApptCountSql = new StringBuffer();
		if(ApptCountSql.length() > 0) ApptCountSql.delete(0,ApptCountSql.length());
		ApptCountSql.append(" SELECT COUNT (*)  FROM oa_appt WHERE facility_id = '"+facilityid+"' AND referral_id IN ( SELECT referral_id FROM pr_referral_register WHERE to_ref_type = 'L' AND to_facility_id = '"+facilityid+"' AND from_encounter_id = '"+encounter_id+"') ");

		stmt	= connection.createStatement();
		rs		= stmt.executeQuery(ApptCountSql.toString());	

		if((rs != null) && (rs.next()))
		{
			ApptCount = rs.getInt(1);
		}

		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();


		if(referralCount == ApptCount)
			hashtable.put("DISCH_CHKLIST_STATUS","1");
		else
			hashtable.put("DISCH_CHKLIST_STATUS","0");
	
	}catch(Exception exp)
	{
		exp.printStackTrace();           
	}
	*/
	
		hashtable.put("DISCH_CHKLIST_STATUS","1");
		
		String cert_no = checkForNull(request.getParameter("cert_no"));
		if(!cert_no.equals(""))
		hashtable.put("MEDICAL_CERT_AVAIL_YN","Y");
		else
		hashtable.put("MEDICAL_CERT_AVAIL_YN","N");


		hashtable.put("REM_ITEM01_YN", checkForNull(request.getParameter("h_iv_catheters_chk")));
		hashtable.put("REM_ITEM01_REMOVED_BY", checkForNull(request.getParameter("h_iv_removed_by")));

		String h_iv_removed_dt =	checkForNull(request.getParameter("h_iv_removed_dt"));
		if(!h_iv_removed_dt.equals(""))
			hashtable.put("REM_ITEM01_REMOVED_DATE",setDateValue(h_iv_removed_dt));
		else
			hashtable.put("REM_ITEM01_REMOVED_DATE","");
		h_iv_removed_dt = DateUtils.convertDate(h_iv_removed_dt,"DMYHM",locale,"en");


		hashtable.put("REM_ITEM02_YN", checkForNull(request.getParameter("h_tubes_chk")));
		hashtable.put("REM_ITEM02_REMOVED_BY", checkForNull(request.getParameter("h_tubes_removed_by")));

		String h_tubes_removed_dt =	checkForNull(request.getParameter("h_tubes_removed_dt"));
		if(!h_tubes_removed_dt.equals(""))
			hashtable.put("REM_ITEM02_REMOVED_DATE",setDateValue(h_tubes_removed_dt));
		else
			hashtable.put("REM_ITEM02_REMOVED_DATE","");
		h_tubes_removed_dt = DateUtils.convertDate(h_tubes_removed_dt,"DMYHM",locale,"en");

	
		hashtable.put("REM_ITEM03_YN", checkForNull(request.getParameter("h_drg_chk")));
		hashtable.put("REM_ITEM03_REMOVED_BY", checkForNull(request.getParameter("h_drg_removed_by")));

		String h_drg_removed_dt =	checkForNull(request.getParameter("h_drg_removed_dt"));
		if(!h_drg_removed_dt.equals(""))
			hashtable.put("REM_ITEM03_REMOVED_DATE",setDateValue(h_drg_removed_dt));
		else
			hashtable.put("REM_ITEM03_REMOVED_DATE","");
		h_drg_removed_dt = DateUtils.convertDate(h_drg_removed_dt,"DMYHM",locale,"en");


		hashtable.put("REM_ITEM04_YN", checkForNull(request.getParameter("h_ngt_tube_chk")));
		hashtable.put("REM_ITEM04_REMOVED_BY", checkForNull(request.getParameter("h_ngt_tube_removed_by")));

		String h_ngt_tube_removed_dt =	checkForNull(request.getParameter("h_ngt_tube_removed_dt"));
		if(!h_ngt_tube_removed_dt.equals(""))
			hashtable.put("REM_ITEM04_REMOVED_DATE",setDateValue(h_ngt_tube_removed_dt));
		else
			hashtable.put("REM_ITEM04_REMOVED_DATE","");
		h_ngt_tube_removed_dt = DateUtils.convertDate(h_ngt_tube_removed_dt,"DMYHM",locale,"en");


		hashtable.put("REM_ITEM05_YN", checkForNull(request.getParameter("h_cngt_tube_chk")));
		hashtable.put("REM_ITEM05_REMOVED_BY", checkForNull(request.getParameter("h_cngt_tube_removed_by")));

		String h_cngt_tube_removed_dt =	checkForNull(request.getParameter("h_cngt_tube_removed_dt"));
		if(!h_cngt_tube_removed_dt.equals(""))
			hashtable.put("REM_ITEM05_REMOVED_DATE",setDateValue(h_cngt_tube_removed_dt));
		else
			hashtable.put("REM_ITEM05_REMOVED_DATE","");
		h_cngt_tube_removed_dt = DateUtils.convertDate(h_cngt_tube_removed_dt,"DMYHM",locale,"en");
		
	   
		hashtable.put("REM_ITEM06_YN", checkForNull(request.getParameter("h_urn_chk")));
		hashtable.put("REM_ITEM06_REMOVED_BY", checkForNull(request.getParameter("h_urn_removed_by")));

		String h_urn_removed_dt =	checkForNull(request.getParameter("h_urn_removed_dt"));
		if(!h_urn_removed_dt.equals(""))
			hashtable.put("REM_ITEM06_REMOVED_DATE",setDateValue(h_urn_removed_dt));
		else
			hashtable.put("REM_ITEM06_REMOVED_DATE","");
		h_urn_removed_dt = DateUtils.convertDate(h_urn_removed_dt,"DMYHM",locale,"en");
		

		hashtable.put("REM_ITEM07_YN", checkForNull(request.getParameter("h_curn_chk")));
		hashtable.put("REM_ITEM07_REMOVED_BY", checkForNull(request.getParameter("h_curn_removed_by")));

		String h_curn_removed_dt =	checkForNull(request.getParameter("h_curn_removed_dt"));
		if(!h_curn_removed_dt.equals(""))
			hashtable.put("REM_ITEM07_REMOVED_DATE",setDateValue(h_curn_removed_dt));
		else
			hashtable.put("REM_ITEM07_REMOVED_DATE","");
		h_curn_removed_dt = DateUtils.convertDate(h_curn_removed_dt,"DMYHM",locale,"en");
		
		
		hashtable.put("REM_ITEM08_YN", checkForNull(request.getParameter("h_sto_chk")));
		hashtable.put("REM_ITEM08_REMOVED_BY", checkForNull(request.getParameter("h_sto_removed_by")));

		String h_sto_removed_dt =	checkForNull(request.getParameter("h_sto_removed_dt"));
		if(!h_sto_removed_dt.equals(""))
			hashtable.put("REM_ITEM08_REMOVED_DATE",setDateValue(h_sto_removed_dt));
		else
			hashtable.put("REM_ITEM08_REMOVED_DATE","");
		h_sto_removed_dt = DateUtils.convertDate(h_sto_removed_dt,"DMYHM",locale,"en");

	 

		hashtable.put("REM_ITEM09_YN", checkForNull(request.getParameter("h_dressing_chk")));
		hashtable.put("REM_ITEM09_REMOVED_BY", checkForNull(request.getParameter("h_dressing_removed_by")));


		String h_dressing_removed_dt =	checkForNull(request.getParameter("h_dressing_removed_dt"));
		if(!h_dressing_removed_dt.equals(""))
			hashtable.put("REM_ITEM09_REMOVED_DATE",setDateValue(h_dressing_removed_dt));
		else
			hashtable.put("REM_ITEM09_REMOVED_DATE","");
		h_dressing_removed_dt = DateUtils.convertDate(h_dressing_removed_dt,"DMYHM",locale,"en");

		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		hashtable.put("REM_ITEM01_REMOVE_YN", checkForNull(request.getParameter("h_iv_remove_chk")));
		hashtable.put("REM_ITEM01_REMARKS", checkForNull(request.getParameter("h_iv_remarks")));
		hashtable.put("REM_ITEM02_REMOVE_YN", checkForNull(request.getParameter("h_tubes_remove_chk")));
		hashtable.put("REM_ITEM02_REMARKS", checkForNull(request.getParameter("h_tubes_remarks")));
		hashtable.put("REM_ITEM03_REMOVE_YN", checkForNull(request.getParameter("h_drg_remove_chk")));
		hashtable.put("REM_ITEM03_REMARKS", checkForNull(request.getParameter("h_drg_remarks")));
		hashtable.put("REM_ITEM04_REMOVE_YN", checkForNull(request.getParameter("h_ngt_remove_chk")));
		hashtable.put("REM_ITEM04_REMARKS", checkForNull(request.getParameter("h_ngt_remarks")));
		hashtable.put("REM_ITEM06_REMOVE_YN", checkForNull(request.getParameter("h_urn_remove_chk")));
		hashtable.put("REM_ITEM06_REMARKS", checkForNull(request.getParameter("h_urn_remarks")));
		hashtable.put("REM_ITEM08_REMOVE_YN", checkForNull(request.getParameter("h_sto_remove_chk")));
		hashtable.put("REM_ITEM08_REMARKS", checkForNull(request.getParameter("h_sto_remarks")));
		hashtable.put("REM_ITEM09_REMOVE_YN", checkForNull(request.getParameter("h_dressing_remove_chk")));
		hashtable.put("REM_ITEM09_REMARKS", checkForNull(request.getParameter("h_dressing_remarks")));
		/*End ML-MMOH-CRF-1142*/

		/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
		hashtable.put("REM_ITEM10_YN", checkForNull(request.getParameter("h_itemloan_chk")));
		hashtable.put("REM_ITEM10_REMOVED_BY", checkForNull(request.getParameter("h_itemloan_removed_by")));

		String h_itemloan_removed_dt =	checkForNull(request.getParameter("h_itemloan_removed_dt"));
		if(!h_itemloan_removed_dt.equals(""))
			hashtable.put("REM_ITEM10_REMOVED_DATE",setDateValue(h_itemloan_removed_dt));
		else
			hashtable.put("REM_ITEM10_REMOVED_DATE","");
		h_itemloan_removed_dt = DateUtils.convertDate(h_itemloan_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM10_REMOVE_YN", checkForNull(request.getParameter("h_itemloan_remove_chk")));
		hashtable.put("REM_ITEM10_REMARKS", checkForNull(request.getParameter("h_itemloan_remarks")));

		hashtable.put("REM_ITEM11_YN", checkForNull(request.getParameter("h_others_chk")));
		hashtable.put("REM_ITEM11_REMOVED_BY", checkForNull(request.getParameter("h_others_removed_by")));

		String h_others_removed_dt =	checkForNull(request.getParameter("h_others_removed_dt"));
		if(!h_others_removed_dt.equals(""))
			hashtable.put("REM_ITEM11_REMOVED_DATE",setDateValue(h_others_removed_dt));
		else
			hashtable.put("REM_ITEM11_REMOVED_DATE","");
		h_others_removed_dt = DateUtils.convertDate(h_others_removed_dt,"DMYHM",locale,"en");

		hashtable.put("REM_ITEM11_REMOVE_YN", checkForNull(request.getParameter("h_others_remove_chk")));
		hashtable.put("REM_ITEM11_REMARKS", checkForNull(request.getParameter("h_others_remarks")));
		/*End ML-MMOH-CRF-1218*/
		

		hashtable.put("BELONGINGS_RETN_YN", checkForNull(request.getParameter("h_blng_returned")));

		String h_blng_returned_dt =	checkForNull(request.getParameter("h_blng_returned_dt"));
		if(!h_blng_returned_dt.equals(""))
			hashtable.put("BELONGINGS_RETN_DATE",setDateValue(h_blng_returned_dt));
		else
			hashtable.put("BELONGINGS_RETN_DATE","");
		h_blng_returned_dt = DateUtils.convertDate(h_blng_returned_dt,"DMYHM",locale,"en");

			  
		hashtable.put("BELONGINGS_REMARKS", checkForNull(request.getParameter("h_blng_remarks")));
		hashtable.put("VALUABLES_RETN_YN", checkForNull(request.getParameter("h_vlb_returned")));
		hashtable.put("VALUABLES_RETN_BY_ID", checkForNull(request.getParameter("h_vlb_user")));

		hashtable.put("VALUABLES_WITNESS_ID", checkForNull(request.getParameter("h_witness_id")));
		hashtable.put("TRANSPORT_ARRANGED_YN", checkForNull(request.getParameter("h_tp_arranged")));

		String h_tp_returned_dt =	checkForNull(request.getParameter("h_tp_returned_dt"));
		if(!h_tp_returned_dt.equals("")) 
			hashtable.put("TRANSPORT_ARRANGED_DATE",setDateValue(h_tp_returned_dt));
		else
			hashtable.put("TRANSPORT_ARRANGED_DATE","");
		h_tp_returned_dt = DateUtils.convertDate(h_tp_returned_dt,"DMYHM",locale,"en");


		hashtable.put("TRANSPORT_REMARKS", checkForNull(request.getParameter("h_tp_remarks")));

		String h_adv_cnt_parent = checkForNull(request.getParameter("h_adv_cnt_parent"));
		String h_adv_cnt_guardian = checkForNull(request.getParameter("h_adv_cnt_guardian"));
		if(h_adv_cnt_parent.equals("Y") && h_adv_cnt_guardian.equals("Y"))
		{hashtable.put("HED_ADVICE_GIVEN_TO","2"); }
		else if(h_adv_cnt_parent.equals("N") && h_adv_cnt_guardian.equals("Y"))
		{hashtable.put("HED_ADVICE_GIVEN_TO","1"); }
		else if(h_adv_cnt_parent.equals("Y") && h_adv_cnt_guardian.equals("N"))
		hashtable.put("HED_ADVICE_GIVEN_TO","0");
		else hashtable.put("HED_ADVICE_GIVEN_TO","");
		

		hashtable.put("HED_ITEM01_YN", checkForNull(request.getParameter("h_wc_chk")));
		hashtable.put("HED_ITEM01_GIVEN_BY", checkForNull(request.getParameter("h_wc_given_by")));

		String h_wc_given_dt =	checkForNull(request.getParameter("h_wc_given_dt"));
		if(!h_wc_given_dt.equals(""))
			hashtable.put("HED_ITEM01_DATE",setDateValue(h_wc_given_dt));
		else
			hashtable.put("HED_ITEM01_DATE","");
		h_wc_given_dt = DateUtils.convertDate(h_wc_given_dt,"DMYHM",locale,"en");

		
		hashtable.put("HED_ITEM02_YN", checkForNull(request.getParameter("h_nu_chk")));
		hashtable.put("HED_ITEM02_GIVEN_BY", checkForNull(request.getParameter("h_nu_given_by")));

		String h_nu_given_dt =	checkForNull(request.getParameter("h_nu_given_dt"));
		if(!h_nu_given_dt.equals(""))
			hashtable.put("HED_ITEM02_DATE",setDateValue(h_nu_given_dt));
		else
			hashtable.put("HED_ITEM02_DATE","");
		h_nu_given_dt = DateUtils.convertDate(h_nu_given_dt,"DMYHM",locale,"en");
		

		hashtable.put("HED_ITEM03_YN", checkForNull(request.getParameter("h_mc_chk")));
		hashtable.put("HED_ITEM03_GIVEN_BY", checkForNull(request.getParameter("h_mc_given_by")));

		String h_mc_given_dt =	checkForNull(request.getParameter("h_mc_given_dt"));
		if(!h_mc_given_dt.equals(""))
			hashtable.put("HED_ITEM03_DATE",setDateValue(h_mc_given_dt));
		else
			hashtable.put("HED_ITEM03_DATE","");
		h_mc_given_dt = DateUtils.convertDate(h_mc_given_dt,"DMYHM",locale,"en");
		

		hashtable.put("HED_ITEM04_YN", checkForNull(request.getParameter("h_ph_chk")));
		hashtable.put("HED_ITEM04_GIVEN_BY", checkForNull(request.getParameter("h_ph_given_by")));

		String h_ph_given_dt =	checkForNull(request.getParameter("h_ph_given_dt"));
		if(!h_ph_given_dt.equals(""))
			hashtable.put("HED_ITEM04_DATE",setDateValue(h_ph_given_dt));
		else
			hashtable.put("HED_ITEM04_DATE","");
		h_ph_given_dt = DateUtils.convertDate(h_ph_given_dt,"DMYHM",locale,"en");


		hashtable.put("HED_ITEM05_YN", checkForNull(request.getParameter("h_cop_chk")));
		hashtable.put("HED_ITEM05_GIVEN_BY", checkForNull(request.getParameter("h_cop_given_by")));

		String h_cop_given_dt =	checkForNull(request.getParameter("h_cop_given_dt"));
		if(!h_cop_given_dt.equals(""))
			hashtable.put("HED_ITEM05_DATE",setDateValue(h_cop_given_dt));
		else
			hashtable.put("HED_ITEM05_DATE","");
		h_cop_given_dt = DateUtils.convertDate(h_cop_given_dt,"DMYHM",locale,"en");
		

		hashtable.put("HED_ITEM06_YN", checkForNull(request.getParameter("h_coc_chk")));

		hashtable.put("HED_ITEM06_GIVEN_BY", checkForNull(request.getParameter("h_coc_given_by")));

		String h_coc_given_dt =	checkForNull(request.getParameter("h_coc_given_dt"));
		if(!h_coc_given_dt.equals(""))
			hashtable.put("HED_ITEM06_DATE",setDateValue(h_coc_given_dt));
		else
			hashtable.put("HED_ITEM06_DATE","");
		h_coc_given_dt = DateUtils.convertDate(h_coc_given_dt,"DMYHM",locale,"en");
		

		hashtable.put("HED_ITEM07_YN", checkForNull(request.getParameter("h_cot_chk")));
		hashtable.put("HED_ITEM07_GIVEN_BY", checkForNull(request.getParameter("h_cot_given_by")));

		String h_cot_given_dt =	checkForNull(request.getParameter("h_cot_given_dt"));
		if(!h_cot_given_dt.equals(""))
		{
		hashtable.put("HED_ITEM07_DATE",setDateValue(h_cot_given_dt));
		}
		else
		{
		hashtable.put("HED_ITEM07_DATE","");
		}
		h_cot_given_dt = DateUtils.convertDate(h_cot_given_dt,"DMYHM",locale,"en");

		hashtable.put("HED_OTHERS_YN", checkForNull(request.getParameter("h_oth_he_chk")));
		hashtable.put("HED_OTHERS", checkForNull(request.getParameter("h_oth_text")));
		hashtable.put("HED_OTHERS_GIVEN_BY", checkForNull(request.getParameter("h_oth_given_by")));

		String h_oth_given_dt =	checkForNull(request.getParameter("h_oth_given_dt"));
		if(!h_oth_given_dt.equals(""))
		{
		hashtable.put("HED_OTHERS_DATE",setDateValue(h_oth_given_dt));
		}
		else
		{
		hashtable.put("HED_OTHERS_DATE","");
		}
		h_oth_given_dt = DateUtils.convertDate(h_oth_given_dt,"DMYHM",locale,"en");

		hashtable.put("PHG_ITEM01_YN", checkForNull(request.getParameter("h_top_to_toe_chk")));
		hashtable.put("PHG_ITEM02_YN", checkForNull(request.getParameter("h_co_umb_stmp_chk")));
		hashtable.put("PHG_ITEM03_YN", checkForNull(request.getParameter("h_care_of_skin_chk")));
		hashtable.put("PHG_ITEM04_YN", checkForNull(request.getParameter("h_care_of_eye_chk")));
		hashtable.put("NUTR_ITEM01_YN", checkForNull(request.getParameter("h_expr_br_mlk_chk")));
		hashtable.put("NUTR_ITEM02_YN", checkForNull(request.getParameter("h_tube_feed_chk")));
		hashtable.put("NUTR_ITEM03_YN", checkForNull(request.getParameter("h_gst_feed_chk")));

		hashtable.put("NUTR_ITEM04_YN", checkForNull(request.getParameter("h_frm_milk_chk")));
		hashtable.put("NUTR_ITEM05_YN", checkForNull(request.getParameter("h_imn_sch_chk")));
		hashtable.put("NUTR_ITEM06_YN", checkForNull(request.getParameter("h_care_of_stoma_chk")));
		hashtable.put("NUTR_ITEM07_YN", checkForNull(request.getParameter("h_anl_dil_chk")));

		hashtable.put("NUTR_ITEM08_YN", checkForNull(request.getParameter("h_pop_chk")));
		hashtable.put("NUTR_ITEM09_YN", checkForNull(request.getParameter("h_fever_chk")));
		hashtable.put("NUTR_ITEM10_YN", checkForNull(request.getParameter("h_sz_chk")));
		hashtable.put("NUTR_ITEM11_YN", checkForNull(request.getParameter("h_jnd_chk")));
		hashtable.put("NUTR_ITEM12_YN", checkForNull(request.getParameter("h_gpd_chk")));
		hashtable.put("NUTR_ITEM13_YN", checkForNull(request.getParameter("h_stlc_chk")));
		
		hashtable.put("NUTR_ITEM14_YN", checkForNull(request.getParameter("h_stlf_chk")));
		hashtable.put("NUTR_ITEM15_YN", checkForNull(request.getParameter("h_coptb_chk")));
		hashtable.put("NUTR_ITEM16_YN", checkForNull(request.getParameter("h_oth_ph_chk")));

		hashtable.put("PLET_ITEM01_YN", checkForNull(request.getParameter("h_bfd_chk")));
		hashtable.put("PLET_ITEM02_YN", checkForNull(request.getParameter("h_stm_cr_chk")));
		hashtable.put("PLET_ITEM03_YN", checkForNull(request.getParameter("h_oper_chk")));
		hashtable.put("PLET_ITEM04_YN", checkForNull(request.getParameter("h_pop_care_chk")));
		hashtable.put("PLET_ITEM05_YN", checkForNull(request.getParameter("h_dn_given_chk")));
		hashtable.put("PLET_ITEM06_YN", checkForNull(request.getParameter("h_db_given_chk")));
		hashtable.put("PLET_OTHERS", checkForNull(request.getParameter("h_oth_pamphlets")));

		hashtable.put("APF_ITEM01", checkForNull(request.getParameter("h_oth_app_fix_item1")));
		hashtable.put("APF_ITEM01_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item1_given1")));

		String h_oth_app_fix_item1_dt1 =	checkForNull(request.getParameter("h_oth_app_fix_item1_dt1"));
		if(!h_oth_app_fix_item1_dt1.equals(""))
		{
		hashtable.put("APF_ITEM01_DATE",setDateValue(h_oth_app_fix_item1_dt1));
		}
		else
		{
		hashtable.put("APF_ITEM01_DATE","");
		}
		h_oth_app_fix_item1_dt1 = DateUtils.convertDate(h_oth_app_fix_item1_dt1,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM02", checkForNull(request.getParameter("h_oth_app_fix_item2")));
		hashtable.put("APF_ITEM02_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item2_given2")));

		String h_oth_app_fix_item2_dt2 =	checkForNull(request.getParameter("h_oth_app_fix_item2_dt2"));
		if(!h_oth_app_fix_item2_dt2.equals(""))
		{
		hashtable.put("APF_ITEM02_DATE",setDateValue(h_oth_app_fix_item2_dt2));
		}
		else
		{
		hashtable.put("APF_ITEM02_DATE","");
		}
		h_oth_app_fix_item2_dt2 = DateUtils.convertDate(h_oth_app_fix_item2_dt2,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM03", checkForNull(request.getParameter("h_oth_app_fix_item3")));
		hashtable.put("APF_ITEM03_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item3_given3")));

		String h_oth_app_fix_item3_dt3 =	checkForNull(request.getParameter("h_oth_app_fix_item3_dt3"));
		if(!h_oth_app_fix_item3_dt3.equals(""))
		{
		hashtable.put("APF_ITEM03_DATE",setDateValue(h_oth_app_fix_item3_dt3));
		}
		else
		{
		hashtable.put("APF_ITEM03_DATE","");
		}
		h_oth_app_fix_item3_dt3 = DateUtils.convertDate(h_oth_app_fix_item3_dt3,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM04", checkForNull(request.getParameter("h_oth_app_fix_item4")));
		hashtable.put("APF_ITEM04_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item4_given4")));

		String h_oth_app_fix_item4_dt4 =	checkForNull(request.getParameter("h_oth_app_fix_item4_dt4"));
		if(!h_oth_app_fix_item4_dt4.equals(""))
		{
		hashtable.put("APF_ITEM04_DATE",setDateValue(h_oth_app_fix_item4_dt4));
		}
		else
		{
		hashtable.put("APF_ITEM04_DATE","");
		}
		h_oth_app_fix_item4_dt4 = DateUtils.convertDate(h_oth_app_fix_item4_dt4,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM05", checkForNull(request.getParameter("h_oth_app_fix_item5")));
		hashtable.put("APF_ITEM05_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item5_given5")));

		String h_oth_app_fix_item5_dt5 =	checkForNull(request.getParameter("h_oth_app_fix_item5_dt5"));
		if(!h_oth_app_fix_item5_dt5.equals(""))
		{
		hashtable.put("APF_ITEM05_DATE",setDateValue(h_oth_app_fix_item5_dt5));
		}
		else
		{
		hashtable.put("APF_ITEM05_DATE","");
		}
		h_oth_app_fix_item5_dt5 = DateUtils.convertDate(h_oth_app_fix_item5_dt5,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM06", checkForNull(request.getParameter("h_oth_app_fix_item6")));
		hashtable.put("APF_ITEM06_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item6_given6")));

		String h_oth_app_fix_item6_dt6 =	checkForNull(request.getParameter("h_oth_app_fix_item6_dt6"));
		if(!h_oth_app_fix_item6_dt6.equals(""))
		{
		hashtable.put("APF_ITEM06_DATE",setDateValue(h_oth_app_fix_item6_dt6));
		}
		else
		{
		hashtable.put("APF_ITEM06_DATE","");
		}
		h_oth_app_fix_item6_dt6 = DateUtils.convertDate(h_oth_app_fix_item6_dt6,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM07", checkForNull(request.getParameter("h_oth_app_fix_item7")));
		hashtable.put("APF_ITEM07_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item7_given7")));

		String h_oth_app_fix_item7_dt7 =	checkForNull(request.getParameter("h_oth_app_fix_item7_dt7"));
		if(!h_oth_app_fix_item7_dt7.equals(""))
		{
		hashtable.put("APF_ITEM07_DATE",setDateValue(h_oth_app_fix_item7_dt7));
		}
		else
		{
		hashtable.put("APF_ITEM07_DATE","");
		}
		h_oth_app_fix_item7_dt7 = DateUtils.convertDate(h_oth_app_fix_item7_dt7,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM08", checkForNull(request.getParameter("h_oth_app_fix_item8")));
		hashtable.put("APF_ITEM08_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item8_given8")));

		String h_oth_app_fix_item8_dt8 =	checkForNull(request.getParameter("h_oth_app_fix_item8_dt8"));
		if(!h_oth_app_fix_item8_dt8.equals(""))
		{
		hashtable.put("APF_ITEM08_DATE",setDateValue(h_oth_app_fix_item8_dt8));
		}
		else
		{
		hashtable.put("APF_ITEM08_DATE","");
		}
		h_oth_app_fix_item8_dt8 = DateUtils.convertDate(h_oth_app_fix_item8_dt8,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM09", checkForNull(request.getParameter("h_oth_app_fix_item9")));
		hashtable.put("APF_ITEM09_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item9_given9")));

		String h_oth_app_fix_item9_dt9 =	checkForNull(request.getParameter("h_oth_app_fix_item9_dt9"));
		if(!h_oth_app_fix_item9_dt9.equals(""))
		{
		hashtable.put("APF_ITEM09_DATE",setDateValue(h_oth_app_fix_item9_dt9));
		}
		else
		{
		hashtable.put("APF_ITEM09_DATE","");
		}
		h_oth_app_fix_item9_dt9 = DateUtils.convertDate(h_oth_app_fix_item9_dt9,"DMYHM",locale,"en");
		hashtable.put("APF_ITEM10", checkForNull(request.getParameter("h_oth_app_fix_item10")));
		hashtable.put("APF_ITEM10_GIVEN_BY", checkForNull(request.getParameter("h_oth_app_fix_item10_given10")));

		String h_oth_app_fix_item10_dt10 =	checkForNull(request.getParameter("h_oth_app_fix_item10_dt10"));
		if(!h_oth_app_fix_item10_dt10.equals(""))
		{
		hashtable.put("APF_ITEM10_DATE",setDateValue(h_oth_app_fix_item10_dt10));
		}
		else 
		{
		hashtable.put("APF_ITEM10_DATE","");
		}
		h_oth_app_fix_item10_dt10 = DateUtils.convertDate(h_oth_app_fix_item10_dt10,"DMYHM",locale,"en");
		
		hashtable.put("ODC_REF_LTR_YN", checkForNull(request.getParameter("h_ref_ltr_chk")));
		hashtable.put("ODC_REF_LTR_CONF_YN", checkForNull(request.getParameter("h_confirm_chk")));
		hashtable.put("ODC_ITEM01_YN", checkForNull(request.getParameter("h_rep_ltr_chk")));
		hashtable.put("ODC_ITEM01_DETAIL1", checkForNull(request.getParameter("h_rep_dtl_txt")));
		hashtable.put("ODC_ITEM01_DETAIL2", checkForNull(request.getParameter("h_rep_cnf_txt")));
		hashtable.put("ODC_ITEM02_YN", checkForNull(request.getParameter("h_cln_doc_chk")));
		hashtable.put("ODC_ITEM02_DETAIL1", checkForNull(request.getParameter("h_cln_dtl_txt")));
		hashtable.put("ODC_ITEM02_DETAIL2", checkForNull(request.getParameter("h_cln_cnf_txt")));
		hashtable.put("ODC_OTHERS_YN", checkForNull(request.getParameter("h_oth_doc_chk")));
		hashtable.put("ODC_OTHERS_DESC", checkForNull(request.getParameter("h_oth_doc_txt")));
		hashtable.put("ODC_OTHERS_DETAIL1", checkForNull(request.getParameter("h_oth_dtl_txt1")));
		hashtable.put("ODC_OTHERS_DETAIL2", checkForNull(request.getParameter("h_oth_cnf_txt1")));

		hashtable.put("LWA_RELATIONSHIP", checkForNull(request.getParameter("h_relationship")));

		String h_rel_date_time =	checkForNull(request.getParameter("h_rel_date_time"));
		
		if(!h_rel_date_time.equals(""))
		{
		hashtable.put("LWA_DATE",setDateValue(h_rel_date_time));
		}
		else
		{
		hashtable.put("LWA_DATE","");
		}
		h_rel_date_time = DateUtils.convertDate(h_rel_date_time,"DMYHM",locale,"en");


		hashtable.put("LWA_REMARKS", checkForNull(request.getParameter("h_rem_lv_ward")));

		hashtable.put("SCH_PATIENT_NAME", checkForNull(request.getParameter("h_name_of_patient")));
		hashtable.put("SCH_MOTHERS_NRIC", checkForNull(request.getParameter("h_mot_ic_no")));
		hashtable.put("SCH_R_NURSE", checkForNull(request.getParameter("h_rn_txt")));
		hashtable.put("SCH_WARD", checkForNull(request.getParameter("h_ward_txt")));

		String h_discharge_date =	checkForNull(request.getParameter("h_discharge_date"));
		if(!h_discharge_date.equals(""))
		{
			hashtable.put("SCH_DATE_OF_DISCH",setDateValue(h_discharge_date));
		}
		else
		{
			hashtable.put("SCH_DATE_OF_DISCH","");
		}
		h_discharge_date = DateUtils.convertDate(h_discharge_date,"DMYHM",locale,"en");
		hashtable.put("SCH_WEIGHT", checkForNull(request.getParameter("h_weight_txt")));
		hashtable.put("SCH_LENGTH", checkForNull(request.getParameter("h_length_txt")));
		hashtable.put("SCH_HEAD_CIR", checkForNull(request.getParameter("h_head_circum")));
		hashtable.put("SCH_ADVICE_GIVEN_TO", checkForNull(request.getParameter("h_adv_given")));
		hashtable.put("SCH_RELATIONSHIP", checkForNull(request.getParameter("h_relationship_txt")));

		hashtable.put("SCH_MOTHERS_NAME", checkForNull(request.getParameter("h_mother_name")));
		hashtable.put("SCH_MOTHERS_NRIC", checkForNull(request.getParameter("h_mother_no")));
		hashtable.put("SCH_FATHERS_NAME", checkForNull(request.getParameter("h_father_name")));
		hashtable.put("SCH_FATHERS_NRIC", checkForNull(request.getParameter("h_father_no")));
		hashtable.put("SCH_OTHER", checkForNull(request.getParameter("h_Remarks")));


		hashtable.put("DISCH_CHKLIST_CONFIRMED_BY",login_user);
		hashtable.put("MODIFIED_BY_ID", login_user);
		hashtable.put("MODIFIED_DATE", date1);
		hashtable.put("MODIFIED_FACILITY_ID", facilityId);
		hashtable.put("MODIFIED_AT_WS_NO", s7);

		//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
		String  cert_num = checkForNull(request.getParameter("cert_num"));
		hashtable.put("CERTIFICATE_NUM", cert_num);

		String cert_from_date =	checkForNull(request.getParameter("cert_from_date"));
		if(!cert_from_date.equals(""))
			hashtable.put("CERT_FROM_DATE",setDateValueDMY(cert_from_date));
		else
			hashtable.put("CERT_FROM_DATE","");
		cert_from_date = DateUtils.convertDate(cert_from_date,"DMY",locale,"en");

		String cert_to_date =	checkForNull(request.getParameter("cert_to_date"));
		if(!cert_to_date.equals(""))
			hashtable.put("CERT_TO_DATE",setDateValueDMY(cert_to_date));
		else
			hashtable.put("CERT_TO_DATE","");
		cert_to_date = DateUtils.convertDate(cert_to_date,"DMY",locale,"en");

		String  duration = checkForNull(request.getParameter("duration"));
		hashtable.put("DURATION", duration);

		String  duration_dmy = checkForNull(request.getParameter("duration_dmy"));
		if(!duration.equals(""))
		hashtable.put("DURATION_DMY", duration_dmy);
		//End ML-MMOH-CRF-0620
		//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050
		String  deli_cert_num = checkForNull(request.getParameter("deli_cert_num"));
		hashtable.put("DELI_CERT_NUM", deli_cert_num);

		HashMap hashtable1 = new HashMap();
		hashtable1.put("facility_id", facilityid);
		hashtable1.put("encounter_id",encounter_id);
		hashtable.put("patient_id", checkForNull(request.getParameter("patient_id")));
		String informed_date = checkForNull(request.getParameter("h_informed_date"));
		informed_date = DateUtils.convertDate(informed_date,"DMYHM",locale,"en");

	
		String tableName = "IP_DISCHARGE_CHECKLIST";
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = hashtable;
		argArray[2] = hashtable1;
		argArray[3] = tableName;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = hashtable.getClass();
		paramArray[2] = hashtable1.getClass();
		paramArray[3] = tableName.getClass();

		java.util.HashMap hashtable2 = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean flag = ((Boolean)hashtable2.get("status")).booleanValue();
		String error = (String)hashtable2.get("error");

		if(flag)
		{
 
			PreparedStatement pstmt = null;
			String modified_inform_to  = checkForNull(request.getParameter("h_inform_to"));
			String modified_informed_date  = informed_date;
			String modified_informed_name  = checkForNull(request.getParameter("h_informed_name"));
			String patient_id  = checkForNull(request.getParameter("patient_id"));
			int result = 0;
		
			try
			{
		
				if(!modified_inform_to.equals(""))
				{
					String updateSql =" update IP_DISCHARGE_ADVICE set INFORMED_TO = ?, INFORMED_NAME = ?, INFORMED_DATE_TIME = to_date(?,'dd/mm/rrrr hh24:mi') , MODIFIED_BY_ID= '"+login_user+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+s7+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where FACILITY_ID = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? and  DIS_ADV_STATUS in ('0','1') ";

					pstmt = connection.prepareStatement(updateSql);
					pstmt.setString	( 1, modified_inform_to ) ;
					pstmt.setString	( 2, modified_informed_name);
					pstmt.setString	( 3, modified_informed_date ) ;
					pstmt.setString	( 4, facilityid ) ;
					pstmt.setString	( 5, encounter_id ) ;
					pstmt.setString	( 6, patient_id ) ;

					result = pstmt.executeUpdate() ;
					if(result > 0)
						flag = true ;
					else
						flag = false;
					if(pstmt != null) pstmt.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

			if(flag)
			{
				connection.commit();
				Hashtable hashtable3 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
				error = (String)hashtable3.get("message");
				hashtable3.clear();
			}
			else
			{
				error = "record not modified...Error in updation";
			}

		} 
		else
		{                
			error = (String)hashtable2.get("error");                
		}
		if(error.lastIndexOf("<br>")>=0)
		error = error.substring(0, error.indexOf("<br>"));
		//out.println("<script>alert(\"" + error + "\");parent.window.close();</script>");
		out.println("<script>alert(\"" + error + "\");const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();</script>");

	   hashtable2.clear();
	   hashtable1.clear();
	   hashtable.clear();

	}
	catch(Exception exception)
	{
		exception.printStackTrace();           
	}
	finally{
		if(connection != null)
				ConnectionManager.returnConnection(connection, request);
	}
}

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
}
    
    
	public static Timestamp setDateValue(String input1)
	{
		Timestamp receiveTimestamp	= new Timestamp(System.currentTimeMillis());
		StringTokenizer receivetoks = new StringTokenizer(input1," ") ;
		StringTokenizer receivetok1 = new StringTokenizer(receivetoks.nextToken(), "/" ) ;
		String receiveArr[] =new String[3] ;
		for( int q=0;q<3;q++ )
		{
			receiveArr[q] = receivetok1.nextToken() ;
		}
		String time24 = receivetoks.nextToken();
		if(time24.equals("")||(time24==null)) time24="00:00";
		input1 = receiveArr[2]+"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+time24+":00";
		receiveTimestamp= Timestamp.valueOf(input1);
		return (receiveTimestamp);		
	}

	public static Timestamp setDateValueDMY(String input1)
	{
		
		Timestamp receiveTimestamp	= new Timestamp(System.currentTimeMillis());
		StringTokenizer receivetoks = new StringTokenizer(input1," ") ;
		StringTokenizer receivetok1 = new StringTokenizer(receivetoks.nextToken(), "/" ) ;
		String receiveArr[] =new String[3] ;
		for( int q=0;q<3;q++ )
		{
			receiveArr[q] = receivetok1.nextToken() ;
		}
		String time24="00:00";
		input1 = receiveArr[2]+"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+time24+":00";
		receiveTimestamp= Timestamp.valueOf(input1);
		return (receiveTimestamp);		
	}

} 