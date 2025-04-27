<!DOCTYPE html>
 <%
/*
-------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------
14/12/2020   IN8219         Prabha	 	   15/12/2020	Manickavasagam J   MMS-DM-CRF-0177
22/12/2021	TFS-25851       Prabha										   SKR-SCF-1641
-------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
 <%!  public String getCheckStatus(String value)	{
		 if(value.equals("Y"))
			 return "checked";
		 else
			 return "";
	 }
	 public String getCheckValue(String value)	{
		 if(value.equals(""))
			 return "N";
		 else
			 return value;
	 }
	 public String getValue(String value)	{
		 if(value==null || value.equals(""))
			return "";
		 else
			return value;
	 }
 %>

	<body  onKeyDown="lockKey()" topmargin="0" onMouseDown = 'CodeArrest()' >

<%
		/* Mandatory checks start */
		String mode				= request.getParameter( "mode" ) ;
		String drug_code		= request.getParameter( "drug_code" );
		String req_str			= request.getQueryString();
		if(drug_code==null)	drug_code	=	"";
		//out.println(drug_code);
		String bean_id = "DrugMasterBean" ;
		String bean_name = "ePH.DrugMasterBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_DRUG";
		String pkey_value		="";
		String promptAlertDrug = "N";
		String alert_for_preferred_drug_status = "";

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		/* Mandatory checks end */

		/* Initialize Function specific start */
		DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		/* Initialize Function specific end */

		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
        log_bean.setLanguageId(locale);
		/* Variable Declarations start */
		HashMap	initialValues						=	null;
		ArrayList	formCode						=	null;
		ArrayList	formDesc						=	null;
		ArrayList	drugMasterMain					=	null;
		ArrayList	prescribing_det					=	null;
		ArrayList	dispensing_det					=	null;

		ArrayList tmpl_values_1 = new ArrayList();
		tmpl_values_1=	 (ArrayList) bean.getSlidingScaleChkdTmpls(drug_code);
		bean.setSlidingScaleChkdValues(tmpl_values_1);

		String		drug_desc						=	"";
		String		in_formulary_status				=	"";
		String		in_formulary					=	"";
		String		link_to_existing_item_status	=	"";
		String		link_to_existing_item			=	"";
		String		item_code						=	"";
		//String		item_desc						=	"";
		String		generic_id						=	"";
		String		generic_name					=	"";
		String		compound_status					=	"";
		String		compound						=	"";
		String		form_code						=	"";
		String		bean_form_code					=	"";
		//String		bean_form_desc					=	"";
		String		form_desc						=	"";
		String		route_code						=	"";
		//String		route_desc						=	"";
		String		drug_code_rule					=	"";
		String		drug_code_and_item				=	"";
		String		drug_item_code_link				=	"";
		String		drug_to_item_mapping			=   "";
		String		drug_code_status				=	"";
		String		drug_desc_status				=	"";
		String		stock_yn						=	"";
		String		ip_yn							=	"";
		String		or_yn							=	"";
		String		base_unit_ref					=	"";
		String		stock_uom_ref					=	"";
		String		pres_base_uom_desc_ref			=	"";
		String		pres_cat_code					=	"";
		String		refill_yn						=	"";
		String strength_value	="";
		String strength_uom		="";
		String item_image_path		="";
		String route_color="";	// added for CRF RUT-CRF-0034.1[IN:037389]-start
		String fntColor="";
		String backgrndColor="";	// added for CRF RUT-CRF-0034.1[IN:037389]-end
		boolean		or_status						=   false;
		String      default_route_yn                =	"Y";// Code Added For CRF 0034
		String      default_route_yn_chk            =   "Checked";
		String mm_short_desc = "";//added for for SKR-SCF-1312
		String mm_long_desc	= "";//added for SKR-SCF-1312
				
		//Added for MMS-DM-CRF-0177
		
		boolean drug_search = false;
	    drug_search = bean.isSite(request,"PH","PRE_ALLOC_APPL"); 
		String drug_search_by = "G";
		String drug_search_generic = "";
		String drug_search_trade = "";
		String pre_alloc_appl_yn="N";
				if(drug_search)
				{
					pre_alloc_appl_yn="Y";
				}
		//Added for MMS-DM-CRF-0177
				
		String sql_ph_drug_select14			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
		String sql_ph_drug_select25			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT25");
		String sql_ph_drug_search_select21	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT21");
		String sql_ph_drug_search_select22	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT22");
		String sql_ph_drug_search_select23	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT23");
		String sql_ph_drug_search_select24	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT24");
		String sql_ph_drug_search_select25	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT25");
		String sql_ph_drug_search_select26	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT26");
		String sql_or_ph_select1			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT1");
		String sql_or_ph_select2			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT2");
		String sql_or_ph_select3			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT3");

		//Check the version
		String licenceRights = PhLicenceRights.getKey();
		bean.setVersion(licenceRights);
		

		initialValues					=	bean.loadIntialValues();
		item_image_path = (String)initialValues.get("item_image_path")==null?"":(String)initialValues.get("item_image_path");

		/* Variable Declartions end*/
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
			formCode						=	(ArrayList)initialValues.get("formCode");
			formDesc						=	(ArrayList)initialValues.get("formDesc");
			in_formulary_status				=	getCheckStatus("Y");
			in_formulary					=	getCheckValue("Y");
			link_to_existing_item_status	=	getCheckStatus("Y");
			link_to_existing_item			=	getCheckValue("Y");
			default_route_yn_chk			=	getCheckStatus("Y");
			refill_yn						=	bean.getRefillYN();
			drug_search_by                  =   getValue("G"); //Added for MMS-DM-CRF-0177
			
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{

			formCode				=	(ArrayList)initialValues.get("formCode");
			formDesc				=	(ArrayList)initialValues.get("formDesc");

			
			if( bean.loadDrugMasterValues(drug_code) )	{
				drugMasterMain					=	bean.getDrugmastermain();
				drug_code						=	getValue((String) drugMasterMain.get(0));
				or_status						=	bean.getDrugStatusInOR(drug_code);
				drug_desc						=	getValue((String) drugMasterMain.get(1));
				in_formulary_status				=	getCheckStatus((String)drugMasterMain.get(2));
				in_formulary					=	getCheckValue((String)drugMasterMain.get(2));
				link_to_existing_item_status	=	getCheckStatus((String)drugMasterMain.get(3));
				link_to_existing_item			=	getCheckValue((String)drugMasterMain.get(3));
				item_code						=	getValue((String) drugMasterMain.get(4));
				//item_desc						=	getValue((String) drugMasterMain.get(5));
				generic_id						=	getValue((String) drugMasterMain.get(6));
				generic_name					=	getValue((String) drugMasterMain.get(7));
				compound_status					=	getCheckStatus((String)drugMasterMain.get(9));

				compound						=	getCheckValue((String)drugMasterMain.get(9));
				bean_form_code					=	getValue((String) drugMasterMain.get(10));
				//bean_form_desc					=	getValue((String) drugMasterMain.get(11));
				route_code						=	getValue((String) drugMasterMain.get(12));
				route_color						=	getValue((String) drugMasterMain.get(16));	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}
				else{
		           	fntColor= "";
					backgrndColor= "";
				}	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				//route_desc						=	getValue((String) drugMasterMain.get(13));
				promptAlertDrug					=	getValue((String) drugMasterMain.get(14));
				alert_for_preferred_drug_status	=	getCheckStatus((String) drugMasterMain.get(14));
				default_route_yn                =   getValue((String) drugMasterMain.get(15));
				drug_search_by						=	getValue((String) drugMasterMain.get(17)); //Drug_Search_By Added for MMS-DM-CRF-0177
                default_route_yn_chk            =	getCheckStatus(default_route_yn);

				refill_yn						=	bean.getRefillYN();

				prescribing_det					=	bean.getPrescription();
				base_unit_ref					=	getValue((String)prescribing_det.get(0));
				strength_value				=	(String)prescribing_det.get(2);
				strength_uom				=	(String)prescribing_det.get(3);
				pres_cat_code					=	getValue((String)prescribing_det.get(6));
				stock_uom_ref					=	getValue((String)prescribing_det.get(9)); //Added for ICN 28393 
				prescribing_det					=	null;
				prescribing_det					=	bean.loadBaseUnit(bean_form_code);
				//COMMENTED FOR SKR-SCF-1312 START
				ArrayList	desclist	 		= bean.getDescFromMM(drug_code, locale);  
				if(desclist.size()>0 && desclist!=null){ //Modified for SKR-SCF-1641
					mm_short_desc=(String)desclist.get(0);
					mm_long_desc = (String)desclist.get(1);
				}
				System.out.println("mm_short_desc: "+mm_short_desc); 
				//SKR-SCF-1312 end				
				for(int i=0;i<prescribing_det.size();i+=3){

				   if(((String)prescribing_det.get(i)).equals( base_unit_ref ))	{
						pres_base_uom_desc_ref		=		(String)prescribing_det.get(i+1);
						bean.setPrescribingDesc(pres_base_uom_desc_ref);
				   }
				}

				dispensing_det					=	bean.getDispensing();
				//stock_uom_ref					=	getValue((String)dispensing_det.get(2)); //commented for ICN 28393 
			}
			else	{
				String Drug_Msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NorecordsforDrugCode.label","ph_labels")+drug_code;
				out.println("<script>alert('"+Drug_Msg+"') ;</script>");
			}
		}

		drug_code_rule					=	bean.getDrugCodeGenRule();
		drug_code_and_item				=	bean.getDrugCodeAndItem();
		drug_item_code_link				=	bean.getDrugItemCodeLink();
		drug_to_item_mapping			=	bean.getDrugDrugItemMapping();
		stock_yn						=	bean.getStockModuleYN();
		ip_yn							=	bean.getIPModuleYN();
		or_yn							=	bean.getORModuleYN();
		if(drug_code_rule.equals("G")) {
			drug_code_status		= "disabled";
			drug_desc_status		= "disabled";
		}

		if( (drug_code_and_item.equals("S")) && stock_yn.equals("Y") ) {
			drug_code_status	=	"readOnly";
			drug_desc_status	= "readOnly";
		}
 /*-------------------------code added for showing audit log---------------------------*/
		//primary_key_1  ------>DRUG_CODE
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(drug_code);      
		
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
		
		//Added for MMS-DM-CRF-0177
		
		if(drug_search_by.equals("G"))
		{
			drug_search_generic = "selected";
		}
		else if(drug_search_by.equals("T"))
		{
			drug_search_trade = "selected";
		}
		
		//Added for MMS-DM-CRF-0177
		
		//	out.println("pkey_value="+pkey_value);
		//	out.println("display_audit_log_button_yn="+display_audit_log_button_yn);
		/*--------------------------------------ends here---------------------------------------*/
