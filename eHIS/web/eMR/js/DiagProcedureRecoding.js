function validateDate(obj){

if(obj.value!="")
	{
	if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			
			return ;
		}
	}
}

function callcheck_val()
{ 
	if (document.forms[0].discharge_val.checked==true)
		document.forms[0].discharge_val.value="Y";
	else
		document.forms[0].discharge_val.value="N";
}

//Func will return an alert message if FROM DATE is null and TO Date is selected
function checkFromDt(to,frmDt)
{
	if ( (frmDt.value=='') && (to.value!='') )
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.fromdate.label","Common"));		
		alert(error);
		to.value='';
		frmDt.focus();
		return false;
	}
}

function doDcsdDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) > Date.parse(fromdt)) return true;
    }
	return true;
}

function DscdPeriodChk(Dt)
{	
	if(Dt.value!="")	
	{
		var SystemDate	= document.forms[0].SystemDate.value;
		if(validDate(Dt.value,"DMY","en"))
		{
			var toDt	= convertDate(Dt.value,"DMY",localeName,"en");
			if(!isAfter(SystemDate,toDt,'DMY',localeName))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));		
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	}
	return;
}

function doDischargeDateCheck(obj1,obj2)
{
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		return false;
	}
	else
		return true;
}

function disChargePeriodChk(Dt)
{
	if(Dt.value!="")
	{	
		if(validDate(Dt.value,"DMY","en"))
		{
			var toDt	= convertDate(Dt.value,"DMY",localeName,"en");
			if(!isBeforeNow(toDt,"DMY","en"))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				//error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));	
				error = error.replace('$', getLabel("eMR.DischPeriod.label","MR"));	
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	}
	return;
}


//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}

function CompareDisPeriodFromToTime(from,to) // modified by mujafar (existing issue) as part of ML-MMOH-CRF-1405
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}


function CompareAltPeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='')
	{
		t1 =false;
		t1 = CheckDate(from);
		if(!t1)
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			from.value="";
			from.focus();
			return;
		}
		
	}
	if(tdt !='')
	{
		t1 =false;

		t1 = CheckDate(to);	
		
		if(!t1)
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			to.value=""; 
			to.focus();
			return;
		}
	}

	if (!PeriodcheckDateTime(frdt,tdt) )
	{
		  to.focus();
		  to.select();
	}
	
}



function CompareDeceasedPeriod(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='')
	{
		var t1 =false;
		t1 = CheckDate(from);
		if(!t1)
		{
			from.value="";
			from.focus();
			return;
		}
		
	}
	if(tdt !='')
	{
		var t1 =false;
		t1 = CheckDate(to);	
		
		if(!t1)
		{
			to.value=""; 
			to.focus();
			return;
		}
	}

	if (!PeriodcheckDateTime(frdt,tdt) )
	{
		  
		  to.focus();
		  to.select();
	}
	
}

function PatValidations(obj)
{
	var call_function=document.forms[0].call_function.value
		
		
	if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='called_from' id='called_from' value='MEDICAL_REPORT_REQUEST'><input type='hidden' name='call_function' id='call_function' value='"+call_function+"'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
}
async function callSearchScreen()
{
	var patientid= await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}
