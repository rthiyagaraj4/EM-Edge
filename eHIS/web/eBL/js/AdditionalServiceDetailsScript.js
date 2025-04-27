//Script added by Ruban Ponraj for Additional Services/ Discount
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
----------------------------------------------------------------------------------------------
1	     	 V210616			20216			MMS-ME-SCF-0028-TF         	   MuthukumarN
2			 V211109			7871			MMS-QH-CRF-0128				   Manivel Natarajan
3            V211224             27155          MMS-ICN-00127-TF               Mohanapriya K
4          V230410			40151			MOHE-SCF-0214-TF			   Mohanapriya
*/

async function billingClassLookup()
{
	var sql;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	
//	sql = "Select description, code from (SELECT Short_Desc DESCRIPTION, Blng_Class_Code CODE FROM BL_BLNG_CLASS_lang_vw WHERE LANGUAGE_ID='"+locale+"' Union Select 'All Billing Class','A' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
	var title									= 	getLabel("Common.BillingClass.label", 'common');
	var argumentArray  	= 	new Array() ;
	var dataNameArray  	= 	new Array() ;
	var dataValueArray 	= 	new Array() ;
	var dataTypeArray  	= 	new Array() ;
	var billingClass  	=	document.getElementById('bilng_class');
	var hdnBillingCls	=	document.getElementById('billing_class');
	sql="BLINTERNALREP_8::blsql::"+locale+"::";//V230410
	argumentArray[0]	= 	sql;
	argumentArray[1]   	= 	dataNameArray ;
	argumentArray[2]   	= 	dataValueArray ;
	argumentArray[3]   	= 	dataTypeArray ;
	argumentArray[4]   	= 	"2,1";
	argumentArray[5]   	= 	billingClass.value;
	argumentArray[6]   	= 	DESC_LINK ;
	argumentArray[7]   	= 	DESC_CODE ;
	retVal 				=  await  CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "")
	{
		billingClass.value 	= 	arr[1];
		hdnBillingCls.value = 	arr[0];
	}
	else
	{
		billingClass.value	    =	"";
		hdnBillingCls.value 	= 	"";
	}
}

