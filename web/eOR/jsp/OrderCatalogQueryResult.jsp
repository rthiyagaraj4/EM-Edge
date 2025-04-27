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
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
08/01/2020	IN068314		Nijitha S     	08/01/2020		Ramesh G		ML-MMOH-CRF-1229
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>



<script>
	function Modify(obj,module_id){

		var order_catalog_code = obj.cells[0].innerText;
		//var module_id		   = document.forms[0].module_id.value;
		var order_category = obj.cells[2].children[0].value;
		if(module_id==null || module_id=="") module_id="OR";

		document.location.href="../../eOR/jsp/OrderCatalogAddModify.jsp?mode=2&order_catalog_code="+order_catalog_code+"&order_category="+order_category+"&function_id="+parent.function_id+"&module_id="+module_id;
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
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"   >
<%
//onMouseDown="CodeArrest()"  onKeyDown="lockKey()"
	//Search Criteria's from Query Criteria page
	
	String order_catalog_code	= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
	String long_desc		= CommonBean.checkForNull(request.getParameter("long_desc"));
	String short_desc		= CommonBean.checkForNull(request.getParameter("short_desc"));
	String order_category			= CommonBean.checkForNull(request.getParameter("order_category"));
	String order_type_code			= CommonBean.checkForNull(request.getParameter("order_type_code"));
	//String activity_type		= CommonBean.checkForNull(request.getParameter("activity_type"));
	//String activity_type_desc			= CommonBean.checkForNull(request.getParameter("activity_type_desc"));
	String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
	String catalog_synonym_type		= CommonBean.checkForNull(request.getParameter("catalog_synonym_type"));
	//out.println("<script>alert('catalog_synonym_type="+catalog_synonym_type+"');</script>");
	String catalog_synonym		= CommonBean.checkForNull(request.getParameter("catalog_synonym"));
	//out.println("<script>alert('catalog_synonym="+catalog_synonym+"');</script>");
	String eff_status	=	CommonBean.checkForNull(request.getParameter("eff_status"));
    String module_id	= CommonBean.checkForNull(request.getParameter("module_id"));
	/* Required while Selecting sql and Formatting display*/
//	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
//	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;
//	String valSource[]  ={"U","R","P"} ;
//	String descsource[]={"User Id","RelationShip","Responsibilty"} ;



//	String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null?
	false : true  ;

	//IN068314 Starts
	 String fpp_yn = CommonBean.checkForNull(request.getParameter( "fpp_yn" ));
	 String fppApplicableyn			= request.getParameter( "fppApplicableyn" );
	 //String sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_QUERY_CRITERIA_NEW");
	 String sql =  "SELECT a.ORDER_CATALOG_CODE,a.LONG_DESC, a.short_desc,a.ORDER_CATEGORY, c.SHORT_DESC order_category_desc , a.ORDER_TYPE_CODE,b.SHORT_DESC order_type_desc,d.catalog_synonym catalog_synonym, a.eff_status eff_status ##FPP_YN## FROM or_order_catalog a , or_order_type b , or_order_category c, or_order_Catalog_synonym d WHERE b.ORDER_TYPE_CODE= a.ORDER_TYPE_CODE AND c.order_category= a.order_category and a.order_catalog_code = d.order_catalog_code AND UPPER(a.ORDER_CATALOG_CODE) LIKE UPPER(?) AND UPPER(a.short_desc) LIKE UPPER(?) AND UPPER(a.LONG_DESC) LIKE UPPER(?) AND UPPER(a.ORDER_TYPE_CODE) LIKE UPPER(?) AND UPPER(b.SHORT_DESC) LIKE UPPER(?) AND UPPER(a.ORDER_CATEGORY) LIKE UPPER(?) and d.catalog_synonym_type like ? and upper(d.catalog_synonym) like upper(?) and a.eff_status LIKE UPPER(?) and order_catalog_nature in ('A','P') ##FPP_APPLICABLEYN##";
	//IN068314 Ends



try{
	String classvalue			= "";
	
	//IN068314 Starts
	if("Y".equals(fppApplicableyn))
	{
		sql=sql.replace("##FPP_YN##"," , a.fpp_yn ");
		if("on".equals(fpp_yn))
			sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
		else
			sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
	}
	else
	{
		sql=sql.replace("##FPP_YN##","  ");
		sql=sql.replace("##FPP_APPLICABLEYN##","");
	}
	//IN068314 Ends
	
	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql);


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();



	displayFields.add( "order_catalog_code" );
	displayFields.add( "short_desc" );
	displayFields.add( "order_category" );
	displayFields.add( "order_category_desc" );
	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_desc" );
	displayFields.add( "catalog_synonym" );
	//displayFields.add( "activity_type" );
	//displayFields.add( "activity_type_desc" );
	displayFields.add( "eff_status" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();



/*	out.println("short_desc="+short_desc);
	out.println("long_desc="+long_desc);
	out.println("order_type_code="+order_type_code);
	out.println("order_type_desc="+order_type_desc);
	out.println("order_category="+order_category);
*/


//	out.println("order_category="+order_category.trim());
//	out.println("<table><tr><td align=left>"+order_category.trim() + "</td></tr></table>");

	chkFields.add( order_catalog_code + "%");
	chkFields.add( short_desc+"%" );
	chkFields.add( long_desc+"%" );
	chkFields.add( order_type_code+"%" );
	chkFields.add( order_type_desc+"%");
	chkFields.add( order_category.trim() +"%");
	chkFields.add( catalog_synonym_type.trim() +"%");
	chkFields.add( catalog_synonym.trim() +"%");
	chkFields.add( eff_status.trim() +"%");

/*	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%");
*/


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
		<td class=label  align="right">
	<%
		// For display the previous/next link
	     out.println(result.get(1));
		//System.out.println("result.get(1)     :    "+result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></th>
		<th><fmt:message key="eOR.CatalogSynonym.label" bundle="${or_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
			<tr onClick='Modify(this,"<%=module_id%>");' >
			<%
			String link_columns = "1";
			records=(ArrayList) result.get( recCount );

			for(int colCount=0; colCount<records.size(); colCount++){

			str = (String)records.get(colCount);
			if(str == null) str = "&nbsp;" ;



			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=str%></a></td>
			<%}else{%>
			<%  if(colCount == 2){%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" style='display:none'>
						<INPUT TYPE="hidden" value=<%=(String)records.get(colCount)%>></td>
					<%continue ;
			}else if(colCount == 7){%>
			<td class="<%=classvalue%>" align='center' onclick="disableClick(event);" nowrap>
			 <%	if( ((String)records.get(colCount)).equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif'><input type='hidden' value='E'></img>");
				else
						out.println("<img src='../../eCommon/images/disabled.gif'><input type='hidden' value='D'></img>");
				}//end of if 3
				else { %>
				<td class="<%=classvalue%>" onclick="disableClick(event);" nowrap>
				<%=str%></td>
			<%}%>

			<%}}%>
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
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderCatalogQueryResult.jsp", searched));
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

