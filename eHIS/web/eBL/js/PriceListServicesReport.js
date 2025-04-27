/* 
Sr No        Version           Incident           SCF/CRF                Developer Name
---------------------------------------------------------------------------------------
1            V201117            	        MOHE-CRF-0050.3-US003          Ram kumar S
1            V201222            11806	    MOHE-CRF-0050.3-US003          Ram kumar S
 */


//V201222 Starts
function reset() {
	pricelistservicesreport.document.location.reload();         
	pricelistservicesreport.document.location.href = '../../eCommon/jsp/blank.html';  
}
//V201222 Ends

function run() {
	var prcInd="";
	var prcInd1="";
	var facility_ID=window.frames["pricelistservicesreport"].document.getElementById("facility_ID").value;
	var PriceInd=window.frames["pricelistservicesreport"].document.getElementById("PriceInd").value;
	var status=window.frames["pricelistservicesreport"].document.getElementById("status").value;
	var userId=window.frames["pricelistservicesreport"].document.getElementById("P_USER_ID").value;""
	var facilityId=window.frames["pricelistservicesreport"].document.getElementById("facilityId").value;
	var locale=window.frames["pricelistservicesreport"].document.getElementById("locale").value;
	var FrmCustCode=window.frames["pricelistservicesreport"].document.getElementById("FrmCustCode").value;
	FrmCustCode = (FrmCustCode=="" || FrmCustCode==null) ? '!!!!!!!!' : FrmCustCode;
	var ToCustCode=window.frames["pricelistservicesreport"].document.getElementById("ToCustCode").value;
	ToCustCode = (ToCustCode=="" || ToCustCode==null) ? '~~~~~~~~' : ToCustCode;
	var FrmBillingGrp=window.frames["pricelistservicesreport"].document.getElementById("FrmBillingGrp").value;
	FrmBillingGrp = (FrmBillingGrp=="" || FrmBillingGrp==null) ? '!!!!' : FrmBillingGrp;
	var ToBillingGrp=window.frames["pricelistservicesreport"].document.getElementById("ToBillingGrp").value;
	ToBillingGrp = (ToBillingGrp=="" || ToBillingGrp==null) ? '~~~~' : ToBillingGrp;
	var FrmBillingCls=window.frames["pricelistservicesreport"].document.getElementById("frmBillingClass").value;
	FrmBillingCls = (FrmBillingCls=="" || FrmBillingCls==null) ? '!!!!!!!' : FrmBillingCls;
	var ToBillingCls=window.frames["pricelistservicesreport"].document.getElementById("toBillingClass").value;
	ToBillingCls = (ToBillingCls=="" || ToBillingCls==null) ? '~~~~~~~' : ToBillingCls;
	var frmBillingServ=window.frames["pricelistservicesreport"].document.getElementById("frmBillingServ").value;
	frmBillingServ = (frmBillingServ=="" || frmBillingServ==null) ? '!!!!!!!!!!' : frmBillingServ;
	var toBillingServ=window.frames["pricelistservicesreport"].document.getElementById("toBillingServ").value;
	toBillingServ = (toBillingServ=="" || toBillingServ==null) ? '~~~~~~~~~~' : toBillingServ;
	var frmEffDate=window.frames["pricelistservicesreport"].document.getElementById("frmEffDate").value;
	frmEffDate = (frmEffDate=="" || frmEffDate==null) ? '01/01/1800' : frmEffDate;
	var toEffDate=window.frames["pricelistservicesreport"].document.getElementById("toEffDate").value;
	toEffDate = (toEffDate=="" || toEffDate==null) ? '31/12/4712' : toEffDate;
	var frmCreateAmendBy=window.frames["pricelistservicesreport"].document.getElementById("frmCreateAmendBy").value;
	frmCreateAmendBy = (frmCreateAmendBy=="" || frmCreateAmendBy==null) ? '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' : frmCreateAmendBy;
	var toCreateAmendBy=window.frames["pricelistservicesreport"].document.getElementById("toCreateAmendBy").value;
	toCreateAmendBy = (toCreateAmendBy=="" || toCreateAmendBy==null) ? '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~' : toCreateAmendBy;
	var frmCreateAmendDate=window.frames["pricelistservicesreport"].document.getElementById("frmCreateAmendDate").value;
	frmCreateAmendDate = (frmCreateAmendDate=="" || frmCreateAmendDate==null) ? '01/01/1800' : frmCreateAmendDate;
	var toCreateAmendDate=window.frames["pricelistservicesreport"].document.getElementById("toCreateAmendDate").value;
	toCreateAmendDate = (toCreateAmendDate=="" || toCreateAmendDate==null) ? '31/12/4712' : toCreateAmendDate;
	var groupby=window.frames["pricelistservicesreport"].document.getElementById("groupby").value;
	var standardPrice="";
	
	if($("#standardPrice",window.frames["pricelistservicesreport"].document).prop('checked') == true){
		standardPrice="Y";
	}else{
		standardPrice="N";
	}
	
	if(PriceInd=="A"){
		prcInd='!';
		prcInd1='~';
	} 	
	else{
		prcInd=PriceInd;
		prcInd1=PriceInd;
	}
		var p_report_id="BLRPRLST";
		var p_module_id = "BL";
		var detailed_yn ='Y';
		$.ajax({
			type:"POST",
			url:"../jsp/TotBillForPeriodCommon.jsp",
			data:"func_mode=PriceListServices"+
				"&p_report_id="+p_report_id+
				"&param1="+frmCreateAmendBy+
				"&param2="+toCreateAmendBy+
				"&param3="+frmBillingServ+
				"&param4="+toBillingServ+
				"&param5="+frmCreateAmendDate+
				"&param6="+toCreateAmendDate+
				"&param7="+FrmCustCode+
				"&param8="+ToCustCode+
				"&param9="+FrmBillingGrp+
				"&param10="+ToBillingGrp+
				"&param11="+FrmBillingCls+
				"&param12="+ToBillingCls+
				"&param13="+frmEffDate+
				"&param14="+toEffDate+
				"&param15="+groupby+
				"&param16="+standardPrice,
			dataType:"text",
			async:false,
			success: function(data){
				var dummyDoc = window.frames["dummy_frame"].document;
				var retVal = trimString(data).split(":::");
				var session_id;
				var pgm_date;
				if(retVal.length == 2){
					session_id = trimString(retVal[0]);
					pgm_date = trimString(retVal[1]);
				}
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
				htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+trim(pgm_date)+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+p_report_id+"'>";	
				htmlVal += "<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='"+facilityId+"'>";
				htmlVal += "<input type='hidden' name='ND_FACILITY_ID' id='ND_FACILITY_ID' value='"+facility_ID+"'>";
				htmlVal += "<input type='hidden' name='SESSION_ID' id='SESSION_ID' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='PGM_DATE' id='PGM_DATE' value='"+trim(pgm_date)+"'>";
				htmlVal += "<input type='hidden' name='PGM_ID' id='PGM_ID' value='"+p_report_id+"'>";
				htmlVal += "<input type='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' value='"+locale+"'>";		
				htmlVal += "<input type='hidden' name='P_USER_ID' id='P_USER_ID' value='"+userId+"'>";	
				htmlVal += "<input type='hidden' name='PRICE_IND' id='PRICE_IND' value='"+prcInd+"'>";	
				htmlVal += "<input type='hidden' name='PRICE_IND1' id='PRICE_IND1' value='"+prcInd1+"'>";
				htmlVal += "<input type='hidden' name='ACTIVE' id='ACTIVE' value='"+status+"'>";			
				htmlVal += "</form></body></html>";
				dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.dummy_frm.submit();
				},
				 error: function(data){
					 alert(data);
			  }
		});	
	//}
}

