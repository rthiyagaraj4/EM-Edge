<!DOCTYPE html>
<%@ page import=" eST.SalesReturnBean,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body  onLoad="FocusFirstElement()">
<form name="formSalesReturnHeader" id="formSalesReturnHeader">
<%
	java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
	String bean_id				=		"salesReturnBean"+login_at_ws_no;
	String bean_name			=		"eST.SalesReturnBean";

    eST.SalesReturnBean bean			=		(eST.SalesReturnBean)getBeanObject( bean_id, bean_name,request );
	eST.SalesBean bean_sales			=		(eST.SalesBean)getBeanObject( "salesBean", "eST.SalesBean",request  );
	//Added for GHL-CRF-0413.5 starts
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	boolean direct_sale_patient_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","DIR_SALE_PAT_BASE");//TBMC-SCF-0014
	bean.setSite_spec_yn(site_main);
	//Added for GHL-CRF-0413.5 ends
	bean.setLanguageId(locale);
	bean_sales.setLanguageId(locale);
	String mode							=		request.getParameter("mode");
	String trn_type						=		"SRT";
	String item_class_based				=		bean.getSALItemClassBased(trn_type);
	String sql_id						=		"SQL_ST_SALES_RET_STORE_SELECT";
	String codeDisabled					=		"";
	String encounter_id_visibility		=		"hidden";
	String patient_name_visibility		=		"hidden";
    String preview_disabled				=		"disabled";
	String chargeable_yn				=		"";
	String chk_chargeable_yn			=		"";
	String chargeable_yn_value			=		"N";
	String discharge_yn					=		"";
	String chk_discharge_yn				=		"";
	String outpatient_yn				=		"";
    String Inpatient_yn					=		"";
    String referral_yn					=		"";
	String NU_Clinic					=		"";
	String patient_class				=		"";
	String room_no						=		"";
	String bed_no						=		"";
	String bl_install_yn				=		bean_sales.getBLModuleInstalled();
	String NU_Clinic_code				=	    "";
	//String SalesDocTypeCode             =       "";
	//String SalesDocNo                   =       "";

	String siteId = bean_sales.getCustomerID();

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	{
		codeDisabled					=		"disabled";
		preview_disabled			 	=		"";
		//SalesDocTypeCode                =      bean.checkForNull(bean.getSalesDocTypeCode());
	    //SalesDocNo						=      bean.checkForNull(bean.getSalesDocNo());
	} 

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		if(bl_install_yn.equals("Y")){
			 chargeable_yn					=		"disabled";
			 chk_chargeable_yn				=		"checked";
			 chargeable_yn_value			=		"Y";
		}else{
			chargeable_yn					=		"disabled";
			chargeable_yn_value				=		"N";
		}
	}

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		chargeable_yn					=		"disabled";

		if(bl_install_yn.equals("Y")){
			chk_chargeable_yn			=		"checked";
			chargeable_yn_value			=		"Y";
		}

		discharge_yn					=		"disabled";

		if(bean_sales.getTake_home_yn().equals("Y")){
			chk_discharge_yn			=		"checked";
			
		}
}
int pat_length				=			Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"));

String srt_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  srt_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getStore_code()),(String) session.getValue( "login_user" )}).get("SRT_DELETE_YN"),"N");

System.out.println("SalesReturnHeader.jsp....mode...."+mode+"...trn_type.."+trn_type+"..trn_type.."+trn_type+"..sql_id..."+sql_id);
System.out.println("SalesReturnHeader.jsp....Doc_type_code..."+bean.getDoc_type_code()+"...Doc_no.."+bean.getDoc_no()+"..Doc_date.."+bean.getDoc_date()+"..getDoc_ref..."+bean.checkForNull(bean.getDoc_ref())+"..Store_code..."+bean.getStore_code()+"...bean_id.."+bean_id+"...bean_name.."+bean_name+"...Item_class_code.."+bean.getItem_class_code());

%>

<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
	<jsp:param name="store_code"		value="<%=bean.checkForNull(bean.getStore_code())%>" />
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" /> 
	<jsp:param name="module_id"			value="<%=bean.getModuleId()%>" />

</jsp:include>
<%	
   if (!(bean.getSal_trn_type().equals("R")||bean.getSal_trn_type().equals("X"))) {
		encounter_id_visibility	=	"visible";
	}
   if (bean.getSal_trn_type().equals("X")) {
		patient_name_visibility	=	"visible";
	}
	//String s = bean_sales.getBLModuleInstalled();
    bean.setBillable_trn_yn(bl_install_yn);
