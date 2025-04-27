<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import=" eSS.*,eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale = (String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/Store.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onload="FocusFirstElement();" onMouseDown="CodeArrest()">
<%
	String disabled			=	"";
    String disabled1		=	"disabled";
	String disabled2		=	"";
	String codeDisabled		=	"";
	String mode				=	"";
	String bean_id			=	"";
	String bean_name		=	"";
	
	/* Mandatory checks start */
	mode					=	request.getParameter( "mode" ) ;
	bean_id					=	"SSStoreBean" ;
	bean_name				=	"eSS.StoreBean";

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	StoreBean bean = (StoreBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	/* Initialize Function specific end */

   	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		if (null == request.getParameter( "store_code" ) )
			return;		
		bean.setStore_code(request.getParameter( "store_code" )) ;
		bean.loadData() ;
		disabled = bean.isStoreDisabled()?"disabled":"";

			String stOwner_storeYN=bean.getOwner_yn( ) ;
			if(stOwner_storeYN.equals("N"))
			{
			  disabled1="disabled" ; 
			}
			else
			{
			  if(disabled.equals("disabled"))
				 disabled1="disabled" ;
			  else
				 disabled1="enabled" ;

			  disabled2="disabled" ;
			}
	}
  	bean.setLanguageId(locale);
	
%>
    <form name="formStore" id="formStore"   onreset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
		<td width='100%' align='center' class="WHITE">
		<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td align='right' class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
            <% if(disabled.equals("disabled")){ %>
			<td>&nbsp;&nbsp;<select name="store_code" id="store_code" <%=codeDisabled%>><option value="disabled"><%=bean.getStore_desc()%></option></select><%=bean.getMandatoryImageTag()%></td>

<% } else { %>
			<td>&nbsp;&nbsp;<select name="store_code" id="store_code" <%=codeDisabled%>><%=bean.getStore_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
<% } %>

		</tr>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type="checkbox" value="Y" name="owner_yn" id="owner_yn" onClick="doCheckUnCheck();" <%=bean.getChecked(bean.getOwner_yn())%> <%=codeDisabled%>>
					</td>
			</tr>
			<tr>
				<td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			<tr>
				<td class='WHITE' colspan=2>&nbsp;</td>
			</tr>
			<tr>
			<td colspan='2'>
			<table border="1" cellpadding="0" cellspacing="0" width='100%' align='center'>
				<tr>
					<th><fmt:message key="eSS.Transaction.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>	
						<td class='QRYODD' width='50%'><fmt:message key="eSS.PrepareGroup.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="pre_allowed_yn" id="pre_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getPre_allowed_yn())%> <%=disabled1%>></td>
						
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></td>
						<td class='QRYEVEN' align='center'>&nbsp;<input type="checkbox" value="Y" name="req_allowed_yn" id="req_allowed_yn" <%=bean.getChecked(bean.getRtg_allowed_yn())%> <%=disabled%>></td>
				</tr>
				<tr>

						<td class='QRYODD'><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="iss_allowed_yn" id="iss_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getIss_allowed_yn())%> <%=disabled1%>></td>
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/></td>
						<td class='QRYEVEN' align='center'>&nbsp;<input type="checkbox" value="Y" name="rtg_allowed_yn" id="rtg_allowed_yn" <%=bean.getChecked(bean.getRtg_allowed_yn())%> <%=disabled%>></td>
				</tr>
				<!--Added for CRF#Bru-HIMS-CRF-225 and inc#32071-->
				<tr>
						<td class='QRYODD'><fmt:message key="eSS.RequestForLoan.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="rql_allowed_yn" id="rql_allowed_yn" onClick="" <%=bean.getChecked(bean.getRql_allowed_yn())%> <%=disabled2%> ></td>
				</tr>

				<tr>
						<td class='QRYODD'><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="isl_allowed_yn" id="isl_allowed_yn" onClick="" <%=bean.getChecked(bean.getIsl_allowed_yn())%> <%=disabled2%>></td>
				</tr>

				<tr>
						<td class='QRYODD'><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="rtl_allowed_yn" id="rtl_allowed_yn" onClick="" <%=bean.getChecked(bean.getRtl_allowed_yn())%> <%=disabled2%>></td>
				</tr>

				<!--Added ends-->
				<tr>

						<td class='QRYODD'><fmt:message key="eSS.ReturnInstrument.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="rti_allowed_yn" id="rti_allowed_yn" <%=bean.getChecked(bean.getRti_allowed_yn())%> <%=disabled%>></td>
				</tr>
				<tr>

						<td class='QRYEVEN'><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></td>
						<td class='QRYEVEN' align='center'>&nbsp;<input type="checkbox" value="Y" name="trd_allowed_yn" id="trd_allowed_yn"  <%=bean.getChecked(bean.getTrd_allowed_yn())%> <%=disabled%>></td>
				</tr>
				<tr>	
						<td class='QRYODD'><fmt:message key="eSS.WriteOff.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="adj_allowed_yn" id="adj_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getAdj_allowed_yn())%> <%=disabled1%>></td>
				</tr>
				<tr>

						<td class='QRYEVEN'><fmt:message key="eSS.Variance.label" bundle="${ss_labels}"/></td>
						<td class='QRYEVEN' align='center'>&nbsp;<input type="checkbox" value="Y" name="var_allowed_yn" id="var_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getVar_allowed_yn())%> <%=disabled1%>></td>
				</tr>
				<tr>

						<td class='QRYODD'><fmt:message key="eSS.SterilizationRequest.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="rof_allowed_yn" id="rof_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getRof_allowed_yn())%> <%=disabled1%>></td>
				</tr>
					<!--Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015-->
				<tr>

						<td class='QRYEVEN'><fmt:message key="eSS.RequestLoanFromVendor.label" bundle="${ss_labels}"/></td>
						<td class='QRYEVEN' align='center'>&nbsp;<input type="checkbox" value="Y" name="rqv_allowed_yn" id="rqv_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getRqv_allowed_yn())%> <%=disabled1%>></td>
				</tr>
				<tr>

						<td class='QRYODD'><fmt:message key="eSS.ReturnVendorLoan.label" bundle="${ss_labels}"/></td>
						<td class='QRYODD' align='center'>&nbsp;<input type="checkbox" value="Y" name="rtv_allowed_yn" id="rtv_allowed_yn" onClick="return isOwner_YNChecked();" <%=bean.getChecked(bean.getRtv_allowed_yn())%> <%=disabled1%>></td>
				</tr>
					<!-- Added ends -->
				</table>
			</td>
			</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
            <input type="hidden" name="disable_store" id="disable_store" value="<%=disabled%>">

		</form>	
	</body>
	<% putObjectInBean(bean_id,bean,request);%>
</html>

