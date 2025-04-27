<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>
		async function callMlcDetails(remarks)
		{
			
			var retVal;
			var dialogHeight = "12vh" ;
			var dialogWidth  = "24vw" ;
			var dialogTop    = "230";
			var dialogLeft   = "230";
			var arguments	= remarks;
			var attribute_readonly='';
			
			attribute_readonly = 'readonly';	
			var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
			retVal =await window.showModalDialog("../../eAE/jsp/AERegisterMLCDetails.jsp?call_from=MLC&disabled="+attribute_readonly,arguments,features);
			
		}  
 </script>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		
		String strEncounterId = request.getParameter("EncounterId");
		String strPrimAssessStartDate = request.getParameter("TriageStartDateTime");
		String facility_id = request.getParameter("FacilityId");
		String strDisabled = "";
		String strMlcCase = "";
		String strBroughtDead = "";

		String strPractitioner = "";
		String strClinicName = "";
		String strPatent ="";
		String strObstructed = "";

		String strObstructedBy ="";
		String strNoControl = "";
		String strNoControlOn = "";
		String strCervicalCollar = "";
		String strSpontaneous = "";
		String strTracheaMidlineShifted = "";
		String strBreathSound = "";
		String strEcgMonitorBP = "";
		String strEcgMonitorHr = "";
		String strCapacityRefill = "";
		String strJvp = "";

		String strSkinCondition = "";
		String strSkinColor = "";
		String strPupilSizeLeft = "";
		String strPupilSizeRight = "";
		String strPupilReaction = "";
		String strAlert = "";
		String strConvulution = "";
		String strResponseToVerbal ="";
		String strResponseToPain ="";
		String strRemarks = "";
				
		String strTreatmentArea = "";

	String qryMedicoDetails = "SELECT MEDICO_LEGAL_DETAILS,MLC_CASE_YN,brought_dead_yn FROM ae_pat_emergency_detail b WHERE encounter_id='"+strEncounterId+"' ";
	qryMedicoDetails=qryMedicoDetails+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";
	String strPrimaryDetails = "SELECT a.clinic_code,d.long_desc Clinic_name, a.treatment_area_code,a.practitioner_id,c.practitioner_name,a.patent_yn,a.obstructed_yn,a.obstructed_by,a.no_control_yn,a.no_control_on,a.cervical_collar_yn,a.spontaneous_yn,a.breathing_type,a.breathing_density,a.trachea_midline_shifted_yn,a.trachea_midline_shifted_to,a.breath_sound,a.ecg_monitor_bp,a.ecg_monitor_hr,a.capacity_refill_yn,a.jvp_yn,a.skin_condition,a.skin_colour,a.pupil_size_left,a.pupil_size_right,a.pupil_reaction,a.alert_yn,a.convulsion_yn,a.response_to_verbal_yn,a.response_to_pain,a.remarks,TO_CHAR(a.exam_date_time,'dd/mm/yyyy hh24:mi') date_time,b.SHORT_DESC Treat_area_desc FROM AE_TRAUMA_PRIMARY_SURVEY a, ae_tmt_area_for_clinic b ,am_practitioner c,OP_CLINIC d WHERE a.FACILITY_ID= '"+facility_id+"'  AND  encounter_id = '"+strEncounterId+"'  AND exam_date_time=TO_DATE('"+strPrimAssessStartDate+"','dd/mm/yyyy hh24:mi')     AND  a.FACILITY_ID=b.FACILITY_ID  AND  a.CLINIC_CODE=b.CLINIC_CODE   AND a.TREATMENT_AREA_CODE=b.TREATMENT_AREA_CODE AND a.practitioner_id = c.practitioner_id and a.clinic_code = d.clinic_code";
%>
<!--
	@Get The Connection
	@Prepare The Statement and Execute The Query
-->
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rsPrimaryAssess= null;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryMedicoDetails);
	rs = pstmt.executeQuery();
%>
	<!--
	@Get All the Values From The Result Set And Store in the Variables
	-->
