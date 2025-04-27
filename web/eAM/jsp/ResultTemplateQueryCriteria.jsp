<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCAAM
	Purpose 		:	Responsible for generating the query page for search functionality
*	Created By		:	Prashant Bhalsingh
*	Created On		:	23 July 2002
*	Modified On		:	22 Feb	2005
*	Version			:	3
--%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%!	ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
%>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request);

	finAr = new ArrayList();

	firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TemplateID.label","common_labels"));		  // label
		firstItem.add("RESULT_TEMPLATE_ID");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

	 secondItem=new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TemplateName.label","common_labels"));	  // label
		secondItem.add("RESULT_TEMPLATE_NAME");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

	 thirdItem = new ArrayList();
		thirdItem.add("List");   //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		thirdItem.add("eff_status");//name
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(thirdItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TemplateID.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TemplateName.label","common_labels");
	 
	orderByColVals[0] = "RESULT_TEMPLATE_ID";
	orderByColVals[1] = "RESULT_TEMPLATE_NAME";


	strbuff = qrypg.getQueryPage(con,finAr,
	"Find Occupation","../jsp/ResultTemplateQueryCriteriaResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	}
	catch (Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();

		ConnectionManager.returnConnection(con,request);
	}
%>

