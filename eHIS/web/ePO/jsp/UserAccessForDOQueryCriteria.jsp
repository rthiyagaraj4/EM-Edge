<!DOCTYPE html>
<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ArrayList components	=	new ArrayList();
		ArrayList firstItem		=	new ArrayList();
		ArrayList secondItem	=	new ArrayList();
		ArrayList thirdItem		=	new ArrayList();
		ArrayList fourthItem	=	new ArrayList();
		ArrayList items			=	new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
		
		String username1="";
		
		String user_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		firstItem.add("Text");
		firstItem.add(user_id);
		firstItem.add("user_id");
		firstItem.add("30");
		firstItem.add("30");
		components.add(firstItem);

		String username = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		secondItem.add("Text");
		secondItem.add(username);
		secondItem.add("appl_user_name");
		secondItem.add("60");
		secondItem.add("60");
		components.add(secondItem);
		
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = user_id;
		headers[1] = username;
		headers[2] = username1;
		headers[3] = username1;

		String[] values = new String[4];
		values[0]="user_id";
		values[1]="appl_user_name";
		values[2]="appl_user_name";
		values[3]="appl_user_name";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String UserAccessForStore=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserAccessforStore.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,UserAccessForStore ,"UserAccessForDOQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);

	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		firstItem.clear();	
		secondItem.clear();
		items.clear();		
	}
%>
