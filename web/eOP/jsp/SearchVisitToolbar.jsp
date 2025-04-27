<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script>
function closew()
  {
parent.window.close();
 document.location.href="../../eCommon/jsp/dmenu.jsp";
//parent.history.go(-1);
}
</script>

<body onKeyDown ='lockKey()'>

<div align='right'>
<table  cellpadding='0' cellspacing='0'  width='100%' align='center'>
			<tr>
			    <td  class='COMMON_TOOLBAR' align ='left'  ><input type='button' name='Home' id='Home' value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' onClick='closew()'  class='button'></td>

					<!-- <td  class='COMMONTOOLBAR' align='right'><input type='button' name='Print' id='Print' value='Print'  onclick="parent.print();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" class='button'><input type='button' name='Help' id='Help' value='Help' onClick="alert('Help is under construction')" class='button'></td> -->

			</tr>
</table>
</div>
</body>
</html>


