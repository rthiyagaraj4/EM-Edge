<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--<script language="JavaScript" src="../js/PhMessages.js"></script>-->
<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../ePH/js/TransType.js"></script>
<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="frmTransTypeQueryResult" id="frmTransTypeQueryResult"  >
<%
	String from= request.getParameter("from");
	String to  = request.getParameter("to");

	String bean_id = "TransTypeBean" ;
	String bean_name = "ePH.TransTypeBean";
	String classvalue="";

/* Initialize Function specific start */
	TransTypeBean bean = (TransTypeBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList result=(ArrayList)bean.getAllByGenericName(from,to);
	if (result.size()>1){
%>

	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
	<tr>
	<td class="white">
	<%out.println(result.get(0));%>

	</td>
	</tr>
	</table>
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
		<tr><th ><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.ShortDesc.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="ePH.StockTransactionType.label" bundle="${ph_labels}"/></th></tr>
		<%
		//Retriving the records from result arraylist
		for(int recCount=1; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
	<%
			String columns[]=(String[] )result.get(recCount);

	%>
		<tr>
		<%
			if (columns[0]==null)
				columns[0]="";
		%>
		<td class="<%=classvalue%>" ><%= columns[0]	%></td>
		<%
			if (columns[1]==null)
				columns[1]="";
		%>
		<td class="<%=classvalue%>"  ><%= columns[1] %></td>
		<%
			if (columns[2]==null)
				columns[2]="";
		%>

		<td class="<%=classvalue%>"  ><%= columns[2] %></td>

		<%
			if (columns[3]==null)
				columns[3]="";
		%>
		<td class="<%=classvalue%>"  >&nbsp;<%= columns[3] %></td>
		</tr>
		<%}%>
		</table>
	<%}
	  else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	  }
	%>
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="eff_status" id="eff_status" value="">
	<input type="hidden" name="generic_name" id="generic_name" value="">
	<input type="hidden" name="drug_class" id="drug_class" value="">
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

