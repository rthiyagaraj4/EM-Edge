<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList, webbeans.eCommon.ConnectionManager" %>
<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%
		String sortOrder =
		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"); 
		String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DefaultSelect.Label","oh_labels");
		String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

		String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String chartid=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		String chart_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		String status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
		String PeriodontalChartSetup_function_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChartSetup.Label","oh_labels");


		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;

		Connection con=null ;
		try {

				con  =  ConnectionManager.getConnection(request);
				ArrayList finAr = new ArrayList();
				ArrayList firstItem = new ArrayList();
						
				firstItem.add("Text");           //Type of item
				firstItem.add(chartid);     // label
				firstItem.add("chartid");   //name of field
				firstItem.add("4"); // SIZE
				firstItem.add("4"); //LENGTH
				finAr.add(firstItem);//add to ArrayList obj finAr

				ArrayList secondItem = new ArrayList();

				secondItem.add("Text");          //Type of item
				secondItem.add(chart_desc);    // label
				secondItem.add("chart_desc");  //name of field
				secondItem.add("30");   // SIZE
				secondItem.add("30");   //LENGTH
				finAr.add(secondItem);    //add to ArrayList obj finAr

				ArrayList thirdItem = new ArrayList();

				thirdItem.add("List");   //Type of item
				thirdItem.add(status);  // label
				thirdItem.add("status");//name
				thirdItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
				finAr.add(thirdItem);

				String[] orderByCols=null;
				String[] orderByColVals=null;

				orderByCols = new String[2];
				orderByColVals = new String[2];

				orderByCols[0] = chartid;
				orderByCols[1] = chart_desc;

				orderByColVals[0] = "chart_code";
				orderByColVals[1] = "chart_desc";

				strbuff = qrypg.getQueryPage( con,finAr,PeriodontalChartSetup_function_name ,"../../eOH/jsp/../../eOH/jsp/PeriodontalChartQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

				out.println(strbuff.toString());

				finAr.clear();
				firstItem.clear();
				secondItem.clear();
				thirdItem.clear();
				} catch (Exception e) {}

		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">


