var newStr = "" ;
var gvar   = new Array() ;
var pvar   = new Array() ;
var status = 'Y' ;
var status1 = 'N' ;
var endTimeFlag=false;

function create()
{
	f_query_add_mod.location.href = '../../eOA/jsp/SetUpDailyScheduleHeader.jsp?function_mode=insert&function_type=timetable&oper_stn_id='+document.getElementById("oper").value ;
}

function reset()
{
	if (f_query_add_mod.document.forms[0])
		{
		f_query_add_mod.document.location.reload();
		}else
		{
				var Obj=frames[1].frames[0].forms[0].b_no_forced_booking;
				var FBking=frames[1].frames[0].document.forms[0].b_forced_allowed_yn;
				frames[1].frames[0].document.getElementById("forced").style.visibility="hidden";
				frames[1].breaktime.document.forms[0].reset();

			if(f_query_add_mod.document.frames[0].document.forms[0].function_mode)
				{
					f_query_add_mod.document.frames[0].document.forms[0].reset();
				}else{
					f_query_add_mod.document.frames[0].document.forms[0].reset();
					f_query_add_mod.document.frames[1].frames[0].document.forms[0].reset();
				}
					
			  if (f_query_add_mod.document.frames[0].document.forms[0].function_mode)
			  {  
				 if (f_query_add_mod.document.frames[0].document.forms[0].function_mode.value=='insert')
				 {

				 if (!f_query_add_mod.document.frames[0].document.forms[0].b_roster_reqd.disabled)
				 {
					 f_query_add_mod.document.frames[0].document.forms[0].b_roster_reqd.disabled=true;
				 }
				  obj=f_query_add_mod.document.frames[0].document.forms[0].b_clinic
				  var len=obj.options.length;
				  var i=0;
				  while(i<len)
				  obj.remove(obj.options[i++]);
				  opt=f_query_add_mod.document.frames[0].document.createElement('OPTION');
				  opt.value='';
				  opt.text='  ---Select---  ';
				  obj.add(opt);
				  f_query_add_mod.document.frames[0].document.forms[0].resource.disabled=true;
			  
				  objTimeTableType=f_query_add_mod.document.frames[0].document.forms[0].b_time_table_type;
				  if (objTimeTableType.options.length<4)
				  {
					  opt1=f_query_add_mod.document.frames[0].document.createElement('OPTION');
					  opt1.value='3';
					  opt1.text='Free Format';
					  objTimeTableType.add(opt1);
				  }
				}
			}
	
	
	if (f_query_add_mod.document.frames[0].document.forms[0].fmode.value!="modify")
	{
			
		if (f_query_add_mod.document.frames[0].document.getElementById("imgpract"))
		f_query_add_mod.document.frames[0].document.getElementById("imgpract").style.visibility='hidden'	
			
		f_query_add_mod.document.frames[0].document.getElementById("b_clinic").focus();
		f_query_add_mod.document.frames[0].document.getElementById("t_per_pat").style.visibility='hidden'
		f_query_add_mod.document.frames[0].document.getElementById("mx_pat_per_day").style.visibility='hidden'
		f_query_add_mod.document.frames[0].document.getElementById("t_per_slab").style.visibility='hidden'
		f_query_add_mod.document.frames[0].document.getElementById("mx_per_slab").style.visibility='hidden'
		f_query_add_mod.document.frames[0].document.getElementById("slot_or_pat_id1").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		f_query_add_mod.document.frames[0].document.getElementById("slot_or_pat_id2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		f_query_add_mod.document.frames[0].document.getElementById("slot_or_pat_id3").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		f_query_add_mod.document.frames[0].document.getElementById("pract_butt").disabled=true;
		f_query_add_mod.document.frames[0].document.getElementById("b_pract_name").disabled=true;
		f_query_add_mod.document.frames[0].document.getElementById("b_no_forced_booking").disabled=true;
		f_query_add_mod.document.frames[0].document.getElementById("b_forced_allowed_yn").disabled=true;
			
			
		if(f_query_add_mod.document.frames[0].document.forms[0].b_day.disabled)
		f_query_add_mod.document.frames[0].document.forms[0].b_day.disabled=false;

		while (f_query_add_mod.document.frames[0].document.forms[0].b_day.options.length =0)
		f_query_add_mod.document.frames[0].document.forms[0].b_day.remove(f_query_add_mod.document.frames[0].document.forms[0].b_day.options[0]);			
		
		opt = document.createElement("OPTION");
		opt.text = "----"+getLabel("Common.defaultSelect.label","Common")+"----";
		opt.value= '';
		opt1 = document.createElement("OPTION");
		opt1.text = '*All';
		opt1.value= '*A';
			
		f_query_add_mod.document.frames[0].document.forms[0].b_day.add(opt);
		f_query_add_mod.document.frames[0].document.forms[0].b_day.add(opt1);
	}
		
		f_query_add_mod.document.frames[0].document.forms[0].b_start_time.focus();
		f_query_add_mod.document.frames[0].document.getElementById("b_no_forced_booking").disabled=true;
  }

	if (f_query_add_mod.document.forms[0]){
	}else{
		if(f_query_add_mod.document.frames[0].document.forms[0].b_no_forced_booking.value=='0')
		{
		f_query_add_mod.document.frames[0].document.forms[0].b_forced_allowed_ynchecked.checked=false;
		f_query_add_mod.document.frames[0].document.forms[0].b_no_forced_booking.value='';	
		
		
		}
	}
}

function qryModify(locnDesc,locnCode,rs_type,p_clinic_code,p_pract_id,p_day_no,p_time_table_type)
{


parent.f_query_add_mod.location.href="../../eOA/jsp/SetUpDailyScheduleHeader.jsp?function_mode=modify&function_type=timetable&clinic_code="+p_clinic_code+"&practid="+p_pract_id+"&dayno="+p_day_no+"&timetabletype="+p_time_table_type+"&locn_care_ind="+locnCode+"&resource_class="+rs_type;
	
}


function query()
{
	//f_query_add_mod.location.href 	= '../../eOA/jsp/TimeTableQueryCriteria.jsp?mode=modify';
	f_query_add_mod.location.href 	= '../../eOA/jsp/SetUpDailyScheduleQueryCriteria.jsp?mode=modify&type=timetable' ;
}


var conf;
async function apply(){
	var url=f_query_add_mod.location.href;
	if ( url.indexOf("blank")==-1 && url.indexOf("QueryCriteria.jsp")==-1 && url.indexOf("QueryResult.jsp")==-1){
		var time_table_type	= f_query_add_mod.document.forms[0].time_table_type.value ;
		if (time_table_type == '1'){
			var fields = new Array ( f_query_add_mod.document.forms[0].b_loc_val,
       					 f_query_add_mod.document.forms[0].resourceType,
						 f_query_add_mod.document.forms[0].b_day,
						 f_query_add_mod.document.forms[0].time_table_type,
						 f_query_add_mod.document.forms[0].start_time,
						 f_query_add_mod.document.forms[0].end_time,
						 f_query_add_mod.document.forms[0].time_per_patient,
						 f_query_add_mod.document.forms[0].max_patients_per_day);
			if(f_query_add_mod.document.forms[0].slot_appt_ctrl.value =="P"){
				var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.days.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.TimeperPatient.label","OA"),
								getLabel("eOA.maxpatperday.label","OA"));
			}else{
				var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.days.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.TimeperSlot.label","OA"),
								getLabel("eOA.maxpatperday.label","OA"));
			}

		}else if (time_table_type == '2'){
			var fields = new Array (f_query_add_mod.document.forms[0].b_loc_val,
								f_query_add_mod.document.forms[0].resourceType,
								 f_query_add_mod.document.forms[0].b_day,
								 f_query_add_mod.document.forms[0].time_table_type,
								 f_query_add_mod.document.forms[0].start_time,
								 f_query_add_mod.document.forms[0].end_time,
								 f_query_add_mod.document.forms[0].time_per_slab,
								 f_query_add_mod.document.forms[0].max_patients_per_slab);

			var names = new Array ( getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.days.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.timeperslab.label","OA"),
								getLabel("eOA.maxpatperslab.label","OA"));
		}else{
			var fields = new Array ( f_query_add_mod.document.forms[0].b_loc_val,
					f_query_add_mod.document.forms[0].resourceType,
					 f_query_add_mod.document.forms[0].b_day,
					 f_query_add_mod.document.forms[0].time_table_type,
					 f_query_add_mod.document.forms[0].start_time,
					f_query_add_mod.document.forms[0].end_time,
					 f_query_add_mod.document.forms[0].max_patients_per_day) ;

			var names = new Array (getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.days.label","Common"),
								getLabel("eOA.TimeTableType.label","OA"),
								getLabel("Common.StartTime.label","Common"),
								getLabel("Common.EndTime.label","Common"),
								getLabel("eOA.maxpatperday.label","OA"));
		}
		if(f_query_add_mod.document.forms[0].rule_appl_yn.value =="Y"){
			fields.push(f_query_add_mod.document.forms[0].max_new_patients);
			fields.push(f_query_add_mod.document.forms[0].max_old_patients);
			names.push("Max New Patients");
			names.push("Max Old Patients");	
		}
		if (f_query_add_mod.document.forms[0].function_mode.value=='insert'){
			if(f_query_add_mod.document.getElementById("imgpract").style.visibility=="visible"){
				fields[fields.length]=f_query_add_mod.document.forms[0].practitioner;
				names[names.length]=getLabel("Common.resourcename.label","Common");
			}	 
		}
		var Flag=0;
     	

     	if ( (Flag==0)){
			if(!f_query_add_mod.checkFields(fields, names, messageFrame)){
			}else{
				//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
				var proceed_yn = "Y";
				var isScheduleExtendAppl = f_query_add_mod.document.forms[0].isScheduleExtendAppl.value ;
				var schedule_extend_param = f_query_add_mod.document.forms[0].schedule_extend_param.value ;

				if(isScheduleExtendAppl == "true" && schedule_extend_param == "Y")
				{
				var schedule_extend_yn = f_query_add_mod.document.forms[0].schedule_extend_yn.value ;
				var endtime = f_query_add_mod.document.forms[0].end_time.value ;

				if(schedule_extend_yn == "Y" && time_table_type != "3" && endtime != "")
				{
					if(endtime == "23:59")
					{
						alert(getMessage("END_TIME_ALREADY_EXTENDED","OA"));
						f_query_add_mod.document.forms[0].schedule_extend_yn.checked=false;
						f_query_add_mod.document.forms[0].schedule_extend_yn.value="N";
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
							var time_per_slot = f_query_add_mod.document.forms[0].time_per_patient.value ;
							if(time_per_slot != "" && time_diff > time_per_slot){
								alert(getMessage("CANNOT_EXTEND_SCHEDULE","OA"));
								f_query_add_mod.document.forms[0].end_time.select();
								f_query_add_mod.document.forms[0].end_time.focus();
								proceed_yn = "N";
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
								return false;
							}
							
						}else if(time_table_type == "2"){
							var time_per_slab = f_query_add_mod.document.forms[0].time_per_slab.value ;
							if(time_per_slab != "" && time_diff > time_per_slab){
								alert(getMessage("CANNOT_EXTEND_SCHEDULE","OA"));
								f_query_add_mod.document.forms[0].end_time.select();
								f_query_add_mod.document.forms[0].end_time.focus();
								proceed_yn = "N";
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
								return false;
							}
						}
					}
				}
				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				var isSlotStartMidEndAppl = f_query_add_mod.document.forms[0].isSlotStartMidEndAppl.value;
				
				if(isSlotStartMidEndAppl == "true" && time_table_type != "3"){
					var ext_start_slots = f_query_add_mod.document.forms[0].ext_start_slots.value ;
					if(ext_start_slots == "")ext_start_slots = 0;
					var ext_mid_slots = f_query_add_mod.document.forms[0].ext_mid_slots.value ;
					if(ext_mid_slots == "")ext_mid_slots = 0;
					var ext_end_slots = f_query_add_mod.document.forms[0].ext_end_slots.value ;
					if(ext_end_slots == "")ext_end_slots = 0;
					var max_pat_per_day_cnt = f_query_add_mod.document.forms[0].max_patients_per_day.value;
					var max_patients_per_slab_cnt = f_query_add_mod.document.forms[0].max_patients_per_slab.value;

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
				var toSubmit 	= new Boolean() ;
				toSubmit	= true ;
				if (f_query_add_mod.document.forms[0].function_mode.value=='insert' || f_query_add_mod.document.forms[0].fmode.value == 'modify'){
					var clinic_code	= f_query_add_mod.document.forms[0].location.value ;
					var pract_code	= f_query_add_mod.document.forms[0].practitioner.value ;

					var day_no	= "";
					if(f_query_add_mod.document.forms[0].function_mode.value=='insert'){
						day_no	= f_query_add_mod.document.forms[0].b_day.value ;
					}else if(f_query_add_mod.document.forms[0].fmode.value == 'modify'){
						day_no	= f_query_add_mod.document.forms[0].day_no_modify.value ;
					}
					var resourceClass=f_query_add_mod.document.forms[0].resourceType.value;
					var start_time = f_query_add_mod.document.forms[0].start_time.value;
					var end_time = f_query_add_mod.document.forms[0].end_time.value;

					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					var clinic_code1=clinic_code.split("$");
					var cliniccode=clinic_code1[0]
					xmlStr ="<root><SEARCH cliniccode=\""+cliniccode+"\" practcode=\""+pract_code+"\" dayno=\""+day_no+"\" resourceClass=\""+resourceClass+"\" start_time=\""+start_time+"\"  end_time=\""+end_time+"\"  from='apply' mode='"+f_query_add_mod.document.forms[0].fmode.value+"' rule_appl_yn='"+f_query_add_mod.document.forms[0].rule_appl_yn.value+"' /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","TimeTableCheckDuplicate.jsp",false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText;
					responseText =trimString(responseText);
					eval(responseText);
					if(!toSubmit){
						return false;
					}
				}
				if (time_table_type=='3'){
					var OB_flag=MaxOverBookings(f_query_add_mod.document.forms[0].max_over_bookings);
					if (!OB_flag && OB_flag!=null){
						f_query_add_mod.document.forms[0].b_max_over_bookings.value="";
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
						return false;
					}
				}
				//Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010

				/*if (time_table_type=="1")
				{
					f_query_add_mod.document.forms[0].time_per_slab.disabled 		= false ;
					f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false ;
				}
				else if (time_table_type=="2")
				{
					f_query_add_mod.document.forms[0].time_per_patient.disabled 		= false ;
					f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false ;
				}
				else if (time_table_type=="3")
				{
					f_query_add_mod.document.forms[0].time_per_patient.disabled 		= false ;
					f_query_add_mod.document.forms[0].time_per_slab.disabled 		= false ;
					f_query_add_mod.document.forms[0].max_patients_per_slab.disabled 	= false ;
					f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false ;
				}*/	
				var startarray;
				var endarray  ;
				var starttime =f_query_add_mod.document.forms[0].start_time.value ;
				var endtime   = f_query_add_mod.document.forms[0].end_time.value ;
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
				var p_from_time1="";
				var p_to_time1="";
				var p_from_time2="";
				var p_to_time2="";
				var p_from_time3="";
				var p_to_time3="";
				var p_from_time4="";
				var p_to_time4="";
				var p_from_time5="";
				var p_to_time5="";
				var time_per_patient = f_query_add_mod.document.forms[0].time_per_patient.value ;
				var tpparray  ;
				var timeperpatient ;
				var time_per_slab    = f_query_add_mod.document.forms[0].time_per_slab.value ;
				var tpsarray  ;
				var timeperslab ;
				var time_table_type  = f_query_add_mod.document.forms[0].time_table_type.value ;
				var start_time1      = f_query_add_mod.document.forms[0].start_time.value ;
				var end_time1        = f_query_add_mod.document.forms[0].end_time.value ;

				var max_first_visit  = f_query_add_mod.document.forms[0].max_first_visit.value;	
				var max_over_bookings = f_query_add_mod.document.forms[0].max_over_bookings.value;
				var max_pat_per_day  = f_query_add_mod.document.forms[0].max_patients_per_day.value;
				var maxpat	;
				//var toSubmit 	= new Boolean() ;
				//toSubmit	= true ;
				var to_submit1 	= new Boolean() ;
				to_submit1	= true ;
				var allow_three 	= new Boolean() ;
				allow_three	= true ;
				var toBreakTime	= new Boolean() ;
				toBreakTime	= true ;
				p_from_time1 	=	f_query_add_mod.document.forms[0].from_time1.value ;
				p_to_time1 	=	f_query_add_mod.document.forms[0].to_time1.value ;
				p_from_time2 	=	f_query_add_mod.document.forms[0].from_time2.value ;
				p_to_time2 	=	f_query_add_mod.document.forms[0].to_time2.value ;
				p_from_time3 	=	f_query_add_mod.document.forms[0].from_time3.value ;
				p_to_time3 	=	f_query_add_mod.document.forms[0].to_time3.value ;
				p_from_time4 	=	f_query_add_mod.document.forms[0].from_time4.value ;
				p_to_time4 	=	f_query_add_mod.document.forms[0].to_time4.value ;
				p_from_time5 	=	f_query_add_mod.document.forms[0].from_time5.value ;
				p_to_time5 	=	f_query_add_mod.document.forms[0].to_time5.value ;	
				olStr		= p_from_time1 + '-' + p_to_time1 + ',' + p_from_time2 + '-' + p_to_time2 + ',' + p_from_time3 + '-' + p_to_time3 + ',' ;
				olStr	       += p_from_time4 + '-' + p_to_time4 + ',' + p_from_time5 + '-' + p_to_time5 + ',';	
				gvar		= olStr.split(",");
				var sttime= f_query_add_mod.document.forms[0].start_time.value;
				var edtime= f_query_add_mod.document.forms[0].end_time.value;
				fromarray= sttime.split(":") ;
				toarray  = edtime.split(":") ;
				fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
				totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;
				if(fromtime >= totime ){
					var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OA");
					status1 = 'Y' ;
					alert(errors);
					toSubmit = false;
					f_query_add_mod.document.forms[0].end_time.focus();
					f_query_add_mod.document.forms[0].end_time.select();
				}
				outerforloop: for (var i=0;i<5;i++){
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

					if ((fromarray.length < 2) && (toarray.length == 2)){
						toBreakTime = false;
					}else if ((toarray.length < 2) && (fromarray.length == 2)){
						toBreakTime = false;
					}
					if(fromtime >= totime ){
						var errors = getMessage("TO_TM_CANT_GR_FROM_TM","OA");
						status1 = 'Y' ;
						alert(errors);
						toSubmit = false;
					}
					if (toSubmit){

					if (Date.parse(fromtime) < Date.parse(starttime2))
					{
					var errors = getMessage("BR_TM_NOT_VALID","OA");
					alert(errors);
					toSubmit = false;
					to_submit1 = false;
					parent.parent.frames[1].document.f_query_add_mod.document.forms[0].start_time.focus()
					}

					else if (Date.parse(fromtime) > Date.parse(endtime2))
					{
					var errors = getMessage("BR_TM_NOT_VALID","OA");
					alert(errors);
					toSubmit = false;
					to_submit1 = false;
					parent.parent.frames[1].document.f_query_add_mod.document.forms[0].start_time.focus()
					}
					else if ( ( Date.parse(fromtime) == Date.parse(starttime2)) &&( Date.parse(totime) == Date.parse(endtime2))			)
					{
					var errors = getMessage('BR_TM_NOT_VALID',"OA");
					alert(errors);
					toSubmit = false;
					to_submit1 = false;

					parent.parent.frames[1].document.f_query_add_mod.document.forms[0].start_time.focus()
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

						for (var i=0;i<5;i++){
							frtotime = pvar[i] ;
							fromarray= frtotime.substring(0,5).split(":") ;
							toarray  = frtotime.substring(5,10).split(":") ;
							fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
							totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;
							if ((fromarray != '') && (fromarray != null)){
								if ((toarray != '') && (toarray != null)){
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
							
								var t_type=f_query_add_mod.document.forms[0].time_table_type.value;
								var time_dur='';
								var strt_tm=f_query_add_mod.document.forms[0].start_time.value;

								if(t_type=='2'){
									time_dur=f_query_add_mod.document.forms[0].time_per_slab.value;
								}else{
									time_dur=f_query_add_mod.document.forms[0].time_per_patient.value;
								}
					
								var brk_flg=true;

								if(time_dur!=''){
							
								var arr1=strt_tm.split(":");
								var arr2=time_dur.split(":");
								
								var dur=(parseInt(arr2[0],10)*60) + parseInt(arr2[1]);
								var strt=(parseInt(arr1[0],10)*60) + parseInt(arr1[1]);
								

									if(f_query_add_mod.document.forms[0].from_time1.value!=''){
										var arr3=f_query_add_mod.document.forms[0].from_time1.value.split(":");
										var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);	
										var modu=(br-strt) % dur;
										if(modu>0){
											alert(getMessage("BR_NT_ML_ST","OA"));
											f_query_add_mod.document.forms[0].from_time1.focus();
											brk_flg=false;
										}
									}

									if(brk_flg){
										if(f_query_add_mod.document.forms[0].to_time1.value!=''){
											var arr3=f_query_add_mod.document.forms[0].to_time1.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].to_time1.focus();
												brk_flg=false;
											}
										}
									}

									if(brk_flg){
										if(f_query_add_mod.document.forms[0].from_time2.value!=''){
											var arr3=f_query_add_mod.document.forms[0].from_time2.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].from_time2.focus();
												brk_flg=false;
											}
										}
									}

									if(brk_flg){
										if(f_query_add_mod.document.forms[0].to_time2.value!=''){
											var arr3=f_query_add_mod.document.forms[0].to_time2.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].to_time2.focus();
												brk_flg=false;
											}
										}
									}
									
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].from_time3.value!=''){
											var arr3=f_query_add_mod.document.forms[0].from_time3.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].from_time3.focus();
												brk_flg=false;
											}
										}
									}
									
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].to_time3.value!=''){
											var arr3=f_query_add_mod.document.forms[0].to_time3.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].to_time3.focus();
												brk_flg=false;
											}
										}
									}
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].from_time4.value!=''){
											var arr3=f_query_add_mod.document.forms[0].from_time4.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].from_time4.focus();
												brk_flg=false;
											}
										}
									}
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].to_time4.value!=''){
											var arr3=f_query_add_mod.document.forms[0].to_time4.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].to_time4.focus();
												brk_flg=false;
											}
										}
									}
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].from_time5.value!=''){
											var arr3=f_query_add_mod.document.forms[0].from_time5.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].from_time5.focus();
												brk_flg=false;
											}
										}
									}	
									if(brk_flg){
										if(f_query_add_mod.document.forms[0].to_time5.value!=''){
											var arr3=f_query_add_mod.document.forms[0].to_time5.value.split(":");
											var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
											var modu=(br-strt) % dur;	
											if(modu>0){
												alert(getMessage("BR_NT_ML_ST","OA"));
												f_query_add_mod.document.forms[0].to_time5.focus();
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
							{	/*Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here */		
								/*alert("b_max_slots_per_day---->"+f_query_add_mod.document.forms[0].b_max_slots_per_day.value);
									if(time_table_type == '1'){			
										var proceed=TimePerPatientValid_new();									
										if(proceed == false){				
											f_query_add_mod.document.forms[0].start_time.focus();
											f_query_add_mod.document.forms[0].start_time.onblur = new Function('movfocus()');
											frames[0].document.location.reload();
											messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
											return false;								
										   }							
									   }
									   var l_time_per_slab	= f_query_add_mod.document.forms[0].time_per_slab.value ;
									   var l_max_pat_per_slab	= f_query_add_mod.document.forms[0].max_patients_per_slab.value ;

									   if(time_table_type == '2'){							   
										   if (l_time_per_slab != ""){
											if (l_max_pat_per_slab <=0 && l_max_pat_per_slab!=""){
													alert(getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common"));
													f_query_add_mod.document.forms[0].max_patients_per_slab.focus();
													frames[0].document.location.reload();
													return false;
												  }
												}
										var proceed=MaxPatPerSlab_new();								
										if(proceed == false){	
											f_query_add_mod.document.forms[0].start_time.focus();
											f_query_add_mod.document.forms[0].start_time.onblur = new Function('movfocus()');
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
									var max_slot_per_day_old=f_query_add_mod.document.forms[0].b_max_slots_per_day.value;							
									var max_slot_per_day_temp = (totaltime / timerinseconds) - breakdiff ;
									max_slot_per_day_temp=max_slot_per_day_temp;				
									
									if((''+max_slot_per_day_temp).indexOf (".") != -1 ){
										alert(getMessage("INVALID_CLINIC_SPAN_TIME","OA"));
										f_query_add_mod.document.forms[0].start_time.focus();
										messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
										return false;
									}
									if (max_slot_per_day_temp!=f_query_add_mod.document.forms[0].b_max_slots_per_day.value)
									{							
										f_query_add_mod.document.forms[0].max_patients_per_day.value = max_slot_per_day_temp ;
										f_query_add_mod.document.forms[0].b_max_slots_per_day.value = max_slot_per_day_temp ;			
										var conf = confirm(getMessage("MAX_PAT_RECALCULATED","OA") );							
										if(conf == false)						
										{	
												f_query_add_mod.document.forms[0].max_patients_per_day.value = max_slot_per_day_old ;
												f_query_add_mod.document.forms[0].b_max_slots_per_day.value = max_slot_per_day_old ;
												messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";			
												return false;
										}
								
									//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
									if(isSlotStartMidEndAppl == "true"){
										var ext_start_slots = f_query_add_mod.document.forms[0].ext_start_slots.value ;
										if(ext_start_slots == "")ext_start_slots = 0;
										var ext_mid_slots = f_query_add_mod.document.forms[0].ext_mid_slots.value ;
										if(ext_mid_slots == "")ext_mid_slots = 0;
										var ext_end_slots = f_query_add_mod.document.forms[0].ext_end_slots.value ;
										if(ext_end_slots == "")ext_end_slots = 0;
										var max_pat_per_day_cnt = f_query_add_mod.document.forms[0].max_patients_per_day.value;

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
							if(	f_query_add_mod.document.forms[0].function_mode.value!="modify"){
								if ((f_query_add_mod.document.forms[0].max_patients_per_day.value).length>3){			
									alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
									f_query_add_mod.document.forms[0].max_patients_per_day.value='' ;
									f_query_add_mod.document.forms[0].time_per_patient.value='';
									f_query_add_mod.document.forms[0].time_per_patient.focus();
									f_query_add_mod.document.forms[0].time_per_patient.select();		
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
									return false;
								}	
							}
							else
							{
								if ((f_query_add_mod.document.forms[0].max_patients_per_day.value).length>3){					
									alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
									f_query_add_mod.document.forms[0].end_time.value='' ;
									f_query_add_mod.document.forms[0].end_time.focus();
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
									return false;
								}
							}
						}

						if (time_table_type == '2')
						{
							 maxpat = ((totaltime / timerinseconds) * f_query_add_mod.document.forms[0].max_patients_per_slab.value);        
							 if((''+maxpat).indexOf (".") != -1 ){
									alert(getMessage("INVALID_CLINIC_SPAN_TIME","OA"));
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
									f_query_add_mod.document.forms[0].start_time.focus();
									return false;
								}
								f_query_add_mod.document.forms[0].max_patients_per_day.value =  maxpat - (breakdiff * f_query_add_mod.document.forms[0].max_patients_per_slab.value);		
								//Added by S.Sathish for IN020308 on Thursday, April 01, 2010
								//f_query_add_mod.document.forms[0].max_other_visits.value=f_query_add_mod.document.forms[0].max_patients_per_day.value;	@UAT-3		
							if ((f_query_add_mod.document.forms[0].max_patients_per_day.value).length>3){			
									alert(getMessage("MAX_PAT_NOT_EXCEED","OA"));
									if(	f_query_add_mod.document.forms[0].function_mode.value!="modify"){
									f_query_add_mod.document.forms[0].max_patients_per_day.value='';
									f_query_add_mod.document.forms[0].max_patients_per_slab.value='';
									f_query_add_mod.document.forms[0].max_patients_per_slab.focus();
									allow_three=false;
									}
									else{
									f_query_add_mod.document.forms[0].end_time.focus();
									f_query_add_mod.document.forms[0].end_time.value='';
									}
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
									return false;
						   }
					
					if(max_pat_per_day  != f_query_add_mod.document.forms[0].max_patients_per_day.value){		
						var conf =confirm(getMessage("MAX_PAT_RECALCULATED","OA"));
						if(conf == false)
						{
							f_query_add_mod.document.forms[0].max_patients_per_day.value=max_pat_per_day;
							//f_query_add_mod.document.forms[0].max_other_visits.value=max_pat_per_day;
							messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";							
							return false;
						}
						
						//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
						if(isSlotStartMidEndAppl == "true"){
							var ext_start_slots = f_query_add_mod.document.forms[0].ext_start_slots.value ;
							if(ext_start_slots == "")ext_start_slots = 0;
							var ext_mid_slots = f_query_add_mod.document.forms[0].ext_mid_slots.value ;
							if(ext_mid_slots == "")ext_mid_slots = 0;
							var ext_end_slots = f_query_add_mod.document.forms[0].ext_end_slots.value ;
							if(ext_end_slots == "")ext_end_slots = 0;
							var max_pat_per_day_cnt = f_query_add_mod.document.forms[0].max_patients_per_day.value;
							var max_patients_per_slab_cnt = f_query_add_mod.document.forms[0].max_patients_per_slab.value;

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
								
						max_pat_per_day  = f_query_add_mod.document.forms[0].max_patients_per_day.value;
						if(!allow_three)		
						{
							if(max_pat_per_day.indexOf(".")!=-1)
							{
								alert(getMessage("LOCN_TIME_SPAN_MULTIPLE","OA"));
								 f_query_add_mod.document.forms[0].max_patients_per_day.value="";
								toSubmit = false;
							}else
							{
								toSubmit = true;	
							}	
						}
				}
				f_query_add_mod.document.forms[0].ftotstr.value = olStr ;
				max_pat_per_day  = f_query_add_mod.document.forms[0].max_patients_per_day.value;


							}
					}
					else
					{
						f_query_add_mod.document.forms[0].ftotstr.value = olStr ;
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
				starttime			= f_query_add_mod.document.forms[0].start_time.value ;
				start_appt_time     = f_query_add_mod.document.forms[0].start_appt_time.value ;
				var p_start_time     = f_query_add_mod.document.forms[0].p_start_time.value ;
				blk_time			= f_query_add_mod.document.forms[0].block_start_time.value;
				

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
						f_query_add_mod.document.forms[0].start_time.focus();
						toSubmit = false;
					}
				}
				
				if (blk_start != null)
				{
					if (Date.parse(blk_start) <= Date.parse(starttm)&&toSubmit)
					{
						var en_lt_st_tm = getMessage('BLOCK_EXISTS_BEFORE_ST_TIME',"OA");
						alert(en_lt_st_tm);
						f_query_add_mod.document.forms[0].start_time.focus();
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
				starttime			= f_query_add_mod.document.forms[0].end_time.value;
				start_appt_time     = f_query_add_mod.document.forms[0].end_appt_time.value;
				blk_time			= f_query_add_mod.document.forms[0].block_end_time.value;
				startarray			= starttime.split(":") ;
				endarray			= start_appt_time.split(":") ;
				blk_startarray		= blk_time.split(":") ;

				starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
				endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;
				blk_start =  new Date(1,1,1,blk_startarray[0],blk_startarray[1],0,0) ;	
				
				if (endtm != null)
				{
					if (Date.parse(starttm) <= Date.parse(endtm)&&toSubmit)
					{
						var en_lt_st_tm = getMessage('APPT_EXISTS_CANT_MDFY',"OA");
						alert(en_lt_st_tm);
						f_query_add_mod.document.forms[0].end_time.focus();
						toSubmit = false;
					}
				}
				
				if (blk_start != null)
				{
				  if (Date.parse(blk_start) <= Date.parse(starttm)&&toSubmit)
					{
						var en_lt_st_tm = getMessage('BLOCK_EXISTS_AFTER_ED_TIME',"OA");
						alert(en_lt_st_tm);
						f_query_add_mod.document.forms[0].end_time.focus();
						toSubmit = false;
					}
				}
				var v1="";
				if (f_query_add_mod.document.forms[0].max_first_visit.value!="")
					v1= parseInt(f_query_add_mod.document.forms[0].max_first_visit.value);
				else
					v1 =0;
				var v2= parseInt(f_query_add_mod.document.forms[0].first_visit_cnt.value);
					if(v1 < v2 &&toSubmit)
					{
					var m_n_l_f = getMessage('MAX_NOT_LESS_FV',"OA");
					alert(m_n_l_f);		
					f_query_add_mod.document.forms[0].max_first_visit.focus();
					toSubmit = false;
					}
					
				if (f_query_add_mod.document.forms[0].max_other_visits.value!="")
					v1= parseInt(f_query_add_mod.document.forms[0].max_other_visits.value);
				else
					v1 =0;
				var v2= parseInt(f_query_add_mod.document.forms[0].other_visit_cnt.value);
					if(v1 < v2 &&toSubmit)
					{
					var m_n_l_f = getMessage('MAX_NOT_LESS_OV',"OA");
					alert(m_n_l_f);		
					f_query_add_mod.document.forms[0].max_first_visit.focus();
					toSubmit = false;
					}
				if (f_query_add_mod.document.forms[0].max_over_bookings.value!="")
					v1= parseInt(f_query_add_mod.document.forms[0].max_over_bookings.value);
				else
					v1 =0;
				var v2= parseInt(f_query_add_mod.document.forms[0].overbook_cnt.value)
				if(v1 < v2 )
				{
					var m_n_l_o = getMessage('MAX_NOT_LESS_OB',"OA");
					alert(m_n_l_o);
					f_query_add_mod.document.forms[0].max_over_bookings.focus();
					toSubmit = false;
					}
									max_pat_per_day     = f_query_add_mod.document.forms[0].max_patients_per_day.value;
								var max_pat_per_slot    = f_query_add_mod.document.forms[0].b_max_slots_per_day.value;
								var visit_limit_rule    = f_query_add_mod.document.forms[0].visit_limit_rule.value;
								var slot_appt_ctrl      = f_query_add_mod.document.forms[0].slot_appt_ctrl.value;
								var b_time_table_type   = f_query_add_mod.document.forms[0].time_table_type.value;
								
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
								
								}else{ //Else added by S.Sathish for 22182 on Thursday, June 17, 2010	
										f_query_add_mod.document.forms[0].max_first_visit.value="";
										f_query_add_mod.document.forms[0].max_other_visits.value="";
								}

								var max_other_visit		= f_query_add_mod.document.forms[0].max_other_visits.value ;
								
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
							/*	if(b_time_table_type=="1")
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
										//alert("APP-OA0226 First Visit value and Other Visit value should be exact");
										alert(getMessage("FIRST_OTHER_VISIT_EXACT","OA"));
										toSubmit = false;
									}
								/*  if ( b_time_table_type!="1" || slot_appt_ctrl=="P"){
									  
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
									 }else if(b_time_table_type=="2" && (parseInt(max_first_visit)+parseInt(max_other_visit)) != parseInt(max_pat_per_day)){// @UAT-3 starts
											var errors = getMessage("SUM_MAX_OT_VI_EQ_MAX_PAT_PER_DAY","OA");
											errors = errors.replace("#",getLabel("Common.day.label","Common"));
											alert(errors);
											toSubmit = false;
									 }// @UAT-3 Ends
									}
								}
								else if (visit_limit_rule=="M"){
								 // if ( b_time_table_type=="1" || slot_appt_ctrl=="P"){commented by S.Sathish bcoz this msg displayed when the time table type is freeformat
									// if ( b_time_table_type=="1" && slot_appt_ctrl=="P"){
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
					//f_query_add_mod.document.forms[0].max_other_visits.value
					var tType=f_query_add_mod.document.forms[0].time_table_type.value;
					var Obj=f_query_add_mod.document.forms[0].no_of_forced_booking;
					var Obj1=f_query_add_mod.document.forms[0].no_of_global_booking;
					var FBking=f_query_add_mod.document.forms[0].forced_book_YN.checked;
					if(FBking){
						//if(Obj.name=='no_of_forced_booking'){
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
							if(parseInt(Obj.value)>parseInt(f_query_add_mod.document.forms[0].max_patients_per_day.value)){
								var errors =  getMessage("FORCED_GR_MAX_PAT","OA");
								alert (errors);
								toSubmit = false
								Obj.focus();
							}
							if(toSubmit){
								if(parseInt(Obj1.value)>parseInt(f_query_add_mod.document.forms[0].max_patients_per_day.value)){
									var errors = getMessage("GLOBAL_GR_MAX_PAT","OA");
									alert (errors);
									toSubmit = false;
									Obj1.focus();
								}
							}
						}else if(tType=='2'){
							l_max_pat_per_slot=(f_query_add_mod.document.forms[0].max_patients_per_day.value)/(f_query_add_mod.document.forms[0].max_patients_per_slab.value);
							if(parseInt(Obj.value)>parseInt(l_max_pat_per_slot)){
								var errors = getMessage("FORCED_GR_MAX_SLAB","OA");
								alert (errors);
								toSubmit = false;
								Obj.focus();
							}
							if(toSubmit){
								if(parseInt(Obj1.value)>parseInt(f_query_add_mod.document.forms[0].max_patients_per_day.value)){
									var errors = getMessage("GLOBAL_GR_MAX_PAT","OA");
									alert (errors);
									toSubmit = false;
									Obj1.focus();
								}
							}
						}else{
							//if(nam=='no_of_global_booking'){
								if(parseInt(Obj1.value)>parseInt(f_query_add_mod.document.forms[0].max_patients_per_day.value)){
									var errors =getMessage("GLOBAL_GR_MAX_PAT","OA");
									alert (errors);
									toSubmit = false;
									Obj1.focus();
								}
							//}
						}
					}
				}else{
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				}
				if( toSubmit){
					if(f_query_add_mod.document.forms[0].fmode.value == 'modify' && f_query_add_mod.document.forms[0].alcn_criteria.value != '' && (f_query_add_mod.document.forms[0].old_max_patients_per_day.value != f_query_add_mod.document.forms[0].max_patients_per_day.value ) ){
						var diff = eval(f_query_add_mod.document.forms[0].old_max_patients_per_day.value) - eval(f_query_add_mod.document.forms[0].max_patients_per_day.value);
						var incdec =  getLabel("eOA.Increased.label","OA");
						if(diff > 0) incdec = getLabel("Common.Decreased.label","Common");
						else diff = eval(f_query_add_mod.document.forms[0].max_patients_per_day.value) - eval(f_query_add_mod.document.forms[0].old_max_patients_per_day.value);
						var facilityid  = f_query_add_mod.document.forms[0].facility_id.value;
						var cliniccode = f_query_add_mod.document.forms[0].location.value;
						//var date = f_query_add_mod.document.forms[0].clinic_date.value;
						var practitionerid = f_query_add_mod.document.forms[0].practitioner.value;
						var alcncriteria = f_query_add_mod.document.forms[0].alcn_criteria.value;
						var allocation_changed = f_query_add_mod.document.forms[0].allocation_changed.value;
						var final_string = f_query_add_mod.document.forms[0].final_string.value;
						var max_patients_per_day = f_query_add_mod.document.forms[0].max_patients_per_day.value;
						var max_patients1 = f_query_add_mod.document.forms[0].max_patients1.value;
						var allocation_changed = f_query_add_mod.document.forms[0].allocation_changed.value;
						var alcn_criteria = f_query_add_mod.document.forms[0].alcn_criteria.value;
						var slots = diff 
						var features	= "dialogHeight:20; dialogWidth:32; scroll=no; status:no"; 
						if (allocation_changed=="N"&&alcn_criteria!=""){
							var params = "facility_id="+facilityid+"&location_code="+cliniccode+"&clinic_date="+date+"&practitioner_id="+practitionerid+"&slots_inc_dec="+slots+"&alcn_criteria="+alcncriteria+"&final_string="+final_string+"&allocation_changed="+allocation_changed+"&max_patients_per_day="+max_patients_per_day+"&inc_dec="+incdec+"&from=DS"; 
							var retVal = await window.showModalDialog("../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?"+params,arguments,features);
							if(retVal != null && retVal != '' && retVal != 'F'){
								f_query_add_mod.document.forms[0].insert_detail.value = 'Y';
								f_query_add_mod.document.forms[0].final_values.value = retVal;
								f_query_add_mod.document.forms[0].max_patients_per_day.readOnly 	= false;
								f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false;
								f_query_add_mod.document.forms[0].b_max_slots_per_day.disabled	=false;
								f_query_add_mod.document.forms[0].action="../../servlet/eOA.TimeTableServlet";				
								f_query_add_mod.document.forms[0].submit();
							}else{
								//alert('Total number of '+incdec+' SLOTS does not match SLOTS TO BE '+incdec+' .. Cannot proceed');
								var err1 = getMessage("SLOTS_MISMATCH","OA");
								err1 = err1.replace('$',incdec);
								alert(err1);
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
							}
						}else if (allocation_changed=="Y" && max_patients1!=max_patients_per_day&&final_string!=""){
							var params = "facility_id="+facilityid+"&location_code="+cliniccode+"&clinic_date="+date+"&practitioner_id="+practitionerid+"&slots_inc_dec="+slots+"&alcn_criteria="+alcncriteria+"&final_string="+final_string+"&allocation_changed="+allocation_changed+"&max_patients_per_day="+max_patients1+"&inc_dec="+incdec+"&from=DS"; 
							var retVal = await window.showModalDialog("../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?"+params,arguments,features);
							if(retVal != null && retVal != '' && retVal != 'F'){
								f_query_add_mod.document.forms[0].insert_detail.value = 'Y';
								f_query_add_mod.document.forms[0].final_values.value = retVal;
								f_query_add_mod.document.forms[0].max_patients_per_day.readOnly 	= false;
								f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false;
								f_query_add_mod.document.forms[0].b_max_slots_per_day.disabled		=false;
								f_query_add_mod.document.forms[0].action="../../servlet/eOA.TimeTableServlet";
								f_query_add_mod.document.forms[0].submit();
							}else{
								alert('Total number of '+incdec+' SLOTS does not match SLOTS TO BE '+incdec+' .. Cannot proceed');
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
							}
						}else{
							f_query_add_mod.document.forms[0].max_patients_per_day.readOnly 	= false;
							f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false;
							f_query_add_mod.document.forms[0].b_max_slots_per_day.disabled		=false;
							if(f_query_add_mod.document.forms[0].resourceType.disabled)
								f_query_add_mod.document.forms[0].resourceType.disabled=false;
							if(f_query_add_mod.document.forms[0].time_table_type.disabled)
								f_query_add_mod.document.forms[0].time_table_type.disabled=false;
							f_query_add_mod.document.forms[0].action="../../servlet/eOA.TimeTableServlet";			
							f_query_add_mod.document.forms[0].submit() ;
						}
					}else if(f_query_add_mod.document.forms[0].fmode.value == 'insert' || f_query_add_mod.document.forms[0].fmode.value == 'modify'){
						f_query_add_mod.document.forms[0].max_patients_per_day.readOnly 	= false;
						f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false;
						f_query_add_mod.document.forms[0].b_max_slots_per_day.disabled		=false;
						f_query_add_mod.document.forms[0].b_roster_reqd.disabled		=false;
							var fin_sting=	f_query_add_mod.document.forms[0].final_string.value;
							var max_patients=f_query_add_mod.document.forms[0].max_patients_per_day.value;
						if(f_query_add_mod.document.forms[0].resourceType.disabled)
							f_query_add_mod.document.forms[0].resourceType.disabled=false;
						if(f_query_add_mod.document.forms[0].time_table_type.disabled)
							f_query_add_mod.document.forms[0].time_table_type.disabled=false;
							
						//	var Obj4=f_query_add_mod.document.forms[0].clinic_date;
							var Obj5=f_query_add_mod.document.forms[0].location;
							var Obj6=f_query_add_mod.document.forms[0].practitioner;

							//cln_dt=Obj4.value;

							var val5  = new Array() ;
							val5 = Obj5.value.split("$");
							var cln_cd=val5[0].split("$");

							var val6  = new Array() ;
							val6 = Obj6.value.split("$");
							var practitioner=val6[0].split("$");	
									
				
							var fin_sting=f_query_add_mod.document.forms[0].final_string.value;
							var max_patients=f_query_add_mod.document.forms[0].max_patients_per_day.value;
							var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='checkMaxPatient' id='checkMaxPatient' method='post' action='../../eOA/jsp/ClinicAllocationChkMaxPat.jsp'><input type='hidden' name='fin_string' id='fin_string' value='"+fin_sting+"'><input type='hidden' name='max_patient' id='max_patient' value='"+max_patients+"'></form></body></html>";
							messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
							messageFrame.document.checkMaxPatient.submit();//calling TimeTableServlet for inserting time table			
					  
				}
					else
					{ 
						f_query_add_mod.document.forms[0].max_patients_per_day.readOnly 	= false;
						f_query_add_mod.document.forms[0].max_patients_per_day.disabled 	= false;
						f_query_add_mod.document.forms[0].b_max_slots_per_day.disabled		=false;	
						if(f_query_add_mod.document.forms[0].resourceType.disabled)
						  f_query_add_mod.document.forms[0].resourceType.disabled=false;
						if(f_query_add_mod.document.forms[0].time_table_type.disabled)
						  f_query_add_mod.document.forms[0].time_table_type.disabled=false;
						f_query_add_mod.document.forms[0].submit();
					}
				}else{

				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
					}
				}
			}/*break time end*/else{		
				var errors = getMessage("INVALID_BREAK_TIME","OA");
				alert(errors);
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			}
			}
			}
		}else{
			if(f_query_add_mod.document.frames[0].document.forms[0].function_mode.value=='insert')
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			else if(f_query_add_mod.document.frames[0].document.forms[0].function_mode.value=='modify')
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
			
		}
	}else
		commontoolbarFrame.document.location.reload();
	}

