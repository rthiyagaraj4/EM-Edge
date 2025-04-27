<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../js/NursUnitPract.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
 		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<script>
			function changeColor(Obj)
			{
			if(Obj.name == 'nurs')
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("pract").className='IPCAHIGHERLEVELCOLOR'
				}
				else
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("nurs").className='IPCAHIGHERLEVELCOLOR'
				}
			}
		</script>
		
	</head>
		<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			<form name='' id='' action='' method>
				<table border='0' cellspacing='0' cellpadding='0' width='50%' align='left'>
					<tr align=''> 
						<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td><td class='IPCAHIGHERLEVELCOLOR'  onClick='selectFunction(this);changeColor(this);' name='nurs'  id='nurs'> <fmt:message key="eIP.ByNursingUnit.label" bundle="${ip_labels}"/></td><td class='IPCAHIGHERLEVELCOLOR'  onClick='selectFunction(this);changeColor(this);'  name ='pract' id='pract'><fmt:message key="eIP.ByPractitioner.label" bundle="${ip_labels}"/></td>
					</tr>
				</table>
			</form>
	</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

