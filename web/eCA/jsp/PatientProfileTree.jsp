<!DOCTYPE html>

<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
        <script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script src="../js/PatHighRisk.js" language="javascript"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name=frm action="PatientProfileContent.jsp" method=post target=fraPatientContent>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
//	String patient_profile = "";
	StringBuffer strSql = new StringBuffer();
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement stmt = null;

try
	{
	con  =  ConnectionManager.getConnection(request);
	if(strSql.length() > 0) strSql.delete(0,strSql.length());
	/*strSql.append("select CONTENT_ID,");
	strSql.append("NVL(CONTENT_USER_DEF_DESC,CONTENT_SYS_DEF_DESC)"); strSql.append(" TITLE_DESC ");
	strSql.append(" FROM ca_patient_profile_content ");
	strSql.append(" WHERE INCLUDE_YN='Y' ");
	strSql.append(" ORDER BY ORDER_SEQ_NO"); */

	strSql.append("select CONTENT_ID,");
	strSql.append("NVL(CONTENT_USER_DEF_DESC,CONTENT_SYS_DEF_DESC)"); 
	strSql.append(" TITLE_DESC ");
	strSql.append(" FROM CA_PAT_PROF_CONT_LANG_VW ");
	strSql.append(" WHERE INCLUDE_YN='Y' AND LANGUAGE_ID = ? ");
	strSql.append(" ORDER BY ORDER_SEQ_NO");

	stmt = con.prepareStatement(strSql.toString());
	stmt.setString(1,locale);
	oRs = 	stmt.executeQuery();
	int counter =0;
	%>
	<table >

	<tr><td class='columnheader' ><input type=checkbox name=check value=Y onclick="checkAll('<%=patient_id%>',this)" ></td><td class='columnheader' style="background-color: black; color: white;"><fmt:message key="eCA.ProfileContent.label" bundle="${ca_labels}" /></td></tr>
	<%	

	while(oRs.next())
	{	%>
			<tr onMouseOver="funOver(this);" onMouseOut="funOut(this);"> 
				<td><input type=checkbox name=chk<%=oRs.getString("content_id")%> value=Y <%if(oRs.getString("content_id").equals("8")){%>onclick="callHighRisk('<%=patient_id%>',this)"<%}%>></td>
				<td > 
				<!--<a  href="../../eCA/jsp/PatientProfileContent.jsp#<%=oRs.getString("content_id")%>"   target=fraPatientContent onclick="showLink('<%=oRs.getString("content_id")%>','<%=patient_id%>',this)" > <%=oRs.getString("title_desc")%> </a> -->
				<a class='gridLink' href = "javascript:showLink('<%=oRs.getString("content_id")%>','<%=patient_id%>',this)"><%=oRs.getString("title_desc")%></a>
				<input type=hidden id=contentId<%=counter%> value=<%=oRs.getString("content_id")%>></td>
			</tr>
		<%	
		counter++;
	}

%>	
	<tr><td colspan=2 align=center><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Show.label","ca_labels")%>' onclick="show()"></td></tr> 
	<!---->
	</table>

<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="patient_profile" id="patient_profile" value="P">

<input type="hidden" name=counter value="<%=counter%>">
<%
	if(oRs!=null) oRs.close();
	if(stmt!=null) stmt.close();
	
}
catch(Exception e)
{
	//out.println("Exception @ try"+ e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(con!=null) ConnectionManager.returnConnection(con,request);

}
	%>
</form>
</body>
</html>

