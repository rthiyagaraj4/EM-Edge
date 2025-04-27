<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
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
					Access flags are in the following order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if (val=='OtherStaffType'){
				parent.frames[1].location.href='OtherStaffType.jsp?module_id=AM&function_id=DurationType&function_name='+encodeURIComponent(getLabel("Common.OtherStaffType.label","Common"))+'&function_type=f&access=YYYNN';
			}
			if (val=='OtherStaff'){
				parent.frames[1].location.href='OtherStaff.jsp?module_id=AM&function_id=ShiftForLocnType&function_name='+encodeURIComponent(getLabel("Common.OtherStaff.label","Common"))+'&function_type=f&access=YYYNN';
			}
			if (val=='OtherStaffForFacility'){
				parent.frames[1].location.href='OtherStaffForFacility.jsp?module_id=AM&function_id=OtherStaffForFacility&function_name='+encodeURIComponent(getLabel("eAM.OtherStaffForFacility.label","am"))+'&function_type=f&access=YYYNN';
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
		
		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body style="background-color:dimgray;" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OtherStaffType')"><fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OtherStaff')"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OtherStaffForFacility')"><fmt:message key="eAM.OtherStaffForFacility.label" bundle="${am_labels}"/></td>
		</tr>

		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>


	</table>

	</body>
	</form>
</html>

