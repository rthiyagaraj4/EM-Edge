<%-- saved on 26/10/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String validate			= request.getParameter( "validate" ) ;
	String age_group_code	= request.getParameter( "age_group_code" ) ;
	
	if(validate==null)  validate="";
	
	int flag=0;
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	TPNConsLimitsBean bean = (TPNConsLimitsBean)getBeanObject(bean_id,bean_name,request) ;
	
	if( validate.equals("checkforvalid"))
	{	
		flag =bean.checkforvalid(  age_group_code);
	
		out.println("addtocheckforvalid('"+flag+"')");
		


	}


putObjectInBean(bean_id,bean,request);
%>
