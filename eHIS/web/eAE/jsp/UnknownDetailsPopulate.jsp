<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/UpdateUnknownDetails.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
	<body class='message' onKeyDown = 'lockKey()'>
	<%
    request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	String locale		= (String)session.getAttribute("LOCALE");
	String p_patient_id	= request.getParameter("p_patient_id");
	if(p_patient_id == null || p_patient_id.equals("null"))
		p_patient_id = "";
	
	String mysql				= "";
	String name					= "";
	String pat_dtls_unknown_yn	= "";

	int count = 0;

	try
	{	
		con		= ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		if(!p_patient_id.equals(""))
		{
			mysql = "SELECT count(*) count FROM mp_patient WHERE patient_id = '"+p_patient_id+"' ";
			rs   = stmt.executeQuery(mysql);
			if(rs != null && rs.next())
			{
				count = rs.getInt("count");
			}if(rs != null) rs.close();
			if(count == 0)
			{
				%>
				<script>
					var errors = getMessage("INVALID_PATIENT",'MP');
					parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;
					parent.frames[1].document.forms[0].p_id_patient_id.select();
				</script> 
				<%
			}
			else
			{
				mysql = "";
				mysql = "SELECT pat_dtls_unknown_yn FROM mp_patient WHERE patient_id = '"+p_patient_id+"'";
				rs    = stmt.executeQuery(mysql);
				if(rs != null && rs.next())
				{
					pat_dtls_unknown_yn = rs.getString("pat_dtls_unknown_yn");
				}if(rs != null) rs.close(); 
				if(pat_dtls_unknown_yn.equals("Y"))
				{
					%>
					<SCRIPT>
						var msg = getMessage('NOT_KNOWN_PATIENT','AE');
						parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(msg);
						parent.frames[1].document.forms[0].p_id_patient_id.select();
					</SCRIPT>
				<%
			}
			else
			{
				mysql = "";
				mysql = "SELECT GET_PATIENT_LINE('"+p_patient_id+"','"+locale+"') name FROM dual";
				rs = stmt.executeQuery(mysql);
				if(rs != null && rs.next())
				{
					name	= rs.getString("name");
				}if(rs != null) rs.close();	
				int ind = name.lastIndexOf(',');
				name	= name.substring(0,ind);
				%>
					<SCRIPT>
						parent.parent.frames[2].frames[1].document.getElementById("NewPatDltsID").innerText="<%=name%>";
						parent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value="<%=name%>";
					</SCRIPT>
				<%
			}
		}
	}
	}catch (Exception e){e.printStackTrace();}
	finally
	{
		if(rs   != null) rs.close();
		if(stmt != null) stmt.close();
	
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
</html>

