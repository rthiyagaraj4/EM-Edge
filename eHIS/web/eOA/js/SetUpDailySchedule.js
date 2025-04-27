function create()  
{   
frames[1].document.location.href='../../eOA/jsp/SetUpDailyScheduleHeader.jsp?oper_stn_id='+document.getElementById("oper_stn_id").value;
} 
var bol=true;


var conf;


async function apply()
{		
		var url=f_query_add_mod.location.href;
		if ( url.indexOf("blank")==-1 && url.indexOf("QueryCriteria.jsp")==-1 && url.indexOf("QueryResult.jsp")==-1)
		{
		var startarray;
		var endarray  ;
		var starttime = frames[1].document.forms[0].start_time.value ;
		var endtime   = frames[1].document.forms[0].end_time.value ;
		var resourceType=frames[1].document.forms[0].resourceType.value ;
		var sttime    ;
		var entime    ;
		var totaltime ;
		var fromarray ;
		var toarray   ;
		var fromtime  ;
		var totime    ;
		var frtime    ;
		var tootime   ;
		breaktime     = 0 ;
		var frtotime  ;
		var frto      = new Array() ;
		var dummytime = '00:00' ;
		var dummyarray;
		var dumtime   ;
		var timerinseconds ;
		var starttime1array  ;
		var endtime1array;
		var starttime2;
		var endtime2;
		var status1="N";
	
		var time_per_patient = frames[1].document.forms[0].time_per_patient.value ;
		var tpparray  ;
		var timeperpatient ;
	
		var time_per_slab    = frames[1].document.forms[0].time_per_slab.value ;
		var tpsarray  ;
		var timeperslab ;
	
		var time_table_type  = frames[1].document.forms[0].time_table_type.value ;
		var max_first_visit  = frames[1].document.forms[0].max_first_visit.value;
		var max_over_bookings = frames[1].document.forms[0].max_over_bookings.value;
		var max_pat_per_day  = frames[1].document.forms[0].max_patients_per_day.value;
		var start_time1      = frames[1].document.forms[0].start_time.value ;
	    var end_time1        = frames[1].document.forms[0].end_time.value ;

		
		var maxpat	;
		
		var toSubmit 	= new Boolean() ;
		toSubmit	= true ;

		var to_submit1 	= new Boolean() ;
		to_submit1 = true ;

		var allow_three 	= new Boolean() ;
		allow_three	= true ;
	
		var toBreakTime	= new Boolean() ;
		toBreakTime	= true ;

	
	var time_table_type	= frames[1].document.forms[0].time_table_type.value ;
	if (time_table_type == '1')
	{
		var fields = new Array ( frames[1].document.forms[0].b_loc_val,
								frames[1].document.forms[0].resourceType,
								 frames[1].document.forms[0].clinic_date,
								 frames[1].document.forms[0].time_table_type,
								 frames[1].document.forms[0].start_time,
								 frames[1].document.forms[0].end_time,
								 frames[1].document.forms[0].time_per_patient,
								 frames[1].document.forms[0].max_patients_per_day);
if(frames[1].document.forms[0].slot_appt_ctrl.value =="P")
		{
	
		var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.TimeperPatient.label","OA"),
								getLabel("eOA.maxpatperday.label","OA")
							);
	}
	else
		{
				var names = new Array ( getLabel("Common.Location.label","Common"),
										getLabel("Common.resourcetype.label","Common"),
										getLabel("Common.date.label","Common"),
										getLabel("eOA.TimeTableType.label","OA"),
										getLabel("Common.StartTime.label","Common"),
										getLabel("Common.EndTime.label","Common"),
										getLabel("eOA.TimeperSlot.label","OA"),
										getLabel("eOA.maxpatperday.label","OA"));
		}

	}
	else if (time_table_type == '2')
	{
		var fields = new Array ( frames[1].document.forms[0].b_loc_val,
								 frames[1].document.forms[0].resourceType,
								 frames[1].document.forms[0].clinic_date,
								 frames[1].document.forms[0].time_table_type,
								 frames[1].document.forms[0].start_time,
								 frames[1].document.forms[0].end_time,
								 frames[1].document.forms[0].time_per_slab,
								 frames[1].document.forms[0].max_patients_per_slab);

		var names = new Array ( getLabel("Common.Location.label","Common"),
							    getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.timeperslab.label","OA"),
								getLabel("eOA.maxpatperslab.label","OA")
							);
	}
	else
	{
		var fields = new Array ( frames[1].document.forms[0].b_loc_val,
					frames[1].document.forms[0].resourceType,
					 frames[1].document.forms[0].clinic_date,
					 frames[1].document.forms[0].time_table_type,
					 frames[1].document.forms[0].start_time,
					frames[1].document.forms[0].end_time,
					 frames[1].document.forms[0].max_patients_per_day) ;


		var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.maxpatperday.label","OA")
								);
	}
	if(frames[1].document.forms[0].rule_appl_yn.value =="Y"){
		fields.push(frames[1].document.forms[0].max_new_patients);
		fields.push(frames[1].document.forms[0].max_old_patients);
		names.push("Max New Patients");
		names.push("Max Old Patients");			
	}

		if(frames[1].document.getElementById("imgpract"))
		{		
			if(frames[1].document.getElementById("imgpract").style.visibility == 'visible')
			{
			fields[fields.length]=frames[1].document.forms[0].practitioner;
			names[names.length]=getLabel("Common.resourcename.label","Common");
			}
		}


	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{

	}
	else
	{
	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	var proceed_yn = "Y";
	var isScheduleExtendAppl = frames[1].document.forms[0].isScheduleExtendAppl.value ;
	var schedule_extend_param = frames[1].document.forms[0].schedule_extend_param.value ;

	if(isScheduleExtendAppl == "true" && schedule_extend_param == "Y")
	{
		var schedule_extend_yn = frames[1].document.forms[0].schedule_extend_yn.value ;

		if(schedule_extend_yn == "Y" && time_table_type != "3" && endtime != "")
		{
			if(endtime == "23:59")
			{
				alert(getMessage("END_TIME_ALREADY_EXTENDED","OA"));
				frames[1].document.forms[0].schedule_extend_yn.checked=false;
				frames[1].document.forms[0].schedule_extend_yn.value="N";
				proceed_yn = "N";
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				return false;
			}else
			{
				var xmlDoc=""
				var xmlHttp = new XMLHttpRequest()
				xmlStr = "<root><SEARCH endtime=\""+endtime+"\" action='timeDifference' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText = xmlHttp.responseText
				var time_diff = trimString(responseText);

				if(time_table_type == "1"){
					var time_per_slot = frames[1].document.forms[0].time_per_patient.value ;
					if(time_per_slot != "" && time_diff > time_per_slot){
						alert(getMessage("CANNOT_EXTEND_SCHEDULE","OA"));
						frames[1].document.forms[0].end_time.select();
						frames[1].document.forms[0].end_time.focus();
						proceed_yn = "N";
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
					
				}else if(time_table_type == "2"){
					var time_per_slab = frames[1].document.forms[0].time_per_slab.value ;
					if(time_per_slab != "" && time_diff > time_per_slab){
						alert(getMessage("CANNOT_EXTEND_SCHEDULE","OA"));
						frames[1].document.forms[0].end_time.select();
						frames[1].document.forms[0].end_time.focus();
						proceed_yn = "N";
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
				}
			}
		}
	}

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	var isSlotStartMidEndAppl = frames[1].document.forms[0].isSlotStartMidEndAppl.value;

	if(isSlotStartMidEndAppl == "true" && time_table_type != "3"){

		var start_appt_exst = frames[1].document.forms[0].start_appt_time.value ;
		var function_mode = frames[1].document.forms[0].function_mode.value ;

		if(start_appt_exst != "" && function_mode == "modify")
		{
			var old_ext_all_slots_yn = frames[1].document.forms[0].old_ext_all_slots_yn.value ;
			var new_ext_all_slots_yn = frames[1].document.forms[0].ext_all_slots_yn.value ;

			var old_ext_start_slots = frames[1].document.forms[0].old_ext_start_slots.value ;
			var new_ext_start_slots = frames[1].document.forms[0].ext_start_slots.value ;

			var old_ext_mid_slots = frames[1].document.forms[0].old_ext_mid_slots.value ;
			var new_ext_mid_slots = frames[1].document.forms[0].ext_mid_slots.value ;

			var old_ext_end_slots = frames[1].document.forms[0].old_ext_end_slots.value ;
			var new_ext_end_slots = frames[1].document.forms[0].ext_end_slots.value ;

			if((old_ext_all_slots_yn != new_ext_all_slots_yn) || (old_ext_start_slots != new_ext_start_slots) || (old_ext_mid_slots != new_ext_mid_slots) || (old_ext_end_slots != new_ext_end_slots))
			{
				alert(getMessage("AAPT_EXST_CANT_MODIFY_BRU_VAL","OA"));
				proceed_yn = "N";
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				return false;
			}
		}

		var ext_start_slots = frames[1].document.forms[0].ext_start_slots.value ;
		if(ext_start_slots == "") ext_start_slots = 0;
		var ext_mid_slots = frames[1].document.forms[0].ext_mid_slots.value ;
		if(ext_mid_slots == "") ext_mid_slots = 0;
		var ext_end_slots = frames[1].document.forms[0].ext_end_slots.value ;
		if(ext_end_slots == "") ext_end_slots = 0;
		var max_pat_per_day_cnt = frames[1].document.forms[0].max_patients_per_day.value;
		var max_patients_per_slab_cnt = frames[1].document.forms[0].max_patients_per_slab.value;

		var total_slots = parseInt(ext_start_slots) + parseInt(ext_mid_slots) + parseInt(ext_end_slots);
		
		if(time_table_type == "1")
		{
			if(total_slots > max_pat_per_day_cnt)
			{
				alert(getMessage("SLOT_START_MID_END_LESS_OR_EQUAL","OA"));
				proceed_yn = "N";
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				return false;
			}else
			{
				if(ext_mid_slots != "" && ext_mid_slots != 0)
				{
					var allowed_SME = max_pat_per_day_cnt / 3;
					allowed_SME = Math.floor(allowed_SME);
					if(ext_start_slots > allowed_SME || ext_mid_slots > allowed_SME || ext_end_slots > allowed_SME)
					{
						var error;
						error=getMessage("SLOTS_OVERLAPPING","OA");
						error=error.replace("#", allowed_SME);
						alert(error);
						proceed_yn = "N";
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
				}
			}
		}else if(time_table_type == "2")
		{

			if(total_slots > max_pat_per_day_cnt)
			{
				alert(getMessage("SLOT_START_MID_END_LESS_OR_EQUAL","OA"));
				proceed_yn = "N";
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				return false;
			}else
			{	
				if(ext_start_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					proceed_yn = "N";
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_mid_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					proceed_yn = "N";
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_end_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					proceed_yn = "N";
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_mid_slots != "" && ext_mid_slots != 0)
				{
					var allowed_SME = max_pat_per_day_cnt / 3;
					allowed_SME = Math.floor(allowed_SME);
					if(ext_start_slots > allowed_SME || ext_mid_slots > allowed_SME || ext_end_slots > allowed_SME)
					{
						var error;
						error=getMessage("SLOTS_OVERLAPPING","OA");
						error=error.replace("#", allowed_SME);
						alert(error);
						proceed_yn = "N";
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
				}
			}
		}
	}

	if(proceed_yn == 'Y')
	{

var currDate=frames[1].document.forms[0].CurrentDate.value;
var currDateArr=currDate.split('/');
var givenDate=frames[1].document.forms[0].clinic_date.value;
var givenDateArr=givenDate.split('/');
var givenTime=frames[1].document.forms[0].start_time.value;

var curDate1 = new Date(currDateArr[2],parseInt(currDateArr[1])-1,currDateArr[0],0,0);
var givenDate1= new Date(givenDateArr[2],parseInt(givenDateArr[1])-1,givenDateArr[0],0,0);


if (Date.parse(curDate1)==Date.parse(givenDate1))
{ 

//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr += "Time=\"" +givenTime + "\" steps='validateTime'";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	if (v_Flag==1)
	{

		alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
		frames[1].document.forms[0].start_time.value="";
		frames[1].document.forms[0].start_time.focus();
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		return false;

	}

}





if ( frames[1].document.forms[0].time_table_type.value=='3')
{

var OB_flag=MaxOverBookings(frames[1].document.forms[0].max_over_bookings,"apply");
if (!OB_flag && OB_flag!=null){
frames(1).document.forms[0].max_over_bookings.value="";
messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
return false;
}

}



	
	p_from_time1 	=	frames[1].document.forms[0].from_time1.value ;
	p_to_time1 	=	frames[1].document.forms[0].to_time1.value ;
	p_from_time2 	=	frames[1].document.forms[0].from_time2.value ;
	p_to_time2 	=	frames[1].document.forms[0].to_time2.value ;
	p_from_time3 	=	frames[1].document.forms[0].from_time3.value ;
	p_to_time3 	=	frames[1].document.forms[0].to_time3.value ;
	p_from_time4 	=	frames[1].document.forms[0].from_time4.value ;
	p_to_time4 	=	frames[1].document.forms[0].to_time4.value ;
	p_from_time5 	=	frames[1].document.forms[0].from_time5.value ;
	p_to_time5 	=	frames[1].document.forms[0].to_time5.value ;

	olStr		= p_from_time1 + '-' + p_to_time1 + ',' + p_from_time2 + '-' + p_to_time2 + ',' + p_from_time3 + '-' + p_to_time3 + ',' ;
	olStr	       += p_from_time4 + '-' + p_to_time4 + ',' + p_from_time5 + '-' + p_to_time5 + ',';

	
	gvar		= olStr.split(",");

       var sttime= frames[1].document.forms[0].start_time.value;
       var edtime= frames[1].document.forms[0].end_time.value;


		fromarray= sttime.split(":") ;
		toarray  = edtime.split(":") ;

		fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;

		if(fromtime >= totime )
		{
			var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OA");
			status1 = 'Y' ;
			alert(errors);
			toSubmit = false;
			parent.frames[0].document.forms[0].end_time.focus();
		parent.frames[0].document.forms[0].end_time.select();
		}


	outerforloop: for (var i=0;i<5;i++)
	{
		frtotime = gvar[i] ;
		frto	 = frtotime.split("-") ;
		
		fromarray= frto[0].split(":") ;
		toarray  = frto[1].split(":") ;

		start1array= start_time1.split(":") ;
		end1array  = end_time1.split(":") ;

		fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		totime	 = new Date(1,1,1,toarray[0],toarray[1],0,0) ;

		starttime2 = new Date(1,1,1,start1array[0],start1array[1],0,0) ;
		endtime2 = new Date(1,1,1,end1array[0],end1array[1],0,0) ;


		if ((fromarray.length < 2) && (toarray.length == 2))
		{
			toBreakTime = false;
		}
		else if ((toarray.length < 2) && (fromarray.length == 2))
		{
			toBreakTime = false;
		}
		if(fromtime >= totime )
		{
			var errors = getMessage("TO_TM_CANT_GR_FROM_TM","OA");
			status1 = 'Y' ;
			alert(errors);
			toSubmit = false;
		}
		
		if (toSubmit)
		{

	  if (Date.parse(fromtime) < Date.parse(starttime2))
	   {
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		toSubmit = false;
		to_submit1 = false;
		parent.parent.frames[1].document.frames[1].document.forms[0].start_time.focus()
	   }
	  
	   else if (Date.parse(fromtime) > Date.parse(endtime2))
	   {
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		toSubmit = false;
		to_submit1 = false;
		parent.parent.frames[1].document.frames[1].document.forms[0].start_time.focus()
	   }
	else if ( ( Date.parse(fromtime) == Date.parse(starttime2)) &&( Date.parse(totime) == Date.parse(endtime2))			)
	   {
		var errors = getMessage('BR_TM_NOT_VALID',"OA");
		alert(errors);
		toSubmit = false;
		to_submit1 = false;
	
	 	parent.parent.frames[1].document.frames[1].document.forms[0].start_time.focus()
	   }
		}
		for( var j=i+1;j<5;j++)
		{
			frtotime = gvar[j] ;
			frto	 = frtotime.split("-") ;

			fromarray= frto[0].split(":") ;
			toarray  = frto[1].split(":") ;

			frtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
			tootime= new Date(1,1,1,toarray[0],toarray[1],0,0) ;


			if ((Date.parse(fromtime) < Date.parse(frtime))  && (Date.parse(frtime) < Date.parse(totime)))
			{
				toSubmit = false;
			}
			else if ((Date.parse(fromtime) < Date.parse(tootime))  && (Date.parse(tootime) < Date.parse(totime)))
			{
				toSubmit = false;
			}
			else if ((Date.parse(frtime) < Date.parse(fromtime))  && (Date.parse(fromtime) < Date.parse(tootime)))
			{
				toSubmit = false;
			}
			else if ((Date.parse(frtime) < Date.parse(totime))  && (Date.parse(totime) < Date.parse(tootime)))
			{
				toSubmit = false;
			}
			else if ((Date.parse(frtime) == Date.parse(fromtime))  && (Date.parse(totime) == Date.parse(tootime)))
			{
				toSubmit = false;
			}
			else if ((Date.parse(fromtime)) == (Date.parse(totime)))
			{
				toSubmit = false;
				status = 'N' ;
			}
		}

		if(fromtime >= totime ){
			toBreakTime = false;
			break outerforloop;
		}

	}

	if (toBreakTime){

	if (!toSubmit&&to_submit1){
		



			if (status == 'N'){
				alert(getMessage('BREAK_TIME_NOT_MUL_STSB',"OA"));
				status = 'Y' ;
			}else{
				if (status1!="Y"){
					var errors = getMessage("BREAK_TIME_OVERLAPS","OA");
					alert(errors);
				}

			}
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		

	}else{

		olStr		= p_from_time1 + p_to_time1 + ',' + p_from_time2 + p_to_time2 + ',' + p_from_time3 + p_to_time3 + ',' ;
		olStr	       += p_from_time4 + p_to_time4 + ',' + p_from_time5 + p_to_time5 + ',';

		pvar		= olStr.split(",");

		for (var i=0;i<5;i++)
		{
			frtotime = pvar[i] ;

			fromarray= frtotime.substring(0,5).split(":") ;
			toarray  = frtotime.substring(5,10).split(":") ;

			fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
			totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;

			if ((fromarray != '') && (fromarray != null))
			{
				if ((toarray != '') && (toarray != null))
				{
					breaktime += totime - fromtime ;
				}
			}

		}
			tpparray       = time_per_patient.split(":") ;
			timeperpatient = new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;

			tpsarray       = time_per_slab.split(":") ;
			timeperslab    = new Date(1,1,1,tpsarray[0],tpsarray[1],0,0) ;

			dummyarray 	= dummytime.split(":") ;
			dumtime    	= new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

			if (time_table_type == '1')
			{
				timerinseconds = timeperpatient - dumtime;
								
			}
			else if (time_table_type == '2')
			{
				timerinseconds = timeperslab - dumtime ;
			}

			if (time_table_type != '3')
			{
				breakmod	= (breaktime%timerinseconds) ;
				
					var t_type=frames[1].document.forms[0].time_table_type.value;
					var time_dur='';
					var strt_tm=frames[1].document.forms[0].start_time.value;

					if(t_type=='2'){
						time_dur=frames[1].document.forms[0].time_per_slab.value;
					}else{
						time_dur=frames[1].document.forms[0].time_per_patient.value;
					}
		
					var brk_flg=true;

					if(time_dur!=''){
			
					var arr1=strt_tm.split(":");
					var arr2=time_dur.split(":");
					/*var first_arr=arr1[0];
					
					var new_val=first_arr.substring(0,first_arr.length-1);
				if(new_val =="0")
						{
					arr1[0]=first_arr.substring(1,first_arr.length);

						}
					alert(arr1[0]);*/
					var dur=(parseInt(arr2[0],10)*60) + parseInt(arr2[1]);
					var strt=(parseInt(arr1[0],10)*60) + parseInt(arr1[1]);
			
if(frames[1].document.forms[0].from_time1.value!=''){
							var arr3=frames[1].document.forms[0].from_time1.value.split(":");
							var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);	
							var modu=(br-strt) % dur;
							if(modu>0){
								alert(getMessage("BR_NT_ML_ST","OA"));
								frames[1].document.forms[0].from_time1.focus();
								brk_flg=false;
							}
						}

						if(brk_flg){
							if(frames[1].document.forms[0].to_time1.value!=''){
								var arr3=frames[1].document.forms[0].to_time1.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].to_time1.focus();
									brk_flg=false;
								}
							}
						}

						if(brk_flg){
							if(frames[1].document.forms[0].from_time2.value!=''){
								var arr3=frames[1].document.forms[0].from_time2.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].from_time2.focus();
									brk_flg=false;
								}
							}
						}

						if(brk_flg){
							if(frames[1].document.forms[0].to_time2.value!=''){
								var arr3=frames[1].document.forms[0].to_time2.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].to_time2.focus();
									brk_flg=false;
								}
							}
						}
						
						if(brk_flg){
							if(frames[1].document.forms[0].from_time3.value!=''){
								var arr3=frames[1].document.forms[0].from_time3.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].from_time3.focus();
									brk_flg=false;
								}
							}
						}
						
						if(brk_flg){
							if(frames[1].document.forms[0].to_time3.value!=''){
								var arr3=frames[1].document.forms[0].to_time3.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].to_time3.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].document.forms[0].from_time4.value!=''){
								var arr3=frames[1].document.forms[0].from_time4.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].from_time4.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].document.forms[0].to_time4.value!=''){
								var arr3=frames[1].document.forms[0].to_time4.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].to_time4.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].document.forms[0].from_time5.value!=''){
								var arr3=frames[1].document.forms[0].from_time5.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].from_time5.focus();
									brk_flg=false;
								}

							}
						}	
						if(brk_flg){
							if(frames[1].document.forms[0].to_time5.value!=''){
								var arr3=frames[1].document.forms[0].to_time5.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].document.forms[0].to_time5.focus();
									brk_flg=false;
								}
							}
						}
					}

				if(!brk_flg)
					breakmod=1;

				if (breakmod != 0 )
				{
					if(brk_flg){
						alert(getMessage('BREAK_TIME_NOT_MUL_STSB',"OA"));
						toSubmit = false;
					}else{
						toSubmit = false;
					}
				}
				else
				{  /*Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here */
					/*if(time_table_type == '1'){							
							var proceed=TimePerPatientValid_new();						
							if(proceed == false){								
								frames[1].document.forms[0].start_time.focus();
								frames[1].document.forms[0].start_time.onblur = new Function('movfocus()');
								frames[0].document.location.reload();
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
								return false;								
							   }							
						   }
						   var l_time_per_slab	= frames[1].document.forms[0].time_per_slab.value ;
						   var l_max_pat_per_slab	= frames[1].document.forms[0].max_patients_per_slab.value ;

						   if(time_table_type == '2'){									   
							    if (l_time_per_slab != ""){
								if (l_max_pat_per_slab <=0 && l_max_pat_per_slab!=""){
										alert(getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common"));
										frames[1].document.forms[0].max_patients_per_slab.focus();
										frames[0].document.location.reload();
										return false;
									  }
								    }
							var proceed=MaxPatPerSlab_new();								
							if(proceed == false){									
								frames[1].document.forms[0].start_time.focus();
								frames[1].document.forms[0].start_time.onblur = new Function('movfocus()');
								frames[0].document.location.reload();
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
								return false;								
							   }							
						   }*/
					/*Ends here*/
					
					
					
					breakdiff = (breaktime/timerinseconds);

					startarray= starttime.split(":") ;
					endarray  = endtime.split(":") ;

					sttime = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
					entime= new Date(1,1,1,endarray[0],endarray[1],0,0) ;

					totaltime = entime - sttime ;

					if (time_table_type == '1')
					{		
						var max_slot_per_day_old=frames[1].document.forms[0].b_max_slots_per_day.value;				
						var max_slot_per_day_temp = (totaltime / timerinseconds) - breakdiff ;
						max_slot_per_day_temp=max_slot_per_day_temp;

						if((''+max_slot_per_day_temp).indexOf (".") != -1 ){
							alert(getMessage("INVALID_CLINIC_SPAN_TIME","OA"));
							frames[1].document.forms[0].start_time.focus();
							messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
							return false;
						}
						if (max_slot_per_day_temp!=frames[1].document.forms[0].b_max_slots_per_day.value)
						{
							frames[1].document.forms[0].max_patients_per_day.value = max_slot_per_day_temp ;
							frames[1].document.forms[0].b_max_slots_per_day.value = max_slot_per_day_temp ;			
							var conf = confirm(getMessage("MAX_PAT_RECALCULATED","OA") );						
							if(conf == false)								
							{	
								frames[1].document.forms[0].max_patients_per_day.value = max_slot_per_day_old ;
								frames[1].document.forms[0].b_max_slots_per_day.value = max_slot_per_day_old ;
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";										
								return false;
							}
							
							//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
							if(isSlotStartMidEndAppl == "true"){
								var ext_start_slots = frames[1].document.forms[0].ext_start_slots.value ;
								if(ext_start_slots == "")ext_start_slots = 0;
								var ext_mid_slots = frames[1].document.forms[0].ext_mid_slots.value ;
								if(ext_mid_slots == "")ext_mid_slots = 0;
								var ext_end_slots = frames[1].document.forms[0].ext_end_slots.value ;
								if(ext_end_slots == "")ext_end_slots = 0;
								var max_pat_per_day_cnt = frames[1].document.forms[0].max_patients_per_day.value;

								var total_slots = parseInt(ext_start_slots) + parseInt(ext_mid_slots) + parseInt(ext_end_slots);
								
								if(total_slots > max_pat_per_day_cnt)
								{
									alert(getMessage("SLOT_START_MID_END_LESS_OR_EQUAL","OA"));
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
									return false;
								}else
								{
									if(ext_mid_slots != "" && ext_mid_slots != 0)
									{
										var allowed_SME = max_pat_per_day_cnt / 3;
										allowed_SME = Math.floor(allowed_SME);
										if(ext_start_slots > allowed_SME || ext_mid_slots > allowed_SME || ext_end_slots > allowed_SME)
										{
											var error;
											error=getMessage("SLOTS_OVERLAPPING","OA");
											error=error.replace("#", allowed_SME);
											alert(error);
											messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
											return false;
										}
									}
								}
							}
						}
				//}
			
				if(	frames[1].document.forms[0].function_mode.value!="modify"){
					if ((frames[1].document.forms[0].max_patients_per_day.value).length>3){			
						alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
						frames[1].document.forms[0].max_patients_per_day.value='' ;
						frames[1].document.forms[0].time_per_patient.value='';
						frames[1].document.forms[0].time_per_patient.focus();
						frames[1].document.forms[0].time_per_patient.select();		
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						return false;
						}	
				}
				else
				{
				if ((frames[1].document.forms[0].max_patients_per_day.value).length>3){				
					alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
					frames[1].document.forms[0].end_time.value='' ;
					frames[1].document.forms[0].end_time.focus();
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					return false;
					}
				}
			}
			if (time_table_type == '2')
			{
				 maxpat = ((totaltime / timerinseconds) * frames[1].document.forms[0].max_patients_per_slab.value); 	
				 if((''+maxpat).indexOf (".") != -1 ){
						alert(getMessage("INVALID_CLINIC_SPAN_TIME","OA"));
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						frames[1].document.forms[0].start_time.focus();
						return false;
				}
				frames[1].document.forms[0].max_patients_per_day.value =  maxpat - (breakdiff * frames[1].document.forms[0].max_patients_per_slab.value);
				//Added by S.Sathish for IN020308 on Thursday, April 01, 2010
				//frames[1].document.forms[0].max_other_visits.value=frames[1].document.forms[0].max_patients_per_day.value;	

				if ((frames[1].document.forms[0].max_patients_per_day.value).length>3){					
					alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
						if(	frames[1].document.forms[0].function_mode.value!="modify"){
							frames[1].document.forms[0].max_patients_per_day.value='';
							frames[1].document.forms[0].max_patients_per_slab.value='';
							frames[1].document.forms[0].max_patients_per_slab.focus();
							allow_three=false;
						}else{
							frames[1].document.forms[0].end_time.focus();
							frames[1].document.forms[0].end_time.value='';
						}
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					return false;
			}
		if(max_pat_per_day  != frames[1].document.forms[0].max_patients_per_day.value)		{
			
			
			var conf =confirm(getMessage("MAX_PAT_RECALCULATED","OA"));
		if(conf == false)
		{
			frames[1].document.forms[0].max_patients_per_day.value=max_pat_per_day;
			//frames[1].document.forms[0].max_other_visits.value=max_pat_per_day;
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		if(isSlotStartMidEndAppl == "true"){
			var ext_start_slots = frames[1].document.forms[0].ext_start_slots.value ;
			if(ext_start_slots == "")ext_start_slots = 0;
			var ext_mid_slots = frames[1].document.forms[0].ext_mid_slots.value ;
			if(ext_mid_slots == "")ext_mid_slots = 0;
			var ext_end_slots = frames[1].document.forms[0].ext_end_slots.value ;
			if(ext_end_slots == "")ext_end_slots = 0;
			var max_pat_per_day_cnt = frames[1].document.forms[0].max_patients_per_day.value;
			var max_patients_per_slab_cnt = frames[1].document.forms[0].max_patients_per_slab.value;

			var total_slots = parseInt(ext_start_slots) + parseInt(ext_mid_slots) + parseInt(ext_end_slots);
			

			if(total_slots > max_pat_per_day_cnt)
			{
				alert(getMessage("SLOT_START_MID_END_LESS_OR_EQUAL","OA"));
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				return false;
			}else
			{
				if(ext_start_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_mid_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_end_slots % max_patients_per_slab_cnt != 0)
				{
					alert(getMessage("SLAB_START_MID_END_EQUALLY_DIV","OA"));
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					return false;
				}
				else if(ext_mid_slots != "" && ext_mid_slots != 0)
				{
					var allowed_SME = max_pat_per_day_cnt / 3;
					allowed_SME = Math.floor(allowed_SME);
					if(ext_start_slots > allowed_SME || ext_mid_slots > allowed_SME || ext_end_slots > allowed_SME)
					{
						var error;
						error=getMessage("SLOTS_OVERLAPPING","OA");
						error=error.replace("#", allowed_SME);
						alert(error);
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
				}
			}
		}
		}
			max_pat_per_day  = frames[1].document.forms[0].max_patients_per_day.value;
			if(!allow_three)		
			{
				if(max_pat_per_day.indexOf(".")!=-1)
				{
					alert(getMessage("LOCN_TIME_SPAN_MULTIPLE","OA"));
					frames[1].document.forms[0].max_patients_per_day.value="";
					toSubmit = false;
				}else
				{
					toSubmit = true;	
				}	
			}
	}
					
	frames[1].document.forms[0].ftotstr.value = olStr ;
	max_pat_per_day  = frames[1].document.forms[0].max_patients_per_day.value;

				}
			}			

		else
			{	
				frames[1].document.forms[0].ftotstr.value = olStr ;
			}
	

	var startarray;
	var endarray;	
	var blk_startarray;
	var starttime;
	var start_appt_time;
	var blk_time;	
	var starttm;
	var endtm;
	var blk_start;
	starttime			= frames[1].document.forms[0].start_time.value ;
	start_appt_time     = frames[1].document.forms[0].start_appt_time.value ;
	var p_start_time     = frames[1].document.forms[0].p_start_time.value ;
	blk_time			= frames[1].document.forms[0].block_start_time.value;
	

	startarray= starttime.split(":") ;
	endarray = start_appt_time.split(":") ;
	blk_startarray = blk_time.split(":") ;

	starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
	endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;
	blk_start  = new Date(1,1,1,blk_startarray[0],blk_startarray[1],0,0) ;
	
	if (endtm != null)
	{
		if (Date.parse(endtm) <= Date.parse(starttm)&&toSubmit&&(p_start_time!=starttime))
		{
			
			
			var en_lt_st_tm = getMessage('APPT_EXISTS_BEFORE_ST_TIME',"OA");
			
			alert(en_lt_st_tm);
			frames[1].document.forms[0].start_time.focus();
			toSubmit = false;
		}
	}
	
	if (blk_start != null)
	{
		if (Date.parse(blk_start) <= Date.parse(starttm)&&toSubmit)
		{
			var en_lt_st_tm = getMessage('BLOCK_EXISTS_BEFORE_ST_TIME',"OA");
			alert(en_lt_st_tm);
			frames[1].document.forms[0].start_time.focus();
			toSubmit = false;
		}
	}

	var startarray;
	var endarray;
	var blk_startarray;
	var starttime;
	var start_appt_time;
	var starttm;
	var endtm;
	var blk_time;
	var blk_start;
	starttime			= frames[1].document.forms[0].end_time.value;
	start_appt_time     = frames[1].document.forms[0].end_appt_time.value;
	blk_time			= frames[1].document.forms[0].block_end_time.value;
	startarray			= starttime.split(":") ;
	endarray			= start_appt_time.split(":") ;
	blk_startarray		= blk_time.split(":") ;

	starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
	endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;
	blk_start =  new Date(1,1,1,blk_startarray[0],blk_startarray[1],0,0) ;	

	if (endtm != null)
	{
		//if (Date.parse(starttm) <= Date.parse(endtm)&&toSubmit) commented as it is not allowing to change overbooking value
		if (Date.parse(starttm) < Date.parse(endtm)&&toSubmit)
		{
			var en_lt_st_tm = getMessage('APPT_EXISTS_CANT_MDFY',"OA");
			alert(en_lt_st_tm);
			frames[1].document.forms[0].end_time.focus();
			toSubmit = false;
		}
	}
	if (blk_start != null)
	{
 	  if (Date.parse(blk_start) <= Date.parse(starttm)&&toSubmit)
		{
			var en_lt_st_tm = getMessage('BLOCK_EXISTS_AFTER_ED_TIME',"OA");
			alert(en_lt_st_tm);
			frames[1].document.forms[0].end_time.focus();
			toSubmit = false;
		}
	}
	var v1="";
	if (frames[1].document.forms[0].max_first_visit.value!="")
		v1= parseInt(frames[1].document.forms[0].max_first_visit.value);
    else
		v1 =0;
	var v2= parseInt(frames[1].document.forms[0].first_visit_cnt.value);
		if(v1 < v2 &&toSubmit)
		{
		var m_n_l_f = getMessage('MAX_NOT_LESS_FV',"OA");
		alert(m_n_l_f);
		frames[1].document.forms[0].max_first_visit.focus();
		toSubmit = false;
		}
		
	if (frames[1].document.forms[0].max_other_visits.value!="")
		v1= parseInt(frames[1].document.forms[0].max_other_visits.value);
    else
		v1 =0;
	var v2= parseInt(frames[1].document.forms[0].other_visit_cnt.value);
		if(v1 < v2 &&toSubmit)
		{
		var m_n_l_f = getMessage('MAX_NOT_LESS_OV',"OA");
		alert(m_n_l_f);
		frames[1].document.forms[0].max_first_visit.focus();
		toSubmit = false;
		}
	if (frames[1].document.forms[0].max_over_bookings.value!="")
		v1= parseInt(frames[1].document.forms[0].max_over_bookings.value);
    else
		v1 =0;
	var v2= parseInt(frames[1].document.forms[0].overbook_cnt.value)
	if(v1 < v2 )
	{
		var m_n_l_o = getMessage('MAX_NOT_LESS_OB',"OA");
		alert(m_n_l_o);
		frames[1].document.forms[0].max_over_bookings.focus();
		toSubmit = false;
		}
					    max_pat_per_day     = frames[1].document.forms[0].max_patients_per_day.value;
					var max_pat_per_slot    = frames[1].document.forms[0].b_max_slots_per_day.value;
					var visit_limit_rule    = frames[1].document.forms[0].visit_limit_rule.value;
					var slot_appt_ctrl      = frames[1].document.forms[0].slot_appt_ctrl.value;
					var b_time_table_type   = frames[1].document.forms[0].time_table_type.value;	
					



					if (visit_limit_rule!="N"){
						
					  if ( b_time_table_type!="1" || slot_appt_ctrl=="P"){						
						if (parseInt(max_first_visit) > parseInt(max_pat_per_day)){		 			
							var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.day.label","Common"));								
							alert(errors);
							toSubmit = false;
						}
					  }else if( b_time_table_type!="1" || slot_appt_ctrl=="S"){
						 if (parseInt(max_first_visit) > parseInt(max_pat_per_slot) ){							
							var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));							 
							alert(errors);
							toSubmit = false;
						 }
					  }	 
				
					}else{ //Else added by S.Sathish for IN022182 on Thursday, June 17, 2010						
							frames[1].document.forms[0].max_first_visit.value="";
							frames[1].document.forms[0].max_other_visits.value="";
					}

					var max_other_visit		= frames[1].document.forms[0].max_other_visits.value ;
					if (max_other_visit=="" )  max_other_visit="0";
					if (max_first_visit=="" )  max_first_visit="0";
					if (max_pat_per_day=="" )  max_pat_per_day="0";		
					if(toSubmit){ //condition added by S.Sathish for IN022182 on Thursday, June 17, 2010	
						if (visit_limit_rule!="N"){
						  if ( b_time_table_type!="1" || slot_appt_ctrl=="P"){
							if (parseInt(max_other_visit) > parseInt(max_pat_per_day) ){	
								var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
								errors = errors.replace("#",getLabel("Common.day.label","Common"));								
								alert(errors);
								toSubmit = false;
							}
						  }else if(b_time_table_type!="1" || slot_appt_ctrl=="S") {
							 if (parseInt(max_other_visit) > parseInt(max_pat_per_slot)){					
								var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
								errors = errors.replace("#",getLabel("Common.Slot.label","Common"));								
								alert(errors);
								toSubmit = false;
							 }
						 }
					}
					/*if(b_time_table_type=="1")
					{
						if(parseInt(max_first_visit) <=0 || parseInt(max_first_visit) =="" )
						  {
							
							var errors = getMessage("MAX_FIRST_VISIT_ZERO","OA");
                           
							alert(errors);
							toSubmit = false;
						  }
						 if(parseInt(max_other_visit) <=0)
						  {
								var errors = getMessage("MAX_FIRST_OTHER_ZERO","OA");
                          
							alert(errors);
							toSubmit = false;
						  }
					}*/
				   }				  
				if (toSubmit){
					if (visit_limit_rule=="E"){
						if (parseInt(max_first_visit) != parseInt(max_other_visit))
						{							
							alert(getMessage("FIRST_OTHER_VISIT_EXACT","OA"));
							toSubmit = false;
						}
				/*	  if ( b_time_table_type!="1" || slot_appt_ctrl=="P"){
						  
						if ((parseInt(max_first_visit)+parseInt(max_other_visit)) != parseInt(max_pat_per_day)  ){
							var errors = getMessage("SUM_MAX_OT_VI_EQ_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.day.label","Common"));
							alert(errors );
							
							toSubmit = false;
						}
					  }
					  else{ */
					  if(toSubmit){ //condition added by S.Sathish for IN022182 on Thursday, June 17, 2010
						if ( b_time_table_type=="1"){
						 if ((parseInt(max_first_visit)+parseInt(max_other_visit)) != parseInt(max_pat_per_slot)){
						
							var errors = getMessage("SUM_MAX_OT_VI_EQ_MAX_PAT_PER_DAY","OA");
							if(slot_appt_ctrl=="P")
							{
							errors = errors.replace("#",getLabel("Common.day.label","Common"));
							}else
							{
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
							}							
							alert(errors);
							toSubmit = false;
						 }
					 }else if(b_time_table_type=="2" &&((parseInt(max_first_visit)+parseInt(max_other_visit)) != parseInt(max_pat_per_day))){// @UAT-3 Starts
							var errors = getMessage("SUM_MAX_OT_VI_EQ_MAX_PAT_PER_DAY","OA");
							errors = errors.replace("#",getLabel("Common.day.label","Common"));						
							alert(errors);
							toSubmit = false;
					 }// @UAT-3 Ends
					}
				}
					else if (visit_limit_rule=="M"){
					  //if ( b_time_table_type=="1" || slot_appt_ctrl=="P"){ commented by S.Sathish bcoz this msg displayed when the time table type is freeformat
						//if ( b_time_table_type=="1" && slot_appt_ctrl=="P"){
						if ( (b_time_table_type=="1" && slot_appt_ctrl=="P") || b_time_table_type=="2"){// @UAT-3

							if ((parseInt(max_first_visit)+parseInt(max_other_visit)) < parseInt(max_pat_per_day) ){
								var errors = getMessage("SUM_MAX_OT_VI_GR_MAX_PAT_PER_DAY","OA");
								errors = errors.replace("#",getLabel("Common.day.label","Common"));
								alert(errors);
								toSubmit = false;
							}
					  }
					 // else if( b_time_table_type=="1" || slot_appt_ctrl=="S"){commented by S.Sathish bcoz this msg displayed when the time table type is freeformat
						 else if( b_time_table_type=="1" && slot_appt_ctrl=="S"){
						 if ((parseInt(max_first_visit)+parseInt(max_other_visit)) < parseInt(max_pat_per_slot)){
							var errors = getMessage("SUM_MAX_OT_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
							alert(errors);
							toSubmit = false;
						 }
					  }
					}						
				}
				if (toSubmit){
					if (visit_limit_rule!="N"){
					  if ( b_time_table_type!="1" || visit_limit_rule=="P"){
						if (parseInt(max_over_bookings) > parseInt(max_pat_per_day)){							
							var errors = getMessage("MAX_OB_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.day.label","Common"));
							alert(errors);
							toSubmit = false;
						}
					  }
					  else{
						 if (parseInt(max_over_bookings) > parseInt(max_pat_per_slot)){							
							var errors = getMessage("MAX_OB_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
							alert(errors);
							toSubmit = false;
						 }
						}
					}
				}

	// jit
	if(toSubmit){
		//frames[1].document.forms[0].max_other_visits.value


		var tType=frames[1].document.forms[0].time_table_type.value;
		var Obj=frames[1].document.forms[0].no_of_forced_booking;
		var Obj1=frames[1].document.forms[0].no_of_global_booking;

		var FBking=frames[1].document.forms[0].forced_book_YN.checked;
		if(FBking){
				if(Obj.value==''){

					var errors = getMessage("FORCED_BKG_BLANK","OA");

					
					alert ( errors);
					
					toSubmit = false;
					Obj.focus();
				}else if(Obj.value<1){
					var errors = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
					var errors1 = errors.substring(0,10);
					var errors2 = errors.substring(11,44);
					alert ( errors1  + getLabel("eOA.NoofForcedinBookingday.label","OA") +errors2);
					
					toSubmit = false;
					Obj.focus();
				}

			//}
		}
	
		if(toSubmit){
			if(tType=='1'){
				if(parseInt(Obj.value)>parseInt(frames[1].document.forms[0].max_patients_per_day.value)){
					var errors =  getMessage("FORCED_GR_MAX_PAT","OA");
					alert (errors);
					toSubmit = false
					Obj.focus();
				}
				if(toSubmit){
					if(parseInt(Obj1.value)>parseInt(frames[1].document.forms[0].max_patients_per_day.value)){
						var errors = getMessage("GLOBAL_GR_MAX_PAT","OA");
						alert (errors);
						toSubmit = false;
						Obj1.focus();
					}
				}
			}else if(tType=='2'){
				
				
				l_max_pat_per_slot=(frames[1].document.forms[0].max_patients_per_day.value)/(frames[1].document.forms[0].max_patients_per_slab.value);
				
				if(parseInt(Obj.value)>parseInt(l_max_pat_per_slot))
					{
					var errors = getMessage("FORCED_GR_MAX_SLAB","OA");
					alert (errors);
					
					toSubmit = false;
					Obj.focus();
				}
				if(toSubmit){
					if(parseInt(Obj1.value)>parseInt(frames[1].document.forms[0].max_patients_per_day.value)){
						
						var errors = getMessage("GLOBAL_GR_MAX_PAT","OA");
						alert (errors);
						
						toSubmit = false;
						Obj1.focus();
					}
				}
			}else{
				//if(nam=='no_of_global_booking'){
					if(parseInt(Obj1.value)>parseInt(frames[1].document.forms[0].max_patients_per_day.value)){
						
						var errors =getMessage("GLOBAL_GR_MAX_PAT","OA");
						alert (errors);
						
						toSubmit = false;
						Obj1.focus();
					}
				//}
			}
		}
	}
	
    if( toSubmit)
	{
		if(frames[1].document.forms[0].fmode.value == 'modify' && frames[1].document.forms[0].alcn_criteria.value != '' && (frames[1].document.forms[0].old_max_patients_per_day.value != frames[1].document.forms[0].max_patients_per_day.value ) )
			
		{
			
			var diff = eval(frames[1].document.forms[0].old_max_patients_per_day.value) - eval(frames[1].document.forms[0].max_patients_per_day.value);
			var incdec = getLabel("eOA.Increased.label","OA");
			if(diff > 0) incdec = getLabel("Common.Decreased.label","Common");
			else diff = eval(frames[1].document.forms[0].max_patients_per_day.value) - eval(frames[1].document.forms[0].old_max_patients_per_day.value);
			var facilityid  = frames[1].document.forms[0].facility_id.value;
			var cliniccode = frames[1].document.forms[0].location.value;
			var date = frames[1].document.forms[0].clinic_date.value;
			var practitionerid = frames[1].document.forms[0].practitioner.value;
			var alcncriteria = frames[1].document.forms[0].alcn_criteria.value;
			var allocation_changed = frames[1].document.forms[0].allocation_changed.value;
			var final_string = frames[1].document.forms[0].final_string.value;
			var max_patients_per_day = frames[1].document.forms[0].max_patients_per_day.value;
			var max_patients1 = frames[1].document.forms[0].max_patients1.value;
			var allocation_changed = frames[1].document.forms[0].allocation_changed.value;
			var alcn_criteria = frames[1].document.forms[0].alcn_criteria.value;

			var slots = diff 
			var features	= "dialogHeight:20; dialogWidth:32; scroll=no; status:no"; 
            if (allocation_changed=="N"&&alcn_criteria!="")
            {
			var params = "facility_id="+facilityid+"&location_code="+cliniccode+"&clinic_date="+date+"&practitioner_id="+practitionerid+"&slots_inc_dec="+slots+"&alcn_criteria="+alcncriteria+"&final_string="+final_string+"&allocation_changed="+allocation_changed+"&max_patients_per_day="+max_patients_per_day+"&inc_dec="+incdec+"&from=DS"; 
			var retVal = await window.showModalDialog("../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?"+params,arguments,features);
			if(retVal != null && retVal != '' && retVal != 'F')
			{
				
				frames[1].document.forms[0].insert_detail.value = 'Y';
				frames[1].document.forms[0].final_values.value = retVal;
				frames[1].document.forms[0].max_patients_per_day.readOnly 	= false;
				frames[1].document.forms[0].max_patients_per_day.disabled 	= false;
				frames[1].document.forms[0].b_max_slots_per_day.disabled	=false;	
				f_query_add_mod.document.forms[0].action="../../servlet/eOA.SetUpDailyScheduleServlet";
				f_query_add_mod.document.forms[0].target="messageFrame";				
				frames[1].document.forms[0].submit();
			}
			else
			{
				var err1 = getMessage("SLOTS_MISMATCH","OA");
				 err1 = err1.replace('$',incdec);
				alert(err1);
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			}
			}
			else if (allocation_changed=="Y" && max_patients1!=max_patients_per_day&&final_string!="")
			{
				var params = "facility_id="+facilityid+"&location_code="+cliniccode+"&clinic_date="+date+"&practitioner_id="+practitionerid+"&slots_inc_dec="+slots+"&alcn_criteria="+alcncriteria+"&final_string="+final_string+"&allocation_changed="+allocation_changed+"&max_patients_per_day="+max_patients1+"&inc_dec="+incdec+"&from=DS"; 
				var retVal =await  window.showModalDialog("../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?"+params,arguments,features);
			if(retVal != null && retVal != '' && retVal != 'F')
				
			{
				frames[1].document.forms[0].insert_detail.value = 'Y';
				frames[1].document.forms[0].final_values.value = retVal;
				frames[1].document.forms[0].max_patients_per_day.readOnly 	= false;
				frames[1].document.forms[0].max_patients_per_day.disabled 	= false;
				frames[1].document.forms[0].b_max_slots_per_day.disabled		=false;
				f_query_add_mod.document.forms[0].action="../../servlet/eOA.SetUpDailyScheduleServlet";
				f_query_add_mod.document.forms[0].target="messageFrame";
				frames[1].document.forms[0].submit();
			}
			else
			{
				var err2 = getMessage("SLOTS_MISMATCH","OA");
				 err2 = err2.replace('$',incdec);
				alert(err2);
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			}
          
			}
            else{
			frames[1].document.forms[0].max_patients_per_day.readOnly 	= false;
			frames[1].document.forms[0].max_patients_per_day.disabled 	= false;
			frames[1].document.forms[0].b_max_slots_per_day.disabled		=false;
				if(frames[1].document.forms[0].resourceType.disabled)
				frames[1].document.forms[0].resourceType.disabled=false;
			if(frames[1].document.forms[0].time_table_type.disabled)
				frames[1].document.forms[0].time_table_type.disabled=false;
			f_query_add_mod.document.forms[0].action="../../servlet/eOA.SetUpDailyScheduleServlet";
			f_query_add_mod.document.forms[0].target="messageFrame";
			frames[1].document.forms[0].submit();
			}
		

		}
		else if(frames[1].document.forms[0].fmode.value == 'insert')
		{
			frames[1].document.forms[0].max_patients_per_day.readOnly 	= false;
			frames[1].document.forms[0].max_patients_per_day.disabled 	= false;
			frames[1].document.forms[0].b_max_slots_per_day.disabled		=false;

				if(frames[1].document.forms[0].resourceType.disabled)
				frames[1].document.forms[0].resourceType.disabled=false;
			if(frames[1].document.forms[0].time_table_type.disabled)
				frames[1].document.forms[0].time_table_type.disabled=false;
			
				var fin_sting=	frames[1].document.forms[0].final_string.value;
				var facility_id=frames[1].document.forms[0].facility_id.value;
				var max_patients=frames[1].document.forms[0].max_patients_per_day.value;
				
				var Obj4=frames[1].document.forms[0].clinic_date;
				var Obj5=frames[1].document.forms[0].location;
				var Obj6=frames[1].document.forms[0].practitioner;

				cln_dt=convertDate(Obj4.value,"DMY",frames[1].document.forms[0].locale.value,"en");//Added by Rameswar on 20-Nov-15 for Leap Year Issue
				//cln_dt=Obj4.value;

				var val5  = new Array() ;
				val5 = Obj5.value.split("$");
				var cln_cd=val5[0].split("$");

				var val6  = new Array() ;
				val6 = Obj6.value.split("$");
				var practitioner=val6[0].split("$");	
							var max_new_patients=0;
							var max_old_patients=0;
							if(frames[1].document.forms[0].rule_appl_yn.value =='Y'){
								max_new_patients = frames[1].document.forms[0].max_new_patients.value;
								max_old_patients = frames[1].document.forms[0].max_old_patients.value;
							}
							var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='checkMaxPatient' id='checkMaxPatient' method='post' action='../../eOA/jsp/ClinicAllocationChkMaxPat.jsp'><input type='hidden' name='cln_dt' id='cln_dt' value='"+cln_dt+"'><input type='hidden' name='cln_cd' id='cln_cd' value='"+cln_cd+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='resourceType' id='resourceType' value='"+resourceType+"'><input type='hidden' name='practitioner' id='practitioner' value='"+practitioner+"'><input type='hidden' name='fin_string' id='fin_string' value='"+fin_sting+"'><input type='hidden' name='max_patient' id='max_patient' value='"+max_patients+"'><input type='hidden' name='calling_from' id='calling_from' value='day_schedule'><input type='hidden' name='caller' id='caller' value='Y'><input type='hidden' name='start_time' id='start_time' value='"+frames[1].document.forms[0].start_time.value+"'><input type='hidden' name='end_time' id='end_time' value='"+frames[1].document.forms[0].end_time.value+"'><input type='hidden' name='max_new_patients' id='max_new_patients' value='"+max_new_patients+"'><input type='hidden' name='max_old_patients' id='max_old_patients' value='"+max_old_patients+"'><input type='hidden' name='mode' id='mode' value='insert'><input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='"+frames[1].document.forms[0].rule_appl_yn.value+"'></form></body></html>";
							
				messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				f_query_add_mod.document.forms[0].action="../../servlet/eOA.SetUpDailyScheduleServlet";
				f_query_add_mod.document.forms[0].target="messageFrame";				
				frames[2].document.checkMaxPatient.submit();
				
		}else{
			var fin_sting=	frames[1].document.forms[0].final_string.value;
			var facility_id=frames[1].document.forms[0].facility_id.value;
			var max_patients=frames[1].document.forms[0].max_patients_per_day.value;

			var Obj4=frames[1].document.forms[0].clinic_date;
			var Obj5=frames[1].document.forms[0].location;
			var Obj6=frames[1].document.forms[0].practitioner;

			//cln_dt=Obj4.value;
			cln_dt=convertDate(Obj4.value,"DMY",frames[1].document.forms[0].locale.value,"en");//Added by Rameswar on 20-Nov-15 for Leap Year Issue
			var val5  = new Array() ;
			val5 = Obj5.value.split("$");
			var cln_cd=val5[0].split("$");

			var val6  = new Array() ;
			val6 = Obj6.value.split("$");
			var practitioner=val6[0].split("$");
							var max_new_patients=0;
							var max_old_patients=0;
							if(frames[1].document.forms[0].rule_appl_yn.value =='Y'){
								max_new_patients = frames[1].document.forms[0].max_new_patients.value;
								max_old_patients = frames[1].document.forms[0].max_old_patients.value;
							}			

			var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='checkMaxPatient' id='checkMaxPatient' method='post' action='../../eOA/jsp/ClinicAllocationChkMaxPat.jsp'><input type='hidden' name='cln_dt' id='cln_dt' value='"+cln_dt+"'><input type='hidden' name='cln_cd' id='cln_cd' value='"+cln_cd+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='resourceType' id='resourceType' value='"+resourceType+"'><input type='hidden' name='practitioner' id='practitioner' value='"+practitioner+"'><input type='hidden' name='fin_string' id='fin_string' value='"+fin_sting+"'><input type='hidden' name='max_patient' id='max_patient' value='"+max_patients+"'><input type='hidden' name='calling_from' id='calling_from' value='day_schedule''><input type='hidden' name='caller' id='caller' value='Y''><input type='hidden' name='start_time' id='start_time' value='"+frames[1].document.forms[0].start_time.value+"'><input type='hidden' name='end_time' id='end_time' value='"+frames[1].document.forms[0].end_time.value+"'><input type='hidden' name='mode' id='mode' value='"+frames[1].document.forms[0].fmode.value+"'><input type='hidden' name='max_new_patients' id='max_new_patients' value='"+max_new_patients+"'><input type='hidden' name='max_old_patients' id='max_old_patients' value='"+max_old_patients+"'><input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='"+frames[1].document.forms[0].rule_appl_yn.value+"'></form></body></html>";
			
			messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			f_query_add_mod.document.forms[0].action="../../servlet/eOA.SetUpDailyScheduleServlet";
			f_query_add_mod.document.forms[0].target="messageFrame";			
			frames[2].document.checkMaxPatient.submit();
			/*frames[1].document.forms[0].max_patients_per_day.readOnly 	= false;
			frames[1].document.forms[0].max_patients_per_day.disabled 	= false;
			frames[1].document.forms[0].b_max_slots_per_day.disabled		=false;	
			frames[1].document.forms[0].submit();*/

		}
	}
 else
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;

	}
}
	else
	{

      if (toSubmit)
		alert(getMessage('INVALID_BREAK_TIME',"OA"));
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	  
	}
}
	}
}
else
	commontoolbarFrame.document.location.reload();

}

