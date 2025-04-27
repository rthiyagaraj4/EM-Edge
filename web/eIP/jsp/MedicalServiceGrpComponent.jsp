<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con ;
	Statement stmt=null;
	ResultSet rs =null;
	String facilityID=(String)session.getValue("facility_id");
	con = ConnectionManager.getConnection(request);
%>

	<select name='medical_service_grp' id='medical_service_grp' ><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---

<%
	try{
		stmt = con.createStatement();
	    String sql2="SELECT  MED_SER_GRP_CODE, SHORT_DESC FROM ip_medical_service_group where facility_id = '"+facilityID+"' order by SHORT_DESC ";
	    rs = stmt.executeQuery(sql2);
            
            if( rs != null )
            {
	      while( rs.next() )
	      {
				String medicalservicecode   = rs.getString(1) ;
				String medicalservicedesc   = rs.getString(2) ;

%>
	 	 <OPTION VALUE="<%=medicalservicecode%>" ><%=medicalservicedesc%>
<%            }
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	    }
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</select>           
            

