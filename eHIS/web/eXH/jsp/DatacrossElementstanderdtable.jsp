<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
 
<HEAD>
</HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
//function funSelEventType
function funSelEventType(obj)
{
	parent.list_frame.location.href="../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?event_type="+obj.value+"&appl_id="+document.forms[0].appl_id.value;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
String appl_id=request.getParameter("appl_id");
Connection con=null;
try
{
con=ConnectionManager.getConnection();
}catch(Exception e1)
{
	System.out.println("(DatacrossElementstanderdtable.jsp:ConnectionException) "+e1.toString());
}
%>
<form name="SegmentTypesForEventForm" id="SegmentTypesForEventForm" target='list_frame' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.ProtocolLinkId.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="eXH.ProtocolLinkName.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.Protocol.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.DataGroup.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>

<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<%
String strTDClass = "";
Statement stmt=null;
ResultSet rs=null;


String Standard_code=request.getParameter("standardcode");
String Application_id=request.getParameter("Application_id");

String sql="SELECT PROTOCOL_LINK_ID,PROTOCOL_LINK_NAME,PROTOCOL_ID,DATA_GROUP_ID,STANDARD_CODE,APPLICATION_ID,PROFILE_ID FROM XH_PROTOCOL_LINK WHERE APPLICATION_ID=NVL('"+Application_id+"',APPLICATION_ID) and STANDARD_CODE=NVL('"+Standard_code+"',STANDARD_CODE)";
//System.out.println(" (DatacrossElementstanderdtable.jsp:sqlProtocolLinkQuery) :"+sql);  

%>
<%
try
{

int i=0;
	
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);	
	while(rs.next())
	{
if (i%2 == 0)
		{
			strTDClass = "class='QRYEVEN'";
			
		}
		else
		{
			strTDClass = "class='QRYODD'";
			
		}


	%>
	<tr>
	<td <%=strTDClass%> align="left" nowrap><%=rs.getString(1)%></td>
<td <%=strTDClass%> align="left" nowrap><%=rs.getString(2)%></td>

<td <%=strTDClass%> align="left" nowrap><%=rs.getString(3)%></td>

<td <%=strTDClass%> align="left" nowrap><%=rs.getString(4)%></td>

<td <%=strTDClass%> align="left" nowrap><%=rs.getString(5)%></td>
<td <%=strTDClass%> align="left" nowrap><%=rs.getString(6)%></td>
<td <%=strTDClass%> align="left" nowrap><%=rs.getString(7)%></td>
</tr>
	<%
	i++;
	}		


}catch(Exception e1)
{
	out.println(e1.toString());
}
finally{
			try{
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(DatacrossElementstanderdtable.jsp:Exception) "+e.toString());		 
				}
		
			} 
%>
 </td></tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>
<input type=hidden name=appl_id id=appl_id value='<%=appl_id%>'>
</form>	
</body>
</html>


