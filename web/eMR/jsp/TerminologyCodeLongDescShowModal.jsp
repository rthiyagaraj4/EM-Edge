<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	20 Jan 2005
--%>

<%@ page contentType="text/html;charset=UTF-8" import = "java.net.*,java.sql.*, java.text.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<TITLE><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;

String terminology_set	= request.getParameter("terminology_set");
String termcode			= request.getParameter("termcode");
//String long_desc = request.getParameter("long_desc");
String long_desc = "";
//out.println(" ld : "+long_desc);
//String long_desc = java.net.URLDecoder.decode(request.getParameter("long_desc"));
String readOnly = checkForNull(request.getParameter("read_only"));
String mode = checkForNull(request.getParameter("mode"));



try
{
	if(mode.equals("Modify")){
		String sql = " select LONG_DESC from mr_term_code  where term_code = ? and term_set_id = ?";
		con = ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(sql);
		stmt.setString(1,termcode);
		stmt.setString(2,terminology_set);
		rs = stmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				long_desc = rs.getString("LONG_DESC");
			}
		}
	}

%>
<script>

function windcls()
{   
	var obj = document.termcode_long_desc.long_desc;
	checkForMax(obj,400);
	window.returnValue = obj.value;
	window.close();
}


function checkForMax(obj,ldmaxSize)
{
	var longdesctext=obj.value;
	if(longdesctext.length >= ldmaxSize){
		var error=getMessage('REMARKS_NOT_EXCEED_200_CH','SM');
		error=error.replace('Remarks',getLabel("Common.longdescription.label","Common"));
		error=error.replace('200',ldmaxSize);
		alert(error);
		var revertField = obj.value.slice(0,ldmaxSize);
   		obj.value = revertField;
		obj.focus();
	}
} 

 function notallowenter(event)
{
	if(window.event.keyCode==13)
	{
		return false;
	}
	return document.termcode_long_desc.long_desc.value.length<400;
} 

</script>
</head>
<body onKeyDown='lockKey()'>
<form name='termcode_long_desc' id='termcode_long_desc' target='messageFrame'>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
	<TR>
		<TD class='label'>&nbsp;</TD>
		<TD class='label'>&nbsp;</TD>
		<TD>

		<TEXTAREA NAME="long_desc" <%=readOnly%> onkeypress='return notallowenter(event);' 
				onkeydown="checkForMax(this,400);" onblur="makeValidString(this);" ROWS="5" COLS="40"><%=long_desc%></TEXTAREA>  
		</TD>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD class='label'>&nbsp;</TD>
		<TD  colspan='2' class='button'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onclick='windcls();'></TD>
		<TD class='label'>&nbsp;</TD>
	</TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
</TABLE>

</form>
</body>
</html>
<%
if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
}
catch(Exception ex){
		ex.printStackTrace();
}finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

