facilty_id<!DOCTYPE html>
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<!--<script src="../../eCP/js/common.js" language="JavaScript"></script>-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>-->
<script src="../../eCP/js/ViewCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_pract_id = (String)session.getAttribute("ca_practitioner_id");
	String facilty_id = (String)session.getAttribute("facility_id");
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs = null;
	PreparedStatement stmt_pract=null;
    ResultSet rset_pract=null;  
	String readonly = "";
	String disable = "";
	String display="", visible="";;
	String pract_name="";
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String p_patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String Age = request.getParameter("Age")==null?"":request.getParameter("Age");
	String Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String relationship_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String sql_pract="select practitioner_name from am_practitioner where practitioner_id=?";
	try
	{
	stmt_pract=con.prepareStatement(sql_pract);
	stmt_pract.setString(1,p_pract_id);
	rset_pract=stmt_pract.executeQuery();
	if(rset_pract!=null)
	{
		while(rset_pract.next())
		{
			pract_name=rset_pract.getString("practitioner_name");
		}
	}
	if(!p_patient_id.equals(""))
	{
		readonly = "readonly"; 
		disable = "disabled"; 
		display = "none";
		visible	= "hidden";
	}
	String sql_source = "Select locn_type, short_desc from am_care_locn_type where care_locn_type_ind in ('C','N') order by short_desc ";

		stmt = con.prepareStatement(sql_source);
		rs = stmt.executeQuery();
%>
<body OnMouseDown='CodeArrest()' onload='Load_Diagnosis()'>
<form name='view_cp_crit' id='view_cp_crit'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr style='display:<%=display%>;'>
	<td class='label' align='right' width='12%'>Source</td>
	<td width='50%'>&nbsp;&nbsp;
		<SELECT name="view_src" id="view_src" onchange='popuval()'>
			<option value="">--------Select--------</option>
<%
			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("locn_type")+"'>"+rs.getString("short_desc")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
%>
		</SELECT>&nbsp;<SELECT name="view_ind" id="view_ind">
			<option value="">---Select---</option>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
	<td colspan=4></td>
</tr>
<tr>
	<td class='label' align='right' width='12%'>Care Manager</td>
	<td width = '30%'>&nbsp;<INPUT TYPE="text" name="view_cp_care_mnagr" id="view_cp_care_mnagr"  value="" size="30" onblur="show_CareManager(this,view_cp_care_mnagr,care_manager_id);"><input type="hidden" name="care_manager_id" id="care_manager_id" value=""><INPUT TYPE="button" class="button" value="?" onClick="show_CareManager(this,view_cp_care_mnagr,care_manager_id);">
	</td>
	<td class='label' align='right' width='6%'>&nbsp;Diagnosis</td>
	<td colspan='2'>&nbsp;<select name="view_diag" id="view_diag" onchange="Load_Diagnosis();">
			<option value="">------Select------</option>

<%
	String sql_diag = "select term_set_id from mr_term_set_for_facility where facility_id = ?  order by term_set_id";
	stmt = con.prepareStatement(sql_diag);
	stmt.setString(1,facilty_id);
	rs = stmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("term_set_id")+"'>"+rs.getString("term_set_id")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
%>
		</select>&nbsp;<select name="diagnosis" id="diagnosis">
	<option value="">---Select---</option>
	</select>
	</td>
</tr>

<tr>
	<td class='label' align='right' width='12%'>Period From</td>
	<td class='label' width='20%'>&nbsp;<input name='view_frmdate' id='view_id_frmdate' type='text' size='8' maxlength='10' value='' onBlur="CheckDate(this)" onKeyPress='return AllowDateFormat(event);'><img  name='view_frmdate_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(view_frmdate,'view_id_frmdate');">&nbsp;&nbsp;To&nbsp;<input name='view_todate' id='view_id_todate' type='text' size='8' maxlength='10' value='' onBlur="CheckDate(this);chkfrmdate()" onKeyPress='return AllowDateFormat(event);'><img  name='view_todate_img' id='view_todate_img'  src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(view_todate,'view_id_todate');">
	</td>
	<td class='label' align='right'>View&nbsp;</td>
	<td colspan='2'>&nbsp;<SELECT name="view_plans" id="view_plans"><option value='A'>Active Plans</option><option value='L' selected>All Plans</option></SELECT>&nbsp;<input name="view_summary" id="view_summary" type="hidden" value="D"></td>
</tr>
<tr >
	<td class='label' align='right' width='12%' ><font style='visibility:<%=visible%>;'>Patient ID&nbsp;</font></td>
	<td width='20%' >&nbsp;&nbsp;<INPUT TYPE="text" name="patient_id" id="patient_id" size="15" value="<%=p_patient_id%>" <%=readonly%> style='visibility:<%=visible%>;' ><INPUT TYPE="button" class="button" value="?" <%=disable%> onclick="PatientSearch()" style='visibility:<%=visible%>;'>
	</td>
	<td colspan='2'></td>
	<td align='right'><INPUT TYPE="button" class="button" value="Search" onclick="callresult();"><INPUT TYPE='button' class='button' value='Clear' onclick='clearresult()'></td>
</tr>
</table>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		System.out.println("Exception in ViewCarePlanCriteria.jsp="+e.toString());
	}
	finally
	{
		try
		{
		if(rs!=null) rs.close();
		if(rset_pract!=null) rset_pract.close();
		if(stmt_pract!=null) stmt_pract.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
					System.out.println(e.toString());
			e.printStackTrace(System.err);

		}
	}
%>
<INPUT TYPE="hidden" value="<%=facilty_id%>" name="facilty_id" id="facilty_id">
<input type=hidden name="p_patient_id" id="p_patient_id" value="<%=p_patient_id%>">
<INPUT TYPE="hidden" value="<%=encounter_id%>" name="encounter_id" id="encounter_id">
<INPUT TYPE="hidden" value="<%=location_code%>" name="location_code" id="location_code">
<INPUT TYPE="hidden" value="<%=location_type%>" name="location_type" id="location_type">
<INPUT TYPE="hidden" value="<%=Sex%>" name="Sex"  id="Sex">
<INPUT TYPE="hidden" value="<%=Age%>" name="Age" id="Age">
<INPUT TYPE="hidden" value="<%=Dob%>" name="Dob" id="Dob">
<INPUT TYPE="hidden" value="<%=relationship_id%>" name="relationship_id" id="relationship_id">
<INPUT TYPE="hidden" value="<%=patient_class%>" name="patient_class" id="patient_class">
<INPUT TYPE="hidden"  name="prevNextPlan_id" id="prevNextPlan_id" value="" >

</form>
<script>
callresult();
</script>
</body>
</html>