%>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center" >
<tr>
	<td class='label'><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
<%	if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
%>
	<td class='fields'>
	<select name="sal_trn_type" id="sal_trn_type"  id="sal_trn_type"  <%=codeDisabled%> onFocus="addList(sal_trn_type);checkSaleRetTRNType(this);" onChange="checkTRNType(this);"> 
	</select>
	</td>
<%}else{%>
	<td class='fields'><select name="sal_trn_type" id="sal_trn_type" <%=codeDisabled%> onFocus="addList(sal_trn_type);" onChange="checkTRNType(this);"> 
					<option value="I"<%=bean.getSal_trn_type().equals("I")?"Selected":""%>><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value="D"<%=bean.getSal_trn_type().equals("D")?"Selected":""%>><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value="O"<%=bean.getSal_trn_type().equals("O")?"Selected":""%>><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="E"<%=bean.getSal_trn_type().equals("E")?"Selected":""%>><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="R"<%=bean.getSal_trn_type().equals("R")?"Selected":""%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
					<option value="X"<%=bean.getSal_trn_type().equals("X")?"Selected":""%>><fmt:message key="eST.DirectSales.label" bundle="${st_labels}"/></option>
		</select>
	</td>
	<%}%>
	<!-- Hidded due to this function in not used -- by gangadharan on Wednesday, October 19, 2011
	<td class='label' ><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="checkbox" name="discharge_yn" id="discharge_yn" value="<%=chk_discharge_yn%>" <%=chk_discharge_yn%> <%=discharge_yn%> onClick="setDischarge()"></td>
	-->
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td class='label' ><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="checkbox" name="chargeable_yn" id="chargeable_yn" value="<%=chargeable_yn_value%>" <%=chargeable_yn%> <%=chk_chargeable_yn%> onClick="setChargeable()"></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td><input type='text' name='patient_id' id='patient_id' class="UPPER" size=20 maxLength='<%=pat_length%>' value="<%=bean.getPatient_id()%>"  onBlur="ChangeUpperCase(this);getPatientName(this.value);callDispCurrEncFinDtlVal();" <%=codeDisabled%> onFocus="CheckStoreSalesType();" ><input type='button' name="pat_search" id="pat_search" class='button' value="?" onclick="searchPatient();" <%=codeDisabled%>><%=bean.getImage("M")%></td><!--calling callDispCurrEncFinDtlVal() Added by suresh.r  15-11-2013 against JD-CRF-156  -->
	<td class='label' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name="patient_name" id="patient_name" value="<%=bean.getPatient_name()%>" size=30 maxLength=40 disabled><span id='id_patient_name_gif' style="visibility:<%=patient_name_visibility%>"><%=bean.getImage("M")%></span></td>
	<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name='encounter_id' id='encounter_id' onChange="callBillingHdrProcedure();displayDetails();callDispCurrEncFinDtlVal();" <%=codeDisabled%> ><!--calling callDispCurrEncFinDtlVal() Added by suresh.r  15-11-2013 against JD-CRF-156  -->
	<%
	
	String select_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){ 
		out.println(select_legend);
	}else{
		out.println(bean.getEncounter_id_List());
	}
	%>
	</select><span id='id_encounter_id_gif' style="visibility:<%=encounter_id_visibility%>"><%=bean.getImage("M")%></span>
	<!-- Added by suresh r  07-11-2013 against JD-CRF-156  beg-->
	<% if(bl_install_yn.equals("Y")){%>
		<span id="id_fin_dtl" style="visibility: hidden;"> 
			<img style="cursor: hand;" onclick="callFinancialDetailScreen();"  src='../../eST/images/dollar.png' title="Current Encounter Financial Details"></img>
		</span> 
		<span style="color: red;visibility:hidden;" id="id_polexp" >Policy Expired</span>
	<%}%>
	<!-- Added by suresh r  07-11-2013 against JD-CRF-156  end -->
	</td>
</tr>


<!--Added By Dinesh T for CRF No 110, starts-->

