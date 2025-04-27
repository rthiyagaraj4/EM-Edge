<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
	<title><fmt:message key="Common.Testing.label" bundle="${common_labels}"/></title>
	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	</script>
</head>
	<%
	request.setCharacterEncoding("UTF-8");
	String comp_id = request.getParameter("comp_id");
	%>
<body onload='instantiateEditor();' class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='compDefinitionForm' id='compDefinitionForm' method='post' action='../../eAM/jsp/DiscrMsrCompParagraphPreview.jsp' target=previewFrame>
<table width=100%>
<tr>
	<td><iframe id="compDefinition" name="compDefinition" width="100%" height="80%" onKeyPress='callOnChange()'></iframe></td>
	<!--<td  nowrap>&nbsp;   <textarea name="compDefinition" cols=85 rows=7  value="" onblur='' onKeyPress='callOnChange()' ></textarea> </td>-->
</tr>
<tr>
	<td colspan=3 align=right>
	<input type="button" value="Save" class="button" onClick="callOnSave()" name='save' id='save' >
	<input type="button" value="Add Component" class="button" onClick="callComponent()" name='search' id='search' >&nbsp;&nbsp;<input type="submit" value="Preview" class="button"  name='preview' id='preview' onclick='callForPreview();' ></td>
</tr>
</table>
	<!--<input type=hidden name=paragraphDef value="">-->
	<textarea name="paragraphDef"  id="paragraphDef" style="visibility:hidden">
	</textarea>
	<input type='hidden' name="calledFrom" id="calledFrom" value="">
	<input type='hidden' name='comp_id'  id='comp_id'  value="<%=comp_id%>">
</form>
</body>
</html>

