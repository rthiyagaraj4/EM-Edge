<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.AdditionalDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/Tender.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			//function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body >
<%
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String doc_date							=				request.getParameter("doc_date");
	
	TenderBean bean							=				(TenderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();
	

	
%>
<form name="formTndrAdditionalDetails" id="formTndrAdditionalDetails">
	<table border='0' cellpadding='3' cellspacing='0'    scrolling=yes>
	   <tr>
				<td colspan = '2'>&nbsp;</td>
		</tr>
		
		<tr>
		    <td align="left" class="label" ><fmt:message key="ePO.TndrExpiryDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getExpiry_date())%>" name="expiry_date"  maxLength="10" size="10"  onBlur="CheckDate(this);checkExpDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');" ></img>
			</td>
			<td align="center" class="label" ><fmt:message key="ePO.TndrApprovalDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getApproval_date())%>" name="approval_date"  maxLength="10" size="10"  onBlur="CheckDate(this);checkApprovalDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('approval_date');" ></img>
			</td>
			 
			 
		</tr>
		
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.ContractSignDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getContract_date())%>" name="contract_date"  maxLength="10" size="10"  onBlur="CheckDate(this);checkContractDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('contract_date');" ></img>
			</td>
			
			<td align="right" class="label"><fmt:message key="ePO.TenderRemarks.label" bundle="${po_labels}"/></td>
			<td class="fields"   colspan='3' >&nbsp;<textarea   name="tender_remarks" rows='4' cols='40' onBlur="SPCheckMaxLen('Tender Remarks',this,400);" onPaste="checkMaxLengthPaste(this,400);" onKeyPress="checkMaxLimit(this,400);" ><%=bean.checkForNull(bean.getTender_remarks())%></textarea>
			<!-- 03-JULY-2013-->
			<!--<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,tender_remarks);"> -->
			</td>
			
		 
			
			
			 
			 
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
				 
				<td colspan = '2'>&nbsp;</td>
				<td colspan = '2'>&nbsp;</td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="OK"  onClick="exitAdditionalDetails();">
				</td>
		</tr>
	</table>
	
	<input type="hidden" 	name=sys_date				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
	<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="POTNDR">
	<input type="hidden"	name="doc_date" id="doc_date"						value="<%=doc_date%>">
	<input type="hidden"    name="remarks_code_2" id="remarks_code_2"          >
	
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

