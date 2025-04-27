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
//This file is saved on 08/02/2006.
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
	String variance_code_pr = request.getParameter("VAR_REASON_CODE");
	String variance_desc_pr = request.getParameter("VAR_REASON_DESC");
	String variancecause_code_pr = request.getParameter("VAR_CAUSE_CODE");
	String variancecause_desc_pr = request.getParameter("VAR_CAUSE_DESC");
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
		

		variance_code_pr	  = (variance_code_pr==null || variance_code_pr.equals(""))? "" : variance_code_pr.trim();
		variance_desc_pr	  = (variance_desc_pr==null || variance_desc_pr.equals(""))? "" : variance_desc_pr.trim();
		variancecause_code_pr = (variancecause_code_pr==null || variancecause_code_pr.equals(""))? "" : variancecause_code_pr.trim();
		variancecause_desc_pr = (variancecause_desc_pr==null || variancecause_desc_pr.equals(""))? "" : variancecause_desc_pr.trim();
		eff_status_pr         = (eff_status_pr==null || eff_status_pr.equals(""))? "" : eff_status_pr.trim();
		
		//Common parameters.
		sqlMap = new HashMap();
//		sql_variance = "SELECT A.VAR_REASON_CODE, A.VAR_REASON_DESC, B.VAR_CAUSE_CODE,B.VAR_CAUSE_DESC, A.EFF_STATUS  FROM CP_VARIANCE_REASON A, CP_VARIANCE_CAUSE B WHERE A.VAR_CAUSE_CODE = B.VAR_CAUSE_CODE   AND UPPER (A.VAR_REASON_CODE) LIKE UPPER (?)   AND UPPER (A.VAR_REASON_DESC) LIKE UPPER (?)   AND UPPER (B.VAR_CAUSE_CODE) LIKE UPPER (?)   AND UPPER (B.VAR_CAUSE_DESC) LIKE UPPER (?)   AND UPPER (A.EFF_STATUS) LIKE UPPER (?)";
		sql_variance = "SELECT A.VAR_REASON_CODE, A.VAR_REASON_DESC, B.VAR_CAUSE_CODE,B.VAR_CAUSE_DESC, A.EFF_STATUS  FROM CP_VARIANCE_REASON_lang_vw A, CP_VARIANCE_CAUSE_lang_vw B WHERE A.VAR_CAUSE_CODE = B.VAR_CAUSE_CODE   AND UPPER (A.VAR_REASON_CODE) LIKE UPPER (?)   AND UPPER (A.VAR_REASON_DESC) LIKE UPPER (?)  AND UPPER (B.VAR_CAUSE_CODE) LIKE UPPER (?)   AND UPPER (B.VAR_CAUSE_DESC) LIKE UPPER (?)   AND UPPER (A.EFF_STATUS) LIKE UPPER (?) AND A.LANGUAGE_ID = ? AND B.LANGUAGE_ID = A.LANGUAGE_ID";
		
		sqlMap.put( "sqlData",sql_variance);
		//out.println("sqlMap "+sqlMap);
		//The fields are going to be displayed
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("VAR_REASON_CODE");
		displayFields.add("VAR_REASON_DESC");
		displayFields.add("VAR_CAUSE_CODE");
		displayFields.add("VAR_CAUSE_DESC");
		displayFields.add("EFF_STATUS");
		
		//The fields are going to be in where condition * shld match with the qry//
		chkFields = new ArrayList();

		chkFields.add(variance_code_pr+"%");
		chkFields.add(variance_desc_pr+"%");
		chkFields.add(variancecause_code_pr+"%");
		chkFields.add(variancecause_desc_pr+"%");
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
		//	System.err.println("result "+result);
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
		<th  align='left'><fmt:message key="eCP.VarianceReasonCode.label" bundle="${cp_labels}"/></th>
		<th  align='left'><fmt:message key="eCP.VarianceReasonDescription.label" bundle="${cp_labels}"/></th>
		<th  align='left'><fmt:message key="eCP.VarianceCauseCode.label" bundle="${cp_labels}"/></th>
		<th  align='left'><fmt:message key="eCP.VarianceCauseDescription.label" bundle="${cp_labels}"/></th>
		<th  align='left'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
				variancecause_code_pr = (String)records.get(0)==null?"":(String)records.get(2);
				variancecause_desc_pr = (String)records.get(1)==null?"":(String)records.get(3);
				eff_status_pr = (String)records.get(2)==null?"":(String)records.get(4);
%>
		<TR>
		<td class=<%=classvalue%>><a href="../../eCP/jsp/VarianceReasonAddModify.jsp?mode=2&variance_code=<%=variance_code_pr%>&variance_desc=<%=variance_desc_pr%>&eff_status=<%=eff_status_pr%>&varianceCausecode=<%=variancecause_code_pr%>"><%=variance_code_pr%></a></td>
		<td class=<%=classvalue%>><%=variance_desc_pr%></td>
		<td class=<%=classvalue%>><%=variancecause_code_pr%></td>
		<td class=<%=classvalue%>><%=variancecause_desc_pr%></td>
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
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/VarianceReasonQueryResult.jsp", searched));
		} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>

