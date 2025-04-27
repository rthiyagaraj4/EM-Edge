
function reset() 
{
	if(f_query_add_mod.document.repTopDiagnosisForm)
	{
		//f_query_add_mod.document.repTopDiagnosisForm.reset() ;
		f_query_add_mod.location.href = '../../eMR/jsp/repTopDiagnosisForm.jsp' ;
	}
}


function run()
{
	 var flag =checkNull();
	 if(flag==true){
	var fields = new Array (f_query_add_mod.document.repTopDiagnosisForm.p_from_date,f_query_add_mod.document.repTopDiagnosisForm.p_to_date);
	var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	
		if(chkGrtrDate(f_query_add_mod.document.repTopDiagnosisForm.p_from_date,f_query_add_mod.document.repTopDiagnosisForm.p_to_date))
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.repTopDiagnosisForm.submit() ;
		}
}
}

function checkzero(obj){
	var count =obj.value;
	if(count =='0' || count =='00'|| count =='000' || count =='0000'||count =='00000'){
		alert(getMessage("COUNT_CANNOT_LESS_TNAN_1","MR"));
		document.getElementById('p_count').value="";
		document.getElementById('p_count').focus();
	}
}
function removeSpec()
	     {  
                var data = document.getElementById("p_count").value;
                for (var i = 0; i < data.length; i++)
                {  
				 if (!(((data.charCodeAt(i)>=48) && (data.charCodeAt(i)<=57))))
                    {    
					data=data.replace(/[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!`@#$%^&*()+=\-\[\]';,.\/{}|\s":<>\\?~_]/g,'');
                    document.getElementById("p_count").value =data;                    
					return false; 
                    } 
                }
				return true;
         }

function checkNull(){
 	var flag;
  	var error="";
  	var obj=f_query_add_mod.document.repTopDiagnosisForm;
  	var from_date =obj.p_from_date.value;
	var to_date =obj.p_to_date.value;
	var patient_class =obj.p_patient_class.value;
	var diag_set =obj.p_diag_set.value;
	var count =obj.p_count.value;
    var from_date_label=(getLabel("Common.from.label","Common")+' '+getLabel("Common.DiagnosisDate.label","Common"));
    var to_date_label=(getLabel("Common.to.label","Common")+' '+getLabel("Common.DiagnosisDate.label","Common")); 
    var patient_class_label=getLabel("Common.patientclass.label","Common");
    var diag_set_label=(getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
    var count_label=getLabel("Common.count.label","Common");
  	if(from_date=="") {
  		flag=false;
  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",from_date_label)+"<br>";
  	}
  	 
   	if(to_date=="") {
   		flag=false;
   		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",to_date_label)+"<br>";
   	}
  	if(patient_class=="") {
  		flag=false;
  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",patient_class_label)+"<br>";
  		
  	}
  	
  if(diag_set=="") {
		flag=false;
		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",diag_set_label)+"<br>";
		
	}
  if(count=="") {
		flag=false;
		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",count_label)+"<br>";
		
	}
  	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
 	if(flag==false) return false; else return true;
  }

function allowNumeric(event){
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}
function chkGrtrDate(obj1,obj2)
{
	if( obj1.value != "" && obj2.value != "" )
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName) == false)
		{
			var msg = getMessage("TO_DT_GR_EQ_FM_DT","SM");
			alert(msg);
			obj2.select();
			return false;
		}
		else
			return true;
	}
	else 
		return true;
}


//<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Started -->
function changeFacility(obj)
{
	 
	var p_user_name = document.forms[0].p_user_name.value;
	var locale = document.forms[0].locale.value;
	var p_resp_id = document.forms[0].P_RESP_ID.value;
	var p_gov_code = obj.value;
	deleteValues(document.forms[0].p_facility_id);

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	
	xmlStr = "<root><SEARCH p_user_name=\""+p_user_name+"\" locale=\""+locale+"\" p_resp_id=\""+p_resp_id+"\" p_gov_code=\""+p_gov_code+"\" action='getFacilityValue' /></root>"
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var FacilityValue = trimString(responseText);
	
	
	var arr = new Array();
	arr = FacilityValue.split("##");
	
	if(FacilityValue != '')
	{
		for(i=0; i<arr.length; i++) 
		{
			var FacilityArr = new Array();
			FacilityArr = trimString(arr[i]).split("~~");
			var facility_id = FacilityArr[0];
			var facility_name = FacilityArr[1];
			var opt = document.createElement('OPTION');
			opt.text = facility_name;
			opt.value = facility_id;
			document.forms[0].p_facility_id.add(opt);
		}
	}
}

function deleteValues(obj)
{
	while(obj.options.length>1) obj.options.remove(1);
}
//<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 End -->
