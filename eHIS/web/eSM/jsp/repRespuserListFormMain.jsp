<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/codeCheck.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 function respuser(obj)
 {
 var resp_user=obj.value;

 if (resp_user !="S")
	 parent.frames[2].document.location.href='../../eSM/jsp/repRespUserListForm.jsp?resp_user='+resp_user
 else 
    parent.frames[2].document.location.href='../../eCommon/html/blank.html';
 }
</script>
</head>
<body  OnMouseDown="CodeArrest()" onLoad=" FocusFirstElement()" ;onKeyDown = 'lockKey()';  >
<form name="menu_form" id="menu_form"  method="post" target="messageFrame">
<div>
  <table border="0" cellpadding="0" cellspacing="0" width="auto" align='center'>

     <tr>     
      <td  class="label"> </td>
      <td></td>
     </tr>

      <tr>
       <br><br>
	  <td width='10%'>&nbsp;</td>
      <td class="label"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
      <td class='fields'>&nbsp;<select name="code" id="code" onChange="respuser(this)">
	<option value='S' selected>&nbsp;------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- -------&nbsp;
	<option value='U'> <fmt:message key="Common.user.label" bundle="${common_labels}"/>
	<option value='R'> <fmt:message key="Common.responsibility.label" bundle="${common_labels}"/>
    </select></td>
    <td width='10%'>&nbsp;</td>
    </tr>
    </table>
</div>
</form>
</body>
</html>

