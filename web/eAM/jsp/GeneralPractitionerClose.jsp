<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<script>
function closew()
  {
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close(); 
	 // window.parent.parent.returnValue=null;
	 // window.parent.close();
  }
</script>
 
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td >
					<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>
' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>
</body>
</html>


