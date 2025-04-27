<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
  <FRAMESET COLS="28,72">
	<FRAMESET ROWS='60,*'>
		<FRAME NAME='GROUP_TITLE' FRAMEBORDER=0 SRC="../../eDR/jsp/PossibleDuplicateHeaderTitle.jsp" scrolling=no noresize>
			<FRAMESET COLS='92%,*'>
				<FRAME NAME='GROUP_HDR' FRAMEBORDER=0  SRC="../../eDR/jsp/PossibleDuplicateHeader.jsp" scrolling=no noresize>
				<FRAME NAME='GROUP_RECORD_IMAGE' FRAMEBORDER=0  SRC="../../eDR/jsp/PossibleDuplicateArrow.jsp" scrolling=no noresize>
			</FRAMESET>
    </FRAMESET>
    <FRAMESET ROWS="14%,14%,*">
				<FRAME NAME='SEARCH_SCREEN' FRAMEBORDER=0 SRC='../../eDR/jsp/PossibleDuplicateSearch.jsp' noresize>
				<FRAME NAME='GROUP_DTLS_TITLE' FRAMEBORDER=0  SRC='../../eDR/jsp/PossibleDuplicateDetailsTitle.jsp' noresize>
				<FRAME NAME='GROUP_DTLS' FRAMEBORDER=0  SRC="" noresize>
    </FRAMESET>
 </FRAMESET>
 
 
</html>



 
