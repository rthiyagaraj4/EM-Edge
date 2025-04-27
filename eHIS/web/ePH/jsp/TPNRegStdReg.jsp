<!DOCTYPE html>

<%-- saved 0n 24/10/2005 --%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %><!-- ,webbeans.eCommon.*,java.sql.* added for ML-MMOL-CRF-1012 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Added for [IN:031523] Start -->
	</HEAD>
<%
	String facility_id  = (String) session.getValue("facility_id");
	String mode1=request.getParameter("mode");
	
	if(mode1 == null || mode1.equals("undefined")){mode1="";} 
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String patient_id							= request.getParameter("patient_id");
	String encounter_id							= request.getParameter("encounter_id");
	String location_type						= request.getParameter("location_type");
	String location_code						= request.getParameter("location_code");
	String pract_id								= request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String patient_class						= request.getParameter("act_patient_class");
	String height								= request.getParameter("height");
	String weight								= request.getParameter("weight");
	String start_date							= request.getParameter("start_date");
	String priority	 							= request.getParameter("priority");
	String bed_num								= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");//ML-MMOH-CRF-1089
	String bean_id								= "TPNStandardRegimenBean";
	String bean_name							= "ePH.TPNStandardRegimenBean";
	String disabled								="";
	String tooltip								="";
	String mode									=CommonRepository.getCommonKeyValue("MODE_INSERT");
    String uom=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ml.label","common_labels");

	String buildMAR_yn = "";
	String MAR_app_yn = "";
	String buildMAR_checked = "";
	String freq_option		= "";	//ML-MMOH-CRF-1126

		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
	String buildMAR_enable = "";
		 SRR20056-CRF-0649.1 */
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = MAR_app_yn;
	if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP"))
			buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 
		if(buildMAR_yn.equals("Y"))*/
		buildMAR_checked ="Checked";
	}
	
	TPNStandardRegimenBean bean		= (TPNStandardRegimenBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	//bean.clear();
	ArrayList freqlist							= bean.getFrequencies(); 
	String params								= request.getQueryString();
	String orderid="";

	String ph_bean_name						= "ePH.PrescriptionBean_1";
	String ph_bean_id						= "@PrescriptionBean_1"+patient_id+encounter_id;
	HashMap OrderDetails					=new HashMap();

	PrescriptionBean_1 phbean = (PrescriptionBean_1)getBeanObject(ph_bean_id,ph_bean_name,request);
	bean.setPresRemarks(phbean.getPresRemarks());
	
	int operation=1;
	
	if (orderid!=null && !orderid.equals(""))
		operation=2;//for update
	
	mode=operation+"";

	String Amd_OrderCatalogCode			="";
	String Amd_Start_Date_Time			="";
	String Amd_End_Date_Time			="";
	String Amd_Freq_Code				="";
	String Amd_Durn_Value				="";
	//String Amd_Durn_Type				="";
	String Amd_Infuse_Over				="";
	String Amd_Infuse_Over_Unit			="";
	String Amd_Isscheduled				="";
	String Amd_ShortName				="";
	String Amd_Freq_Nature				="";
	String Amd_Tot_Volume				="";
	String total_daily_fluid            ="";//added for ML-MMOH-CRF-1012
	String enteral_feeding              ="";//added for ML-MMOH-CRF-1012
	String Amd_Base_Unit				="";
	String DrugRemarksEntered			=	""; //added for [IN:039576]
	String print_ord_sht_rule_ind		=   "";//Added for Bru-HIMS-CRF-393_1.0 
	ArrayList schtime=new ArrayList();
	//added for ML-MMOH-CRF-1012 start
	Connection	con=null;
	boolean tpn_standard_non_standard=false;
	boolean tpn_std_reg_freq = false;//ML-MMOH-CRF-1126
	con	= ConnectionManager.getConnection(request);
	try{
		
		tpn_standard_non_standard = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STAND_NON_STAND_LABEL");
		tpn_std_reg_freq          = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ASSESMENT_REQ_YN");
		//bean.setIssite(site);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		con.close();
	}
//Added for ML-MMOH-CRF-1012
	if (operation==2){
		//Get values for the given order id
		OrderDetails=bean.getOrderDetails(orderid);
		if (!OrderDetails.containsKey("ERROR"))	{
			 Amd_OrderCatalogCode	=(String)OrderDetails.get("ORDER_CATALOG_CODE");
			 Amd_Start_Date_Time		=(String)OrderDetails.get("START_DATE_TIME");
			 Amd_End_Date_Time			=(String)OrderDetails.get("END_DATE_TIME");
			 Amd_Freq_Code				=(String)OrderDetails.get("FREQ_CODE");
			 Amd_Durn_Value				=(String)OrderDetails.get("DURN_VALUE");
			 //Amd_Durn_Type				=(String)OrderDetails.get("DURN_TYPE");
			 Amd_Infuse_Over				=(String)OrderDetails.get("INFUSE_OVER");
			 Amd_Infuse_Over_Unit		=(String)OrderDetails.get("INFUSE_OVER_UNIT");
			 Amd_Isscheduled				=(String)OrderDetails.get("ISSCHEDULED");
			 Amd_ShortName				=(String)OrderDetails.get("LONG_NAME");
			 Amd_Freq_Nature				=(String)OrderDetails.get("FREQ_NATURE");
			 Amd_Tot_Volume				=(String)OrderDetails.get("TOTAL_VOLUME");
			//added for ML-MMOH-CRF-1012 start
			 if(tpn_standard_non_standard){
			 total_daily_fluid				=(String)OrderDetails.get("TOTAL_DAILY_FLUID")==null?"":(String)OrderDetails.get("TOTAL_DAILY_FLUID");
			 enteral_feeding                =(String)OrderDetails.get("ENTERAL_FEEDING")==null?"":(String)OrderDetails.get("ENTERAL_FEEDING");
			 }
			//added for ML-MMOH-CRF-1012 end
			 Amd_Base_Unit	 				=(String)OrderDetails.get("PRES_BASE_UNIT");
			if (OrderDetails.containsKey("SCH_TIME")){
				schtime=(ArrayList)OrderDetails.get("SCH_TIME");	
			}
		}
	}
%>
<!-- <BODY> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<FORM name="tpnStandardRegimen" id="tpnStandardRegimen">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<%
			if (mode1.equals("")){
				print_ord_sht_rule_ind=bean.getprint_ord_sht_rule_ind(bean.getOrder_Type(),request.getParameter("patient_class"));//Added for Bru-HIMS-CRF-393_1.0 
%>
				<tr>
					<th colspan="6" align="left"><fmt:message key="ePH.StandardRegimenDetails.label" bundle="${ph_labels}"/></th>
				</TR>
				<tr>
					<Td   class="label" align="right"><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/></Td>
					<TD  align="left" colspan=2>
					   &nbsp;<input type=text name="stdregimen" id="stdregimen" maxlength=30 size=30 onBlur="
					   if (this.value==''){disableAll();document.tpnStandardRegimen.Regimen_Code.value='';} "><input type=button class=button value="?" name="stdregimenlookup" id="stdregimenlookup" id="stdregimenlookup" onClick="stdLookup(tpnStandardRegimen.stdregimen,'<%=params%>','<%=tpn_std_reg_freq%>')">
						&nbsp;
					   <img src="../../eCommon/images/mandatory.gif">
					  </TD>
					<Td   class="label" align="left"  colspan=1 style="cursor:pointer;color:blue" id="constituent" disabled onClick="displayConst(Regimen_Code.value)"> <fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></Td>
					<Td class="label"  colspan=3 align="left" ><label class="label" id='npc_val' name='npc_val'><B></B></label>&nbsp;<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
<%
						if(MAR_app_yn.equals("Y")){
%>
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> onclick='assignValue(this);'>
			<%
						}
						else{
			%>
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
			<%
						}
			%>	
					</Td>
				</TR>
				<tr>
					<th colspan="6" align="left"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th>
				</TR>
				<tr>
					<Td   class="label" align="right"><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/></Td>
					<TD  align="left">&nbsp;<SELECT name="infroute" id="infroute" id="infroute" >
					<OPTION value="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
					</SELECT>
					</TD>
					<Td   class="label" align="right"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></Td>
					<TD  align="left" class="label">&nbsp;<input type=text  class="number" name="volume" id="volume" maxlength=5 size=5
					onBlur="CheckNum(this);CheckPositiveNumber(this)" >&nbsp;<label id='volumeunit' name='volumeunit'><b><%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,uom.toUpperCase()))%><!-- <fmt:message key="Common.ml.label" bundle="${common_labels}"/> --></b></label><!-- //Modified for CRF--0749 INC-13640 -->
					<img src="../../eCommon/images/mandatory.gif">
					</TD>
					<Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
					<TD  align="left" colspan=3 class="label" >&nbsp;<input type=text  class="number" value="24" name="infuseover" id="infuseover" maxlength=3 size=5 onBlur="CheckNum(this);CheckNum(this);checkInfuse1(this)" >&nbsp;<B><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></B> 
					<img src="../../eCommon/images/mandatory.gif">
					<!-- <SELECT name="infuseoverdrn" id="infuseoverdrn"   id="infuseoverdrn" >
					<OPTION value="H">Hours</OPTION>
					<OPTION value="M">Minutes</OPTION>   </SELECT>  -->  </TD>
				</TR>
				<tr>