function reset()
{
	var FBking=frames[1].document.forms[0].forced_book_YN;
	//frames[1].document.forms[0].reset();
	frames[1].document.location.reload();
	if(frames[1].document.forms[0].function_mode)
	{
	if (frames[1].document.forms[0].function_mode.value!="modify"){
	frames[1].document.getElementById("t_per_pat").style.visibility='hidden'
	frames[1].document.getElementById("mx_pat_per_day").style.visibility='hidden'

	frames[1].document.getElementById("t_per_slab").style.visibility='hidden'
	frames[1].document.getElementById("mx_per_slab").style.visibility='hidden'
	frames[1].document.getElementById("slot_or_pat_id1").innerText ="           ";
	//frames[1].document.getElementById("slot_or_pat_id2").innerText = "           ";
	//frames[1].document.getElementById("slot_or_pat_id3").innerText = "           ";
	frames[1].document.forms[0].search_pract.disabled=true;
	frames[1].document.forms[0].practitioner_name.disabled=true;
	frames[1].document.forms[0].forced_book_YN.disabled=true;
	frames[1].document.forms[0].no_of_forced_booking.disabled=true;
	//frames[1].document.forms[0].location.focus();
	frames[1].document.getElementById("imgpract").style.visibility='hidden';

	frames[1].document.getElementById("resourceType").disabled=true;

	/*var lBox=
	frames[1].document.forms[0].location; 
	var len=frames[1].document.forms[0].location.options.length;

    lBox.remove(lBox.options[0]);
    var opt=frames[1].document.createElement('OPTION');
    
	i=0;
    while(i<= len){
		lBox.remove(lBox.options[i]);
		i+=1;
	}
	opt.value='';
    opt.text=" ----------------------"+getLabel("Common.defaultSelect.label","Common")+"---------------------- ";
	lBox.add(opt);*/
	frames[1].document.forms[0].location.value="";
	}
	}
	if(frames[1].document.forms[0].name!='query_form' ){
		if(frames[1].document.forms[0].start_time)
		{
		frames[1].document.forms[0].start_time.focus();
		}
		if(frames[1].document.forms[0].no_of_forced_booking)
		{
		frames[1].document.forms[0].no_of_forced_booking.disabled=true;
		}
		if(frames[1].document.forms[0].no_of_global_booking)
		{
		if(frames[1].document.forms[0].no_of_global_booking.value=='0')
		{
		frames[1].document.forms[0].no_of_global_booking.value='';
		}
		}
	}
	
}

