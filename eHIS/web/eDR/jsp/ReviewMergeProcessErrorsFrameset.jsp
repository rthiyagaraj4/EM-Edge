<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eDR/js/ReviewMergeProcessErrors.js'></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
</HEAD>
	<FRAMESET COLS="28,72">
		<FRAMESET ROWS='60,*'>
			<FRAME NAME='GROUP_TITLE'  FRAMEBORDER='0' SRC="../../eDR/jsp/ReviewMergeProcessErrorsHeaderTitle.jsp" scrolling='no' noresize>
				<FRAMESET COLS='92%,*'>
					<FRAME NAME='GROUP_HDR' FRAMEBORDER='0'  SRC="../../eDR/jsp/ReviewMergeProcessErrorsHeader.jsp" scrolling='no' noresize>
					<FRAME NAME='GROUP_RECORD_IMAGE' FRAMEBORDER='0'  	SRC="../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp" scrolling='no' noresize>
				</FRAMESET>
			</FRAMESET>
		<FRAMESET ROWS="14%,14%,*">
			<FRAME NAME='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/ReviewMergeProcessErrorsSearch.jsp'>
			<FRAME NAME='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/ReviewMergeProcessErrorsDetailsTitle.jsp'>
			<FRAME NAME='GROUP_DTLS' FRAMEBORDER='0' SRC="">
		</FRAMESET>
	</FRAMESET>
</HTML>


