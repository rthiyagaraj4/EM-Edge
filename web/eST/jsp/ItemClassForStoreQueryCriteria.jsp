<!DOCTYPE html>
 <%@ page import ="java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086			
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<%
		ArrayList components	= new ArrayList();
		ArrayList firstItem		= new ArrayList();
		ArrayList firstItem_1	= new ArrayList();
		ArrayList secondItem	=new ArrayList();
		ArrayList secondItem_2	=new ArrayList();
		ArrayList items			=new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

		String Store_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");
		firstItem.add("Text");
		firstItem.add(Store_Code);
		firstItem.add("store_code");
		firstItem.add("6");
		firstItem.add("6");
		components.add(firstItem);

		String Store_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");
		firstItem_1.add("Text");
		firstItem_1.add(Store_Desc);
		firstItem_1.add("store_desc");
		firstItem_1.add("40");
		firstItem_1.add("40");
		components.add(firstItem_1);

		String ItemClassCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemClassCode.label","common_labels");
		secondItem.add("Text");
		secondItem.add(ItemClassCode);
		secondItem.add("item_class_code");
		secondItem.add("4");
		secondItem.add("4");
		components.add(secondItem);

		String ItemClassDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemClassDescription.label","common_labels");
		
		secondItem_2.add("Text");
		secondItem_2.add(ItemClassDesc);
		secondItem_2.add("item_class_desc");
		secondItem_2.add("40");
		secondItem_2.add("40");
		components.add(secondItem_2);

		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = Store_Code;
		headers[1] = Store_Desc;
		headers[2] = ItemClassCode;
		headers[3] = ItemClassDesc;

		String[] values = new String[4];
		values[0]="store_code";
		values[1]="store_desc";
		values[2]="item_class_code";
		values[3]="item_class_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ItemClassforStore=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemClassforStore.label","mm_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,ItemClassforStore ,"ItemClassForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);

	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();	
		firstItem.clear();			
		firstItem_1.clear();	
		secondItem.clear();	
		secondItem_2.clear();	
		items.clear();			
	}
%>
