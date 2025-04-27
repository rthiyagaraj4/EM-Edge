<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='CASectionTemplateHeaderFrame' id='CASectionTemplateHeaderFrame' src='../../eCA/jsp/CASectionTemplateHeader.jsp' frameborder=no noresize scrolling=no framespacing=NO border=0 style='height:6vh;width:99vw'></iframe>
<iframe name='CASectionTemplateListFrame' id='CASectionTemplateListFrame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=1 style='height:29vh;width:99vw;border: none'></iframe>
<iframe name='CASectionTemplatePreviewFrame' id='CASectionTemplatePreviewFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:6vh;width:99vw'></iframe>
<iframe name='CASectionTemplateDetailFrame' id='CASectionTemplateDetailFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize  framespacing=NO border=0 style='height:46vh;width:99vw'></iframe>
<iframe name='CASectionTemplateToolbarFrame' id='CASectionTemplateToolbarFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize  scrolling=no framespacing=NO border=0 style='height:7vh;width:99vw'></iframe>
<iframe name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize framespacing=NO border=0 style='display:none;height:0vh;width:99vw;  margin-bottom:0vh;'></iframe>
</head>
</html>

<!-- <iframe name='CASectionTemplateHeaderFrame' id='CASectionTemplateHeaderFrame' src='../../eCA/jsp/CASectionTemplateHeader.jsp' frameborder=no noresize scrolling=no framespacing=NO border=0 style='height:10%;width:100vw'></iframe><iframe name='CASectionTemplateListFrame' id='CASectionTemplateListFrame' src='../../eCA/jsp/CASectionTemplateList.jsp' frameborder=1 noresize framespacing=NO border=1 style='height:47%;width:100vw'></iframe><iframe name='CASectionTemplatePreviewFrame' id='CASectionTemplatePreviewFrame' src='../../eCA/jsp/CASectionTemplatePreview.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:5%;width:100vw'></iframe><iframe name='CASectionTemplateDetailFrame' id='CASectionTemplateDetailFrame' src='../../eCA/jsp/CASectionTemplateDetail.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:38%;width:100vw'></iframe><iframe name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize framespacing=NO border=0 style='height:0%;width:100vw'></iframe>
 -->

<!--  <frameset rows='10%,85%,5%' border=0>
	<frame name='CASectionTemplateHeaderFrame' id='CASectionTemplateHeaderFrame' src='../../eCA/jsp/CASectionTemplateHeader.jsp' frameborder=no noresize scrolling=no framespacing=NO border=0>
	<frameset cols='40%,60%,0%'>
		<frame name='CASectionTemplateDetailFrame' id='CASectionTemplateDetailFrame' src='../../eCA/jsp/CASectionTemplateDetail.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0> 
		<frame name='CASectionTemplateListFrame' id='CASectionTemplateListFrame' src='../../eCA/jsp/CASectionTemplateList.jsp' frameborder=1 noresize framespacing=NO border=1> 
		<frame name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize framespacing=NO border=0> 
	</frameset>
<frame name='CASectionTemplatePreviewFrame' id='CASectionTemplatePreviewFrame' src='../../eCA/jsp/CASectionTemplatePreview.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0>
</frameset> -->

