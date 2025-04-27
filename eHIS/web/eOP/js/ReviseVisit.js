

async function apply()
{	
	var fields = new Array();
    var names = new Array();

	fields[0] = f_query_add_mod.document.forms[0].asn_locn_code;
	fields[1] = f_query_add_mod.document.forms[0].revise_reason_code;

	names[0] = getLabel('Common.Location.label','Common');
	names[1] = getLabel('eOP.ReasonForReviseVisit.label','OP');
	
	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	if(f_query_add_mod.document.forms[0].remarks_img.style.visibility == 'visible')
	{
		fields[2] = f_query_add_mod.document.forms[0].other_remarks;
		names[2] = getLabel("Common.remarks.label","Common");

		var i=0;
		if(f_query_add_mod.document.forms[0].identifyPractitionerAtCheckIn.value == 'Y')
		{
			if(f_query_add_mod.document.getElementById("room_cur").value == "NoRoom")
					f_query_add_mod.document.getElementById("room_cur").value="";

			if(f_query_add_mod.document.forms[0].resclass.value != 'R')
			{
			fields[3]=f_query_add_mod.document.forms[0].asn_pract_id;
			names[3]= getLabel('Common.practitionername.label','Common');
			i=4;
			}
			else
			{ 
			  i=3;	 
			}
			
			if(f_query_add_mod.document.getElementById("room_num").value != "NoRoom")
			{
				fields[i]=f_query_add_mod.document.getElementById("Room_numsel");
				names[i]= getLabel('Common.roomno.label','Common');
			}
		}
		else
		{
			if(f_query_add_mod.document.getElementById("room_num").value != "NoRoom")
			{
				fields[3]=f_query_add_mod.document.getElementById("Room_numsel");
				names[3]= getLabel('Common.roomno.label','Common');
			}
			
		}
	}
	else
	{
		var i=0;
		if(f_query_add_mod.document.forms[0].identifyPractitionerAtCheckIn.value == 'Y')
		{
			if(f_query_add_mod.document.getElementById("room_cur").value == "NoRoom")
					f_query_add_mod.document.getElementById("room_cur").value="";

			if(f_query_add_mod.document.forms[0].resclass.value != 'R')
			{
			fields[2]=f_query_add_mod.document.forms[0].asn_pract_id;
			names[2]= getLabel('Common.practitionername.label','Common');
			i=3;
			}
			else
			{ 
			  i=2;	 
			}
			
			if(f_query_add_mod.document.getElementById("room_num").value != "NoRoom")
			{
				fields[i]=f_query_add_mod.document.getElementById("Room_numsel");
				names[i]= getLabel('Common.roomno.label','Common');
			}
		}
		else
		{
			if(f_query_add_mod.document.getElementById("room_num").value != "NoRoom")
			{
				fields[2]=f_query_add_mod.document.getElementById("Room_numsel");
				names[2]= getLabel('Common.roomno.label','Common');
			}
			
		}
	}
	//Below line is Commented for ML-MMOH-CRF-1390 by KAMATCHI S
	/*if(f_query_add_mod.document.forms[0].remarks_img.style.visibility != 'visible')
	{
		f_query_add_mod.document.forms[0].other_remarks.value = "";
	}*/
	/*End ML-MMOH-CRF-1114*/
	
	if(f_query_add_mod.checkFields(fields, names, messageFrame))
	{
		/*Added for JD-CRF-0183 [IN:041353] By Dharma on 28th Nov 2013 Start*/
		var cl_code_all   		  		= f_query_add_mod.document.forms[0].asn_locn_code.value;
		var cl_code_array				= cl_code_all.split("|");
		var cl_code						= cl_code_array[0];
		var visit_adm_date_time			= f_query_add_mod.document.forms[0].visit_adm_date_time.value;
		var Sysdate						= f_query_add_mod.document.forms[0].Sysdate.value;
		var pract_id					= f_query_add_mod.document.forms[0].asn_pract_id.value;
		var action_on_pract_schedule	= f_query_add_mod.document.forms[0].action_on_pract_schedule.value;	
		var exist_pract_id				= f_query_add_mod.document.forms[0].exist_pract_id.value;
		var cur_cl_code 				= f_query_add_mod.document.forms[0].cur_locn_code.value;
		if(visit_adm_date_time!="" && pract_id!="" && action_on_pract_schedule!="N" && (exist_pract_id!=pract_id || cl_code!=cur_cl_code)){
	
			var datearr				= visit_adm_date_time.split(" ");
			var block_date			= datearr[0];
			var block_time			= datearr[1];
			
			if(Sysdate==block_date){
				FNCheckBlockScheduleForPract(block_date,pract_id,'','','revisevisit',cl_code);
				var is_prac_blocked	= f_query_add_mod.document.forms[0].is_prac_blocked.value;
			
				if(is_prac_blocked){
					var Systime						= f_query_add_mod.document.forms[0].Systime.value;
					if(action_on_pract_schedule=="S"){
						var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT","OP");
						err_msg		= err_msg.replace("#",block_date+" "+Systime);
						alert(err_msg);
						commontoolbarFrame.location.reload();
						return;
					}else if(action_on_pract_schedule=="W"){
						var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT_WARNING","OP");
						err_msg		= err_msg.replace("#",block_date+" "+Systime);
						if(confirm(err_msg)){
						
						
						}else{
							commontoolbarFrame.location.reload();
							return;
						}
					}
				}
			}
		}
		/*Added for JD-CRF-0183 [IN:041353] By Dharma on 28th Nov 2013 End*/
	
		if(f_query_add_mod.document.getElementById("room_cur").value == "NoRoom")
		{
			f_query_add_mod.document.getElementById("room_cur").value="";
		    f_query_add_mod.document.getElementById("room_num").value="";
		}
		var flag=true;
		var fnd = await funQry();
		if(fnd)
		{		
			
			getQMSapplbl();
			var qms_interfaced_yn = f_query_add_mod.document.getElementById("qms_interfaced_yn").value;
			//queue number should not visible for BRU  && f_query_add_mod.document.forms[0].isQMSapplicable.value=='false'
			if(qms_interfaced_yn == 'Y' && f_query_add_mod.document.getElementById("qms_exception").value=='Y'  && f_query_add_mod.document.forms[0].isQMSapplicable.value=='false')
			{
				if(f_query_add_mod.document.getElementById("queue_no").value == ''){
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
					flag=false;
					alert(error);
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
				}
			}	
					
			var cur_qms_interfaced_yn=f_query_add_mod.document.forms[0].cur_qms_interfaced_yn.value;
					
			if((qms_interfaced_yn == 'Y' || cur_qms_interfaced_yn == 'Y') && f_query_add_mod.document.getElementById("qms_exception").value=='N' && f_query_add_mod.document.forms[0].status.value < 4  && f_query_add_mod.document.forms[0].isQMSapplicable.value=='false')
			{
					
				var cliniccode=f_query_add_mod.document.getElementById("asn_locn_code").value;
				var temp=cliniccode.split("|");
				cliniccode = temp[0];
				var roomnum=f_query_add_mod.document.getElementById("Room_numsel").value;
				
				
				var encounter_id = f_query_add_mod.document.getElementById("l_encounter_id").value;
				var p_pract_id = f_query_add_mod.document.getElementById("asn_pract_id").value;
				var p_locn_type = f_query_add_mod.document.getElementById("cur_locn_type").value;
				var appt_walk_in = f_query_add_mod.document.getElementById("appt_walk_ind").value;
				var queue_id = f_query_add_mod.document.getElementById("queue_id").value;
				var queue_date = f_query_add_mod.document.getElementById("queue_date").value;
				var	other_res_code = f_query_add_mod.document.getElementById("other_res_code").value;
				var	other_res_type = f_query_add_mod.document.getElementById("other_res_type").value;
				var	queue_num = f_query_add_mod.document.getElementById("queue_num").value;
				var	patient_id = f_query_add_mod.document.getElementById("patient_id").value;
				var count=0;
				var que_id="";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				 
				var param="&callfunc=Revise&clinic_code="+cliniccode+"&room_num="+roomnum+"&pract_id="+p_pract_id+"&queue_date="+queue_date+"&p_locn_type="+p_locn_type+"&other_res_code="+other_res_code+"&other_res_type="+other_res_type+"&encounter_id="+encounter_id+"&appt_walk_in="+appt_walk_in+"&queue_id="+queue_id+"&queue_num="+queue_num+"&patient_id="+patient_id+"&issueCall="+qms_interfaced_yn;
				
				var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=trimString(xmlHttp.responseText);
				var retVal =responseText.split("#")				
				
				
				count=retVal[1];
				
				que_id=retVal[2];
				if(que_id == '-1'){
					flag=false;
					var errors=getMessage('QUEUE_ID_NOT_ATTACHED','OP');
					alert(errors);
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
				}
				else if(que_id=='-2')
				{
					flag=false;
					var errors=getMessage('QUEUE_NUM_CTRL_NOT_DEFINED','OP');
					
					alert(errors);
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
				}
				else if (que_id=='0')				
				{
					f_query_add_mod.document.getElementById("queue_num").value=0;
					f_query_add_mod.document.getElementById("queue_id").value="";
				}
				else
				{
					if(count == '-1' || count == null)
					{
						flag=false;
						var div1=f_query_add_mod.document.getElementById("queue_div");
						if (div1 != null )
						{	
							div1.style.display="block";
						}
		
						f_query_add_mod.document.getElementById("queue_div").style.visibility="visible";
						f_query_add_mod.document.getElementById("qms_exception").value='Y';	
						var error = getMessage('EXT_QUEUE_NO_CONTACT','OP');
						alert(error);
						
						messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
					}
					else
					{
						f_query_add_mod.document.getElementById("queue_num").value=count;
						f_query_add_mod.document.getElementById("queue_id").value=que_id;
					}
				}	
			}
			if(flag == true){		
				if(qms_interfaced_yn == 'Y' && f_query_add_mod.document.getElementById("qms_exception").value=='Y'){				
				//	f_query_add_mod.document.getElementById("queue_num").value=count;
					f_query_add_mod.document.getElementById("queue_num").value=f_query_add_mod.document.getElementById("queue_no").value;
				}
				if(f_query_add_mod.document.getElementById("asn_locn_code").disabled == true)
					f_query_add_mod.document.getElementById("asn_locn_code").disabled = false;
				f_query_add_mod.document.forms[0].submit();
			}

		}
		else
		{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
		}
	}		
}



