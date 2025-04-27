<!DOCTYPE html>
<%@ page import ="java.sql.ResultSet,java.sql.PreparedStatement,java.sql.Connection,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<% 
	Connection connection	 = null;
	PreparedStatement pstmt  = null;
	ResultSet resultset		 = null;
	
	String type = request.getParameter("type");
	String order_catalog_code = request.getParameter("order_catalog_code");
	String oper_code = request.getParameter("oper_code");
	String appt_time="";
	String order_type_code="";
	String splty_code="";
	String splty_desc= "";
	String pat_instr_text_eng ="null";
	String pat_instr_text_local ="null";
	int x_cnt=0;
	try{
		connection = ConnectionManager.getConnection(request);

		if (type.equals("appt_time")){
			String ordercat_time = "SELECT TO_CHAR(APPT_TIME, 'HH24:MI')  AS APPTTIME , ORDER_TYPE_CODE FROM OR_ORDER_CATALOG_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY = 'OT' AND NVL(EFF_STATUS, 'D') = 'E' AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL AND ORDER_CATALOG_CODE = ?";

		   String sql_splty = "SELECT A.SPECIALITY_CODE, B.SHORT_DESC FROM OT_SPECIALITY_ORDER_TYPES A, AM_SPECIALITY B WHERE A.SPECIALITY_CODE = B.SPECIALITY_CODE AND ORDER_TYPE_CODE = ?";

		   String sql_instr_eng_text= "SELECT PAT_PREPS_OR_INSTRNS_TXT  FROM OR_ORDER_CATALOG_PREPS_INSTRN  WHERE ORDER_CATALOG_CODE = ? AND PAT_PREPS_OR_INSTRNS_IND = 'IS'";

		   String sql_instr_local_text = "SELECT patient_instrn_local  FROM   ot_pat_age_sex_instrn  WHERE  oper_code                = ?  AND    pat_preps_or_instrns_ind = 'IS'";																 
		   String sql_chek_cat_dup = "SELECT COUNT(*) FROM OT_OPER_MAST WHERE  ORDER_CATALOG_CODE = ? AND NVL(STATUS,'D') = 'E'";

			
			pstmt = connection.prepareStatement(sql_chek_cat_dup);
			pstmt.setString(1,order_catalog_code);
			resultset = pstmt.executeQuery();
			while(resultset.next()){
				x_cnt = Integer.parseInt(resultset.getString(1)); 
			}

			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			
			pstmt = connection.prepareStatement(ordercat_time);
			pstmt.setString(1,order_catalog_code);
			resultset = pstmt.executeQuery();
			while(resultset.next()){
				appt_time = resultset.getString(1); 
				order_type_code = resultset.getString(2);
			}

			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();

			pstmt = connection.prepareStatement(sql_splty);
			pstmt.setString(1,order_type_code);
			resultset = pstmt.executeQuery();

			while(resultset.next()){
				splty_code = resultset.getString(1); 
				splty_desc = resultset.getString(2); 
			}

			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();

	pstmt = connection.prepareStatement(sql_instr_eng_text);
	pstmt.setString(1,order_catalog_code);
	resultset = pstmt.executeQuery();
	while( resultset.next() ){
			pat_instr_text_eng = resultset.getString(1); 
	}

	if(resultset!=null)resultset.close();
	if(pstmt!=null)pstmt.close();

			pstmt = connection.prepareStatement(sql_instr_local_text);
			pstmt.setString(1,oper_code);
			resultset = pstmt.executeQuery();

			while(resultset.next()){
				pat_instr_text_local = resultset.getString(1); 
			}

			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();

out.println(appt_time+"::"+order_type_code+"::"+splty_code+"::"+splty_desc+"::"+pat_instr_text_eng+"::"+pat_instr_text_local+"::"+x_cnt);
		}
	}

	catch(Exception e){
		System.err.println("Err Msg in DiaryScheduleDtls.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	
%>

