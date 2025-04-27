<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<script>
function closew()
  {
	  window.parent.close();
  }
</script>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td >
					<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>
</body>
</html>

