<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="JavaScript">
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='ECMENUHIGHERLEVELCOLOR';//IPCAHIGHERLEVELCOLOR
		var sec_hdg_cd	 = new Array();
		var logic_seq_no = new Array();
		function goHomePage()
		{
			parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}

		function chcol(ro)
		{
			document.getElementById("t").rows(prev).cells(0).className = prevcol;
			prevcol	= ro.cells(0).className;
			ro.cells(0).className = "MENUSELECTEDCOLOR";//IPCASELECTEDCOLOR
			prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*	Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if(val == 'NURSING_UNIT')
				parent.frames[1].location.href = '../../eIP/jsp/NursingUnit.jsp?function_name='+encodeURIComponent(getLabel("Common.nursingUnit.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'NURSING_UNIT_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/NursingUnitType.jsp?function_name='+encodeURIComponent(getLabel("eIP.NursingUnitType.label","IP"))+'&access=YYYNN&function_type=F';
			if(val == 'PHYS_LOCN_FOR_NURS_UNIT')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitPhysLocn.jsp?function_name='+encodeURIComponent(getLabel("eIP.PhysicalLocationforNursingUnit.label","IP"))+'&access=YYYYN&function_type=F';
			if(val == 'LEVEL_OF_CARE')
				parent.frames[1].location.href = '../../eAM/jsp/LevelofCare.jsp?function_name='+encodeURIComponent(getLabel("Common.levelofcare.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'BED_CLASS')
				parent.frames[1].location.href = '../../eIP/jsp/BedClass.jsp?function_name='+encodeURIComponent(getLabel("Common.BedClass.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'BED_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/BedType.jsp?function_name='+encodeURIComponent(getLabel("Common.bedtype.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'BLOCKING_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/BlockingType.jsp?function_name='+encodeURIComponent(getLabel("eIP.BlockingType.label","IP"))+'&access=YYYNN&function_type=F';

			if(val == 'MED_SER_GRP')
				parent.frames[1].location.href = '../../eIP/jsp/MedicalServiceGrp.jsp?function_name='+encodeURIComponent(getLabel('eIP.MedicalServiceGroup.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'MED_SER_GRP_NURS_UT_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/MedSerGrpNursUtType.jsp?function_name='+encodeURIComponent(getLabel('eIP.NursingUnitTypeforMedicalServiceGroup.label','IP'))+'&access=YYYYN&function_type=F';
			if(val == 'NURS_UT_BKG_LT')
				parent.frames[1].location.href = '../../eIP/jsp/NursingUnitBkgLt.jsp?function_name='+encodeURIComponent(getLabel('eIP.BookingLimitByNursingUnitBedClass.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'AGE_GRP_BOOK_LT')
				parent.frames[1].location.href = '../../eIP/jsp/AgeGrpBookLt.jsp?function_name='+encodeURIComponent(getLabel('eIP.BookingLimitByAgeGroupBedClass.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'BED_BKG_SRL_CTRL')
				parent.frames[1].location.href = '../../eIP/jsp/BedBkgSrlCtrl.jsp?function_name='+encodeURIComponent(getLabel('eIP.BedBookingSerialControl.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'NURS_UNIT_BED')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitBed.jsp?function_name='+encodeURIComponent(getLabel('Common.Bed.label','Common'))+' '+ encodeURIComponent(getLabel('Common.for.label','Common'))+' '+encodeURIComponent(getLabel('Common.nursingUnit.label','Common'))+'&access=YYYYN&function_type=F';
			if(val == 'ADMISSION_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/AdmissionType.jsp?function_name='+encodeURIComponent(getLabel('Common.admissiontype.label','Common'))+'&access=YYYNN&function_type=F';
			if(val == 'TRANSFER_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/TransferType.jsp?function_name='+encodeURIComponent(getLabel('eIP.TransferType.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'DISCHARGE_TYPE')
				parent.frames[1].location.href = '../../eIP/jsp/DischargeType.jsp?function_name='+encodeURIComponent(getLabel('Common.dischargetype.label','Common'))+'&access=YYYNN&function_type=F';
			if(val == 'LODGER_STAY_REASON')
				parent.frames[1].location.href = '../../eIP/jsp/LodgerStayReason.jsp?function_name='+encodeURIComponent(getLabel('eIP.ReasonforLodgerStay.label','IP'))+'&access=YYYNN&function_type=F';
			//Added by kishore on 4/22/2004
			if(val == 'TRANSFER_PRIORITY')
				parent.frames[1].location.href = '../../eIP/jsp/Priority.jsp?function_name='+encodeURIComponent(getLabel('eIP.TransferPriority.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'NURS_UNIT_ROOM')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitRoom.jsp?function_name='+encodeURIComponent(getLabel('eIP.RoomCubicleforNursingUnit.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'NURS_UNIT_PRACT')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitPract.jsp?function_name='+encodeURIComponent(getLabel('eIP.PractitionerforNursingUnit.label','IP'))+'&access=YNYNN&function_type=F';
			if(val == 'NURS_UNIT_SPECIALTY')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitSpecialty.jsp?function_name='+encodeURIComponent(getLabel('eIP.SpecialtyforNursingUnit.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'NURS_UNIT_SERVICES')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitServices.jsp?function_name='+encodeURIComponent(getLabel('eIP.ServicesforNursingUnit.label','IP'))+'&access=YYYNN&function_type=F';
			if(val == 'Room')
				parent.frames[1].location.href = '../../eAM/jsp/Room.jsp?module_id=AM&function_id=ROOM&function_name='+encodeURIComponent(getLabel('Common.RoomCubicle.label','Common'))+'&function_type=F&access=YYYNN';
			if(val == 'DAY_CARE_FOR_NURS_UNIT')
				parent.frames[1].location.href = '../../eIP/jsp/DayCareUnitLink.jsp?function_name='+encodeURIComponent(getLabel('eIP.DaycareUnitforNursingUnit.label','IP'))+'&access=YYYNN&function_type=F';
//<!-- modified on 01/07/2008 for SCR 3228-->
			if(val == 'DISCHARGE_STATUS')
				parent.frames[1].location.href = '../../eIP/jsp/DischargeStatus.jsp?function_name='+encodeURIComponent(getLabel('eIP.DischargeStatus.label','IP'))+'&access=YYYNN&function_type=F';
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<body style="background-color:dimgray;" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name="IPMasterMenu_form" id="IPMasterMenu_form">
		<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
			<tr>
				<td  class='IPCAHIGHERLEVELCOLOR'><fmt:message key="eIP.NursingUnitSetup.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURSING_UNIT_TYPE")'><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("LEVEL_OF_CARE")' ><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURSING_UNIT")' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("PHYS_LOCN_FOR_NURS_UNIT")' ><fmt:message key="eIP.PhysicalLocationforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Room');"><fmt:message key="Common.RoomCubicle.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UNIT_ROOM")' ><fmt:message key="eIP.RoomCubicleforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UNIT_PRACT")' ><fmt:message key="eIP.PractitionerforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UNIT_SPECIALTY")' ><fmt:message key="eIP.SpecialtyforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UNIT_SERVICES")' ><fmt:message key="eIP.ServicesforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("DAY_CARE_FOR_NURS_UNIT")' ><fmt:message key="eIP.DaycareUnitforNursingUnit.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr>
				<td class='IPCAHIGHERLEVELCOLOR'><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("BED_CLASS")'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("BED_TYPE")' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			</tr onclick='chcol(this)'>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UNIT_BED")' ><fmt:message key="Common.Bed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("BLOCKING_TYPE")' ><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr >
				<td class='IPCAHIGHERLEVELCOLOR'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("MED_SER_GRP")' ><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("MED_SER_GRP_NURS_UT_TYPE")'><fmt:message key="eIP.NursingUnitTypeforMedicalServiceGroup.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr>
				<td class='IPCAHIGHERLEVELCOLOR'><fmt:message key="Common.admission.label" bundle="${common_labels}"/>/<fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>/<br><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/></td>
			</tr>

			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("ADMISSION_TYPE")' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			</tr>

			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("TRANSFER_TYPE")' ><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/></td>
			</tr>
<!-- modified on 01/07/2008 for SCR 3228-->
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("DISCHARGE_STATUS")' ><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("DISCHARGE_TYPE")' ><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("LODGER_STAY_REASON")' ><fmt:message key="eIP.ReasonforLodgerStay.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr onclick='chcol(this)'>
				<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("TRANSFER_PRIORITY")' ><fmt:message key="eIP.TransferPriority.label" bundle="${ip_labels}"/> </td>
			</tr>
			<tr>
				<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
			</tr>
		</table>
	</body>
	</form>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

