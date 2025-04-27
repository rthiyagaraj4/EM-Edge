<!DOCTYPE html>
<%--
	FileName	: HealthCareSettingTypeModify.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%!
		public boolean datecompare(java.util.Date dt) {
		java.util.Date systemdate=new java.util.Date();
		if(dt.before(systemdate)) return true;
		else return false;
	}
%>
<%
request.setCharacterEncoding("UTF-8");
String hcare_setting_type_code = request.getParameter("hcare_setting_type_code");
PreparedStatement pstmt=null;
ResultSet rset=null;
Connection conn = null;
String eff_status="",mod_prop="";
%>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
try{


conn = ConnectionManager.getConnection(request);

String sql = "select hcare_setting_type_code,long_desc,short_desc,eff_Status from am_hcare_setting_type	 where hcare_setting_type_code='"+hcare_setting_type_code+"'";
pstmt = conn.prepareStatement(sql);
rset = pstmt.executeQuery();
rset.next();
eff_status=rset.getString("eff_status");


if(eff_status.equals("D"))
{
	mod_prop="READONLY";
}

%>

 <form name='HealthCareSettingType_form' id='HealthCareSettingType_form' action='../../servlet/eAM.HealthCareSettingTypeServlet' method='post' target='messageFrame'>
	 <BR><BR><BR><BR><BR><BR><BR><BR><BR>
	 <div align='left'><table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'><tr><td width='40%'>&nbsp;</td>
	 <td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	 <td width='60%' colspan='2' class='fields'>
<input type='text' name='hcare_setting_type_code' id='hcare_setting_type_code' value='<%= rset.getString("hcare_setting_type_code") %>'  size='1' readonly >

<img src='../../eCommon/images/mandatory.gif'></img>



	</td></tr><tr>
		<td width='40%'>&nbsp;</td>
		<td width='60%' colspan='2'>&nbsp;</td></tr><tr><td  width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </td>
		<td width='60%' colspan='2' class='fields'>
	<input type='text' name='long_desc' id='long_desc' size='30'  onBlur='makeValidString(this)' maxlength='30' value="<%=rset.getString("long_desc")%>"  <%=mod_prop%>>
	
	
	<img src='../../eCommon/images/mandatory.gif'></img></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td><td width='60%' colspan='2' class='fields'>
	<input type='text' onBlur='makeValidString(this)' name='short_desc' id='short_desc' size='15' maxlength='15'  value="<%=rset.getString("short_desc")%>" <%=mod_prop%>>&nbsp;
	<img src='../../eCommon/images/mandatory.gif'></img>
		</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>

	<tr><td  width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='left'>
	<input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");

	out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
//}
	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
}

catch ( Exception e )
{
 out.println(e.toString());
}
finally
	{
  	
			ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>

