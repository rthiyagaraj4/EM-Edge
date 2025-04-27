
function apply()
{

	var to_proceed=true;

		var fields = new Array ( frames[1].document.forms[0].mrd_code,frames[1].document.forms[0].inactive_code,frames[1].document.forms[0].lost_code,frames[1].document.forms[0].auto_track_narr_code);
		var inact_fs_loc=getLabel("Common.Inactive.label","Common")+ " " + getLabel("eFM.FSLocation.label","FM");
		var lost_fs_loc = getLabel("Common.Lost.label","common")+ " " + getLabel("eFM.FSLocation.label","FM");
		var nam_ele4=getLabel("eFM.Narration.label","FM")+ " " + getLabel("Common.for.label","common")+ " " + getLabel("eFM.AutoTrackouttoOPD.label","FM");
		
		var names = new Array ( getLabel("eFM.PermanentFSLocation.label","FM"), inact_fs_loc, lost_fs_loc, nam_ele4);	
		
		/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
		var isRefreshIntervalAvailable	= frames[1].document.forms[0].isRefreshIntervalAvailable.value;
		if(isRefreshIntervalAvailable=='true'){
			fields.push(frames[1].document.forms[0].issue_file_refresh_interval);
			names.push(getLabel("eFM.RefreshIntervalforIssuefile.label","FM"));
		}
		/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
		
		var errors = "";

	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else
		{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>";// "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors=errors.replace('$',names[i]);
		}

	}
	if ( errors.length != 0 ) 
	{

 
      frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}
	if (to_proceed==true)
	{
		frames[1].document.forms[0].autotrack_upon_confirm_pl_yn.disabled = false;
		frames[1].document.forms[0].enable_Monitor_FDefFSL_yn.disabled = false;
		frames[1].document.forms[0].dflt_incomplete_fs_locn_code.disabled = false;
		frames[1].document.forms[0].submit();
	}
}

function reset()
{
	frames[1].location.reload();
}

function onSuccess()
{
	frames[1].location.reload();
}

function CheckNumber(obj) {
    var strCheck = '0123456789';
  		if ( obj.value.length > 0 ) {
			for(var i=0;i<=obj.value.length;i++) {
				if (strCheck.indexOf(obj.value.charAt(i)) == -1){
					alert(getMessage("NUM_ALLOWED","SM"));
					obj.select();
					obj.focus();
					return false;
					break;
				}
			}
  		}

}


function checkbox_value(obj)
	{
		if (obj.checked == true)
		{
			obj.value='Y';
		}
		else
		{
			obj.value='N';
		}
	}
/*Above Function Added for this CRF [SKR-CRF-0012]*/
function chkAutoPatFile(obj)
   {
      if(obj.checked==true)
       {

			obj.checked=true;
			obj.value='Y';
       }
      else
      {
          obj.checked=false;
		   obj.value='N';
		   

       }
   } 	
//End CRF [SKR-CRF-0012]	
function chkValue(obj)
   {
      if(obj.checked==true)
       {

			obj.checked=true;
			obj.value='Y';
			document.forms[0].dflt_incomplete_fs_locn_code.disabled=true;
			document.forms[0].dflt_incomplete_fs_locn_code.value='';
			//ClearList(document.forms[0].dflt_incomplete_fs_locn_code);

       }
      else
      {

           obj.checked=false;
		   obj.value='N';
		   document.forms[0].dflt_incomplete_fs_locn_code.disabled=false;

       }
   } 

function ClearList(object)
{
	if (object)
	var length  =object.length;
  	
    for(i=1;i<length;i++)
		object.remove(1);
}

function ClearIncomplFSLoc()
{
	var enableMonitor = document.forms[0].enable_Monitor_FDefFSL_yn.value;

    if (document.forms[0].enable_Monitor_FDefFSL_yn.checked==true)
    {
		document.forms[0].dflt_incomplete_fs_locn_code.disabled=true;
		document.forms[0].dflt_incomplete_fs_locn_code.value='';
    }
	else 
	{
		document.forms[0].dflt_incomplete_fs_locn_code.disabled=false;
	}
	if (document.forms[0].dflt_incomplete_fs_locn_code.value)
	{
		 document.forms[0].enable_Monitor_FDefFSL_yn.checked=false;
		 document.forms[0].enable_Monitor_FDefFSL_yn.disabled=true;
	}else
	{
		 document.forms[0].enable_Monitor_FDefFSL_yn.disabled=false;
	}
}

function disableMonitorFileDef(Obj)
{
	if (Obj.value !='')
	{
		document.forms[0].enable_Monitor_FDefFSL_yn.disabled = true;
		document.forms[0].enable_Monitor_FDefFSL_yn.checked = false;
		document.forms[0].enable_Monitor_FDefFSL_yn.value='N';
	}
	else
	{
	     document.forms[0].enable_Monitor_FDefFSL_yn.disabled = false;
	}
}
/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 Start */
function checkvalid(obj){
	if(!(obj.value >=5 ))
	{
		var error = getMessage("DATE1_LT_DATE2","OP");
		error = error.replace("$",getLabel("eFM.RefreshIntervalforIssuefile.label","FM"));
		error = error.replace("#","5 minutes");
		alert(error);		
		obj.focus();
		obj.select();
	}
}
/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 End*/

