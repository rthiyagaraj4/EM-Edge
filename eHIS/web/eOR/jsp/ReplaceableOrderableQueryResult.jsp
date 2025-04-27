<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReplaceableOrderableQueryResult.jsp -->


<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

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

		<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>-->
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	</head>

<script language='Javascript'>

function Modify(obj,rowIndex) {

	var order_catalog_code	=     obj.cells[0].innerText;
	var	catalog_desc		=     obj.cells[1].innerText;
	var order_catalog_code_repl			=     obj.cells[2].innerText;
	var order_catalog_code_repl_desc	=     obj.cells[3].innerText;


/* parent.f_query_add_mod.location.href="../../eOR/jsp/ReplaceableOrderableUpdate.jsp?order_catalog_code="+"&order_catalog_code="+order_catalog_code+"&order_catalog_code_repl="+order_catalog_code_repl+"&mode=2";
*/

parent.f_query_add_mod.location.href="../../eOR/jsp/ReplaceableOrderableUpdate.jsp?catalog_desc="+catalog_desc+"&order_catalog_code_repl_desc="+order_catalog_code_repl_desc+"&order_catalog_code="+order_catalog_code+"&order_catalog_code_repl="+order_catalog_code_repl+"&mode=2";

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	String order_catalog_code	= request.getParameter( "order_catalog_code" ).trim() ;
	String catalog_desc	= request.getParameter( "catalog_desc" ) ;
	String order_catalog_code_repl   = request.getParameter( "order_catalog_code_repl" ) ;
	String order_catalog_code_repl_desc		= request.getParameter( "order_catalog_code_repl_desc" ) ;
	//String ord[]				= request.getParameterValues("orderbycolumns");

	
	if( order_catalog_code.equals("''")||order_catalog_code.equals("")||order_catalog_code==null ){
							order_catalog_code="";	}
	//else  order_catalog_code = order_catalog_code.toUpperCase();
	if(catalog_desc==null || catalog_desc.equals("")){catalog_desc="";}
	//else  catalog_desc = catalog_desc.toUpperCase();
	if(order_catalog_code_repl==null || order_catalog_code_repl.equals("")){order_catalog_code_repl="";}
	//else  order_catalog_code_repl = order_catalog_code_repl.toUpperCase();
	if(order_catalog_code_repl_desc==null || order_catalog_code_repl_desc.equals("")){order_catalog_code_repl_desc="";}
	//else  order_catalog_code_repl_desc = order_catalog_code_repl_desc.toUpperCase();


	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue	=  "";
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_RESULT"));
															
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "order_catalog_code" );
	displayFields.add( "catalog_desc" );
	displayFields.add( "order_catalog_code_repl" );
	displayFields.add( "order_catalog_code_repl_desc" );

	//The fields are going to be in where condition should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_catalog_code + "%");
	chkFields.add( order_catalog_code_repl + "%");
	chkFields.add( catalog_desc + "%");
	chkFields.add( order_catalog_code_repl_desc + "%");

	//Function Parameters
	HashMap funcMap = new HashMap();

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

    //out.println(result);
	
	if( (result.size()>=0) && ( !( ((String) result.get(0)).equals("0")) )){
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
		<td class=" COLUMNHEADER"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>

		<td class=" COLUMNHEADER"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
		<td class=" COLUMNHEADER"><fmt:message key="eOR.ReplaceableOrderCatalogCode.label" bundle="${or_labels}"/></td>
		<td class=" COLUMNHEADER"><fmt:message key="eOR.ReplaceableOrderCatalogDescription.label" bundle="${or_labels}"/></td>


		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%> 
		<tr onClick='Modify(this,"<%=recCount%>");'  >
	
		<%

		String link_columns = "1";
		records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{
		%>
				<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" >
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
				</td>

		<%
					}// end if loop1
		else{
			
		%>

				<td class="<%=classvalue%>"  onclick="disableClick(event);">
		<%		out.println((String)records.get( colCount ));
		

		%>		</td>

		<%
					}//end of else 1
			}//inner for loop
			%></tr>
		<%
			} //upper for loop
			records.clear();
		%>
		</table>
		<%
			out.flush();
			}  // first if end
			else{// start of else
		%>
		
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>

			<%} // end of else
			out.println(CommonBean.setForm(request ,"../../eOR/jsp/ReplaceableOrderableQueryResult.jsp", searched));
		sqlMap.clear();
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();
		result.clear();
		}
		catch(Exception e) {
		e.printStackTrace(System.out);
	}
	%>
</body>
</html>


