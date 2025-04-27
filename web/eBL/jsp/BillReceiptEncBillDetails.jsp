<!DOCTYPE html>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.response.BillReceiptResponse"%>
<%@page import="eBL.billreceipt.model.BillReceiptCustomerDetails"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Encounter Billing Details</title>
<%!
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
	String episodeType= replaceNull(request.getParameter("episode_type"));
	//V220512
	//String patientId = replaceNull(request.getParameter("patient_id"));
	String patientId="";
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
		patientId	=replaceNull(request.getParameter("patient_id"));
	}
	//V220512
	String episodeId= replaceNull(request.getParameter("episode_id"));
	String visitId= replaceNull(request.getParameter("visit_id"));
	String locale= (String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue("facility_id");
	BillReceiptRequest brRequest = new BillReceiptRequest();
	brRequest.setEpisodeType(episodeType);
	brRequest.setPatientId(patientId);
	brRequest.setEpisodeId(episodeId);
	brRequest.setVisitId(visitId);
	brRequest.setLocale(locale);
	brRequest.setFacilityId(facilityId);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptCustomerDetails> custList = billReceiptBC.getEncBillDetails(brRequest);
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
$(document).ready(function(){	
	/*$('#encBillingDetails').hide();
	
	$('#resizeBtnSearch').click(function(){
		var defValue = $(this).attr('defValue');
		if(defValue =='shrink'){
			$(this).attr('defValue','expand');
			$(this).attr('src','../../eOT/images/ShowMore.gif');
			$('#encBillingDetails').hide();	
			$(parent.BillReceiptExisOrderSearch.document).find('#searchCriteriaDiv').hide();
			parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('allFramesExisting').value;
		}
		else{
			$(this).attr('defValue','shrink');
			$(this).attr('src','../../eOT/images/ShowLess.gif');
			$('#encBillingDetails').show();
			$(parent.BillReceiptExisOrderSearch.document).find('#searchCriteriaDiv').hide();
			parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('showEncBilling').value;
		}
	});*/
});
</script>
</head>
<body>
	<table  style="width: 100%" CELLSPACING='10' cellpadding=3 align='center'>
		<tr style="width: 100%">
   			<th width='100%' class='COLUMNHEADER' nowrap align='left' >
   				Encounter Billing Details
   				<!-- &nbsp;&nbsp;<img id="resizeBtnSearch" alt="" defValue="expand" src="../../eOT/images/ShowMore.gif" style="cursor: pointer;" >  --> 
   			</th>
   		</tr>
	</table>
	<form name='frmEncBill' id='frmEncBill' id='frmEncBill'>
		<table id='encBillingDetails' name='encBillingDetails' id='encBillingDetails' CELLSPACING=0 cellpadding=3 align='center' class='grid'>
			<tr style="width: 100%">
				<th width="9%" class='COLUMNHEADER'>
					Billing Group
				</th>
				<th width="4%" class='COLUMNHEADER'>
					Priority
				</th>
				<th width="9%" class='COLUMNHEADER'>
					Payer
				</th>
				<th width="9%" class='COLUMNHEADER'>
					Policy Type
				</th>
				<th width="8%" class='COLUMNHEADER'>
					Policy Number
				</th>
				<th width="9%" class='COLUMNHEADER'>
					Policy Start Date
				</th>
				<th width="10%" class='COLUMNHEADER'>
					Policy Expiry Date
				</th>
				<th width="9%" class='COLUMNHEADER'>
					Credit Auth Ref
				</th>
				<th width="9%" class='COLUMNHEADER'>
					Credit Auth Date
				</th>
				<th width="8%" class='COLUMNHEADER'>
					Effective From
				</th>
				<th width="8%" class='COLUMNHEADER'>
					Effective To
				</th>
				<th width="8%" class='COLUMNHEADER'>
					Approved Amt
				</th>
				<th width="4%" class='COLUMNHEADER'>
					Days
				</th>
			</tr>
			<%for(BillReceiptCustomerDetails cust:custList){ %>
				<tr>
					<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getBlngGrpId()) %>
				</td>
				<td width="4%" class='LABEL'>
					<%= replaceNull(cust.getPriority()) %>
				</td>
				<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getCustCode()) %>
				</td>
				<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getPolicyTypeCode()) %>
				</td>
				<td width="8%" class='LABEL'>
					<%= replaceNull(cust.getPolicyNo()) %>
				</td>
				<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getPolStartDate()) %>
				</td>
				<td width="10%" class='LABEL'>
					<%= replaceNull(cust.getPolExpDate()) %>
				</td>
				<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getCreditAuthRef()) %>
				</td>
				<td width="9%" class='LABEL'>
					<%= replaceNull(cust.getCreditAuthDate()) %>
				</td>
				<td width="8%" class='LABEL'>
					<%= replaceNull(cust.getEffectiveFrom()) %>
				</td>
				<td width="8%" class='LABEL'>
					<%= replaceNull(cust.getEffectiveTo()) %>
				</td>
				<td width="8%" class='LABEL'>
					<%= replaceNull(cust.getApprovedAmt()) %>
				</td>
				<td width="4%" class='LABEL'>
					<%= replaceNull(cust.getApprovedDays()) %>
				</td>
				</tr>
			<%} %>
		</table>
	</form>
</body>
</html>