<%
	while(rs.next())
	{
			//strMedicoLegalDetails = rs.getString("MEDICO_LEGAL_DETAILS");
			strMlcCase = rs.getString("MLC_CASE_YN");
			if(strMlcCase.equals("N"))
			{
				strMlcCase = "NO";
				strDisabled = "disabled";
			}
			else
			{
				strMlcCase = "YES";
			}
			strBroughtDead = rs.getString("brought_dead_yn");
			if(strBroughtDead.equals("N"))
			{
				strBroughtDead = "NO";
			}
			else
			{
				strBroughtDead = "YES";
			}
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null) rs.close();

	pstmt = conn.prepareStatement(strPrimaryDetails);
	rsPrimaryAssess = pstmt.executeQuery();

	while(rsPrimaryAssess.next())
	{		
			
			strClinicName = rsPrimaryAssess.getString("Clinic_name");
			strPractitioner =  rsPrimaryAssess.getString("practitioner_name");
			strPatent = rsPrimaryAssess.getString("patent_yn");
			if(strPatent.equals("N"))
			{
				strPatent = "NO";
			}
			else
			{
				strPatent = "YES";
			}
			strObstructed = rsPrimaryAssess.getString("obstructed_yn");
			if(strObstructed.equals("N"))
			{
				strObstructed = "NO";
			}
			else
			{
				strObstructed = "YES";
			}
			strObstructedBy = rsPrimaryAssess.getString("obstructed_by");
			if(strObstructedBy==null)
			{
				strObstructedBy = "";
			}
			if(strObstructedBy.equals("B"))
			{
				strObstructedBy = "Blood";
			}
			else if(strObstructedBy.equals("V"))
			{
				strObstructedBy="Vomits";
			}
			else if(strObstructedBy.equals("F"))
			{
				strObstructedBy="FB";
			}
			else if(strObstructedBy.equals("O"))
			{
				strObstructedBy = "Other";
			}
			
			strNoControl = rsPrimaryAssess.getString("no_control_yn");
			if(strNoControl.equals("N"))
			{
				strNoControl = "NO";
			}
			else
			{
				strNoControl = "YES";
			}
			strNoControlOn = rsPrimaryAssess.getString("no_control_on");
			if(strNoControlOn ==null)
			{
				strNoControlOn = "";
			}
			if(strNoControlOn.equals("O"))
			{
				strNoControlOn = "Oral airway";
			}
			else if(strNoControlOn.equals("N"))
			{
				strNoControlOn = "Nasal airway";
			}
			else if(strNoControlOn.equals("B"))
			{
				strNoControlOn = "Both";
			}
		
			strCervicalCollar = rsPrimaryAssess.getString("cervical_collar_yn");
			if(strCervicalCollar.equals("N"))
			{
				strCervicalCollar ="NO";
			}
			else
			{
				strCervicalCollar = "YES";
			}
			strSpontaneous = rsPrimaryAssess.getString("spontaneous_yn");
			if(strSpontaneous.equals("N"))
			{
				strSpontaneous = "NO";
			}
			else
			{
				strSpontaneous = "YES";
			}
		//	strBreathingType = rsPrimaryAssess.getString("breathing_type"); 

			//strBreathingDensity = rsPrimaryAssess.getString("breathing_density");
			strTracheaMidlineShifted = rsPrimaryAssess.getString("trachea_midline_shifted_yn");
			if(strTracheaMidlineShifted.equals("N"))
			{
				strTracheaMidlineShifted = "NO";
			}
			else
			{
				strTracheaMidlineShifted = "YES";
			}
			//strTracheaMidlineShiftedTo = rsPrimaryAssess.getString("trachea_midline_shifted_to");
			strBreathSound = rsPrimaryAssess.getString("breath_sound");
			if(strBreathSound ==null)
			{
				strBreathSound = "";
			}


		if(strBreathSound.equals("E"))
		{
		strBreathSound = "Equal";
		}
		else if(strBreathSound.equals("D"))
		{
			strBreathSound = "Diminished R/L";
		}
		else if(strBreathSound.equals("A"))
		{
			strBreathSound = "Absent R/L" ;
		}

			strEcgMonitorBP = rsPrimaryAssess.getString("ecg_monitor_bp");
			if(strEcgMonitorBP ==null)
			{
				strEcgMonitorBP ="";
			}

			strEcgMonitorHr = rsPrimaryAssess.getString("ecg_monitor_hr");
			if(strEcgMonitorHr == null)
			{
				strEcgMonitorHr = "";
			}
			strCapacityRefill = rsPrimaryAssess.getString("capacity_refill_yn");
			if(strCapacityRefill.equals("N"))
			{
				strCapacityRefill = "NO";
			}
			else
			{
				strCapacityRefill= "YES";
			}
			strJvp = rsPrimaryAssess.getString("jvp_yn");
			if(strJvp.equals("N"))
			{
				strJvp= "NO";
			}
			else
			{
				strJvp = "YES";
			}

			strSkinCondition = rsPrimaryAssess.getString("skin_condition");
			if(strSkinCondition ==null)
			{
				strSkinCondition = "";
			}
			if(strSkinCondition.equals("W"))
			{
				strSkinCondition = "Warm";
			}
			else if(strSkinCondition.equals("D"))
			{
				strSkinCondition = "Dry";
			}
			else if(strSkinCondition.equals("C"))
			{
				strSkinCondition = "Cold";
			}

			strSkinColor = rsPrimaryAssess.getString("skin_colour");
			if(strSkinColor == null)
			{
				strSkinColor = "";
			}
			if(strSkinColor.equals("G"))
			{
				strSkinColor = "Good";
			}
			else if(strSkinColor.equals("P"))
			{	
				strSkinColor = "Pale";
			}
			else if(strSkinColor.equals("C"))
			{
				strSkinColor = "Cyanotic";
			}

			strPupilSizeLeft = rsPrimaryAssess.getString("pupil_size_left");
			if(strPupilSizeLeft == null)
			{
				strPupilSizeLeft = "";
			}
			strPupilSizeRight = rsPrimaryAssess.getString("pupil_size_right");
			if(strPupilSizeRight == null)
			{
				strPupilSizeRight = "";
			}
			strPupilReaction = rsPrimaryAssess.getString("pupil_reaction");
			if(strPupilReaction == null)
			{
				strPupilReaction = "";
			}
			if(strPupilReaction.equals("G"))
			{
				strPupilReaction = "Brisk";
			}
			else if(strPupilReaction.equals("P"))
			{
				strPupilReaction = "Sluggish";
			}
			else if(strPupilReaction.equals("C"))
			{
				strPupilReaction="Non Resp";
			}
			
			strAlert = rsPrimaryAssess.getString("alert_yn");
			if(strAlert.equals("N"))
			{
				strAlert = "NO";
			}
			else
			{
				strAlert = "YES";
			}
			strConvulution = rsPrimaryAssess.getString("convulsion_yn");
			if(strConvulution.equals("N"))
			{
				strConvulution = "NO";
			}
			else
			{
				strConvulution = "YES";
			}
			strResponseToVerbal =rsPrimaryAssess.getString("response_to_verbal_yn");
			if(strResponseToVerbal.equals("N"))
			{
				strResponseToVerbal ="NO";
			}
			else
			{
				strResponseToVerbal = "YES";
			}
			strResponseToPain =rsPrimaryAssess.getString("response_to_pain");
			if(strResponseToPain == null)
			{
				strResponseToPain = "";
			}
			else if(strResponseToPain.equals("N"))
			{
				strResponseToPain = "Normal";
			}
			else if(strResponseToPain.equals("I"))
			{
				strResponseToPain = "Impaired";
			}
			else if(strResponseToPain.equals("A"))
			{
				strResponseToPain = "Absent";
			}
			
			strRemarks = rsPrimaryAssess.getString("remarks");
			if(strRemarks == null)
			{
				strRemarks = "";
			}
			
			//strDateTime = rsPrimaryAssess.getString("date_time");
			strTreatmentArea = rsPrimaryAssess.getString("Treat_area_desc");
			
	}


