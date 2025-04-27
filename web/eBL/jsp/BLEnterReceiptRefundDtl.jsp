
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Version     	Developer Name		Rev.Date		Rev.Name			SCF/CRF
-------------------------------------------------------------------------------------------------------------------------------------
03/12/2020 	  	V201203	         Ram kumar S									  KDAH-SCF-0685-TF - 9726
17/08/2022      V220816          Manivel N/Namrata/Manivel                            TH-KW-CRF-0156
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>

<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	ResultSet rscurr = null; //ResultSet rs1 = null;		
	CurrencyFormat cf = new CurrencyFormat();
	try
	{
		String chiefcomplaint =  request.getParameter("chiefcomplaint")==null?"":request.getParameter("chiefcomplaint");
		String nursing_unit_code = request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");
		String customer_id=(String)session.getValue("CUSTOMER_ID");
		String chiefComplaintDesc = request.getParameter("chiefComplaintDesc")==null?"":request.getParameter("chiefComplaintDesc");
		con	=	ConnectionManager.getConnection(request);
		Boolean SiteSpec_PkgDep=false;
		String SiteSpecific_PkgDep ="";
		
		SiteSpec_PkgDep = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_DEP_ADJ_APPL_YN");
		
		if(SiteSpec_PkgDep){
			SiteSpecific_PkgDep="Y";
		}
		else{			
			SiteSpecific_PkgDep="N";			
		}
		
		//Added by Manivel for TH-KW-CRF-0156
		boolean dfltRcptTypeForDeposit = false;
		boolean isDfltPkgRcptTypeSetup = false;
		try 
		{
			dfltRcptTypeForDeposit = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENBL_DFLT_RCPT_TYPE_FOR_NATURE");
		} catch(Exception ex) {
			System.err.println("Error in BLEnterReceiptRefundDtl.jsp for getting dfltRcptTypeForDeposit Connection: "+ex);
			ex.printStackTrace();
		}		
		
		String strDownTimeAllowDays="";
		
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String remarks_desc="";
		if((customer_id!=null && customer_id.equals("KDAH"))&&(!chiefcomplaint.equals(""))){
			remarks_desc = chiefComplaintDesc;
		}

		int noofdecimal=2;
		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";		

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	

		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	

/************ADDED FOR PACKAGE BILLING **********************/
		String function_id =  request.getParameter("function_id");	
		if(function_id==null) function_id="";	
		String funct_mode =  request.getParameter("funct_mode");	
		if(funct_mode==null) funct_mode="";	
		String str_bl_package_enabled_yn="N";

		String pkgCode = request.getParameter("pkgCode");// MMS-CRF-0023 moved here	
		if(pkgCode==null) pkgCode="";
		String packseqno = request.getParameter("packseqno");	
		//String packseqno = request.getParameter("packseqno");	
		if(packseqno==null) packseqno="";	

		String pkgAmount = request.getParameter("pkgAmount");	
//		String pkgAmount = request.getParameter("pkg_amt");	
		System.err.println("93-->"+pkgAmount);
		if(pkgAmount==null) pkgAmount="";

		String tot_package_amt = request.getParameter("tot_package_amt");		
		String modeOfCall = request.getParameter("modeOfCall");
		if(modeOfCall == null)	modeOfCall="";
		
		String blng_class = request.getParameter("blng_class");
		if(blng_class == null)	blng_class="";
		
		//Added for MMS-DM-SCF-0013
		String ignoreMandValidationDtl = "N";
		String derivedFromCust = "";
		String derivedFromBase = "";
		String depositReqYn = "";
		String derivedFromDtl = "N";
		double totMinDepositDtl = 0.00;
		// Added for SCF 501.1
		String pkgSeqAmtForSub = "";
		PartialDepositMasterBean refBean = new PartialDepositMasterBean();
		System.err.println("Inside pkgAmount"+pkgAmount);
		System.err.println("Inside tot_package_amt"+ tot_package_amt);
		if(tot_package_amt==null) tot_package_amt="";
		double tot_min_dep_amt=0.00;double d_tot_package_amt=0.00;
		String rec_found_flag="N";String doc_amt="";
		String str_deposit_man_yn = "",	str_partial_dep_yn	= "",	str_min_dep_amt	= "",str_err_level= "",	str_sys_message_id= "",	str_error_text= "";	
		//if(!funct_mode.equals("") && funct_mode.equals("VISIT_REGISTRATION")){
		String bean_id		= "PkgSubsBean" ;
		String bean_name	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;	
		HashMap  patPackSubsDetails=bean.getPatientPackSubsDtls();	

		//String doc_amt="";
		String bean_id1		= "PkgEnterReceptRefundBean" ;
		String bean_name1	= "eBL.PkgEnterReceptRefundBean";
		PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		//PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		//bean1.clearBean();
		//putObjectInBean(bean_id1,bean1,request);
		
		/*Karthik added the below code for Partial Deposit - Starts MMS-CRF-0023*/
		/*Karthik moved the code below the code to calculate Total package amount for subscription cases IN050265  */
		String par_dep_bean_id		= "PartialDepositMasterBean" ;
		String par_dep_bean_name	= "eBL.PartialDepositMasterBean";
		PartialDepositMasterBean par_dep_bean			= (PartialDepositMasterBean)getBeanObject( par_dep_bean_id, par_dep_bean_name, request ) ;
		StringTokenizer stTokpkgCode=new StringTokenizer(pkgCode,"^");  
		StringTokenizer stTokSeqNo=new StringTokenizer(packseqno,"^"); 
		StringTokenizer stBlngClass = new StringTokenizer(blng_class,"^");
			
	if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{
 		 if(episode_type.equals("I") ||episode_type.equals("R")){
			String chargeLogic=	par_dep_bean.getChargeLogic(facilityid);	
				if(chargeLogic.equals("Y")){
			
					double partialDepositAmount=0.00;	
					double partDepAmtTemp = 0.00;
					double minDepAmount = 0.00;
					double minDepAmtTemp = 0.00;
					CallableStatement callMinDep = null;

					int checkTotalPackageCount=stTokpkgCode.countTokens();
					//For Multi Package subscription cases
					if(checkTotalPackageCount>1){
		
						while(stTokpkgCode.hasMoreTokens()){
							String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
							String packseqnoNoDelimiter=stTokSeqNo.nextToken();
							String blng_class_token = "";
							
							HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
							if(parDepMap != null){
								blng_class_token = parDepMap.get("blngClassCode");
							}
							boolean validPartialDepositCase=	par_dep_bean.checkValidPartialDepositCase(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, blng_class_token, con);
							System.err.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
							//If the Case is a Valid PartialDeposit Case Add PartialDeposit otherwise add Deposit Amount to it
							//Note the Package Amount is not considered here
							if(validPartialDepositCase){
								partDepAmtTemp = par_dep_bean.getPartialDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								partialDepositAmount+=partDepAmtTemp;
								minDepAmtTemp = par_dep_bean.getMinimumDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								minDepAmount+=minDepAmtTemp;
							}else{
								HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
								String blngClassCode = hashMapCode.get("blngClassCode");
								String custGrpCode = hashMapCode.get("custGrpCode");
								String custCode = hashMapCode.get("custCode");								
								partDepAmtTemp = par_dep_bean.GetPackagePrice(facilityid, pkgCodeNoDelimiter,blngClassCode, custGrpCode,  custCode, con);
								partialDepositAmount+=partDepAmtTemp;
								
								//Mn Dep Amt
								callMinDep = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
								callMinDep.setString(1,facilityid);				
								callMinDep.setString(2,packseqnoNoDelimiter);				
								callMinDep.setString(3,pkgCodeNoDelimiter);				
								callMinDep.setDouble(4,partDepAmtTemp);											
								callMinDep.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
								callMinDep.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
								callMinDep.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
								callMinDep.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
								callMinDep.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
								callMinDep.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
								callMinDep.execute();				
								str_deposit_man_yn	 = callMinDep.getString(5);
								str_partial_dep_yn	 = callMinDep.getString(6);
								str_min_dep_amt		 = callMinDep.getString(7);		
								str_err_level		 = callMinDep.getString(8);		
								str_sys_message_id	 = callMinDep.getString(9);		
								str_error_text		 = callMinDep.getString(10);		
								callMinDep.close();	
								if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
								if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
								if ( str_min_dep_amt == null ) str_min_dep_amt = "";
								if ( str_err_level == null ) str_err_level = "";
								if ( str_sys_message_id == null ) str_sys_message_id = "";
								if ( str_error_text == null ) str_error_text = "";	
								
								minDepAmount+= Float.parseFloat(str_min_dep_amt);
								//Min Dep Amt
							}
						}
					}else{//For Single Package Subscription Cases
						while(stTokpkgCode.hasMoreTokens()){
							String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
							String packseqnoNoDelimiter=stTokSeqNo.nextToken();
							String blng_class_token = "";
							
							HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
							if(parDepMap != null){
								blng_class_token = parDepMap.get("blngClassCode");
							}
							
							boolean validPartialDepositCase=	par_dep_bean.checkValidPartialDepositCase(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, blng_class_token, con);
							System.err.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
							//If the Case is a Valid PartialDeposit Case Add PartialDeposit otherwise add Deposit Amount to it
							if(validPartialDepositCase){
								if(pkgAmount.equals("")){
									partDepAmtTemp=	par_dep_bean.getPartialDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
									minDepAmtTemp = par_dep_bean.getMinimumDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								}else{						//Note the Package Amount is  considered here
									StringTokenizer stTokPkgAmount=new StringTokenizer(pkgAmount,"^"); 
									String pkgAmountNoDelimiter=stTokPkgAmount.nextToken();
									System.err.println(pkgCodeNoDelimiter +"|"+packseqnoNoDelimiter +"|"+pkgAmountNoDelimiter );
									HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
									String blngClassCode = hashMapCode.get("blngClassCode");
									int encounterSequenceNo= 	par_dep_bean.getEncounterSequenceNo(patient_id,packseqnoNoDelimiter, con);
									partDepAmtTemp=		par_dep_bean.calculatePartialDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
									minDepAmtTemp = par_dep_bean.calculateMinimumDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
								}
								partialDepositAmount+=partDepAmtTemp;
								minDepAmount+=minDepAmtTemp;
								System.err.println("245-->"+minDepAmtTemp);
							}else{
								HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
								String blngClassCode = hashMapCode.get("blngClassCode");
								String custGrpCode = hashMapCode.get("custGrpCode");
								String custCode = hashMapCode.get("custCode");								
								partDepAmtTemp = par_dep_bean.GetPackagePrice(facilityid, pkgCodeNoDelimiter,blngClassCode, custGrpCode,  custCode, con);
								partialDepositAmount+=partDepAmtTemp;
								//Mn Dep Amt
								callMinDep = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
								callMinDep.setString(1,facilityid);				
								callMinDep.setString(2,packseqnoNoDelimiter);				
								callMinDep.setString(3,pkgCodeNoDelimiter);				
								callMinDep.setDouble(4,partDepAmtTemp);											
								callMinDep.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
								callMinDep.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
								callMinDep.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
								callMinDep.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
								callMinDep.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
								callMinDep.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
								callMinDep.execute();				
								str_deposit_man_yn	 = callMinDep.getString(5);
								str_partial_dep_yn	 = callMinDep.getString(6);
								str_min_dep_amt		 = callMinDep.getString(7);		
								str_err_level		 = callMinDep.getString(8);		
								str_sys_message_id	 = callMinDep.getString(9);		
								str_error_text		 = callMinDep.getString(10);		
								callMinDep.close();	
								if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
								if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
								if ( str_min_dep_amt == null ) str_min_dep_amt = "";
								if ( str_err_level == null ) str_err_level = "";
								if ( str_sys_message_id == null ) str_sys_message_id = "";
								if ( str_error_text == null ) str_error_text = "";	
								
								minDepAmount+= Float.parseFloat(str_min_dep_amt);
								//Min Dep Amt
							}
						}						
					}
					
		
					pkgAmount=partialDepositAmount+"^";
					//System.err.println("288-->"+pkgAmount);
					tot_package_amt=partialDepositAmount+"^";
					d_tot_package_amt = partialDepositAmount;
					tot_min_dep_amt = minDepAmount;
					
					System.err.println("BLEnterReceiptRefundDtl.jsp partialDepositAmount:"+ partialDepositAmount);
					}

		}  
		}
		/*Karthik added the below code for Partial Deposit - ends MMS-CRF-0023*/
		
		HashMap  support_data = bean1.getSupportData();		
		HashMap  mult_slmt_vals = bean1.getMultSlmtVals();	
		//System.err.println("support_data: "+support_data);
		if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{			
		 if(support_data!=null && support_data.size()>0)
		 {			
			doc_amt = (String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="0";	
			//System.err.println("doc_amt 123:"+doc_amt);
			d_tot_package_amt=Double.parseDouble(doc_amt);							  
			rec_found_flag="Y";
			//String min_dep_amt = bean1.getMinDepAmt();	
			//tot_min_dep_amt = Double.parseDouble(min_dep_amt);							  							
			HashMap  db_values = bean1.getDBValues(patPackSubsDetails,patient_id,facilityid);				
			str_err_level		=(String)db_values.get("str_err_level");
			if(str_err_level==null) str_err_level="";	
			str_sys_message_id	=(String)db_values.get("str_sys_message_id");
			if(str_sys_message_id==null) str_sys_message_id="";	
			str_error_text		=(String)db_values.get("str_error_text");
			if(str_error_text==null) str_error_text="";				
			if ((str_err_level.equals("10") && (!str_error_text.equals(""))) ||!str_sys_message_id.equals(""))
			{
				if ( !(str_sys_message_id.equals("")))
				{	
	%>				<script>alert(getMessage('<%=str_sys_message_id%>','BL'));
				//window.close();
				</script>
	<%				}
				if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
				{	
	%>				<script>alert('<%=str_error_text%>');
				//window.parent.returnValue="Y";
				//window.close();
				</script>
	<%			}	
			}else{
				String s_tot_min_dep_amt="";
				s_tot_min_dep_amt=(String)db_values.get("str_tot_min_dep_amt");
				if(s_tot_min_dep_amt==null) s_tot_min_dep_amt="0";
				tot_min_dep_amt = Double.parseDouble(s_tot_min_dep_amt);	

				String s_tot_package_amt="";
				s_tot_package_amt=(String)db_values.get("str_tot_package_amt");
														
				if(s_tot_package_amt==null) s_tot_package_amt="0";	
				d_tot_package_amt = Double.parseDouble(s_tot_package_amt);	
			}

		}
		}else{
			bean1.clearBean();
			putObjectInBean(bean_id1,bean1,request);
		}
//	}
		/*bean1.clearBean();
		putObjectInBean(bean_id1,bean1,request);*/
	
//		String pkgCode = request.getParameter("pkg_code");	

//		String str_deposit_man_yn = "",	str_partial_dep_yn	= "",	str_min_dep_amt	= "",str_err_level = "",	str_sys_message_id = "",		    str_error_text = "";	
		String sel_list="";
		//double tot_min_dep_amt=0.00;double d_tot_package_amt=0.00;
		String rcpt_type_long_desc="",rcpt_type_code="";
		String blng_class_code	="",blng_class_desc="";
		String payerGrpCode="",payerGrpDesc="",payerCode="",payerDesc="",pkg_codes_for_disc="",ppkgprice="";
		
/************ENDS**********************************************/
		String rcpt_ip_allowed_yn="",rcpt_op_allowed_yn="", rcpt_ref_allowed_yn="",rfnd_ip_allowed_yn="", rfnd_op_allowed_yn="", rfnd_ref_allowed_yn="",sys_message_id ="", error_text="",cash_counter_code="",shift_id="",rfnd_allowed_yn="",rcpt_allowed_yn="",strDownTimeRcptDocType = "",		   strDownTimeRfndDocType="", strRecptNaturedesc="",  strRecptNatureCode="",ext_acc_int_YN="",tot_adm_dep_amt="",tot_trf_dep_amt="", 	tot_othr_dep_amt="",tot_adm_dep_paid_amt="",collect_dep_amt_in_adv_yn="";
		String reln_code="";
		
		
		System.err.println("370");
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
			
</head>
<%

	try{
		/*********************ADDED FOR PACKAGE BILLING***************************/		
		try{				
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facilityid+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					str_bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(str_bl_package_enabled_yn == null) str_bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();			
			}catch(Exception e){
				System.err.println("Exception from QRY bl_package_enabled_yn:"+e);
				e.printStackTrace();
			}
			String pkg_seq_token="",pkg_code_token="",pkg_amt_token="";
		
		if(str_bl_package_enabled_yn.equals("Y") && function_id.equals("PKG_BILLING"))
		{			
			try{		
				String query_kk = "SELECT RECEIPT_TYPE_CODE,LONG_DESC FROM BL_RECEIPT_TYPE_lang_vw WHERE RECEIPT_TYPE_CODE IN (SELECT pat_dep_for_pkg FROM bl_parameters WHERE operating_facility_id='"+facilityid+"') AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') AND acc_entity_code= (SELECT ACC_ENTITY_CODE FROM sy_Acc_entity WHERE ACC_ENTITY_ID='"+facilityid+"')";
				PreparedStatement pstmt2=con.prepareStatement(query_kk);	
				ResultSet rs3 = pstmt2.executeQuery();	
				while(rs3.next())
					{			
						rcpt_type_code  =  rs3.getString(1);	
						rcpt_type_long_desc  =  rs3.getString(2);	
						isDfltPkgRcptTypeSetup = true;
					}
					
				if(rcpt_type_code == null) rcpt_type_code="";			
				if(rcpt_type_long_desc == null) rcpt_type_long_desc="";			
				pstmt2.close();
				if(rs3!=null) rs3.close();			
				}catch(Exception e){
					System.err.println("Exception in receipt type simple:"+e);
					e.printStackTrace();
				}
		if(rec_found_flag.equals("N")){
		if(!funct_mode.equals("") && funct_mode.equals("VISIT_REGISTRATION"))
		{
			/*String bean_id		= "PkgSubsBean" ;
			String bean_name	= "eBL.PkgSubsBean";
			PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;	
			HashMap  patPackSubsDetails=bean.getPatientPackSubsDtls();	*/		
		  if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
			{
				ArrayList	pkgDtls		=	new ArrayList();
				ArrayList	pkgCodes		=	new ArrayList();
				ArrayList	pkgFrmDate		=	new ArrayList();
				ArrayList	pkgToDate		=	new ArrayList();
				ArrayList	pkgAmt		=	new ArrayList();
				ArrayList	blng_class_code_list	=	new ArrayList();
				ArrayList	blng_class_desc_list	=	new ArrayList();	
				ArrayList	payerGrpCode_list	=	new ArrayList();
				ArrayList	payerGrpDesc_list	=	new ArrayList();
				ArrayList	payerCode_list	=	new ArrayList();
				ArrayList	payerDesc_list	=	new ArrayList();
					String packageCode="",fromDate="",toDate="",packAmt="N";
				//packEnId="",strEMYN="N",strIPYN="N",strDCYN="N" 
				//String str_error_level="",str_sysmesage_id="",str_error_text="";
				
		if(patPackSubsDetails.containsKey(patient_id))
		{
			pkgDtls					=(ArrayList)patPackSubsDetails.get(patient_id);		
			if(pkgDtls.size()>0)
			{
				pkgCodes = (ArrayList)pkgDtls.get(0);
				pkgFrmDate = (ArrayList)pkgDtls.get(2);
				pkgToDate = (ArrayList)pkgDtls.get(3);
				pkgAmt = (ArrayList)pkgDtls.get(4);
				blng_class_code_list = (ArrayList)pkgDtls.get(5);
				blng_class_desc_list = (ArrayList)pkgDtls.get(6);			
				payerGrpCode_list=(ArrayList)pkgDtls.get(7);
				payerGrpDesc_list=(ArrayList)pkgDtls.get(8);
				payerCode_list=(ArrayList)pkgDtls.get(9);
				payerDesc_list=(ArrayList)pkgDtls.get(10);			
			}
			int totRec = 0;
			if(pkgCodes.size() >0)
			totRec = pkgCodes.size();		
		for(int i=0;i<totRec;i++)
		{	
			packageCode	=(String)pkgCodes.get(i);
			//Added for MMS-DM-SCF-0013
			try{
				packageCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
			}
			catch(Exception pkgEx){
				
			}
			//Added for MMS-DM-SCF-0013
			pkg_codes_for_disc = packageCode+"|"+pkg_codes_for_disc;
			fromDate	=(String)pkgFrmDate.get(i);
			toDate	=(String)pkgToDate.get(i);
			packAmt	=(String)pkgAmt.get(i);	
			if(packAmt==null || "".equals(packAmt)) packAmt="0"; 
			d_tot_package_amt=d_tot_package_amt+Double.parseDouble(packAmt);
			blng_class_code	=(String)blng_class_code_list.get(i);
			blng_class_desc	=(String)blng_class_desc_list.get(i);
			payerGrpCode	=(String)payerGrpCode_list.get(i);	
			payerGrpDesc	=(String)payerGrpDesc_list.get(i);		
			payerCode	=(String)payerCode_list.get(i);
			payerDesc	=(String)payerDesc_list.get(i);	

			CallableStatement call12 = con.prepareCall("{ call  blpackage.getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
			call12.setString(1,facilityid);				
			call12.setString(2,packageCode);				
			call12.setString(3,blng_class_code);				
			call12.setString(4,payerGrpCode);	
			call12.setString(5,payerCode);	
			call12.registerOutParameter(6,java.sql.Types.VARCHAR); // p_min_dep_amt      		
			call12.registerOutParameter(7,java.sql.Types.VARCHAR); //p_err_level 			
			call12.registerOutParameter(8,java.sql.Types.VARCHAR); // p_sys_message_id			
			call12.registerOutParameter(9,java.sql.Types.VARCHAR); // p_error_text			
			call12.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text	
		
			call12.execute();				
			ppkgprice	 = call12.getString(6);
			str_min_dep_amt	 = call12.getString(7);	
			str_err_level		 = call12.getString(8);		
			str_sys_message_id	 = call12.getString(9);		
			str_error_text		 = call12.getString(10);			
			call12.close();	

			//Added for MMS-DM-SCF-0013
			if(!"".equals(payerGrpCode) && !"".equals(payerCode)){
				derivedFromDtl = "Y";
				call12 = null;
				call12 = con.prepareCall("{ call  blpackage.getpackagepricedtls(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Added V201203 New parameters
				call12.setString(1,facilityid);
				call12.setString(2,packageCode);
				if(blng_class_code.equals(""))
					call12.setString(3,null);
				else
					call12.setString(3,blng_class_code);
				call12.setString(4,payerGrpCode);
				call12.setString(5,payerCode);
				call12.registerOutParameter(6,java.sql.Types.VARCHAR);
				call12.registerOutParameter(7,java.sql.Types.VARCHAR);
				call12.registerOutParameter(8,java.sql.Types.VARCHAR);
				call12.registerOutParameter(9,java.sql.Types.VARCHAR);
				call12.registerOutParameter(10,java.sql.Types.VARCHAR);
				call12.registerOutParameter(11,java.sql.Types.VARCHAR);
				call12.registerOutParameter(12,java.sql.Types.VARCHAR);
				call12.registerOutParameter(13,java.sql.Types.VARCHAR);
				
				call12.registerOutParameter(14,java.sql.Types.DATE);
				call12.registerOutParameter(15,java.sql.Types.VARCHAR);
				call12.registerOutParameter(16,java.sql.Types.VARCHAR);
				call12.registerOutParameter(17,java.sql.Types.VARCHAR);
				call12.registerOutParameter(18,java.sql.Types.VARCHAR);
				call12.registerOutParameter(19,java.sql.Types.VARCHAR);
				call12.registerOutParameter(20,java.sql.Types.VARCHAR);
				call12.registerOutParameter(21,java.sql.Types.VARCHAR);
				call12.registerOutParameter(22,java.sql.Types.VARCHAR);
				call12.registerOutParameter(23,java.sql.Types.VARCHAR);
				call12.registerOutParameter(24,java.sql.Types.VARCHAR);
				call12.registerOutParameter(25,java.sql.Types.VARCHAR);
				call12.registerOutParameter(26,java.sql.Types.VARCHAR);
				call12.registerOutParameter(27,java.sql.Types.VARCHAR);
				call12.registerOutParameter(28,java.sql.Types.VARCHAR);
				call12.registerOutParameter(29,java.sql.Types.VARCHAR);
				//Starts V201203
				call12.registerOutParameter(30,java.sql.Types.VARCHAR);
				call12.setString(31,episode_type);
				//Ends V201203
				call12.execute();	

				derivedFromCust = call12.getString(9);
				derivedFromBase = call12.getString(10);
				depositReqYn = call12.getString(21);
				
				if("Y".equals(derivedFromCust)){
					/*
					Code Flow comes here when the given customer definition is
					available in the Package
					*/
					if(!"Y".equals(depositReqYn)){
						ignoreMandValidationDtl = "Y";
					}
				}
				else{
					/*
					Code Flow comes here when the given customer definition is
					unavailable and derived from cash
					*/
					ignoreMandValidationDtl = "Y";
					
					if ( str_min_dep_amt == null ){
						str_min_dep_amt = "";
					}
					
					if("".equals(str_min_dep_amt)){
						str_min_dep_amt = "0.0";
					}
					
					totMinDepositDtl = totMinDepositDtl + Double.parseDouble(str_min_dep_amt);
				}
				
			}
			//Added for MMS-DM-SCF-0013
			
			if ( ppkgprice == null ) ppkgprice = "";
			if ( str_min_dep_amt == null ) str_min_dep_amt = "0.0";
			if ( str_err_level == null ) str_err_level = "";
			if ( str_sys_message_id == null ) str_sys_message_id = "";
			if ( str_error_text == null ) str_error_text = "";	
			if ( !(str_sys_message_id.equals("")))
			{	
%>				<script>alert(getMessage('<%=str_sys_message_id%>','BL'));
					//window.close();
					</script>
<%			}
			if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
			{	
%>				<script>alert('<%=str_error_text%>');
					//window.parent.returnValue="Y";
					//window.close();
					</script>
<%			}			
			tot_min_dep_amt =tot_min_dep_amt + Double.parseDouble(str_min_dep_amt);
		}
	}
	}else{
		bean1.clearBean();
		putObjectInBean(bean_id1,bean1,request);
%>		<script>window.parent.returnValue="Y";
		window.close();</script>
<%		}
		}else{
			CallableStatement call1 = null;
			StringTokenizer st_seqno; 
			StringTokenizer st_pkgcode; 
			StringTokenizer st_pkgamt; 
			StringTokenizer st_blng_class;
			sel_list="SELECTED";
			st_pkgcode=new StringTokenizer(pkgCode,"^");
			st_seqno=new StringTokenizer(packseqno,"^");
			st_pkgamt=new StringTokenizer(pkgAmount,"^");
			//System.err.println("630-->"+st_pkgamt);
			st_blng_class = new StringTokenizer(blng_class,"^");
			if("Associate".equals(modeOfCall)){
				if(st_pkgamt.hasMoreTokens()){
					pkg_amt_token = st_pkgamt.nextToken();
					System.err.println("635-->"+pkg_amt_token);					
					d_tot_package_amt = d_tot_package_amt+Double.parseDouble(pkg_amt_token);
					System.err.println("637-->"+d_tot_package_amt);
					float minDepAmtReq = 0;
					try{
						minDepAmtReq = Float.parseFloat(request.getParameter("minDepAmtReq"));
					}
					catch(Exception eMin){
						minDepAmtReq = 0;
					}
					tot_min_dep_amt = minDepAmtReq;
					//System.err.println("646-->"+tot_min_dep_amt);
				}			
			}
			else {//  Karthik commented the code to calculate Total package amount for subscription cases IN050265 ("Subscription".equals(modeOfCall) || "".equals(modeOfCall))
				boolean isPartDeposit = false;
				while(st_pkgcode.hasMoreTokens()){
					pkg_code_token = st_pkgcode.nextToken();
					pkg_seq_token = st_seqno.nextToken();	
					pkg_amt_token = st_pkgamt.nextToken();	
					//blng_class = st_blng_class.nextToken();
					
					/* Karthik commented the code to calculate Total package amount for subscription cases IN050265- starts */
					String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
					String packseqnoNoDelimiter=stTokSeqNo.nextToken();
					HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
					if(parDepMap != null){
						blng_class = parDepMap.get("blngClassCode");
					}
					/* Karthik commented the code to calculate Total package amount for subscription cases IN050265- Ends */
					
					isPartDeposit = refBean.checkValidPartialDepositCase(facilityid, patient_id, pkg_code_token, pkg_seq_token, blng_class, con);
					if(isPartDeposit){						
						pkg_amt_token = String.valueOf(refBean.getPartialDepositAmount(facilityid, patient_id, pkg_code_token, pkg_seq_token,con));
						pkgSeqAmtForSub += "^"+pkg_amt_token;
						d_tot_package_amt=d_tot_package_amt+Double.parseDouble(pkg_amt_token);
						str_min_dep_amt = String.valueOf(refBean.getMinimumDepositAmount(facilityid, patient_id, pkg_code_token, pkg_seq_token,con));
					}
					else{
						d_tot_package_amt=d_tot_package_amt+Double.parseDouble(pkg_amt_token);
						call1 = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
						call1.setString(1,facilityid);				
						call1.setString(2,pkg_seq_token);				
						call1.setString(3,pkg_code_token);				
						call1.setString(4,pkg_amt_token);											
						call1.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
						call1.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
						call1.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
						call1.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
						call1.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
						call1.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
						call1.execute();				
						str_deposit_man_yn	 = call1.getString(5);
						str_partial_dep_yn	 = call1.getString(6);
						str_min_dep_amt		 = call1.getString(7);		
						str_err_level		 = call1.getString(8);		
						str_sys_message_id	 = call1.getString(9);		
						str_error_text		 = call1.getString(10);		
						call1.close();	
						if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
						if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
						if ( str_min_dep_amt == null ) str_min_dep_amt = "";
						if ( str_err_level == null ) str_err_level = "";
						if ( str_sys_message_id == null ) str_sys_message_id = "";
						if ( str_error_text == null ) str_error_text = "";		
						if ( !(str_sys_message_id.equals("")))
						{	
							%><script>alert(getMessage('<%=str_sys_message_id%>','BL'));
							</script>
						<%}
						if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
						{	
							%><script>alert('<%=str_error_text%>');
							</script>
						<%}
					}
					tot_min_dep_amt =tot_min_dep_amt + Double.parseDouble(str_min_dep_amt);
				}
			}
			
			
			}
			//bean1.setMinDepAmt(str_min_dep_amt);
			//putObjectInBean(bean_id1,bean1,request);
		}//rec_found_flag
	}
	/************************ENDS PACKAGE BILLING******************************/

		String query_date=" select COLLECT_DEP_DURING_ADM_YN from bl_ip_nursing_unit_type where NURSING_UNIT_TYPE_CODE = (Select nursing_unit_type_code from ip_nursing_unit where nursing_unit_code='"+nursing_unit_code+"' and facility_id='"+facilityid+"') ";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 collect_dep_amt_in_adv_yn = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
		
	
	}catch(Exception ee)
	{
		System.err.println("Error from collect deposit"+ee);
		ee.printStackTrace();

	}

	try{
		double factor =  Math.pow(10, 2);
		d_tot_package_amt = Math.round(d_tot_package_amt * factor)/factor;
		tot_min_dep_amt = Math.round(tot_min_dep_amt * factor)/factor;
	}
	catch(Exception ex){
		
	}
	%>
		<script>
		var v_collect='<%=collect_dep_amt_in_adv_yn%>'
		if(v_collect=="N")
		{
		
			window.close();
		}
		</script>
	<%
		try{
			String sqlQ=" select nvl(DOWNTIME_ENTRIES_ALLOW_DAYS,0)  from bl_parameters where operating_facility_id = '"+facilityid+"'";
			pstmt = con.prepareStatement(sqlQ);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strDownTimeAllowDays  =  rs.getString(1);							
				}	
				rs.close();
				pstmt.close();
		
	
				CallableStatement call = 
				con.prepareCall(
				"{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
				call.setString(1,facilityid);				
				call.setString(2,episode_type);				
				call.setString(3,strloggeduser);				
				call.setString(4,strclientip);				
				call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
				
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
				
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
				
				call.execute();				

				cash_counter_code	 = call.getString(5);
				shift_id		 = call.getString(6);
				sys_message_id	 = call.getString(7);		
				call.close();	
				if ( cash_counter_code == null ) cash_counter_code = "";
				if ( shift_id == null ) shift_id = "";
				if ( sys_message_id == null ) sys_message_id = "";		

				if ( !(sys_message_id.equals("")))
				{	
%>				<script>alert(getMessage('<%=sys_message_id%>','BL'));
				window.close();
				</script>
<%				}

		

			String sqlRcptRfnd="{ call blcommon.get_receipt_refund_check('"+facilityid+"','"+cash_counter_code+"',?,?,?,?,?,?,?,?)}";
			call = con.prepareCall(sqlRcptRfnd);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.execute();
			rcpt_ip_allowed_yn=call.getString(1);
			rcpt_op_allowed_yn=call.getString(2);
			rcpt_ref_allowed_yn=call.getString(3);
			rfnd_ip_allowed_yn=call.getString(4);
			rfnd_op_allowed_yn=call.getString(5);
			rfnd_ref_allowed_yn=call.getString(6);
			sys_message_id=call.getString(7);
			error_text=call.getString(8);
			
			if(rcpt_ip_allowed_yn==null) rcpt_ip_allowed_yn="";
			if(rcpt_op_allowed_yn==null) rcpt_op_allowed_yn="";
			if(rcpt_ref_allowed_yn==null) rcpt_ref_allowed_yn="";
			if(rfnd_ip_allowed_yn==null) rfnd_ip_allowed_yn="";
			if(rfnd_op_allowed_yn==null) rfnd_op_allowed_yn="";
			if(rfnd_ref_allowed_yn==null) rfnd_ref_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";
			call.close();
			String sqlChkRfnd="{ call blcommon.check_for_refund('"+strloggeduser+"','"+facilityid+"','"+cash_counter_code+"',?,?,?)}";
			call = con.prepareCall(sqlChkRfnd);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);			
			call.execute();
		 
			rfnd_allowed_yn = call.getString(1);
			sys_message_id = call.getString(2);
			error_text = call.getString(3);
			
			if(rfnd_allowed_yn==null) rfnd_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";

			call.close();
			if ( !(sys_message_id.equals("")) || !(error_text.equals("")) )
				{	
%>				<script>alert(getMessage('<%=sys_message_id%>','BL'));
				//window.close();
				</script>
<%				}


			String sqlChkRcpt="{ call blcommon.check_for_receipt('"+strloggeduser+"','"+facilityid+"','"+cash_counter_code+"',?,?,?)}";
			call = con.prepareCall(sqlChkRcpt);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);			
			call.execute();
		 
			rcpt_allowed_yn = call.getString(1);
			sys_message_id = call.getString(2);
			error_text = call.getString(3);
			
			if(rcpt_allowed_yn==null) rcpt_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";

			call.close();
			if ( !(sys_message_id.equals("")) || !(error_text.equals("")) )
				{	
%>				<script>alert(getMessage('<%=sys_message_id%>','BL'));
				//window.close();
				</script>
<%				}

			String sqlD="select DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE  from   BL_PARAMETERS  where  OPERATING_FACILITY_ID = '"+facilityid+"' ";
			pstmt = con.prepareStatement(sqlD);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strDownTimeRcptDocType =  rs.getString(1);							
				   strDownTimeRfndDocType =  rs.getString(2);							
				}	

				if(strDownTimeRcptDocType==null) strDownTimeRcptDocType="";
				if(strDownTimeRfndDocType==null) strDownTimeRfndDocType="";


				rs.close();
				pstmt.close();	
				
	/*************************added for package billing***************************/
			String sqlN="";
			if(function_id.equals("PKG_BILLING"))
			{
				if("Y".equals(SiteSpecific_PkgDep)){
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='AD' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
				}
				else{
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='PK' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
				}
				 
			}else{
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='AD' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
			}		
			pstmt = con.prepareStatement(sqlN);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strRecptNaturedesc=  rs.getString(1);							
				   strRecptNatureCode =  rs.getString(2);							
				}	
				if(strRecptNaturedesc==null) strRecptNaturedesc="";
				if(strRecptNatureCode==null) strRecptNatureCode="";


				rs.close();
				pstmt.close();	
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{	noofdecimal  =  rscurr.getInt(1);}	
		if(rscurr != null) rscurr.close();
		pstmt.close();
	//	pkgAmount=cf.formatCurrency(pkgAmount, noofdecimal);
		pstmt = con.prepareStatement( "SELECT  NVL(EXT_ACCOUNT_INTERFACE_YN,'N') FROM BL_PARAMETERS  WHERE OPERATING_FACILITY_ID='"+facilityid+"' ");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	ext_acc_int_YN  =  rs.getString(1);}	
		if(rs != null) rs.close();
		pstmt.close();

		pstmt = con.prepareStatement( "SELECT NVL(TOT_ADM_DEP_AMT,0)-NVL(TOT_ADM_DEP_PAID_AMT,0) tot_adm_dep_amt,NVL(TOT_TRF_DEP_AMT,0)-NVL(TOT_TRF_DEP_PAID_AMT,0) tot_trf_dep_amt ,NVL(TOT_OTH_DEP_AMT,0)-NVL(TOT_OTH_DEP_PAID_AMT,0) tot_othr_dep_amt,NVL(TOT_ADM_DEP_PAID_AMT,0) FROM   BL_EPISODE_FIN_DTLS WHERE operating_facility_id = '"+facilityid+"' and EPISODE_TYPE in ('D','I')   AND    EPISODE_ID   = '"+episode_id+"' ");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	
			tot_adm_dep_amt  =  rs.getString(1);			
			tot_trf_dep_amt  =  rs.getString(2);
			tot_othr_dep_amt  =  rs.getString(3);			
			tot_adm_dep_paid_amt  =  rs.getString(4);
		}	

				if(tot_adm_dep_amt==null) tot_adm_dep_amt="";
				if(tot_trf_dep_amt==null) tot_trf_dep_amt="";
				if(tot_othr_dep_amt==null) tot_othr_dep_amt="";
				if(tot_adm_dep_paid_amt==null) tot_adm_dep_paid_amt="";

				tot_adm_dep_amt=cf.formatCurrency(tot_adm_dep_amt, noofdecimal);
		if(rs != null) rs.close();
		pstmt.close();

		pstmt = con.prepareStatement( "select blcommon.get_reln_code('"+patient_id+"') from dual");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	
			reln_code  =  rs.getString(1);			
		}	
		if(rs != null) rs.close();
		pstmt.close();

		if(reln_code==null) reln_code="";

		}catch(Exception e)
		{
			System.err.println("str days error="+e.toString());
			e.printStackTrace();
		}

		

