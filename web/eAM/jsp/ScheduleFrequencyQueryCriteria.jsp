<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 




<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,eCommon.XSSRequestWrapper, webbeans.eCommon.ConnectionManager" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try
	{
		con  =  ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");				// Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels"));    // Label
		firstItem.add("freq_code");			// Name of field
		firstItem.add("4");					// Size
		firstItem.add("4");					// Length
		finAr.add(firstItem);				// Add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");				// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels"));   // Label
		secondItem.add("freq_desc");		// Name of field
		secondItem.add("60");				// Size
		secondItem.add("60");				// Length
		finAr.add(secondItem);				// Add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");				// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));		// Label
		thirdItem.add("facility_id");		// Name
		thirdItem.add("2");					// Size
		thirdItem.add("2");					// Length
		finAr.add(thirdItem);				// Add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");				// Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	// Label
		fourthItem.add("facility_name");	// Name
		fourthItem.add("70");				// SIZE
		fourthItem.add("35");				// Length
		finAr.add(fourthItem);				// Add to ArrayList obj finAr

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Frequency.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
		orderByCols[3] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");

		orderByColVals[0] = "freq_code";
		orderByColVals[1] = "freq_desc";
		orderByColVals[2] = "admin_facility_id";
		orderByColVals[3] = "facility_name";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Frequencyt","../../eAM/jsp/ScheduleFrequencyQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		finAr.clear();
	}
	catch (Exception e) 
	{
		//out.println("Exception "+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
