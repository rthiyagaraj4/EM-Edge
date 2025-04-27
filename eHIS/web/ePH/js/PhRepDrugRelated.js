  //saved on 07/11/2005
function run() {
/*if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from, f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to, messageFrame ) )
	{ f_query_add_mod.document.formPhRepDispStatByDrugCriteria.submit();
	  }
     }*/


var frmObject = f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	if(f_query_add_mod.document.formPhRepDispStatByDrugCriteria) {
		var fields= new Array (frmObject.drug_name, frmObject.P_Report_By);
		var names= new Array ('Drug Name','Report By');
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from, f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to, messageFrame ) )
	          { f_query_add_mod.document.formPhRepDispStatByDrugCriteria.submit();
	  }
	 }
	}
	}


function reset() {
/*	searchFrame.formPhRepDrugsByGenName.reset();*/
    f_query_add_mod.formPhRepDispStatByDrugCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage()	{

  var result	=	false;
  frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from;
  to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to;
  msg_frame		=	messageFrame;

  if(doDateCheck(frm_obj,to_obj,msg_frame) )		 {
      result	=	true;
	 }
	else
	 {
	  result  = false;
	  }
	 alert(result);
return result;
}


function searchCode( target ) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] = f_query_add_mod.document.formPhRepDispStatByDrugCriteria.SQL_PH_DRUG_SEARCH_SELECT2.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray = CommonLookup( "Drug Name", argumentArray );

	if(retArray != null && retArray != "" ) {
		target.value = retArray[1];	/* if code need to be returned */
		target.focus();
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}