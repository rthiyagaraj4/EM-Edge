<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EmailRepBodyTxt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String sql_module_id="";
	String sql_module_name="";
	String sql="";
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String module_id="";
	String report_id="";
	String report_desc="";
	String body_text_ref="";
	String body_text_dec="";
	String readOnly="";
	if(mode.equals("modify")){
		readOnly="readonly";
		module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
		report_id=request.getParameter("report_id")==null?"":request.getParameter("report_id");
		report_desc=request.getParameter("report_desc")==null?"":request.getParameter("report_desc");
		body_text_ref=request.getParameter("body_text_ref")==null?"":request.getParameter("body_text_ref");
		body_text_dec=request.getParameter("body_text_dec")==null?"":request.getParameter("body_text_dec");
	}
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">

<form name="EmailRepBodyTxtHdrForm" id="EmailRepBodyTxtHdrForm" action="../../servlet/eCA.EmailRepBodyTxtServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding=3 width='100%' align='center'>
<tr>
<td class=label align='right' width='11%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='moduleId' id='moduleId'  onchange='populateReportId(this)'><option value="<%=module_id%>">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try {
								
	con = ConnectionManager.getConnection(request);
	sql="select module_id,module_name from sm_module where install_yn='Y' and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_module.module_id)  order by 2 ";
	stmt = con.prepareStatement(sql);
	rs = stmt.executeQuery();
	while( rs != null &&  rs.next())
	{
		sql_module_id = rs.getString( "module_id" ) ;
		sql_module_name = rs.getString( "module_name" ) ;
		if(module_id.equals(sql_module_id))
		out.println("<option selected value='"+sql_module_id+"'>"+sql_module_name+"</option>");
		else
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
<td class='fields' ><select name='reportId' id='reportId' onchange='openEditor()'>
<%if(mode.equals("modify")){%>
<option value="<%=report_id%>"><%=report_desc%></option>

<%}else{%>
<option value="<%=report_id%>">
-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%}%>
</select><img src='../../eCommon/images/mandatory.gif' ></img></td>
</tr>
<tr>
<td class=label align='right' width='11%' nowrap><fmt:message key="eCA.ReportBodyTextID.label" bundle="${ca_labels}"/></td>
<td class='fields' ><input type="text" name="body_text_ref" id="body_text_ref" size=4 maxlength=4  value="<%=body_text_ref%>" <%=readOnly%> onkeypress="return CheckForSpecChars(event)" 	onBlur='ChangeUpperCase(this);' ><img src='../../eCommon/images/mandatory.gif'></td>
<td class=label align='right' width='11%' nowrap><fmt:message key="eCA.ReportBodyTextDesc.label" bundle="${ca_labels}"/></td>
<td class='fields'><input type="text" name="body_text_dec" id="body_text_dec" value="<%=body_text_dec%>" size=30 maxlength=30  onBlur="return makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
<input type="hidden" name="report_id" id="report_id" value="<%=report_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</table>
</form>
</body>
</html>
<script>
openEditor()
</script>

