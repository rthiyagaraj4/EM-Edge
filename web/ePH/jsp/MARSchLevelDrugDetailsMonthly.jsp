<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
  
	 <head>
	 <style media="screen" type="text/css">
	/*	#nonIVHeader { position:fixed; top:0; left:0; }
			table {padding-top:15px; }*/
	</style>
<%
try{
 		request.setCharacterEncoding("UTF-8");
 		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
 		request= new XSSRequestWrapper(request); 
 		response.addHeader("X-XSS-Protection", "1; mode=block"); 
 		response.addHeader("X-Content-Type-Options", "nosniff"); 
 		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");	
		String Auto_Admin				=    "";
		float ret_qty=0;
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;

		DecimalFormat dfTest = new DecimalFormat("0.########");

		if(route_admin.equals("undefined")){
			   route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			   admin_route_categ="";
		}
%>
		<script language="javascript">
		var headTop = -1;
		var FloatHead1;
		var FloatHead2;
		var onlyiv=false;
		function processScroll(){
			if (headTop < 0){
				saveHeadPos();
			}				
			if (headTop>0){
				if (document.documentElement && document.documentElement.scrollTop){
					theTop = document.documentElement.scrollTop;
				}
				else if (document.body){
					theTop = document.body.scrollTop;
				}					
				if(FloatHead2!=null){
					if(onlyiv){ //Only IV Drugs
						FloatHead1 = FloatHead2;
					}
					else{ //NonIV and IV Drugs
						if(document.getElementById("ball").offsetTop < theTop){
							FloatHead1.style.visibility= 'hidden';
							FloatHead1 = FloatHead2;
							FloatHead1.style.visibility= 'visible';
							FloatHead1.style.position = "absolute";	
						}
						else {								
							FloatHead1.style.position = "";	
							FloatHead1 = document.getElementById("nonIVHeader");
							FloatHead1.style.visibility= 'visible';
							FloatHead1.style.position = "relative";	
						}
					}
				}
				else{ // only NON IV Drugs
					FloatHead1 = document.getElementById("nonIVHeader");							
				}
				if (theTop>headTop){
					FloatHead1.style.top = (theTop-headTop) + 'px';								
				}
				else{
					FloatHead1.style.top = '0px';							
				}
			}				
		}

		function saveHeadPos(){
			parTable = document.getElementById("nonIVHeaderDiv");
			if (parTable != null){					
				headTop = parTable.offsetTop + 3;					
				FloatHead1 = document.getElementById("nonIVHeader");
				FloatHead1.style.position = "relative";
				FloatHead2= document.getElementById("IVHeader");
				if (FloatHead2 != null){						
					onlyiv=false;
				}
			}
			else{					
				parTable = document.getElementById("IVHeaderDiv");
				if (parTable != null){
					headTop = 3;	
					FloatHead2 = document.getElementById("IVHeader");
					FloatHead2.style.position = "absolute";
					onlyiv=true;
				}
			}
		}			
		window.onscroll = processScroll;
		</script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
		<script type="text/javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="Javascript" src="../../ePH/js/PPNRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%!
	public String roundDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 2){
					bb=a.substring(0,a.indexOf(".")+2);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
	}
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="MedicationAdministrationSchLevelDrugDtls" id="MedicationAdministrationSchLevelDrugDtls" >
<% 
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.setCurrentTimeAndAdminWithinHRS();

	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	admin_bean.setLanguageId(locale);
	
	HashMap	drug_details		  =	(HashMap) bean.getMARDetailsMonthView(encounter_id,hold_discontinue_yn,administration_status,order_type,from_time,to_time,display_order_by,route_admin,admin_route_categ);
	ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "M");
	int daySize=0;
	if(altDateDayList!=null && altDateDayList.size()>0)
		daySize = altDateDayList.size();
	String iv_prep_yn			   =	"";
	String title				   =	"";
	String patient_id					=   "";
	int no_of_alt_drus_selected			=   0;	
	LinkedHashMap	hmNonIVDrugDetails				=	 (LinkedHashMap) drug_details.get("NON_IV");
	LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
	HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
	ArrayList	non_iv_drug_details	=null;
	ArrayList	alTmpOrderSchDetail	=null;
	ArrayList iv_drug_details =null;
	List OrdersList = null;
	Set uniqueSchedules = null;
	Iterator<String> itrSch = null;
	String Store_locn_code				=	"";
	String sch_date_time="";
	String Storelocn_code				=	"";
	String drug_code="", drug_desc="", drug_class="", drug_class_ind="";
	String  prn_remarks, ext_prod_id="",  start_date_time="", end_date_time="", end_date="";
	String  order_pract_id="",  disp_drug_code  ;
	HashMap overridereason = null;
	String classvalue ="";
	String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "";
	String administered_yn="", doseDisplay="", non_iv_admin_quaty, displayStyle="", displayFreqStyle="", admin_recorded_yn="";
	String strength_per_value_pres_uom = "1",qty="", pres_dosage="", fieldname="", dose_uom_desc1="", tempDosage="" , freq_nature="", freq_code="", dosage_seq_no="", 			admin_drug_code	    =  "", admin_drug_desc 	=  "", admindrugdetails, ord_hold_date_time="", ord_disc_date_time="", discontinued_sch="", discontinued_dose="", hold_sch="";
	String admin_dose_prn, remarks="", discontinued, hold,  stat_style="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="", prn_qty_desc="";
	StringTokenizer stadmindrugdetails	=	null;
	StringTokenizer stiv_incred			=	null;	
	String pract_id						=	"";		String against_sch_date				=	"";
	String adr_reason					=	"";		String adr_remarks					=	"";
	String adr_record_time				=	"";		String adr_recorded_by				=	"";
	String adr_details					=	"";	
	String adminStatus="";
	String encode_drug_desc				=   "";
	String next_schd_date				=	"";		String AdUOM						=	"";
	String demostring					=  "\\\'\'";
	String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
	String nonMfrFluidRemarks			=	"";		String linkVacScheduleDesc ="";
	String remarks_style="",  batch_id="", flag="", item_code="", expiry_date ="", AdminBackLogTime="", defaultBatch="", defaultExpiryDate="", defaultTradeId ="", trade_id="" ;
	int orderCount		 = 0, prn_doseCount=0;
	int recCount = 0;
	int dialog_height = 0;
	int rowsPan = 1;
	int schSize = 1;
	int schDayCount =0;
	int dayCount=0;
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int ppn_count						=   0;
	String prev_key="", curr_key="", schKey="", prev_freq_nature="", prev_end_date="";


	if((hmNonIVDrugDetails.size()==0) &&(hmIVDrugDetails.size()==0)){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
		</script>
<%		
		return;
	}
	if(hmNonIVDrugDetails.size()>0){
					
%>
		<div id="nonIVHeaderDiv" > 
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="non_iv_administration_table">
				<tr id="nonIVHeader">
					<td class="TDSTYLE" width="19%" ><B><fmt:message key="ePH.MedicationName.label" bundle="${ph_labels}"/></B></td>
					<td class="TDSTYLE" width="6%"><B><fmt:message key="ePH.ScheduleTime.label" bundle="${ph_labels}"/></B></td>
<%
					if(altDateDayList!=null && altDateDayList.size()>0){
						daySize = altDateDayList.size();
						for(int day=0; day<daySize; day+=2){
%>
							<td class="TDSTYLE" width="2%"><B><%=(String)altDateDayList.get(day+1)%></B></td>
<%
						}
					}
%>
			</tr>
<%
			if(!order_type.equals("A")){ 
				iv_prep_yn				=    (String)drug_details.get("iv_prep_yn");
				if(iv_prep_yn == null)
					iv_prep_yn =    "";
				if(function_from.equals("CP"))
					iv_prep_yn	=	bean.IVType(order_id);
				if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
					title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
				else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
					title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
				else
					title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
%>
				<tr id="nonIVOrderTypeHdr" >
					<td class='COLUMNHEADER' colspan="<%=(daySize/2)+7%>"  style="font-size:10" ><b><%=title%><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
				</tr>
<%	
		}
		OrdersList = new ArrayList(hmNonIVDrugDetails.keySet());
		for (int i=0;i<OrdersList.size();i++){	
			alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
			schSize=1;
			prn_doseCount=0;
			//if(schCount>4)
				//rowsPan = 4;
			for(int sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				non_iv_drug_details = (ArrayList)alTmpOrderSchDetail.get(sch);
				drug_code		= (String)non_iv_drug_details.get(0);	
				disp_drug_code		= (String)non_iv_drug_details.get(0);	
				drug_desc		= (String)non_iv_drug_details.get(1);	
				order_id	    = (String)non_iv_drug_details.get(2);
				order_line_num  = (String)non_iv_drug_details.get(3);
				sch_date_time   = (String)non_iv_drug_details.get(5);
				dosage_seq_no		= (String)non_iv_drug_details.get(6);
				discontinued		= (String)non_iv_drug_details.get(7);
				hold				= (String)non_iv_drug_details.get(8);
				administered_yn  = (String)non_iv_drug_details.get(9);
				admin_recorded_yn	= (String)non_iv_drug_details.get(10);
				end_date_time	= (String)non_iv_drug_details.get(11);
				freq_nature	  = (String)non_iv_drug_details.get(12);
				adr_reason			= (String)non_iv_drug_details.get(15);
				adr_remarks			= (String)non_iv_drug_details.get(16);
				adr_record_time		= (String)non_iv_drug_details.get(17);
				adr_recorded_by		= (String)non_iv_drug_details.get(18);
				prn_remarks			= (String)non_iv_drug_details.get(19);				
				start_date_time	= (String)non_iv_drug_details.get(21);
				ext_prod_id			= (String)non_iv_drug_details.get(22);
				schDate	= (String)non_iv_drug_details.get(24);
				schTime	= (String)non_iv_drug_details.get(25);
				split_dose_yn	= (String)non_iv_drug_details.get(26);
				iv_prep_yn			= (String)non_iv_drug_details.get(27);
				ord_hold_date_time	= (String)non_iv_drug_details.get(29);
				ord_disc_date_time	= (String)non_iv_drug_details.get(30);

				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
					adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;	
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}

				if(remarks==null){
					remarks="Not Entered";
				}
		
				displayFreqStyle = "";
				displayStyle = "";
				
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
					displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
				}
				else if(admin_recorded_yn.equals("Y")){
					if(administered_yn.equals("N")) 
						displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
					else {
						displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
						if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
						if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
					}
				}
				else if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
					displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
				}
				if( freq_code.equals("STAT") || freq_nature.equals("O")) {
					displayFreqStyle	=	"BACKGROUND-COLOR:#CE00CE;";
				} 
				if(sch==0){
					uniqueSchedules = null;
					if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
						uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
						schSize = uniqueSchedules.size();
					}
					/*if(schSize>4)
						rowsPan=4;
					else*/
						rowsPan = schSize;
					if(order_type.equals("A")){
						if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){
							temp1++;
							temp2=0;
							temp3=0;
						}
						else if(iv_prep_yn.equals("8") ||iv_prep_yn.equals("7")){
							temp1=0;
							temp2=0;
							temp3++;
						}
						else{
							 temp1=0;
							 temp3=0;
							 temp2++;
						} 
						if(	temp1==1){
%>
							<tr id="nonIVOrderTypeHdr" >
								<td class='COLUMNHEADER'  colspan="<%=daySize+2%>"  style="font-size:10" ><b><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
							</tr>
<% 
						} 
						else if(temp2==1){ 
%>
							<tr id="nonIVOrderTypeHdr" >
								<td class='COLUMNHEADER'  colspan="<%=daySize+2%>"  style="font-size:10" ><b><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
							</tr>
<%
						}
						else if(temp3==1){ 
%>
							<tr id="nonIVOrderTypeHdr" >
								<td class='COLUMNHEADER'  colspan="<%=daySize+2%>"  style="font-size:10" ><b><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
							</tr>
<%
						}
					} 
							
					if ((orderCount+1) % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;	
				
					if(drug_class!=null && drug_class.equals("N")){
						drug_class_ind = "background:#66FFFF;";
					}
					else if(drug_class!=null && drug_class.equals("C")){
						drug_class_ind = "background:#CCFFCC;";
					}
					else if(iv_prep_yn.equals("6")){
						drug_class_ind = "background:#E4CAFF;";
					}
					else{
						drug_class_ind = "";
					}
%>
					<tr>
						<td class="<%=classvalue%>" width='19%' style="font-size:9;<%=drug_class_ind%>" rowspan='<%=rowsPan%>'>
<%
							if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {
%>
								<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=disp_drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%			
							}
%>	
							<label  style="font-size:9;font-weight:bold;color:black"><%=drug_desc%>		
<%				
							if( !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){
%>					
								<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
							}
							if(iv_prep_yn.equals("7")){
								if(ppn_count >0){
%>
									<img src='../../ePH/images/AddedIngredient.gif' width='17' height='15' onclick = "openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=Store_locn_code%>')" onmouseover="changeCursor(this);">						  
<%								}
							}
%>
							</label>
						</td>
<%
					}
					if(uniqueSchedules!=null){
						schKey = schTime;
						if(freq_nature.equals("P"))
							schKey = dosage_seq_no;
						if(uniqueSchedules.contains(schKey)){
							uniqueSchedules.remove(schKey);
							if(sch!=0){
								schDayCount++;
								for(;schDayCount<=(daySize/2); schDayCount++){
									dispDate = (String)altDateDayList.get((schDayCount-1)*2);
									if(prev_freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(prev_end_date, dispDate, "DMY", locale) ){
%>
										<td class='<%=classvalue%>' width='2%'  style="font-size:9;"><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></td>
<%
									}
									else{
%>
										<td class='<%=classvalue%>' width='2%'  style="font-size:9;">&nbsp;</td>
<%
									}
								}
%>
								</tr>
								<tr>
<%
								schDayCount=0;
								dayCount = 0;
							}
							if(freq_nature.equals("P")){
%>
								<td class='<%=classvalue%>' width='2%' style="font-size:9;" ><fmt:message key="Common.Dose.label" bundle="${common_labels}"/><%=++prn_doseCount%></td>
<%
							}
							else{
%>
								<td class='<%=classvalue%>' width='2%' style="font-size:9;" ><%=schTime%></td>
<%
							}
						}
						for(int day=(dayCount*2); day<daySize; day+=2){
							dispDate = (String)altDateDayList.get(day);
							if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount ==dayCount){
								schDayCount++;
								dayCount++;
									if(dispDate.equals(schDate)){
										scheKey = order_id+"_"+order_line_num+"_"+dayCount+"_"+dosage_seq_no;
										if(administered_yn.equals("Y")){
%>
											<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
												<div id="order<%=scheKey%>" ><img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>'  title='<fmt:message key="ePH.RecordPostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
												</div>
											</td>
<%
										}
										else if(freq_nature.equals("P") ){
%>
											<td class='<%=classvalue%>' width='2%'  style="font-size:9;"><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></td>
<%
										}
										else{
%>
											<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;</td>
<%
										}
										break;
									}
									else{
%>
										<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;">&nbsp;</td>
<%
									}
								}
								else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
									schDayCount++;
									dayCount++;
%>
									<td class='<%=classvalue%>' width='2%'  style="font-size:9;">&nbsp;</td>
<%
								}
								else
									dayCount++;
							}
						}
						else{
							dayCount=0;
								for(int day=0; day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									if(dispDate.equals(schDate)){
											if(administered_yn.equals("Y")){
%>
												<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
													<div id="order<%=scheKey%>" >											
													<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' title='<fmt:message key="ePH.RecordPostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
													</div>
												</td>
<%
											}
											else if(prev_freq_nature.equals("P") ){
%>
												<td class='<%=classvalue%>' width='2%'  style="font-size:9;"><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></td>
<%
											}
											else{
%>
												<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;</td>
<%
											}
									}
									else{
%>
										<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;">&nbsp;</td>
<%
									}
									dayCount++;
							}
%>
						</tr>
<%
					}
					prev_freq_nature=freq_nature;
					prev_end_date=end_date_time.substring(0,10);
					recCount++;
				}
				schDayCount++;
				for(;schDayCount<=(daySize/2); schDayCount++){
					dispDate = (String)altDateDayList.get((schDayCount-1)*2);
					end_date = end_date_time.substring(0,10);
					scheKey = order_id+"_"+order_line_num+"_"+schDayCount+"_"+dosage_seq_no;
					if(freq_nature.equals("P") && com.ehis.util.DateUtils.isBetween(start_date_time.substring(0,10),end_date, dispDate, "DMY", locale)){
%>
							<td class='<%=classvalue%>' width='2%' style="text-align:center;font-size:9;" >
								<fmt:message key="Common.PRN.label" bundle="${common_labels}"/>
							</td>
<%
					}
					else{
%>
						<td class='<%=classvalue%>' width='2%' style="font-size:9;" >&nbsp;</td>
<%
					}
				}