function StEdTimeCheck(obj,timemode)
{
	var startarray ;
	var endarray   ;
	var starttime  ;
	var endtime    ;
	var starttm    ;
	var endtm       ;
	var time_table_type  = parent.frames[0].document.forms[0].b_time_table_type.value ;
	var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK','Common') ;

	if (timemode == 'S')
	{

	if (parent.frames[0].document.forms[0].b_start_time.value.length == 2)
	{
		if (parent.frames[0].document.forms[0].b_start_time.value.substring(1,2) == ':')
		{
			parent.frames[0].document.forms[0].b_start_time.value = '0' + parent.frames[0].document.forms[0].b_start_time.value ;
		}

	}

	if (parent.frames[0].document.forms[0].b_start_time.value.length == 3)
	{
		if (parent.frames[0].document.forms[0].b_start_time.value.substring(0,1) == ':')
		{
			parent.frames[0].document.forms[0].b_start_time.value = '00' + parent.frames[0].document.forms[0].b_start_time.value ;
		}
	}

	}
	else if (timemode == 'E')
	{

	if (parent.frames[0].document.forms[0].b_end_time.value.length == 2)
	{
		if (parent.frames[0].document.forms[0].b_end_time.value.substring(1,2) == ':')
		{
			parent.frames[0].document.forms[0].b_end_time.value = '0' + parent.frames[0].document.forms[0].b_end_time.value ;
		}

	}

	if (parent.frames[0].document.forms[0].b_end_time.value.length == 3)
	{
		if (parent.frames[0].document.forms[0].b_end_time.value.substring(0,1) == ':')
		{
			parent.frames[0].document.forms[0].b_end_time.value = '00' + parent.frames[0].document.forms[0].b_end_time.value ;
		}

	}

	}

	return true;
}

