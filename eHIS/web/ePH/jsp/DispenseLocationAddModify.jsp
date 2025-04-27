<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.io.*,java.util.Hashtable, java.util.HashMap,java.sql.*,webbeans.eCommon.*,ePH.*,ePH.SetupAuditLogBean, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseLocation.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<SCRIPT>
			var function_id = "<%= request.getParameter( "function_id" ).trim() %>"

			function tab_click1(outpatient,mode){
				displayPharmacy(outpatient,mode);
			}

			function displayPharmacy(flag,mode) {
				var IPinstalled = document.formDispenseLocation.IP_INSTALLED.value;	
				if ( flag=="outpatient" && IPinstalled == "N") {
					if(document.getElementById('OP_Pharm_link')){
						document.getElementById('OP_Pharm_link').className = "tabClicked";	
						document.getElementById('OP_Pharm_tabspan').className = "tabSpanclicked"; 				
					}
					if(document.getElementById('IP_Pharm_link')){
						document.getElementById('IP_Pharm_link').className = "tabA";
						document.getElementById('inpatient_tabspan').className = "tabAspan";				
					}
					if(document.getElementById('OD_Pharm_link')){
						document.getElementById('OD_Pharm_link').className = "tabA";
						document.getElementById('otherdetails_tabspan').className = "tabAspan";				
					}
					//if (document.getElementById('IP_Pharm'))
					//{
					if (document.getElementById('inpatientTable'))
						document.getElementById('inpatientTable').style.display		= "none";				
					//}
					if (document.getElementById('otherdetailsTable')){
						document.getElementById('otherdetailsTable').style.display		= "none";					
					}		
					document.getElementById('outpatientTable').style.display		= "inline";
					document.getElementById('outpatientTable').style.visibility	= "visible";		
				}
				else if ( flag=="outpatient" && IPinstalled == "Y") {
					if(mode=='1'){
						if (document.getElementById('inpatientTable'))
							document.getElementById('inpatientTable').style.display		= "none";

						if (document.getElementById('otherdetailsTable'))
							document.getElementById('otherdetailsTable').style.display		= "none";

						document.getElementById('OP_Pharm_link').className = "tabClicked";	
						document.getElementById('OP_Pharm_tabspan').className = "tabSpanclicked"; 

						if(document.getElementById('IP_Pharm_link')){
							document.getElementById('IP_Pharm_link').className = "tabA";
							document.getElementById('inpatient_tabspan').className = "tabAspan";
						}
						document.getElementById('OD_Pharm_link').className = "tabA";
						document.getElementById('otherdetails_tabspan').className = "tabAspan";

						document.getElementById('outpatientTable').style.display		= "inline";
						document.getElementById('outpatientTable').style.visibility	= "visible";
					}
					else if(mode=='2'){

						if (document.getElementById('inpatientTable'))
							document.getElementById('inpatientTable').style.display		= "none";

						if (document.getElementById('otherdetailsTable'))
							document.getElementById('otherdetailsTable').style.display		= "none";

						document.getElementById('OP_Pharm_link').className = "tabClicked";
						document.getElementById('OP_Pharm_tabspan').className = "tabSpanclicked";	

						if(document.getElementById('IP_Pharm_link')){
							document.getElementById('IP_Pharm_link').className = "tabA";
							document.getElementById('inpatient_tabspan').className = "tabAspan";
						}

						document.getElementById('OD_Pharm_link').className = "tabA";
						document.getElementById('otherdetails_tabspan').className = "tabAspan";

						document.getElementById('outpatientTable').style.display		= "inline";
						document.getElementById('outpatientTable').style.visibility	= "visible";
					}
					if (document.getElementById('PREPMEDICATION'))	//if block added for Bru-HIMS-CRF-142 [IN:030195]
						document.getElementById('PREPMEDICATION').style.display		= "inline";
				}
				else if ( flag=="inpatient" ) {
					if(mode=='1'){

						if (document.getElementById('outpatientTable'))
						document.getElementById('outpatientTable').style.display="none";

						if (document.getElementById('otherdetailsTable'))
						document.getElementById('otherdetailsTable').style.display		= "none";

						if(document.getElementById('OP_Pharm_link')){
							document.getElementById('OP_Pharm_link').className = "tabA";
							document.getElementById('OP_Pharm_tabspan').className = "tabAspan";
						}
						document.getElementById('IP_Pharm_link').className = "tabClicked";
						document.getElementById('inpatient_tabspan').className = "tabSpanclicked";

						document.getElementById('OD_Pharm_link').className = "tabA";
						document.getElementById('otherdetails_tabspan').className = "tabAspan";

						//document.getElementById('outpatientTable').style.display		= "none";
						document.getElementById('inpatientTable').style.display		= "inline";
						document.getElementById('inpatientTable').style.visibility	= "visible";
					}
					else if(mode=='2'){

						if(document.getElementById('IP_Pharm_link')){
							if(document.getElementById('OP_Pharm_link')){
								document.getElementById('OP_Pharm_link').className = "tabA";
								document.getElementById('OP_Pharm_tabspan').className = "tabAspan";
							}
							document.getElementById('IP_Pharm_link').className = "tabClicked";
							document.getElementById('inpatient_tabspan').className = "tabSpanclicked";
						}
						else{
							document.getElementById('OP_Pharm_link').className = "tabClicked";
							document.getElementById('OP_Pharm_tabspan').className = "tabSpanclicked";
						}
						document.getElementById('OD_Pharm_link').className = "tabA";
						document.getElementById('otherdetails_tabspan').className = "tabAspan";

						if (document.getElementById('outpatientTable'))
							document.getElementById('outpatientTable').style.display		= "none";

						if (document.getElementById('otherdetailsTable'))
							document.getElementById('otherdetailsTable').style.display		= "none";

						document.getElementById('inpatientTable').style.display		= "inline";
						document.getElementById('inpatientTable').style.visibility	= "visible";
					}
					if (document.getElementById('PREPMEDICATION'))
						document.getElementById('PREPMEDICATION').style.display		= "none";	//if block added for Bru-HIMS-CRF-142 [IN:030195]
				}
				else if ( flag=="otherdetails" ) {

					if(mode=='1'){
						outpatientTable.style.display="none";

						if (document.getElementById('inpatientTable'))
						document.getElementById('inpatientTable').style.display		= "none";

						if(document.getElementById('OP_Pharm_link')){
							document.getElementById('OP_Pharm_link').className = "tabA";
							document.getElementById('OP_Pharm_tabspan').className = "tabAspan";
						}

						if(document.getElementById('IP_Pharm_link')){
							document.getElementById('IP_Pharm_link').className = "tabA";
							document.getElementById('inpatient_tabspan').className = "tabAspan";
						}
						document.getElementById('OD_Pharm_link').className = "tabClicked";
						document.getElementById('otherdetails_tabspan').className = "tabSpanclicked";

						document.getElementById('otherdetailsTable').style.display		= "inline";
						document.getElementById('otherdetailsTable').style.visibility	= "visible";
					}
					else if(mode=='2'){

						if(document.getElementById('OP_Pharm_link')){
							document.getElementById('OP_Pharm_link').className = "tabA";
							document.getElementById('OP_Pharm_tabspan').className = "tabAspan";
						}

						if(document.getElementById('IP_Pharm_link')){
							document.getElementById('IP_Pharm_link').className = "tabA";
							document.getElementById('inpatient_tabspan').className = "tabAspan";
						}

						document.getElementById('OD_Pharm_link').className = "tabClicked";
						document.getElementById('otherdetails_tabspan').className = "tabSpanclicked";

						if (document.getElementById('outpatientTable'))
							document.getElementById('outpatientTable').style.display		= "none";

						if (document.getElementById('inpatientTable'))
							document.getElementById('inpatientTable').style.display		= "none";

						document.getElementById('otherdetailsTable').style.display		= "inline";
						document.getElementById('otherdetailsTable').style.visibility	= "visible";
					}
				}
			}
		</SCRIPT>
	</HEAD>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" STYLE="overflow-y:hidden">
<%
//Added for NMC-JD-CRF-0008 start
Connection con			= null;   
try{
	    con						   = ConnectionManager.getConnection(request);
	    boolean ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXT_DISP_APPL");
		boolean display_delivery_bin = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISPLAY_DELIVERY_BIN");//Added for TH-KW-CRF-0020.9
	    
	    //Added for NMC-JD-CRF-0008 end
		/* Mandatory checks start */
		String mode			= request.getParameter( "mode" ).trim() ;
		String bean_id		= "DispenseLocationBean" ;
		String bean_name	= "ePH.DispenseLocationBean";    
		String checked		= "";
		String ex_rx_checked = "";
		String new_pres_checked = "";
		String disabled		= "DISABLED";
		String readOnly		= "";
		String store_code	= "";
		String working_hours_from="";
		String working_hours_to="";
		String select_store_code_sql =  PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT5");
		String admix_prep_alwd_yn = "N";
		String admixPrepAlwdChk	  = "";
		
		String WithDelivery = "";
		String Separate = "";
		String notapplicable = "";
		String notapplicable_receipt = "";
		String UponAllocation = "";
		String UponDelivery = "";
		String disable="";
		String category = "";
		String billingStage = ""; //added for SRR20056-SCF-7639	ICN027720
		String dispCashCollStage = ""; //added for SRR20056-SCF-7639	ICN027720
		String prep_medication_visible=""; //added for Bru-HIMS-CRF-142 [IN:030195]
		ArrayList alDispLocations =	new ArrayList();//Added for HSA-CRF-0113 [IN:048166] 
		String sDefBMSLocation	= 	"", dispSameLoc ="display:none";//Added for HSA-CRF-0113 [IN:048166] 
		String check_del_bin    ="";//Added for TH-KW-CRF-0020.9
		String display_other_fields    ="";//Added for TH-KW-CRF-0020.9
		//String disableOPCategory = "";
		//String disableIPCategory = "";
		//String dispsheet_directdisp_value ="";
		//String displabel_directdisp_value ="";
		

		if ( mode == null || mode.equals("") )
			return ;

		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;
		/* Mandatory checks end */

		/* Initialize Function specific start */
		DispenseLocationBean bean = (DispenseLocationBean)getBeanObject( bean_id, bean_name,request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		//added for audit log
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_DISP_LOCN";
		String pkey_value		="";
		String Daily_Specific_rangeYN = bean.getDailySpecificRangeYN();
		alDispLocations  = bean.getDispenseLocns();//Added for HSA-CRF-0113 [IN:048166] 
		
		/* Initialize Function specific end */
		Hashtable param_legends = bean.getLegendsFromParam();
%>

		<FORM name="formDispenseLocation" id="formDispenseLocation">
		  
			<INPUT TYPE="hidden" name="h_allocate_legend" id="h_allocate_legend" VALUE="<%= param_legends.get("A").toString() %>">
			<INPUT TYPE="hidden" name="h_fill_legend" id="h_fill_legend" VALUE="<%= param_legends.get("F").toString() %>">
			<INPUT TYPE="hidden" name="h_delivery_legend" id="h_delivery_legend" VALUE="<%= param_legends.get("D").toString() %>">
<%
			String dispLocnCode						=	"";
			String style							=	"";
			String  display							=   "";
			String  max_ret_value_from_parameter	=	"", max_durn_for_op_med_rtn="";
			HashMap paramVals	= null;
			if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
				dispLocnCode = request.getParameter("disp_locn_code");
			else
				dispSameLoc = "display";

			if( (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) && bean.loadInitVals() ) || (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.loadValsForModify(dispLocnCode) ) ) {
				String STinstalled	= bean.getStockModuleYN();
				String IPinstalled	= bean.getIPModuleYN();
				String BLinstalled	= bean.getBillingModuleYN();
				if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) && STinstalled.equalsIgnoreCase("Y") )
					disabled = "";

				if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
					sDefBMSLocation = bean.getDefaultBmsLocation();//Added for HSA-CRF-0113 [IN:048166]
					paramVals = bean.getFacilityParamVals();
					max_ret_value_from_parameter=(String)paramVals.get("MAX_DRUG_RETENTION_BEF_RTN");
					max_durn_for_op_med_rtn=(String)paramVals.get("MAX_DURN_FOR_OP_MED_RTN");
					disabled = "DISABLED";
					if (bean.getEffStat().equals("D"))
						readOnly = "READONLY";

					store_code	= bean.getStoreCode();
					if (!store_code.equals(""))
						checked = "CHECKED";				
					admix_prep_alwd_yn = bean.getAdmixPrepAlwd_YN();
					if(admix_prep_alwd_yn.equals("Y")) {
						admixPrepAlwdChk = "CHECKED";
					}
			   /*-------------------------code added for showing audit log---------------------------*/
					//primary_key_1  ------>FACILITY_ID
					//primary_key_2  ------>DISP_LOCN_CODE 			
	  
				//code for adding pk_values
					ArrayList Pk_values    =new ArrayList();
					Pk_values.add(bean.getLoggedInFacility());      
					Pk_values.add(bean.getDispLocnCode());		
					
					String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
					pkey_value   ="";
					if(display_audit_log_button_yn.equals("Y")){
						audit_log_visible= "visibility:visible";
						pkey_value       = (String)log_bean.getpk_value();
					}else{
						audit_log_visible= "visibility:hidden";
						log_bean.clear();
					}
			  /*--------------------------------------ends here---------------------------------------*/
				}
				String disp_level	=	bean.getDispLevel();
