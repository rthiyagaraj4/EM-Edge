<!DOCTYPE html>
<%--
	FileName	: FacilityDeptQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*, java.util.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%!
	ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem ;
	ArrayList thirdItem;
	ArrayList forthItem;
	ArrayList fifthItem;
%>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try
	{
		request.setCharacterEncoding("UTF-8");
	con=ConnectionManager.getConnection(request);
	
	finAr = new ArrayList();

	firstItem = new ArrayList();
		firstItem.add("Text");  		 // Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	 // label
		firstItem.add("operating_facility_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	// LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	  // label
		secondItem.add("facility_name");	//name of field
		secondItem.add("70");	// SIZE
		secondItem.add("35");	// LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

	thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
		thirdItem.add("dept_code");	//name of field
		thirdItem.add("10");	// SIZE
		thirdItem.add("10");	// LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

	forthItem = new ArrayList();
		forthItem.add("Text");  		 //Type of item
		forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
		forthItem.add("dept_short_desc");	//name of field
		forthItem.add("15");	// SIZE
		forthItem.add("15");	// LENGTH
		finAr.add(forthItem);//add to ArrayList obj finAr

	fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("enabled");//name
	fifthItem.add("B, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "operating_facility_id";
	orderByColVals[1] = "facility_name";
	orderByColVals[2] = "dept_code";
	orderByColVals[3] = "dept_short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Facility Dept","../../eAM/jsp/FacilityDeptQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear() ;
	thirdItem.clear();
	forthItem.clear();
	fifthItem.clear();

	}
	catch (Exception e)
	{}

	finally
	{
		
		ConnectionManager.returnConnection(con,request);
		
	}
%>
