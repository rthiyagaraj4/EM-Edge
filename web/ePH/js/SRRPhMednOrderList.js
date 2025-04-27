 //saved on 30/12/2009

function run() {
//[IVAD, IV With Additives+fluids(Direct),IVAD----->1
//IVAA,                                   IVAA----->2
	//IV With Additives+fluids(Admx),     IVID----->3 
	//IVID, IV Intermittent(Direct),      IVIA---->4
//	IVIA,                                 IVWA----->5
//IV Intermittent(Admx),
//IVWA, IV Without Additive]


	var frmObject = f_query_add_mod.document.formSRRPhMednOrderListCriteria;
	
	  if(f_query_add_mod.document.formSRRPhMednOrderListCriteria) {


        if(frmObject.p_order_by.value=="T") {
        var temp=f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order.value;
		//alert(temp);
		if(temp=="IVAD")
		   f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="1"
		else if(temp=="IVAA")
				f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="2"
			 else if(temp=="IVID")
					f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="3"
				  else if(temp=="IVIA")
						 f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="4"
				       else if(temp=="IVWA")
								f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="5"
		                    else if(temp=="CO")
									f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="6"
						         else if(temp=="TD")
										 f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="7"
		                              else if(temp=="TA")
											f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="8"
									       else if(temp=="CD")
													f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="9"
										        else if(temp=="CA")
														 f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="0"
			                                         else if(temp=="NOR")
															f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="NULL"
                                                          else
															f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="ALL"
                                              

		//alert("value ====>"+f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value);	
		}else{
			f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_type_of_order_val.value="ALL"		
		}
		
		var fields= new Array (frmObject.p_facility_code,frmObject.p_dt_from1,frmObject.p_dt_to1,frmObject.p_disp_loc_code,frmObject.p_order_status,frmObject.p_order_by);
		var names= new Array (getLabel("Common.FacilityName.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("ePH.OrderDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("Common.OrderStatus.label","Common"),getLabel("Common.orderBy.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
		if(!f_query_add_mod.ValidateDateTime(f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_dt_from1, f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_dt_to1) ) { 
			alert("PH_FROM_TIME_ALERT","PH"); 
			f_query_add_mod.document.formSRRPhMednOrderListCriteria.p_dt_from1.select;
		}
		else{
					frmObject.p_dt_from.value = convertDate(frmObject.p_dt_from1.value,'DMYHM',frmObject.p_language_id.value,"en");
					frmObject.p_dt_to.value = convertDate(frmObject.p_dt_to1.value,'DMYHM',frmObject.p_language_id.value,"en");
					f_query_add_mod.document.formSRRPhMednOrderListCriteria.submit();
				
				
			}
			
		}
	}
	
}

function reset() {
	f_query_add_mod.formSRRPhMednOrderListCriteria.reset();
	var disp_loc_len =f_query_add_mod.formSRRPhMednOrderListCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		f_query_add_mod.formSRRPhMednOrderListCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}
	var opt = document.createElement("OPTION") ;
	
	var desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	opt.text = desc ;
	opt.value = "" ;
	f_query_add_mod.formSRRPhMednOrderListCriteria.p_disp_loc_code.add(opt);
	f_query_add_mod.formSRRPhMednOrderListCriteria.drug_item_label.innerText=getLabel("Common.DrugName.label","Common");
	f_query_add_mod.formSRRPhMednOrderListCriteria.p_type_of_order.disabled=true;
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

/*function callDrugSearch(obj,mode) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formSRRPhMednOrderListCriteria.drug_code.value	=	escape(arrCodeDesc[0]);
		  document.formSRRPhMednOrderListCriteria.drug_name.value	=	escape(arrCodeDesc[1]);
		}
		if (mode == 2)
		{		document.formSRRPhMednOrderListCriteria.tdrug_code.value	=	escape(arrCodeDesc[0]);
				document.formSRRPhMednOrderListCriteria.tdrug_name.value	=	escape(arrCodeDesc[1]);
		}
		obj.value =	unescape(arrCodeDesc[1]);
	}
} */

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}



function ValidateTime(obj){
	fr_dt = document.formSRRPhMednOrderListCriteria.p_dt_to1;
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.select();
			return false;
		}
		if (fr_dt.value!="")
		{

			if(!ValidateDateTime(obj,fr_dt)) 
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				//document.formPhMednOrderListCriteria.dt_to.value="";
				obj.select();
				return false;
			}


		}
	}

}


function ValidatetoTime(obj){
	fr_dt = document.formSRRPhMednOrderListCriteria.p_dt_from1;
  if(obj.value!="")
	  {
		if(!doDateTimeChk(obj))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.select();
			return false;
			}
		else
			
		
		if (fr_dt.value!="")
		{
			if(!ValidateDateTime(fr_dt,obj)) 
			{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
			obj.select();
			return false;
			}
		}

		}
		return true;
}


