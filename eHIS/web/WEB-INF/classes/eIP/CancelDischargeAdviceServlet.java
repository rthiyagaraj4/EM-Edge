/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;  

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import blipin.BLCancelDischargeAdvice;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.Map.Entry;

public class CancelDischargeAdviceServlet extends javax.servlet.http.HttpServlet 
{
	/*PrintWriter				out;
	java.util.Properties	p;
	String sStyle				= "";
	HttpSession				session;
	String facilityId			= "";
	Connection con				= null;
    Statement stmt				= null;
    PreparedStatement pstmt		= null;
    CallableStatement callstmt	= null;
    ResultSet rset				= null;
	String locale		
	= "" ;
	String patient_class 	= "" ;*/
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue
	req= new XSSRequestWrapper(req);
	res.addHeader("X-XSS-Protection", "1; mode=block"); 
	res.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
		PrintWriter		out			= null;
		HttpSession	session			= null;
		java.util.Properties	p	= null;
		String sStyle				= "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session						=  req.getSession(false);
		p							=  (java.util.Properties) session.getValue( "jdbc" ) ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		
		try
		{
			out						= res.getWriter();
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eCommon/js/messages.js'></script></head></html> ");
			updateDischargeAdvice(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		PrintWriter		out			= null;
		HttpSession	session			= null;
		java.util.Properties	p	= null;
		String sStyle				= "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session						=  req.getSession(false);
		p							=  (java.util.Properties) session.getValue( "jdbc" ) ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		out							= res.getWriter();
		try	
		{
			doPost(req,res);
			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script><script language='javascript' src='/eCommon/js/messages.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void updateDischargeAdvice(HttpServletRequest req, HttpServletResponse res) throws IOException
	{	

		PrintWriter				out = null;
		java.util.Properties	p	= null;
		String facilityId			= "";
		String locale				= "";
		HttpSession			session = null;
		session						=  req.getSession(false);
		p							=  (java.util.Properties) session.getValue( "jdbc" ) ;
		out							= res.getWriter();
		facilityId					=  (String) session.getValue( "facility_id" ) ;
		locale						= p.getProperty("LOCALE");
		Connection con				= null;
		Statement stmt				= null;
		PreparedStatement pstmt		= null;
		CallableStatement callstmt	= null;
		ResultSet rset				= null;
		PreparedStatement updpstmt	= null;
		PreparedStatement prstmt	= null;
		ResultSet rsset				= null;
		PreparedStatement pstmtacc	= null;
		ResultSet rsacc				= null;
		PreparedStatement pstmtaud	= null;
		ResultSet rsaud				= null;
		PreparedStatement pstmtaudatr	= null;
		ResultSet rsaudatr				= null;
		PreparedStatement pstmtaudatr1	= null;
		ResultSet rsaudatr1				= null;
		String patient_class 		= "" ;
		boolean results				= true;
		boolean bl_results			= true;
		boolean bill_result			= true;
		String encounterId 			=  "";
		String bill_error 			=  "";
		//Added for INC:47208
		int nResult = 0; 
		String sNursingUnitCode 	= "";
		String sBedNo 				= "";

		//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		Boolean isDeceasedDiagClassDeathRegAppl = false;
		String deceased_yn = "N";
		String deceased_date = "";
		String term_set_id = "";
		String term_code = "";
		String occur_srl_no = "";
		String accession_num_work_related = "";
		String audit_term_set_id = "";
		String audit_term_code = "";
		String audit_occur_srl_no = "";
		String audit_attr_updated = "";
		String audit_prev_attr_value = "";
		String attr_column_name = "";

		//Added by Jeyachitra - ML-MMOH-CRF 1742
		HashMap<String, String> prev_RecDiag_Data = new HashMap<String, String>();
		HashMap<String, String> curr_RecDiag_Data = new HashMap<String, String>();

		con							=	 ConnectionManager.getConnection(req);
		try
		{	
			encounterId 			=  checkForNull(req.getParameter("encounterID"));

			isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			
			String remarks				=	"";

			String dis_adv_srl_no		=	"";
			String ip_leave_status		=	"";
			StringBuffer sbsql = new StringBuffer("");
			String error				= "";
			String appt_ref_no			="";

			//Added for INC:47208 - Getting Nursingunitcode and Bedno:
			sNursingUnitCode	= checkForNull(req.getParameter("nursingunitcode"));
			sBedNo				= checkForNull(req.getParameter("bedno"));
			
			remarks						= checkForNull(req.getParameter("cancel_remarks"));
			dis_adv_srl_no				= checkForNull(req.getParameter("dis_adv_srl_no"));
			String dis_adv_status		= "9";
			String addedById 			= p.getProperty( "login_user" ) ;
			String modifiedById 		= addedById ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId 	= addedFacilityId ;
			String addedAtWorkstation	= p.getProperty("client_ip_address");
			String modifiedAtWorkstation= addedAtWorkstation ;
			String referral_id_list		= "";
			String ref_id				= "";
			String dis_adv_Status		= "";
			//String or_installed		= "";
			patient_class 				=  checkForNull(req.getParameter("patient_class"));
			String billing_interfaced 	=  checkForNull(req.getParameter("bl_interfaced_yn"));
			String billing_installed 	=  checkForNull(req.getParameter("bl_operational"));
			String function_id 			=  checkForNull(req.getParameter("function_id"));
			String patient_id 			=  checkForNull(req.getParameter("patient_id"));
			String episode_type			=   "";
			
			//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			if(isDeceasedDiagClassDeathRegAppl){
				String sqlpatid = " SELECT deceased_yn, to_char(deceased_date,'dd/mm/yyyy hh24:mi:ss') deceased_date FROM mp_patient WHERE patient_id = ? ";

				prstmt = con.prepareStatement(sqlpatid);
				prstmt.setString(1,patient_id);
				rsset = prstmt.executeQuery();

				if(rsset!=null && rsset.next()){
					deceased_yn	= rsset.getString("deceased_yn")==null?"N":rsset.getString("deceased_yn");
					deceased_date = rsset.getString("deceased_date")==null?"":rsset.getString("deceased_date");
				}

				if(rsset != null) rsset.close();
				if(prstmt != null) prstmt.close();
			}
			
			int j=0;
				if(sbsql.length() > 0)
			 sbsql.delete(0, sbsql.length());
			sbsql.append("select dis_adv_Status from ip_discharge_advice where FACILITY_ID='"+facilityId+"' and  ENCOUNTER_ID='"+encounterId+"' and  DIS_ADV_SRL_NO='"+dis_adv_srl_no+"'");

             stmt=con.createStatement();
			 rset = stmt.executeQuery(sbsql.toString());
			if(rset.next())
			{
                dis_adv_Status=rset.getString("dis_adv_Status");
					
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			if(dis_adv_Status.equals("1"))
			{
	
			   java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_DISCH_CANT_CANCEL_ADV","IP");
				String error1 = ( (String) message.get("message") ) ;
						
				if(error1.lastIndexOf("<br>") >= 0)
						error1=error1.substring(0,error1.lastIndexOf("<br>"));
				out.println("<script>alert('"+error1+"');</script>");
				out.print("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>window.close();</script>");
				message.clear();
			}
			else
			{
	
			try
			{
				if(sbsql.length() > 0)
				 sbsql.delete(0, sbsql.length());
				sbsql.append(" SELECT  REFERRAL_ID refid");
				sbsql.append(" FROM pr_referral_register a ");
				sbsql.append(" WHERE added_facility_id = '"+facilityId+"' ");
				sbsql.append(" AND from_encounter_id ='"+encounterId+"'");
				sbsql.append(" AND bedside_referral_yn != 'Y' and status = 'D' "); 
				stmt=con.createStatement();
				rset = stmt.executeQuery(sbsql.toString());
				boolean first_time = true;
	
				while(rset.next())
				{
					ref_id = rset.getString("refid");

					if(first_time)
					  referral_id_list = "('"+ref_id+"'" ;
					else
						referral_id_list = referral_id_list + ",'" +ref_id +"'";

					first_time = false;
				}

				if(!first_time)
					referral_id_list = referral_id_list + ")";

				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				if(referral_id_list != "")
				{
					if(results)
					{
						if(sbsql.length() > 0)
							sbsql.delete(0, sbsql.length());
						
						sbsql.append(" update pr_referral_register set status = 'N',");
						sbsql.append(" modified_by_id=?,modified_date=sysdate,modified_facility_id=?, ");
						sbsql.append(" modified_at_ws_no=?");
						sbsql.append(" where referral_id in ");
						sbsql.append(referral_id_list);
						pstmt = con.prepareStatement(sbsql.toString());

						pstmt.setString(1, modifiedById);
						pstmt.setString(2, modifiedFacilityId);
						pstmt.setString(3, modifiedAtWorkstation);

						j = pstmt.executeUpdate();
						if(pstmt != null)	pstmt.close();
						if(j > 0)
							results = true;
						else
							results = false;
					}
					if(results)
					{
						if(sbsql.length() > 0)
						  sbsql.delete(0, sbsql.length());

						sbsql.append(" select appt_ref_no from oa_appt where ");
						sbsql.append(" facility_id = '"+facilityId+"' ");
						/*sbsql.append(" and referral_id in ");
						sbsql.append(referral_id_list);*/
						/*Wednesday, February 02, 2011 , to cancel appointment booked during prepare discharge advice .status of referral_id will be 'C' once appointment is created not 'D' .*/
						sbsql.append(" and FROM_ENCOUNTER_ID ="+encounterId+" ");

						stmt=con.createStatement();
						rset = stmt.executeQuery(sbsql.toString());

						String cancel_appts = "{call Oa_Cancel_Appointment (?,?,?,?,?,?,?,?,?,?,?,?)}";
						callstmt = con.prepareCall(cancel_appts);

						while(rset.next())
						{
						appt_ref_no=rset.getString("appt_ref_no");

							if(appt_ref_no != null)
							{
								String forced = "N";
								String reason="";
								String alcn_criteria="";
								String pat_cat="";
								String referralstatus="N";
								callstmt.setString(1, facilityId);
								callstmt.setString(2, appt_ref_no);
								callstmt.setString(3, patient_id);
								callstmt.setString(4, reason);
								callstmt.setString(5, alcn_criteria);
								callstmt.setString(6, pat_cat);
								callstmt.setString(7, addedFacilityId);
								callstmt.setString(8, addedAtWorkstation);
								callstmt.setString(9, forced);
								callstmt.setString(10, addedById);
								callstmt.registerOutParameter( 11, java.sql.Types.VARCHAR);
								callstmt.setString( 12, referralstatus);
								callstmt.execute() ;
								error = callstmt.getString(11); 
								 if (error==null) 
									 results = true;
								 else
									 results = false;

								if(callstmt != null) callstmt.close();
							}
						}
						if(rset != null) rset.close();
						if(stmt != null) stmt.close();
						if(callstmt != null) callstmt.close();
					}
				}
				/*1/29/2009 7688	PMG20089-CRF-0485 */
				/*if(results)
				{
					try
					{
						if (sbsql.length() > 0)
						sbsql.delete(0, sbsql.length());
						sbsql.append( "select count(*) from sm_module where module_id='OR' and install_yn='Y'");
						stmt=con.createStatement();
						rset = stmt.executeQuery(sbsql.toString());
						
						if(rset.next())
							or_installed = rset.getString(1);	
						if (rset != null)  rset.close();
						if (stmt != null)  stmt.close();
					}
					catch (Exception e)
					{
						results = false;
						//messageBuffer.append("Exception in sm_module"+e.toString());
						out.println("Exception in sm_module"+e.toString());
					}
					
					if(!or_installed.equals("0"))
					{
						if(results)
						{
							
							try
							{
								callstmt = con.prepareCall("{call OR_CAN_DIS_ADV_ORDER (?,?,?)}");
								callstmt.setString(1,  encounterId);
								callstmt.setString(2,  dis_adv_srl_no );
								callstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
														
								callstmt.execute();
								String cs = callstmt.getString(3);
								if(cs == null) cs = "";
								if(cs.equals(""))
								{
									results = true;
								}
								
							}
							catch (Exception exp)
							{
								results = false;
								//messageBuffer.append("Procedure-OR_INS_DIS_ADV_ORDER:"+exp.toString());
								exp.printStackTrace(System.out);
							}
						}
					}
				}
				*/
				if(results)
				{
					if(sbsql.length() > 0)
					  sbsql.delete(0, sbsql.length());
					sbsql.append(" update ip_discharge_advice set cancellation_date_time =sysdate, ");
					sbsql.append(" cancelled_by=?,cancellation_reason=?,dis_adv_status=?, ");
					sbsql.append(" modified_by_id=?,modified_date=sysdate,modified_facility_id=?, ");
					sbsql.append(" modified_at_ws_no=?");
					sbsql.append(" where facility_id=? and encounter_id=? and dis_adv_srl_no=? ");
					pstmt = con.prepareStatement(sbsql.toString());
					pstmt.setString(1, addedById);
					pstmt.setString(2, remarks);
					pstmt.setString(3, dis_adv_status);
					pstmt.setString(4, modifiedById);
					pstmt.setString(5, modifiedFacilityId);
					pstmt.setString(6, modifiedAtWorkstation);
					pstmt.setString(7, facilityId);
					pstmt.setString(8, encounterId);
					pstmt.setString(9, dis_adv_srl_no);
					j = 0;
					j = pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();
					if(j > 0)
						results = true;
					else
						results = false;
				}

			}
			catch(SQLException sqlex1)
			{
				results = false;
				sqlex1.printStackTrace();
			}

			if(results)
			{
				
				try
				{
					if(sbsql.length() > 0)
					  sbsql.delete(0, sbsql.length());
					sbsql.append(" SELECT leave_status FROM ip_leave_detail where encounter_id = "+encounterId+" and facility_id ='"+facilityId+"' and  srl_no=(select max(srl_no) FROM ip_leave_detail where encounter_id= "+encounterId+" and facility_id ='"+facilityId+"') and leave_status not in ( '2','9')");

					stmt=con.createStatement();
					rset = stmt.executeQuery(sbsql.toString());
					if(rset.next())
					{
						ip_leave_status = checkForNull(rset.getString("leave_status"));
					}

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();

					if(ip_leave_status==null) ip_leave_status="";
				}
				catch(Exception e)
				{	
					e.printStackTrace();
				}

				try
				{
					if(sbsql.length() > 0)
					  sbsql.delete(0, sbsql.length());
					//Modified for INC:47208- updating ExpectedDischargeDate as blank in pr_encounter
					sbsql.append(" update pr_encounter set OTH_ADT_STATUS= null,ip_leave_status='"+ip_leave_status+"' , EXP_DISCHARGE_DATE_TIME = '', modified_by_id = '"+modifiedById+"' , modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id  = '"+modifiedFacilityId+"'where encounter_id = "+encounterId+" and facility_id ='"+facilityId+"' ");
					pstmt = con.prepareStatement(sbsql.toString());
					
					j = 0;
					j = pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();

					if(j > 0)
						results = true;
					else
						results = false;
				}
				catch(Exception e)
				{	
					e.printStackTrace();
				}
			}

			if(results && billing_installed.equals("Y") && billing_interfaced.equals("Y"))
		 	{
				try
				{
					
					if(patient_class.equals("IP"))
	 					episode_type = "I";
					else if(patient_class.equals("DC"))
						episode_type = "D";
					
					String  episode_id	=	encounterId;
					Hashtable hashtableBill = new Hashtable();
					hashtableBill.put("facility_id",facilityId);
					hashtableBill.put("patient_id",patient_id);					
					hashtableBill.put("episode_id",episode_id);
					hashtableBill.put("encounter_id",encounterId);
					hashtableBill.put("function_id",function_id);
					hashtableBill.put("locale",locale);
					hashtableBill.put("billing_installed",billing_installed);
					hashtableBill.put("billing_interfaced",billing_interfaced);
					hashtableBill.put("episode_type",episode_type);
					hashtableBill.put("added_at_ws_no",addedAtWorkstation);
					hashtableBill.put("added_user_id",addedById);
					
					BLCancelDischargeAdvice blCancelDischargeAdvice = new BLCancelDischargeAdvice();
					Hashtable resultsBL = blCancelDischargeAdvice.billPatientService(p,con,hashtableBill);
					bill_result = ((Boolean) resultsBL.get("status")).booleanValue();	
							
					if(bill_result == false){
						bill_error = (String) (resultsBL.get("error"));
						results  = false;	
						bl_results = false;
					}
					else{
						results  = true;					
					}
					resultsBL.clear();
					hashtableBill.clear();
				}
				catch(Exception exceptionBL)
				{
					//results  = false;
					exceptionBL.printStackTrace();
				}		
			}
			
			//Modified for INC:47208 - Updating EXP_DISCHARGE_DATE_TIME as blank in ip_nursing_unit_bed, PR_ENCOUNTER_OTHER_DETAIL - Start
			//1. Updating ExpectedDischargeDate in PR_ENCOUNTER_OTHER_DETAIL:
			if(results)
			{
				if(sbsql.length() > 0)
					  sbsql.delete(0, sbsql.length());
				sbsql.append(" UPDATE PR_ENCOUNTER_OTHER_DETAIL SET exp_discharge_date_time = '', modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE operating_facility_id = ? AND encounter_id = ? ");
				pstmt   = con.prepareStatement( sbsql.toString() );
				pstmt.setString	( 1, modifiedById ) ;
				pstmt.setString	( 2, modifiedFacilityId ) ;
				pstmt.setString	( 3, modifiedAtWorkstation ) ;
				pstmt.setString	( 4, facilityId ) ;
				pstmt.setString	( 5, encounterId ) ;
				nResult = pstmt.executeUpdate() ;
				
				if(nResult > 0)
				{
					//2. Updating ExpectedDischargeDate in ip_nursing_unit_bed:
					if (!sBedNo.equals(""))
					{
						if(sbsql.length() > 0)
							  sbsql.delete(0, sbsql.length());
						sbsql.append(" UPDATE ip_nursing_unit_bed SET occupied_until_date_time='', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE facility_id  = ? AND nursing_unit_code =? AND bed_no= ? ");
						
						pstmt   = con.prepareStatement( sbsql.toString() );
						pstmt.setString	( 1, modifiedById ) ;
						pstmt.setString	( 2, modifiedFacilityId ) ;
						pstmt.setString	( 3, modifiedAtWorkstation ) ;
						pstmt.setString	( 4, facilityId ) ;
						pstmt.setString	( 5, sNursingUnitCode ) ;
						pstmt.setString	( 6, sBedNo ) ;
						nResult = pstmt.executeUpdate() ;
						
						if(nResult > 0)
							results = true;
						else
							results = false;
					}
				}else
				{
					results = false;
				}
			}

			//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			if(isDeceasedDiagClassDeathRegAppl){

				if(results)
				{
					if(("Y").equals(deceased_yn)){
						
						String sqldiag = " SELECT * FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND recorded_date_time >= to_date(?,'dd/mm/yyyy hh24:mi:ss') ";

						prstmt = con.prepareStatement(sqldiag);
						prstmt.setString(1,patient_id);
						prstmt.setString(2,encounterId);
						prstmt.setString(3,facilityId);
						prstmt.setString(4,deceased_date);
						rsset = prstmt.executeQuery();

						while(rsset.next()){
							
							term_set_id	= rsset.getString("term_set_id")==null?"":rsset.getString("term_set_id");
							term_code = rsset.getString("term_code")==null?"":rsset.getString("term_code");
							occur_srl_no = rsset.getString("occur_srl_no")==null?"":rsset.getString("occur_srl_no");

							if(!term_code.equals("")){

							if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
							
							sbsql.append(" UPDATE pr_diagnosis SET curr_status = 'E', curr_remarks = 'Discharge Advice Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and curr_facility_id = ? and curr_encounter_id = ? ");
							
							updpstmt = con.prepareStatement( sbsql.toString() );
							updpstmt.setString	( 1, modifiedById ) ;
							updpstmt.setString	( 2, modifiedFacilityId ) ;
							updpstmt.setString	( 3, modifiedAtWorkstation ) ;
							updpstmt.setString	( 4, patient_id ) ;
							updpstmt.setString	( 5, term_set_id ) ;
							updpstmt.setString	( 6, term_code ) ;
							updpstmt.setString	( 7, occur_srl_no ) ;
							updpstmt.setString	( 8, facilityId ) ;
							updpstmt.setString	( 9, encounterId ) ;
							nResult = updpstmt.executeUpdate() ;
							
							if(nResult > 0)
								results = true;
							else
								results = false;

							if(updpstmt != null) updpstmt.close();

							if(results){

								if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
								
								sbsql.append(" UPDATE pr_diagnosis_enc_dtl SET status = 'E', remarks = 'Discharge Advice Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND facility_id = ? AND encounter_id = ? ");
								
								updpstmt = con.prepareStatement( sbsql.toString() );
								updpstmt.setString	( 1, modifiedById ) ;
								updpstmt.setString	( 2, modifiedFacilityId ) ;
								updpstmt.setString	( 3, modifiedAtWorkstation ) ;
								updpstmt.setString	( 4, patient_id ) ;
								updpstmt.setString	( 5, term_set_id ) ;
								updpstmt.setString	( 6, term_code ) ;
								updpstmt.setString	( 7, occur_srl_no ) ;
								updpstmt.setString	( 8, facilityId ) ;
								updpstmt.setString	( 9, encounterId ) ;
								nResult = updpstmt.executeUpdate() ;
								
								if(nResult > 0)
									results = true;
								else
									results = false;

								if(updpstmt != null) updpstmt.close();
							}

							if(results){

								if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
								
								sbsql.append(" UPDATE pr_diagnosis_status SET status = 'E', remarks = 'Discharge Advice Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND facility_id = ? AND encounter_id = ? ");
								
								updpstmt = con.prepareStatement( sbsql.toString() );
								updpstmt.setString	( 1, modifiedById ) ;
								updpstmt.setString	( 2, modifiedFacilityId ) ;
								updpstmt.setString	( 3, modifiedAtWorkstation ) ;
								updpstmt.setString	( 4, patient_id ) ;
								updpstmt.setString	( 5, term_set_id ) ;
								updpstmt.setString	( 6, term_code ) ;
								updpstmt.setString	( 7, occur_srl_no ) ;
								updpstmt.setString	( 8, facilityId ) ;
								updpstmt.setString	( 9, encounterId ) ;
								nResult = updpstmt.executeUpdate() ;
								
								if(nResult > 0)
									results = true;
								else
									results = false;

								if(updpstmt != null) updpstmt.close();
							}

							if(results){

								String sqlaccnum = " SELECT accession_num_work_related FROM pr_diagnosis WHERE patient_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND curr_encounter_id = ? AND curr_facility_id = ? AND added_date >= to_date(?,'dd/mm/yyyy hh24:mi:ss') ";

								pstmtacc = con.prepareStatement(sqlaccnum);
								pstmtacc.setString(1,patient_id);
								pstmtacc.setString(2,term_set_id);
								pstmtacc.setString(3,term_code);
								pstmtacc.setString(4,occur_srl_no);
								pstmtacc.setString(5,encounterId);
								pstmtacc.setString(6,facilityId);
								pstmtacc.setString(7,deceased_date);
								rsacc = pstmtacc.executeQuery();

								if(rsacc!=null && rsacc.next()){
									
									accession_num_work_related = rsacc.getString("accession_num_work_related")==null?"":rsacc.getString("accession_num_work_related");

									if(!accession_num_work_related.equals("")){

										if(sbsql.length() > 0)
											  sbsql.delete(0, sbsql.length());
										
										sbsql.append(" UPDATE ca_encntr_note SET event_status = '9', event_status_caption = 'In Error', marked_in_error_by_id = ?, marked_in_error_date_time = SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE accession_num = ? ");
										
										updpstmt = con.prepareStatement( sbsql.toString() );
										updpstmt.setString	( 1, modifiedById ) ;
										updpstmt.setString	( 2, modifiedById ) ;
										updpstmt.setString	( 3, modifiedAtWorkstation ) ;
										updpstmt.setString	( 4, modifiedFacilityId ) ;
										updpstmt.setString	( 5, accession_num_work_related ) ;
										nResult = updpstmt.executeUpdate() ;
										
										if(nResult > 0)
											results = true;
										else
											results = false;

										if(updpstmt != null) updpstmt.close();
									}
								}

								if(rsacc != null) rsacc.close();
								if(pstmtacc != null) pstmtacc.close();
							}
							}
						}

						if(rsset != null) rsset.close();
						if(prstmt != null) prstmt.close();

						if(results){

							String sqlaudit = " SELECT DISTINCT term_set_id, term_code, occur_srl_no FROM mr_rec_diag_audit_trial WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND added_date >= to_date (?, 'dd/mm/yyyy hh24:mi:ss') ";

							pstmtaud = con.prepareStatement(sqlaudit);
							pstmtaud.setString(1,patient_id);
							pstmtaud.setString(2,encounterId);
							pstmtaud.setString(3,facilityId);
							pstmtaud.setString(4,deceased_date);
							rsaud = pstmtaud.executeQuery();

							while(rsaud.next()){
								
								audit_term_set_id = rsaud.getString("term_set_id")==null?"":rsaud.getString("term_set_id");
								audit_term_code = rsaud.getString("term_code")==null?"":rsaud.getString("term_code");
								audit_occur_srl_no = rsaud.getString("occur_srl_no")==null?"":rsaud.getString("occur_srl_no");

								if(!audit_term_code.equals("")){

								String sqlauditatr = " SELECT attr_updated, prev_attr_value FROM mr_rec_diag_audit_trial t WHERE (t.attr_updated, t.added_date) IN ( SELECT attr_updated, MIN (added_date) FROM mr_rec_diag_audit_trial WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss') GROUP BY attr_updated) AND patient_id = ? AND encounter_id = ? AND facility_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? ";

								pstmtaudatr = con.prepareStatement(sqlauditatr);
								pstmtaudatr.setString(1,patient_id);
								pstmtaudatr.setString(2,encounterId);
								pstmtaudatr.setString(3,facilityId);
								pstmtaudatr.setString(4,audit_term_set_id);
								pstmtaudatr.setString(5,audit_term_code);
								pstmtaudatr.setString(6,audit_occur_srl_no);
								pstmtaudatr.setString(7,deceased_date);
								pstmtaudatr.setString(8,patient_id);
								pstmtaudatr.setString(9,encounterId);
								pstmtaudatr.setString(10,facilityId);
								pstmtaudatr.setString(11,audit_term_set_id);
								pstmtaudatr.setString(12,audit_term_code);
								pstmtaudatr.setString(13,audit_occur_srl_no);
								rsaudatr = pstmtaudatr.executeQuery();

								while(rsaudatr.next()){
									
									audit_attr_updated = rsaudatr.getString("attr_updated")==null?"":rsaudatr.getString("attr_updated");
									audit_prev_attr_value = rsaudatr.getString("prev_attr_value")==null?"":rsaudatr.getString("prev_attr_value");

									//getpreviousdata for audit trail Added by Jeyachitra for ML-MMOH-CRF-1742
									pstmtaudatr1 = con.prepareStatement( "SELECT a.term_code, a.diag_class_code, a.nature, a.severity, a.accuracy_code, a.priority, TO_CHAR(b.onset_date, 'dd/mm/yyyy hh24:mi') onset_date, a.enc_stage, TO_CHAR(b.curr_status_date, 'dd/mm/yyyy') status_date, a.status, a.remarks FROM pr_diagnosis_enc_dtl a, pr_diagnosis b WHERE a.patient_id = b.patient_id AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND a.occur_srl_no = b.occur_srl_no AND a.patient_id = ? AND a.term_set_id = ? AND a.encounter_id = ? AND a.term_code = ? AND a.occur_srl_no = ? AND a.facility_id = ?" );	

									pstmtaudatr1.setString (1,patient_id);
									pstmtaudatr1.setString (2,audit_term_set_id);
									pstmtaudatr1.setString (3,encounterId);
									pstmtaudatr1.setString (4,audit_term_code);
									pstmtaudatr1.setString (5,audit_occur_srl_no);
									pstmtaudatr1.setString (6,facilityId);

									rsaudatr1 = pstmtaudatr1.executeQuery();

									if(rsaudatr1 != null && rsaudatr1.next())
									{
										prev_RecDiag_Data.put("Diagnosis_Code" ,checkForNull(rsaudatr1.getString("term_code")));
										prev_RecDiag_Data.put("Diagnosis_Classification",checkForNull(rsaudatr1.getString("diag_class_code")));
										prev_RecDiag_Data.put("Nature", checkForNull(rsaudatr1.getString("nature")));
										prev_RecDiag_Data.put("Severity", checkForNull(rsaudatr1.getString("severity")));
										prev_RecDiag_Data.put("Accuracy", checkForNull(rsaudatr1.getString("accuracy_code")));
										prev_RecDiag_Data.put("Priority", checkForNull(rsaudatr1.getString("priority")));
										prev_RecDiag_Data.put("Onset_Date", checkForNull(rsaudatr1.getString("onset_date")));
										prev_RecDiag_Data.put("Encounter_Stage", checkForNull(rsaudatr1.getString("enc_stage")));
										prev_RecDiag_Data.put("As_On_Date", checkForNull(rsaudatr1.getString("status_date")));
										prev_RecDiag_Data.put("Status", checkForNull(rsaudatr1.getString("status")));
										prev_RecDiag_Data.put("Diagnosis_Remarks", checkForNull(rsaudatr1.getString("remarks")));
									}
									
									if(rsaudatr1 != null) rsaudatr1.close();
									if(pstmtaudatr1 != null) pstmtaudatr1.close();

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Onset_Date") || audit_attr_updated.equals("Encounter_Stage") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){
					
									String current_attr_value = audit_prev_attr_value;
									
									for(Entry<String, String> k : prev_RecDiag_Data.entrySet())
									{
										String key = k.getKey();
										String prev_value = checkForNull(k.getValue());
											
										if(key.equalsIgnoreCase(audit_attr_updated))
										{
											pstmtaudatr1 = con.prepareStatement( "INSERT INTO mr_rec_diag_audit_trial (patient_id, term_set_id, term_code, occur_srl_no, facility_id, encounter_id, attr_updated, cur_attr_value, prev_attr_value, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );	
											pstmtaudatr1.setString (1,patient_id);
											pstmtaudatr1.setString (2,audit_term_set_id);
											pstmtaudatr1.setString (3,audit_term_code);
											pstmtaudatr1.setString (4,audit_occur_srl_no);
											pstmtaudatr1.setString (5,facilityId);
											pstmtaudatr1.setString (6,encounterId);
											pstmtaudatr1.setString (7,key);
											pstmtaudatr1.setString (8,current_attr_value);
											pstmtaudatr1.setString (9,prev_value);
											pstmtaudatr1.setString (10,addedById);
											pstmtaudatr1.setString (11,addedAtWorkstation);
											pstmtaudatr1.setString (12,facilityId);
											pstmtaudatr1.setString (13,modifiedById);
											pstmtaudatr1.setString (14,modifiedAtWorkstation);
											pstmtaudatr1.setString (15,facilityId);
											nResult = pstmtaudatr1.executeUpdate();

											if(nResult > 0)
												results = true;
											else
												results = false;
											
											if(pstmtaudatr1 != null) pstmtaudatr1.close();
										}
									}
									}

									if(results){

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Onset_Date") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Diagnosis_Classification"))
										attr_column_name = "diag_class_code";
									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "curr_nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "curr_severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "curr_accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "curr_priority";
									if(audit_attr_updated.equals("Onset_Date"))
										attr_column_name = "onset_date";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "curr_status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "curr_status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "curr_remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and curr_facility_id = ? and curr_encounter_id = ? ");
									
									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setString	( 9, encounterId ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										results = true;
									else
										results = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}

									if(results){

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Encounter_Stage") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Diagnosis_Classification"))
										attr_column_name = "diag_class_code";
									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "priority";
									if(audit_attr_updated.equals("Encounter_Stage"))
										attr_column_name = "enc_stage";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis_enc_dtl SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and facility_id = ? and encounter_id = ? ");
									
									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setString	( 9, encounterId ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										results = true;
									else
										results = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}

									if(results){

									if(audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "priority";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis_status SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and facility_id = ? and encounter_id = ? ");

									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setString	( 9, encounterId ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										results = true;
									else
										results = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}
								}

								if(rsaudatr != null) rsaudatr.close();
								if(pstmtaudatr != null) pstmtaudatr.close();
							}
							}

							if(rsaud != null) rsaud.close();
							if(pstmtaud != null) pstmtaud.close();
						}
					}
				}
			}

			if(results)
			{
				
				con.commit();
				
				Hashtable hashtable3 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
				error = (String)hashtable3.get("message");

				
/*
				if(error.lastIndexOf("<br>")>=0)
				error = error.substring(0, error.indexOf("<br>"));
*/
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>alert(\""+error+"\"); window.close();</script>");
				
				
				hashtable3.clear();
			} 
			else
			{

				con.rollback();				
				if(bl_results)
					out.println("<script>alert('ERROR IN CANCEL DISCHARGE ADVICE...');</script>");
				else
					out.println("<script>alert(\""+bill_error+"\");</script>");

				results = false;
				out.print("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>window.close();</script>");
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(callstmt != null) callstmt.close();
			}
	}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt != null)
			{
				try {	
					pstmt.close();	} 
				catch (SQLException e) {
					e.printStackTrace(); }
			}
			ConnectionManager.returnConnection(con, p);
		}
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}//E.O.CLass
