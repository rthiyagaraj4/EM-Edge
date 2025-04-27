<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "java.util.*,eOR.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>

 

<%
	//String bean_id = "Or_OrdersTab";
	//String bean_name = "eOR.OrdersTabBean";
	//String destPage = "";
	request.setCharacterEncoding("UTF-8");
	String practitioner_id = request.getParameter("practitioner_id");
	String patient_class = request.getParameter("patient_class");
	String mode = request.getParameter("mode");

 

	String result = "";
	if(result.equalsIgnoreCase("VALID"))
	{
		request.setAttribute("practitioner_id",practitioner_id);
		request.setAttribute("patient_class",patient_class);
		request.setAttribute("mode",mode);
%>
<jsp:forward page="../../eOR/jsp/OrdersTabPlaceOrderModify.jsp"></jsp:forward>
	<%
	}	
	else
	{
		request.setAttribute("err_num","Invalid Practitioner ID");
	%>
<jsp:forward page="../../eOR/jsp/OrdersTabPlaceOrderModify.jsp"></jsp:forward> 
	<%
	}
	%>
