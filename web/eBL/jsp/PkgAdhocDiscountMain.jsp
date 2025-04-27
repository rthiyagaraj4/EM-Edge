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
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;

%>		
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>'  frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgAdhocDiscountFrame' id='PkgAdhocDiscountFrame' src='PkgAdhocDiscountFrame.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:85vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='dummyFrame' id='dummyFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
			
	
</HTML>

