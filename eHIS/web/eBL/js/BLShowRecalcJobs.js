async function runJob(reqId){
	parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/process.jsp';
	var newReqId = '0';
	$.ajax({
		type:"GET",
		url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
		data:"func_mode=reRunReCalcJob",
		dataType:"text",
		async:false,
		success: function(data){
			newReqId = $.trim(data);
			
		},
		 error: function(data){
			 newReqId = '0';
	      }
	});

	var cnt = 1;
	var status = 'I';
	if(newReqId>0){
		
		if(newReqId == reqId){
			status = checkProgress(newReqId);
			if(status == 'C'){
				msg=getMessage("RECORD_INSERTED","SM");
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.BLShowJobsFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
			}
			else if(status == 'F'){
				msg='Recalculation Job Failed';
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				//parent.parent.BLShowJobsFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
			}
			else{
				var intr = setInterval(function chkProg(){
					cnt++;
					status = checkProgress(newReqId);
					if(status == 'C'){
						clearInterval(intr);
						msg=getMessage("RECORD_INSERTED","SM");
						alert(msg);
						parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
						parent.parent.BLShowJobsFrame.location.reload();
						parent.parent.commontoolbarFrame.location.reload();
					}
					else if(status == 'F'){
						clearInterval(intr);
						msg='Recalculation Job Failed';
						alert(msg);
						parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
						//parent.parent.BLShowJobsFrame.location.reload();
						parent.parent.commontoolbarFrame.location.reload();
					}
					else if(cnt == 5){
						clearInterval(intr);
						var dialogHeight= "14" ;
						var dialogWidth	= "32" ;
						var dialogTop = "225" ;
						var center = "1" ;														   
						var status="no";
						var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "" ;	
						//var modPatientId = document.getElementById("hiddenPatientId").value;
						retVal =await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?reqId="+reqId,arguments,features); 
						msg=getMessage("RECORD_INSERTED","SM");
						alert(msg);
						parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
						parent.parent.BLShowJobsFrame.location.reload();
						parent.parent.commontoolbarFrame.location.reload();
					}
					
					
					
				}, 3000);
			}
		}
		else{
			var dialogHeight= "17" ;
			var dialogWidth	= "37" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			//var modPatientId = document.getElementById("hiddenPatientId").value;
			retVal =await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?closeDisable=Y&reqId="+newReqId,arguments,features); 
			if(retVal != 'Y' && retVal != 'F'){
				var msg = 'Cannot save changes, while financial calculation in progress';
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				//parent.parent.BLShowJobsFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
				return;
			}
			var msg = 'Cannot save changes, while financial calculation in progress';
			alert(msg);
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
			//parent.parent.BLShowJobsFrame.location.reload();
			parent.parent.commontoolbarFrame.location.reload();
			return;
		}
				
	}
	else{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=Error in Running the Job. Please try again';	
		//parent.parent.BLShowJobsFrame.location.reload();
		parent.parent.commontoolbarFrame.location.reload();
	}
}

function checkProgress(reqId){
	var progress = 'I';
	$.ajax({
		type:"GET",
		url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
		data:"func_mode=getProgressStatus",
		dataType:"text",
		async:false,
		success: function(data){
			progress = $.trim(data);
			
		},
		 error: function(data){
			 progress = 'I';
	      }
	});
	return progress;
}

function callPatValidation(obj)
{
	var frm = document.forms[0];
	var patient_id=obj.value;	
	if(patient_id!=""){
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="+patient_id;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);		
	if(responseText=="N")
	{
		alert(getMessage("INVALID_PATIENT","MP"));
		obj.select();		
	}else if(responseText=="Y"){

	}
	
	}
}

function defaultEncounter(obj){
	var patId = document.forms[0].patient_id.value;
	var patClass = document.forms[0].episode_type.value;
	var facilityId = document.forms[0].facilityId.value;
	//if(document.forms[0].hdnEpisode_id.value < 1){
	if(obj == 'patId'){
		if(patId.length>0 && patClass.length>0){
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
				//alert(responseText)
				if(responseText != 'N' && responseText.length>0){
					var retArr = responseText.split(":::");
					document.forms[0].episode_id.value = retArr[0];					
				}
				else{
					document.forms[0].episode_id.value = '';
				}
		}
	}
	else if(obj == 'epsdType'){
		if(patId.length>0 && patClass.length>0){
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;						
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);
			//alert(responseText)
			if(responseText != 'N' && responseText.length>0){
				var retArr = responseText.split(":::");
				document.forms[0].episode_id.value = retArr[0];
			}
			else{
				document.forms[0].episode_id.value = '';
			}
		}
	}
	//}
}