%>
				<INPUT TYPE="hidden" name="IP_INSTALLED" id="IP_INSTALLED"    VALUE="<%= IPinstalled %>">
				<INPUT TYPE="hidden" name="ST_INSTALLED" id="ST_INSTALLED"    VALUE="<%= STinstalled %>">
				<INPUT TYPE="hidden" name="BL_INSTALLED" id="BL_INSTALLED"    VALUE="<%= BLinstalled %>">
				<INPUT TYPE="hidden" name="DEF_PHARM_VERFN" id="DEF_PHARM_VERFN" VALUE="<%= bean.getPharmVerfn() %>">
				<INPUT TYPE="hidden" name="DEF_FILL_STAGE" id="DEF_FILL_STAGE"  VALUE="<%= bean.getFillingStage() %>">
				<INPUT TYPE = 'hidden' NAME ='PARAM_FCLTY_DISP_FLAG' VALUE ='<%=bean.getPrintDispSheet_phparam()%>'/>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="99%" ALIGN="center" BORDER="0" name='MainTable' id='MainTable'>
					<TR>
						<TD>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" name='Subtable1' id='Subtable1'>
								<TR>
									<TH ALIGN="left" COLSPAN="4"><fmt:message key="Common.LocationDetails.label" bundle="${common_labels}"/></TH>
								</TR>
								<TR>
									<TD WIDTH="30%"  CLASS="label"><fmt:message key="ePH.LinktoanExistingStore.label" bundle="${ph_labels}"/></TD>
									<TD width='20%'  CLASS="label"><INPUT TYPE="checkbox" name="LINK_EXIST_STORE" id="LINK_EXIST_STORE" VALUE="D" <%= disabled %> <%= checked %> onClick="setDisabled(this)">
									</td>
<%
									disabled = "DISABLED";
%>
									<TD width='30%' CLASS="label">
										<fmt:message key="ePH.AdmxPrepAllwd.label" bundle="${ph_labels}"/> 
									</TD>
									<TD  width='20%' CLASS="label"><INPUT TYPE="checkbox" name="ADMIX_PREP_ALWD" id="ADMIX_PREP_ALWD" VALUE="<%=admix_prep_alwd_yn%>" <%=admixPrepAlwdChk%> onClick="setDisabled(this)">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
								</TR>
								<TR>
									<TD  CLASS="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></TD>
									<TD  CLASS="label" colspan='3'>
									<INPUT TYPE="text" name="STORE_CODE" id="STORE_CODE" CLASS="UPPER" VALUE="<%= store_code %>" SIZE="15" MAXLENGTH="15" <%= disabled %> onKeyPress="return CheckForSpecChars(event)" onBlur="validateCode(this)">&nbsp;<INPUT TYPE="button" CLASS="button" name="STORE_SEARCH" id="STORE_SEARCH" VALUE="?" <%= disabled %>  onClick="searchCode(STORE_CODE)">
<%
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) && STinstalled.equalsIgnoreCase("Y") ) {
%>
									<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:hidden" ID="st_mandate"></IMG>

<%
								}
%>
								<INPUT TYPE="hidden" name="SQL_PH_DISP_LOCN_SELECT5" id="SQL_PH_DISP_LOCN_SELECT5" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT5" ) %>">
								</TD>
							</TR>
							<TR>
								<TD  CLASS="label"><fmt:message key="ePH.DispenseLocationCode.label" bundle="${ph_labels}"/></TD>
								<TD  CLASS="label">
<%
								if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){	
									disabled = "DISABLED";
									display="display";
									working_hours_from=bean.getWorkingFrom();
									working_hours_to=bean.getWorkingTo();
								}
								else{
									disabled = "";display="none";
									working_hours_from="00:00";
									working_hours_to="23:59";
								}
%>              
								<INPUT TYPE="text" name="DISP_LOCN_CODE" id="DISP_LOCN_CODE" CLASS="UPPER" VALUE="<%= bean.getDispLocnCode() %>" SIZE="6" <%= disabled %> MAXLENGTH="6" onKeyPress="return CheckForSpecChars( event )" onBlur="this.value=this.value.toUpperCase();validateCode(this)">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="disp_mandate"></IMG>
								</TD>
								<td  class="label"  BORDER="0" ID="time_links" STYLE="display:<%=display %>"><fmt:message key="ePH.WorkinghoursFrom.label" bundle="${ph_labels}"/>
									<input type="text" name="working_hour_from" id="working_hour_from" size="3" maxlength="5" value= "<%=working_hours_from%>" onBlur="validate(this);">&nbsp;<IMG 	SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="from_mandate"></IMG>
									&nbsp;To <input type="text" name="working_hour_to" id="working_hour_to" size="3" maxlength="5" value="<%=working_hours_to %>" onBlur="validate(this);">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="to_mandate"></IMG>
								</td>
								</TR><TR>
									<TD  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TD>
									<TD  class="label">
										<INPUT TYPE="text" name="LONG_DESC" id="LONG_DESC" VALUE="<%= bean.getLongDesc() %>" SIZE="24" <%= readOnly %> MAXLENGTH="40">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="longdesc_mandate"></IMG>
									</TD>
									<TD  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TD>
									<TD  class="label">
										<INPUT TYPE="text" name="SHORT_DESC" id="SHORT_DESC" VALUE="<%= bean.getShortDesc() %>" SIZE="13" <%= readOnly %> MAXLENGTH="15">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="shortdesc_mandate"></IMG>
									</TD>
								</TR>
								<TR>
									<TD class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD>
									<TD class="label">
<%
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
%>
									<SELECT name="DISP_LOCN_TYPE" id="DISP_LOCN_TYPE" onChange="showSelect(this.value);showtimings(this.value);">
									<OPTION VALUE="">&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;</OPTION> 
									<OPTION VALUE="P" ><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
<%
									if (IPinstalled.equalsIgnoreCase("Y")) {
%>
										<OPTION VALUE="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
<%
									}
%>
									</SELECT>
<%
								}
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									String dispLocnType = bean.getDispLocnType();
%>
									<INPUT TYPE="hidden" name="DISP_LOCN_TYPE" id="DISP_LOCN_TYPE" VALUE="<%= dispLocnType %>" SIZE="10" MAXLENGTH="15" <%= disabled %>>
<%
									if (dispLocnType.equals("P")) 
										dispLocnType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels");
									else if (dispLocnType.equals("N")) 
										dispLocnType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
									else if (dispLocnType.equals("C")) 
										dispLocnType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
%>
									&nbsp;<INPUT TYPE="text" name="DISP_LOCN_TYPE_LBL" id="DISP_LOCN_TYPE_LBL" VALUE="<%= dispLocnType %>" SIZE="10" MAXLENGTH="15" <%= disabled %>>
<%
								}
%>
								<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
								</TD>
								<TD  CLASS="label" colspan='2'>
<%
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
%>

										<SELECT name="DISP_LOCN_CATEGORY" id="DISP_LOCN_CATEGORY" onChange="disableLinks(this.value)" ID="catgSelect" STYLE="visibility:hidden">
<%
									if (IPinstalled.equalsIgnoreCase("Y")) {
%>
										<OPTION VALUE="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
										<OPTION VALUE="O"><fmt:message key="ePH.OPPharmacy.label" bundle="${ph_labels}"/></OPTION>
										<OPTION VALUE="I"><fmt:message key="ePH.IPPharmacy.label" bundle="${ph_labels}"/></OPTION>
<%
									}
									else {
%>
										<OPTION VALUE="O"><fmt:message key="ePH.OPPharmacy.label" bundle="${ph_labels}"/></OPTION>
<%
									}
%>
									</SELECT>

									<!-- added hidden variable for onlineprint setup -->
									<input type = 'hidden' name='pharmacyType' id='pharmacyType' value =""/>
									<!-- added hidden variable for onlineprint setup -->

									<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" ID="MANDATE_CATEGORY" STYLE="visibility:hidden"></IMG>
									<label class="label" style="visibility:hidden" id="STAGE_LABEL_ID"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></label>&nbsp;
									<select name="DISP_STAGE" id="DISP_STAGE" style="visibility:hidden" id="DISP_STAGE_ID">
										<option value="A"><fmt:message key="ePH.AnyStage.label" bundle="${ph_labels}"/></option>
										<option value="S"><fmt:message key="ePH.SingleStage.label" bundle="${ph_labels}"/></option>
										<option value="M"><fmt:message key="ePH.MultipleStage.label" bundle="${ph_labels}"/></option>
									</select>
									<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" ID="MANDATE_STAGE" STYLE="visibility:hidden"></IMG>
									</TD>
