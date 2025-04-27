<!DOCTYPE html>
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
   	String patient_id			= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String date					= request.getParameter("date");
	String locn_code			= request.getParameter("locn_code");
	String pract_name			= request.getParameter("pract_name");
	String patient_class		= request.getParameter("actual_patient_class");
	Double Dtemp				= null;
	String fluid_code			= request.getParameter("fluid_code");
	String fluid_code2			= request.getParameter("fluid_code2");
	String fluid_code3			= request.getParameter("fluid_code3");
	String fluid_code4			= request.getParameter("fluid_code4");
	String fluid_code5			= request.getParameter("fluid_code5");
	String fluid_code6			= request.getParameter("fluid_code6");
	String fluid_name			= request.getParameter("fluid_name");
	String fluid_name2			= request.getParameter("fluid_name2");
	String fluid_name3			= request.getParameter("fluid_name3");
	String fluid_name4			= request.getParameter("fluid_name4");
	String fluid_name5			= request.getParameter("fluid_name5");
	String fluid_name6			= request.getParameter("fluid_name6");
	String infusion_rate		= request.getParameter("inf_prd");
	String infusion_rate2		= request.getParameter("inf_prd2");
	String infusion_rate3		= request.getParameter("inf_prd3");
	String infusion_rate4		= request.getParameter("inf_prd4");	
	String infusion_rate5		= request.getParameter("inf_prd5");	
	String infusion_rate6		= request.getParameter("inf_prd6");	
	String tot_inf_prd			= request.getParameter("tot_inf_prd");
	String tot_inf_prd2			= request.getParameter("tot_inf_prd2");
	String tot_inf_prd3			= request.getParameter("tot_inf_prd3");
	String tot_inf_prd4			= request.getParameter("tot_inf_prd4");
	String tot_inf_prd5			= request.getParameter("tot_inf_prd5");
	String tot_inf_prd6		    = request.getParameter("tot_inf_prd6");
	String start_date			= request.getParameter("start_date");
	String start_date2			= request.getParameter("start_date2");
	String start_date3			= request.getParameter("start_date3");
	String start_date4			= request.getParameter("start_date4");
	String start_date5			= request.getParameter("start_date5");
	String start_date6			= request.getParameter("start_date6");
	String end_date				= request.getParameter("end_date");	
	String end_date2			= request.getParameter("end_date2");
	String end_date3			= request.getParameter("end_date3");	
	String end_date4			= request.getParameter("end_date4");
	String end_date5			= request.getParameter("end_date5");	
	String end_date6			= request.getParameter("end_date6");	
	String duration_disp		= "";
	String durn_hr				= "";
	String durn_min				= "";
	String duration				= request.getParameter("duration1");
	String duration2			= request.getParameter("duration2");
	String duration3			= request.getParameter("duration3");
	String duration4			= request.getParameter("duration4");
	String duration5			= request.getParameter("duration5");
	String duration6			= request.getParameter("duration6");
	String volume				= request.getParameter("volume");
	String volume2				= request.getParameter("volume2");
	String volume3				= request.getParameter("volume3");
	String volume4				= request.getParameter("volume4");
	String volume5				= request.getParameter("volume5");
	String volume6				= request.getParameter("volume6");
	String vol_uom				= request.getParameter("vol_uom");
	String vol_uom2				= request.getParameter("vol_uom2");
	String vol_uom3				= request.getParameter("vol_uom3");
	String vol_uom4				= request.getParameter("vol_uom4");
	String vol_uom5				= request.getParameter("vol_uom5");
	String vol_uom6				= request.getParameter("vol_uom6");	
	String inf_rate_uom			= request.getParameter("inf_rate_uom");
	String inf_rate_uom2		= request.getParameter("inf_rate_uom2");
	String inf_rate_uom3		= request.getParameter("inf_rate_uom3");
	String inf_rate_uom4		= request.getParameter("inf_rate_uom4");
	String inf_rate_uom5		= request.getParameter("inf_rate_uom5");
	String inf_rate_uom6		= request.getParameter("inf_rate_uom6");
	float tot_volume			=  0.0f;

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);

	String or_bean_name		="eOR.OrderEntryBean";
	String or_bean_id		="@orderentrybean"+patient_id+encounter_id;

	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

	String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
	String pres_bean_name		 = "ePH.PrescriptionBean_1";
	PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request ) ;

	HashMap MFR_AllRecs = new HashMap();
	HashMap MFR_Recs	= new HashMap();

	MFR_AllRecs			= bean.getMFRRecs_fluids("");

	vol_uom			= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom);
	vol_uom2		= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom2);
	vol_uom3		= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom3);
	vol_uom4		= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom4);
	vol_uom5		= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom5);
	vol_uom6		= bean.getUomDisplay((String)session.getValue("facility_id"),vol_uom6);

	String patient_name		= "";
	String sex				= "";
	String age				= "";
	String pres_remarks		= "";	
	String classValue		= "";
	String order_uom		= "";

	ArrayList pat_details	= bean.getPatientDetails(patient_id);
	String iv_calc_infuse_by=bean.getIVCalcInfuseBy();

	if (pat_details.size() != 0) {
		patient_name	= (String)pat_details.get(0);
		sex				= (String)pat_details.get(1);
		age				= (String)pat_details.get(2);
	}

	String locn_desc = "";
	if(patient_class!=null && !patient_class.equals("") && locn_code!=null && !locn_code.equals("") )
		locn_desc		= bean.getLocationDesc(patient_class,locn_code);
	
	Hashtable template	=	null;
	ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code,fluid_code+"_0");

	if(seq_num==null)
		seq_num			=	new ArrayList();

	for(int p=0; p<seq_num.size(); p++) {
		template	=	(Hashtable)orderEntryRecordBean.getOrderFormats(fluid_code,(fluid_code+((Integer)seq_num.get(p)).intValue()));

		if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
			pres_remarks += bean.getPrescriptionRemarks((String) template.get("field_values"))+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		else {
			pres_remarks += (String) template.get("field_values") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
	}
%>

<HTML>
	<HEAD>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescription.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionWithoutAdditivesPreview" id="formIVPrescriptionWithoutAdditivesPreview">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TH COLSPAN="4"><FONT STYLE="font-size:10"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></font></TH>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
				<TR>
					<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :&nbsp;</TD>
					<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= patient_name %></TD>
					<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> :&nbsp;</TD>
					<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= patient_id %></TD>
				</TR>
				<TR>
					<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.age.label" bundle="${common_labels}"/> :&nbsp;</TD>
					<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= age %></TD>
					<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> :&nbsp;</TD>
					<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= encounter_id %></TD>
				</TR>
				<TR>
					<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.gender.label" bundle="${common_labels}"/> :&nbsp;</TD>
<%
				if(sex.equalsIgnoreCase("female"))
					 sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equalsIgnoreCase("male"))
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equalsIgnoreCase("unknown"))
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
				<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= sex %></TD>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/> :&nbsp;</TD>
				<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= date %></TD>
			</TR>
			<TR>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/> :&nbsp;</TD>
				<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= locn_desc %></TD>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/> :&nbsp;</TD>
