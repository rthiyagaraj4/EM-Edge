
function create() 
{
	f_query_add_mod.location.href = "../../eMP/jsp/addFacilityLevel.jsp" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eMP/jsp/queryFacilityLevel.jsp";
}

function apply() 
{
	if (f_query_add_mod.document.facility_level_form.NumberingControl.item(0).checked==true)
		f_query_add_mod.document.facility_level_form.Numbering.value = "Y";
	else
		f_query_add_mod.document.facility_level_form.Numbering.value = "N";

	 var fields = new Array ( 
				  f_query_add_mod.document.facility_level_form.Facility_Name
				);
				       
	 var names  = new Array ( 
		                  "Facility"
				);	
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){ 
			f_query_add_mod.document.facility_level_form.submit() ;
				}

}

function reset() {
	  f_query_add_mod.document.facility_level_form.reset() ;
	    
	  f_query_add_mod.checkNumberingControl( f_query_add_mod.document.forms[0].Chart.value);
}

function checkNumberingControl( option ) 
{
	if(document.facility_level_form.function1.value =="insert") 
	{  
		if(option == "S") 
		{
			document.facility_level_form.NumberingControl.item(0).checked = false;
			document.facility_level_form.NumberingControl.item(1).checked = true;

			document.facility_level_form.NumberingControl.item(0).disabled = false;
			document.facility_level_form.NumberingControl.item(1).disabled = false;
		}
		if(option == "M")
		{
			document.facility_level_form.NumberingControl.item(0).checked = false;
			document.facility_level_form.NumberingControl.item(1).checked = true;

			document.facility_level_form.NumberingControl.item(0).disabled = true;
			document.facility_level_form.NumberingControl.item(1).disabled = true;
		}
	}
	else
	{
		if(option == "S")
		{
			if(document.facility_level_form.Numbering.value == "Y")
				document.facility_level_form.NumberingControl.item(0).checked = true;
			else
				document.facility_level_form.NumberingControl.item(1).checked = true;

			document.facility_level_form.NumberingControl.item(0).disabled = false;
			document.facility_level_form.NumberingControl.item(1).disabled = false;
		}
		if(option == "M")
		{
			document.facility_level_form.NumberingControl.item(0).checked = false;
			document.facility_level_form.NumberingControl.item(1).checked = true;

			document.facility_level_form.NumberingControl.item(0).disabled = true;
			document.facility_level_form.NumberingControl.item(1).disabled = true;
		}
	}
}

function deleterecord() {
	if(f_query_add_mod.document.facility_level_form.function1.value !="insert") {
		if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
		{
			f_query_add_mod.document.facility_level_form.function1.value="delete";
			f_query_add_mod.document.facility_level_form.submit();
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			return true;
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
	}	
	else 	
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
	} 
}

function onSuccess(){
       	//f_query_add_mod.document.facility_level_form.reset() ;
       	f_query_add_mod.document.location.reload();
}

function CheckIdLen(Obj)
{
	if(Obj.value!="")
	{
		if(parseInt(Obj.value) <= 0)
		{
			alert(getMessage("VALUE_GREAT_ZERO","MP"));
			Obj.focus();
			Obj.select();
			return;
		}
	}
	if (CheckNum(Obj)==true)
	{
		if(Obj.value!="")
		{
			if(parseInt(Obj.value) > parseInt(facility_level_form.patient_id_length.value))
			{
				alert(getMessage("PATID_GREATER","MP"));
				Obj.focus();
				Obj.select();
			}
		}
	}
}
