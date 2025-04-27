<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src="../../eCommon/js/DateValidation.js"></script>
<script Language="JavaScript" src='../../eCommon/js/messages.js'></script>
<script language='javascript' src='../../eAE/js/AMBVehicle.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

Connection con=null;

try
{
	
	PreparedStatement stmt=null,stmt1=null,stmt2=null;
	ResultSet rs=null,rs1=null,rs2=null;
	
	String mode="";
	String readOnly = "";
	String sql="";
	String enabled_checked1	=	"";
	String status="";
	String amb_veh_id				=		"",						amb_veh_desc				=	"";
	String amb_veh_regnno			=		"",						amb_veh_model_no			=	"";
	String amb_veh_DOM				=		"",						amb_veh_remarks				=	"";
	String amb_vehicle_type			=		"";
//	amb_park_location			=	"";
	String eff_status				=		"",						amb_veh_type_sel			=	"";
	String amb_veh_location			=		"",						facilityId					=	"";
	String amb_user_prefix			=		"F",					strCurDate					=	"";
	String amb_start_case_no		=		"",						amb_next_case_no			=	"";
	String amb_end_case_no			=		"",						strDisabled					=	"";
	String amb_mileage_uom			=		"",amb_mileage_uom_sel="";

	mode					=	checkForNull(request.getParameter("mode"));
	amb_veh_id				=	checkForNull(request.getParameter("amb_veh_id"));
	amb_veh_desc			=	checkForNull(request.getParameter("amb_veh_desc"));
	amb_veh_regnno			=	checkForNull(request.getParameter("amb_veh_regnno"));
	amb_veh_model_no		=	checkForNull(request.getParameter("amb_model_no"));
	amb_veh_DOM				=	checkForNull(request.getParameter("amb_veh_DOM"));
	amb_veh_remarks			=	checkForNull(request.getParameter("amb_remarks"));
	amb_vehicle_type		=	checkForNull(request.getParameter("amb_vehicle_type"));
	eff_status				=	checkForNull(request.getParameter("eff_status"));
	if(eff_status.equals("")) eff_status="D";
	amb_veh_location		=	checkForNull(request.getParameter("amb_veh_location"));

	try
	{

		facilityId	= (String)session.getValue("facility_id");
		con			=	ConnectionManager.getConnection(request);

		sql = "SELECT  TO_CHAR(SYSDATE,'DD/MM/YYYY') CURDATE, AMB_PREFIX_IND FROM AE_AMB_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";

		stmt	=	con.prepareStatement(sql);
		stmt.setString(1,facilityId);

		rs	=	stmt.executeQuery();

		if( rs != null && rs.next())
		{
			amb_user_prefix	=	checkForNull(rs.getString(2));
			strCurDate		=	rs.getString(1);

			if(amb_user_prefix.equals("") )
				amb_user_prefix =	"F";
		}
		
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			sql ="select AMB_VEHICLE_ID,AMB_VEHICLE_NAME,AMB_REGN_NO,AMB_MODEL_NO,to_char(AMB_DATE_MANUFCT,'dd/mm/yyyy') AMB_DATE_MANUFCT, AMB_REMARKS,AMB_VEHICLE_TYPE,AMB_LOCATION,EFF_STATUS,START_CASE_NO,NEXT_CASE_NO,END_CASE_NO,AMB_MILEAGE_UOM from AE_AMB_VEHICLE where facility_id = '"+facilityId+"' and AMB_VEHICLE_ID=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,amb_veh_id);
			rs = stmt.executeQuery();
			 
			if(rs != null && rs.next())
			{
				 amb_veh_id				=	checkForNull(rs.getString("AMB_VEHICLE_ID"));
				 amb_veh_desc			=	checkForNull(rs.getString("AMB_VEHICLE_NAME"));
				 amb_veh_regnno			=	checkForNull(rs.getString("AMB_REGN_NO"));
				 amb_veh_model_no		=	checkForNull(rs.getString("AMB_MODEL_NO"));
				 amb_veh_DOM			=	checkForNull(rs.getString("AMB_DATE_MANUFCT"));
				 amb_veh_remarks		=	checkForNull(rs.getString("AMB_REMARKS"));
				 amb_vehicle_type		=	checkForNull(rs.getString("AMB_VEHICLE_TYPE"));
				 amb_veh_location		=	checkForNull(rs.getString("AMB_LOCATION"));
				 amb_start_case_no		=	checkForNull(rs.getString("START_CASE_NO"));
				 amb_next_case_no		=	checkForNull(rs.getString("NEXT_CASE_NO"));
				 amb_end_case_no		=	checkForNull(rs.getString("END_CASE_NO"));
				 amb_mileage_uom		=	checkForNull(rs.getString("AMB_MILEAGE_UOM"));
 				 eff_status				=	checkForNull(rs.getString("EFF_STATUS"));
					
				if(eff_status.equals("E"))
					enabled_checked1="checked";
				else
					enabled_checked1="";
			}

			if(rs!=null)  rs.close(); 
			if(stmt!=null)  stmt.close();
		}else{
			enabled_checked1="checked";
			eff_status="E";
			stmt2=con.prepareStatement("select AMB_MILEAGE_UOM from AE_AMB_PARAM_FOR_FACILITY where FACILITY_ID=?");
			stmt2.setString(1,facilityId);
			rs2 = stmt2.executeQuery();
			if(rs2 != null && rs2.next())
				amb_mileage_uom=rs2.getString("AMB_MILEAGE_UOM");			
		}

	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e.toString());
		e.printStackTrace(System.err);
	}finally{
			if(rs2!=null) rs2.close();
			if(stmt2!=null) stmt2.close();	
	}	
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="ambvehicle_form" id="ambvehicle_form" action="../../servlet/eAE.AMBVehicleServlet" method="post" target="messageFrame">
<table border=0 cellspacing=3 cellpadding=3 width='60%' align="center">
<tr>
<%
	if(mode.trim().equalsIgnoreCase("update")) 
	{
		//status	=	"readOnly"; 
		readOnly =	"readonly";
		strDisabled	=	"disabled";
	}
	
	if(mode.trim().equalsIgnoreCase("insert"))
	{
		status="";
		readOnly = "";
		strDisabled = "";
	}
