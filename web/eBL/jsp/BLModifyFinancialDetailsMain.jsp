<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@page import="org.jaxen.util.FollowingAxisIterator"%>
<%@page import="javax.swing.plaf.metal.MetalIconFactory.FolderIcon16"%>
<%@page import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<head>
<title><fmt:message key="eBL.MOD_FIN_DTLS.label" bundle="${bl_labels}" /></title>
<link rel='StyleSheet' href='../../eCommon/html/IeStyle_new.css' type='text/css'/>
<link href="https://cdn.jsdelivr.net/npm/@mdi/font/css/materialdesignicons.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script language='javascript' src='../../eCommon/js/jquery.js'></script>
<script language='javascript' src='../../eBL/js/BLModifyFinancialDetails.js'></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<style>
		.tableContainer{
			overflow: auto;
			width: 1600px;
			height: 250px;
			display: block;
			border-radius: 5px;
			margin: 5px;
		}
		.table {
   			display: table;
   			width: 100%;
		}
		.table-header{
			display: table-header-group;
			position: sticky; 
			top: 0; 
			background-color: #ccc;
			font-weight: bold;
		}
		.table-body-row {
		  display: table-row-group;
		}
		.row{
			 display: table-row;
		}
		.cell {
		   display: table-cell;
		   border: solid; 
		   border-color: white; 
           border-width: thin; 
           font-size: 14px;  
		}
		
		.row,
		.cell {
		  padding: 10px;
		}
		/* Style input field in grid */
		.gridInputs{
			height: 30px;
			width: 82%;
			border: 1px solid #DADCE0;
			border-radius: 2px;
			font-size: 14px;
			padding: 5px 2px; 
			outline: none;
			background: none;
			z-index: 1;
			display: inline-block;
			box-sizing: border-box;
		}
		.gridDate{
			height: 30px;
			width: 90%;
			border: 1px solid #DADCE0;
			border-radius: 2px;
			font-size: 14px;
			padding: 5px 2px; 
			outline: none;
			background: none;
			z-index: 1;
			display: inline-block;
			box-sizing: border-box;
		}
		 .gridSerachIcon{
        	display: inline-block;
        	width: 15%;
        	height: 30px;
			border: 1px solid #DBDBDB;	
			opacity: 1; 
			color: #0F4C8F; 
			background: white;
			border-radius: 2px;
			box-sizing: border-box;
        }
        .pkgSerachIcon{
        	display: inline-block;
        	width: 12%;
        	height: 17px;
        	border: 1px solid #DBDBDB;	
			opacity: 1; 
			color: #0F4C8F; 
			background: white;
			border-radius: 2px;
			box-sizing: border-box;
        }
		/* Style for the popup */
	    #popupkk {
	        display: none;
	        position: absolute;
	        background-color: #fff;
	        padding: 0px;
	        border: 1px solid #ccc;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	        z-index: 1000; /* Ensure popup is on top of overlay */
	        width: 600px; /* Set width */
	    } 
	     /* Style for the overlay */
	    .overlay {
	        display: none;
	        position: fixed;
	        top: 0;
	        left: 0;
	        width: 100%;
	        height: 100%;
	        background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black */
	        z-index: 999; /* Ensure overlay is on top of other content */
	    }
	     #pkgPopupkk {
	        display: none;
	        position: absolute;
	        background-color: #fff;
	        padding: 0px;
	        border: 1px solid #ccc;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	        z-index: 1000; /* Ensure popup is on top of overlay */
	        width: 600px; /* Set width */
	    } 
	     /* Style for the overlay */
	   
	    .lookupContainer{
	    	background-color:#F7F7F7;
			width: inherit; 
			height: inherit;
	    }
	    .lookup-subcontainer {
			background-color: white;
			width: 98%;
			height: inherit;
			border-radius: 3px;
			display: inline-block;
			padding: 1%;
			margin: 1%;
		}
		.lookup-headercontainer {
			background-color: #0F4C8F;
			height: inherit;
		 	width: 98%; 
			height: inherit;
			border-radius: 3px;
			display: inline-block;
			padding: 1%;
			margin: 1%;
		}
		.lookup-title{
			display: inline-block;
			text-align: left;
			font: normal normal bold 15px Segoe UI;
			color: white;
			opacity: 1;
			margin: 2px;
			background-color: inherit;
			float: left;
		}
	    /* Style for the close button */
	    .close-btn {
	        position: absolute;
	        top: 10px;
	        right: 10px;
	        cursor: pointer;
	    }
		
		/* Style for the search results container */
		#popup-results {
		    display: flex;
		    flex-direction: column;
		    border: 1px solid #ccc;
		    padding: 5px;
		    margin-top: 5px;
		    max-height: 300px; /* Set a fixed height for the result section */
		    overflow-y: auto; /* Enable vertical scrolling if content overflows */
		} 
	#pkgLkupResult {
		    display: flex;
		    flex-direction: column;
		    border: 1px solid #ccc;
		    padding: 5px;
		    margin-top: 5px;
		    max-height: 300px; /* Set a fixed height for the result section */
		    overflow-y: auto; /* Enable vertical scrolling if content overflows */
		} 
		/* Style for the table header row */
		.result-row.header-row {
		    font-weight: bold;
		  	/* display: table-header-group;  */
			position: sticky; 
			top: 0; 
			background-color: #ccc;
		}
		.header-row {
		    white-space: nowrap;
		}
		
		/* Style for each row in the table */
		.result-row {
		    display: flex;
		    flex-direction: row;
		    border-top: 1px solid #ccc;
		    padding: 5px 0;
		}
		
		/* Style for each cell in the table */
		.result-cell {
		    flex: 1;
		    padding: 0 5px;
		    
		}
		.popupImg{
			position: absolute;
			top: 10px;
			left: 320px;
			width: 40px;
		}
		.searchIconInGrid{
			float: right;
			width: 20%;
			height: 45px;
			display: inline-block;
		}
		.padding{
			 padding: 1px;
		}
		
		.authpopup {
			display: none;
			position: fixed;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			border: 1px solid #888;
			background-color: white;
			z-index: 1000;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
			padding: 2px;
			width:40%;
			height:50%;
		}
	</style>
