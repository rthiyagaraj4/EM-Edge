<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.net.*,eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%-- Mandatory declarations end --%>


<html>
	<head>
		<title></title>
		<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eOR/js/ActivityType.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<script language='Javascript'>

function Modify(obj,rowIndex) {
	//alert(obj.cells[0].innerText);
	var	activity_type				=     obj.cells[0].innerText;
	//var long_desc				    =     obj.cells[1].innerText;
	//var short_desc					=     obj.cells[2].innerText;
	var eff_status					=     obj.cells[6].children[1].value;
	var order_category_desc			=     obj.cells[3].innerText;
	var order_category				=     obj.cells[3].children[0].value;
	var order_type_code             =     obj.cells[4].innerText;
	var order_type_desc             =     obj.cells[5].innerText;
	//var activity_type				=	  eval("document.getElementById("activity_type")"+rowIndex).value;

// Commented by Murthy - 22-05-2007 for not using the Order Category Desc, Order_type_code,order_type_desc
// var  html="../../eOR/jsp/ActivityTypeAddModifyMultiple.jsp?mode=2&order_category="+order_category+"&activity_type="+escape(activity_type)+"&eff_status="+eff_status+"&order_type_code="+escape(order_type_code)+"&order_type_desc="+escape(order_type_desc)+"&order_category_desc="+escape(order_category_desc);
var html="../../eOR/jsp/ActivityTypeAddModifyMultiple.jsp?mode=2&order_category="+order_category+"&activity_type="+escape(activity_type)+"&eff_status="+eff_status;
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
	String activity_type	= request.getParameter( "activity_type" ) ;
	String long_desc	= request.getParameter( "long_desc" ) ;
	//long_desc	= java.net.URLEncoder.encode("long_desc") ;
//out.println("<script>alert('long_desc="+long_desc+"');</script>");
	//String short_desc	= request.getParameter( "short_desc" ).trim() ;
	String order_type_code	= request.getParameter( "order_type_code" ) ;
	String order_type_desc	= request.getParameter( "order_type_desc" )==null?"":request.getParameter( "order_type_desc" ) ;
	String eff_status	= request.getParameter( "eff_status" ).trim() ;
    //String ord[]				= request.getParameterValues("orderbycolumns");

	//String short_desc	="";


	if( order_category.equals("''")||order_category.equals("")||order_category==null ){
							order_category="";	}

	if(activity_type==null|| activity_type.equals(""))   {
						activity_type="";	}

	if(long_desc==null|| long_desc.equals("")) {
						long_desc="";	}

	//if(short_desc==null|| short_desc.equals("")) {
			//	short_desc="";	}

	if(order_type_code==null|| order_type_code.equals("")) {
				order_type_code="";	}

	if(eff_status.equals("E") )
						eff_status="E";
	else if(eff_status.equals("D"))
						eff_status="D";
	else
						eff_status="";

	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepository.getOrKeyValue("SQL_OR_ACTIVITY_TYPE_SQLDATA_N"));

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	displayFields.add( "activity_type" );
	displayFields.add( "long_desc" );
	displayFields.add( "short_desc" );
	displayFields.add( "order_category_desc" );
	displayFields.add( "order_category" );
	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_desc" );
	displayFields.add( "eff_status" );
	



	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();

//out.println("<script>alert('order_category="+order_category+"');</script>");
	
	chkFields.add( order_category+"%" );
	chkFields.add( activity_type +"%");
	chkFields.add( long_desc +"%");
	//chkFields.add( short_desc +"%");
	chkFields.add( order_type_code +"%");
	chkFields.add( eff_status +"%");
	chkFields.add( order_type_desc +"%");

	
	chkFields.add( order_category+"%" );
	chkFields.add( activity_type +"%");
	chkFields.add( long_desc +"%");
	//chkFields.add( short_desc +"%");
	chkFields.add( eff_status +"%");
	chkFields.add( order_type_code +"%");
	chkFields.add( order_type_desc +"%");

	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );
	//out.println("<script>alert('displayFields="+displayFields+"')</script>");
	//out.println("<script>alert('chkFields="+chkFields+"')</script>");
	//System.out.println("sqlMap="+sqlMap);
	//System.out.println("chkFields="+chkFields);
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

//	sqlMap.clear();
//	funcMap.clear();

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

		<td class=' COLUMNHEADER'><fmt:message key="eOR.ActivityTypeCode.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER'> <fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

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
// out.println("records="+records);
			

	for(int colCount=0; colCount<records.size(); colCount++)
			{
		
		//start of for loop1
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
		
		<%
			       if(colCount ==7)
						{//start of if 3%>
							<td class="<%=classvalue%>"  onclick="disableClick(event);" align='center'>
								<%if( ((String)records.get(colCount)).equals("E"))
										out.println("<img src='../../eCommon/images/enabled.gif'><input type='hidden' value='E'></img>");
					else
										out.println("<img src='../../eCommon/images/disabled.gif'><input type='hidden' value='D'></img>");
							}//end of if 3
					else if(colCount ==3)
								{//start of if 4%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" align='left'>
					<%
					out.println((String)records.get( colCount ));
					colCount=colCount+1;

					%>
								 <input type='hidden' value=<%=(String)records.get( colCount)%>> 
					<%
								
				} else if (colCount == 8) {
					%><td class="<%=classvalue%>"  onclick="disableClick(event);" align='left'><%
					activity_type = (String)records.get(colCount);
				%>

				<%} 
		else
			{
				%><td class="<%=classvalue%>"  onclick="disableClick(event);" align='left'><%
					out.println((String)records.get( colCount ));
			}

	%></td>
	<%
					}//end of else 1
			}//inner for loop
	%>
			<input type='hidden' name='activity_type<%=recCount%>' id='activity_type<%=recCount%>' value='<%=activity_type%>'>
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
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/ActivityTypeQueryResult.jsp", searched) );

//	displayFields.clear();
//	chkFields.clear();
//	result.clear();
//	records.clear();

	} //end of try
catch(Exception e) {//start of catch
	e.printStackTrace(System.out);
}//end of catch
%>
</body>
</html>

