function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyPseudoBedCreation.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eIP/jsp/PseudoBedCreationQueryCriteria.jsp" ;
}

function deleterecord()
{
	if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value == "modify")
	{
		if(f_query_add_mod.document.Nursing_Unit_Bed.occed_patient_id.value == '')
		{
			if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','common')))
			{
				if (f_query_add_mod.document.Nursing_Unit_Bed.Transaction_YN.value != "")
				{
					var error = f_query_add_mod.getMessage('BEDS_USED','IP');
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= " +error;
				}
				else
				{
					f_query_add_mod.document.Nursing_Unit_Bed.function_name.value = 'Delete';
					f_query_add_mod.document.Nursing_Unit_Bed.submit();
				}
			}
			else
			{
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= "
			}
		}
		else
		{
			var errMsg = f_query_add_mod.getMessage('BED_OCCUPIED_NOT_DELETED','IP');
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= " +errMsg;
		}
	}
	else
	{
		parent.frames[1].location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
}

function apply() 
{

	var fields=new Array();
	fields[0]= f_query_add_mod.document.Nursing_Unit_Bed.nursing_unit;
	fields[1]= f_query_add_mod.document.Nursing_Unit_Bed.bed_no;
	fields[2]= f_query_add_mod.document.Nursing_Unit_Bed.room;
	fields[3]= f_query_add_mod.document.Nursing_Unit_Bed.bed_class;
	fields[4]= f_query_add_mod.document.Nursing_Unit_Bed.bed_type;
	
	var names = new Array (	getLabel('Common.nursingUnit.label','common'),getLabel('Common.bedno.label','common'),getLabel('Common.roomcubicleno.label','common'),getLabel('Common.BedClass.label','common'),getLabel('Common.bedtype.label','common'));
	
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			if (f_query_add_mod.document.Nursing_Unit_Bed.occed_patient_id.value == "")
			{
				f_query_add_mod.document.Nursing_Unit_Bed.submit();
				
			}
			else
			{
				
				messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("BED_OCCUPIED_BY_PATIENT","IP");
			}
	}
}

function popDynamicValues(obj,other_code,room_no)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj.name =='nursing_unit')
	{
		removeitems(document.Nursing_Unit_Bed.room)
		removeitems(document.Nursing_Unit_Bed.speciality)
		parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.disabled=false;
	}
	else
	{
		removeitems(document.Nursing_Unit_Bed.bed_type)
	}

	if(obj.name =='nursing_unit' && document.Nursing_Unit_Bed.function_name.value=="insert")
	parent.f_query_add_mod.document.Nursing_Unit_Bed.gender_specific_ind.options[0].selected=true
	var objname= obj.name 
	var dynamicHTML =    "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>"
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
}

function assign_gender_specific_ind(obj)
{
	document.forms[0].gender_specific_ind_code.value=obj.value;
}

function onSuccess()
{
	if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=="insert" || f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=="modify")
	{
		f_query_add_mod.location.reload();
	}
	else if(f_query_add_mod.document.Nursing_Unit_Bed.function_name.value=="Delete")
		f_query_add_mod.location.href='../../eCommon/html/blank.html';
}

function reset() 
{
	if(  f_query_add_mod.document.forms[0].name == "Nursing_Unit_Bed") 
	{
		removeitems(f_query_add_mod.document.Nursing_Unit_Bed.room);
		removeitems(f_query_add_mod.document.Nursing_Unit_Bed.speciality);
		removeitems(f_query_add_mod.document.Nursing_Unit_Bed.bed_type);
		f_query_add_mod.document.Nursing_Unit_Bed.reset() ;
		
	}
	else 
		 f_query_add_mod.document.query_form.reset() ;
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

function getRoomValues(nursingunit)
{
	var sStyle = document.forms[0].sStyle.value;
	var dynamicHTML =    "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>"
	dynamicHTML+=  "<body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForNursingUnitBed.jsp'>"
	dynamicHTML+="<input type='hidden' name='object_name' id='object_name' value='nursing_unit'>"
	dynamicHTML+="<input type='hidden' name='object_val' id='object_val' value='"+nursingunit+"'>"
	dynamicHTML+="</form></body></html>"
	parent.messageFrame.document.write(dynamicHTML);
	parent.messageFrame.document.f.submit();
}

//pasted from addModifyPseudoCreation.jsp

function getRoomNo(obj)
{
	if(obj.value!='')
	{
		var nursingunit = document.forms[0].nursing_unit.value;
		var bedno = obj.value;
		var url = parent.frames[1].location.href;
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
		" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'></form></body></html>";

		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}
}

// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..

function checkTxtVal(target_id,target)
{
	if(document.forms[0].nursing_unit_desc.value == "")
		Lookup(target_id,target);
}

// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit(target_id,target)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
		{
			 Lookup(target_id,target);
		}
		else
		if(document.forms[0].nursing_unit_desc.value == "")
		{
			document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
			removeitems(document.forms[0].room);
			removeitems(document.forms[0].speciality);
		}
	}
}

/*Commented by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
/*function checkStatus(obj)
{
	if(document.Nursing_Unit_Bed.Transaction_YN.value != "" && document.Nursing_Unit_Bed.function_name.value == "modify")
	{
		var error = parent.f_query_add_mod.getMessage('BEDS_USED','IP');
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= " +error;

	  	if(obj.checked == true)
			obj.checked = false;
		else
			obj.checked = true;
	}
}*/

