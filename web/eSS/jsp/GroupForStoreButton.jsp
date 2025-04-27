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
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../js/SsCommon.js"></script>
<script language="JavaScript" src="../js/GroupForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<jsp:useBean id="bean" scope="page" class="eSS.GroupForStoreBean"/>
<form name="groupforstore_button" id="groupforstore_button">
<%
	
	String from_source	= request.getParameter( "from_source" );
	String store_code	= "";
	String group_code	= "";
	String bean_id					= "groupforstore" ;
	String bean_name				= "eSS.GroupForStoreBean";
	String facility_id	= (String)session.getValue( "facility_id" );
	/* Initialize Function specific start */
	//GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id,bean_name, request   ) ;

	
	//for loading the data into DB arraylist passing the service code to bean
	
	if(from_source.equals( "bystore" )){
		store_code	= request.getParameter( "store_code" ) ;
		bean.loadData(store_code,from_source,facility_id);
	}
	else{
		group_code		= request.getParameter( "group_code" ) ;
		
		bean.loadData(group_code,from_source,facility_id);
	}
	
	 

%>
<table border="1" width="32%" cellspacing="0" cellpadding="0">
	<tr>
		<td class="clicked" id="select_col" align="center" width="30%" height="20">
		<a class="TABLINK" href="javascript:Display('1','<%=from_source%>')" id="select" ><b> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b> </a>
		</td>
		<td class="normal" id="association_col" align="center" width="30%" height="20">
		<a class="TABLINK" href="javascript:Display('2','<%=from_source%>')" id="association"><b><fmt:message key="eSS.Association.label" bundle="${ss_labels}"/></b></a>
		</td>
	</tr>
</table>
<%
if(from_source.equals( "bystore" )){
%>
	<script>
		callLabelPage("<%=store_code%>");
	</script>
<%
	}else{
%>
	<script>
		callDetailsPage();
	</script>
<%
	}
%>
<input type="hidden" value="N" name="data_change_yn" id="data_change_yn">
</form>
</body>
</html>

<%
	putObjectInBean( bean_id,bean,request);
%>

