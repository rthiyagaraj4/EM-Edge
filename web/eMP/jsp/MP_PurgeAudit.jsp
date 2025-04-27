<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="JavaScript" src="../../eMP/js/Mp_PurgeAudit.js" language="javascript"></script>
<%
    String toolBarUrl   = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
    String toolBarParams    = request.getQueryString() ;
    String toolBarSource    = toolBarUrl + toolBarParams ;

    String formUrl      = "../../eMP/jsp/mp_purgeaudit_form.jsp?" ;
    String formParams       = "" ;
    String formSource       = "" ;
    formSource = formUrl + formParams ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src='<%= toolBarSource %>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod'   src='<%= formSource %>' frameborder=0 scrolling=no style='height:84vh;width:100vw'></iframe>
    <iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>

