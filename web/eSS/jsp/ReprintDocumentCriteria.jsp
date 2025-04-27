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
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
06/03/2015	IN054317		VijayakumarK	06/03/2015							CRF-SS- AAKH-CRF-0057.2 /02 - Issues in
																				Reprint document [IN:054317]
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*,eSS.*,eSS.Common.*,eCommon.Common.*,java.sql.*,java.lang.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<!-- 	<script language="javascript" src="../../eSS/js/SsMessages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eSS/js/ReprintDocument.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String p_trn_type = request.getParameter("p_trn_type") == null ? ""
			: request.getParameter("p_trn_type");
	String bean_id = "RePrintDocReportBean";
	String bean_name = "eSS.RePrintDocReportBean";
	String facility_id = (String) session.getValue("facility_id");
	System.out.println(facility_id);
	String user_name = (String) session.getValue("login_user");
	HashMap alstartdate 	= 		 null; //IN054317
	RePrintDocReportBean bean = (RePrintDocReportBean) getBeanObject(
			bean_id, bean_name, request);
	String display_flag = "";
	String to_date = com.ehis.util.DateUtils.getCurrentDate("DMY",
			locale).toString();
	alstartdate 	=  bean.getDurationforStartDate(); //IN054317
	//String from_date = com.ehis.util.DateUtils.minusDate(to_date,"DMY", locale, 1, "M").toString();//IN054317
	String from_date  = com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);//IN054317
	bean.clear();
	bean.setLanguageId(locale);
%>
<body onLoad="FocusFirstElement();">
	<form name="ReprintDocumentCriteria" id="ReprintDocumentCriteria"
		action="../../eCommon/jsp/report_options.jsp" target="messageFrame"
		onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%'
			align='center' height='100%'>
			<td width='100%' align='center' class="WHITE" height='100%'>
				<table cellpadding="0" cellspacing="0" width="90%" align="center"
					border="0" height='100%'>
					<th colspan=5 align=left><fmt:message
							key="Common.reportcritera.label" bundle="${common_labels}" /></th>
					<tr>
						<td class="label" colspan='4'>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message
								key="Common.Transaction.label" bundle="${common_labels}" /></td>
						<td>&nbsp;&nbsp;<select name="p_trn_type" id="p_trn_type"
							onblur="populateDocTypeCode(this.value);">
								<%=bean.getTransction_code_List()%>
						</select><%=bean.getImage("M")%>
						</td>

						<td class="label"><fmt:message key="Common.DocType.label"
								bundle="${common_labels}" /></td>
						<td>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code">
								<%
									String select_option = "<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"
											+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,
													"Common.defaultSelect.label", "common_labels")
											+ " ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
								%>
								<%=select_option%>
								<%out.println("populateDocTypeCode(ReprintDocumentCriteria.p_trn_type.value)");%>
						</select>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.Store.label"
								bundle="${mm_labels}" /></td>
						<td>&nbsp;&nbsp;<input maxLength=45 size=45 name="store_desc" id="store_desc">
							<input class="button"
							onClick="return searchCodeStore(store_code,store_desc);"
							type="button" value="?"> <input type="hidden"
							name="store_code" id="store_code" value=""></td>
						<td class="label"><fmt:message key="Common.DocNo.label"
								bundle="${common_labels}" /></td>
						<td>&nbsp;&nbsp;<input class="NUMBER" type="text" size="8"
							maxlength="8" onKeyPress="return isValidInteger();" name="doc_no" id="doc_no"
							onBlur="return checkIntegerFormat(this);"></td>
					</tr>
					<tr>
						<td class=label align=left><fmt:message
								key="eSS.PeriodFromDate.label" bundle="${ss_labels}" /></td>
						<td>&nbsp;&nbsp;<input type=text name="p_fr_doc_date" id="p_fr_doc_date" size=10
							maxlength=10 class="DATE" value="<%=from_date%>"
							onBlur="ChekDate(this,'<%=locale%>');"><img
							src="../../eCommon/images/CommonCalendar.gif"
							onClick="return showCalendar('p_fr_doc_date');"></img><%=bean.getImage("M")%></td>
						<td class="label" align=left><fmt:message
								key="Common.to.label" bundle="${common_labels}" /></td>
						<td>&nbsp;&nbsp;<input type=text name="p_to_doc_date" id="p_to_doc_date" size=10
							maxlength=10 class="DATE" value="<%=to_date%>"
							onBlur="ChekDate(this,'<%=locale%>');"><img
							src="../../eCommon/images/CommonCalendar.gif"
							onClick="return showCalendar('p_to_doc_date');"></img><%=bean.getImage("M")%></td>
					</tr>
					<tr>
						<td class=label align=left><fmt:message
								key="eSS.ConsiderReprintasOriginal.label" bundle="${ss_labels}" />
						</td>
						<td>&nbsp;&nbsp;<input type="checkbox" value=""
							name="reprint_orig" id="reprint_orig"></td>
						<td>&nbsp;</td>

						<td align='right' colspan=4><input type="button"
							class="button" name="search" id="search"
							value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'
							onClick="frmdate();"></td>
					</tr>

					<tr>

					</tr>
				</table>
			</td>
			</tr>
		</table>


		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
		<input type="hidden" name="p_module_id" id="p_module_id" value="SS"> 
		<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_name%>"> 
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id">
		<input type="hidden" name="p_doc_no" id="p_doc_no">
		<input type="hidden" name="p_doc_type_code" id="p_doc_type_code">
		<input type="hidden" name="p_seq_no" id="p_seq_no"> 
		<input type="hidden" name="p_reprint_orig" id="p_reprint_orig"> 
		<input type="hidden" name="dest_locn_type" id="dest_locn_type" value="S"> 
		<input type="hidden" name="dest_locn_code" id="dest_locn_code" value="PARAMETER_WILL_BE_PASSED"> 
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>"> 
		<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP" value="<%=eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
	</form>
	<%
		putObjectInBean(bean_id, bean, request);
	%>

</body>
</html>


