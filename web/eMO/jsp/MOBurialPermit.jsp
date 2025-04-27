<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eMO/js/MOBurialPermit.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID");	
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> 
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMO/jsp/MOBurialPermitCriteria.jsp?function_id=<%=function_id%>&patient_id=<%=patientID%>' frameborder=0 scrolling='no' noresize style='height:90%;width:100vw'></iframe>
	<iframe name='patientLine' id='patientLine' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:7%;width:100vw'></iframe><iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:35%;width:100vw'></iframe>


</html>