function onBlurgetLoc(fac_id,locale,oper_id,loginuser,p_mode,target)
{

		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].assign_care_locn_code.value="";
			return;
		}

 getLocn(fac_id,locale,oper_id,loginuser,p_mode,target);

}

async function getLocn(fac_id,locale,oper_id,loginuser,p_mode,target)
{
	
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	
  
	tit=getLabel('Common.Location.label','Common');

	//sql ="select a.long_desc description, b.locn_code code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+fac_id+"' and a.language_id='"+locale+"' AND a.facility_id=b.facility_id and a.level_of_care_ind='A' and a.eff_status='E'  and a.clinic_type=b.locn_type and a.clinic_code=b.locn_code and b.oper_stn_id= '"+oper_id+"' and b.appl_user_id='"+loginuser+"' and (a.care_locn_type_ind ='C' or a.care_locn_type_ind ='E')";
	
	sql ="select b.locn_code code,a.long_desc description from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+fac_id+"' and a.language_id='"+locale+"' AND a.facility_id=b.facility_id and a.level_of_care_ind='A' and a.eff_status='E'  and a.clinic_type=b.locn_type and a.clinic_code=b.locn_code and b.oper_stn_id= '"+oper_id+"' and b.appl_user_id='"+loginuser+"' and (a.care_locn_type_ind ='C' or a.care_locn_type_ind ='E')";		
	
	if(p_mode=="REVISEVISIT")
		sql =sql+" AND b.revise_visit_yn='Y' ";
	if(p_mode=="CANCELVISIT")
		sql =sql+" AND b.cancel_visit_yn='Y' ";

	sql =sql+" and upper(b.locn_code) like upper(?) and upper(a.long_desc) like upper(?) order by 1 ";   
   
	
  				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
				
				
				if(retVal != null && retVal != "" )
                {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
					document.forms[0].assign_care_locn_code.value=arr[0];
				}

				getOpenToAll(document.forms[0].assign_care_locn_code.value);
}

function getOpenToAll(cliniccode)
{	
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='opentoall' id='opentoall' method='post' action='../../eOP/jsp/FetchValReviseVisit.jsp'><input type='hidden' name='flag_name' id='flag_name' value='assign_care_locn_code1'><input type='hidden' name='clinic_code' id='clinic_code' value='"+cliniccode+"'></form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.forms[0].submit();
}

async function funQry()
{
    if(f_query_add_mod.document.forms[0].bl_interface_yn.value=="Y")
	{
            var retVal;

            var dialogHeight= "20vh";
            var dialogWidth  = "45vw";
            var dialogTop = "0vh";

            var center = "1" ;                                                                                                                                                                           

            var status="no";

            var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling: no";

            var arguments    = "" ;            

            var clinic_code=f_query_add_mod.document.forms[0].asn_locn_code.value

            temp=clinic_code.split("|");
            clinic_code = temp[0];
			var visit_type_code=f_query_add_mod.document.forms[0].cur_visit_type_code.value;

            var patient_id=f_query_add_mod.document.forms[0].patient_id.value

            var episode_type="O"

            var episode_id=f_query_add_mod.document.forms[0].last_episode_no.value

            var visit_id=f_query_add_mod.document.forms[0].last_visit_no.value

            var encounter_id=f_query_add_mod.document.forms[0].l_encounter_id.value

            var facility_id=f_query_add_mod.document.forms[0].facility_id.value
            var calling_module_id="OP";
			         
            var calling_function_id="REVISE_VISIT";

            var logged_user_id=f_query_add_mod.document.forms[0].userid.value

            var practitioner_id=f_query_add_mod.document.forms[0].asn_pract_id.value

            var practitioner_type_ind="P"

 
// all these values are mandatory for our operation.Kindly pass appropriate values to the above variables

 

            var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind+"&old_visit_type_code="+visit_type_code;     

 

 

            retVal = await window.showModalDialog(url,arguments,features);

		

            if(retVal=="1")
            {            
            	return true;  
            }
            else
            {           
            	return false;
            }

	}
    else
	{
    	return true;
	}
}

function reset() {
           document.location.reload();
}

function onSuccess() {
		
	//parent.parent.parent.frames[1].document.location.href='../eOP/jsp/ReviseVisit.jsp?../eCommon/jsp/commonToolbar.jsp?module_id=OP&function_id=REVISE_VISIT&function_name=Revise%20Visit&function_type=F&access=NYNNN';    

	window.document.location.href='../eOP/jsp/ReviseVisit.jsp?module_id=OP&function_id=REVISE_VISIT&function_name=Revise%20Visit&function_type=F&access=NYNNN';    
	
}

function ChangeObj1(obj,val1)
{
    var val1;
    ChangeObj(obj)
}

function PopulateTeam()
{
      var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='queryrevisevisit' id='queryrevisevisit' method='post' action='../../eOP/jsp/FetchValReviseVisit.jsp'><input type='hidden' name='flag_name' id='flag_name' value='asn_pract_id'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[1].document.forms[0].patient_id.value+"'><input type='hidden' name='asn_pract_id' id='asn_pract_id' value='"+parent.frames[1].document.forms[0].asn_pract_id.value+"'><input type='hidden' name='asn_locn_code' id='asn_locn_code' value='"+parent.frames[1].document.forms[0].asn_locn_code.value+"'></form></body></html>";

      parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
      parent.parent.messageFrame.document.forms[0].submit();
}

function query()
{
	
	f_query_add_mod.location.href="../../eOP/jsp/ReviseVisitFrameset1.jsp?p_mode=REVISEVISIT";

}

function ChangeObj(obj)
{
    var obj_value       = obj.value;
    var obj_name        = obj.name;
	var objectText="";
	
	if(obj.options[obj.selectedIndex].value!="")
		 objectText		= "&nbsp;&nbsp;"+obj.options[obj.selectedIndex].text;	

	var old_locn_code = document.forms[0].p_clinic_code.value;
    var frame_list      = "";
	ClearList(obj);
    
	
	if (obj_value != null && obj_value != "")
    {
		if(obj_name == "asn_locn_code")
		{
			
			document.forms[0].asn_pract_id.value = "";
			document.forms[0].pract_name.value = "";			
			document.forms[0].subService.value = "";			
			document.forms[0].other_res_type.value = "";			
			document.forms[0].other_res_txt.value = "";			
			document.getElementById("room_num").value="";
			if(document.forms[0].referal_id1.value != "") 
				document.forms[0].referal_id1.value = "";
	/*		
			if(document.forms[0].referal_id1.value != "" ) {			
				if(document.forms[0].locn_code_old.value != obj_value) {
					if(confirm(getMessage("MISMATCH_REFERRALID_LOCATION","COMMON"))) {		
						document.forms[0].referal_id1.value = "";
					} else {
						document.forms[0].asn_locn_code.value = document.forms[0].locn_code_old.value;				
					}
			    }
			}
	*/
			// Added by Smita Unnikrishnan on 26/03/04 as the queue number updation in OP_Patient_Queue and the next number generation in OP_QUEUE_NUM_FOR_LOCN was based on the value of this object being "Y" which happens only when any value is changed like "Practitioner" or "Location" or "Room number"
			parent.frames[2].document.forms[0].chg_flag.value="Y";
			
		}
		else if (obj_name == "subService")
		{
			return;
		}

     
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='queryrevisevisit' id='queryrevisevisit' method='post' action='../../eOP/jsp/FetchValReviseVisit.jsp'><input type='hidden' name='flag_name' id='flag_name' value='"+obj_name+"'><input type='hidden' name='patient_id' id='patient_id' value='"+parent.frames[2].document.forms[0].patient_id.value+"'><input type='hidden' name='"+obj_name+"' id='"+obj_name+"' value='"+obj_value+"'>";
        
		if (obj_name == "asn_locn_code")
            HTMLVal = HTMLVal+"<input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind' value='"+parent.frames[2].document.forms[0].visit_adm_type_ind.value+"'>";
                   
      	HTMLVal = HTMLVal+"</form></body></html>";
     
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        parent.messageFrame.document.forms[0].submit();
    }
	else
	{
		document.forms[0].asn_pract_id.value = "";
		document.forms[0].pract_name.value = "";
		document.forms[0].pract_butt.disabled = false;
	}
}



