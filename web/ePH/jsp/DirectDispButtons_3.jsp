<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	try{
	request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");

	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String dir_bean_id					= "DirectDispensingBean" ;
	String dir_bean_name				= "ePH.DirectDispensingBean";
	DirectDispensingBean dir_bean		= (DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request) ;

	String billing_interface_yn         = dir_bean.checkforbillinginterface();
	String disp_cash_coll_stage			= dir_bean.getDispCashCollStage();
	String retn_disp_med_for_outstanding	=  dir_bean.getRetnDispMedForOutStanding(); //Added for MMS-QH-CRF-0201
	dir_bean.setLanguageId(locale);
	String tot_gross_charge_amount_str  = "";
	String tot_groos_pat_payable_str    = "";
	String gross_charge_amount			= "";//Added for MMS AdhocTesting
	String groos_pat_payable			= "";//Added for MMS AdhocTesting
	String tot_gross_charge_amount_payable_str="";//added for ml-bru-crf-0469
	String gross_charge_amount_payable			= "";//added for ml-bru-crf-0469
	String colspan="1";
			boolean displayGrossAmtYn = dir_bean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
	if(billing_interface_yn.equals("Y")){
		tot_gross_charge_amount_str =	request.getParameter("tot_gross_charge_amount_str")==null?"0.00":request.getParameter("tot_gross_charge_amount_str");
		tot_groos_pat_payable_str   =	request.getParameter("tot_groos_pat_payable_str")==null?"0.00":request.getParameter("tot_groos_pat_payable_str");
		tot_gross_charge_amount_payable_str=request.getParameter("tot_gross_charge_amount_payable_str")==null?"0.00":request.getParameter("tot_gross_charge_amount_payable_str"); // Added for ML-BRU-CRF-0469 [IN:065426]
	}

	ArrayList presDetails			= (ArrayList) dir_bean.getpresDetails();
	//Added for MMS AdhocTesting-Start
	ArrayList tot_cons_item_dtl		= (ArrayList)dir_bean.getConsumableDetails();
	HashMap billing_det				=  new HashMap();
	HashMap cons_item_dtl			=  new HashMap();
	for(int i=0;i<tot_cons_item_dtl.size();i++){
          cons_item_dtl  = (HashMap)tot_cons_item_dtl.get(i);
	 if(cons_item_dtl.containsKey("BILLING_DET")){   
		 billing_det           =  (HashMap)cons_item_dtl.get("BILLING_DET");
		 gross_charge_amount   =  (String) billing_det.get("GROSS_CHARGE_AMOUNT")==null?"":(String) billing_det.get("GROSS_CHARGE_AMOUNT");  
		 groos_pat_payable     =  (String) billing_det.get("GROOS_PAT_PAYABLE")==null?"":(String) billing_det.get("GROOS_PAT_PAYABLE");
		 gross_charge_amount_payable   =  (String) billing_det.get("GROSS_CHARGE_AMOUNT_PAYABLE")==null?"": (String) billing_det.get("GROSS_CHARGE_AMOUNT_PAYABLE"); //ADDED FOR ML-BRU-CRF-0469 
		 if(!gross_charge_amount.equals("")) 
		 tot_gross_charge_amount_str = Float.parseFloat(tot_gross_charge_amount_str) + Float.parseFloat(gross_charge_amount)+"";
		 if(!groos_pat_payable.equals(""))
		    tot_groos_pat_payable_str = Float.parseFloat(tot_groos_pat_payable_str) + Float.parseFloat(groos_pat_payable)+"";
		 if(!(tot_gross_charge_amount_payable_str.equals("") && gross_charge_amount_payable.equals("")))
		     tot_gross_charge_amount_payable_str = Float.parseFloat(tot_gross_charge_amount_payable_str) + Float.parseFloat(gross_charge_amount_payable)+""; // ML-BRU-CRF-0469 [IN:065426]
	   }
	}//Added for MMS AdhocTesting-End
	String str_disabled ="disabled";
	if(presDetails.size()>0){
		str_disabled="";
	}
	String encounter_id=CommonBean.checkForNull(dir_bean.getEncounterID());
	String patient_id=dir_bean.getPatientID();
	String disp_locn_code=dir_bean.getDispLocnCode();
	String  sysdate				 =  dir_bean.getTodaysDate1();
	String  store_desc           =  dir_bean.getStoreDesc(disp_locn_code);
	String  bl_patient_class     =  dir_bean.getEncounterPatientClass(encounter_id, patient_id); // patient_id  added for [IN:035667] 
	if(bl_patient_class=="" || bl_patient_class.length()==0){
	bl_patient_class="R";
	}
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script> 
<!-- 	<script language="JavaScript" src="../js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_button" id="prescription_button" >
    <table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="1">
		   <tr nowrap>
			<td  class='white'>&nbsp;<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img></td>
			<td  nowrap>&nbsp;&nbsp;<label style="font-size:9;font-weight:bold"><fmt:message key="ePH.PatientCounselling.label" bundle="${ph_labels}"/></label></td>
			<%if(billing_interface_yn.equals("Y")){%>									
				<td  class="data"  align='left' style="font-size:9pt" id='total_payable'><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/> : <%=tot_gross_charge_amount_str%></td>
				<td  class="data"  align='left' style="font-size:9pt" id='patient_payable'><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>  : <%=tot_groos_pat_payable_str%> </td>
				<%if(displayGrossAmtYn){ %>	
				<td  class="data"  align='left' style="font-size:9pt" id='total_gross_payable'><fmt:message key="ePH.TotalGrossAmount.label" bundle="${ph_labels}"/>  : <%=tot_gross_charge_amount_payable_str%> </td> <!--  Added for ML-BRU-CRF-0469 [IN:065426] -->
		<%} else{%>	
		<td  class="data"  align='left' style="font-size:9pt;display:none" id='total_gross_payable'></td>
			<%}%>	
			<%}%>			
	<td  nowrap  width="8%" colspan="<%=colspan%>"   align="right" style="font-size:10;background-color:#fde6d0" >&nbsp;<b><a  style ='font-size:9' href="javascript:callMedicalItemdetails('<%=patient_id%>','<%=encounter_id%>','<%=billing_interface_yn%>','<%=disp_locn_code%>','<%=bl_patient_class%>','<%=sysdate%>','<%=java.net.URLEncoder.encode(store_desc)%>')"><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/> </a></b></td>
			<td  align='right' >
			<input type="button" class="button" value='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/> ' onclick="callPreviewOrders();"  name="previewrx" >&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="ePH.CompleteDispense.label" bundle="${ph_labels}"/>' onclick="CompleteDispensing()"  name="CompleteDispense" <%=str_disabled%>></td>
		</tr>
	</table>
	  <input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount_str%>"><!--Added for MMS AdhocTesting -->
	  <input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable_str%>"><!--Added for MMS AdhocTesting -->
	   <input type="hidden" name="disp_cash_coll_stage" id="disp_cash_coll_stage" value="<%=disp_cash_coll_stage%>"> <!-- added for MMS-QH-CRF-0201  -->
	  <input type="hidden" name="retn_disp_med_for_outstanding" id="retn_disp_med_for_outstanding" value="<%=retn_disp_med_for_outstanding%>"> <!-- added for MMS-QH-CRF-0201  -->
	  <input type="hidden" name="tot_gross_charge_amount_payable" id="tot_gross_charge_amount_payable" value="<%=tot_gross_charge_amount_payable_str%>"> <!--  Added for ML-BRU-CRF-0469 [IN:065426] -->
	  <input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"> <!--  Added for ML-BRU-CRF-0469 [IN:065426] -->
	  <%
	}catch(Exception e){
		  e.printStackTrace();
	  }
		  %>
</form>
</body>
</html>