<%
								}
								else if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getDispLocnType().equals("P")) {
									category = bean.getDispLocnCategory();
									if (category.equals("O")) 
										category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OPPharmacy.label","ph_labels");
									else if (category.equals("I")) 
										category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.IPPharmacy.label","ph_labels");
									else if (category.equals("B")) 
										category =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OPIPPharmacy.label","ph_labels");
									else 
										category="";


									String stage = bean.getDispStage();
									if(stage.equals("S")){
										stage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SingleStage.label","ph_labels");
									}
									else if (stage.equals("M")){
										stage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MultipleStage.label","ph_labels");
									}
									else if (stage.equals("A")){
										stage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnyStage.label","ph_labels");
									}
									else{
										stage = "";
									}
									String displayStage = "";
									if(!stage.equals("")){
										displayStage = ",&nbsp;"+stage;
									}
%>
									<%= category %>&nbsp;<%= displayStage %>
<%
								}
%>
								&nbsp;</td>
							</TR>
							<%if(ext_disp_appl){ //added for nmc-jd-crf-0008 start %>
							<TR>
									<td class="label"><fmt:message key="ePH.ExternalDispensing.label" bundle="${ph_labels}"/></td>
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									    checked="";
									}
									else{
										if(bean.getExtDispAppYN().equals("Y")){
											checked="checked";
										}
										else{
											checked="";
										} 
									}
%>
									<td class='label'>
										<INPUT TYPE="checkbox" name="EXT_DISP_YN" id="EXT_DISP_YN"  VALUE="Y" <%=checked%> onClick="validateExtDisp(this)">
									</td>
							</TR>
							<%}//added for nmc-jd-crf-0008 end %>		
							<TR>
								<TD CLASS="label"><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></TD>
								<TD  CLASS="label">
<%
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									if (bean.getDirdispYN().equals("N")){
										checked	 = "";
										disabled="disabled";			
									}
									else if (bean.getDirdispYN().equals("Y")){
										checked	 = "checked";
										disabled="";
									}
%>
									<INPUT TYPE="checkbox" name="DIRECT_DISP_ALLOWED_YN" id="DIRECT_DISP_ALLOWED_YN" <%=checked%><%=disabled%>   VALUE="Y" onClick="setDisabled(this)">
<%
								}
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									if (bean.getDirdispAllowe().equals("N")){
										checked	 = "";
									}
									else if (bean.getDirdispAllowe().equals("Y")){
										checked	 = "checked";
									}
%>
									<INPUT TYPE="checkbox" name="DIRECT_DISP_ALLOWED_YN" id="DIRECT_DISP_ALLOWED_YN" <%=checked%> VALUE="Y" onClick="setDisabled(this)">
<%
								}
%>
									</TD>
									<td class="label"><fmt:message key="ePH.ExternalPrescription.label" bundle="${ph_labels}"/></td>
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										ex_rx_checked=(bean.getExternalPrescriptionYN().equals("Y"))?"checked":"";
									}
									else if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
										ex_rx_checked=(bean.getExternalPrescriptionYN().equals("Y"))?"checked":"";
									}
%>
									</td>
									<td class='label'>
									<INPUT TYPE="checkbox" name="EXTERNAL_RX_ALLOWED_YN" id="EXTERNAL_RX_ALLOWED_YN" <%=ex_rx_checked%> VALUE="Y" onClick="">
									</td>
								</TR>
								<!--  Added for KDAH-CRF-0231 [IN-034551] - Barcode CRF Changes. start-->
								<TR>
									<td class="label"><fmt:message key="ePH.BarCodeScan.label" bundle="${ph_labels}"/></td>
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									    checked="";
									}
									else{
										if(bean.getBarcode_Scan_YN().equals("Y")){
											checked="checked";
										}
										else{
											checked="";
										} 
									}
%>
									<td class='label'>
										<INPUT TYPE="checkbox" name="BAR_SCAN_ALLOWED_YN" id="BAR_SCAN_ALLOWED_YN"  VALUE="Y" <%=checked%> onClick="">
									</td>
								<!-- added for KDAH-CRF-0231 [IN-034551] - Barcode CRF Changes. end-->
									<!--  RUT-CRF-0035 [IN029926] PIN Authentication Checkbox added begin -->
									<td class="label"><fmt:message key="ePH.PinAuthInDispMed.label" bundle="${ph_labels}"/></td>
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									    checked="";
									}
									else{
										if(bean.getPIN_Auth_DispMed().equals("Y")){
											checked="checked";
										}
										else{
											checked="";
										} 
									}
%>
									<td class='label'>
									<INPUT TYPE="checkbox" name="PIN_AUTH_DISP_YN" id="PIN_AUTH_DISP_YN"  VALUE="Y" <%=checked%> >
									</td>
								</TR>
								<!--  RUT-CRF-0035 [IN029926] PIN Authentication Checkbox added end -->
								<TR>
									<TD CLASS="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
									<TD class='label'>
<%
									if (bean.getEffStat().equals("E"))
										checked	 = "CHECKED";
									else
										checked	 = "";
%>
									<INPUT TYPE="checkbox" name="EFF_STATUS" id="EFF_STATUS" <%= checked %> VALUE="<%= bean.getEffStat() %>" onClick="setDisabled(this)">
								</TD>
<%	
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || !disp_level.equals(""))
								   style="visibility:visible";
								else
									style="visibility:hidden";
%>
								<td class="label"  id="disp_level_td" style="<%=style%>"><fmt:message key="ePH.DispenseLevel.label" bundle="${ph_labels}"/>&nbsp;

								<select name="disp_level" id="disp_level" id="disp_level" style="<%=style%>">
<%
								if(disp_level.equals("O")) {	
%>
									<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
									<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<% 
								} 
								else if(disp_level.equals("P")) { 
%>
									<option value="O"><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
									<option value="P" selected><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<%	
								}
								else { 
%>
									<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
									<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<%	
								}
%>
								</select>
								</td>
								<td class='label'>
								<a href="javascript:callremarks()" title='<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>' name="Remarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><input type='hidden' name='hidden_remarks' id='hidden_remarks' value="">
								</td>
							</TR>
						</TABLE><!--End of subtale1-->
<%			
						if ((mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && !(bean.getDispLocnType().equals("P"))) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ){
%>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="PharmacyTable" STYLE="display:none">
<%
						}
						else{
%>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="PharmacyTable">
<%
						}
%>
							<TR>
								<TD>
									<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="DispenseDetailTable">
										<TR>
											<TH ALIGN="left" COLSPAN="4"><fmt:message key="ePH.DispenseDetail.label" bundle="${ph_labels}"/></TH>
										</TR>
										<TR>

<%
										if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
											disabled = "DISABLED";
										else
											disabled = "";
%>

										<TD WIDTH="28%" CLASS="label"><B><fmt:message key="ePH.DispensableDrugClasses.label" bundle="${ph_labels}"/></B></TD>
<%
										if (bean.getGenDrug().equals("Y"))
											checked	 = "CHECKED";
										else
											checked	 = "";
%>

										<TD WIDTH="24%"  CLASS="label"><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="DISP_DRUG_CLASS_G" id="DISP_DRUG_CLASS_G" VALUE="<%= bean.getGenDrug() %>" <%= disabled %> <%= checked %> onClick="setDisabled(this)"></TD>

<%
										if (bean.getNarcoDrug().equals("Y"))
											checked	 = "CHECKED";
										else
											checked	 = "";
%>

										<TD WIDTH="24%"  CLASS="label"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="DISP_DRUG_CLASS_N" id="DISP_DRUG_CLASS_N" VALUE="<%= bean.getNarcoDrug() %>" <%= disabled %> <%= checked %> onClick="setDisabled(this)"></TD>

<%
										if (bean.getControlDrug().equals("Y"))
											checked	 = "CHECKED";
										else
											checked	 = "";
%>

										<TD WIDTH="24%"  CLASS="label"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="DISP_DRUG_CLASS_C" id="DISP_DRUG_CLASS_C" VALUE="<%= bean.getControlDrug() %>" <%= disabled %> <%= checked %> onClick="setDisabled(this)"></TD>
									</TR>
								</TABLE> <!-- End of DispenseDetailTable-->
<%
							if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getDispLocnType().equals("P")) {
%>

								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" BORDER="0" ID="pharm_links">
<%
							}
							else {
%>
								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" BORDER="0" ID="pharm_links" STYLE="display:none">
<%
							}
%>
							<TH ALIGN="left" COLSPAN="3"><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></TH>
						<TR>
<%
						if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getDispLocnType().equals("P")){
							if (bean.getDispLocnCategory().equals("O")){
%>
								<TD ID="OP_Pharm_lin" class="white" WIDTH="25%" HEIGHT="20">
								<ul id="tablist" class="tablist" >
								<li class="tablistitem" title='<fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/>'>
								<a onclick="tab_click1('outpatient','2')" class="tabClicked" id="OP_Pharm_link" >
								<span class="tabSpanclicked" id="OP_Pharm_tabspan"><fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/></span>
								</a>
								</li>	
								</ul> 
								</td>
<%
							}
							else if (bean.getDispLocnCategory().equals("I")){
%>
								<TD ID="OP_Pharm_lin" class="white" WIDTH="25%" HEIGHT="20">
								<ul id="tablist" class="tablist" >
								<li class="tablistitem" title='<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/>'>
								<a onclick="tab_click1('inpatient','2')"class="tabClicked" id="OP_Pharm_link" >
								<span class="tabSpanclicked" id="OP_Pharm_tabspan">
								<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/></span>
								</a>
								</li>	
								</ul> 
								</td>
<%
							}
							else if (bean.getDispLocnCategory().equals("B")){
%>
								<tr>
									<TD ID="OP_Pharm_lin" class="white"  width="25%" onMouseover="changeCursor(this)">
									<ul id="tablist" class="tablist" >
									<li class="tablistitem" title='<fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click1('outpatient','2')" class="tabClicked" id="OP_Pharm_link" >
									<span class="tabSpanclicked" id="OP_Pharm_tabspan">
									<fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/></span>
									</a>
									</li>	
									</ul>
									</td>		
									 <TD ID="IP_Pharm_lin" class="white" width="25%" onMouseover="changeCursor(this)">          
									<ul id="tablist" class="tablist" >
									<li class="tablistitem" title='<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click1('inpatient','2')" class="tabA" id="IP_Pharm_link" >
									<span class="tabAspan" id="inpatient_tabspan">
									<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/></span>
									</a>
									</li>	
								   </ul>
								   </td>
<%
								}
%>
								<TD ID="OD_Pharm_lin" class="white" onMouseover="changeCursor(this)">   
								<ul id="tablist" class="tablist" >
								<li class="tablistitem" title='<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/>'>
								<a onclick="tab_click1('otherdetails','2')" class="tabA" id="OD_Pharm_link" >
								<span class="tabAspan" id="otherdetails_tabspan">
								<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
								</a>
								</li>	
								</ul>
								</td>
							 </tr>
<%
						}
						else {
%>
							<tr>
								<TD ID="OP_Pharm_lin" class="white"  width="25%"  onMouseover="changeCursor(this)">
								<ul id="tablist" class="tablist" >
								<li class="tablistitem" title='<fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/>'>
								<a onclick="tab_click1('outpatient','1')" class="tabClicked" id="OP_Pharm_link" >
								<span class="tabSpanclicked" id="OP_Pharm_tabspan">
								<fmt:message key="ePH.OutpatientPrescription.label" bundle="${ph_labels}"/></span>
								</a>
								</li>	
								</ul>
								</td>
<%
								if (IPinstalled.equalsIgnoreCase("Y")) {
%>
									<TD ID="IP_Pharm_lin" class="white"   width="25%" onMouseover="changeCursor(this)">   
									<ul id="tablist" class="tablist" >
									<li class="tablistitem" title='<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click1('inpatient','1')" class="tabA" id="IP_Pharm_link" >
									<span class="tabAspan" id="inpatient_tabspan">
									<fmt:message key="ePH.InpatientPrescription.label" bundle="${ph_labels}"/></span>
									</a>
									</li>	
								   </ul>
									</TD>
<%
								}
%>
								<TD ID="OD_Pharm_lin" class="white" onMouseover="changeCursor(this)">   
								<ul id="tablist" class="tablist" >
								<li class="tablistitem" title='<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/>'>
								<a onclick="tab_click1('otherdetails','1')" class="tabA" id="OD_Pharm_link" >
								<span class="tabAspan" id="otherdetails_tabspan">
								<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
								</a>
								</li>	
							   </ul>
								</td>
								</tr>
<%		
							}
