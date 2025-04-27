 //saved on 04/11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhMednStatBySrcCriteria;
	var temp_qry_1=f_query_add_mod.document.getElementById("nursing_unit_query").value;//Modified for ML-BRU-SCF-1220
	var temp_qry_2=f_query_add_mod.document.getElementById("clinic_query").value;//Modified for ML-BRU-SCF-1220
	var locale=frmObject.language_id.value;
	f_query_add_mod.document.getElementById("nursing_unit_query").value="";
	f_query_add_mod.document.getElementById("clinic_query").value="";
	if(f_query_add_mod.document.formPhMednStatBySrcCriteria) {
		var fields= new Array (frmObject.p_select_by,frmObject.p_dt_from,frmObject.p_dt_to,frmObject.Location_Type,frmObject.p_group_by,frmObject.p_report_by);
		var names= new Array (getLabel("ePH.SelectBy.label","PH"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.locationtype.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhMednStatBySrcCriteria.p_dt_from, f_query_add_mod.document.formPhMednStatBySrcCriteria.p_dt_to, messageFrame ) ) {
				if(f_query_add_mod.CheckString(getLabel("ePH.LocationId.label","PH"), f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id, f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id, messageFrame) ) {
					
					frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
					frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
					    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhMednStatBySrcCriteria.submit();
				}				
			}
		}
	}
	f_query_add_mod.document.getElementById("nursing_unit_query").value=temp_qry_1;
	f_query_add_mod.document.getElementById("clinic_query").value=temp_qry_2;
}

function reset() {
    f_query_add_mod.formPhMednStatBySrcCriteria.reset();
	f_query_add_mod.formPhMednStatBySrcCriteria.loc_search.disabled = true;
	f_query_add_mod.formPhMednStatBySrcCriteria.tloc_search.disabled = true;
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_from;
	to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_to;
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
async function CustomerGroupSearch(target){ //added for MMS CRF-0107 start
	var frmObject = parent.f_query_add_mod.document.formPhMednStatBySrcCriteria;
	
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frmObject.language_id.value;
	argumentArray[0] = frmObject.SQL_PH_CUSTOMER_GROUP_SELECT.value+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] =target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.CustomerGroup.label","PH"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "") {
		frmObject.p_customer_group.value = arr[1];
		frmObject.P_CUST_GROUP_CODE.value = arr[0];
	}
}

async function CustomerSearch(target){
	var frm_obj = parent.f_query_add_mod.document.formPhMednStatBySrcCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frm_obj.language_id.value;
	argumentArray[0] = frm_obj.SQL_PH_CUSTOMER_SELECT.value+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.Customer.label","PH"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "") {
		frm_obj.p_customer.value = arr[1];
		frm_obj.P_CUST_CODE.value = arr[0];
	}
}//added for MMS CRF-0107 end
async function searchLocationName(target, mode) {
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
	retVal=await CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id.value=arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id.value=arr[0];

	target.value = arr[1];
	
	}
}
else
{
	
	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("clinic_query").value)+"'"+f_query_add_mod.document.formPhMednStatBySrcCriteria.language_id.value+"'"+ "AND APPL_USER_ID ='"+appl_user_id +"'order by 2";
		
	retVal=await CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.loc_id.value=arr[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatBySrcCriteria.tloc_id.value=arr[0];
		target.value = arr[1];
	}
}

}

function changeLegend(obj)
{  
		
		if (obj.value == "PA")
			{	
			
			document.getElementById("changelabel").innerText="Patient ID";
			formPhPresPatternCriteria.dyn_name.value="";
			
			}
		
		else if (obj.value == "PC")
			{	document.getElementById("PR").innerText="Practitioner";
				formPhPresPatternCriteria.dyn_name.value="";
			}
		else if (obj.value == "SO")
		{	document.getElementById("PR").innerText="Source";
			formPhPresPatternCriteria.dyn_name.value="";
			
		}
		else{
			document.getElementById("changelabel").innerText="Practitioner";
		}

//	formPhPresPatternCriteria.drug_search.disabled=true;

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
