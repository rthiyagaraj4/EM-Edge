  //saved on 02.11.2005
function run() { 
	
	var frmObject = f_query_add_mod.document.formPhDrugUsageBySrcCriteria;
	
	//var temp_qry_1=f_query_add_mod.document.getElementById("nursing_unit_query").value+"'"+frmObject.p_language_id.value+"'";
	//var temp_qry_2=f_query_add_mod.document.getElementById("clinic_query").value+"'"+frmObject.p_language_id.value+"'";
	//f_query_add_mod.document.getElementById("nursing_unit_query").value="";
	//f_query_add_mod.document.getElementById("clinic_query").value="";
	
	if(f_query_add_mod.document.formPhDrugUsageBySrcCriteria) {
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from.value = convertDate(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1.value,'DMY',f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value,'en');
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to.value = convertDate(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1.value,'DMY',f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value,'en');
		
		var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_group_by,frmObject.p_report_by,frmObject.Location_Type);
		var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"),getLabel("Common.locationtype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1, f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1, messageFrame ) ) {
				//if(f_query_add_mod.CheckString("Location Id", f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id, f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id, messageFrame) ) {
					
						f_query_add_mod.document.formPhDrugUsageBySrcCriteria.submit();
				//}
				
			}
		}
	}
	//f_query_add_mod.document.getElementById("nursing_unit_query").value = temp_qry_1;
	
	//f_query_add_mod.document.getElementById("clinic_query").value = temp_qry_2;
}





function reset() {
    f_query_add_mod.location.reload();
	//f_query_add_mod.formPhDrugUsageBySrcCriteria.loc_search.disabled = true;
	//f_query_add_mod.formPhDrugUsageBySrcCriteria.tloc_search.disabled = true;
	//messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_from1;
	to_obj		=	f_query_add_mod.document.formPhDrugUsageBySrcCriteria.dt_to1;
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


		



function callDrugSearch(obj,mode) { 

	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formPhDrugUsageBySrcCriteria.drug_code.value	=	arrCodeDesc[0];
		}
		if (mode == 2)
		{		document.formPhDrugUsageBySrcCriteria.tdrug_code.value	=	arrCodeDesc[0];
		}
			
		//document.formPhDrugUsageBySrcCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}



function searchLocationName(target, mode) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

if (f_query_add_mod.document.formPhDrugUsageBySrcCriteria.Location_Type.value=="N")
{  
	//Search for Nursing Unit
	//argumentArray[0]   = escape(f_query_add_mod.document.formPhDrugUsageBySrcCriteria.nursing_unit_query.value)+"'"+ f_query_add_mod.document.formPhDrugUsageBySrcCriteria.language_id.value+"'";
	argumentArray[0]   =escape(f_query_add_mod.document.getElementById("nursing_unit_query").value)+"'"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value+"'"+ "AND APPL_USER_ID ='"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_user_name.value+"'order by 2";
	
	retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
	
	if(retVal != null && retVal != "") {
		//alert("retVal==>" +retVal);
		if (mode == 1)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id.value=retVal[0];

	target.value = retVal[1];
	
	}
}
else
{

	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("clinic_query").value)+"'"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_language_id.value+"'"+ "AND b.APPL_USER_ID ='"+f_query_add_mod.document.formPhDrugUsageBySrcCriteria.p_user_name.value+"'order by 2";
	
	retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_id.value=retVal[0];
		target.value = retVal[1];
	}
}

}

function disableLocation(val)
{
	/*f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn.disabled=true;
	clearData(f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn);
	addData("","  ---Select---   ",f_query_add_mod.document.formPhMednStatBySrcCriteria.Disp_Locn);*/

	if (val=="")
	{
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_search.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.disabled=true;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_search.disabled=true;

	}
	else
	{
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_name.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.loc_search.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.value="";
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_name.disabled=false;
		f_query_add_mod.document.formPhDrugUsageBySrcCriteria.tloc_search.disabled=false;
	}
	

}




function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}
/*Function written for billing setup*************

/*Function for billing Lookup*/
/*function selectbilling(target)
{
	
	//var frmobj=parent.f_query_header.document.form_AdminRouteCategoryRoutes ;
	var frmobj=parent.f_query_add_mod.document.formPhDrugUsageBySrcCriteria ;
	//alert("frmobj====>" +frmobj.name);
	//frmobj.short_desc.value='';
	frmobj.blng_grp_id.value="";
	//alert("frmobj.blng_grp_id.value====>" +frmobj.blng_grp_id.value);
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
 	
 	
 	//argumentArray[0] ="Select blng_grp_id code,short_desc desc from bl_blng_grp_lang_vw where language_id like ? order by short_desc";
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

		dataNameArray[0] ="locale";
		dataValueArray[0]= frmobj.p_language_id.value;
		//alert("frmobj.p_language_id.value===>" +frmobj.p_language_id.value);
		//alert("");
		dataTypeArray[0] = STRING;

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK ;//CODE_LINK
		argumentArray[7] = DESC_CODE;//CODE_DESC
		retVal = CommonLookup(getLabel("Common.BillingGroup.label","Common"), argumentArray );
		//alert("retVal===>" +retVal);
		if(retVal != null && retVal != "") {
			//alert("retVal====>" +retVal);
			target.value = retVal[1] ;	
			//alert("target.value====>" +target.value);
			document.forms[0].blng_grp_id.value = retVal[0];
		}else{
			target.value ="";			
		}		
		//frmobj.route_code_desc.value='';
		//frmobj.search_criteria.selectedIndex=0;		
		//clearDetail();
}*/

