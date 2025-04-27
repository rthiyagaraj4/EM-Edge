<!DOCTYPE html>

<%@page import="eBL.Common.BlRepository"%>
<%@ page   import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,java.text.*;" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%
/*
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V201216             11086        NMC-JD-CRF-0087-TF-US001         Mohana Priya K
 -->
*/

	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	Properties p = (Properties) session.getValue("jdbc");
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id"); 
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	
	try{
		con = ConnectionManager.getConnection();
		if("insert".equalsIgnoreCase(func_mode)){	
			String reportSql = "{ call   bleclaims.proc_main_eclaims_data(?,?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?) }";
			String p_facility_id  = request.getParameter("p_facility_id");
			String p_patient_id   = request.getParameter("p_patient_id");
			String p_episode_type = request.getParameter("p_episode_type");
			String p_encounter_id = request.getParameter("p_encounter_id");
			String p_fm_date	  = request.getParameter("p_fm_date");
			String p_to_date 	  = request.getParameter("p_to_date");
			String p_payer 		  = request.getParameter("p_payer");
			String p_payer_name   = request.getParameter("p_payer_name");
			String p_policy       = request.getParameter("p_policy");
			String p_specialty    = request.getParameter("p_specialty");
			String p_language_id  = request.getParameter("p_language_id");

			cstmt = con.prepareCall(reportSql);
			cstmt.setString(1, p_facility_id);
			cstmt.setString(2, p_patient_id);
			cstmt.setString(3, p_episode_type);
			cstmt.setString(4, p_encounter_id);
			cstmt.setString(5, p_fm_date);
			cstmt.setString(6, p_to_date);
			cstmt.setString(7, p_payer);
			cstmt.setString(8, p_payer_name);
			cstmt.setString(9, p_policy);
			cstmt.setString(10, p_specialty);
			cstmt.setString(11,p_language_id);
			
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
		
			String errorMsg = cstmt.getString(13);
			String errorCode = cstmt.getString(14);	
			
			String returnValue= "";
			if(errorCode != null || errorMsg != null){
				returnValue = errorMsg+":::"+errorCode;
			}else{
				returnValue ="";
			}
			
			System.err.println("returnValue  "+returnValue);
			out.println(returnValue); 
		}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from EClaimValidation.jsp "+e);
			con.rollback();
	}
	finally{
			ConnectionManager.returnConnection(con,request);
	}
%>


	