%>

<script>

	<!-- Modified by NamrataCharate on 16-08-22 for TH-KW-CRF-0156 -->
	
	// Added by Manivel for TH-KW-CRF-0156
	function fnClearNatureCode(obj) {
		obj.value = '';
		document.forms[0].receipt_code.value = '';
		document.forms[0].receipt_type.value ='';
	}
	
	function fnClearTypeCode(obj) {
		obj.value = '';
	}

	async function callCommonLookupCode(obj, code, sqlSelect, codeDesc, commonCode) {
		var formObj = document.EnterReceiptRefundForm;
		var locale = formObj.locale.value;
		var facility_id = formObj.facility_id.value
		var rcptNatcode = formObj.receipt_nature_code.value;
		var recTypCode= formObj.receipt_type.value;
		var patient_id = formObj.patient_id.value;
		
		
		var acc_entity_code = 'ZZ';
		var recpt_refund_ind = formObj.recpt_refund_ind.value;

		var rcpt_ip_allowed_yn = formObj.rcpt_ip_allowed_yn.value;

		var rcpt_op_allowed_yn = formObj.rcpt_op_allowed_yn.value;

		var rcpt_ref_allowed_yn = formObj.rcpt_ref_allowed_yn.value;

		var rfnd_ip_allowed_yn = formObj.rfnd_ip_allowed_yn.value;

		var rfnd_op_allowed_yn = formObj.rfnd_op_allowed_yn.value;

		var rfnd_ref_allowed_yn = formObj.rfnd_ref_allowed_yn.value;

		var rfnd_allowed_yn = formObj.rfnd_allowed_yn.value;

		var rcpt_allowed_yn = formObj.rcpt_allowed_yn.value;

		
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		var sql = '';
		var title = '';
		var codeval = '';

		switch (sqlSelect) {
			
		
		case 1: {
			
			sql = " Select code,description from (SELECT   DISTINCT receipt_type_code code,  long_desc description FROM bl_receipt_type_lang_vw WHERE receipt_type_code = NVL (NULL, receipt_type_code) AND language_id = ('"
					+ locale
					+ "') AND acc_entity_code IN ( SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = ('"
					+ facility_id
					+ "')) AND receipt_type_code IN ( SELECT receipt_type_code FROM bl_receipt_type_lang_vw  WHERE recpt_nature_code = ('"
					+ rcptNatcode
					+ "') AND language_id = ('"
					+ locale
					+ "') AND NVL	 (status, 'X') != 'S')) where upper(code) like upper(?)  and upper(description) like upper(?) order by 2 ";
			title = 'Receipt Type';
			break;
		}
		
		case 5: {
		
			sql = "select code,description  from (SELECT recpt_nature_code code ,long_desc description "
					+ "FROM bl_receipt_nature_lang_vw WHERE recpt_nature_code IN "
					+ "( SELECT 'AD' FROM DUAL UNION SELECT 'MI' FROM DUAL UNION SELECT 'PR' FROM DUAL UNION SELECT 'RD' FROM DUAL "
					+ "UNION SELECT 'AR' FROM bl_parameters WHERE operating_facility_id = '"
					+ facility_id
					+ "' AND NVL (rcpt_ar_tfr_amt_in_bl_yn, 'N') = 'Y' "
					+ "UNION SELECT 'HC' FROM bl_parameters WHERE operating_facility_id = '"
					+ facility_id
					+ "' AND NVL (hcard_in_use_yn, 'N') = 'Y' "
					//+ "UNION  SELECT 'PK' FROM bl_parameters WHERE operating_facility_id = '"
					//+ facility_id
					//+ "' AND NVL (package_enabled_yn, 'N') = 'Y' "
					+ "UNION SELECT 'PD' FROM DUAL where bl_chk_module_status('PK') = 'VALID' "
					
					+ "UNION  SELECT 'CU' FROM DUAL where bl_chk_module_status('AR') = 'VALID' and '"
					+ patient_id
					+ "' IS NULL"
					+ ")  AND UPPER (language_id) = UPPER ('"
					+ locale
					+ "') ) where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1";
			title = 'Receipt Nature';
			//alert(sql);
				break;
		}

		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		if (codeDesc == '1') {
			argumentArray[4] = "1,2";
			argumentArray[5] = code.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		} else if (codeDesc == '2') {
			argumentArray[4] = "2,1";
			argumentArray[5] = obj.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = CODE_DESC;
		}
		
		returnedValues = await CommonLookup(title, argumentArray);
		var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if ((returnedValues != null) && (returnedValues != "")) {
			obj.value = arr[1];
			code.value = arr[0];
			codeval = code.value;
		} else {
			obj.value = '';
			code.value = '';
		} 
	}

	function defaultReceipttype(obj){
	
		var rcptnature = document.forms[0].receipt_nature.value;
		var rcptdesc =document.forms[0].receipt_nature_code.value;
		var formObj = document.EnterReceiptRefundForm;
		var locale = formObj.locale.value;
		var facilityId = document.forms[0].facility_id.value;
		
		if(obj == 'rcptnature'){
			if(rcptnature.length>0 ){
				
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultReceipttype&rcptdesc="+rcptdesc+"&facility_id="+facilityId+"&language_id="+locale;					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
				
				if(responseText != 'N' && responseText.length>0){	
					var retArr = responseText.split(":::");
					
					document.forms[0].receipt_code.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].receipt_type.value = retArr[1]=='0'?'':retArr[1];
				}
				else
				{
					if($('#rec_ref').val()=='F')
					{			
						if($('#doc_number').val()=='')
						{
							document.forms[0].receipt_code.value = '';
							document.forms[0].receipt_type.value ='';
						}
					}
					else
					{
						document.forms[0].receipt_code.value = '';
						document.forms[0].receipt_type.value ='';
					}
				}
			} 
			else 
			{
				document.forms[0].receipt_code.value = '';
				document.forms[0].receipt_type.value ='';			
			}
		}
	}