function ClearList(object)
{
    var list1   = "";
    var length  ="";
    var element = parent.frames[1].document.createElement('OPTION');
    var obj = object.name;
    element.text= "----------"+getLabel('Common.defaultSelect.label','Common')+"----------";
    element.value="";

    if (obj == "visit_adm_type_ind")
    {
        
        list1 = parent.frames[1].document.forms[0].assign_care_locn_code;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
        parent.frames[1].document.forms[0].assign_care_locn_text.value="";

		list1 = parent.frames[1].document.forms[0].referral_practitioner_id;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);

        if (object.value =='E')
        {
            
            list1 = parent.frames[1].document.forms[0].referral_source_code;
            length  = list1.length;
            for(i=1;i<length;i++)
                list1.remove(1);
            parent.frames[1].document.forms[0].referral_source_type.value="";
        }

        // Attend Practitioner Text

        parent.frames[1].document.forms[0].referral_practitioner_text.value = "";
        parent.frames[1].document.forms[0].referral_practitioner_text.disabled = true;

                
        // Attend Practitioner ID
        list1 = parent.frames[1].document.forms[0].asn_pract_id;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
        parent.frames[1].document.forms[0].pract_type.value="";
        // Reason for Contact
        parent.frames[1].document.forms[0].contact_reason_code.value="";

    }

    else if (obj == "referral_source_type")
    {
        list1 = parent.frames[1].document.forms[0].referral_source_code;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
        ClearList(parent.frames[1].document.forms[0].referral_source_code);
        // Clear the practitioner text
        document.forms[0].referral_practitioner_text.value = "";
        document.forms[0].referral_practitioner_text.disabled = true;
    }

    else if (obj == "referral_source_code")
    {
        list1 = parent.frames[1].document.forms[0].referral_practitioner_id;
        length  = list1.length;
        for(i=1;i<length;i++)
            list1.remove(1);
        document.forms[0].referral_practitioner_text.value = "";
        document.forms[0].referral_practitioner_text.disabled = true;
    }
    else if (obj == "asn_locn_code")
    {
    
        document.forms[0].pract_name.value = "";
		document.forms[0].asn_pract_id.value = "";
		document.forms[0].practitionerMandatoryGIF.style.visibility = "hidden";
		document.forms[0].identifyPractitionerAtCheckIn.value = 'N';
		
		//ClearList(parent.frames[1].document.forms[0].asn_visit_type_code);
        
		var length = parent.frames[2].document.forms[0].Room_numsel.length;

		for(var i=1;i<length;i++)
			parent.frames[2].document.forms[0].Room_numsel.remove(1);

		ClearList(parent.frames[2].document.forms[0].Room_numsel);
			
    }
    else if (obj == "asn_pract_id")
    {
       parent.frames[1].document.forms[0].pract_type.value="";
    }
	
    if (obj == "visit_adm_type_ind" || obj == "assign_care_locn_code")
    {
        // OP Episode Number and Visit Number
        if (parent.frames[1].document.getElementById("op_episode_visit_num") != null)
        {
            parent.frames[1].document.forms[0].op_episode_visit_num.value="";
            parent.frames[1].document.forms[0].op_episode_id.value="";
            parent.frames[1].document.forms[0].old_op_episode_visit_num.value="";
            parent.frames[1].document.forms[0].old_op_episode_id.value="";
            parent.frames[1].document.forms[0].new_op_episode_yn.value="N";
            parent.frames[1].document.forms[0].new_op_episode_yn.disabled=true;
        }
    }
}


function show_visit_dtls(mode)
{
    var frame_list;
    if (mode=="Y")
        frame_list =  parent.frames[1].document.forms[0];
    else
        frame_list = parent.frames[1].frames[1].frames[1].document.forms[0];

    var clinic_code = frame_list.asn_locn_code.value;
    var visit_type_code = frame_list.asn_visit_type_code.value;
    if ((clinic_code.length>0) && (visit_type_code.length>0))
    {
        var visit_date=frame_list.visit_adm_date_time.value;
        var billing_class = frame_list.billing_class.value;
        var mpi_yn = "Y";
        var patient_id = frame_list.patient_id.value;
        var op_episode_id = frame_list.last_episode_no.value;
        var op_episode_type = "O";
        var op_episode_visit_num = frame_list.last_visit_no.value;
        var billing_group = frame_list.billing_group.value;
        var trx_date = visit_date;
        var cust_code = frame_list.cust_1.value;
        var non_ins_blng_grp = frame_list.non_insur_blng_grp.value;
        var non_ins_cust_code = frame_list.cust_4.value;
        var pkg_bill_doc_type = "";//frame_list.pkg_bill_doc_type.value;
        var pkg_bill_doc_num = 0; //frame_list.pkg_bill_doc_num.value;/* In Out */
        var policy_type_code = frame_list.policy_type.value;/* In Out */

        var policy_expiry_date= frame_list.policy_expiry_date.value;
        var mesg_reqd = "0";
        var effective_date = ""; /* In Out */
        var credit_auth_ref = ""; /* In Out */
        var approved_days = 0; /* In Out */
        var pkg_bill_type = "";//frame_list.pkg_bill_type.value;
        var serv_qty = 1;
        var addl_factor = 0;
        var pkg_price = 0;
        var pkg_value = 0;
        var policy_type = frame_list.policy_type.value;
        var base_qty = 1; /* In Out */
        var base_rate = 0;
        var base_charge_amt = 0;
        var gross_charge_amt = 0;
        var disc_amt = 0;
        var net_charge_amt = 0;
        var pat_base_qty = 0;
        var pat_base_rate = 0;
        var pat_serv_qty = 0;
        var pat_base_charge_amt = 0;
        var pat_gross_charge_amt = 0;
        var pat_disc_amt = 0;
        var pat_net_charge_amt = 0;
        var cust_base_qty = 0;
        var cust_base_rate = 0;
        var cust_serv_qty = 0;
        var cust_base_charge_amt = 0;
        var cust_gross_charge_amt = 0;
        var cust_disc_amt = 0;
        var cust_net_charge_amt = 0;

        var qry="";
        var HTMLVal = new String();
        HTMLVal = "<HTML><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eBL/jsp/CalculateVisitCharge.jsp'><input type='hidden' name='visit_date' id='visit_date' value='"+visit_date+"'>"+
        "<input type='hidden' name='billing_class' id='billing_class' value='"+billing_class+"'>"+
        "<input type='hidden' name='billing_group' id='billing_group' value='"+billing_group+"'>"+
        "<input type='hidden' name='mpi_yn' id='mpi_yn' value='"+mpi_yn+"'>"+
        "<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>"+
        "<input type='hidden' name='op_episode_id' id='op_episode_id' value='"+op_episode_id+"'>"+
        "<input type='hidden' name='op_episode_type' id='op_episode_type' value='"+op_episode_type+"'>"+
        "<input type='hidden' name='op_episode_visit_num' id='op_episode_visit_num' value='"+op_episode_visit_num+"'>"+
        "<input type='hidden' name='trx_date' id='trx_date' value='"+trx_date+"'>"+
        "<input type='hidden' name='cust_code' id='cust_code' value='"+cust_code+"'>"+
        "<input type='hidden' name='non_ins_blng_grp' id='non_ins_blng_grp' value='"+non_ins_blng_grp+"'>"+
        "<input type='hidden' name='non_ins_cust_code' id='non_ins_cust_code' value='"+non_ins_cust_code+"'>"+
        "<input type='hidden' name='pkg_bill_doc_type' id='pkg_bill_doc_type' value='"+pkg_bill_doc_type+"'>"+
        "<input type='hidden' name='pkg_bill_doc_num' id='pkg_bill_doc_num' value='"+pkg_bill_doc_num+"'>"+
        "<input type='hidden' name='policy_type_code' id='policy_type_code' value='"+escape(policy_type_code)+"'>"+
        "<input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value='"+policy_expiry_date+"'>"+
        "<input type='hidden' name='mesg_reqd' id='mesg_reqd' value='"+mesg_reqd+"'>"+
        "<input type='hidden' name='effective_date' id='effective_date' value='"+effective_date+"'>"+
        "<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value='"+credit_auth_ref+"'>"+
        "<input type='hidden' name='approved_days' id='approved_days' value='"+approved_days+"'>"+
        "<input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value='"+pkg_bill_type+"'>"+
        "<input type='hidden' name='serv_qty' id='serv_qty' value='"+serv_qty+"'>"+
        "<input type='hidden' name='pkg_price' id='pkg_price' value='"+pkg_price+"'>"+
        "<input type='hidden' name='pkg_value' id='pkg_value' value='"+pkg_value+"'>"+
        "<input type='hidden' name='policy_type' id='policy_type' value='"+escape(policy_type)+"'>"+
        "<input type='hidden' name='base_qty' id='base_qty' value='"+base_qty+"'>"+
        "<input type='hidden' name='base_rate' id='base_rate' value='"+base_rate+"'>"+
        "<input type='hidden' name='base_charge_amt' id='base_charge_amt' value='"+base_charge_amt+"'>"+
        "<input type='hidden' name='gross_charge_amt' id='gross_charge_amt' value='"+gross_charge_amt+"'>"+
        "<input type='hidden' name='disc_amt' id='disc_amt' value='"+disc_amt+"'>"+
        "<input type='hidden' name='net_charge_amt' id='net_charge_amt' value='"+net_charge_amt+"'>"+
        "<input type='hidden' name='pat_base_qty' id='pat_base_qty' value='"+pat_base_qty+"'>"+
        "<input type='hidden' name='pat_base_rate' id='pat_base_rate' value='"+pat_base_rate+"'>"+
        "<input type='hidden' name='pat_serv_qty' id='pat_serv_qty' value='"+pat_serv_qty+"'>"+
        "<input type='hidden' name='pat_base_charge_amt' id='pat_base_charge_amt' value='"+pat_base_charge_amt+"'>"+
        "<input type='hidden' name='pat_gross_charge_amt' id='pat_gross_charge_amt' value='"+pat_gross_charge_amt+"'>"+
        "<input type='hidden' name='pat_disc_amt' id='pat_disc_amt' value='"+pat_disc_amt+"'>"+
        "<input type='hidden' name='pat_net_charge_amt' id='pat_net_charge_amt' value='"+pat_net_charge_amt+"'>"+
        "<input type='hidden' name='cust_base_qty' id='cust_base_qty' value='"+cust_base_qty+"'>"+
        "<input type='hidden' name='cust_base_rate' id='cust_base_rate' value='"+cust_base_rate+"'>"+
        "<input type='hidden' name='cust_serv_qty' id='cust_serv_qty' value='"+cust_serv_qty+"'>"+
        "<input type='hidden' name='cust_base_charge_amt' id='cust_base_charge_amt' value='"+cust_base_charge_amt+"'>"+
        "<input type='hidden' name='cust_gross_charge_amt' id='cust_gross_charge_amt' value='"+cust_gross_charge_amt+"'>"+
        "<input type='hidden' name='cust_disc_amt' id='cust_disc_amt' value='"+cust_disc_amt+"'>"+
        "<input type='hidden' name='cust_net_charge_amt' id='cust_net_charge_amt' value='"+cust_net_charge_amt+"'>"+
        "<input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'>"+
        "<input type='hidden' name='visit_type_code' id='visit_type_code' value='"+visit_type_code+"'>"+
        "<input type='hidden' name='mode' id='mode' value='"+mode+"'>"+
        "</form></BODY></HTML>";

        if (mode=="Y")
        {
            parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.messageFrame.document.form1.submit();
        }
        else
        {
            parent.frames[1].messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.frames[1].messageFrame.document.form1.submit();
        }
    }
}

