<!DOCTYPE html>
 <!--Fine Tuning-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList,java.util.HashMap, ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%! 

	public String getCheckStatus(String value)	{
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
%>
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
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugMasterDetail.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugMaster.js"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        <style>
             textarea {
                         resize: none;
                      }
        </style>


	</head>
	<body  onKeyDown="lockKey()"  onMouseDown = 'CodeArrest()' >
		<form name="drugMasterAddModifyForm" id="drugMasterAddModifyForm" >
<%
		String link				= request.getParameter("link")==null?"":request.getParameter("link");
		String drug_code		= request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String item_code		= request.getParameter("item_code")==null?"":request.getParameter("item_code");
		String form_code		= request.getParameter("form_code")==null?"":request.getParameter("form_code");
		String generic_id		= request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String default_strength_value= request.getParameter("default_strength_value")==null?"":request.getParameter("default_strength_value");//added for ghl-crf-0548
		String dis_continuous	="";
		String dis_prescribed	="";
		String drug_class		="";
		String sql_ph_drug_select14	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
		String sql_ph_drug_select19	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT19");
		String sql_ph_drug_select24	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT24");
		String sql_ph_drug_select25	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT25");
		String sql_ph_drug_select26	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT26");

		String bean_id		=	"DrugMasterBean" ;
		String bean_name	=	"ePH.DrugMasterBean";
		String mode			=	"";
		ArrayList	prescribing_det				=	null;
		ArrayList	iv_char						=	null;
		ArrayList	dispensing_det				=	null;
		ArrayList	external_db					=	null;

		String	pres_base_uom					=	"";
		String	strength_value					=	"";
		String	strength_uom					=	"";
		String	strength_per_pres_uom			=	"";
		String	strength_per_value_pres_uom_qty		=	"";
		String	vol								=	"";
		String	qty								=	"";
		String	pres_catg_code					=	"";
		String	iv_ingredient_yn_chk			=	"";
		String	iv_fluid_yn_chk					=	"";
		String	iv_ingredient_yn				=	"";
		String	iv_fluid_yn						=	"";
		String	appl_piggy_back_yn				=	"";
		String	appl_piggy_back_yn_chk			=	"";
		String	infuse_over_value				=	"";
		String	infuse_over_value_hrs			=	"";
		String	infuse_over_value_mins		=  "";
	//	String	infuse_over_durn_type			=	"";
		String  physical_form					=   "";
		String  dflt_drug_code					=	"";
		String	appl_recn_fld_yn				=	"";
		String	appl_recn_fld_yn_chk				=	"";
		
		String  code							=   "";
		String desc = "";
		String	calc_dosg_by_freq_durn_yn       =	"Y";
		String	fract_dose_round_up_yn          =	"";
		String	fract_dose_appl_yn          =	"N";
		String	stock_uom                       =	"";
		String	content_in_pres_base_uom        =	"";
		String	disp_multi_strength_yn          =	"";
		String  disp_alt_form_yn				=	"";

		String	prn_doses_pres_prd_fill         =	"";
		String	prn_doses_cont_daily_fill       =	"";
		String	disp_auth_reqd_yn               =	"";
		String	disp_via_pres_only_yn           =	"";
		String	disp_against_damage_yn          =	"";
		String	caution_label_test_id_1         =	"";
		String	spl_instr_label_text_id         =	"";
		String	how_to_take_text                =	"";
		String	how_to_take_text_local          =	"";
		String drug_indication					=   "";// Added for ML-BRU-CRF-072[Inc:29938]
		String  calc_dosg_by_freq_durn_yn_chk	=	"checked";
		String	fract_dose_round_up_yn_chk		=	"";
		String	fract_dose_appl_yn_chk		    =	"";
		String	disp_alt_form_yn_chk			=	"";
		//String	disp_multi_strength_yn_chk		=	"";COMMENTED FOR GHL-CRF-0548
		String	disp_auth_reqd_yn_chk			=	"";
		String	disp_via_pres_only_yn_chk		=	"";
		String  disp_against_damage_yn_chk		=	"";
		String	flag							=	"";
		String calc_def_dosage_yn				=	"";
		String calc_def_dosage_yn_chk			=	"";
		String cyto_toxic_yn					=	"";
		String cyto_toxic_yn_chk				=	"";
		String caution_loc_lang                 =   "";
		String spl_instrn_loc_lang              =   "";
		String	virification_required_yn        =	"";
		String  virification_required_yn_chk	=	"";
		String  allow_morethan_pres_qty_yn	 =	"";
		String allow_morethan_pres_qty_yn_chk = "";
		String default_dosage_by = "";  //Code Added For SKR-CRF-PHIS-003[IN028182]
		String print_label_based_on_qty_yn      =   "N";   //Code Added For RUT-CRF-0067 Start
		String print_label_based_on_qty_yn_chk  =   "";   //Code Added For RUT-CRF-0067 End
		String reissue_type_ind				=  ""; //Code Added For Bru-HIMS-CRF-405[IN 044830]
		String  reissue_count_by_ind        =   ""; //Code Added For Bru-HIMS-CRF-405[IN 044830]
		String  reissue_count				=   ""; //Code Added For Bru-HIMS-CRF-405[IN 044830]
		String default_dosage_by_yn			="Y";//added AAKH-CRF-089
		String default_dosage_by_yn_chk		="checked";// added AAKH-CRF-089
	
		DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		mode=bean.getMode() ;
		ArrayList age_group=	bean.getAgeGroupID();
		ArrayList tmpl_values = new ArrayList();
		tmpl_values = (ArrayList) bean.getSlidingScaleTmpls();
		String display_multi="";//ADDED FOR GHL-CRF-0548
		String 	disp_mlti_frm_parm_set_up=bean.checkForMultiStrength();//added for ghl-crf-0548

		try{
		
			if(link.equals( "inventory_tab" ))	{
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
					flag = "I";
				}
%>
				<script>parent.updateCurrentForm("inventory_tab","f_tab_detail.f_detail.document.drugMasterAddModifyDetailForm","parent.drugMasterMain.document.drugMasterMainForm");</script>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<th align="left" colspan="2"><fmt:message key="ePH.Add/Modify/DeleteAssociatingInventoryItemstoDrugs.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
						<td align="left">&nbsp;<input type="text" name="item_desc" id="item_desc" size="30"><input type="hidden" name="item_code" id="item_code" value=""><input type="button" class="button" value="?" onClick="parent.searchItemDescription(document.drugMasterAddModifyForm.item_desc)" name="item_search" id="item_search">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="ePH.StockingUnit.label" bundle="${ph_labels}"/></td>
						<td align="left">&nbsp;<input type="text" name="stock_uom_desc" id="stock_uom_desc" size="10" maxlength="10" readOnly><input type="hidden" name="stock_uom_code" id="stock_uom_code" size="4" maxlength="4"></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.PackSize.label" bundle="${common_labels}"/></td>
						<td align="left">&nbsp;<input type="text" name="content_in_pres_base_uom" id="content_in_pres_base_uom" size="6" onKeyPress="return(ChkNumberInput(this,event,0));" style="text-align:right" maxlength="6" readOnly><input type="text" name="content_in_strength_uom" id="content_in_strength_uom" size="12" style="text-align:right" maxlength="13" readOnly>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td align="right" colspan="2"><input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class="button" name="del_butt" style="visibility:hidden" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);"><input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" name="add_butt"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="parent.callReset()" name="reset_butt"></td>
					</tr>
					<input type="hidden" name="curr_row" id="curr_row" value="">
					<input type="hidden" name="flag" id="flag" value="<%=flag%>">
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
					<input type="hidden" name="sql_ph_drug_select25" id="sql_ph_drug_select25" value="<%=sql_ph_drug_select25%>">
					<input type="hidden" name="sql_ph_drug_select26" id="sql_ph_drug_select26" value="<%=sql_ph_drug_select26%>">
				</table>
<%
			}
			if(link.equals("trade_tab")){
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
					flag = "I";
				}	
				int maxDispNo	=	bean.getMaxDispNo(link);
