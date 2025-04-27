<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
22/07/2018		IN068445		Kamalakannan	22/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryBean"/><!-IN068445-->
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
	<title><fmt:message key="eOR.Catalog.label" bundle="${or_labels}"/> <fmt:message key="eOR.comments.label" bundle="${or_labels}"/> -- <%=request.getParameter("catalog_desc")==null?"":request.getParameter("catalog_desc")%></title>
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<form name="placeOrderForm" id="placeOrderForm">
<%		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//IN068445 start
		String catalogCode = request.getParameter("catalogCode")==null?"":request.getParameter("catalogCode");
		eOR.OrderEntryBean queryBean = (eOR.OrderEntryBean)getObjectFromBean(request.getParameter("beanId"),"OrderEntryBean",session);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) queryBean.getOrderEntryRecordBean();
		ArrayList arrSeqNo = new ArrayList();
		arrSeqNo = (ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalogCode, catalogCode);
		//IN068445 stop
%>
<div class="outer-container" style='width:790px;height:435px'>
    <div class="top-section" style='width:795px;height:435px;overflow:auto'>
		<table cellpadding='3' cellspacing='0' border='0' align='center' width="100%">			
			<tr>
			  <td>
				<%=arrSeqNo.get(0)%> <!--IN068445-->   
			  </td>
			</tr>
		</table>
    </div>
 </div>
<table  cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
	<tr><td class='button' colspan='2' align='right'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td></tr>
</table>
</body>
</html>

