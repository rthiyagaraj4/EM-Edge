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
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
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
try{

	
	String assess_note_id = request.getParameter("assess_note_id");
	String assess_note_desc		= request.getParameter("assess_note_desc");
	String age_group_code		= request.getParameter("age_group_code");
	String long_desc		= request.getParameter("long_desc");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(assess_note_id == null || assess_note_id.equals("null")) assess_note_id =" "; else assess_note_id = assess_note_id.trim();
	if(assess_note_desc == null || assess_note_desc.equals("null")) assess_note_desc =" "; else assess_note_desc = assess_note_desc.trim();
	if(age_group_code == null || age_group_code.equals("null")) age_group_code =" "; else age_group_code = age_group_code.trim();
	if(long_desc == null || long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();

	//Common parameters.
	HashMap sqlMap = new HashMap();

//	String sql_assess="select a.assess_note_id, b.assess_note_desc, a.age_group_code, c.long_desc, decode(c.gender,'M','Male','F','Female','U','Unknown') gender,c.min_age,c.max_age  from CP_ASSESS_NOTE_AGE_GROUP a, cp_assess_note b, am_age_group c where a.assess_note_id = b.assess_note_id and a.age_group_code=c.age_group_code  and upper(a.assess_note_id) like upper(?) and upper(b.assess_note_desc) like upper(?) and upper(a.age_group_code) like upper(?) and upper(c.long_desc) like upper(?)";
	String sql_assess="SELECT a.assess_note_id, b.assess_note_desc, a.age_group_code, c.long_desc, DECODE(c.gender,'M','Male','F','Female','U','Unknown') gender,c.min_age,c.max_age  FROM CP_ASSESS_NOTE_AGE_GROUP a, cp_assess_note_LANG_VW b, am_age_group_LANG_VW c WHERE a.assess_note_id = b.assess_note_id AND a.age_group_code=c.age_group_code  AND UPPER(a.assess_note_id) LIKE UPPER(?) AND UPPER(b.assess_note_desc) LIKE UPPER(?) AND UPPER(a.age_group_code) LIKE UPPER(?) AND UPPER(c.long_desc) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID";
	
	sqlMap.put( "sqlData",sql_assess);
	ArrayList displayFields = new ArrayList();
	displayFields.add("assess_note_id");	
	displayFields.add("assess_note_desc");
	displayFields.add("age_group_code");
	displayFields.add("long_desc");
	
	displayFields.add("gender");
	displayFields.add("min_age");
	displayFields.add("max_age");

	//Gender	Min Age	  Max Age 
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add( assess_note_id+"%");
	chkFields.add( assess_note_desc+"%");
	chkFields.add( age_group_code+"%");
	chkFields.add( long_desc+"%");
	chkFields.add( locale);


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
	<th width="7%" align='center'><fmt:message key="eCP.AssessmentNoteId.label" bundle="${cp_labels}"/></th>
	<th width="20%" align='center'><fmt:message key="eCP.AssessmentNoteDescription.label" bundle="${cp_labels}"/></th>
	<th width="10%" align='center'><fmt:message key="Common.agegroupcode.label" bundle="${common_labels}"/></th>
	<th width="20%" align='center'><fmt:message key="Common.agegroupdesc.label" bundle="${common_labels}"/></th>
	<th width="10%" align='center'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th width="7%" align='center'><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></th>
	<th width="7%" align='center'><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></th>
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/AgeGroupForAssessNoteQueryResult.jsp", searched));
	} catch ( Exception e )	{

		e.printStackTrace() ;
		//out.print(e);//COMMON-ICN-0181
		throw e ;
	} %>
</body>
</html>  

