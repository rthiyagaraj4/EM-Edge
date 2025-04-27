<!DOCTYPE html>
<HTML>   
<%@ page import = "java.util.*" %> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<%  
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String IndelStyle = "";
String ExdelStyle = "";
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
<script language="javascript" src="../../eXH/js/CommProtocolIdFileCtrlStr.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String segment_type_id="";
String segment_type="";
String file_ctrl_type=""; 
String srlno="";

String mode			=	request.getParameter("mode");
if(mode.equals("U"))
{
	IndelStyle	 = "display:block";
	ExdelStyle = "display:none";
	srlno=request.getParameter("srlno");
	segment_type=request.getParameter("segment_type");
	segment_type_id		=	request.getParameter("segment_type_id");
	file_ctrl_type=request.getParameter("file_ctrl_type");
}
else{
	IndelStyle	 = "display:none";
	ExdelStyle = "display:block";
}

//segment_type_id		=	request.getParameter("segment_type_id");

%>

<form name="InterfaceStandard_CtrlStr" id="InterfaceStandard_CtrlStr" target='messageFrame' method='post' action=''>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label >File Control Type</td>
<td align=left>
<select name ='file_ctrl_type' >
	<option value=''>----------Select--------</option>
	<option value='H' <%=file_ctrl_type.equals("H")?"selected":""%>>File Header</option>
	<option value='F' <%=file_ctrl_type.equals("F")?"selected":""%>>File Footer</option>
</select>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>


<tr>
<td class=label >Segment Name</td>
<td align=left>
	<input type="hidden" name="segment_type_id" id="segment_type_id" value="<%=segment_type_id%>">
	<input type=text id="segment_type"  name=segment_type size=35 value='<%=segment_type%>'  > <input class="button" type="button"  name=SegmentTypeSearch value='?'    onClick="searchSegmentType()">
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>

<tr id='IncDel' style='<%=IndelStyle%>' >
<td> </td><td> </td>
<td colspan=2 class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='Record' onClick="record('I')">
<input class='button' type='button'  name='delete' id='delete' value='Delete' onClick="deleteRecord()">
<input class='button' type='button'  name='Cancel' id='Cancel' value='Cancel' onClick="cancel()"></td>
</tr>

<tr id='ExcDel' style='<%=ExdelStyle%>' >
<td> </td><td> </td>
<td colspan=2 class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='Record' onClick="record('I')">
<!--<input class='button' type='button'  name='delete' id='delete' value='Delete' onClick="deleteRecord()"> -->
<input class='button' type='button'  name='Cancel' id='Cancel' value='Cancel' onClick="cancel()"></td>
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
<input type="hidden" name="srlno" id="srlno" value='<%=srlno%>'>

</form>
</BODY>
</HTML> 

