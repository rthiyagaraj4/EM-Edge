<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Janet George
*	Created On		:	6 Jan 2005

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" %><!--, oracle.jdbc.driver.*-->
<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.criteria.label","common_labels"));	// label
firstItem.add("criteria");	//name of field
firstItem.add("20");			// SIZE
firstItem.add("20");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ListValue.label","mr_labels"));	 // label
secondItem.add("List_value");	 //name of field
secondItem.add("60");			 // SIZE
secondItem.add("60");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassCode.label","common_labels"));        // label
thirdItem.add("patient_class");   	 	 //name
thirdItem.add("2");			 // SIZE
thirdItem.add("2");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassDescription.label","common_labels"));  	 //label
fourthItem.add("patient_class_desc");  	 //name
fourthItem.add("30");		         //SIZE 
fourthItem.add("30");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.criteria.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ListValue.label","mr_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassDescription.label","common_labels");

orderByColVals[0] = "criteria";
orderByColVals[1] = "List_value";
orderByColVals[2] = "patient_class";
orderByColVals[3] = "patient_class_desc";




strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetforFacility.label","mr_labels"),"../jsp/TermSetCritforPatientClassResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

if ( firstItem != null ) firstItem.clear(); 
if ( secondItem != null ) secondItem.clear(); 
if ( thirdItem != null ) thirdItem.clear(); 
if ( fourthItem != null ) fourthItem.clear(); 
if ( finAr != null ) finAr.clear(); 

%>
