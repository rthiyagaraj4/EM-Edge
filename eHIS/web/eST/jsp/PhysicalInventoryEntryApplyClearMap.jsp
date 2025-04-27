<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
	<%	
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
//	java.util.HashMap defaultParameter = new HashMap();
	String bean_id = "PhysicalInventoryEntryBean";
	String bean_name = "eST.PhysicalInventoryEntryBean";
	PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean)getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear_data_added();
	%>
</head>
<body>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>
