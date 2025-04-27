<!DOCTYPE html>
<!--
page created by rajesh varadharajan 28-Feb-2013
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<HTML>

<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String source = url + params ;

%>
		        <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style="height:8vh;width:100vw"></iframe>
			<iframe name='PolicyDefinitionMainFrame' id='PolicyDefinitionMainFrame' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style="height:83vh;width:100vw"></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style="height:9vh;width:100vw"></iframe>
		
	<script>   
	</script>
</HTML> 

