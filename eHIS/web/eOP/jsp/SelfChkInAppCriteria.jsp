<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<HEAD>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link> 

<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eOP/js/SelfChkInAppt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD>
<%
	request.setCharacterEncoding("UTF-8");

	Connection con=null;
	String patientIdLength	= "";

	try {
		con =  ConnectionManager.getConnection(request);
		patientIdLength = eCommon.Common.CommonBean.getPatIdLength(con);
		patientIdLength = checkForNull(patientIdLength,"0");

		String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
		String or_install_yn		= checkForNull(request.getParameter("or_install_yn"));

	 %>

<BODY OnMouseDown="CodeArrest()"onload = 'FocusFirstElement()' onKeyDown ='lockKey()'>
<form name='selfChkinApptCriteria' id='selfChkinApptCriteria'  method="post">

<table cellpadding='2' border = '0' cellspacing='0' width='100%'>
<tr>
	<td class="label" width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='fields' width="15%"><input type="text" name="patientId" id="patientId" size="30" maxlength="<%=patientIdLength%>" onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);" onKeypress='makeValidString(this);return CheckForSpecChars(event);' onKeydown="return barCodeScanFunc(event, this);"/></td>
	<td class='fields'>
	   <!--<input type="button" value="Excecute" onclick="callSearch();"/>-->
	</td>

</tr>
</table>
<input type='hidden' name ='oper_stn_id' value="<%=oper_stn_id%>" />
<input type='hidden' name ='or_install_yn' value="<%=or_install_yn%>" />

</form>
</body>
<%
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
  		
		ConnectionManager.returnConnection(con,request);
    }
	%>
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

