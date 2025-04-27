<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML> 
<HEAD> 
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNWorkSheet.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	//Adding start for ML-MMOH-CRF-1201
	   Connection con			= null;  
        con				= ConnectionManager.getConnection(request);
        boolean tpn_change_mmoh = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPLICABILITY_SETTINGS");
//Adding end for ML-MMOH-CRF-1201
	try{
    String params = request.getQueryString() ;

	int iMaxLength = 9;
	int iNoOfDecimals = 4;

	String order_id		= request.getParameter("order_id");
	if(order_id == null) {order_id = "";}
	String tpn_non_std_regimen_code = request.getParameter("tpn_non_std_regimen_code");
	if(tpn_non_std_regimen_code ==  null){tpn_non_std_regimen_code = "";}
	String patient_id	= request.getParameter("patient_id");
//	String locn_code	= request.getParameter("locn_code");
	String curr_group	= "";
	String curr_group_code	= "";
	String prev_group		= "";
	String presc_base_unit	=   "";
	String overage_vol	= "";
	String readOnly		= "";
    String dischargeIND = request.getParameter("dischargeIND");
	String bean_id		  = "TPNWorkSheetBean";
	String bean_name	  = "ePH.TPNWorkSheetBean";
	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

	String bean_id_1	  = "DispMedicationBean" ;
	String bean_name_1	  = "ePH.DispMedicationBean";
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject(bean_id_1,bean_name_1,request);

	String bean_id_2	  = "DispMedicationAllStages" ;
	String bean_name_2	  = "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_2 = (DispMedicationAllStages)getBeanObject(bean_id_2,bean_name_2,request);



    overage_vol	= 	bean_2.getOverageVol();

	if(overage_vol == null || overage_vol.equals("")){ 
		overage_vol = ""; 	
		bean.setOverageVolume(order_id);
		overage_vol	= 	bean.getOverageVolume();
	}

	if(overage_vol == null || !overage_vol.equals("")){
		if(overage_vol == null) {overage_vol = "";}
		readOnly  = "readOnly"; 
	}else{
		overage_vol = bean_2.getDfltOvrgVol(tpn_non_std_regimen_code);
		if(overage_vol == null) {overage_vol = "";}
	}


	String tpn_qty  = "1";
	String tpn_uom  = "";
	ArrayList  tpn_vals = null;
	String ordered_volume = "";
	ordered_volume = bean.getOrderVolume(order_id);
	if(ordered_volume == null){ordered_volume = "";}

	if(bean_1.getTPNWorksheetID(order_id) != null){
		tpn_vals = bean_1.getTPNQtyUom(order_id);

		if((tpn_vals != null) && (tpn_vals.size() >0) ){
			tpn_qty=(String)tpn_vals.get(0);
			tpn_uom=(String)tpn_vals.get(1);
		}
	}

	String locn_code	= bean_1.getDispLocnCode();
	presc_base_unit		= bean.getPrescBaseUnit();
    ArrayList prevWSVls= new ArrayList();
	prevWSVls=bean_1.getPrevWorkSheetDetails();
	if(prevWSVls != null){
		tpn_qty=bean_2.getTPNQty();
		if(tpn_qty.equals("")){tpn_qty = "1";}
		tpn_uom=bean_2.getTPNQtyUOM();
	}

	ArrayList tpn_wrk_sht_details= new ArrayList();
	tpn_wrk_sht_details=bean.getTPNWrkSheetDetails(order_id);
	Hashtable rec = new Hashtable();
	bean.clear();
	ArrayList initalDetails = bean.getInitalDetails(order_id,patient_id,tpn_non_std_regimen_code);
	bean.getConstPrecepInfo();

	int j=0;
	
	String ALLOC_QTY_UOM		=	"";
	String ITEM					=	"";
	String ALLOC_QTY			=	"";
	String BATCH				=	"";
	String EXPIRY_DATE			=	"";
	String ISSUE_QTY			=	"";
	String QTY_UOM				=	"";
	String trade_id				=	"";
	String manufacture_var_percentage="";
	String LastDerivedValue		=	"0";
	String bin_locn_code		=	"";
	String concentration_percent=	"";
	String const_generic_code	=   "";
	String stock_uom			=	"";
	String equvl_value			=   "";
	String beyond_dsg_rsn		=	"";
	String const_remarks		=	"";
	String not_to_be_ordered	=	"";
	String dflt_lkp_vsblty		=   "hidden";
	String osmolar_value		=	"";
	String osmolar_value_lt		=   "";
	float  ws_osmo_value		=   0;
	String ws_osmo_value_lt		=   "";
	int   pres_qty_range		=  0;
	float min_qty				=  0;
	float max_qty				=  0;
	StringBuffer range_buffer = new StringBuffer();
	String billing_interface_yn     =   bean_2.checkforbillinginterface();
	String width					=  "120%";
	if(billing_interface_yn.equals("Y")){
			width						=  "150%";
	}
	String decimalFormatString			=  "";	
	float gross_charge_amount           =  0;
	float groos_pat_payable             =  0;
	String gross_charge_amount_str		=  "";
	String groos_pat_payable_str		=  "";
	String tot_gross_charge_amount_str	=  "";
	String tot_groos_pat_payable_str	=  "";	
	float tot_gross_charge_amt			=	0;
	float tot_pat_payable_amt			=	0;
	ArrayList constPrecepInfo			= new ArrayList();
	ArrayList itemvalues			= new ArrayList();//Added for ML-MMOH-CRF-1201
	String item_concentration_percent=	"";//Added for ML-MMOH-CRF-1201
	String item_volume ="";//Added for ML-MMOH-CRF-1201
%>

<BODY>
<FORM name="formTPNWorkSheetDetails" id="formTPNWorkSheetDetails">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="<%=width%>" ALIGN="center" BORDER="0">
<!-- 	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="<%=width%>" ALIGN="center" BORDER="0"> -->
	<TR>
		<TD WIDTH="30%" align="left" CLASS="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><fmt:message key="ePH.OverageVolume.label" bundle="${ph_labels}"/> </b>&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="TEXT" size="1" maxlength="2" name="overage_volume" id="overage_volume" value="<%=overage_vol%>"  <%=readOnly%> onblur="calOvrgeOrdQty(this);">&nbsp;&nbsp;<label ID='overage_uom' width="20%" align='left' STYLE="font-size:9;font-weight:bold;" > </TD>
		<TD WIDTH="1%" colspan="1" STYLE="background-color:white" ></TD>
		<TD WIDTH="49%"></TD>
		<TD WIDTH="1%" STYLE="background-color:white" ></TD>
	</TR>
	<TR height=2>
		<TD ALIGN="left" WIDTH="40%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			<td class= "COLUMNHEADER" COLSPAN="4" ALIGN="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;<fmt:message key="ePH.DisplaySection.label" bundle="${ph_labels}"/></Td>
			<TR>
				<td class= "COLUMNHEADER" ALIGN="left" WIDTH="2%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="17%"><fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></Td>
				<td class= "COLUMNHEADER" ALIGN="left" WIDTH="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/> <br><fmt:message key="Common.Actual.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Overrage.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%"><fmt:message key="ePH.AvRecQty.label" bundle="${ph_labels}"/></Td>
			</TR>
			</TABLE>
		</TD>
		<TD ALIGN="left" WIDTH="1%" colspan="1" STYLE="background-color:white">&nbsp;</TD>
		<TD ALIGN="left" WIDTH="60%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			 <%if(billing_interface_yn.equals("Y")){%>
			       <td class= "COLUMNHEADER" COLSPAN="6" ALIGN="left"><fmt:message key="ePH.CalculationSection.label" bundle="${ph_labels}"/></Td>
			 <%}else{%>
				   <td class= "COLUMNHEADER" COLSPAN="4" ALIGN="left"><fmt:message key="ePH.CalculationSection.label" bundle="${ph_labels}"/></Td>
			 <%}%>
			<TR>
				<td class= "COLUMNHEADER" ALIGN="right" WIDTH="40%" nowrap >&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%" nowrap>&nbsp;<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%" nowrap>&nbsp;<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="left" WIDTH="14%" nowrap>&nbsp;<fmt:message key="Common.IssueQuantity.label" bundle="${common_labels}"/> &nbsp;</Td>
                <%if(billing_interface_yn.equals("Y")){%>
				  <td class= "COLUMNHEADER" width="11%" ><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
		          <td class= "COLUMNHEADER" width="11%" ><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
			  <%}%>
			</TR>
			</TABLE>
		</TD>
		<TD ALIGN="left" WIDTH="2%" STYLE="background-color:white">&nbsp;</TD>
	</TR>
	<!-- </TABLE> -->

