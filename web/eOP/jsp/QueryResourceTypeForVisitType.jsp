<!DOCTYPE html>


<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {

	con  =  ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels"));     // label
	firstItem.add("visit_type_code");   //name of field
	firstItem.add("2"); // SIZE
	firstItem.add("2"); //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels"));
	secondItem.add("short_desc");
	secondItem.add("15");
	secondItem.add("15");

	finAr.add(secondItem);

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");          //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels"));    // label
	thirdItem.add("resource_class");    //name of field
	thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels"));
	
	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels"));  // label
	fourthItem.add("resource_type");//name
	fourthItem.add("2");
	fourthItem.add("2");
	finAr.add(fourthItem); //add to ArrayList obj finAr


	ArrayList fifthItem = new ArrayList();

	fifthItem.add("Text");          //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));    // label
	fifthItem.add("resource_short_desc");    //name of field
	fifthItem.add("15");   // SIZE
	fifthItem.add("15");   //LENGTH

	finAr.add(fifthItem);//add to ArrayList obj finAr

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels");
	orderByCols[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels");
	orderByCols[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels");
	orderByColVals[0] = "visit_type_code";
	orderByColVals[1]="resource_class";
	orderByColVals[2]="resource_type";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Resource Type For VisitType","../../eOP/jsp/QueryResourceTypeResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	finAr.clear();
	orderByCols = null;
	orderByColVals = null;
} catch (Exception e) {}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>



