<!DOCTYPE html>
<%--
	FileName	: AM_Oper_Setup.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
			
			if(val == 'OperatorStation')
				parent.frames[1].location.href = '../../eAM/jsp/OperatorStation.jsp?module_id=AM&function_id=OPERATOR_STATION&function_name='+encodeURIComponent(getLabel("Common.operatorstation.label","Common"))+'&function_type=F&access=YYYYN';
			if(val == 'UserforOperatorStation')
				parent.frames[1].location.href = '../../eAM/jsp/UserForOperatorStation.jsp?module_id=AM&function_id=USER_OPERATOR_STATION&function_name='+encodeURIComponent(getLabel("eAM.UserforOperatorStation.label","am"))+'&function_type=F&access=YYYYN';
			if(val == 'LocationforOperatorStation')
			
				parent.frames[1].location.href = '../../eAM/jsp/md_LocnForOperatorStation.jsp?module_id=AM&function_id=LOCN_OPERATOR_STATION&function_name='+encodeURIComponent(getLabel("eAM.LocationforOperatorStation.label","am"))+'&function_type=F&access=YYYNN';
			if(val == 'OperatorStationRstrn')
				parent.frames[1].location.href = '../../eAM/jsp/OperatorStationRstrn.jsp?module_id=AM&function_id=OPERATOR_STATION_RESTRN&function_name='+encodeURIComponent(getLabel("eAM.OperatorStationRestriction.label","am"))+'&function_type=F&access=YYYYN';
					
				
		}

	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;"  onKeyDown = 'lockKey()'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperatorStation');"><fmt:message key="Common.operatorstation.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UserforOperatorStation');"><fmt:message key="eAM.UserforOperatorStation.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LocationforOperatorStation');"><fmt:message key="eAM.LocationforOperatorStation.label" bundle="${am_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperatorStationRstrn');"><fmt:message key="eAM.OperatorStationRestriction.label" bundle="${am_labels}"/></td>
		</tr>
		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr>
		
	</table>

	</body>
	</form>
</html>

