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
		String bean_id			=		"VendorLoanReturnBean";
		String bean_name		=		"eSS.VendorLoanReturnBean";
		String function_id		=		request.getParameter("function_id");
		
		String entry_checked	=		"";
		VendorLoanReturnBean bean	=		(VendorLoanReturnBean) getBeanObject( bean_id, bean_name,  request);
		
		HashMap alstartdate           = bean.getDurationforStartDate();
		   String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
		String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		bean.setFrom_date(currentdateminus);
		bean.setTo_date(currentdate);
		
		bean.setFunctionId(bean.checkForNull(function_id));		
		bean.setLanguageId(locale);
		String strEnterdById=bean.getLoginById();
		bean.setAdded_by_id(strEnterdById);
	%>
	<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
		<form name="formVendorLoanReturnQueryCriteria" id="formVendorLoanReturnQueryCriteria" action="../../eSS/jsp/VendorLoanReturnQueryResult.jsp" method="post" target="frameVendorLoanReturnQueryResult" onReset='FocusFirstElement();'>
			
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"  ><%=bean.getDoc_type_code_List()%></select></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onKeyPress="return isValidInteger();"></td>
					<td class="label"><fmt:message key="eSS.FromStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_from_store_code" id="return_from_store_code"><%=bean.getReturn_from_store_code_List()%></select></td>
					<td  class="label"><fmt:message key="eSS.ToVendor.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_to_vendor_code" id="return_to_vendor_code" ><%=bean.getReq_on_vendor_code_List()%></select></td>					
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="eSS.FromDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getFrom_date(),"DMY","en",locale)%>" name="from_date"  maxLength="10" size="10"  onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');" ></img></td>
					<td  class="label"><fmt:message key="eSS.ToDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getTo_date(),"DMY","en",locale)%>" name="to_date"  maxLength="10" size="10"  onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" ></img></td>
					<td  class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>
					<td><input type="submit" value="Search" class="BUTTON"></td>
					<td>&nbsp;</td>
				</tr>				
				</table>
				<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
				<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
							
				<%
				putObjectInBean(bean_id,bean,request); 
				%>
		</form>
	</body>
</html>

