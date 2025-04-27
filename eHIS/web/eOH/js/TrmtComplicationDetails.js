async function recordComplicationUsed(obj){
	var formObj = document.forms[0];
	var site_type = formObj.oh_site.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var trmt_cat_type = formObj.oh_category.value;
	var patient_id    = formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code= formObj.task_code.value;
    //var	task_desc= formObj.task_desc.value;
	var	task_desc= encodeURIComponent(formObj.task_desc.value);//Added encodeURIComponent by Sridevi Joshi on 8/16/2010 for IN023245
    var	task_seq= formObj.task_seq_no.value;
    var	treatment_status_param= formObj.treatment_status_param.value;
	var tooth_range_count_for_order = 0;
	var display_tooth_no= formObj.display_tooth_no.value;
	var ind_chart_line_num= formObj.ind_chart_line_num.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var baseline_chart_yn = formObj.baseline_chart_yn.value;
	var super_key_num = formObj.super_key_num.value;
	var tooth_no=formObj.oh_area.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;//Added by Sridevi Joshi on 2/24/2010 for IN010894
	var date_diff_flag = formObj.date_diff_flag.value;//Added by Sridevi Joshi on 5/27/2010 for IN021668

																					    
	if(site_type == "THRNG" && thrng_nos_ref != ""){
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		tooth_range_count_for_order = formObj.oh_area.options.length 
	}
	if(site_type == "QUAD" || site_type == "ARCH" || site_type == "MAXFS"){//Condition for MAXFS is added for IN021414 by Sridevi Joshi on 5/17/2010
		 display_tooth_no = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
	}
	else{
		if (site_type=="TOOTH" || site_type=="ROOT" || site_type=="CROWN")
		{
			 display_tooth_no = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
		}else{
			 display_tooth_no=formObj.oh_area.value;
		}
	}
	var params = "trmt_cat_type="+trmt_cat_type+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code+"&treatment_status_param="+treatment_status_param+"&task_desc="+unescape(task_desc)+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&task_seq="+task_seq+"&baseline_chart_yn="+baseline_chart_yn+"&super_key_num="+super_key_num+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system+"&super_tooth_ref="+super_tooth_ref+"&date_diff_flag="+date_diff_flag;

	var url	= "../../eOH/jsp/TrmtComplicationFrames.jsp?"+params;
	var dialogHeight= "70vh" ;
	var dialogWidth	= "70vw" ;
	var dialogTop ="";
	var dialogLeft ="";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	var retVal = await top.window.showModalDialog(url,arguments,features);
	
}

 function assingListItemValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = window.parent.hidden_frame.hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[1]=="Y")
			eval("formObj.chk_select"+key).checked=true;
		else
			eval("formObj.chk_select"+key).checked=false;
	}
}

function validateCheckBox(obj){
	var frmObj = window.parent.hidden_frame;
	var formObj = document.forms[0];
	var record= new Array();
    var complication_code=obj.complication_code;
	var complication_remarks=obj.complication_remarks;
	var complication_seq_no=obj.complication_seq_no;

    var hash = new Hashtable();
	hash = frmObj.hash;
    var indx = obj.name.replace("chk_select" , "");
	
	if(obj.checked==true ){
		record[0]=complication_code;
		record[1]="Y";		
		record[2]=complication_remarks;	
		record[3]=complication_seq_no;	
	}else{
		record[0]=complication_code;
		record[1]="N";
		record[2]=complication_remarks;	
		record[3]=complication_seq_no;	
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);	
	}else{
		hash.put(indx,record);	
	}
}

function clear_list(obj){
  while(obj.options.length > 0){
   obj.remove(obj.options[0]);
 }
}  

function populateComplication(obj){
	if(obj.value=='$OTH')
	{
	document.getElementById("DeatailsText").style.display='Inline';
	document.getElementById("DetailsLabel").style.display='Inline';
	}else{
	document.getElementById("DeatailsText").style.display='none';
	document.getElementById("DetailsLabel").style.display='none';
	document.forms[0].complication_remarks.value='';
	}	
}

function clearvalues()
{  
document.forms[0].reset();
	if(document.getElementById("DeatailsText").style.display!='none')
	{
	document.getElementById("DeatailsText").style.display='none';
	document.getElementById("DetailsLabel").style.display='none';
	}
}

