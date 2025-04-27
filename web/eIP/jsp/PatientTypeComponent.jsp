<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<html>
<script>
function setFocusAdd()
{
	if(document.forms[0].name =='AdmitPatient_form')
	{
		 document.getElementById('tab1').scrollIntoView();
	     document.getElementById('nursing_unit_desc').focus();
	}
}  

</script>

<%	
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;
%>

	<select name='PatCode' id='PatCode' onblur='setFocusAdd()' style='width:150'><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---

<%
	    String sql2="Select patient_type,short_desc from am_patient_type where eff_status='E' order by short_desc ";	   
		try
		{
			con = ConnectionManager.getConnection(request);;
		    stmt = con.createStatement();
			rs = stmt.executeQuery(sql2);
            
            if( rs != null )
            {
		      while( rs.next() )
			  {
				 String pattype   = rs.getString(1) ;
				 String patdesc   = rs.getString(2) ;

%>
			 	 <OPTION VALUE="<%=pattype%>" ><%=patdesc%>
<%            }
			}
		
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		
		}catch(Exception e)
		{
			out.println(e.toString());
		}
		finally
		{
			
			ConnectionManager.returnConnection(con,request);
		}
%>
</select>           
   </html>         