%>
			</tr>
<%
			schDayCount=0;
			dayCount = 0;
			orderCount++;
		}
%>
		</table>
		</div>
<%
	} 
%>	
	<br>
<%
		if(hmIVDrugDetails.size()>0){
					
%>
			<img id="ball" src="/images/ball.png" style="visibility:hidden" height="5"/>
			<div id="IVHeaderDiv" > 
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="iv_administration_table">
					<tr id="IVHeader">
						<td class="TDSTYLE" width="19%" ><B><fmt:message key="ePH.MedicationName.label" bundle="${ph_labels}"/></B></td>
						<td class="TDSTYLE" width="6%"><B><fmt:message key="ePH.ScheduleTime.label" bundle="${ph_labels}"/></B></td>
<%
						if(altDateDayList!=null && altDateDayList.size()>0){
							daySize = altDateDayList.size();
							for(int day=0; day<daySize; day+=2){
%>
								<td class="TDSTYLE" width="2%"><B><%=(String)altDateDayList.get(day+1)%></B></td>
<%
							}
						}
%>
					</tr>
<%
					String IVclassvalue= "", prod_name="";
			int ivRowCount = 0;
			boolean ivnextRow = false;
			int fluidRowspan=1, drugRowspan=1, freqRowspan=1, schRowspan=1 ;
			String ivPB_drug_code = "", ivPB_trade_code="", ivPB_drug_desc ="", ivPB_sch_infusion_rate="", ivPB_sch_infusion_vol_str_unit_desc="", ivPB_sch_infusion_per_unit="", 
			ivPB_qty="", ivPB_qty_uom="", ivPB_imageFileURL="",  ivPB_ext_prod_id="", ivPB_encode_drug_desc="";
			ArrayList alTmpIVPBDrugDtls = null;
			HashMap hmIVDrugFluidDtls=null;
			ArrayList alIVPBDrugSchList = null;
		OrdersList = new ArrayList(hmIVDrugDetails.keySet());
		for (int i=0;i<OrdersList.size();i++){
			alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get((String)OrdersList.get(i));
			schSize=1;
			//if(schCount>4)
				//rowsPan = 4;
			for(int sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(sch);
				drug_code		= (String)iv_drug_details.get(2);	
				disp_drug_code		= (String)iv_drug_details.get(2);	
				drug_desc		= (String)iv_drug_details.get(3);	
				order_id	    = (String)iv_drug_details.get(6);
				order_line_num  = (String)iv_drug_details.get(7);
				sch_date_time   = (String)iv_drug_details.get(4);
				dosage_seq_no		= (String)iv_drug_details.get(5);
				discontinued		= (String)iv_drug_details.get(8);
				hold				= (String)iv_drug_details.get(9);
				administered_yn  = (String)iv_drug_details.get(10);
				admin_recorded_yn	= (String)iv_drug_details.get(11);
				end_date_time	= (String)iv_drug_details.get(12);
				freq_nature	  = (String)iv_drug_details.get(13);
				adr_reason			= (String)iv_drug_details.get(16)==null?"":(String)iv_drug_details.get(16);
				adr_remarks			= (String)iv_drug_details.get(17);
				adr_record_time		= (String)iv_drug_details.get(18)==null?"":(String)iv_drug_details.get(18);
				adr_recorded_by		= (String)iv_drug_details.get(19);
				iv_prep_yn			= (String)iv_drug_details.get(20);
				start_date_time	= (String)iv_drug_details.get(23);
				ext_prod_id			= (String)iv_drug_details.get(21);
				schDate	= (String)iv_drug_details.get(24);
				schTime	= (String)iv_drug_details.get(25);
				split_dose_yn	= (String)iv_drug_details.get(26);
				ord_hold_date_time	= (String)iv_drug_details.get(28);
				ord_disc_date_time	= (String)iv_drug_details.get(29);
				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
					adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;	
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}

				if(remarks==null){
					remarks="Not Entered";
				}
		
				displayFreqStyle = "";
				displayStyle = "";
				
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
					displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
				}
				else if(admin_recorded_yn.equals("Y")){
					if(administered_yn.equals("N")) 
						displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
					else {
						displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
						if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
						if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
					}
				}
				else if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
					displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
				}
				if( freq_code.equals("STAT") || freq_nature.equals("O")) {
					displayFreqStyle	=	"BACKGROUND-COLOR:#CE00CE;";
				} 
				if ((orderCount+1) % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;	
				if(order_line_num.equals("1"))
					IVclassvalue="IVFLUID1";
				else
					IVclassvalue="IVINGREDIENT1";
				if(sch==0){
					uniqueSchedules = null;
					if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
						uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
						schSize = uniqueSchedules.size();
					}
					rowsPan = schSize;
				if(sch==0 ){
%>
						<tr>
<%
					}

					if(!(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){
%>
						<td class="<%=IVclassvalue%>" width='19%' style="font-size:9;<%=drug_class_ind%>"  >
<%
							if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
								<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%
							}
%>
							<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=drug_desc%> &nbsp;&nbsp;
<%
							if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){
%>
								<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
							}
%>
							</label>		
							</td>
							<td class='<%=classvalue%>' width='5%'  style="font-size:9;" rowspan='<%=rowsPan%>'>&nbsp;</td>
<%
					}
					else if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
						ivnextRow = false;
						if(sch==0 || (ivRowCount == fluidRowspan && uniqueSchedules.contains(schTime))){
							if(sch!=0 &&(ivRowCount== fluidRowspan && alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0)){ //Drug display
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								if(drug_class!=null && drug_class.equals("N"))
									drug_class_ind = "background:#66FFFF";
								else if(drug_class!=null && drug_class.equals("C"))
									drug_class_ind = "background:#CCFFCC";
								else
									drug_class_ind = "";
								
								ivPB_sch_infusion_rate			= (String)alTmpIVPBDrugDtls.get(1);

								if(ivPB_sch_infusion_rate!= null && !(ivPB_sch_infusion_rate.equals(""))){
									if(Float.parseFloat(ivPB_sch_infusion_rate) < 1.0){ 
										ivPB_sch_infusion_rate = Float.parseFloat(ivPB_sch_infusion_rate)+"";
									}
								}
								ivPB_sch_infusion_per_unit		= (String)alTmpIVPBDrugDtls.get(3);
								if(ivPB_sch_infusion_per_unit.equals("H")){
									ivPB_sch_infusion_per_unit = "Hrs";
								}
								else{
									ivPB_sch_infusion_per_unit = "Mins";
								}
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){
%>
										<td class='<%=classvalue%>' width='5%'  style="font-size:9;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
									}
%>
									</tr>
									<tr>
<%
									schDayCount=0;
									dayCount = 0;
								}
