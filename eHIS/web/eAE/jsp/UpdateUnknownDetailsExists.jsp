<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
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
	Statement stmt1		= null;
	ResultSet rs1		= null;
	String str					= "";
	String mysql				= "";
	String pat_dtls_unknown_yn	= "";
	String deceased_yn			= "";
	String name					= "";
	String duplicate_id=null;
	String valid_id=null;
	String locale		        = (String)session.getAttribute("LOCALE");
	int count = 0;

	String p_patient_id	= request.getParameter("p_patient_id");
	if(p_patient_id == null || p_patient_id.equals("null")) p_patient_id = "";
	
	String CalledFrom	= request.getParameter("CalledFrom"); //from UpdateUnknownDetails.jsp.jsp/js
	if(CalledFrom == null || CalledFrom.equals("null")) CalledFrom = "";  
	try
	{	
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt1	= con.createStatement();

		mysql = "SELECT GET_PATIENT_LINE('"+p_patient_id+"','"+locale+"') name FROM dual";
		rs = stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			name	= rs.getString("name");
		}if(rs != null) rs.close();	
		if(CalledFrom.equals("NewPatDlts"))
		{
			int ind = name.lastIndexOf(',');
			name	= name.substring(0,ind);
			%>
			<SCRIPT>
				parent.parent.frames[2].frames[1].document.getElementById("NewPatDltsID").innerText="<%=name%>";
				parent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value="<%=name%>";
			</SCRIPT>
			<%
		}
		else
		{
			mysql = "SELECT count(*) count FROM mp_patient WHERE patient_id = '"+p_patient_id+"' ";
			rs1   = stmt1.executeQuery(mysql);
			if(rs1 != null && rs1.next())
			{
				count = rs1.getInt("count");
			}
			if(rs1 != null) rs1.close();
			String duplicte_check="select DUPLICATE_PATIENT_ID, VALID_PATIENT_ID from DR_MP_PATIENT where DUPLICATE_PATIENT_ID='"+p_patient_id+"'";
			rs1=stmt1.executeQuery(duplicte_check);
			if(rs1 != null && rs1.next())
			{
				duplicate_id = rs1.getString("DUPLICATE_PATIENT_ID");
				valid_id = rs1.getString("VALID_PATIENT_ID");
			}
			if(rs1 != null) rs1.close();

			if(count == 0)
			{
				if(valid_id==null){
				%>
				<script>
					var errors = getMessage("INVALID_PATIENT",'MP');
			
					parent.frames[1].document.forms[0].p_id_patient_id.value			= '';
					parent.frames[1].document.getElementById("pat_name").innerHTML					= '&nbsp;';
					parent.frames[1].document.getElementById("pat_ser_grp").innerHTML					= '&nbsp;';
					parent.frames[1].document.getElementById("NewPatDltsID").innerHTML				= '&nbsp;';
					parent.parent.frames[2].frames[1].document.getElementById("DeceasedID").innerHTML = '&nbsp;';
					parent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = "";
						
					if(parent.frames[1].document.forms[0].p_id_patient_id.disabled == false)
						parent.frames[1].document.forms[0].p_id_patient_id.disabled = true;
					if(parent.frames[1].document.forms[0].pat_search1.disabled == false)
						parent.frames[1].document.forms[0].pat_search1.disabled = true;
						
					parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;
					parent.parent.frames[2].frames[1].document.forms[0].patient_id.select();
				</script> 
				<%
				}else{%>
				<script>
					var error=getMessage("PATIENT_MERGED_VALID","MP");
					error=error.replace('#','<%=valid_id%>');				
					alert(error);
					parent.frames[1].document.forms[0].patient_id.value			= '';
				</script>
				<%}
			}
			else
			{
				mysql = "SELECT pat_dtls_unknown_yn,deceased_yn FROM mp_patient WHERE patient_id = '"+p_patient_id+"' ";
				rs1   = stmt1.executeQuery(mysql);
				if(rs1 != null && rs1.next())
				{
					pat_dtls_unknown_yn = rs1.getString("pat_dtls_unknown_yn");
					deceased_yn			= rs1.getString("deceased_yn");
				}if(rs1 != null) rs1.close();	
				if(pat_dtls_unknown_yn.equals("N"))
				{
					%>
						<SCRIPT>
						alert(getMessage('NOT_UNKNOWN_PATIENT','AE'));

						parent.frames[1].document.forms[0].patient_id.value					= '';
						parent.frames[1].document.forms[0].p_id_patient_id.value			= '';
						parent.frames[1].document.getElementById("pat_name").innerHTML					= '&nbsp;';
						parent.frames[1].document.getElementById("pat_ser_grp").innerHTML					= '&nbsp;';
						parent.frames[1].document.getElementById("NewPatDltsID").innerHTML				= '&nbsp;';
						parent.parent.frames[2].frames[1].document.getElementById("DeceasedID").innerHTML = '&nbsp;';
						parent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = "";
							
						if(parent.frames[1].document.forms[0].p_id_patient_id.disabled == false)
							parent.frames[1].document.forms[0].p_id_patient_id.disabled = true;
						if(parent.frames[1].document.forms[0].pat_search1.disabled == false)
							parent.frames[1].document.forms[0].pat_search1.disabled = true;
															
						parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?&err_num=";	
						parent.parent.frames[2].frames[1].document.forms[0].patient_id.select();
					</SCRIPT>
					<%
				}
				else
				{
					if(deceased_yn.equals("Y"))
					{
						%>
						<script>
							parent.parent.frames[2].frames[1].document.getElementById("DeceasedID").innerHTML = "<B>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.deceased.label" bundle="${common_labels}"/></B>";
						</script>
						<%
					}
					else if(deceased_yn.equals("N"))
					{
						%>
						<script>
							parent.parent.frames[2].frames[1].document.getElementById("DeceasedID").innerHTML = "&nbsp;";
						</script>
						<%
					}
					String p_pat_ser_grp_code = "";
					str = "select pat_ser_grp_code from mp_patient where patient_id='"+p_patient_id+"' " ;
					rs = stmt.executeQuery(str);
					if(rs != null && rs.next())
					{
						p_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
					}if(rs != null) rs.close();
					str = "select short_desc from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"' " ;

					String p_short_desc = "";

					rs = stmt.executeQuery(str);
					if(rs != null && rs.next())
					{
						p_short_desc = rs.getString("short_desc");
					}if(rs != null) rs.close();
					int ind = name.lastIndexOf(',');
					name	= name.substring(0,ind);
					%>
					<script>
						parent.parent.frames[2].frames[1].document.forms[0].p_existing_series_group.value ='<%=p_short_desc%>' ;
						parent.parent.frames[2].frames[1].document.getElementById("pat_ser_grp").innerHTML="<b>"+"<%=p_short_desc%>";
						parent.parent.frames[2].frames[1].document.getElementById("pat_name").innerText="<%=name%>";
						parent.frames[1].document.forms[0].p_id_patient_id.value = '';
						parent.parent.frames[2].frames[1].document.getElementById("NewPatDltsID").innerHTML="&nbsp;";
						parent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = "";
						if(parent.frames[1].document.forms[0].p_id_patient_id.disabled == true)
							parent.frames[1].document.forms[0].p_id_patient_id.disabled = false;
						if(parent.frames[1].document.forms[0].pat_search1.disabled == true)
							parent.frames[1].document.forms[0].pat_search1.disabled = false;
						parent.parent.frames[2].frames[1].document.forms[0].p_id_patient_id.select();
					</script>
					<%
				}
			}// E.O if(ProceedValue.equals("yes"))
		} 
	}catch (Exception e){e.printStackTrace();}
	finally
	{
		if(rs   != null) rs.close();
		if(rs1  != null) rs1.close();
		if(stmt != null) stmt.close();
		if(stmt1!= null) stmt1.close();
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
</html>

