<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale					= (String)session.getAttribute("LOCALE");	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/VendorLoanRequest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();formVendorLoanRequestQueryCriteria.submit()'>
	<%
		String mode						=		request.getParameter( "mode" ) ;
		VendorLoanRequestBean bean		=		(VendorLoanRequestBean)getBeanObject( "VendorLoanRequestBean","eSS.VendorLoanRequestBean" , request);  
	
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode(mode) ;
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
		HashMap alstartdate             =        bean.getDurationforStartDate();
		String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
		String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

	%>
		<form name="formVendorLoanRequestQueryCriteria" id="formVendorLoanRequestQueryCriteria" action="../../eSS/jsp/VendorLoanRequestQueryResult.jsp" method="post" target="frameVendorLoanRequestQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code">
							<%=bean.getDoc_type_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td  class="label"><fmt:message key="eSS.RequestedbyStore.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="req_by_store_code" id="req_by_store_code" >
							<%=bean.getReq_by_store_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.RequestedonVendor.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="req_on_vendor_code" id="req_on_vendor_code" >
							<%=bean.getReq_on_vendor_code_List()%></select>
							</td>
				</tr><tr>
					<td class="label"><fmt:message key="eSS.FromDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="from_date" id="from_date" value="<%=currentdateminus%>" size='10' maxLength='10' onBlur='CheckDate(this);'  >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');"></img></td>
					<td class="label"><fmt:message key="eSS.ToDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="to_date" id="to_date" value="<%=currentdate%>" size='10' maxLength='10' onBlur='CheckDate(this);'  >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');"></img></td>
					<td class="label"><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="request_type" id="request_type" >
						<option value="N" ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
						<option value="U" ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="E" ><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td  class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>
					</tr><tr>
					<td  colspan=7 class="label">&nbsp;</td>
					<td class="label" align='right'>&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'>&nbsp;&nbsp;</td></tr>
				</tr>
			</table>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
<%
putObjectInBean("VendorLoanRequestBean",bean,request);
%>
	</form>
	</body>
</html>