async function DocNoLookup()
		{
				
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		
		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;
		acc_entity_code	= 'ZZ';	
		recpt_refund_ind = document.forms[0].recpt_refund_ind.value;
		rcpt_ip_allowed_yn = document.forms[0].rcpt_ip_allowed_yn.value;
		rcpt_op_allowed_yn = document.forms[0].rcpt_op_allowed_yn.value;
		rcpt_ref_allowed_yn = document.forms[0].rcpt_ref_allowed_yn.value;
		rfnd_ip_allowed_yn = document.forms[0].rfnd_ip_allowed_yn.value;
		rfnd_op_allowed_yn = document.forms[0].rfnd_op_allowed_yn.value; 
		rfnd_ref_allowed_yn = document.forms[0].rfnd_ref_allowed_yn.value;
		rfnd_allowed_yn = document.forms[0].rfnd_allowed_yn.value;
		rcpt_allowed_yn = document.forms[0].rcpt_allowed_yn.value;		 
		


		var title="doc no look up";
		var column_sizes = escape("15%,10%,10%,10%");
		desc="decription";
		code="code";
		var column_descriptions =desc+","+code; 
		var message = '';	
		sql3="SELECT B.SHORT_DESC short_desc, A.DOC_TYPE_CODE doc_type_code FROM BL_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') AND A.ACC_ENTITY_CODE = 'ZZ' and a.operating_facility_id = '"+facility_id+"'  and ((a.ENTITY_OR_FACILITY_BASED= 'F' and substr(a.doc_type_code,1,2)= '"+facility_id+"' ) or (a.ENTITY_OR_FACILITY_BASED= 'E' and  A.ACC_ENTITY_CODE =  'ZZ')) AND ((A.TRX_TYPE_CODE = '5' AND '"+recpt_refund_ind+"' = 'R' AND ('"+rcpt_op_allowed_yn+"' = 'Y' OR '"+rcpt_ip_allowed_yn+"' = 'Y' OR '"+rcpt_ref_allowed_yn+"'  = 'Y') AND	'"+rcpt_allowed_yn+"' = 'Y') OR (A.TRX_TYPE_CODE = '6' AND '"+recpt_refund_ind+"' = 'F' AND ('"+rfnd_op_allowed_yn+"' = 'Y'  OR '"+rfnd_ip_allowed_yn+"' = 'Y'  OR '"+rfnd_ref_allowed_yn+"' = 'Y') AND '"+rfnd_allowed_yn+"' = 'Y'))";

		 sql = escape(sql3);	
		 var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent('')+"&srch_by_clmn_index=1"+"&col_show_hide=YYYY";
		 retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
		 var arr=new Array();
		 if(retVal == null) retVal='';
		 if (retVal != null || retVal!="")
		 {
			 if(retVal!='undefined' && retVal!=undefined)
			{
			 var retVal=unescape(retVal);		 
				 if(retVal != null && retVal.length>0)
					{
					arr=retVal.split("^~^");	
					document.forms[0].doc_no_code.value=arr[0];				
					document.forms[0].doc_no_desc.value=arr[1];				  
					}
			 }
		}
	
	}
