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
?			?				?	
03/09/2015	IN057333		Badmavathi B									Date should be defaulted based on parameter setup
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,eSS.Common.*" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eSS/js/VendorLoanAck.js'></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<form name='formAcknowledgeHeader' id='formAcknowledgeHeader'>
		<%
		VendorLoanAckBean bean	=	(VendorLoanAckBean) getBeanObject( "VendorLoanAckBean","eSS.VendorLoanAckBean",request );
			bean.setLanguageId(locale);
			bean.clear();
			String mode				= request.getParameter("mode");
			String req_str			= request.getQueryString();
			SsTransaction bean1	=	(SsTransaction) getBeanObject( "SsTransaction","eSS.Common.SsTransaction",request );
			bean.setLanguageId(locale);
			bean.clear() ;
		
	  
	  HashMap alstartdate           = bean.getDurationforStartDate();//changed from getSysdateMinusdays() for AAKH-CRF-0058 INC057333

      String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);//changed from SYSDATEMINUS7 for AAKH-CRF-0058 INC057333
	  String storeMendatevisibility		= "visibility:hidden";
	   
try{
		%>
		
			<table border="0" cellspacing="0" width="100%" align=center>
				<tr>
					<td class="label"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDoc_type_code_List()%></select><%=bean.getImage("M")%></td>
					<td  class="label"><fmt:message key="eSS.RequestDocNo.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="fields"><input type="text" value="" class="UPPER" name="doc_ref" id="doc_ref"  maxLength="15" size="15" onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" ></td><!--Added onKeyPress and onBlur by B.Badmavathi for AAKH-CRF-0058.1 IN57727-->
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type="text" class="UPPER" value="" name="group_code" id="group_code"  maxLength="15" size="15" ><input type='button' class='BUTTON' value="?" onClick="searchGroupCode(group_code)"></td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="eSS.FromVendor.label" bundle="${ss_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name="fm_vendor_code" id="fm_vendor_code"><%=bean.getVendor_code_List()%></select><%=bean.getImage("M")%></td>
					<td class='label'><fmt:message key="eSS.ToStore.label" bundle="${ss_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name="to_store_code" id="to_store_code"><%=bean.getStore_code_List()%></select></td>
					<td  class="label"><fmt:message key="eSS.RequestFromDate.label" bundle="${st_labels}"/></td>
					<td class='fields'><input type="text" name="req_from_date" id="req_from_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');">
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('req_from_date');"></img></td>
					<td  class="label"><fmt:message key="eSS.RequestToDate.label" bundle="${st_labels}"/></td>
					<td class='fields'><input type="text" name="req_to_date" id="req_to_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('req_to_date');"></img></td>
				</tr>
				<tr>
					<td colspan=7>&nbsp;</td>
					<td class='fields' ><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="checkDocDate(document.forms[0]);"></td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value=<%=mode%>>
			<input type="hidden" name="bean_id" id="bean_id"		value="VendorLoanAckBean">
			<input type="hidden" name="bean_name" id="bean_name"	value="eSS.VendorLoanAckBean">
			<input type="hidden" name="record_saved" id="record_saved"value="N">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_REPORT"		value="<%=bean1.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
			<input type="hidden" name="checkedIndices" id="checkedIndices" >
			<input type="hidden" name="total_records" id="total_records" >
			<%} catch(Exception e) {

				e.printStackTrace();
			}%>
				
		</form>
		
	</body>
</html>
 