function deleterecord()
{  

		
	if(frames[1].document.SetUpDailySchedule)
	{
	if(frames[1].document.forms[0].function_mode.value !='insert')
	{
		if(confirm(frames[1].getMessage('DELETE_RECORD','Common')))
		{
		frames[1].document.forms[0].fmode.value = 'delete' ;
        frames[1].document.forms[0].action="../../servlet/eOA.TimeTableServlet";
		frames[1].document.forms[0].submit() ;

		f_query_add_mod.location.href = '../../eOA/jsp/SetUpDailyScheduleHeader.jsp?function_mode=insert&function_type=timetable&oper_stn_id='+document.getElementById("oper").value ;
		//f_query_add_mod.location.href = '../../eOA/jsp/TimeTableMain.jsp?function_mode=insert&oper_stn_id='+document.getElementById("oper").value ;
		}
		else
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	}
	else
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	}
	else
	messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
/*}
else
   messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';*/
}
function qryDelete(locnDesc,locnCode,rs_type,p_clinic_code,p_pract_id,p_day_no,p_time_table_type)
{
parent.f_query_add_mod.location.href="../../eOA/jsp/DeleteTimeTable.jsp?function_mode=modify&clinic_code="+p_clinic_code+"&practid="+p_pract_id+"&dayno="+p_day_no+"&timetabletype="+p_time_table_type+"&locnCode="+locnCode+"&rsType="+rs_type+"&locnDesc="+locnDesc;
	parent.sub.location.href='../../eOA/jsp/TimeTableFrame.jsp' ;
}

