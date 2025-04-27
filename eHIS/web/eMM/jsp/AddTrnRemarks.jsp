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
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="JavaScript" src="../js/TrnRemarks.js"></script> 
<!-- 	<script language="JavaScript" src="../js/MmMessages.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<!-- onKeyDown="return lockKey()" -->
<body onLoad="FocusFirstElement()">
<%
	/* Mandatory checks start */
	String	mode			=	"",		readOnly	=	"";
//	String	disabled		=	"";
	String	checked			=	"";
	String	bean_id			=	"",		bean_name	=	"";
	String	codeReadOnly	=	"",		classValue	=	"";
	int		totalRecords	=	0,		rowIndex	=	0;
	String	mod_id		=	"";	
	mode					=	request.getParameter( "mode" );
	mod_id					=	request.getParameter( "mod_id" )==null ?"ST":request.getParameter("mod_id");
	bean_id					=	"TransactionRemarksBean";
	bean_name				=	"eMM.TransactionRemarksBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	TransactionRemarksBean bean = (TransactionRemarksBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
//	MmUtils objMmUtils	=	new MmUtils( bean.getProperties() );
	/* Mandatory checks end */

	/* Initialize Function specific start */
	try
	{
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setModuleID(mod_id) ;
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
 <table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">

	<table cellpadding=0 cellspacing=0 border="1" align=center>
	<tr>
		<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		 <th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<!-- <th >Module ID</th> -->
		<!-- <th  style="display:none"><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></th> --> 
	</tr>
<%
	for(rowIndex=0; rowIndex<totalRecords; rowIndex++)
	{
		classValue	=	( (rowIndex%2)==0 )	?	"QRYEVEN"	:	"QRYODD";

%>
	<tr>
		<td class="<%=classValue%>" class='UPPER'><input type="text" name="trn_remarks_code<%=rowIndex%>" id="trn_remarks_code<%=rowIndex%>"  size="10" maxlength="10" <%=codeReadOnly%> accesskey='C' onKeyPress="return CheckForSpecChars(event)" onBlur="parent.resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);" onChange="putval('module_id','<%=rowIndex%>','<%=mod_id%>')" >
			<input type="hidden" name="module_id<%=rowIndex%>" id="module_id<%=rowIndex%>"  size="5" maxlength="2" <%=readOnly%>  onBlur="parent.resetColorCode(this);makeValidString(this);" >
		</td>
		<td class="<%=classValue%>"><input type="text" name="remarks_desc<%=rowIndex%>" id="remarks_desc<%=rowIndex%>"  size="40" maxlength="200" <%=readOnly%>  onBlur="parent.resetColorCode(this);makeValidString(this);" onChange="putval('module_id','<%=rowIndex%>','<%=mod_id%>')"></td>
		<td class="<%=classValue%>" ><input type="checkbox" name="eff_status<%=rowIndex%>" id="eff_status<%=rowIndex%>" <%=checked%> value="E"  checked></td>
		 <input type ="hidden" name ="trn_type<%=rowIndex%>"	value="ADJ"> 

		
	</tr>
<%
	}
%>
	</table>
	</td></tr>
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

