function formatTimePerPatient(obj)
{  
	if (obj.value.length == 2)
	{
		if (obj.value.substring(1,2) == ':') 
		{
			obj.value = '0' + obj.value ;
		}

	}

	if (obj.value.length == 3)
	{
		if (obj.value.substring(0,1) == ':')
		{
			obj.value = '00' + obj.value ;
		}

	}
}
function checkColon(dt){
 
 charAtpos3=dt.charAt(2);
 
 if (charAtpos3 == ':')
   return true;
	 else
   return false;
 
}
// Following validation is common for Start Time And End Time of Functions
//   Time Table Scheduling and Set Up Daily Schedule

function timeValidation(Obj,fromField,fromFunc){ // 1

 if (Obj.value!=''){ //2
	if (chkTime(Obj.value)==false || checkColon(Obj.value)==false){ //3
		var errors= getMessage("INVALID_TIME_FMT","SM");
		alert(errors);
		Obj.value='';
		Obj.focus();
	}
else
{   givenTimeArr=(Obj.value).split(':');
	if (fromField=='S'){ //4
	     if (fromFunc!='SetUpDailySchedule'){		
			 if (fromFunc=='SetUpDailySchedulemodify'){
				 defStTime=document.forms[0].defStartTime.value;
				 defEdTime=document.forms[0].defEndTime.value;
				 givenEndTime=document.forms[0].end_time.value;				 
			 }else{
				defStTime=document.forms[0].p_start_time.value ;
				defEdTime=document.forms[0].p_end_time.value ;
				givenEndTime=document.forms[0].end_time.value;				
			 }
		 }else	{
			defStTime=document.forms[0].p_start_time.value ;
			defEdTime=document.forms[0].p_end_time.value ;
			givenEndTime=document.forms[0].end_time.value;
		}	  
		defStTimeArr=defStTime.split(':');		
		defStTime1=createDate(defStTimeArr[0],defStTimeArr[1]);
		stTime1=createDate(givenTimeArr[0],givenTimeArr[1]);
		givenEndTimeArr=givenEndTime.split(':');
		givenEndTime1=createDate(givenEndTimeArr[0],givenEndTimeArr[1]);
		

	    message=getMessage("ST_TIME_LS_DEF_ST_TIME","OA")+" "+defStTime ;
		message1=getMessage("START_TIME_GRT_CLN_DEF_END_TIME","OA")+" "+defEdTime;
		message2=getMessage("START_TIME_GRT_CLN_END_TIME","OA")+" "+givenEndTime;
		

			if (Date.parse(defStTime1) > Date.parse(stTime1))  //5
		{
			alert(message);
			Obj.value=defStTime;
			Obj.select();
			Obj.focus();
		}else{
			
				if (defEdTime!=null && defEdTime!=''){//6
					defEdTimeArr=defEdTime.split(':');
					defEdTime1=createDate(defEdTimeArr[0],defEdTimeArr[1]);
						if (Date.parse(defEdTime1) <= Date.parse(stTime1)) {
							alert(message1);
							Obj.value=defStTime;
							Obj.select();
							Obj.focus();
						}else if (Date.parse(givenEndTime1)<= Date.parse(stTime1)){
							alert(message2);
							Obj.value=defStTime;
							Obj.select();
							Obj.focus();
						}
				}//6
		}//5
 	
		
		
	}else if (fromField=='E'){ //4	
	if (fromFunc!='SetUpDailySchedule'){		
		if (fromFunc=='SetUpDailySchedulemodify'){
			defEndTime=document.forms[0].defEndTime.value;
			defStartTime=document.forms[0].defStartTime.value;
			givenStartTime=document.forms[0].start_time.value;				    
		 }else{
			defEndTime=document.forms[0].p_end_time.value;
			defStartTime=document.forms[0].p_start_time.value;
			givenStartTime=document.forms[0].start_time.value;			
		 }
		
	}else{
		defEndTime=document.forms[0].p_end_time.value ;
		defStartTime=document.forms[0].p_start_time.value ;
		givenStartTime=document.forms[0].start_time.value;	
	}
	
		if (defStartTime=='') {
			if (fromFunc=='SetUpDailySchedulemodify' || fromFunc=='SetUpDailySchedule' )
			    defStartTime=document.forms[0].start_time.value;
			else
				defStartTime=document.forms[0].start_time.value;

		}
     	defEdTimeArr=defEndTime.split(':');
		givenStartTimeArr=givenStartTime.split(':');

		defEdTime1=createDate(defEdTimeArr[0],defEdTimeArr[1]);
		givenTime1=createDate(givenTimeArr[0],givenTimeArr[1]);
		givenStartTime1=createDate(givenStartTimeArr[0],givenStartTimeArr[1]);
        

		message=getMessage("ET_TIME_GR_DEF_ET_TIME","OA")+" "+defEndTime;
		message1=getMessage("ED_TIME_LESS_EQL_ST_TIME","OA")+" "+defStartTime;
		message2=getMessage("ED_TIME_LESS_EQL_ST_TIME","OA")+" "+ givenStartTime;
			if (Date.parse(givenTime1) > Date.parse(defEdTime1))  //5
		{
			alert(message);
			Obj.value=defEndTime;
			Obj.select();
			Obj.focus();
		}else{
			
				if (defStartTime!=null && defStartTime!=''){//6
					defStTimeArr=defStartTime.split(':');
					defStTime1=createDate(defStTimeArr[0],defStTimeArr[1]);
					    if (Date.parse(givenStartTime1)>=Date.parse(givenTime1))
					    {
							alert(message2);
							Obj.value=defEndTime;
							Obj.select();
							Obj.focus();
					    }else if (Date.parse(givenTime1) <= Date.parse(defStTime1)) {//7
							alert(message1);
							Obj.value=defEndTime;
							Obj.select();
							Obj.focus();
						}else{
						if (fromFunc=='modify')
						{
							clearMaxFirstVisit(Obj);
						}
						if (fromFunc=='SetUpDailySchedulemodify')
						{
							setUpDaily(); //intermediate function
						}
						}//7
				}//6
		}//5

		}//4
  } // 3
 } // 2
} // 1