<%
				if(pract_name!=null && !(pract_name.equals(""))){
					pract_name  =java.net.URLDecoder.decode(pract_name,"UTF-8");
				}
%>
				<TD CLASS="data" WIDTH="30%" style="font-size:10"><%=pract_name %></TD>
			</TR>
			<tr><td colspan="4"></td></tr>
			<tr><td colspan="4"></td></tr>
			<tr><td colspan="4"></td></tr>
			<tr><td colspan="4"></td></tr>
		</TABLE>
		 
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<tr>
			<th width="30%" style="font-size:10"><fmt:message key="ePH.Fluid(s).label" bundle="${ph_labels}"/></th>
			<th width="9%" style="font-size:10"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></th>
			<th width="9%" style="font-size:10"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></th>
			<th width="7%" style="font-size:10"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></th>
			<th width="7%" style="font-size:10"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></th>
			<th width="8%" style="font-size:10"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th width="15%" style="font-size:10"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
			<th width="15%" style="font-size:10"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
		</tr>
<% 
		String infusion_over_disp	= "", pack_size="";
		int NoOfFlowRate			= 0;	
		ArrayList MFRDetail			= new ArrayList();
		String mfr_yn				= "N";
		int order_qty			= 0;
		double dur1		= 0 ;
		float tem=0;
		double dur2 = 0.0d, durn_value=0;
		if(!fluid_code.equals("")){ 
			MFR_Recs				= (HashMap)MFR_AllRecs.get(fluid_code);
			if(MFR_Recs != null)
				NoOfFlowRate		= Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));

			mfr_yn					= NoOfFlowRate>0?"Y":"N";
			NoOfFlowRate			= NoOfFlowRate>0?NoOfFlowRate:1;
			bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
			pack_size		= (String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
			for(int j=0; j<NoOfFlowRate; j++){
				classValue		=	"QRYEVENSMALL";
				if(mfr_yn.equals("Y")){
					MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
					duration		= (String)MFR_Recs.get("totFlowDurnHrs");
					tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
					volume			= (String)MFRDetail.get(0)==null?"0":(String)MFRDetail.get(0);
					infusion_rate	= (String)MFRDetail.get(1);
					inf_rate_uom	= (String)MFRDetail.get(2);
					infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
					tot_inf_prd		= (String)MFRDetail.get(5);
					start_date		= (String)MFRDetail.get(6);
					end_date		= (String)MFRDetail.get(7);

					if(duration.indexOf(".") != -1){
						durn_hr		= duration.substring(0,duration.indexOf("."));
						Dtemp		= new Double(duration);
						Dtemp		= Dtemp*60;
						Dtemp		= (Dtemp%60);
						durn_min	= Math.round(Dtemp)+"";

						if(durn_min.indexOf(".") != -1)
							durn_min = durn_min.substring(0,durn_min.indexOf("."));  
					}
					else{
						durn_hr  = duration;
						durn_min = "";
					}
					durn_hr  = durn_hr.equals("")?"00":durn_hr;
					durn_min = durn_min.equals("")?"00":durn_min;
					
					durn_hr			= durn_hr.length()==1?"0"+durn_hr:durn_hr;
					durn_min		= durn_min.length()==1?"0"+durn_min:durn_min;
					duration_disp	= durn_hr+":"+durn_min;
				}
				else{
					duration_disp	=duration;
				}
				// order qty calculation
				durn_value	= Double.parseDouble(duration);
				if(tot_inf_prd.indexOf(".") != -1){
					String hr		= "00";
					infusion_over_disp = tot_inf_prd.substring(tot_inf_prd.indexOf("."));
					infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
					if(!(tot_inf_prd.substring(0,tot_inf_prd.indexOf("."))).equals(""))
						hr = tot_inf_prd.substring(0,tot_inf_prd.indexOf("."));
					hr = hr.equals("")?"00":hr;
					hr = hr.length()==1?"0"+hr:hr;
					infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
					infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
					infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
					infusion_over_disp = hr+":"+ infusion_over_disp;
				}
				else{
					infusion_over_disp = tot_inf_prd;
				}

				dur1		= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd)))*100)/100) ; //Math.ceil added for SKr-SCF-1397
				tem=Float.parseFloat(pack_size);
				if(mfr_yn.equals("Y") ){
					dur2 = tot_volume / tem ;
				}
				else{
					tot_volume = Float.parseFloat(volume);
					if( iv_calc_infuse_by.equals("I")){
						dur2		= tot_volume / tem ;
						duration_disp  = infusion_over_disp;
					}
					else
						dur2		= Math.ceil(tot_volume/tem)*dur1  ;//Math.ceil added for SKR-SCF-1397
				}
				order_qty   = new Float(Math.ceil(dur2)).intValue();			
				order_uom		= bean.getStockUOM(fluid_code);
