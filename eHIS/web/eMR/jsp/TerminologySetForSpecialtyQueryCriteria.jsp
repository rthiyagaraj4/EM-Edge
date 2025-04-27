<!DOCTYPE html>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 Jan 2005

--%>

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, oracle.jdbc.driver.*" %>
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
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels"));	// label
firstItem.add("term_set_id");	//name of field
firstItem.add("20");			// SIZE
firstItem.add("20");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels"));	 // label
secondItem.add("term_set_desc");	 //name of field
secondItem.add("60");			 // SIZE
secondItem.add("60");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels"));        // label
thirdItem.add("specialty_code");   	 	 //name
thirdItem.add("2");			 // SIZE
thirdItem.add("2");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels"));  	 //label
fourthItem.add("specialty_desc");  	 //name
fourthItem.add("30");		         //SIZE 
fourthItem.add("30");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");

orderByColVals[0] = "term_set_id";
orderByColVals[1] = "term_set_desc";
orderByColVals[2] = "specialty_code";
orderByColVals[3] = "specialty_desc";



strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetforSpecialty.label","mr_labels"),"../jsp/TerminologySetForSpecialtyQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

if ( firstItem != null )  firstItem.clear();
if ( secondItem != null )  secondItem.clear();
if ( thirdItem != null )  thirdItem.clear();
if ( fourthItem != null )  fourthItem.clear();
if ( finAr != null )  finAr.clear();


%>