async function PatientIdLookup()
{	
			var pat_id=await PatientSearch();		
			var frm = document.forms[0];
			if( pat_id != null ){
				document.getElementById('patient_id').value = pat_id ;
			}					
			else{
				frm.patient_id.value = '';				
			}
			
}	

async function episodeLookup(obj,code){
	//alert("3");
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	//alert('start frm.patient_id.value->'+frm.patient_id.value);
	var episode_type = frm.episode_type.value;
	
	if(episode_type.length<1){
		alert(getMessage('BL9142','BL'));
		return false;
	}
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	if((episode_type == 'I') || (episode_type == 'D')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where patient_id = '"+patient_id+"' and episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		
	}
	else if((episode_type == 'O') || (episode_type == 'R') || (episode_type == 'E')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"' and episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}		
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	//returnedValues = CommonLookup("Legend", argumentArray );
	var encounter_date = '';
	retVal = await callOperation(patient_id,episode_type,obj.value,facility_id,encounter_date);
	//alert('retVal->'+retVal);
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((retVal != null) && (returnedValues != "") )  {
		var returnedValues = retVal.split("::");
		//alert(returnedValues.length)
		if(returnedValues.length == 4){
			obj.value = arr[0];
			code.value = arr[0];	
			frm.patient_id.value = arr[1];
			//frm.Effective_from.value = returnedValues[2];
		}
		else if(returnedValues.length == 3){
			//alert('3 here')
			//obj.value = returnedValues[0];
			//code.value = returnedValues[0];	
			//frm.Effective_from.value = returnedValues[1];
			obj.value = arr[0];
			code.value = arr[0]; 
			frm.patient_id.value = arr[1]; 
		}

		//alert('frm.patient_id.value->'+frm.patient_id.value);
				

	}
	else
	{
		obj.value = '';
		code.value = '';		
	} 
}

async function callEpisodeDialog(qryParam){
	var retVal				= new String();
	/*var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;*/
	var dialogTop			= "10px";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "900px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Select Episode";		

	var column_sizes = escape("10vh,10vh,10vh,10vh,25vh,10vh,15vh,10vh");

	var column_descriptions = 'PATIENT ID'+','+'EPISODE TYPE'+','+'EPISODE ID'+','+'VISIT ID'+','+'CLINIC DATE'+','+'CLINIC CODE'+','+'CLINIC DESC'+','+'CLINIC_DATE_TRUNC';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YYYYYYYY"+qryParam;
	
	var  retVal= await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=ENC_SPEC_EPISODE_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  retVal=arr[2]+"::"+arr[0]+"::"+arr[4]+"::";
		  //Format Conversion as :: is Needed instead of ^~^ 
	 }
	return retVal;
}

function callOperation(patient_id,episode_type,episode_id,facility_id,encounter_date){	
	var column_sizes = escape("40%,30%,30%");                       	  
	var tit = getLabel('Common.patientId.label','Common') + ',' +
				getLabel('Common.episodeid.label','Common') + ',' 
			+ 'Encounter Date' ;
	//alert('fid->'+facility_id)
	var column_descriptions=encodeURIComponent(tit);

	var sqlTemp = '';

	var qryParam='&patient_id='+patient_id+'&episode_type='+episode_type+'&episode_id='+episode_id+'&facility_id='+facility_id+'&encounter_date='+encounter_date;
	retVal=callEpisodeDialog(qryParam);
	return retVal;
}

function loadRecalcJobs(){
	var patient_id = $('#patient_id').val();
	var episode_type = $('#episode_type').val();
	var episode_id = $('#episode_id').val();
	var visit_id = $('#visit_id').val();
	var eff_from = $('#Effective_from').val();
	var eff_to = $('#Effective_to').val();
	
	if($.trim(patient_id) == ''){
		alert('Patient Id is mandatory');
		return false;
	}
	
	parent.BLResultsFrame.location.href = '../jsp/BLShowRecalcJobs.jsp?patient_id='+patient_id+
											'&episode_type='+episode_type+
											'&episode_id='+episode_id+
											'&visit_id='+visit_id+
											'&eff_from='+eff_from+
											'&eff_to='+eff_to;
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

