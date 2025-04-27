<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%

	request.setCharacterEncoding("UTF-8");
	//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<style>
		A:active {
			COLOR: white;
		}

	</style>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){

				//parent.location.href='../../eCommon/jsp/CommonClearObjects.jsp';
				parent.location.href='../../eCommon/jsp/dmenu.jsp';

		}

		function chcol(ro)
		{
				if (document.getElementById("t").rows(prev).cells(0).className != 'ECMENUHIGHERLEVELCOLOR') {
					document.getElementById("t").rows(prev).cells(0).className=prevcol;
				}
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*Access is in the order -Insert,update,query,delete,print*/

			if(val == 'InterventionType'){
				parent.frames[1].location.href = 'InterventionType.jsp?module_id=CP&function_id=InterventionType&function_name=Intervention Type&function_type=F&access=YYYNN';
			}
			if(val == 'Intervention'){
				parent.frames[1].location.href = 'Intervention.jsp?module_id=CP&function_id=Intervention&function_name=Intervention&function_type=F&access=YYYNN';
			}
			if(val == 'PatientClassForIntervention'){
				parent.frames[1].location.href = 'InterventionForPatientClass.jsp?module_id=CP&function_id=PatientClassForIntervention&function_name=Intervention For Patient Class&function_type=F&access=YYYNN';
			}
			if(val == 'AgeGroupForIntervention'){
				parent.frames[1].location.href = 'AgeGroupForIntervention.jsp?module_id=CP&function_id=AgeGroupForIntervention&function_name=Age Group For Intervention&function_type=F&access=YYYNN';
			}
			if(val == 'PositionForIntervention')
			{
				parent.frames[1].location.href = 'PositionForIntervention.jsp?module_id=CP&function_id=PositionForIntervention&function_name=Position For Intervention&function_type=F&access=YYYNN';
			}
			if(val == 'FreqForIntervention')
			{
				parent.frames[1].location.href = 'FrequencyForIntervention.jsp?module_id=CP&function_id=FrequencyForIntervention&function_name=Frequency For Intervention&function_type=F&access=YYYNN';
			}
			if(val == 'InterventionParameter')
			{
				parent.frames[1].location.href = 'InterventionParam.jsp?module_id=CP&function_id=Parameters&function_name=Parameters&function_type=F&access=NYNNN';
			}
		}



	function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;

		arguments = vals

		retVal	= window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body style="background-color:dimgray;"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>

	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr>
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick="">Intervention Setup</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('InterventionType')">Intervention Type</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Intervention')">Intervention</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientClassForIntervention')">Patient Class for Intervention</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AgeGroupForIntervention')">Age Group for Intervention</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PositionForIntervention')">Position for Intervention</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FreqForIntervention')">Frequency for Intervention</td>
		</tr>
		<!-- Admin Functions Section -->
		<tr>
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick="">Intervention Admin Setup</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('InterventionParameter')">Parameters</td>
		</tr>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
	</table>
    </form>
	</body>

</html>