async function reasonLookup()
{
		var target			= document.forms[0].reason;		
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title ="Reason"
		//var title = encodeURIComponent(title);		
		var locale  = document.forms[0].locale.value;			
		var sql2="SELECT  a.action_reason_code code ,a.action_reason_desc description FROM   bl_action_reason_lang_vw a where nvl(status,'!') != 'S'and upper(language_id) = upper('en')and exists (select action_type from bl_action_reason_by_type b where b.action_type = 'DT' AND    NVL(b.active_yn, 'N') = 'Y') and upper(a.action_reason_code) like upper (?) and upper(a.action_reason_desc) like upper(?) order by 1";

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql2;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;		
		retArray = await CommonLookup( title, argArray );

				var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}  
		if(retArray != null && retArray !="")
		{		
			alert(retArray[0]);
			document.forms[0].reason.value=arr[1];			
			
		}
	}	

	async function origdocLookup()
		{
		var target			= document.forms[0].reason;		
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title ="Reason"
		//var title = encodeURIComponent(title);		
		var locale  = document.forms[0].locale.value;			
		var sql2="SELECT a.BLNG_SERV_CODE code, a.SHORT_DESC description FROM BL_BLNG_SERV_LANG_VW a where nvl(status,'!') != 'S'and upper(language_id) = upper('en') and upper(a.BLNG_SERV_CODE) like upper (?) and upper(a.SHORT_DESC) like upper(?) order by 1";

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql2;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;		
		retArray = await CommonLookup( title, argArray );

			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")
		{		
			alert(retArray[0]);
			document.forms[0].original_doc_no.value=arr[1];			
			
		}
	}	

	async function deptLookup(click_event)
	{
		var target	= document.forms[0].dept_desc;
		if(click_event == 'B')
		{
			if(document.forms[0].dept_desc.value == "")
			{
				document.forms[0].dept_desc.value = "";
				document.forms[0].ext_acc_dept_code.value = "";
				return;
			}
		}
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "80vh" ;
		var dialogWidth			= "50vw" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";

		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;

		var title=getLabel("Common.department.label","common");
		title=encodeURIComponent(title);	

		var column_sizes = escape("30%,70%");
		
		var code=getLabel("Common.code.label","common");
		code=encodeURIComponent(code);	
		
		var desc=getLabel("Common.description.label","common");
		desc=encodeURIComponent(desc);

		var column_descriptions = code+","+desc;
		var message = '';
		
		sql="select dept_code DEPT_CODE,short_desc SHORT_DESC from sy_dept_LANG_VW where nvl(status,'x') != 'S' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and operating_facility_id = '"+facility_id+"'";		

		sql = escape(sql);		

		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

		retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
		
		var arr=new Array();
		if(retVal == null || retVal == "undefined" || retVal == undefined) retVal="";
		if (retVal != "")
		{
			var retVal=unescape(retVal);		 
			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");	
				document.forms[0].ext_acc_dept_code.value=arr[0];				
				document.forms[0].dept_desc.value=arr[1];				  
			}
		}
		else
		{
			document.forms[0].ext_acc_dept_code.value="";
			document.forms[0].dept_desc.value="";
		}
	}

	async function custLookup()
	{
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		
		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;
		var title="Department";
		var column_sizes = escape("15%,10%,10%,10%");
		desc="decription";
		code="code";
		var column_descriptions =desc+","+code; 
		var message = '';	
		sql3="select cust_code,decode(nvl(chinese_reporting_flag,'N'), 'N', long_name, long_name_chinese) from ar_customer_lang_vw where nvl(status,'X') != 'S'AND   UPPER(LANGUAGE_ID) = UPPER('"+facility_id+"') and acc_entity_code in ( select acc_entity_code from sy_acc_entity where acc_entity_id = '"+facility_id+"' ) ";
		prompt(" ",sql3); 
		sql = escape(sql3);	
		 var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent("")+"&srch_by_clmn_index=1"+"&col_show_hide=YYYY";
		 retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
		 var arr=new Array();
		 if(retVal == null) retVal='';
		 if (retVal != null || retVal!="")
		{
			 if(retVal!='undefined' && retVal!=undefined)
			{
			 var retVal=unescape(retVal);		 
			 if(retVal != null && retVal.length>0)
			  {

					arr=retVal.split("^~^");	
					document.forms[0].cust_code.value=arr[0];				
					document.forms[0].cust_desc.value=arr[1];				  
		
			  }
			}
		}
	}
	async function ReceiptTypeLookup(click_event)
	{
		var ext_acc_int_YN = document.forms[0].ext_acc_int_YN.value;

		if(click_event == 'B')
		{
			if(document.forms[0].receipt_type.value == "")
			{
				document.forms[0].receipt_type.value = "";
				document.forms[0].receipt_code.value = "";
				if(ext_acc_int_YN == "Y")
				{
					document.forms[0].ext_acc_code.value = "";
					document.forms[0].ext_acc_dept_code.value = "";
					document.forms[0].dept_desc.value = "";
					document.forms[0].dept_desc.disabled = true;
					document.forms[0].dept_btn.disabled = true;
				}
				return;
			}
			
		}
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "80vh" ;
		var dialogWidth			= "60vw" ;
		var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		
		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;	
		var reln_code = document.forms[0].reln_code.value;
		var episode_type = document.forms[0].episode_type.value;

		var title=getLabel("eBL.RECEIPT_TYPE.label","BL");
		title=encodeURIComponent(title);	
		var column_sizes = escape("20%,80%");
		var code=getLabel("Common.code.label","common");
		var desc=getLabel("Common.description.label","common");	
		desc=encodeURIComponent(desc);
		var column_descriptions = code+","+desc; 
		var message = '';	
		/*****ADDED function_id CHECK  FOR PACKAGE BILLING*******/
			var function_id=document.forms[0].function_id.value;
		/*if(function_id=="PKG_BILLING")
		{
			sql3="select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and ADDED_FACILITY_ID = '"+facility_id+"' and RECPT_NATURE_CODE='PK' and(('"+ext_acc_int_YN+"' = 'Y' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code ='PK' and nvl(status,'X') <> 'S'	and (('PK' not in ('BI','DC') and episode_type IN ('U','"+episode_type+"') and category IN ('"+reln_code+"','UNRESTRICTED'))))) or '"+ext_acc_int_YN+"' = 'N')";
			sql3="SELECT * FROM BL_RECEIPT_TYPE_lang_vw WHERE RECEIPT_TYPE_CODE IN (SELECT pat_dep_for_pkg FROM bl_parameters WHERE operating_facility_id='"+facility_id+"') ANDUPPER(LANGUAGE_ID) = UPPER('"+locale+"') AND acc_entity_code= (SELECT ACC_ENTITY_CODE FROM sy_Acc_entity WHERE ACC_ENTITY_ID='"+facility_id+"')";

		}else{*/
	/*	Commented against incident 41239  on  4/7/2013
		
	sql3="select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and ADDED_FACILITY_ID = '"+facility_id+"' and RECPT_NATURE_CODE='AD' and(('"+ext_acc_int_YN+"' = 'Y' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code ='AD' and nvl(status,'X') <> 'S'	and (('AD' not in ('BI','DC') and episode_type IN ('U','"+episode_type+"') and category IN ('"+reln_code+"','UNRESTRICTED'))))) or '"+ext_acc_int_YN+"' = 'N')";
	*/

			sql3="select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"')  and ACC_ENTITY_CODE in (select ACC_ENTITY_ID from   SM_ACC_ENTITY_PARAM_FACL where FACILITY_ID ='"+facility_id+"' ) and RECPT_NATURE_CODE='AD' and(('"+ext_acc_int_YN+"' = 'Y' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code ='AD' and nvl(status,'X') != 'S'	and (('AD' not in ('BI','DC') and episode_type IN ('U','"+episode_type+"') and category IN ('"+reln_code+"','UNRESTRICTED'))))) or '"+ext_acc_int_YN+"' = 'N')";


		//}

		sql = escape(sql3);	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].receipt_type.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
		 retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
		var arr=new Array();

		if(retVal == null || retVal=="undefined" || retVal==undefined) retVal="";
		if (retVal != "")
		{
			var retVal=unescape(retVal);		 
			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");	
				document.forms[0].receipt_code.value=arr[0];				
				document.forms[0].receipt_type.value=arr[1];				  
			}		
		}
		else
		{
			document.forms[0].receipt_code.value="";				
			document.forms[0].receipt_type.value="";				  
		}

		if(document.forms[0].receipt_code.value != "" && ext_acc_int_YN == "Y")
		{
			var patient_id=document.forms[0].patient_id.value;

			var episode_type=document.forms[0].episode_type.value;
			var episode_id=document.forms[0].episode_id.value;
			var visit_id=document.forms[0].visit_id.value;
			var encounter_id=document.forms[0].encounter_id.value;
			var rcpt_nat_code=document.forms[0].receipt_nature_code.value;
			var rcpt_type_code=document.forms[0].receipt_code.value;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";

			var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&rcpt_nat_code="+rcpt_nat_code+"&rcpt_type_code="+rcpt_type_code;

			var temp_jsp="../../eBL/jsp/BLEnterReceiptRefundValidation.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);

			var retVal = responseText.split("&^&");

			var srch_status = retVal[0];

			if(srch_status == 'E') // Error Txt
			{
				alert(retVal[1]);
				document.forms[0].ext_acc_code.value = "";
				document.forms[0].ext_acc_dept_code.value = "";
				document.forms[0].dept_desc.value = "";
				document.forms[0].dept_desc.disabled = true;
				document.forms[0].dept_btn.disabled = true;
				return false;
			}
			else if(srch_status == 'M') // Message
			{
				alert(getMessage(retVal[1],"BL"));
				document.forms[0].ext_acc_code.value = "";
				document.forms[0].ext_acc_dept_code.value = "";
				document.forms[0].dept_desc.value = "";
				document.forms[0].dept_desc.disabled = true;
				document.forms[0].dept_btn.disabled = true;
				return false;
			}
			else if(srch_status == 'Y') // External Acc Code found
			{
				document.forms[0].ext_acc_facility_id.value = retVal[1];
				document.forms[0].ext_acc_code.value = retVal[2];
				var ext_dept_ind = retVal[3];
				document.forms[0].ext_dept_ind.value = ext_dept_ind;
				if(ext_dept_ind == "E") // Enterable
				{
					document.forms[0].dept_desc.value = "";
					document.forms[0].ext_acc_dept_code.value = "";
					document.forms[0].dept_desc.disabled = false;
					document.forms[0].dept_btn.disabled = false;
				}
				else if(ext_dept_ind == "S") // From Source Location
				{
					document.forms[0].ext_acc_dept_code.value = retVal[4];
					document.forms[0].dept_desc.value = retVal[5];
					document.forms[0].dept_desc.disabled = true;
					document.forms[0].dept_btn.disabled = true;
				}
			}
		}
	}

	function enableall()
	{
		var checked_key=document.forms[0].down_town_entry.checked;
		if(checked_key==true)
		{
			document.forms[0].doc_no_desc.readOnly=false;
			document.forms[0].doc_no_desc.value=down_time_rcpt_doc_type;
			document.forms[0].doc_no.readOnly=false;
			//document.forms[0].doc_date.readOnly=false;
			document.forms[0].reason.readOnly=false;
			document.forms[0].doc_btn.disabled=false;
			document.forms[0].reason_btn.disabled=false;			
			document.getElementById('cal_img_id').style.display='inline';


		}
		else{
			document.forms[0].doc_no_desc.readOnly=true;
			document.forms[0].doc_no.readOnly=true;
			//document.forms[0].doc_date.readOnly=true;
			document.forms[0].reason.readOnly=true;
			document.forms[0].doc_btn.disabled=true;
			document.forms[0].reason_btn.disabled=true;			
			document.getElementById('cal_img_id').style.display='none';
		}
	}

	function callOriDoc()
	{
		var rec_refnd_ind=document.forms[0].rec_refnd_ind.value;
		if(rec_refnd_ind=='refund')
		{
			document.getElementById('ori_doc_btn_id').style.display='inline';
		}
		else{
				document.getElementById('ori_doc_btn_id').style.display='none';
		}
	}

	function validDateChk()
	{	
		var locale = document.forms[0].locale.value;
		var noodDays = document.forms[0].downTimeAllowDays.value;		
		var fromDate = document.forms[0].doc_date.value;
		var currDate = getCurrentDate('DMYHM',locale);
		var daysB = daysBetween(fromDate,currDate,'DMYHM',locale);		
		if(fromDate>currDate)
		{
			alert("Date cannot be greater then sysdate");
			document.forms[0].doc_date.select();		
		}
			if(daysB>noodDays)
			{				
				alert("Downtime Entry more then 2 days is not allowed"); 				
				document.forms[0].doc_date.select();
			}
	}

	async function funBLStmt()
	{
		var retVal = new Array();
		var billdoctype= 'HSBLOP';  //document.forms[0].billdoctypecode.value;	
		var billdocnum='1658'   //document.forms[0].billdocnum.value;	
		var blnggrp="CA";
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "40" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	

		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"blnggrp="+blnggrp;
		retVal=await window.showModalDialog("../../eBL/jsp/BLBillSlmtMain.jsp?"+param,arguments,features);
		
	}

	function putdeci(object)
	{
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}
	function setAmt(billpayableamt)
		{
		parent.frames[2].document.forms[0].rec_refund_amt.value=billpayableamt;
		}


		function setDepType()
		{
			var function_id = document.forms[0].function_id.value;
			
			if (function_id!="PKG_BILLING")
			{			
			var tot_adm_dep_amt=document.forms[0].tot_adm_dep_amt.value;
			var tot_trf_dep_amt=document.forms[0].tot_trf_dep_amt.value;
			var tot_othr_dep_amt=document.forms[0].tot_othr_dep_amt.value;
			
			if(parseFloat(tot_adm_dep_amt)>0)
			{
				
				document.forms[0].dep_type.selectedIndex=1;
				document.forms[0].stlmt_amount.value=tot_adm_dep_amt;
			}
			else if(parseFloat(tot_trf_dep_amt)>0)
			{
					document.forms[0].dep_type.selectedIndex=2;
					document.forms[0].stlmt_amount.value=tot_trf_dep_amt;
			}
			else if(parseFloat(tot_othr_dep_amt)>0)
				{
				
				document.forms[0].dep_type.selectedIndex=3;
					document.forms[0].stlmt_amount.value=tot_othr_dep_amt;
			}
			else{
				
				document.forms[0].dep_type.selectedIndex=0;
					//document.forms[0].stlmt_amount.value="";
				}
				/***************Added function id check PACKAGE BILING**********************************/
			}else{
				
					//var pkgAmount=document.forms[0].pkgAmount.value;	//ram
					var tot_package_amt=document.forms[0].tot_package_amt.value;	
					var d_tot_package_amt=document.forms[0].d_tot_package_amt.value;					 					
					document.forms[0].stlmt_amount.value=d_tot_package_amt;
					//var amt_temp=("document.forms[0].stlmt_amount");
					//putdeci(amt_temp);
				}
		}
		function listChange()
		{
			document.forms[0].stlmt_amount.value="";
			var tot_adm_dep_amt=document.forms[0].tot_adm_dep_amt.value;
			var tot_trf_dep_amt=document.forms[0].tot_trf_dep_amt.value;
			var tot_othr_dep_amt=document.forms[0].tot_othr_dep_amt.value;
			if(document.forms[0].dep_type.value=='A' && parseFloat(tot_adm_dep_amt)>0)
			{
			
				document.forms[0].stlmt_amount.value=tot_adm_dep_amt;
				var slmt_amt1=eval("document.forms[0].stlmt_amount");
				putdeci(slmt_amt1);
			}
			else if(document.forms[0].dep_type.value=='T' && parseFloat(tot_trf_dep_amt)>0)
			{			
					document.forms[0].stlmt_amount.value=tot_trf_dep_amt;
			}
			else if(document.forms[0].dep_type.value=='O' && parseFloat(tot_othr_dep_amt)>0)
				{			
				
					document.forms[0].stlmt_amount.value=tot_othr_dep_amt;
			}
			else if(document.forms[0].dep_type.value=='P')
			{			
				
					document.forms[0].stlmt_amount.value='<%=d_tot_package_amt%>';
			}
			else{
				
					document.forms[0].stlmt_amount.value="";

			}
		}

