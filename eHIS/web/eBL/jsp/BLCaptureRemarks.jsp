<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="eBL.placeorder.model.BLChargePatientServiceDetailsBean"%>
<%@page import="eBL.placeorder.response.PlaceNewOrderResponse"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remarks</title>
<%!
private String decodeParam(String input){
	String output = "";
	if(input == null || "null".equals(input)){
		output = "";
	}
	else{
		output = URLDecoder.decode(input);
	}
	return output;
}
%>
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String remarks= decodeParam(request.getParameter("remarks"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript'>
	$(document).ready(function(){
		$('#close').click(function(){
			var remarks = $.trim($('#remarks').val());
			remarks = remarks.replace(/"/g, "'");
			if(remarks.length>50){
				alert('Maximum 50 characters is allowed for remarks');
				return false;
			}
			/*window.returnValue = remarks;
			window.close();*/
			let dialogBody = parent.document.getElementById('dialog-body');
		    dialogBody.contentWindow.returnValue = remarks;
		    
		    const dialogTag = parent.document.getElementById('dialog_tag');    
		    dialogTag.close();   
		});
	});
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body>
	<br/>
	<br/>
	<span style='padding-left: 20px;' class='label'>Remarks</span>
	<br/>
	<br/>
	<span style='padding-left: 20px;'>
		<textarea id='remarks' rows="2" cols="40"  style="overflow-y: scroll; resize: none;"   ><%=remarks %></textarea>
	</span>
		<br/>
	<br/>
	<span style='padding-left: 20px;'>
	<input type='button' class='button' value='save' id='close'>
	</span>
</body>


</html>

