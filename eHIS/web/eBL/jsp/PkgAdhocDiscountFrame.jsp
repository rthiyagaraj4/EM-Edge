<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	<script language='javascript' src='../../eBL/js/PkgAdhocDiscount.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%		   			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
		//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			//String source = url + params ;

%>		
		<iframe name='PkgPatIdFrame' id='PkgPatIdFrame' src='PkgAdhocDiscountPatientId.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgPatientHdr' id='PkgPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='PkgAdhocDiscountPatientHdrDtlsFrame' id='PkgAdhocDiscountPatientHdrDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:30vh;width:100vw'></iframe>
			<iframe name='PkgAdhocDiscountPatientHdr' id='PkgAdhocDiscountPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgAdhocDiscountDtlsFrame' id='PkgAdhocDiscountDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>

	
</HTML>

