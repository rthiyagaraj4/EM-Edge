<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/CAOpenExternalApplication.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<body onKeyDown='lockKey()'>
	<%
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		String patient_id	= "";
		String event_code	= "";
		String event_group	= "";
		String event_desc	= "";
		String facility_id	= "";
		String specimen_no	= "";
		String template_name = "";

		patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
		event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
		event_desc = request.getParameter("event_desc") == null ? "" : request.getParameter("event_desc");
		facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
		specimen_no = request.getParameter("specimen_no") == null ? "" : request.getParameter("specimen_no");

		try
		{
			con = ConnectionManager.getConnection();
			
			String sql = "select TEMPLATE_NAME from RL_OLE_RESULT_TEXT where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,specimen_no);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,event_group);
			pstmt.setString(5,event_code);

			rs = pstmt.executeQuery();

	%>
		<form name='signRepCriteriaForm' id='signRepCriteriaForm'>
			<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
				<tr>
					<td class='label' width='50%'>
						<fmt:message key="eCA.ViewResults.label" bundle="${ca_labels}"/> :
					</td>
					<td class='label'>
						<%=event_desc%>
					</td>
				</tr>
				<tr>
				<td colspan='2'>
	<%
			while(rs.next())
			{
				template_name = rs.getString(1) == null ? "" : rs.getString(1);
	%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink' href="javascript:openDoc('<%=patient_id%>','<%=event_code%>','<%=event_group%>','<%=event_desc%>','<%=facility_id%>','<%=specimen_no%>','<%=template_name%>');"><%=template_name%></a>
	<%
			}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	%>
				</td>
				</tr>	
			</table>

			<input type=hidden name='locale' id='locale' value='<%=locale%>'>
		</form>
	<%
		}
		catch(Exception e)
		{			
			e.printStackTrace();
		}
		finally
		{
			if (con != null)ConnectionManager.returnConnection(con,request);
		}
	%>
	</body>
</html>

