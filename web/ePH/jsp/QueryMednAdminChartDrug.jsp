<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,java.text.SimpleDateFormat,java.util.Date,ePH.QueryMednAdminChartBean, ePH.MedicationAdministrationBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %><%-- Added SimpleDateFormat,Date for ML-BRU-SCF-1177--%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head> 
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
	    String locale			= (String)session.getAttribute("LOCALE"); 
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
		<!-- import the calendar script -->
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript"> // Added for PMG2014-CRF-0026 [IN:052701]
			function initScroll() {
				var rightDivSize = document.body.offsetWidth-451;
				var leftDiv = document.getElementById('table_container_left');
				var rightDiv = document.getElementById('table_container_right');
				if(rightDiv!=undefined && leftDiv!=undefined && rightDivSize!=-451){//Added new condition for Bru-HIMS-CRF-081 [IN:029947]
					rightDiv.style.width=rightDivSize+'px';
					rightDiv.onscroll = function() {
						leftDiv.scrollTop = this.scrollTop-10;
						leftDiv.scrollTop = this.scrollTop;
					};
				}
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String relevantencounterid	=	request.getParameter("relevantencounter");
	String admindate			=	request.getParameter("admindate")==null?"":request.getParameter("admindate");
	String mode				=	request.getParameter("mode")==null?"":request.getParameter("mode");
	String date_from			=	request.getParameter("date_from")==null?"":request.getParameter("date_from");
	String date_to				=	request.getParameter("date_to")==null?"":request.getParameter("date_to");
	String fromtime				=	"";
	String past_date			=   request.getParameter("past_date")==null?"":request.getParameter("past_date");
	String future_date			=   request.getParameter("future_date")==null?"":request.getParameter("future_date");
	String called_from			=   request.getParameter("called_from")==null?"":request.getParameter("called_from");

	boolean displayed			=	false;
	String t_date="";
	String f_date="";
	String sliding_scale_yn="";
	String sliding_scale_range_unit="";
	String sliding_scale_range_uom="";
	String sliding_scale_adm_unit="";
	String sliding_scale_adm_uom="";
	String sliding_scale="";
	String dishdchk="";//Added for ML-BRU-SCF-1177
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String demostring	="\\\'\'";

	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";
	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject(bean_id,bean_name,request );
	String bean_id1				= "MedicationAdministrationBean";
	String bean_name1			= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject(bean_id1,bean_name1,request );	
	admin_bean.setLanguageId(locale);
	String facility_id					= (String) session.getValue("facility_id");
	String medn_admin_reqd_yn=admin_bean.fetchParamFacilityValues(facility_id);//Added for ML-BRU-SCF-1177--start
	String dishdflg = "";
	String dishdflg1=request.getParameter("dishdflg")==null?"":request.getParameter("dishdflg");
//	String orderby = request.getParameter("ordval")==null?"sch":request.getParameter("ordval"); //Commented for INT-CRF-BRU-PH-001 
	String orderby = request.getParameter("ordval")==null?"status":request.getParameter("ordval"); //Added for INT-CRF-BRU-PH-001
	if(dishdflg1==null || dishdflg1.trim().length()==0)
		dishdflg=admin_bean.getMarDispHeldDiscOrdersYN();
	else
		dishdflg=request.getParameter("dishdflg")==null?"":request.getParameter("dishdflg");

	Date date1 = null;
	Date date2 = null;
	Date date3 = null;
	String chkflg="";
	String heightpx="390px";
	if(called_from.equals("MEDADMIN"))
		heightpx = "450px";
	String scroll	=	"scroll";
	String dosage_seq_no = "";
	String sch_date_time ="";
	boolean	flag  = false;
	if(dishdflg.equals("Y"))//Added for ML-BRU-SCF-1177--end
		dishdchk = "checked";
%>
	<body offsetleft=0 onKeyDown="lockKey()"  onKeyDown = 'lockKey()'  onLoad="initScroll();" onresize="initScroll();" >
		<form name="AdminChart" id="AdminChart">
<%
			HashMap sch_dates		=	bean.loadSchDates(relevantencounterid);
			ArrayList all_dates		=	new ArrayList();
			String dflt_sch_date	=	"";
			//String curr_record_date	=	"";
			int t1;
			if(date_from!=null && !date_from.equals("") && date_to!=null && !date_to.equals("")) {
				all_dates			=	bean.getDates(date_from,date_to);
				dflt_sch_date		=	"";
			}
			else if	(!admindate.equals("")){
				all_dates.add(admindate);
				dflt_sch_date	=	admindate;
			}
			ArrayList past_records		=	(ArrayList) sch_dates.get("past_records");
			ArrayList future_records	=	(ArrayList) sch_dates.get("future_records");
			t1=past_records.size();
			if(t1>0){
				if(t1 >= 3){
					f_date=(String)past_records.get(t1-3); 
				}
				else if(t1 == 2){
					f_date=(String)past_records.get(t1-2);
				}
				else{
					f_date=(String)past_records.get(t1-1);
				}
				t_date=(String)past_records.get(t1-1);
			}
			if(admindate.equals("") && all_dates.size()==0){
				for(int i=0; i<past_records.size(); i++) {
					all_dates.add((String)past_records.get(i));
				}
				for(int i=0; i<future_records.size(); i++) {
					all_dates.add((String)future_records.get(i));
				}
			}
			//if(!date_from.equals("") && !date_to.equals("") && ((!past_records.contains(date_from) && !future_records.contains(date_from)) || (!past_records.contains(date_to) && !future_records.contains(date_to))) ) {
%>
				<script>
					//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); 
					//top.parent.window.close();
				</script>
<% 
				//return;
			//}
			ArrayList al=new ArrayList();
			ArrayList al_times=new ArrayList();
			ArrayList al_drug_desc=new ArrayList();
			//ArrayList al_strength=new ArrayList();
			ArrayList al_qty=new ArrayList();
			HashMap drug_desc_qty_hm=new HashMap();
			String o_date="";
			//String times="";
			String drug_desc="";
			String drug_strength="";
			//String qty="";
			String te_qty="";
			//String flag="";
			String drug_code="";
			String order_id="";
			String admin_recorded_yn="";
			String admin_recorded_date_time="";
			String administered_yn="";
			String admin_not_recorded_flag="n";
			String admin_due_flag="n";
			String adr_detail_flag="n";
			String adr_remarks="";
			String adr_recorded_date_time="";
			String adr_recorded_by="";
			String adr_reson_code="";
			String dis="";
			String pract_type="";
			String mfr_yn="";
			String disc_date_time="";//Added for ML-BRU-SCF-1177--start
			String hd_date_time="";
			String can_date_time="";
			String disc_pract="";
			String hd_pract="";
			String pract_name="";//Added for ML-BRU-SCF-1177--end
			String iv_prep_yn="";
			String iv_prep_flag="";
			String order_line_num1="";
			String order_line_status=""; 
			String displayStyle		="";
			String drug_class="";
			String displayStyle_drug_class = "";
			String pat_brought_medn_yn = "N";
			String extMedGif = "";
			String verbalOrder="";
			HashMap hm_qty=null;
			int t=0, maxFreqCount=0, tdwidth=0, tableWidth=100;
			for(int j=0; j<all_dates.size(); j++) { 
				admindate		=	(String)all_dates.get(j);
				if (fromtime.equals("")){
					admindate=admindate+" 00:00";
				}
				else{
					admindate=admindate+" "+fromtime;
				}
			}
//Table display starts from here
			if(!displayed) { 
				displayed	=	true;
%>
				<INPUT TYPE="hidden" name="locale" id="locale"  value="<%=locale%>"> 
				<input type="hidden" name="date_from" id="date_from" value="<%=date_from%>">
				<input type="hidden" name="date_to" id="date_to" value="<%=date_to%>">
				<input type="hidden" name="date_to" id="date_to" value="<%=past_date%>">
				<input type="hidden" name="date_to" id="date_to" value="<%=future_date%>">
				<input type="hidden" name="min_fm_date" id="min_fm_date" value="<%=past_records.size()>0?past_records.get(0):""%>">
				<input type="hidden" name="relevantencounter" id="relevantencounter" value="<%=relevantencounterid%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">			
				<INPUT TYPE="hidden" name="patient_class" id="patient_class"  value="<%=patient_class%>"> 
				<iNPUT TYPE="hidden" name="dishdflg" id="dishdflg"  value="<%=dishdflg%>"> <!--Added for ML-BRU-SCF-1177 -->
<% 
				if(future_records.size() >=1) { 
%>
					<input type="hidden" name="max_to_date" id="max_to_date" value="<%=(String)future_records.get(future_records.size()-1)%>">
<%
				}	
				else{	
%>
					<input type="hidden" name="max_to_date" id="max_to_date" value="<%=(String)past_records.get(past_records.size()-1)%>">
<%
				}	
%>
				<div id='table_container_top' style='position:relative;float:top;'><!-- Below table for displaying future/past schedule dates-->
					<table cellpadding="0" cellspacing="0"  border="0"  width='100%'><!--Modified for ML-BRU-SCF-1177     width="1200px"   -->
						<tr>
							<td align="right" class="data"><fmt:message key="ePH.PastDose.label" bundle="${ph_labels}"/></td>
							<td align="left">&nbsp;&nbsp;<select name="past_dose" id="past_dose" onChange="reloadDosage(this)">
								<option value="">&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;</option>
<% 		
								for (int i=0; i<past_records.size(); i++) { 	
									if(dflt_sch_date.trim().equals( ((String)past_records.get(i)).trim() )) {
%>
										<option  value="<%=com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)%> "selected> <%=com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)%> </option>
<%
									} 
									else {
%>
										<option value="<%=com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)%>"> <%=com.ehis.util.DateUtils.convertDate((String)past_records.get(i),"DMY","en",locale)%></option>
<%			
									}	  
								}		
%>
								</select>
							</td>
							<td align="right" class="data"><fmt:message key="ePH.FutureDose.label" bundle="${ph_labels}"/></td>
							<td align="left">&nbsp;&nbsp;<select name="future_dose" id="future_dose" onChange="reloadDosage(this)">
								<option value="">&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;</option>
<% 		
								for (int i=0; i<future_records.size(); i++) { 	
									if(dflt_sch_date.trim().equals( ((String)future_records.get(i)).trim() )) {
%>
										<option value="<%=com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)%>"selected> <%=com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)%></option>
<%		
									}
									else{	
%>
										<option value="<%=com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)%>"><%=com.ehis.util.DateUtils.convertDate((String)future_records.get(i),"DMY","en",locale)%></option>
<%	
									}	
								}		
