<!--<!DOCTYPE html>-->
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%	
	request.setCharacterEncoding("UTF-8");
	String bean_id = "RefusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
		request.setCharacterEncoding("UTF-8");

	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");

	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name , request) ;

			bean.setLanguageId(localeName);


	String date = bean.getVisitAdmDate(patient_id,encounter_id);
	
	date=com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",localeName);

System.err.println("date==================="+date);
	
	if(date != null && date != "")
	{
	  
		out.println("setVisitAdminDate(\""+date+"\");"); 
	}
	putObjectInBean(bean_id,bean,request);
%>
