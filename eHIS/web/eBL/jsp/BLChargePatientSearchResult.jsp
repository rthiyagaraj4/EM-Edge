<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         	MOHE-CRF-0060       		   Shikha Seth
2            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
3			 V220801		34676   	BL-Deposit Receipt/Refund	       Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%--  JSP Page specific attributes start --%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
<script language="javascript" src="../../eBL/js/BLChargePatient.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"> </script>
<script language="javascript" src="../../eBL/js/BLChargePatient.js"></script>
<script language="javascript" src="../../eBL/js/BLChargePatientSearch.js"></script>
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>


<script>

async function callEncWin(encounter_date,encounter_id,patient_id,blng_grp_id,episode_id,visit_id,episode_type,payer_group,payer,policy,policyNum,acctSeq,encounterFacilityId,encPatID,encEncID) //V220412
{  
	var funct_name = parent.search_frame.document.report_form.funct_name.value;
	var destPage = "";
	var status=true;
	if(funct_name == 'BillGeneration'){
		var facility_id=$("#facility_id").val();
		var result = '';
		var params = 'facilityId='+facility_id+
						'&episodeType='+episode_type+
						'&patientId='+patient_id+
						'&episodeId='+episode_id+
						'&visitId='+visit_id;
		//V220412
		$.ajax({
			type:"POST",
			url:"../jsp/BillReceiptAjax.jsp?calledFrom=validateCashCounter",
			data:params,
			dataType:"json",
			async:false,
			success: function(data){
				<%
				session.removeAttribute("pkgClosedYN");
				session.removeAttribute("pkgSeqNum");
				if(session.getAttribute("pkgClosedYN")==null){
				session.setAttribute("pkgClosedYN","");
				session.setAttribute("pkgSeqNum","");
				}
				  %>
				if(data.errorId != ''){
					alert(getMessage(data.errorId,'BL'));
					status = false;
				}
				if(status && data.errorText != ''){
					alert(data.errorText);
					status = false;
				}
				if(status && data.ipFlag == 'Y'){
					alert(getMessage('BL00942','BL'));
				}		
				if(status && data.deceasedYn == 'Y'){
					alert(getMessage('BL00943','BL'));
				}
				
			},
			 error: function(data){
				// alert(data);		 
		      }
		});
		destPage = "../../eBL/jsp/BillReceiptMainFrame.jsp?";
	}
	else if(funct_name == 'depositandrefund'){
		var facility_id=$("#facility_id").val();
		var pat_id=patient_id;
		
		var check="";
		$.ajax({
				type : 'POST',
				url : "../jsp/BlDepositremarks.jsp?&func_mode=dischargecheck&facility_id="
					+ facility_id
					+ "&episode_id="
					+episode_id
					+"&episode_type="
					+episode_type
					+ "&pat_id="
					+pat_id,
					async : false,
					dataType : "text",
					success : function(data) {
						check=trimString(data);
						if(check=="Y")
								{
								alert(getMessage("BL2205","BL"));
								status=false;

								}
						
							else
								{
								status=true;
									destPage = "../../eBL/jsp/BLDepositRefundFrame.jsp?";
								}
					}
			});		
		//destPage = "../../eBL/jsp/BLDepositRefundFrame.jsp?";
	}
	else{
		var facility_id=$("#facility_id").val();
	$.ajax({
			type:"POST",
			url:"../jsp/BLFutureOrder.jsp",
			data:" &patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&facility_id="+facility_id,	
			success: function(data){
			
				var data1=$.trim(data);
			
					if(data1=='Y'){
					alert(getMessage('BL9859','BL'));
				}
			},
			 error: function(data){
			alert("error");
		     }
		});
		
		destPage = "../../eBL/jsp/BLChargePatientEncounterFrame.jsp?";
	}
	
	if(status)
	{
		var url= destPage+"encounter_date="+encounter_date+"&blng_grp_id="+blng_grp_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&payerGroup="+payer_group+"&payer="+encodeURIComponent(payer)+"&policy="+policy+"&policyNum="+policyNum+"&acctSeqNum="+acctSeq+"&encounterFacilityId="+encounterFacilityId+"&patient_id="+encPatID+"&encounter_id="+encEncID+"&encoded=Y";//V220412 //38842
		var dialogHeight= "94vh" ;
		var dialogWidth	= "85vw" ;													   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
		var popupWindow;
		
		popupWindow = await top.window.showModalDialog(url,null,features);
		
		if(funct_name == 'BillGeneration'){
			

			if(popupWindow != undefined && popupWindow != 'undefined' ){
				var retValArr = popupWindow.split(':::');
				if(retValArr[0] == 'Y'){
					//if(parseInt(retValArr[3]) > 0){
						var center='1';
						var dialogTop = "0vh";//220
						var dialogHeight = "92vh" ;//100
						var dialogWidth = "90vw" ;//70
						var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
						var title=getLabel("eBL.BILL_SLMT_DTL.label","BL");
						title=encodeURIComponent(title);	
						var arguments = "" ;
						var column_sizes = escape("");               
						var column_descriptions ="";
						var param = "title="+title+
									"&"+"column_sizes="+column_sizes+
									"&"+"column_descriptions="+column_descriptions+
									"&"+"billdoctypecode="+retValArr[1]+
									"&"+"billdocnum="+retValArr[2]+
									"&"+"blnggrp="+blng_grp_id+
									"&episode_type="+episode_type+
									"&fromBillGen=Y"+
									"&userSlmtAmt="+retValArr[3]+
									"&encounterFacilityId="+encounterFacilityId;	//V210129 
						retVal= await top.window.showModalDialog("../../eBL/jsp/BLBillSlmtMainIRB.jsp?"+param,arguments,features);
						
					//}
					/* Commenting the old Settlement part 
					else{
						var dialogHeight    = '40' ;
						 var dialogWidth = '70' ;	
						 var dialogTop = '100' ;	 
						 var center    = '1'  ;	
						 var arguments =   '';
						 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';	

						 var doctype = retValArr[1];
						 var docnum = retValArr[2];
						 var blnggrp = blng_grp_id;
						 var genlater = 'Y';
						 var param="billdoctypecode="+doctype+"&"+"billdocnum="+docnum+"&"+"blnggrp="+blnggrp+"&"+"billgenlater="+genlater;
						 //alert(param)
						 var getUrl1  = "../../eBL/jsp/BLReprintPopupPage.jsp?"+param
						 //var getUrl1 = "../../eBL/jsp/BLChargePatientEncounterFrame.jsp?encounter_date=21/04/2014&encounter_id=101079180001&patient_id=DU00003900&blng_grp_id=CASH&episode_id=10107918&visit_id=1&episode_type=O&payerGroup=null&payer=null&policy=null&policyNum=null&acctSeqNum=1";

						 retVal = window.showModalDialog(getUrl1,arguments,features)
					} */
				}
				//$(parent.search_frame.document).find('#search_button').trigger('click');
			}
			parent.search_frame.document.getElementById('search_button').click();			
		}
	} 		
} 

