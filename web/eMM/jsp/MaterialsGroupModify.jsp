<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<% 
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script>	 -->
	<script language="JavaScript" src="../../eMM/js/MaterialsGroup.js"></script>
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
	bean_id				=	"MaterialsGroupBean";
	bean_name			=	"eMM.MaterialsGroupBean";
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	MaterialsGroupBean bean = null;
	try
	{
		bean = (MaterialsGroupBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;

		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		/* Initialize Function specific end */

		bean.setMasterCode(request.getParameter("material_group_code"));
	
			bean.loadData() ;
			
			bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_MODIFY"),MmRepository.getMmKeyValue( "SQL_MM_MATRIALS_GROUP_UPDATE"));

			//disabled	=	" disabled " ;
			if(bean.getEffStatus().equals("E"))
			{
				checked		=	" CHECKED ";	
			}
			else
			{
				checked		=	"";
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
	<td class="label"><fmt:message key="eMM.MaterialGroupCode.label" bundle="${mm_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="material_group_code" id="material_group_code" value="<%=bean.getMasterCode()%>" size="6" maxlength="6" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
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

