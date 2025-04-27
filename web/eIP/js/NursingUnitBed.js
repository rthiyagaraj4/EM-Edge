function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyNursingUnitBed.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eIP/jsp/NursingUnitBedQueryCriteria.jsp" ;
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


 function clearvalues()
   {
   	var flag="";
	flag= document.Nursing_Unit_Bed.status.value;
	if(flag=="true")
	{
      removeitems(document.Nursing_Unit_Bed.room);
      removeitems(document.Nursing_Unit_Bed.speciality);
		removeitems(document.Nursing_Unit_Bed.bed_type);

	}	
	}

function clearFormValues() {    
   removeitems(document.Nursing_Unit_Bed.room);
   removeitems(document.Nursing_Unit_Bed.speciality);
   removeitems(document.Nursing_Unit_Bed.bed_type);			
}

function apply() 
{
	if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	//if(f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled == true)
	/*Wednesday, December 01, 2010 , PMG20089-CRF-0864 [IN:025309]*/
	/*this line commented CRF [AMRI-CRF-0220]*/
	//if(f_query_add_mod.document.Nursing_Unit_Bed.customer_id.value =='EK')	{  
		if(f_query_add_mod.document.Nursing_Unit_Bed.eff_status.disabled == true)
		{
			var msg=getMessage('NO_CHANGE_TO_SAVE','common');		
			parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	//} //end [AMRI-CRF-0220]
	/*Below line commented CRF [AMRI-CRF-0220]*/
/*	else
	{
		if(f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled == true)
		{ 
			var msg=getMessage('NO_CHANGE_TO_SAVE','common');		
			parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	}*/
//end [AMRI-CRF-0220]

	var fields = new Array (f_query_add_mod.document.Nursing_Unit_Bed.bed_no);
	var names  =  new Array ( getLabel('Common.bedno.label','common') );
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
		var fields=new Array();
		fields[0]= f_query_add_mod.document.Nursing_Unit_Bed.nursing_unit;
		fields[1]= f_query_add_mod.document.Nursing_Unit_Bed.bed_no;
		fields[2]= f_query_add_mod.document.Nursing_Unit_Bed.room;
		fields[3]= f_query_add_mod.document.Nursing_Unit_Bed.bed_class;
		fields[4]= f_query_add_mod.document.Nursing_Unit_Bed.bed_type;
		
		var names = new Array (	getLabel('Common.nursingUnit.label','common'),getLabel('Common.bedno.label','common'),getLabel('Common.room.label','common'),getLabel('Common.BedClass.label','common'),getLabel('Common.bedtype.label','common'));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{ 
			f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind_code.value = f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.value;
			
			for(var i=0; i<f_query_add_mod.document.forms[0].length;i++)
			{
				if( f_query_add_mod.document.forms[0].elements[i].disabled ==true)
				{
					f_query_add_mod.document.forms[0].elements[i].disabled =false;
				}
			}
			f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = false;
			f_query_add_mod.document.Nursing_Unit_Bed.submit();
					}
   	}
	}
if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value == "modify")
	f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = true;

 
}


function popDynamicValues(obj,other_code,room_no)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj.name =='nursing_unit')
	{
		document.Nursing_Unit_Bed.main_bed_no.value = '';
		removeitems(document.Nursing_Unit_Bed.room)
		removeitems(document.Nursing_Unit_Bed.speciality)

		document.Nursing_Unit_Bed.room.disabled=false;
		document.Nursing_Unit_Bed.bed_type.disabled=false;
		removeitems(document.Nursing_Unit_Bed.bed_type)

		document.Nursing_Unit_Bed.bed_class.disabled=false;
		document.Nursing_Unit_Bed.bed_class.options[0].selected = true;
		

		document.Nursing_Unit_Bed.speciality.disabled=false;
		document.Nursing_Unit_Bed.speciality.options[0].selected = true;	
		parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.disabled=false;
	}
	else
	{
		if(document.Nursing_Unit_Bed.bed_type != null)
			removeitems(document.Nursing_Unit_Bed.bed_type)
	}
		
		if(obj.name =='nursing_unit' && document.Nursing_Unit_Bed.function_name.value=="insert")
		parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.options[0].selected=true
		
		var objname= obj.name 
		var dynamicHTML = "";
		dynamicHTML+=  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>"
		dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForNursingUnitBed.jsp'>"
		dynamicHTML+="<input type='hidden' name='object_name' id='object_name' value='"+objname+"'>"
		dynamicHTML+="<input type='hidden' name='object_val' id='object_val' value='"+obj.value+"'>"

		if(other_code!="" && other_code!=null)
			dynamicHTML+="<input type='hidden' name='other_code' id='other_code' value='"+other_code+"'>"
		if(room_no!="" && room_no!=null)
			dynamicHTML+="<input type='hidden' name='room_no' id='room_no' value='"+room_no+"'>"

			dynamicHTML+="</form></body></html>"
		parent.messageFrame.document.write(dynamicHTML);
		parent.messageFrame.document.f.submit();
 	if(document.Nursing_Unit_Bed.nursing_unit.value=="")
	{
	  removeitems(document.Nursing_Unit_Bed.room);
      removeitems(document.Nursing_Unit_Bed.speciality);
	}

}

