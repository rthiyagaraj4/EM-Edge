<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
 <HTML>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
//	String url = "../../ePH/jsp/ReturnMedicationAddModify.jsp?" ;
	String url = "../../ePH/jsp/ReturnMedicationAddModify.jsp" ;
	String params = request.getQueryString() ;
	String source = url +"?"+ params ;
	
	
//String source=url; 


%>
 <%-- <FRAMESET  ROWS="25%,5%,40%,31%,*" FRAMESPACING="0" frameborder="1" id="mainframeset">
	
	
	<FRAME NAME="retmedicationqueryframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source%>">
	<FRAME NAME="retmedicationplineframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="">
	<FRAMESET cols="55%,*" FRAMESPACING="0" frameborder="0">
		<FRAME NAME="retmedicationdrugframe" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html">
		<FRAME NAME="retmedicationremarksframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE 	SRC="../../eCommon/html/blank.html">
	</frameset>
		<FRAME NAME="retmedicationactionframe" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html">
		<FRAME NAME="retmedicationbuttonframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html">
</FRAMESET> --%>
<div style="display: flex; flex-direction: column; height: 95vh;">
    <iframe name="retmedicationqueryframe"  id="retmedicationqueryframe" style="height: 23vh; border: none;" src="<%=source%>"></iframe>
    <iframe name="retmedicationplineframe" id="retmedicationplineframe" style="height: 5vh; border: none;" src=""></iframe>
    <div id='innerdiv' style="display: flex; height: 40vh;">
        <iframe name="retmedicationdrugframe" id="retmedicationdrugframe" style="flex: 0 0 55%; border: none;" src="../../eCommon/html/blank.html"></iframe>
        <iframe name="retmedicationremarksframe" id="retmedicationremarksframe" style="flex: 1; border: none;" src="../../eCommon/html/blank.html"></iframe>
    </div>
    <iframe name="retmedicationactionframe" id="retmedicationactionframe" style="height: 31vh; border: none;" src="../../eCommon/html/blank.html"></iframe>
    <iframe name="retmedicationbuttonframe" id="retmedicationbuttonframe" style="flex-grow: 1;height: 5vh; border: none;" src="../../eCommon/html/blank.html"></iframe>
</div> 

</HTML>
