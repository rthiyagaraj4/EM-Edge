<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	 
	Connection con ;
	PreparedStatement stmt=null;
	ResultSet rs =null;
	con = ConnectionManager.getConnection(request);
%>	
	<select name='blocktype' id='blocktype' ><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>

<%
	try{
			//String sql2 = " Select blocking_type_code,short_desc from IP_BLOCKING_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status ='E' order by 2 ";
			/*Wednesday, May 12, 2010 , modified for PE */
			String sql2 = " Select blocking_type_code,ip_get_desc.ip_blocking_type(blocking_type_code,?,2)short_desc from IP_BLOCKING_TYPE where eff_status ='E' order by 2 ";
			stmt = con.prepareStatement(sql2);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();
            
            if( rs != null )
			{
				while( rs.next() )
				{
					String code   = rs.getString(1) ;
					String desc   = rs.getString(2) ;
					%>
					<OPTION VALUE="<%=code%>" ><%=desc%></option>
					<%            
				}
			}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</select>         
            

