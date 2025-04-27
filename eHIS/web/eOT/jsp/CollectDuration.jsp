
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String catalog_code=""+request.getParameter("catalog_code");
	String duration="";
	String strSurgeonCode="";
	String strOperationCode="";
	String flag=request.getParameter("flag");
	String sql="";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try{
	conn = ConnectionManager.getConnection(request);
	if(flag.equals("1")==true){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT1");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,catalog_code);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				duration=rs.getString("APPT_TIME1");
				duration+="::"+rs.getString("APPT_TIME2");
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
		duration=duration.trim();
		out.print(duration);
	}else{
		/*			sql="SELECT AVG_SURGERY_TIME AVG_SURGERY_TIME1 FROM OT_SURG_OPER_AVG_TIME WHERE  PRACTITIONER_ID = ? AND OPER_CODE = ?";
		*/
		sql=""+OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT2");
		strSurgeonCode=request.getParameter("surgeonCode");
		strOperationCode=request.getParameter("operationCode");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strSurgeonCode);
		pstmt.setString(2,strOperationCode);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				duration=rs.getString("AVG_SURGERY_TIME1");
			}
			out.print(duration);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
}catch(Exception expSQL){
	System.err.println(expSQL);
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null)	pstmt.close();
	ConnectionManager.returnConnection(conn, request);
}
%>



