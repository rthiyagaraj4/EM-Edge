function getNursingUnitValue(nursingUnitComp, nursingUnitDescComp, facilityId, details, loginUser,operstn,wherecondn, callfunction){
	// this function launches nursing unit selection in Assign Bed functionality
	// of GBM module
	// details is given value 'to'; wherecondn is given value '';
	var msg					= "";
	var nursingUnitCode = "";
	if(nursingUnitComp){
		nursingUnitCode = nursingUnitComp.value;
	}
	//var facility_id			= getFacilitID;
	//var loginUser			= document.forms[0].loginUser.value;
	//var operstn				= document.forms[0].operstn.value;
	var sql					= "";
	//var wherecondn			= document.forms[0].wherecondn.value;
	//var retVal				= new String();
	//var call_function		= document.forms[0].call_function.value;
	var tit					= "Nursing Unit";//getLabel("Common.nursingUnit.label","Common");
	var dialogHeight		= "28" ;
	var dialogWidth			= "43" ;
	var status				= "no";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;

	var jsp_name = "GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&call_function="+callfunction+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
	
	var retVal =  window.showModalDialog(jsp_name,arguments,features);
	var arr=new Array();
	
	if(retVal && retVal != ""){
		arr=retVal.split("~");
		if(nursingUnitComp){
			nursingUnitComp.value = arr[1];
		}
		if(nursingUnitDescComp){
			nursingUnitDescComp.value = arr[0];
		}
	}
	
	/*if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");

		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value=arr[0];
			document.forms[0].from_nursing_unit_desc.value=arr[1];
		}
		else
		{
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nursing_unit_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value		="";
			document.forms[0].from_nursing_unit_desc.value	="";
		}
		else
		{
			document.forms[0].nursing_unit.value		="";
			document.forms[0].nursing_unit_desc.value	="";
		}
	}*/
} // End of getNursingUnitValue().
