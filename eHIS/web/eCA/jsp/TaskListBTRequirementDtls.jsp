<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	Connection con =null;
    PreparedStatement pstmt  = null;
    ResultSet rs = null;

	Properties properties = (Properties)session.getValue("jdbc");
    String locale = (String)properties.getProperty("LOCALE");
	try
  {
	con = ConnectionManager.getConnection(request);
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String 	requirement_code	= "";
	String  short_desc	= "";
	String  classValue	= "gridData";
	String  sql  = "";
	int    i = 0;

	sql = "SELECT A.REQUIREMENT_CODE REQUIREMENT_CODE1,A.SHORT_DESC SHORT_DESC1 FROM BT_TRANSFUSE_REQ_LANG_VW A, BT_PATIENT_REQUIREMENT B WHERE A.REQUIREMENT_CODE = B.REQUIREMENT_CODE AND B.PATIENT_ID = ? and A.Language_id = ?";

%>
<form name="requirement_details" id="requirement_details">
	<table width="100%" class="grid">
	<tr>
		<th width="35%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width="65%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	</tr>

<%
	   pstmt= con.prepareStatement(sql);
	   pstmt.setString(1,patient_id);
	   pstmt.setString(2,locale);
	   rs = pstmt.executeQuery();
	   	while(rs!=null && rs.next())
		{
			 requirement_code				=(rs.getString("REQUIREMENT_CODE1").equals(""))?"":rs.getString("REQUIREMENT_CODE1");
	         short_desc				=(rs.getString("SHORT_DESC1").equals(""))?"":rs.getString("SHORT_DESC1");

			i++;


%>
			<tr>
				<td width="35%"  class="<%=classValue%>"><%=requirement_code%></td>
				<td width="65%"  class="<%=classValue%>"><%=short_desc%></td>
			</tr>

<%
	    }
		if(i == 0)
		{
%>
           <script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();
		   </script>
<% 
		}
					
 }
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>

</table>
</form>
</body>
</html>

