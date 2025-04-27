<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/InterfaceStandards.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String segment_type_id="";
String segment_type="";
String element_id=""; 
String element_name=""; 
String element_seq="";
String def_val_id=""; 
String default_val=""; 
  

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	segment_type=request.getParameter("segment_type");
	element_name=request.getParameter("element_name");
	element_seq=request.getParameter("element_seq");
	default_val=request.getParameter("default_val");
}

segment_type_id		=	request.getParameter("segment_type_id");
element_id		=	request.getParameter("element_id");
def_val_id			=	request.getParameter("def_val_id");


%>

<form name="InterfaceStandard_CtrlStr" id="InterfaceStandard_CtrlStr" target='messageFrame' method='post' action='../../servlet/eXH.'>
<table cellspacing=0 cellpadding=3 width='101%' align=center>
<tr>
<!--
	<td width='40%'></td>
	<td width='60%'></td> 
	-->
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.SegmentName.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="segment_type"  name =segment_type size=25 value='<%=segment_type%>'  > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()">
<input type="hidden" name="segment_type_id" id="segment_type_id" value="<%=segment_type_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="element_name"  name =element_name value='<%=element_name%>' size=25> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=InboundAPISearch value='?'    onClick="">
<input type="hidden" name="element_id" id="element_id" value="<%=element_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.ElementSEQ.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=element_seq size=25 value='<%=element_seq%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.DefaultVal.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="default_val"  name =default_val size=25 value='<%=default_val%>' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=DefaultValSearch value='?'    onClick="searchDefaultVal()">
<input type="hidden" name="def_val_id" id="def_val_id" value="<%=def_val_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>
</table>
	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 

