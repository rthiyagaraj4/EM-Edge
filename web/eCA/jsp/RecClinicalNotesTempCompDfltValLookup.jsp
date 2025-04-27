<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id"); 
	//String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id"); 
	String hist_rec_type = request.getParameter("hist_rec_type") == null ? "" : request.getParameter("hist_rec_type");
	String event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
	String old_hist_time_frame_val = request.getParameter("old_hist_time_frame_val") == null ? "" : request.getParameter("old_hist_time_frame_val");
	String old_hist_time_frame_unit = request.getParameter("old_hist_time_frame_unit") == null ? "" : request.getParameter("old_hist_time_frame_unit");
	//String comp_name = request.getParameter("comp_name") == null ? "" : request.getParameter("comp_name");
	String compPrompt = request.getParameter("compPrompt") == null ? "" : request.getParameter("compPrompt");

	String eventDateTime = "";
	String value = "";
	String classValue = "";
	int result = 0;
	
%>
<html>	
	<head>
		<title><fmt:message key="eCA.LookUpfor.label" bundle="${ca_labels}"/> <%=compPrompt%></title>
		 <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()' onscroll='staticTitle()'>
		<form name='recClinCompDefLookUpForm' id='recClinCompDefLookUpForm'>
			<table width='100%' cellpadding='3' cellspacing='0' border='1'>
				<tr id='tableTitle' style='position:relative'>
					<td class='columnheadercenter' ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.RecordedOn.label" bundle="${common_labels}"/></td>
				</tr>
				<%
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet res = null;
					//ResultSet res1 = null;
					StringBuffer sqlBuffer = new StringBuffer();
					try
					{
						con = ConnectionManager.getConnection(request);
						
						sqlBuffer.append("select to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi'),decode(HIST_DATA_TYPE,'NUM',to_char(RESULT_NUM),RESULT_STR) RESULT from cr_encounter_detail where patient_id=? and hist_rec_type=? and CONTR_SYS_EVENT_CODE=? ");

						if(old_hist_time_frame_unit.equals("L"))
						{
							sqlBuffer.append("and event_date=(select max(event_date) from cr_encounter_detail where patient_id=? and hist_rec_type=? and CONTR_SYS_EVENT_CODE=?)");
						}
						else
						{
							sqlBuffer.append("and EVENT_DATE between sysdate-decode(? ,'D',1,'M',30,'Y',365,'W',7)*? and sysdate");
						}

						pstmt = con.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1,patientId);
						pstmt.setString(2,hist_rec_type);
						pstmt.setString(3,event_code);

						if(old_hist_time_frame_unit.equals("L"))
						{
							pstmt.setString(4,patientId);
							pstmt.setString(5,hist_rec_type);
							pstmt.setString(6,event_code);
						}
						else
						{
							pstmt.setString(4,old_hist_time_frame_unit);
							pstmt.setString(5,old_hist_time_frame_val);
						}

						res = pstmt.executeQuery();
				/*		int j = 0;
						while(res.next())
						{
							j++;
						}
						res.beforeFirst();*/
						while(res.next())
						{
							eventDateTime = res.getString(1);
							value = res.getString("RESULT") == null ? "" : res.getString("RESULT");

							if(result % 2 == 0)
							{
								classValue = "QRYEVEN";
							}
							else
							{							
								classValue = "QRYODD";
							}
						%>
							<tr>
								<td class='<%=classValue%>'><a href onClick= "ShowHistoryValue('<%=eventDateTime%>','<%=value%>')"  style="cursor: hand" ><%=value%></a></td>
								<td class='<%=classValue%>'><%=eventDateTime%></td>
							</tr>
						<%
							result++;
						}
						if(result == 1)
						{
						%>
							<script>
							    var val = "<%=eventDateTime%>~<%=value%>";
								window.returnValue = val;
								window.close();
							</script>
						<%
						}
						else if(result == 0)
						{
						%>
							<script>
							alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							top.window.close();
							</script>
						<%
						}
						if(pstmt != null) pstmt.close();
						if(res != null) res.close();
					}//end of try
					catch(Exception e)
					{
						//out.println("Exception in RecClinicalNotesTempCompDfltValLookup.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
				%>
				</table>
				
		</form>
	</body>
</html>

