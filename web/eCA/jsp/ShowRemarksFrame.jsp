<!DOCTYPE html>
<!--  
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
30/03/2023  42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986
05/04/2023    43287        Krishna Pranay   05/04/2023     Ramesh G    CA-ML-MMOH-CRF-1986
---------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<title>
	<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>

<%  
String patientid      =request.getParameter("patient_id");
String  diag_code	  = request.getParameter("diag_code");
String term_set_id	  = request.getParameter("term_set_id");
String term_code_short_desc  = request.getParameter("TERM_CODE_SHORT_DESC");
String occur_srl_no	  = request.getParameter("occur_srl_no");
String apptRemarks = "";

Connection con = null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);	
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		
		try{
			sql	= "select a.curr_remarks from PR_DIAGNOSIS a where a.patient_id = '"+patientid+"' and a.term_set_id = '"+term_set_id+"' and a.term_code = '"+diag_code+"' and a.occur_srl_no = '"+occur_srl_no+"' ";
			
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				apptRemarks	= rs.getString("curr_remarks");
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
  resize: none;
}
</style>
	<div>
<%--  		<textarea  readonly id="curr_remarks" name="curr_remarks" rows="6" cols="46" ><%=apptRemarks%></textarea> --%> 		
           <textarea  readonly id="curr_remarks" name="curr_remarks" rows="6" cols="46" maxlength="2000"><%=apptRemarks%></textarea><!-- 43287 -->
	</div>
<br>
<div align='Right'>	
	<button type="button" onclick="const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();"><fmt:message key="Common.close.label" bundle="${common_labels}"/></button>
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
