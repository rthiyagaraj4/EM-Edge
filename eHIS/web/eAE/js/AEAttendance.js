
function query()
 {
		 f_attendanceCriteria.location.href ="../../eAE/jsp/AEQueryAttendance.jsp" ;
 }
function reset() 
  {
	clear(); 
	f_attendanceCriteria.document.forms[0].reset() ;
	f_attendanceCriteria.document.forms[0].search.disabled= false;
  } 

 
function	clear()
{
		f_attendanceCriteria.document.forms[0].search.disabled= false;
		//f_attendanceCriteria.document.forms[0].ae_attd_datefrom.value='';
		//f_attendanceCriteria.document.forms[0].ae_attd_dateto.value='';
		//f_attendanceCriteria.document.forms[0].ae_attd_location_desc.value='';
		//f_attendanceCriteria.document.forms[0].ae_attd_location.value='';
		f_attendanceResult.location.href="../../eCommon/html/blank.html" ;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
		//commontoolbarFrame.document.forms[0].reset.disabled=true;
	
}

 function callSearch(ae_attd_datefrom,ae_attd_dateto,ae_attd_location,messageFrame)
	{
			 if(f_attendanceCriteria.AEQueryAttendanceForm.ae_attd_datefrom.value=='' )
		      { 
				alert(getMessage("FROM_DATE_CANNOT_BE_BLANK",'SM'));
				
			    f_attendanceCriteria.AEQueryAttendanceForm.ae_attd_datefrom.focus();
				f_attendanceResult.location.href="../../eCommon/html/blank.html" ;
			    return false;
		      }
			  if(f_attendanceCriteria.AEQueryAttendanceForm.ae_attd_dateto.value=='' )
		      {
			    alert(getMessage("TO_DT_NOT_BLANK",'SM'));
			    f_attendanceCriteria.AEQueryAttendanceForm.ae_attd_dateto.focus();
			    f_attendanceResult.location.href="../../eCommon/html/blank.html" ;
			    return false;
		      }
			if(isBefore(ae_attd_datefrom.value,ae_attd_dateto.value,"DMY",localeName))
			{
				f_attendanceCriteria.document.forms[0].search.disabled= true;
				var sql_query=constructQuery(ae_attd_datefrom,ae_attd_dateto,ae_attd_location);
				f_attendanceResult.location.href="../../eAE/jsp/AEResultAttendance.jsp?sql_query="+sql_query;
				messageFrame.location.href="../../eCommon/jsp/error.jsp" ; // 18330 Wednesday, January 20, 2010
			}
			else
			{

					var error=error=getMessage('TO_DT_GR_EQ_FM_DT','SM');
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
					f_attendanceResult.location.href="../../eCommon/html/blank.html" ; // 18330 Wednesday, January 20, 2010
					return false;
			}
		
	}

function checkFieldsLocal( fields, names, messageFrame) 
{
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$', names[i]);
			errors = errors + err + "<br>" ;
		}
    }
    return errors ;
}

	function constructQuery(ae_attd_datefrom,ae_attd_dateto,ae_attd_location)
	{
		var sql_query=' ';
        var andCheck	=	0;            
		
	

		if( ! ((trimCheck(ae_attd_location.value)) == false ))
		{
			sql_query	=' and locn_code = ' +'\''+ae_attd_location.value+'\' ';
		}

		//if( (trimCheck(ae_attd_datefrom.value) == true) && (trimCheck(ae_attd_dateto.value) == true)  )
		{
		sql_query	= sql_query + "	and trunc(queue_date) between trunc(to_date(nvl('"+convertDate(ae_attd_datefrom.value,"DMY",localeName,"en")+"','1/1/1111'),'dd/mm/yyyy')) and trunc(to_date(nvl('"+convertDate(ae_attd_dateto.value,"DMY",localeName,"en")+"','9/9/9999'),'dd/mm/yyyy')) ";
		}
		/*else if((trimCheck(ae_attd_datefrom.value) == true) )
		{
			//sql_query = sql_query + ' and to_char(visit_adm_date_time,\'dd/mm/yyyy\') =\''+ae_attd_datefrom.value +'\'';

		}
		else if( (trimCheck(ae_attd_dateto.value) == true) )
		{
			sql_query = sql_query + ' and to_char(visit_adm_date_time,\'dd/mm/yyyy\') =\''+ae_attd_dateto.value +'\'';
		}*/
		//else {}


		

		return sql_query;
	}
	
	async function CallLocationLookup()
{
	var facility_id="";
	var msg="";
	facility_id=document.forms[0].facilityId.value;
		
	var target				= document.forms[0].ae_pat_history_location_desc;
	var retVal				= new String();
	var dialogTop			= "55vh";
	var dialogHeight		= "60vw" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select distinct clinic_code,clinic_desc from ae_tmt_area_for_clinic_vw where 	facility_id="+facility_id;

	search_code="clinic_code";
	search_desc="clinic_desc";
	tit=encodeURIComponent(getLabel("Common.locationcode.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null)
	{
		var retVal=unescape(retVal);
		if(retVal != null)
		{
			arr=retVal.split("::");
			//document.forms[0].ae_attd_location_desc.value=arr[0];
			document.forms[0].ae_attd_location.value=arr[1];
			//document.forms[0].ae_attd_location_desc.focus();
		}
	}
	else
	{
		target.focus();
	}

}

function disReset()
{
	parent.frames[0].document.getElementById("reset").disabled= true;
		
}

function disReset()
{
	parent.frames[0].document.getElementById("reset").disabled= true;
	
}
async function CallViewPatDetails(patient_id,encounter_id,facilityId)
{
	        var url			= "../../eAE/jsp/AEPatientValuablesDetails.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id+"&facilityId="+facilityId;
			var dialogHeight= "55vh" ;
			var dialogWidth	= "55vw" ;
			var dialogTop ="75";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=auto; status:" + status;
			var returnval = await window.showModalDialog( url, arguments, features ) ;
			//parent.window.close();
			parent.parent.document.getElementById("dialog_tag").close();			
}

  function onMMove(obj,e,patient_valuables)
	{
		var patient_valuables;
		obj.style.left=e.x+20;
		obj.style.top=e.y;
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;
		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+patient_valuables+"</td></tr></table>";
	}
   function onMOut(obj)
	{
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
	}

	function cancelOperation()
    {
	//parent.window.returnValue = "";
	//parent.window.close();
	parent.parent.document.getElementById("dialog_tag").close();
   }

   function checkDate(obj){	
		if(obj.value!="") {
			 if((!isBeforeNow(obj.value,'DMY',localeName))) 	{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"))
				//obj.select();
				obj.value="";
				return false;
			 }
		}
}
