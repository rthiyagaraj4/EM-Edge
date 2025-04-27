<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       	  Edit History  Name        Description
-----------------------------------------------------------------------
?             100         	?            created	
05/07/2012    IN029935      Chowminya G	 Add NPB Request Form in query 								 
-----------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " %> 
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	=  ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String function_id = request.getParameter("function_id");
StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();



ArrayList firstItem=new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentNoteTextID.label","or_labels"));	  // label
firstItem.add("id");	//name of field
firstItem.add("10");	// SIZE
firstItem.add("10");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr
firstItem=null;

ArrayList secondItem = new ArrayList();
secondItem.add("List");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  // label
secondItem.add("consent_type");//name
secondItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsentForm.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PatientInterventions.label","or_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RefusalForm.label","or_labels")+",Z,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReferralForm.label","or_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NPBRequestForm.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted. //IN029935
finAr.add(secondItem); //add to ArrayList obj finAr
secondItem=null;

ArrayList thirdItem= new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
thirdItem.add("Consent_form_label");	//name of field
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr
thirdItem=null;

ArrayList fourthItem = new ArrayList();
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr
fourthItem=null;

ArrayList fifthItem = new ArrayList();
fifthItem.add("Hidden");  //Type of item
fifthItem.add("function_id");  // name of field
fifthItem.add(function_id);   //value of field
finAr.add(fifthItem); //add to ArrayList obj finAr
fifthItem=null;

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");;
orderByCols[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");;

orderByColVals[0] = "consent_form_id";
orderByColVals[1] = "consent_type";
orderByColVals[2] = "Consent_form_label";
strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/ConsentFormatQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
finAr=null;
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

