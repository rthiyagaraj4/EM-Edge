async function funQry(locncode)

{
	
      if(document.forms[0].bl_install_yn.value=="Y")
	{
            var retVal;

            var dialogHeight= "50vh";

            var dialogWidth  = "50vh";

            var dialogTop = "";

            var center = "1" ;                                                                                                                                                                           

            var status="no";

            var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

            var arguments    = "" ;

            

            var clinic_code=locncode

          
			var visit_type_code=document.forms[0].curvisittypecode.value;
          
            var patient_id=document.forms[0].patientid.value

            var episode_type="O"

            var episode_id=document.forms[0].episode_id.value

            var visit_id=document.forms[0].episode_visit_num.value

            var encounter_id=document.forms[0].encounterid.value

            var facility_id=document.forms[0].fac_id.value
			
			/*
            var calling_module_id="";
			if(document.forms[0].module_id.value=="")
            calling_module_id="OP"
			else
			calling_module_id=document.forms[0].module_id.value
			*/
			var calling_module_id = "OP";

            var calling_function_id="ASSIGN_PRACTITIONER";

            var logged_user_id=document.forms[0].userid.value
				

            var practitioner_id=document.forms[0].pract_id.value

            var practitioner_type_ind="P"
			
 
// all these values are mandatory for our operation.Kindly pass appropriate values to the above variables

 //ae_bed_calYN=N this query string used for restriction of AEbed calculatio from billing

            var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_calYN=N&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind;     

 

 

            retVal = await window.showModalDialog(url,arguments,features);

 

            if(retVal=="1")

            {            return true;  

                        

            }

            else

            {           return false;

                        

            }

	}else
	{
	return true;
	}
}




async function apply()
{
	var locn = document.Qmgmt.LAssign1.value;
	var locn_code="";
	var pract_id = Qmgmt.pract_id.value;

	// Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013 Start
	var cl_code	= Qmgmt.curlocncode.value;
	var changed_clinic_code	= cl_code;
	var p_queue_date		= Qmgmt.p_queue_date.value;
	
	if(Qmgmt.LAssign1!=null){
		var cl_code_all					= Qmgmt.LAssign1.value;
		var cl_code_array				= cl_code_all.split("|");
		 changed_clinic_code			= cl_code_array[0];
	}
	var Sysdate	="";
	var action_on_pract_schedule	= "N";
	var exist_pract_id				= "";
	var is_prac_blocked 	= 0;
	
	if(Qmgmt.Sysdate!=null)
	 Sysdate				= Qmgmt.Sysdate.value;
	
	if(Qmgmt.action_on_pract_schedule!=null)
	 action_on_pract_schedule	= Qmgmt.action_on_pract_schedule.value;
	
	if(Qmgmt.exist_pract_id!=null)
	 exist_pract_id	= Qmgmt.exist_pract_id.value;
	// Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013 End
	
	if (locn != null)
		locn_code = locn.substring(0,locn.indexOf("|"));
	//QMS code
	var flag=true;
	await getQMSapplbl();
	var qms_interfaced_yn = document.forms[0].qms_interfaced_yn.value;
	var	assigned_q_no = document.forms[0].queue_no.value;
	if(qms_interfaced_yn == 'Y' && document.forms[0].qms_exception.value=='Y' && document.forms[0].isQMSapplicable.value=='false'){
		if(assigned_q_no== '' || assigned_q_no == 'null'){
			var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
			error = error.replace('$',getLabel('Common.QueueNo.label','Common'));
			flag=false;
			alert(error);
			//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
		}else{
			document.forms[0].queue_num.value=assigned_q_no;
			document.getElementById('chg_flag').value="Y";
		}
	}
	var cur_qms_interfaced_yn=document.forms[0].cur_qms_interfaced_yn.value;
	
	if((qms_interfaced_yn == 'Y' || cur_qms_interfaced_yn == 'Y') && document.forms[0].qms_exception.value=='N' && document.forms[0].isQMSapplicable.value=='false'){
					//var cliniccode=document.forms[0].locncode.value;
					var cliniccode=document.getElementById('LAssign1').value;
					var temp=cliniccode.split("|");
					cliniccode = temp[0];
					var roomnum=document.forms[0].room_numsel.value;
					var encounter_id = document.forms[0].encounterid.value;
					var p_pract_id = document.forms[0].pract_id.value;
					var p_locn_type = document.forms[0].locntype.value;
					var appt_walk_in = document.forms[0].appt_walk_ind.value;
					var queue_id = document.forms[0].queue_id.value;
					var queue_date = document.forms[0].p_queue_date.value;
					var other_res_code = document.forms[0].other_res_code.value;
					var other_res_type = document.forms[0].other_res_type.value;
					var queue_num = document.forms[0].queue_num.value;
					var patient_id = document.forms[0].patientid.value;
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
				}
				else if(que_id=='-2'){
					flag=false;
					var errors=getMessage('QUEUE_NUM_CTRL_NOT_DEFINED','OP');					
					alert(errors);
				}else if (que_id=='0')
				{
					document.forms[0].queue_num.value=count;
					document.forms[0].queue_id.value="";
					document.getElementById('chg_flag').value="Y";
				}else{
					if(count == '-1' || count == null){	
						flag=false;
						var div1=document.getElementById("queue_div");
						var div2=document.getElementById("queue_no_div");
						if (div1 != null )
						{	
							div1.style.display="block";
							div2.style.display="block";
						}
		
						document.getElementById("queue_div").style.visibility="visible";
						document.getElementById("queue_no_div").style.visibility="visible";
						document.forms[0].qms_exception.value='Y';	
						var error = getMessage('EXT_QUEUE_NO_CONTACT','OP');
						alert(error);
				}else{					
					document.forms[0].queue_num.value=count;
					document.forms[0].queue_id.value=que_id;
					document.getElementById('chg_flag').value="Y";
				}
				}	
		}
