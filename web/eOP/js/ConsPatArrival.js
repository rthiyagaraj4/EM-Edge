

function submit_ok()
{
	var	assigned_q_no = "";
	parent.frames[1].document.getElementById("other_res_type").disabled=false;
	var flag=true;
	var qms_interfaced_yn = parent.frames[1].document.forms[0].qms_interfaced_yn.value;
	var mand_queue_no=parent.frames[1].document.forms[0].mand_queue_no.value;//Added by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
		
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started
	var Queue_No_Mandate=parent.frames[1].document.forms[0].Queue_No_Mandate.value;
	var isQMSapplicable=parent.frames[1].document.forms[0].isQMSapplicable.value;	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 End
	
	if(parent.frames[1].document.getElementById("revert_to_check_in").value != "Y")
	{
	    var assign_q_num_by = parent.frames[1].document.forms[0].assign_q_num_by.value;
		var locntype = parent.frames[1].document.forms[0].locntype.value;
		var	other_res_code = parent.frames[1].document.forms[0].other_res_code.value;
		var	other_res_type = parent.frames[1].document.forms[0].other_res_type.value;
		var att_pract_id = parent.frames[1].document.forms[0].practid.value;	
		var queue_date = parent.frames[1].document.forms[0].queue_date.value;		
	
		if(assign_q_num_by=="M")
		{
			if(parent.frames[1].document.forms[0].queue_no!=null)
			{
				var	assigned_q_no = parent.frames[1].document.forms[0].queue_no.value;
				//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started
			/*  if(isQMSapplicable=="true")
				{
					
						if((Queue_No_Mandate=="Y") && (assigned_q_no==""||assigned_q_no==null))
						{    
							var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
							error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
							alert(error);
							parent.frames[1].document.forms[0].queue_no.focus();
							return;
						}
						else 
						{
							parent.frames[1].document.forms[0].queue_num.value = assigned_q_no;
						}
				}
				else
				{ */
							//Pre Existing 
					if(qms_interfaced_yn=="N")
					{
						if((assigned_q_no==""||assigned_q_no==null) && (mand_queue_no=="N"))//Modified by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
						{    
							var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
							error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
							alert(error);
							parent.frames[1].document.forms[0].queue_no.focus();
							return;
						}
						else 
						{
							parent.frames[1].document.forms[0].queue_num.value = assigned_q_no;
						}
					}
			//	}
					//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 End			
			}				
		}
		/*else
		{
			if(parent.frames[1].document.forms[0].queue_no!=null)
				{
				var	assigned_q_no = parent.frames[1].document.forms[0].queue_no.value;
				if(isQMSapplicable=="true")
							{
		        	if((Queue_No_Mandate=="Y") && (assigned_q_no==""||assigned_q_no==null))
						{    
							var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
							error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
							alert(error);
							parent.frames[1].document.forms[0].queue_no.focus();
							return;
						}
						else 
						{
							parent.frames[1].document.forms[0].queue_num.value = assigned_q_no;
						}
		        	}
		}
	}*/
//include the logic for QMS here
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023
	
		if(isQMSapplicable=="true" && qms_interfaced_yn == 'Y' && assign_q_num_by=="M" && (parent.frames[1].document.forms[0].queue_no.value == '' || parent.frames[1].document.forms[0].queue_no.value == 'null' ))
		{
			var cliniccode=parent.frames[1].document.forms[0].clinic_code.value;
			var fac_id=parent.frames[1].document.forms[0].fac_id.value;				 			
			var encounter_id = parent.frames[1].document.getElementById("encntrid").value;
			var assign_q_num_by = parent.frames[1].document.getElementById("assign_q_num_by").value;
			var work_station_id = parent.frames[1].document.getElementById("work_station_id").value;
			var login_user = parent.frames[1].document.getElementById("login_user").value;		 
			var patient_id = parent.frames[1].document.getElementById("patientid").value;
			if(document.forms[0].qms_exception.value=='N'){			
				QueueNumberLoad(fac_id, cliniccode, patient_id, encounter_id,login_user,work_station_id,assign_q_num_by);
			}
			else {
				if((mand_queue_no=="N")&& (parent.frames[1].document.forms[0].queue_no.value == '' || parent.frames[1].document.forms[0].queue_no.value == 'null' )){
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
					flag=false;
					alert(error);
				}
				else {
					var isduplicate=CheckDuplicateQueueNumber(patient_id,encounter_id,isQMSapplicable);
					if(!isduplicate)
					{
						queueNumber="";
						document.getElementById("queue_no").value=queueNumber;
						document.getElementById("queue_no").readOnly = false;
					}
					else {
						parent.frames[1].document.forms[0].queue_num.value = parent.frames[1].document.forms[0].queue_no.value;
						parent.frames[1].document.forms[0].submit();
					}				
				}				
			}			
		}
		else {	
			if(qms_interfaced_yn == 'Y' && document.forms[0].qms_exception.value=='Y'){
				if((mand_queue_no=="N")&& (parent.frames[1].document.forms[0].queue_no.value == '' || parent.frames[1].document.forms[0].queue_no.value == 'null' )){
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
					flag=false;
					alert(error);
				}else {
					parent.frames[1].document.forms[0].queue_num.value =  parent.frames[1].document.forms[0].queue_no.value;;
				}
				
			}
			if(qms_interfaced_yn == 'Y' && document.forms[0].qms_exception.value=='N'){
			
				if(parent.frames[1].document.getElementById("room_num").value != "NoRoom" && (parent.frames[1].document.forms[0].room_num.value == '*ALL' || parent.frames[1].document.forms[0].room_num.value == '' || parent.frames[1].document.forms[0].room_num.value == 'null'))
				{
					flag=false;
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('Common.roomno.label','Common'));
					alert(error);
				}
				else
				{
					var cliniccode=parent.frames[1].document.forms[0].clinic_code.value;
					var roomnum=parent.frames[1].document.forms[0].room_num.value;				
					var queuenum=parent.frames[1].document.forms[0].queue_num.value;				
					var encounter_id = parent.frames[1].document.getElementById("encntrid").value;
					var p_pract_id = parent.frames[1].document.getElementById("practid").value;
					var p_locn_type = parent.frames[1].document.getElementById("locntype").value;
					var appt_walk_in = parent.frames[1].document.getElementById("appt_walk_in").value;
					var queue_id = parent.frames[1].document.getElementById("queue_id").value;
					var patient_id = parent.frames[1].document.getElementById("patientid").value;
					var keyed_queue_num=0;
					var que_id="";			
				
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
				 
					var param="&callfunc=Arrival&clinic_code="+cliniccode+"&room_num="+roomnum+"&pract_id="+p_pract_id+"&queue_date="+queue_date+"&p_locn_type="+p_locn_type+"&other_res_code="+other_res_code+"&other_res_type="+other_res_type+"&encounter_id="+encounter_id+"&appt_walk_in="+appt_walk_in+"&queue_id="+queue_id+"&patient_id="+patient_id+"&queue_num="+queuenum;
					var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=trimString(xmlHttp.responseText);
					var retVal =responseText.split("#")			
					keyed_queue_num=retVal[1];
					que_id=retVal[2];				
	  
			 
				//if condition added by(isQMSapplicable) Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 end
    
					if(que_id == '-1'){
						flag=false;
						var errors=getMessage('QUEUE_ID_NOT_ATTACHED','OP');
						alert(errors);
					}
					else if(que_id=='-2'){
						flag=false;
						var errors=getMessage('QUEUE_NUM_CTRL_NOT_DEFINED','OP');
						
						alert(errors);
					}
					else if (que_id=='0')
					{
						parent.frames[1].document.forms[0].queue_num.value=0;
						parent.frames[1].document.forms[0].queue_id.value="";
					}
					else{
						if(keyed_queue_num == '-1' || keyed_queue_num == null){	
							flag=false;
							var div1=document.getElementById("queue_div");
							var div2=document.getElementById("queue_no_div");
							if (div1 != null )
							{	
								div1.style.display="inline";
								div2.style.display="inline";
							}
			
							document.getElementById("queue_div").style.visibility="visible";
							document.getElementById("queue_no_div").style.visibility="visible";				
							document.forms[0].qms_exception.value='Y';
							//document.forms[0].assign_q_num_by.value='M';
							
							var error = getMessage('EXT_QUEUE_NO_CONTACT','OP');
							alert(error);
						}
						else
						{
							parent.frames[1].document.forms[0].queue_num.value=keyed_queue_num;
							parent.frames[1].document.forms[0].queue_id.value=que_id;
						}
					}					
					 
				}
			}
			if(flag == true){
				if(document.getElementById("roomno_vis") && parent.frames[1].document.getElementById("room_num").value != "NoRoom") //Modified by Suji Keerthi for SKR-SCF-1504
				{
					if(parent.frames[1].document.forms[0].room_num.value == '*ALL' || parent.frames[1].document.forms[0].room_num.value == '' || parent.frames[1].document.forms[0].room_num.value == 'null')
					{
						var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
						error = error.replace('$',getLabel('Common.roomno.label','Common'));
						alert(error);
					}
					else
					{
	
						var cliniccode=parent.frames[1].document.forms[0].clinic_code.value;
						var roomnum=parent.frames[1].document.forms[0].room_num.value;
						var appt_id=parent.frames[1].document.getElementById("appt_id").value;
						var encounter_id = parent.frames[1].document.getElementById("encntrid").value;
	
						var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poproom' id='poproom' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+cliniccode+"'><input type='hidden' name='room_num' id='room_num' value='"+roomnum+"' ><input type='hidden' name='objval' id='objval' value='roomnumsel'><input type='hidden' name='callfunc' id='callfunc' value='Arrival'><input type='hidden' name='pract_id' id='pract_id' value=''><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'><input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='"+assign_q_num_by+"'><input type='hidden' name='queue_date' id='queue_date' value='"+queue_date+"'><input type='hidden' name='locntype' id='locntype' value='"+locntype+"'><input type='hidden' name='assigned_q_no' id='assigned_q_no' value='"+assigned_q_no+"'><input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'><input type='hidden' name='other_res_type' id='other_res_type' value='"+other_res_type+"'><input type='hidden' name='att_pract_id' id='att_pract_id' value='"+att_pract_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'></form></body></html>";		
						
						parent.dummyframe.document.write(HTMLVal);	
						parent.dummyframe.document.poproom.submit();
					}
				}
				else
				{
					
					parent.frames[1].document.getElementById("room_num").value="";
					parent.frames[1].document.getElementById("prev_room").value="";
	
					var cliniccode=parent.frames[1].document.forms[0].clinic_code.value;
					var roomnum=parent.frames[1].document.forms[0].room_num.value;
					var appt_id=parent.frames[1].document.getElementById("appt_id").value;
					var encounter_id = parent.frames[1].document.getElementById("encntrid").value;
	
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poproom' id='poproom' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+cliniccode+"'><input type='hidden' name='room_num' id='room_num' value='"+roomnum+"' ><input type='hidden' name='objval' id='objval' value='roomnumsel'><input type='hidden' name='callfunc' id='callfunc' value='Arrival'><input type='hidden' name='pract_id' id='pract_id' value=''><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'><input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='"+assign_q_num_by+"'><input type='hidden' name='queue_date' id='queue_date' value='"+queue_date+"'><input type='hidden' name='locntype' id='locntype' value='"+locntype+"'><input type='hidden' name='assigned_q_no' id='assigned_q_no' value='"+assigned_q_no+"'><input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'><input type='hidden' name='other_res_type' id='other_res_type' value='"+other_res_type+"'><input type='hidden' name='att_pract_id' id='att_pract_id' value='"+att_pract_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'></form></body></html>";
	
					parent.dummyframe.document.write(HTMLVal);	
					parent.dummyframe.poproom.submit();
				}
			}
		}
	}
	else
	{		
		if(qms_interfaced_yn == 'Y' && document.forms[0].qms_exception.value=='N'){
	
			var queue_num = parent.frames[1].document.forms[0].queue_num.value
			var encounter_id = parent.frames[1].document.getElementById("encntrid").value;
			var patient_id = parent.frames[1].document.getElementById("patientid").value;
			
			 var xmlStr ="<root><SEARCH ";
			 xmlStr +=" /></root>";
			 
			 var param="&callfunc=Revert&queue_num="+queue_num+"&encounter_id="+encounter_id+"&patient_id="+patient_id;
			 var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
			 var xmlDoc = "" ;
			 var xmlHttp = new XMLHttpRequest() ;
			 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			 xmlHttp.open("POST",temp_jsp,false);
			 xmlHttp.send(xmlDoc);
			 responseText=trimString(xmlHttp.responseText);
			 parent.frames[1].document.forms[0].queue_id.value="";
		}
		parent.frames[1].document.forms[0].submit();
	}	
}

