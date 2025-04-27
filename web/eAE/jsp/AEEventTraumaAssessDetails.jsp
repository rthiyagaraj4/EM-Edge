<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function lockKey()
	 {
	    if(event.keyCode == 93)
		    getMessage("WELCOME","Common");
	 }
var currentLink = new String();
	currentLink = "Upper";
function objClick(objName)
	{
		changeLink(objName);
		if (objName == 'Upper')
		{
			moveToLink(1);			
		}
		else if(objName == 'lower')
		{
			moveToLink(2);
		}
		else if(objName == 'other_attr')
		{
			moveToLink(3);
		}
	}
	function changeLink(LinkName) 
	{
		if (currentLink =='Upper')
			document.getElementById("Upper").src='../../eAE/images/Upper_click.gif';
		else if (currentLink =='lower')
			document.getElementById("lower").src='../../eAE/images/Lower_click.gif';
		else if (currentLink =='other_attr')
			document.getElementById("other_attr").src='../../eAE/images/Others_click.gif';

		if(LinkName=='Upper')
			document.getElementById("Upper").src='../../eAE/images/Upper.gif';
		else if(LinkName=='lower')
			document.getElementById("lower").src='../../eAE/images/Lower.gif';
		else if(LinkName=='other_attr')
			document.getElementById("other_attr").src='../../eAE/images/Others.gif';
		currentLink = LinkName;
	}
	function moveToLink(LinkIndex)
	{
		if(LinkIndex==1)
			document.getElementById("upper_view").scrollIntoView();
		else if(LinkIndex==2)
			document.getElementById("lower_view").scrollIntoView();
		else if(LinkIndex==3)
			document.getElementById("otherdetail").scrollIntoView();
	}
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	 String strEncounterId = request.getParameter("EncounterId");
	 String strTraumaDate = request.getParameter("TraumaDate");
     String facility_id = request.getParameter("FacilityId");

	String strTreatmentName ="";
	String strClinicName = "";
	String strPractName = "";
	String strFacialFracture = "";
	String strCervicalCollar = "";
	String strCSpineTenderness = "";
	String strCSpineFracture = "";
	String strGTubeNasal = "";
	String strGTubeOral = "";
	String strOpenWound = "";
	String strOpenWoundPosition = "";
	String strOpenPneumothroax = "";
	String strOpenPneumothroaxPosition = "";
	String strAirEntryRight = "";
	String strAirEntryLeft = "";
	String strChestTubeInSitu = "";
	String strChestTubeRightVolume = "";
	String strChestTubeLeftVolume = "";
	String strSubcutaneous = "";
	String strBonyCrepitus = "";
	String strBonyCrepitusPos = "";
	String strRibFracture = "";
	String strRibFracturePos = "";
	String strFlailSegment = "";
	String strFlailSegmentPos = "";
	String strChestOpenWound = "";
	String strPrevSurgery = "";
	String strDistended = "";
	String strTense = "";
	String strTenderness = "";
	String strDiffuse = "";
	String strSupraPubic = "";
	String strRigidity = "";

	String strTone = "";
	String strBulbocavemousReflax = "";
	String strProstrate = "";
	String strRectalInjury = "";
	String strPelvisStatus = "";
	String strPelvisFracture = "";
	String strPelvisDislocation = "";

	String strSpineStatus = "";
	String strSpineFracture = "";
	String strSpineDislocation = "";
	String strCatheter = "";
	String strBloodAtMeatus = "";
	String strHaematura = "";
	String strChestXray  = "";
	String strLimbColor = "";
	String strPulsesRight = "";
	String strPulseLeft = "";
	String strExtreOpenWound = "";
	String strFractureList="";
	String strRemarks="";

	String qryCodeDetails ="SELECT a.encounter_id, a.Treatment_area_code, b.SHORT_DESC treatment_name,a.clinic_code,c.long_desc clinic_name, a.practitioner_id ,d.SHORT_NAME pract_name FROM AE_TRAUMA_SECONDARY_SURVEY a ,ae_tmt_area_for_clinic b,op_clinic c,am_practitioner d WHERE encounter_id = '"+strEncounterId+"'  AND b.TREATMENT_AREA_CODE = a.TREATMENT_AREA_CODE AND b.CLINIC_CODE = a.CLINIC_CODE AND b.FACILITY_ID = c.FACILITY_ID AND a.FACILITY_ID = b.FACILITY_ID AND a.CLINIC_CODE = c.CLINIC_CODE AND a.practitioner_id = d.practitioner_id and c.FACILITY_ID='"+facility_id+"' ";

	String qryTraumaAssessDetails = "SELECT TREATMENT_AREA_CODE,CLINIC_CODE, FACIAL_FRACTURE_YN, CERVICAL_COLLAR_YN, C_SPINE_TENDERNESS,C_SPINE_FRACTURE, G_TUBE_NASAL_YN, G_TUBE_ORAL_YN, OPEN_WOUND_YN, OPEN_WOUND_POSITION, OPEN_PNEUMOTHROAX_YN, OPEN_PNEUMOTHROAX_POSITION, AIR_ENTRY_RIGHT, AIR_ENTRY_LEFT, CHEST_TUBE_IN_SITU_YN, CHEST_TUBE_RIGHT_VOLUME_ML, CHEST_TUBE_LEFT_VOLUME_ML, SUBCUTANEOUS_EMPHYSEMA_YN, BONY_CREPITUS_YN, BONY_CREPITUS_POSITION, RIB_FRACTURE_YN, RIB_FACTURE_POSITION, FLAIL_SEGMENT_YN, FLAIL_SEGMENT_POSITION, CHEST_OPEN_WOUND_YN, PREVIOUS_SURGERY_YN, DISTENDED_YN, TENSE_YN, TENDERNESS_YN, DIFFUSE, SUPRA_PUBIC, RIGIDITY_YN, TONE, BULBOCAVEMOUS_REFLAX, PROSTRATE,RECTAL_INJURY_YN, PELVIS_STATUS, PELVIS_FRACTURE_YN, PELVIS_DISLOCATION_YN, SPINE_STATUS, SPINE_FRACTURE_YN, SPINE_DISLOCATION_YN, CATHETER_YN, BLOOD_AT_MEATUS_YN, HEAMATURA, CHEST_XRAY_YN, LIMB_COLOR, PULSE_RIGHT, PULSE_LEFT, EXTRE_OPEN_WOUND_YN, FRACTURE_LIST, REMARKS FROM AE_TRAUMA_SECONDARY_SURVEY WHERE facility_id = '"+facility_id+"' AND encounter_id = '"+strEncounterId+"' AND exam_date_time = TO_DATE('"+strTraumaDate+"','dd/mm/yyyy hh24:mi')";

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rsCodeDetails = null;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryTraumaAssessDetails);
	rs = pstmt.executeQuery();