function qTimeTableType()
{

	var timetabletype = '1';

	parent.sub.frames[1].document.forms[0].b_time_per_patient.disabled 		= false ;
	parent.sub.frames[1].document.forms[0].b_time_per_slab.disabled 		= false ;
	parent.sub.frames[1].document.forms[0].b_max_patients_per_slab.disabled 	= false ;
	parent.sub.frames[1].document.forms[0].b_max_patients_per_day.disabled 	= false ;
	parent.sub.frames[1].document.forms[0].b_max_first_visit.disabled 		= false ;
	parent.sub.frames[1].document.forms[0].b_max_over_bookings.disabled 	= false ;
	parent.sub.frames[1].document.getElementById("forms")(0).time_per_pat.innerText=getLabel("eOA.TimeperPatient.label","OA");
	if (timetabletype=="1")
	{
		parent.sub.frames[1].document.forms[0].b_time_per_slab.disabled 		= true ;
		parent.sub.frames[1].document.forms[0].b_max_patients_per_day.disabled 	= true ;
		parent.sub.frames[1].document.forms[0].time_per_pat.innerText=getLabel("eOA.Timeperslot.label","OA");
	}
	else if (timetabletype=="2")
	{
		parent.sub.frames[1].document.forms[0].b_time_per_patient.disabled 		= true ;
		parent.sub.frames[1].document.forms[0].b_max_patients_per_day.disabled 	= true ;
	}
	else if (timetabletype=="3")
	{
		parent.sub.frames[1].document.forms[0].b_time_per_patient.disabled 		= true ;
		parent.sub.frames[1].document.forms[0].b_time_per_slab.disabled 		= true ;
		parent.sub.frames[1].document.forms[0].b_max_patients_per_slab.disabled 	= true ;
		parent.sub.frames[1].document.forms[0].b_max_patients_per_day.disabled 	= false ;
	}
}

function timeFormat(obj)
{
	var fieldval = obj ;
}

function populatePractitioner()
{
	parent.frames[0].document.forms[0].b_pract_name.value="";
	parent.frames[0].document.forms[0].b_practitioner.value="";

	if(parent.frames[0].document.forms[0].b_day.disabled)
		parent.frames[0].document.forms[0].b_day.disabled=false;


	var dayy = parent.frames[0].document.forms[0].b_day;

	while ( dayy.options.length > 0 )
		dayy.remove(dayy.options[0]);

	var opt = parent.frames[0].document.createElement('OPTION');
	opt.text ="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value= '';
	parent.frames[0].document.forms[0].b_day.add(opt);

	if(parent.frames[0].document.forms[0].b_clinic.selectedIndex==0){
		opt1 = document.createElement("OPTION");
		opt1.text = '*All';
		opt1.value= '*A';
		parent.frames[0].document.forms[0].b_day.add(opt1);
	}

	var clinic_code	= parent.frames[0].document.forms[0].b_clinic.value ;
	
	if (clinic_code != null && clinic_code != "")
	{
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='populatepract' id='populatepract' method='post' action='../../eOA/jsp/TimeTablePract.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+clinic_code+"'></form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.populatepract.submit();
		parent.frames[0].document.forms[0].b_max_slots_for_first_visit.value="0";
	}
    else
	parent.frames[0].document.forms[0].pract_butt.disabled=true;
	parent.frames[0].document.getElementById("imgpract").style.visibility='hidden';
	parent.frames[0].document.forms[0].b_max_slots_for_first_visit.value="0";
}

function checkDuplicate()
{

	
	var clinic_code	= parent.frames[0].document.forms[0].b_clinic.value ;
	var pract_code	= parent.frames[0].document.forms[0].b_practitioner.value ;

	var day_no	= parent.frames[0].document.forms[0].b_day.value ;
	var resourceClass=parent.frames[0].document.forms[0].resource.value;
	
    
	var srcEle=event.target;
	if (clinic_code != null && clinic_code != "")
	{
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH cliniccode=\""+clinic_code+"\" practcode=\""+pract_code+"\" dayno=\""+day_no+"\" resourceClass=\""+resourceClass+"\" from=\""+srcEle.name+"\" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","TimeTableCheckDuplicate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
		/*var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='checkDuplicate' id='checkDuplicate' method='post' action='../../eOA/jsp/TimeTableCheckDuplicate.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+clinic_code+"'><input type='hidden' name='practcode' id='practcode' value='"+pract_code+"'><input type='hidden' name='dayno' id='dayno' value='"+day_no+"'><input type='hidden' name='resourceClass' id='resourceClass' value='"+resourceClass+"'><input type='hidden' name='from' id='from' value='"+srcEle.name+"'></form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.checkDuplicate.submit();*/
	}

}
function checkDuplicate1()
{

	
	var clinic_code	= parent.frames[1].frames[1].frames[0].document.forms[0].b_clinic.value ;
	var pract_code	= parent.frames[1].frames[1].frames[0].document.forms[0].b_practitioner.value ;

	var day_no	= parent.frames[1].frames[1].frames[0].document.forms[0].b_day.value ;
	var resourceClass=parent.frames[1].frames[1].frames[0].document.forms[0].resource.value;
	
	var srcEle='apply';
	if (clinic_code != null && clinic_code != "")
	{   
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='checkDuplicate' id='checkDuplicate' method='post' action='../../eOA/jsp/TimeTableCheckDuplicate.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+clinic_code+"'><input type='hidden' name='practcode' id='practcode' value='"+pract_code+"'><input type='hidden' name='dayno' id='dayno' value='"+day_no+"'><input type='hidden' name='resourceClass' id='resourceClass' value='"+resourceClass+"'><input type='hidden' name='from' id='from' value='"+srcEle+"'></form></body></html>";
		parent.frames[1].messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[1].messageFrame.document.checkDuplicate.submit();
	}

}
function PractManipulate()
{
	var clinic_code	= parent.frames[1].document.forms[0].b_clinic.value ;
	var pract_code	= parent.frames[1].document.forms[0].b_practitioner.value ;
	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='practmanipulate' id='practmanipulate' method='post' action='../../eOA/jsp/TimeTablePractManipulate.jsp'><input type='hidden' name='cliniccode' id='cliniccode' value='"+clinic_code+"'><input type='hidden' name='practcode' id='practcode' value='"+pract_code+"'></form></body></html>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.practmanipulate.submit();
}


function timetableType(obj,addmod)
{
	if( obj.value == ''){
	parent.frames[0].document.forms[0].b_no_global_ref.disabled=true;
	}else{
		parent.frames[0].document.forms[0].b_no_global_ref.disabled=false;
		}

	parent.frames[0].document.forms[0].b_no_forced_booking.disabled=true;
	var fmode=parent.frames[0].document.forms[0].function_mode.value;
	if(fmode == "insert")
	{
		if(parent.frames[0].document.forms[0].b_no_forced_booking.value !=0)
			{
			parent.frames[0].document.forms[0].b_forced_allowed_yn.checked = true;
			}
			else
			{
				parent.frames[0].document.forms[0].b_forced_allowed_yn.checked = false;
			}
	}else if(fmode == "modify")
	{
		
		if(parent.frames[0].document.forms[0].b_no_forced_booking.value !=0)
		   {
			parent.frames[0].document.forms[0].b_forced_allowed_ynchecked.checked = true;
		  }
		  else
		  {
			parent.frames[0].document.forms[0].b_forced_allowed_ynchecked.checked=false;
		  }
	}
	

	var timetabletype = parent.frames[0].document.forms[0].b_time_table_type.value ;
	parent.frames[0].document.getElementById("time_per_pat").innerText=getLabel("eOA.Timeperslot.label","OA");
	if(addmod == 'A'){
	parent.frames[0].document.forms[0].b_max_slots_per_day.value = "";
	parent.frames[0].document.forms[0].b_max_slots_per_day.disabled = true;
	parent.frames[0].document.forms[0].b_time_per_patient.disabled 		= false ;
	parent.frames[0].document.forms[0].b_time_per_slab.disabled 		= false ;
	parent.frames[0].document.forms[0].b_max_patients_per_slab.disabled = false ;
	parent.frames[0].document.forms[0].b_max_patients_per_day.disabled 	= false ;
	parent.frames[0].document.forms[0].b_max_first_visit.disabled 		= false ;
	parent.frames[0].document.forms[0].b_max_over_bookings.disabled 	= false ;
	parent.frames[0].document.getElementById("slot_or_pat_id1").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	parent.frames[0].document.getElementById("slot_or_pat_id2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	parent.frames[0].document.getElementById("slot_or_pat_id3").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

	if (timetabletype=="1")
	{
	    parent.frames[0].document.getElementById("time_per_pat").innerText=getLabel("eOA.Timeperslot.label","OA");
        var slot_appt_ctrl = parent.frames[0].document.forms[0].slot_appt_ctrl.value;
		if (slot_appt_ctrl=="S")
		{
			parent.frames[0].document.getElementById("slot_or_pat_id1").innerText = " (Slots) ";
			parent.frames[0].document.getElementById("slot_or_pat_id2").innerText = " (Slots) ";
			parent.frames[0].document.getElementById("slot_or_pat_id3").innerText = " (Slots) ";
		}
		else
		{
			parent.frames[0].document.getElementById("slot_or_pat_id1").innerText = " (Patients) ";
			parent.frames[0].document.getElementById("slot_or_pat_id2").innerText = " (Patients) ";
			parent.frames[0].document.getElementById("slot_or_pat_id3").innerText = " (Patients) ";
		}
		parent.frames[0].document.forms[0].b_time_per_slab.value='';
		parent.frames[0].document.forms[0].b_max_patients_per_slab.value='';
		parent.frames[0].document.forms[0].b_max_patients_per_day.value='';
		parent.frames[0].document.forms[0].b_time_per_slab.disabled 		= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_slab.disabled = true ;
		parent.frames[0].document.forms[0].b_max_patients_per_day.disabled 	= true ;
	}
	else if (timetabletype=="2")
	{
		
		parent.frames[0].document.forms[0].b_time_per_patient.value='';
		parent.frames[0].document.forms[0].b_max_patients_per_day.value='';
		parent.frames[0].document.forms[0].b_time_per_patient.disabled 		= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_day.disabled 	= true ;
	}
	else if (timetabletype=="3")
	{

			
		parent.frames[0].document.forms[0].b_time_per_patient.value='';
		parent.frames[0].document.forms[0].b_time_per_slab.value='';
		parent.frames[0].document.forms[0].b_max_patients_per_slab.value='';
		parent.frames[0].document.forms[0].b_max_patients_per_day.value='';

		parent.frames[0].document.forms[0].b_time_per_patient.disabled 		= true ;
		parent.frames[0].document.forms[0].b_time_per_slab.disabled 		= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_slab.disabled 	= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_day.disabled 	= false ;
	}
} else{
	parent.frames[0].document.forms[0].b_time_per_patient.disabled 		= false ;
	parent.frames[0].document.forms[0].b_time_per_slab.disabled 		= false ;
	parent.frames[0].document.forms[0].b_max_patients_per_slab.disabled 	= false ;
	parent.frames[0].document.forms[0].b_max_patients_per_day.disabled 	= false ;
	parent.frames[0].document.forms[0].b_max_first_visit.disabled 		= false ;
	parent.frames[0].document.forms[0].b_max_over_bookings.disabled 	= false ;

if (timetabletype=="1")
	{
	    parent.frames[0].document.getElementById("time_per_pat").innerText=getLabel("eOA.TimeperSlot.label","OA");
		parent.frames[0].document.forms[0].b_time_per_slab.readOnly 			= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_slab.readOnly 	= true ;
		if (parent.frames[0].document.forms[0].slot_appt_ctrl.value=="S")
		   parent.frames[0].document.forms[0].b_max_patients_per_day.disabled = true;
	    else
			parent.frames[0].document.forms[0].b_max_patients_per_day.disabled = false;
	}
	else if (timetabletype=="2")
	{
		
		parent.frames[0].document.forms[0].b_time_per_patient.readOnly 		= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_day.readOnly 	= true ;
	}
	else if (timetabletype=="3")
	{
		parent.frames[0].document.forms[0].b_forced_allowed_ynchecked.disabled=true;
		parent.frames[0].document.forms[0].b_time_per_patient.readOnly 		= true ;
		parent.frames[0].document.forms[0].b_time_per_slab.readOnly 		= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_slab.readOnly 	= true ;
		parent.frames[0].document.forms[0].b_max_patients_per_day.readOnly 	= false ;
	}
}
	
}


function formatBreakFrToTime(xer)
{
	if (xer == '1')
	{
		

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time1.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time1.value ;
			}

		}
	}

	if (xer == '2')
	{

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time2.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time2.value ;
			}

		}
	}
	if (xer == '3')
	{

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time3.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time3.value ;
			}

		}
	}
	if (xer == '4')
	{

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time4.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time4.value ;
			}

		}
	}

	if (xer == '5')
	{

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_from_time5.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value.length == 2)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value.substring(1,2) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value = '0' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value ;
			}

		}

		if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value.length == 3)
		{
			if (parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value.substring(0,1) == ':')
			{
				parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value = '00' + parent.parent.frames[1].breaktime.document.forms[0].b_to_time5.value ;
			}

		}
	}
}