%>
							</TR>
						</TABLE> <!--End of pharm_links -->
<%
						if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && bean.getDispLocnType().equals("P") && (bean.getDispLocnCategory().equals("O") || bean.getDispLocnCategory().equals("B"))) ) {
							String style_OP_table = "";
							if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) )
								style_OP_table = "display:none";
%>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="outpatientTable" STYLE="<%= style_OP_table %>">
								<TR>
									<TD WIDTH="18%" ALIGN="left" CLASS="label"><B><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></B>
									</TD>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getRegistration().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("DISP_REGN_REQD_YN").toString().equals("Y")) {
											if (bean.getRegistration().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
											}
											else {
												checked	 = "";
												disabled = "";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";							
									}
%>
									<TD WIDTH="17%"  CLASS="label"><%= param_legends.get("R") %></TD>
									<TD WIDTH="7%" ALIGN="left" CLASS="label"><INPUT TYPE="checkbox" name="REGN_CHK_BOX" id="REGN_CHK_BOX" VALUE="<%= bean.getRegistration() %>" <%=checked%> <%=disabled%> onClick="setDisabled(this)"></TD>
<%
									checked="";
									disabled="";
									//added for Bru-HIMS-CRF-142 [IN:030195] -Start
									if (bean.getIssueToken().equals("Y")){	
										checked	 = "CHECKED";
										prep_medication_visible ="visibility:visible";
									}
									else{
										checked	 = "";
										if(display_delivery_bin){//Adding end for TH-KW-CRF-0020.9
										  prep_medication_visible ="visibility:visible";
										  display_other_fields    ="visibility:hidden";
										}else{
											prep_medication_visible ="visibility:hidden";
											display_other_fields    ="visibility:hidden";
										}//Adding end for TH-KW-CRF-0020.9
									}

									if (bean.getRegistration().equals("Y"))
										disabled = "";
									else
										disabled = "DISABLED";	
									//added for Bru-HIMS-CRF-142 [IN:030195] -End
									if (bean.getPrintPresc().equals("Y"))
										checked	 = "CHECKED";
									else
										checked	 = "";

									if (bean.getRegistration().equals("Y"))
										disabled = "";
									else
										disabled = "DISABLED";

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									<TD WIDTH="20%"  CLASS="label"><fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="20%" ALIGN="left" CLASS="label" colspan='2'><INPUT TYPE="checkbox" name="PRINT_PRES" id="PRINT_PRES" VALUE="<%= bean.getPrintPresc() %>"  <%= checked %> <%= disabled %> onClick="setDisabled(this)">
<%
									checked="";
									disabled="";
									if (bean.getIssueToken().equals("Y"))
										checked	 = "CHECKED";
									else
										checked	 = "";

									if (bean.getRegistration().equals("Y"))
										disabled = "";
									else
										disabled = "DISABLED";

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.IssueToken.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="17%" ALIGN="left" CLASS="label"><INPUT TYPE="checkbox" name="ISSUE_TOKEN" id="ISSUE_TOKEN" VALUE="<%= bean.getIssueToken() %>"  <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
								</TR>
								<TR>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getFilling().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("DISP_FLNG_REQD_YN").toString().equals("Y")) {
											if (bean.getFilling().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
											}
											else {
												checked	 = "";
												disabled = "";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";					
									}
%>
                                    <TD COLSPAN="1" ALIGN="left">
									<TD COLSPAN="1"  CLASS="label"><%=param_legends.get("F")%></TD>
									<TD WIDTH="5%" ALIGN="left" CLASS="label"><INPUT TYPE="checkbox" name="FILLING_CHK_BOX" id="FILLING_CHK_BOX" VALUE="<%= bean.getFilling() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
									<TD WIDTH="20%"  CLASS="label"><%=param_legends.get("F") %><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></TD>
									<TD COLSPAN="1" ALIGN="left" CLASS="label">
<%
									disabled="";
									String selectNotApp = "";
									String selectBefAll = "";
									String selectAftAll = "";

									if (bean.getFilling().equals("N")) {
										selectNotApp = "SELECTED";
										disabled = "DISABLED";
									}
									else {
										disabled = "";
										if (bean.getFillingStage().equals("B")) selectBefAll = "SELECTED";
										else if (bean.getFillingStage().equals("A")) selectAftAll = "SELECTED";
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									&nbsp;<SELECT name="FILLING_STAGE" id="FILLING_STAGE" onChange="populateData(document.formDispenseLocation.PHARM_VERFN, this.value)" <%= disabled %>>
<%
									if (bean.getFilling().equals("N")) {
%>
										<OPTION VALUE="X" <%= selectNotApp %>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
<%
									}
									else {
%>
										<OPTION VALUE="B" <%= selectBefAll %>><fmt:message key="ePH.Before.label" bundle="${ph_labels}"/> <%=param_legends.get("A") %></OPTION>
										<OPTION VALUE="A" <%= selectAftAll %>><fmt:message key="Common.After.label" bundle="${common_labels}"/> <%= param_legends.get("A") %></OPTION>
<%
									}
%>
									</SELECT>
									</TD>
								</TR>
								<TR>
									<TD COLSPAN="2"  CLASS="label"><fmt:message key="ePH.Pharmacist.label" bundle="${ph_labels}"/> <%= param_legends.get("V")%></TD>
									<TD COLSPAN="1" ALIGN="left">
<%
									String selectSBF = "";
									String selectSBA = "";
									String selectCWA = "";
									disabled = "";
									if (bean.getPharmVerfn().equals("F")) 
										selectSBF = "SELECTED";
									else if (bean.getPharmVerfn().equals("B")) 
										selectSBA = "SELECTED";
									else if (bean.getPharmVerfn().equals("C")) 
										selectCWA = "SELECTED";

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									&nbsp;<SELECT name="PHARM_VERFN" id="PHARM_VERFN" <%= disabled %>>
<%
									if (bean.getFillingStage().equals("A") || bean.getFillingStage().equals("X")) {
%>
										<OPTION VALUE="B" <%= selectSBA %>><fmt:message key="ePH.SeparateBefore.label" bundle="${ph_labels}"/> <%=param_legends.get("A")%></OPTION>
<%
									}
									else {
%>
										<OPTION VALUE="F" <%= selectSBF %>><fmt:message key="ePH.SeparateBeforeFill.label" bundle="${ph_labels}"/></OPTION>
<%
									}
%>
									<OPTION VALUE="C" <%= selectCWA %>><fmt:message key="ePH.CombinedWith.label" bundle="${ph_labels}"/> <%= param_legends.get("A") %></OPTION>
									</SELECT>
									</TD>
									<td   class="label"><fmt:message key="ePH.DispensePeriod.label" bundle="${ph_labels}"/>
									</td>
									<td class="label" COLSPAN="1">&nbsp;<input type="text" name="op_disp_period" id="op_disp_period" size=3 CLASS="NUMBER" maxlength="3" value="<%=bean.getOpDispPeriod()%>" <%=disabled%> onKeyPress="return CheckForSpecChars( event )" onBlur="checkIsNotZero(this, 'Dispense Period');CheckNum(this);validNumber(this);"> &nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
									</td>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getDelivery().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("DISP_DELV_REQD_YN").toString().equals("Y")) {
											if (bean.getDelivery().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
											}
											else {
												checked	 = "";
												disabled = "";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";					
									}
%>									 
									<TD WIDTH="15%"  CLASS="label"><%= param_legends.get("D")%></TD>
									<TD WIDTH="10%" ALIGN="left" CLASS="label" COLSPAN="2"><INPUT TYPE="checkbox" name="DELIVERY_CHK_BOX" id="DELIVERY_CHK_BOX" VALUE="<%= bean.getDelivery() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
								</TR>
								<TR>
									<TD COLSPAN="1"  CLASS="label" style='visibility:hidden'><%= param_legends.get("B") %> Stage</TD>
									<TD COLSPAN="1" ALIGN="left" style='visibility:hidden'>
<%
									String selectNA		= "";
									//String selectCWAl	= "";
									//String selectSAA	= "";
									if (BLinstalled.equals("N")) {
										disabled = "DISABLED";
										selectNA	 = "SELECTED";
									}
									//else {
										//disabled = "";
									//	if (bean.getBillGen().equals("C")) selectCWAl = "SELECTED";
										//else if (bean.getBillGen().equals("A")) selectSAA = "SELECTED";
									//}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									&nbsp;<SELECT name="BILL_GEN_CASH_COLL" id="BILL_GEN_CASH_COLL" <%= disabled %>>
									<OPTION VALUE="X" selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="C"><fmt:message key="ePH.CombinedWith.label" bundle="${ph_labels}"/> <%= param_legends.get("A") %></OPTION>
									<OPTION VALUE="A" ><fmt:message key="ePH.SeparateAfter.label" bundle="${ph_labels}"/> <%= param_legends.get("A") %></OPTION>
									</SELECT>
									</TD>

									
								</TR>
<!-- below lines of code is commented with ref to CRF 293.1 Print Dispensing labels -->
				<!-- <TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
					<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.Outputs.label" bundle="${ph_labels}"/></B></TD>
				

				</TR>
				<TR>
					<TD COLSPAN="2"  CLASS="label"><fmt:message key="ePH.PrintBalanceMedicationSheetonPartialDispensing.label" bundle="${ph_labels}"/></TD> -->

<%
/*
			checked="";
			disabled="";
			if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
				if (bean.getPrintBalMedSheet().equals("Y")) {
					checked	 = "CHECKED";
					disabled = "";
				}
				else {
					checked	 = "";
					disabled = "DISABLED";
				}
			}

			if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
				if (paramVals.get("PRINT_BAL_MED_SHEET_OP_YN").toString().equals("Y")) {
					if (bean.getPrintBalMedSheet().equals("Y")) {
						checked	 = "CHECKED";
						disabled = "";
					}
					else {
						checked	 = "";
						disabled = "";
					}
				}
				else {
					checked	 = "";
					disabled = "DISABLED";
				}

				if (bean.getEffStat().equals("D"))
					disabled = "DISABLED";					
			}*/
%>

					<!-- <TD WIDTH="30%" ALIGN="left" CLASS="label">&nbsp;<INPUT TYPE="checkbox" name="PRINT_BAL_MED_SHEET" id="PRINT_BAL_MED_SHEET" VALUE="<%= bean.getPrintBalMedSheet() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
				</TR>
				</TABLE>  -->
<!-- above lines of code is commented with ref to CRF 293.1 Print Dispensing labels --> 

								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.DRUGRETURN.label" bundle="${ph_labels}"/></B>
									</TD>
<%
									checked="";
									disabled="";
									String img_ret_mand = "";

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getMedReturn().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
											img_ret_mand = "visibility:visible";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
											img_ret_mand = "visibility:hidden";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("ALLOW_DRUG_RETURN_YN").toString().equals("Y")) {
											if (bean.getMedReturn().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
												img_ret_mand = "visibility:visible";
											}
											else {
												checked	 = "";
												disabled = "";
												img_ret_mand = "visibility:hidden";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";
									}
%>
									<TD WIDTH="45%"  CLASS="label" colspan='2' ><fmt:message key="ePH.AllowMedicationReturn.label" bundle="${ph_labels}"/>
									</TD>
									<TD WIDTH="11%" ALIGN="left" CLASS="label" colspan='4'>&nbsp;<INPUT TYPE="checkbox" name="ALLOW_MED_RETURN" id="ALLOW_MED_RETURN" VALUE="<%= bean.getMedReturn() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)">&nbsp;<fmt:message key="Common.within.label" bundle="${common_labels}"/>&nbsp;
<%				
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (bean.getMedReturn().equals("N"))
											disabled = "DISABLED";
									}

									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									&nbsp;<INPUT TYPE="text" name="RETURN_WITHIN" id="RETURN_WITHIN" CLASS="NUMBER" VALUE="<%= bean.getReturnWithin() %>" SIZE="3" MAXLENGTH="4" <%= disabled %> onKeyPress="return CheckForSpecChars( event )" onBlur="validNumber(this);validateForGreaterValue('<%= max_durn_for_op_med_rtn %>', this,2)">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
									&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= img_ret_mand %>" ID="return_mandate"></IMG>
									</TD> <!-- maxlength changed from 2 to 4 for  Bru-HIMS-CRF-419 [IN:045563]-->
								</TR>
								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.UNDELIVEREDDRUGS.label" bundle="${ph_labels}"/></B></TD>
<%
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getReturnWithin().equals("")) {
											disabled = "DISABLED";
										}
										else {
											disabled = "";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("MAX_DRUG_RETENTION_BEF_RTN").toString().equals("")) {
											disabled = "DISABLED";
										}
										else {
											disabled = "";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";					
									}
