<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.ArrayList,eSS.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		String itemcode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
		String itemdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(itemcode);
		items.add("item_code");
		items.add("20");
		items.add("20");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(itemdesc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		String Consumable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Consumable.label","ss_labels");
		String All_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Items.label","common_labels");
	    String Consume_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Consumable.label","ss_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Only.label","ss_labels");
	    String Non_consume_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.NonConsumable.label","ss_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Only.label","ss_labels");
        String Consume_List="%,"+All_legend+",Y,"+Consume_legend+",N,"+Non_consume_legend;
		items=new ArrayList();
		items.add("List");
		items.add(Consumable);
		items.add("consumable_yn");
		items.add(Consume_List);
		items.add("1");
		items.add("1");	
		components.add(items);
			
		String Chargeable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Chargeable.label","ss_labels");
	    String Charge_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Chargeable.label","ss_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Only.label","ss_labels");
	    String Non_charge_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.NonChargeable.label","ss_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Only.label","ss_labels");
        String Charge_List="%,"+All_legend+",Y,"+Charge_legend+",N,"+Non_charge_legend;
		items=new ArrayList();
		items.add("List");
		items.add(Chargeable);
		items.add("chargeable_yn");
		items.add(Charge_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	    String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
        String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		items=new ArrayList();
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
		headers[0] = itemcode;
		headers[1] = itemdesc;

		String[] values = new String[2];
		values[0]="item_code";
		values[1]="long_desc";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String item=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.item.label","common_labels");

		htmlTag = queryPage.getQueryPage(null,components,item ,"../../eSS/jsp/ItemQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
