<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<!--
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj){

		var level				= obj.cells[0].innerText;
		var order_cat_code		= obj.cells[1].innerText;
		var order_type_code		= obj.cells[3].innerText;
		var order_catalog_code	= obj.cells[5].innerText;
		var order_catalog_desc	= obj.cells[2].innerText;

	//	alert("order_catalog_desc"+order_catalog_desc);

		var format_id			= eval("document.result_form.format_id"+obj.rowIndex).value;

	//alert("../../eOR/jsp/OrderEntryFormatsAddModify.jsp?mode=2&format_id="+format_id+"&function_id="+parent.function_id)	;
	document.location.href="../../eOR/jsp/OrderEntryFormatsAddModify.jsp?mode=2&format_id="+format_id+"&function_id="+parent.function_id
}
</script>

<!--OnMouseDown='CodeArrest()'   -->
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name=result_form >
 <%

//	String bean_id				= "Or_OrderEntryFormatItems" ;
//	String bean_name			= "eOR.OrderEntryFormatItem";

//	OrderEntryFormatItem bean = (OrderEntryFormatItem)mh.getBeanObject( bean_id, request, bean_name ) ;

	String classvalue = "";

//	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
//	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;

	String headerLineVal[]		={"H","L"} ;
	String headerLineDesc[]	={"Header","Line"} ;

try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String level				= CommonBean.checkForNull(request.getParameter("level"));
	String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
	String order_type			= CommonBean.checkForNull(request.getParameter("order_type"));
	String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
	String order_catalog		= CommonBean.checkForNull(request.getParameter("order_catalog"));
	String order_catalog_desc	= CommonBean.checkForNull(request.getParameter("order_catalog_desc"));
	String meaning				= CommonBean.checkForNull(request.getParameter("meaning"));
	boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

	if(level != null )				level = level.trim();
	if(order_category != null )		order_category = order_category.trim();
	if(order_type != null )			order_type = order_type;
	if(order_type_desc != null )	order_type_desc = order_type_desc;
	if(order_catalog != null )		order_catalog = order_catalog;
	if(order_catalog_desc != null )	order_catalog_desc = order_catalog_desc;
	if(meaning != null )			meaning = meaning.trim();

	order_type_desc		= order_type_desc .toUpperCase();
	order_catalog_desc  = order_catalog_desc .toUpperCase();

	//Common parameters.
	HashMap sqlMap = new HashMap();


	//include all the common parameters.
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_RSLT") );
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "format_level" );
	displayFields.add( "order_category_id" );
	displayFields.add( "order_category" );
	displayFields.add( "order_type" );
	displayFields.add( "order_type_desc" );
	displayFields.add( "order_catalog" );
	displayFields.add( "order_catalog_desc" );
	displayFields.add( "sys_user_def_ind" );
	displayFields.add( "format_id" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_category+"%" );
	chkFields.add( level+"%" );
	chkFields.add( order_type+"%" );
	chkFields.add( order_catalog+"%" );
	chkFields.add( order_type_desc+"%" );
	chkFields.add( order_catalog_desc+"%" );
	chkFields.add( meaning+"%" );


	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
    int rowCount = 1;

	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

%>
	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label nowrap></td>
		<td class=label nowrap>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
	</table>

	<table class='grid' width='100%'>
		<tr>
			<th class='columnheader' width="10%"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<th class=' columnheader' width="10%"><fmt:message key="eOR.OrderCategory ID.label" bundle="${or_labels}"/></td>
			<th class=' columnheader' width="15%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<th class=' columnheader' width="10%"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
			<th class=' columnheader' width="20%"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
			<th class=' columnheader' width="10%"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
		    <th class=' columnheader' width="15%"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
			<th class=' columnheader' width="10%"><fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/></td>
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

		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				String str=(String)records.get(colCount);
				str = eHISFormatter.chkReturn(headerLineVal,str,headerLineDesc,"&nbsp;");

			%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#''><%=str%></a></td>
			<%
			}else{
			String str = (String)records.get(colCount);



				if(colCount == 8){
					out.println("<input type=hidden name='format_id"+rowCount+"' id='format_id"+rowCount+"'  value='"+str+"'>");
					rowCount++;
				}else{
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%
				}
			}
		 }%>

		</tr>
		<%}%>
	</table>
			</form>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"OrderEntryFormatsQueryResult.jsp", searched));

}catch(Exception e ){
	e.printStackTrace();
}
%>
</body>
</html>

<!-- select a.order_category order_category_id, a.field_mnemonic field_mnemonic,a.field_type field_type, b.short_desc  order_category,a.single_or_multi single_or_multi,a.eff_status eff_status,a.sys_user_def_ind sys_user_def_ind,a.help_text help_text  ,a.max_num_value max_num_value,a.min_num_value min_num_value ,a.discr_msr_id discr_msr_id	from or_order_field a,or_order_category b	where a.order_category = b.order_category  and upper(a.field_mnemonic ) like upper(?) and upper(a.field_type) like upper(?) and a.order_category like upper(?) and a.single_or_multi like upper(?) and a.sys_user_def_ind like upper(?) and a.eff_status like ?  -->