//JS functions in SearchVisit criteria and result..
/*function DateCheck(obj) 
	{
     var valid=false;
	 var sys_date= parent.frames[1].document.forms[0].sys_date;
	 if(!CheckDate(obj))
	 {
         obj.focus();    
		 obj.select();
		 valid=false;
     }else{
		 valid=true;
	}
	  if(valid)
	{
		  if(!doDateCheckAlert(obj,sys_date))
		{
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","COMMON") ;
                alert(invaldt);
                obj.select();
                obj.focus();
				valid=false;
		}
	}
}*/

function chkWithSysDt(obj)
	{
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				//obj.select();
				obj.value="";
				obj.focus();
				return false ;
			}
		}
}

/*function validateDate(obj)
{
	if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/
 
var param_list="";
var vis_date = "";

function CallDescFrame() {
	  	var visitDate = parent.frames[1].document.forms[0].visit_adm_date_time.value;		
		if(visitDate!="") {
			vis_date = convertDate(visitDate,"DMY",localeName,"en");				
		} else {
			var msg= getMessage('CAN_NOT_BE_BLANK','COMMON');
			msg = msg.replace('$',getLabel("Common.VisitDate.label","COMMON"));
			alert(msg);
			parent.frames[1].document.forms[0].visit_adm_date_time.focus();
			return false;
		}
		var p_mode=parent.frames[1].document.forms[0].p_mode.value;		
		var oper_id=parent.frames[1].document.forms[0].oper_id.value;		
		var package_bl_install_YN=parent.frames[1].document.forms[0].package_bl_install_YN.value;		
		var bl_interfaced_yn=parent.frames[1].document.forms[0].bl_interfaced_yn.value;		
		if(p_mode == null || p_mode == "null")  p_mode="";	

		if(p_mode != "") { 	
			//var visitadmdatetime1 = convertDate(parent.frames[1].document.forms[0].visitadmdatetime.value,"DMY",localeName,"en");
			var visitadmdatetime1 = convertDate(parent.frames[1].document.forms[0].visit_adm_date_time.value,"DMY",localeName,"en");
			
			//if(isAfter(visitadmdatetime1,parent.frames[1].document.forms[0].sys_date1.value,"DMY", localeName)) 
			/*Above line Commented and Below line added by Rameswar on 01-Oct-15 for Leap Year Issue*/
			if(isAfter(visitadmdatetime1,parent.frames[1].document.forms[0].sys_date1.value,"DMY", "en")){
				param_list="";
			    construct_where_clause();
			    parent.frames[1].document.forms[0].Search.disabled = true;  
				if(p_mode == "CANCELVISIT") { 
					if(parent.frames[1].document.forms[0].inc_arrive_cons_start_pats.checked == true)
						Include_Arrive_startCons_yn = "Y";
					else
						Include_Arrive_startCons_yn = "N";	
				   parent.frames[2].location.href="../../eOP/jsp/SearchVisitQueryResult.jsp?bl_interfaced_yn="+bl_interfaced_yn+"&oper_id="+oper_id+"&pmode="+p_mode+"&Include_Arrive_startCons_yn="+Include_Arrive_startCons_yn+"&where_criteria="+parent.frames[1].document.forms[0].where_criteria1.value+param_list;						
			    } else {		
					  parent.frames[2].location.href="../../eOP/jsp/SearchVisitQueryResult.jsp?bl_interfaced_yn="+bl_interfaced_yn+"&package_bl_install_YN="+package_bl_install_YN+"&oper_id="+oper_id+"&pmode="+p_mode+"&where_criteria="+parent.frames[1].document.forms[0].where_criteria1.value+param_list;
				}
			} else {
				var revMsg = "";
				if(p_mode == "REVISEVISIT")
					revMsg = getMessage("REVISE_VISIT_DAYS_LESS_OP_PARAM","OP") ;
				else if(p_mode == "CANCELVISIT")
					revMsg = getMessage("CANNOT_CANCEL_VISIT_LESSER_DATE","OP") ;
				alert(revMsg);				
				parent.frames[2].location.href='../../eCommon/html/blank.html';				
			 }
	    } else {			
			  param_list="";
			  construct_where_clause();		 
			  parent.frames[1].document.forms[0].Search.disabled = true; 		  parent.frames[2].location.href="../../eOP/jsp/SearchVisitQueryResult.jsp?bl_interfaced_yn="+bl_interfaced_yn+"&oper_id="+oper_id+"&pmode="+p_mode+"&where_criteria="+parent.frames[1].document.forms[0].where_criteria1.value+param_list;
         }		
     }
function ClearFrame()
{
    parent.frames[1].document.SearchVisit.reset() ;
	document.forms[0].Search.disabled = false;
    parent.frames[2].location.href='../../eCommon/html/blank.html';
  
}

