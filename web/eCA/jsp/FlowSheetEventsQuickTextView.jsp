<!DOCTYPE html>


<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
    String patientid = request.getParameter("patient_id") == null? "" : request.getParameter("patient_id");
    String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounter_id,"eCA.PatientBannerGroupLine",session);
%>
<HTML>
<HEAD>
    <TITLE></TITLE>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->
	
	
<script src='../../eCommon/js/common.js'></script>
<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='staticTitleForCommentDetails()'>
<form name='FlowQuickText' id='FlowQuickText'>
<div id='commentTitleId1'>
<b><fmt:message key="eCA.ExistingComments.label" bundle="${ca_labels}"/></b>
</div>
<table width='100%' id='dataTable' class='grid' >
<TR id='commentTitleId'>
	<td class='COLUMNHEADERCENTER'  nowrap><fmt:message key="eCA.EventDate.label" bundle="${ca_labels}"/></Td>
	<td class='COLUMNHEADERCENTER'  nowrap><fmt:message key="Common.Event.label" bundle="${common_labels}"/></Td>
	<td class='COLUMNHEADERCENTER'  nowrap><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></Td>
	<td class='COLUMNHEADERCENTER'  nowrap><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></Td>		
	<td class='COLUMNHEADERCENTER'  nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></Td>	
</TR>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer strBuffSql = new StringBuffer();
	//Modified by Uma on 12/23/2010 for IN025645
	strBuffSql.append("SELECT TO_CHAR(D.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME , B.LONG_DESC,am_get_desc.am_practitioner(c.practitioner_id,?,'1') practitioner_name ,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE,A.QUICK_TEXT,A.ADDED_DATE FROM CA_PRACTITIONER_QUICK_TEXT A, CR_ENCOUNTER_DETAIL D ,CR_CLIN_EVENT_MAST B, AM_PRACTITIONER C WHERE  A.HIST_REC_TYPE = ? and A.CONTR_SYS_ID = ? and A.ACCESSION_NUM = ? and A.CONTR_SYS_EVENT_CODE = ? and A.ADDED_BY_ID=C.PRACTITIONER_ID AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.CONTR_SYS_ID=A.CONTR_SYS_ID AND D.ACCESSION_NUM=A.ACCESSION_NUM AND D.CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND  d.HIST_REC_TYPE=B.HIST_REC_TYPE and d.EVENT_CODE=B.EVENT_CODE  AND d.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE");

  	String quick_text = "";
	String strEventDate = "";
	String strAddedDate = "";
	ArrayList keyList = manageEmailBean.returnSortList();
	Collections.sort(keyList);
	int listSize = keyList.size();

	StringTokenizer strTok = null;
	String listValue = "";
	String enc_id = "";
	String histRecType = "";
	String sortedEventDate = "";
	String contrSysId = "";
	String accNum = "";
	String contrSysEventCode = "";
	int counter =0;

	String tempStrValue = "",classValue="gridData";

	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strBuffSql.toString());
		for(int i=0;i<listSize;i++)
		{
			listValue = (String)keyList.get(i);
			strTok = new StringTokenizer(listValue,"`");

			while(strTok.hasMoreTokens())
			{
				enc_id = (String) strTok.nextToken();
				histRecType = (String) strTok.nextToken();
				sortedEventDate = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}
			//Added by Uma on 12/23/2010 for IN025645
			pstmt.setString(1,locale);
			pstmt.setString(2,histRecType);
			pstmt.setString(3,contrSysId);
			pstmt.setString(4,accNum);
			pstmt.setString(5,contrSysEventCode);
	
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				strEventDate = rs.getString(1);
				strAddedDate = rs.getString(4);
				//strEventDate = rs.getString(1)==null?"":rs.getString(1);
				//strAddedDate = rs.getString(4)==null?"":rs.getString(4);
				strEventDate = com.ehis.util.DateUtils.convertDate(strEventDate,"DMYHM","en",locale);
				strAddedDate = com.ehis.util.DateUtils.convertDate(strAddedDate,"DMY","en",locale);

				counter++;
				out.println("<TR>");
				out.println("<TD nowrap class='"+classValue+"'>"+strEventDate+"</TD>");
				out.println("<TD nowrap class='"+classValue+"'>"+rs.getString(2)+"</TD>");
				out.println("<TD nowrap class='"+classValue+"'>"+rs.getString(3)+"</TD>");
				out.println("<TD nowrap class='"+classValue+"'>"+strAddedDate+"</TD>");
				quick_text = rs.getString(5);

					
				if(quick_text.length() > 15)
				{
					tempStrValue = quick_text.substring(0,14);
					quick_text = replaceSpecialChar(quick_text);					
					out.println("<TD nowrap class='"+classValue+"'><a class='gridLink' href=\"javaScript:ShowRemarks('"+counter+"')\">"+tempStrValue+"...</a></TD><input type='hidden' id='result"+counter+"' value=\""+quick_text+"\">");

				}
				else
				{
					out.println("<TD nowrap class='"+classValue+"'>"+quick_text+"</TD>");			
				}
				out.println("</TR>");			
			}		
		}//end of for
	}//end of try
	catch(Exception ee)
	{
		//out.println("Exception in try - list of FlowSheetEventsQuickTextView.jsp -"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|");
		return resultStr;
	}
%>
</TABLE>
</FORM>
</BODY>
</HTML>

