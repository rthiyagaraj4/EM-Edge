$( document ).ready(function() {
	$("#specialityList").focus();
});
function fnGetPractitionerList(obj){
	var specialityCode	= obj.value;
	var jsonArguments	= {
							'specialityCode':specialityCode,
							'action':'getPratitionerList'
						 };


	if(specialityCode!=""){
		$("#divPractitionerList").html("<div class='processing'><img src='../patientportal/ajax-loader.gif' alt='Loading..' align='center' style='margin:100px 0 0 500px;'></div>");
		$.ajax({  
			 url:'../../eOA/jsp/patientPortalConfigIntermediate.jsp',  
			 type:'post',  
			 data:jsonArguments,
			 dataType: 'json',
			 success: function(data) {
				
				 var DisplayData					= "";
				 var clinic_code					= "";
				 var clinic_desc					= "";
				 var pract_id						= "";
				 var pract_desc						= "";
				 var tdclass						= "";
				 var prev_clinic_pract_id			= "";
				 var cur_clinic_pract_id			= "";
				 var max_patients_per_day			= "";
				 var time_table_type				= "";
				 var resource_type					= "";
				 var locn_type						= "";
				 var availableDays					= "";
				 var slot_slab_interval				= "";
				 var patient_per_slot_slab			= "";
				 var srl_no							= "";
				 parent.availableDaysArr			= {};
				 parent.storedDaysArr				= {};
				 parent.storedDaysArrwithDayNo		= {};
				 parent.breakeTimingwithDayNo		= {};
				 parent.breakeTimingwithDayNoInSec	= {};
				 parent.misMatchedTimeTableList		= {};
				 var hiddenFields					= "";
				 var i								= 1;
				 var className						= "";
				 
				 if(data!=null){
						 if(data.error==""){
							 if(data.rowCnt > 0){
								var recordlist		= eval(data.PratitionerList);
								var daysList1		= eval(data.daysList);
								 $.each(daysList1,function(index,value){
									parent.daysList[value.day_no]	= value.day_of_week;
								 });



								DisplayData			= '<table width="100%" border="0" cellspacing="0" cellpadding="0">';
								DisplayData		   +=	'<tr class="Header">';
								DisplayData		   +=		'<td width="2%" align="center" valign="middle">&nbsp;</td>';
								DisplayData		   +=		'<td width="15%" align="center" valign="middle" class="TdHeader">'+getLabel("Common.resourcename.label","Common")+'</td>';
								DisplayData		   +=		'<td width="15%" align="center" valign="middle" class="TdHeader">'+getLabel("Common.clinic.label","Common")+'</td>';
								DisplayData		   +=		'<td width="60%" align="center" valign="middle" class="TdHeader"> '+getLabel("eOA.ScheduleDetail.label","OA")+'</td>';
								DisplayData		   +=		'<td width="8%" align="center" valign="middle">&nbsp;</td>';
								DisplayData		   +=	"</tr></table>";
								DisplayData		   +=	'<div style=" height:400px;overflow:auto;"><table width="100%" border="0" cellspacing="0" cellpadding="0" >';
								
								var storedRowCount	= 0;

								/*Recorded Data generation Start*/
								if(data.availableRowCnt){
										storedRowCount		= data.availableRowCnt;
											if(data.eff_status=="Y"){
												$("#isEnabled").prop('checked',true);
											}else{
												$("#isEnabled").prop('checked',false);
											}

											var s_locn_code					= "";
											var s_locn_type					= "";
											var s_resource_id				= "";
											var s_day_no					= "";
											var s_start_time				= "";
											var s_end_time					= "";
											var s_noOfSlots					= "";
											var s_prev_clinic_pract_id		= "";
											var s_cur_clinic_pract_id		= "";
											var S_clinic_desc				= "";
											var s_pract_desc				= "";
											var S_resource_type				= "";
											var s_time_table_type			= "";
											var s_time_per_patient			= "";
											var storedData					= "";
											var s_slot_slab_interval		= "";
											var s_patient_per_slot_slab		= "";
											var s_srl_no					= "";
											var s_org_start_time			= "";
											var s_org_end_time				= "";
											var s_org_no_of_slots			= "";
											var s_org_time_table_type		= "";
											
											var s_index						= "";

											var storedRecordList			= eval(data.StoredPratitionerList);
											$.each(storedRecordList,function(s_index,s_value){
																			
												s_locn_code					= s_value.locn_code;
												s_locn_type					= s_value.locn_type;
												s_resource_id				= s_value.resource_id;
												s_day_no					= s_value.day_no;
												s_start_time				= s_value.start_time;
												s_end_time					= s_value.end_time;
												s_noOfSlots					= s_value.no_of_slots;
												s_clinic_desc				= s_value.clinic_short_desc;
												s_pract_desc				= s_value.practitioner_short_name;
												s_resource_type				= s_value.resource_type;
												s_time_table_type			= s_value.time_table_type;
												s_time_per_patient			= s_value.time_per_patient;
												s_srl_no					= s_value.srl_no;
												s_org_start_time			= s_value.org_start_time; 
												s_org_end_time				= s_value.org_end_time;
												s_org_no_of_slots			= s_value.org_no_of_slots; 
												s_org_time_table_type		= s_value.org_time_table_type; 


												if(s_time_table_type==1){
													s_slot_slab_interval		= s_value.time_per_patient;
													s_patient_per_slot_slab	= 1;
												}else if(s_time_table_type==2){
													s_slot_slab_interval	= s_value.time_per_slab;
													s_patient_per_slot_slab	= s_value.max_patients_per_slab;
												}				


												s_cur_clinic_pract_id		= s_locn_code+"_"+s_resource_id;

												s_index					= s_locn_code+"_"+s_resource_id+"_"+s_day_no;
												parent.storedDaysArrwithDayNo[s_index]	= s_day_no+"|~|"+s_start_time+"|~|"+s_end_time+"|~|"+s_locn_code+"|~|"+s_resource_id+"|~|"+s_noOfSlots+"|~|"+s_time_per_patient+"|~|"+s_slot_slab_interval+"|~|"+s_time_table_type+"|~|"+s_patient_per_slot_slab+"|~|"+s_srl_no+"|~|"+s_org_start_time+"|~|"+s_org_end_time+"|~|"+s_org_no_of_slots+"|~|"+s_org_time_table_type;
												
												if(s_cur_clinic_pract_id!=s_prev_clinic_pract_id){
													s_prev_clinic_pract_id	= s_locn_code+"_"+s_resource_id;
													s_index					= s_locn_code+"_"+s_resource_id+"_"+s_day_no;
													storedData		= "";
													storedData		= s_day_no+"|~|"+s_start_time+"|~|"+s_end_time+"|~|"+s_locn_code+"|~|"+s_resource_id+"|~|"+s_noOfSlots+"|~|"+s_time_per_patient+"|~|"+s_slot_slab_interval+"|~|"+s_time_table_type+"|~|"+s_patient_per_slot_slab+"|~|"+s_srl_no+"|~|"+s_org_start_time+"|~|"+s_org_end_time+"|~|"+s_org_no_of_slots+"|~|"+s_org_time_table_type+"###";
													
													
													if(i%2==0){
														className	= "rowB";
													}else{
														className	= "rowA";
													}	

													DisplayData		+= "<input type='hidden' id='locn_type_"+s_prev_clinic_pract_id+"' value='"+s_locn_type+"'/>";
													DisplayData		+= "<input type='hidden' id='pract_id_"+s_prev_clinic_pract_id+"' value='"+s_resource_id+"'/>";
													DisplayData		+= "<input type='hidden' id='clinic_code_"+s_prev_clinic_pract_id+"' value='"+s_locn_code+"'/>";
													DisplayData		+= "<input type='hidden' id='resource_type_"+s_prev_clinic_pract_id+"' value='"+s_resource_type+"'/>"



													var tableRowsStoredData	= fnGenerateTableRows(s_prev_clinic_pract_id,className,s_pract_desc,s_clinic_desc,"checked");//function for generating table rows.
													DisplayData		+= tableRowsStoredData;

													i++;
													
													parent.storedDaysArr[s_prev_clinic_pract_id]	= storedData;
													
												}else{
													storedData		+= s_day_no+"|~|"+s_start_time+"|~|"+s_end_time+"|~|"+s_locn_code+"|~|"+s_resource_id+"|~|"+s_noOfSlots+"|~|"+s_time_per_patient+"|~|"+s_slot_slab_interval+"|~|"+s_time_table_type+"|~|"+s_patient_per_slot_slab+"|~|"+s_srl_no+"|~|"+s_org_start_time+"|~|"+s_org_end_time+"|~|"+s_org_no_of_slots+"|~|"+s_org_time_table_type+"###";
													parent.storedDaysArr[s_prev_clinic_pract_id]	= storedData;
												}
											});
										}

								/*Recorded Data generation End*/
								
								$.each(recordlist,function(index,value){
									cur_clinic_pract_id	= value.clinic_code+"_"+value.practitioner_id;

									clinic_code					= value.clinic_code;
									clinic_desc					= value.clinic_short_desc;
									pract_id					= value.practitioner_id;
									pract_desc					= value.practitioner_short_name;
									max_patients_per_day		= value.max_patients_per_day;
									time_table_type				= value.time_table_type;
									resource_type				= value.resource_class;
									locn_type					= value.care_locn_type_ind;
									srl_no						= value.srl_no;


									if(time_table_type==1){
										slot_slab_interval		= value.time_per_patient;
										patient_per_slot_slab	= 1;
									}else if(time_table_type==2){
										slot_slab_interval		= value.time_per_slab;
										patient_per_slot_slab	= value.max_patients_per_slab;
									}

									if(cur_clinic_pract_id!=prev_clinic_pract_id){
										prev_clinic_pract_id	= clinic_code+"_"+pract_id;
										availableDays	= "";
										availableDays	= value.day_no+"|~|"+value.start_time+"|~|"+value.end_time+"|~|"+clinic_code+"|~|"+pract_id+"|~|"+max_patients_per_day+"|~|"+slot_slab_interval+"|~|"+time_table_type+"|~|"+patient_per_slot_slab+"|~|"+srl_no+"###";
										if(i%2==0){
											className	= "rowB";
										}else{
											className	= "rowA";
										}
										var checked		= "";
										var isAlreadyGenerated	= false;
										if(prev_clinic_pract_id in parent.storedDaysArr){
											isAlreadyGenerated	= true;
										}
										if(!isAlreadyGenerated){
											DisplayData		+= "<input type='hidden' id='locn_type_"+prev_clinic_pract_id+"' value='"+locn_type+"'/>";
											DisplayData		+= "<input type='hidden' id='pract_id_"+prev_clinic_pract_id+"' value='"+pract_id+"'/>";
											DisplayData		+= "<input type='hidden' id='clinic_code_"+prev_clinic_pract_id+"' value='"+clinic_code+"'/>";
											DisplayData		+= "<input type='hidden' id='resource_type_"+prev_clinic_pract_id+"' value='"+resource_type+"'/>";
											var tableRows	= fnGenerateTableRows(prev_clinic_pract_id,className,pract_desc,clinic_desc,checked);//function for generating table rows.
											DisplayData		+= tableRows;
										}
									
										i++;
										parent.availableDaysArr[prev_clinic_pract_id]	= availableDays;
									}else{

										availableDays	+= value.day_no+"|~|"+value.start_time+"|~|"+value.end_time+"|~|"+clinic_code+"|~|"+pract_id+"|~|"+max_patients_per_day+"|~|"+slot_slab_interval+"|~|"+time_table_type+"|~|"+patient_per_slot_slab+"|~|"+srl_no+"###";
										parent.availableDaysArr[prev_clinic_pract_id]	= availableDays;
									}

								});

								DisplayData			   += '</table></div>';

								$.each(parent.availableDaysArr,function(clinicCode_PractionerId,value){
									hiddenFields		+= "<input type='hidden' id='hidden_"+clinicCode_PractionerId+"' value='"+parent.availableDaysArr[clinicCode_PractionerId]+"' />";
									hiddenFields		+= "<input type='hidden' id='hidden_saved_"+clinicCode_PractionerId+"' value='"+parent.availableDaysArr[clinicCode_PractionerId]+"' />";
								 });
								
								 DisplayData			+= hiddenFields;
							 }
					 }else{
						 alert(data.error);
					 }
				 }
					
					$("#divPractitionerList").html(DisplayData).hide();


					 /*Calculate Break Time Start*/

					var breakTimeListCnt	= data.breakTimeListCnt;
					var breakTimeList		= "";
					if(breakTimeListCnt > 0){
						breakTimeList		= eval(data.breakTimeLists);
						var b_pract_id		= "";
						var b_clinic_code	= "";
						var b_day_no		= "";
						var b_start_time	= "";
						var b_end_time		= "";
						var b_time_sec		= "";
						var index			= "";
						var breakTimesAll	= "";
						var chk_index		= "";
						var breakTimeInsec	= 0;
						$.each(breakTimeList,function(ind,val){
							b_pract_id		= val.practitioner_id;
							b_clinic_code	= val.clinic_code;
							b_day_no		= val.day_no;
							b_start_time	= val.b_start_time;
							b_end_time		= val.b_end_time;
							b_time_sec		= val.diff_in_seconds;
							index			= val.clinic_code+"_"+val.practitioner_id+"_"+val.day_no;
						
							if(index!=chk_index){
								chk_index										= b_clinic_code+"_"+b_pract_id+"_"+b_day_no;
								breakTimesAll									= b_day_no+"|~|"+b_start_time+"|~|"+b_end_time+"|~|"+b_clinic_code+"|~|"+b_pract_id+"|~|"+b_time_sec+"###";
								breakTimeInsec									= parseInt(b_time_sec);
								parent.breakeTimingwithDayNo[chk_index]			= breakTimesAll;//break time list for a day        
								parent.breakeTimingwithDayNoInSec[chk_index]	= breakTimeInsec; //break time for a day in seconds
							}else{
								breakTimesAll									+= b_day_no+"|~|"+b_start_time+"|~|"+b_end_time+"|~|"+b_clinic_code+"|~|"+b_pract_id+"|~|"+b_time_sec+"###";
								breakTimeInsec									+= parseInt(b_time_sec);
								parent.breakeTimingwithDayNo[chk_index]			= breakTimesAll;//break time list for a day
								parent.breakeTimingwithDayNoInSec[chk_index]	= breakTimeInsec; //break time for a day in seconds
							}
						});
					}
					/*Calculate Break Time End*/
					fnGenerateTableRowAvailDays("",document);/*To Display the avail days data in table row*/

					$("#divPractitionerList").fadeIn(2000);

			 },
			 error: function(jqXHR, textStatus, errorThrown) {
					$("#divPractitionerList").html("Error fetching practioner list");
			 }
		 });
	 }else{
		$("#divPractitionerList").html("");
	}
}