function assign_gender_specific_ind(obj)
{
	document.forms[0].gender_specific_ind_code.value=obj.value;
}
function onSuccess()
{
	
	if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=="insert")
	{
		
		f_query_add_mod.document.Nursing_Unit_Bed.reset();
		 f_query_add_mod.document.forms[0].nursing_unit.focus() ;

		for(var i=0; i<f_query_add_mod.document.forms[0].length;i++)
		{
			if( f_query_add_mod.document.forms[0].elements[i].disabled ==true)
			{
				f_query_add_mod.document.forms[0].elements[i].disabled =false;
			}
		}
	}
	else{
		
		if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=='Delete')
		{
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
		}
        else
		{
			f_query_add_mod.document.location.reload();
		}
	}
}

function reset() 
{
	if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	if(f_query_add_mod.document.forms[0].name == "Nursing_Unit_Bed")
	{ 
		f_query_add_mod.document.forms[0].reset() ;
		if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=="insert")
		{
			f_query_add_mod.document.forms[0].nursing_unit.focus() ;
			removeitems(f_query_add_mod.document.Nursing_Unit_Bed.room);
			removeitems(f_query_add_mod.document.Nursing_Unit_Bed.speciality);
			removeitems(f_query_add_mod.document.Nursing_Unit_Bed.bed_type);

			for(var i=0; i<f_query_add_mod.document.forms[0].length;i++)
			{
				if( f_query_add_mod.document.forms[0].elements[i].disabled ==true)
				{
					f_query_add_mod.document.forms[0].elements[i].disabled =false;
				}
			}
		}
		else
			 f_query_add_mod.document.location.reload();
	 }
	else 
	{
		
		 f_query_add_mod.document.query_form.reset() ;
	}
	}
}

function callChk(obj,val)
{
	if(val=="D")
		obj.checked=!obj.checked
}

function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}

function deleterecord()
{
	if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value != 'insert')
	{   
	//f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = false;
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','common')))
		{
			if (f_query_add_mod.document.Nursing_Unit_Bed.occupying_patient_id.value!="")
			{
				var error = f_query_add_mod.getMessage('BED_OCCUPIED_NOT_DELETED','IP');
				//f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = true;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= " +error;
			}
			else
			if(f_query_add_mod.document.forms[0].hddBedVal.value  != "" )
			{
				//var error = f_query_add_mod.getMessage('BED_OCCUPIED_NOT_DELETED');
				//f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = true;

				if(f_query_add_mod.document.forms[0].hddBedVal.value == 'TransactionExists')
				{
				var error = f_query_add_mod.getMessage("BEDS_USED","IP");
				}
				else
				{
				var error = f_query_add_mod.getMessage("BED_OCCUPIED_BY_PATIENT","IP");	
				}
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= " +error;
			}
			else{
			f_query_add_mod.document.Nursing_Unit_Bed.function_name.value = 'Delete';
			f_query_add_mod.document.Nursing_Unit_Bed.bed_no.disabled = false;
			f_query_add_mod.document.Nursing_Unit_Bed.bed_no.readonly = false;
			f_query_add_mod.document.Nursing_Unit_Bed.submit();
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	}
}

//functions moved from addModifyNursingUnitBed.jsp

function populateBedClass(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	var HTML = " <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForNursingUnitBed.jsp?BED_CLASS=BED_CLASS'></form></body></html>";
	parent.messageFrame.document.write(HTML);
	parent.messageFrame.document.f.submit();
}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt=document.createElement("Option");
	opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value="";
	field.add(opt);
}

function getDetails(bed_no)
{
	popDynamicValuesForBed(document.forms[0].main_bed_no,document.forms[0].nursing_unit,parent.frames[2])
}