%>
								<td class="<%=IVclassvalue%>" width='19%' style="font-size:9;<%=drug_class_ind%>"  rowspan='<%=drugRowspan%>'>
<%
								if (!iv_prep_yn.equals("4")){
%>
									<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=ivPB_drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=ivPB_drug_desc%> &nbsp;&nbsp;
<%
								if( !ivPB_ext_prod_id.equals("")&& !iv_prep_yn.equals("4")){
%>
									<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ivPB_ext_prod_id%>','<%=ivPB_encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
								}
%>
								</label>		
								</td>
<%
							}
							else{ //Fluid Display
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){
%>
										<td class='<%=classvalue%>' width='5%'  style="font-size:9;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
									}
%>
									</tr>
									<tr>
<%
									schDayCount=0;
									dayCount = 0;
								}
%>
								<td class="<%=IVclassvalue%>" width='19%' style="font-size:9;<%=drug_class_ind%>"  rowspan='<%=fluidRowspan%>'>
<%
									if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
										<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%
									}
%>
									<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=drug_desc%> &nbsp;&nbsp;
<%
									if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){
%>
										<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
									}
%>
									</label>		
								</td>
<%
							}
						}
					}
						if(order_line_num.equals("1")) {
							if(uniqueSchedules!=null){
								if(uniqueSchedules.contains(schTime)){
									uniqueSchedules.remove(schTime);
									ivRowCount++;
									if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
										if(sch!=0 && !ivnextRow){
											ivnextRow = false;
											for(;schDayCount<(daySize/2); schDayCount++){
%>
												<td class='<%=classvalue%>' width='5%'  style="font-size:9;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
											}
%>
											</tr>
											<tr>
<%
										}
%>
										<td class='<%=classvalue%>' width='5%' style="font-size:9;" ><%=schTime%></td>
<%
										schDayCount=0;
										dayCount = 0;
									}
								}
						for(int day=(dayCount*2); day<daySize; day+=2){
							dispDate = (String)altDateDayList.get(day);
							if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount ==dayCount){
								schDayCount++;
								dayCount++;
									if(dispDate.equals(schDate)){
										scheKey = order_id+"_"+order_line_num+"_"+dayCount+"_"+dosage_seq_no;
										if(administered_yn.equals("Y")){
%>
											<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
												<div id="order<%=scheKey%>" >														
												<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>'  title='<fmt:message key="ePH.RecordPostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
												</div>
											</td>
<%
										}
										else{
%>
											<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
											</td>
<%
										}
										break;
									}
									else{
%>
										<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;">&nbsp;</td>
<%
									}
								}
								else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
									schDayCount++;
									dayCount++;
%>
									<td class='<%=classvalue%>' width='2%'  style="font-size:9;">&nbsp;</td>
<%
								}
								else
									dayCount++;
							}
							}
						}
						else{
							dayCount=0;
								for(int day=0; day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									if(dispDate.equals(schDate)){
											if(administered_yn.equals("Y")){
%>
												<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
													<div id="order<%=scheKey%>" >											
													<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' title='<fmt:message key="ePH.RecordPostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
													</div>
												</td>
<%
											}
											else{
%>
												<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;<%=displayStyle%>">&nbsp;
													<div id="order<%=scheKey%>"></div>
												</td>
<%
											}
									}
									else{
%>
										<td class='<%=classvalue%>' width='2%'  style="text-align:center;font-size:9;">&nbsp;</td>
<%
									}
									dayCount++;
								}
							}
							schDayCount=0;
							dayCount = 0;
