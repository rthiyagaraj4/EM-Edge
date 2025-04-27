<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,ePH.DispMedicationBean" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML> 
<HEAD> 
  	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		

</HEAD>

<%
	try{

	
	String bean_id			= "DispMedicationBean" ;
	String bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	String token_series =request.getParameter("token_series")==null?"":request.getParameter("token_series");
	String token_no =request.getParameter("token_no")==null?"":request.getParameter("token_no");
             
	ArrayList tokendetails	= bean.getPendingTokenDetails( token_series,token_no);

		
	
	String Qryclass="";

 %>

<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
	<FORM name="formTokenDetails" id="formTokenDetails">
		<table border="1" width="100%" cellspacing="0" cellpadding="0">
		<TR>
			<td class="COLUMNHEADER" align="center" width="15%" class = "LABEL"><B> <fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></B></td>
			<td class="COLUMNHEADER" align="center" width="15%" class = "LABEL"><B> <fmt:message key="eOR.OrderLineNo.label" bundle="${or_labels}"/></B></td>
			<td class="COLUMNHEADER" align="center" width="40%" class = "LABEL"><B> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/></B></td>
			<td class="COLUMNHEADER" align="center" width="32%" class = "LABEL"><B> <fmt:message key="Common.status.label" bundle="${common_labels}"/></B></td> 
		</TR>
<%

	for (int i=0; i<tokendetails.size(); i++) 
		{ 
		HashMap toke_detail = (HashMap)tokendetails.get(i);
		if(i%2==0)
		 {
			Qryclass="QRYEVENSMALL";
		 }else{
			Qryclass="QRYODDSMALL";
			 }

%>
	<TR >
		
				<TD   ALIGN="LEFT" class="<%=Qryclass%>"  WIDTH="15%">
					<%= (String)toke_detail.get("ORDER_ID") %> </TD>							
				<TD  align='right'  class="<%=Qryclass%>" WIDTH="15%">
					<%= (String)toke_detail.get("ORDER_LINE_NUM") %> </TD>
				<TD   ALIGN="left" class="<%=Qryclass%>"  WIDTH="40%">
					<%= (String)toke_detail.get("DRUG_DESC") %> </TD>
				<TD   ALIGN="LEFT" class="<%=Qryclass%>"  WIDTH="32%">
					<%= (String)toke_detail.get("ORDER_LINE_STATUS") %></TD>							
	</TR>
		
	

  <% 
		}
  %>
  </TABLE>
 	<%
		
		putObjectInBean(bean_id,bean,request);
		}catch(Exception e){
	  e.printStackTrace(); }
	  
	%>
</FORM>
</BODY>
</HTML>

