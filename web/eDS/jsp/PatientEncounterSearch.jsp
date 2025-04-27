<%@  page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>


<% request.setCharacterEncoding("UTF-8"); 
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		conn = ConnectionManager.getConnection(request);
		String sql = request.getParameter("sql");
		String patient_class = request.getParameter("patient_class");
		String patient_id = request.getParameter("patient_id");
		String facility_id=(String)session.getAttribute("facility_id"); 
		String count = "";
		String strLinkData = "";
		String encounter_id="";
		String patient_class_rst="";
		String episode_id="";
		String op_episode_visit_num="";
		String episode_type="";
		String sql_count="SELECT COUNT(*) FROM IP_OPEN_ENCOUNTER WHERE FACILITY_ID=? AND PATIENT_ID=? AND PATIENT_CLASS=?";
			pstmt = conn.prepareStatement(sql_count);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,patient_class);
			rs = pstmt.executeQuery();
			while(rs.next()){
				count=rs.getString(1);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(count.equals("1")){
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,patient_class);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,patient_class);
				rs = pstmt.executeQuery();
				while(rs.next()){					
					encounter_id=checkForNull(rs.getString("ENCOUNTER_ID"));
					patient_class_rst=checkForNull(rs.getString("PATIENT_CLASS"));
					episode_id=checkForNull(rs.getString("EPISODE_ID"));
					op_episode_visit_num=checkForNull(rs.getString("OP_EPISODE_VISIT_NUM"));
					episode_type=checkForNull(rs.getString("EPISODE_TYPE"));
				}
		  }			strLinkData=count+"::"+encounter_id+"::"+patient_class_rst+"::"+episode_id+"::"+op_episode_visit_num+"::"+episode_type;
		  out.println(strLinkData);		
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}finally{
		rs.close();
		pstmt.close();
        ConnectionManager.returnConnection(conn,request);
	}
%>
