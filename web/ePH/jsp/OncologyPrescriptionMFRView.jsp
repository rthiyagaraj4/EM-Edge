<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>			<!-- newly added for CRF-673.2 -->
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>   
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		  request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		  response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		  response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		  //ends
		  
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patientId	=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String order_id	= request.getParameter("order_id")==null?"":request.getParameter("order_id");

	String volume		="";
	String inf_rate		="";
	String inf_over_hr	=""; 
	String inf_over_min	="";
	String start_date	="";
	String end_date		="";
	String stock_uom_code="";
	String InfRateHrMin	="";
	String gap_hr = "";
	String gap_min = "";


	String volumeUom		=""; 
	String adminRateDetail		="";
	String gapInHr		="";

	String ivType				=request.getParameter("ivType")==null?"":request.getParameter("ivType");
	String mode					=request.getParameter("mode")==null?"":request.getParameter("mode");
	String bean_id				=request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name			=request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String drug_code			=request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String infusion_rate_uom	= request.getParameter("infusion_rate_uom")==null?"":request.getParameter("infusion_rate_uom"); 
	String srlNo				= request.getParameter("srlNo")==null?"":request.getParameter("srlNo"); 


	float tot_volume = 0.0f;
	float tot_flow_durn = 0.0f;
	float tot_gap = 0.0f;
	float tot_durn = 0.0f;
	ArrayList rec = new ArrayList();
	String temp="";
	String infusionOverInsertValue	=request.getParameter("infusion_over_insert_value")==null?"":request.getParameter("infusion_over_insert_value");
	
	
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
	ArrayList MultiFlowRecs = null;
	ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
	HashMap Mfr_Rec = null;


		HashMap ext_drugData			=	null;
		String ext_drug_code			=	"";
    	String ext_srl_no				=	"";
		String fluid_code			= "";
		HashMap MFR_Recs			= null;
		int totRec = 0;
		

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionMFR.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></title>
</head>

<BODY > 

	<form name="formOncoPrescriptionMFR" id="formOncoPrescriptionMFR">
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr >
				<td class='label' ><B>
					<fmt:message key="ePH.TotalInfusionVolume.label" bundle="${common_labels}"/>
					&nbsp;<label id='TotInfVolUnit' maxlength='10'></label> </B>
				</td>
				<td class='label' ><B>
					<fmt:message key="ePH.TotalInfuseDuration.label" bundle="${common_labels}"/>
					<label id='TotFlowDurn' maxlength='10'></label>
					&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></B>
				</td>
				<td class='label'><B>
					<fmt:message key="ePH.TotalDuration.label" bundle="${common_labels}"/>
					<label id='TotDuration' maxlength='10'></label>
					&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></B>
				</td>
			</tr>
		</table>
<%		String mfr_remarks="";
		ArrayList MFRRecord  = null;
		HashMap mfr_view = null;
		String ocurrance_num = "";
		HashMap mfr_remarks_map = (HashMap)bean.getmfr_remark();
