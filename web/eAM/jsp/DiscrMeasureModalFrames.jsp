<!DOCTYPE html>
<%--
	FileName	: DiscrMeasureModalFrames.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from")==null?"":request.getParameter("from");
        
		if(from.equals("A"))
		{
%>
		<title><fmt:message key="Common.AlphaInfo.label" bundle="${common_labels}"/></title>
		<iframe name='result' id='result'	src="../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="../../eAM/jsp/DiscrMeasureAlphaInfoAddModify.jsp?discr_measure=<%=request.getParameter("discr_measure")%>" frameborder=0 scrolling=auto style='height:55vh;width:100vw'></iframe>
<%
		}
		else
		{
%>
		<title><fmt:message key="eAM.NumericDetails.label" bundle="${am_labels}"/></title>
		<iframe name='result' id='result'	src="../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="../../eAM/jsp/DiscrMeasureNumericAddModify.jsp?discr_measure=<%=request.getParameter("discr_measure")%>&max_min_dec=<%=request.getParameter("max_min_dec")%>" frameborder=0 scrolling=auto style='height:50vh;width:100vw'></iframe>
<%
		}
%>
</html>

