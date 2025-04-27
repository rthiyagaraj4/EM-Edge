/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blpatreg;
import java.net.*;
import java.io.* ;
import java.sql.* ;

import javax.rmi.*;
import java.util.*;
import java.sql.* ;



import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;

public class BLMPRegCharges
{
    public java.util.Hashtable billPatientRegCharges(Connection con,HashMap tabdata)
	{
    CallableStatement statement = null;
	Hashtable results = new Hashtable();
	Hashtable messageHashtable=new Hashtable();
	StringBuffer sb = new StringBuffer();	
	PreparedStatement pstmt		= null ;

	Statement st=null;
	ResultSet rs  =null;ResultSet rs1  =null;

	String slmt_ind="", non_ins_blng_grp_id="", blng_grp_id="", non_ins_cust_group_code="", non_ins_cust_code="", cur_acct_seq_no="",strPatSerCode="",cust_group_code="",cust_code="",pat_reg_charge_YN="",locale="";
	//String strModuleId="MP";
	String calledfrmencYN="N";String str_charge_for_pat_regn_yn="N";
	//String bean_id_bl ="";	String bean_name_bl="";
//	HashMap finDtls		= new HashMap();
	String facility_id="",strPatientId="",strloggeduser="",strclientip="";
	String strPatRegServPanelInd="",strPatRegServPanelCode="",  strPatRegServPanelStr="", strPatRegServPanelQty="1", strPatRegServChargeAmt="";
	String strFinalMessage ="";	String bill_gen_yn="";	String bill_doc_type="";	String bill_doc_number="";
	String str_bill_later_YN="N";	String str_bill_gen_later="N";	String str_total_bill_amt="";String str_total_chrg_amt="";
	String str_total_pat_chrg_amt="";	
	double total_chrg_amt=0.0;	double total_pat_chrg_amt=0.0;	double pat_reg_chrg_amt=0;double pat_reg_chrg_pat_amt=0;
	String str_pat_reg_charged_YN = "N";		String function_id="";
	boolean insertable = true;		int noofdecimal=2;
	//String proc_success="N";
	String str_pat_reg_chrg_amt="";	String str_pat_reg_chrg_pat_amt="";
	String err_level = "";String sys_message_id = "";	String err_text = "";
	//String strPolicyTypeCode="", strPolicyPriority="",  strPolicyNumber="", strPolicyStartDate="", strPolicyExpiryDate="", strCreditAuthRef="", strCreditAuthDate="", strEffectiveFrom ="",strEffectiveTo ="",strApprovedAmt="", strApprovedDays="", strNonInsBlnggrpId ="" 
	String strNonInsCustGroupCode="", strNonInsCustCode ="";// service_date
	String strNull = "";	
	
	String  str_cust_group_code  ="",str_cust_code ="",priority ="",str_priority  ="",policy_number="", str_policy_number ="", policy_start_date="", str_policy_start_date ="",credit_auth_ref="", str_credit_auth_ref ="",credit_auth_date="", str_credit_auth_date="", effective_from ="",str_effective_from ="", effective_to ="", str_effective_to="", approved_amt ="",str_approved_amt="", approved_days ="", str_approved_days="", policy_type_code="",str_policy_type_code="",policy_expiry_date="",str_policy_expiry_date="",str_blng_grp_id="";
	String regn_charge_YN="",regn_charge_dur_enc_YN="",service_date="",call_frm="";
	String temp_blng_grp_id="",temp_cust_group_code="",temp_cust_code="";

	String str_bill_prt_format_YN = "N";
	String str_bill_prt_format_vals = "";
	String pgm_id ="";
	String session_id ="";
	String pgm_date ="";
	String mpi_id_rep = "";

	try
    {
//		System.err.println("********tabdata MLMPpregCharges********:"+tabdata);
		locale			= (String)tabdata.get("locale");
		if(locale==null) locale="";		
		calledfrmencYN="Y";//request.getParameter("patregnchargeYN");
		if(calledfrmencYN==null) calledfrmencYN="";
		facility_id = (String)tabdata.get("facility_id");			
		try
		{		
			String charge_for_pat_regn_yn="select  nvl(charge_for_pat_regn_yn,'N') from BL_PARAMETERS WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
			st = con.createStatement();
			rs1 = st.executeQuery(charge_for_pat_regn_yn) ;
			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					str_charge_for_pat_regn_yn  =  rs1.getString(1);	
				}
			}
			if(str_charge_for_pat_regn_yn == null) str_charge_for_pat_regn_yn="N";			
			st.close();
			if(rs1!=null) rs1.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in str_charge_for_pat_regn_yn Query="+e.toString());
		}
//		System.out.println("str_charge_for_pat_regn_yn webbeean"+str_charge_for_pat_regn_yn);
	if(str_charge_for_pat_regn_yn.equals("Y"))
	{
		strPatientId = (String)tabdata.get("patient_id");	
		strloggeduser = (String)tabdata.get("strloggeduser");	
		strclientip = (String)tabdata.get("strclientip");
		call_frm = (String)tabdata.get("callFromAE");
		if(!call_frm.equals("DR"))
		{		
			strPatRegServPanelInd = (String)tabdata.get("service_panel_ind");	
			strPatRegServPanelCode = (String)tabdata.get("service_panel_code");	
			strPatRegServPanelStr = (String)tabdata.get("panel_str_frm_bl");	
			strPatRegServChargeAmt = (String)tabdata.get("strPatRegServChargeAmt");	
			function_id = (String)tabdata.get("function_id");
			regn_charge_dur_enc_YN="Y";
		}		
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
		String pat_reg_chrg_leg = bl_labels.getString("eBL.PAT_REG_CHRG.label");
		String bill_gen_yn_leg = bl_labels.getString("eBL.PAT_REG_CHARGE_BILL_GEN.label");
		String patient_payable_leg = common_labels.getString("Common.PatientPayable.label");
		try
		{		
			String no_of_decimal="select nvl(no_of_decimal,2) from  sm_acc_entity_param";
			st = con.createStatement();
			rs = st.executeQuery(no_of_decimal) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					noofdecimal  =  rs.getInt(1);	
				}
			}
			st.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in No of Decimal Query="+e.toString());
		}

		try
		{		
			String bill_gen_later_YN_qry="select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+facility_id+"'";
			st = con.createStatement();
			rs = st.executeQuery(bill_gen_later_YN_qry) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					str_bill_later_YN  =  rs.getString(1);	
				}
			}
			if(str_bill_later_YN == null) str_bill_later_YN="N";			
			st.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of bill_gen_later_YN_qry Query="+e.toString());
		}

		/*try{
			String pat_fin_det_sql="select SETTLEMENT_IND,NON_INS_BLNG_GRP_ID,blng_grp_id, non_ins_cust_group_code, non_ins_cust_code,cur_acct_seq_no  from bl_patient_fin_dtls   where patient_id ='"+strPatientId+"'";
			pstmt = con.prepareStatement(pat_fin_det_sql);
			rs = pstmt.executeQuery();	
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					slmt_ind  =  rs.getString(1);
					non_ins_blng_grp_id  =  rs.getString(2);				
					blng_grp_id  =  rs.getString(3);
					non_ins_cust_group_code  =  rs.getString(4);
					non_ins_cust_code  =  rs.getString(5);
					cur_acct_seq_no  =  rs.getString(6);
					
				}
			}
			if(blng_grp_id == null) blng_grp_id="";
			if(slmt_ind == null) slmt_ind="";
			if(non_ins_blng_grp_id == null) non_ins_blng_grp_id="";
			if(non_ins_cust_code == null) non_ins_cust_code="";
			if(non_ins_cust_group_code == null) non_ins_cust_group_code="";			
			pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e)
		{
		System.err.println("Exception in  bl_patient_fin_dtls:"+e);
		}
*/
		try{
					int i=0;
		//if(slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
		//{
			String pat_fin_det_sql="select CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE,PRIORITY,POLICY_NUMBER,to_char(POLICY_START_DATE,'dd/mm/yyyy'),to_char(POLICY_EXPIRY_DATE,'dd/mm/yyyy'),CREDIT_AUTH_REF,to_char(CREDIT_AUTH_DATE,'dd/mm/yyyy'),to_char(EFFECTIVE_FROM,'dd/mm/yyyy'),to_char(EFFECTIVE_TO,'dd/mm/yyyy'),APPROVED_AMT,APPROVED_DAYS,BLNG_GRP_ID from BL_ENCOUNTER_PAYER_PRIORITY   where patient_id ='"+strPatientId+"' and EPISODE_TYPE='R' AND ACCT_SEQ_NO=1 ORDER BY PRIORITY";
					pstmt = con.prepareStatement(pat_fin_det_sql);
					rs = pstmt.executeQuery();	
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							priority   =  rs.getString(4);
							if(priority==null) priority="";
							if(priority.equals(""))
							{
								if(i==0)
								{
//									System.out.println("priority 11"+priority);
									blng_grp_id  =  rs.getString(14);
									if(blng_grp_id==null) blng_grp_id="";
									cust_group_code  =  rs.getString(1);
									if(cust_group_code==null) cust_group_code="";
									cust_code  =  rs.getString(2);
									if(cust_code==null) cust_code="";
//									System.out.println("cust_code 11 "+cust_code);
								}

								non_ins_blng_grp_id  =  rs.getString(14);	
								if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";
								non_ins_cust_group_code  =  rs.getString(1);
								if(non_ins_cust_group_code==null) non_ins_cust_group_code="";
								non_ins_cust_code  =  rs.getString(2);
								if(non_ins_cust_code==null) non_ins_cust_code="";

//								System.out.println("non_ins_blng_grp_id 11 "+non_ins_blng_grp_id);
//								System.out.println("non_ins_cust_group_code 11 "+non_ins_cust_group_code);
//								System.out.println("non_ins_cust_code 11 "+non_ins_cust_code);
							}else{
								if(priority.equals("1"))
								{
									blng_grp_id = rs.getString(14); 
									cust_group_code  =  rs.getString(1);
									cust_code  =  rs.getString(2);
								}
								temp_blng_grp_id  =  rs.getString(14);
								//blng_grp_id  = blng_grp_id +str_blng_grp_id +"|";
								if(temp_blng_grp_id ==null) temp_blng_grp_id ="";	
								str_blng_grp_id  = str_blng_grp_id +temp_blng_grp_id +"|";
//								System.out.println("str_blng_grp_id 12 "+str_blng_grp_id);

								temp_cust_group_code  =  rs.getString(1);					
								str_cust_group_code = str_cust_group_code+temp_cust_group_code+"|";
								if(str_cust_group_code==null) str_cust_group_code="";	
								
								temp_cust_code  =  rs.getString(2);
								str_cust_code = str_cust_code+temp_cust_code+"|";
								if(str_cust_code==null) str_cust_code="";

								policy_type_code  =  rs.getString(3);
								str_policy_type_code = str_policy_type_code+policy_type_code+"|";
								if(str_policy_type_code==null) str_policy_type_code="";

								priority   =  rs.getString(4);
								str_priority = str_priority+priority+"|";
								if(str_priority==null) str_priority="";

								policy_number  =  rs.getString(5);
								str_policy_number = str_policy_number+policy_number+"|";
								if(str_policy_number==null) str_policy_number="";

								policy_start_date  =  rs.getString(6);
								str_policy_start_date = str_policy_start_date+policy_start_date+"|";
								if(str_policy_start_date==null) str_policy_start_date="";

								policy_expiry_date  =  rs.getString(7);
								str_policy_expiry_date = str_policy_expiry_date+policy_expiry_date+"|";
								if(str_policy_expiry_date==null) str_policy_expiry_date="";

								credit_auth_ref  =  rs.getString(8);
								str_credit_auth_ref = str_credit_auth_ref+credit_auth_ref+"|";
								if(str_credit_auth_ref==null) str_credit_auth_ref="";

								credit_auth_date  =  rs.getString(9);
								str_credit_auth_date = str_credit_auth_date+credit_auth_date+"|";
								if(str_credit_auth_date==null) str_credit_auth_date="";

								effective_from  =  rs.getString(10);
								str_effective_from = str_effective_from+effective_from+"|";
								if(str_effective_from==null) str_effective_from="";

								effective_to  =  rs.getString(11);
								str_effective_to = str_effective_to+effective_to+"|";
								if(str_effective_to==null) str_effective_to="";

								approved_amt  =  rs.getString(12);
								str_approved_amt = str_approved_amt+approved_amt+"|";
								if(str_approved_amt==null) str_approved_amt="";

								approved_days  =  rs.getString(13);
								str_approved_days = str_approved_days+approved_days+"|";
								if(str_approved_days==null) str_approved_days="";				
								}
							i++;
						  }
						}		
						if(i==1)
						{
//							System.out.println("i 122 "+i);
								non_ins_blng_grp_id  = "";				
								non_ins_cust_group_code  =  "";
								non_ins_cust_code  =  "";
//								System.out.println("non_ins_blng_grp_id 122 "+non_ins_blng_grp_id);
						}
				pstmt.close();
				if(rs!=null) rs.close();			
	 //}
	}catch(Exception e)
		{
		System.err.println("Exception in FIN  DET  QUERY :"+e);
		}
		try{
			String strPatSerCode_qry="select PAT_SER_GRP_CODE from  mp_patient where PATIENT_ID='"+strPatientId+"'";		
			pstmt = con.prepareStatement(strPatSerCode_qry);
			rs = pstmt.executeQuery();	
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					strPatSerCode  =  rs.getString(1);	
				}
			}
			if(strPatSerCode == null) strPatSerCode="N";
