<!DOCTYPE html>
<%@page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html; charset=	UTF-8"%>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
 <% 
 request.setCharacterEncoding("UTF-8");
 String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
 %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;


try {
	con = ServiceLocator.getInstance().getConnection(request);
 
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	String lib_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryID.label","cp_labels");
	String lib_des=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryDescription.label","cp_labels");
	String case_type_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseTypeCode.label","cp_labels");
	String case_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseTypeDescription.label","cp_labels");
	String find_case_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindCaseType.label","cp_labels");

	firstItem.add("Text");  		 //Type of item
	firstItem.add(case_type_code);	  // label
	firstItem.add("case_type_code");	//name of field
	firstItem.add("10");
	firstItem.add("10"); //size
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(case_type_desc); //label
	secondItem.add("case_type_desc");//name
	secondItem.add("60"); //size
	secondItem.add("60");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(lib_id);  // label
	thirdItem.add("library_id");//name
	thirdItem.add("20"); //size
	thirdItem.add("20");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(lib_des);  // label
	fourthItem.add("short_desc");//name
	fourthItem.add("60"); //size
	fourthItem.add("60");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];
	
	orderByCols[0] = case_type_code;
	orderByCols[1] = case_type_desc;
	orderByCols[2] = lib_id;
	orderByCols[3] = lib_des;

	orderByColVals[0] = "case_type_code";
	orderByColVals[1] = "case_type_desc";
	orderByColVals[2] = "library_id";
	orderByColVals[3] = "short_desc";
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	strbuff = qrypg.getQueryPage(con,finAr,find_case_type, "../jsp/LibraryForCaseTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		ServiceLocator.getInstance().returnConnection(con,request);
	}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