%>
				<script>parent.updateCurrentForm("trade_tab","f_tab_detail.f_detail.document.drugMasterAddModifyDetailForm","parent.drugMasterMain.document.drugMasterMainForm");</script>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<th align="left" colspan="5"><fmt:message key="ePH.Add/ModifyTradeNamestoDrugs.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td  class="label" width='12%'><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
						<td  width='25%'><input type="text" name="trade_name" id="trade_name" onBlur="parent.searchTradeName(this);" size="40"><input type="button" class="button" value="?" onclick="parent.searchTradeName(this);" name="trade_search" id="trade_search">&nbsp;<img src="../../eCommon/images/mandatory.gif">
						<input type="hidden" name="trade_id" id="trade_id" value=""></td>
						<td  class="label" width='12%'><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></td>
						<td  width='20%'><input type="text" name="manufacturer_name" id="manufacturer_name" size="20" readOnly><input type="hidden" name="manufacturer_id" id="manufacturer_id" value=""></td>
						<td class="label" style="display:none"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/><input type="hidden" name="disp_seq_no" id="disp_seq_no" maxlength="2" size="2" value="" class="NUMBER"></td>
					</tr>
					<tr>
						<td class="label" nowrap><fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/></td>
						<td ><input type="text" name="trade_image_filename" id="trade_image_filename" maxlength='200' size='40' value=''></td>
						<td align="right" colspan="2"><input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class="button" name="del_butt" style="visibility:hidden" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);">
						<input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" name="add_butt"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="parent.callReset()" name="reset_butt"></td>
					</tr>
				</table>
				<input type="hidden" name="curr_row" id="curr_row" value="">
				<input type="hidden" name="flag" id="flag" value="<%=flag%>">
				<input type="hidden" name="sql_ph_drug_select19" id="sql_ph_drug_select19" value="<%=sql_ph_drug_select19%>">
				<input type="hidden" name="sql_ph_drug_select24" id="sql_ph_drug_select24" value="<%=sql_ph_drug_select24%>">
				 <input type="hidden" name="max_val" id="max_val"  value="<%=maxDispNo%>"> 
<%
			}
			else if(link.equals("generic_tab")){
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
					flag = "I";
				}
			int maxDispNo	=	bean.getMaxDispNo(link);
%>
			<script>parent.updateCurrentForm("generic_tab","f_tab_detail.f_detail.document.drugMasterAddModifyDetailForm","parent.drugMasterMain.document.drugMasterMainForm");</script>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<th align="left" colspan="4"><fmt:message key="ePH.Add/DeleteGenericIngredientstoDrugs.label" bundle="${ph_labels}"/></th>
				</tr>
				<tr>
					<td align="right" class="label" width="20%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
					<td align="left" width="30%">&nbsp;
					<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40"><input type="button" class="button" value="?"  onclick="parent.searchGenericNameforGeneric(this);" name="generic_search" id="generic_search">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					<input type="hidden" name="generic_id" id="generic_id" value=""></td>
					<td align="right" class="label" width="20%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
					<td align="left" width="30%">&nbsp;
					<input type="text" name="disp_seq_no" id="disp_seq_no" maxlength="3" size="2" class="NUMBER" onBlur="CheckNum(this),chkzero1(this)" onKeyPress="return allowValidNumber(this,event,2,0);"></td>
				</tr>
				<tr>
					<td align="right" colspan="4"><input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);" name="del_butt" style="visibility:hidden"><input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" name="add_butt"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="parent.callReset()" name="reset_butt"></td>
				</tr>
			</table>
			<input type="hidden" name="curr_row" id="curr_row" value="">
			<input type="hidden" name="flag" id="flag" value="<%=flag%>">
			<input type="hidden" name="drug_class" id="drug_class" value="">
			<input type="hidden" name="max_val" id="max_val"  value="<%=maxDispNo%>">
<%
		}
		else if(link.equals("prescribingdet_tab"))	{

			ArrayList stock_unit		=	new ArrayList();
			HashMap pres_details = (HashMap) bean.loadPrescribingDetails();
			ArrayList	baseunit = bean.loadBaseUnit(form_code);
			ArrayList	strength = (ArrayList) pres_details.get("strength");
			ArrayList	category = (ArrayList) pres_details.get("category");
			prescribing_det		 =	bean.getPrescription();
			String pres_base_uom_desc = "";

			if(prescribing_det.size()!= 0)	{
				pres_base_uom				=	(String)prescribing_det.get(0);
				calc_dosg_by_freq_durn_yn   =	(String)prescribing_det.get(1);
				strength_value				=	(String)prescribing_det.get(2);
				if(strength_value!=null && !strength_value.equals("")){
					if(Float.parseFloat(strength_value) < 1 &&Float.parseFloat(strength_value)!=0)
						strength_value =Float.parseFloat(strength_value)+"";
		
					if(Float.parseFloat(strength_value)==0)
						strength_value ="";
				}
				else
					strength_value ="";

				strength_uom				=	(String)prescribing_det.get(3);
				strength_per_pres_uom		=	(String)prescribing_det.get(4);
				strength_per_value_pres_uom_qty	=	(String)prescribing_det.get(5);
				pres_catg_code				=	(String)prescribing_det.get(6);
				vol							=	(String)prescribing_det.get(7);
				qty							=	(String)prescribing_det.get(8);
				stock_uom					=   (String)prescribing_det.get(9);
				content_in_pres_base_uom	=   (String)prescribing_det.get(10);
				calc_def_dosage_yn			=   (String)prescribing_det.get(11);
				default_dosage_by_yn			=(String)prescribing_det.get(12);//added AAKH-CRF-089
				stock_unit					=	bean.loadStockUnit(pres_base_uom);
			}
			calc_dosg_by_freq_durn_yn_chk	=	getCheckStatus(calc_dosg_by_freq_durn_yn	);
			calc_def_dosage_yn_chk			=	getCheckStatus(calc_def_dosage_yn	);
			calc_dosg_by_freq_durn_yn		=	getCheckValue(calc_dosg_by_freq_durn_yn	);
			calc_def_dosage_yn				=	getCheckValue(calc_def_dosage_yn	);
			if(default_dosage_by_yn.length()==0)//Added for AAKH-CRF-089
				default_dosage_by_yn="Y";
			default_dosage_by_yn_chk		=	getCheckStatus(default_dosage_by_yn	);
			////END AAKH-CRF-089
			String strength_uom_mand ="display:none;";

		//	if(strength_value!=null && !strength_value.equals(""))
			if(strength_value!=null && !strength_value.equals("") && !strength_value.equals("0"))
				strength_uom_mand = "display:inline;";
%>
			<script>
				parent.adjustFrames('<%=link%>');
				parent.updateCurrentForm("prescribingdet_tab","f_tab_detail.f_detail.document.drugMasterAddModifyForm","parent.drugMasterMain.document.drugMasterMainForm");
			</script>
			<br>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<th colspan="4" align="left"><fmt:message key="ePH.PrescribingDetails.label" bundle="${ph_labels}"/></th>
				</tr>
				<tr>
					<td colspan="4">&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label" width='15%'><fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/></td>
<% 
					if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 
%>
						<td align="left" colspan="3" class="label"><select name="pres_base_uom" id="pres_base_uom" onchange="parent.assignPresRefValue(this);parent.assignPerVolQty(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');parent.loadStockUnit(this);" onBlur="parent.makeInventoryRecord();">
							<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
								for(int i=0;i<baseunit.size(); i+=3){
									String uom_code	=	(String)baseunit.get(i);
									String uom_desc	=	(String)baseunit.get(i+1);
									//String dflt_uom	=	(String)baseunit.get(i+2);

									if(uom_code.equals( pres_base_uom )){
										pres_base_uom_desc =uom_desc; 
%>
										<script>
											parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');
										</script>
										<option value="<%=uom_code%>" selected><%=uom_desc%></option>
<%
									}	
									else{
%>
										<option value="<%=uom_code%>"><%=uom_desc%></option>
<%
									}
								}
%>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" >
						</td>
<% 
					} 
					else { 
%>
						<td align="left" colspan="3" class="label"><select name="pres_base_uom" id="pres_base_uom" onchange="parent.assignPresRefValue(this);parent.assignPerVolQty(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');parent.loadStockUnit(this);" onBlur="parent.makeInventoryRecord();">
							<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
							for(int i=0;i<baseunit.size(); i+=3){
								String uom_code	=	(String)baseunit.get(i);
								String uom_desc	=	(String)baseunit.get(i+1);
								String dflt_uom	=	(String)baseunit.get(i+2);

								if(uom_code.equals( pres_base_uom )  || dflt_uom.equals("Y"))	{
										pres_base_uom_desc =uom_desc; 
 %>
									<script>
										parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');
									</script>
									<option value="<%=uom_code%>" selected><%=uom_desc%></option>
<%
								}
								else{
%>
									<option value="<%=uom_code%>"><%=uom_desc%></option>
<%
								}
							}
%>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
						</td>
<%
					} 
