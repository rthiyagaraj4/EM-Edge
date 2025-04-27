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

		<script language="JavaScript" src ="../../eCA/js/SitesForVaccine.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<iframe src="../../eCA/jsp/SitesForVaccineHdr.jsp" name='SitesForVaccineHeaderFrame' id='SitesForVaccineHeaderFrame' scrolling = "no"  style='height:10vh; width:98vw;'></iframe>
	<iframe src="../../eCommon/html/blank.html" name='SitesForVaccineMiddleFrame' id='SitesForVaccineMiddleFrame' scrolling = "no"  style='height:25vh; width:98vw; border:0px;'></iframe>
	<iframe src="../../eCommon/html/blank.html" name='SitesForVaccineSearchFrame' id='SitesForVaccineSearchFrame' scrolling = "no"  style='height:20vh; width:98vw; border:0px;' ></iframe>
	<iframe src="../../eCommon/html/blank.html" name='SitesForVaccineBottomFrame' id='SitesForVaccineBottomFrame' scrolling = "no"  style='height:30vh; width:98vw; border:0px;'></iframe>
	<iframe src="../../eCommon/html/blank.html" name='blankFrame' id='blankFrame' scrolling = "no"  style='height:10vh; width:98vw; border:0px;'></iframe>
</html>

