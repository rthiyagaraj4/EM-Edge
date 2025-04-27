<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*   File Name		:	TerminologySetForPractitionerTypeQueryCriteria.jsp
*	Purpose 			:	to get the criteria for the Query
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper " %>
   <%String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;
//String orderCatValues = "";

try {
	con = ServiceLocator.getInstance().getConnection(request);
	//HttpSession ss = request.getSession(false);
 
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels"));	  // label
	firstItem.add("term_set_id");	//name of field
	firstItem.add("20");
	firstItem.add("20"); //size
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels")); //label
	secondItem.add("term_set_desc");//name
	secondItem.add("40"); //size
	secondItem.add("60");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));  // label
	thirdItem.add("pract_type");//name
	thirdItem.add("3"); //size
	thirdItem.add("2");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PractitionerTypeDescription.label","common_labels"));  // label
	fourthItem.add("pract_type_desc");//name
	fourthItem.add("20"); //size
	fourthItem.add("15");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PractitionerTypeDescription.label","common_labels");

	orderByColVals[0] = "a.term_set_id";
	orderByColVals[1] = "b.term_set_desc";
	orderByColVals[2] = "a.pract_type";
	orderByColVals[3] = "c.desc_userdef";

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetforPractType.label","mr_labels"),"../jsp/TerminologySetForPractitionerTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( finAr != null )  finAr.clear();

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		ServiceLocator.getInstance().returnConnection(con,request);
	}
%>