function construct_where_clause()
{   
	var facilityId=parent.frames[1].document.forms[0].facilityId.value;
    var where_criteria  = "";
    var and_yn      = " and ";
    var soundex_function    ="";
    var whereCriteria1="";
    	
	//Start Date

    if (!(parent.frames[1].document.forms[0].visit_adm_date_time.value==null || parent.frames[1].document.forms[0].visit_adm_date_time.value==""))
    {
        where_criteria  = " and trunc(a.check_in_date_time) >= to_date('"+vis_date+"','dd/mm/yyyy')";
        and_yn      = "  and ";
      
		whereCriteria1  = " and trunc(a.visit_adm_date_time) >= to_date('"+vis_date+"','dd/mm/yyyy')";
        and_yn      = "  and ";
	}
	
    //Clinic
    if (!(parent.frames[1].document.forms[0].assign_care_locn_code.value==null || parent.frames[1].document.forms[0].assign_care_locn_code.value==""))
    {
		
		var cliniccode	= parent.frames[1].document.forms[0].assign_care_locn_code.value;		
		var arrval1 = cliniccode.split("|");
		var locncode = arrval1[0];
		         
		where_criteria  += and_yn+ "    a.locn_code    ='"+locncode+    "'";
        and_yn      = " and ";
	
    }

    //Practitioner
    if ( !(parent.frames[1].document.forms[0].practitioner_id.value==null || parent.frames[1].document.forms[0].practitioner_id.value==""))
    {
        where_criteria  += and_yn+ "    a.practitioner_id='"+parent.frames[1].document.forms[0].practitioner_id.value+  "'";
        and_yn      = " and";
    
	    
	}

    //Encounter ID
    if (!(parent.frames[1].document.forms[0].encounter_id.value==null || parent.frames[1].document.forms[0].encounter_id.value==""))
    {
        where_criteria  += and_yn+ "   a.encounter_id='"+parent.frames[1].document.forms[0].encounter_id.value+   "'";
        and_yn      = "  and";
    
	}
		
   
	//Patient ID
    if (!(parent.frames[1].document.forms[0].patient_id.value==null || parent.frames[1].document.forms[0].patient_id.value==""))
    {
        where_criteria  += and_yn+ "   a.patient_id='"+parent.frames[1].document.forms[0].patient_id.value+   "'";
        and_yn      = " and  ";
    }

    //MRN
   
  parent.frames[1].document.forms[0].where_criteria1.value  = where_criteria;

}

function callPractSearch(obj,target)
		{
			
			var practName_FName="";
			var practName_FValue="";
			var practId_FName="";
			var facilityid = parent.frames[1].document.forms[0].facilityId.value;
			
			var cliniccode	=parent.frames[1].document.forms[0].assign_care_locn_code.value;		
			var arrval = cliniccode.split("|");
			var cur_locn_code = arrval[0];			

			var open_to_all_pract_yn = parent.frames[1].document.forms[0].open_to_all_pract_yn.value;

			var locale=parent.frames[1].document.forms[0].locale.value;		
			
			target.value=trimString(target.value);

			if(target.value=="" && window.event.target == target)
			{
				parent.frames[1].document.forms[0].practitioner_id.value="";
				return;
			}
			
			practName_FName=target.name;
			practName_FValue=target.value;
						
			var sql="";
			var sqlsec="";
			
			//do not forget to give aliases as mentioned below	
			
			
			if(open_to_all_pract_yn=="Y")
			{
				
				//getPractitioner(obj,target,facilityid,'','',cur_locn_code,'','','','',"Q10");	
				
				getPractitioner(obj,target,facilityid,'','',cur_locn_code,'','','','',"Q4");

				/*

				//sql = " SELECT  distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, am_pract_for_facility d, op_clinic e WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' and e.facility_id=d.facility_id and e.clinic_code='"+cur_locn_code+"' and (e.speciality_code = a.primary_speciality_code or e.speciality_code in (select speciality_code from am_pract_specialities where facility_id='"+facilityid+"' and practitioner_id=a.practitioner_id)) and nvl(e.pract_type,a.pract_type) = a.pract_type order by 2 ";

				sql = " SELECT DISTINCT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name   ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"','1') practitioner_type ,am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"','2') primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,am_pract_for_facility d,op_clinic e WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND   (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)  AND a.practitioner_id=d.practitioner_id AND d.eff_status='E' AND d.facility_id='"+facilityid+"' AND e.facility_id=d.facility_id   AND e.clinic_code='"+cur_locn_code+"' AND (e.speciality_code = a.primary_speciality_code OR e.speciality_code IN ( SELECT      speciality_code  FROM am_pract_specialities WHERE facility_id='"+facilityid+"' AND practitioner_id=a.practitioner_id)) AND NVL(e.pract_type,a.pract_type) = a.pract_type ORDER BY 2 ";

				//sqlsec=" SELECT  distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, am_pract_for_facility d, op_clinic e WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' and e.facility_id=d.facility_id and e.clinic_code='"+cur_locn_code+"' and (e.speciality_code = a.primary_speciality_code or e.speciality_code in (select speciality_code from am_pract_specialities where facility_id='"+facilityid+"' and practitioner_id=a.practitioner_id)) and nvl(e.pract_type,a.pract_type) = a.pract_type order by 2 ";
			

				sqlsec = " SELECT DISTINCT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name   ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"','1') practitioner_type ,am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"','2') primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,am_pract_for_facility d,op_clinic e WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND   (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)  AND a.practitioner_id=d.practitioner_id AND d.eff_status='E' AND d.facility_id='"+facilityid+"' AND e.facility_id=d.facility_id   AND e.clinic_code='"+cur_locn_code+"' AND (e.speciality_code = a.primary_speciality_code OR e.speciality_code IN ( SELECT      speciality_code  FROM am_pract_specialities WHERE facility_id='"+facilityid+"' AND practitioner_id=a.practitioner_id)) AND NVL(e.pract_type,a.pract_type) = a.pract_type ORDER BY 2 ";

				*/
				
				
			}
			else
			{
				//getPractitioner(obj,target,facilityid,'','',cur_locn_code,'','','','',"Q11");	
				
				getPractitioner(obj,target,facilityid,'','',cur_locn_code,'','SearchVist','','',"Q6");

				/*
				//sql=" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,op_pract_for_clinic_vw d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and d.facility_id= '"+facilityid+"' and d.clinic_code=nvl('"+cur_locn_code+"',d.clinic_code) and d.eff_status='E' and a.practitioner_id=d.practitioner_id order by 2";

				sql="SELECT DISTINCT a.practitioner_id practitioner_id , a.practitioner_name practitioner_name   ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type  , am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty ,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,op_pract_for_clinic d WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (   UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND d.facility_id= '"+facilityid+"' AND d.clinic_code=NVL('"+cur_locn_code+"',d.clinic_code) AND d.eff_status='E' AND a.practitioner_id=d.practitioner_id ORDER BY 2";
				
				
				//sqlsec=" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,op_pract_for_clinic_vw d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and d.facility_id= '"+facilityid+"' and d.clinic_code=nvl('"+cur_locn_code+"',d.clinic_code) and d.eff_status='E' and a.practitioner_id=d.practitioner_id order by 2";

				sqlsec="SELECT DISTINCT a.practitioner_id practitioner_id , a.practitioner_name practitioner_name   ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type  , am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty ,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,op_pract_for_clinic d WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (   UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND d.facility_id= '"+facilityid+"' AND d.clinic_code=NVL('"+cur_locn_code+"',d.clinic_code) AND d.eff_status='E' AND a.practitioner_id=d.practitioner_id ORDER BY 2";
				*/
			}
			
			
			/*var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " sql=\"" +escape(sql)+"\"";
			xmlStr += " sqlSec=\"" +escape(sqlsec)+"\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + "" + "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);			
			eval(responseText);	*/
			
		}

		function PractLookupRetVal(retVal,objName)
		{		
			          
            if(objName == "pract_name1")
			{
				var arr;
				if (retVal != null)
				{
				arr=retVal.split("~");
				document.forms[0].practitioner_id.value=arr[0];
				document.forms[0].pract_name1.value=arr[1];
				}
				else
					{
				document.forms[0].practitioner_id.value="";
				document.forms[0].pract_name1.value="";			
					}
			}else
			{
				
			var arr;
			var locn_code	= document.forms[0].asn_locn_code.value;
			var locnvals=new Array();
			locnvals=locn_code.split("|");
			var cur_locn_code=locnvals[0];
			if (retVal != null && trimString(retVal) != "")
			{
				arr=retVal.split("~");
				document.forms[0].asn_pract_id.value=arr[0];
				document.forms[0].pract_name.value=arr[1];
				
				//parent.parent.frames[1].frames[1].document.getElementById("asn_pract_type").innerHTML=arr[7];

				document.forms[0].chg_flag.value="Y";
				
				var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='queryrevisevisit' id='queryrevisevisit' method='post' action='../../eOP/jsp/FetchValReviseVisit.jsp'><input type='hidden' name='flag_name' id='flag_name' value='asn_medical_team'><input type='hidden' name='asn_pract_id' id='asn_pract_id' value='"+arr[0]+"'><input type='hidden' name='asn_locn_code' id='asn_locn_code' value='"+cur_locn_code+"'></form></body></html>";
				parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[3].document.forms[0].submit();
				
			}else
			{
			    document.forms[0].asn_pract_id.value="";
			    document.forms[0].pract_name.value="";	
				//parent.parent.frames[1].frames[1].document.getElementById("asn_pract_type").innerHTML="";
				
			}
		}		
	}

