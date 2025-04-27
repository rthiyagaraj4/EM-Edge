<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../js/ResultTemplate.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		/*var temparr = new Array();
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
				if(val == 'ResultTemplate')
					parent.frames[1].location.href = '../../eAM/jsp/ResultTemplate.jsp?module_id=AM&function_id=RESULT_TEMPLATE&function_name=Result Template&function_type=F&access=YYYNN';
				if(val == 'DiscreteMeasure')
					parent.frames[1].location.href = '../../eAM/jsp/DiscrMeasure.jsp?module_id=AM&function_id=DISCRETE_MEASURE&function_name=Discrete Measure&function_type=F&access=YYYNN';
				if(val == 'DiscreteMeasurePanel')
					parent.frames[1].location.href = '../../eAM/jsp/DiscrMeasurePanel.jsp?module_id=AM&function_id=DISCRETE_MEASURE_PANEL&function_name=Discrete Measure Panel&function_type=F&access=YYNYN';
		}*/
	</script>

	</head>

	<body onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' style="background-color:dimgray;" >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ResultTemplate')"><fmt:message key="Common.ResultTemplate.label" bundle="${common_labels}"/></td>
		</tr>

		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiscreteMeasure');">Discrete Measure</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiscreteMeasurePanel');">Discrete Measure Panel</td>
		</tr> -->
		<!--10/11/2008<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NewDiscreteMeasure');"><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></td>
		</tr>-->

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiscreteMeasure');"><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiscreteMeasurePanel');"><fmt:message key="Common.DiscreteMeasurePanel.label" bundle="${common_labels}"/></td>
		</tr>
 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href="javascript:goHomePage()" style="color:white"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr> 
		

	</table>

	</body>
	</form>
</html>


