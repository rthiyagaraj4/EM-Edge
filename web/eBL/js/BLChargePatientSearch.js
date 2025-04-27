/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
------------------------------------------------------------------------------------------------------------------------------
1            V210129             13523     	MOHE-CRF-0060							Shikha Seth
*/
function onSearch()
{	
	var patient_id = document.report_form.patient_id.value;  //ok 
	var encounter_id=document.report_form.encounter_id.value;
	var encounter_period = document.report_form.encounter_period.value;
	var encounter_from_date = document.report_form.encounter_from_date.value;
	var encounter_to_date = document.report_form.encounter_to_date.value;
	var patient_name = document.report_form.patient_name.value;
	var patient_name_cond = document.report_form.patient_name_cond.value;
	var contact_no = document.report_form.contact_no.value;
	var contact_no_cond = document.report_form.contact_no_cond.value;
	var age_from = document.report_form.age_from.value;
	var age_to = document.report_form.age_to.value;
	var location_type = document.report_form.location_type.value;
	var location_code = document.report_form.location_code.value;
	var gender = document.report_form.gender.value;
	var doctor_name = document.report_form.doctor_name.value;
	var doctor_name_cond = document.report_form.doctor_name_cond.value;
	var payer_group = document.report_form.payerGroupCode.value;
	var payer= document.report_form.payer.value;
	var payer_cond= document.report_form.payer_cond.value;
	var policy= document.report_form.policy.value;
	var policy_cond= document.report_form.policy_cond.value;
	var patient_type = document.report_form.patient_type.value;
	var episode_type = document.report_form.episode_type.value;
	var episode_status = document.report_form.episode_status.value;

	var select_value = document.report_form.encounter_period.value;
	var optionList = document.report_form.optionList.value;
	var nric = document.report_form.nric.value;
	var facilityid = document.report_form.facilityid.value; //V210129
	/*
	 * var unBilled = document.report_form.nric.value;
	 * if($('#unBilledExists').prop('checked')){ unBilled = 'Y'; } else{ unBilled =
	 * 'N'; }
	 */

	if(location_type != '' && location_code == ''){
		location_code = '**';
	}

	if(episode_type == 'R' && patient_id==''){
		//alert(getMessage("BL6103",'BL'));
		var process_label = getMessage('BL6103','BL');  //'Encounter Period cannot be blank';     
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		return;
	}
	
    if(select_value == 'S' && episode_type != 'R'){
		var process_label = getMessage('BL00915','BL');  //'Encounter Period cannot be blank';     
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;		
		return;  
    }
    if(select_value == 'P'){
    	if(encounter_from_date == ''){
    		alert(getMessage("BL00916",'BL'));
    		//alert("APP-BL00916 Encounter From Date cannot be blank ")
    		//var process_label = getMessage('BL00916','BL'); // 'Encounter From Date cannot be blank';  
    	//	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
    		return false;
    	}
    	
    	if(encounter_to_date == ''){
    		alert(getMessage("BL00917",'BL'));
    	//	alert("APP-BL00917 Encounter To Date cannot be blank ");
    		//var process_label = getMessage('BL00917','BL'); // 'Encounter To Date cannot be blank';  
    		//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
    		return false;
    	}
    	
    	var starr = encounter_from_date.split("/");
		var enarr = encounter_to_date.split("/");
		var startdt = new Date();
		var enddt = new Date();
		startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
		enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
		var timeDiff;
		var daysDiff;
		if(startdt>enddt)
		{	alert(getMessage("BL4115",'BL'));
			//alert("APP-BL4115 TO date is less than FROM date ");
		//	var process_label = getMessage('BL4115','BL'); 
    		//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
    		return false;
		}
		timeDiff = enddt.getTime() - startdt.getTime();
		daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
				

		var actualDays = 30;
		if(patient_id == '' && daysDiff > actualDays)
		{
			alert(getMessage("BL00918",'BL'));
			//alert("APP-BL00918 Encounter To Date Cannot be greater than 30 Days from Encounter from Date ");
				//var process_label = getMessage('BL00918','BL');  //"Encounter To Date Cannot be greater than 30 Days from Encounter from Date";
			//	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
	    		return false;
		}
		
    }
  
	if(episode_type=='E' || episode_type=='O' )
	{   
	
	
	
	if(location_type=='W')
	{
		
		var process_label = getMessage('BL00297','BL'); 
		
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		return false;
	}
	
}
if(episode_type=='I' || episode_type=='D')
{
	
	if(location_type=='C'){
	var process_label = getMessage('BL00298','BL'); 
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
	return false;
	}
}

if (episode_type=='R')
{
	
	if(location_type=='W' || location_type=='C' )
	{
		
		var process_label = getMessage('BL00301','BL'); 
		
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		return false;
		}
	
}

    if($('#saveSearchCriteria').is(':checked')){
    	$('input:text').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});
    	$('select').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});

    	$('#payerGroupCode').attr('dflt_srch_value','Y');
    	
    	if($('#funct_name').val() == 'BillGeneration'){
    		try{
    			fnAutoFillSaveCriteria('EBL_TRAN_BILL_GEN');
    		}
    		catch(e){
    			alert(e)
    		}
    		
        }
    	else if($('#funct_name').val() == 'depositandrefund')
    	{
    		fnAutoFillSaveCriteria('EBL_DEP_REFUND');
        }
        else{
        	fnAutoFillSaveCriteria('EBL_TRAN_EXISTING_ORDER');
        }
    }
    parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
    parent.parent.dummyFrame.location.href= '../../eCommon/jsp/process.jsp';
	var url="../../eBL/jsp/BLChargePatientSearchResult.jsp?patient_id="+patient_id+
	"&encounter_id="+encounter_id+ //102343567
	"&encounter_period="+encounter_period+ 
	"&encounter_from_date="+encounter_from_date+
	"&encounter_to_date="+encounter_to_date+
	"&patient_name="+encodeURIComponent(patient_name)+
	"&patient_name_cond="+patient_name_cond+
	"&contact_no="+contact_no+
	"&contact_no_cond="+contact_no_cond+
	"&age_from="+age_from+
	"&age_to="+age_to+
	"&location_type="+location_type+
	"&location_code="+location_code+
	"&gender="+gender+
	"&doctor_name="+encodeURIComponent(doctor_name)+
	"&doctor_name_cond="+doctor_name_cond+
	"&payer_group="+payer_group+
	"&payer="+encodeURIComponent(payer)+
	"&payer_cond="+payer_cond+
	"&policy="+encodeURIComponent(policy)+
	"&policy_cond="+policy_cond+
	"&patient_type="+patient_type+
	"&episode_type="+episode_type+
	"&episode_status="+episode_status+
	"&optionList="+optionList+
	"&nric="+nric+
	"&facilityid="+facilityid; //V210129
	// "&unBilled="+unBilled;

	parent.frames[1].location.href=url;
}