function createDate(hr,mi){
	
	dt = new Date();
	year=dt.getFullYear();
	month=dt.getMonth();
	date=dt.getDate();
	newDate=new Date(year,month,date,hr,mi,0,0);
	return(newDate);
}

function setUpDaily(){ // this is intermediate function the following lines need to be executed on blur of End Time of Set Up Daily Schedule
var function_mode =parent.frames[1].document.forms[0].function_mode.value;
	if (function_mode!="modify"){
		if(parent.frames[1].document.forms[0].start_time.value != parent.frames[1].document.forms[0].p_start_time.value || parent.frames[1].document.forms[0].end_time.value != parent.frames[1].document.forms[0].p_end_time.value){
			parent.frames[1].document.forms[0].time_per_patient.value='';
			parent.frames[1].document.forms[0].max_patients_per_day.value='';
			parent.frames[1].document.forms[0].time_per_slab.value='';
			parent.frames[1].document.forms[0].max_patients_per_slab.value='';
		}
	}
}


function populateLocations(Obj){
    //populate(Obj,'SetupDailySchedule');
	
	if(Obj.value!=""){
	document.getElementById("b_loc_val").value="";
	document.getElementById("b_loc_val").disabled=false;
	document.getElementById("b_loc_search").disabled=false;
	}else{
	document.getElementById("b_loc_val").value="";
	document.getElementById("b_loc_val").disabled=true;
	document.getElementById("b_loc_search").disabled=true;
	if(document.forms[0].b_day){
        var b_day = document.forms[0].b_day;
		var len=b_day.length;
		var i=1;
		while(i<len)
		{
			len=b_day.length;
			b_day.remove(i);
		}
		
		var opt = document.createElement("OPTION");
		opt.text ="*"+getLabel("Common.all.label","Common");
		opt.value= "*A";
		document.forms[0].b_day.add(opt);
	    }

	}

	document.getElementById("imgpract").style.visibility='hidden';
	
	document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';

	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	document.getElementById("resourceType").value='';
	document.getElementById("resourceType").disabled=true;
	 checkRoster('1'); // newly added

	document.getElementById("time_table_type").value='';
	document.forms[0].start_time.value='';
	document.forms[0].end_time.value='';
	document.forms[0].p_start_time.value='';
	document.forms[0].p_end_time.value='';
	document.forms[0].hddDur.value='';
	document.forms[0].time_per_slab.value='';
	document.forms[0].time_per_patient.value='';

	displayMandatory(document.getElementById("time_table_type"));
	timetableType(document.getElementById("time_table_type"));
	allowforced();

 
	remove_freeform(Obj.value)	

}
function locationPopulate(obj){

	var locationType= obj;
	if (obj.value!=''){
	populate(obj,'TimeTableScheduling');
	} else
	{  obj1=document.forms[0].b_clinic;
	  var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);
	}
}

/*function populate(obj,from){

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+obj.value+"\"  steps='1' from=\""+from+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 

}*/


function allowValidNumber(fld, e, maxInt, deci)
{
	
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}


