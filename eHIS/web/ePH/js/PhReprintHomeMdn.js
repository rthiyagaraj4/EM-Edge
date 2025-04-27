var reprint_seq_no="";
var p_patient_id="";//Added for RUT-SCF-0384[IN46988]
function run() {}

function reset() {
	f_query_add_mod.location.href="../../ePH/jsp/PhReprintHomeMednCriteria.jsp";
	f_query_dtl_rec.location.href="../../ePH/jsp/PhReprintHomeMednDtl.jsp";
	f_query_dtl_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp";
	f_query_dtl_add_rec.location.href="../../ePH/jsp/PhReprintHomeMednAddDtl.jsp";
	f_query_add_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp";
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

//for patient lookup
function callPatientSearch(target){
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;		
	}
}

function locationLookup(target){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;
			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );//Added for [IN46130]
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}
		else if (locn_type=="C"){
			argumentArray[0]   =  document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );//Added for [IN46130]
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}
	else{
		formObj.p_locn_type.focus()
	}
}

function CheckDateT(obj){
	var locale=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform.p_language_id.value;
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

function showDtlResults(){
	var formObj=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform;
	var bean_id			=	"PhReprintHomeMednBean";
	var bean_name		=	"ePH.PhReprintHomeMednBean";
	var patient_id		=	formObj.p_patient_id.value;
	var locale			=	formObj.p_language_id.value;//Added for IN046078
	var disp_date_frm	=	convertDate(formObj.p_disp_dt_from.value,'DMY',locale,"en");//Added for IN046078
	var disp_date_to	=	convertDate(formObj.p_disp_dt_to.value,'DMY',locale,"en");//Added for IN046078
	/*var disp_date_frm	=	formObj.p_disp_dt_from.value;
	var disp_date_to	=	formObj.p_disp_dt_to.value;*///Commented for IN046078
	var pres_id			=	formObj.p_prescription_id.value;
	var token_no		=	formObj.p_token_no.value;
	var encounter_id	=	formObj.p_encounter.value;
	var disp_locn_code	=	formObj.p_disp_locn_code.value;
	var drug_ord_type	=	formObj.p_drug_ord_type.value;
	var med_type_ind	=	"";	
	
	if(formObj.p_med_type_ind.style.visibility=="visible")
		med_type_ind	=	formObj.p_med_type_ind.value;
	
	var locn_type		=	formObj.p_locn_type.value;
	var locn_code		=	formObj.locn_code.value;//Changed for RUT-CRF-0061[IN46200]
	var Orientation		=	formObj.p_Orientation.value;
	var language_id		=	formObj.p_language.value;
	
	if(checkForMandatory(disp_date_frm,disp_date_to,disp_locn_code)==true){
		parent.f_query_dtl_rec.location.href="../../ePH/jsp/PhReprintHomeMednDtl.jsp?bean_id =PhReprintHomeMednBean&bean_name=ePH.PhReprintHomeMednBean&patient_id="+patient_id+"&disp_date_frm="+disp_date_frm+ "&disp_date_to="+disp_date_to+"&pres_id="+pres_id+"&token_no="+token_no+"&disp_locn_code="+disp_locn_code+"&med_type_ind="+med_type_ind+"&encounter_id="+encounter_id+"&locn_type="+locn_type+"&locn_code="+locn_code+"&Orientation="+Orientation+"&language_id="+language_id+"&drug_ord_type="+drug_ord_type+"&mode=search";//Modified for RUT-CRF-0061[IN46200]
		parent.f_query_dtl_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp";
		parent.f_query_dtl_add_rec.location.href="../../ePH/jsp/PhReprintHomeMednAddDtl.jsp";
		parent.f_query_add_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp";
    }
}

function checkForMandatory(disp_date_frm,disp_date_to,disp_locn_code){
	var formObj=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform;
	if (disp_date_frm =="" ){
		alert(getMessage("PH_MANDATORY","PH"));
		formObj.p_disp_dt_from.focus();
		return false;
	}
	else if (disp_date_to ==""){
		alert(getMessage("PH_MANDATORY","PH"));
		formObj.p_disp_dt_to.focus();
		return false;
	}
	else if(disp_locn_code == ""){
		alert(getMessage("PH_MANDATORY","PH"));
		formObj.p_disp_locn_code.focus();
		return false;
	}
	else{
		return true;
	}
}

function fetchPresIdDtlRec(row_chk){
	var table = parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.MednDetailTable;
	 var selected_data  	=	new Array() ;
	 var unselected_data	=	new Array();
	var patient_id="";//Added for RUT-SCF-0384[IN46988]
	var chkbox="";//Added for RUT-SCF-0384[IN46988]
	var i=0;
	var j=0;
	var k=0;
	var row_id="";//Added for RUT-SCF-0384[IN46988]
	for (var r = 2, n = table.rows.length; r < n; r++) {
		for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
			chkbox = table.rows[r].cells[6].childNodes[0];//Added for RUT-SCF-0384[IN46988] - Start
			pat_id=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.patient_id_"+(r-1)).value)
			patient_id=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.patient_id_"+(row_chk)).value);
			if(pat_id!=patient_id){
				chkbox.checked=false;
			}//Added for RUT-SCF-0384[IN46988] - End
			if(table.rows[r].cells[6].innerHTML.indexOf("CHECKED")!=-1){
				selected_data[j]=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.pres_order_id_"+(r-1)).value);//Modified for RUT-SCF-0383[IN46980]
				j++;
				break;
			}else{
				unselected_data[k]=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.pres_order_id_"+(r-1)).value);//Modified for RUT-SCF-0383[IN46980]
				k++;
				break;
			}
		}
	}
	i++;
    	parent.f_query_dtl_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp?bean_id =PhReprintHomeMednBean&bean_name=ePH.PhReprintHomeMednBean&pres_id="+selected_data+"&uncheck_data="+unselected_data+"&patient_id="+patient_id;//Added patient_id for RUT-SCF-0384[IN46988]
    	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";//Added for RUT-SCF-0384[IN46988]
    	checkPatientselect(patient_id);//Added for RUT-SCF-0384[IN46988]
}