%>
				<tr>
<%
				if(j == 0){
%>		
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=fluid_name %> </td>
<%
				}
%>
				<td class="<%=classValue%>"><%= volume %>&nbsp;<%=vol_uom%></td>
<%
				if(inf_rate_uom.equals("H") || inf_rate_uom.equals("h") || inf_rate_uom.equals("Hour(s)") || inf_rate_uom.equals("hr(s)")){
%>
					<td class="<%=classValue%>"><%= infusion_rate%>&nbsp;<%=vol_uom%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
				}
				else if(inf_rate_uom.equals("M")|| inf_rate_uom.equals("m") || inf_rate_uom.equals("Minute(s)") || inf_rate_uom.equals("mt(s)")){
%>
					<td class="<%=classValue%>"><%= infusion_rate%>&nbsp;<%=vol_uom%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
				if(j == 0){
%>
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%			
				}
%>
					<td class="<%=classValue%>" rowspan='1'><%= start_date %></td>
					<td class="<%=classValue%>" rowspan='1'><%= end_date %></td>
				</tr>
<%
			}
		}
		if(!fluid_code2.equals("")){ 
			if(classValue.equals("")) {
				classValue		="QRYEVENSMALL";
			} 
			else {
				classValue		="QRYODDSMALL";
			}
			MFR_Recs = new HashMap();
			MFR_Recs = (HashMap)MFR_AllRecs.get(fluid_code2);
			NoOfFlowRate = 0;
			if(MFR_Recs != null)
				NoOfFlowRate = Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));
			mfr_yn = NoOfFlowRate>0?"Y":"N";
			NoOfFlowRate = NoOfFlowRate>0?NoOfFlowRate:1;
			bean.setFluidDetails(fluid_code2,"","","",""); // CRF-0062 NEWLY ADDED
			pack_size	=	(String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
			duration_disp = "";
			for(int j=0; j<NoOfFlowRate; j++){
				if(mfr_yn.equals("Y")){
					MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
					duration2		= (String)MFR_Recs.get("totFlowDurnHrs");
					volume2			= (String)MFRDetail.get(0);
					tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
					infusion_rate2	= (String)MFRDetail.get(1);
					inf_rate_uom2	= (String)MFRDetail.get(2);
					infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
					tot_inf_prd2		= (String)MFRDetail.get(5);
					start_date2		= (String)MFRDetail.get(6);
					end_date2		= (String)MFRDetail.get(7);

					if(duration2.indexOf(".") != -1){
						durn_hr		= duration2.substring(0,duration2.indexOf("."));
						Dtemp		= new Double(duration2);
						Dtemp		= Dtemp*60;
						Dtemp		= (Dtemp%60);
						durn_min	= Math.round(Dtemp)+""; 
						if(durn_min.indexOf(".") != -1)
							durn_min = durn_min.substring(0,durn_min.indexOf("."));  
					}
					else{
						durn_hr  = duration2;
						durn_min = "";
					}
					durn_hr		= durn_hr.equals("")?"00":durn_hr;
					durn_min	= durn_min.equals("")?"00":durn_min;
					durn_hr		= durn_hr.length()==1?"0"+durn_hr:durn_hr;
					durn_min	= durn_min.length()==1?"0"+durn_min:durn_min;
					duration_disp = durn_hr+":"+durn_min;
				}
				else{
					duration_disp = duration2;
				}

				// order qty calculation
				durn_value	= Double.parseDouble(duration2);
				dur1			= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd2)))*100)/100) ;//Math.ceil added for SKR-SCF-1397

				if(mfr_yn.equals("Y") ){
					dur2		= Math.ceil(tot_volume / Float.parseFloat(pack_size));
				}
				else{
					if( iv_calc_infuse_by.equals("I"))
						dur2		= Math.ceil((Float.parseFloat(volume2)) / Float.parseFloat(pack_size));
					else
						dur2		= Math.ceil(Float.parseFloat(volume2)/Float.parseFloat(pack_size))*dur1  ;
					//modified for SKR-SCF-1397
				//		dur2		= Math.ceil((Float.parseFloat(volume2)*dur1) / Float.parseFloat(pack_size));
				}
				order_qty			= new Float(Math.ceil(dur2)).intValue();				
				order_uom			= bean.getStockUOM(fluid_code2);
				infusion_over_disp  = "";

				if(tot_inf_prd2.indexOf(".") != -1){
					String hr = "0";

					infusion_over_disp = tot_inf_prd2.substring(tot_inf_prd2.indexOf("."));
					infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
					if(!(tot_inf_prd2.substring(0,tot_inf_prd2.indexOf("."))).equals(""))
						hr = tot_inf_prd2.substring(0,tot_inf_prd2.indexOf("."));
					hr = hr.equals("")?"00":hr;
					hr = hr.length()==1?"0"+hr:hr;
					infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
					infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
					infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
					infusion_over_disp = hr+":"+ infusion_over_disp;
				}
				else{
					infusion_over_disp = tot_inf_prd2;
				}
				if( iv_calc_infuse_by.equals("I"))
					duration_disp  = infusion_over_disp;