function getStatus(obj)
{
	
	var obj_type = document.forms[0].status;
	var length  = obj_type.length;
	for(i=0;i<=length;i++) 
	{
		obj_type.remove(1);
	}

	if(obj.value == 'M')
	{
	document.forms[0].mand_gif3.style.visibility="visible";
		var opt = "";
				/*opt = document.createElement("OPTION");
				opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				opt.value= '';
				document.forms[0].status.add(opt)*/
				/*opt = document.createElement("OPTION");
				opt.text = getLabel("eMR.PendingReview.label","MR");
				opt.value= 'PR';
				document.forms[0].status.add(opt)*/
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.PartiallyCompleted.label","common");
				opt.value= 'PC';
				document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.completed.label","common");
				opt.value= 'C';
				document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Authorized.label","common");
				opt.value= 'A';
				document.forms[0].status.add(opt)
					

	}
	else if(obj.value == 'A')
	{
		document.forms[0].mand_gif3.style.visibility="visible";
		var opt = "";
				//opt = document.createElement("OPTION");
				//opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				//opt.value= '';
				//document.forms[0].status.add(opt)
				//opt = document.createElement("OPTION");
				//opt.text = getLabel("eMR.PendingReview.label","MR");
				//opt.value= 'PR';
				//document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.PartiallyCompleted.label","common");
				opt.value= 'PC';
				document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Authorized.label","common");
				opt.value= 'A';
				document.forms[0].status.add(opt)

	}
	else if(obj.value =="")
		document.forms[0].mand_gif3.style.visibility="hidden";


parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
}


function chkPeriod(obj){
	if(obj.value == 'IP' || obj.value == 'DC'){
		if(document.forms[0].stage_no.value == "3"){
			if(obj.value == "IP" && document.forms[0].max_level_for_ip_yn.value == "Y"){
				document.forms[0].p_discharge_date_from.value=document.forms[0].ip_grace.value;
			}else if(obj.value == "DC" && document.forms[0].max_level_for_dc_yn.value == "Y"){
				document.forms[0].p_discharge_date_from.value=document.forms[0].ip_grace.value;
			}else{
				document.forms[0].p_discharge_date_from.value=document.forms[0].SystemDate_ip.value;
			}
		}else{
			document.forms[0].p_discharge_date_from.value=document.forms[0].SystemDate_ip.value;
		}
		if(document.forms[0].isAllowModifyDiscPeriod.value == 'true') // added by mujafar for ML-MMOH-CRF-1405 and below line enabled
		document.forms[0].discDate_img.style.visibility="visible"; //commented by mujafar for ML-MMOH-CRF-1271
		document.forms[0].p_discharge_date_to.value=document.forms[0].SystemDischarge_display.value;
		if(document.forms[0].isAllowModifyDiscPeriod.value == 'false'){ // added by mujafar for ML-MMOH-CRF-1405
		document.forms[0].p_discharge_date_from.disabled=true;
		document.forms[0].p_discharge_date_to.disabled=true;
		document.getElementById("d1").disabled=true;
		document.getElementById("d2").disabled=true;
		}
//		CompareDischargePeriod(document.forms[0].p_discharge_date_from,document.forms[0].p_discharge_date_to,"DV");Commented On 5/14/2010
	}
	else if(obj.value == 'OP' || obj.value == 'EM'){
		if(document.forms[0].stage_no.value == "3"){
		//alert(document.forms[0].lstPatientClass.value);
		if(document.forms[0].lstPatientClass.value == "OP" && document.forms[0].max_level_for_op_yn.value == "Y"){
		document.forms[0].p_discharge_date_from.value=document.forms[0].op_grace.value;
		}else if(document.forms[0].lstPatientClass.value == "EM" && document.forms[0].max_level_for_em_yn.value == "Y"){
		document.forms[0].p_discharge_date_from.value=document.forms[0].op_grace.value;
		}else{
		document.forms[0].p_discharge_date_from.value=document.forms[0].SystemDate_op.value;
		}
		}
		else
		{
		document.getElementById("p_discharge_date_from").value=document.getElementById("SystemDate_op").value;
		}
		if(document.forms[0].isAllowModifyDiscPeriod.value == 'true') // added by mujafar for ML-MMOH-CRF-1405 and enabled below line
		document.forms[0].discDate_img.style.visibility="visible"; // commented by mujafar for ML-MMOH-CRF-1271
		document.forms[0].p_discharge_date_to.value=document.forms[0].SystemDischarge_display.value;
		if(document.forms[0].isAllowModifyDiscPeriod.value == 'false'){ // added by mujafar for ML-MMOH-CRF-1405
		document.forms[0].p_discharge_date_from.disabled=true;
		document.forms[0].p_discharge_date_to.disabled=true;
		document.getElementById("d1").disabled=true;
		document.getElementById("d2").disabled=true;
		
		}
//		CompareDischargePeriod(document.forms[0].p_discharge_date_from,document.forms[0].p_discharge_date_to,"DV"); Commented On 5/14/2010
	}else{
		if(document.forms[0].isAllowModifyDiscPeriod.value == 'true') // added by mujafar for ML-MMOH-CRF-1405 and enabled below line
		document.forms[0].discDate_img.style.visibility="hidden"; // commented by mujafar for ML-MMOH-CRF-1271
		document.forms[0].p_discharge_date_from.value="";
		document.forms[0].p_discharge_date_to.value="";
		document.forms[0].p_discharge_date_from.disabled=false; // modified by mujafar for (existing issue) against ML-MMOH-CRF-1271 
		document.forms[0].p_discharge_date_to.disabled=false; // modified by mujafar for (existing issue) against ML-MMOH-CRF-1271 
//		document.forms[0].duration_period.value="";//Commented On 5/14/2010
	}

}
function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function clearResultPage(obj){
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
}
function beforeGetLoc(obj1,obj2,obj3){
	
	if(document.forms[0].locn_code.value != "")
			getLocn(obj1,obj2,obj3);
		else
			document.forms[0].Hloc.value = "";


}

