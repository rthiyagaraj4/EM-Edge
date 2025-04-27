<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title></title>
		<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	
	//String bean_id				= "catalogsBySection" ;
	//String bean_name			= "eOR.CatalogsBySection";

//	CatalogsBySection bean = (CatalogsBySection)mh.getBeanObject( bean_id, request, bean_name ) ;
		
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//Search Criteria's from Query Criteria page
	String tick_sheet_id	= CommonBean.checkForNull(request.getParameter("tick_sheet_id"));
	String tick_sheet_desc		= CommonBean.checkForNull(request.getParameter("tick_sheet_desc"));
	String order_category			= CommonBean.checkForNull(request.getParameter("order_category"));
	String section_code			= CommonBean.checkForNull(request.getParameter("section_code"));
	String section_desc 		= CommonBean.checkForNull(request.getParameter("section_desc"));
	String order_catalog_code	= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
	String order_catalog_desc=
	CommonBean.checkForNull(request.getParameter("order_catalog_desc"));
	String order_type_code	= CommonBean.checkForNull(request.getParameter("order_type_code"));
	String order_type_desc=
	CommonBean.checkForNull(request.getParameter("order_type_desc"));
//	out.println("<script>alert('order_category="+order_category+"');</script>");	
//	String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null? 
	false : true  ;
	
	 String sql = OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_QUERYCRITERIA");	

	if(tick_sheet_id != null || (!(tick_sheet_id.trim()).equals("")))
		tick_sheet_id = tick_sheet_id.toUpperCase();

	if(section_code != null || (!(section_code.trim()).equals("")))
		section_code = section_code.toUpperCase();
	
	if(order_type_code != null || (!(order_type_code.trim()).equals("")))
		order_type_code = order_type_code.toUpperCase();

	if(order_catalog_code != null || (!(order_catalog_code.trim()).equals("")))
		order_catalog_code = order_catalog_code.toUpperCase();

	if(order_category != null && ((order_category.trim()).equals("")))
		order_category = order_category+"%";
try{
	String classvalue			= "";
	
	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql);

	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "ORDEr_CATEGORY_DESC" );
	displayFields.add( "TICK_SHEET_ID" );
	displayFields.add( "TICK_SHEET_DESC" );
	displayFields.add( "SECTION_CODE" );
	displayFields.add( "SECTION_DESC" );
	displayFields.add( "ORDER_CATALOG_CODE" );
	displayFields.add( "ORDER_CATALOG_DESC" );
	displayFields.add( "ORDER_TYPE_CODE" );
	displayFields.add( "ORDER_TYPE_DESC" );

//	displayFields.add( "ORDER_CATEGORY" );
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	
	chkFields.add( tick_sheet_id+"%" );
	chkFields.add( order_category );
	chkFields.add( section_code+"%" );
	chkFields.add( order_type_code+"%" );
	chkFields.add( order_catalog_code+"%");
	chkFields.add( order_catalog_desc +"%");
	chkFields.add( order_type_desc+"%" );
	chkFields.add( section_desc+"%" );
	chkFields.add( tick_sheet_desc+"%");
	//Union
	chkFields.add( order_category );
	chkFields.add( tick_sheet_id+"%" );
	chkFields.add( section_code+"%" );
	chkFields.add( order_type_code+"%" );
	chkFields.add( order_catalog_code+"%");
	chkFields.add( order_catalog_desc+"%" );
	chkFields.add( order_type_desc+"%" );
	chkFields.add( section_desc+"%" );
	chkFields.add( tick_sheet_desc+"%");

/*

	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	//Union
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");

*/
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
//System.out.println("####sqlMap="+sqlMap);
//System.out.println("####displayFields="+displayFields);
//System.out.println("####chkFields="+chkFields);
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

//	sqlMap.clear();
//  funcMap.clear();
//System.out.println("###result.size()="+result.size());
//System.out.println("###result="+result);
//System.out.println("###result.get(0)="+(String)result.get(0));
	
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th class='columnheader'  style="text-align:left;"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='15%'  style="text-align:left;"><fmt:message key="eOR.TickSheetID.label" bundle="${or_labels}"/></th>
		<th class='columnheader'  style="text-align:left;"><fmt:message key="eOR.TickSheetDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader'  style="text-align:left;"><fmt:message key="Common.SectionCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="eOR.SectionDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader'  style="text-align:left;"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader'  style="text-align:left;"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></th>
		<th class='columnheader'  style="text-align:left;"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String str = "";
		for(int recCount=2; recCount<result.size(); recCount++){
			if ( recCount % 2 == 0 )
			classvalue = "gridData" ;
			else
			classvalue = "gridData" ;
		%>
			<tr>
			<%
			//String link_columns = "";
			records=(ArrayList) result.get( recCount );
			  //System.out.println("####recCount="+recCount);
			  //System.out.println("####records="+records);
			for(int colCount=0; colCount<records.size(); colCount++){
			 str = (String)records.get(colCount);	
%>
			<td class="<%=classvalue%>" onclick="disableClick(event);" nowrap><%=str%></td>
			<%}%>
		   
			</tr>
		<%}%>
	</table>
	<%
//			displayFields.clear();
//			chkFields.clear();
//			result.clear();
//			records.clear();
			out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}

	out.println(CommonBean.setForm(request ,"../../eOR/jsp/CatalogBySectionQueryResult.jsp", searched));
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

