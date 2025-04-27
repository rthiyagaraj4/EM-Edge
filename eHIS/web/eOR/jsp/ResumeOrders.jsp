<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
---------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------
09/02/2017	IN063457		Karthi L										Order disappears when user Resumes the Partially Resulted Order.
---------------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>

<%
	/* Mandatory checks start */
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CancelOrder" ;
	String bean_name = "eOR.CancelOrder";

	//String ord_cat = request.getParameter("ord_cat");
	String colval=	request.getParameter("colval");
	String orderId = request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String catalog_code = request.getParameter("catalog_code");
	if(catalog_code == null) catalog_code = "";
	String ord_typ_code = request.getParameter("ord_typ_code");
	if(ord_typ_code == null) ord_typ_code = "";
	

	//out.println(">>>>>>>>>>>"+orderId+"<BR>");
	//out.println(">>>>>>>>>>>"+order_line_num+"<BR>");
	
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//CancelOrder bean = (CancelOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	ArrayList allValues = new ArrayList();

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	allValues		= bean.getResumeDtl(orderId);

	
%>

<html>
<head>
	<title><fmt:message key="eOR.ResumeOrder.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<!-- <script language="JavaScript" src="../js/OrMessages.js"></script> -->
 	<script language="JavaScript" src="../js/CancelOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST name="resume_order" id="resume_order">

<table cellpadding=3 ALIGN=CENTER  cellspacing=0 border=0 width='100%'>
	<tr>
		<td class=label width='50%'><B><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></B></td>
		<td class=label width='50%'><%=colval%></td>
	</tr>
	<tr>
		<td class=label width='50%'><B><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></B></td>
		<td class=label width='50%' ><%=orderId%></td>
	</tr>
	<%
	String pract_dtl[] = (String[])allValues.get(0);
	if(pract_dtl[0] == null) pract_dtl[0] = ""; // IN063457
	%>
	<tr>
		<td class=label width='50%'><B><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></B></td>
		<td class=label width='50%'><%=pract_dtl[0]%></td>
	</tr>
	<tr>
		<td class=label width='50%'><B><fmt:message key="eOR.HoldDateTime.label" bundle="${or_labels}"/></B></td>
		<td class=label width='50%' ><%=com.ehis.util.DateUtils.convertDate(pract_dtl[1],"DMYHM","en",localeName)%></td>
	</tr>
	<tr>
		<td colspan=2 class=button><input type=button name='resume' id='resume' value='<fmt:message key="eOR.Resume.label" bundle="${or_labels}"/>' class='Button' onClick='resumeOrder()'><input type=button name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='Button' onClick='window.close()'></td>
		
	</tr>
</table>
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="which_place" id="which_place" value="resume_order">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
	<input type="hidden" name="ord_typ_code" id="ord_typ_code" value="<%=ord_typ_code%>">
	<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
	<input type="hidden" name="language" id="language" value="<%=localeName%>">

</FORM>
<%
 	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

