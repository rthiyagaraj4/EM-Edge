<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><fmt:message key="Common.AutoFileRequest.label" bundle="${common_labels}"/></title>
</head>
<%
	String file_no				=	checkForNull(request.getParameter("file_no"));
	String patient_id			=	checkForNull(request.getParameter("patient_id"));
	String fs_locn_code			=	checkForNull(request.getParameter("fs_locn_code"));
	String online_mr_notfn_yn	=	checkForNull(request.getParameter("online_mr_notfn_yn"));
	String req_locn_id			=	checkForNull(request.getParameter("req_locn_id"));
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
%>
<iframe name='FMAFTVNoFrame' id='FMAFTVNoFrame' src='../../eFM/jsp/FMAcceptFileTypeVolumeNo.jsp?file_no=<%=file_no%>&patient_id=<%=patient_id%>&fs_locn_code=<%=fs_locn_code%>&online_mr_notfn_yn=<%=online_mr_notfn_yn%>&encounter_id=<%=encounter_id%>&req_locn_id=<%=req_locn_id%>'  frameborder=0 scrolling='no' noresize style='height:100%;width:100vw'></iframe>
	<iframe name='msgFrame' id='msgFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' noresize style='height:0%;width:100vw'></iframe>

</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
%>

