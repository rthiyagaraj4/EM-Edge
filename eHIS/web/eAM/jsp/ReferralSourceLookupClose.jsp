<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* "  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");	
	
%>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body>

<form>

<script>
function closew()
  {
	
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   
	  //window.parent.close();
  }
</script>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td >
					<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>
</form>

</body>
</html>

