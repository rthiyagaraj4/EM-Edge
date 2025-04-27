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

			String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String fromDate = request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
			String toDate = request.getParameter("toDate") == null ? "" : request.getParameter("toDate");
			String login_user=(String)session.getValue("login_user");

			eCA.PatientBannerGroupLine verifySignBean = null;
			verifySignBean = (eCA.PatientBannerGroupLine) getObjectFromBean("verifySignBean","eCA.PatientBannerGroupLine",session);
			verifySignBean.clearBean();
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		

		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='signRepTreeForm' id='signRepTreeForm'>
			<table width="100%" class='grid' align='center'>
				<tr>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				</tr>
			<%
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;

				String moduleId = "";
				String firstModId = "";
				String reportId = "";
				String firstRepId = "";
				String reportDesc = "";
				String countRep = "0";
				String classValue = "QRYEVEN";
				int i = 0;
				int cnt = 0;
				int cntVal = 0;
				try
				{
					con = ConnectionManager.getConnection(request);
					//Properties p = (Properties)session.getValue("jdbc");
					//String locale = (String) p.getProperty("LOCALE");

					StringBuffer sqlModRep = new StringBuffer("select distinct a.MODULE_ID mod_id, a.REPORT_ID rep_id, b.report_desc rep_desc, count(*) count_rep  from SM_REPORT_VERIFY_REQUEST a, SM_REPORT b where a.report_id = b.report_id and VERIFIED_OR_REJECTED = 'P' and (b.module_id, b.report_id) in (select module_id, report_id from SM_MAIL_AUTH_USER where user_id=?) ");
					if(!patient_id.equals(""))
						sqlModRep.append(" and a.patient_id = ?");
					if(!fromDate.equals("") && !toDate.equals(""))
						sqlModRep.append(" and a.REQUEST_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')+.9999");
					else if(!fromDate.equals("") && toDate.equals(""))
						sqlModRep.append(" and a.REQUEST_DATE > to_date(?,'dd/mm/yyyy')+.9999");
					else if(fromDate.equals("") && !toDate.equals(""))
						sqlModRep.append(" and a.REQUEST_DATE < to_date(?,'dd/mm/yyyy')+.9999");

					sqlModRep.append(" GROUP BY a.MODULE_ID, a.REPORT_ID,b.report_desc order by b.report_desc");

					ps = con.prepareStatement(sqlModRep.toString());
					ps.setString(++i,login_user);
					if(!patient_id.equals(""))
						ps.setString(++i,patient_id);
					if(!fromDate.equals("") && !toDate.equals(""))
					{
						ps.setString(++i,fromDate);
						ps.setString(++i,toDate);
					}
					else if(!fromDate.equals("") && toDate.equals(""))
						ps.setString(++i,fromDate);
					else if(fromDate.equals("") && !toDate.equals(""))
						ps.setString(++i,toDate);

					rs = ps.executeQuery();

					while(rs.next())
					{
						if(cntVal % 2 == 0) classValue = "QRYEVEN";
						else classValue = "QRYODD";

						moduleId = rs.getString("mod_id") == null ? "" : rs.getString("mod_id");
						reportId = rs.getString("rep_id") == null ? "" : rs.getString("rep_id");
						if(cntVal == 0)
						{
							firstModId = moduleId;
							firstRepId = reportId;
						}
						reportDesc = rs.getString("rep_desc") == null ? "" : rs.getString("rep_desc");
						countRep = rs.getString("count_rep") == null ? "0" : rs.getString("count_rep");						
						out.println("<tr>");
						out.println("<td class='gridData'>");
						out.println("<a class='gridLink' href='javascript:signRepDetailPage(\""+reportId+"\",\""+moduleId+"\",\"clearMsg\")'>"+reportDesc + "</a>&nbsp;(" +countRep+ ")");
						out.println("</td>");
						out.println("</tr>");
						cnt += Integer.parseInt(countRep);
						cntVal++;
					}
					if(cntVal % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					out.println("<tr>");
					out.println("<td class='CAGROUP'>");
					out.println("<a class='gridLink'  href='javascript:signRepDetailPage(\"\",\"\",\"clearMsg\")'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>(" +cnt+ ")");
					out.println("</td>");
					out.println("</tr>");
				}// end of try
				catch(Exception e)
				{
					
					//out.println("Exception at try of VerifySignReportsTree.jsp--"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}//end of catch
				finally
				{
					if(con != null) ConnectionManager.returnConnection(con,request);
				}//end of finally
			%>
			</table>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			<input type='hidden' name='fromDate' id='fromDate' value='<%=fromDate%>'>
			<input type='hidden' name='toDate' id='toDate' value='<%=toDate%>'>
		</form>
	</body>
</html>
<script>
	signRepDetailPage('<%=firstRepId%>','<%=firstModId%>','');
</script>