%>
				<tr>
<%
				if(j == 0){
%>		
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%= fluid_name2 %> </td>
<%			
				}
%>
				<td class="<%=classValue%>"><%= volume2 %>&nbsp;<%=vol_uom2%></td>
<%
				if(inf_rate_uom2.equals("H") || inf_rate_uom2.equals("h") || inf_rate_uom2.equals("Hour(s)") || inf_rate_uom2.equals("hr(s)")){
%>
					<td class="<%=classValue%>"><%= infusion_rate2%>&nbsp;<%=vol_uom2%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
				}
				else if(inf_rate_uom2.equals("M")|| inf_rate_uom2.equals("m") || inf_rate_uom2.equals("Minute(s)") || inf_rate_uom2.equals("mt(s)")){
				//if(inf_rate_uom2_code.equals("H") || inf_rate_uom2_code.equals("h")){
%>
					<td class="<%=classValue%>"><%= infusion_rate2%>&nbsp;<%=vol_uom2%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
				if(j == 0){
%>
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
					<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%
				}
%>
				<td class="<%=classValue%>"><%= start_date2 %></td>
				<td class="<%=classValue%>"><%= end_date2 %></td>
			</tr>
<%	
		}// for mfr
	} // if fluid_code2
	if(!fluid_code3.equals("")){ 
		if(classValue.equals("QRYODDSMALL")) {
			classValue		="QRYEVENSMALL";
		}
		else {
			classValue		="QRYODDSMALL";
		}
		NoOfFlowRate	= 0;
		MFR_Recs		= new HashMap();
		MFR_Recs		= (HashMap)MFR_AllRecs.get(fluid_code3);
		NoOfFlowRate	= 0;

		if(MFR_Recs != null)
			NoOfFlowRate = Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));

		mfr_yn		 = NoOfFlowRate>0?"Y":"N";
		NoOfFlowRate = NoOfFlowRate>0?NoOfFlowRate:1;

		bean.setFluidDetails(fluid_code3,"","","",""); // CRF-0062 NEWLY ADDED
		duration_disp		= "";
		pack_size	=	(String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
		for(int j=0; j<NoOfFlowRate; j++){
			if(mfr_yn.equals("Y")){
				MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
				duration3		= (String)MFR_Recs.get("totFlowDurnHrs");
				volume3			= (String)MFRDetail.get(0);
				tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
				infusion_rate3	= (String)MFRDetail.get(1);
				inf_rate_uom3	= (String)MFRDetail.get(2);
				infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
				tot_inf_prd3		= (String)MFRDetail.get(5);
				start_date3		= (String)MFRDetail.get(6);
				end_date3		= (String)MFRDetail.get(7);

				if(duration3.indexOf(".") != -1){
					durn_hr = duration3.substring(0,duration3.indexOf("."));
					Dtemp = new Double(duration3);
					Dtemp = Dtemp*60;
					Dtemp = (Dtemp%60);
					durn_min = Math.round(Dtemp)+""; 
					if(durn_min.indexOf(".") != -1)
						durn_min = durn_min.substring(0,durn_min.indexOf("."));  
				}
				else{
					durn_hr = duration3;
					durn_min = "";
				}
				durn_hr = durn_hr.equals("")?"00":durn_hr;
				durn_min = durn_min.equals("")?"00":durn_min;
				
				durn_hr = durn_hr.length()==1?"0"+durn_hr:durn_hr;
				durn_min = durn_min.length()==1?"0"+durn_min:durn_min;
				duration_disp = durn_hr+":"+durn_min;
			}
			else{
				duration_disp = duration3;
			}
			// order qty calculation
			durn_value	= Double.parseDouble(duration3);
			dur1		= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd3)))*100)/100) ;//Math.ceil added for SKR-SCF-1397
			if(mfr_yn.equals("Y") || iv_calc_infuse_by.equals("Y")){
				dur2		= Math.ceil(tot_volume / Float.parseFloat(pack_size));
			}
			else{
				if( iv_calc_infuse_by.equals("I"))
					dur2		= Math.ceil((Float.parseFloat(volume3)) / Float.parseFloat(pack_size));
				else
					dur2		= Math.ceil(Float.parseFloat(volume3)/Float.parseFloat(pack_size))*dur1 ;//modified for SKR-SCF-1397
					//dur2		= Math.ceil((Float.parseFloat(volume3)*dur1) / Float.parseFloat(pack_size));
			}
			order_qty   = new Float(Math.ceil(dur2)).intValue();	
			order_uom		= bean.getStockUOM(fluid_code3);

			infusion_over_disp = "";
			if(tot_inf_prd3.indexOf(".") != -1){
				String hr = "0";

				infusion_over_disp = tot_inf_prd3.substring(tot_inf_prd3.indexOf("."));
				infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
				if(!(tot_inf_prd3.substring(0,tot_inf_prd3.indexOf("."))).equals(""))
					hr = tot_inf_prd3.substring(0,tot_inf_prd3.indexOf("."));
				hr = hr.equals("")?"00":hr;
				hr = hr.length()==1?"0"+hr:hr;
				infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
				infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
				infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
				infusion_over_disp = hr+":"+ infusion_over_disp;
			}
			else{
				infusion_over_disp = tot_inf_prd3;
			}
			if( iv_calc_infuse_by.equals("I"))
				duration_disp  = infusion_over_disp;
