//saved on 02.11.2005
function run() {
		var frmObject = f_query_add_mod.document.formPhPresPatternCriteria;
		//var temp_qry_1=frmObject.sql_ph_medn_stat_pract_select1.value+"'"+frmObject.language_id.value+"'";
		//frmObject.sql_ph_medn_stat_pract_select1.value="";
		var check='1';
		if(frmObject.locn_type.disabled){
		check='2';
		frmObject.locn_type.disabled=false;
	}
		frmObject.p_locn_type.value = frmObject.locn_type.value;
		frmObject.p_location_fm.value = frmObject.loc_id.value;
		frmObject.p_location_to.value = frmObject.tloc_id.value;
		frmObject.P_BILLGRP_FM.value = frmObject.p_billgrp_fm1.value;
		frmObject.P_BILLGRP_TO.value = frmObject.p_billgrp_to1.value;
		//alert("frmObject.P_BILLGRP_FM.value===>" +frmObject.P_BILLGRP_FM.value);
		//alert("frmObject.P_BILLGRP_TO.value===>" +frmObject.P_BILLGRP_TO.value);
		frmObject.dt_from.value = frmObject.dt_from1.value;
		frmObject.dt_to.value = frmObject.dt_to1.value;	
		if(f_query_add_mod.document.formPhPresPatternCriteria) {
			var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_select_by,frmObject.p_order_by);
			var names= new Array (getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("Common.to.label","Common"), getLabel("ePH.SelectBy.label","PH"),getLabel("Common.orderBy.label","Common"));
			if(checkFields(fields,names,messageFrame) ) {
				
				
				//alert(frmObject.p_disp_date_to.value);
				frmObject.dt_from.value = convertDate(frmObject.dt_from1.value,'DMY',frmObject.p_language_id.value,'en');
				frmObject.dt_to.value = convertDate(frmObject.dt_to1.value,'DMY',frmObject.p_language_id.value,'en');
				/*alert("frmObject.dt_from.value====>" +frmObject.dt_from.value);
				alert("frmObject.dt_to.value=31===>" +frmObject.dt_to.value);*/
				if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhPresPatternCriteria.dt_from1, f_query_add_mod.document.formPhPresPatternCriteria.dt_to1, messageFrame ) ) {
							f_query_add_mod.document.formPhPresPatternCriteria.submit();
								
				}
			}
		}
		//frmObject.sql_ph_medn_stat_pract_select1.value = temp_qry_1;
		if(check=='2')
		frmObject.locn_type.disabled=true;
	}


	function reset() {
		f_query_add_mod.location.reload();
		//f_query_add_mod.formPhPresPatternCriteria.drug_search.disabled=true;
		//if(f_query_add_mod.formPhPresPatternCriteria.locn_type.disabled==true)
			//f_query_add_mod.formPhPresPatternCriteria.locn_type.disabled=false;
		//f_query_add_mod.formPhPresPatternCriteria.p_facility_code.focus();
		//messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}



	


	function callDrugSearch(obj) {
		var arrCodeDesc = DrugSearch("D",obj);
		if(arrCodeDesc != null && arrCodeDesc != "" ) {
			document.formPhPresPatternCriteria.dyn_code.value	=	arrCodeDesc[0];
			obj.value =	arrCodeDesc[1];
		}
	}


	function changeLegend(obj)
	{  
			clearList();			
			if (obj.value == "PT")
				{	
				
				document.getElementById("PR").innerText="Practitioner";
					formPhPresPatternCriteria.drug_search.disabled=false;
					formPhPresPatternCriteria.dyn_name.value='';
					addList();
				}
			
			else if (obj.value == "DR")
				{	document.getElementById("PR").innerText="Drug";
					formPhPresPatternCriteria.drug_search.disabled=false;
					formPhPresPatternCriteria.dyn_name.value='';
					addList();
				}
			else{
				formPhPresPatternCriteria.dyn_name.value = '';
				formPhPresPatternCriteria.drug_search.disabled=true;
			}

	}

	function callFunc(target)
	{ 
		if (formPhPresPatternCriteria.p_select_by.value=="PT")	
		{
		searchPractitionerName(document.formPhPresPatternCriteria.dyn_name);

		}
	  else
		if (formPhPresPatternCriteria.p_select_by.value=="DR")	
		  { 
		   callDrugSearch(document.formPhPresPatternCriteria.dyn_name);
		  }

	}


	function searchPractitionerName(target) {
		

		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

			
			var temp='';
		dataNameArray[0]="p_user_name";
		dataValueArray[0]=document.formPhPresPatternCriteria.p_user_name.value;
		dataTypeArray[0]=STRING;
		dataNameArray[1]="p_facility_id";
		dataValueArray[1]=document.formPhPresPatternCriteria.p_facility_id.value;
		dataTypeArray[1]=STRING;
		dataNameArray[2]="p_facility_id";
		dataValueArray[2]=document.formPhPresPatternCriteria.p_facility_id.value;
		dataTypeArray[2]=STRING;
		dataNameArray[3]="p_locn_type";
		dataValueArray[3]=document.formPhPresPatternCriteria.p_locn_type.value;
		dataTypeArray[3]=STRING;
		
		argumentArray[0] = escape(document.getElementById("sql_ph_medn_stat_pract_select1").value)+"'"+document.formPhPresPatternCriteria.language_id.value+"'";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "5,6";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE ;

		retArray = CommonLookup(getLabel("Common.SearchCriteria.label","Common"), argumentArray );
		
		if(retArray != null && retArray != "") {
			formPhPresPatternCriteria.dyn_name.value = retArray[1];
			formPhPresPatternCriteria.dyn_code.value = retArray[0];
		}
	}



	function GoBack() {
		alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
		history.go(-1);
	}


	function clearList()	{
		var len =formPhPresPatternCriteria.p_order_by.options.length;
			for(var i=0;i<len;i++) {
				formPhPresPatternCriteria.p_order_by.remove("p_order_by") ;
			}

			var tp = "   --- Select ---   " ;
			var opt = document.createElement("OPTION") ;
			opt.text = tp ;
			opt.value = "" ;
			formPhPresPatternCriteria.p_order_by.add(opt);
	}

	function addList()	{
			var element = document.createElement('OPTION') ;
			
			if (formPhPresPatternCriteria.p_select_by.value=="PT")
			{	
				element.value		= "DG";
				element.text		= "Drug";
				formPhPresPatternCriteria.p_order_by.add(element);
			
				element = document.createElement('OPTION') ;
				element.value		= "UP" ;
				element.text		= "Usage Percent" ;
				formPhPresPatternCriteria.p_order_by.add(element);
			}
			else
			{	element.value		= "PR";
				element.text		= "Practitioner";
				formPhPresPatternCriteria.p_order_by.add(element);

				element = document.createElement('OPTION') ;
				element.value		= "UP" ;
				element.text		= "Usage Percent" ;
				formPhPresPatternCriteria.p_order_by.add(element);
			}
	//		formPhPresPatternCriteria.p_order_by.add(element);
	}




	function disableLocation(val)
	{

		if (val=="")
		{
			f_query_add_mod.document.formPhPresPatternCriteria.query_search.disabled=true;
			formPhPresPatternCriteria.dyn_name.value="";
			
		}
		else
		{
			f_query_add_mod.document.formPhPresPatternCriteria.query_search.disabled=false;
			formPhPresPatternCriteria.dyn_name.value="";
		}
		

	}

function callLocation(obj){

	formPhPresPatternCriteria.p_locn_type.value= obj.value;
	formPhPresPatternCriteria.loc_id.value = '';
	formPhPresPatternCriteria.loc_name.value = '';
	formPhPresPatternCriteria.tloc_id.value = '';
	formPhPresPatternCriteria.tloc_name.value = '';
//	alert(formPhPresPatternCriteria.p_locn_type.value);
}

function enableLocation(Obj){
	if(Obj.value==""){
		formPhPresPatternCriteria.locn_type.value="";
		formPhPresPatternCriteria.locn_type.selectedIndex=0;
		formPhPresPatternCriteria.locn_type.disabled=true;

	}
	else{
		formPhPresPatternCriteria.locn_type.disabled=false;
	}
}



function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].dt_to1;
	  to = document.forms[0].dt_from1;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].dt_from1;
	  to = document.forms[0].dt_to1;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE',"PH");
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].dt_to1;
	  to = parent.frames[1].document.forms[0].dt_from1;
	  //alert("from===>" +from);
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/
if(document.forms[0].dt_from1.value=='' || document.forms[0].dt_to1.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].dt_from1.value,document.forms[0].dt_to1.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
}