function onSuccess()
{
	if(frames[1].document.forms[0].fmode.value=='insert'){
		frames[1].document.location.href='../../eOA/jsp/SetUpDailyScheduleHeader.jsp'
	} else if(frames[1].document.forms[0].fmode.value=='delete') {
		frames[1].document.location.href = '../../eCommon/html/blank.html';
	} else {
		frames[1].document.location.reload();		
		frames[1].document.forms[0].clinic_date.value="";
	}
}

/*function populatePractitioner(Obj,Obj1)
{
	var val   = new Array() ;

	val = Obj.value.split("$");
    if (val !="")
    {
	parent.frames[1].document.getElementById("search_pract").disabled=false;
	parent.frames[1].document.getElementById("practitioner_name").disabled=false;
	var clinic_code=val[0].split("$");
	var clinic_type=val[1].split("$");
	var open_to_all_pract_yn= val[2].split("$");
	var ident_at_checkin= val[3].split("$");
	var fi_visit_type_appl_yn= val[4].split("$");
	if (ident_at_checkin=="P")
		parent.frames[1].document.getElementById("practMandatory").style.visibility='visible';
	else
		parent.frames[1].document.getElementById("practMandatory").style.visibility='hidden';
	}
	else
	{
	parent.frames[1].document.getElementById("practMandatory").style.visibility='hidden';
	parent.frames[1].document.getElementById("search_pract").disabled=true;
	parent.frames[1].document.getElementById("practitioner_name").disabled=true;
	//parent.frames[1].document.getElementById("loc").innerText="";
	var clinic_code="";
	var clinic_type="";
	var open_to_all_pract_yn= "";
	var ident_at_checkin="";
	var fi_visit_type_appl_yn= "";

	}


	if (clinic_code != null && clinic_code != "")
	{

		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='populatepract' id='populatepract' method='post' action='../../eOA/jsp/SetupDailySchedulePract.jsp'><input type='hidden' name='clinic_type' id='clinic_type' value='"+clinic_type+"'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'><input type='hidden' name='param' id='param' value='ForPract'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.populatepract.submit();
	}
	else
		document.forms[0].alcn_criteria.value = '';

	if( fi_visit_type_appl_yn == 'Y')
		parent.frames[1].document.forms[0].max_first_visit.readOnly=false;
	else
		parent.frames[1].document.forms[0].max_first_visit.readOnly=true;	
	

}*/