function exitContact() {
    // Set the return value if necessary
    let dialogBody = parent.parent.document.getElementById('dialog-body');
    if (dialogBody && dialogBody.contentWindow) {
        dialogBody.contentWindow.returnValue = "ok";
    }

    // Retrieve dialog tags
    const dialogTags = parent.parent.document.querySelectorAll("#dialog_tag");

    // Close each dialog tag if they exist
    dialogTags.forEach(dialogTag => {
        if (typeof dialogTag.close === 'function') {
            dialogTag.close();
        }
    });
}

function chgbuttonclr() 
{

	parent.frames[1].document.getElementById("ok").style.background="navy" ;
	parent.frames[1].document.getElementById("ok").style.color="white" ;
	parent.frames[1].document.getElementById("ok").style.fontWeight="700" ;
	parent.frames[1].document.getElementById("ok").style.borderStyle="solid" ;

	parent.frames[1].document.getElementById("close").style.background="navy" ;
	parent.frames[1].document.getElementById("close").style.color="white" ;
	parent.frames[1].document.getElementById("close").style.fontWeight="700" ;
	parent.frames[1].document.getElementById("close").style.borderStyle="solid" ;
}

function selectroomno()
{
	parent.frames[1].document.getElementById("room_num").value=parent.frames[1].document.getElementById("roomnumsel").options[parent.frames[1].document.getElementById("roomnumsel").options.selectedIndex].value;
	parent.frames[1].document.getElementById("room_change").value=parent.frames[1].document.getElementById("room_num").value;
}