%>
								</select>
							</td>
							<td align="right" class="data"><fmt:message key="ePH.DisplayHeld/DiscontinuedOrders.label" bundle="${ph_labels}"/></td><!--Added for ML-BRU-SCF-1177 start-->
							<td align="left"><input type="checkbox" id="hold_discontinue_yn" name="hold_discontinue_yn" id="hold_discontinue_yn" size="2" <%=dishdchk%>></td><!--Added for ML-BRU-SCF-1177 -->
							<td align="right" class="data"><fmt:message key="ePH.displayOrderby.label" bundle="${ph_labels}"/></td>
							<td><select name="orderby" id="orderby" id="orderby">
<%
							if(orderby==null || orderby.trim().length()==0|| orderby.equalsIgnoreCase("sch")){ 
%>
								<option value="sch" selected="selected"><fmt:message key="ePH.Scheduled.label" bundle="${ph_labels}"/></option>
								<option value="status"><fmt:message key="Common.status.label" bundle="${common_labels}"/></option>
<%
							}
							else{
%>
								<option value="sch"><fmt:message key="ePH.Scheduled.label" bundle="${ph_labels}"/></option>
								<option value="status" selected="selected"><fmt:message key="Common.status.label" bundle="${common_labels}"/></option>
<%
							}
%>
							</select></td><!--Added for ML-BRU-SCF-1177 end-->
							<td align="right" class="label" nowrap ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
