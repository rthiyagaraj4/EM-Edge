
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject" contentType="text/html;charset=UTF-8" %>


<%  
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id		= (String) session.getValue( "facility_id" ) ;
	String Group_id			= (String) request.getParameter("GroupId") ;
	String LOCN_NAME		= "";
	String LOCN_CODE		= "";
	String MIN_PATIENTS		= "";
	String MAX_PATIENTS		= "";	
	int isJsonResults		= 0;
	int TotMemberInGroup	= 0;
	 
	 
	JSONObject json = new JSONObject();
	//String sql = "select MIN_PATIENTS,MAX_PATIENTS  from oa_group_hdr where GROUP_ID=?";
	/*Above query commented and below query added by senthil*/		
	String sql = "select  op_get_desc.op_clinic('"+facility_id+"', LOCN_CODE, '"+locale+"','1') LOCN_NAME,LOCN_CODE,MIN_PATIENTS,MAX_PATIENTS  from oa_group_hdr where GROUP_ID=?";
	
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();			
	if(rs1!=null && rs1.next()) {
	   /*below line modified and added by senthil*/	
        LOCN_NAME = rs1.getString("LOCN_NAME")==null?"":rs1.getString("LOCN_NAME");
		LOCN_CODE = rs1.getString("LOCN_CODE")==null?"":rs1.getString("LOCN_CODE");		
		MIN_PATIENTS = rs1.getString("MIN_PATIENTS")==null?"":rs1.getString("MIN_PATIENTS");	
		MAX_PATIENTS = rs1.getString("MAX_PATIENTS")==null?"":rs1.getString("MAX_PATIENTS");	
	} 
	/*below line modified and added by senthil*/	
	if(!LOCN_NAME.equals("") && !MIN_PATIENTS.equals("") && !MAX_PATIENTS.equals("")){	     
		  json.put("LOCN_NAME", LOCN_NAME);  
	      json.put("LOCN_CODE", LOCN_CODE); 
	      json.put("MIN_PATIENTS", MIN_PATIENTS);  
	      json.put("MAX_PATIENTS", MAX_PATIENTS); 
	      isJsonResults	= 1;
	}
	if(pstmt != null) pstmt.close();
	if(rs1  != null) rs1.close();	
	
	
	String sql1 = "select count(*) TOTGRPMEM from OA_GROUP_DTLS where GROUP_ID=?";
	pstmt = conn.prepareStatement(sql1);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();	
	if(rs1!=null && rs1.next()) {		 
		TotMemberInGroup = rs1.getInt("TOTGRPMEM");
	}
	json.put("TotMemberInGroup", TotMemberInGroup);
	json.put("isJsonResults", isJsonResults);
	out.print(json);
	
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
