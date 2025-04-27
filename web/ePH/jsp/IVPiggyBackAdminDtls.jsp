<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana												SKR-SCF-1276
--------------------------------------------------------------------------------------------------------------
*/
%>
   <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePH/js/IVPiggyBack.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
<%
    /*aa*/
	Connection con			= null;//added for ml-mmoh-crf-1223
	try{
	String end_date_time		="";
	String infuse_over			="";
	String infusion_rate		="";
	String selected1            ="selected";
	String selected2            ="";
	String durn_value			="";
	String freq_value			="";
	String optSelected			="";
	String order_catalog_code	="";
	String order_catalog_code1  ="";
	String stock_uom_code		="", stock_uom_desc=""; //stock_uom_desc added for SKR-SCF-1076 [IN:054498]
	String stock_value			="";
	String optSelected1			="";
	int    durn_value1			=0; 
	int    J					=0; 
	String order_line_num       ="";
	String temp					="";
	String infusion_over_time	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	String durn_type1			="";
	String readonly				="";
	String disabled				="";
	String  repeat_value		="";
	String drug_code			="";
	String srl_no               ="";
	String infusion_uom			="H"; 
	String order_id				= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String patient_id			= request.getParameter("patient_id");
	String patient_class		= request.getParameter("act_patient_class");
	String encounter_id			= request.getParameter("encounter_id");
	String facility_id			= (String)session.getValue("facility_id");
	String 	answer				= request.getParameter("answer")==null?"":request.getParameter("answer");

	String bean_id			= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPiggyBackBean";
	ArrayList shedule_freq		= new ArrayList();
	IVPiggyBackBean bean	= (IVPiggyBackBean)getBeanObject( bean_id, bean_name , request) ;


	bean.setLanguageId(locale);
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-1223
	boolean default_comp_fluid_falg = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DEFAULT_COMP_FLUID_INF_OVER");// Added for ML-MMOH-CRF-1223
	HashMap   max_duration  =  bean.getMaxDuration();
	String op_max_duration  =  (String)max_duration.get("OP");
	String ip_max_duration  =  (String)max_duration.get("IP");
	String disp_str			=  "";
	int size = 0;
	if(patient_class!=null && patient_class.equals("IP")){
		size		=	Integer.parseInt(ip_max_duration);
	}
	else{
		size		=	Integer.parseInt(op_max_duration);
	}
	String sys_date				= request.getParameter("start_date");

	String timeFrame			= "";
	ArrayList orderSetValues	= new ArrayList();
		
	String iv_bean_id		= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
    iv_bean.setLanguageId(locale);

	String infuse_over_hr	= "";
	String infuse_over_mi	= "";
	String durn_type		= "";
	String durn_calc		= "";
	String freq_nature		= "";
	String freq_value_durn	= "";
	String interval_value	= "";
	String repeat_value_durn= "";
	String schedule_yn		= "";
	String repeat_durn_type	= "";
	String freq_durn_type	= "";
	String scheduled_yn		= "";
	String split_dose_yn	= "";
	String qty_value		= "";
	String freq_code		= "";
	String infusion_per_unit= "";//INO71514
	ArrayList tmp_freq_values = new ArrayList();
	float total_qty			= 0.0f;
	String final_qty		= "";
	boolean split_chk		=	false;
	String tooltiptable		= "";
	String adm_time			= "";
    HashMap record;
	HashMap record1;
	String param_volume_cal=iv_bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	//date is coming as thai. so it is converted to english to set the order date.13/07/2010
	if(!(order_type_flag.equals("Existing") && answer.equals("N"))) //If condition added for MO-GN-5407 IN31902	
	         iv_bean.setOrderDate(com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM",iv_bean.getLanguageId(),"en"));
	//end comment
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
		
		String bean_id1				    = "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name1				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1, bean_name1, request );
		
		ArrayList exstngIVorder         = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,""); //passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062

		record			=	new HashMap();
		int siz			=	exstngIVorder.size();
		String lengt=siz+"";
		if(lengt.equals("1")){
			record1		=	(HashMap)exstngIVorder.get(0);
			record		=	(HashMap)exstngIVorder.get(0);
		}
		else{
			record1		=	(HashMap)exstngIVorder.get(0);
			record		=	(HashMap)exstngIVorder.get(1);
		}


		freq_nature		= (String)record.get("FREQ_NATURE")==null?"":(String)record.get("FREQ_NATURE");
		freq_value		= (String)record.get("FREQ_VALUE")==null?"":(String)record.get("FREQ_VALUE");
		interval_value	= (String)record.get("INTERVAL_VALUE")==null?"":(String)record.get("INTERVAL_VALUE");
		repeat_value	= (String)record.get("REPEAT_VALUE")==null?"":(String)record.get("REPEAT_VALUE");
		schedule_yn		= (String)record.get("SCHEDULE_YN")==null?"":(String)record.get("SCHEDULE_YN");
		repeat_durn_type= (String)record.get("REPEAT_DURN_TYPE")==null?"":(String)record.get("REPEAT_DURN_TYPE");
		end_date_time	= (String)record.get("END_DATE_TIME");
		order_line_num  = (String)record.get("ORDER_LINE_NUM");
		infuse_over		= (String)record.get("INFUSE_OVER");
		infusion_per_unit		= (String)record.get("INFUSION_PER_UNIT");//INO71514

		if(infuse_over.indexOf(".") != -1){
			infuse_over_hr	 = infuse_over.substring(0,infuse_over.indexOf("."));
			Double Dtemp	 = new Double(infuse_over);
			Dtemp			 = Dtemp*60;
			Dtemp			 = (Dtemp%60);
			infuse_over_mi	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
			if(infuse_over_mi.indexOf(".") != -1)
				infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx

		}else{
			//added for INO71514	
			if(infusion_per_unit.equals("M")){
				infuse_over_hr = "";
				infuse_over_mi = infuse_over;
			}
			else{
				infuse_over_hr	 = infuse_over;
				infuse_over_mi	 = "";
			}
		}

		infuse_over_hr			= infuse_over_hr.equals("")?"0":infuse_over_hr;
		infuse_over_mi			= infuse_over_mi.equals("")?"0":infuse_over_mi;
		disp_str				= "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
		infusion_rate		    =(String)record.get("INFUSION_RATE");
		durn_type1				=(String)record.get("INFUSION_PER_UNIT");
	
		if(durn_type1.equals("H")){
			selected2		  =	"";
			selected1		  =	"selected";
			infusion_over_time=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
			infusion_uom="H";
		}
		else  if(durn_type1.equals("M")){ 
			selected1		=	"";
			selected2		=	"selected";
			infusion_over_time=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			infusion_uom="M";
		}

		if(mode.equals("amend")){
			sys_date		        =(String)record.get("START_DATE_TIME");
			// start date time is coming as thai. so it is converted and order date is saved
			iv_bean.setOrderDate(com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM",locale,"en"));
			iv_bean.setOrder_type_flag("amend");
		}
		String temp_end_date_time = "";	
		if(order_type_flag.equals("Existing") && !mode.equals("amend")){
			if(end_date_time!=null && !(end_date_time.equals(""))){//if block Code added for IN23819 -- 21/09/2010-- priya
				 temp_end_date_time = DateUtils.convertDate(end_date_time, "DMYHM",locale,"en");
			}
			temp=iv_bean.comp_date_time(temp_end_date_time,order_id,order_line_num); //passed temp_end_date_time instead of end_date_time for IN23819 -- 21/09/2010-- priya
			sys_date=temp;

			if(sys_date!=null && !(sys_date.equals(""))){//if block Code added for IN23819 -- 21/09/2010-- priya
				sys_date = DateUtils.convertDate(sys_date, "DMYHM","en",locale);
			}
			iv_bean.setOrder_type_flag("Existing");
		}

		durn_value				=(String)record.get("DURN_VALUE");
		durn_value1				=Integer.parseInt(durn_value);
		freq_value				=(String)record.get("FREQ_CODE");	
		durn_type				=(String)record.get("DURN_TYPE");

		order_catalog_code1		=(String)record1.get("ORDER_CATALOG_CODE");
		order_catalog_code		=(String)record.get("ORDER_CATALOG_CODE");

		iv_bean.setFluidDetails(order_catalog_code1,"","","",""); // CRF-0062 NEWLY ADDED
		ArrayList stockDetails	=iv_bean.getStockDetails(order_catalog_code1, "1");
		stock_uom_code			=(String)stockDetails.get(1);
		stock_uom_desc			=(String)stockDetails.get(2); //added for SKR-SCF-1076 [IN:054498]
		stock_value				=(String)stockDetails.get(0);		
		HashMap freqNature		=(HashMap)iv_bean.freqValidate(freq_value);

	// for renew purpose....
		if(order_type_flag.equals("Existing")){
			readonly="readonly";
		}
		if(mode.equals("amend") || prev_order.equals("previous")){
			readonly="";
		}
		if((mode.equals("amend"))||(order_type_flag.equals("Existing"))){	  
			ArrayList drugData		= (ArrayList) iv_bean.getDrugDetails();
			if(drugData.size()>0){
				HashMap   drugDataMap   = (HashMap) drugData.get(0);
				repeat_value			= (String) drugDataMap.get("REPEAT_VALUE");
				drug_code		        = (String) drugDataMap.get("DRUG_CODE");
				shedule_freq	=  bean.getSheduleFrequency(drug_code);
				drugDataMap.put("DURN_VALUE",durn_value);     // added while fixing IN25314 --01/12/2010-- priya
				drugDataMap.put("DURN_TYPE",durn_type);        // durn value & type was getting set as 1 D from SQL_PH_PRESCRIPTION_SELECT3A query
			}
			srl_no           ="1";
			Hashtable sch_output1	=	new Hashtable();
			sch_output1.put("code",drug_code);
			sch_output1.put("row_value",srl_no);
			sch_output1.put("start_time_assign","");
			sch_output1.put("durationType",durn_type); //replaced repeat_durn_type with durn_type for IN25314 --01/12/2010-- priya  //hanga
			sch_output1.put("daySM7","7");
			sch_output1.put("daySM6","6");
			sch_output1.put("daySM5","5");
			sch_output1.put("daySM4","4");
			sch_output1.put("daySM3","3");
			sch_output1.put("daySM2","2");
			sch_output1.put("daySM1","1");
			sch_output1.put("error","");
			sch_output1.put("repeat",repeat_value);
			sch_output1.put("dayDisplay7","Sat");
			sch_output1.put("dayDisplay6","Fri"); 
			sch_output1.put("dayDisplay5","Thu"); 
			sch_output1.put("displayHrs6","6");
			sch_output1.put("dayDisplay4","Wed");
			sch_output1.put("displayHrs5","5"); 
			sch_output1.put("dayDisplay3","Tue"); 
			sch_output1.put("displayHrs4","4"); 
			sch_output1.put("dayDisplay2","Mon"); 
			sch_output1.put("displayHrs3","3"); 
			sch_output1.put("dayDisplay1","Sun"); 
			sch_output1.put("displayHrs2","2"); 
			sch_output1.put("displayHrs1","1");
			sch_output1.put("start_day_assign","");			
			sch_output1.put("start_day_param",sys_date);			
			order_line_num="1";
			ArrayList values	=	iv_bean.getFreqDet(order_id,order_line_num);

			int incr=0;

			for(int p=0; p<values.size(); p+=4) {
				incr++;
				sch_output1.put("time"+(incr),values.get(p));
				sch_output1.put("qty"+(incr),values.get(p+1));				
				sch_output1.put("admin_day"+(incr),values.get(p+3));
			}

			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output1.put("time"+(q),"");
					sch_output1.put("qty"+(q),"");
				}
			}
			if(scheduled_yn.equals("Y")){ //hanga //if condition added for  IN25314 --01/12/2010-- priya
			iv_bean.setScheduleFrequencyStr(sch_output1);
			}
			ArrayList schedule		= (ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			HashMap temp_freq_chars =	null;
					freq_durn_type	=  "D";
			 if(schedule != null && schedule.size()>0){
				temp_freq_chars = (HashMap)schedule.get(0);
				freq_durn_type	= (String)temp_freq_chars.get("durationType");
			 }
			
			 if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
	 
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);

				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", sys_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code);
				sch_output.put("row_value","1");
				sch_output.put("start_date_time",sys_date);

				freq_durn_type	= (String)sch_output.get("durationType");

//				iv_bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				values	=	iv_bean.getFreqDet(order_id,"1");
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList	 dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = iv_bean.getDayOfWeek(sys_date); 
						  freqCharctValues = (ArrayList)sch_output.get(drug_code);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
		
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add(values.get(p+3));
				}

				
				if(day_list.size()>0){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals(""))
						{
							String temp1 = (String)day_list.get(j);
							if (temp1 == null || temp1.equals(""))
							{
								temp1 = "0";
							}
							if (!temp1.equals("0"))
							{
								day_names.add(week_days.get((Integer.parseInt(temp1))-1));
							}
						
						}
					}
				}

				tmp_freq_values.add(freqCharctValues.get(0));
				tmp_freq_values.add(day_list);
				tmp_freq_values.add(day_names);
				tmp_freq_values.add(time_list);
				tmp_freq_values.add(dose_list);
				sch_output.put(drug_code,tmp_freq_values);

				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}
						
	/*			tooltiptable = (String)iv_bean.getTooltipStringFrFreq(tmp_freq_values,"toolTip");
				adm_time = tooltiptable;
				split_chk	=	iv_bean.checkSplit(tmp_freq_values);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}*/


		/*		int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));				
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}

				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						sch_output.put("qty"+(q),"");
					}
				}*/
				iv_bean.setScheduleFrequencyStr(sch_output);
				schedule		= (ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");
			}

		}
		putObjectInBean(bean_id1,bean1,request);
	}

	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues	        =	null;
	if(scheduled_yn.equals("Y")){ //hanga //if condition added for  IN25314 --01/12/2010-- priya
	chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();
	if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
		frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(order_catalog_code);
		}
	} 
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();

	orderSetValues = iv_bean.getOrderSetValues();
	if(orderSetValues.size() > 0){
		timeFrame			= (String)orderSetValues.get(7);
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(Integer.parseInt((String)orderSetValues.get(i+7)) > Integer.parseInt(timeFrame)){
				timeFrame	= (String)orderSetValues.get(i+7);
			}
		}
		sys_date	= iv_bean.populateEndDate(sys_date,timeFrame,"H");
	}

