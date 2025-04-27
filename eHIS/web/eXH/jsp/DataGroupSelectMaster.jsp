<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));%>
<% 
 
String dg_code = "";
String dg_desc = "";

String standard_code = "";
String standard_desc = "";
String application_id = "";
String application_name = ""; 

String mode=request.getParameter("mode");
String rule=request.getParameter("rule");
String comm_mode="";
if(mode.equals("U"))
{
	dg_code=request.getParameter("dg_code");
	dg_desc=request.getParameter("dg_desc");

	standard_code=request.getParameter("standard_code");
	standard_desc=request.getParameter("standard_desc");
	application_id=request.getParameter("application_id");
	application_name=request.getParameter("application_name");
	comm_mode=request.getParameter("comm_mode");
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;

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
<script language="javascript" src="../../eXH/js/DataGroupId.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
  
<script>
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghitjklmnopqrsuvwxyzABCDEFGHIJKLMNOTPQRSUVWXYZ';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	} 
function checkEmptyChar(obj)
{
var fields=obj.value;
obj.value=fields.toUpperCase();
if(fields.indexOf(' ')!=-1)
{
alert(getMessage('XH0068','XH'));
obj.focus();
}

}
</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<form name="Datagroupsetup_form" id="Datagroupsetup_form" target='messageFrame' method='post' action='../../servlet/eXH.DataGroupIdAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr> 

<tr>
	<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name='dg_code' id='dg_code' size=20 maxlength=30 value='<%=dg_code%>' onKeyPress='return CheckForSpecCharsforID(event);'  title='DataGroup Code' <%=mode.equals("U")?"readonly":""%> onblur='checkEmptyChar(this);'> <input type=hidden name='dg_codehidden' id='dg_codehidden' value='<%=dg_code%>'><img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name='dg_desc' id='dg_desc' size=20 maxlength=30 value='<%=dg_desc%>' ><input type=hidden name='dg_deschidden' id='dg_deschidden' value='<%=dg_desc%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>
<tr>
<td class='label' ><fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}"/></td>
  <td align=left>
	<select name='Communication_mode' id='Communication_mode'  style="width:155">
	  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
      <option value='O' <%=comm_mode.equals("O")?"selected":""%>><fmt:message key="eXH.Outbound.Label"  bundle="${xh_labels}"/></option>
      <option value='I' <%=comm_mode.equals("I")?"selected":""%>><fmt:message key="eXH.Inbound.Label"  bundle="${xh_labels}"/></option>
	</select> <img src='../../eCommon/images/mandatory.gif' align=middle><input type=hidden name='commode_deschidden' id='commode_deschidden' value='<%=XHDBAdapter.checkNull(comm_mode)%>'> 
  </td>
  	<td></td> <td></td> 
</tr> 
<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td align=left>
	<input type="hidden" name="standard_code" id="standard_code" size=10   value="<%=XHDBAdapter.checkNull(standard_code)%>">
	<input type=text id="standard_desc"  name ='standard_desc' size=40 value='<%=XHDBAdapter.checkNull(standard_desc)%>'   onBlur="searchStandardCode()"> <input class="button"  type="button"  name='standard_code_search' id='standard_code_search' value='?'    onClick="searchStandardCode()"><input type=hidden name='standard_deschidden' id='standard_deschidden' value='<%=XHDBAdapter.checkNull(standard_desc)%>'>
	<img src='../../eCommon/images/mandatory.gif' align=middle></td> 
<td></td> <td></td>
</tr>  

<tr>
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=hidden id="application_id"  name ='application_id' value='<%=XHDBAdapter.checkNull(application_id)%>' size=10 >
<input type=text id="application_name"  name ='application_name' value='<%=XHDBAdapter.checkNull(application_name)%>' size=40   onBlur="searchApplication();" > <input class="button"  type="button"  name='ApplicationSearch' id='ApplicationSearch' value='?'    onClick="searchApplication();" ><input type=hidden name='application_namehidden' id='application_namehidden' value='<%=XHDBAdapter.checkNull(application_name)%>'>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<% if(mode.equals("U")) { %>
 
<tr>
<td colspan=2></td>
<td colspan=2 class='BUTTON'> 
<input class='button' type="button"  name='add_butt' id='add_butt' value='<fmt:message key="eXH.AddmsgRoutingCriteria.Label" bundle="${xh_labels}"/>'  onClick='funAdd()'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
</td>
</tr>

<% } %>

<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table> 
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=comm_mode value='<%=comm_mode%>'>
<input type=hidden name=rule value='<%=rule%>'>
</form>
<script>
if(document.forms[0].act_mode.value=='U' && document.forms[0].rule.value=='U')
{
	
}
else if(document.forms[0].act_mode.value=='U' && document.forms[0].rule.value=='R')
{
dispmode();
}
else
{
	
}
</script>
</BODY> 
</HTML> 

