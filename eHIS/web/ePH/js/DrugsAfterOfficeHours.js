  //saved on 02.11.2005
function run() { 
	var frmObject=f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria;
	if(f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria) {
		var fields= new Array (frmObject.location_type,frmObject.disp_location,frmObject.dt_from,frmObject.dt_to);
		var names= new Array (getLabel("Common.locationtype.label","Common"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"));
		
		if(checkFields(fields,names,messageFrame) ) {
/*
			alert('p_facility_id --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.p_facility_id.value);
			alert('p_user_name --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.p_user_name.value);
			alert('p_module_id --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.p_module_id.value);
			alert('p_report_id --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.p_report_id.value);
			alert('working_hr_from --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.working_hr_from.value);
			alert('working_hr_to --'+f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.working_hr_to.value);	
*/          
            f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.formPhDrugAfterOfficeHoursCriteria.submit();	
	     }
	}	
}

// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formPhDrugAfterOfficeHoursCriteria.p_language_id.value;

		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				//obj.select();
				//obj.focus();
                obj.value="";
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}
function reset() {    
	f_query_add_mod.formPhDrugAfterOfficeHoursCriteria.reset();    
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
}

function showtimings(obj)  
{  	
	var disp_loc_code=obj.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest(); 
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "disp_loc_code =\"" + disp_loc_code + "\" " ;
	xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=disp_timings",false ) ; 
		xmlHttp.send( xmlDoc ) ; 
		responseText=xmlHttp.responseText ;
		eval( responseText );
	} 
function getDispLoc(obj)
{   
	var disp_loc_flag= obj.value;
	var formObj = document.formPhDrugAfterOfficeHoursCriteria;
	    document.getElementById("disp_lookup").style="display";
		formObj.drug_name.value=""; 
		formObj.tdrug_name.value="";
		formObj.locn_code1.value="";  
		formObj.locn_code2.value="";
		formObj.dt_from.value=""; 
		formObj.dt_to.value="";
		document.getElementById("working_hrs_txt").innerHTML="";
	    document.getElementById("from_time").innerHTML="";
	    document.getElementById("to_time").innerHTML="";
	if(disp_loc_flag=="C"){
		document.getElementById("disp_txt").innerHTML="Clinic From";
	}else{
		document.getElementById("disp_txt").innerHTML="Nursing Unit From";
	}
   	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "disp_loc_flag =\"" + disp_loc_flag + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=disp_loc",false ) ;  
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
function addtimings(working_hours_from,working_hours_to){       
	document.getElementById("working_hrs_txt").innerHTML="Working Hours From";
	document.getElementById("from_time").innerHTML="<b>"+working_hours_from+"</b>";
	document.getElementById("to_time").innerHTML="<b>"+working_hours_to+"</b>";
	document.formPhDrugAfterOfficeHoursCriteria.working_hr_from.value=working_hours_from;
	document.formPhDrugAfterOfficeHoursCriteria.working_hr_to.value=working_hours_to;
}
function populateDispLoc(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.formPhDrugAfterOfficeHoursCriteria.disp_location.add(element);
}

function clearDispLoc()	{
	var len =document.formPhDrugAfterOfficeHoursCriteria.disp_location.options.length;
	for(var i=0;i<len;i++) {
		document.formPhDrugAfterOfficeHoursCriteria.disp_location.remove("") ;
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	opt.text = "---"+getLabel("Common.defaultSelect.label","Common")+"---";

	document.formPhDrugAfterOfficeHoursCriteria.disp_location.add(opt); 
}
function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH")); 
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}
async function locationLookup(target,inc){
	 
	var formObj = document.formPhDrugAfterOfficeHoursCriteria;
	var locn_type=formObj.location_type.value;
	var argumentArray  = new Array() ; 
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ; 
	var dataTypeArray  = new Array() ; 
	if (locn_type!=""){
		if (locn_type=="N"){

	
			var language_id=document.formPhDrugAfterOfficeHoursCriteria.locale.value;
			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value+"'"+language_id+"'"; 

//			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value+"'"+formObj.language_id.value+"'";

			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ; 

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
                var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				} 
				if(inc == "1"){
				formObj.locn_code1.value=arr[0];
				}else{
				formObj.locn_code2.value=arr[0];
				}
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
				var language_id=document.formPhDrugAfterOfficeHoursCriteria.locale.value;
//			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value+"'"+formObj.language_id.value+"'";
			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value+"'"+language_id+"'"; 
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
                var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				} 
				if(inc == "1"){
				formObj.locn_code1.value=arr[0];
				}else{
				formObj.locn_code2.value=arr[0];
				}
				target.value = arr[1] ;  
			}
		}
	}else{
		formObj.location_type.focus(); 
	}
}
function chkDate(dt_from,dt_to){ 
	
	var ref=parent.frames[2]; 
	if(doDateCheck(dt_from,dt_to,ref)){
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp'; 
	}
	else{
		dt_from.select();
	}
}

