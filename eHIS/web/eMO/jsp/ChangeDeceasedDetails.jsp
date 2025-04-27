<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script src='../../eMO/js/MOManageDeceased.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String parmeters = request.getQueryString() ;
	
	String source = url + parmeters ;
 	String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";

	%>
   
 
   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
   <iframe name='patientFrame' id='patientFrame' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?<%=parmeters%>&callfrom=callfrommoreg' frameborder=0 scrolling='no' noresize style='height:37vh;width:100vw'></iframe>
   <iframe name='MOFrame' id='MOFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
   <iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:35vh;width:100vw'></iframe>
   <iframe name='messageFrame' id='messageFrame' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
   <iframe name='dispfr' id='dispfr' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no'  style='height:6vh;width:100vw'>
	<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form style='height:5%;width:100vw'></iframe>


<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>


</html>

