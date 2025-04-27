 <%@page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	

	StringBuffer strbuff = new StringBuffer();
	try 
	{
		ArrayList finAr = new ArrayList();

			
	//=============== populating the first item in the firstitem object
	String Item_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Item_code);	  // label
		firstItem.add("item_code");	//name of field
		firstItem.add("20");	//LENGTH
		firstItem.add("20");
		finAr.add(firstItem);//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object
	String Item_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Item_Desc);  // label
		secondItem.add("item_desc");   //name of field
		secondItem.add("40");	//LENGTH
		secondItem.add("40");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr

		String tpn_item = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNItem.label","ph_labels");

		String all_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String tpn_item_list_values="A,"+all_legend+",Y,"+yes_legend+",N,"+no_legend;
		ArrayList ThirdItem=new ArrayList();
		ThirdItem.add("List");  //Type of item
		ThirdItem.add(tpn_item);  // label
		ThirdItem.add("tpn_item_yn");   //name of field
		ThirdItem.add(tpn_item_list_values);//static values that need to be displayed as
		ThirdItem.add("7");	//LENGTH
		finAr.add(ThirdItem); //add to ArrayList obj finAr
	
		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = Item_code;
		orderByCols[1] = Item_Desc;

		orderByColVals[0] = "item_code";
		orderByColVals[1] = "short_desc";
         
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

        strbuff = qrypg.getQueryPage(null, finAr, Item_Desc, "TPNStockItemQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);


		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