function clear_list(obj) 
{
//   if( obj.options.length >1)
  //  {
	    while(obj.options.length > 0) {
		    obj.remove(obj.options[0]);
	    }
   // }
  }

function PractManipulate(Obj3)
{
	var val2  = new Array() ;
	val2 = Obj3.value.split("$");
	
	var pract_code=val2[0].split("$");
	var L_fi_visit_type_appl_yn=val2[1].split("$");
	
	if( L_fi_visit_type_appl_yn == 'Y')
		parent.frames[1].document.forms[0].max_first_visit.readOnly=false;
	else
	if( L_fi_visit_type_appl_yn == 'N')
		parent.frames[1].document.forms[0].max_first_visit.readOnly=true;
}

function validateClinicDate(Obj4,Obj5,Obj6)
{


    if(Obj4!=""){
		
		
	if(!validDateObj(Obj4,"DMY",localeName))
		{
			Obj4.value="";
			return ;
		}
			
		from = parent.frames[1].document.forms[0].clinic_date;
		to = parent.frames[1].document.forms[0].CurrentDate;
			
		var fromarray;
		var toarray;

	var obj1=convertDate(from.value,"DMY",localeName,"en");


	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(to.value,obj1,'DMY','en')==false) /*localeName is changed to en by Rameswar on 03-Nov-15 for Leap Year Issue*/
				{
				var invaldt = parent.parent.frames[0].getMessage("NOSHOW_FM_DT_VALIDATION","OA") ;
					alert(invaldt)
					from.value="";
					from.focus();
					from.select();
					return false ;
			}
			else
				return true;
		}


			
			var val5  = new Array() ;
			val5 = Obj5.value.split("$");
			var clinic_code=val5[0].split("$");
			
			var val6  = new Array() ;
			val6 = Obj6.value.split("$");
			var pract_id=val6[0].split("$");	
			
			var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dateCheck' id='dateCheck' method='post' action='../../eOA/jsp/SetupDailySchedulePract.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='clinic_date' id='clinic_date' value='"+obj1+"'><input type='hidden' name='Practitioner_id' id='Practitioner_id' value='"+pract_id+"'><input type='hidden' name='param' id='param' value='ForDate'></form></body></html>";
			//parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.messageFrame.document.dateCheck.submit();
    }


	starttime =parent.frames[1].document.forms[0].start_time.value ;
	
	startarray = starttime.split(":") ;
	starttime[0] = parseInt(starttime[0])-1
	starttime[0] = parseInt(starttime[1])-1
	startdt = parent.frames[1].document.forms[0].clinic_date.value;
	startdt = startdt.split("/")
	//startdt[1] =startdt[1]-1
	starttm = new Date(startdt[2],startdt[1],startdt[0],startarray[0],startarray[1],0,0)
		

	Current_Date = parent.frames[1].document.forms[0].CurrentDatetm.value.split(" ") ;
	startarray = Current_Date[1].split(":") ;
	startdt = Current_Date[0].split("/")
	
	//startdt[1] = parseInt(startdt[1])-1
	starttime[0] = parseInt(starttime[0])-1
	starttime[1] = parseInt(starttime[1])-1
	Current_Date=new Date(startdt[2],startdt[1],startdt[0],startarray[0],startarray[1],0,0)
	
	if(Date.parse(starttm)<Date.parse(Current_Date))
	{
		
		alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
		parent.frames[1].document.forms[0].start_time.value="";	
		parent.frames[1].document.forms[0].start_time.focus();
	}
	

}

function timetableType(Obj6){

	if( Obj6.value == ''){
		parent.frames[1].document.forms[0].no_of_global_booking.disabled=true;
	}else{
		parent.frames[1].document.forms[0].no_of_global_booking.disabled=false;
	}

	//if( Obj6.value == '' || Obj6.value == '3'){
		parent.frames[1].document.forms[0].no_of_forced_booking.disabled=true;
		parent.frames[1].document.forms[0].no_of_forced_booking.value='';
		parent.frames[1].document.forms[0].forced_book_YN.checked=false;
		parent.frames[1].document.forms[0].no_of_global_booking.value='';
	//}


	parent.frames[1].document.getElementById("slot_or_pat_id1").innerText ="           ";
	//parent.frames[1].document.getElementById("slot_or_pat_id2").innerText = "           ";
	//parent.frames[1].document.getElementById("slot_or_pat_id3").innerText = "           ";

	var val= parent.frames[1].document.forms[0].location.value;
	//have to change here also by sudha
	/*while(val.indexOf("null")!=-1){
	val=val.replace("null","");
	
	}*/
	var arr=val.split('$');
	
	parent.frames[1].document.forms[0].start_time.value=arr[6];
	parent.frames[1].document.forms[0].end_time.value=arr[7];
	parent.frames[1].document.forms[0].p_start_time.value=arr[6];
	parent.frames[1].document.forms[0].p_end_time.value=arr[7];
	parent.frames[1].document.forms[0].hddDur.value=arr[8];

	parent.frames[1].document.forms[0].b_max_slots_per_day.value='';
	parent.frames[1].document.forms[0].max_patients_per_day.value='';


	if( Obj6.value == '1'){
		parent.frames[1].document.forms[0].time_per_patient.readOnly=false;
		parent.frames[1].document.forms[0].max_patients_per_day.readOnly=false;
		
		parent.frames[1].document.forms[0].time_per_slab.value='';
		parent.frames[1].document.forms[0].max_patients_per_slab.value='';
		parent.frames[1].document.forms[0].time_per_slab.readOnly=true;
		parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=true;	
		var slot_appt_ctrl = parent.frames[1].document.forms[0].slot_appt_ctrl.value;
		if (slot_appt_ctrl=="S"){
		    parent.frames[1].document.getElementById("time_per_pat").innerText=getLabel("eOA.TimeperSlot.label","OA");
			//"Time per Slot ";
			parent.frames[1].document.getElementById("slot_or_pat_id1").innerText = getLabel("Common.Slot.label","Common");
			//parent.frames[1].document.getElementById("slot_or_pat_id2").innerText = "(Slots) ";
			//parent.frames[1].document.getElementById("slot_or_pat_id3").innerText = "(Slots) ";
		}else{
		    parent.frames[1].document.getElementById("time_per_pat").innerText=getLabel("eOA.TimeperPatient.label","OA");
			//"Time per Patient ";
			parent.frames[1].document.getElementById("slot_or_pat_id1").innerText = getLabel("Common.patient.label","Common");
			//parent.frames[1].document.getElementById("slot_or_pat_id2").innerText = "(Patients) ";
			//parent.frames[1].document.getElementById("slot_or_pat_id3").innerText = "(Patients) ";
		}

		parent.frames[1].document.forms[0].time_per_patient.value=arr[8];

		TimePerPatientValid(parent.frames[1].document.forms[0].time_per_patient)

	}else if( Obj6.value == '2'){
		parent.frames[1].document.getElementById("time_per_pat").innerText=getLabel("eOA.TimeperPatient.label","OA");
		parent.frames[1].document.forms[0].time_per_slab.readOnly=false;
		parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=false;
		
		parent.frames[1].document.forms[0].time_per_patient.value='';
		parent.frames[1].document.forms[0].max_patients_per_day.value='';
		parent.frames[1].document.forms[0].time_per_patient.readOnly=true;
		parent.frames[1].document.forms[0].max_patients_per_day.readOnly=true;
		


		parent.frames[1].document.forms[0].time_per_slab.value=arr[8];



	}else if( Obj6.value == '3'){
		if (parent.frames[1].document.forms[0].max_patients_per_day.disabled){
			parent.frames[1].document.forms[0].max_patients_per_day.disabled=false;
		}
	    parent.frames[1].document.getElementById("time_per_pat").innerText=getLabel("eOA.TimeperPatient.label","OA");
		parent.frames[1].document.forms[0].time_per_slab.readOnly=false;
		parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=false;
		parent.frames[1].document.forms[0].time_per_patient.readOnly=false;
		parent.frames[1].document.forms[0].max_patients_per_day.readOnly=false;
		
		
		parent.frames[1].document.forms[0].time_per_patient.readOnly=true;
		parent.frames[1].document.forms[0].time_per_slab.readOnly=true;
		parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=true;
		
		parent.frames[1].document.forms[0].time_per_patient.value='';
		parent.frames[1].document.forms[0].time_per_slab.value='';
		parent.frames[1].document.forms[0].max_patients_per_slab.value='';

	}else{
		parent.frames[1].document.forms[0].time_per_patient.readOnly=false;
		parent.frames[1].document.forms[0].time_per_slab.readOnly=false;
		parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=false;	
		parent.frames[1].document.forms[0].max_patients_per_day.readOnly=false;

		parent.frames[1].document.forms[0].start_time.value='';
		parent.frames[1].document.forms[0].end_time.value='';
		parent.frames[1].document.forms[0].p_start_time.value='';
		parent.frames[1].document.forms[0].p_end_time.value='';
		parent.frames[1].document.forms[0].hddDur.value='';

	}

}


function CheckTime(obj,fld) {
	var type = parent.frames[1].document.forms[0].time_table_type.value;
	var timefield 	= obj;
	if(fld == 'E'){
	var function_mode =parent.frames[1].document.forms[0].function_mode.value;
	if (function_mode!="modify"){
		if(parent.frames[1].document.forms[0].start_time.value != parent.frames[1].document.forms[0].p_start_time.value || parent.frames[1].document.forms[0].end_time.value != parent.frames[1].document.forms[0].p_end_time.value){
			parent.frames[1].document.forms[0].time_per_patient.value='';
			parent.frames[1].document.forms[0].max_patients_per_day.value='';
			parent.frames[1].document.forms[0].time_per_slab.value='';
			parent.frames[1].document.forms[0].max_patients_per_slab.value='';
		}
	}
       var sttime= parent.frames[1].document.forms[0].start_time.value;
       var edtime= parent.frames[1].document.forms[0].end_time.value;


		var fromarray= sttime.split(":") ;
		var toarray  = edtime.split(":") ;

		var fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		var totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;


		if(fromtime >= totime)
		{
			var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OA");
			status1 = 'Y' ;
			alert(errors);
			obj.focus();
		}

	}
	if (obj.value!="")
	{
		if (chkTime(obj.value) == false || checkColon(obj.value)==false) {		
			var errors = getMessage("INVALID_TIME_FMT",'SM');
			alert(errors);
			obj.value="";
			obj.focus();
			return false;
		}
		else
			return true;
	}
}


function tmchk(obj1)
{
	var strTime;
	var strHr;
	var strMi;

	var timefield = obj1;

	var strTimeArray = new Array();

	strTime = timefield.value;
	if (strTime.length == 0)
	{
		return true;
	}

	if(strTime.length != 5)
		return false;

	strTimeArray = strTime.split(":");
	if (strTimeArray.length != 2) {
	return false;
	}
	else {
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
	}

	if (strHr.length > 2) {
		return false;
	}
	if (strMi.length > 2) {
		return false;
	}

	if (isNaN(strHr) == true){
		return false;
	}
	if (isNaN(strMi) == true){
		return false;
	}

	if (strHr < 0 || strHr > 23){
		return false;
	}

	if (strMi < 0 || strMi > 59){
		return false;
	}

}



function StEdTimeCheck(obj,timemode)
{
	var startarray ;
	var endarray   ;
	var starttime  ;
	var endtime    ;
	var starttm    ;
	var endtm       ;
	var time_table_type  = parent.frames[1].document.forms[0].time_table_type.value ;
	var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK',"Common") ;

 if (timemode == 'E')
	{

	if (parent.frames[1].document.forms[0].end_time.value.length == 2)
	{
		if (parent.frames[1].document.forms[0].end_time.value.substring(1,2) == ':')
		{
			parent.frames[1].document.forms[0].end_time.value = '0' + parent.frames[1].document.forms[0].end_time.value ;
		}

	}

	if (parent.frames[1].document.forms[0].end_time.value.length == 3)
	{
		if (parent.frames[1].document.forms[0].end_time.value.substring(0,1) == ':')
		{
			parent.frames[1].document.forms[0].end_time.value = '00' + parent.frames[1].document.forms[0].end_time.value ;
		}

	}

	if (parent.frames[1].document.forms[0].end_time.value.length == 5)
	{
		endtime     = obj.value ;
		starttime    = parent.frames[1].document.forms[0].start_time.value ;

		startarray = starttime.split(":") ;
		endarray   = endtime.split(":") ;

		starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
		endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;

			if (starttime != null)
			{
				if (Date.parse(endtm) <= Date.parse(starttm))
				{
					parent.frames[1].document.forms[0].end_time.focus();
					parent.frames[1].document.forms[0].end_time.select() ;
					bol = false
					var en_lt_st_tm = getMessage('ED_TIME_LESS_EQL_ST_TIME',"OA");

					parent.frames[1].document.forms[0].end_time.value='';
					parent.frames[1].document.forms[0].end_time.select() ;
					parent.frames[1].document.forms[0].end_time.focus();
					
				}
			}
		}
	}
	
	
 if (timemode == 'S')
	{
	
	if (parent.frames[1].document.forms[0].start_time.value.length == 2)
	{
		if (parent.frames[1].document.forms[0].start_time.value.substring(1,2) == ':')
		{
			parent.frames[1].document.forms[0].start_time.value = '0' + parent.frames[1].document.forms[0].start_time.value ;
		}

	}

	if (parent.frames[1].document.forms[0].start_time.value.length == 3)
	{
		if (parent.frames[1].document.forms[0].start_time.value.substring(0,1) == ':')
		{
			parent.frames[1].document.forms[0].start_time.value = '00' + parent.frames[1].document.forms[0].start_time.value ;
		}
	}

	if (parent.frames[1].document.forms[0].start_time.value.length == 5)
	{
		starttime   = obj.value ;
		endtime    = parent.frames[1].document.forms[0].end_time.value ;

		startarray = starttime.split(":") ;
		endarray   = endtime.split(":") ;

		starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
		endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;
		
		
		
			if (starttime != null)
			{
				if (Date.parse(endtm) <= Date.parse(starttm))
				{
					parent.frames[1].document.forms[0].end_time.focus();
					parent.frames[1].document.forms[0].end_time.select() ;
					var en_lt_st_tm = getMessage('ED_TIME_LESS_EQL_ST_TIME',"OA");
					alert(en_lt_st_tm);
					parent.frames[1].document.forms[0].end_time.value='';
					parent.frames[1].document.forms[0].end_time.select() ;
					parent.frames[1].document.forms[0].end_time.focus();
					return false;
				}
			}
		}
	}
}

var temp = true;

function chkStartTime(Obj){
	var mode=parent.frames[1].document.forms[0].function_mode.value ;
	

	/*if( CheckTime(Obj,'S'))		
			clearMaxFirstVisit(Obj)*/
		starttime =parent.frames[1].document.forms[0].start_time.value ;
		
		
		var fromarray= starttime.split(":") ;
		var startval = parent.frames[1].document.forms[0].clinic_date.value;
		var currtval =  parent.frames[1].document.forms[0].CurrentDate.value;
		Current_Date = parent.frames[1].document.forms[0].CurrentDatetm.value.split(" ") ;
		startarray = Current_Date[1].split(":") ;
		var fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		var cutime   = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
		

/*if (doDateCheckAlert(parent.frames[1].document.forms[0].clinic_date.value,parent.frames[1].document.forms[0].CurrentDate.value))
	{*/

	var obj1=parent.frames[1].document.forms[0].clinic_date.value;
		var sysdate=parent.frames[1].document.forms[0].CurrentDate.value;
		var obj2=convertDate(obj1,"DMY",localeName,"en");
		if(isBefore(obj2,sysdate,'DMY',localeName)==true)
		{
	if(fromtime < cutime)
	{
		var msg=getMessage("ST_TM_LESS_SY_TM","OA");
			var pos=msg.indexOf("T");
			msg=msg.substring(0,pos) + "Start" + msg.substring(pos+2);
			alert(msg);
			parent.frames[1].document.forms[0].start_time.value="";	
			parent.frames[1].document.forms[0].start_time.focus();
	}
	
	}


	
	
if(CheckTime(Obj,'S'))
	validate_frm_tm(Obj)
	
}
/*function doDateCheckAlert(from,to) {
	var fromarray; var toarray;
	var fromdate = from ;
	var todate = to ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			fromarray[1]=fromarray[1]-1;
			toarray[1]=toarray[1]-1;

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) { return true; } 
			
			
	}
}*/


//////////////////// Time Per Patient Validity