%>
									<TD WIDTH="56%"  CLASS="label" colspan='2'><fmt:message key="ePH.MaxDrugsRetentionPeriodBeforeReturn.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%" ALIGN="left" CLASS="label" colspan='4'>&nbsp;<INPUT TYPE="text" name="MAX_RETURN_STOCK" id="MAX_RETURN_STOCK" CLASS="NUMBER" VALUE="<%=bean.getMaxRetPrd() %>" SIZE="3" MAXLENGTH="4" <%= disabled %> onKeyPress="return CheckForSpecChars( event )" onBlur="validNumber(this);validateForGreaterValue('<%= max_ret_value_from_parameter %>', this,0)">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></TD> <!-- MAXLENGTH increased to 4 for  TTM-SCF-0078 [IN:047180] -->
								</TR>
<%
								checked="";
								disabled="";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									if (bean.getGenerateTokonReissueYN().equals("Y")) {
										checked	 = "CHECKED";
									}
									else {
										checked	 = "";
									}
								}
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									if (bean.getGenerateTokonReissueYN().equals("Y")) {
										checked	 = "CHECKED";
									}
									else {
										checked	 = "";
									}
									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";						
								}
%>
								<TR>
									<TD WIDTH="25%" ALIGN="left" class="label"><B><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></B>
									</TD>
									<TD WIDTH="45%"  CLASS="label" colspan='2'><fmt:message key="ePH.GenerateTokonuponReissue.label" bundle="${ph_labels}"/>
									</TD>
									<TD WIDTH="30%" ALIGN="left" CLASS="label" colspan='4'>&nbsp;<INPUT TYPE="checkbox" name="GENERATE_TOKON_REISSUE" id="GENERATE_TOKON_REISSUE" VALUE="Y"<%= checked %> <%= disabled %> onClick="setDisabled(this)">
									</TD>
								</TR>
<%
								checked="";
								disabled="";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									if (bean.getGenerateTokonReturnYN().equals("Y")) {
										checked	 = "CHECKED";
									}
									else {
										checked	 = "";
									}
								}
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									if (bean.getGenerateTokonReturnYN().equals("Y")) {
											checked	 = "CHECKED";
										}
									else {
											checked	 = "";
										}
									if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";						
								}
%>
								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></B></TD>
									<TD WIDTH="45%"  CLASS="label" colspan='2'><fmt:message key="ePH.GenerateTokonuponReturn.label" bundle="${ph_labels}"/>
									</TD>
									<TD WIDTH="30%" ALIGN="left" CLASS="label" colspan='4'>&nbsp;<INPUT TYPE="checkbox" name="GENERATE_TOKON_RETURN_MEDI" id="GENERATE_TOKON_RETURN_MEDI" VALUE="Y"<%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
								</TR>
<%
								checked="";
								disabled="";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									if (bean.getGenerateTokonDirectYN().equals("Y")) {
										checked	 = "CHECKED";
									}
									else {
										checked	 = "";
									}
								}
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									if (bean.getGenerateTokonDirectYN().equals("Y")) {
										checked	 = "CHECKED";
									}
									else {
										checked	 = "";
									}
									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";
								}
%>
								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></B></TD>
									<TD WIDTH="45%"  CLASS="label" colspan='2'><fmt:message key="ePH.GenerateTokonuponDirectDispensing.label" bundle="${ph_labels}"/>
									</TD>
									<TD WIDTH="30%" ALIGN="left" CLASS="label" colspan='4'>&nbsp;<INPUT TYPE="checkbox" name="GENERATE_TOKON_DIRECT_DISP" id="GENERATE_TOKON_DIRECT_DISP" VALUE="Y"<%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
								</TR>
<!-- billing interface is added here for OP for SRR20056-SCF-7639 ICN027720 -->
<%
								disable="";
								if(BLinstalled.equals("N"))
									disable="DISABLED";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									WithDelivery = "";
									Separate = "";
									notapplicable = "";
									UponAllocation = "";
									UponDelivery = "";
									disable="";
									billingStage = bean.getDispBillStageOP();
									dispCashCollStage = bean.getDispCashCollStageOP();
									if (billingStage.equals("X")) 
										notapplicable = "SELECTED";
									else if (billingStage.equals("A")) 
										UponAllocation = "SELECTED";
									else if (billingStage.equals("D"))
										UponDelivery = "SELECTED";

									if (dispCashCollStage.equals("X")) 
										notapplicable_receipt = "SELECTED";
									else if (dispCashCollStage.equals("D")) 
										WithDelivery = "SELECTED";
									else if (dispCashCollStage.equals("S"))
										Separate = "SELECTED";
								}
								if (bean.getEffStat().equals("D") ) {
									   disable="DISABLED";
								}

%>
								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.BillingInterfece.label" bundle="${ph_labels}"/></B></TD>
									<TD WIDTH="17%"  CLASS="label"><fmt:message key="ePH.BillStage.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="20%">&nbsp;
									<SELECT name="DISP_BILL_STAGE_OP" id="DISP_BILL_STAGE_OP" <%=disable%> onchange="CheckBillStage(this)">
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ){
%>
										<OPTION VALUE="X"  selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
<%
									}
									else{
%>
										<OPTION VALUE="X"  <%=notapplicable%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
<%
									}
%>
									<OPTION VALUE="A" <%=UponAllocation%>><fmt:message key="ePH.UponAllocation.label" bundle="${ph_labels}"/></OPTION>
									<OPTION VALUE="D" <%=UponDelivery%>><fmt:message key="ePH.UponDelivery.label" bundle="${ph_labels}"/></OPTION>
									 </SELECT>
									</TD>
<%
									if(notapplicable.equals("SELECTED"))
										disable="DISABLED";
%>
									<TD  WIDTH="20%" CLASS="label"><fmt:message key="ePH.ReceiptStage.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%">&nbsp;
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ){
%>
										<SELECT name="DISP_CASH_COLL_STAGE_OP" id="DISP_CASH_COLL_STAGE_OP" disabled >
<%
									}
									else{
%>
										<SELECT name="DISP_CASH_COLL_STAGE_OP" id="DISP_CASH_COLL_STAGE_OP" <%=disable%> >
<%
									}
%>
									<OPTION VALUE="X" <%=notapplicable_receipt%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="D"<%=WithDelivery%>><fmt:message key="ePH.WithDelivery.label" bundle="${ph_labels}"/></OPTION>
									<OPTION VALUE="S"<%=Separate%>><fmt:message key="Common.Separate.label" bundle="${common_labels}"/></OPTION>
									</SELECT>
									</TD>
								</TR>
<!-- billing interface is added here for OP for SRR20056-SCF-7639	ICN027720 END-->
								<TR>
									<TD WIDTH="25%" ALIGN="left" CLASS="label"><B><fmt:message key="ePH.PrinterLocation.label" bundle="${ph_labels}"/></B></TD>
<%
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									<TD WIDTH="17%"  CLASS="label"><fmt:message key="ePH.ForStatOrder.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%" ALIGN="left" >&nbsp;&nbsp;<INPUT TYPE="text" name="STAT_ORDER" id="STAT_ORDER" CLASS="NUMBER" VALUE="<%= bean.getStatOrder() %>" SIZE="3" MAXLENGTH="6" <%= disabled %> onKeyPress="return CheckForSpecChars( event )"></TD>
									<TD WIDTH="20%"  CLASS="label"><fmt:message key="ePH.ForRoutineOrder.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%" ALIGN="left" >&nbsp;&nbsp;<INPUT TYPE="text" name="ROUTINE_ORDER" id="ROUTINE_ORDER" CLASS="NUMBER" VALUE="<%= bean.getReturnOrder() %>" SIZE="3" MAXLENGTH="6" <%= disabled %> onKeyPress="return CheckForSpecChars( event )"></TD>
								</TR>
								<TR><!-- Added for HSA-CRF-0113 [IN:048166] Start -->
									<td class="label"><fmt:message key="ePH.DefaultNextBMSLocation.label" bundle="${ph_labels}"/> </td>
										<td class="label" style='<%=dispSameLoc%>;'><fmt:message key="ePH.SameLocation.label" bundle="${ph_labels}"/>
										<INPUT TYPE="checkbox" name="CURRENT_DISP_LOC" id="CURRENT_DISP_LOC" onClick="setDisabled(this)"></td>
										<td>
											<select name="defBMSDispLoc" id="defBMSDispLoc">
												<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
												for(int i=0; i<alDispLocations.size(); i+=2) {
													if( sDefBMSLocation.equals((String)alDispLocations.get(i))) {
%>
														<option value="<%=(String)alDispLocations.get(i)%>" selected><%=(String)alDispLocations.get(i+1)%></option>
<%	
													}
													else {	
%>
													<option value="<%=(String)alDispLocations.get(i)%>"><%=(String)alDispLocations.get(i+1)%></option>
<%	
													}	
												}	
