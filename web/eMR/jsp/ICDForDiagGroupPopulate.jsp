<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*,webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

     <%
		request.setCharacterEncoding("UTF-8");
        Connection conlConn = null;
		PreparedStatement stmt = null;
		ResultSet rstlRs = null;
		String speciality_code="",practitioner_id="",diag_group_code="";
		String speciality_desc="",practitioner_name="",facility_name="",group_type="";
	try
	{
	      out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body  onKeyDown = 'lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");

  	       group_type= request.getParameter("group_type");
	       if(group_type == null) group_type="";

	       diag_group_code = request.getParameter("diag_group_code");
	       if(diag_group_code == null) diag_group_code="";
	       
	       speciality_code = request.getParameter("speciality_code");
	       if(speciality_code == null) speciality_code="";
	       
	       practitioner_id = request.getParameter("practitioner_id");
	       if(practitioner_id == null) practitioner_id="";
	       
	       String sql=" select facility_name,practitioner_name ,d.short_desc from mr_diag_group a,sm_facility_param b,am_practitioner c,am_speciality d where a.facility_id=b.facility_id (+) and a.practitioner_id=c.practitioner_id(+) and a.speciality_code = d.speciality_code(+) and a.diag_group_code =? and group_type = ? ";
		   
		   conlConn = ConnectionManager.getConnection(request);	
	       
		   stmt= conlConn.prepareStatement(sql);
			stmt.setString(1,diag_group_code);
			stmt.setString(2,group_type);
	       rstlRs = stmt.executeQuery();
	       
           	if(rstlRs.next() && rstlRs!=null)
	       	{
				speciality_desc = rstlRs.getString("short_desc");
				if(speciality_desc == null) speciality_desc="";
				practitioner_name=rstlRs.getString("practitioner_name");
				if( practitioner_name == null ) practitioner_name ="";
				facility_name=rstlRs.getString("facility_name");
				if(facility_name == null) facility_name="";
				String group_type_disp="";
				if (group_type.equals("D")) group_type_disp="Diagnosis";
				else
					group_type_disp="Procedure";
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('speciality_disp').innerText='Speciality '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('facility_disp').innerText='Facility  '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('pract_disp').innerText='Practitioner '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('diag_code_desc').innerText='    Code Scheme  '</script>");
	       	
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('group_type').innerText='Type  '</script>");
			out.println("<script>parent.frames[1].frames[0].document.getElementById('group_type_disp').innerText=\""+group_type_disp+"\"</script>");
			out.println("<script>parent.frames[1].frames[0].document.getElementById('speciality').innerText=\"  "+speciality_desc+"\"</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('practitioner').innerText=\"  "+practitioner_name+"\"</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('facility').innerText=\""+facility_name+"\"</script>");
	       	       
	    }
 	}catch(Exception e){
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
    }finally{

		try
		{
            if(stmt != null){ stmt.close(); }
            if(rstlRs != null){ rstlRs.close(); }	     
		}
		catch(Exception e){
			//out.println("Exception @ finally "+e.toString());
			e.printStackTrace();
    }
			    ConnectionManager.returnConnection(conlConn,request);
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

