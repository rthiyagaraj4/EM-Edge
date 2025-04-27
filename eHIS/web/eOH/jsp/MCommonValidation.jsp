<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

//	String facility_id      = (String) session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;
	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("populateTreatmentTypes")){	
			String splty_module_id	= request.getParameter( "splty_module_id" ) ;
			String sql				= "";		
			String trmt_category_type = "";
			String trmt_category_desc = "";
			StringBuffer trmt_category_code_desc = new StringBuffer();
			
				sql = "SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TREATMENT_CATEGORY_TYPE WHERE SPLTY_MODULE_ID = ? ORDER BY 2";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,splty_module_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					trmt_category_type = rst.getString("TRMT_CATEGORY_TYPE");
					trmt_category_desc = rst.getString("TRMT_CATEGORY_TYPE_DESC");
					trmt_category_code_desc.append(trmt_category_type+"##"+trmt_category_desc);
					trmt_category_code_desc.append("~");
				}
				out.println(trmt_category_code_desc);
		}else if(func_mode.equalsIgnoreCase("populateConditionTypes")){	
			String splty_module_id	= request.getParameter( "splty_module_id" ) ;
			String sql				= "";		
			String condition_type = "";
			String condition_type_desc = "";
			StringBuffer condition_code_desc = new StringBuffer();
			
				sql = "SELECT CONDITION_TYPE, CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE WHERE SPLTY_MODULE_ID = ? ORDER BY 2";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,splty_module_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					condition_type = rst.getString("CONDITION_TYPE");
					condition_type_desc = rst.getString("CONDITION_TYPE_DESC");
					condition_code_desc.append(condition_type+"##"+condition_type_desc);
					condition_code_desc.append("~");
				}
				out.println(condition_code_desc);
		}else if(func_mode.equalsIgnoreCase("populateSpeciality")){	
			String splty_module_id	= request.getParameter( "splty_module_id" ) ;
			String sql				= "";		
			String speciality_code = "";
			String short_desc = "";
			StringBuffer speciality_code_desc = new StringBuffer();
			
				sql = "SELECT A.SPECIALITY_CODE SPECIALITY_CODE, B.SHORT_DESC SHORT_DESC FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY_LANG_VW B WHERE A.MODULE_ID = ? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND LANGUAGE_ID = ? ORDER BY 2";
				pstmt = con.prepareStatement(sql);
					pstmt.setString(1,splty_module_id);
					pstmt.setString(2,locale);
					rst=pstmt.executeQuery();
					while(rst!=null && rst.next()){
						speciality_code=rst.getString("SPECIALITY_CODE");
						short_desc=rst.getString("SHORT_DESC");
					speciality_code_desc.append(speciality_code+"##"+short_desc);
					speciality_code_desc.append("~");
				}
				out.println(speciality_code_desc);
		}else if(func_mode.equalsIgnoreCase("populateTreatmentCodes")){	
			String splty_module_id	= request.getParameter( "splty_module_id" ) ;
			String sql				= "";		
			String trmt_category_code = "";
			String short_desc = "";
			StringBuffer trmt_category_code_desc = new StringBuffer();
			
				sql = "SELECT TRMT_CATEGORY_CODE, TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY WHERE SPLTY_MODULE_ID = ? ORDER BY 2";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,splty_module_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					trmt_category_code = rst.getString("TRMT_CATEGORY_CODE");
					short_desc = rst.getString("TRMT_CATEGORY_DESC");
					trmt_category_code_desc.append(trmt_category_code+"##"+short_desc);
					trmt_category_code_desc.append("~");
				}
				out.println(trmt_category_code_desc);
		}else if(func_mode.equalsIgnoreCase("populateMultipleTrmtYN")){	
			String treatment_code	= request.getParameter( "treatment_code" ) ;
			String sql				= "";		
			String multiple_yn = "";
				sql = "SELECT MULTIPLE_TASK_YN FROM OH_TREATMENT WHERE TRMT_CODE = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,treatment_code);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					multiple_yn = rst.getString("MULTIPLE_TASK_YN");
				}
				out.println(multiple_yn);
		}
		else if(func_mode.equalsIgnoreCase("countOfCheckedObjects")){	
			String treatment_code	= request.getParameter( "treatment_code" ) ;
			String sql				= "";		
			String count = "";
				sql = "SELECT COUNT(*) COUNT FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,treatment_code);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					count = rst.getString("COUNT");
				}
				out.println(count);
		}
		else if(func_mode.equalsIgnoreCase("VALIDATESEQNO")){	
			String treatment_code	= request.getParameter( "treatment_code" ) ;
			String seq_no	= request.getParameter( "seq_no" ) ;
			String sql = "";		
			String count = "";
				sql = "select count(1)  from OH_TREATMENT_TASKS where TRMT_CODE=? and  SEQ_NO=?";
				//sql = "select SEQ_NO from OH_TREATMENT_TASKS where TRMT_CODE=? and  SEQ_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,treatment_code);
				pstmt.setString(2,seq_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					count = rst.getString(1);
				}
				
				out.println(count);
		}
		else if(func_mode.equalsIgnoreCase("VALIDATESEQ_NO1")){	
			String treatment_code	= request.getParameter( "treatment_code" ) ;
			String seq_no	= request.getParameter( "seq_no" ) ;
			String sql = "";		
			String count = "";
				//sql = "select count(1)  from OH_TREATMENT_TASKS where TRMT_CODE=? and  SEQ_NO=?";
				sql = "select SEQ_NO from OH_TREATMENT_TASKS where TRMT_CODE=? and  SEQ_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,treatment_code);
				pstmt.setString(2,seq_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					count = rst.getString(1);
				}
				out.println(count);
		}
		else if(func_mode.equalsIgnoreCase("countRecords")){	
			String chart_code =request.getParameter( "chart_code" ) ;
		    String component_code =request.getParameter( "component_code" ) ;
			String tooth_no = request.getParameter( "tooth_no" ) ;
			String sql = "";		
			String count = "";
				sql = "select count(*)  count from OH_PERIODONTAL_CHART_DEF_DTL2 where chart_code=? and  component_code=? and  (tooth_no=? or tooth_no = '*A' )";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,component_code);
				pstmt.setString(3,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					count = rst.getString(1);
				}
				out.println(count);
		}
		else if(func_mode.equalsIgnoreCase("EvaluationList")){	
			String chart_code =request.getParameter( "chart_code" ) ;
		    String patient_id =request.getParameter( "patient_id" ) ;
			String facility_id = request.getParameter( "facility_id" ) ;
			StringBuilder sbr = new StringBuilder();
			String sql = "SELECT A.CHART_CODE, C.CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_PERIODONTAL_CHART_DEF_HDR C WHERE  A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_CODE=? AND B.CHART_LINE_NUM > 1 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID  AND A.PATIENT_ID = B.PATIENT_ID  AND  A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.CHART_CODE = C.CHART_CODE ORDER BY 2";		
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					sbr.append(rst.getString(1)+"##"+rst.getString(2)).append("~");
				}
				out.println(sbr.toString());
				//sbr.setLength(0);
		}
		else if(func_mode.equalsIgnoreCase("getAllTasksLink")){	
			String treatment_code =request.getParameter( "treatment_code" ) ;
			StringBuilder sbr = new StringBuilder();
				pstmt = con.prepareStatement("SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS_LANG_VW B WHERE B.TASK_CODE = A.TASK_CODE AND B.LANGUAGE_ID = ?) TASK_DESC, A.SEQ_NO FROM OH_TREATMENT_TASKS A WHERE TRMT_CODE = ? ORDER BY A.SEQ_NO ");
				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					sbr.append(rst.getString("TASK_CODE")+"##"+rst.getString("TASK_DESC")+"##"+rst.getString("SEQ_NO")).append("~");
				}
				out.println(sbr.toString());
				//sbr.setLength(0);
		}
		else if(func_mode.equalsIgnoreCase("populateMinMaxValue")){	
		String component_code =request.getParameter( "component_code" ) ;
		
		   int min_value=0;
		   int max_value=0;
		   int cut_off=0;
	       StringBuffer  min_max= new StringBuffer();
            pstmt = con.prepareStatement("SELECT MIN_VALUE,MAX_VALUE,CUT_OFF FROM OH_PERIODONTAL_CHART_COMP WHERE COMPONENT_CODE=?");
                pstmt.setString(1,component_code);
			    rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
		            min_value = Integer.parseInt(rst.getString("MIN_VALUE"));;
					max_value = Integer.parseInt(rst.getString("MAX_VALUE"));
					cut_off = Integer.parseInt(rst.getString("CUT_OFF"));
				
				    min_max.append(min_value +"##"+max_value+"##"+cut_off);
				    min_max.append("~"); 
			 
			   }
			out.println(min_max);
         
	 }
	 else if(func_mode.equalsIgnoreCase("countDtlRecords")){	
			String chart_code =request.getParameter( "chart_code" ) ;
		    String component_code =request.getParameter( "component_code" ) ;
			String sql = "";		
			String record_count = "";
				sql = "select count(*) record_count from oh_periodontal_chart_dtl where  chart_code = ? and component_code = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,component_code);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					record_count = rst.getString(1);
				}
				out.println(record_count);
	 }
	 else if(func_mode.equalsIgnoreCase("deleteSelectedCompValues")){//Added by Sridevi Joshi on 12/23/2009 for IN017540 to get the status of Extraction treatment 
			String chart_code	= checkForNull(request.getParameter( "chart_code" )) ;
			String comp_code	= checkForNull(request.getParameter( "comp_code" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;

			int del_comp_flag = 0;
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("DELETE FROM OH_PERIODONTAL_CHART_DEF_DTL2 WHERE CHART_CODE = ? AND COMPONENT_CODE = ? AND TOOTH_NO = ?");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,comp_code);
			pstmt.setString(3,tooth_no);
			del_comp_flag = pstmt.executeUpdate();
			if(del_comp_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			out.println(del_comp_flag);
	 }
	 else if(func_mode.equalsIgnoreCase("checkCompRecorded")){	
			String chart_code =request.getParameter( "chart_code" ) ;
		    String component_code =request.getParameter( "component_code" ) ;
			String comp_record_count = "";

			pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_PERIODONTAL_CHART_DEF_DTL2 WHERE CHART_CODE = ? AND COMPONENT_CODE = ? AND TOOTH_NO != '*A'");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				comp_record_count = rst.getString(1);
			}
			out.println(comp_record_count);
	 }
	  else if(func_mode.equalsIgnoreCase("getTrmtCategoryType")){	
			String trmt_category_code =request.getParameter( "trmt_category_code" ) ;
		    String trmt_category_type = "";

			pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE FROM OH_TREATMENT_CATEGORY WHERE TRMT_CATEGORY_CODE = ? AND SPLTY_MODULE_ID = ?");
			pstmt.setString(1,trmt_category_code);
			pstmt.setString(2,"OH");
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type = rst.getString("TRMT_CATEGORY_TYPE");
			}
			out.println(trmt_category_type);
	 }
	 else if(func_mode.equalsIgnoreCase("populateUserMinMaxValue")){	
		String component_code =request.getParameter( "component_code" ) ;
		String chart_code =request.getParameter( "chart_code" ) ;
		String mode =request.getParameter( "mode" ) ;
		
		   int user_min_value=0;
		   int user_max_value=0;
		   int user_cut_off=0;

	       StringBuffer  user_min_max= new StringBuffer();
		   if(mode.equals("modify")){
				pstmt = con.prepareStatement("SELECT MIN_VALUE, MAX_VALUE, CUT_OFF FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE = ? AND COMPONENT_CODE=?");
                pstmt.setString(1,chart_code);
                pstmt.setString(2,component_code);
			    rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
		            user_min_value = Integer.parseInt(rst.getString("MIN_VALUE"));;
					user_max_value = Integer.parseInt(rst.getString("MAX_VALUE"));
					user_cut_off = Integer.parseInt(rst.getString("CUT_OFF"));
				
				    user_min_max.append(user_min_value +"##"+user_max_value +"##"+user_cut_off );
				    user_min_max.append("~"); 
			 
			   }
		   }
		   else if(mode.equals("insert")){
				pstmt = con.prepareStatement("SELECT MIN_VALUE, MAX_VALUE, CUT_OFF FROM OH_PERIODONTAL_CHART_COMP WHERE COMPONENT_CODE=?");
                pstmt.setString(1,component_code);
			    rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
		            user_min_value = Integer.parseInt(rst.getString("MIN_VALUE"));;
					user_max_value = Integer.parseInt(rst.getString("MAX_VALUE"));
					user_cut_off = Integer.parseInt(rst.getString("CUT_OFF"));
				
				    user_min_max.append(user_min_value +"##"+user_max_value +"##"+user_cut_off );
				    user_min_max.append("~"); 
			 
			   }
		   }
			out.println(user_min_max);
         
	 }
	 else if(func_mode.equalsIgnoreCase("getDentureRemovable")){	
		    int removable_count = 0;

			pstmt = con.prepareStatement("SELECT COUNT(*) REMOVABLE_COUNT FROM  OH_TREATMENT_CATEGORY WHERE TRMT_CATEGORY_TYPE = 'DENTURE' AND DENTURE_REMOVABLE = 'Y' AND SPLTY_MODULE_ID = 'OH'");
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				removable_count = Integer.parseInt(rst.getString("REMOVABLE_COUNT"));
			}
			out.println(removable_count);
	 }
	 else if(func_mode.equalsIgnoreCase("getDentureRemovableYN")){	
		    String denture_removable = "";
			String trmt_cat_code =request.getParameter( "trmt_cat_code" ) ;

			pstmt = con.prepareStatement("SELECT  DENTURE_REMOVABLE FROM  OH_TREATMENT_CATEGORY WHERE TRMT_CATEGORY_TYPE = 'DENTURE' AND TRMT_CATEGORY_CODE = ? AND SPLTY_MODULE_ID = 'OH'");
			pstmt.setString(1,trmt_cat_code);
			rst = pstmt.executeQuery();

			while(rst!= null && rst.next()){
				denture_removable = rst.getString("DENTURE_REMOVABLE");
			}
			out.println(denture_removable);
	 }
	}catch(Exception e){
		System.err.println("Err Msg from MCommonValidation.jsp "+e);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

	
