<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<% String params = request.getQueryString(); %>
<FRAMESET ROWS='30%,*' border='0'>	
	<FRAME NAME='PostOperDiagFrame' SRC='../../eOT/jsp/PostOperDiagHdr.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
<FRAMESET COLS='40%,*' border='0'>	
	    <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/PostOperDiagnosisRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	  <!--<FRAME NAME='DetailFrame' SRC='../../eOT/jsp/PostOperDiagnosisDtls.jsp?<%=params%>' 			   scrolling='no' noresize='no'></FRAME>-->
	<FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
