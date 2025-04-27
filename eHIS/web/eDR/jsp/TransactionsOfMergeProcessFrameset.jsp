<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<HEAD>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</HEAD>
	<FRAMESET COLS="28,72">
		<FRAMESET ROWS='10,42,7,41'>
			<FRAME NAME='GROUP_TITLE1' FRAMEBORDER='0' SRC="../../eDR/jsp/TransactionsOfMergeProcessHeaderTitle1.jsp" scrolling='no' noresize>
			<FRAMESET COLS='92%,*'>
				<FRAME NAME='GROUP_HDR1' FRAMEBORDER='0'  SRC="../../eDR/jsp/TransactionsOfMergeProcessHeader1.jsp" scrolling='no' noresize>
				<FRAME NAME='GROUP_RECORD_IMAGE1' FRAMEBORDER='0'  SRC="../../eDR/jsp/TransactionsOfMergeProcessArrow1.jsp" scrolling='no' noresize>
			</FRAMESET>
			<FRAME NAME='GROUP_TITLE2' FRAMEBORDER='0' SRC="../../eDR/jsp/TransactionsOfMergeProcessHeaderTitle2.jsp" scrolling='no' noresize>
			<FRAMESET COLS='92%,*'>
				<FRAME NAME='GROUP_HDR2' FRAMEBORDER='0'  SRC="../../eDR/jsp/TransactionsOfMergeProcessHeader2.jsp" scrolling='no' noresize>
				<FRAME NAME='GROUP_RECORD_IMAGE2' FRAMEBORDER='0'  SRC="../../eDR/jsp/TransactionsOfMergeProcessArrow2.jsp" scrolling='no' noresize>
			</FRAMESET>
		</FRAMESET>
		<FRAMESET ROWS="14%,14%,*">
			<FRAME NAME='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/TransactionsOfMergeProcessSearch.jsp'>
			<FRAME NAME='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/TransactionsOfMergeProcessDetailsTitle.jsp'>
			<FRAME NAME='GROUP_DTLS' FRAMEBORDER='0' SRC=""><I></I>
		</FRAMESET>
	</FRAMESET>
</html>


