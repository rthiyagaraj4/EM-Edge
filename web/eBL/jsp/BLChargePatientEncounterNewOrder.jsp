<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Sr No	Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
1.		1-Nov-2012      100           	Karthikeyan.K       created
--------------------------------------------------------------------------------------------------------------
Sr No     	Version     Incident		SCF/CRF    			Developer Name
--------------------------------------------------------------------------------------------------------------
2.			V210531		19058			MOHE-SCF-0107		Nandhini M
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eBL.placeorder.model.BLChargePatientNewOrderBean"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>

<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eBL/js/BLChargeEncounterNewOrder.js'></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script>

$(document).ready(function(){
	$('#serviceClassification').blur(function(){
		if($('#serviceClassification').val() != ''){			
			callBGDesc('BSGC',$('#serviceClassification'),$('#hdnClassification'),$('#serviceGroup'));
		}
		else{
			clearCode($('#hdnClassification'));
		}
	});
	$('#serviceClass_btn').click(function(){
		callBGDesc('BSGC',$('#serviceClassification'),$('#hdnClassification'),$('#serviceGroup'))
	});
	$('#orderType').blur(function(){
		if($('#orderType').val() != ''){			
			callBGDesc('OTP',$('#orderType'),$('#hdnOrderType'));
		}		
	});
	$('#orderType_btn').click(function(){
		callBGDesc('OTP',$('#orderType'),$('#hdnOrderType'));
	});
	
	$('#add_mod').click(function(){
		callSearchCriteria();
	});
	
	
	$('#serviceOrPanel').click(function(){
		if($(this).is(":checked")){
			$('#serviceGroup').prop("disabled",true);
			$('#serviceClassification').val("");
			$('#hdnClassification').val("");
			$('#serviceClassification').prop("readonly",true);
			$('#serviceClass_btn').prop("disabled",true);
		}else{
			$('#serviceGroup').prop("disabled",false);
			$('#serviceClassification').prop("readonly",false);
			$('#serviceClass_btn').prop("disabled",false);
		}
	});
	
	
	$('#reset').click(function(){
		resetNewOrder();
	})
	
});
</script>
<%-- JSP Page specific attributes end --%>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
%>
<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
String reqParam = request.getQueryString();

BLChargePatientNewOrderBean chargePatientBean = null;
HashMap<String,String> serviceGroupMapUnsorted = null;
Map<String, String> serviceGroupMap =null;
/*
String patientId = checkForNull(request.getParameter("patient_id"));
String encounterId = checkForNull(request.getParameter("encounter_id"));
*/
	String patientId	="";
	String encounterId	="";

	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		encounterId	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
	}else{
		patientId	= checkForNull(request.getParameter("patient_id"));
		encounterId	= checkForNull(request.getParameter("encounter_id"));
	}
	//V220513
System.out.println("patient_id new order "+patientId);
System.out.println("encounter_id "+encounterId);
String episodeId = checkForNull(request.getParameter("episode_id"));
String visitId = checkForNull(request.getParameter("visit_id"));
String encounterDate = checkForNull(request.getParameter("encounter_date"));
String episodeType = checkForNull(request.getParameter("episode_type"));
String acctSeqNo = checkForNull(request.getParameter("acctSeqNum"));
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String policyNum = checkForNull(request.getParameter("policyNum"));
//System.err.println(Runtime.getRuntime().availableProcessors());
//System.err.println(Runtime.getRuntime().freeMemory());
//System.err.println(Runtime.getRuntime().totalMemory());
String beanId = "BLChargePatientNewOrderBean" ;
String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";

BLChargePatientNewOrderBean chargeBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
//cleanBeanObject(beanId, beanName, request);
chargeBean.clearAll();
//HashMap<String,String> orderCategoryMap = null;
PlaceOrderBC placeOrderBC = new PlaceOrderBC(); 
try{
	chargePatientBean = new BLChargePatientNewOrderBean();
	serviceGroupMapUnsorted = placeOrderBC.getServiceGroup(locale);
	serviceGroupMap = new TreeMap<String, String>(serviceGroupMapUnsorted);
	//orderCategoryMap = chargePatientBean.getOrderCategory(locale, con);
	
}
catch(Exception e){
	System.err.println("Exception in New Order Search Criteria ->"+e);
}


