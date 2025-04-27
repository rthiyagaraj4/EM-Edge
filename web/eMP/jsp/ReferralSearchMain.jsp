<!DOCTYPE html>
<!--
   		 Developed By  :- M.F.Mohamed Ali Suhail
   		 Function      :-  Referral Search (To search a referral id)
-->
<html>
  <head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/ReferralSearch.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
  <%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String function_id = request.getParameter("function_id");

  %>
  		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod_main' id='f_query_add_mod_main' 	src='../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=<%=function_id%>' frameborder=0 style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
  <form>	    
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
  </form>
</html>

