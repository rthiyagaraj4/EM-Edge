<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/MmMessages.js"></script>	 -->
	<script language="JavaScript" src="../js/TrnRemarks.js"></script>
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
	bean_id				=	"TransactionRemarksBean";
	bean_name			=	"eMM.TransactionRemarksBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//TransactionRemarksBean bean = null;
	TransactionRemarksBean bean = (TransactionRemarksBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);
	try
	{
	//	bean = (TransactionRemarksBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		/* Initialize Function specific end */
		bean.setMasterCode(request.getParameter("trn_remarks_code"));
		bean.loadData() ;
		bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_MODIFY"),MmRepository.getMmKeyValue( "SQL_MM_TRN_REMARKS_UPDATE"));
			//disabled	=	" disabled " ;
			if(bean.getEffStatus().equals("E"))
			{
				checked		=	" CHECKED ";	
			}
			else
			{
				checked		=	"";
			//	readOnly	=	" readOnly " ;
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
		
<form name="FormAddTrnRemarks" id="FormAddTrnRemarks" >
<table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="60%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">

<table cellpadding=0 cellspacing=0 width="90%"  border = 0 align=center>

<tr>
	<td  class="label" style="display:none"><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/></td>
	<td  class=fields  colspan="2" style="display:none" >&nbsp;&nbsp;<input type="text" name="module_id" id="module_id" value="<%=bean.getModuleID()%>" size="4" maxlength="4" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td  class="label" style="display:none"><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2" style="display:none">&nbsp;&nbsp;<input type="text" name="trn_type" id="trn_type" value="<%=bean.getTRNType()%>" size="4" maxlength="4" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
 <tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.TransactionRemarksCode.label" bundle="${mm_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="trn_remarks_code" id="trn_remarks_code" value="<%=bean.getMasterCode()%>" size="10" maxlength="10" <%=codeReadOnly%> <%=disabled%> onKeyPress="return changeCase()">
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.TransactionRemarks.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="remarks_desc" id="remarks_desc" value="<%=bean.getRemarks()%>" size="40" maxlength="200" onBlur="makeValidString( this ) ;" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
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

