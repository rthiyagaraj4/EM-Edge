<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
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
	<script language='javascript' src='../../eOT/js/ProsthesisType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");

String prosthesis_type = request.getParameter("prosthesis_type")==null?"":request.getParameter( "prosthesis_type" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String catg_disable="";

String prosthesis_type_desc="";
String status="";
String sql="";

if(mode.equals("modify"))
{
try{
	con=ConnectionManager.getConnection(request);
		sql=" Select  prosthesis_type, prosthesis_type_desc,  nvl(status,'E') status from ot_prosthesis_type where prosthesis_type = ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,prosthesis_type);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			prosthesis_type_desc=rs.getString("prosthesis_type_desc");
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
<form OnMouseDown='CodeArrest()' onKeyDown="lockKey()" name="prosthesis_type_form" id="prosthesis_type_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ProsthesisTypeServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='80%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class=label><fmt:message key="eOT.ProsthesisType.Label" bundle="${ot_labels}"/></td>
	<td class='fields'><input type="text" name="prosthesis_type" id="prosthesis_type" value="<%=prosthesis_type%>" size=4 maxlength=4  <%=catg_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  nowrap><input type="text" name="prosthesis_type_desc" id="prosthesis_type_desc" value="<%=prosthesis_type_desc%>"  size=60 maxlength=60 <%=disable_flag%>><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
	</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=prosthesis_type1 value="<%=prosthesis_type%>">
<input type=hidden name=prosthesis_type_desc1 value="<%=prosthesis_type_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


