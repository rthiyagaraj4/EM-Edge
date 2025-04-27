<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017	MMS-DM-SCF-0417   Manickavasagam	Allocated Quantity is showing wrong when the batch gets expired before Allocated days
04/19/2017	BSP-SCF-0041	  Mukesh		Allocated Quantity is showing wrong when the batch gets expired before Allocated days		 
08/10/2020	IN73611             Shazana		MMS-DM-CRF-0174.4
7/7/2021		TFS:9495	Shazana					MOHE-CRF-0026.1
10/12/2022     TFS:37091       Erappa             TH-KW-CRF-0020.3
--------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ page import ="java.sql.*,webbeans.eCommon.*"%> <!-- 37091 added -->
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
		String facility_id		=   (String) session.getValue("facility_id");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String user_id = ((String)session.getValue("login_user")) == null ? "" : (String)session.getValue("login_user");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PPNRegimen.js"></script>
		<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>   
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
		table>*
        {
        	white-space: nowrap;
        }      
        
</style>
	</head>
<%
	Connection con			= null;  // added for AAKH-CRF-0117
	
	
try{//moved try above for MOHE-CRF-0026.1
	con				= ConnectionManager.getConnection(request);//moved from above in try block
	boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117
	boolean iqvia_integration_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","IQVIA_INTEGRATION");//MOHE-CRF-0026.1   
	boolean queue_pkid_appl =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_QMS_PATIENT_DTLS");//TH-KW-CRF-0020.3
	
	String settlement_id = "";  
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	
	String bean_id_1 = "DispMedicationAllStages" ;
	String bean_name_1 = "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;
	MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
	medplan_bean.clearMedPlan_DrugDetails();
	medplan_bean.clearMedPlan_Local_DrugDetails();
	medplan_bean.setStrTotal_gross_charge_amount("");
	medplan_bean.clearMediPlanSeqNo();
	medplan_bean.setMedValuesChanged(false);// Added for Bru-HIMS-CRF-072.1 [IN:049144] end
	String disp_stage = bean.getDispStage();	
	String order_id = request.getParameter("order_id");
	String patient_id = request.getParameter("patient_id");
	String sDispLocnCatg	=	bean.getDispLocnCatg();
	bean.setApprovalNoFlag(approval_no_flag);//AAKH-CRF-0117
	bean.setPatientID(patient_id);
	String barcode_flg="N";//Added for Bru-HIMS-CRF-076 [IN:034551]
	String iv_prep_yn = request.getParameter("iv_prep_yn");
	String fill_list = bean.getFillList();
	//Ading start for MMS-DM-CRF-157.1
	//con = ConnectionManager.getConnection(request);
      bean.setBarcodeSiteYN(con);
	  
	  String bar_code_scan_site_YN= bean.getBarcodeSiteYN();
//Ading end for MMS-DM-CRF-157.1
	
	boolean sPPNFlag	 = request.getParameter("PPNFlag")!=null?true:false; // This flag is used to stop reseting the filling page
																			 // if its from "Remove PPN" link
	// In the query criteria if the order type is "ALL" and the orders are admx orders then the order id should be set to ""
	if(iv_prep_yn != null && (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR")) && !(iv_prep_yn.equals("2") || iv_prep_yn.equals("4") || iv_prep_yn.equals("0") || iv_prep_yn.equals("6"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		order_id = "";
	}

	String selectedOrderType = "";
	if(bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR")){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		if(iv_prep_yn == null || iv_prep_yn.equals("null"))
			selectedOrderType = "NOR";
		else if(iv_prep_yn.equals("1"))
			selectedOrderType = "IVAD";
		else if(iv_prep_yn.equals("2"))
			selectedOrderType = "IVAA";
		else if(iv_prep_yn.equals("3"))
			selectedOrderType = "IVID";
		else if(iv_prep_yn.equals("4"))
			selectedOrderType = "IVIA";
		else if(iv_prep_yn.equals("5"))
			selectedOrderType = "IVWA";
		else if(iv_prep_yn.equals("6"))
			selectedOrderType = "CO";
		else if(iv_prep_yn.equals("7"))
			selectedOrderType = "TD";
		else if(iv_prep_yn.equals("8"))
			selectedOrderType = "TA";
		else if(iv_prep_yn.equals("9"))
			selectedOrderType = "CD";
		else if(iv_prep_yn.equals("0"))
			selectedOrderType = "CA";

		bean.setOrderType(selectedOrderType);
	}
	
	selectedOrderType		= bean.getOrderType(); // this is required in case of specific order type search instead of ALL 
	String strOrderIds =  request.getParameter("orderIDS_trxRefIDS");
	// 1 - IV with additives (without admixture)
	// 2 - IV with additives( with admixture)
	// 3 - IV with piggy back( without admixture)	
	// 4 - IV with piggy back( with admixture)	
	// 5 - IV Without additives( continuous)
	// 6 - Compound Rx
	// 7 - TPN Standard Regimen (TPN Direct)
	// 8 - TPN Non-Standard Regimen (TPN Admixture)
	//out.println("iv_prep_yn"+iv_prep_yn);

   String disable_yn  ="";
   boolean bChangeValues = true;
	 if(((disp_stage.equals("F") && (bean.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean.getFillingStatus().equals("B")  )))&&(!bean.getDispLocnCatg().equals("I")) ){
	 	if(selectedOrderType.equals("IVAA") || selectedOrderType.equals("IVIA") || selectedOrderType.equals("CA") ||  selectedOrderType.equals("CO")){
			bChangeValues = false;
			disable_yn = "Y";
		}
		else{
			bean.setDurations(order_id);
			bChangeValues= bean.getEditValues();
			if(!bChangeValues)
				disable_yn = "Y";
		}
	}
	String	sDisableEditLabel	= "";
	String	sShowEditLabel	="";//display:none";
    String  billing_interface_yn =	request.getParameter("billing_interface_yn")==null?"N":request.getParameter("billing_interface_yn");
	String  encounter_id		 =	bean.getEncounterID();
	String  disp_locn_code	     =  bean.getDispLocnCode();
	String  store_desc           =  bean.getStoreDesc(disp_locn_code);
    String  orderIDS_trxRefIDS   =  request.getParameter("orderIDS_trxRefIDS");
	String  sysdate				 =  bean.getTodaysDate();
    String  order_type			 =	bean.getOrderType();
	String strDispLocationCategory = bean.getDispLocnCatg()==null?"":bean.getDispLocnCatg();
	String strDuration = "";
	String strDurationType = "";
	String alloc_durn_display="visibility:visible";
	String  bl_patient_class     =  bean_1.getEncounterPatientClass(encounter_id, patient_id);  // patient_id  added for [IN:035667] 
	if(bChangeValues){
		sDisableEditLabel		="<font style='font-size:10px;cursor:pointer;color:blue;'  onclick=openEditLabel('"+patient_id+"','edit','"+bl_patient_class+"')>";
	}
	else{
         sDisableEditLabel		="<font style='font-size:10px;color:gray;'>";
	}

	if(disp_stage.equals("V"))
		sShowEditLabel	="display:none";
	if(selectedOrderType.equals("IVAA") || selectedOrderType.equals("IVIA") || selectedOrderType.equals("CA") || selectedOrderType.equals("TA") || selectedOrderType.equals("TD") || selectedOrderType.equals("CO")|| !bean.getBEditDispLabelAfterDisp())
		sShowEditLabel	="display:none";

	String chk_group_by_patient	= bean.getChkGroupByPatient();
	if(chk_group_by_patient==null)
		chk_group_by_patient="E";
	Hashtable param_legends = bean.getLegendsFromParam();
	String issue_token_on_regn_yn = bean.getIssueTokenOnRegnYN();
	bean.setOrderID(order_id.trim());
	bean.setOrderID1(order_id.trim());

	String params		=	request.getQueryString();
	String disp_level	=	bean.getDispLevelValue();
	String colspan		=	"1";

	if(patient_id==null || patient_id.equals(""))
		patient_id      =bean.getSelectedPatientID();

    String scope        ="";
	if( (bean.getDispLocnCatg()).equals("I")) {
		scope				=	bean.getIPScope();
	} 
	else {
		scope				=	bean.getScope();
	}
	String butt_status			= ""; 
	if(scope.equals("H")){
        butt_status="disabled";
	}
	else{
		butt_status="";
	}
    String disp_butt_status			= ""; 
	if(disable_yn.equals("Y")){
          disp_butt_status="disabled";
	}
	else{
		  disp_butt_status="";
	}
	if(strDispLocationCategory.equals("O")){
		strDuration = bean.getStrOPDispPeriod();
		strDurationType = "D";
	}
	else if(strDispLocationCategory.equals("I")){
		if(fill_list.equals("WF")){ /* if block added for SRR20056-CRF-0663 */
			strDuration = bean.getIPFillDispPeriod();
			strDurationType = bean.getIPFillDispPeriodUnit();
		}
		if(strDuration==null || strDuration.equals("")|| strDurationType==null || strDurationType.equals("")) {/* if condition alone added for SRR20056-CRF-0663 */
			strDuration = bean.getStrIPFillPeriodAhead();
			strDurationType = bean.getStrIPFillPeriodUnit();
		}
		if(strDurationType.equals("P")){
			alloc_durn_display="display:none";
			strDuration        ="999";
			strDurationType    ="D";
		}
	}
	else{
		strDuration = "1";
		strDurationType = "D";
	}
	// If the page is loaded after the close of the Fill or allocate window, we need to restore the durn value from the window
	if(bean.getStrChangedDispensePeriod()!=null && !bean.getStrChangedDispensePeriod().equals("")){
		strDuration = bean.getStrChangedDispensePeriod();
		strDurationType = bean.getStrChangedDispenseUnit();
	}

	bean.setFillPeriod(strDuration);
	bean.setFillUnit(strDurationType);
	String prevEncouterID = bean.getPrevVisitEncounter(patient_id, encounter_id);
	//Added for Bru-HIMS-CRF-076 [IN:034551]
	bean.getBarCodeflg(facility_id,disp_locn_code);
	if(bean.getBarcode_Scan_YN().equals("Y")){
	    barcode_flg="Y";
	}  
	settlement_id = bean.getBillingGrp(patient_id, locale); //added for MOHE-CRF-0026.1 
	bean.setSettlementId(settlement_id);////end    
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="setfldFocus('<%=barcode_flg%>')"><!-- Added for Bru-HIMS-CRF-076 [IN:034551] -->
		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
				<tr >
<%
					if(prevEncouterID!=null && !prevEncouterID.equals("")){ //Added for RUT-CRF-0036[Inc:29925]
%>
						<td  width="9%" style="background-color:#fde6d0;">
						<font style='font-size:10px;cursor:pointer;color:blue;' class="HYPERLINK" onClick="showLastViewMedication('<%=patient_id%>','<%=encounter_id%>')"><b>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.LastVisitRX.label" bundle="${ph_labels}"/><b></font>  
						</td>
<%
					}
%>

					<td  nowrap  width="9%" style="background-color:#fde6d0;<%=sShowEditLabel%>"><%=sDisableEditLabel%><b><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}" /></b></font></td>
					<td  nowrap  width="9%" style="background-color:#fde6d0;<%=sShowEditLabel%>;"><font style='font-size:10px;cursor:pointer;color:blue;'  onclick="openEditLabel('<%=patient_id%>','preview','<%=bl_patient_class%>')"><b><fmt:message key="Common.Preview.label" bundle="${common_labels}"/> <fmt:message key="Common.Label.label" bundle="${common_labels}"/></b></font></td>
<% 
				if(disp_level.equals("P")) {	
					colspan	="5";	
				}	
				else{	
%>
					<td  nowrap  width="9%" style="font-size:10px;background-color:#fde6d0"><b><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></b></td>
					<td  style="font-size:10px;background-color:#fde6d0" width="18%">&nbsp;<b><%=order_id%></b></td>
					<td  nowrap  width="9%" style="font-size:10px;background-color:#fde6d0" >&nbsp;<b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> :</b></td>
					<td  style="font-size:10px;background-color:#fde6d0" width="18%">&nbsp;<b><%=patient_id%></b></td>
<%
				}
				if(iv_prep_yn.equals("7") && disp_stage.equals("F")){
					String sPPNOpenFontStyle	= "";
					String sOpenPPN				= "";
					String sPPNRemoveFontStyle	= "";
					String sRemovePPN			= "";
					if(bean.getHmPPNValues() == null){
						sPPNOpenFontStyle	= "cursor:pointer;color:blue;";
						sPPNRemoveFontStyle	= "";				
						sOpenPPN			= "onclick=\"openAddPPN('"+patient_id+"','"+order_id+"','"+params+"')\" ";
						sRemovePPN	= "";
					}
					else{
						sPPNOpenFontStyle	= "";
						sPPNRemoveFontStyle	= "cursor:pointer;color:blue;";
						sOpenPPN		= "";
						sRemovePPN	= "onclick=openRemovePPN('"+params+"')";
					}
%>
					<td style="background-color:#fde6d0" align = "center" nowrap ><b><font style="font-size:9px;<%=sPPNOpenFontStyle%>" <%=sOpenPPN%>  id ="AddPPNLbl"> <fmt:message key="ePH.AddPPN.label" bundle="${ph_labels}"/></B> </font> </td>
					<td style="background-color:#fde6d0;" align = "center" nowrap ><b><font style="font-size:9px;<%=sPPNRemoveFontStyle%>" <%=sRemovePPN%> id ="RemovePPNLbl" > <fmt:message key="ePH.RemovePPN.label" bundle="${ph_labels}"/></font></B> </td>
<%
				}
				 //if(!order_type.equals("CO")&&!order_type.equals("IVAA")&&!order_type.equals("IVIA")&&!order_type.equals("CA")&&!order_type.equals("TA")){
				 if(!order_type.equals("TD")&&!order_type.equals("TA")){
					if(disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")) {
%>
						<td  nowrap  width="20%" colspan="<%=colspan%>"   align="right" style="font-size:10px;background-color:#fde6d0" >&nbsp;<b><a  style ='font-size:9px' href="javascript:callMedicalItemdetails('<%=patient_id%>','<%=encounter_id%>','<%=disp_stage%>','<%=billing_interface_yn%>','<%=disp_locn_code%>','<%=bl_patient_class%>','<%=orderIDS_trxRefIDS%>','<%=sysdate%>','<%=store_desc%>')"><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/> </a></b></td>
<%
					}
				}
				 if((disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D") || disp_stage.equals("AS")) && sDispLocnCatg.equals("O") && selectedOrderType.equals("NOR") && bean.getMedicationPlannerYN().equals("Y")) {	// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					 medplan_bean.setStrCalledFrom("Dispensing");
%>			
		 			<td  nowrap  width="10%"  style="font-size:10px;background-color:#fde6d0" >&nbsp;<b><a  style ='font-size:9px' href="javascript:callMedicationPlanner('<%=patient_id%>','<%=encounter_id%>','','')"><fmt:message key="ePH.MedicationPlanner.label" bundle="${ph_labels}"/> </a></b></td>
<%				}
				if(!disp_stage.equals("V") && !disp_stage.equals("D")&& disp_butt_status.equals("") && !fill_list.equals("AF")){ 
%>
					<td style="font-size:10px;background-color:#fde6d0" width="2%" align = "right" nowrap style="<%=alloc_durn_display%>"> <fmt:message key="ePH.ALLOCATEDFOR.label" bundle="${ph_labels}"/> </td>
					<td class="label" width="9%" nowrap style="<%=alloc_durn_display%>"> <input size="3" maxlength="3" type = "text" name ="durationVal" value = "<%=strDuration%>" style="text-align:right" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}" onchange=" changeDurationValue(this,document.DispMedicationAllStages);">&nbsp;
						<select name="durnType" id="durnType" onchange="changeDurationValue(document.DispMedicationAllStages.durationVal,document.DispMedicationAllStages)" >
<%
						if(strDispLocationCategory.equals("I")){
%>
							<option value= "H"><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
<%
						}
%>
						<option value= "D" ><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
						<option value= "W" > <fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
						<option value= "M" > <fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
<%	
				}
				//Added for Bru-HIMS-CRF-076 [IN:034551]
				if(barcode_flg.equals("Y") && !disp_stage.equals("V") && !disp_stage.equals("D")){ 
					bean.getStockDtl().put("barcode_applicable",barcode_flg);	
					if(bar_code_scan_site_YN.equals("Y")){//If considition added for MMS-DM-CRF-0157.1
%>

					<td  width="20%"  style='text-align:right;'>Barcode<input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right"  onkeydown="if (event.keyCode==13 || event.keyCode==17) {callBarcodeflg(event,'<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');}" maxlength="100" size=50  >
					<!--Modified for IN073611 increased size to 80 -->			
					</td>
<%			    
				}else{
						%>
					<td  width="30%"  style='text-align:right;'>Barcode <input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right"  onkeydown="if (event.keyCode==13) {callBarcodeflg('','<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');}" maxlength="100"  ><!-- added '' begining for MMS-DM-CRF-0157.1 --> 
					</td>
<%
				}
				}else{
					bean.getBarCodesForDrug().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getStockDtl().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getOrderDrugdtl().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getDrugQty().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.setBarcode_multi_id("N");//Added for KDAH-CRF-0231 [IN-034551]
				}

			          //added for TH-KW-CRF-0020.3 start
		              if(queue_pkid_appl && ( disp_stage.equals("AS"))){
		 %>
			           <td   width="50%"  style='text-align:left;'><font style='font-size:10px;'>Queue PKID</font> 
			           <input id='quePkiId' name='quePkiId' id='quePkiId' type=text size="25" value='' onBlur="getQUEPKICode(this)">
			           <label name="quePkiId_res_name" id="quePkiId_res_id" value="" />
			           </td>
			
			<%     
			
				//added for TH-KW-CRF-0020.3 end
		}
				if(approval_no_flag && !disp_stage.equals("V")) //added for AAKH-CRF-0117 - start
				{
				
%>
				<td align="right" nowrap><label><fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/></label> 
				<input type="text" value="" maxlength="20" name="approval_no" id="approval_no" onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'H');"><!-- modified for AAK-CRF-0117-->
				<input type="button" value="Add" onclick="getApprovalNum(this)"></td>
<%
				} //added for AAKH-CRF-0117 - end
				//added for GHL-CRF-0453 
				if(iv_prep_yn==null)
					iv_prep_yn="";
				if(((disp_stage.equals("F")) || (disp_stage.equals("A"))) && !fill_list.equals("AF")){	// Added for IN064793 
%>
				<td class="white" align="right"><input type="button" value="Print" class="button" onclick = "printPresAllocateAndFill('<%=disp_stage%>','<%=iv_prep_yn%>')"></td><!-- GHL-CRF-453 and quotes added for GHL-SCF-1268-->

<%}%>
		       <%   //added for TH-KW-CRF-0020.3 start
	              if(queue_pkid_appl && (disp_stage.equals("A") )){
	 %>
		           <td   width="50%" align="left" nowrap ><font style='font-size:10px;'>Queue PKID</font> 
		           <input id='quePkiId' name='quePkiId' id='quePkiId' type=text size="25" value='' onBlur="getQUEPKICode(this)">
		           <label name="quePkiId_res_name" id="quePkiId_res_id" value="" />
		           </td>
		          
		
		<%     
		
			//added for TH-KW-CRF-0020.3 end
	}%>
	<input type=hidden id="queue_pkid_appl" name="queue_pkid_appl" id="queue_pkid_appl" value="<%=queue_pkid_appl%>"/> <!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiStatus" name="quePkiStatus" id="quePkiStatus" value=""/><!--  //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiStatusText" name="quePkiStatusText" id="quePkiStatusText" value=""/><!-- 	//added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiToken" name="quePkiToken" id="quePkiToken" value=""/><!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiNumber" name="quePkiNumber" id="quePkiNumber" value=""/><!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiIsueDateTime" name="quePkiIsueDateTime" id="quePkiIsueDateTime" value=""/><!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="quePkiCallDateTime" name="quePkiCallDateTime" id="quePkiCallDateTime" value=""/>	<!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>"/><!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="referenceId" name="referenceId" id="referenceId" value=""/><!-- //added for TH-KW-CRF-0020.3 -->
	<input type=hidden id="user_id" name="user_id" id="user_id" value="<%=user_id%>"/><!-- //added for TH-KW-CRF-0020.3 -->
	
	
	
 
  	<%
		         

				if(disp_stage.equals("V")){
%>
					<td  nowrap class="white"></td>
<%
				}
				else if(disp_stage.equals("A")){
					if(iv_prep_yn==null)
						iv_prep_yn="";
					if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
						bean.setAdmixtureType("I");
%>
						<td  nowrap  class="white" border="none" align="right">
							<input type="button" value="<%=param_legends.get("A")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','IV')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
						</td>	
<%
					}
					else if(iv_prep_yn.equals("6")){
						bean.setAdmixtureType("I");
%>
						<td  nowrap  class="white" border="none" align="right">
						<input type="button" value="<%=param_legends.get("A")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','CO')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
						</td>	
<%	
					}
					else if(iv_prep_yn.equals("0")){
						bean.setAdmixtureType("C");
%>
						<td  nowrap  class="white" border="none" align="right">
						<input type="button" value="<%=param_legends.get("A")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','CY')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
						</td>
		<%		}else if(iv_prep_yn != null && iv_prep_yn.equals("8")){
					bean.setAdmixtureType("TA");
		%>
			<td  nowrap  class="white" border="none" align="right">
				<input type="button" value="<%=param_legends.get("A")%>" class="button" onClick="showWorksheetForTPNAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
			</td>	
		<%		}else{
					if(iv_prep_yn != null && iv_prep_yn.equals("7") )
						bean.setAdmixtureType("TD");
		%>
			<td  nowrap  class="white" border="none" align="right">
				<input type="button" value="<%=param_legends.get("A")%>" class="button"  <%=butt_status%> onClick="callAllocate('<%=patient_id%>','<%=order_id%>','','<%=disp_stage%>')" name="alloc_but" <%=butt_status%>  <%=disp_butt_status%>>
			</td>	
		<%
				}
			}else if(disp_stage.equals("F")){
					if(iv_prep_yn==null)
					iv_prep_yn="";
				if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
					bean.setAdmixtureType("I");
				

		%>
			<td  nowrap  class="white" border="none"  align="right">
				<input type="button" value="<%=param_legends.get("F")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','IV')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
			</td>	
		<%
				}else if(iv_prep_yn.equals("6")){
					bean.setAdmixtureType("I");
		%>
			<td  nowrap  class="white" border="none"  align="right">
				<input type="button" value="<%=param_legends.get("F")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','CO')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
			</td>	
		
		<%		
				}else if(iv_prep_yn.equals("0")){
					bean.setAdmixtureType("C");
		%>
			<td  nowrap  class="white" border="none" align="right">
				<input type="button" value="<%=param_legends.get("F")%>" class="button" onClick="showWorksheetForIVAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>','CY')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
			</td>	

		<%
				}else if(iv_prep_yn.equals("8")){
					bean.setAdmixtureType("TA");
		%>
			<td  nowrap  class="white" border="none" align="right">
				<input type="button" value="<%=param_legends.get("F")%>" class="button" onClick="showWorksheetForTPNAdmixture('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>')" name="alloc_but" <%=butt_status%> <%=disp_butt_status%>>
			</td>	
		<%
				}else{
					if(iv_prep_yn != null && iv_prep_yn.equals("7") )
						bean.setAdmixtureType("TD");
		%>
			<td  nowrap  class="white" border="none" align="right">
			
				<input type="button" name="btnFill" id="btnFill" value="<%=param_legends.get("F")%>" class="button"  <%=butt_status%> <%=disp_butt_status%>  onClick="callAllocate('<%=patient_id%>','<%=order_id%>','','F')">
			</td>	
		<%
				}
			}else if(disp_stage.equals("D")){
				if(iqvia_integration_flag){//MOHE-CRF-0026.1  
				if( bl_patient_class.equalsIgnoreCase("O") && (settlement_id.equalsIgnoreCase("X")) && (iv_prep_yn==null || iv_prep_yn.equals("") || iv_prep_yn.equals("null")) ) {   
		%>
		
		<!-- MOHE-CRF-0026.1 -->
			<td  nowrap class="button" align="right">
				<input type="button" name="btnAuthChk" id="btnAuthChk" value="Authorization Check" class="button"  onClick="callAuthCheck('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');callInterface('<%=disp_stage%>','PHPREAUTH');"> 
			</td>
			<td>
				<input type="button" name="btnAuthStat" id="btnAuthStat" value="Authorization Status" class="button" onClick="callAuthStatus('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');callInterface('<%=disp_stage%>','PHSTATUS');"> 
			</td>
			<%} //END %>  
			<td  nowrap class="white" align="right">
				<input type="button" name="btnDelivery" id="btnDelivery" value="<%=param_legends.get("D")%>" class="button" <%=butt_status%> onClick="callDelivery('<%=patient_id%>','<%=issue_token_on_regn_yn%>')">
			</td>
		<%	}}else if(disp_stage.equals("AS")){	
				if(iv_prep_yn != null && iv_prep_yn.equals("S") )
				bean.setAdmixtureType("S");
				if(iqvia_integration_flag){//added for MOHE-CRF-0026.1 
				if( bl_patient_class.equalsIgnoreCase("O") && (settlement_id.equalsIgnoreCase("X")) && ( iv_prep_yn == null || iv_prep_yn.equals("") || iv_prep_yn.equals("null")) ) { //added for MOHE-CRF-0026.1
		%>
		<!-- MOHE-CRF-0026.1 -->
			<td  nowrap class="button" align="right">
				<input type="button" name="btnAuthChk" id="btnAuthChk" value="Authorization Check" class="button"  onClick="callAuthCheck('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');callInterface('<%=disp_stage%>','PHPREAUTH');"> 
			</td>
			<td>
				<input type="button" name="btnAuthStat" id="btnAuthStat" value="Authorization Status" class="button" onClick="callAuthStatus('<%=patient_id%>','<%=order_id%>','<%=disp_stage%>');callInterface('<%=disp_stage%>','PHSTATUS');"> 
			</td>
			<%} }%>
		<td  nowrap class="white"></td>
		<td  border="none" class="white" align="right">
		<%
				String filling_reqd			= "";
				String delivery_reqd		= "";
				String allocation_reqd		= "";
				String filling_status		= ""; 
				String display_seq			= "";
				String allocate_button		= "";
				String filling_button		= "";
				 butt_status			= "";
				if(scope.equals("H")){
                      butt_status="disabled";
				}else{
					  butt_status="";
				}
				String stages				=	bean.getStageDisplaySequence();
				filling_status				=	bean.getFillingStatus();

				StringTokenizer stages_token = new StringTokenizer(stages,":");
				while(stages_token.hasMoreTokens()){
					String stage	=	(String)stages_token.nextToken();
					if( stage.equals("F")) {
						filling_reqd = "Y";
						}
					else if( stage.equals("D")) {
						delivery_reqd = "Y";
					}
					else if( stage.equals("A")) {
						allocation_reqd = "Y";
						}
					else if( stage.equals("V")) {
						}
				}

				if(filling_status.equals("A")) 
				   display_seq	=	"A";
				else 
				   display_seq	=	"F";

				allocate_button = "<input type='button' class='button' value='"+param_legends.get("A")+"' style='font-size:12;cursor:pointer;text-align:center' onClick='callAllocate(\""+patient_id+"\",\""+order_id+"\",\"\",\"AS\",\"A\")' name='alloc_but' id='alloc_but' "+butt_status+">&nbsp;";
				filling_button	=	"<input type='button' class='button' value='"+param_legends.get("F")+"' style='font-size:12;cursor:pointer;text-align:center'     name='fill_but' id='fill_but' onClick='callFilling(\""+patient_id+"\",\""+order_id+"\",\"\",\"F\")' "+butt_status+">&nbsp;";

			

					if(display_seq.equals("A")) { 
						if(allocation_reqd.equals("Y")) {
							out.println(allocate_button);
						}	
						if(filling_reqd.equals("Y")) {
							out.println(filling_button);
						}	
					} else	{ 
						if(filling_reqd.equals("Y")) { 
						out.println(filling_button);
						}
						if(allocation_reqd.equals("Y")) {
						out.println(allocate_button);
						}
					}	
					 if(delivery_reqd.equals("Y")) { %>
					<input type="button" class="button" value="<%=param_legends.get("D")%>" style="font-size:12;cursor:pointer;text-align:center"  name="delivery_but"  <%=butt_status%> onClick="callDelivery('<%=patient_id%>','<%=issue_token_on_regn_yn%>')"        >
<%			
				 }
%>
					</td>
<%
				}
