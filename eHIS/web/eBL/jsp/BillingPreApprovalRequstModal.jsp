<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.PreApprovalRequestDetailsBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP					=	"<%=BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP")%>";
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pre Approval Request Details</title>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode																			=	new String();
String locale																				=	"";
String facilityId																			=	"";
String loggedInUser																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
String patinetId																			=	"";
String episodeType																			=	"";
String episodeId																			=	"";
String visitId																				=	"";
String priority																				=	"";
String acctSeqNo																			=	"";
String authorized																			=	"";
String encounterId																			=	"";
String billingGrpId																			=	"";
String policyTypeCode																		=	"";
String custGroupCode   																		=	"";
String custCode   																			=	"";
String policyNumber																			=	"";
String billingServiceCode																	=	"";
String requestStatus																		=	"";
String availbleServiceAmount																=	"";
String approvedDate																			=	"";
String approvalNumber																		=	"";
String approvalStatus																		=	"";
String reason																				=	"";
String approvalRemarks																		=	"";
String serviceDate																			=	"";
String includedExcluded																		=	"";
String appReqDate																			=	"";
String status																				=	"";
String effectiveFrom																		=	"";
String disable																				=	"DISABLED";
ArrayList<String[]>		preApprovalRequestDetailsModalList									=	null;