%>
										</select>
									</td>
								</TR><!-- Added for HSA-CRF-0113 [IN:048166] End -->
								<!-- Billing Interface removed from here -->
								<TR><!-- added for Bru_HIMS-CRF-142(30195)  Start-->
									<TD colspan = '5'>
										<TABLE ID='PREPMEDICATION' CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" style='<%=prep_medication_visible%>'>
											<tr>
												<TD WIDTH="25%" ALIGN="left" CLASS="label" NOWRAP><B><fmt:message key="ePH.OtherDispensingRules.label" bundle="${ph_labels}"/></B></TD>&nbsp;
												<TD WIDTH="45%"  CLASS="label"  NOWRAP ID="REG_PAT_LB" style='<%=display_other_fields%>'><fmt:message key="ePH.RegisterBeforePatientArrival.label" bundle="${ph_labels}"/>&nbsp;</TD><!-- Added id and style for TH-KW-CRF-0020.9 -->
<%
												String chk="";
												String chktkn="";
												String chkprint="";
												String distkn="";
												String chkstrg="";
												
												if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
													if (bean.getEffStat().equals("D"))
														disabled = "DISABLED";
													if (bean.getPatArrival().equals("Y"))
														chk	 = "CHECKED";
													else 
														distkn ="DISABLED";
													if (bean.getActualToken().equals("Y"))
														chktkn	= "CHECKED";
													if (bean.getTokenNoLabel().equals("Y"))
														chkprint = "CHECKED";
													if (bean.getStorageLoc().equals("Y"))
														chkstrg = "CHECKED";
												}
%>
												<TD WIDTH="35%" ALIGN="left"  ID="REG_PAT_TX"  style='<%=display_other_fields%>'>&nbsp;<INPUT TYPE="checkbox" name="PAT_ARRIVAL" id="PAT_ARRIVAL" VALUE="<%=bean.getPatArrival()%>" <%= chk %> <%= disabled %> onClick="validatePat()"></TD><!-- Added id and style for TH-KW-CRF-0020.9 -->
											</TR>
										  
											<TR>
												<TD WIDTH="15%" ALIGN="left" CLASS="label">
												<TD WIDTH="40%"  CLASS="label" NOWRAP ID ="PAT_ARRIVAL_LB"  style='<%=display_other_fields%>'><fmt:message key="ePH.GenerateTokenNumberBeforePatientArrival.label" bundle="${ph_labels}"/>&nbsp;</TD><!-- Added id and style for TH-KW-CRF-0020.9 -->
												<TD WIDTH="35%" ALIGN="left" ID ="PAT_ARRIVAL_TX" style='<%=display_other_fields%>'>&nbsp;<INPUT TYPE="checkbox" name="ACTUAL_TOKEN" id="ACTUAL_TOKEN"  VALUE="<%=bean.getActualToken()%>" <%= chktkn%> <%=distkn%>  onClick="ValidateGenTkn(this)"> </TD><!-- Added id and style for TH-KW-CRF-0020.9 -->
											</TR>
												<TD WIDTH="25%" ALIGN="left" CLASS="label" ></TD>
												<TD WIDTH="45%"  CLASS="label"  NOWRAP><fmt:message key="ePH.DeliveryBinApplicable.label" bundle="${ph_labels}"/>&nbsp;</TD>
												<TD WIDTH="35%" ALIGN="left">&nbsp;<INPUT TYPE="checkbox" name="STORAGE_LOCN" id="STORAGE_LOCN" VALUE="<%= bean.getStorageLoc() %>" <%= chkstrg %> <%=disabled%>   onClick="ValidateStgLoc(this)"> </TD>
											</TR>
										</TABLE>
									</TD>
								<!--  added for Bru_HIMS-CRF-142(30195) End -->	
								</TR>
							</TABLE> <!--end of outpatient table -->
<%
						}
						if ( (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && IPinstalled.equalsIgnoreCase("Y")) || (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && bean.getDispLocnType().equals("P") && (bean.getDispLocnCategory().equals("I") || bean.getDispLocnCategory().equals("B"))) ) {
							
							String style_IP_table = "display:none";
							if (bean.getDispLocnCategory().equals("I"))
								style_IP_table = "display";
%>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="inpatientTable" STYLE="<%= style_IP_table %>">
								<TR>
									<TD CLASS="label" width='27%'><B><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></B>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getIPVerify().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("IP_VERF_YN").toString().equals("Y")) {
											if (bean.getIPVerify().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
											}
											else {
												checked	 = "";
												disabled = "";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";				
									}
%>
						
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= param_legends.get("V")%></td>
									<td class="label" width='3%'><INPUT TYPE="checkbox" name="VERIFY" id="VERIFY" VALUE="<%= bean.getIPVerify() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) 
										new_pres_checked=(bean.getNewPrescriptionsOnlyYN().equals("Y"))?"checked":"";
									else if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
										new_pres_checked=(bean.getNewPrescriptionsOnlyYN().equals("Y"))?"checked":"";
%>
									<td class="label" colspan='2' WIDTH="35%"> <fmt:message key="ePH.NewPrescriptionsOnly.label" bundle="${ph_labels}"/></td>
									<td class="label" colspan='2' WIDTH="35%"><input type="checkbox" name="VERIFY_REGULAR_IP_RX_YN" id="VERIFY_REGULAR_IP_RX_YN" value="Y" <%=new_pres_checked%> <%=disabled%>></td>
								</tr>
								<tr>
<%
									String strIPAllocYNChecked = "";;
									if(bean.getIPAllocYN().equals("Y"))
										strIPAllocYNChecked = "checked";
									else
										strIPAllocYNChecked ="";
%>
									<TD CLASS="label" ><%= param_legends.get("F")%></td>
									<td class="label"><INPUT TYPE="CHECKBOX" name="IP_ALLOC_YN" id="IP_ALLOC_YN" VALUE="Y" <%= strIPAllocYNChecked %> <%= disabled %>></TD>
									<TD WIDTH="35%"  CLASS="label" colspan='2'><%= param_legends.get("F")%> <fmt:message key="Common.Process.label" bundle="${common_labels}"/>: <%=param_legends.get("F") %> <fmt:message key="Common.Period.label" bundle="${common_labels}"/></TD>
<%
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getIPFillPeriod().equals(""))
											disabled = "DISABLED";
										else
											disabled = "";
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("IP_FILL_PRD_AHEAD").toString().equals(""))
											disabled = "DISABLED";
										else if (bean.getIPFillPeriodUnit().equals("P"))
											disabled = "DISABLED";
										else if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";
										else
											disabled="";
									}			

									String ip_fill_prd = "";
									if (bean.getIPFillPeriodUnitForCheck().equals("H"))
										ip_fill_prd = bean.getIPFillPeriodForCheck();
									else if (!(bean.getIPFillPeriodForCheck().equals("")) && bean.getIPFillPeriodUnitForCheck().equals("D"))
										ip_fill_prd = 24*(Integer.parseInt(bean.getIPFillPeriodForCheck()))+"";
%>
									<TD WIDTH="35%" ALIGN="left" CLASS="label" colspan='2'>&nbsp;
									<INPUT TYPE="text" name="FILL_PROCESS" id="FILL_PROCESS" CLASS="NUMBER" VALUE="<%= bean.getIPFillPeriod() %>" SIZE="2" MAXLENGTH="2" <%= disabled %> onKeyPress="return allowValidNumber(this,event);" onBlur="validNumber(this);validateForGreaterValue('<%= ip_fill_prd %>', this, 1)">&nbsp;&nbsp;
<%
									String selectHours = "";
									String selectDay = "";
									String selectPrescPrd = "";
									if (bean.getIPFillPeriodUnit().equals("H")) 
										selectHours = "SELECTED";
									else if (bean.getIPFillPeriodUnit().equals("D")) 
										selectDay = "SELECTED";
									else if (bean.getIPFillPeriodUnit().equals("P")) 
										selectPrescPrd = "SELECTED";

									String ip_fill_mand = "";

									if (bean.getIPFillPeriodUnit().equals("H") || bean.getIPFillPeriodUnit().equals("D"))
										ip_fill_mand = "visibility:visible";
									else
										ip_fill_mand = "visibility:hidden";			
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";
									}
%>
									&nbsp;<SELECT name="FILL_PROCESS_UNIT" id="FILL_PROCESS_UNIT" <%= disabled %> onChange="toggleEditingFill(this.value)">
									<OPTION VALUE="H" <%= selectHours %>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="D" <%= selectDay %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="P" <%= selectPrescPrd %>><fmt:message key="ePH.PrescribedPeriod.label" bundle="${ph_labels}"/></OPTION>
									</SELECT>
									&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="<%= ip_fill_mand %>" ID="ip_fill_mandate"></IMG>
									</TD>
								</TR>
								<TR>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getIPDelivery().equals("Y")) {
											checked	 = "CHECKED";
											disabled = "";
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("IP_DELV_REQD_YN").toString().equals("Y")) {
											if (bean.getIPDelivery().equals("Y")) {
												checked	 = "CHECKED";
												disabled = "";
											}
											else {
												checked	 = "";
												disabled = "";
											}
										}
										else {
											checked	 = "";
											disabled = "DISABLED";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";			
									}
%>
									<TD  CLASS="label"><%= param_legends.get("D") %></td>
									<td CLASS="label"><INPUT TYPE="checkbox" name="DELIVERY" id="DELIVERY" VALUE="<%= bean.getIPDelivery() %>" <%= checked %> <%= disabled %> onClick="setDisabled(this)"></TD>
									<TD WIDTH="35%"  CLASS="label" colspan='2'><fmt:message key="ePH.ExcludeNewOrdersPlacedWithin.label" bundle="${ph_labels}"/></TD>
<%
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getExcludeOrders().equals("")) {
											disabled = "DISABLED";
										}
										else {
											disabled = "";
										}
									}

									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (paramVals.get("IP_FILL_EXCL_PRD_BEHIND").toString().equals("")) {
											disabled = "DISABLED";
										}
										else {
											disabled = "";
										}

										if (bean.getEffStat().equals("D"))
											disabled = "DISABLED";				
									}
