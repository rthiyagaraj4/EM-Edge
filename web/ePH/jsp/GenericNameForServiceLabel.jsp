<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
				  Display the Alpha links includes CSS
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String alphabet		= "";
	String linkStr		= "";
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	/* Initialize Function specific start */

	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);
	bean.emptyDupRecords();
%>
<table border="0" width="100%" cellspacing="0" cellpadding="0" class="TABTABLE">
	<tr>
		<%
		String splitLinkStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		linkStr="";

		
		for(int i=0; i<26; i++){
			alphabet = String.valueOf(splitLinkStr.charAt(i)) ;
			linkStr += "<td class='normal' align='center' id='cell"+i+"' width='2%'><a href=javascript:callGenericBean('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
		}

		if(!linkStr.equals(""))
			linkStr += "<td class='normal' id='celloth'  align='center' width='5%'><a href=javascript:callGenericBean('OTH','celloth') >Others</a></td>";
		out.println(linkStr);
		
		%>
	</tr>
 </table>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

