<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/RecDiagnosis.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DifferentialGroup.label","mr_labels")+"</title>");
	String flag = ""; flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	
	String mode = "";
	mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	if(mode.equals("") || mode.equals("R")){
			mode = "insert";
	}	
%>
	
<frameset rows='100%,8%,10%'>
 
<%
	if(flag.equals("Record_found") || mode.equals("insert") ){
%>
	<frame name='diff_pop_up' id='diff_pop_up' 	src='../../eMR/jsp/RecDiagnosisDifferentialGroupPopup1.jsp?<%=request.getQueryString()%>' frameborder=0>
<%
}
else{
%>
	<frame name='diff_pop_up' id='diff_pop_up' 	src='../../eMR/jsp/RecDiagnosisDifferentialGroupPopup.jsp?<%=request.getQueryString()%>' frameborder=0> 
<%
}
%>	
	<frame name='toolbar_frame' id='toolbar_frame' src='../../eMR/jsp/RecDiagnosisDifferentialGroupButtons.jsp' frameborder=0  noresize scrolling='no' >

	<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>

