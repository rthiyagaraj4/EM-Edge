<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));%>
<% 

String module_Id="";   
String module_Name="";

String sub_module_id = "";
String sub_module_desc = "";

String mode=request.getParameter("mode");

if(mode.equals("U"))
{
	module_Id=XHDBAdapter.checkNull(request.getParameter("module_Id"));
	module_Name=XHDBAdapter.checkNull(request.getParameter("module_Name"));

	sub_module_id=XHDBAdapter.checkNull(request.getParameter("sub_module_id"));
	sub_module_desc=XHDBAdapter.checkNull(request.getParameter("sub_module_desc"));
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;

%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/DomainApplication.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<form name="InterfaceMod_setup_form" id="InterfaceMod_setup_form" target='messageFrame' method='post' action='../../servlet/eXH.InterfaceModulesAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>

<tr>
	<td class=label >Interface Domain</td>
	<td align=left>
		<input type="hidden" name="module_Id" id="module_Id" size=10 maxlength=2 value="<%=XHDBAdapter.checkNull(module_Id)%>" <%=mode.equals("U")?"readonly":""%> >
		<input type=text id="module_Name"  name =module_Name size=35 value='<%=module_Name%>' <%=mode.equals("U")?"readonly":""%>   onBlur='searchModuleName();' > <input type="button"  name=moduleNameSearch value='?'    onClick='searchModuleName();' <%=mode.equals("U")?"disabled":""%>>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr> 

<tr>
	<td class=label >Sub Domain</td>
	<td align=left><input type=text name='sub_module_id' id='sub_module_id' size=10 maxlength=6 value='<%=sub_module_id%>' <%=mode.equals("U")?"readonly":""%> title='Sub domain' onblur='ChangeUpperCase(this);chkTables(this);'> <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label >Description</td>
	<td align=left><input type=text name='sub_module_desc' id='sub_module_desc' size=35 maxlength=30 value='<%=sub_module_desc%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td width='20%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>
</table>
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type=hidden name=act_mode value='<%=mode%>'>


</form>

</BODY>
</HTML> 

