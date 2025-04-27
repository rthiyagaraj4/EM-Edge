<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %><!-- ,webbeans.eCommon.*,java.sql.* added for ML-MMOL-CRF-1013 -->
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<% 
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>

async function checkAndAmendDrug(disc_vals,cancel_vals,patient_id,generic_id,encounter_id,alternate_amend_yn,order_id,order_line_no,drug_code,patient_id1,encounter_id1,locn_type,locn_code,patientclass,iv_prep_yn)
{
	var ret = await recordDiscCanValue(disc_vals,cancel_vals,patient_id,generic_id,encounter_id,alternate_amend_yn)
   if (ret) 
   {
      await  amendAltDrug(order_id,order_line_no,drug_code,patient_id1,encounter_id1,locn_type,locn_code,patientclass,iv_prep_yn)
   }
}

</script>
  <!-- Added for JD-CRF-0198 [IN058599] -->
		<title><fmt:message key="ePH.Drug/DosageDetail.label" bundle="${ph_labels}"/></title>
	</HEAD>
		<style>
textarea {
  resize: none;
}
</style>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String order_id				= request.getParameter( "order_id" ) ;
		String patient_id				= request.getParameter( "patient_id" ) ;
		String patient_class		= request.getParameter( "patient_class" ) ;
		String order_line_no		= request.getParameter( "order_line_no" ) ;
		String locn_code			= request.getParameter( "locn_code" ) ;
		String drug_code			= request.getParameter( "drug_code" ) ;
		String called_from			= request.getParameter( "called_from" ) ;	
		String disp_locn_code		= request.getParameter( "disp_locn_code" )==null?"":request.getParameter("disp_locn_code"); 
		String sliding_scale_applicable	= request.getParameter( "from_sliding_scale_yn" )==null?"":request.getParameter("from_sliding_scale_yn"); 
		String mfr_yn				= request.getParameter( "mfr_yn" )==null?"":request.getParameter("mfr_yn");
		String facility_id			= (String) session.getValue("facility_id");
	        String disp_stage           = request.getParameter( "disp_stage" ) ; // added for JD-CRF-0198 [IN058599] - Start
	        String generic_id           = request.getParameter( "generic_id" ) ;   		
	        String pract_id             = request.getParameter( "pract_id" ) ; 
	        String allow_amend_alt_drug_dtl             = request.getParameter( "allow_amend_alt_drug_dtl" ) ; 
	        String order_line_status    = request.getParameter( "order_line_status" ) ;
	        String disc_vals            = "";
	        String cancel_vals          = "";   // added for JD-CRF-0198 [IN058599] - End
	       //added for ML-MMOH-CRF-1013 start
	        Connection	con=null;
	    	boolean tpn_standard_non_standard=false;
	    	con	= ConnectionManager.getConnection(request);
	    	try{
	    		
	    		tpn_standard_non_standard = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STAND_NON_STAND_LABEL");
	    		System.out.println("Site==>"+tpn_standard_non_standard);
	    		//bean.setIssite(site);
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	finally
	    	{
	    		con.close();
	    	}
        //added for ML-MMOH-CRF-1013 end
		if(order_line_no.equals("")){
			order_line_no="%";
			drug_code="%";
		}

		if(called_from	== null)
			called_from	=	"";
		
		String	bean_id				=	"DispMedicationAllStages" ;
		String	bean_name			=	"ePH.DispMedicationAllStages";
		
		DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
		//bean.setLanguageId(locale);
		String iv_prep_yn			=	bean.getIVFlag(order_id)==null?"":bean.getIVFlag(order_id);
		String	bean_id_2			=	"DispMedicationBean" ;
		String	bean_name_2			=	"ePH.DispMedicationBean";	
		DispMedicationBean bean_2 = (DispMedicationBean)getBeanObject( bean_id_2, bean_name_2, request);

		//bean_2.setLanguageId(locale);
		bean_2.setDispLocnCode(disp_locn_code);
		String	bean_id_3			=	"MedicationAdministrationFTBean" ;
		String	bean_name_3			=	"ePH.MedicationAdministrationFTBean";	
		MedicationAdministrationFTBean bean_3 = (MedicationAdministrationFTBean)getBeanObject( bean_id_3, bean_name_3, request);

		String bl_patient_class     =   bean.getEncounterPatientClass((String)bean_2.getEncounterID(), patient_id);  // patient_id  added for [IN:035667] 

		if(bl_patient_class.equals("I")){
			bl_patient_class="IP";
		}
		else if(bl_patient_class.equals("O")){
			bl_patient_class="OP";
		}
		else if(bl_patient_class.equals("D")){
			bl_patient_class="DC";
		}
		else if(bl_patient_class.equals("E")){
			bl_patient_class="EM";
		}
		else if(bl_patient_class.equals("R")){
			bl_patient_class="XT";
		}
		ArrayList tot_drug_det		=	bean.getDrugDetails(patient_class,locn_code,order_id,drug_code,order_line_no);
		String drug_name			=	"";
		String route_desc			=	"";
		String dosage				=	"";
		String freq_desc			=	"";
		String start_date			=	"";
		String end_date				=	"";
		String duration				=	"";
		String pres_qty				=	"";
		String dosage_dtls			=	"";
		String timing_dtls				=	"";
		String time_val				=	"";
		String dose_val				=	"";
		String allergy_reason		=	"";
		String exceed_dose_reason	=	"";
		String duplicate_reason		=	"";
		String alternate_amend_reason="";
		String all_drug_dose		=	"";
		String amend_dtl_btn_yn     =   "";  // added for JD-CRF-0198 [IN058599]
		String total_daily_fluid    = ""; //added for ML-MMOH-CRF-1013
		String enteral_feeding      = ""; //added for ML-MMOH-CRF-1013
		String location_type		=	"";
		String discharge_ind		=	"";
		String order_line_num		=	"";
		String drug_yn				=	"";
		String dose					=	"";
		String tmp					=	null;
		String div_str				=	"";
		String split_yn				=   "";
		String ord_iv_prep_yn				=   "";
		
		//Added New Varaibles for the incident num:24533 on 18/Oct/2010==By Sandhya
		String encodeduplicate_reason				=	"";
		String encodeexceed_dose_reason				=	"";
		String encodeallergy_reason				=	"";
		String route_color			=	""; 	// added for CRF RUT-CRF-0034.1 [IN:037389]-start
		String backgrndColor= "";
	    String fntColor="";	// added for CRF RUT-CRF-0034.1 [IN:037389]-End

		if(bl_patient_class.equals("OP")||bl_patient_class.equals("EM"))
			location_type = "C";
		else if(bl_patient_class.equals("IP")||bl_patient_class.equals("DC"))
			location_type = "N";
		
		ArrayList remarks=new ArrayList();
	//	if(!order_line_no.equals("%"))
	//	{
		 remarks			= bean.getPresRemarks(order_id,order_line_no);
	//	}
%>
		<FORM name="DispMedicationDrugDetailsForm" id="DispMedicationDrugDetailsForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1"><!-- changed With from 100 to 105 for ML-MMOH-CRF-1013 -->
				<tr>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="ePH.PrescribedQty.label" bundle="${ph_labels}"/></td>
				    <td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/> </td>
				<!-- added for ML-MMOH-CRF-1013 start -->
				<%
				if(iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))
				{
				if(tpn_standard_non_standard)
				{
				%>
				    <td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="ePH.TotalDailyFluid.label" bundle="${ph_labels}"/>&nbsp;<label id='totaldailyfluidunit' name='totaldailyfluidunit'><b>(<fmt:message key="ePH.ml.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.kg.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.day.label" bundle="${ph_labels}"/>)</b></label></td>
				    <td class= "COLUMNHEADER"  align="left" style="font-size:9"><fmt:message key="ePH.EnteralFeeding.label" bundle="${ph_labels}"/> </td>
				   <%
				   }   
				}
			%>
				 <!-- added for ML-MMOH-CRF-1013 end -->
				<%
				if(allow_amend_alt_drug_dtl.equals("Y")){
				%>
				<td class= "COLUMNHEADER"  align="left" style="font-size:9">Amend Reason</td>
				<%}%>
				</tr>
