<!DOCTYPE html>
<html>
<head>
<%@ page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function funcchange(obj)
{

	var objname = obj.name;
	if(objname=="User")
	{
		parent.frames[1].location.href="../../eSM/jsp/ResponsibilityforUser_Form.jsp?objectname="+objname;
		parent.frames[2].location.href='../../eCommon/html/blank.html';
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp'
	}
	if(objname=="Resp")
	{
		parent.frames[1].location.href="../../eSM/jsp/ResponsibilityforUser_Form.jsp?objectname="+objname;
		parent.frames[2].location.href='../../eCommon/html/blank.html';
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp'	
	}
}	
</script>
</head>
<body  onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()";>
<form name='respForUser_Button' id='respForUser_Button'>
&nbsp;<INPUT TYPE="button" class='BUTTON' name="User" id="User" value='<fmt:message key="Common.ByUser.label" bundle="${common_labels}"/>' onclick="funcchange(this)">&nbsp;<INPUT TYPE="button" class='BUTTON' name="Resp" id="Resp" value='<fmt:message key="eSM.ByResponsibility.label" bundle="${sm_labels}"/>' onclick="funcchange(this)">
</form>
</body>
</html>

