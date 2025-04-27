 <%-- saved on 03/11/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id		= request.getParameter( "bean_id" ) ;
	String bean_name	= request.getParameter( "bean_name" ) ;
	String patient_id   = request.getParameter( "patient_id" ) ;
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	ArrayList result =	bean.getNationalityHealthCardNo(patient_id);
	if (result.size()>0){
		out.println("assignNationalityHealthCardNo('"+result.get(0)+"','"+result.get(1)+"')");
	}
%>
<% putObjectInBean(bean_id,bean,request); %>
