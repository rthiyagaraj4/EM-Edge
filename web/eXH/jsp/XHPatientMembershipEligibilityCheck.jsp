<!DOCTYPE html>
<html>
<%@ page import="java.sql.CallableStatement,java.sql.Connection,com.ehis.util.DateUtils,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<head>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css' type='text/css'></link>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function cancel2()
{
	//window.close();
	parent.parent.getElementById("dialog_tag").close();
}
//come
function acceptPayer()
{
   var operating_facility_id = document.forms[0].operating_facility_id.value;  
   var encounter_id = document.forms[0].encounter_id.value;  
   var episode_type=document.forms[0].episode_type.value;     
   var episode_id=document.forms[0].episode_id.value;  
   var visit_id=document.forms[0].visit_id.value;  
   var acc_seq_num = document.forms[0].acc_seq_num.value;   
   var patient_id = document.forms[0].patient_id.value;   
   var billing_group_id = document.forms[0].billing_group_id.value;
   var settlement_ind = document.forms[0].settlement_ind.value;
   var cust_code = document.forms[0].payer_code.value;
   var priority = document.forms[0].priority.value;
   var policy_type_code = document.forms[0].policy_type_code.value;
   var cust_group_code = document.forms[0].provider_code.value;

   var transaction_id=document.forms[0].transaction_id.value;
   var response_date_time=document.forms[0].response_date_time.value;
   var response_code=document.forms[0].response_code.value;
   var eligibility_code=document.forms[0].eligibility_code.value;
   var validity_type= document.forms[0].validity_period.value;
   var error_msg=document.forms[0].errorMsg.value;
   var remarks=document.forms[0].remarks.value;
   var validity_until=document.forms[0].validity_until.value;

  /*alert(operating_facility_id);
  alert(encounter_id);
  alert(episode_type);
  alert(episode_id);
  alert(visit_id);
  alert(acc_seq_num);
  alert(patient_id);
  alert(billing_group_id);
  alert(settlement_ind);
  alert(cust_code);
  alert(priority);
  alert(policy_type_code);
  alert(cust_group_code); */

   var responseMsg="";
   var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'StorePayerDetails',
				ofd: operating_facility_id,
				eid: encounter_id,
				epty: episode_type,
				epid: episode_id,
				vid: visit_id,
				asn: acc_seq_num,
				pid: patient_id,
				bgi: billing_group_id,
				sin: settlement_ind,
				cuco: cust_code,
				prio: priority,
				ptc: policy_type_code,
				cgc: cust_group_code,
				tid: transaction_id,
				rdt: response_date_time,
				rco: response_code,
				ety: eligibility_code,
				vty: validity_type,
				emg: error_msg,
				rks: remarks,
			    val_until: validity_until
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	}); 
	
	alert(responseMsg);
}