<%
							if (date_from.equals("") && past_date.equals(""))
								date_from=f_date;
							else if(!date_from.equals("") && !past_date.equals(""))
								date_from=past_date;
							else if(!date_from.equals("") && !future_date.equals(""))
								date_from=future_date;
								
							if(date_to.equals("")&& past_date.equals(""))
								date_to=t_date; 
							else if(!date_to.equals("") && !past_date.equals(""))
							   date_to=past_date;
							else if(!date_to.equals("") && !future_date.equals(""))
								date_to=future_date;
%> 
							<td align="left" >&nbsp;&nbsp;
								<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="CheckDate(this);"   value="<%=com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale)%>">
								<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_from');document.AdminChart.order_date_from.focus();return false;" > 
							</td> 
							<td align="right" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
							<td align="left" >&nbsp;&nbsp;
								<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="CheckDate(this);"  value="<%=com.ehis.util.DateUtils.convertDate(date_to,"DMY","en",locale)%>">
								<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_to');document.AdminChart.order_date_to.focus();return false;" > 
							</td> 
							<td class="data" align="right">
								<input type="button" class="button" value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' onClick="reloadResult(order_date_from,order_date_to)">
							</td>
						</tr>
					</table>
				</div>
				<input type="hidden" name="admindate" id="admindate" value="">	
				<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">	
