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
<%@page import="java.util.*, eCP.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*"%>
<jsp:useBean id="TermCodeEvalMeasure" class="webbeans.eCommon.RecordSet" scope="session"/>

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
	    String locale=(String)session.getAttribute("LOCALE");
        String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<LINK rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></LINK>	
	<SCRIPT src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="javascript" src="../js/TermCodeEvalMeasure.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM name="termCodeEvalMeasureResultForm" id="termCodeEvalMeasureResultForm" action="../../servlet/eCP.TermCodeEvalMeasuresServlet" method="POST" target="messageFrame" >
<%
	String termSet=request.getParameter("termSet");
	String termCode=request.getParameter("termCode");
	String loadvalue=request.getParameter("loadvalue")==null?"":request.getParameter("loadvalue");
	String flag="";
	String id="";
	String desc="";
	String score="";
	String seq_no="";
	String classvalue = "QRYEVEN";

	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt = null;//common-icn-0180
	ResultSet rs=null;
	
	//String sql="SELECT TERM_CODE_MSR_ID, TERM_CODE_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO FROM CP_TERM_CODE_MSR WHERE TERM_SET_ID='"+termSet+"' AND TERM_CODE='"+termCode+"'";//common-icn-0180
	String sql="SELECT TERM_CODE_MSR_ID, TERM_CODE_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO FROM CP_TERM_CODE_MSR WHERE TERM_SET_ID=? AND TERM_CODE=?";//common-icn-0180

	ArrayList Tablist = null;
	/*ArrayList sessionList		=		(ArrayList)TermCodeEvalMeasure.getRecordSetHandle();
	if(sessionList.size()>0){
		Tablist=(ArrayList)TermCodeEvalMeasure.getObject(0);
	}*/
	try
	{
		if(loadvalue.equals("1"))
		{
			Tablist=new ArrayList();
			conn	=	 ConnectionManager.getConnection(request);
			//stmt	=	 conn.createStatement();//common-icn-0180
			pstmt = conn.prepareStatement(sql);//common-icn-0180
			pstmt.setString(1,termSet);//common-icn-0180
			pstmt.setString(2,termCode);//common-icn-0180
			//rs		=	 stmt.executeQuery(sql);//common-icn-0180
			rs		=	 pstmt.executeQuery();//common-icn-0180
			if(rs!=null)
			{
				while(rs.next()){
					id=rs.getString("TERM_CODE_MSR_ID");
					desc=rs.getString("TERM_CODE_MSR_DESC");
					score=rs.getString("CUT_OFF_SCORE");
					seq_no=rs.getString("DISP_SEQ_NO");
					Tablist.add(id);
					Tablist.add(desc);
					Tablist.add(score);
					Tablist.add(seq_no);
					Tablist.add("U");
				}
			}
			TermCodeEvalMeasure.putObject(Tablist);
		}else
		{
			Tablist=(ArrayList)TermCodeEvalMeasure.getObject(0);
		}
	}
	catch(Exception e)
	{
		System.err.println(e.toString());
		e.printStackTrace();
	 }
	 finally
	{
		if(rs != null) rs.close();
		if(stmt!=null)	  stmt.close();
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);					
	}	
	//System.err.println("Tablist in result************ "+Tablist);
%>
			<BR>
			<LABEL class="label"><B><fmt:message key="eCP.AssociatedMeasures.label" bundle="${cp_labels}"/></B></LABEL>
			<BR><BR>
			<TABLE cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
				<TH align="left" width="5%" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></TH>
				<TH align="left"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
				<TH align="left"><fmt:message key="eCP.CutOffScore.label" bundle="${cp_labels}"/></TH>
				<TH align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></TH>
<%
	if(Tablist.size()>0)
	{
		for(int i=0;i<Tablist.size();i=i+5){
			flag=(String)Tablist.get(i+4);
			
			if(flag.equals("I")||flag.equals("U")){

				if ( classvalue.equals("QRYODD"))
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

				 id=(String)Tablist.get(i);
				 desc=(String)Tablist.get(i+1);
				 score=(String)Tablist.get(i+2);
				 seq_no=(String)Tablist.get(i+3);

%>
	<TR>
		<TD class="<%=classvalue%>"onmouseover="changeCursor(this);"><font class='HYPERLINK'><label name="id" onclick="loadIddetails('<%=id%>','<%=desc%>','<%=score%>','<%=seq_no%>')"><%=id%></label></font></TD>
		<TD class="<%=classvalue%>"><%=desc%></TD>
		<TD class="<%=classvalue%>"><%=score%></TD>
		<TD class="<%=classvalue%>"><%=seq_no%></TD>
		
	</TR>
<%
			}
		}

	}
%>
		</TABLE>
		<INPUT TYPE="hidden" name="termSet" id="termSet" value="<%=termSet%>">
		<INPUT TYPE="hidden" name="termCode" id="termCode" value="<%=termCode%>">
	</FORM>
</BODY>
</HTML>


