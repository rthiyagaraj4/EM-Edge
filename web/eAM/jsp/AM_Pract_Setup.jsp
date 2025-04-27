<!DOCTYPE html>
<%--
	FileName	: AM_Pract_Setup.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
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
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
    
			if(val == 'Speciality')
				parent.frames[1].location.href = '../../eAM/jsp/AddSpeciality.jsp?module_id=AM&function_id=SPECIALITY&function_name='+encodeURIComponent(getLabel("Common.speciality.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'PractitionerType')
				parent.frames[1].location.href = '../../eAM/jsp/PractitionerType.jsp?module_id=AM&function_id=PRACT_TYPE&function_name='+encodeURIComponent(getLabel("Common.practitionertype.label","Common"))+'&function_type=F&access=NYYNN';
		    			
			if(val == 'Practitioner')
				parent.frames[1].location.href = '../../eAM/jsp/Practitioner.jsp?module_id=AM&function_id=PRACTITIONER&function_name='+encodeURIComponent(getLabel("Common.practitioner.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'PractitionerforFacility')
				parent.frames[1].location.href = '../../eAM/jsp/md_OPPForFacility.jsp?module_id=AM&function_id=PRACT_FOR_FACILITY&function_name='+encodeURIComponent(getLabel("eAM.PractitionerforFacility.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'Position')
				parent.frames[1].location.href = '../../eAM/jsp/Position.jsp?module_id=AM&function_id=POSITION&function_name='+encodeURIComponent(getLabel("Common.Position.label","Common"))+' &function_type=F&access=YYYNN';
			if(val == 'SpecialityforPractitioner')
				parent.frames[1].location.href = '../../eAM/jsp/md_OPSPractitioner.jsp?module_id=AM&function_id=SPECIALITY_PRACT&function_name='+encodeURIComponent(getLabel("Common.SpecialityforPractitioner.label","common"))+'&function_type=F&access=YYYNN';
            if(val == 'MedicalTeam')
				parent.frames[1].location.href = '../../eAM/jsp/MedicalTeam.jsp?module_id=AM&function_id=MEDICAL_TEAM&function_name='+encodeURIComponent(getLabel("Common.medicalteam.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'PractForMedicalTeam')
				parent.frames[1].location.href = '../../eAM/jsp/md_PractitionersForTeam.jsp?module_id=AM&function_id=PRACT_FOR_TEAM&function_name='+encodeURIComponent(getLabel("eAM.PractitionerforTeam.label","am"))+'&function_type=F&access=YYYNN';
				
		}

	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()' >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Speciality');"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractitionerType');"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Position');"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		</tr>
		
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Practitioner');"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractitionerforFacility');"><fmt:message key="eAM.PractitionerforFacility.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityforPractitioner');"><fmt:message key="Common.SpecialityforPractitioner.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MedicalTeam');"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractForMedicalTeam');"><fmt:message key="eAM.PractitionerforTeam.label" bundle="${am_labels}"/></td>
		</tr>
		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		
	</table>
	</body>
</form>
</html>

