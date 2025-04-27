<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>



<html>
     <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		
		<script src='../js/ShiftForPosition.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function changeColor(Obj)
			{
			if(Obj.name == 'workplace')
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('shift').className='IPCAHIGHERLEVELCOLOR'
				}
				else
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('workplace').className='IPCAHIGHERLEVELCOLOR'
				}
				
			}
		</script>
		
	 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="50%">
	<tr>
		<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
		<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showPosition();changeColor(this);' align='left' name='workplace'  id='workplace'><fmt:message key="Common.ByPosition.label" bundle="${common_labels}"/></td>
		<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showShift();changeColor(this);' align='left' name='shift' id='shift'><fmt:message key="Common.ByShift.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
</body>
</html>

