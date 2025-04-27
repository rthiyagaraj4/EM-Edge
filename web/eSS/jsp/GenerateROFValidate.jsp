<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.*, eSS.Common.*, eSS.* "%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = "generateROFBean";
	String bean_name = "eSS.GenerateROFBean";
	int functionType = Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	GenerateROFBean bean = (GenerateROFBean) getBeanObject(bean_id, bean_name,request );
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	
	switch (functionType) {
		case 1: 
			{
			boolean		result=false;
					if (hash.size() > 0) {
						bean.updateSelectedTrays(hash);
						result=true;
						out.println(" assignResult(" + result + ", \"" + " " + "\", \"" + " " + "\" ) ; ") ;
					}else{
				
		out.println(" assignResult(" + result + ", \"" + " " + "\", \"" + " " + "\" ) ; ") ;
					}
			}
			break;
		default :
			return;
	}
%>
<%
	putObjectInBean(bean_id, bean,request);
%>

