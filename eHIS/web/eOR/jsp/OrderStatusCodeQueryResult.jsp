<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<script>
	function Modify(obj){
	var order_status_code	= obj.cells[0].innerText;
	var long_desc			= obj.cells[1].innerText;
	var short_desc			= obj.cells[2].innerText;
	var order_status_desc	= obj.cells[3].innerText;
	var count				= obj.rowIndex+1;
	order_status_type 		= eval(document.getElementById("order_status_type"+count)).value;
	document.location.href="../../eOR/jsp/OrderStatusCodeAddModify.jsp?mode=2&order_status_code="+order_status_code+"&long_desc="+escape(long_desc)+"&short_desc="+escape(short_desc)+"&order_status_type="+escape(order_status_type)+"&order_status_desc="+escape(order_status_desc)+"&function_id="+parent.function_id;
}
</script>

<html>
	<head>
		<title></title>
		
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	String sqlQuery = OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_QUERY_RESULT_SELECT");

	String order_status_code	= CommonBean.checkForNull(request.getParameter("order_status_code"));
	String long_desc			= CommonBean.checkForNull(request.getParameter("long_desc"));
	String order_status_type	= CommonBean.checkForNull(request.getParameter("order_status_type"));
	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null?
	false : true  ;

	try
	 {
		String classvalue		= "";

		//Common parameters.
		HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData",sqlQuery);

		//Function Parameters
		HashMap funcMap = new HashMap();

			//Display Fields
			ArrayList displayFields = new ArrayList();

				displayFields.add( "order_status_code" );
				displayFields.add( "long_desc" );
				displayFields.add( "short_desc" );
				displayFields.add( "order_status_desc" );
				displayFields.add( "order_status_type" );


			//Where condition put in order
			ArrayList chkFields = new ArrayList();
				chkFields.add( order_status_code+"%" );
				chkFields.add( long_desc+"%" );
				chkFields.add( order_status_type.trim()+"%" );

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adapter as an arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

		if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class='label'></td>
		<td class='label'>
	<%
		// To display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table class='grid' width="100%">
		<tr>
			<th class='columnheader' width='15%' style="text-align:left;"><fmt:message key="eOR.OrderStatusCode.label" bundle="${or_labels}"/></th>
			<th class='columnheader' width='33%'  style="text-align:left;"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='17%' style="text-align:left;"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='10%' style="text-align:left;"><fmt:message key="eOR.OrderStatusType.label" bundle="${or_labels}"/></th>
		</tr>
	<%
		//Retrieving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
		<tr onClick="Modify(this);" >
	<%

		  String link_columns = "1";
		  records=(ArrayList) result.get( recCount );
		  String str="";
		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			   <td class="<%=classvalue%>" onmouseover="changeCursor(this);">
				 <a class='gridLink' href='#'><%=(String)records.get(colCount)%> </a>
			   </td>
	<%		}else if(colCount == 4) {
					out.println("<input type='hidden' name = 'order_status_type"+recCount+"' id = 'order_status_type"+recCount+"'  value='"+(String)records.get(colCount)+"'>");
			} else {
				str = (String)records.get(colCount);
	%>
    		<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%>
			</td>
			<%}
		 }%>
		</tr>
		<% } %>
	</table>
	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderStatusCodeQueryResult.jsp", searched) );
     } catch(Exception e) {
	     System.out.print("Exception @ Result JSP :"+e.toString());
  }
%>
  </body>
</html>