%>

									<TD COLSPAN="2" ALIGN="left" CLASS="label" colspan='2'>&nbsp;<INPUT TYPE="text" name="EXCLUDE_ORDERS" id="EXCLUDE_ORDERS" CLASS="NUMBER" VALUE="<%= bean.getExcludeOrders() %>" SIZE="2" MAXLENGTH="6" <%= disabled %> onKeyPress="return CheckForSpecChars( event )" onBlur="validNumber(this);validateForGreaterValue('<%= bean.getExcludeOrdersForCheck() %>', this, '0')"> <fmt:message key="ePH.HoursofScheduledStart.label" bundle="${ph_labels}"/></TD>
								</TR>
								<tr>
<%
								String strAUTODISPATADMINYNChecked = "";;
								disabled = ""; //Added for ML-BRU-SCF-0846 [IN:040059]
								if (bean.getEffStat().equals("D")) //Added for ML-BRU-SCF-0846 [IN:040059]
									disabled = "DISABLED";				
								if(bean.getAUTODISPATADMINYN().equals("Y"))
									strAUTODISPATADMINYNChecked = "checked";
								else
									strAUTODISPATADMINYNChecked ="";
%>
								<td colspan='2'>&nbsp;</td>
								<TD CLASS="label"   colspan='2'><fmt:message key="ePH.AutoDispenseAtAdministration.label" bundle="${ph_labels}"/></TD>
								<TD ALIGN="LEFT" colspan='2'>&nbsp;<INPUT TYPE="CHECKBOX" name="AUTO_DISP_AT_ADMIN_YN" id="AUTO_DISP_AT_ADMIN_YN" VALUE="Y" <%= strAUTODISPATADMINYNChecked %> <%= disabled %>></TD>
								
							</TR>
							<TR>
								<td colspan='2'>&nbsp;</td>
								<TD  CLASS="label" colspan='2'><fmt:message key="ePH.ContinuousIntermittentOrdersScheduleStart.label" bundle="${ph_labels}"/> </TD>
<%
								disabled="";
								String cont_int_orders = bean.getContIntermittent();
								if (cont_int_orders.equals("00:00")) cont_int_orders = "";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
									if (cont_int_orders.equals("")) {
										disabled = "DISABLED";
									}
									else {
										disabled = "";
									}
								}

								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									if (paramVals.get("IP_FILL_DFLT_START_TIME").toString().equals("00:00")) {
										disabled = "DISABLED";
									}
									else {
										disabled = "";
									}

									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";				
								}
%>
								<TD COLSPAN="2" ALIGN="left" CLASS="label" colspan='2'>&nbsp;<INPUT TYPE="text" name="CONT_INT_ORDERS" id="CONT_INT_ORDERS" CLASS="NUMBER" VALUE="<%= cont_int_orders %>" SIZE="2" MAXLENGTH="5" <%= disabled %> onBlur="appendzero(this);CheckTime(this)"></TD>
							</TR>
<%
							disabled="";
							String ip_allow_drug_return_yn = bean.getIPAllowDrugReturnYN();
							String ip_fill_allocate_bathces_yn  = bean.getIPFillBatchesYN();

							if(ip_allow_drug_return_yn.equals("Y"))
								ip_allow_drug_return_yn = "checked";
							else
								ip_allow_drug_return_yn = "";

							if(ip_fill_allocate_bathces_yn.equals("Y"))
								ip_fill_allocate_bathces_yn = "checked";
							else
								ip_fill_allocate_bathces_yn = "";

							if(bean.getEffStat().equals("D"))
								disabled = "DISABLED";
%>
							<TR>
								<td colspan=2>&nbsp;</td>
								<TD  CLASS="label" colspan='2'><fmt:message key="ePH.AllowMedicationReturn.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan='2'><INPUT TYPE="CHECKBOX" name="IP_ALLOW_DRUG_RETURN_YN" id="IP_ALLOW_DRUG_RETURN_YN" VALUE="Y" <%= ip_allow_drug_return_yn %> <%= disabled %>></TD>
							</tr>
								<!--Columns hidden for IN14118 --28/04/2010-- priya -->
							<tr style='display:none'>
								<td colspan=2>&nbsp;</td>
								<TD  CLASS="label" style='visibility:hidden' colspan='2'><fmt:message key="ePH.AllocateBatchesDuringFillProcess.label" bundle="${ph_labels}"/></TD>
								<TD COLSPAN="2" ALIGN="LEFT" style='visibility:hidden' colspan='2'>&nbsp;<INPUT TYPE="CHECKBOX" name="IP_FILL_ALLOCATE_BATHCES_YN" id="IP_FILL_ALLOCATE_BATHCES_YN" VALUE="Y" <%= ip_fill_allocate_bathces_yn %> <%= disabled %>></TD>
							</TR>
<%
							if (Daily_Specific_rangeYN.equals("Y")){
								String ip_dsn_from = bean.getIP_SQENCE_NO_FROM();
								String ip_dsn_to = bean.getIP_SQENCE_NO_TO();
%>
								<tr>
									<td colspan=2>&nbsp;</td>
									<td  CLASS="label" colspan='2'><fmt:message key="ePH.ENABLEDAILYSEQUENCENUMBERRANGE" bundle="${ph_labels}"/></TD>
									<td width='17%' ALIGN="LEFT" CLASS='label' >&nbsp;<INPUT TYPE="text" name="IP_SQENCE_NO_FROM" id="IP_SQENCE_NO_FROM" VALUE="<%=ip_dsn_from%>"  SIZE="3" CLASS="NUMBER" MAXLENGTH="5" onKeyPress="return allowValidNumber(this,event);" onBlur="validNumber(this);">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<INPUT TYPE="text" name="IP_SQENCE_NO_TO" id="IP_SQENCE_NO_TO" VALUE="<%=ip_dsn_to %>" SIZE="3" CLASS="NUMBER" MAXLENGTH="5" onKeyPress="return allowValidNumber(this,event)" onBlur="validNumber(this);" ></td>
									<td width='13%'><a href="javascript:callViewRanges()" title='<fmt:message key="ePH.VIEWRANGES.label" bundle="${ph_labels}"/>' name="ViewRanges"><fmt:message key="ePH.VIEWRANGES.label" bundle="${ph_labels}"/></a><input type='hidden' name='hidden_ViewRanges' id='hidden_ViewRanges' value=""></td>
								</tr>
<%
							}
%>
<!-- ================================================================================================== -->
<!-- Removed Spill quantity details from here -->

<!-- ================================================================================================== -->
<% 				/* added for SRR20056-CRF-0663 ----------------START*/

							String ip_fill_disp_prd = bean.getIPFillDispPrd();
							String ip_fill_disp_prd_unit = bean.getIPFillDispPrdUnit();
							String ip_dflt_prty_disp = bean.getIPDfltPrtyDisp();
							if(ip_fill_disp_prd == null || ip_fill_disp_prd.equals(""))
								ip_fill_disp_prd=bean.getIPFillPeriod();  // FD: same as that of field ?Fill Process: Fill Period?
							if(ip_fill_disp_prd_unit== null || ip_fill_disp_prd_unit.equals(""))
								ip_fill_disp_prd_unit = bean.getIPFillPeriodUnit();
							if(ip_dflt_prty_disp== null)
								ip_dflt_prty_disp = "";
							if(ip_fill_disp_prd_unit.equals("P")){
								ip_fill_disp_prd = "";
								disabled = "disabled";
							}
%>
							<TR>
								<td colspan=2>&nbsp;</td>
								<TD  ALIGN="left" CLASS="label" colspan='2'><fmt:message key="ePH.FillPeriod.label" bundle="${ph_labels}"/>:&nbsp;<fmt:message key="ePH.FillWithoutFillList.label" bundle="${ph_labels}"/></TD>
								<TD  ALIGN="left" CLASS="label" colspan='2'>&nbsp;<INPUT TYPE="text" name="IP_FILL_DISP_PRD" id="IP_FILL_DISP_PRD" CLASS="NUMBER" VALUE="<%=ip_fill_disp_prd%>" SIZE="2" MAXLENGTH="2" onKeyPress="return allowValidNumber(this,event);" onBlur="validNumber(this);validateForGreaterValue('<%= ip_fill_prd %>', this, 1);" <%= disabled %>>&nbsp;&nbsp;
								&nbsp;<SELECT name="IP_FILL_DISP_PRD_UNIT" id="IP_FILL_DISP_PRD_UNIT" onChange="toggleEditingFillDISP_PRD(this.value);">
<%
								if (ip_fill_disp_prd_unit.equals("H")){
%>
									<OPTION VALUE="H" selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
<%
								}
								else {
%>
									<OPTION VALUE="H" ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
<%
								}
								if (ip_fill_disp_prd_unit.equals("D")){
%>
										<OPTION VALUE="D" selected><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
<%
								}
								else {
%>
									<OPTION VALUE="D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
<%
								}
								if (ip_fill_disp_prd_unit.equals("P")){
%>
									<OPTION VALUE="P" selected><fmt:message key="ePH.PrescribedPeriod.label" bundle="${ph_labels}"/></OPTION>
<%
								}
								else{
%>
									<OPTION VALUE="P"><fmt:message key="ePH.PrescribedPeriod.label" bundle="${ph_labels}"/></OPTION>
<%
								}
%>
								</SELECT>
								</TD>
							</TR>
							<TR>
								<td colspan=2>&nbsp;</td>
								<TD colspan='2' ALIGN="left" CLASS="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/>:&nbsp;<fmt:message key="ePH.FillWithoutFillList.label" bundle="${common_labels}"/></TD>
								<TD colspan='2' ALIGN="left" CLASS="label">&nbsp;<SELECT name="IP_DFLT_PRTY_DISP" id="IP_DFLT_PRTY_DISP" >
<%
								if (ip_dflt_prty_disp.equals("")){
%>
									<option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
								}
								else {
%>
									<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
								}
								if (ip_dflt_prty_disp.equals("U")){
%>
									<option value="U" selected><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
<%
								}
								else {
%>
									<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
<%
								}
								if (ip_dflt_prty_disp.equals("R")){
%>
									<option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
<%
								}
								else{
%>
									<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
<%
								}
%>					
								</TD>
							</TR>
						<!------------ added for SRR20056-CRF-0663 ---END -->
						<!-- billing interface details added here for ip SRR20056-SCF-7639	ICN027720 -->
<%							
								disable="";
								//billingStage = "X"; 
								dispCashCollStage = "X"; //For IP cash collstage not applicable
								if(BLinstalled.equals("N") || billingStage.equals("X"))
									disable="DISABLED";
								if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
									WithDelivery = "";
									Separate = "";
									notapplicable = "";
									UponAllocation = "";
									UponDelivery = "";
									disable = "";
									billingStage = bean.getDispBillStage(); 
									/*dispCashCollStage = bean.getDispCashCollStage();*///For IP cash collstage not applicable
									if (billingStage.equals("X")) 
										notapplicable = "SELECTED";
									else if (billingStage.equals("A")) 
										UponAllocation = "SELECTED";
									else if (billingStage.equals("D"))
										UponDelivery = "SELECTED";

									if (dispCashCollStage.equals("X")) 
										notapplicable_receipt = "SELECTED";
									else if (dispCashCollStage.equals("D")) 
										WithDelivery = "SELECTED";
									else if (dispCashCollStage.equals("S"))
										Separate = "SELECTED";
								}
