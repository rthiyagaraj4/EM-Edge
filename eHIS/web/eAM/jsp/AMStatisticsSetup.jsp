<!DOCTYPE html>
<%--
	FileName	: AMStatisticsSetup.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
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
				//parent.parent.parent.parent.frames[1].expand();
		}

		function chcol(ro)
		{
				
				document.getElementById('t').rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if(val == 'StatisticsGroup')
				parent.frames[1].location.href = '../../eAM/jsp/StatisticsGroup.jsp?module_id=AM&function_id=STAT_GROUP&function_name=Statistics Group&function_type=F&access=YYYNN';
											
			if(val == 'StatGrpforProgram')
				parent.frames[1].location.href = '../../eAM/jsp/StatisticsGroupForProgram.jsp?module_id=AM&function_id=STAT_GROUP_PRG&function_name=Statistics Group For Program&function_type=F&access=YYYYN';

			if(val == 'StatGrpDetail')
				parent.frames[1].location.href = '../../eAM/jsp/StatGrpNationDetail.jsp?module_id=AM&function_id=STAT_GROUP_DTL&function_name=Statistics Group Detail&function_type=F&access=YYYNN';
		}

	</script>


	</head>

	<body style="background-color:dimgray;"  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<form name="AMStatisticsMenu_form" id="AMStatisticsMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StatisticsGroup');"><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/></td>
		</tr>

		 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StatGrpforProgram');"><fmt:message key="eAM.StatisticsGroupforProgram.label" bundle="${am_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StatGrpDetail');"><fmt:message key="eAM.StatisticsGroupDetail.label" bundle="${am_labels}"/></td>
		</tr>

		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style="color:white"><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

	</table>

	</body>
	</form>
</html>

