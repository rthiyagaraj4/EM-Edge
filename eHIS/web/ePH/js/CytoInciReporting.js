  //saved on 02.11.2005
var function_id	= "PH_CYTO_INCI_REPO" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;
var maxRec = 0  ;
var displaySize = 0 ;
var currClass="";
function create() { 
f_query_add_mod.location.href="../../ePH/jsp/PhCytoInciReportingDtls.jsp?function_id="+function_id+"&mode=MODE_INSERT";
}
function query() {
		f_query_add_mod.location.href="../../ePH/jsp/PhCytoInciQueryCriteriaFrames.jsp";
}
function reset() {
	var url = f_query_add_mod.location.href;
	if(url.indexOf('blank')!= -1){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	if(f_query_add_mod.document.forms[0]!=null && f_query_add_mod.document.forms[0].name=='PhCytoInciReportingForm'){
		f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.document.forms[0].spill.value=='O'){
			f_query_add_mod.document.getElementById("rmks").style.display='';

		}
		f_query_add_mod.location.reload();//Added for ICN_ADHOC_020
		/*if(f_query_add_mod.document.forms[0].locn_type.value=='N'){//Commented for ICN_ADHOC_020--start
			callLocation2('N')
		}else{
			callLocation2('C')
		}*///Commented for ICN_ADHOC_020--end
		messageFrame.location.href="../../eCommon/jsp/error.jsp";
		return;
	}
	else if(f_query_add_mod.frames[0]!=null && f_query_add_mod.frames[0].name=='f_query_criteria_search'){
			f_query_add_mod.location.reload();
			return;
	}
	else{	
		
		parent.reload();
	}

}


function assignResult( _result, _message, _flag ) {
	
	result = _result ;
	message  = _message ;
	flag = _flag ;

	
}
/* This apply function is called from the top frame button */
function apply(){
	var errors='';
	var flag='true';
	var flag1='true';
	var flag2='true';
	var strngth_vol='';
	var strength_wt='';
	if(f_query_add_mod.document.forms[0] ==null || f_query_add_mod.document.forms[0].name !='PhCytoInciReportingForm'){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	else{

		var frmObj=frames[1].document.forms[0];
		var mode=frames[1].document.forms[0].mode.value;
		flag=chkMandatary('apply');
		if(flag=='true'){
			strngth_vol=frmObj.volume.value;
			var strength_wt=frmObj.weight.value;
			if(strngth_vol=='' && strength_wt==''){
				flag1='false';

			}else{
				flag1='true';
			}

			var max=255;
		
			if(flag1=='true'){
				 if(frmObj.comment.value.length >max){ 
					flag2='false';
					alert(getMessage('COMMENT_ON_INSIDENT_CANNOT_EXCEED','PH')+" "+ max  +" "+ getLabel("ePH.characters.label","PH"));
					frmObj.comment.focus();
					
				}
				if(frmObj.other_remarks.value.length >max){
					flag2='false';
					alert(getMessage('SPILLAGE_REMARKS_CANNOT_EXCEED','PH') + " "+max  + " "+getLabel("ePH.characters.label","PH") );
					frmObj.other_remarks.focus();
					
				}if(frmObj.incident_desc.value.length >max){
					flag2='false';
					alert(getMessage('INCIDENT_REMARKS_CANNOT_EXCEED','PH') +" "+ max  + " "+getLabel("ePH.characters.label","PH") );
					frmObj.incident_desc.focus();
				}
			}
			if(flag1=='true' && flag2=='true'){
				eval(formApply(frames[1].document.forms[0],PH_CONTROLLER));
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+message;
					
						if( result ) {

						var print_confirm=confirm(getMessage("PH_INCI_REPO2", "PH"));
					
		
					if(print_confirm)
							{	
						var xmlStr ="<root><SEARCH ";
						xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
						xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
						xmlStr+= "p_language_id =\"" +frmObj.locale.value + "\" " ;
					
						xmlStr +=" /></root>";
					
						var temp_jsp="PhCytoInciReportingValidate.jsp?func_mode=getPrint";
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,true);
						xmlHttp.send(xmlDoc);
							}
						if(mode == "RENEW_ORDER" ){
						   //window.close()
						       var dialogTag = parent.parent.document.getElementById("dialog_tag");    
							dialogTag.close();  
						}
						else{
							onSuccess();
						}
					}
			}
			else{
				if(flag1=='false'){
					var err=getMessage("PH_INCI_REPO1","PH");
					frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+err;
					return;
				}else if(flag2=='false'){
					err='';
					frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+err;
					return;
				}
			}
		}
	}
}