try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	patinetId																				=	checkForNull(request.getParameter("patinetId"));
	episodeType																				=	checkForNull(request.getParameter("episodeType"));
	episodeId																				=	checkForNull(request.getParameter("episodeId"));
	visitId																					=	checkForNull(request.getParameter("visitId"));
	priority																				=	checkForNull(request.getParameter("priority"));
	acctSeqNo																				=	checkForNull(request.getParameter("acctSeqNo"));
	encounterId																				=	checkForNull(request.getParameter("encounterId"));
	billingGrpId																			=	checkForNull(request.getParameter("billingGroupId"));
	policyTypeCode																			=	checkForNull(request.getParameter("policyTypeCode"));
	custGroupCode																			=	checkForNull(request.getParameter("custGroupCode"));
	custCode																				=	checkForNull(request.getParameter("custCode"));
	policyNumber																			=	checkForNull(request.getParameter("policyNumber"));
	requestStatus																			=	checkForNull(request.getParameter("requestStatus"));
	billingServiceCode																		=	checkForNull(request.getParameter("billingServiceCode"));
	availbleServiceAmount																	=	checkForNull(request.getParameter("availbleServiceAmount"));                  
	approvedDate																			=	checkForNull(request.getParameter("approvedDate"));  
	approvalNumber																			=	checkForNull(request.getParameter("approvalNumber"));          
	approvalStatus																			=	checkForNull(request.getParameter("approvalStatus"));          
	reason																					=	checkForNull(request.getParameter("reason"));  
	approvalRemarks																			=	checkForNull(request.getParameter("approvalRemarks"));          
	serviceDate																				=	checkForNull(request.getParameter("serviceDate"));  
	includedExcluded																		=	checkForNull(request.getParameter("includedExcluded"));
	appReqDate																				=	checkForNull(request.getParameter("appReqDate"));		
	status																					=	checkForNull(request.getParameter("status"));
	effectiveFrom																			=	checkForNull(request.getParameter("effectiveFrom"));
	if(status.equalsIgnoreCase("no"))
		status="";
	System.out.println("Request Param ::::::"+request.getQueryString());
	System.out.println("patinetId 					IN BillingPreApprovalRequstModal.jsp:::: "+patinetId);
	System.out.println("episodeType 				IN BillingPreApprovalRequstModal.jsp:::: "+episodeType);
	System.out.println("episodeId 					IN BillingPreApprovalRequstModal.jsp:::: "+episodeId);
	System.out.println("visitId 					IN BillingPreApprovalRequstModal.jsp:::: "+visitId);
	System.out.println("priority 					IN BillingPreApprovalRequstModal.jsp:::: "+priority);
	System.out.println("acctSeqNo 					IN BillingPreApprovalRequstModal.jsp:::: "+acctSeqNo);
	System.out.println("encounterId 				IN BillingPreApprovalRequstModal.jsp:::: "+encounterId);
	System.out.println("policyTypeCode 				IN BillingPreApprovalRequstModal.jsp:::: "+policyTypeCode);
	System.out.println("custGroupCode 				IN BillingPreApprovalRequstModal.jsp:::: "+custGroupCode);
	System.out.println("custCode 					IN BillingPreApprovalRequstModal.jsp:::: "+custCode);
	System.out.println("billingGrpId 				IN BillingPreApprovalRequstModal.jsp:::: "+billingGrpId);
	System.out.println("policyNumber 				IN BillingPreApprovalRequstModal.jsp:::: "+policyNumber);
	System.out.println("availbleServiceAmount 		IN BillingPreApprovalRequstModal.jsp:::: "+availbleServiceAmount);
	System.out.println("approvedDate 				IN BillingPreApprovalRequstModal.jsp:::: "+approvedDate);
	System.out.println("approvalNumber 				IN BillingPreApprovalRequstModal.jsp:::: "+approvalNumber);
	System.out.println("approvalStatus 				IN BillingPreApprovalRequstModal.jsp:::: "+approvalStatus);
	System.out.println("reason 						IN BillingPreApprovalRequstModal.jsp:::: "+reason);
	System.out.println("approvalRemarks 			IN BillingPreApprovalRequstModal.jsp:::: "+approvalRemarks);
	System.out.println("serviceDate 				IN BillingPreApprovalRequstModal.jsp:::: "+serviceDate);
	System.out.println("includedExcluded			IN BillingPreApprovalRequstModal.jsp:::: "+includedExcluded);
	System.out.println("billingGrpId 				IN BillingPreApprovalRequstModal.jsp:::: "+billingGrpId);
	System.out.println("appReqDate 					IN BillingPreApprovalRequstModal.jsp:::: "+appReqDate);
	System.out.println("status		 				IN BillingPreApprovalRequstModal.jsp:::: "+status);
	System.out.println("effectiveFrom				IN BillingPreApprovalRequstModal.jsp:::: "+effectiveFrom);
	
	bean_id																					= 	"PreApprovalRequestDetailsBean" ;
	bean_name																				= 	"eBL.PreApprovalRequestDetailsBean";
	PreApprovalRequestDetailsBean preApprovalRequestDetailsBean								= 	(PreApprovalRequestDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	preApprovalRequestDetailsModalList														=	preApprovalRequestDetailsBean.getBillingServiceCodeForBillingGroupModal(patinetId, episodeType, episodeId, visitId, priority, acctSeqNo, custGroupCode, custCode, policyTypeCode, billingServiceCode, facilityId, locale);		
	 
		
%>
<body>
<form id="recordApprovalDetailsModalForm" name="recordApprovalDetailsModalForm" id="recordApprovalDetailsModalForm">
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
			
			
					<td  class="columnheader" >Pre Approval Request Details</td></tr>		
</TABLE>
<br>
<table align='center' cellpadding=3 cellspacing=0  width='100%' id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1">	 
	<tr>
			<th class='CAFLOWSHEETLEVEL1'	width="1%"	align="left"><fmt:message key="eBL.INCLUDED_EXCLUDED.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.BLNG_SERV_CODE.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.BillingServiceDesc.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.SERVICE_DATE.label" 				bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.AvailableServiceAmt.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.APPROVED_DATE.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="eBL.ApprovalNumber.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="1%" 	align="left"><fmt:message key="Common.status.label" 				bundle="${common_labels}"/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="2%" 	align="left"><fmt:message key="Common.reason.label" 				bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1'	width="1%" 	align="left"><fmt:message key="Common.remarks.label" 				bundle="${common_labels}"		/></th>
	</tr>
</table>
	<div id="record_approval_detail_div_modal" name="record_approval_detaile_div_modal" style="width:100%; height:180px; overflow: auto; " >		 
	<table align='center'  cellpadding=3 cellspacing=0  width='100%' id="record_approval_details_modal_table" name="record_approval_details_modal_table" id="record_approval_details_modal_table" border="1">	
	
	<%
	System.out.println("preApprovalRequestDetailsModalList SIZE:::::: "+preApprovalRequestDetailsModalList.size());
	for(int index=0;index<preApprovalRequestDetailsModalList.size();index++)
	{
	
	%>

	
			<tr>
				<td class="fields" 	width="1%"		><select id="included_excluded<%=index%>"					name="included_excluded<%=index%>"			style="width: 110px;"	<%=disable%>  > <option value=<%=includedExcluded%> >	   <%=includedExcluded%> </option></select></td> 
				<td class="fields"	width="2%" 		><input type="text"	id="billing_service_code<%=index%>"		name="billing_service_code<%=index%>"		title="<%=preApprovalRequestDetailsModalList.get(index)[0]	!=	null	?	preApprovalRequestDetailsModalList.get(index)[0]	:	""	 %>" 		value="<%=preApprovalRequestDetailsModalList.get(index)[0]	!=	null	?	preApprovalRequestDetailsModalList.get(index)[0]	:	""	 %>" 	size="10"	<%=disable%> /></td> 
				<td class="fields"	width="2%" 		><input type="text" id="billing_service_desc<%=index%>"		name="billing_service_desc<%=index%>" 		title="<%=preApprovalRequestDetailsModalList.get(index)[1]	!=	null	?	preApprovalRequestDetailsModalList.get(index)[1]	:	""	 %>" 		value="<%=preApprovalRequestDetailsModalList.get(index)[1]	!=	null	?	preApprovalRequestDetailsModalList.get(index)[1]	:	""	 %>" 	size="11"	<%=disable%> /><a href="javascript:showPopUP1('<%=index%>');"> <b>?</b> </a></td>
				<td class="fields" 	width="2%"		><input type="text" id="service_date<%=index%>"				name="service_date<%=index%>"		  		title="<%=serviceDate%>" 																															value="<%=serviceDate%>" 																														size="7"	<%=disable%> /><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('service_date<%=index%>');"  onKeyPress="return lockbackSpace();"	<%=disable%> ></td> 
				<td class="fields" 	width="2%"		><input type="text" id="available_service_amount<%=index%>"	name="available_service_amount<%=index%>"	title="<%=availbleServiceAmount%>" 																													value="<%=availbleServiceAmount%>" 																												size="10"	 /></td> 
				<td class="fields" 	width="2%"		><input type="text" id="approved_date<%=index%>"			name="approved_date<%=index%>"				title="<%=approvedDate%>" 																															value="<%=approvedDate%>" 																														size="7"	/><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('approved_date<%=index%>');" name="approved_date_cal<%=index%>" id="approved_date_cal<%=index%>" onKeyPress="return lockbackSpace();"  ></td>
				<td class="fields" 	width="2%"		><input type="text" id="approval_number<%=index%>"			name="approval_number<%=index%>"			title="<%=approvalNumber%>" 																														value="<%=approvalNumber%>" 																													size="10"  	/></td> 
				<td class="fields" 	width="1%"		><input type="text" id="approval_status<%=index%>"			name="approval_status<%=index%>"			title="<%=approvalStatus%>" 																														value="<%=approvalStatus%>" 																													size="3"	/></td> 
				<td class="fields" 	width="2%"		><input type="text" id="reason<%=index%>"					name="reason<%=index%>"						title="<%=reason%>" 																																value="<%=reason%>" 																															size="5"	/><input type='button' class='button' name="reason_lookup<%=index%>" id="reason_lookup<%=index%>" id="reason_lookup<%=index%>" value='?' onClick="return reasonCodeLookup('<%=index%>')"  tabindex='2' 	/></td>
				<td class="fields" 	width="1%"		><input type="text" id="approval_remarks<%=index%>"			name="approval_remarks<%=index%>"			title="<%=approvalRemarks%>" 																														value="<%=approvalRemarks%>" 																													size="4"	/></td> 
			</tr> 
	<%
	}
	%>
	
</table>
</div>	
<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td class='fields' width="32%"></td>
					<td class='fields' width="55%"></td>
					<td class='fields' width="15%"><input type="button" class='button' name="save_modal" id="save_modal"	id="save_modal"    	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%>" <%=preApprovalRequestDetailsModalList!=null && preApprovalRequestDetailsModalList.size()>0 ? ""  : "DISABLED" %> onClick="saveBillingRecordApprovalModalValues(),parent.window.close();return retModal(this);"  /></td>
					
				</tr>
			</TABLE>	
			
			
			
			
		<input type='hidden' name='patinetId' id='patinetId' 			id='patinetId'				value="<%=patinetId%>" >
		<input type='hidden' name='episodeType' id='episodeType' 		id='episodeType'			value="<%=episodeType%>" >
		<input type='hidden' name='visitId' id='visitId' 			id='visitId'				value="<%=visitId%>" >
		<input type='hidden' name='priority' id='priority' 			id='priority'				value="<%=priority%>" />
 		<input type='hidden' name='acctSeqNo' id='acctSeqNo' 			id='acctSeqNo'				value="<%=acctSeqNo%>" />
 		<input type='hidden' name='encounterId' id='encounterId' 		id='encounterId'			value="<%=encounterId%>" >
		<input type='hidden' name='policyTypeCode' id='policyTypeCode' 		id='policyTypeCode'			value="<%=policyTypeCode%>" >
		<input type='hidden' name='custGroupCode' id='custGroupCode' 		id='custGroupCode'			value="<%=custGroupCode%>" >
		<input type='hidden' name='custCode' id='custCode' 			id='custCode'				value="<%=custCode%>" />
 		<input type='hidden' name='policyNumber' id='policyNumber' 		id='policyNumber'			value="<%=policyNumber%>" />
 		<input type='hidden' name='episodeId' id='episodeId' 			id='episodeId'				value="<%=episodeId%>" />
 		<input type="hidden" name="effective_from" id="effective_from"  	id="effective_from"			value="<%=effectiveFrom%>" />
		<input type="hidden" name="app_req_date" id="app_req_date"		id="app_req_date" 			value="<%=appReqDate%>" />
		<input type="hidden" name="billing_grp_id" id="billing_grp_id"		id="billing_grp_id" 		value="<%=billingGrpId%>" />
		<input type="hidden" name="status" id="status"			    id="status" 				value="<%=status%>" />
													
 		
</form>		
</body>
<%
}
catch(Exception e)
{
	System.out.println("Exception in BillingPreApprovalRequstModal.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