function PractEnableDisable(Obj)
{
	if(Obj.value != "")
	{
		parent.frames[1].document.forms[0].practitioner_id.value = "";
		parent.frames[1].document.forms[0].pract_name1.value = "";
		parent.frames[1].document.forms[0].pract_name1.readOnly = false;
		parent.frames[1].document.forms[0].pract_butt.disabled = false;
	}
	else
	{
		parent.frames[1].document.forms[0].practitioner_id.value = "";
		parent.frames[1].document.forms[0].pract_name1.value = "";
		parent.frames[1].document.forms[0].pract_name1.readOnly = true;
		parent.frames[1].document.forms[0].pract_butt.disabled = true;			
	}
}

function callBlank()
  {
    parent.frames[3].location.href='../../eCommon/html/blank.html'
  }

function call_result2(patientid,pmode)
  {
	parent.frames[3].location.href='../../eOP/jsp/SearchVisitQueryResult2.jsp?oper_id='+oper_id+'&patientid='+patientid+'&pmode='+pmode+'&where_criteria='+parent.frames[1].document.forms[0].whereCriteria.value;
  }


function closew(Dcode,Ddate,patientid,QStatus,arriveDTime,VitalDtime,queue_num,bl_interfaced_yn,status,op_episode_visit_num,episode_id,count,package_bl_install_YN){   
	oper_id=document.forms[0].oper_id.value;
	build_episode_rule=parent.frames[1].document.forms[0].build_episode_rule.value;
	assign_queue_num_by=parent.frames[1].document.forms[0].assign_queue_num_by.value;
	sys_date=parent.frames[1].document.forms[0].queue_date.value;	
    if(parent.frames[1].document.forms[0].p_mode.value=="REVISEVISIT"){ 
		//added for Package Billing
		if(parent.frames[2].document.forms[0].bl_install_yn.value=="Y" && package_bl_install_YN=="Y"){
			var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='packageCheck' id='packageCheck' method='post' action='../../eOP/jsp/OPPackageIntermediateValidations.jsp'>";
			HTMLVal+="<input type='hidden' name='encounter_id' id='encounter_id' value='"+Dcode+"'>";
			HTMLVal+="<input type='hidden' name='queue_date' id='queue_date' value='"+Ddate+"'>";
			HTMLVal+="<input type='hidden' name='QStatus' id='QStatus' value='"+QStatus+"'>";
			HTMLVal+="<input type='hidden' name='arriveDTime' id='arriveDTime' value='"+arriveDTime+"'>";
			HTMLVal+="<input type='hidden' name='VitalDtime' id='VitalDtime' value='"+VitalDtime+"'>";
			HTMLVal+="<input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'>";
			HTMLVal+="<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value='"+bl_interfaced_yn+"'>";
			HTMLVal+="<input type='hidden' name='oper_id' id='oper_id' value='"+oper_id+"'>";
			HTMLVal+="<input type='hidden' name='called_function' id='called_function' value='REVISEVISIT'>";
			HTMLVal+="<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='Y'>";
			HTMLVal+="<input type='hidden' name='patient_id' id='patient_id' value='"+patientid+"'>";
			HTMLVal+="<input type='hidden' name='rowNum' id='rowNum' value='"+count+"'>";
			HTMLVal+="<input type='hidden' name='build_episode_rule' id='build_episode_rule' value='"+build_episode_rule+"'>";
			HTMLVal+="<input type='hidden' name='assign_queue_num_by' id='assign_queue_num_by' value='"+assign_queue_num_by+"'>";
			HTMLVal+="<input type='hidden' name='sys_date' id='sys_date' value='"+sys_date+"'>";
			HTMLVal+="<input type='hidden' name='status' id='status' value='"+status+"'>";
			HTMLVal+= "</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.packageCheck.submit();
		}else{
			/*count=parseInt(count);
			count=count+1;
			for( k=0;k<6;k++)
					parent.frames[2].document.getElementById("tb1").rows(count).cells(k).style.backgroundColor=obj.style.backgroundColor;
			for( k=0;k<6;k++)
					parent.frames[2].document.getElementById("tb1").rows(count).cells(k).style.backgroundColor="#B2B6D7" ;*/
			//parent.rv.rows='42,10%,*,30';
			parent.frames[1].document.location.href='../../eCommon/jsp/pline.jsp?P_MODULE_ID=OP&P_FUNCTION_ID=REVISE_VISIT&EncounterId='+Dcode
			parent.frames[2].document.location.href="../../eOP/jsp/ReviseVisitMain.jsp?encounter_id="+Dcode+"&queue_date="+Ddate+"&Patient="+patientid+"&QStatus="+QStatus+"&ArriveDTime="+arriveDTime+"&VitalDTime="+VitalDtime+"&queue_num="+queue_num+"&oper_id="+oper_id+"&bl_interfaced_yn="+bl_interfaced_yn+"&sys_date="+sys_date+"&assign_queue_num_by="+assign_queue_num_by+"&build_episode_rule="+build_episode_rule+"&status="+status;
			
			parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp"
			parent.frames[4].document.location.href='../../eBL/jsp/BLSessionValuesReset.jsp';
	   }
	  
	  }else if(parent.frames[1].document.forms[0].p_mode.value=="CANCELVISIT")  {	 
		  /*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
						Modified by Suresh M
		  */				 
	//	 if(bl_interfaced_yn == "N") { //commented for SKR-SCF-0615 [IN:034919]  by Srinivas.Y
				 var xmlStr ="<root><SEARCH ";
				 xmlStr +=" /></root>";
				 var param="called_function=CANCELVISIT&encounter_id="+Dcode+"&pat_id="+patientid;
				 var temp_jsp="../../eOP/jsp/OPPackageIntermediateValidations.jsp?"+param;
				 var xmlDoc = "" ;
				 var xmlHttp = new XMLHttpRequest() ;
				 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				 xmlHttp.open("POST",temp_jsp,false);
				 xmlHttp.send(xmlDoc);
				 responseText=trimString(xmlHttp.responseText);
				 var retVal =responseText.split("#")				
				 if(retVal[1] == 0){	 
					  //parent.rv.rows='42,10%,*,30'
					  parent.document.getElementById("group_head").style.height="9vh";
					  parent.document.getElementById("f_query_add_mod").style.height="74vh";
					  parent.document.getElementById("messageFrame").style.height="8vh";
						   
					  parent.frames[1].document.location.href='../../eCommon/jsp/pline.jsp?P_MODULE_ID=OP&P_FUNCTION_ID=REVISE_VISIT&EncounterId='+Dcode
					  parent.frames[2].document.location.href="../../eOP/jsp/CancelVisitFrame2.jsp?encounter_id="+Dcode+"&queue_date="+Ddate+"&Patient="+patientid+"&QStatus="+QStatus+"&ArriveDTime="+arriveDTime+"&VitalDTime="+VitalDtime+"&queue_num="+queue_num+"&bl_interfaced_yn="+bl_interfaced_yn;
					  parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp"
			    } else {
				   alert(getMessage("ORDERS_PLACED_CANNOT_CANCEL","OP"));		
				   parent.frames[2].location.reload();
			    }		
	/*	 } else {		//commented for SKR-SCF-0615 [IN:034919]  by Srinivas.Y
				 parent.rv.rows='42,10%,*,30'
				 parent.frames[1].document.location.href='../../eCommon/jsp/pline.jsp?EncounterId='+Dcode
				 parent.frames[2].document.location.href="../../eOP/jsp/CancelVisitFrame2.jsp?encounter_id="+Dcode+"&queue_date="+Ddate+"&Patient="+patientid+"&QStatus="+QStatus+"&ArriveDTime="+arriveDTime+"&VitalDTime="+VitalDtime+"&queue_num="+queue_num+"&bl_interfaced_yn="+bl_interfaced_yn;
				 parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp"
					
			} */ // end for SKR-SCF-0615 [IN:034919]  by Srinivas.Y
  	  } else 	  {
			/* parent.rv.rows='42,10%,*,30'
			   
			   parent.frames[1].document.location.href='../../eCommon/html/blank.html'*/
			   parent.frames[4].document.location.href="../../eOP/jsp/OpinternlReportReprintModal.jsp?encounterid="+Dcode+"&file_created_at_regn_yn=N"
			   //parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp"	  
	  		}
	
	//parent.window.returnValue=Dcode+"|"+Ddate+"|"+patientid+"|"+QStatus+"|"+arriveDTime+"|"+VitalDtime+"|"+queue_num;
    //parent.window.close();
	
  }

// JS functions in ReviseVisit main.jsp

function onblurres()
{
	if(parent.parent.frames[1].frames[1].document.forms[0].pract_name.value != "" && parent.parent.frames[1].frames[1].document.forms[0].resclass.value != "")
	{
		resourcenamelookup();
	}
	if(parent.parent.frames[1].frames[1].document.forms[0].pract_name.value =="")
	{
		parent.parent.frames[1].frames[1].document.forms[0].asn_pract_id.value="";
	    return;
	}
}