<%
//ArrayList CONST_GENERIC_CODE = new ArrayList();
StringBuffer batch_str				= new StringBuffer();
StringBuffer gross_charge_display_str  = new StringBuffer();
StringBuffer pat_charge_display_str    = new StringBuffer();

	for (int i=0; i<initalDetails.size(); i+=11, j++) {

	  /*cal = Math.round(((100/Float.parseFloat((String)initalDetails.get(i+7)))* Integer.parseInt((String)initalDetails.get(i+4))))+"";*/
    // if(!CONST_GENERIC_CODE.get(0).equals(initalDetails.get(i+2)))
		//CONST_GENERIC_CODE.add(initalDetails.get(i+2)+"$");
		ALLOC_QTY_UOM="";
		ITEM="";
		ALLOC_QTY="";
		BATCH="";
		EXPIRY_DATE="";
		ISSUE_QTY="";
//		LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
		trade_id="";
		bin_locn_code="";
		QTY_UOM="";
		concentration_percent="";
		manufacture_var_percentage="";
		osmolar_value="";
		osmolar_value_lt = "";
		const_remarks="";
		beyond_dsg_rsn="";
		item_concentration_percent="";//Added for ML-MMOH-CRF-1201
		item_volume ="";//Added for ML-MMOH-CRF-1201

		curr_group		= (String)initalDetails.get(i);
		curr_group_code	= (String)initalDetails.get(i+1);
		const_generic_code = (String)initalDetails.get(i+2);
		if(prevWSVls!=null && prevWSVls.size()>0){
		if (prevWSVls.size()>0){
			rec=(Hashtable)prevWSVls.get(j);
			ALLOC_QTY_UOM=(String)rec.get("ALLOC_QTY_UOM"+j);
			ITEM=(String)rec.get("ITEM_"+j);
			ALLOC_QTY=(String)rec.get("ALLOC_QTY_"+j);
			BATCH=(String)rec.get("BATCH_"+j);
			EXPIRY_DATE=(String)rec.get("EXPIRY_DATE_"+j);
			ISSUE_QTY=(String)rec.get("ISSUE_QTY_"+j);
			LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
			manufacture_var_percentage=(String)rec.get("manufacture_var_percentage"+j);
			trade_id=(String)rec.get("trade_id_"+j);
			bin_locn_code=(String)rec.get("bin_locn_code_"+j);
			concentration_percent=((String)rec.get("concentration_percent_"+j)).equals("")?"0":(String)rec.get("concentration_percent_"+j);
			QTY_UOM=(String)rec.get("QTY_UOM"+j);
			//ALLOC_QTY_UOM=(String)rec.get("ALLOC_QTY_UOM"+j);
			osmolar_value=(String)rec.get("osmolar_value_"+j);

			if(!osmolar_value.equals("") && !ITEM.equals("")){
				osmolar_value_lt = bean.roundTwoDigits((Float.parseFloat(osmolar_value) * Float.parseFloat(ISSUE_QTY) / 1000)+"");
			}
			if(!osmolar_value.equals("")){
					ws_osmo_value = ws_osmo_value + Float.parseFloat(String.valueOf(osmolar_value_lt)); 
			}
         if(!ISSUE_QTY.equals("")&&billing_interface_yn.equals("Y")){
            batch_str				  = new StringBuffer();
			//gross_charge_display_str  = new StringBuffer();
			//pat_charge_display_str    = new StringBuffer();

			batch_str.append(trade_id).append(";").append(BATCH).append(";").append(EXPIRY_DATE).append(";").append(bin_locn_code).append(";").append(ISSUE_QTY+"").append(";");
           double issued_qty                      =   Double.parseDouble(ISSUE_QTY);
           HashMap  chareg_det  = (HashMap)bean_2.callItemChargeDtls(patient_id,bean_1.getEncounterID(),bean_2.getEncounterPatientClass(bean_1.getEncounterID() , patient_id ), ITEM,issued_qty,batch_str.toString(), bean_1.getTodaysDate(),locn_code,"","",order_id,"1",bean_1.getDispStage(),dischargeIND); // patient_id for getEncounterPatientClass added for [IN:035667] 

            String err_msg   =(String)chareg_det.get("error_msg");

			decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			 if(err_msg.equals("")){
					

					if(!chareg_det.get("grosschargeamt").equals("null")){
						 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
					}
					if(!chareg_det.get("patnetamt").equals("null")){
						groos_pat_payable  = Float.parseFloat((String)chareg_det.get("patnetamt"));
					}

					 gross_charge_amount_str  = dfTest.format(gross_charge_amount);
					 groos_pat_payable_str    = dfTest.format(groos_pat_payable);

					gross_charge_display_str.append("<label style='font-size:10;color:black' id='groos_pat_payable_str_").append(j).append("'>").append( gross_charge_amount_str).append("</label>");

					pat_charge_display_str.append("<label style='font-size:10;color:black' id='gross_charge_amount_str_").append(j).append("'>").append(groos_pat_payable_str).append("</label>");	
			 }

				 if(!gross_charge_amount_str.equals("") && !groos_pat_payable_str.equals("")){
			 	     tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat(gross_charge_amount_str);
					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat(groos_pat_payable_str);

					 tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
					 tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
				 }

        }

		}
		}else if(tpn_wrk_sht_details!=null && tpn_wrk_sht_details.size() > 0){
			for(int tws=0; tws<tpn_wrk_sht_details.size(); tws+=15){
				osmolar_value = "";
				osmolar_value_lt = "";
				pres_qty_range = 0;
				range_buffer = new StringBuffer();
				if(const_generic_code.equals((String)tpn_wrk_sht_details.get(tws))){
					ALLOC_QTY_UOM=(String)tpn_wrk_sht_details.get(tws+1);
					ITEM=(String)tpn_wrk_sht_details.get(tws+2);
					ALLOC_QTY=(String)tpn_wrk_sht_details.get(tws+3);
					BATCH=(String)tpn_wrk_sht_details.get(tws+4);
					EXPIRY_DATE=(String)tpn_wrk_sht_details.get(tws+5);
					ISSUE_QTY=(String)tpn_wrk_sht_details.get(tws+6);
//					LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
					trade_id=(String)tpn_wrk_sht_details.get(tws+7);
					bin_locn_code=(String)tpn_wrk_sht_details.get(tws+8);
					stock_uom=(String)tpn_wrk_sht_details.get(tws+9);
					QTY_UOM=(String)tpn_wrk_sht_details.get(tws+10);
					equvl_value=(String)tpn_wrk_sht_details.get(tws+11);
					concentration_percent=(String)tpn_wrk_sht_details.get(tws+12);
					manufacture_var_percentage=(String)tpn_wrk_sht_details.get(tws+13);



         if(!ISSUE_QTY.equals("")&&billing_interface_yn.equals("Y")){
            batch_str				  = new StringBuffer();
			//gross_charge_display_str  = new StringBuffer();
			//pat_charge_display_str    = new StringBuffer();

			batch_str.append(trade_id).append(";").append(BATCH).append(";").append(EXPIRY_DATE).append(";").append(bin_locn_code).append(";").append(ISSUE_QTY+"").append(";");
           double issued_qty                      =   Double.parseDouble(ISSUE_QTY);
           HashMap  chareg_det  = (HashMap)bean_2.callItemChargeDtls(patient_id,bean_1.getEncounterID(),bean_2.getEncounterPatientClass(bean_1.getEncounterID(),patient_id ),ITEM, issued_qty, batch_str.toString(), bean_1.getTodaysDate(),locn_code,"","",order_id,"1",bean_1.getDispStage(),dischargeIND); // patient_id for getEncounterPatientClass added for [IN:035667] 

            String err_msg   =(String)chareg_det.get("error_msg");

			decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			 if(err_msg.equals("")){
					

					if(!chareg_det.get("grosschargeamt").equals("null")){
						 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
					}
					if(!chareg_det.get("patnetamt").equals("null")){
						groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
					}

					 gross_charge_amount_str  = dfTest.format(gross_charge_amount);
					 groos_pat_payable_str    = dfTest.format(groos_pat_payable);

					gross_charge_display_str.append("<label style='font-size:10;color:black' id='groos_pat_payable_str_").append(j).append("'>").append(gross_charge_amount_str).append("</label>");

					pat_charge_display_str.append("<label style='font-size:10;color:black' id='gross_charge_amount_str_").append(j).append("'>").append(groos_pat_payable_str).append("</label>");	
			 }
			  if(!gross_charge_amount_str.equals("") && !groos_pat_payable_str.equals("")){
			 	     tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat(gross_charge_amount_str);
					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat(groos_pat_payable_str);

					 tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
					 tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
			  }




        }


if((!((String)initalDetails.get(i+1)).equals("EL")) && !ALLOC_QTY.equals("")){
					pres_qty_range = new Float(Math.ceil((Float.parseFloat(String.valueOf(manufacture_var_percentage))/100)* Float.parseFloat(String.valueOf(ALLOC_QTY)))).intValue();
					min_qty =  Float.parseFloat(String.valueOf(ALLOC_QTY)) - pres_qty_range;
					max_qty =  Float.parseFloat(String.valueOf(ALLOC_QTY)) + pres_qty_range;
					range_buffer.append("( ");
					range_buffer.append(min_qty);
					range_buffer.append(" ~ ");
					range_buffer.append(max_qty);
					range_buffer.append(" )");
}
					osmolar_value=(String)tpn_wrk_sht_details.get(tws+14);
					if(!osmolar_value.equals("") && !ITEM.equals("")){
						osmolar_value_lt = bean.roundTwoDigits((Float.parseFloat(osmolar_value) * Float.parseFloat(ISSUE_QTY) / 1000)+"");
					}
					if(!osmolar_value.equals("")){
						ws_osmo_value = ws_osmo_value + Float.parseFloat(String.valueOf(osmolar_value_lt)); 
					}
					break;
				}
			}
		
		}else{
			dflt_lkp_vsblty = "hidden";
			if(!((String)initalDetails.get(i+7)).equals("")){
				ITEM = (String)initalDetails.get(i+7);
				dflt_lkp_vsblty = "visible";
			}else{
				ITEM = "";
				dflt_lkp_vsblty = "hidden";
			}
		}

	

%>

	<TR>
		<TD ALIGN="left" WIDTH="40%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">

<%
		if (!curr_group.equals(prev_group)) {
%>

			<td class= "COLUMNHEADER" ALIGN="left" COLSPAN="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<%= curr_group %></Td>

<%
		
		}
			const_remarks	  = (String)initalDetails.get(i+8);
			beyond_dsg_rsn	  = (String)initalDetails.get(i+9);
			not_to_be_ordered = (String)initalDetails.get(i+10);
			  //Adding start for ML-MMOH-CRF-1201
			  if(!ITEM.equals("")){
            itemvalues = bean.getItemValues(curr_group_code,ITEM);
			//System.err.println("itemvalues.size()===="+itemvalues.size());
			if(itemvalues.size()>0){
			for(int k=0;k<itemvalues.size();k+=2){
              item_concentration_percent =(String)itemvalues.get(k)==null?"":(String)itemvalues.get(k);
			  item_volume =(String)itemvalues.get(k+1)==null?"":(String)itemvalues.get(k+1);
			   }
			   }
			  }
		//	System.err.println("item_concentration_percent=-=="+item_concentration_percent+"item_volume==="+item_volume);
			//Adding end for ML-MMOH-CRF-1201
			String ordered_class = "label";
			if(not_to_be_ordered.equals("Y")){ordered_class = "AMENDEDDRUGS";}
%>

			<TR>
				<INPUT TYPE="hidden" name="CONST_GROUP_CODE_<%= j %>" id="CONST_GROUP_CODE_<%= j %>" VALUE="<%= initalDetails.get(i+1) %>">
				<INPUT TYPE="hidden" name="CONST_GENERIC_CODE_<%= j %>" id="CONST_GENERIC_CODE_<%= j %>" VALUE="<%= initalDetails.get(i+2) %>">
				<INPUT TYPE="hidden" name="CONST_REMARKS_<%= j %>" id="CONST_REMARKS_<%= j %>" VALUE="<%= initalDetails.get(i+8) %>">
				<INPUT TYPE="hidden" name="OVERRIDE_REASON_<%= j %>" id="OVERRIDE_REASON_<%= j %>" VALUE="<%= initalDetails.get(i+9) %>">
		
				<%if(beyond_dsg_rsn != null && !beyond_dsg_rsn.equals("")){
					ordered_class = "DOSELIMIT";
					%>
					<TD WRAP ALIGN="left" class="<%=ordered_class%>" WIDTH="5%" onclick="showOvrRsn('<%=beyond_dsg_rsn%>')" onMouseOVer="showToolTip(this,'<%=beyond_dsg_rsn%>')"><b>i</b>
					<%if(curr_group_code.equals("EL")){
						constPrecepInfo = (ArrayList)bean.getConstPreciptInfo((String)initalDetails.get(i+2));
			
						if(constPrecepInfo != null){
						%>
							<Label STYLE="font-size:9;cursor:pointer;color:blue" onclick="showPrecipitaionInfo('<%= initalDetails.get(i+2) %>')">
							<b>&nbsp; <img src="../../ePH/images/information.gif" align="center"></img></b>
							</Label>
						<%}else{%>
							<b>	&nbsp;</b>
						<%}
					 }else{%>
						<b>	&nbsp;</b>
					<%}%>
					</TD>
				<%}else{%>
					<TD WRAP ALIGN="left" CLASS="<%=ordered_class%>" WIDTH="5%"><LABEL ID="remarks_<%= j %>" STYLE="font-size:9">&nbsp;</LABEL> 
					<%if(curr_group_code.equals("EL")){
						constPrecepInfo = (ArrayList)bean.getConstPreciptInfo((String)initalDetails.get(i+2));

						if(constPrecepInfo != null){
						%>
							<Label STYLE="font-size:9;cursor:pointer;color:blue" onclick="showPrecipitaionInfo('<%= initalDetails.get(i+2) %>')">
							<b>&nbsp; <img src="../../ePH/images/information.gif" align="center"></img></b>
							</Label>
						<%}else{%>
							<b>	&nbsp;&nbsp;</b>
						<%}
					 }else{%>
						<b>	&nbsp;&nbsp;</b>
					<%}%>
					</TD>
				<%}%>

				<%if(const_remarks != null && !const_remarks.equals("")){%>
					<TD WRAP ALIGN="left" CLASS="label" WIDTH="21%"><LABEL ID="CONST_GENERIC_NAME_<%= j %>" STYLE="font-size:9;cursor:pointer;color:blue" onclick="showRemarks('<%=const_remarks%>')" onMouseOVer="showToolTip(this,'<%=const_remarks%>')" ><%= initalDetails.get(i+3) %></LABEL></TD>
				<%}else{%>
					<TD WRAP ALIGN="left" CLASS="label" WIDTH="21%"><LABEL ID="CONST_GENERIC_NAME_<%= j %>" STYLE="font-size:9"><%= initalDetails.get(i+3) %></LABEL></TD>
				<%}%>

				

				<TD ALIGN="left" CLASS="label" WIDTH="18%">
				<%if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid") ){%>				
					<INPUT TYPE="text" ALIGN="right" CLASS="number" name="ORDER_QTY_<%= j %>" id="ORDER_QTY_<%= j %>" VALUE="<%= initalDetails.get(i+4) %>" READONLY SIZE="3">&nbsp;<LABEL ID="ALLOC_QTY_UOM_<%= j %>" STYLE="font-size:9"><%= initalDetails.get(i+5) %></LABEL>
				<%}else{%>
					<INPUT style="visibility:hidden" TYPE="text" ALIGN="right" CLASS="number" name="ORDER_QTY_<%= j %>" id="ORDER_QTY_<%= j %>" VALUE="<%= initalDetails.get(i+4) %>" READONLY SIZE="3"><label STYLE="font-size:9;visibility:visible"></label>&nbsp;<LABEL ID="ALLOC_QTY_UOM_<%= j %>" STYLE="font-size:9;visibility:visible"></LABEL>
				<%}%>
				<INPUT TYPE='HIDDEN' NAME ="ALLOC_QTY_UM_<%=j%>" VALUE="<%=initalDetails.get(i+5)%>">
				<INPUT TYPE="hidden" name="VARIANCE_<%= j %>" id="VARIANCE_<%= j %>" VALUE="<%= initalDetails.get(i+6) %>">
				</TD>

				<TD ALIGN="left" CLASS="label" WIDTH="21%" nowrap>
				<%if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid") ){%>				
					<INPUT TYPE="text" ALIGN="left" CLASS="number" name="OVERAGE_ORDER_QTY_<%= j %>" id="OVERAGE_ORDER_QTY_<%= j %>" VALUE="<%= initalDetails.get(i+4) %>" READONLY SIZE="3">&nbsp;&nbsp;<LABEL ID="item_limits_<%= j %>" STYLE="font-size:9"><%=range_buffer.toString()%></LABEL>
				<%}else{%>
					<INPUT style="visibility:hidden" TYPE="text" ALIGN="left" CLASS="number" name="OVERAGE_ORDER_QTY_<%= j %>" id="OVERAGE_ORDER_QTY_<%= j %>" VALUE="0" READONLY SIZE="3"><label STYLE="font-size:9;visibility:visible"></label>&nbsp;&nbsp;&nbsp;<LABEL ID="item_limits_<%= j %>" STYLE="font-size:9;visibility:hidden"></LABEL>
				<%}%>
				<INPUT TYPE='HIDDEN' NAME ="ALLOC_QTY_UM1_<%=j%>" VALUE="<%=initalDetails.get(i+5)%>"><INPUT TYPE="hidden" name="VARIANCE1_<%= j %>" id="VARIANCE1_<%= j %>" VALUE="<%= initalDetails.get(i+6) %>">
				</TD>

				<TD ALIGN="left" CLASS="label" WIDTH="18%">
				<%if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid")){%>				
					<INPUT TYPE="text" ALIGN="right" CLASS="number" name="ALLOC_QTY_<%= j %>" id="ALLOC_QTY_<%= j %>" VALUE="<%=ALLOC_QTY%>" READONLY SIZE="3" >&nbsp;&nbsp;<LABEL ID="ALLOC_QTY_UOM<%= j %>" STYLE="font-size:9"><%=ALLOC_QTY_UOM%></LABEL>
				<%}else{%>
					<INPUT style="visibility:hidden" TYPE="text" ALIGN="right" CLASS="number" name="ALLOC_QTY_<%= j %>" id="ALLOC_QTY_<%= j %>" VALUE="<%=ALLOC_QTY%>" READONLY SIZE="3">&nbsp;&nbsp;<LABEL ID="ALLOC_QTY_UOM<%= j %>" STYLE="font-size:9;visibility:hidden"><%=ALLOC_QTY_UOM%></LABEL>
				<%}%>
				<INPUT TYPE='HIDDEN' NAME ="ALLOC_QTY_UM<%=j%>" VALUE="<%=ALLOC_QTY_UOM%>"></TD>
			</TR>
			</TABLE>
		</TD>
		<TD ALIGN="left" WIDTH="1%" STYLE="background-color:white">&nbsp;</TD>
		<TD ALIGN="right" WIDTH="59%">

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">