if(flag == true){
	if(document.forms[0].multi_speciality_yn.value=='Y'){
		document.forms[0].LAssign1.disabled=false;
		//code for validating secondary resource - 198
		var secList=document.forms[0].sec_res_lst.value;
		var secListArr=secList.split("$");

		if(secListArr.length<=2){
			flag=false;
			var msg=getMessage("ATLEAST_TWO_SEC_RES","OA");
			alert(msg);
		}
	}
}
if(flag==true){
	if((document.forms[0].curlocncode.value != locn_code) || (document.forms[0].curpractid.value != pract_id))
	{
		
		if(document.forms[0].pmode.value == 'R' && document.forms[0].visitcase.value == 'A' && document.forms[0].pract_id.value!="")
		{
			var IDENT_AT_CHECKIN=document.forms[0].IDENT_AT_CHECKIN.value;
			
			var ALLOW_WALK_IN_YN=document.forms[0].ALLOW_WALK_IN_YN.value;

			if( !(ALLOW_WALK_IN_YN == 'N')  &&  !(IDENT_AT_CHECKIN == 'X') ) 
			{		
				if(confirm(getMessage("APPT_CASE_DELINK","OP")))
				{
					document.forms[0].unlinkapptcaseyn.value = 'Y' ;
				}
			}
				
			if(blankchk())
				{
					
					// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 Start
					if(p_queue_date==Sysdate && pract_id!='' && action_on_pract_schedule!='N' && (exist_pract_id!=pract_id || cl_code!=changed_clinic_code)){
						await FNCheckBlockScheduleForPract(p_queue_date,pract_id,'','','assign_reassign',changed_clinic_code);
						is_prac_blocked	= document.forms[0].is_prac_blocked.value;
						var block_time	=  document.forms[0].Systime.value;
						
						if(is_prac_blocked){
							if(action_on_pract_schedule=="S"){
								var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT","OP");
								err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
								alert(err_msg);
								return false;
							}else if(action_on_pract_schedule=="W"){
								var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT_WARNING","OP");
								err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
								if(confirm(err_msg)){
								}else{
									return false;
								}
							}
						}
					}
					// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 End
				
					if(document.forms[0].room_num.value == "NoRoom")
					{
					document.forms[0].room_num.value = "";
					}
					var roomnum=document.forms[0].room_num.value;
					var appt_id=document.forms[0].appt_ref_no.value;
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poproom' id='poproom' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+locn_code+"'><input type='hidden' name='room_num' id='room_num' value='"+roomnum+"' ><input type='hidden' name='assigned_q_no' id='assigned_q_no' value='"+assigned_q_no+"'><input type='hidden' name='objval' id='objval' value='room_numsel'><input type='hidden' name='callfunc' id='callfunc' value='Assign'><input type='hidden' name='pract_id' id='pract_id' value='"+pract_id+"'><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'></form></body></html>";
						
					
					var check = await funQry(locn_code)	
					if(check){
						parent.dummyfr.document.insertAdjacentHTML('afterbegin',HTMLVal);
					
						parent.dummyfr.poproom.submit();
							if(document.forms[0].menuId.value == "CA"){
				var form = parent.frames[1].document.forms[0];
				// Serialize form data into a URL-encoded string
				var formData = '';
				for (var i = 0; i < form.elements.length; i++) {
				    var element = form.elements[i];
				    if (element.name) {
				        formData += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value) + '&';
				    }
				}
				// Create a new XMLHttpRequest object
				var xhr = new XMLHttpRequest();
				// Configure the request
				xhr.open('POST', '../../servlet/eOP.QmgmtRe_AssignPractServlet?&'+formData);
				// Set up event listener to handle response
				xhr.onreadystatechange = function() {
				    if (xhr.readyState == 4 && xhr.status == 200) {
				        // Request was successful, do something with the response
				        var res = xhr.responseText;
						if (res.indexOf("APP-SM0071 Operation Completed Successfully ....") > -1){
						alert(getMessage("RECORD_MODIFIED",'SM'));
						}
						var HTMLVal  = "<html>";
						HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
						HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + document.forms[0].encounterid.value + "'>";
						HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" +  document.forms[0].patientid.value + "'>";
						HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='OP'>";
						HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
						HTMLVal  += "<input type='hidden' name='CAReassignflag' id='CAReassignflag' value='Reassign'>";
						HTMLVal  += "</form>";
						HTMLVal  += "</html>";
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
						top.content.messageFrame.document.OpenChartWrapperForm.submit();
				    } 
				};
				/*// Set up event listener to handle errors
				xhr.onerror = function() {
				    console.error('Request failed');
				};*/
				// Send the request with form data
				xhr.send();
				}
			
					}else{
						return false
					}
				}
			}
			else
			{
			
			if(blankchk())
			{
				// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 Start
				if(p_queue_date==Sysdate && pract_id!='' && action_on_pract_schedule!='N'  && (exist_pract_id!=pract_id || cl_code!=changed_clinic_code)){
					await FNCheckBlockScheduleForPract(p_queue_date,pract_id,'','','assign_reassign',changed_clinic_code);
					is_prac_blocked	= document.forms[0].is_prac_blocked.value;
					var block_time	=  document.forms[0].Systime.value;
					
					if(is_prac_blocked){
						if(action_on_pract_schedule=="S"){
							var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT","OP");
							err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
							alert(err_msg);
							return false;
						}else if(action_on_pract_schedule=="W"){
							var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT_WARNING","OP");
							err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
							if(confirm(err_msg)){
							}else{
								return false;
							}
						}
					}
				}
				// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 End
				if(document.forms[0].room_num.value == "NoRoom"){
					var check = await funQry(locn_code)	
					if(check)
					{
					document.forms[0].submit();
				    }else
					{
					return false
					}
				}else{
					var roomnum=document.forms[0].room_num.value;
					var appt_id=document.forms[0].appt_ref_no.value;
			
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poproom' id='poproom' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+locn_code+"'><input type='hidden' name='room_num' id='room_num' value='"+roomnum+"' ><input type='hidden' name='assigned_q_no' id='assigned_q_no' value='"+assigned_q_no+"'><input type='hidden' name='objval' id='objval' value='room_numsel'><input type='hidden' name='callfunc' id='callfunc' value='Assign'><input type='hidden' name='pract_id' id='pract_id' value='"+pract_id+"'><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'></form></body></html>";
				//	parent.dummyfr.document.write(HTMLVal);	
					var check = await funQry(locn_code)	
					if(check){
						parent.dummyfr.document.insertAdjacentHTML('afterbegin',HTMLVal);
						
						parent.dummyfr.poproom.submit();
						if(document.forms[0].menuId.value == "CA"){
				var form = parent.frames[1].document.forms[0];
				// Serialize form data into a URL-encoded string
				var formData = '';
				for (var i = 0; i < form.elements.length; i++) {
				    var element = form.elements[i];
				    if (element.name) {
				        formData += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value) + '&';
				    }
				}
				// Create a new XMLHttpRequest object
				var xhr = new XMLHttpRequest();
				// Configure the request
				xhr.open('POST', '../../servlet/eOP.QmgmtRe_AssignPractServlet?&'+formData);
				// Set up event listener to handle response
				xhr.onreadystatechange = function() {
				    if (xhr.readyState == 4 && xhr.status == 200) {
				        // Request was successful, do something with the response
				        var res = xhr.responseText;
						if (res.indexOf("APP-SM0071 Operation Completed Successfully ....") > -1){
						alert(getMessage("RECORD_MODIFIED",'SM'));
						}
						var HTMLVal  = "<html>";
						HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
						HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + document.forms[0].encounterid.value + "'>";
						HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" +  document.forms[0].patientid.value + "'>";
						HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='OP'>";
						HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
						HTMLVal  += "<input type='hidden' name='CAReassignflag' id='CAReassignflag' value='Reassign'>";
						HTMLVal  += "</form>";
						HTMLVal  += "</html>";
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
						top.content.messageFrame.document.OpenChartWrapperForm.submit();
				    } 
				};
				/*// Set up event listener to handle errors
				xhr.onerror = function() {
				    console.error('Request failed');
				};*/
				// Send the request with form data
				xhr.send();
				}
					}else{
						return false
					}
				}
			}
		}
	}
	else
	{		
		if(blankchk())
		{
			// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 Start
			if(p_queue_date==Sysdate && pract_id!='' && action_on_pract_schedule!='N'  && (exist_pract_id!=pract_id || cl_code!=changed_clinic_code)){
				await FNCheckBlockScheduleForPract(p_queue_date,pract_id,'','','assign_reassign',changed_clinic_code);
				is_prac_blocked	= document.forms[0].is_prac_blocked.value;
				var block_time	=  document.forms[0].Systime.value;
				if(is_prac_blocked){
					if(action_on_pract_schedule=="S"){
						var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT","OP");
						err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
						alert(err_msg);
						return false;
					}else if(action_on_pract_schedule=="W"){
						var err_msg	= getMessage("BLOCK_SCH_FOR_PRACT_WARNING","OP");
						err_msg		= err_msg.replace("#",p_queue_date +" "+block_time);
						if(confirm(err_msg)){
						
						
						}else{
							return false;
						}
					}
				}
			}
			// Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 End
			if(document.forms[0].room_num.value == "NoRoom")
			{
			document.forms[0].room_num.value = "";
			}
			var roomnum=document.forms[0].room_num.value;
			var appt_id=document.forms[0].appt_ref_no.value;
			
			var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poproom' id='poproom' method='post' target='dummyfr' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+locn_code+"'><input type='hidden' name='room_num' id='room_num' value='"+roomnum+"' ><input type='hidden' name='assigned_q_no' id='assigned_q_no' value='"+assigned_q_no+"'><input type='hidden' name='objval' id='objval' value='room_numsel'><input type='hidden' name='callfunc' id='callfunc' value='Assign'><input type='hidden' name='pract_id' id='pract_id' value='"+pract_id+"'><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'></form></body></html>";

			var check = await funQry(locn_code)	
			if(check){
				
			if(funQry(locn_code)){
				parent.dummyfr.document.write(HTMLVal);
				parent.dummyfr.poproom.submit();
				if(document.forms[0].menuId.value == "CA"){
				var form = parent.frames[1].document.forms[0];
				// Serialize form data into a URL-encoded string
				var formData = '';
				for (var i = 0; i < form.elements.length; i++) {
				    var element = form.elements[i];
				    if (element.name) {
				        formData += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value) + '&';
				    }
				}
				// Create a new XMLHttpRequest object
				var xhr = new XMLHttpRequest();
				// Configure the request
				xhr.open('POST', '../../servlet/eOP.QmgmtRe_AssignPractServlet?&'+formData);
				// Set up event listener to handle response
				xhr.onreadystatechange = function() {
				    if (xhr.readyState == 4 && xhr.status == 200) {
				        // Request was successful, do something with the response
				        var res = xhr.responseText;
						if (res.indexOf("APP-SM0071 Operation Completed Successfully ....") > -1){
						alert(getMessage("RECORD_MODIFIED",'SM'));
						}
						var HTMLVal  = "<html>";
						HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
						HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + document.forms[0].encounterid.value + "'>";
						HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" +  document.forms[0].patientid.value + "'>";
						HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='OP'>";
						HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
						HTMLVal  += "<input type='hidden' name='CAReassignflag' id='CAReassignflag' value='Reassign'>";
						HTMLVal  += "</form>";
						HTMLVal  += "</html>";
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
						top.content.messageFrame.document.OpenChartWrapperForm.submit();
				    } 
				};
				/*// Set up event listener to handle errors
				xhr.onerror = function() {
				    console.error('Request failed');
				};*/
				// Send the request with form data
				xhr.send();
				}
		    }else{
				return false
			}
		}
	}
}
}