%>
	<!--
	Close All the Connections and Result sets
	-->
	<%
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rsPrimaryAssess!=null)rsPrimaryAssess.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
	%>
		<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>	 -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		</head>		
		<body onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>	
		<table align="center" cellPadding="1" border='0' cellSpacing="0" width="100%" >
		<tr>
		<td class="label"  nowrap><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
		<td  class="QueryData" nowrap>&nbsp;<%=strClinicName%></td>
		<td class="label"  nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		<td  class="QueryData" nowrap>&nbsp;<%=strTreatmentArea%></td>
		</tr>
		<tr>
		<td class="label" nowrap><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>		
		<td class="QueryData" nowrap>&nbsp;<%=strPrimAssessStartDate%></td>	
		<td class="QueryData" nowrap colspan='2'>&nbsp;</td>	
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
		<td class="QueryData" align='left'>&nbsp;<%=strPractitioner%></td>			
		<td class='LABEL' ><fmt:message key="eAE.CaseofMLC.label" bundle="${ae_labels}"/> &nbsp;<b><%=strMlcCase%></b></td>
        <td class='LABEL'><input type="button" <%=strDisabled%> name="mlc_details" class="BUTTON" value="MLC Detail"   onClick="callMlcDetails('<%=strRemarks%>')" >
        </td>
		</tr>	
		<tr>
		<th colspan='4' align='left'><fmt:message key="eAE.Airway.label" bundle="${ae_labels}"/></th>

		</tr>
		<tr>
		<td class="label" ><fmt:message key="eMP.Patent.label" bundle="${mp_labels}"/></td>
		<td  class='QUERYDATA'><%=strPatent%></td>
		<td class="label" ><fmt:message key="eAE.CervicalCollar.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'>&nbsp;<%=strCervicalCollar%></td>
		</td>
		</tr>
		<tr>
		<td class="label"><fmt:message key="eAE.Obstructed.label" bundle="${ae_labels}"/></td>
		<td colspan='3' class='label'><b><%=strObstructed%></b>&nbsp;By&nbsp;<b><%=strObstructedBy%></b></td>
		</tr> 
		<tr>
		<td class="label" ><fmt:message key="eAE.NoControl.label" bundle="${ae_labels}"/></td>
		<td colspan='3' class='label'><b><%=strNoControl%></b>&nbsp;On&nbsp;<b><%=strNoControlOn%></b></td>
		</tr>
		<tr>
		<th colspan='4'  align='left'><fmt:message key="eAE.Breathing.label" bundle="${ae_labels}"/></th>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eAE.Spontaneous.label" bundle="${ae_labels}"/></td>
		<td colspan='3'  class='QUERYDATA' ><%=strSpontaneous%>	</td>
		</tr>

		<tr>
		<td class="label" ><fmt:message key="eAE.Trachea.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strTracheaMidlineShifted%></td>
		<td class="label" ><fmt:message key="eAE.BreathSound.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strBreathSound%></td>
		</tr>
		<tr>
		<th colspan='4' align='left'><fmt:message key="eAE.Circulation.label" bundle="${ae_labels}"/></th>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eAE.ECGMonitorBP.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strEcgMonitorBP%></td>
		<td class="label" ><fmt:message key="Common.Hr.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><%=strEcgMonitorHr%></td>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eAE.CapacityRefill.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strCapacityRefill%></td>
		<td class="label" ><fmt:message key="eAE.JVP.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA' ><%=strJvp%></td>
		</tr>
		<tr>
		<td class="label"><fmt:message key="eAE.SkinCondition.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strSkinCondition%></td>

		<td class="label" ><fmt:message key="eAE.Colour.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strSkinColor%></td>
		</tr> 
		
		<tr>
		<th colspan='4'  align='left'><fmt:message key="eAE.DisabilityCNS.label" bundle="${ae_labels}"/></th>
		</tr>

		<tr >
		<td class="label" ><fmt:message key="eAE.PupilSize.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class='label' nowrap  ><fmt:message key="Common.Left.label" bundle="${common_labels}"/><b>&nbsp;<%=strPupilSizeLeft%></b>&nbsp;Right&nbsp;<b><%=strPupilSizeRight%></b></td>
	
		<td class="label"  ><fmt:message key="eAE.PupilReaction.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strPupilReaction%></td>
		</tr>
		<tr >
		<td class="label"  width='24%' ><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA' ><%=strAlert%></td>
		<td class="label"  ><fmt:message key="eAE.ResponseToVerbal.label" bundle="${ae_labels}"/></td>
		<td class='QUERYDATA'><%=strResponseToVerbal%></td>
		</tr>
		<tr >
		<td class="label"  ><fmt:message key="eAE.ResponseToPain.label" bundle="${ae_labels}"/></td>
		<td colspan="3" class='QUERYDATA'><%=strResponseToPain%></td>
		</tr>
		<tr >
		<td class="label"  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'  align='left' colspan="3"><%=strRemarks%></td>
		</tr>
		<tr>
			<td class='LABEL' ><fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
  		    <td class='QUERYDATA' colspan='3'><%=strBroughtDead%></td> 
		</tr>
	</table>
		</body>
		</html>	