function patientOnChange(){
	
    var select_value = document.report_form.encounter_period.value;
    var id = document.getElementById("encounter_period");
	var idhide = 'hide_this_row';
	var obj = '';
    var encounter_from= document.forms[0].encounter_from_date.value;		
    var encounter_to=document.forms[0].encounter_to_date.value;

	if(select_value == 'P' )
	     {
			obj=document.getElementById(idhide);
	        obj.style.display = ( obj.style.display != "none" ) ? "none" : "";//Hide Fields  
	        obj.visibility = "show";//Show Fields
	 } 

	 if(select_value == 'S'){
	 obj=document.getElementById(idhide);
	 obj.style.display = "none";
	 obj.visibility = "hidden";
	 }

	 if(select_value == 'D'){
	 obj=document.getElementById(idhide);
	 obj.style.display = "none";
	 obj.visibility = "hidden";
	 }

	if(select_value == 'W'){
	 obj=document.getElementById(idhide);
	 obj.style.display = "none";
	 obj.visibility = "hidden";
	 }

	 if(select_value == 'M'){
		 obj=document.getElementById(idhide);
		 obj.style.display = "none";
		 obj.visibility = "hidden";
	}		

}

async function getPatID()
{	
	var pat_id=await PatientSearch();	
	if( pat_id != null )						
	document.forms[0].patient_id.value = pat_id ;					
}

function showCalendar_loc(Val1, Val2){	

	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1,null,null);
	}
}	
	

function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;	
		var effFromDt = document.forms[0].encounter_from_date.value;
		var effToDt = document.forms[0].encounter_to_date.value;
		if(validDate(obj.value,'DMY',locale))
		{
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL0643",'BL'));
				obj.value = '';
				return false;
			}
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL4115",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}
			}		
			
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function showWardClinic()
{
	var epi_type=document.forms[0].episode_type.value;	
	if(epi_type=='E' || epi_type=='O')
	{
		document.forms[0].ward_code.value = "";
		document.forms[0].ward_desc.value = "";
    	document.getElementById('clinic_id').style.display='inline';
		document.getElementById('clinic_id1').style.display='inline';
		document.getElementById('ward_id').style.display='none';
		document.getElementById('ward_id1').style.display='none';
	}
	else if(epi_type=='I' || epi_type=='D')
	{
		document.forms[0].clinic_code.value = "";
		document.forms[0].clinic_desc.value = "";
		document.getElementById('clinic_id').style.display='none';
		document.getElementById('clinic_id1').style.display='none';
		document.getElementById('ward_id').style.display='inline';
		document.getElementById('ward_id1').style.display='inline';
	}
	else
	{
		document.forms[0].ward_code.value = "";
		document.forms[0].ward_desc.value = "";
		document.forms[0].clinic_code.value = "";
		document.forms[0].clinic_desc.value = "";
		document.getElementById('clinic_id').style.display='none';
		document.getElementById('clinic_id1').style.display='none';
		document.getElementById('ward_id').style.display='none';
		document.getElementById('ward_id1').style.display='none';
	}
}


function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
			Obj.select();
			return false;  
		}
	}
	return true;
}


function localTrimString(sInString) {	
  sInString = sInString.replace( /^\s+/g, "" );// strip leading space
  return sInString.replace(/^\s+|\s+$/g,"");
}

