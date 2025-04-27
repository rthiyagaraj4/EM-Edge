<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	 request.setCharacterEncoding("UTF-8");
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MOExportDeceased.js'></script>
	<script language='javascript' src='../../eMO/js/MORegDetailsQuery.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?function_id=<%=function_id%>&callfrom=ExpoOfDeceased' scrolling='no' frameborder=0 style='height:30vh;width:99vw'></iframe>
<iframe name='MOFrame' id='MOFrame' src='../../eMO/jsp/MOManagePatTabs.jsp?function_id=<%=function_id%>' frameborder=0 noresize scrolling='no' style='height:3vh;width:100vw'></iframe>
<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:47vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
<iframe name='dispfr' id='dispfr' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:5%;width:100vw'></iframe>
<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>

