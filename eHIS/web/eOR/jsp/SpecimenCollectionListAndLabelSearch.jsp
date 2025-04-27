<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
19/12/2011    IN30055      Menaka V 	    Incident No: IN30055 - <Manage specimen screen: In the Operator field-
											the list item "View Dispatch"  is no longer available in the drop down list which needs to be restored (function was earlier in 5.x but now may have been altered or not available in 10.x) > 
03/02/2012	  IN:030168	   VIJAY R			introduced new filter parameter 'ordering practitiner' in manage specimens page, search functionality.			
28/04/2014	  IN048703	   Nijitha S		GHL-SCF-807
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------------------------
29/08/2014	IN049737	   	Chowminya	 							MMS-CRF-194.1 Unbilled services will be regrouped into a new order
06/10/2015	IN055737		Karthi L								IN055737 HSA-CRF-0250.1 - Dispatch Slip
09/01/2017	IN061888		Karthi L								To record collection all at 1 go
26/07/2017	IN064835		Vijayakumar K									ML-MMOH-CRF-0578.1 [IN:064835]		
19/10/2017	IN065324		Dinesh T		19/10/2017	Ramesh G	To display the price in OR screen and the billing 																				status in Manage Specimen screen
08/07/2020  IN072184        Chandrashekar raju                 		Modified for MMS-DM-CRF-0157.2
02/11/2022  34898           Krishna Pranay  03/11/2022  Ramesh G    TH-KW-CRF-0020.5
--------------------------------------------------------------------------------------------------------------------------------
--> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
boolean isBTViewBillDtls = false;//IN065324
String btViewBillDtls = "";//IN065324

try
{
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> 
	
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<!--  added for  IN055737 HSA-CRF-0250.1 - Start -->
	<script type="text/javascript">     
    	function callBarCodeSearch(obj){    	   
    		if(window.event.keyCode==13 && obj.value!=""){
    			specimenBarCodeSearch();
    		  	if(document.forms[0].print_loc_desc.value != "") {
    		   		obj.select();
    	   		} else {
    	   			obj.value = "";
    	   		}
       		}
       }
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--  added for  IN055737 HSA-CRF-0250.1 - End -->

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
 
/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_SpecimenOrder" ;
	String bean_name = "eOR.SpecimenOrder";

	String practitioner_id = (String)session.getValue("or_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String userid = (String)session.getAttribute("login_user") == null ? "" : (String)session.getAttribute("login_user"); //Ramesh
	//String templocale=localeName;
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";
/* Mandatory checks end */

	/* Initialize Function specific start */
	SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setSiteSpecificYN("SPECIMEN_REGISTER_ORDER");//IN064835

	int patient_id_length = bean.getPatientIdLength();
	String disabled		   = "";
	String p_function_from = request.getParameter( "p_function_from" ) ;
	if(p_function_from==null) p_function_from = "";

	String p_patient_id = request.getParameter( "p_patient_id" ) ;
	if(p_patient_id==null) p_patient_id = "";
	String p_start_date_time = request.getParameter( "p_start_date_time" ) ;
	if(p_start_date_time==null) p_start_date_time = "";
 	String p_order_id = request.getParameter( "p_order_id" ) ;
	if(p_order_id==null) p_order_id = "";
	String p_encounter_id = request.getParameter( "p_encounter_id" ) ;
	if(p_encounter_id==null) p_encounter_id = "";
	if(p_function_from!=null && p_function_from.equals("CP"))
		disabled		   = "DISABLED";
	String options="";
	if(p_function_from!=null && p_function_from.equals("CP"))
	{
		options=bean.checkForNull(request.getParameter("options"));
	}
	String p_option_id =  (bean.checkForNull(request.getParameter("option_id"))); //ML-MMOH-CRF-0540 [IN061888]
 	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}
	/*Thai date validations 15/02/2007 start */
	if(last_week_date.equals("null") || (last_week_date.equals(" "))) last_week_date="";
	if(curr_week_date.equals("null") || (curr_week_date.equals(" "))) curr_week_date="";
	if(curr_sys_date.equals("null") || (curr_sys_date.equals(" "))) curr_sys_date="";
	if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMYHM","en",localeName);
	curr_week_date = com.ehis.util.DateUtils.convertDate(curr_week_date,"DMYHM","en",localeName);
	curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
	}
	Boolean bar_code_scan_site=false;
	boolean  quePki_SiteSpecific =false; //34898
	String  pkiSiteSpecificYN="N"; //34898
	try{
	Connection con 		= null;//Added for IN072184
	con = ConnectionManager.getConnection(request);//Added for IN072184
	bar_code_scan_site = CommonBean.isSiteSpecific(con, "AM", "BARCODE_SCANNING_APPLICABLE");//Added for MMS-DM-CRF-157.2
	quePki_SiteSpecific =CommonBean.isSiteSpecific(con, "OR", "QUE_PKI_APPLIC_SPECIMEN");  //34898
	}catch(Exception e){
		e.printStackTrace();
	}finally{//Added for IN072184
	  //if (con!=null) ConnectionManager.returnConnection(con,request);
}
	//34898 Start.
	if(quePki_SiteSpecific && "SPECIMEN_REGISTER_ORDER".equals(p_option_id)){
		pkiSiteSpecificYN="Y";
	}
	//34898 End.
	String bar_code_scan_site_YN = "";
