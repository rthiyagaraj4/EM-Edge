<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	
	String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;

	if(chart_flag.equals("R")){ // Restorative Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else if(chart_flag.equals("P")){ // Periodontal Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}
%>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String func_mode = request.getParameter( "func_mode" ) ;
	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("buildPerioParameters")){	
			String sql = "";
			String tooth_numbering_system = request.getParameter("numbering_system");
			String oh_chart_level = request.getParameter("oh_chart_level");
			
			String numbering_system_desc = "";
			int mixed_dentition_from_age_yrs = 0;
			int mixed_dentition_from_age_days = 0;
			int mixed_dentition_to_age_yrs = 0;
			int mixed_dentition_to_age_days = 0;
			int rest_chrt_validity_days = 0;
			int grace_period_days = 0;
			String dflt_mixed_dentition_chart = "";
			String deciduous_grace_period_valid = "";
			String currentAgeOfPatient = "";
			int patientAge = 0;
			int patientAgeDays = 0;

			String PD_flag = "";
			String chart_type = "";
			String MD_yn = "N";
			//String oh_chart_level = "";
			
			//Based on the chart level the parameters need to be taken.
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			/*pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
			}*/
			

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			if(oh_chart_level.equals("E")){
				// Get the OH Param values and Patient Age
				sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_numbering_system);
				pstmt.setString(3,patient_id);
			}
			else
			{
				// Get the OH Param values and Patient Age
				sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_numbering_system);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,facility_id);
			 }

			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				numbering_system_desc			= rs.getString("NUMBERING_SYSTEM_DESC");
				mixed_dentition_from_age_yrs	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_YRS"));
				mixed_dentition_from_age_days	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_DAYS"));
				mixed_dentition_to_age_yrs		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_YRS"));
				mixed_dentition_to_age_days		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_DAYS"));
				rest_chrt_validity_days         = Integer.parseInt(rs.getString("REST_CHRT_VALIDITY_DAYS"));
				dflt_mixed_dentition_chart      = rs.getString("DFLT_MIXED_DENTITION_CHART");
				grace_period_days               = Integer.parseInt(rs.getString("DECIDUOUS_GRACE_PERIOD_DAYS"));
				currentAgeOfPatient				= rs.getString("PATIENT_AGE");
			}
			
			// get the age in years.
			int patientAgeAtIndex = currentAgeOfPatient.indexOf("Y");
			if(patientAgeAtIndex == -1)
			  patientAge = 0;
			else 
			  patientAge = Integer.parseInt(currentAgeOfPatient.substring(0,patientAgeAtIndex));

			if(currentAgeOfPatient.indexOf("D") != -1){
				//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("M")+1,currentAgeOfPatient.indexOf("D")));
				//Commented by Sharon Crasta on 7/9/2009 for IN011768 and IN011782
				//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+1,currentAgeOfPatient.indexOf("D")));
				patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+2,currentAgeOfPatient.indexOf("D")));
			}

			//Change made here to consider the Mixed Dentition Period to display chart in this period and set chart_type with corresponding values.
			
			//Commented by Sharon Crasta on 7/9/2009 for IN011768 and IN011782
			/*if(patientAge < mixed_dentition_from_age_yrs){
				PD_flag = "D"; // Deciduous
				chart_type = "RD";
			}
			
			else if(patientAge == mixed_dentition_from_age_yrs){
				if(patientAgeDays < mixed_dentition_to_age_days){
					PD_flag = "D"; // Deciduous
					chart_type = "RD";
				}
				else{
					chart_type = "RM";
				}
			}
			
			if(patientAge > mixed_dentition_to_age_yrs ){
				PD_flag = "P"; // Permament
				chart_type = "RA";
			}
			
			else if(patientAge == mixed_dentition_to_age_yrs ){
				if( patientAgeDays > mixed_dentition_to_age_days){
					PD_flag = "P"; // Permament
					chart_type = "RA";
				}
				else{
					chart_type = "RM";
				}
			}
			
			if(patientAge>=mixed_dentition_from_age_yrs && patientAge<=mixed_dentition_to_age_yrs){
				MD_yn = "Y"; // Mixed Dentition
				chart_type = "RM";
				//out.println("patientAgeDays : "+patientAge + ":"+ mixed_dentition_from_age_yrs);

				if(patientAge == mixed_dentition_from_age_yrs){
					if((grace_period_days -(patientAgeDays-mixed_dentition_to_age_days)) > 0){
						deciduous_grace_period_valid = "Y";
					}
					else{
						deciduous_grace_period_valid = "N";
					}

				}
				
				if(dflt_mixed_dentition_chart.equals("D")){
					PD_flag = "D"; // Deciduous
				}
				else{
					PD_flag = "P"; // Permament
				}
			}*/
			if(patientAge < mixed_dentition_from_age_yrs){
					PD_flag = "D"; // Deciduous
					chart_type = "RD";
			}
			else if((patientAge == mixed_dentition_from_age_yrs)&& (patientAgeDays < mixed_dentition_from_age_days)){
				PD_flag = "D"; // Deciduous
				chart_type = "RD";
			}
			else if(patientAge >= mixed_dentition_from_age_yrs && patientAge <= mixed_dentition_to_age_yrs){
				if((patientAge == mixed_dentition_from_age_yrs) && (patientAge == mixed_dentition_to_age_yrs)){
					if(patientAgeDays > mixed_dentition_to_age_days) {
						chart_type="RA";
						PD_flag="P";
					}
					else if((patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)) && ((mixed_dentition_from_age_days + grace_period_days) <= mixed_dentition_to_age_days)){
						deciduous_grace_period_valid = "Y";
						MD_yn = "Y"; // Mixed Dentition
						PD_flag = "D";
						chart_type = "RD";
					}
					else{
						deciduous_grace_period_valid = "N";
						MD_yn = "Y"; // Mixed Dentition
						chart_type = "RM";
						if(dflt_mixed_dentition_chart.equals("D")){
							PD_flag = "D"; // Deciduous
						}
						else{
							PD_flag = "P"; // Permament
						}
					}
				}
				else if((patientAge == mixed_dentition_from_age_yrs) && (patientAge < mixed_dentition_to_age_yrs)){
					if(patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)){
						deciduous_grace_period_valid = "Y";
						MD_yn = "Y"; // Mixed Dentition
						PD_flag = "D";
						chart_type = "RD";
					}
					else {
						deciduous_grace_period_valid = "N";
						MD_yn = "Y"; // Mixed Dentition
						chart_type = "RM";
						if(dflt_mixed_dentition_chart.equals("D")){
							PD_flag = "D"; // Deciduous
						}
						else{
							PD_flag = "P"; // Permament
						}
					}
				}
				else if((patientAge > mixed_dentition_from_age_yrs) && (patientAge < mixed_dentition_to_age_yrs)){
					deciduous_grace_period_valid = "N";
					MD_yn = "Y"; // Mixed Dentition
					chart_type = "RM";
					if(dflt_mixed_dentition_chart.equals("D")){
						PD_flag = "D"; // Deciduous
					}
					else{
						PD_flag = "P"; // Permament
					}
				}
				else if(patientAge == mixed_dentition_to_age_yrs){ 
						if(patientAgeDays > mixed_dentition_to_age_days) {
							chart_type="RA";
							PD_flag="P";
						}
						else{
							deciduous_grace_period_valid = "N";
							MD_yn = "Y"; // Mixed Dentition
							chart_type = "RM";
							if(dflt_mixed_dentition_chart.equals("D")){
								PD_flag = "D"; // Deciduous
							}
							else{
								PD_flag = "P"; // Permament
							}
						}
					}
				else{
					deciduous_grace_period_valid = "N";
					MD_yn = "Y"; // Mixed Dentition
					chart_type = "RM";
					if(dflt_mixed_dentition_chart.equals("D")){
						PD_flag = "D"; // Deciduous
					}
					else{
						PD_flag = "P"; // Permament
					}
				}
			}
			else if (patientAge == mixed_dentition_to_age_yrs){
				if(patientAgeDays > mixed_dentition_to_age_days){
					chart_type="RA";
					PD_flag="P";
				}
			}
			else if(patientAge > mixed_dentition_to_age_yrs){
				chart_type="RA";
				PD_flag="P";				
			}
			//End
			
			params = "&chart_name="+chart_name+"&tooth_numbering_system="+tooth_numbering_system+"&numbering_system_desc="+numbering_system_desc+"&permanent_deciduous_flag=P"+"&chart_type="+chart_type+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&MD_yn="+MD_yn+"&oh_chart_level="+oh_chart_level;
			
			out.println(params);
			
	}
}catch(Exception e){
	System.err.println("Err Msg from buildPerioPramaeter.jsp "+e);
	System.err.println("func_mode== "+func_mode);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null)pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>

	
