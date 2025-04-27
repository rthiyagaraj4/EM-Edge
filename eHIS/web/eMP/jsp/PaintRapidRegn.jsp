<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
<html>
    <head>
    <iframe name='patient_main' id='patient_main'  src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:17vh;width:100vw'></iframe>
    <iframe name='patient_sub' id='patient_sub' src='../../eMP/jsp/chkNatIDForPatReg.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe>
    </head>
</html>