function resetValues(){

	$('input:text').each(function(){
		$(this).val('');
	});
	$('select').each(function(){
		$(this).val('');
	});

	$('#payerGroupCode').val('');
	$('#encounter_period').val('S');
	$('#hide_this_row').hide();  
	
	
	$('#patient_name_cond').val('S');
   
   	 $('#doctor_name_cond').val('S');
   
   	 $('#payer_cond').val('S');
   
   	 $('#policy_cond').val('S');
   	 
   	 $('#gender').val('A');
   	 
   	 $('#contact_no_cond').val('S');
   	 
   	 $('#encounter_period').removeAttr("disabled","disabled");
   	 $('.mandHide').show();
   	$("#pageredirect").hide();
   	$('#episode_type').val('A');
   	$('#optionList').val('A');
   	$('#optionList').children().remove();
   	$('#optionList').append('<option value="A">All</option>');
}

function checkForNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

async function sendSelectedValues() { 	
	  var  popupWindow =await window.showModalDialog('SortList.jsp',null,"dialogWidth:400px; dialogHeight:250px; center:yes");  
	  if (popupWindow==null || popupWindow.text=="undefined"){
		  popupWindow="EncounterId(ASC)";
	  }
	  document.getElementById("sortByValues").innerHTML='Click to Sort['+popupWindow+']';
}

function clearCode(obj){
	obj.value = '';
}

function cliniconchange(){
	$('#location_name').val('');
	$('#location_code').val('');
}

function pageredirect()
{
	var episode_type = document.report_form.episode_type.value;
	var url="../../eBL/jsp/BLDepositRefundFrame.jsp?episode_type="+episode_type;
	//alert(url);
	var dialogHeight= "100" ;
	var dialogWidth	= "100" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var retVal =window.showModalDialog(url,null,features);  
}

function reset(){	
	BLChargePatientQueryFrame.location.reload();
}

function CheckForAlphaCharsNatID(event){

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}



//added by Vijay for bill generation patient deposit collection  	

 function deposit_call(episode_id,visit_id,patient_id,encounter_id,episode_type)
{
	//alert("e");
	
	
	var facility_id=$("#facility_id").val();
	var pat_id=patient_id;	
	
	var check="";
	$.ajax({
			type : 'POST',
			url : "../jsp/BlDepositremarks.jsp?&func_mode=dischargecheck&facility_id="
				+ facility_id
				+ "&episode_id="
				+episode_id
				+"&episode_type="
				+episode_type
				+ "&pat_id="
				+pat_id,
				async : false,
				dataType : "text",
				success : function(data) { 
					check=trimString(data);
					if(check=="Y")
							{
							alert(getMessage("BL2205","BL"));
							status=false;

							}
					
						else
							{
							status=true;
							
							//return;
							var url="../../eBL/jsp/BLDepositRefundFrame.jsp?called_from=bill_generation&episode_type="+episode_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id"+encounter_id;
							
							
							//alert(url);
							var dialogHeight= "100vh" ;
							var dialogWidth	= "100vw" ;													   
							var status="no";
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
							var retVal =top.window.showModalDialog(url,null,features);  
							}
				}
		});	

	
	
	


}

function loadSearchResults(patient_id,encounter_id,encounter_period,encounter_from_date,encounter_to_date,
		patient_name,patient_name_cond,contact_no,contact_no_cond,age_from,age_to,
		location_type,location_code,gender,doctor_name,doctor_name_cond,payer_group,
		payer,payer_cond,policy,policy_cond,patient_type,episode_type,episode_status,chunk_id,optionList,nric,facilityid){	 //V210129
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	parent.parent.dummyFrame.location.href= '../../eCommon/jsp/process.jsp';
	
	var url="../../eBL/jsp/BLChargePatientSearchResult.jsp?patient_id="+patient_id+
	"&encounter_id="+encounter_id+ //102343567
	"&encounter_period="+encounter_period+ 
	"&encounter_from_date="+encounter_from_date+
	"&encounter_to_date="+encounter_to_date+
	"&patient_name="+encodeURIComponent(patient_name)+
	"&patient_name_cond="+patient_name_cond+
	"&contact_no="+contact_no+
	"&contact_no_cond="+contact_no_cond+
	"&age_from="+age_from+
	"&age_to="+age_to+
	"&location_type="+location_type+
	"&location_code="+location_code+
	"&gender="+gender+
	"&doctor_name="+encodeURIComponent(doctor_name)+
	"&doctor_name_cond="+doctor_name_cond+
	"&payer_group="+payer_group+
	"&payer="+encodeURIComponent(payer)+
	"&payer_cond="+payer_cond+
	"&policy="+encodeURIComponent(policy)+
	"&policy_cond="+policy_cond+
	"&patient_type="+patient_type+
	"&episode_type="+episode_type+
	"&episode_status="+episode_status+
	"&chunk_id="+chunk_id+
	"&optionList="+optionList+
	"&nric="+nric+
	"&facilityid="+facilityid; //V210129

	parent.frames[1].location.href=url;
}

// ends ---
