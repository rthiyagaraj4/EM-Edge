<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*, eOR.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%   

	String bean_id = "OROrderablesBySourceBean" ;
	String bean_name = "eOR.OROrderablesBySourceBean";
	
	OROrderablesBySourceBean bean = (OROrderablesBySourceBean)getBeanObject( bean_id, bean_name, request ) ;
	
	String str_order_category = request.getParameter("order_category");
	
	if(str_order_category != null)
	{
		System.out.println(" @@@@@@@@@@ Entered into order category condition");

		ArrayList orderList = bean.getOrderTypeList(str_order_category);	
		Vector order_type_code = (Vector )orderList.get(0);
		Vector short_desc_type = (Vector )orderList.get(1);
		out.println( "fillOrderTypeValues(\"\" ,\"All\") ; " ) ;
		//out.println("alert('"+order_type_code.size()+"');");
		for(int i=0;i<order_type_code.size();i++){
			
		//for(int i=0;i<=2;i++){
			out.println("fillOrderTypeValues(\'"+(String)order_type_code.get(i)+"\',\'"+(String)short_desc_type.get(i)+"\');");
		}
	} putObjectInBean(bean_id,bean,request);
%>