<% 
				ArrayList freq   = new ArrayList();
				freq=bean.getTpnFrequency();
				String code="";
				String desc="";
				String freqNature = "";
				if(freq.size()!= 0) {
					for(int r=1;r<freq.size();r++){
						code=(String)freq.get(0);
						desc=(String)freq.get(1);
						freqNature=(String)freq.get(2);
					}
				}
%>
				<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> :</Td> 
<%			if(tpn_std_reg_freq){ //ML-MMOH-CRF-1126 - start
			
			
%>				
				<TD  align="left" class="label"><select name="frequency" id="frequency" onChange="" style="width:200;">
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				</select></td>
<%}else{%>			
				<TD  align="left" class="label">&nbsp;<b><%=desc %></b><input type="hidden" name="frequency" id="frequency" value="<%=code %>"></td>
<%}%>								
				<Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
				<TD  align="left" class="label">&nbsp;<input type=text class="number"  name="duration" id="duration" maxlength=2 size=5 value="" onBlur="CheckNum(this);CheckPositiveNumber(this);CheckMaxDuration(this);">&nbsp;<B><fmt:message key="Common.days.label" bundle="${common_labels}"/></b>
					<img src="../../eCommon/images/mandatory.gif">
					<label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label>

				</TD>
				<Td   class="label"  align="right"> &nbsp;</Td>
				<Td   class="label" align="left"  style="cursor:pointer;color:blue" name="remarks"	id="remarks"  name='remarksDtls' onClick="getFormatId('Y')"> &nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> <!--  getFormatId() is replaced by getFormatId('Y') and blelow code added for [IN:39795]-start -->
		      <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
			  <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
			  <input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
			  <!-- added for [IN:39795]-end -->
				</Td>  
			</TR>
			<tr>
				<Td   class="label" ></Td> 
				<TD  align="left" class="label">	 </TD>
				<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
				<TD  align="left" >&nbsp;<input type=text name="startdate" id="startdate" value="<%=start_date%>" onBlur="DateFormatCheck(this,'<%=locale%>');CalculateEndDate(document.tpnStandardRegimen)"  maxlength=16 size=14 ><!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('startdate',null,'hh:mm');document.tpnStandardRegimen.startdate.focus();return false;" > </TD>
				<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
				<TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate"  maxlength=16 value="<%=start_date%>"  size=14 ></TD>
			</TR>
			<tr>
				<Td  colspan=6  align=left >
				<br>
				<label id="AuthReqd" class="hyperlink1" onClick="Authorize(this)" style="visibility:hidden"><img  id="AuthReqdimg" src="../../eOR/images/Authorization.gif"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></label>&nbsp;
				<label class="hyperlink1" onClick="Cosign(this)"   id="CosignReqd" style="visibility:hidden"><img id="CosignReqdimg" src="../../eOR/images/Cosign_click.gif"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></label>&nbsp;
				<label class="hyperlink1" onClick="SplApprove(this)"  style="visibility:hidden" id="SplAppReqd"><img id="SplAppReqdimg" src="../../eOR/images/SpecialApproval.gif"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></label>&nbsp;
				<label  style="visibility:hidden;font-size:8pt;color:red;font-weight:bold" id="ConsentReqd" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/> </label>
				</td>
			</TR>
			<!-- ML-MMOH-CRF-1012 start -->
			<% if(tpn_standard_non_standard){ %>
			<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.TotalDailyFluid.label" bundle="${ph_labels}"/></Td>
			<TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10" class="number" name="total_daily_fluid" id="total_daily_fluid" value="<%=total_daily_fluid%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif"><label id='totaldailyfluidunit' name='totaldailyfluidunit'><b><fmt:message key="ePH.ml.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.kg.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.day.label" bundle="${ph_labels}"/></b></label>
			   </TD>
			</tr>
			<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.EnteralFeeding.label" bundle="${ph_labels}"/></Td>
			<TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10" class="number" name="enteral_feeding" id="enteral_feeding" value="<%=enteral_feeding%>"  onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif">
			</TD>
			</tr>
			<%}%>
			<!-- ML-MMOH-CRF-1012 end -->
			<input type=hidden name="Regimen_Code" id="Regimen_Code">
			<input type=hidden name="max_duration" id="max_duration" >
			<input type=hidden name="action_type" id="action_type">
			<input type=hidden name="action_msg" id="action_msg">
			<input type=hidden name="ordertype_code" id="ordertype_code">

			<input type=hidden name="patient_id" id="patient_id"	 value="<%=patient_id%>" >
			<input type=hidden name="tpn_standard_non_standard" id="tpn_standard_non_standard" value="<%=tpn_standard_non_standard%>"><!-- added for ML-MMOH-CRF-1012 -->
			<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type=hidden name="location_type" id="location_type" value="<%=location_type%>">
			<input type=hidden name="location_code" id="location_code" value="<%=location_code%>">
			<input type=hidden name="pract_id" id="pract_id"		 value="<%=pract_id%>" >
			<input type=hidden name="patient_class" id="patient_class" value="<%=act_patient_class.trim()%>">
			<input type=hidden name="height" id="height"		   value="<%=height%>">
			<input type=hidden name="weight" id="weight"		   value="<%=weight%>">
			<input type=hidden name="order_date" id="order_date" value="<%=start_date%>">
			<input type=hidden name="priority" id="priority"	   value="<%=priority%>">
			<input type=hidden name="freqNature" id="freqNature"   value="<%=freqNature%>"	  > 
			<input type=hidden name="authreqdYN" id="authreqdYN"		 value="N">
			<input type=hidden name="cosignreqdYN" id="cosignreqdYN"	 value="N">
			<input type=hidden name="splappreqdYN" id="splappreqdYN"	 value="N">
			<input type=hidden name="consentreqdYN" id="consentreqdYN"	 value="N">
			<input type=hidden name="authorizedYN" id="authorizedYN"	   value="N">
			<input type=hidden name="cosignedYN" id="cosignedYN"	   value="N">
			<input type=hidden name="splappedYN" id="splappedYN"	   value="N">
			<input type=hidden name="unitofvolume" id="unitofvolume">
			<input type=hidden name="bean_id" id="bean_id"		value='<%=bean_id%>'>
			<input type=hidden name="bean_name" id="bean_name"	value='<%=bean_name%>'>
			<input type=hidden name="remarksDtls1" id="remarksDtls1"	value="">
			<input type=hidden name="mode" id="mode"			value=<%=mode%>>
			<input type=hidden name="print_ord_sht_rule_ind" id="print_ord_sht_rule_ind"			value=<%=print_ord_sht_rule_ind%>><!--Added for Bru-HIMS-CRF-393_1.0 -->
			<script>disableAll()</script>
