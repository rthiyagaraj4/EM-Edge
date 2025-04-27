<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicatePatient.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	//String proc_status		= "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String str				= "";
		String proc_status		= "";
		String str_query_param	= "";

		int pat_id_length	= 0;
		int rec_param		= 0;

		String patient_id	= request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		
		str = "SELECT patient_id_length FROM mp_param";
		rs  = stmt.executeQuery(str);
		while (rs.next())
		{
			pat_id_length = rs.getInt("patient_id_length");
		} if(rs != null) rs.close();
			
		str_query_param="SELECT count(*) FROM dr_param";
		rs	= stmt.executeQuery(str_query_param);
		
		if(rs!= null)
		if(rs.next())
		{
			rec_param=rs.getInt(1);
		} if(rs != null) rs.close();
		
		if(rec_param==0)
		{
			%>
			<script>
				errors = getMessage("DR_PARAM_NOT_AVAILABLE","DR") ;
				alert(errors);
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
		else
		{
			str_query_param="SELECT proc_status FROM dr_process_ctl";
			rs	    =stmt.executeQuery(str_query_param);
			if(rs!= null)
			{
				if(rs.next())
				{
					proc_status=rs.getString("proc_status");
				}
			} if(rs != null) rs.close();
		}
		if(proc_status != null)
		{
			%>
			<body onLoad="query_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
			<form name='query_form' id='query_form'>
					<table width='100%' cellspacing='0' border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td class='label' width='18%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
							<td class='fields' width='30%'>
								<input type='text' name='patient_id' id='patient_id' size='20' onblur = 'ChangeUpperCase(this);' maxlength='<%=pat_id_length%>' tabindex='1'><input type='button' class='button' value='?' onClick ="callPatientSearch()"><img src='../../eCommon/images/mandatory.gif'>
							</td>
							<td class='button'>
								<input type='button' class='button' name='Execute' id='Execute' value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>' onClick='execute_query();' tabindex='2' style="float:right;margin-right:10px;"></td>
						</tr>
					</table>
				</form>
			</body>
			<%
		}
		else
		{
			%>
			<script>
				errors="Already Process in Progess";
			    alert(errors);
							parent.location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

