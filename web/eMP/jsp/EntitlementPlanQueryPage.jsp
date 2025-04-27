<!DOCTYPE html>
<!-- 
	Query Criteria for Entitlement Plan
	Created		: 2/10/2006 11:08 AM
	Modified		: 2/10/2006 11:08 AM
	Created By	: Vinod Babu MV

-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% 
	    String login_facilityid = (String) session.getValue( "facility_id" ) ;
		String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eMP/js/EntitlementPlan.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String ip_install_yn = "N";
	String op_install_yn = "N";
	String module_id = "";
	java.sql.Statement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	try
	{
	con = ConnectionManager.getConnection(request);
%>
<body OnLoad="FocusFirstElement();" OnMouseDown="CodeArrest()" onKeyDown='lockKey()' OnKeyPress="lockKey()">
<form name="entitlement_plan_form" id="entitlement_plan_form" method="post" action="../../servlet/eMP.EntitlementPlanServlet" target="messageFrame">
<table name='main_tab' id='main_tab' border=0 cellpadding=0 cellspacing=0 width='100%' align='center'>
<tr>
	<td class='label' align='right'><fmt:message key="Common.category.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align='left' class="fileds">
		<select name='patient_category' id='patient_category' onchange='chgdOption(this);'>
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			String  pat_cat_code ="";
			String  patient_class ="";
			String  short_desc ="";
			stmt = con.createStatement();
			rs = stmt.executeQuery("select pat_cat_code, short_desc from mp_pat_category where eff_status='E' order by short_desc");
			while(rs.next())
			{
				pat_cat_code = rs.getString("pat_cat_code");
				short_desc = rs.getString("short_desc");
				out.println("<option value='"+pat_cat_code+"'>"+short_desc+"</option>");
			}
		%>
		</select>
		<img  id='pat_cat_img'  src='../images/mandatory.gif' > </img>
	</td>
<%
	rs = stmt.executeQuery("SELECT module_id, install_yn FROM sm_module WHERE module_id = 'IP' or module_id = 'OP'");
	if (rs != null)
	while(rs.next())
	{
		module_id = rs.getString("module_id");
		if (module_id.equals("IP"))
			ip_install_yn = rs.getString("install_yn");
		else
		if (module_id.equals("OP"))
			op_install_yn = rs.getString("install_yn");
	}
	if (rs != null) rs.close();
%>
	<input type='hidden' name='ip_install_yn' id='ip_install_yn' value='<%=ip_install_yn%>'>
	<input type='hidden' name='op_install_yn' id='op_install_yn' value='<%=op_install_yn%>'>
	</td>
	<td class='label' align='right'><fmt:message key="eMP.EntitlementBy.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
	<td align='left' class="fileds">
		<select name='entitlement_by' id='entitlement_by' onchange='chgdOption(this);chkForLocn(this);''>
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
		<option value='3'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></option>
		<option value='2'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
		<option value='1'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
		</select>
		<img  id='entitlement_img'  src='../images/mandatory.gif' > </img>
	</td>
</tr>
<tr><td class='label' colspan='4'></td></tr>
<tr><td class='label' colspan='4'></td></tr>
<tr><td class='label' colspan='4'></td></tr>
<tr><td class='label' colspan='4'></td></tr>
<tr><td class='label' colspan='4'></td></tr>
<tr>
	<td class='label' align='right'><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class="fileds" align='left'  width='35%' >
	<input type='hidden' name='login_facility' id='login_facility' value='<%=login_facilityid%>'>
		<select name='facility' id='facility' disabled onchange='chgdOption(this);'>
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			String  facility_id ="";
			String  facility_name ="";
			stmt = con.createStatement();
			rs = stmt.executeQuery("select facility_id, facility_name from sm_facility_param order by facility_name");
			while(rs.next())
			{
				facility_id = rs.getString("facility_id");
				facility_name = rs.getString("facility_name");
				out.println("<option value='"+facility_id+"'>"+facility_name+"</option>");
			}
		%>
	   </select>
	   <img  id='facility_img'  src='../images/mandatory.gif' style='visibility:hidden' > </img>
	</td>
	<td class='label' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align='left'  class="fileds">
		<select name='location_type' id='location_type' disabled onchange='chgdOption(this);'>
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			String  locn_type ="";
			short_desc ="";
			stmt = con.createStatement();
			if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("Y")) )
			{
				rs = stmt.executeQuery("select short_desc, locn_type from am_care_locn_type where sys_user_def_ind = 'S' and (care_locn_type_ind = 'C' or care_locn_type_ind = 'E' or care_locn_type_ind = 'N' or care_locn_type_ind = 'D') order by short_desc");
			}
			else
			if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("N")) )
			{
				rs = stmt.executeQuery("select short_desc, locn_type from am_care_locn_type where sys_user_def_ind = 'S' and care_locn_type_ind = 'N' order by short_desc");
			}
			else
			if ( (ip_install_yn.equals("N")) && (op_install_yn.equals("Y")) )
			{
				rs = stmt.executeQuery("select short_desc, locn_type from am_care_locn_type where sys_user_def_ind = 'S' and (care_locn_type_ind = 'C' or care_locn_type_ind = 'E' or care_locn_type_ind = 'D') order by short_desc");
			}

			if ( (ip_install_yn.equals("Y")) || (op_install_yn.equals("Y")) )
			while(rs.next())
			{
				locn_type = rs.getString("locn_type");
				short_desc = rs.getString("short_desc");
				out.println("<option value='"+locn_type+"'>"+short_desc+"</option>");
			}
		%>
		</select>
		<img id='location_type_img' src='../images/mandatory.gif' style='visibility:hidden' > </img>
	</td>
</tr>
<tr>
	<td colspan='3'>
		<table border=0 width='100%'>
			<tr>
			<td class='label'  width='28%'align='right' id='pat_class_leg' style='visibility:hidden' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class="fileds"  align='left' id='pat_class_list' style='visibility:hidden' >
			<select name='pat_class_val' id='pat_class_val' onchange='chgdOption(this);'>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			  <%
				stmt = con.createStatement();
				rs = stmt.executeQuery("select short_desc,patient_class from am_patient_class where patient_class!='XT' order by short_desc");
				while(rs.next())
				{
					short_desc = rs.getString("short_desc");
					patient_class = rs.getString("patient_class");
					out.println("<option value='"+patient_class+"'>"+short_desc+"</option>");
				}
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
				%>
			</select>
			<img  id='pat_class_img'  src='../images/mandatory.gif' > </img>
			</td>
		   </tr>
		</table>
	</td>
	<td align='left'>
		<input class='button' type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchPatCat()'>&nbsp;&nbsp;
		<input class='button' type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearVal()'>
	</td>
</tr>
</table>
<br>
<input type='hidden' name='pat_cat_code' id='pat_cat_code' value=''>
<input type='hidden' name='entitlement_criteria' id='entitlement_criteria' value=''>
<input type='hidden' name='entitlement_facility_id' id='entitlement_facility_id' value=''>
<input type='hidden' name='entitlement_care_locn_ind' id='entitlement_care_locn_ind' value=''>
</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if ( stmt != null ) stmt.close();
		if ( rs != null ) rs.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</head>
</html>
<%!
	public static String checkForNull(String inputStr,String defaultVal)
	{
		 return ( ((inputStr==null) || (inputStr=="null")) ?  defaultVal : inputStr );
	}
%>