/*******************FUNCTION ADDED FOR PACKAGE BILLING*************************/
	function setAmtpkg(obj,function_id)
		{			
			var partial_dep_yn = "<%=str_partial_dep_yn%>";			
			var min_dep_amt = "<%=str_min_dep_amt%>";			
			var tot_min_dep_amt = "<%=tot_min_dep_amt%>";			
//			var pkgamt="<%=tot_package_amt%>";
			//var pkgamt="<%=d_tot_package_amt%>";
		//	if('<%=doc_amt%>'!=""){
		//	var pkgamt="<%=doc_amt%>";
			//}else{
			var pkgamt="<%=d_tot_package_amt%>";
			//}
			var pkgamtfld=obj.value;	

			/*if(partial_dep_yn =="N")
			{
				if(parseInt(pkgamtfld)  < parseInt(pkgamt)){
				alert("For this Package Partial deposit not allowed");
				obj.select();
				}

			}else{
				if(parseInt(pkgamtfld)  < parseInt(min_dep_amt)){
					alert("Package Deposit Must be equal to min. deposit Amount"+"="+min_dep_amt);					
				}
			}*/
			//Added for MMS-DM-SCF-0013
			var minMandAmtFinal = parent.frames[4].document.forms[0].totMinDeposit.value;
			var minMandAmtDtl = document.forms[0].totMinDepositDtl.value;
			var derivedFromDtl = document.forms[0].derivedFromDtl.value;
			//In Details page if value is Y then override this page value
			if(derivedFromDtl == 'Y'){
				minMandAmtFinal = minMandAmtDtl;
			}
			tot_min_dep_amt = parseFloat(tot_min_dep_amt) - parseFloat(minMandAmtFinal);
			//Added for MMS-DM-SCF-0013
			if (parseInt(pkgamtfld)  > parseInt(pkgamt))
			{
				//alert("Amount should not be greater than Package Amount"+pkgamt);
				alert(getMessage("BL8660","BL")+':'+pkgamt);
				obj.select();

			}else if(parseFloat(pkgamtfld)<parseFloat(tot_min_dep_amt))
			{
				alert(getMessage("BL8658","BL")+':'+tot_min_dep_amt);
				obj.select();
			}else{
				setAmt(obj);
			}

		}
	</script>
	<!-- condition added by Manivel for TH-KW-CRF-0156 -->