%>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="issue_token_on_regn" id="issue_token_on_regn" value="<%=bean.getIssueTokenOnRegnYN()%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=bean.getDispLocnCatg()%>">
			<input type="hidden" name="module_id" id="module_id" value="<%=bean_1.getModuleId()%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
			<input type="hidden" name="OrderIds" id="OrderIds" value="<%=strOrderIds%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
			<input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value='<%=bean.getBarcodeSiteYN()%>'><!--Added for MMS-DM-CRF-157.2-->
            <input type='hidden' name='entry_type' id='entry_type' value=''><!--Added for MMS-DM-CRF-157.2-->
			<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'><!--Added for MMS-DM-CRF-157.2bl_patient_class-->
			<input type='hidden' name='act_patient_episode_type' id='act_patient_episode_type' value='<%=bl_patient_class%>'><!--Added for MMS-DM-CRF-170-->


		</form>
	</body>
	<script>
<%	
		if(disp_stage.equals("AS")) {
%>
			callAllStages('<%=params%>');
<%
		}	
		if(sPPNFlag){
%>
			reloadFillPage();
<%
		}
		else if(!disp_stage.equals("V")  && !disp_stage.equals("D") && disp_butt_status.equals("") && !fill_list.equals("AF") && bChangeValues){ //&& !disp_stage.equals("AS") removed for MMS-SCF-417 //&& !disp_stage.equals("AS") removed for BSP-SCF-0041  
			if(strDurationType!=null && !strDurationType.equals("") && bean.getHmPPNValues() == null) {
%>
			document.DispMedicationAllStages.durnType.value= "<%=strDurationType%>";
			document.DispMedicationAllStages.durationVal.onchange();
<%
		}
	}
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	e.printStackTrace();
}finally{ // added for AAKH-CRF-0117 - start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request); // added for AAKH-CRF-0117 - end	
}
%>
	</script>
</html>

