<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ArrayList components= new ArrayList();
		ArrayList firstItem = new ArrayList();
		ArrayList secondItem=new ArrayList();
		ArrayList thirdItem	=new ArrayList();
		ArrayList items		=new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();		
		String function_id=request.getParameter("function_id");
		String prepare_location_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrepareLocation.label","common_labels");
		firstItem.add("Text");
		firstItem.add(prepare_location_code);
		firstItem.add("prepare_location_code");
		firstItem.add("8");
		firstItem.add("8");
		components.add(firstItem);

		
		
		String description_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		String prepare_desc=prepare_location_code+" "+description_legend;
		
		secondItem.add("Text");
		secondItem.add(prepare_desc);
		secondItem.add("long_desc");
		secondItem.add("40");
		secondItem.add("40");
		components.add(secondItem);

		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		thirdItem.add("List");
		thirdItem.add(Nature);
		thirdItem.add("eff_status");
		thirdItem.add(Nature_List);
		thirdItem.add("1");
		thirdItem.add("1");	
		components.add(thirdItem); 

		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);


		String[] headers = new String[2];
		headers[0] = prepare_location_code;
		headers[1] = prepare_desc;

		String[] values = new String[2];
		values[0]="prepare_location_code";
		values[1]="long_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,prepare_location_code,"PrepareLocationQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		firstItem.clear(); 
		secondItem.clear();
		thirdItem.clear();	
		items.clear();		
	}
%>
