<!DOCTYPE html>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
04/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
12/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions
--------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.*,java.sql.* , eCommon.Common.*,java.text.DecimalFormat,java.sql.* , eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%> 
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String facility_id				=(String)session.getValue("facility_id");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

<%


boolean site_MFR_greater_than_24hr = false;//added start for ML-MMOH-CRF-1222
Connection con = null;
try{

		  con	= ConnectionManager.getConnection(request);
		 site_MFR_greater_than_24hr = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","MFR_GREATER_THAN_24H");

}catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
}
finally{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}


	String buildMAR_yn		= "";
	String MAR_app_yn		= "";
	String buildMAR_checked	= "";
	// RUT-CRF-0062 [IN029600] To build -- begin 
	String buildMAR_rule	= "";  
	String buildMAR_enable	= "";
	// RUT-CRF-0062 [IN029600] -- end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
	String buildMAR_enable	= "";
		 SRR20056-CRF-0649.1 */
	String params			= request.getQueryString();
	String adr_count		= request.getParameter("adr_count") == null ? "0":request.getParameter("adr_count");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id 	= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
 	String order_type_flag	= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String order_set_code	= request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
	String weight= request.getParameter("weight") == null ? "":request.getParameter("weight");//Added for IN:070451
	String bsa= request.getParameter("bsa") == null ? "":request.getParameter("bsa");//Added for IN:070451
	ArrayList orderSetCodes	= new ArrayList();
	HashMap   orderSetFluid = new HashMap();
	String iv_prep_default	= request.getParameter("iv_prep_default") == null ? "":request.getParameter("iv_prep_default");

	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = MAR_app_yn;

	//RUT-CRF-0062 [IN029600] Commented to display Build MAR field based on Build MAR Rule -- begin
	/*if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP"))
			buildMAR_enable  =	"disabled";
		 SRR20056-CRF-0649.1 
		if(buildMAR_yn.equals("Y"))
		buildMAR_checked =	"Checked";
	}
	*/
	//RUT-CRF-0062 [IN029600] -- end

	String form_code			=	"";
	String route_code			=	"";
	String order_type_code		=	"";
	String Disabled				=	"";
	String checkVal				=   "";
	String admix_value			=   "";
	String CATALOG_DESC			=   "";
	String ORDER_CATALOG_CODE   =   "";
	String fluid_code			=   "";
	String stock_value			=   "";
	String stock_uom_code		=   "";
	String time_flag            =   ""; 
	String disable_addmixture	=   "";
	String alert_practitioner_yn=   "";
	String chk_addmixture       =   ""; 
	String base_volume			=   "";	
    String fluid_adr_display    =   "hidden";
	String mfr_display			=	"hidden";
	String read					=	"";
	String mfr_remarks			=	"";
	String remarksDisplay		=	"display:none";
	String ext_disp_appl_yn = "";   //added for nmc-jd-crf-0046
	ArrayList exstngIVOrders	= new ArrayList();
	HashMap   record			= new HashMap();

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
	
	String order_id			= (String)ORbean.getOrderId();
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;

	bean.setLanguageId(locale);
	String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); //added for SKR-CRF-0035 start
	String iv_calc_infuse_display="", iv_calc_duration_display="";
	if(iv_calc_infuse_by.equals("I")){
		iv_calc_infuse_display="display:inline;";
		iv_calc_duration_display="display:none;";
	}
	else{
		iv_calc_infuse_display="display:none;";
		iv_calc_duration_display="display:inline;";
	} //added for SKR-CRF-0035 end
	String param_volume_cal=bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
		
		if(!order_set_code.equals("")) 
			orderSetCodes = bean.getOrdersetCodes(order_set_code);
		if((orderSetCodes.size() != 0) &&(bean.getFluidCompatibility().equals("Y"))) {
			orderSetFluid = bean.getOrderSetDrugs((String)orderSetCodes.get(0)); 
			ArrayList orderSetValues	= bean.getOrderSetValues();
			String	sReqRnot			= "";
			fluid_code					= (String)orderSetFluid.get("drug_code");
			CATALOG_DESC				= (String)orderSetFluid.get("drug_desc");
			bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED

			if(orderSetValues.get(0).equals(fluid_code)){
				stock_value				= (String)orderSetValues.get(1);		
				sReqRnot				= (String)orderSetValues.get(6);
			}
			if(sReqRnot.equals("R")) 
				Disabled = "disabled";
		} 
	}
