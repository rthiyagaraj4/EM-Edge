<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="eCommon.XSSRequestWrapper" %>
<html>
<head>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../js/ATCClassification.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String level_num	=	request.getParameter("level_num");
	if(level_num==null || level_num.equals("") )
		level_num = "";
	String level_value	=	"";
%>

<!-- <body topmargin="0"> -->
<body topmargin="0" onMouseDown="" onKeyDown="lockKey()">
<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
<%	if(level_num!=""){	

	      if(level_num.equals("1"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PharmacologicalClassification.label","ph_labels");
		  if(level_num.equals("2"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GroupClassification[LevelI].label","ph_labels");
		  if(level_num.equals("3"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SubGroupClassification[LevelII].label","ph_labels");
		  if(level_num.equals("4"))	  level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ViewHierarchy.label","ph_labels");
	%>
<tr >
	<th align="left" width="65%">&nbsp;<%=level_value%></th>
	<th width="1%" style="background-color:white">&nbsp;</th>
</tr>
<% }%>
</table>
</body>
</html>

