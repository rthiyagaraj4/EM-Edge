
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
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eOR/js/ReasonCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var consent_form_id = obj.cells[0].innerText;
		var	eff_status		= obj.cells[3].innerText;
	 	document.location.href="../../eOR/jsp/ConsentFormatAddModify.jsp?mode=2&consent_form_id="+consent_form_id+"&eff_status="+eff_status+"&function_id"+parent.function_id;
	}
	</script>
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%

    String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
    String order_type_code		= CommonBean.checkForNull(request.getParameter("order_type_code"));
    String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
    String format				= CommonBean.checkForNull(request.getParameter("format"));
    String prefix				= CommonBean.checkForNull(request.getParameter("prefix"));

	if(format.equals(" ")) format = "";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	String formatVal[]		={"YY","YJ"} ;
	String formatDesc[]	={"By Year","By Year and Julian Date"} ;

	try{
	String classvalue			= "";

//SELECT  a.order_type_code order_type_code, 	a.order_category ord_category, 	c.short_desc short_desc, NVL(b.short_desc,'All')  order_type_short_desc, 	a.access_num_prefix access_num_prefix, a.access_num_format access_num_format, 	a.next_access_num next_access_num, 	a.default_access_num default_access_num,a.last_num_date_time last_num_date_time  FROM  or_spec_access_num_rule a, or_order_type b,or_order_category c  WHERE 	b.order_type_code(+)  = a.order_type_code AND 	a.order_category=c.order_category AND 	UPPER(a.order_category) LIKE UPPER(?) and b.short_desc LIKE (?) AND UPPER(a.order_type_code) LIKE (?) AND a.access_num_format LIKE (?)  AND a.access_num_prefix LIKE (?)

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_SELECT"));
	String accession_sql=OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_SELECT");
	if(order_type_desc.trim().equalsIgnoreCase("All") || order_type_desc.trim().length()==0)
	{
		accession_sql = accession_sql.replaceAll("&&FILTER##"," or a.order_type_code like ?");
	}
	else
	{
		accession_sql = accession_sql.replaceAll("&&FILTER##","");
	}
	sqlMap.put( "sqlData", accession_sql);
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "short_desc" );
	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_short_desc" );
	displayFields.add( "access_num_prefix" );	
	displayFields.add( "access_num_format" );	
	displayFields.add( "default_access_num" );	
	displayFields.add( "next_access_num" );
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();


	chkFields.add(order_category+"%");
	chkFields.add(order_type_desc+"%");
	if(order_type_desc.trim().equalsIgnoreCase("All") || order_type_desc.trim().length()==0)
	{
		chkFields.add("*ALL%");
	}
	chkFields.add(order_type_code+"%");
	chkFields.add(format+"%");
	chkFields.add(prefix+"%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

//	sqlMap.clear();
//	funcMap.clear();

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

		<table class='grid' width="100%">
		<td class=columnheader width='20%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='20%'><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='20%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
		<td class=columnheader width='25%'><fmt:message key="Common.Format.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="eOR.DefaultNumber.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='15%'><fmt:message key="eOR.NextAccessionNumber.label" bundle="${or_labels}"/></td>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();

		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr >
		<%
		//String link_columns = "1", disp ="";
		records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++){
			String str = (String)records.get(colCount);	
			
			if(colCount == 4)
			str=eHISFormatter.chkReturn(formatVal,str,formatDesc,"&nbsp;");
			/*if(colCount == 4)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 5)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);*/
			
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%

		 }
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script> 
			<%}
		
		out.println(CommonBean.setForm(request ,"AccessionNumberRulesQueryResults.jsp", searched));
//		displayFields.clear();
//		chkFields.clear();
//		result.clear();
//		records.clear();
	}
	catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}	
	%>
	</body>
	</html>

