 //saved on 30/12/2009

function run() {
	
	 	var frmObject = f_query_add_mod.document.formSRRPhRepReissueCriteria;		
		if(frmObject.p_locn_name.value == "")
			frmObject.p_locn_code.value = "";
		if(frmObject.p_reason_desc.value == "")
			frmObject.p_reason_code.value = "";
		if(frmObject.p_drug_name.value == "")
			frmObject.p_drug_code.value = "";
		var fields= new Array (frmObject.p_dt_from_text,frmObject.p_dt_to_text);
		var names= new Array ('Date From','Date To');
		if(checkFields(fields,names,messageFrame)){
			if(frmObject.p_dt_from_text.value!= null && frmObject.p_dt_from_text.value!="")
				frmObject.p_dt_from.value = convertDate(frmObject.p_dt_from_text.value,'DMY',frmObject.p_language_id.value,'en');
			if(frmObject.p_dt_to_text.value!= null && frmObject.p_dt_to_text.value!="")
				frmObject.p_dt_to.value = convertDate(frmObject.p_dt_to_text.value,'DMY',frmObject.p_language_id.value,'en');
			f_query_add_mod.document.formSRRPhRepReissueCriteria.submit();	
	     } 
	
}

function reset() {
    f_query_add_mod.formSRRPhRepReissueCriteria.reset();
	
		var formObj = f_query_add_mod.formSRRPhRepReissueCriteria;
		formObj.drug_item_label.innerText=getLabel("Common.DrugName.label","Common");
		var opt;
		var desc ;
		var order_by_len =formObj.p_order_by.options.length;
		
		for(var i=0;i<order_by_len;i++) 
			{
				formObj.p_order_by.remove("p_order_by") ;
			}
		opt = formObj.document.createElement("OPTION") ;
		desc = getLabel("ePH.ReissueDispensingLocation.label","PH");
		opt.text = desc ;
		opt.value = "R" ;
		formObj.p_order_by.add(opt);
		opt = formObj.document.createElement("OPTION") ;
		desc = getLabel("Common.OrderingLocation.label","PH");
		opt.text = desc ;
		opt.value = "L" ;
		formObj.p_order_by.add(opt);
		formObj.p_order_by.value="R";
		formObj.p_order_by.disabled = false;
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
function callPatientSearch(target){

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}

function chkDate(dt_from,dt_to){ 
	
	var ref=parent.frames[2]; 
	if(doDateCheck(dt_from,dt_to,ref)){
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp'; 
	}else{
		parent.f_query_add_mod.formSRRPhRepReissueCriteria.p_dt_from_text.focus(); 
		parent.f_query_add_mod.formSRRPhRepReissueCriteria.p_dt_from_text.select(); 
		
	}
}

function ReasonLookup(target){
	var formObj = document.frames.formSRRPhRepReissueCriteria;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	
			argumentArray[0]   = escape(document.getElementById("SQL_PH_REISSUE_MEDICATION_SELECT4").value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.reason.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_reason_code.value=retVal[0];
				target.value = retVal[1] ;
			}
			else
			{
				formObj.p_reason_code.value="";
				target.value = "" ;
			}
		
	
}

function locationLookup(target){
	var formObj = document.frames.formSRRPhRepReissueCriteria;
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
			else
			{
				formObj.p_locn_code.value="";
				target.value = "" ;
			}
		}
	}
	else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
		formObj.p_locn_type.focus()
	}
}

function clear1(obj)
{
	
if(document.formSRRPhRepReissueCriteria.p_locn_type.value==""){
	document.formSRRPhRepReissueCriteria.p_locn_name.disabled=false;
	document.formSRRPhRepReissueCriteria.p_locn_name.value='';	
	document.formSRRPhRepReissueCriteria.p_locn_code.value='';	
			}
else
	{
		document.formSRRPhRepReissueCriteria.p_locn_name.value='';
		document.formSRRPhRepReissueCriteria.p_locn_code.value='';	
	}
}

function DisableOrderBy(report_type_obj)
{
	var formObj = document.formSRRPhRepReissueCriteria;
	var opt;
	var desc ;
	if(report_type_obj.value=="S")
	{
		var order_by_len =document.formSRRPhRepReissueCriteria.p_order_by.options.length;
		for(var i=0;i<order_by_len;i++) 
			{
				formSRRPhRepReissueCriteria.p_order_by.remove("p_order_by") ;
			}
		opt = document.createElement("OPTION") ;
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
		opt.text = desc ;
		opt.value = "" ;
		document.formSRRPhRepReissueCriteria.p_order_by.add(opt);
		formObj.p_order_by.value="";
		formObj.p_order_by.disabled = true;
	}
	else
	{
		var order_by_len =document.formSRRPhRepReissueCriteria.p_order_by.options.length;
		
		for(var i=0;i<order_by_len;i++) 
			{
				formSRRPhRepReissueCriteria.p_order_by.remove("p_order_by") ;
			}
		opt = document.createElement("OPTION") ;
		desc = getLabel("ePH.ReissueDispensingLocation.label","PH");
		opt.text = desc ;
		opt.value = "R" ;
		document.formSRRPhRepReissueCriteria.p_order_by.add(opt);
		opt = document.createElement("OPTION") ;
		desc = getLabel("Common.OrderingLocation.label","PH");
		opt.text = desc ;
		opt.value = "L" ;
		document.formSRRPhRepReissueCriteria.p_order_by.add(opt);
		formObj.p_order_by.value="R";
		formObj.p_order_by.disabled = false;
	}
}



function ChangeLegend(drug_med_supply_obj)
{
	var formObj = document.formSRRPhRepReissueCriteria;
	if(drug_med_supply_obj.value=="N")
	{
		formObj.drug_item_label.innerText=getLabel("Common.ItemName.label","Common");
	}
	else
	{
		formObj.drug_item_label.innerText=getLabel("Common.DrugName.label","Common");
	}
}

function Drug_ItemLookup(target)
{
	var formObj = document.frames.formSRRPhRepReissueCriteria;
	var drug_med_supply=formObj.p_drug_med_supply.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var label ="";
	if (drug_med_supply=="Y"){
			argumentArray[0]   = escape(document.getElementById("drug_search_query").value)+"'"+formObj.p_language_id.value+"'";
			label = getLabel("Common.Drug.label","Common")
		}else if (drug_med_supply=="N"){
			argumentArray[0]   =  escape(document.getElementById("item_search_query").value)+"'"+formObj.p_language_id.value+"'";
				label = getLabel("ePH.MEDICALSUPPLY.label","PH")
		}else if(drug_med_supply==""){
			argumentArray[0]   =  escape(document.getElementById("drug_item_search_query").value)+"'"+formObj.p_language_id.value+"'";
			label = getLabel("ePH.DRUG/MEDICALSUPPLY.label","PH");
		}
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( label, argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_drug_code.value=retVal[0];
				target.value = retVal[1] ;
			}
			else
			{
				formObj.p_drug_code.value="";
				target.value = "" ;
			}
}