async function getLocn(loginuser,fac_id,target)
{
	
   var retVal =    new String();
   var retVal =    new String();
   var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
   var locale="";				
   var spec_code="";				
   var oper_id="";				
   locale=document.forms[0].locale.value; 
   spec_code=document.forms[0].speciality_code.value;
   oper_id=document.forms[0].oper_stn_id.value;
   var patient_class = document.forms[0].lstPatientClass.value;
   tit=getLabel("Common.Location.label",'Common')

	
		if(patient_class == 'OP')
		{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind ='A' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}
				
				
			sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' and DIAG_PROC_RECODE_FOR_OP_YN='Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				
			sql=sql+"  ORDER BY  2";
		}
		else if (patient_class == 'EM')
		{	
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind = 'E' and care_locn_type_ind = 'C' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				
			   sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' and DIAG_PROC_RECODE_FOR_OP_YN='Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
			   sql=sql+"  ORDER BY  2";
		
		}
		else if(patient_class == 'IP')
		{
			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+oper_id+"' and b.appl_user_id='"+loginuser+"'  and diag_proc_recode_for_ip_yn = 'Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";

			
	 

				sql=sql+"  ORDER BY  2";
		}
		else if(patient_class == 'DC')
		{

			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='DC' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+oper_id+"' and b.appl_user_id='"+loginuser+"'  and diag_proc_recode_for_ip_yn = 'Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";

			

		}
		else
		{
				sql="SELECT cli_nur_code code ,cli_nur_description description FROM (SELECT clinic_code cli_nur_code,long_desc cli_nur_description FROM op_clinic_lang_vw WHERE facility_id ='"+fac_id+"' AND language_id = '"+locale+"' AND eff_status = 'E'  ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}
				
				sql=sql+" AND (facility_id,clinic_type,clinic_code) IN (SELECT facility_id,locn_type,locn_code FROM am_os_user_locn_access_vw WHERE facility_id ='"+fac_id+"' AND oper_stn_id = '"+oper_id+"' AND appl_user_id = '"+loginuser+"' and DIAG_PROC_RECODE_FOR_OP_YN='Y')";
				
				 sql=sql+" UNION SELECT a.nursing_unit_code cli_nur_code ,a.short_desc cli_nur_description FROM ip_nursing_unit_lang_vw a ,am_os_user_locn_access_vw b WHERE a.language_id ='"+locale+"' AND a.facility_id ='"+fac_id+"'  AND a.patient_class IN ('IP','DC') AND a.facility_id = b.facility_id AND a.eff_status = 'E' AND a.nursing_unit_code = b.locn_code AND a.locn_type = b.locn_type AND b.locn_type = 'N' AND b.oper_stn_id ='"+oper_id+"' AND b.appl_user_id ='"+loginuser+"' AND b.diag_proc_recode_for_ip_yn = 'Y')";

				
				
				sql=sql+"WHERE UPPER (cli_nur_code) LIKE UPPER (?) AND UPPER (cli_nur_description) LIKE UPPER (?)";

				

				sql=sql+"  ORDER BY  2";


		}
   
  
				
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray );
		
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		if(retVal != null && retVal != "")
		{
			target.value = arr[1] ;
			document.forms[0].Hloc.value = arr[0];
		}
		else
			target.value ="";

}
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

