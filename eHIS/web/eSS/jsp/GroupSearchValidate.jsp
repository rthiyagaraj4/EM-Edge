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
	request.setCharacterEncoding("UTF-8");
	GroupSearchBean bean = (GroupSearchBean)getBeanObject("groupSearch",  "eSS.GroupSearchBean",request );
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	int functionType = Integer.parseInt((String)hash.get("function_type"));

	switch (functionType) {
	case 1:
		{
				String group_code = (String) hash.get("group_desc");
				group_code = group_code.trim();
				bean.setGroup_code(group_code.toUpperCase());
				bean.execute(functionType);
				out.println("assignResult("+bean.getResult()+",getMessage(\"INVALID_GROUP_CODE\"), \"0\")");
				if (bean.getResult()) {
					out.println("group_code.value ='"+bean.getGroup_code()+"';");
					out.println("group_desc.value ='"+bean.getGroup_desc()+"';");
				}
		}
		break;
	case 2:
		{
				String group_code = (String) hash.get("group_desc");
				String group_type_code = (String) hash.get("group_type_code");
				group_code = group_code.trim();
				bean.setGroup_code(group_code.toUpperCase());
				bean.setGroup_type_code(group_type_code);
				bean.execute(functionType);
				out.println("assignResult("+bean.getResult()+",getMessage(\"INVALID_GROUP_CODE\"), \"0\")");
				if (bean.getResult()) {
					out.println("group_code.value ='"+bean.getGroup_code()+"';");
					out.println("group_desc.value ='"+bean.getGroup_desc()+"';");
				}
		}
		break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}
	putObjectInBean( "groupSearch",  bean,request);
%>
