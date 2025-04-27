<!DOCTYPE html>
 
<html>
 
<head>
    <%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script language='javascript' src='../../eSM/js/RecordTrans.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    </head>
<%
request.setCharacterEncoding("UTF-8");
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html' frameborder=0 style='height:86vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe><iframe name='dumyFrame' id='dumyFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>