async function clearAll()
{
	
		if(parent.frames[2].name == "resultFrame")
				parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';
			else
				parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

		
	}
async function submitPage(){

     parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	 var continue_yn = "Y";
		 if(document.forms[0].lstPatientClass.value == ''){
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus();
			return;
		}
				if(document.forms[0].isAllowModifyDiscPeriod.value == "true")
		{ // added by mujafar for ML-MMOH-CRF-1405
		
		if(document.forms[0].p_discharge_date_from.value == '' || document.forms[0].p_discharge_date_to.value == '' )
			{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.DischPeriod.label","MR"));
			alert(error);
			if(document.forms[0].p_discharge_date_from.value == '') document.forms[0].p_discharge_date_from.focus();
			if(document.forms[0].p_discharge_date_to.value == '') document.forms[0].p_discharge_date_to.focus();

			return;
			}
		}


		


		var speciality_code	= document.forms[0].speciality_code.value;
		var patient_id			= document.forms[0].PatientId.value;
		var p_encounter_id	= document.forms[0].p_encounter_id.value;
//		var duration_period	= document.forms[0].duration_period.value;
		var locn_code			= document.forms[0].locn_code.value;
		/*Commented On 5/14/2010
		if(duration_period>180&&duration_period<=730){
			if(speciality_code=="" && patient_id=="" && p_encounter_id=="" ){
				continue_yn= CompareDischargePeriod(document.forms[0].p_discharge_date_from,document.forms[0].p_discharge_date_to,"");
			}
		}else if(duration_period>730){
				if(patient_id=="" && p_encounter_id=="" ){
					continue_yn= CompareDischargePeriod(document.forms[0].p_discharge_date_from,document.forms[0].p_discharge_date_to,"");
				}
		}*/
	if(speciality_code=="" && patient_id=="" && p_encounter_id==""&& locn_code=="" ){
			var err_msg=getMessage("MANDATORY_FIELDS_FOR_SEARCH","MR");
			alert(err_msg);
			continue_yn="N";
	}else{
			continue_yn="Y";
	}
	if(continue_yn == "Y"){
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
				condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
		oper_stn = document.forms[0].operstn.value;
		var call_function = document.forms[0].call_function.value;
 //alert(document.forms[0].status.value);
			var speciality_code = document.forms[0].speciality_code.value;
			var location_code = document.forms[0].Hloc.value;
			var status = document.forms[0].status.value;
			var stage_no = document.forms[0].stage_no.value;
			var search_by = document.forms[0].search_by.value;
			var action_if_not_done=document.forms[0].action_if_not_done.value;
			var allow_recode_diag_yn=document.forms[0].allow_recode_diag_yn.value;
			var allow_recode_proc_yn=document.forms[0].allow_recode_proc_yn.value;
			var allow_ot_proc_recode_yn=document.forms[0].allow_ot_proc_recode_yn.value;
			var allow_non_ot_proc_recode_yn=document.forms[0].allow_non_ot_proc_recode_yn.value;

			parent.frames[2].location.href="../../eMR/jsp/DiagProcedureRecodingResult.jsp?clear=session&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect&speciality_code="+speciality_code+"&location_code="+location_code+"&status="+status+"&stage_no="+stage_no+"&search_by"+search_by+"&increment_rec_count=Y&action_if_not_done="+action_if_not_done;	
;
		}
	}

