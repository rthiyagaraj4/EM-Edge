 <%--This file is saved on 07/11/2005 --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
 		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();
		String generic_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.GenericName.label", "ph_labels");
		String drug_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.DrugCode.label" ,"common_labels");
		String drug_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.DrugName.label" ,"common_labels");


		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(generic_name);	  // label
		firstItem.add("GenericName");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr
		
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(drug_code);  // label
		secondItem.add("DrugCode");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(drug_name);	  // label
		thirdItem.add("DrugName");	//name of field
		thirdItem.add("20");	// SIZE
		thirdItem.add("60");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr
		

		//=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] =generic_name;
		orderByCols[1] = drug_code;
		orderByCols[2] = drug_name;

		orderByColVals[2] = "GenericName";	
		orderByColVals[1] = "DrugCode";
		orderByColVals[2] = "DrugName";

		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");
		String ExternalProductLink=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalProductLink.label","ph_labels");

				
		strbuff = qrypg.getMultiColumnQueryPage(null, finAr, ExternalProductLink , "ExternalProductLinkQueryResult.jsp", SortOrder, QueryCriteria, Select, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