%>
<%
	 while(rs.next())
	{

			strFacialFracture = rs.getString("FACIAL_FRACTURE_YN");
			if(strFacialFracture.equals("N"))
			{
				strFacialFracture = "NO";
			}
			else
			{
				strFacialFracture = "YES";
			}
			strCervicalCollar = rs.getString("CERVICAL_COLLAR_YN");
			if(strCervicalCollar.equals("N"))
			{
				strCervicalCollar = "NO";
			}
			else
			{
				strCervicalCollar = "YES";
			}
			strCSpineTenderness = rs.getString("C_SPINE_TENDERNESS");
			if(strCSpineTenderness == null)
			{
				strCSpineTenderness = "";
			}
			if(strCSpineTenderness.equals("Y"))
			{
				strCSpineTenderness = "YES";
			}
			else if(strCSpineTenderness.equals("N"))
			{
				strCSpineTenderness = "NO";
			}
			else if(strCSpineTenderness.equals("U"))
			{
				strCSpineTenderness = "Unknown";
			}
			strCSpineFracture = rs.getString("C_SPINE_FRACTURE");
			if(strCSpineFracture == null)
			{
				strCSpineFracture = "";
			}
			if(strCSpineFracture.equals("Y"))
			{
				strCSpineFracture = "YES";
			}
			else if(strCSpineFracture.equals("N"))
			{
				strCSpineFracture= "NO";
			}
			else if(strCSpineFracture.equals("U"))
			{
				strCSpineFracture = "Unknown";
			}
			strGTubeNasal = rs.getString("G_TUBE_NASAL_YN");
			if(strGTubeNasal.equals("N"))
			{
				strGTubeNasal = "NO";
			}
			else
			{
				strGTubeNasal = "YES";
			}
			strGTubeOral = rs.getString("G_TUBE_ORAL_YN");
			if(strGTubeOral.equals("N"))
			{
				strGTubeOral = "NO";
			}
			else
			{
				strGTubeOral = "YES";
			}
			strOpenWound = rs.getString("OPEN_WOUND_YN");
			if(strOpenWound.equals("N"))
			{
				strOpenWound = "NO";
			}
			else
			{
				strOpenWound ="YES";
			}
			strOpenWoundPosition = rs.getString("OPEN_WOUND_POSITION");
			if(strOpenWoundPosition== null)
			{
				strOpenWoundPosition = "";
			}
			if(strOpenWoundPosition.equals("R"))
			{
				strOpenWoundPosition = "Right";
			}
			else if(strOpenWoundPosition.equals("L"))
			{
				strOpenWoundPosition = "Left";
			}
			else if(strOpenWoundPosition.equals("B"))
			{
				strOpenWoundPosition = "Both";
			}
			strOpenPneumothroax = rs.getString("OPEN_PNEUMOTHROAX_YN");
			if(strOpenPneumothroax.equals("N"))
			{
				strOpenPneumothroax ="NO";
			}
			else
			{
				strOpenPneumothroax = "YES";
			}
			strOpenPneumothroaxPosition = rs.getString("OPEN_PNEUMOTHROAX_POSITION");
			if(strOpenPneumothroaxPosition ==null)
			{
				strOpenPneumothroaxPosition = "";
			}
			if(strOpenPneumothroaxPosition.equals("R"))
			{
				strOpenPneumothroaxPosition = "Right";
			}
			else if(strOpenPneumothroaxPosition.equals("L"))
			{
				strOpenPneumothroaxPosition= "Left";
			}
			strAirEntryRight = rs.getString("AIR_ENTRY_RIGHT");
			if(strAirEntryRight == null)
			{
				strAirEntryRight ="";
			}
			if(strAirEntryRight.equals("N"))
			{
				strAirEntryRight = "Normal";
			}
			else if(strAirEntryRight.equals("D"))
			{
				strAirEntryRight = "Decreased";
			}
			else if(strAirEntryRight.equals("A"))
			{
				strAirEntryRight = "Absent";
			}
			strAirEntryLeft = rs.getString("AIR_ENTRY_LEFT");
			if(strAirEntryLeft == null)
			{
				strAirEntryLeft = "";
			}
			if(strAirEntryLeft.equals("N"))
			{
				strAirEntryLeft = "Normal";
			}
			else if(strAirEntryLeft.equals("D"))
			{
				strAirEntryLeft = "Decreased";
			}
			else if(strAirEntryLeft.equals("A"))
			{
				strAirEntryLeft = "Absent";
			}
			strChestTubeInSitu = rs.getString("CHEST_TUBE_IN_SITU_YN");
			if(strChestTubeInSitu.equals("N"))
			{
				strChestTubeInSitu = "NO";
			}
			else
			{
				strChestTubeInSitu ="YES";
			}
			strChestTubeRightVolume = rs.getString("CHEST_TUBE_RIGHT_VOLUME_ML");
			if(strChestTubeRightVolume == null)
			{	
				strChestTubeRightVolume="";
			}
			strChestTubeLeftVolume = rs.getString("CHEST_TUBE_LEFT_VOLUME_ML");
			if(strChestTubeLeftVolume == null)
			{	
				strChestTubeLeftVolume = "";
			}
			strSubcutaneous = rs.getString("SUBCUTANEOUS_EMPHYSEMA_YN");
			if(strSubcutaneous.equals("N"))
			{
				strSubcutaneous = "NO";
			}
			else
			{
				strSubcutaneous = "YES";
			}
			strBonyCrepitus = rs.getString("BONY_CREPITUS_YN");
			if(strBonyCrepitus.equals("N"))
			{
				strBonyCrepitus = "NO";
			}
			else
			{	
				strBonyCrepitus = "YES";
			}
			strBonyCrepitusPos = rs.getString("BONY_CREPITUS_POSITION");
			if(strBonyCrepitusPos == null)
			{
				strBonyCrepitusPos = "";
			}
			if(strBonyCrepitusPos.equals("R"))
			{
				strBonyCrepitusPos = "Right";
			}
			else if(strBonyCrepitusPos.equals("L"))
			{
				strBonyCrepitusPos = "Left";
			}
			strRibFracture = rs.getString("RIB_FRACTURE_YN");
			if(strRibFracture.equals("N"))
			{
				strRibFracture ="NO";
			}
			else
			{
				strRibFracture ="YES";
			}
			strRibFracturePos = rs.getString("RIB_FACTURE_POSITION");
			if(strRibFracturePos==null)
			{
				strRibFracturePos = "";
			}
			if(strRibFracturePos.equals("R"))
			{
				strRibFracturePos = "Right";
			}
			else if(strRibFracturePos.equals("L"))
			{
				strRibFracturePos = "Left";
			}
			strFlailSegment = rs.getString("FLAIL_SEGMENT_YN");
			if(strFlailSegment.equals("N"))
			{
				strFlailSegment = "NO";
			}
			else
			{
				strFlailSegment ="YES";
			}
			strFlailSegmentPos = rs.getString("FLAIL_SEGMENT_POSITION");
			if(strFlailSegmentPos == null)
			{
				strFlailSegmentPos = "";
			}
			if(strFlailSegmentPos.equals("R"))
			{
				strFlailSegmentPos = "Right";
			}
			else if(strFlailSegmentPos.equals("L"))
			{
				strFlailSegmentPos = "Left";
			}
			else if(strFlailSegmentPos.equals("C"))
			{
				strFlailSegmentPos = "Central";
			}
			strChestOpenWound = rs.getString("CHEST_OPEN_WOUND_YN");
			if(strChestOpenWound.equals("N"))
			{
				strChestOpenWound = "NO";
			}
			else
			{
				strChestOpenWound = "YES";
			}
			strPrevSurgery = rs.getString("PREVIOUS_SURGERY_YN");
			if(strPrevSurgery.equals("N"))
			{
				strPrevSurgery = "NO";
			}
			else
			{
				strPrevSurgery ="YES";
			}
			strDistended = rs.getString("DISTENDED_YN");
			if(strDistended.equals("N"))
			{
				strDistended = "NO";
			}
			else
			{
				strDistended = "YES";
			}
			strTense = rs.getString("TENSE_YN");
			if(strTense.equals("N"))
			{
				strTense = "NO";
			}
			else
			{
				strTense ="YES";
			}

			strTenderness = rs.getString("TENDERNESS_YN");
			if(strTenderness.equals("N"))
			{
				strTenderness = "NO";
			}
			else
			{
				strTenderness ="YES";
			}
			strDiffuse = rs.getString("DIFFUSE");
			if(strDiffuse == null)
			{
				strDiffuse = "";
			}
			if(strDiffuse.equals("R"))
			{	
				strDiffuse = "RUQ";
			}
			else if(strDiffuse.equals("L"))
			{
				strDiffuse = "LUQ";
			}
			strSupraPubic = rs.getString("SUPRA_PUBIC");
			if(strSupraPubic == null)
			{
				strSupraPubic = "";
			}
			if(strSupraPubic.equals("R"))
			{	
				strSupraPubic = "RUQ";
			}
			else if(strSupraPubic.equals("L"))
			{
				strSupraPubic = "LUQ";
			}
			strRigidity = rs.getString("RIGIDITY_YN");
			if(strRigidity.equals("N"))
			{
				strRigidity = "NO";
			}
			else
			{
				strRigidity  = "YES";
			}
			
			strTone = rs.getString("TONE");
			if(strTone == null)
			{
				strTone = "";
			}
			if(strTone.equals("N"))
			{
				strTone = "Normal";
			}
			else if(strTone.equals("R"))
			{
				strTone = "Reduced";
			}
			else if(strTone.equals("A"))
			{
				strTone = "Absent";
			}

			strBulbocavemousReflax = rs.getString("BULBOCAVEMOUS_REFLAX");
			if(strBulbocavemousReflax ==null)
			{
				strBulbocavemousReflax = "";
			}
			if(strBulbocavemousReflax.equals("P"))
			{
				strBulbocavemousReflax = "Positive";
			}
			else if(strBulbocavemousReflax.equals("N"))
			{
				strBulbocavemousReflax = "Negative";
			}
			strProstrate = rs.getString("PROSTRATE");
			if(strProstrate == null)
			{
				strProstrate = "";
			}
			if(strProstrate.equals("H"))
			{
				strProstrate = "High";
			}
			else if(strProstrate.equals("N"))
			{
				strProstrate = "Normal";
			}
			strRectalInjury = rs.getString("RECTAL_INJURY_YN");
			if(strRectalInjury.equals("N"))
			{
				strRectalInjury ="NO";
			}
			else
			{
				strRectalInjury = "YES";
			}
			strPelvisStatus = rs.getString("PELVIS_STATUS");
			if(strPelvisStatus == null)
			{
				 strPelvisStatus = "";
			}
			if(strPelvisStatus.equals("S"))
			{
				strPelvisStatus = "Stable";
			}
			else if(strPelvisStatus.equals("U"))
			{
				strPelvisStatus = "Unstable";
			}
			strPelvisFracture = rs.getString("PELVIS_FRACTURE_YN");
			if(strPelvisFracture.equals("N"))
			{
				strPelvisFracture = "NO";
			}
			else
			{
				strPelvisFracture = "YES";
			}	
			strPelvisDislocation = rs.getString("PELVIS_DISLOCATION_YN");
			if(strPelvisDislocation.equals("N"))
			{
				strPelvisDislocation = "NO";
			}
			else
			{
				strPelvisDislocation = "YES";
			}
			strSpineStatus = rs.getString("SPINE_STATUS");
			if(strSpineStatus == null)
			{
				strSpineStatus = "";
			}
			if(strSpineStatus.equals("S"))
			{
				strSpineStatus = "Stable";
			}
			else if(strSpineStatus.equals("U"))
			{
				strSpineStatus = "Unstable";
			}
			strSpineFracture = rs.getString("SPINE_FRACTURE_YN");
			if(strSpineFracture.equals("N"))
			{
				strSpineFracture = "NO";
			}
			else
			{
				strSpineFracture = "YES";
			}
			strSpineDislocation = rs.getString("SPINE_DISLOCATION_YN");
			if(strSpineDislocation.equals("N"))
			{
				strSpineDislocation = "NO";
			}
			else
			{
				strSpineDislocation = "YES";
			}
			strCatheter =rs.getString("CATHETER_YN");
			if(strCatheter.equals("N"))
			{
				strCatheter = "NO";
			}
			else
			{
				strCatheter = "YES";
			}
			strBloodAtMeatus = rs.getString("BLOOD_AT_MEATUS_YN");
			if(strBloodAtMeatus.equals("N"))
			{
				strBloodAtMeatus = "NO";
			}
			else
			{
				strBloodAtMeatus ="YES";
			}
			strHaematura = rs.getString("HEAMATURA");
			if(strHaematura==null)
			{
				strHaematura = "";
			}
			if(strHaematura.equals("B"))
			{
				strHaematura = "Brisk";
			}
			else if(strHaematura.equals("S"))
			{
				strHaematura = "Sluggish";
			}
			else if(strHaematura.equals("N"))
			{
				strHaematura = "Non Resp";
			}
			strChestXray = rs.getString("CHEST_XRAY_YN");
			if(strChestXray.equals("N"))
			{
				strChestXray = "NO";
			}
			else
			{
				strChestXray = "YES";
			}
			strLimbColor = rs.getString("LIMB_COLOR");
			if(strLimbColor == null)
			{
				strLimbColor = "";
			}
			if(strLimbColor.equals("P"))
			{
				strLimbColor = "Pale";
			}
			else if(strLimbColor.equals("N"))
			{
				strLimbColor = "Normal";
			}
			else if(strLimbColor.equals("H"))
			{
				strLimbColor = "Hyper";
			}

			strPulsesRight = rs.getString("PULSE_RIGHT");
			if(strPulsesRight==null)
			{
				strPulsesRight = "";
			}
			if(strPulsesRight.equals("R"))
			{
				strPulsesRight = "Radial";
			}
			else if(strPulsesRight.equals("B"))
			{
				strPulsesRight = "Brachial";
			}
			else if(strPulsesRight.equals("F"))
			{
				strPulsesRight = "Femoral";
			}
			else if(strPulsesRight.equals("P"))
			{
				strPulsesRight = "Popliteal";
			}
			else if(strPulsesRight.equals("D"))
			{
				strPulsesRight = "Pedal";
			}

			strPulseLeft = rs.getString("PULSE_LEFT");
			if(strPulseLeft == null)
			{
				strPulseLeft = "";
			}
			if(strPulseLeft.equals("R"))
			{
				strPulseLeft = "Radial";
			}
			else if(strPulseLeft.equals("B"))
			{
				strPulseLeft = "Brachial";
			}
			else if(strPulseLeft.equals("F"))
			{
				strPulseLeft = "Femoral";
			}
			else if(strPulseLeft.equals("P"))
			{
				strPulseLeft = "Popliteal";
			}
			else if(strPulseLeft.equals("D"))
			{
				strPulseLeft = "Pedal";
			}
			strExtreOpenWound = rs.getString("EXTRE_OPEN_WOUND_YN");
			if(strExtreOpenWound.equals("N"))
			{
				strExtreOpenWound = "NO";
			}
			else
			{
				strExtreOpenWound = "YES";
			}
			strFractureList = rs.getString("FRACTURE_LIST");
			if(strFractureList==null)
			{	
				strFractureList = "";
			}
			strRemarks = rs.getString("REMARKS");
			if(strRemarks==null)
			{
				strRemarks = "";
			}
			

	}
    if(rs!=null)rs.close();
	if(pstmt != null)pstmt.close();

	pstmt = conn.prepareStatement(qryCodeDetails);
	rsCodeDetails = pstmt.executeQuery();
	while(rsCodeDetails.next())
	{
			strTreatmentName = rsCodeDetails.getString("treatment_name");
			strClinicName = rsCodeDetails.getString("clinic_name");
			strPractName = rsCodeDetails.getString("pract_name");
	}
	if(rsCodeDetails!=null)rsCodeDetails.close();
	if(pstmt != null)pstmt.close();
