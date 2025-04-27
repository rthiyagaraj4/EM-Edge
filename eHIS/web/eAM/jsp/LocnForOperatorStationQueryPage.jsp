<!DOCTYPE html>
<%--
	FileName	: LocnForOperatorStationQueryPage.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>


<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
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

con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
firstItem.add("facility_id");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	  // label
secondItem.add("facility_name");	//name of field
secondItem.add("70");	// SIZE
secondItem.add("35");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
thirdItem.add("oper_stn_id");	//name of field
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
fourthItem.add("oshort_desc");	//name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");  		 //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
sixthItem.add("locn_code");	//name of field
sixthItem.add("4");	// SIZE
sixthItem.add("4");	//LENGTH

finAr.add(sixthItem);//add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();

seventhItem.add("Text");  		 //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));	  // label
seventhItem.add("short_desc");	//name of field
seventhItem.add("15");	// SIZE
seventhItem.add("15");	//LENGTH

finAr.add(seventhItem);//add to ArrayList obj finAr


ArrayList eightItem = new ArrayList();

eightItem.add("Text");  		 //Type of item
eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
eightItem.add("speciality_code");	//name of field
eightItem.add("4");	// SIZE
eightItem.add("4");	//LENGTH

finAr.add(eightItem);//add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");  		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));	  // label
fifthItem.add("locn_type");
fifthItem.add("select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND in('C','N','E','D')  order by upper(short_desc)");	//name of field
finAr.add(fifthItem);//add to ArrayList obj finAr



String orderByCols[] = new String[7];
String orderByColVals[] = new String[7];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");

orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");

orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");

orderByColVals[0] = "facility_id";
orderByColVals[1] = "facility_name";

orderByColVals[2] = "oper_stn_id";
orderByColVals[3] = "oper_stn_short_desc";
orderByColVals[4] = "care_locn_type";
orderByColVals[5] = "locn_code";
orderByColVals[6] = "locn_short_desc";




strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Location For Operator Station","../../eAM/jsp/LocnForOperatorStationQuery.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	eightItem.clear();
	seventhItem.clear();
	thirdItem.clear();
	fifthItem.clear();
	fourthItem.clear();


} catch (Exception e) {
	//out.println(e);
	e.printStackTrace();	
}

finally{
	ConnectionManager.returnConnection(con,request);
}

%>
