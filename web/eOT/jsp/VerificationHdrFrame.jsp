<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>            
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts 
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<%
	String chk_sequence = checkForNull(request.getParameter("chk_sequence"));
	String room_code=checkForNull(request.getParameter("room_code"));
	String waitlistkey=checkForNull(request.getParameter("waitlistkey"));
	String  param = "chk_sequence="+chk_sequence+"&room_code="+room_code+"&waitlistkey="+waitlistkey;
%>           

<FRAMESET ROWS="100%" >
 	<!-- <FRAME  NAME="f_query_add_mod"  frameborder="0" scrolling="auto" noresize SRC="../../eOT/jsp/VerificationHdr.jsp?<%=param%>" > -->
 	<FRAME  NAME="qa_query_result" id="qa_query_result" frameborder=0 scrolling="yes"  noresize SRC="../../eOT/jsp/VerificationSchSearch.jsp?<%=request.getQueryString()%>"   >
 </FRAMESET> 


