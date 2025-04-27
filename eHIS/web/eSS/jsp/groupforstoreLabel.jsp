<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="eSS.GroupForStoreBean" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/SsCommon.js"></script>
<script language="JavaScript" src="../js/GroupForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String alphabet		= "";
	String linkStr		= "";
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	/* Initialize Function specific start */

	GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.emptyDupRecords();
%>
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<%
		String splitLinkStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		linkStr="";
		for(int i=0; i<26; i++){
			alphabet = String.valueOf(splitLinkStr.charAt(i)) ;
			linkStr =linkStr+ "<td class='normal' align='center' id='cell"+i+"' width='2%'><a class=\"TABLINK\" href=javascript:callGroupBean('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
		}
		if(!linkStr.equals(""))
		{
			linkStr =linkStr + "<td class='normal' id='celloth'  align='center' width='5%'><a class=\"TABLINK\" href=javascript:callGroupBean('OTH','celloth') ><fmt:message key='Common.others.label' bundle='${common_labels}'/></a></td>";
		}
		out.println(linkStr);
		%>
	</tr>
 </table>
</body>
</html>
<%
	putObjectInBean( bean_id,bean,request);
%>

