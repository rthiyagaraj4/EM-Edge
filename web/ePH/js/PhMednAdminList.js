 //saved on 02.11.2005
function run() {
	
	var frmObject = f_query_add_mod.document.formPhMednAdminListCriteria;
	if(f_query_add_mod.document.formPhMednAdminListCriteria) {
		
	
		if(frmObject.site.value == "true"){
		
			var fields= new Array (frmObject.dt_from1,frmObject.dt_to1, frmObject.locn_type,frmObject.locn_name);
			var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"));
			if(f_query_add_mod.checkFields(fields,names,messageFrame) ) {
				ValidDateTime(frmObject.dt_from1,frmObject.dt_to1);
				frmObject.dt_from.value = convertDate(frmObject.dt_from1.value,'DMYHM',frmObject.p_language_id.value,'en');
				frmObject.dt_to.value= convertDate(frmObject.dt_to1.value,'DMYHM',frmObject.p_language_id.value,'en');
				f_query_add_mod.document.formPhMednAdminListCriteria.submit();
		}
		}
		else{
			
				var fields= new Array (frmObject.dt_from1,frmObject.dt_to1, frmObject.locn_type,frmObject.locn_name,frmObject.group_by); 	
			    var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"),getLabel("Common.groupby.label","Common"));

				if(f_query_add_mod.checkFields(fields,names,messageFrame) ) {
						ValidDateTime(frmObject.dt_from1,frmObject.dt_to1);
						frmObject.dt_from.value = convertDate(frmObject.dt_from1.value,'DMYHM',frmObject.p_language_id.value,'en');
						frmObject.dt_to.value= convertDate(frmObject.dt_to1.value,'DMYHM',frmObject.p_language_id.value,'en');
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhMednAdminListCriteria.submit();
				}
		}
	}
}

function reset() {
/*	searchFrame.formPhRepDrugsByGenName.reset();*/
    f_query_add_mod.formPhMednAdminListCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage()	{

  var result	=	false;
  frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from1;
  to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to1;
  msg_frame		=	messageFrame;

  if(doDateCheck(frm_obj,to_obj,msg_frame) )		 {
      result	=	true;
	 }
	else
	 {
	  result  = false;
	  }
	 alert(result);
return result;
}


async function searchCode( target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] = f_query_add_mod.document.formPhMednAdminListCriteria.SQL_PH_MED_ADMIN_SELECT2.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray = await CommonLookup( "Nursing Unit", argumentArray );

	if(retArray != null && retArray != "" ) {
		target.value = retArray[0];	/* if code need to be returned */
		target.focus();
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ADM_WARN"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(to.value!="")
	  {
		if(!doDateTimeChk(to))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
			}
		else
		if(!ValidateDateTime(from,to)) {
			alert("Should be Greater than Current Time");
			to.select();
			result	=	false;
		}
		else
		{
			if(!ValidateDateTime(to,en)) {
				alert("Should be Less than Sysdate ");
				to.select();
				result	=	false;
			}
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(to.value!="" && from.value != "")
	  {
		if(!doDateTimeChk(to)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
			}
		else if(!doDateTimeChk(from))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			from.focus;
			}else 
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than From Time");
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}
	  }
return result;
}


function doDateChk(obj)
        {
			if(obj.value != ""){
            if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
            {
                retval= false
				alert(getMessage("INVALID_DATE_TIME","PH"))
                obj.focus()
            }
            else
            {
                var comp=obj
                obj=obj.value
                var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]

                    if(!checkDt(dt) )
                    {
                        retval= false
						alert(getMessage("INVALID_DATE_TIME","PH"))
                        comp.focus()
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            alert(getMessage("INVALID_DATE_TIME","PH"))
                            retval= false;
                            comp.focus()
                        }

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME","PH"))
                                    comp.focus()
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME","PH"))
                    comp.focus()
                }

                if(retval)
                {
                    //callDateFunction(comp)
                }
            }
            return retval
        }
		}
function ValidDateTime(from,to)
{
	from1 = from.value
    to1      = to.value
    if(from1 !="" && to1 != ""){
	var a=  from1.split(" ")
    splitdate=a[0];
    splittime=a[1]
    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to1.split(" ")
    splitdate=a[0];
    splittime=a[1]
     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(to_date) < Date.parse(from_date))
    {
		 alert(getMessage("TO_DT_GR_EQ_FM_DT", "PH"));//modified 
			to.select();
			to.focus();//modified
			return false;//modified
		//parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT", "PH")
     //  to.select();
    }
    else
        return true;
	}
}


// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhMednAdminListCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMYHM',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMYHM',locale,'en');
	}
}
//Added for scf ML-BRU-SCF-0498 [IN:035593]  -- begin
function resetLocation(){
	var formObj = document.formPhMednAdminListCriteria;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
	site=formObj.site.value;
	if(formObj.site.value == "false"){//if condtion added for ghl-crf-0458
	formObj.group_by.options.length=1;
	}
	if(formObj.locn_type.value=="C"){
		formObj.bed_from.value="";
		formObj.bed_to.valu="";
		formObj.bed_from.style.visibility="hidden";
		formObj.bed_to.style.visibility="hidden";
		document.getElementById('lbl_from_bed').style.visibility="hidden";
		document.getElementById('lbl_to_bed').style.visibility="hidden";
		if(formObj.site.value == "false"){//if condtion added for ghl-crf-0458
			var optn = document.createElement("OPTION");
			optn.text = getLabel("ePH.AdminTime.label","PH");
			optn.value = "A";
			formObj.group_by.options.add(optn);
		}
		
	}else{
		formObj.bed_from.style.visibility="visible";
		formObj.bed_to.style.visibility="visible";
		document.getElementById('lbl_from_bed').style.visibility="visible";
		document.getElementById('lbl_to_bed').style.visibility="visible";
		var optn = document.createElement("OPTION");
		optn.text = getLabel("Common.bedno.label","Common");
		optn.value = "B";
		if(formObj.site.value == "false"){//if condtion added for ghl-crf-0458
		formObj.group_by.options.add(optn);
		var optn = document.createElement("OPTION");
		optn.text = getLabel("ePH.AdminTime.label","PH");
		optn.value = "A";
		formObj.group_by.options.add(optn);
		}
	}
}

async function locationLookup(target){
	var formObj = document.formPhMednAdminListCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
				formObj.locn_code.value=arr[0];
				target.value = arr[1] ;;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
//Added for scf ML-BRU-SCF-0498 [IN:035593] -- end

function Duplicatecheck(){
	var formObj = document.formPhMednAdminListCriteria;
	var patientId = formObj.p_patient_id.value; 
	var	bean_id			= "PHReportsBean";
	var	bean_name		= "ePH.PHReportsBean";
	if((patientId != null) && (patientId !="")){
		//var	bean_id			= formObj.bean_id.value;
		//var	bean_name		= formObj.bean_name.value;
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;		
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}		
} 

async function callPatientSearch(){
	var formObj = document.frames.formPhMednAdminListCriteria;
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
	}
}

function dateDifference(obj){
	var result	=	true;
	var formObj = document.formPhMednAdminListCriteria;
	var max_days=daysBetween(formObj.dt_from1.value,formObj.dt_to1.value,"DMYHM",formObj.p_language_id.value);
	
	 if(max_days>90){
	
	var errors=getMessage('PH_DATE_RANGE_90','PH');
	alert(errors);
	obj.select();
	obj.focus();
	result = false;
}
}
