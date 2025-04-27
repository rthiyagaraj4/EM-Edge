 //saved on 04/11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhMednStatBySrcCriteria;
	var temp_qry_1=f_query_add_mod.document.getElementById("nursing_unit_query").value+"'"+frmObject.language_id.value+"'";
	var temp_qry_2=f_query_add_mod.document.getElementById("clinic_query").value+"'"+frmObject.language_id.value+"'";
	//f_query_add_mod.document.getElementById("nursing_unit_query").value="";
	//f_query_add_mod.document.getElementById("clinic_query").value="";
	if(f_query_add_mod.document.formPhMednStatBySrcCriteria) {
		var fields= new Array (frmObject.p_select_by,frmObject.dt_from,frmObject.dt_to,frmObject.Location_Type,frmObject.p_group_by,frmObject.p_report_by);
		var names= new Array (getLabel("Common.ReportBy.label","Common"),getLabel("Common.DateFrom.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.locationtype.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {

			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhMednStatBySrcCriteria.dt_from, f_query_add_mod.document.formPhMednStatBySrcCriteria.dt_to, messageFrame ) ) {
				if(f_query_add_mod.CheckString(getLabel("ePH.LocationId.label","PH"), f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id, f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id, messageFrame) ) {
						f_query_add_mod.document.formPhMednStatBySrcCriteria.submit();
				}				
			}
		}
	}
//f_query_add_mod.document.getElementById("nursing_unit_query").value=temp_qry_1;
//f_query_add_mod.document.getElementById("clinic_query").value=temp_qry_2;
}

function reset() {
    //f_query_add_mod.formPhMednStatBySrcCriteria.reset();
    //f_query_add_mod.formPhMednStatBySrcCriteria.p_only_discharge.value = 'N';
	//f_query_add_mod.formPhMednStatBySrcCriteria.loc_search.disabled = true;
	//f_query_add_mod.formPhMednStatBySrcCriteria.tloc_search.disabled = true;
	f_query_add_mod.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from;
	to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to;
	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame)) {
		result	=	true;
	}
	else {
		result  = false;
	}
	alert(result);
	return result;
}

function searchLocationName(target, mode) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	//dataNameArray[0]	= "APPL_USER_ID" ;
	//dataValueArray[0]	= f_query_add_mod.document.formPhMednStatBySrcCriteria.p_user_name.value;
	//dataTypeArray[0]	= STRING ;
	dataNameArray[0]	= "FACILITY_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhMednStatBySrcCriteria.p_facility_code.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhMednStatBySrcCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
    
	//argumentArray[0] = f_query_add_mod.document.getElementById("nursing_unit_query").value+"'"+f_query_add_mod.document.formPhMednStatBySrcCriteria.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3,4";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
//alert(f_query_add_mod.document.formPhMednStatBySrcCriteria.p_user_name.value+"====="+f_query_add_mod.document.formPhMednStatBySrcCriteria.p_facility_code.value);
var appl_user_id= f_query_add_mod.document.formPhMednStatBySrcCriteria.p_user_name.value;

if (f_query_add_mod.document.formPhMednStatBySrcCriteria.Location_Type.value=="N")
{
	 
	//Search for Nursing Unit
	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("nursing_unit_query").value)+"'"+f_query_add_mod.document.formPhMednStatBySrcCriteria.language_id.value+"'"+ "AND APPL_USER_ID ='"+appl_user_id+"'order by 2";
	//alert(f_query_add_mod.document.getElementById("nursing_unit_query").value+"'"+f_query_add_mod.document.formPhMednStatBySrcCriteria.language_id.value+"'");
	retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
	
	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id.value=retVal[0];

	target.value = retVal[1];
	
	}
}
else
{
	
	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("clinic_query").value)+"'"+f_query_add_mod.document.formPhMednStatBySrcCriteria.language_id.value+"'"+ "AND APPL_USER_ID ='"+appl_user_id +"'order by 2";
		
	retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id.value=retVal[0];
		target.value = retVal[1];
	}
}

}


function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}


function disableLocation(val)
{

	if (val=="")
	{
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_name.disabled=true;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_search.disabled=true;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_name.disabled=true;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_search.disabled=true;

	}
	else
	{
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_name.disabled=false;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_search.disabled=false;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_name.disabled=false;
		f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_search.disabled=false;
	}
	

}

function checkStatus(obj){
  if (obj.checked)
  {
	  obj.value ='Y';
	  document.getElementById("p_only_discharge").value ="Y";
  }
  else{
	 obj.value ='N';
     document.getElementById("formPhMednStatBySrcCriteria").p_only_discharge.value ="N"
  }
}