System.err.println("OncologyPrescriptionMFRView.jsp------------prescriptionDetails.size()----------107-->"+prescriptionDetails);
		for(int j=0;j<prescriptionDetails.size();j++){
			
			 ext_drugData	=(HashMap) prescriptionDetails.get(j);
//System.err.println("OncologyPrescriptionMFRView.jsp--------------ext_drugData----asdfs--sd----136---->"+ext_drugData);
			 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
			 fluid_code		= (String) ext_drugData.get("amend_fluid_code");
			 MFR_Recs		=(HashMap) ext_drugData.get("MFR_Rec_details");
			 ocurrance_num  = (String) ext_drugData.get("OCURRANCE_NUM");	
			 MFRRecord		= (ArrayList)ext_drugData.get("MFRRecord");
			 
			
			// if(mfr_remarks_map!=null && mfr_remarks_map.size()>0){ //CRF-673.2 on 8/20/2014
			//	mfr_remarks = (String)mfr_remarks_map.get(drug_code+ocurrance_num);
			// }
			

//System.err.println("OncologyPrescriptionMFRView.jsp---115-ocurrance_num---sdfasd--->"+ocurrance_num+"---srlNo---->"+srlNo);

System.err.println("OncologyPrescriptionMFRView.jsp--sd-119-MFR_Recs---adsfe--->"+MFR_Recs+"==MFRRecord===>"+MFRRecord);


			if(MFRRecord!=null && MFRRecord.size()>0){
				//totRec = Integer.parseInt((String)MFR_Recs.get("totRec"));
				//totRec = MFRRecord.size();//commented for CRF-673 incident#51649 
		if(drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num)){
				totRec = MFRRecord.size(); //added for CRF-673 incident#51649 
		
			mfr_remarks	= (String) ext_drugData.get("MFR_REMARKS")==null?"":(String) ext_drugData.get("MFR_REMARKS");
			if(mfr_remarks==null) //CRF-673.2 on 8/20/2014
				mfr_remarks= "";
			%>
		<table id='mfrTable' >
			<tr>
				<td class="COLUMNHEADER" width='12%'>
					<fmt:message key="ePH.FlowRateNo.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='8%' >
					<fmt:message key="ePH.InfuseVol.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='13%'>
					<fmt:message key="ePH.InfusionRate.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='9%'>
					<fmt:message key="ePH.InfuseOver.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='16%'>
					<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='16%'>
					<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='9%'>
					<fmt:message key="ePH.InfusionGapTime.label" bundle="${common_labels}"/>

			</tr>
			

<%		}
	//Added For SRR20056-CRF-682 at siriraj warroom 




	if( MFRRecord.size() > 0){

		for(int i=0; i<MFRRecord.size(); i++){
			if(drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num) ){
			mfr_view = (HashMap)MFRRecord.get(i);
			volume		= (String)mfr_view.get("TOT_STRENGTH");
			volumeUom	=  infusion_rate_uom;
			inf_rate		= (String)mfr_view.get("INFUSION_RATE");
			InfRateHrMin	= (String)mfr_view.get("INFUSION_PER_UNIT");
			 

			inf_over_hr	= "";
			inf_over_min= "";
			infusionOverInsertValue		= (String)mfr_view.get("INFUSE_OVER");
//			System.err.println("OncologyPrescriptionMFRView.jsp------------182---infusionOverInsertValue-->"+infusionOverInsertValue);
			if(infusionOverInsertValue==null || infusionOverInsertValue.equals(""))
				infusionOverInsertValue = "0";
			start_date		= (String)mfr_view.get("START_DATE_TIME");
			end_date		= (String)mfr_view.get("END_DATE_TIME");
//			System.err.println("OncologyPrescriptionMFRView.jsp----start_date------178---->"+start_date+"----end_date----->"+end_date+"-----locale----->"+locale);
			if(!locale.equals("en")){
			start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale);
			end_date		= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);

			}
			gapInHr		= (String)mfr_view.get("GAP_DURATION_IN_HRS");
System.err.println("OncologyPrescriptionMFRView.jsp=====gapInHr====197======>"+gapInHr);
			if(gapInHr==null|| gapInHr.equals(""))
				gapInHr = "0";
			//Added For SRR20056-CRF-682 at siriraj warroom 
			tot_volume = tot_volume + Float.parseFloat(volume);
			tot_flow_durn = tot_flow_durn + Float.parseFloat(infusionOverInsertValue);
			tot_gap = tot_gap + Float.parseFloat(gapInHr);
			tot_durn = tot_durn+Float.parseFloat(infusionOverInsertValue) + Float.parseFloat(gapInHr);
			if(volume!=null && !volume.equals("")) {
				DecimalFormat dfVol = new DecimalFormat("0.##");
				volume = dfVol.format(Float.parseFloat(volume));
			}
			/* SCF-8240 */
			if(inf_rate!=null && !inf_rate.equals("")) {		   
				DecimalFormat dfVol = new DecimalFormat("#.##");
				inf_rate = dfVol.format(Float.parseFloat(inf_rate));
			}
			
%>
			<tr>
				<td class='label' ><fmt:message key="ePH.FlowRate.label" bundle="${common_labels}"/>&nbsp;<%=i+1%></td>
				<td class='label' >
					<label id='InfVolUnit<%=i%>'><%=volume%> &nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),volumeUom)%></label>
					<%
	
%>
				</td>
				<td class='label' >
<%				if(InfRateHrMin.equals("H")){
%>
					<label id='InfRateUnit<%=i%>'><%=inf_rate%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),volumeUom)%>/<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></label>
<%}else{%>
					<label id='InfRateUnit<%=i%>'><%=inf_rate%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),volumeUom)%>/<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></label>
<%}


%>			
				</td>
				<td class='label' >
					<label id='InfOver<%=i%>'></label>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/>
					<input type=hidden name='InfOverInHrs<%=i%>' id='InfOverInHrs<%=i%>' value='<%=infusionOverInsertValue%>'>
				</td>
				<td class='label' >
					<label id='start_date<%=i%>'><%=start_date%></label>
				</td>
				<td class='label' >
					<label id='end_date<%=i%>'><%=end_date%></label>
				</td>
				<td class='label' >
					<label id='InfGap<%=i%>'></label>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/>
					<input type=hidden name='InfGapInHrs<%=i%>' id='InfGapInHrs<%=i%>' value='<%=gapInHr%>'>
				</td>
				</tr>
				
			
<%	}			
	}
%>
</table>
<%	}
if(drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num)){ //if condition added on 10/7/2014
	if(mfr_remarks!=null && !mfr_remarks.equals("")){
	%>
<table>
<tr>
<tr><td>
<label class='label'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/>: <%=mfr_remarks%> </label> </td>
</tr></tr></table>
<%	}
	}
	}
	}
%>
		
		<input type=hidden name='noOfRows' id='noOfRows' value='<%=totRec%>'>	
		<script>
			calculateViewValues(document.formOncoPrescriptionMFR,'<%=tot_volume%>','<%=tot_flow_durn%>','<%=tot_gap%>','<%=tot_durn%>','<%=totRec%>','<%=tot_flow_durn%>','<%=volumeUom%>');
		</script>
	</form>
</body>
</html>
<%

%>

