<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	PractTypeForAssessmentNoteQueryResult.jsp
*	Purpose 			:	to display Query Result
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/
%>

<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<HTML>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
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
		
	String assess_note_id= request.getParameter("assess_note_id");
	String assess_note_desc	= request.getParameter("assess_note_desc");
	String pract_type= request.getParameter("pract_type");
	String pract_type_desc	= request.getParameter("pract_type_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(assess_note_id == null || assess_note_id.equals("null")) 
		assess_note_id =""; 
	else 
		assess_note_id =assess_note_id.trim();

	if(assess_note_desc == null ||assess_note_desc.equals("null")) 
		assess_note_desc =""; 
	else 
		assess_note_desc = assess_note_desc.trim();

	if(pract_type == null ||pract_type.equals("null")) 
		pract_type =""; 
	else 
		pract_type = pract_type.trim();

	if(pract_type_desc == null ||pract_type_desc.equals("null")) 
		pract_type_desc =""; 
	else 
		pract_type_desc = pract_type_desc.trim();

	HashMap sqlMap = new HashMap();
//	String sql_terminology="select a.assess_note_id, b.assess_note_desc, a.pract_type, c.desc_userdef pract_type_desc from cp_assess_note_pract_type a, cp_assess_note b, am_pract_type c where a.assess_note_id = b.assess_note_id and a.pract_type=c.pract_type and upper(a.assess_note_id) like upper(?) and upper( b.assess_note_desc) like upper(?) and upper(a.pract_type) like upper(?) and upper(c.desc_userdef) like upper(?)";
	String sql_terminology="SELECT a.assess_note_id, b.assess_note_desc, a.pract_type, c.desc_userdef pract_type_desc FROM cp_assess_note_pract_type a, cp_assess_note_LANG_VW b, am_pract_type_LANG_VW c WHERE a.assess_note_id = b.assess_note_id AND a.pract_type=c.pract_type AND UPPER(a.assess_note_id) LIKE UPPER(?) AND UPPER( b.assess_note_desc) LIKE UPPER(?) AND UPPER(a.pract_type) LIKE UPPER(?) AND UPPER(c.desc_userdef) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID";
	
		
	sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("assess_note_id");
	displayFields.add("assess_note_desc");
	displayFields.add("pract_type");
	displayFields.add("pract_type_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(assess_note_id+"%");
	chkFields.add( assess_note_desc+"%");
	chkFields.add( pract_type+"%");
	chkFields.add(pract_type_desc+"%");
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

	<th width="15%" align='left'><fmt:message key="eCP.AssessmentNoteId.label" bundle="${cp_labels}"/></th>
	<th width="50%" align='left'><fmt:message key="eCP.AssessmentNoteDescription.label" bundle="${cp_labels}"/></th>
	<th width="10%" align='left'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
	<th width="25%" align='left'><fmt:message key="Common.PractitionerTypeDescription.label" bundle="${common_labels}"/></th>
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/PractTypeForAssessmentNoteQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html>  