<% 
		}  //mode="";
		else if(mode1.equals("amend")) { 
			//ArrayList vol_inf=new ArrayList();
			String tpn_admin_route="";
			OrderDetails=bean.getOrderDetails(order_id);
			 Amd_OrderCatalogCode	=(String)OrderDetails.get("ORDER_CATALOG_CODE");
			 String drug_desc=bean.getDrugDesc(Amd_OrderCatalogCode);
			 if(drug_desc == null){
				drug_desc="";
			 }
			 print_ord_sht_rule_ind=bean.getprint_ord_sht_rule_ind(bean.getOrder_Type(),request.getParameter("patient_class"));//Added for Bru-HIMS-CRF-393_1.0 
			 Amd_Start_Date_Time		=(String)OrderDetails.get("START_DATE_TIME");
			 Amd_End_Date_Time			=(String)OrderDetails.get("END_DATE_TIME");
			 Amd_Freq_Code				=(String)OrderDetails.get("FREQ_CODE");
			 Amd_Durn_Value				=(String)OrderDetails.get("DURN_VALUE");
			// Amd_Durn_Type				=(String)OrderDetails.get("DURN_TYPE");
			 Amd_Infuse_Over				=(String)OrderDetails.get("INFUSE_OVER");
			 Amd_Infuse_Over_Unit		=(String)OrderDetails.get("INFUSE_OVER_UNIT");
			 Amd_Isscheduled				=(String)OrderDetails.get("ISSCHEDULED");
			 Amd_ShortName				=(String)OrderDetails.get("LONG_NAME");
			 Amd_Freq_Nature				=(String)OrderDetails.get("FREQ_NATURE");
			 Amd_Tot_Volume				=(String)OrderDetails.get("TOTAL_VOLUME");
			//added for ML-MMOH-CRF-1012 start
			 if(tpn_standard_non_standard){
			 total_daily_fluid				=(String)OrderDetails.get("TOTAL_DAILY_FLUID")==null?"":(String)OrderDetails.get("TOTAL_DAILY_FLUID");
			 enteral_feeding				=(String)OrderDetails.get("ENTERAL_FEEDING")==null?"":(String)OrderDetails.get("ENTERAL_FEEDING");
			 }
			//added for ML-MMOH-CRF-1012 end
			 Amd_Base_Unit	 				=(String)OrderDetails.get("PRES_BASE_UNIT");
			 tpn_admin_route            =(String)OrderDetails.get("TPN_ADMIN_ROUTE");
			 Amd_Tot_Volume             =bean.getVolume(order_id);
			 buildMAR_yn = (String) OrderDetails.get("BUILD_MAR_YN")==null?"":(String) OrderDetails.get("BUILD_MAR_YN");

			/*if(MAR_app_yn.equals("Y")){ //Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP SRR20056-CRF-0649.1 
				buildMAR_enable ="disabled"; */
			if(buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			else
				buildMAR_checked="";
			//}
	%>
			<tr>
				<th colspan="6" align="left"><fmt:message key="ePH.StandardRegimenDetails.label" bundle="${ph_labels}"/></th>
			</TR>
			<tr>
				<Td   class="label" align="right"><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/></Td>
				<TD  align="left" colspan=2>
				&nbsp;<input type=text name="stdregimen" id="stdregimen" maxlength=30 size=30 value="<%=drug_desc%>" READONLY onBlur="
				if (this.value==''){disableAll();document.tpnStandardRegimen.Regimen_Code.value='';} "><input type=button class=button value="?" disabled readonly name="stdregimenlookup" id="stdregimenlookup" id="stdregimenlookup"onClick="stdLookup(tpnStandardRegimen.stdregimen,'<%=params%>','<%=tpn_std_reg_freq%>','<%=act_patient_class%>')">
				&nbsp;
				<img src="../../eCommon/images/mandatory.gif">
				</TD>
				<Td   class="label" align="left"  colspan=1 style="cursor:pointer;color:blue" id="constituent"  onClick="displayConst('<%=Amd_OrderCatalogCode%>')"> <fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></Td>
				<Td class="label"  colspan=3 align="left" ><label class="label" id='npc_val' name='npc_val'><B></B></label>&nbsp;<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
			<%
						if(MAR_app_yn.equals("Y")){
			%>
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%>  onclick='assignValue(this);'>
			<%
						}
						else{
			%>
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
			<%
						}
			%>	
		</Td>
	</TR>
	<tr>
			<th colspan="6" align="left"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th>
	</TR>
	
	<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/></Td>
		   <TD  align="left">&nbsp;<SELECT name="infroute" id="infroute" id="infroute" disabled >
<%
					if(tpn_admin_route.equals("C") || tpn_admin_route.equals("")){ 
%>
						
						    <OPTION value="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
<% 
						} 
						else {  
%>
							<SELECT name="infroute" id="infroute" id="infroute">
							<OPTION value="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
							<OPTION  value="P" selected><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
<%
						} 
%>
						</SELECT>
					</TD>
					<Td   class="label" align="right"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></Td>
					<TD  align="left" class="label">&nbsp;<input type=text  class="number" name="volume" id="volume" value="<%=Amd_Tot_Volume%>" READONLY maxlength=5 size=5
					   onBlur="CheckNum(this);CheckPositiveNumber(this)">&nbsp;<label id='volumeunit' name='volumeunit'><b><!-- <fmt:message key="ePH.StandardRegimenDetails.label" bundle="${ph_labels}"/> --><fmt:message key="Common.ml.label" bundle="${common_labels}"/></b></label>
					   <img src="../../eCommon/images/mandatory.gif">
					</TD>
					<Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
					<TD  align="left" colspan=3 class="label" >&nbsp;<input type=text  class="number" value="<%=Amd_Infuse_Over%>" name="infuseover" maxlength=3 size=5 onBlur="CheckNum(this);checkInfuse1(this)" >&nbsp;<B><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></B> 
					<!-- <SELECT name="infuseoverdrn" id="infuseoverdrn"   id="infuseoverdrn" >
					<OPTION value="H">Hours</OPTION>
					<OPTION value="M">Minutes</OPTION>   </SELECT>  -->  </TD>
				</TR>
				<tr>
<%
					ArrayList freq   = new ArrayList();
					freq=bean.getTpnFrequency();
					String code="";
					String desc="";
					String freqNature = "";
					if(freq.size()!= 0) {
						for(int r=1;r<freq.size();r++){
							code=(String)freq.get(0);
							desc=(String)freq.get(1);
							freqNature=(String)freq.get(2);
						}
					}
%>
					<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> :</Td>
<%			if(tpn_std_reg_freq){//ML-MMOH-CRF-1126 - start
			String freq_code="";

			HashMap tpnFreq = bean.getTPNContFreq(Amd_OrderCatalogCode,act_patient_class);
			

			if(tpnFreq!=null){
				freq_code = (String)tpnFreq.get("defTpnFreqCode");

				ArrayList contFreq = (ArrayList)tpnFreq.get("conTpnFreqList");

			for(int i=0;i<contFreq.size();i+=2){

					if(Amd_Freq_Code.equals((String) contFreq.get(i))){//modified FOR ml-mmoh-crf-1126.1
						freq_option		= freq_option +	"<option value='"+((String) contFreq.get(i))+"'  selected>"+((String) contFreq.get(i+1))+"</option>";
						freq_code	    = ((String) contFreq.get(i));
					}
					else{
						freq_option		= freq_option +	"<option value='"+((String) contFreq.get(i))+"' >"+((String) contFreq.get(i+1))+"</option>";
					}
					
				}	
			  }
			
			if(Amd_Freq_Code!=null && !Amd_Freq_Code.equals("")){//modified FOR ml-mmoh-crf-1126.1
			
			
%>				
				<TD  align="left" class="label"><select name="frequency" id="frequency" onChange="" style="width:200;">
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<b><%=freq_option %></b></select></td>
				<%}else{ %>
					<TD  align="left" class="label">&nbsp;<b><%=desc %></b><input type="hidden" name="frequency" id="frequency" value="<%=code %>"></td>
<%					}
				}else{	%>				

					<TD  align="left" class="label">&nbsp;<b><%=desc %></b><input type="hidden" name="frequency" id="frequency" value="<%=code %>"></td>
				<%} //ML-MMOH-CRF-1126%>
					<Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
					<TD  align="left" class="label">&nbsp;<input type=text class="number"  name="duration" id="duration" maxlength=2 size=5 value="<%=Amd_Durn_Value%>" onBlur="CheckNum(this);CheckPositiveNumber(this);CheckMaxDuration(this);">&nbsp;<B><fmt:message key="Common.days.label" bundle="${common_labels}"/></b>
					   <img src="../../eCommon/images/mandatory.gif">
						<label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label>

					</TD>
					<Td   class="label"  align="right"> &nbsp;</Td>
					<Td   class="label" align="left"  style="cursor:pointer;color:blue" name="remarks"	id="remarks"  name='remarksDtls' onClick="getFormatId('Y')"> &nbsp;<fmt:message key="ePH.StandardRegimenDetails.label" bundle="${ph_labels}"/><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> <!--  getFormatId() is replaced by getFormatId('Y') and blelow code added for [IN:39795]-start -->
		      <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
			  <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
			  <input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
			  <!-- added for [IN:39795]-end --></Td>
				</TR>
				<tr>
					<Td   class="label" ></Td> 
					<TD  align="left" class="label">	 </TD>
					<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
				   <TD  align="left" >&nbsp;<input type=text name="startdate" id="startdate" value="<%=Amd_Start_Date_Time%>" onBlur="DateFormatCheck(this,'<%=locale%>');CalculateEndDate(document.tpnStandardRegimen)"  maxlength=16 size=14 ><!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
				   <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('startdate',null,'hh:mm');document.tpnStandardRegimen.startdate.focus();return false;" > </TD>
					<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
				   <TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate"  maxlength=16 value="<%=Amd_End_Date_Time%>"  size=14 ></TD>
				</TR>
		<!-- added for ML-MMOH-CRF-1012 start amend mode-->
				<% if(tpn_standard_non_standard){ %>
			<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.TotalDailyFluid.label" bundle="${ph_labels}"/></Td>
			<TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10" class="number" name="total_daily_fluid" id="total_daily_fluid" value="<%=total_daily_fluid%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif"><label id='totaldailyfluidunit' name='totaldailyfluidunit'><b><fmt:message key="ePH.ml.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.kg.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.day.label" bundle="${ph_labels}"/></b></label>
			   </TD>
			</tr>
			<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.EnteralFeeding.label" bundle="${ph_labels}"/></Td>
			<TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10" class="number" name="enteral_feeding" id="enteral_feeding" value="<%=enteral_feeding%>"  onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif">
			</TD>
			</tr>
			<%}%>	
		<!-- added for ML-MMOH-CRF-1012 end  amend mode-->
				<tr>
					<Td  colspan=6  align=left >
					<br>
					<label id="AuthReqd" class="hyperlink1" onClick="Authorize(this)" style="visibility:hidden"><img  id="AuthReqdimg" src="../../eOR/images/Authorization.gif"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></label>&nbsp;
					<label class="hyperlink1" onClick="Cosign(this)"   id="CosignReqd" style="visibility:hidden"><img id="CosignReqdimg" src="../../eOR/images/Cosign_click.gif"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></label>&nbsp;
					<label class="hyperlink1" onClick="SplApprove(this)"  style="visibility:hidden" id="SplAppReqd"><img id="SplAppReqdimg" src="../../eOR/images/SpecialApproval.gif"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></label>&nbsp;
					<label  style="visibility:hidden;font-size:8pt;color:red;font-weight:bold" id="ConsentReqd" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/></label>
					
					</td>
				</TR>
				<input type=hidden name="Regimen_Code" id="Regimen_Code" value="<%=Amd_OrderCatalogCode%>">
				<input type=hidden name="max_duration" id="max_duration" >
				<input type=hidden name="action_type" id="action_type">
				<input type=hidden name="action_msg" id="action_msg">
				<input type=hidden name="ordertype_code" id="ordertype_code">
				<input type=hidden name="patient_id" id="patient_id"	 value="<%=patient_id%>" >
				<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type=hidden name="location_type" id="location_type" value="<%=location_type%>">
				<input type=hidden name="location_code" id="location_code" value="<%=location_code%>">
				<input type=hidden name="pract_id" id="pract_id"		 value="<%=pract_id%>" > 
				<input type=hidden name="order_id" id="order_id"		 value="<%=order_id%>" >
				<input type=hidden name="tpn_standard_non_standard" id="tpn_standard_non_standard" value="<%=tpn_standard_non_standard%>"><!-- added amend for ML-MMOH-CRF-1012 -->
				<input type=hidden name="patient_class" id="patient_class" value="<%=act_patient_class.trim()%>">
				<input type=hidden name="height" id="height"		   value="<%=height%>">
				<input type=hidden name="weight" id="weight"		   value="<%=weight%>">
				<input type=hidden name="order_date" id="order_date" value="<%=start_date%>">
				<input type=hidden name="priority" id="priority"	   value="<%=priority%>">
				<input type=hidden name="freqNature" id="freqNature"   value="<%=freqNature%>"	  > 
				<input type=hidden name="authreqdYN" id="authreqdYN"		 value="N">
				<input type=hidden name="cosignreqdYN" id="cosignreqdYN"	 value="N">
				<input type=hidden name="splappreqdYN" id="splappreqdYN"	 value="N">
				<input type=hidden name="consentreqdYN" id="consentreqdYN"	 value="N">
				<input type=hidden name="authorizedYN" id="authorizedYN"	   value="N">
				<input type=hidden name="cosignedYN" id="cosignedYN"	   value="N">
				<input type=hidden name="splappedYN" id="splappedYN"	   value="N">
				<input type=hidden name="unitofvolume" id="unitofvolume"	value="<%=Amd_Base_Unit%>" >
				<input type=hidden name="bean_id" id="bean_id"		value='<%=bean_id%>'>
				<input type=hidden name="bean_name" id="bean_name"	value='<%=bean_name%>'>
				<input type=hidden name="mode1" id="mode1"			value=<%=mode1%>>
				<input type=hidden name="remarksDtls1" id="remarksDtls1"	value="">
				<input type=hidden name="mode" id="mode"			value="2">
				<input type=hidden name="print_ord_sht_rule_ind" id="print_ord_sht_rule_ind"			value=<%=print_ord_sht_rule_ind%>><!--Added for Bru-HIMS-CRF-393_1.0 -->
<%
			} //ends at 489==amend
			else if (operation==2) { 
 %>
				<tr>
					<Td   class="label" align="right"><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/></Td>
					<TD  align="left" colspan=2>   &nbsp;
					<input type=text name="stdregimen" id="stdregimen" maxlength=30 size=30  value="<%=Amd_ShortName%>" disabled><input type=button class=button value="?" name="stdregimenlookup" id="stdregimenlookup" id="stdregimenlookup" disabled>&nbsp;
					<img src="../../eCommon/images/mandatory.gif">
					</TD>
					<Td   class="label" align="left"  colspan=2 style="cursor:pointer;color:blue" id="constituent" onClick="displayConst('<%=Amd_OrderCatalogCode%>')"> <fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></Td>
					<Td   class="label"  colspan=2><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
<%
					if(MAR_app_yn.equals("Y")){
%>
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> onclick='assignValue(this);'>
<%
					}
					else{
%>
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
					}
%>		
						</td>
					</TR>
					<tr>
						<th colspan="6" align="left"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th>
					</TR>
					<tr>
						<Td   class="label" align="right"><fmt:message key="ePH.InfusionRoute.label" bundle="${ph_labels}"/></Td>
						<TD  align="left">&nbsp;<SELECT name="infroute" id="infroute" id="infroute" >
								<OPTION value="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
							   <OPTION value="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
						</SELECT>
						</TD>
						<Td   class="label" align="right"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></Td>
						<TD  align="left" class="label">&nbsp;<input type=text  class="number" name="volume" id="volume" maxlength=5 size=5
						   onBlur="CheckPositiveNumber(this)" value="<%=Amd_Tot_Volume%>">&nbsp;<label id='volumeunit' name='volumeunit'><%=Amd_Base_Unit%></label>
						   <img src="../../eCommon/images/mandatory.gif">
						</TD>
						<Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
						<TD  align="left" class="label" colspan=3 >&nbsp;<input type=text  class="number" name="infuseover" id="infuseover" value="<%=Amd_Infuse_Over%>" maxlength=3 size=5 onBlur="CheckPositiveNumber(this)"  >&nbsp;<SELECT name="infuseoverdrn" id="infuseoverdrn"   id="infuseoverdrn" >
<%
						if (Amd_Infuse_Over_Unit.equals("H")){
%>
							<OPTION value="H" Selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></OPTION>  
<%
						}
						else if (Amd_Infuse_Over_Unit.equals("M")){
%>	
							<OPTION value="H" ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="M" Selected><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></OPTION>  
 <%
						}
%> 
						</SELECT>   
						</TD>
					</TR>
					<tr>
						<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></Td>
<% 	
						if (!Amd_Isscheduled.equals("0")){
							disabled="disabled";
							tooltip="<TABLE>";
							for (int i=0;i<schtime.size();i+=2){
								tooltip+="<TR><TD class=TIP>"+schtime.get(i)+"</TD><TD class=TIP>"+schtime.get(i+1)+"</TD></TR>";
							}
							tooltip+="</TABLE>";
						}
%>
						<TD  align="left">&nbsp;<SELECT name="frequency" id="frequency"  <%=disabled%> id="frequency"  onChange="frequencySelect(this)" >
						<OPTION value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</OPTION>
<%
						String code, desc, scheduled, freqnature;
						for (int i=0;i<freqlist.size();i+=4){
							code			=(String)freqlist.get(i);
							desc			=(String)freqlist.get(i+1);
							scheduled		=(String)freqlist.get(i+2);
							freqnature	=(String)freqlist.get(i+3);
%>
							<script>
								schedulearr['<%=code%>']='<%=scheduled%>';	
								freqnaturearr['<%=code%>']='<%=freqnature%>';
							</script>
<% 
							if (Amd_Freq_Code.equals(code)){
%>
								<OPTION selected value="<%=code%>"><%=desc%></OPTION>
<%
							}
							else{
%>
									<OPTION value="<%=code%>"><%=desc%></OPTION>
<%
								}
							}
%>
						   </SELECT>   	  <img src="../../eCommon/images/mandatory.gif"></TD>
						   <Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
						   <TD  align="left" class="label">&nbsp;<input type=text class="number"  name="duration" id="duration"  value="<%=Amd_Durn_Value%>" maxlength=2 size=5  <%=disabled%> onBlur="CheckPositiveNumber(this);CheckMaxDuration(this);">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
								<img src="../../eCommon/images/mandatory.gif">
							<label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label>
							</TD>
							<Td   class="label"  align="right"> &nbsp;</Td>
							<Td   class="label" align="left"  style="cursor:pointer;color:blue" name="remarks"	id="remarks"  name='remarksDtls' onClick="getFormatId('Y')"> &nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
		      <!-- added for [IN:039576]-start -->
		      <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
			  <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
			  <input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
			  <!-- added for [IN:039576]-end -->
						</TR>
						<tr>
<% 
						if (!Amd_Isscheduled.equals("0")) {
%>
							<Td   class="label" align="right" id="scmed" name="scmed" 	 onmouseover="displayamendToolTipDataChange('<%=tooltip%>');" onmouseout="disasbleamendToolTipDataChange();"  style="color:blue;cursor:pointer"><fmt:message key="ePH.ScheduleMedication.label" bundle="${ph_labels}"/> 	</Td> 

<%
						}
						else{
%>
							<Td   class="label" align="right" id="scmed" name="scmed" 		><fmt:message key="ePH.ScheduleMedication.label" bundle="${ph_labels}"/>
							</Td> 
<% 
						}
 %>
						<TD  align="left" class="label"><INPUT TYPE="checkbox" <%=disabled %> NAME="schedulemed" id="schedulemed" onClick="displaySchedule(this)">		 </TD>
						<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
						<TD  align="left" class="label">&nbsp;<input type=text name="startdate" id="startdate" value="<%=Amd_Start_Date_Time%>" <%=disabled%> onBlur="DateFormatCheck(this,'<%=locale%>');CalculateEndDate(document.tpnStandardRegimen)"  maxlength=16 size=14 ><!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
						<IMG disabled SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('startdate',null,'hh:mm');" > </TD>
						<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
						<TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate" <%=disabled%> maxlength=16 value="<%=Amd_End_Date_Time%>"  size=14 ></TD>
					</TR>
					<tr>
						<Td  colspan=6  align=left >
						<br>
						<label id="AuthReqd" class="hyperlink1" onClick="Authorize(this)" style="visibility:hidden"><img  id="AuthReqdimg" src="../../eOR/images/Authorization.gif"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></label>&nbsp;
						<label class="hyperlink1" onClick="Cosign(this)"   id="CosignReqd" style="visibility:hidden"><img id="CosignReqdimg" src="../../eOR/images/Cosign_click.gif"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></label>&nbsp;
						<label class="hyperlink1" onClick="SplApprove(this)"  style="visibility:hidden" id="SplAppReqd"><img id="SplAppReqdimg" src="../../eOR/images/SpecialApproval.gif"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></label>&nbsp;
						<label  style="visibility:hidden;font-size:8pt;color:red;font-weight:bold" id="ConsentReqd" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/></label>
						
						</td>
					</TR>
					<input type=hidden name="Regimen_Code" id="Regimen_Code" value="<%= Amd_OrderCatalogCode%>">
					<input type=hidden name="max_duration" id="max_duration" >
					<input type=hidden name="action_type" id="action_type">
					<input type=hidden name="action_msg" id="action_msg">
					<input type=hidden name="ordertype_code" id="ordertype_code">

					<input type=hidden name="patient_id" id="patient_id"	 value="<%=patient_id%>" >
					<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
					<input type=hidden name="location_type" id="location_type" value="<%=location_type%>">
					<input type=hidden name="location_code" id="location_code" value="<%=location_code%>">
					<input type=hidden name="pract_id" id="pract_id"		 value="<%=pract_id%>" >
					<input type=hidden name="patient_class" id="patient_class" value="<%=act_patient_class.trim()%>">
					<input type=hidden name="height" id="height"		   value="<%=height%>">
					<input type=hidden name="weight" id="weight"		   value="<%=weight%>">
					<input type=hidden name="order_date" id="order_date" value="<%=start_date%>">
					<input type=hidden name="priority" id="priority"	   value="<%=priority%>">
					<input type=hidden name="freqNature" id="freqNature"	 value="<%=Amd_Freq_Nature%>" >
					<input type=hidden name="authreqdYN" id="authreqdYN"		 value="N">
					<input type=hidden name="cosignreqdYN" id="cosignreqdYN"	 value="N">
					<input type=hidden name="splappreqdYN" id="splappreqdYN"	 value="N">
					<input type=hidden name="consentreqdYN" id="consentreqdYN"	 value="N">
					<input type=hidden name="authorizedYN" id="authorizedYN"	   value="N">
					<input type=hidden name="cosignedYN" id="cosignedYN"	   value="N">
					<input type=hidden name="splappedYN" id="splappedYN"	   value="N">
					<input type=hidden name="unitofvolume" id="unitofvolume"	value="<%=Amd_Base_Unit%>" >
					<input type=hidden name="bean_id" id="bean_id"		value='<%=bean_id%>'>
					<input type=hidden name="bean_name" id="bean_name"	    value='<%=bean_name%>'>
					<input type=hidden name="mode" id="mode"			value=<%=mode%>>
					<input type=hidden name="orderid" id="orderid"		value=<%=orderid%>>
					<input type=hidden name="remarksDtls1" id="remarksDtls1"	value="">
					<input type=hidden name="total_daily_fluid" id="total_daily_fluid"  value="" > <!-- ML-MMOH-CRF-1012 -->
			        <input type=hidden name="enteral_feeding" id="enteral_feeding" value="" > <!-- ML-MMOH-CRF-1012 -->
					<!--	<script>disableAll()</script>-->
<%
				}
				putObjectInBean(bean_id,bean,request);
				putObjectInBean(ph_bean_id,phbean,request);
%>
			<input type=hidden name="bed_num" id="bed_num" value="<%=bed_num%>"><!-- ML-MMOH-CRF-1089-->
			</TABLE>
			<label id="tool_tip" style="visibility:hidden"></label>
			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
				<tr><td width="100%" id="t"></td></tr>
				</table>
			</div> 
		</FORM>
	</body>
</html>