function selectbilling(obj,calledby)
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formPhDrugUsageBySrcCriteria.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.BillingGroup.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
		
			obj.value = retVal[1] ;	
			if (calledby =='from')
			{
				formPhDrugUsageBySrcCriteria.p_fr_privilegde.value = retVal[0];
			}
			else
				formPhDrugUsageBySrcCriteria.p_to_privilegde.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}

/* Function for AtcClassification Listbox  values onchanging*/
function callATC(Obj){
	if(document.formPhDrugUsageBySrcCriteria.p_atc_level.value!="ALL"){
		document.formPhDrugUsageBySrcCriteria.narrationFrom.disabled=false;
		document.formPhDrugUsageBySrcCriteria.narrationTo.disabled=false;
		document.formPhDrugUsageBySrcCriteria.p_atc_from_id.value='';
		document.formPhDrugUsageBySrcCriteria.p_atc_to_id.value='';
		document.formPhDrugUsageBySrcCriteria.p_atc_level.disabled=false;

	}else{
		document.formPhDrugUsageBySrcCriteria.p_atc_from.value='';
		document.formPhDrugUsageBySrcCriteria.p_atc_from_id.value='';
		document.formPhDrugUsageBySrcCriteria.narrationFrom.disabled=true;
		document.formPhDrugUsageBySrcCriteria.p_atc_to.value='';
		document.formPhDrugUsageBySrcCriteria.p_atc_to_id.value='';
		document.formPhDrugUsageBySrcCriteria.narrationTo.disabled=true;
		document.formPhDrugUsageBySrcCriteria.p_atc_level.value="ALL";
		document.formPhDrugUsageBySrcCriteria.p_atc_level.selectedIndex=0;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=true;
	}
}
function search1(target ,mode) {
	
	
	var frmObj= document.formPhDrugUsageBySrcCriteria;
	//alert("frmObj=====>" +frmObj.name)
	
	var lan_id=frmObj.p_language_id.value;
	//alert("lan_id=====>" +lan_id);
	if(mode == "1"){
	
		frmObj.p_atc_from_id.value='';
		frmObj.p_atc_from.value='';
	}
	if(mode == "2"){
		var frmObj= document.formPhDrugUsageBySrcCriteria;
		frmObj.p_atc_to_id.value='';
		frmObj.p_atc_to.value='';
		
	}	
		var searchFor = frmObj.p_atc_level.value;
	
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var retArray 		= new Array() ;


		if (searchFor == "") {
			alert(getLabel("ePH.ATCLevelmustbeselected.label","PH"));
			return false;
					
		}else if (searchFor == "ATC1") {
			//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc1_lookup").value+"'"+lan_id+"'";
					
		}else if (searchFor == "ATC2") {
			//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc2_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATC3") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc3_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATC4") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc4_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATC5") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc5_lookup").value+"'"+lan_id+"'";
		}
		
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retArray = CommonLookup( searchFor, argumentArray );
		
			
		if(retArray != null && retArray != "" ) {
			target.value = retArray[1];	
			if(target.name=="p_atc_from_id"){
					frmObj.p_atc_from.value=retArray[0];
				}
			else if(target.name=="p_atc_to_id"){
				frmObj.p_atc_to.value=retArray[0];	
					}
			target.focus();
		}
	
}
//Validation for the check box Termcode For Drug Items
/*function checkStatus(obj){
  if (obj.checked)
  {
	  obj.value ='Y';
  }
  else
	 obj.value ='N';
}*/
function checkStatus(obj,chk_obj)
{	
	if(obj.checked == true)
	{	
		obj.value = "Y";
		chk_obj.value = "Y";
	}
	else if(obj.checked == false)
	{
		
		obj.value = "N";
		chk_obj.value = "N";
	}
	
}
function callNational(Obj){
	
	if(document.formPhDrugUsageBySrcCriteria.nat_item.value=="NAT"){
		//alert("if");
		document.formPhDrugUsageBySrcCriteria.ed_class.disabled=false;
		

	}else{
		document.formPhDrugUsageBySrcCriteria.ed_class.disabled=true;
		
	}
}
