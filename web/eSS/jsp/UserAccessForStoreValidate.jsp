
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* "%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	String validate = request.getParameter("validate");
	if ((bean_id == null) || (bean_id.equals("")))
		return;

	UserAccessForStoreBean bean = (UserAccessForStoreBean)getBeanObject( bean_id, bean_name,request) ;  
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	
	
		if(validate.equals("TRIAL")){
		
							if (hash.size() > 0) {
												bean.setAllNext(hash);
												}
									}
		putObjectInBean(bean_id,bean,request);
%>
