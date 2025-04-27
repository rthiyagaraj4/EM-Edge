/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCA.VaccineForCategoryBean;

public class ScheduleVaccinAdminServlet extends javax.servlet.http.HttpServlet	{

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;
		Connection con = null;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		String mode =request.getParameter("mode")==null?"":request.getParameter("mode");

		if(mode.equals("insert"))
		{
			insertAdminDetails(request,response,con);
		}
		else if(mode.equals("modify"))
		{
			modifyAdminDetails(request,response,con);
		}
		else if(mode.equals("all_rec"))
		{
			recordAllergyDetails(request,response,con);
		}
		else if(mode.equals("view"))
		{
			modifyAllergyDetails(request,response,con);
		}

	}

	public void insertAdminDetails(HttpServletRequest request,HttpServletResponse response,Connection con)
	{

		HttpSession session = request.getSession(false);

		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String vac_sch_ref = "";
		String vacc_categ_id = "";
		String vaccine_id = "";
		String dose_no = "";
		String schedule_date = "";
		String administered_date = "";
		String admin_site_id = "";
		String external_adm_yn = "";
		String external_facility = "";
		String batch_id = "";
		String manufacturer = "";
		String outcome_code = "";
		String remarks = "";
		String administered_by = "";
		String patient_id = "";
		String initiating_encounter_id = "";
		String scheduled_user_id = "";
		String sch_closed_date = "";
		String sch_status = "";
		String categ_hdr_query = "";
		String adhoc = "";
		String error_remarks = "";

		/*
		if(adhoc.equals("Y"))
		{
			outcome_code="C";
		}

		*/

		int nInsStat=0;


		//vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");

		vacc_categ_id = request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");

		vaccine_id = request.getParameter("vaccine_name")==null?"":request.getParameter("vaccine_name");
		dose_no = request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
		schedule_date = request.getParameter("Schedule_date")==null?"":request.getParameter("Schedule_date");
		administered_date = request.getParameter("administer_date")==null?"":request.getParameter("administer_date");
		schedule_date			= com.ehis.util.DateUtils.convertDate(schedule_date,"DMYHM",locale,"en");
		administered_date			= com.ehis.util.DateUtils.convertDate(administered_date,"DMYHM",locale,"en");
		admin_site_id = request.getParameter("site_name")==null?"":request.getParameter("site_name");
		external_adm_yn = request.getParameter("ext_administer")==null?"N":request.getParameter("ext_administer");
		external_facility = request.getParameter("ext_facility")==null?"":request.getParameter("ext_facility");
		batch_id = request.getParameter("batch_no")==null?"":request.getParameter("batch_no");
		manufacturer = request.getParameter("manufacturer")==null?"":request.getParameter("manufacturer");
		outcome_code = request.getParameter("Outcome1")==null?"C":request.getParameter("Outcome1");
		remarks = request.getParameter("remark_text")==null?"":request.getParameter("remark_text");
		administered_by = request.getParameter("administer_by")==null?"":request.getParameter("administer_by");
		patient_id = request.getParameter("patient_id")==null?"temp":request.getParameter("patient_id");

		initiating_encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

		scheduled_user_id = request.getParameter("administer_user_id")==null?"":request.getParameter("administer_user_id");
		sch_closed_date = request.getParameter("sch_closed_date")==null?"":request.getParameter("sch_closed_date");
		sch_status = request.getParameter("sch_status")==null?"A":request.getParameter("sch_status");

		adhoc=request.getParameter("adhoc_yn")==null?"":request.getParameter("adhoc_yn");

		error_remarks = request.getParameter("error_remarks")==null?"":request.getParameter("error_remarks");
		try
		{

		String vac_sch_query ="select VAC_SCH_REF from CA_IM_PAT_VAC_SCH_HDR where  SCH_STATUS='A' AND PATIENT_ID=? and VACC_CATEG_ID =? ";

		pstmt=con.prepareStatement(vac_sch_query);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,vacc_categ_id);

		rs = pstmt.executeQuery();

		while(rs.next())
		{
			vac_sch_ref =rs.getString("VAC_SCH_REF")==null ? "":rs.getString("VAC_SCH_REF");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();



		if(outcome_code.equals("E"))
		{
			String upd_err_qry ="update CA_IM_PAT_VAC_SCH_DTL set OUTCOME_CODE ='E', ERR_MARKED_BY=?,ERR_MARKED_DATE = sysdate,ERR_REMARKS=? where VAC_SCH_REF=? and VACCINE_ID=? and DOSE_NO=? ";

			pstmt=con.prepareStatement(upd_err_qry);
			pstmt.setString(1,loginuserid);
			pstmt.setString(2,error_remarks);
			pstmt.setString(3,vac_sch_ref);
			pstmt.setString(4,vaccine_id);
			pstmt.setString(5,dose_no);

			nInsStat = pstmt.executeUpdate();


		if(nInsStat>0)
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;
			}
			else
			{
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;

			}

		if(pstmt != null) pstmt.close();


			/*
			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(nInsStat>0)
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.frames(1).onSuccess1();</script>");
			out.println("</BODY></html>"); */
		}
		else
		{
		/*String vac_sch_query ="select VAC_SCH_REF from CA_IM_PAT_VAC_SCH_HDR where  SCH_STATUS='A' AND PATIENT_ID=? and VACC_CATEG_ID =? ";

		pstmt=con.prepareStatement(vac_sch_query);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,vacc_categ_id);

		rs = pstmt.executeQuery();

		while(rs.next())
		{
			vac_sch_ref =rs.getString("VAC_SCH_REF")==null ? "":rs.getString("VAC_SCH_REF");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close(); */

		if(adhoc.equals("Y"))
		{
			outcome_code="C";
		}


		if(vac_sch_ref.equals(""))
		{

			String seq_num_query = " select CA_IM_PAT_VAC_SCH_HDR_SEQ.NEXTVAL VAC_SCH_REF from dual ";
			pstmt=con.prepareStatement(seq_num_query);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				vac_sch_ref = rs.getString("VAC_SCH_REF")==null ? "":rs.getString("VAC_SCH_REF");

				dose_no = "1";

			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		//For Adhoc hdr table insertion


		try{
			categ_hdr_query ="INSERT INTO CA_IM_PAT_VAC_SCH_HDR ( VAC_SCH_REF, PATIENT_ID, VACC_CATEG_ID, INITIATING_ENCOUNTER_ID, INITIATING_FACILITY_ID, SCHEDULED_USER_ID, SCH_CREATED_DATE, SCH_CLOSED_DATE, SCH_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( ?,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,? )";

			pstmt=con.prepareStatement(categ_hdr_query);

			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,vacc_categ_id);
			pstmt.setString(4,initiating_encounter_id);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,scheduled_user_id);
			pstmt.setString(7,schedule_date);
			pstmt.setString(8,sch_closed_date);
			pstmt.setString(9,sch_status);
			pstmt.setString(10,loginuserid);
			pstmt.setString(11,client_ip_address);
			pstmt.setString(12,facilityid);
			pstmt.setString(13,loginuserid);
			pstmt.setString(14,client_ip_address);
			pstmt.setString(15,facilityid);

			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception e)

			{			
			e.printStackTrace();

			try
			{
				con.rollback();

			}
			catch(Exception eee)
			{

				eee.printStackTrace();
			}

			}




		}
		else
		{

			String dose_num_query ="select nvl(max(dose_no),0)+1 dose_no from CA_IM_PAT_VAC_SCH_DTL  where VAC_SCH_REF =? and VACCINE_ID =?" ;

			pstmt=con.prepareStatement(dose_num_query);
			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,vaccine_id);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				dose_no = rs.getString("dose_no")==null ? "1":rs.getString("dose_no");

			}


			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
