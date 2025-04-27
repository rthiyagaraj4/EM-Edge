<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/CAPatMedReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
Connection con = null;
PreparedStatement ps = null,pstmt = null;
ResultSet res = null,rset = null;

try
{ 
	//con = ConnectionManager.getConnection(request);
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//String encounter_yn= "N";
	String day_care    = "";
	String emergency   = "";
	String external   = "";
	String inpatient_yn   = "";
	String outpatient_yn   = "";
	String encounter_checked ="checked";
	//String sel = "checked";
	String enc_yn="Y";
	String current_encounter="";
	String NoteTypeID ="";
	String fnName ="";
	String selFacility ="";
	String prev_encntr ="";
	String pdays_unit ="";
	String pdays ="";
	//String patient_status="";
	String facility_disbl="";
	String facility="";
	String facility_sel="";
	String pastEncReadOnly="";

	current_encounter		=(request.getParameter("current_encounter")==null)?"Y":request.getParameter("current_encounter");
    NoteTypeID = request.getParameter("NoteTypeID") == null ? "" : request.getParameter("NoteTypeID");
    fnName = request.getParameter("fnName") == null ? "" : request.getParameter("fnName");
    selFacility = request.getParameter("selFacility") == null ? "" : request.getParameter("selFacility");
	
	day_care		=(request.getParameter("day_care")==null)?"":request.getParameter("day_care");
	emergency		=(request.getParameter("emergency")==null)?"":request.getParameter("emergency");
	external		=(request.getParameter("external")==null)?"":request.getParameter("external");
	inpatient_yn		=(request.getParameter("inpatient_yn")==null)?"":request.getParameter("inpatient_yn");
	outpatient_yn		=(request.getParameter("outpatient_yn")==null)?"":request.getParameter("outpatient_yn");

	String SqlQuery = "Select NOTE_TYPE_ID,ENCNTR_PAST_DAYS,ENCNTR_PDAYS_OPTION,CURRENT_ENCNTR,PREV_ENCNTR,INPATIENT_YN,OUTPATIENT_YN,DAYCARE_YN,EMERGENCY_YN,EXTERNAL_YN,FACILITY_ID from CA_PMR_ENCNTR_DETAILS where NOTE_TYPE_ID = ? ";

	

	con = ConnectionManager.getConnection(request);
	ps = con.prepareStatement(SqlQuery);
	ps.setString(1,NoteTypeID);
	//ps.setString(2,selFacility);

	

	res = ps.executeQuery();
	if(res.next())
	{		
		pdays = res.getString("ENCNTR_PAST_DAYS") == null ? "" : res.getString("ENCNTR_PAST_DAYS");
		pdays_unit = res.getString("ENCNTR_PDAYS_OPTION") == null ? "" : res.getString("ENCNTR_PDAYS_OPTION");
		current_encounter = res.getString("CURRENT_ENCNTR") == null ? "Y" : res.getString("CURRENT_ENCNTR");
		prev_encntr = res.getString("PREV_ENCNTR") == null ? "" : res.getString("PREV_ENCNTR");
		inpatient_yn = res.getString("INPATIENT_YN") == null ? "N" : res.getString("INPATIENT_YN");
		outpatient_yn = res.getString("OUTPATIENT_YN") == null ? "N" : res.getString("OUTPATIENT_YN");
		day_care = res.getString("DAYCARE_YN") == null ? "N" : res.getString("DAYCARE_YN");
		emergency = res.getString("EMERGENCY_YN") == null ? "N" : res.getString("EMERGENCY_YN");
		external = res.getString("EXTERNAL_YN") == null ? "N" : res.getString("EXTERNAL_YN");
		facility = res.getString("FACILITY_ID") == null ? "N" : res.getString("FACILITY_ID");
		
	}
		if(pdays.equals("0"))
			pdays ="";

		if(prev_encntr.equals("0"))
			prev_encntr ="";

		if(current_encounter.equalsIgnoreCase("Y"))
		{
			encounter_checked = "checked";
			enc_yn = "Y";
		}
		else
		{
			encounter_checked = "";
			enc_yn = "N";
		}
	
	if(res != null) res.close();
	if(ps != null) ps.close();
%>


<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="PatMedEncounterDetails_form" id="PatMedEncounterDetails_form">
<br><br><br>
<table border=0 cellspacing=0 cellpadding='3' width='70%' align=center>
<tr>
    <td  class='label' ><fmt:message key="eCA.PastDays.label" bundle="${ca_labels}"/></td><td colspan="5" class='fields'>&nbsp;
	<input type="text" name="past_days" id="past_days" size=3 maxlength=3 value="<%=pdays%>" onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);" >
	<SELECT name="unit" id="unit">
	<option value = 'D' <%if (pdays_unit.equals("D")){%>SELECTED<%}%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option> 
	<option value = 'M' <%if (pdays_unit.equals("M")){%>SELECTED<%}%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option> 
	<option value = 'Y' <%if (pdays_unit.equals("Y")){%>SELECTED<%}%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option> 
	</SELECT>
	</td>
