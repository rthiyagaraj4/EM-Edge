<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eOR.Common.*,eCommon.Common.*,java.util.ArrayList,eCommon.XSSRequestWrapper" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<title>Order Entry(Multi Patient Orders Resulting)</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String query = "";
	
		query = request.getQueryString();
	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";

	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	int total_count = Integer.parseInt(request.getParameter("total_count"));
	ArrayList records_list = new ArrayList();
	String record = "";
	for(int i=0;i<total_count;i++)
	{
		record = request.getParameter("select_yn"+i);
		if(!record.equals(""))
			record = record;
		else
			record = "";
		records_list.add(record);
	}
	bean.setFront_page_records(records_list);
	putObjectInBean(bean_id,bean,request);
%>
<Script>
	document.location.href = "../../eOR/jsp/ORMultiPatientOrdersResultingMain.jsp?<%=query%>";
</script>
</html>

