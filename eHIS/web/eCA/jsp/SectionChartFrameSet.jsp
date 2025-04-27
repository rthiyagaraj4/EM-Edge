<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<% 
	 request.setCharacterEncoding("UTF-8");
     String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/SectionChart.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<!--<frameset rows='10%,*,11%,40%,0%'  border ="0">--> <!--Updated by Arvind @ 08-12-08-->
	<!--
		<frame src="../../eCA/jsp/SectionChartHdr.jsp" name='sectionChartHeaderFrame' id='sectionChartHeaderFrame' scrolling = "no" noresize >
		<frame src="../../eCommon/html/blank.html" name='sectionChartMiddleFrame' id='sectionChartMiddleFrame' scrolling = "auto" noresize >
		<frame src="../../eCommon/html/blank.html" name='sectionChartSearchFrame' id='sectionChartSearchFrame' scrolling = "no" noresize >
		<frame src="../../eCommon/html/blank.html" name='sectionChartBottomFrame' id='sectionChartBottomFrame' scrolling = "no" noresize>
		<frame src="../../eCommon/html/blank.html" name='blankFrame' id='blankFrame' scrolling = "no" noresize>
	</frameset>
	-->
	
	<iframe src="../../eCA/jsp/SectionChartHdr.jsp" name='sectionChartHeaderFrame' id='sectionChartHeaderFrame' scrolling = "no" frameborder="no" noresize style="height:11vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name='sectionChartMiddleFrame' id='sectionChartMiddleFrame' scrolling = "auto" frameborder="no" noresize style="height:30vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name='sectionChartSearchFrame' id='sectionChartSearchFrame' scrolling = "no" frameborder="no" noresize style="height:11vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name='sectionChartBottomFrame' id='sectionChartBottomFrame' scrolling = "no" frameborder="no" noresize style="height:43vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name='blankFrame' id='blankFrame' frameborder="no" scrolling = "no" noresize style="height:0vh;width:100vw"></iframe>
</html>

