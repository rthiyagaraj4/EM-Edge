function DateCheck(from,to) {
	if(from.value=="" || to.value==""){ 
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
function validate_date(Obj,ref) {
 
	if(document.forms[0].dt_from1.value=='' || document.forms[0].dt_to1.value==''){ 
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

async function searchCode(target){
    var frm_obj		=	parent.frames[1].document.formConsumptionReportCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;
	var lan_id=parent.frames[1].document.formConsumptionReportCriteria.p_language_id.value;
	argumentArray[0] = escape(document.formConsumptionReportCriteria.sql_ph_reports_disp_lookup.value)+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.formConsumptionReportCriteria.disp_loc_desc.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	 retArray = await CommonLookup( getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
//	alert(argumentArray);
	if(retArray != null && retArray != "") {
		 	var ret1=unescape(retArray);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			document.formConsumptionReportCriteria.p_disp_locn_code.value = arr[0];
			document.formConsumptionReportCriteria.disp_loc_desc.value = arr[1];

		}
}

function run(){
 var frm_obj		=	 f_query_add_mod.document.formConsumptionReportCriteria;

  if(f_query_add_mod.document.formConsumptionReportCriteria) {
   	var Frm=getLabel("ePH.DispenseDateDuration.label","PH")+" "+getLabel("Common.from.label","Common");
   	var to=getLabel("ePH.DispenseDateDuration.label","PH")+" "+getLabel("Common.to.label","Common");
   	var fields= new Array (frm_obj.disp_loc_desc,frm_obj.dt_from1,frm_obj.dt_to1);
	var names= new Array (getLabel("ePH.DispenseLocation.label","PH"),Frm,to);
	if(checkFields(fields,names,messageFrame) ) {

	if(!isBefore(frm_obj.dt_to1.value,frm_obj.sysdate.value,"DMY",frm_obj.p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}

    if(!isBefore(frm_obj.dt_from1.value,frm_obj.dt_to1.value,"DMY",frm_obj.p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
    
    if(frm_obj.item_name.value!=null && frm_obj.item_name.value!=undefined){
    	frm_obj.item_from.value=frm_obj.item_name.value;
		//frm_obj.item_from.value="";
		}
		if(frm_obj.titem_name.value!=null && frm_obj.titem_name.value!=undefined){
			frm_obj.item_to.value=frm_obj.titem_name.value;
			//frm_obj.item_to.value="";
		}
	var reportType = frm_obj.reportType.value;
	if(reportType=='D')
		frm_obj.p_report_id.value = "PHITCONS";
	else
		frm_obj.p_report_id.value = "PHITCONSSUM_MMS";
    //Added for MMS-QH-CRF-0106 [IN:039374] - Start
    var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="";
	xmlStr ="<root><SEARCH " ;
	xmlStr			+= "bean_id  ='PHReportsBean' " ;
	xmlStr			+= "bean_name = 'ePH.PHReportsBean' " ;
	xmlStr		    += "disp_locn_code=\""+ frm_obj.p_disp_locn_code.value + "\" ";
	xmlStr		    += "dt_from=\""+ frm_obj.dt_from1.value + "\" ";
	xmlStr		    += "dt_to=\""+ frm_obj.dt_to1.value + "\" ";
	xmlStr		    += "customer_code=\""+ frm_obj.p_cust_code.value + "\" ";
	xmlStr		    += "p_pat_class=\""+ frm_obj.p_patient_class.value + "\" ";
	xmlStr		    += "customer_group_frm=\""+ frm_obj.p_fm_cust_group_code.value + "\" ";
	xmlStr		    += "customer_group_to=\""+ frm_obj.p_to_cust_group_code.value + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=ReportSubmit", false ) ;
	xmlHttp.send( xmlDoc ) ;
	var recCount=eval(xmlHttp.responseText);
	if(recCount!="0"){//Added for MMS-QH-CRF-0106 [IN:039374] - End
		if(f_query_add_mod.document.formConsumptionReportCriteria) {
			if(CheckString(getLabel("ePH.ItemRange.label","PH"), f_query_add_mod.document.formConsumptionReportCriteria.item_name, f_query_add_mod.document.formConsumptionReportCriteria.titem_name, messageFrame) )
				frm_obj.p_from_date.value = convertDate(frm_obj.dt_from1.value,'DMY',frm_obj.p_language_id.value,'en');
				frm_obj.p_to_date.value = convertDate(frm_obj.dt_to1.value,'DMY',frm_obj.p_language_id.value,'en');
				
				if(frm_obj.item_name.value!=null && frm_obj.item_name.value!=undefined){ //Added code for [IN:45428] start
					frm_obj.item_name.value=encodeURIComponent(frm_obj.item_name.value);
				}
				if(frm_obj.titem_name.value!=null && frm_obj.titem_name.value!=undefined){
					frm_obj.titem_name.value=encodeURIComponent(frm_obj.titem_name.value);
				}
				if(frm_obj.item_name.value==""){
					frm_obj.p_item_code_from.value="";
				}
				if(frm_obj.titem_name.value==""){
					frm_obj.p_item_code_to.value=""; //Added code for [IN:45428] end
				}
				
				 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				 f_query_add_mod.document.forms[0].target="messageFrame";
			     f_query_add_mod.document.formConsumptionReportCriteria.submit();
			
			     if(frm_obj.item_name.value!=null && frm_obj.item_name.value!=undefined){//Added code for [IN:45428] start
			    	frm_obj.item_from.value=frm_obj.item_name.value;
			    	frm_obj.item_name.value=decodeURIComponent(frm_obj.item_name.value);
			     	
			 		}
			 		if(frm_obj.titem_name.value!=null && frm_obj.titem_name.value!=undefined){
			 			frm_obj.item_to.value=frm_obj.titem_name.value;
			 		     frm_obj.titem_name.value=decodeURIComponent(frm_obj.titem_name.value); //Added code for [IN:45428] end
			 		}
				}
			}
			else{//Added for MMS-QH-CRF-0106 [IN:039374]
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH");
			}
		}
	}
}

function reset() {
    f_query_add_mod.document.formConsumptionReportCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


async function itemsearch(obj){
	var frm_obj		=	parent.frames[1].document.formConsumptionReportCriteria;
    if(frm_obj.disp_loc_desc.value!=""){
		var search_string=document.formConsumptionReportCriteria.item_name.value;
		var store_code=document.formConsumptionReportCriteria.p_disp_locn_code.value;
		var category ="A";
		var sole_source ="A";
		var ps_item ="A";
		var mfg_item ="A";
		var expiry ="A";
		var consignment ="A";
		var retVal=await callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,"",consignment);
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
	  if(retVal != null && retVal[0].length>0) {
	    document.formConsumptionReportCriteria.p_item_code_from.value=arr[0];
		document.formConsumptionReportCriteria.item_name.value= arr[1];//Added code for [IN:45428]
		document.formConsumptionReportCriteria.item_from.value=arr[1];
		}
	}
	else{
		alert(getMessage('PH_DISPENSE_LOCATION','PH'));
		frm_obj.disp_loc_desc.focus();
	}
}

async function itemsearch1(obj){
	var frm_obj		=	parent.frames[1].document.formConsumptionReportCriteria;
    if(frm_obj.disp_loc_desc.value!=""){
		var search_string=document.formConsumptionReportCriteria.titem_name.value;
		var store_code=document.formConsumptionReportCriteria.p_disp_locn_code.value;
		var category ="A";
		var sole_source ="A";
		var ps_item ="A";
		var mfg_item ="A";
		var expiry ="A";
		var consignment ="A";

		var retVal=await callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,"",consignment);
		if(retVal != null ) {
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			document.formConsumptionReportCriteria.p_item_code_to.value=arr[0];
			document.formConsumptionReportCriteria.titem_name.value=arr[1];//Added code for [IN:45428]
			document.formConsumptionReportCriteria.item_to.value=arr[1];
		}
	} 
	else{
		alert(getMessage('PH_DISPENSE_LOCATION','PH'));
		frm_obj.disp_loc_desc.focus();
	}
}


// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formConsumptionReportCriteria.p_language_id.value;
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
