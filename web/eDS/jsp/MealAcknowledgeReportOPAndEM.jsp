<!DOCTYPE html>
<!-- New file MealAcknowledgeReportOPAndEM.jsp created against ML-MMOH-CRF-0413 [IN:057274] -->
<%@ page import="eDS.Common.DlQuery" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealAcknowledgeReportOPAndEM.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
  $(document).ready(function() {
	getCurrentServerDate();	
	loadKitchen();
	loadSpecialty();
	loadMealClass();
	loadMealType();
	loadDietType();
	loadPriorityZone();
	loadTreatmentArea();
	});	

function changeRepId()
{
		var repType = document.getElementById("repType").value;
		if(repType == 'Summary')
		{
			document.getElementById("report_id").value = "DSROMLAKS";
			document.getElementById("p_report_id").value = "DSROMLAKS";
		}
		else if(repType == 'Detail')
		{
			document.getElementById("report_id").value = "DSROMLAKD";
			document.getElementById("p_report_id").value = "DSROMLAKD";
		}
}

</script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;

		String strCode ="";
		String strDesc ="";
		String servingDate="";
		String description =  "";
		String mealTypeCode = "";
		String mealTypeDesc =  "";
		String dietTypeCode = "";
		String dietTypeDesc =  "";
		String priorityZoneCode = "";
		String specialityCode = "";
		boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207

		try{

			conn = ConnectionManager.getConnection(request);
			isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
			pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
			rst = pstmt.executeQuery();
			while(rst.next()){
				servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
%>
<form name="MealAcknowledgeReport" id="MealAcknowledgeReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>

		<!-- Meal Acknowledge OP/EM - Serving Date -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
		</tr>
		
		<!-- Meal Acknowledge OP/EM - Kitchen -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
			<select name="kitchen" id="kitchen" id="kitchen" onchange="loadSpecialty();loadLocation();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>	
			<option value="<%=strCode%>"><%=strDesc%></option>	
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
			</td>
		</tr>
	
		<!-- Meal Acknowledge OP/EM - Meal Order For -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eDS.MealOrderFor.Label" bundle="${ds_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="mealOrderFor" id="mealOrderFor" id="mealOrderFor" onchange="disableEMFields(this.value);loadSpecialty();loadLocation();loadPriorityZone();loadTreatmentArea();loadMealType();">
				<option value="ALL"><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<option value="OP"><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></option>
				<option value="EM"><fmt:message key="eDS.EmergencyPatients.Label" bundle="${ds_labels}"/></option>
				</select>
			</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - Speciality -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			</td>
				<td align="right" class='label'>
					<select name="speciality" id="speciality" id="speciality" onChange="loadLocation();loadPriorityZone();loadTreatmentArea();">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>	
					<option value="<%=specialityCode%>"><%=description%></option>	
					</select>
				</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - Location -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			</td>
				<td align="right" class='label'>
				<%if(isMultiDietType){%>
				<select name="location" id="location" id="location" onchange="selectAll(this.value);loadPriorityZone();loadTreatmentArea();" >
				<%}else{%>	   
				<select name="location" id="location" id="location" onchange="selectAll(this.value);loadPriorityZone();loadTreatmentArea();" multiple>
				<%}%>   
				   <option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				      <fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				   </option>
				</select>
			</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - Priority Zone -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>
			</td>
				<td align="right" class='label'>
					<select name="priorityZone" id="priorityZone" id="priorityZone" onChange="loadTreatmentArea();">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					
					</select>
				</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - Priority Zone -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
			</td>
				<td align="right" class='label'>
				<select name="treatmentArea" id="treatmentArea" id="treatmentArea" ><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>
		</tr>
		
		<!-- Meal Acknowledge OP/EM - Meal Type -->
		<tr>
			<td align="right" class="label">
	<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="mealType" id="mealType" id="mealType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>	
					<option value="<%=mealTypeCode%>"><%=mealTypeDesc%></option>	
				</select>
			</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - Diet Type -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="dietType" id="dietType" id="dietType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<option value="<%=dietTypeCode%>"><%=dietTypeDesc%></option>	
			</select>
			</td>
		</tr>

		<!-- Meal Acknowledge OP/EM - patientId -->
		<tr>
	<%			String pat_id_length="";
				try
				{
					pstmt = conn.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
					rst	=pstmt.executeQuery();
					if (rst.next() && rst != null)
					{
						pat_id_length = rst.getString(1);
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(rst !=null) rst.close();
						if(pstmt != null) pstmt.close();
					}
	%>
			<td align="left" class='label'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</td>
			<td align="right" class='label'>
				<input type="text" name="patientId" id="patientId"  maxlength='<%=pat_id_length%>' onkeypress="restrictSpecialChars(event);return CheckForSpecChars(event);" size="12" />
			</td>
		</tr>
		
		<!-- Meal Acknowledge OP/EM - status -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.status.label" bundle="${common_labels}"/>
			</td>
			<td width=50% >
					<select name="setStatusForAll" id="setStatusForAll" >
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
						<option value='MS'>
							<fmt:message key="eDS.served.Label" bundle="${ds_labels}" />
						</option>
						<option value='MA'>
							<fmt:message key="eDS.accept.Label" bundle="${ds_labels}" />
						</option>
						<option value='MR'>
							<fmt:message key="eDS.reject.Label" bundle="${ds_labels}" />
						</option>
					</select>					
			</td>
		</tr>
		
		<!-- Meal Acknowledge OP/EM -Report Type -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
			</td>
			<td align="left">
				<select name="repType" id="repType" id="repType" onchange="changeRepId();">
				<option value="Summary"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
				<option value="Detail"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
				</select>
			</td>			
		</tr>
<%
		}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
			if(conn!=null)  ConnectionManager.returnConnection(conn, request);
		}
%>

	<input type="hidden" name="method" id="method"/>

	<INPUT TYPE="hidden" name="facility_id" id="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

	<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
	<input type="hidden" name="module_id" id="module_id" value="DS">	

	<input type="hidden" name="p_report_id" id="p_report_id" id ="p_report_id" value="DSROMLAKS">
	<input type="hidden" name="report_id" id="report_id" id ="report_id" value="DSROMLAKS"/>

	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
	<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
	<input type="hidden" name="converDate" id="converDate" value="" />
	<input type='hidden' name='PARAM1' id='PARAM1' value="" />
	<input type="hidden" name="selectedAll" id="selectedAll" id="selectedAll" value="" />	
</form>
</body>
</html>
<script>
$('body').bind('paste',function(e) {
    e.preventDefault(); return false; 
});
</script>

