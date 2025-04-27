<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%-- Mandatory declarations end --%>
 	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<html>
	<head>
		<title></title>
<%
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eOR/js/ChargeType.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>

<script language='Javascript'>

function Modify(obj,rowIndex) {
	//alert(obj.cells[0].innerText);
	var	charge_type_code			=     obj.cells[0].innerText;
	var order_category_desc			=     obj.cells[2].innerText;
	var order_category				=     obj.cells[2].children[0].value;
	//var description					=     obj.cells[2].innerText;

	//var activity_type				=	  eval("document.getElementById("activity_type")"+rowIndex).value;
var  html="../../eOR/jsp/ChargeTypeMultiple.jsp?order_category="+order_category+"&charge_type_code="+escape(charge_type_code)+"&order_category_desc="+escape(order_category_desc)+"&mode=2";
//alert(html);
parent.f_query_add_mod.location.href=html;
//alert(parent.f_query_add_mod.location.name);
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Search Criteria's from Query Criteria page
	String order_category	= request.getParameter( "order_category" ).trim() ;
	//String order_category_desc=request.getParameter( "order_category_desc" )==null?"":request.getParameter( "order_category_desc" ).trim();
	String charge_type_code	= request.getParameter( "charge_type_code" ) ;
	String description	= request.getParameter( "description" ) ;
//	String ord[]				= request.getParameterValues("orderbycolumns");

	if( order_category.equals("''")||order_category.equals("")||order_category==null ){
							order_category="";	}

	if(charge_type_code==null|| charge_type_code.equals(""))   {
						charge_type_code="";	}

	if(description==null|| description.equals("")) {
						description="";	}



	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_SQLDATA_N"));

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	
	displayFields.add( "charge_type_code" );
	displayFields.add( "description" );	
	displayFields.add( "order_category_desc" );
	displayFields.add( "order_category" );



	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();

//out.println("<script>alert('order_category="+order_category+"');</script>");
	
	chkFields.add( order_category+"%" );
	chkFields.add( charge_type_code +"%");
	chkFields.add( description +"%");
	
	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );

ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	
	if( (result.size()>=0) && ( !( ((String) result.get(0)).equals("0")) ))	{
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

		
		<th class=' COLUMNHEADER'><fmt:message key="eOR.ChargeTypeCode.label" bundle="${or_labels}"/></th>
		<th class=' COLUMNHEADER'><fmt:message key="eOR.ChargeTypeDescription.label" bundle="${or_labels}"/></th>
		<th class=' COLUMNHEADER'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>

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

			String link_columns = "1";

			records=(ArrayList) result.get( recCount );
//out.println("##records="+records);
	for(int colCount=0; colCount<records.size(); colCount++)
			{
		
		//start of for loop1
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{  // if loop1
	%>
		<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" align="left">
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
		</td>
	<%
					}// end if loop1
	else{// start  else 1%>
		<td class="<%=classvalue%>"  onclick="disableClick(event);" align='left'>
		<%
			       
					if(colCount ==2)
								{//start of if 4
					out.println((String)records.get( colCount ));
					colCount=colCount+1;

					%>
								 <input type='hidden' value=<%=(String)records.get( colCount)%>> 
					<%
								
				} else if (colCount == 0) {
					charge_type_code = (String)records.get(colCount);
				%>

				<%}
		else
			{
					out.println((String)records.get( colCount ));
			}

	%></td>
	<%
					}//end of else 1
			}//inner for loop
	%>
			<input type='hidden' name='charge_type_code<%=recCount%>' id='charge_type_code<%=recCount%>' value='<%=charge_type_code%>'>
			</tr>
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
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/ChargeTypeQueryResult.jsp", searched) );
	} //end of try
catch(Exception e) {//start of catch
	e.printStackTrace(System.out);
}//end of catch
%>
</body>
</html>

