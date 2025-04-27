<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,blpatreg.*, com.ehis.util.*,java.util.*,eBL.BLPatRegChargesBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	CallableStatement call = null;
	ResultSet rs				= null;	//ResultSet rscurr = null;	
	//CurrencyFormat cf = new CurrencyFormat();
	try
	{
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String bean_id = "BLPatRegChargesBean" ;
		String bean_name = "eBL.BLPatRegChargesBean";
		BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id, bean_name, request ) ;
		//int noofdecimal=2;		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	
		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		String step1 = request.getParameter("step1");
		if (step1==null) step1 = "";
		String blng_grp_id="",cust_group_code="", cust_code="", cur_acct_seq_no="",  non_ins_blng_grp_id="",  non_ins_cust_group_code="", non_ins_cust_code="",service_date="";
		String strPatSerCode="";String regn_charge_YN="N", regn_charge_dur_enc_YN="N",  strPatRegServPanelInd="", strPatRegServPanelCode="",  error_level="", sys_message_id="", error_text="",strPatRegServPanelStr="",strPatRegServChargeAmt="",strPatRegServPanelQty="1";
		String strPatientId="";
		strPatientId=request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
		String proc_success="";String charge_for_pat_regn_yn="Y";
		double pat_reg_chrg_amt=0;	double pat_reg_chrg_pat_amt=0;
		String bill_gen_yn="", bill_doc_type="", bill_doc_number="", str_bill_gen_later="", str_total_bill_amt="";String str_pat_reg_chrg_amt = "",str_pat_reg_chrg_pat_amt="";String slmt_ind="";String bl_charge_for_pat_regn_yn="";
		HashMap finDtls		= new HashMap();
		String  str_cust_group_code  ="",str_cust_code ="",priority ="",str_priority  ="",policy_number="", str_policy_number ="", policy_start_date="", str_policy_start_date ="",credit_auth_ref="", str_credit_auth_ref ="",credit_auth_date="", str_credit_auth_date="", effective_from ="",str_effective_from ="", effective_to ="", str_effective_to="", approved_amt ="",str_approved_amt="", approved_days ="", str_approved_days="", policy_type_code="",str_policy_type_code="",policy_expiry_date="",str_policy_expiry_date="",str_blng_grp_id="";
		//HashMap service_panel_Dtls		= new HashMap();
		String str_bill_later_YN="";
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;	

		String temp_blng_grp_id="",temp_cust_group_code="",temp_cust_code="";
