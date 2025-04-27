function query() {
	query_criteria_frame.location.href ="../../eOP/jsp/QryCancelledOPVisits.jsp" ;
}

function reset() {
	frames[3].location.href="../../eCommon/jsp/error.jsp";
	frames[1].document.forms[0].reset();
	frames[1].document.forms[0].search_button.disabled=false;

	frames[2].location.href="../../eCommon/html/blank.html";

}

function clearqry() {
	parent.frames[1].document.query_criteria_form.search_button.disabled=false;

	parent.frames[2].location.href="../../eCommon/html/blank.html";
	
}

function chkfld(){

	var dateFrm=parent.frames[1].document.query_criteria_form.txtdtfrm.value;
	var dateTo=parent.frames[1].document.query_criteria_form.txtdtto.value;
	
		if(dateFrm!="" && dateTo!="")	 
		{
			if(isBefore(dateFrm,dateTo,'DMY',localeName)==false)
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
				parent.frames[1].document.forms[0].txtdtto.select();				
				return false;
			}
		} 

 	    if(dateFrm!="")
		dateFrm=convertDate(dateFrm,"DMY",localeName,"en");
		if(dateTo!="")
		dateTo=convertDate(dateTo,"DMY",localeName,"en");	
	
	var patid=parent.frames[1].document.query_criteria_form.txtpatid.value;	
	var serv=parent.frames[1].document.query_criteria_form.opservice.value;	
	var loc=parent.frames[1].document.query_criteria_form.oplocation.value;
	var pract=parent.frames[1].document.query_criteria_form.oppract.value;
	var spelty_code=parent.frames[1].document.query_criteria_form.speciality_code.value;
	
	var returnarray=loc.split("|");
	var locid=returnarray[0];
	returnarray=pract.split("|");
	var practid=returnarray[0];	
		
	parent.frames[1].document.query_criteria_form.search_button.disabled=true;

	var qrystr="date_from="+dateFrm+"&date_to="+dateTo+"&service_code="+serv+"&locn_code="+locid+"&pract_id="+practid+"&patient_id="+patid+"&splty_code="+spelty_code+"&srch=Y";
	parent.frames[2].location.href="../../eOP/jsp/QryCancelledOPVisitsResults.jsp?"+qrystr;
	
}

async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.query_criteria_form.txtpatid.value=pat_id;
}

// JS functions used in QPVCriteria.jsp

async function getValues(obj,target,targetId)
		{var locale=document.forms[0].locale.value
			var tit="";
			var facilityid =document.forms[0].facility_id.value;
			var dataNameArray  = new Array() ;
		     var dataValueArray = new Array() ;
		     var dataTypeArray  = new Array() ;
			var argumentArray=new Array(8);
			var sql="";
			var sqlSecond="";
			target.value=trimString(target.value);
			if(target.value=="" && window.event.target == target)
			{
				targetId.value="";
				return;
			}

			if(obj.name=="service_button")
			{
				tit=getLabel("Common.service.label","Common");

				argumentArray[0]="SELECT distinct service_code code, am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) description FROM   am_facility_service WHERE operating_facility_id = '"+facilityid+"' AND   eff_status =  'E' AND   UPPER(service_code) LIKE UPPER(NVL(?,service_code)) AND   UPPER(am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)) LIKE UPPER(NVL(?,am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)))";	
				
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else
			if(obj.name=="locn_button")
			{
				tit=getLabel("Common.Location.label","Common");;
				
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and language_id='"+locale+"' and eff_status ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else 
			if(obj.name=="speciality_button")
			{
				tit=getLabel("Common.speciality.label","Common");							

				argumentArray[0]="select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) description from AM_SPECIALITY where EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)))"; 

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else
			if(obj.name=="pract_button")
			{
				getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");			

				return;
			}
			var retVal=await CommonLookup(tit,argumentArray);
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal ==null || retVal=="")
			{
				target.value="";
				targetId.value="";
			}
			else
			{
				targetId.value=arr[0];
				target.value=arr[1];
			}
		}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null && trimString(retVal) != "")
	{
		arr=retVal.split("~");
		
		document.forms[0].oppract.value=arr[0];
		document.forms[0].oppract_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].oppract.value="";	
		document.forms[0].oppract_desc.value="";			
	}
}

function changeCase(Obj)
{
			Obj.value=Obj.value.toUpperCase();
}



