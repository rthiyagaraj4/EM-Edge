<!DOCTYPE html>
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
  String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
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
		String auto_wash_unitcode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.AutoclaveWashUnitCode.label","ss_labels");
		String auto_wash_unitdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.AutoclaveWashUnitDescription.label","ss_labels");

		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(auto_wash_unitcode);
		items.add("autoclave_wash_unit_code");
		items.add("8");
		items.add("8");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(auto_wash_unitdesc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		String unittype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UnitType.label","ss_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String autoclave_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Autoclave.label","ss_labels");
	    String washing_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Washing.label","ss_labels");
        String Unittype_List="%,"+Both_legend+",A,"+autoclave_legend+",W,"+washing_legend;
		items=new ArrayList();
		items.add("List");
		items.add(unittype);
		items.add("unit_type");
		items.add(Unittype_List);
		items.add("1");
		items.add("1");	
		components.add(items);
	String servicelocation = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.ServiceLocation.label","ss_labels");
		items=new ArrayList();
		items.add("List");
		items.add(servicelocation);
		items.add("service_location_code");
		String s = "SELECT service_location_code, short_desc FROM ss_service_location_lang_vw WHERE eff_status='E' AND facility_id=";
		String s1 = s+"'"+(String)session.getAttribute("facility_id")+"' and language_id ='"+locale+"' order by 2";
		items.add(s1);
		components.add(items);
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
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
		headers[0] = auto_wash_unitcode;
		headers[1] = auto_wash_unitdesc;

		String[] values = new String[2];
		values[0]="unit_type,autoclave_wash_unit_code";
		values[1]="unit_type,aut_long_desc";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String autoclavewashingunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.AutoclaveWashingUnit.label","ss_labels");

		htmlTag = queryPage.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,autoclavewashingunit ,"../../eSS/jsp/AutoclaveWashingUnitQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
