<%@ page  import="java.net.URLDecoder,java.util.*,java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String login_user      = (String) session.getAttribute("login_user");
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;


	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );

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
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}
			//String chart_status = checkForNull(request.getParameter( "chart_status" )) ;
			String active_chart_yn = "N";
			String closed_chart_yn = "N";
			String chart_type = "";
			String chart_num = "";
			String chart_status = "";
			String sql				= "";		
			StringBuffer chartSerialBuff = new StringBuffer();	
		//	sql = "SELECT CHART_TYPE, CHART_NUM, CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')";
		if (oh_chart_level.equals("E")){
			sql = "SELECT CHART_TYPE, CHART_NUM, CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')";
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,perio_chart);
			//pstmt.setString(4,chart_status);
			rst = pstmt.executeQuery();
		
		}else{
			sql = "SELECT CHART_TYPE, CHART_NUM, CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')";
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			//pstmt.setString(4,chart_status);
			rst = pstmt.executeQuery();
		}
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
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}

			String active_chart_yn = "N";
			String chart_type = "";
			String chart_line_num = "";
			String sql				= "";		
			StringBuffer chartSerialBuff = new StringBuffer();	
		if (oh_chart_level.equals("E")){

			sql = "SELECT CHART_TYPE, CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_LINE_STATUS = 'PE' AND CHART_TYPE = 'EC'";
			pstmt = con.prepareStatement(sql);
	     //pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,perio_chart);
			rst = pstmt.executeQuery();
		}else{
			sql = "SELECT CHART_TYPE, CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_LINE_STATUS = 'PE' AND CHART_TYPE = 'EC'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,other_chart_facility_id);
			//pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			rst = pstmt.executeQuery();
		
		
		}
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
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
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
			if (oh_chart_level.equals("E")){
				if(baseline_closed_yn.equals("Y")){ // Called from Baseline Chart Active menu
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD'");
					
					
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE  AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE  AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND (A.VALUE IS NULL OR (A.VALUE != '0' AND A.COMPONENT_CODE != 'MITH'))");
				}
			
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,"1");
				pstmt.setString(4,chart_code);
				pstmt.setString(5,tab_code);
			
			}else{
				if(baseline_closed_yn.equals("Y")){ // Called from Baseline Chart Active menu
				pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD'");
				//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD'");
				}
				else{ 

				//	pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE  AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
				pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
				}
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,"1");
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			}
			
			else if(tab_code.equals("EC")){ //For Evaluation Charts		
				if(eval_active_yn.equals("N")){ // Called from Baseline/Evaluation Chart menu (for completed Evaluation Charts)
					if (oh_chart_level.equals("E")){

					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = 'BC' AND C.CHART_LINE_STATUS = 'CM'");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ?  AND C.CHART_LINE_STATUS = 'CM'");

				//	pstmt.setString(1,facility_id);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,tab_code);
				}else{
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE  AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,chart_code);
					pstmt.setString(6,tab_code);
					}
			}
				else{ 
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME','CM')");
					if (oh_chart_level.equals("E")){

					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE  A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM  AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = 'BC' AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
					//pstmt.setString(1,facility_id);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,tab_code);
				}else{
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE =? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
					//pstmt.setString(1,facility_id);
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,chart_code);
					pstmt.setString(6,tab_code);
				}
				
				}
			
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
			
			//pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND A.TOOTH_NO = ? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
			pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND A.TOOTH_NO = ? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
		//	pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,component_code);
			pstmt.setString(5,tooth_no);
			pstmt.setString(6,chart_type);
			pstmt.setString(7,chart_line_num);
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
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String min_val = "";
			String max_val = "";
			String cut_off = "";
			String surfaces_appl_yn = "";
			StringBuffer surface_code_name = new StringBuffer();
			//pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, B.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP B WHERE  B.COMPONENT_CODE=?");
			//pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, A.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? AND B.COMPONENT_CODE=?");
			pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, A.SURFACES_APPL_YN, B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? AND B.COMPONENT_CODE=?");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				min_val = checkForNull(rst.getString("MIN_VALUE"));
				max_val = checkForNull(rst.getString("MAX_VALUE"));
				surfaces_appl_yn = checkForNull(rst.getString("SURFACES_APPL_YN"));
				cut_off = checkForNull(rst.getString("CUT_OFF"));
				//surface_code_name.append(min_val+"##"+max_val+"##"+surfaces_appl_yn);
				surface_code_name.append(min_val+"##"+max_val+"##"+surfaces_appl_yn+"##"+cut_off);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		else if(func_mode.equalsIgnoreCase("updateChartStatus")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
			String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String status = checkForNull(request.getParameter( "status" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String called_from = checkForNull(request.getParameter( "called_from" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;


			int flag = 0;
			String sql				= "";		
			//sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS = 'PE'";
			if(called_from.equals("EC")){
				if(oh_chart_level.equals("E")){
					sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,status);
				//	pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_code);
					pstmt.setString(4,chart_num);
					pstmt.setString(5,chart_line_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
				}else{
					sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,status);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,chart_num);
					pstmt.setString(6,chart_line_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
				}
			}
			else{
				if(oh_chart_level.equals("E")){
				sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_STATUS = ? WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,status);
			//	pstmt.setString(2,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				}else{
					sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,status);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_code);
				pstmt.setString(5,chart_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				
				
				}
				if(!status.equals("CD")){
					if(oh_chart_level.equals("E")){

					sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = '1'";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,status);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_code);
					pstmt.setString(4,chart_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
					}else{
						sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_LINE_STATUS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = '1'";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,status);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,chart_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
					
					
					}
				}
				else if(status.equals("CD")){
				if(oh_chart_level.equals("E")){

					sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_CLOSED_BY = ?, CHART_CLOSE_DATE = SYSDATE WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,login_user);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_code);
					pstmt.setString(4,chart_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
					
					
					}else{
					sql = "UPDATE OH_PERIODONTAL_CHART_HDR SET CHART_CLOSED_BY = ?, CHART_CLOSE_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,login_user);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,chart_num);
					flag = pstmt.executeUpdate();

					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
				}
				}
			}
			if(status.equals("CM")){
				//Update Chart_completed_by and chart_completed_date
				if(oh_chart_level.equals("E")){

				sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_COMPLETED_BY = ?, CHART_COMPLETED_DATE = SYSDATE WHERE PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,login_user);
				//pstmt.setString(2,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,chart_line_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				}else{
					sql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET CHART_COMPLETED_BY = ?, CHART_COMPLETED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,login_user);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_code);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,chart_line_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				
				
				}
				// Below code is added by bshankar on 17th Jan 2008.
				/*OH_CALCULATE_SUMMARY(P_FACILITY_ID,P_PATIENT_ID, P_ENCOUNTER_ID,P_PATIENT_CLASS,
 P_CHART_NUM,P_CHART_CODE,P_CHART_LINE_NUM,P_CLOSING_CHART_YN,P_USER_ID,
 P_WS_NO,P_INDEX_VALUE (OUT), P_COMPONENT_VALUE (OUT) ,P_STATUS (OUT),
 P_ERR_MSG (OUT), P_LANG_ERR_MSG_ID (OUT)) */

				cstmt=con.prepareCall("{call OH_CALCULATE_SUMMARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1,facility_id);
				cstmt.setString(2,patient_id);
				cstmt.setString(3,encounter_id);
				cstmt.setString(4,patient_class);
				cstmt.setString(5,chart_num);
				cstmt.setString(6,chart_code);
				cstmt.setString(7,chart_line_num);
				cstmt.setString(8,"Y");
				cstmt.setString(9,login_user);
				cstmt.setString(10,client_ip_address);

				cstmt.registerOutParameter(11,Types.VARCHAR);	//P_INDEX_VALUE
				cstmt.registerOutParameter(12,Types.VARCHAR);	//P_COMPONENT_VALUE
				cstmt.registerOutParameter(13,Types.VARCHAR);	//P_STATUS
				cstmt.registerOutParameter(14,Types.VARCHAR);	//P_ERR_MSG
				cstmt.registerOutParameter(15,Types.VARCHAR);	//P_LANG_ERR_MSG_ID
				cstmt.execute();
				String err_status = cstmt.getString(13);
				if(err_status.equals("E")){
					flag= 0;
				}else{
					flag = 1;
					con.commit();
				}
				// Code ends here (17th Jan 2008)
			}			

			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("getChartStatus")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String called_from = checkForNull(request.getParameter("called_from"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));

			String status = "";
			if(called_from.equals("EC")){
					if(oh_chart_level.equals("E")){
						pstmt = con.prepareStatement("SELECT CHART_LINE_STATUS CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,chart_line_num);
						rst=pstmt.executeQuery();
			}else{
			           pstmt = con.prepareStatement("SELECT CHART_LINE_STATUS CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_code);
						pstmt.setString(4,chart_num);
						pstmt.setString(5,chart_line_num);
						rst=pstmt.executeQuery();
			
			}
			}else{
				if(oh_chart_level.equals("E")){

				pstmt = con.prepareStatement("SELECT CHART_STATUS CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?");
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_code);
				pstmt.setString(3,chart_num);
				rst=pstmt.executeQuery();
			}else{
			pstmt = con.prepareStatement("SELECT CHART_STATUS CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
				rst=pstmt.executeQuery();
			}
			}

			while(rst.next()){
				status = checkForNull(rst.getString("CHART_STATUS"));
			}
			out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("displayBECMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.PATIENT_ID = ? AND A.CHART_STATUS = 'CM' ORDER BY A.CHART_DATE DESC");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
		}else{
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CM' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
		
		
		}
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
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){

			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM') ORDER BY A.CHART_DATE DESC");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
			}else{
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM') ORDER BY A.CHART_DATE DESC");
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
											
			}
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
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){

			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
			}else{
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			
			
			}
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
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			String chart_date = "";
			String chart_line_num = "";
			String chart_desc = "";
			String chart_line_status = "";
			StringBuffer eval_chart_menu = new StringBuffer();
			
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' ORDER BY A.CHART_NUM DESC");

			//Added Chart_num in the query to get the records with only that chart_num... By sridevi joshi on 28/04/08
			if (oh_chart_level.equals("E")){
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? AND A.CHART_LINE_STATUS IN('PE','CM') ORDER BY A.CHART_NUM DESC");
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'BC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			
		//	pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			pstmt.setString(3,chart_num);
			rst=pstmt.executeQuery();
			}else{
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? AND A.CHART_LINE_STATUS IN('PE','CM') ORDER BY A.CHART_NUM DESC");
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'BC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num);
			rst=pstmt.executeQuery();
			
			}
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
		else if(func_mode.equalsIgnoreCase("getECStatus")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String status = "";
						
			pstmt = con.prepareStatement("SELECT CHART_LINE_STATUS FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND CHART_LINE_TYPE = 'EC'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num);
			pstmt.setString(5,chart_line_num);
			rst=pstmt.executeQuery();
			while(rst.next()){
				status = checkForNull(rst.getString("CHART_LINE_STATUS"));
			}
			out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("getChartNum")){	
			String chart_type = "";
			String chart_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			if(header_tab.equals("E")){
				chart_type = "EC";
			}
			else{
				chart_type = "BC";
			}
		if (oh_chart_level.equals("E")){
			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE  PATIENT_ID = ? AND CHART_CODE = ?");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			//pstmt.setString(4,chart_type);
			rst=pstmt.executeQuery();
		}else{
			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			//pstmt.setString(4,chart_type);
			rst=pstmt.executeQuery();


	}
			while(rst.next()){
				chart_num = checkForNull(rst.getString("CHART_NUM"));
			}
			out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("getHdrChartNum")){	
			String chart_type = "";
			String chart_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			if(header_tab.equals("E")){
				chart_type = "EC";
			}
			else{
				chart_type = "BC";
			}
			if (oh_chart_level.equals("E")){
			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			//pstmt.setString(4,chart_type);
			rst=pstmt.executeQuery();
			}else{
			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_STATUS IN ('PE','CM')");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			//pstmt.setString(4,chart_type);
			rst=pstmt.executeQuery();			
			}
			while(rst.next()){
				chart_num = checkForNull(rst.getString("CHART_NUM"));
			}
			out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("createNewChartNum")){	
			String chart_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));

			//pstmt=con.prepareStatement("SELECT MAX(NVL(CHART_NUM,'0'))+1 NEW_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=?");
			pstmt=con.prepareStatement("SELECT MAX(NVL(CHART_NUM,'0'))+1 NEW_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE  PATIENT_ID=?");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_num = checkForNull(rst.getString("NEW_CHART_NUM"));
			}
			if(chart_num.equals("")){
				chart_num = "1";
			}
			out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("createNewChartLineNum")){	
			String chart_line_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
		if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE  PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? ");
		//	pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_code);
			rst = pstmt.executeQuery();
		}else{
			pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? ");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_code);
			rst = pstmt.executeQuery();

		}
			while(rst.next()){
				chart_line_num=checkForNull(rst.getString("CHART_LINE_NUM"));
			}

			out.println(chart_line_num);
		}
		else if(func_mode.equalsIgnoreCase("countHeaderRecords")){	
			String chart_code = "";
			String chart_num = "";
			String chart_status = "";
			int count_records = 0;
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));

			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CHART_CODE,CHART_NUM,CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE  PATIENT_ID = ? AND CHART_STATUS IN ('PE','CM')");
				pstmt.setString(1,patient_id);
				rst=pstmt.executeQuery();
			}else{
				pstmt = con.prepareStatement("SELECT CHART_CODE,CHART_NUM,CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS IN ('PE','CM')");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				rst=pstmt.executeQuery();
			
			}

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
			String check_missing_for_completion = checkForNull(request.getParameter("check_missing_for_completion"));
			String chart_type = "";
			String miss_count = "";
			String component_code = "";
			String component_value = "";

			StringBuffer miss_tooth_buffer = new StringBuffer();
			
			if(header_tab.equals("B")){
				chart_type = "BC";
				chart_line_num = "1";
			}
			else if(header_tab.equals("E")){
				chart_type = "EC";
			}

			if(check_missing_for_completion.equals("Y")){ // 'Y' when called when try to complete the chart 
				//pstmt = con.prepareStatement("SELECT COUNT(COMPONENT_CODE) MISS_COUNT FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM  AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?  AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND A.TOOTH_NO = ? AND A.COMPONENT_CODE = 'MITH' AND A.VALUE = '1'");
				pstmt = con.prepareStatement("SELECT COMPONENT_CODE, VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM  AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?  AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND A.TOOTH_NO = ? ");
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,perio_tooth);
				rst=pstmt.executeQuery();
				
				while(rst.next()){
					component_code = checkForNull(rst.getString("COMPONENT_CODE"));
					component_value = checkForNull(rst.getString("VALUE"));
					miss_tooth_buffer.append(component_code+"##"+component_value);
					miss_tooth_buffer.append("~");
				}
				out.println(miss_tooth_buffer);
				
				/*
				while(rst.next()){
					miss_count = checkForNull(rst.getString("MISS_COUNT"));
				}
				out.println(miss_count);
				*/
			}
			else{
				pstmt = con.prepareStatement("SELECT COUNT(COMPONENT_CODE) MISS_COUNT FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM  AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?  AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND B.CHART_TYPE = ? AND A.TOOTH_NO = ? AND A.COMPONENT_CODE = 'MITH' AND A.VALUE = '1'");
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

	else if(func_mode.equalsIgnoreCase("getHdrChartNumAndLineNum")){	
			String chart_type = "";
			String chart_line_num = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
		
			if(header_tab.equals("B")){
				chart_type = "BC";
			}
			else if(header_tab.equals("E")){
				chart_type = "EC";
			}

			//pstmt = con.prepareStatement("SELECT CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_lINE_STATUS IN ('PE') AND CHART_TYPE = ?");
			/*
				This condition is written on 28/04/08 by Sridevi Joshi
			*/
			if(header_tab.equals("B")){
				if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE PATIENT_ID = ? AND CHART_CODE = ? AND CHART_lINE_STATUS IN ('PE','CM') AND CHART_TYPE = ?");
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_code);
				pstmt.setString(3,chart_type);
				rst=pstmt.executeQuery();
				}else{
					pstmt = con.prepareStatement("SELECT CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_lINE_STATUS IN ('PE','CM') AND CHART_TYPE = ?");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_code);
					pstmt.setString(4,chart_type);
					rst=pstmt.executeQuery();
				
				}
			}
			else if(header_tab.equals("E")){
				if (oh_chart_level.equals("E")){
					pstmt = con.prepareStatement("SELECT CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE  PATIENT_ID = ? AND CHART_CODE = ? AND CHART_lINE_STATUS IN ('PE') AND CHART_TYPE = ?");
				//	pstmt.setString(1,facility_id);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_code);
					pstmt.setString(3,chart_type);
					rst=pstmt.executeQuery();
				}else{
				pstmt = con.prepareStatement("SELECT CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_HDR_LINE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_lINE_STATUS IN ('PE') AND CHART_TYPE = ?");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_type);
				rst=pstmt.executeQuery();
			}
			}
			while(rst.next()){
				//chart_num = checkForNull(rst.getString("CHART_NUM"));
				chart_line_num = checkForNull(rst.getString("CHART_lINE_NUM"));
				//chart_num_line_num.append(chart_num+"##"+chart_line_num);
				//chart_num_line_num.append("~");
			}
			out.println(chart_line_num);
		}
		else if(func_mode.equalsIgnoreCase("getPDCEJValues")){	
			
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String perio_chart = checkForNull(request.getParameter("perio_chart"));
			String DB_perio_comp = checkForNull(request.getParameter("DB_perio_comp"));
			String perio_tooth = checkForNull(request.getParameter("perio_tooth"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			StringBuffer dtl_val = new StringBuffer();

			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s6 = "";

			pstmt = con.prepareStatement("SELECT S1, S2, S3, S4, S5, S6 FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND TOOTH_NO = ? AND COMPONENT_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? ");
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,perio_chart);
			pstmt.setString(4,perio_tooth);
			pstmt.setString(5,DB_perio_comp);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			rst=pstmt.executeQuery();
			while(rst.next()){
				s1 = checkForNull(rst.getString("S1"));
				s2 = checkForNull(rst.getString("S2"));
				s3 = checkForNull(rst.getString("S3"));
				s4 = checkForNull(rst.getString("S4"));
				s5 = checkForNull(rst.getString("S5"));
				s6 = checkForNull(rst.getString("S6"));
				dtl_val.append(s1+"##"+s2+"##"+s3+"##"+s4+"##"+s5+"##"+s6);
				dtl_val.append("~");
			}
			out.println(dtl_val);
		}
		 else if(func_mode.equalsIgnoreCase("checkForPerioChart")){	
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String added_date = "";
				pstmt = con.prepareStatement("SELECT TO_CHAR(ADDED_DATE,'DD/MM/YYYY') ADDED_DATE FROM OH_PERIODONTAL_CHART_DEF_HDR where CHART_CODE=?");
				pstmt.setString(1,chart_code);

				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					added_date = checkForNull(rst.getString("added_date"));
				}
			
			out.println(added_date);
		}
		else if(func_mode.equalsIgnoreCase("checkForPerioChartCompleted")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String added_date = "";
				pstmt = con.prepareStatement("SELECT TO_CHAR(CHART_COMPLETED_DATE,'DD/MM/YYYY') ADDED_DATE FROM OH_PERIODONTAL_CHART_HDR_LINE where CHART_CODE=? and PATIENT_ID = ?");
				
				pstmt.setString(1,chart_code);
				pstmt.setString(2,patient_id);

				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					added_date = checkForNull(rst.getString("added_date"));
				}
			
			out.println(added_date);
		}
		else if(func_mode.equalsIgnoreCase("displayOtherBCActiveMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String facility_id1 = checkForNull(request.getParameter( "facility_id" )) ;		
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM') ORDER BY A.CHART_DATE DESC");
			
			pstmt.setString(1,facility_id1);
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

		else if(func_mode.equalsIgnoreCase("displayOtherBCClosedMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String facility_id1 = checkForNull(request.getParameter( "facility_id" )) ;
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){

			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
			}else{
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id1);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			
			}
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
		else if(func_mode.equalsIgnoreCase("displayOtherBECMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String facility_id1 = checkForNull(request.getParameter("facility_id1"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			String chart_status = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.PATIENT_ID = ? AND A.CHART_STATUS = 'CM' ORDER BY A.CHART_DATE DESC");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
		}else{
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC, A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CM' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id1);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
		
		
		}
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
		else if(func_mode.equalsIgnoreCase("displayOtherECClosedMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String facility_id1 = checkForNull(request.getParameter("facility_id1"));
			String chart_code = "";
			String chart_date = "";
			String chart_num = "";
			String chart_desc = "";
			StringBuffer BCClosed_menu = new StringBuffer();
			if (oh_chart_level.equals("E")){

			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,patient_id);
			rst=pstmt.executeQuery();
			}else{
			
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_STATUS = 'CD' ORDER BY A.CHART_DATE DESC");
			pstmt.setString(1,facility_id1);
			pstmt.setString(2,patient_id);
			rst=pstmt.executeQuery();
			
			
			}
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
		else if(func_mode.equalsIgnoreCase("displayFacilityEvalChartMenu")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			String chart_date = "";
			String chart_line_num = "";
			String chart_desc = "";
			String chart_line_status = "";
			StringBuffer eval_chart_menu = new StringBuffer();
			
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' ORDER BY A.CHART_NUM DESC");

			//Added Chart_num in the query to get the records with only that chart_num... By sridevi joshi on 28/04/08
			if (oh_chart_level.equals("E")){
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? AND A.CHART_LINE_STATUS IN('PE','CM') ORDER BY A.CHART_NUM DESC");
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'BC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			
		//	pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			pstmt.setString(3,chart_num);
			rst=pstmt.executeQuery();
			}else{
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'EC' AND CHART_NUM = ? AND A.CHART_LINE_STATUS IN('PE','CM') ORDER BY A.CHART_NUM DESC");
			//pstmt = con.prepareStatement("SELECT A.CHART_CODE,TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM,A.CHART_LINE_NUM, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND CHART_CODE = ? AND CHART_TYPE = 'BC' AND CHART_NUM = ? ORDER BY A.CHART_NUM DESC");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num);
			rst=pstmt.executeQuery();
			
			}
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
		/*
		else if(func_mode.equalsIgnoreCase("populatePerioSurfacesDesc")){	
			String surface_name = "";
			StringBuffer surface_code_name = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT SURFACE_NAME FROM OH_SURFACE_LANG_VW WHERE LANGUAGE_ID=? AND APPL_CHART_TYPE IN ('B','P') ORDER BY SURFACE_NAME");
			pstmt.setString(1,locale);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_name = checkForNull(rst.getString("SURFACE_NAME"));
				surface_code_name.append(surface_name);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}
		*/
		else if(func_mode.equalsIgnoreCase("populateSurfaceValuesDataEntry")){	
			String chart_type = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String component_code = checkForNull(request.getParameter("component_code"));
			//String tooth_no = checkForNull(request.getParameter("tooth_no"));
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
			
			//pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND A.TOOTH_NO = ? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
			//Commented by Sharon Crasta on 4/17/2009
			//pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND A.TOOTH_NO = ? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
			pstmt = con.prepareStatement("SELECT A.S1, A.S2, A.S3, A.S4, A.S5, A.S6, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_CODE = ? AND A.COMPONENT_CODE=? AND B.CHART_TYPE = ? AND A.CHART_LINE_NUM = ?");
		//	pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,component_code);
			//pstmt.setString(5,tooth_no);
			pstmt.setString(5,chart_type);
			pstmt.setString(6,chart_line_num);
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
		else if(func_mode.equalsIgnoreCase("getMaxMinValuesDataEntry")){	
			String component_code = checkForNull(request.getParameter("component_code"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String min_val = "";
			String max_val = "";
			String surfaces_appl_yn = "";
			StringBuffer surface_code_name = new StringBuffer();
			//pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, B.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP B WHERE  B.COMPONENT_CODE=?");
			pstmt = con.prepareStatement("SELECT B.MIN_VALUE, B.MAX_VALUE, A.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? AND B.COMPONENT_CODE=?");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				min_val = checkForNull(rst.getString("MIN_VALUE"));
				max_val = checkForNull(rst.getString("MAX_VALUE"));
				surfaces_appl_yn = checkForNull(rst.getString("SURFACES_APPL_YN"));
				surface_code_name.append(min_val+"##"+max_val+"##"+surfaces_appl_yn);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}else if(func_mode.equalsIgnoreCase("getToothValuesDataEntry")){	
			
			String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
			String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
			String q1_sno = checkForNull(request.getParameter("q1_sno"));
			String q2_sno = checkForNull(request.getParameter("q2_sno"));
			
			String display_tooth_no = "";			
			String tooth_no= "";			
			StringBuffer tooth_values = new StringBuffer();

			pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND B.QUADRANT_SNO IN (?,?)");
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,q1_sno);
			pstmt.setString(4,q2_sno);
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
				tooth_values.append(tooth_no+"##"+display_tooth_no);
				tooth_values.append("~");
			}
			out.println(tooth_values);
		}else if(func_mode.equalsIgnoreCase("getCutOffValues")){	
			String component_code = checkForNull(request.getParameter("component_code"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String cut_off = "";
			pstmt = con.prepareStatement("SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=?");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				cut_off = checkForNull(rst.getString("CUT_OFF"));
			}
			out.println(cut_off);
		} else if(func_mode.equalsIgnoreCase("getRecordsForTooth")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String tab_code = checkForNull(request.getParameter("tab_code"));
			//String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
			String perio_tooth = checkForNull(request.getParameter("perio_tooth"));
			/*if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			} */
			String perio_comp = "";
			String perio_value = "";
			StringBuffer perio_buffer = new StringBuffer();

			if(tab_code.equals("BC")){ // For Baseline Charts
				//if (oh_chart_level.equals("E")){
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A,OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND A.TOOTH_NO = ? AND C.CHART_TYPE = ?");
					
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,perio_tooth);
					pstmt.setString(6,tab_code);

					rst = pstmt.executeQuery();

					while(rst!= null && rst.next()){
						perio_comp = checkForNull(rst.getString("COMPONENT_CODE"));
						perio_value = checkForNull(rst.getString("VALUE"));
						perio_buffer.append(perio_comp+"##"+perio_value);
						perio_buffer.append("~");
					}
			}			
			else if(tab_code.equals("EC")){ //For Evaluation Charts		
				pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, A.VALUE FROM OH_PERIODONTAL_CHART_DTL A,OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND A.TOOTH_NO = ? AND C.CHART_TYPE = ?");
					
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,perio_tooth);
					pstmt.setString(6,tab_code);

					rst = pstmt.executeQuery();

					while(rst!= null && rst.next()){
						perio_comp = checkForNull(rst.getString("COMPONENT_CODE"));
						perio_value = checkForNull(rst.getString("VALUE"));
						perio_buffer.append(perio_comp+"##"+perio_value);
						perio_buffer.append("~");
					}
			}
			out.println(perio_buffer);
		
		}
		else if(func_mode.equalsIgnoreCase("checkMissingForCompletion")){	
			String chart_type = "";
			String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String header_tab = checkForNull(request.getParameter("header_tab"));
			if(header_tab.equals("E")){
				chart_type = "EC";
			}
			else{
				chart_type = "BC";
			}

			StringBuffer missing_buffer = new StringBuffer();
			
			String missing_cont = "";
			String missing_tooth_no = "";
			//pstmt = con.prepareStatement("SELECT C.NS_TOOTH_NO TOOTH_NO, COUNT(*) AS MISSING_CONT FROM OH_PERIODONTAL_CHART_DTL A, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE  PATIENT_ID =? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND CHART_CODE = ? AND COMPONENT_CODE = 'MITH' AND VALUE = '1' AND C.TOOTH_NO = A.TOOTH_NO AND C.NUMBERING_SYSTEM=? GROUP BY C.NS_TOOTH_NO");
			pstmt = con.prepareStatement("SELECT C.NS_TOOTH_NO TOOTH_NO,COUNT(A.COMPONENT_CODE) MISS_COUNT FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_TOOTH_BY_NUMBERING_SYSTEM C, OH_PERIODONTAL_CHART_DEF_DTL2 D WHERE A.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM  AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?  AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND B.CHART_TYPE = ? AND A.COMPONENT_CODE = 'MITH' AND A.VALUE = '1' AND C.TOOTH_NO = A.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND A.CHART_CODE = D.CHART_CODE AND A.COMPONENT_CODE = D.COMPONENT_CODE AND A.TOOTH_NO = D.TOOTH_NO GROUP BY C.NS_TOOTH_NO");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_type);
			pstmt.setString(7,tooth_numbering_system);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				missing_cont = checkForNull(rst.getString("MISSING_CONT"));
				missing_tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				missing_buffer.append(missing_cont+"##"+missing_tooth_no);
				missing_buffer.append("~");
			}
			out.println(missing_buffer);
		}else if(func_mode.equalsIgnoreCase("getComponentCode")){	
			String component_code = "";
			String component_desc = checkForNull(request.getParameter("component_desc"));
			pstmt = con.prepareStatement("SELECT COMPONENT_CODE FROM OH_PERIODONTAL_CHART_COMP WHERE COMPONENT_SHORT_DESC_USER_DEF = ?");
			pstmt.setString(1,component_desc);
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				component_code = checkForNull(rst.getString("COMPONENT_CODE"));
			}
			out.println(component_code);
		}else if(func_mode.equalsIgnoreCase("getToothNo")){	
			String tooth_no = "";
			String disp_tooth_no = checkForNull(request.getParameter("disp_tooth_no"));
			String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
			pstmt = con.prepareStatement("SELECT TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NS_TOOTH_NO = ? AND NUMBERING_SYSTEM = ?");
			pstmt.setString(1,disp_tooth_no);
			pstmt.setString(2,tooth_numbering_system);
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no = checkForNull(rst.getString("tooth_no"));
			}
			out.println(tooth_no);
		/*}else if(func_mode.equalsIgnoreCase("getChartDetailsFroHeader")){	//added by parul for IN016339 on 17/11/2009
			String chart_status = "";
			String chart_code_1 = "";
			String chart_date_start_bc = "";
			String chart_close_date_bc = "";
			String chart_num_1 = "";
			String chart_desc_1 = "";
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			StringBuffer bc_buffer = new StringBuffer();
			
			pstmt = con.prepareStatement("SELECT  A.CHART_STATUS, A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD,TO_CHAR (A.CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE ,A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC,  A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A  WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM','CD') AND A.CHART_CODE=? AND A.CHART_NUM=? ORDER BY A.CHART_DATE DESC")

			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			pstmt.setString(3,chart_num);
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
				chart_code_1 = checkForNull(rst.getString("CHART_CODE"));
				chart_date_start_bc = checkForNull(rst.getString("CHART_DATE_MOD"));
				chart_close_date_bc = checkForNull(rst.getString("CHART_CLOSE_DATE"));
				chart_num_1 = checkForNull(rst.getString("CHART_NUM"));
				chart_desc_1 = checkForNull(rst.getString("CHART_DESC"));
				bc_buffer.append(chart_status+"##"+chart_code_1+"##"+chart_date_start_bc+"##"+chart_close_date_bc+"##"+chart_num_1+"##"+chart_desc_1);

			}
			out.println(bc_buffer);*/
		}
	/*else if(func_mode.equalsIgnoreCase("getFacilityName")){	//added by parul for IN016339 on 17/11/2009
			String facility_name = "";

			//pstmt = con.prepareStatement("SELECT FACILITY_NAME  FROM SM_FACILITY_PARAM WHERE FACILITY_ID = (SELECT OPERATING_FACILITY_ID FROM OH_PERIODONTAL_CHART_HDR  WHERE CHART_NUM = ? AND PATIENT_ID = ?)");
			pstmt = con.prepareStatement("SELECT FACILITY_NAME  FROM SM_FACILITY_PARAM WHERE FACILITY_ID =?");
			pstmt.setString(1,facility_id);			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				facility_name = checkForNull(rst.getString("FACILITY_NAME"));

			}
			out.println(facility_name);
		}*/
		/*else if(func_mode.equalsIgnoreCase("getChartDetailsForHeaderEC")){	//added by parul for IN016339 on 17/11/2009
			String operating_facility_id_ec = "";
			String chart_code_ec = "";
			String chart_date_start_ec = "";
			String chart_close_date_ec = "";
			String chart_status_ec = "";
			String chart_desc_ec = "";
			String display_chart_num = "";
			String chart_type_ec = "";
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			StringBuffer ec_buffer = new StringBuffer();


			 pstmt = con.prepareStatement("SELECT A.CHART_TYPE,A.OPERATING_FACILITY_ID, A.CHART_CODE, TO_CHAR(A.CHART_LINE_DATE,'DD/MM/YYYY') CHART_DATE_MOD, A.CHART_NUM||'.'||A.CHART_LINE_NUM DISPLAY_CHART_NUM, TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM/YYYY') CHART_COMPLETED_DATE, A.CHART_LINE_STATUS,(SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE)  CHART_DESC FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE 	A.PATIENT_ID =?  AND 	CHART_CODE = ? AND 	CHART_TYPE = 'EC' AND CHART_NUM = ? AND CHART_LINE_NUM = ? ");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_code);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				operating_facility_id_ec = checkForNull(rst.getString("OPERATING_FACILITY_ID"));
				chart_code_ec = checkForNull(rst.getString("CHART_CODE"));
				chart_date_start_ec = checkForNull(rst.getString("CHART_DATE_MOD"));
				display_chart_num = checkForNull(rst.getString("DISPLAY_CHART_NUM"));
				chart_close_date_ec = checkForNull(rst.getString("CHART_COMPLETED_DATE"));
				chart_status_ec = checkForNull(rst.getString("CHART_LINE_STATUS"));
				chart_desc_ec = checkForNull(rst.getString("CHART_DESC"));
				chart_type_ec = checkForNull(rst.getString("CHART_TYPE"));
				ec_buffer.append(operating_facility_id_ec+"##"+chart_code_ec+"##"+chart_date_start_ec+"##"+display_chart_num+"##"+chart_close_date_ec+"##"+chart_status_ec+"##"+chart_desc_ec+"##"+chart_type_ec);

			}
			out.println(ec_buffer);
		}*/
		else if(func_mode.equalsIgnoreCase("CurrentDate")){ //added by rajesh for display the chart date in baseline for in018376
			String surgery_date="";
			pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') DATE_TIME, TO_CHAR(SYSDATE,'MM/YYYY') MON_YEAR, TO_CHAR(SYSDATE,'HH24:MI') HOURS_MTS FROM DUAL");
			rst = pstmt.executeQuery();
			while(rst.next()){
				surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}
			out.println(surgery_date);
			
		}else if(func_mode.equalsIgnoreCase("MissingToothCheck")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String tooth_num="";
			StringBuffer tooth_buff = new StringBuffer();
			//String sql_miss_tooth="SELECT TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID='"+patient_id+"' AND CHART_NUM = (SELECT CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID='"+patient_id+"' AND CHART_STATUS='A') AND (CONDITION_TYPE IN ('MISSTH','EXFOLTH') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS = (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_TYPE WHERE ORDER_STATUS_TYPE = 'CD')))";	
			String sql_miss_tooth="SELECT TOOTH_NO FROM OH_PERIODONTAL_CHART_DTL WHERE CHART_CODE='"+chart_code+"' AND CHART_NUM='"+chart_num+"' AND COMPONENT_CODE='MITH' AND CHART_LINE_NUM='"+chart_line_num+"' AND PATIENT_ID='"+patient_id+"' AND VALUE=1";	
			pstmt = con.prepareStatement(sql_miss_tooth);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_num = checkForNull(rst.getString("TOOTH_NO"));
				tooth_buff.append(tooth_num+"##");
			}
			out.println(tooth_buff);
		}
		 // Added by Yadav for CRF492 on 1/21/2010
		else if(func_mode.equalsIgnoreCase("setRemarksHistory")){
			int returnFlag=0;
			//int rem_seq_no=0;
			Hashtable htFormValues1  = (Hashtable) XMLobj.parseXMLString(request);
			htFormValues1 = (Hashtable)htFormValues1.get( "SEARCH" ) ;
			String patient_id = (String) htFormValues1.get( "patient_id");
			String chart_code = (String) htFormValues1.get( "chart_code");
			String chart_num = (String) htFormValues1.get( "chart_num");
			String added_by_id = (String) htFormValues1.get( "added_by_id");
			String added_at_ws_no = (String) htFormValues1.get( "added_at_ws_no");
			String remarks = (String) htFormValues1.get( "remarks");
			URLDecoder urlDecoder=null;
			remarks=urlDecoder.decode(remarks);
			String rem_seq_no = (String) htFormValues1.get( "rem_seq_no");
			/*if(rst != null) rst.close();
			if(pstmt != null) pstmt.close();
			pstmt=con.prepareStatement("SELECT REM_SEQ_NUM FROM OH_PERIODONTAL_CHART_REMARKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_CODE= ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			//pstmt.setString(3,chart_line_num);
			pstmt.setString(3,chart_code);
			rst=pstmt.executeQuery();
			while(rst.next()){
				rem_seq_no=Integer.parseInt(checkForNull(rst.getString("REM_SEQ_NUM"),"0"));
			}
			rem_seq_no=rem_seq_no+1;*/
             //by parul on 28/04/2010 for PE ,removed chart_line_num from query becoz remarks is chart level insertion 
			//pstmt = con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_REMARKS(PATIENT_ID,CHART_NUM,CHART_CODE,CHART_LINE_NUM,REM_SEQ_NUM,REMARKS,ADDED_BY_ID,ADDED_DATE_TIME,ADDED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,SYSDATE,?)");
			pstmt = con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_REMARKS(PATIENT_ID,CHART_NUM,CHART_CODE,REM_SEQ_NUM,REMARKS,ADDED_BY_ID,ADDED_DATE_TIME,ADDED_AT_WS_NO) VALUES(?,?,?,?,?,?,SYSDATE,?)");
				
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_code);
	//		pstmt.setString(4,chart_line_num);
			pstmt.setString(4,rem_seq_no+"");
			pstmt.setString(5,remarks);
			pstmt.setString(6,added_by_id);
			pstmt.setString(7,added_at_ws_no);
			returnFlag = pstmt.executeUpdate();

			if(returnFlag != 0){
				con.commit();
			}else{
				con.rollback();
			}
		}
		// Added by Yadav for CRF492 on 1/21/2010
		else if(func_mode.equalsIgnoreCase("showRemarkLink")){
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String perio_chart = checkForNull(request.getParameter("perio_chart"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String query="";int count=0;
			if(rst != null) rst.close();
			if(pstmt != null) pstmt.close();
			if(!perio_chart.equals("")){
				query="SELECT COUNT (*) FROM OH_PERIODONTAL_CHART_HDR WHERE PATIENT_ID  = ? AND CHART_STATUS IN ('CM','PE') AND CHART_CODE = ? AND CHART_NUM=?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,perio_chart);
				pstmt.setString(3,chart_num);
				rst=pstmt.executeQuery();
				if(rst.next()){
					count = rst.getInt(1);
				}
			}
			out.println(count);
		}	
		// Added by Yadav for CRF492 on 1/21/2010
		else if(func_mode.equalsIgnoreCase("showRemarkHistoryLink")){
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String perio_chart = checkForNull(request.getParameter("perio_chart"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String sql1="";
			int count_rmt=0;
			if(rst != null) rst.close();
			if(pstmt != null) pstmt.close();
			if(!perio_chart.equals("")){
				//commented by parul on 28/04/2010 for PE 
				//sql1="SELECT REMARKS FROM OH_PERIODONTAL_CHART_REMARKS WHERE PATIENT_ID=? AND CHART_NUM = ?  AND CHART_CODE= ? ";
				sql1="SELECT  COUNT (*) FROM OH_PERIODONTAL_CHART_REMARKS WHERE PATIENT_ID=? AND CHART_NUM = ?  AND CHART_CODE= ? ";
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,perio_chart);
				rst=pstmt.executeQuery();
				if(rst.next()){
					count_rmt = rst.getInt(1);
				}
			}
			out.println(count_rmt);
		}
		// Added by Yadav for CRF476 on 2/23/2010
		else if(func_mode.equalsIgnoreCase("getMaxillaConditionFlag")){
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			chart_num=chart_num.trim();
				int counter=0;
				 //The below code gets the CONDITION_TYPE from OH_RESTORATIVE_CHART_DTL table
				if(rst != null) rst.close();
				if(pstmt != null) pstmt.close();
				String sql1="SELECT a.CONDITION_TYPE,b.CONDITION_DESC,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE,a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a,OH_CONDITION_LANG_VW b WHERE a.CONDITION_CODE = b.CONDITION_CODE and  a.PATIENT_ID=? AND a.CHART_NUM = ?  AND a.CONDITION_TYPE IN('MALPOSN','MALOCLN','MXNTL')  and b.LANGUAGE_ID = ? order by  a.TREATMENT_CONDITION_DATE desc";
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,locale);
				rst=pstmt.executeQuery();
				while(rst.next()){
				counter++;	
				}
				out.println(counter);
		}
		// Added by Yadav for CRF476 on 2/23/2010
		else if(func_mode.equalsIgnoreCase("getMaxillaTreatmentFlag")){
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			chart_num=chart_num.trim();
				int counter=0;
				 //The below code gets the Treatment from OH_RESTORATIVE_CHART_DTL table
				if(rst != null) rst.close();
				if(pstmt != null) pstmt.close();
				String sql1="SELECT a.TRMT_CATEGORY_TYPE,b.TRMT_DESC,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a, OH_TREATMENT_LANG_VW  b WHERE a.TRMT_CODE=b.TRMT_CODE AND a.PATIENT_ID=? AND a.CHART_NUM = ? AND a.TRMT_CATEGORY_TYPE IN('MAXILLA') and a.TREATMENT_INT_EXT='I' and b.LANGUAGE_ID  = ? order by  a.TREATMENT_CONDITION_DATE desc";
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,locale);
				rst=pstmt.executeQuery();
				while(rst.next()){
				counter++;	
				}
					out.println(counter);

		}else if(func_mode.equalsIgnoreCase("populatePeriodontalSummary")){//added by parul on 03/05/2010 for IN021073
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String encounter_id = "";
			String patient_class = "";
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			int flag_sum=0;
				cstmt=con.prepareCall("{call OH_CALCULATE_SUMMARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1,facility_id);
				cstmt.setString(2,patient_id);
				cstmt.setString(3,encounter_id);
				cstmt.setString(4,patient_class);
				cstmt.setString(5,chart_num);
				cstmt.setString(6,chart_code);
				cstmt.setString(7,chart_line_num);
				cstmt.setString(8,"N");
				cstmt.setString(9,login_user);
				cstmt.setString(10,client_ip_address);

				cstmt.registerOutParameter(11,Types.VARCHAR);	//P_INDEX_VALUE
				cstmt.registerOutParameter(12,Types.VARCHAR);	//P_COMPONENT_VALUE
				cstmt.registerOutParameter(13,Types.VARCHAR);	//P_STATUS
				cstmt.registerOutParameter(14,Types.VARCHAR);	//P_ERR_MSG
				cstmt.registerOutParameter(15,Types.VARCHAR);	//P_LANG_ERR_MSG_ID
				cstmt.execute();

				String p_index_value 		= checkForNull(cstmt.getString(11),"");
				String component_value 	= checkForNull(cstmt.getString(12),"");

                if ((p_index_value!="") || (component_value!="")){
				   flag_sum=1;
				}
				out.println(flag_sum);

		}
		/*else if(func_mode.equalsIgnoreCase("callComponentCode")){//Added by rajesh for Perio Graph Component code fiter

			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String sql1="";
			String comp_code="";
			StringBuffer code_buff = new StringBuffer();
					if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
						sql1="SELECT DISTINCT(COMPONENT_CODE) COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DTL WHERE PATIENT_ID=? AND CHART_CODE=? AND CHART_NUM=? AND OPERATING_FACILITY_ID='HS'";
						pstmt=con.prepareStatement(sql1);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,chart_num);
						rst=pstmt.executeQuery();
						 while(rst.next())
						{
							 comp_code = checkForNull(rst.getString("COMPONENT_CODE"));
							 code_buff.append(comp_code+"##");
						}
					out.println(code_buff);
		}*/	
	

	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from OH PerioCommonValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(cstmt!=null)cstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
