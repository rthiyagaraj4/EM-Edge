function refresh(){
	interim_main_report.search_hdr.document.location.href = '../../eBL/jsp/BLApproveOSMedRecReqHdr.jsp'
	interim_main_report.body_frame.document.location.href = "../../eCommon/html/blank.html";
	commontoolbarFrame.location.reload();
	}



function apply(){
	var result = interim_main_report.search_hdr.document;	
	var facilityId = $(result).find('#facility_id').val();
	var patient_id = $(result).find('#patient_id').val();
	var result1 = interim_main_report.body_frame.document;
	
	
	if($(result1).find("#approve").is(":checked") == true){
	$(result1).find('#approve').val('Y');
				}
	else{
	$(result1).find('#approve').val('N');
				}
	
	
	var authorized_yn= $(result1).find('#approve').val();
	
	
	
var	auth_start_time_str='';
	$.ajax({
		type:"POST",
		url:"../../eBL/jsp/BLMedRepSystemDateAjax.jsp?",
		dataType:"text",
		async:false,
		success: function(data){
			auth_start_time_str = $.trim(data);
			
		},
		 error: function(data){
			 alert(data);
	      }
	});

	
	
	$.ajax({
		type:"POST",
		url:"../../servlet/eBL.BLApproveApplyServlet?&facilityId="+facilityId+"&patient_id="+patient_id+"&authorized_yn="+authorized_yn+"&auth_start_time_str="+auth_start_time_str,
		dataType:"text",
		async:false,
		
		success: function(data){
			date = $.trim(data);
		
			interim_main_report.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"APP-SM0070 Operation Completed Successfully ...."+"&err_value=Error";
			
		
			
		},
		 error: function(data){
			 alert(data);
	      }
	});
	refresh();
}


function updateApproveFlag(){
	var body_frame = parent.body_frame.document;
	if($(body_frame).find("#approve").is(":checked") == true){
	$(body_frame).find('#approve').val('Y');
				}
	else{
	$(body_frame).find('#approve').val('N');
				}
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
		if(responseText=="N"){
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}	
	}
}

function defaultEncounter(obj){

	var patId = document.forms[0].patient_id.value;
	var patClass = document.forms[0].episode_type.value;
	var facilityId = document.forms[0].facility_id.value;
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
				if(responseText != 'N' && responseText.length>0){
					var retArr = responseText.split(":::");
					document.forms[0].episode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].hdnEpisode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].visit_id.value = retArr[2]=='0'?'':retArr[2];	
				}
				else{
					document.forms[0].episode_id.value = '';
					document.forms[0].hdnEpisode_id.value = '';
					document.forms[0].visit_id.value ='';	
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
			if(responseText != 'N' && responseText.length>0){
				var retArr = responseText.split(":::");
				document.forms[0].episode_id.value = retArr[0];
				document.forms[0].hdnEpisode_id.value = retArr[0];
				document.forms[0].visit_id.value = retArr[2]=='0'?'':retArr[2];
				document.forms[0].Effective_from.value = retArr[1];
			}
			else{
				document.forms[0].episode_id.value = '';
				document.forms[0].hdnEpisode_id.value = '';
				document.forms[0].visit_id.value ='';
				document.forms[0].Effective_from.value = '';
			}
		}
	}
	
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
function getPatDetails(){
	var frm = document.forms[0]
	var patId = frm.patient_id.value;
	if(patId.length>0){
			if(frm.enteredPatient.value.length>0){
				if((frm.enteredPatient.value != patId)){
					parent.body_frame.location.href="../../eCommon/html/blank.html";
					parent.messageFrame.location.href="../../eCommon/html/blank.html";
				}
			}

			frm.enteredPatient.value = patId;
	}
	
}

function resetSrchCriteria(){
	var frm  = document.BLApproveOS;
	var patientId = frm.patient_id.value;
	frm.patient_id.value = '';				
	parent.body_frame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/html/blank.html";
}
function reset()
{	
	interim_main_report.location.reload();
}

function search(){
	//alert("1");
	var frm  = document.BLApproveOS;
	var patientId = frm.patient_id.value;
	var noOfDecimal1 = frm.noOfDecimal.value;
	var usr_id = frm.usr_id.value;
	if (patientId == "") {
			alert("Patient ID cannot be blank");
			return false;
	}
parent.body_frame.location.href="../../eBL/jsp/BLApproveOSMedRecReqResult.jsp?called_frm=BL&patientId="+patientId+"&noOfDecimal1="+noOfDecimal1+"&usr_id="+usr_id;
parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}


function putDecimal_Text(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
	 
				}
 
			}

		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var tempForMinus = temp7;
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			var nextDigit = temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+2));

			if(nextDigit.length>temp6.length){
				var lastDigit = nextDigit.substring(deci,parseInt(deci)+1);
				if(lastDigit>=5){
					if(temp6>(Math.pow(10,deci) - 2)){
						temp7 = parseFloat(temp7)+parseFloat(1);
						temp6=0;
					}
					else{
						if(temp6.charAt(0) == '0'){
							var temp10 = parseFloat(temp6)+parseFloat(1);
							temp6 = '0'+temp10;
						}
						else{
							temp6=parseFloat(temp6)+parseFloat(1);
						}												
					}					
					
				}
			}
			/*Added new Logic for Rounding*/
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.toString().length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
			
			if(temp5 == 0){
				Obj.text("0."+temp6+localTemp);
			}
			else if(temp5 == 1 && tempForMinus == '-'){
				Obj.text(temp7+"0."+temp6+localTemp);
			}
			else{
				Obj.text(temp7+"."+temp6+localTemp);
			}
	
		}
	}
}
