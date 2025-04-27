<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%><%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<head>
<%
//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
try{

	
	String case_type_code = request.getParameter("case_type_code");
	String case_type_desc		= request.getParameter("case_type_desc");
	String library_id		= request.getParameter("library_id");
	String short_desc		= request.getParameter("short_desc");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(case_type_code == null || case_type_code.equals("null")) case_type_code =" "; else case_type_code = case_type_code.trim();
	if(case_type_desc == null || case_type_desc.equals("null")) case_type_desc =" "; else case_type_desc = case_type_desc.trim();
	if(library_id == null || library_id.equals("null")) library_id =" "; else library_id = library_id.trim();
	if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc = short_desc.trim();

	//Common parameters.
	HashMap sqlMap = new HashMap();

//	String sql_assess="select a.case_type_code, a.short_desc case_type_desc, b.library_id, b.short_desc from cp_case_type a, cp_library b, CP_CASE_TYPE_FOR_LIBRARY c where a.case_type_code =c.case_type_code and b.library_id=c.library_id and upper( a.case_type_code) like upper(?) and upper(a.short_desc) like upper(?) and upper( b.library_id) like upper(?) and upper(b.short_desc) like upper(?)";
	String sql_assess="SELECT a.case_type_code, a.short_desc case_type_desc, b.library_id, b.short_desc FROM cp_case_type_lang_vw a, cp_library_lang_vw b, CP_CASE_TYPE_FOR_LIBRARY c WHERE a.case_type_code =c.case_type_code AND b.library_id=c.library_id AND a.language_id =? AND b.language_id = a.language_id AND UPPER( a.case_type_code) LIKE UPPER(?) AND UPPER(a.short_desc) LIKE UPPER(?) AND UPPER( b.library_id) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?)";
	
	sqlMap.put( "sqlData",sql_assess);
	ArrayList displayFields = new ArrayList();
	displayFields.add("case_type_code");
	displayFields.add("case_type_desc");
	displayFields.add("library_id");
	displayFields.add("short_desc");
	
	
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();
	chkFields.add( locale);
	chkFields.add( case_type_code+"%");
	chkFields.add( case_type_desc+"%");
	chkFields.add( library_id+"%");
	chkFields.add( short_desc+"%");


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 %>

 <table cellpadding=0 cellspacing=0 width="98%" align="center">
<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
     out.println(result.get(1));
%>
	</td>
</tr>
</table>

<table cellpadding=0 cellspacing=0 border=1 align=center width='98%'>
<tr>
	<th width="15%" align='center'><fmt:message key="eCP.CaseTypeCode.label" bundle="${cp_labels}"/></th>
	<th width="35%" align='center'><fmt:message key="eCP.CaseTypeDescription.label" bundle="${cp_labels}"/></th>
	<th width="15%" align='center'><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></th>
	<th width="35%" align='center'><fmt:message key="eCP.LibraryDescription.label" bundle="${cp_labels}"/></th>
	
</tr>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			
			records=(ArrayList) result.get( recCount );
		%>				
		<tr>   
		<%
		for(int colCount=0; colCount<records.size(); colCount++){		
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
			if(str.equals("")){%>
			<td class="<%=classvalue%>">&nbsp;</td>
 		<%} else {
		  if((colCount==5)||(colCount==6)) { %>
				<td align=right class="<%=classvalue%>"><%=str%></td>
			  <%} else{ %>
			  <td class="<%=classvalue%>"><%=str%></td>

		  <%}}}//end of for loop
		  %>
</tr>
<%}//L00p for all records%>
</table>
	<%
	out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/LibraryForCaseTypeQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  

