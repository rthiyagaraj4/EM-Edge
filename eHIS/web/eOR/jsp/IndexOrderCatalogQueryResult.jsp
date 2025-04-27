<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.* "  %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String service_code			= request.getParameter( "service_code" ) ;
	String service_desc			= request.getParameter( "service_desc" ) ;
	String order_catalog_code   = request.getParameter( "order_catalog_code" ) ;
	String catalog_desc			= request.getParameter( "catalog_desc" ) ;

	if(service_code==null || service_code.equals("")){service_code="";}
	//else  service_code = service_code.toUpperCase();
	if(service_desc==null || service_desc.equals("")){service_desc="";}
	//else  service_desc = service_desc.toUpperCase();
	if(order_catalog_code==null || order_catalog_code.equals("")){order_catalog_code="";}
	//else  order_catalog_code = order_catalog_code.toUpperCase();
	if(catalog_desc==null || catalog_desc.equals("")){catalog_desc="";}
	//else  catalog_desc = catalog_desc.toUpperCase();

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";
	//String bean_id = "indexordercatalogbean" ;
	//String bean_name = "eOR.IndexOrderCatalogBean";

	/* Initialize Function specific start */
	//IndexOrderCatalogBean bean = (IndexOrderCatalogBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//bean.clear() ;
	/* Initialize Function specific end */

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_INDEX_ORDER_CATALOG_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "service_code" );
	displayFields.add( "service_desc" );
	displayFields.add( "order_catalog_code" );
	displayFields.add( "catalog_desc" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( service_code + "%");
	chkFields.add( service_desc + "%");
	chkFields.add( order_catalog_code + "%");
	chkFields.add( catalog_desc + "%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td class='label' nowrap></td>
		<td class='label' nowrap>
	<%
		//For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<td class=" COLUMNHEADER"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
		<td class=" COLUMNHEADER"><fmt:message key="eOR.ServiceDesc.label" bundle="${or_labels}"/></td>
		<td class=" COLUMNHEADER"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
		<td class=" COLUMNHEADER"><fmt:message key="Common.OrderCatalogDescription.label" bundle="${common_labels}"/></td>
		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr>
		<%
		records=(ArrayList) result.get( recCount );
		for(int colCount=0; colCount<records.size(); colCount++){
			%><td class="<%=classvalue%>"  onclick="disableClick(event);">
			<% 	out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
			}
			%>
			</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/IndexOrderCatalogQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
</body>
</html>


