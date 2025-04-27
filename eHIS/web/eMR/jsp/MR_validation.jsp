<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	try
	{
		
	con = ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		String termsetid=request.getParameter("termsetid");
		String callfunction=request.getParameter("callfunction");
		String sensitive_yn="";
		String notifiable_yn="";
		String diag_spec_yn="";
		String proc_spec_yn="";

		if(callfunction.equals("sensvity/notifiable")){
			String querySen_notif="select SENSITIVITY_APPL_YN,NOTIFICATION_APPL_YN,DIAG_SPEC_YN,PROC_SPEC_YN from  MR_TERM_SET  where  term_set_id =?";
			
			
			pstmt = con.prepareStatement(querySen_notif);
			pstmt.setString(1,termsetid);
			rs = pstmt.executeQuery() ;
			if(rs!=null)
		{
			if(rs.next())
			{
				sensitive_yn = rs.getString("SENSITIVITY_APPL_YN");
				notifiable_yn = rs.getString("NOTIFICATION_APPL_YN");
				/*Monday, January 25, 2010 18499 , 18499*/
				diag_spec_yn = rs.getString("DIAG_SPEC_YN");
				if(diag_spec_yn == null) diag_spec_yn = "N";
				proc_spec_yn = rs.getString("PROC_SPEC_YN");
				if(proc_spec_yn == null) proc_spec_yn = "N";
				/**/
			}
		}
		
		if (rs != null)   rs.close();
					pstmt.close();
						

		}

		if(callfunction.equals("sensvity/notifiable")){

			/*Monday, January 25, 2010 18499 , 18499*/
			//out.println(sensitive_yn+"&^&"+notifiable_yn);
			out.println(sensitive_yn+"&^&"+notifiable_yn+"&^&"+diag_spec_yn+"&^&"+proc_spec_yn);
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}

	%>

	
