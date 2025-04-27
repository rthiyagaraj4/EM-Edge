<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>

</HEAD>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params	= request.getQueryString() ;
	
%>

<frameset cols="50%,*" framespacing="0">
    <frameset name='f_drug_preview_buttons' rows="68%,32%" framespacing="0" >
	   <frame name="f_oncology_regimen_drug_list" scrolling="auto" noresize src="../../eCommon/html/blank.html"CLASS="CATHIRDWORKAREA1" >
	   <frame name="f_preview_buttons" scrolling="auto" noresize src="../../eCommon/html/blank.html"frameborder="0" CLASS="CATHIRDWORKAREA1">
    </frameset>  
	<frameset name='f_drug_fluid_admindtls' rows="45%,35%,50%,30%" framespacing="0">

		<frame name="f_oncology_sub_drugs" frameborder="0" scrolling="yes" noresize src="OncologyRegimenDrugDetails.jsp?<%= params %>">
		<frame name="oncology_fluid" frameborder="0" scrolling="yes" noresize src="OncologyRegimenFluidDetail.jsp?<%= params %>">
	    <frame name="oncology_admin" frameborder="0" scrolling="yes" noresize src="OncologyRegimenAdminDetail.jsp?<%= params %>">
		<frame name="oncology_button" frameborder="0" scrolling="yes" noresize src="OncologyRegimenButtons.jsp?<%= params %>"CLASS="CATHIRDWORKAREA1">
	</frameset>
</frameset>

</html>
