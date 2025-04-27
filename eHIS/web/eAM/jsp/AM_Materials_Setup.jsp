<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
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
			
			if(val == 'UnitofMeasure')
			parent.frames[1].location.href = '../../eAM/jsp/UnitofMeasure.jsp?module_id=AM&function_id=UOM&function_name='+encodeURIComponent(getLabel("Common.UnitofMeasure.label","common"))+'&function_type=F&access=YYYNN';
			
			if(val == 'EquivalentDosageUnitofMeasure')
				parent.frames[1].location.href = '../../eAM/jsp/EquivalentUOM.jsp?module_id=AM&function_id=EQL_DOSE_UOM&function_name='+encodeURIComponent(getLabel("eAM.EquivalentUnitofMeasure.label","am"))+'&function_type=F&access=YYYYN';
			if(val == 'Manufacturer')
				parent.frames[1].location.href = '../../eAM/jsp/Manufacturer.jsp?module_id=AM&function_id=MANUFACTURER&function_name='+encodeURIComponent(getLabel("Common.Manufacturer.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'TradeName')
				parent.frames[1].location.href = '../../eAM/jsp/TradeName.jsp?module_id=AM&function_id=TRADE&function_name='+encodeURIComponent(getLabel("Common.TradeName.label","common"))+'&function_type=F&access=YYYNN';
			
			
		}
	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
	
		 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UnitofMeasure')"><fmt:message key="Common.UnitofMeasure.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR'onClick="javascript:callJSPs('EquivalentDosageUnitofMeasure')" ><fmt:message key="eAM.EquivalentUnitofMeasure.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Manufacturer')"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TradeName')"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
		</tr>
		<tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style="color:#FFFFFF"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr>
		

		
	</table>
	</body>
	</form>
</html>

