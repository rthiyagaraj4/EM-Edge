<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	Body Frame which contains all the pages belonging to this function --%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Update</title>
<%
String beanId = "PkgPriceRevisionRequest" ;
String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
PkgPriceRevisionRequest pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
pkgPriceDiscount.clearAll();
%>
</head>
<iframe id='search' name='search' frameborder="0" src="PkgBulkUpdSearch.jsp" noresize style='height:27vh;width:100vw'></iframe>
	<iframe id='bulkUpdate' name='bulkUpdate' frameborder="0" src="../../eCommon/html/blank.html" noresize style='height:28vh;width:100vw'></iframe>
	<iframe name='lookupTab' id='lookupTab' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'  style='height:7vh;width:100vw'></iframe>
	<iframe id='lookUpData' name='lookUpData' frameborder="0" src="../../eCommon/html/blank.html" noresize style='height:32vh;width:100vw'></iframe>
	<iframe id='lookup' name='lookup' frameborder="0" src="../../eCommon/html/blank.html" noresize style='height:6vh;width:100vw'></iframe>	
	<iframe name='lookupAdd' id='lookupAdd'	src='../../eCommon/html/blank.html' frameborder=0 noresize   style='height:0vh;width:100vw'></iframe>
</html>