System.err.println("====135======stock_value========>"+stock_value);
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);
	
	//Start of NMC-JD-CRF-0046
	String  disp_loc = (String)bean.getDisp_locn_code();
	ext_disp_appl_yn = bean.getExtDispYN(disp_loc);

    //End of NMC-JD-CRF-0046
   
    
	if(iv_prep_yn.equals("1")){
		checkVal="unchecked";
		admix_value = "N";
	}
	else if(iv_prep_yn.equals("2")){
		checkVal="checked";
		admix_value = "Y";
	}
	else checkVal="";
	String mode = request.getParameter("mode");
		if(mode == null) mode="";
	if(order_type_flag.equals("Existing") || (mode.equals("amend"))){
		Disabled = "disabled";
  
		exstngIVOrders		= bean.getAllExistingIVOrders();
		record				= (HashMap)exstngIVOrders.get(0);
		CATALOG_DESC		= (String)record.get("CATALOG_DESC");
		ORDER_CATALOG_CODE	= (String)record.get("ORDER_CATALOG_CODE");
		mfr_remarks			= (String)record.get("MFR_REMARKS");
		fluid_code			= ORDER_CATALOG_CODE;
		bean.setFluidDetails(ORDER_CATALOG_CODE,"","","",""); // CRF-0062 NEWLY ADDED
		if (bean.checkForStock()) {
			ArrayList stockDetails = bean.getStockDetails(ORDER_CATALOG_CODE, "1");
			if (stockDetails.size() != 0){
				stock_value    = (String)stockDetails.get(0);
				stock_uom_code = (String)stockDetails.get(1);
				base_volume    = stock_value;
			}
		}
		stock_value     = (String)record.get("QTY_VALUE");
		order_type_code	= bean.getOrderType(ORDER_CATALOG_CODE);
		bean.setPatientClass(patient_class);
		HashMap MFRRecs = new HashMap();
		MFRRecs         = bean.getMFRRecs();
		bean.clear();
		bean.setMFRRecs(MFRRecs);
		if(MFRRecs != null && MFRRecs.size()>0){
			bean.setMFRYN("Y");
			mfr_display = "";
			
		}
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		for(int i=1;i<exstngIVOrders.size();i++){
			bean.setPatientClass(patient_class);
			record					= (HashMap)exstngIVOrders.get(i);
			ORDER_CATALOG_CODE		= (String)record.get("ORDER_CATALOG_CODE");
			bean.setWeight(weight);//Added for IN:070451
			bean.setBSA(bsa);//Added for IN:070451
			bean.setDrugDetails(ORDER_CATALOG_CODE,ORbean.getPractitionerId(),ORbean.getResponsibilityId(),"","","","");  //CRF-0062 // Added getPractitionerId and getResponsibilityId for ML-MMOH-CRF-0343 [IN:057182]
			bean.setIVPB("N");
		}
		//added for SRR20056-SCF-7882 -29157 - start
		/*if(record.get("BUILD_MAR_YN")==null){
			record.put("BUILD_MAR_YN",MAR_app_yn);
		}*/
		buildMAR_yn		= (String) record.get("BUILD_MAR_YN");
		// RUT-CRF-0062 [IN029600] Added to get the Build MAR Rule -- begin
		buildMAR_rule = record.get("BUILD_MAR_RULE").toString();
		/*if(MAR_app_yn.equals("Y")){
			if(buildMAR_yn !=null && buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			else
				buildMAR_checked="";
		//}
		//added for SRR20056-SCF-7882 -29157 - End */
		// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value
		
		if(buildMAR_yn !=null && buildMAR_yn.equals("Y"))
			buildMAR_checked ="Checked";
		else
			buildMAR_checked="";
		buildMAR_rule=buildMAR_rule==null?"":buildMAR_rule;  
		if(buildMAR_rule.equals("CE")){
			buildMAR_enable="";
		}
		else if(buildMAR_rule.equals("UE")){
			buildMAR_enable="";
		}
		else if(buildMAR_rule.equals("CD")){
			buildMAR_enable="disabled";
		}
		else if(buildMAR_rule.equals("UD")){
			buildMAR_enable="disabled";
		}
		if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
		{
			buildMAR_enable="disabled";
			buildMAR_checked="";
			buildMAR_yn="N";
		}
		bean.setBuildMAR_yn(buildMAR_yn);// RUT-CRF-0062 [IN029600] Added to get the Build MAR Rule -- end
	}
	else {
		String resetYN = request.getParameter("reset")==null?"": request.getParameter("reset");
		HashMap hm_fluid_details = null;

		if(!resetYN.equals("Y")){
			if(bean.getAmendFluidDetails()==null || (bean.getAmendFluidDetails()).size()==0){
				bean.loadAmendDetails(order_id, patient_id,"");// RUT-CRF-0062 
			}
		}
		hm_fluid_details = bean.getAmendFluidDetails();
		bean.setPatientClass(patient_class);
		if(hm_fluid_details != null){
			if(hm_fluid_details.size()>0){
				fluid_code		= (String)hm_fluid_details.get("DRUG_CODE");
				order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
				if(hm_fluid_details.get("BUILD_MAR_YN")==null){
					hm_fluid_details.put("BUILD_MAR_YN",MAR_app_yn);
				}
				buildMAR_yn		= (String) hm_fluid_details.get("BUILD_MAR_YN");
				buildMAR_rule = hm_fluid_details.get("BUILD_MAR_RULE").toString(); // RUT-CRF-0062 [IN029600]-- Added to get the Build MAR Rule value

		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(MAR_app_yn.equals("Y")){
					if(patient_class.equals("IP"))
						buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
		 /* RUT-CRF-0062 [IN029600] Added / Commented to set the Build MAR value based on Build MAR Rule-- begin
					if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
						buildMAR_checked ="Checked";
					else
						buildMAR_checked="";
		*/
			// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value
				if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked="";
					
				buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;
				
	
				if(buildMAR_rule.equals("CE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("UE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("CD")){
					buildMAR_enable="disabled";
				}
				else if(buildMAR_rule.equals("UD")){
					buildMAR_enable="disabled";
				}
				if(ext_disp_appl_yn.equals("Y"))  //Added for NMC-JD-CRF-0046
				{
					buildMAR_enable="disabled";
				        buildMAR_checked="";
				}
				bean.setBuildMAR_yn(buildMAR_yn);// RUT-CRF-0062 [IN029600]-- Added to get the Build MAR Rule value	-- end
				//}
			}
		}
	}	
    if( Integer.parseInt(adr_count)>0){
		int fluid_adr_count = bean.getADRCount(patient_id,fluid_code);
		if(fluid_adr_count>0)
			fluid_adr_display ="visible";
	}
	bean.setIVPB("N");
	bean.setIVType("IVD");
	HashMap record1;
 /******************************************************************************************
	  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE and FROM_TIME and 
	                TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB starts 
	  date:11/22/2004
	*****************************************************************************************/
	//if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){   
	record1					=	new HashMap(); 
	record1					=	bean.ChkAdMixture();
	chk_addmixture			=	(String)record1.get("IV_ADMIXTURE_APPL_YN");
	alert_practitioner_yn	=	(String)record1.get("ALERT_PRACTITIONER_YN");

	if(chk_addmixture.equals("N") || mfr_display.equals(""))
	   disable_addmixture	=	"Disabled";		    
	else{
	   disable_addmixture	=	"";
	}
	if(order_type_flag.equals("Existing")){
%>
		<script>

			parent.f_iv_drug_details.location.href="../../ePH/jsp/IVPrescriptionDrugDetailFrames.jsp?<%=params%>";

		</script>
<%
	} 
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formIVPrescriptionDetails" id="formIVPrescriptionDetails">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td class="COLUMNHEADER" colspan="8">
						<font style="font-size:9"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></font>
					</td>
				</tr>
				<tr>
                    <TD CLASS="label" COLSPAN="" NOWRAP WIDTH="4%" ><img style="visibility:<%=fluid_adr_display%>" id="fluid_ADR_img" name="fluid_ADR_img" src='../../ePH/images/ADR.gif' height ='20' width ='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>
					</TD>
					<td   width='20%' >
						<SELECT name="fluid" id="fluid" onchange="changeFluid('this','<%=param_volume_cal%>')"  <%=Disabled%>> <!-- '<%//=param_volume_cal%>' added for AAKH-CRF-0094 -->
							<option value="" >----------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>----------</option>
<%
							if(order_type_flag.equals("Existing") || (mode.equals("amend"))){
%>
								<option value='<%=fluid_code%>' selected><%=CATALOG_DESC%></option>
<%
							}
%>						  </SELECT>
						<img id="img1" style="visibility:visible" src="../../eCommon/images/mandatory.gif" ></img>
<%					
						if(fluid_code != null && !fluid_code.equals("")){%>
							<img id="edl_info" style="visibility:visible;cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(fluid.value);">
<%						
						}
						else{
%>
							<img id="edl_info" style="visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(fluid.value);">
<%						
						}
%>
					</td>
					<td class="label" width='16%' style='<%=iv_calc_infuse_display%>' id="tdVolumePerUnit">
						<label id="volumePerUnit_leg"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
						<input type="text" name="volumePerUnit" id="volumePerUnit" size="3" class="NUMBER" readOnly>&nbsp;
						<label id="volPerUnitUom_leg" class="label" style="font-size:9px;"></label>
					</td>
					<td   width='10%' class="label" ><label style='<%=iv_calc_infuse_display%>'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;</label><fmt:message key="Common.volume.label" bundle="${common_labels}"/>: </td>
					<input type="hidden" name="stock_uom_code" id="stock_uom_code" value="<%=stock_uom_code%>" >

<%					if(!mfr_display.equals("hidden")) {
						read = "readonly";
						checkVal = "disabled";
						remarksDisplay="";
					}
					else{
						read = "";
					}
					if (bean.checkForStock()) {
						if (iv_option.equals("Y")) {
%>
							<!-- Added for AAKH-CRF-0094 start -->
					<%	if(param_volume_cal.equals("N")){%>
						<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);"  <%=read%> disabled> &nbsp;<label id='stock_display' name='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
							 
							 <%	}  
							else{%>
							<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);"  <%=read%> > &nbsp;<label id='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
							<%} %>
						<!-- Added for AAKH-CRF-0094 end-->
						
							<%
						}
						else {
%>
							<!-- Added for AAKH-CRF-0094 start -->
					<%	if(param_volume_cal.equals("N")){%>
						<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);" <%=read%> disabled> &nbsp;<label id='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
							 <%	}  
							else{%>
							<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);" <%=read%> > &nbsp;<label id='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
							<%} %>
						<!-- Added for AAKH-CRF-0094 end-->
							
