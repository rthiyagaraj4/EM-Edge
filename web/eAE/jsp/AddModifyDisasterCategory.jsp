<!-- 
CRF Reference No: ML-MMOH-CRF-2111
Detected Release: JUNE24
File Prepared by: Ajay Hatwate
File Prepared on: 10/04/2024
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript" src="../../eAE/js/DisasterCategory.js"></script>
<script language='javascript'
	src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'> </script>
</head>
<% 

String function = request.getParameter("function")==null?"":request.getParameter("function");
String disaster_category_code = request.getParameter("disaster_category_code")==null?"":request.getParameter("disaster_category_code");
String long_desc="";
String short_desc="";
String enable_value = "";
String is_enable = "";
String disaster_catg_param = "N";
String isReadOnly = "";
String facilityId = (String) session.getValue("facility_id");
Connection con = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
try{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select ENABLE_DISASTER_CATEG from ae_param where operating_facility_id = ?");
	pstmt.setString(1, facilityId);
	rset = pstmt.executeQuery();
	rset.next();
	disaster_catg_param = rset.getString("ENABLE_DISASTER_CATEG");

	System.out.println(disaster_catg_param + " : ENABLE_DISASTER_CATEG ");
}catch(Exception e){
	e.printStackTrace();
}

if(function.equals("modify")){	
String eff_date_from="",eff_date_to="";

try{
con = ConnectionManager.getConnection(request);

StringBuffer sql = new StringBuffer("select disaster_category_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from ae_disaster_category where disaster_category_code='");
sql.append(disaster_category_code);
sql.append("'");
pstmt = con.prepareStatement(sql.toString());
rset = pstmt.executeQuery();
rset.next();
long_desc = rset.getString("long_desc");
short_desc = rset.getString("short_desc");
enable_value = rset.getString("eff_status");

System.out.println(long_desc+ " : " + short_desc+ " : " + enable_value);


if(enable_value.equals("E")){
	is_enable = "checked";	
}else{
	is_enable = "";
	isReadOnly = "READONLY";
}

}catch(Exception e){
	e.printStackTrace();
}
}
%>


<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('case_type_code')">
<form name="disaster_category_form" id="disaster_category_form" action="../../servlet/eAE.DisasterCategoryServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="disaster_catg_code" id="disaster_catg_code" size="2"maxlength="2" onBlur="ChangeUpperCase(this)" value="<%= disaster_category_code %>" onKeyPress="return CheckForSpecChars(event)" <%if(function.equals("modify")){out.print("readonly");} %> ><img src='../../eCommon/images/mandatory.gif'></img>	
	  </td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" value="<%= long_desc %>" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}' <%=isReadOnly %>><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
  <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" value="<%=short_desc %>" size="15" maxlength="15" onBlur='makeValidString(this)' <%=isReadOnly %>><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

<% if(function.equals("modify")){ %>
	<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width="60%" colspan='2' class='fields'><input type="checkbox" onclick="updateEffStatus()" name="eff_status" id="eff_status" value="<%= enable_value %>" <%=is_enable
		%>></td>
	</tr>
	<%}else{ %>
		<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width="60%" colspan='2' class='fields'><input type="checkbox" onclick="updateEffStatus()" name="eff_status" id="eff_status" value="E" checked></td>
	</tr>
<%} %>
   <tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  </table>
</div>
<%if(function.equals("modify")){ %>
<input type="hidden" name="function" id="function" value="modify">
<input type='hidden' name='function_name' id='function_name' value='modify'>
<%}else{ %>
 
<input type="hidden" name="function" id="function" value="insert">
<input type='hidden' name='function_name' id='function_name' value='insert'>
<% }%>

<input type='hidden' name='disaster_catg_param' id='disaster_catg_param' value='<%=disaster_catg_param%>'>

</form>

</body>
</html>

