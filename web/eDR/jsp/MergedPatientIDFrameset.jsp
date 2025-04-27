<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<FRAMESET COLS="28%,72%">
		<FRAMESET ROWS='11%,*'>
			<FRAME NAME='GROUP_TITLE' FRAMEBORDER='0' SRC="../../eDR/jsp/MergedPatientIDHeaderTitle.jsp" scrolling='no' noresize>
			<FRAMESET COLS='92%,*'>
				<FRAME NAME='GROUP_HDR' FRAMEBORDER='0'  SRC="../../eDR/jsp/MergedPatientIDHeader.jsp" scrolling='no' noresize>
				<FRAME NAME='GROUP_RECORD_IMAGE' FRAMEBORDER='0'  SRC="../../eDR/jsp/MergedPatientIDArrow.jsp" scrolling='no' noresize>
			</FRAMESET>
		</FRAMESET>
		<FRAMESET ROWS="17%,9%,*">
			<FRAME NAME='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/MergedPatientIDSearch.jsp' noresize>
			<FRAME NAME='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/MergedPatientIDDetailsTitle.jsp' scrolling='auto'>
			<FRAME NAME='GROUP_DTLS' FRAMEBORDER='0'  SRC="" noresize>
		</FRAMESET>
	</FRAMESET>
</html>
