<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eMR/js/RecDiagnosisEOC.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

 <body onKeyDown='lockKey()'>
		<form name='RecDiagAddModifyForm' id='RecDiagAddModifyForm' >
		<table border=0 align='center' cellspacing=0 cellpadding=0 width='100%'>
		
		<tr><td width='10%'>&nbsp;&nbsp;&nbsp;</td>
		<td class='button'><input type='button' class='button' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick='form_submit()'>
		<input type='Button' name='clear' id='clear' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%> ' class="button" onclick='clearform()'>
		</td>
			
		</tr>
	</table>	
	</form>
	</body>
</html>
		

