<!DOCTYPE html>
<%-- Added by Rajesh V for KAUH-CRF-0318
	Body Frame which contains all the pages belonging to this function --%>
<%@page import="eBL.CosmeticRuleHeaderBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cosmetic Rule Setup</title>
<%String params = request.getQueryString(); 

String beanId = "CosmeticRuleBean" ;
String beanName = "eBL.CosmeticRuleHeaderBean";

CosmeticRuleHeaderBean cosmeticBean = (CosmeticRuleHeaderBean) getBeanObject(beanId, beanName, request);
cleanBeanObject(beanId, beanName, request);
cosmeticBean.clearAll();
%>
</head>
	<iframe id='headerFrame' name='headerFrame' id='headerFrame' frameborder="0" src="CosmeticRuleHeader.jsp?<%=params %>" noresize style='height:100vh;width:100vw'></iframe>
	
	<!--<iframe id='criteriaForTax' name='criteriaForTax' id='criteriaForTax' frameborder="0" src="CosmeticRuleTaxCriteria.jsp" noresize></iframe>
		<iframe id='criteriaInclExcl' name='criteriaInclExcl' id='criteriaInclExcl' frameborder="0" src="CosmeticRuleInclExcl.jsp" noresize></iframe>
		-->
</html>

