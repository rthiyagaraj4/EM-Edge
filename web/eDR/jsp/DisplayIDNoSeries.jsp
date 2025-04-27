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

	<script language='javascript' src='../../eDR/js/ChangeIDSeries.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown='lockKey();'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str					= "";
	String p_pat_ser_grp_code	= "";
	String p_pat_short_desc		= "";

	String p_patient_id	= request.getParameter("p_patient_id");
	String p_id_series  = request.getParameter("p_id_series");

	if(p_patient_id == null) p_patient_id = "";
	if(p_id_series == null) p_id_series = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		str = "";
		str = "SELECT pat_ser_grp_code,short_desc FROM mp_pat_ser_grp WHERE id_type='"+p_id_series+"' " ;
		
		rs = stmt.executeQuery(str);

		if(rs != null)
		{
			while (rs.next())
			{
				p_pat_ser_grp_code	= rs.getString("pat_ser_grp_code");
				p_pat_short_desc	= rs.getString("short_desc");
				%>
				<script>
					var temp	= "<%=p_pat_ser_grp_code%>";
					var temp1	= "<%=p_pat_short_desc%>";
					var opt		= parent.parent.frames[2].frames[1].document.createElement("OPTION");
					opt.text	= temp1;
					opt.value	= temp;
					parent.parent.frames[2].frames[1].document.getElementById('id_series1').add(opt);
				</script>
				<%
			}
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch (Exception e)
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