function TimePerPatientValid(obj)
{
	if( temp)
	{
	var function_mode =parent.frames[1].document.forms[0].function_mode.value;
	var time_table_type  	= parent.frames[1].document.forms[0].time_table_type.value ;
	if (function_mode!="modify"){
	if (time_table_type  == "1")
		parent.frames[1].document.forms[0].max_patients_per_day.value='';
		

	var tm = obj;
	if(CheckTime(obj)){
		if(chkTime(parent.frames[1].document.forms[0].end_time.value)==true){
	
	var time_per_patient 	= parent.frames[1].document.forms[0].time_per_patient.value ;
	var start_time	     	= parent.frames[1].document.forms[0].start_time.value ;
	var end_time	     	= parent.frames[1].document.forms[0].end_time.value ;
	var dummytime 		= '00:00' ;
	var dummyarray		;

	var l_total_time	;
	var l_time_per_patient	;
	var l_max_pat	 	;
	var l_max_pat_category	= "1";

	var tpparray 		;
	var endarray		;
	var tpptime		;
	var endtime		;
	var startarray		;
	var starttime		;
	dummyarray 		= dummytime.split(":") ;
	dumtime    		= new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

	tpparray		= time_per_patient.split(":") ;
	endarray		= end_time.split(":") ;
	startarray		= start_time.split(":") ;

	tpptime			= new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;
	endtime			= new Date(1,1,1,endarray[0],endarray[1],0,0) ;
	starttime		= new Date(1,1,1,startarray[0],startarray[1],0,0) ;

	if (time_table_type  == "1")
	{
		if (time_per_patient.length != 0)
		{
			if ((time_per_patient <= "0") || (Date.parse(tpptime) > Date.parse(endtime)))
			{
					var invalid_tpp	     = getMessage('INVALID_TM_PR_PAT',"OA") ;
					parent.frames[1].document.forms[0].time_per_patient.focus();
					alert(invalid_tpp) ;
					parent.frames[1].document.forms[0].time_per_patient.focus();
					parent.frames[1].document.forms[0].time_per_patient.select();
			
			}
			else if ((tpptime - dumtime) > (endtime - starttime))
			{	
				
				var invalid_mtpp	     = getMessage('INVALID_MAX_PR_PAT',"OA") ;
				
					alert(invalid_mtpp) ;
					if(parent.frames[1].document.forms[0].function_mode.value!="modify"){
					parent.frames[1].document.forms[0].time_per_patient.focus();
					parent.frames[1].document.forms[0].time_per_patient.select();
					
					}
					else
				{
						parent.frames[1].document.forms[0].end_time.focus();
						parent.frames[1].document.forms[0].end_time.select();
				}

			}
			else if ((start_time.length != 0) && (end_time.length !=0) && (time_per_patient.length != 0))
				{
				
				var x=parent.frames[1].document.forms[0].time_per_patient.value;
				var y=parent.frames[1].document.forms[0].hddDur.value;

				var arr1=x.split(":");
				var arr2=y.split(":");
				

				//var dur=parseInt('10');
				var dur=(parseInt(arr2[0])*60) + parseInt(arr2[1]);
				var indur=(parseInt(arr1[0])*60) + parseInt(arr1[1]);
				var modu=indur % dur;
				
			
				
				if(modu>0){
					var error=getMessage("TIME_DEFAULT_DURATION","OA");
					alert(error +y);
					parent.frames[1].document.forms[0].time_per_patient.value=y;
				}else{
					var function_mode = parent.frames[1].document.forms[0].function_mode.value;
					if (function_mode!="modify"){
							var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='maxPatients' id='maxPatients' method='post' action='../../eOA/jsp/SetUpDailyScheduleMaxPatients.jsp'><input type='hidden' name='starttime' id='starttime' value='"+start_time+"'><input type='hidden' name='endtime' id='endtime' value='"+end_time+"'><input type='hidden' name='timeperpatient' id='timeperpatient' value='"+time_per_patient+"'><input type='hidden' name='maxpatcat' id='maxpatcat' value='"+l_max_pat_category+"'><input type='hidden' name='normal_yn' id='normal_yn' value='Y'></form></body></html>";
							parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
							parent.messageFrame.document.maxPatients.submit();
							if (parent.frames[1].document.forms[0].slot_appt_ctrl.value=="P")
								{
								   parent.frames[1].document.forms[0].max_patients_per_day.disabled =false;
								   parent.frames[1].document.forms[0].max_patients_per_day.focus();
								}

							else{
								   parent.frames[1].document.forms[0].max_patients_per_day.disabled =true;
								   parent.frames[1].document.forms[0].max_first_visit.focus();
							}
					}
					else{
						  var p_start_time  = parent.frames[1].document.forms[0].p_start_time.value;
						  var p_end_time    = parent.frames[1].document.forms[0].p_end_time.value;
						  if (p_start_time!=start_time||p_end_time!=end_time){
   							var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='maxPatients' id='maxPatients' method='post' action='../../eOA/jsp/SetUpDailyScheduleMaxPatients.jsp'><input type='hidden' name='starttime' id='starttime' value='"+start_time+"'><input type='hidden' name='endtime' id='endtime' value='"+end_time+"'><input type='hidden' name='timeperpatient' id='timeperpatient' value='"+time_per_patient+"'><input type='hidden' name='maxpatcat' id='maxpatcat' value='"+l_max_pat_category+"'><input type='hidden' name='normal_yn' id='normal_yn' value='Y'></form></body></html>";
							parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
							parent.messageFrame.document.maxPatients.submit();
							if (parent.frames[1].document.forms[0].slot_appt_ctrl.value=="P"){
								   parent.frames[1].document.forms[0].max_patients_per_day.readOnly =false;
								   parent.frames[1].document.forms[0].max_patients_per_day.disabled =false;
								   parent.frames[1].document.forms[0].max_patients_per_day.focus();
								}
							else{
								   parent.frames[1].document.forms[0].max_patients_per_day.readOnly =true;
								   parent.frames[1].document.forms[0].max_first_visit.focus();
								}
						 }
					}
				}
				}

			}
		}
}
}
	}

}
if(obj.value=='')
{
	if(time_table_type=="1"){
	parent.frames[1].document.forms[0].b_max_slots_per_day.value="";
	parent.frames[1].document.forms[0].max_patients_per_day.value="";
	}
}



}

function ChkNum(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		return true;
	}
	else if ( obj.value.length > 0 ) {
  			alert(getMessage('NUM_ALLOWED','SM'));
  			obj.select();
  			obj.focus();
  			return false;
  		}
  	else
  		return true;
  	}



function TimePerSlab(obj)
{
	//parent.frames[1].document.forms[0].max_patients_per_day.value='';
	var function_mode =parent.frames[1].document.forms[0].function_mode.value;
	if (function_mode!="modify")
		parent.frames[1].document.forms[0].max_patients_per_slab.value='';
	var tm = obj;
	if(CheckTime(obj,'X')){
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var end_time		= parent.frames[1].document.forms[0].end_time.value ;
	var start_time		= parent.frames[1].document.forms[0].start_time.value ;
	var timetabletype 	= parent.frames[1].document.forms[0].time_table_type.value ;
	var time_per_slab 	= parent.frames[1].document.forms[0].time_per_slab.value ;
	var dummytime 		= '00:00' ;
	var dummyarray		;

	var tpsarray 		;
	var endarray		;
	var startarray		;
	var tpstime			;
	var endtime			;
	var starttime		;

	tpsarray		= fieldval.split(":") ;
	endarray		= end_time.split(":") ;
	startarray		= start_time.split(":") ;
	dummyarray 		= dummytime.split(":") ;
	dumtime    		= new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

	tpstime			= new Date(1,1,1,tpsarray[0],tpsarray[1],0,0) ;
	endtime			= new Date(1,1,1,endarray[0],endarray[1],0,0) ;
	starttime		= new Date(1,1,1,startarray[0],startarray[1],0,0) ;
	if (timetabletype == '2')
	{
		if (time_per_slab.length != 0)
		{
			if ((tpstime - dumtime) > (endtime - starttime))
			{
					var in_max_tps	     = getMessage('INVALID_MAX_TM_PR_SLAB',"OA") ;
					alert(in_max_tps) ;
					if(parent.frames[1].document.forms[0].function_mode.value!="modify"){
					parent.frames[1].document.forms[0].time_per_slab.focus();
					}
					else
				{
						parent.frames[1].document.forms[0].end_time.focus();
						parent.frames[1].document.forms[0].end_time.select();
				}

			}
			else if (time_per_slab <= "0" )
			{
				var in_tm_pr_slab = getMessage('INVALID_TM_PR_SLAB',"OA");
				alert(in_tm_pr_slab) ;
				parent.frames[1].document.forms[0].time_per_slab.focus();
			}else{
				var x=parent.frames[1].document.forms[0].time_per_slab.value;
				var y=parent.frames[1].document.forms[0].hddDur.value;

				var arr1=x.split(":");
				var arr2=y.split(":");


				//var dur=parseInt('10');
				var dur=(parseInt(arr2[0])*60) + parseInt(arr2[1]);
				var indur=(parseInt(arr1[0])*60) + parseInt(arr1[1]);
				var modu=indur % dur;


				if(modu>0){
					var error=getMessage("TIME_DEFAULT_DURATION","OA");
					alert(error +y);
					parent.frames[1].document.forms[0].time_per_slab.value=y;
				}	
			parent.frames[1].document.forms[0].max_patients_per_slab.focus();
			}
		}
		else
		{
		parent.frames[1].document.forms[0].max_patients_per_slab.focus();
		}
	}
}
}




function MaxPatPerSlab(obj)
{
	if(parent.frames[1].document.forms[0].function_mode.value!='modify'){		
	var no=obj;
	if(ChkNum(obj)){
	fieldname 		= obj ;
	fieldval		= fieldname.value ;
	var timetabletype 	= parent.frames[1].document.forms[0].time_table_type.value ;
	var l_max_pat_category	= "2" ;
	var start_time	     	= parent.frames[1].document.forms[0].start_time.value ;
	var end_time	     	= parent.frames[1].document.forms[0].end_time.value ;
	var l_time_per_slab	= parent.frames[1].document.forms[0].time_per_slab.value ;
	var l_max_pat_per_slab	= parent.frames[1].document.forms[0].max_patients_per_slab.value ;
	 if (obj.value !='' && (start_time =='' || end_time==''))
       {
			alert(getMessage('START_END_NOT_BLANK','OA'));
		   parent.frames[1].document.forms[0].start_time.focus()
			   //obj.focus();
		   return 
       }
	if (timetabletype == '2' && l_time_per_slab != ""){
	if (l_max_pat_per_slab <=0&&l_max_pat_per_slab!=""){
			alert(getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common"));
			fieldname.focus();
		}
		else{	   
			if ((l_time_per_slab != "0") && (!l_time_per_slab < '0'))
			{
				if ((fieldval=="") && (l_time_per_slab != ""))
				{
					var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK',"Common") ;
					alert(no_blank) ;
					fieldname.focus();
				}

				else if ((fieldval <= 0) && (l_time_per_slab != ""))
				{
				//Changes to be made
					alert(getMessage('INVALID_MAX_TM_PR_SLAB','OA'));
						fieldname.focus();
				}

			}
			if (l_max_pat_per_slab!=""){
				
				
				var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='maxPatients' id='maxPatients' method='post' action='../../eOA/jsp/SetUpDailyScheduleMaxPatients.jsp'><input type='hidden' name='starttime' id='starttime' value='"+start_time+"'><input type='hidden' name='endtime' id='endtime' value='"+end_time+"'><input type='hidden' name='timeperslab' id='timeperslab' value='"+l_time_per_slab+"'><input type='hidden' name='maxpatperslab' id='maxpatperslab' value='"+l_max_pat_per_slab+"'><input type='hidden' name='maxpatcat' id='maxpatcat' value='"+l_max_pat_category+"'><input type='hidden' name='normal_yn' id='normal_yn' value='Y'></form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				
				parent.messageFrame.document.maxPatients.submit();
				
			}
		}
	}
}
	}
}
var max_loop = "0";
function MaxFirstVisit(obj)
{	
	var no=obj;
	if(ChkNum(no)){
	fieldname 		= obj ;
	fieldval		= fieldname.value ;
	max_pat_per_day		= parent.frames[1].document.forms[0].max_patients_per_day.value ;
	max_first_visit		= parent.frames[1].document.forms[0].max_first_visit.value;
	slot_appt_ctrl		= parent.frames[1].document.forms[0].slot_appt_ctrl.value;
	visit_limit_rule	= parent.frames[1].document.forms[0].visit_limit_rule.value;
	b_time_table_type	= parent.frames[1].document.forms[0].time_table_type.value;
	max_pat_per_slot	= parent.frames[1].document.forms[0].b_max_slots_per_day.value;

	if(fieldval != ''){
	/*if (fieldval <= 0)
	{
			var errors = getMessage("VALUE_GREATER_ZERO",'OA');
            if (visit_limit_rule=="E")
				errors = errors.replace("#",getLabel("eOA.nooffirstvisits.label","OA"));
			else
				errors = errors.replace("#",getLabel("eOA.maxfirstvisits.label","OA"));
			alert(errors);
			fieldname.value='';
			fieldname.focus();
			flag=0;
			return false;
	}
	else flag=1;*/
	}
	if (visit_limit_rule!="N")
	{
	  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
	  {
		if (parseInt(max_first_visit) > parseInt(max_pat_per_day))
		{
			
			var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
			errors = errors.replace("#",getLabel("Common.days.label","Common"));
			alert(errors);
			fieldname.select();
			flag=0;
			return false;

		}
		else flag=1;
	  }
	  else
	  {
		 if (parseInt(max_first_visit) > parseInt(max_pat_per_slot))
		 {			
			var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
			errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
			alert(errors);
			fieldname.select();
			flag=0;
			return false;
		 }
		 else flag=1;
		}
	}
	else flag=1;

	if (flag == 1 && max_pat_per_day!="" && max_first_visit!="")
		{		
		 parent.frames[1].document.forms[0].max_other_visits.value = parseInt(max_pat_per_day)-parseInt(max_first_visit);
		 //if(parent.frames[1].document.forms[0].function_mode.value != 'modify')
			parent.frames[1].document.forms[0].max_other_visits.select();
		 
		}
	}
}

function maxothervisit(obj)
{
	max_other_visit		= parent.frames[1].document.forms[0].max_other_visits.value ;
	if(max_other_visit != ''){
		max_pat_per_day		= parent.frames[1].document.forms[0].max_patients_per_day.value ;
		slot_appt_ctrl		= parent.frames[1].document.forms[0].slot_appt_ctrl.value;
		visit_limit_rule	= parent.frames[1].document.forms[0].visit_limit_rule.value;
		b_time_table_type	= parent.frames[1].document.forms[0].time_table_type.value;
		max_pat_per_slot	= parent.frames[1].document.forms[0].b_max_slots_per_day.value;
		var flag ="0";
		if (max_other_visit=="" )  max_other_visit="0";
		if (max_pat_per_day=="" )  max_pat_per_day="0";
		/*if (max_other_visit <= 0)
		{
				var errors = getMessage("VALUE_GREATER_ZERO","OA");
				if (visit_limit_rule=="E")
					errors = errors.replace("#",getLabel("eOA.noofothervisits.label","OA"));
				else
					errors = errors.replace("#",getLabel("eOA.MaxOtherVisits.label","OA"));
				alert(errors);
				parent.frames[1].document.forms[0].max_other_visits.value = '';
				parent.frames[1].document.forms[0].max_other_visits.focus();
				flag=0;
				return false;
		}*/
		 if (visit_limit_rule!="N")
		{	 	
		  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
		  {
			if (parseInt(max_other_visit) > parseInt(max_pat_per_day))
			{
				
				var errors = getMessage("MAX_OT_VI_GR_MAX_PAT_PER_DAY","OA");
				errors = errors.replace("#",getLabel("Common.days.label","Common"));
				alert(errors);
				parent.frames[1].document.forms[0].max_other_visits.focus();
			}
		  }
		  else
		  {
			 if (parseInt(max_other_visit) > parseInt(max_pat_per_slot))
			 {				
				var errors = getMessage("MAX_OT_VI_GR_MAX_PAT_PER_DAY","OA");
				errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
				alert(errors);
				parent.frames[1].document.forms[0].max_other_visits.focus();
			 }
			}
		}
	}

}

function chkMaximumFirstVisit(Obj1,Obj2)
{
	var v1= parseInt(Obj1.value);
	var v2= parseInt(Obj2.value);
	if(v2 != 0)
	{
		if(v1 < v2 )
		{
		var m_n_l_f = getMessage('MAX_NOT_LESS_FV',"OA");
		alert(m_n_l_f);
        max_loop="1";
		Obj1.focus();
		}
	}
    else
	max_loop="0";
}



function MaxOverBookings(obj,fromWhere)
{
   if (max_loop=="0")
   {
	fieldname 		= obj ;
	if(ChkNum(fieldname)){
	fieldval		= fieldname.value ;
	if (fromWhere=="apply")
	{
	max_pat_per_day		= frames[1].document.forms[0].max_patients_per_day.value ;
	max_over_booking	= frames[1].document.forms[0].max_over_bookings.value ;
	}else{
	max_pat_per_day		= parent.frames[1].document.forms[0].max_patients_per_day.value ;
	max_over_booking	= parent.frames[1].document.forms[0].max_over_bookings.value ;
	}
	maxoverloop="0"
	
	if (fieldval <0 &&fieldval!=""){
	//if (fieldval <= 0&&fieldval!=""){  // commented and teh above line added for incident IN015281 
		alert(getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common"));
			fieldname.select();
			obj.focus();
			return false;
	}
	else if (parseInt(max_over_booking) > parseInt(max_pat_per_day))
	{
		var max_ob	= getMessage('MAX_OB_GR_MAX_PAT_PER_DAY',"OA") ;
		maxoverloop="1";
		//obj.focus();
		obj.value="";
		alert(max_ob) ;
		obj.focus();
		return false;

	}
}
}
}

var maxoverloop="0";
function chkMaximumOverBooking(Obj1,Obj2)
{

}



///////////// Break Time Validations 

function formatBreakFrToTime(xer)
{

	if (xer == '1')
	{

		if (parent.frames[1].document.forms[0].from_time1.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].from_time1.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].from_time1.value = '0' + parent.frames[1].document.forms[0].from_time1.value ;
			}

		}

		if (parent.frames[1].document.forms[0].from_time1.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].from_time1.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].from_time1.value = '00' + parent.frames[1].document.forms[0].from_time1.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time1.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].to_time1.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].to_time1.value = '0' + parent.frames[1].document.forms[0].to_time1.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time1.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].to_time1.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].to_time1.value = '00' + parent.frames[1].document.forms[0].to_time1.value ;
			}

		}
	}

	if (xer == '2')
	{

		if (parent.frames[1].document.forms[0].from_time2.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].from_time2.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].from_time2.value = '0' + parent.frames[1].document.forms[0].from_time2.value ;
			}

		}

		if (parent.frames[1].document.forms[0].from_time2.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].from_time2.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].from_time2.value = '00' + parent.frames[1].document.forms[0].from_time2.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time2.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].to_time2.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].to_time2.value = '0' + parent.frames[1].document.forms[0].to_time2.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time2.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].to_time2.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].to_time2.value = '00' + parent.frames[1].document.forms[0].to_time2.value ;
			}

		}
	}
	if (xer == '3')
	{

		if (parent.frames[1].document.forms[0].from_time3.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].from_time3.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].from_time3.value = '0' + parent.frames[1].document.forms[0].from_time3.value ;
			}

		}

		if (parent.frames[1].document.forms[0].from_time3.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].from_time3.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].from_time3.value = '00' + parent.frames[1].document.forms[0].from_time3.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time3.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].to_time3.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].to_time3.value = '0' + parent.frames[1].document.forms[0].to_time3.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time3.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].to_time3.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].to_time3.value = '00' + parent.frames[1].document.forms[0].to_time3.value ;
			}

		}
	}
	if (xer == '4')
	{

		if (parent.frames[1].document.forms[0].from_time4.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].from_time4.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].from_time4.value = '0' + parent.frames[1].document.forms[0].from_time4.value ;
			}

		}

		if (parent.frames[1].document.forms[0].from_time4.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].from_time4.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].from_time4.value = '00' + parent.frames[1].document.forms[0].from_time4.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time4.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].to_time4.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].to_time4.value = '0' + parent.frames[1].document.forms[0].to_time4.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time4.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].to_time4.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].to_time4.value = '00' + parent.frames[1].document.forms[0].to_time4.value ;
			}

		}
	}

	if (xer == '5')
	{

		if (parent.frames[1].document.forms[0].from_time5.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].from_time5.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].from_time5.value = '0' + parent.frames[1].document.forms[0].from_time5.value ;
			}

		}

		if (parent.frames[1].document.forms[0].from_time5.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].from_time5.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].from_time5.value = '00' + parent.frames[1].document.forms[0].from_time5.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time5.value.length == 2)
		{
			if (parent.frames[1].document.forms[0].to_time5.value.substring(1,2) == ':')
			{
				parent.frames[1].document.forms[0].to_time5.value = '0' + parent.frames[1].document.forms[0].to_time5.value ;
			}

		}

		if (parent.frames[1].document.forms[0].to_time5.value.length == 3)
		{
			if (parent.frames[1].document.forms[0].to_time5.value.substring(0,1) == ':')
			{
				parent.frames[1].document.forms[0].to_time5.value = '00' + parent.frames[1].document.forms[0].to_time5.value ;
			}

		}
	}
}


