<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.XHReturnArray,java.util.*,java.sql.*"%>
<head>
<style type = 'text/css'>
TD.COLUMNHEADER {
   BACKGROUND-COLOR: #404040;
   COLOR: white ;  
   FONT-SIZE: 8pt;   
   font-weight: bolder;
   PADDING-LEFT:7px;
   PADDING-RIGHT:7px
}
  </STYLE>
  <link rel="StyleSheet" href="../../eXH/html/IeStyle.css" type="text/css" />
		<link rel="StyleSheet" href="../../eXH/html/dtree.css" type="text/css" />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="StyleSheet" href="../../eXH/html/lris_style.css" type="text/css" />
	<script type="text/javascript" src="../../eXH/js/dtree4.js"></script>
	<script language="javascript" src="../../eXH/js/Viewtreeimage.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY>
<form name="view_segment_form" id="view_segment_form">
<table cellspacing=0 cellpadding=3 border=1 width='100%'  >
<tr>
<td width='5%'></td>
<td width='15%'></td>
</tr>
<tr> 
<td colspan="3" class="COLUMNHEADER" align=center><fmt:message key="Common.query.label" bundle="${common_labels}"/></td>
<td colspan="3" class="COLUMNHEADER" align=center><fmt:message key="Common.Response.label" bundle="${common_labels}"/></td>
</tr>
</table>
</form>
</BODY>
</html>