function DateCheck(from,to) {
/*alert("from.valu====>" +from.value);
alert("fto.value====>" +to.value);*/
    if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
    return true;
}
//Function  For Location type from and to ==== 29/12/09*/
function searchLocationName(target, mode) {
	

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhPresPatternCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhPresPatternCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


if (f_query_add_mod.document.formPhPresPatternCriteria.locn_type.value=="N")
{
	
	
	
	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+f_query_add_mod.document.formPhPresPatternCriteria.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+f_query_add_mod.document.formPhPresPatternCriteria.p_user_name.value+"' order by 2";	
	retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
	
	if(retVal != null && retVal != "") {
		
		
		if (mode == 1)
			f_query_add_mod.document.formPhPresPatternCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhPresPatternCriteria.tloc_id.value=retVal[0];

	target.value = retVal[1];
	
	}
}
else if (f_query_add_mod.document.formPhPresPatternCriteria.locn_type.value=="C")
{
	
	argumentArray[0]   = escape(f_query_add_mod.document.getElementById("sql_ph_clinic_select").value)+" '"+f_query_add_mod.document.formPhPresPatternCriteria.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+f_query_add_mod.document.formPhPresPatternCriteria.p_user_name.value+"' order by 2";	
	//argumentArray[0]   = escape("SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND CLINIC_CODE LIKE ? AND LONG_DESC LIKE ? AND A.LANGUAGE_ID = ")+"'"+f_query_add_mod.document.formPhPresPatternCriteria.p_language_id.value+"'"+ "AND b.APPL_USER_ID ='"+f_query_add_mod.document.formPhPresPatternCriteria.p_user_name.value+"'order by 2";
	
	retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

	if(retVal != null && retVal != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhPresPatternCriteria.loc_id.value=retVal[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhPresPatternCriteria.tloc_id.value=retVal[0];
		target.value = retVal[1];
	}
}
else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
	   return false;
}

}

