<!DOCTYPE html>
<%try{%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%><!-- Added for KDAH-CRF-0432.1 -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<% 
		request.setCharacterEncoding("UTF-8");
		String locale	=	 (String)session.getAttribute("LOCALE");

		String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String bean_id						=		"salesBean" ;
	String bean_name					=		"eST.SalesBean";

	eST.SalesBean bean					=		(eST.SalesBean)getBeanObject( bean_id, bean_name,request  );  
	bean.setLanguageId(locale);

	/*GHL-CRF-0419.2 STARTS*/
	String restrictChecked="N";
	restrictChecked=bean.restrictChecked();
	/*GHL-CRF-0419.2 ENDS*/
	//System.out.println("restrictChecked-"+restrictChecked);
	
	String param = request.getQueryString();
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><!-- Added for KDAH-CRF-0432.1 -->
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!-- Added for KDAH-CRF-0432.1 -->
		<Script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></Script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>


 <!-- Added for KDAH-CRF-0432.1-->
	</head>

<%if((bean.getModuleId()).equals("OT")){%>
	<body>
<%}else{%>
<!-- 	<body onLoad="callCashCounterProcedure();FocusFirstElement();">
 -->	<body onLoad="FocusFirstElement();">
<%}%>
<form name="formSalesHeader" id="formSalesHeader">
<%

	String mode							=		request.getParameter("mode");
    String trn_type						=		"SAL";

    String outpatient_yn				=		"";
    String Inpatient_yn					=		"";
    String referral_yn					=		"";
	String directsale_yn				=		"";

	String item_class_based				=		bean.getSALItemClassBased(trn_type);
	String sql_id						=		"SQL_ST_OT_SAL_STORE_SELECT";
	//String sql_id						=		"SQL_ST_SAL_STORE_SELECT";
	/*if((bean.getModuleId()).equals("OT")){
		sql_id							=		"SQL_ST_OT_SAL_STORE_SELECT";
	}*/
	String codeDisabled					=			"";
	String encounter_id_visibility		=		"hidden";
	String patient_name_visibility		=		"hidden";
	String chargeable_yn				=		"";
	String	chk_chargeable_yn			=		"";
	String chargeable_yn_value			=		"N";
	String discharge_yn					=		"";
	String chk_discharge_yn				=		"";
	String NU_Clinic					=		"";
	String patient_class				=		"";
	String room_no						=		"";
	String bed_no						=		"";
	String display_table				=		"";
	String NU_Clinic_code				=	"";
	/*String patient_id					=		(String)request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	out.println(patient_id);
	String encounter					=		(String)request.getParameter("encounter")==null?"":request.getParameter("encounter");
	String store_code					=		(String)request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String sal_trn_type					=		(String)request.getParameter("sal_trn_type")==null?"":request.getParameter("sal_trn_type");
	if(!sal_trn_type.equals(""))
		bean.setSal_trn_type(sal_trn_type);*/
		
		//<!-- Added by Narasimhulu FOR KDAH-CRF-0432.1 STARTED  -->
		String ModFinVIsible = "hidden";
		Connection	con=null;
		boolean site=false;
		boolean direct_sale_patient_flag = false;//TBMC-SCF-0014
		try{
			con	= ConnectionManager.getConnection(request);
			 site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_MODIFY_FIN_DET");
			 //System.out.println("site======="+site);
			 direct_sale_patient_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","DIR_SALE_PAT_BASE"); //TBMC-SCF-0014
			//System.err.println("Site=21=>"+site);
			//bean.setIssite(site);
			
		}
		finally
		{
			con.close();
		}
		//GHL-CRF-0419.2 starts//
		Connection	con1=null;
		boolean site1=false;
		try{
			con1	= ConnectionManager.getConnection(request);
			 site1 = eCommon.Common.CommonBean.isSiteSpecific(con1, "ST","ST_RESTRICT_OP_EM_ENCTR");
			//System.out.println("Site1==>"+site1);
		}
		finally
		{
			con1.close();
		}
		//GHL-CRF-0419.2 ends//
		
		//<!-- Added by Narasimhulu FOR KDAH-CRF-0432.1 ENDED -->
		
	String preview_disabled				=		"disabled";
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	{
		codeDisabled					=		"disabled";
		preview_disabled				=		"";
	}
String bl_install_yn = bean.getBLModuleInstalled();
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
		chargeable_yn					=		 "disabled";
		if(bl_install_yn.equals("Y")){
			chk_chargeable_yn			=		"checked";
			chargeable_yn_value			=		 "Y";
		}

		discharge_yn					=		"disabled";
		if(bean.getTake_home_yn().equals("Y")){
			chk_discharge_yn			=		"checked";
			
		}
	}
	if((bean.getModuleId()).equals("OT")){
		codeDisabled					=		"disabled";
		display_table					=		"display:none";
		bean.setPatient_name((String)bean.getPatientName(bean.getPatient_id()));
	}
	int pat_length				=		Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"));
