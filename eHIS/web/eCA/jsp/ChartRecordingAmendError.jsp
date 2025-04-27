<!DOCTYPE html>
<!-- 
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
13/7/2011     101            Chowminya G      	Incident No: IN027022 - <MC module Charting - amend(replace) display issue> 
08/02/2013    IN033465      Chowminya G      	Chart Recorded As? In Error? Remarks Not Displayed For Viewing In View Error Details 
-----------------------------------------------------------------------
*/
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="chartAmendErrorBean" class="eCA.ChartRecordingAmendErrorBean" scope="page"/>
<html>
	<head>
		<title><fmt:message key="eCA.AmendError.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<%
		String currDate = request.getParameter("currentDate") == null ? "" : request.getParameter("currentDate");
		String currDate_th = com.ehis.util.DateUtils.convertDate(currDate,"DMYHM","en",locale);
		String chartID = request.getParameter("chartID") == null ? "" : request.getParameter("chartID");
		String functionFrom = request.getParameter("functionFrom") == null ? "" : request.getParameter("functionFrom");
		String patientId = request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
		//String encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
		//String defaultYN = request.getParameter("defaultYN") == null ? "N" : request.getParameter("defaultYN");
		//String facilityID = request.getParameter("facilityID") == null ? "" : request.getParameter("facilityID");
		String practName = (String) session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
		//---[101]/start---
		String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
		String modifyYN = request.getParameter("modifyYN") == null ? "" : request.getParameter("modifyYN");
		String qs = request.getParameter("qs") == null ? "" : request.getParameter("qs");
		//---[101]/end---

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		//String sqlChartName = "select short_desc from ca_chart where chart_id = ?";
		String sqlChartName = "select	CA_GET_DESC.CA_CHART(?,?,'2') short_desc FROM DUAL";
		String chartName = "";
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sqlChartName);
			pstmt.setString(1,chartID);
			pstmt.setString(2,locale);

			res = pstmt.executeQuery();
			while(res.next())
			{
			chartName = res.getString(1) == null ? "" : res.getString(1);
			}
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception eeee)
		{
			//out.println("Exception in ChartRecordingAmendError.jsp -- chart Name --"+eeee.toString());//common-icn-0181
	               eeee.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	%>
		<body onKeyDown="lockKey()">
		<form name='chartRecordingAmendErrorForm' id='chartRecordingAmendErrorForm' action = "../../servlet/eCA.ChartRecordingServlet?sentFrom=amendError " method='post' target="messageFrame">
			<table cellspacing=0 cellpadding=3 border=0 id='titleTable' width='100%'>
				<tr>
					<td class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> </td><td  class='label'><b><%=chartName%></b></td>
					<td class='label' ><fmt:message key="eCA.MarkallasError.label" bundle="${ca_labels}"/></td><td ><input type='checkbox' name='allError' id='allError' onclick='markAllError(this)'></td>					
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/> </td><td  class='label'><b><%=currDate_th%></b></td>
					<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td ><input type='text' size='30' maxlength='60' name='errorRemarks' id='errorRemarks' onblur='remarksToAll(this)' ></td> <!-- IN033465 -->
				</tr>
				<tr>
					<td class='label' ><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/> </td><td ><input type='text' name='markedErrorBy' id='markedErrorBy' value='<%=practName%>' readonly></input><input type='button' class='button' name='practName' id='practName' onclick='selectPractName()' value='?'><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
					<td colspan='2'></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='columnheadercenter'  colspan='4'><font color='yellow'><fmt:message key="eCA.SelectedForErrorAmend.label" bundle="${ca_labels}"/></font></td>
				</tr>				
			</table>
			<table class='grid'  id='tableId' width="100%">
				<tr>
					<td class='columnheadercenter' width='20%'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' width='23%'><fmt:message key="Common.OldValue.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' width='10%'><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' width='13%'><fmt:message key="eCA.AmendError.label" bundle="${ca_labels}"/> <div style='display:none' id='newValID'><fmt:message key="eMP.newvalues.label" bundle="${mp_labels}"/></div></td>
					<td class='columnheadercenter' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/><img align=center src='../../eCommon/images/mandatory.gif'></img></td><!-- IN033465 -->
				</tr>
				<%
					chartAmendErrorBean.loadGrpDiscrId(request,chartID,currDate,patientId,locale);
					chartAmendErrorBean.addtoHashMap(request,chartID,currDate,patientId,locale);
					StringBuffer display = new StringBuffer();
					display = chartAmendErrorBean.amendErrorScreen(request,chartID,currDate,patientId,locale);
					out.println(display.toString());
				%>
				<input type='hidden' name='userIDHidden' id='userIDHidden' value='<%=practName%>'>
				<input type='hidden' name='functionFrom' id='functionFrom' value='<%=functionFrom%>'>
				<!--//---[101]/start--->
				<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
				<input type='hidden' name='contr_mod_accession_num' id='contr_mod_accession_num' value='<%=contr_mod_accession_num%>'>
				<input type='hidden' name='modifyYN' id='modifyYN' value='<%=modifyYN%>'>
				<input type='hidden' name='qs' id='qs' value='<%=qs%>'>
				<!--//---[101]/end--->
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		</form>
	</body>
</html>

