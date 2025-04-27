<!DOCTYPE html>
<%--
	FileName	: queryOpera.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,ecis.utils.*" contentType="text/html;charset=UTF-8" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
CommonQueryPage qrypg = new CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try 
{
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem1 = new ArrayList();

firstItem1.add("Text");  		 //Type of item
firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
firstItem1.add("facility_id");	//name of field
firstItem1.add("2");	// SIZE
firstItem1.add("2");	//LENGTH
finAr.add(firstItem1);//add to ArrayList obj finAr

ArrayList firstItem2 = new ArrayList();

firstItem2.add("Text");  		 //Type of item
firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	  // label
firstItem2.add("facility_name");	//name of field
firstItem2.add("70");	// SIZE
firstItem2.add("35");	//LENGTH
finAr.add(firstItem2);//add to ArrayList obj finAr


ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
firstItem.add("oper_stn_id");	//name of field
firstItem.add("30");	// SIZE
firstItem.add("30");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("short_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));  // label
thirdItem.add("appl_user_id");   //name of field
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));  // label
fourthItem.add("appl_user_name");   //name of field
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();

fifthItem.add("Text");  		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
fifthItem.add("locn_code");	//name of field
fifthItem.add("4");	// SIZE
fifthItem.add("4");	//LENGTH

finAr.add(fifthItem);//add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");  		 //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));	  // label
sixthItem.add("locn_short_desc");	//name of field
sixthItem.add("15");	// SIZE
sixthItem.add("15");	//LENGTH

finAr.add(sixthItem);//add to ArrayList obj finAr

ArrayList fifthItem1 = new ArrayList();

fifthItem1.add("List");  		 //Type of item
fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));	  // label
fifthItem1.add("locn_type");
fifthItem1.add("select  locn_type, short_desc from am_care_locn_type order by short_desc ");	//name of field
finAr.add(fifthItem1);//add to ArrayList obj finAr




String orderByCols[] = new String[9];
String orderByColVals[] = new String[9];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operatorstation.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");


orderByColVals[0] = "facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "oper_stn_id";
orderByColVals[3] = "oper_stn_short_desc";
orderByColVals[4] = "appl_user_id";
orderByColVals[5] = "appl_user_name";
orderByColVals[6] = "locn_code";
orderByColVals[7] = "locn_short_desc";
orderByColVals[8] = "care_locn_type";


strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Operator Station","../../eAM/jsp/OperatorStationRstrnQuery.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));

finAr.clear();
firstItem1.clear();
firstItem2.clear();
firstItem.clear();
secondItem.clear();
//thirdItemaddl.clear();
//fourthItemaddl.clear();
fourthItem.clear();
thirdItem.clear();
sixthItem.clear();
fifthItem.clear();
fifthItem1.clear();
} 
catch (Exception e)
{}

finally{
	ConnectionManager.returnConnection(con,request);
}
%>