%>
			<tr>
<%
			if(j == 0){
%>		
				<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%= fluid_name3 %> </td>
<%		
			}
%>
			<td class="<%=classValue%>"><%= volume3 %>&nbsp;<%=vol_uom3%></td>
<%
			if(inf_rate_uom3.equals("M")|| inf_rate_uom3.equals("m") || inf_rate_uom3.equals("Minute(s)") || inf_rate_uom3.equals("mt(s)")){
%>
				<td class="<%=classValue%>"><%= infusion_rate3%>&nbsp;<%=vol_uom3%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
			}
			else if(inf_rate_uom3.equals("H") || inf_rate_uom3.equals("h") || inf_rate_uom3.equals("Hour(s)") || inf_rate_uom3.equals("hr(s)")){
%>
				<td class="<%=classValue%>"><%= infusion_rate3%>&nbsp;<%=vol_uom3%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
			}
%>
			<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					if(j == 0){
%>
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%		
					}
%>
					<td class="<%=classValue%>"><%= start_date3 %></td>
					<td class="<%=classValue%>"><%= end_date3 %></td>
				</tr>
<%
				} 
			}
			if(!fluid_code4.equals("")){ 
				if(classValue.equals("QRYODDSMALL")) {
					classValue		="QRYEVENSMALL";
				}
				else {
					classValue		="QRYODDSMALL";
				}
				NoOfFlowRate = 0;
				MFR_Recs = new HashMap();
				MFR_Recs = (HashMap)MFR_AllRecs.get(fluid_code4);
				NoOfFlowRate = 0;
				if(MFR_Recs != null)
					NoOfFlowRate = Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));
				mfr_yn = NoOfFlowRate>0?"Y":"N";
				NoOfFlowRate = NoOfFlowRate>0?NoOfFlowRate:1;

				bean.setFluidDetails(fluid_code4,"","","",""); // CRF-0062 NEWLY ADDED
				duration_disp = "";
				for(int j=0; j<NoOfFlowRate; j++){
					if(mfr_yn.equals("Y")){
						MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
						duration4		= (String)MFR_Recs.get("totFlowDurnHrs");
						volume4			= (String)MFRDetail.get(0);
						tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
						infusion_rate4	= (String)MFRDetail.get(1);
						inf_rate_uom4	= (String)MFRDetail.get(2);
						infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
						tot_inf_prd4		= (String)MFRDetail.get(5);
						start_date4		= (String)MFRDetail.get(6);
						end_date4		= (String)MFRDetail.get(7);
						if(duration4.indexOf(".") != -1){
							durn_hr = duration4.substring(0,duration4.indexOf("."));
							Dtemp = new Double(duration4);
							Dtemp = Dtemp*60;
							Dtemp = (Dtemp%60);
							durn_min = Math.round(Dtemp)+""; 
							if(durn_min.indexOf(".") != -1)
								durn_min = durn_min.substring(0,durn_min.indexOf("."));  
						}
						else{
							durn_hr = duration4;
							durn_min = "";
						}
						durn_hr = durn_hr.equals("")?"00":durn_hr;
						durn_min = durn_min.equals("")?"00":durn_min;
						
						durn_hr = durn_hr.length()==1?"0"+durn_hr:durn_hr;
						durn_min = durn_min.length()==1?"0"+durn_min:durn_min;

						duration_disp = durn_hr+":"+durn_min;
					}
					else{
						duration_disp = duration4;
					}
					pack_size	=	(String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
					// order qty calculation
					durn_value	= Double.parseDouble(duration4);
					dur1		= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd4)))*100)/100) ;//ceil added for SKR-SCF-1397
					if(mfr_yn.equals("Y") ){
						dur2		= Math.ceil(tot_volume / Float.parseFloat(pack_size));
					}
					else{
						if( iv_calc_infuse_by.equals("I"))
							dur2		= Math.ceil((Float.parseFloat(volume4)) / Float.parseFloat(pack_size));
						else
							dur2		= Math.ceil(Float.parseFloat(volume4)/Float.parseFloat(pack_size))*dur1 ;  //modified for SKR-SCF-1397
							//dur2		= Math.ceil((Float.parseFloat(volume4)*dur1) / Float.parseFloat(pack_size));
					}
					order_qty   = new Float(Math.ceil(dur2)).intValue();
					order_uom		= bean.getStockUOM(fluid_code4);
					infusion_over_disp = "";
					if(tot_inf_prd4.indexOf(".") != -1){
						String hr = "0";

						infusion_over_disp = tot_inf_prd4.substring(tot_inf_prd4.indexOf("."));
						infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
						if(!(tot_inf_prd4.substring(0,tot_inf_prd4.indexOf("."))).equals(""))
							hr = tot_inf_prd4.substring(0,tot_inf_prd4.indexOf("."));
						hr = hr.equals("")?"00":hr;
						hr = hr.length()==1?"0"+hr:hr;
						infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
						infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
						infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
						infusion_over_disp = hr+":"+ infusion_over_disp;
					}
					else{
						infusion_over_disp = tot_inf_prd4;
					}
					if( iv_calc_infuse_by.equals("I"))
						duration_disp  = infusion_over_disp;
