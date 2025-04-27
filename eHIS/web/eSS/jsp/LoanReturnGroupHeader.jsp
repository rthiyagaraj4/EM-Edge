<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.LoanReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="we" class="eSS.LoanReturnGroupBean"/>
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
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				=		request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode					=		mode.trim();
				
		String bean_id			=		"LoanReturnGroupBean";
		String bean_name		=		"eSS.LoanReturnGroupBean";
		String function_id		=		request.getParameter("function_id");
		String disabled			=		"";
		String entry_checked	=		"";//Added By Sakti against BRU-HIMS-CRF-360 to default check entry completed

		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			 entry_checked			=		"checked";
		}
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			disabled			=		"disabled";
		}
		LoanReturnGroupBean bean	=		(LoanReturnGroupBean) getBeanObject( bean_id, bean_name,  request);		
		bean.setFunctionId(bean.checkForNull(function_id));
		bean.setMode(mode);
		bean.setLanguageId(locale);

		//To get Entered By User Name from User ID
			String strEnterdByName="";
			String strEnterdById=bean.getLoginById();
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
	<body onLoad="FocusFirstElement();isUpdationAllowed();" onMouseDown="CodeArrest()">
		<form name="formLoanReturnGroupHeader" id="formLoanReturnGroupHeader" onReset='FocusFirstElement();'>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocAutoNo(doc_type_code);" <%=disabled%>><%=bean.getDoc_type_code_List()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" disabled value="<%=bean.getDoc_no()%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" maxLength="10" size="10" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.ReturnFrom.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_from" id="return_from" <%=disabled%>><%=bean.getReturnFrom(bean.getFr_store_code())%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.ReturnTo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="return_to" id="return_to" <%=disabled%>><%=bean.getReturnTo(bean.getTo_store_code())%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref"  size=15 maxlength=15 value="<%=bean.checkForNull(bean.getDoc_ref())%>"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" name="entry_completed_yn" id="entry_completed_yn" value="Y" <%=entry_checked%> <%=bean.getEntry_completed_yn().equals("Y")?"checked":""%>></td>
					<td class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" name="entered_by" id="entered_by" maxLength="12" size="12" value="<%=bean.getLoginById()%>" disabled>
					<input type="text" name="entered_by_name" id="entered_by_name" maxLength="12" size="12" value="<%=strEnterdByName%>" disabled>
					</td>
					<!-- // Added by Sakti #Inc no:39364 (Bru-HIMS-CRF-360) on 17-May-2013 -->
					<td  align="right" class="label"><fmt:message key="eSS.DisplayGroupsLinkedToPatient.label" bundle="${ss_labels}"/></td>
	                <td  class="label">&nbsp;&nbsp;<select name="patient_order" id="patient_order" >
		            <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		            <option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		            <option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option></select></td>
					<!-- ends-->
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
					<td colspan='2'><input type="button" value="Select Trays" class="BUTTON" onClick="showSelectTray(return_from,return_to);" <%=disabled%>></td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"  value="-1">
			<input type="hidden" name="function_id" id="function_id"				value="<%=function_id%>">
			<input type='hidden' name="finalize_yn" id="finalize_yn"				value="">
			<input type='hidden' name="autono_yn" id="autono_yn"				value="No">
			<input type='hidden' name="selectedTrayDetails" id="selectedTrayDetails"		value="-1">
			<input type='hidden' name="trn_type" id="trn_type"				value="RTL">
			<input type='hidden' name="update_trays" id="update_trays"			value="">
			<input type='hidden' name="delete_trays" id="delete_trays"			value="">
<%

	try{
		/*
			ArrayList alParameters			=		new ArrayList();
			alParameters.add(request.getParameter("module_id"));
			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));

			ArrayList alRequestGroupRecords	=		bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc	=	(HashMap)alRequestGroupRecords.get(i);
hidden filed is removed SS_REQUEST_GROUP_AUTHORIZE
			}*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}
		finally{
			rset.close();
			stmt.close();
			ConnectionManager.returnConnection(con,request);
		}
putObjectInBean(bean_id,bean,request); 
%>
		</form>
	</body>
</html>