<% if(dfltRcptTypeForDeposit && !isDfltPkgRcptTypeSetup && function_id.equals("PKG_BILLING")){
%>
<BODY onLoad="setDepType();defaultReceipttype('rcptnature');" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<%	}
	else
	{
%>
<BODY onLoad="setDepType();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<%
	}
%>
<FORM name='EnterReceiptRefundForm' id='EnterReceiptRefundForm' action="" method='' >	

	<!--<table border='0' cellpadding='0' cellspacing='0'  id='tbl' width='100%'>	
	 <tr>
	  <td class="label" width="25%"><b>Down Town Entry</b>
	  <input type='checkbox' name='down_town_entry' id='down_town_entry' size='5'  maxlength='5' value="" onclick="enableall()"></td>
	  <td width="25%"  class='labels'>
	  <td width="25%"  class='labels'>
	  <td width="25%"  class='labels'>

	  </tr>
	  <tr>
		 <td class="label" width="25%">Document No
		<td width='25%' class="fields"><input type='text' name='doc_no_desc' id='doc_no_desc' size='15' maxlength='15'   value=''  onBlur="" readonly>/<input type='text' name='doc_no' id='doc_no' size='10' maxlength='10'   value=''  onBlur="" readonly><input type='button' class='button' name="doc_btn" id="doc_btn"   value='?'  tabindex='0' onClick='DocNoLookup()' disabled>
		<input type= 'hidden' name="doc_no_code" id="doc_no_code"  value="">
		<td class="label" width="10%">Date<input type='text' name='doc_date' id='doc_date' size='10' maxlength='10' value=''  onBlur="validDateChk();" ><div id='cal_img_id' style='display:none'><input name='cal_btn' id='cal_btn' type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('doc_date',null,'hh:mm');" style='cursor:pointer' ></div></td>
		 <td class="label" width="15%">Reason<input type='text' name='reason' id='reason' size='15' maxlength='15'  value=''  onBlur="" readonly><input type='button' class='button' name="reason_btn" id="reason_btn"   value='?'  tabindex='0' onClick='reasonLookup()' disabled></td>
		</tr>
	  <tr> </tr>	  <tr> </tr>
	</table>-->
	<table border='0' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<tr>			
			<td class="label" width="25%"><fmt:message key="eBL.REC_NATURE.label"	bundle="${bl_labels}"/></td>
			<td width='25%' class="fields">
				<input type='hidden' name='receipt_nature_code' id='receipt_nature_code' value='<%=strRecptNatureCode%>'  onBlur="">
				<input type='text' name='receipt_nature' id='receipt_nature' size='22' maxlength='22'  value='<%=strRecptNaturedesc%>'  onBlur="" readonly>
			</td>
			<td class="label" width="25%"><fmt:message key="eBL.RECEIPT_REFUND.label"	bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><select name='recpt_refund_ind' id='recpt_refund_ind' id='rec_ref'  onChange="">
			<!--    <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>-->
					<option value='R' selected>Receipt</option>
			<!--    <option value='F'>Refund</td>-->							
		</tr>
	 <!--	<tr>			
		 <td class="label" width="25%">Original Doc No</td>
		 <td width='25%' class="fields"><input type='text' name='original_doc_no' id='original_doc_no' size='10' maxlength='10'  value=''  onBlur="">/<input type='text' name='original_doc_no1' id='original_doc_no1' size='10' maxlength='10'  value=''  onBlur="">/<input type='text' name='original_doc_no2' id='original_doc_no2' size='4' maxlength='10'  value=''  onBlur=""><div id='ori_doc_btn_id' style='display:none'><input type='button' class='button' name="reason_btn" id="reason_btn"   value='?'  tabindex='0' onClick='origdocLookup()'></div></td>
		 <td class="label" width="25%">Customer</td>
		 <td width='25%' class="fields"><input type='text' name='cust_desc' id='cust_desc' size='30' maxlength='15'  value=''  onBlur=""><input type='button' class='button' name="cust_btn" id="cust_btn"   value='?'  tabindex='0' onClick='custLookup()'></td>
		  <input type= 'hidden' name="cust_code" id="cust_code"  value=""></tr>-->
		<tr>
			<td class="label" width="25%"><fmt:message key="eBL.RECEIPT_TYPE.label"	bundle="${bl_labels}"/></td>
