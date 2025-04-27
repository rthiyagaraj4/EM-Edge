<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
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
			
         
			if(val == 'CareLocationType')
				parent.frames[1].location.href = '../../eAM/jsp/Carelocationtype.jsp?module_id=AM&function_id=CARE_LOCATION_TYPE&function_name='+encodeURIComponent(getLabel("eAM.CareLocationType.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'BuilidinginFacility')
				parent.frames[1].location.href = '../../eAM/jsp/Buildinginfacility.jsp?module_id=AM&function_id=BUIDLING_IN_FACILITY&function_name='+encodeURIComponent(getLabel("eAM.BuildinginFacility.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'FloorinFacility')
				parent.frames[1].location.href = '../../eAM/jsp/FloorinFacility.jsp?module_id=AM&function_id=FLOOR_IN_FACILITY&function_name='+encodeURIComponent(getLabel("eAM.FloorinFacility.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'Room')
				parent.frames[1].location.href = '../../eAM/jsp/Room.jsp?module_id=AM&function_id=ROOM&function_name='+encodeURIComponent(getLabel("Common.room.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'DepartmentforRoom')
				parent.frames[1].location.href = '../../eAM/jsp/DepartmentforRoom.jsp?module_id=AM&function_id=DEPARTMENTS_FOR_ROOM&function_name='+encodeURIComponent(getLabel("eAM.AcctDeptforRoom.label","am"))+'&function_type=F&access=YYYNN';

		}

	</script>

	</head>

	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' style="background-color:dimgray;" >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CareLocationType');"><fmt:message key="eAM.CareLocationType.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BuilidinginFacility');"><fmt:message key="eAM.BuildinginFacility.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FloorinFacility');"><fmt:message key="eAM.FloorinFacility.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Room');"><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DepartmentforRoom');"><fmt:message key="eAM.AcctDeptforRoom.label" bundle="${am_labels}"/></td>
		</tr>

		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		
	</table>

	</body>
	</form>
</html>

