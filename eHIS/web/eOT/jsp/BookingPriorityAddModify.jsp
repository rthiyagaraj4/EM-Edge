<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
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
<script language='javascript' src='../../eOT/js/BookingPriority.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->  
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//out.println(mode);
String priority_code = request.getParameter("priority_code")==null?"":request.getParameter( "priority_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String priority_code_disable="";

String priority_desc="";

String status="";
String sql="";
try{
if(mode.equals("modify"))
{
	con=ConnectionManager.getConnection(request);
		//sql=" Select priority_code, priority_desc,nvl(status,'E') status from OT_BOOKING_PRIORITY where priority_code=? ";

		sql=" Select priority_code, priority_desc,nvl(status,'E') status from OT_BOOKING_PRIORITY_LANG_VW where priority_code=? AND LANGUAGE_ID='"+locale+"'  ";


		stmt=con.prepareStatement(sql);
		stmt.setString(1,priority_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			priority_code=rs.getString("priority_code");
			priority_desc=rs.getString("priority_desc");
						
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
		
	priority_code_disable="disabled";	
}
}catch(Exception e){
		 System.err.println("Err Msg in BookingPriority.jsp "+e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<form name="booking_priority_form" id="booking_priority_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.BookingPriorityServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="priority_code" id="priority_code" value="<%=priority_code%>" size=2 maxlength=2  <%=priority_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="priority_desc" id="priority_desc" value="<%=priority_desc%>"  size=30 maxlength=30 <%=disable_flag%>>
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
<input type=hidden name=priority_code1 value="<%=priority_code%>">
<input type=hidden name=priority_desc1 value="<%=priority_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>


