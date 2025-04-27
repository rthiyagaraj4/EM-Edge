<!DOCTYPE html>

		
		
		<!-- AM Master Unit of Measure Query Criteria -->

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, eCommon.XSSRequestWrapper, java.util.*" %>
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
	Connection con = null ;

//	String setup_bl_dtls_in_ip_yn="N";
	//String facilityId = (String)session.getValue("facility_id");
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  	// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	// Label
	firstItem.add("Code");		// Name of field
	firstItem.add("4");			// Size
	firstItem.add("4");			// Length
	finAr.add(firstItem);		// Add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  	 // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // Label
	secondItem.add("long_desc"); // Name of field
	secondItem.add("32");		 // Size
	secondItem.add("30");		 // Lenght
	finAr.add(secondItem);		 // Add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

 	thirdItem.add("List");   	  // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));      // Label
	thirdItem.add("eff_status");  // Name


	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));	// Values that need to be displayed in list Item
	finAr.add(thirdItem); 		  // Add to ArrayList obj finAr
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "UOM_CODE";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Code","../jsp/UnitofMeasureQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	finAr.clear();

%>