/*function populateDispLocn(facility_id)
{

	bean_id		=	document.formSRRPhMednOrderListCriteria.bean_id.value;
	bean_name	=	document.formSRRPhMednOrderListCriteria.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PhRepMednOrdersValidation.jsp",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	

}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= unescape(desc) ;
	document.formSRRPhMednOrderListCriteria.p_disp_loc_code.add(element);
}

function clearList()	{
var len			= document.formSRRPhMednOrderListCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<len;i++) {
		document.formSRRPhMednOrderListCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}

	var tp = "     --- Select ---       " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	
	document.formSRRPhMednOrderListCriteria.p_disp_loc_code.add(opt);
}*/

function qryCreate(obj){

	var qryValue ='';

	if(obj.value == "OS"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('OS','RG','VF')";
	} else if(obj.value == "IR"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('DP')";
	} else if(obj.value == "CD"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('DF')";
	}
	document.formSRRPhMednOrderListCriteria.p_orderstatus_qry.value = qryValue;
}

/* function ModifyDates(){
var form_obj=f_query_add_mod.document.formSRRPhMednOrderListCriteria;
var from_date=form_obj.dt_from.value;
var to_date=form_obj.dt_to.value;
var strDateArray=new Array() ; 
	if(from_date != ''){

	strDateArray = from_date.split(" ");

		form_obj.dt_from.value=strDateArray[0]+' 00:00';
	}
	if(to_date != ''){
	strDateArray = to_date.split(" ");
		form_obj.dt_to.value=strDateArray[0]+' 23:59';
	}
} */

function showtypeoforder()
{
	
var form_obj=document.formSRRPhMednOrderListCriteria;
//alert(form_obj.p_order_by.value);
if(form_obj.p_order_by.value=="T")
{
	form_obj.p_type_of_order.disabled=false;
	//alert(document.getElementById("tp1").style.display);
	//document.getElementById("tp1").style.visibility = "visible";
	//document.getElementById("tp2").style.display = "inline";
}
else
{
	//alert("enter");
	//form_obj.p_type_of_order.value="";
	//f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="Doesn't Exist"
	form_obj.p_type_of_order.value=" ";
	form_obj.p_type_of_order.disabled=true;
   

	//document.getElementById("tp1").style.visibility = "hidden";
	//document.getElementById("tp2").style.display = "none";
}
}

function callPatientSearch(target){

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}

function locationLookup(target){
	var formObj = document.frames.formSRRPhMednOrderListCriteria;
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.p_language_id.value+"'";
			
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.p_language_id.value+"'";
			
		}
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
	}
	else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
		formObj.p_locn_type.focus()
	}
}

function clear1(obj)
{
	
if(document.formSRRPhMednOrderListCriteria.p_locn_type.value==""){
	document.formSRRPhMednOrderListCriteria.p_locn_name.disabled=false;
	document.formSRRPhMednOrderListCriteria.p_locn_name.value='';	
	document.formSRRPhMednOrderListCriteria.p_locn_code.value='';	
			}
else
	{
		document.formSRRPhMednOrderListCriteria.p_locn_name.value='';
		document.formSRRPhMednOrderListCriteria.p_locn_code.value='';	
	}
}

function ChangeLegend(drug_med_supply_obj)
{
	var formObj = document.formSRRPhMednOrderListCriteria;
	if(drug_med_supply_obj.value=="N")
	{
		formObj.drug_item_label.innerText=getLabel("Common.ItemName.label","Common");
	}
	else
	{
		formObj.drug_item_label.innerText=getLabel("Common.DrugName.label","Common");
	}
}

function Drug_ItemLookup(target)
{
	var formObj = document.frames.formSRRPhMednOrderListCriteria;
	var drug_med_supply=formObj.p_drug_med_supply.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var label ="";
	if (drug_med_supply=="Y"){
			argumentArray[0]   = escape(document.getElementById("drug_search_query").value)+"'"+formObj.p_language_id.value+"'";
			label = getLabel("Common.Drug.label","Common")
		}else if (drug_med_supply=="N"){
			argumentArray[0]   =  escape(document.getElementById("item_search_query").value)+"'"+formObj.p_language_id.value+"'";
				label = getLabel("ePH.MEDICALSUPPLY.label","PH")
		}else if(drug_med_supply==""){
			argumentArray[0]   =  escape(document.getElementById("drug_item_search_query").value)+"'"+formObj.p_language_id.value+"'";
			label = getLabel("ePH.DRUG/MEDICALSUPPLY.label","PH");
		}
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( label, argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_drug_code.value=retVal[0];
				target.value = retVal[1] ;
			}
}

function populateDispLocs(facility_id, language_id)
{
	var formObj =document.formSRRPhMednOrderListCriteria;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocs"+"&facility_id="+facility_id+"&locale="+language_id.value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}

function addOption(code,desc){
	desc = decodeURIComponent(desc,"UTF-8") ;
	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	opt.text = desc ;
	opt.value = code ;
	document.formSRRPhMednOrderListCriteria.p_disp_loc_code.add(opt);

}

function clearList(){
	
	var disp_loc_len =document.formSRRPhMednOrderListCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formSRRPhMednOrderListCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}
}

function SetDiscontinueOrder(this_obj,chk_obj)
{
	if(this_obj.checked == true)
	{
		this_obj.value = "Y";
		chk_obj.value = "Y";
	}
	else if(this_obj.checked == false)
	{
		this_obj.value = "N";
		chk_obj.value = "N";
	}
	
}


