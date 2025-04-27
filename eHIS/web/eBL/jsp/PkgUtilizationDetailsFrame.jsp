<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
		<script language='javascript' src='../../eBL/js/PkgUtilization.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<%		   			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			//String source = url + params ;

%>		
		<iframe name='PkgPatIdFrame' id='PkgPatIdFrame' src='PkgUtilizationPatientId.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'> </iframe>
			<iframe name='PkgPatientHdr' id='PkgPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='PkgDtlsFrame' id='PkgDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:33vh;width:100vw'></iframe>
			<iframe name='PkgUtilizationPatientHdr' id='PkgUtilizationPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='PkgServDtlsFrame' id='PkgServDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:35vh;width:100vw'></iframe>

	
</HTML>

