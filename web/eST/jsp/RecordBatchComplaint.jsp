<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> -->
<%
request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src="../../eST/js/SuspendOrReinstateBatch.js"></script>
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<!-- <script language='javascript' src="../../eST/js/StMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

</head>
<%
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString() ;
String source = url + params ;

String function_id = request.getParameter( "function_id" ) ;

%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source%>"  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_criteria' id='f_query_add_mod_criteria' src="../../eST/jsp/SuspendOrReinstateBatchCriteria.jsp?mode=<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")%>&function_id=<%=function_id%>" frameborder=0  scrolling='no' style='height:20vh;width:100vw'></iframe><iframe name='f_query_add_mod_result' id='f_query_add_mod_result' src='../../eCommon/html/blank.html' frameborder=0 style='height:62vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>

</html>

