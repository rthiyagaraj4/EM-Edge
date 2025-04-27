<!DOCTYPE html>
<%@ page import ="eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function onSuccess()
	{
	alert(getMessage('RECORD_MODIFIED','SM'));
	window.close();
	}
	</script>
<title><fmt:message key="eMP.LinkRelatedFamilyMembers.label" bundle="${mp_labels}"/></title>
</head>

<%
		String params = request.getQueryString() ;
%>

<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eMP/jsp/RelatedFamilyMembers.jsp?<%=params%>' frameborder=0 style='height:75vh;width:100vw'></iframe>
<iframe name='buttonfrm' id='buttonfrm' 	src='../../eMP/jsp/RelatedFamilyMemberButton.jsp' frameborder=0 style='height:15vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

</html>