//Added by Prithivi on 08/12/2016 for MMS-QH-CRF-0085
function payerEligibilityCheck(buttonVar)
{
 /*<PATIENT_ID>111$!^<ENCOUNTER_ID>111$!^<NATIONAL_ID>111$!^<PATIENT_NAME>TEST$!^<PATIENT_DOB>01012016$!^<MOBILE_NO>098898778$!^<MEMBERSHIP_NO>12121$!^<POLICY_HOLDER_NAME>test$!^<POLICY_PLAN_NO>54646$!^<PROVIDER_CODE>546464$!^<SERVICE_TYPE>56565$!^<PAYER_CODE>4453$!^FACILITY_ID>02$!^<LOGGED_IN_USER_ID>BLESSAN$!^<LOGGED_IN_WSNO>TEST$!^<SESSION>REGVISIT */
   /*<PATIENT_ID>#PatientId$!^<ENCOUNTER_ID>$!^<NATIONAL_ID>#NationalId$!^<PATIENT_NAME>#PatientName$!^<PATIENT_DOB>#PatientDOB$!^<MOBILE_NO>#PatientMobileNO$!^<MEMBERSHIP_NO>#MembershipNO$!^<POLICY_HOLDER_NAME>#PolicyHolderName$!^<POLICY_PLAN_NO>#PolicyNO$!^<PROVIDER_CODE>#ProviderCode$!^<SERVICE_TYPE>#ServiceCode$!^<PAYER_CODE>#PayerCode$!^<FACILITY_ID>#FacilityId$!^<LOGGED_IN_USER_ID>#Username$!^<LOGGED_IN_WSNO>#strWsNo$!^<SESSION>REGVISIT */
   var dataElements = "<PATIENT_ID>#PatientId$!^<ENCOUNTER_ID>$!^<NATIONAL_ID>#NationalId$!^<PATIENT_NAME>#PatientName$!^<PATIENT_DOB>#PatientDOB$!^<MOBILE_NO>#PatientMobileNO$!^<MEMBERSHIP_NO>#MembershipNO$!^<POLICY_HOLDER_NAME>#PolicyHolderName$!^<POLICY_PLAN_NO>#PolicyNO$!^<PROVIDER_CODE>#ProviderCode$!^<SERVICE_TYPE>#ServiceCode$!^<PAYER_CODE>#PayerCode$!^<FACILITY_ID>#FacilityId$!^<LOGGED_IN_USER_ID>#Username$!^<LOGGED_IN_WSNO>#strWsNo$!^<SESSION>REGVISIT$!^<REQUEST_TYPE>#RequestType$!^<TRANS_NO>#TransNo$!^<POLICY>#policy$!^<POLICY_START_DATE>#policy_start_date$!^<POLICY_END_DATE>#policy_end_date";  //V230707
   var patient_id = document.forms[0].patient_id.value;  // username =  login user -- mandatory
   var userName = document.forms[0].login_user.value;  // username =  login user -- mandatory
   var cust_3=document.forms[0].payer_code.value;        // payer_code -- mandatory
   var policy_no=document.forms[0].policy_no.value;  // policy_plan_no
   var provider_code=document.forms[0].provider_code.value;  // provider_code --mandatory
   var membershipId = document.forms[0].membership_no.value;   // membership no --mandatory
   var service_code = document.forms[0].service_code.value;   // service_code --mandatory
   var strWsNo = document.forms[0].strWsNo.value;
   var trans_no = document.forms[0].transaction_id.value; //Added by Apoorva for MOHE-CRF-0020


   var facility_id = document.forms[0].facility_id.value;

   if(service_code=="" || service_code=="")
	{
		alert("Service Type is required for eligibility check ");
		return false;
	}

   if(provider_code=="")
	{
		//alert(getMessage("BL6277","BL"));
		alert("Payer group is required for eligibility check ");
		document.forms[0].payer_group.focus();
		return false;
	}

	if(cust_3=="")
	{
		alert("Payer name is required for eligibility check");
		document.forms[0].payer_desc.focus();
		return false;
	}

	if(membershipId=="")
	{
		alert("Membership Id is required for eligibility check ");
		document.forms[0].membership_no.focus();
		return false;
	}
    
   dataElements = dataElements.replace("#PatientId", patient_id);
   dataElements = dataElements.replace("#Username", userName);
   dataElements = dataElements.replace("#PayerCode", cust_3);
   dataElements = dataElements.replace("#ProviderCode", provider_code);
   dataElements = dataElements.replace("#MembershipNO", membershipId);
   dataElements = dataElements.replace("#PolicyNO", policy_no);
   dataElements = dataElements.replace("#FacilityId", facility_id);
   dataElements = dataElements.replace("#ServiceCode", service_code);
   dataElements = dataElements.replace("#strWsNo", strWsNo);

   //Added by Apoorva for MOHE-CRF-0020
	if (buttonVar == "CS"){
		dataElements = dataElements.replace("#RequestType", "CHECKSTATUS");
   	}
	else
	{
		dataElements = dataElements.replace("#RequestType", "CHECK_ELIGIBILITY");
	}
	
	dataElements = dataElements.replace("#TransNo", trans_no);
	

	//Added by Apoorva for MOHE-CRF-0020 ends here

   //alert("dataElements after 1st replace...."+dataElements);
   //This procedure is available in eXH/js/ExternalApplication.js 
   var response = checkPatientMembershipEligibility(dataElements,patient_id);
   //alert("final response from interface...."+response);
   if(response.indexOf("$!^") != -1) {
	   
	   //S$!^SUCCESS$!^TransactionID$!^ResponseDateTime$!^ResponseCode$!^ValidityType$!^EligibilityCode$!^ErrorMessage$!^Remarks
	   var responseArr = response.split("$!^");
        if(responseArr[0]=="S")
		{
		   document.forms[0].response_code.value=responseArr[4];
		  /* 	if(responseArr[4]=="1")
		   {
			  document.forms[0].response_code_desc.value = "1-Invalid";
		   }
		   else if(responseArr[4]=="2")
		   {
			  document.forms[0].response_code_desc.value = "2-Valid";
		   }
		   else if(responseArr[4]=="3")
		   {
			  document.forms[0].response_code_desc.value = "3-Need additional information";
		   }
		   else if(responseArr[4]=="4")
		   {
			  document.forms[0].response_code_desc.value = "4-Error";
		   }

		   */
		   document.forms[0].response_code_desc.value=responseArr[8];
		   document.forms[0].status_description.value=responseArr[7];
		   document.forms[0].status_desc_text.value=responseArr[7];
		   document.forms[0].validity_period.value=responseArr[5];
		   document.forms[0].eligibility_code.value=responseArr[6];

		   document.forms[0].transaction_id.value=responseArr[2];
		   document.forms[0].response_date_time.value=responseArr[3];

		   document.forms[0].remarks.value=responseArr[8];
		   document.forms[0].errorMsg.value=responseArr[7];
		   document.forms[0].validity_until.value=responseArr[9];
		}
		else
	   {
			alert(responseArr[1]);
	   }

   }
   else
	{
	   alert("Response Failed!!!      "+response);
	}

}

