<!DOCTYPE html>
<%@ page import ="javax.servlet.http.HttpServletRequest " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>

<html>
<head>
	<title><fmt:message key="ePO.orderStatus.label" bundle="${po_labels}"/></title>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String documentNo = "";
	documentNo = request.getParameter("documentNo");
	try
	{	
	
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
		
		displayFields.add("ADDED_BY_ID");
		displayFields.add("ADDED_DATE");
		displayFields.add("MODIFIED_BY_ID");
		displayFields.add("MODIFIED_DATE");
		
		chkFields.add(documentNo);
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_STATUS_AUDIT_QUERY"));
			
		System.out.println("PurchaseOrderStatusAuditInfo.jsp,  documentNo : "+documentNo);
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);			

		System.out.println("funcMap (Audit) result= "+result);
		
		
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){	
			ArrayList records=new ArrayList();
			records=(ArrayList) result.get(2);
		
%>

	<table border=1 cellspacing=0 cellpadding='3' width='100%' align=center>
		<tr>
			<td class='label'><fmt:message key="ePO.enteredBy.label" bundle="${st_labels}"/></td>	
			<td class='label'><%=CommonBean.checkForNull((String)records.get(0))%></td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="ePO.enteredOn.label" bundle="${st_labels}"/></td>
			<td class='label'><%=CommonBean.checkForNull((String)records.get(1))%></td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="ePO.lastAccssBy.label" bundle="${st_labels}"/></td>
			<td class='label'><%=CommonBean.checkForNull((String)records.get(2))%></td>	
		</tr>
		<tr>
			<td class='label'><fmt:message key="ePO.lastAccssOn.label" bundle="${st_labels}"/></td>
			<td class='label'><%=CommonBean.checkForNull((String)records.get(3))%></td>
		</tr>
	</table>

<%

	}
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

	<span style="float:right">
		<input type="button" class = 'BUTTON'  value ='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick ="window.close();">
	</span>

</body>
</html>

