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
	
			  if(val == 'SpecialityEvent'){
				parent.frames[1].location.href = '../../eCA/jsp/SpecialtyEvent.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.SpecialityEvent.label","CA"))+'&function_type=F&access=NYYNN';
			}
			  if(val == 'SpecialityOutcome'){
				parent.frames[1].location.href = '../../eCA/jsp/SpecialityOutcome.jsp?module_id=CA&function_id=SpecialityOutcome&function_name=Speciality Outcome&function_type=F&access=NYYNN';
			}
			  if(val == 'SpecialityTasks'){
				parent.frames[1].location.href = '../../eCA/jsp/SpecialityTasks.jsp?module_id=CA&function_id=SpecialityTasks&function_name='+encodeURIComponent(getLabel("Common.speciality.label","common")+" "+getLabel("Common.Tasks.label","COMMON"))+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'SpltyEventOutcome'){
				parent.frames[1].location.href = '../../eCA/jsp/SpltyEventOutcomeMain.jsp?module_id=CA&function_id=SpecialityEventOutcome&function_name=Speciality Event Outcome&function_type=F&access=YYYNN';
			}

			if(val == 'SpecialityTasksForEvents'){
				parent.frames[1].location.href = '../../eCA/jsp/SpecialityTasksForEvents.jsp?module_id=CA&function_id=SpecialityTasksForEvents&function_name=Speciality Tasks For Events&function_type=F&access=YYYNN';
			}
			if(val == 'SpecialityEpisodeCycle'){
				parent.frames[1].location.href = '../../eCA/jsp/SpecialityEpisodeCycle.jsp?module_id=CA&function_id=SpecialityTasksForEvents&function_name=Speciality Episode Cycle&function_type=F&access=NYYNN';
			}
			if(val == 'SpecialityMasterCode'){
				parent.frames[1].location.href =																																					  '../../eCA/jsp/SpltyMasterCode.jsp?module_id=CA&function_id=SpecialityMasterCode&function_name=Speciality Master Code&function_type=F&access=YYNNN';
			}

			 if(val == 'SpecialityAssesmentTask'){
				parent.frames[1].location.href =																																					  '../../eCA/jsp/SpltyAssTask.jsp?module_id=CA&function_id=SpecialityAssesmentTask&function_name=Speciality Assesment Task&function_type=F&access=YYYYN';
			}

}
	
	
		/**/

/*

function openwinnowin(mID,funName,fileName,str)
{
	var W = 400 ;
	var H = 100 ;	

	r = ",resizable=1"
	s = ",width="+W+",height="+H;

	var windowW = W;
	var windowH = H;
	var windowX = Math.ceil( (window.screen.width  - windowW) / 2 );
	var windowY = Math.ceil( (window.screen.height - windowH) / 2 );
	
	splashWin = window.open('','HelpWindow','fullscreen=1,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=no'+r+s)

	splashWin.resizeTo( Math.ceil( W )       , Math.ceil( H ) )
	splashWin.moveTo  ( Math.ceil( windowX ) , Math.ceil( windowY ) )

	splashWin.document.open("text/html", "replace");
	splashWin.document.write(str);
	splashWin.document.help_form.submit();
	splashWin.document.close();
	splashWin.focus();
	eval("HelpWindow"+"=splashWin")
}

*/

	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	=await  window.showModalDialog('change_functionality.jsp',arguments,features);


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
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
 		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.LOCATIONACCESS.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityEvent')"><fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityOutcome')"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
		</tr>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpltyEventOutcome')"><fmt:message key="eCA.SpecialtyEventOutcome.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityTasks')"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="eCA.Tasks.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityTasksForEvents')"><fmt:message key="eCA.SpecialityTasksForEvents.label" bundle="${ca_labels}"/></td>
		</tr>  -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityEpisodeCycle')"><fmt:message key="eCA.SpecialityEpisodeCycle.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityMasterCode')"><fmt:message key="eCA.SpecialityMasterCode.label" bundle="${ca_labels}"/></td>
		</tr>


 	<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpecialityAssesmentTask')"><fmt:message key="eCA.SpecialityAssesmentTask.label" bundle="${ca_labels}"/></td>
		</tr> 
 -->

		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>


		<!-- <tr>
			<td class='ECMENUHIGHERLEVELCOLOR' onClick="showFunctionality()"><b>Functions</b></td>
		</tr>
 -->

	</table>

	</body>
	</form>
</html>

