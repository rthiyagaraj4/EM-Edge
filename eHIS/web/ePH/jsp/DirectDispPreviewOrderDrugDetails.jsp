<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
--------------------------------------------------------------------------------------------------------------
*/%>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eOR.Common.*,eOR.*" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	try{
		String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String locn_code			=	request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String actual_patient_class	=	request.getParameter("actual_patient_class")==null?"":request.getParameter("actual_patient_class");
		String bean_id				=	"DirectDispensingBean";
		String bean_name			= "ePH.DirectDispensingBean";
		String facility_id					= (String) session.getValue("facility_id");

		DirectDispensingBean bean   = (DirectDispensingBean)getBeanObject( bean_id,bean_name,request) ;
		ArrayList prescriptionDetails = bean.getpresDetails();
		ArrayList consumableDetails = bean.getConsumableDetails();

		String drug_code		=	null;
		String srl_no			=	null;
		String taper_yn			=	null;
		String split_dose_yn	=	null;
		String qty_value		=	null;
		String qty_desc			=	null;
		String or_qty_desc		=	null;
		String freq_nature		=	null;
		String freq_desc		=	null;
		String durn_value		=	null;
		String tmp_durn_value	=	null;
		String or_durn_desc		=	null;
		String or_durn_desc1	=	null;
		String strength_uom		=	null;
		String dosage_type		=	null;
		String strength_value	=	null;
		//String rowVal			=	null;
		String no_refill		=	null;
		String end_date			=	null;
		String repeat_durn_type	=	null;
		String	prn_dose		= 	"";
		String fract_dose		=   "N";
		String act_strength_value=  "";
		//String freq_str1 ="";
		//String freq_str2 ="";
		//String freq_str3 ="";
		//String freq_str4 ="";
		HashMap RefillDetail	=	null;
		//Code Added For ICN 29927	RUT-CRF-0034 -Start
		String route_color                 ="";
		String addRouteDesc                 =""; 
		String route_desc                 =""; 
		String fntColor                 ="";
		String backgrndColor= "";// added for CRF RUT-CRF-0034.1[IN:037389]
		String route_code                 =""; 
		//Code Added For ICN 29927	RUT-CRF-0034 -End
		/* Code Added for SKR-SCF-0647[Inc:35263]-Start */
		String drugindication_remarks	  ="";
		String override_remarks			  ="";
		String allergy_remarks			  ="";
		String dosage_remarks			  ="";
		HashMap PRN_remarks				  =	new HashMap();
		String PRN_remarks_code			  =	"";
		String PRN_remarks_dtl		  	  =	"";
	//MMS-KH-CRF-0029 [IN070606] - start
		String interaction_exists	=  "";
		String interaction_remarks	=  "";
		String food_interaction_remarks =  ""; 
		String lab_interaction_remarks  =  ""; 
		String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229
	//MMS-KH-CRF-0029 [IN070606] - end
		/* Code Added for SKR-SCF-0647[Inc:35263]-End */
%>
		<html>
			<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    <script language="JavaScript" src="../../js/Prescription.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="prescription_form_preview_order" id="prescription_form_preview_order" >
