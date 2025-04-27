<!DOCTYPE html>
<%--
/**
  *
  * @filename addMaritalStatus.jsp
  * @version 3.0 updated on 2/17/2005
  */
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");%>
<%
	//java.util.Date currentdate=new java.util.Date();
	//java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy");
	//String sysdt=sf.format(currentdate);
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad="marital_status_form.mar_status_code.focus()"> 
		<form name="marital_status_form" id="marital_status_form" action="../../servlet/eMP.MaritalStatusServlet" method="post" target="messageFrame">
			<BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<div align="left">
			<table border="0" cellpadding="3" cellspacing="0" width='75%' align='center'><!--width="100%"-->
				<tr>
					<!--td width='10%'>&nbsp;</td-->
					<td width="40%" >&nbsp;</td>
					<td width="60%" colspan="2">&nbsp;</td>
					<!--td width='10%'>&nbsp;</td-->
				</tr>
				<tr>
					<!--td>&nbsp;</td-->
					<td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'>
					&nbsp;&nbsp; 
					<input type="text" name="mar_status_code" id="mar_status_code" size="1" maxlength="1" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)">&nbsp;
					<img src='../images/mandatory.gif'></img>
					</td>
					<!--td>&nbsp;</td-->
				</tr>
				<tr>
					<!--td>&nbsp;</td-->
					<td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'>&nbsp;&nbsp; 
						<input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur="makeValidString(this);">&nbsp;
						<img src='../images/mandatory.gif'></img>
					</td>
					<!--td>&nbsp;</td-->
				</tr>
				<tr>
					<!--td>&nbsp;</td-->
					<td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td>
					<td width="60%" colspan="2" class='fields'>&nbsp;&nbsp; 
						<input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur="makeValidString(this);">&nbsp;
						<img src='../images/mandatory.gif'></img>
					</td>
					<!--td>&nbsp;</td-->
				</tr>
				<!-- <tr> 
				<td>&nbsp;</td
				<td width="40%"  class="label" >Effective From </td>
				<td width="13%" >&nbsp;&nbsp;&nbsp;--> 			
				
				<input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"  maxlength="10"><!--</td>
				<td width="47%"  class="label">&nbsp;&nbsp;To &nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--</td>
				<td>&nbsp;</td>
				</tr>

				<tr>
				<td width="40%">&nbsp;</td>
				<td width="60%" colspan="2">&nbsp;</td>
				</tr>-->
				<tr>
					<!--td>&nbsp;</td-->
					<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'>&nbsp;&nbsp; 
						<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>&nbsp;
					</td>
					<!--td>&nbsp;</td-->
				</tr>
				<tr>
					<td width="40%">&nbsp;</td>
					<td width="60%" colspan="2">&nbsp;</td>
				</tr>
		</table>
		</div>
		<input type="hidden" name="function" id="function" value="insert">
		<input type="hidden" name="eff_date_from" id="eff_date_from" >
		<input type="hidden" name="eff_date_to" id="eff_date_to" >
		<input type='hidden' name='function_name' id='function_name' value='insert'>
	</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

