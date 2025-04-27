
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String login_user      = (String) session.getAttribute("login_user");
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;
	String splty_code = request.getParameter( "splty_code" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );

	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("populateLocType")){	
			String sql				= "";		
			String locn_type = "";
			String note_type = "";
			StringBuffer locn_type_buff = new StringBuffer();
			
				sql = "SELECT LOCN_TYPE,NOTE_TYPE FROM OT_NOTE_TYPE_FOR_SPECIALTIES where SPECIALTY_CODE=?";
				pstmt = con.prepareStatement(sql);
					pstmt.setString(1,splty_code);
					rst=pstmt.executeQuery();
					while(rst!=null && rst.next()){
						locn_type=rst.getString("LOCN_TYPE");
						note_type=rst.getString("NOTE_TYPE");
					locn_type_buff.append(locn_type+"##"+note_type);
					locn_type_buff.append("~");
				}
				out.println(locn_type_buff);
		}

		}catch(Exception e){
		System.err.println("Err Msg from CommonValidation.jsp "+e);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
