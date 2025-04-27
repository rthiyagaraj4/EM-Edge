<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<html>
<head>
  <%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/BLFunctionPrivilegePolicy.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;
	System.out.println(source);	
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='BLUserRightsMainFrame' id='BLUserRightsMainFrame' 	src='BFunctionPrivilegeAddMod.jsp' frameborder=0 style='height:50vh;width:100vw'></iframe>
			<iframe name='BLUserRightsLookupFrame' id='BLUserRightsLookupFrame' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:34vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>

</html>

