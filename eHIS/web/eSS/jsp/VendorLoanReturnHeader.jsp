<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eSS.VendorLoanReturnBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="we" class="eSS.VendorLoanReturnBean"/>
<html>
	<head>
<%		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/VendorLoanReturn.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
	<%
		String mode				=		request.getParameter("mode");
		String entryDisabled	=		"";
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode					=		mode.trim();
				
		String bean_id			=		"VendorLoanReturnBean";
		String bean_name		=		"eSS.VendorLoanReturnBean";
		String function_id		=		request.getParameter("function_id");
		String disabled			=		"";
		String entry_checked	=		"";
		String doc_type_code	=		"";
		String doc_no			=		"";
		String docNoDisabled				=		"";
		
		
		VendorLoanReturnBean bean	=		(VendorLoanReturnBean) getBeanObject( bean_id, bean_name,  request);
		bean.setFunctionId(bean.checkForNull(function_id));
		bean.setMode(mode);
		bean.setLanguageId(locale);
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			 entry_checked			=		"checked";
			 HashMap alstartdate           = bean.getDurationforStartDate();
		     String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
			 String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
			 bean.setFrom_date(currentdateminus);
			 bean.setTo_date(currentdate);
		}
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			disabled	= "disabled";
			doc_type_code					=		request.getParameter("doc_type_code");
			doc_no							=		request.getParameter("doc_no");
			if (( doc_type_code== null )||( doc_no== null )) {
				return;
			}			
			bean.setDoc_no(doc_no) ;
			bean.setDoc_type_code(doc_type_code) ;
			bean.loadData() ;
			if(bean.getEntry_completed_yn().equals("Y")) entryDisabled="disabled";		
		}
		
		String strEnterdByName="";
		String strEnterdById=bean.getLoginById();
		bean.setAdded_by_id(strEnterdById);
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
	<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
		<form name="formVendorLoanReturnHeader" id="formVendorLoanReturnHeader" onReset='FocusFirstElement();'>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocAutoNo(doc_type_code);" <%=disabled%>><%=bean.getDoc_type_code_List()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" disabled value="<%=bean.getDoc_no()%>"></td>
					<td  class="label" colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.FromStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_from_store_code" id="return_from_store_code" <%=disabled%>><%=bean.getReturn_from_store_code_List()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.ToVendor.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_to_vendor_code" id="return_to_vendor_code" <%=disabled%>><%=bean.getReq_on_vendor_code_List()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td class="label"><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="request_type" id="request_type" <%=disabled%>><%=bean.getRequest_type_List()%></select></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.FromDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getFrom_date(),"DMY","en",locale)%>" name="from_date"  maxLength="10" size="10" <%=disabled%> onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');" <%=disabled%>></img></td>
					<td  class="label"><fmt:message key="eSS.ToDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getTo_date(),"DMY","en",locale)%>" name="to_date"  maxLength="10" size="10" <%=disabled%> onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" <%=disabled%>></img></td>
					<td class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;
						<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
						<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="checkbox" value="Y"  name="entry_completed_yn" id="entry_completed_yn" <%=entryDisabled%> <%=entry_checked%> <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>
					<td colspan='2'>&nbsp;</td>
					<td colspan='2'><input type="button" value="Search" class="BUTTON" onClick="callVendorLoanSearch();" <%=disabled%>></td>
				</tr>
				</table>
				</td>
				</tr>
				<tr style="display:none"><td id="hiddenData"></td></tr>
			</table>
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"  value="-1">
			<input type="hidden" name="function_id" id="function_id"				value="<%=function_id%>">
			<input type='hidden' name="authorized" id="authorized"				value="">
			<input type='hidden' name="autono_yn" id="autono_yn"				value="No">
			<input type='hidden' name="selectedTrayDetails" id="selectedTrayDetails"		value="-1">
			<input type='hidden' name="trn_type" id="trn_type"				value="RTV">
			<input type='hidden' name="selectedLoanReturnDocNos" id="selectedLoanReturnDocNos" value ="" >
			<input type='hidden' name="update_trays" id="update_trays"			value="">
			<input type='hidden' name="delete_trays" id="delete_trays"			value="">
			
		<%
		putObjectInBean(bean_id,bean,request); 
		%>

		</form>
	</body>
</html>
<script>
if('2'=='<%=mode%>')
	callVendorLoanSearch();
</script>

