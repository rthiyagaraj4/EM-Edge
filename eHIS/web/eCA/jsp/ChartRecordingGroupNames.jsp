<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.GroupNames.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='chartRecordingGrpNamesForm' id='chartRecordingGrpNamesForm'>
			<table cellpadding='3' cellspacing='0' border='1' width='100%'>
				<tr>	
					<td>
						<input type='radio' name='groups' id='groups' value='G1' class='label' onclick='loadDetailsPage()'><fmt:message key="Common.Group.label" bundle="${common_labels}"/> 1
						<input type='radio' name='groups' id='groups' value='G2' class='label' onclick='loadDetailsPage()'><fmt:message key="Common.Group.label" bundle="${common_labels}"/> 2
						<input type='radio' name='groups' id='groups' value='G3' class='label' onclick='loadDetailsPage()'><fmt:message key="Common.Group.label" bundle="${common_labels}"/> 3
					</td>
				</tr>
			</table>
			<input type='hidden' name='grpValueHidden' id='grpValueHidden' value=''>
		</form>
	</body>
</html>

