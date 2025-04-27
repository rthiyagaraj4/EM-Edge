<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.Common.*, eMM.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 
<html>
<head>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eMM/js/Supplier.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String supplier_code = request.getParameter("supplier_code");
	String supplier_name = request.getParameter("supplier_name");
	String status = request.getParameter("status");


	//String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		supplier_code = CommonBean.checkForNull(supplier_code).trim()+"%";
		supplier_name = CommonBean.checkForNull(supplier_name).trim()+"%";
		//status = CommonBean.checkForNull(status);
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eMM.Common.MmRepository.getMmKeyValue("SQL_MM_SUPPLIER_CODE_QUERY_RESULT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("SUPP_CODE");
		displayFields.add("LONG_NAME");
		displayFields.add("SHORT_NAME");
		displayFields.add("STATUS");
		

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( supplier_code);
		chkFields.add( supplier_name);
		chkFields.add( status);
		chkFields.add( locale);
		

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		//out.println(result + " result ");
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  align=center>
				<th><fmt:message key="Common.SupplierCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
//						System.err.println("Supplier flag" + (String)records.get( 3 ));
							if(colCount == 3) {
								out.println(" align=\'center\'>");
								if( CommonBean.checkForNull(  ((String)records.get( colCount ))).equals("S"))
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
							}
							else if(colCount == 2) {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
							}
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
							}
						
						//out.println((String)records.get( colCount )); 
						%> 
						</td>
		<%
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
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/SupplierQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0184
	}
%>
</body>
</html>

