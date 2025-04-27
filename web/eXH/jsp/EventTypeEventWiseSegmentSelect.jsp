<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));
 %>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
PreparedStatement pstmt = null;

String messageType = "0"; 
String interfaceYN = "0";
//String defaultval = "";
//String selected = "selected"; 
String qry = "";
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
 
//function onSelectEventType
function onSelectEventType()
{
//	alert("stnd_code : "+document.forms[0].stnd_code.value);
	var stnd_code=document.forms[0].stnd_code.value;
	var event_type=document.forms[0].event_type.value;

/*	if(event_type=='I13' || event_type=='I14' || event_type=='O01' ||  event_type=='O02' ||  event_type=='R01' ||  event_type=='R02' ||  event_type=='R04' ||  event_type=='R05')
{
		var replace=getMessage('XH0080','XH').replace('$',event_type);
		alert(replace);
}*/
	
	
	document.forms[0].action="../../eXH/jsp/EventTypeEventwiseSegmentDisplay.jsp?event_type="+event_type+"&standard_code="+stnd_code;
	document.forms[0].submit();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onSelectEventType();'>
<form name="EventTypeEventwiseSegmentForm" id="EventTypeEventwiseSegmentForm" target='disp_list' method='post'>
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
qry = "SELECT STANDARD_CODE,STANDARD_CODE||' - '||STANDARD_DESC FROM xh_standard";
//String qry = "select standard_code,standard_desc from xh_standard where standard_code='HL7'";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<select class='select' name='stnd_code' id='stnd_code'  onChange='onSelectEventType();' style='width:300'>
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
	System.out.println("(EventTypeEventWiseSegmentSelect.jsp:Exc1) : "+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}

%>
</td>

<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>

<td class='fields'>
<%
try
{
qry = " SELECT EVENT_TYPE,EVENT_TYPE||' - '||EVENT_NAME FROM XH_EVENT_TYPE_LANG_VW WHERE MESSAGE_TYPE=DECODE(?,'0',MESSAGE_TYPE,?) AND INTERFACE_YN=DECODE(?,'0',INTERFACE_YN,?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";

pstmt = con.prepareStatement(qry);
pstmt.setString(1,messageType);
pstmt.setString(2,messageType);
pstmt.setString(3,interfaceYN);
pstmt.setString(4,interfaceYN); 
rs = pstmt.executeQuery();
%>
<select class='select' name='event_type' id='event_type'  onChange='onSelectEventType()' style='width:300'>
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
	System.out.println("(EventTypeEventWiseSegmentSelect.jsp:Exc2) :  "+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
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