%>
<td class=label width="20%"><fmt:message key="eAE.AmbulanceType.label" bundle="${ae_labels}"/></td>
<td width="20%"><select name='amb_vehicle_type' id='amb_vehicle_type' <%=strDisabled%>>
<option value=''>----- Select -----</option>

<% 
	if(amb_vehicle_type.equals("A") )
		amb_veh_type_sel = "selected";
	else
		amb_veh_type_sel = "";
%>
<option value='A' <%=amb_veh_type_sel%>>Air Ambulance</option>
<%
	if(amb_vehicle_type.equals("M") )
		amb_veh_type_sel = "selected";
	else
		amb_veh_type_sel = "";
%>
<option value='M' <%=amb_veh_type_sel%>>Marine Ambulance</option>
<%
	if(amb_vehicle_type.equals("R") )
		amb_veh_type_sel = "selected";
	else
		amb_veh_type_sel = "";
%>
<option value='R' <%=amb_veh_type_sel%>>Road Ambulance</option>
</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
<tr>

<td class=label width="20%"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
<td width="20%"><input type="text" name="amb_veh_id" id="amb_veh_id" value="<%=amb_veh_id%>" <%=status%> size=12 maxlength=10 onkeypress="return AMBCheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" <%=readOnly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label width="20%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width="20%"><input type="text" name="amb_veh_desc" id="amb_veh_desc" value="<%=amb_veh_desc%>"<%=status%>  size=30 maxlength=30 onBlur = "return makeValidString(this)"  >&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label width="20%"><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
	<td class=label><input type="text" name="amb_veh_regnno" id="amb_veh_regnno" value="<%=amb_veh_regnno%>"<%=status%> size=20 maxlength=20>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
<tr>
	<td class=label width="20%"><fmt:message key="eAE.Make.label" bundle="${ae_labels}"/></td>
	<td class=label><input type="text" name="amb_veh_model_no" id="amb_veh_model_no" value="<%=amb_veh_model_no%>"<%=status%>  size=20 maxlength=20  ></td>
</tr>