function callNational(Obj){
	
	if(document.formPhPresPatternCriteria.p_national_item.value=="Y"){
		document.formPhPresPatternCriteria.p_edl_code.disabled=false;
		//document.formPhDrugUsageByPractCriteria.narrationTo.disabled=false;
		//document.formPhDrugUsageByPractCriteria.p_atc_from_id.value='';
		//document.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=false;

	}else{
		document.formPhPresPatternCriteria.p_edl_code.disabled=true;
		document.formPhPresPatternCriteria.p_edl_code.value="";
		//document.formPhDrugUsageByPractCriteria.p_atc_from.value='';
		//document.formPhDrugUsageByPractCriteria.p_atc_from_id.value='';
		//document.formPhDrugUsageByPractCriteria.narrationFrom.disabled=true;
		//document.formPhDrugUsageByPractCriteria.p_atc_to.value='';
		//document.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
		//document.formPhDrugUsageByPractCriteria.narrationTo.disabled=true;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.value="ALL";
		//document.formPhDrugUsageByPractCriteria.p_atc_level.selectedIndex=0;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=true;
	}
}

//
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
function checkLocationLookup(){
	
	var formObj =document.formPhPresPatternCriteria;
	if (formObj.locn_type.disabled == true)
	{
		formObj.loc_search.disabled = true;
		formObj.tloc_search.disabled = true;
		formObj.loc_name.disabled = true;
		formObj.tloc_name.disabled = true;
		formObj.loc_name.value  = '';
		formObj.tloc_name.value = '';
		formObj.loc_id.value = '';
		formObj.tloc_id.value = '';

	}else{
		formObj.loc_search.disabled = false;
		formObj.tloc_search.disabled = false;
		formObj.loc_name.disabled = false;
		formObj.tloc_name.disabled = false;
		formObj.loc_name.value  = '';
		formObj.tloc_name.value = '';
		formObj.loc_id.value = '';
		formObj.tloc_id.value = '';
	
	}

 
 }

 /* Billing Group Lookup*/
 function selectbilling(obj,calledby)
{
	
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formPhPresPatternCriteria.p_language_id.value;
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
				formPhPresPatternCriteria.p_billgrp_fm1.value = retVal[0];
			}
			else
				formPhPresPatternCriteria.p_billgrp_to1.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}
// Validations for Location,Billing Group,Drug/Practitioner Lookup done on 6/Sept/2010 Regarding incident num:23026 in spira

function chktxt(obj)
{
	
	/*alert("document.formPhPresPatternCriteria.dyn_name.value======69" +document.formPhPresPatternCriteria.dyn_name.value);
	alert("document.formPhPresPatternCriteria.dyn_code.value=====70" +document.formPhPresPatternCriteria.dyn_code.value);*/
	if(document.formPhPresPatternCriteria.dyn_name.value==null || document.formPhPresPatternCriteria.dyn_name.value=="")
	{
		
		document.formPhPresPatternCriteria.dyn_code.value="";
	}
	
}

function chkloc()
{
	
	if(document.formPhPresPatternCriteria.loc_name.value==null || document.formPhPresPatternCriteria.loc_name.value=="")
	{
		
		document.formPhPresPatternCriteria.loc_id.value="";
	}
	if(document.formPhPresPatternCriteria.tloc_name.value==null || document.formPhPresPatternCriteria.tloc_name.value=="")
	{
		
		document.formPhPresPatternCriteria.tloc_id.value="";
	}

}
function chkbill()
{
		//alert("document.formPhPresPatternCriteria.billing_from.value======69" +document.formPhPresPatternCriteria.billing_from.value);
		//alert("document.formPhPresPatternCriteria.billing_to.value=====70" +document.formPhPresPatternCriteria.billing_to.value);
	if(document.formPhPresPatternCriteria.billing_from.value==null || document.formPhPresPatternCriteria.billing_from.value=="")
	{
		
		document.formPhPresPatternCriteria.p_billgrp_fm1.value="";
	}
	if(document.formPhPresPatternCriteria.billing_to.value==null || document.formPhPresPatternCriteria.billing_to.value=="")
	{
		
		document.formPhPresPatternCriteria.p_billgrp_to1.value="";
	}
	

}
//end