function checkField( fields, names) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
	 if(fields[i].value) {
	   fields[i].value = trimString(fields[i].value);
	 }
	 else { 
	   errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n"
	 }
	}
	if ( errors.length != 0 )
	{
	 return false ;
	}
	return true;
}



function recordComplication()
{
	formObj=document.forms[0];
	var patient_id     = formObj.patient_id.value;
	var chart_num      = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var	trmt_code      = formObj.trmt_code.value;
	var task_code      = formObj.task_code.value;
	var	dtl_params     = formObj.params.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var complication_code  =formObj.complication_code.value;
	var display_tooth_no   = parent.TrmtComplicationHeaderTitle.document.forms[0].display_tooth_no.value;
	var ind_chart_line_num = parent.TrmtComplicationHeader.document.forms[0].ind_chart_line_num.value;

	var frmObj = window.parent.hidden_frame;
	
   

  
	var complication_title     = getLabel("eOH.Complication.Label","OH");
	var details_title           = getLabel("eOH.Details.Label","OH");
	if(formObj.complication_code.value=="$OTH"){
	var fields                 = new Array (formObj.complication_remarks);
    var names                  = new Array (details_title);
	}else{
	var fields                 = new Array (formObj.complication_code);
    var names                  = new Array (complication_title);
	}
	var complication_desc=formObj.complication_code.options[formObj.complication_code.options.selectedIndex].text;
	
	var complication_code_db=new Array();
	var complication_desc_db=new Array();
	var complication="";
	var duplicate_yn='N';
	var hdr_title_params=parent.TrmtComplicationHeaderTitle.document.forms[0].params.value;
    var hdr_params= parent.TrmtComplicationHeader.document.forms[0].params.value;
	var trmt_cat_type=formObj.trmt_cat_type.value;
	var task_desc = formObj.task_desc.value;
	
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var seq_no = formObj.seq_no.value;

	var messageFrame = parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame)){	
		if(complication_code!='$OTH')
		{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params1="complication_code="+complication_code+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&ind_chart_line_num="+ind_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&task_code="+task_code+"&seq_no="+seq_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getComplicationCode&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

			if(retVal.length >  1){
				complication= retVal.split("~");
			
				for(j=0;j<complication.length;j++){
					complication1=complication[j].split("$$");
					complication_code_db[j]=complication1[0];
					complication_desc_db[j]=complication1[1];
					if(complication_code == complication_code_db[j]){
						var msg = getMessage("APP-OH000160","OH");
						var msgArray = msg.split("##");
						alert(msgArray[0]+"'"+complication_desc_db[j]+"'"+msgArray[1]);
						duplicate_yn='Y';
						break;
					}
					else{
						duplicate_yn='N';
					}
				}
			}
	    var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&complication_code="+complication_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
		}
		
		if(duplicate_yn == 'N'){
			document.forms[0].submit();
			var msg = getMessage("RECORD_INSERTED","SM");
			alert(msg);
			var hash = new Hashtable();
			hash = frmObj.hash;
			hash.clear();

			var formObj = document.forms[0];
			var patient_id      = formObj.patient_id.value;
			var chart_num       = formObj.chart_num.value;
			var chart_line_num  = formObj.chart_line_num.value;
			var	trmt_code       = formObj.trmt_code.value;
			var	task_code_req   = task_code;

			var	from            = formObj.from.value;
			var	to              = formObj.to.value;
			var	totalSelected   = formObj.totalSelected.value;
			var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
			var	display_tooth_no= formObj.display_tooth_no.value;
			var	ind_chart_line_num= formObj.ind_chart_line_num.value;
			var	status_disabled = formObj.status_disabled.value;
			var	oh_chart_level  = formObj.oh_chart_level.value;
			var	other_chart_facility_id= formObj.other_chart_facility_id.value;
			var	seq_no          = formObj.seq_no.value;
			var	maxRecord       = formObj.maxRecord.value;
			var	trmt_cat_type   = formObj.trmt_cat_type.value;
			var	task_desc       = formObj.task_desc.value;

			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+from+"&to="+to+"&totalSelected="+totalSelected+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&trmt_cat_type="+trmt_cat_type+"&task_desc="+task_desc;

			var messageFrame = parent.parent.parent.parent.parent.messageFrame
			messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			parent.TrmtComplicationHeader.location.href="../../eOH/jsp/TrmtComplicationHeader.jsp?"+params;
			parent.TrmtComplicationDetails.location.href="../../eOH/jsp/TrmtComplicationDetails.jsp?"+params;
			
		}
	}
}
function refresh()
{
	formObj=document.forms[0];
	var	dtl_params= formObj.params.value;
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var	dtl_params= formObj.params.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var composition_class=formObj.composition_class.value;
	var composition_code=formObj.composition_code.value;
	var display_tooth_no= parent.TrmtComplicationHeaderTitle.document.forms[0].display_tooth_no.value;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 

	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+composition_class+"&composition_code="+composition_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class="+composition_class+"&display_tooth_no="+display_tooth_no+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	parent.TrmtComplicationHeaderTitle.location.href = '../../eOH/jsp/TrmtComplicationHeaderTitle.jsp?'+params;	
	parent.TrmtComplicationHeader.location.href="../../eOH/jsp/TrmtComplicationHeader.jsp?"+params;
	document.location.href="../../eOH/jsp/TrmtComplicationDetails.jsp?"+dtl_params;

}

