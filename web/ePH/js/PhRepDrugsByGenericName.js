  //saved on 02.11.2005
function run() {
	if(searchFrame.document.formPhRepDrugsByGenName) {
		if(CheckString("Generic ID", searchFrame.document.formPhRepDrugsByGenName.p_from_genid, searchFrame.document.formPhRepDrugsByGenName.p_to_genid, messageFrame) )
			searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			searchFrame.document.forms[0].target="messageFrame";
			searchFrame.document.formPhRepDrugsByGenName.submit();
	}
}

async function searchCode( target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	
	var language_id=document.formPhRepDrugsByGenName.locale.value;
	//argumentArray[0] = document.getElementById("SQL_PH_REPORTS_GENID_LOOKUP").value;	
	argumentArray[0] ="";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	
	parNameArray[0] ="~LANGUAGE_ID`";
	parValueArray[0]=language_id;
	
	argumentArray[12]  = "SQL_PH_REPORTS_GENID_LOOKUP_NEW";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
		
	retArray = await CommonLookup(getLabel("ePH.GenericID.label","PH"), argumentArray );
	var ret1=unescape(retArray);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray != "" ) {
		target.value = arr[0];	/* if code need to be returned */
		target.focus();
	}
}

function reset() {
	searchFrame.formPhRepDrugsByGenName.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