%>
								<TR>
									<TD colspan='2' ALIGN="left" CLASS="label"><B><fmt:message key="ePH.BillingInterfece.label" bundle="${ph_labels}"/></B></TD>

									<TD WIDTH="17%" CLASS="label"><fmt:message key="ePH.BillStage.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%">&nbsp;
									<SELECT name="DISP_BILL_STAGE" id="DISP_BILL_STAGE" <%=disable%> onchange="">
<%
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) 
									{
%>
										<OPTION VALUE="X"  selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
<%
									}
									else
									{
%>
										<OPTION VALUE="X"  <%=notapplicable%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
<%
									}
%>
									<OPTION VALUE="A" <%=UponAllocation%>><fmt:message key="ePH.UponAllocation.label" bundle="${ph_labels}"/></OPTION>
									<OPTION VALUE="D" <%=UponDelivery%>><fmt:message key="ePH.UponDelivery.label" bundle="${ph_labels}"/></OPTION>
									 </SELECT>
									</TD>
									<TD  WIDTH="20%" CLASS="label"><fmt:message key="ePH.ReceiptStage.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%">&nbsp;
									<SELECT name="DISP_CASH_COLL_STAGE" id="DISP_CASH_COLL_STAGE" disabled >
									<OPTION VALUE="X" <%=notapplicable_receipt%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="D"<%=WithDelivery%>><fmt:message key="ePH.WithDelivery.label" bundle="${ph_labels}"/></OPTION>
									<OPTION VALUE="S"<%=Separate%>><fmt:message key="Common.Separate.label" bundle="${common_labels}"/></OPTION>
									</SELECT>
									</TD>
								</TR>
								<!--- Billing interface detail for IP SRR20056-SCF-7639	ICN027720 - END -->
								<TR>
									<TD colspan='2' ALIGN="left" CLASS="label"><B><fmt:message key="ePH.PrinterLocation.label" bundle="${ph_labels}"/></B></TD>
<%
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>
									<TD WIDTH="17%"  CLASS="label"><fmt:message key="ePH.ForStatOrder.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%" ALIGN="left" CLASS="label">&nbsp;<INPUT TYPE="text" name="IP_STAT_ORDER" id="IP_STAT_ORDER" CLASS="NUMBER" VALUE="<%= bean.getIPStatOrder() %>" SIZE="3" MAXLENGTH="6" <%= disabled %> onKeyPress="return CheckForSpecChars( event )"></TD>
									<TD WIDTH="20%"  CLASS="label"><fmt:message key="ePH.ForRoutineOrder.label" bundle="${ph_labels}"/></TD>
									<TD WIDTH="19%" ALIGN="left" CLASS="label">&nbsp;<INPUT TYPE="text" name="IP_ROUTINE_ORDER" id="IP_ROUTINE_ORDER" CLASS="NUMBER" VALUE="<%= bean.getIPReturnOrder() %>" SIZE="3" MAXLENGTH="6" <%= disabled %> onKeyPress="return CheckForSpecChars( event )"></TD>
								</TR>
							</TABLE> <!--end of inpatientTable-->
<%
						}
 //Added on 07/01/2009 for Other Details tab 
						//if ( (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) && bean.getDispLocnType().equals("P") ) ){
							String style_OD_table = "display:none";			
%> 		
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0" ID="otherdetailsTable" STYLE="<%= style_OD_table %>">
		<!-- Code added for the CRF 293.1 -- Added new Hyperlink for online print setup -->
<%	
								bean.setOnlinePrintDetails(bean.getLoggedInFacility(),dispLocnCode);	
%>		     
								 <tr>
									<td class="label"><a href="javascript:callonlineSetup()" title='<fmt:message key="ePH.OnlinePrintSetup.label" bundle="${ph_labels}"/>' name="onlineprintsetup"><fmt:message key="ePH.OnlinePrintSetup.label" bundle="${ph_labels}"/></a><input type='hidden' name='hidden_onlineprintsetup' id='hidden_onlineprintsetup' value=""></td>
								</TR>
<!-- Code end for the CRF 293.1 -- Added new Hyperlink for online print setup -->
		
								<TR>
									<TD>&nbsp;</TD>
								</TR>
<!-- code added for dispense sheet for direct dipensing and dispense label for direct dispensing -->
								<TR>
									<TD  WIDTH="32%" ALIGN="left" CLASS="label"><fmt:message key="ePH.DispenseSheetinDirectDispensing.label" bundle="${ph_labels}"/> </td>
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getPrintDispSheet().toString().equals("Y") && bean.getDirdispYN().equals("Y")){
											checked	 = "CHECKED";						
										}else{
											checked	 = "";
											disabled = "DISABLED";
										}
									}
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
										if (paramVals.get("PRINT_DISP_SHEET_OP_YN").toString().equals("Y")){
											if (bean.getPrintDispSheet().toString().equals("Y") && bean.getDirdispAllowe().equals("Y")&&bean.getPrintDispSheet_phparam().equals("Y") ) {
												disabled = "";
												//checked	 = "CHECKED";
											
												if (bean.getDelDispSheetDefaultYN().equals("Y")){
													checked	 = "CHECKED";
												}
												else{
													checked	 = "";
													
												}
											}
											else{
												checked	 = "";
												disabled = "DISABLED";
											}	 
										}
										else{
											checked	 = "";
											disabled = "DISABLED";
										}
%>
										<input type ='hidden' name ='H_DELI_DISP_SHEET_VAL' value ="<%=bean.getDelDispSheetDefaultYN()%>" />
<%
									}
									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";
%>							
									<td  WIDTH="15%" ALIGN="LEFT" >
										<INPUT TYPE="checkbox" name="DELI_DISP_SHEET" id="DELI_DISP_SHEET" <%= checked %> <%= disabled %> onClick="setDisabled(this)" VALUE="Y">
									</TD>						
<%
									checked="";
									disabled="";
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
										if (bean.getDirdispYN().equals("Y"))
											checked	 = "CHECKED";
										else{
											checked ="";
											disabled = "DISABLED";
										}
									}
									if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
										if (bean.getDelDispLabelDefaultYN().equals("Y")){
											if (bean.getDirdispAllowe().equals("Y") )
												checked	 = "CHECKED";
											else {
												checked	 = "";
												disabled = "DISABLED";
											}
													
										}
										else{
											checked	 = "";
											 if (bean.getDirdispAllowe().equals("N") ){
											 disabled = "DISABLED";
											}
										}
%>
										<input type ='hidden' name ="H_DELI_DISP_LABEL_VAL" value ="<%=bean.getDelDispLabelDefaultYN()%>" />
<%										}
									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";								
%>
									<TD WIDTH="28%" ALIGN="left" CLASS="label"><fmt:message key="ePH.DispenseLabelinDirectDispensing.label" bundle="${ph_labels}"/>  </TD>
									<TD  >&nbsp;&nbsp;<INPUT TYPE="checkbox" name="DELI_DISP_LABEL" id="DELI_DISP_LABEL" <%= checked %> <%= disabled %> onClick="setDisabled(this)" VALUE="Y"></TD>
										
								</tr>
			
<!-- code end for dispense sheet for direct dipensing and dispense label for direct dispensing  -->
								<TR>
									<TH ALIGN="left" COLSPAN="10"><fmt:message key="ePH.SpillQuantityDetails.label" bundle="${ph_labels}"/></TH>
								</TR>
<%
								String allow_usage_of_spil_qty_yn  = bean.getIPAllowSpillUsageYN();
								if(allow_usage_of_spil_qty_yn.equals("Y"))
									allow_usage_of_spil_qty_yn = "checked";
								else
									allow_usage_of_spil_qty_yn = "";
%>
								<TR>
									<TD  WIDTH="32%" ALIGN="left" CLASS="label"><fmt:message key="ePH.UsageofSpillQuantityDuringAdmixture.label" bundle="${ph_labels}"/></TD>
									<TD   WIDTH="15%" ALIGN="LEFT"><INPUT TYPE="CHECKBOX" name="ALLOW_USAGE_OF_SPIL_QTY_YN" id="ALLOW_USAGE_OF_SPIL_QTY_YN" VALUE="Y" <%= allow_usage_of_spil_qty_yn %> <%= disabled %>></TD>
				
<%
									disabled="";
									String charge_pat_for_spill_qty_yn  = bean.getChargePatForSpillQtyYN();
									if(BLinstalled.equals("Y")){
										disabled="";
										if(charge_pat_for_spill_qty_yn.equals("Y"))
											charge_pat_for_spill_qty_yn = "checked";
										else
										   charge_pat_for_spill_qty_yn = "";
									}
									else{
										 charge_pat_for_spill_qty_yn = "";
										 disabled = "DISABLED";
									}
									if (bean.getEffStat().equals("D"))
										disabled = "DISABLED";				
				
%>			
									<TD   WIDTH="28%" ALIGN="left" CLASS="label"><fmt:message key="ePH.ChargePatientforSpillQuantity.label" bundle="${ph_labels}"/></TD>
									<TD ALIGN="LEFT">&nbsp;&nbsp;<INPUT TYPE="CHECKBOX" name="CHARGE_PAT_FOR_SPILL_QTY_YN" id="CHARGE_PAT_FOR_SPILL_QTY_YN" VALUE="Y"  <%= charge_pat_for_spill_qty_yn %> <%= disabled %>></TD>
								</TR>
								<TR> 
									<TD> &nbsp; </TD>
								</TR><!--- Billing interface details removed from here and separeted for IP and OP for SCF -->
							</TABLE> <!--end of otherdetails table-->
<%
						//}
%>
					</TD>
				</TR>
			</TABLE>	<!--end of maintable-->
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="disp_locn_code" id="disp_locn_code" VALUE="<%= dispLocnCode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
			<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= bean.getLoggedInFacility() %>">
			<INPUT TYPE="hidden" name="select_store_code_sql" id="select_store_code_sql" VALUE="<%= select_store_code_sql %>">
			<INPUT TYPE="hidden" name="display_delivery_bin" id="display_delivery_bin" VALUE="<%= display_delivery_bin %>"><!-- Added for TH-KW-CRF-0020.9 -->
<%
		}
		else {
%>
			<SCRIPT>
				alert("PH Facility param not set");
				history.go(-1);
			</SCRIPT>
<%//Added for NMC-JD-CRF-0008 start
		}
			if(ext_disp_appl){%>
<script>
			onLoadValidation();
</SCRIPT>
<%			}
			//Added for NMC-JD-CRF-0008 end 
			%>

		</FORM>
	</BODY>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(log_bean_id,log_bean,request);
//Added for NMC-JD-CRF-0008 start	
}
catch(Exception e){
	e.printStackTrace();
}finally{ 
    	if(con != null)
      		ConnectionManager.returnConnection(con,request);	
}
//Added for NMC-JD-CRF-0008 end
%>

