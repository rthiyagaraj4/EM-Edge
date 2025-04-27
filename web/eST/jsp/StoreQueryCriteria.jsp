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
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
//		eCommon.CommonQueryPageTest queryPage = new eCommon.CommonQueryPageTest();		
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

		String Store_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");
		items.add("Text");
		items.add(Store_Code);
		items.add("store_code");
		items.add("6");
		items.add("6");
		components.add(items);

		items=new ArrayList();
		String Store_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");
		items.add("Text");
		items.add(Store_Desc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		String StoreType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreType.label","common_labels");
		String all_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String main_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels");
		String NonStock_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonStock.label","st_labels");
		String SubStore_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SubStore.label","st_labels");
		String pharmacy_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels");
		String Store_type_list="%,"+all_legend+",M,"+main_legend+",S,"+SubStore_legend+",P,"+pharmacy_legend+",N,"+NonStock_legend;
		items.add("List");
		items.add(StoreType);
		items.add("store_type_flag");
		items.add(Store_type_list);
		items.add("1");
		items.add("1");	
		components.add(items);
		
		items=new ArrayList();
		String ReorderableStore = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ReorderableStore.label","st_labels");
		//String all_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String Reorderable_Stores_Only = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ReorderableStoresOnly.label","st_labels");
		String Non_Reorderable_Stores_Only = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonReorderableStoresOnly.label","st_labels");
		String ROorder_list="%,"+all_legend+",Y,"+Reorderable_Stores_Only+",N,"+Non_Reorderable_Stores_Only;
		items.add("List");
		items.add(ReorderableStore);
		items.add("chk_stk_lvl_for_pur_yn");
		items.add(ROorder_list);
		items.add("1");
		items.add("1");	
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

		String[] headers = new String[3];
		headers[0] =Store_Code;
		headers[1] = Store_Desc;
		headers[2] = ReorderableStore;

		String[] values = new String[4];
		values[0]="store_code";
		values[1]="short_desc";
		values[2]="chk_stk_lvl_for_pur_yn";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String Store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

/*
		java.sql.Connection connection=webbeans.eCommon.ConnectionManager.getConnection(request);
		out.println(connection);
*/
		htmlTag = queryPage.getQueryPage(null,components,Store_legend ,"../../eST/jsp/StoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		items.clear();
	}
%>
