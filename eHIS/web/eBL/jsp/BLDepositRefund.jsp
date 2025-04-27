<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.Common.*, eBL.*, eCommon.Common.*,org.apache.commons.codec.binary.Base64" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<!-- 
Sr No        Version          TFS/Incident        SCF/CRF            		    	Developer Name
--------------------------------------------------------------------------------------------------------
1			 V220801			34745		BL-Deposit Receipt/Refund-Encounter	    Mohanapriya
1            V220816            34122           TH-KW-CRF-0156                      Namrata/Manivel
--------------------------------------------------------------------------------------------------------
-->

<%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} %>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	ResultSet rscurr = null; //ResultSet rs1 = null;		
	CurrencyFormat cf = new CurrencyFormat();
	String recptTypCode =null ;
	String recptTypLongDesc =null ;
	String splAgnDepYN  =null ;
	String beanId = "EstimateDepositBean" ;
	String beanName = "eBL.BLEstimateDepositBean";
	String strCustomerId="";
	
	//Added by NamrataCharate for TH-KW-CRF-0156
	boolean dfltRcptTypeForDeposit = false;
	boolean isDfltPkgRcptTypeSetup = false;

	try
	{
		
		BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
		//cleanBeanObject(beanId, beanName, request);
		depositbean.clearAll();
		
		String calledFrom=request.getParameter("called_from");
			
		
		
		String medrep_pay_int_mode="";
		String chiefcomplaint =  request.getParameter("chiefcomplaint")==null?"":request.getParameter("chiefcomplaint");
		String nursing_unit_code = request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");
		String customer_id=(String)session.getValue("CUSTOMER_ID");
		String chiefComplaintDesc = request.getParameter("chiefComplaintDesc")==null?"":request.getParameter("chiefComplaintDesc");
		//System.out.println("remarks : "+chiefComplaintDesc);
		con	=	ConnectionManager.getConnection(request);
		String strDownTimeAllowDays="";
		String receiptDownCode = "";
		String refundDownCode = "";
		String misc_rcpt_type="";
		String depcount="";
		String depreturn="";		
		//int depamt=0;
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String remarks_desc="";
		if((customer_id!=null && customer_id.equals("KDAH"))&&(!chiefcomplaint.equals(""))){
			remarks_desc = chiefComplaintDesc;
		}

		try
		{
		pstmt=con.prepareStatement("SELECT MEDREP_PAY_INT_MODE FROM   MR_PARAMETER");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				medrep_pay_int_mode  =  rs.getString(1);	
			}
		}
		System.out.println("query returned value MEDREP_PAY_INT_MODE "+medrep_pay_int_mode);
		if(medrep_pay_int_mode == null) medrep_pay_int_mode="N";			
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY MEDREP_PAY_INT_MODE:"+e);
			e.printStackTrace();
		}
		
		//Added by NamrataCharate for TH-KW-CRF-0156
		try 
		{
			dfltRcptTypeForDeposit = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENBL_DFLT_RCPT_TYPE_FOR_NATURE");
		} catch(Exception ex) {
			System.err.println("Error in BLEnterReceiptRefundDtl.jsp for getting dfltRcptTypeForDeposit Connection: "+ex);
			ex.printStackTrace();
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
		System.out.println("cc machine id"+strclientip);
		//System.out.println("encoded "+encoded);
		String patient_id ="";
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
			patient_id	= request.getParameter("patient_id");
			if(patient_id==null) patient_id="";	
		} //V220801	
		System.out.println("patient_id ,BLDepositRefund.jsp  "+patient_id); 

