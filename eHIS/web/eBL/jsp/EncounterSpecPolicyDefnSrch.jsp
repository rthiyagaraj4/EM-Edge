<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K          created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<%
  	String sStyle	=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../../eBL/js/EncounterSpecPolicyDefnSrch.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;
	session.setAttribute("succesfully_logged_in_user",null);
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='PolicyDefinitionMainFrame' id='PolicyDefinitionMainFrame' 	src='../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp' frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

