<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
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
				if (document.getElementById("t").rows(prev).cells(0).className != 'ECMENUHIGHERLEVELCOLOR') {
					document.getElementById("t").rows(prev).cells(0).className=prevcol;
				}
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
				Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if(val == 'Grade'){
				parent.frames[1].location.href = 'Grade.jsp?module_id=RS&function_id=Grade&function_name=Grade&function_type=F&access=YYYNN';
			}
			if(val == 'Reason'){
				parent.frames[1].location.href = 'Reason.jsp?module_id=RS&function_id=Reason&function_name=Reason&function_type=F&access=YYYNN';
			}

			if(val == 'Training'){
				parent.frames[1].location.href = 'Training.jsp?module_id=RS&function_id=Training&function_name=Training&function_type=F&access=YYYNN';
			}
			if(val == 'Access_ Rights'){
				parent.frames[1].location.href = 'AccessRights.jsp?module_id=RS&function_id=AccessRights&function_name=Access Rights&function_type=F&access=YYYNN';
			}

			if(val == 'workplace')
			{
				parent.frames[1].location.href = 'Workplace.jsp?module_id=RS&function_id=Workplace&function_name=Workplace&function_type=F&access=YYYNN';
			}
			if(val == 'staffprofile')
			{
				parent.frames[1].location.href = 'StaffProfileSetup.jsp?module_id=RS&function_id=StaffProfile&function_name=Staff  Profile&function_type=F&access=NNNNY';
			}
			if(val == 'staff_for_workplace')
			{
				parent.frames[1].location.href = 'StaffForWorkplace.jsp?module_id=RS&function_id=Staff_For_Workplace&function_name=Staff For Workplace&function_type=F&access=YYYNN';
			}
			if(val == 'shift_for_workplace')
			{
				parent.frames[1].location.href = 'ShiftForWorkplace.jsp?module_id=RS&function_id=Shift_For_Workplace&function_name=Shift For Workplace&function_type=F&access=YYYNN';
			}
			if(val == 'shift_pattern')
			{
				parent.frames[1].location.href = 'ShiftPattern.jsp?module_id=RS&function_id=Shift_Pattern&function_name=Shift Pattern&function_type=F&access=YYYNN';
			}
			if(val == 'shift_pattern_for_workplace')
			{
				parent.frames[1].location.href = 'ShiftPatternForWorkplace.jsp?module_id=RS&function_id=Shift_Pattern_For_Workplace&function_name=Shift Pattern For Workplace&function_type=F&access=YYYNN';
			}
			if(val == 'skill')
			{
				parent.frames[1].location.href = 'Skill.jsp?module_id=RS&function_id=Skill&function_name=Skill&function_type=F&access=YYYNN';
			}
			if(val == 'skillforposition')
			{
				parent.frames[1].location.href = 'SkillForPosition.jsp?module_id=RS&function_id=SkillForPosition&function_name=Skill for Position&function_type=F&access=YYYNN';
			}
            if(val == 'licensure')
			{
				parent.frames[1].location.href = 'Licensure.jsp?module_id=RS&function_id=Licensure&function_name=Licensure&function_type=F&access=YYYNN';
			}
            if(val == 'workplace_requirement')
			{
				parent.frames[1].location.href = 'WorkplaceRequirement.jsp?module_id=RS&function_id=WorkplaceRequirement&function_name=Workplace Requirement&function_type=F&access=YYYNN';
			}
            if(val == 'locnforworkplace')
			{
				parent.frames[1].location.href = 'LocnForWorkplace.jsp?module_id=RS&function_id=locnforworkplace&function_name=Locations For Workplace&function_type=F&access=YYYNN';
			}
            if(val == 'Parameter')
			{
				parent.frames[1].location.href = 'Parameter.jsp?module_id=RS&function_id=Parameter&function_name=Parameters&function_type=F&access=YYYYN';
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
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick="">Code Setup</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Grade')">Grade</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Reason')">Reason</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Training')">Training</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('skill')">Skill</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('skillforposition')">Skill for Position</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('licensure')">Licensure</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('workplace')">Workplace</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('locnforworkplace')">Locations for Workplace</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('staffprofile')">Staff Profile</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('staff_for_workplace')">Staff for Workplace</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('shift_for_workplace')">Shift for Workplace</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('workplace_requirement')">Workplace Requirement</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('shift_pattern')">Shift Pattern</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('shift_pattern_for_workplace')">Shift Pattern for Workplace</td>
		</tr>
		<!-- End -->
		<tr>
			<td  class='ECMENUHIGHERLEVELCOLOR' onClick="">Admin Setup</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Parameter')">Parameters</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Access_ Rights')">Access Rights</td>
		</tr>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b>HOME</b></a></td>
		</tr>
	</table>
    </form>
	</body>
</html>