%>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<td align="left" colspan='3' class="label"><input type="text" id="id_qty_value" name="strength_value" id="strength_value"  size="15" maxlength="15" value="<%=strength_value%>" onfocus="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');"  onKeyPress="checkBeforeDecimal(this,event); return allowPositiveNumber(this);" style="text-align:right" onBlur="parent.defaultStrength(this);"> <!--added checkBeforeDecimal() function for ML-BRU-SCF-1437 -->
						<select name="strength_uom" id="strength_uom" onChange="parent.assignPerVolQty(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');">
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
                            for(int i=0;i<strength.size();i++){
								HashMap data = new HashMap();
								data = (HashMap)strength.get(i);
								if( (data.get("uom_code")).equals(strength_uom))	{
%>
									<option value="<%=data.get("uom_code")%>" selected><%=data.get("short_desc")%></option>
<%
								}
								else{
%>
									<option value="<%=data.get("uom_code")%>" ><%=data.get("short_desc")%></option>
<%
								}
							}
%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="strength_mand" style='<%=strength_uom_mand%>'>
						<fmt:message key="ePH.inevery.label" bundle="${ph_labels}"/>
						<input type="text" name="strength_per_value_pres_uom_qty" id="strength_per_value_pres_uom_qty" value="<%=strength_per_value_pres_uom_qty%>" size="3" onfocus="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" style="text-align:right" maxlength="13" disabled  onblur="checkValue();"><!-- checkValue() added for 32491 -->
						<b><label id='strength_pres_uom'><%=pres_base_uom_desc%></label></b>
						<input type="hidden" name="strength_per_pres_uom" id="strength_per_pres_uom"  value="<%=strength_per_pres_uom%>">
						<input type="hidden" name="strength_per_pres_uom_qty" id="strength_per_pres_uom_qty"  value="<%=vol%>">
					</td>
				</tr>
				<tr>
					<td align="left" class="label" ><fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan='3' class="label" ><select name="stock_uom" id="stock_uom" onchange="parent.assignStockRefValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');">
						<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
					   		for(int i=0;i<stock_unit.size();i+=2){
								code = (String)stock_unit.get(i);
								desc = (String)stock_unit.get(i+1);
								if( code.equals(stock_uom))	{
 %>
									<option value="<%=code%>" selected><%=desc%></option>
<%
								}	
								else{
%>
									<option value="<%=code%>"><%=desc%></option>
<%
								}
							}
%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
<%
					if(!(item_code.equals(""))){		
%>
						<script>
							document.drugMasterAddModifyForm.stock_uom.value="<%=code%>";
						</script>
<%
					}
%>
						<fmt:message key="Common.contains.label" bundle="${common_labels}"/>
						&nbsp;<b><label id='pack_size'><%=content_in_pres_base_uom%></label> &nbsp;<label id='disp_pres_uom'> <%=pres_base_uom_desc%></b></label>
						<input type="hidden" name="content_in_pres_base_uom" id="content_in_pres_base_uom" value="<%=content_in_pres_base_uom%>">
					</td>
				</tr>
				<!--				<tr>
 					<td align="right" class="label" ><fmt:message key="ePH.StrengthintermsofBaseUnit.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp; -->
					<!-- &nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="strength_base_mand" style="visibility:hidden"> 
					</td>
				</tr>-->
				<tr>
					<td align="left" class="label" ><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan="3" class="label"><select name="pres_catg_code" id="pres_catg_code" onchange="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');parent.updateDrugMain(this);">
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
                            for(int i=0;i<category.size();i++){
								HashMap data = new HashMap();
								data = (HashMap)category.get(i);
								if(	(data.get("drug_catg_code")).equals(pres_catg_code))	{
%>
									<option value="<%=data.get("drug_catg_code")%>" selected><%=data.get("short_desc")%></option>
<%
								}
								else{
%>
									<option value="<%=data.get("drug_catg_code")%>"><%=data.get("short_desc")%></option>
<%
								}
							}
%>
						</select>
					</td>
				</tr>
					<td align="left" class="label" colspan="2" width='25%'><fmt:message key="ePH.CalculateDefaultDosagebyAge/Weight.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan="2">&nbsp;<input type="checkbox" name="calc_def_dosage_yn" id="calc_def_dosage_yn" value="<%=calc_def_dosage_yn%>" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" <%=calc_def_dosage_yn_chk%>></td>

				<tr>
					<td align="left" class="label" colspan="2" width='25%'><fmt:message key="ePH.CalculateByFreqDurn.label" bundle="${ph_labels}"/></td>
					<td align="left"  colspan="2">&nbsp;<input type="checkbox" name="calc_dosg_by_freq_durn_yn" id="calc_dosg_by_freq_durn_yn" value="<%=calc_dosg_by_freq_durn_yn%>" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" <%=calc_dosg_by_freq_durn_yn_chk%> ></td>
				</tr>
				<!-- AAKH-CRF-089  DefaultDoseApplicable is added Start -->
					<tr>
					<td align="left" class="label" colspan="2" width='25%'><fmt:message key="ePH.DefaultDoseApplicable.label" bundle="${ph_labels}"/></td>
					<td align="left"  colspan="2">&nbsp;<input type="checkbox" name="default_dosage_by_yn" id="default_dosage_by_yn" value="<%=default_dosage_by_yn%>" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" <%=default_dosage_by_yn_chk%> ></td>
				</tr>
				<tr><td colspan="6" >&nbsp;</td></tr>
				<!-- AAKH-CRF-089  DefaultDoseApplicable is added END -->
			</table>
