<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  
String function_id = request.getParameter("function_id");
String oper = request.getParameter("oper");
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eOP/js/ResourceForLocnByPract.js'></script>
		<script>
			function changeColor(Obj)
			{
			if(Obj.name == 'locn')
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('pract').className='IPCAHIGHERLEVELCOLOR'
				}
				else
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('locn').className='IPCAHIGHERLEVELCOLOR'
				}
			}
		</script>
		
	</head>
		<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			<table border='0' cellspacing='0' cellpadding='0' width='50%' align='left'>
				<tr align='center'> 
					<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
					<td class='IPCAHIGHERLEVELCOLOR'  onClick='selectFunction(this, "<%=oper %>");changeColor(this);' name='locn'  id='locn'> <fmt:message key="Common.bylocation.label" bundle="${common_labels}"/></td>
					<td class='IPCAHIGHERLEVELCOLOR'  onClick='selectFunction(this, "<%=oper %>");changeColor(this);'  name ='pract' id='pract'><fmt:message key="eIP.ByPractitioner.label" bundle="${ip_labels}"/></td>
				</tr>
			</table>
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

