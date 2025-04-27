<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	String serialNum		= request.getParameter("serialNum") == null ? "1":request.getParameter("serialNum");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");

	String or_mode			=	request.getParameter("or_mode") == null ? "":request.getParameter("or_mode");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String resp_id		= (String)ORbean.getResponsibilityId();
	String pract_id		= (String)ORbean.getPractitionerId();
	String pract_name	= (String)ORbean.getPractitionerName();
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String order_id		= (String)ORbean.getOrderId();

	String license			=	bean.getLicense();
	String readOnly			=	"";
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<FORM name="formIVPrescriptionDrugDetails" id="formIVPrescriptionDrugDetails">
<%
		String disabled	= "";
		int srlNo		= 0;
		srlNo			= Integer.parseInt(serialNum);

		ArrayList drug_details		= bean.getDrugDetails();
		ArrayList drugList			= null;
		if(drug_details.size()==0)
			drugList = bean.loadAmendDetails(order_id,patient_id,""); //RUT-CRF-0062
		else
			drugList = drug_details;

		
		HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);

//		out.println(drugDetails);


		String generic_id			= (String)drugDetails.get("GENERIC_ID");
		String drug_desc			= (String)drugDetails.get("CATALOG_DESC");
		String drug_code			= (String)drugDetails.get("DRUG_CODE");
		String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
		String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
		String generic_name			= (String)drugDetails.get("GENERIC_NAME");
		String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
		String unit_dose			= (String)drugDetails.get("UNIT_DOSE");
		String mono_graph			= (String)drugDetails.get("MONO_GRAPH");
		String limit_ind			= (String)drugDetails.get("LIMIT_IND");
		String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
		String current_rx			= (String)drugDetails.get("CURRENT_RX");
		String srl_no				= (String)drugDetails.get("SRL_NO");
		String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
		String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
		String strength_uom			= (String)drugDetails.get("QTY_UNIT");
		String form_code			= (String)drugDetails.get("FORM_CODE");
		String pres_qty_value		= (String)drugDetails.get("QTY_VALUE");
		String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
		String freq_code			= (String)drugDetails.get("FREQ_CODE");
		String durn_value			= (String)drugDetails.get("DURN_VALUE");
		String durn_type			= (String)drugDetails.get("DURN_TYPE");
		String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
		String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
		String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
		String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
		String auth_yn				= (String)drugDetails.get("AUTH_YN");
		String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
		String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
		String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
		String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
		String route_code			= (String)drugDetails.get("ROUTE_CODE");
		String end_date				= (String)drugDetails.get("END_DATE");
		String dup_drug_desc		= (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");
		String allergy_desc			= (String)drugDetails.get("ALLERGY_OVERRIDE_REASON");
		String exceed_dose_desc		= (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");
		String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
		String bms_qty				= (String)drugDetails.get("BMS_QTY");
		String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
		String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
		String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
		String amend_yn				= (String)drugDetails.get("AMEND_YN");
String abuse_exists= (String)drugDetails.get("ABUSE_EXISTS");
String abuse_action= (String)drugDetails.get("ABUSE_ACTION");
String abuse_override_remarks= (String)drugDetails.get("abuse_drug_override_reason");
String abuse_override= (String)drugDetails.get("ABUSE_OVERRIDE");
System.out.println("ivprescritpion"+abuse_override_remarks+"abuse_override_remarks");
	
		/*out.println("dup_drug_desc:"+dup_drug_desc);
		out.println("allergy_desc:"+allergy_desc);
		out.println("exceed_dose_desc:"+exceed_dose_desc);*/

		if(dup_drug_desc != null && !dup_drug_desc.equals("")){
			current_rx="Y";
		}
		if(allergy_desc != null && !allergy_desc.equals("")){
			allergy_yn = "N";
		}
		if(exceed_dose_desc != null && !exceed_dose_desc.equals("")){
			limit_ind = "Y";
		}

		HashMap practRights			= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);

		String pres_base	=	bean.getPresBase(drug_code);
		String base_desc	=	"";
//		String base_code	=	"";
		String infusion_uom	=	"";
		String dr_flow_unit	=	"";
		
		if(drugDetails.containsKey("INFUSION_UOM"))
			infusion_uom			= (String)drugDetails.get("INFUSION_UOM");

		if(drugDetails.containsKey("dr_flow_unit"))
			dr_flow_unit			= (String)drugDetails.get("dr_flow_unit");

		StringTokenizer st	=	new StringTokenizer(pres_base,"::");
		if(st.hasMoreTokens()) {
			base_desc	=	st.nextToken();
//			base_code	=	st.nextToken();
		}

		String pack_values	=	bean.getInfuseOverValue(drug_code,"");//Added "" for ML-MMOH-CRF-1223
		StringTokenizer st1	=	new StringTokenizer(pack_values,"::");
		String pack_size	=	"";

		if(st1.hasMoreTokens()) {
			st1.nextToken(); st1.nextToken(); st1.nextToken();
			pack_size	=	st1.nextToken();
			
		}	
%>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="10%" CLASS="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD WIDTH="60%" ><INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="<%= drug_desc %>" SIZE="45" MAXLENGTH="40" DISABLED><INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?" onClick="searchIVDrugs('D', DRUG_NAME)" DISABLED>

<%
		if (iv_option.equals("Y")) {
%>

			<IMG ID="mandate_drug" SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>

<%
		}
%>
			
			<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_code %>">
		</TD>
		<TD WIDTH="15%" CLASS="label"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD WIDTH="15%" ><SELECT name="DOSAGE" id="DOSAGE" onChange="changeScrDetails(this.value);" disabled>
<%
		if (strength_value.equals("0")) {
%>

			<OPTION VALUE="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>

<%
		}
		else {
			if(dosage_type.equals("Q")) {
%>

			<OPTION VALUE="S"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="Q" SELECTED><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>

<%
			}
			else {
%>

			<OPTION VALUE="S" SELECTED><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>

<%
			}
		}
%>

			</SELECT>
		</TD>
	</TR>
	</TABLE>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="25%" CLASS="label" ID="auth_yn_img">

<%
		if (drugDetails.get("ORD_AUTH_REQD_YN").equals("Y")) {
			//if (practRights.get("AUTH_YN").equals("Y")) {
				if (drugDetails.get("AUTH_YN_VAL").equals("N")) {
%>

					<IMG SRC="../../eOR/images/Authorization.gif" BORDER="0"></IMG>&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('authorize')"><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></A>

<%
				}
				else if(drugDetails.get("AUTH_YN_VAL").equals("Y")) {
%>

					<IMG SRC="../../eOR/images/Authorized.gif" BORDER="0"></IMG>&nbsp;<B><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></B>

<%
				}
		//	}
			else {
%>

				<IMG SRC="../../eOR/images/Authorization.gif" BORDER="0"></IMG>&nbsp;<fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/>

<%
			}
		}
%>

		</TD>
		<TD WIDTH="25%" CLASS="label" ID="spappl_yn_img">

<%
		if (drugDetails.get("ORD_APPR_REQD_YN").equals("Y")) {
			if (practRights.get("SPL_APPR_YN").equals("Y")) {
				if (drugDetails.get("APPROVAL_YN_VAL").equals("N")) {
%>

					<IMG SRC="../../eOR/images/SpecialApproval.gif" BORDER="0"></IMG>&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('approve')"><fmt:message key="Common.Approve.label" bundle="${common_labels}"/></A>

<%
				}
				else {
%>

					<IMG SRC="../../eOR/images/SpecialApproval_click.gif" BORDER="0"></IMG>&nbsp;<B><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></B>

<%
				}
			}
			else {
%>

				<IMG SRC="../../eOR/images/SpecialApproval.gif" BORDER="0"></IMG>&nbsp;<fmt:message key="ePH.SplApprovalReqd.label" bundle="${ph_labels}"/>

<%
			}
		}
%>

		</TD>
		<TD WIDTH="20%" CLASS="label" ID="cosign_yn_img">

<%
		if (drugDetails.get("ORD_COSIGN_REQD_YN").equals("Y")) {
			if (practRights.get("COSIGN_YN").equals("Y")) {
				if (drugDetails.get("COSIGN_YN_VAL").equals("N")) {
%>

					<IMG SRC="../../eOR/images/Cosign_click.gif" BORDER="0">&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('cosign')"><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></A>

<%
				}
				else {
%>

					<IMG SRC="../../eOR/images/Cosign.gif" BORDER="0">&nbsp;<B><fmt:message key="Common.Cosigned.label" bundle="${common_labels}"/></B>

<%
				}
			}
			else {
%>

				<IMG SRC="../../eOR/images/Cosign_click.gif" BORDER="0">&nbsp;<fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/>

<%
			}
		}
%>

		</TD>

<%
		drugDetails.put("CONSENT_REQD_YN","N");


		if (drugDetails.get("CONSENT_REQD_YN").equals("Y")) {
%>

		<TD WIDTH="15%" CLASS="eORConsent" ID="consent" TITLE="Consent Required"><FONT COLOR="#0066CC" SIZE="1"><B><fmt:message key="ePH.ConsentReqd..label" bundle="${ph_labels}"/></B></FONT></TD>

<%
		}
		else {
%>

		<TD WIDTH="15%" CLASS="label" ID="consent">&nbsp;</TD>

<%
		}
%>

		<TD WIDTH="15%" CLASS="label" ID="monograph">

<%
		drugDetails.put("MONO_GRAPH","N");

		if (drugDetails.get("MONO_GRAPH").equals("")) {
%>

			&nbsp;

<%
		}
		else {
%>


			<A HREF onMouseOver="changeCursor(this);" onClick="showMonoGraph('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>');"><fmt:message key="ePH.Monograph.label" bundle="${ph_labels}"/></A></IMG>

<%
		}
%>

		</TD>
	</TR>
	</TABLE>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>

<%
		String str_value = pres_qty_value;
		if (strength_value.equals("0")) {						
%>
		<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
		}else {
				if(dosage_type.equals("S")) {
%>
		<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/>&nbsp;</TD>
<%
				}else {
%>
		<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;</TD>
<%
				}
		}
		if(str_value != null && str_value != "" && Float.parseFloat(str_value) < 1.0){
			str_value = Float.parseFloat(str_value)+"";
		}
%>
		<TD WIDTH="20%" >
			<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" CLASS="number" VALUE="<%=str_value%>" SIZE="3" MAXLENGTH="6" onBlur="setCalculatedQty(this);"><SELECT name="STRENGTH_UOM" id="STRENGTH_UOM" disabled onChange="setQtyUOM(this.value)">
<%
		if (!strength_value.equals("0")) {
			if(dosage_type.equals("S")) {
%>

				<OPTION VALUE="<%= strength_uom %>"><%= strength_uom_desc %></OPTION>

<%
			}
			else {
%>

				<OPTION VALUE="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</OPTION>

<%
				Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
				Enumeration keys_des		= QtyDescDetails.keys();
				String uom_code				= "";
				String uom_desc				= "";
				String def_uom				= "";

				while(keys_des.hasMoreElements()) {
					uom_code	= (String)keys_des.nextElement();
					uom_desc	= (String)QtyDescDetails.get(uom_code);

					if(!uom_code.equals("dflt_code")) {
						if(uom_code.equals(qty_desc_code))
							def_uom = "SELECTED";
						else
							def_uom = "";
%>

				<OPTION VALUE="<%= uom_code %>" <%= def_uom %>><%= uom_desc %></OPTION>

<%
					}
				}
			}
		}
		else {
%>

				<OPTION VALUE="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</OPTION>

<%
			Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
			Enumeration keys_des		= QtyDescDetails.keys();
			String uom_code				= "";
			String uom_desc				= "";
			String def_uom				= "";
			String dflt_code			= "";

			if (amend_yn.equals("N"))
				dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
			else
				dflt_code = qty_desc_code;

			while(keys_des.hasMoreElements()) {
				uom_code	= (String)keys_des.nextElement();
				uom_desc	= (String)QtyDescDetails.get(uom_code);

				if(!uom_code.equals("dflt_code")) {
					if(uom_code.equals(dflt_code))
						def_uom = "SELECTED";
					else
						def_uom = "";
%>

				<OPTION VALUE="<%= uom_code %>" <%= def_uom %>><%= uom_desc %></OPTION>


<%
				}
			}
		}
%>

			</SELECT><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
		</TD>
		<TD WIDTH="15%" CLASS="label"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>&nbsp;</TD>

<%
		String inf_uom = "";
		int srlNum		= Integer.parseInt(srl_no)-1;
		String inf_val	= bean.getInfRate(Integer.toString(srlNum), 3);

		if (strength_value.equals("0")) {
			disabled = "DISABLED";
		}
		else {
			if(dosage_type.equals("S")) {
				inf_uom = strength_uom_desc;
				disabled = "";

				if (!inf_val.equals("") && !(bean.getInfRate(Integer.toString(srlNum), 1).equals(Integer.toString(srlNum)))) {
					disabled = "DISABLED";
				}
				else if (inf_val.equals("")) {
					disabled = "";
				}
			}
			else {
				disabled = "DISABLED";
			}
		}
%>

		<TD WIDTH="35%" CLASS="label"><INPUT TYPE="text" name="INFUSION_VALUE" id="INFUSION_VALUE" VALUE="<%= bean.getInfRate(Integer.toString(srlNum), 2) %>" SIZE="1" MAXLENGTH="3" onBlur="setInfusionPeriod(this)" CLASS="number" disabled <%=readOnly%>>
		<SELECT name="INFUSION_UOM" id="INFUSION_UOM" onChange="setInfusionPeriod(document.formIVPrescriptionDrugDetails.INFUSION_VALUE)" disabled>&nbsp;
		<% if(infusion_uom.equals("strength_uom")) {	%>
			<OPTION VALUE="strength_uom" selected><%= inf_uom %></option>
			<option value="pres_uom"><%=base_desc%></option>
		<%	} else if(infusion_uom.equals("pres_uom")) {	%>
			<OPTION VALUE="strength_uom"><%= inf_uom %></option>
			<option value="pres_uom" selected><%=base_desc%></option>
		<%	}	else	{	%>
			<OPTION VALUE="strength_uom"><%= inf_uom %></option>
			<option value="pres_uom"><%=base_desc%></option>
		<%	}	%>
		</select>&nbsp;/&nbsp;<select name="dr_flow_unit" id="dr_flow_unit" onChange="defaultRates(this)" disabled >
		<% if(dr_flow_unit.equals("M")) {	%>
			<option value="M" selected><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></option>
			<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
		<%	} else if(dr_flow_unit.equals("H")) {	%>
			<option value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></option>
			<option value="H" selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
		<%	} else {	%>
			<option value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></option>
			<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
		<%	}	%>

		</select>	
		<TD WIDTH="10%" CLASS="label"><A HREF onMouseOver="changeCursor(this);"  id="drug_remarks"  onClick="getFormatId('Drug')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A></TD>
		<INPUT TYPE="hidden" name="INF_VAL" id="INF_VAL" VALUE="<%= bean.getInfRate(Integer.toString(srlNum), 2) %>">
	</TR>
	</TABLE>

	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="patient_id" id="patient_id" VALUE="<%= patient_id %>">
	<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" VALUE="<%= encounter_id %>">
	<INPUT TYPE="hidden" name="start_date" id="start_date" VALUE="<%= start_date %>">
	<INPUT TYPE="hidden" name="patient_class" id="patient_class" VALUE="<%= patient_class %>">
	<INPUT TYPE="hidden" name="drug_codes" id="drug_codes" VALUE="<%= bean.getDrugCodes() %>">
	<INPUT TYPE="hidden" name="resp_id" id="resp_id" VALUE="<%= resp_id %>">
	<INPUT TYPE="hidden" name="pract_id" id="pract_id" VALUE="<%= pract_id %>">
	<INPUT TYPE="hidden" name="pract_name" id="pract_name" VALUE="<%= pract_name %>">
	<INPUT TYPE="hidden" name="locn_type" id="locn_type" VALUE="<%= locn_type %>">
	<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%= locn_code %>">
	<INPUT TYPE="hidden" name="GENERIC_ID" id="GENERIC_ID" VALUE="<%= generic_id %>">
	<INPUT TYPE="hidden" name="GENERIC_NAME" id="GENERIC_NAME" VALUE="<%= generic_name %>">
	<INPUT TYPE="hidden" name="DAILY_DOSE" id="DAILY_DOSE" VALUE="<%= daily_dose %>">
	<INPUT TYPE="hidden" name="UNIT_DOSE" id="UNIT_DOSE" VALUE="<%= unit_dose %>">
	<INPUT TYPE="hidden" name="MONO_GRAPH" id="MONO_GRAPH" VALUE="<%= mono_graph %>">
	<INPUT TYPE="hidden" name="LIMIT_IND" id="LIMIT_IND" VALUE="<%= limit_ind %>">
	<INPUT TYPE="hidden" name="ALLERGY_YN" id="ALLERGY_YN" VALUE="<%= allergy_yn %>">
	<INPUT TYPE="hidden" name="CURRENT_RX" id="CURRENT_RX" VALUE="<%= current_rx %>">
	<INPUT TYPE="hidden" name="SRL_NO" id="SRL_NO" VALUE="<%= srl_no %>">
	<INPUT TYPE="hidden" name="FORM_CODE" id="FORM_CODE" VALUE="<%= form_code %>">
	<INPUT TYPE="hidden" name="PRES_QTY_VALUE" id="PRES_QTY_VALUE" VALUE="<%= str_value %>">
	<INPUT TYPE="hidden" name="PRES_BASE_UOM" id="PRES_BASE_UOM" VALUE="<%= pres_base_uom %>">
	<INPUT TYPE="hidden" name="FREQ_CODE" id="FREQ_CODE" VALUE="<%= freq_code %>">
	<INPUT TYPE="hidden" name="DURN_VALUE" id="DURN_VALUE" VALUE="<%= durn_value %>">
	<INPUT TYPE="hidden" name="DURN_TYPE" id="DURN_TYPE" VALUE="<%= durn_type %>">
	<INPUT TYPE="hidden" name="OR_DURN_DESC" id="OR_DURN_DESC" VALUE="<%= or_durn_desc %>">
	<INPUT TYPE="hidden" name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL" VALUE="<%= approval_yn_val %>" >
	<INPUT TYPE="hidden" name="AUTH_YN_VAL" id="AUTH_YN_VAL" VALUE="<%= auth_yn_val %>">
	<INPUT TYPE="hidden" name="COSIGN_YN_VAL" id="COSIGN_YN_VAL" VALUE="<%= cosign_yn_val %>">
	<INPUT TYPE="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE" VALUE="<%= order_type_code %>">
	<INPUT TYPE="hidden" name="ROUTE_CODE" id="ROUTE_CODE" VALUE="<%= route_code %>">
	<INPUT TYPE="hidden" name="END_DATE" id="END_DATE" VALUE="<%= end_date %>">
	<INPUT TYPE="hidden" name="AUTH_YN" id="AUTH_YN" VALUE="<%= auth_yn %>">
	<INPUT TYPE="hidden" name="APPROVAL_YN" id="APPROVAL_YN" VALUE="<%= approval_yn %>">
	<INPUT TYPE="hidden" name="COSIGN_YN" id="COSIGN_YN" VALUE="<%= cosign_yn %>">
	<INPUT TYPE="hidden" name="CONSENT_REQD_YN" id="CONSENT_REQD_YN" VALUE="<%= consent_reqd_yn %>">
	<INPUT TYPE="hidden" name="ALLERGY_DESC" id="ALLERGY_DESC" VALUE="<%= allergy_desc %>">
	<INPUT TYPE="hidden" name="EXCEED_DOSE_DESC" id="EXCEED_DOSE_DESC" VALUE="<%= exceed_dose_desc %>">
	<INPUT TYPE="hidden" name="DUP_DRUG_DESC" id="DUP_DRUG_DESC" VALUE="<%= dup_drug_desc %>">
	<INPUT TYPE="hidden" name="UOM_CODE" id="UOM_CODE" VALUE="<%= strength_uom %>">
	<INPUT TYPE="hidden" name="STRENGTH_UOM_DESC" id="STRENGTH_UOM_DESC" VALUE="<%= strength_uom_desc %>">
	<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= strength_value %>">
	<INPUT TYPE="hidden" name="BMS_QTY" id="BMS_QTY" VALUE="<%= bms_qty %>">
	<INPUT TYPE="hidden" name="DFLT_QTY_UOM" id="DFLT_QTY_UOM" VALUE="<%= dflt_qty_uom %>">
	<INPUT TYPE="hidden" name="TAB_QTY_VALUE" id="TAB_QTY_VALUE" VALUE="<%= tab_qty_value %>">
	<INPUT TYPE="hidden" name="QTY_DESC_CODE" id="QTY_DESC_CODE" VALUE="<%= qty_desc_code %>">
	<INPUT TYPE="hidden" name="MIN_DAILY_DOSE" id="MIN_DAILY_DOSE" VALUE="<%= min_daily_dose %>">
	<INPUT TYPE="hidden" name="MIN_UNIT_DOSE" id="MIN_UNIT_DOSE" VALUE="<%= min_unit_dose %>">
	<INPUT TYPE="hidden" name="STR_DESC" id="STR_DESC" VALUE="">
	<input type="hidden" name="pack_size" id="pack_size" value="<%=pack_size%>">
	<input type="hidden" name="license" id="license" value="<%=license%>">
	<INPUT TYPE="hidden" name="abuse_action" id="abuse_action" VALUE="<%= abuse_action %>">
	<INPUT TYPE="hidden" name="abuse_exists" id="abuse_exists" VALUE="abuse_exists">
	<input type="hidden" name="ABUSE_OVERRIDE" id="ABUSE_OVERRIDE" value="<%=abuse_override%>">
	<input type="hidden" name="abuse_override_remarks" id="abuse_override_remarks" value="<%=abuse_override_remarks%>">
	<SCRIPT>
		loadButtonsFrame('<%=or_mode%>','<%=patient_id%>','<%=encounter_id%>');
		/*if(document.formIVPrescriptionDrugDetails.DOSAGE.value!="") {
			changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value);
		}*/
	</SCRIPT>
</FORM>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
%>