function formatTimePerSlab()
{
	if (parent.frames[0].document.forms[0].b_time_per_slab.value.length == 2)
	{
		if (parent.frames[0].document.forms[0].b_time_per_slab.value.substring(1,2) == ':')
		{
			parent.frames[0].document.forms[0].b_time_per_slab.value = '0' + parent.frames[0].document.forms[0].b_time_per_slab.value ;
		}

	}

	if (parent.frames[0].document.forms[0].b_time_per_slab.value.length == 3)
	{
		if (parent.frames[0].document.forms[0].b_time_per_slab.value.substring(0,1) == ':')
		{
			parent.frames[0].document.forms[0].b_time_per_slab.value = '00' + parent.frames[0].document.forms[0].b_time_per_slab.value ;
		}

	}
	if (parent.frames[0].document.forms[0].b_time_per_slab.value.length == 4)
	{
		if (parent.frames[0].document.forms[0].b_time_per_slab.value.substring(0,1) == ':')
		{
			parent.frames[0].document.forms[0].b_time_per_slab.value = '00' + parent.frames[0].document.forms[0].b_time_per_slab.value ;
		}

	}
	if (parent.frames[0].document.forms[0].b_time_per_slab.value.length == 5)
	{
		if (parent.frames[0].document.forms[0].b_time_per_slab.value.substring(0,1) == ':')
		{
			parent.frames[0].document.forms[0].b_time_per_slab.value = '00' + parent.frames[0].document.forms[0].b_time_per_slab.value ;
		}

	}
	
}




function TimePerPatientValid(obj)
{ 
	parent.frames[0].document.forms[0].b_max_patients_per_day.value='';

	var tm = obj;
	if(CheckTime(obj,'X')){
	var time_table_type  	= parent.frames[0].document.forms[0].b_time_table_type.value ;
	var time_per_patient 	= parent.frames[0].document.forms[0].b_time_per_patient.value ;
	var start_time	     	= parent.frames[0].document.forms[0].b_start_time.value ;
	var end_time	     	= parent.frames[0].document.forms[0].b_end_time.value ;
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
					if (parent.frames[0].document.forms[0].fmode.value=='insert'){
					parent.frames[0].document.forms[0].b_time_per_patient.value='';
					parent.frames[0].document.forms[0].b_time_per_patient.focus();
					}else{
					parent.frames[0].document.forms[0].b_end_time.value='';
					parent.frames[0].document.forms[0].b_end_time.focus();
					}
			}
			else if ((tpptime - dumtime) > (endtime - starttime))
			{
					var invalid_mtpp	     = getMessage('INVALID_TM_PR_PAT','OA') ;
					alert(invalid_mtpp) ;
					if (parent.frames[0].document.forms[0].fmode.value=='insert'){
					parent.frames[0].document.forms[0].b_time_per_patient.value='';
					parent.frames[0].document.forms[0].b_time_per_patient.focus();
					}
					else{
					parent.frames[0].document.forms[0].b_end_time.value='';
					parent.frames[0].document.forms[0].b_end_time.focus();
					}
			}
			else if ((start_time.length != 0) && (end_time.length !=0) && (time_per_patient.length != 0))
				{				
					var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='maxPatients' id='maxPatients' method='post' action='../../eOA/jsp/TimeTableMaxPatients.jsp'><input type='hidden' name='starttime' id='starttime' value='"+start_time+"'><input type='hidden' name='endtime' id='endtime' value='"+end_time+"'><input type='hidden' name='timeperpatient' id='timeperpatient' value='"+time_per_patient+"'><input type='hidden' name='maxpatcat' id='maxpatcat' value='"+l_max_pat_category+"'><input type='hidden' name='normal_yn' id='normal_yn' value='Y'></form></body></html>";
					parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.parent.messageFrame.document.maxPatients.submit();
					if (parent.frames[0].document.forms[0].slot_appt_ctrl.value=="P")
						{
						   parent.frames[0].document.forms[0].b_max_patients_per_day.disabled =false;
						   parent.frames[0].document.forms[0].b_max_patients_per_day.focus();
						}

					else
					   parent.frames[0].document.forms[0].b_max_first_visit.focus();
				}
			}
		}
}
}


function TimePerSlab(obj)
{
	parent.frames[0].document.forms[0].b_max_patients_per_day.value='';
	parent.frames[0].document.forms[0].b_max_patients_per_slab.value='';

	var tm = obj;
	if(CheckTime(obj,'X')){
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var end_time		= parent.frames[0].document.forms[0].b_end_time.value ;
	var start_time		= parent.frames[0].document.forms[0].b_start_time.value ;
	var timetabletype 	= parent.frames[0].document.forms[0].b_time_table_type.value ;
	var time_per_slab 	= parent.frames[0].document.forms[0].b_time_per_slab.value ;
	var dummytime 		= '00:00' ;
	var dummyarray		;

	var tpsarray 		;
	var endarray		;
	var startarray		;
	var tpstime		;
	var endtime		;
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
					var in_max_tps	     = getMessage('INVALID_MAX_TM_PR_SLAB','OA') ;
					alert(in_max_tps) ;
					parent.frames[0].document.forms[0].b_time_per_slab.focus();
			}
			else if (time_per_slab <= "0" )
			{
				var in_tm_pr_slab = getMessage('INVALID_TM_PR_SLAB','OA');
				alert(in_tm_pr_slab) ;
				parent.frames[0].document.forms[0].b_time_per_slab.focus();
			}
		}
	}
}
}