function popDynamicValuesForBed(obj,obj2,obj3)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj.value == '')
	{
		delete_values(document.getElementById("room"))
		delete_values(document.getElementById("bed_class"))
		delete_values(document.getElementById("bed_type"))
		delete_values(document.getElementById("speciality"))

		document.forms[0].room.disabled			= false;
		document.forms[0].bed_class.disabled	= false;
		document.forms[0].bed_type.disabled		= false;
		document.forms[0].speciality.disabled	= false;
		
		var nursingUnitCode = document.forms[0].nursing_unit.value	;
		popDynamicValues(document.forms[0].nursing_unit)

	}
	else if (obj2.value=="" && obj.value != '')
	{
		msg=getMessage('NU_NOTNULL','IP');
		alert(msg)
		obj2.focus();
		obj.value='';
	}

	if ((obj.value != "") && (obj2.value != ""))
	{		
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' "+ "href='../../eCommon/html/"+sStyle+"'></link></head>" + 
		"<body class='message' onKeyDown='lockKey()'><form name='f' id='f' "+ "action='../../eIP/jsp/FetchValForBlockBed.jsp'>";
		HTMLVal += "<input type='hidden' name='obj_name' id='obj_name' value='"+obj.name+"'>"; 
		HTMLVal += "<input type='hidden' name='nursing_unit' id='nursing_unit' value='"+obj2.value+"'>";
		HTMLVal += "<input type='hidden' name='bed_no' id='bed_no' value='"+obj.value+"'>";
		HTMLVal += "</form></body></html>";
		eval(obj3).document.write(HTMLVal);
 		eval(obj3).document.f.submit();
		return true;
	}
}

function getValues(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj.name =='nursing_unit')
	{
		removeitems(document.Nursing_Unit_Bed.room)
		removeitems(document.Nursing_Unit_Bed.speciality)
		//parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.disabled=false;IN015822
	}

	if(obj.name =='nursing_unit' && document.Nursing_Unit_Bed.function_name.value=="insert")
	{			
		parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.options[0].selected=true;
		parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.disabled=true;//IN015822
	}
	
	var objname= obj.name 
	var bedclasscode= document.Nursing_Unit_Bed.hdd_bed_class.value
	
	var dynamicHTML = "";
	dynamicHTML+=  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>"
	dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForNursingUnitBed.jsp'>"
	dynamicHTML+="<input type='hidden' name='object_name' id='object_name' value='"+objname+"'>"
	dynamicHTML+="<input type='hidden' name='object_val' id='object_val' value='"+obj.value+"'>"
	dynamicHTML+="<input type='hidden' name='bed_class_code' id='bed_class_code' value='"+bedclasscode+"'>"
	dynamicHTML+="<input type='hidden' name='calling_from' id='calling_from' value='MAINBED'>"
	dynamicHTML+="</form></body></html>"
	parent.messageFrame.document.write(dynamicHTML);
	parent.messageFrame.document.f.submit();
}

async function searchBed()
{
	var nursingunit =document.forms[0].nursing_unit.value;
	var call_function = "IP_MASTER_CODE_BED";
	var retVal = 	new String();
	var dialogHeight	= "95vh";//41
	var dialogWidth		= "80vw";//65
	var dialogTop		= "72";	//72

	var status			= "no";
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	/*Friday, February 12, 2010 IN000242(emergency release),added disable_field=Nursing ,since Nursing unit list item getting enable from Bed for Nursing Unit function */
	retVal = await window.showModalDialog( "../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=Nursing&call_function="+call_function+"&nursing_unit_code="+nursingunit+"",arguments,features);

	if(retVal!=null)
	{
		var arr=retVal.split("^");

			if(arr[i] == null) arr[i]="";
			document.forms[0].main_bed_no.value	= arr[1];

			if(arr[4] == null) arr[4]="";
			document.forms[0].hdd_room.value			= arr[4];
			
			if(arr[3] == null) arr[3]="";
			document.forms[0].hdd_bed_class.value		= arr[3];

			if(arr[2] == null) arr[2]="";
			document.forms[0].hdd_bed_type.value		= arr[2];
			
			if(arr[13] == null) arr[13]="";
			document.forms[0].hdd_bed_type_desc.value	= arr[13];
			
			if(arr[10] == null) arr[10]="";
			document.forms[0].hdd_speciality_code.value		= arr[10];

			if(arr[11] == null) arr[11]="";
			document.forms[0].hdd_speciality_desc.value	= arr[11];

			getValues(document.forms[0].nursing_unit);
	}
}
			
	function focusTxt()
	{
		Nursing_Unit_Bed.nursing_unit.focus();
	}

function getValue(obj)
{
alert(obj.value);

}

