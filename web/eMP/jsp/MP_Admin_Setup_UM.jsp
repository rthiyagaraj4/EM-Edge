<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
      
			if(val == 'PatientSeries')
				parent.frames[1].location.href = '../../servlet/eMP.PatientNumberingServlet?module_id=MP&function_id=MP_PAT_SER_GRP&function_name='+encodeURIComponent(getLabel("eMP.PatientSeries.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'MPParameter')
				parent.frames[1].location.href = '../../eMP/jsp/mp_param.jsp?module_id=MP&function_id=MPAPARAM&function_name='+encodeURIComponent(getLabel("eMP.MPParameter.label","MP"))+'&function_type=F&access=NYNNN';
		/*	if(val == 'MPParameterforFacility')
				parent.frames[1].location.href = '../../eMP/jsp/FacilityLevelPass.jsp?module_id=MP&function_id=MPAFYPAR&function_name='+encodeURIComponent(getLabel("eMP.MPParameterforFacility.label","MP"))+'&function_type=F&access=YYYYN';
		*/
			if(val == 'MPTerminalDigit')
				parent.frames[1].location.href = '../../eMP/jsp/TerminalDigitPass.jsp?module_id=MP&function_id=MPTERMDIGIT&function_name='+encodeURIComponent(getLabel("eMP.MPTerminalDigit.label","MP"))+'&function_type=F&access=YYYYN';
			if(val == 'MPAuditTrailParameter')
				parent.frames[1].location.href = '../../eMP/jsp/MPAuditTrialParameterMain.jsp?module_id=MP&function_id=MP_AUDIT_TRAIL_PARAM&function_name='+encodeURIComponent(getLabel("eMP.MPAuditTrailParameter.label","MP"))+'&function_type=F&access=NYNNN';
			if(val == 'MRSection')
				parent.frames[1].location.href = '../../eMP/jsp/MRecordsSectionPass.jsp?module_id=MP&function_id=MR_SECTION&function_name='+encodeURIComponent(getLabel("Common.MRSection.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'FileType') 
				parent.frames[1].location.href = '../../eMP/jsp/FileType.jsp?module_id=MP&function_id=MR_FILE_TYPE&function_name='+encodeURIComponent(getLabel("Common.filetype.label","common"))+'&function_type=F&access=YYYNN';				
			if(val == 'PatientNumbering')
				parent.frames[1].location.href = '../../servlet/eMP.PatientNumberingDetailServlet?module_id=MP&function_id=MP_PAT_NUMBERING&function_name='+encodeURIComponent(getLabel("eMP.PatientNumbering.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'PatientNumberingForRelnLevel')
				parent.frames[1].location.href = '../../eMP/jsp/PatientNumberingForRelation.jsp?module_id=MP&function_id=MP_PAT_NUMBERING_RELN_LVL&function_name='+encodeURIComponent(getLabel("eMP.PatientNumberingForRelation.label","MP"))+'&function_type=F&access=NYNNN';
			if(val == 'MPInternalRequestReportRule')
				parent.frames[1].location.href = '../../eMP/jsp/MpInternalReqRepRule.jsp?module_id=MP&function_id=MP_ONLINE_REPORT&function_name='+encodeURIComponent(getLabel("eMP.MPInternalRequestReportRule.label","MP"))+'&function_type=F&access=YYYYN';
			if(val == 'PatientSearchResultFormat')
				parent.frames[1].location.href = '../../eMP/jsp/PatSearchResultFormat.jsp?module_id=MP&function_id=MP_PAT_SEARCH_RESULT&function_name='+encodeURIComponent(getLabel("eMP.PatientSearchResultFormat.label","MP"))+'&function_type=F&access=NYYNN';
			if(val == 'PurgeAudit')
				parent.frames[1].location.href = '../../eMP/jsp/MP_PurgeAudit.jsp?module_id=MP&function_id=PURGEAUDIT&function_name='+encodeURIComponent(getLabel("eMP.PurgeAudit.label","MP"))+'&function_type=F&access=NYNNN';
			if(val == 'PatEncBanner')
				parent.frames[1].location.href = '../../eMP/jsp/PatEncBannerMain.jsp?module_id=MP&function_id=PatEncBanner&function_name='+encodeURIComponent(getLabel("eMP.PatEncBanner.label","MP"))+'&function_type=F&access=NYNNN';
		if(val == 'AccessRights')
			parent.frames[1].location.href = '../../eMP/jsp/MP_AccessRights.jsp?module_id=MP&function_id=AccessRights&function_name='+encodeURIComponent(getLabel("eMP.MPAccessRights.label","MP"))+'&function_type=F&access=NYNNN';
		/*			if(val == 'PatientAdministrator')
				parent.frames[1].location.href = '../../eMP/jsp/PatientAdministrator.jsp?module_id=MP&function_id=PATIENTADMIN&function_name=Patient Administrator&function_type=F&access=YYYNN';
			
			if(val == 'SecurityLevel')
				parent.frames[1].location.href = '../../eMP/jsp/SecurityLevel.jsp?module_id=MP&function_id=SECURITYLEVEL&function_name=Security Level&function_type=F&access=YYYNN';*/

		}

	</script>

	</head>

	<body style="background-color:dimgray;" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientSeries')"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
		</tr>
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MRSection')"><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FileType')"><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
		</tr>-->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientNumbering')"><fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/></td>
		</tr>
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientNumberingForRelnLevel')"><fmt:message key="eMP.PatientNumberingForRelation.label" bundle="${mp_labels}"/></td>
		</tr>-->
 		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MPParameter')"><fmt:message key="eMP.MPParameter.label" bundle="${mp_labels}"/></td>
		</tr>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MPParameterforFacility')"><fmt:message key="eMP.MPParameterforFacility.label" bundle="${mp_labels}"/></td>
		</tr> -->
		<!--
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MPTerminalDigit')"><fmt:message key="eMP.MPTerminalDigit.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MPAuditTrailParameter')"><fmt:message key="eMP.MPAuditTrailParameter.label" bundle="${mp_labels}"/></td>
		</tr>
 		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MPInternalRequestReportRule')"><fmt:message key="eMP.MPInternalRequestReportRule.label" bundle="${mp_labels}"/></td>
		</tr>
 		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientSearchResultFormat')"><fmt:message key="eMP.PatientSearchResultFormat.label" bundle="${mp_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PurgeAudit')"><fmt:message key="eMP.PurgeAudit.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatEncBanner')"><fmt:message key="eMP.PatEncBanner.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' 
		onClick="javascript:callJSPs( 'AccessRights')"><fmt:message key="eMP.MPAccessRights.label" bundle="${mp_labels}"/></td>
		</tr>
		
		
		
		<tr><td class="BLANK_ROW">&nbsp;</td></tr> -->
	<!-- 	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AccessRights')"><fmt:message key="eMP.AccessRightsforViewPatientPhoto.label" bundle="${mp_labels}"/></td>
		</tr> -->
	<!--	<tr><td class="BLANK_ROW">&nbsp;</td></tr>-->
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SecurityLevel')">Security Level</td>
		</tr>-->
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientAdministrator')">Patient Administrator</td>
		</tr> -->	
		<tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

	</table>

	</body>
	</form>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