<% if(function_id.equals("PKG_BILLING"))
	{
 %>
		
		<td width='25%' class="fields"><input type='text' name='receipt_type' id='receipt_type' size='22' maxlength='22'  value='<%=rcpt_type_long_desc%>'  READONLY>
		<img src='../../eCommon/images/mandatory.gif'>
		 <input type= 'hidden' name="receipt_code" id="receipt_code"  value="<%=rcpt_type_code%>">	</td> 
		 
<%	}
	else
	{
%>
			<td width='25%' class="fields"><input type='text' name='receipt_type' id='receipt_type' size='22' maxlength='22'  value=''  onBlur="ReceiptTypeLookup('B')"><input type='button' class='button' name="rec_type" id="rec_type"   value='?'  tabindex='0' onClick="ReceiptTypeLookup('C')"><img src='../../eCommon/images/mandatory.gif'>
				<input type= 'hidden' name="receipt_code" id="receipt_code"  value="">	
			</td>
<%
	}
%>
			<td class="label" width="25%"><fmt:message key="eBL.DEPOSIT_TYPE.label"	bundle="${bl_labels}"/></td>
<% if(function_id.equals("PKG_BILLING"))
		 {
			 if("Y".equals(SiteSpecific_PkgDep))
			 {
%>
			<td width='25%' class="fields">
			<select name='dep_type' id='dep_type' onChange="listChange()">
			<option value='P'><fmt:message key="eBL.ADM_DEP.label" bundle="${bl_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif'>
		 </td>		
<%
			 }
			 else{
				 
			%>
			<td width='25%' class="fields">
			<select name='dep_type' id='dep_type' onChange="listChange()">
			<option value='P'><fmt:message key="eBL.PKG_DEP.label" bundle="${bl_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif'>
		 </td>		
<%	 
				 
				 
			 }


		}else{
%>
		<td width='25%' class="fields">
			<select name='dep_type' id='dep_type' onChange="listChange()">
				<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>-->
				<option value='A'><fmt:message key="eBL.ADM_DEP.label" bundle="${bl_labels}"/></option>
				<option value='T'><fmt:message key="eBL.TRN_DEP.label" bundle="${bl_labels}"/></option>
				<option value='O'><fmt:message key="eBL.OTH_DEP.label" bundle="${bl_labels}"/></option>
				<option value='P'><fmt:message key="eBL.PKG_DEP.label" bundle="${bl_labels}"/></option>
				<option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif'>
		 </td>		
<%}
	%>
	</tr>
	<tr>
<%
		if(ext_acc_int_YN.equals("Y"))
		{
%>
		 <td width="25%" class="label"><fmt:message key="eBL.ACCOUNT_CODE.label" bundle="${bl_labels}"/></td>
		 <td width='25%' class="fields"><input type='text' name='ext_acc_code' id='ext_acc_code' size='15' maxlength='15'  value='' onBlur="" DISABLED></td>
		 <td width='25%' class='label'><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
		 <td width='25%' class="fields"><input type='text' name='dept_desc' id='dept_desc' size='30' maxlength='45'  value=''  onBlur="deptLookup('B')" DISABLED><input type='button' class='button' name="dept_btn" id="dept_btn"   value='?'  tabindex='0' onClick='deptLookup("C")' DISABLED></td>	
		 <input type= 'hidden' name="ext_acc_dept_code" id="ext_acc_dept_code"  value="">
<%
		}
		else
		{
%>
			<input type= 'hidden' name="ext_acc_code" id="ext_acc_code"  value="">	
			<input type= 'hidden' name="ext_acc_dept_code" id="ext_acc_dept_code"  value="">	
<%
		}
%>
	 </tr>
<!--
	<tr>

		 <td class="label" width="25%">Healthcare Appl no</td>
		 <td width='25%' class="fields"><input type='text' name='customer' id='customer' size='30' maxlength='30'  value=''  onBlur=""><input type='button' class='button' name="hc_btn" id="hc_btn"   value='?'  tabindex='0' onClick=''></td> 
		  <td width="25%"  class='labels'>
			   <td width="25%"  class='labels'>
	</tr> 

	<tr>
		<td class="label" width="25%">Package Doc</td>		
		<td width='25%' class="fields"><input type='text' name='pack_doc' id='pack_doc' size='15' maxlength='15'  value=''  onBlur="">Date<input type='text' name='date_tx' id='date_tx' size='15' maxlength='15'  value=''  onBlur=""></td>
		 <td class="label" width="25%">Booking Ref</td>
		 <td width='25%' class="fields"><input type='text' name='book_ref' id='book_ref' size='30' maxlength='30'  value=''  onBlur=""></td>
	</tr> 