function fnGenerateTableRows(prev_clinic_pract_id,className,pract_desc,clinic_desc,checked){
	
	var returnTableRowsData	= "";
	
	//returnTableRowsData		+= "<tr class='"+className+"'>";
	returnTableRowsData		+= "<tr class='"+className+"'>";
	returnTableRowsData		+=		'<td width="2%" align="center" valign="middle">'
	returnTableRowsData		+=			'<input type="checkbox" name="practList"  id="'+prev_clinic_pract_id+'" value="'+prev_clinic_pract_id+'" onclick="fnChkClick(this,document);" '+checked+'/>';
	returnTableRowsData		+=		'</td>';
	returnTableRowsData		+=		'<td width="15%" align="left" valign="middle">'+pract_desc+'</td>';
	returnTableRowsData		+=		'<td width="16%" align="left" valign="middle">'+clinic_desc+'</td>';
	returnTableRowsData		+=		'<td width="60%" align="left" valign="middle">';
	returnTableRowsData		+=			'<table width="100%" border="0" cellspacing="0" cellpadding="0">';
	returnTableRowsData		+=				'<tr><td align="left" valign="middle" id="avail_days_list_'+prev_clinic_pract_id+'">';
	returnTableRowsData		+=				'</td></tr>';
	returnTableRowsData		+=			'</table>';
	returnTableRowsData		+=		'</td>';
	returnTableRowsData		+=		'<td width="8%" align="right" valign="middle">';
	returnTableRowsData		+=			'<img src="../patientportal/save_accept.png" width="24"  height="24"  style="display:none;" />';
	returnTableRowsData		+=			'<img src="../patientportal/Edit.png" width="24" height="24" id="edit_'+prev_clinic_pract_id+'" onclick="return fnShowAvailableDays(\''+prev_clinic_pract_id+'\',document)"/>';
	returnTableRowsData		+=			'<img src="../patientportal/Save.png" width="24" height="24" id="save_'+prev_clinic_pract_id+'" style="display:none;" onclick="return fnSave(\''+prev_clinic_pract_id+'\',document)"/>';
	returnTableRowsData		+=			'<img src="../patientportal/Close.png" width="24" height="24" id="close_'+prev_clinic_pract_id+'" style="display:none;" onclick="return fnClose(\''+prev_clinic_pract_id+'\',document,\'reset\')" />';
	returnTableRowsData		+=		'<input type="hidden" id="isEnableClose_'+prev_clinic_pract_id+'" value="N" />';
	returnTableRowsData		+=		'</td>';
	returnTableRowsData		+= "</tr>";
	returnTableRowsData		+= "<tr class='"+className+"' style='display:none;' id='avail_"+prev_clinic_pract_id+"'></tr>";


	return returnTableRowsData;
}



