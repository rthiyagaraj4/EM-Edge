<!DOCTYPE html>
<!--
	Created On	: 6/17/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Receive File at MRD
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
try
{
	con	= ConnectionManager.getConnection(request);

	String fac_id  			= (String) session.getValue( "facility_id" ) ;
	String storage_location	= request.getParameter("storage_location");
	
	String sql	= "";
	String str1 = "";	

	
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");
	
	if(!(storage_location.equals("")))
	{
		sql  = "SELECT LOCN_IDENTITY FROM FM_STORAGE_LOCN WHERE  FS_LOCN_CODE = ? and facility_id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,storage_location);
		pstmt.setString(2,fac_id);
		rs    = pstmt.executeQuery();
		
		while(rs != null && rs.next())
		{
			str1 = rs.getString( "LOCN_IDENTITY" ) ;
				
			if(str1.equals("A")) str1="All";
			if(str1.equals("D")) str1="Department";
			if(str1.equals("C")) str1="Clinic";
			if(str1.equals("N")) str1="Nursing Unit";
			if(str1.equals("T")) str1="Doctor";
			if(str1.equals("E")) str1="Procedure Unit";
			if(str1.equals("Y")) str1="Daycare Unit";
			
			%>
			<script>
				parent.frames[2].document.getElementById("location_identity").innerText="<%=str1%>";				
				var p_old_string  = parent.frames[1].document.forms[0].p_select_values.value;
				var p_search_type ;
				var p_pat_file_no = parent.frames[2].document.forms[0].p_curr_fs_loc.value;
				
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='L'></form></BODY></HTML>";
				parent.frames[5].document.write(HTMLVal);
				parent.frames[5].document.form1.submit();
			</script>
			<%
		}
	}
	else
	{
		%>
		<script>
			parent.frames[2].document.getElementById("location_identity").innerText = "";
	    </script>
		<%
	}
if(rs != null) rs.close() ;
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println("Exception e :"+e.toString());}
finally
{			
	ConnectionManager.returnConnection(con,request);	
}
%>
</form>
</body>
</html>

