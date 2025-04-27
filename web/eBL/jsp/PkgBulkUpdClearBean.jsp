<!DOCTYPE html>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
String beanId = "PkgPriceRevisionRequest" ;
String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
PkgPriceRevisionRequest pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
pkgPriceDiscount.clearAll();
%>
