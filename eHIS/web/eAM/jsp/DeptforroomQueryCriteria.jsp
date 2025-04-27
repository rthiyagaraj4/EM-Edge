<!DOCTYPE html>
<%--
	FileName	: DeptforroomQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try
	{
		
	con = ConnectionManager.getConnection(request);
	

	ArrayList finAr = new ArrayList();

	ArrayList firstItem1 = new ArrayList();

	firstItem1.add("Text");  		 // Type of item
	firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	 // label
	firstItem1.add("facility_id");	//name of field
	firstItem1.add("2");	// SIZE
	firstItem1.add("2");	// LENGTH

	finAr.add(firstItem1);//add to ArrayList obj finAr

	ArrayList firstItem2 = new ArrayList();

	firstItem2.add("Text");  		 // Type of item
	firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	 // label
	firstItem2.add("facility_name");	//name of field
	firstItem2.add("50");	// SIZE
	firstItem2.add("35");	// LENGTH

	finAr.add(firstItem2);//add to ArrayList obj finAr


	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels"));	 // label
	firstItem.add("room_num");	//name of field
	firstItem.add("10");	// SIZE
	firstItem.add("10");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	
	secondItem.add("Text");  		 // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // label
	secondItem.add("room_short_desc");	//name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	// LENGTH
	
	finAr.add(secondItem);//add to ArrayList obj finAr


	ArrayList ThirdItem = new ArrayList();

	ThirdItem.add("Text");  		 //Type of item
	ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
	ThirdItem.add("dept_code");	//name of field
	ThirdItem.add("10");	// SIZE
	ThirdItem.add("10");	// LENGTH

	finAr.add(ThirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	fourthItem.add("dept_short_desc");	//name of field
	fourthItem.add("15");	// SIZE
	fourthItem.add("15");	// LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr
	
	ArrayList fifthItem = new ArrayList();
	
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));	  // label
	fifthItem.add("service_code");	//name of field
	fifthItem.add("4");	// SIZE
	fifthItem.add("4");	// LENGTH
	
	finAr.add(fifthItem);//add to ArrayList obj finAr
	
	ArrayList sixthItem = new ArrayList();

	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));	  // label
	sixthItem.add("service_short_desc");	//name of field
	sixthItem.add("15");	// SIZE
	sixthItem.add("15");	// LENGTH

	finAr.add(sixthItem);//add to ArrayList obj finAr


	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");

	orderByColVals[0] = "room_num";
	orderByColVals[1] = "room_short_desc";
	orderByColVals[2] = "dept_code";
	orderByColVals[3] = "dept_short_desc";
	orderByColVals[4] = "service_code";
	orderByColVals[5] = "service_short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Facility Dept","../../eAM/jsp/DeptforroomQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	finAr.clear();
	firstItem1.clear();
	firstItem2.clear();
	firstItem.clear();
	secondItem.clear();
	ThirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();

} catch (Exception e) {}

finally{
	ConnectionManager.returnConnection(con,request);
}

%>