//V201222 Starts
function onBlurEvent(r){
	var fromId="";
	var toId="";
	if(r==1){
		fromId="FrmCustCode";
		toId="ToCustCode";
		if( $("#FrmCustCode").val() != "" || $("#ToCustCode").val() != ""){
			$("#FrmBillingGrp").attr("disabled", true);
    		$("#FrmBillingGrplookUp").attr("disabled", true);
    		$('#FrmBillingGrp').val("");
    		$('#FrmBillingGrpHid').val("");
    		$("#ToBillingGrp").attr("disabled", true);
    		$("#ToBillingGrplookUp").attr("disabled", true);
    		$('#ToBillingGrp').val("");
    		$('#ToBillingGrpHid').val("");
		}else{
			$("#FrmBillingGrp").attr("disabled", false);
    		$("#FrmBillingGrplookUp").attr("disabled", false);
    		$('#FrmBillingGrp').val("");
    		$('#FrmBillingGrpHid').val("");
    		$("#ToBillingGrp").attr("disabled", false);
    		$("#ToBillingGrplookUp").attr("disabled", false);
    		$('#ToBillingGrp').val("");
    		$('#ToBillingGrpHid').val("");
		}
	}else if(r==2){
		fromId="FrmBillingGrp";
		toId="ToBillingGrp";
		if( $("#FrmBillingGrp").val() != "" || $("#ToBillingGrp").val() != ""){
			$("#FrmCustCode").attr("disabled", true);
    		$("#FrmCustCodelookUp").attr("disabled", true);
    		$('#FrmCustCode').val("");
    		$('#FrmCustCodeHid').val("");
    		$("#ToCustCode").attr("disabled", true);
    		$("#ToCustCodelookUp").attr("disabled", true);
    		$('#ToCustCode').val("");
    		$('#ToCustCodeHid').val("");
		}else{
			$("#FrmCustCode").attr("disabled", false);
    		$("#FrmCustCodelookUp").attr("disabled", false);
    		$('#FrmCustCode').val("");
    		$('#FrmCustCodeHid').val("");
    		$("#ToCustCode").attr("disabled", false);
    		$("#ToCustCodelookUp").attr("disabled", false);
    		$('#ToCustCode').val("");
    		$('#ToCustCodeHid').val("");
		}
	}
	
}
//V201222 Ends