<%
				if(tot_drug_det.size() > 0 ) {
					for(int i=0;i<tot_drug_det.size();i++){
						HashMap	drug_det=(HashMap)tot_drug_det.get(i);
						drug_name			= (String)drug_det.get("form_drug");
						route_desc			= (String)drug_det.get("route_desc");
						route_color			= (String)drug_det.get("route_color");// added for CRF RUT-CRF-0034.1[IN:037389]
						ord_iv_prep_yn			= (String)drug_det.get("iv_prep_yn");
						if(route_desc.equals(""))
							route_desc ="&nbsp;";
						if(route_color!= null && !route_color.equals("")){  // added if condition for CRF RUT-CRF-0034.1[IN:037389]-start
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}// added for CRF RUT-CRF-0034.1 [IN:037389]-end
						dosage				= (String)drug_det.get("dosage");
						if(dosage.startsWith("."))
							dosage			="0"+dosage;
						drug_yn				= (String)drug_det.get("drug_yn");	
						if(drug_yn.equals("Y")){
							freq_desc			= (String)drug_det.get("freq_desc");
							start_date			= (String)drug_det.get("start_date");
							end_date			= (String)drug_det.get("end_date");
							duration			= (String)drug_det.get("duration");

							split_yn			 =  (String)drug_det.get("split_yn");	
							if(split_yn.equals("Y")) //added for IN25545 --20/12/2010-- priya
								freq_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels");
						}
						else{
						   /* Commented By SureshKumar T For The RR20056-SCF-7431 [Incident No : 27482 ] and SRR20056-SCF-7432 [Incident No. 27483] */
						   if(ord_iv_prep_yn == null || ord_iv_prep_yn.equals("")){
								freq_desc			= "&nbsp;";	
								start_date			= "";
								end_date			= "";
								duration			= "&nbsp;";
						   }
						   else{
							/*added The Code By SureshKumar T For The SRR20056-SCF-7431 [Incident No : 27482 ] and SRR20056-SCF-7432[Incident No. 27483]*/
								freq_desc			= (String)drug_det.get("freq_desc");
								start_date			= (String)drug_det.get("start_date");
								end_date			= (String)drug_det.get("end_date");
								duration			= (String)drug_det.get("duration");
						   }
						}
						pres_qty			= (String)drug_det.get("order_qty");
						dosage_dtls			= (String)(drug_det.get("dosage_dtls"));
						//added for ML-MMOH-CRF-1013 start 
						if(tpn_standard_non_standard){
 						total_daily_fluid		= (String)(drug_det.get("total_daily_fluid")==null?"":drug_det.get("total_daily_fluid"));
 						enteral_feeding			= (String)(drug_det.get("enteral_feeding")==null?"":drug_det.get("enteral_feeding"));
						}
					    //added for ML-MMOH-CRF-1013 end
					
						// Commented on 18/Oct/2010 regarding incident num:24533 ==By Sandhya
						allergy_reason		=  java.net.URLEncoder.encode((String)drug_det.get("allergy_reason"),"UTF-8");
						exceed_dose_reason	= java.net.URLEncoder.encode((String)drug_det.get("exceed_dose_reason"),"UTF-8");
						duplicate_reason	= java.net.URLEncoder.encode((String)drug_det.get("duplicate_reason"),"UTF-8");
						alternate_amend_reason = (String)(drug_det.get("alternate_amend_reason")==null?"":drug_det.get("alternate_amend_reason"));
				//Added code for replacing ??? for Allergy,duplicate,Drug reasons in Thai Regarding incident num:24533 on 18/Oct/2010 ==By Sandhya
					/*	encodeallergy_reason= (String)drug_det.get("allergy_reason");
						allergy_reason		= encodeallergy_reason.replaceAll(" ","%20");
						allergy_reason		= java.net.URLEncoder.encode(encodeallergy_reason,"UTF-8");
						allergy_reason		= encodeallergy_reason.replaceAll("%2520","%20");
						encodeexceed_dose_reason=(String)drug_det.get("exceed_dose_reason");
						exceed_dose_reason=encodeexceed_dose_reason.replaceAll(" ","%20");
						exceed_dose_reason=java.net.URLEncoder.encode(encodeexceed_dose_reason,"UTF-8");
						exceed_dose_reason=encodeexceed_dose_reason.replaceAll("%2520","%20");
						encodeduplicate_reason=(String)drug_det.get("duplicate_reason");
						duplicate_reason= encodeduplicate_reason.replaceAll(" ","%20");
						duplicate_reason= java.net.URLEncoder.encode(encodeduplicate_reason,"UTF-8");
						duplicate_reason= encodeduplicate_reason.replaceAll("%2520","%20"); //End*/
						discharge_ind		= (String)drug_det.get("discharge_ind");
						order_line_num		= (String)drug_det.get("order_line_num");

						if(dosage.equals("Sliding"))
							sliding_scale_applicable ="Y";

						if(discharge_ind.equals("D")&& patient_class.equals("OP")){
							patient_class="IP";
							location_type = "N"; //line added on 22/3/2010 
						}

						if(freq_desc==null) 
							freq_desc	=	"";
						// Below lines commented for IN23960 --01/10/2010-- priya
					/*	if(!dosage_dtls.equals("")) {
							StringTokenizer time	=	new StringTokenizer(dosage_dtls,"$");
							if(time.hasMoreTokens()) {
								time_val			=	(String)time.nextToken();	
								dose_val			=	(String)time.nextToken();	
							} 
						}*/


						boolean firstTime	=	true;
						boolean found		=	false;

						StringTokenizer st_2=new StringTokenizer(dose_val," ");
						while(st_2.hasMoreTokens()) { 
							dose	=	(String)st_2.nextToken();
							if(dose.startsWith("Dosage"))
								dose	=	new StringBuffer(dose).replace(0,6,"").toString();
							if(firstTime){
								tmp			=	dose;
								firstTime	=	false;
							} 
							else if(!tmp.equals(dose)){
								found		=	true;
								break;
							}
					   }

					   if(found){
							div_str =" <label style='color:red'>("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels")+") </label>";
						}
						else{
							div_str ="";
						}
						remarks				 = bean.getPresRemarks(order_id,order_line_num);
%>
						<tr>
							<td class="QRYEVENSMALL"><%=drug_name%></td>
<%	
							if((iv_prep_yn.equals("1")||iv_prep_yn.equals("2")||iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))&& Integer.parseInt(order_line_num)>1){
%>
								<td class="QRYEVENSMALL">&nbsp;</td>		
<%
							}
							else{
%>
								<td class="QRYEVENSMALL" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'><%=route_desc%></td>	<!-- // style added for CRF RUT-CRF-0034.1 [IN:037389]-->
<%
							}
