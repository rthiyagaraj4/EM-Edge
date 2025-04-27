<!DOCTYPE html>
<!--  
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
09/05/2023  42489        srinivasa          09/05/2023     Ramesh G   
---------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<title>
	 <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>


<% 
String Val      =request.getParameter("Val");
String []fields = Val.split("~");
 String prov_id      = fields[0];
String  phys_prov_reln_name	  =  fields[1];
phys_prov_reln_name=phys_prov_reln_name.replace("BLANK"," ");
String patient_id	  = fields[2];
String curr_remarks = "";
Connection con = null;
PreparedStatement pstmt	= null;
ResultSet rs 			= null;
		try{
			con		= ConnectionManager.getConnection(request);	
			String sql				= "";
			sql	= "select REMARKS from ca_encntr_pract_reln_vw where PHYS_PROV_ID= '"+prov_id+"' and PHYS_PROV_RELN_NAME = '"+phys_prov_reln_name+"'  and PATIENT_ID= '"+patient_id+"'";		
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs!=null && rs.next()){
			curr_remarks	= rs.getString("REMARKS");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				con.close();
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
	<div>
<%--  		<textarea  readonly id="curr_remarks" name="curr_remarks" rows="6" cols="46" ><%=apptRemarks%></textarea> --%> 		
           <textarea  readonly id="curr_remarks" name="curr_remarks" rows="6" cols="46" maxlength="2000"><%=curr_remarks%></textarea>
	</div>
<br>
<div align='Right'>	
	<button type="button" onclick="javascript:window.close()"><fmt:message key="Common.close.label" bundle="${common_labels}"/></button>
</div>
</body>
</HTML>

