<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<%
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

		ArrayList components = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserID.label","ss_labels"));
		firstItem.add("user_id");
		firstItem.add("30");
		firstItem.add("30");
		components.add(firstItem);

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserName.label","ss_labels"));
		secondItem.add("appl_user_name");
		secondItem.add("60");
		secondItem.add("60");
		components.add(secondItem);

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreCode.label","ss_labels"));
		thirdItem.add("store_code");
		thirdItem.add("6");
		thirdItem.add("6");
		components.add(thirdItem); 

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreDescription.label","ss_labels"));
		fourthItem.add("long_desc");
		fourthItem.add("40");
		fourthItem.add("40");
		components.add(fourthItem);

		ArrayList items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserID.label","ss_labels");
		headers[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserName.label","ss_labels");
		headers[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreCode.label","ss_labels");
		headers[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreDescription.label","ss_labels");

		String[] values = new String[4];
		values[0]="user_id";
		values[1]="appl_user_name";
		values[2]="store_code";
		values[3]="long_desc";
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String useraccess=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserAccessforStore.label","ss_labels");
		htmlTag = queryPage.getQueryPage(null,components,useraccess ,"UserAccessForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);

	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
