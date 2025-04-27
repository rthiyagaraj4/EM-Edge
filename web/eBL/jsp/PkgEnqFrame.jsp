<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
		String params = request.getQueryString();
		//String from	= request.getParameter("from")== null ? "PACKAGE" : request.getParameter("from"); 
		String packageCode	=	request.getParameter("packageCode");
		packageCode			=	packageCode == null ? "" :packageCode ;
		String packageSeqNo	=	request.getParameter("packageSeqNo");
		packageSeqNo		= packageSeqNo==null?"":packageSeqNo;
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgEnq.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		

		<iframe name='PkgEnqHeader' id='PkgEnqHeader'	src='PkgEnqHeader.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:40vh;width:99vw'></iframe>
			
			<iframe name='PkgEnqTabFrame' id='PkgEnqTabFrame'	src='PkgEnqTab.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:5vh;width:99vw'></iframe>

			<iframe name='PkgEnqDetailFrame' id='PkgEnqDetailFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:50vh;width:99vw'></iframe>
		 

			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:0vw'></iframe>
		
</HTML>


