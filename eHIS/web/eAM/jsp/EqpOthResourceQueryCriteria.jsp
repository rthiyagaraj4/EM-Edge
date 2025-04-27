<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,webbeans.eCommon.ConnectionManager" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try 
	{
request.setCharacterEncoding("UTF-8");
    con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("List");      //  Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));	// label
	firstItem.add("facility_id");  // name of field
	firstItem.add("select facility_id, facility_name from sm_facility_param order by 2");  //static values that need to be displayed. Send it along with the value that is inserted.

	finAr.add(firstItem);	//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");	//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels"));	//label
	secondItem.add("resource_class");  //name of field
	secondItem.add("A,------ "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"------,E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels")+"");//static values that need to be displayed. Send it along with the value that is inserted.

	finAr.add(secondItem);

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels"));	  // label
	thirdItem.add("resource_type");	//name of field
	thirdItem.add("2");	// SIZE
	thirdItem.add("2");	// LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	fourthItem.add("short_desc");	//name of field
	fourthItem.add("30");// SIZE
	fourthItem.add("30");// LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr
	
	ArrayList fifthItem = new ArrayList();

	fifthItem.add("Text");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels"));  // label
	fifthItem.add("resource_id");//name
	fifthItem.add("15");// SIZE
	fifthItem.add("15");// LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("Text");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	sixthItem.add("long_desc");//name
	sixthItem.add("30");// SIZE
	sixthItem.add("30");// LENGTH

	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");   //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	seventhItem.add("eff_status");//name
	seventhItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed. Send it along with the value that is inserted.
	
	finAr.add(seventhItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	/* The order in which the query has to be executed is specified in the following part of code. */
	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	

	orderByColVals[0] = "facility_id";
	orderByColVals[1] = "a.resource_class";
	orderByColVals[2] = "a.resource_type";
	orderByColVals[3] = "b.short_desc";
	orderByColVals[4] = "a.resource_id";
	orderByColVals[5] = "a.long_desc";
	
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Equipment Other Resource  ","../../eAM/jsp/EqpOthResourceQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	finAr.clear();



	} 
	catch (Exception e) {}
	finally   {
		ConnectionManager.returnConnection(con,request);
	}
%>