%>
					<tr>
<%
					if(j == 0){
%>		
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=fluid_name3 %> </td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= volume4 %>&nbsp;<%=vol_uom4%></td>

<%	
					if(inf_rate_uom4.equals("M")|| inf_rate_uom4.equals("m") || inf_rate_uom4.equals("Minute(s)") || inf_rate_uom4.equals("mt(s)")){
%>
						<td class="<%=classValue%>"><%= infusion_rate4%>&nbsp;<%=vol_uom4%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
					}
					else if(inf_rate_uom4.equals("H") || inf_rate_uom4.equals("h") || inf_rate_uom4.equals("Hour(s)") || inf_rate_uom4.equals("hr(s)")){%>
					   <td class="<%=classValue%>"><%= infusion_rate4%>&nbsp;<%=vol_uom4%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					}
%>
					<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					if(j == 0){
%>		
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= start_date4 %></td>
					<td class="<%=classValue%>"><%= end_date4 %></td>
				</tr>
<%	
				}
			}
			if(!fluid_code5.equals("")){ 
				if(classValue.equals("QRYODDSMALL")) {
					classValue		="QRYEVENSMALL";
				}
				else {
					classValue		="QRYODDSMALL";
				}
				NoOfFlowRate = 0;
				MFR_Recs = new HashMap();
				MFR_Recs = (HashMap)MFR_AllRecs.get(fluid_code5);
				NoOfFlowRate = 0;
				if(MFR_Recs != null)
					NoOfFlowRate = Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));
				mfr_yn = NoOfFlowRate>0?"Y":"N";
				NoOfFlowRate = NoOfFlowRate>0?NoOfFlowRate:1;
				duration_disp = "";

				bean.setFluidDetails(fluid_code5,"","","",""); // CRF-0062 NEWLY ADDED
				for(int j=0; j<NoOfFlowRate; j++){
					if(mfr_yn.equals("Y")){
						MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
						duration5		= (String)MFR_Recs.get("totFlowDurnHrs");
						volume5			= (String)MFRDetail.get(0);
						tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
						infusion_rate5	= (String)MFRDetail.get(1);
						inf_rate_uom5	= (String)MFRDetail.get(2);
						infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
						tot_inf_prd5		= (String)MFRDetail.get(5);
						start_date5		= (String)MFRDetail.get(6);
						end_date5		= (String)MFRDetail.get(7);
						if(duration5.indexOf(".") != -1){
							durn_hr = duration5.substring(0,duration5.indexOf("."));
							Dtemp = new Double(duration5);
							Dtemp = Dtemp*60;
							Dtemp = (Dtemp%60);
							durn_min = Math.round(Dtemp)+""; 
							if(durn_min.indexOf(".") != -1)
								durn_min = durn_min.substring(0,durn_min.indexOf("."));  
						}
						else{
							durn_hr = duration5;
							durn_min = "";
						}
						durn_hr = durn_hr.equals("")?"00":durn_hr;
						durn_min = durn_min.equals("")?"00":durn_min;
						
						durn_hr = durn_hr.length()==1?"0"+durn_hr:durn_hr;
						durn_min = durn_min.length()==1?"0"+durn_min:durn_min;

						duration_disp = durn_hr+":"+durn_min;
					}
					else{
						duration_disp = duration5;
					}
					pack_size	=	(String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
					// order qty calculation
					durn_value	= Double.parseDouble(duration5);
					dur1		= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd5)))*100)/100) ; //Math.ceil added for SKR-SCF-1397

					if(mfr_yn.equals("Y") || iv_calc_infuse_by.equals("Y")){
						dur2		= Math.ceil(tot_volume / Float.parseFloat(pack_size));
					}
					else{
						if( iv_calc_infuse_by.equals("I"))
							dur2		= Math.ceil((Float.parseFloat(volume5)) / Float.parseFloat(pack_size));
						else
							dur2		= Math.ceil(Float.parseFloat(volume5)/Float.parseFloat(pack_size))*dur1;
						//modified SKR-SCF-1397
						//dur2		= Math.ceil((Float.parseFloat(volume5)*dur1) / Float.parseFloat(pack_size));
					}
					order_qty   = new Float(Math.ceil(dur2)).intValue();				
					order_uom		= bean.getStockUOM(fluid_code5);
					infusion_over_disp = "";
					if(tot_inf_prd5.indexOf(".") != -1){
						String hr = "0";
						infusion_over_disp = tot_inf_prd5.substring(tot_inf_prd5.indexOf("."));
						infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
						if(!(tot_inf_prd5.substring(0,tot_inf_prd5.indexOf("."))).equals(""))
							hr = tot_inf_prd5.substring(0,tot_inf_prd5.indexOf("."));
						hr = hr.equals("")?"00":hr;
						hr = hr.length()==1?"0"+hr:hr;
						infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
						infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
						infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
						infusion_over_disp = hr+":"+ infusion_over_disp;
					}
					else{
						infusion_over_disp = tot_inf_prd5;
					}
					if( iv_calc_infuse_by.equals("I"))
						duration_disp  = infusion_over_disp;
