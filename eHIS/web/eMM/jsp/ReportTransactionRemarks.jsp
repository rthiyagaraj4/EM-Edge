<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.*,java.lang.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
	<head>
	<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//locale ="en";
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
		<!-- <script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
		<script language="javascript" src="../../eMM/js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
	<%
		
		String bean_id = "ReportsMasterCodeBeanMM";
		String bean_name = "eMM.ReportsMasterCodeBeanMM";
		//String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		ReportsMasterCodeBeanMM bean = (ReportsMasterCodeBeanMM) getBeanObject( bean_id, bean_name, request );

		bean.clear();
bean.setLanguageId(locale);		
		
	%>
	<body >
		<form name="formReportTransactionRemarks" id="formReportTransactionRemarks" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center >
			<tr>
			<td width='100%'  class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%"  border="0" align=center>
				<tr>
				<th  colspan='4'> 
				<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr style="display:none">
					<td  class="label" width='35%' >
					<fmt:message key="Common.Module.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  class=fields colspan="2" >&nbsp;&nbsp;<select name="module_id" id="module_id"  >
					<%
					
					ArrayList	arrModule		=	null;
					HashMap		hmModule			=	null;	
					String code = "",	desc		=	"";
					arrModule		=	bean.getModuleList();
					int arrLength	=	arrModule.size();
					String Selected = "";
					for(int i=0;i<arrLength; i++)
					{
						hmModule      		=	(HashMap) arrModule.get(i);

						code				=	(String)hmModule.get("code");
						desc				=	(String)hmModule.get("desc");
						if (code.equals("ST")) Selected ="Selected";
						
						%>
							<option value="<%=code%>" <%=Selected%> ><%=desc%> 
							
						</option>
						<%
					}
						
					%>
					</select></td>
					<td >&nbsp;</td>
					
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" width='35%' >
					<fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
					<td  class=fields  colspan="2">&nbsp;&nbsp;<select name="trn_type" id="trn_type" disabled >
					<%/*
					
					ArrayList	arrTRNType		=	null;
					HashMap		hmTRNType			=	null;	
					String trncode = "",	trndesc		=	"";
					arrTRNType		=	bean.getTRNTypeList();
					int arrLength1	=	arrTRNType.size();
					for(int i=0;i<arrLength1; i++)
					{
						hmTRNType      		=	(HashMap) arrTRNType.get(i);

						trncode				=	(String)hmTRNType.get("code");
						trndesc				=	(String)hmTRNType.get("desc");
						*/
						%>
							
							<option value="ADJ">
							<fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/>
							</option>
						<%
					//}
					
					%>
					</select></td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					</td>
					<td  >&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp
					<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"> 
					<fmt:message key="eMM.TransactionRemarksCode.label" bundle="${mm_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength="10" size="10" name="P_FM_trn_remarks_code" id="P_FM_trn_remarks_code" value="" ><input class="button" onClick="return searchCodeRemarks(P_FM_trn_remarks_code,from_desc);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength="10" size="10" name="P_TO_trn_remarks_code" id="P_TO_trn_remarks_code" value="" ><input class="button" onClick="return searchCodeRemarks(P_TO_trn_remarks_code,to_desc);" type="button" value="?"></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" >
					<fmt:message key="Common.Nature.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="P_eff_status" id="P_eff_status" >
					<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" >
					<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
			<option value='3'><fmt:message key="eMM.TransactionRemarksCode.label" bundle="${mm_labels}"/></option>
			<option value='4'><fmt:message key="eMM.TRNRemarksDescription.label" bundle="${mm_labels}"/></option>
			</select></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="from_desc" id="from_desc" value="" >
			<input type="hidden" name="to_desc" id="to_desc" value="" > 
			<input type="hidden" name="p_dept_from_code" id="p_dept_from_code" value="" >
			<input type="hidden" name="p_dept_to_code" id="p_dept_to_code" value="" >
			<input type="hidden" name="p_mod_id" id="p_mod_id" 			value="ST">
			<input type="hidden" name="p_trn_type" id="p_trn_type" 		value="ADJ">
			<input type="hidden" name="p_module_id" id="p_module_id" 	value="MM">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="MMBTRNRM">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			
			
		</form>
		<input type="hidden" name="SQL_MM_TRN_REMARKS_LOOKUP" id="SQL_MM_TRN_REMARKS_LOOKUP" value="<%= eMM.Common.MmRepository.getMmKeyValue("SQL_MM_TRN_REMARKS_LOOKUP")%>">
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

