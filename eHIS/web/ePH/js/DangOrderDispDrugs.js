  //saved on 02.11.2005
// lookup for Drug Name

async function searchDrugName(){
	var formObj = parent.document.f_query_criteria.formDangOrderDispDrugs;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]=
	escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.p_drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.p_drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		
		formObj.p_drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;

		}
}

	// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formDangOrderDispDrugs.p_language_id.value;
		
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}
//reset
function reset()
{
		var formObj=f_query_criteria.document.formDangOrderDispDrugs;
		//alert(formObj);
		formObj.drug_name_search.disabled = false;
		f_query_criteria.document.formDangOrderDispDrugs.reset();
}


//From time and to time validation...

function validateDate(){
	var formObj = document.f_query_criteria.formDangOrderDispDrugs;
	if (formObj.p_from_date.value!="" && formObj.p_to_date.value!=""){
		if(!doDateCheck(formObj.p_from_date,formObj.p_to_date,parent.messageFrame)){
			formObj.p_to_date.select();
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}
function initialize_date(obj){
	var mode=obj.value;
	var formObj = document.formDangOrderDispDrugs;
	if(formObj == undefined){
		formObj = f_query_criteria.document.formDangOrderDispDrugs;;  
	}
	var from_date=formObj.p_from_date; 
	var to_date=formObj.p_to_date;
	if(mode == 'M'){
		assigndate(from_date,'M');
		assigndate(to_date,'M');
	}else if(mode == 'Y'){
		assigndate(from_date,'Y');
		assigndate(to_date,'Y');
	}
}
function assigndate(obj,flag){
	var strDate=obj.value;
	var strDateArray=new Array() ; 
	if(strDate != ''){
	strDateArray = strDate.split("/");
		var	strday   = strDateArray[0];
		var strMonth = strDateArray[1];
		var StrYear  = strDateArray[2];
		if(flag == 'Y'){
			obj.value='01/01/'+StrYear;
		}else if(flag == 'M'){
			obj.value='01/'+strMonth+'/'+StrYear; 
		}
	}
}

//orderlocation lookup
async function locationLookup(target){
	var formObj = parent.document.f_query_criteria.formDangOrderDispDrugs;
	var locn_type=formObj.p_order_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.OrderLocation.label","Common"), argumentArray );
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal != null && retVal != "" )  {
				formObj.p_order_locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.OrderLocation.label","Common"), argumentArray );
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal != null && retVal != "" )  {
				formObj.p_order_locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}
	else{
		formObj.p_order_locn_type.focus()
	}
}

function run(){
	
	var frmObject = f_query_criteria.document.formDangOrderDispDrugs;
	var obj=frmObject.p_report_by; 
	if(f_query_criteria.document.formDangOrderDispDrugs) {
		initialize_date(obj);
		var fields= new Array (frmObject.p_order_locn_type,frmObject.p_order_locn_name,frmObject.p_from_date,frmObject.p_to_date);
		var names= new Array ('Order Location Type','Order Location','From Date', 'To Date');
		if(checkFields(fields,names,messageFrame) ) {
			f_query_criteria.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_criteria.document.forms[0].target="messageFrame";
			f_query_criteria.document.formDangOrderDispDrugs.submit();
		}
	}
	
}
function initialize_clase(obj){
	var formObj = document.formDangOrderDispDrugs;
	var order_by=obj.value;
	if(order_by == 'Drug'){
      formObj.CLAUSE.value="ORDER BY E.DRUG_DESC";
	}else{
		formObj.CLAUSE.value="ORDER BY B.SOURCE_CODE"; 
	}
}

function clearOrderLocation() {
  var formObj = document.formDangOrderDispDrugs;
   formObj.p_order_locn_name.value  = "" ;
   
}
