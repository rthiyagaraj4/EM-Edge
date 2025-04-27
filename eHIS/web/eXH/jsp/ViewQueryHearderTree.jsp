<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.XHReturnArray,java.util.*,java.sql.*,webbeans.eCommon.*"%>
<head>
 <%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="StyleSheet" href="../../eXH/html/dtree.css" type="text/css" />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="StyleSheet" href="../../eXH/html/lris_style.css" type="text/css" />
	<script type="text/javascript" src="../../eXH/js/dtree4.js"></script>							  
	<script language="javascript" src="../../eXH/js/Viewtreeimage.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head> 
<script>
async function funAction()
{  
var dialogHeight = "250";
	var dialogWidth  = "250";
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no;" ;



var url = "../../eXH/jsp/ViewSegmentsTreeMain.jsp?"+
				"applicationID="+document.forms[0].applicationId.value+
				"&facilityID="+document.forms[0].facilityId.value+ 
				"&msgID="+document.forms[0].msgId.value+
				"&facilityName="+document.forms[0].facilityName.value+
				"&applicationName="+document.forms[0].applicationName.value+ 
				"&protocolMode="+document.forms[0].protocolMode.value+
				"&sub_module="+document.forms[0].sub_module.value+
				"&srlNo="+document.forms[0].srlNo.value+
				"&protocol_link_id="+document.forms[0].protocol_link_id.value+
				"&purge_status="+document.forms[0].purge_status.value+'&even_type='+document.forms[0].even_type.value+'&posi='+document.forms[0].position.value+"&rule=R&rule2=H&img=N";  
				var arguments  =new Array();
   await window.showModalDialog(url,arguments,features); 

}
</script>
<BODY>
<form name="view_segment_form" id="view_segment_form">  
<table cellspacing=0 cellpadding=3 border=0 width='100%'  >  
<tr>

<%
String applicationID=XHDBAdapter.checkNull(request.getParameter("applicationID"));
String facilityID=XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID=XHDBAdapter.checkNull(request.getParameter("msgID"));
String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
String protocolMode=XHDBAdapter.checkNull(request.getParameter("protocolMode"));
String sub_module=XHDBAdapter.checkNull(request.getParameter("sub_module"));
String srlNo=XHDBAdapter.checkNull(request.getParameter("srlNo"));
String protocol_link_id=XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status=XHDBAdapter.checkNull(request.getParameter("purge_status"));
String even_type=XHDBAdapter.checkNull(request.getParameter("even_type"));
String position=XHDBAdapter.checkNull(request.getParameter("position"));
String img=XHDBAdapter.checkNull(request.getParameter("img"));
%>
	<input type='hidden' name='applicationId' id='applicationId' value='<%= applicationID %>' >
	<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityID%>'>
	<input type='hidden' name='msgId' id='msgId' value='<%=msgID%>'>
	<input type='hidden' name='facilityName' id='facilityName' value=<%=java.net.URLEncoder.encode(facilityName) %>>
	<input type='hidden' name='applicationName' id='applicationName' value=<%=java.net.URLEncoder.encode(applicationName) %>>
	<input type='hidden' name='protocolMode' id='protocolMode' value='<%=protocolMode %>'>
	<input type='hidden' name='sub_module' id='sub_module' value='<%=sub_module %>'>
	<input type='hidden' name='srlNo' id='srlNo' value='<%=srlNo %>'>
	<input type='hidden' name='protocol_link_id' id='protocol_link_id' value='<%=protocol_link_id %>'>
	<input type='hidden' name='purge_status' id='purge_status' value='<%=purge_status %>'>
	<input type='hidden' name='even_type' id='even_type' value='<%=even_type %>'>
	<input type='hidden' name='position' id='position' value='<%=position %>'>

<td colspan="3" class="COLUMNHEADER" align=center> <fmt:message key="Common.Message.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if(img.equals("Y")){%> 
<a style='cursor:pointer' onClick="funAction()"><img src='../../eXH/images/expandpic.gif' height=15 title='Full Screen Message Viewer' ></a>
<%}else{ }%>
</td> 

</tr> 
</table>
</form> 
</BODY>
</html>

