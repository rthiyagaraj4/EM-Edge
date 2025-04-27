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
		<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
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
	String supp_code						=				request.getParameter("supp_code");
	String po_mode							=				request.getParameter("po_mode");
	QuotationBean bean						=				(QuotationBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();

		if(mode.equals("1")){
			System.out.println("supp_code in List.jsp"+supp_code);
			supp_code= supp_code;
			po_mode = po_mode;
		} else if(mode.equals("2")){
		
				 supp_code= bean.getRequest_on_supp();
				 po_mode = bean.getPo_mode();
		}	
			
	/*	String []stParameters =	{supp_code};	
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_SUPP_DTL_SELECT"), stParameters);
		System.out.println("hmRecord in jsp="+hmRecord);
		
		String acc_no=(String)hmRecord.get("ACC_NO");
		String supp_address1 = (String)hmRecord.get("ADD1_DESC");
		String supp_address2 = (String)hmRecord.get("ADD2_DESC");
		String supp_address3 = (String)hmRecord.get("ADD3_DESC");

		System.out.println("supp_address1="+supp_address1+" "+"supp_address2="+supp_address2+" "+"supp_address3="+supp_address3);
	*/	
	

%>
<form name="formQuotAdditionalDetails" id="formQuotAdditionalDetails">
	<table border='0' cellpadding='3' cellspacing='0'    scrolling=yes>
	   <tr>
				<td colspan = '3'>&nbsp;</td>
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.QuotPaymentTerms.label" bundle="${po_labels}"/></td>
			<td >&nbsp;&nbsp;<select name="pmnt_term" id="pmnt_term" ><%=bean.getPayment_term()%></select></td>
			<td align="center" class="label" ><fmt:message key="ePO.QuotDeliveryMode.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;<select name="delivery_mode" id="delivery_mode" ><%=bean.loadDelivery_mode()%>
			</select></td> 
			 <td>&nbsp;</td>
			<td align="right" class="label" ><fmt:message key="ePO.QuotTermsAndConditions.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;<select name="terms_conditions" id="terms_conditions" ><%=bean.getTermsandcondition()%>
			</select></td>
		</tr> 
		<tr>
		    <td align="left" class="label" ><fmt:message key="ePO.SubmissiontoAdvt.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getAdvt_date()%>" name="advt_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('advt_date');" ></img>
			</td>
			<td align="center" class="label" ><fmt:message key="ePO.QuotOpenDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getOpen_date()%>" name="open_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('open_date');" ></img>
			</td>
			 <td>&nbsp;</td>
			<td align="left" class="label" ><fmt:message key="ePO.QuotClosedDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getClosed_date()%>" name="closed_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('closed_date');" ></img>
			</td>
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.DrugPurchasingRecordDoc.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getDrug_purchase_date()%>" name="drug_purchase_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('drug_purchase_date');" ></img>
			</td>
			<td align="left" class="label" ><fmt:message key="ePO.QuotClerkRecord.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getClerk_date()%>" name="clerk_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('clerk_date');" ></img>
			</td>
			 <td>&nbsp;</td>
			<td align="right" class="label" ><fmt:message key="ePO.QuotInitialEvaluation.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getInitial_eval_date()%>" name="initial_eval_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('initial_eval_date');" ></img>
			</td>
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.QCResult.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getQc_res_date()%>" name="qc_res_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('qc_res_date');" ></img>
			</td>
			<td align="center" class="label" ><fmt:message key="ePO.QuotCheckedDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getChecked_date()%>" name="checked_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('checked_date');" ></img>
			</td>
			 <td>&nbsp;</td>
			<td align="left" class="label" ><fmt:message key="ePO.QuotMeetingDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getMeeting_date()%>" name="meeting_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('meeting_date');" ></img>
			</td>
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.QuotRecordAfterMeeting.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getAfter_meeting_date()%>" name="after_meeting_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('after_meeting_date');" ></img>
			</td>
			
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePO.SubmittedforApproval.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getSubmitted_date()%>" name="submitted_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('submitted_date');" ></img>
			</td>
			<td align="center" class="label" ><fmt:message key="ePO.QuotApprovedDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getApproved_date()%>" name="approved_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('approved_date');" ></img>
			</td>
		</tr>
		<tr>
		  <td align="left" class="label" ><fmt:message key="ePO.QuotContactPerson.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value = "<%=bean.getContact_person()%>" name="contact_person" size='30' maxLength='30' ></td> 
			<td align="right" class="label"><fmt:message key="ePO.QuotationRemarksQuot.label" bundle="${po_labels}"/></td>
			<td class="fields"   colspan='3' >&nbsp;<textarea   name="quotation_remarks" rows='4' cols='40' onBlur="SPCheckMaxLen('Item Remarks',this,400);" onPaste="checkMaxLengthPaste(this,400);" onKeyPress="checkMaxLimit(this,400);" ><%=bean.getQuotation_remarks()%></textarea>
			<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=bean.getQuotation_remarks()%>" >
			<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,quotation_remarks);">
			</td>
			 
			 
		</tr>
		<tr>
		</tr>
		<tr>
				 
				<td colspan = '3'>&nbsp;</td>
				<td colspan = '3'>&nbsp;</td>
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
	<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="POQUOT">
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

