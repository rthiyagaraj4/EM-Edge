<!DOCTYPE html>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
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
	<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>Purchase Request Details</title>
</head>
<%
	String params = request.getQueryString();
	System.out.println("params = "+params);
	
%>
<iframe name="framePurchaseOrderSearchWindowCriteria" id="framePurchaseOrderSearchWindowCriteria" scrolling="no" noresize src="../../ePO/jsp/PurchaseOrderSearchWindowCriteria.jsp?<%=params%>" style="height:19vh;width:100vw"></iframe><iframe name="framePurchaseOrderSearchWindowResult" id="framePurchaseOrderSearchWindowResult" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:81vh;width:100vw"></iframe>
</html>