%>
							</tr>
<%
							if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0 && schSize ==1){
								rowsPan = 2;
								freqRowspan=2;
								schRowspan=2;
								drugRowspan=1;
								fluidRowspan=1;
								ivnextRow = true;
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								if(drug_class!=null && drug_class.equals("N"))
									drug_class_ind = "background:#66FFFF";
								else if(drug_class!=null && drug_class.equals("C"))
									drug_class_ind = "background:#CCFFCC";
								else
									drug_class_ind = "";
								
								ivPB_sch_infusion_rate			= (String)alTmpIVPBDrugDtls.get(1);

								if(ivPB_sch_infusion_rate!= null && !(ivPB_sch_infusion_rate.equals(""))){
									if(Float.parseFloat(ivPB_sch_infusion_rate) < 1.0){ 
										ivPB_sch_infusion_rate = Float.parseFloat(ivPB_sch_infusion_rate)+"";
									}
								}
								ivPB_sch_infusion_per_unit		= (String)alTmpIVPBDrugDtls.get(3);
								if(ivPB_sch_infusion_per_unit.equals("H")){
									ivPB_sch_infusion_per_unit = "Hrs";
								}
								else{
									ivPB_sch_infusion_per_unit = "Mins";
								}
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);

%>
								<tr>
								<td class="<%=IVclassvalue%>" width='19%' style="font-size:9;<%=drug_class_ind%>"  rowspan='<%=drugRowspan%>'>