async function callDrugSearch(obj) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.PhCytoInciReportingForm.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}

async function show_uesr_id_window(target,desc,user){
	var formObjDetail= parent.f_query_add_mod.document.PhCytoInciReportingForm;    
	var language_id=document.PhCytoInciReportingForm.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id;
	
	//argumentArray[0]   = "SELECT APPL_USER_ID CODE, APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER WHERE PIN_NO IS NOT NULL AND UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) AND LANGUAGE_ID = "+"'"+language_id+"'"; //Added by MOHE-SCF-0132
	argumentArray[0]   ="";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 
	argumentArray[12]  = "SQL_PH_CYTOINCIREORT_WITNESSEDBY_SELECT";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	retVal = await CommonLookup( user, argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(',');
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		target.value = arr[0];
		desc.value   = arr[1];
	}
}

function onSuccess(){
	f_query_add_mod.location.href="../../ePH/jsp/PhCytoInciReportingDtls.jsp";
}

function reloadPage() {
	f_query_add_mod.location.reload();
}

function ChkMaxLen(lab,obj,max,mode) {
	if(obj.value.length >= max) {
		alert(getMessage('INCIDENT_REMARKS_CANNOT_EXCEED','PH') +" "+ max +" "+ getLabel("ePH.characters.label","PH") );
		//obj.focus();
		obj.value="";
		obj.focus();
		return false;
	} 
	else return
		true;
}


function chkDate(dt_from,dt_to){ 
	if(!doDateCheckAlert(dt_from,dt_to)){
	}
}

function callFirst(str){
	    
	if(str=="Replaced"){
		var obj=parent.frames[1].PhCytoInciReportingForm.replace_dt;
		validateReplaceDate(obj);
	}
	if(str=="Checked"){
		var obj=parent.frames[1].PhCytoInciReportingForm.check_dt;
		validateCheckDate(obj);
	}
}


function validateIncidentDate(obj,locale){

	if(obj.value != ""){
		if(!validDate(obj.value,"DMYHM",locale)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			//obj.focus();
			obj.value="";
			obj.focus();
		}
	}

	if(obj.name=="inc_date"){
		if(obj.value != ""){
			if(validDate(obj.value,"DMYHM",locale)){
				if(!isBeforeNow(obj.value,"DMYHM",locale)){
					alert(getMessage("PH_INCI_REPO3","PH"));
					//obj.focus();
					//obj.select();
					obj.value="";
					obj.focus();
				}
			}
		}
	}
}

