<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.MailText.label" bundle="${ca_labels}"/></title>
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
					Clob clb = null;
					StringBuffer displayDataTemp = new StringBuffer();

					String sqlDtls = "select b.REPORT_TEXT rep_text from SM_REPORT_VERIFY_REQUEST a, SM_PDF_GENERATE_REQUEST b where a.REQUEST_SRL_NO = ? and a.REQUEST_SRL_NO = b.REQUEST_SRL_NO";

					try
					{
						con = ConnectionManager.getConnection(request);
						ps = con.prepareStatement(sqlDtls);
						ps.setString(1,requestSrlNo);

						rs = ps.executeQuery();
						while(rs.next())
						{
							clb = rs.getClob("rep_text");
						}

						if(ps != null) ps.close();
						if(rs != null) rs.close();

						if( (clb != null) && (clb.length()>0) )
							displayDataTemp.append(clb.getSubString(1,((int)clb.length())));

					}
					catch(Exception e)
					{
						
						//out.println("Exception at try of VerifySignRepText.jsp--"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
			%>
			<%=displayDataTemp.toString()%>
			<table  border="0" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right'>
						<input type='button' class='button'  name='okBtn' id='okBtn' value='    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   ' onclick='window.close();' align='right'></input>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<script>
	<%if(displayDataTemp.toString().length() <= 0)
	{
	%>
		alert(getMessage("NO_ATTCHMENT_FOUND",'CA'));
		window.close();
	<%
	}
	%>
</script>