-->
	<tr>
		<td class="label" width="25%"><fmt:message key="Common.remarks.label"	bundle="${common_labels}"/></td>
		<td width='25%' class="fields"><input type='text' name='remarks' id='remarks' size='30 maxlength='30'  value='<%=remarks_desc%>'  onBlur=""></td>
		<!-- <td class="label" width="25%">Medical Report Request No</td>
		 <td width='25%' class="fields"><input type='text' name='med_rep_req_no' id='med_rep_req_no' size='30' maxlength='30'  value=''  onBlur=""></td>-->
		  <td width="25%"  class='labels'>
			   <td width="25%"  class='labels'>
	</tr> 


	<tr>

		<%
/********************ADDED FOR PACKAGE BILLING function_id CHECK**********************/		
	if(function_id.equals("PKG_BILLING"))
	{
%>
		<td class="label" width="25%"><fmt:message key="Common.amount.label"	bundle="${common_labels}"/></td>
		<td width='25%' class="fields"><input type='text' name='stlmt_amount' id='stlmt_amount' size='15' maxlength='15'  value='<%=doc_amt%>'    style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onBlur='putdeci(this);setAmtpkg(this,"PKG_BILLING")'><img src='../../eCommon/images/mandatory.gif'></td>
<%
	}else{
%>
		<td class="label" width="25%"><fmt:message key="Common.amount.label"	bundle="${common_labels}"/></td>
		<td width='25%' class="fields"><input type='text' name='stlmt_amount' id='stlmt_amount' size='15' maxlength='15'  value=''   style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onBlur='putdeci(this);setAmt(this)'><img src='../../eCommon/images/mandatory.gif'></td>
<%
	}
%>

		 <!--<td class="label" width="25%">Credit Card Deductaible Amt</td>
		 <td width='25%' class="fields"><input type='text' name='credit_cd_ded_amt' id='credit_cd_ded_amt' size='30' maxlength='30	'  value=''  onBlur=""></td>-->
		<td class="label" width="25%"></td>
  		<td class="label" width="25%"><fmt:message key="eBL.THRU_MAIL.label"	bundle="${bl_labels}"/>
		<input type='checkbox' name='thru_mail' id='thru_mail' size='5'  maxlength='5' value="" onclick=""></td>
		<td width="25%"  class='labels'>
		</tr> 

<%/*	if(function_id.equals("PKG_BILLING"))
		{*/
%>		 <!--  <tr><td class="label" width="25%"><fmt:message key="eBL.packageSeqNo.label"	bundle="${bl_labels}"/></td>
		<td width='25%' class="fields"><input type='text' name='pkgSeqNo' id='pkgSeqNo' size='15' maxlength='15'  value='<%=packseqno%>' readonly > </td>		 -->	
<%		//}    
%>
		<!-- </tr> -->
	</table>
<!--
		<table border='0' cellpadding='0' cellspacing='0'  id='tbl' width='100%'>	
	 <tr>
	  <td class="label" width="25%"><b>Counter/Shift</b>
	  <td width='25%' class="fields"><input type='text' name='ctr' id='ctr' size='10' maxlength='30	'  value=''  onBlur=""><input type='text' name='shift' id='shift' size='10' maxlength='30	'  value=''  onBlur=""></td>

		 <td class="label" width="25%"><b>Document No</b>
	  <td width='25%' class="fields"><input type='text' name='doc_type' id='doc_type' size='10' maxlength='30	'  value=''  onBlur=""><input type='text' name='doc_no' id='doc_no' size='10' maxlength='30'  value=''  onBlur=""></td>
		  </tr>
		<tr>
		  	<td width="25%"  class='labels'>
		  	<td width="25%"  class='labels'>
		  <td class="label" width="25%"><b>Date</b>
			<td width='25%' class="fields"><input type='text' name='doc_type' id='doc_type' size='10' maxlength='30	'  value=''  onBlur=""></td>
		  	
	  </tr>
	</table>-->
	
	<input type= 'hidden' name="downTimeAllowDays" id="downTimeAllowDays"  value="<%=strDownTimeAllowDays%>">
	<input type= 'hidden' name="locale" id="locale"  value="<%=locale%>">
	<input type= 'hidden' name="facility_id" id="facility_id"  value="<%=facilityid %>">	
	<input type= 'hidden' name="rcpt_ip_allowed_yn" id="rcpt_ip_allowed_yn"  value="<%=rcpt_ip_allowed_yn %>">	
	<input type= 'hidden' name="rcpt_ref_allowed_yn" id="rcpt_ref_allowed_yn"  value="<%=rcpt_ref_allowed_yn %>">	
	<input type= 'hidden' name="rcpt_op_allowed_yn" id="rcpt_op_allowed_yn"  value="<%=rcpt_op_allowed_yn %>">	
	<input type= 'hidden' name="rfnd_ip_allowed_yn" id="rfnd_ip_allowed_yn"  value="<%=rfnd_ip_allowed_yn %>">	
	<input type= 'hidden' name="rfnd_op_allowed_yn" id="rfnd_op_allowed_yn"  value="<%=rfnd_op_allowed_yn %>">	
	<input type= 'hidden' name="rfnd_ref_allowed_yn" id="rfnd_ref_allowed_yn"  value="<%=rfnd_ref_allowed_yn %>">			
	<input type= 'hidden' name="rfnd_allowed_yn" id="rfnd_allowed_yn"  value="<%=rfnd_allowed_yn %>">	
	<input type= 'hidden' name="rcpt_allowed_yn" id="rcpt_allowed_yn"  value="<%=rcpt_allowed_yn %>">	
	<input type= 'hidden' name="down_time_rcpt_doc_type" id="down_time_rcpt_doc_type"  value="<%=strDownTimeRcptDocType %>">	
	<input type= 'hidden' name="down_time_rfnd_doc_type" id="down_time_rfnd_doc_type"  value="<%=strDownTimeRfndDocType %>">	
	<input type= 'hidden' name="noofdecimal" id="noofdecimal"  value="<%=noofdecimal %>">	
	<input type= 'hidden' name="tot_adm_dep_amt" id="tot_adm_dep_amt"  value="<%=tot_adm_dep_amt %>">		
	<input type= 'hidden' name="tot_trf_dep_amt" id="tot_trf_dep_amt"  value="<%=tot_trf_dep_amt %>">	
	<input type= 'hidden' name="tot_othr_dep_amt" id="tot_othr_dep_amt"  value="<%=tot_othr_dep_amt %>">	
	<input type= 'hidden' name="tot_adm_dep_paid_amt" id="tot_adm_dep_paid_amt"  value="<%=tot_adm_dep_paid_amt %>">	
	<input type= 'hidden' name="collect_dep_amt_in_adv_yn" id="collect_dep_amt_in_adv_yn"  value="<%=collect_dep_amt_in_adv_yn %>">	
	<input type= 'hidden' name="shift_id" id="shift_id"  value="<%=shift_id%>">	
	<input type= 'hidden' name="cash_counter_code" id="cash_counter_code"  value="<%=cash_counter_code%>">	
	<input type= 'hidden' name="ext_acc_facility_id" id="ext_acc_facility_id"  value="">	
	<input type= 'hidden' name="ext_dept_ind" id="ext_dept_ind"  value="">		
	<input type= 'hidden' name="ext_acc_int_YN" id="ext_acc_int_YN"  value="<%=ext_acc_int_YN%>">	
	<input type= 'hidden' name="pkgAmount" id="pkgAmount"  value="<%=pkgAmount%>">	
	<input type= 'hidden' name="tot_package_amt" id="tot_package_amt"  value="<%=tot_package_amt%>">	
	<input type= 'hidden' name="d_tot_package_amt" id="d_tot_package_amt"  value="<%=d_tot_package_amt%>">		
	

	<input type= 'hidden' name="patient_id" id="patient_id"  value="<%=patient_id%>">	
	<input type= 'hidden' name="episode_type" id="episode_type"  value="<%=episode_type%>">	
	<input type= 'hidden' name="episode_id" id="episode_id"  value="<%=episode_id%>">	
	<input type= 'hidden' name="visit_id" id="visit_id"  value="<%=visit_id%>">	
	<input type= 'hidden' name="encounter_id" id="encounter_id"  value="<%=encounter_id%>">	
	<input type= 'hidden' name="reln_code" id="reln_code"  value="<%=reln_code%>">	
	<input type= 'hidden' name="function_id" id="function_id"  value="<%=function_id%>">	
	<input type= 'hidden' name="funct_mode" id="funct_mode"  value="<%=funct_mode%>">	
	<input type= 'hidden' name="deposit_man_yn" id="deposit_man_yn"  value="<%=str_deposit_man_yn%>">	
	<input type= 'hidden' name="packseqno" id="packseqno"  value="<%=packseqno%>">	
	<input type= 'hidden' name="pkgCode" id="pkgCode"  value="<%=pkgCode%>">	
	<input type= 'hidden' name="min_dep_amt" id="min_dep_amt"  value="<%=str_min_dep_amt%>">	
	<input type= 'hidden' name="min_dep_amt_man" id="min_dep_amt_man"  value="<%=tot_min_dep_amt%>">	
	<input type= 'hidden' name="pkgSeqAmtForSub" id="pkgSeqAmtForSub"  value="<%=pkgSeqAmtForSub%>">	
	<input type= 'hidden' name='ignoreMandValidationDtl' id='ignoreMandValidationDtl' id='ignoreMandValidationDtl' value='<%=ignoreMandValidationDtl%>'>
	<input type= 'hidden' name='derivedFromDtl' id='derivedFromDtl' id='derivedFromDtl' value='<%=derivedFromDtl%>'>
	<input type='hidden' name='totMinDepositDtl' id='totMinDepositDtl' id='totMinDepositDtl' value='<%=totMinDepositDtl %>'>	
	<input type='hidden' name = 'dfltRcptTypeForDeposit' id='dfltRcptTypeForDeposit' value ='<%=dfltRcptTypeForDeposit%>'>
	<input type='hidden' name = 'isDfltPkgRcptTypeSetup' id='isDfltPkgRcptTypeSetup' value ='<%=isDfltPkgRcptTypeSetup%>'>
	
</form>
	<script>
	
</script>
</BODY>	
</HTML>
<%
	}
	catch(Exception e )
	{ 
		System.err.println("BLEnterServiceSerachResult:"+e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