function deleteCompRecorded(){
	 formObj=document.forms[0];
	 var patient_id= formObj.patient_id.value;
	 var chart_num = formObj.chart_num.value;
	 var trmt_code =formObj.trmt_code.value;
	 var task_code_req=formObj.task_code_req.value;
	 var chart_line_num = formObj.chart_line_num.value;
	 var ind_chart_line_num = formObj.ind_chart_line_num.value;
	 var tooth_range_count_for_order = formObj.tooth_range_count_for_order.value;
     var dtl_params = parent.TrmtComplicationDetails.document.forms[0].params.value;
	 var hdr_params= formObj.params.value;
	 var hdr_title_params=parent.TrmtComplicationHeaderTitle.document.forms[0].params.value;
	 var display_tooth_no= parent.TrmtComplicationHeaderTitle.document.forms[0].display_tooth_no.value;
	 var task_desc = formObj.task_desc.value;

	 var complication_code="";
	 var complication_seq_no="";
	

	 var other_chart_facility_id = formObj.other_chart_facility_id.value;
	 var oh_chart_level = formObj.oh_chart_level.value; 
	 var seq_no = formObj.seq_no.value; 

	 var hash = new Hashtable(); 
	 hash = parent.hidden_frame.hash;
	 var keys_arr = hash.keys();
	 if(keys_arr.length > 0)
	 {
	 for(k=0;k<keys_arr.length;k++){
	  if(hash.get(keys_arr[k])!=null){
		if(hash.get(keys_arr[k])[1]=="Y"){
			complication_code=hash.get(keys_arr[k])[0];
			complication_seq_no=hash.get(keys_arr[k])[3];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var delete_params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&complication_code="+complication_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&task_code_req="+task_code_req+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&complication_seq_no="+complication_seq_no+"&seq_no="+seq_no;   
          
		   
			
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=deleteComplicationRecorded&"+delete_params,false);
			xmlHttp.send(xmlDoc);
		 }
	    }
	  }
	
	var params = delete_params+"&task_code="+task_code_req;
	hash.clear();
	
	var messageFrame = parent.parent.parent.parent.parent.messageFrame
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	
	
   
	document.location.href = "../../eOH/jsp/TrmtComplicationHeader.jsp?"+params+"&ind_chart_line_num="+ind_chart_line_num+"&task_desc="+task_desc+"&seq_no="+seq_no;
	
	 
	parent.TrmtComplicationDetails.location.href = '../../eOH/jsp/TrmtComplicationDetails.jsp?'+dtl_params;	
	
   }
      else
	{
	   //alert("Select atleast one Composition");
		alert(getMessage("APP-OH000159","OH"))
	}
}
function showRecords(count){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num= formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code_req= formObj.task_code_req.value;
    var	task_desc= formObj.task_desc.value;

    var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
    //var	display_tooth_no= formObj.display_tooth_no.value;
    var	ind_chart_line_num= formObj.ind_chart_line_num.value;
    var	status_disabled= formObj.status_disabled.value;
    var	oh_chart_level= formObj.oh_chart_level.value;
    var	other_chart_facility_id= formObj.other_chart_facility_id.value;
    var	seq_no= formObj.seq_no.value;
    var	maxRecord= formObj.maxRecord.value;
   
    //var	i= formObj.i.value;

	var start = count;
	var end = count+9;

	var hash = new Hashtable(); 
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();

	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+start+"&to="+end+"&totalSelected="+keys+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&task_desc="+task_desc;

	parent.TrmtComplicationHeader.location.href='../../eOH/jsp/TrmtComplicationHeader.jsp?'+params;
}