/*		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	
		System.out.println("patient_id ,refund"+patient_id);
 	*///V220801	
	
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		
		String strepisode_id = replaceNull(request.getParameter("episode_id"));	
		int episode_id=0;
		if("".equals(strepisode_id)){
			episode_id=0;
		}		
		else
		{
			try
			{
				episode_id=Integer.parseInt(strepisode_id);	
			}catch(Exception e)
			{
				episode_id=0;
			}
		}
		//if(episode_id==null) episode_id="";	
		System.out.println("Episode id depositrefund="+episode_id);
		
		String strVisit_id = replaceNull(request.getParameter("visit_id"));	
		int visit_id=0;
		if("".equals(strVisit_id)){
			visit_id=0;
		}		
		else
		{
			try
			{
				visit_id=Integer.parseInt(strVisit_id);	
			}catch(Exception e)
			{
				visit_id=0;
			}
		}
		System.out.println("visit_id="+visit_id);
		String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
		int encounter_id=0;
		if("".equals(strencounter_id)){
			encounter_id=0;
		}		
		else
		{
			try
			{
				encounter_id=Integer.parseInt(strencounter_id);	
			}catch(Exception e)
			{
				encounter_id=0;
			}
		} 
		System.out.println("encounter_id="+encounter_id);
		
		/*try
		{
		pstmt=con.prepareStatement(" select count(*) from bl_receipt_refund_HDR where operating_facility_id = '"+facilityid+"' and patient_id = '"+patient_id+"' and episode_id = '"+episode_id+"' and episode_type = NVL('"+episode_type+"','I') and recpt_refund_ind = 'R'and recpt_nature_code = 'AD'and nvl(cancelled_ind,'N') != 'Y' ");	
		 rs = pstmt.executeQuery();			
		 if( rs != null ) 
		{
			if( rs.next() )
			{			
				depcount  =  rs.getString(1);	
				
			}
		}
		
		if(depcount == null || depcount=="") 
			{
			depcount=Integer.toString(0);
			}
		System.out.println("query returned value depcount "+depcount);
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY depcount:"+e);
			e.printStackTrace();
		}*/
				
		/*try
		{
		pstmt=con.prepareStatement("select nvl(trn_dep,0) i from bl_ip_adt_trn_vw where patient_id = '"+patient_id+"' and episode_id = '"+episode_id+"' and facility_id = '"+facilityid+"' and trn_code = 'A' and nvl(adt_trn_status,'0') != '9' ");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				depreturn  =  rs.getString(1);	
			}
		}
		if(depreturn == null || depreturn=="")
		{
			System.out.println("if");
			depreturn=Integer.toString(0);
			
		}
		
		System.out.println("query returned value depreturn "+depreturn);
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY depreturn:"+e);
			e.printStackTrace();
		}*/

		try{
			
			String sqlsiteParam = "Select CUSTOMER_ID from SM_SITE_PARAM ";
			pstmt = con.prepareStatement(sqlsiteParam);		
			rs = pstmt.executeQuery();
			
			if(rs != null){			
				while(rs.next()){
					strCustomerId = rs.getString("CUSTOMER_ID");
					strCustomerId=strCustomerId==null?"":strCustomerId;
			
				}
			System.out.println("strCustomerId:::"+strCustomerId);
			}
			pstmt = null;
			rs = null;			

		}
		catch(Exception e)
		{
			System.out.println("Exception in getting CUSTOMER_ID"+e);
			e.printStackTrace();
		}
		
		try
		{
		pstmt=con.prepareStatement("SELECT MISC_RCPT_TYPE_FOR_MED_REP FROM   BL_PARAMETERS WHERE  OPERATING_FACILITY_ID = '"+facilityid+"' ");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				misc_rcpt_type =  rs.getString(1);	
			}
		}
		System.out.println("query returned value misc_rcpt_type "+misc_rcpt_type);
		if(misc_rcpt_type  == null) misc_rcpt_type ="N";			
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY MISC_RCPT_TYPE_FOR_MED_REP:"+e);
			e.printStackTrace();
		}
		

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
		System.out.println("Inside pkgAmount"+pkgAmount);
		System.out.println("Inside tot_package_amt"+ tot_package_amt);
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
							System.out.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
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
						while(stTokpkgCode.hasMoreTokens()){;
							String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
							String packseqnoNoDelimiter=stTokSeqNo.nextToken();
							String blng_class_token = "";
							
							HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
							if(parDepMap != null){
								blng_class_token = parDepMap.get("blngClassCode");
							}
							
							boolean validPartialDepositCase=	par_dep_bean.checkValidPartialDepositCase(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, blng_class_token, con);
							System.out.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
							//If the Case is a Valid PartialDeposit Case Add PartialDeposit otherwise add Deposit Amount to it
							if(validPartialDepositCase){
								if(pkgAmount.equals("")){
									partDepAmtTemp=	par_dep_bean.getPartialDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
									minDepAmtTemp = par_dep_bean.getMinimumDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								}else{						//Note the Package Amount is  considered here
									StringTokenizer stTokPkgAmount=new StringTokenizer(pkgAmount,"^"); 
									String pkgAmountNoDelimiter=stTokPkgAmount.nextToken();
									System.out.println(pkgCodeNoDelimiter +"|"+packseqnoNoDelimiter +"|"+pkgAmountNoDelimiter );
									HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
									String blngClassCode = hashMapCode.get("blngClassCode");
									int encounterSequenceNo= 	par_dep_bean.getEncounterSequenceNo(patient_id,packseqnoNoDelimiter, con);
									partDepAmtTemp=		par_dep_bean.calculatePartialDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
									minDepAmtTemp = par_dep_bean.calculateMinimumDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
								}
								partialDepositAmount+=partDepAmtTemp;
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
					}
					
		
					pkgAmount=partialDepositAmount+"^";
					tot_package_amt=partialDepositAmount+"^";
					d_tot_package_amt = partialDepositAmount;
					tot_min_dep_amt = minDepAmount;
					
					System.out.println("BLEnterReceiptRefundDtl.jsp partialDepositAmount:"+ partialDepositAmount);
					}

		}  
		}
		/*Karthik added the below code for Partial Deposit - ends MMS-CRF-0023*/
		
		HashMap  support_data = bean1.getSupportData();		
		HashMap  mult_slmt_vals = bean1.getMultSlmtVals();	
		//System.out.println("support_data: "+support_data);
		if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{			
		 if(support_data!=null && support_data.size()>0)
		 {			
			doc_amt = (String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="0";	
			//System.out.println("doc_amt 123:"+doc_amt);
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
				
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
				</script>
	<%				}
				if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
				{	
	%>				<script>alert('<%=str_error_text%>');
				//window.parent.returnValue="Y";
				//window.close();
				let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "Y";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
				
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
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
		
		<script>
		
		$(document).ready(function(){
			
		//added by Vijay for bill generation patient deposit collection  
			
			if($('#called_from').val()=='bill_generation')
				{
				
			$('#receipt_nature_code').val('AD');
			$('#receipt_nature').val('Patient Deposit');
			$('#receipt_nature_code').attr('readonly','readonly');
			$('#receipt_nature').attr('readonly','readonly');
			$('#rec_ref').attr('disabled','disabled');
			$('#dep_type').attr('disabled','disabled');
			$('#depest').hide();
			$('#dep_type').val('N');
			$('#receiptNatureBtn').attr('disabled','disabled');
				
				}
			//ends-------------
			var formObj=document.EnterReceiptRefundForm;
		$('#customerid').hide();
		$('#cus_id').hide();
			$("#spldep").attr("disabled", "disabled");
			$("#doc_number").attr("disabled", "disabled");
			$("#doc_num").attr("disabled", "disabled");
			$("#documnumber").attr("disabled", "disabled");
			$("#doc_btn").attr("disabled", "disabled");
			//$("#rec_ref option[value*='F']").prop('disabled',true);	
			//$("#dep_type option[value*='K']").prop('disabled',true);
			$('#reference').attr("disabled","disabled");
			$('#request_id').hide();
			$("#reqcheck").val("N");
			$('#reqlabel').hide();	
			$('#accountcode').hide();
			$('#act_code').hide();
			$('#deptcode').hide();
			$('#deptdesc').hide();
			$("#dept_btn").hide();
			$("#cusmandatory").hide();
			//$("#document_number1").hide();
			//$("#doclabel").hide();
			$("#stlmt_amount").val("")	;
			$("#dep_type option[value*='K']").remove();
		
			
			//parent.frames[1].document.forms[0].stlmt_amount.value="";
				
			//var episode_type = formObj.episode_type.value;
		/*	if($("#episode_type").val()=="O" || $("#episode_type").val()=="R")
				{
			
				$("#dep_type option[value*='K']").prop('disabled',true);
				//$("#dep_type option[value*='S']").prop('disabled',true);
				//$("#dep_type option[value*='N']").prop('disabled',true);
				$("#dep_type option[value*='T']").prop('disabled',true);
				$("#dep_type option[value*='O']").prop('disabled',true);
				$("#dep_type option[value*='A']").prop('disabled',true);

				}*/
				
			
			if($('#cusid').val()=="SHALM" || ($('#cusid').val()=="MOHBR"))
				{
				
				$('#act_code').show();
				$('#accountcode').show();
				$('#deptcode').show();
				$('#deptdesc').show();
				$("#dept_btn").show();
					
				}
			
				else
				{
					
				$('#act_code').hide();
				$('#accountcode').hide();
				$('#deptdesc').hide();
				$('#deptcode').hide();
				$("#dept_btn").hide();
				
				}
								
					
			
			var episode_type="<%=episode_type%>";			
			$("#episode_typ option[value!='"+episode_type+"']").prop('disabled',true);
  
			$("#trdowntypeentry").hide();
			$("#totamt").hide();
			$("#paidamt").hide();		
			   $("#splAgnDep").hide();
			$("#totalbillamt").hide();
			$("#billpaidamt").hide();
			$("#depest").hide();	 
			$("#DownTimeEntry").change(function()
			{
				  
		 if ($(this).is(":checked"))
		    {				
				
				$("#trdowntypeentry").show();	

				if($('#rec_ref').val() == 'R'){
					$('#doc_type_number').val($('#receiptDownCode').val());
				}
				else{
					$('#doc_type_number').val($('#refundDownCode').val());
				}
			}	
				 
		 else
			{
				$("#trdowntypeentry").hide();
			}
		});	
			 
			$("#rec_ref").change(function() 
			{
				
				 if ($('#DownTimeEntry').is(":Checked"))
					 {
				
				if($('#rec_ref').val() == 'R'){
					$('#doc_type_number').val($('#receiptDownCode').val());
				}
				else{
					$('#doc_type_number').val($('#refundDownCode').val());
				}
					 }
				
				if($(this).val()!= "F") 
				{
					
					$("#doc_number").val('')
					$("#doc_num").val('');
					$("#documnumber").val('');
					$('#stlmt_amount').val(''); 
					
					$("#doc_number").attr("disabled", "disabled");
					$("#doc_num").attr("disabled", "disabled");
					$("#documnumber").attr("disabled", "disabled");
					$("#doc_btn").attr("disabled", "disabled");
				
					 $('#receipt_type_code').removeAttr('readonly');
					 $('#receipt_desc').removeAttr('readonly');
					$('#rec_type').removeAttr('disabled');
			
					$('#receipt_type_code').val('');
					 $('#receipt_desc').val('');  
					 
					 $('#receipt_nature_code').removeAttr('readonly');
					 $('#receipt_nature').removeAttr('readonly');
					 $('#receiptNatureBtn').removeAttr('disabled');
					 $('#dep_type').removeAttr('disabled'); 
					 
					 
				}
				else 
				 {    
					$("#doc_number").removeAttr("disabled");
					$("#doc_num").removeAttr("disabled");
				 	$("#documnumber").removeAttr("disabled");
				 	$("#doc_btn").removeAttr("disabled");
				 	$('#stlmt_amount').val(''); 
					 $('#receipt_type_code').attr('readonly', 'true');
					 $('#receipt_desc').attr('readonly', 'true');
					$('#rec_type').attr('disabled','disabled');

					$('#receipt_type_code').val('');
					 $('#receipt_desc').val('');
					$('#remarks').val('');
					 //$('#dep_type').attr('disabled','disabled');
					 
				 }
		});		
				
			  $("#rec_ref").change(function() 
			  {
					recref();
							
		});
			/*	$("#receipt_nature_code").blur(function() 
				{
					
					recref();
					
									
		}); */
		
				$("#receipt_type_code").blur(function() 
						{
							if($("#rec_ref").val()!="F")
								{
					remark();
								}
											
				}); 	
				
		});
		</script>
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
				System.out.println("Exception from QRY bl_package_enabled_yn:"+e);
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
						isDfltPkgRcptTypeSetup = true;   //Added by NamrataCharate for TH-KW-CRF-0156
					}
				if(rcpt_type_code == null) rcpt_type_code="";			
				if(rcpt_type_long_desc == null) rcpt_type_long_desc="";			
				pstmt2.close();
				if(rs3!=null) rs3.close();			
				}catch(Exception e){
					System.out.println("Exception in receipt type simple:"+e);
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
				call12 = con.prepareCall("{ call  blpackage.getpackagepricedtls(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
%>		
<script>
		//window.parent.returnValue="Y";
		//window.close();
		let dialogBody = parent.parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = "Y";
		
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
		</script>
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
			st_blng_class = new StringTokenizer(blng_class,"^");
			if("Associate".equals(modeOfCall)){
				if(st_pkgamt.hasMoreTokens()){
					pkg_amt_token = st_pkgamt.nextToken();	
					d_tot_package_amt = d_tot_package_amt+Double.parseDouble(pkg_amt_token);
					float minDepAmtReq = 0;
					try{
						minDepAmtReq = Float.parseFloat(request.getParameter("minDepAmtReq"));
					}
					catch(Exception eMin){
						minDepAmtReq = 0;
					}
					tot_min_dep_amt = minDepAmtReq;
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
			String sqlQ=" select nvl(DOWNTIME_ENTRIES_ALLOW_DAYS,0), DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE  from bl_parameters where operating_facility_id = '"+facilityid+"'";
			pstmt = con.prepareStatement(sqlQ);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strDownTimeAllowDays  =  rs.getString(1);	
				   receiptDownCode = rs.getString("DOWNTIME_RECEIPT_DOC_TYPE");
				   refundDownCode = rs.getString("DOWNTIME_REFUND_DOC_TYPE");
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

				/*String recauth=null;
				pstmt=con.prepareCall("select Distinct RECEIPT_AUTH_YN from bl_users_for_credit_auth where operating_facility_id = '"+facilityid+"' AND upper(credit_auth_user_id) = upper('"+strloggeduser+"')");	
					//rs=pstmt.execute();
					 rs = pstmt.executeQuery();	
						if( rs != null ) 
						{
							if( rs.next() )
							{			
								recauth  =  rs.getString(1);	
							}
						}
						System.out.println("query returned value recauth "+recauth);*/
				/*	if(recauth.equals("N"))
					{*/
			%>
						<!-- alert(getMessage("BL1260","BL")); 
						 window.close();
					</script>-->
			<%		//}
		

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
			/*if(function_id.equals("PKG_BILLING"))
			{
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='PK' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
			}else{*/
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='AD' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
			//}		
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
	
	 /*document.getElementById("depest").onclick = function () {
	
		 location.href = "EstimateForDeposit.jsp";
	    };
	   */ 
	async function estdep()
{
		 // alert('episode_id'+episode_id);

	var formObj=document.EnterReceiptRefundForm;
	var patient_id=formObj.patient_id.value;
	var episode_id=formObj.episode_id.value;
	var episode_type=formObj.episode_type.value;
	var encounter_id=formObj.encounter_id.value;
	var visit_id=formObj.visit_id.value;
	
	
	var url="../../eBL/jsp/Esmfordeposit.jsp?patient_id="+patient_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&visit_id="+visit_id;
	
	var dialogHeight= "55vh" ;
	var dialogWidth	= "86vw" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var retVal =await window.showModalDialog(url,null,features);  
	var stlmt_amnt=formObj.stlmt_amount.value;
	if(retVal=='undefined' || retVal==undefined)
		{
		formObj.stlmt_amount.value =stlmt_amnt;
		}
	else
		{
	formObj.stlmt_amount.value = retVal;
		}
	
}
	async function splAgencyDeposit()
	{
		//alert("splAgencyDeposit call");
		
		if($("#cusid").val()=="SHALM" || $("#cusid").val()=="MOHBR")
			{
		if(document.getElementById("dept_desc").value==null || document.getElementById("dept_desc").value=="" ){
			alert("Department code cannot be blank");
			return;
		}
			}
		var facilityId=document.forms[0].facility_id.value;
		var patientId=document.forms[0].patient_id.value;
		var episodeType=document.forms[0].episode_type.value;
		
		//alert("facilityId / patientId / episodeType ::: "+facilityId+" / "+patientId+" / "+episodeType);
		
		var url="../../eBL/jsp/SplAgencyDeposit.jsp?facilityId="+facilityId+"&patientId="+patientId+"&episodeType="+episodeType+"&effFromDt="+document.forms[0].splAgnEffFrom.value+"&effToDt="+document.forms[0].splAgnEffTo.value;
		
		var dialogHeight= "30" ;
		var dialogWidth	= "65" ;													   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
		var retVal =await window.showModalDialog(url,null,features);  
		//alert("retVal"+retVal);
		var dataArr = $.trim(retVal).split("::"); 	
		document.forms[0].splAgnEffFrom.value=dataArr[1];
		document.forms[0].splAgnEffTo.value=dataArr[2];
		
			
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
					document.forms[0].doc_type_number.value=arr[0];				
					document.forms[0].document_number.value=arr[1];				  
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
			//alert(retArray[0]);
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
			//alert(retArray[0]);
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
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
		
	sql3="select receipt_type_code code,long_desc description from bl__lang_vw where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and ADDED_FACILITY_ID = '"+facility_id+"' and RECPT_NATURE_CODE='AD' and(('"+ext_acc_int_YN+"' = 'Y' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code ='AD' and nvl(status,'X') <> 'S'	and (('AD' not in ('BI','DC') and episode_type IN ('U','"+episode_type+"') and category IN ('"+reln_code+"','UNRESTRICTED'))))) or '"+ext_acc_int_YN+"' = 'N')";
	*/

			sql3="select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"')  and ACC_ENTITY_CODE in (select ACC_ENTITY_ID from   SM_ACC_ENTITY_PARAM_FACL where FACILITY_ID ='"+facility_id+"' ) and RECPT_NATURE_CODE='AD' and(('"+ext_acc_int_YN+"' = 'Y' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code ='AD' and nvl(status,'X') != 'S'	and (('AD' not in ('BI','DC') and episode_type IN ('U','"+episode_type+"') and category IN ('"+reln_code+"','UNRESTRICTED'))))) or '"+ext_acc_int_YN+"' = 'N')";


		//}

		sql = escape(sql3);	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
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
				//alert(retVal[1]);
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
				
					//var pkgAmount=document.forms[0].pkgAmount.value;	ram				 
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
	
<%
	System.err.println("Function_id in BLDepositRefund.jsp: "+function_id);
	System.err.println("dfltRcptTypeForDeposit in BLDepositRefund.jsp: "+dfltRcptTypeForDeposit);
	if(dfltRcptTypeForDeposit){
%>	
<BODY onLoad="defaultReceipttype('rcptnature');" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<% 
	}
	else
	{
%>
<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<%
	}
%>
<!--  onLoad="setDepType();" -->
<FORM name='EnterReceiptRefundForm' id='EnterReceiptRefundForm' action="" method=''>	

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
		<table>
		<tr>
		 <td class="label" width="2%"><fmt:message key="eBL.DownTimeEntry.label" bundle="${bl_labels}"/>
		<input type="checkbox" id='DownTimeEntry' name="DownTimeEntry" id="DownTimeEntry" value=''  >	</td>
		</tr>
		</table>
		<table>
		<tr name="trdowntypeentry" id="trdowntypeentry">
		<td class="label" width="2%"><fmt:message key="eBL.DocumentNo.label" bundle="${bl_labels}"/>
		</td>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<td  width="5%"> 
		<input type='text' name='doc_type_number' id='doc_type_number' id='doc_type_number' size='10' maxlength='30'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(document_number,doc_type_number,2,1); } else{ fnClearCode(document_number); }"   >		 
		 <label><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>
		<input type='text' name='document_number' id='document_number' id='document_number' size='10' maxlength='8' onkeypress='return checkAlpha(event);' onBlur='checkForNumber(this)' value=''  onBlur='' ><input type='button' class='button' name="docnumber" id="docnumber"   value='?'  tabindex='0' onClick="callCommonLookupCode(document_number,doc_type_number,2,2);"><img src='../../eCommon/images/mandatory.gif'>					 
		</td>
		<td class="label" width="2%"><fmt:message key="eBL.DepositDate.label" bundle="${bl_labels}"/>
		 </td>
		 <td width="5%" >
		 <input type='text' name='deposit_date' id='deposit_date' size='17' maxlength='22'  value=''  onBlur='isValidDateTime(deposit_date);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('deposit_date','dd/mm/yyyy','hh:mm');" >		 		
		<img src='../../eCommon/images/mandatory.gif'>		
		</td>
		 <td class="label" width="2%"><fmt:message key="eBL.DepositReason.label" bundle="${bl_labels}"/>
		</td>
		 <td width="3%" >
		 <input type='text' name='deposit_reason' id='deposit_reason' size='10' maxlength='30'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(dep_reason,deposit_reason,3,1); } else{ fnClearCode(dep_reason); }">			 		
		<input type='text' name='dep_reason' id='dep_reason' size='10' maxlength='30'  value=''  onBlur=''><input type='button' class='button' name="reason" id="reason"   value='?'  tabindex='0' onClick="callCommonLookupCode(dep_reason,deposit_reason,3,2);"><img src='../../eCommon/images/mandatory.gif'>					 
		</td>			 				
		</tr>			
		<br/><br/>								
		<tr>	
		 <td class="label" width="2%"><fmt:message key="eBL.REC_NATURE.label"	bundle="${bl_labels}"/></td>	 
		 <!-- Modified by Manivel N on 16-08-22 for TH-KW-CRF-0156 -->
		<td width="5%" class="fields">
			<input type='text' name='receipt_nature_code' id='receipt_nature_code'  size='10' maxlength='22'  value=''  onBlur="if(this.value!=''){callCommonLookupCode(receipt_nature,receipt_nature_code,5,1);if(document.forms[0].rec_ref.value == 'R') defaultReceipttype('rcptnature') } else{ fnClearCode(receipt_nature); }" >	
			
			<input type='text' name='receipt_nature' id='receipt_nature'  size='10' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(receipt_nature,receipt_nature_code,5,2); } else{ fnClearCode(receipt_nature_code); };if(document.forms[0].rec_ref.value == 'R') defaultReceipttype('rcptnature');" ><input type='button' class='button' name="receiptNatureBtn" id="receiptNatureBtn"  value='?'  tabindex='0' onClick="callCommonLookupCode(receipt_nature,receipt_nature_code,5,2);if(document.forms[0].rec_ref.value == 'R') defaultReceipttype('rcptnature');">				 	
		</td>
		<td class="label" width="2%"><fmt:message key="eBL.RECEIPT_REFUND.label"	bundle="${bl_labels}"/>
		</td>
		 <td id="rec_refund" width='3%' class="fields">
		 <select name='recpt_refund_ind' id='rec_ref' >
		 <option value='R'>Receipt</option>
						
							-------
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							-------  
						</option>
								<option value='F'>Refund</option>
						</option>
				</select></td>
		 
	 	 		 	
		 		 <td class="label" width="2%"><fmt:message key="eBL.RECEIPT_TYPE.label"	bundle="${bl_labels}"/>
		</td>
		<td class="fields" width="5%">
			<input type='text' name='receipt_type_code' id='receipt_type_code'  size='05' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(receipt_desc,receipt_type_code,1,1); } else{ fnClearCode(receipt_desc); } ">
			
			<input type='text' name='receipt_desc' id='receipt_desc'  size='17' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(receipt_desc,receipt_type_code,1,2); } else{ fnClearCode(receipt_type_code); }">
			
			<input type='button' class='button' name="rec_type" id="rec_type"  value='?'  tabindex='0' onClick="callCommonLookupCode(receipt_desc,receipt_type_code,1,2)">
		</td> 									
		</tr>
		<tr>
		<td class="label" width="2%"><fmt:message key="Common.remarks.label"	bundle="${common_labels}"/></td>
		<td width="5%" class="fields"><input type="text" name="remarks" id="remarks" size="20" maxlength="30"  value=''  onBlur="">
		</td>
		
		
		<td class="label" width="2%"><fmt:message key="eBL.DEPOSIT_TYPE.label"	bundle="${bl_labels}"/></td>
			<td width='3%' class="fields">
				<select name='dep_type' id='dep_type' id='dep_type' onChange="deptypecheck();" >
				<option value='A'><fmt:message key="eBL.ADM_DEP.label" bundle="${bl_labels}"/></option>
				<option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				<option value='T'><fmt:message key="eBL.TRN_DEP.label" bundle="${bl_labels}"/></option>
				<option value='O'><fmt:message key="eBL.OTH_DEP.label" bundle="${bl_labels}"/></option>
				<option value='K'><fmt:message key="eBL.PKG_DEP.label" bundle="${bl_labels}"/></option>
				<option value='S'><fmt:message key="eBL.DepositAgainstSurgery.label" bundle="${bl_labels}"/></option>
				</select>
				</td>
				
		<td width="2%" class="label" id='reqlabel' ><fmt:message key="eBL.requestid.label" bundle="${bl_labels}"/>
	</td>
	<td class="fields" width="5%" id='request_id'><input type='text' name='reqid' id='reqid'  size='07' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(req,reqid,7,1); } else{ fnClearCode(stlmt_amount); }"><input type='button' class='button' name="requestid" id="requestid"    value='?'  tabindex='0' onClick='callCommonLookupCode(req,reqid,7,2);'>	
	</td> 	
	
		
				
		 
		</tr>
		<tr>
	 <td width="2%"  class='label' ><fmt:message key="eBL.BookingReference.label"	bundle="${bl_labels}"/>
  </td>
	<td width="5%" class="fields"><input type='text' name='reference' id='reference' size='20' maxlength='30'  value=''  onBlur="">
	</td>	
	
	<td class="label"  width="2%"><fmt:message key="Common.amount.label"	bundle="${common_labels}"/>
	</td>
	<td width="5%" class="fields"><input type='text' name='stlmt_amount' id='stlmt_amount'  size='15' maxlength='15'  value='' style='text-align:right' onKeyPress='return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))' onBlur='checkForNumber(this);putdeci(this);setAmt(this);stlmt_amountcheck();'>
	</td>
		<td width="2%"  class='label' id='customerid' ><fmt:message key="Common.Customer.label"	bundle="${common_labels}"/>
 		</td>
		<td width="5%" class="fields" id='cus_id'><input type='text' name='customer_code' id='customer_code'  size='05' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(customer_name,customer_code,4,1); } else{ fnClearCode(customer_name); }" >		
		<input type='text' id='customer_name' name='customer_name' size='17' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(customer_name,customer_code,4,2); } else{ fnClearCode(customer_code); }" ><input type='button' class='button' name="reason" id="reason"  value='?'  tabindex='0' onClick="callCommonLookupCode(customer_name,customer_code,4,2);"><td id='cusmandatory'><img  src='../../eCommon/images/mandatory.gif'></td>					 	
		</td>		
	
 	</tr>
