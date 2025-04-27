<!DOCTYPE html>
<%@page import="eBL.billreceipt.model.BillReceiptExclusionDiscount"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exclude Services</title>
<%	String queryString = request.getQueryString(); 	
String beanId = "BillReceiptExistOrderExclusion" ;
String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
BillReceiptExistOrderExclusion exclusionBean = null;
exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
/*
exclusionBean.setInterDiscount(new HashMap<String,BillReceiptExclusionDiscount>());
exclusionBean.setInterExclusion(new HashMap<String,BillReceiptExclusionDiscount>());*/

HashMap<String,BillReceiptExclusionDiscount> interDiscount = exclusionBean.getDiscountMap();
if(interDiscount == null){
	interDiscount = new HashMap<String,BillReceiptExclusionDiscount>();
}
Set<String> interExclusion = exclusionBean.getServiceExclusion();
if(interExclusion == null){
	interExclusion = new HashSet<String>();
}
exclusionBean.setInterDiscount(interDiscount);
exclusionBean.setInterExclusion(interExclusion);
putObjectInBean(beanId,exclusionBean,request);
%>
</head>
	<iframe frameborder='0' name='progressFrame' id='progressFrame' src='../../eCommon/jsp/process.jsp' noresize style='height:5vh;width:100vw'></iframe>
		<iframe frameborder='0' name='serviceList' id='serviceList' src='BillReceiptExistOrderService.jsp?<%=queryString %>' noresize style='height:82vh;width:100vw'></iframe>
		<iframe frameborder='0' name='closeWinsow' id='closeWinsow' src='BillReceiptExistOrderServiceClose.jsp?<%=queryString %>' scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	
</html>