<%
						}
					}
					else {
%>					<!-- Added for AAKH-CRF-0094 start -->
					<%	if(param_volume_cal.equals("N")){%>
						<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);" <%=read%> disabled> &nbsp;<label id='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
						 
						<%	}  
							else{%>
							<td class='label' width='15%'><input type="text" maxlength="5" size="5" style="text-align:right" name="stock_value" id="stock_value" value="<%=stock_value%>" onblur="setStockValue(this)" onKeyPress="return allowValidNumber(this,event,5,0);" <%=read%> > &nbsp;<label id='stock_display' ><b> <%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label></td>
							<%} %>
						<!-- Added for AAKH-CRF-0094 end-->
<%
					}
%>
					</td>
<%
					if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
						<td class='label' width='10%'><fmt:message key="Common.IVAdmixture.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="admixture" id="admixture" <%=checkVal%>  onClick="setAdmixtureValue(formIVPrescriptionDetails),checkadmixture(formIVPrescriptionDetails)" <%=disable_addmixture%>></td>
<%
					}
					else{
%>
						<td class='label' width='10%'><fmt:message key="Common.IVAdmixture.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="admixture" id="admixture" <%=checkVal%> value="<%=admix_value%>" onClick="setAdmixtureValue(formIVPrescriptionDetails)" ></td>
<%					
					}
					if(MAR_app_yn.equals("Y")){
						if(!ext_disp_appl_yn.equals("")){ //Added For NMC-JD-CRF_0046
%>
						<td class='label' width='10%' nowrap><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
						<!-- RUT-CRF-0062 [IN029600]-- Added buildMAR_enable flag to enable/disable based on Build MAR Rule -->
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%>   <%=buildMAR_enable%>  onclick='assignValue(this);'></td>
<%
					         	}
				}
					 
					else{
%>
						<td class='label'width='10%' nowrap>
						<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
						</td>
<%
					}
