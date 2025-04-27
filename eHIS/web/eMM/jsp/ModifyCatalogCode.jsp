<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
13/5/2021		TFS:14012			Shazana											MO-CRF-20165
---------------------------------------------------------------------------------------------------------
*/ %>    


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
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script> 
<!-- 	<script language="JavaScript" src="../js/MmMessages.js"></script>	 -->
	<script language="JavaScript" src="../js/CatalogCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="FocusFirstElement()" >
<%
	/* Mandatory checks start */
	String	mode		=	"";		
	String	disabled	=	"",		checked		=	"";
	String	bean_id		=	"",		bean_name	=	"";
	String	codeReadOnly=	"";	

	mode				=	request.getParameter( "mode" );
	bean_id				=	"catalogCodeBean";
	bean_name			=	"eMM.CatalogCodeBean";
	 
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	CatalogCodeBean bean =(CatalogCodeBean)getBeanObject( bean_id, bean_name,request) ;  
	bean.setLanguageId(locale);
	try
	{
	//	bean = (ItemAnalysisBean)getBeanObject( bean_id, bean_name,request) ;  
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;

		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		/* Initialize Function specific end */

		//bean.setMasterCode(request.getParameter("item_anal_code"));
		bean.setMasterCode(request.getParameter("item_catalog_code"));	  
			
			bean.loadData() ;
			
			bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_MODIFY"),MmRepository.getMmKeyValue( "SQL_MM_CATALOG_CODE_UPDATE")); 

			//disabled	=	" disabled " ;
			if(bean.getEffStatus().equals("E"))
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
		
<form name="formMasterCode" id="formMasterCode" >
<table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">

<table cellpadding=0 cellspacing=0 width="90%" align=center>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.CatalogCode.label" bundle="${mm_labels}"/></td>  
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="catalog_code" id="catalog_code" value="<%=bean.getMasterCode()%>" size="4" maxlength="4" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
	<img src="../../eCommon/images/mandatory.gif"></img></td> 
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=bean.getLongDesc()%>" size="40" maxlength="40" onBlur="makeValidString( this ) ;" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=bean.getShortDesc()%>" size="15" maxlength="15" onBlur="makeValidString( this ) ;"  <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" <%=checked%> value="E" ></td>
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