<%
		}
		else if(link.equals("dispensingdet_tab")){

		//	ArrayList stock_unit		= (ArrayList) bean.loadStockUnit(item_code);
			HashMap labels				= (HashMap) bean.loadLabels();
			ArrayList	caution			= (ArrayList) labels.get("caution");
			ArrayList	spl_instruction = (ArrayList) labels.get("spl_instruction");
		//	ArrayList	spl_instruction2 = (ArrayList) labels.get("spl_instruction2");
			String ip_module_status		=	bean.getIPModuleYN();
			String disableString = "disabled", npbdisable="";

			if(ip_module_status.equals("N") || ip_module_status.equals(""))	{
				dis_prescribed	=	"READONLY";
				dis_continuous	=	"READONLY";
			}
			prescribing_det		 =	bean.getPrescription();
			calc_dosg_by_freq_durn_yn   =	(String)prescribing_det.get(1);
			strength_value			   =	(String)prescribing_det.get(2);

			drug_class					=	bean.getDrugClass(generic_id);
			dispensing_det				=	bean.getDispensing();
			if(dispensing_det.size()!=0)	{
				fract_dose_round_up_yn             		=	(String)dispensing_det.get(0)==null?"":(String)dispensing_det.get(0);
				disp_alt_form_yn             			=	(String)dispensing_det.get(1)==null?"":(String)dispensing_det.get(1);
				disp_multi_strength_yn             		=	(String)dispensing_det.get(2)==null?"":(String)dispensing_det.get(2);
				prn_doses_pres_prd_fill            		=	(String)dispensing_det.get(3)==null?"":(String)dispensing_det.get(3);
				prn_doses_cont_daily_fill          		=	(String)dispensing_det.get(4)==null?"":(String)dispensing_det.get(4);
				disp_auth_reqd_yn                  		=	(String)dispensing_det.get(5)==null?"":(String)dispensing_det.get(5);
				disp_via_pres_only_yn              		=	(String)dispensing_det.get(6)==null?"":(String)dispensing_det.get(6);
				disp_against_damage_yn             		=	(String)dispensing_det.get(7)==null?"":(String)dispensing_det.get(7);
				caution_label_test_id_1            		=	(String)dispensing_det.get(8)==null?"":(String)dispensing_det.get(8);
				//caution_label_test_id_2            	=	(String)dispensing_det.get(9);
				spl_instr_label_text_id            		=	(String)dispensing_det.get(10)==null?"":(String)dispensing_det.get(10);
				how_to_take_text                   		=	(String)dispensing_det.get(11)==null?"":(String)dispensing_det.get(11);
				how_to_take_text_local			    	=	(String)dispensing_det.get(12)==null?"":(String)dispensing_det.get(12);
				fract_dose_appl_yn			    	    =	(String)dispensing_det.get(12)==null?"N":(String)dispensing_det.get(14);
				virification_required_yn             	=   (String)dispensing_det.get(15)==null?"":(String)dispensing_det.get(15);
				allow_morethan_pres_qty_yn		        =   (String)dispensing_det.get(16)==null?"N":(String)dispensing_det.get(16);
				print_label_based_on_qty_yn             =   (String)dispensing_det.get(17)==null?"N":(String)dispensing_det.get(17); //Code Added For RUT-CRF-0034 
				default_dosage_by		                =   (String)dispensing_det.get(18)==null?"":(String)dispensing_det.get(18); //Code Added For SKR-CRF-PHIS-003[IN028182]
				drug_indication							=    (String)dispensing_det.get(19)==null?"":(String)dispensing_det.get(19);//Code Added For  ML-BRU-CRF-072[Inc:29938]
				reissue_type_ind						=   (String)dispensing_det.get(22)==null?"":(String)dispensing_det.get(20);//Code Added For Bru-HIMS-CRF-405[IN 044830]
				reissue_count_by_ind					=	(String)dispensing_det.get(22)==null?"":(String)dispensing_det.get(21);//Code Added For Bru-HIMS-CRF-405[IN 044830]
				reissue_count							=   (String)dispensing_det.get(22)==null?"":(String)dispensing_det.get(22);//Code Added For Bru-HIMS-CRF-405[IN 044830]
			}
	
			fract_dose_round_up_yn						=	getCheckValue(fract_dose_round_up_yn);
			fract_dose_appl_yn						    =	getCheckValue(fract_dose_appl_yn);
			disp_multi_strength_yn						=	getCheckValue(disp_multi_strength_yn);
			disp_auth_reqd_yn							=	getCheckValue(disp_auth_reqd_yn);
			disp_via_pres_only_yn						=	getCheckValue(disp_via_pres_only_yn	);
			disp_against_damage_yn						=	getCheckValue(disp_against_damage_yn);
			disp_alt_form_yn							=	getCheckValue(disp_alt_form_yn);
			print_label_based_on_qty_yn                 =   getCheckValue(print_label_based_on_qty_yn);   //Code Added For RUT-CRF-0067 End
			fract_dose_round_up_yn_chk					=	getCheckStatus(fract_dose_round_up_yn);
			fract_dose_appl_yn_chk					    =	getCheckStatus(fract_dose_appl_yn);
			//disp_multi_strength_yn_chk					=	getCheckStatus(disp_multi_strength_yn); COMMENTED FOR GHL-CRF-0548
			disp_auth_reqd_yn_chk						=	getCheckStatus(disp_auth_reqd_yn);
			disp_via_pres_only_yn_chk					=	getCheckStatus(disp_via_pres_only_yn	);
			disp_against_damage_yn_chk					=	getCheckStatus(disp_against_damage_yn);
			disp_alt_form_yn_chk						=	getCheckStatus(disp_alt_form_yn	);
			virification_required_yn_chk				=	getCheckStatus(virification_required_yn	);
			print_label_based_on_qty_yn_chk				=	getCheckStatus(print_label_based_on_qty_yn);  //Code Added For RUT-CRF-0067 Start
			if (!disp_alt_form_yn.equals("Y"))
				disableString = "";

			virification_required_yn					=	getCheckValue(virification_required_yn);
			allow_morethan_pres_qty_yn_chk	=	getCheckStatus(allow_morethan_pres_qty_yn);
			allow_morethan_pres_qty_yn			=	getCheckValue(allow_morethan_pres_qty_yn);

			//added for  Bru-HIMS-CRF-070 [IN029935] - start
			ArrayList	characteristics	=	bean.getCharacteristics();
			String npbDrugYN = (String)characteristics.get(27);
			if(npbDrugYN!=null && npbDrugYN.equals("Y")){
				disp_alt_form_yn = "N";
				disp_alt_form_yn_chk="";
				//disp_multi_strength_yn = "N";//commented for ghl-crf-0548
				//disp_multi_strength_yn_chk ="";//commented for ghl-crf-0548
				 display_multi="disabled";//added for ghl-crf-0548
				disableString = "disabled";
				npbdisable = "disabled";
			}
			//added for  Bru-HIMS-CRF-070 [IN029935] - end
%>
			<script>parent.adjustFrames('<%=link%>')</script>
			<script>parent.updateCurrentForm("dispensingdet_tab","f_tab_detail.f_detail.document.drugMasterAddModifyForm","parent.frames[0].document.drugMasterMainForm");</script>
			<br>
<%
//	if (!licenceRights.equals("PHBASIC")){
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th align="left" colspan="4"> <fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></th>
				<tr>
					
					<td align="left" class="label" ><fmt:message key="ePH.FractionalDoseApplicable.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" id="FractionalDoseApplicable1" name="FractionalDoseApplicable" id="FractionalDoseApplicable" onclick="parent.assignValue(this,fract_dose_round_up_yn);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');checkdefaultDosageBy(this,'<%=calc_dosg_by_freq_durn_yn%>','<%=strength_value%>');" value="<%=fract_dose_appl_yn%>" <%=fract_dose_appl_yn_chk%> ></td>

					<td align="left" class="label"><fmt:message key="ePH.FractionalDoseRoundUp.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn" value="<%=fract_dose_round_up_yn%>" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" <%=fract_dose_round_up_yn_chk%>></td>
				</tr>
				<!--- below code added for SKR-CRF-PHIS-003[IN028182] start  -->
				 
				<tr>
				<td align="left" class="label" > <fmt:message key="ePH.DefaultdoseNormalRX.label" bundle="${ph_labels}"/>   </td>
				<td align="right" class="label"> <select name="default_dosage_by" id="default_dosage_by"  style="width:100" onChange="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" >
				</select>				
				</td>
				</tr>
				    
				<!--- SKR-CRF-PHIS-003[IN028182] End  -->
				<tr>

					<td align="left" class="label" ><fmt:message key="ePH.DispenseByAlternateForm.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="disp_by_alt_form_yn" id="disp_by_alt_form_yn" onclick="parent.assignValue(this);parent.checkMultiStrength(this,document.drugMasterAddModifyForm);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" value="<%=disp_alt_form_yn%>" <%=disp_alt_form_yn_chk%> <%=npbdisable%>></td>
					<!-- commented for GHL-CRF-0548 START -->
					<%-- <td align="right" class="label" ><fmt:message key="ePH.DispenseByMultiStrength.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="disp_multi_strength_yn" id="disp_multi_strength_yn" onclick="parent.assignValue(this);" value="<%=disp_multi_strength_yn%>" <%=disp_multi_strength_yn_chk%> <%=disableString%>></td>
 --%>
 <!-- commented for GHL-CRF-0548 END -->
       <td align="left" class="label"><fmt:message key="ePH.DispenseBy.label" bundle="${ph_labels}"/></td>
            <td  align="left">&nbsp;
      <%System.out.println("default_strength_value"+default_strength_value);
               
      if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				 if(default_strength_value.equals("") || default_strength_value.equals("0")){%>
				 <select name="disp_multi_strength_yn" id="disp_multi_strength_yn" DISABLED >
					
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					
           </select>
				<%}
            else if(disp_mlti_frm_parm_set_up.equals("S") && !default_strength_value.equals("") && !default_strength_value.equals("0") ){
            	 %>
            	 <select name="disp_multi_strength_yn" id="disp_multi_strength_yn" DISABLED >
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					
           </select>
           <% } 
            else{%>
            	 <select name="disp_multi_strength_yn" id="disp_multi_strength_yn" DISABLED >
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
            	
           
           <%  }}else{
        	   if(disp_alt_form_yn !=null && disp_alt_form_yn.equals("Y"))
        	   if(disp_multi_strength_yn !=null &&( disp_multi_strength_yn.equals("Y") ||disp_multi_strength_yn.equals("M") || disp_multi_strength_yn.equals("N")) && (!default_strength_value.equals("") && !default_strength_value.equals("0"))){
        		   display_multi="enabled";
        		   %>
           
           <select name="disp_multi_strength_yn" id="disp_multi_strength_yn" <%=display_multi%>  >
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
           
           <%}else{
           if(default_strength_value.equals("") || default_strength_value.equals("0") ){
           %>
           
           <select name="disp_multi_strength_yn" id="disp_multi_strength_yn"  <%=display_multi%>>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<%-- <option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option> --%>
           </select>
           <%}else{ %>
        	    <select name="disp_multi_strength_yn" id="disp_multi_strength_yn" <%=display_multi%>  >
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					
			
           </select>
          <% }} else{
        	  display_multi="disabled";
        	  if(default_strength_value.equals("") || default_strength_value.equals("0") ){
           %>
           <select name="disp_multi_strength_yn" id="disp_multi_strength_yn"  <%=display_multi%>>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<%-- <option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option> --%>
           </select>
            <%}else{ %>
        	 <select name="disp_multi_strength_yn" id="disp_multi_strength_yn"  <%=display_multi%>>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
         <% }}} %>
            </td>
            <!-- ADDED for GHL-CRF-0548 END  -->
				</tr>
				<tr>
					<td align="left" class="label" ><fmt:message key="ePH.PRNDosesForPrescribedPeriodFillQty.label" bundle="${ph_labels}"/></td>
					<td align="left" >&nbsp;&nbsp;<input type="text" name="prn_doses_pres_prd_fill" id="prn_doses_pres_prd_fill" value="<%=prn_doses_pres_prd_fill%>" size="3" <%=dis_prescribed%> onKeyPress="return(ChkNumberInput(this,event,0));" style="text-align:right" maxlength="3" onfocus="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" onchange="parent.updatePrescribedPeriodinMain(this);" >&nbsp;
					</td>
					<td align="left" class="label"><fmt:message key="ePH.ForContinuousFill.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label">&nbsp;<input type="text" name="prn_doses_cont_daily_fill" id="prn_doses_cont_daily_fill" value="<%=prn_doses_cont_daily_fill%>" size="3" <%=dis_continuous%> onfocus="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')"  onchange="parent.updateContinuousFillinMain(this);" onKeyPress="return(ChkNumberInput(this,event,0));" style="text-align:right" maxlength="3">&nbsp;<fmt:message key="ePH.Perday.label" bundle="${ph_labels}"/>&nbsp;
					</td>
				</tr>
				<th align="left" colspan="4"><fmt:message key="ePH.DispensingControls.label" bundle="${ph_labels}"/></th>
				<tr>
					<td align="left" class="label"><fmt:message key="ePH.AuthorizeonDispensing.label" bundle="${ph_labels}"/></td>
					<td align="left" >&nbsp;<input type="checkbox" name="disp_auth_reqd_yn" id="disp_auth_reqd_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" value="<%=disp_auth_reqd_yn	%>" <%=disp_auth_reqd_yn_chk%>></td>
					<td align="left" class="label" ><fmt:message key="ePH.DispenseViaPrescriptionOnly.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="disp_via_pres_only_yn" id="disp_via_pres_only_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" value="<%=disp_via_pres_only_yn%>" <%=disp_via_pres_only_yn_chk%>></td>
				</tr>
				<tr>
					<td align="left" class="label" ><fmt:message key="ePH.ReissueApplicable.label" bundle="${ph_labels}"/></td>
					<td align="left" >&nbsp;<input type="checkbox" name="disp_against_damage_yn" id="disp_against_damage_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');displayreissuetype(this)"  <%=disp_against_damage_yn_chk%> value="<%=disp_against_damage_yn%>" <%=disp_against_damage_yn%>></td>
					<!--Added for Bru-HIMS-CRF-405[IN 044830]-Start -->
					<td align="left" class="label" id="lblReIssue" style='display:inline;'><fmt:message key="ePH.ReissueType.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label" id="fldReIssue" width='10%' style='display:inline;'><select name="reissue_type_ind" id="reissue_type_ind" onchange="parent.updateReIssueType();setselectedreissue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');">
					</select>
					</td>
					<td align="left" class="label" id="fldReIssue_count" width='10%' style='display:inline;'><select name="reissue_count_by_ind" id="reissue_count_by_ind" onchange="assignselectedType();parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');"></select></td>
					<td align="left" class="label" id="fldReIssue_count_text" width='4%' style='display:inline;'>
					<input type="text" name="reissue_count" id="reissue_count" size="3" maxlength="3" onfocus="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" onchange="parent.updateReIssueCount(this);assignselectedType();" onblur="validatereissueCount(this);" onKeyPress="return allowValidNumber(this,event,3,0);" oncopy="return false" onpaste="return false" value="<%=reissue_count%>" <%=reissue_count%>><img src="../../eCommon/images/mandatory.gif" align="center" style="visibility:visible" id="reissue_count_img"><td align="left" class="label" id="fldReIssue_desc_q" style='display:none;'><fmt:message key="ePH.NoofQty.label" bundle="${ph_labels}"/></td><td class="label" id="fldReIssue_desc_t" style='display:none;'><fmt:message key="ePH.Times.label" bundle="${ph_labels}"/></td>
					</td>
				</tr>	
				<tr><!--Added for Bru-HIMS-CRF-405[IN 044830]-End-->
					<td align="left" class="label" ><fmt:message key="ePH.AllowMoreThanPrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;<input type="checkbox" name="allow_morethan_pres_qty_yn" id="allow_morethan_pres_qty_yn"  onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" value="<%=allow_morethan_pres_qty_yn%>" <%=allow_morethan_pres_qty_yn_chk%>></td>			

					<td align="left" class="label" style="display:none"> <fmt:message key="ePH.VerificationRequired.label" bundle="${ph_labels}"/></td><td></td>
					<td align="left" >&nbsp;<input type="checkbox" name="virification_required_yn" id="virification_required_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')"  <%=virification_required_yn_chk%>  style="display:none"value="Y" checked></td>
				</tr>
				<!-- Code Added For RUT-CRF-0067 Start -->
				<tr>
				   <td align="left" class="label" ><fmt:message key="ePH.PrintNumberOfLabel.label" bundle="${ph_labels}"/></td>
					<td align="left" >&nbsp;<input type="checkbox" name="print_label_based_on_qty_yn" id="print_label_based_on_qty_yn"  onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" value="<%=print_label_based_on_qty_yn%>" <%=print_label_based_on_qty_yn_chk%>></td>
				</tr>
				<!-- Code Added For RUT-CRF-0067 Endss -->
			</table>
