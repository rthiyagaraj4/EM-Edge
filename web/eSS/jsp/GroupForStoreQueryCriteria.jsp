<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList,eSS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
     <head>
	 		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 </head>
<%
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
		String strcode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreCode.label","ss_labels");
		String strdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.StoreDescription.label","ss_labels");
		String grpcode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupCode.label","ss_labels");
		String grpdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupDescription.label","ss_labels");

		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(strcode);
		items.add("store_code");
		items.add("6");
		items.add("6");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(strdesc);
		items.add("store_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(grpcode);
		items.add("group_code");
		items.add("10");
		items.add("10");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(grpdesc);
		items.add("group_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = strcode;
		headers[1] = strdesc;
		headers[2] = grpcode;
		headers[3] = grpdesc;

		String[] values = new String[4];
		values[0]="store_code";
		values[1]="store_desc";
		values[2]="group_code";
		values[3]="group_desc";
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String grpforstore=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupforStore.label","ss_labels");
		htmlTag = queryPage.getQueryPage(null,components,grpforstore ,"../../eSS/jsp/GroupForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