function showRecords1(count)
{
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code = formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var chart_line_num=formObj.chart_line_num.value;
	var maxRecord=formObj.maxRecord.value;
	var task_code=formObj.task_code.value;
	var trmt_cat_type=formObj.trmt_cat_type.value;

	var display_tooth_no= parent.TrmtComplicationHeaderTitle.document.forms[0].display_tooth_no.value;
	var ind_chart_line_num= parent.TrmtComplicationHeader.document.forms[0].ind_chart_line_num.value;
    var start = count;
	var end = count+9;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 
	var	status_disabled = formObj.status_disabled.value; 
    //var	i= formObj.i.value;

    
	var hash = new Hashtable(); 
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();

	parent.TrmtComplicationDetails.location.href='../../eOH/jsp/TrmtComplicationDetails.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&chart_line_num="+chart_line_num+"&maxRecord="+maxRecord+"&task_code="+task_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
}


function setCheckValue(){
	formObj=document.forms[0];
	var patient_id= formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code =formObj.trmt_code.value;
	var task_code_req=formObj.task_code_req.value;
    var chart_line_num = formObj.chart_line_num.value;
    var count = formObj.count.value;
    var tooth_range_count_for_order = document.forms[0].tooth_range_count_for_order.value;
	for(var i=0;i<=count;i++){
		if(eval("formObj.completed"+i) != "null" && eval("formObj.completed"+i) != "undefined" && eval("formObj.completed"+i) != undefined){
			if(eval("formObj.completed"+i).checked==true){
				eval("formObj.completed"+i).value="Y";
			}
			else{
				eval("formObj.completed"+i).value="N";
			}
		}
	}
}


