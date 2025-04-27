<!DOCTYPE html>

<%@page  import ="java.sql.*,java.util.*, webbeans.eCommon.*,eCommon.Common.CommonBean" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eOT/js/InstrumentCount.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
<form name="InstrumentCountStatusConfirmForm" id="InstrumentCountStatusConfirmForm" >
<%
	String initial_count_cmpl_yn	= request.getParameter("initial_count_cmpl_yn");
	String final_count_cmpl_yn		= request.getParameter("final_count_cmpl_yn");
	initial_count_cmpl_yn=initial_count_cmpl_yn==null?"N":initial_count_cmpl_yn;
	initial_count_cmpl_yn=initial_count_cmpl_yn.equals("null")?"N":initial_count_cmpl_yn;
	final_count_cmpl_yn=final_count_cmpl_yn==null?"N":final_count_cmpl_yn;
	final_count_cmpl_yn=final_count_cmpl_yn.equals("null")?"N":final_count_cmpl_yn;
	String disabled = "";
	String checked = "";
%>
<table border='0' cellpadding=3  cellspacing='0' align='center'  width='100%' >
	<tr>
	<%
		if(initial_count_cmpl_yn.equals("Y")){
			disabled = "disabled";
			checked = "checked";
		}
	%>
		<td width="25%" class="label">
		<fmt:message key="eOT.InitialStatusCompleted.Label" bundle="${ot_labels}"/>
		</td>
		<td width="25%" class="field">
			<input type="checkbox" class="checkbox" <%=disabled%> <%=checked%> name="initial_count_cmpl_yn" value="<%=initial_count_cmpl_yn%>" onClick="assignCheckboxValue(this)" >
		</td>
	<%
		disabled="";
		checked = "";
		if(final_count_cmpl_yn.equals("Y")){
			disabled = "disabled";
			checked = "checked";
		}
	%>
		<td width="25%" class="label">
		<fmt:message key="eOT.FinalStatusCompleted.Label" bundle="${ot_labels}"/>
		</td>
		<td width="25%" class="fields">
			<input type="checkbox" class="checkbox" <%=disabled%> <%=checked%> name="final_count_cmpl_yn" value="<%=final_count_cmpl_yn%>" onClick="assignCheckboxValue(this)" >
		</td>
	</tr>
</table>
</form>
</body>
</html>

