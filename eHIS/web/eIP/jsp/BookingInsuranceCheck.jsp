<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../js/Booking.js' language='javascript'></script>
	<script src='../js/Booking1.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body class='Message' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	String patId = request.getParameter("patId");
	if (patId==null) patId = "";
	String prDt = (String) request.getParameter("prefDt");
	if (prDt==null) prDt = "";
	java.sql.Date prefDt = java.sql.Date.valueOf(prDt);
	String facilityId = (String)session.getValue("facility_id"); 

	boolean isBlInterfaced=false;
	Connection con = null;
	Statement stmt = null;
    CallableStatement cstmt = null;
	ResultSet rs1 = null;

	String retVal="";
	
	try {
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs1 = stmt.executeQuery("Select BL_INTERFACED_YN from ip_param where facility_id='"+facilityId+"'");
		if(rs1.next()) {
			if(rs1.getString("BL_INTERFACED_YN").equals("Y")) isBlInterfaced=true;
			else isBlInterfaced=false;
		}
		if(isBlInterfaced) {
			cstmt = con.prepareCall("{ call BL_CHK_INS_EXPIRY(?,?,?) }");
			cstmt.setString(1,patId);
			cstmt.setDate(2,prefDt);
			cstmt.registerOutParameter(3,3);
			cstmt.execute();
			retVal = cstmt.getString(3);
			if (retVal==null) retVal = "";			
			if(retVal.equals("1")){
				out.println("<script>alert(getMessage('INSURANCE_EXPIRE_BEFORE_ADM','IP'))</script>");
				out.println("<script>parent.f_query_add_mod.callApply_bl()</script>");
			}
			else if(retVal.equals("2")){
				out.println("<script>alert(getMessage('INSURANCE_EXPIRE','IP'))</script>");
				//INSURANCE_EXPIRE - IP
				out.println("<script>parent.f_query_add_mod.callApply_bl()</script>");
			}
			else {
				out.println("<script>parent.f_query_add_mod.callApply_bl()</script>");
			}
		}
		else {
			out.println("<script>parent.f_query_add_mod.callApply_bl()</script>");
		}
	
	
		 if(rs1 != null) rs1.close();
		 if(cstmt != null) cstmt.close();
		 if(stmt != null) stmt.close();

	}catch(Exception e) {
		out.println(e.toString());
	}
	finally {
		
		 ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