function fnGenerateAvailableList(clinicCode_PracId){
	var practAvailableDays	= parent.availableDaysArr[clinicCode_PracId].slice(0,-3); //get practioner availbledays from global variable
	var dayListArr			= practAvailableDays.split("###");//practioner availbledays each days in array

	var returnData	= "";
	returnData		= '<td align="center" valign="middle">&nbsp;</td><td colspan="4" align="left" valign="middle">';
	returnData		+=		'<table width="100%" border="1" cellspacing="0" cellpadding="0" class="border">';
	returnData		+=			'<tr class="SubHeader">';
	returnData		+=				'<td width="15%" align="left" valign="middle">'+getLabel("Common.available.label","Common")+'&nbsp;'+getLabel("Common.days.label","Common")+' <br/><span class="err" id="err_avail_days_'+clinicCode_PracId+'"></span></td>';
	returnData		+=				'<td width="16%" align="left" valign="middle">'+getLabel("Common.available.label","Common")+'&nbsp;'+getLabel("Common.time.label","Common")+' ('+getLabel("eOA.NoofSlots.label","OA")+')</td>';
	returnData		+=				'<td width="18%" align="left" valign="middle">'+getLabel("Common.StartTime.label","Common")+'</td>';
	returnData		+=				'<td width="17%" align="left" valign="middle">'+getLabel("Common.EndTime.label","Common")+'</td>';
	returnData		+=				'<td width="17%" align="left" valign="middle">'+getLabel("Common.available.label","Common")+'&nbsp;'+getLabel("Common.Slot.label","Common")+'(s)/'+getLabel("eOA.slab.label","OA")+'(s)</td>';
	returnData		+=				'<td width="17%" align="left" valign="middle">Portal '+getLabel("eOA.SlotsSlabsAllocated.label","OA")+'</td>';
	returnData		+=			'</tr>';
	
	var org_start_time			= "";
	var org_end_time			= "";
	var org_no_of_slots			= "";
	var org_time_table_type		= "";
	var errDayno				= "";
	$.each(dayListArr,function(index,value){
		var individualDays					= value.split("|~|");
		var dayNo							= individualDays[0];
		var startTime						= individualDays[1];
		var endTime							= individualDays[2];
		var clinic_code						= individualDays[3];
		var pract_id						= individualDays[4];
		var max_patients_per_day			= individualDays[5];
		var slot_slab_interval				= individualDays[6];
		var time_table_type					= individualDays[7];
		var patient_per_slot_slab			= individualDays[8];
		var srl_no							= individualDays[9];
		
		var startTimeDisplay				= startTime;
		var endTimeDisplay					= endTime;
		var max_patients_per_day_display	= max_patients_per_day;


		var max_patients_per_day_dispaly	= individualDays[5];
		var startEndTimeDisplay		= startTime+" - "+endTime;
		var breakTimeInlineNone		= "none;";
		var displayBreakTime		= "";
		var slabText				= "";
		if(time_table_type==2){
			slabText				= '<img src="../patientportal/slab-icon.png" width="16" height="16" title="'+getLabel("eOA.maxpatperslab.label","OA")+' : '+patient_per_slot_slab+'"/>';
		}
				

		if(parent.daysList[dayNo]!=""){
			
			var chk_id					= clinic_code+"_"+pract_id+"_"+dayNo;
			var checked					=" ";
			returnData					+= '<input type="hidden" id="patient_per_slot_slab_'+chk_id+'" value="'+patient_per_slot_slab+'" />';	
			returnData					+= '<input type="hidden" id="time_table_type_'+chk_id+'" value="'+time_table_type+'" />';	
			returnData					+= '<input type="hidden" id="chk_start_time_'+chk_id+'" value="'+startTime+'" />';	
			returnData					+= '<input type="hidden" id="chk_end_time_'+chk_id+'" value="'+endTime+'" />';
			returnData					+= '<input type="hidden" id="slot_slab_interval_'+chk_id+'" value="'+slot_slab_interval+'" />';	
			returnData					+= '<input type="hidden" id="chk_portal_avail_slots_'+chk_id+'" value="'+max_patients_per_day_dispaly+'" />';	
			returnData					+= '<input type="hidden" id="org_portal_avail_slots_'+chk_id+'" value="'+max_patients_per_day_dispaly+'" />';	
			returnData					+= '<input type="hidden" id="srl_no_'+chk_id+'" value="'+max_patients_per_day_dispaly+'" />';	

			
			if(chk_id in parent.breakeTimingwithDayNo){
				breakTimeInlineNone		= "inline;";
				var breakListArr			= parent.breakeTimingwithDayNo[chk_id].split("###");//practioner availbledays each days in array
				$.each(breakListArr,function(btimeind,btime){
					var indBreakTiming	= btime.split("|~|");
					if(indBreakTiming!=""){
						displayBreakTime	+= indBreakTiming[1] +" - "+ indBreakTiming[2] +", ";
					}
				});
				displayBreakTime			= displayBreakTime.slice(0,-2);	 
			}
			var errClass					= "";

			if(chk_id in parent.storedDaysArrwithDayNo){
				checked		= "checked";
				individualDays					= parent.storedDaysArrwithDayNo[chk_id].split("|~|");
				dayNo							= individualDays[0];
				startTimeDisplay				= individualDays[1];
				endTimeDisplay					= individualDays[2];
				clinic_code						= individualDays[3];
				pract_id						= individualDays[4];
				max_patients_per_day_display	= individualDays[5];
				srl_no							= individualDays[10];
				
				org_start_time					= individualDays[11];
				org_end_time					= individualDays[12];
				org_no_of_slots					= individualDays[13];
				org_time_table_type				= individualDays[14];

				if(org_start_time!=startTime || org_end_time!=endTime || org_no_of_slots!=max_patients_per_day || org_time_table_type!=time_table_type){
					errClass ='errTimeTable';
					errDayno	+= dayNo+"~";
					startTimeDisplay	= startTime;
					endTimeDisplay		= endTime;
					max_patients_per_day_display	= max_patients_per_day;
				}
			}

			returnData		+=	'<tr class="Subtable" >';
			returnData		+=		'<td align="left" valign="middle">';
			returnData		+=			'<table width="100%" border="0" cellspacing="0" cellpadding="0" >';
			returnData		+=				'<tr>';
			returnData		+=					'<td width="84%" align="left" valign="middle">';
			returnData		+=						'<input type="checkbox" name="chk_'+clinicCode_PracId+'" id="chk_'+chk_id+'" value="'+dayNo+'" '+checked+'/>&nbsp;'+parent.daysList[dayNo];
			returnData		+=					'</td>';
			returnData		+=					'<td width="16%" align="right" valign="middle">';
			returnData		+=						'<img src="../patientportal/Break.png" width="16" height="16" style="display:'+breakTimeInlineNone+'" class="masterTooltip" title="'+displayBreakTime+'"/>';
			returnData		+=					'</td>';
			returnData		+=				'</tr>';
			returnData		+=			'</table>';
			returnData		+=		'</td>';
			returnData		+=		'<td align="left" valign="middle">';
			returnData		+=			'<table width="100%" border="0" cellspacing="0" cellpadding="0" >';
			returnData		+=				'<tr>';
			returnData		+=					'<td width="84%" align="left" valign="middle" class='+errClass+' >'+startEndTimeDisplay+'</td>';
			returnData		+=					'<td width="16%" align="right" valign="middle">';
			returnData		+=						'<span class="Available '+errClass+'">'+max_patients_per_day+'</span>';
			returnData		+=					'</td>';
			returnData		+=				'</tr>';
			returnData		+=			'</table>';
			returnData		+=		'</td>';

			returnData		+=		'<td align="left" valign="middle" class="Subtabletxt">';
			returnData		+=			'<input type="text" name="start_time_'+chk_id+'" id="start_time_'+chk_id+'" size="10" value="'+startTimeDisplay+'" maxlength="5" onblur="return fnCheckTimeFormat(this,\'start_time\',\''+chk_id+'\')"/>';
			//returnData		+=			'<input type="text" name="start_time_'+chk_id+'"  id="start_time_'+chk_id+'" size="10" value="'+startTimeDisplay+'" maxlength="5" onblur="return fnCheckTimeFormat(this,\'start_time\',\''+chk_id+'\')"/>';
			returnData		+=			'<br/><span class="err" id="err_start_time_'+chk_id+'"></span>';
			returnData		+=		'</td>';

			returnData		+=		'<td align="left" valign="middle" class="Subtabletxt">';
			returnData		+=			'<input type="text" name="end_time_'+chk_id+'"  id="end_time_'+chk_id+'" size="10" value="'+endTimeDisplay+'" maxlength="5"  onblur="return fnCheckTimeFormat(this,\'end_time\',\''+chk_id+'\')"/>';
			//returnData		+=			'<input type="text" name="end_time_'+chk_id+'"  id="end_time_'+chk_id+'" size="10" value="'+endTimeDisplay+'" maxlength="5"  onblur="return fnCheckTimeFormat(this,\'end_time\',\''+chk_id+'\')"/>';
			returnData		+=			'<br/><span class="err" id="err_end_time_'+chk_id+'"></span>';
			returnData		+=		'</td>';

			returnData		+=		' <td align="left" valign="middle" class="Subtabletxt" > <span id="disp_portal_avail_slots_'+chk_id+'">'+max_patients_per_day+'</span> &nbsp; '+slabText+'</td>';

			returnData		+=		'<td align="left" valign="middle" class="Subtabletxt">';
			returnData		+=			'<input type="text" name="portal_avail_slots_'+chk_id+'"  id="portal_avail_slots_'+chk_id+'" size="10" value="'+max_patients_per_day_display+'" maxlength="3" onblur="return isNumber(this)"/>';
			returnData		+=			'<br/><span class="err" id="err_portal_avail_slots_'+chk_id+'"></span>';
			returnData		+=		'</td>';
			returnData		+=	'</tr>';
		}
	});

	if(errDayno!=""){
		parent.misMatchedTimeTableList[clinicCode_PracId]	=	errDayno;
	}

	returnData		+=		'</table>';
	returnData		+= '</td>';
	return returnData;
}

