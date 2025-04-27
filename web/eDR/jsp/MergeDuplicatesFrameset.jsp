<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
</head>

	<FRAMESET COLS="28,72">
		<FRAMESET ROWS='11%,*'>
			<FRAME NAME='GROUP_TITLE' FRAMEBORDER='0' SRC="../../eDR/jsp/MergeDuplicateHeaderTitle.jsp" scrolling='no' noresize>
			<FRAMESET COLS='92%,*'>
			<FRAME NAME='GROUP_HDR' FRAMEBORDER='0' SRC="../../eDR/jsp/MergeDuplicateHeader.jsp" scrolling='no' noresize>
			<FRAME NAME='GROUP_RECORD_IMAGE' FRAMEBORDER='0' SRC="../../eDR/jsp/MergeDuplicateArrow.jsp" scrolling='no' noresize>
		</FRAMESET>
		</FRAMESET>
		<FRAMESET ROWS="15%,15%,*">
			<FRAME NAME='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/MergeDuplicateSearch.jsp' noresize>
			<FRAME NAME='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/MergeDuplicateDetailsTitle.jsp' scrolling='auto' noresize>
			<FRAME NAME='GROUP_DTLS' FRAMEBORDER='0' SRC="../../eDR/jsp/MergeDuplicateDetails.jsp" scrolling='auto' noresize>
		</FRAMESET>
	</FRAMESET>
</html>
