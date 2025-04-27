
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"%> 
<%-- JSP Page specific attributes end --%>

 <%-- Mandatory declarations start --%>
 <%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
 <%-- Mandatory declarations end --%>
   
<html>
	<head>
		<title></title>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/ClosingProcessedOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	//Search Criteria's from Query Criteria page
	String order_type_code	= request.getParameter( "order_type_code" ) ;
	String short_desc		= request.getParameter( "short_desc" );
	String order_category		= request.getParameter( "order_category" );
	String patient_class		= request.getParameter( "patient_class" );

	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;

	if(order_type_code==null || order_type_code.equals(""))
	order_type_code ="";
	if(short_desc==null || short_desc.equals(""))
	short_desc ="";
	if(order_category==null || order_category.equals(""))
	order_category ="";
	if(patient_class==null || patient_class.equals(""))
	patient_class ="";

try{
	String classvalue			= "";
	String tmp_ord_cat="";


	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	String sql_query=OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_QUERY_CRITERIA");
		
	sqlMap.put( "sqlData",sql_query);


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "order_category" );
	displayFields.add( "order_type_code" );
	displayFields.add( "short_desc" );
	displayFields.add( "patient_class" );
	displayFields.add( "ELAPSED_PRD_CLOSE_UNPR" );	
	displayFields.add( "close_unpr_fut_ord" );	
	displayFields.add( "close_unpr_billed_ord" );
	displayFields.add( "close_unpr_reverse_chrg" );
	displayFields.add( "ingore_order_in_hrs" );
	displayFields.add( "ELAPSED_PRD_CLOSE_INPR" );
	displayFields.add( "close_inpr_billed_ord" );
	displayFields.add( "close_inpr_reverse_chrg" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_type_code+"%" );
	chkFields.add(short_desc +"%");
	chkFields.add(order_category +"%");
	chkFields.add(patient_class +"%");
	chkFields.add(order_type_code+"%" );
	chkFields.add(short_desc +"%");
	chkFields.add(order_category +"%");
	chkFields.add(patient_class +"%");

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	//ArrayList result=bean.getQueryResultPage(sqlMap, funcMap, request);
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table border="0" cellpadding=3 cellspacing=0 width="100%" align="center">
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
		<tr>
			<td class=columnheader width="10%"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>	
			<td class=columnheader width="15%"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
			<td class=columnheader width="10%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class=columnheader width="10%" ><fmt:message key="eOR.CloseUnprocessedOrdersafter.label" bundle="${or_labels}"/>(<fmt:message key="Common.days.label" bundle="${common_labels}"/>)
			</td>		
			<td class=columnheader width="5%" ><fmt:message key="eOR.Unprocessed.label" bundle="${or_labels}"/>
					<fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/>
				</td>
				</td>
				<td class=columnheader width="10%" ><fmt:message key="eOR.Unprocessed.label" bundle="${or_labels}"/>
					<fmt:message key="eOR.CloseBilledOrder.label" bundle="${or_labels}"/>
				</td>
				<td class=columnheader width="10%" ><fmt:message key="eOR.Unprocessed.label" bundle="${or_labels}"/>
					<fmt:message key="eOR.ReverseCharge.label" bundle="${or_labels}"/>
				</td>		
			<td class=columnheader width='10%' wrap>
				<fmt:message key="eOR.IgnoreOrdersPlacedWithin.label" bundle="${or_labels}"/>(<fmt:message key="Common.hours.label" bundle="${common_labels}"/>)			
			</td>
			<td class=columnheader width="10%"><fmt:message key="eOR.CloseInProcessOrdersafter.label" bundle="${or_labels}"/>(<fmt:message key="Common.days.label" bundle="${common_labels}"/>)
		    </td>
			<td class=columnheader width="10%" ><fmt:message key="eOR.InProcess.label" bundle="${or_labels}"/>
				<fmt:message key="eOR.CloseBilledOrder.label" bundle="${or_labels}"/>
			</td>	
			<td class=columnheader width="10%" ><fmt:message key="eOR.InProcess.label" bundle="${or_labels}"/>
				<fmt:message key="eOR.ReverseCharge.label" bundle="${or_labels}"/>
			</td>	
			</tr>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) 
		{
			classvalue = "gridData" ;
		/*	if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;  */
	%>
			<tr>
	<%

			String link_columns = "";
			

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
				{
	%>
					 <td class="<%=classvalue%>" >  <%=(String)records.get( colCount )==null?"&nbsp;":(String)records.get( colCount )%>    </font></td> 
	<%
				}
				else
				{

					if(colCount==0)
					{
					 
						if(!tmp_ord_cat.equals((String)(records.get(0))))
						{
							out.println("<tr><td class=columnheader colspan=11>"+(String)records.get(0)+"</td></tr><tr>");
							tmp_ord_cat = (String)(records.get(0));
												
						}
					}
					else
					{
	%>
						<td class="<%=classvalue%>"  >
						<%

						out.println(((String)records.get( colCount )==null||(records.get( colCount ).toString().equals("0"))?"&nbsp;":(String)records.get( colCount))); 
						
						
						%>						
						</td>
	<%}
					
				}
			}
	%>
			</tr>
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/ClosingProcessedOrdersQueryResult.jsp", searched) );
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

