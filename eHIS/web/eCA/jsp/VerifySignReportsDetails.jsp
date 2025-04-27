<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		<title><fmt:message key="eCA.VerifySignReports.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String reportId = request.getParameter("reportId") == null ? "" : request.getParameter("reportId");
			String moduleId = request.getParameter("moduleId") == null ? "" : request.getParameter("moduleId");
			String fromDate = request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
			String toDate = request.getParameter("toDate") == null ? "" : request.getParameter("toDate");
			String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");

			eCA.PatientBannerGroupLine verifySignBean = null;
			verifySignBean = (eCA.PatientBannerGroupLine) getObjectFromBean("verifySignBean","eCA.PatientBannerGroupLine",session);

			ArrayList list = verifySignBean.returnList1();
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='signRepDtlsForm' id='signRepDtlsForm' target='messageFrame' action="../../servlet/eCA.VerifySignReportServlet" method="post">
				<%
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					int cnt = 0;
					String requestDate = "";
					String requestSrlNo = "";
					String patLine = "";
					String mailedUser = "";
					String reportDesc = "";
					String prevRepDesc = "";
					String classValue = "QRYEVEN";
					String chkUnchk = "";
					int cntVal = 0;
					//Boolean flag = false;

					//int	 rowCnt = 0;
					int maxRecordsDisp = 14;
					int	 startIndex = 0;
					int endIndex = 0;
					int	 totalRecordCount = 0;
					String lower_limit =	"";	
					String upper_limit =	"";
					lower_limit =	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
					upper_limit =	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
					startIndex = Integer.parseInt(lower_limit);
					endIndex = Integer.parseInt(upper_limit);			

					StringBuffer repDetails = new StringBuffer("select b.report_id rep_id,b.module_id mod_id,b.report_desc rep_desc, to_char(a.REQUEST_DATE,'dd/mm/yyyy hh24:mi') req_date, to_date(a.REQUEST_DATE,'dd/mm/yyyy hh24:mi') req_order_date, a.REQUEST_SRL_NO req_srl_no, get_patient.get_line_detail (?, a.encounter_id,?) pline, a.USER_ID mailed_user from  SM_REPORT_VERIFY_REQUEST a,sm_report b");
					repDetails.append(" where a.report_id = b.report_id and a.module_id = b.module_id and VERIFIED_OR_REJECTED = 'P' and (b.module_id, b.report_id) in (select module_id, report_id from SM_MAIL_AUTH_USER where user_id=?) ");
					if(!reportId.equals("") && !moduleId.equals(""))
						repDetails.append(" and a.report_id = ? and a.module_id = ? ");	
					if(!patientId.equals("") )
						repDetails.append(" and a.patient_id = ?  ");	
					if(!fromDate.equals("") && !toDate.equals(""))
						repDetails.append(" and a.REQUEST_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'DD/MM/YYYY')+.9999 ");
					else if(!fromDate.equals("") && toDate.equals(""))
						repDetails.append(" and a.REQUEST_DATE > to_date(?,'dd/mm/yyyy')+.9999 ");
					else if(fromDate.equals("") && !toDate.equals(""))
						repDetails.append(" and a.REQUEST_DATE < to_date(?,'dd/mm/yyyy')+.9999 ");
					repDetails.append(" order by b.report_desc, req_order_date");

					try
					{
						con = ConnectionManager.getConnection(request);
						Properties p = (Properties)session.getValue("jdbc");
						String locale = (String) p.getProperty("LOCALE");
						String login_user=(String)session.getValue("login_user");

						ps = con.prepareStatement(repDetails.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						ps.setString(++cnt,facilityId);
						ps.setString(++cnt,locale);
						ps.setString(++cnt,login_user);
						if(!reportId.equals("") && !moduleId.equals(""))
						{
							ps.setString(++cnt,reportId);
							ps.setString(++cnt,moduleId);
						}
						if(!patientId.equals("") )
							ps.setString(++cnt,patientId);
						if(!fromDate.equals("") && !toDate.equals(""))
						{
							ps.setString(++cnt,fromDate);
							ps.setString(++cnt,toDate);
						}
						else if(!fromDate.equals("") && toDate.equals(""))
						{
							ps.setString(++cnt,fromDate);
						}
						else if(fromDate.equals("") && !toDate.equals(""))
						{
							ps.setString(++cnt,toDate);
						}

						rs = ps.executeQuery();

						rs.last();
						totalRecordCount	=	rs.getRow();
						rs.beforeFirst();
						if(totalRecordCount>maxRecordsDisp)
						{
						%>
						<table WIDTH='100%' class='grid'>
							<tr><td CLASS='gridaAta' >&nbsp;</td>	
						<%
							if(startIndex>maxRecordsDisp)
							{  
						%>								
								<td class='gridData'  width='8%'><a class='gridLink' href="../../eCA/jsp/VerifySignReportsDetails.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&reportId=<%=reportId%>&moduleId=<%=moduleId%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>

						<%
							}
							if(totalRecordCount>endIndex)
							{
						%>
								<td class='gridData' align='center' width='8%'><a class='gridLink'  href="../../eCA/jsp/VerifySignReportsDetails.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&reportId=<%=reportId%>&moduleId=<%=moduleId%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
						<%
							}
						%>
							</tr></table>
						<%
							}
						%>

						<table width="100%" class='grid'>
						<tr>
							<th ><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></th>
							<th ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
							<th ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
							<th ><fmt:message key="eCA.MailedUser.label" bundle="${ca_labels}"/></th>
							<th ><fmt:message key="eCA.MailDetails.label" bundle="${ca_labels}"/></th>
						</tr>
						<%

						if(startIndex>1)
							rs.absolute((startIndex-1));

						while(rs.next())
						{
							if(cntVal % 2 == 0) classValue = "QRYEVEN";
							else classValue = "QRYODD";
							requestDate = rs.getString("req_date") == null ? "" : rs.getString("req_date");
							reportId = rs.getString("rep_id") == null ? "" : rs.getString("rep_id");
							moduleId = rs.getString("mod_id") == null ? "" : rs.getString("mod_id");
							requestSrlNo = rs.getString("req_srl_no") == null ? "" : rs.getString("req_srl_no");
							mailedUser = rs.getString("mailed_user") == null ? "" : rs.getString("mailed_user");
							patLine = rs.getString("pline") == null ? "&nbsp;" : rs.getString("pline");
							reportDesc = rs.getString("rep_desc") == null ? "" : rs.getString("rep_desc");
							patLine = patLine.replace('|',',');
							
							if(!prevRepDesc.equals(reportDesc))
								out.println("<tr><td class='gridData' colspan='10'>"+reportDesc+"</td></tr>");

							if(list.contains(requestSrlNo))
								chkUnchk = " checked ";
							else
								chkUnchk = "";

							out.println("<tr>");
							out.println("<td class='gridData'><input type='checkbox' name='chk"+cntVal+"' id='chk"+cntVal+"'  "+chkUnchk+" onclick='addValsToBean(this,chk1"+cntVal+",\""+reportId+"\",\""+moduleId+"\",escape(\""+requestDate+"\"),\""+mailedUser+"\",\""+requestSrlNo+"\",\"V\",\""+cntVal+"\")'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"<br><input type='checkbox' name='chk1"+cntVal+"' id='chk1"+cntVal+"'  "+chkUnchk+" onclick='addValsToBean1(this,chk"+cntVal+",\""+reportId+"\",\""+moduleId+"\",escape(\""+requestDate+"\"),\""+mailedUser+"\",\""+requestSrlNo+"\",\"R\",\""+cntVal+"\")'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+"<input type='hidden' name='reason"+cntVal+"' id='reason"+cntVal+"' value=''><a class='gridLink'  href='javascript:showRemarks(\""+requestSrlNo+"\",\""+cntVal+"\");' name='remark"+cntVal+"' style='display:none' title='View Remarks'>*</a></td>");
							out.println("<td class='gridData'>"+com.ehis.util.DateUtils.convertDate(requestDate,"DMYHM","en",locale)+"</td>");
							out.println("<td class='gridData'>"+patLine+"</td>");
							out.println("<td class='gridData'>"+mailedUser+"</td>");
							out.println("<td class='gridData'><a class='gridLink' href='javascript:showRepBody(\""+requestSrlNo+"\")'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Mail.label","ca_labels")+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../eCA/images/DOCUL.gif' onclick='javascript:showRepText(\""+requestSrlNo+"\")' title='Click here to view attachment'></td>");
							out.println("</tr>");

							prevRepDesc = reportDesc;
							cntVal++;
							if(cntVal >= maxRecordsDisp) break;
						}
					}
					catch(Exception e)
					{
						
						//out.println("Exception at try of VerifySignReportsDetails.jsp --"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
				%>
			</table>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patientId%>'>
		</form>
	</body>
</html>

