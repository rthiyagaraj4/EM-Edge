<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
 <%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head>
		<title></title>
		<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language='javascript' src='../js/OrderTypesForOrderable.js'></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	try{
	String order_type_code			= request.getParameter( "order_type_code" ).trim() ;
	String order_desc				= request.getParameter( "order_desc" ).trim() ;
	String order_catalog_code		= request.getParameter( "order_catalog_code" ).trim() ;
	String catalog_desc				= request.getParameter( "catalog_desc" ).trim() ;

	if(order_type_code==null || order_type_code.equals("")){order_type_code="";}
	if(order_desc==null || order_desc.equals("")){order_desc="";}
	if(order_catalog_code==null || order_catalog_code.equals("")){order_catalog_code="";}
	if(catalog_desc==null || catalog_desc.equals("")){catalog_desc="";}

	order_type_code = order_type_code.toUpperCase();
	order_catalog_code = order_catalog_code.toUpperCase();

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;


	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_ORDER_TYPES_ORDERABLE_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_type_code" );
	displayFields.add( "order_desc" );
	displayFields.add( "order_catalog_code" );
	displayFields.add( "catalog_desc" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_type_code + "%" );
	chkFields.add( order_desc + "%" );
	chkFields.add( order_catalog_code + "%" );
	chkFields.add( catalog_desc + "%" );

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th>Order Type Code</th>
		<th>Order Type Description</th>
		<th>Order Catalog Code</th>
		<th>Order Catalog Description</th>
		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
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
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderTypesForOrderableQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
</body>
</html>