//////////////////
var loop_flag ="1";
var flag1=1;
function CallFromBreakTimeValidation(obj,xer)
{
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var fieldarray		;
	var fieldtime		;

	var l_timetabletype 	= SetUpDailySchedule.time_table_type.value ;
	var l_start_time	= SetUpDailySchedule.start_time.value ;
	var l_end_time	     	= SetUpDailySchedule.end_time.value ;
	var l_time_per_slab	= SetUpDailySchedule.time_per_slab.value ;
	var l_time_per_patient 	= SetUpDailySchedule.time_per_patient.value ;


	var endarray 	;
	var tpsarray	;
	var tpparray	;
	var endtime	;
	var tpstime	;
	var tpptime	;
	var startarray	;
	var starttime	;
	var entime	;
	var sttime	;

	var dummytime = '00:00' ;
	var dummyarray;
	var dumtime   ;

	endarray	=	l_end_time.split(":") ;
	endtime		= 	new Date(1,1,1,endarray[0],endarray[1],0,0) ;

	startarray	=	l_start_time.split(":") ;
	starttime	= 	new Date(1,1,1,startarray[0],startarray[1],0,0) ;

	tpsarray	=	l_time_per_slab.split(":") ;
	tpstime		= 	new Date(1,1,1,tpsarray[0],tpsarray[1],0,0) ;

	tpparray	=	l_time_per_patient.split(":") ;
	tpptime		= 	new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;

	fieldarray	=	fieldval.split(":") ;
	fieldtime	= 	new Date(1,1,1,fieldarray[0],fieldarray[1],0,0) ;

	dummyarray 	= 	dummytime.split(":") ;
	dumtime    	= 	new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

	frtime		= 	fieldtime - dumtime ;
	entime		=	endtime	- dumtime;
	sttime		=	starttime - dumtime;
	if(frtime == sttime)
	{
		alert(getMessage('ATLEAST_ONE_SLSB_START_EXIT',"OA") );
		obj.focus();
		obj.value="";
	}else
	{
		
	}
	if (max_loop=="0" && maxoverloop=="0"){

		if (frtime < sttime){
			alert(getMessage('BR_TM_NOT_VALID',"OA"));
			loop_flag ="0";
			obj.focus();
		}else if (frtime > entime){
			alert(getMessage('BR_TM_NOT_VALID',"OA"));
			loop_flag ="0";
			obj.focus();

		}else{
			loop_flag ="1";
			
			
			}
	}
		
	}	


function query()
{	 
	var sysdate = document.getElementById("sysdate").value;
	f_query_add_mod.location.href 	= "../../eOA/jsp/SetUpDailyScheduleQueryCriteria.jsp?mode=modify&sysdate="+sysdate ;
}


function qryModify(p_clinic_code,p_pract_id,clinic_date,p_time_table_type,sl_no,locn_type,res_type)
{		parent.f_query_add_mod.location.href="../../eOA/jsp/SetUpDailyScheduleHeader.jsp?function_mode=modify&clinic_code="+p_clinic_code+"&practid="+p_pract_id+"&clinic_date="+clinic_date+"&timetabletype="+p_time_table_type+"&locn_care_ind="+locn_type+"&resource_class="+res_type;
}

function deleterecord()
{

	
	if(frames[1].document.forms[0].fmode.value !='insert')
	{
 if(confirm(frames[1].getMessage('DELETE_RECORD','Common')))
	{

	frames[1].document.forms[0].fmode.value='delete'
	var time_table_type	= frames[1].document.forms[0].time_table_type.value ;
	if (time_table_type == '1')
	{
		
		var fields = new Array ( frames[1].document.forms[0].location,
					 frames[1].document.forms[0].clinic_date,
					 frames[1].document.forms[0].time_table_type,
					 frames[1].document.forms[0].start_time,
					 frames[1].document.forms[0].end_time,
					 frames[1].document.forms[0].time_per_patient,
					 frames[1].document.forms[0].max_patients_per_day);

		var names = new Array (	getLabel("Common.Location.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.TimeperPatient.label","OA"),
								getLabel("eOA.maxpatperday.label","OA")
								);
	}
	else if (time_table_type == '2')
	{
		var fields = new Array ( frames[1].document.forms[0].location,
					 frames[1].document.forms[0].clinic_date,
					 frames[1].document.forms[0].time_table_type,
					 frames[1].document.forms[0].start_time,
					 frames[1].document.forms[0].end_time,
					 frames[1].document.forms[0].time_per_slab,
					 frames[1].document.forms[0].max_patients_per_day);

		var names = new Array (getLabel("Common.Location.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.timeperslab.label","OA"),
								getLabel("eOA.maxpatperday.label","OA")
							);
	}
	else
	{
		var fields = new Array ( frames[1].document.forms[0].location,
					 frames[1].document.forms[0].clinic_date,
					 frames[1].document.forms[0].time_table_type,
					 frames[1].document.forms[0].start_time,
					frames[1].document.forms[0].end_time,
					 frames[1].document.forms[0].max_patients_per_day) ;


		var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.date.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.maxpatperday.label","OA")
									);


		var v1="";
	var toSubmit = true;
	if (frames[1].document.forms[0].max_first_visit.value!="")
		v1= parseInt(frames[1].document.forms[0].max_first_visit.value);
    else
		v1 =0;
	var v2= parseInt(frames[1].document.forms[0].first_visit_cnt.value);
		if(v1 < v2 &&toSubmit)
		{
		var m_n_l_f = getMessage('MAX_NOT_LESS_FV',"OA");
		alert(m_n_l_f);
		frames[1].document.forms[0].max_first_visit.focus();
		toSubmit = false;
		}
	if (frames[1].document.forms[0].max_other_visits.value!="")
		v1= parseInt(frames[1].document.forms[0].max_other_visits.value);
    else
		v1 =0;
	var v2= parseInt(frames[1].document.forms[0].other_visit_cnt.value);
		if(v1 < v2 &&toSubmit)
		{
		var m_n_l_f = getMessage('MAX_NOT_LESS_OV',"OA");
		alert(m_n_l_f);
		frames[1].document.forms[0].max_first_visit.focus();
		toSubmit = false;
		}
	}
	if(time_table_type == '1' ||time_table_type == '2')
	{
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	frames[1].document.forms[0].submit();
	}else if(time_table_type == '3')
	{
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
	if(toSubmit ==true)
	{
			frames[1].document.forms[0].submit();
	}else
	{
	messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	}
	}
	}
	else
	messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}
		else
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='


	
}

//var bol=true;


function ChkNumber(Obj)
{
	if(parseInt(Obj.value)!=0){
	if(ChkNum(Obj))
	{
		if( parent.frames[1].document.forms[0].time_table_type.value == '1')
		 	parent.frames[1].document.forms[0].max_first_visit.focus();

	}
	}
	else{
	alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));	
	Obj.value='';
	Obj.focus();
	}

}
function CallToBreakTimeValidation(obj,xer)
{
	if (loop_flag=="1"&&maxoverloop=="0"&&max_loop=="0")
	{
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var fieldarray		;
	var fieldtime		;

	var l_timetabletype 	= SetUpDailySchedule.time_table_type.value ;
	var l_start_time	= SetUpDailySchedule.start_time.value ;
	var l_end_time	     	= SetUpDailySchedule.end_time.value ;
	var l_time_per_slab	= SetUpDailySchedule.time_per_slab.value ;
	var l_time_per_patient 	= SetUpDailySchedule.time_per_patient.value ;

	var endarray 	;
	var tpsarray	;
	var tpparray	;
	var endtime	;
	var tpstime	;
	var tpptime	;
	var startarray	;
	var starttime	;
	var entime	;
	var sttime	;

	var dummytime = '00:00' ;
	var dummyarray;
	var dumtime   ;

	endarray	=	l_end_time.split(":") ;
	endtime		= 	new Date(1,1,1,endarray[0],endarray[1],0,0) ;

	startarray	=	l_start_time.split(":") ;
	starttime	= 	new Date(1,1,1,startarray[0],startarray[1],0,0) ;

	tpsarray	=	l_time_per_slab.split(":") ;
	tpstime		= 	new Date(1,1,1,tpsarray[0],tpsarray[1],0,0) ;

	tpparray	=	l_time_per_patient.split(":") ;
	tpptime		= 	new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;

	fieldarray	=	fieldval.split(":") ;
	fieldtime	= 	new Date(1,1,1,fieldarray[0],fieldarray[1],0,0) ;

	dummyarray 	= 	dummytime.split(":") ;
	dumtime    	= 	new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

	totime		= 	fieldtime - dumtime ;
	entime		=	endtime	- dumtime;
	sttime		=	starttime - dumtime;


	if (totime < sttime)
	{
		alert(getMessage('BR_TM_NOT_VALID',"OA"));
		obj.focus();
	}
	else if (totime > entime)
	{
		alert(getMessage('BR_TM_NOT_VALID',"OA"));
		obj.focus();    
	}
    else
	   loop_flag = '1';
	if (l_timetabletype == '1')
	{
				
		brtime		=	endtime-tpptime ;
	
		if (totime > brtime)
		{
			alert(getMessage('ATLEAST_ONE_SLSB_EXIT',"OA") );
			obj.focus();
		}
	}
	else if (l_timetabletype == '2')
	{
		brtime		=	endtime-tpstime ;
		if (totime > brtime)
		{
			alert(getMessage('ATLEAST_ONE_SLSB_EXIT',"OA") );
			obj.focus();
		}
	}
	}
}



function formatTimePerSlab()
{
	if (parent.frames[1].document.forms[0].time_per_slab.value.length == 2)
	{
		if (parent.frames[1].document.forms[0].time_per_slab.value.substring(1,2) == ':')
		{
			parent.frames[1].document.forms[0].time_per_slab.value = '0' + parent.frames[1].document.forms[0].time_per_slab.value ;
		}

	}

	if (parent.frames[1].document.forms[0].time_per_slab.value.length == 3)
	{
		if (parent.frames[1].document.forms[0].time_per_slab.value.substring(0,1) == ':')
		{
			parent.frames[1].document.forms[0].time_per_slab.value = '00' + parent.frames[1].document.forms[0].time_per_slab.value ;
		}

	}
}

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
function PractLookupRetVal(retVal,objName){
	var arr;
	if (retVal != null){
		arr=unescape(retVal).split("~");	parent.frames[1].document.forms[0].practitioner_name.value=arr[1];
		parent.frames[1].document.forms[0].practitioner.value=arr[0];
		if(parent.frames[1].document.forms[0].function_type.value=="timetable"){
			parent.frames[1].document.forms[0].b_day.disabled=false;
			parent.frames[1].document.forms[0].b_roster_reqd.disabled=false;
		}		
	}else{
		parent.frames[1].document.forms[0].practitioner_name.value= "";
		parent.frames[1].document.forms[0].practitioner.value="";
		if(parent.frames[1].document.forms[0].function_type.value=="timetable"){
			parent.frames[1].document.forms[0].b_day.disabled=true;
			parent.frames[1].document.forms[0].b_roster_reqd.disabled=true;
		}		
	}
}
function rostertype(){
	 if (parent.frames[1].document.forms[0].b_roster_reqd.checked == true)
		parent.frames[1].document.forms[0].b_roster_reqd.value="Y";
	 else
		parent.frames[1].document.forms[0].b_roster_reqd.value="N";
}