%>
							<td class="QRYEVENSMALL"><%=dosage%>&nbsp;<%=div_str%></td>	
							<td class="QRYEVENSMALL"><%=freq_desc%></td>
							<td class="QRYEVENSMALL"><%if(!start_date.equals("")){out.print(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale));}else{out.print("&nbsp;");}%></td>
							<td class="QRYEVENSMALL"><%if(!start_date.equals("")){out.print(com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale));}else{out.print("&nbsp;");}%></td>
							<td class="QRYEVENSMALL"><%=duration%></td>
							<td class="QRYEVENSMALL"><%=pres_qty%></td>
							<td class="QRYEVENSMALL">&nbsp; 
							<!-- added for ML-MMOH-CRF-1013 start -->
				     <%
							if(iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))
							{
							if(tpn_standard_non_standard)
							{
						%>
							<td class="QRYEVENSMALL"><%=total_daily_fluid%></td>
							<td class="QRYEVENSMALL"><%=enteral_feeding%></td>
				<%
							}
							}
							    %>
							<!-- added for ML-MMOH-CRF-1013 end -->
<% 
							if(!allergy_reason.equals("") || !exceed_dose_reason.equals("") || !duplicate_reason.equals("") ) {
%>
								<input type="button"  class="button" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>'     onClick="showOverRideReason('<%=allergy_reason%>','<%=exceed_dose_reason%>','<%=duplicate_reason%>')" style="cursor:pointer">
<% 
							}