<%	
			}
			al=(ArrayList)bean.getRecord(past_date,future_date,date_from,date_to,relevantencounterid,dishdflg,orderby);//Added dishdflg,orderby for ML-BRU-SCF-1177
			if(al.size() == 0){
%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); 
				</script>
<% 
				return;
			}
%>
			<div id='table_container_left' style='overflow:hidden;width:450px;height:<%=heightpx%>;position:relative;float:left;'>
				<table cellpadding="0" cellspacing="0"  border="1"   id="drugTable" name="drugTable" id="drugTable" ><!--Modified for ML-BRU-SCF-1177-->
					<tr style='position:relative;border-collapse: collapse;' style='top:expression(this.offsetParent.scrollTop-2)'>
						<td align="center" class="COLUMNHEADER" width="3px" style="border-collapse: collapse;">&nbsp;</td>
						<td align="center"  class="COLUMNHEADER" width="447px" style="border-collapse: collapse;"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					</tr>
<%
				HashMap record1=null;
				String altDrugDesc = "";//BRU-CRF-399.1
				String split_dose_yn = "";//ML-MMOH-SCF-1529
				String dosage = "";//ML-MMOH-SCF-1529
				for(int i=0;i<al.size();i++) { 
					record1=(HashMap)al.get(i);
					o_date	= com.ehis.util.DateUtils.convertDate((String)record1.get("dates"),"DMY","en",locale); 
%>
					<tr style="border-collapse: collapse;">
						<td class='COLUMNHEADER' align="left" colspan="2" style='height:29px;"border-collapse: collapse;'><fmt:message key="ePH.AdministrationDetailfor.label" bundle="${ph_labels}"/> <%=o_date%></td><!-- Pixel modified for SKR-SCF-1179-->
					</tr>
<%
					al_drug_desc=(ArrayList)record1.get("desc_qty");		
					al_times=(ArrayList)record1.get("times");
					if(maxFreqCount<al_times.size())
						maxFreqCount=al_times.size(); 
					for(int x=0;x<al_drug_desc.size();x++){
						drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
						drug_code=(String)drug_desc_qty_hm.get("drug_code");
						drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
						order_id=(String)drug_desc_qty_hm.get("order_id");
						order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
						order_line_status=(String)drug_desc_qty_hm.get("order_line_status");
						drug_class=(String)drug_desc_qty_hm.get("drug_class");				
						pract_type=(String)drug_desc_qty_hm.get("pract_type");						
						pract_name=(String)drug_desc_qty_hm.get("pract_name")==null?"":(String)drug_desc_qty_hm.get("pract_name");
						disc_pract = disc_date_time + " " +pract_name;
						hd_pract = hd_date_time + " " +pract_name;//Added for ML-BRU-SCF-1177--end
						iv_prep_yn=(String)bean.checkIVOrder(order_id);
						altDrugDesc = "";//BRU-CRF-399.1 - start
						if(iv_prep_yn.equals("") ){
							altDrugDesc = bean.getAltDrugDesc(order_id,order_line_num1);
						}
						//BRU-CRF-399.1 - start

						if(!iv_prep_yn.equals("")){
							if(order_line_num1.equals("1"))
								 iv_prep_flag="Y";
							else 
								 iv_prep_flag="N";
						}
						else
							iv_prep_flag="";
						
						if(order_line_status.equals("DC"))
							displayStyle = "BACKGROUND-COLOR:red;";
						else if(order_line_status.equals("HD")||order_line_status.equals("HC"))
							displayStyle = "BACKGROUND-COLOR:yellow;";						
						else
							displayStyle = "";

						if(pract_type.equals("NS")){
							//displayStyle = "BACKGROUND-COLOR:#00FF00;";
							verbalOrder="<b>V</b>";
						}
						else{
							verbalOrder="&nbsp";
						}
						/*	narcotic  -----N
							controlled-----C
							others    -----""  	*/

						if(iv_prep_flag.equals("")){
							if(drug_class.equals("C"))
								displayStyle_drug_class = "BACKGROUND-COLOR:#CCFFCC;";
							else if(drug_class.equals("N"))
								displayStyle_drug_class = "BACKGROUND-COLOR:#66FFFF";
							else if(!drug_class.equals(""))
								displayStyle_drug_class = "BACKGROUND-COLOR:white";
						}
%>
						<tr style='height:19px;'>
						<%//Modified for ML-BRU-SCF-1177--start
						if(disc_date_time!= null && disc_date_time.trim().length()>0){ 
%>
							<td align='center'class="white" onMouseOver = "showToolTipLockStatus(this,'<%=disc_pract%>')" style="<%=displayStyle%>"><%=verbalOrder%></td>
<%  					}	
						else if(hd_date_time!=null && hd_date_time.trim().length()>0)	{
%>
							<td align='center'class="white" onMouseOver = "showToolTipLockStatus(this,'<%=hd_pract%>')" style="<%=displayStyle%>"><%=verbalOrder%></td>
<%                      }
						else{
%>		
							<td align='center'class="white" style="<%=displayStyle%>"><%=verbalOrder%></td>
<%						}	//Modified for ML-BRU-SCF-1177--end			
						if(iv_prep_yn.equals("6")){
%>
								<td  align='left' height ="29px" nowrap style="background-color:#E4CAFF;color:black"><font size='1'><%=drug_desc%></font></td> <!-- Pixel modified for SKR-SCF-1179-->
<%
							}
							else if(iv_prep_flag.equals("Y")){ 
%>
								<td  align='left' nowrap height ="29px"  style="background-color:#FFBFBF;color:black"><font size='1'><%=drug_desc%></font></td><!-- height added for ml-bru-scf-1816-->
<%
							}
							else if(iv_prep_flag.equals("N")){ 
%>
								<td  align='left' height ="29px" nowrap style="background-color:#FFDFDF;color:black"><font size='1'><%=drug_desc%></font></td><!-- Pixel modified for SKR-SCF-1179-->
<%
							}
							else{
%>  
								<td  align='left' nowrap  height ="29px" style=" <%=displayStyle_drug_class%>" ><font size='1' ><%=drug_desc%></font><br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=altDrugDesc%> </label></td> 
<% 
							}
						}
					}