// for Adhoc hdr



		String insert_query="INSERT INTO  CA_IM_PAT_VAC_SCH_DTL ( VAC_SCH_REF, VACCINE_ID,DOSE_NO,SCHEDULE_DATE,ADMINISTERED_DATE,ADMIN_SITE_ID,EXTERNAL_ADM_YN ,EXTERNAL_FACILITY ,BATCH_ID,MANUFACTURER,OUTCOME_CODE,REMARKS, ADMINISTERED_BY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) VALUES (?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,? )";

		pstmt=con.prepareStatement(insert_query);
		pstmt.setString(1,vac_sch_ref);
		pstmt.setString(2,vaccine_id);
		pstmt.setString(3,dose_no);
		pstmt.setString(4,schedule_date);
		pstmt.setString(5,administered_date);
		pstmt.setString(6,admin_site_id);
		pstmt.setString(7,external_adm_yn);
		pstmt.setString(8,external_facility);
		pstmt.setString(9,batch_id);
		pstmt.setString(10,manufacturer);
		pstmt.setString(11,outcome_code);
		pstmt.setString(12,remarks);
		pstmt.setString(13,administered_by);
		pstmt.setString(14,loginuserid);
		pstmt.setString(15,client_ip_address);
		pstmt.setString(16,facilityid);
		pstmt.setString(17,loginuserid);
		pstmt.setString(18,client_ip_address);
		pstmt.setString(19,facilityid);


		nInsStat = pstmt.executeUpdate();


		if(pstmt != null) pstmt.close();

		if(nInsStat>0)
		{
			con.commit();
			errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
			error_value = "1" ;

		}
		else
		{
			errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
			error_value = "0" ;
		}

		}

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(nInsStat>0)
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.frames[1].onSuccess1();</script>");
			out.println("</BODY></html>");


		}
		catch (Exception e)
		{		
			e.printStackTrace();

			try
			{
				con.rollback();

			}
			catch(Exception eee)
			{

				eee.printStackTrace();
			}

		}

		finally
		{

			if(con != null) ConnectionManager.returnConnection(con);

		}

	}



	public void modifyAdminDetails(HttpServletRequest request,HttpServletResponse response,Connection con)
	{

		HttpSession session = request.getSession(false);

		PrintWriter out = null;

		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		PreparedStatement pstmt = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";
		String adhoc="";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String	locale = (String) p.getProperty("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


		String	vac_sch_ref ="";
		String	vaccine_id ="";
		String	dose_no ="";
		String	administered_date ="";
		String	external_adm_yn ="";
		String	external_facility ="";
		String	outcome_code ="";
		String	remarks ="";
		String	update_query="";

		String patient_id = "";
		String sch_srl_no = "";
		String vaccine_id1 = "";
		String vac_srl_no = "";
		String reaction_code = "";
		String reaction_date = "";
		String reaction_remarks = "";
		String reaction_treatment = "";
		String allergy_YN = "";
		String admin_site_id = "";
		String batch_id = "";
		String manufacturer = "";
		String administered_by = "";
		String error_remarks = "";

		int		nInsStat =0;

		adhoc=request.getParameter("adhoc_yn")==null?"":request.getParameter("adhoc_yn");
		vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
		vaccine_id = request.getParameter("vaccine_name")==null?"":request.getParameter("vaccine_name");
		dose_no = request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
		administered_date = request.getParameter("administer_date")==null?"":request.getParameter("administer_date");
		//Date Convesion added by Archana Dhal on 12/8/2010 related to incident no IN025377.
		administered_date			= com.ehis.util.DateUtils.convertDate(administered_date,"DMYHM",locale,"en");
		admin_site_id = request.getParameter("site_name")==null?"":request.getParameter("site_name");
		batch_id = request.getParameter("batch_no")==null?"":request.getParameter("batch_no");
		manufacturer = request.getParameter("manufacturer")==null?"":request.getParameter("manufacturer");
		administered_by = request.getParameter("administer_by")==null?"":request.getParameter("administer_by");

		external_adm_yn = request.getParameter("ext_administer")==null?"N":request.getParameter("ext_administer");
		external_facility = request.getParameter("ext_facility")==null?"":request.getParameter("ext_facility");

		outcome_code = request.getParameter("Outcome1")==null?"":request.getParameter("Outcome1");
		remarks = request.getParameter("remark_text")==null?"":request.getParameter("remark_text");

		//for allergy

		patient_id = request.getParameter("patient_id")==null?"temp":request.getParameter("patient_id");
		sch_srl_no = request.getParameter("sch_srl_no")==null?"1":request.getParameter("sch_srl_no");
		vaccine_id1 = request.getParameter("vaccine_name1")==null?"":request.getParameter("vaccine_name1");
		vac_srl_no = request.getParameter("vac_srl_no")==null?"2":request.getParameter("vac_srl_no");
		reaction_date = request.getParameter("reaction_Date")==null?"":request.getParameter("reaction_Date");
		reaction_code = request.getParameter("reaction_code")==null?"":request.getParameter("reaction_code");
		reaction_remarks = request.getParameter("allergy_remark")==null?"":request.getParameter("allergy_remark");
		reaction_treatment = request.getParameter("allergy_treat")==null?"":request.getParameter("allergy_treat");
		allergy_YN = request.getParameter("allergy_YN")==null?"":request.getParameter("allergy_YN");
		error_remarks = request.getParameter("error_remarks")==null?"":request.getParameter("error_remarks");



		try
		{

		if(outcome_code.equals("E"))
		{
			/*String upd_err_qry ="update CA_IM_PAT_VAC_SCH_DTL set OUTCOME_CODE ='E', ERR_MARKED_BY=?,ERR_MARKED_DATE = sysdate,ERR_REMARKS=? where VAC_SCH_REF=? and VACCINE_ID=? and DOSE_NO=? ";

			pstmt=con.prepareStatement(upd_err_qry);
			pstmt.setString(1,loginuserid);
			pstmt.setString(2,error_remarks);
			pstmt.setString(3,vac_sch_ref);
			pstmt.setString(4,vaccine_id);
			pstmt.setString(5,dose_no);

			nInsStat = pstmt.executeUpdate();*/

			String upd_err_qry ="UPDATE CA_IM_PAT_VAC_SCH_DTL SET ADMINISTERED_DATE = '',ADMIN_SITE_ID = '', EXTERNAL_ADM_YN = '', EXTERNAL_FACILITY = '', BATCH_ID = '', MANUFACTURER = '', OUTCOME_CODE = 'A', REMARKS = '', ADMINISTERED_BY = '',        ERR_MARKED_BY = '', ERR_MARKED_DATE = '', ERR_REMARKS = '' WHERE VAC_SCH_REF=? AND VACCINE_ID=? AND DOSE_NO=?";

			pstmt=con.prepareStatement(upd_err_qry);
			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,vaccine_id);
			pstmt.setString(3,dose_no);

			nInsStat = pstmt.executeUpdate();

			String insertMrkErrSql = "insert into  CA_IM_PAT_VAC_ERR_DTL (VAC_SCH_REF, ERR_MARKED_BY, ERR_MARKED_DATE, ERR_REMARKS, VACCINE_ID, DOSE_NO, ADMINISTERED_DATE, ADMINISTERED_BY) values(?,?,sysdate,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?)";
			PreparedStatement pst = con.prepareStatement(insertMrkErrSql);
			pst.setString(1, vac_sch_ref);
			pst.setString(2, loginuserid);
			pst.setString(3, error_remarks);
			pst.setString(4, vaccine_id);
			pst.setString(5, dose_no);
			pst.setString(6, administered_date);
			pst.setString(7, administered_by);

			 pst.executeUpdate();

			 if (pst != null)
			 {
				 pst.close();
			 }



		if(nInsStat>0)
		{
			con.commit();
			errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
			error_value = "1" ;
		}
		else
		{
			errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
			error_value = "0" ;

		}

		if(pstmt != null) pstmt.close();

		}
		else
		{

		//for adhoc
		if(adhoc.equals("Y"))
		{
			outcome_code="C";
		}

		update_query ="update CA_IM_PAT_VAC_SCH_DTL set ADMINISTERED_DATE = to_date(?,'DD/MM/YYYY HH24:MI'),ADMIN_SITE_ID = ? ,EXTERNAL_ADM_YN = ?,EXTERNAL_FACILITY = ?, BATCH_ID = ?, MANUFACTURER = ?, OUTCOME_CODE = ?,REMARKS = ?, ADMINISTERED_BY = ? where  VAC_SCH_REF =? and VACCINE_ID =? and DOSE_NO =?";

		pstmt=con.prepareStatement(update_query);
		pstmt.setString(1,administered_date);
		pstmt.setString(2,admin_site_id);
		pstmt.setString(3,external_adm_yn);
		pstmt.setString(4,external_facility);
		pstmt.setString(5,batch_id);
		pstmt.setString(6,manufacturer);
		pstmt.setString(7,outcome_code);
		pstmt.setString(8,remarks);
		pstmt.setString(9,administered_by);
		pstmt.setString(10,vac_sch_ref);
		pstmt.setString(11,vaccine_id);
		pstmt.setString(12,dose_no);
		nInsStat = pstmt.executeUpdate();


		if(nInsStat>0)
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;
			}
			else
			{
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;

			}

		if(pstmt != null) pstmt.close();

		}

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(nInsStat>0)
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.location.href='../eCA/jsp/blank.jsp';</script>");
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.VaccineAdminTabFrame.location.href='../eCA/jsp/blank.jsp';</script>");
			out.println("</BODY></html>");


		}
		catch (Exception eee)
		{			
			eee.printStackTrace();

			try
			{
				con.rollback();

			}
			catch(Exception ee)
			{

				ee.printStackTrace();
			}

		}
		finally
		{

			if(con != null) ConnectionManager.returnConnection(con);

		}



	}

	public void recordAllergyDetails(HttpServletRequest request,HttpServletResponse response,Connection con)
	{

		HttpSession session = request.getSession(false);

		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";
		String vac_srl_no = "";
		int nInsStat =0;
		int vac_srl_no1 =0;

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


		String	vac_sch_ref ="";
		String	vaccine_id ="";
		String	dose_no ="";

		String reaction_code = "";
		String reaction_date = "";
		String reaction_remarks = "";
		String reaction_treatment = "";

		vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
		vaccine_id = request.getParameter("vaccine_id")==null?"":request.getParameter("vaccine_id");
		dose_no = request.getParameter("dose_no")==null?"":request.getParameter("dose_no");

		reaction_date = request.getParameter("reaction_Date")==null?"":request.getParameter("reaction_Date");
		reaction_code = request.getParameter("reaction_code")==null?"":request.getParameter("reaction_code");
		reaction_remarks = request.getParameter("allergy_remark")==null?"":request.getParameter("allergy_remark");
		reaction_treatment = request.getParameter("allergy_treat")==null?"":request.getParameter("allergy_treat");

		try
			{


			String Vac_reac_ser_query ="select nvl(max(a.VAC_SRL_NO),0)+1 vac_srl_no from CA_IM_PAT_VAC_REACTION a where a.VAC_SCH_REF =? and a.VACCINE_ID =? and a.DOSE_NO = ? " ;

			pstmt=con.prepareStatement(Vac_reac_ser_query);

			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,vaccine_id);
			pstmt.setInt(3,Integer.parseInt(dose_no));

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				vac_srl_no	=rs.getString("vac_srl_no");
			}

			vac_srl_no1=Integer.parseInt(vac_srl_no);

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			String allergy_insert_query ="Insert into CA_IM_PAT_VAC_REACTION (VAC_SCH_REF ,VACCINE_ID,DOSE_NO, VAC_SRL_NO, REACTION_DATE, REACTION_CODE, REACTION_REMARKS, REACTION_TREATMENT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values( ?, ?,?, ?,to_date(?,'DD/MM/YYYY HH24:MI'), ?,?, ?, ?, sysdate,?, ?, ?, sysdate,?, ?)";

			pstmt=con.prepareStatement(allergy_insert_query);
			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,vaccine_id);
			pstmt.setString(3,dose_no);
			pstmt.setInt(4,vac_srl_no1);
			pstmt.setString(5,reaction_date);
			pstmt.setString(6,reaction_code);
			pstmt.setString(7,reaction_remarks);
			pstmt.setString(8,reaction_treatment);
			pstmt.setString(9,loginuserid);
			pstmt.setString(10,client_ip_address);
			pstmt.setString(11,facilityid);
			pstmt.setString(12,loginuserid);
			pstmt.setString(13,client_ip_address);
			pstmt.setString(14,facilityid);

			nInsStat = pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();

			if(nInsStat>0)
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;

			}
			else
			{
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(nInsStat>0)
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.frames[1].frames[1].onSuccess2();</script>");
			out.println("</BODY></html>");


			}//end of try
			catch (Exception eee)
			{			
			eee.printStackTrace();

				try
				{
					con.rollback();

				}
				catch(Exception ee)
				{

					ee.printStackTrace();
				}

			}
			finally
			{

				if(con != null) ConnectionManager.returnConnection(con);

			}

	}// end of all rec

	public void modifyAllergyDetails(HttpServletRequest request,HttpServletResponse response,Connection con)

	{

		HttpSession session = request.getSession(false);

		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";
		String vac_srl_no = "";
		int nInsStat =0;
		int vac_srl_no1 =0;

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


		String	vac_sch_ref ="";
		String	vaccine_id ="";
		String	dose_no ="";
		String reaction_treatment = "";

		vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
		vaccine_id = request.getParameter("vaccine_id")==null?"":request.getParameter("vaccine_id");
		dose_no = request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
		vac_srl_no = request.getParameter("vac_srl_no")==null?"0":request.getParameter("vac_srl_no");
		reaction_treatment = request.getParameter("allergy_treat")==null?"":request.getParameter("allergy_treat");

		vac_srl_no1=Integer.parseInt(vac_srl_no);


		try
		{
		String update_allergy ="update CA_IM_PAT_VAC_REACTION a set  a.REACTION_TREATMENT =?  where a.VAC_SCH_REF=? and a.VACCINE_ID =? and a.DOSE_NO =? and a.VAC_SRL_NO =?" ;

		pstmt=con.prepareStatement(update_allergy);
		pstmt.setString(1,reaction_treatment);
		pstmt.setString(2,vac_sch_ref);
		pstmt.setString(3,vaccine_id);
		pstmt.setString(4,dose_no);
		pstmt.setInt(5,vac_srl_no1);

		nInsStat = pstmt.executeUpdate();

		if(pstmt != null) pstmt.close();


			if(nInsStat>0)
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;

			}
			else
			{
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(nInsStat>0)
			out.println("<script>top.content.workAreaFrame.VaccinationFrame.frames[1].frames[1].onSuccess2();</script>");
			out.println("</BODY></html>");

		}
		catch(Exception eee)

		{			
			eee.printStackTrace();

				try
				{
					con.rollback();

				}
				catch(Exception ee)
				{

					ee.printStackTrace();
				}

		}
		finally
		{

			if(con != null) ConnectionManager.returnConnection(con);

		}

	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }

}