%>
<html>
<head>
<%		
		String sStyle	= 	((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eBL/js/BLMPPatRegCharges.js'></script>	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type="text/javascript">

function delay(ms) { return new Promise(resolve => setTimeout(resolve, ms)); }

async function runWithDelay() {
	  console.log("Start");

	  // Pause for 3 seconds
	  await delay(3000);

	  console.log("After 3 seconds");
	}
</script>
<%
		String calling_module_id = request.getParameter("calling_module_id");
		if(calling_module_id == null) calling_module_id="";
		calling_module_id="MP";
			try
			{
				String query_service_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query_service_date) ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						service_date = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in Sys Date :"+e);
			}
		if(step1.equals("STEP_OTH")){
			bean.clearBean();	

			try
			{
				String query_service_date="SELECT NVL(CHARGE_FOR_PAT_REGN_YN,'N') FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID='"+facilityid+"'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query_service_date) ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						bl_charge_for_pat_regn_yn = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in Sys Date :"+e);
			}

			if(bl_charge_for_pat_regn_yn == null || bl_charge_for_pat_regn_yn.equals("")) bl_charge_for_pat_regn_yn="";
			if(bl_charge_for_pat_regn_yn.equals("N"))
			{
				
				out.println("<script> window.returnValue = 'Y'; window.close();  </script>");
				/* out.println("<script>let dialogBody = parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = 'Y'; 
				parent.document.getElementById('dialog_tag').close();</script>");
				 out.println("<script>" +
				    	    "let dialogBody = parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y';" +
				    	    "parent.parent.document.getElementById('dialog_tag').close();" +
				    	    "</script>");	
				out.println("<script> alert('line 114'); console.log(parent.window[1]); " +
			            "parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y'; " +  // Replace 'success' with the desired value
			            "parent.document.getElementById('dialog_tag').close(); " +
			            "</script>");*/
  	    
			}
			else{
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
						pstmt.close();
						if(rs!=null) rs.close();
					 }catch(Exception e)
						{
						System.err.println("Exception in  bl_patient_fin_dtls:"+e);
						}
			System.out.println("bl_charge_for_pat_regn_yn11223");*/
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
									
									blng_grp_id  =  rs.getString(14);
									if(blng_grp_id==null) blng_grp_id="";
									str_blng_grp_id = blng_grp_id;
									cust_group_code  =  rs.getString(1);
									if(cust_group_code==null) cust_group_code="";
									cust_code  =  rs.getString(2);
									if(cust_code==null) cust_code="";
									
								}

								non_ins_blng_grp_id  =  rs.getString(14);	
								if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";
								non_ins_cust_group_code  =  rs.getString(1);
								if(non_ins_cust_group_code==null) non_ins_cust_group_code="";
								non_ins_cust_code  =  rs.getString(2);
								if(non_ins_cust_code==null) non_ins_cust_code="";
								
							}else{
								temp_blng_grp_id  =  rs.getString(14);
								//blng_grp_id  = blng_grp_id +str_blng_grp_id +"|";
								if(temp_blng_grp_id ==null) temp_blng_grp_id ="";	
								str_blng_grp_id  = str_blng_grp_id +temp_blng_grp_id +"|";								
								if(priority.equals("1"))
								{
									blng_grp_id = rs.getString(14); 
									cust_group_code  =  rs.getString(1);
									cust_code  =  rs.getString(2);
								}
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
							
								non_ins_blng_grp_id  = "";				
								non_ins_cust_group_code  =  "";
								non_ins_cust_code  =  "";
								
						}
						pstmt.close();
						if(rs!=null) rs.close();			
			// }
			}catch(Exception e)
				{
				System.err.println("Exception in FIN  DET  QUERY :"+e);
				}
					finDtls.put("blng_grp_id",str_blng_grp_id);
					finDtls.put("str_cust_group_code",str_cust_group_code);
					finDtls.put("str_cust_code",str_cust_code);
					finDtls.put("str_policy_type_code",str_policy_type_code);
					finDtls.put("str_priority",str_priority);
					finDtls.put("str_policy_number",str_policy_number);
					finDtls.put("str_policy_start_date",str_policy_start_date);
					finDtls.put("str_policy_expiry_date",str_policy_expiry_date);
					finDtls.put("str_credit_auth_ref",str_credit_auth_ref);
					finDtls.put("str_credit_auth_date",str_credit_auth_date);
					finDtls.put("str_effective_from",str_effective_from);
					finDtls.put("str_effective_to",str_effective_to);
					finDtls.put("str_approved_amt",str_approved_amt);
					finDtls.put("str_approved_days",str_approved_days);
					finDtls.put("non_ins_blng_grp_id",non_ins_blng_grp_id);
					finDtls.put("non_ins_cust_group_code",non_ins_cust_group_code);
					finDtls.put("non_ins_cust_code",non_ins_cust_code);
					bean.setFinDtls(finDtls);
					HashMap finDtls_temp		= new HashMap();
					finDtls_temp = (HashMap)bean.getFinDtls();
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
					pstmt.close();
					if(rs!=null) rs.close();
				}catch(Exception e)
				{
					System.err.println("Exception in strPatSerCode"+e);
				}			

			try{	
				call = con.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				call.setString(1,facilityid);
				call.setString(2,strPatSerCode);//P_pat_ser_grp_code
				call.setString(3,blng_grp_id);
				call.setString(4,cust_group_code);
				call.setString(5,cust_code);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);
				call.registerOutParameter(10,java.sql.Types.VARCHAR);
				call.registerOutParameter(11,java.sql.Types.VARCHAR);
				call.registerOutParameter(12,java.sql.Types.VARCHAR);
				call.registerOutParameter(13,java.sql.Types.VARCHAR);
				call.registerOutParameter(14,java.sql.Types.VARCHAR);
				call.execute();
				regn_charge_YN = call.getString(6);
				System.out.println("regn_charge_YN "+regn_charge_YN);
				if(regn_charge_YN == null) regn_charge_YN="N";

				regn_charge_dur_enc_YN = call.getString(7);
				if(regn_charge_dur_enc_YN == null) regn_charge_dur_enc_YN="N";

				strPatRegServPanelInd=call.getString(8);
				if(strPatRegServPanelInd==null) strPatRegServPanelInd="";
				strPatRegServPanelCode=call.getString(9);
				if(strPatRegServPanelCode==null) strPatRegServPanelCode="";

				error_level=call.getString(10);
				sys_message_id=call.getString(11);
				error_text=call.getString(12);

				if (error_level == null) error_level ="";
				if (sys_message_id ==null) sys_message_id ="";
				if (error_text ==null) error_text ="";

				call.close();

		
				if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
				{
					//strValidatedState = "E";	
					proc_success="N";
					if ( !(sys_message_id.equals("")))
							{
								%>	<script>alert(getMessage('<%=sys_message_id%>','BL'));
								parent.document.getElementById('dialog-body').contentWindow.returnValue="N";
								parent.document.getElementById('dialog_tag').close();
									</script>
									<%
							}
				}else
				{
					//strValidatedState = "Y";
					proc_success="Y";
				}
			}catch(Exception e)
			{
				proc_success="N";
				System.err.println("Exception in Procedure GETPATREGNSERVDTL in BLPatRegChargeDetValidationFrame.jsp:"+e);
				e.printStackTrace();
			}
			if(regn_charge_dur_enc_YN.equals("N")){	
				
			out.println("<script> let dialogBody = parent.document.getElementById('dialog-body');dialogBody.contentWindow.returnValue = 'Y'; parent.document.getElementById('dialog_tag').close();</script>");
				
			/*	  out.println("<script>" +
				    	    "let dialogBody = parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y';" +
				    	    "parent.parent.document.getElementById('dialog_tag').close();" +
				    	    "</script>");	
				out.println("<script>" +
			            "let dialogBody = parent.parent.document.getElementById('dialog-body');" +
			            "dialogBody.contentWindow.returnValue = 'Y';" +  // Replace 'success' with the desired value
			            "const dialogTag = parent.parent.document.getElementById('dialog_tag');" +
			            "dialogTag.close();" +
			            "</script>");*/
  	    
				
				
			}else{
				String strEpisodeType="R";
				String strClinicCode="";
				String str_epi_type_clinic_code="";
				str_epi_type_clinic_code =strEpisodeType+"#"+strClinicCode;
		//		String 	str_ins_policy_type_code="",str_ins_cust_priority="", str_ins_policy_no ="",str_ins_policy_start_date="", str_ins_policy_expiry_date ="", str_ins_credit_auth_ref ="", str_ins_credit_auth_date ="",str_ins_policy_eff_from_date="", str_ins_policy_eff_to_date ="",str_ins_credit_approval_amount="", str_ins_credit_approval_days ="",str_non_ins_blng_grp="", str_non_ins_cust_group_code ="",str_non_ins_cust_code="",
					String strNull="";
				if(proc_success.equals("Y") && charge_for_pat_regn_yn.equals("Y"))
				{
					try{				
						call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

									call.setString(1,facilityid);//facility_id
									call.setString(2,"MP");	//module_id
									call.setString(3,strNull); //key
									call.setString(4,strNull); //key_line_no
									call.setString(5,"R");//Episode_type
									call.setString(6,strPatientId);//patient_id
									call.setString(7,strNull);//strEpisodeId
									call.setString(8,strNull);
									call.setString(9,strNull);
									call.setString(10,cur_acct_seq_no);
									call.setString(11,service_date);//service_date
									call.setString(12,strNull);//item_code
									call.setString(13,strPatRegServPanelInd);//service_panel_ind
									call.setString(14,strPatRegServPanelCode);//service_panel_code
									call.setDouble(15,1);//service_qty
									call.setString(16,strNull);//charge_based_amt
									call.setString(17,strNull);//pract_staff_ind
									call.setString(18,strNull);//pract_staff_id
									call.setString(25,strNull);//excl_incl_action_ind
									call.setString(26,strNull);//action_reason_code
									call.setString(30,locale);//locale
									call.registerOutParameter(19,java.sql.Types.VARCHAR);
									call.registerOutParameter(20,java.sql.Types.VARCHAR);
									call.registerOutParameter(21,java.sql.Types.VARCHAR);
									call.registerOutParameter(22,java.sql.Types.VARCHAR);
									call.registerOutParameter(23,java.sql.Types.VARCHAR);
									call.registerOutParameter(24,java.sql.Types.VARCHAR);
									call.registerOutParameter(27,java.sql.Types.VARCHAR);
									call.registerOutParameter(28,java.sql.Types.VARCHAR);
									call.registerOutParameter(29,java.sql.Types.VARCHAR);	
									call.registerOutParameter(31,java.sql.Types.VARCHAR);
									call.registerOutParameter(32,java.sql.Types.VARCHAR);
									call.registerOutParameter(33,java.sql.Types.VARCHAR);
									call.execute();	
					
									strPatRegServPanelStr=call.getString(19);	
			
									if(strPatRegServPanelStr==null) strPatRegServPanelStr="";
			
									error_level=call.getString(31);
									sys_message_id=call.getString(32);
									error_text=call.getString(33);
			
									if (error_level == null) error_level ="";
									if (sys_message_id ==null) sys_message_id ="";
									if (error_text ==null) error_text ="";
			
									if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
									{
										//strValidatedState = "E";	
										proc_success="N";
										if ( !(sys_message_id.equals("")))
										{
											%>	<script>alert(getMessage('<%=sys_message_id%>','BL'));
											parent.document.getElementById('dialog-body').contentWindow.returnValue="N";
											parent.document.getElementById('dialog_tag').close();
												</script>
											<%					
										}
									}else
									{
										//strValidatedState = "Y";
										proc_success="Y";
									}
						
						}catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception in Hospital:"+e);
						}
				}
			
				try{
					if(proc_success.equals("Y")){
						//String strPolicyTypeCode="", strPolicyPriority="",  strPolicyNumber="", strPolicyStartDate="", strPolicyExpiryDate="", strCreditAuthRef="", strCreditAuthDate="", strEffectiveFrom ="",strEffectiveTo ="",strApprovedAmt="", strApprovedDays="", strNonInsBlnggrpId ="",
							String strNonInsCustGroupCode="", strNonInsCustCode =""; // service_date  
						
						String sql="{call BLPatientRegnCharge.Main('C','"+function_id+"','"+facilityid+"','MP','"+strPatientId+"','"+strPatSerCode+"','R',to_date('"+service_date+"','dd/mm/yyyy HH24:MI'),'"+strNull+"','"+strNull+"','"+blng_grp_id+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_policy_type_code+"','"+str_priority+"','"+str_policy_number+"','"+str_policy_start_date+"','"+str_policy_expiry_date+"','"+str_credit_auth_ref+"','"+str_credit_auth_date+"','"+str_effective_from+"','"+str_effective_to+"','"+str_approved_amt+"','"+str_approved_days+"','"+non_ins_blng_grp_id+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','Y','"+strPatRegServPanelInd+"','"+strPatRegServPanelCode+"','"+strPatRegServPanelStr+"','"+strPatRegServPanelQty+"','"+strPatRegServChargeAmt+"','"+str_bill_later_YN+"','"+strloggeduser+"','"+strclientip+"','"+strclientip+"','"+strNull+"','"+strNull+"','"+locale+"',?,'"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
						call=con.prepareCall(sql);
						call.setString(1,"Y");
						call.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						call.registerOutParameter( 2, java.sql.Types.VARCHAR);
						call.registerOutParameter( 3, java.sql.Types.VARCHAR);
						call.registerOutParameter( 4, java.sql.Types.VARCHAR);
						call.registerOutParameter( 5, java.sql.Types.VARCHAR);
						call.registerOutParameter( 6, java.sql.Types.VARCHAR);
						call.registerOutParameter( 7, java.sql.Types.VARCHAR);
						call.registerOutParameter( 8, java.sql.Types.VARCHAR);
						call.registerOutParameter( 9, java.sql.Types.VARCHAR);
						call.registerOutParameter( 10, java.sql.Types.VARCHAR);
						call.registerOutParameter( 11, java.sql.Types.VARCHAR);				
						call.registerOutParameter( 12, java.sql.Types.VARCHAR);				
						call.registerOutParameter( 13, java.sql.Types.VARCHAR);				
						call.execute();				
						regn_charge_YN= call.getString(1);
						if(regn_charge_YN==null || regn_charge_YN.equals("")) regn_charge_YN="";
						pat_reg_chrg_amt= call.getDouble(2);
						pat_reg_chrg_pat_amt=call.getDouble(3);				
						bill_gen_yn=call.getString(4);
						if(bill_gen_yn==null) bill_gen_yn="";
						bill_doc_type=call.getString(5);
						if(bill_doc_type==null) bill_doc_type="";
						bill_doc_number=call.getString(6);
						if(bill_doc_number==null) bill_doc_number="";
						str_bill_gen_later=call.getString(7);
						if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="";
						str_total_bill_amt=call.getString(8);
						if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";


						error_level=call.getString(9);
						sys_message_id=call.getString(10);
						error_text=call.getString(11);
			
						call.close();
						
						if (error_level == null) error_level ="";
						if (sys_message_id ==null) sys_message_id ="";
						if (error_text ==null) error_text ="";


						//pat_reg_chrg_amt = cf.formatCurrency(pat_reg_chrg_amt, noofdecimal);
						//pat_reg_chrg_pat_amt = cf.formatCurrency(pat_reg_chrg_pat_amt, noofdecimal);
						if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
						{
							if ( !(sys_message_id.equals("")))
							{
								%>	<script>alert(getMessage('<%=sys_message_id%>','BL'));
										parent.document.getElementById('dialog-body').contentWindow.returnValue="N";
										parent.document.getElementById('dialog_tag').close();
									</script>
									<%				
							}
						//	strValidatedState = "E";	
						proc_success="N";
						}else
						{
							//strValidatedState = "Y";
						}
				 }
				}catch(Exception e)
				{
					proc_success="N";
					System.err.println("Exception in BLVisitCharge:"+e);
				}
				
		  
				 str_pat_reg_chrg_amt = Double.toString(pat_reg_chrg_amt);
				 str_pat_reg_chrg_pat_amt = Double.toString(pat_reg_chrg_pat_amt);

			//	bean.setTotPatPay(str_pat_reg_chrg_pat_amt);
			//	bean.setTotPay(str_pat_reg_chrg_pat_amt);
				bean.setPanelString(strPatRegServPanelStr);
			}
			if(regn_charge_YN.equals("Y"))
			{		
			}else{
				
				out.println("<script>  let dialogBody = parent.document.getElementById('dialog-body');dialogBody.contentWindow.returnValue = 'Y'; parent.document.getElementById('dialog_tag').close();</script>");
				//out.println("<script>close_det();</script>");
				
				//out.println("<script>let dialogBody = parent.document.getElementById('dialog-body');dialogBody.contentWindow.returnValue = 'Y'; parent.document.getElementById('dialog_tag').close();</script>");
				
			//	out.println("<script> parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'success';
				//	    parent.parent.document.getElementById('dialog_tag').close();</script>")
					    
					    
					    
				/*	    out.println("<script>" +
					    	    "let dialogBody =parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y';" +
					    	    "parent.parent.document.getElementById('dialog_tag').close();" +
					    	    "</script>");	
					    	    
				out.println("<script> alert('line 568')" +
			            "let dialogBody = parent.document.getElementById('dialog-body');" +
			            "dialogBody.contentWindow.returnValue = 'Y';" +  // Replace 'success' with the desired value
			            "const dialogTag = parent.document.getElementById('dialog_tag');" +
			            "dialogTag.close();" +
			            "</script>");	*/
   	    
					    	    
			}
	}//patient registration allowed check
} 	
%>
	<title><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></title>
	</head>
	<iframe  src="../../eBL/jsp/BLPatRegChargeDet.jsp?pat_reg_chrg_amt=<%=pat_reg_chrg_amt%>&pat_reg_chrg_pat_amt=<%=pat_reg_chrg_pat_amt%>&patient_id=<%=strPatientId%>&cur_acct_seq_no=<%=cur_acct_seq_no%>&serv_panel_ind=<%=strPatRegServPanelInd%>&serv_panel_code=<%=strPatRegServPanelCode%>&service_date=<%=service_date%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&patregnchargeYN=<%=regn_charge_YN%>&blng_grp_id=<%=blng_grp_id%>&function_id=<%=function_id%>" frameborder=0 noresize scrolling=no style='height:50vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
	

	
	
	<%putObjectInBean(bean_id,bean,request);%>
<%
}catch(Exception e )
		{ 
			System.err.println("exception PatRegValidation:"+e);
		}
		finally
		{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 
</html>

