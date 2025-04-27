<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/ChangeIDSeries.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str			= "";

	String p_patient_id	= request.getParameter("p_patient_id");
	if(p_patient_id == null) p_patient_id = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		
		int maxrecord = 0;

		str = "SELECT count(*) total_records FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		rs  = stmt.executeQuery(str);
		while(rs.next())
		{
			maxrecord = rs.getInt("total_records");
		} 

		if(maxrecord == 1)
		{
			%>
			<script>
				var errors = getMessage("CODE_ALREADY_EXISTS","Common") ;
				parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;	
				parent.frames[1].document.getElementById('p_id_patient_id').focus();
			</script> 
			<%
		}
		else
		{
			%>
			<script>
				var errors = '';
				parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;	
			</script> 
			<%
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