function blankchk()
{
	var error = "";
	var erval="";
	if(document.forms[0].room_num.value != "NoRoom")
	{
		
		if(document.forms[0].room_num.value =='')
		{
			erval	=getMessage('CAN_NOT_BE_BLANK','COMMON');
			error += erval.replace('$',getLabel('Common.roomno.label','Common'));
			error += "\n";
		}
	}
	
	if(document.forms[0].pract_id.value == ''||document.forms[0].pract_id.value == '*ALL')
	{
		erval = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error += erval.replace('$',getLabel('Common.practitioner.label','Common'));
			error += "\n";
	}
				
	if(error != "")
	{
		alert(error);
		return false
	}
	else
	{
		return true;
	}
}



function exitContact()
{
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "ok";   
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); ;
}


function PopulatePractList()
{
	var p_pract_id	= Qmgmt.pract_id;
	var  HTMLVal = new String();
	var locn = document.Qmgmt.LAssign1.value;
	var arrvals=locn.split("|");

	if (locn != null)
	{
		locn_code 	= arrvals[0];
		locn_type 	= arrvals[1];
		locn_type_code 	= arrvals[2];

	}
	self.document.getElementById('LAssign2').innerText=locn_type;
}

/*function PopulateVisitList()
{
	var visit_assign = Qmgmt.VAssign;
	var  HTMLVal = new String();

	var p_patient_id=parent.frames[1].document.forms[0].patientid.value;

	clear_list(parent.frames[1].document.forms[0].VAssign);

	var p_cur_visit_type_code	= Qmgmt.curvisittypecode.value;

	var pract_id			= Qmgmt.pract_id.value;
	var pract_type_assign		= "";
	var clinic_code			= "";

	self.document.getElementById('practtype').innerText=pract_type_assign;

	clinic_code = Qmgmt.LAssign1.value;
	if (clinic_code != null)
		clinic_code = clinic_code.substring(0,clinic_code.indexOf("|"));

	
	if (pract_id != null && pract_id != "")
	{
		HTMLVal = "<html><body><form name='tempq' id='tempq' method='post' action='../../eOP/jsp/TempQmgmtPract.jsp'><input type='hidden' name='step' id='step' value='2'><input type='hidden' name='p_pract_id' id='p_pract_id' value='"+pract_id+"'><input type='hidden' name='p_cur_visit_type_code' id='p_cur_visit_type_code' value='"+p_cur_visit_type_code+"'><input type='hidden' name='p_clinic_code' id='p_clinic_code' value='"+clinic_code+"'><input type='hidden' name='p_patient_id' id='p_patient_id' value='"+p_patient_id+"'></form></body></html>";
		
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.tempq.submit();

	}
	else
	{
		var opt = parent.parent.frames[1].document.createElement('OPTION');
		opt.text = '-------- Select --------';
		opt.value= '';

		parent.frames[1].document.forms[0].VAssign.add(opt);
	}
}*/

