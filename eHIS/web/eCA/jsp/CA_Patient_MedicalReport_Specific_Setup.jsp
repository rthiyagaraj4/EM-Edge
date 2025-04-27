<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String license_rights = "";
if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
{
	license_rights= "FULL";
}
else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
{
	license_rights= "BASIC";
}
else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
{
	license_rights= "MINI";
}

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'> </script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

	<style>
		A:active{ 
			COLOR: white; 
		}
	</style>
	
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=1;
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
	
		    if(val == 'EncounterDetails'){					
				parent.frames[1].location.href = '../../eCA/jsp/CAPatientMedicalReport.jsp?module_id=CA&function_id=Encounter Details&function_name='+encodeURIComponent(getLabel("eCA.EncounterDetailForPMR.label","CA"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'Speciality'){
				parent.frames[1].location.href = '../../eCA/jsp/CAPatientMedicalReport.jsp?module_id=CA&function_id=Speciality&function_name='+encodeURIComponent(getLabel("eCA.SpecialityForPMR.label","CA"))+'&function_type=F&access=NYNNN';
			}
			  if(val == 'Practitioner'){
				parent.frames[1].location.href = '../../eCA/jsp/CAPatientMedicalReport.jsp?module_id=CA&function_id=Practitioner&function_name='+encodeURIComponent(getLabel("eCA.PractitionerForPMR.label","CA"))+'&function_type=F&access=NYNNN';
			}		  			
			if(val == 'UserPrevilegeForPrintEMail')
			{
				parent.frames[1].location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailMain.jsp?module_id=CA&function_id=UserPrevilegeForPrintEMail&function_name='+encodeURIComponent(getLabel("eCA.PrintMailPrivilegeForPMR.label","CA"))+'&function_type=F&access=YNNNN';
			}

}	
	

	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	=await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;">
	<form name="CA_PMR_MasterMenu_form" id="CA_PMR_MasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
 		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.PatientMedicalReport.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EncounterDetails')"><fmt:message key="eCA.EncounterDetailForPMR.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Speciality')"><fmt:message key="eCA.SpecialityForPMR.label" bundle="${ca_labels}"/></td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Practitioner')"><fmt:message key="eCA.PractitionerForPMR.label" bundle="${ca_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UserPrevilegeForPrintEMail')"><fmt:message key="eCA.PrintMailPrivilegeForPMR.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

	</table>

	</body>
	</form>
</html>

