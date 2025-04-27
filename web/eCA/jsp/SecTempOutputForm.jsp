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
	<script language="javascript" src="../js/SecTempOutputForm.js"></script>

	<!-- <frameset rows='6%,33%,55%,8%' border=0>

		<frame name='SecTempOutputFormHeaderFrame' src='../../eCA/jsp/SecTempOutputFormHeader.jsp' frameborder=no noresize scrolling=no framespacing=NO border=0>
		<frameset id='listFrameset' cols='60%,*' border=0>	
		<frame name='SecTempOutputFormPrevEdtrFrame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=1> 
		<frame name='SecTempOutputFormListFrame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=1>
		</frameset>
			
		<frame name='SecTempOutputFormEdtrFrame' src='../../eCommon/html/blank.html' frameborder=no noresize framespacing=NO border=0>

		<frame name='SecTempOutputFormEdtrBttnFrame' src='../../eCommon/html/blank.html' frameborder=no noresize  scrolling=no framespacing=NO border=0> 
			
	</frameset> -->
	
   			 <iframe name="SecTempOutputFormHeaderFrame" src="../../eCA/jsp/SecTempOutputFormHeader.jsp" style="border: none; height: 6vh; width: 98vw;" scrolling="no"></iframe>

		<div style="display: flex; height: 33vh; border: 0;">
   			 <iframe name="SecTempOutputFormPrevEdtrFrame" id="SecTempOutputFormPrevEdtrFrame" src="../../eCommon/html/blank.html" style="border: none; width: 60vw; height: 33vh;" scrolling="yes"></iframe>
   			 <iframe name="SecTempOutputFormListFrame"  id="SecTempOutputFormListFrame" src="../../eCommon/html/blank.html" style="border: none; width: 40vw; height: 33vh;" scrolling="no"></iframe>
		</div>
		<div style=" height: 45vh; border: 0;">
 		   <iframe name="SecTempOutputFormEdtrFrame" src="../../eCommon/html/blank.html" style="border: none; height: 50vh; width: 98vw;" scrolling="no"></iframe>

 		   <iframe name="SecTempOutputFormEdtrBttnFrame" src="../../eCommon/html/blank.html" style="border: none; height: 8vh; width: 98vw;" scrolling="no"></iframe>
 		   </div>
 		   
</head>

</html>
