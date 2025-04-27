<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


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
	
		<script language="Javascript" src="../../eOR/js/OrderCatalogProcedureLink.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>-->

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<script language='Javascript'>

function Modify(obj,rowIndex) {

	var	order_catalog_code			=     obj.cells[0].innerText;
	var term_set_code				=     obj.cells[3].innerText;
parent.f_query_add_mod.location.href="../../eOR/jsp/OrderCatalogProcedureLinkAddModify.jsp?order_catalog_code="+order_catalog_code+"&term_set_code="+term_set_code+"&mode=2";

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	//Search Criteria's from Query Criteria page

	String order_catalog_code	= request.getParameter( "order_catalog_code" ).trim() ;
	String order_catalog	= request.getParameter( "order_catalog" ) ;
	String term_set	= request.getParameter( "term_set" ) ;
	String term_set_code	= request.getParameter( "term_set_code" ) ;
	String term_set_desc	= request.getParameter( "term_set_desc" ) ;
//	String ord[]			= request.getParameterValues("orderbycolumns");

	if( order_catalog_code.equals("''")||order_catalog_code.equals("")||order_catalog_code==null ){
							order_catalog_code="";	}

	if(term_set==null|| term_set.equals("")) {
						term_set="";	}

	if(term_set_code==null|| term_set_code.equals(""))   {
						term_set_code="";	}

	if(term_set_desc==null|| term_set_desc.equals("")) {
						term_set_desc="";	}

	if(order_catalog==null|| order_catalog.equals("")) {
				order_catalog="";	}
	

	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
try{
	String classvalue	= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_SQLDATA_N"));

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_catalog_code" );
	displayFields.add( "order_catalog" );
	displayFields.add( "term_set" );
	displayFields.add( "term_set_code" );
	displayFields.add( "term_set_desc" );


	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();

//out.println("<script>alert('order_category="+order_category+"');</script>");
	
	chkFields.add( order_catalog_code+"%" );
	chkFields.add( order_catalog+"%" );
	chkFields.add( term_set +"%");
	chkFields.add( term_set_code +"%");
	chkFields.add( term_set_desc +"%");
	
// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );
	//out.println("<script>alert('displayFields="+displayFields+"')</script>");
	//out.println("<script>alert('chkFields="+chkFields+"')</script>");
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

	//out.println("<script>alert('displayFields="+displayFields+"')</script>");
	if( (result.size()>=0) && ( !( ((String) result.get(0)).equals("0")) ))	{
	%>
		<table cellpadding=1 cellspacing=0 width="100%" align="center">
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

		<td class='COLUMNHEADER'><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="eOR.TermSetCode.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/></td>


	<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++)
			{//start of outer for loop
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr   onClick='Modify(this,"<%=recCount%>");'  >
	<%

			String link_columns = "4";
//out.println("result="+result);
			records=(ArrayList) result.get( recCount );
 //out.println("records="+records);
			

	for(int colCount=0; colCount<records.size(); colCount++)
			{
		
		//start of for loop1
		//out.println("<script>alert('"+link_columns.indexOf(String.valueOf(colCount+1))+"');</script>");
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
	//out.println("records("+colCount+")="+(String)records.get(colCount));%>
		
		
		<td class="<%=classvalue%>"  onclick="disableClick(event);" align='left'><%
					out.println((String)records.get( colCount ));
		

	%></td>
	<%
					}//end of else 1
			}//inner for loop
			%></tr>
	<%
			} //upper for loop
	%>
		</table>
	<%
		out.flush();
	}  // first if end
	else{// start of else
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}//end of else
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/OrderCatalogProcedureLinkQueryResult.jsp", searched) );
	} //end of try
catch(Exception e) {//start of catch
	e.printStackTrace(System.out);
}//end of catch
%>
</body>
</html>

