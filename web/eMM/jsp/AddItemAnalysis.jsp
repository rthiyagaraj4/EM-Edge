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
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="JavaScript" src="../../eMM/js/ItemAnalysis.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
</head>
<!-- onKeyDown="return lockKey()" -->
<body onLoad="FocusFirstElement()">
<%
	/* Mandatory checks start */
	String 	mode			=	"",		readOnly	=	"";
	String	 checked		=	"";
	String	bean_id			=	"",		bean_name	=	"";
	String	codeReadOnly	=	"",		classValue	=	"";
	int		totalRecords	=	0,		rowIndex	=	0;
	mode					=	request.getParameter( "mode" );
	bean_id					=	"itemAnalysisBean";
	bean_name				=	"eMM.ItemAnalysisBean";
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	ItemAnalysisBean bean = (ItemAnalysisBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	/* Mandatory checks end */

	/* Initialize Function specific start */
	try
	{
//		ItemAnalysisBean bean = (ItemAnalysisBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
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
<form name="formMasterCode" id="formMasterCode" >
<table border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">
	<table cellpadding=0 cellspacing=0 border="1" align=center>
	<tr>
		<!-- <th align="center">#</th> -->
		<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
<%
	for(rowIndex=0; rowIndex<totalRecords; rowIndex++)
	{
		classValue	=	( (rowIndex%2)==0 )	?	"QRYEVEN"	:	"QRYODD";

%>
	<tr>
		<!-- <td class="<%=classValue%>" align="RIGHT"><label class="LABEL"><%=(rowIndex+1)%>.</label></td> -->
		<td class="<%=classValue%>" class='UPPER'><input type="text" name="item_anal_code<%=rowIndex%>" id="item_anal_code<%=rowIndex%>"  size="10" maxlength="4" <%=codeReadOnly%> accesskey='C' onKeyPress="return CheckForSpecChars(event)" onBlur="parent.resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);"></td>
		<td class="<%=classValue%>"><input type="text" name="long_desc<%=rowIndex%>" id="long_desc<%=rowIndex%>"  size="40" maxlength="40" <%=readOnly%>  onBlur="parent.resetColorCode(this);makeValidString(this);" accesskey='L'></td>
		<td class="<%=classValue%>"><input type="text" name="short_desc<%=rowIndex%>" id="short_desc<%=rowIndex%>" size="15" maxlength="15" onBlur="parent.makeValidString( this );parent.resetColorCode(this);"  <%=readOnly%> accesskey='S'></td>
		<td class="<%=classValue%>" ><input type="checkbox" name="eff_status<%=rowIndex%>" id="eff_status<%=rowIndex%>" <%=checked%> value="E"  checked></td>
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
<script>
	FocusFirstElement();
</script>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

