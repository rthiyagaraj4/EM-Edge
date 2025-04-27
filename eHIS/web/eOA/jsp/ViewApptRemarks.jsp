<!DOCTYPE html>
<!--Created by Thamizh selvi on 19th July 2018 against ML-MMOH-CRF-1058-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>

	<TITLE> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/> </TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function closeWin(obj){
			parent.window.close();
		}
	</script>
</HEAD>
<%

	String facilityId = checkForNull(request.getParameter("facilityId"));
	String apptId	  = checkForNull(request.getParameter("apptId"));

	String apptRemarks = "";

	Connection con = null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);	
		apptRemarks = eOA.OACommonBean.getApptRemarks(con,facilityId,apptId);
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='ViewApptRemarks' id='ViewApptRemarks'> 
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>
		<td class='label' colspan='3'>&nbsp;</td>
	</tr>
	<tr>
		<td class='label'>&nbsp;</td>
		<td class='fields' colspan='3'><textarea name='remarks' rows="7" cols="70" maxlength="100" readonly><%=apptRemarks%></textarea></td>
	</tr>
	<tr>
		<td class='label' colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class="fields" nowrap><input type=button class='button' name = 'close' style= "width: 50px;  height: 20px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWin(this);'>
		</td> 
	</tr>
</table>

</form>
</body>
</HTML>
<%			
	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	
%>
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

