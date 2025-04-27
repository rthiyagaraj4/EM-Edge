<!DOCTYPE html>
<html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<body class="MESSAGE" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%!
   String isFutureBlock(String facility_id,String bed_no,String nursingunit,Connection con)
	{
		
		String sql = "Select booking_type,override_yn,PATIENT_ID from ip_bed_booking WHERE facility_id='"+facility_id+"' and req_nursing_unit_code='"+nursingunit+"' and req_bed_no='"+bed_no+"' and booking_status='0' and blocked_from_date_time > sysdate";
		String temp_flag = "";
		Statement stmt1 = null;
		ResultSet rset1 = null;
		try
		{
			
			stmt1 = con.createStatement();
			rset1 = stmt1.executeQuery(sql);
			if(rset1!=null && rset1.next())
			{
				temp_flag = "Y";
			}
			
							if (stmt1 != null) stmt1.close();
				if (rset1 != null) rset1.close();
			
			}catch(Exception e) {
				e.printStackTrace();
				}

			return temp_flag;
	}
%>

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

