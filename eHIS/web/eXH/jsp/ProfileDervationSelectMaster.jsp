<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params="";
params=(String)session.getAttribute("params");
params=params+"&expand="+"&home_required_yn=N";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
//String selected = "selected";
//String defaultval = "";
String code_yn="";
String element_id="";   
//String element_desc="";
//String Profile_id=request.getParameter("Profile_id");

element_id=request.getParameter("element_id");

%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/ProfiledervationRefrence.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script language="JavaScript">
//function funAdd

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="application_element_setup_form" id="application_element_setup_form">
<table cellspacing=0 cellpadding=4 width='100%' align=center >
<!---<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>--->
<tr><td class=label ><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
<td align=left><input type='text' size='15' name='Profile_name' id='Profile_name' id='Profile_name'  maxlength=3 ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElementSearch1 value='?' onClick='searchProfileID();'><input type="hidden" name="Profile_id" id="Profile_id" value=""><img src='../../eCommon/images/mandatory.gif' align=middle></td><!--<input type=text id="datainput_"  name =Profile_Idtxt size=25 value='' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ProfileIDSearch value='?'    onClick="searchProfileID()"><input type="hidden" name="Profile_id" id="Profile_id" value="null">
<td class='fields'><img src='../../eCommon/images/mandatory.gif' align=middle> </td>-->
<td class=label ><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="datainput_api"  name =element_desc size=25 value='' >
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=elementIDSearch value='?'    onClick="searchElementID()"><input  type="hidden" name=Action_code value='afsa'/>
<input type="hidden" name="element_id" id="element_id" value="<%=element_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr><tr><td colspan=6 class='BUTTON'>
<input class='button' type="button"  name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick='funAdd("A")'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch("U")'>
</td>
</tr>
<tr>
<!--	<td width='30%'></td>
	<td width='70%'></td> -->
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>
<%		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
<input  type="hidden" name=code value='<%=code_yn%>'/>
</form>
</BODY>
</HTML>

