<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
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
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			
      
			if(val == 'HealthCare_Setting_Type')
				parent.frames[1].location.href = '../../eAM/jsp/HealthCareSettingType.jsp?module_id=AM&function_id=HCARE_SET_TYPE&function_name='+encodeURIComponent(getLabel("Common.HealthcareSettingType.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'HealthCare_Setting_Type_Restrictions')
				parent.frames[1].location.href = '../../eAM/jsp/HealthCareSettingTypeRestrictions.jsp?module_id=AM&function_id=HCARE_SET_TYPE_RSTRN&function_name='+encodeURIComponent(getLabel("eAM.HealthCareSettingTypeRestrictions.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'ExternalReferralSource')
				parent.frames[1].location.href = '../../servlet/eAM.ReferralServlet?module_id=AM&function_id=REFERRAL&function_name='+encodeURIComponent(getLabel("eAM.ExternalReferralSource.label","am"))+'&function_type=F&access=YYYNN';

			if(val == 'Referral_ID_Numbering')
				parent.frames[1].location.href = '../../eAM/jsp/ReferralIDNumbering.jsp?module_id=AM&function_id=REF_ID_NUM_FOR_FCY&function_name='+encodeURIComponent(getLabel("eAM.ReferralIDNumbering.label","am"))+'&function_type=F&access=YYYNN';
		
			if(val == 'ExternalReferralSource')
			parent.frames[1].location.href = '../../servlet/eAM.ReferralServlet?module_id=AM&function_id=REFERRAL&function_name='+encodeURIComponent(getLabel("eAM.ExternalReferralSource.label","am"))+'&function_type=F&access=YYYNN';
			
			if(val == 'Referral_Speciality')
				parent.frames[1].location.href = '../../eAM/jsp/SpecialtyForExternalReferralSource.jsp?module_id=AM&function_id=SPLTY_FOR_EXT_REF_SRC&function_name='+encodeURIComponent(getLabel("eAM.SpecialtyforExternalReferralSource.label","am"))+' &function_type=F&access=YYYNN';

			if(val == 'ExternalPractitioner')
				parent.frames[1].location.href = '../../eAM/jsp/ExternalPractitioner.jsp?module_id=AM&function_id=EXT_PRACT&function_name='+encodeURIComponent(getLabel("Common.ExternalPractitioner.label","common"))+'&function_type=F&access=YYYNN';

			if(val == 'ExternalPractitionerForRef')
				parent.frames[1].location.href = '../../eAM/jsp/PractForExternalReferral.jsp?module_id=AM&function_id=EXT_PRACT_REF_SRC&function_name='+encodeURIComponent(getLabel("eAM.ExternalPractitionerforReferralSource.label","am"))+'&function_type=F&access=YYYNN';

		}

	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()' >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('HealthCare_Setting_Type');"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('HealthCare_Setting_Type_Restrictions');"><fmt:message key="eAM.HealthCareSettingTypeRestrictions.label" bundle="${am_labels}"/></td>
		</tr>
		

		
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ExternalReferralSource')"><fmt:message key="eAM.ExternalReferralSource.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Referral_Speciality');"><fmt:message key="eAM.SpecialtyforExternalReferralSource.label" bundle="${am_labels}"/></td>
		</tr>
	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ExternalPractitionerForRef')"><fmt:message key="eAM.ExternalPractitionerforReferralSource.label" bundle="${am_labels}"/></td>
		</tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Referral_ID_Numbering');"><fmt:message key="eAM.ReferralIDNumbering.label" bundle="${am_labels}"/></td>
		</tr>
		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style="color:white"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		

	</table>
	</body>
	</form>
</html>

