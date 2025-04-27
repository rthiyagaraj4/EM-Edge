<!DOCTYPE html>
<%--
    Created: S V Narayana
	Created on 	: 14-04-2009
 --%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	java.util.Date currentdate=new java.util.Date();
	java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy");
	String sysdt=sf.format(currentdate);
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%  
    Connection conn = null;
	conn = ConnectionManager.getConnection(request);
try{
request.setCharacterEncoding("UTF-8");
	PreparedStatement pstmt=null;
	ResultSet rset=null;
    String s_desc="";
    String l_desc="";
    String eff_status="";
    String mod_prop="";
	String function_name=request.getParameter("function_name")==null?"":request.getParameter("function_name");
	String facility_category_code=request.getParameter("facility_category_code")==null?"":request.getParameter("facility_category_code");

try{
	//conn = ConnectionManager.getConnection(request);
	String sql = "select facility_level_code,long_desc,short_desc,eff_Status from sm_facility_level	 where facility_level_code=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString	(	1,	facility_category_code		);
	rset = pstmt.executeQuery();
	while(rset.next())
		{
	eff_status=rset.getString("eff_Status");
	l_desc=rset.getString("long_desc");
	s_desc=rset.getString("short_desc");
		}

	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;

if(eff_status.equals("D"))
{
	mod_prop="READONLY";
}
}
	catch ( Exception e )
{
	out.println(e.toString());
}
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eSM/js/FacilityCategory.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'> 
<form name="FacilityCategory_form" id="FacilityCategory_form" action="../../servlet/eSM.FacilityCategoryServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>

<div  align="left">

  <table border="0" cellpadding="0" cellspacing="0" width='75%' align='center'>
  <tr class="label">
  	<td width="50%" class="label" >&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<% if(function_name.equals("insert"))
	 {%>
     <td width="50%" colspan="2" class="fields">
	  <input type="text" onKeyPress="return CheckForSpecChars(event)" onblur="SpeCharCheck(this)"  name="facility_category_code" id="facility_category_code" size="2" maxlength="2" onBlur="ChangeUpperCase(this)"><img src='../../eCommon/images/mandatory.gif'></img>
     </td>
	 <%} else
	 {%>
     <td width="50%" colspan="2" class="fields">
	  <input type="text" onKeyPress="return CheckForSpecChars(event)"  name="facility_category_code" id="facility_category_code" size="2" value="<%=facility_category_code%>"maxlength="2" onBlur="ChangeUpperCase(this)" readonly><img src='../../eCommon/images/mandatory.gif'></img>
	 <%}%>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<% if(function_name.equals("insert"))
	 {%>
	<td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)' name="long_desc" id="long_desc" size="30" maxlength="30"><img src='../../eCommon/images/mandatory.gif'></img></td>
	<% } else {%>
		<td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)' name="long_desc" id="long_desc"  value="<%=l_desc%>" size="30" maxlength="30" <%=mod_prop%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<%}%>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
	<td width="50%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<% if(function_name.equals("insert"))
	 {%>
    <td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)'  name="short_desc" id="short_desc" size="15" maxlength="15"><img src='../../eCommon/images/mandatory.gif'></img></td>
	<%} else {%>
	    <td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)'  name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=s_desc%>" <%=mod_prop%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<% }%>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
	 <input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"  onblur="CheckDate(this,'<','<%=sysdt%>','chksysdt')" maxlength="10"><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  onblur="CheckDate(this,'<','<%=sysdt%>','chksysdt')" maxlength="10">
  <tr>
	<td width="50%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<% if(function_name.equals("insert"))
	{%>
    <td width="50%" colspan="2" class="fields"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
	<%} else {%>
    <td width="50%" colspan="2" class="fields"><input type="checkbox" name="eff_status" id="eff_status" value="E" 
	<%
	if  ( eff_status.equals("E") )
	  {
		out.println("checked >");
		}
	else
	{
		out.println(">");
	}
	 out.println("</td></tr>");
		}%>

  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
</table>
</div>
<input type="hidden" name="function_name" id="function_name" value="<%=function_name%>">
</form>
<% }
	catch ( Exception e )
{
	out.println(e.toString());
}
    finally { 
    ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>

