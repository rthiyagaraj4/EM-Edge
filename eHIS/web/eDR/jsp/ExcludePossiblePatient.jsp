<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head><title><fmt:message key="eDR.ExcludePossibleDuplicates.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/ExcludePossibleDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:9vh;width:100vw' frameborder='0'></iframe>
		<iframe name='excludeDuplicatePatients' id='excludeDuplicatePatients' src='../../eCommon/html/blank.html'  scrolling='no' noresize style='height:81vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:10vh;width:100vw;border:none'></iframe>
	
</html>

