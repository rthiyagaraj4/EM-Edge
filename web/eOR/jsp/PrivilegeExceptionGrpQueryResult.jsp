<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
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
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="JavaScript" src="../js/PrivilegeExceptionGrp.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String grp_exception_id		= request.getParameter( "grp_exception_id" ) ;
	String exception_type		= request.getParameter( "exception_type" ).trim() ;
	String grp_exception_name   = request.getParameter( "grp_exception_name" ) ;
		
	if(grp_exception_id==null || grp_exception_id.equals("")){grp_exception_id="";}
	if(exception_type==null || exception_type.equals("")){exception_type="";}
	if(grp_exception_name==null || grp_exception_name.equals("")){grp_exception_name="";}
	
	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";
	//String bean_id = "privilegeexceptiongrpbean" ;
	//String bean_name = "eOR.PrivilegeExceptionGrpBean";

	/* Initialize Function specific start */
	//PrivilegeExceptionGrpBean bean = (PrivilegeExceptionGrpBean)mh.getBeanObject( bean_id, request,  bean_name ) ;  
	//bean.clear() ;
	/* Initialize Function specific end */

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_PRIV_GRP_EXCEPTION_QUERY_RESULT"));
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "grp_exception_id" );
	displayFields.add( "grp_exception_name" );
	displayFields.add( "exception_type_name" );	
	displayFields.add( "exception_type" );	
		
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( grp_exception_id + "%");
	chkFields.add( grp_exception_name + "%");
	chkFields.add( exception_type + "%");
		
	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table border="0" cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<td class='columnheader'><fmt:message key="eOR.GroupID.label" bundle="${or_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="eOR.ExceptionType.label" bundle="${or_labels}"/></td>
		<%
		//Retriving the records from result arraylist
		
		ArrayList records=new ArrayList();
		String link_columns ="";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		%>
			<tr onClick="Modify(this);" >
		<%
		link_columns = "1";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=(String)records.get(colCount)%> </font></td>
			<%}else{
				if(colCount != 3){
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></td>
				<%
				}else{
					%>
					<td class="WHITE"><input type="hidden" value="<%=(String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount)%>"></td>
					<%
				}
			}
		}
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/PrivilegeExceptionGrpQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}	
	%>
</body>
</html>



