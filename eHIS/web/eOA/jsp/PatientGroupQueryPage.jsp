<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html>
<script src='../../eCommon/js/common.js' language='javascript'></script></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
String locale = (String)session.getAttribute("LOCALE");	


try{
		con = (Connection) session.getValue( "connection" );
	} catch (Exception e) {}


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));
firstItem.add("locationType");//name
firstItem.add(" ,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(firstItem); 

ArrayList secondItem = new ArrayList();
secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));
secondItem.add("location_code");
secondItem.add("4");	// SIZE
secondItem.add("4");//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.GroupId.label","oa_labels"));	  // label
thirdItem.add("group_id");	//name of field
thirdItem.add("5");	// SIZE
thirdItem.add("5");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("Text");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupName.label","common_labels")); // label
fourthItem.add("group_name");	//name of field
fourthItem.add("30");	// SIZE
fourthItem.add("32");	//LENGTH
finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("Text");  		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels"));	  // label
fifthItem.add("patient_id");	//name of field
fifthItem.add("10");	// SIZE
fifthItem.add("10");	//LENGTH
finAr.add(fifthItem);//add to ArrayList obj finAr



String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.GroupId.label","oa_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels");

orderByColVals[0] = "GROUP_ID";
orderByColVals[1] = "GROUP_NAME";
orderByColVals[2] = "LOCN_CODE";
orderByColVals[3] = "PATIENT_ID";




strbuff = qrypg.getQueryPage(con,finAr,"Find PatientGroup","../../eOA/jsp/PatientGroupResultPage.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
//fourthItem.clear();
finAr.clear();

%>