function CheckTime(obj,fld) {
	var type = parent.frames[0].document.forms[0].b_time_table_type.value;
	var timefield 	= obj;
	if(fld == 'E'){
       var sttime= parent.frames[0].document.forms[0].b_start_time.value;
       var edtime= parent.frames[0].document.forms[0].b_end_time.value;


		var fromarray= sttime.split(":") ;
		var toarray  = edtime.split(":") ;

		var fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		var totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;


		if(fromtime >= totime)
		{
			var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OA");
			status1 = 'Y' ;
			alert(errors);
			obj.value='';
			obj.focus();
		}

	}
	if (fld=='S')
	{ var mode=parent.frames[0].document.forms[0].fmode.value;
	  
	  var sttime=parent.frames[0].document.forms[0].b_start_time.value;
	  var sttimeArr=sttime.split(':');
	  if (mode=='insert'){
	  var selIndex=parent.frames[0].document.forms[0].b_clinic.options.selectedIndex;
      var defTmVls=endTimeArr[selIndex];
      var defArr =defTmVls.split(':');
	  if (defTmVls=='')	  return;
      }else if(mode=='modify'){
      var defTmVls=parent.frames[0].document.forms[0].endTime.value;
	  var defArr=defTmVls.split(':');
	  }
	  var stDt=new Date(1,1,1,sttimeArr[0],sttimeArr[1],0,0);
	  var defDt= new Date(1,1,1,defArr[0],defArr[1],0,0);
	  if (stDt >= defDt)
	  {
		  //alert("APP-000001 Start Time Should Not Be Greater/Equal Than Clinic Default End Time "+defTmVls);
		  msg=getMessage("START_TIME_GRT_CLN_DEF_END_TIME","OA")+" "+defTmVls;
			 alert(msg);
          parent.frames[0].document.forms[0].b_start_time.value='';
		  parent.frames[0].document.forms[0].b_start_time.focus();
	  }
	  

	}
	if (obj.value!="")
	{
		if (chkTime(obj.value) == false) {		
			var errors = getMessage("INVALID_TIME_FMT","SM");
			alert(errors);
			obj.value='';
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

function MaxPatPerDay(obj)
{
	var fieldname	= obj;
	var fieldval	= fieldname.value;
	var timetabletype = parent.frames[0].document.forms[0].b_time_table_type.value ;
	var maxpatperday  = parent.frames[0].document.forms[0].b_max_patients_per_day.value ;
	if (parseInt(maxpatperday) <= 0)
		{
			
			
			var errors = getOA_Message("VALUE_GREATER_ZERO");
			errors = errors.replace("#",getLabel("eOA.maxpatperday.label","OA"));
			alert(errors);
			fieldname.select();
			fieldname.focus();
			return false;
		}

	if (timetabletype == '3')
	{
		if (fieldval =="")
		{
			var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK','Common') ;
		}
		else
		{
			parent.frames[0].document.forms[0].b_max_first_visit.focus();
		}

		
	} 
	else if (timetabletype == '1')
	{
	  var max_pat_per_slot  = parent.frames[0].document.forms[0].b_max_slots_per_day.value ;
	  if (maxpatperday !="" && parseInt(max_pat_per_slot)<parseInt(maxpatperday))
	  {
			var errors = getMessage("MAX_SLOT_NOT_GREATER_MAX_DAY","OA");
			alert(errors);
			parent.frames[0].document.forms[0].b_max_patients_per_day.focus();

	  }
	  else
 		  parent.frames[0].document.forms[0].l_max_pat_per_day.value =parent.frames[0].document.forms[0].b_max_patients_per_day.value
    }

}

function MaxPatPerSlab(obj)
{  if (obj.value!='0'){

	var no=obj;
	if(ChkNum(obj)){
	fieldname 		= obj ;
	fieldval		= fieldname.value ;
	var timetabletype 	= parent.frames[0].document.forms[0].b_time_table_type.value ;
	var l_max_pat_category	= "2" ;
	var start_time	     	= parent.frames[0].document.forms[0].b_start_time.value ;
	var end_time	     	= parent.frames[0].document.forms[0].b_end_time.value ;
	var l_time_per_slab	= parent.frames[0].document.forms[0].b_time_per_slab.value ;
	var l_max_pat_per_slab	= parent.frames[0].document.forms[0].b_max_patients_per_slab.value ;
       if (obj.value !='' && (start_time =='' || end_time==''))
       {
		  // alert('APP-000001 Start/End Time Should Not Be Blank..');
		  alert(getMessage("START_END_NOT_BLANK","OA"));
		   obj.select();
		   obj.focus();
		   return 
       }
	if (timetabletype == '2')
	{

		if ((l_time_per_slab != "0") && (!l_time_per_slab < '0'))
		{
			if ((fieldval=="") && (l_time_per_slab != ""))
			{
				var no_blank	     = getMessage('SHOULD_NOT_BE_BLANK','Common') ;
			}

			else if ((fieldval <= 0) && (l_time_per_slab != ""))
			{
				
				
				var errors	     = getMessage('INVALID_MAX_TM_PR_SLAB','OA') ;
				alert(errors) ;
					fieldname.focus();
			}

		}
		
		if(fieldval !='' && l_time_per_slab != ""){
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='maxPatients' id='maxPatients' method='post' action='../../eOA/jsp/TimeTableMaxPatients.jsp'><input type='hidden' name='starttime' id='starttime' value='"+start_time+"'><input type='hidden' name='endtime' id='endtime' value='"+end_time+"'><input type='hidden' name='timeperslab' id='timeperslab' value='"+l_time_per_slab+"'><input type='hidden' name='maxpatperslab' id='maxpatperslab' value='"+l_max_pat_per_slab+"'><input type='hidden' name='maxpatcat' id='maxpatcat' value='"+l_max_pat_category+"'><input type='hidden' name='normal_yn' id='normal_yn' value='Y'></form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		
		parent.parent.messageFrame.document.maxPatients.submit();
		}
	

	}
}
}else{
alert("APP-000001 Max Petientis Per Slab Should Not Be Zero");
obj.select();
obj.focus();
}
}

var flag=1;

function MaxFirstVisit(obj)
{	
	var no=obj;
	if(ChkNum(no)){
	fieldname 		= obj ;
	fieldval		= fieldname.value ;
	max_pat_per_day		= parent.frames[0].document.forms[0].b_max_patients_per_day.value ;
	max_first_visit		= parent.frames[0].document.forms[0].b_max_first_visit.value;
	slot_appt_ctrl		= parent.frames[0].document.forms[0].slot_appt_ctrl.value;
	visit_limit_rule	= parent.frames[0].document.forms[0].visit_limit_rule.value;
	b_time_table_type	= parent.frames[0].document.forms[0].b_time_table_type.value;
	max_pat_per_slot	= parent.frames[0].document.forms[0].b_max_slots_per_day.value;

	if(fieldval != ''){
	if (fieldval <= 0)
	{
			var errors = getOA_Message("VALUE_GREATER_ZERO");
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
	else flag=1;
	}
	if (visit_limit_rule!="N")
	{
	  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
	  {
		if (parseInt(max_first_visit) > parseInt(max_pat_per_day))
		{
			
			var errors = getOA_Message("MAX_FI_VI_GR_MAX_PAT_PER_DAY");
			errors = errors.replace("#",getLabel("Common.day.label","Common"));
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
			
			var errors = getOA_Message("MAX_FI_VI_GR_MAX_PAT_PER_DAY");
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
		 if (parent.frames[0].document.forms[0].b_max_other_visits.value==""){
		 if (parseInt(max_pat_per_day)-parseInt(max_first_visit) !=0)
		 parent.frames[0].document.forms[0].b_max_other_visits.value = parseInt(max_pat_per_day)-parseInt(max_first_visit);
		 parent.frames[0].document.forms[0].b_max_other_visits.focus();
		 }
		}
	}
}

function maxothervisit(obj)
{

	max_other_visit		= parent.frames[0].document.forms[0].b_max_other_visits.value ;
	if(max_other_visit != ''){
		max_pat_per_day		= parent.frames[0].document.forms[0].b_max_patients_per_day.value ;
		slot_appt_ctrl		= parent.frames[0].document.forms[0].slot_appt_ctrl.value;
		visit_limit_rule	= parent.frames[0].document.forms[0].visit_limit_rule.value;
		b_time_table_type	= parent.frames[0].document.forms[0].b_time_table_type.value;
		max_pat_per_slot	= parent.frames[0].document.forms[0].b_max_slots_per_day.value;
		var flag ="0";
		if (max_other_visit=="" )  max_other_visit="0";
		if (max_pat_per_day=="" )  max_pat_per_day="0";
		if (max_other_visit <= 0)
		{
				var errors = getOA_Message("VALUE_GREATER_ZERO");
				if (visit_limit_rule=="E")
					errors = errors.replace("#",getLabel("eOA.noofothervisits.label","OA"));
				else
					errors = errors.replace("#",getLabel("eOA.MaxOtherVisits.label","OA"));
				alert(errors);
				obj.value = '';
				obj.focus();
				flag=0;
				return false;
		}
		else if (visit_limit_rule!="N")
		{	 	
		  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
		  {
			if (parseInt(max_other_visit) > parseInt(max_pat_per_day))
			{
				
				var errors = getOA_Message("MAX_OT_VI_GR_MAX_PAT_PER_DAY");
				errors = errors.replace("#",getLabel("Common.day.label","Common"));
				alert(errors);
				parent.frames[0].document.forms[0].b_max_other_visits.focus();
			}
		  }
		  else
		  {
			 if (parseInt(max_other_visit) > parseInt(max_pat_per_slot))
			 {
				
				var errors = getOA_Message("MAX_OT_VI_GR_MAX_PAT_PER_DAY");
				errors = errors.replace("#",getLabel("Common.Slot.label","Common"));
				alert(errors);
				parent.frames[0].document.forms[0].b_max_other_visits.focus();
			 }
			}
		}
	}

}

function MaxOverBookings(obj)
{
	if(flag == 1)
	{
	fieldname 		= obj ;

	if(ChkNum(fieldname)){
	fieldval		= fieldname.value ;
	max_pat_per_day		= frames[1].document.forms[0].max_patients_per_day.value ;
	max_over_booking	= frames[1].document.forms[0].max_over_bookings.value ;

	if(fieldval!=''){
	if (fieldval <= 0)
	{
			
			var errors = getMessage("VALUE_GREATER_ZERO","OA");
			errors= errors.replace("#",getLabel("eOA.MaximumOverBookings.label","OA"));
			alert(errors);			
			fieldname.value='';
			fieldname.focus();
			return false;
	}
	else if (parseInt(max_over_booking) > parseInt(max_pat_per_day))
	{
		var max_ob	= getMessage('MAX_OB_GR_MAX_PAT_PER_DAY','OA') ;
		obj.value="";
		alert(max_ob) ;
		obj.focus();
		return false;

	}
	}
}
}

}

var flag3=1;
function CallToBreakTimeValidation(obj,xer)
{
	if(flag1 == 1 )
	{
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var fieldarray		;
	var fieldtime		;

	var l_timetabletype 	= parent.frames[0].document.forms[0].b_time_table_type.value ;
	var l_start_time	= parent.frames[0].document.forms[0].b_start_time.value ;
	var l_end_time	     	= parent.frames[0].document.forms[0].b_end_time.value ;
	var l_time_per_slab	= parent.frames[0].document.forms[0].b_time_per_slab.value ;
	var l_time_per_patient 	= parent.frames[0].document.forms[0].b_time_per_patient.value ;
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
		
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		toTimeFocus(xer);
		flag3=0;
	}
	else if (totime > entime)
	{
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		toTimeFocus(xer);
		flag3=0;
	}
	else
	flag3=1;

	if(flag3 == 1)
	{
	if (l_timetabletype == '1')
	{
		brtime		=	endtime-tpptime ;

		if (totime > brtime)
		{
			var errors = getMessage("BREAK_END_TIME","OA");
			alert(errors);
			toTimeFocus(xer);
		}
	}
	else if (l_timetabletype == '2')
	{
		brtime		=	endtime-tpstime ;
		if (totime > brtime)
		{
			var errors = getMessage("ATLEAST_ONE_SLSB_EXIT","OA");
			alert(errors);
			toTimeFocus(xer);
		}
	}else if(l_timetabletype == '3')
	{
		brtime		=	endtime-tpptime ;
		if (totime == entime)
		{
			var errors = getMessage("BREAK_END_TIME","OA");
			alert(errors);
			toTimeFocus(xer);
		}
	}
	
	}
	}

}

var flag1=1;

function CallFromBreakTimeValidation(obj,xer)
{
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var fieldarray		;
	var fieldtime		;
	
	var l_timetabletype 	= parent.frames[0].document.forms[0].b_time_table_type.value ;
	var l_start_time	= parent.frames[0].document.forms[0].b_start_time.value ;
	var l_end_time	     	= parent.frames[0].document.forms[0].b_end_time.value ;
	var l_time_per_slab	= parent.frames[0].document.forms[0].b_time_per_slab.value ;
	var l_time_per_patient 	= parent.frames[0].document.forms[0].b_time_per_patient.value ;

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

	if (frtime < sttime)
	{
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		flag1=0;
		fromTimeFocus(xer);
	}
	else if (frtime > entime)
	{
		var errors = getMessage("BR_TM_NOT_VALID","OA");
		alert(errors);
		flag1=0;
		fromTimeFocus(xer);
	}
	else
	flag1=1;
}


function fromTimeFocus(ind)
{
	if (ind == '1')
	{
		parent.frames[1].document.forms[0].b_from_time1.focus();
	}
	else if (ind == '2')
	{
		parent.frames[1].document.forms[0].b_from_time2.focus();
	}
	else if (ind == '3')
	{
		parent.frames[1].document.forms[0].b_from_time3.focus();
	}
	else if (ind == '4')
	{
		parent.frames[1].document.forms[0].b_from_time4.focus();
	}
	else if (ind == '5')
	{
		parent.frames[1].document.forms[0].b_from_time5.focus();
	}
}
function toTimeFocus(ind)
{
	if (ind == '1')
	{
		parent.frames[1].document.forms[0].b_to_time1.focus();
	}
	else if (ind == '2')
	{
		parent.frames[1].document.forms[0].b_to_time2.focus();
	}
	else if (ind == '3')
	{
		parent.frames[1].document.forms[0].b_to_time3.focus();
	}
	else if (ind == '4')
	{
		parent.frames[1].document.forms[0].b_to_time4.focus();
	}
	else if (ind == '5')
	{
		parent.frames[1].document.forms[0].b_to_time5.focus();
	}
}


/*function callBTI(mode,dispmode)
{
alert("ser");
	p_from_time		= parent.parent.sub.frames[0].document.forms[0].b_from_time.value ;
	p_to_time		= parent.parent.sub.frames[0].document.forms[0].b_to_time.value ;

	if (dispmode == 'A')
	{
		p_db_fr_to_time		= '' ;
	}
	else
	{
		p_db_fr_to_time	= parent.parent.sub.list.document.forms[0].hd_totstr.value ;
	}

	callBreakTimeIntervals(p_from_time,p_to_time,p_db_fr_to_time) ;
}*/

/*function callBreakTimeIntervals(strVal1,strVal2,dbStr)
{

	newStr += dbStr ;

	newStr += strVal1 + strVal2 + ',' ;

	parent.parent.f_query_add_mod.document.forms[0].ftotstr.value = newStr ;

	parent.list.location.href  = "../../eOA/jsp/TimeTableList.jsp?newstr="+newStr+"&disp=X" ;
}*/

/*function assignVal(fval,sval)
{
	parent.parent.sub.breaktime.document.forms[0].b_from_time.value = fval ;
	parent.parent.sub.breaktime.document.forms[0].b_to_time.value = sval ;

	parent.parent.sub.list.document.forms[0].hd_from_time.value = fval ;
	parent.parent.sub.list.document.forms[0].hd_to_time.value = sval ;

	parent.dummy.location.href  = "../../eOA/jsp/TimeTableButton.jsp?getMode=modify" ;
}*/

function moddelBTI(mode)
{
	totStrVal = parent.parent.sub.list.document.forms[0].hd_totstr.value ;

	oldStrVal = parent.parent.sub.list.document.forms[0].hd_from_time.value + parent.parent.sub.list.document.forms[0].hd_to_time.value ;
	newStrVal = parent.parent.sub.breaktime.document.forms[0].b_from_time.value + parent.parent.sub.breaktime.document.forms[0].b_to_time.value ;
	pmode     = mode ;

	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='breaktimeModDel' id='breaktimeModDel' method='post' action='../../eOA/jsp/TimeTableBreakTimeModDel.jsp'><input type='hidden' name='totstr' id='totstr' value='"+totStrVal+"'><input type='hidden' name='oldstr' id='oldstr' value='"+oldStrVal+"'><input type='hidden' name='newstr' id='newstr' value='"+newStrVal+"'><input type='hidden' name='pmode' id='pmode' value='"+pmode+"'></form></body></html>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.breaktimeModDel.submit();
}

function CallBreakTimeValidation1(obj,frtime)
{
	var fieldname 		= obj ;
	var fieldval		= fieldname.value ;
	var fieldarray		;
	var fieldtime		;


	var l_timetabletype 	= parent.parent.frames[1].document.forms[0].b_time_table_type.value ;
	var l_end_time	     	= parent.parent.frames[1].document.forms[0].b_end_time.value ;
	var l_time_per_slab	= parent.parent.frames[1].document.forms[0].b_time_per_slab.value ;
	var l_time_per_patient 	= parent.parent.frames[1].document.forms[0].b_time_per_patient.value ;
	var l_to_time1		= parent.parent.frames[2].document.frames[0].document.forms[0].b_to_time1.value ;
	var l_from_time1	= parent.parent.frames[2].document.frames[0].document.forms[0].b_from_time1.value ;
	var l_to_time2		= parent.parent.frames[2].document.frames[0].document.forms[0].b_to_time2.value ;
	var l_from_time2	= parent.parent.frames[2].document.frames[0].document.forms[0].b_from_time2.value ;
	var l_to_time3		= parent.parent.frames[2].document.frames[0].document.forms[0].b_to_time3.value ;
	var l_from_time3	= parent.parent.frames[2].document.frames[0].document.forms[0].b_from_time3.value ;
	var l_to_time4		= parent.parent.frames[2].document.frames[0].document.forms[0].b_to_time4.value ;
	var l_from_time4	= parent.parent.frames[2].document.frames[0].document.forms[0].b_from_time4.value ;
	var l_to_time5		= parent.parent.frames[2].document.frames[0].document.forms[0].b_to_time5.value ;
	var l_from_time5	= parent.parent.frames[2].document.frames[0].document.forms[0].b_from_time5.value ;

	totStr		= l_from_time1 + l_to_time1 + ',' + l_from_time2 + l_to_time2 + ',' + l_from_time3 + l_to_time3 + ',' ;
	totStr		+= l_from_time4 + l_to_time4 + ',' + l_from_time5 + l_to_time5 + ',';

	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='breaktimevalidations' id='breaktimevalidations' method='post' action='../../eOA/jsp/TimeTableBreakTime.jsp'><input type='hidden' name='timetabletype' id='timetabletype' value='"+l_timetabletype+"'><input type='hidden' name='endtime' id='endtime' value='"+l_end_time+"'><input type='hidden' name='timeperslab' id='timeperslab' value='"+l_time_per_slab+"'><input type='hidden' name='timeperpatient' id='timeperpatient' value='"+l_time_per_patient+"'><input type='hidden' name='totStr' id='totStr' value='"+totStr+"'></form></body></html>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.breaktimevalidations.submit();

}



function remarksNext()
{
	parent.frames[2].document.frames[0].document.forms[0].b_from_time1.focus();
}

function ChkNum(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		return true;
	}
	else if ( obj.value.length > 0 ) {
			var errors = getMessage("NUM_ALLOWED","SM");
			alert(errors);
  			obj.select();
  			obj.focus();
  			return false;
  		}
  	else
  		return true;
  	}

var flagtime = 'T';
	function Call_CheckTime(obj,mode){
			dat=obj;
			fld=mode;
			var startarray ;
			var endarray   ;
			var starttime  ;
			var endtime    ;
			var starttm    ;
			var endtm       ;
			var time_table_type  = parent.frames[0].document.forms[0].b_time_table_type.value ;
			parent.frames[0].document.forms[0].b_time_per_patient.value='';
			parent.frames[0].document.forms[0].b_max_patients_per_day.value='';
			parent.frames[0].document.forms[0].b_time_per_slab.value='';
			parent.frames[0].document.forms[0].b_max_patients_per_slab.value='';

			if(CheckTime(dat,fld)){
			starttime=dat.value;
			endtime    = parent.frames[0].document.forms[0].b_end_time.value ;

			startarray = starttime.split(":") ;
			endarray   = endtime.split(":") ;

			starttm    = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
			endtm	   = new Date(1,1,1,endarray[0],endarray[1],0,0) ;

			if(starttime != ''){
			if (endtime != null)
			{
				if (Date.parse(starttm) >= Date.parse(endtm))
				{
					var st_gt_en_tm = getMessage('ED_TIME_LESS_EQL_ST_TIME','OA');
					alert(st_gt_en_tm);
					parent.frames[0].document.forms[0].b_end_time.select();
					parent.frames[0].document.forms[0].b_end_time.focus();
					flagtime='F'
					return false;

				}
		}
	}
}
}

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

function MaxSlots(obj){
if (parseInt(obj.value) <= 0)
	{
		var errors = getMessage("VALUE_GREATER_ZERO","OA");
		errors = errors.replace("#",getLabel("eOA.maxslotsperday.label","OA"));
		alert(errors);
		obj.select();
		obj.focus();
		return false;
	}
}

async function show_allocation(mode){
	
var alcn_criteria=parent.frames[0].document.forms[0].alcn_criteria.value;


		var max_no_patient=parent.frames[0].document.forms[0].b_max_patients_per_day.value;
	if(max_no_patient==''){ 
				alert(getMessage("MAX_PAT_NOT_DEFINED","OA"));	
					}
else
	{
		if(chkBeforeAllocation())
		{
		var alcn_basis=parent.frames[0].document.forms[0].alcn_basis.value;
		var alcn_criteria=parent.frames[0].document.forms[0].alcn_criteria.value;
		if(alcn_basis!=''){
		var clinic_code=parent.frames[0].document.forms[0].b_clinic.value;
		var practitioner_id=parent.frames[0].document.forms[0].b_practitioner.value;
		var b_time_table_type=parent.frames[0].document.forms[0].b_time_table_type.value;
		var day_no=parent.frames[0].document.forms[0].b_day.value;
		var time_table_type=parent.frames[0].document.forms[0].b_time_table_type.value;
		var final_string=parent.frames[0].document.forms[0].final_string.value;
		var visit_limit_rule=parent.frames[0].document.forms[0].visit_limit_rule.value;
		var slot_appt_ctrl=parent.frames[0].document.forms[0].slot_appt_ctrl.value;
		if(mode=='insert')
			var status_no="";
		else
			var status_no="direct";

		if (visit_limit_rule!="N")
		{
		  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
			var max_no_patient=parent.frames[0].document.forms[0].b_max_patients_per_day.value;
		  else
			var max_no_patient=parent.frames[0].document.forms[0].b_max_slots_per_day.value;				
		}
		else
			var max_no_patient=parent.frames[0].document.forms[0].b_max_patients_per_day.value;	
				
				parent.frames[0].document.forms[0].b_time_per_patient.readonly=true;
				parent.frames[0].document.forms[0].b_max_patients_per_day.readonly=true;

				var retVal = 	new String();
				var dialogHeight= "19" ;
				var dialogTop = "300" ;
				var dialogWidth	= "58" ;
				var status = "no";
				var scroll = "no";
				
				if(parent.frames[0].document.forms[0].final_string.value =='')  { status_no='';}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var callurl="../../eOA/jsp/ClinicAllocation.jsp?alcn_basis="+alcn_basis+"&alcn_criteria="+alcn_criteria+"&max_no_patient="+max_no_patient+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&day_no="+day_no+"&time_table_type="+time_table_type+"&final_string="+final_string+"&time_table_type="+time_table_type+"&status="+status_no+"&mode="+mode+"&slot_appt_ctrl="+slot_appt_ctrl;
				retVal = await window.showModalDialog(callurl,arguments,features);
				if(retVal!=null && retVal!='undefined' && retVal!=''){
				parent.frames[0].document.forms[0].final_string.value=retVal;
				}
				else if(retVal==null || retVal =='undefined' || retVal=='')
				{
				retVal='';
				parent.frames[0].document.forms[0].final_string.value=retVal;
				}
				else{
				retVal='';
				parent.frames[0].document.forms[0].final_string.value=retVal;
				}

}
else{
var errors = getMessage("ALCN_CRIT_NOT_DEFINED","OA");
alert(errors);

}
}
}
		
}
function onSuccess(){
f_query_add_mod.document.location.reload();
}

function chkBeforeAllocation()
{
	var time_table_type	= parent.frames[0].document.forms[0].b_time_table_type.value ;

	var startarray;
	var endarray  ;
	var starttime =parent.frames[0].document.forms[0].b_start_time.value ;
	var endtime   = parent.frames[0].document.forms[0].b_end_time.value ;
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

	var time_per_patient = parent.frames[0].document.forms[0].b_time_per_patient.value ;
	var tpparray  ;
	var timeperpatient ;

	var time_per_slab    = parent.frames[0].document.forms[0].b_time_per_slab.value ;
	var tpsarray  ;
	var timeperslab ;
	var start_time1      = parent.frames[0].document.forms[0].b_start_time.value ;
	var end_time1        = parent.frames[0].document.forms[0].b_end_time.value ;

	var max_first_visit  = parent.frames[0].document.forms[0].b_max_first_visit.value;
	var max_over_bookings = parent.frames[0].document.forms[0].b_max_over_bookings.value;
	var max_pat_per_day  = parent.frames[0].document.forms[0].b_max_patients_per_day.value;
	var maxpat	;
	var toSubmit 	= new Boolean() ;
	toSubmit	= true ;

	var toBreakTime	= new Boolean() ;
	toBreakTime	= true ;


	var p_from_time1="";
	var p_to_time1="";
	var p_from_time2="";
	var p_to_time2="";
	var p_from_time3="";
	var p_to_time3="";
	var p_from_time4="";
	var p_to_time4="";
	var p_from_time5="";
	var p_to_time5="";

	p_from_time1 	=	parent.frames[1].breaktime.document.forms[0].b_from_time1.value ;
	p_to_time1 	=	parent.frames[1].breaktime.document.forms[0].b_to_time1.value ;
	p_from_time2 	=	parent.frames[1].breaktime.document.forms[0].b_from_time2.value ;
	p_to_time2 	=	parent.frames[1].breaktime.document.forms[0].b_to_time2.value ;
	p_from_time3 	=	parent.frames[1].breaktime.document.forms[0].b_from_time3.value ;
	p_to_time3 	=	parent.frames[1].breaktime.document.forms[0].b_to_time3.value ;
	p_from_time4 	=	parent.frames[1].breaktime.document.forms[0].b_from_time4.value ;
	p_to_time4 	=	parent.frames[1].breaktime.document.forms[0].b_to_time4.value ;
	p_from_time5 	=	parent.frames[1].breaktime.document.forms[0].b_from_time5.value ;
	p_to_time5 	=	parent.frames[1].breaktime.document.forms[0].b_to_time5.value ;
	olStr		= p_from_time1 + '-' + p_to_time1 + ',' + p_from_time2 + '-' + p_to_time2 + ',' + p_from_time3 + '-' + p_to_time3 + ',' ;
	olStr	       += p_from_time4 + '-' + p_to_time4 + ',' + p_from_time5 + '-' + p_to_time5 + ',';

	gvar		= olStr.split(",");
	
	var max_pat_per_day_temp ="";
	
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
					breakdiff = (breaktime/timerinseconds);

					startarray= starttime.split(":") ;
					endarray  = endtime.split(":") ;

					sttime = new Date(1,1,1,startarray[0],startarray[1],0,0) ;
					entime= new Date(1,1,1,endarray[0],endarray[1],0,0) ;

					totaltime = entime - sttime ;

					if (time_table_type == '1')
					{
						max_pat_per_day_temp = (totaltime / timerinseconds) - breakdiff ;
					}
					if (time_table_type == '2')
					{
						maxpat = ((totaltime / timerinseconds) * parent.frames[0].document.forms[0].b_max_patients_per_slab.value);

						parent.frames[0].document.forms[0].b_max_patients_per_day.value =  maxpat - (breakdiff * parent.frames[0].document.forms[0].b_max_patients_per_slab.value) ;
					}
					parent.frames[0].document.forms[0].ftotstr.value = olStr ;
					if (time_table_type == '1')
					{
						max_slot_per_day  = parent.frames[0].document.forms[0].b_max_slots_per_day.value;
						if (max_pat_per_day_temp!=max_slot_per_day)
						{
						  parent.frames[0].document.forms[0].b_max_slots_per_day.value = max_pat_per_day_temp;
						  parent.frames[0].document.forms[0].b_max_patients_per_day.value = max_pat_per_day_temp;
						}
					}

					max_pat_per_day			= parent.frames[0].document.forms[0].b_max_patients_per_day.value;
					var max_pat_per_slot	= parent.frames[0].document.forms[0].b_max_slots_per_day.value;
					var visit_limit_rule	= parent.frames[0].document.forms[0].visit_limit_rule.value;
					var slot_appt_ctrl		= parent.frames[0].document.forms[0].slot_appt_ctrl.value;
					var b_time_table_type   = parent.frames[0].document.forms[0].b_time_table_type.value;

					if (visit_limit_rule!="N")
					{
					  if ( b_time_table_type!="1" || slot_appt_ctrl=="P")
					  {
						if (parseInt(max_first_visit) > parseInt(max_pat_per_day))
						{
							
							
							var errors = getMessage("MAX_FI_VI_GR_MAX_PAT_PER_DAY","OA");
                            errors = errors.replace("#",getLabel("Common.day.label","Common"));
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
                            errors = errors.replace("#",getLabel("Common.day.label","Common"));
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
				parent.frames[0].document.forms[0].ftotstr.value = olStr ;
			}
			
		if ((Date.parse(fromtime)) >= (Date.parse(totime)))
		{
			var s = getMessage('ED_TIME_LESS_EQL_ST_TIME','OA');
			alert(s);
			toSubmit = false;
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
if (obj.name=="b_start_time")
parent.frames[0].document.forms[0].b_end_time.value="";
parent.frames[0].document.forms[0].b_max_first_visit.value="";
parent.frames[0].document.forms[0].b_max_other_visits.value="";
parent.frames[0].document.forms[0].b_max_over_bookings.value="";
if (parent.frames[0].document.forms[0].function_mode.value!='modify'){
parent.frames[0].document.forms[0].b_time_per_slab.value='';
parent.frames[0].document.forms[0].b_time_per_patient.value='';
}
parent.frames[0].document.forms[0].b_max_patients_per_day.value='';

parent.frames[0].document.forms[0].b_max_patients_per_slab.value='';

 parent.frames[1].document.forms[0].b_to_time1.value ="";
 parent.frames[1].document.forms[0].b_from_time1.value ="";
 parent.frames[1].document.forms[0].b_to_time2.value ="";
 parent.frames[1].document.forms[0].b_from_time2.value=""; 
 parent.frames[1].document.forms[0].b_to_time3.value ="";
 parent.frames[1].document.forms[0].b_from_time3.value ="";
 parent.frames[1].document.forms[0].b_to_time4.value ="";
 parent.frames[1].document.forms[0].b_from_time4.value ="";
 parent.frames[1].document.forms[0].b_to_time5.value ="";
 parent.frames[1].document.forms[0].b_from_time5.value ="";
 var timetabletype = parent.frames[0].document.forms[0].b_time_table_type.value ;
 if (obj.name!="b_start_time"){
 if(timetabletype =='1')
 {
 
if (parent.frames[0].document.forms[0].function_mode.value=='modify'){
TimePerPatientValid(obj);

}
 }
 else
 if(timetabletype == '2')
 {
 }
 else
 if(timetabletype == '3')
  parent.frames[0].document.forms[0].b_max_patients_per_day.focus();
 }
}
function validateBkTime1()
	{
	var t_type=frames[1].document.frames[0].document.forms[0].b_time_table_type.value;
	var time_dur='';
	var strt_tm=frames[1].document.frames[0].document.forms[0].b_start_time.value;
	if(t_type=='2'){
	time_dur=frames[1].document.frames[0].document.forms[0].b_time_per_slab.value;
	}else{
	time_dur=frames[1].document.frames[0].document.forms[0].b_time_per_patient.value;
	}
	
	var brk_flg=true;
	if(time_dur!=''){
				
	var arr1=strt_tm.split(":");
	var arr2=time_dur.split(":");
					
	var dur=(parseInt(arr2[0])*60) + parseInt(arr2[1]);
	var strt=(parseInt(arr1[0])*60) + parseInt(arr1[1]);
	if(frames[1].breaktime.document.forms[0].b_from_time1.value!=''){
	var arr3=frames[1].breaktime.document.forms[0].b_from_time1.value.split(":");
	var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);	
	var modu=(br-strt) % dur;
	if(modu>0){
alert(getMessage("BR_NT_ML_ST","OA"));
frames(1).breaktime.document.forms[0].b_from_time1.focus();
	brk_flg=false;
	}
	}

						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_from_time1.value!=''){
						 var arr3=frames[1].breaktime.document.forms[0].b_from_time1.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_from_time1.focus();
									brk_flg=false;
								}
							}
						}

						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_from_time2.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_from_time2.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_from_time2.focus();
									brk_flg=false;
								}
							}
						}

						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_to_time2.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_to_time2.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_to_time2.focus();
									brk_flg=false;
								}
							}
						}
						
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_from_time3.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_from_time3.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_from_time3.focus();
									brk_flg=false;
								}
							}
						}
						
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_to_time3.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_to_time3.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_to_time3.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_from_time4.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_from_time4.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_from_time4.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_to_time4.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_to_time4.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_to_time4.focus();
									brk_flg=false;
								}
							}
						}
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_from_time5.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_from_time5.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_from_time5.focus();
									brk_flg=false;
								}
							}
						}	
						if(brk_flg){
							if(frames[1].breaktime.document.forms[0].b_to_time5.value!=''){
								var arr3=frames[1].breaktime.document.forms[0].b_to_time5.value.split(":");
								var br=(parseInt(arr3[0])*60) + parseInt(arr3[1]);			
								var modu=(br-strt) % dur;	
								if(modu>0){
									alert(getMessage("BR_NT_ML_ST","OA"));
									frames[1].breaktime.document.forms[0].b_to_time5.focus();
									brk_flg=false;
								}
							}
						}
					
					}
					return (brk_flg);
}