function CompareDischargePeriod(p_from_date,p_to_date,action){
//	var file_created_lbl		= Add_Modify_Frame.getLabel('eFM.FileCreatedDate.label','FM');//File Created Date Label
		var proceed="Y";
		var day1, day2;
		var month1, month2;
		var year1, year2;

		value1 = p_from_date.value;
		value2 =p_to_date.value;

		day1 = value1.substring (0, value1.indexOf ("/"));
		month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);

		day2 = value2.substring (0, value2.indexOf ("/"));
		month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length); 

		date1 = year1+"/"+month1+"/"+day1;
		date2 = year2+"/"+month2+"/"+day2;
		firstDate = Date.parse(date1)
		secondDate= Date.parse(date2)
		msPerDay = 24 * 60 * 60 * 1000;
		dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
//		alert(dbd)
		if(action!="DV"){
			if(dbd>180&&dbd<=730){
				var err_msg=getMessage("SEARCH_CRITERIA_BEYOND_6_MONTHS","MR");
				alert(err_msg);
				proceed="N";
				return proceed;
			}else if(dbd>730){
				var err_msg=getMessage("SEARCH_CRITERIA_BEYOND_2_YEARS","MR");
				alert(err_msg);
				proceed="N";
				return proceed;
			}else{
				return proceed;
			}
		}else{
			document.forms[0].duration_period.value=dbd;
		}
}