<%
	//}
%>
			<script>parent.validateCalculateByFreqDurn();</script>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th align="left" colspan="2"><fmt:message key="ePH.Labels.label" bundle="${ph_labels}"/></th>
				<tr>
				<td width="40%" align="center" class="Data">&nbsp;</td>
				<td width="60%" align="left" class="Data">&nbsp;</td>
				</tr> 
				<tr>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				</tr> 
				</table>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="ePH.Caution.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label">				
						<select name="caution_label_test_id_1" id="caution_label_test_id_1" onchange="parent.loadCmb(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" width="500" style="width: 500px"> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
							<option>-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
					          for(int i=0;i<caution.size();i++){
								HashMap data = new HashMap();
								data = (HashMap)caution.get(i);
								
								if((data.get("label_text_id")).equals(caution_label_test_id_1) )	{
									caution_loc_lang=(String)data.get("label_text_1_loc_lang")==null?"":(String)data.get("label_text_1_loc_lang");
%>

									<option value="<%=data.get("label_text_id")%>" selected><%=data.get("label_text_1")%></option>
<%
								}
								else{
%>
									<option value="<%=data.get("label_text_id")%>"><%=data.get("label_text_1")%></option>
<%
								}
							}
%>
							</select>&nbsp;&nbsp;<label style="font-size:9" id="caution_loc"><%=caution_loc_lang%></label></td>
						</tr>
						<tr>
							<td class="label" align="left" nowrap><fmt:message key="ePH.SpecialInstruction.label" bundle="${ph_labels}"/></td>
							<td align="left" class="label">
								<select name="spl_instr_label_text_id" id="spl_instr_label_text_id" onchange="parent.loadCmbSplInstr(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" width="500" style="width: 500px"> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
									<option>-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
									for(int i=0;i<spl_instruction.size();i++){
									HashMap data = new HashMap();
									data = (HashMap)spl_instruction.get(i);

									if( (data.get("label_text_id")).equals(spl_instr_label_text_id) )	{
										spl_instrn_loc_lang=(String)data.get("label_text_1_loc_lang")==null?"":(String)data.get("label_text_1_loc_lang");
%>
										<option value="<%=data.get("label_text_id")%>" selected><%=data.get("label_text_1")%></option>
<%
									}
									else{
%>
										<option value="<%=data.get("label_text_id")%>"><%=data.get("label_text_1")%></option>
<%
									}

								}