function flipStar(){
var ch='';
var vls="";
vls=document.forms[0].identityCheckIn.value;
var si=document.forms[0].b_clinic.options.selectedIndex-1;
if (si==-1){
 ch='';
document.forms[0].resource.disabled = true;
 }
else{
 ch=vls.substr(si,1);
 document.forms[0].resource.disabled= false;
}
if (ch=='P'){
 document.getElementById("imgpract").style.display="";
}
else{
document.getElementById("imgpract").style.display="none";
}

}



function validateTbs(){
	
var clValue=document.forms[0].b_clinic.value;
var selLocation =document.forms[0].locationType.value;
if (clValue=='')
	document.forms[0].resource.disabled=true;
else
    document.forms[0].resource.disabled=false;

 if (!document.forms[0].b_pract_name.disabled)
     {
		document.forms[0].b_pract_name.value="";
		document.forms[0].b_pract_name.disabled=true;
		document.forms[0].pract_butt.disabled=true;
	 }

if (!document.forms[0].b_roster_reqd.disabled) document.forms[0].b_roster_reqd.disabled=true;

if (!document.forms[0].b_pract_name.disabled) document.forms[0].b_pract_name.value="";

document.forms[0].resource.options.selectedIndex=0;

if (!document.forms[0].b_day.disabled) document.forms[0].b_day.options.selectedIndex=0;
if (document.forms[0].b_roster_reqd.checked==true) document.forms[0].b_roster_reqd.checked=false;
document.forms[0].b_time_table_type.options.selectedIndex=0;
document.forms[0].b_start_time.value="";
document.forms[0].b_end_time.value="";
document.forms[0].b_time_per_patient.value="";
document.forms[0].b_max_slots_per_day.value="";
document.forms[0].b_max_patients_per_day.value="";
document.forms[0].b_time_per_slab.value="";
document.forms[0].b_max_patients_per_slab.value="";
document.forms[0].b_max_first_visit.value="";
document.forms[0].b_max_other_visits.value="";
document.forms[0].b_max_over_bookings.value="";
document.forms[0].b_no_forced_booking.value="";
document.forms[0].b_no_global_ref.value="";
document.forms[0].b_remarks.value="";
}


function practValidate(Obj){
var clinicCode=document.forms[0].b_clinic.value;
var resourceCode=document.forms[0].resource.value;

document.forms[0].b_pract_name.value="";
document.forms[0].b_practitioner.value="";
var vls = document.forms[0].primary_rec_class.value;
 var selIndex=document.forms[0].b_clinic.options.selectedIndex-1;
 var ch=vls.substr(selIndex,1);
if (clinicCode!=null && clinicCode!="" && resourceCode !=null && resourceCode!="")
	{
		document.forms[0].b_pract_name.disabled=false;
		document.forms[0].pract_butt.disabled=false;
	}
	else
	{
		document.forms[0].b_pract_name.disabled=true;
		document.forms[0].pract_butt.disabled=true;
	}
if (!document.forms[0].b_roster_reqd.disabled) document.forms[0].b_roster_reqd.disabled=true;

 obj1=document.forms[0].b_time_table_type;


if ((ch =='P' && Obj.value =='P') || (ch =='R' && Obj.value =='R') || (ch =='E' && Obj.value =='E') || (ch =='O' && Obj.value =='O'))
	{

  while (obj1.options.length > 0) obj1.remove(obj1.options[0]);
  opt=document.createElement('OPTION');
  opt.value='';
  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
  obj1.add(opt);
  opt1=document.createElement('OPTION');
  opt1.value='1';
  opt1.text=getLabel("Common.Slot.label","Common");
  obj1.add(opt1);
  opt2=document.createElement('OPTION');
  opt2.value='2';
  opt2.text=getLabel("eOA.slab.label","OA");
  obj1.add(opt2);
  opt3=document.createElement('OPTION');
  opt3.value='3';
  opt3.text=getLabel("Common.FreeFormat.label","Common");
  obj1.add(opt3);

	} else {
	 while (obj1.options.length > 0) obj1.remove(obj1.options[0]);
  opt=document.createElement('OPTION');
  opt.value='';
  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
  obj1.add(opt);
  opt1=document.createElement('OPTION');
  opt1.value='1';
  opt1.text=getLabel("Common.Slot.label","Common");
  obj1.add(opt1);
  opt2=document.createElement('OPTION');
  opt2.value='2';
  opt2.text=getLabel("eOA.slab.label","OA");
  obj1.add(opt2);
		 
		 }
if (resourceCode=='B'){
		document.forms[0].b_pract_name.disabled=true;
		document.forms[0].pract_butt.disabled=true;
	 }
}

function resourceOnBlur(){

	var selIn=document.forms[0].resource.options.selectedIndex;
	var valIs= document.forms[0].resource.options[selIn].value;
     document.getElementById("resourceType").value=valIs;
}

var startTimeArr ="";
var endTimeArr = "";
var durationTimeArr="";
var givenStTime=0;

function defaultTimes(){
var startTimeVls=document.forms[0].defaultStartTime.value;
var endTimeVls=document.forms[0].defaultEndTime.value;
var durationTimeVls=document.forms[0].defaultDuration.value;

startTimeArr=startTimeVls.split('|');
endTimeArr=endTimeVls.split('|');
durationTimeArr=durationTimeVls.split('|');
var selIndex=document.forms[0].b_clinic.options.selectedIndex;
if (document.forms[0].b_time_table_type.value==1 || document.forms[0].b_time_table_type.value==2 || document.forms[0].b_time_table_type.value==3){
	if((startTimeArr[selIndex]!="null" && startTimeArr[selIndex]!='')){
document.forms[0].b_start_time.value=startTimeArr[selIndex];
document.forms[0].b_end_time.value=endTimeArr[selIndex];
document.forms[0].defStartTime.value=startTimeArr[selIndex];
document.forms[0].defEndTime.value=endTimeArr[selIndex];
}
else {
document.forms[0].b_start_time.value="";
document.forms[0].b_end_time.value="";
document.forms[0].defStartTime.value="";
document.forms[0].defEndTime.value="";
}
}
document.forms[0].defDur.value=durationTimeArr[selIndex];
if (document.forms[0].b_time_table_type.value==1){
	if((durationTimeArr[selIndex]!="null" && durationTimeArr[selIndex]!='')){
	document.forms[0].b_time_per_patient.value=durationTimeArr[selIndex];
    TimePerPatientValid(document.forms[0].b_time_per_patient);
	}
	else {
	document.forms[0].b_time_per_patient.value="";
	

}
}
else if (document.forms[0].b_time_table_type.value==2) {
	if((durationTimeArr[selIndex]!="null" && durationTimeArr[selIndex]!='')){
document.forms[0].b_time_per_slab.value=durationTimeArr[selIndex];
	}
	else {
	document.forms[0].b_time_per_slab.value="";

}
}
}