</script>
</head>


<body>

<%
HttpSession httpSession = request.getSession(false);
Properties p = (Properties)httpSession.getValue("jdbc");
String strWsNo   =  p.getProperty("client_ip_address");
String facility_id = (String)httpSession.getValue("facility_id");
if(strWsNo == null) strWsNo="";

/* "title="+title+"&pid="+patient_id+"&eid="+encounter_id+"&nuc="+nursing_unit_code+"&pst="+pStartDate+"&ped="+pEndDate+"&pn="+pat_name+"&pdob="+pat_dob+"&ni="+national_id+"&pcn="+pat_contactno+"&mcn="+membership_no+"&phn="+policy_holder_name+"&pln="+policy_number+"&pdc="+provider_code+"&sc="+service_code+"&pyc="+payer_code+"&ptc="+policy_type_code+"&bgi="+billing_group_id+"&bgd="+p_g_desc+"&prio="+priority+"&pyname="+payerName+"&vdt="+visit_adm_date_time+"&eff="+effectiveFrom+"&eft="+effectiveTo;  */


String patient_id = XHDBAdapter.checkNull(request.getParameter("pid"));    //to_store
String encounter_id = XHDBAdapter.checkNull(request.getParameter("eid"));  //to_store
//String nursing_unit_code = XHDBAdapter.checkNull(request.getParameter("nuc"));
String payer_code = XHDBAdapter.checkNull(request.getParameter("pyc"));    //to_store  cust_code
String service_code = XHDBAdapter.checkNull(request.getParameter("sc"));
String policy_number = XHDBAdapter.checkNull(request.getParameter("pln"));
String provider_code = XHDBAdapter.checkNull(request.getParameter("pdc"));  // cust_group_code
String membership_no = XHDBAdapter.checkNull(request.getParameter("mcn"));

String policyStartDate = XHDBAdapter.checkNull(request.getParameter("pst"));
String policyEndDate = XHDBAdapter.checkNull(request.getParameter("ped"));

String policy_type_code = XHDBAdapter.checkNull(request.getParameter("ptc"));   //to_store
String policy_type_desc = XHDBAdapter.checkNull(request.getParameter("ptydesc"));
String billing_group_id = XHDBAdapter.checkNull(request.getParameter("bgi"));   //to_store
String billing_group_desc = XHDBAdapter.checkNull(request.getParameter("bgd"));
String priority = XHDBAdapter.checkNull(request.getParameter("prio"));    //to_store

String payerName = XHDBAdapter.checkNull(request.getParameter("pyname"));
String payer_group_desc = XHDBAdapter.checkNull(request.getParameter("pgd"));
String cust_name = XHDBAdapter.checkNull(request.getParameter("cun"));
String encounterDateTime = XHDBAdapter.checkNull(request.getParameter("vdt"));
String policyEffFrom = XHDBAdapter.checkNull(request.getParameter("eff"));
String policyEffTo = XHDBAdapter.checkNull(request.getParameter("eft"));

