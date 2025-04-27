function viewWorkPlace(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
   	var frmObj=parent.frame_report.document.RepWorkplaceRoster_Form;
	var facility_id=frmObj.facility_id.value;
	argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace WHERE eff_status = 'E'  and facility_id='"+facility_id+"' AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) ORDER BY workplace_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = RSCommonLookup("WorkPlace", argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.workplace_code.value = retVal[0];
		}else
			target.value ="";
}


function run() 
{ 
	var frmObject=frame_report.document.RepWorkplaceRoster_Form;
	frmObject.submit();	
}


function reset() 
{ 
	var frmObject=frame_report.document.RepWorkplaceRoster_Form;
         frmObject.reset();	
}