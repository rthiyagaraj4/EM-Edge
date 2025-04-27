<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%! private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
}
%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>

<%
			String facilityId =  (String) session.getValue( "facility_id" ) ;
			String locale = (String)session.getAttribute("LOCALE");
			String message=request.getParameter( "message" );
			String called_from_dashboard_YN=request.getParameter( "called_from_dashboard_YN" );
			String params=request.getQueryString();
			System.err.println("params"+params);
			String visitId = checkForNull(request.getParameter("visitId"));
			String patientId =checkForNull(request.getParameter("patientId"));
			String episodeType = checkForNull(request.getParameter("episodeType"));
			String payerGrpCode = checkForNull(request.getParameter("payer_grp_code"));
			String payerCode = checkForNull(request.getParameter("payer_code"));
			String policyTypeCode =checkForNull(request.getParameter("policy_type_code"));
			String apprDocRefNum = checkForNull(request.getParameter("apprDocRefNum"));
			String claimId = checkForNull(request.getParameter("claimId"));
			String StateDurFrom = checkForNull(request.getParameter("State_dur_from"));
			String StateDurTo =checkForNull(request.getParameter("State_dur_to"));
			String insuranceStatus = checkForNull(request.getParameter("insurance_Status"));
			String claims_services_level = checkForNull(request.getParameter("claims_services_level"));
			String function_id =  checkForNull(request.getParameter("function_id")) ;
			String err_value = request.getParameter("err_value");


%>

<script language="JavaScript">
$(document).ready(function(){
	var frm = document.forms[0];
	var message = frm.message.value;
	var err_value = frm.err_value.value;
	
	if(err_value == "1"){
		alert(message);
	}
		reloadQueryCriteria();
	
});

function reloadQueryCriteria()
{
	
	var frm = document.forms[0];
	var p_facility_id = frm.facility_id.value;
	var locale = frm.locale.value;
	var func_id = "EBL_RCM_TRX";
	var called_from_dashboard_YN = frm.called_from_dashboard_YN.value;
	var err_value = frm.err_value.value;
	var message = frm.message.value;
	message = "Exception from Servlet : "+message;
	
	if(called_from_dashboard_YN == "N"){
		parent.frames[0].location.reload();
		parent.frames[1].frames[0].location.href = "../../eBL/jsp/BLEClaimQueryCriteria.jsp?function_id="+func_id;
		parent.frames[1].frames[0].document.getElementById("search_button").click();
	}else{
		
		parent.frames[0].location.href = "../../eCommon/html/blank.html";
		parent.frames[1].location.href = "../../eBL/jsp/BLRCMTransGenerateBillResult.jsp?called_from_dashboard_YN="+called_from_dashboard_YN+"&facility_id="+p_facility_id+"&locale="+locale+"&visitId=<%=visitId%>&patientId=<%=patientId%>&episodeType=<%=episodeType%>&payer_grp_code=<%=payerGrpCode%>&payer_code=<%=payerCode%>&policy_type_code=<%=policyTypeCode%>&apprDocRefNum=<%=apprDocRefNum%>&claimId=<%=claimId%>&State_dur_from=<%=StateDurFrom%>&State_dur_to=<%=StateDurTo%>&insurance_Status=<%=insuranceStatus%>&claims_services_level=<%=claims_services_level%>&function_id=<%=function_id%>";
		parent.frames[2].location.href = "../../eCommon/html/blank.html";		
	}
	
	if(err_value == "0"){
		if(called_from_dashboard_YN == "N"){
			parent.frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='+message+'&err_value='+err_value;
		}else{
			parent.frames[4].location.href = '../../eCommon/jsp/error.jsp?err_num='+message+'&err_value='+err_value;
		}
	}

}	

</script>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form id='messageFrm'>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">	
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='message' id='message' id='message' value='<%=message %>'>
	<input type='hidden' name='called_from_dashboard_YN' id='called_from_dashboard_YN' id='called_from_dashboard_YN' value='<%=called_from_dashboard_YN %>'>
	<input type='hidden' name = 'err_value' id='err_value' value='<%=err_value%>'>
	</form>
</BODY>

