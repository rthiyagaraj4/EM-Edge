<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>  <!--  ,webbeans.eCommon.*,java.sql.* added for ML-MMOH-CRF-1012 --> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
	 request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	
	String locale			= (String)session.getAttribute("LOCALE");  //added for [IN:031523] to avoid leap year issue
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNNonStdRegimen.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Added for[IN:031523]  -->


</HEAD>
<%
    String start_date="";
	String mode1=request.getParameter("mode");
	if(mode1 == null || mode1.equals("undefined")){mode1="";}
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String patient_id							= request.getParameter("patient_id");
	String encounter_id						    = request.getParameter("encounter_id");
	String location_type						= request.getParameter("location_type");
	String location_code						= request.getParameter("location_code");
	String pract_id								= request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String height								= request.getParameter("height");
	String weight								= request.getParameter("weight");
	if(weight == null){weight="";}
	String priority	 							= request.getParameter("priority");
	
	String infroute1	 							= request.getParameter("infroute1");
	String infusevalue1	 							= request.getParameter("infusevalue1");
	String durnvalue1	 							= request.getParameter("durnvalue1");
	String startdate1	 							= request.getParameter("startdate1");
	String end_date1	 							= request.getParameter("end_date1");
	
   // start_date							= request.getParameter("start_date");
   //Added for ML-MMOH-CRF-1012 start
   Connection	con=null;
	boolean tpn_standard_non_standard=false;
	boolean tpn_tab_reg = false;//ML-MMOH-CRF-1290
	con	= ConnectionManager.getConnection(request);
	try{
		
		 tpn_standard_non_standard = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STAND_NON_STAND_LABEL");
		 tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
		System.out.println("Site==>"+tpn_standard_non_standard);
		//bean.setIssite(site);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		con.close();
	}
     //Added for Ml-MMOH-CRF-1012 end
	if(startdate1.equals("")){
		start_date						= request.getParameter("start_date");
    }
	else{
		 start_date=startdate1;
	}
	String mode									=CommonRepository.getCommonKeyValue("MODE_INSERT");
	
	String bean_id								= "@TPNNonStandardRegimenBean"+patient_id+encounter_id;
	String bean_name							= "ePH.TPNNonStandardRegimenBean";
	String fluidValuesStd =  null;
	ArrayList fluidReq			= new ArrayList(); 
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);

	ArrayList regimenDetails			=bean.getRegimenDetails(); 
	fluidReq							=bean.getFluidRequired(patient_id);

	String high_carbo_concentration= bean.getCarboConcentration();

	if(fluidReq != null){
	fluidValuesStd			= (String)fluidReq.get(3);}
	/*try
	{
		*/
    String regCode			="";
	String routeCode		="";
	String totvolume		="";
	String unitofvolume		="";
	//String infusedurn		="";
	String infusevalue		=""; 
	String ordertypecode	="";
	String consentreqd		="";
	String authreqd			="";
	String cosignreqd		="";
	String splappreqd		="";
	//String freqcode			="";
	String durnvalue	 	="";
	String action_type 		="";
	String action_msg 		="";
	String max_durn 		="";
	String end_date 		="";
	String infuse           ="";
	String DrugRemarksEntered			=""; //added for [IN:039576]
	String total_daily_fluid            ="";//added for ML-MMOH-CRF-1012
	String enteral_feeding              ="";//added for ML-MMOH-CRF-1012

    if(regimenDetails.size()!=0 && regimenDetails!=null){		
	 regCode			=(String)regimenDetails.get(0);
	 routeCode		=(String)regimenDetails.get(1);
	 totvolume		=(String)regimenDetails.get(2);
	 if(totvolume == null){totvolume="";}
	 if(!weight.equals("") && !fluidValuesStd.equals("")){
		totvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+"";
	    } 
	 unitofvolume		=(String)regimenDetails.get(4);
	 //infusedurn		=(String)regimenDetails.get(6);
	 if(infusevalue1.equals("")&&infusevalue1==null){
	 infusevalue		=(String)regimenDetails.get(7);
	 }else{
		 infusevalue=infusevalue1;
	 }
	 
	 ordertypecode	=(String)regimenDetails.get(8);
	 consentreqd		=(String)regimenDetails.get(9);
	 authreqd			=(String)regimenDetails.get(10);
	 cosignreqd		=(String)regimenDetails.get(11);
	 splappreqd		=(String)regimenDetails.get(12);
	 //freqcode			=(String)regimenDetails.get(13);
	 if(durnvalue1.equals("")){
	 durnvalue	 	=(String)regimenDetails.get(14);
     }else{durnvalue=durnvalue1;}
	 action_type 		=(String)regimenDetails.get(15);
	 action_msg 		=(String)regimenDetails.get(16);
	 max_durn 		=(String)regimenDetails.get(17);

	 if(end_date1.equals("")){
	 end_date 		=(String)regimenDetails.get(18);
     }else{end_date=end_date1;}
	 if(!locale.equals("en")) // Added for added for [IN:031523] 
		 end_date  = com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale); // Added for added for [IN:031523]
	 }
/*	}
	catch (Exception e)
	{
			out.println("Order Catalog Not Defined!! Cannot proceed!!!");
	}
	*/
	String print_ord_sht_rule_ind=bean.getprint_ord_sht_rule_ind(ordertypecode,request.getParameter("patient_class"));//Added for Bru-HIMS-CRF-393_1.0
	String bean_id1			= "@TPNStandardRegimenBean"+patient_id+encounter_id;
	String bean_name1	= "ePH.TPNStandardRegimenBean";


	TPNStandardRegimenBean bean1	= (TPNStandardRegimenBean)getBeanObject( bean_id1,bean_name1, request);
	ArrayList freqlist								=bean1.getFrequencies();

	//get values for all groups and populate

	int i=0;

