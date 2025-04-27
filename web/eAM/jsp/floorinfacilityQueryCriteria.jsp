<!DOCTYPE html>
<%--
	FileName	: floorinfacilityQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try 
	{
		request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);



ArrayList finAr = new ArrayList();

ArrayList firstItem1 = new ArrayList();

firstItem1.add("Text");  		 //Type of item
firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
firstItem1.add("operating_facility_id");	//name of field
firstItem1.add("2");	// SIZE
firstItem1.add("2");	//LENGTH

finAr.add(firstItem1);//add to ArrayList obj finAr

ArrayList firstItem2 = new ArrayList();

firstItem2.add("Text");  		 //Type of item
firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	  // label
firstItem2.add("operating_facility_name");	//name of field
firstItem2.add("70");	// SIZE
firstItem2.add("35");	//LENGTH

finAr.add(firstItem2);//add to ArrayList obj finAr


ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
firstItem.add("bldng_code");	//name of field
firstItem.add("6");	// SIZE
firstItem.add("6");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr



ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");  		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
fifthItem.add("bldng_desc");	//name of field
fifthItem.add("15");	// SIZE
fifthItem.add("15");	//LENGTH

finAr.add(fifthItem);//add to ArrayList obj finAr


ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FloorCode.label","common_labels"));  // label
secondItem.add("floor_code");   //name of field
secondItem.add("6");	// SIZE
secondItem.add("6");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FloorDescription.label","am_labels"));  // label
fourthItem.add("short_desc");   //name of field
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("Nature");//name
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr



String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FloorCode.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FloorDescription.label","am_labels");

orderByColVals[0] = "b.operating_facility_id";
orderByColVals[1] = "c.facility_name";
orderByColVals[2] = "b.bldng_code";
orderByColVals[3] = "a.short_desc";
orderByColVals[4] = "b.floor_code";
orderByColVals[5] = "b.long_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Patient Type","../../eAM/jsp/floorinfacilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


out.println(strbuff.toString());
	
	finAr.clear();
	firstItem.clear();
	firstItem1.clear();
	firstItem2.clear();
	secondItem.clear();
	thirdItem.clear();
	fifthItem.clear();
	fourthItem.clear();
} catch (Exception e) {}
finally{
	ConnectionManager.returnConnection(con,request);
}
%>