%>
							</td>
							<td class="QRYEVENSMALL">&nbsp; 
							<%
							if(allow_amend_alt_drug_dtl.equals("Y") && !alternate_amend_reason.equals("") ) {
							%>
							<label><%=alternate_amend_reason%></label>
							<%
							}
%>
							</td>
						</tr>
						<tr>
<% 
						if(remarks.size()!=0) { 
%>
							<td class="QRYODDSMALL" colspan="8">&nbsp;<b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:</b>&nbsp;&nbsp;
<%	
							for(int j=0; j<remarks.size(); j++) {	
								if(j==(remarks.size()-1)) {
%>
									<%=remarks.get(j)%>
<%		
								}
								else { 
%>
									<%=remarks.get(j)+","%>
<%		
								}
							}  
%>
							</td> 
 <%  
						}
%>
						</tr>
<%
					}
				}
%>
			</table>
			<br>
<% //==================replaced table with timings and dosage details with schedule frequency string for IN23960 --01/10/2010-- priya
			if( dosage_dtls!=null && !dosage_dtls.equals("") && !dosage_dtls.equals("$")){
				//"&& !dosage_dtls.equals("$")" added By SureshKumar T For The SRR20056-SCF-7431 [Incident No : 27482 ]	and SRR20056-SCF-7432[Incident No. 27483]
				String [] timing_dsg_dtls = dosage_dtls.split("Dosage :");
				StringTokenizer timing_dtl = new StringTokenizer(timing_dsg_dtls[0], "|"); //Added for  ML-BRU-SCF-1032 [IN:043723] -Start
				StringTokenizer dosage_dtl = new StringTokenizer(timing_dsg_dtls[1], "|"); 
				dosage_dtl.nextToken();
				int divToken=dosage_dtl.countTokens();
				if(divToken<1){
					divToken=1;
				}
				int width = 100/divToken;
				
				if(width>=30 || width<15)
					width = 15;
				int count=0;//Added for  ML-BRU-SCF-1032 [IN:043723] -End
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<th align="left" style="font-size:9" colspan='<%=timing_dtl.countTokens()+1%>'><fmt:message key="ePH.ScheduledFrequency.label" bundle="${ph_labels}"/></th>
					<tr>
<%
						while (timing_dtl.hasMoreElements()){ //While loop added for ML-BRU-SCF-1032 [IN:043723]
							if(count==0){
								count++;
%>
								<td class="QRYEVENSMALL" width='10%'>&nbsp;<%=timing_dtl.nextToken()%>&nbsp;</td>
<%
							}
							else{
%>
								<td class="QRYEVENSMALL" width='<%=width%>%'>&nbsp;<%=timing_dtl.nextToken()%>&nbsp;</td>
<%
							}
						}
%>
							<td class="QRYEVENSMALL" width='*'>&nbsp;</td>
					</tr>
					<tr>
						<td class="QRYEVENSMALL" >&nbsp;<fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>:</td>
<%
						while (dosage_dtl.hasMoreElements()){//While loop added for ML-BRU-SCF-1032 [IN:043723]
%>
							<td class="QRYEVENSMALL" width='<%=width%>%' >&nbsp;<%=dosage_dtl.nextToken()%>&nbsp;</td>
<%
						}
%>
							<td class="QRYEVENSMALL" width='*'>&nbsp;</td>
					</tr>
				</table>
<% 	
			}
			//code added for change dose  (Amend button).....on 29/4/2004
			if(!order_line_no.equals("%")){
				all_drug_dose = bean.getAllDrugDosage(order_id,order_line_no,disp_locn_code);
			}	
			if(allow_amend_alt_drug_dtl.equals("Y")){ // Start - code added for JD-CRF-0198 [IN058599]
				amend_dtl_btn_yn = bean.getAllowAmendDtlYN(order_id,order_line_no);
			}                                         // End - code added for JD-CRF-0198 [IN058599]
			if(sliding_scale_applicable.equals("Y")){
				ArrayList sliding_scale_details =   bean.getSlidingScaleTemplateDetails(order_id,order_line_no);
				if(sliding_scale_details.size()>0){
%>
				<table cellpadding="0" cellspacing="0" width="70%" align="center" border="1">
					<tr>
						<th style="font-size:9" colspan=6><%=(String)sliding_scale_details.get(8)%></th>		
						</tr>
						<tr>
						<th align="left" style="font-size:9"><fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/></th>
						<th align="left" style="font-size:9"><fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/></th>
						<th align="left" style="font-size:9"><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
						<th align="left" style="font-size:9"><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/></th>
						<th align="left" style="font-size:9"><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
						<th align="left" style="font-size:9"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					</tr>
<%
					String sRemarks="&nbsp;";
					String toRan="";
					String admUnit="";
					for(int sl=0;sl<sliding_scale_details.size();sl+=9){
%>
						<tr>
							<td><%=(String)sliding_scale_details.get(sl+2)%></td>
<%
							toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
							admUnit=(String)sliding_scale_details.get(sl+4);
							if(admUnit!=null && !admUnit.equals(""))
							{
								float admUnitValue=Float.parseFloat(admUnit);
								if(admUnitValue>0.0 && admUnitValue<1.0)
									admUnit=Float.parseFloat(admUnit)+"";
							}
%>			
							<td><%=toRan%></td>	
							<td><%=(String)sliding_scale_details.get(sl+5)%></td>	
							<td><%=admUnit%></td>	
							<td><%=(String)sliding_scale_details.get(sl+6)%></td>
<%
							//	sRemarks=((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null")?"&nbsp":(String)sliding_scale_details.get(sl+7);
							if(sliding_scale_details.get(sl+7) ==null || ((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") ) 
								sRemarks = "&nbsp"; //"&nbsp;" added for 10.X-CRF-SRR20056-CRF-0675
							else
								//sRemarks = (String)sliding_scale_details.get(sl+7); //decode removed for 10.X-CRF-SRR20056-CRF-0675
								sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");//decode added for skr-scf-250
%>
							<td><%=sRemarks%></td>	
<%
						}
%>
					</table>
<%
				}
			}
			else if(mfr_yn.equals("Y")){
				ArrayList mfrDetails=bean_3.getMFRDetails(order_id,order_line_no);
				HashMap dtls;
				String flow_srl_no,infusionDateTime,infusionEndTime,gap_duration_in_hrs,tot_strength,tot_strength_uom;
				if(mfrDetails.size()>0){
%>
					<table cellpadding="0" cellspacing="0" width="70%" align="center" border="1">
						<tr>
							<th style="font-size:9" colspan=6><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/></th>		
						</tr>
						<tr>
							<th align="left" style="font-size:9"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/> #</th>
							<th align="left" style="font-size:9"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
							<th align="left" style="font-size:9"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
							<th align="left" style="font-size:9"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
							<th align="left" style="font-size:9"><fmt:message key="ePH.GapHours.label" bundle="${ph_labels}"/></th>		
						</tr>
<%		
						for(int jj=0;jj<mfrDetails.size();jj++){
							dtls=(HashMap)mfrDetails.get(jj);
							flow_srl_no = (String)dtls.get("SL_NO")==null?"1":(String)dtls.get("SL_NO");
							infusionDateTime=(String)dtls.get("START_DATE_TIME")==null?"":(String)dtls.get("START_DATE_TIME");
							infusionDateTime = com.ehis.util.DateUtils.convertDate(infusionDateTime,"DMYHM","en",locale);
							infusionEndTime=(String)dtls.get("END_DATE_TIME")==null?"":(String)dtls.get("END_DATE_TIME");
							infusionEndTime = com.ehis.util.DateUtils.convertDate(infusionEndTime,"DMYHM","en",locale);
							gap_duration_in_hrs = (String)dtls.get("GAP_DURATION_IN_HRS")==null?"":(String)dtls.get("GAP_DURATION_IN_HRS");				
							tot_strength = (String)dtls.get("TOT_STRENGTH")==null?"":(String)dtls.get("TOT_STRENGTH");
							tot_strength_uom = (String)dtls.get("TOT_STRENGTH_UOM")==null?"":(String)dtls.get("TOT_STRENGTH_UOM");
%>
							<tr>
								<td align="center"><%=flow_srl_no%></td>
								<td><%=tot_strength%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),tot_strength_uom)%></td><!--tot_strength_uom is changed to bean.getUomDisplay((String)session.getValue("facility_id"),tot_strength_uom) for ML-BRU-SCF-0417 [IN:035080] -->
								<td><%=infusionDateTime%></td>
								<td><%=infusionEndTime%></td>
								<td>
<%
								int tempval=Math.round(Float.parseFloat(gap_duration_in_hrs)*60);					
								if(tempval>0){
									int hrs = tempval / 60;
									int min = tempval % 60;
%>
									<%=hrs%> <fmt:message key="Common.Hrs.label" bundle="${common_labels}"/> <%=min%> <fmt:message key="ePH.Mins.label" bundle="${ph_labels}"/>
<%
								}
								else{
%>
									&nbsp;
<%
								}
%>
							</td>
						</tr>
<%	
					}	
%>
					</table>		
<%
				}
			}
			String fill_list = bean_2.getFillList().trim()==null?"":bean_2.getFillList().trim();
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td  class="white" width="12%">&nbsp;
<%  
					//code added for change dose  (Amend button).....on 29/4/2004
					//	if(all_drug_dose.equals("Y") && called_from.equals("")&&(drug_yn.equals("Y") || iv_prep_yn.equals("8"))  && !iv_prep_yn.equals("6")) {
				if(all_drug_dose.equals("Y") && called_from.equals("")&&(drug_yn.equals("Y") || iv_prep_yn.equals("8"))  && !iv_prep_yn.equals("6")) {
%>
						<input type="button" class="button" value='<fmt:message key="ePH.AmendPrescription.label" bundle="${ph_labels}"/>'   onClick="callAmendReasonRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','O','<%=(String)bean_2.getPatientID()%>','<%=(String)bean_2.getEncounterID()%>','<%=location_type%>','<%=locn_code%>','<%=bl_patient_class%>','<%=iv_prep_yn%>')">
<%
					}
%>
					</td>
					
					<td  class="white" width="12%"> <!-- Start - code added for JD-CRF-0198 [IN058599] -->
<%  			
					if(amend_dtl_btn_yn.equals("Y") && !fill_list.equals("AF") && drug_yn.equals("Y") && iv_prep_yn.equals("") && !disp_stage.equals("V") && !disp_stage.equals("D") && allow_amend_alt_drug_dtl.equals("Y") ) { 
						bean_2.setGenericId(generic_id);
						bean_2.setOrStatus_1(order_line_status); 
						disc_vals=order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+drug_code+"~"+generic_id;  																				 							  
%> 
<%-- 						<input type="button" class="button" value='<fmt:message key="ePH.AmendAlternateDrug.label" bundle="${ph_labels}"/>'   onClick="if(recordDiscCanValue('<%=disc_vals%>','<%=cancel_vals%>','<%=(String)bean_2.getPatientID()%>','<%=generic_id%>','<%=(String)bean_2.getEncounterID()%>','Y')) {amendAltDrug('<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','<%=(String)bean_2.getPatientID()%>','<%=(String)bean_2.getEncounterID()%>','<%=location_type%>','<%=locn_code%>','<%=patient_class%>','<%=iv_prep_yn%>');}">
 --%>
 							<input type="button" class="button" value='<fmt:message key="ePH.AmendAlternateDrug.label" bundle="${ph_labels}"/>'   onClick="checkAndAmendDrug('<%=disc_vals%>', '<%=cancel_vals%>', '<%=(String)bean_2.getPatientID()%>','<%=generic_id%>', '<%=(String)bean_2.getEncounterID()%>','Y','<%=order_id%>', '<%=order_line_no%>', '<%=drug_code%>','<%=(String)bean_2.getPatientID()%>', '<%=(String)bean_2.getEncounterID()%>','<%=location_type%>', '<%=locn_code%>', '<%=patient_class%>', '<%=iv_prep_yn%>') ">
 <%
					}
%>
					</td> <!-- End - code added for JD-CRF-0198 [IN058599] -->
					
					<td  class="white" width="8%" align='right'><input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close();"></td>
				</tr>
			</table>
		</form>
	</body>
<%
	putObjectInBean(bean_id_2,bean_2,request);
%>
</html>