%>
								</select>&nbsp;&nbsp;<label id="spl_loc"><%=spl_instrn_loc_lang%></label>
							</td>
						</tr>
						<tr>
							<td align="left" class="label"  nowrap><fmt:message key="ePH.DirectionToPatient.label" bundle="${ph_labels}"/></td>
							<td align="left" class="label" >
								<textarea name="how_to_take_text" value="" size="150" maxlength="150"  rows='3' cols='50'  onKeyPress="return checkMaxLimit(this,150);" onblur="parent.validmaxlength1(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')"><%=how_to_take_text%></textarea>
								<!-- <input type="text" maxlength='60' size='45' name="how_to_take_text" id="how_to_take_text" value="<%=how_to_take_text%>"> -->
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" maxlength='60' size='50' name="how_to_take_text_local" id="how_to_take_text_local" value="" style="visibility:hidden">
								<!--<input type="text" maxlength='60' size='50' name="how_to_take_text_local" id="how_to_take_text_local" value="<%=how_to_take_text_local%>" style="visibility:hidden">-->
							</td>
						</tr>
						<tr><!----Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start ------->
							<td align="left" class="label"  nowrap><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
							<td align="left" class="label" >								
								<textarea name="drug_ind" value="" size="150" maxlength="150"  rows='3' cols='50'  onKeyPress="return checkMaxLimit(this,150);" onblur="parent.validmaxlength1(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')"><%=drug_indication%></textarea>
							</td>
						</tr>	<!----Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] End ------->
					</table>
					<script>
						parent.checkStrengthValue(document.drugMasterAddModifyForm);
						checkdefaultDosageBy('<%=fract_dose_appl_yn%>','<%=calc_dosg_by_freq_durn_yn%>','<%=strength_value%>','<%=default_dosage_by%>');//This function added For SKR-CRF-PHIS-003[IN028182]
						setDefaultReIssueOptions('<%=reissue_type_ind%>','<%=reissue_count_by_ind%>');//Added for Bru-HIMS-CRF-405[IN 044830]
					</script>
