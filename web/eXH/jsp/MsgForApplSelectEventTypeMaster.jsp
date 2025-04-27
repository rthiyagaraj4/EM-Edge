<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));
		locale = "en"; %>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String selected = "selected";
String defaultval = "";
%>  
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
function funSelEventType() 
{
	parent.parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	var appl_id       = parent.parent.frames[0].document.forms[0].appli.value;
	var index		    = parent.parent.frames[0].document.forms[0].appln_name.options.selectedIndex;
	var appl_name	= parent.parent.frames[0].document.forms[0].appln_name.options[index].text;

	if(appl_id=='')
		{
		alert(getMessage( 'XH1003','XH'));
		parent.parent.frames[0].document.forms[0].appli.focus();
		return;
		}

	var stnd_code=document.forms[0].stnd_code.value;
//		alert("stnd_code : "+stnd_code);
	var event_type=document.forms[0].event_type.value;
	document.forms[0].action="../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?event_type="+event_type+"&standard_code="+stnd_code+"&appl_id="+appl_id+"&appl_name="+appl_name;
	document.forms[0].submit();

} 

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='funSelEventType();'>
<%
String appl_id=request.getParameter("appl_id");
%>

<form name="SegmentTypesForEventForm" id="SegmentTypesForEventForm" target='list_frame' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='25%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='25%'></td>
</tr>
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
<select class='select' name='stnd_code' id='stnd_code'  "+disabled+"  onChange='funSelEventType();' style="width:300">
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
	System.out.println("MsgForApplSelectEventTypeMaster.jsp Exc : "+e1.toString());
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

String qry="SELECT A.EVENT_TYPE,A.EVENT_TYPE||' - '||B.EVENT_NAME FROM XH_APPLICATION_EVENT_TYPE A, XH_EVENT_TYPE_LANG_VW B WHERE A.IN_USE_YN='Y' AND A.EVENT_TYPE=B.EVENT_TYPE AND A.APPLICATION_ID='"+appl_id+"' AND B.LANGUAGE_ID='"+locale+"' ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<select class='select_event' name='event_type' id='event_type'   onChange='funSelEventType()' style="width:300">
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
	System.out.println("MsgForApplSelectEventTypeMaster.jsp Exc : "+e1.toString());
	e1.printStackTrace(System.err);
}
finally
{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	ConnectionManager.returnConnection(con);
}

%>
</td>
</tr>
<tr>
	<td width='25%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='25%'></td>
</tr>

</table>
<input type=hidden name=appl_id id=appl_id value='<%=appl_id%>'>
</form>	
</body>
</html>


