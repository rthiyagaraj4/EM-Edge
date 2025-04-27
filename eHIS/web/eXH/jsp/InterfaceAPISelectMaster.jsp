<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
// String selected = "selected";
String chkDisp = "none";
%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/InterfaceAPI.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String api_code="";
String api_desc="";
String api_type="";
String exec_nature="";

String mode			=	request.getParameter("mode");
	//System.out.println("mode : "+mode);

if(mode.equals("U"))
{
//	api_code=request.getParameter("api_code");
	api_desc=request.getParameter("api_desc");
	api_type=request.getParameter("api_type");
	exec_nature=request.getParameter("exec_nature");
	//language_id=request.getParameter("lang_id");
	chkDisp = "block";
}

	api_code=request.getParameter("api_code");

%>

<form name="InterfaceAPI_setup_form" id="InterfaceAPI_setup_form" target='messageFrame' method='post' action='../../servlet/eXH.InterfaceAPIAddModifyServlet'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=api_code size=25 maxlength=50 value='<%=XHDBAdapter.checkNull(api_code)%>'   <%=mode.equals("U")?"readonly":""%> > <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=api_desc size=25 maxlength=90 value='<%=api_desc%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>


<tr>
<td class=label ><fmt:message key="eXH.APIType.Label" bundle="${xh_labels}"/></td>
<td align=left>
<select class='select' name='api_type' id='api_type'  "+disabled+" >
            <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			<option value='D' <%=api_type.equals("D")?"selected":""%>><fmt:message key="eXH.CommDataIOAPI.Label" bundle="${xh_labels}"/></option>
			<option value='S' <%=api_type.equals("S")?"selected":""%>><fmt:message key="eXH.CommStatisticsAPI.Label" bundle="${xh_labels}"/></option>
			<option value='F' <%=api_type.equals("F")?"selected":""%>><fmt:message key="eXH.FileNamingAPI.Label" bundle="${xh_labels}"/></option>
</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ExecNature.Label" bundle="${xh_labels}"/></td>
<td align=left>
<select class='select' name='exec_nature' id='exec_nature'  "+disabled+" >
            <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			<option value='A' <%=exec_nature.equals("A")?"selected":""%>><fmt:message key="eXH.APIBased.Label" bundle="${xh_labels}"/></option>
			<option value='Q' <%=exec_nature.equals("Q")?"selected":""%>><fmt:message key="eXH.QueryBased.Label" bundle="${xh_labels}"/></option>
			<option value='T' <%=exec_nature.equals("T")?"selected":""%>><fmt:message key="eXH.TableBased.Label" bundle="${xh_labels}"/></option>
		
</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
	<td width='20%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>
</table>


<div id='button_disp' style="display:<%=chkDisp%>;" >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan=2> </td>
	<td class='BUTTON' colspan=2 align=right>
		<input class='button' type="button"  name='add_butt' id='add_butt' value='<fmt:message key="eXH.AddDetails.Label" bundle="${xh_labels}"/>'  onClick='funAdd()'>
		<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
	</td>
</tr>
</table>
</div>	

	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 

