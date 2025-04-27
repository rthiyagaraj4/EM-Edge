function locationPopulate(obj){	
	
/*	if(obj.value!=""){
		document.getElementById('b_loc_val').value="";
		document.getElementById('blocation').value="";
		 parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}else{ */
		document.getElementById('b_loc_val').value="";
		document.getElementById('blocation').value="";
	var n=document.forms[0].Time_Table_Details.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].Time_Table_Details.remove("clinic");		
	}
	var opt=document.createElement("OPTION");
	opt.text="-------------"+getLabel("Common.defaultSelect.label","Common")+"---------------";
	opt.value="";
	document.forms[0].Time_Table_Details.add(opt);		
	parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
	parent.frames[2].document.location.href='../../eCommon/html/blank.html'	
    parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
	
	//}
}

function ena_loc_lookup(obj){
	if(obj.value==null || obj.value==''){
		document.forms[0].blocation.value="";
		document.forms[0].Time_Table_Details.value="";
		var n=document.forms[0].Time_Table_Details.options.length;
		for(var i=0;i<n;i++){
			document.forms[0].Time_Table_Details.remove("clinic");		
		}
		var opt=document.createElement("OPTION");
		opt.text="-------------"+getLabel("Common.defaultSelect.label","Common")+"---------------";
		opt.value="";
		document.forms[0].Time_Table_Details.add(opt);					
		parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
		parent.frames[2].document.location.href='../../eCommon/html/blank.html'	
		
	}else{
	open_loc_lookup()
	}
}


async function open_loc_lookup(){
	var location1=document.forms[0].locationType.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[0];
	var care_locn_ind=location1[0];
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	//retVal = window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=QRY_APPT_DOCT",arguments,features);
	
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=SCH_APPT",arguments,features);
		
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];	 
		var loc = document.forms[0].blocation.value.split("$")	
		var clinic_code=loc[1];	 
		if(clinic_code != code){
			var n=document.forms[0].Time_Table_Details.options.length;
			for(var i=0;i<n;i++){
				document.forms[0].Time_Table_Details.remove("clinic");		
			}
			var opt=document.createElement("OPTION");
			opt.text="-------------"+getLabel("Common.defaultSelect.label","Common")+"---------------";
			opt.value="";
			document.forms[0].Time_Table_Details.add(opt);					
			parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
			parent.frames[2].document.location.href='../../eCommon/html/blank.html'
		
			var desc=rvalues[1];
			var open_all_pract_yn=rvalues[2];
			document.forms[0].b_loc_val.value=desc;
			document.forms[0].blocation.value=open_all_pract_yn+"$"+code;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH clinic_code=\""+code+"\" steps='1' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","CopyTimeTableIntermediate.jsp",false) 
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)		
	 		eval(responseText)		
	   }
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].blocation.value="";
		var n=document.forms[0].Time_Table_Details.options.length;
		for(var i=0;i<n;i++){
			document.forms[0].Time_Table_Details.remove("clinic");		
		}
		var opt=document.createElement("OPTION");
		opt.text="-------------"+getLabel("Common.defaultSelect.label","Common")+"---------------";
		opt.value="";
		document.forms[0].Time_Table_Details.add(opt);					
		parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
		parent.frames[2].document.location.href='../../eCommon/html/blank.html'
	
	}

}

function TimeTableDetails(obj){
	if(obj.value!=""){
		var TimeTableDetails=obj.value.split("|");
		var pract_id=TimeTableDetails[0];
		var time_table_type=TimeTableDetails[1];
		var day_no=TimeTableDetails[2];
		var resource_class=TimeTableDetails[3];
		var start_time=TimeTableDetails[4];
		var end_time=TimeTableDetails[5];
		var loc = document.forms[0].blocation.value.split("$")
		var open_all_pract_yn=loc[0];
		var clinic_code=loc[1];
		parent.frames[1].location.href = "../../eOA/jsp/CopyTimeTableDetails.jsp?pract_id="+pract_id+"&time_table_type="+time_table_type+"&day_no="+day_no+"&clinic_code="+clinic_code+"&open_all_pract_yn="+open_all_pract_yn+"&resource_class="+resource_class;
		
		parent.frames[2].location.href = "../../eOA/jsp/CopyTimeTableResult.jsp?pract_id="+pract_id+"&time_table_type="+time_table_type+"&day_no="+day_no+"&clinic_code="+clinic_code+"&open_all_pract_yn="+open_all_pract_yn+"&resource_class="+resource_class+"&start_time="+start_time+"&end_time="+end_time;	
	//	parent.frames[2].location.href = "../../eOA/jsp/upload.jsp?pract_id="+pract_id+"&time_table_type="+time_table_type+"&day_no="+day_no+"&clinic_code="+clinic_code+"&open_all_pract_yn="+open_all_pract_yn+"&resource_class="+resource_class+"&start_time="+start_time+"&end_time="+end_time;	
	}else{		
		parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
		parent.frames[2].document.location.href='../../eCommon/html/blank.html'	
	}
}


function reset() 
{
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[1].document.location.href='../../eCommon/html/blank.html'
	frames[1].frames[2].document.location.href='../../eCommon/html/blank.html'	
}


function apply(){		

	if(frames[1].frames[2].document.PractTimeTableCopy){
	var visitLimtRuleParam = frames[1].frames[1].document.forms[0].visitLimtRuleParam.value;
	var visit_limit_rule = frames[1].frames[1].document.forms[0].visit_limit_rule.value;

	if(visitLimtRuleParam == visit_limit_rule){
	var len=frames[1].frames[2].document.PractTimeTableCopy.nochkbox.value;
	
	var finalPract="";
	
	 for(var k=0; k<len; k++){  
		if(eval('frames[1].frames[2].document.PractTimeTableCopy.selected_'+k).checked==true){			
			finalPract = finalPract +eval('frames[1].frames[2].document.PractTimeTableCopy.practitioner_id_'+k).value;		
				finalPract = finalPract +"|";			
		}		
	}
	
	finalPract = finalPract.substring(0,finalPract.length-1)

	frames[1].frames[1].document.forms[0].finalPractList.value = finalPract;	

	if(frames[1].frames[1].document.forms[0].finalPractList.value != ""){
		frames[1].frames[1].document.forms[0].submit();
	}else{ 
		var msg=getMessage('NO_CHANGE_TO_SAVE','Common');
			alert(msg);
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	}
}else{		
		var msg=getMessage('VISIT_LIMIT_RULE_DIFF','OA');
			alert(msg);
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
	 }
  }else{
	   messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
  }
}

function onSuccess(){ 
	frames[1].frames[0].document.location.reload();
	frames[1].frames[1].document.location.href='../../eCommon/html/blank.html'
	frames[1].frames[2].document.location.href='../../eCommon/html/blank.html'	

}
