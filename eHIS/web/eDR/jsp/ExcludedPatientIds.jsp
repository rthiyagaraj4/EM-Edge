<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
<title><fmt:message key="eDR.ExcludePossibleDuplicates.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/QueryExcludePossibleDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script  language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <script>
		function reset()
		{ 
			   frames[1].location.href="../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp";
			// frames[1].document.getElementById('patient_id').value = "";
			// frames[1].document.getElementById("PatDetID").innerHTML   = "";
			 frames[2].document.location.href ='../../eCommon/html/blank.html';
		}
	</script>
</head>

<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString() ;
	String source	= url + params ;
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling='no' noresize style='height:9vh;width:100vw;border:none;'></iframe>
		<iframe name='pat_search' id='pat_search'         src='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp'  scrolling='auto' noresize style='height:15vh;width:100vw;border:none;'></iframe>
		<iframe name='dup_display' id='dup_display'        src='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:66vh;width:100vw;border:none;'></iframe>
		<iframe name='messageFrame' id='messageFrame'       src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:10vh;width:100vw;border:none;'></iframe>
	
</html>