async function otherResourceLookUp(obj,target)
{
	var clinic_code = document.forms[0].clinic_code.value;
	var other_resType=document.forms[0].other_res_type.value;
	var facilityId=document.forms[0].fac_id.value;
	var oth_code = document.forms[0].res_code.value;
	var locale=document.forms[0].locale.value;
	
	if(other_resType != '')
	{
	
	var sql="SELECT PRACTITIONER_ID code,DECODE(RESOURCE_CLASS, 'P', am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','2'),			'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), 'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O',AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description FROM OP_PRACT_FOR_CLINIC WHERE facility_id='"+facilityId+"'  AND resource_class='"+other_resType+"'   AND clinic_code='"+clinic_code+"'  AND UPPER(PRACTITIONER_ID) LIKE UPPER(?)   AND DECODE(RESOURCE_CLASS, 'P',am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), 'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O',AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) LIKE UPPER(?) AND eff_status='E' ORDER BY 2";
	var tit				= getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var arr			= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].other_res_txt.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	document.forms[0].other_res_txt.focus();

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].other_res_txt.value=arr[1];
		document.forms[0].other_res_code.value=arr[0];
		if(oth_code != arr[0])
			document.getElementById("room_change").value="selected";
		else
			document.getElementById("room_change").value="";
	}else
	{
		document.forms[0].other_res_txt.value="";
		document.forms[0].other_res_code.value="";
	}
	}
	else
	{
		document.forms[0].other_res_txt.value="";
		document.forms[0].other_res_code.value="";
	}

}

