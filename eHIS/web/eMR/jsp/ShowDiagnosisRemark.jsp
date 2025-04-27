<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<title>
	<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>

<%

	String Patient_Id = checkForNull(request.getParameter("Patient_Id"));
	String term_code	  = checkForNull(request.getParameter("term_code"));
	String term_set_id = checkForNull(request.getParameter("term_set_id"));
	String term_set_desc = checkForNull(request.getParameter("term_set_desc"));
	String occur_srl_no = checkForNull(request.getParameter("occur_srl_no"));
	
	String apptRemarks = "";

	Connection con = null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);	
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		
		try{
			sql	= "select a.curr_remarks from PR_DIAGNOSIS a where a.patient_id = '"+Patient_Id+"' and a.term_set_id = '"+term_set_id+"' and a.term_code = '"+term_code+"' and a.occur_srl_no = '"+occur_srl_no+"' ";
			
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				apptRemarks	= checkForNull(rs.getString("curr_remarks"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getApptRemarks - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		
		
%>
<body>
<br>
<style>
textarea {
    display: block;
    margin-left: 5px;
}
</style>
	<table>
	<tr>
		<td><textarea  readonly id="DiagnosisRemark" name="DiagnosisRemark" rows="6" cols="46" maxlength="2000" ><%=apptRemarks%></textarea></td>
		</tr>
	</table>
<br>
<div align='Right'>	
	<button type="button" onclick="javascript:window.close()"><fmt:message key="Common.close.label" bundle="${common_labels}"/></button>
</div>
</body>
</HTML>
<%			
	}
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
