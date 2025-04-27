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
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="JavaScript" src="../js/TrnRemarks.js"></script> 
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body >
<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String	mode			=	"";
	String	disabled		=	"";
	String	bean_id			=	"",		bean_name	=	"";
	int		totalRecords	=	0;
//	String	mod_id		=	"";	
	mode					=	request.getParameter( "mode" );
//	mod_id					=	request.getParameter( "mod_id" )==null?"ST":request.getParameter("mod_id");
	bean_id					=	"TransactionRemarksBean";
	bean_name				=	"eMM.TransactionRemarksBean";
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	TransactionRemarksBean bean = (TransactionRemarksBean)getBeanObject( bean_id, bean_name, request );
		bean.setLanguageId(locale);
	MmUtils objMmUtils	=	new MmUtils( bean.getProperties() );
	try
	{
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		totalRecords	=	Integer.parseInt((String)CommonRepository.getCommonKeyValue( "MULTIPLE_INSERT_PAGE_SIZE"));
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		/* Initialize Function specific end */
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);
		e.printStackTrace(); // COMMON-ICN-0184
	}

%>
<form name="FormAddTrnRemarks" id="FormAddTrnRemarks" >
<BR>
<table cellpadding=0 cellspacing=0 width="90%"  border =0 style="display:none" align=center>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class="fields" >
		<SELECT name='module_id' id='module_id' onChange="setmoduleid(this);" <%=disabled%> > <%=objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MODULE_ID"),"ST",locale)
		%>
		</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	
	</td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
</center>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