function OnclickPresIdDtlRec(pres_id){
	//Added to show only onclick of prescription id details for RUT-SCF-0385[IN46989] - Start
	var table = parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.MednDetailTable;
	var selected_data  	=	"";
	var pres_order_id	=	"";//Added for RUT-SCF-0383[IN46980]
	 var chkbox="";
	 var i=0;
	for (var r = 2, n = table.rows.length; r < n; r++) {
		for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
				chkbox = table.rows[r].cells[6].childNodes[0];
				//selected_data=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.pres_id_"+(r-1)).value);//Commented for RUT-SCF-0383[IN46980]
				pres_order_id=trimString(eval("parent.f_query_dtl_rec.document.PhReprintHomeMednDtlform.pres_order_id_"+(r-1)).value);//Added for RUT-SCF-0383[IN46980]
				if(pres_order_id==pres_id){
					chkbox.checked=true;
					i=r-1;//Added for RUT-SCF-0384[IN46988]
				}else{
					chkbox.checked=false;
				}	
		}
	}
	
	var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " pres_order_id=\""+pres_order_id+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=clearPresId", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
	fetchPresIdDtlRec(i);//Modified for RUT-SCF-0384[IN46988]
	//Added to show only onclick of prescription id details for RUT-SCF-0385[IN46989] - End
	//parent.f_query_dtl_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp?bean_id =PhReprintHomeMednBean&bean_name=ePH.PhReprintHomeMednBean&pres_id="+pres_id;//Commented for RUT-SCF-0385[IN46989]
}

