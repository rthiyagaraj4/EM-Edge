<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EMail.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String module_id="";
String report_id="";
//String from="";
//String to="";
String disclaimer="";
String disclaimerId="";


module_id		=(request.getParameter("module_id")==null)?"":request.getParameter("module_id");
report_id		=(request.getParameter("report_id")==null)?"":request.getParameter("report_id");
disclaimerId		=(request.getParameter("disclaimerId")==null)?"":request.getParameter("disclaimerId");
//from		=(request.getParameter("from")==null)?"":request.getParameter("from");
//to=(request.getParameter("to")==null)?"":request.getParameter("to");
disclaimer=(request.getParameter("disclaimer")==null)?"":request.getParameter("disclaimer");
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

//out.println("<script>alert('disclaimerId ---"+disclaimerId+"---');</script>");

try{

con=ConnectionManager.getConnection(request);
if(!module_id.equals("") && !report_id.equals("")){
pstmt=con.prepareStatement("select disclimer_text from ca_disclimer_txt_lang  where disclimer_code=? and language_id=?");
pstmt.setString(1,disclaimerId);
pstmt.setString(2,locale);
rs=pstmt.executeQuery();
while(rs.next()){
	disclaimer=rs.getString("disclimer_text")==null?"":rs.getString("disclimer_text");
}
}

%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='' onKeyDown="lockKey()">
<form name="EMailBtmForm" id="EMailBtmForm" action="../../servlet/eCA.EMailServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding='3' width='100%' align=center>
<!-- <tr>
	<td colspan='4'>&nbsp;</td>
</tr> -->
<tr>
	<td class=label ><fmt:message key="eCA.Disclaimer.label" bundle="${ca_labels}"/>:</td>
	<td class='fields' colspan='2'>&nbsp;<%=disclaimer%></td>
	<td width='10%'><a href='#' onclick="viewAttchmnt()"><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></a></td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
	<td class='fields' align='right'><input type="button" name="send" id="send" class="button" value='<fmt:message key="eCA.Send.label" bundle="${ca_labels}"/>' onclick="apply()"><input type="button" name="cancel" id="cancel" class="button" value='<fmt:message  key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="cancelRecord()" ></td>
</tr>
<tr>
	<td colspan='4'>&nbsp;</td>
</tr>

</table>
<input type="hidden" name ="disclaimer" value="<%=disclaimer%>" >
</form>
</body>
<%}catch(Exception e){
	
	e.printStackTrace();
}finally{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		
		if(con!=null) ConnectionManager.returnConnection(con,request);

		
	}	
%>
</html>

