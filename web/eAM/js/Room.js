function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyRoom.jsp?function_id="+function_id1 ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/RoomQueryCriteria.jsp?function=service&function_id="+function_id1;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply() {
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	f_query_add_mod.document.room_form.flor_code.value=f_query_add_mod.document.room_form.floor_code.value;
	f_query_add_mod.document.room_form.maxi_bed.value=f_query_add_mod.document.room_form.max_bed.value;
		var fields = new Array (
				f_query_add_mod.document.room_form.facility,
				  f_query_add_mod.document.room_form.room_num,
			 // f_query_add_mod.document.room_form.room_type,
			    f_query_add_mod.document.room_form.long_desc,
			    f_query_add_mod.document.room_form.short_desc,
			     f_query_add_mod.document.room_form.locn_type
			       );
  
		var names = new Array (getLabel("Common.facility.label",'Common'),
				  getLabel("Common.RoomCubicle.label",'Common'),
					getLabel("Common.longdescription.label",'Common'),
			  	getLabel("Common.shortdescription.label",'Common'),
			  	getLabel("Common.type.label",'Common'));
		if (f_query_add_mod.document.getElementById('nob_img'))
		{
		
		if(f_query_add_mod.document.getElementById('nob_img').style.visibility=='visible'){
			names[names.length]		= getLabel("eAM.NoofBeds.label",'am');
			fields[fields.length]	= f_query_add_mod.document.room_form.max_bed;
		 
		}
}
		if(f_query_add_mod.document.room_form.function_name.value!='modify')
		{
/*
	 var fields = new Array(f_query_add_mod.document.room_form.facility,f_query_add_mod.document.room_form.long_desc,f_query_add_mod.document.room_form.short_desc);
	 var name = new Array ( "Facility",  "Long Description","Short Description");
*/
//////////Added by Manish Anand on 01-07-2002////////////////////
		var spFields = new Array (f_query_add_mod.document.room_form.room_num);
		var spNames = new Array (getLabel("Common.roomno.label","Common"));
		var error_page="../../eCommon/jsp/MstCodeError.jsp"
		if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				//if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				//	var fn_status = f_query_add_mod.document.room_form.function_name.value ;
				//if(f_query_add_mod.document.room_form.resident_stay_yn.checked==false){
				//f_query_add_mod.document.room_form.privacy_level.value='';
				//}
				//alert('hai')
				f_query_add_mod.document.room_form.submit();
				//var fn_status = f_query_add_mod.document.room_form.function_name.value ;
			   // if(fn_status == "insert")  {}

			}//
		}
		else
		{
			//if(f_query_add_mod.document.room_form.resident_stay_yn.checked==false){
			//f_query_add_mod.document.room_form.privacy_level.value='';
			//}
					//f_query_add_mod.document.room_form.inf_disease_yn.disabled=false;
				if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
					return;
				}
				if(f_query_add_mod.document.room_form.locn_type.value=='')
				{
					//errors="APP-000001 Type cannot be blank...";	
					errors = getMessage('CAN_NOT_BE_BLANK','Common');
					errors = errors.replace('$',getLabel("Common.type.label","Common"));
					messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errors+'&err_value=0' ;
				}
				else
				{
					if(f_query_add_mod.document.room_form.oxygen.disabled == true)
					   f_query_add_mod.document.room_form.oxygen.disabled = false;

					if(f_query_add_mod.document.room_form.ivpump.disabled == true)
					   f_query_add_mod.document.room_form.ivpump.disabled = false;

					if(f_query_add_mod.document.room_form.resident_stay_yn.disabled == true)
					   f_query_add_mod.document.room_form.resident_stay_yn.disabled = false;

					if(f_query_add_mod.document.room_form.suction.disabled == true)
					   f_query_add_mod.document.room_form.suction.disabled = false;

					if(f_query_add_mod.document.room_form.eeg.disabled == true)
					   f_query_add_mod.document.room_form.eeg.disabled = false;

					if(f_query_add_mod.document.room_form.vitalsign.disabled == true)
					   f_query_add_mod.document.room_form.vitalsign.disabled = false;

					if(f_query_add_mod.document.room_form.ecg.disabled == true)
					   f_query_add_mod.document.room_form.ecg.disabled = false;

					if(f_query_add_mod.document.room_form.infusionpump.disabled == true)
					   f_query_add_mod.document.room_form.infusionpump.disabled = false;

					if(f_query_add_mod.document.room_form.ventilator.disabled == true)
					   f_query_add_mod.document.room_form.ventilator.disabled = false;

					if(f_query_add_mod.document.room_form.inf_disease_yn.disabled == true)
					   f_query_add_mod.document.room_form.inf_disease_yn.disabled = false;
					
					if(f_query_add_mod.document.room_form.smoking_yn.disabled == true)
					   f_query_add_mod.document.room_form.smoking_yn.disabled = false;

					if(f_query_add_mod.document.room_form.rad_implant_patients_yn.disabled == true)
					   f_query_add_mod.document.room_form.rad_implant_patients_yn.disabled = false;
					
					f_query_add_mod.document.room_form.submit();
				}
		}
}