%>
					</table>
				</div>
<%
				if(called_from.equals("MEDADMIN"))
					heightpx = "470px";
				else
					heightpx="410px";
					//if(maxFreqCount>8)
						//tableWidth = (maxFreqCount+1) * 7;
					//if(tableWidth<100)
					//	tableWidth = 100;
					//tdwidth =8;// tableWidth/(maxFreqCount+1);
%>
				<div id='table_container_right' style='height:<%=heightpx%>;position:relative;float:left;' ><!--  Modified for Bru-HIMS-CRF-081 -->
					<table  border="1" cellpadding="0" cellspacing="0" align="left">
						<tr style='position:relative;border-collapse: collapse;' style='top:expression(this.offsetParent.scrollTop-2)'>
							<td align="center" class="COLUMNHEADERCENTER" colspan='<%=maxFreqCount+1%>'>&nbsp;</td>	
						</tr>
<%
						for(int i=0;i<al.size();i++) { 
							record1=(HashMap)al.get(i);
							o_date	= com.ehis.util.DateUtils.convertDate((String)record1.get("dates"),"DMY","en",locale); 
							al_times=(ArrayList)record1.get("times");
							t=al_times.size(); 
							//tableWidth = 100;
							//if(maxFreqCount>9)
								//tableWidth = (maxFreqCount * 10)+10;
%>
							<tr > 
								<td align="center"  class="COLUMNHEADER" style="border-collapse: collapse;" style='height:14.5px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <!-- style='height:14.5px;' Added for SKR-SCF-1201 -->
								<td align="center" class="COLUMNHEADER" colspan="<%=maxFreqCount%>" style='height:14.5px;'><fmt:message key="ePH.Timings/Dosage.label" bundle="${ph_labels}"/></td> <!-- style='height:14.5px;' Added for SKR-SCF-1201 -->
							</tr>
							<tr height ="29px"> <!-- Pixel added for SKR-SCF-1179-->
								<td  align="center" class='TIMING'   >&nbsp;</td>
<% 
							for(int p=0;p<maxFreqCount;p++){
								if(p<t){
%>
									<td  align="center" class='TIMING'   ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=al_times.get(p)%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<% 
								}
								else{
%>
									<td  align="center" class='TIMING' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<% 
								}
							}
%>
							</tr>
<%  
										al_drug_desc=(ArrayList)record1.get("desc_qty");		
										for(int x=0;x<al_drug_desc.size();x++){
											drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
											drug_code=(String)drug_desc_qty_hm.get("drug_code");
											drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
											order_id=(String)drug_desc_qty_hm.get("order_id");
											order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
											order_line_status=(String)drug_desc_qty_hm.get("order_line_status");
											drug_class=(String)drug_desc_qty_hm.get("drug_class");				
											pract_type=(String)drug_desc_qty_hm.get("pract_type");						
											mfr_yn=(String)drug_desc_qty_hm.get("mfr_yn")==null?"N":(String)drug_desc_qty_hm.get("mfr_yn");						
											disc_date_time=(String)drug_desc_qty_hm.get("disc_date_time")==null?"":(String)drug_desc_qty_hm.get("disc_date_time");//Added for ML-BRU-SCF-1177--start
											hd_date_time = (String)drug_desc_qty_hm.get("hold_date_time")==null?"":(String)drug_desc_qty_hm.get("hold_date_time");
											can_date_time = (String)drug_desc_qty_hm.get("can_date_time")==null?"":(String)drug_desc_qty_hm.get("can_date_time");
											drug_strength=(String)drug_desc_qty_hm.get("drug_strength")==null?"":(String)drug_desc_qty_hm.get("drug_strength"); 

											split_dose_yn = (String)drug_desc_qty_hm.get("split_dose_yn")==null?"":(String)drug_desc_qty_hm.get("split_dose_yn"); //ML-MMOH-SCF-1529
											dosage = (String)drug_desc_qty_hm.get("dosage")==null?"":(String)drug_desc_qty_hm.get("dosage"); //ML-MMOH-SCF-1529
%>
											<tr style='height:19px;'>
												<td class="white" align='center' height="29px" nowrap style=" background-color:white" ><font size='1'><%=bean.getUomDisplay(facility_id,drug_strength) %>&nbsp;</font></td><!--height added for ml-bru-scf-1816-->
<%
										al_qty=(ArrayList)drug_desc_qty_hm.get("qty");
										for(int k=0;k<maxFreqCount;k++){ 
											if(k<al_qty.size()){
												sliding_scale="";
												flag = false;
												hm_qty=(HashMap)al_qty.get(k);
												order_id=(String)hm_qty.get("order_id");
												sch_date_time = (String)hm_qty.get("sch_date_time1");//Added for ML-BRU-SCF-1177
												admin_recorded_yn=(String)hm_qty.get("admin_recorded_yn");
												admin_recorded_date_time=(String)hm_qty.get("admin_recorded_date_time");
												administered_yn=(String)hm_qty.get("administered_yn");
												//admin_date_time=(String)hm_qty.get("admin_date_time");
												te_qty=(String)hm_qty.get("f_qty")==null?"":(String)hm_qty.get("f_qty");
												if(!te_qty.equals("")){
													if(Float.parseFloat(te_qty)<1.0)
														te_qty = "0"+te_qty;
													if(te_qty.equals("00") ){ //if condition added for ML-MMOH-SCF-1529
														if(!split_dose_yn.equals("Y") && !dosage.equals("")) //added for ML-MMOH-SCF-1674
															te_qty = Float.parseFloat(dosage)+"";
														else{
															if(split_dose_yn.equals("Y")){
															te_qty = bean.getSplitDosage(order_id,order_line_num1,sch_date_time.split(" ")[1]);
															te_qty = Float.parseFloat(te_qty)+"";
															}
														}
													}
												}
												admin_not_recorded_flag=(String)hm_qty.get("admin_not_recorded_flag");
												admin_due_flag=(String)hm_qty.get("admin_due_flag");
												adr_detail_flag=(String)hm_qty.get("adr_detail_flag");
												adr_remarks=(String)hm_qty.get("adr_remarks")==null?"":(String)hm_qty.get("adr_remarks");
												adr_recorded_date_time=(String)hm_qty.get("adr_recorded_date_time");
												if(!locale.equals("en")){ //added for IN25266 --04/01/2011-- priya
													adr_recorded_date_time =  DateUtils.convertDate(adr_recorded_date_time, "DMYHM","en",locale);
												}
												adr_recorded_by=(String)hm_qty.get("adr_recorded_by");
												adr_reson_code  =   (String)hm_qty.get("adr_reson_code");
												adr_reson_code  =   adr_reson_code==null?"":adr_reson_code;
												adr_reson_code	=	admin_bean.getReasonDesc("M",adr_reson_code);
												adr_reson_code  =   adr_reson_code==null?"":adr_reson_code;
												sliding_scale_yn=(String)hm_qty.get("sliding_scale_yn")==null?"N":(String)hm_qty.get("sliding_scale_yn");									
												dosage_seq_no= hm_qty.get("DOSAGE_SEQ_NO")==null?"":(String)hm_qty.get("DOSAGE_SEQ_NO");
												sliding_scale_range_unit=(String)hm_qty.get("sliding_scale_range_unit")==null?"":(String)hm_qty.get("sliding_scale_range_unit");
												sliding_scale_range_uom=(String)hm_qty.get("sliding_scale_range_uom")==null?"":(String)hm_qty.get("sliding_scale_range_uom");
												sliding_scale_adm_unit=(String)hm_qty.get("sliding_scale_adm_unit")==null?"":(String)hm_qty.get("sliding_scale_adm_unit");
												sliding_scale_adm_uom=(String)hm_qty.get("sliding_scale_adm_uom")==null?"":(String)hm_qty.get("sliding_scale_adm_uom");
												pat_brought_medn_yn=(String)hm_qty.get("medn_brought_by_patient_yn")==null?"N":(String)hm_qty.get("medn_brought_by_patient_yn");
												//pract_type=(String)hm_qty.get("pract_type");
												dis="";	
												SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");//Added for ML-BRU-SCF-1177--start
												if(sch_date_time!=null && sch_date_time.trim().length()>0){
													date1 = sdf.parse(sch_date_time);
												}
												if(disc_date_time!=null && disc_date_time.trim().length()>0){
													date2 = sdf.parse(disc_date_time);
												}
												if(hd_date_time!=null && hd_date_time.trim().length()>0){
													date3 = sdf.parse(hd_date_time);
												}//Added for ML-BRU-SCF-1177--end
												
												
												if(pat_brought_medn_yn.equals("Y")){
													extMedGif="<img src=\"../../ePH/images/ExternalMedicine.gif\" title=\""+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ExternalMedicine.label", "ph_labels")+"\"> ";
												}
												else{
													extMedGif="";
												}
												if(sliding_scale_yn.equals("Y")){
													sliding_scale=sliding_scale_range_unit+" "+sliding_scale_range_uom+" /"+sliding_scale_adm_unit+" "+sliding_scale_adm_uom;
													if(!te_qty.equals(""))
														te_qty=sliding_scale;
												}
												if(te_qty.equals("")){ 
%>
													<td  align='center' style=" background-color:white"  ><font size='1' >&nbsp;</font></td>
<%
												}
												else if(adr_detail_flag.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														if(te_qty.equals("")){ //added for SCF-7863
															te_qty="&nbsp;";
														}
													}
													dis=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdministrationDetails.label", "ph_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reson_code+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+" : "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordedDateTime.label", "ph_labels")+" : "+adr_recorded_date_time+"\n"+   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+" : "+adr_recorded_by+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.reason.label","common_labels")+" : "+adr_reson_code; 
													if(!mfr_yn.equals("Y"))	{
%>									
														<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue"   onClick="loadAdminDetails('<%=relevantencounterid%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=order_id%>','<%=o_date%>','<%=bean.getFacilityId()%>','<%=al_times.get(k)%>','Y',this,'<%=te_qty%>','<%=iv_prep_yn%>','<%=drug_strength%>','<%=order_line_num1%>','<%=dosage_seq_no%>')"><font size='1' ><%=extMedGif%><%=te_qty%><img src="../../ePH/images/stop.gif" title="<%=dis%>"></font><!-- order_line_num1 newly added for inc 30030-->
														</td>
<%
													}
													else{
%>
														<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue"   onClick="openMFRDetails('1','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=drug_code%>','','MednAdminChart','<%=order_id%>')"><font size='1' ><%=te_qty%>(<fmt:message key="ePH.MFR.label" bundle="${ph_labels}"/>)<img src="../../ePH/images/stop.gif" title="<%=dis%>"></font></td>
<%
													}
												}
												else if(admin_recorded_yn.equals("Y")){
													if(administered_yn.equals("Y")){
														if(!mfr_yn.equals("Y")){
%>
															<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue"   onClick="loadAdminDetails('<%=relevantencounterid%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=order_id%>','<%=o_date%>','<%=bean.getFacilityId()%>','<%=al_times.get(k)%>','Y',this,'<%=te_qty%>','<%=iv_prep_yn%>','<%=drug_strength%>','<%=order_line_num1%>','<%=dosage_seq_no%>')" ><font size='1' ><%=extMedGif%><%=te_qty%></font><!-- order_line_num1 newly added for inc 30030-->
															</td>
<%
														}
														else{
%>
															<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue"   onClick="openMFRDetails('1','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=drug_code%>','','MednAdminChart','<%=order_id%>')" ><font size='1' ><%=te_qty%>(<fmt:message key="ePH.MFR.label" bundle="${ph_labels}"/>)</font>
															</td>
<%
														}
													}
													else{
														if(!mfr_yn.equals("Y")){
%>
															<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue"   onClick="loadAdminDetails('<%=relevantencounterid%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=order_id%>','<%=o_date%>','<%=bean.getFacilityId()%>','<%=al_times.get(k)%>','N',this,'<%=te_qty%>','<%=iv_prep_yn%>','<%=drug_strength%>','<%=order_line_num1%>','<%=dosage_seq_no%>')" ><font size='1' ><%=extMedGif%><%=te_qty%></font> <!-- order_line_num1 newly added for inc 30030-->
															</td>
<%
														}
														else{
%>
															<td  align='center' style="background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue"   onClick="openMFRDetails('1','<%=java.net.URLEncoder.encode(drug_desc)%>','<%=drug_code%>','','MednAdminChart','<%=order_id%>')" ><font size='1' ><%=te_qty%>(<fmt:message key="ePH.MFR.label" bundle="${ph_labels}"/>)</font>
															</td>
<%
														}
													}
												}								
												else if(sch_date_time!=null && sch_date_time.trim().length()>0 && disc_date_time!=null && disc_date_time.trim().length()>0 && date1.compareTo(date2)>=0){//Added for ML-BRU-SCF-1177--start
%>
													<td  align='center' style="background-color:white;color:#FF8000;border-right:15px solid red;color:black"  ><font size='1' ><%=extMedGif%><%=te_qty%></font></td>
<%								
												}
												else if(sch_date_time!=null && sch_date_time.trim().length()>0 && hd_date_time!=null && hd_date_time.trim().length()>0 && date1.compareTo(date3)>=0){
%>
													<td  align='center' style="background-color:white;color:#FF8000;border-right:15px solid yellow;color:black"  ><font size='1' ><%=extMedGif%><%=te_qty%></font></td>
<%
												}//Added for ML-BRU-SCF-1177--end moved after if(adr_detail_flag.equals("Y")) for ML-BRU-SCF-1177.1 [IN:049200]
												else if(admin_due_flag.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){										
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}
%>
													<td  align='center' style="background-color:white;color:silver;border-right:15px solid silver;color:black"  ><font size='1' ><%=extMedGif%><%=te_qty%></font></td>
<%
												}
												else if(admin_due_flag.equals("N") && !admin_recorded_yn.equals("Y") && !administered_yn.equals("Y")){ 
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}
%>
													<td  align='center' style="background-color:white;color:#FF8000;border-right:15px solid #FF8000;color:black"   ><font size='1' > <%=extMedGif%><%=te_qty%></font></td>
<%
												}
												else{
													if(sliding_scale_yn.equals("Y")){
														//sliding_scale=sliding_scale_range_uom+" /"+sliding_scale_adm_uom;
														te_qty="&nbsp;";
													}
													else if(mfr_yn.equals("Y")){
														te_qty=te_qty+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels")+")";
													}
%>
													<td  align='center' style=" background-color:white"  ><font size='1' ><%=extMedGif%><%=te_qty %></font></td>
<%
												}
											}
											else{
%>
												<td  align="center"  >&nbsp;</td>
<%
												}
											}
										}
%>
									</tr> 
<% 
					}
%>
				</TABLE>
		</form>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,admin_bean,request);
%>
	</body>
</html> 