//to_store
String operating_facility_id = XHDBAdapter.checkNull(request.getParameter("ofd"));  //to_store
String episode_id = XHDBAdapter.checkNull(request.getParameter("epid"));  //to_store
String visit_id = XHDBAdapter.checkNull(request.getParameter("vsid"));  //to_store

String episode_type = XHDBAdapter.checkNull(request.getParameter("eptype"));  //to_store
String acc_seq_num = XHDBAdapter.checkNull(request.getParameter("asno"));  //to_store
String settlement_ind = XHDBAdapter.checkNull(request.getParameter("slid"));  //to_store

String trans_id = XHDBAdapter.checkNull(request.getParameter("transId"));  //to_store
String respDateTime = XHDBAdapter.checkNull(request.getParameter("respDTime"));  //to_store
String respCode = XHDBAdapter.checkNull(request.getParameter("respCode"));  //to_store

String elgibilityCode = XHDBAdapter.checkNull(request.getParameter("elgCode"));  //to_store
String errorMsg = XHDBAdapter.checkNull(request.getParameter("errMsg"));  //to_store
String remarks = XHDBAdapter.checkNull(request.getParameter("remarks"));  //to_store
String validityType = XHDBAdapter.checkNull(request.getParameter("validityType"));  //to_store
String validity_until = XHDBAdapter.checkNull(request.getParameter("validity_until"));  //to_store
String respCodeDesc =  XHDBAdapter.checkNull(request.getParameter("remarks"));;
String disabledStr="disabled";
String checkStatusdisabledStr="disabled";
String hiddenStr="hidden"; 
	

         /*  if("1".equals(respCode))
		   {
			  respCodeDesc = "1-Invalid";
		   }
		   else if("2".equals(respCode))
		   {
			  respCodeDesc = "2-Valid";
		   }
		   else if("3".equals(respCode))
		   {
			 respCodeDesc = "3-Need additional information";
		   }
		   else if("4".equals(respCode))
		   {
			  respCodeDesc = "4-Error";
		   }  */

%>

<form name='add_modify_pat_fin_det_ins_bodyedit' id='add_modify_pat_fin_det_ins_bodyedit' method='post' action="">

<table cellpadding=3 cellspacing=0  width="100%" align='left'>

<td align='left' class='COLUMNHEADER' colspan='4'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td>
<tr>
<td width="25%" class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
<td width="25%" class='fields'>
<input type='text' name="billing_group_desc" id="billing_group_desc"   tabindex='0' value="<%=billing_group_desc %>" readonly></td>

<td width="25%" class='label'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
<td width="25%" class='label'><B><%=""+encounterDateTime%><B></td>

</tr>
<tr>	
		<td width="25%" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></div></td>
		<td width="25%" class="fields">
		<input type='text' name="srch_by_desc" id="srch_by_desc" maxlength='30' size='20'  tabindex='0' value="" readonly>
		</td>

		<td width="25%" class="label" id='srch_by_leg'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="region" id="region" maxlength='30' size='20'  tabindex='0' value="" readonly></td>			
</tr>

<tr>
<td class='label' width='25%'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
<td class='fields' width='25%' ><input maxlength='15' size='30' type=text name='payer_group' id='payer_group' value="<%=payer_group_desc %>" readonly></td>
<td width="25%">&nbsp;</td>
<td width="25%">&nbsp;</td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width='25%' ><input maxlength='40' size='30' type=text name='payer_desc' id='payer_desc'  value="<%=payerName %>" readonly>
	</td>
	<td class='label' width='25%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type="text" maxlength='2' size="3" name='priority' id='priority' style='text-align:right'  value="<%=priority %>" ></td>
</tr>

<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields">
		<input type="text" maxlength='40' size='10'  name='policy' id='policy' style='text-align:right'  value="<%=policy_type_desc %>" readonly>
		</td>

		<td width="25%" class="label"><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text'  name="policy_no" id="policy_no" maxlength='30' size="23"  tabindex='0' value="<%=policy_number %>" readonly></td>			
</tr>


<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields">
				<input size='10' maxlength='10' type=text name='policy_start_date' id='policy_start_date' value="<%=policyStartDate %>" readonly>
		</td>

		<td width="25%" class="label"><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="policy_expiry_date" id="policy_expiry_date" size='10' maxlength='10'  tabindex='0' value="<%=policyEndDate %>" readonly></td>			
</tr>

