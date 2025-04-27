<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		
		<style>
			table {
 				 border-spacing: 40px;
				}	
		</style>
		
		
		

		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/CancelRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%

	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code;
	String doc_no;

	
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"cancelRequestBean" ;
	bean_name					=		"eSS.CancelRequestBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	CancelRequestBean bean		=		(CancelRequestBean) getBeanObject( bean_id,  bean_name, request );
	bean.setLanguageId(locale) ;
	bean.clear() ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setAdded_by_id(bean.getLoginById());

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		doc_type_code			=		request.getParameter("doc_type_code");
		doc_no					=		request.getParameter("doc_no");

		if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setDoc_no(doc_no) ;
		bean.setDoc_type_code(doc_type_code) ;
		bean.loadData() ;
	}

	//To get Entered By User Name from User ID

			String strEnterdByName="";
			String strEnterdById=bean.getAdded_by_id();
			String strLocale=(String) session.getValue( "LOCALE" ) ;
			Connection con=ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rset=null;
			rset = stmt.executeQuery("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+strLocale+"' and APPL_USER_ID='"+strEnterdById+"'") ;
			
			if(rset !=null)	{
				if(rset.next()) {
					strEnterdByName = rset.getString("APPL_USER_NAME");
				}
			}
%>
	<body onload="FocusFirstElement();"onMouseDown="CodeArrest()">
		<form name="formCancelRequestHeader" id="formCancelRequestHeader"onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onChange="checkDoc_type_code()" disabled>
						<%=bean.getDoc_type_code_List()%>
					</select></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="8" size="8" disabled></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" name="doc_date"  maxLength="10" size="10" disabled ></td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="req_by_store_code" id="req_by_store_code" disabled>
					<%=bean.getReq_by_store_code_List()%>
					</select></td>
					<td class="label"><fmt:message key="eSS.RequestedOn.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="req_on_store_code" id="req_on_store_code" disabled>
					<%=bean.getReq_on_store_code_List()%>
					</select></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="15" size="15"  disabled></td>
				</tr>			
				<tr>
				<td class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
					</td>
					<td  class="label"><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="request_type" id="request_type" disabled>
					<%=bean.getRequest_type_List()%>
					</select></td>
					<td colspan=2>&nbsp;</td>
				</tr>			
				<tr>
					<td class="label"><fmt:message key="eSS.CancellationRemarks.label" bundle="${ss_labels}"/></td>
					<td  colspan=5>&nbsp;&nbsp;<textarea cols='43' rows='3' name="cancelled_remarks"  style="resize: none; overflow-y: scroll;" onKeyPress="return setTextAreaMaxLength(this,200);" onBlur="checkSetTextAreaMaxLength(this,200);" ></textarea><%=bean.getMandatoryImageTag()%></td>
				</tr>			
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%= bean.getFunctionId() %>">
		</form>
<%
try{
	putObjectInBean(bean_id,bean,request);
}
catch (Exception exception) {
}
finally{
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

