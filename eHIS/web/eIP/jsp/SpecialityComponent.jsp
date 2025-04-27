<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;
%>
<select name='Splcode' id='Splcode' onchange='setGroupBy()' width="15"><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%  try
	{
		con = ConnectionManager.getConnection(request);		
		stmt = con.createStatement();
		String sql2=" Select Speciality_code, short_desc from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
		String Splcode   = "";
		String Spldesc   = "";

		rs = stmt.executeQuery(sql2);
		if( rs != null )
		{
			while( rs.next() )
			{
				Splcode   = rs.getString(1);
				Spldesc   = rs.getString(2);
%>
				<OPTION VALUE="<%=Splcode%>" ><%=Spldesc%>
	<%		}
		}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e) { /* out.println(e.getMessage()); */ e.printStackTrace(); }
		finally
		{		  
		  	ConnectionManager.returnConnection(con,request);
	  }
%>
</select>
            