$(function() {
	// Setting default value of Group By as Customer and Status to active and Facility Id by default
    var tempCust="C";		 //V201222 Modified
    var tempStatus="A";		//V201222 Added
    var tempFacId=$('#facilityId').val();	//V201222 Added
    $("#groupby").val(tempCust); 		//V201222 Modified
    $("#status").val(tempStatus);		//V201222 Added
    $("#facility_ID").val(tempFacId);	//V201222 Added
    //Disable Standard Price by default
	$("#standardPrice").attr("disabled", true);
    
    //Change Event of Price Indicator
    $("#PriceInd").change(function() {
    	// Standard Price Disable function
    	var pricIndval=$('#PriceInd').val();
    	if(pricIndval=='P' || pricIndval=='C' || pricIndval=='B'){
        	$("#standardPrice").attr("disabled", false);   		
    	}else{
        	$("#standardPrice").prop('checked', false);
        	$("#standardPrice").attr("disabled", true);
    	}
    	if(pricIndval=='P' || pricIndval=='S'){
    		$("#FrmCustCode").attr("disabled", true);
    		$("#FrmCustCodelookUp").attr("disabled", true);
    		$('#FrmCustCode').val("");
    		$('#FrmCustCodeHid').val("");
    		$("#ToCustCode").attr("disabled", true);
    		$("#ToCustCodelookUp").attr("disabled", true);
    		$('#ToCustCode').val("");
    		$('#ToCustCodeHid').val("");
    		$("#FrmBillingGrp").attr("disabled", true);
    		$("#FrmBillingGrplookUp").attr("disabled", true);
    		$('#FrmBillingGrp').val("");
    		$('#FrmBillingGrpHid').val("");
    		$("#ToBillingGrp").attr("disabled", true);
    		$("#ToBillingGrplookUp").attr("disabled", true);
    		$('#ToBillingGrp').val("");
    		$('#ToBillingGrpHid').val("");
    	}else if(pricIndval=='C'){
    		$("#FrmBillingGrp").attr("disabled", true);
    		$("#FrmBillingGrplookUp").attr("disabled", true);
    		$('#FrmBillingGrp').val("");
    		$('#FrmBillingGrpHid').val("");
    		$("#ToBillingGrp").attr("disabled", true);
    		$("#ToBillingGrplookUp").attr("disabled", true);
    		$('#ToBillingGrp').val("");
    		$('#ToBillingGrpHid').val("");
    		$("#FrmCustCode").attr("disabled", false);
    		$("#FrmCustCodelookUp").attr("disabled", false);
    		$("#ToCustCode").attr("disabled", false);
    		$("#ToCustCodelookUp").attr("disabled", false);
    	}else if(pricIndval=='B'){
    		$("#FrmBillingGrp").attr("disabled", false);
    		$("#FrmBillingGrplookUp").attr("disabled", false);
    		$("#ToBillingGrp").attr("disabled", false);
    		$("#ToBillingGrplookUp").attr("disabled", false);
    		$("#FrmCustCode").attr("disabled", true);
    		$("#FrmCustCodelookUp").attr("disabled", true);
    		$('#FrmCustCode').val("");
    		$('#FrmCustCodeHid').val("");
    		$("#ToCustCode").attr("disabled", true);
    		$("#ToCustCodelookUp").attr("disabled", true);
    		$('#ToCustCode').val("");
    		$('#ToCustCodeHid').val("");
    	}else{
    		$("#FrmBillingGrp").attr("disabled", false);
    		$("#FrmBillingGrplookUp").attr("disabled", false);
    		$("#ToBillingGrp").attr("disabled", false);
    		$("#ToBillingGrplookUp").attr("disabled", false);
    		$("#FrmCustCode").attr("disabled", false);
    		$("#FrmCustCodelookUp").attr("disabled", false);
    		$("#ToCustCode").attr("disabled", false);
    		$("#ToCustCodelookUp").attr("disabled", false);
    	}
    });
});