%>
				<td class='label'>		
<%				
				if(!mode.equals("amend") ){
%>
					
					<a href="#"  onMouseOver="changeCursor(this);" onClick="javascript:showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=site_MFR_greater_than_24hr%>');" id='mfrLink'>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a> <!-- Modified for TFS-13907 -->
<%
					if(mfr_display.equals("")){
%>
						<img src="../../eCommon/images/enabled.gif"  id='MFR_Indicator'>
<%					
					}
					else{
%>
						<img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator'>
<%					
					}
				}
				else{
					if(mfr_display.equals("")){
%>
						<a href="#"  onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=site_MFR_greater_than_24hr%>');" id='mfrLink' >&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a>
						<img src="../../eCommon/images/enabled.gif"  id='MFR_Indicator'>
<%					
					}
					else{
%>						
						<fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/>
						<img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator'>
<%
					}
				}				
%>
				<br><a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks();" id='mfrRemarksLink' style="<%=remarksDisplay%>" >&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></a>
			</td></tr> 
			</table>
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
			<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
			<input type="hidden" name="base_uom" id="base_uom" value="">
			<input type="hidden" name="eqvl_uom_value" id="eqvl_uom_value" value="">
			<input type="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE" value="<%=order_type_code%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
			<input type="hidden" name="STOCK_VALUE" id="STOCK_VALUE" value="<%=stock_value%>">
			<input type="hidden" name="DRUG_VOLUME" id="DRUG_VOLUME" value="">
			<input type="hidden" name="STOCK_UOM_CODE" id="STOCK_UOM_CODE" value="<%=stock_uom_code%>">
			<input type="hidden" name="BASE_VOLUME" id="BASE_VOLUME" value="<%=base_volume%>">
			<input type="hidden" name="order_type_flag1" id="order_type_flag1" value="<%= order_type_flag %>">
			<input type="hidden" name="order_set_code" id="order_set_code" value="<%= order_set_code %>">
			<input type="hidden" name="language_id" id="language_id" value="<%= locale %>">
			<input type="hidden" name="mfr_yn" id="mfr_yn" value='<%=read.equals("")?"N":"Y"%>'>
			<input type="hidden" name="mfr_remarks" id="mfr_remarks" value="<%=mfr_remarks%>">
			<input type="hidden" name="back_date" id="back_date"		value="">
			<input type="hidden" name="future_date" id="future_date"		value="">
			<input type="hidden" name="volume_reference" id="volume_reference" value="<%=stock_value%>"><!-- Added for AAKH-CRF-0094 -->
                        <input type="hidden" name="param_volume_cal" id="param_volume_cal" value="<%=param_volume_cal%>"><!-- Added for AAKH-CRF-0094 -->
                         <input type="hidden" name="ext_disp_appl_yn" id="ext_disp_appl_yn" value="<%=ext_disp_appl_yn%>"><!-- added for nmc-jd-crf-0046 -->
<%
			if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
				<input type="hidden"	name="alert_practitioner_yn" id="alert_practitioner_yn"	value="<%=alert_practitioner_yn%>">
<%
			}
%>
		</FORM>
<% 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(or_bean_id,ORbean,request);
%>
	</body>
<%
	if(mode.equals("amend")){
%>
		<script>document.formIVPrescriptionDetails.img1.style.visibility="hidden";</script>
<%
	}
	if(fluid_code!=null && !fluid_code.equals("")){
%>
		<script>
			var bean_id			= document.getElementById("bean_id").value;
			var bean_name		= document.getElementById("bean_name").value;
			var qryString		= bean_id+"&bean_name="+bean_name+"&validate=STOCKDETAILS&drug_code=<%=fluid_code%>&mode=<%=mode%>&order_set_code=<%=order_set_code%>";
			setTimeout("submitXML(qryString, \"\")",1000);

		</script>
 <%
	}
 %>
 </HTML>

