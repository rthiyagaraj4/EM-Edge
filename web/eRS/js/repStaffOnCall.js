function viewWorkPlace(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
   	var frmObj=parent.frame_report.document.RepStaffOnCall_Form;
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
	var frmObject=frame_report.document.RepStaffOnCall_Form;
        var from_date=frmObject.Duration_From.value;
        var to_date=frmObject.Duration_To.value;
        var fromarray;
	var toarray;

	if(frmObject) 
	{
	   if(from_date != "" && to_date != "")
	   { 
	    if(from_date.length > 0 && to_date.length > 0 ) 
	    {
            fromarray = from_date.split("/");
            toarray = to_date.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) 
	    {
                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - To Date should be greater than or equal to From Date";
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) 
            frmObject.submit();
            }
           }
              frmObject.submit();	
	} 
}


function reset() 
{ 
	var frmObject=frame_report.document.RepStaffOnCall_Form;
         frmObject.reset();	
}