<%
								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
									<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=ivPB_drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=ivPB_drug_desc%> &nbsp;&nbsp;
<%
								if( !ivPB_ext_prod_id.equals("")){
%>
									<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ivPB_ext_prod_id%>','<%=ivPB_encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
								}
%>
								</label>		
								</tr>
<%
							}
						}
					}
				}
%>
					</tr>
				</table>
			</div>
<%
		}
%>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>">
	<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id_test%>">
	<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
	<input type="hidden" name="patient_id_selected" id="patient_id_selected" value="<%=patient_id%>">
	<input type="hidden" name="admin_due_date" id="admin_due_date"		value="<%=admin_due_date%>">
	<input type="hidden" name="assign_bed_num" id="assign_bed_num"		value="<%=assign_bed_num%>">
	<input type="hidden" name="disp_locn_code" id="disp_locn_code"		value="<%=Store_locn_code%>">
	<input type="hidden" name="nursing_unit" id="nursing_unit"		value="<%=nursing_unit%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
	<input type="hidden" name="mode" id="mode"				value="<%=CommonRepository.getCommonKeyValue( "MODE_INSERT" )%>">	
	<input type="hidden" name="non_iv_records" id="non_iv_records"		value="<%=orderCount%>">
	<input type="hidden" name="func_mode" id="func_mode"			value="<%=mode%>">
	<input type="hidden" name="hold_discontinue_yn" id="hold_discontinue_yn" value="<%=hold_discontinue_yn%>">
	<input type="hidden" name="adr_recorded" id="adr_recorded"		value="N">
	<input type="hidden" name="admin_recorded" id="admin_recorded"		value="N">
	<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
	<input type="hidden" name="from_time" id="from_time"			value="<%=from_time%>">
	</form>
	</body>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:15%;visibility:hidden;" bgcolor="blue">
		<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="100%" height="100%" align="center">
			<tr><td id="tooltiptd"></td></tr>
		</table>
	</div>
	</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

