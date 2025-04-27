<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EmailRepControlSetup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String sql_module_id="";
	String sql_module_name="";
	String sql="";
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="EmailRepControlSetupHdrForm" id="EmailRepControlSetupHdrForm" action="" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding=3 width='95%' align='center'>
<tr>
<td class=label align='right' width='11%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='module_id' id='module_id'  onchange='populateReportId(this);populateFormVals(this,report_id);'><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try {
								
	con = ConnectionManager.getConnection(request);
	sql="select module_id,module_name from sm_module where install_yn='Y' and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_module.module_id)  order by 2";
	stmt = con.prepareStatement(sql);
	rs = stmt.executeQuery();
	while( rs != null &&  rs.next())
	{
		sql_module_id = rs.getString( "module_id" ) ;
		sql_module_name = rs.getString( "module_name" ) ;
		out.println("<option value='"+sql_module_id+"'>"+sql_module_name+"</option>");
	}
	if( rs != null )  rs.close();
	if( stmt != null )  stmt.close();
								
} catch(Exception e) {
	
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
</select><img src='../../eCommon/images/mandatory.gif' ></img></td>

<td class=label><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
<td class='fields' ><select name='report_id' id='report_id' onChange='populateFormVals(module_id,this)'><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
</select><img src='../../eCommon/images/mandatory.gif' ></img></td>
</tr>
</table>
</form>
</body>
</html>

