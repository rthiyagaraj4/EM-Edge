<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,webbeans.eCommon.*, eCP.*,com.ehis.eslp.* " %>

<HTML>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale			= (String)session.getAttribute("LOCALE");
		 //This file is saved on 18/10/2005.
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
try{
		
	String assess_note_id = request.getParameter("assess_note_id");
	String assess_note_desc		= request.getParameter("assess_note_desc");
	String assess_catg_code		= request.getParameter("assess_catg_code");
	String long_desc		= request.getParameter("long_desc");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(assess_note_id == null || assess_note_id.equals("null")) assess_note_id =" "; else assess_note_id = assess_note_id.trim();
	if(assess_note_desc == null || assess_note_desc.equals("null")) assess_note_desc =" "; else assess_note_desc = assess_note_desc.trim();
	if(assess_catg_code == null || assess_catg_code.equals("null")) assess_catg_code =" "; else assess_catg_code = assess_catg_code.trim();
	if(long_desc == null || long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();

	//Common parameters.
	 HashMap sqlMap = new HashMap();
//	String sql_assess="select a.assess_note_id, b.assess_note_desc, a.assess_catg_code, c.long_desc  from CP_ASSESS_NOTE_ASSESS_CATG a, cp_assess_note   b, cp_assess_catg c where a.assess_note_id = b.assess_note_id and a.assess_catg_code = c.assess_catg_code  and upper(a.assess_note_id) like upper(?) and upper(b.assess_note_desc) like upper(?) and upper(a.assess_catg_code) like upper(?) and upper(c.long_desc) like upper(?)";
	String sql_assess="SELECT a.assess_note_id, b.assess_note_desc, a.assess_catg_code, c.long_desc  FROM CP_ASSESS_NOTE_ASSESS_CATG a, cp_assess_note_LANG_VW   b, cp_assess_catg_LANG_VW c WHERE a.assess_note_id = b.assess_note_id AND a.assess_catg_code = c.assess_catg_code  AND UPPER(a.assess_note_id) LIKE UPPER(?) AND UPPER(b.assess_note_desc) LIKE UPPER(?) AND UPPER(a.assess_catg_code) LIKE UPPER(?) AND UPPER(c.long_desc) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID";
     
	
		
	sqlMap.put( "sqlData",sql_assess);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();					
	
	displayFields.add("assess_note_id");
	displayFields.add("assess_note_desc");
	displayFields.add("assess_catg_code");
	displayFields.add("long_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(assess_note_id+"%");
	chkFields.add(assess_note_desc+"%");
	chkFields.add(assess_catg_code+"%");
	chkFields.add(long_desc+"%");
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

<table cellpadding=0 cellspacing=0 border=1 align=center width='98%'>
<tr>

	<th width="10%" align='left'><fmt:message key="eCP.AssessmentNoteId.label" bundle="${cp_labels}"/></th>
	<th width="20%" align='left'><fmt:message key="eCP.AssessmentNoteDescription.label" bundle="${cp_labels}"/></th>
	<th width="10%" align='left'><fmt:message key="eCP.AssessmentCategoryCode.label" bundle="${cp_labels}"/></th>
	<th width="20%" align='left'><fmt:message key="eCP.AssessmentCategoryDescription.label" bundle="${cp_labels}"/></th>
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/AssessmentCategoryForAssessmentNoteQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  