%>

		<form name="drugMasterMainForm" id="drugMasterMainForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
				<td align="left" class="label"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></td>
<%
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{	
%>
						<td align="left">&nbsp;&nbsp;<input type="text" name="drug_code" id="drug_code" maxlength="20" size="20" <%=drug_code_status%> value="<%=drug_code%>" onBlur="this.value=this.value.toUpperCase();parent.validateCode(this)" onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>

<%	
					}
					else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{	
%>
						<td align="left">&nbsp;&nbsp;<input type="text" name="drug_code" id="drug_code" maxlength="20" size="20" READONLY value="<%=drug_code%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>

<%
					}	
%>
					<td align="left" class="label"><fmt:message key="ePH.InFormulary.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="in_formulary_yn" id="in_formulary_yn" <%=in_formulary_status%> onClick="parent.validateItemCode(this);parent.assignValue(this);" value="<%=in_formulary%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="parent.viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
					</td>

				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="ePH.Linktoanexistingitem.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="link_to_existing_item" id="link_to_existing_item" <%=link_to_existing_item_status%> value="<%=link_to_existing_item%>" onclick="parent.assignValue(this);parent.checkItemCode(this);"></td>
					<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<input type="text" name="item_code" id="item_code" maxlength="20" size="20" value="<%=item_code%>"><input type="button" class="button" value="?" name="item_code_lookup" id="item_code_lookup" onClick="parent.searchItem(document.drugMasterMainForm.item_code)">&nbsp;