function fnGenerateTableRowAvailDays(refID,frameRef,from){
	if(refID==""){
		$.each(parent.availableDaysArr,function(clinicCode_PractionerId,value){
			availDayslist			= "";
			var practAvailableDays	= "";
			if($("#"+clinicCode_PractionerId).prop('checked')){
				practAvailableDays	= parent.storedDaysArr[clinicCode_PractionerId].slice(0,-3);
			}else{
				practAvailableDays	= $("#hidden_"+clinicCode_PractionerId).val().slice(0,-3); //get practioner availbledays from global variable
			}
			var dayListArr			= practAvailableDays.split("###");//practioner availbledays each days in array
				
			var trData			=  fnGenerateAvailableList(clinicCode_PractionerId);
			$("#avail_"+clinicCode_PractionerId).html(trData);

			var mismatchedDayArr	= [];

			if(clinicCode_PractionerId in parent.storedDaysArr){
				if(clinicCode_PractionerId in parent.misMatchedTimeTableList){
					mismatchedDayArr	= parent.misMatchedTimeTableList[clinicCode_PractionerId].split("~");
				}
			}

			$.each(dayListArr,function(index,value){
				var individualDays			= value.split("|~|");
				var dayNo					= individualDays[0];
				var max_patients_per_day	= individualDays[5];
				var errClass				= "";
				
				$.each(mismatchedDayArr,function(i,v){
					if(v==dayNo){
						max_patients_per_day	= $("#org_portal_avail_slots_"+clinicCode_PractionerId+"_"+dayNo,frameRef).val();
						errClass				= "errTimeTable";	
					}
				});
				if(parent.daysList[dayNo]!=""){
					availDayslist		+= '<span class="AvailDays '+errClass+'">'+parent.daysShortName[parent.daysList[dayNo]]+' - <span class="Available '+errClass+'">'+max_patients_per_day+'</span></span>'
				}
			});
			$("#avail_days_list_"+clinicCode_PractionerId).html(availDayslist);


			/*Generating Time Picker Start*/
			$("input[name='chk_"+clinicCode_PractionerId+"']",frameRef).each(function() {
				var timePickerID		= clinicCode_PractionerId+"_"+$(this).val();
				var chk_start_time			= $("#chk_start_time_"+timePickerID,frameRef).val();
				var chk_end_time			= $("#chk_end_time_"+timePickerID,frameRef).val();
				var start_time			= $("#start_time_"+timePickerID,frameRef).val();
				var end_time			= $("#end_time_"+timePickerID,frameRef).val();
				var slot_slab_interval	= timeToMinute($("#slot_slab_interval_"+timePickerID,frameRef).val());
				var breakeList				= "";
				if(timePickerID in parent.breakeTimingwithDayNoInSec){
					var breakListArr			= parent.breakeTimingwithDayNo[timePickerID].split("###");//practioner availbledays each days in array
					breakeList					= "[";
					$.each(breakListArr,function(btimeind,btime){
						var indBreakTiming	= btime.split("|~|");
						if(indBreakTiming!=""){
							var bStartTime	= indBreakTiming[1];
							var bEndTime	= indBreakTiming[2];
							breakeList		+= "['"+bStartTime+"','"+bEndTime+"']"+",";
						}
					});
					breakeList				= breakeList.slice(0,-1) ;
					breakeList				+="]";
				}
				
			
				$(function() {
					if(breakeList==""){
						$("#start_time_"+timePickerID,frameRef).timepicker({ 'timeFormat': 'H:i','minTime':chk_start_time,'maxTime':chk_end_time,'step':slot_slab_interval  });
						$("#end_time_"+timePickerID,frameRef).timepicker({ 'timeFormat': 'H:i','minTime':chk_start_time,'maxTime':chk_end_time,'step':slot_slab_interval});
					}else{
						$("#start_time_"+timePickerID,frameRef).timepicker({ 'timeFormat': 'H:i','minTime':chk_start_time,'maxTime':chk_end_time,'step':slot_slab_interval, 'disableTimeRanges': eval(breakeList)});
						$("#end_time_"+timePickerID,frameRef).timepicker({ 'timeFormat': 'H:i','minTime':chk_start_time,'maxTime':chk_end_time,'step':slot_slab_interval, 'disableTimeRanges': eval(breakeList)});
					}
				});


				var slot_slab_interval		= $("#slot_slab_interval_"+timePickerID).val();
				var patient_per_slot_slab	= $("#patient_per_slot_slab_"+timePickerID).val();
				var chk_slot				= parseInt($("#org_portal_avail_slots_"+timePickerID).val());
				var available_slots			= fnCalculateAvailableSlots(timePickerID,chk_start_time,chk_end_time,start_time,end_time,slot_slab_interval,patient_per_slot_slab);
				if(available_slots > 0){
					$("#disp_portal_avail_slots_"+timePickerID,frameRef).html(available_slots);
					$("#chk_portal_avail_slots_"+timePickerID,frameRef).val(available_slots);
				}
			});
			/*Generating Time Picker End*/

		});
	}else{
		var availDayslist	= "";

		if(from!='reset') {
			if($("#"+refID,frameRef).prop('checked')){
				$("input[name='chk_"+refID+"']",frameRef).filter(':checked').each(function() {
					var dayNo			= $(this).val();
					var chk_id			= refID+"_"+dayNo;
					var avail_slots		= "";
					if($("#portal_avail_slots_"+chk_id,frameRef).val()!=""){
						avail_slots		= $("#portal_avail_slots_"+chk_id,frameRef).val();
					}else{
						avail_slots		= $("#disp_portal_avail_slots_"+chk_id,frameRef).html();
					}
					availDayslist		+= '<span class="AvailDays">'+parent.daysShortName[parent.daysList[dayNo]]+' - <span class="Available">'+avail_slots+'</span></span>';
				});
				$("#avail_days_list_"+refID).html(availDayslist);
				
			}
		}else{
			var practAvailableDays	= "";
			
			$("input[name='chk_"+refID+"']",frameRef).each(function() {
				var day_no					= $(this).val();
				var chk_id					= refID+"_"+day_no;
				$(this).prop("checked",false);
			});
			for (var i = 0; i < parent.availableDaysArr.length; i++) {
				console.log(parent.availableDaysArr[i]);
			}
			/*Reseting all values to original i.e Time Table value Start*/
			var orgData			= parent.availableDaysArr[refID].slice(0,-3);
			var orgDayListArr	= orgData.split("###");
			$.each(orgDayListArr,function(index,value){
					var individualDays			= value.split("|~|");
					var dayNo					= individualDays[0];
					var chk_id					= refID+"_"+dayNo;
					var startTime				= individualDays[1];
					var endTime					= individualDays[2];
					var max_patients_per_day	= individualDays[5];
					setValueDayData(chk_id,frameRef,startTime,endTime,max_patients_per_day);
			});

			/*Reseting all values to original i.e Time Table value End*/

			
		
			if(refID in parent.storedDaysArr){
				practAvailableDays	= parent.storedDaysArr[refID].slice(0,-3);
			}else{
				practAvailableDays	= parent.availableDaysArr[refID].slice(0,-3);
			}
			var dayListArr			= practAvailableDays.split("###");//practioner availbledays each days in array
			var mismatchedDayArr	= [];

			if(refID in parent.storedDaysArr){
				if(refID in parent.misMatchedTimeTableList){
					mismatchedDayArr	= parent.misMatchedTimeTableList[refID].split("~");
				}
			}
	
			
			$.each(dayListArr,function(index,value){
				var individualDays			= value.split("|~|");
				var dayNo					= individualDays[0];
				var chk_id					= refID+"_"+dayNo;
				var startTime				= individualDays[1];
				var endTime					= individualDays[2];
				var max_patients_per_day	= individualDays[5];
				var errClass				= "";
				$.each(mismatchedDayArr,function(i,v){
					if(v==dayNo){
						startTime				= $("#chk_start_time_"+chk_id,frameRef).val();
						endTime					= $("#chk_end_time_"+chk_id,frameRef).val();
						max_patients_per_day	= $("#org_portal_avail_slots_"+chk_id,frameRef).val();
						errClass				= "errTimeTable";	
					}
				});
					

				setValueDayData(chk_id,frameRef,startTime,endTime,max_patients_per_day);

				if(parent.daysList[dayNo]!=""){
					availDayslist		+= '<span class="AvailDays '+errClass+'">'+parent.daysShortName[parent.daysList[dayNo]]+' - <span class="Available '+errClass+'">'+max_patients_per_day+'</span></span>'
				}
				if($("#"+refID,frameRef).prop('checked')){
					$("#chk_"+chk_id,frameRef).prop("checked",true);
					$("#chk_"+chk_id,frameRef).prop("disabled",false);
					$("#start_time_"+chk_id,frameRef).prop('disabled',false);
					$("#end_time_"+chk_id,frameRef).prop('disabled',false);
					$("#portal_avail_slots_"+chk_id,frameRef).prop('disabled',false);
				}
			});

			$("#avail_days_list_"+refID).html(availDayslist);
		}
	}
}

