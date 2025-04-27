
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
		String function_id=request.getParameter("function_id");
		String servicelocation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.ServiceLocation.label","ss_labels");
		String servicelocationdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.ServiceLocationDescription.label","ss_labels");
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	    String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
        String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;

		ArrayList components = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(servicelocation);
		firstItem.add("service_location_code");
		firstItem.add("8");
		firstItem.add("8");
		components.add(firstItem);

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");
		secondItem.add(servicelocationdesc);
		secondItem.add("long_desc");
		secondItem.add("40");
		secondItem.add("40");
		components.add(secondItem);

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");
		thirdItem.add(Nature);
		thirdItem.add("eff_status");
		thirdItem.add(Nature_List);
		thirdItem.add("1");
		thirdItem.add("1");	
		components.add(thirdItem); 

		ArrayList items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);


		String[] headers = new String[2];
		headers[0] = servicelocation;
		headers[1] = servicelocationdesc;

		String[] values = new String[2];
		values[0]="service_location_code";
		values[1]="long_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String ServiceLocation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.ServiceLocation.label","ss_labels");

		htmlTag = queryPage.getQueryPage(null,components,ServiceLocation,"ServiceLocationQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
