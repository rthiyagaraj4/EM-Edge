
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>



<% 
		request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
		String locale = (String)session.getAttribute("LOCALE");
		String encounter_id = request.getParameter("encounter_id");
		String patient_class = request.getParameter("patient_class");
		String facility_id = (String)session.getAttribute("facility_id");
		String result="";
		String locn_type="";
		String locn_code="";
		String locn_desc="";

		String SQL ="SELECT ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=?  AND ENCOUNTER_ID=?";

		String location_desc1="SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE FACILITY_ID=? AND LANGUAGE_ID=? AND NURSING_UNIT_CODE=?";

		String location_desc2="	SELECT LONG_DESC FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID=? AND LANGUAGE_ID=? AND CLINIC_CODE=?";
				
		String NURSING_UNIT_DESC = ("IP".equals(patient_class) || "DC".equals(patient_class))? location_desc1:location_desc2;

		if("XT".equals(patient_class)){
			out.println("R@''@''");
			return;
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				 locn_type=rst.getString(1);
				 locn_code=rst.getString(2);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(NURSING_UNIT_DESC);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,locn_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				 locn_desc=rst.getString(1);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			result=locn_type+"@"+locn_code+"@"+locn_desc;
			out.println(result);
		}catch(Exception e){
			System.err.println("Err Msg in TempEncounterLkup.jsp"+e.getMessage());
			out.println(e);
		} finally{
			try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}

%>