%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formIVPrescriptionAdminDetail" id="formIVPrescriptionAdminDetail">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<td class="COLUMNHEADER" colspan="12"><font style="font-size:9"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></td>
				<tr>
					<td width='15%' class='label'><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></td>
					<td COLSPAN=2>&nbsp;
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text" width='3%' class="number" size="2" maxlength="9" value="<%=infusion_rate%>" name="INFUSION_VALUE" onChange="CheckNum(this);allowValidNumber(this,event,6,2);calVolumeInfuseOver();" onKeyPress="return allowValidNumber(this,event,6,2); " > 
					<%}
					else{  %>
						<input type="text" width='3%' class="number" size="2" maxlength="9" value="<%=infusion_rate%>" name="INFUSION_VALUE" onChange="CheckNum(this);allowValidNumber(this,event,6,2);calInfuseOver();showAdminRate()" onKeyPress="return allowValidNumber(this,event,6,2);" > <!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415 and allowValidNumber(this,event,3,0) to allowValidNumber(this,event,6,2) for SKR-SCF-1303-->
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
						<label align="left"  width='19%' class='label' id='infusion_uom_display'>&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<select name="infusion_time" id="infusion_time" onChange="ChangeInfuseOverTime(this);calVolumeInfuseOver()"> 
					<%}
					else{  %>
						<select name="infusion_time" id="infusion_time" onChange="ChangeInfuseOverTime(this);calInfuseOver()"> 
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
							<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
							<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						</select> &nbsp;&nbsp;					
					    <A HREF onMouseOver="changeCursor(this);" onClick="adminRate();" style="visibility:hidden" id='adminrate'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></A>
					</td>

					<td width='15%' class='label'><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td >
							<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text"  width='3%' class="number" size='2' maxlength="6" value="<%=infuse_over_hr%>" name="INFUSION_PERIOD_VALUE"  onKeyPress="return allowValidNumber(this,event,3,0);" tabindex='2' onBlur="CheckNum(this);calVolumeInfuseRate();" > 
					<%}
					else{  %>
						<input type="text"  width='3%' class="number" size='2' maxlength="6" value="<%=infuse_over_hr%>" name="INFUSION_PERIOD_VALUE"  onKeyPress="return allowValidNumber(this,event,3,0);" tabindex='2' onBlur="CheckNum(this);calInfusionRate();showAdminRate()" > 
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
						<b>:</b>
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE_MIN" id="INFUSION_PERIOD_VALUE_MIN" value='<%=infuse_over_mi%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onChange="CheckNum(this);calVolumeInfuseRate();showAdminRate()" > 
					<%}
					else{  %>
						<input type="text"  width='3%' class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE_MIN" id="INFUSION_PERIOD_VALUE_MIN" value='<%=infuse_over_mi%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onChange="CheckNum(this);calInfusionRate();showAdminRate()" > 
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						<!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415-->
						<label align="left"  width='5%'class='label' <b><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></b></label>
						<label align="left"  width='5%'class='label' id="infuse_over_str"><%=disp_str%></label>
					</td>	
					
				</tr>
				<tr NOWRAP> 
					<td class="label"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td class="label" COLSPAN=2><select name="FREQUENCY" id="FREQUENCY" onChange="freqChange(this); setSchedule(this.value);ExternalDosageCheck('','admndtl') ; validateFrequency() ; dosageCheck()" <!-- Modified for IN:070451 added dosagecheck function  -->

						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---</option> 
<%
						if((mode.equals("amend"))||(order_type_flag.equals("Existing"))){
	
							for(int i=0;i<shedule_freq.size();i=i+2){
								if(((String)shedule_freq.get(i)).equals(freq_value)){
										 optSelected="selected";

								}
								else{
								   optSelected="";
								}
%>
								 <option value="<%=(String)shedule_freq.get(i)%>" <%=optSelected%> ><%=(String)shedule_freq.get(i+1)%></option>
<%
							}
						}
%>				   	
						</select>&nbsp;<input type="button" name="btn_schedule" id="btn_schedule" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' class="button" onClick="DisplaySchedule()">
					<input type="hidden" name="sched_medn_yn" id="sched_medn_yn" value="N">
					</td> 
					<td class="label" width='12%' id="dosage_label" colspan="" nowrap>&nbsp;</td>						
					
				</tr>
				<tr> 
					<td width='10%' class='label'><fmt:message key="Common.duration.label" bundle="${common_labels}"/><br><label style="visibility:visible" id=""><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->	</td>
					<td class="label">
					
					<%
						if(durn_value.equals(""))
							durn_value = "1";
						if(durn_type==null || durn_type.equals(""))
							durn_type="D";
%>
						<input type="text" size="1" maxlength="3" name="DURN_VALUE" id="DURN_VALUE" class="NUMBER"  value="<%=durn_value%>"  onChange="calEndDate();ExternalDosageCheck('','admndtl');validateFrequency()" onKeyPress="return allowValidNumber(this,event,3,0)" onchange="validateAllDates();ExternalDosageCheck('','admndtl');" >&nbsp;
						<!-- onBlur changed to onChange for SRR20056-SCF-7374 Incident No. 27415-->
						<select name="durn_unit" id="durn_unit" onfocus = "validateFrequency();" onChange="validateAllDates();">
							<option>-<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-</option>
<%
						if(!(order_type_flag.equals("Existing")||mode.equals("amend"))){
							// Added the if/else for durn_type (Y,L,W,D,H,M) for SRR20056-SCF-7374 Incident No. 27415 to default select for durn_unit.
							if(durn_type.equals("Y")){
%>
								<option value='Y' selected><fmt:message key="ePH.years.label" bundle="${ph_labels}"/></option>	  
<%
							}
							else{
%>
								<option value='Y'><fmt:message key="ePH.years.label" bundle="${ph_labels}"/></option>	  
<%
							}
							if(durn_type.equals("L")){
%>
								<option value='L' selected><fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
<%
							}
							else{
%>
								<option value='L'><fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
<%
							}
							if(durn_type.equals("W")){
%>
								<option value='W' selected><fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
<%
							}
							else{
%>
								<option value='W'><fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
<%
							}
							if(durn_type.equals("D")){
%>
								<option value='D' selected><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
<%
							}
							else{
%>
								<option value='D'><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
<%
							}
							if(durn_type.equals("H")){
%>
								<option value='H' selected><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
<%
							}
							else{
%>
								<option value='H'><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
<%
							}
							if(durn_type.equals("M")){
%>
								<option value='M' selected><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
<%
							}
							else{
%>
								<option value='M'><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
<%
							}
						}
%>
						</select>

					</td>	
					<td class='label'><fmt:message key="ePH.StartDateTime.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
					<input type="text" name="START_DATE" id="START_DATE"  <%=readonly%> value="<%=sys_date%>" size="14" maxlength="16" onBlur="chkBackFutureDate(this,'<%=locale%>');calEndDate()"><IMG src="../../eCommon/images/CommonCalendar.gif" <%=disabled%> id=Calendar onclick="showCalendar('START_DATE',null,'hh:mm');document.formIVPrescriptionAdminDetail.START_DATE.focus(); return false;" >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
					<td class='label'><fmt:message key="Common.EndDateTime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td>
						<input type="text" name="END_DATE" id="END_DATE" value=""  size="14" maxlength="16" tabindex='5' readonly>&nbsp; 
					</td> 
				</tr>

			</table>		
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>"		>
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>"		>
			<input type="hidden" name="iv_bean_id" id="iv_bean_id"		value="<%=iv_bean_id%>"		>
			<input type="hidden" name="iv_bean_name" id="iv_bean_name"	value="<%=iv_bean_name%>"	>
			<input type="hidden" name="sys_date" id="sys_date"		value="<%=sys_date%>"		>
			<input type="hidden" name="patient_id" id="patient_id"		value="<%=patient_id%>"		>
			<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>"	>
			<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>"	>
			<input type="hidden" name="facility_id" id="facility_id"		value="<%=facility_id%>"	>
			<input type="hidden" name="freq_changed_yn" id="freq_changed_yn" value="N">
			<input type="hidden" name="PRACT_ID" id="PRACT_ID"		value="<%=pract_id%>">
			<input type="hidden" name="LOCN_CODE" id="LOCN_CODE"		value="<%=locn_code%>">
			<!-- <input type="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM"	value=<%=infusion_uom%>> -->
			<input type="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM"	value="H">
			<input type="hidden" name="INFUSION_UOM" id="INFUSION_UOM"	value=<%=infusion_uom%>>
			<input type="hidden" name="DURN_UNIT" id="DURN_UNIT"		value=<%=durn_type%>> <!-- changed from H to <%=durn_type%> for SRR20056-SCF-7374-->
			<input type="hidden" name="STOCK_VALUE" id="STOCK_VALUE"		value="<%=stock_value%>"	>
			<input type="hidden" name="LOCN_TYPE" id="LOCN_TYPE"		value="<%=locn_type%>"	>
			<input type="hidden" name="EQVL_UOM_CODE" id="EQVL_UOM_CODE"	value="<%=stock_uom_code%>"	>
			<input type="hidden" name="STOCK_UOM_CODE" id="STOCK_UOM_CODE"	value="<%=stock_uom_code%>"	>
			<input type="hidden" name="mode1" id="mode1"	        value="<%=mode%>"	>
			<input type="hidden" name="repeat_value" id="repeat_value"	value=""	>
			<input type="hidden" name="drug_code" id="drug_code"	    value="<%=drug_code%>"	>
			<input type="hidden" name="infusion_over_insert_value" id="infusion_over_insert_value"	value="<%=infuse_over%>"	>
			<input type="hidden" name="calcualted_durn_value" id="calcualted_durn_value"	value=""	>
			<input type="hidden" name="interval_value" id="interval_value"	value="<%=interval_value%>"	>
			<input type="hidden" name="freq_nature" id="freq_nature"   	value="<%=freq_nature%>"	>
			<input type="hidden" name="repeat_durn_type" id="repeat_durn_type"value=""	>
			<input type="hidden" name="scheduled_yn" id="scheduled_yn"	value=""	>
			<input type="hidden" name="back_date" id="back_date" value="" >
			<input type="hidden" name="future_date" id="future_date" value="" >
			<input type="hidden" name="iv_calc_infuse_by" id="iv_calc_infuse_by" value="" >
            <input type="hidden" name="default_comp_fluid_falg" id="default_comp_fluid_falg" value="<%=default_comp_fluid_falg%>" ><!-- Added for ML-MMOH-CRF-1223 -->

			<!-- <input type="hidden" name="drugCodeFreq" id="drugCodeFreq"	value=""	> -->
			<label id="tool_tip" style="visibility:hidden"></label>
				<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
					<tr><td width="100%" id="t"></td></tr>
				</table>
			</div>
			<script>				
				document.querySelectorAll('#infusion_uom_display').innerHTML ="<%=stock_uom_desc%>/"; //stock_uom_code changed to stock_uom_desc for SKR-SCF-1076 [IN:054498]
			</script>
		</form>
	</body>

	 <script>

<%
	if((order_type_flag.equals("Existing")||mode.equals("amend"))){
		out.println("makeAutoSchedule()");
		out.println("assignDurnDesc('"+repeat_value_durn+"','"+repeat_durn_type+"','"+freq_nature+"','"+interval_value+"','','"+freq_value_durn+"','"+schedule_yn+"','','"+durn_value+"','"+durn_type+"')");



	//	out.println("dfltDurnDesc('"+durn_type+"','"+freq_nature+"','')");		
%>

//		document.formIVPrescriptionAdminDetail.durn_unit.value='<%=durn_type%>';

<%
	//	out.println("populateEndDate()");
	}
	if(!order_type_flag.equals("Existing")&& !mode.equals("amend") && !freq_nature.equals("I")){
		
		out.println("setSchedule('"+freq_value+"')");

	}
		HashMap data		=	null;
		String att			=	null;
		adm_time		=	"";
		String adm_qty		=	"";
		//total_qty	=   "";

		if(frequencyValues!=null && frequencyValues.size()>0){

	/*		adm_time =adm_time +"<tr>";					
			for(int i=0;i<frequencyValues.size();i++){
				data=(HashMap)frequencyValues.get(i);
				att="align=center class=TIP";
				adm_time =adm_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			adm_time =adm_time +"</tr>";

			adm_qty= adm_qty +"<tr>";
			for(int i=0;i<frequencyValues.size();i++){
				att="align=center class=TIP";
				data=(HashMap)frequencyValues.get(i);
				adm_qty= adm_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
				total_qty=(String) data.get("admin_qty");
			}
			adm_qty= adm_qty +"</tr>";*/

			
			tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
			adm_qty = tooltiptable;		
			split_chk	=	iv_bean.checkSplit(frequencyValues);	
			out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+iv_bean.getRepeatValue()+"')");
		}
%>
	</script>   
</html>
<script language="javascript">
	calEndDate();
	showAdminRate();
	var str = getHrsMinStr(document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,document.formIVPrescriptionAdminDetail.infusion_time.value);
	
//	document.formIVPrescriptionAdminDetail.all.infuse_over_str.innerHTML	= str;
</script>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
	putObjectInBean(iv_bean_id,iv_bean,request);
}catch(Exception e){
		e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-1223 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-1223 end
%>

