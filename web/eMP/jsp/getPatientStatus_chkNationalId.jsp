<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn			= null;
	conn=ConnectionManager.getConnection(request);
	try{
		
		String facility_id		= (String) session.getValue( "facility_id" ) ;
		String action			= request.getParameter("action")==null?"":request.getParameter("action");
		
		if(action.equals("chk_valid_patient")){
			String patientId		= request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String national_id_chk	= request.getParameter("national_id_chk")==null?"":request.getParameter("national_id_chk");
			webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			patdata.setFacility_id(facility_id);
			String pat_status = patdata.CheckStatus(conn,patientId);
			
			pat_status		= pat_status==null?"":pat_status;
			
			if(pat_status.equals("") && national_id_chk.equals("Y")){
				
				HashMap ResultParamHashMap = new HashMap();
				HashMap sqlColumns = new HashMap();
				sqlColumns.put("NATIONAL_ID_NO","S");
				sqlColumns.put("CITIZEN_YN","S");
				sqlColumns.put("PAT_DTLS_UNKNOWN_YN","S");
				String whereClause	= "where patient_id='"+patientId+"'";
				ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
				String NATIONAL_ID_NO = (String) ResultParamHashMap.get("NATIONAL_ID_NO");
				NATIONAL_ID_NO		= NATIONAL_ID_NO==null?"":NATIONAL_ID_NO;

				String citizen_yn = (String) ResultParamHashMap.get("CITIZEN_YN");
				citizen_yn		= citizen_yn==null?"N":citizen_yn;

				String pat_dtls_unknown_yn = (String) ResultParamHashMap.get("PAT_DTLS_UNKNOWN_YN");
				pat_dtls_unknown_yn		= pat_dtls_unknown_yn==null?"N":pat_dtls_unknown_yn;


				if(citizen_yn.equals("N")){
					pat_status	= "NRIC_FOR_NONCITIZEN";
				}else if(pat_dtls_unknown_yn.equals("Y")){
					pat_status	= "CAN_NOT_MERGE_UNKNOWN_PATIENT";
				}else if(!NATIONAL_ID_NO.equals("")){
					pat_status	= "NATIONAL_ID_EXISTS";
				}
				sqlColumns.clear();
				ResultParamHashMap.clear();
			}

			out.println(pat_status);
		}else if(action.equals("chk_national_id")){
			String nationalIdStatus	= "";
			String nationalId				= request.getParameter("nationalId")==null?"":request.getParameter("nationalId");
			String invoke_routine			= request.getParameter("invoke_routine")==null?"":request.getParameter("invoke_routine");
			String invoke_routine_name		= request.getParameter("invoke_routine_name")==null?"":request.getParameter("invoke_routine_name");
			String nat_id_check_digit_id	= request.getParameter("nat_id_check_digit_id")==null?"":request.getParameter("nat_id_check_digit_id");
			String result					= "";
			HashMap ResultParamHashMap = new HashMap();
			HashMap sqlColumns = new HashMap();
			sqlColumns.put("patient_id","S");
			String whereClause	= "where national_id_no='"+nationalId+"'";
			ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
			nationalIdStatus = (String) ResultParamHashMap.get("patient_id");
			sqlColumns.clear();
			ResultParamHashMap.clear();

			nationalIdStatus		= nationalIdStatus==null?"":nationalIdStatus;

			if(!nationalIdStatus.equals("")){
				nationalIdStatus	= "DUP_NAT_ID";
			}
			
			if(nationalIdStatus.equals("") && !nat_id_check_digit_id.equals("")){
				sqlColumns.put("program_name","S");
				String whereClause1						= "where scheme_id='"+nat_id_check_digit_id+"'";
				ResultParamHashMap						= CommonBean.getParamDetails(sqlColumns,whereClause1,"MP_CHECK_DIGIT_SCHEME",conn);
				String nat_id_check_digit_function		= (String) ResultParamHashMap.get("program_name");
				sqlColumns.clear();
				ResultParamHashMap.clear();
				if(!nat_id_check_digit_id.equals("")){
					nationalIdStatus	= CommonBean.verifyCheckDigitSchemeForNationalId(conn,nationalId,nat_id_check_digit_function);
					if(nationalIdStatus.equals("N")){
						nationalIdStatus	= "INVALID_NAT_ID";
					}else{
						nationalIdStatus	= "";
					}
				}
			}

			if(nationalIdStatus.equals("") && invoke_routine.equals("Y") && !invoke_routine_name.equals("")){
				nationalIdStatus	= CommonBean.verifyNationalId(conn,nationalId);
			}

			out.println(nationalIdStatus);
		}

		
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
		if(conn != null) {
			ConnectionManager.returnConnection(conn,request);
		}	
	}                           
%>          
            
            
