<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper "%>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_term_code_set' id='f_term_code_set' 	src='../../eMR/jsp/TerminologyCodeTermSet.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
<iframe name='f_term_result_header' id='f_term_result_header' 	src='../../eMR/jsp/TerminologyCodeResultHeader.jsp' frameborder=0 noresize style='height:8vh;width:100vw' scrolling='no'></iframe>
<iframe name='f_term_code_result' id='f_term_code_result' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:26vh;width:100vw' scrolling='auto'></iframe>
<iframe name='f_term_selected_frms' id='f_term_selected_frms' 	src='../../eMR/jsp/TerminologyCodeSelectionFrameSet.jsp' frameborder=0 noresize style='height:15vh;width:100vw'></iframe>
<iframe name='f_term_add_modify' id='f_term_add_modify' 	src='../../eMR/jsp/TerminologyCodeAddModify.jsp' frameborder=0 noresize style="height:22vh; width:100vw" ></iframe>
<iframe name='blankFrame' id='blankFrame' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:1vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</head>
</html>

