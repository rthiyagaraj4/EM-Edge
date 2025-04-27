<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eAE/js/ReleaseBay.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<iframe src="../../eCommon/html/blank.html" name="ReleaseBed_criteria" id="ReleaseBed_criteria"  frameborder=0 noresize scrolling=NO style="height:15vh;width:100vw"></iframe><iframe src="../../eCommon/html/blank.html" name="ReleaseBed_result" id="ReleaseBed_result" frameborder=0 noresize style="height:85vh;width:100vw"></iframe>
	
</html>