<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields">
				<input size='10' maxlength='10' type=text name='policy_effective_from' id='policy_effective_from' value="<%=policyEffFrom %>" readonly>
		</td>

		<td width="25%" class="label"><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="policy_effective_to" id="policy_effective_to" size='10' maxlength='10'  tabindex='0' value="<%=policyEffTo %>" readonly></td>			
</tr>


<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.ADJUSTMENT_RULE_INDICATOR.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields">
				<input type=text name='adj_rule_indicator' id='adj_rule_indicator' value="" readonly>
		</td>

		<td width="25%" class="label"><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="amount_indicator" id="amount_indicator"  tabindex='0' value="" readonly></td>			
</tr>


<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.ADJUSTMENT_VALUE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields">
				<input maxlength='10' size='10' type=text name='adj_value' id='adj_value' value="" readonly>
		</td>

		<td width="25%" class="label"><fmt:message key="eBL.ADJUSTMENT_INTERFACE_CODE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="adj_interface_code" id="adj_interface_code" size='30' maxlength='100'  tabindex='0' value="" readonly></td>			
</tr>

<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.ClaimCode.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields">
				<input type=text name='claim_code' id='claim_code' value="" readonly>
		</td>

		<td width="25%" class="label" id='authorised_by_leg'><fmt:message key="eBL.CreditAuthorisationBy.label" bundle="${bl_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="authorised_by" id="authorised_by" tabindex='0' value="" readonly></td>			
</tr>


<tr> 
		<td width="25%" class="label"><fmt:message key="eBL.additionalApprovals.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields">
				<input type=text name='additional_approvals' id='additional_approvals' value="" readonly>
		</td>

		<td width="25%" class="label" id='membership_id_leg'>Membership Id</td>
		<td width="25%" class='fields' ><input type='text' name="membership_no" id="membership_no" size='30' maxlength='100'  tabindex='0' value="<%=membership_no %>" ></td>			
</tr>
<tr>
<td align='left' class='COLUMNHEADER' colspan='4'>Eligibility Check Details</td>
</tr>
<tr id="bupaEligibilityCheck1" >
		<td class='label' width='25%' ><fmt:message key="eBL.ResponseCode.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%'><input name='response_code_desc' id='response_code_desc' type='text' readonly value="<%=respCodeDesc%>">
		<input name='response_code' id='response_code' type='hidden' readonly value="<%=respCode%>"></td>
		<td class='label' width='25%' ><fmt:message key="eBL.ValidityPeriod.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%'><input name='validity_until' id='validity_until' type='text' readonly value="<%=validity_until%>">
		<input name='validity_period' id='validity_period' type='hidden' readonly value="<%=validityType%>">
		</td>	
    </tr>
	<tr id="bupaEligibilityCheck2" >
		<td class='label' width='25%' valign="top"><fmt:message key="eBL.EligibilityCode.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%'  valign="top"><input name='eligibility_code' id='eligibility_code' type='text' readonly value="<%=elgibilityCode%>"></td>
		<td class='label' width='25%'  valign="top"><fmt:message key="eBL.StatusDescription.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%'  valign="top">
		<textarea rows="3" cols="40" id="status_desc_text" name="status_desc_text" readonly wrap="hard" style="text-align: left"><%=errorMsg%></textarea>
		<input name='status_description' id='status_description' type='hidden' readonly value="<%=errorMsg%>">
		</td>
		<input type=hidden name='transaction_id' id='transaction_id'  value="<%=trans_id%>">
		<input type=hidden name='response_date_time' id='response_date_time' value="<%=respDateTime%>">
		<input type=hidden name='errorMsg' id='errorMsg' value="<%=errorMsg%>">
		<input type=hidden name='remarks' id='remarks' value="<%=remarks%>">
    </tr>
