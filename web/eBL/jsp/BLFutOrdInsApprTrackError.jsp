<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@ 
page import="java.sql.*,java.io.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="org.apache.poi.hssf.usermodel.*"%>
<%@page import="org.apache.poi.hssf.util.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="JavaScript">

$(document).ready(function(){ 
	var frm = document.forms[0];
	var err = frm.err_value.value;
	var message = frm.err_num.value;
	var actionID = frm.p_action_id.value;
	var encounterId = frm.p_encounter_id.value;
	if(err == '1'){
		alert(message);
		var qryFrame = parent.frames[1].frames[0];
		qryFrame.document.getElementById('prevActionID').value = actionID;
		qryFrame.document.getElementById('prevEncounterId').value = encounterId;
		qryFrame.document.getElementById('search_btn').click();
	}else if(err == '2'){
		alert(message);
		return false;
	}
});


</script>
<%
	String err_num = request.getParameter("err_num");
	String err_value = request.getParameter("err_value");
	String p_action_id = request.getParameter("p_action_id");
	String p_encounter_id = request.getParameter("p_encounter_id");
	System.err.println("err_num:"+err_num);
	System.err.println("err_value:"+err_value);
	System.err.println("p_action_id:"+p_action_id);
	System.err.println("Query String in BLFutOrdInsApprTrackError.jsp:"+request.getQueryString());
	
	try
	{
%>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()' >
<form id='messageFrm'>
	<input type="hidden" id = "err_num" name = "err_num" value="<%=err_num%>" >
	<input type="hidden" id = "err_value" name = "err_value" value="<%=err_value%>" >
	<input type="hidden" id = "p_action_id" name = "p_action_id" value="<%=p_action_id%>" >
	<input type="hidden" id = "p_encounter_id" name = "p_encounter_id" value="<%=p_encounter_id%>" >
</form>
</BODY>
<%
	}catch(Exception e){
		System.err.println("Exception in BLFutOrdInsApprTrackError.jsp is: "+e);
	}finally{
	}
%>

