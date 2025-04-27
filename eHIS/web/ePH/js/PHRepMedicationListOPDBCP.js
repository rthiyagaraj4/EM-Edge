function reset(){
	if(f_query_add_mod.document.PHRepMedicationListOPDBCP_Form){
		f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.reset();
		f_query_add_mod.document.getElementById("frmLocnDesc").innerText="";
		f_query_add_mod.document.getElementById("toLocnDesc").innerText="";
	}
}	 

function CheckDateT(obj){
	var locale=document.PHRepMedicationListOPDBCP_Form.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			obj.value="";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function run(){
	var frmObject=f_query_add_mod.document.PHRepMedicationListOPDBCP_Form;
	 if(f_query_add_mod.document.PHRepMedicationListOPDBCP_Form){
		var fields= new Array (frmObject.p_fr_date,frmObject.p_to_date);
		var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));	
		if(checkFields(fields,names,messageFrame) ){
			if(validateProcessDt()){
				//for ML-MMOH-SCF-2131	
				 var days_between  = daysBetween(frmObject.p_fr_date.value,frmObject.p_to_date.value, 'DMY', 'en');
	                if(days_between>=7) //more than a week then proceed
	                   
	            {
	                	alert(getMessage("DATE_RANGE_WEEK","PH"));
	            
	                	frmObject.p_to_date.value="";
	                	frmObject.p_to_date.focus();
	                	frmObject.p_to_date.select();				
				        return false;
				        
				}
	                else{
					frmObject.p_fr_adm_date.value = convertDate(frmObject.p_fr_date.value,'DMY',frmObject.p_language_id.value,'en');
					frmObject.p_to_adm_date.value = convertDate(frmObject.p_to_date.value,'DMY',frmObject.p_language_id.value,'en');
					f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.action="../../eCommon/jsp/report_options.jsp";
					f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.target="messageFrame";
					f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.submit();	
				}
			}
		}
	}
}
	
function validateProcessDt(){
	var frmObject=f_query_add_mod.document.PHRepMedicationListOPDBCP_Form;
	var from =f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.p_fr_date ;
	var to= f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.p_to_date ;
	var sysdt= f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.sys_date;
	var fromarray;
	var toarray;
	var fromdate1 = from.value ;
	var todate1 = sysdt.value ;
	var todt= to.value;
	if(fromdtvalidation(fromdate1,todate1))
	if(fromdate1.length > 0 && todt.length > 0 ){
		fromarray = fromdate1.split("/");
		toarray = todt.split("/");
		var fromdat = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todat = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(fromdat) > Date.parse(todat)){
			var msg=alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
			frmObject.p_to_date.value="";
			frmObject.p_to_date.focus();
			return false;								
		}
		else if(Date.parse(todat) <= Date.parse(fromdat));
		return true;
	}
}
function fromdtvalidation(fromdate1,todate1){
	if(fromdate1.length > 0 && todate1.length > 0 ){   
		fromarray = fromdate1.split("/");
		toarray = todate1.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			if(!doDateCheckAlert(f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.sys_date,f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.p_fr_date)){
				var msg=alert(getMessage("PH_FROM_DATE_GREATER_EQUAL_CURRENT_DATE","PH"));
				f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.p_fr_date.value="";
				f_query_add_mod.document.PHRepMedicationListOPDBCP_Form.p_fr_date.focus();
				return false;								
			}
		}
		else if(Date.parse(todt) <= Date.parse(fromdt));
		return true;
	}		
}	

async function searchCoderepCurrentMedicationList(target, objDescLabel){
	var ordering_facility_id = document.forms[0].p_facility_id.value;
	var p_language_id = document.forms[0].p_language_id.value;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;
	argumentArray[0] = document.getElementById("SQL_PH_REPORTS_BCP_LOCATION_LOOKUP").value+"'"+p_language_id+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3,4";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	target.value = ""
	objDescLabel.innerText = "";
	retArray = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray==null || retArray=="")
				target.value="";
			else
               {
				target.value=arr[0];
                objDescLabel.innerText = arr[1];
			}
} 

/***********Date chk week function*/
function dateCheckforWeek(from_date,to_date){
	var fromdate =convertDate(from_date.value,'DMY',localeName); 
	var todate= convertDate(to_date.value,'DMY',localeName); 
	var fromarray;
    var toarray;
	if(fromdate.length >0){
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var frommonth=parseInt(fromarray[1])-1;
		var tomonth=parseInt(toarray[1])-1;
		today=new Date(fromarray[2],frommonth,fromarray[0]);
		var christmas=new Date(toarray[2], tomonth, toarray[0]); //Month is 0-11 in JavaScript
		var one_day=1000*60*60*24
		date_diff=(Math.ceil((christmas.getTime()-today.getTime())/(one_day)));
		if((date_diff>6)) {
			var msg=alert(getMessage("DATE_RANGE_WEEK","PH"));
			to_date.value="";
			to_date.focus();
			to_date.select();				
			return false;
	    }
	}
	return true;
}
