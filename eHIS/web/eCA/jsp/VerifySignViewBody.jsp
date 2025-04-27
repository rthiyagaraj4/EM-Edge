<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.MailBody.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			//String reportId = request.getParameter("reportId") == null ? "" : request.getParameter("reportId");
			//String moduleId = request.getParameter("moduleId") == null ? "" : request.getParameter("moduleId");
			String requestSrlNo = request.getParameter("requestSrlNo") == null ? "" : request.getParameter("requestSrlNo");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='verifySignRepTextForm' id='verifySignRepTextForm'>
			<%
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					String toId = "";
					String ccId = "";
					String subj = "";
					String bodyTxt = "";

					String sqlDtls = "select FAX_MAIL_ADDRESS to_id, FAX_MAIL_CC_ADDRESS cc_id, subject, body body_text from SM_REPORT_VERIFY_REQUEST  where REQUEST_SRL_NO = ?";
					try
					{
						con = ConnectionManager.getConnection(request);
						ps = con.prepareStatement(sqlDtls);
						ps.setString(1,requestSrlNo);

						rs = ps.executeQuery();
						while(rs.next())
						{
							toId = rs.getString("to_id") == null ? "" : rs.getString("to_id");
							ccId = rs.getString("cc_id") == null ? "" : rs.getString("cc_id");
							subj = rs.getString("subject") == null ? "" : rs.getString("subject");
							bodyTxt = rs.getString("body_text") == null ? "" : rs.getString("body_text");							
						}

						if(ps != null) ps.close();
						if(rs != null) rs.close();
					}
					catch(Exception e)
					{
						
						//out.println("Exception at try of VerifySignViewBody.jsp--"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
			%>
			<table  border="0" width="100%" cellspacing='0' cellpadding='5'>
				<tr>
					<td class='label' width='10%' align='right'><B><fmt:message key="Common.to.label" bundle="${common_labels}"/> : </B></td>
					<td class='label' align='left'><B><%=toId%></B></td>
				</tr>
				<%if(!ccId.equals("")) {%>
				<tr>
					<td class='label' width='10%' align='right'><B><fmt:message key="eCA.CC.label" bundle="${ca_labels}"/> : </B></td>
					<td class='label' align='left'><B><%=ccId%></B></td>
				</tr>
				<%}%>
				<tr>
					<td class='label' width='10%' align='right'><B><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/> : </B></td>
					<td class='label' align='left'><B><%=subj%></B></td>
				</tr>
				<tr>
					<td colspan='2'>
						<%=bodyTxt%>
					</td>
				<tr>
					<td align='right' colspan='2'>
						<input type='button' class='button'  name='okBtn' id='okBtn' value='    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   ' onclick='window.close();' align='right'></input>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<script>
	if('<%=toId%>' == '' && '<%=subj%>' == '')
	{
		alert(getMessage('NO_MAIL_DATA_FOUND','CA'));
		window.close();
	}
</script>

