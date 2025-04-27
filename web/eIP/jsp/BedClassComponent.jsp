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
	 
	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
%>
	<select name='Bedcode' id='Bedcode'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
	try{
		con = ConnectionManager.getConnection(request);
		
	    //String sql2 = " Select bed_class_code, short_desc from IP_BED_CLASS_LANG_VW where language_id = '"+locale+"' AND eff_status='E' order by short_desc ";
	   String sql2 = " Select bed_class_code, ip_get_desc.IP_BED_CLASS(bed_class_code ,?,2)short_desc from IP_BED_CLASS where  eff_status='E' order by short_desc ";
	   pstmt = con.prepareStatement(sql2);
	   pstmt.setString(1,locale);
	    rs = pstmt.executeQuery();
            
		if( rs != null )
		{
	      while( rs.next() )
	      {
			 String bedcode   = rs.getString(1) ;
			 String beddesc   = rs.getString(2) ;

	%>
			 <OPTION VALUE="<%=bedcode%>" ><%=beddesc%>
<%         }
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
%>
</select>           
            

