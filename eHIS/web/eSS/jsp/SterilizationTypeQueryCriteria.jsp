<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, eSS.*, eSS.Common.*,eCommon.Common.*"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
     <head>
	 		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 </head>
<%
	try {
		ecis.utils.CommonQueryPage queryPage		=		new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag						=		new StringBuffer();
		String function_id							=		request.getParameter( "function_id" );
		ArrayList components						=		new ArrayList();
		ArrayList items								=		new ArrayList();
		
        String SterilizationType					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SterilizationType.label","ss_labels");


		items.add("Text");
		items.add(SterilizationType);
		items.add("sterile_type");
		items.add("4");
		items.add("4");
		components.add(items);

		items=new ArrayList();

		String SterilizationTypeDescription			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SterilizationTypeDescription.label","ss_labels");

		items.add("Text");
		items.add(SterilizationTypeDescription);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items										=		new ArrayList();
		
		String Nature								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String Enabled_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	    String Disabled_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
        String Nature_List							=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;


		items.add("List");
		items.add(Nature);
		items.add("eff_status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items										=		new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		

		String[] headers							=		new String[2];
		headers[0]									=		SterilizationType;
		headers[1]									=		SterilizationTypeDescription;

		String[] values								=		new String[2];
		values[0]									=		"sterile_type";
		values[1]									=		"long_desc";
       
		String Sort_order							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","mm_labels");
		htmlTag										=		queryPage.getQueryPage(null,components,"Sterilization Type" ,"../../eSS/jsp/SterilizationTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
%>
</html>
