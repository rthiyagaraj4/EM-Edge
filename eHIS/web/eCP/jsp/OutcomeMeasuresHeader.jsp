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
*	Created By		:	
*	Created On		:	28th Oct 2005
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");
%>
	<LINK rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></LINK>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="javascript" src="../js/OutcomeMeasures.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM>
			<BR>
			<LABEL class="label"><B><fmt:message key="eCP.AssociatedMeasures.label" bundle="${cp_labels}"/></B></LABEL>
			<BR><BR>

<%
	String outcome_code				=		request.getParameter("outcome_code");
	Connection conn					=		null;
	Statement stmt					=		null;
	PreparedStatement pstmt         =       null;//common-icn-0180
	ResultSet rs					=		null;
	//String sql						=		"SELECT OUTCOME_MSR_ID, OUTCOME_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO FROM CP_OUTCOME_MSR WHERE OUTCOME_CODE='"+outcome_code+"'";
	//String sql						=		"SELECT OUTCOME_MSR_ID, OUTCOME_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO FROM CP_OUTCOME_MSR_LANG_VW WHERE OUTCOME_CODE='"+outcome_code+"' AND LANGUAGE_ID ='"+locale+"'";//common-icn-0180
	String sql						=		"SELECT OUTCOME_MSR_ID, OUTCOME_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO FROM CP_OUTCOME_MSR_LANG_VW WHERE OUTCOME_CODE=? AND LANGUAGE_ID =?";//common-icn-0180
	
	String id						=		"";
	String desc						=		"";
	String score					=		"";
	String seqno					=		"";
	String classvalue				=		"";
	int i							=		1;

	
%>
			<TABLE cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
				<TH align="left" width="5%" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></TH>
				<TH align="left"> <fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
				<TH align="left"><fmt:message key="eCP.CutOffScore.label" bundle="${cp_labels}"/></TH>
				<TH align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></TH>

<%
	try{
			conn	=	 ConnectionManager.getConnection(request);
			//common-icn-0180 starts
			//stmt	=	 conn.createStatement();//common-icn-0180	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, outcome_code);
			pstmt.setString(2, locale);
			rs		=	 pstmt.executeQuery();
			//rs		=	 stmt.executeQuery(sql);//common-icn-0180
			//common-icn-0180 ends
			if(rs!=null)
			{
				while(rs.next()){
					id			=	rs.getString("OUTCOME_MSR_ID");
					desc		=	rs.getString("OUTCOME_MSR_DESC");
					score		=	rs.getString("CUT_OFF_SCORE");
					seqno		=	rs.getString("DISP_SEQ_NO");
					if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;

%>			
			<TR>
					<TD align="left" class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><label name="id" onclick="loaddetails('<%=outcome_code%>','<%=id%>','<%=desc%>','<%=score%>','<%=seqno%>')"><%=id%></label></font></TD>
					<TD align="left" class="<%=classvalue%>"><%=desc%></TD>
					<TD align="left" class="<%=classvalue%>"><%=score%></TD>
					<TD align="left" class="<%=classvalue%>"><%=seqno%></TD>
			</TR>
		
<%
			i++;

				}
			}
		}catch(Exception e){
			  System.err.println(e.toString());
				e.printStackTrace();

		 }
		 finally
		{

			if(rs != null) rs.close();
			if(stmt!=null)	  stmt.close();
			if(pstmt!=null)	  pstmt.close();//common-icn-0180
			if(conn != null)
				ConnectionManager.returnConnection(conn,request);					
		}	

%>
				
			</TABLE>
	</FORM>
</BODY>
</HTML>


