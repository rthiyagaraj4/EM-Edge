<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
     request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function closew()
  {
	   const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();   
  }
</script>

<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='3' cellspacing='0' align='right'>
			<tr >
			    <td colspan =4 align ='right'>
					<input type='button' class = button  name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()'>
				</td>
			</tr>
</table>
</div>
</body>
</html>


