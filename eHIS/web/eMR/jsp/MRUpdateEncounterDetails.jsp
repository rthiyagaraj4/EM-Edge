<!DOCTYPE html>

<html>
<head>
	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eMR/js/MRUpdateEncounterDtls.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String fac_id = (String) session.getValue( "facility_id" );
	String userid = (String) session.getValue("login_user");
	String function_id=request.getParameter("function_id");
%>			
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='criteria' id='criteria'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eMR/jsp/MRUpdateEncounterDtlsCriteria.jsp?called_from="MR"' style='height:100%;width:100vw'></iframe><iframe name='result' id='result'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>

</html>

