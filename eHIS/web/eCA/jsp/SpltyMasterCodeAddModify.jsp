<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpltyMasterCode.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name='SpltyMasterCodeAddForm' id='SpltyMasterCodeAddForm'>
	<%
		String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
		String splty_mst_code = request.getParameter("splty_mst_code") == null ? "" : request.getParameter("splty_mst_code");
		String short_desc = request.getParameter("shortDesc") == null ? "" : request.getParameter("shortDesc");
		String long_desc = request.getParameter("longDesc") == null ? "" : request.getParameter("longDesc");
		String eff_status = request.getParameter("effStatus") == null ? "E" : request.getParameter("effStatus");
		String mast_type_ref = request.getParameter("mast_type_ref") == null ? "" : request.getParameter("mast_type_ref");
		String clearvalue = request.getParameter("clearvalue") == null ? "" : request.getParameter("clearvalue");

		String chk = "checked";
		String bvalue = "Add";
		String dis = "";
		String read = "";
		if(!splty_mst_code.equals(""))
		{
			bvalue = "Modify";
			mode = "update";
			read = "readonly";
		}
		else
		{
			bvalue = "Add";
			mode = "insert";
			read = "";
		}
		if(eff_status.equals("E"))
		{
			chk = "checked";
			dis = "";
		}
		else
		{
			chk = "";
			dis = "disabled";
		}
	%>
	<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class ='fields'><input type='text' name='code' id='code' value='<%=splty_mst_code%>' size='6' <%=dis%> maxlength = '4' <%=read%> onkeypress='return CheckForSpecChars(event)' onBlur='changeCase(this);'><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
		</tr>
		<tr>
			<td class ='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class ='fields'><input type='text' name='longDesc' id='longDesc' value='<%=long_desc%>' size='30' maxlength='40' <%=dis%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
		</tr>
		<tr>
			<td class ='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class ='fields'><input type='text' name='shortDesc' id='shortDesc' value='<%=short_desc%>' maxlength='30' <%=dis%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
		</tr>
		<tr>
			<td class ='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class ='fields'><input type='checkbox' name='enabled' id='enabled' <%=chk%> value=''></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<input type='button' name='add' id='add' value='<%=bvalue%>' class='button' onClick='addPanel()'>
				<input type='button' name='clear' id='clear' value='Clear' class='button' onClick='onClear()'>
			</td>
		</tr>
	</table>

	<input type=hidden name='mast_type_ref' id='mast_type_ref' value='<%=mast_type_ref%>'>
	<input type=hidden name='mode' id='mode' value='<%=mode%>'>
	<input type=hidden name='clearvalue' id='clearvalue' value='<%=clearvalue%>'>
	<input type=hidden name='code1' id='code1' value='<%=splty_mst_code%>'>
	</form>
	</body>
</html>

