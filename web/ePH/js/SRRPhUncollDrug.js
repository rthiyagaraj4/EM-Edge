  //saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhUncollDrugCriteria;
	if(f_query_add_mod.document.formPhUncollDrugCriteria) {
		var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_disp_loc_code);
		var names= new Array (getLabel("ePH.AllocatedDateFrom.label","PH"),getLabel("ePH.AllocatedDateTo.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
			//Added code for date convesion regarding incident num:23336 in spira on 31/Aug/2010
			if(frmObject.dt_from1.value!= null && frmObject.dt_from1.value!="")
			frmObject.dt_from.value = convertDate(frmObject.dt_from1.value,'DMY',frmObject.p_language_id1.value,'en');
			if(frmObject.dt_to1.value!= null && frmObject.dt_to1.value!="")
			frmObject.dt_to.value = convertDate(frmObject.dt_to1.value,'DMY',frmObject.p_language_id1.value,'en');
			//ends
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhUncollDrugCriteria.dt_from1, f_query_add_mod.document.formPhUncollDrugCriteria.dt_to1, messageFrame ) ) {
				if(f_query_add_mod.CheckString("Drug From", f_query_add_mod.document.formPhUncollDrugCriteria.drug_code, f_query_add_mod.document.formPhUncollDrugCriteria.tdrug_code, messageFrame) ) {
					//alert(f_query_add_mod.document.formPhUncollDrugCriteria.dt_from.value);
					//alert(f_query_add_mod.document.formPhUncollDrugCriteria.dt_to.value);
						f_query_add_mod.document.formPhUncollDrugCriteria.submit();
				}
				
			}
		}
	}
}




function reset() {
    //f_query_add_mod.formPhUncollDrugCriteria.reset();
	f_query_add_mod.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}



/*function callDrugSearch(obj,mode) {
  	var arrCodeDesc = DrugSearch("D",obj);
	alert("stringreturn"+ arrCodeDesc);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_code.value = arrCodeDesc[0];
		else if (mode == 2)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_code.value = arrCodeDesc[0];
	    alert(arrCodeDesc[0]); 	
	//	document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
		alert(arrCodeDesc[1]);
	}
} */


function callDrugSearch(obj,mode) {
	
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formPhUncollDrugCriteria.drug_code.value	=	arrCodeDesc[0];
	
		}
		if (mode == 2)
		{		document.formPhUncollDrugCriteria.tdrug_code.value	=	arrCodeDesc[0];
		}
//		document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
		
		//alert("document.formPhUncollDrugCriteria.drug_code.value===61===>" +document.formPhUncollDrugCriteria.drug_code.value);
	}

}

function chkdrug()
{
	
	//alert("document.formPhUncollDrugCriteria.drug_name.value======69" +document.formPhUncollDrugCriteria.drug_name.value);
	if(document.formPhUncollDrugCriteria.drug_name.value==null || document.formPhUncollDrugCriteria.drug_name.value=="")
	{
		document.formPhUncollDrugCriteria.drug_code.value="";
	}
	if(document.formPhUncollDrugCriteria.tdrug_name.value==null || document.formPhUncollDrugCriteria.tdrug_name.value=="")
	{
		document.formPhUncollDrugCriteria.tdrug_code.value="";
	}

	//alert("document.formPhUncollDrugCriteria.drug_code.value===>" +document.formPhUncollDrugCriteria.drug_code.value);
	//alert("document.formPhUncollDrugCriteria.tdrug_code.value===>" +document.formPhUncollDrugCriteria.tdrug_code.value);
}






function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
	to.select();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}



/*function populateDispLocn(facility_id)
{

	bean_id		=	"PhUncollDrugBean";
	//bean_name	=	document.formPhUncollDrugCriteria.bean_name.value;
	bean_name	=	"ePH.PhUncollDrugBean";

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PhRepMednOrdersValidation.jsp",false);
	//SRRPhRepUncollValidation.jsp
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)
		//alert(xmlHttp.responseText);

}*/

/*function addList(code,desc)	{
	//alert("inside add list");
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	//alert("===========" +document.formPhUncollDrugCriteria.p_disp_loc_code.value);
	document.formPhUncollDrugCriteria.p_disp_loc_code.add(element);
}

function clearList()	{
	//alert("inside clearlist");
var len			= document.formPhUncollDrugCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<len;i++) {
		document.formPhUncollDrugCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}

	var tp = "            --- Select ---               " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	alert(document.formPhUncollDrugCriteria.p_disp_loc_code.value);
	document.formPhUncollDrugCriteria.p_disp_loc_code.add(opt);
}
*/
//Function for Patient Search:
function callPatientSearch(target)
{

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  
	 {		
		target.value = patient_id;
	 }
}
function populateDispLocs(obj, language_id)
{ 
	var formObj =document.formPhUncollDrugCriteria;
	var facility_id = obj.value;	
	var bean_id		= "SRRPHRepDispStatisByDispBean" ; ;
	var bean_name	= "ePH.SRRPHRepDispStatisByDispBean" ;
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

function clearList(){
	
	var disp_loc_len =document.formPhUncollDrugCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formPhUncollDrugCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	opt.text =decodeURIComponent(desc,"UTF-8");   //Added decodeUri component to desc regarding incident 23336 in spira on 31/Aug/2010
	opt.value = code ;	
	document.formPhUncollDrugCriteria.p_disp_loc_code.add(opt);

}
function checkoption(obj)
{
	//alert("obj==>" +obj.value);
}

 //Added NewFunction  By SureshKumar T for the ICN NO :31195
function ChkDate(obj){
	var locale=formPhUncollDrugCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
