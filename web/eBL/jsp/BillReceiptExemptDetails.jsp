<!DOCTYPE html>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemption Details</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<table style="width: 90%">
		<tr>
			<td style="width: 30%">
				Exempt Type
			</td>
			<td  style="width: 70%">
				<input type='text' name='exemptCode' id='exemptCode' id='exemptCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(exemptDesc,exemptCode,1,1); } else{ fnClearCode(exemptDesc); }">&nbsp;
				<input type='text' name='exemptDesc' id='exemptDesc' id='exemptDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(exemptDesc,exemptCode,1,2); } else{ fnClearCode(exemptCode); }">&nbsp;
				<input type='button' class='button' name="exemptBtn" id="exemptBtn" id='exemptBtn' value='?' onClick="callCommonLookupCode(exemptDesc,exemptCode,1,2)" tabindex='2'>				
			</td>
		</tr>
		<tr>
			<td style="width: 30%">
				Assig
			</td>
			<td  style="width: 70%">
				<input type='text' name='exemptCode' id='exemptCode' id='exemptCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(exemptDesc,exemptCode,1,1); } else{ fnClearCode(exemptDesc); }">&nbsp;
				<input type='text' name='exemptDesc' id='exemptDesc' id='exemptDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(exemptDesc,exemptCode,1,2); } else{ fnClearCode(exemptCode); }">&nbsp;
				<input type='button' class='button' name="exemptBtn" id="exemptBtn" id='exemptBtn' value='?' onClick="callCommonLookupCode(exemptDesc,exemptCode,1,2)" tabindex='2'>				
			</td>
		</tr>
	</table>
</body>
</html>