async function RecodeDiagnosis(encID, PatID, ln_code, Patient_Class, sex,dob,FacilityId,practitioner_id)
{
	var call_function = "DIAG_RECODE";
	//var FacilityId = document.forms[0].FacilityId.value;
	//var practitioner_id = document.forms[0].attend_practitioner_id.value;
	var dialogHeight= "72vh";
	var dialogWidth = "65vw";
	var dialogTop	= "150";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;


	retVal = 	await window.showModalDialog("../../eMR/jsp/DiagRecodePatProblemMain.jsp?modal_yn=Y&Encounter_Id="+encID+"&ip_practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function+"&location_code="+ln_code+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob,arguments,features);
}





function sendtomain(encounter_id1){
			parent.window.returnValue=encounter_id1;
			parent.window.close();
	}




function submitPrevNext(from, to,action){
	var increment_rec_count="";
	if(action=="Previous"){
		increment_rec_count="N";
	}else if(action=="Next"){
		increment_rec_count="Y";
	}
	document.forms[0].finalSelect.value=document.forms[0].temp1.value;
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].p_discharge_date_from.value = parent.frames[1].document.forms[0].p_discharge_date_from.value; 
	document.forms[0].p_discharge_date_to.value		= parent.frames[1].document.forms[0].p_discharge_date_to.value; 
	document.forms[0].increment_rec_count.value		= increment_rec_count; 
	document.forms[0].totalRecords.value					= document.forms[0].totalRecords.value; 
	document.forms[0].submit();
	
	
}
 function chkForSelectAll(start,end)
{
	if(document.forms[0].criteria != null)
	{
		if(document.forms[0].criteria.value != "validate")
		{
			if(document.forms[0].name =='DiagProcedureRecodingResult')
			{
				if(document.forms[0].selectAll_yn != null && document.forms[0].chkAll != null)
				{
					if(document.forms[0].selectAll_yn.value == "YES")
					{
						document.forms[0].chkAll.checked = true;
						selectAll(document.forms[0].chkAll,start,end)
					}
					else if(document.forms[0].selectAll_yn.value == "NO")
					{
						document.forms[0].chkAll.checked = false;
						selectAll(document.forms[0].chkAll,start,end)
					}
				}
			}
		}
	}
}
function chkCount()
{
	
}
function enableSelect(obj,i)
{
	//alert(obj.checked);
	if(obj.checked) {
	var stage = parent.frames[1].document.forms[0].stage_no.value;
	var temp_val=obj.value;
		if(temp_val!=''){
			temp_arr=temp_val.split("`");
				
			for( i=0;i<temp_arr.length;i++){
				var in_arr=temp_arr[i].split(",");
				var trm_cd=in_arr[2];
								
				//alert('in_arr'+in_arr);

				if(in_arr=="pending1" && (stage == "2" || stage == "3")){
					
					var lvl_check=window.confirm(getMessage("ENC_PEN_L1","MR"));
					
				}else if(in_arr=="pending2" && stage == "3"){
					var lvl_check=window.confirm(getMessage("ENC_PEN_L2","MR"));

				}
				if(lvl_check == false)
				{
					obj.checked=false;
				}
				
			}
		}
		
	}
	var k=document.getElementById("sel_cnt").value;
	
	if (obj.checked == true )
	{
		k++;
		document.getElementById("select_but").disabled = false;
		document.getElementById("finalSelect1").value=document.getElementById("temp2").value;
		
		if(i >= 1)
		{
			
		}
	
	}
	else
	{
		k--;
		
	}
	document.getElementById("sel_cnt").value = k;
	
}
async function recodeModal(fetchrecord){
	var enctemp = "";
	var cnt = document.getElementById("enc_cnt").value;
	//alert("cnt==="+cnt);
	var k=0;
	var from =document.getElementById("from").value;
	var to =document.getElementById("to").value;
	for(var j=1;j<=fetchrecord;j++)	{
		if(document.getElementById('select_chk'+j)){
			if(document.getElementById('select_chk'+j).checked){
				if(k == 0){
					document.getElementById("enc_temp").value="'"+document.getElementById('encid'+j).value+"'$E"
					document.getElementById("pat_temp").value="'"+document.getElementById('Pid'+j).value+"'$E"
					document.getElementById("temp2").value=document.getElementById('encid'+j).value+"$"+document.getElementById('encid'+j).name+"$"+"~"
				}else{
					//				alert(eval("document.getElementById("select_chk")"+j).value);	
					document.getElementById("enc_temp").value=document.getElementById("enc_temp").value+",'"+document.getElementById('encid'+j).value+"'$E"
					document.getElementById("pat_temp").value=document.getElementById("pat_temp").value+",'"+document.getElementById('Pid'+j).value+"'$E"
					document.getElementById("temp2").value=document.getElementById("temp2").value+document.getElementById('encid'+j).value+"$"+document.getElementById('encid'+j).name+"$"+"~"
				}
				k++;
			}
		}
	}
	var dialogHeight="95vh";
	var dialogWidth="95vw";
	var dialogTop="0vh";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var enc_val= document.getElementById("temp2").value;
	var enc_temp= document.getElementById("enc_temp").value;
	var pat_temp= document.getElementById("pat_temp").value;
	var finalSelect1= document.getElementById("finalSelect1").value;


	if(enc_val==''){

		alert(getMessage("NO_SELECTION","MR")); 
		
	}else{
		retVal=await top.window.showModalDialog("../../eMR/jsp/DPRecodingFrames.jsp?fetchrecord="+fetchrecord+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1,arguments,features);
		document.getElementById("enc_temp").value="";
		document.getElementById("pat_temp").value="";

		if(retVal==undefined){
			var htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='mode' id='mode' value='RemoveSessionVals'></input></form></body></html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',htmlval);
			parent.frames[3].document.MRvalidate.submit();
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
			parent.frames[3].location.href = "../../eCommon/jsp/error.jsp";
		}
	}
}
async function closeWindowval(enc,patid,changefunc,Patient_Class){
	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function;
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "41vh";
	var dialogWidth = "65vw";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
}
function closeWin(enc,patid,changefunc,Patient_Class,call_function){
	showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function);
}
async function showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function,bl_install_yn){
	//var bl_install_yn=document.forms[0].bl_install.value;
	//var call_function = document.forms[0].call_function.value;
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "90vh";
	var dialogWidth = "70vw";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
	if(retVal!=null && retVal!='')

	parent.content.document.location.reload();
}

