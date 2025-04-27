
function query() {
	query_criteria_frame.location.href ="../../eOP/jsp/QPVmain.jsp" ;
}

function reset() {
	frames[2].location.href="../../eCommon/jsp/error.jsp";
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[0].document.forms[0].search_button.disabled=false;

	frames[1].frames[1].location.href="../../eCommon/html/blank.html";

}

function clearqry() {
	// parent.frames[0].document.query_criteria_form.search_button.disabled=false;
	parent.query_frame.document.query_criteria_form.search_button.disabled=false;

	// parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.result_frame.location.href="../../eCommon/html/blank.html";
	
}

/*function ValidateDateFrom2(date)
{
	//alert(date);
	document.forms[0].txtdtfrm1.value=date;
}

function ValidateDateFrom(flag)
{
if(flag==true)
	{
	
	date_from=document.forms[0].txtdtfrm.value
	var dteFrom=DateUtils.convertDate(date_from,"DMY",localeName,"en",ValidateDateFrom2);	
	}
}


function ValidateDateTo2(date)
{
	document.forms[0].txtdtto1.value=date;
}

function ValidateDateTo(flag)
{
if(flag==true)
	{
	date_to=document.forms[0].txtdtto.value
	var dteTo=DateUtils.convertDate(date_to,"DMY",localeName,"en",ValidateDateTo2);
	
	}
}*/

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

function chkfld(){

	if(parent.frames[0].document.query_criteria_form.created_by.value == "")
		parent.frames[0].document.query_criteria_form.user.value="";

	var dateFrm=parent.frames[0].document.query_criteria_form.txtdtfrm.value;
	var dateTo=parent.frames[0].document.query_criteria_form.txtdtto.value;
	
		if(dateFrm!="" && dateTo!="")	 
		{
			if(isBefore(dateFrm,dateTo,'DMY',localeName)==false)
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
				parent.frames[0].document.forms[0].txtdtto.select();				
				return false;
			}
		} 

 	    if(dateFrm!="")
		dateFrm=convertDate(dateFrm,"DMY",localeName,"en");
		if(dateTo!="")
		dateTo=convertDate(dateTo,"DMY",localeName,"en");
	
	/*if(!CheckDate(parent.frames[0].document.query_criteria_form.txtdtfrm)) return false;
	if(!CheckDate(parent.frames[0].document.query_criteria_form.txtdtto)) return false;
	if(!doDateCheckAlert(parent.frames[0].document.query_criteria_form.txtdtfrm,parent.frames[0].document.query_criteria_form.txtdtto)) 
	{
		var err = getMessage('TO_DT_GR_EQ_FM_DT','SM');
		alert(err);
		return false;
	}*/
	
	var patid=parent.frames[0].document.query_criteria_form.txtpatid.value;
	var mrnno=escape(parent.frames[0].document.query_criteria_form.txtmrn.value);
	var openEpisode='N';
	if(parent.frames[0].document.query_criteria_form.openEpisode.checked)
		openEpisode ='Y';
	else
		openEpisode='N';
		
	//var dtfrm=parent.frames[0].document.query_criteria_form.txtdtfrm1.value;
	//var dtto=parent.frames[0].document.query_criteria_form.txtdtto1.value;
	var serv=parent.frames[0].document.query_criteria_form.opservice.value;
	//alert(serv);
	var loc=parent.frames[0].document.query_criteria_form.oplocation.value;
	var pract=parent.frames[0].document.query_criteria_form.oppract.value;
	var user_id=parent.frames[0].document.query_criteria_form.user.value;
	var episode_id=parent.frames[0].document.query_criteria_form.episode_no.value;
	var speciality_id=parent.frames[0].document.query_criteria_form.speciality_code.value;
	
	var returnarray=loc.split("|");
	var locid=returnarray[0];
	returnarray=pract.split("|");
	var practid=returnarray[0];
	var msg="";
	if( (patid == "") && (mrnno == "")) {
		msg=getMessage('PAT_MRN_ENC_BLANK','OP');
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}else
       parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		
	parent.frames[0].document.query_criteria_form.search_button.disabled=true;

	var qrystr="blnk=N&patid="+patid+"&mrnno="+mrnno+"&openEpisode="+openEpisode+"&dtfrm="+dateFrm+"&dtto="+dateTo+"&serv="+serv+"&loc="+locid+"&pract="+practid+"&user_id="+user_id+"&episode_id="+episode_id+"&speciality_id="+speciality_id+"&srch=Y";
	parent.frames[1].location.href="../../eOP/jsp/QPVresult.jsp?"+qrystr;
	
}

function populateClinic(serv_code) {
	HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/QPVrepopClinic.jsp?serv_code="+serv_code+"'></form></BODY></HTML>";
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.form1.submit();
}

function populatePract(practlist) {
	var strpractyn="";
	var strpracttype="";
	var strclncode="";
	var strFldArray = new Array();

	if (practlist.length != 0) {
		strFldArray = practlist.split("|");
		strclncode = strFldArray[0];
		strpractyn = strFldArray[1];
		strpracttype = strFldArray[2];
	}
	HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/QPVrepopPract.jsp?cln_code="+strclncode+"&pract_yn="+strpractyn+"&pract_type="+strpracttype+"'></form></BODY></HTML>";
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.form1.submit();
}