<%
		if (!curr_group.equals(prev_group)) {
%>

			<td class= "COLUMNHEADER"  ALIGN="left" COLSPAN="6">&nbsp;</td>

<%
			prev_group = curr_group;
		}
%>          

			<TR>
				

	   <TD ALIGN="left" CLASS="label" WIDTH="40%" nowrap>
			<SELECT name="ITEM_<%= j %>" id="ITEM_<%= j %>" onchange="assignval(this,'<%= locn_code %>','<%= j %>');if(document.formTPNWorkSheetDetails.CONST_GROUP_CODE_<%=j%>.value=='EL')populateIssueQty(this,'<%=order_id%>','<%=j%>');GetBillingDetails('<%= j %>','Y');">
			<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -------------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
				<%	String item = "";
					String desc	= "";
					System.err.println("@2@@@==="+(String)initalDetails.get(i+2)+"order_id==="+order_id+"locn_code==="+locn_code);
					ArrayList item_list	= bean.getItemList((String)initalDetails.get(i+2), order_id, locn_code,tpn_change_mmoh,patient_id);//tpn_change_mmoh,patient_id added for ML-MMOH-CRF-1201

					String selected="";
					if(item_list != null){
							 for(int t=0;t<item_list.size();t+=2){
								 item=(String)item_list.get(t);
								 desc=(String)item_list.get(t+1);
								 if (item.equals(ITEM)){
									 selected="selected";
								 }else{
									selected="";
								 }

				%>
				<OPTION VALUE="<%= item %>" <%=selected%>><%= desc %></OPTION>

				<%
					}}
				%>

				</SELECT><input style="visibility:<%=dflt_lkp_vsblty%>" type="button" class="button" name="dflt_item_search_<%= j %>" value="?" onclick="assignval('','<%= locn_code %>','<%= j %>');if(document.formTPNWorkSheetDetails.CONST_GROUP_CODE_<%=j%>.value=='EL')populateIssueQty('','<%=order_id%>','<%=j%>');">
				<label class="label" id="osmolar_value_lb_<%= j %>" name="Osmo_<%= j %>"><%=osmolar_value_lt%></label><INPUT TYPE="hidden" name="osmolar_value_<%= j %>" id="osmolar_value_<%= j %>" VALUE="<%=osmolar_value%>" >
			</TD>

			
				<TD ALIGN="left" CLASS="label" WIDTH="14%" STYLE="font-weight:bold;" nowrap><label class="label" id="BATCH_<%= j %>" name="BATCH_<%= j %>"><%=BATCH%></label></TD>

				<TD ALIGN="left" CLASS="label" WIDTH="14%" STYLE="font-weight:bold;" nowrap><label class="label" id="EXPIRY_DATE_<%= j %>" name="EXPIRY_DATE_<%= j %>"><%=EXPIRY_DATE%></label></TD>
				
				<TD ALIGN="left" CLASS="label" WIDTH="14%">
					<INPUT TYPE="hidden" name="AVAIL_QTY_<%= j %>" id="AVAIL_QTY_<%= j %>" VALUE="" ><INPUT TYPE="text" ALIGN="right" CLASS="number" name="ISSUE_QTY_<%= j %>" id="ISSUE_QTY_<%= j %>" SIZE="6" MAXLENGTH="<%=iMaxLength%>" onKeyPress="return allowValidNumber(this,event,4,<%=iNoOfDecimals%>)" onBlur="if(validateNumbers(this,4,'<%=iNoOfDecimals%>')){checkForTPNItemSelect(this,'<%= j %>');checkIsNotZero(this, 'Issue Quantity', '<%= j %>');GetBillingDetails('<%= j %>');if(document.formTPNWorkSheetDetails.CONST_GROUP_CODE_<%=j%>.value=='EL'){checkPrecipitation(this,'<%=j%>');};}" value='<%=ISSUE_QTY%>'>&nbsp;<LABEL ID="QTY_UOM<%= j %>" STYLE="font-size:9;font-weight:bold;"><%=QTY_UOM%></LABEL>
					<input type="hidden"  name="issued_stock_uom_<%=j%>" id="issued_stock_uom_<%=j%>" value="<%=stock_uom%>">
					<input type="hidden"  name="order_uom<%=j%>" id="order_uom<%=j%>" value="">
					<input type="hidden"  name="ISSUE_QTY1_<%=j%>" id="ISSUE_QTY1_<%=j%>" value="">
					<INPUT TYPE="hidden" name="Eqvl_value_<%=j%>" id="Eqvl_value_<%=j%>" VALUE="<%=equvl_value%>">
					<input type="hidden"  name="concentration_percent_<%=j%>" id="concentration_percent_<%=j%>" value="<%=concentration_percent%>">
					<input type="hidden"  name="LastDerivedValue<%=j%>" id="LastDerivedValue<%=j%>" value="<%=LastDerivedValue%>">	
					<input type="hidden"  name="manufacture_var_percentage<%=j%>" id="manufacture_var_percentage<%=j%>" value="<%=manufacture_var_percentage%>">
					
					<input type="hidden" name='trade_id_<%=j%>' id='trade_id_<%=j%>' value='<%=trade_id%>'>
					<input type="hidden" name='bin_locn_code_<%=j%>' id='bin_locn_code_<%=j%>' value='<%=bin_locn_code%>'>
                    <input type="hidden" name='item_concentration_percent_<%=j%>' id='item_concentration_percent_<%=j%>' value=""><!-- added for ML-MMOH-CRF-1201 -->
                    <input type="hidden" name='item_volume_<%=j%>' id='item_volume_<%=j%>' value=""><!-- added for ML-MMOH-CRF-1201 -->
				</TD>

               <%if(billing_interface_yn.equals("Y")){%>
			      <TD ALIGN="left" CLASS="label" WIDTH="11%" STYLE="font-weight:bold;" id='td_gross_charge_amount_str_<%=j%>'><%=gross_charge_display_str.toString()%></TD>
			      <TD ALIGN="left" CLASS="label" WIDTH="11%" STYLE="font-weight:bold;" id='td_groos_pat_payable_str_<%=j%>'><%=pat_charge_display_str.toString()%></TD>
				  
	              <input type="hidden"  name="gross_charge_amount_<%=j%>" id="gross_charge_amount_<%=j%>" value="<%=gross_charge_amount_str%>">
				  <input type="hidden"  name="groos_pat_payable_<%=j%>" id="groos_pat_payable_<%=j%>"   value="<%=groos_pat_payable_str%>">


              <%
				  gross_charge_display_str  = new StringBuffer();
			      pat_charge_display_str    = new StringBuffer();
				  
			  }%>



			</TR>
			</TABLE>
		</TD>
	</TR>

