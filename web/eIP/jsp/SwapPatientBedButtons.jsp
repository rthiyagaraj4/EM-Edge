<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
   request.setCharacterEncoding("UTF-8");%>
<html>
	<title><fmt:message key="eIP.ConfirmSwapBeds.label" bundle="${ip_labels}"/></title>
	<head>
		    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script src='../../eCommon/js/dchk.js' language='javascript'></script>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			
			
			<script src='../../eIP/js/SwapPatientBeds.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name="Outstanding_button_form" id="Outstanding_button_form">
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>
				<td width="20%" align='right' class='white'><input type='button' class='button' name='Swap' id='Swap' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SwapBeds.label","ip_labels")%>'  onClick='Add();'>&nbsp;&nbsp;</td>
			</table> 
		</form>
	</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

