<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("populateArch")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String arch_sno = "";
			String arch_desc = "";
			StringBuffer arch_buff = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT ARCH_ID, ARCH_DESC FROM OH_ARCH_LANG_VW WHERE LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ? ORDER BY 2");
			pstmt.setString(1,locale);
			pstmt.setString(2,tooth_numbering_system);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				arch_sno = checkForNull(rst.getString("ARCH_ID"));
				arch_desc = checkForNull(rst.getString("ARCH_DESC"));
				arch_buff.append(arch_sno+"##"+arch_desc);
				arch_buff.append("~");
			}
			out.println(arch_buff);
		}else if(func_mode.equalsIgnoreCase("populatePerioSurfaces")){	
			String surface_code = "";
			String surface_name = "";
			String buccal_or_lingual = "";
			StringBuffer surface_code_name = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT SURFACE_CODE, SURFACE_NAME, BUCCAL_OR_LINGUAL FROM OH_SURFACE_LANG_VW WHERE LANGUAGE_ID=? AND APPL_CHART_TYPE IN ('B','P') ORDER BY 2");
			pstmt.setString(1,locale);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));
				surface_name = checkForNull(rst.getString("SURFACE_NAME"));
				buccal_or_lingual = checkForNull(rst.getString("BUCCAL_OR_LINGUAL"));
				surface_code_name.append(surface_code+"##"+surface_name+"##"+buccal_or_lingual);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		else if(func_mode.equalsIgnoreCase("checkForActiveChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String perio_chart = checkForNull(request.getParameter( "perio_chart" )) ;
			//String chart_status = checkForNull(request.getParameter( "chart_status" )) ;
			String active_chart_yn = "N";
			String closed_chart_yn = "N";
			String chart_type = "";
			String chart_num = "";
			String chart_status = "";
			String sql				= "";		
			StringBuffer chartSerialBuff = new StringBuffer();	
			sql = "SELECT CHART_TYPE, CHART_NUM, CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			//pstmt.setString(4,chart_status);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_type = checkForNull(rst.getString("CHART_TYPE"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
				//if(chart_status.equals("PE")){
					active_chart_yn = "Y";
				//}

				//if(chart_status.equals("CM")){
					//closed_chart_yn = "Y";
				//}
				chartSerialBuff.append(active_chart_yn+"##"+chart_type+"##"+chart_num+"##"+closed_chart_yn+"##"+chart_status);
			}
			chartSerialBuff.append("~");
			out.println(chartSerialBuff);
		}
		else if(func_mode.equalsIgnoreCase("checkForECActiveChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String perio_chart = checkForNull(request.getParameter( "perio_chart" )) ;

			String active_chart_yn = "N";
			String chart_type = "";
			String chart_line_num = "";
			String sql				= "";		
			StringBuffer chartSerialBuff = new StringBuffer();	
			sql = "SELECT CHART_TYPE, CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_LINE_STATUS = 'PE' AND CHART_TYPE = 'EC'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_type = checkForNull(rst.getString("CHART_TYPE"));
				chart_line_num = checkForNull(rst.getString("CHART_LINE_NUM"));
				active_chart_yn = "Y";
				chartSerialBuff.append(active_chart_yn+"##"+chart_type+"##"+chart_line_num);
			}
			chartSerialBuff.append("~");
			out.println(chartSerialBuff);
		}
		else if(func_mode.equalsIgnoreCase("checkForClosedChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String perio_chart = checkForNull(request.getParameter( "perio_chart" )) ;
			String active_chart_yn = "N";
			String chart_type = "";
			String chart_num = "";
			String sql				= "";		
			StringBuffer chartSerialBuff = new StringBuffer();	
			sql = "SELECT CHART_TYPE, CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS = 'CD'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_type = checkForNull(rst.getString("CHART_TYPE"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				active_chart_yn = "Y";
				chartSerialBuff.append(active_chart_yn+"##"+chart_type+"##"+chart_num);
			}
			chartSerialBuff.append("~");
			out.println(chartSerialBuff);
		}
		else if(func_mode.equalsIgnoreCase("getAllDetailRecords")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
			String eval_active_yn = checkForNull(request.getParameter("eval_active_yn"));
			String tab_code = checkForNull(request.getParameter("tab_code"));
			String component_code = "";
			String tooth_no = "";
			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s6 = "";
			String value = "";
			String surface_B_val = "";
			String surface_L_val = "";
			StringBuffer surface_code_name = new StringBuffer();
			if(tab_code.equals("BC")){ // For Baseline Charts
				if(baseline_closed_yn.equals("Y")){ // Called from Baseline Chart Active menu
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD'");
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
				}

				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,"1");
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			else if(tab_code.equals("EC")){ //For Evaluation Charts
				if(eval_active_yn.equals("N")){ // Called from Baseline/Evaluation Chart menu (for completed Evaluation Charts)
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME','CM')");
				}
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				component_code = checkForNull(rst.getString("COMPONENT_CODE"));
				tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				s1 = checkForNull(rst.getString("s1"));
				s2 = checkForNull(rst.getString("s2"));
				s3 = checkForNull(rst.getString("s3"));
				s4 = checkForNull(rst.getString("s4"));
				s5 = checkForNull(rst.getString("s5"));
				s6 = checkForNull(rst.getString("s6"));
				value = checkForNull(rst.getString("VALUE"));
				surface_B_val = s1+s2+s3;
				surface_L_val = s4+s5+s6;
				//surface_code_name.append(component_code+"##"+tooth_no+"##"+surface_B_val+"##"+surface_L_val+"##"+value);
				surface_code_name.append(component_code+"##"+tooth_no+"##"+s1+"##"+s2+"##"+s3+"##"+s4+"##"+s5+"##"+s6+"##"+value);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		
		else if(func_mode.equalsIgnoreCase("populateSurfaceValues")){	
			String chart_type = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String component_code = checkForNull(request.getParameter("component_code"));
			String tooth_no = checkForNull(request.getParameter("tooth_no"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			if(header_tab.equals("E")){
				chart_type = "EC";
			}
			else{
				chart_type = "BC";
				chart_line_num = "1";
			}

			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s6 = "";
			String value = "";
			
			StringBuffer surface_code_name = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND A.TOOTH_NO = ? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_code);
			pstmt.setString(5,component_code);
			pstmt.setString(6,tooth_no);
			pstmt.setString(7,chart_type);
			pstmt.setString(8,chart_line_num);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				s1 = checkForNull(rst.getString("s1"));
				s2 = checkForNull(rst.getString("s2"));
				s3 = checkForNull(rst.getString("s3"));
				s4 = checkForNull(rst.getString("s4"));
				s5 = checkForNull(rst.getString("s5"));
				s6 = checkForNull(rst.getString("s6"));
				value= checkForNull(rst.getString("value"));
				
				surface_code_name.append(s1+"##"+s2+"##"+s3+"##"+s4+"##"+s5+"##"+s6+"##"+value);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		else if(func_mode.equalsIgnoreCase("getMaxMinValues")){	
			String component_code = checkForNull(request.getParameter("component_code"));
			String min_val = "";
			String max_val = "";
			String surfaces_appl_yn = "";
			StringBuffer surface_code_name = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, B.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP B WHERE  B.COMPONENT_CODE=?");
			pstmt.setString(1,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				min_val = checkForNull(rst.getString("MIN_VALUE"));
				max_val = checkForNull(rst.getString("MAX_VALUE"));
				surfaces_appl_yn = checkForNull(rst.getString("SURFACES_APPL_YN"));
				surface_code_name.append(min_val+"##"+max_val+"##"+surfaces_appl_yn);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		else if(func_mode.equalsIgnoreCase("updateChartStatus")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String status = checkForNull(request.getParameter( "status" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String called_from = checkForNull(request.getParameter( "called_from" )) ;
			int flag = 0;
			String sql				= "";		
			//sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS = 'PE'";
			if(called_from.equals("EC")){
				sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,status);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_code);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,chart_line_num);
				flag = pstmt.executeUpdate();
			}
			else{
				sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,status);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_code);
				pstmt.setString(5,chart_num);
				flag = pstmt.executeUpdate();

				sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = '1'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,status);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_code);
				pstmt.setString(5,chart_num);
				flag = pstmt.executeUpdate();
			
				// Below code is added by bshankar on 17th Jan 2008.
				/*OH_CALCULATE_SUMMARY(P_FACILITY_ID,P_PATIENT_ID, P_ENCOUNTER_ID,P_PATIENT_CLASS,
 P_CHART_NUM,P_CHART_CODE,P_CHART_LINE_NUM,P_CLOSING_CHART_YN,P_USER_ID,
 P_WS_NO,P_INDEX_VALUE (OUT), P_COMPONENT_VALUE (OUT) ,P_STATUS (OUT),
 P_ERR_MSG (OUT), P_LANG_ERR_MSG_ID (OUT))

				cstmt=con.prepareCall("{call OH_CALCULATE_SUMMARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1,facility_id);
				cstmt.setString(2,patient_id);
				cstmt.setString(3,encounter_id);
				cstmt.setString(4,patient_class);
				cstmt.setString(5,chart_num);
				cstmt.setString(6,chart_code);
				cstmt.setString(7,chart_line_num);
				cstmt.setString(8,'Y');
				cstmt.setString(9,login_user);
				cstmt.setString(10,client_ip_address);

				cstmt.registerOutParameter(2,Types.VARCHAR);
				cstmt.execute();
*/
				// Code ends here (17th Jan 2008)

			}
			
			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("getChartStatus")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String called_from = checkForNull(request.getParameter("called_from"));
			String status = "";
			if(called_from.equals("EC")){
				pstmt = con.prepareStatement("SELECT CHART_LINE_STATUS FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,chart_line_num);
				rst=pstmt.executeQuery();
			}
			else{
				pstmt = con.prepareStatement("SELECT CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
				rst=pstmt.executeQuery();
			}
			while(rst.next()){
				status = checkForNull(rst.getString("CHART_STATUS"));
			}
			out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("displayBECMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CM' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_code = checkForNull(rst.getString("CHART_CODE"));
				chart_date = checkForNull(rst.getString("CHART_DATE_MOD"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_desc = checkForNull(rst.getString("CHART_DESC"));
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
				BCClosed_menu.append(chart_code+"##"+chart_date+"##"+chart_num+"##"+chart_desc+"##"+chart_status);
				BCClosed_menu.append("~");
			}
			out.println(BCClosed_menu);
		}
		else if(func_mode.equalsIgnoreCase("displayBCActiveMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM') ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_code = checkForNull(rst.getString("CHART_CODE"));
				chart_date = checkForNull(rst.getString("CHART_DATE_MOD"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_desc = checkForNull(rst.getString("CHART_DESC"));
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
				BCClosed_menu.append(chart_code+"##"+chart_date+"##"+chart_num+"##"+chart_desc+"##"+chart_status);
				BCClosed_menu.append("~");
			}
			out.println(BCClosed_menu);
		}
		else if(func_mode.equalsIgnoreCase("displayBCClosedMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_code = checkForNull(rst.getString("CHART_CODE"));
				chart_date = checkForNull(rst.getString("CHART_DATE_MOD"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_desc = checkForNull(rst.getString("CHART_DESC"));
				BCClosed_menu.append(chart_code+"##"+chart_date+"##"+chart_num+"##"+chart_desc);
				BCClosed_menu.append("~");
			}
			out.println(BCClosed_menu);
		}
		else if(func_mode.equalsIgnoreCase("displayEvalChartMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));

			String chart_date = "";
			String chart_num = "";
			String chart_line_num = "";
			String chart_desc = "";
			String chart_line_status = "";
			StringBuffer eval_chart_menu = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' ORDER BY A.CHART_NUM DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_code = checkForNull(rst.getString("CHART_CODE"));
				chart_date = checkForNull(rst.getString("CHART_DATE_MOD"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_desc = checkForNull(rst.getString("CHART_DESC"));
				chart_line_num = checkForNull(rst.getString("CHART_LINE_NUM"));
				chart_line_status = checkForNull(rst.getString("CHART_LINE_STATUS"));
				eval_chart_menu.append(chart_code+"##"+chart_date+"##"+chart_num+"##"+chart_desc+"##"+chart_line_num+"##"+chart_line_status);
				eval_chart_menu.append("~");
			}
			out.println(eval_chart_menu);
		}	
		else if(func_mode.equalsIgnoreCase("getBCStatus")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String status = "";
						
			pstmt = con.prepareStatement("SELECT CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_TYPE = 'BC'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num);
			rst=pstmt.executeQuery();
			while(rst.next()){
				status = checkForNull(rst.getString("CHART_STATUS"));
			}
			out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("getChartNum")){	
			String chart_type = "";
			String chart_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			if(header_tab.equals("E")){
				chart_type = "EC";
			}
			else{
				chart_type = "BC";
			}

			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			//pstmt.setString(4,chart_type);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_num = checkForNull(rst.getString("CHART_NUM"));
			}
			out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("countHeaderRecords")){	
			String chart_code = "";
			String chart_num = "";
			String chart_status = "";
			int count_records = 0;
			String patient_id = checkForNull(request.getParameter("patient_id"));
			
			pstmt = con.prepareStatement("SELECT CHART_CODE,CHART_NUM,CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS IN ('PE','CM')");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			while(rst.next()){
				count_records++;
				chart_code = checkForNull(rst.getString("CHART_CODE"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
			}
			out.println(count_records+"##"+chart_code+"##"+chart_num+"##"+chart_status);
		}
		else if(func_mode.equalsIgnoreCase("checkForMissingTooth")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String perio_tooth = checkForNull(request.getParameter("perio_tooth"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			String chart_type = "";
			String miss_count = "";
			if(header_tab.equals("B")){
				chart_type = "BC";
				chart_line_num = "1";
			}
			else if(header_tab.equals("E")){
				chart_type = "EC";
			}
			
			pstmt = con.prepareStatement("SELECT COUNT(COMPONENT_CODE) MISS_COUNT FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM  AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?  AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND B.CHART_TYPE = ? AND A.TOOTH_NO = ? AND A.COMPONENT_CODE = 'MITH'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_type);
			pstmt.setString(7,perio_tooth);
			rst=pstmt.executeQuery();
			while(rst.next()){
				miss_count = checkForNull(rst.getString("MISS_COUNT"));
			}
			out.println(miss_count);
		}
		else if(func_mode.equalsIgnoreCase("getChartComponents")){	
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String comp_code = "";

			StringBuffer comp_code_buff = new StringBuffer();

			pstmt = con.prepareStatement("SELECT COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE = ?");
			pstmt.setString(1,chart_code);
			
			rst=pstmt.executeQuery();
			while(rst.next()){
				comp_code = checkForNull(rst.getString("COMPONENT_CODE"));
				comp_code_buff.append(comp_code);
				comp_code_buff.append("~");
			}
			out.println(comp_code_buff);
		}
		else if(func_mode.equalsIgnoreCase("getAllDetailRecordsForGraph")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
			String eval_active_yn = checkForNull(request.getParameter("eval_active_yn"));
			String tab_code = checkForNull(request.getParameter("tab_code"));
			String component_code = "";
			String tooth_no = "";
			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s6 = "";
			String value = "";
			String surface_B_val = "";
			String surface_L_val = "";
			StringBuffer surface_code_name = new StringBuffer();
			if(tab_code.equals("BC")){ // For Baseline Charts
				if(baseline_closed_yn.equals("Y")){ // Called from Baseline Chart Active menu
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD' ");
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
				}

				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,"1");
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			else if(tab_code.equals("EC")){ //For Evaluation Charts
				if(eval_active_yn.equals("N")){ // Called from Baseline/Evaluation Chart menu (for completed Evaluation Charts)
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM' AND A.COMPONENT_CODE IN ('PD','CAL','CEJ')");
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME','CM') AND A.COMPONENT_CODE IN ('PD','CAL','CEJ')");
				}
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				component_code = checkForNull(rst.getString("COMPONENT_CODE"));
				tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				s1 = checkForNull(rst.getString("s1"));
				s2 = checkForNull(rst.getString("s2"));
				s3 = checkForNull(rst.getString("s3"));
				s4 = checkForNull(rst.getString("s4"));
				s5 = checkForNull(rst.getString("s5"));
				s6 = checkForNull(rst.getString("s6"));
				value = checkForNull(rst.getString("VALUE"));
				surface_B_val = s1+s2+s3;
				surface_L_val = s4+s5+s6;
				//surface_code_name.append(component_code+"##"+tooth_no+"##"+surface_B_val+"##"+surface_L_val+"##"+value);
				surface_code_name.append(component_code+"##"+tooth_no+"##"+s1+"##"+s2+"##"+s3+"##"+s4+"##"+s5+"##"+s6+"##"+value);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		/*
		else if(func_mode.equalsIgnoreCase("deleteMissingRecords")){	
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String tooth_no = checkForNull(request.getParameter("tooth_no"));

			int flag_delete = 0;

			pstmt = con.prepareStatement("DELETE FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND COMPONENT_CODE != 'MITH'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num);
			pstmt.setString(5,tooth_no);
			
			flag_delete=pstmt.executeUpdate();
			if(flag_delete != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(flag_delete);
		}
	*/
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from PerioCommonValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
