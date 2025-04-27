<!DOCTYPE html>
<%@ page import ="ePO.*, ePO.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<% 

	 request.setCharacterEncoding("UTF-8");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><fmt:message key="eST.PurchaseOrderDetails.label" bundle="${st_labels}"/></title>
</head>
<%
	String params = request.getQueryString();
%>
<iframe name="framePOItemDetailCriteria" id="framePOItemDetailCriteria" scrolling="no" noresize src="../../ePO/jsp/POItemDetailCriteria.jsp?<%=params%>" style="height:19vh;width:100vw"></iframe><iframe name="framePOItemDetailResult" id="framePOItemDetailResult" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:81vh;width:100vw"></iframe>
</html>

