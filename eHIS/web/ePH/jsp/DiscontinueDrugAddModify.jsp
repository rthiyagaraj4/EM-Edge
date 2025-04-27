<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
         <script language="javascript"  src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	    
	
    	<script language="Javascript"  src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript"  src="../js/PhCommon.js"></script>
	    <script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
    	<script language="javascript"  src="../js/DiscontinueDrug.js"></script>
	    <script language="javascript"  src="../js/DrugDetailsDisplay.js"></script>
	    <script language="javascript"  src="../js/DrugNameCommonLookup.js"></script>
		<script language="javascript"  src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start onKeyDown="lockKey()" */
String sql_ph_drug_query_select1		= PhRepository.getPhKeyValue("SQL_PH_REPORTS_DRUG_LOOKUP");
	String mode							= request.getParameter( "mode" ) ;
	String drug_code					= "";
	//String drug_desc					= "";
	String bean_id						= "DiscontinueDrugBean" ;
	String bean_name					= "ePH.DiscontinueDrugBean";
	String checked						= "" ;
	String status_checked				= "" ;
	String status_value					= "" ;
	String load_satus					= "" ;
	String DrugDetail_status			= "disabled";
	String MMEnabled					= "";


	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

/* Mandatory checks end */

/* Initialize Function specific start */
	DiscontinueDrugBean bean = (DiscontinueDrugBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
/* Initialize Function specific end */

	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		drug_code	= request.getParameter("drug_code").trim();
		bean.loadData(drug_code);		
		load_satus="DISABLED";
		DrugDetail_status="Enabled";
		if(!bean.isItemEnabledInMM(drug_code))
			MMEnabled="DISABLED";
	}
%>

<FORM name="DiscontinueDrugForm" id="DiscontinueDrugForm">
<BR><BR><BR>
	<TABLE CELLPADDING="1" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">
	<TH ALIGN="left" COLSPAN="3"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></TH>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" MAXLENGTH="60" SIZE="60" name="DRUG_NAME" id="DRUG_NAME"  VALUE="<%= bean.getDrugName() %>" onBlur ="searchDrugName1(this);" <%=load_satus%> >
		<input type="button" class="button" value="?" name="drug_search" id="drug_search" onclick="searchDrugName1(DRUG_NAME);" >
		<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_code %>"></TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="GENERIC_NAME" id="GENERIC_NAME" VALUE="<%=bean.checkForNull( bean.getGenericName()) %>" SIZE="40" MAXLENGTH="40" DISABLED></TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" VALUE="<%=bean.checkForNull( bean.getStrengthValue()) %>" SIZE="12" MAXLENGTH="12" DISABLED></TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="FORM_OF_DRUG" id="FORM_OF_DRUG" VALUE="<%=bean.checkForNull( bean.getFormOfDrug()) %>" SIZE="20" MAXLENGTH="20" DISABLED></TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="ADMIN_ROUTE" id="ADMIN_ROUTE" VALUE="<%=bean.checkForNull( bean.getAdminRoute()) %>" SIZE="20" MAXLENGTH="20" DISABLED></TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left">&nbsp;<INPUT TYPE="text" name="BASE_UNIT" id="BASE_UNIT" VALUE="<%= bean.checkForNull(bean.getBaseUnit() )%>" SIZE="15" MAXLENGTH="15" DISABLED></TD>
		
		<TD CLASS="Label" COLSPAN="3"><A href onMouseOver="changeCursor(this)" onClick="PatientEducation('<%= drug_code %>')" style="color: #666666;" ><fmt:message key="ePH.PatientEducation.label" bundle="${ph_labels}"/></A></TD>
		   


	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left" WIDTH="60%">

<%
	String chkboxval = bean.getCompoundDrugYN();
	if (chkboxval.equals("Y"))
		checked = "CHECKED";
%>

			<INPUT TYPE="checkbox" name="COMPOUND_DRUG_YN" id="COMPOUND_DRUG_YN" VALUE="<%= chkboxval %>" DISABLED <%= checked %>>
		</TD>
		<TD ALIGN="left" WIDTH="20%"><INPUT TYPE="button" VALUE='<fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/>' CLASS="button" NAME="BTN_DRUG_DETAILS" 
		onclick="loadPage('<%= drug_code %>')"<%=DrugDetail_status%>></TD>
	</TR>
	 <tr>
	<td CLASS="label" ALIGN="right" colspan="3"></td>
	</tr>
	
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">
		<%  if(bean.getDiscontinuedYN().equals("Y")){
		status_value		= "Y" ;
		status_checked="CHECKED";
		}else{
		status_checked="";
		status_value		= "N" ;
		}
		%>
		<!-- 	<INPUT TYPE="checkbox" name="DISCONTINUED_YN" id="DISCONTINUED_YN" CHECKED VALUE="Y" onclick="disableReason(this)"> -->
			<INPUT TYPE="checkbox" name="DISCONTINUED_YN" id="DISCONTINUED_YN"  VALUE="<%=status_value%>" onclick="disableReason(this)" <%=status_checked%> <%=MMEnabled%>>
		</TD>
	</TR>
	<TR>
		<TD CLASS="label" ALIGN="right" WIDTH="20%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></TD>
		<TD ALIGN="left" COLSPAN="2">&nbsp;<INPUT TYPE="text" name="DISCONTINUED_REASON" id="DISCONTINUED_REASON" VALUE="<%=bean.checkForNull(bean.getDiscontinueReason())%>" SIZE="42" MAXLENGTH="40">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" STYLE="visibility:visible" NAME="MANDATE_REASON"></IMG>
		</TD>
	</TR>
	</TABLE>
	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="SQL_PH_DRUG_CODE_LOOKUP" id="SQL_PH_DRUG_CODE_LOOKUP" VALUE="<%=PhRepository.getPhKeyValue( "SQL_PH_DOSG_LMT_SELECT1_TEST") %>">
	<input type="hidden" name="sql_ph_drug_query_select1" id="sql_ph_drug_query_select1" value="<%=sql_ph_drug_query_select1%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

