<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	<script language='javascript' src='../../eBL/js/PkgSrvsToNonPkgSvs.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%		   			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;

%>		
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>'  frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgPatIdFrame' id='PkgPatIdFrame' src='PkgSrvsToNonPkgSvsPatientId.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgPatientHdr' id='PkgPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='PkgSrvsToNonPkgSvsPatientHdrDtlsFrame' id='PkgSrvsToNonPkgSvsPatientHdrDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:37vh;width:100vw'></iframe>
			<iframe name='PkgSrvsToNonPkgSvsPatientHdr' id='PkgSrvsToNonPkgSvsPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='PkgSrvsToNonPkgSvsDtlsFrame' id='PkgSrvsToNonPkgSvsDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:37vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:4vh;width:100vw'></iframe>

	
</HTML>