//Adding start forIN072184
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
//Ading end for IN072184

	/*Thai date validations 15/02/2007 end */
	ArrayList orderType=bean.getOrderTypeSpecimen();

	ArrayList facilityDetails = bean.getFacilityDetails();
	//IN064835 starts
	ArrayList reRoutePrinters = null;
	if(bean.isSiteSpecificYN())
	{
		reRoutePrinters = bean.getReRoutePrinters();//IN064835
	}
	//IN064835 ends
	ArrayList behindDetails = bean.getSpecimenBehindDetails();
	String rd_instal_yn		= bean.getInstallYn("RD",facility_id);  // for RD Instal
	String ot_instal_yn		= bean.getInstallYn("OT",facility_id);  // for RD Instal
	if(rd_instal_yn==null) rd_instal_yn = "N";
	if(ot_instal_yn==null) ot_instal_yn = "N";
	String behind_date = "";
	String ahead_date  = "";
	String specimen_collect_hrs_behind  = "";
	String specimen_collect_hrs_ahead  = "";
	//IN049737 - Start
	String disCheck = "N";
	disCheck = bean.getFunctiondtl();
	//IN049737 - End
	// added for  IN055737 HSA-CRF-0250.1 - Start
	String isBarCodeSearchConfigEnabled = "";
	isBarCodeSearchConfigEnabled = bean.getBarcodeSearchConfigValue();	
	if("Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) {
		bean.removeAllClonedPatientDispSlipRecords(); 
	} 
	//added for IN055737 HSA-CRF-0250.1 - End
	if (behindDetails.size() > 0) 
	{
		if (behindDetails.get(0) != null)
			behind_date = (String) behindDetails.get(0);
	   	if (behindDetails.get(1) != null)
	   		ahead_date  = (String) behindDetails.get(1);
		if (behindDetails.get(2) != null)
	   		specimen_collect_hrs_behind  = (String) behindDetails.get(2);
		if (behindDetails.get(3) != null)
	   		specimen_collect_hrs_ahead  = (String) behindDetails.get(3);
		/*Thai date validations 15/02/2007 start */
		if (behind_date.equals(" ") || behind_date.equals("null")) behind_date=""; 
		if (ahead_date.equals(" ") || ahead_date.equals("null")) ahead_date=""; 
		if(!localeName.equals("en")){
		behind_date =  com.ehis.util.DateUtils.convertDate(behind_date,"DMYHM","en",localeName);
		ahead_date =  com.ehis.util.DateUtils.convertDate(ahead_date,"DMYHM","en",localeName);
		}
		/*Thai date validations 15/02/2007 end */
	}

	String l_calling_from = bean.checkForNull(request.getParameter("calling_from"),"");//IN065324

	//IN065324, starts
	if("TASK_LIST".equals(l_calling_from))
	{
		btViewBillDtls =  bean.checkForNull(request.getParameter("isBTViewBillDtls"),"");	
		
		if(!btViewBillDtls.equals(""))
			isBTViewBillDtls = new Boolean(btViewBillDtls).booleanValue();

		bean.setSiteSpecificDtls("BT_VIEW_BILL_DTLS");
	}
	else
	{
		bean.setSiteSpecific("BT_VIEW_BILL_DTLS");
	}
	//IN065324, ends

