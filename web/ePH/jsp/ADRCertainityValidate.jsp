
 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	
	String bean_id				=		request.getParameter( "bean_id" ) ;
	String bean_name		    =		request.getParameter( "bean_name" ) ;
	String validate			    =		request.getParameter( "validate" ) ;
	String rel_score_from		=		request.getParameter( "rel_score_from" ) ;
	String rel_score_to			=		request.getParameter( "rel_score_to" ) ;
	String Certainity_code		=		request.getParameter( "Certainity_code" ) ;
	String result				=		"N";
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	

	ADRCertainityBean beanObj = ( ADRCertainityBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "OVERLAPPING" ) ) 
	{
			
			 result = beanObj.checkOverlapping(rel_score_from,rel_score_to,Certainity_code);
			 if(result.equals("Y"))
			{
				out.println("alert(getMessage('OVERLAPPING_NOT_ALLOWED','PH'));");
							
			}
		 out.println("checkedValue('"+result+"')");
		
	}
%>
