<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="JavaScript" src='../js/ShiftForWorkplace.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function changeColor(Obj)
			{
			    if(Obj.name == 'workplace')
			    {
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("shift").className='IPCAHIGHERLEVELCOLOR'
			    }
			    else
			    {
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("workplace").className='IPCAHIGHERLEVELCOLOR'
				}				
			}
		</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<table border='0' cellpadding='0' cellspacing='0' align='left' width="50%">
<tr>
<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showWorkplace();changeColor(this);' align='left' name='workplace'  id='workplace'>&nbsp;<fmt:message key="eRS.ByWorkplace.label" bundle="${rs_labels}"/></td>
<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showShift();changeColor(this);' align='left' name='shift' id='shift'>&nbsp;<fmt:message key="eRS.ByShift.label" bundle="${rs_labels}"/></td>
</tr>
</table>
</body>
</html>

