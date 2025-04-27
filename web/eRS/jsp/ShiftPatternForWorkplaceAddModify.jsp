<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language='javascript' src='../../eRS/js/ShiftPatternForWorkplace.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>
		function changeColor(Obj)
		{
		if(Obj.name == 'workplace')	{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("shiftPattern").className='IPCAHIGHERLEVELCOLOR'
				}
				else{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById("workplace").className='IPCAHIGHERLEVELCOLOR'
				}
				
		}
</script>
</head>
<body>	
<table border='0' cellpadding='0' cellspacing='0' align='left' width="50%">
<tr>
<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:getWorkplace();changeColor(this);' align='left' name='workplace'  id='workplace'><fmt:message key="eRS.ByWorkplace.label" bundle="${rs_labels}"/></td>
<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:getShiftPattern();changeColor(this);' align='left' name='shiftPattern' id='shiftPattern'><fmt:message key="eRS.ByShiftPattern.label" bundle="${rs_labels}"/></td>
</tr>
</table>
</body>
</html>