$(document).ready(function(){
	var functName =  parent.search_frame.document.report_form.funct_name.value;
	parent.parent.dummyFrame.location.href= '../../eCommon/html/blank.html';
	if(functName != 'BillGeneration'){
		//added by Vijay for bill generation patient deposit collection		
		$('#depositcallhdr').hide();
		$('td[id^=depositcall]').each(function(){
		$(this).hide();
		});
		//ends ----
		
		$('td[id^=billGen]').each(function(){
			$(this).hide();
		});
	}
	else{
		var noOfDecimals = $('#noOfDecimals').val();
		$('td[id^=billGenC]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		if($('#episodeType').val() == 'R'){
			$('#depositcallhdr').hide();
			$('td[id^=depositcall]').each(function(){
				$(this).hide();
			});
		}
	}
});

</script>
<%!
public int returnInt(Object number){
	if(number==null|| number.equals("")){
		return 0;
	}
	else{
		return Integer.parseInt((String)number);
	}	
}

public double returnDouble(Object number){
	if(number==null|| number.equals("")){
		return 0;
	}
	else{
		return Double.parseDouble((String)number);
	}	
}

public String returnDateString(Object encounterDateValue) {	
	String eff_from_date="";
	if(encounterDateValue==null){
		return eff_from_date;
	}else{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Timestamp inputTimeStamp = Timestamp.valueOf(encounterDateValue.toString());
	long longTimeStamp = inputTimeStamp.getTime();
	eff_from_date=sdf.format(longTimeStamp);
	return eff_from_date;
	}
}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<%-- JSP Page specific attributes end --%>