/*function clear_list(obj)
{
	if(obj.name != "pract_id")
	{
	while ( obj.options.length > 0 )
		obj.remove(obj.options[0]);
	}

	if (obj.name == "pract_id")
	{
		clear_list(parent.parent.frames[1].document.forms[0].VAssign);
		parent.parent.frames[1].document.getElementById('practtype').innerText="";
	}
}
*/
//JS functions in QMGMT Assign pract.jsp

function Chkval(Obj,e,yy){
	if(e.keyCode=='13')
		return false;
}

function chgvalue(obj)
	{
		
		if(obj.name=="service_code")
		{
			document.getElementById('service_code_h').value=document.getElementById('service_code').options(document.getElementById('service_code').options.selectedIndex).value;
			
		}
		else if(obj.name=="sub_service_code")
		{
			document.getElementById('sub_service_code_h').value=document.getElementById('sub_service_code').options(document.getElementById('sub_service_code').options.selectedIndex).value;
			
		}
		else if(obj.name=="room_numsel")
		{
			document.getElementById("room_num").value=document.getElementById('room_numsel').options(document.getElementById('room_numsel').options.selectedIndex).value;
			document.getElementById('room_change').value=document.getElementById("room_num").value;
			document.getElementById('chg_flag').value="Y";
			
		}

	}

