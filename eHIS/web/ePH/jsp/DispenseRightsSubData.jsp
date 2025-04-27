<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseRights.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			var function_id = "<%= request.getParameter( "function_id" ).trim() %>"
		</SCRIPT>
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
try{
		/* Mandatory checks start onKeyDown="lockKey()" */
		String mode			= request.getParameter( "mode" ) ;
		String bean_id		= "DispenseRightsBean" ;
		String bean_name	= "ePH.DispenseRightsBean";

		String disabled		= "";
		String checked		= "";
		String authChecked  ="";//added for ml-mmoh-crf-0863
		String selected		= ""; 
		String fillselected = "";
		String locn_code	= request.getParameter("disp_locn_code");
		String user_id		= request.getParameter("appl_user_id");
		DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.setDispLocnCode(locn_code);
		bean.setUserID(user_id);

		Hashtable param_legends = bean.getLegendsFromParam();
		String disp_locn_category = bean.getDispLocnCategory();
		ArrayList locnDetailsForMod=null;
		ArrayList referralfcy=bean.getReferralFacilities();	
		String op_dflt_disp_stage="", ip_dflt_disp_stage="", verify_yn="", fill_yn="", deliver_yn="", allocate_yn=""; //added for [IN047788]
		String register_yn="", issueToken_yn="", dflt_token_series_ind="", sort_token_series_ind="", generate_actual_token_yn=""; //Added for HSA-CRF-0136 [IN:048412]
%>
		<FORM name="formDispenseRightsSubData" id="formDispenseRightsSubData">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="98%" ALIGN="center" BORDER="0">
			<TR>
				<TH COLSPAN="4"><fmt:message key="ePH.AuthorizedDrugs.label" bundle="${ph_labels}"/></TH>
			</TR>
			<TR>
				<TD CLASS="label" WIDTH="30%"><B><fmt:message key="ePH.DispLocnLevel.label" bundle="${ph_labels}"/></B></TD>
				<TD CLASS="label" WIDTH="20%"><fmt:message key="Common.general.label" bundle="${common_labels}"/></TD>
				<TD CLASS="label" WIDTH="25%"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></TD>
				<TD CLASS="label" WIDTH="25%"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></TD>
			</TR>
			<TR>
				<TD CLASS="label" WIDTH="30%">&nbsp;</TD>
				<TD CLASS="label" WIDTH="20%">&nbsp;
<%
				ArrayList locnDetails = bean.getLocnDetails();
				if(locnDetails!=null && locnDetails.size()>0){ //added for HSA-CRF-0136 [IN:048412] -start
					register_yn = (String)locnDetails.get(3);
					issueToken_yn = (String)locnDetails.get(13);
					generate_actual_token_yn = (String)locnDetails.get(14);
				} //HSA-CRF-0136 [IN:048412] -end
				if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
					String disp_verf_stage =(String)locnDetails.get(11);
					if (locnDetails.get(0).toString().equals("Y")) {
%>
						<IMG SRC="../../eCommon/images/enabled.gif"></IMG>
<%
					}
					else {
%>
						<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
					}
%>
					</TD>
					<TD CLASS="label" WIDTH="25%">&nbsp;
<%
					if (locnDetails.get(1).toString().equals("Y")) {
%>				
						<IMG SRC="../../eCommon/images/enabled.gif"></IMG>
<%
					}
					else {
%>
						<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
					}
%>
					</TD>
					<TD CLASS="label" WIDTH="25%">&nbsp;
<%
					if (locnDetails.get(2).toString().equals("Y")) {
%>
						<IMG SRC="../../eCommon/images/enabled.gif"></IMG> 
<%
					}
					else {
%>
						<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
					}
%>
					</TD>
				</TR>
				<TR>
					<TD CLASS="label" WIDTH="25%"><B><fmt:message key="ePH.UserLevel.label" bundle="${ph_labels}"/></B></TD>
<%
					String style_box = "";
					if (locnDetails.get(0).toString().equals("N")) {
						style_box = "STYLE=visibility:hidden";
						checked = "";
					}
					else {
						style_box = "";
						checked = "CHECKED";
					}
%>
					<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="GENERAL_YN" id="GENERAL_YN" <%= checked %> <%= style_box %>></TD>
<%
					if (locnDetails.get(1).toString().equals("N")) {
						style_box = "STYLE=visibility:hidden";
						checked = "";
					}
					else {
						style_box = "";
						checked = "CHECKED";
					}
%>
					<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="NARCOTIC_YN" id="NARCOTIC_YN" <%= checked %> <%= style_box %>></TD>
<%
					if (locnDetails.get(2).toString().equals("N")) {
						style_box = "STYLE=visibility:hidden";
						checked = "";
					}
					else {
						style_box = "";
						checked = "CHECKED";
					}
%>
					<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="CONTROLLED_YN" id="CONTROLLED_YN" <%= checked %> <%= style_box %>></TD>
				</TR>
			</TABLE>
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="98%" ALIGN="center" BORDER="0">
				<TR>
					<TH COLSPAN="4"><fmt:message key="ePH.DispensingControls.label" bundle="${ph_labels}"/></TH>
				</TR>
				<TR>
					<TD width='25%' class="label"'><fmt:message key="ePH.ChangeTradeName.label" bundle="${ph_labels}"/></TD>
					<td width='20%'>&nbsp;<INPUT name="TRADE_CHANGE_ALLOWED_YN" id="TRADE_CHANGE_ALLOWED_YN" TYPE="checkbox" <%= checked %> ></td>
					<TD width='20%' class="label"><fmt:message key="ePH.AllowMultiTrade.label" bundle="${ph_labels}"/></TD>
					<td width='35%'>&nbsp;<INPUT name="ALLOW_MULTI_TRADE_YN" id="ALLOW_MULTI_TRADE_YN" TYPE="checkbox" <%= checked %> ></td>
				</TR>
				<TR>
					<TD class="label"><fmt:message key="ePH.RerouteOrder.label" bundle="${ph_labels}"/></TD>
					<td >&nbsp;<INPUT name="REROUTE_ORDER_YN" id="REROUTE_ORDER_YN" TYPE="checkbox" <%= checked %> ></td>
					<TD class="label"><fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></TD>
					<td >&nbsp;<INPUT name="PATIENT_HISTROY_YN" id="PATIENT_HISTROY_YN" TYPE="checkbox" <%= checked %> ></td>
				</TR>
				<TR> <!-- code added for JD-CRF-0156[IN041737]--Start -->	 			
					<TD class="label"><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/> <fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></TD>
					<td >&nbsp;<INPUT name="FINANCIAL_DETAILS_YN" id="FINANCIAL_DETAILS_YN" TYPE="checkbox" ></td>
					<TD COLSPAN="2">&nbsp;</TD> 
				</TR><!-- code added for JD-CRF-0156[IN041737]--End -->	 	
				<TR>
					<TD CLASS="label" COLSPAN="4"><B><fmt:message key="ePH.OPSubProcess.label" bundle="${ph_labels}"/> :</B></TD>
				</TR>
				<TR>
					 <TD CLASS="label" ><%=param_legends.get("R")%>&nbsp;</TD> 
<%
					if (locnDetails.get(3).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
					}
					else {
						disabled = "";
						checked = "CHECKED";
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="REGN_YN" id="REGN_YN" <%= checked %> <%= disabled %> onclick='dispDefTokenSeries(this);'></TD>
					<TD CLASS="label" ><%=param_legends.get("V")%>&nbsp;</TD>
<%
					if (locnDetails.get(3).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
						if(disp_verf_stage.equals("B")){
							checked = "CHECKED";
							disabled = "";
							verify_yn = "Y";
						}
						else if(disp_verf_stage.equals("F")){
							checked = "CHECKED";
							disabled = "";
							verify_yn="";
						}
					}
					else {
						if(disp_verf_stage.equals("B")){ //if condition and else block added for MMS-SCF-0448 [IN:052251]
							checked = "CHECKED";
							disabled = "";
							verify_yn = "Y";
						}
						else{
							disabled = "DISABLED";
							checked = "";
							verify_yn = "";
						}
					}
%>
					<TD CLASS="label"><INPUT TYPE="checkbox" name="VERIFY_YN" id="VERIFY_YN" <%= disabled %> <%=checked%> onclick='addToDefStage(this, "VF","<%=param_legends.get("V")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
				</TR>
				<TR>
					<TD CLASS="label"><%=param_legends.get("F")%>&nbsp;</TD>
<%
					if (locnDetails.get(4).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
						fill_yn=""; //added for [IN047788]
					}
					else {
						checked = "CHECKED";
						disabled = "";
						fill_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="FILL_YN" id="FILL_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "FL","<%=param_legends.get("F")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
					<TD CLASS="label" ><%=param_legends.get("A")%>&nbsp;</TD>
<%
					if (locnDetails.get(4).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";	
						if(!disp_verf_stage.equals("F")){
							checked = "CHECKED";
							disabled = "";
							allocate_yn="Y";//added for [IN047788] //"Y" for MMS-SCF-0448 [IN:052251]
						}
					}
					else {
						checked = "CHECKED";
						disabled = "";
						allocate_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="ALLOCATE_YN" id="ALLOCATE_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "AL","<%=param_legends.get("A")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
				</TR>
				<TR>
					<TD CLASS="label" style='display:none'><%=param_legends.get("B")%>&nbsp;</TD>
<%
					if (locnDetails.get(5).toString().equals("X") || disp_locn_category.equals("I")) {
						//disabled = "DISABLED";
						checked = "";
					}
					else {
						//checked = "CHECKED";
						//disabled = "";
						checked = "";
					}
%>
					<TD CLASS="label" style='display:none' ><INPUT TYPE="checkbox" name="BILL_RECEIPT_YN" id="BILL_RECEIPT_YN" <%= checked %> <%= disabled %>></TD>
					<TD CLASS="label" ><%=param_legends.get("D")%>&nbsp;</TD>
<%
					if (locnDetails.get(6).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
						deliver_yn="";//added for [IN047788]
					}
					else {
						checked = "CHECKED";
						disabled = "";
						deliver_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="DELIVER_YN" id="DELIVER_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "DL","<%=param_legends.get("D")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
					<TD CLASS="label"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD CLASS="label"><INPUT TYPE="checkbox" name="OP_REISSUE_MEDICATION_YN" id="OP_REISSUE_MEDICATION_YN" checked ></TD>
				</TR>
				<TR>
				<TD CLASS="label" ><fmt:message key="ePH.AllowReprintingOfPrescription.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="ALLOW_REPRINT_YN" id="ALLOW_REPRINT_YN" onclick="disableReprints(this);" <%=disabled%>></TD>
					<TD CLASS="label" ><fmt:message key="ePH.No.OfReprintsAllowed.label" bundle="${ph_labels}"/>&nbsp;</TD>
					<TD CLASS="label" >&nbsp;<INPUT TYPE="text" CLASS="NUMBER" VALUE="" name="NO_OF_REPRINTS" id="NO_OF_REPRINTS" DISABLED SIZE="2" MAXLENGTH="2" onBlur="CheckNum(this);"></TD>
				</TR>
				<TR>
					<TD CLASS="label" ><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
					if (locnDetails.get(7).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
					}
					else {
						checked = "CHECKED";
						disabled = "";
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="MEDN_RTN_YN" id="MEDN_RTN_YN" <%= checked %> <%= disabled %> onclick='mednRtnBillGenStatus(this, "OP");'></TD>
					<td class='label'><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.AfterBillGen.label" bundle="${ph_labels}"/></td>
<%
					if(checked.equals(""))
						disabled="disabled";
					else
						disabled = "";
%>
					<td class='label'><SELECT name="OP_MEDN_RTN_AFTER_BILL_GEN" id="OP_MEDN_RTN_AFTER_BILL_GEN" <%=disabled%>>
						<option VALUE='' >&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
						<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
						<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					</select></td>
				</TR>
				<TR> <!--addToDefStage added for [IN047788] -start-->
					<td class=label><fmt:message key="ePH.DefaultDispenseStage.label" bundle="${ph_labels}"/></td>
					<td class='label'><SELECT name="OP_DFLT_DISP_STAGE" id="OP_DFLT_DISP_STAGE"  >
						<option VALUE='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
					if(verify_yn.equals("Y")){
%>
						<option VALUE='VF' ><%=param_legends.get("V")%></option>
<%
					}
					if(fill_yn.equals("Y")){
%>
						<option VALUE='FL' ><%=param_legends.get("F")%></option>
<%
					}
					if(allocate_yn.equals("Y")){
%>
						<option VALUE='AL' ><%=param_legends.get("A")%></option>
<%
					}
					if(deliver_yn.toString().equals("Y")){
%>
						<option VALUE='DL' <%=checked%>><%=param_legends.get("D")%></option>
<%
					}
%>
					</select>
					</td>
					<td class=label><fmt:message key="ePH.DefaultTokenSeries.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td> <!-- added for HSA-CRF-0136 [IN:048412] start-->
<%
					if(register_yn.equals("Y") && issueToken_yn.equals("Y"))
						disabled="";
					else
						disabled="disabled";
%>
					<td class='label'><SELECT name="DFLT_TOKEN_SERIES_IND" id="DFLT_TOKEN_SERIES_IND"  <%=disabled%> >
						<option VALUE='W' selected><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></option>
						<option VALUE='A' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option VALUE='I' ><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
						</select>
						&nbsp;&nbsp;&nbsp;<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
						&nbsp;&nbsp;&nbsp;<SELECT name="SORT_TOKEN_SERIES_IND" id="SORT_TOKEN_SERIES_IND" <%=disabled%> >
						<option VALUE='O' selected><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
						<option VALUE='R' ><fmt:message key="ePH.RegisterDateTime.label" bundle="${ph_labels}"/></option>
<%
						if(generate_actual_token_yn.equals("Y")){
%>
							<option VALUE='P' ><fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
<%
						}
%>
						</select>
					</td> <!-- added for HSA-CRF-0136 [IN:048412] End-->
				</TR>	<!--addToDefStage added for [IN047788] -End -->
				<TR>
					<TD COLSPAN="4">&nbsp;</TD>
				</TR>	
				<TR>
					<TD COLSPAN="4" CLASS="label"><B><fmt:message key="ePH.IPSubProcess.label" bundle="${ph_labels}"/> :</B></TD>
				</TR>
				<TR>
					<TD CLASS="label" ><%=param_legends.get("V")%>&nbsp;</TD>
<%
					if (locnDetails.get(8).toString().equals("N") || disp_locn_category.equals("O")) {
						disabled = "DISABLED";
						checked = "";
						verify_yn="";//added for [IN047788]
					}
					else {
						checked = "CHECKED";
						disabled = "";
						verify_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_VERIFY_YN" id="IP_VERIFY_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "VF","<%=param_legends.get("V")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
					<TD CLASS="label" ><%=param_legends.get("F")%>&nbsp;</TD>
<%
					if (locnDetails.get(9).toString().equals("N") || disp_locn_category.equals("O")) {
						disabled = "DISABLED";
						checked = "";
						fill_yn="";//added for [IN047788]
					}
					else {
						checked = "CHECKED";
						disabled = "";
						fill_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_ALLOCATE_YN" id="IP_ALLOCATE_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "FL","<%=param_legends.get("F")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
				</TR>
				<TR>
					<TD CLASS="label" ><%=param_legends.get("D")%>&nbsp;</TD>
<%
					if (locnDetails.get(10).toString().equals("N") || disp_locn_category.equals("O")) {
						disabled = "DISABLED";
						checked = "";
						deliver_yn="";//added for [IN047788]
					}
					else {
						checked = "CHECKED";
						disabled = "";
						deliver_yn="Y";//added for [IN047788]
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_DELIVER_YN" id="IP_DELIVER_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "DL","<%=param_legends.get("D")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
					<TD CLASS="label" ><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></TD>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_REISSUE_MEDICATION_YN" id="IP_REISSUE_MEDICATION_YN" checked ></TD>
					<TR>
					<TD CLASS="label" ><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/></TD>
<%
					if(locnDetails.get(12).toString().equals("N")){
						disabled="DISABLED";
						checked="";
					}
					else{
						disabled="";
						checked="Checked";
					}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_ACCEPT_MEDN_RTN_YN" id="IP_ACCEPT_MEDN_RTN_YN" <%= checked %> <%= disabled %> onclick='mednRtnBillGenStatus(this, "IP");'></TD>
						<td class='label'><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.AfterBillGen.label" bundle="${ph_labels}"/></td>
<%
						if(checked.equals(""))
							disabled="disabled";
						else
							disabled = "";
%>
						<td class='label'><SELECT name="IP_MEDN_RTN_AFTER_BILL_GEN" id="IP_MEDN_RTN_AFTER_BILL_GEN" <%=disabled%>>
							<option VALUE='' selected>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
						</select></td>
					</TR>
				</TR>
				<TR>
					<TD CLASS="LABEL" >
						<fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=param_legends.get("F")%>
					</td>
					<TD CLASS="LABEL"  >
						<input type="radio" name="CHK_FILL_LIST" id="CHK_FILL_LIST" checked value="AF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						<input type="radio" name="CHK_FILL_LIST" id="CHK_FILL_LIST" value="WF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
					</TD>
					<TD CLASS="LABEL" >
						<fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=param_legends.get("D")%>
					</td>
					<TD CLASS="LABEL">
						<input type="radio" name="CHK_DELIVER_FILL_LIST" id="CHK_DELIVER_FILL_LIST" checked value="DWF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						<input type="radio" name="CHK_DELIVER_FILL_LIST" id="CHK_DELIVER_FILL_LIST" value="DF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
					</TD>
				</TR>
				<TR> <!--addToDefStage added for [IN047788] -start -->
					<td class=label><fmt:message key="ePH.DefaultDispenseStage.label" bundle="${ph_labels}"/></td>
					<td class='label'><SELECT name="IP_DFLT_DISP_STAGE" id="IP_DFLT_DISP_STAGE"  >
						<option VALUE='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
					if(verify_yn.equals("Y")){
%>
						<option VALUE='VF' ><%=param_legends.get("V")%></option>
<%
					}
					if(fill_yn.equals("Y")){
%>
						<option VALUE='FL' ><%=param_legends.get("F")%></option>
<%
					}
					if(deliver_yn.toString().equals("Y")){
%>
						<option VALUE='DL' <%=checked%>><%=param_legends.get("D")%></option>
<%
					}
%>
					<td>
					<td colspan='2'>&nbsp;</td>
				</TR>	<!--addToDefStage added for [IN047788] -end-->
				<TR>
					<TD COLSPAN="4">&nbsp;</TD>
				</TR>	
				<TR>
					<TD class="label" COLSPAN="4"><B><fmt:message key="ePH.VerificationRights.label" bundle="${ph_labels}"/> :</B></TD>
				</TR>
				<TR>
					<TD class="label"><fmt:message key="ePH.AllowChangeofDose.label" bundle="${ph_labels}"/></TD>
					<!--onclick added for ml-mmoh-crf-0863 -->
					<TD class="label"><INPUT TYPE="checkbox" name="CHANGE_DOSE_DURN_VERIFY_YN" id="CHANGE_DOSE_DURN_VERIFY_YN" onclick="modifyAuthAmendPres(this)" ></TD>
					<!-- <TD COLSPAN="2">&nbsp;</TD>  commented for ML-MMOH-CRF-0863 AND  NEW td ADDED -->
				<!-- added for ml-mmoh-crf-0863 start  -->
					<TD class="label" id="AUTH_AMEND_PRES_LABEL_YN" name="AUTH_AMEND_PRES_LABEL_YN"  style="visibility:hidden"><fmt:message key="ePH.AUTHAMENDPRESLABEL.label" bundle="${ph_labels}"/></TD>
					<td  style="visibility:hidden"  ID="AUTH_AMEND_PRES_YN">&nbsp;<INPUT name="AUTH_AMEND_PRES_YN" id="AUTH_AMEND_PRES_YN" TYPE="checkbox"    ></td>
		         <!-- added for ml-mmoh-crf-0863 end -->
				<TR><!-- //Added for CRF-0439 -->
					<TD class="label"><fmt:message key="ePH.UnlockRecordsLockedByOtherUsers.label" bundle="${ph_labels}"/></TD>
					<TD class="label"><INPUT TYPE="checkbox" name="UNLOCK_RECORDS_YN" id="UNLOCK_RECORDS_YN" ></TD>
					<TD COLSPAN="2">&nbsp;</TD>
				</TR>
				<TR> <!--added for Bru-HIMS-CRF-087 [IN:029953] - start -->
					<TD COLSPAN="4">&nbsp;</TD>
				</TR>	
				<TR>
					<TD class="label"><B><fmt:message key="ePH.TrackingOutsourceMedication.label" bundle="${ph_labels}"/> :</B></TD>
					<TD class="label" COLSPAN="3"><INPUT TYPE="checkbox" name="TRACK_OUTSOURCING_YN" id="TRACK_OUTSOURCING_YN" onclick='trackOutSourcing(this)'></TD>
				</TR>
				<TR style='display:none;' id='trOutSourcingAccess'>
					<TD class="label"><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/></TD>
					<TD class="label"><fmt:message key="ePH.Send.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_SEND" id="OUTSOURCING_SEND" onclick='addToDefAction(this,"S");'></TD>
					<TD class="label"><fmt:message key="ePH.Receive.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_RECEIVE" id="OUTSOURCING_RECEIVE" onclick='addToDefAction(this,"R");' ></TD>
					<TD class="label"><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_DELIVER" id="OUTSOURCING_DELIVER" onclick='addToDefAction(this,"D");' ></TD>
				</TR>
				<TR style='display:none;' id='trOutSourcingDefault'>
					<TD class="label"><fmt:message key="ePH.DefTrackAction.label" bundle="${ph_labels}"/></TD>
					<TD class="label">
						<SELECT name="OUTSOURCING_DEF_ACTION" id="OUTSOURCING_DEF_ACTION" >
							<option value=''>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
						</SELECT>
					</TD>
					<TD class="label"><fmt:message key="ePH.DefRefFacility.label" bundle="${ph_labels}"/></TD>
					<TD class="label">
						<SELECT name="OUTSOURCING_DEF_FACILITY" id="OUTSOURCING_DEF_FACILITY" >
							<option value=''>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0;i<referralfcy.size();i+=2){
%>
								<option  VALUE="<%=(String)referralfcy.get(i)%>"><%= referralfcy.get(i+1) %></option>
<%
							}
%>
						</SELECT>
					</TD>
				</TR><!--added for Bru-HIMS-CRF-087 [IN:029953] - End -->
<%
			}
			else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {
			try{
				locnDetailsForMod = bean.getLocnDtlsForModify();
				if (locnDetailsForMod.get(0).toString().equals("Y")) {
%>
					<IMG SRC="../../eCommon/images/enabled.gif"></IMG>
<%
				}
				else {
%>
					<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
				}
%>
				</TD>
				<TD CLASS="label" WIDTH="25%">&nbsp;
<%
				if (locnDetailsForMod.get(1).toString().equals("Y")) {
%>
					<IMG SRC="../../eCommon/images/enabled.gif"></IMG>
<%
				}
				else {
%>
					<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
				}
%>
				</TD>
				<TD CLASS="label" WIDTH="25%">&nbsp;
<%
				if (locnDetailsForMod.get(2).toString().equals("Y")) {
%>
					<IMG SRC="../../eCommon/images/enabled.gif"></IMG>
<%
				}
				else {
%>
					<IMG SRC="../../eCommon/images/disabled.gif"></IMG>
<%
				}
%>
				</TD>
			</TR>
			<TR>
				<TD CLASS="label" ><B><fmt:message key="ePH.UserLevel.label" bundle="${ph_labels}"/></B></TD>
				<TD CLASS="label" >&nbsp;
<%
				if (locnDetailsForMod.get(0).toString().equals("Y")) {
					if (locnDetailsForMod.get(3).toString().equals("Y")) {
						disabled = "";
						checked = "CHECKED";
					}
					else {
						disabled = "";
						checked = "";
					}
%>
					<INPUT name="GENERAL_YN" id="GENERAL_YN" TYPE="checkbox" <%= checked %> <%= disabled %>>
<%
				}
				else{
%>
					<INPUT name="GENERAL_YN" id="GENERAL_YN" TYPE="checkbox"  style="display:none">
<%
				}
%>
				</TD>
				<TD CLASS="label" >&nbsp;
<%
				if (locnDetailsForMod.get(1).toString().equals("Y")) {
					if (locnDetailsForMod.get(4).toString().equals("Y")) {
						disabled = "";
						checked = "CHECKED";
					}
					else {
						disabled = "";
						checked = "";
					}
%>
					<INPUT name="NARCOTIC_YN" id="NARCOTIC_YN" TYPE="checkbox" <%= checked %> <%= disabled %>>
<%
					}
					else{
%>
						<INPUT name="NARCOTIC_YN" id="NARCOTIC_YN" TYPE="checkbox"  style="display:none">
<%
					}
%>
					</TD>
					<TD CLASS="label" >&nbsp;
<%
					if (locnDetailsForMod.get(2).toString().equals("Y")) {
						if (locnDetailsForMod.get(5).toString().equals("Y")) {
							disabled = "";
							checked = "CHECKED";
						}
						else {
							disabled = "";
							checked = "";
						}
%>
						<INPUT name="CONTROLLED_YN" id="CONTROLLED_YN" TYPE="checkbox" <%= checked %> <%= disabled %>>
<%
					}
					else{
%>
						<INPUT name="CONTROLLED_YN" id="CONTROLLED_YN" TYPE="checkbox" style="display:none">
<%
					}
%>
					</TD>
				</TR>
			</TABLE>
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="98%" ALIGN="center" BORDER="0">
				<TR>
					<TH COLSPAN="4"><fmt:message key="ePH.DispensingControls.label" bundle="${ph_labels}"/></TH>
				</TR>
				<TR>
<%			
					if (locnDetailsForMod.get(28).toString().equals("Y")) {	
						checked = "CHECKED";
					}	
					else {	
						checked = "";
					}	
%>			
					<TD class="label" width='25%'><fmt:message key="ePH.ChangeTradeName.label" bundle="${ph_labels}"/></TD>
					<td  width='20%'>&nbsp;<INPUT name="TRADE_CHANGE_ALLOWED_YN" id="TRADE_CHANGE_ALLOWED_YN" TYPE="checkbox" <%= checked %> ></td>
<% 
					if (locnDetailsForMod.get(29).toString().equals("Y")) {	
						checked = "CHECKED";
					}	
					else {	
						checked = "";
					}	
%>
					<TD class="label"  width='20%'><fmt:message key="ePH.AllowMultiTrade.label" bundle="${ph_labels}"/></TD>
					<td  width='35%'>&nbsp;<INPUT name="ALLOW_MULTI_TRADE_YN" id="ALLOW_MULTI_TRADE_YN" TYPE="checkbox" <%= checked %> ></td>
				</TR>
<%
				if (locnDetailsForMod.get(30).toString().equals("Y")) {	
					checked = "CHECKED";
				}	
				else {	
					checked = "";
				}	
%>
				 <TR>
					<TD class="label"><fmt:message key="ePH.RerouteOrder.label" bundle="${ph_labels}"/></TD>
					<td >&nbsp;<INPUT name="REROUTE_ORDER_YN" id="REROUTE_ORDER_YN" TYPE="checkbox" <%= checked %> ></td>
<%
					if (locnDetailsForMod.get(31).toString().equals("Y")) {	
						checked = "CHECKED";
					}	
					else {	
						checked = "";
					}	
%>
					<TD class="label"><fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></TD>
					<td >&nbsp;<INPUT name="PATIENT_HISTROY_YN" id="PATIENT_HISTROY_YN" TYPE="checkbox" <%= checked %> ></td>
				</TR>
				<TR> <!-- code added for JD-CRF-0156[IN041737]--Start -->	 			
					<TD class="label"><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/> <fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></TD>
<%
					if (locnDetailsForMod.get(45).toString().equals("Y")) {	
						checked = "CHECKED";
					}	
					else {	
						checked = "";
					}	
%>					
					<td >&nbsp;<INPUT name="FINANCIAL_DETAILS_YN" id="FINANCIAL_DETAILS_YN" TYPE="checkbox" <%= checked %>></td>
						<TD COLSPAN="2">&nbsp;</TD> 				
						
				</TR><!-- code added for JD-CRF-0156[IN041737]--End -->	
				<TR>
					<TD CLASS="label" COLSPAN="4"><B><fmt:message key="ePH.OPSubProcess.label" bundle="${ph_labels}"/> :</B></TD>
				</TR>
				<TR>
					<TD CLASS="label" ><%=param_legends.get("R")%>&nbsp;</TD>
<%
					if (locnDetailsForMod.get(6).toString().equals("N")|| disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
					}
					else {
						disabled = "";
						if (locnDetailsForMod.get(7).toString().equals("Y")) {
							checked = "CHECKED";
						}
						else {
							checked = "";
						}
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="REGN_YN" id="REGN_YN" <%= checked %> <%= disabled %> onclick='dispDefTokenSeries(this);'></TD>
					<TD CLASS="label" ><%=param_legends.get("V")%>&nbsp;</TD>
<%
					if (locnDetailsForMod.get(8).toString().equals("Y")) {
						checked = "CHECKED";
					}
					else {
						checked = "";
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="VERIFY_YN" id="VERIFY_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "VF","<%=param_legends.get("V")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
				</TR>
				<TR>
					<TD CLASS="label" ><%=param_legends.get("F")%>&nbsp;</TD>
<%
					if (locnDetailsForMod.get(9).toString().equals("N") || disp_locn_category.equals("I")) {
						disabled = "DISABLED";
						checked = "";
					}
					else {
						disabled = "";
						if (locnDetailsForMod.get(10).toString().equals("Y")) {
							checked = "CHECKED";
						}
						else {
							checked = "";
						}
					}
%>
					<TD CLASS="label" ><INPUT TYPE="checkbox" name="FILL_YN" id="FILL_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "FL","<%=param_legends.get("F")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
					<TD CLASS="label" ><%=param_legends.get("A")%>&nbsp;</TD>
<%
						disabled = "";//added for ML-BRU-SCF-1417 [IN:050675]
						if (locnDetailsForMod.get(11).toString().equals("Y")) {
							checked = "CHECKED";
						}
						else {
							checked = "";
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="ALLOCATE_YN" id="ALLOCATE_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "AL","<%=param_legends.get("A")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
					</TR>
					<TR>
						<TD CLASS="label" style='display:none'><%=param_legends.get("B")%>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(12).toString().equals("X") || disp_locn_category.equals("I")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(13).toString().equals("Y")) {
								//checked = "CHECKED";
								checked = "";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label" style='display:none'><INPUT TYPE="checkbox" name="BILL_RECEIPT_YN" id="BILL_RECEIPT_YN" <%= checked %> <%= disabled %>></TD>
						<TD CLASS="label" ><%=param_legends.get("D")%>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(14).toString().equals("N") || disp_locn_category.equals("I")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(15).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label"><INPUT TYPE="checkbox" name="DELIVER_YN" id="DELIVER_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "DL","<%=param_legends.get("D")%>","OP");'></TD> <!--addToDefStage added for [IN047788]-->
						<TD CLASS="label" ><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(32).toString().equals("N")) {
							disabled = "";
							checked = "";
						}
						else {
							disabled = "";
							checked = "CHECKED";
						}
%>
						<TD CLASS="label"><INPUT TYPE="checkbox" name="OP_REISSUE_MEDICATION_YN" id="OP_REISSUE_MEDICATION_YN" <%= checked %> <%= disabled %>></TD>
					</TR>
					<TR>
						<TD CLASS="label" ><fmt:message key="ePH.AllowReprintingOfPrescription.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(16).toString().equals("Y")) {
							checked = "CHECKED";
							disabled = "";
						}
						else {
							checked = "";
							//disabled = "DISABLED";//commented for inc 12506
							disabled = "";
						}
						if(disp_locn_category.equals("I")){
							checked = "";
							disabled = "DISABLED";
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="ALLOW_REPRINT_YN" id="ALLOW_REPRINT_YN" onclick="disableReprints(this);" <%= checked %> <%= disabled %> ></TD>
						<TD CLASS="label" ><label style="visibility:hidden"><fmt:message key="ePH.No.OfReprintsAllowed.label" bundle="${ph_labels}"/>&nbsp;</label></TD>
						<TD CLASS="label" >&nbsp;<INPUT TYPE="text" CLASS="NUMBER" VALUE="<%= locnDetailsForMod.get(17)%>" NAME="NO_OF_REPRINTS" SIZE="2" MAXLENGTH="2" onBlur="CheckNum(this);" <%= disabled %> style="display:none"></TD>
					</TR>
					<TR>
						<TD CLASS="label" ><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(18).toString().equals("N") || disp_locn_category.equals("I")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(19).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="MEDN_RTN_YN" id="MEDN_RTN_YN" <%= checked %> <%= disabled %> onclick='mednRtnBillGenStatus(this, "OP");'></TD>
						<td class='label'><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.AfterBillGen.label" bundle="${ph_labels}"/></td>
<%
						if(checked.equals(""))
							disabled="disabled";
						else
							disabled = "";
%>
						<td class='label'><SELECT name="OP_MEDN_RTN_AFTER_BILL_GEN" id="OP_MEDN_RTN_AFTER_BILL_GEN" <%=disabled%> >
<%
						if(locnDetailsForMod.get(44).toString().equals("A")){
%>
							<option VALUE=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A' selected><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
						else if(locnDetailsForMod.get(44).toString().equals("N")){
%>
							<option VALUE=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N' selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='' selected>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
%>
						</select>
						</td>
					</TR>
					<TR> <!--addToDefStage added for [IN047788] -start -->
						<td class=label><fmt:message key="ePH.DefaultDispenseStage.label" bundle="${ph_labels}"/></td>
						<td class='label'><SELECT name="OP_DFLT_DISP_STAGE" id="OP_DFLT_DISP_STAGE"  >
							<option VALUE='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
						op_dflt_disp_stage = (String)locnDetailsForMod.get(47);
						if(locnDetailsForMod.get(8).toString().equals("Y")){
							if(op_dflt_disp_stage.equals("VF"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='VF' <%=checked%>><%=param_legends.get("V")%></option>
<%
						}
						if(locnDetailsForMod.get(10).toString().equals("Y")){
							if(op_dflt_disp_stage.equals("FL"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='FL' <%=checked%>><%=param_legends.get("F")%></option>
<%
						}
						if(locnDetailsForMod.get(11).toString().equals("Y")){
							if(op_dflt_disp_stage.equals("AL"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='AL' <%=checked%>><%=param_legends.get("A")%></option>
<%
						}
						if(locnDetailsForMod.get(15).toString().equals("Y")){
							if(op_dflt_disp_stage.equals("DL"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='DL' <%=checked%>><%=param_legends.get("D")%></option>
<%
						}
%>
						</select>
						</td>
						<td class=label><fmt:message key="ePH.DefaultTokenSeries.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td> <!-- added for HSA-CRF-0136 [IN:048412] start-->
<%
						if(register_yn.equals("Y") && issueToken_yn.equals("Y")){
							disabled="";
							dflt_token_series_ind = locnDetailsForMod.get(48).toString();
							sort_token_series_ind = locnDetailsForMod.get(49).toString();
						}
						else{
							disabled="disabled";
						}
%>
						<td class='label'><SELECT name="DFLT_TOKEN_SERIES_IND" id="DFLT_TOKEN_SERIES_IND"  <%=disabled%> >
<%
						if(dflt_token_series_ind.equals("W") ){
%>
							<option VALUE='W' selected><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='W' ><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></option>
<%
						}
						if(dflt_token_series_ind.equals("A") ){
%>
							<option VALUE='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='A' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						}
						if(dflt_token_series_ind.equals("I") ){
%>
							<option VALUE='I' selected><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='I' ><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
<%
						}
%>
						</select>
						&nbsp;&nbsp;&nbsp;<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
						&nbsp;&nbsp;&nbsp;<SELECT name="SORT_TOKEN_SERIES_IND" id="SORT_TOKEN_SERIES_IND"  <%=disabled%>>
<%
						if(sort_token_series_ind.equals("O") ){
%>
							<option VALUE='O' selected><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='O' ><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
<%
						}
						if(sort_token_series_ind.equals("R") ){
%>
							<option VALUE='R' selected><fmt:message key="ePH.RegisterDateTime.label" bundle="${ph_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='R' ><fmt:message key="ePH.RegisterDateTime.label" bundle="${ph_labels}"/></option>
<%
						}
						if(generate_actual_token_yn.equals("Y")){
							if(sort_token_series_ind.equals("P") ){
%>
								<option VALUE='P' selected><fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
<%
							}
							else{
%>
								<option VALUE='P' ><fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
<%
							}
						}
%>
						</select>
						</td> <!-- added for HSA-CRF-0136 [IN:048412] End -->
					</TR> <!--addToDefStage added for [IN047788] -End -->	
					<TR>
						<TD COLSPAN="4" CLASS="label"><B><fmt:message key="ePH.IPSubProcess.label" bundle="${ph_labels}"/> :</B></TD>
					</TR>
					<TR>
						<TD CLASS="label" ><%=param_legends.get("V")%>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(20).toString().equals("N") || disp_locn_category.equals("O")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(21).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_VERIFY_YN" id="IP_VERIFY_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "VF","<%=param_legends.get("V")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
						<TD CLASS="label" ><%=param_legends.get("F")%>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(22).toString().equals("N")|| disp_locn_category.equals("O")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(23).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_ALLOCATE_YN" id="IP_ALLOCATE_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "FL","<%=param_legends.get("F")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
					</TR>
					<TR>
						<TD CLASS="label"><%=param_legends.get("D")%>&nbsp;</TD>
<%
						if (locnDetailsForMod.get(24).toString().equals("N") || disp_locn_category.equals("O")) {
							disabled = "DISABLED";
							checked = "";
						}
						else {
							disabled = "";
							if (locnDetailsForMod.get(25).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_DELIVER_YN" id="IP_DELIVER_YN" <%= checked %> <%= disabled %> onclick='addToDefStage(this, "DL","<%=param_legends.get("D")%>","IP");'></TD> <!--addToDefStage added for [IN047788]-->
						<TD CLASS="label"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></TD>
<%
						if (locnDetailsForMod.get(33).toString().equals("N")) {
							disabled = "";
							checked = "";
						}
						else {
							disabled = "";
							checked = "CHECKED";
						}
%>
						<TD CLASS="label" COLSPAN="4" ><INPUT TYPE="checkbox" name="IP_REISSUE_MEDICATION_YN" id="IP_REISSUE_MEDICATION_YN"<%= checked%><%= disabled %>></TD>
						<TR>
						<TD CLASS="label" ><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/></TD>
<%
						if (locnDetailsForMod.get(26).toString().equals("Y")) {
							checked = "CHECKED";
						}
						else {
							checked = "";
						}
						if(locnDetails.get(12).toString().equals("N")){
							disabled="DISABLED";	
							checked="";
						}
						else{
							disabled="";
						}
%>
						<TD CLASS="label" ><INPUT TYPE="checkbox" name="IP_ACCEPT_MEDN_RTN_YN" id="IP_ACCEPT_MEDN_RTN_YN" <%=checked%> <%= disabled %> onclick='mednRtnBillGenStatus(this, "IP");'> </TD>
						<td class='label'><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.AfterBillGen.label" bundle="${ph_labels}"/></td>
<%
						if(checked.equals(""))
							disabled="disabled";
						else
							disabled = "";
%>
						<td class='label'><SELECT name="IP_MEDN_RTN_AFTER_BILL_GEN" id="IP_MEDN_RTN_AFTER_BILL_GEN" <%=disabled%>>
<%
						if(locnDetailsForMod.get(43).toString().equals("A") ){
%>
							<option VALUE=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A' selected><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
						else if(locnDetailsForMod.get(43).toString().equals("N")){
%>
							<option VALUE=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N' selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option VALUE='' selected>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
							<option VALUE='A'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
							<option VALUE='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
						}
%>
						</select></td>
					</TR>
					<TR>   <!-- Added for ICN30405-->
						<TD CLASS="LABEL" >
							<fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=param_legends.get("F")%>
						</td>
						<TD CLASS="LABEL" >
<%
							//Added for ICN-30405
							selected = ""; fillselected ="";
							if (locnDetailsForMod.get(35).toString() != null && locnDetailsForMod.get(35).toString().equals("WF")) {
								fillselected  = "CHECKED";  // WF
							} 
							else {
								selected	  = "CHECKED";	// AF
							}
%>
							<input type="radio" name="CHK_FILL_LIST" id="CHK_FILL_LIST" <%=selected%> value="AF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
							<input type="radio" name="CHK_FILL_LIST" id="CHK_FILL_LIST" <%=fillselected%> value="WF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						</TD>
						<TD CLASS="LABEL"  >
							<fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=param_legends.get("D")%>
						</td>
						<TD CLASS="LABEL" >
<%
							//Added for ICN-30405
							selected = ""; 
							fillselected ="";
							if (locnDetailsForMod.get(36).toString() != null && locnDetailsForMod.get(36).toString().equals("DF")) {
								fillselected  = "CHECKED";  // DWF
							} 
							else {
								selected	  = "CHECKED";	// DF
							}
%>
							<input type="radio" name="CHK_DELIVER_FILL_LIST" id="CHK_DELIVER_FILL_LIST" <%=selected%> value="DWF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
							<input type="radio" name="CHK_DELIVER_FILL_LIST" id="CHK_DELIVER_FILL_LIST" <%=fillselected%> value="DF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						</TD>
					</TR>	<!-- ICN30405-->
					<TR> <!--addToDefStage added for [IN047788] -start -->
						<td class=label><fmt:message key="ePH.DefaultDispenseStage.label" bundle="${ph_labels}"/></td>
						<td class='label'><SELECT name="IP_DFLT_DISP_STAGE" id="IP_DFLT_DISP_STAGE"  >
							<option VALUE='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
						ip_dflt_disp_stage = (String)locnDetailsForMod.get(46);
						if(locnDetailsForMod.get(21).toString().equals("Y")){
							if(ip_dflt_disp_stage.equals("VF"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='VF' <%=checked%>><%=param_legends.get("V")%></option>
<%
						}
						if(locnDetailsForMod.get(23).toString().equals("Y")){
							if(ip_dflt_disp_stage.equals("FL"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='FL' <%=checked%>><%=param_legends.get("F")%></option>
<%
						}
						if(locnDetailsForMod.get(25).toString().equals("Y")){
							if(ip_dflt_disp_stage.equals("DL"))
								checked="selected";
							else
								checked="";
%>
							<option VALUE='DL' <%=checked%>><%=param_legends.get("D")%></option>
<%
						}
%>
						<td>
						<td colspan='2'>&nbsp;</td>
					</TR> <!--addToDefStage added for [IN047788]- end -->
					<TR>
						<TD COLSPAN="4">&nbsp;</TD>
					</TR>	
					<TR>
						<TD class="label" COLSPAN="4"><B><fmt:message key="ePH.VerificationRights.label" bundle="${ph_labels}"/> :</B></TD>
					</TR>
					<TR>
						<TD class="label"><fmt:message key="ePH.AllowChangeofDose.label" bundle="${ph_labels}"/></TD>
<%
						if (locnDetailsForMod.get(27).toString().equals("Y")) {
							checked = "CHECKED";
						}
						else {
							checked = "";
						}
%>
						<TD class="label"><INPUT TYPE="checkbox" name="CHANGE_DOSE_DURN_VERIFY_YN" id="CHANGE_DOSE_DURN_VERIFY_YN" <%=checked%> onclick="modifyAuthAmendPres(this)"></TD>
						<!-- <TD COLSPAN="2">&nbsp;</TD> COMMENTED FOR ML-MMOH-CRF-0863 -->
							<!-- ADDED FOR ML-MMOH-CRF-0863 START -->
							<%
							if (locnDetailsForMod.get(27).toString().equals("Y")) {
								//System.out.println("prathyusha"+locnDetailsForMod.get(51));
								if (locnDetailsForMod.get(50).toString().equals("Y")) {
									authChecked = "CHECKED";
								}
							%>
							<TD class="label" id="AUTH_AMEND_PRES_LABEL_YN"><fmt:message key="ePH.AUTHAMENDPRESLABEL.label" bundle="${ph_labels}"/></TD>
					        <td >&nbsp;<INPUT name="AUTH_AMEND_PRES_YN" id="AUTH_AMEND_PRES_YN" TYPE="checkbox"  <%=authChecked %>  ></td>
					        <%} else{%>
					         <TD class="label" id="AUTH_AMEND_PRES_LABEL_YN"  style="visibility:hidden" ><fmt:message key="ePH.AUTHAMENDPRESLABEL.label" bundle="${ph_labels}"/></TD>
					        <td style="visibility:hidden" id="AUTH_AMEND_PRES_YN" ><INPUT name="AUTH_AMEND_PRES_YN" id="AUTH_AMEND_PRES_YN" TYPE="checkbox"   ></td>
					        <%} %>
					        <!-- ADDED FOR ML-MMOH-CRF-0863 END -->
					</TR>
						<TR><!-- //Added for CRF-0439 -->
						<TD class="label"><fmt:message key="ePH.UnlockRecordsLockedByOtherUsers.label" bundle="${ph_labels}"/></TD>
<%
							if (locnDetailsForMod.get(34).toString().equals("Y")) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
%>
							<TD class="label"><INPUT TYPE="checkbox" name="UNLOCK_RECORDS_YN" id="UNLOCK_RECORDS_YN" <%=checked%>></TD>
						</TR>
						<TR> <!--added for Bru-HIMS-CRF-087 [IN:029953] - start -->
							<TD COLSPAN="4">&nbsp;</TD>
						</TR>	
						<TR>
							<TD class="label"><B><fmt:message key="ePH.TrackingOutsourceMedication.label" bundle="${ph_labels}"/> :</B></TD>
<%
							String trackOutSourcingDisply="none;";
							if (locnDetailsForMod.get(37).toString().equals("Y")) {
								checked = "CHECKED";
								trackOutSourcingDisply = "inline";
							}
							else {
								checked = "";
								trackOutSourcingDisply = "none";
							}
%>
							<TD class="label" COLSPAN="3"><INPUT TYPE="checkbox" name="TRACK_OUTSOURCING_YN" id="TRACK_OUTSOURCING_YN" onclick='trackOutSourcing(this)' <%=checked%>></TD>
						</TR>
						<TR style='display:<%=trackOutSourcingDisply%>;' id='trOutSourcingAccess'>
							<TD class="label"><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/></TD>
<%
							if (locnDetailsForMod.get(37).toString().equals("Y") && locnDetailsForMod.get(38).toString().equals("Y") ) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
%>
							<TD class="label"><fmt:message key="ePH.Send.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_SEND" id="OUTSOURCING_SEND" onclick='addToDefAction(this,"S");' <%=checked%>></TD>
<%
							if (locnDetailsForMod.get(37).toString().equals("Y") && locnDetailsForMod.get(39).toString().equals("Y") ) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
%>
							<TD class="label"><fmt:message key="ePH.Receive.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_RECEIVE" id="OUTSOURCING_RECEIVE" onclick='addToDefAction(this,"R");' <%=checked%>></TD>
<%
							if (locnDetailsForMod.get(37).toString().equals("Y") && locnDetailsForMod.get(40).toString().equals("Y") ) {
								checked = "CHECKED";
							}
							else {
								checked = "";
							}
%>
							<TD class="label"><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="OUTSOURCING_DELIVER" id="OUTSOURCING_DELIVER" onclick='addToDefAction(this,"D");' <%=checked%>></TD>
						</TR>
						<TR style='display:<%=trackOutSourcingDisply%>;' id='trOutSourcingDefault'>
							<TD class="label"><fmt:message key="ePH.DefTrackAction.label" bundle="${ph_labels}"/></TD>
							<TD class="label">
								<SELECT name="OUTSOURCING_DEF_ACTION" id="OUTSOURCING_DEF_ACTION" >
<%
									if (locnDetailsForMod.get(38).toString().equals("Y")) {
										if(locnDetailsForMod.get(41).toString().equals("S"))
											checked = "selected";
										else
											checked="";
%>
										<option value='S' <%=checked%>><fmt:message key="ePH.Send.label" bundle="${ph_labels}"/></option>
<%
									}
									if (locnDetailsForMod.get(39).toString().equals("Y")) {
										if(locnDetailsForMod.get(41).toString().equals("R"))
											checked = "selected";
										else
											checked="";
%>
										<option value='R' <%=checked%>><fmt:message key="ePH.Receive.label" bundle="${ph_labels}"/></option>
<%
									}
									if (locnDetailsForMod.get(40).toString().equals("Y")) {
										if(locnDetailsForMod.get(41).toString().equals("D"))
											checked = "selected";
										else
											checked="";
%>
										<option value='D' <%=checked%>><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/></option>
<%
									}
									if (!locnDetailsForMod.get(38).toString().equals("Y") && !locnDetailsForMod.get(39).toString().equals("Y") && !locnDetailsForMod.get(40).toString().equals("Y")) {
%>
										<option value=''>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
									}
%>
								</SELECT>
							</TD>
							<TD class="label"><fmt:message key="ePH.DefRefFacility.label" bundle="${ph_labels}"/></TD>
							<TD class="label">
								<SELECT name="OUTSOURCING_DEF_FACILITY" id="OUTSOURCING_DEF_FACILITY" >
									<option value=''>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
									for(int i=0;i<referralfcy.size();i+=2){
										checked="";
										if(locnDetailsForMod.get(42).toString().equals((String)referralfcy.get(i)))
											checked = "selected";
%>
										<option  VALUE="<%=(String)referralfcy.get(i)%>" <%=checked%>><%= referralfcy.get(i+1) %></option>
<%
									}
%>
								</SELECT>
							</TD>
						</TR><!--added for Bru-HIMS-CRF-087 [IN:029953] - End -->
<%
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
%> 
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
			<INPUT TYPE="hidden" name="user_id" id="user_id" VALUE="<%= user_id %>">
			<INPUT TYPE="hidden" name="oldPassword" id="oldPassword" VALUE="<%=bean.getUserPass(user_id) %>">
		</FORM>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</HTML>