function clearResourceVal(obj)
{
   document.forms[0].other_res_txt.value="";
   document.forms[0].other_res_code.value="";
   document.getElementById("room_change").value="selected";

   if(obj.value != '')
	{
	   
	   document.forms[0].other_res_txt.readOnly=false;
	   document.forms[0].other_res_butt.disabled=false;
	}else
	{
	   document.forms[0].other_res_txt.readOnly=true;
	   document.forms[0].other_res_butt.disabled=true;
	}

}

function applyclick(e)
{
  if(e.keyCode ==13)
		return false;

}


//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
function CheckDuplicateQueueNumber(Patient_id,encntrid,isQMSapplicable)
{ 
	var QUEUE_NUM = document.getElementById("queue_no").value;
	var clinic_code = document.getElementById("clinic_code").value;
	if(isQMSapplicable=="true")
	{
        xmlStr = "<root><SEARCH Patient_id=\""+Patient_id+"\" QUEUE_NUM=\""+QUEUE_NUM+"\" encntrid=\""+encntrid+"\" clinic_code=\""+clinic_code+"\" action='checkQueueNoExists' /></root>"
				 var temp_jsp="../../eOP/jsp/OPIntermediate.jsp";
				 var xmlDoc = "" ;
				 var xmlHttp = new XMLHttpRequest() ;
				 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				 xmlHttp.open("POST",temp_jsp,false);
				 xmlHttp.send(xmlDoc);
				 var responseText = xmlHttp.responseText;
				 var response = trimString(xmlHttp.responseText);
				 if(response=="true")
				 {
					document.getElementById("queue_no").value = "";
					alert(getMessage('QUEUE_NUM_EXISTS','OP'));
					return false;
				 }
				 else
					{
				//	submit_ok();
					return true;
					}
	}

}

