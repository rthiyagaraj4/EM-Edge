<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" %>
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
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj,recordCount){
		var	resp_id	= obj.cells[0].innerText.trim();
		var pract_id = obj.cells[2].innerText.trim();
		//var order_category = obj.cells[4].innerText;
		var order_category = eval("document.getElementById('ord_cat_')"+recordCount).value
		//alert("../../eOR/jsp/UserForReportingAddModify.jsp?mode=2&resp_id="+resp_id+"&pract_id="+pract_id+"&function_id="+parent.function_id)
		document.location.href="../../eOR/jsp/UserForReportingAddModify.jsp?mode=2&resp_id="+resp_id+"&pract_id="+pract_id+"&function_id="+parent.function_id+"&order_category="+order_category;
	}
	</script>
</head>
 <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
 <%

    //String function_id = request.getParameter("function_id");

	String resp_id			= CommonBean.checkForNull(request.getParameter("resp_id").trim());
	String resp_name		= CommonBean.checkForNull(request.getParameter("resp_name").trim());
	String pract_id			= CommonBean.checkForNull(request.getParameter("pract_id").trim());
	String practitioner_name= CommonBean.checkForNull(request.getParameter("practitioner_name").trim());
	String order_category	= CommonBean.checkForNull(request.getParameter("order_category").trim());
	String order_type_code	= CommonBean.checkForNull(request.getParameter("order_type_code").trim());
	String privilege		= CommonBean.checkForNull(request.getParameter("privilege").trim());
	//String security			= CommonBean.checkForNull(request.getParameter("security"));

    /*String resp_name		= request.getParameter("resp_name").trim();
	String pract_name		= request.getParameter("pract_name").trim();
	String order_type_desc	= request.getParameter("order_type_desc").trim();
	*/

	if(resp_id == null){ resp_id = "";  }else{resp_id = resp_id.toUpperCase(); }
	if(resp_name == null){ resp_name = "";  }
	if(pract_id == null){pract_id = "";	}else{pract_id = pract_id.toUpperCase();}
	if(practitioner_name == null){practitioner_name = "";	}
	if(order_category == null){order_category = "";}
	if(order_type_code	== null){ order_type_code="";}
	if(privilege == null){privilege = "";}
	///if(security == null){security = "";}
	/*
	if(resp_name == null){resp_name = "";}
	if(pract_name == null){pract_name = "";}
	if(order_type_desc == null){order_type_desc = "";}
	*/

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "resp_id" );
	displayFields.add( "resp_name" );
	displayFields.add( "practitioner_id" );
	displayFields.add( "practitioner_name" );
	displayFields.add("ord_category");
	displayFields.add( "short_desc" );
	displayFields.add( "ord_typ_code" );
	displayFields.add( "order_type_short_desc" );
	displayFields.add( "user_category" );
	//displayFields.add( "security_level" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( pract_id + "%");
	chkFields.add( practitioner_name + "%");
	chkFields.add( resp_name + "%");
	chkFields.add( resp_id + "%");
	chkFields.add( order_category + "%");
	chkFields.add( order_type_code + "%");
	chkFields.add( privilege + "%");
	//chkFields.add( security + "%");

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
		</td>
	</tr>
	</table>
	<table class='grid' width="100%">
		<td class=' COLUMNHEADER'><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
		<td class=' COLUMNHEADER'><fmt:message key="eOR.Privilege.label" bundle="${or_labels}"/></td>
		<!-- <th>Security Level</th> -->
		<%
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
		<tr onClick="Modify(this,<%=recCount%>);" >
		<%
		String link_columns = "1,3", disp="";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if (colCount != 4) {
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					if((String)records.get(colCount) != null){
					%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><a class='gridLink' href='#'><%=(String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount)%></a></td>
					<% }else{
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" ><%=(String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount)%></td>
					<%
					}%>
			<%}else{%>
				<td class="<%=classvalue%>"  onclick="disableClick(event);">
				<%
					disp = (String)records.get(colCount);
					if(disp == null || disp.equals("null") || disp.equals("")) disp="&nbsp;";
					out.println(disp);
				%></td>
			<%}

		}
	}
	%>
		</tr>
		<Input type='hidden' name='ord_cat_<%=recCount%>' id='ord_cat_<%=recCount%>' value='<%=(String)records.get(4)%>'>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/UserForReportingQueryResult.jsp", searched));
	}
	catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
	</body>
	</html>

