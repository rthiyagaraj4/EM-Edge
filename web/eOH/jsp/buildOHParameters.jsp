<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	//String patient_id = "SD00000085";//request.getParameter("patient_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	
	String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;

	StringBuffer chart_data = new StringBuffer();

	if(chart_flag.equals("R")){ // Restorative Chart
		//chart_name = "Restorative Chart";
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else if(chart_flag.equals("P")){ // Periodontal Chart
		//chart_name = "Periodontal Chart";
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//Added by Sharon Crasta on 1/4/2010 for IN017815
	PreparedStatement pstmt_active_chart = null;
	ResultSet rs_active_chart = null;
	String sql_active_chart = "";
	String other_chart_facility_id = "";
	int count_active = 0;
	//

	String func_mode = request.getParameter( "func_mode" ) ;
	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("buildOHParameters")){	
			String sql = "";
			String tooth_numbering_system = request.getParameter("numbering_system");
			String oh_chart_level = request.getParameter("oh_chart_level"); //Added by Sridevi joshi on 4/26/2010 for PE to eleminate query for oh_chart_level which is written below.
			
			//String params = request.getParameter("params");
			String numbering_system_desc = "";
			int mixed_dentition_from_age_yrs = 0;
			int mixed_dentition_from_age_days = 0;
			int mixed_dentition_to_age_yrs = 0;
			int mixed_dentition_to_age_days = 0;
			int rest_chrt_validity_days = 0;
			int grace_period_days = 0;
			String dflt_mixed_dentition_chart = "";
			String deciduous_grace_period_valid = "";
			String record_gingival_status_yn = "";

			String upper_arch_desc = "";
			String lower_arch_desc = "";
			String Q1_id = ""; 	String Q1_desc = "";
			String Q2_id = ""; 	String Q2_desc = "";
			String Q3_id = ""; 	String Q3_desc = "";
			String Q4_id = ""; 	String Q4_desc = "";

			String currentAgeOfPatient = "";
			int patientAge = 0;
			int patientAgeDays = 0;

			String PD_flag = "";
			String chart_type = "";
			String MD_yn = "N";
			//String oh_chart_level = "";

				//Based on the Chart Level the paramters need to be taken.
				/*if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rs = pstmt.executeQuery();
				while (rs != null && rs.next()){
					oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
				}*/

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				if(oh_chart_level.equals("E")){
					// Get the OH Param values and Patient Age
					//Commented by Sharon Crasta on 6/29/2009 for IN011768 and IN011782
					//sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT GET_AGE_YD(DATE_OF_BIRTH,SYSDATE) FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, RECORD_GINGIVAL_STATUS_YN FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
					
					sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT  MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, RECORD_GINGIVAL_STATUS_YN FROM OH_PARAM"; 
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_numbering_system);
					pstmt.setString(3,patient_id);
				//	pstmt.setString(4,facility_id);
				}//	End
				else{ 
					// Get the OH Param values and Patient Age
					//Commented by Sharon Crasta on 6/29/2009 for IN011768 and IN011782
					//sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT GET_AGE_YD(DATE_OF_BIRTH,SYSDATE) FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, RECORD_GINGIVAL_STATUS_YN FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
					
					//Commented and Added by Sharon Crasta on 1/4/2010 for IN017815
					//Taking the facility_id as the value of other_chart_facility_id incase the chart level is facility. 
					//sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT  MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, RECORD_GINGIVAL_STATUS_YN FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
					sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT  MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, RECORD_GINGIVAL_STATUS_YN, FACILITY_ID FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_numbering_system);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,facility_id);
				}
				//
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
					record_gingival_status_yn	    = rs.getString("RECORD_GINGIVAL_STATUS_YN");
					//Added by Sharon Crasta on 1/4/2010 for IN017815
					//Taking the facility_id as the value of other_chart_facility_id incase the chart level is facility.
					if(oh_chart_level.equals("F")){
						other_chart_facility_id	    = rs.getString("FACILITY_ID");
					}
					//End
				}
				
				//Commented and Added by Sharon Crasta on 1/4/2010 for IN017815
				//Taking the facility_id as the value of other_chart_facility_id incase the chart level is facility. 
				if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
				}
				//End

				// get the age in years.
				int patientAgeAtIndex = currentAgeOfPatient.indexOf("Y");
				if(patientAgeAtIndex == -1)
				  patientAge = 0;
				else 
				  patientAge = Integer.parseInt(currentAgeOfPatient.substring(0,patientAgeAtIndex));
			
				if(currentAgeOfPatient.indexOf("D") != -1){
					//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("M")+1,currentAgeOfPatient.indexOf("D")));
					//Commented by Sharon Crasta on 7/8/2009 for IN011768 and IN011782
					//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+1,currentAgeOfPatient.indexOf("D")));
					patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+2,currentAgeOfPatient.indexOf("D")));
				}
			
				//Commented and Added by Sharon Crasta on 7/9/2009 for for IN011768 and IN011782

				//Change made here to consider the Mixed Dentition Period to display chart in this period and set chart_type with corresponding values.
				
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
						//if(dflt_mixed_dentition_chart.equals("D")){
						//	PD_flag = "D"; // Deciduous
						//}
						//else{
						//	PD_flag = "P"; // Permament
						//}
						//MD_yn = "Y";
						//chart_type = "RM";
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
						//if(dflt_mixed_dentition_chart.equals("D")){
						//	PD_flag = "D"; // Deciduous
						//}
						//else{
						//	PD_flag = "P"; // Permament
						//}
						//MD_yn = "Y";
						//chart_type = "RM"; 
					}
				}  

				
				//if(patientAge>=mixed_dentition_from_age_yrs && patientAge<=mixed_dentition_to_age_yrs){ //commenter bt Sridevi Joshi on 31/12/2008 ...when both the yrs are equal that is handled by conditions above
				if(patientAge > mixed_dentition_from_age_yrs && patientAge < mixed_dentition_to_age_yrs){
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
				} */
				// End

				
				if(patientAge < mixed_dentition_from_age_yrs){
						PD_flag = "D"; // Deciduous
						chart_type = "RD";
						deciduous_grace_period_valid = "N";
				}
				else if((patientAge == mixed_dentition_from_age_yrs)&& (patientAgeDays < mixed_dentition_from_age_days) ) {
					PD_flag = "D"; // Deciduous
					chart_type = "RD";
					deciduous_grace_period_valid = "N";
				}
				else if(patientAge >= mixed_dentition_from_age_yrs && patientAge <= mixed_dentition_to_age_yrs){
					if((patientAge == mixed_dentition_from_age_yrs) && (patientAge == mixed_dentition_to_age_yrs)){
						if(patientAgeDays > mixed_dentition_to_age_days) {
							chart_type="RA";
							PD_flag="P";
						}
						//Added by Sharon Crasta on 1/12/2010 for IN017822
						//Considering the grace period if equal to 0, then directly the Mixed chart should open.
						else if(grace_period_days == 0){
						   deciduous_grace_period_valid = "N";
							MD_yn = "Y"; // Mixed Dentition
							chart_type = "RM";
							if(dflt_mixed_dentition_chart.equals("D")){
								PD_flag = "D"; // Deciduous
							}
							else{
								PD_flag = "P"; // Permament
							}
						}//End
						else if((patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)) && ((mixed_dentition_from_age_days + grace_period_days) <= mixed_dentition_to_age_days)){
							deciduous_grace_period_valid = "Y";
							MD_yn = "Y"; // Mixed Dentition
							chart_type = "RD";
							//Commented by Sharon Crasta on 1/5/2010 for IN017815
							//Marking the PD_flag value as the defaulted value in Setup Params once the patient enters the mixed dentition period.
							//PD_flag = "D";
							if(dflt_mixed_dentition_chart.equals("D")){
								PD_flag = "D"; // Deciduous
							}
							else{
								PD_flag = "P"; // Permament
							} //End
							
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
					   
						//Commented and Added by Sharon Crasta on 1/4/2010 for IN017815
						//Taking the facility_id as the value of other_chart_facility_id incase the chart level is facility. 
						if(oh_chart_level.equals("E")){
							sql_active_chart = "SELECT COUNT(*) COUNT_ACTIVE FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'"; 
							
							pstmt_active_chart = con.prepareStatement(sql_active_chart);
							pstmt_active_chart.setString(1,patient_id);

						}//	End
						else{ 
										
							sql_active_chart = "SELECT COUNT(*) COUNT_ACTIVE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'"; 
							
							pstmt_active_chart = con.prepareStatement(sql_active_chart);
							pstmt_active_chart.setString(1,other_chart_facility_id);
							pstmt_active_chart.setString(2,patient_id);
							
						}
						//
						rs_active_chart = pstmt_active_chart.executeQuery();
						while (rs_active_chart != null && rs_active_chart.next()){ 
							count_active = Integer.parseInt(rs_active_chart.getString("COUNT_ACTIVE"));
						}
						//Considering the grace period if equal to 0, then directly the Mixed chart should open.
						if(grace_period_days == 0){
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
						//if(patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)){
						else if((patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)) && count_active >= 1){ //End
							deciduous_grace_period_valid = "Y";
							MD_yn = "Y"; // Mixed Dentition
							chart_type = "RD";
							//Commented by Sharon Crasta on 1/5/2010 for IN017815
							//Once the Mixed Chart is created, then the PD_flag value should be set to the Svalue Given in Setup Params.
							//PD_flag = "D";
							if(dflt_mixed_dentition_chart.equals("D")){
								PD_flag = "D"; // Deciduous
							}
							else{
								PD_flag = "P"; // Permament
							} //End
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
							//PD_flag = "P";
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
				
				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS and ARCH_ID column reference from OH_QUADRANT */
				//sql	= "SELECT A.ARCH_ID, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW AV WHERE AV.LANGUAGE_ID=? AND AV.ARCH_ID = A.ARCH_ID AND AV.NUMBERING_SYSTEM = A.NUMBERING_SYSTEM) ARCH_DESC, B.QUADRANT_SNO, B.QUADRANT_ID, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID =? AND QDV.QUADRANT_ID = B.QUADRANT_ID AND QDV.NUMBERING_SYSTEM = B.NUMBERING_SYSTEM AND QDV.PERMANENT_DECIDUOUS = B.PERMANENT_DECIDUOUS AND QDV.ARCH_ID = B.ARCH_ID) QUADRANT_DESC FROM OH_ARCH A, OH_QUADRANT B WHERE A.NUMBERING_SYSTEM=? AND B.NUMBERING_SYSTEM = A.NUMBERING_SYSTEM AND B.PERMANENT_DECIDUOUS = ? AND A.ARCH_ID = B.ARCH_ID ORDER BY B.QUADRANT_ID"; 
				sql	= "SELECT A.ARCH_ID, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW AV WHERE AV.LANGUAGE_ID=? AND AV.ARCH_ID = A.ARCH_ID AND AV.NUMBERING_SYSTEM = A.NUMBERING_SYSTEM) ARCH_DESC, B.QUADRANT_SNO, B.QUADRANT_ID, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID =? AND QDV.QUADRANT_ID = B.QUADRANT_ID AND QDV.NUMBERING_SYSTEM = B.NUMBERING_SYSTEM ) QUADRANT_DESC FROM OH_ARCH A, OH_QUADRANT B WHERE A.NUMBERING_SYSTEM=? AND B.NUMBERING_SYSTEM = A.NUMBERING_SYSTEM ORDER BY B.QUADRANT_ID"; 

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,tooth_numbering_system);
				//pstmt.setString(4,PD_flag);
				rs = pstmt.executeQuery();
				while (rs != null && rs.next()){

					if( "U".equals(rs.getString("ARCH_ID")))
						upper_arch_desc = rs.getString("ARCH_DESC");

					if( "L".equals(rs.getString("ARCH_ID")))
						lower_arch_desc = rs.getString("ARCH_DESC");

					if( "1".equals(rs.getString("QUADRANT_SNO"))){
						Q1_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
						Q1_desc = rs.getString("QUADRANT_DESC");	// TOP LEFT QUADRANT in any numbering system
					}
					if( "2".equals(rs.getString("QUADRANT_SNO"))){	
						Q2_id = rs.getString("QUADRANT_SNO");		// TOP LEFT QUADRANT in any numbering system
						Q2_desc = rs.getString("QUADRANT_DESC");	// TOP RIGHT QUADRANT in any numbering system
					}
					/*
					if( "3".equals(rs.getString("QUADRANT_SNO"))){
						if(tooth_numbering_system.equals("FDI")){
							Q3_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q3_desc = rs.getString("QUADRANT_DESC");	// BOTTOM LEFT QUADRANT in any numbering system
						}
						else{
							Q4_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q4_desc = rs.getString("QUADRANT_DESC");	// BOTTOM RIGHT QUADRANT in any numbering system
						}
					}
					if( "4".equals(rs.getString("QUADRANT_SNO"))){
						if(tooth_numbering_system.equals("FDI")){
							Q4_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q4_desc = rs.getString("QUADRANT_DESC");	// BOTTOM RIGHT QUADRANT in any numbering system
						}
						else{
							Q3_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q3_desc = rs.getString("QUADRANT_DESC");	// BOTTOM LEFT QUADRANT in any numbering system
						}
					}
					*/

					if( "3".equals(rs.getString("QUADRANT_SNO"))){
						//if(tooth_numbering_system.equals("FDI")){
							Q3_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q3_desc = rs.getString("QUADRANT_DESC");	// BOTTOM LEFT QUADRANT in any numbering system
						//}
						//else{
							//Q4_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							//Q4_desc = rs.getString("QUADRANT_DESC");	// BOTTOM RIGHT QUADRANT in any numbering system
						//}
					}
					if( "4".equals(rs.getString("QUADRANT_SNO"))){
						//if(tooth_numbering_system.equals("FDI")){
							Q4_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							Q4_desc = rs.getString("QUADRANT_DESC");	// BOTTOM RIGHT QUADRANT in any numbering system
						//}
						//else{
							//Q3_id = rs.getString("QUADRANT_SNO");	// TOP LEFT QUADRANT in any numbering system
							//Q3_desc = rs.getString("QUADRANT_DESC");	// BOTTOM LEFT QUADRANT in any numbering system
						//}
					}
				}
				chart_data.append(chart_name+"##"+upper_arch_desc+"##"+lower_arch_desc+"##"+Q1_id+"##"+Q2_id+"##"+Q3_id+"##"+Q4_id+"##"+Q1_desc+"##"+Q2_desc+"##"+Q3_desc+"##"+Q4_desc+"##"+PD_flag+"##"+MD_yn);

				//Commented by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
				//params = "chart_name="+chart_name+"&tooth_numbering_system="+tooth_numbering_system+"&numbering_system_desc="+numbering_system_desc+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&PD_flag="+PD_flag+"&chart_type="+chart_type+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&MD_yn="+MD_yn+"&deciduous_grace_period_valid="+deciduous_grace_period_valid+"&record_gingival_status_yn_param="+record_gingival_status_yn+"&oh_chart_level="+oh_chart_level;
				params = "chart_name="+chart_name+"&tooth_numbering_system="+tooth_numbering_system+"&numbering_system_desc="+numbering_system_desc+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&PD_flag="+PD_flag+"&chart_type="+chart_type+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&MD_yn="+MD_yn+"&deciduous_grace_period_valid="+deciduous_grace_period_valid+"&record_gingival_status_yn_param="+record_gingival_status_yn+"&oh_chart_level="+oh_chart_level;
				//out.println(params);
				out.println(params+"~~"+chart_data);
				
		}
	}catch(Exception e){
		System.err.println("Err Msg from buildOHPramaeter.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		//Added by Sharon Crasta on 1/4/2010 for IN017815
		//Closing the connections of Active Chart
		if(rs_active_chart!=null) rs_active_chart.close();
		if(pstmt_active_chart!=null)pstmt_active_chart.close();
		//End
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
%>

	