<script>
	$(document).ready(function() {
		$('#remove-selected-rows').click(function() {
	    	var checkedRow = "N";
	        $('.row-checkbox:checked').each(function() {
	        	checkedRow = "Y";
	            $(this).closest('.row').remove();
	        });
	        if(checkedRow == "Y")
	        	resetTheOrder();
	        else
	        	alert("Please select atleast one record");
	    });
	   
	});
	
	function getMessage( message_ref,moduleId) {
		var urlString ="msgId="+message_ref+"&moduleId="+moduleId;
		var retDesc = "";
		$.ajax({
				 type: "POST",
				 url:"../../eCommon/jsp/MessageContainer.jsp?",
				 data: urlString,
				 dataType:"text",
				 async:false,
				 success: function(response){					
					retDesc = response;
				 },
				 error: function(){
					 alert("Error while getting Message Description!");
				 }
			 });
		return retDesc;
	}	
	
	function getLabel( label_ref,moduleId) {
		var urlString = "labelId="+label_ref+"&moduleId="+moduleId;
		var retDesc = "";
		$.ajax({
				 type: "POST",
				 url:"../../eCommon/jsp/LabelContainer.jsp?",
				 data: urlString,
				 dataType:"text",
				 async:false,
				 success: function(response){				
					retDesc = response;
				 },
				 error: function(){
					 alert("Error while getting Message Description!");
				 }
			 });
		return retDesc;
	}	

</script>

