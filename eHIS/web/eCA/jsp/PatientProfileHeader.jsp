<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
        <script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body class="COMMON_TOOLBAR" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%

	String patient_id = request.getParameter("patient_id");
	if(patient_id==null)		patient_id			=	"";
	String patient_info = "";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");

	String strSql = "";
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement pstmt  = null;

try
{
	con =  ConnectionManager.getConnection(request);
	strSql="select replace(get_patient.get_line_detail(?,?),'|', ',  ') Pline FROM dual";
	pstmt = con.prepareStatement(strSql);
	pstmt.setString(1,patient_id);
	pstmt.setString(2,locale);
	oRs = 	pstmt.executeQuery();

	if (oRs.next())
		patient_info = oRs.getString("Pline");
%>
<br>
<div id="printArea">
<p>
<b>
<%=patient_info%> </b>
</p>
</div>
<script>
	top.window.document.title = "<%=patient_info%>";
</script>
<%	
	if(oRs!=null) oRs.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ 3444"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

