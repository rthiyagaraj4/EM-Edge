<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>

<HTML>
<HEAD>
</HEAD>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
	<script language='javascript' src='../../eBL/js/MultiPkgDisc.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String params = request.getQueryString();
	String source = url + params;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='MultiPkgDiscCreate' id='MultiPkgDiscCreate'	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:87vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe>
	
</HTML>

