<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- JSP Page specific attributes end --%>
<jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/> <!--just to use the checkForNull functions -->
<%-- Mandatory declarations start --%>
 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//	String bean_id 				= request.getParameter("bean_id");
//	String bean_name 			= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 		 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//	OrderEntryBean  bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
//	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
//	String key					= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
//   	HashMap previousValues		= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
   	/*	---------Till Here------------- */
	bean.setLanguageId(localeName);
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	OrderEntryBean or_bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		or_bean.setLanguageId(localeName);
	String order_category		= bean.checkForNull(request.getParameter("order_category"),""); 
   	//String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
//   	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
   	String order_format_mandatory= bean.checkForNull(request.getParameter("order_format_mandatory"),"0");
   	String order_format			= bean.checkForNull(request.getParameter("order_format"),"0");
   	String query_string			= bean.checkForNull(request.getQueryString(),"");
	String amend_start_disabled	= "";

	if((or_bean.getAmendOrder().equalsIgnoreCase("existing_order"))&&(order_category.equalsIgnoreCase("RD")))
	{
		amend_start_disabled	= "DISABLED";
	}
	else
	{
		amend_start_disabled	= "";
	}
		
 %>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="Javascript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<STYLE TYPE="text/css"> <!-- Violated, To make the text as white -->
		A:link
		{
		   COLOR: RED;
		}
		A:visited
		{
		    COLOR: YELLOW ;
		}
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="placeOrderLegendsForm" id="placeOrderLegendsForm">
 <%
 	//if((previousValues!=null && previousValues.size()>0) || function_from.equals("AMEND_ORDER"))
   	//{
  %>
  		<div width="100%" style="overflow: hidden;">
		<table border="1" cellpadding=3 cellspacing=0  style="width:100%">
		<tr>
			<th class=' COLUMNHEADER' style="width:2%">&nbsp;</th>
			<th class=' COLUMNHEADER'  style="width:12%"><a class="gridLink" href="javascript:<%=amend_start_disabled.equals("DISABLED")?"":"changeAllStartDateTime()"%>" title="<%=amend_start_disabled.equals("DISABLED")?"":"Do you want to change the Start Date Time, Click here"%>"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></th>
			<th class=' COLUMNHEADER' style="width:29%"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></th> 
			<th class=' COLUMNHEADER' style="width:14%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' style="width:4%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' style="width:5%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' style="width:17%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
  			<th class=' COLUMNHEADER' style="width:4%">&nbsp;</th>
			<th class=' COLUMNHEADER' style="width:11%" ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></th>
			<!--<th width="">End Date</th> -->
		</tr>
<%	//}	
%>
	</table>
	</div>
<%
	// Nullifying the Objects
	//previousValues	= null;

	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);

%>
</form>
<script>//setFormatHdr("<%=order_format_mandatory%>","<%=order_format%>","<%=order_category%>",escape("<%=query_string%>"));
	//alert("<%=query_string%>");
	//alert("order_category="+"<%=order_category%>");
	//alert("<%=order_format%>");
	<% if(!order_category.equals("") && order_category.equalsIgnoreCase("CS")) { // For Care Sets Order %>
 		parent.placeOrderDetailFrame.document.location.href = "OrderEntryPlaceOrderCareSetResults.jsp?<%=query_string%>";
 	<% } else { %>
 		parent.placeOrderDetailFrame.document.location.href = "../../eOR/jsp/OrderEntryPlaceOrderResult.jsp?<%=query_string%>";
 	<% } %>
 	if(parent.criteriaDetailFrame.document.getElementById('hdr_format_mandatory_count')!=null)
			parent.criteriaDetailFrame.document.getElementById('hdr_format_mandatory_count').value="<%=order_format_mandatory%>";
	if(parent.criteriaDetailFrame.document.getElementById('hdr_format_count')!=null)
 		parent.criteriaDetailFrame.document.getElementById('hdr_format_count').value="<%=order_format%>";
</script>
</body>
</html>