async function show_allocation_details(){
var max_no_patient=parent.frames[1].document.forms[0].max_patients_per_day.value;
var visit_limit_rule=parent.frames[1].document.forms[0].visit_limit_rule.value;
var slot_appt_ctrl=parent.frames[1].document.forms[0].slot_appt_ctrl.value;
var b_time_table_type=parent.frames[1].document.forms[0].time_table_type.value;

if(max_no_patient==''){ 

	alert(getMessage("MAX_PAT_NOT_DEFINED","OA"));
	}
else
{
if(chkBeforeAllocation())
{
		if (visit_limit_rule!="N")
		{
		  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
			var max_no_patient=parent.frames[1].document.forms[0].max_patients_per_day.value;
		  else
			var max_no_patient=parent.frames[1].document.forms[0].b_max_slots_per_day.value;				
		}
		else
			var max_no_patient=parent.frames[0].document.forms[0].max_patients_per_day.value;	

var alcn_basis=parent.frames[1].document.forms[0].alcn_basis.value;
var alcn_criteria=parent.frames[1].document.forms[0].alcn_criteria.value;


if(alcn_basis!=''){
var clinic_code=parent.frames[1].document.forms[0].clinic_code.value;
var practitioner_id=parent.frames[1].document.forms[0].practitioner.value;
//var day_no=parent.frames[1].document.forms[0].b_day.value;
var day_no=parent.frames[1].document.forms[0].day_no.value;
var clinic_date=parent.frames[1].document.forms[0].clinic_date.value;


var time_table_type=parent.frames[1].document.forms[0].time_table_type.value;
var final_string=parent.frames[1].document.forms[0].final_string.value;
var mode=parent.frames[1].document.forms[0].fmode.value;
if(mode=='insert'){
var status_no="";
}
else{
var status_no="direct";}

				parent.frames[1].document.forms[0].time_per_patient.readonly=true;
				parent.frames[1].document.forms[0].max_patients_per_day.readonly=true;
				var retVal = 	new String();
				var dialogHeight= "19" ;
				var dialogTop = "300" ;
				var dialogWidth	= "58" ;
				var status = "no";
				var scroll = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				if(parent.frames[1].document.forms[0].final_string1.value =='')  { status_no='';}
				var callurl="../../eOA/jsp/ClinicAllocationDaySchedule.jsp?alcn_basis="+alcn_basis+"&alcn_criteria="+alcn_criteria+"&max_no_patient="+max_no_patient+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&clinic_date="+clinic_date+"&day_no="+day_no+"&time_table_type="+time_table_type+"&final_string="+final_string+"&time_table_type="+time_table_type+"&status="+status_no+"&mode=insert&calling_from=DAY_SCHEDULE"+"&slot_appt_ctrl="+slot_appt_ctrl;;
				retVal = await window.showModalDialog(callurl,arguments,features);				
				
				
				if(retVal!=null && retVal!='undefined' && retVal!=''){
				parent.frames[1].document.forms[0].final_string.value=retVal;
				parent.frames[1].document.forms[0].max_patients1.value=parent.frames[1].document.forms[0].max_patients_per_day.value;
                
				parent.frames[1].document.forms[0].allocation_changed.value="Y";				
				}
				else if(retVal==null || retVal =='undefined' || retVal=='')
				{
				retVal="";
				parent.frames[1].document.forms[0].final_string.value=retVal;
				parent.frames[1].document.forms[0].final_string1.value=retVal;
				parent.frames[1].document.forms[0].allocation_changed.value="Y";				
				}
				else{
				retVal="";
				parent.frames[1].document.forms[0].final_string.value=retVal;
				parent.frames[1].document.forms[0].final_string1.value=retVal;
				parent.frames[1].document.forms[0].allocation_changed.value="Y";				
				}
				}
else{

var errors = getMessage("ALCN_CRIT_NOT_DEFINED","OA");
alert(errors);

}
}
}
}
function displayMandatory(Obj)
{
	if(Obj.value == '')
	{
	document.getElementById("t_per_pat").style.visibility='hidden'
	document.getElementById("mx_pat_per_day").style.visibility='hidden'
	document.getElementById("t_per_slab").style.visibility='hidden'
	document.getElementById("mx_per_slab").style.visibility='hidden'
		document.getElementById("forced").style.visibility='hidden';
	}
	else
	if(Obj.value == '1')
	{
	document.getElementById("t_per_pat").style.visibility='visible'
	document.getElementById("mx_pat_per_day").style.visibility='visible'
	document.getElementById("t_per_slab").style.visibility='hidden'
	document.getElementById("mx_per_slab").style.visibility='hidden'
document.getElementById("forced").style.visibility='hidden';
	}
	else
	if(Obj.value == '2')
	{
	document.getElementById("t_per_slab").style.visibility='visible'
	document.getElementById("mx_per_slab").style.visibility='visible'
	document.getElementById("t_per_pat").style.visibility='hidden'
	document.getElementById("mx_pat_per_day").style.visibility='hidden'
document.getElementById("forced").style.visibility='hidden';
	}
	else
	if(Obj.value == '3')
	{
	document.getElementById("mx_pat_per_day").style.visibility='visible';
	document.getElementById("t_per_pat").style.visibility='hidden'
	document.getElementById("t_per_slab").style.visibility='hidden'
	document.getElementById("mx_per_slab").style.visibility='hidden'
	document.getElementById("forced").style.visibility='hidden';
	}

}
function hidemand()
{
	document.getElementById("t_per_pat").style.visibility='hidden'
	document.getElementById("mx_pat_per_day").style.visibility='hidden'
	document.getElementById("t_per_slab").style.visibility='hidden'
	document.getElementById("mx_per_slab").style.visibility='hidden'
	

}
function chkBeforeAllocation(){
	var time_table_type	= parent.frames[1].document.forms[0].time_table_type.value ;

	var startarray;
	var endarray  ;
	var starttime = parent.frames[1].document.forms[0].start_time.value ;
	var endtime   = parent.frames[1].document.forms[0].end_time.value ;
	var sttime    ;
	var entime    ;
	var totaltime ;

	var fromarray ;
	var toarray   ;
	var fromtime  ;
	var totime    ;
	var starttime1array  ;
	var endtime1array;
	var starttime2;
	var endtime2;
	var frtime    ;
	var tootime   ;
	breaktime     = 0 ;
	var frtotime  ;
	var frto      = new Array() ;
	var dummytime = '00:00' ;
	var dummyarray;
	var dumtime   ;
	var timerinseconds ;

	var time_per_patient = parent.frames[1].document.forms[0].time_per_patient.value ;
	var tpparray  ;
	var timeperpatient ;

	var time_per_slab    = parent.frames[1].document.forms[0].time_per_slab.value ;
	var tpsarray  ;
	var timeperslab ;

	var start_time1      = parent.frames[1].document.forms[0].start_time.value ;
	var end_time1        = parent.frames[1].document.forms[0].end_time.value ;

	var max_first_visit  = parent.frames[1].document.forms[0].max_first_visit.value;
	var max_over_bookings = parent.frames[1].document.forms[0].max_over_bookings.value;
	var max_pat_per_day  = parent.frames[1].document.forms[0].max_patients_per_day.value;
	var maxpat	;

	var toSubmit 	= new Boolean() ;
	toSubmit	= true ;

	var toBreakTime	= new Boolean() ;
	toBreakTime	= true ;

	p_from_time1 	=	parent.frames[1].document.forms[0].from_time1.value ;
	p_to_time1 		=	parent.frames[1].document.forms[0].to_time1.value ;
	p_from_time2 	=	parent.frames[1].document.forms[0].from_time2.value ;
	p_to_time2 		=	parent.frames[1].document.forms[0].to_time2.value ;
	p_from_time3 	=	parent.frames[1].document.forms[0].from_time3.value ;
	p_to_time3 		=	parent.frames[1].document.forms[0].to_time3.value ;
	p_from_time4 	=	parent.frames[1].document.forms[0].from_time4.value ;
	p_to_time4 		=	parent.frames[1].document.forms[0].to_time4.value ;
	p_from_time5 	=	parent.frames[1].document.forms[0].from_time5.value ;
	p_to_time5 		=	parent.frames[1].document.forms[0].to_time5.value ;
	olStr		= p_from_time1 + '-' + p_to_time1 + ',' + p_from_time2 + '-' + p_to_time2 + ',' + p_from_time3 + '-' + p_to_time3 + ',' ;
	olStr	       += p_from_time4 + '-' + p_to_time4 + ',' + p_from_time5 + '-' + p_to_time5 + ',';

	gvar		= olStr.split(",");


		for (var i=0;i<5;i++)
		{
			frtotime = gvar[i] ;
			frto	 = frtotime.split("-") ;
	
			fromarray= frto[0].split(":") ;
			toarray  = frto[1].split(":") ;
			start1array= start_time1.split(":") ;
			end1array  = end_time1.split(":") ;
	
	
			fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
			totime = new Date(1,1,1,toarray[0],toarray[1],0,0) ;
	
			starttime2 = new Date(1,1,1,start1array[0],start1array[1],0,0) ;
			endtime2 = new Date(1,1,1,end1array[0],end1array[1],0,0) ;
	
	
	
			if ((fromarray.length < 2) && (toarray.length == 2))
			{
				toBreakTime = false;
			}
			else if ((toarray.length < 2) && (fromarray.length == 2))
			{
				toBreakTime = false;
			}
			if(fromtime >= totime )
			{
				toBreakTime = false;
		}
		
	}

	
	if (toBreakTime)
	{

		olStr		= p_from_time1 + p_to_time1 + ',' + p_from_time2 + p_to_time2 + ',' + p_from_time3 + p_to_time3 + ',' ;
		olStr	       += p_from_time4 + p_to_time4 + ',' + p_from_time5 + p_to_time5 + ',';

		pvar		= olStr.split(",");

		for (var i=0;i<5;i++)
		{
			frtotime = pvar[i] ;

			fromarray= frtotime.substring(0,5).split(":") ;
			toarray  = frtotime.substring(5,10).split(":") ;

			fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
			totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;

			if ((fromarray != '') && (fromarray != null))
			{
				if ((toarray != '') && (toarray != null))
				{
					
					breaktime += totime - fromtime ;
				}
				else{
					

					breaktime =0;
				}
			}

		}
			tpparray       = time_per_patient.split(":") ;
			timeperpatient = new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;

			tpsarray       = time_per_slab.split(":") ;
			timeperslab    = new Date(1,1,1,tpsarray[0],tpsarray[1],0,0) ;

			dummyarray 	= dummytime.split(":") ;
			dumtime    	= new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

			if (time_table_type == '1')
			{
				timerinseconds = timeperpatient - dumtime;
			}
			else if (time_table_type == '2')
			{
				timerinseconds = timeperslab - dumtime ;
			}

			if (time_table_type != '3')
			{
				breakmod	= (breaktime%timerinseconds) ;

				if (breakmod != 0 )
				{
					var errors = getMessage("BREAK_TIME_NOT_MUL_STSB","OA");
					alert(errors);
					toSubmit = false;
				}
				else
				{
					maxoverloop="0"
					breakdiff = (breaktime/timerinseconds);

					startarray= starttime.split(":") ;
					endarray  = endtime.split(":") ;

					sttime = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
					entime= new Date(1,1,1,endarray[0],endarray[1],0,0) ;

					totaltime = entime - sttime ;

					if (time_table_type == '1'){

						max_pat_per_day_temp = (totaltime / timerinseconds) - breakdiff ;

					}
					if (time_table_type == '2')
					{
						maxpat = ((totaltime / timerinseconds) * parent.frames[1].document.forms[0].max_patients_per_slab.value);

						parent.frames[1].document.forms[0].max_patients_per_day.value =  maxpat - (breakdiff * parent.frames[1].document.forms[0].max_patients_per_slab.value) ;
					}
					parent.frames[1].document.forms[0].ftotstr.value = olStr ;
					max_pat_per_day  = parent.frames[1].document.forms[0].max_patients_per_day.value;

/*					if (parseInt(max_first_visit) > parseInt(max_pat_per_day))
					{
						
						var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY");
						alert(errors);
						toSubmit = false;
					}

					if (parseInt(max_over_bookings) > parseInt(max_pat_per_day))
					{
						var errors = getMessage("MAX_OB_GR_MAX_PAT_PER_DAY");
						alert(errors);
						maxoverloop="1";
						toSubmit = false;
					}*/
					if (time_table_type == '1')
					{
						max_slot_per_day  = parent.frames[1].document.forms[0].b_max_slots_per_day.value;
						if (max_pat_per_day_temp!=max_slot_per_day)
						{
						  parent.frames[1].document.forms[0].b_max_slots_per_day.value = max_pat_per_day_temp;
						  parent.frames[1].document.forms[0].max_patients_per_day.value = max_pat_per_day_temp;
						}
					}

					max_pat_per_day			= parent.frames[1].document.forms[0].max_patients_per_day.value;
					var max_pat_per_slot	= parent.frames[1].document.forms[0].b_max_slots_per_day.value;
					var visit_limit_rule	= parent.frames[1].document.forms[0].visit_limit_rule.value;
					var slot_appt_ctrl		= parent.frames[1].document.forms[0].slot_appt_ctrl.value;
					var b_time_table_type   = parent.frames[1].document.forms[0].time_table_type.value;

					if (visit_limit_rule!="N")
					{
					  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
					  {
						if (parseInt(max_first_visit) > parseInt(max_pat_per_day))
						{
							
							var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.days.label","Common"));
							alert(errors);
							toSubmit = false;
						}
					  }
					  else
					  {
						 if (parseInt(max_first_visit) > parseInt(max_pat_per_slot))
						 {
							
							var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
							alert(errors);
							toSubmit = false;
						 }
						}
					}
					if (visit_limit_rule!="N")
					{
					  if ( b_time_table_type!="1" || visit_limit_rule=="P")
					  {
						if (parseInt(max_over_bookings) > parseInt(max_pat_per_day))
						{
							
							var errors = getMessage("MAX_OB_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.days.label","Common"));
							alert(errors);
							toSubmit = false;
						}
					  }
					  else
					  {
						 if (parseInt(max_over_bookings) > parseInt(max_pat_per_slot))
						 {
							
							var errors = getMessage("MAX_OB_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
							alert(errors);
							toSubmit = false;
						 }
						}
					}
					
				}
			}
			else
			{
				parent.frames[1].document.forms[0].ftotstr.value = olStr ;
			}
			
		if ((Date.parse(fromtime)) >= (Date.parse(totime)))
		{
			var s = getMessage('ED_TIME_LESS_EQL_ST_TIME',"OA");
			alert(s);
			toSubmit = false;
			parent.frames[0].document.forms[0].end_time.focus();
		parent.frames[0].document.forms[0].end_time.select();
		}
	}
	else
	{
			var errors = getMessage("INVALID_BREAK_TIME","OA");
			alert(errors);
			toSubmit = false;
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	}
	return toSubmit ;
}
function clearMaxFirstVisit(obj)
{		
if(chkTime(obj.value)){
	var start_time =parent.frames[1].document.forms[0].start_time;
	var p_start_time =parent.frames[1].document.forms[0].p_start_time;
	var function_mode =parent.frames[1].document.forms[0].function_mode.value; 
   
	if (start_time.value!=p_start_time.value){	
		if (obj.name=="start_time"){			
		parent.frames[1].document.forms[0].end_time.value="";
		}
		parent.frames[1].document.forms[0].max_first_visit.value="";
		parent.frames[1].document.forms[0].max_other_visits.value=""; //Added by S.Sathish for IN020308 on Thursday, April 01, 2010
		parent.frames[1].document.forms[0].max_over_bookings.value="";

		 parent.frames[1].document.forms[0].to_time1.value ="";
		 parent.frames[1].document.forms[0].from_time1.value ="";
		 parent.frames[1].document.forms[0].to_time2.value ="";
		 parent.frames[1].document.forms[0].from_time2.value=""; 
		 parent.frames[1].document.forms[0].to_time3.value ="";
		 parent.frames[1].document.forms[0].from_time3.value ="";
		 parent.frames[1].document.forms[0].to_time4.value ="";
		 parent.frames[1].document.forms[0].from_time4.value ="";
		 parent.frames[1].document.forms[0].to_time5.value ="";
		 parent.frames[1].document.forms[0].from_time5.value ="";
		 if (function_mode!="modify"){
		 parent.frames[1].document.forms[0].max_patients_per_day.value="";
		 }
		 
		 var timetabletype = parent.frames[1].document.forms[0].p_time_table_type.value ;
		  if(timetabletype =='1')
		 {
		
			if (function_mode!="modify"){
                 parent.frames[1].document.forms[0].time_per_patient.value="";}
		 }
		 else
		 if(timetabletype == '2')
		 {
			if (function_mode!="modify")
			 {
			 parent.frames[1].document.forms[0].time_per_slab.value="";
			 parent.frames[1].document.forms[0].max_patients_per_slab.value="";
			 }
		 }
		 else
		 if(timetabletype == '3')
				if (function_mode!="modify")
				 parent.frames[1].document.forms[0].max_patients_per_day.value="";

		if (obj.name!="start_time"){
		 if(timetabletype =='1')
		 {
		if (function_mode!="modify"){
			
		 parent.frames[1].document.forms[0].time_per_patient.focus();
		}
		 }
		 else
		 if(timetabletype == '2')
		 {
			if (function_mode!="modify"){
		 parent.frames[1].document.forms[0].time_per_slab.focus();
			}
		 }
		 else
		 if(timetabletype == '3'){
		 if (function_mode!="modify"){
		  parent.frames[1].document.forms[0].max_patients_per_day.focus();
		 }
		 }
		}
	}
}
}
function MaxPatPerDay(obj)
{
	var fieldname	= obj;
	var fieldval	= fieldname.value;
	var timetabletype = parent.frames[1].document.forms[0].time_table_type.value ;
	var maxpatperday  = parent.frames[1].document.forms[0].max_patients_per_day.value ;
	if (parseInt(maxpatperday) <= 0)
		{
			
			
			var errors = getMessage("VALUE_GREATER_ZERO","OA");
			errors = errors.replace("#","Maximum Patients per Day");
			alert(errors);
			fieldname.select();
			fieldname.focus();
			return false;
		}

	if (timetabletype == '3')
	{
		if (fieldval =="")
		{
			var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK',"Common") ;
		}
		else
		{
			if(timetabletype == '1')
			{
			parent.frames[1].document.forms[0].max_first_visit.focus();
			}
		}

		
	} 
	else if (timetabletype == '1')
	{
	  var max_pat_per_slot  = parent.frames[1].document.forms[0].b_max_slots_per_day.value ;
	  if (maxpatperday !="" && parseInt(max_pat_per_slot)<parseInt(maxpatperday))
	  {
			var errors = getMessage("MAX_SLOT_NOT_GREATER_MAX_DAY","OA");
			alert(errors);
			parent.frames[1].document.forms[0].max_patients_per_day.focus();

	  }
	  
}
}

function changeResource(obj){
var selValue=obj.value;
var res = document.forms[0].resourceType;
while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text='   ---'+getLabel("Common.defaultSelect.label","Common")+'---   ';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
}


function checkinIdentification(Obj){
	
	document.getElementById("imgpract").style.visibility='hidden';
	document.getElementById("resourceType").value='';
	document.getElementById("resourceType").disabled=true;
	document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	document.getElementById("time_table_type").value='';
	document.forms[0].start_time.value='';
	document.forms[0].end_time.value='';
	document.forms[0].p_start_time.value='';
	document.forms[0].p_end_time.value='';
	document.forms[0].hddDur.value='';
	document.forms[0].time_per_slab.value='';
	document.forms[0].time_per_patient.value='';
	document.getElementById("location_code1").value= Obj.value;
	TimePerPatientValid(document.forms[0].time_per_patient)

	displayMandatory(document.getElementById("time_table_type"));
	timetableType(document.getElementById("time_table_type"));
	allowforced();

	var val= Obj.value;
	var arr=val.split('$');
	if(val!=''){
		if(arr[3]=='P'){
			document.getElementById("imgpract").style.visibility='visible';
			document.getElementById("resourceType").disabled=false;

		}else{
			document.getElementById("imgpract").style.visibility='hidden';
					document.getElementById("resourceType").disabled=false;
		}
	}else{
	}
}

function check_loc(Obj){ 
	document.forms[0].start_time.value='';
	document.forms[0].end_time.value='';
	document.forms[0].p_start_time.value='';
	document.forms[0].p_end_time.value='';
	document.forms[0].hddDur.value='';
	document.forms[0].time_per_slab.value='';
	document.forms[0].time_per_patient.value='';


	document.forms[0].max_patients_per_slab.value='';
	document.forms[0].max_first_visit.value='';
	document.forms[0].max_other_visits.value='';
	document.forms[0].max_over_bookings.value='';
	if(parent.frames[1].document.forms[0].rule_appl_yn.value =="Y"){
		document.forms[0].max_new_patients.value='';
		document.forms[0].max_old_patients.value='';
	}
/*if(Obj.value =="3")
{
	document.forms[0].max_first_visit.readonly=true;
	document.forms[0].max_other_visits.readonly=true;
	document.forms[0].max_first_visit.disabled=true;
	document.forms[0].max_other_visits.disabled=true;	
}else
{
	document.forms[0].max_first_visit.readonly=false;
	document.forms[0].max_other_visits.readonly=false;
	document.forms[0].max_first_visit.disabled=false;
	document.forms[0].max_other_visits.disabled=false;
	
}*/
	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	var isScheduleExtendAppl = document.forms[0].isScheduleExtendAppl.value;
	var schedule_extend_param = document.forms[0].schedule_extend_param.value;

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	var isSlotStartMidEndAppl = document.forms[0].isSlotStartMidEndAppl.value;

	if(document.forms[0].b_loc_val.value!=''){
			displayMandatory(Obj);
			timetableType(Obj);
			allowforced();
			if(isScheduleExtendAppl == "true" && schedule_extend_param == "Y"){
				displayExtendTimeYN();
			}
			if(isSlotStartMidEndAppl == "true"){
				timetableOnChangeExtSlotsYN();
			}
	}else{
		var error=getMessage("CAN_NOT_BE_BLANK","Common");
		error=error.replace("$",getLabel("Common.Location.label","Common"));
		alert(error);
		Obj.value='';
	}
	if(Obj.value !='' && Obj.value !="3"){
		//document.getElementById("entitledPatRow").style.display ="";
	}

}

function enable_dsiable_res(Obj){
     document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';
	checkRoster('1');
	document.getElementById("resourceType1").value=document.forms[0].resourceType.value;
	var val    = new Array() ;
	val = document.forms[0].location.value.split("$");
	/*if((Obj.value=='R') ||(Obj.value=='E') || (Obj.value=='O')){
		if(document.forms[0].b_roster_reqd){
			document.forms[0].b_roster_reqd.checked=false;
			document.forms[0].b_roster_reqd.disabled=true;
		}
	}else{
		if(document.forms[0].b_roster_reqd){
			document.forms[0].b_roster_reqd.disabled=false;
		}
	}*/
	if((val[9] =='P' && Obj.value=='P') || (val[9] =='R' && Obj.value=='R') ||(val[9] =='E' && Obj.value=='E') || (val[9] =='O' && Obj.value=='O')){
		var i=0;
		var len=parent.frames[1].document.forms[0].time_table_type.options.length;
		var lBox=parent.frames[1].document.forms[0].time_table_type; 
		lBox.remove(lBox.options[0]);
		while(i<= len){
			lBox.remove(lBox.options[i]);
			i+=1;
		}
		var opt=parent.frames[1].document.createElement('OPTION');
		opt.value='';
		opt.text='  --'+getLabel("Common.defaultSelect.label","Common")+'-- ';
		lBox.add(opt);
		var opt1=parent.frames[1].document.createElement('OPTION');
		opt1.value='1';
		opt1.text=getLabel("Common.Slot.label","Common");
		lBox.add(opt1);
		var opt2=parent.frames[1].document.createElement('OPTION');
		opt2.value='2';
		opt2.text=getLabel("eOA.slab.label","OA");
		lBox.add(opt2);
		var opt3=parent.frames[1].document.createElement('OPTION');
		opt3.value='3';
		opt3.text=getLabel("Common.FreeFormat.label","Common");
		lBox.add(opt3);
	}else{
		var i=0;
		var len=parent.frames[1].document.forms[0].time_table_type.options.length;
		var lBox=parent.frames[1].document.forms[0].time_table_type; 
		lBox.remove(lBox.options[0]);
		while(i<= len){
			lBox.remove(lBox.options[i]);
			i+=1;
		}
		var opt=parent.frames[1].document.createElement('OPTION');
		opt.value='';
		opt.text='  --'+getLabel("Common.defaultSelect.label","Common")+'-- ';
		lBox.add(opt);
		var opt1=parent.frames[1].document.createElement('OPTION');
		opt1.value='1';
		opt1.text=getLabel("Common.Slot.label","Common");
		lBox.add(opt1);
		var opt2=parent.frames[1].document.createElement('OPTION');
		opt2.value='2';
		opt2.text=getLabel("eOA.slab.label","OA");
		lBox.add(opt2);
	}
	if((Obj.value=='')||(Obj.value=='B')){
		document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
	}else{
		document.getElementById("practitioner_name").disabled=false;
		document.getElementById("search_pract").disabled=false;
	}
}


function remove_freeform(inVal){
	if(inVal=='P' || inVal=='' || inVal=='C'){
		var i=0;
		var len=parent.frames[1].document.forms[0].time_table_type.options.length;
		var lBox=parent.frames[1].document.forms[0].time_table_type; 
		lBox.remove(lBox.options[0]);
	 
		 while(i<= len){
			 lBox.remove(lBox.options[i]);
			 i+=1;
		}

		var opt=parent.frames[1].document.createElement('OPTION');
		 opt.value='';
		 opt.text='  --'+getLabel("Common.defaultSelect.label","Common")+'-- ';
		 lBox.add(opt);
		var opt1=parent.frames[1].document.createElement('OPTION');
		 opt1.value='1';
		 opt1.text=getLabel("Common.Slot.label","Common");
		 lBox.add(opt1);
		 var opt2=parent.frames[1].document.createElement('OPTION');
		 opt2.value='2';
		 opt2.text=getLabel("eOA.slab.label","OA");
		 lBox.add(opt2);

		 var opt=parent.frames[1].document.createElement('OPTION');
		 opt.value='3';
		 opt.text=getLabel("Common.FreeFormat.label","Common");
			 lBox.add(opt);
		
		
	}else{
		var i=0;
		var len=parent.frames[1].document.forms[0].time_table_type.options.length;
		var lBox=parent.frames[1].document.forms[0].time_table_type; 
		lBox.remove(lBox.options[0]);
	 
		 while(i<= len){
			 lBox.remove(lBox.options[i]);
			 i+=1;
		}

		var opt=parent.frames[1].document.createElement('OPTION');
		 opt.value='';
		 opt.text='  --'+getLabel("Common.defaultSelect.label","Common")+'-- ';
		 lBox.add(opt);
		var opt1=parent.frames[1].document.createElement('OPTION');
		 opt1.value='1';
		 opt1.text=getLabel("Common.Slot.label","Common");
		 lBox.add(opt1);
		 var opt2=parent.frames[1].document.createElement('OPTION');
		 opt2.value='2';
		 opt2.text=getLabel("eOA.slab.label","OA");
		 lBox.add(opt2);	
		 
	}	
}


/*For checking the Resource Type*/
	function changeLabel()
{	
	var valSel=document.getElementById("resourceType").value;
	if(valSel=="R")
	document.getElementById("resourceTypeLabel").innerHTML="Room&nbsp;";
	else if(valSel=="P")
	document.getElementById("resourceTypeLabel").innerHTML="Practitioner&nbsp;";
	document.forms[0].practitioner.value='';
	document.forms[0].practitioner_name.value='';
}

