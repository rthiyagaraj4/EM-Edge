/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blopin;
import java.io.* ;
import java.sql.* ;
import javax.rmi.*;

import blPolicy.BLPayerPolicyDetails;
import eBL.PolicyInsuranceMasterBean;

import java.util.*;
import java.sql.* ;
import java.net.*;


import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;

public class BLOPReviseVisit
{
	public java.util.Hashtable billPatientService( Properties properties,Connection con, Hashtable tabdata)
	{
//		System.out.println("Inside BLOP Revise Visit");
	    PreparedStatement stmt =null;
		Statement stmt3 =null;
		CallableStatement statement = null;
		ResultSet rs  =null;

//		String err_out="";
		String strVisitMessage = "";
//		String strBillGenYN = "";
//		String strBillMessage = "";
		String strFinalMessage ="";

	/* *************** NEWLY ADDED VARIABLE ***************** */
		String str_blng_grp="";
/*
		String str_slmt_ind="";
		String str_credit_doc_reqd_yn="";
		String str_blng_class="";
		String str_emp_code="";
		String str_slmt_type_code="";
		String str_inst_ref="";
		String str_inst_date="";
		String str_inst_remarks="";
		String str_credit_cust_code="";
		String str_credit_doc_ref="";
		String str_credit_doc_start_date="";
		String str_credit_doc_end_date="";
		String str_sponsor_cust_code="";
		String str_sponsor_credit_doc_ref="";
		String str_sponsor_credit_doc_start_date="";
		String str_sponsor_credit_doc_end_date="";
		String str_ins_blng_grp="";
		String str_ins_cust_code="";
*/
		String str_ins_cust_priority="";
		String str_ins_policy_type_code="";
		String str_ins_policy_no="";
		String str_ins_policy_start_date="";
		String str_ins_policy_expiry_date="";
		String str_ins_credit_auth_ref="";
		String str_ins_credit_auth_date="";
		String str_ins_credit_approval_days="";
		String str_ins_credit_approval_amount="";
		String str_ins_policy_eff_from_date="";
		String str_ins_policy_eff_to_date="";
/*
		String str_ins_adj_rule_ind="";
		String str_ins_adj_perc_amt_ind="";
		String str_ins_adj_perc_amt_value="";
		String str_ins_pmnt_diff_adj_int="";
		String str_ins_drg_pmnt_diff_adj_int="";
		String str_ins_spl_srv_pmnt_diff_adj_int="";
*/
		String str_non_ins_blng_grp="";
/*
		String str_non_ins_credit_doc_reqd_yn="";
		String str_non_ins_slmt_type_code="";
		String str_non_ins_inst_ref="";
		String str_non_ins_inst_date="";
		String str_non_ins_inst_remarks="";
*/
		String str_non_ins_cust_group_code="";
		String str_non_ins_cust_code="";
/*
		String str_non_ins_credit_doc_ref="";
		String str_non_ins_credit_doc_start_date="";
		String str_non_ins_credit_doc_end_date="";
		String str_annual_income="";
		String str_family_asset="";
		String str_no_of_dependants="";
		String str_resp_for_payment="";
		String str_pat_reln_with_resp_person="";
		String str_fin_remarks="";
		String str_gl_holder_name="";
		String str_pat_reln_with_gl_holder="";
		String str_upd_patient_fin_dtls_yn="";
		String str_user_id="";
		String str_fin_auth_user_id="";
		String str_calling_function_id="";
*/
		String str_cust_code = "";
		String str_cust_group_code = "";
/*		String str_doc_ref= "";
		String str_doc_start_date="";
		String str_doc_end_date="";

		String str_acct_seq_eff_from_date="";
		String str_acct_seq_eff_to_date="";

		double annual_income = 0.0;
		double family_asset = 0.0;
		int no_of_dependants = 0;
		int ins_credit_approval_days=0;
		double ins_credit_approval_amount=0.0;
		double ins_adj_perc_amt_value=0.0;
*/
		String strNewHospChrgCreate="";
		String strNewMedChrgCreate="";
		String strNewAddlChrgCreate="";

		String hosp_serv_panel_ind="";
		String hosp_serv_panel_code="";
		String hosp_serv_panel_str="";
		String hosp_serv_panel_qty="1.0";
		String hosp_serv_charge_amt="";

		String med_serv_panel_ind="";
		String med_serv_panel_code="";
		String med_serv_panel_str="";
		String med_serv_panel_qty="1.0";
		String med_serv_charge_amt="";

		String addl_serv_panel_ind="";
		String addl_serv_panel_code="";
		String addl_serv_panel_str="";
		String addl_serv_panel_qty="1.0";
		String addl_serv_charge_amt="";

		int acc_seq_no=0;
		String strAccSeqNo="";

		String exempt_date="";

		String hosp_charge_YN="";
		String med_charge_YN="";
		String addl_charge_YN="";

		double hosp_chrg_amt=0.0;
		double hosp_chrg_pat_amt=0.0;
		double med_chrg_amt=0.0;
		double med_chrg_pat_amt=0.0;
		double addl_chrg_amt=0.0;
		double addl_chrg_pat_amt=0.0;
		double total_chrg_amt=0.0;
		double total_pat_chrg_amt=0.0;
		
		String str_hosp_chrg_amt="";
		String str_hosp_chrg_pat_amt="";
		String str_med_chrg_amt="";
		String str_med_chrg_pat_amt="";
		String str_addl_chrg_amt="";
		String str_addl_chrg_pat_amt="";
		String str_total_chrg_amt="";
		String str_total_pat_chrg_amt="";

		String bill_gen_yn="";
		String bill_doc_type="";
		String bill_doc_number="";
		String total_bill_text="";

		String str_bill_later_YN="N";
		String str_bill_gen_later="N";
		String str_total_bill_amt="";

		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";

		String err_level = "";
		String sys_message_id = "";
		String err_text = "";

		String module_id="";
		String facility_id="";
		String episode_type="";
		String episode_id="";
		String visit_id="";
		String encounter_id="";
		String function_id="";
		String visit_type_code="";
		String old_visit_type_code="";
		String clinic_code="";
		String practitioner_id="";
		String charge_basis_by_physician_yn = "";
		String locale="";
		String added_by_id="";
		String added_at_ws_no="";
		String patient_id="";

		String str_vst_regn_date_time = "";

		String strOldClinicCode = "";
		String strOldVstTypeCode = "";
		String strOldPractId= "";
		String strOldChargeByPractYN = "";

		String call_revise_proc_YN = "N";
		String call_charge_proc_YN = "N";

	/******************************************************************************/

//		String encounterid="";
		boolean insertable = true;
		StringBuffer sb = new StringBuffer( " " ) ;
		java.util.Hashtable results = new java.util.Hashtable() ;
		Hashtable messageHashtable=new Hashtable();

//		boolean result=false;

//		String strUser = (String)properties.getProperty("login_user");
//		String strWsNo = (String)properties.getProperty("client_ip_address");
		String strBLInterfaceYN = "N";
		String strBillInterfaceQry ="";

		String strNull = "";

		int noofdecimal=2;
		
		try
		{		
			String no_of_decimal="select nvl(no_of_decimal,2) from  sm_acc_entity_param";
			stmt3 = con.createStatement();
			rs = stmt3.executeQuery(no_of_decimal) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					noofdecimal  =  rs.getInt(1);	
				}
			}
			stmt3.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}

		try
		{		
			String bill_gen_later_YN_qry="select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+(String)tabdata.get("facilityId")+"'";
			stmt3 = con.createStatement();
			rs = stmt3.executeQuery(bill_gen_later_YN_qry) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					str_bill_later_YN  =  rs.getString(1);	
				}
			}
			if(str_bill_later_YN == null) str_bill_later_YN="N";
