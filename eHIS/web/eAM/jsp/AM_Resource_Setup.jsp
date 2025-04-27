<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>

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
			if(val == 'EquipmentOtherResourceTypes')
				parent.frames[1].location.href = '../../eAM/jsp/EquipmentOtherResourceTypes.jsp?module_id=AM&function_id=EquipmentOtherResourceTypes&function_name='+encodeURIComponent(getLabel("eAM.EquipmentOtherResourceTypes.label","am"))+'&function_type=F&access=YYYNN';	

			if(val == 'EquipmentOtherResource')
				parent.frames[1].location.href = '../../eAM/jsp/EquipmentOtherResource.jsp?module_id=AM&function_id=EquipmentOtherResource&function_name='+encodeURIComponent(getLabel("eAM.EquipmentOtherResource.label","am"))+'&function_type=F&access=YYYNN';	
		}
	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
                                    
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EquipmentOtherResourceTypes');"><fmt:message key="eAM.EquipmentOtherResourceTypes.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EquipmentOtherResource');"><fmt:message key="eAM.EquipmentOtherResource.label" bundle="${am_labels}"/></td>
		</tr>

		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style="color:white"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		
	</table>

	</body>
	</form>
</html>

