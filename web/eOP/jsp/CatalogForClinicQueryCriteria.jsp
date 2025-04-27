<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic	
*/ -->

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	
	

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);//(Connection) session.getValue( "connection" );
	
	ArrayList finAr = new ArrayList();
	ArrayList zeroitem = new ArrayList();

	zeroitem.add("List");   //Type of item
	zeroitem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));  // label
	zeroitem.add("locn_type");//name
	zeroitem.add("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(zeroitem); //add to ArrayList obj finAr

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
	firstItem.add("CLINIC_CODE");	//name of field
	firstItem.add("10");	// SIZE
	firstItem.add("10");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));  // label
	secondItem.add("CLINIC_DESC");   //name of field
	secondItem.add("20");	// SIZE
	secondItem.add("20");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList secondItem1=new ArrayList();
	secondItem1.add("List");  //Type of item
	secondItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
	secondItem1.add("ORDER_CATEGORY");  // name
	secondItem1.add("Select Order_Category,Short_Desc  from OR_ORDER_CATEGORY where Order_Category not in ('PH','CS') order by 2");   //name of field
 	finAr.add(secondItem1); //add to ArrayList obj finAr

	ArrayList ThirdItem = new ArrayList();
	ThirdItem.add("Text");  		 //Type of item
	ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));	  // label
	ThirdItem.add("ORDER_CATALOG_CODE");	//name of field
	ThirdItem.add("10");	// SIZE
	ThirdItem.add("10");	//LENGTH
	finAr.add(ThirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem=new ArrayList();
	fourthItem.add("Text");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
	fourthItem.add("ORDER_CATALOG_DESC");   //name of field
	fourthItem.add("20");	// SIZE
	fourthItem.add("20");	//LENGTH
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");


	orderByColVals[0] = "CARE_LOCN_TYPE_IND";
	orderByColVals[1] = "CLINIC_CODE";
	orderByColVals[2] = "CLINC_DESC";
	orderByColVals[3] = "ORDER_CATEGORY";
	orderByColVals[4] = "ORDER_CATALOG_CODE";
	orderByColVals[5] = "ORDER_CATALOG_DESC";


	strbuff = qrypg.getQueryPage(con,finAr,"Statics Group Detail","../../eOP/jsp/CatalogForClinicQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	zeroitem.clear();
	firstItem.clear();
	secondItem.clear();
	secondItem1.clear();
	ThirdItem.clear();
	fourthItem.clear();
	finAr.clear();
	orderByColVals = null;
	orderByCols = null;

} catch (Exception e) {}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>

