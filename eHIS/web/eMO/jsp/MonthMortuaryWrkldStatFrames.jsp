<!DOCTYPE html>
<!--Created by Ashwini on 27-Oct-2017 for ML-MMOH-CRF-0790-->
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
<script src="../../eMO/js/MonthMortuaryWrkldStat.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String function_id = request.getParameter("function_id");
%>
<frameset rows='42,40,*,40'>
	<frame name='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize>
	<frame scrolling="no" name='monthMortuaryWrkldStatFrame' src='../../eMO/jsp/MonthMortuaryWrkldStat.jsp?function_id=<%=function_id%>' frameborder=0 noresize>
	<frame scrolling="no"  src='../../eCommon/html/blank.html'  frameborder=0  noresize>
	<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>

