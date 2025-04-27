<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>   
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head></html>

<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
String locale=(String)session.getAttribute("LOCALE");


try {
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItemmain = new ArrayList();

firstItemmain.add("List");  		 //Type of item
firstItemmain.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels")); // label
firstItemmain.add("locn_type");	//name of field

firstItemmain.add("Select CARE_LOCN_TYPE_IND, short_desc from am_care_locn_type_lang_vw where sys_user_def_ind='S' and locn_type in ('C','E','Y') and language_id = '"+locale+"' order by short_desc");

finAr.add(firstItemmain);//add to ArrayList obj finAr


ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
firstItem.add("location_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr


ArrayList enhancedItem = new ArrayList();
enhancedItem.add("List");
enhancedItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcetype.label","common_labels"));
enhancedItem.add("resource_type");
enhancedItem.add("'',  ---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---  ,P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels")+" ");
finAr.add(enhancedItem);

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels"));  // label
thirdItem.add("pract_id");//name
thirdItem.add("15");	// SIZE
thirdItem.add("15");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels"));  // label
fourthItem.add("pract_name");//name
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Date");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.BlockDate.label","oa_labels"));  // label
fifthItem.add("block_date");//name
fifthItem.add("10");	// SIZE
fifthItem.add("10");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr




String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.BlockDate.label","oa_labels");

orderByColVals[0] = "CARE_LOCN_TYPE_IND";
orderByColVals[1] = "clinic_code";
orderByColVals[2] = "clinic_name";
orderByColVals[3] = "PRACTITIONER_ID";
orderByColVals[4] = "PRACTITIONER_NAME";
orderByColVals[5] = "block_date";






strbuff = qrypg.getQueryPage(con,finAr,"Find Arrival","../../eOA/jsp/BlockAppointmentQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
firstItemmain.clear();
firstItem.clear();
secondItem.clear();
enhancedItem.clear();
thirdItem.clear();
fifthItem.clear();
fourthItem.clear();

} catch (Exception e) {}
finally { 
ConnectionManager.returnConnection(con,request);
}
%>