function updateTaskCmplicationCmplyn(obj,task_code_req,task_desc,seq_no,count)
{  
	formObj=document.forms[0];
	var count_records = 0;
	var patient_id= formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code =formObj.trmt_code.value;
	var chart_line_num = formObj.chart_line_num.value;
	var tooth_range_count_for_order = document.forms[0].tooth_range_count_for_order.value;
	var task_cmplication_cmpl_yn=obj.value;
	var i=document.forms[0].i.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 
        var frmObj = window.parent.hidden_frame;
	var hash = new Hashtable();
	hash = frmObj.hash;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code_req+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=populateComplicationDetails&"+params1,false);
	xmlHttp.send(xmlDoc);
	var i = trimString(xmlHttp.responseText);
    
	var j=i-1;
	if(j<1){
		var flag=confirm(getMessage("APP-OH000161","OH"))
		if(flag){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&task_code_req="+task_code_req+"&task_cmplication_cmpl_yn="+task_cmplication_cmpl_yn+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateTaskCmplicationCmplyn&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

           
			if(retVal==1){
				if(parent.TrmtComplicationHeader.document.forms[0] != null && parent.TrmtComplicationHeader.document.forms[0] != "null"){
					if(parent.TrmtComplicationHeader.document.forms[0].task_code_req.value == task_code_req && parent.TrmtComplicationHeader.document.forms[0].seq_no.value == seq_no){
						count_records = parent.TrmtComplicationHeader.document.forms[0].i.value;
                        if(parent.TrmtComplicationDetails.document.forms[0].complication_code.value=='$OTH')
						{
						parent.TrmtComplicationDetails.document.getElementById("DeatailsText").style.display='none';
						parent.TrmtComplicationDetails.document.getElementById("DetailsLabel").style.display='none';
						parent.TrmtComplicationDetails.document.forms[0].complication_remarks.value='';
						}

						parent.TrmtComplicationDetails.document.forms[0].complication_code.value="";
						parent.TrmtComplicationDetails.document.forms[0].record.disabled=true;
						parent.TrmtComplicationDetails.document.forms[0].clear.disabled=true;
						parent.TrmtComplicationDetails.document.forms[0].complication_code.disabled=true;
						parent.TrmtComplicationHeader.document.forms[0].delete1.disabled=true;
						parent.TrmtComplicationHeader.document.forms[0].status_disabled.value="disabled";
						
						for(var m=1;m<=count_records-1;m++){
						if(typeof eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m)!='undefined')
						{
							eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m).disabled=true;
							eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m).checked=false;
						}
						}
						hash.clear();
					}
				}
				eval("formObj.completed"+count).checked=true;
				eval("formObj.completed"+count).disabled=true;
				eval("formObj.completed"+count).value="Y";
                                
			}
		}
		else{
			eval("formObj.completed"+count).checked=false;
			eval("formObj.completed"+count).value="N";
			return;
		}
	}
	else{
		//var data_entry_completed = confirm("Treatments Data Entry will be completed.Do you want to proceed?")
		var data_entry_completed = confirm(getMessage("APP-OH000124","OH"));
		if(data_entry_completed){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&task_code_req="+task_code_req+"&task_cmplication_cmpl_yn="+task_cmplication_cmpl_yn+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;
			//
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateTaskCmplicationCmplyn&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

			if(retVal==1){
				if(parent.TrmtComplicationHeader.document.forms[0] != null && parent.TrmtComplicationHeader.document.forms[0] != "null"){
					if(parent.TrmtComplicationHeader.document.forms[0].task_code_req.value == task_code_req && parent.TrmtComplicationHeader.document.forms[0].seq_no.value == seq_no){
						count_records = parent.TrmtComplicationHeader.document.forms[0].i.value;
						if(parent.TrmtComplicationDetails.document.forms[0].complication_code.value=='$OTH')
						{
						parent.TrmtComplicationDetails.document.getElementById("DeatailsText").style.display='none';
						parent.TrmtComplicationDetails.document.getElementById("DetailsLabel").style.display='none';
						parent.TrmtComplicationDetails.document.forms[0].complication_remarks.value='';
						}
						
						parent.TrmtComplicationDetails.document.forms[0].record.disabled=true;
						parent.TrmtComplicationDetails.document.forms[0].clear.disabled=true;
						
						parent.TrmtComplicationDetails.document.forms[0].complication_code.value="";
						parent.TrmtComplicationDetails.document.forms[0].record.disabled=true;
						parent.TrmtComplicationDetails.document.forms[0].clear.disabled=true;
						parent.TrmtComplicationDetails.document.forms[0].complication_code.disabled=true;
						parent.TrmtComplicationHeader.document.forms[0].delete1.disabled=true;
						parent.TrmtComplicationHeader.document.forms[0].status_disabled.value="disabled";
						for(var m=1;m<=count_records-1;m++){
							if(typeof eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m)!='undefined')
							{
							eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m).disabled=true;
							eval("parent.TrmtComplicationHeader.document.forms[0].chk_select"+m).checked=false;
							}
						}
						hash.clear();
					}
				}
				eval("formObj.completed"+count).checked=true;
				eval("formObj.completed"+count).disabled=true;
				eval("formObj.completed"+count).value="Y";
                                
			}
		}
		else{
			eval("formObj.completed"+count).checked=false;
			eval("formObj.completed"+count).value="N";
			return;
		}
	}
}

/* Loading TrmtComplicationHeader(middle),TrmtComplicationDetails(Details part) frames when pressing Task in TrmtComplicationHeader(HeaderPart) frame*/

