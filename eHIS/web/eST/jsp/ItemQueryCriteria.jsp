<!DOCTYPE html>
<%@ page import ="java.util.ArrayList" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
				
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

		String SterileType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SterileType.label","common_labels");
		items.add("Text");
		items.add(SterileType);
		items.add("sterile_type");
		items.add("4");
		items.add("4");
		components.add(items);

		items=new ArrayList();
		
		String description_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SterileType.label","common_labels");
		String Sterile_type_desc=SterileType+" "+description_legend;
		items.add("Text");
		items.add(Sterile_type_desc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		items.add("List");
		items.add(Nature);
		items.add("eff_status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[2];
		headers[0] = SterileType;
		headers[1] = Sterile_type_desc;

		String[] values = new String[2];
		values[0]="sterile_type";
		values[1]="long_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String item_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.item.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,item_legend ,"../../eST/jsp/ItemQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		items.clear();
	}
%>