<%
				}
				else  if(link.equals("ivchar_tab")){

					iv_char		 =	bean.getIVChar();
					if(iv_char.size()!= 0)	{
						iv_ingredient_yn				=	(String)iv_char.get(0);
						iv_fluid_yn						=	(String)iv_char.get(1);
						infuse_over_value				=	(String)iv_char.get(2);
					//	infuse_over_durn_type			=	(String)iv_char.get(3);
						physical_form					=	(String)iv_char.get(4);
						cyto_toxic_yn					=	(String)iv_char.get(5);
						dflt_drug_code					=   (String)iv_char.get(6);
						appl_piggy_back_yn				=   (String)iv_char.get(7);
						appl_recn_fld_yn				=   (String)iv_char.get(8);
					}
	
					if(infuse_over_value.equals(""))
						infuse_over_value			=	"";

					iv_ingredient_yn_chk			=	getCheckStatus(iv_ingredient_yn	);
					iv_fluid_yn_chk					=	getCheckStatus(iv_fluid_yn);
					cyto_toxic_yn_chk				=	getCheckStatus(cyto_toxic_yn);
					iv_ingredient_yn				=	getCheckValue(iv_ingredient_yn	);
					iv_fluid_yn						=	getCheckValue(iv_fluid_yn);
					cyto_toxic_yn					=	getCheckValue(cyto_toxic_yn);
					appl_piggy_back_yn_chk			=	getCheckStatus(appl_piggy_back_yn);	
					appl_piggy_back_yn				=	getCheckStatus(appl_piggy_back_yn);	
					appl_recn_fld_yn_chk			=	getCheckStatus(appl_recn_fld_yn);	
					appl_recn_fld_yn				=	getCheckValue(appl_recn_fld_yn);	
%>
					<br>
<%
					ArrayList dflt_fluids = new ArrayList();
					dflt_fluids = bean.loadFluids();
					//String drug_code_dflt=" ";
					//String drug_desc_dflt=" ";
%>
					<script>parent.updateCurrentForm("ivchar_tab","f_tab_detail.f_detail.document.drugMasterAddModifyForm","parent.drugMasterMain.document.drugMasterMainForm");</script>
					<script>parent.adjustFrames('<%=link%>')</script>
					
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0"  >
						<tr><th colspan="4" align="left"><fmt:message key="ePH.IVCharacteristics.label" bundle="${ph_labels}"/></th></tr>
							<tr><td colspan="4">&nbsp;&nbsp;</td></tr>
							<tr>
								<td align="left" class="label"><fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/> ?</td>
								<td align="left" >&nbsp;<input type="checkbox" name="iv_ingredient_yn" id="iv_ingredient_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');parent.validateForPhysicalForm();parent.dfDisplay();parent.dflroutedisplay('<%=bean.getDefaultRouteCode()%>')" value="<%=iv_ingredient_yn%>" <%=iv_ingredient_yn_chk%>></td>
								<td  align="left" class="label"  >
								<div id="dflt_td" style="visibility:hidden">
								&nbsp;&nbsp;
									<input type="button" class="button" name="comp_fluids" id="comp_fluids" value='<fmt:message key="ePH.CompatibleFluids.label" bundle="${ph_labels}"/>' onclick="parent.compFluids(dflt_fluid,'<%=drug_code%>');updateFormModify('parent.parent.drugMasterMain.document.drugMasterMainForm')">
									</div>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>				
							</tr>
							<tr>
								<td align="left" class="label"><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/> ?</td>
								<td align="left">&nbsp;<input type="checkbox" name="iv_fluid_yn" id="iv_fluid_yn" onclick="if(fluidCompCheck(this,'<%=drug_code%>')){parent.assignValue(this);parent.validateForPhysicalForm();	parent.validateInfuseOver(document.drugMasterAddModifyForm);	parent.updateFormModify('parent.frames[0].document.drugMasterMainForm'); parent.dfDisplay();}"  value="<%=iv_fluid_yn%>" <%=iv_fluid_yn_chk%>></td>
								<td colspan="2">&nbsp;&nbsp;</td>
							</tr>
							<tr  height="10"> <td colspan="4">&nbsp;&nbsp;</td></tr>
							<tr>
								<td align="left" class="label"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></td>
								<td align="left" class="label" ><input type="text" size="3" name="infuse_over_value_hrs" id="infuse_over_value_hrs" value="<%=infuse_over_value_hrs%>"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckForSpecCharsonBlur(this); validateNum(document.drugMasterAddModifyForm,drugMasterAddModifyForm.infuse_over_value_mins,this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" style="text-align:right" maxlength="6">&nbsp;:
<!-- ================================================================================================ -->
				<!--==== Code added for addind textbox to enter infuse_over_minutes value ====== -->
								<input type="text" size="3" name="infuse_over_value_mins" id="infuse_over_value_mins" value="<%=infuse_over_value_mins%>"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckForSpecCharsonBlur(this); validateNum(document.drugMasterAddModifyForm,this,document.drugMasterAddModifyForm.infuse_over_value_hrs); parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')" style="text-align:right" maxlength="6">&nbsp;
								<input type="hidden" name="infuse_over_value" id="infuse_over_value" value="<%=infuse_over_value%>">

								<script> 
								
								getHrsMinStr(document.drugMasterAddModifyForm,document.drugMasterAddModifyForm.infuse_over_value.value);
								validateNum(document.drugMasterAddModifyForm,drugMasterAddModifyForm.infuse_over_value_mins,document.drugMasterAddModifyForm.infuse_over_value_hrs);
								</script>
<!-- ================================================================================================ -->
						<!--======= Commented for removing the selection of hours and minutes======-->

						<!--			<select name="infuse_over_durn_type" id="infuse_over_durn_type" onchange="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')">
										<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
							//			if(infuse_over_durn_type.equals("M")) {	
%>
											<option value="M" selected><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
											<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
<%	
						//				}
							//			else if(infuse_over_durn_type.equals("H"))	{	
%>
											<option value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
											<option value="H" selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
<%
								//		}
									//	else	{	
%>
											<option value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
											<option value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
<%
									//	}	
%> -->
									<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
									<img src="../../eCommon/images/mandatory.gif" align="center" style="visibility:hidden" id="infuse_img"></td>
								<td colspan="2">&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td align="left" class="label"><fmt:message key="ePH.PhysicalForm.label" bundle="${ph_labels}"/> ?</td>
								<td align="left">&nbsp;
<%
									String physical_form_liquid = "";
									String physical_form_powder = "";
									String physical_form_liquid_n = "";
									if(physical_form.equals("L")){
										physical_form_liquid="selected";
										physical_form_powder="";
									}
									else if(physical_form.equals("P")){
										physical_form_liquid="";
										physical_form_powder="selected";
									}
									else{
										physical_form_liquid_n="selected";
										physical_form_powder="";
										physical_form_liquid="";
									}
%>
					
									<select name="physical_form" id="physical_form"  onchange="parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');parent.applrecfldDisplay();">>
										<option value="S" <%=physical_form_liquid_n%>>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
										<option value="L" <%=physical_form_liquid%>><fmt:message key="ePH.Liquid.label" bundle="${ph_labels}"/></option>
										<option value="P" <%=physical_form_powder%>><fmt:message key="ePH.Powder.label" bundle="${ph_labels}"/></option>
									</select>
								</td>
								<td align="left" class="label" >
									<div id="applrecfld" style="visibility:hidden">
										<fmt:message key="ePH.ApplicabletoReconsitutuentFluid.label" bundle="${ph_labels}"/>
										<input type="checkbox" name="appl_recn_fld_yn" id="appl_recn_fld_yn" onclick="parent.assignValue(this);" value="<%=appl_recn_fld_yn%>" <%=appl_recn_fld_yn_chk%>>
									</div>
									&nbsp;&nbsp;
								</td>
							</tr>	
							<tr>
								<td align="left" class="label" nowrap><fmt:message key="ePH.UseforOncologyDrugPreparation.label" bundle="${ph_labels}"/></td>
								<td align="left">&nbsp;<input type="checkbox" name="cyto_toxic_yn" id="cyto_toxic_yn" disabled onclick="parent.assignValue(this);	parent.updateFormModify('parent.frames[0].document.drugMasterMainForm')"  value="<%=cyto_toxic_yn%>" <%=cyto_toxic_yn_chk%>></td>
								<td colspan="2">&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td class="label" align="right" >
								<div id="appl_piggyback" style="visibility:visible"><fmt:message key="ePH.ApplicabletoPiggyback.label" bundle="${ph_labels}"/> </div> 	
								</td>
								<td align="left">
								<div id="appl_piggyback1" style="visibility:visible">
								&nbsp;<input type="checkbox" name="appl_piggy_back_yn" id="appl_piggy_back_yn" onclick="parent.assignValue(this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');"value="<%=appl_piggy_back_yn%>" <%=appl_piggy_back_yn_chk %>> 
								</div></td>
								<td colspan="4">&nbsp;&nbsp;</td>
							</tr>
			
						</table>
						<script> parent.dflroutedisplay('<%=bean.getDefaultRouteCode()%>');</script> <script>parent.dfDisplay();</script>
					<script>parent.validateInfuseOver(document.drugMasterAddModifyForm);</script>
<%
					}	
					else if(link.equals("external_tab")){
%>
					<script>
						parent.updateCurrentForm("external_tab","f_tab_detail.document.drugMasterAddModifyForm","drugMasterMain.document.drugMasterMainForm");
					</script>
<%
					//Mahesh
					external_db		 =	bean.getExternalDB();
					String external_db_legend = "";
					String ext_prod_drug_code="";
					String eff_status_value="";
					String eff_status="";
					//String ext_prod_drug_code1="";
					//String eff_status1_value="";
					//String eff_status1="";
					String product_id1="";
					String product_id2="";
					String db_action1="";
					String db_action2="";
					String read_only="";
					ArrayList drug_data = new ArrayList();
					//String read_only1="";
					if(external_db.size()!= 0){
							product_id1=(String)external_db.get(0);
							ext_prod_drug_code=(String)external_db.get(1);
						//	if(ext_prod_drug_code.equals(""))
						//		read_only="";
						//	else
						//		read_only="readonly";

							eff_status_value=((String)external_db.get(2));
							eff_status=(eff_status_value.equals("E")?"checked":"");
							 if(eff_status_value.equals("E"))
								 read_only="";
							 else
								 read_only="readonly";
							db_action1=(String)external_db.get(3);

							 external_db_legend =(String)external_db.get(4); // IN18771 -- 02/02/2010 -- Shyampriya--
						}
					else{
					//	ArrayList drug_data = new ArrayList();
						drug_data=bean.getDrugDatabase(drug_code);

						if(drug_data.size()>0){
							product_id1=(String)drug_data.get(0);
							ext_prod_drug_code=(String)drug_data.get(1)==null?"":(String)drug_data.get(1);
						//	 if(ext_prod_drug_code.equals(""))
							//	 read_only="";
						//	 else
							//	 read_only="readonly"; 
							 
							 eff_status_value=((String)drug_data.get(2));
							 eff_status=(eff_status_value.equals("E")?"checked":"");
							 if(eff_status_value.equals("E"))
								 read_only="";
							 else
								 if(ext_prod_drug_code.trim().length()!=0 || !ext_prod_drug_code.trim().equals(""))
								 read_only="readonly";
							 db_action1=(String)drug_data.get(3);

								 external_db_legend =(String)drug_data.get(4); // IN18771 -- 02/02/2010 -- Shyampriya--
						}
					}
%>
					<br><br><br>
					<table cellpadding="0" cellspacing="0" width="70%" align="center" border="1">
						<tr>
<%
			//	out.println("drug_data>>>>>"+drug_data);
	%>
							<th><fmt:message key="ePH.DrugDatabase.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.ExternalDrugCode.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
						</tr>

						<tr>
							<td class="label"><%=external_db_legend%></td>
							<td><input type="text" size="40" name="FDB_Text" id="FDB_Text"  onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onBlur="parent.assignValue1(eff_status,this)" value="<%=ext_prod_drug_code.trim()%>"  <%=read_only%> ></td>
							<td><input type="checkbox" name="eff_status" id="eff_status"  <%=eff_status%> value="<%=eff_status_value%>" onclick="parent.assignValue1(this,FDB_Text);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');"></td>
						</tr>
						<input type=hidden name="db_action1" id="db_action1" value="<%=db_action1%>">
						<input type=hidden name="db_action2" id="db_action2" value="<%=db_action2%>">
						<input type=hidden name="product_id1" id="product_id1" value="<%=product_id1%>">
						<input type=hidden name="product_id2" id="product_id2" value="<%=product_id2%>">
						<input type=hidden name="external_db_legend" id="external_db_legend" value="<%=external_db_legend%>">
<%
	//	out.println("db_action1>>"+db_action1+"==db_action2>>"+db_action2+"==product_id1>>"+product_id1+"==product_id2>>"+product_id2);
%>
					</table>

<%	
				}

				if(link.equals("weightrecording_tab")){
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
						flag = "I";
					}	
					//	int maxDispNo	=	bean.getMaxDispNo(link);
%>
					<script>parent.updateCurrentForm("weightrecording_tab","f_tab_detail.f_detail.document.drugMasterAddModifyDetailForm","parent.drugMasterMain.document.drugMasterMainForm");</script>		
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
						<tr>
							<th align="left" colspan="5"><fmt:message key="ePH.AddModifyAgeGroups.label" bundle="${ph_labels}"/></th>
						</tr>
						<tr>
							<td  class="label" width='12%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>



							<td  width='12%'>	<select name="agegroup_id" id="agegroup_id" onchange="parent.loadagegroup(agegroup_id)" >

							<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%			
							String age_group1="";
							String AGE_GROUP_CODE1="";
							for(int i=0;i<age_group.size();i++){
								HashMap data = new HashMap();
							
								data = (HashMap)age_group.get(i);
								
								if( (data.get("age_group_code")).equals(AGE_GROUP_CODE1) )	{
									age_group1=(String)data.get("short_desc")==null?"":(String)data.get("short_desc");
%>
									<option value="<%=data.get("age_group_code")%>" selected><%=data.get("short_desc")%></option> 
<%
								}
								else{
%>
								<option value="<%=data.get("age_group_code")%>"><%=data.get("short_desc")%></option> 
<%
								}
							}
%>
							</select>
							</td>
							<td  class="label" width='12%'>
							<td  class="label" width='12%'>
						</tr>
						<tr>
							<td  class="label" width='12%'>	&nbsp;<fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;:&nbsp;	<label id='gender1'></label> </td>
							<td  class="label" width='12%'><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>&nbsp;:&nbsp;	<label id='MinAge'> </label></td>
							<td  class="label" width='12%'>	<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>&nbsp;:&nbsp;		<label id='MaxAge'></label> </td>
							<td  class="label" width='12%'>	<fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/>	&nbsp;:&nbsp;<label id='AgeUnit'> </label>
							</td>
							<input type="hidden" name="curr_row" id="curr_row" value="">
							<input type="hidden" name="age_group_code" id="age_group_code" value="">
							<input type="hidden" name="short_desc" id="short_desc" value="">
							<input type="hidden" name="min_age" id="min_age" value="">
							<input type="hidden" name="max_age" id="max_age" value="">
							<input type="hidden" name="age_unit" id="age_unit" value="">
							<input type="hidden" name="gender" id="gender" value="">
							<input type="hidden" name="flag" id="flag" value="<%=flag%>">
					
							<input type="hidden" name="disp_seq_no" id="disp_seq_no" maxlength="2" size="2" value="" class="NUMBER">
						</tr>
						<tr>
							<td  class="label" width='12%'>
							
							<td align="right" colspan="2"><input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class="button" name="del_butt" style="visibility:hidden" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);">
							<td align="right" colspan="2"><input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(document.drugMasterAddModifyForm,this);parent.updateFormModify('parent.frames[0].document.drugMasterMainForm');" name="add_butt"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="parent.callReset1()" name="reset_butt"></td>
						</tr>
					</table>