function setValueDayData(chk_id,frameRef,startTime,endTime,max_patients_per_day){
	$("#start_time_"+chk_id,frameRef).val(startTime);
	$("#end_time_"+chk_id,frameRef).val(endTime);
	$("#portal_avail_slots_"+chk_id,frameRef).val(max_patients_per_day);

	var chk_start_time			= $("#chk_start_time_"+chk_id).val();
	var chk_end_time			= $("#chk_end_time_"+chk_id).val();
	var slot_slab_interval		= $("#slot_slab_interval_"+chk_id).val();
	var patient_per_slot_slab	= $("#patient_per_slot_slab_"+chk_id).val();

	var availslots				= fnCalculateAvailableSlots(chk_id,chk_start_time,chk_end_time,startTime,endTime,slot_slab_interval,patient_per_slot_slab);

	$("#disp_portal_avail_slots_"+chk_id,frameRef).html(availslots);
	$("#chk_portal_avail_slots_"+chk_id,frameRef).val(availslots);
	$("#org_portal_avail_slots_"+chk_id,frameRef).val(availslots);


	$("#start_time_"+chk_id,frameRef).removeClass("errBorder");
	$("#err_start_time_"+chk_id,frameRef).html("");
	$("#end_time_"+chk_id,frameRef).removeClass("errBorder");
	$("#err_end_time_"+chk_id,frameRef).html("");
	$("#portal_avail_slots_"+chk_id,frameRef).removeClass("errBorder");
	$("#err_portal_avail_slots_"+chk_id,frameRef).html("");
}