<%
	Connection con = null; 
	CallableStatement stmtBulk = null;

	String p_error_code = null;
	String p_error_text = null;
	String psysmessageid = null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
 	int recordsPerPage=14;	
 	int totalRecord =0;
	int chunk_id = request.getParameter("chunk_id") == null ? 1	: Integer.parseInt(request.getParameter("chunk_id"));
		
	String facility_id = (String) session.getValue("facility_id");
	String p_dflt_type="A";
	String p_dflt_code="B";
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String patient_name =checkForNull(request.getParameter("patient_name"));
	String patient_name_cond = checkForNull(request.getParameter("patient_name_cond"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));//102343567	
	System.out.println("encounter_id "+encounter_id);
	String encounter_period_type = checkForNull(request.getParameter("encounter_period_type"));
	String encounter_from_date_str = checkForNull(request.getParameter("encounter_from_date"));
	String encounter_to_date_str = checkForNull(request.getParameter("encounter_to_date"));
	
	java.sql.Date encounter_from_date = null;
	java.sql.Date encounter_to_date = null;	
	String contact_no = checkForNull(request.getParameter("contact_no"));
	String contact_no_cond = checkForNull(request.getParameter("contact_no_cond"));
	System.out.println("contact_no_cond "+contact_no_cond);
	int age_from = returnInt(request.getParameter("age_from"));
	int age_to = returnInt(request.getParameter("age_to"));
	System.out.println("age_to after int "+age_to);
	String gender = checkForNull(request.getParameter("gender"));
	String location_type = checkForNull(request.getParameter("location_type"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String doctor_name = checkForNull(request.getParameter("doctor_name"));
	String doctor_name_cond = checkForNull(request.getParameter("doctor_name_cond"));
	String payer_group = checkForNull(request.getParameter("payer_group"));
	String payer = checkForNull(request.getParameter("payer"));
	String payer_cond = checkForNull(request.getParameter("payer_cond"));
	String policy= checkForNull(request.getParameter("policy"));
	String policy_cond= checkForNull(request.getParameter("policy_cond"));
	String patient_type = checkForNull(request.getParameter("patient_type"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	if("A".equals(episode_type)){
		episode_type = "";
	}
	System.out.println("episode_type "+episode_type);
	int session_start_index=(chunk_id - 1)* recordsPerPage;
	int session_end_index=(chunk_id)* recordsPerPage;

	String encounter_period = checkForNull(request.getParameter("encounter_period"));
	String episode_status = checkForNull(request.getParameter("episode_status"));
	String sort_by=null;
	String addedById =(String)session.getValue("login_user");
	String modifiedById =(String)session.getValue("login_user");
	String addedAtWsno =p.getProperty("client_ip_address"); 
	String addedFacilityId =(String)session.getValue("facility_id");
	String modifiedAtWsno =p.getProperty("client_ip_address"); 
	String modifiedFacilityid =(String)session.getValue("facility_id");	
	String makeDefault =null;
	String nric = checkForNull(request.getParameter("nric"));
	String optionList = checkForNull(request.getParameter("optionList"));
	String facilityid = checkForNull(request.getParameter("facilityid")); //V210129 

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	Array tempArray = null;
	Timestamp[] encounterDateValues = null;
	BigDecimal[] encounterIdValues = null;
	String[] patientIdValues = null;
	String[] patientNameValues = null;
	String[] patientSexValues = null;
	String[] patientLocationValues = null;
	String[] doctorNameValues = null;
	String[] blngGroupIdValues = null;
	BigDecimal[] unbilledAmtValues = null;
	BigDecimal[] outstAmtValues = null; 
	BigDecimal[] totUnadjValues = null; 
	String[] payerNameValues = null;
	BigDecimal[] payerApprovalAmtValues = null;
	BigDecimal[]  episodeIdValues = null;
	BigDecimal[] visitIdValues =  null;
	String[] episodeTypeValues = null;
	
	String[] payerGroup = null;
	String[] policyCode = null;
	String[] policyNumber = null;
	String[] blngGrpDesc = null;
	BigDecimal[] acctSeqNo = null;
	BigDecimal[]  priorityNo = null;
	String[] specialClinic = new String[14];
	String[] encounterFacilityId = new String[2];	//V210129 
	String locale = (String)session.getAttribute("LOCALE"); //V210129 
	Calendar cal = Calendar.getInstance();	 
    	String noOfDecimals = "";

 	try{
 		con = ConnectionManager.getConnection(request);
 		noOfDecimals = BLHelper.getNoOfDecimals(con);
		stmtBulk = (CallableStatement) con.prepareCall("begin blpatsearch.search(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;"); //V210129 
		//stmtBulk.setString(1,facility_id); //V210129 Commented
		stmtBulk.setString(1,facilityid); //V210129 Added
		stmtBulk.setString(2,p_dflt_type);
		stmtBulk.setString(3,p_dflt_code);
		stmtBulk.setString(4,patient_id);
		stmtBulk.setString(5,patient_name);
		stmtBulk.setString(6,patient_name_cond);
		stmtBulk.setString(7,encounter_id);
		stmtBulk.setString(8,encounter_period);	
	if ("P".equals(encounter_period)) {
		if(encounter_from_date_str == null || "".equals(encounter_from_date_str)){
			stmtBulk.setString(9,null);
		}
		else{
			stmtBulk.setDate(9, new Date(format.parse(encounter_from_date_str).getTime()));
		}
		if(encounter_to_date_str == null || "".equals(encounter_to_date_str)){
			stmtBulk.setString(10,null);
		}
		else{
			stmtBulk.setDate(10, new Date(format.parse(encounter_to_date_str).getTime()));
		}
	} 	
	else{
		stmtBulk.setString(9,null);
		stmtBulk.setString(10,null);
	}
	stmtBulk.setString(11,contact_no);
	stmtBulk.setString(12,contact_no_cond);
	if(age_from == 0){
		stmtBulk.setString(13,null);
	}
	else{
		stmtBulk.setInt   (13,age_from);		
	}
	if(age_to == 0){
		stmtBulk.setString(14,null);
	}
	else{
		stmtBulk.setInt   (14,age_to);
	}
	stmtBulk.setString(15,gender);
	stmtBulk.setString(16,location_type);
	stmtBulk.setString(17,location_code);
	stmtBulk.setString(18,doctor_name);
	stmtBulk.setString(19,doctor_name_cond);
	stmtBulk.setString(20,payer_group);
	stmtBulk.setString(21,payer);
	stmtBulk.setString(22,payer_cond);
	stmtBulk.setString(23,policy);
	stmtBulk.setString(24,policy_cond);
	stmtBulk.setString(25,patient_type);
	stmtBulk.setString(26,episode_type);
	stmtBulk.setInt   (27,session_start_index);
	stmtBulk.setInt   (28,session_end_index);
	stmtBulk.setString(29,encounter_period);
	stmtBulk.setString(30,episode_status);
	stmtBulk.setString(31,sort_by);
	stmtBulk.setString(32,addedById);
	stmtBulk.setString(33,modifiedById);
	stmtBulk.setString(34,addedAtWsno);
	stmtBulk.setString(35,addedFacilityId);
	stmtBulk.setString(36,modifiedAtWsno);
	stmtBulk.setString(37,modifiedFacilityid);
	stmtBulk.setString(38,makeDefault);
	stmtBulk.setString(39,nric);
	stmtBulk.setString(40,optionList);	
	stmtBulk.registerOutParameter(41, Types.VARCHAR);
	stmtBulk.registerOutParameter(42, Types.VARCHAR);
	stmtBulk.registerOutParameter(43, Types.VARCHAR);
	stmtBulk.registerOutParameter(44, Types.ARRAY,"BL_ENCOUNTER_DATE_TYPE");
	stmtBulk.registerOutParameter(45, Types.ARRAY,"BL_ENCOUNTER_ID_TYPE");
	stmtBulk.registerOutParameter(46, Types.ARRAY,"BL_PATIENT_ID_TYPE");
	stmtBulk.registerOutParameter(47, Types.ARRAY,"BL_PATIENT_NAME_TYPE");
	stmtBulk.registerOutParameter(48, Types.ARRAY,"BL_SEX_TYPE");
	stmtBulk.registerOutParameter(49, Types.ARRAY,"BL_PATIENT_LOCATION_TYPE");
	stmtBulk.registerOutParameter(50, Types.ARRAY,"BL_DOCTOR_NAME_TYPE");
	stmtBulk.registerOutParameter(51, Types.ARRAY,"BL_BLNG_GRP_ID_TYPE");
	stmtBulk.registerOutParameter(52, Types.ARRAY,"BL_UNBILLED_AMOUNT_TYPE");
	stmtBulk.registerOutParameter(53, Types.ARRAY,"BL_OUTSTANDING_AMT_TYPE");
	stmtBulk.registerOutParameter(54, Types.ARRAY,"BL_UNADJ_DEPOSIT_AMT_TYPE");
	stmtBulk.registerOutParameter(55, Types.ARRAY,"BL_PAYER_NAME_TYPE");
	stmtBulk.registerOutParameter(56, Types.ARRAY,"BL_PAYER_APPROVAL_AMT_TYPE");
	stmtBulk.registerOutParameter(57, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(58, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(59, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(60, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(61, Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
	stmtBulk.registerOutParameter(62, Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
	stmtBulk.registerOutParameter(63, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(64, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(65, Types.ARRAY,"BL_BLNG_GRP_ID_TYPE");	
	stmtBulk.registerOutParameter(66, java.sql.Types.INTEGER);
	stmtBulk.registerOutParameter(67, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(68, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10"); //V210129 
	
	stmtBulk.executeUpdate();

	p_error_code = stmtBulk.getString(41);
	psysmessageid = stmtBulk.getString(42);
	p_error_text = stmtBulk.getString(43);
	
	tempArray = stmtBulk.getArray(44);
	if(tempArray != null){		
		try{
			encounterDateValues = (Timestamp[]) tempArray.getArray();
		}
		catch(Exception e){
			encounterDateValues = new Timestamp[1];
			e.printStackTrace();
		}
	}
	else{
		
		encounterDateValues = new Timestamp[1];
	}
	
	tempArray = stmtBulk.getArray(45);
	if(tempArray != null){
		
		try{
			encounterIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			encounterIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		encounterIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(46);
	if(tempArray != null){
		
		try{
			patientIdValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientIdValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientIdValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(47);
	if(tempArray != null){
		
		try{
			patientNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(48);
	if(tempArray != null){
		
		try{
			patientSexValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientSexValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientSexValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(49);
	if(tempArray != null){
		
		try{
			patientLocationValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientLocationValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientLocationValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(50);
	if(tempArray != null){
		
		try{
			doctorNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			doctorNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		doctorNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(51);
	if(tempArray != null){
		
		try{
			blngGroupIdValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			blngGroupIdValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		blngGroupIdValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(52);
	if(tempArray != null){
		
		try{
			unbilledAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			unbilledAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		unbilledAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(53);
	if(tempArray != null  ){
		
		try{
			outstAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			outstAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		outstAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(54);
	if(tempArray != null){		
		try{
			totUnadjValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			totUnadjValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		totUnadjValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(55);
	if(tempArray != null){
		
		try{
			payerNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			payerNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		payerNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(56);
	if(tempArray != null){
		
		try{
			payerApprovalAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			payerApprovalAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		payerApprovalAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(57);
	if(tempArray != null){
		
		try{
			episodeIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			episodeIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		 episodeIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(58);
	if(tempArray != null){
		
		try{
			visitIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			visitIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		visitIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(59);
	if(tempArray != null){
		
		try{
			episodeTypeValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			episodeTypeValues = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		episodeTypeValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(60);
	if(tempArray != null){
		
		try{
			payerGroup = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			payerGroup = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		payerGroup = new String[1];
	}
	
	tempArray = stmtBulk.getArray(61);
	if(tempArray != null){
		
		try{
			policyCode = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			policyCode = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		policyCode = new String[1];
	}
	
	tempArray = stmtBulk.getArray(62);
	if(tempArray != null){
		
		try{
			policyNumber = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			policyNumber = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		policyNumber = new String[1];
	}
	
	tempArray = stmtBulk.getArray(63);
	if(tempArray != null){
		
		try{
			priorityNo = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			priorityNo = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		priorityNo = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(64);
	if(tempArray != null){
		
		try{
			acctSeqNo = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			acctSeqNo = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		acctSeqNo = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(65);
	if(tempArray != null){
		
		try{
			blngGrpDesc = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			blngGrpDesc = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		blngGrpDesc = new String[1];
	}		
	
	 totalRecord = stmtBulk.getInt(66);
	 
	 tempArray = stmtBulk.getArray(67);
		if(tempArray != null){
			
			try{
				specialClinic = (String[]) tempArray.getArray();
			}
			catch(Exception e){
				specialClinic = new String[1];
				e.printStackTrace();
			}
		}
		else{			
			specialClinic = new String[1];
		}
		//V210129 start		
		tempArray = stmtBulk.getArray(68);
		if(tempArray != null){			
			try{
				encounterFacilityId = (String[]) tempArray.getArray();
			}
			catch(Exception e){
				encounterFacilityId = new String[1];
				e.printStackTrace();
			}
		}
		else{			
			encounterFacilityId = new String[1];
		}
		//V210129 end			
 	}
 	catch(Exception e){
 		System.err.println("Exception in Search Result is ->"+e);
		e.printStackTrace();
 	}
 	finally{
 		ConnectionManager.returnConnection(con);
 	}
%>
<form name='searchresult' id='searchresult' id='searchresult' method='post'>
<!-- Next and Previous Link -->
	<table width="100%" >
		<tr>
			<td align="right">
			<%
				if (chunk_id > 1) {
			%>
			<A id='prevvalue' HREF="javascript:loadSearchResults('<%=patient_id %>','<%=encounter_id %>','<%=encounter_period %>','<%=encounter_from_date_str %>','<%=encounter_to_date_str %>',
			'<%=patient_name %>','<%=patient_name_cond %>','<%=contact_no %>','<%=contact_no_cond %>','<%=age_from %>','<%=age_to %>',
			'<%=location_type %>','<%=location_code %>','<%=gender %>','<%=doctor_name %>','<%=doctor_name_cond %>','<%=payer_group %>',
			'<%=payer %>','<%=payer_cond %>','<%=policy %>','<%=policy_cond %>','<%=patient_type %>','<%=episode_type %>','<%=episode_status %>','<%=chunk_id - 1%>','<%=optionList %>',
			'<%=nric %>','<%=facilityid %>')" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
			<%
				}
				if(encounterIdValues.length==recordsPerPage && (chunk_id*recordsPerPage)!=totalRecord ){	
			%>
			<A id='nextvalue' HREF="javascript:loadSearchResults('<%=patient_id %>','<%=encounter_id %>','<%=encounter_period %>','<%=encounter_from_date_str %>','<%=encounter_to_date_str %>',
			'<%=patient_name %>','<%=patient_name_cond %>','<%=contact_no %>','<%=contact_no_cond %>','<%=age_from %>','<%=age_to %>',
			'<%=location_type %>','<%=location_code %>','<%=gender %>','<%=doctor_name %>','<%=doctor_name_cond %>','<%=payer_group %>',
			'<%=payer %>','<%=payer_cond %>','<%=policy %>','<%=policy_cond %>','<%=patient_type %>','<%=episode_type %>','<%=episode_status %>','<%=chunk_id + 1%>','<%=optionList %>',
			'<%=nric %>','<%=facilityid %>')"  text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
			<%	
				} 
			%>
			</td>
		</tr>
	</table>

	<!-- Displays Data  -->
	<table border="2" width="100%" cellspacing='0' cellpadding='0' class="grid">
	<tr>
<th class='columnheadercenter' width='7.5%'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="eBL.Facility.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="eBL.DOCTOR_NAME.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>			
<td class='COLUMNHEADERCENTER' width='7%' style = "display:none"><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>			
<td class='COLUMNHEADERCENTER' width='5%' id='billGenH1'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%' id='billGenH2'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5.5%' style = "display:none">Unadj Deposit</td>
<td class='COLUMNHEADERCENTER' width='5%' style = "display:none">Payer Approval amount</td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='3%' id='billGenH3'><fmt:message key="eBL.Special_Clinic.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 
<td class='COLUMNHEADERCENTER' width='3%' id='depositcallhdr'><fmt:message key="eBL.PatientDeposit.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 
</tr>
	<%
	int sNo = 0;
	for (int k = 0; k < encounterIdValues.length; k++) {	
		String encounterDateValue=returnDateString(encounterDateValues[k]);	
		//V220801 starts
		String encEncID ="";
		System.err.println("BLChargePatientSearchResult.jsp ,enc_id "+encounterIdValues[k]);
		System.err.println("episode_type "+episode_type);
		if(episode_type.equalsIgnoreCase("R"))
			encEncID ="";
		else
			encEncID = new String(Base64.encodeBase64((encounterIdValues[k].toString()).getBytes()));
		//V220801 ends
		//V220412 Starts
		//String encEncID = new String(Base64.encodeBase64((encounterIdValues[k].toString()).getBytes()));//V220801
		String encPatID=new String(Base64.encodeBase64((patientIdValues[k].getBytes())));

		//V220412 Ends
		sNo++;
	%>
	<tr>
	<td nowrap class="QRYODD"><%=encounterDateValue%></td>
	<td nowrap class="QRYEVEN"><%=encounterIdValues[k] == null ? "0": encounterIdValues[k]%></td>
	<td nowrap class="QRYEVEN"><%=encounterFacilityId[k] == null ? "": encounterFacilityId[k]%></td>
	<td nowrap class="QRYODD"><a href="javascript:callEncWin('<%=encounterDateValue%>','<%=encounterIdValues[k]%>','<%=patientIdValues[k]%>','<%=blngGroupIdValues[k]%>','<%=episodeIdValues[k]%>','<%=visitIdValues[k]%>','<%=episodeTypeValues[k]%>','<%=payerGroup[k]%>','<%=payerNameValues[k]%>','<%=policyCode[k]%>','<%=policyNumber[k]%>','<%=acctSeqNo[k]%>','<%=encounterFacilityId[k]%>','<%=encPatID%>','<%=encEncID%>');"><%=patientIdValues[k] == null ? "" : patientIdValues[k]%></a></td> <!--V220412--> 
	<td nowrap class="QRYEVEN"><%=patientNameValues[k] == null ? ""	: patientNameValues[k]%></td>
	<td nowrap class="QRYODD"><%=patientSexValues[k] == null ? "": patientSexValues[k]%></td>
	<td nowrap class="QRYODD"><%=patientLocationValues[k] == null ? "": patientLocationValues[k]%></td>
	<td nowrap class="QRYODD"><%=doctorNameValues[k] == null ? "": doctorNameValues[k]%></td>
	<td nowrap class="QRYODD"><%=blngGroupIdValues[k] == null ? "": blngGroupIdValues[k]%></td>
	<td nowrap class="QRYODD" style = "display:none" ><%=payerNameValues[k] == null ? "" : payerNameValues[k]%></td>
	<td nowrap class="QRYODD" id='billGenC1<%=sNo%>' style="text-align: right;"><%=unbilledAmtValues[k] == null ? ""	: unbilledAmtValues[k]%></td>
	<td nowrap class="QRYODD" id='billGenC2<%=sNo%>' style="text-align: right;"><%=outstAmtValues[k] == null ? "" : outstAmtValues[k]%></td>
	<td nowrap class="QRYODD" style = "display:none"><%=totUnadjValues[k] == null ? "" : totUnadjValues[k]%></td>
	<td nowrap class="QRYODD" style = "display:none"><%=payerApprovalAmtValues[k] == null ? "": payerApprovalAmtValues[k]%></td>
	<td nowrap class="QRYODD"><%=episodeIdValues[k] == null ? "": episodeIdValues[k]%></td>
	<td nowrap class="QRYODD"><%=visitIdValues[k] == null ? "": visitIdValues[k]%></td>
	<td nowrap class="QRYODD" id='billGenS<%=sNo%>'style="text-align: center;"  >
	<%if("Y".equals(specialClinic[k])){ %>
		<img src='../../eBL/images/SelectSplClinic.png'></img>
	<%}else{ %>
		<img src='../../eBL/images/UnSelectSplClinic.png'></img>
	<%} %>
	</td>
	<td nowrap class="QRYODD" id='depositcall' ><a href="javascript:deposit_call('<%=episodeIdValues[k]%>','<%=visitIdValues[k]%>','<%= patientIdValues[k]%>','<%=encounterIdValues[k]%>','<%=episodeTypeValues[k]%>','<%=encPatID%>','<%=encEncID%>');">Collect</a>
	</td><!--V220412--> 
	</tr>
	<%
		}
	if(sNo==0){%>
	<script>	
	setTimeout(function(){alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"))}, 100);
	</script>
	<%}
	%>
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type='hidden' name='noOfDecimals' id='noOfDecimals'  value="<%=noOfDecimals%>">
	<input type='hidden' name='episodeType' id='episodeType'  value="<%=episode_type%>">
	<input type='hidden' name='locale' id='locale'  value="<%=locale%>">	

</form>
</table>
<%!	
	private String checkForNull(String inputString)
	{
		if (inputString == null) return "";
		if(inputString.equals("null")) return "";
		
		return  inputString;
	}
	%>
</BODY>

