<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	


<%
	request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";		



%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src="../../eMR/js/MRAuditParam.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name="InternalReportSearch" id="InternalReportSearch" action="" method="post" target="messageFrame">

<BR>
<div align="left">
<table border="0" cellpadding="3" cellspacing="0"  align='center' width='50%'>
	<tr>
	  <td width='20%' >&nbsp;</td>
      <td class="label" width='30%'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/></td>
	  <td class='fields' width='40%'><select name="audit_trial" id="audit_trial" onChange="loadSection();" >
	    <option value='' selected>------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------</option> 
	   <option value='MR' ><fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/>  </option>
	    

	  
	  </td>
    </tr>

</table></div>
</body>
</form>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

