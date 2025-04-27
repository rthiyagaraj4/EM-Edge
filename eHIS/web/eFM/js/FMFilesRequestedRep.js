	async function searchCode(obj, target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var facilityid = document.forms[0].p_facility_id.value;
			var locn_iden = document.forms[0].p_locn_identity.value;
			
			if(obj.name == "location1" || obj.name == "location2")
			{
				tit=getLabel('eFM.FSLocation.label','FM')
				sql="select FS_LOCN_CODE, SHORT_DESC from FM_STORAGE_LOCN_LANG_VW where facility_id=`"+facilityid+"` and LOCN_IDENTITY = `"+locn_iden+"` and language_id=`"+localeName+"`";
				search_code="FS_LOCN_CODE";
				search_desc= "SHORT_DESC";
			}

			if(obj.name == "narration")
			{
				tit=getLabel('eFM.Narration.label','FM');
				sql="select NARRATION_CODE, SHORT_DESC from FM_NARRATION_LANG_VW where language_id=`"+localeName+"` ";
				search_code="NARRATION_CODE";
				search_desc= "SHORT_DESC";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			{
				target.value = "";
				target.focus();
			}
	}

function displayListVals(Obj)
	{
		if(Obj.value == "D")
		{
			document.forms[0].p_fm_locn_code.value = "";
			document.forms[0].p_to_locn_code.value = "";
			document.forms[0].p_fm_locn_code.readOnly = true;
			document.forms[0].p_to_locn_code.readOnly = true;
			document.forms[0].location1.disabled = true;
			document.forms[0].location2.disabled = true;

			document.getElementById("facility_label").innerHTML = getLabel("eFM.RequestTo.label","FM");
			document.getElementById("facility_vals").innerHTML = "<select name='p_request_to' id='p_request_to' onChange='showFacilities(this);'><option value='L'>"+ getLabel('Common.loginfacility.label','common') +"</option><option value='E'>"+getLabel('Common.enterprise.label','common') +"</option></select>";
		}
		else if(Obj.value == "")
		{
			document.getElementById("facility_label").innerHTML = "";
			document.getElementById("facility_vals").innerHTML = "";
			document.getElementById("facility_id_vals").innerHTML = "";

			document.forms[0].p_fm_locn_code.value = "";
			document.forms[0].p_to_locn_code.value = "";

			document.forms[0].p_fm_locn_code.readOnly = true;
			document.forms[0].p_to_locn_code.readOnly = true;
			document.forms[0].location1.disabled = true;
			document.forms[0].location2.disabled = true;
		}
		else
		{
			document.getElementById("facility_label").innerHTML = "";
			document.getElementById("facility_vals").innerHTML = "";
			document.getElementById("facility_id_vals").innerHTML = "";

			document.forms[0].p_fm_locn_code.value = "";
			document.forms[0].p_to_locn_code.value = "";

			document.forms[0].p_fm_locn_code.readOnly = false;
			document.forms[0].p_to_locn_code.readOnly = false;
			document.forms[0].location1.disabled = false;
			document.forms[0].location2.disabled = false;
		}
	}

function reset()
{
	parent.frames[2].frames[1].document.location.reload() ;
}

function run()
{
	if(parent.frames[2].frames[1].CheckString( getLabel('eFM.FSLocationCode.label','FM') , parent.frames[2].frames[1].document.FMFilesRequested.p_fm_locn_code,parent.frames[2].frames[1].document.FMFilesRequested.p_to_locn_code, messageFrame ))
	if(parent.frames[2].frames[1].CheckString(getLabel('eFM.NarrationCode.label','FM'), parent.frames[2].frames[1].document.FMFilesRequested.p_fm_narration,parent.frames[2].frames[1].document.FMFilesRequested.p_to_narration, messageFrame ))
	if(parent.frames[2].frames[1].doDateCheck1(parent.frames[2].frames[1].document.FMFilesRequested.p_fm_date,parent.frames[2].frames[1].document.FMFilesRequested.p_to_date ))
	{
	parent.frames[2].frames[1].document.FMFilesRequested.submit() ;
	}
} 

function doDateCheck1(p_fm_date,p_to_date)
{
	var fromdate=p_fm_date.value;
	var todate = p_to_date.value;
	if(fromdate != "" && todate!="")
	{
	if(!isBefore(fromdate,todate,"DMY",localeName))
	{
		var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		p_fm_date.focus();
		p_fm_date.select();
		return false;
	}
	else
		return true;
	}
	else
		return true;
}

