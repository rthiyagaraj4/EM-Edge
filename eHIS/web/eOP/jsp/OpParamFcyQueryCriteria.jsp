<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
    
	con = ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));    // label
	firstItem.add("operating_facility_id"); //name of field
	firstItem.add("2"); // SIZE
	firstItem.add("2"); //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));     // label
	secondItem.add("facility_name");    //name of field
	secondItem.add("70");   // SIZE
	secondItem.add("35");   //LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));   // label
	thirdItem.add("service_code");  //name of field
	thirdItem.add("4"); // SIZE
	thirdItem.add("4"); //LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");          //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));      // label
	fourthItem.add("service_short_desc");   //name of field
	fourthItem.add("15");   // SIZE
	fourthItem.add("15");   //LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr
	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");

	orderByColVals[0] = "operating_facility_id";
	orderByColVals[1] = "facility_name";
	orderByColVals[2] = "service_code";
	orderByColVals[3] = "service_short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find OP Parameter For Facility","../../eOP/jsp/OpParamFcyQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();

	} catch (Exception e) {}
	finally
	{
	  ConnectionManager.returnConnection(con,request); 
	}
%>