/* For the present, a dummy value is given for order id..If present the function is taken as amend orders */
   String orderid=request.getParameter("orderid");
// out.println("order id si"+orderid);

	int operation=1;
	if (orderid!=null && !orderid.equals(""))
		operation=2;//for update
	
	mode=operation+"";
%>
<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<script>ChangeReleaseButtonStatus(parent.parent.ButtonFrame.document.TpnButtons,false);</script>
<% if (mode1.equals("")){  
	%>
	<FORM name="TpnAdmin" id="TpnAdmin">
	
	<div id="ADMIN" name="ADMIN">

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
		<tr>
			<Td   class="label" align="right"><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/></Td>
			 <TD  align="left" colspan=1 width="50%">&nbsp;
			  <SELECT name="infroute" id="infroute" id="infroute" onchange="changeInfusion(this);">
				 <%if(infroute1.equals("")){%>
					<OPTION value="C" Selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
					<%}else{%>
					<OPTION value="C" <%=infroute1.equals("C")?"selected":"" %>><fmt:message key="Common.Central.label" bundle="${common_labels}"/>	</OPTION>
					<option value="P" <%=infroute1.equals("P")?"selected":"" %>><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
				 <%}%>
			   </SELECT>
			   </TD>
				 
				<!-- <Td   class="label" align="right">Volume</Td>
			   <TD  align="left" class="label" colspan=3>&nbsp;<input type=text onBlur="CheckNum(this);CheckPositiveNumber(this)"  class="number" name="volume" id="volume" maxlength=5 size=5 value="<%=totvolume%>" >&nbsp;<label id='volumeunit' name='volumeunit'><B><%=unitofvolume%></B><img src="../../eCommon/images/mandatory.gif"></TD> -->
			   <td colspan=2>&nbsp;</td>
				 <Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
				   <% if(infusevalue.equals("")){infuse="24";} else {infuse=infusevalue;} %>
			   <TD class="label"  >&nbsp;<input type=text  name="infuseover" id="infuseover"  maxlength=3 size=5 class="number" onBlur="CheckNum(this);checkInfuse1(this);checkInfuseValue(this);" value="<%=infuse%>"  >&nbsp;<B><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></b></TD>
				  </TR> 
			   <TR>
			  <!--  <SELECT name="infuseoverdrn" id="infuseoverdrn" id="infuseoverdrn" >
			   <%// if (infusedurn.equals("H"))			   {
			   %>
					<OPTION value="H" Selected>Hours</OPTION>
					<OPTION value="M">Minutes</OPTION>
				<%//   }
			   //else   {
				   %>
					<OPTION value="H" >Hours</OPTION>
					<OPTION value="M" Selected>Minutes</OPTION>
					<%//   }
			   %>
				   </SELECT> -->
			   				 <% ArrayList freq   = new ArrayList();
				          freq=(ArrayList)bean.getTpnFrequency();
						  String code="";
						  String desc="";
						  String freqNature ="";
						 if(freq.size()!= 0) {
							  for(int r=1;r<freq.size();r++){
							  code=(String)freq.get(0);
							  desc=(String)freq.get(1); 
							  freqNature=(String)freq.get(2);						

							} 
						}
							  %>
				<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>&nbsp;:</td><td class="label" align="left"><B>&nbsp;<%=desc %></b><input type="hidden" name="frequency" id="frequency" value="<%=code %>">
				  </td><td colspan=2>&nbsp;</td>
	 <!--  <SELECT name="frequency" id="frequency" id="frequency"  onChange="frequencySelect(this)" >
			   <OPTION value="">---Select---</OPTION> -->
		   			   <%   /* for ( i=0;i<freqlist.size();i+=4){
					String code1			=(String)freqlist.get(i);
					String desc1			=(String)freqlist.get(i+1);
					String scheduled		=(String)freqlist.get(i+2);
					String freqnature	=(String)freqlist.get(i+3);  */
					%>
					<script>
					//schedulearr['<%//=code1%>']='<%//=scheduled%>';	
					//freqnaturearr['<%//=code1%>']='<%//=freqnature%>';
					</script>
						<% //if (freqcode.equals(code1)) {%>
							<OPTION selected value="<%//=code1%>"><%//=desc1%></OPTION>
						<%//}else{%>
							<OPTION value="<%//=code1%>"><%//=desc1%></OPTION>
					<%//}}
			   %>

	<!--	   </SELECT><img src="../../eCommon/images/mandatory.gif">   -->
			<Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text class="number" name="duration" id="duration" maxlength=2 size=5 onBlur="CheckNum(this);CheckPositiveNumber(this);CheckMaxDuration(this);checkDuration1(this,document.TpnAdmin.enddate);" value="<%=durnvalue%>" >&nbsp;<B><fmt:message key="Common.days.label" bundle="${common_labels}"/></B><img src="../../eCommon/images/mandatory.gif"><label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label></TD>
			   </tr>
												
			<!-- <Td   class="label" align="right"  nowrap name='scmed' id='scmed'>Schedule Medication</Td>  
				<TD colspan=1 align="left"><INPUT TYPE="checkbox" disabled name="schedulemed" id="schedulemed" id="schedulemed"  onClick="displaySchedule(this)" >		 </TD> -->
			   <TR>

				<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="startdate" id="startdate" value="<%=start_date%>" onBlur="DateFormatCheck(this,'<%=locale%>');CalculateEndDate(document.TpnAdmin);checkTpnDate(this,document.TpnAdmin.enddate);"  maxlength=16 size=14 ><!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('startdate',null,'hh:mm');document.TpnAdmin.startdate.focus();return false;" >
			     </TD>
				 <td colspan=2>&nbsp;</td>
				<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate" readonly maxlength=16 size=14
			   value="<%=end_date%>"></TD>

			</TR>
			<tr>
			<td class="label" align="left" width="25%"><!-- Width changed for 15% to 25% ML-MMOH-CRF-1012-->
			 <a href="javascript:getFormatId('Y');" style="visibility:visible"  id="remarks" name="remarks" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			      <!-- added for [IN:039576]-start -->
			      <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
			      <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
				  <input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
				  <!-- added for [IN:039576]-endchandu111 -->
			<td colspan=5> &nbsp;</td>
			 </TR>
			 <!-- ML-MMOH-CRF-1012 start -->
			<% if(tpn_standard_non_standard){ %>
			 <tr>
			 <Td   class="label" align="right"><fmt:message key="ePH.TotalDailyFluid.label" bundle="${ph_labels}"/></Td>
			 <TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10"class="number" name="total_daily_fluid" id="total_daily_fluid" value="<%=total_daily_fluid%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif"><label id='totaldailyfluidunit' name='totaldailyfluidunit'><b><fmt:message key="ePH.ml.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.kg.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.day.label" bundle="${ph_labels}"/></b></label>
			 </TD>
			 </tr>
			 <tr>
			 <Td   class="label" align="right"><fmt:message key="ePH.EnteralFeeding.label" bundle="${ph_labels}"/></Td>
			 <TD  align="left" class="label">&nbsp;<input type=text  size="7" maxlength="10"class="number" name="enteral_feeding" id="enteral_feeding" value="<%=enteral_feeding%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif">
			 </tr>
			 <%} %>
			 <!-- ML-MMOH-CRF-1012 end-->
			<tr>
			<Td  colspan=6  align="left" >
			<% if (authreqd.equals("Y")){
			%>
				<label id="AuthReqd" class="hyperlink1" onClick="Authorize(this)" ><img  id="AuthReqdimg" src="../../eOR/images/Authorization.gif"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (cosignreqd.equals("Y")){
			%>
			<label class="hyperlink1" onClick="Cosign(this)"   id="CosignReqd" ><img id="CosignReqdimg" src="../../eOR/images/Cosign_click.gif"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (splappreqd.equals("Y")){
			%>
			<label class="hyperlink1" onClick="SplApprove(this)"  id="SplAppReqd"><img id="SplAppReqdimg" src="../../eOR/images/SpecialApproval.gif"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (consentreqd.equals("Y")){
			%>
			<label  style="font-size:8pt;color:red;font-weight:bold" id="ConsentReqd" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/></label>
			<%
			}
			%>
			</td>
	</TR>
		</table>
	</div>
		<input type=hidden name="Regimen_Code" id="Regimen_Code"			value="<%=regCode%>">
		<input type=hidden name="max_duration" id="max_duration"			value="<%=max_durn%>">
		<input type=hidden name="action_type" id="action_type"			value="<%=action_type%>">
		<input type=hidden name="action_msg" id="action_msg"			value="<%=action_msg%>">
		<input type=hidden name="ordertype_code" id="ordertype_code"		value="<%=ordertypecode%>">
		<input type=hidden name="patient_id" id="patient_id"			value="<%=patient_id%>" >
		<input type=hidden name="encounter_id" id="encounter_id"			value="<%=encounter_id%>">
		<input type=hidden name="location_type" id="location_type"			value="<%=location_type%>">
		<input type=hidden name="location_code" id="location_code"			value="<%=location_code%>">
		<input type=hidden name="pract_id" id="pract_id"				value="<%=pract_id%>" >
		<input type=hidden name="patient_class" id="patient_class"			value="<%=act_patient_class.trim()%>">
		<input type=hidden name="height" id="height"				value="<%=height%>">
		<input type=hidden name="weight" id="weight"				value="<%=weight%>">
		<input type=hidden name="order_date" id="order_date"			value="<%=start_date%>">
		<input type=hidden name="priority" id="priority"				value="<%=priority%>">
		<input type=hidden name="freqNature" id="freqNature"			value="<%=freqNature%>"  >
		<input type=hidden name="authreqdYN" id="authreqdYN"		    value="<%=authreqd%>">
		<input type=hidden name="cosignreqdYN" id="cosignreqdYN"			value="<%=cosignreqd%>">
		<input type=hidden name="splappreqdYN" id="splappreqdYN"			value="<%=splappreqd%>">
		<input type=hidden name="consentreqdYN" id="consentreqdYN"			value="<%=consentreqd%>">
		<input type=hidden name="authorizedYN" id="authorizedYN"			value="N">
		<input type=hidden name="cosignedYN" id="cosignedYN"			value="N">
		<input type=hidden name="splappedYN" id="splappedYN"			value="N">
		<input type=hidden name="unitofvolume" id="unitofvolume"			value="<%=unitofvolume%>"	 >
		<input type=hidden name="bean_id" id="bean_id"				value='<%=bean_id%>'>
		<input type=hidden name="bean_name" id="bean_name"				value='<%=bean_name%>'>
		<input type=hidden name="mode" id="mode"					value=<%=mode%>>
		<input type=hidden name="durnvalue" id="durnvalue"					value=<%=durnvalue%>>
		<input type=hidden name="volume" id="volume"			value="">
		<input type=hidden name="volumeunit" id="volumeunit"			value="">
		<input type=hidden name="print_ord_sht_rule_ind" id="print_ord_sht_rule_ind"		value='<%=print_ord_sht_rule_ind%>'><!--Added for Bru-HIMS-CRF-393_1.0-->
		<input type=hidden name="tpn_standard_non_standard" id="tpn_standard_non_standard" value='<%=tpn_standard_non_standard%>'><!-- Added for ML-MMOH-CRF-1012 -->
		
<%
}
else if(mode1.equals("amend")){ 
		HashMap OrderDetails=new HashMap();
		OrderDetails					=bean.getOrderDetails1(order_id);
		mode		=CommonRepository.getCommonKeyValue("MODE_MODIFY");
				//String  Amd_OrderCatalogCode		=(String)OrderDetails.get("ORDER_CATALOG_CODE");
				//String  long_name					=(String)OrderDetails.get("LONG_NAME");
				String  Amd_Start_Date_Time			=(String)OrderDetails.get("START_DATE_TIME");
				String  Amd_End_Date_Time			=(String)OrderDetails.get("END_DATE_TIME");
				//String  Amd_Freq_Code				=(String)OrderDetails.get("FREQ_CODE");
				String  Amd_Durn_Value				=(String)OrderDetails.get("DURN_VALUE");

				//String  Amd_Durn_Type				=(String)OrderDetails.get("DURN_TYPE");
				String  Amd_Infuse_Over				=(String)OrderDetails.get("INFUSE_OVER");
				//String  Amd_Infuse_Over_Unit		=(String)OrderDetails.get("INFUSE_OVER_UNIT");
				//String  Amd_Isscheduled				=(String)OrderDetails.get("ISSCHEDULED");
				//String  Amd_ShortName				=(String)OrderDetails.get("LONG_NAME");
				//String  Amd_Freq_Nature				=(String)OrderDetails.get("FREQ_NATURE");
				String  Amd_Tot_Volume				=(String)OrderDetails.get("TOTAL_VOLUME");
				String  Amd_Base_Unit	 			=(String)OrderDetails.get("PRES_BASE_UNIT");
				String  tpn_admin_route             =(String)OrderDetails.get("TPN_ADMIN_ROUTE");
				//added for ML-MMOH-CRF-1012 start
				if(tpn_standard_non_standard){
					 total_daily_fluid				=(String)OrderDetails.get("TOTAL_DAILY_FLUID")==null?"":(String)OrderDetails.get("TOTAL_DAILY_FLUID");
					 enteral_feeding				=(String)OrderDetails.get("ENTERAL_FEEDING")==null?"":(String)OrderDetails.get("ENTERAL_FEEDING");
					 }
				//added for ML-MMOH-CRF-1012 end
				Amd_Tot_Volume=bean.getVolume(order_id);
		%>
	<FORM name="TpnAdmin" id="TpnAdmin">
	
	<div id="ADMIN" name="ADMIN">

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
		<tr>
				<Td   class="label" align="right"><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/></Td>
			   <TD  align="left" colspan=1>&nbsp;

			    <% if (tpn_admin_route.equals("C")){
			   %><SELECT name="infroute" id="infroute" id="infroute" disabled>
					<OPTION value="C" Selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
				<%
			   }else{
				   %>
				   <SELECT name="infroute" id="infroute" id="infroute">
				   <OPTION value="C" Selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
				   <OPTION value="P" Selected><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
				<%
			   }
			   %>
					</SELECT>
				 </TD>
				<!-- <Td   class="label" align="right">Volume</Td>
			   <TD  align="left" class="label" colspan=3>&nbsp;<input type=text onBlur="CheckNum(this);CheckPositiveNumber(this)"  class="number" name="volume" id="volume" maxlength=5 size=5 value="<%=Amd_Tot_Volume%>">&nbsp;<label id='volumeunit' name='volumeunit'><B><%=Amd_Base_Unit%></B><img src="../../eCommon/images/mandatory.gif"></TD> -->
			   <TD>&nbsp;</TD>
			   <Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
				   <% if(infusevalue.equals("")){infuse="24";} else {infuse=infusevalue;} %>
			   <TD class="label"  >&nbsp;<input type=text  name="infuseover" id="infuseover"  maxlength=3 size=5 class="number" onBlur="CheckNum(this);checkInfuse1(this)" value="<%=Amd_Infuse_Over%>"  >&nbsp;<B><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></b></TD>
			   </TR>
			   <TR>
			  <!--  <SELECT name="infuseoverdrn" id="infuseoverdrn" id="infuseoverdrn" >
			   <%// if (infusedurn.equals("H"))			   {
			   %>
					<OPTION value="H" Selected>Hours</OPTION>
					<OPTION value="M">Minutes</OPTION>
				<%//   }
			   //else   {
				   %>
					<OPTION value="H" >Hours</OPTION>
					<OPTION value="M" Selected>Minutes</OPTION>
					<%//   }
			   %>
				   </SELECT> -->
			   				 <% ArrayList freq   = new ArrayList();
				          freq=(ArrayList)bean.getTpnFrequency();
						  String code="";
						  String desc="";
						  String freqNature ="";
						 if(freq.size()!= 0) {
							  for(int r=1;r<freq.size();r++){
							  code=(String)freq.get(0);
							  desc=(String)freq.get(1); 
							  freqNature=(String)freq.get(2);						

							} 
						}
							  %>
				<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> :</td><td class="label" align="left"><B>&nbsp;&nbsp;<%=desc %></b><input type="hidden" name="frequency" id="frequency" value="<%=code %>">
				  </td><td>&nbsp;</td>
	 <!--  <SELECT name="frequency" id="frequency" id="frequency"  onChange="frequencySelect(this)" >
			   <OPTION value="">---Select---</OPTION> -->
		   			   <%   /* for ( i=0;i<freqlist.size();i+=4){
					String code1			=(String)freqlist.get(i);
					String desc1			=(String)freqlist.get(i+1);
					String scheduled		=(String)freqlist.get(i+2);
					String freqnature	=(String)freqlist.get(i+3);  */
					%>
					<script>
					//schedulearr['<%//=code1%>']='<%//=scheduled%>';	
					//freqnaturearr['<%//=code1%>']='<%//=freqnature%>';
					</script>
						<% //if (freqcode.equals(code1)) {%>
							<OPTION selected value="<%//=code1%>"><%//=desc1%></OPTION>
						<%//}else{%>
							<OPTION value="<%//=code1%>"><%//=desc1%></OPTION>
					<%//}}
			   %>

	<!--	   </SELECT><img src="../../eCommon/images/mandatory.gif">   -->

			<Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
			   <%-- <TD  align="left" class="label">&nbsp;<input type=text class="number" name="duration" id="duration" maxlength=2 size=5 onBlur="CheckNum(this);CheckPositiveNumber(this);CheckMaxDuration(this);" value="<%=Amd_Durn_Value%>" readonly >&nbsp;<B><fmt:message key="Common.days.label" bundle="${common_labels}"/></B><img src="../../eCommon/images/mandatory.gif"><label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label></TD> commended for ML-MMOH-CRF-0449(IN057483)--%>
			    <TD  align="left" class="label">&nbsp;<input type=text class="number" name="duration" id="duration" maxlength=2 size=5 onBlur="CheckNum(this);CheckPositiveNumber(this);CheckMaxDuration(this);" value="<%=Amd_Durn_Value%>"  >&nbsp;<B><fmt:message key="Common.days.label" bundle="${common_labels}"/></B><img src="../../eCommon/images/mandatory.gif"><label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label></TD>
			   </tr>
												
			<!-- <Td   class="label" align="right"  nowrap name='scmed' id='scmed'>Schedule Medication</Td>  
				<TD colspan=1 align="left"><INPUT TYPE="checkbox" disabled name="schedulemed" id="schedulemed" id="schedulemed"  onClick="displaySchedule(this)" >		 </TD> -->
			
			   <TR>

				<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="startdate" id="startdate" value="<%=Amd_Start_Date_Time%>" onBlur="DateFormatCheck(this,<%=locale%>);CalculateEndDate(document.TpnAdmin)"  maxlength=16 size=14 disabled ><!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('startdate',null,'hh:mm');document.TpnAdmin.startdate.focus();return false;" disabled >
			     </TD>
				 <TD>&nbsp;</TD>
				<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate" readonly maxlength=16 size=14
			   value="<%=Amd_End_Date_Time%>" disabled></TD>

			</TR>
			<TR>
			<td class="label" align="left">
			 <a href="javascript:getFormatId();"  style="visibility:visible" id="remarks" name="remarks" > &nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			 <!-- added for [IN:039576]-start -->
			         <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
					 <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
					 <input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
					 <!-- added for [IN:039576]-end chandu2222 -->
			<td colspan=3> &nbsp;</td>
			 </TR>
			 <!-- ML-MMOH-CRF-1012 amend start -->
			<% if(tpn_standard_non_standard){ %>
			 <tr>
			 <Td   class="label" align="right"><fmt:message key="ePH.TotalDailyFluid.label" bundle="${ph_labels}"/></Td>
			 <TD  align="left" class="label">&nbsp;<input type=text size="7" maxlength="10"class="number" name="total_daily_fluid" id="total_daily_fluid" value="<%=total_daily_fluid%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif"><label id='totaldailyfluidunit' name='totaldailyfluidunit'><b><fmt:message key="ePH.ml.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.kg.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.day.label" bundle="${ph_labels}"/></b></label>
			 </TD>
			 </tr>
			 <tr>
			 <Td   class="label" align="right"><fmt:message key="ePH.EnteralFeeding.label" bundle="${ph_labels}"/></Td>
			 <TD  align="left" class="label">&nbsp;<input type=text  size="7" maxlength="10"class="number" name="enteral_feeding" id="enteral_feeding" value="<%=enteral_feeding%>" onBlur="CheckNum(this);CheckPositiveNumber(this)" onKeyPress="return allowValidNumber(this,event,5,4)">&nbsp;<img src="../../eCommon/images/mandatory.gif">
			 </tr>
			 <%} %>
			 <!-- ML-MMOH-CRF-1012 amend end-->
			<tr>
			<Td  colspan=6  align="left" >
			<% if (authreqd.equals("Y")){
			%>
				<label id="AuthReqd" class="hyperlink1" onClick="Authorize(this)" ><img  id="AuthReqdimg" src="../../eOR/images/Authorization.gif"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (cosignreqd.equals("Y")){
			%>
			<label class="hyperlink1" onClick="Cosign(this)"   id="CosignReqd" ><img id="CosignReqdimg" src="../../eOR/images/Cosign_click.gif"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (splappreqd.equals("Y")){
			%>
			<label class="hyperlink1" onClick="SplApprove(this)"  id="SplAppReqd"><img id="SplAppReqdimg" src="../../eOR/images/SpecialApproval.gif"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></label>&nbsp;
			<%
			}
			%>
			<% if (consentreqd.equals("Y")){
			%>
			<label  style="font-size:8pt;color:red;font-weight:bold" id="ConsentReqd" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/></label>
			<%
			}
			%>
		</td>
	</TR>
 </table>
	</div>
		<input type=hidden name="Regimen_Code" id="Regimen_Code"			value="<%=regCode%>">
		<input type=hidden name="max_duration" id="max_duration"			value="<%=max_durn%>">
		<input type=hidden name="action_type" id="action_type"			value="<%=action_type%>">
		<input type=hidden name="action_msg" id="action_msg"			value="<%=action_msg%>">
		<input type=hidden name="ordertype_code" id="ordertype_code"		value="<%=ordertypecode%>">
		<input type=hidden name="patient_id" id="patient_id"			value="<%=patient_id%>" >
		<input type=hidden name="encounter_id" id="encounter_id"			value="<%=encounter_id%>">
		<input type=hidden name="location_type" id="location_type"			value="<%=location_type%>">
		<input type=hidden name="location_code" id="location_code"			value="<%=location_code%>">
		<input type=hidden name="pract_id" id="pract_id"				value="<%=pract_id%>" >
		<input type=hidden name="patient_class" id="patient_class"			value="<%=act_patient_class.trim()%>">
		<input type=hidden name="height" id="height"				value="<%=height%>">
		<input type=hidden name="weight" id="weight"				value="<%=weight%>">
		<input type=hidden name="order_date" id="order_date"			value="<%=start_date%>">
		<input type=hidden name="priority" id="priority"				value="<%=priority%>">
		<input type=hidden name="freqNature" id="freqNature"			value="<%=freqNature%>"  >
		<input type=hidden name="authreqdYN" id="authreqdYN"			value="<%=authreqd%>">
		<input type=hidden name="cosignreqdYN" id="cosignreqdYN"			value="<%=cosignreqd%>">
		<input type=hidden name="splappreqdYN" id="splappreqdYN"			value="<%=splappreqd%>">
		<input type=hidden name="consentreqdYN" id="consentreqdYN"			value="<%=consentreqd%>">
		<input type=hidden name="authorizedYN" id="authorizedYN"			value="N">
		<input type=hidden name="cosignedYN" id="cosignedYN"			value="N">
		<input type=hidden name="splappedYN" id="splappedYN"			value="N">
		<input type=hidden name="unitofvolume" id="unitofvolume"			value="<%=unitofvolume%>"	 >
		<input type=hidden name="bean_id" id="bean_id"				value='<%=bean_id%>'>
		<input type=hidden name="bean_name" id="bean_name"				value='<%=bean_name%>'>
		<input type=hidden name="mode" id="mode"					value=<%=mode%>>
		<input type=hidden name="order_id" id="order_id"				value=<%=order_id%>>
        <input type=hidden name="volume" id="volume"			value="">
		<input type=hidden name="volumeunit" id="volumeunit"			value="">
		<input type=hidden name="print_ord_sht_rule_ind" id="print_ord_sht_rule_ind"		value='<%=print_ord_sht_rule_ind%>'><!--Added for Bru-HIMS-CRF-393_1.0-->
		<input type=hidden name="tpn_standard_non_standard" id="tpn_standard_non_standard" value='<%=tpn_standard_non_standard%>'><!-- Added for ML-MMOH-CRF-1012 amend-->
<%}
else if (operation==2)
{
	//String Amd_OrderCatalogCode	="";
	String Amd_Start_Date_Time		="";
	String Amd_End_Date_Time		="";
	String Amd_Freq_Code				="";
	String Amd_Durn_Value				="";
	//String Amd_Durn_Type				="";
	String Amd_Infuse_Over				="";
	String Amd_Infuse_Over_Unit		="";
	String Amd_Isscheduled				="";
	//String Amd_ShortName				="";
	String Amd_Freq_Nature				="";
	//String Amd_Tot_Volume				="";
	//String Amd_Base_Unit				="";
	String disabled							="";
	String tooltip								="";
	ArrayList schtime=new ArrayList();

	//Get values for the given order id
	/* we have to get order details from the bean */
	HashMap  OrderDetails=new HashMap();
	OrderDetails=bean.getAdminDetails();
	if (!OrderDetails.containsKey("ERROR"))
	{
				// Amd_OrderCatalogCode	=(String)OrderDetails.get("ORDER_CATALOG_CODE");
				 Amd_Start_Date_Time		=(String)OrderDetails.get("START_DATE_TIME");
				 Amd_End_Date_Time			=(String)OrderDetails.get("END_DATE_TIME");
				 Amd_Freq_Code				=(String)OrderDetails.get("FREQ_CODE");
				 Amd_Durn_Value				=(String)OrderDetails.get("DURN_VALUE");
				 //Amd_Durn_Type				=(String)OrderDetails.get("DURN_TYPE");
				 Amd_Infuse_Over				=(String)OrderDetails.get("INFUSE_OVER");
				 Amd_Infuse_Over_Unit		=(String)OrderDetails.get("INFUSE_OVER_UNIT");
				 Amd_Isscheduled				=(String)OrderDetails.get("ISSCHEDULED");
				 //Amd_ShortName				=(String)OrderDetails.get("LONG_NAME");
				 Amd_Freq_Nature				=(String)OrderDetails.get("FREQ_NATURE");
				// Amd_Tot_Volume				=(String)OrderDetails.get("TOTAL_VOLUME");
				 //Amd_Base_Unit	 				=(String)OrderDetails.get("PRES_BASE_UNIT");
				//added for ML-MMOH-CRF-1012 start
				 if(tpn_standard_non_standard){
				 total_daily_fluid				=(String)OrderDetails.get("TOTAL_DAILY_FLUID")==null?"":(String)OrderDetails.get("TOTAL_DAILY_FLUID");
			         enteral_feeding                 =(String)OrderDetails.get("ENTERAL_FEEDING")==null?"":(String)OrderDetails.get("ENTERAL_FEEDING");
				}
				//added for ML-MMOH-CRF-1012 end
				 if (OrderDetails.containsKey("SCH_TIME"))
				{
					schtime=(ArrayList)OrderDetails.get("SCH_TIME");	

				}
		}
	if (!Amd_Isscheduled.equals("0")) 
			{
			disabled="disabled";
				tooltip="<TABLE>";
			for ( i=0;i<schtime.size();i+=2)
				{
					tooltip+="<TR><TD class=TIP>"+schtime.get(i)+"</TD><TD class=TIP>"+schtime.get(i+1)+"</TD></TR>";
				}
				tooltip+="</TABLE>";
		}
%>

	<FORM name="TpnAdmin" id="TpnAdmin">
	
	<div id="ADMIN" name="ADMIN">

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
		<tr>
				<Td   class="label" align="right"><fmt:message key="ePH.InfusionRoute.label" bundle="${ph_labels}"/></Td>
			   <TD  align="left" colspan=1>&nbsp;<SELECT name="infroute" id="infroute" id="infroute">
		
					<OPTION value="C" Selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
				   <OPTION value="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
					</SELECT>
				 </TD>
				<Td   class="label" align="right"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label" colspan=3>&nbsp;<input type=text onBlur="CheckPositiveNumber(this)"  class="number" name="volume" id="volume" maxlength=5 size=5 value="<%=totvolume%>">&nbsp;<label id='volumeunit' name='volumeunit'><%=unitofvolume%><img src="../../eCommon/images/mandatory.gif"></TD>
			   </TR>
			   <TR>
				<Td   class="label" align="right"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></Td>
			   <TD  align="left" class="label" colspan=3 >&nbsp;<input type=text name="infuseover" id="infuseover" maxlength=3 size=5 onBlur="CheckPositiveNumber(this)" value="<%=Amd_Infuse_Over%>"  >&nbsp;<SELECT name="infuseoverdrn" id="infuseoverdrn"   id="infuseoverdrn" >
			<% if (Amd_Infuse_Over_Unit.equals("H"))
	  {
	   %>
   					<OPTION value="H" Selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
				   <OPTION value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></OPTION>  
		<%
	  }
	   else if 	 (Amd_Infuse_Over_Unit.equals("M"))
	  {
%>	
				<OPTION value="H" ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
				   <OPTION value="M" Selected><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></OPTION>  

			 <%
	  }
	    %> 
	   </SELECT>   </TD>
			   </TR>
			   <TR>
		 	<Td   class="label" align="right"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></Td>
		   <TD  align="left">&nbsp;<SELECT name="frequency" id="frequency"  <%=disabled%> id="frequency"  onChange="frequencySelect(this)" >
			   <OPTION value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</OPTION>
		   			   <%
				for ( i=0;i<freqlist.size();i+=4)
				{
					String code1			=(String)freqlist.get(i);
					String desc1			=(String)freqlist.get(i+1);
					String scheduled		=(String)freqlist.get(i+2);
					String freqnature	=(String)freqlist.get(i+3);
					%>
					<script>
					schedulearr['<%=code1%>']='<%=scheduled%>';	
					freqnaturearr['<%=code1%>']='<%=freqnature%>';
					</script>
						<% if (Amd_Freq_Code.equals(code1)) {%>
							<OPTION selected value="<%=code1%>"><%=desc1%></OPTION>
						<%}else{%>
							<OPTION value="<%=code1%>"><%=desc1%></OPTION>
					<%}
				}
			   %>

		   </SELECT><img src="../../eCommon/images/mandatory.gif"></TD>

				<Td   class="label" align="right"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text class="number" name="duration" id="duration" maxlength=2 size=5 onBlur="CheckPositiveNumber(this);CheckMaxDuration(this);" value="<%=Amd_Durn_Value%>" <%=disabled%> >&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif"><label id="DurnApproval"	  class="hyperlink1" style="visibility:hidden">&nbsp;<fmt:message key="Common.Approve.label" bundle="${common_labels}"/>&nbsp;</label></TD>
			
			
			</TR>
					<tr>

			
				<% if (!Amd_Isscheduled.equals("0")) 
	  {
%>
				<Td   class="label" align="right" id="scmed" name="scmed"  nowrap	onmouseover="displayamendToolTipDataChange('<%=tooltip%>');" onmouseout="disasbleamendToolTipDataChange();"  style="color:blue;cursor:pointer" ><fmt:message key="ePH.ScheduleMedication.label" bundle="${ph_labels}"/> 	</Td> 

	<%
	  }
	  else
	  {
		  %>

		<Td   class="label" align="right" id="scmed" name="scmed" 		><fmt:message key="ePH.ScheduleMedication.label" bundle="${ph_labels}"/>
		</Td> 
		  <% 

	  }
	  %>
			
			
			<TD colspan=1 align="left"><INPUT TYPE="checkbox"  name="schedulemed" id="schedulemed" id="schedulemed"  onClick="displaySchedule(this)" <%=disabled%> >		 </TD>
			<td class="label" align="left">
			 <a href="javascript:getFormatId();" style="visibility:visible" id="remarks" name="remarks" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			            <!-- added for [IN:039576]-start -->
			            <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></Td>
						<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
						<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
						<!-- added for [IN:039576]-end chandu -->
			<td> &nbsp;</td>
							   </TR>
			   <TR>
				<Td   class="label" align="right"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="startdate" id="startdate" <%=disabled%> value="<%=Amd_Start_Date_Time%>" onBlur="DateFormatCheck(this,<%=locale%>);CalculateEndDate(document.TpnAdmin)"  maxlength=16 size=14 ></TD> <!-- added locale variable into DateFormatCheckfor [IN:031523]  -->
				<Td   class="label" align="right" ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></Td>
			   <TD  align="left" class="label">&nbsp;<input type=text name="enddate" id="enddate" readonly maxlength=16 size=14
			   <%=disabled%> value="<%=Amd_End_Date_Time%>"></TD>

			</TR>
			<tr>
			<Td  colspan=6  align=left >
			</td>
	</TR>


		</table>
	</div>
		<input type=hidden name="Regimen_Code" id="Regimen_Code"		value="<%=regCode%>">
		<input type=hidden name="max_duration" id="max_duration"		value="<%=max_durn%>">
		<input type=hidden name="action_type" id="action_type"			value="<%=action_type%>">
		<input type=hidden name="action_msg" id="action_msg"			value="<%=action_msg%>">
		<input type=hidden name="ordertype_code" id="ordertype_code"	value="<%=ordertypecode%>">
		<input type=hidden name="patient_id" id="patient_id"			value="<%=patient_id%>" >
		<input type=hidden name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
		<input type=hidden name="location_type" id="location_type"		value="<%=location_type%>">
		<input type=hidden name="location_code" id="location_code"		value="<%=location_code%>">
		<input type=hidden name="pract_id" id="pract_id"				value="<%=pract_id%>" >
		<input type=hidden name="patient_class" id="patient_class"		value="<%=act_patient_class.trim()%>">
		<input type=hidden name="height" id="height"					value="<%=height%>">
		<input type=hidden name="weight" id="weight"					value="<%=weight%>">
		<input type=hidden name="order_date" id="order_date"			value="<%=start_date%>">
		<input type=hidden name="priority" id="priority"				value="<%=priority%>">
		<input type=hidden name="freqNature" id="freqNature"	value='<%=Amd_Freq_Nature%>'  >
		<input type=hidden name="authreqdYN" id="authreqdYN"		 value="<%=authreqd%>">
		<input type=hidden name="cosignreqdYN" id="cosignreqdYN"	 value="<%=cosignreqd%>">
		<input type=hidden name="splappreqdYN" id="splappreqdYN"	 value="<%=splappreqd%>">
		<input type=hidden name="consentreqdYN" id="consentreqdYN"	 value="<%=consentreqd%>">
		<input type=hidden name="authorizedYN" id="authorizedYN"	   value="N">
		<input type=hidden name="cosignedYN" id="cosignedYN"	   value="N">
		<input type=hidden name="splappedYN" id="splappedYN"	   value="N">
		<input type=hidden name="unitofvolume" id="unitofvolume"  value="<%=unitofvolume%>"	 >
		<input type=hidden name="bean_id" id="bean_id"		value='<%=bean_id%>'>
		<input type=hidden name="bean_name" id="bean_name"	value='<%=bean_name%>'>
		<input type=hidden name="mode" id="mode"			value=<%=mode%>>
		<input type=hidden name="orderid" id="orderid"			value=<%=orderid%>>
		<input type=hidden name="print_ord_sht_rule_ind" id="print_ord_sht_rule_ind"		value='<%=print_ord_sht_rule_ind%>'><!--Added for Bru-HIMS-CRF-393_1.0-->
		<label id="tool_tip" style="visibility:hidden"></label>
		
<%}
%>
		<input type=hidden name="Regimen_Desc" id="Regimen_Desc"	value="">
		<input type=hidden name="high_carbo_concentration" id="high_carbo_concentration"	value="<%=high_carbo_concentration%>">
</FORM>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute;z-index:10; width:20%; visibility:hidden;" bgcolor="blue">
		<table id="tooltiptable" style="z-index:10" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
		<tr><td width="100%" id="t"></td></tr></div> 

<% if (operation==1) 
{
	%>
<script>frequencySelect(document.TpnAdmin.frequency)</script>
<%
}
if (!mode1.equals("amend")) {
%>
<script>
	parent.parent.parent.parent.frames[0].prescription_header_form.height.readOnly = true;
	parent.parent.parent.parent.frames[0].prescription_header_form.weight.readOnly = true;
</script>
<%}%>
<script>
getFormatId('N');//  added for [IN:039576]
</script>
<INPUT TYPE="hidden" name="tpn_tab_reg" id="tpn_tab_reg" value="<%=tpn_tab_reg%>"><!-- added for ml-mmoh-crf-1290 -->
</body>
<% 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
%>
</html>