/* Initialize Function specific end */

%>
<form name='specimen_order_search' id='specimen_order_search' target='messageFrame' >

<table cellpadding=3 cellspacing=0 border='0'  width="100%"  align=center  >
	<TR>
		<TD class='label' ><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></TD>
		<TD class='fields' >
			<Select id="ordering_facility" name='ordering_facility' id='ordering_facility' <%=disabled%>>
				<Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
				<%	for (int i=0;i<facilityDetails.size();i++) {
					String [] facility = (String[])facilityDetails.get(i);
				%>
				<Option value='<%=facility[1]%>' <%=(facility_id.equals(facility[1]) ? "selected" : "")%>><%=facility[0]%></Option>
				<%}%>
			</Select>
		</TD>
	   <TD class='label' ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></TD>
	   <TD class='fields' colspan=4>
			<Select name='performing_facility' id='performing_facility' <%=disabled%>>
			<Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<%	for (int i=0;i<facilityDetails.size();i++) {
				String [] facility = (String[])facilityDetails.get(i);
			%>
			<Option value='<%=facility[1]%>' <%=(facility_id.equals(facility[1]) ? "selected" : "")%>><%=facility[0]%></Option>
		   <%}%>
			</Select>
		</TD>
	</TR>
	<tr>
        <td class=label ><fmt:message key="Common.Operator.label" bundle="${common_labels}"/></td>
		<td class='fields' >
			<select name='option_list' id='option_list' <%=disabled%> onchange='changeOption(this);updatePeriod();'><!--added updatePeriod method for IN048703 -->
							<option value='N' <%=(options.equals("N"))?"selected":""%>><fmt:message key="eOR.NewList.label" bundle="${or_labels}"/></option>
							<!--<option value='R'><fmt:message key="eOR.Reprint.label" bundle="${or_labels}"/></option>-->
							<option value='C' <%=(options.equals("C"))?"selected":""%>><fmt:message key="eOR.RecordCollection.label" bundle="${or_labels}"/></option>
							<option value='D'<%=(options.equals("D"))?"selected":""%>><fmt:message key="eOR.RecordDispatch.label" bundle="${or_labels}"/></option>
							<option value='R'><fmt:message key="eOR.ReprintSpecimen.label" bundle="${or_labels}"/></option>
							<option value='S'><fmt:message key="eOR.ReprintDispatchSlip.label" bundle="${or_labels}"/></option>
							<option value='V'><fmt:message key="eOR.ViewAfterDispatchSlip.label" bundle="${or_labels}"/></option><!-- IN30055 Starts-->
			</select>
		</td>
		<%	if( (rd_instal_yn!=null && rd_instal_yn.equals("Y")) || (ot_instal_yn!=null && ot_instal_yn.equals("Y")))  { %>
		<TD class="label"  ><fmt:message key="eOR.DeptLocation.label" bundle="${or_labels}"/></td>
		<td class="fields" >
			<Select name='ordered_location' id='ordered_location' onChange='populateOrderSelection(this)' <%=disabled%>>      	<Option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</Option>
			<%	if(rd_instal_yn!=null && rd_instal_yn.equals("Y")) { %>
    		<option value='W'><fmt:message key="eOR.Wing.label" bundle="${or_labels}"/></option>
			<%} %>
			<%if(ot_instal_yn!=null && ot_instal_yn.equals("Y")) { %>
    			<option value='O'><fmt:message key="eOR.OperatingTheatre.label" bundle="${or_labels}"/></option>
			<%} %>
    		</select>
			<input type="text" value='' name="ordered_location_val_desc" id="ordered_location_val_desc" onblur='populateOrderLocation1(ordered_location_val_desc,ordered_location_val);' disabled style="width:100px"><input type=button name="orderedSearch" id="orderedSearch" value='?'  class=button tabIndex="4" onClick="populateOrderLocation(ordered_location_val_desc,ordered_location_val);" disabled><input type="hidden" name="ordered_location_val" id="ordered_location_val" value="">
    		<!--<select name='ordered_location_val' id='ordered_location_val' <%=disabled%>>
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			</select>-->
		</TD>
<%		} else {  %>
			<td class="label" >&nbsp;</td>
			<td class="label" >
				<input type="hidden" name="ordered_location" id="ordered_location" value="">
				<input type="hidden" name="ordered_location_val" id="ordered_location_val" value="">
			</td>
<%		}	%>

	</tr>
	<tr>
		<TD class=label ><fmt:message key="eOR.MovementLocation.label" bundle="${or_labels}"/></TD>
		<td class=fields >
			<SELECT name="location_type" id="location_type" onChange='populateLocation(this)' <%=disabled%>>
				<option value='' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C' ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value='R' ><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
			</SELECT>
			<input type="text" value='' name="locn" id="locn" onblur='populateMoveLoaction1(locn,locn_code);' disabled>
			<input type=button name="SourceSearch" id="SourceSearch" value='?'  class=button tabIndex="4" onClick="populateMoveLocation(locn,locn_code);" disabled>
			<input type="hidden" name="locn_code" id="locn_code" value="">
			<input type="hidden" name="locn_code1" id="locn_code1" value="">
		</td>
		<td class=label ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='fields' >
			<select name="order_type" id="order_type" <%=disabled%>>
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<%  if(orderType.size()>0){
						for(int i=0;i<orderType.size();i++){
							String[] ordertype = (String[])orderType.get(i);
				%>
				<option value="<%=ordertype[0]%>" ><%=ordertype[1]%></option>
				<%
						}
					}
				%>
			</select>
		</td>
	</tr>
	<tr>
		<TD class='label' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD class='fields' >
			<Select name='status' id='status' <%=disabled%>>
				<Option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
				<Option value='F'><fmt:message key="Common.Future.label" bundle="${common_labels}"/></Option>
				<Option value='D'><fmt:message key="Common.Due.label" bundle="${common_labels}"/></Option>
				<Option value='O'><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></Option>
			</Select>
		</TD>
   		<td class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class="fields" >
			<SELECT name="priority" id="priority" <%=disabled%>>
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>        		
	</tr>
	<tr>
		<td  class=label id='patientId_lbl_td' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class=fields id='patientId_td' >
			<input type='text' id="patientId" name='patientId' id='patientId' value="<%=p_patient_id%>" onkeydown ='barcodeScan(event,this)' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength='<%=patient_id_length%>' <%=disabled%>><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()" <%=disabled%>>
			<!-- onkeydown ='barcodeScan(event,this)' added for IN072184-->
			<%
			//34898 Start.
			if("Y".equals(pkiSiteSpecificYN)){%>
			<img id="patientIdManImage" name="patientIdManImage" src='../../eCommon/images/mandatory.gif'/>
			<%}
			//34898 End.
			%>
		</td>		
		<td class=label id='encounter_lbl_td' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class=fields id='encounter_id_td' >
			<input type=text id="encounter_id" name='encounter_id' id='encounter_id' size="12" maxlength="12" onKeyPress="return(ChkNumberInput(this,event,'0'))" value="<%=p_encounter_id%>"   <%=disabled%>>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class=fields > 
			<%//if(!p_function_from.equals("CP")){
			p_start_date_time = (behind_date.equals("")?curr_week_date:behind_date);
			//}%><!-- <input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="<%=p_start_date_time%>" onBlur="checkValidDateTime(this)" <%=disabled%>> --><input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="<%=p_start_date_time%>" onBlur="validDateObj(this,'DMYHM','<%=localeName%>')" <%=disabled%> style="width:100px"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from',null,'hh:mm',true);" style='cursor:pointer' <%=disabled%>>
			<input type=text name='date_to' id='date_to'  size=16 maxlength=16 value="<%=(ahead_date.equals("")) ? last_week_date : ahead_date%>" onBlur="validDateObj(this,'DMYHM','<%=localeName%>')" <%=disabled%> style="width:100px"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to',null,'hh:mm',true);" style='cursor:pointer' <%=disabled%>>
		</td>
		<TD id="location_id" class=label ><fmt:message key="eOR.PrintLocation.label" bundle="${or_labels}"/></TD>
		<td class=fields  id='print_location_type'>
			<SELECT name='loctype' id='loctype' onChange='populatePrintLocation(this,"SEARCH")'>
				<option value='' >-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-</option>
				<option value='C' ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</SELECT>
			<input type="text" value='' name="print_loc_desc" id="print_loc_desc" onblur='populatePrintLoaction1(print_loc_desc,print_loc);'>
			<input type=button name="PrintSearch" id="PrintSearch" value='?'  class=button tabIndex="4" onClick="populatePrintLoaction(print_loc_desc,print_loc);" disabled><img src="../../eCommon/images/mandatory.gif" align=center style='visibility:hidden' id='imgmand'>
			<input type="hidden" name="print_loc" id="print_loc" value="">
		</td>		
  	</tr>
	<tr>
		<td class=label id='specimen_no_lbl_td'  ><fmt:message key="eOR.SpecimenNo.label" bundle="${or_labels}"/></td>
		<% if("Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) { %>
			<td class=fields id='specimen_no_td'  ><input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16' onBlur = "" onKeyUp="callBarCodeSearch(this)" onKeyPress='return(ChkNumberInput(this,event,"0"))' ></td>
		<%} else { %>
			<td class=fields id='specimen_no_td'  ><input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16' onKeyPress='return(ChkNumberInput(this,event,"0"))'></td>
		<%
		}	
		%>
		<td class=label ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=fields ><input name='order_id' id='order_id' type=text size="15" maxlength="15" value="<%=p_order_id%>"  <%=disabled%> onKeyPress='return CheckForSpecChars(event)' <%=disabled%>></td>
	</tr>	
	<!-- [IN:030168] Start -->
	<tr>
		<!-- <td colspan=1></td><td colspan=2></td> -->
		<td class=label id='ord_pract_lbl_td'  ><fmt:message key="eOR.OrderingPractitioner.label" bundle="${or_labels}"/></td>
		<td class='fields' ><input type="text" name="ordering_pract_desc" id="ordering_pract_desc" value="" onblur='callpractSearchSpecimenSearch1(ordering_pract_desc,ordering_pract);'><input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="callpractSearchSpecimenSearch(ordering_pract_desc,ordering_pract);"><input type="hidden" name="ordering_pract" id="ordering_pract" value=""></td>
		<!-- IN064835 starts -->
		<%if(bean.isSiteSpecificYN())
		{
		%>
		<TD class='label' id='reroute_printer_lbl_td'  style='display:none'><fmt:message key="eOR.ReRoutePrinter.label" bundle="${or_labels}"/></TD>
		<TD class='fields' id='reroute_printer_opt_td'  style='display:none'>
			<Select name='reroutePrinter' id='reroutePrinter' <%=disabled%>>
			<Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<%for (int i=0;i<reRoutePrinters.size();i++) {
			  String [] printer = (String[])reRoutePrinters.get(i);
			%>
			<Option value='<%=printer[1]%>' ><%=printer[0]%></Option>
			<%}%>
			</Select>
		</TD>
		<%
		}else{
		%>
		<td class=label >&nbsp;</td>
		<td class=label >&nbsp;</td>
		<%}%>
			<!-- IN064835 ends -->
	</tr>
	<!-- [IN:030168] End -->	
	<tr>		
		<td class=label id="id_collection" ><fmt:message key="eOR.CollectionList.label" bundle="${or_labels}"/></td>
		<td class="fields" id='id_collection_chk' >
			<input name=collection_list1 id=collection_list1 type='checkbox' value='N' onClick="setCollection(this);" >
			<input name=collection_list id=collection_list type='hidden'  value='N'>
		</td>
		<td  class=label  id='coll_list_date_time_lbl_td' ><fmt:message key="eOR.AutoUpdateCollectionDateTime.label" bundle="${or_labels}"/></td>
		<td  class=fields id='coll_list_date_time_td' >
			<input name=collection_list_date_time1 id=collection_list_date_time1 type='checkbox' value='N' onClick="setAutoUpdateCollection(this);" >
			<input name=collection_list_date_time id=collection_list_date_time type='hidden' value='N'>
		</td>
	</tr>
	<tr>
			<%if("Y".equals(pkiSiteSpecificYN)){%>
			<td class=label id="quepkiRow"><fmt:message key="eOR.QuePkiCode.label" bundle="${or_labels}" /></td>
			<td class=fields id="quepkiRow1"><input id='quePkiId' name='quePkiId' id='quePkiId' type=text size="25" value='' onBlur="getQUEPKICode(this)"></td>
			<%}else{%>
			<td class=label >&nbsp;</td>
			<td class=label >&nbsp;</td>
			<%}%>
			<td class=label></td>
			<td class='button' style="text-align:right;">
			<input type=button class=button name='search_btn' id='search_btn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='populateValues()'>
			<%if( !p_function_from.equals("CP")) { %>
			<input type=button name='clear' id='clear' class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'>
			<%}%>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<%if("Y".equals(pkiSiteSpecificYN)){%>
	<tr id="quePkiIdRow2">			
		<td class=label colspan=2 id="quePkiIdMessage">&nbsp;</td>
		<td class=label></td>
		<td class=fields></td>
	</tr>
	<%}%>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="behind_date" id="behind_date" value="<%=behind_date%>">
