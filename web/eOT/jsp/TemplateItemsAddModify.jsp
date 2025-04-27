<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>


<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/TemplateItems.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head> 
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>  <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt = null;
ResultSet rs = null;
String mode = request.getParameter("mode");
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String item_code_disable="";
String description="";
String status="";
String sql="";

if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT ITEM_CODE, DESCRIPTION, nvl(STATUS,'E') status FROM OT_SWAB_INSTR_ITEMS_LANG_VW WHERE LANGUAGE_ID= ? AND ITEM_CODE=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,item_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			item_code=rs.getString("item_code");
			description=rs.getString("description");
			
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
		
	item_code_disable="disabled";	
}catch(Exception e)
	{
	e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}
}

%>
<form name="template_item_form" id="template_item_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.TemplateItemsServlet" method="post" target="messageFrame" > 
<br><br><br><br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center >
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="item_code" id="item_code" value="<%=item_code%>" size=4 maxlength=4  <%=item_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label align=left>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="description" id="description" value="<%=description%>"  size=30 maxlength=30 <%=disable_flag%> >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
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
<input type=hidden name=item_code1 value="<%=item_code%>">
<input type=hidden name=description1 value="<%=description%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


