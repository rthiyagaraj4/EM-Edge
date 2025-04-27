<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	12 Dec 2004
-->

<!-- AssessBasedDepClassificationQueryResult.jsp-->

<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
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

try{
			String classvalue = "";

			String assess_note_id = request.getParameter("assess_note_id")==null ? "":request.getParameter("assess_note_id");
			String assess_note_desc = request.getParameter("assess_note_desc")==null ? "":request.getParameter("assess_note_desc");
			String dependency_code = request.getParameter("dependency_code")==null ? "":request.getParameter("dependency_code");
			String dependency_desc = request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
			String depedency_level = request.getParameter("dependency_level")==null ? "":request.getParameter("dependency_level");

boolean searched		= request.getParameter( "searched" ) == null? false : true  ;

			HashMap sqlMap = new HashMap();

//			String sql_terminology="SELECT a.assess_note_id assess_note_id,  b.assess_note_desc assess_note_desc,  a.dependency_code dependency_code,c.short_desc dependency_desc,c.dependency_level dependency_level,a.min_score min_score FROM  cp_trgd_dep_clsfn_at_assmt a, cp_assess_note b,cp_dependency c where a.assess_note_id=b.assess_note_id and a.dependency_code=c.dependency_code and upper(a.assess_note_id) like upper(?) and upper(b.assess_note_desc) like upper(?) and upper(a.dependency_code) like upper(?) and  upper(c.short_desc) like upper(?)and upper(c.dependency_level) like upper(?)";
			String sql_terminology="SELECT a.assess_note_id assess_note_id,  b.assess_note_desc assess_note_desc,  a.dependency_code dependency_code,c.short_desc dependency_desc,c.dependency_level dependency_level,a.min_score min_score FROM  cp_trgd_dep_clsfn_at_assmt a, cp_assess_note_LANG_VW b,cp_dependency_LANG_VW c WHERE a.assess_note_id=b.assess_note_id AND a.dependency_code=c.dependency_code AND UPPER(a.assess_note_id) LIKE UPPER(?) AND UPPER(b.assess_note_desc) LIKE UPPER(?) AND UPPER(a.dependency_code) LIKE UPPER(?) AND  UPPER(c.short_desc) LIKE UPPER(?)AND UPPER(c.dependency_level) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID";


			sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("assess_note_id");
	displayFields.add("assess_note_desc");
	displayFields.add("dependency_code");
	displayFields.add("dependency_desc");
	displayFields.add("dependency_level");
	displayFields.add("min_score");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(assess_note_id+"%");
	chkFields.add( assess_note_desc+"%");
	chkFields.add( dependency_code+"%");
	chkFields.add(dependency_desc+"%");
	chkFields.add(depedency_level+"%");
	chkFields.add(locale);
	
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

<table cellpadding=0 cellspacing=0 border=1 width='97%'  align=center>
<tr>

		<th rowspan="2"><fmt:message key="eCP.AssessmentNoteId.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="eCP.AssessmentNoteDescription.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="eCP.DependencyCode.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="eCP.DependencyDescription.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="eCP.MinScore.label" bundle="${cp_labels}"/></th>
</tr><tr></tr>
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
		 %>
				<td class="<%=classvalue%>"><%=str%></td>
		  <%}}//end of for loop
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/AssessBasedDepClassficationQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html>  





			