//			System.out.println("str_bill_later_YN:"+str_bill_later_YN);
			stmt3.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of bill_gen_later_YN_qry Query="+e.toString());
		}

		try
		{
			strBillInterfaceQry = " SELECT nvl(BL_INTERFACED_YN,'N') from OP_PARAM where "+
				"	OPERATING_FACILITY_ID=?";
		   stmt = con.prepareStatement( strBillInterfaceQry );
			stmt.setString(1,((String)tabdata.get("facilityId")).trim());
			rs = stmt.executeQuery();
			if (rs.next())
			{
				strBLInterfaceYN = rs.getString(1);
			}
			if (strBLInterfaceYN.equals(""))
			{
				strBLInterfaceYN = "N";
			}
			stmt.close();
			if(rs !=null)rs.close();
		}
		catch(Exception exceptionBL)
		{
			strBLInterfaceYN ="N";
		}

		if (strBLInterfaceYN.equals("Y"))
		{
			try
			{
				sb.append(" ");

				HashMap billing_data=(HashMap)tabdata.get("fin_dtls");
	/*
				if(billing_data!=null)
				{
					locale			= (String)billing_data.get("locale");
				}
				if(locale==null || locale.equals("")) locale="en";
	*/
				locale=(String)tabdata.get("locale");
				if(locale==null || locale.equals("")) locale="en";

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String hosp_chrg_leg = bl_labels.getString("eBL.HOSP_CHRG.label");
				String prof_chrg_leg = bl_labels.getString("eBL.PROF_CHRG.label");
				String addl_chrg_leg = bl_labels.getString("eBL.ADDL_CHARGE.label");
				String vst_chrg_exmpt_leg = bl_labels.getString("eBL.VISIT_CHRG_EXEMPT_UPTO.label");
				String bill_gen_yn_leg = bl_labels.getString("eBL.PLS_NOTE_DOWN_THE_BILL.label");
				String bill_gen_yn_leg1 = bl_labels.getString("eBL.FOR_THE_VISIT_CHRG.label");
				String patient_payable_leg = common_labels.getString("Common.PatientPayable.label");
				String bill_gen_yn_message = (String) bl_messages.getString("BL7335");

				module_id=(String)tabdata.get("module_id");
				if(module_id==null || module_id.equals("")) module_id="";

				facility_id=(String)tabdata.get("facilityId");
				if(facility_id==null || facility_id.equals("")) facility_id="";

				episode_type=(String)tabdata.get("episode_type");
				if(episode_type==null || episode_type.equals("")) episode_type="";

				episode_id=(String)tabdata.get("episode_id");
				if(episode_id==null || episode_id.equals("")) episode_id="";

				visit_id=(String)tabdata.get("visit_id");
				if(visit_id==null || visit_id.equals("")) visit_id="";

				encounter_id=(String)tabdata.get("encounterid");
				if(encounter_id==null || encounter_id.equals("")) encounter_id="";

				function_id=(String)tabdata.get("function_id");
				if(function_id==null || function_id.equals("")) function_id="";

				patient_id=(String)tabdata.get("patient_id");
				if(patient_id==null || patient_id.equals("")) patient_id="";

				clinic_code=(String)tabdata.get("clinic_code");
				if(clinic_code==null || clinic_code.equals("")) clinic_code="";

				visit_type_code=(String)tabdata.get("cur_visit_type_code");
				if(visit_type_code==null || visit_type_code.equals("")) visit_type_code="";

				
				old_visit_type_code=(String)tabdata.get("cur_visit_type_code");
				if(old_visit_type_code==null || old_visit_type_code.equals("")) old_visit_type_code="";	

							
				practitioner_id=(String)tabdata.get("asn_pract_id");
				if(practitioner_id==null || practitioner_id.equals("")) practitioner_id="";

				added_by_id=(String)tabdata.get("addedById");
				if(added_by_id==null || added_by_id.equals("")) added_by_id="";
				
				added_at_ws_no=(String)tabdata.get("addedAtWorkstation");
				if(added_at_ws_no==null || added_at_ws_no.equals("")) added_at_ws_no="";
				
//				System.out.println("billng_data in OP bean is:"+billing_data);

				if(billing_data!=null)
				{

				
				HashMap hosp_dtls=(HashMap)billing_data.get("hosp_dtls");

				if(hosp_dtls!=null)
				{
					hosp_serv_panel_ind=(String)hosp_dtls.get("hosp_serv_panel_ind");
					hosp_serv_panel_code=(String)hosp_dtls.get("hosp_serv_panel_code");
					hosp_serv_panel_str=(String)hosp_dtls.get("hosp_serv_panel_str");
					hosp_serv_panel_qty=(String)hosp_dtls.get("hosp_serv_panel_qty");
					hosp_serv_charge_amt=(String)hosp_dtls.get("hosp_serv_chrg_amt");
				}

				HashMap prof_dtls=(HashMap)billing_data.get("prof_dtls");
		
				if(prof_dtls!=null)
				{
					med_serv_panel_ind=(String)prof_dtls.get("prof_serv_panel_ind");
					med_serv_panel_code=(String)prof_dtls.get("prof_serv_panel_code");
					med_serv_panel_str=(String)prof_dtls.get("prof_serv_panel_str");
					med_serv_panel_qty=(String)prof_dtls.get("prof_serv_panel_qty");
					med_serv_charge_amt=(String)prof_dtls.get("prof_serv_chrg_amt");
				}

				HashMap addl_dtls=(HashMap)billing_data.get("addl_dtls");
		
				if(addl_dtls!=null)
				{
					addl_serv_panel_ind=(String)addl_dtls.get("addl_serv_panel_ind");
					addl_serv_panel_code=(String)addl_dtls.get("addl_serv_panel_code");
					addl_serv_panel_str=(String)addl_dtls.get("addl_serv_panel_str");
					addl_serv_panel_qty=(String)addl_dtls.get("addl_serv_panel_qty");
					addl_serv_charge_amt=(String)addl_dtls.get("addl_serv_chrg_amt");
				}
				}
				
//				int intVisitNum = Integer.parseInt((String) tabdata.get("visit_id"));
//				int intEpisodeNum = Integer.parseInt((String) tabdata.get("episode_id"));

				try
				{
					String acc_seq_no_sql="select NVL(CUR_ACCT_SEQ_NO,0)  from bl_visit_fin_Dtls where OPERATING_FACILITY_ID='"+facility_id+"' AND EPISODE_TYPE ='"+episode_type+"' AND EPISODE_ID='"+episode_id+"' AND VISIT_ID ='"+visit_id+"' AND PATIENT_ID  ='"+patient_id+"'";

					stmt3 = con.createStatement();
					rs = stmt3.executeQuery(acc_seq_no_sql) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							strAccSeqNo= rs.getString(1);
						}
					}
					stmt3.close();
					if(rs !=null)rs.close();

					if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";

					acc_seq_no=Integer.parseInt(strAccSeqNo);

//					System.out.println("acc_seq_no:"+acc_seq_no);
						
				}
				catch(Exception e)
				{
					System.out.println("Exception in Acc Seq No:"+e);
				}

					// Added for WS by IP Address/Name
					
				String str_ws_by_ip_name = "";
				String str_facility_id = ((String) tabdata.get("facilityId"));
				String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+str_facility_id+"'";
				PreparedStatement pst1=con.prepareStatement(sqlst1);
				ResultSet rst1 = pst1.executeQuery();
				if (rst1!=null)
				{
				   if (rst1.next())
				   {
						 str_ws_by_ip_name = rst1.getString("ws_by_ip_name");
				   }
			   }
			   if(rst1 != null) rst1.close();

				if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";

					// End for WS by IP Adress/Name

				String strModuleId = (String)tabdata.get("module_id");
				if (strModuleId == null || strModuleId.equals(""))
				{
					strModuleId = "OP";
				}
				String strEpisodeType = (String)tabdata.get("episode_type");
				if (strEpisodeType == null || strEpisodeType.equals(""))
				{
					strEpisodeType="O";
				}

				String p_machine_name = "";
		
				if (str_ws_by_ip_name.equals("I"))
				{						
					p_machine_name = InetAddress.getByName((String) added_at_ws_no).getHostName() ;
				}
				else
				{
					p_machine_name = ((String) added_at_ws_no);
				}

				try
				{
					String old_visit_dtls_sql="select CLINIC_CODE,VISIT_TYPE_CODE,PHYSICIAN_ID,CUR_CHARGING_BASIS_BY_PRACT_YN from bl_visit_exm_fin_dtls where OPERATING_FACILITY_ID='"+str_facility_id+"' AND EPISODE_TYPE ='"+episode_type+"' AND EPISODE_ID='"+episode_id+"' AND VISIT_ID ='"+visit_id+"' AND PATIENT_ID  ='"+patient_id+"'";
//					System.out.println("old_visit_dtls_sql:"+old_visit_dtls_sql);
					stmt3 = con.createStatement();
					rs = stmt3.executeQuery(old_visit_dtls_sql) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							strOldClinicCode = rs.getString(1);
							strOldVstTypeCode = rs.getString(2);
							strOldPractId= rs.getString(3);
							strOldChargeByPractYN = rs.getString(4);
						}
					}
					if(rs != null) rs.close();
					stmt3.close();

					if(strOldClinicCode==null || strOldClinicCode.equals("")) strOldClinicCode="";
					if(strOldVstTypeCode==null || strOldVstTypeCode.equals("")) strOldVstTypeCode="";
					if(strOldPractId==null || strOldPractId.equals("")) strOldPractId="";

