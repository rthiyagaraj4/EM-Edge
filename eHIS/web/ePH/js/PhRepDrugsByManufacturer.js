  //saved on 02.11.2005
function run() {
	if(searchFrame.document.formPhRepDrugsByManufacturer) {
		if(CheckString("Manufacturer ID", searchFrame.document.formPhRepDrugsByManufacturer.p_from_mfrid, searchFrame.document.formPhRepDrugsByManufacturer.p_to_mfrid, messageFrame) )
			searchFrame.document.formPhRepDrugsByManufacturer.submit();
	}
}

async function searchCode( target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] = document.getElementById("SQL_PH_REPORTS_MFR_LOOKUP").value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray =await CommonLookup(getLabel("Common.ManufacturerID.label","Common"), argumentArray);
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" ) {
		target.value = arr[0];	/* if code need to be returned */
		target.focus();
	}
}

function reset() {
	searchFrame.formPhRepDrugsByManufacturer.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
