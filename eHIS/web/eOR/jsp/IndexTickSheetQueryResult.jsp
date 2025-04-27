<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eOR/js/IndexTickSheet.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
		<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	td
	{
		FONT-SIZE: 8pt;
	}
</style>
		</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_category		= request.getParameter( "order_category" ).trim() ;
	String tick_sheet_id		= request.getParameter( "tick_sheet_id" ) ;
	String tick_sheet_desc      = request.getParameter( "tick_sheet_desc" ) ;
	String index_type			= request.getParameter( "index_type" ).trim() ;
	String source_type			= request.getParameter( "source_type" ).trim() ;
	String source_code			= request.getParameter( "source_code" ) ;
	String short_desc			= request.getParameter( "short_desc" ) ;
	String practitioner_id		= request.getParameter( "practitioner_id" ) ;
	String practitioner_name	= request.getParameter( "practitioner_name" ) ;
	String service_code			= request.getParameter( "service_code" ) ;
	String service_name			= request.getParameter( "service_name" ) ;

	if(order_category==null || order_category.equals("")){order_category="";}
	if(tick_sheet_id==null || tick_sheet_id.equals("")){tick_sheet_id="";}
	if(tick_sheet_desc==null || tick_sheet_desc.equals("")){tick_sheet_desc="";}
	if(index_type==null || index_type.equals("")){index_type="";}
	if(source_type==null || source_type.equals("")){source_type="";}
	if(source_code==null || source_code.equals("")){source_code="";}
	if(short_desc==null || short_desc.equals("")){short_desc="";}
	if(practitioner_id==null || practitioner_id.equals("")){practitioner_id="";}
	if(practitioner_name==null || practitioner_name.equals("")){practitioner_name="";}
	if(service_code==null || service_code.equals("")){service_code="";}
	if(service_name==null || service_name.equals("")){service_name="";}

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";
	//String bean_id				= "indexticksheet" ;
	//String bean_name			= "eOR.IndexTickSheet";

	/* Initialize Function specific start */
	//IndexTickSheet bean = (IndexTickSheet)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//bean.clear() ;
	/* Initialize Function specific end */

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_TICK_SHEET_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_category_desc" );
	displayFields.add( "tick_sheet_id" );
	displayFields.add( "tick_sheet_desc" );
	displayFields.add( "index_type" );
	displayFields.add( "facility_name" );
	displayFields.add( "source_type" );
	displayFields.add( "source_code" );
	displayFields.add( "short_desc" );
	displayFields.add( "practitioner_id" );
	displayFields.add( "practitioner_name" );
	displayFields.add( "service_code" );
	displayFields.add( "service_name" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_category+"%");
	chkFields.add( tick_sheet_id+"%");
	chkFields.add( tick_sheet_desc+"%");
	chkFields.add( index_type+"%");
	chkFields.add( source_type+"%");
	chkFields.add( practitioner_id+"%");
	chkFields.add( practitioner_name+"%");
	chkFields.add( service_code+"%");
	chkFields.add( service_name+"%");
	chkFields.add( source_code+"%");
	chkFields.add( short_desc+"%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' cellpadding=3 cellspacing=0 width="100%">
		
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="eOR.TickSheetID.label" bundle="${or_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="eOR.TickSheetDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="eOR.SourceCode.label" bundle="${or_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="eOR.SourceDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' align='left' style="color:white"><fmt:message key="eOR.ServiceDesc.label" bundle="${or_labels}"/></th>
  
 
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
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/IndexTickSheetQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>

</body>
</html>


