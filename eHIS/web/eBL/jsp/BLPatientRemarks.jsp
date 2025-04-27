<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%	
	HttpSession httpSession = request.getSession(false);

	//unused variable, commented on 15/06/05
	//Properties p = null;
	String facility_id = "";
	
	//unused variable, commented on 09/06/05
	//String login_user = "";

	String module_id = "BL";
	String calling_function_id="";
	String patient_id = "";
	String episode_type = "";
	String episode_id = "";
	String visit_id = "";

	String general_remarks_yn       ="N";
	String patient_fin_rem_yn="N";
	String patient_encounter_rem_yn="N";
	String sponsor_rem_yn="N";
	String bg_rem_yn="N";

	String general_remarks="N";
	String patient_fin_rem="N";
	String patient_encounter_rem="N";
	String sponsor_rem="N";
	String bg_rem="N";

	Connection con = null;

	int size = 0;
	request.setCharacterEncoding("UTF-8");	

	
	try
	{
		//unused variable, commented on 15/06/05
		//p = (Properties)httpSession.getValue("jdbc");	
		
		facility_id = (String)httpSession.getValue("facility_id");
		
		//login_user =  p.getProperty("login_user");

		module_id = request.getParameter("module_id");
		module_id = (module_id==null)? "":module_id;

		calling_function_id= request.getParameter("calling_function_id");
		calling_function_id = (calling_function_id == null)? "":calling_function_id;

		patient_id = request.getParameter("patient_id");
		patient_id  = (patient_id  == null)? "":patient_id ;

		episode_type = request.getParameter("episode_type");
		episode_type  = (episode_type  == null)? "":episode_type ;

		episode_id = request.getParameter("episode_id");
		episode_id  = (episode_id  == null)? "0":episode_id ;
		
		visit_id = request.getParameter("visit_id");
		visit_id  = (visit_id  == null)? "0":visit_id ;




	}
	catch(Exception exp)
	{
		out.println("First Exp = "+exp);
	}
	try
	{
		
		//Connection 
		con = ConnectionManager.getConnection(request);
		
		try
		{
			CallableStatement call = con.prepareCall("{ call BLCOMMON.Get_Blng_Remarks_Applicability(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
			call.setString(1,facility_id);
			call.setString(2,module_id);
			call.setString(3,calling_function_id);
			call.setString(4,patient_id);               
			call.setString(5,episode_type);
			call.setLong(6,(long)Integer.parseInt(episode_id));
			call.setLong(7,(long)Integer.parseInt(visit_id));

			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.registerOutParameter(12,java.sql.Types.VARCHAR);
			call.registerOutParameter(13,java.sql.Types.VARCHAR);
			call.registerOutParameter(14,java.sql.Types.VARCHAR);
			call.registerOutParameter(15,java.sql.Types.VARCHAR);
			call.registerOutParameter(16,java.sql.Types.VARCHAR);
			call.registerOutParameter(17,java.sql.Types.VARCHAR);
			call.execute();

			general_remarks_yn = call.getString(8);   
			patient_fin_rem_yn = call.getString(9);   
			patient_encounter_rem_yn = call.getString(10);   
			sponsor_rem_yn = call.getString(11);   
			bg_rem_yn = call.getString(12);   


			if ((general_remarks_yn == null) || (general_remarks_yn.equalsIgnoreCase("null")) )
			{
				general_remarks_yn = "N";
			}
			if ((patient_fin_rem_yn == null) || (patient_fin_rem_yn.equalsIgnoreCase("null")) )
			{
				patient_fin_rem_yn = "N";
			}
			if ((patient_encounter_rem_yn == null) || (patient_encounter_rem_yn.equalsIgnoreCase("null")) )
			{
				patient_encounter_rem_yn = "N";
			}
			if ((sponsor_rem_yn == null) || (sponsor_rem_yn.equalsIgnoreCase("null")) )
			{
				sponsor_rem_yn = "N";
			}
			if ((general_remarks_yn == null) || (general_remarks_yn.equalsIgnoreCase("null")) )
			{
				general_remarks_yn = "N";
			}
			if ((bg_rem_yn == null) || (bg_rem_yn.equalsIgnoreCase("null")) )
			{
				bg_rem_yn = "N";
			}
			if (general_remarks_yn.equalsIgnoreCase("Y"))
			{
				general_remarks = call.getString(13);
			}
			if (patient_fin_rem_yn.equalsIgnoreCase("Y"))
			{
				patient_fin_rem = call.getString(14);
			}
			if (patient_encounter_rem_yn.equalsIgnoreCase("Y"))
			{
				patient_encounter_rem = call.getString(15);
			}
			if (sponsor_rem_yn.equalsIgnoreCase("Y"))
			{
				sponsor_rem = call.getString(16);
			}
			if (bg_rem_yn.equalsIgnoreCase("N"))
			{
				bg_rem = call.getString(17);
			}
			call.close();
			// commented in Bangalore on 13/10/2005
			//ConnectionManager.returnConnection(con, request);
		}
		catch(Exception sql)	
		{
					out.println("sql = "+sql);
					// commented in Bangalore on 13/10/2005
					//ConnectionManager.returnConnection(con, request);
		}
	}
	catch(Exception conn)
	{
				out.println("conn = "+conn);

	}
	finally{ //Added in Bangalore on 13/10/2005
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
	}
%>
<HTML>
	<head>
<!-- 	<title>Patient Remarks</title> -->
		<title><fmt:message key="eBL.PATIENT_REMARK.label" bundle="${bl_labels}"/></title> 
	<!--
	<link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script Language='JavaScript'>
	function funLoad()
	{
		document.forms[0].close_button.focus();
	}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<form name='Query' id='Query' >
<BODY class='CONTENT' onLoad='funLoad();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<p>
<table align='center' width='100%' cellpadding="3" cellspacing='0' border='0'>
<%
try
{
if (general_remarks_yn.equalsIgnoreCase("Y"))
{
		++size;
%>
	<tr>
<!--	<td class='common'> General Remarks </td> -->
		<td class='label'><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class="fields"> <textarea name='pat_remarks' READONLY cols='60'  ><%=general_remarks %></textarea>
		</td>
	</tr>
<%
}
%>

<%
if (patient_fin_rem_yn.equalsIgnoreCase("Y"))
{
		++size;
%>
	<tr>
<!--		<td class='common'> Patient Remarks </td> -->
			<td class='label'><fmt:message key="eBL.PATIENT_REMARK.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
		<td class="fields"> <textarea name='pat_fin_remarks' READONLY cols='60'  ><%=patient_fin_rem %></textarea>
		</td>
	</tr>
<%
}
%>

<%

if (patient_encounter_rem_yn.equalsIgnoreCase("Y"))
{
		++size;
%>
	<tr>
<!--	<td class='common'> Patient Remarks </td> -->
		<td class='label'><fmt:message key="eBL.PATIENT_REMARK.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
		<td class="fields"> <textarea name='pat_enc_remarks' READONLY cols='60'  ><%=patient_encounter_rem %></textarea>
		</td>
	</tr>
<%
}
%>

<%

if (sponsor_rem_yn.equalsIgnoreCase("Y"))
{
			++size;
%>
	<tr>
<!--	<td class='common'> Patient Remarks	</td> -->
		<td class='label'><fmt:message key="eBL.PATIENT_REMARK.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
		<td class="fields"> <textarea name='sponsor_remarks' READONLY cols='60'  ><%=sponsor_rem %> </textarea>
		</td>
	</tr>
<%
}
%>
<%
if (bg_rem_yn.equalsIgnoreCase("Y"))
{
			++size;
%>
	<tr>
<!--	<td class='common'> Billing Group Remarks</td> -->
		<td class='label'><fmt:message key="eBL.BILLING_GROUP_REMARK.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
		<td class="fields"> <textarea name='bg_remarks' READONLY cols='60'  ><%=bg_rem %> </textarea>
		</td>
	</tr>
<%
}
}
catch(Exception body)
{
	out.println("Exception ="+body);
}
%>
</table>
<center> <input type='button' class='button' name='close_button' id='close_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='javascript:window.close();'></center>
<input type='hidden' name='size' id='size' value='<%=size%>'>
</body>
</form>
</html>



