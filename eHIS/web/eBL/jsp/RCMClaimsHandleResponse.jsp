<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eBL.BLReportIdMapper"%>
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
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" );
	String facilityId =  (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String err_value=request.getParameter( "err_value" );
	String message = request.getParameter( "message" );
	String claim_status = request.getParameter( "claim_status" );

	try
	{
		con = ConnectionManager.getConnection();


%>

<script language="JavaScript">
$(document).ready(function(){
	var claim_status = document.forms[0].claim_status.value;
	var frm = document.forms[0];
	var err = frm.err_value.value;
	var message = frm.message.value;
	
	if(claim_status == "E"){
		if(err == '1'){
			alert("APP-SM0070 Operation Completed Successfully");
			parent.frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
			parent.frames[1].frames[0].document.forms[0].search_btn.click();
		}else if(err == '0'){
			alert(message);
			return false;
		}
	}
	if(claim_status == "D"){
		if(err == '1'){
			alert("APP-SM0070 Operation Completed Successfully");
			parent.frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
			parent.frames[1].frames[0].document.forms[0].search_btn.click();
		}else if(err == '0'){
			alert(message);
			return false;
		}
	}
	if(claim_status == "R"){
		if(err == '1'){
			alert("APP-SM0070 Operation Completed Successfully");
			parent.frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
			parent.frames[1].frames[0].document.forms[0].search_btn.click();
		}else if(err == '0'){
			alert(message);
			return false;
		}
	}
	if(claim_status == "G"){
		if(err == '1'){
			alert("APP-SM0070 Operation Completed Successfully");
			parent.frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
			parent.frames[1].frames[0].document.forms[0].search_btn.click();
		}else if(err == '0'){
			alert(message);
			return false;
		}
	}
});

</script>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form id='messageFrm'>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">	
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='err_value' id='err_value' id='err_value' value='<%=err_value %>'>
	<input type='hidden' name='message' id='message' id='message' value='<%=message %>'>
	<input type='hidden' name='claim_status' id='claim_status' id='claim_status' value='<%=claim_status %>'>
</form>
</BODY>
<%
	}catch(Exception e){
		System.err.println("Exception is: "+e);
	}finally{
		if(cstmt!=null) cstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);	
	}
%>

