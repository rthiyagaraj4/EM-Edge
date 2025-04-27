<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try
{
   // con = (Connection) session.getValue( "connection" );
    con  = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");                  //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));         // label
	firstItem.add("locn_type");         //name of field
	firstItem.add("1");                 // SIZE
	firstItem.add("1");                 //LENGTH

	finAr.add(firstItem);                   //add to ArrayList obj finAr


	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");                 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.LocationTypeDescription.label","op_labels"));   // label
	secondItem.add("locn_type_short_desc");      //name of field
	secondItem.add("15");                   // SIZE
	secondItem.add("15");                   //LENGTH

	finAr.add(secondItem);              //add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");                  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));         // label
	thirdItem.add("locn_code");         //name
	thirdItem.add("4");                 // SIZE
	thirdItem.add("4");                 //LENGTH

	finAr.add(thirdItem);               //add to ArrayList obj finAr


	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");                 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));    // label
	fourthItem.add("locn_short_desc");       //name
	fourthItem.add("15");               // SIZE
	fourthItem.add("15");               //LENGTH

	finAr.add(fourthItem);              //add to ArrayList obj finAr


	ArrayList fifthItem = new ArrayList();

	fifthItem.add("Text");                  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));       // label
	fifthItem.add("practitioner_id");       //name
	fifthItem.add("15");                    // SIZE
	fifthItem.add("15");                    //LENGTH

	finAr.add(fifthItem);               //add to ArrayList obj finAr


	ArrayList sixthItem = new ArrayList();

	sixthItem.add("Text");                  //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));     // label
	sixthItem.add("practitioner_name"); //name
	sixthItem.add("30");                // SIZE
	sixthItem.add("30");                //LENGTH

	finAr.add(sixthItem);               //add to ArrayList obj finAr

	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.LocationTypeDescription.label","op_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");

	orderByColVals[0] = "locn_type";
	orderByColVals[1] = "locn_type_short_desc";
	orderByColVals[2] = "locn_code";
	orderByColVals[3] = "locn_short_desc";
	orderByColVals[4] = "practitioner_id";
	orderByColVals[5] = "practitioner_name";


	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Speciality For Practitioner","../../eOP/jsp/OpqueuenumberingQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString().replace("nowrap",""));

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();

}
catch (Exception e) {}
finally
{
  ConnectionManager.returnConnection(con,request);  
}
%>