//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
function QueueNumberLoad(facility_id, assign_care_locn_code, patient_id, EncounterId,login_user,workStationId,assign_q_num_by)
	{	
	var isQMSapplicable=document.getElementById("isQMSapplicable").value;
	var qms_interfaced_yn=document.getElementById("qms_interfaced_yn").value;
	var revert_to_check_in=document.getElementById("revert_to_check_in").value;
	var alert_duration=document.getElementById("alert_duration").value;
	
	
	if(isQMSapplicable=="true" && qms_interfaced_yn=="Y" && revert_to_check_in=="N" )
	{
			
			var queueNumber="";
			showPopup(alert_duration);
			//var responseValue='S$!^SUCCESS$!^RP$!^QN6754$!^YEELI_TAN$!^MRO$!^BN40099153$!^10/04/202315:25:30';
			var responseValue=fetchQueueNumber(facility_id, assign_care_locn_code, patient_id, EncounterId,login_user,workStationId);
			var queueNumber=responseValue.split("$!^");
			queueNumber=queueNumber[3];	
      		
			if(queueNumber!="" && queueNumber!=null && queueNumber!="0" && queueNumber!="FAILURE")
			{
			document.getElementById("queue_div").style.display="";
			document.getElementById("queue_no_div").style.display="";	
			document.getElementById("queue_div").style.visibility="visible";
			document.getElementById("queue_no_div").style.visibility="visible";	
			document.getElementById("queue_no").value=queueNumber;
			document.getElementById("queue_num").value=queueNumber;
			document.getElementById("queue_no").readOnly = true;
			var isQMSapplicable=document.getElementById("isQMSapplicable").value;
			var isduplicate=CheckDuplicateQueueNumber(patient_id,EncounterId,isQMSapplicable);
			if(!isduplicate)
			{
				queueNumber="";
				document.getElementById("queue_no").value=queueNumber;
				document.getElementById("queue_num").value=queueNumber;
				document.getElementById("queue_no").readOnly = false;
			}else
			{
				parent.frames[1].document.forms[0].submit();
			}
			
			}
			else
			{
			queueNumber="";
			document.getElementById("queue_no").value=queueNumber;
			document.getElementById("queue_num").value=queueNumber;
			document.getElementById("queue_no").readOnly = false;
			document.forms[0].qms_exception.value='Y';
			alert(getMessage('QUEUE_NO_TIMEOUT_ERR','OP'));
			var div1=document.getElementById("queue_div");
			var div2=document.getElementById("queue_no_div");
			if (div1 != null )
			{	
				div1.style.display="inline";
				div2.style.display="inline";
			}
			document.getElementById("queue_div").style.visibility="visible";
			document.getElementById("queue_no_div").style.visibility="visible";	
			
			if(parent.frames[1].document.forms[0].Queue_No_Mandate.value=="N"){
			document.forms[0].mand_queue_no.value="Y";
			document.getElementById("mand_gif").style.display="none";	
			}			
			}	
	}
}


async function showPopup(duration) {
	 var parameters="?duration="+duration;
	 var dialogHeight= "60vh" ;
     var dialogWidth = "70vw" ;
     var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
     var arguments   = "" ;
     await window.showModalDialog("../../eOP/jsp/FetchingQueueNumberPopUp.jsp"+parameters,arguments,features);
  }

function checkspecialandalphanumericOP(textObj)
{
	var ValidChars = /^[a-zA-Z0-9]+$/;
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	if(ValidChars.test(pasteData))
	{
		textObj.value = pasteData;
	}
	else 
		return false; 
}


function Check_SpecCharsValidationOP(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1) return false;
	return true ;
}


