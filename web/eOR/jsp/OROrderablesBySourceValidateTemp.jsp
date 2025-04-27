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

	String str_order_code = request.getParameter("order_code");
	ArrayList codeList = new ArrayList();
	String facility_id = request.getParameter("facility_id");

	if(str_order_code != null)
	{
		System.out.println(" @@@@@@ Entered into source code condition");
		codeList = bean.getSourceCodeList(str_order_code,facility_id);
		Vector unit_code = (Vector)codeList.get(0);
		Vector short_desc = (Vector)codeList.get(1);
		out.println( "fillSourceCodeValues(\"\" ,\'All\')" ) ;
		
		int  no = unit_code.size();
		//out.println("alert('"+no+"');");
		//int no1=unit_code.size();
		String  temp = "";
		for(int i=0;i<no;i++)
		{
			temp = (String)short_desc.get(i);
			if(temp.indexOf('\'') != -1)
			{
				temp = temp.replace('\'', '`');												
			}
			
			out.println("fillSourceCodeValues(\'"+(String)unit_code.get(i)+"\',\'"+temp +"\');");
		}
		/*for(int i=0;i<no1;i++)
		{
			out.println("fillSourceCodeValues1(\'"+(String)unit_code.get(i)+"\',\'"+(String) short_desc.get(i)+"\');");
		}*/
	} putObjectInBean(bean_id,bean,request);	
%>