//			System.err.println("strPatSerCode qury:"+strPatSerCode);
			pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e)
		{
			System.err.println("Exception in strPatSerCode"+e);
		}	

		if(call_frm.equals("DR"))
		{	
				function_id="VISIT_REGISTRATION";
			try
			{
				String query_service_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
				st = con.createStatement();
				rs = st.executeQuery(query_service_date) ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						service_date = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				st.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in Sys Date :"+e);
			}

			try{					
				statement = con.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?)}");
				statement.setString(1,facility_id);
				statement.setString(2,strPatSerCode);//P_pat_ser_grp_code
				statement.setString(3,blng_grp_id);
				statement.setString(4,cust_group_code);
				statement.setString(5,cust_code);
				statement.registerOutParameter(6,java.sql.Types.VARCHAR);
				statement.registerOutParameter(7,java.sql.Types.VARCHAR);
				statement.registerOutParameter(8,java.sql.Types.VARCHAR);
				statement.registerOutParameter(9,java.sql.Types.VARCHAR);
				statement.registerOutParameter(10,java.sql.Types.VARCHAR);
				statement.registerOutParameter(11,java.sql.Types.VARCHAR);
				statement.registerOutParameter(12,java.sql.Types.VARCHAR);
				statement.execute();
				insertable = true;
				regn_charge_YN = statement.getString(6);
				if(regn_charge_YN == null) regn_charge_YN="N";

				regn_charge_dur_enc_YN = statement.getString(7);
				if(regn_charge_dur_enc_YN == null) regn_charge_dur_enc_YN="N";

				strPatRegServPanelInd=statement.getString(8);
				if(strPatRegServPanelInd==null) strPatRegServPanelInd="";
				strPatRegServPanelCode=statement.getString(9);
				if(strPatRegServPanelCode==null) strPatRegServPanelCode="";

				err_level=statement.getString(10);
				sys_message_id=statement.getString(11);
				err_text=statement.getString(12);

				if (err_level == null) err_level ="";
				if (sys_message_id ==null) sys_message_id ="";
				if (err_text ==null) err_text ="";

				statement.close();						
				if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
						{
							insertable=false;

							if((err_level.equals("10") && !err_text.equals("") ))
							{
								sb.append("<br>"+err_text+"<br> ") ;
							}
							else
							{
								messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
							statement.close();
						}
					}catch(Exception e)
					{
						insertable = false;
						sb.append("Exception while calling procedure BLPatientRegnCharge.Main : "+e);
						System.err.println("Exception in Patient Registration Charges Insertion::"+e);
					}
				if(insertable)
				{
					if(regn_charge_dur_enc_YN.equals("Y"))
					{
						try{			
	

							String sql_get_serv_panel_dtls="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+facility_id+"','MP','R','"+strPatientId+"','"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"',sysdate,'"+strPatRegServPanelInd+"','"+strPatRegServPanelCode+"',1,'P','"+strNull+"','"+blng_grp_id+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_policy_type_code+"','"+str_priority+"','"+str_policy_number+"','"+str_policy_start_date+"','"+str_policy_expiry_date+"','"+str_credit_auth_ref+"','"+str_credit_auth_date+"','"+str_effective_from+"','"+str_effective_to+"','"+str_approved_amt+"','"+str_approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,'"+strNull+"','"+strNull+"',?,'"+locale+"',?,?,?)}";
							
							CallableStatement call=con.prepareCall(sql_get_serv_panel_dtls);

							call.registerOutParameter(1,java.sql.Types.VARCHAR);
							call.registerOutParameter(2,java.sql.Types.VARCHAR);
							call.registerOutParameter(3,java.sql.Types.DOUBLE);
							call.registerOutParameter(4,java.sql.Types.DOUBLE);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.DOUBLE);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);	
							call.registerOutParameter(10,java.sql.Types.VARCHAR);

							call.execute();	
							insertable = true;
							strPatRegServPanelStr=call.getString(1);	
//							System.err.println("Charge bases YN in Registration AE:"+(String)call.getString(2));		
//							System.err.println("Total Amount in Registration AE:"+(String)call.getString(3));
//							System.err.println("Patient Payable Amount in Registration AE:"+(String)call.getString(4));
	
//							System.err.println("strHospServPanelStr: " + strHospServPanelStr);	
							if(strPatRegServPanelStr==null) strPatRegServPanelStr="";
	
							err_level=call.getString(8);
							sys_message_id=call.getString(9);
							err_text=call.getString(10);
	
							if (err_level == null) err_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (err_text ==null) err_text ="";
	
//							System.err.println("error_level for Registration panel AE:"+err_level);
//							System.err.println("sys_message_id for Registration_panel AE:"+sys_message_id);
//							System.err.println("error_text for Registration_panel AE:"+err_text);	
							if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
							{
								insertable=false;

								if((err_level.equals("10") && !err_text.equals("") ))
								{
									sb.append("<br>"+err_text+"<br> ") ;
								}
								else
								{
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									sb.append((String)messageHashtable.get("message"));
								}
								statement.close();
							}
						}catch(Exception e)
						{
							insertable = false;
							sb.append("Exception while calling procedure BLPatientRegnCharge.Main : "+e);
							System.err.println("Exception in Patient Registration Charges Insertion::"+e);
						}
					}
				}

		}
		if(regn_charge_dur_enc_YN.equals("Y"))
		{
		if(insertable)
		{
			try
			{
				String sql_pat_reg="{call BLPatientRegnCharge.Main('I','"+function_id+"','"+facility_id+"','MP','"+strPatientId+"','"+strPatSerCode+"','R',sysdate,'"+strNull+"','"+strNull+"','"+str_blng_grp_id+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_policy_type_code+"','"+str_priority+"','"+str_policy_number+"','"+str_policy_start_date+"','"+str_policy_expiry_date+"','"+str_credit_auth_ref+"','"+str_credit_auth_date+"','"+str_effective_from+"','"+str_effective_to+"','"+str_approved_amt+"','"+str_approved_days+"','"+non_ins_blng_grp_id+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','Y','"+strPatRegServPanelInd+"','"+strPatRegServPanelCode+"','"+strPatRegServPanelStr+"','"+strPatRegServPanelQty+"','"+strPatRegServChargeAmt+"','"+str_bill_later_YN+"','"+strloggeduser+"','"+strclientip+"','"+strclientip+"','"+strNull+"','"+strNull+"','"+locale+"',?,'"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
//				System.err.println("sql_pat_reg new:"+sql_pat_reg);
				statement = con.prepareCall(sql_pat_reg);
			
				statement.setString(1,"Y");

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
			
				statement.execute();

				insertable = true;

				pat_reg_charge_YN= statement.getString(1);
				if(pat_reg_charge_YN==null || pat_reg_charge_YN.equals("")) pat_reg_charge_YN="N";

				str_pat_reg_chrg_amt= statement.getString(2);
				if(str_pat_reg_chrg_amt==null || str_pat_reg_chrg_amt.equals("")) str_pat_reg_chrg_amt="0.0";
				pat_reg_chrg_amt= Double.parseDouble(str_pat_reg_chrg_amt);

				str_pat_reg_chrg_pat_amt=statement.getString(3);
				if(str_pat_reg_chrg_pat_amt==null || str_pat_reg_chrg_pat_amt.equals("")) str_pat_reg_chrg_pat_amt="0.0";
				pat_reg_chrg_pat_amt=Double.parseDouble(str_pat_reg_chrg_pat_amt);
				
				bill_gen_yn=statement.getString(4);
				if(bill_gen_yn==null) bill_gen_yn="N";
				bill_doc_type=statement.getString(5);
				if(bill_doc_type==null) bill_doc_type="";
				bill_doc_number=statement.getString(6);
				if(bill_doc_number==null) bill_doc_number="";
				str_bill_gen_later=statement.getString(7);
				if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="N";
				str_total_bill_amt=statement.getString(8);
				if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

				str_bill_prt_format_YN=statement.getString(9);
				if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

				str_bill_prt_format_vals=statement.getString(10);
				if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
			
				err_level=statement.getString(11);
				sys_message_id=statement.getString(12);
				err_text=statement.getString(13);

				if(err_level==null) err_level="";
				if(sys_message_id==null) sys_message_id="";
				if(err_text==null) err_text="";

				total_chrg_amt=pat_reg_chrg_amt;
				total_pat_chrg_amt=pat_reg_chrg_pat_amt;

				str_total_chrg_amt=String.valueOf(total_chrg_amt);
				str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);

				if(total_chrg_amt > 0)
					str_pat_reg_charged_YN = "Y";
				else
					str_pat_reg_charged_YN = "N";

				try
				{
					CurrencyFormat cf1 = new CurrencyFormat();

					if (str_pat_reg_chrg_amt!=null)
						str_pat_reg_chrg_amt = cf1.formatCurrency(str_pat_reg_chrg_amt, noofdecimal);
				
					if(str_total_chrg_amt!=null)
						str_total_chrg_amt = cf1.formatCurrency(str_total_chrg_amt, noofdecimal);

					if(str_total_pat_chrg_amt!=null)
						str_total_pat_chrg_amt = cf1.formatCurrency(str_total_pat_chrg_amt, noofdecimal);

					if(str_pat_reg_chrg_pat_amt!=null)
						str_pat_reg_chrg_pat_amt=cf1.formatCurrency(str_pat_reg_chrg_pat_amt, noofdecimal);

				}
				catch(Exception e)
				{
					System.err.println("Currency exception ::"+e);
				}
/*
				System.err.println("str_pat_reg_chrg_amt:"+str_pat_reg_chrg_amt);
				System.err.println("pat_reg_chrg_amt:"+pat_reg_chrg_amt);
				System.err.println("str_pat_reg_chrg_pat_amt:"+str_pat_reg_chrg_pat_amt);
				System.err.println("pat_reg_chrg_pat_amt:"+pat_reg_chrg_pat_amt);
				System.err.println("pat_reg_charge_YN:"+pat_reg_charge_YN);
				System.err.println("bill_gen_yn:"+bill_gen_yn);
				System.err.println("bill_doc_type:"+bill_doc_type);
				System.err.println("bill_doc_number:"+bill_doc_number);
				System.err.println("str_bill_gen_later:"+str_bill_gen_later);
				System.err.println("str_total_bill_amt:"+str_total_bill_amt);
				System.err.println("err_level:"+err_level);
				System.err.println("err_text:"+err_text);
				System.err.println("sys_message_id:"+sys_message_id);
*/
				if(bill_gen_yn.equals("Y") && (bill_doc_type.equals("") && bill_doc_number.equals("0")))
				{
					bill_gen_yn="N";
				}
										   
				if(pat_reg_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
				{
					if(pat_reg_chrg_amt>=0)
					{
						strFinalMessage=pat_reg_chrg_leg+" "+str_pat_reg_chrg_amt+" "+patient_payable_leg+" "+str_pat_reg_chrg_pat_amt;
					}
				}

				if(bill_gen_yn.equals("Y") && str_bill_gen_later.equals("N"))
				{
					bill_gen_yn_leg = bill_gen_yn_leg.replaceAll("#",(bill_doc_type+"/"+bill_doc_number));
					bill_gen_yn_leg = bill_gen_yn_leg.replaceAll("%",str_total_chrg_amt);
					bill_gen_yn_leg = bill_gen_yn_leg.replaceAll("&",str_total_pat_chrg_amt);

					strFinalMessage=bill_gen_yn_leg;
				}
//					strFinalMessage=strFinalMessage+"<BR>";
				
//				System.err.println("strFinalMessage:"+strFinalMessage);

				if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
				{
					insertable=false;

					if((err_level.equals("10") && !err_text.equals("") ))
					{
						sb.append("<br>"+err_text+"<br> ") ;
					}
					else
					{
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
					}
					statement.close();
				}

				if(insertable && str_bill_prt_format_YN.equals("Y"))
				{
					try
					{
						StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

						while(st1.hasMoreTokens())
						{

							if(st1.hasMoreTokens())			pgm_id = st1.nextToken();
							System.err.println("pgm_id:"+pgm_id);
							if(st1.hasMoreTokens())		
							session_id = st1.nextToken();
							System.err.println("session_id:"+session_id);
							if(st1.hasMoreTokens())		
							pgm_date = st1.nextToken();
							System.err.println("pgm_date:"+pgm_date);
							if(st1.hasMoreTokens())		
							mpi_id_rep = st1.nextToken();
							System.err.println("mpi_id_rep:"+mpi_id_rep);
						}							
					}
					catch (Exception e)
					{
						insertable=false;
						System.err.println("Error while submitting Print Job to Report Server:"+e);
						sb.append("Mod. Exception while calling Print Report : "+e);
					}
				}
			}
			catch(Exception e)
			{
				insertable = false;
				sb.append("Exception while calling procedure BLPatientRegnCharge.Main : "+e);
				System.err.println("Exception in Patient Registration Charges Insertion::"+e);
			}
			}
			if(insertable)
			{
				try
				{
					String upd_stmt="update BL_PATIENT_FIN_DTLS set REGN_CHARGING_STAGE='E', CUR_REGN_FEE_CHARGED_YN ='Y', CUR_REGN_SERV_PANEL_IND='"+strPatRegServPanelInd+"',CUR_REGN_SERV_PANEL_CODE='"+strPatRegServPanelCode+"' where patient_id =	'"+strPatientId+"'";
//					System.err.println("upd_stmt BL_PATIENT_FIN_DTLS: "+upd_stmt);
					pstmt = con.prepareStatement(upd_stmt);
					int res_upd = pstmt.executeUpdate();
//				System.err.println("update BL_PATIENT_FIN_DTLS: "+res_upd);
					if (res_upd != 0)
						insertable = true;
					else
						insertable = false;

					if (pstmt != null)
						pstmt.close();


				}catch(Exception ee)
				{
					insertable=false;
					sb.append("Exception while updating BL_PATIENT_FIN_DTLS : "+ee);
					System.err.println("Exception in update BL_PATIENT_FIN_DTLS:"+ee.toString());
				}
			}
	}//end regn_charge_dur_enc_YN
	}//end str_charge_for_pat_regn_yn
	}catch(Exception ebl1)
	{  
		try
		{
			if (statement != null)
			{
				statement.close();
			}
		}
		catch(Exception exc)
		{
		}
		insertable=false;
		sb.append("Exception while calling procedure BL :"+ebl1);  
//		System.err.println("Exception in Procedure:"+ebl1);
	}
	results.put("transaction_completed",new Boolean(insertable));
	if(insertable)
	{
		results.put("success_message",strFinalMessage);
//		sb.append(strFinalMessage);
	}
	results.put("error",sb.toString());
	results.put( "billgenlater",str_bill_gen_later) ;	
	results.put( "billdoctype",bill_doc_type) ;
	results.put( "billdocnum", bill_doc_number) ;
	results.put( "billtotalamt", str_total_bill_amt) ;
	results.put( "bill_prt_format_YN", str_bill_prt_format_YN);
	results.put( "pgm_id", pgm_id);
	results.put( "session_id", session_id);
	results.put( "pgm_date", pgm_date);
	results.put( "mpi_id_rep", mpi_id_rep);
	System.err.println("results:"+results);
    return results ;
}
}	
	
