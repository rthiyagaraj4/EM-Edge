<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs =null;
	
%>
	 <select name='Bedcode' id='Bedcode' onChange='onBedClassChange(this)' tabindex='4' style='width:150'><option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option> 
<%
	try{
			stmt = con.createStatement();
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("Select bed_class_code,short_desc from ip_bed_class where eff_status='E' order by short_desc ");
			rs = stmt.executeQuery(sqlQuery.toString());
            
            if( rs != null )
            {
	      while( rs.next() )
	      {
			 String bedcode   = rs.getString("bed_class_code") ;
			 String beddesc   = rs.getString("short_desc") ;

%>
	 	 <OPTION VALUE="<%=bedcode%>" ><%=beddesc%></option>
<%            }
	    }
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</select>           
            