async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	locn_type=document.forms[0].location_type.value;
	var care_locn_ind=document.forms[0].location_type.value;
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
	var retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=SetUpDailySchedule",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_all_pract_yn=rvalues[2];
		var clinic_type=rvalues[3];
		var ident_at_checkin=rvalues[4];
		var fi_visit_type_appl_yn=rvalues[5];
		var alcn_criteria=rvalues[6];
		var STime=rvalues[7];
		var ETime=rvalues[8];
		var dur=rvalues[9];
		var primary_resource_class=rvalues[10];
		var rad_appl_yn=rvalues[11];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=code+"$"+clinic_type+"$"+open_all_pract_yn+"$"+ident_at_checkin+"$"+fi_visit_type_appl_yn+"$"+alcn_criteria+"$"+STime+"$"+ETime+"$"+dur+"$"+primary_resource_class;
		/*onChangeEvents();
		checkResource(document.forms[0].blocation)*/
		displayMandatory(document.getElementById("time_table_type"));
		timetableType(document.getElementById("time_table_type"));
		allowforced();
		checkinIdentification(document.forms[0].location);
		if(document.forms[0].b_day && open_all_pract_yn=='Y')
			populatePractitioner();
		if(rad_appl_yn=="Y"){ 
			document.forms[0].resourceType.selectedIndex=2;			
			enable_dsiable_res(document.forms[0].resourceType)
			document.forms[0].resourceType.disabled=true;
			document.forms[0].time_table_type.selectedIndex=1;
			check_loc(document.forms[0].time_table_type);
			document.forms[0].time_table_type.disabled=true;
		}
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		displayMandatory(document.getElementById("time_table_type"));
		timetableType(document.getElementById("time_table_type"));
		allowforced();
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		checkinIdentification(document.forms[0].location);
		document.getElementById("resourceType").disabled=true;
		if(document.forms[0].b_day){
		var b_day = document.forms[0].b_day;
		var len=b_day.length;
		var i=1;
		while(i<len)
		{
			len=b_day.length;
			b_day.remove(i);
		}
		
		var opt = document.createElement("OPTION");
		opt.text ="*"+getLabel("Common.all.label","Common");
		opt.value= "*A";
		document.forms[0].b_day.add(opt);
		}
	  checkRoster('1'); // newly added

	}else{
	open_loc_lookup()
	}
}

function populatePractitioner()
{
	if(parent.frames[1].document.forms[0].b_day.disabled)
		parent.frames[1].document.forms[0].b_day.disabled=false;


	var dayy = parent.frames[1].document.forms[0].b_day;

	while ( dayy.options.length > 0 )
		dayy.remove(dayy.options[0]);

	var opt = parent.frames[1].document.createElement('OPTION');
	opt.text ="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value= '';
	parent.frames[1].document.forms[0].b_day.add(opt);

	var retVal	= parent.frames[1].document.forms[0].location.value ;
	var rvalues=retVal.split("$");
	var clinic_code=rvalues[0];
	var resource_id="";
	var resource_type="";
	if(document.forms[0].resourceType){
		resource_type=document.forms[0].resourceType.value;
	}
	if(document.forms[0].practitioner){
		resource_id=document.forms[0].practitioner.value;
	}
	if (clinic_code != null && clinic_code != "")
	{
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='populatepract' id='populatepract' method='post' action='../../eOA/jsp/TimeTablePract.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+clinic_code+"'><input type='hidden' name='resource_type' id='resource_type' value='"+resource_type+"'><input type='hidden' name='resource_id' id='resource_id' value='"+resource_id+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.populatepract.submit();
		parent.frames[1].document.forms[0].b_max_slots_for_first_visit.value="0";
	}
    else
	//parent.frames[1].document.forms[0].pract_butt.disabled=true;
	parent.frames[1].document.getElementById("imgpract").style.visibility='hidden';
	parent.frames[1].document.forms[0].b_max_slots_for_first_visit.value="0";
}


// added for allocation
async function showAalocation(){

	
	var max_patients_per_day=document.SetUpDailySchedule.max_patients_per_day.value;
	var time_table_type=document.SetUpDailySchedule.time_table_type.value;
	var b_max_slots_per_day=document.SetUpDailySchedule.b_max_slots_per_day.value;
	if(max_patients_per_day==""){
		alert(getMessage("MAX_PAT_NOT_DEFINED","OA"));
	}else{
		var dialogTop = "60" ;
		var dialogHeight= "20" ;
		var dialogWidth	= "50" ;
		var status = "no";
		var arguments	= "" ;
		var tit="Alcn_criteria";
		var final_alcn_criteria=document.SetUpDailySchedule.final_alcn_criteria.value;
		var slot_appt_ctrl=document.SetUpDailySchedule.slot_appt_ctrl.value;
		var alcn_criteria=document.SetUpDailySchedule.alcn_criteria.value;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				
		var retVal = await window.showModalDialog("../../eOA/jsp/ClinicAllocation.jsp?slot_appt_ctrl="+slot_appt_ctrl+"&alcn_criteria="+alcn_criteria+"&max_patients_per_day="+max_patients_per_day+"&time_table_type="+time_table_type+"&final_alcn_criteria="+final_alcn_criteria,arguments,features);	
		
		if(retVal!=undefined){
			document.SetUpDailySchedule.final_alcn_criteria.value=retVal;
			document.SetUpDailySchedule.final_string.value=retVal;
		
		}
	}
}