/*if(patient_id.equals(""))	
	patient_id					=		bean.getPatient_id();
if(store_code.equals("")||store_code==null)
	store_code					=		bean.checkForNull(bean.getStore_code());*/
String sal_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  sal_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getStore_code()),(String) session.getValue( "login_user" )}).get("SAL_DELETE_YN"),"N");

%>

<jsp:include page="StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
	<jsp:param name="store_code"		value="<%=bean.checkForNull(bean.getStore_code())%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" /> 
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
	<jsp:param name="module_id"			value="<%=bean.getModuleId()%>" />
</jsp:include>

<%	
	if (!(bean.getSal_trn_type().equals("R")||bean.getSal_trn_type().equals("X"))) {
		encounter_id_visibility	=	"visible";
		ModFinVIsible = "hidden";//Added by Narasimhulu FOR KDAH-CRF-0432.1 
	}
	if (!bean.getSal_trn_type().equals("X")) {
		patient_name_visibility	=	"visible";
		ModFinVIsible = "hidden";//Added by Narasimhulu FOR KDAH-CRF-0432.1 

	}
	String practitioner_name_visibility1		=	"hidden";
	String practitioner_name_visibility2		=	"hidden";
	String practitioner_name_visibility3		=	"hidden";
	String practitioner_name_visibility4		=	"hidden";

	String pat_additional_dtl_visibility        =	"hidden";
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))  && bean.getSal_trn_type().equals("X")){
	pat_additional_dtl_visibility  = "visible";
	}
	//added for KDAH-CRF-0432 start
	 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))  && bean.getSal_trn_type().equals("R")){
		ModFinVIsible = "visible";
	 	}//end KDAH-CRF-0432 END


	String site_id=bean.getCustomerID();
	String sal_trn_type_chk = bean.getSal_trn_type();

	if( (site_id.equals("SRR")||site_id.equals("SKR")) && (sal_trn_type_chk.equals("X")||sal_trn_type_chk.equals("R")) ){
	practitioner_name_visibility1="visible";
	practitioner_name_visibility2="visible";
	practitioner_name_visibility3="hidden";
	practitioner_name_visibility4="visible";
	 ModFinVIsible =    "hidden";//Added by Narasimhulu FOR KDAH-CRF-0432.1 

	}else if (sal_trn_type_chk.equals("X")){
	practitioner_name_visibility1="visible";	
	practitioner_name_visibility2="visible";
	practitioner_name_visibility3="hidden";
	practitioner_name_visibility4="visible";
	 ModFinVIsible =    "hidden";//Added by Narasimhulu FOR KDAH-CRF-0432.1 
	}
	else{
	practitioner_name_visibility1="visible";	
	practitioner_name_visibility2="visible";
	practitioner_name_visibility3="visible";
	practitioner_name_visibility4="visible";	
	}

%>
<!-- Added by Rabbani #incident no:AMS-SCF-0296 [IN:047589] changed width from 100% to 110% on 12-JUN-2014  -->
<table cellpadding=0 cellspacing=2 border=0 width='108%' align="center" id="123" style="<%=display_table%>">
<tr>
	<td class='label' ><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