<%
	String customerId;
	ArrayList custList = bean.getCustomerId();
	HashMap map = (HashMap)custList.get(0);
	customerId = (String)map.get("CUSTOMER_ID")==null?"":(String)map.get("CUSTOMER_ID");

	//if(customerId.equals("MC") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
	if(customerId.equals("XXX") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
	{
%>
	<tr>
		<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name=item_desc size=70 maxlength=60 value="" <%=codeDisabled%> onblur="onBlurcallItemSearchScreenForDocFilter()"><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreenForDocFilter(item_desc)"  value='?' <%=codeDisabled%>><input type="hidden" name="item_code" id="item_code" value=""></td>
		<td class='label'><fmt:message key="eST.SalesDocTpe.label" bundle="${st_labels}"/></td>
		<td class='field' colspan=4>
		<%if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {%>
		<select class='field' name="sales_doc_type" id="sales_doc_type" onchange="loadDocNo(this);"><%=select_legend%>
		 </select><%=bean.getImage("M")%>
		<% }else{%>
		<select name="sales_doc_type" id="sales_doc_type" disabled><%=bean.getSalesDocTypeList()%>
		</select><%=bean.getImage("M")%>
		<%	
		}
		%>
		</td>
	</tr>
<!--Added By Dinesh T for CRF No 110, ends-->
	<tr>
    <td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="5"><input type='text' name='remarks' id='remarks' size=60 maxLength=200 value="<%=bean.getRemarks()%>"></td>
		<td class='label'><fmt:message key="eST.SalesDocNo.label" bundle="${st_labels}"/></td><td class='field' colspan="3"><select name='sales_doc_no' id='sales_doc_no' onChange="loadDetailPage(this,sales_doc_type);" <%=codeDisabled%>> 
<%
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){ 
		out.println(select_legend);
	}else{
		out.println(bean.getSalesDocNo_List());
	}
%>
	</select><span id='sal_doc_no_gif'><%=bean.getImage("M")%></span></td>
	
	</tr> 
<% }

//Added by Ganga - New Sales Return Starts
else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
	{
%>
<tr>
<td class='label'><fmt:message key="eST.SalesDocTpe.label" bundle="${st_labels}"/></td>
<td class='field'><input type='text' name='sales_doc_type' id='sales_doc_type' size=15 maxLength=50 value=""  disabled ></td>
<td class='label'><fmt:message key="eST.SalesDocNo.label" bundle="${st_labels}"/></td>
<td class='field' colspan="4"><input type='text' name='sales_doc_no' id='sales_doc_no' size=10 maxLength=15 value="" disabled >
	<input type=button name="doc_no_search" id="doc_no_search" class="button" onClick="searchDetails()"  value='?' ></td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="5"><input type='text' name='remarks' id='remarks' size=60 maxLength=200 value=""></td>
</tr>
<% }
//New Sales Return Ends
else 
{
%>
<tr>
<td class='label'>
<fmt:message key="eST.SalesDocTpe.label" bundle="${st_labels}"/>
</td>
<td class='field'  colSpan="3">
	<%if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {%>
	<select class='field' name="sales_doc_type" id="sales_doc_type" onchange="loadDocNo(this);"><%=select_legend%>
	 </select><%=bean.getImage("M")%>
	<% }else{%>
		<input type='text' name='sales_doc_type' id='sales_doc_type' size=15 maxLength=50 value="<%=bean.getSalesDocTypeCode()%>"  disabled ><%=bean.getImage("M")%></td>
		
	<%	}
	%>
</td>
<td class='label'>
	<fmt:message key="eST.SalesDocNo.label" bundle="${st_labels}"/></td>
	<td class='field' colspan="3">
	<input type='text' name='sales_doc_no' id='sales_doc_no' size=10 maxLength=50 value="<%=bean.getSalesDocNo()%>"  disabled ></td>	
	<span id='sal_doc_no_gif'></span></td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="5"><input type='text' name='remarks' id='remarks' size=60 maxLength=200 value="<%=bean.getRemarks()%>"></td>
</tr>
<%
}



