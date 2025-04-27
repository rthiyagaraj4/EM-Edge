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
*	Created By		:	Sreelatha
*	Created On		:	27 Dec 2004
-->

<!-- AssessmentNoteQueryResult.jsp-->

<%-- JSP Page specific attributes start --%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<HTML>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
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
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj,assess_note_desc,Enabled){
		var assess_note_id	= obj.cells[0].innerText;
		var assess_note_desc	 			=assess_note_desc;
		var Enabled			= Enabled;
				
document.location.href="../../eCP/jsp/AssessmentNoteHeader.jsp?mode=2&assess_note_id="+assess_note_id+"&assess_note_desc="+escape(assess_note_desc)+"&Enabled="+ Enabled;
}
</script>
	<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
try{
	
	String assess_note_id=request.getParameter("assess_note_id")==null ? "":request.getParameter("assess_note_id");
	String assess_note_desc=request.getParameter("assess_note_desc")==null ? "":request.getParameter("assess_note_desc");
	String Enabled = request.getParameter("eff_status")== null ? "":request.getParameter("eff_status");


		
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	
	HashMap sqlMap = new HashMap();

	String strsql = "SELECT assess_note_id ,assess_note_desc ,eff_status FROM CP_ASSESS_NOTE_lang_vw WHERE language_id like ? and UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc ) LIKE UPPER(?) AND UPPER(eff_status) LIKE UPPER(?)  ";

			

sqlMap.put( "sqlData",strsql);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("assess_note_id");
	displayFields.add("assess_note_desc");
	displayFields.add("eff_status");
			
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();
	chkFields.add(locale+"%");
	chkFields.add(assess_note_id+"%");
	chkFields.add(assess_note_desc+"%");
	chkFields.add(Enabled+"%");
		

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

		<th rowspan="2"><fmt:message key="eCP.NoteID.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.NoteDescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr><tr></tr>

			<%
				
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		String link_columns = "1";
		
		 records=(ArrayList) result.get( recCount );
		 assess_note_desc=(String)records.get(1);
		 Enabled=(String)records.get(2);
		 //System.err.println("Enabled in queryresult "+Enabled);
		 		
		
	%>
	<tr onClick='Modify(this,"<%=assess_note_desc%>","<%=Enabled%>");' >
		<%
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);	

			if(colCount == 2 )
				str=str.equals("E")?enableGif:disableGif;
			if(str.equals("")){
		%>
			<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;</td>
		<%}else{%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=str%></td>
		  <%}}//with out hyper link
		}//loop for all tds
		%>
	</tr>
	<%}//L00p for all records%>
	</table>

	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/AssessmentNoteQueryResult.jsp", searched));
		}catch(Exception e ){
			//out.println("here in catch"+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	%>

</body>
</html>

