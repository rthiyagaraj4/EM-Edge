<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id	= request.getParameter("function_id") ;
	String bean_id = "Or_ConfigSpecimenLabel" ;
	String bean_name = "eOR.ORConfigSpeciLabelFrmtBean";
/* Mandatory checks end */	

/* Initialize Function specific start */
	ORConfigSpeciLabelFrmtBean configSpecimenLabel = (ORConfigSpeciLabelFrmtBean)getObjectFromBean(bean_id,bean_name,session);	
	configSpecimenLabel.setLanguageId(localeName);
	configSpecimenLabel.clearObject();
	/* Initialize Function specific end */
try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

ArrayList secondItem=new ArrayList();
String facilityString = configSpecimenLabel.getFacilityString();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));  // label
firstItem.add("facility_id");//name
firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+ facilityString);

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
String specNoFrmt = configSpecimenLabel.getSpecFrmtString();

if(specNoFrmt!=null && !specNoFrmt.equals(""))
	specNoFrmt = ","+specNoFrmt;
else
	specNoFrmt = "";

fourthItem.add("List");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNoFormat.label","or_labels"));  // label
fourthItem.add("specimen_frmt_type");//name
//fourthItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+specNoFrmt);
fourthItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---"+specNoFrmt);

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();
seventhItem.add("Hidden");  //Type of item
seventhItem.add("function_id");  // name of field
seventhItem.add(function_id);   //value of field
finAr.add(seventhItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels");
//orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplication.label","or_labels");
orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNoFormat.label","or_labels");

orderByColVals[0] = "FACILITY_ID";
//orderByColVals[1] = "EXT_APPL";
orderByColVals[1] = "SPEC_NUM_FORMAT";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../../eOR/jsp/ORConfigureSpeciLabelQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
} catch (Exception e) {
	//out.println(e.toString());//common-icn-0181
e.printStackTrace();
}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
		putObjectInBean(bean_id,configSpecimenLabel,request);
 
%>

