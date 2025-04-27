<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%> 
<%request.setCharacterEncoding("UTF-8");%>
<frameset cols="40%,*" framespacing="0" id="drawingtools"  frameborder="none" border="none"> 
	<frame name="drawingToolView"   src="../../eOR/jsp/MedPntredit.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize> 
	<frameset rows="*,10%" framespacing="0"   frameborder="none" border="none"> 
		<frame name="drawingToolResultView"   src="../../eOR/jsp/MedPntredit.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize> 
		<frame name="drawingToolResultRecording"   src="../../eOR/jsp/ResultEntryDrawingToolButton.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize> 
	</frameset>
</frameset>
