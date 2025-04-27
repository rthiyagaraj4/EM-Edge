async	function searchCode(obj, target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
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
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

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


function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
	 
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
			
				
				if(fromdate.length > 0 && todate.length > 0 ) {
			
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
					//	if(isBefore(fromdate,todate,"DMY",localeName)) {
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;

						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				//}
						}
			return true;
	 }
	return true;

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
	
	//if(parent.frames[2].frames[1].document.FMFilesRequested.p_date_criteria.value=='1')
	//{
//	if(parent.frames[2].frames[1].doDateCheck1(parent.frames[2].frames[1].document.FMFilesRequested.p_fm_date,parent.frames[2].frames[1].document.FMFilesRequested.p_to_date ))
	//{

	
	if(parent.frames[2].frames[1].FMFilesRequested.p_to_date) {
			if(doDateCheckFrom(parent.frames[2].frames[1].FMFilesRequested.p_to_date,
								parent.frames[2].frames[1].FMFilesRequested.p_fm_date))	{	
					parent.frames[2].frames[1].document.FMFilesRequested.submit() ;
			}
	} else if(parent.frames[2].frames[1].FMFilesRequested.p_fl_reqr_to_date) {
			if(doDateCheckFrom(parent.frames[2].frames[1].FMFilesRequested.p_fl_reqr_to_date,
								parent.frames[2].frames[1].FMFilesRequested.p_fl_reqr_fm_date))	{	
					parent.frames[2].frames[1].document.FMFilesRequested.submit() ;
			}
	}
	//}
	//}else{
//if(parent.frames[2].frames[1].doDateCheck1(parent.frames[2].frames[1].document.FMFilesRequested.p_pl_reqr_fm_date,parent.frames[2].frames[1].document.FMFilesRequested.p_pl_reqr_to_date))
	//{
//	parent.frames[2].frames[1].document.FMFilesRequested.submit() ;
	//}

	//}
} 

function doDateCheck1(p_fm_date,p_to_date)
{
	var fromdate=p_fm_date.value;
	var todate = p_to_date.value;
	if(fromdate != "" && todate!="")
	{
	alert(fromdate);
	alert(fromdate);
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



function date_cri_link(obj,val)
{
	var val=obj.value;
		var flag=val;		
		if(val=="1") {          
			  document.getElementById("test").innerHTML=getLabel("Common.Request.label","Common") +"  "+ getLabel("Common.date.label","Common");
			 document.getElementById("test1").innerHTML="&nbsp;&nbsp;"+"<input type='text' name='p_fm_date' id='p_fm_date' size='10' onBlur = 'if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' maxlength='10' value='' id='date_from'><img onClick=\"return showCalendar('date_from');\"  src='../../eCommon/images/CommonCalendar.gif' />";
			 document.getElementById("test3").innerHTML="";
			 document.getElementById("test3").innerHTML="<input type='text' name='p_to_date' id='p_to_date' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' value=''  id='date_to' ><img  onClick=\"return showCalendar('date_to');\"  src='../../eCommon/images/CommonCalendar.gif'/>";
		} else if(val=="2") 	{
		   document.getElementById("test").innerHTML="Require On "+ getLabel("Common.date.label","Common");
		   document.getElementById("test1").innerHTML="&nbsp;&nbsp;"+"<input type='text' name='p_fl_reqr_fm_date' id='p_fl_reqr_fm_date' size='10' onBlur = 'if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' maxlength='10' value='' id='p_fl_date_from'><img onClick=\"return showCalendar('p_fl_date_from');\"  src='../../eCommon/images/CommonCalendar.gif' />";
		   document.getElementById("test2").innerHTML="";
		   document.getElementById("test3").innerHTML="<input type='text' name='p_fl_reqr_to_date' id='p_fl_reqr_to_date' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' value='' id='p_fl_date_to' ><img onClick=\"return showCalendar('p_fl_date_to');\" src='../../eCommon/images/CommonCalendar.gif' />";
		 }  
	}
		 
		 function setDate(Object)    { // function to set either Date of Birth or Day Month Age

       var currentDate = new Date();
       var p_date_criteria=document.forms[0].p_date_criteria.value;
	  
	   if(p_date_criteria=="1")
			 {
	   if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        } 
    }
	
			 }
	}