<input type="hidden" name="ahead_date" id="ahead_date" value="<%=ahead_date%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="language" id="language" value="<%=localeName%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="seq_no" id="seq_no" value="">
<input type="hidden" name="specimen_date_time" id="specimen_date_time" value="">
<input type="hidden" name="specimen_remarks" id="specimen_remarks" value=">">
<input type="hidden" name="collected_by" id="collected_by" value="">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="referral_sql" id="referral_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_R")%>">
<input type="hidden" name="location_sql" id="location_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_FORWARD_PRACT_SELECT_LOOKUP")%>">
<input type="hidden" name="wing_sql" id="wing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_LOCATION_ORDER_WING")%>">
<input type="hidden" name="theatre_sql" id="theatre_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_LOCATION_ORDER_THEATRE")%>">
<input type="hidden" name="p_function_from" id="p_function_from" value="<%=p_function_from%>">
<input type="hidden" name="specimen_collect_hrs_behind" id="specimen_collect_hrs_behind" value="<%=specimen_collect_hrs_behind%>">
<input type="hidden" name="specimen_collect_hrs_ahead" id="specimen_collect_hrs_ahead" value="<%=specimen_collect_hrs_ahead%>">
<input type="hidden" name="specimen_Orderby_pract" id="specimen_Orderby_pract" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_AM_PRACT")%>">
<input type="hidden" name="disCheck" id="disCheck" value="<%=disCheck%>"><!-- IN049737 -->
<input type="hidden" name="isBarCodeSearchConfigEnabled" id="isBarCodeSearchConfigEnabled" value="<%=isBarCodeSearchConfigEnabled%>"><!-- added for IN055737 HSA-CRF-0250.1 -->
<input type="hidden" name="option_id" id="option_id" value="<%=p_option_id%>"><!-- ML-MMOH-CRF-0540 [IN061888] -->
<input type="hidden" name="bar_code_scan_site_YN" id="bar_code_scan_site_YN" value="<%=bar_code_scan_site_YN%>"><!-- IN072184 -->
<input type=hidden name='bar_code_scaned_YN' id='bar_code_scaned_YN' value=''><!--Added for IN072184-->
<input type=hidden id='pkiSiteSpecificYNOrg' name='pkiSiteSpecificYNOrg' id='pkiSiteSpecificYNOrg' value='<%=pkiSiteSpecificYN%>'><!--Added for -->
<input type=hidden id="pkiSiteSpecificYN" name="pkiSiteSpecificYN" id="pkiSiteSpecificYN" value="<%=pkiSiteSpecificYN%>"/>
<input type=hidden id="quePkiStatus" name="quePkiStatus" id="quePkiStatus" value="E"/>
<input type=hidden id="quePkiStatusText" name="quePkiStatusText" id="quePkiStatusText" value="User missed entering primary key of queue no"/>	
<input type=hidden id="quePkiToken" name="quePkiToken" id="quePkiToken" value=""/>
<input type=hidden id="quePkiNumber" name="quePkiNumber" id="quePkiNumber" value=""/>
<input type=hidden id="quePkiIsueDateTime" name="quePkiIsueDateTime" id="quePkiIsueDateTime" value=""/>
<input type=hidden id="quePkiCallDateTime" name="quePkiCallDateTime" id="quePkiCallDateTime" value=""/>	
<input type=hidden id="userId" name="userId" id="userId" value="<%=userid%>"/>
</form>
<%	
if(p_function_from!=null && p_function_from.equals("CP") &&"N".equals(pkiSiteSpecificYN))  //Added pkiSiteSpecificYN 34898
{ 
%>
	<Script>populateValues();</script> 
	<Script>enableDisableCollectionList();</script> 

<% 
} 
%>
<Script>enableDisableSpecNo();</script> 
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

