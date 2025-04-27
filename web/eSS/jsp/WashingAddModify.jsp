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
		<meta name="Author" content="Sudha K.">

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
<%
	String codeDisabled					=			"";
	String mode							=			"";
	String bean_id						=			"";
	String bean_name					=			"";
	/* Mandatory checks start */
	mode								=			request.getParameter( "mode" ) ;
	bean_id								=			"WashingBean" ;
	bean_name							=			"eSS.WashingBean";

	String autoclave_wash_unit_code		=			request.getParameter( "autoclave_wash_unit_code" ) ==null?"":request.getParameter( "autoclave_wash_unit_code" );
	String washing_type					=			request.getParameter( "washing_type" ) ==null?"":request.getParameter( "washing_type" );
	String load_no						=			request.getParameter( "load_no" ) ==null?"":request.getParameter( "load_no" );
	String temperature					=			request.getParameter( "temperature" ) ==null?"":request.getParameter( "temperature" );
	String entry_completed_yn			=			request.getParameter( "entry_completed_yn" ) ==null?"":request.getParameter( "entry_completed_yn" );
    String service_location_desc		=			request.getParameter( "service_location_desc" ) ==null?"":request.getParameter( "service_location_desc" );
    String store_code					=			request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );
    String store_desc					=			request.getParameter( "store_desc" ) ==null?"":request.getParameter( "store_desc" );
	if(temperature.equals("null"))
		temperature						=	"";

	if ( mode == null || mode.equals("") ) 
		return ;
	
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	// WashingBean bean = (WashingBean)getBeanObject( bean_id,  bean_name, request) ; 
	bean.setLoginFacilityId((String) session.getAttribute("facility_id"));
	bean.setLoginById((String) session.getAttribute("login_user")) ;
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setSession( session) ;
	bean.initSsParameter();
	bean.initStore_code();
	bean.initDoc_type_code();
	/* Initialize Function specific end */
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		
		codeDisabled	= "disabled";
		
		bean.setAutoclave_wash_unit_code(autoclave_wash_unit_code) ;
		bean.setWashing_type(washing_type) ;
		bean.setLoad_no(load_no) ;
		bean.setTemperature(temperature) ;
        bean.setServiceLocationDesc(service_location_desc) ;
		bean.setStore_code(store_code);
		%>
		<body onMouseDown="CodeArrest()">
		<%}	else {%>
		<body  onLoad=""onMouseDown="CodeArrest()"><%}%>
		<form name="formWashing" id="formWashing" onReset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
				<td class="label"><fmt:message key="eSS.WashingUnit.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code" <%=codeDisabled%> onChange="populateData(this);"><%=bean.getWashingUnit_List()%></select><%=bean.getMandatoryImageTag()%></td>
				<td class="label" >Service Location</td>
				<td>&nbsp;&nbsp;<input type='text' name="service_location" id="service_location"  maxLength='15' size='15' value="<%=bean.getServiceLocationDesc()%>" <%=codeDisabled%> readOnly></td>
				<td class="label"><fmt:message key="eSS.Temperature.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<input type='text' name="temperature" id="temperature"  maxLength='15' size='15' value="<%=bean.getTemperature()%>" <%=codeDisabled%>></td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<input type='text' name="load_no" id="load_no" maxLength='15' size='15' value='<%=bean.getLoad_no()%>' readonly></td>       
				<td class="label"><fmt:message key="eSS.SterReqDocType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="rof_doc_type_code" id="rof_doc_type_code"  <%=codeDisabled%>><%=bean.getROFDocType_List()%></select></td>
                <td class="label"><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="washing_type" id="washing_type" <%=codeDisabled%>><%=bean.getWashingType_List()%></select><%=bean.getMandatoryImageTag()%></td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<% if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {%>
				<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code"  <%=codeDisabled%> ><%=bean.getStoreCode_List()%></select></td>
				<%} else if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
				<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code"  <%=codeDisabled%> ><option><%=store_desc%></option></select></td>
				<%}%>
			    <td class="label"><fmt:message key="eSS.WashingCompleted.label" bundle="${ss_labels}"/></td>
			    <td >&nbsp;&nbsp;<input type=checkbox name='entry_completed_yn' id='entry_completed_yn'  onclick="assignValueHeader(this);"  value="N"  <%=entry_completed_yn.equals("Y")?"checked":""%>></td>
                <td class="label" align=left>&nbsp;</td>
			    <td class="label" align=left>&nbsp;&nbsp;<input type='button' class='BUTTON' value='Get Ster Req Dtls' <%=codeDisabled%> onClick="getRofDtls();"  name="Alternategroup_search"></td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="records_to_delete" id="records_to_delete"	value="">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

