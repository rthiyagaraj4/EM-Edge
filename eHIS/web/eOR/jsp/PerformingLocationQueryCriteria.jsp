<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
<%
String bean_id		= "performing_location" ;
String bean_name	= "eOR.PerformingLocation";
//String lb_install	= "N";
String rd_install	= "N";

PerformingLocation bean = (PerformingLocation)getBeanObject( bean_id,  bean_name , request) ;
//lb_install = bean.getLbInstall("RL");
rd_install = bean.getLbInstall("RD");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();



ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationType.label","or_labels"));  // label
firstItem.add("locn_type");//name
//if (!lb_install.equalsIgnoreCase("Y") && !rd_install.equalsIgnoreCase("Y")) {changed on 7/19/2007 for lab_install chk by uma 
if ( !rd_install.equalsIgnoreCase("Y")) {
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,L,Laboratory Site,R,Radiology Wing,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
//} else  if (!lb_install.equalsIgnoreCase("N") && !rd_install.equalsIgnoreCase("Y")) {changed on 7/19/2007 for labinstall check by uma
} else  if ( !rd_install.equalsIgnoreCase("Y")) {  // lab installed
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,R,Radiology Wing,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
//} else  if (!lb_install.equalsIgnoreCase("Y") && !rd_install.equalsIgnoreCase("N")) { changed on 7/19/2007 for labinstall check by uma  // rd installed
} else  if ( !rd_install.equalsIgnoreCase("N")) {  // rd installed
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,L,Laboratory Site,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NonOTRooms.label","or_labels")+"");//IN31901
} else {
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
}
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationCode.label","or_labels"));  // label
secondItem.add("code");//name
secondItem.add("4");
secondItem.add("4");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationDesc.label","or_labels"));  // label
thirdItem.add("long_desc");//name
thirdItem.add("30");
thirdItem.add("30");
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();
fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");   //name of field
fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
fifthItem.add("7");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");


orderByColVals[0] = "performing_deptloc_type";
orderByColVals[1] = "performing_deptloc_code";
orderByColVals[2] = "performing_deptloc_short_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/PerformingLocationQueryResults.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);

} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

<%
	putObjectInBean(bean_id,bean,request);
%>