//					System.out.println("strOldClinicCode:"+strOldClinicCode);
//					System.out.println("strOldVstTypeCode:"+strOldVstTypeCode);
//					System.out.println("strOldPractId:"+strOldPractId);
//					System.out.println("strOldChargeByPractYN:"+strOldChargeByPractYN);
				}
				catch(Exception e)
				{
					System.out.println("Exception in old_visit_dtls_sql:"+e);
				}

				try
				{
					CallableStatement call = con.prepareCall("{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					call.setString(1,facility_id);
					call.setString(2,clinic_code);
					call.setString(3,visit_type_code);
					call.setString(4,practitioner_id);

					call.registerOutParameter(5,java.sql.Types.INTEGER);
					call.registerOutParameter(6,java.sql.Types.INTEGER);
					call.registerOutParameter(7,java.sql.Types.VARCHAR);
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.registerOutParameter(9,java.sql.Types.VARCHAR);
					call.registerOutParameter(10,java.sql.Types.VARCHAR);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
					call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);	
					call.registerOutParameter(14,java.sql.Types.VARCHAR);
					call.registerOutParameter(15,java.sql.Types.VARCHAR);
					call.registerOutParameter(16,java.sql.Types.VARCHAR);

					call.execute();

					charge_basis_by_physician_yn=call.getString(7);
					if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="N";

					err_level=call.getString(14);
					sys_message_id=call.getString(15);
					err_text=call.getString(16);
					if (err_level == null) err_level ="";
					if (sys_message_id ==null) sys_message_id ="";
					if (err_text ==null) err_text ="";

//					System.out.println("charge_basis_by_physician_yn:"+charge_basis_by_physician_yn);

//					System.out.println("error_level in BLOPIN:"+err_level);
//					System.out.println("sys_message_id in BLOPIN:"+sys_message_id);
//					System.out.println("error_text in BLOPIN:"+err_text);

					if( (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
					{
						insertable=false;

						if((err_level.equals("10") && !err_text.equals("") ))
						{
							sb.append("<br>"+err_text+"<br> ") ;
//							System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append((String)messageHashtable.get("message"));
//							System.out.println("sb mesage in sys_message is:"+sb);
						}
						call.close();
					}
					sys_message_id="";
					err_level="";
					err_text="";
				
					call.close();
				}
				catch(Exception e)
				{
					insertable = false;
					System.out.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"+e);
				}

/*
				statement=con.prepareCall("{call  BL_OP_REVISE_VISIT.proc_main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				statement.setString( 1,"D");									
				statement.setString( 2,"REVISE_VISIT");									
				statement.setString( 3,(String)tabdata.get("facilityId"));		
				//statement.setString( 4,"OP");									
				statement.setString( 4, strModuleId);									
				statement.setString( 5, (String) tabdata.get("clinic_code"));	
				statement.setString( 6, (String) tabdata.get("asn_visit_type_code"));
				statement.setString( 7, (String) tabdata.get("cur_visit_type_code"));
				statement.setString( 8, strNull);								
				statement.setString( 9, (String) tabdata.get("patient_id"));	
				statement.setString( 10, strEpisodeType);						
				statement.setInt( 11, intEpisodeNum);							
				statement.setInt( 12, intVisitNum);								
				statement.setString( 13,(String) tabdata.get("asn_pract_id"));	
				statement.setString( 14, strUser);								
				statement.setString( 15, strWsNo);
				statement.setString( 16,p_machine_name);
				statement.registerOutParameter( 17, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 18, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 19, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 20, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 21, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 22, java.sql.Types.VARCHAR);	
				statement.registerOutParameter( 23, java.sql.Types.VARCHAR);	

				statement.execute();

				strVisitMessage = statement.getString(17);
				strBillGenYN = statement.getString(18);
				String strBillDocTypeCode = statement.getString(19);
				String strBillDocNumber = statement.getString(20);
				strBillMessage =  statement.getString(21);
				String strErrMsg  = statement.getString(22);
				String strErrText  = statement.getString(23);
					
				if (strErrMsg != null )
				{
					strErrMsg = strErrMsg.trim();
					if (!strErrMsg.equals(""))
					{
						insertable=false;
						sb.append("BLOPReviseVisit: Error Code "+strErrMsg);
						con.rollback();
						con.setAutoCommit(true);
					}
				}
				if (strErrText != null )
				{
					strErrText = strErrText.trim();
					if ( !strErrText.equals("") )
					{
						insertable=false;
						sb.append("BLOPReviseVisit: Error Text "+strErrText);
						con.rollback();
						con.setAutoCommit(true);
					}
				}
				if (strBillGenYN == null || strBillGenYN.equals(""))
				{
					strBillGenYN = "N";
					strFinalMessage = strVisitMessage;
				}
				if (strBillGenYN.equals("V"))
				{
					strFinalMessage = strBillMessage;
				}
				else
				{
					strFinalMessage = strVisitMessage;
				}		
*/
				if(insertable)
				{
					if( (!strOldClinicCode.equals(clinic_code)) || (!strOldVstTypeCode.equals(visit_type_code)) || ((charge_basis_by_physician_yn.equals("Y") && !strOldPractId.equals(practitioner_id)) || (charge_basis_by_physician_yn.equals("N") && !strOldPractId.equals(practitioner_id)) ) )
					{
						call_revise_proc_YN = "Y";
					}
					else
					{
						call_charge_proc_YN = "Y";
					}

					if(call_charge_proc_YN.equals("Y"))
					{
						String sql_charge_visit="{call BLVisitCharge.proc_main('D','"+function_id+"','"+facility_id+"','"+module_id+"','"+clinic_code+"','"+visit_type_code+"','"+strNull+"','"+patient_id+"','"+episode_type+"','"+encounter_id+"','"+episode_id+"','"+visit_id+"','"+str_vst_regn_date_time+"','P','"+practitioner_id+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+addl_serv_panel_ind+"','"+addl_serv_panel_code+"','"+addl_serv_panel_str+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+added_by_id+"','"+added_at_ws_no+"','"+p_machine_name+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
						
//						System.out.println("sql_charge_visit:"+sql_charge_visit);
						statement=con.prepareCall(sql_charge_visit);

						statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 11, java.sql.Types.VARCHAR);								statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 20, java.sql.Types.VARCHAR);


						statement.execute();

						hosp_charge_YN= statement.getString(1);
						if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

						med_charge_YN= statement.getString(2);
						if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

						addl_charge_YN= statement.getString(3);
						if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";
						
						exempt_date= statement.getString(4);

						hosp_chrg_amt= statement.getDouble(5);
						hosp_chrg_pat_amt=statement.getDouble(6);
						
						med_chrg_amt= statement.getDouble(7);
						med_chrg_pat_amt=statement.getDouble(8);

						addl_chrg_amt= statement.getDouble(9);
						addl_chrg_pat_amt=statement.getDouble(10);

						bill_gen_yn=statement.getString(11);
						if(bill_gen_yn==null) bill_gen_yn="";
						bill_doc_type=statement.getString(12);
						if(bill_doc_type==null) bill_doc_type="";
						bill_doc_number=statement.getString(13);
						if(bill_doc_number==null) bill_doc_number="";
						str_bill_gen_later=statement.getString(14);
						if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="N";
						str_total_bill_amt=statement.getString(15);
						if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

						str_bill_prt_format_YN = statement.getString(16);
						if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

						str_bill_prt_format_vals = statement.getString(17);
						if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";

						System.err.println("str_bill_prt_format_YN:"+str_bill_prt_format_YN);
						System.err.println("str_bill_prt_format_vals:"+str_bill_prt_format_vals);
						
						err_level=statement.getString(18);
						sys_message_id=statement.getString(19);
						err_text=statement.getString(20);
						if (err_level == null) err_level ="";
						if (sys_message_id ==null) sys_message_id ="";
						if (err_text ==null) err_text ="";
		
						statement.close();

					}
					else if (call_revise_proc_YN.equals("Y"))
					{
						String sql_revise_visit="{call BLVISITREVISE.proc_main('D','"+function_id+"','"+facility_id+"','"+module_id+"','"+clinic_code+"','"+visit_type_code+"','"+old_visit_type_code+"','"+strNull+"','"+patient_id+"','"+episode_type+"','"+encounter_id+"','"+episode_id+"','"+visit_id+"','P','"+practitioner_id+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+addl_serv_panel_ind+"','"+addl_serv_panel_code+"','"+addl_serv_panel_str+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+added_by_id+"','"+added_at_ws_no+"','"+p_machine_name+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

						System.out.println("sql_revise_visit:"+sql_revise_visit);

						statement=con.prepareCall(sql_revise_visit);			

						statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 11, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 20, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 21, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 22, java.sql.Types.VARCHAR);
						
						statement.execute();

						hosp_charge_YN= statement.getString(1);
						if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

						med_charge_YN= statement.getString(2);
						if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

						addl_charge_YN= statement.getString(3);
						if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";

						exempt_date= statement.getString(4);
						if(exempt_date==null || exempt_date.equals("")) exempt_date="";

						str_hosp_chrg_amt=statement.getString(5);
						if(str_hosp_chrg_amt==null || str_hosp_chrg_amt.equals("")) str_hosp_chrg_amt="0.0";
						hosp_chrg_amt= Double.parseDouble(str_hosp_chrg_amt);

						str_hosp_chrg_pat_amt=statement.getString(6);
						if(str_hosp_chrg_pat_amt==null || str_hosp_chrg_pat_amt.equals("")) str_hosp_chrg_pat_amt="0.0";
						hosp_chrg_pat_amt=Double.parseDouble(str_hosp_chrg_pat_amt);
							
						str_med_chrg_amt=statement.getString(7);
						if(str_med_chrg_amt==null || str_med_chrg_amt.equals("")) str_med_chrg_amt="0.0";
						med_chrg_amt=Double.parseDouble(str_med_chrg_amt);

						str_med_chrg_pat_amt=statement.getString(8);
						if(str_med_chrg_pat_amt==null || str_med_chrg_pat_amt.equals("")) str_med_chrg_pat_amt="0.0";
						med_chrg_pat_amt=Double.parseDouble(str_med_chrg_pat_amt);

						str_addl_chrg_amt=statement.getString(9);
						if(str_addl_chrg_amt==null || str_addl_chrg_amt.equals("")) str_addl_chrg_amt="0.0";
						addl_chrg_amt=Double.parseDouble(str_addl_chrg_amt);

						str_addl_chrg_pat_amt=statement.getString(10);
						if(str_addl_chrg_pat_amt==null || str_addl_chrg_pat_amt.equals("")) str_addl_chrg_pat_amt="0.0";
						addl_chrg_pat_amt=Double.parseDouble(str_addl_chrg_pat_amt);

						strVisitMessage=statement.getString(11);
						if(strVisitMessage==null) strVisitMessage="";

						bill_gen_yn=statement.getString(12);
						if(bill_gen_yn==null || bill_gen_yn.equals("")) bill_gen_yn="";
						bill_doc_type=statement.getString(13);
						if(bill_doc_type==null || bill_doc_type.equals("")) bill_doc_type="";
						bill_doc_number=statement.getString(14);
						if(bill_doc_number==null || bill_doc_number.equals("")) bill_doc_number="";
						total_bill_text=statement.getString(15);
						if(total_bill_text==null || total_bill_text.equals("")) total_bill_text="";

						str_bill_gen_later=statement.getString(16);
						if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="N";
						str_total_bill_amt=statement.getString(17);
						if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

						str_bill_prt_format_YN = statement.getString(18);
						if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

						str_bill_prt_format_vals = statement.getString(19);
						if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
				
						err_level=statement.getString(20);
						sys_message_id=statement.getString(21);
						err_text=statement.getString(22);

						if(err_level==null || err_level.equals("")) err_level="";
						if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
						if(err_text==null || err_text.equals("")) err_text="";
					}

					try
					{
						total_chrg_amt=hosp_chrg_amt+med_chrg_amt+addl_chrg_amt;
						total_pat_chrg_amt=hosp_chrg_pat_amt+med_chrg_pat_amt+addl_chrg_pat_amt;
						
						str_total_chrg_amt=String.valueOf(total_chrg_amt);
						str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);

						CurrencyFormat cf1 = new CurrencyFormat();
			
						if (str_hosp_chrg_amt!=null)
							str_hosp_chrg_amt = cf1.formatCurrency(str_hosp_chrg_amt, noofdecimal);
							
						if(str_med_chrg_amt!=null)
							str_med_chrg_amt = cf1.formatCurrency(str_med_chrg_amt, noofdecimal);

						if(str_addl_chrg_amt!=null)
							str_addl_chrg_amt = cf1.formatCurrency(str_addl_chrg_amt, noofdecimal);
							
						if(str_total_chrg_amt!=null)
							str_total_chrg_amt = cf1.formatCurrency(str_total_chrg_amt, noofdecimal);

						if(str_total_pat_chrg_amt!=null)
							str_total_pat_chrg_amt = cf1.formatCurrency(str_total_pat_chrg_amt, noofdecimal);

						if(str_hosp_chrg_pat_amt!=null)
							str_hosp_chrg_pat_amt=cf1.formatCurrency(str_hosp_chrg_pat_amt, noofdecimal);

						if(str_med_chrg_pat_amt!=null)
							str_med_chrg_pat_amt=cf1.formatCurrency(str_med_chrg_pat_amt, noofdecimal);

						if(str_addl_chrg_pat_amt!=null)
							str_addl_chrg_pat_amt=cf1.formatCurrency(str_addl_chrg_pat_amt, noofdecimal);
					}
					catch(Exception e)
					{
						System.out.println("Currency exception ::"+e);
					}

					System.out.println("hosp_charge_YN BLOPReviseVisit.java :"+hosp_charge_YN);
					System.out.println("med_charge_YN BLOPReviseVisit.java :: "+med_charge_YN);
					System.out.println("addl_charge_YN BLOPReviseVisit.java :: "+addl_charge_YN);
					System.out.println("exempt_date BLOPReviseVisit.java : "+exempt_date);
					System.out.println("hosp_chrg_amt BLOPReviseVisit.java :: "+hosp_chrg_amt);
					System.out.println("hosp_chrg_pat_amt BLOPReviseVisit.java :: "+hosp_chrg_pat_amt);
					System.out.println("med_chrg_amt BLOPReviseVisit.java :: "+med_chrg_amt);
					System.out.println("med_chrg_pat_amt BLOPReviseVisit.java :: "+med_chrg_pat_amt);
					System.out.println("addl_chrg_amt BLOPReviseVisit.java :: "+addl_chrg_amt);
					System.out.println("addl_chrg_pat_amt BLOPReviseVisit.java :: "+addl_chrg_pat_amt);
					System.out.println("strVisitMessage BLOPReviseVisit.java :: "+strVisitMessage);
					System.out.println("bill_gen_yn BLOPReviseVisit.java :: "+bill_gen_yn);
					System.out.println("bill_doc_type BLOPReviseVisit.java :: "+bill_doc_type);
					System.out.println("bill_doc_number BLOPReviseVisit.java :: "+bill_doc_number);
					System.out.println("total_bill_text BLOPReviseVisit.java :: "+total_bill_text);
					System.out.println("str_bill_gen_later BLOPReviseVisit.java :: "+str_bill_gen_later);
					System.out.println("str_total_bill_amt BLOPReviseVisit.java :: "+str_total_bill_amt);

					if(bill_gen_yn.equals("Y") && (bill_doc_type.equals("") && bill_doc_number.equals("0")))
					{
						bill_gen_yn="N";
					}

					if(hosp_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(hosp_chrg_amt>=0)
						{
							strFinalMessage=hosp_chrg_leg+" "+str_hosp_chrg_amt+" "+patient_payable_leg+" "+str_hosp_chrg_pat_amt;
						}
					}

					if(med_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(med_chrg_amt>=0)
						{
							strFinalMessage=strFinalMessage+"<BR>"+prof_chrg_leg+" "+str_med_chrg_amt+" "+patient_payable_leg+" "+str_med_chrg_pat_amt;
						}
					}

					if(addl_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(addl_chrg_amt>=0)
						{
							strFinalMessage=strFinalMessage+"<BR>"+addl_chrg_leg+" "+str_addl_chrg_amt+" "+patient_payable_leg+" "+str_addl_chrg_pat_amt;
						}
					}

					if(exempt_date!=null && !exempt_date.equals(""))
					{
						strFinalMessage=strFinalMessage+"<BR>"+vst_chrg_exmpt_leg+" "+exempt_date;
					}

					if(bill_gen_yn.equals("Y") && str_bill_gen_later.equals("N"))
					{
//						strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_leg+" "+bill_doc_type+"/"+bill_doc_number+" "+bill_gen_yn_leg1+" "+str_total_chrg_amt+" "+patient_payable_leg+" "+str_total_pat_chrg_amt;
						strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_message+bill_doc_type+"/"+bill_doc_number;
					}
						
					System.out.println("strFinalMessage BLOPReviseVisit.java :: "+strFinalMessage);

					

					System.out.println("err_level BLOPReviseVisit.java :: "+err_level);
					System.out.println("sys_message_id BLOPReviseVisit.java :: "+sys_message_id);
					System.out.println("err_text BLOPReviseVisit.java :: "+err_text);

					if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
					{
						insertable=false;

						if((err_level.equals("10") && !err_text.equals("") ))
						{
							sb.append("<br>"+err_text+"<br> ") ;
//							System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append("<br>"+(String)messageHashtable.get("message")+"<br>");
//							System.out.println("sb mesage in sys_message is:"+sb);
						}
						statement.close();
					}
					sys_message_id="";
					err_level="";
					err_text="";
				}
				
			/*Karthik added code starts here INCLUDE_POLICY_DETAILS_CRF 5-25-2013*/	
				if(insertable){

					HashMap plcyDetails=new HashMap(); 
					billing_data=(HashMap)tabdata.get("fin_dtls");
					plcyDetails=(HashMap)billing_data.get("payer_plcy_dtls"); 
					String priority=null;
					String policy_no=null;

					try{
					HashMap returnMap = new HashMap();
					Set<String> plcyDetailsSet;
					plcyDetailsSet=(Set<String>)plcyDetails.keySet();
					Iterator<String> plcyDetailsIt=plcyDetailsSet.iterator();
					PolicyInsuranceMasterBean plcyRecord=null;
					BLPayerPolicyDetails policyFetch=new BLPayerPolicyDetails();
					HashMap paramMap=(HashMap)billing_data.get("payer_policy_access_specifier");
					
					while(plcyDetailsIt.hasNext())
					{
					String plcyDetailsKey=(String)plcyDetailsIt.next();
					plcyRecord=(PolicyInsuranceMasterBean)plcyDetails.get(plcyDetailsKey);
					
					StringTokenizer stTok=new StringTokenizer(plcyDetailsKey,"~");
					if(stTok.hasMoreTokens()){
						priority=stTok.nextToken();
						policy_no=stTok.nextToken();
					}
					
					returnMap=policyFetch.insertHeaderDetails(con,plcyRecord,paramMap);
					
					if(((Boolean) returnMap.get("status")).booleanValue()){
						returnMap=policyFetch.insertPolicyDetails(con,plcyRecord,paramMap);
					}
					else{
						insertable = false;
						con.rollback();
						break;
					}							
					
					if(((Boolean) returnMap.get("status")).booleanValue()){
						returnMap=policyFetch.insertPreApprovalDetails(con,plcyRecord,paramMap);
					}else{
						insertable = false;
						con.rollback();
						break;
					}
					}

					}
					catch(Exception e){
						System.err.println("Exception happened while inserting policy Definition details");
					}
				}
			/*Karthik added code ends here INCLUDE_POLICY_DETAILS_CRF */
			
			} // End of Try Block in Calculation of VisitCharge
			catch(Exception except)
			{
				insertable=false;
				sb.append("BLOPReviseVisit: Exception Error Text  "+except);
			}

			if(insertable && str_bill_prt_format_YN.equals("Y"))
			{
				try
				{
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						System.err.println("pgm_id BLOPReviseVisit.java :: "+pgm_id);
						session_id = st1.nextToken();
						System.err.println("session_id BLOPReviseVisit.java :: "+session_id);
						pgm_date = st1.nextToken();
						System.err.println("pgm_date BLOPReviseVisit.java :: "+pgm_date);
						mpi_id_rep = st1.nextToken();
						System.err.println("mpi_id_rep BLOPReviseVisit.java :: "+mpi_id_rep);
					}							
/*								
					OnlineReport onlinereportParam = new OnlineReport((String) tabdata.get("facility_id"), "BL", "BLRBLPRT");
					onlinereportParam.addParameter("p_facility_id",(String) tabdata.get("facility_id"));
					onlinereportParam.addParameter("p_pgm_date",pgm_date);
					onlinereportParam.addParameter("p_pgm_id",pgm_id);
					onlinereportParam.addParameter("p_Session_id",session_id);
					System.err.println("Online Report onlinereportParam:"+onlinereportParam);
					OnlineReports onlinereports = new OnlineReports();
					onlinereports.add(onlinereportParam);
					System.err.println("Online Report Added:"+onlinereports);
					String strResults =  onlinereports.execute((HttpServletRequest) billing_data.get("httpreq"), (HttpServletResponse) billing_data.get("httpres"));
					System.err.println("Online Report Executed");
					System.err.println("strResults:"+strResults);

					onlinereportParam = null;
					onlinereports = null;		
*/								
				}
				catch (Exception e)
				{
					insertable=false;
					System.err.println("Error while submitting Print Job to Report Server:"+e);
					sb.append("Mod. Exception while calling Print Report : "+e);
				}
			}
		}
		else
		{
			insertable = true;
		}
	
		if ( (strFinalMessage == null) ||  (strFinalMessage.equals("")) )
		{
			strFinalMessage =" ";
		}

		results.put( "status", new Boolean(insertable) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "message",strFinalMessage);
		results.put( "billgenlater",str_bill_gen_later) ;	
		results.put( "billtotalamt", str_total_bill_amt) ;