<%
					if(stock_yn.equals("Y"))	{	
%>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="item_mand" style="visibility:hidden"></td>
<%
					}
%>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></td>
<%
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
%>
						<td align="left" >&nbsp;&nbsp;<input type="text" name="drug_desc" id="drug_desc" maxlength="60" size="66" value="<%=drug_desc%>" <%=drug_desc_status%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> <!-- Removed Colspan for MMS-DM-CRF-0177 -->
<%
					}
					else{
%>
					   <td align="left">&nbsp;&nbsp;<input type="text" name="drug_desc" id="drug_desc" maxlength="60" size="66" value="<%=drug_desc%>" <%=drug_desc_status%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> <!-- Removed Colspan for MMS-DM-CRF-0177 -->
<%
				   }
					System.out.println("DrugMasterMain.jsp - drug_desc: "+drug_desc); 
					
				 /* Added For MMS-DM-CRF-0177 */
                   if(drug_search){
%>
                	<td align="left" class="label"><fmt:message key="ePH.DrugSearchBy.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<select name="drug_search_by" id="drug_search_by"  onchange="validateDrugSearchBy(this)" >
					<option value="G" <%=drug_search_generic%>><fmt:message key="ePH.Generic.label" bundle="${ph_labels}"/></option>
					<option value="T" <%=drug_search_trade%>><fmt:message key="ePH.Generic&TradeName.label" bundle="${ph_labels}"/></option>
					</select></td>
<%					} 
%>
 					 <!-- Added For MMS-DM-CRF-0177 -->
				</tr> 
				<tr>
					<td align="left" class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;
					<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40" value="<%=generic_name%>"><input type="button" class="button" name="gnbtn" id="gnbtn" value="?"  onclick="parent.searchGenericName(this);">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
						<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>"></td>
					<td align="left" class="label"><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="compound_drug_yn" id="compound_drug_yn" <%=compound_status%>	value="<%=compound%>" onclick="parent.assignValue(this);parent.validateAlternateAndStrength(this);" ></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;
						<select name="form_code" id="form_code"
						onChange="parent.populateRoute(document.drugMasterMainForm)"	><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
						for(int i=0; i<formCode.size(); i++){

							form_code	=	(String)formCode.get(i);
							form_desc	=	(String)formDesc.get(i);
							if(bean_form_code.equals(form_code))	{
%>
								<option value="<%=form_code%>" selected><%=form_desc%></option>
<%
							}
							else{	
%>
								<option value="<%=form_code%>"><%=form_desc%></option>
<%		
							}
						}
