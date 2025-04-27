<!DOCTYPE html>
<!-- New file MealAcknowledgeReport.jsp created against ML-MMOH-CRF-0413 [IN:057274] -->
<%@ page import="eDS.Common.DlQuery" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.*,webbeans.eCommon.ConnectionManager" %>
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
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealAcknowledgeReport.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
  $(document).ready(function() {
	getCurrentServerDate();
	loadKitchen();
	loadMealClass();
	loadMealType();
	loadDietType();
});	

function changeRepId()
{
	var repType = document.getElementById("repType").value;
	var generaterep = document.getElementById("generaterep").value;	
	if(repType == 'Summary')
	{
		if(generaterep == 'M')
		{
			document.getElementById("report_id").value = "DSRIMLAKS";
			document.getElementById("p_report_id").value = "DSRIMLAKS";
		}
		else if (generaterep == 'S')
		{
			document.getElementById("report_id").value = "DSRSIMLAKS";
			document.getElementById("p_report_id").value = "DSRSIMLAKS";
		}
	}
	else if(repType == 'Detail')
	{
		if(generaterep == 'M')
		{
			document.getElementById("report_id").value = "DSRIMLAKD";
			document.getElementById("p_report_id").value = "DSRIMLAKD";
		}
		else if(generaterep == 'S')
		{
			document.getElementById("report_id").value = "DSRSIMLAKD";
			document.getElementById("p_report_id").value = "DSRSIMLAKD";
		}

	}
}

function changeFreq()
{
	var frequency=$('#frequency').val();
	if (frequency == 'F')
	{
		$('#mealType').attr("disabled","disabled");
		$('#mealType').val('');		
	}	
	else 
	{
		$('#mealType').removeAttr('disabled');
	    	$('#mealType').val('');
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
		boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207

		String pat_id_length="";
		try{			
			conn = ConnectionManager.getConnection(request);
			isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
	%>
<form name="MealAcknowledgeReport" id="MealAcknowledgeReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>

		<!-- Meal Acknowledge Generate Report For -->
		<tr>
			<td class='label' align="right">
				<fmt:message key="eDS.GenerateReportfor.Label" bundle="${ds_labels}" />
			</td>
			<td align="left">
				<select name="generaterep" id="generaterep" id="generaterep" onchange="enableDisableField();changeRepId();">
					<option value="M"><fmt:message key="eDS.MealType.Label" bundle="${ds_labels}"/></option>
					<option value="S"><fmt:message key="eDS.SpecialFoodItems.Label" bundle="${ds_labels}"/></option>
				</select>				
			</td>
		</tr>

		<!-- Meal Acknowledge Date -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<input type="text" name="servingDate" id="servingDate" id="servingDate" maxlength="10" size="10" value="" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
		</tr>
		
		<!-- Meal Acknowledge Kitchen -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
			<select name="kitchen" id="kitchen" id="kitchen" onchange="loadWards(this.value);"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>	
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
			</td>
		</tr>

		<!-- Meal Acknowledge Kitchen -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.Ward.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
			<%if(isMultiDietType){%>
			    <select name="ward" id="ward" id="ward" onchange="selectAll(this.value)" > <!-- modified against ML-MMOH-CRF-2576-->
			<%}else{%>		
				<select name="ward" id="ward" id="ward" onchange="selectAll(this.value)" multiple style="height: auto; overflow: auto; min-width: 9vw;">
			<%}%>	   
				   <option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				      <fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				   </option>
				</select>
			</td>
		</tr>		

		<!-- Meal Acknowledge Meal Class -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="mealClass" id="mealClass" id="mealClass" ><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			</select>
			</td>
		</tr>
		
		<!-- Meal Acknowledge Meal Type -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="mealType" id="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			</select>
			</td>
		</tr>

		<!-- Meal Acknowledge Diet Type -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="dietType" id="dietType" id="dietType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			</select>
			</td>
		</tr>

		<!-- Meal Acknowledge patientId -->
		<tr>
	<%			
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
				<input type="text" name="patientId" id="patientId"  maxlength='<%=pat_id_length%>' onkeypress="restrictSpecialChars(event);return CheckForSpecChars(event);"  size="12"/>
			</td>
		</tr>
		
		<!-- Meal Acknowledge status -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.status.label" bundle="${common_labels}"/>
			</td>
			<td width=50% >
					<select name="setStatus" id="setStatus">
						<option value=''>
							-----<fmt:message key="Common.Select.label" bundle="${common_labels}" />-----
						</option>
						<!-- Added Against Start KDAH-CRF-0505 -->
						<option value='OS'>
							<fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" />
						</option>
						<!-- Added Against End KDAH-CRF-0505 -->
						<option value='MP'>
							<fmt:message key="eOT.MealPrepared.Label" bundle="${ot_labels}" />
						</option>
						<option value='MR'>
							<fmt:message key="eOT.MealReceived.Label" bundle="${ot_labels}" />
						</option>
						<option value='MS'>
							<fmt:message key="eOT.MealServed.Label" bundle="${ot_labels}" />
						</option>
						<option value='MJ'>
							<fmt:message key="eOT.MealReject.Label" bundle="${ot_labels}" />
						</option>
					</select>					
			</td>
		</tr>

		<!-- Meal Acknowledge Frequency -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
			</td>
			<td align="left">
				<select name="frequency" id="frequency" id="frequency" onchange="changeFreq();" disabled>
					<option value="">-----<fmt:message key="Common.Select.label" bundle="${common_labels}"/>-----</option>		
					<option value="F"><fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/> </option>
					<option value="N"><fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/> </option>
				</select>				
			</td>
		</tr>
		
		<!-- Meal Acknowledge Report Type -->
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
	</table>
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
	<input type="hidden" name="p_report_id" id="p_report_id" id ="p_report_id" value="DSRIMLAKS">
	<input type="hidden" name="report_id" id="report_id" id ="report_id" value="DSRIMLAKS"/>
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

