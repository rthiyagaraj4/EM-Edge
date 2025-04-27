<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1            V210112             7661	     MOHE-CRF-0050.1        Ram kumar S
2            V210226            15050	     MOHE-CRF-0050.1        Ram kumar S
 -->


<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/IntermDraftReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String facilityId =	"";
	Connection conIntermDraft = ConnectionManager.getConnection();	
	PreparedStatement pstmtIntermDraft = null;
	ResultSet rsIntermDraft = null;

	try  
	{		 
		sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		facilityId =   (String) session.getValue( "facility_id" ) ;
		if(facilityId == null) facilityId="";
		String loginUser	= (String) session.getValue("login_user");
		if(loginUser == null) loginUser="";
		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";
		java.util.Properties p=null;
		p = (java.util.Properties) session.getValue( "jdbc" );
		String WS_NO  = p.getProperty("client_ip_address");
		//Geting function control for Service Date and Billing Service Group
		boolean servDateGrpSiteSpec = false;
		servDateGrpSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(conIntermDraft, "BL","BL_SERVICE_GRP_AND_DATE_FIL");
		//Getting Function Control For Language
		boolean languageSiteSpec = false;
		languageSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(conIntermDraft, "BL","ARABIC_REPORT_PRINT");
		String billStageSql="select DISCHARGE_BILLING_STAGE from bl_parameters "+
				"where OPERATING_FACILITY_ID='"+facilityId+"'";
		String billStageVal="";
		pstmtIntermDraft = conIntermDraft.prepareStatement(billStageSql);
		rsIntermDraft = pstmtIntermDraft.executeQuery() ;
		while(rsIntermDraft.next())
		{
			billStageVal=rsIntermDraft.getString("DISCHARGE_BILLING_STAGE");
		}
		rsIntermDraft.close();
		pstmtIntermDraft.close();		
		
		String siteIdSql="Select CUSTOMER_ID From Sm_Site_Param";
		String siteIdVal="";
		pstmtIntermDraft = conIntermDraft.prepareStatement(siteIdSql);
		rsIntermDraft = pstmtIntermDraft.executeQuery() ;
		while(rsIntermDraft.next())
		{
			siteIdVal=rsIntermDraft.getString("CUSTOMER_ID");
		}		
%>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	style="padding-left: 10px; padding-right: 10px; padding-top: 5px;">
	<form name="IntermDraftReportForm" id="IntermDraftReportForm" id="IntermDraftReportForm"
		action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

		<table width="100%" CELLSPACING='0' cellpadding='3' align='center'>
			<tr>
				<td class="columnheader">Report Criteria</td>
			</tr>
		</table>
		<br>
		<table cellpadding='5' cellspacing='0' width="100%" align="center" border='0'>
			<tr>
				<table align="center">
					<tr>
						<td>
							<table>
									<tr>
										<td class="label" width="10%" colspan="3"><strong style="font-size: 15px;"><fmt:message key="eBL.From.label" bundle="${bl_labels}" /></strong></td>
									</tr>
									<tr><td></td>
									<td class="label"  style="text-align:right; width: 160px;"><fmt:message key="eBL.NursingUnit.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="FrmNursingUnit" id="FrmNursingUnit"
											id="FrmNursingUnit" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') interDraftCommonLookup(FrmNursingUnit,FrmNursingUnitHid,'nurseUnitFrm');   else { FrmNursingUnitHid.value =''; }"
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="FrmNursingUnitlookUp" id="FrmNursingUnitlookUp"
											id="FrmNursingUnitlookUp" value='?'
											onClick="interDraftCommonLookup(FrmNursingUnit,FrmNursingUnitHid,'nurseUnitFrm');"
											tabindex='2' /> <input type="hidden" name="FrmNursingUnitHid" id="FrmNursingUnitHid"
											id="FrmNursingUnitHid" value="">
										</td>
									</tr>
									<tr><td></td>
									<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.AdmissionNo.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="FrmAdmissionNo" id="FrmAdmissionNo"
											id="FrmAdmissionNo" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') {admnolkp(document.forms[0].FrmAdmissionNo,'Frm');onBlurEvent('1'); }   else { FrmAdmissionNo.value =''; }"
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="FrmAdmissionNolookUp" id="FrmAdmissionNolookUp"
											id="FrmAdmissionNolookUp" value='?'
											onClick="admnolkp(document.forms[0].FrmAdmissionNo,'Frm');"
											tabindex='2' /><input type="hidden" name="FrmAdmissionNoHid" id="FrmAdmissionNoHid"
											id="FrmAdmissionNoHid" value="">
										</td>
									</tr>
									<tr id="serdate"><td></td>
									<td class="label"  style="text-align:right; width: 160px;"><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}" /></td>
										<td class='fields' style="text-align:left; width: 160px;"><input type="text" name="frmServDate" id="frmServDate"
											id="frmServDate"  size="15" maxlength='10'  value=''
											onBlur='return dateRegEx(this);'><img
											src="../../eCommon/images/CommonCalendar.gif"
											onClick="return showCalendar('frmServDate');">
										</td>
									</tr>
									<tr id="billservgrp"><td></td>
										<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="FrmBillServGrp" id="FrmBillServGrp"
											id="FrmBillServGrp" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') interDraftCommonLookup(3,FrmBillServGrp,FrmBillServGrpHid,'billServGrp');   else { FrmBillServGrpHid.value =''; onBlurEvent('1'); }"
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="FrmBillServGrplookUp" id="FrmBillServGrplookUp"
											id="FrmBillServGrplookUp" value='?'
											onClick="interDraftCommonLookup(3,FrmBillServGrp,FrmBillServGrpHid,'billServGrp');"
											tabindex='2' /> <input type="hidden" name="FrmBillServGrpHid" id="FrmBillServGrpHid"
											id="FrmBillServGrpHid" value="">
										</td>
									</tr>
							</table>
						</td>
						<td>
							<table>
									<tr>
										<td class="label" width="10%" colspan="3"><strong style="font-size: 15px;"><fmt:message key="eBL.To.label" bundle="${bl_labels}" /></strong></td>
									</tr>
									<tr><td></td>
									<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.NursingUnit.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="ToNursingUnit" id="ToNursingUnit"
											id="ToNursingUnit" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') interDraftCommonLookup(ToNursingUnit,ToNursingUnitHid,'nurseUnitTo');   else { ToNursingUnitHid.value =''; onBlurEvent('1'); }"
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="ToNursingUnitlookUp" id="ToNursingUnitlookUp"
											id="ToNursingUnitlookUp" value='?'
											onClick="interDraftCommonLookup(ToNursingUnit,ToNursingUnitHid,'nurseUnitTo');"
											tabindex='2' /> <input type="hidden" name="ToNursingUnitHid" id="ToNursingUnitHid"
											id="ToNursingUnitHid" value="">
										</td>
									</tr>
									<tr><td></td>
									<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.AdmissionNo.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="ToAdmissionNo" id="ToAdmissionNo"
											id="ToAdmissionNo" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') {admnolkp(document.forms[0].ToAdmissionNo,'To'); onBlurEvent('1'); } else { ToAdmissionNoHid.value ='';  } "
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="ToAdmissionNolookUp" id="ToAdmissionNolookUp"
											id="ToAdmissionNolookUp" value='?'
											onClick="admnolkp(document.forms[0].ToAdmissionNo,'To');"
											tabindex='2' /> <input type="hidden" name="ToAdmissionNoHid" id="ToAdmissionNoHid"
											id="ToAdmissionNoHid" value="">
										</td>
									</tr>
									<tr id="serdate1"><td></td>
									<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}" /></td>
										<td class='fields' style="text-align:left; width: 160px;"><input type="text" name="ToServDate" id="ToServDate"
											id="ToServDate"  size="15" maxlength='10'  value=''
											onBlur='return dateRegEx(this);'><img
											src="../../eCommon/images/CommonCalendar.gif"
											onClick="return showCalendar('ToServDate');">
										</td>
									</tr>
									<tr id="billservgrp1"><td></td>
										<td class="label" style="text-align:right; width: 160px;"><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}" /></td>
										<td class="fields" style="text-align:left; width: 160px;"><input type="text" name="ToBillServGrp" id="ToBillServGrp"
											id="ToBillServGrp" maxlength="50"
											onBlur="ChangeUpperCase( this );if(this.value!='') interDraftCommonLookup(3,ToBillServGrp,ToBillServGrpHid,'billServGrp');   else { ToBillServGrpHid.value =''; onBlurEvent('1'); }"
											onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
											<input type='button' class='button' name="ToBillServGrplookUp" id="ToBillServGrplookUp"
											id="ToBillServGrplookUp" value='?'
											onClick="interDraftCommonLookup(3,ToBillServGrp,ToBillServGrpHid,'billServGrp');"
											tabindex='2' /> <input type="hidden" name="ToBillServGrpHid" id="ToBillServGrpHid"
											id="ToBillServGrpHid" value="">
										</td>
									</tr>
							</table>
						</td>
						
					</tr>
				</table>
			</tr>
			<tr><!-- Modifed V210226 Starts-->
					<table width="85%" align="center">
						<tr>
							<td class="label" width="15%" style="text-align:right;"><fmt:message key="eBL.PAYABLE_TYPE.label" bundle="${bl_labels}" /></td>
							<td class='fields'>
							<select name="payableType" id="payableType" id="payableType"  onchange="payTypeChange(this)">
								<option value="I">Payer</option>
								<option value="P">Patient</option>
								<option value="B" selected>Both</option>
							</select>
							</td>
							<td class="label" width="5%" style="text-align:right;"><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}" /></td>
							<td class="fields" width="35%" align="center">
							<input type="text"  name="Payer" id="Payer" id="Payer" maxlength="50"
							style="width:25%;" onBlur="ChangeUpperCase( this );if(this.value!='') interDraftCommonLookup(Payer,PayerHid,'Payer');   else { PayerHid.value =''; onBlurEvent('1'); }"
							onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
							<input type="text"  style="width:55%;" name="PayerHid" id="PayerHid" id="PayerHid" value="">
							<input type='button' class='button'  name="PayerlookUp" id="PayerlookUp" id="PayerlookUp" value='?'
							onClick="interDraftCommonLookup(Payer,PayerHid,'Payer');"
							tabindex='2' /> 
							</td>
							<td class="label" width="20%" style="text-align:right;"><fmt:message key="eBL.PAYABLE_AMT_EXCEED.label" bundle="${bl_labels}" /></td>
							<td class="fields" width="10%"  >
							<input type="text"  name="PayerAmtExceed" id="PayerAmtExceed" id="PayerAmtExceed" style="text-align:right;">							
							</td>
						</tr></table>
						<table width="90%" align="center">
						<tr>
							<td class="label" width="10%" style="text-align:right;"><fmt:message key="eBL.Option.label" bundle="${bl_labels}" /></td>
							<td class='fields' width="20%">
							<select name="option" id="option" id="option" >
								<option value="N" selected>Without Discharge Advice</option>
								<option value="Y">With Discharge Advice</option>
							</select>
							</td>
							<td class="label"  width="20%" style="text-align:right;" id="ReportPrintOptionLbl"><fmt:message key="eBL.ReportPrintOption.label" bundle="${bl_labels}" /></td>
							<td class='fields'  width="20%" >
							<select name="ReportPrintOption" id="ReportPrintOption" id="ReportPrintOption" >
								<option value="S" selected>Billing Service</option>
								<option value="C">Billing Service Classification</option>
							</select>
							</td>
							<td colspan="2" width="20%" align="center">
								<input type='button' class='button' style="width:40%;" name="SearchBtn" id="SearchBtn" id="SearchBtn" value='Search'/>
							</td>
							</tr>
					</table>
					<table width="70%" align="center">
						<tr><%
						if(languageSiteSpec){
						%>
							<td class="label" style="text-align:right;width: 15%;" id="langLabel"><fmt:message key="eBL.Language.label" bundle="${bl_labels}" /></td>
							<td class='fields'  style="width: 15%">
							<select name="Language" id="Language" id="Language">
								<option value="en" selected>English</option>
								<option value="ar">Arabic</option>
							</select>
							</td>
							<%
						}
						else{
						%>
							<td colspan=2></td>
						<%	
						}
						%>
							<td style="text-align:center;width: 30%;"><input type="text" style="width: 100%;" name="langHid" id="langHid" id="langHid" value="" disabled></td>
							<td class="label" style="text-align:left;width: 15%;"><input type="checkbox" style="text-align:right;" name="detailRprtChkbx" id="detailRprtChkbx"	id="detailRprtChkbx" /><fmt:message key="Common.Detail.label" bundle="${common_labels}" /></td>
							<td style="width: 15%;"><input type='button' class='button' name="prcssBedChrg" id="prcssBedChrg" id="prcssBedChrg" value='Process Bed Charges'/></td>
							<td style="width: 15%;"><input type='button' class='button' name="Recalculate" id="Recalculate" id="Recalculate" value='Recalculate'/></td>
						</tr>
					</table>
					<table width="100%" align="center">
						<tr>
							<td class="label" width="10%"><strong style="font-size: 15px;"><fmt:message key="eBL.PatientDetails.label" bundle="${bl_labels}" /></strong></td>
						</tr>
					</table>	
			</tr>				
		</table>
		<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value="<%=facilityId%>"> 
		<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" value="<%=str_module_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id" value="">
		<input type="hidden" name="p_user_id" id="p_user_id" id="p_user_id" value="<%=loginUser%>">
		<input type="hidden" name="pgm_id" id="pgm_id" id="pgm_id" value="">
		<input type="hidden" name="servDateGrpSiteSpec" id="servDateGrpSiteSpec" id="servDateGrpSiteSpec" value="<%=servDateGrpSiteSpec%>">
		<input type="hidden" name="languageSiteSpec" id="languageSiteSpec" id="languageSiteSpec" value="<%=languageSiteSpec%>">
		<input type="hidden" name="billStageVal" id="billStageVal" id="billStageVal" value="<%=billStageVal%>">
		<input type="hidden" name="reportType" id="reportType" id="reportType" value="">
		<input type="hidden" name="selectedRow" id="selectedRow" id="selectedRow" value="">
		<input type="hidden" name="WS_NO" id="WS_NO" id="WS_NO" value="<%=WS_NO%>">
		<input type="hidden" name="siteIdVal" id="siteIdVal" id="siteIdVal" value="<%=siteIdVal%>">
	</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in IntermDraft Report.jsp::"+e);
	}
	finally {
	    if (rsIntermDraft != null) {
	        try {
	        	rsIntermDraft.close();
	        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
	    }
	    if (pstmtIntermDraft != null) {
	        try {
	        	pstmtIntermDraft.close();
	        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
	    }
	    if (conIntermDraft != null) {
	        try {
	        	conIntermDraft.close();
	        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
	    }
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>