<%	if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))&& (bean.getModuleId()).equals("ST")) {
%>
	<td class='fields'>
<!-- 	<select name="sal_trn_type" id="sal_trn_type" <%=codeDisabled%> onFocus="addList(sal_trn_type);" onChange="callCashCounterProcedure();checkTRNType(this);">  -->
	<select name="sal_trn_type" id="sal_trn_type"  id="sal_trn_type" <%=codeDisabled%> onFocus="addList(sal_trn_type);checkSaleTRNType(this);" onChange="checkTRNType(this);"> 
	</select></td>
<!-- 	<td width='25%' class="label"><div id='modify_fin_details' style="display:inline"><a href="javascript:findtl();">Modify Financial Details</a></div></td> -->
<!-- Added By Narasimhulu for KDAH-CRF-0432.1  started-->
<%if(site){ %>
<td >
<b><a name = "ModifyFin_Details" id = "ModifyFin_Details" href ="javascript:findtl();" style="visibility:<%=ModFinVIsible%>" ><fmt:message key="eST.ModifyFin.Details.label" bundle="${st_labels}"/></a></b>
</td>
<%}%>

<!-- Added By Narasimhulu for KDAH-CRF-0432.1  ending-->
<%}else{%>
	<td class='fields'>
		<select name="sal_trn_type" id="sal_trn_type" <%=codeDisabled%> onFocus="addList(sal_trn_type);"  onChange="checkTRNType(this);"> 
					<option value="I"  <%=bean.getSal_trn_type().equals("I")?"Selected":""%>><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value="D"  <%=bean.getSal_trn_type().equals("D")?"Selected":""%>><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value="O"<%=bean.getSal_trn_type().equals("O")?"Selected":""%>><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="E"<%=bean.getSal_trn_type().equals("E")?"Selected":""%>><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="R"<%=bean.getSal_trn_type().equals("R")?"Selected":""%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
					<option value="X"<%=bean.getSal_trn_type().equals("X")?"Selected":""%>><fmt:message key="eST.DirectSales.label" bundle="${st_labels}"/></option>
		</select>
	</td>
	<%if(site){ %><!--Start  Added for KDAH-CRF-0432.1 -->
		 <td id=>
				<b><a  id = "ModifyFin_Details" name = "ModifyFin_Details" style="visibility:<%=ModFinVIsible%>"disabled ><fmt:message key="eST.ModifyFin.Details.label" bundle="${st_labels}"/></a></b>
				
		</td>
<%}%><!-- End Added for KDAH-CRF-0432.1 -->
	<%}%>
	<td class='label' ><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="checkbox" name="discharge_yn" id="discharge_yn" value="<%=chk_discharge_yn%>" <%=chk_discharge_yn%> <%=discharge_yn%> onClick="setDischarge()"></td>
	<td class='label' ><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="3">&nbsp;<input type="checkbox" name="chargeable_yn" id="chargeable_yn" value="<%=chargeable_yn_value%>" <%=chargeable_yn%> <%=chk_chargeable_yn%> onClick="setChargeable()"></td>


