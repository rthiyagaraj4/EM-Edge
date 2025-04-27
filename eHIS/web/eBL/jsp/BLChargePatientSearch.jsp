
<%-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523            MOHE-CRF-0060       		Shikha Seth
2            V210203            13523            MOHE-CRF-0060       		Shikha Seth
3			 210720			    21718			 MOHE-SCF-0125-TF	    	Mohana Priya K
--------------------------------------------------------------------------------------------------------
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ page import="eBL.Common.BlRepository"%>
 
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javaScript" src='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eBL/js/BLChargePatient.js"></script>
<script language="javascript" src="../../eBL/js/BLChargePatientSearch.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <link rel="stylesheet" type="text/css"	href="../../eBL/html/ui.dropdownchecklist.css" /> 
<link rel="stylesheet" type="text/css" href="../../eBL/html/main.css" />  -->
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<!--<script language="javascript" src="../../eBL/js/ui.core.js"></script>
<script language="javascript" src="../../eBL/js/ui.dropdownchecklist.js"></script>-->
<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
    	$("#pageredirect").hide();
         // $("#payer_group").dropdownchecklist({ firstItemChecksAll: false, maxDropHeight: 100 });   
         // $("#episode_type").dropdownchecklist({ firstItemChecksAll: false, maxDropHeight: 100 });
         $('#reset').click(function(){
        	 resetValues();
         });
  
         if($('#episode_type').val() == 'R'){
        	 $('.mandHide1').show();
         }else{
        	 $('.mandHide1').hide();
         }

         if($('#funct_name').val() == 'BillGeneration'){
        	 $(parent.document).find('#SearchPatientFrame').attr('rows','42%,58%,0%');
        	 $('#forBillGeneration').show();
        	 fnAutoFillLoadCriteria('EBL_TRAN_BILL_GEN');
        	 episodeOption($('#episode_type').get(0));
        	 fnAutoFillLoadCriteria('EBL_TRAN_BILL_GEN');
         }
         else if($('#funct_name').val() == 'depositandrefund')
         {
        	 
			fnAutoFillLoadCriteria('EBL_DEP_REFUND');
			
	  	 if($("#episode_type").val()=='R')
	  		 {
	  		 	$("#pageredirect").show();
	  		 
	  		 }
	  	 else
	  		 {
	  			$("#pageredirect").hide();
	  		 }

 $('#episode_type').change(function(){
        	 
        	 if($(this).val() == 'R'){
        		$('#pageredirect').show();
        		 $('.mandHide').hide();
        		 $('.mandHide1').show();
        		 $('#hide_this_row').hide();
        		 $('#encounter_period').val('S');
        		 $('#encounter_period').attr("disabled","disabled");
        	 }
        	 else{
         		// alert('else check');
         		 $('.mandHide').show();
         		$('.mandHide1').hide();
         		 $('#pageredirect').hide();
         		 if($('#encounter_period').val() == 'P'){
         			$('#hide_this_row').show();  
         		 }
         		 $('#encounter_period').removeAttr("disabled","disabled");
         	 }
          });
         
         
         }
         else{
        	 fnAutoFillLoadCriteria('EBL_TRAN_EXISTING_ORDER');
         }
         
         if($('#encounter_from_date').val() == ''){
    		 $('#encounter_from_date').val($('#backDate').val())
    	 }
    	 if($('#encounter_to_date').val() == ''){
    		 $('#encounter_to_date').val($('#todaysDate').val())
    	 }
         
         if($('#encounter_period').val() == 'P'){
        	 $('#hide_this_row').show();        	
         }
         
         $('#episode_type').change(function(){
        	 
        	 if($('#funct_name').val() == 'depositandrefund')
             {
        		 if($("#episode_type").val()=='R')
    	  		 {
    	
    	  		 	$("#pageredirect").show();
    	  		 
    	  		 }
    	  	 else
    	  		 {
    	  			$("#pageredirect").hide();
    	  		 }
         
             } 
        	 if($(this).val() == 'R'){
        		 $('.mandHide').hide();
        		 $('.mandHide1').show();
        		 $('#hide_this_row').hide();
        		 $('#encounter_period').val('S');
        		 $('#encounter_period').attr("disabled","disabled");
        		 $('#episode_status').val('S');
        		 $('#episode_status').attr("disabled","disabled");
        	 }
        	 else{
        		 $('.mandHide').show();
        		 $('.mandHide1').hide();
        		 if($('#encounter_period').val() == 'P'){
        			$('#hide_this_row').show();  
        		 }
        		 $('#encounter_period').removeAttr("disabled","disabled");
         		 $('#episode_status').removeAttr("disabled","disabled");
        	 }
			if($('#funct_name').val() == 'BillGeneration'){
        		 episodeOption($('#episode_type').get(0));
        	 }
         });
         
         if($('#episode_type').val() == 'R'){
    		 $('.mandHide').hide();
    		 $('.mandHide1').show();
    		 $('#hide_this_row').hide();
    		 $('#encounter_period').val('S');
    		 $('#encounter_period').attr("disabled","disabled");
    	 }
         
         if($('#patient_name_cond').val() == '' || $('#patient_name_cond').val() == null){
        	 $('#patient_name_cond').val('S')
         }
         if($('#doctor_name_cond').val() == '' || $('#doctor_name_cond').val() == null){
        	 $('#doctor_name_cond').val('S')
         }
         if($('#payer_cond').val() == '' || $('#payer_cond').val() == null){
        	 $('#payer_cond').val('S')
         }
         if($('#policy_cond').val() == '' || $('#policy_cond').val() == null){
        	 $('#policy_cond').val('S')
         }
         if($('#contact_no_cond').val() == '' || $('#contact_no_cond').val() == null){
        	 $('#contact_no_cond').val('S')
         }
       //V210203 start          
       if($('#siteSlmtAcrossFacilityYN').val() == "Y" && $('#funct_name').val() == 'BillGeneration') {    	   
         $('#facilityid').val($('#facility_id').val()) ;         
         getFacility('',$('#facilityid').val(),1);      
       } else {
    	   $('#facilityid').val("**");          
       }
         //V210203 end
     });
    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterId="";
	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String contact_legend="";
	con	=	ConnectionManager.getConnection(request);
	//V210203 start    
	boolean siteSlmtAcrossFacility = false;
	String siteSlmtAcrossFacilityYN ="N";	
	//V210203 end    
	try{
		pstmt=con.prepareStatement("SELECT SHORT_DESC FROM MP_CONTACT_MODE WHERE CONTACT_MODE='PRN'");	
		rs = pstmt.executeQuery();	
		
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				contact_legend  =  rs.getString(1);	
				System.out.println("contact_legend :"+contact_legend);
			}
		}
		//V210203 start    
		siteSlmtAcrossFacility = CommonBean.isSiteSpecific(con, "BL", "BILL_SLMT_ACCROSS_FACILITY");		
		if (siteSlmtAcrossFacility) siteSlmtAcrossFacilityYN="Y";
		//V210203 end
	}catch(Exception e){
		System.out.println("Exception in getting contact legend name"+e);
		e.printStackTrace();
	}
	finally{
		pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con, request); 
	}

	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate=dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, -30); 
	String backDate=dateFormat.format(cal.getTime());
	
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String funct_name = request.getParameter("funct_name");
	HashMap<String,String> billOptions = null;
	BillReceiptRequest brRequest = new BillReceiptRequest();
	brRequest.setFacilityId(facility_id);
	brRequest.setLocale(locale);
	BillReceiptBC receiptBC = new BillReceiptBC();
	billOptions = receiptBC.getBillOptions(brRequest);
	if(billOptions == null){
		billOptions = new HashMap<String,String>();
	}
	request.setAttribute("billOptions", billOptions);
