<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eAM/js/OPEncounter.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AESearchVisit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function reset() 
  {
	 
	  clear();
	  parent.parent.frames[2].frames[1].document.forms[0].reset();
  } 

 
function clear()
{
	parent.parent.frames[2].frames[1].document.forms[0].reset();
	parent.parent.frames[2].frames[2].location.href="../../eCommon/html/blank.html" ;
	parent.parent.frames[2].frames[3].location.href="../../eCommon/html/blank.html" ;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url						= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params					= request.getQueryString() ;
	String source					= url + params ;
	String p_mode					=	"INTERNALREPORT";
%>

						<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
								<iframe name='searchCriteria' id='searchCriteria' frameborder=no scrolling='no' src='../../eAE/jsp/AESearchVisitQueryCriteria.jsp?p_mode=<%=p_mode%>' style='height:18vh;width:100vw'></iframe><iframe name='PatientLine' id='PatientLine'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:6vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:59vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

