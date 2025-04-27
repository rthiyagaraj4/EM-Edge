<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language='JavaScript' src='../../eCommon/js/common.js' ></script>
<script language='JavaScript' src='../../eCommon/js/MstCodeCommon.js' ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript"src='../js/SkillForPosition.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function changeColor(Obj){
if(Obj.name == 'position'){
Obj.className='IPCASELECTEDCOLOR';
document.getElementById("skill").className='IPCAHIGHERLEVELCOLOR'
}
else{
Obj.className='IPCASELECTEDCOLOR';
document.getElementById("position").className='IPCAHIGHERLEVELCOLOR'
}

}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<table border='0' cellpadding='0' cellspacing='0' align='left' width="50%">
<tr>
<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
<!-- <td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showPosition();changeColor(this);' align='left' name='position'  id='position'>By Position</td> -->


<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showPosition();changeColor(this);' align='left' name='position'  id='position'><fmt:message key="eRS.ByPosition.label" bundle="${rs_labels}"/></td>

<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showSkill();changeColor(this);' align='left' name='skill' id='skill'><fmt:message key="eRS.BySkill.label" bundle="${rs_labels}"/></td>
</tr>
</table>
</body>
</html>

