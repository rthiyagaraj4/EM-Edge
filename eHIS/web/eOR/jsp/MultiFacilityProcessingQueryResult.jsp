<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100				?				?				?           created
03/04/2014	IN048344		NijithaS							     		Alpha-OR-ICN Order Type Code is misspelled  as Order Type Cope 
----------------------------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eOR/js/MultiFacilityProcessing.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<!--<script language="Javascript" src="../../eCommon/js/MultiFacilityProcessing.js"></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	String ordering_facility_id		= request.getParameter( "ordering_facility_id" ) ;
	String order_facility_name	= request.getParameter( "order_facility_name" ) ;
	String order_category			= request.getParameter( "order_category" ).trim() ;
	String order_type_code			= request.getParameter( "order_type_code" ) ;
	String order_type_desc			= request.getParameter( "order_type_desc" ) ;
	String performing_facility_id	= request.getParameter( "performing_facility_id" ) ;
	String performing_facility_name = request.getParameter( "performing_facility_name" );

	String order_catalog_code		= request.getParameter( "order_catalog_code" ) ;
	String order_catalog_desc		= request.getParameter( "order_catalog_desc" ) ;

	if(ordering_facility_id==null || ordering_facility_id.equals("")){ordering_facility_id="";}
	if(order_facility_name==null || order_facility_name.equals("")){order_facility_name="";}
	if(order_category==null || order_category.equals("")){order_category="";}
	if(order_type_code==null || order_type_code.equals("")){order_type_code="";}
	if(order_type_desc==null || order_type_desc.equals("")){order_type_desc="";}
	if(performing_facility_id==null || performing_facility_id.equals("")){performing_facility_id="";}
	if(performing_facility_name==null || performing_facility_name.equals("")){performing_facility_name="";}
	if(order_catalog_code==null || order_catalog_code.equals("")){order_catalog_code="";}
	if(order_catalog_desc==null || order_catalog_desc.equals("")){order_catalog_desc="";}

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";
	//String bean_id				= "multifacilityprocessingbean" ;
	//String bean_name			= "eOR.MultiFacilityProcessingBean";

	/* Initialize Function specific start */
	//MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//bean.clear() ;
	/* Initialize Function specific end */

	/*
	out.println("funcMap:"+funcMap.size());
	out.println("sqlMap:"+sqlMap.size());
	*/

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "ordering_facility_id" );
	displayFields.add( "order_facility_name" );
	displayFields.add( "order_category" );
	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_desc" );
	displayFields.add( "performing_facility_id" );
	displayFields.add( "performing_facility_name" );
	displayFields.add( "order_catalog_code" );
	displayFields.add( "order_catalog_desc" );
	displayFields.add( "source_type" );
	displayFields.add( "source_location" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

	chkFields.add( ordering_facility_id + "%");
	chkFields.add( order_facility_name + "%");
	chkFields.add( order_category + "%");
	chkFields.add( order_type_code + "%");
	chkFields.add( order_type_desc + "%");
	chkFields.add( performing_facility_id + "%");
	chkFields.add( performing_facility_name + "%");
	chkFields.add( order_catalog_code + "%");
	chkFields.add( order_catalog_desc + "%");


	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);


	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="106%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table class='grid' width="100%" border="1">
		<th class="columnheader"><fmt:message key="Common.OrderingFacilityID.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.OrderingFacilityName.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="eOR.OrderTypeCode.label" bundle="${or_labels}"/></th> <!--IN048344--> 
		<th class="columnheader"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.PerformingFacilityID.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.PerformingFacilityName.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></th> 
		<th class="columnheader"><fmt:message key="eOR.SourceLocation.label" bundle="${or_labels}"/></th> 
		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			
		<%
			String link_columns = "1";
		records=(ArrayList) result.get( recCount );
		%>
		<tr onClick='Modify(this,"<%=recCount%>");' >
		<%
		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{  // if loop1
			%>
		<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" >
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
		</td>
	<%
					}// end if loop1
	else{// start  else 1

	%>
	
			<td class="<%=classvalue%>"  onclick="disableClick(event);">
			<% 	out.println((String)records.get(colCount)==null ? "" :(String)records.get(colCount));

			}
		}
			%>
			</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/MultiFacilityProcessingQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
</body>
</html>