function showPriceDetails()
{

	//alert('Inside show price details function>>>>>1');
	var serviceCode 	= document.getElementById("service_code").value;
	var billingClass 	= document.getElementById("billing_class").value;
	//var serviceIndicator			 			= document.getElementById("service_ind");
	var priceInd 		= document.getElementById("price_ind");
	var discApplicability = document.getElementById("disc_applicability").value;
	var serviceDescription= document.getElementById("service_description").value;
	var priceDescription= document.getElementById("price_description").value;
	var EffectiveFrom	= document.getElementById("Effective_from").value;
	var EffectiveTo		= document.getElementById("Effective_to").value;
	var Desc			= document.getElementById("Desc");
	var priceCode		= document.getElementById("price_code").value;


	var serviceind = document.getElementById("service_ind");
	for(var j=0; j<serviceind.options.length; j++)
	{
		if(serviceind.options[j].selected)
			serviceIndicator=serviceind.options[j].value;
	}

	var chargeType;
	var charge_type = document.getElementById("charge_type");
	for(var x=0; x < charge_type.options.length; x++)
	{
		//alert("===for==x=="+x+"===sel=="+charge_type.options[x].selected);
		if(charge_type.options[x].selected)
			{
			chargeType = charge_type.options[x].value;
			if(chargeType==undefined || chargeType=='')
			{
				//alert(getMessage("BL07286","BL"));
				chargeType = null;
				//return;
			}
			}
	}

	var disc_applicability = document.getElementById("disc_applicability");
	for(var j=0; j<disc_applicability.options.length; j++)
	{
		if(disc_applicability.options[j].selected){
			discApplicability=disc_applicability.options[j].value;
			if(discApplicability==undefined || discApplicability=='')
			{
				//alert(getMessage("BL07286","BL"));
				discApplicability = null;
				//return;
			}
		}
	}
	var Description=null;
	if(Desc.checked)
		{
		 Description = "Y";
		}
	else{
		Description = "N";
	}
	var price_ind = document.getElementById("price_ind");
//	for(var j=0; j<price_ind.options.length; j++)
//    {
//		if(price_ind.options[j].selected)
//			price_ind=price_ind.options[j].value;
//    }
	for(var j=0; j<price_ind.options.length; j++)
	{
		if(price_ind.options[j].selected)
			priceInd=price_ind.options[j].value;
	}
//
/*		var serviceDescription																		=	document.getElementById("service_description").value;
	var priceDescription																		=	document.getElementById("price_description").value;
	var customerGroupCode																		=	document.getElementById("payer_group").value;
	var validFromDate																			=	document.getElementById("Effective_from").value;
	var validToDate																				=	document.getElementById("Effective_to").value;
	var desc																					=	document.getElementById("Desc").value;
	var policyCode																				=	document.getElementById("policy").value;
	 */

	if(serviceIndicator==undefined || serviceIndicator=='')
	{
		alert(getMessage("BL07281","BL"));
		return;
	}

			if(EffectiveFrom==undefined || EffectiveFrom=='')
	{
		//alert(getMessage("BL00004","BL"));
		EffectiveFrom = null;
		//return;
	}
	if(EffectiveTo==undefined || EffectiveTo=='')
	{
		//alert(getMessage("BL8560","BL"));
		EffectiveTo = null;
		//return;
	}
	if(serviceCode==undefined || serviceCode=='')
	{
		//alert(getMessage("BL07282","BL"));
		serviceCode = null;
		//return;
	}
	if(serviceDescription==undefined || serviceDescription=='')
	{
		//alert(getMessage("BL07283","BL"));
		serviceDescription = null;
		//return;
	}
	if(priceInd==undefined || priceInd=='')
	{
		alert(getMessage("BL07284","BL"));
		//priceInd = null;
		return;
	}
	if(priceDescription==undefined || priceDescription=='')
	{
		//alert(getMessage("BL07285","BL"));
		priceDescription = null;
		//return;
	}
	if(priceCode==undefined || priceCode=='')
	{
		//alert(getMessage("BL07286","BL"));
		priceCode = null;
		//return;
	}
	if(billingClass==undefined || billingClass=='')
	{
		alert(getMessage("BL07287","BL"));
		return;
	}


/*		var starr = document.getElementById('Effective_from').value.split("/");
	var enarr = document.getElementById('Effective_to').value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;
	if(startdt>enddt)
	{
		alert(getMessage('BL4115','BL'));
		return;
	}
	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
	if(daysDiff > 30)
	{
			alert("Encounter To Date Cannot be greter than 30 Days from Encounter from Date");
			return;
	}
*/
	//alert('Inside show price details function END>>>>');
	//Added By Rajesh V - To Show Progress Bar
	fnShowProgress();
	parent.additionalServiceDiscountDetails.location.href = "../../eCommon/html/blank.html";
	//Added By Rajesh V - To Show Progress Bar
	parent.additionalServicePriceDetails.location.href = "../../eBL/jsp/AdditionalServicePriceDetails.jsp?serviceIndicator="+serviceIndicator+"&serviceCode="+serviceCode
	+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&billingClass="+billingClass+"&EffectiveFrom="+EffectiveFrom+"&EffectiveTo="+EffectiveTo+"&chargeType="+chargeType+"&discApplicability="+discApplicability+"&Description="+Description;
}
 function serviceindreset() {
	document.getElementById('service_code').value = "";
	document.getElementById('service_description').value = "";
	var serviceInd = document.getElementById('service_ind').value;
	if(serviceInd == 'A'){
		document.getElementById('service_code').disabled = true;
		document.getElementById('service_description').disabled = true;
		document.getElementById('servicecodebut').disabled = true;
	}
	else if(serviceInd != 'A'){
		document.getElementById('service_code').disabled = false;
		document.getElementById('service_description').disabled = false;
		document.getElementById('servicecodebut').disabled = false;
	}
}

 function priceindreset() {
	document.getElementById('price_code').value = "";
	document.getElementById('price_description').value = "";
	var priceInd = document.getElementById('price_ind').value;
	if(priceInd == 'A'){
		document.getElementById('price_code').disabled = true;
		document.getElementById('price_description').disabled = true;
		document.getElementById('priceindbut').disabled = true;
	}
	else if(priceInd != 'A'){
		document.getElementById('price_code').disabled = false;
		document.getElementById('price_description').disabled = false;
		document.getElementById('priceindbut').disabled = false;
	}
}

	async function serviceCodeLookUp(){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	//	alert("===========locale=================="+locale);
	//	alert("===========facility_id=================="+facility_id);
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	var s			   = document.getElementById("service_ind");
	//	alert("inside serviceCodeLookUp function>>>111111");
	 var selectedValue;
		for(var j=0; j<s.options.length; j++)
		{
			if(s.options[j].selected)
				selectedValue=s.options[j].value;
		}
		var serviceIndicator = selectedValue;
	//	alert("inside selectedvalue function>>>111111"+selectedValue);
	//		switch(selectedValue)
	//		{
	//			case 'Service Group'		:		serviceIndicator = 'BSG';
	//												break;
	//			case 'Classification'		:		serviceIndicator = 'BSGC';
	//												break;
	//			case 'Billing Service'		:		serviceIndicator = 'S';
	//												break;
	//		}
	//	switch(sqlSelect){

	//		case 1:
	//		{
	//			var cust_code = document.forms[0].payerCode2.value;
	//			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
	//					"Where acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
	//					"and nvl(patient_flag,'N')  ='Y' "+
	//					"and nvl(pat_com_flag,'N')='N' "+
	//					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
	//					"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";
	//
	//			title = 'Payer';
	//			break;
	//		}

	//	}
		if(serviceIndicator == 'B'){
		//	alert("inside serviceCodeLookUp function>>>ssssssss");
            sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";	//Removed Union Select 'All Billing Services','**' From Dual against V211224
			title = 'Billing Services';
		}
		else if(serviceIndicator == 'BSG'){
	  //  	alert("inside serviceCodeLookUp function>>>111111BSG");
            sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
			title = 'Service Group';
		}
		else if(serviceIndicator == 'BSC'){
	  //  	alert("inside serviceCodeLookUp function>>>111111BSGC");
            sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
			title = 'Billing Classification';
		}
		else if(serviceIndicator == 'PG'){ //Loop added for V211109
			//alert("inside serviceCodeLookUp function>>>111111BSGC");
			sql = "Select description, code from (select short_desc description,package_serv_group_code code from bl_pkg_grp_hdr_lang_vw where nvl(discount_applicable_yn,'N') = 'Y' and upper(language_id) = upper('"+locale+"') and OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Package Group';		
		}

	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//	alert('sql------------------>'+sql)
		
		
		
		
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_description.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	//argumentArray[6] = DESC_LINK;
	//argumentArray[7] = DESC_CODE;
	//	alert("=======argumentArray========="+argumentArray);
	retval = await CommonLookup(title, argumentArray );
	//	alert("===returnedValues==="+returnedValues);
	if((retval != null) && (retval != "") )  {
		if(retval.length === 1){
			retval = retval[0].split(',');
		}
		document.forms[0].service_description.value = retval[1];
		document.forms[0].service_code.value = retval[0];
	}
	else
	{
	document.forms[0].service_description.value = '';
	document.forms[0].service_code.value = '';
		//obj.value = returnedValues[1];
	}
}
	
