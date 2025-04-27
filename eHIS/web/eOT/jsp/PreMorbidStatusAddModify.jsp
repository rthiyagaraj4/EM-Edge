<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/PreMorbidStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");

String premorbid_code = request.getParameter("premorbid_code")==null?"":request.getParameter( "premorbid_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String premorbid_code_disable="";

String long_desc="";
String short_desc="";

String status="";
String sql="";

if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		sql=" Select premorbid_code, long_desc, short_desc, nvl(status,'E') status from AT_PREMORBID_MAST where premorbid_code=?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,premorbid_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{	long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			
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
		
	premorbid_code_disable="disabled";	
}catch(Exception e)
	{
		e.printStackTrace();
		//System.err.println("Err PreMorbidStatusAddModify" +e);
	//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
			//System.err.println("Err PreMorbidStatusAddModify" +e);
			//out.println("Exception is "+e);
			}
		
		}
}

%>
<form name="pre_morbid_status_form" id="pre_morbid_status_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.PreMorbidStatusServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%'  align=center>
<tr>
	<td class='label' width="25%">
	<fmt:message key="eOT.PreMorbidCode.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%">
	<input type="text" name="premorbid_code" id="premorbid_code" value="<%=premorbid_code%>" size=6 maxlength=6  <%=premorbid_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class='label' width="25%">
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
	<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size=20 maxlength=30 <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label width="25%" >
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"   size='15' maxlength='15' <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='feilds' width="25%">
	<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>

</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='premorbid_code1' id='premorbid_code1' value="<%=premorbid_code%>">
<input type="hidden" name='long_desc1' id='long_desc1' value="<%=long_desc%>">
<input type="hidden" name='short_desc1' id='short_desc1' value="<%=short_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


