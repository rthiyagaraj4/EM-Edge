<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/ProsthesisCategory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String prosthesis_cat_code = request.getParameter("prosthesis_cat_code")==null?"":request.getParameter( "prosthesis_cat_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String catg_disable="";

String prosthesis_cat_desc="";
String status="";
String sql="";

if(mode.equals("modify"))
{
try{
		con=ConnectionManager.getConnection(request);
		// sql=" Select  prosthesis_cat_code, prosthesis_cat_desc,  nvl(status,'E') status from ot_prosthesis_category where prosthesis_cat_code = ?";
		// sql=" Select  prosthesis_cat_code,LONG_DESC,nvl(status,'E') status from OT_PROSTHESIS_CATEGORY_LANG_VW where prosthesis_cat_code = ? and LANGUAGE_ID='"+locale+"' ";

		sql=" Select  prosthesis_cat_code, PROSTHESIS_CAT_DESC LONG_DESC,nvl(status,'E') status from OT_PROSTHESIS_CATEGORY_LANG_VW where prosthesis_cat_code = ? and LANGUAGE_ID= ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,prosthesis_cat_code);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			prosthesis_cat_desc=rs.getString(2);
			status=rs.getString("status");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
}
catch(Exception e)
{
	e.printStackTrace();		
	//out.println(e.toString());
}
finally
{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
}

	catg_disable="disabled";	
}
%>
<form OnMouseDown='CodeArrest()' onKeyDown="lockKey()" name="prosthesis_catg_form" id="prosthesis_catg_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ProsthesisCategoryServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='80%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.ProsthesisCategory.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="prosthesis_cat_code" id="prosthesis_cat_code" value="<%=prosthesis_cat_code%>" size=4 maxlength=4  <%=catg_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' nowrap>
		<input type="text" name="prosthesis_cat_desc" id="prosthesis_cat_desc" value="<%=prosthesis_cat_desc%>"  size=60 maxlength=60 <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label >
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name='prosthesis_cat_code1' id='prosthesis_cat_code1' value="<%=prosthesis_cat_code%>">
<input type=hidden name='prosthesis_cat_desc1' id='prosthesis_cat_desc1' value="<%=prosthesis_cat_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


