<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
1-Dec-2014     100           	Karthikeyan.K       GHL-CRF-0366.1 Karthik Created this File code for Credit Card Integration   
---------------------------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*, eXH.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>


<%

	request.setCharacterEncoding("UTF-8");   

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        
	//Added by prithivi on 28/02/2017 for MMS-DM-SCF-INT-0004/63556 CC-auto
	Connection conn = null;	
	Boolean ccAutoPluginFlag=false;
	String ccAutoEnabled="false";
	boolean isDebugYN = false; 

	try
	{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		conn = ConnectionManager.getConnection();	
		ccAutoPluginFlag = eCommon.Common.CommonBean.isSiteSpecific(conn, "XH","CC_AUTO_PLUGIN_ENABLED");
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Auto Plugin Flag..."+ccAutoPluginFlag);

		if(ccAutoPluginFlag)
		{
			ccAutoEnabled = "true";
		}
		else
		{
            ccAutoEnabled = "false";
		}
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Auto Enabled..."+ccAutoEnabled);

	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("***Inside Credit Card Interface Validation - Exception while checking Auto Plugin Flag... "+e);
	}
	finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Conection closed");
	}
	
	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
	
	System.out.println("*****************************************");

	String sqlStatement = "";
	int ccAppletCount = 0;
	String slmttype = request.getParameter("slmttype").substring(0,2);
	
	System.out.println("***Inside Credit Card Interface Validation - Settlement Type... "+isDebugYN);

	if(isDebugYN)
		System.out.println("***Inside Credit Card Interface Validation - Settlement Type... "+slmttype );

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	try {

		conn = ConnectionManager.getConnection();

		sqlStatement = "select count(*) applet_count from SM_FUNCTION_CONTROL a, sm_site_param b "
							+ "	where a.MODULE_ID = ? and a.FUNCTIONALITY_ID like '%CREDITCARD%' and a.SITE_ID = b.customer_id "
							+ "	and a.KEY_1 = ? AND VALUE_1 = 'Y' ";
		pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1,"XH");
		pstmt.setString(2,slmttype);

		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				ccAppletCount = rs.getInt("applet_count");
			}
		}
		
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - SQL... "+sqlStatement+" ***Applet Count  : "+ccAppletCount);
	}
	catch (Exception e){
		System.out.println("***Inside Credit Card Interface Validation - Exception in fetching CC Applet "+e );
	}
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();	
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Conection closed");		
	}


	sqlStatement = "";

	pstmt		= null;
	rs			= null;

	String loggedInUser = XHDBAdapter.isNullReplace(request.getParameter("loggeduser"),"*");
	String respID = XHDBAdapter.isNullReplace(request.getParameter("responsibility_id"),"*");
	String funcID = XHDBAdapter.isNullReplace(request.getParameter("function_id"),"*");

	String strApplicationId = "";
	
	if(isDebugYN)
		System.out.println(" ***Inside Credit Card Interface Validation - Settlement Type... "+slmttype+" ***Logged in User "+loggedInUser+" ***Responsibility ID... "+respID+" ***Function ID... "+funcID );


	try {

		conn = ConnectionManager.getConnection();

		sqlStatement = "SELECT external_application,key_2 FROM xh_filter_dms_vw WHERE "
						+ " login_user = (decode(login_user, '*', login_user, ?)) "
						+ " AND responsibility = (decode(responsibility, '*', responsibility, ?)) "
						+ " AND login_function = (decode(login_function, '*', login_function, ?)) "
						+ " AND key_1 = (decode(key_1, '*', key_1, ?)) ";

		pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, loggedInUser);
		pstmt.setString(2, respID);
		pstmt.setString(3, funcID);
		pstmt.setString(4, slmttype);

		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				strApplicationId = rs.getString("external_application");
			}
		}

		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Credit Card Application query... "+sqlStatement+" ***Application ID... "+strApplicationId);
	}
	catch (Exception e){
		System.out.println("***Inside Credit Card Interface Validation - Exception in Fetching CC Application ID... "+e);
	}
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();	
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Sethu Validation - Conection closed");		
	}
		
	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	

	
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript"src="../../eXH/js/ExternalApplication.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%

%>