function fnChkClick(obj,frameRef){
	if($("#"+obj.id,frameRef).prop('checked')){
		enableDisableFields(obj.id,false,frameRef);
	}else{
		enableDisableFields(obj.id,true,frameRef);
	}
}

function fnShowAvailableDays(clinicCode_PracId,frameRef){

	$("#edit_"+clinicCode_PracId,frameRef).hide();
	$("#save_"+clinicCode_PracId,frameRef).fadeIn(1000);
	
	if($("#isEnableClose_"+clinicCode_PracId,frameRef).val()=="Y" && $("#"+clinicCode_PracId,frameRef).prop('checked')){
		$("#close_"+clinicCode_PracId,frameRef).fadeIn(1000);
	}
	
	var isEnable			= false;
	if($("#"+clinicCode_PracId,frameRef).prop('checked')){
		isEnable			= true;
	}

	if(!isEnable){
		enableDisableFields(clinicCode_PracId,true,frameRef);
	}

	$("#avail_"+clinicCode_PracId,frameRef).fadeIn('slow');
}

function enableDisableFields(clinicCode_PracId,isEnable,frameRef){
	$("input[name='chk_"+clinicCode_PracId+"']",frameRef).prop('disabled',isEnable);
	$("input[name='start_time_"+clinicCode_PracId+"']",frameRef).prop('disabled',isEnable);
	$("input[name='end_time_"+clinicCode_PracId+"']",frameRef).prop('disabled',isEnable);
	$("input[name='portal_avail_slots_"+clinicCode_PracId+"']",frameRef).prop('disabled',isEnable);
	if(isEnable){
		$("input[name='chk_"+clinicCode_PracId+"']",frameRef).prop('checked',false);
	}else{
		$("input[name='chk_"+clinicCode_PracId+"']",frameRef).prop('checked',true);
	}

	if(clinicCode_PracId in parent.storedDaysArr || isEnable){
		fnGenerateTableRowAvailDays(clinicCode_PracId,frameRef,'reset');
	}

}

function fnSave(id,frameRef){
	var returnData	= fnValidate(id,frameRef);
	/*Clear and set the values for unchecked days Start*/	
	$("input[name='chk_"+id+"']",frameRef).each(function() {
		var dayNo			= $(this).val();
		var chk_id			= id+"_"+dayNo;
		if(!$("#chk_"+chk_id,frameRef).prop('checked')){
			var startTime				= $("#chk_start_time_"+chk_id,frameRef).val();
			var endTime					= $("#chk_end_time_"+chk_id,frameRef).val();
			var max_patients_per_day	= $("#org_portal_avail_slots_"+chk_id,frameRef).val();
			setValueDayData(chk_id,frameRef,startTime,endTime,max_patients_per_day);
		}
	});
	/*Clear and set the values for unchecked days End*/
		
		
	if(returnData!=""){
		fnClose(id,frameRef,'save');
		if($("#"+id,frameRef).prop('checked')){
			$("#isEnableClose_"+id,frameRef).val("Y");
		}else{
			$("#isEnableClose_"+id,frameRef).val("N");
		}
		fnGenerateTableRowAvailDays(id,frameRef);
	}
}

function fnClose(clinicCode_PracId,frameRef,from){
	if(from=='reset'){
		fnGenerateTableRowAvailDays(clinicCode_PracId,frameRef,'reset');
	}
	$("#edit_"+clinicCode_PracId,frameRef).fadeIn(1000);
	$("#save_"+clinicCode_PracId,frameRef).hide();
	$("#close_"+clinicCode_PracId,frameRef).hide();
	$("#avail_"+clinicCode_PracId,frameRef).hide();
}