async function resourcenamelookup()
	{
  	var res_class=parent.parent.frames[1].frames[1].document.forms[0].resclass.value;
	var res_type=parent.parent.frames[1].frames[1].document.forms[0].restype.value;
	var facilityid =parent.parent.frames[1].frames[1].document.forms[0].facility_id.value;
    var sql="";
	
			var tit				= getLabel('Common.resourcename.label','Common')
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;

			if(res_class=="R")
					{	

					//sql="select a.room_num code,a.short_desc description from am_facility_room a where a.operating_facility_id='"+facilityid+"' and a.resident_stay_yn = 'N' and a.room_type=nvl('"+res_type+"',a.room_type) and a.eff_Status='E' and upper(a.room_num) like upper(?) and upper(a.short_desc)  like upper(?) ";

					sql="select a.room_num code,a.short_desc description from am_facility_room_lang_vw a where a.operating_facility_id='"+facilityid+"' and language_id='"+locale+"' and a.resident_stay_yn = 'N' and a.room_type=nvl('"+res_type+"',a.room_type) and a.eff_Status='E' and upper(a.room_num) like upper(?) and upper(a.short_desc)  like upper(?)";
					
					}
					else if(res_class=="E" || res_class=="O")
					{
					   
						//sql="select a.resource_id code,a.short_desc description from am_resource a  where a.resource_class='"+res_class+"' and a.resource_type= nvl('"+res_type+"',a.resource_type) and  a.facility_id='"+facilityid+"' and a.eff_Status='E' and upper( a.resource_id) like upper(?) and upper(a.short_desc) like upper(?) "

						sql="select a.resource_id code,a.short_desc description from am_resource_lang_vw a  where a.resource_class='"+res_class+"' and language_id='"+locale+"' and a.resource_type= nvl('"+res_type+"',a.resource_type) and  a.facility_id='"+facilityid+"' and a.eff_Status='E' and upper( a.resource_id) like upper(?) and upper(a.short_desc) like upper(?) "
					}
					
					argumentArray[0]	= sql;
					argumentArray[1]	= dataNameArray ;
					argumentArray[2]	= dataValueArray ;
					argumentArray[3]	= dataTypeArray ;
					argumentArray[4]	= "1,2";
					argumentArray[5]	= document.forms[0].pract_name.value;
					argumentArray[6]	= DESC_LINK;
					argumentArray[7]	= DESC_CODE;

					

					retVal = await CommonLookup( tit, argumentArray );

					if(retVal != null && retVal != "" )
					{
						var ret1=unescape(retVal);
						arr=ret1.split(",");
					document.forms[0].pract_name.value=arr[1];
					document.forms[0].asn_pract_id.value=arr[0];
						
					}
					else
					{
					document.forms[0].pract_name.value="";
					document.forms[0].asn_pract_id.value="";
					}
	}
	function onBlurCallPractitionerSearch(obj,target_name)
		{
		 
		 target_name.value = trimString(target_name.value);
		 
		 if(target_name.value == "")
			{
			 document.forms[0].asn_pract_id.value="";
			 return;
			}
			callPractSearchRevise(obj,target_name);
		}

  function callPractSearchRevise(obj,target)
		{
			
         	var resourceClass=document.forms[0].res_class.value;
						
			//parent.parent.frames[1].frames[1].document.getElementById("asn_pract_type").innerHTML = "";
			target.value=trimString(target.value);
		   			
			if(target.value == "" && window.event.target == target)
			{
			document.forms[0].asn_pract_id.value = "";
				return;
			}
          
			var practName_FName=target.name;
			var practName_FValue=target.value;			
			var facilityid = document.forms[0].facility_id.value;

			//Following query was included by smita on 9/3/2004 as the specialty was not being considered in the pract lookup

			var locn_code			= document.forms[0].asn_locn_code.value;
			var locnvals=new Array();
			locnvals=locn_code.split("|");
			var visitadmtype		= document.forms[0].cur_visit_type_code.value;
			var cur_locn_code=locnvals[0];
			var open_to_all_pract_yn=locnvals[3];
			var cur_speciality_code=locnvals[4];
			var cur_pract_type=document.getElementById("pract_type").value;
			var locale=document.forms[0].locale.value;
			
			var sql="";
			var sqlsec="";
			
			if(open_to_all_pract_yn=="Y")
			{		

				//getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','','','',"Q8");

				getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','','','',"Q4");

				/*
				//sql = " SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,OP_REGISTER_VISIT_PRACT_VW d,op_clinic e WHERE a.pract_type=b.pract_type AND d.clinic_code=e.clinic_code AND D.FACILITY_ID=E.FACILITY_ID AND c.speciality_code = e.speciality_code AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.facility_id= '"+facilityid+"' and d.clinic_code='"+cur_locn_code+"' ";

				sql = " SELECT a.practitioner_id practitioner_id , a.practitioner_name practitioner_name, am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, am_get_desc.AM_SPECIALITY(e.speciality_code,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,OP_REGISTER_VISIT_PRACT_VW d ,op_clinic e WHERE d.clinic_code=e.clinic_code AND D.FACILITY_ID=E.FACILITY_ID  AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))   AND a.gender LIKE (?)  AND  (a.position_code LIKE (?) OR a.position_code IS NULL )  AND a.practitioner_id=d.practitioner_id AND d.facility_id= '"+facilityid+"' AND d.clinic_code='"+cur_locn_code+"'";

;

				//sqlsec = " SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,OP_REGISTER_VISIT_PRACT_VW d,op_clinic e WHERE a.pract_type=b.pract_type AND D.FACILITY_ID=E.FACILITY_ID AND  d.clinic_code=e.clinic_code AND c.speciality_code = e.speciality_code AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  AND  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.facility_id= '"+facilityid+"' and d.clinic_code='"+cur_locn_code+"' ";

				sqlsec = " SELECT a.practitioner_id practitioner_id , a.practitioner_name practitioner_name, am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, am_get_desc.AM_SPECIALITY(e.speciality_code,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM am_practitioner a  ,OP_REGISTER_VISIT_PRACT_VW d ,op_clinic e WHERE d.clinic_code=e.clinic_code AND D.FACILITY_ID=E.FACILITY_ID  AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))   AND a.gender LIKE (?)  AND  (a.position_code LIKE (?) OR a.position_code IS NULL )  AND a.practitioner_id=d.practitioner_id AND d.facility_id= '"+facilityid+"' AND d.clinic_code='"+cur_locn_code+"'";
				*/

			}
			else
			{
				//getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','',cur_pract_type,visitadmtype,"Q12");

				getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','',cur_pract_type,visitadmtype,"Q3");

			/*sql = "SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM op_pract_for_clinic a, am_practitioner b, op_clinic c,am_pract_type d,am_speciality e WHERE b.pract_type=d.pract_type AND c.speciality_code=e.speciality_code AND b.pract_type LIKE (?)  AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code ";

				if(cur_pract_type != "R")
				{				
					sql += " AND b.pract_type=NVL(c.pract_type,b.pract_type)";
				}
				
				sql += " AND DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+facilityid+"'),'F',a.fi_visit_type_appl_yn,'L',a.fu_visit_type_appl_yn, 'R',a.rt_visit_type_appl_yn,'S',a.sr_visit_type_appl_yn, 'C',a.cs_visit_type_appl_yn,'E',a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+cur_locn_code+"'  AND c.facility_id = a.facility_id AND a.facility_id='"+facilityid+"' AND a.eff_status = 'E' "; */
				
				//Commented by MM
				/*
				sql = "SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name  ,am_get_desc.am_pract_type(b.pract_type,'"+locale+"',1) practitioner_type,am_get_desc.AM_SPECIALITY(c.speciality_code,'"+locale+"',2) primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.position_code job_title FROM  op_pract_for_clinic a, am_practitioner b, op_clinic c WHERE b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND a.practitioner_id =b.practitioner_id AND a.clinic_code=c.clinic_code ";

				if(cur_pract_type != "R")
				{				
					sql += "  AND b.pract_type=NVL(c.pract_type,b.pract_type)";
				}
				
				sql += " AND DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+facilityid+"'),'F',a.fi_visit_type_appl_yn,'L',a.fu_visit_type_appl_yn, 'R' ,a.rt_visit_type_appl_yn,'S',a.sr_visit_type_appl_yn, 'C',a.cs_visit_type_appl_yn,'E',a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+cur_locn_code+"' AND c.facility_id = a.facility_id AND a.facility_id='"+facilityid+"' AND a.eff_status = 'E'";
				*/
				//End Of Comment

				/*sqlsec="SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM op_pract_for_clinic a, am_practitioner b, op_clinic c,am_pract_type d,am_speciality e WHERE b.pract_type=d.pract_type AND c.speciality_code=e.speciality_code AND b.pract_type LIKE (?)  AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code ";

				if(cur_pract_type != "R")
				{				
					sqlsec += " AND b.pract_type=NVL(c.pract_type,b.pract_type)";
				}
				
				sqlsec += " AND DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+facilityid+"'),'F',a.fi_visit_type_appl_yn,'L',a.fu_visit_type_appl_yn, 'R',a.rt_visit_type_appl_yn,'S',a.sr_visit_type_appl_yn, 'C',a.cs_visit_type_appl_yn,'E',a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+cur_locn_code+"'  AND c.facility_id = a.facility_id AND a.facility_id='"+facilityid+"' AND a.eff_status = 'E'  ";*/

				//Commented by MM
				/*
				sqlsec = "SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name  ,am_get_desc.am_pract_type(b.pract_type,'"+locale+"',1) practitioner_type,am_get_desc.AM_SPECIALITY(c.speciality_code,'"+locale+"',2) primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.position_code job_title FROM  op_pract_for_clinic a, am_practitioner b, op_clinic c WHERE b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND a.practitioner_id =b.practitioner_id AND a.clinic_code=c.clinic_code ";

				if(cur_pract_type != "R")
				{				
					sqlsec += "  AND b.pract_type=NVL(c.pract_type,b.pract_type)";
				}
				
				sqlsec += " AND DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+facilityid+"'),'F',a.fi_visit_type_appl_yn,'L',a.fu_visit_type_appl_yn, 'R' ,a.rt_visit_type_appl_yn,'S',a.sr_visit_type_appl_yn, 'C',a.cs_visit_type_appl_yn,'E',a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+cur_locn_code+"' AND c.facility_id = a.facility_id AND a.facility_id='"+facilityid+"' AND a.eff_status = 'E'";

				*/
				//End Of Comment
					
			}
			/*
            var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + practName_FName + "\"";
			xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " sql=\"" +escape(sql)+"\"";
			xmlStr += " sqlSec=\"" +escape(sqlsec)+"\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" +cur_speciality_code+ "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);	
			*/
			
		}

