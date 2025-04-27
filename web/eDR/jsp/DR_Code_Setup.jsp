<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script  language='javascript' src='../../eCommon/js/common.js'></script>

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		var temparr			= new Array();
		var count			= 0;
		var prev			= 0;
		var prevcol			= 'MENUSUBLEVELCOLOR';
		var sec_hdg_cd		= new Array();
		var logic_seq_no	= new Array();

		function goHomePage()
		{
			parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
			document.getElementById("t").rows(prev).cells(0).className = prevcol;
			prevcol					= ro.cells(0).className;
			ro.cells(0).className	= "MENUSELECTEDCOLOR";
			prev					= ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess*/

			if(val == 'DRParameter')
				parent.frames[1].location.href = '../../eDR/jsp/DRParam.jsp?module_id=MP&function_id=DR_PARAM&function_name='+encodeURIComponent(getLabel("eDR.DRParameter.label","DR"))+'&function_type=F&access=NYNNN';
			if(val == 'UserRights')
				parent.frames[1].location.href = '../../eDR/jsp/DRUserRights.jsp?module_id=MP&function_id=DR_USER_RIGHTS&function_name='+encodeURIComponent(getLabel("eDR.UserRights.label","DR"))+'&function_type=F&access=YYYNN';
		}
	</script>
</head>
	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
		<form name="MPMasterMenu_form" id="MPMasterMenu_form">
			<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
				<tr onclick='chcol(this)'>
					<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DRParameter')"><fmt:message key="eDR.DRParameter.label" bundle="${dr_labels}"/></td>
				</tr>
				<tr onclick='chcol(this)'>
					<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UserRights')"><fmt:message key="eDR.UserRights.label" bundle="${dr_labels}"/></td>
				</tr>
				<tr>
					<td class='MENUHIGHERLEVELCOLOR'>
					<a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
				</tr>
			</table>
		</form>
	</body>
</html>

