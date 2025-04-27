<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  1-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,java.text.SimpleDateFormat,java.util.Date"%>
<%
	String sStyle = checkForNull((String) session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
<html>
<head>
<style>
.inner_table { 
		width: 98%; 
		height: 300px;
		overflow-y: auto;
	}
</style>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Statement stmt = null;
	ResultSet rs = null;
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");
	
	String lstPatientClass = (request.getParameter("lstPatientClass") != null) ? request.getParameter("lstPatientClass") : "";
	String periodTo = DateUtils.convertDate(request.getParameter("periodTo"), "DMY", locale, "en");
	String periodFrom = DateUtils.convertDate(request.getParameter("periodFrom"), "DMY", locale, "en");
	String encounter_id = (request.getParameter("encounter_id") != null) ? request.getParameter("encounter_id") : "";
	String locationType = (request.getParameter("locationType") != null) ? request.getParameter("locationType") : "";
	String loc_val = (request.getParameter("loc_val") != null) ? request.getParameter("loc_val") : "";
	System.err.println(request.getParameter("patientId") != null);
	String patient_Id = (request.getParameter("patientId") != null) ? request.getParameter("patientId") : "";
	System.err.println("PatientId 1== "+patient_Id);
	String BHTStatus = (request.getParameter("BHTStatus") != null) ? request.getParameter("BHTStatus") : "";
	String pageName = (request.getParameter("pageName") != null) ? request.getParameter("pageName") : "";
	Integer maxDaysBHTSubmission = (!checkForNull(request.getParameter("maxDaysBHTSubmission")).equals("")) ? Integer.parseInt(request.getParameter("maxDaysBHTSubmission")) : 0;
	Date currentDateTime = new Date();
	String cMonth =  String.valueOf(currentDateTime.getMonth() + 1);
	String cDay =  String.valueOf(currentDateTime.getDate());
	String cYear =  String.valueOf(currentDateTime.getYear() + 1900);
	String cHours =  String.valueOf(currentDateTime.getHours());
	String cMinutes =  String.valueOf(currentDateTime.getMinutes());
							
	if(Integer.valueOf(cMonth) < 10)
		cMonth="0"+cMonth;
	if(Integer.valueOf(cDay) < 10)
		cDay="0"+cDay;
	String currentDate = cDay+"/"+cMonth+"/"+cYear+" "+cHours+":"+cMinutes;

	String PatientId = "";
	String BHT_Status = "";
	String EncounterDate = "";
	String EncounterId = "";
	String PatientClass = "";
	String PatientClassDesc = "";
	String LocnType = "";
	String AssignLocnDesc = "";
	String DischargeDate = "";
	String Specaility = "";
	String PractitionerName = "";
	String Facility_ID = "";
	String Remarks = "";

	int cnt = 0;
	HashMap<String,String> remarksMap = new HashMap();
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src="../js/PatientBHT.js"></script>
<script type="text/javascript">
	var CheckedEncounterID = "";
	var CheckedBHTStatus="";
	function bulkOrder(EncounterID, obj, BHTStatus) {
		if (obj.checked) {
			if (CheckedEncounterID == null || CheckedEncounterID == "") {
				CheckedEncounterID = EncounterID;
				CheckedBHTStatus = BHTStatus;
			} else {
				CheckedEncounterID = CheckedEncounterID + "," + EncounterID;
				CheckedBHTStatus = CheckedBHTStatus + "," + BHTStatus;
			}
		} else {
			var arrayRemove = new Array();
			var arrayBHTRemove = new Array();
			arrayRemove = CheckedEncounterID.split(',');
			arrayBHTRemove = CheckedBHTStatus.split(',');
			var index = 0;
			var countRemove = 0;
			for (var j = 0; j < arrayRemove.length; j++) {
				if (arrayRemove[j] == EncounterID) {
					countRemove++;
					index = j;
				}
			}
			if (countRemove > 0) {
				arrayRemove.splice(index, 1);
				arrayBHTRemove.splice(index, 1);
				CheckedEncounterID = arrayRemove.toString();
				CheckedBHTStatus = arrayBHTRemove.toString();
			}

		}
		parent.BHT_result.document.getElementById("EncounterID_param").value = CheckedEncounterID;
		parent.BHT_result.document.getElementById("BHTStatus_param").value = CheckedBHTStatus;
		
		var BHTStatusArray = new Array();
		BHTStatusArray = CheckedBHTStatus.split(',');
		var disableReturn = false;
		for (var i = 0; i < BHTStatusArray.length; i++) {
			if(BHTStatusArray[i]!="" && BHTStatusArray[i]!="Delivered"){
				disableReturn=true;
				break;
			}
		}
		if(disableReturn == true){
			document.getElementById("Return_BHT").disabled = true;
		} else {
			document.getElementById("Return_BHT").disabled = false;
		}
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="BHTResult" id="BHTResult" method="post" action='../../servlet/eMR.PatBHTServlet' target="messageFrame">
		<%
			try {
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT PATIENT_ID,BHT_STATUS,ENCOUNTER_DATE,ENCOUNTER_ID,PATIENT_CLASS,PATIENT_CLASS_DESC,ASSIGN_CARE_LOCN_TYPE_DESC,ASSIGN_CARE_LOCN_DESC,DISCHARGE_DATE_TIME,SPECAILITY_SHORT_DESC,PRACTITIONER_NAME,FACILITY_ID,REMARKS FROM  MR_PAT_BHT_STATUS_VW WHERE PATIENT_CLASS='"+lstPatientClass+"' AND to_date(to_char(TO_DATE (discharge_date_time, 'dd/mm/yyyy  hh24:mi'), 'dd/mm/yyyy'), 'dd/mm/yyyy') BETWEEN to_date('" + periodFrom + "','dd/mm/yyyy') and to_date('" + periodTo + "','dd/mm/yyyy')");
				
				if(!checkForNull(encounter_id).equals("")) {
					sql.append(" AND ENCOUNTER_ID=NVL('"+encounter_id+"',ENCOUNTER_ID)");
				}
				if(!checkForNull(locationType).equals("")) {
					sql.append(" AND ASSIGN_CARE_LOCN_TYPE=NVL('"+locationType+"',ASSIGN_CARE_LOCN_TYPE)");
				}
				if(!checkForNull(loc_val).equals("")) {
					sql.append(" AND ASSIGN_CARE_LOCN_CODE=NVL('"+loc_val+"',ASSIGN_CARE_LOCN_CODE)");
				}
				if(!checkForNull(patient_Id).equals("")) {
					sql.append(" AND PATIENT_ID=NVL('"+patient_Id+"',PATIENT_ID)");
				} 		
				if(!checkForNull(BHTStatus).equals("")) {
					String BHTStatusDesc = (BHTStatus.equals("P")) ? "Pending" : (BHTStatus.equals("O")) ? "Pending" : (BHTStatus.equals("D")) ? "Delivered"
											: (BHTStatus.equals("R")) ? "Received" : (BHTStatus.equals("X")) ? "Returned" : "";
					sql.append(" AND BHT_STATUS=NVL('" + BHTStatusDesc + "',BHT_STATUS)");
				} else {
					if (pageName.equals("ReceiveBHT")) {
						sql.append(" AND BHT_STATUS in('Pending','Overdue','Delivered','Received','Returned')");
					} else if (pageName.equals("DeliveryBHT")) {
						sql.append(" AND BHT_STATUS in('Pending','Overdue','Returned')");
					}
				}

				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql.toString());
				rst = pstmt.executeQuery();
		%>
		<div class="inner_table">
		<table class='grid' id='PatBHTResultTbl' border='1' cellpadding='1' cellspacing='0' width='100%' align='center'>
			<th align="center" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap></th>
			<th align="center" nowrap></th>
			<th align="center" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="eMR.BHTStatus.label" bundle="${mr_labels}"/></th>
			<th align="center" nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.DiagnosisDetails.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}" /></th>
			<%
				while (rst != null && rst.next()) {
						PatientId = checkForNull(rst.getString(1));
						BHT_Status = checkForNull(rst.getString(2));
						EncounterDate = checkForNull(rst.getString(3));
						EncounterId = checkForNull(rst.getString(4));
						PatientClass = checkForNull(rst.getString(5));
						PatientClassDesc = checkForNull(rst.getString(6));
						LocnType = checkForNull(rst.getString(7));
						AssignLocnDesc = checkForNull(rst.getString(8));
						DischargeDate = checkForNull(rst.getString(9));
						Specaility = checkForNull(rst.getString(10));
						PractitionerName = checkForNull(rst.getString(11));
						Facility_ID =  checkForNull(rst.getString(12));
						Remarks =  checkForNull(rst.getString(13));
						
						if(maxDaysBHTSubmission > 0 && BHT_Status.equals("Pending")){
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
							Date newDate = sdf.parse(DischargeDate);
							newDate.setDate(newDate.getDate() + maxDaysBHTSubmission);
							String month =  String.valueOf(newDate.getMonth() + 1);
							String day =  String.valueOf(newDate.getDate());
							String year =  String.valueOf(newDate.getYear() + 1900);
							String hours =  String.valueOf(newDate.getHours());
							String minutes =  String.valueOf(newDate.getMinutes());
													
							if(Integer.valueOf(month) < 10)
								month="0"+month;
							if(Integer.valueOf(day) < 10)
								day="0"+day;
							String maxDaysBHT = day+"/"+month+"/"+year+" "+hours+":"+minutes;
							
							Date date1 = sdf.parse(currentDate);
							Date date2 = sdf.parse(maxDaysBHT);
							
							BHT_Status = (BHT_Status.equals("Pending") && date1.after(date2))?"Overdue":BHT_Status;
						}
						
						String colourCode = BHT_Status.equals("Pending")?"#FFFF00":BHT_Status.equals("Overdue")?"#FF0000":BHT_Status.equals("Delivered")?"#ffa500":BHT_Status.equals("Received")?"#00FF00":BHT_Status.equals("Returned")?"#007FFF":"";
						String styleValue ="WIDTH: 50px; background-color:"+colourCode;
			%>
			<tr>
			<% if((checkForNull(BHTStatus).equals("")) || (!checkForNull(BHTStatus).equals("") && ((BHTStatus.equals("P") && BHT_Status.equals("Pending")) || (BHTStatus.equals("O") && BHT_Status.equals("Overdue")) || BHTStatus.equals("R") || BHTStatus.equals("D") || BHTStatus.equals("X"))) ){ %>
				<td nowrap><input type="checkbox" name="chk<%=EncounterId%>" id="chk<%=EncounterId%>" <%if(BHT_Status.equals("Received")){ %>disabled<%} %>
					id='chk<%=EncounterId%>' onclick="bulkOrder('<%=EncounterId%>',this,'<%=BHT_Status%>')"></td>
				<td nowrap><font size=1><a href="#" onClick="showEncounter('<%=EncounterId%>','<%=PatientId%>','<%=(PatientClass==null)?"":PatientClass%>','<%=Facility_ID%>')">+</a></td>
				<td nowrap style="<%=styleValue%>"></td>
				<td nowrap><font size=1><a href="#" onClick="callDemographics('<%=PatientId%>')"><%=PatientId%></a></td>
				<td nowrap><%=BHT_Status%></td>
				<td nowrap><%=EncounterDate%></td>
				<td nowrap><%=EncounterId%></td>
				<td nowrap><%=PatientClassDesc%></td>
				<td nowrap><%=LocnType%> / <%=AssignLocnDesc%></td>
				<td nowrap><%=DischargeDate%></td>
				<td nowrap><%=Specaility%></td>
				<td nowrap><%=PractitionerName%></td>
				<td nowrap><font size=1><a href="#" onClick="viewDiagnosis('<%=EncounterId%>','<%=PatientId%>','<%=Facility_ID%>')"><fmt:message key="eMR.DiagnosisDetails.label" bundle="${mr_labels}"/></a></td>
				<td nowrap><font size=1><a href="#" onClick="viewRemarks('<%=EncounterId%>')"><fmt:message key="eMR.CAUSE_OF_DEATH_REMARKS.label" bundle="${mr_labels}"/></a>
				<input type="hidden" id="remarks_<%=EncounterId%>" name="remarks_<%=EncounterId%>" value="<%=Remarks%>">
				</td>
				<%
					cnt++;
					}
				}

				if (cnt == 0) {
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				%>
			</tr>
		</table>
		</div>

		<%
			if (pageName.equals("DeliveryBHT")) {
		%>
		<input style="float: right;" type="button" class="button"
			name="Deliver_BHT" id="Deliver_BHT" value='Deliver BHT' onClick="submitBHT('Delvier')">
		<%
			} else if (pageName.equals("ReceiveBHT")) {
		%>
		<input style="float: right;height:90%" type="button" class="button"
			name="Receive_BHT" id="Receive_BHT" value='Receive BHT' onClick="submitBHT('Receive')">
		<input style="float: right;height:90%" type="button" class="button"
			name="Return_BHT" id="Return_BHT" value='Return BHT' onClick="submitBHT('Return')">
		<%	} %>

		<input type="hidden" id = "EncounterID_param" name="EncounterID_param" id="EncounterID_param" value="">
		<input type="hidden" id = "BHTStatus_param" name="BHTStatus_param" id="BHTStatus_param" value="">
		<input type="hidden" id = "pageName" name="pageName" id="pageName" value="<%=pageName%>">
		<input type="hidden" id = "buttonType" name="buttonType" id="buttonType" value="">
		<%
			if (pstmt != null)
					pstmt.close();
				if (rst != null)
					rst.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.returnConnection(con, request);
			}
		%>
	</form>
</body>
</html>
<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}%>