function populateComplicationDetails(task_code,task_desc,status_disabled,seq_no,count){
	var formObj = document.forms[0];
	var max=formObj.count.value;
	var task_code_r=formObj.task_code_req.value;
	//Added on 9/17/2010 for IN023245 by AnithaJ
	var task_desc=formObj.DB_task_desc_first.value;

    if(task_code_r!="")
	{ 	var j=0;  
		//eval("document.getElementById('tasklink"+j+"')").style.backgroundColor='#00FF00';
		//eval("document.getElementById('tasklink"+j+"')").style.font-weight='bold';
		document.getElementById('tasklink' + i).style.fontWeight = '700';

	}
	else
	{
	for(i=0;i<max;i++)
	{
	if(count==i)
	{
	//eval("document.getElementById('tasklink"+i+"')").style.backgroundColor='#DCDCDC';
	 document.getElementById('tasklink' + i).style.fontWeight = '700';
	//eval("document.getElementById('tasklink"+i+"')").style.backgroundColor='#00FF00';
	}
	else
	{
	//eval("document.getElementById('tasklink"+i+"')").style.backgroundColor='white';
	 document.getElementById('tasklink' + i).style.fontWeight = 'normal';
	}
	}
	}
   
	//eval("document.getElementById('tasklink_"+count+"')").style.backgroundColor='pink';

    //document.getElementById("tasklink").style.backgroundColor='pink';
    //obj.style.backgroundColor='pink';
	var patient_id = formObj.patient_id.value;
	var chart_num= formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code_req= task_code;

    var	from= formObj.from.value;
    var	to= formObj.to.value;
    var	totalSelected= formObj.totalSelected.value;
    var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
    var	display_tooth_no= formObj.display_tooth_no.value;
    var	ind_chart_line_num= formObj.ind_chart_line_num.value;
    //var	status_disabled= formObj.status_disabled.value;
    var	oh_chart_level= formObj.oh_chart_level.value;
    var	other_chart_facility_id= formObj.other_chart_facility_id.value;
    //var	seq_no= formObj.seq_no.value;
    var	maxRecord= formObj.maxRecord.value;

	var frmObj = window.parent.hidden_frame;
	var hash = new Hashtable();
	hash = frmObj.hash;
	hash.clear();

    var	trmt_cat_type= formObj.trmt_cat_type.value;
    var	baseline_chart_yn= formObj.baseline_chart_yn.value;
    var	date_diff_flag= formObj.date_diff_flag.value;

	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+from+"&to="+to+"&totalSelected="+totalSelected+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&trmt_cat_type="+trmt_cat_type+"&task_desc="+task_desc+"&seq_no="+seq_no+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag="+date_diff_flag;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	parent.TrmtComplicationHeader.location.href="../../eOH/jsp/TrmtComplicationHeader.jsp?"+params;
	parent.TrmtComplicationDetails.location.href="../../eOH/jsp/TrmtComplicationDetails.jsp?"+params;
}
 function closewindow()
 {
	 window.close();
 }

 function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function checkForSpecCharsforCompRemarks(event){   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key
	if (whichCode == 13) return false;
	return true ;
}

function CheckForOHSpecChars(event){
	if((event.keyCode==61) || (event.keyCode==43) || (event.keyCode==163) || (event.keyCode==96) || (event.keyCode==126) || (event.keyCode==64) || (event.keyCode==35) || (event.keyCode==36) || (event.keyCode==37) || (event.keyCode==38) || (event.keyCode==42) || (event.keyCode==40) || (event.keyCode==41) || (event.keyCode==45) || (event.keyCode==95) || (event.keyCode==91) || (event.keyCode==93) || (event.keyCode==123) || (event.keyCode==125) || (event.keyCode==92) || (event.keyCode==124) || (event.keyCode==59) || (event.keyCode==58) || (event.keyCode==39) || (event.keyCode==34) || (event.keyCode==44) || (event.keyCode==46) || (event.keyCode==47) || (event.keyCode==60) || (event.keyCode==62) || (event.keyCode==63) || (event.keyCode==62) || (event.keyCode==60) ||(event.keyCode==36)||(event.keyCode==94) ||(event.keyCode==126)||(event.keyCode==37)||(event.keyCode==33)||(event.keyCode==38)){
	return false; 
		}
	}

function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10) ||(str.charCodeAt(u)>200));
			/*
			Special Characters keycodes are below 200 only. for other language like thai charcters should work properly for that purpose  (str.charCodeAt(u)>200) condition given. added by sathsh against CRF-0479
			*/
            else{
                specCharsExist = true;
                break;
            }
        }
        return specCharsExist;
    }
	function CheckChars1(obj)
	{ 
	   var specCharsExist=CheckChars2(obj);
	   if(specCharsExist==true) 
		{
		 alert(getMessage("APP-OH000162","OH"));	
		  obj.focus();
	      return;
		}else
		{
		checkLimit(obj,100);
		}
	}
function checkLimit(field, limit){
  if (field.value.length > limit){
		//  var msg = getMessage("MAX_LENGTH_DATA","OT");//commented by parul for IN020183 on 23/03/2010
		var details_label =getLabel("eOH.Details.Label","OH");
		var msg = getMessage("APP-OH000181","OH");	
		var msgArray = msg.split("#");
		alert(msgArray[0]+details_label+""+msgArray[1]+limit+msgArray[2]);
		var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

     function populateComplicationDetailsFirstLoadingTime()
		{
			var formObj=document.forms[0];
			var DB_task_code_first=formObj.DB_task_code_first.value;
			var DB_task_desc_first=formObj.DB_task_desc_first.value;
			var DB_task_seq_first =formObj.DB_task_seq_first.value;
			var status_disabled   =formObj.status_disabled.value;
			var count=0;
            populateComplicationDetails(DB_task_code_first,DB_task_desc_first,status_disabled,DB_task_seq_first,count);
		}