<%	
}
%>

	</TABLE>
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%= locn_code %>">
	<INPUT TYPE="hidden" name="order_id" id="order_id" VALUE="<%= order_id %>">
	<INPUT TYPE="hidden" name="row_count" id="row_count" VALUE="<%= j %>">
	<INPUT TYPE="hidden" name="item_count" id="item_count" VALUE="">
	<INPUT TYPE="hidden" name="patient_id" id="patient_id" VALUE="<%=patient_id%>">
	<!-- <INPUT TYPE="hidden" name="Eqvl_value" id="Eqvl_value" VALUE=""> -->
	<INPUT TYPE="hidden" name="ordered_volume" id="ordered_volume" VALUE="<%=ordered_volume%>">
	<INPUT type="hidden" name='presc_base_unit' id='presc_base_unit' value='<%=presc_base_unit%>'>
	<INPUT type="hidden" name='decimal_format_string' id='decimal_format_string' value='<%=decimalFormatString%>'>
	<INPUT type="hidden" name='dischargeIND' id='dischargeIND' value='<%=dischargeIND%>'>
    <INPUT type="hidden" name='tpn_change_mmoh' id='tpn_change_mmoh' value='<%=tpn_change_mmoh%>'><!-- Added for ML-MMOH-CRF-1201 -->
   </FORM>
		<SCRIPT>
	   

		
		<%if((tpn_vals != null) && (tpn_vals.size() >0) ){%>

			//parent.messageFrame.document.formTPNWorkSheetButtons.fluid_volume.value = '<%=tpn_qty%>';
			//parent.messageFrame.document.getElementById("fluid_uom").innerText = '<%=tpn_uom%>';
			//params='<%=params%>' + "&tpn_qty="+'<%=tpn_qty%>'+"&tpn_uom="+'<%=tpn_uom%>';

		<%}%>
			//calOvrgeOrdQty(parent.commontoolbarFrame.document.formTPNWorkSheetHeader.overage_volume);
		   // calOvrgeOrdQty(parent.f_query_add_mod.document.formTPNWorkSheetDetails.overage_volume);

		<%if((tpn_wrk_sht_details != null && tpn_wrk_sht_details.size() > 0) || (prevWSVls!=null && prevWSVls.size()>0)){
				ws_osmo_value_lt = bean.roundTwoDigits(((ws_osmo_value*1000) /Float.parseFloat(tpn_qty))+"");
			
			%>
			document.formTPNWorkSheetDetails.overage_volume.readOnly = true;
			//parent.messageFrame.document.formTPNWorkSheetButtons.osmolarity_volume.value = '<%=ws_osmo_value%>';
			//parent.messageFrame.document.formTPNWorkSheetButtons.osmolarity_volume_per_ltr.value = '<%=ws_osmo_value_lt%>';
			//params=params + "&ws_osmo_value="+'<%=ws_osmo_value%>'+"&ws_osmo_value_lt="+'<%=ws_osmo_value_lt%>';
			parent.messageFrame.location.href="../../ePH/jsp/TPNWorkSheetButtons.jsp?"+'<%=params%>'+"&tot_groos_pat_payable_str="+'<%=tot_groos_pat_payable_str%>'+"&tot_gross_charge_amount_str="+'<%=tot_gross_charge_amount_str%>'+ "&ws_osmo_value="+'<%=ws_osmo_value%>'+"&ws_osmo_value_lt="+'<%=ws_osmo_value_lt%>'+ "&tpn_qty="+'<%=tpn_qty%>'+"&tpn_uom="+'<%=tpn_uom%>';

		<%}else{%>
            parent.messageFrame.location.href="../../ePH/jsp/TPNWorkSheetButtons.jsp?"+'<%=params%>'+"&tot_groos_pat_payable_str="+'<%=tot_groos_pat_payable_str%>'+"&tot_gross_charge_amount_str="+'<%=tot_gross_charge_amount_str%>';

		<%}%>

		</SCRIPT>
				
<%	
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_1,bean_1,request);

		}catch(Exception e){
	         e.printStackTrace();
        } finally{ // Adding start for ML-MMOH-CRF-1201
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}// Adding end for ML-MMOH-CRF-1201
%>

</BODY>
</HTML>

