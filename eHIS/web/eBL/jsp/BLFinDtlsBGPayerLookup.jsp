<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message bundle="${bl_labels }" key="eBL.BillingGroup.label"></fmt:message></title>
<%String  queryString = request.getQueryString();
System.err.println("queryString->"+queryString);
%>
</head>

<iframe src= "../../eBL/jsp/BLFinDtlsBGPayerSearch.jsp?<%=queryString%>" name="SearchFrame" frameborder=0 noresize scrolling='no' style='height:15vh;width:100vw'></iframe>
<iframe src= "../../eCommon/html/blank.html" name="ResultFrame" id="ResultFrame" frameborder=0 noresize scrolling='auto' style='height:60vh;width:100vw'></iframe>
<iframe src= "../../eBL/jsp/BLFinDtlsBGPayerDisplay.jsp" name="DisplayFrame" id="DisplayFrame" frameborder=0 noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
</html>

