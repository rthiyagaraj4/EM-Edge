<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%   request.setCharacterEncoding("UTF-8"); %>

<html>
<head></head>
	<script>
	</script>
	
	<frameset rows='25%,*'>
	<frame name='RecDiagnosisEOCResultCriteria' id='RecDiagnosisEOCResultCriteria' framespacing=0 border=0 src="../../eMR/jsp/RecDiagnosisEOCResultCriteria.jsp?<%=request.getQueryString()%>" scrolling='no' noresize frameborder='no'>
	</frame>
	<frame name='RecDiagnosisEOCResultCriteriaResult' id='RecDiagnosisEOCResultCriteriaResult' framespacing=0 border=0 src="../../eMR/jsp/RecDiagnosisEOCResultCriteriaResult.jsp?<%=request.getQueryString()%>" scrolling='auto' noresize frameborder='no'>
	</frame>
</frameset>
</html>

