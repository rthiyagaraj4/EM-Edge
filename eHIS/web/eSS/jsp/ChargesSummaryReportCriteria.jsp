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
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */ %> 
<%@ page contentType="text/html;charset=UTF-8"  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<jsp:useBean id="bean" scope="page" class="eSS.ReportsMasterCodeBean"/>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/ChargesSummaryReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()"> 
<%
		//SsTransaction bean		=		(SsTransaction)getBeanObject( "ssTransaction", "eSS.Common.SsTransaction",request );       
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		Connection con			= null;//MMOH-CRF-1661 START
		boolean linen_applicable_yn = false;
		try{
			con				= ConnectionManager.getConnection(request);
			linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); //END 
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in ChargesSummaryReportCriteria.jsp");
		}
		finally{
			if(con != null)
	    		ConnectionManager.returnConnection(con,request);  
		}//end  
%>
		
<form name="formChargeSummary" id="formChargeSummary" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='3' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='2' size='2' name="p_fr_facility_id" id="p_fr_facility_id"><input type='button' class='BUTTON' value="?" onClick="searchFacilityID(p_fr_facility_id)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='2' size='2' name="p_to_facility_id" id="p_to_facility_id"><input type='button' class='BUTTON' value="?" onClick="searchFacilityID(p_to_facility_id)"></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_fm_store_code" id="p_fm_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_fm_store_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_to_store_code" id="p_to_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_to_store_code)"></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onBlur="CheckDate(this);" type='text' maxLength='10' size='10' name="p_fm_doc_date1" id="p_fm_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_doc_date1');"></img></td>
		<td>&nbsp;<input onBlur="CheckDate(this);" type='text' maxLength='10' size='10' name="p_to_doc_date1" id="p_to_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name=p_group_type>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="eSS.Set.label" bundle="${ss_labels}"/></option>
		<option value='T'><fmt:message key="eSS.Tray.label" bundle="${ss_labels}"/></option>
		<option value='P'><fmt:message key="eSS.SoftPack.label" bundle="${ss_labels}"/></option>
		<option value='S'><fmt:message key="Common.single.label" bundle="${common_labels}"/></option>
		<%if (linen_applicable_yn){  %><!-- added for MMOH-CRF-1661 --> 
		<option value='L'><fmt:message key="eSS.Linen.label" bundle="${ss_labels}"/></option>  
		<%} %>
		</select></td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"								value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 							value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 							value="SSBCHGSM">
	<input type="hidden" name="p_fm_doc_date" id="p_fm_doc_date" 							value="">
	<input type="hidden" name="p_to_doc_date" id="p_to_doc_date" 							value="">
	<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"						value="<%=bean.getSsRepositoryValue("SQL_SS_STORE_LOOKUP")%>">
	<input type="hidden" name="SQL_SM_FACILITY_PARAM_SELECT_LOOKUP" id="SQL_SM_FACILITY_PARAM_SELECT_LOOKUP"		value="<%=bean.getSsRepositoryValue("SQL_SM_FACILITY_PARAM_SELECT_LOOKUP")%>">
</form>
</body>
</html>
<%
	putObjectInBean("ssTransaction", bean,request);
%>

