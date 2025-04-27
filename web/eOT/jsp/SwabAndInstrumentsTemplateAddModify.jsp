<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	<script language='javascript' src='../../eOT/js/SwabAndInstrumentsTemplate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disable=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'--> 
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("update_mode_yn");
String chk_checked="checked";
String chk_value="E";
String template_id = request.getParameter("template_id")==null?"":request.getParameter( "template_id" );
if(template_id.equals("null") || template_id=="null")
{
	template_id="";
}
String disable_flag="",template_id_disable="",description="",sql="",status="";
StringBuffer template_id_from_DB=new StringBuffer();
	try{
		con=ConnectionManager.getConnection(request);
		if(mode.equals("modify"))
		{
		sql="SELECT TEMPLATE_ID, DESCRIPTION,NVL(STATUS,'E') STATUS FROM OT_SWAB_INSTR_TMPL_HDR WHERE TEMPLATE_ID=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,template_id);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			template_id=rs.getString(1);
			description=rs.getString(2);
			status=rs.getString(3);
			
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
		template_id_disable="disabled";	
		template_id_disable="disabled";	
	}else if(mode.equals("insert")){
		if(stmt!=null) stmt.close();
		if(rs!=null)rs.close();
		sql="SELECT TEMPLATE_ID FROM OT_SWAB_INSTR_TMPL_HDR";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
		template_id_from_DB=template_id_from_DB.append(",").append(rs.getString(1));
		}
}
}catch(Exception e){
	e.printStackTrace();
}
finally{
		if(stmt!=null) stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
	  }
%>
<form name="SwabAndInstrumentsTemplateHdr" id="SwabAndInstrumentsTemplateHdr"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'></td>
</tr>

<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="text" name="template" id="template" value="<%=template_id%>" size=6  maxlength=6  <%=template_id_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
		<td width='25%'></td>
	<td width='25%'></td>

</tr>

<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="text" name="description" id="description" value="<%=description%>" <%=disable_flag%> size=25 maxlength=30 ><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td width='25%'></td>
	<td width='25%'></td>
</tr>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="checkbox" name="status" id="status" onClick='setStatusValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
	<td width='25%'></td>
	<td width='25%'></td>
</tr>
<tr>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='template_id' id='template_id' value="<%=template_id%>">
<input type="hidden" name='description1' id='description1' value="<%=description%>">
<input type="hidden" name='template_id_from_DB' id='template_id_from_DB' value="<%=template_id_from_DB%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


