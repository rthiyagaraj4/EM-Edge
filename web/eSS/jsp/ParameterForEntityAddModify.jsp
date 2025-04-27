<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page    import=" eSS.*, eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript'>
	function checking()
	{
		var check=document.formParameterForEntity.bl_interface_yn;
		var blng_code=document.formParameterForEntity.def_blng_serv_code;
		if(check.checked==false)
		{
		blng_code.disabled=true;
		blng_code.value="";
		}
		else if(check.checked==true)
		{
			blng_code.disabled=false;
		}
		
	}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled				=	"";
	String periodEndScopeDisabled	=	"";
	mode							=	"" ;
	bean_id							=	"ParameterForEntityBean" ;
	bean_name						=	"eSS.ParameterForEntityBean";
	ParameterForEntityBean bean		=	(ParameterForEntityBean)getBeanObject( bean_id, bean_name,request   ) ;  

	bean.clear() ;
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLanguageId(locale);
	mode							=	bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");


	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled				=	"disabled";
		bean.loadData();
	}
	periodEndScopeDisabled			=	(bean.getPeriodEndScope().equals("F"))?"disabled":"";
%>
<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
	<form name="formParameterForEntity" id="formParameterForEntity" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td  class='WHITE'>
	<table cellpadding=1 cellspacing=0 align='center' width='98%'>
	<%if(!periodEndScopeDisabled.equals("disabled")){%>
	<tr>
	<td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>	<td class='LABEL' colspan='4' align='center'><fmt:message key="eSS.CurrentProcessingMonthYear.label" bundle="${ss_labels}"/>&nbsp;<input type="text" value="<%=bean.getCurr_proc_month()%>" name="curr_proc_month" class="NUMBER" maxLength='2' size='2' onKeyPress='return isValidInteger();' <%=codeDisabled%> <%=periodEndScopeDisabled%>><input type="text" value="<%=bean.getCurr_proc_year()%>" name="curr_proc_year"  class="NUMBER" maxLength='4' size='4' onKeyPress='return isValidInteger();' <%=codeDisabled%> <%=periodEndScopeDisabled%>><%=bean.getMandatoryImageTag()%>
		</td>
	</tr>
	<%}%>
	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.Interface.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.Billing.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="Y" name="bl_interface_yn" id="bl_interface_yn" <%=bean.getChecked(bean.getBl_interface_yn())%> onClick="checking()" <%=bean.isModuleInstalled("BL")?"":"disabled title='Module not installed'"%>></td>
		<td align="right" class="label"><fmt:message key="eSS.BillingService.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="def_blng_serv_code" id="def_blng_serv_code" <%=bean.getBl_interface_yn().equals("N")?"disabled":""%>  <%=bean.isModuleInstalled("BL")?"":"disabled title='Module not installed'"%>>
			<%=bean. getDef_blng_serv_code_List()%>
			
			</select>
		</td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.GeneralLedger.label" bundle="${ss_labels}"/></TD>
		<td colspan='3' >&nbsp;<input type="checkbox" value="Y" name="gl_interface_yn" id="gl_interface_yn" <%=bean.getChecked(bean.getGl_interface_yn())%> <%=bean.isModuleInstalled("GL")?"":"disabled title='Module not installed'"%>></td>
	</tr>
	<tr><td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.DefaultDocumentTypes.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.PrepareGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_pre_doc_type_code" id="def_pre_doc_type_code">
			<%=bean.getDef_pre_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_req_doc_type_code" id="def_req_doc_type_code">
			<%=bean.getDef_req_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_iss_doc_type_code" id="def_iss_doc_type_code">
			<%=bean.getDef_iss_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtg_doc_type_code" id="def_rtg_doc_type_code">
			<%=bean.getDef_rtg_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<!--Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013-->
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.RequestForLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rql_doc_type_code" id="def_rql_doc_type_code">
			<%=bean.getDef_rql_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_isl_doc_type_code" id="def_isl_doc_type_code">
			<%=bean.getDef_isl_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtl_doc_type_code" id="def_rtl_doc_type_code">
			<%=bean.getDef_rtl_doc_type_code_List()%>
		</select>
		</td>
<!--ENDED-->	
		<td align='right'  class='label'><fmt:message key="eSS.ReturnInstrument.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rti_doc_type_code" id="def_rti_doc_type_code">
			<%=bean.getDef_rti_doc_type_code_List()%>
		</select>
		</td>
	</tr>

	<tr>		
		<td align='right'  class='label'><fmt:message key="eSS.WriteOff.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_adj_doc_type_code" id="def_adj_doc_type_code">
			<%=bean.getDef_adj_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_trd_doc_type_code" id="def_trd_doc_type_code">
			<%=bean.getDef_trd_doc_type_code_List()%>
		</select>		
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.ProcessSterilizationRequest.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rof_doc_type_code" id="def_rof_doc_type_code">
			<%=bean.getDef_rof_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.Variance.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_var_doc_type_code" id="def_var_doc_type_code">
			<%=bean.getDef_var_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<!-- Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 -->
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.RequestLoanFromVendor.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rqv_doc_type_code" id="def_rqv_doc_type_code">
			<%=bean.getDef_rqv_doc_type_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'><fmt:message key="eSS.ReturnVendorLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtv_doc_type_code" id="def_rtv_doc_type_code">
			<%=bean.getDef_rtv_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<!-- Added ends -->
		<tr><td align='left' colspan='4'>&nbsp;</td></tr>

	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.OtherDefaults.label" bundle="${ss_labels}"/></th>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.SterileLife.label" bundle="${ss_labels}"/></td>
		<td colspan="3">&nbsp;&nbsp;<input type="text" value="<%=bean.getDflt_sterile_life()%>" name="dflt_sterile_life" class='NUMBER' maxLength='3' size='3' onKeyPress='return isValidInteger();'>
		</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.ItemImagePath.label" bundle="${ss_labels}"/></td>
		<td colspan="3">&nbsp;&nbsp;<input type="text" value="<%=bean.getItem_image_path()%>" name="item_image_path" maxLength='150' size='50'>
		</td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.WriteoffReason.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="def_write_off_reason_code" id="def_write_off_reason_code">
			<%=bean.getDef_write_off_reason_code_List()%>
		</select>
		</td>
		<td align='right'  class='label'>&nbsp;</TD>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eSS.GenerateSterilizationRequestwhilepreparing.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="Y" name="gen_rof_at_pre_yn" id="gen_rof_at_pre_yn" <%=bean.getChecked(bean.getGen_rof_at_pre_yn())%>></td>
		<td align='right'  class='label'>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr><td align='left' colspan='4'>&nbsp;</td></tr>
	</table>
		</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="ss_period_end_scope" id="ss_period_end_scope" value="<%=bean.getPeriodEndScope()%>">

	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

