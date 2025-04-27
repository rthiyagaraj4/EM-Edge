<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%String patient_id=request.getParameter("Patient_Id");
String FacilityID=(String)session.getValue("facility_id");

%>

<html>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	function callModal(cnt)
	{
		if(parseInt(cnt) == 0)
		{
			if(confirm('File not available for the logged in facility.Do you want to create?')) 
				document.location.href='../../servlet/eMR.PatientFileServlet?Patient_Id=<%=patient_id%>&operation=create_file_no';
			else
				parent.parent.frames[1].location.href='../../eMR/jsp/mrblank.jsp?step_1=7';
		}
		else
			document.location.href='../../servlet/eMR.PatientFileServlet?Patient_Id=<%=patient_id%>&operation=create_file_no';
	}
</script>
</head>

<body onKeyDown='lockKey()'>
<form name=blank>
<input type=hidden name=patient_id value='<%=patient_id%>'>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con=null ;
ResultSet rst = null;
Statement stmt =null ;

try {
	con = ConnectionManager.getConnection(request);
	String sql=" Select count(*)  from mr_pat_file_index Where Patient_Id = '"+patient_id+"' and	Facility_Id = '"+FacilityID+"' ";
	stmt = con.createStatement();
	rst = stmt.executeQuery(sql);
	if(rst !=null)
		if(rst.next())
			out.println("<script>callModal('"+rst.getInt(1)+"')</script>");
	

} catch (Exception e) {/* out.println(e); */e.printStackTrace();}
finally{
	try
	{
	if(rst != null)rst.close();
	if(stmt != null)stmt.close();
	}
	catch (Exception e) {}
	ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