%>
<%
	}catch(Exception exc)
	{
		exc.printStackTrace();
	}
	finally
	{
		if(rs!=null)rs.close();
		if(rsCodeDetails != null)rsCodeDetails.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
%>
<body  onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<center>
	<a name='upper_view'></a>
	<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strClinicName%></td>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strTreatmentName%></td>
	</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strTraumaDate%></td>
</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strPractName%></td>
</tr>
<br>
</table>
	<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
	
	<tr>
		<td width='100%' align='left'>
		<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower_click.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others_click.gif'  ></img></a>
		</td>
	</tr>
	</table>
	 
	<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
    <tr>
		<th colspan='6' align='left'>Head & Neck</th>
    </tr>
    <tr>
		<td class="label" align='right'><fmt:message key="eAE.FacialFracture.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData" >&nbsp;<%=strFacialFracture%></td>
		<td class="label" align='right'><fmt:message key="eAE.CervicalCollar.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strCervicalCollar%></td>
	</tr>
	<tr>
        <td class="label" align='right'><fmt:message key="eAE.CSpineTenderness.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strCSpineTenderness%></td>
		<td class="label" align='right'><fmt:message key="eAE.CSpineFracture.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strCSpineFracture%>
		</td>
	</tr> 
    <tr>
		<td class="label" align='right'><fmt:message key="eAE.GTubeNasal.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strGTubeNasal%></td>
		<td class="label" align='right'><fmt:message key="eAE.GTubeOral.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strGTubeOral%></td>
	</tr>
	<tr>
          <td colspan='6' >&nbsp;</td>
	</tr>
	<tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Chest.label" bundle="${ae_labels}"/></th>
	</tr>
	
	<tr>
        <td class="label" align='right'><fmt:message key="eAE.OpenWound.label" bundle="${ae_labels}"/></td>
        <td align='left'   class="QueryData">&nbsp;<%=strOpenWound%> &nbsp;<%=strOpenWoundPosition%></td>
		<td class="label" align='right' nowrap><fmt:message key="eAE.OpenPneumothroax.label" bundle="${ae_labels}"/></td>
		<td align='left'  class="QueryData">&nbsp;<%=strOpenPneumothroax%> &nbsp; <%=strOpenPneumothroaxPosition%></td>
	</tr>
	<tr>
        <td class="label" align='right'><fmt:message key="eAE.AirEntryRight.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strAirEntryRight%></td>
		<td class="label" align='right' nowrap><fmt:message key="Common.Left.label" bundle="${common_labels}"/></td>
		<td align='left'  class="QueryData">&nbsp;<%=strAirEntryLeft%></td>
	</tr>
	<tr>
        <td class="label" align='right'><fmt:message key="eAE.ChestTubeinSitu.label" bundle="${ae_labels}"/></td>
        <td  align='left' class="label" >&nbsp;<b><%=strChestTubeInSitu%></b>&nbsp;&nbsp;Volume Right&nbsp;<b><%=strChestTubeRightVolume%></b>&nbsp;</td>
		<td class="label" align='right' nowrap><fmt:message key="eAE.VolumeLeft.label" bundle="${ae_labels}"/></td>
		<td  class="QueryData" align='left'>&nbsp;<%=strChestTubeLeftVolume%>&nbsp;ml</td>
	</tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.SubEmphysema.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strSubcutaneous%></td>
        <td class="label" align='right'><fmt:message key="eAE.BonyCrepitus.label" bundle="${ae_labels}"/></td>
        <td align='left'   class="QueryData">&nbsp;<%=strBonyCrepitus%>&nbsp;<%=strBonyCrepitusPos%></td>
	</tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.RibFracture.label" bundle="${ae_labels}"/></td>
        <td class="QueryData" align='left'>&nbsp;<%=strRibFracture%>&nbsp;<%=strRibFracturePos%></td>
		<td class="label" align='right'><fmt:message key="eAE.FlailSegment.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strFlailSegment%>&nbsp;<%=strFlailSegmentPos%>
		</td>
	</tr> 
	<tr>
          <td colspan='6' >&nbsp;</td>
	</tr>
	<tr>
		<th colspan='6' align='left'><fmt:message key="eAE.Abdomen.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr >
		<td class="label" align='right'><fmt:message key="eAE.OpenWounds.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strChestOpenWound%></td>
		<td class="label" align='right'><fmt:message key="eAE.PreviousSurgery.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strPrevSurgery%></td>
	</tr>
	<tr >
		<td class="label" align='right'><fmt:message key="eAE.Distended.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strDistended%></td>
		<td class="label" align='right'><fmt:message key="eAE.Tense.label" bundle="${ae_labels}"/></td>
        <td align='left'  class="QueryData">&nbsp;<%=strTense%></td>
	</tr>
	<tr >
		<td class="label" align='right'><fmt:message key="eAE.Tenderness.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strTenderness%></td>
		<td class="label" align='right'><fmt:message key="eAE.Rigidity.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strRigidity%></td>
    </tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.Diffuse.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strDiffuse%>&nbsp;
		</td>
		<td class="label" align='right'><fmt:message key="eAE.Suprapubic.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strSupraPubic%>&nbsp;
		</td>
	</tr> 
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	</table>
	
	<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
	<a name='lower_view'></a>
	<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strClinicName%></td>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strTreatmentName%></td>
	</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strTraumaDate%></td>
</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strPractName%></td>
</tr>
<br>
</table>
	<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
	<tr>
		<td width='100%' align='left'>
		<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper_click.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others_click.gif'  ></img></a>
		</td>
	</tr>
	</table>
	
	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<tr>
		<th colspan='6' align='left'><fmt:message key="eAE.Rectal.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr>
		<td width='24%'>&nbsp;</td>
        <td >&nbsp;</td>
        <td >&nbsp;</td>
		<td >&nbsp;</td>
        <td >&nbsp;</td>
		<td width='27%'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.Tone.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData" >&nbsp;<%=strTone%>
		</td>
		<td  class="label" align='right'  nowrap><fmt:message key="eAE.BulbocavemousReflex.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strBulbocavemousReflax%>		</td>
				<td colspan="2">&nbsp;</td>
	</tr> 
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.Prostrate.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strProstrate%>&nbsp;
		</td>
		<td  class="label" align='right'><fmt:message key="eAE.RectalInjury.label" bundle="${ae_labels}"/></td>
      	<td align='left'  valign='center' class="QueryData">&nbsp;<%=strRectalInjury%></td>
		<td colspan="2">&nbsp;</td>
	</tr> 
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr>
		<th colspan='6' align='left'><fmt:message key="eAE.Pelvis.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr >
		<td class="label"  align='right'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=strPelvisStatus%>&nbsp;
		</td>
		<td class="label"  align='right'><fmt:message key="eAE.Fracture.label" bundle="${ae_labels}"/> &nbsp;<b></b></td>
		<td align='left' class="QueryData"><%=strPelvisFracture%></td>
		<td class="label"  align='right' nowrap>&nbsp;&nbsp;<fmt:message key="eAE.FractureDislocation.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class="label"><b><%=strPelvisDislocation%></b></td>
      </tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr>
		<th colspan='6' align='left'><fmt:message key="eAE.Spine.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr >
		<td class="label"  align='right'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=strSpineStatus%>&nbsp;
		</td>
		<td class="label"  align='right'><fmt:message key="eAE.Fracture.label" bundle="${ae_labels}"/></td>
		 <td align='left' class="QueryData">&nbsp;<%=strSpineFracture%></td>
        <td class="label"  align='right' nowrap>&nbsp;&nbsp;<fmt:message key="eAE.FractureDislocation.label" bundle="${ae_labels}"/>&nbsp;</td>
			<td class="QueryData">&nbsp;<b><%=strSpineDislocation%></b></td>
        </tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr>
		<th colspan='6' align='left'><fmt:message key="eAE.GenitoUrinary.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<tr >
		<td class="label" align='right'><fmt:message key="eAE.Catheterin.label" bundle="${ae_labels}"/></td>
        <td align='left'  valign='center' class="QueryData">&nbsp;<%=strCatheter%></td>
        <td class="label" align='right' nowrap><fmt:message key="eAE.BloodAtMeatus.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strBloodAtMeatus%></td>
		<td class="label" align='right'><fmt:message key="eAE.Haematura.label" bundle="${ae_labels}"/></td>
		<td align='left' width='27%' class="QueryData">&nbsp;<%=strHaematura%>&nbsp;
		</td>
	</tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	</table>
	<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> 
	<a name='otherdetail'></a>
	<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strClinicName%></td>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
	<td align='LEFT' class='QueryData' >&nbsp;<%=strTreatmentName%></td>
	</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strTraumaDate%></td>
</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
	<td align='LEFT' class='QueryData' colspan='3'>&nbsp;<%=strPractName%></td>
</tr>
<br>
</table>
	<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
	<tr>
		<td width='100%' align='left'>
		<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper_click.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower_click.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others.gif'  ></img></a>
		</td>
	</tr>
	</table>
	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<tr>
		<th colspan='4' align='left'><fmt:message key="eAE.Vascular.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr>
		<td width='45%'>&nbsp;</td>
        <td >&nbsp;</td>
        <td  >&nbsp;</td>
        <td width='29%'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align='right' nowrap>Wide Mediastinum ( Chest X Ray )</td>
        <td align='left'  class="QueryData" colspan='4'>&nbsp;<%=strChestXray%></td>
	</tr> 
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.LimbColour.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData" colspan='4'>&nbsp;<%=strLimbColor%></td>
	</tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eAE.PulsesRight.label" bundle="${ae_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=strPulsesRight%>
		</td>
		<td class="label" align='right'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=strPulseLeft%>
		</td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<th colspan='4' align='left'><fmt:message key="eAE.Extremities.label" bundle="${ae_labels}"/></th>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr >
		<td class="label" align='right'><fmt:message key="eAE.OpenWounds.label" bundle="${ae_labels}"/></td>
        <td align='left'   colspan='4' class="QueryData">&nbsp;<%=strExtreOpenWound%></td>
	</tr>
	<tr >
		<td class="label"  align='right'><fmt:message key="eAE.FracturesList.label" bundle="${ae_labels}"/></td>
		<td align='left' colspan='4' class="QueryData">&nbsp;<%=strFractureList%></td>
	</tr>
	<tr >
		<td class="label"  align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td align='left' colspan='4' class="QueryData">&nbsp;<%=strRemarks%>	</td>
    </tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
  </table>

<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> 
</center>
</body>
</html>