async function serviceCodeLookUpCode(){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	var s			   = document.getElementById("service_ind");

	 var selectedValue;
		for(var j=0; j<s.options.length; j++)
		{
			if(s.options[j].selected)
				selectedValue=s.options[j].value;
		}
		var serviceIndicator = selectedValue;

		if(serviceIndicator == 'B'){
	            sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';
		}
	        else if(serviceIndicator == 'BSG'){
	            sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
			title = 'Service Group';
		}
		else if(serviceIndicator == 'BSC'){
	            sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
			title = 'Billing Classification';
		}else if(serviceIndicator == 'PG'){ //Loop added for V211109
			sql = "Select description, code from (select short_desc description,package_serv_group_code code from bl_pkg_grp_hdr_lang_vw where nvl(discount_applicable_yn,'N') = 'Y' and upper(language_id) = upper('"+locale+"') and OPERATING_FACILITY_ID = '"+facility_id+"') where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Package Group';		
		}


	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;


	retval = await CommonLookup(title, argumentArray );
	if((retval != null) && (retval != "") )  {
		if(retval.length === 1){
			retval = retval[0].split(',');
		}
		document.forms[0].service_description.value = retval[1];
		document.forms[0].service_code.value = retval[0];
	}
else
	{
	document.forms[0].service_description.value = '';
	document.forms[0].service_code.value = '';
	}

}
	
async function priceIndCodeLookup(){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
//	alert("===========locale=================="+locale);
//		alert("===========facility_id=================="+facility_id);
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	var p			   = document.getElementById("price_ind");
//	alert("inside priceIndCodeLookup function>>>111111"+p.value);
	 var selectedValue;
		for(var j=0; j<p.options.length; j++)
		{
			if(p.options[j].selected)
				selectedValue=p.options[j].value;
		}
		var serviceIndicator = selectedValue;
//			switch(selectedValue)
//			{
//			case 'Standard'				:		serviceIndicator = 'S';
//													break;
//				case 'Customer Price'		:		serviceIndicator = 'C';
//													break;
//				case 'Billing Group Price'	:		serviceIndicator = 'B';
//													break;
//				case 'Price Class Price'	:		serviceIndicator = 'P';
//													break;
//			}
		if(selectedValue == 'C'){
//			alert("inside priceIndCodeLookup function>>>cccccc");
			sql = "Select description, code from (SELECT Short_Name DESCRIPTION, Cust_code CODE  FROM ar_customer_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND  acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"')  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = "Price indicator - Customer";
		}
		else if(selectedValue == 'P'){
//    	alert("inside priceIndCodeLookup function>>>ppppp");
			sql = "Select description, code from (SELECT Short_Desc DESCRIPTION, Price_Class_Code CODE  FROM bl_price_class_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)   order by 2";
			title = 'Price Indicator - Price class';
		}
		else if(selectedValue == 'S'){
//        	alert("inside priceIndCodeLookup function>>>sssss");
			sql="Select description, code from (select facility_name description,facility_id code from sm_facility_param WHERE LANGUAGE_ID = '"+locale+"'  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Price Indicator - standerd';
		}
		else if(selectedValue == 'B'){
			sql = "Select description, code from (SELECT short_desc DESCRIPTION, blng_grp_id CODE  FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Price Indicator - BillingGroup';
		}

//		alert("inside priceIndCodeLookup function>>>222222");

	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
//	alert('sql------------------>'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].price_description.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	//argumentArray[6] = DESC_LINK;
	//argumentArray[7] = DESC_CODE;
//		alert("=======argumentArray========="+argumentArray);
	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
//		alert("===returnedValues==="+returnedValues);
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].price_description.value = arr[1];
		document.forms[0].price_code.value = arr[0];
	}
