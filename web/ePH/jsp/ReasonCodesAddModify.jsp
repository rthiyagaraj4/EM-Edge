<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
07/02/2017		IN062827		Chithra		07/02/2017	Chandra		ML-MMOH-CRF-0734
22/11/2019      IN059899        PRATHYUSHA                          JD-CRF-0200
22/11/2019      IN067956        PRATHYUSHA                           MMS-KH-CRF-0010
29/05/2020	IN:072092	Manickavasagam J			     GHL-CRF-0618
08/06/2020      IN:072715       Haribabu                            MMS-DM-CRF-0165
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
		<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
        request.setCharacterEncoding("UTF-8");

	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/ReasonCodes.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			function_id = "<%= request.getParameter( "function_id" ) %>"
		</SCRIPT>
	</HEAD>
	<style>
textarea {
  resize: none;
}
</style>
	<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%	
		try{
		/* Mandatory checks start */
		String mode				= request.getParameter( "mode" ) ;
		String	bean_id			=	"ReasonCodes" ;
		String	bean_name		=	"ePH.ReasonCodesBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_MEDN_TRN_REASON";
		String pkey_value		="";
		if ( mode == null || mode.equals("") )
		return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		/* Mandatory checks end */
		ReasonCodesBean bean = (ReasonCodesBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
		Connection con			= null;  //ADDED FOR MMS-KH-CRF-0010
	   	con				= ConnectionManager.getConnection(request);//ADDED FOR MMS-KH-CRF-0010
		boolean viewAdminRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
		 boolean over_ride_remarks_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");//Added for IN:072715
		if(con != null)
		 ConnectionManager.returnConnection(con,request);	
		
		String max_length_prn_reason =(String)bean.getPrnRemarkForDrug();
%>
		<form name="frmReasonCodesAddModify"  id="Reason Codes for Medication Reissue/Return">
<%
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
%>
				<br> <br> <br> 	<br> <br>  	
				<table cellpadding=0 cellspacing=0 width="95%" align="center">
					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.ApplicableTransaction.label" bundle="${ph_labels}"/></td>
						<td  colspan="1" >&nbsp;&nbsp;
							<select name="appl_trn_type" id="appl_trn_type" onChange="return(ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',remarks,'<%=max_length_prn_reason%>',this));">
								<option value="R"><fmt:message key="ePH.MedicationReissue.label" bundle="${ph_labels}"/></option>
								<option value="T"><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/></option>
								<option value="H"><fmt:message key="ePH.MedicationHold.label" bundle="${ph_labels}"/></option>
								<option value="A"><fmt:message key="ePH.Allocation.label" bundle="${ph_labels}"/></option>
								<option value="F"><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
								<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
								<option value="O"><fmt:message key="ePH.AmendOrder.label" bundle="${ph_labels}"/></option>
								<option value="M"><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></option>
								<option value="E"><fmt:message key="ePH.ADRReason.label" bundle="${ph_labels}"/></option>
								<option value="TD"><fmt:message key="ePH.TDMOrder.label" bundle="${ph_labels}"/></option>
								<option value="RP"><fmt:message key="ePH.ReleaseBatchPatient.label" bundle="${ph_labels}"/></option>
								<option value="RO"><fmt:message key="ePH.ReleaseBatchOthers.label" bundle="${ph_labels}"/></option>
								<option value="CO"><fmt:message key="ePH.CompleteOrder.label" bundle="${ph_labels}"/></option>
								<option value="RR"><fmt:message key="ePH.ReroutePrescription.label" bundle="${ph_labels}"/></option>
								<option value="OB"><fmt:message key="ePH.OverRideBMS.label" bundle="${ph_labels}"/></option>
								<option value="BR"><fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></option>
								<option value="DM"><fmt:message key="ePH.DosageChangeinMAR.label" bundle="${ph_labels}"/></option>
								<option value="PR"><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>  </option>
								<option value="CN"><fmt:message key="ePH.CancelNPBRequest.label" bundle="${ph_labels}"/>  </option>
								<option value="AC"><fmt:message key="ePH.ADRCancelReason.label" bundle="${ph_labels}"/>  </option> <!-- code added for HSA-CRF-0005[40601] --> 
								<option value="AI"><fmt:message key="ePH.ADRInErrorReason.label" bundle="${ph_labels}"/>  </option><!-- code added for HSA-CRF-0005[40601] -->     	
								<option value="CM"><fmt:message key="ePH.CancelMarAdminstration.label" bundle="${ph_labels}"/>  </option><!-- Added for JD-CRF-0200 -->
								<%if(viewAdminRemarks){//added for mms-kh-crf-0010
									%>
								
								<option value="MR"><fmt:message key="ePH.MarAdminstrationRemarks.label" bundle="${ph_labels}"/>  </option><!-- Added for MMS-KH-CRF-0010 -->
							<%}
								//Added for IN:072715 start
								if(over_ride_remarks_appl){%>
								<option value="AO"><fmt:message key="ePH.AllergyOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="BD"><fmt:message key="ePH.BeyondDoseLimitOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="DP"><fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="DD"><fmt:message key="ePH.Drug-DrugInteractionOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="DF"><fmt:message key="ePH.Drug-FoodInteractionOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="DL"><fmt:message key="ePH.Drug-LabInteractionOverrideReason.label" bundle="${ph_labels}"/></option>
								<option value="DI"><fmt:message key="ePH.Drug-DiseaseOverrideReason.label" bundle="${ph_labels}"/></option><!-- Added for MMS-DM-CRF-0229 -->
								
									<%} %>
								<option value="NP"><fmt:message key="ePH.NotPreferedItemRemarks.label" bundle="${ph_labels}"/>  </option><!-- GHL-CRF-0618-->
								<!-- Added for IN:072715 end -->
							</select>
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
						 <td ALIGN="right"> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="Common.ReasonCode.label"  bundle="${common_labels}"/></td>
						<td align="left" colspan="2" >&nbsp;&nbsp;
							<input type="text" name="reason_code" id="reason_code" value="" size="4" maxlength="4" onBlur="toUpper(this);ReasonCodeCheck(this);"  onKeyPress="return CheckForSpecChars( event );">
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></td>
						<td colspan="2" >&nbsp;&nbsp;
							<input type="text" name="reason_desc" id="reason_desc" value="" size="43" maxlength="40">
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td colspan="2">&nbsp;&nbsp;&nbsp;<textarea rows="7" cols="49" name="remarks" maxLength="1000"  scrolling="no"  onBlur="return(ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',this,'<%=max_length_prn_reason%>',appl_trn_type));"></textarea><!-- MaxLength 255 to 1000 for ML-MMOH-CRF-0734 -->
						<img name='mandatory1' id='mandatory1' style="visibility:hidden" align="center" src="../../eCommon/images/mandatory.gif"></img>
					</tr>
					 <tr >
					   <td class="label"  style="display:none" ><fmt:message key="ePH.ApplicableforQualityStatisticsreport.label" bundle="${ph_labels}"/></td>
						<td colspan="3" >&nbsp;&nbsp;
						<input type="checkbox" name="QAP_report" id="QAP_report"   style="display:none" >
						</td>
					</tr> 
					<tr>
						<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td colspan="2" >&nbsp;&nbsp;
						<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
						</td>
					</tr>
					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
				</table>
<%
			}
			else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				String appl_trn_type = request.getParameter("appl_trn_type");
				String reason_code	 = request.getParameter("reason_code");
				bean.setApplTrnType(appl_trn_type);
				bean.setReasonCode(reason_code);
				bean.loadData();
				String tranDesc = bean.getApplTrnTypeDesc();
				String applTranDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+tranDesc+".label","ph_labels");

				String disableAll = "";
				if ((bean.getEffStatus()).equals("D")){
					disableAll = "disabled";
				}
				//primary_key_1  ------>APPL_TRN_TYPE   
				//primary_key_2  ------>REASON_CODE
				//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(appl_trn_type.trim());      
				Pk_values.add(reason_code.trim());      
				
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value   ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}
				else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}