if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		NU_Clinic_code	=	bean.checkForNull(bean.getNU_Clinic_code());

			String alParameters[]={locale,bean.getLoginFacilityId(),bean.checkForNull(bean.getEncounter_id( )),bean.getPatient_id(),locale};
			HashMap nuOrClinic = new HashMap();
			HashMap hmRecord = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_CLASS_SELECT"),alParameters);
			if(hmRecord.size()>0){
			patient_class	=	bean.checkForNull((String)hmRecord.get("PATIENT_CLASS"));
			room_no			=	bean.checkForNull((String)hmRecord.get("ASSIGN_ROOM_NUM"));
			bed_no			=	bean.checkForNull((String)hmRecord.get("ASSIGN_BED_NUM"));
			NU_Clinic_code	=	bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE"));
			//out.println("patient_class = > "+patient_class+" room_no = > "+room_no+" bed_no = > "+bed_no+" NU_Clinic_code = >"+NU_Clinic_code+" ASSIGN_CARE_LOCN_TYPE = > "+hmRecord.get("ASSIGN_CARE_LOCN_TYPE"));
			if(((String)hmRecord.get("ASSIGN_CARE_LOCN_TYPE")).equals("N")){
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_NURSING_UINIT_SELECT"),alParameters1);
			}else{
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_CLINIC_SELECT"),alParameters1);
			}
			 NU_Clinic = (String)nuOrClinic.get("SHORT_DESC");
			}
	}
%>
	<tr>
	</tr>
	<td colspan=6></td>
	<tr>
		<td class="label" nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class="label" nowrap><B><label id="pat_class"><%=patient_class%></label></B></td>
		<td class="label" nowrap><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></td>
		<td class="label" nowrap><B><label id="NU_Clinic"><%=NU_Clinic%></label></B></td>
		<td class="label" nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>: <B><label id="room_no"><%=room_no%></B></label></td>
		<td class="label" nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>:<B><label id="bed_no"><%=bed_no%></label></B></td>
	</tr>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td class='fields'>
			<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>  onclick="previewDetails();" >
	</td>
	</tr>
</table>

	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="finalized_allowed_yn" id="finalized_allowed_yn"	value="N">
	<input type="hidden" name="function_id" id="function_id"				value="<%=request.getParameter("function_id") %>">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="outpatient_yn" id="outpatient_yn"			value="<%=outpatient_yn%>">
	<input type="hidden" name="Inpatient_yn" id="Inpatient_yn"			value="<%=Inpatient_yn%>">
	<input type="hidden" name="referral_yn" id="referral_yn"				value="<%=referral_yn%>">
	<input type="hidden" name="store_code1" id="store_code1"				value="<%=bean.getStore_code()%>">
	<input type="hidden" name="doc_no" id="doc_no"					value="<%=bean.getDoc_no()%>">
	<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>">
	<input type="hidden" name="ST_SQL_DIR_SAL_PAT_LOOKUP" id="ST_SQL_DIR_SAL_PAT_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("ST_SQL_DIR_SAL_PAT_LOOKUP")%>">
	<input type="hidden" name="srt_delete_yn" id="srt_delete_yn" value="<%=srt_delete_yn%>">
	<input type="hidden" name="prevIndex" id="prevIndex"				value="">
	<input type="hidden" name="item_class_doc_yn" id="item_class_doc_yn"		value="<%=bean.getItemClassBased("SRT")%>">
	<input type="hidden" name="no_of_records" id="no_of_records"		value="<%=bean.getRecordsPerTrn("SRT")%>">
	<input type="hidden" name="NU_Clinic_code" id="NU_Clinic_code"			value="<%=NU_Clinic_code%>">
	<input type="hidden" name="site_id" id="site_id" value="<%=siteId%>">
	<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
	<input type="hidden" name="patient_classcode" id="patient_classcode"	value=""><!-- Added by suresh r  04-12-2013 against JD-CRF-156 -->
	<!--Added against GHL-CRF-0413.5 starts-->
        <input type="hidden"    name="site" id="site"	 value="<%=site_main%>">
        <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
	<input type="hidden"    name="direct_sale_patient_flag" id="direct_sale_patient_flag"				value="<%=direct_sale_patient_flag%>" >
	
	<!--Added against GHL-CRF-0413.5 ends-->
	
</form>
<!-- Added by suresh r  07-11-2013 against JD-CRF-156 beg-->
<script>
<% if(bl_install_yn.equals("Y")){//Added by suresh.r on 07-05-2014 against #48871(MO-GN-5447)%>
XX1=new blinkText("XX1",'id_polexp',500,500,'darkred','#ff0000');
<% if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
callDispCurrEncFinDtlVal();
<%}}%>
callBarCodeApplicable('SRT','formSalesReturnHeader','salesReturnBean','eST.SalesReturnBean');//Added against GHL-CRF-0413.5 
</script>
<!-- Added by suresh r  07-11-2013 against JD-CRF-156 end-->
<%
//Added for GHL-CRF-0413.5 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.5 ends
%>
</body>
</html>