function AddDtlRec(){
	var formObj=parent.f_query_dtl_add_rec.document.PhReprintHomeMednAddform.all;
	if(formObj.item_desc.value!="" && formObj.instruction.value!="" && formObj.qty_value.value!=""){
	var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " item_desc=\""+formObj.item_desc.value+"\"";
	xmlStr += " instruction=\""+formObj.instruction.value+"\"";
	xmlStr += " qty_value=\""+formObj.qty_value.value+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=chkDuplicateRec", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
	var duplicate=eval(responseText);
		if(!duplicate){
			parent.f_query_add_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp?bean_id =PhReprintHomeMednBean&bean_name=ePH.PhReprintHomeMednBean&item_desc="+formObj.item_desc.value+"&instruction="+formObj.instruction.value+"&qty_value="+formObj.qty_value.value ;
		}
		else if(confirm("Already Record Added. Do You Want to Update the Existing Record?")){
			xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=updateDuplicateRec", false ) ;
			xmlHttp.send( xmlDoc );
			responseText=xmlHttp.responseText ;
			var udpateduplicate=eval(responseText);
			if(udpateduplicate){
				parent.f_query_add_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp?bean_id =PhReprintHomeMednBean&bean_name=ePH.PhReprintHomeMednBean&item_desc="+formObj.item_desc.value+"&instruction="+formObj.instruction.value+"&qty_value="+formObj.qty_value.value ;
			}
		}
	}
	formObj.item_desc.value="";
	formObj.instruction.value="";
	formObj.qty_value.value="";
}

function printReport(obj){
	
	var	frmObject=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform;
	var	frmObj	=parent.f_query_dtl_sub_rec.document.PhReprintHomeMednSubDtlForm.all;
	var	frmsubObj=parent.f_query_add_sub_rec.document.PhReprintHomeMednSetDtlform.MednSetDetailTable;
	var edit_data  = new Array() ;
	var i=0;
	var added_presid=frmsubObj;
	var drug_added="N";//Added for RUT-SCF-0384[IN46988]
	for (var k = 0; k < added_presid.rows.length; k++) {
		for (var c = 0;c < added_presid.rows[k].cells.length; c++) {
			if(added_presid.rows[k].cells[3]!=undefined && added_presid.rows[k].cells[3].innerHTML.indexOf("CHECKED")!=-1){
				edit_data[i]=added_presid.rows[k].cells[0].innerHTML+"/"+added_presid.rows[k].cells[2].innerHTML;
				drug_added="Y";//Added for RUT-SCF-0384[IN46988]
				i++;
				break;
			}
		}
	}
	var view_opt="";//Added for [IN045915] - Start
	if(obj!=null && obj!=undefined)
		view_opt="view"
			//Added for [IN045915] - End
	var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	//xmlStr += " selected_data=\""+selected_data+"\"";//Commented for RUT-SCF-0383[IN46980]
	xmlStr += " edit_data=\""+edit_data+"\"";
	xmlStr += " view_opt=\""+view_opt+"\"";//Added for [IN045915]
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=InsertPrintRec", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
	var result=eval(responseText);
	if(result){
		if(frmObject.p_med_type_ind.style.visibility=="visible"){
		 if(frmObject.p_med_type_ind.value == "I"){
			 if(frmObject.p_Orientation.value=="L"){
				 frmObject.p_report_id.value="PHHOMEDWITHEYE";
			 }
			 else if(frmObject.p_Orientation.value=="P"){
				 frmObject.p_report_id.value="PHHOMEDWITHEYE_PO";
			 }
		 }
		 else if(frmObject.p_med_type_ind.value == "S"){
			 if(frmObject.p_Orientation.value=="L"){
				 frmObject.p_report_id.value="PHHOMEDWOEYE";
			 }
			 else if(frmObject.p_Orientation.value=="P"){
				 frmObject.p_report_id.value="PHHOMEDWOEYE_PO";
			 }
		 }
		 else if(frmObject.p_med_type_ind.value == "O"){
			 if(frmObject.p_Orientation.value=="L"){
				 frmObject.p_report_id.value="PHHOMEDONLYEYE";
			 }
			 else if(frmObject.p_Orientation.value=="P"){
				 frmObject.p_report_id.value="PHHOMEDONLYEYE_PO";
			 }
		 }
		}else{
			if(frmObject.p_Orientation.value=="L"){
				 frmObject.p_report_id.value="PHHOMEDOUTTAPER";
			 }
			 else if(frmObject.p_Orientation.value=="P"){
				 frmObject.p_report_id.value="PHHOMEDOUTTAPER_PO";
			 }
		}
		var p_report_id		=	frmObject.p_report_id.value;
		var p_user_name		=	frmObject.p_user_name.value;
		var p_facility_id	=	frmObject.p_facility_id.value;
		var p_report_id		=	frmObject.p_report_id.value;
		var p_language_id   =	frmObject.p_language_id.value;
		var flag			=	"N";
		frmObject.p_print_seq_no.value=reprint_seq_no;
		if(frmObject.p_patient_id.value=="")
			flag="Y";
		frmObject.p_patient_id.value=p_patient_id;//Added for RUT-SCF-0384[IN46988]
		frmObject.p_add_drug_yn.value=drug_added;//Added for RUT-SCF-0384[IN46988]
		if(obj!=null && obj!=undefined){
			if(reprint_seq_no!=""){
				frmObject.submit();
				if(flag=="Y")
					frmObject.p_patient_id.value="";
			}
			else{
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
			}
		}
		else{	
			xmlStr ="<root><SEARCH ";
			xmlStr += " p_report_id=\""+p_report_id+"\"";
			xmlStr += " p_user_name=\""+p_user_name+"\"";
			xmlStr += " p_facility_id=\""+p_facility_id+"\"";
			xmlStr += " p_language_id=\""+p_language_id+"\"";
			xmlStr += " p_print_seq_no=\""+reprint_seq_no+"\"";
			xmlStr += " p_patient_id=\""+p_patient_id+"\"";//Added for RUT-SCF-0384[IN46988]
			xmlStr += " p_add_drug_yn=\""+drug_added+"\"";//Added for RUT-SCF-0384[IN46988]
			xmlStr += " p_reprint=\"Y\"";
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ReportsValidate.jsp?called_from=PRINT_HOME_MED_SUMM",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			if(trimString(responseText) == 'Success'){
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("REPORT_SUBMITTED","PH");
			}
		}	
	}
}