%>
				<br> <br> <br> 	<br> <br> 
				<table cellpadding=0 cellspacing=0 width="95%" align="center">
					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.ApplicableTransaction.label" bundle="${ph_labels}"/></td>
						<td  colspan="1" >&nbsp;&nbsp;
							<input type="text" name="appl_trn_type_desc" id="appl_trn_type_desc" value="<%=applTranDesc%>" size="30"  disabled><!-- 25 changed to 30 for JD-CRF-0200 -->
							<input type="hidden" name="appl_trn_type" id="appl_trn_type" value="<%=bean.getApplTrnType()%>" size="1"  disabled>
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
						<td > <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>' onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
						<td colspan="2" >&nbsp;&nbsp;
							<input type="text" name="reason_code" id="reason_code" value="<%=bean.getReasonCode()%>" size="4" maxlength="4" disabled>
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></td>
						<td colspan="2" >&nbsp;&nbsp;
							<input type="text" name="reason_desc" id="reason_desc" value="<%=bean.getReasonDesc()%>" size="43" maxlength="40" <%=disableAll%>>
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td  colspan="2" >&nbsp;&nbsp;&nbsp;<textarea rows="7" cols="49" name="remarks" maxLength="1000"  scrolling="no"  onBlur="return(ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',this,'<%=max_length_prn_reason%>',appl_trn_type));" <%=disableAll%> ><%=bean.checkForNull(bean.getRemarks())%></textarea><!--maxLength 255 to 1000 chnaged for ML-MMOH-CRF-0734-->
<%
						if(bean.getApplTrnType().equals("PR")){
%>
							<img name='mandatory1' style="visibility:visible" align="center" src="../../eCommon/images/mandatory.gif"></img>
<%
						}
						else{
%>
							<img name='mandatory1' style="visibility:hidden" align="center" src="../../eCommon/images/mandatory.gif"></img>
<%
						}
%>
					</tr>
							<tr>
						<td align="right" class="label"  style="visibility:hidden"><fmt:message key="ePH.ApplicableforQualityStatisticsreport.label" bundle="${ph_labels}"/> </td>
						<td align="left" colspan="2" >&nbsp;&nbsp;
<%
						if (bean.getQAP().equals("Y")){
%>
							<input type="checkbox" name="QAP_report" id="QAP_report" value="Y" checked style="visibility:hidden">
<%
						}
						else{
							if (bean.getQAP().equals("N")){
%>
								<input type="checkbox" name="QAP_report" id="QAP_report" value="N" style="visibility:hidden">
<%
							} 
						}
%>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td colspan="2" >&nbsp;&nbsp;
<%
								if (bean.getEffStatus().equals("E")){
%>
									<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
<%
								}
								else{
%>
									<input type="checkbox" name="eff_status" id="eff_status" value="E" >
<%
								}
%>
						</td>
					</tr>
					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
				</table>
<%
			}
%>
			<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">	
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		</form>
<% 
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && bean.getEffStatus().equals("E") || bean.getQAP().equals("Y") ){ 
%>
			<script>
			//	document.frmReasonCodesAddModify.reason_desc.focus() ;
			</script>
<% 
		}
		putObjectInBean(bean_id,bean,request); 
}catch(Exception e){
e.printStackTrace();
}
%>
	</BODY>
</HTML>

