<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<script>
	function Modify(obj){

		var order_cat			= obj.cells[0].innerText;
		var order_type_code		= obj.cells[1].innerText;
		var order_type_desc		= obj.cells[2].innerText;
		var order_catalog_code	= obj.cells[3].innerText;
		var order_catalog_desc	= obj.cells[4].innerText;
		var wait_green			= obj.cells[5].innerText;
		var wait_yellow			= obj.cells[6].innerText;
		var wait_red			= obj.cells[7].innerText;
		var active_stat			= obj.cells[8].children[1].value;
		
		/*alert("order_cat"+order_cat);
		alert("order_type_code"+order_type_code);
		alert("order_catalog_code"+order_catalog_code);
		alert("activestat---"+obj.cells[8].children(1).value);*/

document.location.href="../../eOR/jsp/WaitTimePendingOrdersAddModify.jsp?mode=2&order_cat="+order_cat+"&order_type_code="+order_type_code+"&order_type_desc="+order_type_desc+"&order_catalog_code="+order_catalog_code+"&order_catalog_desc="+order_catalog_desc+"&wait_green="+wait_green+"&wait_yellow="+wait_yellow+"&wait_red="+wait_red+"&active_stat="+active_stat+"&function_id="+parent.function_id  ;


}
</script>

<!--OnMouseDown='CodeArrest()'   -->
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	String classvalue = "";
//	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
//	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;


try{
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085    
	String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
	String order_type			= CommonBean.checkForNull(request.getParameter("order_type_code"));
	String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
	String order_catalog		= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
	String order_catalog_desc	= CommonBean.checkForNull(request.getParameter("order_catalog_desc"));
	String active_stat			= CommonBean.checkForNull(request.getParameter("active_stat"));
	
	boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

	if(order_category != null )		order_category = order_category.trim();
	if(order_type != null )			order_type = order_type;
	if(order_type_desc != null )	order_type_desc = order_type_desc;
	if(order_catalog != null )		order_catalog = order_catalog;
	if(order_catalog_desc != null )	order_catalog_desc = order_catalog_desc;
	if(active_stat != null )		active_stat = active_stat.trim();

	order_type_desc		= order_type_desc .toUpperCase();
	order_catalog_desc  = order_catalog_desc .toUpperCase();

	//Common parameters.
	HashMap sqlMap = new HashMap();


	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_PENDING_RESULT") );
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "ORDER_CATEGORY" );
	displayFields.add( "ORDER_TYPE_CODE" );
	displayFields.add( "ORDER_TYPE_DESC" );
	displayFields.add( "ORDER_CATALOG_CODE" );
	displayFields.add( "ORDER_CATALOG_DESC" );
	displayFields.add( "APPT_WAIT_TIME_GREEN_IND" );
	displayFields.add( "APPT_WAIT_TIME_YELLOW_IND" );
	displayFields.add( "APPT_WAIT_TIME_RED_IND" );
	displayFields.add( "APPT_WAIT_TIME_ACTIVATE_YN" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_category+"%" );
	chkFields.add( order_type+"%" );
	chkFields.add( order_type_desc+"%" );
	chkFields.add( order_catalog+"%" );
	chkFields.add( order_catalog_desc+"%" );
	chkFields.add( active_stat+"%" );
	chkFields.add( order_category+"%" );
	chkFields.add( order_type+"%" );
	chkFields.add( active_stat+"%" );
	chkFields.add( order_category+"%" );
	chkFields.add( active_stat+"%" );


	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
  
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

	<table class='grid' width='100%'>
		<tr>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' colspan='3'><fmt:message key="eOR.WaitingTime.label" bundle="${or_labels}"/></td>
			<td class='COLUMNHEADER' rowspan='2'><fmt:message key="eMP.ActiveStatus.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr>
		
		<td class='COLUMNHEADER'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></td>	
		
	</tr>	
		<%

		//Retriving the records from result arraylist
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

		  //System.err.println("==== records======"+records);

		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				String str=(String)records.get(colCount);
				
			%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=str%></a></td>
			<%
			}else{
				String str = (String)records.get(colCount); 
				if(str==null)
					str = "&nbsp;";
				if(colCount == 8){
					String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
					String disableGif ="<div align='center'><img src='../../eCommon/images/disabled.gif'></img></div>" ;
					str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
				}
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%>
				<input type='hidden' value="<%=(String)records.get(colCount)%>"></td>
			<%
				
			} // end of else
		 }// end of for loop%>

		</tr>
		<%}//loop for all records%>
	</table>
	
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"WaitTimePendingOrdersQueryResult.jsp", searched));

}catch(Exception e ){
	//out.println("here in catch"+e);//common-icn-0181
	e.printStackTrace();
}
%>
</body>
</html>