else
	{
	document.forms[0].price_description.value = '';
	document.forms[0].price_code.value = '';
		//obj.value = returnedValues[1];
	}

}
	
async function priceIndCodeLookupCode(){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	var p			   = document.getElementById("price_ind");

	 var selectedValue;
		for(var j=0; j<p.options.length; j++)
		{
			if(p.options[j].selected)
				selectedValue=p.options[j].value;
		}
		var serviceIndicator = selectedValue;

		if(selectedValue == 'C'){

			sql = "Select description, code from (SELECT Short_Name DESCRIPTION, Cust_code CODE  FROM ar_customer_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND  acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"')  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = "Price indicator - Customer";
		}
		else if(selectedValue == 'P'){

			sql = "Select description, code from (SELECT Short_Desc DESCRIPTION, Price_Class_Code CODE  FROM bl_price_class_lang_vw WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)   order by 2";
			title = 'Price Indicator - Price class';
		}
		else if(selectedValue == 'S'){

			sql="Select description, code from (select facility_name description,facility_id code from sm_facility_param WHERE LANGUAGE_ID = '"+locale+"'  Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Price Indicator - standerd';
		}
		else if(selectedValue == 'B'){
			sql = "Select description, code from (SELECT short_desc DESCRIPTION, blng_grp_id CODE  FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Price Indicator - BillingGroup';
		}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].price_code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].price_description.value = arr[1];
		document.forms[0].price_code.value = arr[0];
	}
else
	{
	document.forms[0].price_description.value = '';
	document.forms[0].price_code.value = '';
	}

}
	