function viewReport(obj){
	printReport(obj);
}
function SubmitLink(from,to){
	var obj;
	if(document.PhReprintHomeMednDtlform!=undefined)
		obj			=	document.PhReprintHomeMednDtlform;
	else if(document.PhReprintHomeMednSubDtlForm!=undefined)
		obj			=	document.PhReprintHomeMednSubDtlForm;
	
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}

function assignresult(result,message,print_seq_no,view_opt,patient_id){//Added for [IN045915]//Added patient_id for RUT-SCF-0384[IN46988]
	if(result=="true"){
		reprint_seq_no=print_seq_no;
		p_patient_id=patient_id;//Added for RUT-SCF-0384[IN46988]
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("REPORT_SUBMITTED","PH");
		if(view_opt==""){//Added for [IN045915]
			parent.f_query_add_mod.location.href="../../ePH/jsp/PhReprintHomeMednCriteria.jsp";
			parent.f_query_dtl_rec.location.href="../../ePH/jsp/PhReprintHomeMednDtl.jsp";
			parent.f_query_dtl_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp";
			parent.f_query_dtl_add_rec.location.href="../../ePH/jsp/PhReprintHomeMednAddDtl.jsp";
			parent.f_query_add_sub_rec.location.href="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp";	
		}
		return true;
	}
	else{
		if(print_seq_no=="")
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
		else
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+message;
		
		return false;
	}
}

function checkForPositiveNumber(obj) {
    if(!( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)) {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.focus();
			return false;
        }
    }
	else if( obj.value.length == 0 || parseInt(obj.value)<=0){
		msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
		msg = msg.replace('$' ,getLabel("Common.Quantity.label", "Common"));		alert(msg);
		obj.focus();
		return false;
	}
}

