<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>



<BODY class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	session.removeAttribute("chartEvents"+encounterId);
	session.removeAttribute("chartGrp"+encounterId);
	//session.removeAttribute("finalHash");
	//session.removeAttribute("dates");	
%>
</BODY>
<script>
	if(top.content!=null){
		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}else{
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
</script>
</HTML>