%>
<script>


</script>



<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();" >

	<FORM method='post' name="report_form" id="report_form" id="report_form" action=""
		onsubmit="return onSearch()" >
		<TABLE border='0' cellpadding='2' cellspacing='0'>
			<!-- V210129 START --> 
			<% if(siteSlmtAcrossFacility && funct_name.equals("BillGeneration") ) {				 
			%>
		<tr>
			<td width='2%' class='label'><fmt:message key="eBL.Facility.label" bundle="${bl_labels}" /></td>			
			<td class="fields" width="5%">
				<input type='text' name='facilityidName' id='facilityidName' id='facilityidName' size='20' maxlength='40'  value='' onblur='if(this.value!=""){ getFacility(facilityidName,facilityid,2) } else{ clearCode(facilityid); } '/>
				<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value=''>
				<input type='button' class='button' name="facilityid_btn" id="facilityid_btn" value='?' onClick="getFacility(facilityidName,facilityid,2)" tabindex='2'>				
			</td>							
		</tr>
		<%} else{
			%>
			<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value=''>
		<% }%>
			<!-- V210129 end -->
			<tr>
			<td width='2%' class='label'><fmt:message
						key="Common.EpisodeType.label" bundle="${common_labels}" /></td>
				<td width='5%' class='fields'>
				<select name='episode_type' id='episode_type' >
						<option value='A'>
							
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						
						</option>
						<option value='D'>
							<fmt:message key="Common.daycare.label" bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.emergency.label"
								bundle="${common_labels}" />
						</option>
						<option value='I'>
							<fmt:message key="Common.inpatient.label"
								bundle="${common_labels}" />
						</option>
						<option value='O'>
							<fmt:message key="Common.Outpatient.label"
								bundle="${common_labels}" />
						</option>
						<option value='R'>
							<fmt:message key="Common.referral.label"
								bundle="${common_labels}" />
						</option>
				</select>
				</td>
				

				<td width='2%' class='label'><fmt:message
						key="Common.encounterid.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='encounter_id' id='encounter_id' id='encounter_id' size='17' maxlength='12'
					style='text-align: right' value='<%=encounterId%>'
					onKeyPress='return(ChkNumberInput(this,event,0))'
					onBlur="CheckForChar(this)"></td>

				<td width='2%' class='label'><fmt:message
						key="eBL.encounterperiod.label" bundle="${bl_labels}" /></td>
				<td width='5%' class='fields'><select id="encounter_period"
					name="encounter_period" id="encounter_period" onchange='patientOnChange()'>
						<option value='S'>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>
						<option value='D'>
							<fmt:message key="Common.today.label" bundle="${common_labels}" />
						</option>
						<option value='W'>
							<fmt:message key="eBL.OneWeek.label" bundle="${bl_labels}" />
						</option>
						<option value='M'>
							<fmt:message key="eBL.OneMonth.label" bundle="${bl_labels}" />
						</option>
						<option value='P'>
							<fmt:message key="Common.Period.label" bundle="${common_labels}" />
						</option>
				</select><span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span></td>

			</tr>

			<tr id="hide_this_row" style="display: none">

				<td class="label" width="2%"></td>
				<td width='5%' class="fields"></td>
				<td class="label" width="2%"><fmt:message
						key="Common.fromdate.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='encounter_from_date' id='encounter_from_date' id="encounter_from_date" size='10' maxlength='10'
					value=''
					onBlur='return checkDateBL(document.forms[0].encounter_from_date)'>
					<img src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar_loc('encounter_from_date',document.forms[0].encounter_from_date);"
					>
					<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>
				<td class="label" width="2%"><fmt:message
						key="Common.todate.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='encounter_to_date' id='encounter_to_date' id='encounter_to_date' size='12' maxlength='10' value=''
					onBlur='return toFromDateChk(document.forms[0].encounter_to_date)'>
					<img src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar_loc('encounter_to_date',document.forms[0].encounter_to_date);"
					>
					<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>
			</tr>

			<tr>
			<td class="label" width="2%"><fmt:message
						key="Common.patientId.label" bundle="${common_labels}" /></td>
				<td class="fields" width="5%"><INPUT TYPE="TEXT"
					name="patient_id" id="patient_id"  SIZE="12" maxlength='12' VALUE=''
					onKeyPress='changeToUpper()' onBlur="" dflt_srch_value="Y"><input type='button'
					class='button' value='?'
					onClick="return getPatID()" tabindex='2'><span class='mandHide1'><img  src='../../eCommon/images/mandatory.gif'></span></td>
				<td class="label" width="2%"><fmt:message
						key="Common.PatientName.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><INPUT TYPE="TEXT"
					style="height: 21px;" name='patient_name' id='patient_name' size='17' maxlength='50'
					style='text-align:right' value='' 
					onBlur=" "> <select id='patient_name_cond'
					name='patient_name_cond' id='patient_name_cond' >						
						<option value='S'>
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='C'>
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
						</option>
				</select></td>
				
				
				<td class="label" width="2%"><fmt:message
						key="Common.AgeRange.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='age_from' id='age_from' size='7' maxlength='3'
					style='text-align: right' value='' onBlur='checkForNumber(this)'> 
					 - <input type='text' name='age_to' id='age_to' size='7'
					maxlength='3' style='text-align: right' value=''
					onBlur='checkForNumber(this)'></td>
			</tr>

			<tr>
				<td width='2%' class='label'><fmt:message
						key="Common.Location.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields">
					<select id='location_type' name='location_type' id='location_type'
					onchange='cliniconchange()'>
						<option value=''>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>						
						<option value='C'>
							<fmt:message key="Common.clinic.label" bundle="${common_labels}" />
						</option>
						<option value='W'>
							<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}" />
						</option>
				</select> 
				<input type='text' name='location_name' id='location_name' id='location_name' size="12" maxlength="20" value='' onblur='if(this.value!=""){ callCommonValidation(4,location_name,location_code) } else{ clearCode(location_code); } '>
				<input type='hidden' name='location_code' id='location_code' id='location_code' value=''>
				<input type='button' class='button' name="location_code_btn" id="location_code_btn" value='?' onClick="callCommonValidation(4,location_name,location_code);" tabindex='2'>				
				</td>
				<td width='2%' class='label'><fmt:message
						key="Common.gender.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><select id='gender'
					name='gender' id='gender'>
						
						<option value='A'>
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						</option>
						<option value='M'>
							<fmt:message key="Common.male.label" bundle="${common_labels}" />
						</option>
						<option value='F'>
							<fmt:message key="Common.female.label" bundle="${common_labels}" />
						</option>
						<option value='U'>
							<fmt:message key="Common.unknown.label" bundle="${common_labels}" />
						</option>
						
				</select></td>
				<td width='2%' class='label'><fmt:message
						key="eBL.DOCTOR_NAME.label" bundle="${bl_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='doctor_name' id='doctor_name' size='12' maxlength='30'
					style='text-align: right' value='' >
					 <select name='doctor_name_cond' id='doctor_name_cond' id='doctor_name_cond'
					>
						
						<option value='S'>
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='C'>
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
						</option>
				</select></td>
			</tr>

			<tr>
				<td width='2%' class='label'><fmt:message
						key="eBL.PAYER_GROUP.label" bundle="${bl_labels}" /></td>
				<td width='5%' class="fields">
					<input type='text' name='payerGroup' id='payerGroup' size='20' maxlength='40'  value='' onblur='if(this.value!=""){ callCommonValidation(3,payerGroup,payerGroupCode) } else{ clearCode(payerGroupCode); } '/>
					<input type='hidden' name='payerGroupCode' id='payerGroupCode' id='payerGroupCode' value=''>
					<input type='button' class='button' name="payerGroup_btn" id="payerGroup_btn" value='?' onClick="callCommonValidation(3,payerGroup,payerGroupCode);" tabindex='2'>					
				</td>
				<td width='2%' class='label'><fmt:message
						key="eBL.PayerName.label" bundle="${bl_labels}" /></td>
				<td width='5%' class="fields"><input type='text' name='payer' id='payer'
					size='17' maxlength='30' style='text-align: right' value=''
					> <select name='payer_cond' id='payer_cond' id='payer_cond'>
						
						<option value='S'>
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='C'>
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
						</option>
				</select></td>



				<td width='2%' class='label'><fmt:message
						key="eBL.POLICY_NAME.label" bundle="${bl_labels}" /></td>


				<td width='5%' class="fields"><input type='text' name='policy' id='policy'
					size='12' maxlength='30' style='text-align: right' value=''> 
					<select name='policy_cond' id='policy_cond'>
						
						<option value='S'>
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='C'>
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
						</option>
				</select></td>



			</tr>
			<tr>
				<td width='2%' class='label'><fmt:message
						key="Common.patienttype.label" bundle="${common_labels}" /></td>
				<td width='5%' class='fields'><select id='patient_type'
					name='patient_type' id='patient_type'>
						<option value=''>
							
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						
						</option>
						<option value='C'>
							<fmt:message key="eBL.CASH.label" bundle="${bl_labels}" />
						</option>
						<option value='X'>
							<fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}" />
						</option>
				</select></td>