//		System.err.println("results from BLOPRevise Visit Bean:"+results);
		// results.put( "p_encounter_id", encounterid);
		results.put( "bill_prt_format_YN", str_bill_prt_format_YN);
		results.put( "pgm_id", pgm_id);
		results.put( "session_id", session_id);
		results.put( "pgm_date", pgm_date);
		results.put( "mpi_id_rep", mpi_id_rep);
		System.out.println("results BLOPReviseVisit.java :: "+results);

		return results ;
	}
    
	private PreparedStatement setData(PreparedStatement stmt,Object[] obj)
	{
        try
        {
			for(int i=0;i<obj.length;i++)
            {
				if(obj[i] instanceof java.sql.Date)
                {
					if (obj[i] instanceof java.sql.Date  )
                    stmt.setDate((i+1),(java.sql.Date)obj[i]);
                }

                if(obj[i] instanceof String)
                {
                    if(((String)obj[i]).equalsIgnoreCase("null"))
	                    stmt.setString((i+1),null);
                    else if((String)obj[i] == null)
						stmt.setString((i+1),null);
                    else
                        stmt.setString((i+1),(String)obj[i]);
                }

                if(obj[i] instanceof Integer)
                {
                    stmt.setInt((i+1),(((Integer)obj[i]).intValue()));
                }

				if(obj[i] instanceof Long)
                {
                    stmt.setLong((i+1),(  ((Long)obj[i]).longValue() ));
                }

                if(obj[i] instanceof Double)
                {
                    stmt.setDouble((i+1),( ((Double)obj[i]).doubleValue()) );
                }

                if(obj[i] instanceof Float)
                {
                    stmt.setFloat((i+1),(((Float)obj[i]).floatValue()));
                }
			}
		}
        catch(Exception e)
		{
			e.printStackTrace();
		}
        return(stmt);
	}
}
	
	
