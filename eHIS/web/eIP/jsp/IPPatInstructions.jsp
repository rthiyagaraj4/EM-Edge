<!DOCTYPE html>
<%--
FileName		: IPPatInstructions.jsp Included for the CRF - RUT-CRF-013 23396

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eIP/js/IPPatInstructions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="pat_instructions_add_mod" id="pat_instructions_add_mod" src = "../../eIP/jsp/IPPatInstructionsAddModify.jsp" marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize style='height:35%;width:100vw'></iframe>
	<iframe name="pat_instructions_result" id="pat_instructions_result" src = "../../eIP/jsp/IPPatInstructionsResult.jsp?mode=update" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize  style='height:80vh;width:100vw'></iframe>
</html>

