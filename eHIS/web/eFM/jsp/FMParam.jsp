<!DOCTYPE html>
<!--
	Created On	: 6/8/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: FM Parameter	
-->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eFM.FMParameter.label" bundle="${fm_labels}"/> </title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eFM/js/FMParam.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
 	<script language='javascript' src='../../eFM/js/FMParam.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	try
	{
		String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params	= request.getQueryString();
		String source	= url + params;	
		%>
		 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
			 <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eFM/jsp/FMParamAddModify.jsp' frameborder=0 scrolling='auto' style='height:83vh;width:100vw'></iframe>
			 <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
		 
		<%
	}catch(Exception e){out.println(e);}
%>
</html>

