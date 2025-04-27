<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page    import="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*"
	contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<script> 
</script>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String enabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.enabled.label", "bl_labels");
	String disabled = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Disabled.label", "bl_labels");
	String all = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.all.label", "bl_labels");
	StringBuffer strbuff;
	Connection con = null;

	try {

		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text"); //Type of item
		firstItem.add("Card Type"); // label
		firstItem.add("card_type_code"); //name of field
		firstItem.add("30"); // SIZE
		firstItem.add("30"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr


		ArrayList secondItem = new ArrayList();
		secondItem.add("Text"); //Type of item
		secondItem.add("Long Description"); // label
		secondItem.add("long_desc"); //name of field
		secondItem.add("30"); // SIZE
		secondItem.add("30"); //LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr
		
		ArrayList thirdItem = new ArrayList();
		thirdItem.add("List"); //Type of item
		thirdItem.add("Status"); // label
		thirdItem.add("status");//name
		thirdItem.add("A,"+all+",Y,"+enabled+",N,"+disabled);//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(thirdItem);//add to ArrayList obj finAr


		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = "Card Type";
		orderByCols[1] = "Status";

		orderByColVals[0] = "card_type_code";
		orderByColVals[1] = "status";

		strbuff = qrypg.getQueryPage(con, finAr, "Find Service",
				"../jsp/HealthCardMasterQueryResult.jsp",
				com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.SortOrder.label",
						"common_labels"), com.ehis.util.BundleMessage
						.getBundleMessage(pageContext,
								"Common.QueryCriteria.label",
								"common_labels"),
				com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.defaultSelect.label",
						"common_labels"),
				com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.orderBy.label",
						"common_labels"), orderByCols, orderByColVals,
				"Execute Query");

		out.println(strbuff.toString());
		strbuff.setLength(0);
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
%>