%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<HTML>
<HEAD>
</HEAD>
<body>
	<form name='newOrderSrchCriteria' id='newOrderSrchCriteria' id='newOrderSrchCriteria'>
		<table width='95%' align="center">
			<tr>
				<td class='label' width='15%' nowrap="nowrap" style="text-align: right;">
					<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message>
				</td>
				<td class='fields' width='20%' nowrap="nowrap">
					<Select style="width: 200px;" name='serviceGroup' id='serviceGroup' id='serviceGroup'  >
      				<option value=''><fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" /></option>
 
      					
      				<%
      				if(serviceGroupMap != null){
      					String key = "";
	      				for (Iterator iterator = serviceGroupMap.keySet().iterator(); iterator.hasNext();) {
	    					key = (String) iterator.next(); %>
	    					<option value='<%=key%>'><%=serviceGroupMap.get(key)%></option>
	    				<%	
	    				}
      				}%>
				</td>
				<td class='label' width='15%' nowrap="nowrap" style="text-align: right;">
					<fmt:message key="eBL.CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message>
				</td>
				<td class='fields' width='20%' nowrap="nowrap">
					<input type='text' size="40" name='serviceClassification' id='serviceClassification' id='serviceClassification'>&nbsp;
					<input type='hidden' name='hdnClassification' id='hdnClassification' id='hdnClassification'>
 					<input type='button' class='button' name="serviceClass_btn" id="serviceClass_btn" id='serviceClass_btn' value='?' tabindex='2'>
				</td>
				<td class='label' width='10%' style="text-align: right;" nowrap="nowrap">
					<input type='checkbox' name='serviceOrPanel' id='serviceOrPanel' id='serviceOrPanel'  >&nbsp;
					<fmt:message key="Common.Panel.label" bundle="${common_labels}"></fmt:message>					
				</td>
				<td width='15%'>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td class='label' width='15%' style="text-align: right;" nowrap="nowrap" >
					<fmt:message key="eBL.SERV_PANEL_CODE.label" bundle="${bl_labels}" ></fmt:message>
				</td>
				<td class='label' width='20%' nowrap="nowrap"  >
					<!--<input type='text' size='20' name='servPanelCode' id='servPanelCode' id='servPanelCode' onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >-->
					<!-- Added against MOHE-SCF-0107 V210531 -->
					<input type='text' size='20' name='servPanelCode' id='servPanelCode' id='servPanelCode' >
				</td>
				<td class='label' width='15%' style="text-align: right;" nowrap="nowrap" >
					<fmt:message key="eBL.SERV_PANEL_DESC.label" bundle="${bl_labels}"></fmt:message>
				</td>
				<td class='label' width='20%' nowrap="nowrap">
				<!-- Added against MOHE-SCF-0107 V210531 -->
					<input type='text' size='40' name='servPanelDesc' id='servPanelDesc' id='servPanelDesc' >&nbsp;
				</td>
				<td class='label' width='10%' align='right' style="text-align: right;">
					<input class='button' type='button' name='add_mod' id='add_mod' id='add_mod' value='Search'>				
				</td>
				<td class='label' width='15%' align='right' style="text-align: right;">
					<input class='button' type='button' name='reset' id='reset' id='reset' value='Reset'>
				</td>
			</tr>
			<!-- <tr>
				<td class='label' width='10%'>
					<fmt:message key="eBL.ORDER_CATEGORY.label" bundle="${bl_labels}"></fmt:message>
				</td>
				<td class='fields' width='15%'>
					<Select style="width: 200px;" name='orderCategory' id='orderCategory' id='orderCategory' >
      				<option value=''><fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" /></option>
      				
				</td>
				<td class='label' width='10%'>
					<fmt:message key="eBL.ORDER_TYPE.label" bundle="${bl_labels}"></fmt:message>
				</td>
				<td class='fields' width='10%'>
					<input type='text' size="40" name='orderType' id='orderType' id='orderType' >&nbsp;
					<input type='hidden' name='hdnOrderType' id='hdnOrderType' id='hdnOrderType'>
 					<input type='button' class='button' name="orderType_btn" id="orderType_btn" id='orderType_btn' value='?'  tabindex='2'>
				</td>
				<td class='label' width='10%' style="text-align: right;">
					<fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"></fmt:message>
				</td>
				<td class='fields' width='10%'>
					<input type='text' size="20" name='orderCatCode' id='orderCatCode' id='orderCatCode' >
				</td>
				
				<td class='label' width='10%' style="text-align: right;">
					<fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"></fmt:message>
				</td>
				<td class='fields' width='15%'>
					<input type='text' size="40" name='orderCatDesc' id='orderCatDesc' id='orderCatDesc'>&nbsp;
 					<input type='button' class='button' name="orderCat_btn" id="orderCat_btn" value='?' onClick="callCommonValidation(2,serviceClassification,hdnClassification);" tabindex='2'>
				</td>
				
			</tr>
		 -->
		</table>
		<input type= hidden id='locale'name="locale"  value="<%=locale%>">
      	<input type= hidden id='facility_id' name="facility_id" id="facility_id"  value="<%=facility_id %>">
      	<input type= hidden id='patient_id' name="patient_id" id="patient_id"  value="<%=patientId %>">
      	<input type= hidden id='episode_id' name="episode_id" id="episode_id"  value="<%=episodeId %>">
      	<input type= hidden id='visit_id' name="visit_id" id="visit_id"  value="<%=visitId %>">
      	<input type='hidden' id='encounter_date' name='encounter_date' id='encounter_date' value='<%=encounterDate %>'>
      	<input type='hidden' id='encounter_id' name='encounter_id' id='encounter_id' value='<%=encounterId %>'>
      	<input type='hidden' id='episode_type' name='episode_type' id='episode_type' value='<%=episodeType %>'>
      	<input type='hidden' name='queryString' id='queryString' id='queryString' value='<%=reqParam%>'>
      	<input type='hidden' name='acctSeqNo' id='acctSeqNo' id='acctSeqNo' value='<%=acctSeqNo %>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='policyNum' id='policyNum' id='policyNum' value='<%=policyNum%>'>
      	
	</form>
</body>
<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
</HTML>

