<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 


<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Packing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code;
	String doc_no;
	
	mode					=		request.getParameter( "mode" ) ;
	bean_id					=		"packingBean" ;
	bean_name				=		"eSS.PackingBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	PackingBean bean		=		(PackingBean)getBeanObject( bean_id,bean_name, request );
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));

	bean.setMode(mode) ;
	bean.setSession(session) ;
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		doc_type_code=request.getParameter("doc_type_code");
		doc_no=request.getParameter("doc_no");
		if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setDoc_no(doc_no) ;
		bean.setDoc_type_code(doc_type_code) ;
		bean.loadData() ;
	}
%>
	<body onload="FocusFirstElement();">
		<form name="formPackingHeader" id="formPackingHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" disabled>
						<%=bean.getDoc_type_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td align="left" class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="8" size="8" disabled><%=bean.getMandatoryImageTag()%></td>
					<td align="left" class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" name="doc_date"  maxLength="10" size="10" disabled><%=bean.getMandatoryImageTag()%></td>
				</tr>			
				<tr>
					<td align="left" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code" disabled>
					<%=bean.getStore_code()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td align="left" class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="service_location" id="service_location" disabled>
					<%=bean.getService_location_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td align="left" class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="15" size="15"  disabled></td>
				</tr>			
				<tr>
					<td align="left" class="label"><fmt:message key="eSS.Sterilize.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="sterilize_yn" id="sterilize_yn" disabled <%=bean.getChecked(bean.getSterilize_yn())%> ></td>
					<td align="left" class="label"><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="wash_yn" id="wash_yn" disabled <%=bean.getChecked(bean.getWash_yn())%> ></td>
					<td align="left" class="label"><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="pack_yn" id="pack_yn" disabled <%=bean.getChecked(bean.getPack_yn())%> ></td>
				<tr>			
			</table>
			<input type="hidden" name="records_to_pack" id="records_to_pack"			value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			
		</form>
		<%
		
			putObjectInBean(bean_id,bean,request);
		%>
	</body>
</html>

