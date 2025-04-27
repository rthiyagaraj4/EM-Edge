<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	con=ConnectionManager.getConnection(request);

	
	try{
			String patientSeriesId		= request.getParameter("patientSeriesId")==null?"":request.getParameter("patientSeriesId");
			String result				= "";
			String facility_id					= (String)session.getValue("facility_id");
	
			if(!patientSeriesId.equals("")){
				 result	= eAE.AECommonBean.getDownTimePatientsListCount(con,patientSeriesId,facility_id);
			}
			
			out.println(result);
		
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
		if(con != null) {
					
			ConnectionManager.returnConnection(con,request);
		}	
	}                           
%>          
            
            
