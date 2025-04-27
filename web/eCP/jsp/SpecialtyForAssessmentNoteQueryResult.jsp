<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 January 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>



<HTML>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
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
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String assess_note_id= request.getParameter("assess_note_id");
	String assess_note_desc	= request.getParameter("assess_note_desc");
	String specialty_code		= request.getParameter("specialty_code");
	String specialty_desc		= request.getParameter("specialty_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(assess_note_id == null || assess_note_id.equals("null")) assess_note_id =" "; else assess_note_id =assess_note_id.trim();
	if(assess_note_desc == null ||assess_note_desc.equals("null")) assess_note_desc =" "; else assess_note_desc = assess_note_desc.trim();
	if(specialty_code	 == null || specialty_code	.equals("null")) specialty_code	 =" "; else specialty_code	 = specialty_code	.trim();
	if(specialty_desc == null || specialty_desc.equals("null")) specialty_desc=" "; else specialty_desc = specialty_desc.trim();
	
	HashMap sqlMap = new HashMap();

	
	
//	String sql_terminology="select a.assess_note_id, b.assess_note_desc, a.specialty_code, c.long_desc specialty_desc  from cp_assess_note_splty a, cp_assess_note b,am_speciality c where a.assess_note_id = b.assess_note_id and a.specialty_code=c.speciality_code    and upper(a.assess_note_id) like upper(?) and upper( b.assess_note_desc) like upper(?) and upper(a.specialty_code) like upper(?) and upper(c.long_desc) like upper(?)";
	String sql_terminology="SELECT a.assess_note_id, b.assess_note_desc, a.specialty_code, c.long_desc specialty_desc  FROM cp_assess_note_splty a, cp_assess_note_LANG_VW b,am_speciality_LANG_VW c WHERE a.assess_note_id = b.assess_note_id AND a.specialty_code=c.speciality_code    AND UPPER(a.assess_note_id) LIKE UPPER(?) AND UPPER( b.assess_note_desc) LIKE UPPER(?) AND UPPER(a.specialty_code) LIKE UPPER(?) AND UPPER(c.long_desc) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID";
	

	sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("assess_note_id");
	displayFields.add("assess_note_desc");
	displayFields.add("specialty_code");
	displayFields.add("specialty_desc");

	
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(assess_note_id+"%");
	chkFields.add( assess_note_desc+"%");
	chkFields.add( specialty_code+"%");
	chkFields.add(specialty_desc+"%");
	chkFields.add(locale);
	


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
  //  int rowCount = 1;
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
	<th width="10%" align='left'><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></th>
	<th width="25%" align='left'><fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/></th>
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
			String str = (String)records.get(colCount) == null ? "" : (String)records.get(colCount);
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/SpecialtyForAssessmentNoteQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html>  

