<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
   	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/UserForReview.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()" >

<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_UserForReview" ;
	String bean_name = "eOR.UserForReview";
	//String disabled = "" ;

	//String responsibility_id = (String)session.getValue("responsibility_id") ;
	
	

//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	UserForReview bean = (UserForReview)getBeanObject( bean_id,bean_name ,request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	
/* Initialize Function specific end */
//	if ( mode.equals( CommonInterface.MODE_MODIFY )  || mode.equals( CommonInterface.MODE_DELETE ) ) {

//	}
%>

<form name='user_for_review_top1' id='user_for_review_top1' target='messageFrame' >
   <input type="hidden" name="mode" id="mode" value="<%=mode%>">
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' >
	<tr>
		<td class=fields width='50%' align='center'>
		
		<input type=radio name=radio_but value='practitioner' onclick='loadPage(this)' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> 
		</td><td class=fields width='50%' align='center'>
		<input type=radio name=radio_but value='responsibility' onclick='loadPage(this)'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/>
		</td></tr>

	<!--<tr>
		<td colspan="2">&nbsp;</td>
	</tr>-->		
</table>


</form>

</body>
</html>
<%
putObjectInBean( bean_id, bean , request) ;  
%>

