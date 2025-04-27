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
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Dispatch.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>

<jsp:useBean id="bean" scope="page" class="eSS.DispatchBean"/>	
<%
	String codeDisabled			=		"";
	String mode					=		"";
	String bean_id				=		"";
	String bean_name			=		"";
	/* Mandatory checks start */
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"DispatchBean" ;
	bean_name					=		"eSS.DispatchBean";
	


	String doc_type_code;
	String doc_no;
	String doc_date;
	String	store_code;
	String	service_location;
	String	doc_type_desc;
	String	doc_ref;
	String Disable				=		"";

	if ( mode == null || mode.equals("") ) 
		return ;
	
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	// DispatchBean bean			 =		(DispatchBean)getBeanObject( bean_id, bean_name, request  ) ;  
	bean.setLoginFacilityId((String) session.getAttribute("facility_id"));
	bean.setLoginById((String) session.getAttribute("login_user")) ;
	bean.clear() ;
	bean.initialize() ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setSession( session) ;
	bean.RofDocTypeServicelocation();
	
	bean.setDoc_date(bean.getSSParameter().get("SYS_DATE").toString());//Added by Sakti Sankar to display system date by default
	
	
	/* Initialize Function specific end */
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		// System.out.println("dispatchList.size()"+dispatchList.size());
		/*if(dispatchList.size()>0){
			System.out.println("dispatchList.size() inside"+dispatchList.size());
		doc_type_code			=		request.getParameter("rof_doc_type_code");
		doc_no					=		request.getParameter("doc_no");
		doc_date				=		request.getParameter("doc_date");
		store_code				=		request.getParameter("store_code");
		service_location		=		request.getParameter("service_location");
		doc_type_desc			=		request.getParameter("doc_type_desc");
		doc_ref					=		request.getParameter("doc_ref");
		Disable="disabled";
		if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setRof_doc_no(doc_no) ;
		bean.setRof_doc_type_code(doc_type_code) ;
		bean.setLocation(service_location) ;
		bean.setStore_code(store_code) ;
		bean.setDoc_date(doc_date) ;
		bean.setDoc_ref(doc_ref) ;
		}*/
	
		%>
		<body onMouseDown='CodeArrest();'onLoad="searchRofDtls();">
		<%}else{%>
		<body onLoad="searchRofDtls();"  onMouseDown='CodeArrest();' >
		<%}%>
		<form name="formDispatch" id="formDispatch" onReset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
				<td  class="label" ><fmt:message key="eSS.SterReqDocType.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="rof_doc_type_code" id="rof_doc_type_code"  <%=Disable%> >
				<%=bean.getROFDocType_List()%>
				</select></td>
				<td  class="label" ><fmt:message key="eSS.SterReqDocNo.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type='text' name="rof_doc_no" id="rof_doc_no"  maxLength='8' size='8' onKeyPress="return isValidInteger();" class="NUMBER" onBlur="return checkIntegerFormat(this);"  value='<%=bean.getRof_doc_no()%>' <%=Disable%> >
				</td>
				<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type='text' name="doc_date" id="doc_date"  maxLength='10' size='10'  onBlur="return checkValDate(this);" value='<%=bean.getDoc_date()%>' <%=Disable%>>&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" <%=Disable%>></img><%=bean.getMandatoryImageTag()%>
				</td>
			</tr>
			<tr>
				<td  class="label" ><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="service_location" id="service_location"  <%=Disable%> >
				<%=bean.getLocation_List()%>
				</select></td>
				<td  class="label" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="store_code" id="store_code" <%=codeDisabled%> <%=Disable%> >
				<%=bean.getStoreCode_List()%>
				</select></td>
				<td  class="label" ><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type='text' name="doc_ref" id="doc_ref"  maxLength='15' size='15' value='<%=bean.getDoc_ref()%>' <%=Disable%>>
				</td>
			</tr>
			
			<tr>
				<td  colspan=5>&nbsp;</td>
				<td class="label" align=right>&nbsp;&nbsp;<input type='button' class='BUTTON' value='Search' <%=Disable%> onClick="searchRofDtls();"  name="Alternategroup_search">
				</td>
			</tr>
			</table>
			<input type='hidden' name="sysdate" id="sysdate"				value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="records_to_modify" id="records_to_modify" >
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="records_to_delete" id="records_to_delete"	value="">
		</form>
	</body>
</html>

<%
	putObjectInBean(bean_id, bean,request);
%>