async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[0].document.query_criteria_form.txtpatid.value=pat_id;
}

async function patvisit() {
	var retVal;
	var dialogHeight= "33" ;
	var dialogWidth	= "50" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eOP/jsp/PaintSearchVisit.jsp",arguments,features);
	if(retVal != null){
		if(retVal == "close")
		retVal="|";
		returnarray=retVal.split("|");

		var j1=returnarray[1];
		var j2=returnarray[0];
		parent.frames[0].document.query_criteria_form.txtenctid.value=j2;
	}
}
function dispvisit(params,episode_id,service_code) {
	var arr = episode_id.split("$");
	var fr_epi_id = arr[0];
	var to_epi_id = "";
	if (arr[1]!=null)
		to_epi_id = arr[1];
	//parent.parent.frames[0].frames[1].document.getElementById("visit_tab").src = '../../eOP/images/Visits.gif';
	//parent.parent.frames[0].frames[1].document.getElementById("episode_tab").src = '../../eOP/images/Episodes_click.gif';
	var source="../../eOP/jsp/QPVvisits.jsp?"+params+"&fr_epi_id="+fr_epi_id+"&to_epi_id="+to_epi_id+"&service_code="+service_code;
	parent.parent.frames[1].location.href=source;
}
function dispnotes(episode_id) {
	parent.frames[1].location.href="../../eOP/jsp/QPVepisodenotes.jsp?episode_id="+episode_id;
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
          argumentArray[0]="SELECT distinct  service_code code, am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) description FROM   am_facility_service WHERE   operating_facility_id = '"+facilityid+"' AND   eff_status =  'E' AND   UPPER(service_code) LIKE UPPER(NVL(?,service_code)) AND   UPPER(am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)) LIKE UPPER(NVL(?,am_get_desc.AM_SERVICE(service_code,'"+locale+"`',2)))"
				//argumentArray[0]="select service_code code, service_short_desc description from am_facility_service_vw where operating_facility_id like ? and eff_status like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(service_short_desc) like upper(nvl(?,service_short_desc)) ";

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
				
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and language_id='"+locale+"' and level_of_care_ind ='A' and eff_status ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))  ";
				
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

				/*sql="SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facilityid+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'";
				

				 sqlSecond = "SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facilityid+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'";				 

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + target.name + "\"";
				xmlStr += " practName_FValue=\"" + encodeURIComponent(target.value) + "\"";
				xmlStr += " sql=\"" +escape(sql)+"\"";
				xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
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
				
				eval(responseText);
				*/

				return;
			}
			var retVal= await CommonLookup(tit,argumentArray);
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

function callPline()
{
	var params1=parent.document.forms[0].params1.value;
	parent.frames[0].location.href="../../eOP/jsp/QPVpline.jsp?"+params1;
}
function changeCase(Obj)
		{
			Obj.value=Obj.value.toUpperCase();
		}
// JS functions used in QPVimgtabs.jsp

function tab_click(objName,params)
{
	//var episode_no = document.forms[0].episode_no.value;
	//alert(episode_no);
	selectTab(objName)
    // FIRST CHANGE THE CURRENT SELECTED TAB
    var error = "";
    if (objName == "visit_tab")
    {
      
		// changeTab(objName);
        var source="../../eOP/jsp/QPVvisits.jsp?"+params;
		parent.parent.frames[1].location.href=source;
    }
    else if (objName == 'episode_tab')
    {
        // changeTab(objName);
        var source="../../eOP/jsp/QPVepisode.jsp?"+params;
        parent.parent.frames[1].location.href=source;
    }
}

function changeTab(TabName) {
if (tabopt_form.ct_tab_name.value=="addvisit_tab")
    currentTab = tabopt_form.ct_tab_name.value;
    tabopt_form.ct_tab_name.value = "";
// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
    if (currentTab == 'visit_tab') {
        document.getElementById("visit_tab").src = '../images/Visits_click.gif';
        document.getElementById("episode_tab").src = '../images/Episodes.gif';
    }
    else if (currentTab == 'episode_tab') {
        document.getElementById("visit_tab").src = '../images/Visits.gif';
        document.getElementById("episode_tab").src = '../images/Episodes_click.gif';
    }

// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

    if (TabName == 'visit_tab') {
        document.getElementById("visit_tab").src = '../images/Visits.gif';
        document.getElementById("episode_tab").src = '../images/Episodes_click.gif';
    }
    else if (TabName == 'episode_tab') {
        document.getElementById("visit_tab").src = '../images/Visits_click.gif';
        document.getElementById("episode_tab").src = '../images/Episodes.gif';
    }

// FINALLY SET THE CURRENT TAB TO THE PASSED PARAMETER
    currentTab = TabName;
}


function GetCancellLookupBlur(target)
{
	if(target.value != "")
	{
		GetCancellLookup(target);
	}
}
async function GetCancellLookup(target){

	var sql="";
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.Createdby.label",'Common');
	sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=document.forms[0].created_by.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].created_by.value=arr[1];
		document.forms[0].user.value=arr[0];
		
	
	}
	else
	{
		document.forms[0].created_by.value="";
		document.forms[0].user.value="";
	}

}

