 <%--This file is saved on 07/11/2005 --%>
 <%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
22/11/2019      IN059899        PRATHYUSHA                          JD-CRF-0200
29/05/2020	IN:072092	Manickavasagam J	    GHL-CRF-0618
08/06/2020      IN:072715       Haribabu                            MMS-DM-CRF-0165
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
       request.setCharacterEncoding("UTF-8");
	  //  String locale			= (String)session.getAttribute("LOCALE");
	  //
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	Connection con			= null;  //ADDED FOR MMS-KH-CRF-0010
    con				= ConnectionManager.getConnection(request);//ADDED FOR MMS-KH-CRF-0010
	 boolean viewAdminRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
	 boolean over_ride_remarks_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");//Added for IN:072715
	try 
	{
		ArrayList finAr = new ArrayList();

			
	//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String ApplicableTransaction = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ApplicableTransaction.label","ph_labels");

       String MedicationReissue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReissue.label","ph_labels");
	   String MedicationReturn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReturn.label","ph_labels");
	   String MedicationHold = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationHold.label","ph_labels");
	   String Allocation = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Allocation.label","ph_labels");
	   String Filling = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Filling.label","ph_labels");
	   String Delivery = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Delivery.label","ph_labels");
	   String AmendOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AmendOrder.label","ph_labels");
	   String Administration = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Administration.label","ph_labels");
	   String ADRReason = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRReason.label","ph_labels");
	   String TDMOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TDMOrder.label","ph_labels");
	   String ReleaseBatchPatient = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ReleaseBatchPatient.label","ph_labels");
	   String ReleaseBatchOthers = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ReleaseBatchOthers.label","ph_labels");
	   String CompleteOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrder.label","ph_labels");
	   String ReroutePrescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ReroutePrescription.label","ph_labels");
	   String Overridereason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OverRideBMS.label","ph_labels");
	   String BalanceMedicationRemarks= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BalanceMedicationRemarks.label","ph_labels");
	   String DosageChangeinMAR= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DosageChangeinMAR.label","ph_labels");
	   String PRNRemarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PRNRemarks.label","ph_labels");
	   String CancelNPBRequest=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CancelNPBRequest.label","ph_labels");		 
	   String ADRCancelReason=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRCancelReason.label","ph_labels");//code added for HSA-CRF-0005[40601]		
	   String ADRInErrorReason=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ADRInErrorReason.label","ph_labels");//code added for HSA-CRF-0005[40601]		
	   String CancelMarAdminstration=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CancelMarAdminstration.label","ph_labels");//code added JD-CRF-0200		   
	
	  String MarAdminstrationRemarks= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MarAdminstrationRemarks.label","ph_labels");//code added MMS-KH-CRF-0010
  	   String non_preferable=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NotPreferedItemRemarks.label","ph_labels");//code added GHL-CRF-0618		   
        //Added for IN:072715	start
	String allergy_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AllergyOverrideReason.label","ph_labels");//Added for IN:072715	   
	String beyond_dose_limit_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BeyondDoseLimitOverrideReason.label","ph_labels");//Added for IN:072715
	String duplicate_drug_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateDrugOverrideReason.label","ph_labels");//Added for IN:072715
	String drug_drug_interaction_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DrugInteractionOverrideReason.label","ph_labels");//Added for IN:072715
	String drug_food_interaction_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-FoodInteractionOverrideReason.label","ph_labels");//Added for IN:072715
	String drug_lab_interaction_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-LabInteractionOverrideReason.label","ph_labels");//Added for IN:072715
	String drug_disease_interaction_override_reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DiseaseOverrideReason.label","ph_labels");//Added for MMS-DM-CRF-0229
	//Added for IN:072715 end
			   
	//CancelMarAdminstration ADDED FOR JD-CRF-0200
	//MarAdminstrationRemarks ADDED FOR MMS-KH-CRF-0010
       String tpn_item_list_val="R,"+MedicationReissue+",T,"+MedicationReturn+",H,"+MedicationHold+",A,"+Allocation+",F,"+Filling+",D,"+Delivery+",O,"+AmendOrder+",M,"+Administration+",E,"+ADRReason+",TD,"+TDMOrder+",RP,"+ReleaseBatchPatient+",RO,"+ReleaseBatchOthers+",CO,"+CompleteOrder+",RR,"+ReroutePrescription+",OB,"+Overridereason+",BR,"+BalanceMedicationRemarks+",DM,"+DosageChangeinMAR+",PR,"+PRNRemarks+",CN,"+CancelNPBRequest  +",AC,"+ADRCancelReason+",AI,"+ADRInErrorReason+",CM,"+CancelMarAdminstration+",NP,"+non_preferable; //code 'AC,ADRCancelReason,AI,ADRInErrorReason' added for HSA-CRF-0005[40601]

       if(viewAdminRemarks){
    	   tpn_item_list_val=tpn_item_list_val+",MR,"+MarAdminstrationRemarks;
       }
        //Added for IN:072715 start
       if(over_ride_remarks_appl){
    	   tpn_item_list_val=tpn_item_list_val+",AO,"+allergy_override_reason+",BD,"+beyond_dose_limit_override_reason+",DP,"+duplicate_drug_override_reason+",DD,"+drug_drug_interaction_override_reason+",DF,"+drug_food_interaction_override_reason+",DL,"+drug_lab_interaction_override_reason+",DI,"+drug_disease_interaction_override_reason;//drug_disease_interaction_override_reason Added for MMS-DM-CRF-0229
       }
       //Added for IN:072715 end

		firstItem.add("List");  		 //Type of item
		firstItem.add(ApplicableTransaction);	  // label
		firstItem.add("appl_trn_type");	//name of field
		firstItem.add(tpn_item_list_val);
		firstItem.add("30");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		 String ReasonCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(ReasonCode);  // label
		secondItem.add("reason_code");   //name of field
		secondItem.add("4");	//LENGTH
		secondItem.add("4");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();
		 String ReasonDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonDescription.label","common_labels");

		thirdItem.add("Text");  //Type of item
		thirdItem.add(ReasonDescription);  // label
		thirdItem.add("reason_desc");   //name of field
		thirdItem.add("43");	//SIZE
		thirdItem.add("40");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

		 String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
       
	   String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
     

		fourthItem.add("List");  //Type of item
		fourthItem.add(Nature);  // label
		fourthItem.add("eff_status");   //name of field
		fourthItem.add(tpn_item_list_values);//static values that need to be displayed as
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
	
		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];
	

		orderByCols[0] = ApplicableTransaction;
		orderByCols[1] = ReasonDescription;
		//orderByCols[2] = ReasonDescription;
	

		orderByColVals[0] = "appl_trn_type";
		orderByColVals[1] = "reason_desc";
		//orderByColVals[2] = "reason_desc";
		

        String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
//String ReasonCode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
		
		strbuff = qrypg.getQueryPage(null, finAr,ReasonCode, "ReasonCodesQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
	 finally{//ADDED FOR MMS-KH-CRF-0010 
			
			if(con != null)
				ConnectionManager.returnConnection(con,request);	
		} 
%>
