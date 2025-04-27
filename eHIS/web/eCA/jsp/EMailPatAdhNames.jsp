<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String email_to_pat_id_yn = request.getParameter("email_to_pat_id_yn") == null ? "" : request.getParameter("email_to_pat_id_yn");	
	String email_to_any_id_yn = request.getParameter("email_to_any_id_yn") == null ? "" : request.getParameter("email_to_any_id_yn");	
	String email_to_regd_id_yn = request.getParameter("email_to_regd_id_yn") == null ? "" : request.getParameter("email_to_regd_id_yn");	
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/EMail.js'></script>
		<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='patEMailAdhForm' id='patEMailAdhForm' >
			<table border=0 cellspacing=0 cellpadding='3' width='100%' align=center bgcolor='white'  frame='box'>
				<tr>
					<td>
	<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String emailId = "";

		String sqlPatEmail = "select email_id from mp_patient where patient_id = ?";
		if(email_to_pat_id_yn.equals("Y"))
		{

			try
			{
				con = ConnectionManager.getConnection(request);

				pstmt = con.prepareStatement(sqlPatEmail);
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					emailId = rs.getString(1) == null ? "" : rs.getString(1);
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}//end of try
			catch(Exception e)
			{
				
				//out.println("Exception in try of EMailPatAdhNames.jsp-- "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		%>
			<table  width='100%' cellspacing='5' cellpadding='3'  border=1 bordercolor=blue bgcolor='white'>
				<tr>
					<td >
							<table  width='100%' cellspacing='0' cellpadding='3'  border=0>
								<tr>
									<td class='label'><b><fmt:message key="eCA.ToPatient.label" bundle="${ca_labels}"/></b></td>
								</tr>
								<tr>
									<td class='label' align='center' width='18%'><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.EmailId.label" bundle="${ca_labels}"/> : </td>
									<td><a href='javascript:addPatMailId(escape("<%=emailId%>"))'><%=emailId%></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			<%}
				if(email_to_any_id_yn.equals("Y"))
				{
				%>
				<table  width='100%' cellspacing='5' cellpadding='3'  border=1 bordercolor=blue bgcolor='white'>
						<tr>
							<td>
									<table  width='100%' cellspacing='0' cellpadding='3'  border=0>
										<tr>
											<td class='label'><b><fmt:message key="eCA.ToAdhocUser.label" bundle="${ca_labels}"/></b></td>
										</tr>
										<tr>
											<td class='label' width='18%'><fmt:message key="eCA.RegisteredRecipientID.label" bundle="${ca_labels}"/></td>
											<td><input type='text' name='mailer_id' id='mailer_id' size=4 maxlength=4 onkeypress="return CheckForSpecChars(event)"  onBlur='ChangeUpperCase(this)'><img src='../../eCommon/images/mandatory.gif'></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td class='label' width='18%'><fmt:message key="eCA.RegisteredRecipientName.label" bundle="${ca_labels}"/></td>
											<td><input type='text' name='mailer_name' id='mailer_name' size=30 maxlength=100  onBlur="return makeValidString(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td class='label' width='18%'><fmt:message key="eCA.EmailId.label" bundle="${ca_labels}"/></td>
											<td><input type='text' name='email_id' id='email_id' maxlength='100' size='34.5' onBlur="return chkValidEmail(this);"><img src='../../eCommon/images/mandatory.gif'></td>
											<td align='right'><input type='button' class='button'  value='Insert' name='adhInsert' id='adhInsert' onclick='insertAdh()'></td>
										</tr>
										<tr>
											
										</tr>
									</table>
							</table>
						</td>
					</tr>
				</table>
			<%}%>
		</form>
	</body>
</html>
<script>
	if('<%=email_to_regd_id_yn%>' == 'Y')
	{
		if('<%=email_to_pat_id_yn%>' != 'Y' && '<%=email_to_any_id_yn%>' == 'Y' )
			parent.patAdhRegFrameset.rows = '27%,*,10%';
		if('<%=email_to_any_id_yn%>' != 'Y' && '<%=email_to_pat_id_yn%>' == 'Y')
			parent.patAdhRegFrameset.rows = '15%,*,10%';	
	}
	if('<%=email_to_regd_id_yn%>' != 'Y')
		parent.patAdhRegFrameset.rows = '*,0%,10%';
</script>

