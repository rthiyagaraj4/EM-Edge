<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" %>
<%	
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	 
	Connection con			= null ;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	con						= ConnectionManager.getConnection(request);
	String calledfrom		= checkForNull(request.getParameter("calledfrom"));
	
%>

<select name='bed_type_code' id='bed_type_code'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
	if(!calledfrom.equals("TransferPatientOut"))
	{
	try
	{		
	   
		//String sql2 = " Select short_desc, bed_type_code from IP_BED_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
		/*Saturday, April 24, 2010 modified for PE*/
		String sql2 = " Select ip_get_desc.ip_bed_type(bed_type_code,?,2) short_desc, bed_type_code from IP_BED_TYPE where eff_status='E' order by short_desc ";

		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,locale);
	    rs = pstmt.executeQuery();

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String short_desc = rs.getString( "short_desc" ) ;
				String bed_type_code = rs.getString( "bed_type_code" ) ;
%>
				<OPTION VALUE="<%=bed_type_code%>" ><%=short_desc%>
<%
	          }
	      }
		
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	}
%>
</select>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

