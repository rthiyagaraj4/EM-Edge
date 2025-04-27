<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<% 
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String facility_id = request.getParameter("facility_id");
	String order_id = request.getParameter("order_id");
	String patient_id = "";
	String patient_class = "";
	StringBuffer append_str = new StringBuffer();
	String sql = "";
	String patient_name = "";
	String encounter_id = "";
	String sex = "";
	String dob = "";
	String episode_type = "";
	String patient_class_desc = "";
	String data_count = "";
	String order_type_code ="";
	String ordered_date = "";
	append_str.append("::");
	try{
		connection = ConnectionManager.getConnection(request);
// GET THE PATIENT ID BASED FOR THE SELECTED ORDER_ID
		sql="SELECT PATIENT_ID, PATIENT_CLASS, ENCOUNTER_ID FROM OR_ORDER WHERE ORDER_CATEGORY = 'RD' AND ORDER_ID=?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			patient_id = resultset.getString("PATIENT_ID");
			patient_class = resultset.getString("PATIENT_CLASS");
			encounter_id = resultset.getString("ENCOUNTER_ID");
		}
		append_str.append(patient_id+"::");
		append_str.append(encounter_id+"::");

// GET THE PATIENT DETAILS


//Modifued by rajesh for displaying patient name in locale language
		sql ="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH, DECODE(SEX,'F','Female','M','Male','Unknown') SEX FROM MP_PATIENT WHERE PATIENT_ID=?";
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,patient_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			patient_name = resultset.getString("SHORT_NAME");
			sex = resultset.getString("SEX");
			dob = resultset.getString("DATE_OF_BIRTH");
		}
		append_str.append(patient_name+"::");
		append_str.append(sex+"::");
		append_str.append(dob+"::");

// GET THE PATIENT CLASS DESCRIPTION
		sql = "SELECT EPISODE_TYPE, SHORT_DESC FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ?"; 

		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,patient_class);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			episode_type = resultset.getString("EPISODE_TYPE");
			patient_class_desc = resultset.getString("SHORT_DESC");
		}
		append_str.append(episode_type+"::");
		append_str.append(patient_class+"::");
		append_str.append(patient_class_desc+"::");	


// CHECK WHETHER DATA EXISTS OR NOT FOR THE SELECTED ORDER_ID
		sql = "SELECT COUNT(*) DATA_COUNT FROM RD_REQUEST_CHECK_LSIT_HDR WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL='1'"; 

		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,order_id);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			data_count = resultset.getString("DATA_COUNT");
		}
		if(data_count.equals("1")){
			append_str.append("DATA_EXISTS::");
			sql = "SELECT NVL(COMPLETED_BY_ID,'##') COMPLETED_BY_ID FROM RD_REQUEST_CHECK_LSIT_HDR WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL=1"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,order_id);
			resultset=pstmt.executeQuery();
			String completed_by_id = "";
			while(resultset.next()){
				completed_by_id = resultset.getString("COMPLETED_BY_ID");
			}
			if(completed_by_id.equals("##"))
				append_str.append("N::");	
			else
				append_str.append("Y::");	
		}else{
			append_str.append("NO_DATA_EXISTS::");
			append_str.append("N::");	
		}
// GET THE ORDER_TYPE_CODE
		sql="SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, ORDER_TYPE_CODE FROM OR_ORDER WHERE ORDER_CATEGORY = 'RD' AND ORDER_ID=?";
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			order_type_code = resultset.getString("ORDER_TYPE_CODE");
			ordered_date	= resultset.getString("ORD_DATE_TIME");			
		}
		append_str.append(order_type_code+"::");	
		append_str.append(ordered_date+"::");	
	}catch(Exception e){
		System.err.println("Err Msg in ExamsCheckListValidation.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	out.println(append_str);
	append_str.setLength(0);
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">