function clearingNulls(){
var startTimeVls6=document.forms[0].defaultStartTime.value;
var endTimeVls6=document.forms[0].defaultEndTime.value;
var durationTimeVls6=document.forms[0].defaultDuration.value;
while(durationTimeVls6.indexOf('null')!=-1){
durationTimeVls6=durationTimeVls6.replace('null','');
}
while(startTimeVls6.indexOf('null')!=-1){
startTimeVls6=startTimeVls6.replace('null','');
}
while(endTimeVls6.indexOf('null')!=-1){
endTimeVls6=endTimeVls6.replace('null','');
}
document.forms[0].defaultStartTime.value=startTimeVls6;
document.forms[0].defaultEndTime.value=endTimeVls6;
document.forms[0].defaultDuration.value=durationTimeVls6;

}

function ValidateStTime(obj){
if (obj.value!=''){
  if (chkTime(obj.value)==false || checkColon(obj.value)==false){
var errors= getMessage("INVALID_TIME_FMT","SM");
alert(errors);
obj.value='';
obj.focus();
}
else
{
var selIndex=document.forms[0].b_clinic.options.selectedIndex;
var defTmVls=startTimeArr[selIndex];
var givenTmVls=document.forms[0].b_start_time.value;
if(defTmVls!=null && defTmVls!="" && defTmVls!="undefined"){
	
var defTmArr=defTmVls.split(':');
var givenTmArr=givenTmVls.split(':');
var curDt= new Date();
var defDt = new Date(curDt.getFullYear(),curDt.getMonth(),curDt.getDate(),defTmArr[0],defTmArr[1],0,0);
var givenDt= new Date(curDt.getFullYear(),curDt.getMonth(),curDt.getDate(),givenTmArr[0],givenTmArr[1],0,0);
var defTime=defDt.getTime();
givenStTime=givenDt.getTime();
if (defTime > givenStTime) {
alert(getMessage("ST_TIME_LS_DEF_ST_TIME","OA"));
document.forms[0].b_start_time.value=defTmVls;
document.forms[0].b_start_time.select();
document.forms[0].b_start_time.focus();
}
else{

Call_CheckTime(obj,'S');
}
}
}
}
}


function ValidateTimeDuration(obj){

	if (obj.value!=''){
		if (chkTime(obj.value)==false || checkColon(obj.value)==false){
			var errors= getMessage("INVALID_TIME_FMT","SM");
			alert(errors);
			obj.value='';
			obj.focus();
		}else{
			if (document.forms[0].b_start_time.value!='' && document.forms[0].b_end_time.value!='' && document.forms[0].b_time_per_patient.value!=''){
				var selIndex=document.forms[0].b_clinic.options.selectedIndex;
				var defDurValues=document.forms[0].defaultDuration.value;
				var defDurSplitVls=defDurValues.split('|');
				var defCurDur=defDurSplitVls[selIndex];
				if(defCurDur!="null" && defCurDur!="" && defCurDur!="undefined" ){
					var defDurationArray=defCurDur.split(':');
					var defHours= parseInt(defDurationArray[0]);
					 var defMinites=parseInt(defDurationArray[1]);
					 var defHourMilli=(defHours*60*60*1000);
					 var defMiniMilli=(defMinites*60*1000);
					var defMilliSec=(defHourMilli + defMiniMilli);
					 var givenDur=document.forms[0].b_time_per_patient.value;
					 var givenDurArr=givenDur.split(':');
					var givenHours= parseInt(givenDurArr[0]);
					 var givenMinites=parseInt(givenDurArr[1]);
					 var givenHourMilli=(givenHours*60*60*1000);
					 var givenMiniMilli=(givenMinites*60*1000);
					 var givenMilliSec=(givenHourMilli+givenMiniMilli);
					 var checkMultitude=(givenMilliSec%defMilliSec);

		if (checkMultitude!=0) {
			var error=getMessage("TIME_DEFAULT_DURATION","OA");
					alert(error +defCurDur);
document.forms[0].b_time_per_patient.value=defCurDur;
document.forms[0].b_time_per_patient.select();
document.forms[0].b_time_per_patient.focus();
}else{
	TimePerPatientValid(obj);
}
}
else
{
	TimePerPatientValid(obj);
}
}
}
}
}



function ValidateTimeDurationForSlab(obj){
if (obj.value!=''){
	if (chkTime(obj.value)==false){
	var errors= getMessage("INVALID_TIME_FMT","SM");
	alert(errors);
	obj.value='';
	obj.focus();
	}else{

		var selIndex=document.forms[0].b_clinic.options.selectedIndex;
		var defDurValues=document.forms[0].defaultDuration.value;
		
		var defDurSplitVls=defDurValues.split('|');
		var defCurDur=defDurSplitVls[selIndex];
		
		if (defCurDur=='') return;
		var defDurationArray=defCurDur.split(':');
		var defHours= parseInt(defDurationArray[0]);
		 var defMinites=parseInt(defDurationArray[1]);
		 var defHourMilli=(defHours*60*60*1000);
		 var defMiniMilli=(defMinites*60*1000);
		var defMilliSec=(defHourMilli + defMiniMilli);
		 var givenDur=document.forms[0].b_time_per_slab.value;
		 var givenDurArr=givenDur.split(':');
		var givenHours= parseInt(givenDurArr[0]);
		 var givenMinites=parseInt(givenDurArr[1]);
		 var givenHourMilli=(givenHours*60*60*1000);
		 var givenMiniMilli=(givenMinites*60*1000);
		 var givenMilliSec=(givenHourMilli+givenMiniMilli);
		 var checkMultitude=(givenMilliSec/defMilliSec);
		var intPart=Math.floor(checkMultitude);
		var decPart=checkMultitude-intPart;

		 if (decPart!=0) {
			 	var error=getMessage("TIME_DEFAULT_DURATION","OA");
					alert(error +defCurDur);
			document.forms[0].b_time_per_slab.value=defCurDur;
			document.forms[0].b_time_per_slab.focus();
		}else{
			TimePerSlab(obj,'X');
		}

}
}
}


function clearFields(obj){
   var selIndex=obj.options.selectedIndex;
   document.forms[0].reset();
   obj.options.selectedIndex=selIndex;
   if (!document.forms[0].b_roster_reqd.disabled) document.forms[0].b_roster_reqd.disabled=true;
   if (!document.forms[0].resource.disabled) document.forms[0].resource.disabled=true;
   if (!document.forms[0].b_pract_name.disabled) document.forms[0].b_pract_name.disabled=true;
   if (!document.forms[0].pract_butt.disabled) document.forms[0].pract_butt.disabled=true;
   var selValue=obj.value;
   var obj1=document.forms[0].b_time_table_type;
   if (selValue!='C' && selValue!=''){
	   while(obj1.options.length>0) obj1.remove(obj1.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	   obj1.add(opt);
	   opt1=document.createElement('OPTION');
	   opt1.value='1';
	   opt1.text=getLabel("Common.Slot.label","Common");
	   obj1.add(opt1);
	   opt2=document.createElement('OPTION');
	   opt2.value='2';
	   opt2.text=getLabel("eOA.slab.label","OA");
	   obj1.add(opt2);

   }
   else if (selValue=='' || selValue=='C'){
	   var len=obj1.options.length;
	   if (len < 4){ 
		  
	   opt3=document.createElement('OPTION');
	   opt3.value='3';
	   opt3.text=getLabel("Common.FreeFormat.label","Common");
	   obj1.add(opt3);
	   }
   }
   
   if (selValue=='D'){
	 var res=document.forms[0].resource;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
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
   else{  //if (selValue!='')
	   var res=document.forms[0].resource;
	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
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
   return obj;
}


function rostertype()
	{
	 if (TimeTable.b_roster_reqd.checked == true)
		TimeTable.b_roster_reqd.value="Y";
	 else
		TimeTable.b_roster_reqd.value="N";
	}


function forcedtype(){
	if(TimeTable.b_forced_allowed_yn.checked){
		TimeTable.b_forced_allowed_yn.value="Y";
		if(TimeTable.b_time_table_type.value=='' || TimeTable.b_time_table_type.value=='3'){
			
			
			TimeTable.b_forced_allowed_yn.checked=false;
			TimeTable.b_no_forced_booking.disabled=true;
		}else{
			TimeTable.b_no_forced_booking.disabled=false;
			document.getElementById("forced").style.visibility='visible';
			
		}
	}else{
		TimeTable.b_no_forced_booking.disabled=true;
		TimeTable.b_no_forced_booking.value='';
		document.getElementById("forced").style.visibility='hidden';
		
	}
}


function allowforced()
{
	if(TimeTable.b_time_table_type.value=='' || TimeTable.b_time_table_type.value=='3')
	{
		TimeTable.b_forced_allowed_yn.disabled=true;
	}
	else
	{
		TimeTable.b_forced_allowed_yn.disabled=false;
	}
	
}

function hidePractgif()
{
	document.getElementById("imgpract").style.visibility='hidden';
	document.getElementById("t_per_pat").style.visibility='hidden'
	document.getElementById("mx_pat_per_day").style.visibility='hidden'
	document.getElementById("t_per_slab").style.visibility='hidden'
	document.getElementById("mx_per_slab").style.visibility='hidden'
}

function displayMandatory(Obj)
{
	document.forms[0].b_max_other_visits.value ="";
	document.forms[0].b_max_patients_per_slab.value="";
	document.forms[0].b_max_other_visits.value="";
	document.forms[0].b_max_first_visit.value ="";
	document.forms[0].b_max_over_bookings.value ="";
	document.forms[0].b_time_per_slab.value="";
	document.forms[0].b_max_patients_per_day.value="";
	document.forms[0].b_time_per_patient.value="";
    document.forms[0].b_start_time.value='';
	document.forms[0].b_end_time.value='';

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
	document.getElementById("mx_per_slab").style.visibility='hidden';
	document.getElementById("forced").style.visibility='hidden';
	}

}





function PractLookupRetVal(retVal,objName)
{
var arr;

if (retVal!=null){
if (!(unescape(retVal) == null))
{
	
	arr=unescape(retVal).split("~");
	document.forms[0].b_practitioner.value=arr[0];
	document.forms[0].b_pract_name.value=arr[1];
	document.forms[0].b_day.disabled=false;
	document.forms[0].b_roster_reqd.disabled=false;
	
}
else
	{
document.forms[0].b_pract_name.focus();
document.forms[0].b_practitioner.value="";
document.forms[0].b_pract_name.value="";
	}
}else{
document.forms[0].b_pract_name.focus();
document.forms[0].b_practitioner.value="";
document.forms[0].b_pract_name.value="";
}

}



function validateBkTime(fmTime,toTime,i){

fmTm=eval(fmTime+".value");
if (fmTm!='' && toTime.value!=''){
	  if (chkTime(toTime.value)==false){
		  errors=getMessage("INVALID_TIME_FMT","SM");
	      alert(errors);
		  toTime.select();
		  toTime.focus();
}else
	{
	
	obj=parent.frames[0].document.forms[0].b_time_table_type;
	

	if (obj.value==1)
	defTime=parent.frames[0].document.forms[0].b_time_per_patient.value;
	else if (obj.value==2)
    defTime=parent.frames[0].document.forms[0].b_time_per_slab.value;
	
	
	if (obj.value==1 || obj.value==2 ){
fmTimeArr=fmTm.split(':');
toTimeValue=toTime.value
toTimeArr=toTimeValue.split(':');

defTimeArr=defTime.split(':');
defTimeHour=parseInt(defTimeArr[0]);
defTimeMinute=parseInt(defTimeArr[1]);
defTimeInMilliSec=(defTimeHour*60*60*1000)+(defTimeMinute*60*1000);
fmTimeHour=parseInt(fmTimeArr[0]);
fmTimeMinute=parseInt(fmTimeArr[1]);
toTimeHour=parseInt(toTimeArr[0]);
toTimeMinute=parseInt(toTimeArr[1]);
fmTimeMilliSec=(fmTimeHour*60*60*1000)+(fmTimeMinute*60*1000);
toTimeMilliSec=(toTimeHour*60*60*1000)+(toTimeMinute*60*1000);

diffInMilliSec=toTimeMilliSec-fmTimeMilliSec;
checkMultiple=diffInMilliSec%defTimeInMilliSec;
if (checkMultiple!=0) {
	//alert("APP-000001 Break time Must Be multiple of Given Duration");
	alert(getMessage("BR_NT_ML_DR","OA"));
	toTime.select();
	toTime.focus(); 
}
 else{
	 ChkTime(toTime);
	 CallToBreakTimeValidation(toTime,i);
 }
}
if(obj.value==3)
{
	ChkTime(toTime);
	 CallToBreakTimeValidation(toTime,i);
}
}
}
}

function forcedtype1()
{
	if(TimeTable.b_forced_allowed_ynchecked.checked  )
    {
		TimeTable.b_forced_allowed_ynchecked.value="Y";
		if(TimeTable.b_time_table_type.value=='' || TimeTable.b_time_table_type.value=='3')
		{
			TimeTable.b_forced_allowed_ynchecked.checked=false;
			TimeTable.b_no_forced_booking.disabled=true;
		}else
		{
			TimeTable.b_no_forced_booking.disabled=false;
			document.getElementById("forced").style.visibility='visible';
		}
	}else
	{
		TimeTable.b_no_forced_booking.disabled=true;
		TimeTable.b_no_forced_booking.value='';
		document.getElementById("forced").style.visibility='hidden';
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
					var calling_from='apply';					
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH calling_from=\""+calling_from+"\" starttime=\""+start_time+"\" endtime=\""+end_time+"\"  timeperpatient=\""+time_per_patient+"\"  maxpatcat=\""+l_max_pat_category+"\" /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","TimeTableMaxPatients.jsp",false);
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
//new function MaxPatPerSlab_new() Added by S.Sathish for IN020308 on Thursday, April 01, 2010
function MaxPatPerSlab_new()
{  	
	var timetabletype 	= frames[1].document.forms[0].time_table_type.value ;
	var l_max_pat_category	= "2" ;
	var start_time	     	= frames[1].document.forms[0].start_time.value ;
	var end_time	     	=frames[1].document.forms[0].end_time.value ;
	var l_time_per_slab	= frames[1].document.forms[0].time_per_slab.value ;
	var l_max_pat_per_slab	=frames[1].document.forms[0].max_patients_per_slab.value ;
	
	if (timetabletype == '2')
	{		
		
		if(l_time_per_slab != ""){
		
					var calling_from='apply';					
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH calling_from=\""+calling_from+"\" starttime=\""+start_time+"\" endtime=\""+end_time+"\"  timeperslab=\""+l_time_per_slab+"\"  maxpatperslab=\""+l_max_pat_per_slab+"\"  maxpatcat=\""+l_max_pat_category+"\"/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","TimeTableMaxPatients.jsp",false);
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