function onSuccess()
{
if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
{
	//f_query_add_mod.document.forms[0].reset() ;
	f_query_add_mod.location.reload();
}else
{
f_query_add_mod.location.reload();
}
	
}

function reset() {
/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
		if(f_query_add_mod.document.forms[0].name == "query_form")
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
		if(f_query_add_mod.document.forms[0].name =="room_form")
			{

			if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
			{
			//	f_query_add_mod.document.forms[0].reset() ;
				f_query_add_mod.document.location.reload();
				//f_query_add_mod.document.forms[0].locn_type.value=''
				f_query_add_mod.document.forms[0].privacy_level.disabled = true;
				f_query_add_mod.document.forms[0].inf_disease_yn.disabled = true;				
				ClearList(f_query_add_mod.document.room_form.floor_code)
			}else
			{
					f_query_add_mod.location.reload();
			}

/*
		f_query_add_mod.document.forms[0].reset() ;		
		if (f_query_add_mod.document.forms[0].privacy_level.value=='')
		{			
			f_query_add_mod.document.forms[0].privacy_level.disabled = true;
		}
		//f_query_add_mod.document.forms[0].privacy_level.disabled = true;
		f_query_add_mod.document.forms[0].inf_disease_yn.disabled = true;
		*/
	}
}				


function PopulateFloorList()
{
		var selected = room_form.bldng_code;
		

	/*while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	*/
		var bldngcode = room_form.bldng_code.value;
		var getbldngcode=room_form.bldng_code.value;
		var floor_code=room_form.floor_code.value;

	if (bldngcode != null && bldngcode != "")
		
	{	/*var HTMLVal = "<html><body><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/RoomPopulate.jsp?getcode=one'><input type='hidden' name='bldng_code' id='bldng_code' value='"+bldngcode+"'></form></body></html>";*/
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querydept' id='querydept' method='post' action='../../eAM/jsp/RoomPopulate.jsp'> "+
					" <input type='hidden' name='operating_facilityID' id='operating_facilityID' value='"+document.forms[0].facility.value+"'><input type='hidden' name='bldng_code' id='bldng_code' value='"+bldngcode+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.querydept.submit();
	}
	else
	{
		var selected = room_form.floor_code;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);

		var opt=parent.frames[1].document.createElement("Option");
		opt.text="   -----"+getLabel("Common.defaultSelect.label","Common")+"-----   "
		opt.value="";

		parent.frames[1].document.getElementById('floor_code').add(opt);
	}
}


function PopulateEquipment(obj)
{

	var selected = obj.value;

	//if (selected != null && selected != "")

	//{



		if (selected == "oxygen" || selected == "OXY" || selected == ""||selected == null||selected == "N"){
			if(room_form.oxygen.checked==true)
				room_form.oxygen.value="OXY";
			else
				room_form.oxygen.value="";

		}


		if (selected == "ivpump" || selected == "IVP" || selected == ""||selected == null||selected == "N"){
			if(room_form.ivpump.checked==true)
				room_form.ivpump.value="IVP";
			else
				room_form.ivpump.value="";

		}

		if (selected=="suction" || selected == "SUC" || selected == ""||selected == null||selected == "N"){
			if(room_form.suction.checked==true)
				room_form.suction.value="SUC";
			else
				room_form.suction.value="";

		}

		if (selected == "eeg" || selected == "EEG" || selected == ""||selected == null||selected == "N"){
			if(room_form.eeg.checked==true)
				room_form.eeg.value="EEG";
			else
				room_form.eeg.value="";

		}

		if (selected == "vitalsign" || selected == "VIT" || selected == ""||selected == null||selected == "N"){
			if(room_form.vitalsign.checked==true)
				room_form.vitalsign.value="VIT";
			else
				room_form.vitalsign.value="";

		}

		if (selected == "ecg" || selected == "ECG" || selected == ""||selected == null||selected == "N"){
			if(room_form.ecg.checked==true)
				room_form.ecg.value="ECG";
			else
				room_form.ecg.value="";

		}

		if (selected =="infusionpump" || selected == "INF" || selected == ""||selected == null||selected == "N"){
			if(room_form.infusionpump.checked==true)
				room_form.infusionpump.value="INF";
			else
				room_form.infusionpump.value="";

		}

		if (selected == "ventilator" || selected == "VEN" || selected == ""||selected == null||selected == "N"){
			if(room_form.ventilator.checked==true)
				room_form.ventilator.value="VEN";
			else
				room_form.ventilator.value="";

		}


	//}
}


function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.room_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";
   

	
        for(i=1;i<length;i++)
            object.remove(1);
   

}