function priceListCommonLookup(sqlselect, obj, code,lookupName){
	var facility = $('#facilityId').val();
	var locale   =  $('#locale').val();
    var formObj  = document.forms[0];
  
    var title = "";
	var sql   = "";
	switch (lookupName) {
		case 'custCode' :{
			sql="select cust_code code,short_name description from ar_customer_lang_vw where upper(language_id) = upper('" +
			locale +
			"')  and UPPER (cust_code) LIKE UPPER (?) AND UPPER (short_name) LIKE UPPER (?) order by 1 ";
			switch(sqlselect){
				case 1:{
					title = 	getLabel("eBL.FrmCustCode.label", 'bl');
					break;
				}
				case 2:{
					title = 	getLabel("eBL.ToCustCode.label", 'bl');  //V201222 Modified
					break;
				}
			}
			break;
		}
		case 'billingGrp' :{
			sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where nvl(status,'X') != 'S' and upper(language_id) = upper('" +
			locale +
			"') AND UPPER (blng_grp_id) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?)  order by 1  ";
			switch(sqlselect){
				case 1:{
					title = getLabel("eBL.FrmBillingGrp.label", 'bl');
					break;
				}
				case 2:{
					title = getLabel("eBL.ToBillingGrp.label", 'bl');
					break;
				}
			}
			break;
		}
		case 'billingCls' :{
			sql="SELECT short_desc description,blng_class_code code FROM bl_blng_class_lang_vw "+
			 "WHERE language_id='"+locale +"' AND UPPER (blng_class_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) "+
			 "UNION "+
			 "SELECT 'ALL','**' from dual ORDER BY 1 ";
			switch(sqlselect){
				case 1:{
					title = getLabel("eBL.frmBillingClass.label", 'bl');
					break;
				}
				case 2:{
					title = getLabel("eBL.toBillingClass.label", 'bl');
					break;
				}
			}
			break;
		}
		case 'billingServ' :{
			 sql="select short_desc description, blng_serv_code  code from  bl_blng_serv_lang_vw where language_id ='"+locale +"'" +
			 	" AND UPPER (blng_serv_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ";
			switch(sqlselect){
				case 1:{
					title = getLabel("eBL.frmBillingServ.label", 'bl');
					break;
				}
				case 2:{
					title = getLabel("eBL.toBillingServ.label", 'bl');
					break;
				}
			}
			break;
		}
		case 'CreateAmendBy' :{
			sql="select username description,user_id code "+
			 "from sy_user "+
			 "where facility_id='"+facility+"' "+
			 "and user_id in(select bl_user_id from bl_user "+
			 "where nvl(status,'N') != 'S' "+
		     "and operating_facility_id='"+facility+"') "+
		     "and nvl(status,'N') != 'S' AND UPPER (username) LIKE UPPER (?) AND UPPER (user_id) LIKE UPPER (?)  ORDER BY 1 ";
			switch(sqlselect){
				case 1:{
					title = getLabel("eBL.frmCreateAmendBy.label", 'bl');
					break;
				}
				case 2:{
					title = getLabel("eBL.toCreateAmendBy.label", 'bl');
					break;
				}
			}
			break;
		}
		
	}
	    var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "1,2";							//V201222 Modified
	    argumentArray[5] = code.value;
	    argumentArray[6] = CODE_LINK;						//V201222 Modified
	    argumentArray[7] = CODE_DESC;						//V201222 Modified

	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		obj.value			=   retVal[0];
		code.value 			= 	retVal[1];
		//V201222 Starts
		if(lookupName=="custCode"){
			onBlurEvent('1');
		}
		else if(lookupName=="billingGrp"){
			onBlurEvent('2');
		}
		//V201222 Ends
	}
	else
	{
        obj.value = '';
        code.value = '';
	}

}

