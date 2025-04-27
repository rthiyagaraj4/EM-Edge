<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1			V221130								TH-KW-CRF-0084.1  		Mohana Priya K
 -------------------------------------------------------------------------------------------
*/ %>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>
<%
String functionMode = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


try {
	con = ConnectionManager.getConnection();
	functionMode = request.getParameter("functionMode");
	if (null == functionMode) {
		functionMode = "";
	}
	System.err.println("functionMode "+functionMode);
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = (String) p.getProperty("login_user");
	HttpSession httpSession = request.getSession(false);	
	String facility_id = (String)httpSession.getValue("facility_id");
	
	if("insuranceClearanceSts".equals(functionMode)){ 
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId insuranceClearanceSts "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		System.err.println("facility_id "+facility_id);
		pstmt=con.prepareStatement("select  blinstransactions.get_ins_clearance_status(?,?,?,?,?) from dual");
		pstmt.setString(1, facility_id);
		pstmt.setString(2, patient_Id);
		pstmt.setString(3,episodeType);
		pstmt.setString(4, episodeId);
		pstmt.setString(5, visitId);
		rs = pstmt.executeQuery();
		String status="";
		while (rs.next()) {
			status =rs.getString(1);
		}
		
		System.err.println("status:::"+status);
		out.println(status);
		
	}else if ("cancelInsuranceClearance".equals(functionMode)) {
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId cancelInsuranceClearance "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		CallableStatement cstmt = con.prepareCall("{ call blinstransactions.cancel_ins_clearance(?,?,?,?,?,?,?) }");
			
		cstmt.setString(1, facility_id);
		cstmt.setString(2, episodeType);
		cstmt.setString(3,patient_Id);
		cstmt.setString(4, episodeId);
		cstmt.setString(5, visitId);
		cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt.execute();
				
		String cancelSts = cstmt.getString(6);
		String errmessage = cstmt.getString(7);	
		
		if(null != errmessage && !"".equals(errmessage)){
			System.err.println("errmessage:::"+errmessage);
			out.println(errmessage);
		}
		System.err.println("cancelSts:::"+cancelSts);
		out.println(cancelSts);
		con.commit();
		
		if(cstmt!=null) cstmt.close();
	}else if("get_bill_ip_indicator".equals(functionMode)){ 
		String visitId = checkNull(request.getParameter("visitId"));
		String episodeType = checkNull(request.getParameter("episodeType"));
		String episodeId = checkNull(request.getParameter("episodeId"));
		String patient_Id = checkNull(request.getParameter("patientId"));
		
		System.err.println("visitId get_bill_ip_indicator "+visitId);
		System.err.println("episodeType "+episodeType);
		System.err.println("episodeId "+episodeId);
		System.err.println("patient_Id "+patient_Id);
		pstmt=con.prepareStatement("select  bl_get_bill_gen_dtls.get_bill_ip_indicator(?,?,?,?) from dual");
		pstmt.setString(1, facility_id);
		pstmt.setString(2, patient_Id);
		pstmt.setString(3,episodeType);
		pstmt.setString(4, episodeId);
		rs = pstmt.executeQuery();
		String dischargebill="";
		while (rs.next()) {
			dischargebill =rs.getString(1);
		}
		
		System.err.println("dischargebill:::"+dischargebill);
		out.println(dischargebill);
		
	}
}catch(Exception e){
	e.printStackTrace();
	System.err.println("Exception from InsuranceClearanceAjax.jsp :" + e);
}finally {
		ConnectionManager.returnConnection(con, request);
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
%>
<%!
public String checkNull(String inputString)
{
	if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
		inputString = "";
	return inputString;
}
%>