</tr>
 
<tr>
	<td class='label'><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></td>
	<td colspan="5" class='fields'>&nbsp;<input type="checkbox" name="current_encounter" id="current_encounter" value= "<%=enc_yn%>" <%=encounter_checked%> onclick='OnConfChange(this)'></td>
</tr>

<% 
	if(encounter_checked.equals("checked"))
	{
		facility_disbl ="disabled";
		pastEncReadOnly="readOnly";
	}
	else
	{
		facility_disbl = ""; //facility  facility_sel
		pastEncReadOnly = "";
	}
%>
<tr>
    <td  class='label' ><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></td><td colspan="5" class='fields'>&nbsp;
	<input type="text" name="previous_enconters" id="previous_enconters" value ="<%=prev_encntr%>" size=3 maxlength=3 onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);" <%=pastEncReadOnly%> ><fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/></td>
</tr>

<tr>
	<td  class='label' ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td><td colspan="5" class='fields'>&nbsp;
	<select name="facility_scope" id="facility_scope" <%=facility_disbl%> onchange='setFacility(this)'>
		<%if(facility.equals("A")){ facility_sel="selected";}else{facility_sel="";} %>
		<option value="A" <%=facility_sel%>><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/></option>
		<%if(facility.equals("L")||facility.equals("")){ facility_sel="selected";}else{facility_sel="";} %>
		<option value="L" <%=facility_sel%> ><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>
		<!--<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option> -->
	</select><input type='hidden' name='facility' id='facility' value='L'>
	</td>

</tr>
 <!--<tr>
	<td class='label' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td colspan="5" class='fields'>IP&nbsp;<input type="checkbox" name="inpatient_yn" id="inpatient_yn" value ="<%=inpatient_yn%>" onclick="chkunchk(this);" <%if (inpatient_yn.equals("Y")){%>Checked<%}%> >&nbsp;&nbsp;
	&nbsp;&nbsp;OP&nbsp;<INPUT TYPE="checkbox" name="outpatient_yn" id="outpatient_yn" value="<%=outpatient_yn%>" onclick="chkunchk(this);"  <%if (outpatient_yn.equals("Y")){%>Checked<%}%>>&nbsp;&nbsp;
	&nbsp;DC&nbsp;<input type="checkbox" name="day_care" id="day_care" value="<%=day_care%>" onclick="chkunchk(this);" <%if (day_care.equals("Y")){%>Checked<%}%> >
	&nbsp;&nbsp;EM&nbsp;<input type="checkbox" name="emergency" id="emergency" value="<%=emergency%>" onclick="chkunchk(this);" <%if (emergency.equals("Y")){%>Checked<%}%>>&nbsp;&nbsp;&nbsp;&nbsp;EX&nbsp;<INPUT TYPE="checkbox" name="external" id="external" value="<%=external%>" onclick="chkunchk(this);"  <%if (external.equals("Y")){%>Checked<%}%>> 
</tr> -->
<!-- <tr>
<td class='label'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<%
	try
	{
		String  sql = " select PATIENT_CLASS,  SHORT_DESC  from  am_patient_class_lang_vw where language_id = ? ";
		String patient_class="";
		String short_desc="";
		//int i=0;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
	    rset = pstmt.executeQuery();	
		while (rset!=null && rset.next())
		{
			patient_class = rset.getString("PATIENT_CLASS") == null ? "" : rset.getString("PATIENT_CLASS");
			short_desc = rset.getString("SHORT_DESC") == null ? "" : rset.getString("SHORT_DESC");
		
		%>
				
			<td class='fields'> <%=patient_class%>
			<input type="checkbox"  name="<%=patient_class%>" id="<%=patient_class%>" value="" onclick = 'chkunchk(this)'>
			</td>
		<%		 		
		}
	
		if(rset!=null)  rset.close(); 
		if(pstmt!=null)  pstmt.close();
	}//try 
	catch(Exception eg)
	{
	   out.println("Exception in ="+eg.toString());
	}
 
    %>
</tr> -->
</table>
	    <input type='hidden' name='fnName' id='fnName' value='<%=fnName%>'>
		<input type='hidden' name='NoteTypeID' id='NoteTypeID' value='<%=NoteTypeID%>'>
		<input type='hidden' name='selFacility' id='selFacility' value='<%=selFacility%>'>

	<%
			} 
			catch ( Exception e) 
			{
			//out.println("Exception "+e.toString());//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
			finally 
			{						
				if(con!=null)ConnectionManager.returnConnection(con,request);	
			}
		%>
		
		
</form>
</body>
</html>