<%

	if(prescriptionDetails.size()>0){ 
%>
		<table border="0" width="100%" cellspacing="0" cellpadding="0" id="prescription_table">
<%
		ArrayList grp			=	(ArrayList) bean.sortList();		
		int k					=	0;
		HashMap drugDetails		=	null;
		String absol_qty		=	"";
		String pres_base_uom	=	"";
			
			for(int i=0;i<grp.size();i++){
				ArrayList displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));
				
				for(int j=0;j<displayList.size();j++){
				drugDetails			= (HashMap) displayList.get(j);
											
				 drug_code			= (String)drugDetails.get("DRUG_CODE");
				 srl_no				= (String)drugDetails.get("SRL_NO");
				 taper_yn			= (String)drugDetails.get("TAPER_DOSE_YN");
				 split_dose_yn		= ((String)drugDetails.get("SPLIT_DOSE_YN_VAL"))==null?"N":(String)drugDetails.get("SPLIT_DOSE_YN_VAL");
				 qty_value			= (String)drugDetails.get("QTY_VALUE");
				 qty_desc			= (String)drugDetails.get("QTY_DESC");
				 or_qty_desc		= (String)drugDetails.get("OR_QTY_DESC");
				 	freq_nature		            =	((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
			
			//	 freq_nature		= (String)drugDetails.get("FREQ_NATURE");
				 freq_desc			= java.net.URLDecoder.decode((String)drugDetails.get("FREQ_DESC"));
				 durn_value			= (String)drugDetails.get("DURN_VALUE");
				 tmp_durn_value		= (String)drugDetails.get("TMP_DURN_VALUE");
				 or_durn_desc		= (String)drugDetails.get("DURN_DESC");
				 or_durn_desc1		= (String)drugDetails.get("DURN_DESC");
				 

				 strength_uom		= (String)drugDetails.get("STRENGTH_UOM");
				 dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
				 strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				// rowVal				= (String)drugDetails.get("rowVal");
				no_refill			= (String)drugDetails.get("NO_REFILL");
				end_date			= (String)drugDetails.get("END_DATE");	
				repeat_durn_type	= (String)drugDetails.get("REPEAT_DURN_TYPE");	
				absol_qty			= (String)drugDetails.get("ABSOL_QTY");
				pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				prn_dose			= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
			    fract_dose			= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
				act_strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
				//MMS-KH-CRF-0029 [IN070606] - start
				interaction_exists 	= (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
				interaction_remarks	= (String)drugDetails.get("INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("INTERACTION_REMARKS");
				food_interaction_remarks=	  (String)drugDetails.get("FOOD_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("FOOD_INTERACTION_REMARKS"); //MMS-KH-CRF-0029 [IN070606]
				lab_interaction_remarks=	  (String)drugDetails.get("LAB_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("LAB_INTERACTION_REMARKS");//MMS-KH-CRF-0029 [IN070606]
				disease_interaction_remarks=	  (String)drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
				interaction_remarks=interaction_remarks.replaceAll(" ","%20");
				interaction_remarks = java.net.URLEncoder.encode(interaction_remarks,"UTF-8");
				interaction_remarks = java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
				interaction_remarks=interaction_remarks.replaceAll("%2520"," ");
				interaction_remarks=interaction_remarks.replaceAll("%20"," ");
				food_interaction_remarks=food_interaction_remarks.replaceAll(" ","%20");
				food_interaction_remarks = java.net.URLEncoder.encode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks = java.net.URLDecoder.decode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%2520"," ");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%20"," ");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll(" ","%20");
				lab_interaction_remarks = java.net.URLEncoder.encode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks = java.net.URLDecoder.decode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%2520"," ");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%20"," ");
				 //Adding start for MMS-DM-CRF-0229
				disease_interaction_remarks=disease_interaction_remarks.replaceAll(" ","%20");
				disease_interaction_remarks = java.net.URLEncoder.encode(disease_interaction_remarks,"UTF-8");
				disease_interaction_remarks = java.net.URLDecoder.decode(disease_interaction_remarks,"UTF-8");
				disease_interaction_remarks=disease_interaction_remarks.replaceAll("%2520"," ");
				disease_interaction_remarks=disease_interaction_remarks.replaceAll("%20"," ");//Adding end MMS-DM-CRF-0229
				//MMS-KH-CRF-0029 [IN070606] - end
				 /* Code Added for SKR-SCF-0647[Inc:35263]-Start */
				drugindication_remarks=(String)drugDetails.get("DRUG_INDICATION");
				/*drugindication_remarks=drugindication_remarks.replaceAll(" ","%20");
				drugindication_remarks = java.net.URLEncoder.encode(drugindication_remarks,"UTF-8");
				drugindication_remarks = java.net.URLDecoder.decode(drugindication_remarks,"UTF-8");
				drugindication_remarks=drugindication_remarks.replaceAll("%2520"," ");
				drugindication_remarks=drugindication_remarks.replaceAll("%20"," ");*/

				override_remarks   =drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
				/*override_remarks=override_remarks.replaceAll(" ","%20");
				override_remarks   =java.net.URLEncoder.encode(override_remarks);
				override_remarks   =java.net.URLDecoder.decode(override_remarks);
				override_remarks=override_remarks.replaceAll("%2520"," ");
				override_remarks=override_remarks.replaceAll("%20"," ");*/

				allergy_remarks   =drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
				/*allergy_remarks=allergy_remarks.replaceAll(" ","%20");
				allergy_remarks   =java.net.URLEncoder.encode(allergy_remarks);
				allergy_remarks   =java.net.URLDecoder.decode(allergy_remarks);
				allergy_remarks=allergy_remarks.replaceAll("%2520"," ");
				allergy_remarks=allergy_remarks.replaceAll("%20"," ");*/

				dosage_remarks   =drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
				//dosage_remarks		=java.net.URLDecoder.decode((String)drugDetails.get("DOSE_REMARKS"));
				PRN_remarks			=  bean.getPRNRemarks(drug_code);
				if(PRN_remarks != null){
					PRN_remarks_code = PRN_remarks.get("remarks_code")==null?"":(String)PRN_remarks.get("remarks_code");
					PRN_remarks_dtl = PRN_remarks.get("remarks_dtl")==null?"":(String)PRN_remarks.get("remarks_dtl");
				}//Code Added for SKR-SCF-0647[Inc:35263]-End
				 if(repeat_durn_type.equals(or_durn_desc))
					 or_durn_desc		= bean.getDurationType(repeat_durn_type);
				 else{
					 if(or_durn_desc.equals("M"))
						or_durn_desc="Minute(s)";
					 else if(or_durn_desc.equals("H"))
						or_durn_desc="Hour(s)";
					 else if(or_durn_desc.equals("W"))
						or_durn_desc="Week(s)";
					 else if(or_durn_desc.equals("D"))
						or_durn_desc="Day(s)";
					 else if(or_durn_desc.equals("L"))
						or_durn_desc="Month(s)";
					 else if(or_durn_desc.equals("Y"))
						or_durn_desc="Year(s)";
				 }
 				 

				if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
						prn_dose	=	"1";
				}

				RefillDetail= (HashMap) bean.getRefillDetail(srl_no);//Modified for IN:069886
				//RefillDetail= (HashMap) bean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);
					

				if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
					strength_value = Float.parseFloat(strength_value) +"" ;

				if(strength_value.equals("0")) {
					strength_value		=	"";
					strength_uom		=	"";
				}				
				String tooltip			= "";
				String freq_str			= "";
				String pres_remarks		= "";
				ArrayList schedule		= null;
				String last_refill_durn_value=(String)RefillDetail.get("last_refill_durn_value")==null?durn_value:(String)RefillDetail.get("last_refill_durn_value");//Added for IN:069886
				//Hashtable template		= null;
			
				//ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),(drug_code+srl_no)+"_0");

				
				/*if(seq_num==null)
					seq_num			=	new ArrayList();

				for(int p=0; p<seq_num.size(); p++) {
					
						template	=	(Hashtable)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),((drug_code+srl_no)+((Integer.parseInt((String)seq_num.get(p))) ) ));
 						if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
							pres_remarks += bean.getPrescriptionRemarks((String) template.get("field_values"))+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						} else {
							pres_remarks += (String) template.get("field_values") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						} 
				
				}*/
				//out.println("remarks"+pres_remarks);
				

				
				 schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			

				 boolean split_chk	=	bean.checkSplit(schedule);

				  /*for(int n=0; n<schedule.size(); n++) {
					 HashMap detail	=	(HashMap)schedule.get(n);
					freq_str += detail.get("admin_time")+"-";
					freq_str += detail.get("admin_qty")+" "+qty_desc;
						if(n==(schedule.size()-1))
							freq_str +=" ";
						else
							freq_str +=", ";
				 }	*/
				 freq_str= (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+bean.getUomDisplay(facility_id,qty_desc));
				if(dosage_type.equals("A"))
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
				else if(schedule.size() > 0 && split_chk) {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+durn_value+" "+or_durn_desc;
				} else if(schedule.size() > 0) {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+durn_value+" "+or_durn_desc;
				} else {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
				}
				//Added for IN:069886 start
				String tooltipnew			= "";
				if(dosage_type.equals("A"))
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+last_refill_durn_value+" "+or_durn_desc;
				else if(schedule.size() > 0 && split_chk) {
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+last_refill_durn_value+" "+or_durn_desc;
				} else if(schedule.size() > 0) {
					tooltipnew		= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+last_refill_durn_value+" "+or_durn_desc;
				} else {
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+last_refill_durn_value+" "+or_durn_desc;
				}
				//Added for IN:069886 end	
				// calculate the dosage qty
				String sch_size			=	"";
				String conv_factor		=	"";
				float    tot_qty_value    =0; 
				
				if(schedule.size() > 0 && (split_dose_yn.equals("N"))) {
						 //HashMap detail	=	(HashMap)schedule.get(0);
						 ArrayList dose_list		= (ArrayList)schedule.get(4);
						 if(fract_dose.equals("N")){
						   //qty_value		=	(String)detail.get("admin_qty");
						   if(dose_list.size()>0)								
						   {
						      qty_value		=	(String)dose_list.get(0);
						      if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
									 qty_value="1";
						   }
						   else
						   {
							  if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
									 qty_value="1";
						   }

						  }else{
                            if(dosage_type.equals("S")){								
                               //qty_value		=	(String)detail.get("admin_qty");
							    if(dose_list.size()>0)								
								{
									qty_value		=	(String)dose_list.get(0);	
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
								}
								else
								{
									  if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
											 qty_value="1";
								}
							   qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
						     }else if(dosage_type.equals("Q")){
								//qty_value		=	(String)detail.get("admin_qty");
								if(dose_list.size()>0)								
								{
									qty_value		=	(String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								}
								else
								{
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								}
                               	qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
							 }  
						// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";

						 }

						 sch_size		=	""+dose_list.size();
						
					
				} else {
						//sch_size		=	repeat_value;
					
					if(split_dose_yn.equals("Y")){
						if(fract_dose.equals("N")){
							//for(int n=0; n<schedule.size(); n++) {
							if(schedule.size()>0) {
								sch_size		=	"1";
								//HashMap  detail	=  (HashMap)schedule.get(n);
								String final_qty="";
								ArrayList dose_list		= (ArrayList)schedule.get(4);
								for(int n=0; n<dose_list.size(); n++) {
								 //tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
								final_qty	=	(String)dose_list.get(n);
								if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
									tot_qty_value    =  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
								else
									tot_qty_value	+=1.0f;
								}
							}
						}else{
                          // for(int n=0; n<schedule.size(); n++) {
							if(schedule.size()>0) {
							  sch_size		=	"1";
							  //HashMap  detail	=  (HashMap)schedule.get(n);
							  ArrayList dose_list		= (ArrayList)schedule.get(4);
							  for(int n=0; n<dose_list.size(); n++) {
								if(dosage_type.equals("S")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
									qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
								}else if(dosage_type.equals("Q")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
                               		qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
								}  
								tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
							  }

							}
						}

			            qty_value       =tot_qty_value+"";
					}
					else
					{
						if(freq_nature.equals("O"))
						{
							if(fract_dose.equals("Y") && dosage_type.equals("S"))
							{
								 qty_value   =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
							}
						}
					}
				}
				

				if(freq_nature.equals("P") && absol_qty==null) {
					absol_qty		=	prn_dose;	
				}

				if(absol_qty==null || absol_qty.equals("0"))
					absol_qty		=	"1";



				if(dosage_type.equals("A") || freq_nature.equals("P")) {
										qty_value		=	absol_qty;
										dosage_type		=	"A";
				}

				if(dosage_type.equals("Q"))
					conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);
			 if(sch_size.equals("")){
					 sch_size ="1";
			 }	
			 //out.println("==sch_size=="+sch_size+",durn_value=="+durn_value+",dosage_type=="+dosage_type);
			if(!repeat_durn_type.equals(or_durn_desc1))
			{
				if(tmp_durn_value!=null && tmp_durn_value!="" && tmp_durn_value!="0")
					durn_value=tmp_durn_value;
			}
					//Code Added For ICN 29927	RUT-CRF-0034 Start
					route_code=(String)drugDetails.get("ROUTE_CODE")==null?"":	(String)drugDetails.get("ROUTE_CODE");  
					fntColor="000000";
					ArrayList routes				=	bean.getRoutes((String)drugDetails.get("FORM_CODE")); 
					for(int l=0; l<routes.size(); l+=3) { 
						if(route_code.equals(routes.get(l))){
							route_desc = (String)routes.get(l+1);
							route_color = (String)routes.get(l+2);
							break;
						}
					}
					if(route_color!= null && !route_color.equals("") && route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);// added for CRF RUT-CRF-0034.1[IN:037389]
					}
					addRouteDesc="("+route_desc+")"; 	// removed font for CRF RUT-CRF-0034.1[IN:037389]
					//Code Added For ICN 29927	RUT-CRF-0034 End
			
			
			String order_qty	=	bean.getOrderQty(drugDetails,qty_value,sch_size,durn_value,dosage_type,conv_factor,split_chk,"","","Preview");
			//out.println("order qty="+order_qty);
			order_qty			=	new Float(Math.ceil(Float.parseFloat(order_qty))).intValue()+"";
			
			String order_uom	=	bean.getOrderUnit(dosage_type,order_qty,drug_code);
			boolean override_flag=false; //MMS-KH-CRF-0029
		if(j==0 || !taper_yn.equals("Y")) {					

	%>
		<tr><td class="data" colspan="7" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td></tr>
		<tr><td width="10%">&nbsp;</td>
			<!-- <td class="data" WRAP colspan="3"  width="50%"><%=(String)drugDetails.get("DRUG_DESC")%>&nbsp;&nbsp;<%=strength_value%>&nbsp;<%=strength_uom%> &nbsp;&nbsp;<%=(String)drugDetails.get("FORM_CODE")%>&nbsp;&nbsp;</td> commented on 8/10/09-->
			<td class="data" WRAP colspan="3"  width="50%"><%=(String)drugDetails.get("DRUG_DESC")%>&nbsp;&nbsp;<%=strength_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,strength_uom))%>&nbsp;&nbsp;<%=(String)drugDetails.get("FORM_CODE")%>&nbsp;&nbsp;</td>
		<td class="data" wrap ><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class="data" wrap  width="15%"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class="data" wrap  width="15%"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		</tr>
		<tr>
		
			<td width="10%">&nbsp;</td>
			<td class="label" wrap  colspan="3">&nbsp;&nbsp;<%=tooltip%>&nbsp;<font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=addRouteDesc%></font></td>
			<td class="label"><%=order_qty%>&nbsp;<%=order_uom%></td>
			<td class="label" wrap ><%=(String)drugDetails.get("START_DATE")%></td>
			<td class="label" wrap ><%=(String)drugDetails.get("END_DATE")%></td>
		</tr>
		
		<tr>	<td width="10%">&nbsp;</td>
				 <td colspan="6" class="label"> 
	<%
				if(!freq_str.equals("")) { 
					//out.println("freq_str--386--->" +freq_str);	
					freq_str=freq_str.trim();
					/*StringTokenizer st =new StringTokenizer(freq_str, ";");
					int countTokens = st.countTokens();
					//out.println("countTokens--393--->" +countTokens);		
					while (st.hasMoreTokens()){
						String ssssexa=st.nextToken();
						StringTokenizer st1 =new StringTokenizer(ssssexa, " ");
				
						while (st1.hasMoreTokens()){
								if(st1.hasMoreTokens())
									freq_str1=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str2=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str3=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str4=st1.nextToken();
						}
				out.println(freq_str1+" "+freq_str2+" "+freq_str3+" "+bean.getUomDisplay(facility_id,freq_str4)+";" );
				}*/
				out.println(freq_str);
		%>
				</td> 				
		</tr>
	<%	}	
		if(!pres_remarks.equals("")) {
	%>
		<tr>	
			<td width="10%">&nbsp;</td>
			<td colspan="6" class="label"><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=pres_remarks%></td>	
		</tr>
	<%	}		

		if(no_refill!=null && (!no_refill.equals(""))) {	%>
		<tr><td class="data" colspan="7">&nbsp;</td></tr>
			<%
			if(!RefillDetail.isEmpty()){for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { //if condtion added for regration issue		
			%>
			<tr>
				<td width="10%" class="data"><fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/></td>
				<!-- Modified for IN:069886 start-->
				<%if(p==(((ArrayList)RefillDetail.get("refill_start_date")).size()-1)){%>	
				<td class="label" wrap colspan="4">&nbsp;&nbsp;<%=tooltipnew%></td>
				<%}else{ %>
				<td class="label" wrap colspan="4">&nbsp;&nbsp;<%=tooltip%></td>
				<%} %>
				<!-- Modified for IN:069886 end-->
				<td class="label" wrap ><%=((ArrayList)RefillDetail.get("refill_start_date")).get(p)%></td>
				<td class="label" wrap ><%=((ArrayList)RefillDetail.get("refill_end_date")).get(p)%></td>
			</tr>
	<%			} 
		}
		}
		
		} else	{	%>
		<tr><td class="data" colspan="7">&nbsp;</td></tr>
	<%
				if(freq_nature.equals("O") || freq_nature.equals("P")) {
	%>
		<tr><td class="data" colspan="7" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td></tr>
	<%		} else  { %>
		<tr>
			<td width="10%" class="data"><fmt:message key="Common.Taper.label" bundle="${common_labels}"/></td>
			<td class="label" wrap  colspan="3">&nbsp;&nbsp;<%=tooltip%></td>
		    <td class="label"><%=order_qty%>&nbsp;<%=order_uom%></td>
			<td class="label" wrap ><%=(String)drugDetails.get("START_DATE")%></td>
			<td class="label" wrap ><%=(String)drugDetails.get("END_DATE")%></td>
		</tr>
	<% 			}
		if(!freq_str.equals("")) { %>
		<tr>	<td width="10%">&nbsp;</td>
				<td colspan="6" class="label">&nbsp;&nbsp;<%=freq_str%></td>	
		</tr>
	<%	}
		if(!pres_remarks.equals("")) {
	%>
		<tr>	
			<td width="10%">&nbsp;</td>
			<td colspan="6" class="label"><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=pres_remarks%></td>	
		</tr>
	<%	}	
	
		}		   
		k++;
		 //Code Added for SKR-SCF-0647[Inc:35263]-Start
		 if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){
	    %>
				<tr>	
					<td width="10%">&nbsp;</td>
					<td colspan="6" class="label"><b><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=PRN_remarks_dtl%></td>
				</tr>
		<%	  
			   }
		      if(!drugindication_remarks.equals("")) {
		%>
			  <tr>	
				 <td width="10%">&nbsp;</td>
				 <td colspan="6" class="label"><b><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=drugindication_remarks%></td>	
			</tr>
		<%
				} //MMS-KH-CRF-0029 - start
				if((!override_remarks.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")) || ( !allergy_remarks.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")) || ( ((String)drugDetails.get("LIMIT_IND")).equals("N")) || ((interaction_exists.equals("Y") && !interaction_remarks.equals("")) || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals(""))) //modified for MMS-KH-CRF-0029
				{  
				override_flag = true; 
%>
				<tr>	
					<td width="5%" class=label>&nbsp;</td>
					<td class=label width="17%" valign='TOP'><U><b><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></b></U></td>

					</tr><br><br>
<%				} //MMS-KH-CRF-0029 - end

		    if(!override_remarks.equals("")) {
		%>
		    <tr>	
				<td width="10%">&nbsp;</td>
				<td colspan="6" class="label"><b><fmt:message key="ePH.DuplicateRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=override_remarks%></td><!-- modified for MMS-KH-CRF-0029[IN070606]-->
				</tr>
		<%
			}
		  if(!allergy_remarks.equals("")){
	    %>
		  <tr>	
			  <td width="10%">&nbsp;</td>
			   <td colspan="6" class="label"><b><fmt:message key="ePH.AllergyRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=allergy_remarks%></td>
			   </tr>
		<%	
			}
		  if(!dosage_remarks.equals("")){
		%>
		 <tr>	
			  <td width="10%">&nbsp;</td>
			   <td colspan="6" class="label"><b><fmt:message key="ePH.OverDoseRemarks.label" bundle="${ph_labels}"/>:</b><%=dosage_remarks%></td>
			   </tr>
		<%
		}//Code Added for SKR-SCF-0647[Inc:35263]-End
		//MMS-KH-CRF-0029 [IN070606] - start
			ArrayList hmDrugIntList=(ArrayList) drugDetails.get("INTERACTION_DTL");
			String interaction_desc = "";
			String interaction_type = "";
			ArrayList intrType = new ArrayList();
			HashMap DrugInteractionDtl=  null;
			if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
				for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
					DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
				  interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
				  interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");
					intrType.add(interaction_type);
				}
			}
			String drug_drug_display = "none";
			String drug_food_display = "none";
			String drug_lab_display = "none";
			String drug_disease_display = "none";//MMS-DM-CRF-0229
			String drug_food_remarks ="";
			String drug_lab_remarks ="";
			String drug_disease_remarks ="";//MMS-DM-CRF-0229

			if(intrType!=null && intrType.size()>0){
			if(intrType.contains("D") || intrType.contains("G")){
				drug_drug_display = "inline";
			}
			if(intrType.contains("F")){
				drug_food_display = "inline";
			}
			if(intrType.contains("L")){
				drug_lab_display = "inline"; 
			}
			if(intrType.contains("I")){//MMS-DM-CRF-0229
    			drug_disease_display = "inline"; 
			}
			drug_food_remarks = food_interaction_remarks;
			drug_lab_remarks = lab_interaction_remarks;
			drug_disease_remarks = disease_interaction_remarks;//MMS-DM-CRF-0229

			} 
			if(interaction_exists.equals("Y") && !interaction_remarks.equals("") && drug_drug_display.equals("inline")){
%>
				<tr>	
					<td width="5%" class=label>&nbsp;</td>
					<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_DrugInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>  
					<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=interaction_remarks%></td>
				</tr>  
			 
<%		
			}
			if(drug_food_display.equals("inline") && override_flag ){ 
%>
				<tr>	
					<td width="5%" class=label>&nbsp;</td>
					<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_FoodInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
					<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_food_remarks%></td>
				</tr>
			
<%		
			}
			if(drug_lab_display.equals("inline") && override_flag){ 
%>
				<tr>	
					<td width="5%" class=label>&nbsp;</td>
					<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_LabInteractionRemarks.label" bundle="${common_labels}"/>&nbsp;:</b></td>
					<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_lab_remarks%></td>
				</tr> <!-- added for MMS-KH-CRF-0029[IN070606] end-->
			
<%		
			}
             if(drug_disease_display.equals("inline") && override_flag){ //modified for MMS-DM-CRF-0229
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug-DiseaseInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_disease_remarks%></td>
											</tr> 
<%		
										}
		
	  }
			if( (i!=(grp.size())-1))
			%>
			<tr><td class="white"></td></tr><tr><td class="white"></td></tr>	
			<%
			}
	%>
	<%    String clinical_comments	=	bean.getPresRemarks();
		   if(clinical_comments!=null && !clinical_comments.equals("")) {
	%>
		<tr>
			<td class="white"></td></tr><tr><td class="white"></td>
		</tr>
		<tr>
			<td class="white"></td></tr><tr><td class="white"></td>
		</tr>
		<tr>
			<td width="10%" colspan="2" class="data"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</td>
			<td colspan="5" class="label">&nbsp;&nbsp;<%=clinical_comments%></td>	
		</tr>
	<%	   }
	%>
			</table>
<%
	}
if(consumableDetails.size()>0){%>
<table border="0" width="100%" cellspacing="0" cellpadding="0" id="prescription_table">
<%
	%>
	<tr><td class="data" colspan="7" ><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></td></tr>
	<%
for(int i=0;i<consumableDetails.size();i++)
	{

	HashMap  cons_dtl      =  new HashMap(); 
	cons_dtl =(HashMap)consumableDetails.get(i);
	
	HashMap batchDetails   =  new HashMap(); 
	
		 if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals(""))
			 {   
			
				batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
						
				%>

	<tr><td width="10%">&nbsp;</td>
<td class="data" WRAP colspan="3"  width="50%"><%=(String)batchDetails.get("ITEM_NAME")%>
				<td class="label"><%=(String)cons_dtl.get("ALLOC_QTY")%>&nbsp;<%=(String)cons_dtl.get("ORDER_UOM")%></td>
				</TR>
			<%  }
	}

}

%>
</form>
</body>
	<%
	putObjectInBean(bean_id,bean,request);
	//putObjectInBean(or_bean_id,orbean,request);
	}
catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
	
	}%>
</html>


