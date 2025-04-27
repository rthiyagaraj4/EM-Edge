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
*	File Name		:	ReasonQueryResult.jsp
*	Purpose 		:	To display Query Result
*	Created By		:	nikhil
*	Created On		:	28-01-2005
*/
%>

<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<HTML>
<head>
<%
//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue				=		"";
	String reason_code_pr			=		request.getParameter("reason_code");
	String reason_desc_pr			=		request.getParameter("reason_desc");
	String activity_code_pr			=		request.getParameter("activity_type_code");
	String eff_status_pr			=		request.getParameter("eff_status");
	String sql_reason				=		"";
	String str						=		"";
	HashMap sqlMap					=		null;
	ArrayList chkFields				=		null;
	HashMap funcMap					=		null;
	ArrayList result				=		null;
	ArrayList records				=		null;

		boolean searched			=		request.getParameter( "searched" ) == null? false : true;

		try{
		

		reason_code_pr				=		(reason_code_pr==null || reason_code_pr.equals(""))? "" : reason_code_pr.trim();
		reason_desc_pr				=		(reason_desc_pr==null || reason_desc_pr.equals(""))? "" : reason_desc_pr.trim();
		activity_code_pr			=		(activity_code_pr==null || activity_code_pr.equals(""))? "" : activity_code_pr.trim();
		eff_status_pr				=		(eff_status_pr==null || eff_status_pr.equals(""))? "" : eff_status_pr.trim();

		//Common parameters.
		sqlMap						=		new HashMap();
		//sql_reason = "select a.reason_code, a.reason_desc, a.activity_type_code, b.activity_type_desc, a.eff_status from cp_reason a, cp_activity_type b where a.activity_type_code = b.activity_type_code and upper(a.reason_code) like upper(?) and upper(a.reason_desc) like upper(?) and upper(a.activity_type_code) like upper(?) and upper(a.eff_status) like upper(?)";
		sql_reason = "SELECT a.reason_code, a.reason_desc, a.activity_type_code, b.activity_type_desc, a.eff_status FROM cp_reason_lang_vw a, cp_activity_type_lang_vw b WHERE a.activity_type_code = b.activity_type_code AND a.language_id = ? AND b.language_id = a.language_id AND UPPER(a.reason_code) LIKE UPPER(?) AND UPPER(a.reason_desc) LIKE UPPER(?) AND UPPER(a.activity_type_code) LIKE UPPER(?) AND UPPER(a.eff_status) LIKE UPPER(?)";
		
		sqlMap.put( "sqlData",sql_reason);
		
		//The fields are going to be displayed
		ArrayList displayFields		=		new ArrayList();
		
		
		displayFields.add("reason_code");
		displayFields.add("reason_desc");
		displayFields.add("activity_type_code");
		displayFields.add("activity_type_desc");
		displayFields.add("eff_status");
		
		//The fields are going to be in where condition * shld match with the qry//
		chkFields					=		new ArrayList();

		chkFields.add(locale);
		chkFields.add(reason_code_pr+"%");
		chkFields.add(reason_desc_pr+"%");
		chkFields.add(activity_code_pr+"%");		
		chkFields.add(eff_status_pr+"%");

		//Adding function related array list into the HashMap//

		funcMap						 =		new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		//Calling the Result from Common Adaptor as a arraylist.//
		result=new ArrayList();
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
	<table cellpadding=0 cellspacing=0 border=1 width='98%'>
	<tr>
		<th width="15%" ><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></th>
		<th width="50%" ><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></th>
		<th width="25%" ><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
		<th width="10%" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	
		<%
			//Retriving the records from result arraylist
			records=new ArrayList();
			
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN";
				else
					classvalue = "QRYODD";				
			records				=		(ArrayList)result.get(recCount);

			reason_code_pr		=		(String)records.get(0)==null?"":(String)records.get(0);
			reason_desc_pr		=		(String)records.get(1)==null?"":(String)records.get(1);
			activity_code_pr	=		(String)records.get(2)==null?"":(String)records.get(2);
			eff_status_pr		=		(String)records.get(4)==null?"":(String)records.get(4);
			

		%>
		<tr>
			<%
			for(int colCount=0; colCount<records.size(); colCount++){		
				 str = (String)records.get(colCount)==null?"":(String)records.get(colCount);

				

				if(str.equals("")){
			%>
					<td class=<%=classvalue%>>&nbsp;</td>
			<%} else {%>
				<% if(colCount==0){ %>
					<td class=<%=classvalue%>><a href="../../eCP/jsp/ReasonAddModify.jsp?mode=2&reason_code=<%=reason_code_pr%>"><%=str%></a></td>
				<%continue;}
				else if(colCount==2) continue; 
				else if(colCount==4){
					if(eff_status_pr.equals("E")){%>
						<td align="center" class=<%=classvalue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
						<%continue;}
					else{%>
						<td align="center" class=<%=classvalue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
						<%continue;}
				}%>
				<td class=<%=classvalue%>><%=str%>
				<% } %>

			 <%
				}//end of for loop
			 %>
		</tr>
	<%}//L00p for all records%>
	</table>
	<%
		out.flush();
		}else{
	%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/ReasonQueryResult.jsp", searched));
		} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>

