<!DOCTYPE html>
		<!-- *****AM Master - Trade Name Query Criteria **** -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, eCommon.XSSRequestWrapper, java.util.*" contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null ;
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	
	firstItem.add("Text"); 		// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeID.label","common_labels"));	// Label
	firstItem.add("tradeid");	// Name of field
	firstItem.add("21");		// Size
	firstItem.add("20");		// Length
	finAr.add(firstItem);		// Add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels"));	 // Label
	secondItem.add("long_name");	 // Name of field
	secondItem.add("44");			 // Size
	secondItem.add("40");			 // Length
	finAr.add(secondItem);			 // Add to ArrayList obj finAr
	
/*	ArrayList thirdItem = new ArrayList();
	
	thirdItem.add("Text"); 		// Type of item
	thirdItem.add("Trade Short Name");	// Label
	thirdItem.add("short_name");	// Name of field
	thirdItem.add("21");		// Size
	thirdItem.add("20");		// Length
	finAr.add(thirdItem);		// Add to ArrayList obj finAr
*/
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManufacturerID.label","common_labels"));	 // Label
	thirdItem.add("Manufacturer_id");	 // Name of field
	thirdItem.add("21");			 // Size
	thirdItem.add("20");			 // Length
	finAr.add(thirdItem);			 // Add to ArrayList obj finAr


	
	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 // Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManufacturerName.label","common_labels"));	 // Label
	fourthItem.add("Manufacturer_name");	 // Name of field
	fourthItem.add("21");			 // Size
	fourthItem.add("20");			 // Length
	finAr.add(fourthItem);			 // Add to ArrayList obj finAr

		
	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   		 // Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Drug.label","common_labels"));		 // Label
	fifthItem.add("drug_yn");   	 // Name
	//fifthItem.add("B,Both,Y,Yes,N,No");	 // Values that need to be displayed 
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(fifthItem); 			 // Add to ArrayList obj finAr


	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   		 // Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));		 // Label
	sixthItem.add("eff_status");   	 // Name
	 // Values that need to be displayed 
  sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
	finAr.add(sixthItem); 			 // Add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeID.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManufacturerID.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManufacturerName.label","common_labels");
	
	orderByColVals[0] = "A.TRADE_ID";
	orderByColVals[1] = "A.LONG_NAME";
	orderByColVals[2] = "A.MANUFACTURER_ID";
	orderByColVals[3] = "B.LONG_NAME";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Id","../jsp/TradeNameQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	finAr.clear();

%>
