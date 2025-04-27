<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>



<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha">

<%
	String locale= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Washing.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<jsp:useBean id="bean" scope="page" class="eSS.WashingBean"/>
<body onload="FocusFirstElement();getSearchDetails();" onMouseDown="CodeArrest()">
<%
	String codeDisabled			=		"";
	String mode					=		"";
	String bean_id				=		"";
	String bean_name			=		"";

	/* Mandatory checks start */
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"WashingBean" ;
	bean_name					=		"eSS.WashingBean";


	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	// WashingBean bean			=		(WashingBean)getBeanObject( bean_id, bean_name,request) ;  
	bean.setLoginFacilityId((String) session.getAttribute("facility_id"));
	bean.setLoginById((String) session.getAttribute("login_user")) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setSession( session) ;
	/* Initialize Function specific end */

%>
		<form name="formWashingCriteria" id="formWashingCriteria" onReset="FocusFirstElement();" >
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
				<td  class="label" ><fmt:message key="eSS.WashingUnit.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code" <%=codeDisabled%> >
					<%=bean.getWashingUnit_List()%>
				</select></td>
				
			
				<td class="label"><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type='text' name="load_no" id="load_no"  maxLength='15' size='15' <%=codeDisabled%> onKeyPress="return isValidNumber(this,event,<%=bean.getCurrencyFormat()%>);"  >
				</td>       
              
				
			</tr>
			<tr>
				<td class="label"><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="washing_type" id="washing_type" <%=codeDisabled%> >
					<%=bean.getWashingType_List()%>
				</select>
				</td>
				<td>&nbsp;</td>
				<td class="label" colspan=2>&nbsp;&nbsp;<input type='button' class='BUTTON' value='Search'  onClick="getSearchDetails();"  name="Alternategroup_search" id="Alternategroup_search">
				</td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="records_to_delete" id="records_to_delete" value="">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

