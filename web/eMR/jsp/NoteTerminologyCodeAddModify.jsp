<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="JavaScript" src="../../eMR/js/TerminologyGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <%
  request.setCharacterEncoding("UTF-8");
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
 String url="../../eCommon/html/blank.html";
 String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
 if(mode.equals("2"))
	url = "../../eMR/jsp/NoteTerminologyCodeSingle.jsp?"+request.getQueryString();
 %>

<iframe name='term_set' id='term_set' 	src='../../eMR/jsp/NoteTerminologyCodeAddModifySet.jsp?<%=request.getQueryString()%>' frameborder='0' noresize scrolling='no' style='height:16vh;width:100vw'></iframe>
<iframe name='term_level' id='term_level' src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='no' style='height:16vh;width:100vw'></iframe>
<iframe name='term_associated' id='term_associated' src='<%=url%>' frameborder='0' noresize scrolling='auto' style='height:59vh;width:100vw'></iframe>
</head>
</html>

