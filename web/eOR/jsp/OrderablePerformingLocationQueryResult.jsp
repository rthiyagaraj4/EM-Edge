<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "  contentType="text/html; charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--	<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<% String locale = ((String)session.getAttribute("LOCALE")); %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String bean_id				= "orderablePerformingLocation";
	//String bean_name			= "eOR.OrderablePerformingLocationBean";

//	OrderablePerformingLocationBean bean = (OrderablePerformingLocationBean)mh.getBeanObject( bean_id, request, bean_name ) ;


	//Search Criteria's from Query Criteria page
	String performing_facility_id = CommonBean.checkForNull(request.getParameter("performing_facility_id"));
	String location_code		= CommonBean.checkForNull(request.getParameter("location_code"));
	String location_desc		= CommonBean.checkForNull(request.getParameter("location_desc"));
	String location_type		= CommonBean.checkForNull(request.getParameter("location_type"));
	String order_type_code		= CommonBean.checkForNull(request.getParameter("order_type_code"));
	String order_type_desc 		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
	String order_catalog_code	= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
	String order_catalog_desc=
	CommonBean.checkForNull(request.getParameter("order_catalog_desc"));

	//System.err.println("@@@@@@@@@@@@@@@  performing_facility_id " + performing_facility_id);
	//System.err.println("@@@@@@@@@@@@@@@  location_code " + location_code);
	//System.err.println("@@@@@@@@@@@@@@@  location_desc " + location_desc);
	//System.err.println("@@@@@@@@@@@@@@@  location_type " + location_type);
	//System.err.println("@@@@@@@@@@@@@@@  order_type_code " + order_type_code);
	//System.err.println("@@@@@@@@@@@@@@@  order_type_desc " + order_type_desc);
	//System.err.println("@@@@@@@@@@@@@@@  order_catalog_code " + order_catalog_code);
	//System.err.println("@@@@@@@@@@@@@@@  order_catalog_desc " + order_catalog_desc);


	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null?
	false : true  ;
	 //To be changed accordingly
	 //String sql = OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_QUERYCRITERIA");
	 //String sql = "select a.PERFORMING_DEPTLOC_CODE location_code,b.PERFORMING_DEPTLOC_SHORT_DESC location_desc,a.ORDER_TYPE_CODE order_type,c.SHORT_DESC order_type_desc,a.ORDER_CATALOG_CODE order_catalog_code,d.short_desc order_catalog_desc from or_orderables_for_deptloc a,OR_PERFORMING_DEPTLOC b,OR_ORDER_TYPE c,OR_ORDER_CATALOG d where a. PERFORMING_FACILITY_ID='GW' and b.PERFORMING_DEPTLOC_CODE=a.PERFORMING_DEPTLOC_CODE and c.ORDER_TYPE_CODE=a.ORDER_TYPE_CODE and d.ORDER_CATALOG_CODE=a.ORDER_CATALOG_CODE";

	//Modified by Subhash.Y on 21st June 2004...
	//Start

	 //String sql = "select a.PERFORMING_DEPTLOC_TYPE location_type,a.PERFORMING_DEPTLOC_CODE location_code,b.PERFORMING_DEPTLOC_SHORT_DESC location_desc,a.ORDER_TYPE_CODE order_type,c.SHORT_DESC order_type_desc,a.ORDER_CATALOG_CODE order_catalog_code,d.short_desc order_catalog_desc from or_orderables_for_deptloc a,OR_PERFORMING_DEPTLOC b,OR_ORDER_TYPE c,OR_ORDER_CATALOG d where a.PERFORMING_FACILITY_ID='GW' and b.PERFORMING_DEPTLOC_CODE=a.PERFORMING_DEPTLOC_CODE and c.ORDER_TYPE_CODE=a.ORDER_TYPE_CODE and d.ORDER_CATALOG_CODE=a.ORDER_CATALOG_CODE and a.performing_facility_id like (?) and a.performing_deptloc_type like (?) and a.performing_deptloc_code like (?) and b.performing_deptloc_short_desc like (?) and a.order_type_code like (?) and c.short_desc like (?) and a.order_catalog_code like (?) and d.short_desc like (?)";

	String sql = "select a.PERFORMING_DEPTLOC_TYPE location_type,a.PERFORMING_DEPTLOC_CODE location_code,b.PERFORMING_DEPTLOC_SHORT_DESC location_desc,a.ORDER_TYPE_CODE order_type,c.SHORT_DESC order_type_desc,a.ORDER_CATALOG_CODE order_catalog_code,d.short_desc order_catalog_desc from or_orderables_for_deptloc a,OR_PERFORMING_DEPTLOC b,OR_ORDER_TYPE c,OR_ORDER_CATALOG d where b.PERFORMING_DEPTLOC_CODE=a.PERFORMING_DEPTLOC_CODE and c.ORDER_TYPE_CODE=a.ORDER_TYPE_CODE and d.ORDER_CATALOG_CODE=a.ORDER_CATALOG_CODE and a.performing_facility_id like (?) and a.performing_deptloc_type like (?) and a.performing_deptloc_code like (?) and b.performing_deptloc_short_desc like (?) and a.order_type_code like (?) and c.short_desc like (?) and a.order_catalog_code like (?) and d.short_desc like (?)";

	//End

	 //End of Changes

    if(location_type != null || (!(location_type.trim()).equals("")))
		location_type = location_type.toUpperCase();

	if(location_code != null || (!(location_code.trim()).equals("")))
		location_code = location_code.toUpperCase();

	if(order_type_code != null || (!(order_type_code.trim()).equals("")))
		order_type_code = order_type_code.toUpperCase();


	if(order_catalog_code != null || (!(order_catalog_code.trim()).equals("")))
		order_catalog_code = order_catalog_code.toUpperCase();

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
	//To be changed accordingly with the query
	displayFields.add("location_type");
	displayFields.add("location_code");
	displayFields.add("location_desc");
	displayFields.add("order_type");
	displayFields.add("order_type_desc");
	displayFields.add("order_catalog_code");
	displayFields.add("order_catalog_desc");

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

	chkFields.add(performing_facility_id+"%");
	chkFields.add(location_type+"%");
	chkFields.add(location_code+"%");
	chkFields.add(location_desc+"%");
	chkFields.add(order_type_code+"%");
	chkFields.add(order_type_desc+"%");
	chkFields.add(order_catalog_code+"%");
	chkFields.add(order_catalog_desc+"%");
	//End of changes

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

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
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
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

			for(int colCount=0; colCount<records.size(); colCount++){
				if (records.get(colCount) == null) str = "&nbsp;";
				else if (colCount == 0) {
					if (((String)records.get(colCount)).equalsIgnoreCase("I")) str		= "Departmental Diagnostics";
					else if (((String)records.get(colCount)).equalsIgnoreCase("L")) str = "Laboratory Site";
					else if (((String)records.get(colCount)).equalsIgnoreCase("R")) str = "Radialogy Wing";
					else if (((String)records.get(colCount)).equalsIgnoreCase("T")) str = "Treatment Location";
					else if (((String)records.get(colCount)).equals("M")) str			= "Miscellaneous Service";
					else if (((String)records.get(colCount)).equals("P")) str 			= "Patient Care";
					else if (((String)records.get(colCount)).equals("O")) str 			= "Non OT Rooms"; //IN31901
				} else str = (String)records.get(colCount);
			 //str = (String)records.get(colCount);
%>
			<td class="<%=classvalue%>" onclick="disableClick(event);" nowrap><%=str%></td>
			<%}%>

			</tr>
		<%}%>
	</table>
	<%
			out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderablePerformingLocationQueryResult.jsp", searched));
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">
</body>
</html>