%>
					<tr>
<%
					if(j == 0){
%>		
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=fluid_name3%> </td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= volume5 %>&nbsp;<%=vol_uom5%></td>
<%	
					if(inf_rate_uom5.equals("M")|| inf_rate_uom5.equals("m") || inf_rate_uom5.equals("Minute(s)") || inf_rate_uom5.equals("mt(s)")){
%>
						<td class="<%=classValue%>"><%= infusion_rate5%>&nbsp;<%=vol_uom5%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
					}
					else if(inf_rate_uom5.equals("H") || inf_rate_uom5.equals("h") || inf_rate_uom5.equals("Hour(s)") || inf_rate_uom5.equals("hr(s)")){%>
					   <td class="<%=classValue%>"><%= infusion_rate5%>&nbsp;<%=vol_uom5%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					}
%>
					<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					if(j == 0){
%>
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= start_date5 %></td>
					<td class="<%=classValue%>"><%= end_date5 %></td>
				</tr>
<%
				} 
			}
			if(!fluid_code6.equals("")){ 
			if(classValue.equals("QRYODDSMALL")) {
				classValue		="QRYEVENSMALL";
			}
			else {
				classValue		="QRYODDSMALL";
			}
			NoOfFlowRate = 0;
			MFR_Recs = new HashMap();
			MFR_Recs = (HashMap)MFR_AllRecs.get(fluid_code6);
			NoOfFlowRate = 0;
			if(MFR_Recs != null)
				NoOfFlowRate = Integer.parseInt((String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec"));
			mfr_yn = NoOfFlowRate>0?"Y":"N";
			NoOfFlowRate = NoOfFlowRate>0?NoOfFlowRate:1;

			bean.setFluidDetails(fluid_code6,"","","",""); // CRF-0062 NEWLY ADDED
			duration_disp = "";
			for(int j=0; j<NoOfFlowRate; j++){
				if(mfr_yn.equals("Y")){
					MFRDetail		= (ArrayList)MFR_Recs.get("MFR"+(j+1));
					duration6		= (String)MFR_Recs.get("totFlowDurnHrs");
					volume6			= (String)MFRDetail.get(0);
					tot_volume		= Float.parseFloat((String)MFR_Recs.get("totInfVolume")==null?"0":(String)MFR_Recs.get("totInfVolume"));	
					infusion_rate6	= (String)MFRDetail.get(1);
					inf_rate_uom6	= (String)MFRDetail.get(2);
					infusion_over_disp	= (String)MFRDetail.get(3)+":"+(String)MFRDetail.get(4);
					tot_inf_prd6		= (String)MFRDetail.get(5);
					start_date6		= (String)MFRDetail.get(6);
					end_date6		= (String)MFRDetail.get(7);
					if(duration6.indexOf(".") != -1){
						durn_hr = duration5.substring(0,duration6.indexOf("."));
						Dtemp = new Double(duration6);
						Dtemp = Dtemp*60;
						Dtemp = (Dtemp%60);
						durn_min = Math.round(Dtemp)+""; 
						if(durn_min.indexOf(".") != -1)
							durn_min = durn_min.substring(0,durn_min.indexOf("."));  
						}
						else{
							durn_hr = duration6;
							durn_min = "";
						}
						durn_hr = durn_hr.equals("")?"00":durn_hr;
						durn_min = durn_min.equals("")?"00":durn_min;
						durn_hr = durn_hr.length()==1?"0"+durn_hr:durn_hr;
						durn_min = durn_min.length()==1?"0"+durn_min:durn_min;
						duration_disp = durn_hr+":"+durn_min;
					}
					else{
						duration_disp = duration6;
					}

					pack_size	=	(String)bean.getFluidDetails().get("FLUID_PACK_SIZE");
					// order qty calculation
					durn_value	= Double.parseDouble(duration6);
					dur1		= Math.ceil(((durn_value / (Float.parseFloat(tot_inf_prd6)))*100)/100) ;//Math.ceil added for SKR-SCF-1397
					if(mfr_yn.equals("Y") ){
						dur2		= Math.ceil(tot_volume / Float.parseFloat(pack_size));
					}
					else{
						if( iv_calc_infuse_by.equals("I"))
							dur2		= Math.ceil((Float.parseFloat(volume6)) / Float.parseFloat(pack_size));
						else
							dur2		= Math.ceil(Float.parseFloat(volume6)/Float.parseFloat(pack_size))*dur1; 
							//modified for SKR-SCF-1397
							//dur2		= Math.ceil((Float.parseFloat(volume6)*dur1) / Float.parseFloat(pack_size));
					}
					order_qty   = new Float(dur2).intValue();				
					order_uom		= bean.getStockUOM(fluid_code6);
					infusion_over_disp = "";
					if(tot_inf_prd6.indexOf(".") != -1){
						String hr = "0";

						infusion_over_disp = tot_inf_prd6.substring(tot_inf_prd6.indexOf("."));
						infusion_over_disp = ((Float.parseFloat(infusion_over_disp))*60)+"";
						if(!(tot_inf_prd6.substring(0,tot_inf_prd6.indexOf("."))).equals(""))
							hr = tot_inf_prd6.substring(0,tot_inf_prd6.indexOf("."));
						hr = hr.equals("")?"00":hr;
						hr = hr.length()==1?"0"+hr:hr;
						infusion_over_disp = Math.round(Float.parseFloat(infusion_over_disp))+"";
						infusion_over_disp = infusion_over_disp.equals("")?"00":infusion_over_disp;
						infusion_over_disp = infusion_over_disp.length()==1?"0"+infusion_over_disp:infusion_over_disp;
						infusion_over_disp = hr+":"+ infusion_over_disp;
					}
					else{
						infusion_over_disp = tot_inf_prd6;
					}
					if( iv_calc_infuse_by.equals("I"))
						duration_disp  = infusion_over_disp;
%>
					<tr>
<%
					if(j == 0){
%>		
						<td class="<%=classValue%>" rowspan='<%=NoOfFlowRate%>'><%=fluid_name3%> </td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= volume6 %>&nbsp;<%=vol_uom6%></td>
<%	
					if(inf_rate_uom6.equals("M")|| inf_rate_uom6.equals("m") || inf_rate_uom6.equals("Minute(s)") || inf_rate_uom6.equals("mt(s)")){
%>
						<td class="<%=classValue%>"><%= infusion_rate6%>&nbsp;<%=vol_uom6%> /<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%
					}
					else if(inf_rate_uom6.equals("H") || inf_rate_uom6.equals("h") || inf_rate_uom6.equals("Hour(s)") || inf_rate_uom6.equals("hr(s)")){
%>
						<td class="<%=classValue%>"><%= infusion_rate6%>&nbsp;<%=vol_uom6%> /<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					}
%>
					<td class="<%=classValue%>"><%= infusion_over_disp %>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
<%
					if(j == 0){
%>
						<td class="<%=classValue%>"  rowspan='<%=NoOfFlowRate%>'><%=duration_disp%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></td>
						<td class="<%=classValue%>"  rowspan='<%=NoOfFlowRate%>'><%=order_qty%>&nbsp;<%=order_uom%></td>
<%	
					}
%>
					<td class="<%=classValue%>"><%= start_date6 %></td>
					<td class="<%=classValue%>"><%= end_date6%></td>
				</tr>
<%
				}
			}
			pres_remarks	=	pres_bean.getPresRemarks();
			if(pres_remarks!=null && !pres_remarks.equals("")) { 

%>
				<tr><td colspan="8">&nbsp;</td></tr>
				<tr>
					<td class="label" colspan="8"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:&nbsp;<label style="font-weight:bold"><%=pres_remarks%></label></td>
				</tr>
<%
			 }
%>
			</TABLE>
		</FORM>
	</BODY>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(pres_bean_id,pres_bean,request);
%>

