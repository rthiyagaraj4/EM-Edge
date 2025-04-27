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
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.DocTypeCode.label","ss_labels"));
		items.add("doc_type_code");
		items.add("6");
		items.add("6");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.DocTypeDescription.label","ss_labels"));
		items.add("doc_type_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items = new ArrayList();
		items.add("Text");
		items.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.TRNType.label","ss_labels"));
		items.add("trn_type");
		items.add("3");
		items.add("3");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.TRNTypeDescription.label","ss_labels"));
		items.add("trn_type_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.DocTypeCode.label","ss_labels");
		headers[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.DocTypeDescription.label","ss_labels");
		headers[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.TRNType.label","ss_labels");
		headers[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.TRNTypeDescription.label","ss_labels");

		String[] values = new String[4];
		values[0]="doc_type_code";
		values[1]="doc_type_desc";
		values[2]="trn_type";
		values[3]="trn_type_desc";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String surgerytype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SurgeryType.label","ss_labels");
		htmlTag = queryPage.getQueryPage(null,components,surgerytype ,"../../eSS/jsp/TrnDocTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
