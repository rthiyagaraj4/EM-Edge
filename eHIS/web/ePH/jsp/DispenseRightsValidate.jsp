<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String password = request.getParameter( "password" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setPassWord(password);
%>
<%
putObjectInBean(bean_id,bean,request);
%>
