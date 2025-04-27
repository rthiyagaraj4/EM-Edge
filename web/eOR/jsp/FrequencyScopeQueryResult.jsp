<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eOR/js/FrequencyScope.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Search Criteria's from Query Criteria page
	String freq_code	        = request.getParameter( "freq_code" ) ;
	String freq_desc	        = request.getParameter( "freq_desc" );
	String order_category	= request.getParameter( "order_category" ).trim() ;
//	String ord[]				    = request.getParameterValues("orderbycolumns");

			if(freq_code.equals("")||freq_code==null )
								{
							freq_code="";
								}

			if(freq_desc.equals("")||freq_desc==null )
								{
						freq_desc="";
								}

			if( order_category.equals("''")|| order_category.equals("")||order_category==null)
								{
							order_category="";
								}
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_QUERY_RESULT"));

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	displayFields.add( "freq_code" );
	displayFields.add( "freq_desc" );
	displayFields.add( "order_category" );
	displayFields.add( "short_desc" );
	displayFields.add( "freq_scope_yn" );
	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();
	chkFields.add(freq_code+"%" );
	chkFields.add( freq_desc+"%");
	chkFields.add( order_category+"%" );



	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );


	//Calling the Result from Common Adaptor as a arraylist.

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
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

		<th class='COLUMNHEADER' width='20%' align='left'><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='40%' align='left'><fmt:message key="eOR.FrequencyDesc.label" bundle="${or_labels}"/></th>
		<th class='COLUMNHEADER' width='40%' align='left'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
        <th class='COLUMNHEADER' width='40%' align='left'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
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
			<tr>
	<%

			String link_columns = "";

			records=(ArrayList) result.get( recCount );

	for(int colCount=0; colCount<records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
								{  // if loop1
							%>
									<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" >
										<font class='HYPERLINK'>
										<%=(String)records.get(colCount)%>
										</font>
									</td>
							<%
								}// end if loop1
								else{// start  else 1
							%>
											<td class="<%=classvalue%>"  onclick="disableClick(event);">
							<%
					if(colCount==4){
										if( ((String)records.get(colCount)).equals("Y"))
										out.println("<img src='../../eCommon/images/enabled.gif'><input type='hidden' value='Y'></img>");
					else
										out.println("<img src='../../eCommon/images/disabled.gif'><input type='hidden' value='N'></img>");


							}
	                     else

						 if(colCount==2)
											{
												out.println((String)records.get( colCount+1));
											%>
												<input type=hidden name='order_category' id='order_category'<%=recCount-2%> value='<%=(String)records.get( colCount)%>'  >
											<%
												colCount=colCount+1;
											}
									else{
											out.println((String)records.get( colCount ));
											}
											%>
										</td>
										<%
									}//end of else 1
			}//inner for loop
	%>
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
	out.println(CommonBean.setForm( request ,"../../eOR/jsp/FrequencyScopeQueryResult.jsp", searched) );
	} //end of try
catch(Exception e) {//start of catch
	System.out.print("Exception @ Result JSP :"+e.toString());
}//end of catch
%>
</body>
</html>

