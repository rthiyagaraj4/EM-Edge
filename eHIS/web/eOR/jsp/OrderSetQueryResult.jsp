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
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%><!--Added for IN068314-->
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--Added for IN068314-->
<%-- Mandatory declarations end --%>

<script>
	function Modify(obj){

		var order_set_code = obj.cells[0].innerText;

		document.location.href="../../eOR/jsp/OrderSetAddModify.jsp?mode=2&order_set_code="+order_set_code+"&function_id="+parent.function_id+"&module_id=OR";
}
</script>


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
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	</head>
<body  onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	
	//Search Criteria's from Query Criteria page
	String order_set_code	= CommonBean.checkForNull(request.getParameter("order_set_code"));
	String long_desc		= CommonBean.checkForNull(request.getParameter("long_desc"));
	String short_desc		= CommonBean.checkForNull(request.getParameter("short_desc"));
	String order_category			= CommonBean.checkForNull(request.getParameter("order_category"));
	String order_type_code			= CommonBean.checkForNull(request.getParameter("order_type_code"));
	String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
	String eff_status			= CommonBean.checkForNull(request.getParameter("eff_status"));


	/* Required while Selecting sql and Formatting display*/
	//String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	//String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;
	//String valSource[]  ={"U","R","P"} ;
	//String descsource[]={"User Id","RelationShip","Responsibilty"} ;



	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null?
	false : true  ;

		//IN068314 Starts
	//String sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_QUERY_CRITERIA");
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, 	request ) ;  
	String fpp_yn =CommonBean.checkForNull(request.getParameter( "fpp_yn" ));
	String sql = 
	"SELECT a.ORDER_CATALOG_CODE,a.LONG_DESC,a.short_desc,a.ORDER_CATEGORY,c.SHORT_DESC order_category_desc , a.ORDER_TYPE_CODE,b.SHORT_DESC order_type_desc, a.eff_status eff_status ##FPP_YN## FROM or_order_catalog a , or_order_type b , or_order_category c WHERE  b.ORDER_TYPE_CODE = a.ORDER_TYPE_CODE AND   c.order_category = a.order_category AND a.ORDER_CATALOG_CODE  LIKE UPPER(?) AND UPPER(a.short_desc)  LIKE UPPER(?) AND UPPER(a.LONG_DESC) LIKE UPPER(?) AND UPPER(a.ORDER_TYPE_CODE)  LIKE UPPER(?) AND UPPER(b.SHORT_DESC)  LIKE UPPER(?) AND UPPER(a.ORDER_CATEGORY) LIKE UPPER(?) and UPPER(a.eff_status) LIKE UPPER(?) AND a.ORDER_CATALOG_NATURE='S' ##FPP_APPLICABLEYN## ";
	//IN068314 Ends

try{
	String classvalue			= "";
	//IN068314 Starts
	if(bean.getIsFPPApplicable())
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
	displayFields.add( "order_category_desc" );
	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_desc" );
	displayFields.add( "eff_status" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();




	chkFields.add( order_set_code.trim() + "%");
	chkFields.add(short_desc.trim()+"%" );
	chkFields.add( long_desc.trim()+"%" );
	chkFields.add( order_type_code.trim()+"%" );
	chkFields.add( order_type_desc.trim()+"%");
	chkFields.add( order_category.trim() +"%");
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
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<td class="COLUMNHEADER" ><fmt:message key="eOR.OrderSetCode.label" bundle="${or_labels}"/></td>
			<td class="COLUMNHEADER" ><fmt:message key="eOR.OrderSetDesc.label" bundle="${or_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
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
			<tr onClick="Modify(this);" >
			<%
			String link_columns = "1";
			records=(ArrayList) result.get( recCount );

			for(int colCount=0; colCount<records.size(); colCount++){

			str = (String)records.get(colCount);
			if(str == null) str = "" ;



			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=str%></a></td>
			<%}else{%>
			<td class="<%=classvalue%>" onclick="disableClick(event);" >
			<% if(colCount == 5)
				{//start of if 3
					if( ((String)records.get(colCount)).equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif' align=center><input type='hidden' value='E'></img>");
				else
						out.println("<img src='../../eCommon/images/disabled.gif' align=center><input type='hidden' value='D'></img>");
				}//end of if 3
				else { %>
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
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderSetQueryResult.jsp", searched));
} catch(Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>

