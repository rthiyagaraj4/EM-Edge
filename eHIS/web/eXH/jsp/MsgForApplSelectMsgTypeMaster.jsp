<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import  ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));
		 %>
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
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

//function onSelectMessageType 
function onSelectMessageType()
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
	var msg_type=document.forms[0].msg_type.value;
	document.forms[0].action="../../eXH/jsp/MsgForApplDisplayMsgTypeMaster.jsp?message_type="+msg_type+"&standard_code="+stnd_code+"&appl_id="+appl_id+"&appl_name="+appl_name;
document.forms[0].submit();
 
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onSelectMessageType();'>

<form name="EventTypesForMessageForm" id="EventTypesForMessageForm" target='list_frame' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='25%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='25%'></td>
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
<select class='select' name='stnd_code' id='stnd_code'  "+disabled+"  onChange='onSelectMessageType();' style="width:300">
            <option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
	while(rs.next())
            {
             
	/*		  if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }  "+selected+" 
			  */
%>
	<option value='<%=rs.getString(1)%>' ><%=rs.getString(2)%></option>
            
		<% 	}%>

            </select>
<%

}catch(Exception e1)
{
	System.out.println("MsgForApplSelectMsgTypeMaster.jsp Exc1 : "+e1.toString());
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
//String qry = "SELECT MESSAGE_TYPE,DESCRIPTION FROM XH_MESSAGE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

String qry = "SELECT a.MESSAGE_TYPE,a.MESSAGE_TYPE||' - '||a.DESCRIPTION FROM XH_MESSAGE_TYPE_LANG_VW a,(SELECT DISTINCT MESSAGE_TYPE FROM XH_EVENT_TYPE) b WHERE a.MESSAGE_TYPE=b.MESSAGE_TYPE AND a.LANGUAGE_ID='"+locale+"' ORDER BY 2 ";

stmt = con.createStatement();
rs = stmt.executeQuery(qry); 
%>
<select class='select' name='msg_type' id='msg_type'  "+disabled+"  onChange='onSelectMessageType()' style="width:300">

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
	System.out.println("MsgForApplSelectMsgTypeMaster.jsp Exc2 : "+e1.toString());
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
</form>	
</body>
</html>


