<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>

<HTML>
<HEAD>
	<% 
	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	 <script language="JavaScript" src="../../ePH/js/ADRReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String	bean_id			=	"ADRReportBean" ;
	String	bean_name		=	"ePH.ADRReportBean";
	ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	String p_user_name= (String) session.getValue( "login_user" ) ;	
//	ArrayList result =new ArrayList();
	ArrayList result= bean.checkToProceed(p_user_name.trim());
	if(result.size()>0) {
		 bean.setApplUserID((String) result.get(0));
		 bean.setApplUserName((String) result.get(1));
	}
	else{
			bean.clear();
%>
		<SCRIPT>
		 alert(getMessage("PH_LOGIN_USER_NOT_PRACT","PH"));
		 window.location.href ='../../eCommon/jsp/dmenu.jsp' 
		
		</SCRIPT>
<%	
	}
%>


<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/AdrReportingFrames.jsp?<%=params%>" style="height:83vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/error.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:9vh;width:100vw"></iframe>
</HTML>

