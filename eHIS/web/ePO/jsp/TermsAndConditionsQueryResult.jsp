<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.Common.*, ePO.* " contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
	<script language="javascript" src="../../ePO/js/TermsAndConditions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String termsAndCond_code = request.getParameter("termsAndCond_code");
	System.out.println("termsAndCond_code = "+termsAndCond_code);
	String termsAndCond_desc = request.getParameter("termsAndCond_desc");
	String status = request.getParameter("status");


	//String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		termsAndCond_code = CommonBean.checkForNull(termsAndCond_code).trim()+"%";
		termsAndCond_desc = CommonBean.checkForNull(termsAndCond_desc).trim()+"%";
		//status = CommonBean.checkForNull(status);
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_TERMS_AND_COND_CODE_QUERY_RESULT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("TERM_CONS_CODE");
		displayFields.add("SHORT_DESC");
		displayFields.add("LONG_DESC");
		displayFields.add("EFF_STATUS");
		

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( termsAndCond_code);
		chkFields.add( termsAndCond_desc);
		chkFields.add( status);
		//chkFields.add( locale);
		

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		System.out.println("sqlMap = "+ sqlMap);
		System.out.println("funcMap = "+ funcMap);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		System.out.println("result = " +  result );
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
			
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
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
							if(colCount == 3) {
								out.println(" align=\'center\'>");
								if( CommonBean.checkForNull(  ((String)records.get( colCount ))).equals("D"))
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
		out.println(CommonBean.setForm ( request ,"../../ePO/jsp/TermsAndConditionsQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

