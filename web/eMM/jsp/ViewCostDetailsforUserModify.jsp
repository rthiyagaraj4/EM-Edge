<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script> 
			<script language="JavaScript" src="../../eMM/js/ViewCostDetailsforUser.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			

<body onLoad="FocusFirstElement()" >
<%
	/* Mandatory checks start */
	String	mode		=	"";		
	String	disabled	=	"";
	String  checked		=	"";
	String	bean_id		=	"";
	String	bean_name	=	"";
	String	codeReadOnly=	"";	

	mode										=		request.getParameter( "mode" );
	String user_id								=		request.getParameter( "user_id" ).trim();
	String user_name							=		request.getParameter( "user_name" ).trim();
	String view_cost_details_yn					=		request.getParameter( "view_cost_details_yn" );
	bean_id										=		"viewCostDetailsforUser";
	bean_name									=		"eMM.ViewCostDetailsforUser";
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	
	ViewCostDetailsforUser bean =(ViewCostDetailsforUser)getBeanObject( bean_id, bean_name,request) ;  

	bean.setLanguageId(locale);
	try
	{
		
		bean.clear() ;
		//bean.setUserID(request.getParameter("user_id"));
		//bean.setUserName(request.getParameter("user_name"));
		//bean.setViewCostDetails(request.getParameter("view_cost_details_yn"));
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setUser_Id(user_id);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
		bean.loadData() ;
			
			bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_MODIFY"),"Update MM_VIEW_COST_FOR_USER set view_cost_yn = ?,  MODIFIED_DATE =SYSDATE , MODIFIED_BY_ID =? , MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ? where APPL_USER_ID like ?)");

			//disabled	=	" disabled " ;
			if(view_cost_details_yn.equals("Y"))
			{
				checked		=	" CHECKED ";	
			}
			else
			{
				checked		=	"";
//				readOnly	=	" readOnly " ;
				disabled		=	"disabled";
			}
			codeReadOnly	=	" disabled ";
	}
		
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);
		e.printStackTrace(); // COMMON-ICN-0184
	}
%>
		
<form name="formViewCostAddModify" id="formViewCostAddModify" >
<table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">

<table cellpadding=0 cellspacing=0  width="90%" align=center>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="user_id" id="user_id" value="<%=user_id%>" size="4" maxlength="4" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="user_name" id="user_name" value="<%=user_name%>" size="40" maxlength="40" onBlur="makeValidString( this ) ;" <%=disabled%><%=codeReadOnly%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eST.ViewCostDetails.label" bundle="${st_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;
	<input type="checkBox" name="view_cost_details_yn" id="view_cost_details_yn" value="<%=view_cost_details_yn%>" <%=checked%> onClick="return setStatus(this);" >
	</td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>

</table>
</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>

</body>

</html>