function toFromCheck(option){
    var formsObj = document.forms[0];
    var fm_CustCode	 = $('#FrmCustCode').val();
    var To_CustCode	 = $('#ToCustCode').val();
    var Frm_bill_Gp	 = $('#FrmBillingGrp').val();
    var To_bill_Gp	 = $('#ToBillingGrp').val();
    var Frm_bill_Cls = $('#frmBillingClass').val();
    var To_bill_Cls	 = $('#toBillingClass').val();
    var Frm_bill_Serv= $('#frmBillingServ').val();
    var To_bill_Serv = $('#toBillingServ').val();
    var Frm_Amend_By = $('#frmCreateAmendBy').val();
    var To_Amend_By	 = $('#toCreateAmendBy').val();
   
if(option==1){ 
	 if(fm_CustCode != '' && To_CustCode !=''){  
			if((!isBeforefm(fm_CustCode,To_CustCode)))
			{		
				alert(getMessage("BL7060",'BL'));
				$('#ToCustCode').val()= '';
				$('#ToCustCodeHid').val()= '';
				return false;
			}
			else
			{			
				return true;
			}
			
		}
 }
if(option==2){
	if(Frm_bill_Gp != '' && To_bill_Gp !=''){
		if((!isBeforefm(Frm_bill_Gp,To_bill_Gp)))
		{		
			alert(getMessage("BL7060",'BL'));
			$('#ToBillingGrp').val() = '';
			$('#ToBillingGrpHid').val() = '';
			return false;
		}
		else
		{			
			return true;
		}
		
	}
}			
if(option==3){
	if(Frm_bill_Cls != '' && To_bill_Cls !=''){
		if((!isBeforefm(Frm_bill_Cls,To_bill_Cls)))
		{		
			alert(getMessage("BL7060",'BL'));
			$('#toBillingClass').val() = '';
			$('#ToBillingClsHid').val() = '';
			return false;
		}
		else
		{			
			return true;
		}
		
	}
}

if(option==4){
	if(Frm_bill_Serv != '' && To_bill_Serv !=''){
		if((!isBeforefm(Frm_bill_Serv,To_bill_Serv)))
		{		
			alert(getMessage("BL7060",'BL'));
			$('#toBillingServ').val() = '';
			$('#toBillingServHid').val() = '';
			return false;
		}
		else
		{			
			return true;
		}
		
	}
 }
if(option==5){
	if(Frm_Amend_By != '' && To_Amend_By !=''){
		if((!isBeforefm(Frm_Amend_By,To_Amend_By)))
		{		
			alert(getMessage("BL7060",'BL'));
			$('#toCreateAmendBy').val() = '';
			$('#toCreateAmendByHid').val() = '';
			return false;
		}
		else
		{			
			return true;
		}
		
	}
 }

}

function isBeforefm(from,to){
	if(from>to){
		return false;
	}else 
		return true;
}

function dateValidation(opt){
	if(opt==1){
		var Frm_Eff_Date = $('#frmEffDate').val();
		var To_Eff_Date	 = $('#toEffDate').val();
		if(process(Frm_Eff_Date)>process(To_Eff_Date)){
			alert(getMessage("BL00613",'BL'));
			document.getElementById('toEffDate').value="";
			document.getElementById('toEffDate').focus();
		}
	}
	else if(opt==2){
		var Frm_Amend_Date = $('#frmCreateAmendDate').val();
		if(process(Frm_Amend_Date)>process(getCurrentDate())){    //V201222 Modified
			alert(getMessage("BL6015",'BL'));
			document.getElementById('frmCreateAmendDate').value=getCurrentDate();   //V201222 Modified
		    document.getElementById('frmCreateAmendDate').focus();
		}
	}
	else if(opt==3){
		var Frm_Amend_Date = $('#frmCreateAmendDate').val();
		var To_Amend_Date	 = $('#toCreateAmendDate').val();
		if(process(Frm_Amend_Date)>process(To_Amend_Date)){
			alert(getMessage("BL00613",'BL'));
			document.getElementById('toCreateAmendDate').value="";
			document.getElementById('toCreateAmendDate').focus();
		}
	}
}

function process(date){
	   var parts = date.split("/");
	   return new Date(parts[2], parts[1] - 1, parts[0]);
	}


function dateRegEx(e){  //Added for Character Restriction in date field
	  var pattern = new RegExp("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");			//V201222 Modified
	  if (e.value.search(pattern)===0){															//V201222 Modified
	    return true;
	  }
	  else {
	    alert("Please provide valid date in format DD/MM/YYYY");								//V201222 Modified			
	    document.getElementById(e.id).value=getCurrentDate();									//V201222 Modified
	    document.getElementById(e.id).focus();
	    return false; 
	  } 
}

function getCurrentDate()								//V201222 Modified
{
	var currentdate = new Date(); 
		var month=("0" + (currentdate.getMonth() + 1)).slice(-2);
		datetime = 	   currentdate.getDate() + "/"
				+  month  + "/" 
				+  currentdate.getFullYear();
				return datetime;
}

//Function to Trim String
function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 

