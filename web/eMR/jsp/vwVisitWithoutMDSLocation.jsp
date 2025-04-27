<!DOCTYPE html>
  
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>



<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	
	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;
	con =  ConnectionManager.getConnection(request);
	 stmt	= con.createStatement();

	 String clinic_code="";
	 String nursing_unit_code="";
	 String short_desc="";
	 String enc_type1=checkForNull(request.getParameter("enc_type"));
	 
	 
	 try
	 {
		if(enc_type1.equals("OP"))
		{

		StringBuffer clinicCode = new StringBuffer();
		String sql				= "";
		sql="SELECT CLINIC_CODE,short_desc FROM  op_clinic WHERE LEVEL_OF_CARE_IND='A'";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				clinic_code = checkForNull(rs.getString("CLINIC_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				clinicCode.append(clinic_code+"##"+short_desc);
				clinicCode.append("~");
			}
			out.println(clinicCode);
			
				
			
		}
		else if(enc_type1.equals("DC"))
		{

		StringBuffer nursingUNitCode = new StringBuffer();
		String sql				= "";
		sql="select NURSING_UNIT_CODE, SHORT_DESC from ip_nursing_unit where facility_id='"+p_facility_id+"' and APPL_PATIENT_CLASS='DC' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				nursing_unit_code = checkForNull(rs.getString("NURSING_UNIT_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				nursingUNitCode.append(nursing_unit_code+"##"+short_desc);
				nursingUNitCode.append("~");
			}
			out.println(nursingUNitCode);	
		
				
		}
		else if(enc_type1.equals("IP"))
		{
		StringBuffer nursingUNitCode = new StringBuffer();
		String sql				= "";
		sql="select NURSING_UNIT_CODE, SHORT_DESC from ip_nursing_unit where facility_id='"+p_facility_id+"' and APPL_PATIENT_CLASS='IP' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);
		
				
		while(rs!= null && rs.next()){
				nursing_unit_code = checkForNull(rs.getString("NURSING_UNIT_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				nursingUNitCode.append(nursing_unit_code+"##"+short_desc);
				nursingUNitCode.append("~");
			}
			out.println(nursingUNitCode);	
		
		}
		else if(enc_type1.equals("EM"))
		{

			StringBuffer clinicCode = new StringBuffer();
		String sql				= "";
		sql="select CLINIC_CODE, SHORT_DESC from op_clinic where facility_id='HS' and LEVEL_OF_CARE_IND='E' order by SHORT_DESC";
		rs = stmt.executeQuery(sql);

		while(rs!= null && rs.next()){
				clinic_code = checkForNull(rs.getString("CLINIC_CODE"));
				short_desc = checkForNull(rs.getString("short_desc"));
				clinicCode.append(clinic_code+"##"+short_desc);
				clinicCode.append("~");
			}
			out.println(clinicCode);				
				
			}
%>

<%
	 }
	 catch(Exception e){
		//out.println("Exception="+e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>	

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
