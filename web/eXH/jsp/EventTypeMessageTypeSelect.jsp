<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));	
	 %>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null; 
%> 
<HEAD>
</HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

//function onSelectMessageType
function onSelectMessageType()
{
//	alert("stnd_code : "+document.forms[0].stnd_code.value);
	var stnd_code=document.forms[0].stnd_code.value;
	var msg_type=document.forms[0].msg_type.value;
	document.forms[0].action="../../eXH/jsp/EventTypeMessageTypeDisplay.jsp?message_type="+msg_type+"&standard_code="+stnd_code;
	document.forms[0].submit();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onSelectMessageType()'>
<form name="EventTypesForMessageForm" id="EventTypesForMessageForm" target='disp_list' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='25%'></td>
	<td width='40%'></td>
	<td width='30%'></td>   
	<td width='50%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>

<td class='fields'>
<%
try
{
con=ConnectionManager.getConnection();
String qry = "SELECT STANDARD_CODE,STANDARD_CODE||' - '||STANDARD_DESC FROM xh_standard";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<select class='select' name='stnd_code' id='stnd_code'  onChange='onSelectMessageType();' style='width:300'>
            <option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
	while(rs.next())
            {
%>
	<option value='<%=rs.getString(1)%>'  ><%=rs.getString(2)%></option>
            
<% 	}%>

 </select>
<%

}catch(Exception e1)
{
	System.out.println("(EventTypeMessageTypeSelect.jsp:Exc1) : "+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}

%>
</td>

<td class=label ><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/>
<fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 

<td class='fields'>
<%
try
{
String qry = "SELECT MESSAGE_TYPE,MESSAGE_TYPE||' - '||DESCRIPTION FROM XH_MESSAGE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<select class='select' name='msg_type' id='msg_type'  onChange='onSelectMessageType()' style='width:300'>
<!--            <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option> -->
            <option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>

<%
	while(rs.next())
            {
%>
	<option value='<%=rs.getString(1)%>'  ><%=rs.getString(2)%></option>
            
<% 	}%>

 </select>
<% 

}catch(Exception e1)
{
	System.out.println("(EventTypeMessageTypeSelect.jsp:Exc2) : "+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	ConnectionManager.returnConnection(con);
}

%>
</td></tr>
<tr>
	<td width='25%'></td>
	<td width='40%'></td>
	<td width='30%'></td>
	<td width='50%'></td>
</tr>

</table>
</form>	
 <%
		
%>
</body>
</html>


