<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	String bin_location_code = request.getParameter("bin_location_code");
	String tray_no = request.getParameter("tray_no");
	String table_index = request.getParameter("table_index");
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;

	AssignBinLocationBean bean = (AssignBinLocationBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
	hash = (Hashtable) hash.get ("SEARCH");

	switch (functionType) {
	case 1: // Case -1 will be executed on click of Modify Button
		{
				String tray_detail[] = {table_index,tray_no, bin_location_code};
				
				
				bean.setSelected_bin_location_code(bin_location_code);
				
				bean.updateTrayDetail(tray_detail);	
		}
		break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}

	putObjectInBean(bean_id,bean,request);
%>
