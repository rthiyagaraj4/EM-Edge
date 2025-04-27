<!-- 
CRF Reference No: ML-MMOH-CRF-2111
Detected Release: JUNE24
File Prepared by: Ajay Hatwate
File Prepared on: 10/04/2024
-->
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try {
		con = ConnectionManager.getConnection(request);

		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disaster.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
		firstItem.add("disaster_catg_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();

		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disaster.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
		secondItem.add("long_desc");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		thirdItem.add("enabled");   //name of field
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("4");	//LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disaster.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","ae_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disaster.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		orderByColVals[0] = "disaster_category_code";
		orderByColVals[1] = "long_desc";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disaster.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","ae_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"),"../jsp/QueryResultDisasterCategory.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
	}catch (Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>