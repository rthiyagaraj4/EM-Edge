<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"
	import="webbeans.eCommon.*,java.sql.*,java.util.*,eMM.*,eMM.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%
	//@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	//	
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>

<html>
<head>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%
	try {
		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

		String function_id = request.getParameter("function_id");
		StringBuffer strbuff = new StringBuffer();
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		ArrayList secondItem = new ArrayList();
		ArrayList thirdItem = new ArrayList();
		
		String categoryGroupCode = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext, "ePH.CategoryGroupCode.label",
						"ph_labels");

		String categoryGroupDescription = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"ePH.CategoryGroupDesc.label", "ph_labels");
		//String categoryGroupCode = "Category Group code";
		//String categoryGroupDescription = "Category Group Description";
		
		firstItem.add("Text"); //Type of item
		firstItem.add(categoryGroupCode); // label
		firstItem.add("category_group_code"); 
		firstItem.add("20"); // SIZE
		firstItem.add("20");
		finAr.add(firstItem);

		
		
		secondItem.add("Text"); //Type of item
		secondItem.add(categoryGroupDescription); // label
		secondItem.add("category_group_desc"); //name of field
		secondItem.add("20"); // SIZE
		secondItem.add("20"); //LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		
		
		String both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String category_list_values="B,"+both_legend+",E,"+enabled_legend+",D,"+disabled_legend;
 
		String nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

		thirdItem.add("List");  //Type of item
		thirdItem.add(nature);  // label
		thirdItem.add("eff_status");   //name of field
		thirdItem.add(category_list_values); //static values that need to be 
		thirdItem.add("7");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList items = new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		finAr.add(items);

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = categoryGroupCode;
		orderByCols[1] = categoryGroupDescription;
		

		orderByColVals[0] = "category_group_code";
		orderByColVals[1] = "category_group_desc";
		
		

		String Sort_order = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.SortOrder.label", "common_labels");

		String defaultSelect = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.defaultSelect.label", "common_labels");

		String orderBy = com.ehis.util.BundleMessage.getBundleMessage(
				pageContext, "Common.orderBy.label", "common_labels");

		String QueryCriteria = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.QueryCriteria.label", "common_labels");

		String ExecuteQuery = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.ExecuteQuery.label", "common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, "category_group_code",
				"PregnancyCategoryQueryResult.jsp", Sort_order,
				QueryCriteria, defaultSelect, orderBy, orderByCols,
				orderByColVals, ExecuteQuery, true);

		out.println(strbuff.toString());
	} catch (java.lang.Exception exception) {
		out.println(exception.toString());
	}
%>
