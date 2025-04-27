 <%-- saved on 26/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		String Regimen_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RegimenCode.label","ph_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Regimen_code);	  // label
		firstItem.add("tpn_regimen_code");	//name of field
		firstItem.add("15");	// SIZE
		firstItem.add("15");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		
		ArrayList thirdItem=new ArrayList();
		String long_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longname.label","common_labels");
		thirdItem.add("Text");  //Type of item
		thirdItem.add(long_name);  // label
		thirdItem.add("long_name");   //name of field
		thirdItem.add("30");//SIZE
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		//=====================================================================

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];


		orderByCols[0] = Regimen_code;

		orderByCols[1] = long_name;

		orderByColVals[0] = "tpn_regimen_code";

		orderByColVals[1] = "long_name";

		String tpn_regimen = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNRegimen.label","ph_labels");

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		
		strbuff = qrypg.getQueryPage(null, finAr, tpn_regimen , "TPNRegimenMastQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