async function otherResourceLookUp(obj,target)
{
	
	var locn_code			= document.forms[0].asn_locn_code.value;
	var locnvals=new Array();
	locnvals=locn_code.split("|");
	var clinic_code=locnvals[0];

	var other_resType=document.forms[0].other_res_type.value;
	var facilityid = document.forms[0].facility_id.value;
	locale=document.forms[0].locale.value;
	var oth_res_id=document.forms[0].oth_res_id.value;

	if(other_resType != '')
	{
	
   var sql="SELECT PRACTITIONER_ID code,  	DECODE(RESOURCE_CLASS,'P',am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID,PRACTITIONER_ID,'"+locale+"','2'),'E',AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) description  FROM   OP_PRACT_FOR_CLINIC WHERE facility_id='"+facilityid+"'   AND resource_class='"+other_resType+"'   AND clinic_code='"+clinic_code+"'   AND UPPER(PRACTITIONER_ID) LIKE UPPER(?)   AND DECODE(RESOURCE_CLASS,'P', am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E',AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) LIKE UPPER(?) ORDER BY 2"

	var tit				= getLabel('Common.resource.label','Common');
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

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].other_res_txt.value=arr[1];
		document.forms[0].other_res_code.value=arr[0];
		if(oth_res_id != arr[0])
	 		document.forms[0].chg_flag.value="Y";
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
   document.forms[0].chg_flag.value="Y";
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


 function new_episode_yn_func(obj)
   {
      var obj_value = obj.value;
      
	  if (obj_value == "N")
        obj.value = "Y";
      else
        obj.value = "N";

      if (obj.value == "Y")
      {
        parent.parent.frames[1].frames[1].document.forms[0].old_op_episode_id.value        = parent.parent.frames[1].frames[1].document.forms[0].op_episode_id.value;
        parent.parent.frames[1].frames[1].document.forms[0].old_op_episode_visit_num.value = parent.parent.frames[1].frames[1].document.forms[0].op_episode_visit_num.value;
       parent.parent.frames[1].frames[1].document.forms[0].op_episode_id.value            = "";
       parent.parent.frames[1].frames[1].document.forms[0].op_episode_visit_num.value     = "";
      }
      else
      {
        parent.parent.frames[1].frames[1].document.forms[0].op_episode_id.value            = parent.parent.frames[1].frames[1].document.forms[0].old_op_episode_id.value;
        parent.parent.frames[1].frames[1].document.forms[0].op_episode_visit_num.value     = parent.parent.frames[1].frames[1].document.forms[0].old_op_episode_visit_num.value;
      }
    }
function setroomno()
{	

parent.frames[2].document.getElementById("room_num").value = parent.frames[2].document.forms[0].Room_numsel.options[parent.frames[2].document.forms[0].Room_numsel.options.selectedIndex].value;
parent.frames[2].document.forms[0].chg_flag.value="Y";
parent.frames[2].document.getElementById("room_change").value = parent.frames[2].document.getElementById("room_num").value;

}

async function getPatID()
{					  
	var pat_id=await PatientSearch();
	if( pat_id != null )						
		parent.frames[1].document.forms[0].patient_id.value = pat_id ;					
}

async function getReferralID() {
	var locn_code = document.forms[0].asn_locn_code.value;	
	var locn_code_array = locn_code.split("|");		
	var p_to_locn_code=locn_code_array[0];	
//	 document.forms[0].locn_code_old.value = document.forms[0].asn_locn_code.options[document.forms[0].asn_locn_code.selectedIndex].value;
	 var p_to_pract_id=document.forms[0].cur_practitioner_id.value;
	 var p_to_pract_name=document.forms[0].cur_pract_name.value;	 
	 var p_speciality_code=document.forms[0].cur_specialty_code.value;
	 var p_service_code=document.forms[0].cur_service_code.value;
	 var res_class=document.forms[0].resclass.value;
	 var p_to_locn_type=document.forms[0].cur_locn_type.value;
	 var p_patient_id=document.forms[0].patient_id.value;	 
	 var p_service_code=document.forms[0].cur_service_code.value;	 
	 
	var funcid="";	
	var retVal;
	var dialogTop       = "61";
	var dialogHeight    = "1000px";
	var dialogWidth = "1500px";    
	var arguments   = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
	var arguments   = "" ;	
	url="../../eMP/jsp/ReferralSearchFrameset.jsp?p_calling_function=REV_VISIT_DTLS&p_to_locn_type="+p_to_locn_type+"&p_to_locn_code="+p_to_locn_code+"&res_class="+res_class+"&p_to_pract_id="+p_to_pract_id+"&p_to_pract_name="+p_to_pract_name+"&p_speciality_code="+p_speciality_code+"&p_service_code="+p_service_code+"&p_select=YES&p_reg_patient=YES&p_patient_id="+p_patient_id;
	
	retVal = await window.showModalDialog(url,arguments,features);
	
	if(retVal==null) retVal="";
	document.getElementById("referal_id1").value= retVal	

	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" );
	var xmlHttp = new XMLHttpRequest("Microsoft.XMLHTTP");
	xmlHttp.open("POST","../../eCommon/jsp/commonToolbar.jsp?module_id=OP&function_id=REVISE_VISIT&function_name=Revise%20Visit&function_type=F&menu_id=OP_TRANSACTIONS&access=NYNNN&desktopFlag=N",false);
	xmlHttp.send(null);		
	responseText=xmlHttp.responseText;
	
}

function searchReferral(obj)
{	
	 	 if(document.forms[0].referal_id1.value!='')
           {
	         if(obj.value!='')	
	         {					 
			     var revisVisitFlag = "Y";
				 var locn_code = document.forms[0].asn_locn_code.value;	
				 var locn_code_array = locn_code.split("|");		
				 var p_to_locn_code=locn_code_array[0];
				 var referal_id1 =document.forms[0].referal_id1.value;
				 var patient_id =document.forms[0].patient_id.value;
                 var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOP/jsp/GetValResource.jsp'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+referal_id1+"'><input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value='"+p_to_locn_code+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='revisVisitFlag' id='revisVisitFlag' value='"+revisVisitFlag+"'></form></BODY></HTML>";				
				 parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				 parent.frames[3].document.form1.submit();
		     }
	      }	  
}

function chkValue(obj)
		{
			if(obj.value!="")
			{
				if(obj.value<1)
				{
					alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
					obj.select();
				}
			}
		}

		function allowNumOnly(event)
		{
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1)
				return false;  
			else
				return true ;			
		}


		function getQMSapplbl(){			
			var cliniccode=f_query_add_mod.document.getElementById("asn_locn_code").value;
			var temp=cliniccode.split("|");
		   cliniccode = temp[0];
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					 
					var param="&callfunc=QMSQuery&clinic_code="+cliniccode;

					var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=trimString(xmlHttp.responseText);
					var retVal=responseText
					f_query_add_mod.document.getElementById("qms_interfaced_yn").value=retVal;
					
		}

//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
async function UploadDocument()
{
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].l_encounter_id.value;

	var dialogHeight = "400px";
	var dialogWidth	= "700px";
	var status = "no";
	var arguments = "";
	var function_id = "UPLOAD_DOC";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll = auto; status:" + status;

	await window.showModalDialog('../../eMP/jsp/MPUploadDocument.jsp?function_id='+function_id+'&patient_id='+patient_id+'&encounter_id='+encounter_id,arguments,features);			
}