<%				}
				if(link.equals("sliding_scale_tab")){
					ArrayList tmpl_values_2 = new ArrayList();				
					tmpl_values_2	=	(ArrayList) bean.getSlidingScaleChkdValues();
					
					String sld_checked="";
					String sld_disabled="";
				
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						flag = "I";
					}
%>
					<script>
						parent.updateCurrentForm("sliding_scale_tab","f_tab_detail.document.drugMasterAddModifyForm","drugMasterMain.document.drugMasterMainForm");
					</script>
					
					<br><br><br>
					<table cellpadding="0" cellspacing="0" width="60%" align="center" border="1">
						<tr>
							<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
							<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
							<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
						</tr>
<%
						for(int i=0; i<tmpl_values.size();i=i+3){
							if(tmpl_values_2.size()!=0)
								for(int k=0;k<tmpl_values_2.size();k++){
									
									if(tmpl_values_2.get(k).equals(tmpl_values.get(i))){
										sld_checked="checked";
										break;
									}
									else
										sld_checked="";
								}
%>
								<tr>
								<td width="25%" class="label" align="left" ><%=tmpl_values.get(i++)%></td>
								<td width="60%" class="label" align="left"><%=tmpl_values.get(i++)%></td>
<%
								if(tmpl_values.get(i).equals("D")){
									sld_disabled="disabled";
									sld_checked="";
								}
								else if(tmpl_values.get(i).equals("E")){
									sld_disabled="";
								}
								i=i-2;	
%>							
								<td align="center"><input type="checkbox" name="sld_<%=i%>" id="sld_<%=i%>" value="<%=tmpl_values.get(i)%>"  onClick="parent.updateSlidingScale1(document.drugMasterAddModifyForm,this); parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" <%=sld_checked%> <%=sld_disabled%> ></td>
							</tr>
<%
						}	
					}
				}
				catch(Exception e){
					out.println(e);
				}
%>
			<input type="hidden" name="link" id="link" value="<%=link%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="sql_ph_drug_select14" id="sql_ph_drug_select14" value="<%=sql_ph_drug_select14%>">
			<input type="hidden" name="dflt_fluid" id="dflt_fluid" value="<%=dflt_drug_code%>">
			<input type="hidden" name="eff_stat" id="eff_stat" value="">
		</form>

	 <script>
<% 
			if (!link.equals("external_tab") && !link.equals("sliding_scale_tab"))  {
%>
				parent.updateLink('<%=link%>');
<%	
				if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) && link.equals("prescribingdet_tab") )	{
%>
					parent.assignStockRefValue(document.drugMasterAddModifyForm.stock_uom);
					parent.assignPresRefValue(document.drugMasterAddModifyForm.pres_base_uom);
					parent.assignPerVolQty(document.drugMasterAddModifyForm.pres_base_uom);
					parent.assignPerVolQty(document.drugMasterAddModifyForm.strength_uom);
<%
				}
				else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) && link.equals("dispensingdet_tab") )	{ 
%>
					parent.updatePrescribedPeriodinMain(document.drugMasterAddModifyForm.prn_doses_pres_prd_fill);
					parent.updateContinuousFillinMain(document.drugMasterAddModifyForm.prn_doses_cont_daily_fill);
					parent.updateReIssueCount(document.drugMasterAddModifyForm.reissue_count);//Added for Bru-HIMS-CRF-405[IN 044830]
					parent.updateReIssueType();//Added for Bru-HIMS-CRF-405[IN 044830]
<%
				}
				else if (link.equals("prescribingdet_tab")) {	
					if(stock_uom.equals("")){
%>
						parent.loadStockUnit(document.drugMasterAddModifyForm.pres_base_uom);
<%
					}
%>
					parent.checkBaseUnit(document.drugMasterAddModifyForm);
					parent.assignPresRefValue(document.drugMasterAddModifyForm.pres_base_uom);
					parent.assignPerVolQty(document.drugMasterAddModifyForm.pres_base_uom);
					parent.updateFormModify(parent.parent.frames[0].document.drugMasterMainForm);

<%
				}	
			}
%>
		</script>

	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