function changeReportOptStatus(obj){
	var formObj=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform;
	if(obj.value=="T"){
		formObj.p_reportOpt.innerText='';
		formObj.p_med_type_ind.style.visibility="hidden";
	}else{
		formObj.p_reportOpt.innerText=getLabel("Common.ReportOption.label", "PH");
		formObj.p_med_type_ind.style.visibility="visible";
	}
}
function checklocncode(){//Added for RUT-CRF-0061[IN46200]
	var formObj=parent.f_query_add_mod.ReprintHomeMednReportCriteriaform;
	if(formObj.p_locn_type.value==""){
		formObj.p_locn_code.value="";
		formObj.locn_code.value="";
	}
}

function storecheckbox(index){ //Added below function for RUT-SCF-0383[IN46980]-Alpha Reopen Start
    var formObj = document.PhReprintHomeMednSubDtlForm;
	var chk_yn="";
	var selected_data="";//Added for RUT-SCF-0383[IN46980]
	var unselected_data="";//Added for RUT-SCF-0383[IN46980]
 if(eval("formObj.selected_"+index).checked==true){
	 selected_data=eval("formObj.doc_no_"+(index)).value+"/"+eval("formObj.disp_no_"+(index)).value+"/"+eval("formObj.doc_srl_no_"+(index)).value+"/"+eval("formObj.order_id_"+(index)).value+"/"+eval("formObj.order_line_num_"+(index)).value+"/"+eval("formObj.item_desc_"+(index)).value+"/"+eval("formObj.disp_qty_"+(index)).value;//Added for RUT-SCF-0383[IN46980]
    var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	chk_yn="Y";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " selected_data=\""+selected_data+"\"";//Modified for RUT-SCF-0383[IN46980]
	xmlStr += " chk_yn=\""+chk_yn+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=StoreCheckValue", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
  }
  else{
	unselected_data=eval("formObj.doc_no_"+(index)).value+"/"+eval("formObj.disp_no_"+(index)).value+"/"+eval("formObj.doc_srl_no_"+(index)).value+"/"+eval("formObj.order_id_"+(index)).value+"/"+eval("formObj.order_line_num_"+(index)).value+"/"+eval("formObj.item_desc_"+(index)).value+"/"+eval("formObj.disp_qty_"+(index)).value;//Added for RUT-SCF-0383[IN46980]
	var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	chk_yn          = "N";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " selected_data=\""+unselected_data+"\"";//Modified for RUT-SCF-0383[IN46980]
	xmlStr += " chk_yn=\""+chk_yn+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=StoreCheckValue", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
   }
}//Added below function for RUT-SCF-0383[IN46980]-Alpha Reopen End

function checkPatientselect(patient_id){//Added for RUT-SCF-0384[IN46988] - Start
	var table="";
	var patient_selected=false;
	var bean_id		=	"PhReprintHomeMednBean";
	var bean_name	=	"ePH.PhReprintHomeMednBean";
	var xmlDoc  = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/ReportsValidate.jsp?called_from=Checkpatient", false ) ;
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText ;
	patient_selected=eval(responseText);
	
	if(document.PhReprintHomeMednSetDtlform==undefined)
		table = parent.f_query_add_sub_rec.document.PhReprintHomeMednSetDtlform.MednSetDetailTable;
	else
		table = document.PhReprintHomeMednSetDtlform.MednSetDetailTable;
	
	var selected_data  	=	"";
	var pres_order_id	=	"";
	var chkbox="";
	var i=0;
	var j=0;
	if(!patient_selected){
		for (var r = 1, n = table.rows.length; r < n; r++) {
			for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
					chkbox = table.rows[r].cells[3].childNodes[0];
						chkbox.checked=false;
						if(patient_id==undefined)
							parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_SELECT_PATIENT_FOR_DMS_LINK","PH");
						break;
			}
		}
	}
}//Added for RUT-SCF-0384[IN46988] - End