function onBlurCallPractitionerSearch(obj,target_name)
		{
		
		 target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			 document.forms[0].pract_name.value="";
			 document.forms[0].pract_id.value="";
		     document.getElementById('practtype').innerHTML="";
			 return;
			}
			callPractSearch(obj,target_name);
   	    }


function callPractSearch(obj,target)
		{
		
		/*var practName_FName="";
		var practName_FValue="";
		var practId_FName="";*/
		var facilityid = document.forms[0].fac_id.value;
		var locn_code=document.getElementById('LAssign1').value;
		var locale=document.forms[0].locale.value;
		var visit_type_code=document.forms[0].curvisittypecode.value;

		//Speciality added by smita on 09/03/04 to pass on to the GeneralPractsearch

		 var locnvals=new Array();
		 locnvals=locn_code.split("|");	
 
		var cur_locn_code=locnvals[0];
		var cur_speciality_code=locnvals[3];
		var open_to_all_pract_yn=locnvals[4];
		var cur_pract_type=locnvals[5];
		
		if(cur_pract_type == "?") cur_pract_type="";		
		
		/*target.value=trimString(target.value);
		practName_FName=target.name;
		practName_FValue=target.value;*/
	
		//var sql="";
		//var sqlsec="";
		
		//do not forget to give aliases as mentioned below	

		if(open_to_all_pract_yn=="Y")
		{	
			//getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','','','',"Q8");

			getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','','','',"Q4");
		/*

		//sql="SELECT   d.practitioner_id  practitioner_id, d.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG','Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM OP_REGISTER_VISIT_PRACT_VW d,am_practitioner a, am_pract_type b,am_speciality c, OP_CLINIC e WHERE a.pract_type=b.pract_type AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND c.speciality_code = e.speciality_code and  d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE LIKE (?)  OR a.job_title IS NULL) AND d.facility_id='"+facilityid+"' AND  d.clinic_code= '"+cur_locn_code+"'";

		sql="SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name  ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1)  practitioner_type, am_get_desc.am_speciality(e.speciality_code,'"+locale+"',2)primary_specialty , DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d ,am_practitioner_lang_vw a , OP_CLINIC e WHERE a.language_id='"+locale+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id   AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND d.facility_id='"+facilityid+"' AND d.clinic_code= '"+cur_locn_code+"'";
		


		//sqlsec ="SELECT   d.practitioner_id  practitioner_id, d.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG','Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM OP_REGISTER_VISIT_PRACT_VW d,am_practitioner a, am_pract_type b,am_speciality c, op_clinic e WHERE a.pract_type=b.pract_type AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code and c.speciality_code = e.speciality_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE LIKE (?)  OR a.job_title IS NULL) AND d.facility_id='"+facilityid+"' AND  d.clinic_code= '"+cur_locn_code+"'";

		sqlsec="SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name  ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1)  practitioner_type, am_get_desc.am_speciality(e.speciality_code,'"+locale+"',2)primary_specialty , DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d ,am_practitioner_lang_vw a , OP_CLINIC e WHERE a.language_id='"+locale+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id   AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND d.facility_id='"+facilityid+"' AND d.clinic_code= '"+cur_locn_code+"'";

		*/
		}
		else
		{
			//getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','',cur_pract_type,'',"Q9");
			getPractitioner(obj,target,facilityid,cur_speciality_code,'',cur_locn_code,'','',cur_pract_type,visit_type_code,"Q3");	

		//op clinic specialty to match the specialty with am_speciality instead of am_practitioner.primary_speciality_code 
		//in where clause where we match with speciality code with place holder there primary specialty should be replaced with op_clinic's specialty

		/*sql="SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, op_pract_for_clinic e,op_clinic f WHERE a.pract_type=b.pract_type AND f.speciality_code=c.speciality_code and e.clinic_code=f.clinic_code AND a.pract_type LIKE (?)  AND f.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.JOB_TITLE LIKE (?) OR a.job_title IS NULL) AND e.practitioner_id = a.practitioner_id AND e.clinic_code = '"+cur_locn_code+"' ";

		if(cur_pract_type != "R")
		{
			//sql += "AND NVL(a.pract_type,'X') = NVL('"+cur_pract_type+"',NVL(a.pract_type,'X'))";
			sql += "AND NVL(a.pract_type,'X') = NVL('"+cur_pract_type+"',NVL(a.pract_type,'X'))";



		}
		sql +=" AND e.facility_id = '"+facilityid+"' ";*/

	    //Commented for generalise Pract Look Up by Marimuthu

		/*sql="  SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1) practitioner_type,am_get_desc.AM_SPECIALITY(f.speciality_code,'"+locale+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.position_code job_title FROM  am_practitioner_lang_vw a,op_pract_for_clinic e ,op_clinic f WHERE language_id='"+locale+"' AND e.clinic_code=f.clinic_code AND a.pract_type LIKE (?) AND f.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND  (a.position_code LIKE (?) OR a.position_code IS NULL) AND e.practitioner_id = a.practitioner_id AND e.clinic_code = '"+cur_locn_code+"' ";


		if(cur_pract_type != "R")
		{
			sql += "AND NVL(a.pract_type,'X') = NVL('"+trimString(cur_pract_type)+"',NVL(a.pract_type,'X'))";
		}
		sql +=" AND e.facility_id = '"+facilityid+"' ";*/
		
		/*sqlsec="SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, op_pract_for_clinic e,op_clinic f 
		WHERE a.pract_type=b.pract_type AND f.speciality_code=c.speciality_code and e.clinic_code=f.clinic_code AND a.pract_type LIKE (?)  AND f.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND (a.JOB_TITLE LIKE (?) OR a.job_title IS NULL) AND e.practitioner_id = a.practitioner_id AND e.clinic_code = '"+cur_locn_code+"' ";
		if(cur_pract_type != "R")
		{
			sqlsec += "AND NVL(a.pract_type,'X') = NVL('"+cur_pract_type+"',NVL(a.pract_type,'X'))";
		}
		sqlsec +=" AND e.facility_id = '"+facilityid+"' ";
	
	    }*/

		//Commented for generalise Pract Look Up by Marimuthu

		/*
		sqlsec="  SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name  ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1) practitioner_type, am_get_desc.AM_SPECIALITY(f.speciality_code,'"+locale+"',2) primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,a.position_code job_title FROM  am_practitioner_lang_vw a,op_pract_for_clinic e ,op_clinic f WHERE language_id='"+locale+"' AND e.clinic_code=f.clinic_code AND a.pract_type LIKE (?) AND f.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND  (a.position_code LIKE (?) OR a.position_code IS NULL) AND e.practitioner_id = a.practitioner_id AND e.clinic_code = '"+cur_locn_code+"' ";
		if(cur_pract_type != "R")
		{
			sqlsec += "AND NVL(a.pract_type,'X') = NVL('"+trimString(cur_pract_type)+"',NVL(a.pract_type,'X'))";
		}
		sqlsec +=" AND e.facility_id = '"+facilityid+"' ";	
	    } 
		*/
		}
		
		
	/*
	* if you are passing User Defined SQL and in that if you want to pass any of the folowing in where criteria  :-
	*	1.  practioner type
	*   2. Speciality /Clinic code
	*   3. Job Title
	*   4. Gender
	*
	* then you must pass them in the query string below with folowing names
	*	1.  practioner type               ----->practitioner_type
	*   2. Speciality /Clinic code    ----->specialty_code
	*   3. Job Title							----->job_title
	*   4. Gender							----->gender
	*
	*
	*/
	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + encodeURIComponent(practName_FName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +encodeURIComponent(sql)+"\"";
	xmlStr += " sqlSec=\"" +encodeURIComponent(sqlsec)+"\"";
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
	eval(responseText);	*/
	
	}
	
	
function PractLookupRetVal(retVal,objName)
	{
		var arr;
		if (retVal != null)
		{
		arr=retVal.split("~");
	
		document.forms[0].pract_id.value=arr[0];
		document.forms[0].pract_name.value=arr[1];
		//document.forms[0].p_pract_type.value=arr[6];
		document.getElementById('chg_flag').value="Y";
		
		}else{
			document.forms[0].pract_id.value="";
			document.forms[0].pract_name.value="";			
			//document.forms[0].p_pract_type.value="";
	
		}		
	
    }

function Changeobj(obj)
{
	var obj_value       = obj.value;
    var obj_name        = obj.name;
	var p_patient_id=document.forms[0].patientid.value;
	var pServsCd = document.forms[0].service_code_h_new.value;
	var old_locn_code= document.forms[0].locncode.value;

	if (obj_value != null && obj_value != "")
    {
		parent.frames[2].document.open();
		if(obj_name == "LAssign1")
		{
			var arrval = obj_value.split("|");
			var locncode = arrval[0];
			
			ClearList(document.forms[0].room_numsel);
			document.forms[0].room_num.value="";
						
			document.forms[0].pract_id.value="";
			document.forms[0].pract_name.value="";
		
			document.getElementById('chg_flag').value="Y";
			parent.frames[2].location.href = "../../eOP/jsp/TempQmgmtPract.jsp?step=1&list_name111="+obj_name+"&"+obj_name+"="+locncode+"&p_service_code="+pServsCd;;
		}	
	}
}

function ClearList(object)
{
 	var list1   = "";
    var length  ="";
    var element = parent.frames[1].document.forms[0].document.createElement('OPTION');
    var obj = object.name;
    element.text= "------"+getLabel("Common.defaultSelect.label",'Common')+"------";
    element.value="";
	if (object)
	var length  =object.length;
	var element = parent.frames[1].document.forms[0].document.createElement('OPTION');
	element.text= "------"+getLabel("Common.defaultSelect.label",'Common')+"------";
	element.value="";
      for(i=1;i<length;i++)
         object.remove(1);
}

async function otherResourceLookUp(obj,target)
{
	var clinic_code = Qmgmt.LAssign1.value;
	if (clinic_code != null)
		clinic_code = clinic_code.substring(0,clinic_code.indexOf("|"));

	var other_resType=document.forms[0].other_res_type.value;
	var facilityId=document.forms[0].fac_id.value;
	var locale = document.forms[0].locale.value;
			
	if(other_resType != '')
	{
	//var sql="select PRACTITIONER_ID code,PRACTITIONER_SHORT_NAME description from op_pract_for_clinic_vw where facility_id='"+facilityId+"'  and resource_class='"+other_resType+"' and clinic_code='"+clinic_code+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_SHORT_NAME) like upper(?) order by PRACTITIONER_SHORT_NAME ";



	var sql="SELECT PRACTITIONER_ID code, DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),		 'O',AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description    FROM op_pract_for_clinic WHERE facility_id='"+facilityId+"'  AND resource_class='"+other_resType+"' AND clinic_code='"+clinic_code+"' AND  UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND(UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) LIKE UPPER(?) OR  UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) IS NULL) ORDER BY 2";
	
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

		document.getElementById('chg_flag').value="Y";
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
   document.getElementById('chg_flag').value="Y";
  
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
			var cliniccode=document.getElementById('LAssign1').value;
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
					document.forms[0].qms_interfaced_yn.value=retVal;
					
		}
		
		

		async function callSecondaryResource(clinic_code,appt_id,practList,calledFrom){
			if(practList=='' || practList==undefined || practList=='null'){
			var dialogTop	= "";
			var dialogHeight= "33vh" ;
			var dialogWidth = "40vw" ;
			var status = "no";
			var scroll = "no";
			var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var arguments   = "" ;
			var dislpayed_practList=document.forms[0].sec_res_lst.value;
			if(document.forms[0].curpractid){
			var curpractid=document.forms[0].curpractid.value;
						
			practList=await window.showModalDialog("../jsp/SecResourcesFromAppt.jsp?clinic_code="+clinic_code+"&appt_id="+appt_id+"&practList="+dislpayed_practList+"&curpractid="+curpractid,arguments,features);
			
			}
			}

			//if(practList!=''){
			var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='SecResource'><input type='hidden' name='practs' id='practs' value="+practList+"><input type='hidden' name='clinic_code' id='clinic_code' value="+clinic_code+"></form></body></html>";		

			parent.dummyfr.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.dummyfr.document.popordercatalog.submit();
			//}

		}
		
		function valtext(){
			var excludePract=parent.criteria_frame.document.forms[0].excludePract.value;
			var practCount=parent.criteria_frame.document.forms[0].practCount.value;
			var clinic_code=parent.criteria_frame.document.forms[0].clinic_code.value;
			var appt_id=parent.criteria_frame.document.forms[0].appt_id.value;
			var practList=parent.criteria_frame.document.forms[0].practList.value;
			var curpractid=parent.criteria_frame.document.forms[0].curpractid.value;

			var url="../../eOP/jsp/SecResResult.jsp?search_by="+parent.criteria_frame.document.CriteriaForm.radioval.value+"&search_text="+encodeURIComponent(parent.criteria_frame.document.CriteriaForm.search_text.value)+"&searchcriteria="+parent.criteria_frame.document.CriteriaForm.searchcriteria.value+"&clinic_code="+clinic_code+"&appt_id="+appt_id+"&practList="+practList+"&curpractid="+curpractid;
			var buttonUrl="../jsp/SecResButtons.jsp?";

			parent.contents_frame.document.location.href=url;
			parent.buttons_frame.document.location.href=buttonUrl;
			
			
		}

		function addSelectedIns(obj,index){
			var selectedPract=parent.contents_frame.document.forms[0].selectedPract.value;
			var Prac_count=parseInt(parent.contents_frame.document.forms[0].Prac_count.value);	
			
			if (obj.checked==true)
				{
				Prac_count=Prac_count+1;
				selectedPract=selectedPract+eval('parent.contents_frame.document.forms[0].practCode'+index).value+"$";														
				}else{
					var subString=eval('parent.contents_frame.document.forms[0].practCode'+index).value;
					if(selectedPract.indexOf(subString) != -1){
						selectedPract=selectedPract.split(subString+"$").join("");
							if(Prac_count > 0)
								Prac_count=Prac_count-1;
					}
				}					
				parent.contents_frame.document.forms[0].selectedPract.value=selectedPract;
				parent.contents_frame.document.forms[0].Prac_count.value=Prac_count;				
		}

		function addCheckedPracts(){
			var Prac_count=parent.contents_frame.document.forms[0].Prac_count.value;
			
			var addedPractCode="";
			addedPractCode=parent.contents_frame.document.forms[0].selectedPract.value;

			/*if(Prac_count<2){
				var msg=getMessage("ATLEAST_TWO_SEC_RES","OA");
				alert(msg);
				
			}else{*/
				addedPractCode = addedPractCode.substring(0,addedPractCode.length-1)
			parent.contents_frame.document.forms[0].selectedPract1.value=parent.contents_frame.document.forms[0].selectedPract.value;	
			parent.contents_frame.document.forms[0].calledFromOK.value='Y';	
			window.returnValue=addedPractCode;
			window.close();
			//}
		}
		
		function cancelCheckedPracts(){
			var addedPractCode="";			
			//Added the following condition for the incident 44143
			if(parent.contents_frame && parent.contents_frame.document.forms[0] && parent.contents_frame.document.forms[0].selectedPract1){
			if(parent.contents_frame.document.forms[0].calledFromOK.value==''){
				if(parent.contents_frame.document.forms[0].selectedPract1.value!=parent.contents_frame.document.forms[0].selectedPract.value)
					addedPractCode=parent.contents_frame.document.forms[0].selectedPract1.value;
				else
					addedPractCode=parent.contents_frame.document.forms[0].selectedPract.value;
				//Following if condition added for the incident 44151
				if(parent.contents_frame.document.forms[0].selectedPract.value=='' && parent.contents_frame.document.forms[0].selectedPract1.value=='')
					addedPractCode=parent.criteria_frame.document.forms[0].practList.value;
				}else{
					addedPractCode=parent.contents_frame.document.forms[0].selectedPract.value;
					//addedPractCode = addedPractCode.substring(0,addedPractCode.length-1)
				}
			}else{
				addedPractCode=parent.criteria_frame.document.forms[0].practList.value;
			}
			
		
			window.returnValue=addedPractCode;
			window.close();
		}
		
		function allow_nochars( val ) {

			var text_val=val.value;
			if(text_val.indexOf("#") !=-1)
			{
				 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
				val.value="";
			}
		}
		
		function checkCriteria(obj){
			parent.criteria_frame.document.CriteriaForm.searchcriteria.value=obj.value;
		}
		
		function storeVal1(){
			if(parent.criteria_frame.document.CriteriaForm.search_by_code.checked==true){
				parent.criteria_frame.document.CriteriaForm.search_by_desc.checked=false;
				parent.criteria_frame.document.CriteriaForm.radioval.value="C";
			}
		}

		function storeVal2(){
			if(parent.criteria_frame.document.CriteriaForm.search_by_desc.checked==true){
				parent.criteria_frame.document.CriteriaForm.search_by_code.checked=false;
				parent.criteria_frame.document.CriteriaForm.radioval.value="D";
			}
		}

//Added the function for the incident 44151	
function resetForm(formObj){
	formObj.reset();
    parent.contents_frame.document.location.href= "../../eCommon/html/blank.html";
    parent.buttons_frame.document.location.href= "../../eCommon/html/blank.html";
}

