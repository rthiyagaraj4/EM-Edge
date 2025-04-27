<!DOCTYPE html>

<%@	 page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		 (String)session.getAttribute("LOCALE");

		String sStyle				=		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
		 <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	     <script language="JavaScript" src="../../eMM/js/ViewCostDetailsforUser.js"></script>
		 <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body >
<%

	String 		mode					=		"";
	String		readOnly				=		"";
	String		checked					=		"";
	String		bean_id					=		"";
	String		bean_name				=		"";
//	String		codeReadOnly			=		"";
	String		classValue				=		"";
	int			totalRecords			=		0;
	int			rowIndex				=		0;
	int			recCount				=		0;

	mode								=		request.getParameter( "mode" );
	bean_id								=		"viewCostDetailsforUser";
	bean_name							=		"eMM.ViewCostDetailsforUser";

	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
	return ;

	
	ViewCostDetailsforUser bean			=	(ViewCostDetailsforUser)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);



	try
	{

		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		totalRecords						=	Integer.parseInt((String)CommonRepository.getCommonKeyValue( "MULTIPLE_INSERT_PAGE_SIZE"));
		
		
}
		catch(Exception e)
	{
		//System.out.println("comes to exception");
		//out.println("Exception@1: "+e);
		e.printStackTrace(); // COMMON-ICN-0184
	}
%>
<form name="formViewCostAddModify" id="formViewCostAddModify" >
<table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">
	<table cellpadding=0 cellspacing=0 border="1" align=center>
	<tr>
		
		<th ><fmt:message key="Common.userid.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></th>
		<th ><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="eST.ViewCostDetails.label" bundle="${st_labels}"/></th>
	</tr>
<%
	for(rowIndex=0; rowIndex<totalRecords; rowIndex++)
	{
		recCount	=	0;
		classValue	=	( (rowIndex%2)==0 )	?	"QRYEVEN"	:	"QRYODD";
	

%>
	<tr>
		
		<td class="<%=classValue%>" class='UPPER'>
		 <input type="text" name="user_id<%=rowIndex%>" id="user_id<%=rowIndex%>" value="" size=60 maxLength=30    align="centre" onKeyPress="return CheckForSpecChars(event);">
		 <input type="button" class="button" name="userIdSearch<%=rowIndex%>" id="userIdSearch<%=rowIndex%>" value="?" onClick="searchCode(user_id<%=rowIndex%>,<%=rowIndex%>)" align="left">&nbsp;
		 
		</td>
		<td class="<%=classValue%>" >
			<input type="text" name="user_name<%=rowIndex%>" id="user_name<%=rowIndex%>"  size="40" maxlength="40" <%=readOnly%>    >
		</td>
		<td class="<%=classValue%>"  >
			<input type="checkbox" name="view_cost_details_yn<%=rowIndex%>" id="view_cost_details_yn<%=rowIndex%>" <%=checked%> value="N" onClick="return setStatus(this);">
		</td>
	</tr>
<%
	recCount++;}
%>
	</table>
	</td></tr>
</table>
<input type="hidden"	 name="mode" id="mode"				value="<%=mode%>">
<input type="hidden"	 name="bean_id" id="bean_id"				value="<%=bean_id%>">
<input type="hidden"	 name="bean_name" id="bean_name"			value="<%=bean_name%>">
<input type="hidden"	 name="totalRecords" id="totalRecords"		value="<%=totalRecords%>">
<input type="hidden"	 name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
<input type="hidden"	 name="p_language_id" id="p_language_id" 		value="<%=locale%>">
</form>
</center>
<%
bean.setTotalRecords(totalRecords);
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

