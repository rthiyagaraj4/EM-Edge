<!DOCTYPE html>
<%@page import="eCA.*,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;	
	String locale = (String) p.getProperty("LOCALE");

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../js/DefaultTranscriberSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<body onMouseDown='CodeArrest();' onKeyDown='lockKey();'>
<form name="formDefaultTransSetupHdr" id="formDefaultTransSetupHdr">
<%
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

	String practitioner_id = "";
	String practitioner_name = "";

	String bean_id = "CATranscriberSetupBean" ;
	
	try
	{
		con = ConnectionManager.getConnection(request);

		String sql = "select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_LANG_VW where PRACT_TYPE = 'TR' and LANGUAGE_ID = ? order by PRACTITIONER_NAME";
		pstmt	= con.prepareStatement(sql);
		pstmt.setString(1, locale);
		rs		= pstmt.executeQuery();
%>

<table border='0' cellspacing='0' cellpadding='0' width='100%' height='100%' align='center'>
	<tr>
		<td class='label' width='25%'><fmt:message key="eCA.Transcriber.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'>
			<select id='transcriber' name='transcriber' id='transcriber' onchange='disableTabs()'>
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
				while(rs.next())
				{
					practitioner_id = rs.getString("PRACTITIONER_ID") == null ? "" : rs.getString("PRACTITIONER_ID");
					practitioner_name = rs.getString("PRACTITIONER_NAME") == null ? "" : rs.getString("PRACTITIONER_NAME");
		%>
				<option value="<%=practitioner_id%>"><%=practitioner_name%></option>	
		<%
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		%>
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td class='label' width='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select id='group_by' name='group_by' id='group_by' onchange='disableTabs()'>
				<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>	
				<option value="PR"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>	
				<option value="SP"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
				<option value="PC"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></option>
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
	</tr>

<%if(!imgUrl.equals("")){ %>
<tr>
<td colspan='4'>
<img src='<%=imgUrl%>' width='100%' height='15' /> 
</td>
<tr>
<%}%>
</table>

<%
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
%>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="transcriber_id" id="transcriber_id" value="">
	<input type="hidden" name="group_by_id" id="group_by_id" value="">
</form>
</body>
</html>