function validateReturnDate(obj,locale){

	var res_dt=parent.frames[1].PhCytoInciReportingForm.replace_dt;
	var check_dt=parent.frames[1].PhCytoInciReportingForm.check_dt;
	
	
	if(obj.value != ""){
		 if(!validDate(obj.value,"DMYHM",locale)){
			 alert(getMessage("INVALID_DATE_TIME","PH"));
		 }
	}
	if(obj.name=="return_dt"){
			if(obj.value != "" ){
					
				   if(!isBeforeNow(obj.value,"DMYHM",locale)){
					  alert(getMessage("PH_INCI_REPO4","PH"));
					  //obj.select();
					  obj.value="";
					  return true;
				    }

				
			}
		var err='';
		if(res_dt.value !="" && obj.value != "" ){
				if(!isBefore(obj.value,res_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO6","PH"));
				obj.value="";
				obj.focus();
				return true;
			}
	
		}
		var err='';
		if(check_dt.value !="" && obj.value != "" ){
			if(!isBefore(obj.value,check_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO9","PH"));
				obj.value="";
				obj.focus();
				return true;
			}	
		}
	}
	
}
function validateReplaceDate(obj){

	var ret_dt		=	parent.frames[1].PhCytoInciReportingForm.return_dt;
	var check_dt	=	parent.frames[1].PhCytoInciReportingForm.check_dt;
	var locale		=	parent.frames[1].PhCytoInciReportingForm.locale.value;
	if(obj.value != ""){
		
		 if(!validDate(obj.value,"DMYHM",locale)){
			 alert(getMessage("INVALID_DATE_TIME","PH"));
		 }
    }
	if(obj.name=="replace_dt"){
		if(obj.value != "" ){
			if(!isBeforeNow(obj.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO5","PH"));
				//obj.select();
				obj.value="";
				return true;
		   }			
		}
		var err='';
		if(ret_dt.value !="" && obj.value != "" ){
              if(!isBefore(obj.value,ret_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO6","PH"));
				obj.value="";
				obj.focus();
				return true;
			}

	
		}
		var err='';
		if(check_dt.value !="" && obj.value != "" ){
			if(!isBefore(obj.value,check_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO9","PH"));
				obj.value="";
				obj.focus();
				return true;
			}

	
		}
	}
	
}
function validateCheckDate(obj){
	var ret_dt=parent.frames[1].PhCytoInciReportingForm.return_dt;
	var rep_dt=parent.frames[1].PhCytoInciReportingForm.replace_dt;
	var locale=parent.frames[1].PhCytoInciReportingForm.locale.value;
	var inci_date=parent.frames[1].PhCytoInciReportingForm.inc_date.value;
	if(obj.value != ""){
		 if(!validDate(obj.value,"DMYHM",locale)){
		
			alert(getMessage("INVALID_DATE_TIME","PH"));
		}
    }

	if(obj.name=="check_dt"){
		if(obj.value != "" ){
             if(!isBeforeNow(obj.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO7","PH"));
				//obj.select();
				obj.value="";
				return true;
			}
			
		}
		var err='';
		if(ret_dt.value !="" && obj.value != "" ){
            if(!isBefore(obj.value,ret_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO8","PH"));
				//obj.select();
				obj.value="";
				obj.focus();
				return true;
			}	
		}
		
		var err='';
		if(rep_dt.value !="" && obj.value != "" ){
			if(!isBefore(obj.value,rep_dt.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REPO9","PH"));
				//obj.select();
				obj.value="";
				obj.focus();
				return true;
			}	
		}
		var err='';
		if(inci_date.value !="" && obj.value != "" ){
	        if(!isBefore(inci_date,obj.value,"DMYHM",locale)){
				alert(getMessage("PH_INCI_REP10","PH"));//PH_INCI_REP10
				//obj.select();
				obj.value="";
				obj.focus();
				return true;
			}	
		}
		
	}
	
}


function chkMandatary(str1)
{
var flag			   = 'true';
var errors				="";
var messageFrame	=	"";
var fields = new Array ();
var names = new Array ();
var i=0;
	messageFrame=frames[2];
	var formObj		   = frames[1].document.forms[0];

	
	
		if(formObj.drug_name.value==''){
			fields[i]=formObj.drug_name;
			names[i]=getLabel("Common.DrugName.label","Common");
			flag='false'
			i++;
		}
	
	
		if(formObj.location1.value==''){
			fields[i]=formObj.location1;
			names[i]=getLabel("Common.locationtype.label","Common");
			flag='false'
			i++;
		}
	
	
	
 		  if(formObj.inc_date.value==""){
			fields[i]=formObj.inc_date;
			names[i]=getLabel("ePH.DateofIncident.label","PH");
			flag='false'
			i++;
		  }

	
		  if(formObj.incident_desc.value==""){
			fields[i]=formObj.incident_desc;
			names[i]=getLabel("ePH.IncidentRemarks.label","PH");
			flag='false'
			i++;
		  }

    if(formObj.dosage_drug.value=="" ) {
			fields[i]=formObj.dosage_drug;
			names[i]=getLabel("ePH.DosageformofDrug.label","PH");
			 flag='false';
				i++;
	}
	 if(formObj.spill.value=="" ) {
			fields[i]=formObj.spill;
			names[i]=getLabel("ePH.CauseofSpill.label","PH");
			 flag='false';
				i++;
	}
	 if(formObj.rep_person_id.value=="" ) {
			fields[i]=formObj.rep_person_id;
			names[i]=getLabel("Common.ReportedBy.label","Common");
			 flag='false';
				i++;
	}
	
	if(formObj.spill.value=="O"){
		 if(formObj.other_remarks.value=="" ) {
			fields[i]=formObj.other_remarks;
			names[i]=getLabel("ePH.SpillageRemarks.label","PH");
			 flag='false';
				i++;
		}
	}
		
if(fields.length==0)
	{
	flag='true';
	return flag;
	}
	else{
	
		flag='false'
		for( var i=0; i<fields.length; i++ ) {
		 
		errors = errors + "APP-PH0045 " + names[i] +" "+ getLabel("Common.Cannotbeblank.label","Common") + "<br>" ;
	}
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		return flag;
	}
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] +" "+ getLabel("Common.Cannotbeblank.label","Common") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function validate_date(Obj,ref) {
                

	if (CheckDate(Obj))
	{
	if(ref == "FROM_DATE_LESS_SYSDATE" )
	{
	  
	    error_id = getMessage('FROM_DATE_LESS_SYSDATE','PH');
	    	    	    		
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].enq_date_to;
	  to = document.forms[0].enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].respond_date_to;
	  to = document.forms[0].respond_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].enq_date_to;
	  to = document.forms[0].enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	}
	else if(ref == "TO_DATE_LESS_FROM1")
	{
	  from = document.forms[0].respond_date_to;
	  to = document.forms[0].respond_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	}

	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			from.value="";
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
		       return true;
		      } 
	}
	return true;
}
}


function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                //to.select();
				to.value="";
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
function callDosage(obj){
}


function serDefault(){
	var locn_code=f_query_add_mod.document.forms[0].locn_code.value;
	var ee =f_query_add_mod.document.forms[0].location1.options.length;
var tt=f_query_add_mod.document.forms[0].location1;
for(var i=0;i<ee;i++){
	if(tt.options(i).value==locn_code){
		f_query_add_mod.document.forms[0].location1.selectedIndex=i;
	}
}
}
function callSpill(obj){
	
	if(obj.value=="O"){
		parent.frames[1].document.getElementById("rmks").style.display='';
		
		
	}else{
		parent.frames[1].document.getElementById("rmks").style.display='none';
		
	}
}



function checkForZero(obj){
	if(parseFloat(obj.value) == 0){
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
		obj.select();
	}
}

function showDetails(obj){
	var Seq_no=obj;


parent.parent.frames[1].location.href="../../ePH/jsp/PhCytoInciReportingDtls.jsp?Seq_no="+Seq_no	;

	
}

function clearDesc(Obj){
	if(Obj.name=='check_person_id' && Obj.value==""){
		parent.frames[1].document.forms[0].check_person_name.value='';
	}
	if(Obj.name=='rep_person_id' && Obj.value==""){
		parent.frames[1].document.forms[0].rep_person_name.value='';
	}
	if(Obj.name=='witness_id' && Obj.value==""){
		parent.frames[1].document.forms[0].witness_name.value='';
	}
}



async function lookUpLocation(obj){
var sql="";
var repositoryKey="";

if(obj.value=="C")
	{
	// sql="SELECT CLINIC_CODE CODE, LONG_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE EFF_STATUS='E' AND CLINIC_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) AND FACILITY_ID =";
	 repositoryKey="SQL_PH_CYTOINCIREORT_CLINIC_SELECT";
	}else if(obj.value=="N"){
	 //sql="SELECT NURSING_UNIT_CODE  CODE, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW  WHERE EFF_STATUS='E' and NURSING_UNIT_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)and FACILITY_ID =";
	 repositoryKey="SQL_PH_CYTOINCIREORT_NURSING_SELECT";
	}else if(obj.value=="P"){
	 //sql="SELECT DISP_LOCN_CODE CODE, SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' AND DISP_LOCN_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) and facility_id ="; 
	 repositoryKey="SQL_PH_CYTOINCIREORT_DISP_SELECT";
	}

var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

var parNameArray  = new Array() ;
var parValueArray  = new Array() ;
var FACILITY_ID=document.PhCytoInciReportingForm.facility_id.value;
var LANGUAGE_ID=document.PhCytoInciReportingForm.locale.value;

parNameArray[0] ="~FACILITY_ID`";
parNameArray[1] ="~LOCALE_ID`";
parValueArray[0]=FACILITY_ID;
parValueArray[1]=LANGUAGE_ID;
	


	//argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and language_id="+"'"+LANGUAGE_ID+"' "+"order by 2"; //Modified for MOHE-SCF-0132
	argumentArray[0] ="";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = document.PhCytoInciReportingForm.location.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	
	argumentArray[12] =repositoryKey;
	argumentArray[13] ="ePH.Common.PhRepository";
	argumentArray[14] =parNameArray;
	argumentArray[15] =parValueArray;
	retVal = await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(',');
		if(retVal != null && retVal != "") {
		document.PhCytoInciReportingForm.location.value = arr[1];
		document.PhCytoInciReportingForm.location1.value=arr[0];
	}


}

function LocationDisabled(obj){
document.PhCytoInciReportingForm.location.value="";
document.PhCytoInciReportingForm.location1.value="";
if (obj.value!="")
{
document.PhCytoInciReportingForm.location.disabled=false;
document.PhCytoInciReportingForm.location_desc.disabled=false;
}else{
document.PhCytoInciReportingForm.location.disabled=true;
document.PhCytoInciReportingForm.location_desc.disabled=true;
}

}

function LocationQueryDisabled(obj){
document.formPhCytoInciReportCriteria.locations.value="";
document.formPhCytoInciReportCriteria.location1.value="";
if (obj.value!="")
{
document.formPhCytoInciReportCriteria.location_desc1.disabled=true;
document.formPhCytoInciReportCriteria.location1.disabled=true;
}else{
document.formPhCytoInciReportCriteria.location_desc1.disabled=true;
document.formPhCytoInciReportCriteria.location1.disabled=true;
}

}

async function lookUpLocationQuery(obj){
var sql="";

if(obj.value=="C")
	{
	 sql="SELECT CLINIC_CODE CODE, LONG_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE EFF_STATUS='E' AND CLINIC_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) AND FACILITY_ID =";
	}else if(obj.value=="N"){
	 sql="SELECT NURSING_UNIT_CODE  CODE, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW  WHERE EFF_STATUS='E' and NURSING_UNIT_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)and FACILITY_ID =";
	}else if(obj.value=="P"){
	 sql="SELECT DISP_LOCN_CODE CODE, SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' AND DISP_LOCN_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) and facility_id ="; 
	}

var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;
var FACILITY_ID=document.formPhCytoInciReportCriteria.facility_id.value;
var LANGUAGE_ID=document.formPhCytoInciReportCriteria.locale.value;

	argumentArray[0]   =sql+"'"+FACILITY_ID+"'"+" and language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = document.formPhCytoInciReportCriteria.location1.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
		if(retVal != null && retVal != "") {
		document.formPhCytoInciReportCriteria.location1.value = arr[1];
		document.formPhCytoInciReportCriteria.locations.value=arr[0];
	}


}
