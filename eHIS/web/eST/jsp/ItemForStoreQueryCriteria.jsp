<%@ page import ="java.util.ArrayList" %>
<%@page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<%
		ArrayList components					=		new ArrayList();
		ArrayList firstItem						=		new ArrayList();
		ArrayList firstItem_1					=		new ArrayList();
		ArrayList secondItem					=		new ArrayList();
		ArrayList secondItem_2					=		new ArrayList();
		ArrayList thirdItem						=		new ArrayList();
		ArrayList fourthItem					=		new ArrayList();
		ArrayList fifthItem						=		new ArrayList();
		ArrayList sixthItem						=		new ArrayList();
		ArrayList items							=		new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage	=		new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag					=		new StringBuffer();
		String function_id						=		request.getParameter( "function_id" );

		String Store_Code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");
		firstItem.add("Text");
		firstItem.add(Store_Code);
		firstItem.add("store_code");
		firstItem.add("6");
		firstItem.add("6");
		components.add(firstItem);

		String Store_Desc						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");
		firstItem_1.add("Text");
		firstItem_1.add(Store_Desc);
		firstItem_1.add("store_desc");
		firstItem_1.add("40");
		firstItem_1.add("40");
		components.add(firstItem_1);

		String Item_Code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
		secondItem.add("Text");
		secondItem.add(Item_Code);
		secondItem.add("item_code");
		secondItem.add("20");
		secondItem.add("20");
		components.add(secondItem);

		String Item_Desc						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
		secondItem_2.add("Text");
		secondItem_2.add(Item_Desc);
		secondItem_2.add("item_desc");
		secondItem_2.add("60");
		secondItem_2.add("60");
		components.add(secondItem_2);

		String StoreType						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreType.label","common_labels");
		String all_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String main_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels");
		String NonStock_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonStock.label","st_labels");
		String SubStore_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SubStore.label","st_labels");
		String pharmacy_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels");

		String Store_type_list					=		"%,"+all_legend+",M,"+main_legend+",S,"+SubStore_legend+",P,"+pharmacy_legend+",N,"+NonStock_legend;
		thirdItem.add("List");
		thirdItem.add(StoreType);
		thirdItem.add("store_type_code");
		thirdItem.add(Store_type_list);
		thirdItem.add("1");
		thirdItem.add("1");	
		components.add(thirdItem);

		String Stock_Item						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StockItem.label","st_labels");
		String Yes_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Stock_Item_Option				=		"%,"+all_legend+",Y,"+Yes_legend+",N,"+No_legend;

		fourthItem.add("List");
		fourthItem.add(Stock_Item);
		fourthItem.add("stock_item_yn");
		fourthItem.add(Stock_Item_Option);
		fourthItem.add("1");
		fourthItem.add("1");	
		components.add(fourthItem);

		String Item_Class						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemClass.label","common_labels");
		fifthItem.add("List");
		fifthItem.add(Item_Class);
		fifthItem.add("item_class_code");
		fifthItem.add(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_ST_SELECT_LIST"));
		components.add(fifthItem);
	
		
		String Nature							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List						=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;

		sixthItem.add("List");
		sixthItem.add(Nature);
		sixthItem.add("eff_status");
		sixthItem.add(Nature_List);
		sixthItem.add("1");
		sixthItem.add("1");	
		components.add(sixthItem); 

		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers						=		new String[4];
		headers[0] = Store_Code;
		headers[1] = Store_Desc;
		headers[2] = Item_Code;
		headers[3] = Item_Desc;

		String[] values							=		new String[4];
		values[0]="store_code";
		values[1]="store_desc";
		values[2]="item_code";
		values[3]="item_desc";

		String Sort_order						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String ItemforStore						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemforStore.label","mm_labels");
		String QueryCriteria					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag									=		queryPage.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,ItemforStore ,"ItemForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
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
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		items.clear();
	}
%>