<%-- 				<td class="label" width="2%"><fmt:message key="Common.contactNo.label" bundle="${common_labels}" /></td> --%>
				<%--V210727 Starts --%>
				<%if(siteSlmtAcrossFacilityYN.equals("Y") && contact_legend.equals("Primary Resi No")){ 
					System.err.println("558");
				%>
					<td class="label" width="2%"><fmt:message key="eBL.PrimRecNo.label" bundle="${bl_labels}" /></td> 
				<%} else{%>
				<td class="label" width="2%"> <%=contact_legend %></td>
				<%} %>  
				<%--V210727 Ends --%>
				<td width='5%' class="fields"><INPUT TYPE="TEXT"
					name='contact_no' id='contact_no' size='17' maxlength='12'
					style='text-align: right' value='' onBlur='checkForNumber(this)'
					> <select name='contact_no_cond' id='contact_no_cond' id='contact_no_cond'>
						
						<option value='S'>
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						</option>
						<option value='C'>
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
						</option>
				</select></td>


				<td width='2%' class='label'><fmt:message
						key="eBL.EPISODE_STATUS.label" bundle="${bl_labels}" /></td>
				<td width='5%' class='fields'><select id='episode_status'
					name='episode_status' id='episode_status'>
						<option value=''>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>
						<option value='O'>
							<fmt:message key="eBL.CURRENT_OUTPATIENT.label"
								bundle="${bl_labels}" />
						</option>
						<option value='I'>
							<fmt:message key="eBL.CURRENT_INPATIENT.label"
								bundle="${bl_labels}" />
						</option>						
				</select></td>
			</tr>
			<tr id='forBillGeneration' style="display: none;">
				<td width='2%' class='label'><fmt:message
						key="Common.Option.label" bundle="${common_labels}" /></td>
				<td width='5%' class='fields'><select id='optionList' name='optionList'>		
									
				<!--  	<c:forEach var="billOpt" items="${billOptions }">      						
      						<option value="${billOpt.key }">${billOpt.value }</option>
      					</c:forEach> -->
				</select>
				</td>
				<td width='2%' class='label'><fmt:message
						key="eBL.NRIC.label" bundle="${bl_labels}" /></td>
				<td width='5%' class='fields' colspan="4"><input type='text' onkeypress="return CheckForAlphaCharsNatID(event);" id='nric'
					name='nric' id='nric' maxlength="20">
				</td>
				<!-- commented by shikha for bill generation 
				     <td colspan='2' class='label'><fmt:message
						key="eBL.UnBilledOrExists.label" bundle="${bl_labels}" />
				&nbsp;&nbsp;
				<input type="checkbox" name="unBilledExists" id="unBilledExists" id='unBilledExists'  />
				<inp
				</td> -->				
			</tr>
			<tr style="display: none;">
				<td width="2%" class='label' colspan=3 nowrap>
				<td width="5%" class='button' colspan=3 nowrap><a href
					STYLE="color: blue" onClick='sendSelectedValues();'><p id="sortByValues" style="font-size: 11px">Click to Sort[EncounterId(ASC)]</p></a></td>
			</tr>
			<tr>
				<td colspan='2' nowrap></td>
				<td colspan='2' nowrap>
					<a href	id='pageredirect' STYLE="color: blue" onClick='pageredirect();'>Click here for referral without patient id  only</a>
				</td>
				<td width="5%" class='button' colspan=2 nowrap>
				<input type='hidden' name="check_type" id="check_type" value="N"> 
				<input type="checkbox" name="saveSearchCriteria" id="saveSearchCriteria" checked="checked" /> 
					<a href	STYLE="color: blue" onClick='sendDefaultValues();'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.SetDefaultValue.label", "bl_labels")%></a> <!-- 210720 -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='button' name="search_button" id="search_button"value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>"
					class='button' onClick='onSearch();'>
				&nbsp;
				<input type='button' class='button' id='reset' name='reset' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.reset.label", "common_labels")%>'></td> <!-- 210720 -->
			</tr>
		</table>
		<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='funct_name' id='funct_name' value='<%=funct_name %>'>
		<input type='hidden' name='todaysDate' id='todaysDate' value='<%=todaysDate%>'>
		<input type='hidden' name='backDate' id='backDate' value='<%=backDate %>'>
		<input type='hidden' name='siteSlmtAcrossFacilityYN' id='siteSlmtAcrossFacilityYN' value='<%=siteSlmtAcrossFacilityYN %>'>

	</form>
</body>
</html>



