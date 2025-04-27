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
*	Purpose 		:	To display Query Result
*	Created By		:	
*	Created On		:	18th July 2005
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
String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
	String variance_code_pr = request.getParameter("VAR_CAUSE_CODE");
	String variance_desc_pr = request.getParameter("VAR_CAUSE_DESC");
	String eff_status_pr = request.getParameter("eff_status");
			
	String sql_variance = "";
	String str ="";
	HashMap sqlMap =null;
	ArrayList chkFields = null;
	HashMap funcMap = null;
	ArrayList result=null;
	ArrayList records=null;

		boolean searched = request.getParameter( "searched" ) == null? false : true;

		try{
		

		variance_code_pr = (variance_code_pr==null || variance_code_pr.equals(""))? "" : variance_code_pr.trim();
		variance_desc_pr = (variance_desc_pr==null || variance_desc_pr.equals(""))? "" : variance_desc_pr.trim();
		eff_status_pr = (eff_status_pr==null || eff_status_pr.equals(""))? "" : eff_status_pr.trim();
		
		//Common parameters.
		sqlMap = new HashMap();
		sql_variance = "SELECT VAR_CAUSE_CODE, VAR_CAUSE_DESC, EFF_STATUS  FROM CP_VARIANCE_CAUSE_lang_vw WHERE UPPER (VAR_CAUSE_CODE) LIKE UPPER (?)   AND UPPER (VAR_CAUSE_DESC) LIKE UPPER (?)   AND UPPER (EFF_STATUS) LIKE UPPER (?) and language_id=?";
		sqlMap.put( "sqlData",sql_variance);
		//out.println("sqlMap "+sqlMap);
		//The fields are going to be displayed
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("VAR_CAUSE_CODE");
		displayFields.add("VAR_CAUSE_DESC");
		displayFields.add("EFF_STATUS");
		
		//The fields are going to be in where condition * shld match with the qry//
		chkFields = new ArrayList();

		chkFields.add(variance_code_pr+"%");
		chkFields.add(variance_desc_pr+"%");
		chkFields.add(eff_status_pr+"%");
		chkFields.add(locale);
		//Adding function related array list into the HashMap//
		funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		//out.println("funcMap "+funcMap);
		//Calling the Result from Common Adaptor as a arraylist.//
		result=new ArrayList();
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request, false);
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
		<th width="15%" align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width="50%" align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width="10%" align='left'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
<%
			records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN";
				else
					classvalue = "QRYODD";				
				records=(ArrayList)result.get(recCount);
				variance_code_pr = (String)records.get(0)==null?"":(String)records.get(0);
				variance_desc_pr = (String)records.get(1)==null?"":(String)records.get(1);
				eff_status_pr = (String)records.get(2)==null?"":(String)records.get(2);
%>
		<TR>
		<td class=<%=classvalue%>><a href="../../eCP/jsp/VarianceCauseAddModify.jsp?mode=2&variance_code=<%=variance_code_pr%>&variance_desc=<%=variance_desc_pr%>&eff_status=<%=eff_status_pr%>"><%=variance_code_pr%></a></td>
		<td class=<%=classvalue%>><%=variance_desc_pr%></td>
<%	 if(eff_status_pr.equals("E")){
%>
		<td align="center" class=<%=classvalue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
<%
	}else{
%>
		<td align="center" class=<%=classvalue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
<%
	}
%>
				</TR>

<%

			}
		out.flush();
		}else{
	%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/VarianceCauseQueryResult.jsp", searched));
		} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>