function fnCheckTimeFormat(obj,fromTo,chk_id){
	
	$("#"+obj.id).removeClass("errBorder");
	$("#err_"+obj.id).html("");
	
	var regex	= /^(?:0?[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
	if(obj.value!=""){
		if(!regex.test(obj.value)){
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			$("#"+obj.id).addClass("errBorder");
			$("#err_"+obj.id).html(getMessage("INVALID_TIME_FMT","SM"));			
		}else{
			var chk_start_time			= $("#chk_start_time_"+chk_id).val();
			var chk_end_time			= $("#chk_end_time_"+chk_id).val();
			var chk_start_time_sec		= parseInt(timeToSeconds(chk_start_time));
			var chk_end_time_sec		= parseInt(timeToSeconds(chk_end_time));

			var start_time				= $("#start_time_"+chk_id).val();
			var end_time				= $("#end_time_"+chk_id).val();
			var start_time_sec			= "";
			var end_time_sec			= "";
			if(start_time!=""){
				start_time_sec			= parseInt(timeToSeconds(start_time));
			}
			if(end_time!=""){
				end_time_sec			= parseInt(timeToSeconds(end_time));
			}

			if(start_time!="" && fromTo=='start_time'){
				if(start_time_sec < chk_start_time_sec){
					var message		= getMessage("REMARKS_SHOULD_GR_EQUAL","Common").replace("$",getLabel("Common.StartTime.label","Common"));
					message			= message.replace("#",chk_start_time);
					$("#start_time_"+chk_id).val("");
					//$("#start_time_"+chk_id).focus();
					$("#start_time_"+chk_id).addClass("errBorder");
					$("#err_start_time_"+chk_id).html(message);
					return false;
				}else if(start_time_sec > chk_end_time_sec){
					var message		= getMessage("REMARKS_SHOULD_LS_EQUAL","Common").replace("$",getLabel("Common.StartTime.label","Common"));
					message			= message.replace("#",chk_end_time);
					$("#start_time_"+chk_id).val("");
					//$("#start_time_"+chk_id).focus();
					$("#start_time_"+chk_id).addClass("errBorder");
					$("#err_start_time_"+chk_id).html(message);
				}
			}else if(end_time!="" && fromTo=='end_time'){
				if(end_time_sec < chk_start_time_sec){
					var message		= getMessage("REMARKS_SHOULD_GR_EQUAL","Common").replace("$",getLabel("Common.EndTime.label","Common"));
					message			= message.replace("#",chk_start_time);
					$("#end_time_"+chk_id).val("");
				//	$("#end_time_"+chk_id).focus();
					$("#end_time_"+chk_id).addClass("errBorder");
					$("#err_end_time_"+chk_id).html(message);
					return false;

				}else if(end_time_sec > chk_end_time_sec){
					var message		= getMessage("REMARKS_SHOULD_LS_EQUAL","Common").replace("$",getLabel("Common.EndTime.label","Common"));
					message			= message.replace("#",chk_end_time);
					$("#end_time_"+chk_id).val("");
				//	$("#end_time_"+chk_id).focus();
					$("#end_time_"+chk_id).addClass("errBorder");
					$("#err_end_time_"+chk_id).html(message);
					return false;
				}
			}
			

			
			if(start_time!="" && end_time!=""  && fromTo=='start_time'){
				if(start_time_sec >= end_time_sec){
					var message		= getMessage("REMARKS_SHOULD_LS_EQUAL","Common").replace("$",getLabel("Common.StartTime.label","Common"));
					message			= message.replace("#",getLabel("Common.EndTime.label","Common"));
					message			= message.replace("or equal to  ","");
					$("#start_time_"+chk_id).val("");
				//	$("#start_time_"+chk_id).focus();
					$("#start_time_"+chk_id).addClass("errBorder");
					$("#err_start_time_"+chk_id).html(message);
					return false;
				}
			}

			if(start_time!="" && end_time!=""  && fromTo=='end_time'){
			
				if(end_time_sec <= start_time_sec){
					var message		= getMessage("REMARKS_SHOULD_GR_EQUAL","Common").replace("$",getLabel("Common.EndTime.label","Common"));
					message			= message.replace("#",getLabel("Common.StartTime.label","Common"));
					message			= message.replace("or equal to  ","");
					$("#end_time_"+chk_id).val("");
					//$("#end_time_"+chk_id).focus();
					$("#end_time_"+chk_id).addClass("errBorder");
					$("#err_end_time_"+chk_id).html(message);
					return false;
				}
			}
			

			if(start_time!="" && end_time!="" ){
				var slot_slab_interval		= $("#slot_slab_interval_"+chk_id).val();
				var patient_per_slot_slab	= $("#patient_per_slot_slab_"+chk_id).val();
				var chk_slot				= parseInt($("#org_portal_avail_slots_"+chk_id).val());
				var available_slots			= fnCalculateAvailableSlots(chk_id,chk_start_time,chk_end_time,start_time,end_time,slot_slab_interval,patient_per_slot_slab);
	
				if(available_slots > 0){
					$("#chk_portal_avail_slots_"+chk_id).val(available_slots);
					$("#portal_avail_slots_"+chk_id).val(available_slots);
					$("#disp_portal_avail_slots_"+chk_id).html(available_slots);
				}else{
					$("#start_time_"+chk_id).val("");
					$("#end_time_"+chk_id).val("");
					//$("#start_time_"+chk_id).focus();
					$("#start_time_"+chk_id).addClass("errBorder");
					$("#err_start_time_"+chk_id).html("Slots Not Available");

					$("#portal_avail_slots_"+chk_id).val(chk_slot);
					$("#chk_portal_avail_slots_"+chk_id).val(chk_slot);
					$("#disp_portal_avail_slots_"+chk_id).html(chk_slot);
					return false;
				}
			}
		}
	}
}

function fnCalculateAvailableSlots(chk_id,chk_start_time,chk_end_time,start_time,end_time,slot_slab_interval,patient_per_slot_slab){

	var chk_start_time_sec		= parseInt(timeToSeconds(chk_start_time));
	var chk_end_time_sec		= parseInt(timeToSeconds(chk_end_time));

	var start_time_sec			= "";
	var end_time_sec			= "";
	if(start_time!=""){
		start_time_sec			= parseInt(timeToSeconds(start_time));
	}
	if(end_time!=""){
		end_time_sec			= parseInt(timeToSeconds(end_time));
	}

	var breakTimeInSec			= 0;
	if(chk_id in parent.breakeTimingwithDayNoInSec){
		breakTimeInSec			= parseInt(parent.breakeTimingwithDayNoInSec[chk_id]);
	}
	var slot_slab_interval_in_min		= timeToMinute(slot_slab_interval);

	var breakTimeAll	= 0;
	if(breakTimeInSec > 0){
		var breakListArr			= parent.breakeTimingwithDayNo[chk_id].split("###");//practioner availbledays each days in array
		$.each(breakListArr,function(btimeind,btime){
			var indBreakTiming	= btime.split("|~|");
			if(indBreakTiming!=""){
				var bSTimeInSec	= parseInt(timeToSeconds(indBreakTiming[1]));
				var bETimeInSec	= parseInt(timeToSeconds(indBreakTiming[2]));
				var chkbreak	= bETimeInSec - bSTimeInSec;
				var slot_slab_interval_sec	=  parseInt(timeToSeconds(slot_slab_interval));
				var no_of_breaks	= parseInt(chkbreak/slot_slab_interval_sec);

				if( ((bSTimeInSec >= start_time_sec) &&  (bSTimeInSec <= end_time_sec)) ||  ((bETimeInSec > start_time_sec) &&  (bETimeInSec < end_time_sec))){
					breakTimeAll	+= parseInt(slot_slab_interval_sec) * no_of_breaks;
				}
			}
		});

	}

	var entered_time			= parseInt((end_time_sec - start_time_sec - breakTimeAll)/60);


	var available_slots			= parseInt(entered_time / slot_slab_interval_in_min) * parseInt(patient_per_slot_slab);



	return available_slots;
}



function timeToSeconds(time) { 
	if(time != undefined) {
    time = time.split(":");
    return time[0] * 3600 + time[1] * 60 ;
	} else {
		return "" ;
	}
}
function timeToMinute(time) { 
	if(time != undefined) {
    time = time.split(":");
    return (time[0] * 3600 + time[1] * 60)/60 ;
	}else {
	return "" ;
	}
}


function tConvert (time) {
  // Check correct time format and split into components
  time = time.toString ().match (/^([01]\d|2[0-3])(:)([0-5]\d)(:[0-5]\d)?$/) || [time];

  if (time.length > 1) { // If time format correct
    time = time.slice (1);  // Remove full string match value
    time[5] = +time[0] < 12 ? 'AM' : 'PM'; // Set AM/PM
    time[0] = +time[0] % 12 || 12; // Adjust hours
  }
  return time.join (''); // return adjusted time or original string
}


function isNumber(obj){
	$("#"+obj.id).removeClass("errBorder");
	$("#err_"+obj.id).html("");
	var regex		= /^[0-9]+$/;
	var chk_slot	= parseInt($("#chk_"+obj.id).val());
	if(obj.value!=""){
		var enterdValue	= parseInt(obj.value,10);
		if(!regex.test(enterdValue)){
			$("#"+obj.id).addClass("errBorder");
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			$("#err_"+obj.id).html(getMessage("INVALID_NEXT_NUMBER","Common").replace("next",""));
		}else if(enterdValue==0){
			$("#"+obj.id).addClass("errBorder");
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			$("#err_"+obj.id).html(getMessage("INVALID_NEXT_NUMBER","Common").replace("next",""));
		}else if(enterdValue > chk_slot){
			var message		= getMessage("REMARKS_SHOULD_LS_EQUAL","Common").replace("$",'Portal '+getLabel("eOA.SlotsSlabsAllocated.label","OA"));
			message			= message.replace("#",getLabel("Common.available.label","Common")+'&nbsp;'+getLabel("Common.Slot.label","Common")+'(s)/'+getLabel("eOA.slab.label","OA")+'(s)');
			$("#"+obj.id).addClass("errBorder");
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			$("#err_"+obj.id).html(message);
		}else{
			$("#"+obj.id).val(enterdValue);
		}
	}
}

function reset(){
	frames[1].location.href='../../eOA/jsp/patientPortalConfig.jsp';
	frames[2].location.href='../../eCommon/jsp/error.jsp';
}

function fnValidate(clinicCode_PractionerId,frameRef){
	var errorCnt		= 0;
	var enteredData		= "";
//	console.log(document.getElementById("f_query_add_mod").contentWindow.document.getElementById("pract_id_"+clinicCode_PractionerId).value);
	
	var pract_id		= $("#pract_id_"+clinicCode_PractionerId,frameRef).val();
	var clinic_code		= $("#clinic_code_"+clinicCode_PractionerId,frameRef).val();
	var locn_type		= $("#locn_type_"+clinicCode_PractionerId,frameRef).val();
	var resource_type	= $("#resource_type_"+clinicCode_PractionerId,frameRef).val();
	
	if($("#"+clinicCode_PractionerId,frameRef).prop('checked')){
		var chkCount	= 0;
		$("input[name='chk_"+clinicCode_PractionerId+"']",frameRef).filter(':checked').each(function() {
			chkCount++;
			var dayNo			= $(this).val();
			var id				= clinicCode_PractionerId+"_"+dayNo;
			var startTime		= $("#start_time_"+id,frameRef).val();
			var endTime			= $("#end_time_"+id,frameRef).val();
			var noOfSlots		= $("#portal_avail_slots_"+id,frameRef).val();
			var time_table_type	= $("#time_table_type_"+id,frameRef).val();
			var srl_no			= $("#srl_no_"+id,frameRef).val();


			$("#start_time_"+id).removeClass("errBorder");
			$("#err_start_time_"+id,frameRef).html("");
			$("#end_time_"+id).removeClass("errBorder");
			$("#err_end_time_"+id,frameRef).html("");
			$("#portal_avail_slots_"+id).removeClass("errBorder");
			$("#err_portal_avail_slots_"+id,frameRef).html("");
			$("#err_avail_days_"+clinicCode_PractionerId,frameRef).html("");

			if(startTime==""){
				$("#start_time_"+id,frameRef).addClass("errBorder");
				$("#err_start_time_"+id,frameRef).html(getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.StartTime.label","Common")));
				$("#start_time_"+id,frameRef).focus();
				errorCnt++;
				return false;
			}else if(endTime==""){
				$("#err_end_time_"+id,frameRef).html(getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.EndTime.label","Common")));
				$("#end_time_"+id,frameRef).focus();
				$("#end_time_"+id,frameRef).addClass("errBorder");
				errorCnt++;
				return false;
			}else if(noOfSlots==""){
				$("#err_portal_avail_slots_"+id,frameRef).html(getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.NoofSlots.label","OA")));
				$("#portal_avail_slots_"+id,frameRef).focus();
				$("#portal_avail_slots_"+id,frameRef).addClass("errBorder");
				errorCnt++;
				return false;
			}
			var org_start_time			= $("#chk_start_time_"+id,frameRef).val();
			var org_end_time			= $("#chk_end_time_"+id,frameRef).val();
			var org_no_of_slots			= $("#org_portal_avail_slots_"+id,frameRef).val();
			var org_time_table_type		= $("#time_table_type_"+id,frameRef).val();

			enteredData	+= dayNo+"|~|"+startTime+"|~|"+endTime+"|~|"+noOfSlots+"|~|"+clinic_code+"|~|"+pract_id+"|~|"+time_table_type+"|~|"+locn_type+"|~|"+resource_type+"|~|"+srl_no+"|~|"+org_start_time+"|~|"+org_end_time+"|~|"+org_no_of_slots+"|~|"+org_time_table_type+"###";
			
			var entries = enteredData.split("###");
			for (var i = 0; i < entries.length; i++) 
			{
				var entry = entries[i].split("|~|"); 
				for (var j = 0; j < entry.length; j++) 
				{
					if (entry[j] == 'undefined') 
					{
						entry[j] = ""; 
					}
				}
				entries[i] = entry.join("|~|");
			}

			enteredData = entries.join("###");

		
		});
		if(chkCount==0){
			$("#err_avail_days_"+clinicCode_PractionerId,frameRef).html(getMessage("ATLEAST_ONE_RECORD_ENTERED","Common"));
			errorCnt++;
			return false;
		}

		if(errorCnt==0){
			return enteredData;
		}else{
			return "";
		}
	}
}


function apply(){
	var speciality_code	= $("#specialityList",f_query_add_mod.document).val();
	var isEnabled		= "N";
	if($("#isEnabled",f_query_add_mod.document).prop('checked')){
		isEnabled		= "Y";
	}
	
	if(speciality_code==""){
		alert(getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.speciality.label","Common")));
		 window.commontoolbarFrame.document.location.reload();
		return false;
	}
	var count	= 0;
	var error	= 0;
	
	$('input[name="practList"]',f_query_add_mod.document).filter(':checked').each(function() {
		var id = $(this).val();
	
		var individualData	= fnValidate(id,f_query_add_mod.document);
		if(individualData!=""){
			$("#hidden_"+id,f_query_add_mod.document).val(individualData);
			window.commontoolbarFrame.document.location.reload();
		}else{
			fnShowAvailableDays(id,f_query_add_mod.document);
			error++;
			window.commontoolbarFrame.document.location.reload();
		}
		count++;
	});
	if(count==0){
		alert(getMessage("ATLEAST_ONE_RECORD_ENTERED","Common"));
		window.commontoolbarFrame.document.location.reload();
		return false;
	}
	if(error==0){
		var finalRowcount	= 0;
		var finalData	= "";
		$('input[name="practList"]',f_query_add_mod.document).filter(':checked').each(function() {
			var id = $(this).val();
			console.log("ID: " + id);
			// console.log(document.getElementById("f_query_add_mod").contentWindow.document.getElementById("hidden_" + id)) ;
			finalData	+= $("#hidden_"+id,f_query_add_mod.document).val();
			console.log("ELEMENT: " + $("#hidden_"+id,f_query_add_mod.document).val());
			finalRowcount++;
		});
		if(finalData!=""){
					var isMismatchedTimeTable	= false;
					$.each(misMatchedTimeTableList,function(i,v){
						if($("#"+i,f_query_add_mod.document).prop('checked')){
							isMismatchedTimeTable	= true;
						}
					});
					if(isMismatchedTimeTable){
						alert(getMessage("TIME_TABLE_CHANGED","OA"));
					}

					
					var jsonArguments	= {
											'speciality_code':speciality_code,
											'mode':'insert',
											'finalData':finalData,
											'eff_status':isEnabled
										  };
										
					$.ajax({  
						 url:'../../servlet/eOA.patientPortalConfigServlet',  
						 type: 'post',  
						 data: jsonArguments,
						 dataType: 'json',
						 success: function(data) {
							if(data!=null){
								 if(data.error == ""){
									 alert(getMessage("RECORD_INSERTED","SM"));
									 $("#specialityList",f_query_add_mod.document).val("");
									 $("#divPractitionerList",f_query_add_mod.document).html("");
									 document.getElementById("f_query_add_mod").contentWindow.location.reload();

								 }else{
									 alert(data.error);
								 }
							}
						 }
					 });
			}
			window.commontoolbarFrame.document.location.reload();
	}
}




