
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.*,java.util.*,java.sql.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
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
	
	<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>
	function Modify(obj){

		var field_mnemonic		= obj.cells[0].innerText;
		var field_mnemonic_desc		= obj.cells[1].innerText;
		var field_type			= eval("document.result_form.field_type_id"+obj.rowIndex).value;
		var order_category_id	= eval("document.result_form.order_category_id"+obj.rowIndex).value;

		var order_catalog_desc	= obj.cells[3].innerText;
		document.location.href="../../eOR/jsp/OrderEntryFormatItemAddModify.jsp?mode=2&field_mnemonic="+field_mnemonic+"&field_type="+field_type+"&order_category_id="+order_category_id+"&function_id="+parent.function_id+"&order_category="+order_catalog_desc+"&field_mnemonic_desc="+field_mnemonic_desc
}
</script>

<!--  -->
<BODY class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name=result_form >
 <%

//	String bean_id				= "Or_OrderEntryFormatItems" ;
//	String bean_name			= "eOR.OrderEntryFormatItem";

//	OrderEntryFormatItem bean = (OrderEntryFormatItem)mh.getBeanObject( bean_id, request, bean_name ) ;

	String classvalue = "";

	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;

	String valSource[]  ={"C","N","I","L","D","E","T","A","M","V","R"} ;
	String descsource[]	={"Yes/No","Decimal Numeric","Integer Numeric","List","Date","Date/Time","Time","Alphanumeric","Discrete measure","Clinical Events","Radio Group"} ;

	String singleMultiVal[]		={"S","M"} ;
	String singleMultiDesc[]	={"Single","Multi"} ;

try{
		     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String field_mnemonic		= CommonBean.checkForNull(request.getParameter("field_mnemonic"));
	String field_mnemonic_desc		= CommonBean.checkForNull(request.getParameter("field_mnemonic_desc"));
	String field_type			= CommonBean.checkForNull(request.getParameter("field_type"));
	String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
	String single_multi			= CommonBean.checkForNull(request.getParameter("single_multi"));
	String presentation_type	= CommonBean.checkForNull(request.getParameter("presentation_type"));
	String meaning				= CommonBean.checkForNull(request.getParameter("meaning"));
	String eff_status			= CommonBean.checkForNull(request.getParameter("eff_status"));
	
	boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_SELECT") );

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "field_mnemonic" );
	displayFields.add( "field_mnemonic_desc" );
	displayFields.add( "field_type" );
	displayFields.add( "order_category" );
	displayFields.add( "order_category_id" );
	displayFields.add( "help_text" );
	displayFields.add( "single_or_multi" );
	displayFields.add( "eff_status" );



	//The fields are going to be in where condition * should match with the query


	ArrayList chkFields = new ArrayList();
	chkFields.add( field_mnemonic+"%" );
	chkFields.add( field_mnemonic_desc+"%" );
	chkFields.add( field_type+"%" );
	chkFields.add( order_category.trim()+"%" );
	chkFields.add( single_multi+"%" );
	chkFields.add( presentation_type+"%" );
	chkFields.add( meaning+"%" );
	chkFields.add( eff_status+"%" );
	if(order_category.trim().equals(""))	order_category = "*A";
	if(order_category.trim().equals("*A"))
	{
		chkFields.add( order_category.trim());
		chkFields.add( order_category.trim() );
	}
	else
	{
		chkFields.add( order_category.trim()+"%" );
		chkFields.add( order_category.trim()+"%" );
	}
	chkFields.add( field_mnemonic+"%" );
	chkFields.add( field_mnemonic_desc+"%" );
	chkFields.add( field_type+"%" );
	chkFields.add( single_multi+"%" );
	chkFields.add( presentation_type+"%" );
	chkFields.add( meaning+"%" );
	chkFields.add( eff_status+"%" );


	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	int rowCount = 1;

	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

%>
	<table cellpadding=3 cellspacing=0 width="100%" align=center>
		<tr>
		<td class='label'></td>
		<td class='label'>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
	</td></tr>
	</table>

	<table class='grid' width='100%'>
		<tr>
		   <td class='columnheader'  width="20%"><fmt:message key="eOR.FieldMnemonic.label" bundle="${or_labels}"/></td>
			<td class='columnheader'  width="20%"><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
			<td class='columnheader' width="16%"><fmt:message key="eOR.FieldType.label" bundle="${or_labels}"/></td>
			<td class='columnheader'  width="12%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='columnheader'  width="22%"><fmt:message key="eOR.Hint.label" bundle="${or_labels}"/></td>
			<td class='columnheader'  width="10%"><fmt:message key="eOR.SingleMulti.label" bundle="${or_labels}"/></td>
			<td class='columnheader'  width="8%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		</tr>

		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) 
		{
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="Modify(this);" >
	<%

		  String link_columns = "1";

		  records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++)
		  {
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
			{
			%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=(String)records.get(colCount)%></a></td>
			<%
			}
			else
			{
				String str = (String)records.get(colCount);
				if (str==null)str = "&nbsp;";

				if(colCount ==2)
				{
					out.println("<input type=hidden name='field_type_id"+rowCount+"' id='field_type_id"+rowCount+"'  value='"+str+"'>");
					str=eHISFormatter.chkReturn(valSource,str,descsource,"&nbsp;");
				}
				if(colCount ==5)
				{
					if(str==null)
					{
						str = "&nbsp;";
					}
				}
			if(colCount ==6)
   				str=eHISFormatter.chkReturn(singleMultiVal,str,singleMultiDesc,"&nbsp;");
			if(colCount == 7)
   				str=eHISFormatter.chkReturn("E",str,enableGif,disableGif);
				if(colCount == 4)
				{
					out.println("<input type=hidden name='order_category_id"+rowCount+"' id='order_category_id"+rowCount+"'  value='"+str+"'>");
					rowCount++;
				}
				else
				{
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%
				}
			}
		 }%>

		</tr>
		<%
		}
		%>
	</table>
			</form>
	<%
	out.flush();
	} 
	else
	{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"OrderEntryForamtItemQueryResult.jsp", searched));

}catch(Exception e )
{
	e.printStackTrace();
}
%>
</body>
</html>

<!-- select a.order_category order_category_id, a.field_mnemonic field_mnemonic,a.field_type field_type, b.short_desc  order_category,a.single_or_multi single_or_multi,a.eff_status eff_status,a.sys_user_def_ind sys_user_def_ind,a.help_text help_text  ,a.max_num_value max_num_value,a.min_num_value min_num_value ,a.discr_msr_id discr_msr_id	from or_order_field a,or_order_category b	where a.order_category = b.order_category  and upper(a.field_mnemonic ) like upper(?) and upper(a.field_type) like upper(?) and a.order_category like upper(?) and a.single_or_multi like upper(?) and a.sys_user_def_ind like upper(?) and a.eff_status like ?  -->

