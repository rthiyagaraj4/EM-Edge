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

	String bean_id					=		request.getParameter( "bean_id" ) ;
	String bean_name				=		request.getParameter( "bean_name" ) ;
	String validate					=		request.getParameter( "validate" ) ;
	String relative_score_yes		=		request.getParameter( "relative_score_yes" ) ;
	String relative_score_no		=		 request.getParameter( "relative_score_no" ) ;
	String relative_score_not_known =		 request.getParameter( "relative_score_not_known" ) ;
	String result					=		"Y";
	ArrayList values				=		 new ArrayList();
		if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
	ADRQuestionBean beanObj = ( ADRQuestionBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
   hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "OVERLAPPING" ) ) 
		{
		
		 values							=		 beanObj.checkOverlapping();
		
		 String min						=		(values.get(0).toString());
		 int min_value					=		Integer.parseInt(min);
		 String max						=		(values.get(1).toString());
		  int max_value					=		Integer.parseInt(max);
		  int relative_score_yes_1		=		Integer.parseInt(relative_score_yes);
		  int relative_score_no_1		=		Integer.parseInt(relative_score_no);
		  int relative_score_not_known_1=		Integer.parseInt(relative_score_not_known);
		 
		if(((relative_score_yes_1>=min_value)&&(relative_score_yes_1<=max_value))&&((relative_score_no_1>=min_value)&&(relative_score_no_1<=max_value))&&((relative_score_not_known_1>=min_value)&&(relative_score_not_known_1<=max_value)))
			{
				 result="Y";
			}
			else
			{
				result="N";
				out.println("alert(getMessage('RANGE_SHOULD_NOT_EXCEED','PH'));");
			}
		
			 out.println("checkedValue('"+result+"')");
	
		}
		
	%>