function showPriceDetailsData(index)
{
	//alert("==========showPriceDetailsData====index============"+index);
	//document.getElementById('printUCAFIndex').value = index;
	/*document.getElementById('patient_id'+index).focus();
	document.getElementById('patient_id'+index).select();
	*//*document.getElementById('srl_no'+index).style.fontWeight = 'bold';
	document.getElementById('patient_id'+index).style.fontWeight = 'bold';
	document.getElementById('patient_name'+index).style.fontWeight = 'bold';
	document.getElementById('episode_id'+index).style.fontWeight = 'bold';
	document.getElementById('encounter_id'+index).style.fontWeight = 'bold';
	document.getElementById('policy'+index).style.fontWeight = 'bold';
	document.getElementById('payer_group'+index).style.fontWeight = 'bold';
	document.getElementById('payer'+index).style.fontWeight = 'bold';
	document.getElementById('age'+index).style.fontWeight = 'bold';
	document.getElementById('mobile_number'+index).style.fontWeight = 'bold';
	document.getElementById('policy_effective_from'+index).style.fontWeight = 'bold';
	document.getElementById('effective_to'+index).style.fontWeight = 'bold';
	document.getElementById('approved_amount'+index).style.fontWeight = 'bold';*/

//	alert("==========showPriceDetailsData============222222222facility_id"+facility_id);

	//var facilityId 					=	trimString(document.getElementById('facility_id'+index).innerText) ;

//  alert("==========inside===showPriceDetailsData=========1service_ind-------"+(document.getElementById('service_ind'+index).value));
	var facility_id					=	trimString(document.getElementById('facility'+index).value) ; //Added NMC-JD-CRF-0014 by shikha on 200902
	var serviceInd					=	trimString(document.getElementById('service_ind'+index).value) ;
//	alert("==========inside===showPriceDetailsData=========2service_code"+document.getElementById('service_code'+index).value);
	var serviceCode					=	trimString(document.getElementById('service_code'+index).innerText) ;
//	alert("==========inside===showPriceDetailsData=========3service_description"+document.getElementById('service_description'+index).value);
	var serviceDescription			=	trimString(document.getElementById('service_description'+index).innerText );
//	alert("==========inside===showPriceDetailsData=========4price_ind"+document.getElementById('price_ind'+index).value);
	var priceInd					=	trimString(document.getElementById('price_ind'+index).value) ;
	//alert("==========inside===showPriceDetailsData=========5price_code"+document.getElementById('price_code'+index).value);
	var priceCode					=	trimString(document.getElementById('price_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========6price_description"+document.getElementById('price_description'+index).value);
	var priceDescription			=	trimString(document.getElementById('price_description'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========7policy_code"+document.getElementById('policy_code'+index).value);
	var policyCode					=	trimString(document.getElementById('policy_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========8policy_desc"+document.getElementById('policy_desc'+index).value);
	var policyDesc   				=  	trimString(document.getElementById('policy_desc'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========9cust_code"+document.getElementById('cust_code'+index).value);
	var custCode   					=  	trimString(document.getElementById('cust_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========billing_class=="+document.getElementById('billing_class'+index).value);
	var custDesc					=  	trimString(document.getElementById('cust_desc'+index).innerText);
	var billingClass				=  	trimString(document.getElementById('billing_class'+index).value);
	//var billingClass				=  	document.forms[0].billingClass.value;
	var EffectiveTo					=  	trimString(document.getElementById('Effective_to'+index).value);
	var desc						=  	trimString(document.getElementById('Desc'+index).value);
	var EffectiveFrom				=  	trimString(document.getElementById('Effective_from'+index).value);
	var discApplicability			=  	trimString(document.getElementById('disc_applicability'+index).value);
	var chargeType					=  	trimString(document.getElementById('charge_type'+index).value);
//	alert("==========showPriceDetailsData============333333333");
			
	parent.additionalServiceDiscountDetails.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+serviceInd
	+"&serviceCode="+serviceCode+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&policyCode="+policyCode
	+"&policyDesc="+encodeURIComponent(policyDesc)+"&custCode="+custCode+"&custCode="+custCode+"&custDesc="+encodeURIComponent(custDesc)+"&billingClass="+billingClass+"&EffectiveTo="+EffectiveTo+"&desc="+desc+"&EffectiveFrom="+EffectiveFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType+"&facility_id="+facility_id; //Modified NMC-JD-CRF-0014 by shikha on 200902
	
	parent.additionalServiceDiscountDetailsAdd.location.href = "../../eBL/jsp/AdditionalServiceDetailsAdd.jsp";
//	alert("==========showPriceDetailsData============4444444444");
}
	
async function fnViewModify(index){
	//alert("====index value===="+index);
	var dialogHeight= "95vh" ;
	var dialogWidth	= "96vw" ;

	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;
	var mode = 'modify';
	var facilityId = document.getElementById('facilityId').value;		//Added NMC-JD-CRF-0014 by shikha on 200902
	var servInd = document.getElementById('service_ind'+index).value;
	var servCode = document.getElementById('service_code').value ;
	var serviceDescription = document.getElementById('service_desc').value ;
	var priceInd = trimString(document.getElementById('Indicator'+index).innerText);
	var priceCode = document.getElementById('price_code').value;
	var priceDescription = document.getElementById('price_desc').value ;
	var policyCode = document.getElementById('policy_code').value;
	var policyDesc = document.getElementById('policy_desc').value ;
	var custGrpCode = document.getElementById('cust_code').value;
	var custDesc = document.getElementById('cust_desc').value ;
	var billngClass = trimString(document.getElementById('billing_class'+index).innerText);
	var effectFrom = trimString(document.getElementById('valid_from'+index).innerText);

	var staticBillngClass = document.getElementById('blng_class').value;
	var staticEffectFrom = document.getElementById('eff_from').value;
	var effTo = trimString(document.getElementById('valid_to'+index).innerText);
	var discApplicability = document.getElementById('desc_app').value;
	var desc = document.getElementById('description').value;
	var chargeType = document.getElementById('charge_type').value;

	var param = 'mode='+mode+'&servInd='+servInd+'&servCode='+servCode+'&serviceDescription='+serviceDescription+'&priceInd='+priceInd+'&priceCode='+priceCode+'&policyCode='+policyCode+
				'&custGrpCode='+custGrpCode+'&blngClass='+billngClass+'&effFrom='+effectFrom+'&effTo='+effTo+'&facilityId='+facilityId; //Modified NMC-JD-CRF-0014 by shikha on 200902
	var retVal = await top.window.showModalDialog('../../eBL/jsp/BLServiceDiscPriceCreateRecord.jsp?'+param,arguments,features);	
	parent.additionalServiceDiscountDetails.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+servInd
	+"&serviceCode="+servCode+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&policyCode="+policyCode
	+"&policyDesc="+encodeURIComponent(policyDesc)+"&custCode="+custGrpCode+"&custDesc="+encodeURIComponent(custDesc)+"&billingClass="+staticBillngClass+"&EffectiveTo="+effTo+"&desc="+desc+"&EffectiveFrom="+staticEffectFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType+"&facility_id="+facilityId;  //Modified NMC-JD-CRF-0014 by shikha on 200902
}

function billingServiceCodeLookup(index)
{
	var sql;
	sql											=	PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP+" '" +document.forms[0].locale.value+"'";
	var title									= 	getLabel("eBL.BLNG_SERV_CODE.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var billingServiceCode						=	document.getElementById('billing_service_code'+index);
	var billingServiceDesc						=	document.getElementById('billing_service_desc'+index);
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	billingServiceCode.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		billingServiceCode.value 				= 	retVal[0];
		billingServiceCode.title				=	retVal[0];
		billingServiceDesc.value 				= 	retVal[1];
		billingServiceDesc.title				=	retVal[1];
	}
	else
	{
		billingServiceCode.value 				= 	"";
		billingServiceCode.title				=	"";
		billingServiceDesc.value 				= 	"";
		billingServiceDesc.title				=	"";
	}
}

async function fnCreateRecord()
{
	var dialogHeight= "94vh" ;
	var dialogWidth	= "97vw" ;
	var doc = "" ;
	if(parent.additionalServiceDiscountDetails == undefined){
		doc = document.getElementById("additionalServiceDetails").contentWindow.document.getElementById("additionalServiceDiscountDetails").contentWindow.document ;
	} else{
		doc = parent.additionalServiceDiscountDetails.document;
	}
	var facility_id = doc.getElementById('facilityId').value; //Added NMC-JD-CRF-0014 by shikha on 200902
	var servInd = doc.getElementById('service_ind').value;
	//var servInd = doc.getElementById('service_ind'+index).value;
	var servCode = doc.getElementById('service_code').value ;
	var serviceDescription = doc.getElementById('service_desc').value ;
	var priceInd = doc.getElementById('price_ind').value;
	//var priceInd = trimString(doc.getElementById('Indicator'+index).innerText);
	var priceCode = doc.getElementById('price_code').value;
	var priceDescription = doc.getElementById('price_desc').value ;
	var policyCode = doc.getElementById('policy_code').value;
	var policyDesc = doc.getElementById('policy_desc').value ;
	var custGrpCode = doc.getElementById('cust_code').value;
	var custDesc = doc.getElementById('cust_desc').value ;
	var billngClass = doc.getElementById('blng_class').value;
	//var billngClass = trimString(doc.getElementById('blng_class'+index).innerText);
	//var effFrom = trimString(doc.getElementById('valid_from'+index).innerText);
	//var effTo = trimString(doc.getElementById('valid_to'+index).innerText);
	var effFrom = doc.getElementById('eff_from').value ;
	var effTo = doc.getElementById('eff_to').value;
	var discApplicability = doc.getElementById('desc_app').value;
	var desc = doc.getElementById('description').value;
	var chargeType = doc.getElementById('charge_type').value;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;
	var mode = 'insert';
	var param = 'mode='+mode+'&servInd='+servInd+'&servCode='+servCode+'&serviceDescription='+serviceDescription+'&priceInd='+priceInd+'&priceCode='+priceCode+'&policyCode='+policyCode+
	'&custGrpCode='+custGrpCode+'&blngClass='+billngClass;
	var retVal = await top.window.showModalDialog('../../eBL/jsp/BLServiceDiscPriceCreateRecord.jsp?'+param,arguments,features);
	
	if(parent.additionalServiceDiscountDetails !== undefined){
		parent.additionalServiceDiscountDetails.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+servInd
		+"&serviceCode="+servCode+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&policyCode="+policyCode
		+"&policyDesc="+encodeURIComponent(policyDesc)+"&custCode="+custGrpCode+"&custDesc="+encodeURIComponent(custDesc)+"&billingClass="+billngClass+"&EffectiveTo="+effTo+"&desc="+desc+"&EffectiveFrom="+effFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType+"&facility_id="+facility_id; //Modified NMC-JD-CRF-0014 by shikha on 200902
	} else {
		document.getElementById("additionalServiceDetails").contentWindow.document.getElementById("additionalServiceDiscountDetails").contentWindow.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+servInd
		+"&serviceCode="+servCode+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&policyCode="+policyCode
		+"&policyDesc="+encodeURIComponent(policyDesc)+"&custCode="+custGrpCode+"&custDesc="+encodeURIComponent(custDesc)+"&billingClass="+billngClass+"&EffectiveTo="+effTo+"&desc="+desc+"&EffectiveFrom="+effFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType+"&facility_id="+facility_id; //Modified NMC-JD-CRF-0014 by shikha on 200902
	}
}

function resetFields()
{
	document.getElementById('service_code').value = "";
	document.getElementById('service_description').value = "";
	document.getElementById('price_code').value = "";
	document.getElementById('price_description').value = "";
	document.getElementById('billing_class').value = "A";
	document.getElementById('bilng_class').value = "All Billing class";
	document.getElementById('Effective_from').value = "";
	document.getElementById('Effective_to').value = "";
	document.getElementById('Desc').checked = false;
	document.forms[0].price_ind.selectedIndex =0;
	document.forms[0].service_ind.selectedIndex =0;	
	document.forms[0].service_code.disabled = true;
	document.forms[0].price_code.disabled = true;  	
	document.forms[0].servicecodebut.disabled = true;
	document.forms[0].priceindbut.disabled = true;
	parent.additionalServicePriceDetails.location.href="../../eCommon/html/blank.html";
	parent.additionalServicePriceDetailsTraverse.location.href="../../eCommon/html/blank.html";
	parent.additionalServiceDiscountDetails.location.href="../../eCommon/html/blank.html";
}

//Function to disable all special characters in master codes.
function restrictCharacters(event){
	if( (event.keyCode >= 48) && (event.keyCode <= 57) )
		return true ;
	else
		return false;
}

function create()
{

}

function apply()
{
	/*	var rowCount = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById("record_approval_details_table").rows.length;
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].rowCount.value=rowCount;
		var authorized 			=	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById('authorized').value;
		var isUserCanAcess 		=	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById('isUserCanAcess').value;
		if(authorized == "Y" && isUserCanAcess == "Y")
		{
			parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].target='messageFrame';
			parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].method="post";
			parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].action="../../servlet/eBL.BillingRecordApprovalServlet";
			parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].submit();
		}*/
}

function onSuccess()
{
	//parent.frames[2].BillingRecordApproval.document.location.reload();
}

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

//Added By Ruban - To Chnage Field Color
function changeFieldColor(obj){
	obj = obj-1;
	var prevClicked = document.forms[0].prevClicked.value;
	if(prevClicked.length>0){
		document.getElementById('srl_no'+prevClicked).className =  "fields";
		document.getElementById('facility_id'+prevClicked).className =  "fields";
		document.getElementById('service_ind_val'+prevClicked).className =  "fields";
		document.getElementById('service_code'+prevClicked).className =  "fields";
		document.getElementById('service_description'+prevClicked).className =  "fields";
		document.getElementById('price_ind_val'+prevClicked).className =  "fields";
		document.getElementById('price_code'+prevClicked).className =  "fields";
		document.getElementById('price_description'+prevClicked).className =  "fields";
		document.getElementById('policy_code'+prevClicked).className =  "fields";
		document.getElementById('policy_desc'+prevClicked).className =  "fields";
		document.getElementById('cust_code'+prevClicked).className =  "fields";
		document.getElementById('cust_desc'+prevClicked).className =  "fields";
	}
		document.getElementById('srl_no'+obj).className =  "YELLOW";
		document.getElementById('facility_id'+obj).className =  "YELLOW";
		document.getElementById('service_ind_val'+obj).className =  "YELLOW";
		document.getElementById('service_code'+obj).className =  "YELLOW";
		document.getElementById('service_description'+obj).className =  "YELLOW";
		document.getElementById('price_ind_val'+obj).className =  "YELLOW";
		document.getElementById('price_code'+obj).className =  "YELLOW";
		document.getElementById('price_description'+obj).className =  "YELLOW";
		document.getElementById('policy_code'+obj).className =  "YELLOW";
		document.getElementById('policy_desc'+obj).className =  "YELLOW";
		document.getElementById('cust_code'+obj).className =  "YELLOW";
		document.getElementById('cust_desc'+obj).className =  "YELLOW";
		document.forms[0].prevClicked.value = obj;
}

//Added By Rajesh V
function fnShowProgress(){
	//parent.document.getElementById('mainFrame').rows = '22%,43%,0%,0%,27%,5%';
	parent.document.getElementById('additionalServiceDetailsSearch').style.height='24vh';
	parent.document.getElementById('progressFrame').style.height='40vh';
	parent.document.getElementById('additionalServicePriceDetailsTraverse').style.height='0vh';
	parent.document.getElementById('additionalServicePriceDetails').style.height='0vh';
	parent.document.getElementById('additionalServiceDiscountDetails').style.height='19vh';
	parent.document.getElementById('additionalServiceDiscountDetailsAdd').style.height='5vh';
	
	parent.progressFrame.document.location.href = '../../eCommon/jsp/process.jsp'
}

function fnHideProgress(){
	//parent.document.getElementById('mainFrame').rows = '22%,0%,7%,36%,27%,5%';
	parent.document.getElementById('additionalServiceDetailsSearch').style.height='27vh';
	parent.document.getElementById('progressFrame').style.height='0vh';
	parent.document.getElementById('additionalServicePriceDetailsTraverse').style.height='11vh';
	parent.document.getElementById('additionalServicePriceDetails').style.height='36vh';
	parent.document.getElementById('additionalServiceDiscountDetails').style.height='16vh';
	parent.document.getElementById('additionalServiceDiscountDetailsAdd').style.height='5vh';
	parent.progressFrame.document.location.href = '../../eCommon/html/blank.html'
}

function goNext(service_ind,service_code,service_description,price_ind,price_code,price_description,
		billing_class,Effective_from,Effective_to,charge_type,
				disc_applicability,Desc,fromRcrd,toRcrd){
	//parent.document.getElementById('mainFrame').rows = '22%,43%,0%,0%,27%,5%';
	parent.document.getElementById('additionalServiceDetailsSearch').style.height='24vh';
	parent.document.getElementById('progressFrame').style.height='40vh';
	parent.document.getElementById('additionalServicePriceDetailsTraverse').style.height='0vh';
	parent.document.getElementById('additionalServicePriceDetails').style.height='0vh';
	parent.document.getElementById('additionalServiceDiscountDetails').style.height='19vh';
	parent.document.getElementById('additionalServiceDiscountDetailsAdd').style.height='5vh';
	parent.progressFrame.document.location.href = '../../eCommon/jsp/process.jsp'
	parent.additionalServiceDiscountDetails.location.href = "../../eCommon/html/blank.html";
	parent.additionalServiceDiscountDetailsAdd.location.href = "../../eCommon/html/blank.html";
	parent.additionalServicePriceDetails.location.href = "../../eBL/jsp/AdditionalServicePriceDetails.jsp?serviceIndicator="+service_ind+"&serviceCode="+service_code+"&serviceDescription="+encodeURIComponent(service_description)+"&priceInd="+price_ind+"&priceCode="+price_code+"&priceDescription="+encodeURIComponent(price_description)+"&billingClass="+billing_class+"&EffectiveFrom="+Effective_from+"&EffectiveTo="+Effective_to+"&chargeType="+charge_type+"&discApplicability="+disc_applicability+"&Description="+Desc+"&fromRcrd="+fromRcrd+"&toRcrd="+toRcrd;
}

async function goAdd()
{
	var dialogHeight= "95vh" ;
	var dialogWidth	= "95vw" ;
	var doc = parent.additionalServiceDiscountDetails.document;
	//var servInd = "";//Commented against V210616
	var servInd = parent.frames[0].document.getElementById('service_ind').value;//Added against V210616
	//var servCode = "";
	var servCode = parent.frames[0].document.getElementById('service_code').value; //added by Nandhini
	//alert("846==>"+servCode);
	var serviceDescription = parent.frames[0].document.getElementById('service_description').value; //added by Nandhini
	//alert("847==>"+serviceDescription);
	var priceInd = "";

	var priceCode = "";
	var priceDescription = "";
	var policyCode = "";
	var policyDesc = "";
	var custGrpCode = "";
	var custDesc = "";
	var billngClass = "";

	var effFrom = "";
	var effTo = "";
	var discApplicability = "";
	var desc = "";
	var chargeType = "";
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;
	var mode = 'add';
	var param = 'mode='+mode+'&servInd='+servInd+'&servCode='+servCode+'&serviceDescription='+serviceDescription+'&priceInd='+priceInd+'&priceCode='+priceCode+'&policyCode='+policyCode+
	'&custGrpCode='+custGrpCode+'&blngClass='+billngClass;
	var retVal =await top.window.showModalDialog('../../eBL/jsp/BLServiceDiscPriceCreateRecord.jsp?'+param,arguments,features);

	parent.additionalServiceDiscountDetails.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+servInd
	+"&serviceCode="+servCode+"&serviceDescription="+encodeURIComponent(serviceDescription)+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+encodeURIComponent(priceDescription)+"&policyCode="+policyCode
	+"&policyDesc="+encodeURIComponent(policyDesc)+"&custCode="+custGrpCode+"&custDesc="+encodeURIComponent(custDesc)+"&billingClass="+billngClass+"&EffectiveTo="+effTo+"&desc="+desc+"&EffectiveFrom="+effFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType;
}

function loadTraverseFrame(service_ind,service_code,service_description,price_ind,price_code,price_description,billing_class,Effective_from,Effective_to,charge_type,disc_applicability,Desc,fromRcrd,toRcrd,constcnt,prevYn,nextYn){	
	parent.additionalServicePriceDetailsTraverse.location.href = "../../eBL/jsp/AdditionalServicePriceDetailsTraverse.jsp?serviceIndicator="+service_ind+"&serviceCode="+service_code+"&serviceDescription="+encodeURIComponent(service_description)+"&priceInd="+price_ind+"&priceCode="+price_code+"&priceDescription="+encodeURIComponent(price_description)+"&billingClass="+billing_class+"&EffectiveFrom="+Effective_from+"&EffectiveTo="+Effective_to+"&chargeType="+charge_type+"&discApplicability="+disc_applicability+"&Description="+Desc+"&fromRcrd="+fromRcrd+"&toRcrd="+toRcrd+"&next="+nextYn+"&previous="+prevYn+"&constcnt="+constcnt;
}//Added By Rajesh V