<tr>	
	 <td width="2%" class="label" id='accountcode' ><fmt:message key="eBL.ACCOUNT_CODE.label" bundle="${bl_labels}"/>
		 </td>
		 <td width='5%' class="fields" id='act_code'><input type='text' name='ext_acc_code' id='ext_acc_code' id='ext_acc_code' size='15' maxlength='15'  value='' onBlur="" >
		 </td>
		 
	 <td width='2%' class='label'id='deptcode'><fmt:message key="Common.department.label" bundle="${common_labels}"/>
		 </td>
		 <td width='5%' class="fields" id='deptdesc' ><input type='text' name='dept_desc' id='dept_desc' id='dept_desc' size='30' maxlength='45'  value=''   onBlur="if(this.value!=''){ callCommonLookupCode(dep_code,dept_desc,6,1); } else{ fnClearCode(dep_code); }" ><input type='button' class='button' name="dept_btn" id="dept_btn" id="dept_btn"  value='?'  tabindex='0' onClick='callCommonLookupCode(dep_code,dept_desc,6,2);'>
		 </td>	
	
</tr>
	<tr>
	 <tr>
	<td width="2%"  class='label' id='totamt'><fmt:message key="eBL.TotalBillAmount.label"	bundle="${bl_labels}"/>
  	</td>
	<td width="5%" class="fields" id='totalbillamt'>	
	<input type='text' name='totalbillamt' id='totalbillamt'  size='17' maxlength='30'  value=''  onBlur="">
	</td>	
	<td class="label" id="paidamt" width="2%"><fmt:message key="eBL.BillPaidAmount.label"	bundle="${bl_labels}"/>
	</td>
	<td width="5%" class="fields" id='billpaidamt'>
	<input type='text' name='billpaidamt' id='billpaidamt'  size='17' maxlength='30'  value=''  onBlur="">
	</td>
	<td class="label" width="2%" id='doclabel'><fmt:message key="eBL.OriginalDocNo.label" bundle="${bl_labels}"/></td>
		<td width="5%" id='document_number1'>
		<input type='text' name='doc_number' id='doc_number' id='doc_number' size='10' maxlength='30'  value=''  onBlur="" readonly >		
		<label id='slash1'><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>		
	 	<input type='text' name='doc_num' id='doc_num' id='doc_num' size='10' maxlength='30'  value=''  onBlur=""readonly >					 
		<label id='slash2'><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>		
		<input type='text' name='documnumber' id='documnumber' id='documnumber' size='10' maxlength='30'  value=''  onBlur="" readonly >		
		<input type='button' class='button' name="doc_btn" id="doc_btn" id="doc_btn"  value='?'  tabindex='0' onClick='originaldocnum();'>
		</td>					
	</tr></table>
			<table>
 	 <tr>
	  <td width="5%">
	  <input type='button' class='button' name="depest" id="depest" id='depest'   value=' Estimate For Deposit'  tabindex='0' onClick="estdep();">
	  <input type='button' class='button' name="splAgnDep" id="splAgnDep" id='splAgnDep'   value=' Special Agency Deposit'  tabindex='0' onClick="splAgencyDeposit();">
	</td>
	<td class="label" width="2%"><fmt:message key="eBL.THRU_MAIL.label"	bundle="${bl_labels}"/>
	
	<input type='checkbox' name='thru_mail' id='thru_mail' size='5'  maxlength='5' value="" onclick=""></td>		
	
	 </tr> 
	</table>
	</table>
	
	
	<input type= 'hidden' name="downTimeAllowDays" id="downTimeAllowDays"  value="<%=strDownTimeAllowDays%>">
	<input type= 'hidden' name="medrep_pay_int_mode" id="medrep_pay_int_mode" id="medrep_pay_int_mode"  value="<%=medrep_pay_int_mode%>">
	<input type= 'hidden' name="misc_rcpt_type" id="misc_rcpt_type" id="misc_rcpt_type"  value="<%=misc_rcpt_type%>">
	<!--  <input type='hidden' name='depcount' id='depcount'  id="depcount"  value="<//%=depcount %>" 
	<input type='hidden' name='depreturn' id='depreturn' id="depreturn" value="<//%=depreturn %>"-->
	
	
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
	<input type= 'hidden' name="dep_code" id="dep_code" id="dep_code" value="">		
	<input type= 'hidden' name="req_id" id="req_id" id="req_id" value="">		
	<input type= 'hidden' name="tdentry" id="tdentry" id="tdentry" value="">		
	

	<input type= 'hidden' name="patient_id" id="patient_id" id='patient_id' value="<%=patient_id%>">	
	
	<input type= 'hidden' name="episode_type" id="episode_type" id='episode_type'  value="<%=episode_type%>">	
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
	 <input type='hidden' name='rec_nature_code' id='rec_nature_code' value='<%=strRecptNatureCode%>'  onBlur="">
		<input type='hidden' name='rec_nature' id='rec_nature' value=''  onBlur="">	 

	<input type= 'hidden' name="recptTypCode" id="recptTypCode"  value="<%=recptTypCode%>">	
	<input type= 'hidden' name="recptTypLongDesc" id="recptTypLongDesc"  value="<%=recptTypLongDesc%>">	

	<input type= 'hidden' name="splAgnDepYN" id="splAgnDepYN"  value="<%=splAgnDepYN%>">	
	<input type= 'hidden' name="splAgnDepChkYN" id="splAgnDepChkYN"  value="N">	
	<input type= 'hidden' name="splAgnEffFrom" id="splAgnEffFrom"  value="">	
	<input type= 'hidden' name="splAgnEffTo" id="splAgnEffTo"  value="">	
	<input type= 'hidden' name="cusid" id="cusid"  id='cusid' value="<%=strCustomerId %>">
		<input type= 'hidden' name="reqamount" id="reqamount"  id='reqamount' value="">
		<input type= 'hidden' name="reqcheck" id="reqcheck"  id='reqcheck' value="">
		  <input type= 'hidden' name="req" id="req" id="req" value=''> 
			  <input type= 'hidden' name="orgdoc_amt" id="orgdoc_amt" id="orgdoc_amt" value=''> 
						  <input type= 'hidden' name="orgdoc_type" id="orgdoc_type" id="orgdoc_type" value=''> 
			  <input type= 'hidden' name="orgdoc_num" id="orgdoc_num" id="orgdoc_num" value=''> 
			  <input type= 'hidden' name="orgdoc_srno" id="orgdoc_srno" id="orgdoc_srno" value=''> 
	
	<input type='hidden' name='refundDownCode' id='refundDownCode' id='refundDownCode' value='<%=refundDownCode %>'>
	<input type='hidden' name='receiptDownCode' id='receiptDownCode' id='receiptDownCode' value='<%=receiptDownCode %>'>
	<input type='hidden' name='called_from' id='called_from' id='called_from' value='<%=calledFrom %>'>


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