</head>
<%
	try{
		String pageCalledYN = (String) session.getAttribute("pageCalledYN");
		if(pageCalledYN == null) pageCalledYN = "N";
		pageCalledYN="Y";
		String facility_id=(String) request.getParameter("facility_id");
		if(facility_id==null) facility_id="";
		System.out.println("facility_id in main.jsp "+facility_id);
		String locale=(String) request.getParameter("locale");
		System.out.println("locale in main.jsp "+locale);
		if(locale==null) locale="en"; 
		String login_user=(String) request.getParameter("login_user");
		System.out.println("login_user in main.jsp "+login_user);
		
		if(pageCalledYN.equals("Y")){ 
%>	
<body onKeyDown="lockKey()">
<div class="container">
<form id="modifyFinancialDetails" method="post">
		<!--  <div class="overlay" onclick="closePopup()" id="overlay"></div> 
		 --> <!-- <div id="popup"></div>  -->
		<!-- <div class="overlay" onclick="closePkgPopup()" id="pkglkup"></div> -->
		<div class="popup" id="popup"> 
			<div id="popup-content" class="popup-content"></div> 
		</div>
		<div class="popup" id="pkglkup">
			<div id="popup-content" class="popup-content"></div> 
		</div>
		<div class="authpopup" id="authPopup">
			<div id="popup-content" class="popup-content"></div> 
		</div>		
		
	<div id="headerDiv" class="subcontainer" style="background-color: #00A0DD;">
		<div class="title" style="color: white;"><fmt:message key="eBL.MOD_FIN_DTLS.label" bundle="${bl_labels}" /></div>
		<div class="buttoncontainer">
			<input type="Button" class="icon-button" value="Apply" onclick="onApply();">
			<input type="Button" class="icon-button" value="Reset" onClick = "resetEntireForm();">
		</div>
	</div>
	<div id="searchDiv" class="subcontainer">
		<div class="gridcontainer">
			<label class="labelHeader"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}" /></label>
			<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label class="label" >Episode Type</label>
					<select class="inputselect" id="episode_Type" name="episode_Type" onChange="disableField(this)">
						<option class="label-select"  value='S'>--<fmt:message key="Common.Select.label" bundle="${common_labels}" />--</option>
						<option class="label-select"  value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>
						<option class="label-select"  value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
						<option class="label-select"  value='R'><fmt:message key="Common.external.label" bundle="${common_labels}" /></option>
						<option class="label-select"  value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
						<option class="label-select"  value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
					</select>
				</div>
			</div>
			<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}" /></label>
					<input type="text" class="input" id="patient_Id" name="patient_Id" SIZE="12" maxlength='12' autocomplete="off" onKeyPress='convertToUppercase(event)' oninput="checkLength(this)"  onBlur="if(this.value != '' && checkForEpisodeType(this)){callPatValidation(this);}else{clearPatDtls(this)}" />
				</div>
			</div>
			<div class="col-5">
				<div class="input-wrapper">
					<button class="searchIcon" type="button" id="patiendIdLov" onclick="if(checkForEpisodeType(this)){ return patiendIdLookup(patient_Id);}">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div>
			<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}" /></label>
					<input type="text" class="input" id="patient_Name" readonly>
				</div>
			</div>
			<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}" /></label>
					<input type="text" class="input" id="encounter_Id" name="encounter_Id"  maxlength="12"  size="12" autocomplete="off" onKeyPress="return(ChkNumberInput(this,event,0));return CheckForSpecChars(event);lockbackSpace();" onBlur="if(this.value != '' && checkForEpisodeType(this)){encounterIdLookup(encounter_Id);}">
				</div>
			</div>
			<div class="col-5">
				<div class="input-wrapper">
					<button class="searchIcon" type="button" id="encounterIdLov" onclick="if(checkForEpisodeType(this)){encounterIdLookup(encounter_Id);}">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div>
			<div class="buttoncontainer padding">
				<input type="Button" class="btn btn-primary" id="searchData" value="Search" onClick="getFinancialDetails();">
				<input type="Button" class="btn btn-primary" id='Authorized' disabled value="Authorized" onclick="validateUser()" >
			</div>
		</div>
	</div>
	<!-- searh criteria ends -->
	<div class="subcontainer" id="financialDtls">
		<div class="gridcontainer">
			<label class="labelHeader"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}" /></label>
			<!-- primary blng grp tab starts-->
			<div  class="subcontainer" id="primaryBlngGrp">
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.BillingGroupCategory.Label" bundle="${bl_labels}" /></label>
						<input type="text" class="input1 code" id="priBlngGrpCat" name="priBlngGrpCat" disabled onblur="if(this.value!=''){PrimaryBlngGrpCatLkp(priBlngGrpCat,'1')}else{clearValues('priBlngGrpCat')}">
						<input type="text" class="input1 desc" id="priBlgGrpCatDesc" onblur="if(this.value!=''){PrimaryBlngGrpCatLkp(priBlgGrpCatDesc,'2')}else{clearValues('priBlgGrpCatDesc')}" disabled>
					</div>
				</div>
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" id="pricatSearch" disabled onclick="PrimaryBlngGrpCatLkp(priBlgGrpCatDesc,'2')" disabled>
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div>
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input1 code" id="priBlngGrpId"  name="priBlngGrpId" disabled onblur="if(this.value!=''){PrimaryBlngGrpIdLkp(priBlngGrpId,'1')}else{clearValues('priBlngGrpId')}" >
						<input type="text" class="input1 desc" id="priBlngGrpDesc" disabled onblur="if(this.value!=''){PrimaryBlngGrpIdLkp(priBlngGrpDesc,'2')}else{clearValues('priBlngGrpDesc');}">
					</div>
				</div>
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" id="priblngSearch" disabled onclick="PrimaryBlngGrpIdLkp(priBlngGrpDesc,'2')">
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div>
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input1 code" id="priRefSrcCode" name="priRefSrcCode" disabled onblur="if(this.value!=''){PrimaryRefSrcLkp(priRefSrcCode,'1')}else{updateRefSrcBlur('PrimaryRefSrc',1);clearValues('priRefSrcCode');}" tabindex=1>
						<input type="text" class="input1 desc" id="priRefSrc" disabled onblur="if(this.value!=''){PrimaryRefSrcLkp(priRefSrc,'2')}else{updateRefSrcBlur('PrimaryRefSrc',1);clearValues('priRefSrc');}">
					</div>
				</div>
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" disabled id="priRefSrcIcon" onclick="PrimaryRefSrcLkp(priRefSrc,'2')" tabindex=2>
								<span class="mdi mdi-magnify"></span>
						</button>
					</div> 
				</div>   
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input1 code" id="secRefSrcCode" name="secRefSrcCode" disabled onblur="if(this.value!=''){SecRefSrcLkp(secRefSrcCode,'1')}else{updateRefSrcBlur('SecRefSrc',1);clearValues('secRefSrcCode');}" tabindex=3>
						<input type="text" class="input1 desc" id="secRefSrc" disabled onblur="if(this.value!=''){SecRefSrcLkp(secRefSrc,'2')}else{updateRefSrcBlur('SecRefSrc',1);clearValues('SecRefSrc');}">
					</div>
				</div>
				<div class="col-5"> 
					<div class="input-wrapper">
						<button class="searchIcon" type="button" disabled id="secRefSrcIcon" onclick="SecRefSrcLkp(secRefSrc,'2')" tabindex=4>
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div>
				<br><br>
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}" /></label>
						<input type='text' class="input1 code" id="custGrpId" name="custGrpId" disabled onblur="if(this.value!=''){custGroupLookup(custGrpId,'1')}else{clearValues('custGrpId')}" >
						<input type="text" class="input1 desc" id="custGrp" disabled onblur="if(this.value!=''){custGroupLookup(custGrp,'2')}else{clearValues('custGrp')}" >
					</div>
				</div>  
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" id="cusGrpIcn" disabled onclick="custGroupLookup(custGrp,'2')">
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div>
				<div class="col-4">  
					<div class="input-wrapper inputLargeContainer"> 
						<label  class="label" ><fmt:message key="eBL.Customer.label" bundle="${bl_labels}" /></label> 
						<input type='text' class="input1 code" id="customerId" name="customerId" disabled onblur="if(this.value!=''){custLookup(customerId,'1')}else{clearValues('customerId')}"  >
						<input type="text" class="input1 desc" id="customer"  disabled onblur="if(this.value!=''){custLookup(customer,'2')}else{clearValues('customer')}" >
					</div>
				</div>
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" id="customerIcn" disabled onclick="custLookup(customer,'2')">
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div> 
			</div> 
	<input type="hidden" id="slmtInd" name="slmtInd" value = "" >
	<input type="hidden" id="admRecFlag" name="admRecFlag" value="">
	<input type="hidden" id="capRefSrcYN" name="capRefSrcYN" value= "" >
	<input type="hidden" id="primaryRefSrcMandYN" name="primaryRefSrcMandYN" value = "" >
	<input type="hidden" id="secRefSrcMandYN" name="secRefSrcMandYN" value = "" >
	<input type="hidden" id="creditAuthRefReqd" name="creditAuthRefReqd" value = "" >
		</div>
	</div>
		<!-- primary blng grp tab ends-->
		<div class="subcontainer" id="payerSection">
			<div class="gridcontainer">
			<label class="labelHeader"><fmt:message key="eBL.PayerDtls.label" bundle="${bl_labels}" /></label>

				<div class="tableContainer" id='payerDtls' >
					<div class="table">
						<div class="table-header">
						<div class="cell"><fmt:message key="Common.Select.label" bundle="${common_labels}" /></div>
						<div class="cell"><fmt:message key="Common.priority.label" bundle="${common_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.BillingGroupCategory.Label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.Customer.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_TYPE_CODE.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.CREDIT_AUTH_REF.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}" /></div>
						<div class="cell"><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}" /></div>
						</div>
						<div class="table-body-row" id="tableBody" contenteditable="false" >
				
						</div>
					</div>
						<input type="hidden" id="totalRowsIns" name="totalRowsIns" />
				</div>
			<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="eBL.BillingGroupDesc.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input" id="blngGrpDesc" name="blngGrpDesc" readonly disabled>
					</div>
				</div>
			<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="eBL.CUSTOMER_DESC.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input" id="custDesc" name="custDesc" readonly disabled>
					</div>
				</div>
			<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="eBL.POLICY_TYPE_DESC.label" bundle="${bl_labels}" /></label>
						<input type="text" class="input" id="policyTypeDesc" name="policyTypeDesc" readonly disabled>
					</div>
				</div>
				<div class="buttoncontainer">
					<br>
					<input type="Button" class="btn btn-primary" value="Add Row" onclick="addNewRow()" disabled id="addRw">
					<input type="Button" class="btn btn-primary" value="Delete Row" disabled id="remove-selected-rows">
					<input type="Button" class="btn btn-primary" id="pkgDtls" value="Package Details" onclick='associatePkg()' disabled>
				</div>
			</div>
		</div>
	<div class="subcontainer" id="nonInsDtls">
		<div class="gridcontainer">
			<label class="labelHeader"><fmt:message key="eBL.NON_INS_BILL_DTLS.label" bundle="${bl_labels}" /></label>
				<div class="col-4">
					<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}" /></label>
						<input type='text' class="input1 code" id="nonInsBlngGrpId" name="nonInsBlngGrpId" readonly disabled onblur="if(this.value!=''){nonInsBlngGrpLov(nonInsBlngGrpId,'1');}else{clearValues('nonInsBlngGrpId')}">
						<input type="text" class="input1 desc" id="nonInsBlngGrp" name="nonInsBlngGrp" readonly disabled onblur="if(this.value!=''){nonInsBlngGrpLov(nonInsBlngGrp,'2');}else{clearValues('nonInsBlngGrp')}">
					</div>
				</div>
				<div class="col-5">
					<div class="input-wrapper">
						<button class="searchIcon" type="button" id="nonInsBlngGrpBttn" onclick="nonInsBlngGrpLov(nonInsBlngGrp,'2')" disabled>
								<span class="mdi mdi-magnify"></span>
						</button>
					</div>
				</div>			
				<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}" /></label>
					<input type='text' class="input1 code" id="nonInsRefSrcId" name="nonInsRefSrcId" onblur="if(this.value!=''){PrimaryRefSrcLkp(nonInsRefSrcId,'1')}else{clearValues('nonInsRefSrcId')}" disabled >
					<input type="text" class="input1 desc" id="nonInsRefSrc" disabled onblur="if(this.value!=''){PrimaryRefSrcLkp(nonInsRefSrc,'2')}else{clearValues('nonInsRefSrc')}">
				</div> 
			</div>
			<div class="col-5"> 
				<div class="input-wrapper"> 
					<button class="searchIcon" type="button" id="nonInsRefIcn" disabled onclick="PrimaryRefSrcLkp(nonInsRefSrc,'2')">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div>
			<div class="col-2">
				<div class="input-wrapper inputLargeContainer"> 
					<label  class="label" ><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}" /></label>
					<input type='text' class="input1 code" id="nonInsScRefSrcId" name="nonInsScRefSrcId" onblur="if(this.value!=''){SecRefSrcLkp(nonInsScRefSrcId,'1')}else{clearValues('nonInsScRefSrcId')}" disabled >
					<input type="text" class="input1 desc" id="nonInsScRefSrc" disabled onblur="if(this.value!=''){SecRefSrcLkp(nonInsScRefSrc,'2')}else{clearValues('nonInsScRefSrc')}">
				</div>
			</div>
			<div class="col-5">
				<div class="input-wrapper">
					<button class="searchIcon" type="button" id="nonInsSecRefIcn" disabled onclick="SecRefSrcLkp(nonInsScRefSrc,'2')">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div>
			
			<div class="col-4">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label" ><fmt:message key="eBL.NON_INS_CUST_GRP.label" bundle="${bl_labels}" /></label>
					<input type='text' class="input1 code" id="NonInsCustGrpId" name="NonInsCustGrpId"  onblur="if(this.value!=''){nonInsCustGroupLookup(NonInsCustGrpId,'1')}else{clearValues('NonInsCustGrpId')}" disabled >
					<input type="text" class="input1 desc" id="NonInsCustGrp" disabled  onblur="if(this.value!=''){nonInsCustGroupLookup(NonInsCustGrp,'2')}else{clearValues('NonInsCustGrp')}">
				</div>
			</div>
			<div class="col-5">
				<div class="input-wrapper">
					<button class="searchIcon" type="button" id="nonInsCusGrpIcn" disabled onclick="nonInsCustGroupLookup(NonInsCustGrp,'2')">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div> 
			<div class="col-4"> 
				<div class="input-wrapper inputLargeContainer"> 
					<label  class="label" ><fmt:message key="eBL.NON_INS_CUSTOMER.label" bundle="${bl_labels}" /></label>
					<input type='text' class="input1 code" id="NonInsCustId" name="NonInsCustId" onblur="if(this.value!=''){nonInsCustLookup(NonInsCustId,'1')}else{clearValues('NonInsCustId')}" disabled >
					<input type="text" class="input1 desc" id="NonInsCust"  disabled  onblur="if(this.value!=''){nonInsCustLookup(NonInsCust,'2')}else{clearValues('NonInsCust')}">
				</div>
			</div>
			<div class="col-5">
				<div class="input-wrapper">
					<button class="searchIcon" type="button" id="nonInsCusIcn" disabled onclick="nonInsCustLookup(NonInsCust,'2')">
							<span class="mdi mdi-magnify"></span>
					</button>
				</div>
			</div>
		</div> 
	</div> 
	<input type="hidden" id="nonInsSlmtInd" value = "" >
	<input type="hidden" id="nonInsAdmRecFlag" value="">
	<input type="hidden" id="nonInsCapRefSrcYN" value = "" >
	<input type="hidden" id="nonInsPrimaryRefSrcMandYN" value = "" >
	<input type="hidden" id="nonInsSecRefSrcMandYN" value = "" >
	<input type="hidden" id="nonInsCreditAuthRefReqd" value = "" >
	<!-- Non-Insurance ends -->
	<div>
	<div class="subcontainer" id="ccdetails">
		<div class="gridcontainer" >
				<label class="labelHeader"><fmt:message key="eBL.CREDIT_DOC_DTLS.label" bundle="${bl_labels}" /></label>
			<div class="col-2">
				<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}" /></label>
					<input type="text" class="input" id="dcmntRef" name="dcmntRef" readonly disabled>
				</div>
			</div>
			<div class="col-2">
				<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}" /></label>
					<input type="date" class="input" id="docStartDate" name="docStartDate" onBlur="if(this.value!=''){creditDocDatesValid(this)}" readonly disabled>
				</div>
			</div>
			<div class="col-2">
				<div class="input-wrapper inputLargeContainer">
						<label  class="label" ><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}" /></label>
					<input type="date" class="input" id="docEndDate" name="docEndDate" onBlur="if(this.value!=''){creditDocDatesValid(this)}" readonly disabled>
				</div>
			</div>				
		</div>
	</div>
	<div class="subcontainer" id="finremarks">
		<div class="gridcontainer" >
				<label class="labelHeader" ><fmt:message key="eBL.FINANCIAL_REMARKS.label" bundle="${bl_labels}" /></label>
			<div class="col-t3">
				<div class="input-wrapper inputLargeContainer">
					<input type="textarea" class="input" id="finRemarks" name="finRemarks" length=200 maxlength=400 readonly disabled>
				</div>
			</div>
		</div>
	</div>
		</div>
	<input type="hidden" id="pageCalledYN" name="pageCalledYN" value = "<%=pageCalledYN%>" >
		<input type="hidden" id="facility_id" name="facility_id" value = "<%=facility_id%>" >
	<input type="hidden" id="login_user"   name="login_user" value = "<%=login_user.toUpperCase()%>" >
		<input type="hidden" id="locale" name="locale" value = "<%=locale%>" > 
		<input type="hidden" id="authUserId" name="authUserId" value="" />
		 <!-- params added for submit proc -->
		<input type="hidden" id="visit_regn_date_time" name="visit_regn_date_time" value="" />
		<input type="hidden" id="postDiscFlag" name="postDiscFlag" value = "" >
		<input type="hidden" id="currentSeqNo" name="currentSeqNo" value = "" >
		<input type="hidden" id="visitStatus" name="visitStatus" value = "" >
		<input type="hidden" id="episodeStatus" name="episodeStatus" value = "" > 
		<input type="hidden" id="totAdmnDepAmt" name="totAdmnDepAmt" value = "" >
		<input type="hidden" id="isSpecClinicRelated" name="isSpecClinicRelated" value = "" >
		<input type="hidden" id="bedCatCode" name="bedCatCode" value = "" >
		<input type="hidden" id="errorDesc" name="errorDesc" value = "" > 
		<input type="hidden" id="packageChk" name="packageChk" value="" >
		<input type="hidden" id="AssociatedYN" name="AssociatedYN" value="" >
		<input type="hidden" id="pkgCodeStr" name="pkgCodeStr" value = "" > 
		<input type="hidden" id="pkgDescStr" name="pkgDescStr" value = "" > 
		<input type="hidden" id="pkgSeqNoStr" name="pkgSeqNoStr" value="" >
		<input type="hidden" id="pkgAssocFlagStr" name="pkgAssocFlagStr" value="" >
		<input type="hidden" id="existPkgRec" name="existPkgRec" value="" >
		<input type="hidden" id="existTotalPkgRecs" name="existTotalPkgRecs" value="0" >
		<input type="hidden" id="totalPkgRecs" name="totalPkgRecs" value="0"/>
	
		<input type="hidden" id="episodeType" name="episodeType" value = "" > 
		<input type="hidden" id="moduleId" name="moduleId" value = "" > 	
		<input type="hidden" id="patientId" name="patientId" value = "" > 
		<input type="hidden" id="patientName" name="patientName" value="" > 
		<input type="hidden" id="encounterId" name="encounterId" value="" > 
		<input type="hidden" id="package_yn" name="package_yn" value="N" > 
		<input type="hidden" id="postDischrgFlag" name="postDischrgFlag" value="N" > 
		<input type="hidden" id="amtDeciPt" name="amtDeciPt" value="2" > 
	</form>
</div>
</body>
<%  
			//session.removeAttribute("pageCalledYN"); 
		}
		else{		
%>
<script>
	alert("Session is refreshed, please relogin");
</script>
<%			
		}
	}
	catch(Exception e){
		System.err.println("Error in BLModifyFinancialDetailsMain.jsp = "+e);
	}
%>	
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
</html>