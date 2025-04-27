<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Checklistsmodified.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disable=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body onload="parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=checkForNull(request.getParameter("update_mode_yn"));

String checklist_code = request.getParameter("checklist_code")==null?"":request.getParameter( "checklist_code" );
if(checklist_code.equals("null") || checklist_code=="null")
{
	checklist_code="";
}
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String checklist_code_disable="";
String description="";
String status="";
String sql="";
StringBuffer checklist_code_from_DB=new StringBuffer();
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT CHECKLIST_CODE, DESCRIPTION, NVL(STATUS,'E') status FROM OT_CHECKLIST_HDR WHERE CHECKLIST_CODE=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,checklist_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			checklist_code=rs.getString("checklist_code");
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
		
	checklist_code_disable="disabled";	
}catch(Exception e)
	{
		e.printStackTrace();
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
				//out.println("Exception is "+e);
			}
		
		}
}else if(mode.equals("insert")){
   
		try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT CHECKLIST_CODE FROM OT_CHECKLIST_HDR";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        		
		while(rs!=null && rs.next())
		{
			checklist_code_from_DB=checklist_code_from_DB.append(",").append(rs.getString(1));
		}

	
	}catch(Exception e)
	{
		e.printStackTrace();
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
				//out.println("Exception is "+e);
			}
		
		}
	}

%>
<form name="checklistsHdr" id="checklistsHdr"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=1 width='80%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class='label'>
		<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="checklist_code" id="checklist_code" value="<%=checklist_code%>" size=4 maxlength=4  <%=checklist_code_disable%> <%=disable_flag%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label >
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="description" id="description" value="<%=description%>"  <%=disable_flag%> size=60 maxlength=60 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label >
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
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='checklist_code1' id='checklist_code1' value="<%=checklist_code%>">
<input type="hidden" name='description1' id='description1' value="<%=description%>">
<input type="hidden" name='checklist_code_from_DB' id='checklist_code_from_DB' value="<%=checklist_code_from_DB%>">
</form>
</body>
</html>


