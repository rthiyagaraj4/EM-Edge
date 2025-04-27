<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function closew()
  {
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
	  //window.parent.close();
  }
</script>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='3' cellspacing='0'>
			<tr>
			    <td colspan ='4' align ='right' >
					<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>
</body>
</html>


