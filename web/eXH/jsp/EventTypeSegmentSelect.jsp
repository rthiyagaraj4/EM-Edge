<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import  ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>


<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null; 
String selected = "selected"; 
String defaultval = ""; 
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
//function onSelectStandard
function onSelectStandard()
{
//	alert("stnd_code : "+document.forms[0].stnd_code.value);
	var standard_code=document.forms[0].stnd_code.value;
	document.forms[0].action="../../eXH/jsp/EventTypeSegmentUsage.jsp?standard_code="+standard_code;
	document.forms[0].submit();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onSelectStandard();' >
<form name="EventTypesForSegmentForm" id="EventTypesForSegmentForm" target='disp_list' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>
<tr>
	<td width='30%'></td>
	<td class=label  align=center ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/> </td>
	<td class='fields' colspan=2> 

	<%
	try
	{
	con=ConnectionManager.getConnection();
	String qry = "SELECT STANDARD_CODE,STANDARD_CODE||' - '||STANDARD_DESC FROM xh_standard";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
	%>
	<select class='select' name='stnd_code' id='stnd_code'  "+disabled+"  onChange='onSelectStandard()' style='width:300'>
				<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<%
		while(rs.next())
				{ 
             
			  if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
	%>
			<option value='<%=rs.getString(1)%>'  "+selected+" ><%=rs.getString(2)%></option>
            
		<% 	}%>

            </select>
<%

}catch(Exception e1)
{
	System.out.println("(EventTypeSegmentSelect.jsp:Exc) : "+e1.toString());
	e1.printStackTrace(System.err);
}

%> 
</td>
</tr>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>

</table>
</form>	
 <%
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
</body>
</html>


