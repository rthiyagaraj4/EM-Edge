<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<frameset rows='12%,*,8%,0%' frameborder=0>
	<frame name='signRepCriteriaFrame' src='../../eCA/jsp/VerifySignReportsCriteria.jsp' scrolling='no'></frame>
	<frameset cols='25%,*'>
		<frame name='signRepTreeFrame' src='../../eCommon/html/blank.html' scrolling='auto'></frame>
		<frame name='signRepDetailsFrame' src='../../eCommon/html/blank.html' scrolling='auto'></frame>
	</frameset>
	<frame name='signRepButtonFrame' src='../../eCA/jsp/VerifySignReportsButton.jsp' scrolling='no'></frame>
	<frame name='signRepIntermediateFrame' src='../../eCommon/html/blank.html' scrolling='no'></frame>
</frameset>
