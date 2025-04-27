<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ProceduresIntermediate.label" bundle="${ca_labels}"/></title>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../../eCA/js/procedures.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<body onKeyDown='lockKey()'>
	<% 	request.setCharacterEncoding("UTF-8");	%>
	<%
		String procCode = request.getParameter("procCode") == null ? "" : request.getParameter("procCode");
		String facility_id = (String) session.getAttribute("facility_id") == null ? "" :(String)  session.getAttribute("facility_id");
		String encounterid = request.getParameter("encounterID") == null ? "" : request.getParameter("encounterID");
		procCode = procCode.trim();
		String cnt = "";
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		try
		{
			con	=	ConnectionManager.getConnection(request);
			String sql = "select count(*) count  from pr_encounter_procedure where facility_id=? and encounter_id=? and PROC_CODE=? and  ERROR_MARKED_BY_ID is null";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounterid);
			pstmt.setString(3,procCode);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				cnt = rs.getString(1) == null ? "" : rs.getString(1);
				if(!cnt.equals("0"))
				{
					%>
						<script>
							var confirm_flag = window.confirm(getMessage("PROC_ALREADY_EXISTS","CA"));
							if(confirm_flag == true)
					        {
								parent.frame2.document.OPProc_form.dup_chk.value = "Y";
							}
							else
					         {
								parent.frame2.document.OPProc_form.dup_chk.value = "N";
							 }

							if(parent.frame2.document.OPProc_form.dup_chk.value == "Y")
					         {
								parent.frame2.document.OPProc_form.submit();
							 }
						</script>
					<%
				}
				else
				{
				%>
					<script>
						parent.frame2.document.OPProc_form.submit();
					</script>
				<%
				}
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}		
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con, request);
		}
	%>
	</body>
</html>