</tr>
<tr>
	<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td><input type='text' name='patient_id' id='patient_id' class = "UPPER" size=20 maxLength='<%=pat_length%>' value="<%=bean.getPatient_id()%>" onBlur="ChangeUpperCase(this);getPatientName(this.value);callDispCurrEncFinDtlVal();" onFocus="CheckStoreSalesType();"<%=codeDisabled%>><input type='button' name='search_id' id='search_id' class='button' value="?" onclick="searchPatient();" <%=codeDisabled%>><%=bean.getImage("M")%></td><!--calling callDispCurrEncFinDtlVal() Added by suresh.r  15-11-2013 against JD-CRF-156  -->
	<td class='label' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type='text' name="patient_name" id="patient_name" value="<%=bean.getPatient_name()%>"  size=30 maxLength=40  onKeyPress="return CheckForSpecialCharsPatient(event);" disabled><span id='id_patient_name_gif' style="visibility:<%=patient_name_visibility%>"><%=bean.getImage("M")%></span></td>
	<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="3">&nbsp;<select name='encounter_id' id='encounter_id'  <%=codeDisabled%> onchange="displayDetails();callDispCurrEncFinDtlVal();"><!--calling callDispCurrEncFinDtlVal() Added by suresh.r  15-11-2013 against JD-CRF-156  -->
	<%
	
	String select_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && (bean.getModuleId()).equals("ST")) {
		out.println(select_legend);
	}else{
		out.println(bean.getEncounter_id_List());
	}
	%>
	</select><span id='id_encounter_id_gif' name='id_encounter_id_gif' style="visibility:<%=encounter_id_visibility%>"><%=bean.getImage("M")%></span>
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
<!-- <tr>
<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td colspan='3' class='fields'>&nbsp;<input type='text' name='remarks' id='remarks' size=70 maxLength=200 value="<%=bean.getRemarks()%>">
	</td>
	<td class='label'>&nbsp;</td>
	<td class='fields'>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>  onclick="previewDetails();" >
		</td> 
	</tr>
 --><%
	if((bean.getModuleId()).equals("ST")){
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {

		//	String encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
			String alParameters[]={locale,bean.getLoginFacilityId(),bean.getEncounter_id( ),bean.getPatient_id(),locale};
			HashMap nuOrClinic = new HashMap();
			HashMap hmRecord = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_CLASS_SELECT"),alParameters);
			patient_class	=	bean.checkForNull((String)hmRecord.get("PATIENT_CLASS"));
			room_no			=	bean.checkForNull((String)hmRecord.get("ASSIGN_ROOM_NUM"));
			bed_no			=	bean.checkForNull((String)hmRecord.get("ASSIGN_BED_NUM"));
			NU_Clinic_code	=	bean.checkForNull(bean.getNU_Clinic_code());
			if((bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_TYPE"))).equals("N")){
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_NURSING_UINIT_SELECT"),alParameters1);
			}else{
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_CLINIC_SELECT"),alParameters1);
			}
			 NU_Clinic = bean.checkForNull((String)nuOrClinic.get("SHORT_DESC"));
			}
%>
	<tr>
		<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class="label"><B><label id="pat_class"><%=patient_class%></label></B></td>
		<td class="label"><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></td>
		<td class="label"><B><label id="NU_Clinic"><%=NU_Clinic%></label></B></td>
		<td class="label" nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>: &nbsp;<B><label id="room_no"><%=room_no%></B></label></td>
		<td class="label" colspan="3"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>:&nbsp;<B><label id="bed_no"><%=bed_no%></label></B></td>
	</tr>
	<%}%>
<!-- </table>
	<table cellpadding=0 cellspacing=0 border=0 width='100%'  > -->
		<tr>
			<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan='2' class='fields'><input type='text' name='remarks' id='remarks' onblur = "GoBarcode();" size=70 maxLength=200 value="<%=bean.getRemarks()%>"></td><!-- GoItem_desc to GoBarcode() for GHL-CRF-0413-->
				
		<td class='label'>
			<span id = "pat_additional_dtl_label_1" style="visibility:<%=pat_additional_dtl_visibility%>">	
				<fmt:message key="Common.age.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
				<input type='text' name='Patient_age' id='Patient_age' size=5 maxLength=3  class='NUMBER'  onKeyPress="return isValidInteger();"  value="<%=bean.getPatient_age()%>">				
				<select name='Patient_age_DMY' id='Patient_age_DMY' value="<%=bean.getPatient_sex()%>">
					<option value="D" <%=bean.getPatient_age_DMY()=='D'?"Selected":""%>><fmt:message key="Common.days.label"  bundle="${common_labels}"/> </option>
					<option value="M" <%=bean.getPatient_age_DMY()=='M'?"Selected":""%>><fmt:message key="Common.months.label"  bundle="${common_labels}"/></option>
					<option value="Y" <%=bean.getPatient_age_DMY()=='Y'?"Selected":""%>><fmt:message key="Common.Years.label"  bundle="${common_labels}"/></option></select>
				<%=bean.getImage("M")%>
			</span>
		</td>
		<td class='label' colspan="3">
			<span id = "pat_additional_dtl_label_2" style="visibility:<%=pat_additional_dtl_visibility%>" >
				<fmt:message key="Common.Sex.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
				<select name='Patient_sex' id='Patient_sex' value="<%=bean.getPatient_sex()%>">
					<option value=""  <%=bean.getPatient_sex().equals("")?"Selected":""%>><fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> </option>
					<option value="M" <%=bean.getPatient_sex().equals("M")?"Selected":""%>><fmt:message key="Common.male.label"  bundle="${common_labels}"/></option>
					<option value="F" <%=bean.getPatient_sex().equals("F")?"Selected":""%>><fmt:message key="Common.female.label"  bundle="${common_labels}"/></option></select>
				<%=bean.getImage("M")%>
			</span>
		</td>
				<%if((bean.getModuleId()).equals("OT")){%>
				<td class='label' ><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan="3">&nbsp;<input type="checkbox" name="chargeable_yn_OT" id="chargeable_yn_OT" value="<%=chargeable_yn_value%>" <%=chargeable_yn%> <%=chk_chargeable_yn%> onClick="setChargeable()"></td>
			<%}%>				
			<td class='fields'>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>  onclick="previewDetails();" >
				</td> 
		</tr>
		<tr>
        <%if(!site_id.equals("SRR")){
				if(!site_id.equals("SKR")){%>

			<td class='label'><fmt:message key="eST.Priority.label" bundle="${st_labels}" /></td>
			<td class='field'><select name='sales_priority_type' id='sales_priority_type' <%=codeDisabled%> >
			<option value="R" <%=bean.getSales_priority_type().equals("R")?"Selected":""%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
			<option value="U" <%=bean.getSales_priority_type().equals("U")?"Selected":""%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				</select>
			</td> 
			<%}
			else{%>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
				<%}	
			}
			else{%>
			<td>&nbsp;</td>
			<td>&nbsp;</td>

			<%}%>

			<td class='label'><span id = "practitioner_name_label" style="visibility:<%=practitioner_name_visibility1%>">
			<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></span></td>
			<td class='fields' colspan="6">&nbsp;<input type='text' name="practitioner_name" id="practitioner_name"  value="<%=bean.getPractitioner_name()%>" style="visibility:<%=practitioner_name_visibility2%>" size=30 maxLength=30   onBlur="searchPractitioner1(practitioner_id,practitioner_name);"  >
								<input type='button' id='id_practitioner_name_gif' style="visibility:<%=practitioner_name_visibility3%>" name='practitioner_id_look' class='button' value="?" onclick="searchPractitioner(practitioner_id,practitioner_name);" ><span id = "prac_name_mandatory_label" style="visibility:<%=practitioner_name_visibility4%>" ><%=bean.getImage("M")%></span></td>
		</tr>

	</table>
	<input type="hidden" name="patient_id_ot" id="patient_id_ot"			value="<%=bean.getPatient_id()%>">
	<input type="hidden" name="encounter_ot" id="encounter_ot"			value="<%=bean.getEncounter_id()%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="authorize_allowed_yn" id="authorize_allowed_yn"	value="N">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="outpatient_yn" id="outpatient_yn"			value="<%=outpatient_yn%>">
	<input type="hidden" name="Inpatient_yn" id="Inpatient_yn"			value="<%=Inpatient_yn%>">
	<input type="hidden" name="referral_yn" id="referral_yn"				value="<%=referral_yn%>">
    <input type="hidden" name="directsale_yn" id="directsale_yn"			value="<%=directsale_yn%>">
	<input type="hidden" name="language_id" id="language_id"				value="<%=locale%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
	<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>">
	<input type="hidden" name="doc_no" id="doc_no"					value="<%=bean.getDoc_no()%>">
	<input type="hidden" name="NU_Clinic_code" id="NU_Clinic_code"			value="<%=NU_Clinic_code%>">
	<input type="hidden" name="prevIndex" id="prevIndex"				value="">
	
	<input type="hidden" name="ST_SQL_DIR_SAL_PAT_LOOKUP" id="ST_SQL_DIR_SAL_PAT_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("ST_SQL_DIR_SAL_PAT_LOOKUP")%>">
	<input type="hidden" name="sal_delete_yn" id="sal_delete_yn" value="<%=sal_delete_yn%>">
	<input type="hidden" name="item_class_doc_yn" id="item_class_doc_yn"	value="<%=bean.getItemClassBased("SAL")%>">
	<input type="hidden" name="no_of_records" id="no_of_records"		value="<%=bean.getRecordsPerTrn("SAL")%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id"		value="<%=bean.getPractitioner_id()%>">
	<input type="hidden" name="site_id" id="site_id"		value="<%=site_id%>">
	<input type="hidden" name="Patient_dob" id="Patient_dob"		value="<%=bean.getPatient_dob()%>">
	<input type="hidden" name="patient_classcode" id="patient_classcode"	value=""><!-- Added by suresh r  04-12-2013 against JD-CRF-156 -->
	<input type="hidden" name="site" id="site"		value="<%=site%>"><!--//Added for KDAH-SCF-0432.1-->
	
	<input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
	<input type="hidden" name="restrictChecked" id="restrictChecked"		value="<%=restrictChecked%>"><!--//Added for GHL-CRF-0419.2-->
	<input type="hidden" name="site1" id="site1"		value="<%=site1%>"><!--//Added for GHL-CRF-0419.2-->
	<input type="hidden" name="flagcount" id="flagcount"		value=""><!--//Added for GHL-CRF-0419.2-->
	<input type="hidden" name="direct_sale_patient_flag" id="direct_sale_patient_flag"		value="<%=direct_sale_patient_flag%>"><!--//Added for TBMC-SCF-0014-->
	
	


</form>

<script>
//Added by suresh r  07-11-2013 against JD-CRF-156 beg
<% if(bl_install_yn.equals("Y")){//Added by suresh.r on 07-05-2014 against #48871(MO-GN-5447)%>
XX1=new blinkText("XX1",'id_polexp',500,500,'darkred','#ff0000');
<% if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
callDispCurrEncFinDtlVal();
<%}}%>
//Added by suresh r  07-11-2013 against JD-CRF-156 end
callBarCodeApplicable('SAL','formSalesHeader','salesBean','eST.SalesBean');
parent.frameSalesDetail.document.location.href="../../eST/jsp/SalesDetail.jsp?<%=param%>";
parent.frameSalesList.document.location.href="../../eST/jsp/SalesListFrame.jsp?<%=param%>";	
</script>
</body>
</html>
<%}catch(Exception e){
	 e.printStackTrace();
 }
 %>