%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<!-- Code Changed for CRF -0034 Route Selection  -->
					<td align="left" class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;
						<select name="route_code" id="route_code" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'>
						<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<!-- Code Started for Prompt Alert for Preferred Drug  -->
				<tr>
				<td align="left" class="label"><fmt:message key="ePH.PromptAlertForPreferredDrug.label" bundle="${ph_labels}"/> </td>
					<td align="left">
						<input type="checkbox" name="prompt_alert_for_preferred_drug" id="prompt_alert_for_preferred_drug" <%=alert_for_preferred_drug_status%> onClick="parent.promptAlertForDrug(this);" value="<%=promptAlertDrug%>">
					</td>
					<td align="left" class="label"><fmt:message key="ePH.DefaultRoute.label" bundle="${ph_labels}"/> </td>
					<td align="left">
						<input type="checkbox" name="default_route_yn" id="default_route_yn" <%=default_route_yn_chk%> onClick="parent.promptAlertForDrug(this);" value="<%=default_route_yn%>">
					</td>
				</tr>
				<!-- Code ended for Prompt Alert for Preferred Drug  -->
				
			</table>
		
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="short_desc" id="short_desc" value="">
			<input type="hidden" name="sql_ph_drug_select25" id="sql_ph_drug_select25" value="<%=sql_ph_drug_select25%>">
			<input type="hidden" name="stock_yn" id="stock_yn" value="<%=stock_yn%>">
			<input type="hidden" name="ip_yn" id="ip_yn" value="<%=ip_yn%>">
			<input type="hidden" name="or_yn" id="or_yn" value="<%=or_yn%>">
			<input type="hidden" name="bean_route_code" id="bean_route_code" value="<%=route_code%>">
			<input type="hidden" name="drug_item_code_link" id="drug_item_code_link" value="<%=drug_item_code_link%>">
			<input type="hidden" name="drug_code_and_item" id="drug_code_and_item" value="<%=drug_code_and_item%>">
			<input type="hidden" name="sql_ph_drug_select14" id="sql_ph_drug_select14" value="<%=sql_ph_drug_select14%>">
			<input type="hidden" name="sql_ph_drug_search_select21" id="sql_ph_drug_search_select21" value="<%=sql_ph_drug_search_select21%>">
			<input type="hidden" name="sql_ph_drug_search_select22" id="sql_ph_drug_search_select22" value="<%=sql_ph_drug_search_select22%>">
			<input type="hidden" name="sql_ph_drug_search_select23" id="sql_ph_drug_search_select23" value="<%=sql_ph_drug_search_select23%>">
			<input type="hidden" name="sql_ph_drug_search_select24" id="sql_ph_drug_search_select24" value="<%=sql_ph_drug_search_select24%>">
			<input type="hidden" name="sql_ph_drug_search_select25" id="sql_ph_drug_search_select25" value="<%=sql_ph_drug_search_select25%>">
			<input type="hidden" name="sql_ph_drug_search_select26" id="sql_ph_drug_search_select26" value="<%=sql_ph_drug_search_select26%>">
			<input type="hidden" name="sql_or_ph_select1" id="sql_or_ph_select1" value="<%=sql_or_ph_select1%>">
			<input type="hidden" name="sql_or_ph_select2" id="sql_or_ph_select2" value="<%=sql_or_ph_select2%>">
			<input type="hidden" name="sql_or_ph_select3" id="sql_or_ph_select3" value="<%=sql_or_ph_select3%>">
			<input type="hidden" name="allow_inventory" id="allow_inventory" value="Y">
			<input type="hidden" name="drug_class" id="drug_class" value="">
			<input type="hidden" name="drug_to_item_mapping" id="drug_to_item_mapping" value="<%=drug_to_item_mapping%>">
			<input type="hidden" name="current_form" id="current_form" value="">
			<input type="hidden" name="last_link" id="last_link" value="">
			<input type="hidden" name="form_modify" id="form_modify" value="N">
			<input type="hidden" name="content_in_pres_base_uom_ref" id="content_in_pres_base_uom_ref" value="">
			<input type="hidden" name="scheduled_drug_yn_man" id="scheduled_drug_yn_man" value="N">
			<input type="hidden" name="schedule_man" id="schedule_man" value="">
			<input type="hidden" name="drug_cat_code" id="drug_cat_code" value="<%=pres_cat_code%>">
			<input type="hidden" name="pres_base_uom_ref" id="pres_base_uom_ref" value="<%=base_unit_ref%>">
			<input type="hidden" name="stock_uom_code" id="stock_uom_code" value="">
			<input type="hidden" name="stock_uom_desc" id="stock_uom_desc" value="">
			<input type="hidden" name="pres_base_uom_desc_ref" id="pres_base_uom_desc_ref" value="<%=pres_base_uom_desc_ref%>">
			<input type="hidden" name="base_unit_code" id="base_unit_code" value="">
			<input type="hidden" name="base_unit_desc" id="base_unit_desc" value="">
			<input type="hidden" name="base_unit_status" id="base_unit_status" value="">
			<input type="hidden" name="stock_uom_ref" id="stock_uom_ref" value="<%=stock_uom_ref%>">
			<input type="hidden" name="content_in_pres_base_uom_man" id="content_in_pres_base_uom_man" value="">
			<input type="hidden" name="prn_doses_pres_prd_fill_man" id="prn_doses_pres_prd_fill_man" value="">
			<input type="hidden" name="prn_doses_cont_daily_fill_man" id="prn_doses_cont_daily_fill_man" value="">
			<input type="hidden" name="multi_strength_status" id="multi_strength_status" value="">
			<input type="hidden" name="disp_auth_reqd_yn" id="disp_auth_reqd_yn" value="">
			<input type="hidden" name="link" id="link" value="">
			<input type="hidden" name="retval" id="retval" value="">
			<input type="hidden" name="count_flag" id="count_flag" value="">
			<input type="hidden" name="or_status" id="or_status" value="<%=or_status%>">
			<input type="hidden" name="toolbarQueryString" id="toolbarQueryString" value="">
			<input type="hidden" name="refill_yn" id="refill_yn" value="<%=refill_yn%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="licenceRights" id="licenceRights" value="<%=licenceRights%>">
			<input type="hidden" name="strength_uom" id="strength_uom" value="<%=strength_uom%>">
			<input type="hidden" name="strength_value" id="strength_value" value="<%=strength_value%>">
			<input type="hidden" name="item_image_path" id="item_image_path" value="<%=item_image_path%>">
			<input type="hidden" name="fntColor" id="fntColor" value="<%=fntColor%>"><!-- added for CRF RUT-CRF-0034.1[IN:037389] -->
			<input type="hidden" name="backgrndColor" id="backgrndColor" value="<%=backgrndColor%>"><!-- added for CRF RUT-CRF-0034.1[IN:037389] -->
			<input type="hidden" name="reissue_count" id="reissue_count" value=""><!--Added for Bru-HIMS-CRF-405[Inc : 44830] -->
			<input type="hidden" name="reissue_type" id="reissue_type" value=""><!--Added for Bru-HIMS-CRF-405[Inc : 44830] -->
			<input type="hidden" name="expiry_alert_days" id="expiry_alert_days" value=""><!-- Added for TH-KW-CRF-0008 -->
		 <input type="hidden" name="mm_short_desc" id="mm_short_desc" value="<%=mm_short_desc%>">
			<input type="hidden" name="mm_long_desc" id="mm_long_desc" value="<%=mm_long_desc%>">
			<input type="hidden" name="pre_alloc_appl_yn" id="pre_alloc_appl_yn" value="<%=pre_alloc_appl_yn%>"> <!-- Added for MMS-DM-CRF-0177 -->
		</form>
		<script>
<%
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 
%>				parent.populateRoute(document.drugMasterMainForm);
				parent.defaultRouteValue();
				parent.getMainDrugClass(document.drugMasterMainForm.generic_id.value);
<%
			}
			if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {	
%>
				parent.validateLinkItem();
				parent.checkItemCode(document.drugMasterMainForm.link_to_existing_item);
<%
			}
%>
			parent.setFocus(document.drugMasterMainForm);
			parent.loadButtons('<%=req_str%>');
		</script>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

