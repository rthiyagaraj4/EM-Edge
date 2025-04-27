<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%	
	request.setCharacterEncoding("UTF-8");	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

	Properties properties = (Properties)session.getValue("jdbc");
    String locale = (String)properties.getProperty("LOCALE");

	
	try
  {
    con = ConnectionManager.getConnection(request);
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String antibody_code	= "";
	String short_desc	= "";
	String last_date	="";
	String classValue	= "gridData";
	String sql = "";
	int    i	= 0;

    sql = "SELECT A.ANTIBODY_CODE ANTIBODY_CODE1,	A.SHORT_DESC SHORT_DESC1,to_Char(B.LAST_REPORTED_DATE,'dd/mm/yyyy hh24:mi')  LAST_DATE1 FROM BT_ANTIBODY_CODE_MAST_LANG_VW A,BT_PATIENT_ANTIBODY B	WHERE A.ANTIBODY_CODE=B.ANTIBODY_CODE AND B.PATIENT_ID = ? and A.Language_id = ?";

%>
<form name="antibody_details" id="antibody_details">

	<table width="100%"  class="grid">
	<tr>
		<th width="20%" ><fmt:message key="eCA.PatientAntibody.label" bundle="${ca_labels}"/></th>
		<th width="55%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width="25%"><fmt:message key="eCA.LastReportedDate.label" bundle="${ca_labels}"/></th>
	</tr>
<%
	   pstmt= con.prepareStatement(sql);
	   pstmt.setString(1,patient_id);
	   pstmt.setString(2,locale);
	   rs = pstmt.executeQuery();
	   	while(rs!=null && rs.next())
		{
			antibody_code			= (rs.getString("ANTIBODY_CODE1").equals(""))?"":rs.getString("ANTIBODY_CODE1");
	        short_desc				= (rs.getString("SHORT_DESC1").equals(""))?"":rs.getString("SHORT_DESC1");
	        last_date				= (rs.getString("LAST_DATE1").equals(""))?"":rs.getString("LAST_DATE1");
			//Date Conversion added by Archana Dhal on 11/23/2010 related to incident no. IN025159.
			last_date = com.ehis.util.DateUtils.convertDate(last_date,"DMYHM","en",locale);

			i++;
%>
			<tr>
				<td width="20%"  class="<%=classValue%>"><%=antibody_code%></td>
				<td width="55%"  class="<%=classValue%>"><%=short_desc%></td>
	 		    <td width="25%"  class="<%=classValue%>"><%=last_date%></td> 

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