<tr>
	<td class=label width="20%"><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<td class=label><input type='text' size=10 maxlength='10' name='amb_veh_DOM' id='amb_veh_DOM' value='<%=amb_veh_DOM%>' onblur="CheckDate(this);effDateValidation(this);"><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('amb_veh_DOM');">
</tr>	
<tr>
	<td class=label width="20%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class=label>
	<textarea name="amb_veh_remarks" value='' maxlength='2000' rows="3" cols ="60" onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,2000)' onchange='chopText(this,2000)'
	onkeyup='chopText(this,2000)' ><%=amb_veh_remarks%></textarea></td>
</tr>
<tr>
	<td class=label width="20%"><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></td>
	<td class=label><input type="text" name="amb_veh_location" id="amb_veh_location" value="<%=amb_veh_location%>"  size=60 maxlength=60  ></td>
</tr>
<%
		if(amb_user_prefix.equals("A") )
		{
			%>
			<tr>
				<td class=label width="20%"><fmt:message key="eOP.StartNumber.label" bundle="${op_labels}"/></td>
				<td class=label><input type="text" name="amb_start_case_no" id="amb_start_case_no" value="<%=amb_start_case_no%>" onblur = 'fillNext()' <%=readOnly%> size=12 maxlength=12  ></td>
			</tr>

			<tr>
				<td class=label width="20%"><fmt:message key="eAM.NextNumber.label" bundle="${ae_labels}"/></td>
				<td class=label><input type="text" name="amb_next_case_no" id="amb_next_case_no" value="<%=amb_next_case_no%>"  readOnly size=12 maxlength=12  ></td>
			</tr>

			<tr>
				<td class=label width="20%"><fmt:message key="eAE.EndNumber.label" bundle="${ae_labels}"/></td>
				<td class=label><input type="text" name="amb_end_case_no" id="amb_end_case_no" value="<%=amb_end_case_no%>"  <%=readOnly%> size=12 maxlength=12  ></td>
			</tr>
			<%
		}
		else
		{
			%>
				<input type="hidden" name="amb_start_case_no" id="amb_start_case_no" value="<%=amb_end_case_no%>"  size=12 maxlength=12  >
				<input type="hidden" name="amb_next_case_no" id="amb_next_case_no" value="<%=amb_end_case_no%>"  size=12 maxlength=12  >
				<input type="hidden" name="amb_end_case_no" id="amb_end_case_no" value="<%=amb_end_case_no%>"  size=12 maxlength=12  >
			<%
		}
%>

<tr>
	<td class=label width="20%"><fmt:message key="eAE.OdometerUnits.label" bundle="${ae_labels}"/></td>
	<td width="20%" class=label><select name="amb_mileage_uom" id="amb_mileage_uom">
	<option value="">----Select----</option>
	<% 
		
			stmt1=con.prepareStatement("select uom_code,short_desc from AM_UOM where STOCK_UOM_YN='N'  AND PUR_UOM_YN = 'N'  AND SALE_UOM_YN = 'N'  AND DOSAGE_UOM_YN = 'N'  AND STRENGTH_UOM_YN = 'N'  AND  QTY_UOM_YN = 'N'  AND EFF_STATUS ='E' ");
			rs1 = stmt1.executeQuery();
			while (rs1 != null && rs1.next())
			{
			if(checkForNull(rs1.getString("uom_code")).equals(amb_mileage_uom))
				amb_mileage_uom_sel="selected";
			else
				amb_mileage_uom_sel="";
			%>
			<option value='<%=checkForNull(rs1.getString("uom_code"))%>' <%=amb_mileage_uom_sel%>><%=checkForNull(rs1.getString("short_desc"))%></option>
		<%	}
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
	%>
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>


<tr>
	<td class=label width="20%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td width="20%" class=label><input type="checkbox" name="eff_status" id="eff_status" value='<%=eff_status%>' <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="amb_vehicle_id" id="amb_vehicle_id" value="<%=amb_veh_id%>">
<input type=hidden name="amb_user_prefix" id="amb_user_prefix" value="<%=amb_user_prefix%>">
<input type=hidden name="curDate" id="curDate" value="<%=strCurDate%>">
</form>
</body>
</html>
<%
}
catch(Exception e)
{
	e.printStackTrace(System.err);
	//out.println("Exception in  Amb Vehicle add modify.jsp"+e.toString());
}
finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

