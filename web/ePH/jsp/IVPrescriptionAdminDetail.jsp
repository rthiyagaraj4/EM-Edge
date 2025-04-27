<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
23/07/2020      IN073425           Prabha											   SKR-SCF-1392
--------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</HEAD>
<%
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_class		= request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
	String start_date			= request.getParameter("start_date")==null?"":request.getParameter("start_date");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String pr_order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String locale = (String) session.getAttribute("LOCALE");
	String mfr_yn				= "";
	String disable_for_mfr		= "";
	String infusion_rate		= "";
	String infuse_over			= "";
	String duration				= "24";
	String start_time			= "";
	String end_time				= "";
	String disabled				= "";
	String order_line_num		= "";
	String QTY_UNIT				= "";
	String renewOrderStartDate  = "";
	String selected1  = "selected";
	String selected2  = "";
	String timeFrame			= "";
	String infusion_period_uom ="H"; 
	String infusionOverUnit =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	infusion_period_uom="H"; 
	ArrayList orderSetValues	= new ArrayList();

	ArrayList exstngIVOrders = new ArrayList();
	HashMap   record = new HashMap();

	String order_type_flag = request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String	infuse_over_hr = "";
	String	infuse_over_mi = "";

	if(order_type_flag.equals("Existing")) 
		disabled = "disabled";
	if(mode.equals("amend")) 
		disabled = "";

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name,request) ;
	
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);
	bean.setLanguageId(locale);
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId()==null?"":(String)ORbean.getPractitionerId();
	String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); //added for SKR-CRF-0035 start
	String iv_calc_infuse_display="", iv_calc_duration_display="";
	if(iv_calc_infuse_by.equals("I")){
		iv_calc_infuse_display="display:inline;";
		iv_calc_duration_display="display:none;";
	}
	else{
		iv_calc_infuse_display="display:none;";
		iv_calc_duration_display="display:inline;";
	} //added for SKR-CRF-0035 end
	String param_volume_cal=bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	String disp_str = "";
	if(!prev_order.equals("") && prev_order.equals("previous")){
		ORbean.setOrderId(pr_order_id);
		disabled = "";
	}
	String order_id		= (String)ORbean.getOrderId();
	String freq_code = "";
	String freq_desc = "";

	ArrayList frequency = bean.getFrequency();
	if(frequency.size() > 0){
		freq_code = (String)frequency.get(0);
		freq_desc = (String)frequency.get(1);
	}
	if((order_type_flag.equals("Existing") || mode.equals("amend"))){
		exstngIVOrders = bean.getAllExistingIVOrders();
		record = (HashMap)exstngIVOrders.get(0);
// the below 3 vars were assigned inside the if(!mfr_yn.equals("Y")){} block , now its assigned outside if block- prev order copy MFR issue : 26465
		start_time = (String)record.get("START_DATE_TIME");
		end_time = (String)record.get("END_DATE_TIME");
		order_line_num = (String)record.get("ORDER_LINE_NUM");

		mfr_yn = (String)record.get("MFR_YN")==null?"":(String)record.get("MFR_YN");
		if(!mfr_yn.equals("Y")){
			infusion_rate = (String)record.get("INFUSION_RATE");
			infuse_over = (String)record.get("INFUSE_OVER");
			if(!infusion_rate.equals("")){
				if(Float.parseFloat(infusion_rate)<1 && Float.parseFloat(infusion_rate)>0)
				infusion_rate=Float.parseFloat(infusion_rate)+"";
			}
			if(infuse_over.indexOf(".") != -1){
				infuse_over_hr = infuse_over.substring(0,infuse_over.indexOf("."));
				Double temp = new Double(infuse_over);
				temp = temp*60;
				temp = (temp%60);

				infuse_over_mi = Math.round(temp)+""; // infuse_over_mi = xx.0
				if(infuse_over_mi.indexOf(".") != -1)
					infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
			}
			else{
				infuse_over_hr = infuse_over;
				infuse_over_mi = "";
			}
			infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
			infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
			disp_str = "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
			if(iv_calc_infuse_by.equals("I"))
				duration = "24";
			else
				duration = (String)record.get("DURN_VALUE");
			
			QTY_UNIT  = (String)record.get("QTY_UNIT")==null?"":(String)record.get("QTY_UNIT");
			if(!QTY_UNIT.equals("")) 
				QTY_UNIT = QTY_UNIT+" / ";

	//		infusion_period_uom				=(String)record.get("INFUSION_PER_UNIT")==null?"H":(String)record.get("INFUSION_PER_UNIT");
			infusion_period_uom				=(String)record.get("INF_PERIOD_UNIT")==null?"H":(String)record.get("INF_PERIOD_UNIT");

			if(infusion_period_uom.equals("H")){
				selected2="";
				selected1="selected";
				infusionOverUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
				infusion_period_uom="H";
			}
			else  if(infusion_period_uom.equals("M")){ 
				selected1="";
				selected2="selected";
				infusionOverUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			}
		}
		else{
			disable_for_mfr = "disabled";
			if(iv_calc_infuse_by.equals("I"))
				duration="24";
			else
				duration = (String)((HashMap)bean.getMFRRecs()).get("totDurnHrs");
		}
	}

	if(!mode.equals("amend")){
		renewOrderStartDate=bean.comp_date_time(end_time,order_id,order_line_num);
		start_time =renewOrderStartDate;
	}
	if(!start_date.equals("") && (prev_order==null || !prev_order.equals("previous"))) {
		start_time  = start_date;
		if(!locale.equals("en")){ //if condition added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574] Leap Year Issue
			start_time = DateUtils.convertDate(start_time, "DMYHM",locale,"en");	//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
			//sys_date_time_str = DateUtils.convertDate(sys_date_time_str, "DMYHM","en",locale); //commented for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		}
		end_time	= bean.populateEndDate(start_time,"24","H");//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		start_time  = DateUtils.convertDate(start_time, "DMYHM","en",locale);//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		end_time    = DateUtils.convertDate(end_time, "DMYHM","en",locale); //added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
	}																						//added for [IN:56574]
/*==============================================================================================================*/
//Code added for IN23819 -- 21/09/2010-- priya
	if(prev_order!=null && prev_order.equals("previous")){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		try{ 
			 java.util.Date sys_date_time =  df.parse(bean.getSysdate());  
			 String sys_date_time_str = df.format(sys_date_time);
				if(!locale.equals("en")){
					start_time = DateUtils.convertDate(start_time, "DMYHM","en",locale);
					sys_date_time_str = DateUtils.convertDate(sys_date_time_str, "DMYHM","en",locale);
				}
				java.util.Date ord_end_date_time = df.parse(start_time);             
				if((df.parse(end_time)).compareTo(df.parse(sys_date_time_str))< 0){
					start_time = sys_date_time_str;
				}
				else{
					start_time = df.format(ord_end_date_time);
				}	
				end_time	= bean.populateEndDate(df.format(df.parse(start_time)),"24","H");
			
				// whole of if condition added, so that the duration is passed correctly of mfr- prev order copy MFR issue : 26465
				if(mfr_yn.equals("Y")){
					end_time	= bean.populateEndDate(df.format(df.parse(start_time)),duration,"H");
				}

				/*if(!locale.equals("en")){
					start_time = DateUtils.convertDate(start_time, "DMYHM","en",locale);
					end_time = DateUtils.convertDate(end_time, "DMYHM","en",locale);
				} */
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	orderSetValues = bean.getOrderSetValues();
	if(orderSetValues.size() > 0){
		start_date = bean.getSysdate();
		timeFrame			= (String)orderSetValues.get(7);
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(Integer.parseInt((String)orderSetValues.get(i+7)) > Integer.parseInt(timeFrame)){
				timeFrame	= (String)orderSetValues.get(i+7);
			}
		}
		start_time	= bean.populateEndDate(start_date,timeFrame,"H");
		start_date = start_time;
	}
	if(start_date.equals("")) { 
		start_date = start_time;
	} 
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formIVPrescriptionAdminDetail" id="formIVPrescriptionAdminDetail">
			<input type="hidden" name="MFR_start_time" id="MFR_start_time" value='<%=start_time%>'>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<td class="COLUMNHEADER" colspan="8"><font style="font-size:9"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></td>
				<tr>
					<td width='10%' class='label'><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td width='20%' class='label'>
					<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text" class="number" size="5" maxlength="9" name="INFUSION_VALUE" id="INFUSION_VALUE" value='<%=infusion_rate%>'  onBlur="CheckNum(this);setInfusion_uom();calVolumeInfuseOver();showAdminRate();" onKeyPress="return allowValidNumber(this,event,6,2);" <%=disable_for_mfr%>>
					<%}
					else{  %>
						<input type="text" class="number" size="5" maxlength="9" name="INFUSION_VALUE" id="INFUSION_VALUE" value='<%=infusion_rate%>'  onBlur="CheckNum(this);setInfusion_uom();setInfuseOverValue();showAdminRate();" onKeyPress="return allowValidNumber(this,event,6,2);" <%=disable_for_mfr%>>
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
						<label align="left" class='label' id='infusion_uom_display'><b>&nbsp;<%=QTY_UNIT%></b></label>
						
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<select name="lstInfusionRateDurnUnit" id="lstInfusionRateDurnUnit" onChange="ChangeInfuseOverTime(this);calVolumeInfuseOver()" <%=disable_for_mfr%>>
					<%}
					else{  %>
						<select name="lstInfusionRateDurnUnit" id="lstInfusionRateDurnUnit" onChange="ChangeInfuseOverTime(this);setInfuseOverValue()" <%=disable_for_mfr%>>
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
							<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
							<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						</select>

					</td>
					<td class="label" width='10%' id="tdOrderQty_leg" style="<%=iv_calc_infuse_display%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/>
					</td>
					<td class="label" width='15%' id="tdOrd_qty" style="<%=iv_calc_infuse_display%>">
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input disabled type='text' class="NUMBER" name='order_qty' id='order_qty' size="1" maxlength="3" disabled>&nbsp;<label id="ord_qty_uom" class="label" style="font-size:9px;" ></label>
					<%}
					else{  %>
						<input type='text' class="NUMBER" name='order_qty' id='order_qty' size="1" maxlength="3" onKeyPress="return allowValidNumber(this,event,2,0);" onchange="calcTotalVolume()">&nbsp;<label id="ord_qty_uom" class="label" style="font-size:9px;" ></label>
					<% } %>
						
					</td>
					<td width='8%' class='label'>
						<fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/> &nbsp;</label>
					</td>
					<td width='19%' class='label'>
					<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text" class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" value='<%=infuse_over_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="CheckNum(this);checkHr(INFUSION_PERIOD_VALUE,'H');calVolumeInfuseRate();showAdminRate();" <%=disable_for_mfr%>>
					<%}
					else{  %>
						<input type="text" class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" value='<%=infuse_over_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="CheckNum(this);checkHr(INFUSION_PERIOD_VALUE,'H');setInfuseRateValue();showAdminRate();" <%=disable_for_mfr%>>
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
						<b>:</b>
						<!-- Added for AAKH-CRF-0094 START -->
					<%if(param_volume_cal.equals("N")){ %>
					<input type="text" class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE_MIN" id="INFUSION_PERIOD_VALUE_MIN" value='<%=infuse_over_mi%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="CheckNum(this);checkHr(INFUSION_PERIOD_VALUE_MIN,'M');calVolumeInfuseRate();showAdminRate();" <%=disable_for_mfr%>>
					<%}
					else{  %>
						<input type="text" class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE_MIN" id="INFUSION_PERIOD_VALUE_MIN" value='<%=infuse_over_mi%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="CheckNum(this);checkHr(INFUSION_PERIOD_VALUE_MIN,'M');setInfuseRateValue();showAdminRate();" <%=disable_for_mfr%>>
					<% } %>
					<!-- Added for AAKH-CRF-0094 end -->
						
						<!--<label align="left"  width='5%'class='label' id="infusionOverUnit"><b><%=infusionOverUnit%></b></label>-->
						<label align="left"  width='5%'class='label' ><b><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></b></label>
						<label align="left"  width='5%'class='label' name="infusionOverStr" id="infusionOverStr"><%=disp_str%></label>
					</td>		
					<td width='8%' class='label' style='<%=iv_calc_duration_display%>'>
						<fmt:message key="Common.duration.label" bundle="${common_labels}"/><br><label style="visibility:visible" id=""><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->
					</td>
					<td width='10%' class='label' style='<%=iv_calc_duration_display%>'>
						<input type="text" class="number" size="1" maxlength="2" value='<%=duration%>' name="DURN_VALUE" onChange="CheckNum(this);chkDuration(this,'<%=mode%>');" onKeyPress="return allowValidNumber(this,event,3,0);" <%=disable_for_mfr%>>&nbsp;<b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>&nbsp; <!-- Onblur Changed to Onchange for SKR-SCF-1392 -->
					</td>
					<td width='*'class='label'>&nbsp;</td>
				</tr>
				<tr> 
					<td class='label'><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='label'>
					<input type="text" name="START_DATE" id="START_DATE" value='<%=start_time%>' <%=disabled%> <%=disable_for_mfr%> size="14" maxlength="16"  onblur="resetInfuse(this)" tabindex="-1">&nbsp;<IMG src="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('START_DATE',null,'hh:mm');document.formIVPrescriptionAdminDetail.START_DATE.focus();return false;"  <%=disable_for_mfr%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
					
					<td class='label'><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='label'>
					<input type="text" name="END_DATE" id="END_DATE" value='<%=end_time%>' <%=disabled%> <%=disable_for_mfr%> size="14" maxlength="12"  readonly>&nbsp; 
					</td>
					<td class='label' calspan='4'> 
						<A HREF onMouseOver="changeCursor(this);" onClick="adminRate();" style="visibility:hidden" id='adminrate'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/> </A>
					</td>
				</tr>
			</table>
		
			<input type="hidden" name="BEAN_ID" id="BEAN_ID" value="<%= bean_id %>">
			<input type="hidden" name="BEAN_NAME" id="BEAN_NAME" value="<%= bean_name %>">
			<INPUT TYPE="hidden" name="LOCN_TYPE" id="LOCN_TYPE" VALUE="<%= locn_type %>">
			<INPUT TYPE="hidden" name="LOCN_CODE" id="LOCN_CODE" VALUE="<%= locn_code %>">
			<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM" VALUE='<%=infusion_period_uom%>' >
			<INPUT TYPE="hidden" name="DURN_UNIT" id="DURN_UNIT" VALUE='H'>
			<INPUT TYPE="hidden" name="INFUSION_UOM" id="INFUSION_UOM" VALUE=<%=infusion_period_uom%>>
			<INPUT TYPE="hidden" name="FREQUENCY" id="FREQUENCY" VALUE = '<%=freq_code%>'>
			<input type="hidden" name="freq_desc" id="freq_desc" value='<%=freq_desc%>' >
			<input type="hidden" name="sys_date" id="sys_date" value="<%=start_date%>">
			<input type="hidden" name="drug_codes" id="drug_codes" value="<%= bean.getDrugCodes() %>">
			<input type="hidden" name="INFUSION_UOM_DISPLAY" id="INFUSION_UOM_DISPLAY" value="">
			<INPUT TYPE="hidden" name="PRACT_ID" id="PRACT_ID" VALUE="<%= pract_id %>">
			<input type="hidden" name="EQVL_UOM_CODE" id="EQVL_UOM_CODE" value="">
			<input type="hidden" name="INFUSION_PER_UNIT" id="INFUSION_PER_UNIT" value="H">
			<input type="hidden" name="order_type_flag" id="order_type_flag" value="<%=order_type_flag%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="prev_order" id="prev_order" value="<%=prev_order%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="infusion_over_insert_value" id="infusion_over_insert_value" value="<%=infuse_over%>">
			<input type="hidden" name="errorFound" id="errorFound" value="false">
			<input type="hidden" name="MFR_YN_Flag" id="MFR_YN_Flag" value='<%=mfr_yn%>'>
			<input type="hidden" name="INFUSION_VALUE_WITHOUT_ROUND" id="INFUSION_VALUE_WITHOUT_ROUND" value=''><!--added for IN61608-->
			<input type="hidden" name="previous" id="previous" value='<%=prev_order%>'><!-- new hidden var - prev order copy MFR issue : 26465 -->
			<input type="hidden" name="iv_calc_infuse_by" id="iv_calc_infuse_by" value="<%=iv_calc_infuse_by%>"> <!-- SKR-CRF-0035 -->
<% 
			putObjectInBean(bean_id,bean,request); 
			putObjectInBean(or_bean_id,ORbean,request);
%>

		</FORM>
	</body>
	<script>
		var str = getHrsMinStr(document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,document.formIVPrescriptionAdminDetail.lstInfusionRateDurnUnit.value);
		//document.formIVPrescriptionAdminDetail.all.infusionOverStr.innerHTML	= str;
	</script>
<%
	if((order_type_flag.equals("Existing") || mode.equals("amend")) && !mfr_yn.equals("Y")){
%>
		<script>
			chkDuration(document.formIVPrescriptionAdminDetail.DURN_VALUE,'1');
			showAdminRate();
		</script>
<%
	}
%>
</HTML>