<tr>
<%

	String profile_id_exists="N";
	String interfaceYN="";
	CallableStatement checkProfileIdStatement = null;
	Connection con=null;
      try{
		    con = ConnectionManager.getConnection(request);
			String check_profileId="ELCPROF1";
			String checkProfileIdQuery = "{ ? = call xh_standard_profile_exists(?) }";

			checkProfileIdStatement = con.prepareCall(checkProfileIdQuery);
			checkProfileIdStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			checkProfileIdStatement.setString(2, check_profileId);
			checkProfileIdStatement.execute();
		
			profile_id_exists = checkProfileIdStatement.getString(1);
			System.out.println("XHPatinetMembershipEligibility.jsp::::profile_id_exists for HSWITCHPROF1....."+profile_id_exists);
     }
	catch(Exception e)
	{
		System.out.println("XHPatinetMembershipEligibility.jsp::::Exception in checkProfileIdStatement..."+e);
	}
	finally{
         checkProfileIdStatement.close();
	}
	

   if("Y".equals(profile_id_exists))
		{  	   
	        ResultSet rs1 = null;
			PreparedStatement pstmt = null;
			try
			{
				System.out.println("XHPatinetMembershipEligibility.jsp::::provider_code--cust_group_code ..."+provider_code);
				String sql_interface_flag="SELECT INTERFACE_YN FROM AR_CUST_GROUP WHERE CUST_GROUP_CODE = ? ";
				pstmt = con.prepareStatement(sql_interface_flag);
				pstmt.setString(1, provider_code);

				rs1 = pstmt.executeQuery();
				if (rs1 != null) {
					while (rs1.next()) {
						interfaceYN = rs1.getString("INTERFACE_YN");					
					}
				}
				System.out.println("XHPatinetMembershipEligibility.jsp:::checkInterfaceEnabled...interfaceYN...."+interfaceYN+".....respCode........."+respCode);	
				if("Y".equals(interfaceYN))
				{
					if(!"2".equals(respCode)) 
					{
						disabledStr = "";
					}
					else
					{
						disabledStr = "disabled";
					}
                   
				}
				else
				{
                   disabledStr = "disabled";
				}
			}
			catch(Exception exp)
			{
				System.out.println("(XHPatinetMembershipEligibility.jsp:checkInterfaceEnabled) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}
			finally
			{			
				if (rs1 != null)   
				rs1.close();
                
				if (pstmt != null)   
				pstmt.close();
			}

		}   
	   %>
<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>
	<td class='label' width='25%'>

    <input type="button" name="eligibility_check" id="eligibility_check" value="Check Eligibility" class="button" onClick='payerEligibilityCheck("EC")' <%=disabledStr%>>&nbsp;
	<!-- Added By Apoorva for AAKH-CRF-0142 -->
		<input type="button" name="check_status" id="check_status" id="check_status"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckStatus.label","common_labels")%>" class="button" onClick='payerEligibilityCheck("CS")' <%=checkStatusdisabledStr%> <%=hiddenStr%>>&nbsp;

		<!-- Added By Apoorva for AAKH-CRF-0142 ends here -->
	<input type="button" name="accept_payer" id="accept_payer" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class="button" onClick='acceptPayer()' <%=disabledStr%>>&nbsp;
	<input type="button" name="cancel" id="cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>"  class="button" onClick='cancel2()'>&nbsp;
	</td>
</tr>
<input type='hidden' name='login_user' id='login_user' value='<%=(String)session.getAttribute("login_user")%>'>
<input type='hidden' name='strWsNo' id='strWsNo' value='<%=strWsNo%>' >
<input type=hidden name="facility_id" id="facility_id"  value='<%=facility_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' >
<input type=hidden name="encounter_id" id="encounter_id"  value='<%=encounter_id%>'>
<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='' >
<input type=hidden name="payer_code" id="payer_code"  value='<%=payer_code%>'>
<input type='hidden' name='service_code' id='service_code' value='<%=service_code%>' >
<input type=hidden name="provider_code" id="provider_code"  value='<%=provider_code%>'>

<input type=hidden name="operating_facility_id" id="operating_facility_id"  value='<%=operating_facility_id%>'>
<input type=hidden name="episode_id" id="episode_id"  value='<%=episode_id%>'>
<input type=hidden name="visit_id" id="visit_id"  value='<%=visit_id%>'>

<input type=hidden name="episode_type" id="episode_type"  value='<%=episode_type%>'>
<input type=hidden name="acc_seq_num" id="acc_seq_num"  value='<%=acc_seq_num%>'>
<input type=hidden name="settlement_ind" id="settlement_ind"  value='<%=settlement_ind%>'>
<input type=hidden name="billing_group_id" id="billing_group_id"  value='<%=billing_group_id%>'>
<input type=hidden name="policy_type_code" id="policy_type_code"  value='<%=policy_type_code%>'>
<input type=hidden name="policy_type_desc" id="policy_type_desc"  value='<%=policy_type_desc%>'>

</form>
</body>
</html>

