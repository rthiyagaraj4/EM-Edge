<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
05/02/2013    IN033465      Chowminya G      	Chart Recorded As? In Error? Remarks Not Displayed For Viewing In View Error Details 
20/02/2013    IN036093      Chowminya G      	Record charts function, when input error detail at select time. 
-----------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartRecordingViewErrorResults.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
	</head>
	<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String chartId = request.getParameter("chartID") == null ? "" :  request.getParameter("chartID");
		//String recDateTime = request.getParameter("recDateTime") == null ? ""  : request.getParameter("recDateTime");
		String encounterId = request.getParameter("encounterId") == null ? ""  : request.getParameter("encounterId");
		String facilityId = (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
	%>
	<body onscroll='processScroll()' onKeyDown="lockKey()"><!--IN033465-->
		<form name='chartRecViewErrResultForm' id='chartRecViewErrResultForm'>
		<div id="divHeadSep" style="position: absolute;height: 100px;" ><!--IN033465 IN036093 included MarkedDate-->
			<table cellpadding=0 cellspacing=0 border=1 width="100%" class="grid">
			<!--<table  class='grid' width='100%'>			-->
				<tr id="heading">
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 70px;"><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 70px;"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 70px;"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 147px;"> <fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 260px;"> <fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' style="height: 30px;width: 165px;"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><!--IN033465-->
				</tr>
				<%
					String discrMsrID = "";
					String grpID = "";
					String resultNumStr = "";
					String resultUOM = "";
					String resultType = "";
					String errorMarkedDate = "";
					String prevErrorMarkedDate = "";
					String errorMarkedBy = "";
					String classValue = "";
					String prevGrpID	= "";
					String errorRemarks = "";//IN033465
					String recDatetime = "";//IN036093

					int i = 0;

					//String sql = "select a.DISCR_MSR_PANEL_OR_FORM_ID, a.DISCR_MSR_ID, a.DISCR_MSR_RESULT_NUM, a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_STR, a.DISCR_MSR_RESULT_DATA, a.DISCR_MSR_RESULT_TYPE, a.ACCESSION_NUM, G.short_desc PANEL_DESC, I.short_desc DISCR_DESC, a.NORMAL_LOW, a.NORMAL_HIGH, a.CRITICAL_LOW, a.CRITICAL_HIGH, I.NUM_DIGITS_MAX, I.NUM_DIGITS_MIN, I.NUM_DIGITS_DEC, I.ASSOCIATE_SCORE_YN,CA_GET_FORMULA_STRING(b.FORMULA_DEF) FORMULA_DEF, to_char(a.ERROR_MARKED_DATE,'dd/mm/yyyy HH24:MI'), j.APPL_USER_NAME  ERROR_MARKED_BY_NAME from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b, AM_DISCR_MSR G, AM_DISCR_MSR I, SM_APPL_USER J where a.facility_id=? and a.encounter_id=? and a.CHART_ID = ? and nvl(ERROR_YN,'N') != 'N' and b.CHART_ID  =a.CHART_ID   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID AND G.DISCR_MSR_ID=a.DISCR_MSR_PANEL_OR_FORM_ID AND I.DISCR_MSR_ID=a.DISCR_MSR_ID and j.APPL_USER_ID=a.ERROR_MARKED_BY_ID  order by a.ERROR_MARKED_DATE desc, B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";
					
					String sql = "select a.DISCR_MSR_PANEL_OR_FORM_ID, a.DISCR_MSR_ID, a.DISCR_MSR_RESULT_NUM, a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_STR, a.DISCR_MSR_RESULT_DATA, a.DISCR_MSR_RESULT_TYPE, a.ACCESSION_NUM, AM_GET_DESC.AM_DISCR_MSR(A.DISCR_MSR_PANEL_OR_FORM_ID,?,'2') PANEL_DESC, AM_GET_DESC.AM_DISCR_MSR(A.DISCR_MSR_ID,?,'2') DISCR_DESC, a.NORMAL_LOW, a.NORMAL_HIGH, a.CRITICAL_LOW, a.CRITICAL_HIGH, I.NUM_DIGITS_MAX, I.NUM_DIGITS_MIN, I.NUM_DIGITS_DEC, I.ASSOCIATE_SCORE_YN,CA_GET_FORMULA_STRING(b.FORMULA_DEF) FORMULA_DEF, to_char(a.ERROR_MARKED_DATE,'dd/mm/yyyy HH24:MI'), SM_GET_DESC.SM_APPL_USER(A.ERROR_MARKED_BY_ID,?,'1')  ERROR_MARKED_BY_NAME,a.error_remarks, TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy HH24:MI')	from 	ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b, AM_DISCR_MSR I	where 	a.facility_id=? and 	a.encounter_id=? and 	a.CHART_ID = ? 	and 	nvl(ERROR_YN,'N') != 'N' 	and 	b.CHART_ID  =a.CHART_ID   	and 	b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID 	and 	b.DISCR_MSR_ID=a.DISCR_MSR_ID 	AND 	I.DISCR_MSR_ID=a.DISCR_MSR_ID 	order by a.ERROR_MARKED_DATE desc, B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";	
					//Included error remarks - IN033465, Inculded test_observ_dt_tm - IN036093
				
					try
					{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(sql);

						pstmt.setString(1,locale);
						pstmt.setString(2,locale);
						pstmt.setString(3,locale);
						pstmt.setString(4,facilityId);
						pstmt.setString(5,encounterId);
						pstmt.setString(6,chartId);

						res = pstmt.executeQuery();

						while(res.next())
						{
							if(i % 2 == 0)
								classValue = "gridData";
							else
								classValue = "gridData";
							discrMsrID = res.getString("DISCR_DESC") == null ? "" : res.getString("DISCR_DESC");
							grpID = res.getString("PANEL_DESC") == null ? "" : res.getString("PANEL_DESC");
							resultType = res.getString(7) == null ? "" : res.getString(7);
							resultUOM = res.getString(4) == null ? "&nbsp;" : res.getString(4);
							
							if(resultType.equals("N") || resultType.equals("I") || resultType.equals("A"))
							{
								resultNumStr = res.getString(3) == null ? "" : res.getString(3);
							}
							else
							{
								resultNumStr = res.getString(5) == null ? "" : res.getString(5);
							}
								
							if(resultType.equals("D") )
								resultNumStr = com.ehis.util.DateUtils.convertDate(resultNumStr,"DMY","en",locale);
							else if(resultType.equals("E") )
								resultNumStr = com.ehis.util.DateUtils.convertDate(resultNumStr,"DMYHM","en",locale);

							errorMarkedDate = res.getString(20) == null ? "" : res.getString(20);
							errorMarkedDate	= com.ehis.util.DateUtils.convertDate(errorMarkedDate,"DMYHM","en",locale);
							errorMarkedBy = res.getString(21) == null ? "" : res.getString(21);
							errorRemarks = res.getString(22) == null ? "" : res.getString(22); //IN033465
							recDatetime = res.getString(23) == null ? "" : res.getString(23);//IN036093
							recDatetime	= com.ehis.util.DateUtils.convertDate(recDatetime,"DMYHM","en",locale);//IN036093

							if(!prevErrorMarkedDate.equals(errorMarkedDate))
							{
								out.println("<tr>");
								out.println("<td class='columnheadercenter' colspan = '6' align='left'>"+recDatetime+"</td>");
								out.println("</tr>");
								prevErrorMarkedDate = errorMarkedDate;
								prevGrpID = "";
							}

							if(!prevGrpID.equals(grpID))
							{
								out.println("<tr>");
								out.println("<td colspan = '6' class='CACHARTFOURTHLEVELCOLOR'>"+grpID+"</td>");
								out.println("</tr>");
								prevGrpID = grpID;
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'>"+discrMsrID+"</td>");
							out.println("<td class='"+classValue+"'>"+resultNumStr+"</td>");
							out.println("<td class='"+classValue+"'>"+resultUOM+"</td>");
							out.println("<td class='"+classValue+"'>"+errorMarkedBy+"</td>");
							out.println("<td class='"+classValue+"'>"+errorMarkedDate+"</td>");//IN036093
							out.println("<td class='"+classValue+"'>"+errorRemarks+"</td>");	
							out.println("</tr>");
							i++;
						}

						if(res != null) res.close();
						if(pstmt != null) pstmt.close();
					}
					catch(Exception e)
					{
						//out.println("Exception in try of ChartRecordingViewErrorResults.jsp--"+e.toString());//common-icn-0181
						e.printStackTrace();
					}
					finally
					{
						if(con != null) ConnectionManager.returnConnection(con,request);
					}
				%>
			</table>
		</form>
	</body>
</html>