<script>
	/*
	function window.confirm(str) {
	    execScript('n = msgbox("' + str + '","4132")', "vbscript");
	    return (n == 6);
	}
	*/

	$(document).ready(function () {
		alert("Inside Validate ");
		validate();
	});
	

 	function validate()
	{
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp';	
		
		var formName= parent.frames[0].document.forms[0];
		var dataElements="";
		dataElements+="P_patient_id="+formName.patientid.value;
		dataElements+="&P_episode_ID="+formName.episodeid.value;
		dataElements+="&P_settlement_type="+(formName.slmttype.value).substring(0,2);
		dataElements+="&P_trn_type="+formName.trn_type.value;
		dataElements+="&p_doc_date="+formName.p_doc_date.value;
		dataElements+="&P_Bill_Doc_Type="+formName.billdoctypecode.value;
		dataElements+="&P_Bill_Doc_Num="+formName.billdocnum.value;
		//dataElements+="&P_Total_Bill_Amount="+formName.total_amt_payable.value;// Commented by Sethu for NMC-JD-SCF-0044 ON 13/05/2020
		dataElements+="&P_Total_Bill_Amount="+formName.billslmtamt.value; // Added by Sethu for NMC-JD-SCF-0044 ON 13/05/2020
		dataElements+="&P_doc_amt="+formName.total_amt_payable.value;
		dataElements+="&P_Preapaid_Card_Number="+formName.prepaid_card_number.value;
		dataElements+="&P_Reciept_Date="+formName.p_doc_date.value;
		dataElements+="&P_USER_ID="+formName.loggeduser.value;
		dataElements+="&P_RESP_ID="+formName.responsibility_id.value;
		dataElements+="&P_FACILITY_ID="+formName.facilityid.value;
		dataElements+="&P_MODULE_ID="+formName.moduleid.value;
		dataElements+="&P_FUNCTION_ID="+formName.function_id.value;
		dataElements+="&P_LANGUAGE_ID="+formName.locale.value;
		dataElements+="&P_WS_NO="+formName.strclientip.value;
		dataElements+="&P_Trx_No="+formName.trn_number.value;
		dataElements+="&P_Ext_Input_Key="+formName.ext_input_key.value;
		dataElements+="&P_Ext_Application_ID="+formName.ext_application_id.value;
		dataElements+="&P_Ext_Function="+formName.ext_function.value;
		dataElements+="&P_PATIENT_NAME="+formName.slmtpayername.value;
		dataElements+="&P_Reciept_number="+formName.receipt_number.value;// changed

		//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019

		var creditCardForm=	parent.frames[1].document.forms[0];

		dataElements+="&P_Card_Status_YN="+creditCardForm.credit_card_status_yn.value;// changed
		dataElements+="&P_Card_Batch_ID="+creditCardForm.credit_card_batch_id.value;// changed
		dataElements+="&P_Card_Roc_No="+creditCardForm.credit_card_roc_no.value;// changed
		dataElements+="&P_Card_Trn_No="+creditCardForm.credit_card_trn_no.value;// changed
		dataElements+="&P_Trn_Status="+creditCardForm.credit_trn_status.value;// changed
		
		//Code ends for KDAH-CRF-0504.3 on 14/08/2019

		var ccAutoPluginFlag = this.document.forms[0].ccAutoEnabled.value;
		var outTimeVal = 100;

		if(ccAutoPluginFlag == "true")
		{
			outTimeVal = 12000;
			creditcardInterface2();
		}
		else
		{
		   outTimeVal = 100;
		} 
		
		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
		var ccAppletFlag = this.document.forms[0].ccAppletEnabled.value;
		var applicationId = this.document.forms[0].applicationID.value;
		dataElements+="&P_CCAppletEnabled="+ccAppletFlag;// changed

		//Added by Sethu for KDAH-CRF-0535 on 07/01/2020 Request Type Variable	
		dataElements+="&P_Request_Type="+creditCardForm.cc_request_type.value;// changed
		dataElements+="&P_Card_Urn_No="+creditCardForm.credit_card_urn_no.value;// changed

		setTimeout(function() 
		{ 
		
			//alert("**** ALERT FOR TESTING PURPOSE **** \n Input Parameters "+dataElements);

			var retVal = "";
			var arr = "";
			var ccResponse = "";

			var errMess = "<H5 style='color:blue'>Processing please wait...</H5>" +"<br>" ;
			parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;

			retVal = dispExtApp(dataElements);

			if (ccAppletFlag > 0)
			{
				ccResponse = creditCardApplet(retVal);

				if (applicationId == "SPECTRA")
				{
					retVal = ccResponse;
				}

				if (ccResponse!='' && ccResponse!=null && applicationId != "SPECTRA")
				{
					retVal = "";
					dataElements+="&RESPONSE_TEXT="+ccResponse+"&requestGUIType=AJAX";
					retVal = CreditCardResponse(dataElements);
				}
			}
		
			//var retVal = 'S$|#$|#Amount deducted$|#Test Payer$|#992836$|#7777801$|#XXXXXX$|#VISA$|#104793$|#15/12/2014$|#1234001$|#$|#$|#$|#HDFC';
			//var retVal ='S$|#Card has sufficient balance, Do you want  to proceed for Deduction of the amount?$|#$|#Mr. Sudhish Chandra Gupta$|#365$|#365$|#AA$|#WC$|#100033$|#01/01/2099$|#365$|#06/01/2015$|#113511$|#$|#WC';
			//alert("**** ALERT FOR TESTING PURPOSE **** \n Response "+ retVal );

			//S$|#Transaction Completed Succesfully...$|#$|#$|#107$|#14005$|#AA$|#WALLET$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#101731$|#$|#105
			//S$|#Transaction Completed Succesfully...$|#$|#MANU PRAKASH DEEP        / $|#44 $|#24242421 $|#AA$|#$|#461786******2913 $|#$|#0 $|#18/08/2015$|#170509$|#$|#01 
			//setTimeout(function() { 

			//retVal = "E$|#TRANSACTION INITIATED - CHECK GET STATUS$|#$|#$|#101$|#14005$|#AE$|#$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#094425$|#$|#105$|#13278492";

			//retVal = "S$|#Transaction Completed Succesfully...$|#$|#$|#107$|#14005$|#003439$|#WALLET$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#101731$|#$|#105$|#13278490!!";

			/*
				Fields
				1 - Process Status(response status from Walletree)
				2 - Process remarks(Error if any from Walletree)
				3 - Error Message while processing
				4 - Payer Name				
				5 - Sale Draft No
				6 - Retrieval Reference Number
				7 - Approval Code
				8 - Card Issuer Name/Card Type
				9 - CC No
				10 - Expiry Date (YYYYMMDD)
				11- Batch Number	
				12- Transaction Date(YYYYMMDD)
				13- Transaction Time(HH24MISS)
				14- NULL field
				15- Card Issued bank	
				16- Tracking ID
				17- Terminal ID	
			*/
			/* MMS Credit Card */
			//retVal = "S$|#Approved $|#$|#$|#400308022011   $|#632613221071$|#001322$|#SPAN$|#428331******6605$|#$|#00238$|#21-11-2016 13:22:43$|#$|#$|#$|#$|#$|#5675678";
			/* AMS Pine Labs Plutus Credit Card */
			//retVal = "S$|#Transaction Completed Succesfully...$|#$|#$|#15968$|#000000016763$|#002129$|#VISA$|#436389******2935$|#01/01/2099$|#714$|#09/11/2020$|#16:39:31$|#$|#01$|#21000108$|#41350447$|#";
			//retVal = "S$|#Transaction Completed Succesfully...$|#$|#$|#18291$|#000000019172$|#007976$|#VISA$|#436389******2935$|#01/01/2099$|#855$|#09/11/2020$|#161402$|#$|#01$|#21112614$|#41350440$|#";
			//retVal = "E$|#Read timed out$|#$|#$|#$|#$|#AE$|#$|#$|#01/01/2099$|#$|#$|#$|#$|#OTH";
			/* GHL Pine Labs Plutus Credit Card */
			//retVal = "S$|#Transaction Completed Succesfully...$|#$|#RAJINDER SINGH           /$|#000000000020$|#12856978$|#AA$|#MASTER$|#531849******1497$|#01/01/2099$|#4$|#14/06/2019$|#101412$|#$|#01";
			/* AMRI Error */
			//retVal = "E$|#Communication With EDC Failed - Check EDC Connectiom$|#$|#$|#$|#$|#AE$|#$|#$|#01/01/2099$|#$|#$|#$|#$|#OTH";
			//retVal = "S$|#Transaction Completed Succesfully...$|#$|#TMW FB MASTERCARD/$|#156579330974$|#SB8I9910$|#005644$|#MASTERCARD PIN@POS$|#531829xxxxxx4920$|#01/01/2099$|#000002$|#14/08/2019$|#200509$|#$|#OTH";
			
			if(retVal!='' && retVal!=null)
			{			
				arr = retVal.split("$|#");

				if (applicationId != "SPECTRA")
				{

					//Added by Sethu for KDAH-CRF-0504.4 on 14/08/2019

					var trn_no = arr[15];
					var batch_id = arr[10];
					var roc_no = arr[4];
					var trn_status = arr[1];
					var urn_no = "";
					
					creditCardForm=	parent.frames[1].document.forms[0];
					
					//Code Modified for KDAH-CRF-0535 on 07/01/2020
					var credit_card_status_yn = creditCardForm.credit_card_status_yn.value;
					if (applicationId == "WLCR")
					{
						urn_no = arr[17];						
					}

					var status_btn = parent.frames[0].document.getElementById('validate_cc_status');

					if (status_btn)
						status_btn.disabled = true;

					parent.frames[0].document.getElementById('show_button_status').style.display='inline';

					creditCardForm.credit_card_batch_id.value="";
					creditCardForm.credit_card_roc_no.value="";
					creditCardForm.credit_trn_status.value="N";

					//Code Modified for KDAH-CRF-0535 on 07/01/2020

					if (credit_card_status_yn == 'Y') 
					{
						if (applicationId == "PHONEPE")
						{					
							if (trn_status == "TRANSACTION INITIATED - CHECK GET STATUS") 
							{
								creditCardForm.credit_card_batch_id.value=batch_id;
								creditCardForm.credit_card_roc_no.value=roc_no;
								creditCardForm.credit_trn_status.value="Y";
								if (status_btn)
									status_btn.disabled = false;					
							}
						}
						else if (applicationId == "WLCR")
						{
							if (urn_no != null && urn_no != "")
							{
								creditCardForm.credit_card_urn_no.value = urn_no;
								creditCardForm.credit_trn_status.value="Y";
								if (status_btn)
									status_btn.disabled = false;		
							}
						}
						else
						{
							creditCardForm.credit_trn_status.value="Y";
							if (status_btn)
								status_btn.disabled = false;
						}
					}					
					
					creditCardForm.credit_card_trn_no.value=trn_no;

					//Code ends for KDAH-CRF-0504.4 on 14/08/2019
				}

				var errMess = "" ;
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;

				if (retVal.charAt(0)=='S' && arr[8] != null && arr[8] != "") 
				{	
					
					var card_no=arr[8]; 
					//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021
					//var expiry_date=arr[11];
					//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021
					var cc_trx_date=arr[11];
					var card_Transaction_date=arr[11]+" "+arr[12];
					var card_issued_bank=arr[14];
					var card_type=arr[7];
					var online_approval_batch_no=arr[10];
					var approval_code=arr[6];
					var sale_draft_no=arr[4];
					var tid_no=arr[16]; //var tid_no=arr[5];
					var payer_name=arr[3];	

					var rr_no = arr[5];

					creditCardForm =	parent.frames[1].document.forms[0];

					creditCardForm.credit_card_batch_id.value="";
					creditCardForm.credit_card_roc_no.value="";

					creditCardForm.instref.value=card_no;
					//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021
					//creditCardForm.instdate.value=expiry_date;
					//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021
					creditCardForm.instdate.value=cc_trx_date;
					creditCardForm.instremark.value=card_type;
					creditCardForm.instremarkcode.value=card_type;
					creditCardForm.batchno.value=online_approval_batch_no;
					creditCardForm.instbranch.value=card_issued_bank;		
					creditCardForm.payername.value=payer_name;				
					creditCardForm.recrefidno.value=rr_no;	//tid_no		
					creditCardForm.apprrefno.value=approval_code;				
					creditCardForm.saledraftno.value=sale_draft_no;	
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021
					creditCardForm.cc_term_id_num.value=tid_no;				
					creditCardForm.cc_trx_date_time.value=card_Transaction_date;

					parent.frames[3].document.forms[0].cancel_button.disabled=true;	
					
					$.ajax({
					   url:"../../eBL/jsp/BLCreditCardDetailsStorage.jsp",
					   type:'post',
					   data: {
							cardOperation: "storedata",
							P_patient_id:  formName.patientid.value ,
							P_episode_ID:  formName.episodeid.value ,
							P_settlement_type:  (formName.slmttype.value).substring(0,2) ,
							P_trn_type:  formName.trn_type.value ,
							p_doc_date:  formName.p_doc_date.value ,
							P_Bill_Doc_Type:  formName.billdoctypecode.value ,
							P_Bill_Doc_Num:  formName.billdocnum.value ,
							P_Total_Bill_Amount:  formName.total_amt_payable.value ,
							P_doc_amt:  formName.total_amt_payable.value ,
							P_Preapaid_Card_Number:  formName.prepaid_card_number.value ,
							P_Reciept_Date:  formName.p_doc_date.value ,
							P_USER_ID:  formName.loggeduser.value ,
							P_RESP_ID:  formName.responsibility_id.value ,
							P_FACILITY_ID:  formName.facilityid.value ,
							P_MODULE_ID:  formName.moduleid.value ,
							P_FUNCTION_ID:  formName.function_id.value ,
							P_LANGUAGE_ID:  formName.locale.value ,
							P_WS_NO:  formName.strclientip.value ,
							P_Trx_No:  formName.trn_number.value ,
							P_Ext_Input_Key:  formName.ext_input_key.value ,
							P_Ext_Application_ID:  formName.ext_application_id.value ,
							P_Ext_Function:  formName.ext_function.value ,
							P_PATIENT_NAME:  formName.slmtpayername.value , 
							//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021
							//cardData : card_no +'|'+ expiry_date+'|'+card_issued_bank+'|'+ card_type+'|' +online_approval_batch_no+'|' +approval_code+'|' +sale_draft_no+'|' +rr_no+'|'+payer_name
							//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021
							cardData : card_no +'|'+ card_Transaction_date+'|'+card_issued_bank+'|'+ card_type+'|' +online_approval_batch_no+'|' +approval_code+'|' +sale_draft_no+'|' +rr_no+'|'+payer_name+'|'+tid_no
						},
						success: function(data) 
						{
							var tmpSlmtType = formName.slmttype.value;
							var tmpSlmtTypeSub = tmpSlmtType.substring(0,2);
							if(tmpSlmtTypeSub == 'WC')
							{
								if (confirm(arr[1]) == true) 
								{
									
								} 
								else 
								{
									creditCardForm.instref.value='';
									creditCardForm.instdate.value='';
									creditCardForm.instremark.value='';
									creditCardForm.instremarkcode.value='';
									creditCardForm.batchno.value='';
									creditCardForm.instbranch.value='';		
									creditCardForm.payername.value='';				
									creditCardForm.recrefidno.value='';				
									creditCardForm.apprrefno.value='';				
									creditCardForm.saledraftno.value='';
									//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021
									creditCardForm.cc_term_id_num.value='';				
									creditCardForm.cc_trx_date_time.value='';
									parent.frames[3].document.forms[0].cancel_button.disabled=false;	
									
									$.ajax({
										url:"../../eBL/jsp/BLCreditCardDetailsStorage.jsp",
										type:'post',
										data: { cardOperation: "removedata"}
									});
									
								}
							}
						}
					 });			

				}
				else
				{	
					var errMess = "<H5 style='color:red'>"+arr[1]+"</H5>" +"<br>" ;
					parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
					return false;			
				}		
			}
			else
			{
				var errMess = "<H5 style='color:red'>Credit Card Transaction Declined.</H5>" +"<br>" ;
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
				return false;
			}
		}, outTimeVal );

	} 

	
</script>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="bl_creditcard_form" id="bl_creditcard_form" >
<input type="hidden" name="ccAutoEnabled" id="ccAutoEnabled" value='<%=ccAutoEnabled%>'>
<!--Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	-->
<input type="hidden" name="ccAppletEnabled" id="ccAppletEnabled" value='<%=ccAppletCount%>'>
<input type="hidden" name="applicationID" id="applicationID" value='<%=strApplicationId%>'>
</form>
</BODY>
</HTML>

