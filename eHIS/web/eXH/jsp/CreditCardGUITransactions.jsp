<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%request.setCharacterEncoding("UTF-8"); %>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<HEAD>

<title>Credit Card Interface</title>

<script type="text/javascript">
function processResponse(action)
{	
	var myObj = {};
	var message = "";
	var cardNo = document.getElementById("P_Preapaid_Card_Number").value;

	if(action == 'OK') {
		if(cardNo == "") {
			alert(getMessage('XH0121','XH'));
			document.getElementById("P_Preapaid_Card_Number").focus();
			return;
		}
		else {
			if(cardNo.charAt(0) == ';') {
				cardNo = cardNo.substring(1);
			}
			var cardNoLen = cardNo.length;
			
			if(cardNo.charAt(cardNoLen - 1) == '?') {
				cardNo = cardNo.substring(0, cardNoLen - 1);
			}
			message = cardNo + "$|#" + "";
		}
	}
	else {
		retVal = getMessage('XH0122','XH');
		retVal = "E" + "$|#" + retVal + "$|#" + retVal;
		message = "" + "$|#" + retVal;
	}
	window.close();
	window.returnValue = message;
} 
</script>
<style>
#tabTable {
   position:fixed;
    top: 20%;
    left: 15%;
}
</style>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eXH/js/Validate.js'></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/common.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<FORM ID="creditCardGUI" name="creditCardGUI" id="creditCardGUI">
	<TABLE ID="tabTable">
	<TR>
		<TD CLASS="label" COLSPAN="2">Swipe Walletree Card for Patient ID - ${param.P_patient_id}</TD>
	</TR>
	<TR>
		<TD CLASS="label">Card # </TD>
		<TD><INPUT TYPE="text" name="P_Preapaid_Card_Number" id="P_Preapaid_Card_Number" ID="P_Preapaid_Card_Number"></TD>
	</TR>
	<TR ALIGN="right">
		<TD COLSPAN="2" CLASS=>
			<INPUT CLASS="BUTTON" TYPE="button" VALUE="Ok" onClick="processResponse('OK')">
			<INPUT CLASS="BUTTON" TYPE="button" VALUE="Cancel" onClick="processResponse('CANCEL')">
		</TD>
	</TR>
	</TABLE>
</FORM>
</body>
</html>