/*For checking the forced booking */
function check_Forced(){
	if(document.forms[0].forced_book_YN.checked){
		
		if(document.forms[0].time_table_type.value=='' || document.forms[0].time_table_type.value=='3'){
				
			document.forms[0].forced_book_YN.checked=false;
			document.forms[0].no_of_forced_booking.disabled=true;
		}else{
			
			document.forms[0].no_of_forced_booking.disabled=false;
			document.getElementById("forced").style.visibility='visible';
		}
	}else{
		document.forms[0].no_of_forced_booking.disabled=true;
		document.forms[0].no_of_forced_booking.value='';
		document.getElementById("forced").style.visibility='hidden';
	}
	
}


/*check for allowing the forced booking*/
function allowforced()
{
	if(document.forms[0].time_table_type.value=='' || document.forms[0].time_table_type.value=='3')
	{
		document.forms[0].forced_book_YN.disabled=true;
	}
	else
	{
		document.forms[0].forced_book_YN.disabled=false;
	}
}


/*For checking the time format */
	function ChkTime(obj) 
	{
		var timefield 	= obj;
		if (tmchk(obj) == false) 
		{
			obj.focus();
			alert(getMessage('INVALID_TIME_FMT','SM')) ;
			obj.value="";
			obj.select();
			obj.focus();
			return false;
		}
	   else
		   return true;
	}


function chkmandatory()
{
	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	var isScheduleExtendAppl = document.forms[0].isScheduleExtendAppl.value;
	var schedule_extend_param = document.forms[0].schedule_extend_param.value;

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	var isSlotStartMidEndAppl = document.forms[0].isSlotStartMidEndAppl.value;

	if(isScheduleExtendAppl == "true" && schedule_extend_param == "Y"){
		displayExtendTimeYN();
	}

	if(isSlotStartMidEndAppl == "true"){
		displayExtSlotsYN();
	}

	if(document.forms[0].function_mode.value=='modify')
	{
		if(document.forms[0].p_time_table_type.value=='3')
		{
			document.forms[0].forced_book_YN.disabled=true;
		}

		if(document.forms[0].p_time_table_type.value=='3')
		{
			document.forms[0].max_first_visit.disabled=true;
			document.forms[0].max_other_visits.disabled=true;
		}
		
	}else{
		document.getElementById("forced").style.visibility='hidden';
		document.getElementById("b_loc_val").disabled=true;
		document.getElementById("b_loc_search").disabled=true;
		/*Added by S.Sathish for IN020308 on Wednesday, April 07, 2010 starts here*/
		document.getElementById("time_per_slab").readOnly=true;
		document.getElementById("max_patients_per_day").readOnly=true;
		document.getElementById("max_patients_per_slab").readOnly=true;
		/*Ends here*/
	}
}

function removeOrderByCol() 
{  
var j=0;
var from = document.item('orderbycolumns'); 
if ( from.options.length > 0 )
{
var to = document.item('orderbycols');
var element = document.createElement('OPTION');
element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);   
from.remove(from.selectedIndex);
if(from.options[j]) from.options[j].selected=true;
j++; 
} 
} 

function addOrderByCol()   
{     
var i=0; var from = document.item('orderbycols'); 
if ( from.options.length > 0 ) { 
	var to = document.item('orderbycolumns'); 
	var element = document.createElement('OPTION'); 
	element.text = from.options[from.selectedIndex].text; 
	element.value= from.options[from.selectedIndex].value; 
	to.add(element);      
	from.remove(from.selectedIndex);
	if(from.options[i])  from.options[i].selected=true ; 
	i++;
}
}
function execQuery()
{
	var fun_type=parent.frames[1].document.forms[0].f_type.value;
	if(fun_type=="")
	{
	if(document.forms[0].clinic_date.value =="")
	{
		var errors = getMessage("DATE_NOT_BLANK","OA");
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+errors+'&err_value=0'  ;
	}else
	{
	var locn=document.forms[0].care_locn_type_ind.value;
	var locn_id=document.forms[0].clinic_code.value;
	var locn_desc=document.forms[0].clinic_desc.value;
	var resc_class=document.forms[0].resourceType.value;
	var resc_id=document.forms[0].practitioner_id.value;
	var resc_desc=document.forms[0].practitioner_name.value;
	var clinic_date=document.forms[0].clinic_date.value;
	var time_table_type=document.forms[0].time_table_type.value;
	var function_mode=document.forms[0].function_mode.value;
	var orderbycolumns =document.forms[0].orderbycolumns.value;
		if(locn=="------ Select------")
		locn = "";
if(document.getElementById("orderbycolumns").options.length >0 ){
		parent.frames[1].location.href='../../eOA/jsp/SetUpDailyScheduleQueryResult.jsp?function_mode='+function_mode+'&clinic_code='+locn_id+'&clinic_desc='+locn_desc+'&practitioner_id='+resc_id+'&practitioner_name='+resc_desc+'&clinic_date='+clinic_date+'&time_table_type='+time_table_type+'&locn_type='+locn+'&resource_type='+resc_class;
		}else{
			alert(getMessage('ORDERBY_NOT_BLANK','Common'))
			}	
	}
	}
	else
	{
	var locn=document.forms[0].care_locn_type_ind.value;
	var locn_id=document.forms[0].clinic_code.value;
	var locn_desc=document.forms[0].clinic_desc.value;
	var resc_class=document.forms[0].resourceType.value;
	var resc_id=document.forms[0].practitioner_id.value;
	var resc_desc=document.forms[0].practitioner_name.value;
	var day_code1=document.forms[0].day_code.value;
	var time_table_type=document.forms[0].time_table_type.value;
	var roster_req=document.forms[0].phys_roster_reqd_yn.value;
	var function_mode=document.forms[0].function_mode.value;
	var orderbycolumns =document.forms[0].orderbycolumns.value;
	if(locn=="------ Select------")
		locn = "";

if(document.getElementById("orderbycolumns").options.length >0 ){
		var url='../../eOA/jsp/TimeTableQueryResult.jsp?mode='+function_mode+'&clinic_code='+locn_id+'&clinic_desc='+locn_desc+'&practitioner_id='+resc_id+'&practitioner_name='+resc_desc+'&day_code='+day_code1+'&time_table_type='+time_table_type+'&care_locn_type_ind='+locn+'&resource_class='+resc_class+'&phys_roster_reqd_yn='+roster_req;
		parent.f_query_add_mod.location.href=url;
		}else{
			alert(getMessage('ORDERBY_NOT_BLANK','Common'))
			}	

	//parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
}


/*
function populatePractitioner(obj)
{
	
	document.forms[0].practitioner_name.value="";
	document.forms[0].resourceType.disabled=false;

	document.forms[0].practitioner.value="";

	if(document.forms[0].b_day.disabled)
		document.forms[0].b_day.disabled=false;


	var dayy = document.forms[0].b_day;


	while ( dayy.options.length > 0 )
		dayy.remove(dayy.options[0]);

	var opt = document.createElement('OPTION');
	opt.text ="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value= '';
	document.forms[0].b_day.add(opt);
	if(document.forms[0].location.selectedIndex==0){
		opt1 = document.createElement("OPTION");
		opt1.text = '*All';
		opt1.value= '*A';
		document.forms[0].b_day.add(opt1);
	}

	var clinic_code	= document.forms[0].location.value ;
	//clinic_code=clinic_code.split("$");
	var clinic_code1=clinic_code.split("$");
	var cliniccode=clinic_code1[0];
	if (cliniccode != null && cliniccode!= "")
	{
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='populatepract' id='populatepract' method='post' action='../../eOA/jsp/TimeTablePract.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+cliniccode+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.populatepract.submit();
		document.forms[0].b_max_slots_for_first_visit.value="0";
	}
    else
	document.forms[0].pract_butt.disabled=true;
	document.getElementById("imgpract").style.visibility='hidden';
	document.forms[0].b_max_slots_for_first_visit.value="0";

	document.getElementById("location_code1").value= obj.value;
}
*/
function checkRoster(checkVal){
	if(checkVal==1){
		if(document.forms[0].practitioner.value==""){
			if(document.forms[0].b_roster_reqd){
				document.forms[0].b_roster_reqd.checked=false;
				document.forms[0].b_roster_reqd.disabled=true;
			}
		}else{
			var Obj=document.forms[0].resourceType;
			if((Obj.value=='R') ||(Obj.value=='E') || (Obj.value=='O')){
				if(document.forms[0].b_roster_reqd){
					document.forms[0].b_roster_reqd.checked=false;
					document.forms[0].b_roster_reqd.disabled=true;
				}
			}else{
				if(document.forms[0].b_roster_reqd){
					document.forms[0].b_roster_reqd.disabled=false;
				}
			}
		}
	}else{
		if(document.forms[0].b_roster_reqd){
			document.forms[0].b_roster_reqd.checked=false;
			document.forms[0].b_roster_reqd.disabled=true;
		}
	}
	if(document.forms[0].practitioner.value!=""){
		var rvalues=document.forms[0].location.value.split("$");
		//if(document.forms[0].b_day && open_all_pract_yn=='Y'){
		if(document.forms[0].b_day){
		if(rvalues[2]=='N' ||(document.getElementById("resourceType").value!='P' && rvalues[2]=='Y')){
			populatePractitioner();
			}
		}
	}
}
//new function TimePerPatientValid_new() Added by S.Sathish for IN020308 on Thursday, April 01, 2010
function TimePerPatientValid_new()
{ 		
	var time_table_type  	= frames[1].document.forms[0].time_table_type.value ;
	var time_per_patient 	= frames[1].document.forms[0].time_per_patient.value ;
	var start_time	     	= frames[1].document.forms[0].start_time.value ;
	var end_time	     	=frames[1].document.forms[0].end_time.value ;
	var dummytime 		= '00:00' ;
	var dummyarray		;

	var l_total_time	;
	var l_time_per_patient	;
	var l_max_pat	 	;
	var l_max_pat_category	= "1";

	var tpparray 		;
	var endarray		;
	var tpptime		;
	var endtime		;
	var startarray		;
	var starttime		;
	dummyarray 		= dummytime.split(":") ;
	dumtime    		= new Date(1,1,1,dummyarray[0],dummyarray[1],0,0) ;

	tpparray		= time_per_patient.split(":") ;
	endarray		= end_time.split(":") ;
	startarray		= start_time.split(":") ;

	tpptime			= new Date(1,1,1,tpparray[0],tpparray[1],0,0) ;
	endtime			= new Date(1,1,1,endarray[0],endarray[1],0,0) ;
	starttime		= new Date(1,1,1,startarray[0],startarray[1],0,0) ;


	if (time_table_type  == "1")
	{
		if (time_per_patient.length != 0)
		{
			if ((time_per_patient <= "0") || (Date.parse(tpptime) > Date.parse(endtime)))
			{
					var invalid_tpp	     = getMessage('INVALID_TM_PR_PAT','OA') ;
					alert(invalid_tpp) ;
					if (frames[1].document.forms[0].fmode.value=='insert'){
					frames[1].document.forms[0].time_per_patient.value='';
					frames[1].document.forms[0].time_per_patient.focus();
					}else{
					frames[1].document.forms[0].end_time.value='';
					frames[1].document.forms[0].end_time.focus();
					}
			}
			else if ((tpptime - dumtime) > (endtime - starttime))
			{
					var invalid_mtpp	     = getMessage('INVALID_TM_PR_PAT','OA') ;
					alert(invalid_mtpp) ;
					if (frames[1].document.forms[0].fmode.value=='insert'){
					frames[1].document.forms[0].time_per_patient.value='';
					frames[1].document.forms[0].time_per_patient.focus();
					}
					else{
					frames[1].document.forms[0].end_time.value='';
					frames[1].document.forms[0].end_time.focus();
					}
			}
			else if ((start_time.length != 0) && (end_time.length !=0) && (time_per_patient.length != 0))
				{	
				
					var x=frames[1].document.forms[0].time_per_patient.value;
				var y=frames[1].document.forms[0].hddDur.value;

				var arr1=x.split(":");
				var arr2=y.split(":");
				

				//var dur=parseInt('10');
				var dur=(parseInt(arr2[0])*60) + parseInt(arr2[1]);
				var indur=(parseInt(arr1[0])*60) + parseInt(arr1[1]);
				var modu=indur % dur;			
				
				if(modu>0){
					var error=getMessage("TIME_DEFAULT_DURATION","OA");
					alert(error +y);
					frames[1].document.forms[0].time_per_patient.value=y;
				}else{					
						var calling_from='apply';					
						var xmlDoc = ""
						var xmlHttp = new XMLHttpRequest()
						xmlStr ="<root><SEARCH calling_from=\""+calling_from+"\" starttime=\""+start_time+"\" endtime=\""+end_time+"\"  timeperpatient=\""+time_per_patient+"\"  maxpatcat=\""+l_max_pat_category+"\" /></root>"
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
						xmlHttp.open("POST","SetUpDailyScheduleMaxPatients.jsp",false);
						xmlHttp.send(xmlDoc)
						responseText=xmlHttp.responseText;
						responseText = trimString(responseText);
						eval(responseText);							
						var result=frames[1].document.forms[0].result.value;	
						if(result=="1")
							return false;
						else
							return true;	
					}					
					}
									
			}
		}
}
//new function MaxPatPerSlab_new() Added by S.Sathish for IN020308 on Thursday, April 01, 2010

function MaxPatPerSlab_new(){	
	
	var timetabletype 	= frames[1].document.forms[0].time_table_type.value ;
	var l_max_pat_category	= "2" ;
	var start_time	     	= frames[1].document.forms[0].start_time.value ;
	var end_time	     	= frames[1].document.forms[0].end_time.value ;
	var l_time_per_slab	= frames[1].document.forms[0].time_per_slab.value ;
	var l_max_pat_per_slab	= frames[1].document.forms[0].max_patients_per_slab.value ;	
	
	if (timetabletype == '2'){	
			if (l_max_pat_per_slab!=""){
					var calling_from='apply';					
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH calling_from=\""+calling_from+"\" starttime=\""+start_time+"\" endtime=\""+end_time+"\"  timeperslab=\""+l_time_per_slab+"\"  maxpatperslab=\""+l_max_pat_per_slab+"\"  maxpatcat=\""+l_max_pat_category+"\"/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","SetUpDailyScheduleMaxPatients.jsp",false);
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText;
					responseText = trimString(responseText);
					eval(responseText);							
					var result=frames[1].document.forms[0].result.value;						
					if(result=="1")
						return false;
					else
						return true;
				
			}
		}
}

//new function movfocus() Added by S.Sathish for IN020308 on Thursday, April 01, 2010

function movfocus()
{
	frames[1].document.forms[0].end_time.focus();
}


// New Enhancement for Rutnin CRF
function NewOldPatValidation(obj){
	if(obj.name=='max_new_patients' && obj.value !=""){
		var max_patients_per_day=parseInt(parent.f_query_add_mod.SetUpDailySchedule.max_patients_per_day.value);
		var max_new_patients=parseInt(parent.f_query_add_mod.SetUpDailySchedule.max_new_patients.value);
		if(max_new_patients > max_patients_per_day){
			var error = getMessage("CAN_NOT_BE_GRTR","OA");
			error = error.replace('$',getLabel("eOA.MaxNewPat.label","OA"));
			error = error.replace('#',getLabel("eOA.maxpatperday.label","OA"));
			alert(error);
			obj.focus();
			obj.select();
		}else{
			parent.f_query_add_mod.SetUpDailySchedule.max_old_patients.value = max_patients_per_day - max_new_patients;
		}
	}else if(obj.name=='max_old_patients' && obj.value !=""){
		var max_patients_per_day=parseInt(parent.f_query_add_mod.SetUpDailySchedule.max_patients_per_day.value);
		var max_old_patients=parseInt(parent.f_query_add_mod.SetUpDailySchedule.max_old_patients.value);
		if(max_old_patients > max_patients_per_day){
			var error = getMessage("CAN_NOT_BE_GRTR","OA");
			error = error.replace('$',getLabel("eOA.MaxOldPat.label","OA"));
			error = error.replace('#',getLabel("eOA.maxpatperday.label","OA"));
			alert(error);
			obj.focus();
			obj.select();
		}else{
			parent.f_query_add_mod.SetUpDailySchedule.max_new_patients.value = max_patients_per_day - max_old_patients;
		}
	}
}

/*Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112*/
function ScheduleExtendYN(obj)
{
  if(obj.checked==true){
	document.forms[0].schedule_extend_yn.value="Y";
  }else{
	document.forms[0].schedule_extend_yn.value="N";
  }
}

function displayExtendTimeYN()
{
	if(document.forms[0].time_table_type.value == "3"){
		document.forms[0].schedule_extend_yn.checked=false;
		document.forms[0].schedule_extend_yn.value="N";
		document.getElementById("scheduleextendyn").style.display='none';
	}else{
		document.getElementById("scheduleextendyn").style.display='inline';
	}
}
/*End NMC-JD-CRF-0112*/

/*Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1*/
function ExtAllSlotsYN(obj)
{
  if(obj.checked==true){
	document.forms[0].ext_all_slots_yn.value="Y";
	document.forms[0].ext_start_slots.value="";
	document.forms[0].ext_start_slots.disabled=true;
	document.forms[0].ext_mid_slots.value="";
	document.forms[0].ext_mid_slots.disabled=true;
	document.forms[0].ext_end_slots.value="";
	document.forms[0].ext_end_slots.disabled=true;
  }else{
	document.forms[0].ext_all_slots_yn.value="N";
	document.forms[0].ext_start_slots.value="";
	document.forms[0].ext_start_slots.disabled=false;
	document.forms[0].ext_mid_slots.value="";
	document.forms[0].ext_mid_slots.disabled=false;
	document.forms[0].ext_end_slots.value="";
	document.forms[0].ext_end_slots.disabled=false;
  }
}

function displayExtSlotsYN()
{
	if(document.forms[0].time_table_type.value != ""){
		if(document.forms[0].time_table_type.value == "3"){
			document.forms[0].ext_all_slots_yn.checked=false;
			document.forms[0].ext_all_slots_yn.value="N";
			document.forms[0].ext_start_slots.value="";
			document.forms[0].ext_mid_slots.value="";
			document.forms[0].ext_end_slots.value="";
			document.getElementById("allslots").style.display='none';
			document.getElementById("StartMidEnd").style.display='none';
		}else{
			document.getElementById("allslots").style.display='inline';
			document.getElementById("StartMidEnd").style.display='inline';
			if(document.forms[0].ext_all_slots_yn.checked == true)
			{
				document.forms[0].ext_start_slots.disabled=true;
				document.forms[0].ext_mid_slots.disabled=true;
				document.forms[0].ext_end_slots.disabled=true;
			}
		}
	}
}

function timetableOnChangeExtSlotsYN()
{
	if(document.forms[0].time_table_type.value == "3" || document.forms[0].time_table_type.value == ""){
		document.forms[0].ext_all_slots_yn.checked=false;
		document.forms[0].ext_all_slots_yn.value="N";
		document.forms[0].ext_start_slots.value="";
		document.forms[0].ext_mid_slots.value="";
		document.forms[0].ext_end_slots.value="";
		document.getElementById("allslots").style.display='none';
		document.getElementById("StartMidEnd").style.display='none';
	}else{
		document.getElementById("allslots").style.display='inline';
		document.getElementById("StartMidEnd").style.display='inline';
		document.forms[0].ext_all_slots_yn.checked=false;
		document.forms[0].ext_all_slots_yn.value="N";
		document.forms[0].ext_start_slots.value="";
		document.forms[0].ext_start_slots.disabled=false;
		document.forms[0].ext_mid_slots.value="";
		document.forms[0].ext_mid_slots.disabled=false;
		document.forms[0].ext_end_slots.value="";
		document.forms[0].ext_end_slots.disabled=false;
	}
}
/*End ML-BRU-CRF-0628.1*/

