<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%
//MMS-ME-SCF-0096 vulnerability Issue
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//MMS-ME-SCF-0096 vulnerability Issue
String pract_type = request.getParameter("pract_type");%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script src='../../eAM/js/Practitioner.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad='FocusFirstElement();' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

<%
Connection conn = null;
Statement stmt = null;
ResultSet rset = null;

try
{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

String sql = "select pract_type,desc_sysdef,desc_userdef,seq_no,eff_date_from,eff_date_to,eff_status from am_pract_type where pract_type='"+pract_type+"'";
rset = stmt.executeQuery(sql);
rset.next();%>

 <form name='practitioner_form' id='practitioner_form' action='../../servlet/eAM.PractitionerTypeServlet' method='post' target='messageFrame'> <div><br><br><br><br><br><br><br><br><table border='0' cellpadding='0' cellspacing='0' width='auto' align='CENTER'><tr><td width='10%'>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td width='10%'>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right' class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td><td>&nbsp;&nbsp;

<input type='text' onBlur='makeValidString(this)' name='pract_type' id='pract_type' value='<%=rset.getString("pract_type")%>'  size='4' maxlength='4'  readonly >

<img src='../../eMP/images/mandatory.gif'></img>
<%

if ( rset.getString("eff_status").equals("E") )
{
	out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right'  class='label'><!--width='40%'-->"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDescription.label","common_labels")+"</td><td><!--width='60%' colspan='2'-->&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)'  name='desc_sysdef' id='desc_sysdef' size='15' maxlength='15' value=\""+rset.getString("desc_sysdef")+"\" readonly >");
	 %>
	<% out.println("<img src='../../eMP/images/mandatory.gif'></img></td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td>");
	%> <td align='right'  class='label'><fmt:message key="Common.UserDescription.label" bundle="${common_labels}"/></td><td>&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)'  name='desc_userdef' id='desc_userdef'   size='15' maxlength='15' value="<%=rset.getString("desc_userdef")%>"
	<%
	out.println("> <img src='../../eMP/images/mandatory.gif'></img>");
	out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td  align='right' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SequenceNo.label","common_labels")+"</td><td align='left'>&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)' name='seq_no' id='seq_no' maxlength='3'   size='3'  value='");
	out.println( rset.getString("seq_no"));
	out.println("' readonly >&nbsp;<img src='../../eMP/images/mandatory.gif'></img> </td><td>&nbsp;</td></tr>");
	out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");

	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");

	out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from1' id='eff_date_from1'><input type='hidden' name='eff_date_to1' id='eff_date_to1'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
}
if ( rset.getString("eff_status").equals("D") )
{
	out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right' class='label'><!--width='40%'-->"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDescription.label","common_labels")+"</td><td><!-- width='60%' colspan='2'-->&nbsp;&nbsp;&nbsp;<input type='text'  onBlur='makeValidString(this)' name='desc_sysdef' id='desc_sysdef' size='30' maxlength='30' value='"+rset.getString("desc_sysdef")+"' readonly>");
	out.println("<img src='../../eMP/images/mandatory.gif'></img></td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right'class='label'><!--width='40%'-->"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDescription.label","common_labels")+"</td><td><!--width='60%' colspan='2'-->&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)' name='desc_userdef' id='desc_userdef'  readonly size='15' maxlength='15' value='");
	out.println( rset.getString("desc_userdef"));
	out.println("'> <img src='../../eMP/images/mandatory.gif'></img></td><td>&nbsp;</td></tr>");
	out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td align='right'  class='label'><!--width='40%'-->"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SequenceNo.label","common_labels")+"</td><td><!--width='60%' colspan='2'-->&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)' name='seq_no' id='seq_no' size='15' maxlength='15' value='");
	out.println( rset.getString("seq_no"));
	out.println("' readonly >&nbsp;<img src='../../eMP/images/mandatory.gif'></img></td><td>&nbsp;</td></tr>");

	out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");

	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");

	out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from1' id='eff_date_from1'><input type='hidden' name='eff_date_to1' id='eff_date_to1'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
}
	 if (rset != null)   rset.close();	
	 if (stmt != null) stmt.close();
}
catch ( Exception e )
{
out.println(pract_type);
}

finally 
{
 	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

