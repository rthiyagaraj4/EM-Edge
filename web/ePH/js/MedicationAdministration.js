
var result = false ;
var message = "" ;
var flag = "" ;
var duplicate_code=true;
var routedesc;
var freqdesc;
//common for calling TEMP JSP for Validations
function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicationAdministrationValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}

function create() {
}

function reset(){
	clearBean();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var params=f_search.MedicationAdministrationSearchForm.params.value;
	f_search.document.location.href="../../ePH/jsp/../../ePH/jsp/MedicationAdministrationSearch.jsp?"+params;
	f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}

function disableSearchCriteria(){
	var formObj = document.MedicationAdministrationSearchForm;
	formObj.nursing_unit.disabled = true;
	formObj.admin_from_date.disabled = true;
	formObj.admin_to_date.disabled = true;
	formObj.time_type[0].disabled = true;
	formObj.time_type[1].disabled = true;
	formObj.from_time.disabled = true;
	formObj.to_time.disabled = true;
	formObj.hold_discontinue_yn.disabled=true;
	//formObj.include_past_timings.disabled=true;
	formObj.order_type.disabled=true;
	formObj.administration_status.disabled=true;
	formObj.Search.disabled=true;
}

function enableSearchCriteria(){
	var formObj = parent.f_search.MedicationAdministrationSearchForm;
	formObj.nursing_unit.disabled = false;
	//formObj.nursing_unit.value="";
	formObj.admin_from_date.disabled = true;
	formObj.admin_to_date.disabled = true;
	formObj.time_type[0].disabled = false;
	formObj.time_type[1].disabled = false;
	formObj.from_time.disabled = false;
	formObj.to_time.disabled = false;
	formObj.hold_discontinue_yn.disabled=false;
	//formObj.include_past_timings.disabled=false;
	formObj.administration_status.disabled=false;
	formObj.order_type.disabled=false;
	formObj.Search.disabled=false;
}

function searchMednAdmin(callFrom){
	var formObj = document.MedicationAdministrationSearchForm;
	clearBean();
	if(callFrom=='MARSCH'){
		var nursing_unit	= formObj.nursing_unit.value;
		var admin_from_date	= formObj.fromDate.value;
		var admin_to_date	= formObj.toDate.value;
		var from_time		= formObj.fromDate.value;
		var to_time			= formObj.toDate.value;
		var order_type		= formObj.order_type.value;
		var called_from		= formObj.called_from.value;
		var from_bed_no		= formObj.from_bed_no.value;
		var to_bed_no		= formObj.to_bed_no.value;
		var bed_num      = formObj.bed_num.value;
		var patient_id      = formObj.patient_id.value;
		var encounter_id    = formObj.encounter_id.value;
		var display_order_by = formObj.display_order_by.value;
		var patient_class    = formObj.patient_class.value
		var hold_discontinue_yn    = formObj.hold_discontinue_yn.value
		var administration_status	= "ALL";
		var admin_route_categ    = formObj.admin_route_category.value;
		var route_admin    = formObj.route_of_admin.value;
		if(route_admin=="--Select--")
			route_admin = "";
		if(admin_route_categ=="--Select--")
			admin_route_categ = "";
		var viewBy    = formObj.viewBy.value;
		var disa    = formObj.disa.value;
		parent.f_query_add_mod.location.href="../../ePH/jsp/MedicationAdministrationFTFrame.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&nursing_unit="+nursing_unit+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&mode=TIME&order_type="+order_type+"&from_time="+from_time+"&to_time="+to_time+"&called_from="+called_from+"&administration_status="+administration_status+"&from_bed_no="+from_bed_no+"&to_bed_no="+to_bed_no+"&patient_id="+patient_id+"&bed_num="+bed_num+"&encounter_id="+encounter_id+"&disa="+disa+"&display_order_by="+display_order_by+"&patient_class="+patient_class+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ+"&MAR_sch_level_yn=Y";
	}
	else{

		var disa            = formObj.disa.value;
		
		if(disa!='Y'){
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
		
		if(parent.f_search.MedicationAdministrationSearchForm.btnPrint != undefined) {// Added for GHL-CRF-0458 - Start
			parent.f_search.MedicationAdministrationSearchForm.btnPrint.style.visibility="hidden"; 
		}		
		var nursing_unit	= formObj.nursing_unit.value;
		var admin_from_date	= formObj.admin_from_date.value;
		var admin_to_date	= formObj.admin_to_date.value;
		var order_type		= formObj.order_type.value;
		var to_time			= formObj.to_time.value;
		var from_time		= formObj.from_time.value;
		var called_from		= formObj.called_from.value;
		var from_bed_no		= formObj.from_bed_no.value;
		var to_bed_no		= formObj.to_bed_no.value;
		var patient_id      = formObj.patient_id.value;
		var bed_num      = formObj.bed_num.value;
		var encounter_id    = formObj.encounter_id.value;
		var display_order_by = formObj.display_order_by.value;
		var patient_class    = formObj.patient_class1.value
		var administration_status	= formObj.administration_status.value;
		var admin_route_categ    = formObj.admin_route_category.value;
		var route_admin    = formObj.route_of_admin.value;
		var call_from_ca   = formObj.call_from_ca.value;
		var option_id   = formObj.option_id.value;
		var locale = formObj.locale.value;
		if(route_admin=="--Select--")
			route_admin = "";
		if(admin_route_categ=="--Select--")
			admin_route_categ = "";
		
		if(nursing_unit!="" && admin_from_date!=""){
			if(document.MedicationAdministrationSearchForm.time_type[0].checked==true) {
				time_type_val="M"; }
			if(formObj.time_type[1].checked==true) {
				time_type_val="F"; }
			//alert("formObj.from_time.value:"+formObj.from_time.value+",formObj.to_time.value:"+formObj.to_time.value);
			if(time_type_val=="F"){
				
				if(formObj.from_time.value!="" && formObj.to_time.value!=""){
					if(!isBetween(admin_from_date, admin_to_date, formObj.to_time.value, 'DMYHM', locale)){
					//if(!ValidateDateTimeIBA(formObj.to_time,formObj.admin_to_date)){
						alert(getMessage("PH_TO_TIME_RANGE_ALERT",'PH'));
						return;
					}
					//else if(!ValidateDateTimeIBA(formObj.admin_from_date,formObj.from_time)){
					else if(!isBetween(admin_from_date, admin_to_date, formObj.from_time.value, 'DMYHM', locale)){
						if(formObj.administration_status.value!="ALL" && formObj.administration_status.value!="DOA"){ // && formObj.administration_status.value!="ALL" Added for GHL-CRF-0458
							alert(getMessage("PH_FROM_TIME_RANGE_ALERT",'PH'));
							return;
						}
					}
					var time_val=formObj.from_time.value;
					var hold_discontinue_yn="N";
					//var include_past_time="N";
					if(formObj.hold_discontinue_yn.checked==true){
						hold_discontinue_yn="Y";
					}

					else{
						hold_discontinue_yn="N";
					}
					/*if(formObj.include_past_timings.checked==true){
						include_past_time="Y";
					}else{
						include_past_time="N";
					}*/
					//parent.commontoolbarFrame.location.href= "../../ePH/jsp/MARHeaderForCA.jsp?function_name=Medication%20Administration";
					
					parent.f_query_add_mod.location.href="../../ePH/jsp/MedicationAdministrationFTFrame.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&time="+time_val+"&nursing_unit="+nursing_unit+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&mode=TIME&order_type="+order_type+"&from_time="+from_time+"&to_time="+to_time+"&called_from="+called_from+"&administration_status="+administration_status+"&from_bed_no="+from_bed_no+"&to_bed_no="+to_bed_no+"&patient_id="+patient_id+"&bed_num="+bed_num+"&encounter_id="+encounter_id+"&disa="+disa+"&display_order_by="+display_order_by+"&patient_class="+patient_class+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ+"&call_from_ca="+call_from_ca+"&option_id="+option_id;
				}
				else{
					 var errormessage  = getMessage("PH_MANDATORY",'PH');
					 parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
					 enableSearchCriteria();
				}
			}
			else{
				//alert("inside else line 179");
				//alert("formObj.hold_discontinue_yn.checked:"+formObj.hold_discontinue_yn.checked);
				if(formObj.hold_discontinue_yn.checked==true){
					hold_discontinue_yn="Y";
				}
				else{
					hold_discontinue_yn="N";
				}
				//alert("admin_from_date:"+admin_from_date+", admin_to_date:"+admin_to_date+", from_time:"+from_time+", to_time:"+to_time);
				//alert("route_admin:"+route_admin+", admin_route_categ:"+admin_route_categ);
				parent.f_query_add_mod.location.href="../../ePH/jsp/MedicationAdministrationModifyFrame.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&nursing_unit="+nursing_unit+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&time=12:00&mode=NOTIME&order_type="+order_type+"&called_from="+called_from+"&administration_status="+administration_status+"&from_time="+from_time+"&to_time="+to_time+"&display_order_by="+display_order_by+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ;
				
				
			}
		}
		else{
			var errormessage  = getMessage("PH_MANDATORY",'PH');

			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
			enableSearchCriteria();
		}
	}
	
}

function assignValue(obj){
	if(obj.checked==true){
		obj.value="Y"
	}
	else{
		obj.value="N"
	}
}

function changeCursor(obj){
	//obj.style.cursor="hand";
	obj.style.cursor="pointer";
}

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}

function loadDrugAdminChart(encounter_id,patient_id,selected_row){
	//parent.parent.AdminDetailFrameSet.rows="22%,*,0%,11%";
	parent.parent.document.getElementById("f_patient_line").style.height="22vh";
	parent.parent.document.getElementById("f_admin_chart").style.height="67vh";
	parent.parent.document.getElementById("f_admin_detail").style.height="0vh";
	parent.parent.document.getElementById("f_button").style.height="11vh";
	var admin_from_date= parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.admin_from_date.value;
	var admin_to_date  = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.admin_to_date.value;
	var to_time        = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.to_time.value;
	var from_time      = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.from_time.value;
	var administration_status = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.administration_status.value;
	var nursing_unit = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.nursing_unit.value;

	var hold_discontinue_yn=parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.hold_discontinue_yn.value;
	mode='database';
	formDetailObj	=document.MedicationAdministrationBedPatientHeader;
	for(i=1; i<parseInt(formDetailObj.tot_rec.value); i++) {
		if(i!=parseInt(selected_row)) {
			eval(document.getElementById('tr_'+i)).style.display='none';
		}
	}

	formDetailObj.pat_id_link.value	=	patient_id;
	document.getElementById('pat_links').style.display="inline";

	parent.parent.f_admin_chart.location.href		= "../../ePH/jsp/MedicationAdministrationChart.jsp?encounter_id="+encounter_id+"&patient_id="+patient_id+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&mode="+mode+"&hold_discontinue_yn="+hold_discontinue_yn+"&to_time="+to_time+"&from_time="+from_time+"&administration_status="+administration_status;
	parent.parent.f_admin_detail.location.href		= "../../eCommon/html/blank.html";
	//parent.parent.f_medn_admin_view.location.href	= "../../ePH/jsp/MedicationAdministrationViewMAR.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_to_time="+admin_to_date;
}

function chkAdminDueDate(backdate,sysdate,obj) {
	var back_date=backdate.value;
	var sys_date=sysdate.value;
	var admin_date=obj.value;
	if(obj.value!=""){
		if(ChkDate(obj)){
			if(back_date!=admin_date){
				if(sys_date!=admin_date){
					var errormessage  = getMessage("PH_MEDN_ADMINDATE_NEWENTRY",'PH');
					alert(errormessage);
					obj.value="";
					obj.focus();
				}
				//else{
				//document.MedicationAdministrationSearchForm.include_past_timings.disabled=false;
				//}
			}
			else{
				if(admin_date!=sys_date){
					//document.MedicationAdministrationSearchForm.include_past_timings.checked=false;
					//document.MedicationAdministrationSearchForm.include_past_timings.disabled=true;
				}
				else if(admin_date==sys_date){
					//document.MedicationAdministrationSearchForm.include_past_timings.disabled=false;
				}
			}
		}
		else{
			var errormessage  = getMessage("INVALID_DATETIME",'PH');
			alert(errormessage);
			obj.focus();
		}
	}
}

function chkDuplicate(selDateTime){
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" selDateTime=\""+ selDateTime + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"chkDuplicate");
}

function alertDuplicate(){
	//var change=confirm("Already Admisnsitered. Do u want to continue");
	var change=true;
	duplicate_code=change;
}

function callAdminDetails(obj,order_id,drug_code,srl_no,uom,mode,date,time,qty,encounter_id,order_line_no,patient_id,admin_from_date,admin_to_date,from_time,to_time,administration_status){
	changeColor(obj);
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

	duplicate_code=true;
	var selDateTime=drug_code+date+time;
	chkDuplicate(selDateTime);
	var schedule_date_time = date+" "+time;
	if(duplicate_code){
		if(mode=="Y")
			mode="iv";
		else
			mode="noniv";
		if(mode=="iv"){
			parent.AdminDetailFrameSet.rows="22%,*,30%,11%";
		}
		else if(mode=="noniv"){
			parent.AdminDetailFrameSet.rows="22%,*,30%,11%";
		}
		if(mode=="iv" || mode=="noniv"){
			if(mode=="iv") {
				order_line_no	=	"";
				drug_code =	"";
				srl_no =	"";
				qty =	"";
				uom =	"";
			}
			parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?mode=NOTIME&order_line_no="+order_line_no+"&encounter_id="+encounter_id+"&admin_from_date="+admin_from_date+"&order_id="+order_id+"&mode="+mode+"&drug_code="+drug_code+"&srl_no="+srl_no+"&time="+time+"&qty="+qty+"&uom="+uom+"&selDateTime="+selDateTime+"&patient_id="+patient_id+"&to_time="+to_time+"&from_time="+from_time+"&admin_to_date="+admin_to_date+"&shedule_date_time="+schedule_date_time;
		}
		else{
			parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?order_id="+order_id+"&order_line_no="+order_line_no+"&mode="+mode+"&drug_code="+drug_code+"&srl_no="+srl_no+"&time="+time+"&qty="+qty+"&uom="+uom+"&selDateTime="+selDateTime+"&patient_id="+patient_id+"&to_time="+time;
		}
		parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode="+mode+"&sel_schedule_time="+selDateTime;
	}
}

function displayDisconLink(){
	//parent.f_admin_button.document.MedicationAdministrationButton.discon_drugs.style.visibility="visible";
}

function displayHoldLink(){
	//parent.f_admin_button.document.MedicationAdministrationButton.hold_drugs.style.visibility="visible";
}

function locateBedNo(obj){
	/*var bed_no=document.MedicationAdministrationBedPatientHeader.bed_no.value;
	var row_no = parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows.length;
	for (var i=1;i<row_no ; i++){
		parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(0).style.backgroundColor	= "";
		parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(1).style.backgroundColor	= "";
	}
	for (var i=0;i<row_no ; i++){
		if (eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.bed_num"+i).value==bed_no){
			eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.bed_num"+i).scrollIntoView();
			parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(0).style.backgroundColor	= "#fde6d0";
			parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(1).style.backgroundColor	= "#fde6d0";
			var encounter_id=eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.encounter_id"+i).value;
			var patient_id=eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.patient_id"+i).value;
			loadDrugAdminChart(encounter_id,patient_id);
		}
		else{
			parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(0).style.backgroundColor	= "";
			parent.f_bed_patient.MedicationAdministrationBedPatientDetail.bedpatientdisplaytable.rows(i).cells(1).style.backgroundColor	= "";
		}
	}*/
	var bed_no=document.MedicationAdministrationBedPatientHeader.bed_no.value;
	var row_no = parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows.length;
	for (var i=1;i<row_no ; i++){
		parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[0].style.backgroundColor	= "";
		parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[1].style.backgroundColor	= "";
	}
	for (var i=0;i<row_no ; i++){
		if (eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.bed_num"+i).value==bed_no){
			eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.bed_num"+i).scrollIntoView();
			parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[0].style.backgroundColor	= "#fde6d0";
			parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[1].style.backgroundColor	= "#fde6d0";
			var encounter_id=eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.encounter_id"+i).value;
			var patient_id=eval("parent.f_bed_patient.document.MedicationAdministrationBedPatientDetail.patient_id"+i).value;
			loadDrugAdminChart(encounter_id,patient_id);
		}
		else{
			parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[0].style.backgroundColor	= "";
			parent.f_bed_patient.document.getElementById('bedpatientdisplaytable').rows[i].cells[1].style.backgroundColor	= "";
		}
	}
}

function clearField(obj){
	obj.value="";
	obj.style.color="#330066";
}

function formValidation(changeDetails,frmObj){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(chkforRemarks(frmObj)){
		var xmlStr ="<root><SEARCH ";
		var arrObj = frmObj.elements;
		var frmObjs = new Array()
		if(frmObj.name == null){
			frmObjs = frmObj ;
		}
		else{
			frmObjs[0] = frmObj ;
		}

		for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
			frmObj = frmObjs[frmCount]
			var arrObj = frmObj.elements;
			for(var i=0;i<arrObj.length;i++) {
				var val = "" ;
				if(arrObj[i].type == "checkbox") {
					if(arrObj[i].checked){
						arrObj[i].value="Y"
						val = "Y";
					}
					else{
						val ="N";
					}
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSplChar(val) + "\" " ;
				}
				else if(arrObj[i].type == "radio") {
					if(arrObj[i].checked) {
						val = arrObj[i].value;
						if(arrObj[i].name != null && arrObj[i].name != "")
							xmlStr+= arrObj[i].name+"=\"" + checkSplChar(val) + "\" " ;
					}
				}
				else if(arrObj[i].type == "select-multiple" ) {
					for(var j=0; j<arrObj[i].options.length; j++){
						if(arrObj[i].options[j].selected)
							val+=arrObj[i].options[j].value +"~"
					}
					val= val.substring(0,val.lastIndexOf('~'))
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSplChar(val) + "\" " ;
				}
				else{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSplChar(val) + "\" " ;
				}
			}
		}
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MedicationAdministrationValidation.jsp?func_mode=insertDetails",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		parent.f_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp";
		parent.AdminDetailFrameSet.rows="22%,*,0,11%";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return true;
	}
	else{
		var errormessage  = getMessage("MANDATORY_ADMIN_DETAILS",'PH');
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
	}
}

function changeDetails(){
	return fieldValidation(xmlStr,"changeDetails");
}

function addDetails(){
	//	parent.AdminDetailFrameSet.rows="70,*,21,170";
	var drug_code=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_code.value;
	var drug_name=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_name.value;
	var pract_id=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_code.value;
	var pract_name=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_name.value;
	var dose_qty=parent.f_admin_detail.MedicationAdministrationEntryForm.dose_qty.value;
	var qty_uom=parent.f_admin_detail.MedicationAdministrationEntryForm.qty_desc.value;
	var route_code=parent.f_admin_detail.MedicationAdministrationEntryForm.route.value;
	var freq_code=parent.f_admin_detail.MedicationAdministrationEntryForm.freq.value;
	var admin_date_time=parent.f_admin_detail.MedicationAdministrationEntryForm.admin_date_time.value;
	var batch_id=parent.f_admin_detail.MedicationAdministrationEntryForm.batch_id.value;
	var expiry_date=parent.f_admin_detail.MedicationAdministrationEntryForm.expiry_date.value;
	var trade_name=parent.f_admin_detail.MedicationAdministrationEntryForm.trade_name.value;
	if(validateForMandatoryFields(parent.f_admin_detail.MedicationAdministrationEntryForm)){
		var xmlStr ="<root><SEARCH ";
		xmlStr += " drug_code=\""+ drug_code + "\" ";
		xmlStr += " drug_name=\""+ drug_name + "\" ";
		xmlStr += " pract_id=\""+ pract_id + "\" ";
		xmlStr += " pract_name=\""+ pract_name + "\" ";
		xmlStr += " dose_qty=\""+ dose_qty + "\" ";
		xmlStr += " qty_uom=\""+ qty_uom + "\" ";
		xmlStr += " route_code=\""+ route_code + "\" ";
		xmlStr += " freq_code=\""+ freq_code + "\" ";
		xmlStr += " admin_date_time=\""+ admin_date_time + "\" ";
		xmlStr += " batch_id=\""+ batch_id + "\" ";
		xmlStr += " expiry_date=\""+ expiry_date + "\" ";
		xmlStr += " trade_name=\""+ trade_name + "\" ";
		xmlStr += " route_desc=\""+ routedesc + "\" ";
		xmlStr += " freq_desc=\""+ freqdesc + "\" ";
		xmlStr += " /></root>";
		return fieldValidation(xmlStr,"addDetails");
	}
}
function validateForMandatoryFields(formEntryObj){

	var pract_name = formEntryObj.pract_name.value;
	var pract_code = formEntryObj.pract_code.value;
	var drug_name  = formEntryObj.drug_name.value;
	var drug_code  = formEntryObj.drug_code.value;
	var route_code = formEntryObj.route.value;
	routedesc=formEntryObj.route.options[formEntryObj.route.selectedIndex].text;
	var freq_code  = formEntryObj.freq.value;
	freqdesc=formEntryObj.freq.options[formEntryObj.freq.selectedIndex].text;
	var dose_qty   = formEntryObj.dose_qty.value;
	var qty_desc   = formEntryObj.qty_desc.value;
	var admin_date_time = formEntryObj.admin_date_time.value;
	var batch_id	= formEntryObj.batch_id.value;
	var expiry_date = formEntryObj.expiry_date.value;
	var trade_name	= formEntryObj.trade_name.value;

	var fields  = new Array() ;
	var names   = new Array() ;

	var i=0;
	var j=0;
	var can_add_1=false;

	if(pract_code==""){
		fields[i]   = formEntryObj.pract_code ;
		names[j]    = getLabel("ePH.OrderingPractioner.label",'PH') ;
		can_add_1	=true;
	}

	if(drug_name=="") {
		fields[++i]   = formEntryObj.drug_code ;
		names[++j]   = getLabel("Common.Drug.label",'Common') ;
	}
	if(route_code==""){
		fields[++i]   = formEntryObj.route ;
		names[++j]   =getLabel("ePH.AdminRoutelabel",'PH') ;
	}
	if(freq_code==""){
		fields[++i]   = formEntryObj.freq ;
		names[++j]   =getLabel("Common.Frequency.label",'Common') ;
	}
	if(dose_qty==""){
		fields[++i]   = formEntryObj.dose_qty;
		names[++j]   = getLabel("ePH.DosageQuantity.label",'PH') ;
	}
	if(qty_desc==""){
		fields[++i]   = formEntryObj.qty_desc ;
		names[++j]   = getLabel("ePH.DosageQtyUOM.label",'PH') ;
	}
	if(admin_date_time==""){
		fields[++i]   = formEntryObj.admin_date_time ;
		names[++j]   = getLabel("ePH.AdminDate/Time.label",'PH') ;
	}
	if(checkFlds( fields, names)){
		return true;
	}
}
function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] + " "+getLabel("Common.Cannotbeblank.label",'Common')+"..." + "<br>" ;
		}
	}
	if ( errors.length != 0 ) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		return false ;
	}else{
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	return true ;
}
function amendDetails(){
//	parent.AdminDetailFrameSet.rows="70,*,115,21";
	var drug_code=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_code.value;
	var srl_no=parent.f_admin_detail.MedicationAdministrationEntryForm.srl_no.value;
	var drug_name=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_name.value;
	var pract_id=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_code.value;
	var pract_name=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_name.value;
	var dose_qty=parent.f_admin_detail.MedicationAdministrationEntryForm.dose_qty.value;
	var qty_uom=parent.f_admin_detail.MedicationAdministrationEntryForm.qty_desc.value;
	var route_code=parent.f_admin_detail.MedicationAdministrationEntryForm.route.value;
	var freq_code=parent.f_admin_detail.MedicationAdministrationEntryForm.freq.value;
	var admin_date_time=parent.f_admin_detail.MedicationAdministrationEntryForm.admin_date_time.value;
	if(drug_code!="" && pract_id!="" && dose_qty!="" && dose_qty!="" && qty_uom!="" && route_code!="" && freq_code!="" && admin_date_time!="" ){
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" drug_code=\""+ drug_code + "\" ";
		xmlStr+=" srl_no=\""+ srl_no + "\" ";
		xmlStr+=" drug_name=\""+ drug_name + "\" ";
		xmlStr += " pract_id=\""+ pract_id + "\" ";
		xmlStr += " pract_name=\""+ pract_name + "\" ";
		xmlStr += " dose_qty=\""+ dose_qty + "\" ";
		xmlStr += " qty_uom=\""+ qty_uom + "\" ";
		xmlStr += " route_code=\""+ route_code + "\" ";
		xmlStr += " freq_code=\""+ freq_code + "\" ";
		xmlStr += " admin_date_time=\""+ admin_date_time + "\" ";
		xmlStr +=" /></root>";
		return fieldValidation(xmlStr,"amendDetails");
	}
	else{
		var errormessage  = getMessage("PH_MANDATORY",'PH');
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
	}
}
function deleteDetails(){
	//parent.AdminDetailFrameSet.rows="70,*,21,115";
	var drug_code=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_code.value;
	var srl_no=parent.f_admin_detail.MedicationAdministrationEntryForm.srl_no.value;
	var drug_name=parent.f_admin_detail.MedicationAdministrationEntryForm.drug_name.value;
	var pract_id=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_code.value;
	var pract_name=parent.f_admin_detail.MedicationAdministrationEntryForm.pract_name.value;
	var dose_qty=parent.f_admin_detail.MedicationAdministrationEntryForm.dose_qty.value;
	var qty_uom=parent.f_admin_detail.MedicationAdministrationEntryForm.qty_desc.value;
	var route_code=parent.f_admin_detail.MedicationAdministrationEntryForm.route.value;
	var freq_code=parent.f_admin_detail.MedicationAdministrationEntryForm.freq.value;
	var admin_date_time=parent.f_admin_detail.MedicationAdministrationEntryForm.admin_date_time.value;

	if(drug_code!="" && pract_id!="" && dose_qty!="" && dose_qty!="" && qty_uom!="" && route_code!="" && freq_code!="" && admin_date_time!="" ){
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" drug_code=\""+ drug_code + "\" ";
		xmlStr+=" srl_no=\""+ srl_no + "\" ";
		xmlStr+=" drug_name=\""+ drug_name + "\" ";
		xmlStr += " pract_id=\""+ pract_id + "\" ";
		xmlStr += " pract_name=\""+ pract_name + "\" ";
		xmlStr += " dose_qty=\""+ dose_qty + "\" ";
		xmlStr += " qty_uom=\""+ qty_uom + "\" ";
		xmlStr += " route_code=\""+ route_code + "\" ";
		xmlStr += " freq_code=\""+ freq_code + "\" ";
		xmlStr += " admin_date_time=\""+ admin_date_time + "\" ";
		xmlStr +=" /></root>";
		return fieldValidation(xmlStr,"deleteDetails");
	}
	else{
		var errormessage  = getMessage("PH_MANDATORY",'PH');
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
	}
}

function validateAdminDetail_1(){
	document.MedicationAdministrationEntryForm.qty.disabled=false;
	document.MedicationAdministrationEntryForm.from_time.disabled=false;
	document.MedicationAdministrationEntryForm.to_time.disabled=false;
	document.MedicationAdministrationEntryForm.qty.disabled=false;
	document.MedicationAdministrationEntryForm.remarks_man.style.visibility="hidden";
}

function validateAdminDetail_2(){
	document.MedicationAdministrationEntryForm.qty.value=document.MedicationAdministrationEntryForm.ori_qty.value;
	document.MedicationAdministrationEntryForm.from_time.value=document.MedicationAdministrationEntryForm.ori_time.value;
	document.MedicationAdministrationEntryForm.to_time.value=document.MedicationAdministrationEntryForm.ori_time.value;
	document.MedicationAdministrationEntryForm.qty.value="";
	document.MedicationAdministrationEntryForm.from_time.value="";
	document.MedicationAdministrationEntryForm.to_time.value="";
	document.MedicationAdministrationEntryForm.qty.disabled=true;
	document.MedicationAdministrationEntryForm.from_time.disabled=true;
	document.MedicationAdministrationEntryForm.to_time.disabled=true;
	document.MedicationAdministrationEntryForm.qty.disabled=true;
	document.MedicationAdministrationEntryForm.remarks_man.style.visibility="visible";
}

function refreshPage(order_id,drug_code,srl_no){
	var encounter_id   = parent.f_admin_chart.MedicationAdministrationChartForm.encounter_id.value;
	var admin_from_date= parent.f_admin_chart.MedicationAdministrationChartForm.admin_from_date.value;
	var admin_to_date  = parent.f_admin_chart.MedicationAdministrationChartForm.admin_to_date.value;
	var to_time		   = parent.f_admin_chart.MedicationAdministrationChartForm.to_time.value;
	var from_time	   = parent.f_admin_chart.MedicationAdministrationChartForm.from_time.value;
	var past_time_yn=parent.f_admin_chart.MedicationAdministrationChartForm.past_time_yn.value;
	mode='modify';
	parent.f_admin_chart.location.href	="../../ePH/jsp/MedicationAdministrationChart.jsp?encounter_id="+encounter_id+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&past_time_yn="+past_time_yn+"&order_id="+order_id+"&drug_code="+drug_code+"&srl_no="+srl_no+"&mode="+mode+"&to_time="+to_time+"&from_time="+from_time;
}

function callEntryDetails(){
	parent.AdminDetailFrameSet.rows="70,*,170,21";
	parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?mode=entry";
	parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode=entry";
}
function drugSearch(){
	if(parent.f_admin_detail == null)
		var formObj = document.MedicationAdministrationEntryForm;
	else
		var formObj = parent.f_admin_detail.document.MedicationAdministrationEntryForm;

	retVal = DrugSearch("D",formObj.drug_name);
	if(retVal != null && retVal != "" )  {
		formObj.drug_code.value=retVal[0];
		formObj.drug_name.value=retVal[1];
		getFormCode(retVal[0]);
	}else{
		formObj.drug_name.disabled=false;
	}
}
function getFormCode(drug_code){
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" drug_code=\""+ drug_code + "\" ";
		xmlStr +=" /></root>";
		return fieldValidation(xmlStr,"getFormCode");
}

async function searchPract() {

	if(parent.f_admin_detail == null)
		var formObj	= document.MedicationAdministrationEntryForm;
	else
		var formObj = parent.f_admin_detail.document.MedicationAdministrationEntryForm;

	var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
        dataNameArray[0]   = "operating_facility_id" ;
        dataValueArray[0]  = formObj.facility_id.value;
        dataTypeArray[0]   = STRING ;
    argumentArray[0]   = formObj.sql_ph_med_admin_select9.value;
	argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
    argumentArray[5]   = formObj.pract_name.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.PractionerName.label",'PH'), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal!=null && retVal!=""){
		formObj.pract_code.value=arr[0];
		formObj.pract_name.value=arr[1];
		formObj.pract_name.disabled=true;
	}
}

function textEnable(){
	var formObj = document.MedicationAdministrationSearchForm.all;
	//document.MedicationAdministrationSearchForm.from_time.style.visibility='visible';
	//document.MedicationAdministrationSearchForm.to_time.style.display='inline';
	formObj.from_time_calendar.style.display='inline';
	formObj.to_time_calendar.style.display='inline';
	formObj.from_time_man.style.visibility='visible';
	formObj.to_time_man.style.display='inline';
	formObj.from_label.style.display='inline';
	formObj.to_label.style.display='inline';

	formObj.from_time.value = formObj.admin_from_date.value;
	formObj.to_time.value   = formObj.admin_to_date.value;

	parent.f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}
function textDisable(){
	var formObj = document.MedicationAdministrationSearchForm.all;
	document.MedicationAdministrationSearchForm.from_time.value =formObj.admin_from_date.value;
	document.MedicationAdministrationSearchForm.to_time.value   =formObj.admin_to_date.value;

//	document.MedicationAdministrationSearchForm.from_time.style.visibility='hidden';
//	document.MedicationAdministrationSearchForm.to_time.style.display='none';

//	document.MedicationAdministrationSearchForm.from_time_calendar.style.display='none';
//	document.MedicationAdministrationSearchForm.to_time_calendar.style.display='none';

//	document.MedicationAdministrationSearchForm.from_time_man.style.visibility='hidden';
//	document.MedicationAdministrationSearchForm.to_time_man.style.display='none';
//	document.MedicationAdministrationSearchForm.from_label.style.display='none';
//	document.MedicationAdministrationSearchForm.to_label.style.display='none';
	parent.f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}

function populateRoute(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.MedicationAdministrationEntryForm.route.add(element);
}

function clearRoute()	{
	var len =document.MedicationAdministrationEntryForm.route.options.length;
	for(var i=0;i<len;i++) {
		document.MedicationAdministrationEntryForm.route.remove("route") ;
	}

	var tp = "           --- "+getLabel("ePH.Select.label",'PH')+" ---           ";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.MedicationAdministrationEntryForm.route.add(opt);
}

function getbed_nos(){
	//alert("inside getbed_nos function 796");
	var  frmobj=document.MedicationAdministrationSearchForm;
	var facility_id=frmobj.facility_id.value;
	var nursing_unit_code=frmobj.nursing_unit.value;
	var bean_id		= frmobj.bean_id.value ;
	var bean_name	= frmobj.bean_name.value ;
	var xmlStr;
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "facility_id =\"" + facility_id + "\" " ;
	xmlStr+= "nursing_unit_code =\"" + nursing_unit_code + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//	alert("facility_id 810 "+facility_id +" "+ nursing_unit_code);
    //xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicationAdministrationValidation.jsp?func_mode=getBedValues",false);
	//xmlHttp.open("POST","MedicationAdministrationValidation.jsp?func_mode=getBedValues",true);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
}

async function bedSearch(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmobj=document.MedicationAdministrationSearchForm;
	var facility_id=frmobj.facility_id.value;
	var nursing_unit_code=frmobj.nursing_unit.value;
	if(nursing_unit_code=="" || facility_id=="")
		return false;
	var sql	="SELECT   bed_no CODE, bed_no description FROM ip_nursing_unit_bed WHERE NURSING_UNIT_CODE = '#' AND FACILITY_ID = '$'  and upper(bed_no) like upper(?) and upper(bed_no) like upper(?) AND eff_status = 'E'  ORDER BY 1";
	sql=sql.replace("#",nursing_unit_code);
	sql=sql.replace("$",facility_id);
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal =await CommonLookup("Bed Search", argumentArray );
	//var str =unescape(retVal);
	//var arr = str.split(",");
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "") {
		target.value = arr[1] ;
	}
	else{
		target.value="";
	}
}

function clear_from_beds(){
	document.MedicationAdministrationSearchForm.from_bed_no.value="";
}

function clear_to_beds(){
	document.MedicationAdministrationSearchForm.to_bed_no.value="";
}

function add_from_beds(code){
	document.MedicationAdministrationSearchForm.from_bed_no.value=code;
}

function add_to_beds(code){
	document.MedicationAdministrationSearchForm.to_bed_no.value=code;
}

function clearQtyDescList(){
	var len =document.MedicationAdministrationEntryForm.qty_desc.options.length;
	for(var i=0;i<len;i++) {
		document.MedicationAdministrationEntryForm.qty_desc.remove("qty_desc") ;
	}
	var tp = " --- "+getLabel("ePH.Select.label",'PH')+" --- ";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.MedicationAdministrationEntryForm.qty_desc.add(opt);
}

function addQtyDescList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.MedicationAdministrationEntryForm.qty_desc.add(element);
}

function setdfltQtyUom(code,desc)	{
	document.MedicationAdministrationEntryForm.qty_desc.value=desc;
}

function callAmendEntry(drug_code,srl_no){
	parent.AdminDetailFrameSet.rows="70,*,170,21";
	parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?mode=entryAmend&drug_code="+drug_code+"&srl_no="+srl_no;
}

function chkAdminDate(obj,locale){
	var sys_date=document.MedicationAdministrationEntryForm.sys_date;
	var facility_id=document.MedicationAdministrationEntryForm.facility_id.value;
	if(obj.value!=""){
		//if(doDateTimeChk(obj)){
		if(validDate(obj.value, "DMYHM",locale)){
			if(ValidateDateTime(obj,sys_date, locale)){
				var admin_date=obj.value;
				var xmlStr ="<root><SEARCH ";
				xmlStr+=" admin_date=\""+ admin_date + "\" ";
				xmlStr+=" facility_id=\""+ facility_id + "\" ";
				xmlStr +=" /></root>";
				return fieldValidation(xmlStr,"validateAdminDate");
			}
			else{
				alert(getMessage("PH_MEDN_ADMIN_DATE",'PH'));
				obj.focus();
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME",'PH'));
			obj.focus;
		}
	}
}

function validateForExpiry(expiry_date){
	var sys_date_without_time=document.MedicationAdministrationEntryForm.sys_date_without_time;
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" sys_date_without_time=\""+ sys_date_without_time + "\" ";
	xmlStr+=" expiry_date=\""+ expiry_date.value + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicationAdministrationValidation.jsp?func_mode=ValidateExpiry",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
}

function warnExpiry(){
	alert(getMessage("PH_EXPDATE_GREATER_SYSDATE",'PH'));
	document.MedicationAdministrationEntryForm.expiry_date.focus();
}

function alertAdminDate(){
	alert(getMessage("PH_MEDN_ADMINDATE_NEWENTRY",'PH'));
	document.MedicationAdministrationEntryForm.admin_date_time.focus();
}

function windexpand(obj){
	document.MedicationAdministrationPatientLine.maximageTD.style.display="none";
	parent.f_admin_chart.location.href	="../../eCommon/html/blank.html";
	parent.f_admin_detail.location.href	="../../eCommon/html/blank.html";
	parent.AdminDetailFrameSet.rows="70,*,21,170";
}

function refreshnewEntryPage(){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var encounter_id=parent.f_admin_chart.MedicationAdministrationChartForm.encounter_id.value;
	var admin_from_date=parent.f_admin_chart.MedicationAdministrationChartForm.admin_from_date.value;
	//var include_past_timings=parent.f_admin_chart.MedicationAdministrationChartForm.past_time_yn.value;

	var admin_date_time = parent.f_admin_detail.MedicationAdministrationEntryForm.admin_date_time.value;
	var drug_code	= parent.f_admin_detail.MedicationAdministrationEntryForm.drug_code.value;

	var admin_dt_time_array = admin_date_time.split(" ");
	var admin_dt = admin_dt_time_array[0];
	var admin_time = admin_dt_time_array[1];

	var selDateTime=drug_code+ admin_dt +admin_time
	var patient_id = parent.f_admin_chart.MedicationAdministrationChartForm.patient_id.value;

	parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?mode=NOTIME&encounter_id="+encounter_id+"&admin_from_date="+admin_from_date+"&time=00:00&selDateTime="+selDateTime+"&patient_id="+patient_id;
	parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode=noniv&sel_schedule_time="+selDateTime;
}

function hideframe(){
	parent.AdminDetailFrameSet.rows="70,*,21,170";
}

function dfltEntryDetails(srl_no,drug_code,drug_name,pract_id,pract_name,route_code,dose_qty,qty_uom,freq_code,admin_date_time,batch_id,expiry_date,trade_name){
	getFormCode(drug_code);
	if(parent.f_admin_detail == null){
		var entryFormObj = document.frames.MedicationAdministrationEntryForm.all;
		entryFormObj.pract_name.value=pract_name;
		entryFormObj.pract_code.value=pract_id
		entryFormObj.drug_code.value=drug_code;
		entryFormObj.drug_name.value=drug_name;
		entryFormObj.route.value=route_code;
		entryFormObj.dose_qty.value=dose_qty;
		entryFormObj.qty_desc.value=qty_uom;

		entryFormObj.freq.value=freq_code;
		entryFormObj.admin_date_time.value=admin_date_time;
		entryFormObj.srl_no.value=srl_no;
		entryFormObj.batch_id.value=batch_id;
		entryFormObj.expiry_date.value=expiry_date;
		entryFormObj.trade_name.value=trade_name;
	}
	else{
		parent.f_admin_detail.MedicationAdministrationEntryForm.pract_name.value=pract_name;
		parent.f_admin_detail.MedicationAdministrationEntryForm.pract_code.value=pract_id;
		parent.f_admin_detail.MedicationAdministrationEntryForm.drug_code.value=drug_code;
		parent.f_admin_detail.MedicationAdministrationEntryForm.drug_name.value=drug_name;
		parent.f_admin_detail.MedicationAdministrationEntryForm.route.value=route_code;
		parent.f_admin_detail.MedicationAdministrationEntryForm.dose_qty.value=dose_qty;
		parent.f_admin_detail.MedicationAdministrationEntryForm.qty_desc.value=qty_uom;
		parent.f_admin_detail.MedicationAdministrationEntryForm.freq.value=freq_code;
		parent.f_admin_detail.MedicationAdministrationEntryForm.admin_date_time.value=admin_date_time;
		parent.f_admin_detail.MedicationAdministrationEntryForm.srl_no.value=srl_no;
		parent.f_admin_detail.MedicationAdministrationEntryForm.batch_id.value=batch_id;
		parent.f_admin_detail.MedicationAdministrationEntryForm.expiry_date.value=expiry_date;
		parent.f_admin_detail.MedicationAdministrationEntryForm.trade_name.value=trade_name;
		mode='entryAmend';
		parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode="+mode;
	}
}

function cancelDetails(mode,objValue){

	var formObj = parent.f_button.document.MedicationAdministrationButton.all;
	parent.f_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp";
	parent.AdminDetailFrameSet.rows="90,*,0,20";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(formObj.direct_admin.value=="Y"){
		formObj.add_button.style.display="inline";
		formObj.add_button.style.visibility="visible";
	}
	formObj.record.style.display="none";
	formObj.cancel.style.display="none";
	var encounter_id=parent.f_admin_chart.MedicationAdministrationChartForm.encounter_id.value;

	if(mode=="insertDetails"){
		var obj = parent.f_patient_line.f_bedheader.MedicationAdministrationBedPatientHeader.all;
		eval("obj.patient_id_"+obj.selected_patient_id_row.value).click();
	}
	if(objValue=="cancelSelScheduleDateTime"){
		if(formObj.sel_schedule_time.value != ""){

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();

			xmlStr	="<root><SEARCH " ;
			xmlStr += "sel_schedule_date_time=\""+ formObj.sel_schedule_time.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?func_mode=cancelSelScheduleDateTime", false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);

			var obj = parent.f_patient_line.f_bedheader.MedicationAdministrationBedPatientHeader.all;
			eval("obj.patient_id_"+obj.selected_patient_id_row.value).click();
		}
	}
}

function enablePage(size){
	if(size!='0'){
		if(parent.f_admin_chart.MedicationAdministrationChartForm != null){
			var encounter_id=parent.f_admin_chart.MedicationAdministrationChartForm.encounter_id.value;
			var admin_from_date=parent.f_admin_chart.MedicationAdministrationChartForm.admin_from_date.value;
			var admin_from_date=parent.f_admin_chart.MedicationAdministrationChartForm.admin_to_date.value;
			//var include_past_timings=parent.f_admin_chart.MedicationAdministrationChartForm.past_time_yn.value;
			//parent.AdminDetailFrameSet.rows="70,*,23,100,0";
			//parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?mode=NOTIME&encounter_id="+encounter_id+"&admin_due_date="+admin_due_date+"&time=00:00";
			mode='entryAmend';
			parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode=noniv";
		}
	}
}

function showAdminToDate(obj){

	var current_date_time = obj.value;
	var bean_id           = document.getElementById('ft_bean_id').value;
	var bean_name         = document.getElementById('ft_bean_name').value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "current_date_time=\""+ current_date_time +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=showAdminToDate", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function showAdminFromDate(obj){
	var current_date_time = obj.value;
	var bean_id           = document.getElementById('ft_bean_id').value;
	var bean_name         = document.getElementById('ft_bean_name').value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "current_date_time=\""+ current_date_time +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=showAdminFromDate", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function assignAdminFromDate(date_time){
	document.getElementById('admin_from_date').value = date_time;
}
function assignAdminToDate(date_time){
	document.getElementById('admin_to_date').value = date_time;
}


//code added for Recording ADR Details

function checkFields( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " "+getLabel("Common.Cannotbeblank.label",'Common')+"..." + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}


async function recordADR(encounter_id,drug,recno, obj,sch_date,order_id,  order_no, callFrom, scheKey, colvalue){
	if(sch_date ==undefined)
		sch_date = "";
	if(callFrom ==undefined)
		callFrom = "";
	if(scheKey ==undefined)
		scheKey = "";
	if(colvalue ==undefined)
		colvalue = "";

	var dialogHeight	= "55vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "250" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal =  await window.showModalDialog("../../ePH/jsp/MedicationAdminAdrRemarks.jsp?drug="+drug+"&recno="+recno+"&encounter_id="+encounter_id+"&sch_date="+sch_date+"&order_id="+order_id+"&order_no="+order_no+"&callFrom="+callFrom+"&scheKey="+scheKey+"&sch_date_time="+sch_date+"&colvalue="+colvalue,arguments,features);
	if(retVal=="OK"){
		if(callFrom=='SCH')
			return retVal;
		obj.src="../../eOR/images/Authorization.gif" ;
		obj.title="Post Administration Details Recorded" ;
		document.MedicationAdministrationFTDrugDetails.adr_recorded.value="Y";
	}
}

async function recordPRN(patient_id,encounter_id){

	if(patient_id == ""){
		patient_id   = parent.frames[2].document.forms[0].patient_id_selected.value;
		encounter_id = parent.frames[2].document.forms[0].encounter_id.value;
	}
	else if(patient_id == null || patient_id == undefined){
		patient_id   = parent.frames[2].document.MedicationAdministrationChartForm.patient_id.value;
		encounter_id = parent.frames[2].document.MedicationAdministrationChartForm.encounter_id.value;
	}
	var dialogHeight	= "30vh" ;
	var dialogWidth		= "50vw";
	var dialogTop		= "250" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal = await window.showModalDialog("../../ePH/jsp/MedicationAdminPRN.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
}

function setADRDetails(formObj, callFrom){
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = formObj.scheduled_date ;
	fields[1]	= formObj.reason_code;
	fields[2]	= formObj.remarks;
	fields[3]	= formObj.record_date;
	fields[4]	= formObj.administered_by;
	names[0]    = getLabel("ePH.ScheduledDateTime.label",'PH') ;
	names[1]	=  getLabel("Common.reason.label",'Common');
	names[2]	=  getLabel("Common.remarks.label",'Common');
	names[3]	= getLabel("Common.recordeddate.label",'Common');
	names[4]	= getLabel("Common.RecordedBy.label",'Common');

	for(i=0; i<fields.length;i++){
		if(!checkField( fields[i], names[i])){
			return false;
		}
	}
	//if(checkField( fields, names)){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "scheduled_date=\"" + formObj.scheduled_date.value + "\" " ;
		xmlStr+= "reason_code=\"" + formObj.reason_code.value + "\" " ;
		xmlStr+= "record_date=\"" + formObj.record_date.value + "\" " ;
		xmlStr+= "remarks=\"" + encodeURIComponent(formObj.remarks.value,"UTF-8") + "\" " ;
		xmlStr+= "administered_by=\"" + formObj.administered_by.value + "\" " ;
		xmlStr+= "drug=\"" + formObj.drug.value + "\" " ;
		xmlStr+= "recno=\"" + formObj.recno.value + "\" " ;
		xmlStr+= "order_id=\"" + formObj.order_id.value + "\" " ;
		xmlStr+= "encounter_id=\"" + formObj.encounter_id.value + "\" " ;
		xmlStr+= "scheKey=\"" + formObj.scheKey.value + "\" " ;
		xmlStr+= "callFrom=\"" + callFrom + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=recordADRDtl";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		window.returnValue="OK";
		window.close();
}

function removeADRDetails(formObj){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug=\"" + formObj.drug.value + "\" " ;
	xmlStr+= "recno=\"" + formObj.recno.value + "\" " ;
	xmlStr+= "scheduled_date=\"" + formObj.scheduled_date.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=recordCancelADRDtl";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	window.close();
}

function getAdrRemarks(formObj){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason_code=\"" + formObj.reason_code.value + "\" " ;
	xmlStr+= "appl_trn_type=\"" + formObj.appl_trn_type.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=getAdrRemarks";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function setRemarks(remarks){
	document.ADRRemarksForm.remarks.value = decodeURIComponent(remarks); // decodeURIComponent added for SKR-SCF-0208 -IN029298
}

function setDefaultValues(formObj){
	formObj.remarks.value = "";
	sch = (formObj.sch_date_time.value);

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug=\"" + formObj.drug.value + "\" " ;
	xmlStr+= "scheduled_date=\"" + formObj.scheduled_date.value + "\" " ;
	xmlStr+= "formObj=\"" + formObj.name + "\" " ;
	xmlStr+= "sch_date_time=\"" + formObj.sch_date_time.value + "\" " ;
	xmlStr+= "encounter_id=\"" + formObj.encounter_id.value + "\" " ;
	xmlStr+= "order_id=\"" + formObj.order_id.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=getDefaultValues";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function ValidateDateTimeIBA (from,to){

	if (from.value != undefined){
		from = from.value;
	}
	else{
		from=from;
	}

	if (to.value != undefined){
		to = to.value;
	}
	else{
		to=to;
	}
    var objorval=from.value;
    var objorval2=to.value;
	if (objorval != undefined)  {
		from = from.value;
    }
	else{
		from = from;
	}

	if (objorval2 != undefined) {
		 to      = to.value;
    }
	else{
		 to      = to;
	}

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]
    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")
     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
     if(Date.parse(to_date) < Date.parse(from_date)) {
        return false;
    }
    else{
        return true;
	}
}

function validateDateTime(formObj,obj,locale){
	if(formObj.name == "ADRRemarksForm"){
		if( obj.value!=""){
			if(!(validDate(obj.value, "DMYHM",locale))){
				alert(getMessage("INVALID_DATE_TIME", "PH"));
				obj.value="";
				obj.focus();
				return false;
			}
		}
		return true;
	}
	else{
	//if( ( formObj.administration_status.value=="DUE")||(formObj.administration_status.value=="OVERDUE" && obj.name=="to_time")){
		if(obj.value!=""&&formObj.from_time.value!==""&&formObj.to_time.value!==""){
			if(validDate(obj.value, "DMYHM",locale)){
				var xmlStr ="<root><SEARCH ";
				xmlStr+= "obj_name=\""	+ obj.name + "\" " ;
				xmlStr+= "from_time=\"" + formObj.from_time.value + "\" " ;
				xmlStr+= "to_time=\""	+ formObj.to_time.value   + "\" " ;
				xmlStr+= "admin_from_date=\"" + formObj.admin_from_date.value + "\" " ;
				xmlStr+= "admin_to_date=\""	  + formObj.admin_to_date.value   + "\" " ;
				xmlStr +=" /></root>";
				var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=validateDateTime";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;
				eval(responseText);
			}
			else{
				alert(getMessage("INVALID_DATE_TIME", "PH"));
				obj.value="";
				obj.focus();
				return false;
			}

		}
		else{
			if(formObj.from_time.value==""){
				var onBlurfn = formObj.from_time.onblur;
				formObj.from_time.onblur = null;
				alert(getMessage("PH_FROM_TIME_NOT_BLANK",'PH'));
				setTimeout(function() {
							formObj.from_time.blur(); 
							formObj.from_time.onblur =onBlurfn;
							  

				}, 1000);
				formObj.from_time.focus();

			}
			else if(formObj.to_time.value==""){
				var onBlurfn = formObj.to_time.onblur;
				formObj.to_time.onblur = null;
				alert(getMessage("PH_TO_TIME_NOT_BLANK",'PH'));
				setTimeout(function() {
					formObj.to_time.blur(); 
					formObj.to_time.onblur =onBlurfn;
					  

				}, 1000);
				formObj.to_time.focus();
			}
		}
	}
}

function changeFromTime(){
	var formobj=document.MedicationAdministrationSearchForm;
	if(formobj.administration_status.value!="ALL" && formobj.administration_status.value!="DOA") //  && formobj.administration_status.value!="DOA" Added for GHL-CRF-0458
		formobj.from_time.value=formobj.admin_from_date.value;
}

function showAlert(obj,msg){
	if(!(obj=="from_time" && (document.MedicationAdministrationSearchForm.administration_status.value=="ALL" || document.MedicationAdministrationSearchForm.administration_status.value=="DOA"))){ // || document.MedicationAdministrationSearchForm.administration_status.value=="DOA" Added for GHL-CRF-0458
		alert(getMessage(msg,'PH'));
		eval("document.MedicationAdministrationSearchForm."+obj).value="";
	}
}

function changeColor(obj){
	obj.style.backgroundColor="#FFD7D7";
}

function chkforRemarks(frmObj){
	var arrObj = frmObj.elements;
	var tep;
	var chk_obj;
	var chk_obj1;
	var frmObjs = new Array()
    if(frmObj.name == null){
        frmObjs = frmObj ;
	}
	else{
		frmObjs[0] = frmObj ;
	}
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		var val="N";
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++) {
            if(arrObj[i].type == "checkbox") {
				obj_name	= arrObj[i].name;
				 var name_str	=	obj_name.substr(0,6);
			     var name_str1  =   obj_name.substr(0,10);
				 var result;
				if(name_str=="iv_chk"){
					var p=obj_name.length;
					var s=obj_name.substr(p-1,p);
					chk_obj	=	eval(frmObj.document.getElementById("iv_remarks_mand_id_")+s);
				}
				if(name_str1=="non_iv_chk"){
					var m=obj_name.length;
					var n=obj_name.substr(m-1,m);
					chk_obj1	=	eval(frmObj.document.getElementById("drug_remarks_mand_id_")+n);
				}

				var nt=obj_name.length;
                tep=obj_name.substr(nt-1,nt);
				if((name_str=="iv_chk") && tep == "1"){
					val="Y";
					var t=obj_name.length;
					var row_no=obj_name.substr(t-1,t);
					var drug_code=frmObj.iv_drug_code_1.value;
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr	="<root><SEARCH " ;
					xmlStr += "row_no=\""+ row_no +"\" " ;
					xmlStr += "drug_code=\""+ drug_code +"\" " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=validateRemarksForDrug", false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=eval(xmlHttp.responseText);
					if(responseText== true){ break;}
				}
				 else if(name_str1=="non_iv_chk" && (chk_obj1.style.display =='' ||chk_obj1.style.display =='inline')){
					val="Y";
					var t=obj_name.length;
					var row_no=obj_name.substr(t-1,t);
					var drug_code=frmObj.drugCode.value;
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr	="<root><SEARCH " ;
					xmlStr += "row_no=\""+ row_no +"\" " ;
					xmlStr += "drug_code=\""+ drug_code +"\" " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=validateRemarksForDrug", false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=eval(xmlHttp.responseText);
				}
			}
		}
	}
	if(chk_obj1 != undefined){
		if(chk_obj1.style.display =='none'){
			return true;
		}
	}
	if(val=="Y" && responseText == true){
		return true;
	}
	else if(val=="Y" && responseText == false){
		return false;
	}
	else if(val=="N"){
		return true;
	}
}

function setframe(no){
	var n;
	if(no >= 3 <=15) {
		n=(no*3)+20;
	}
	else if (no > 15 ){
		n=(no*3)+40;
	}
	//else if(no > 3 && no <= 40) {n=(no*2.8)+20;}
	//else if(no > 40 && no <= 50 ){n=(no*3)+25;}
	//else if(no > 50 && no <= 60 ){n=(no*3)+30;}
	//else if(no > 60){n=(no*4)+25;}
	document.body.scrollTop=document.body.scrollTop+n;
 }

function reloadAdminRoutes(obj){
	var route_categ_code=obj.value;
	frmObj=document.MedicationAdministrationSearchForm
	var len =frmObj.route_of_admin.options.length;
	for(var i=0;i<len;i++) {
		frmObj.route_of_admin.remove("route_of_admin") ;
	}
	var element = document.createElement('OPTION') ;
	element.value		="";
	element.text		="--"+getLabel("Common.defaultSelect.label",'Common')+"--";
	frmObj.route_of_admin.add(element);
	frmObj.route_of_admin.selectedIndex= 0 ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=getAdminRouteDetails&route_categ_code="+route_categ_code, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function AddAdminRoutes(rt_code,rt_description){
	frmObj=document.MedicationAdministrationSearchForm;
	var element = document.createElement('OPTION') ;
	element.value		=rt_code;
	element.text		=rt_description;
	frmObj.route_of_admin.add(element);
}

async function callADRdetails(patient_id,drug_code){//newly added for RUT-SCF-0144 [IN:033371]
	var dialogHeight= "60vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "305" ;
	var dialogLeft = "180" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/AdrReportingFrame_1.jsp?type=query "+"&status=S"+"&drug_code="+drug_code+"&patient_id="+patient_id ,arguments,features);
}

function viewByChange(viewByObj){
	var formObj= document.MedicationAdministrationSearchForm;
	var viewBy = viewByObj.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "viewBy=\""+ viewBy +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=getDateRangeDef", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	document.MedicationAdministrationSearchForm.btnSearch.click();
}

function assignDateRange(from_date, to_date){
	var formObj= document.MedicationAdministrationSearchForm;
	formObj.fromDate.value=from_date;
	formObj.toDate.value=to_date;
}

function showHideCriteria(showHideFlag){
	if(showHideFlag==undefined)
		showHideFlag='';
	var rowsSize ="30,*";
	var btnValue=getLabel("Common.morecriteria.label",'Common') ;
	var btnId='Show';
	if(showHideFlag=='H')
		var formObj= parent.parent.f_search.document.MedicationAdministrationSearchForm;
	else
		var formObj= document.MedicationAdministrationSearchForm;
	btnShowCriteria = formObj.btnShowCriteria.id;
	if(btnShowCriteria == 'Show' && showHideFlag==''){
		rowsSize ="105,*";
		btnId='Hide';
		btnValue = getLabel("ePH.HideCriteria.label",'PH') ;
	}
	else if(btnShowCriteria == 'Hide' || showHideFlag=='H'){
		rowsSize ="30,*";
		btnId='Show';
		btnValue = getLabel("Common.morecriteria.label",'Common') ;
	}
	formObj.btnShowCriteria.id=btnId;
	formObj.btnShowCriteria.value=btnValue;
	if(showHideFlag=='H')
	{
		//parent.parent.parent.workAreaFrame.MARFrameset.rows=rowsSize; //workAreaFrame--frames[3]
		parent.parent.parent.workAreaFrame.document.getElementById('f_search').style.height="5vh";
		parent.parent.parent.workAreaFrame.document.getElementById('f_query_add_mod').style.height="94vh";
	}
	else
	{
		parent.document.getElementById('f_search').style.height="5vh";
		parent.document.getElementById('f_query_add_mod').style.height="94vh";
		//parent.MARFrameset.rows=rowsSize;
	}
		
}

function SubmitLink( navigation){
	var formObj =  document.MedicationAdministrationSearchForm;
	var viewBy = formObj.viewBy.value;
	var fromDate = formObj.fromDate.value;
	var toDate = formObj.toDate.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	if(viewBy=='' || fromDate==''  || toDate=='')
		return false;
	xmlStr	="<root><SEARCH " ;
	xmlStr += "viewBy=\""+ viewBy +"\" " ;
	xmlStr += "fromDate=\""+ fromDate +"\" " ;
	xmlStr += "toDate=\""+ toDate +"\" " ;
	xmlStr += "navigation=\""+ navigation +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=getPrevNextDateRange", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	searchMednAdmin("MARSCH");
}

async function dispAdminOptions(scheKey,administered_yn, admin_recorded_yn,callFrom, orderCount, schCount, schDayCount,recCount, status, dosage_seq_no, drugCount,mfr_yn,completed_flow,cancelYn,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom,iv_prep_val){//mfr_yn added for ML-MMOH-CRF-1014
	//cancelYn,admin_by_name,drug_desc added for JD-CRF-0200

	var frmObj=document.MedicationAdministrationSchLevelDrugDtls;
	var hold ="";
	var oncoMFR = "N";//ML-MMOH-CRF-1014
	var future_admin = ""; // Added for GHL-CRF-0482
	if(callFrom=='NONIV' ){

		if(mfr_yn=="Y")
		oncoMFR = mfr_yn;
	   if(eval("frmObj.future_admin_"+orderCount+"_"+schCount+"_"+schDayCount)!=undefined){ // Added for GHL-CRF-0482 - Start
		future_admin = eval("frmObj.future_admin_"+orderCount+"_"+schCount+"_"+schDayCount).value;
	   } // Added for GHL-CRF-0482 - End
		var disccontinued = eval("frmObj.discontinued"+orderCount).value;
		hold = eval("frmObj.hold"+orderCount).value;
		var mar_disc_dose_yn = frmObj.mar_disc_dose_yn.value;
		if(administered_yn !='Y' && disccontinued=="Y" && mar_disc_dose_yn!="Y"){
			return false;
		}
		if(disccontinued=="Y" && administered_yn!='Y'){
			var conform = false;
			var discontinued_dose = eval("frmObj.discontinued_dose_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			if(mar_disc_dose_yn=="Y" && discontinued_dose=='Y'){
				 conform = confirm(getMessage("PH_MAR_DISCONTIUED_DRUG", "PH"));
			}
			if(conform)
				return await callMenuFunctionsSch('AD', 'NONIV', orderCount,schCount, schDayCount, recCount,scheKey,'Y', drugCount);
			else
				return false;

		}
	}
	if((callFrom=='NONIV' || callFrom=='PRN') && administered_yn !='Y'){
		var allowPRN = eval("frmObj.allowPRN_"+orderCount+"_"+schCount+"_"+schDayCount);
		if(allowPRN != undefined && schCount>0){
			var allowPRN_prev = eval("frmObj.allowPRN_"+orderCount+"_"+(parseInt(schCount)-1)+"_"+schDayCount);
			if(allowPRN_prev != undefined && allowPRN_prev.value=='Y'){
				alert(getMessage("PH_MAR_ADMIN_PREV_PRN_DOSE", "PH"));
				return false;
			}
		}
	}
	obj=document.getElementById("order" + scheKey);
	var calval="";

	if(hold=="Y"){
		calval="RE,DC";
	}
	else if(administered_yn !='Y'){
		if(callFrom=='IV' ){
			var MfrYN = eval("document.forms[0].MfrYN"+orderCount).value;
			if(MfrYN=='Y'){
				var formMFR=document.MedicationAdministrationSchLevelDrugDtls;
				var order_id = eval("formMFR.iv_order_id_"+orderCount).value;
				var order_line_num = eval("formMFR.iv_order_line_no_"+orderCount).value;
				var iv_prep_yn = eval("formMFR.iv_prep_yn"+orderCount).value;
				var ord_drug_code = eval("formMFR.iv_drug_code_"+orderCount).value;
				var drugdesc = encodeURIComponent(eval("formMFR.iv_drug_desc_"+orderCount).value,"UTF-8");
				var disp_locn_code = eval("formMFR.disp_locn_code"+orderCount).value;
				var iv_Auto_Admin = eval("formMFR.iv_Auto_Admin_"+orderCount).value;
				var from_time = formMFR.adminFromDateTime.value;
				var iv_discontinued = eval("formMFR.iv_discontinued"+orderCount).value;
				var iv_hold = eval("formMFR.iv_hold"+orderCount).value;
				var calledFrom = 'Admin';
				if(iv_hold=='Y' || iv_discontinued=='Y'  )
					calledFrom = 'NotAdmin'
				await openMFRDetails(orderCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,'SCH', schCount, schDayCount);
			}//ML-MMOH-CRF-1014 - start
			else{
				if(status=="NS")
					calval="ST,AD";
				else if(status=="ST")
					calval="HO,CH,CO";
				else if(status=="HO")
					calval="RE,CO";
				else if(status=="RE")
					calval="HO,CH,CO";
			}
		}else if(callFrom=="NONIV" && mfr_yn=="Y" ){
			//var MfrYN = eval("document.forms[0].MfrYN"+orderCount).value;


				var formMFR=document.MedicationAdministrationSchLevelDrugDtls;
				var MfrYN = eval("formMFR.MfrYN"+orderCount).value;

				if(MfrYN=='Y' || mfr_yn=="Y"){
				var order_id = eval("formMFR.non_iv_order_id_"+orderCount).value;
				var order_line_num = eval("formMFR.non_iv_order_line_no_"+orderCount).value;
				var iv_prep_yn = eval("formMFR.iv_prep_yn"+orderCount).value;
				var ord_drug_code = eval("formMFR.non_iv_drug_code_"+orderCount).value;
				var drugdesc = encodeURIComponent(eval("formMFR.non_iv_drug_desc_"+orderCount).value,"UTF-8");
				var disp_locn_code = eval("formMFR.non_iv_store_code_"+orderCount).value;
				var iv_Auto_Admin = eval("formMFR.non_iv_Auto_Admin_"+orderCount).value;
				var from_time = formMFR.adminFromDateTime.value;
				var iv_discontinued = eval("formMFR.discontinued"+orderCount).value;
				var iv_hold = eval("formMFR.hold"+orderCount).value;
				var calledFrom = 'Admin';
				oncoMFR = "Y";//ML-MMOH-CRF-1014
				if(iv_hold=='Y' || iv_discontinued=='Y'  )
					calledFrom = 'NotAdmin'
				if(completed_flow!="true")
					await openMFRDetails(orderCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,'SCH', schCount, schDayCount,"N","Y");
				else
					calval = "AD,VMFR";
			}
			else{
				if(status=="NS")
					calval="ST,AD";
				else if(status=="ST")
					calval="HO,CH,CO";
				else if(status=="HO")
					calval="RE,CO";
				else if(status=="RE")
					calval="HO,CH,CO";
			}
		}
		else{
			if(admin_recorded_yn=='Y')
				calval ='AD,SAD,HD,DC';
			else
				calval ='AD,SAD,HD,CNAD,DC';
		}
	}
	else{
		if(status == 'PAD'){
			await loadAdminDetails(orderCount,schCount, schDayCount, recCount, scheKey);
			return;
		}
		else if(callFrom=='NONIV' ){
			if(mfr_yn!="Y")
			  if(cancelYn == 'Y')//added for JD-CRF-0200
				calval="PAD,VAD,CAN";
			  else
				  calval="PAD,VAD";
			else
				if(cancelYn == 'Y' &&(iv_prep_val=="" || iv_prep_val==null || iv_prep_val=="1" || iv_prep_val=="3" ||iv_prep_val=="5" || iv_prep_val=="9" ))//added for JD-CRF-0200
				calval="PAD,VAD,CAN";
				else
					calval="PAD,VAD";
		}
		else if(callFrom == 'PRN'){
			var maxdosecount = eval("frmObj.maxdosecount_"+orderCount).value;
			var sch_date_time = eval("frmObj.sch_date_time_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var sch_date = eval("frmObj.sch_date_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var sch_dosage_qty = eval("frmObj.sch_dosage_qty"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var end_schedule = sch_date+" 23:59";
			var locale = frmObj.locale.value;
			if(schCount == maxdosecount && !isBefore(end_schedule,sch_date_time,"DMYHM",locale) && parseInt(sch_dosage_qty)>0)
				if(cancelYn == 'Y')//added for JD-CRF-0200
				calval="ADPRN,PAD,VAD,CAN";
				else
					calval="ADPRN,PAD,VAD";
			else
				if(cancelYn == 'Y' && (iv_prep_val=="" || iv_prep_val==null || iv_prep_val=="1" ||  iv_prep_val=="3" ||iv_prep_val=="5" || iv_prep_val=="9" )) //added for JD-CRF-0200
				calval="PAD,VAD,CAN";
				else
					calval="PAD,VAD";
		}
	}

	await buildTableSch(scheKey,administered_yn, callFrom, calval, orderCount, schCount, schDayCount, recCount, drugCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR,future_admin,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom);//drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR added for ML-MMOH-CRF-1014 // future_admin Added for GHL-SCF-0482//admin_by_name,drug_desc ADDED FOR JD-CRF-0200
	await resizeWindowSch(obj);
}

async function hideAdminOptions(row){
	//obj=eval(document.getElementById("order")+row);
	obj = document.getElementById("order" + row);
	await dynamichideSch(obj, window.event,row);
}

var prevObjIDSch;

function buildTableSch(scheKey,administered_yn, callFrom, colvals, orderCount, schCount, schDayCount, recCount, drugCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR,future_admin,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom) {//drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR for ML-MMOH-CRF-1014 // future_admin Added for GHL-CRF-0482


	//admin_by_name,drug_desc ADDED FOR JD-CRF-0200

	var rowval   = colvals.split (",");
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='left'>"
	var descval="";
	for( var i=0; i<rowval.length; i++ ) {
		var colval  = rowval[i]
		if (colval != ""){
			if(administered_yn!='Y'){
				if(callFrom=='IV'){
					if(colval=="ST")
						descval=getLabel("ePH.START.label",'PH');
					if(colval=="AD")
						descval=getLabel("Common.Administer.label",'Common');
					else if(colval=="HO")
						descval=getLabel("ePH.Hold.label",'PH');
					else if(colval=="RE")
						descval=getLabel("ePH.RESUME.label",'PH');
					else if(colval=="CO")
						descval=getLabel("ePH.COMPLETE.label",'PH');
					else if(colval=="CH")
						descval=getLabel("Common.change.label",'Common')+" "+getLabel("ePH.FlowRate.label",'PH');
				}
				else{
					if(colval=="AD" && future_admin =="F") // if condition Added for GHL-CRF-0482 - Start
						descval=getLabel("ePH.EarlyAdmin.label",'PH'); // if condition Added for GHL-CRF-0482 - End
					else if(colval=="AD")
						descval=getLabel("ePH.admin.label",'PH');
					else if(colval=="SAD")
						descval=getLabel("ePH.selfadmin.label",'PH');
					else if(colval=="HD")
						descval=getLabel("ePH.Hold.label",'PH');
					else if(colval=="CNAD")
						descval=getLabel("ePH.CouldNotAdmin.label",'PH');
					else if(colval=="DC")
						descval=getLabel("Common.Discontinue.label",'Common');
					else if(colval=="RE")
						descval=getLabel("ePH.RESUME.label",'PH');
					else if(colval=="VMFR") // ML-MMOH-CRF-1014
						descval="View MFR Details";
				}
			}
			else{
				if(colval=="PAD")
					descval=getLabel("ePH.RecordPostAdminDetails.label",'PH');
				else if(colval=="VPAD")
					descval=getLabel("ePH.ViewPostAdminDetails.label",'PH');
				else if(colval=="VAD")
					descval=getLabel("ePH.ViewAdminDetails.label",'PH');
				else if(colval=="ADPRN")
					descval=getLabel("ePH.AddPRN.label",'PH');
				else if(colval=="CAN")//added for JD-CRF-0200
					descval="Cancel Admin";
			}

			tab_dat = tab_dat+"<tr>"
			tab_dat=tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOverSch(this)' onMouseOut='callOnMouseOutSch(this);' onClick=callMenuFunctionsSch('"+colval+"','"+callFrom+"','"+orderCount+"','"+ schCount+"','"+ schDayCount+"','"+recCount+"','"+scheKey+"','','"+drugCount+"','"+drugdesc+"','"+ord_drug_code+"','"+disp_locn_code+"','"+calledFrom+"','"+order_id+"','','"+iv_Auto_Admin+"','"+oncoMFR+"','"+future_admin+"','"+admin_by_name+"','"+encodeURIComponent(drug_desc,"UTF-8")+"','"+qty+"','"+encodeURIComponent(admin_date_time,"UTF-8")+"','"+strength_per_value_pres_uom+"');>"+descval+" </td>" // future_admin Added for GHL-CRF-0482
			tab_dat=tab_dat+ "</tr> "
//'"+drugdesc+"','"+ord_drug_code+"','"+disp_locn_code+"','"+calledFrom+"','"+order_id+"','','"+iv_Auto_Admin+"','"+oncoMFR+ added for ML-MMOH-CRF-1014
		}
	}
	tab_dat=tab_dat+ "</table> ";
	document.getElementById('tooltiptd').innerHTML = tab_dat;
}	
		
function resizeWindowSch(orderctlHDR){
	var orderctlHDR1 = orderctlHDR.id;
	var wdth = document.getElementById(orderctlHDR1).offsetWidth;
	var hght1 = document.getElementById(orderctlHDR1).offsetHeight;

	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var z = bodwidth- (event.x + wdth);

	var x 	  = event.x;
	var y 	  = event.y;

	x 	  = x + (document.getElementById('tooltiplayer').offsetWidth);
	y 	  = hght + (document.getElementById('tooltiplayer').offsetHeight);	

	if(x<bodwidth){
		x= wdth1;
	}
	else{
		x = getPosSch(orderctlHDR).x-100;
	}
	if(y<bodheight){
		y = hght+15;
	}
	else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1;
	}
	document.getElementById('tooltiplayer').style.left= x+"px";
	document.getElementById('tooltiplayer').style.top = y+"px";
	document.getElementById('tooltiplayer').style.visibility='visible';
}

function getPosSch(inputElement){
	var coords =  new Object();
	coords.x = 0;
	coords.y = 0;
	try{
		targetElement = inputElement;
		if(targetElement.x && targetElement.y){
			coords.x = targetElement.x;
			coords.y = targetElement.y;
		}
		else{
			if(targetElement.offsetParent){
				coords.x += targetElement.offsetLeft;
				coords.y += targetElement.offsetTop;
				while(targetElement = targetElement.offsetParent){
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
				}
			}
		}
		return coords;
	}
	catch(error){
		return coords;
	}
}
function callOnMouseOutSch(obj){
	obj.className = 'contextMenuItem';
}
function callMouseOverSch(obj){
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';
}

function dynamichideSch(m, e,row){
	if (!this.isContainedSch(m, e)){
		this.delayhidemenuSch(row)
	}
}
function isContainedSch(m, e){
	var e=window.event || e
	var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
	while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
	if (c==m)
		return true
	else
		return false
}

function delayhidemenuSch(row){
	this.delayhide=setTimeout("hidemenuSch()", this.disappeardelay)
	//this.delayhide=setTimeout("hidemenuSch()", 50)
}

function hidemenuSch(){
	if(document.getElementById("tooltiplayer"))
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

async function callMenuFunctionsSch(colvalue, callFrom, orderCount, schCount, schDayCount, recCount,scheKey, admin_discontinue, drugCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR,future_admin,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom){//drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,oncoMFR added for ML-MMOH-CRF-1014 // future_admin Added for GHL-CRF-0482//admin_by_name,DRUG_DESC ADDED FOR JD-CRF-0200

	await hidemenuSch();
	var patientId = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var nursing_unit =document.forms[0].nursing_unit.value;
	var assign_bed_num =document.forms[0].assign_bed_num.value;
	var facility_id = document.forms[0].facility_id.value;
	var userAuthPINYN = document.forms[0].userAuthPINYN.value;
	if(admin_discontinue == undefined)
		admin_discontinue = 'N';
	var refresfMain = false;
	if(colvalue!='VAD' &&  colvalue!='VPAD'){
		if(!callUserAuthVal('SCH', userAuthPINYN)){
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			return false;
		}
	}
	if(callFrom=='NONIV' || callFrom=='PRN'){
		var order_id = eval("document.forms[0].non_iv_order_id_"+orderCount).value;
		var order_line_num = eval("document.forms[0].non_iv_order_line_no_"+orderCount).value;
		var iv_prep_yn = eval("document.forms[0].iv_prep_yn"+orderCount).value;
		var ord_drug_code = eval("document.forms[0].non_iv_drug_code_"+orderCount).value;
		var freq_code = eval("document.forms[0].freq_code"+orderCount).value;
		var encode_drug_desc = encodeURIComponent(eval("document.forms[0].non_iv_drug_desc_"+orderCount).value,"UTF-8");
		var drug_class = eval("document.forms[0].non_iv_drug_class"+orderCount).value;
		//MMS-KH-CRF-0017.1 - start
		var onco_direct_drug_count = eval("document.forms[0].onco_direct_drug_count_"+orderCount).value; //MMS-KH-CRF-0017.1
		var onco_iv_prep_yn = eval("document.forms[0].onco_iv_prep_yn_"+orderCount).value; //MMS-KH-CRF-0017.1
		if(onco_iv_prep_yn=="0" || onco_iv_prep_yn=="9")
			iv_prep_yn = onco_iv_prep_yn;
		//MMS-KH-CRF-0017.1 - end

		var dosage_seq_no,sch_date_time,sch_date,recExists = "";
		if(document.getElementById("dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount))
		 dosage_seq_no = document.getElementById("dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		if(document.getElementById("sch_date_time_"+orderCount+"_"+schCount+"_"+schDayCount))
		 sch_date_time = document.getElementById("sch_date_time_"+orderCount+"_"+schCount+"_"+schDayCount).value;

		if(document.getElementById("sch_date_"+orderCount+"_"+schCount+"_"+schDayCount))
		 sch_date = document.getElementById("sch_date_"+orderCount+"_"+schCount+"_"+schDayCount).value;

		if(document.getElementById("recExists_"+orderCount+"_"+schCount+"_"+schDayCount))
		 recExists = document.getElementById("recExists_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		var freq_nature = eval("document.forms[0].freq_nature_"+orderCount).value;
		var key = new Array();
		if(colvalue=='AD' || colvalue=='SAD'){
			if(freq_nature=='P' && recExists=='N'){
				refresfMain = true;
				await addPRNDose(orderCount, schCount, schDayCount, recCount, scheKey, 'Admin');
			}
			dialogTop		= "10";
			dialogHeight	= "90vh";
			dialogWidth		= "90vw";
			status			= "no";
			arguments		= "" ;
			features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;

			var action_url		=	'../../ePH/jsp/MARSchLevelDrugAdmin.jsp?&patient_id='+patientId+'&function_from=SCH&p_start_date_time='+sch_date_time+'&p_ord_drug_code='+ord_drug_code+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+dosage_seq_no+'&order_id='+order_id+"&order_line_num="+order_line_num+"&nursing_unit="+nursing_unit+"&iv_prep_yn="+iv_prep_yn+"&schCount="+schCount+"&schDayCount="+schDayCount+"&recCount="+recCount+"&adminOption="+colvalue+"&userAuthPINYN="+userAuthPINYN+"&callFrom=adminNONIV"+"&admin_discontinue="+admin_discontinue+"&sch_date="+sch_date+"&doseCount="+callFrom+"&mfr_yn="+oncoMFR+"&future_admin="+future_admin+"&onco_direct_drug_count="+onco_direct_drug_count+"&onco_iv_prep_yn="+onco_iv_prep_yn; // future_admin Added for GHL-CRF-0482 and onco_direct_drug_count added for MMS-KH-CRF-0017.1
			var retVal= await top.window.showModalDialog(action_url,arguments,features);
			if(retVal=='OK' || refresfMain){
				parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
			}
		}else if(colvalue=='VMFR' || (colvalue=='VAD' && oncoMFR=="Y")){//ML-MMOH-CRF-1014

			await openMFRDetails(orderCount,drugdesc,ord_drug_code,disp_locn_code,calledFrom,order_id, from_time, iv_Auto_Admin,'SCH', schCount, schDayCount,"N","Y");

		}else if(colvalue=='CNAD'){
			var retVal = await enterRemarks(encode_drug_desc,drug_class,orderCount,ord_drug_code,'SCH','',colvalue,freq_code,dosage_seq_no,'',order_id,order_line_num,encounter_id,false,iv_prep_yn,'','',sch_date_time,'','Y', assign_bed_num, nursing_unit,scheKey, '', '', '','Y'); //'Y' Added for AAKH-SCF-0296 IN062053
			if(retVal=='OK')
				parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
		}
		else if(colvalue=='HD' || colvalue=='DC'){
			retVal = await recordHoldDiscontinue(patientId , order_id, order_line_num , colvalue, sch_date_time);
			if(retVal=='OK')
				parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
		}
		else if(colvalue=='PAD' || colvalue=='VPAD'){
			retVal = await  recordADR(encounter_id,ord_drug_code,'1', '',sch_date_time,order_id,order_line_num, 'SCH', scheKey, colvalue);
			if(retVal=='OK')
				parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
		}
		else if(colvalue=='VAD'){
			await loadAdminDetails(orderCount,schCount, schDayCount, recCount, scheKey);
		}
		else if(colvalue=='ADPRN'){
			await addPRNDose(orderCount, schCount, schDayCount, recCount, scheKey, 'AddPRN');
		}
		else if(colvalue=='CAN'){//added for JD-CRF-0200

			//cancelAdminstration(drug_desc,admin_by_name,qty,admin_date_time);

			await cancelAdminstration(encode_drug_desc,admin_by_name,ord_drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq_no,qty,patientId,encounter_id,admin_date_time,strength_per_value_pres_uom);
			//changed drug_desc to encode_drug_desc for IN73000
		}
	}
	else {
		var MfrYN = eval("document.forms[0].MfrYN"+orderCount).value;
		if(MfrYN=='Y'){
			return;
		}
		else{
			drugIndex = 1;
			var recInserted = false;
			var formMain=document.MedicationAdministrationSchLevelDrugDtls;
			var order_id=eval("formMain.iv_order_id_"+orderCount).value;
			var order_line_num=eval("formMain.iv_order_line_no_"+orderCount).value;
			var drug_desc=eval("formMain.iv_drug_desc_"+orderCount).value;

			var srl_no=eval("formMain.iv_dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var MFR_flow_rate=eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			//var iv_sch_admin_date_time=eval("formMain.iv_admin_date_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value; Commented for SKR-SCF-0913[Inc:46556]
			var iv_sch_admin_date_time=eval("formMain.iv_sch_date_tim_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;//Added for SKR-SCF-0913[Inc:46556]
			var flowRateDurationUnitDesc1=eval("formMain.sch_infusion_per_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var iv_infusion_period=eval("formMain.iv_infusion_period_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var iv_prep_yn = eval("document.forms[0].iv_prep_yn"+orderCount).value;
			var batch_id=eval("formMain.iv_batch_id_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var expiry_date=eval("formMain.iv_expiry_date_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var trade_id = eval("formMain.iv_trade_id_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var trade_name = encodeURIComponent(eval("formMain.iv_trade_name_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value);
			var drug_code = eval("formMain.iv_drug_code_"+orderCount).value;
			var iv_Auto_Admin = eval("formMain.iv_Auto_Admin_"+orderCount).value;
			var disp_locn_code = eval("formMain.disp_locn_code"+orderCount).value;
			var patient_id = formMain.patient_id.value;
			var admin_from_date = formMain.adminFromDateTime.value;
			var admin_to_date = formMain.adminToTime.value;
			var encounter_id = formMain.encounter_id.value;
			var assign_bed_num = formMain.assign_bed_num.value;
			var nursing_unit = formMain.nursing_unit.value;
			var locale = formMain.locale.value;
			var flow_rate_changed_YN = "N";
			var h_iv_admin_qty = eval("formMain.h_iv_admin_qty_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			var iv_admin_qty = eval("formMain.iv_admin_qty_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
			//iv_sch_admin_date_time=convertDate(iv_sch_admin_date_time,'DMYHM',locale,"en");Commented for SKR-SCF-0913[Inc : 46556]
			var mar_iv_compl_dt_ind = formMain.mar_iv_compl_dt_ind.value;
			if(flowRateDurationUnitDesc1=="H")
				flowRateDurationUnitDesc="Hrs";
			else
				flowRateDurationUnitDesc="Min";
			var sch_infusion_vol_str_unit_desc=encodeURIComponent(eval("formMain.sch_infusion_vol_str_unit_desc"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value);
			formMain.current_date_time.value=getCurrentDate('DMYHM','en');

			var validateTime1 ="";
			var validateTime2 ="";
			if(colvalue=="CO" ){
				if(mar_iv_compl_dt_ind=='I')
					current_date_time=eval("formMain.sfrACT_END_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
				else
					current_date_time=formMain.current_date_time.value;
				validateTime2=formMain.current_date_time.value;
			}
			else if(colvalue=="ST" ){
				await getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex, 'SCH');
				current_date_time=eval("formMain.iv_admin_date_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value; //iv_infusion_st_time_
				//current_date_time=convertDate(current_date_time,'DMYHM',locale,"en");//commented for SKR-SCF-0913[Inc :46556]
				validateTime1=formMain.adminFromDateTime.value;
				validateTime2=formMain.current_date_time.value;
			}
			else if(colvalue!="AD") {
				prevHoldTime=eval("formMain.sfrHOLD_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
				prevResumedTime=eval("formMain.sfrRESUME_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
				if(colvalue=="RE" && prevHoldTime!="")
					validateTime1=prevHoldTime;
				else if(colvalue=="HO" && prevResumedTime!="")
					validateTime1=prevResumedTime;
				else{
					validateTime1= eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value
					validateTime1=convertDate(validateTime1,'DMYHM',locale,"en")
				}
				current_date_time=formMain.current_date_time.value;
				if(colvalue=="RE"){
					validateTime2= formMain.current_date_time.value;
				}
				else{
					validateTime2= eval("formMain.sfrACT_END_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
					if(!isBefore(validateTime2,current_date_time,"DMYHM",locale))
						validateTime2=current_date_time;
				}
			}
			if(colvalue!="AD"){
				var dialogWidth	= "90vw" ;
				var dialogHeight= "90vh" ;
				var dialogTop = "10" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var returnvalues=await top.window.showModalDialog("../../ePH/jsp/MedicationAdministrationFTMFRRemarks.jsp?linkValue="+colvalue+"&current_date_time="+current_date_time+"&validateTime1="+validateTime1+"&validateTime2="+validateTime2+"&MFR_flow_rate="+MFR_flow_rate+"&flowRateDurationUnitDesc="+flowRateDurationUnitDesc+"&sch_infusion_vol_str_unit_desc="+sch_infusion_vol_str_unit_desc+"&h_iv_admin_qty="+h_iv_admin_qty+"&drugdesc="+encodeURIComponent(drug_desc,"UTF-8")+"&sch_date_time="+iv_sch_admin_date_time+"&batch_id="+batch_id+"&expiry_date="+expiry_date+"&callfrom=SCH"+"&batch_id="+batch_id+"&expiry_date="+expiry_date+"&trade_id="+trade_id+"&trade_name="+trade_name+"&drug_code="+drug_code+"&patient_id="+patient_id+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&iv_Auto_Admin="+iv_Auto_Admin+"&order_id="+order_id+"&order_line_num="+order_line_num+"&Store_locn_code="+disp_locn_code+"&mar_iv_compl_dt_ind="+mar_iv_compl_dt_ind+"&admin_discontinue="+admin_discontinue+"&iv_admin_qty="+iv_admin_qty+"&iv_prep_yn="+iv_prep_yn,arguments,features);
			}
			else{
				iv_infusion_st_time=eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
				iv_infusion_st_time=convertDate(iv_infusion_st_time,'DMYHM',locale,"en")
				var returnvalues =new Array();
				returnvalues[0]=colvalue;
				returnvalues[1]="";
				returnvalues[2]=iv_infusion_st_time;
				returnvalues[3]="";
			}
			if(returnvalues != undefined ) {
				//var returnStatusString="";
				var returnStatus=returnvalues[0];
				var returnedAdminId =returnvalues[1];
				var returnedDate =returnvalues[2];
				var returnedRemarks =returnvalues[3];
				eval("formMain.sfrFLOW_STATUS"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=returnStatus;
				if(returnStatus=="ST" ){
					returnStatusString=getLabel("ePH.STARTED.label",'PH');
					eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=convertDate(returnedDate,"DMYHM","en",locale);
					await calcDatesForSFR(returnedDate,orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,returnStatus, 'SCH');
				}
				else if(returnStatus=="HO"){
					//returnStatusString=getLabel("ePH.HOLD.label",'PH');
					eval("formMain.sfrHOLD_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=returnedDate;
					await CalculateCompletedFlowOnHold(orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex, returnedDate , 'SCH');
					await changeDisplay(eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex),orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,flowRateDurationUnitDesc1, 'SCH');
					await getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex, 'SCH');
				}
				else if(returnStatus=="RE"){
					//returnStatusString=getLabel("ePH.RESUMED.label",'PH');
					returnedFlowRate=returnvalues[4];
					eval("formMain.sfrRESUME_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=returnedDate;
					var holdedMinutes=eval("formMain.sfrHOLD_DURN_IN_MINS"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
					if(returnedFlowRate != eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value)
						flow_rate_changed_YN = "Y";
					eng_st_time = convertDate(eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,"DMYHM",locale,"en");

					var already_administered_duration=minutesBetween(eng_st_time,eval("formMain.sfrHOLD_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,"DMYHM",locale);
					var holdedDuration=minutesBetween(eval("formMain.sfrHOLD_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,returnedDate,"DMYHM",locale);
					var durn_bw_std_resumed = parseInt(holdedDuration) +  parseInt(already_administered_duration)+parseInt(holdedMinutes);

					eval("formMain.sfrHOLD_DURN_IN_MINS"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=parseInt(holdedMinutes)+parseInt(holdedDuration);
					eval("formMain.durn_bw_std_resumed_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=durn_bw_std_resumed;
					eval("formMain.flow_rate_changed_YN"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value = flow_rate_changed_YN;
					eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=returnedFlowRate;
					await CalculateCompletedFlowOnChangeOfFlowRateSFR(orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,MFR_flow_rate,returnedDate,'SCH');
					await changeDisplay(eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex),orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,flowRateDurationUnitDesc1, 'SCH');
					await getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex , 'SCH');
					await calcDatesForSFR(convertDate(eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,"DMYHM",locale,"en"),orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,"RE", 'SCH');
				}
				else if(returnStatus=="CH")	{
					returnedFlowRate=returnvalues[4];
					eng_st_time = convertDate(eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,"DMYHM",locale,"en");
					eval("formMain.flow_rate_changed_YN"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value = "Y";
					eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=returnedFlowRate;
					await CalculateCompletedFlowOnChangeOfFlowRateSFR(orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,MFR_flow_rate,returnedDate,'SCH');
					await changeDisplay(eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex),orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,flowRateDurationUnitDesc1, 'SCH');
					await getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex , 'SCH');
					await calcDatesForSFR(convertDate(eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value,"DMYHM",locale,"en"),orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex,"RE", 'SCH');
				}
				else if(returnStatus=="CO")	{
					//returnStatusString=getLabel("ePH.COMPLETED.label",'PH');
					eval("formMain.sfrACT_END_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value=convertDate(returnedDate,"DMYHM","en",locale);
					batch_id=returnvalues[5];
					expiry_date =returnvalues[6];
					trade_id =returnvalues[7];
					trade_name =returnvalues[8];
				}
				var bean_id		= "" ;
				var bean_name	= "" ;
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += "holdMinutes='"+eval("formMain.sfrHOLD_DURN_IN_MINS"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "holdDateTime='"+eval("formMain.sfrHOLD_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "infusion_date_time='"+eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "infusion_end_date='"+eval("formMain.sfrACT_END_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "resumeDateTime='"+eval("formMain.sfrRESUME_DATE_TIME"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "completed_durn_in_mins='"+eval("formMain.completedMinutes"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "completed_volume='"+eval("formMain.completedFlow"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "iv_infusion_period='"+eval("formMain.iv_infusion_period_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "iv_flow_rate='"+eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' " ;
				xmlStr += "iv_sch_admin_date_time='"+iv_sch_admin_date_time+"' " ;
				if(returnStatus=='CO' ){
					for(var dIndex=1; dIndex<=drugCount; dIndex++ ){
						xmlStr += "iv_drug_code_"+dIndex+"='"+eval("formMain.iv_drug_code_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_item_code_"+dIndex+"='"+eval("formMain.iv_item_code_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_order_id_"+dIndex+"='"+eval("formMain.iv_order_id_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_order_line_no_"+dIndex+"='"+eval("formMain.iv_order_line_no_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";

						xmlStr += "iv_dosage_seq_no_"+dIndex+"='"+eval("formMain.iv_dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_admin_qty_"+dIndex+"='"+eval("formMain.iv_admin_qty_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_infusion_st_time_"+dIndex+"='"+eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_flow_rate_"+dIndex+"='"+eval("formMain.iv_flow_rate_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' " ;
						xmlStr += "sch_infusion_vol_str_unit_"+dIndex+"='"+eval("formMain.sch_infusion_vol_str_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "sch_infusion_per_unit_"+dIndex+"='"+eval("formMain.sch_infusion_per_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_infusion_period_"+dIndex+"='"+eval("formMain.iv_infusion_period_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' " ;
						xmlStr += "sch_infusion_period_unit_"+dIndex+"='"+eval("formMain.sch_infusion_period_unit_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";

						//xmlStr += "iv_admin_date_time_1='"+eval("formMain.iv_admin_date_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' ";
						xmlStr += "iv_qty_uom_"+dIndex+"='"+eval("formMain.iv_qty_uom_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_bin_code_"+dIndex+"='"+eval("formMain.iv_bin_code_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "next_schd_date_"+dIndex+"='"+eval("formMain.next_schd_date_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "previous_batch_id_"+dIndex+"='"+eval("formMain.previous_batch_id_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "previous_exp_date_"+dIndex+"='"+eval("formMain.previous_exp_date_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "previous_trade_id_"+dIndex+"='"+eval("formMain.previous_trade_id_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "IV_Newly_administerderd_"+dIndex+"='"+eval("formMain.IV_Newly_administerderd_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_modified_date_time_"+dIndex+"='"+eval("formMain.iv_modified_date_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";
						xmlStr += "iv_link_vaccine_code_"+dIndex+"='"+eval("formMain.iv_link_vaccine_code_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+dIndex).value+"' ";

						xmlStr += "iv_batch_id_"+dIndex+"='"+batch_id+"' ";
						xmlStr += "iv_expiry_date_"+dIndex+"='"+expiry_date+"' ";
						xmlStr += "iv_trade_id_"+dIndex+"='"+trade_id+"' ";
						xmlStr += "iv_chk_complete_"+dIndex+"='"+"E"+"' ";
						xmlStr += "iv_trade_name_"+dIndex+"='"+trade_name+"' ";
						xmlStr += "iv_store_code_"+dIndex+"='"+eval("formMain.iv_store_code_"+orderCount).value+"' ";
						xmlStr += "iv_admin_date_time_"+dIndex+"='"+iv_sch_admin_date_time+"' ";
						xmlStr += "iv_Auto_Admin_"+dIndex+"='"+eval("formMain.iv_Auto_Admin_"+orderCount).value+"' ";
						xmlStr += "iv_order_pract_id_"+dIndex+"='"+eval("formMain.iv_order_pract_id_"+orderCount).value+"' ";
						xmlStr += "could_not_administer_"+dIndex+"='"+"N"+"' ";
						xmlStr += "chk_iv_select_"+dIndex+"='"+"Y"+"' ";
					}
					xmlStr += "non_iv_records='"+"0"+"' ";
					xmlStr += "alt_non_iv_records='"+"0"+"' ";
					xmlStr += "iv_records='"+drugCount+"' ";
					xmlStr += "patient_id='"+patient_id+"' ";
					xmlStr += "encounter_id='"+encounter_id+"' ";
					xmlStr += "assign_bed_num='"+assign_bed_num+"' ";
					xmlStr += "nursing_unit='"+nursing_unit+"' ";
					xmlStr += "disp_locn_code='"+disp_locn_code+"' ";
					xmlStr += "callFrom='"+"SCH"+"' ";
					xmlStr += "flow_status='"+returnStatus+"' ";
					xmlStr += "iv_prep_yn='"+iv_prep_yn+"' ";
					xmlStr += "mar_iv_compl_dt_ind='"+mar_iv_compl_dt_ind+"' ";
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "../../ePH/jsp/MedicationAdministrationValidation.jsp?bean_id=&bean_name=&func_mode=insertDetailsSCH&order_id="+order_id+"&srl_no="+srl_no+"&sfr_status="+returnStatus+"&actionBy="+returnedAdminId+"&actionTime="+returnedDate+"&actionRemarks="+returnedRemarks+"&callFrom=SCH", false ) ;
					xmlHttp.send( xmlDoc ) ;
					eval(xmlHttp.responseText);
				}
				else{
					if(returnStatus=='ST' || returnStatus=='AD'){
						xmlStr += "next_schd_date='"+eval("formMain.next_schd_date_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value+"' ";
						xmlStr += "iv_drug_code='"+eval("formMain.iv_drug_code_"+orderCount).value+"' ";
						xmlStr += "iv_prep_yn='"+iv_prep_yn+"' ";
						xmlStr += "encounter_id='"+encounter_id+"' ";
					}
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=updateSFR&order_id="+order_id+"&srl_no="+srl_no+"&sfr_status="+returnStatus+"&actionBy="+returnedAdminId+"&actionTime="+returnedDate+"&actionRemarks="+returnedRemarks+"&callFrom=SCH", false ) ;
					xmlHttp.send( xmlDoc ) ;
					eval(xmlHttp.responseText);
					if(recInserted==true || recInserted=='true'){
						await adminIVSCH(colvalue, callFrom, orderCount, schCount, schDayCount, recCount,scheKey )
					}
				}
				//if(returnStatus!='AD')
				parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
			}
		}
	}
}

async function adminIVSCH(colvalue, callFrom, orderCount, schCount, schDayCount, recCount,scheKey ){
	hidemenuSch();
	var formMain=document.MedicationAdministrationSchLevelDrugDtls;
	var patientId = formMain.patient_id.value;
	var encounter_id = formMain.encounter_id.value;
	var nursing_unit = formMain.nursing_unit.value;
	var assign_bed_num = formMain.assign_bed_num.value;
	var facility_id = formMain.facility_id.value;
	var userAuthPINYN = formMain.userAuthPINYN.value;

	var hold_discontinue_yn=formMain.hold_discontinue_yn.value;
	var admin_from_date=formMain.adminFromDateTime.value;
	var admin_to_date=formMain.adminToTime.value;
	var order_id=eval("formMain.iv_order_id_"+orderCount).value;
	var order_line_num=eval("formMain.iv_order_line_no_"+orderCount).value;
	var iv_prep_yn = eval("formMain.iv_prep_yn"+orderCount).value;
	var ord_drug_code = "";//eval("formMain.iv_drug_code_"+orderCount).value;
	var encode_drug_desc = encodeURIComponent(eval("formMain.iv_drug_desc_"+orderCount).value,"UTF-8");

	var drug_class = eval("formMain.iv_drug_class"+orderCount).value;
	var dosage_seq_no = eval("formMain.iv_dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
	//var sch_date_time = eval("formMain.iv_infusion_st_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
	var sch_date_time = eval("formMain.iv_admin_date_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_"+drugIndex).value;
	dialogTop		= "100";
	dialogHeight	= "60vh";
	dialogWidth		= "80vw";
	status			= "no";
	arguments		= "" ;
	features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
	var action_url		=	'../../ePH/jsp/MARSchLevelDrugAdmin.jsp?&patient_id='+patientId+'&function_from=SCH&p_start_date_time='+sch_date_time+'&p_ord_drug_code='+ord_drug_code+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+dosage_seq_no+'&order_id='+order_id+"&order_line_num="+order_line_num+"&nursing_unit="+nursing_unit+"&iv_prep_yn="+iv_prep_yn+"&schCount="+schCount+"&schDayCount="+schDayCount+"&recCount="+recCount+"&adminOption="+colvalue+"&userAuthPINYN="+userAuthPINYN+"&callFrom=adminIV"+"&hold_discontinue_yn="+hold_discontinue_yn+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date;
	var retVal=await window.showModalDialog(action_url,arguments,features);
	if(retVal=='OK'){
		parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
	}
}

function loadAdminDetails(orderCount, schCount, schDayCount, recCount, scheKey){
	//var patientId = document.MedicationAdministrationSchLevelDrugDtls.patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var patient_class =document.forms[0].patient_class.value;
	var facility_id = document.forms[0].facility_id.value;
	var order_id = eval("document.forms[0].non_iv_order_id_"+orderCount).value;
	var order_line_num = eval("document.forms[0].non_iv_order_line_no_"+orderCount).value;
	var iv_prep_yn = eval("document.forms[0].iv_prep_yn"+orderCount).value;
	var ord_drug_code = eval("document.forms[0].non_iv_drug_code_"+orderCount).value;
	var drug_desc = encodeURIComponent(eval("document.forms[0].non_iv_drug_desc_"+orderCount).value,"UTF-8");
	if(iv_prep_yn == '1' || iv_prep_yn =='2'|| iv_prep_yn =='3' || iv_prep_yn =='4'|| iv_prep_yn =='5' ){
		var MfrYN = eval("document.forms[0].MfrYN"+orderCount).value;
		if( MfrYN!='Y'){
			var sch_dosage_uom_code = eval("document.forms[0].dosage_uom_code_"+orderCount+"_"+schCount+"_"+schDayCount+"_1").value;
			var sch_date = eval("document.forms[0].sch_date_"+orderCount+"_"+schCount+"_"+schDayCount+"_1").value;
			var dosage = eval("document.forms[0].dosage_"+orderCount+"_"+schCount+"_"+schDayCount+"_1").value;
			var admintime = eval("document.forms[0].sch_time_"+orderCount+"_"+schCount+"_"+schDayCount+"_1").value;
			var dosage_seq_no = eval("document.forms[0].dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount+"_1").value;
		}
		else{
			var sch_dosage_uom_code = eval("document.forms[0].dosage_uom_code_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var sch_date = eval("document.forms[0].sch_date_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var dosage = eval("document.forms[0].dosage_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var admintime = eval("document.forms[0].sch_time_"+orderCount+"_"+schCount+"_"+schDayCount).value;
			var dosage_seq_no = eval("document.forms[0].dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		}
	}
	else{
		var sch_dosage_uom_code = eval("document.forms[0].dosage_uom_code_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		var sch_date = eval("document.forms[0].sch_date_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		var dosage = eval("document.forms[0].dosage_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		var admintime = eval("document.forms[0].sch_time_"+orderCount+"_"+schCount+"_"+schDayCount).value;
		var dosage_seq_no = eval("document.forms[0].dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount).value;
	}
	parent.MedicationAdministrationFixedTimeFrameSet.rows="14%,*,23%,15%";
	var patient_class=	document.MedicationAdministrationSchLevelDrugDtls.patient_class.value;
	var localeName = document.MedicationAdministrationSchLevelDrugDtls.locale.value;
	//sch_date = convertDate(sch_date,"DMY",localeName,"en");
   	parent.f_admin_new_entry.location.href="../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp?order_id="+order_id+"&encounter_id="+encounter_id+"&schdatetime="+sch_date+"&ord_drug_code="+ord_drug_code+"&drug_desc="+drug_desc+"&facility_id="+facility_id+"&adminyn=Y&patient_class="+patient_class+"&admintime="+admintime+"&te_qty="+dosage+"&iv_prep_yn="+iv_prep_yn+"&sch_dosage_uom_code="+sch_dosage_uom_code+"&order_line_num="+order_line_num+"&callFrom=SCH"+"&dosage_seq_no="+dosage_seq_no;
}

/*function closeAdminDtl(callFrom){
	alert('ADMIN callFrom='+callFrom);
	if(callFrom=='SCH') // Added for PMG2014-CRF-0026 [IN:052701]
		parent.MedicationAdministrationFixedTimeFrameSet.rows="14%,*,0%,11%";
}*/

function addPRNDose(orderCount, schCount, schDayCount, recCount, scheKey, calledFrom){
	var formObj = document.MedicationAdministrationSchLevelDrugDtls;
	var criteriaFormObj = parent.parent.f_search.document.MedicationAdministrationSearchForm;
	var sch_date = document.getElementById("sch_date_"+orderCount+"_"+schCount+"_"+schDayCount).value;
	var localeName = document.MedicationAdministrationSchLevelDrugDtls.locale.value;
	var drug_code = eval("formObj.non_iv_drug_code_"+orderCount).value;
	var encounter_id = formObj.encounter_id.value;
	var administration_status = formObj.administration_status.value;
	var adminFromDateTime = formObj.adminFromDateTime.value;
	var adminToTime = formObj.adminToTime.value;
	var from_time = formObj.from_time.value;
	var to_time = formObj.to_time.value;

	var order_id = eval("formObj.non_iv_order_id_"+orderCount).value;
	var order_line_num = eval("formObj.non_iv_order_line_no_"+orderCount).value;
	var dosage_seq_no = document.getElementById("dosage_seq_no_"+orderCount+"_"+schCount+"_"+schDayCount).value;
	var hold_discontinue_yn = criteriaFormObj.hold_discontinue_yn.value;
	var order_type = criteriaFormObj.order_type.value;
	var display_order_by = criteriaFormObj.display_order_by.value;
	var route_admin = criteriaFormObj.route_of_admin.value;
	var admin_route_categ = criteriaFormObj.admin_route_category.value;
	//sch_date = convertDate(sch_date,"DMY",localeName,"en"); //Commented for SKR-SCF-0997 [IN:048677]

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "sch_date='"+sch_date+"' " ;
	xmlStr += "order_id='"+order_id+"' " ;
	xmlStr += "order_line_no='"+order_line_num+"' " ;
	xmlStr += "dosage_seq_no='"+dosage_seq_no+"' " ;
	xmlStr += "encounter_id='"+encounter_id+"' " ;
	xmlStr += "drug_code='"+drug_code+"' " ;
	xmlStr += "hold_discontinue_yn='"+hold_discontinue_yn+"' " ;
	xmlStr += "administration_status='"+administration_status+"' " ;
	xmlStr += "order_type='"+order_type+"' " ;
	xmlStr += "adminFromDateTime='"+adminFromDateTime+"' " ;
	xmlStr += "adminToTime='"+adminToTime+"' " ;
	xmlStr += "display_order_by='"+display_order_by+"' " ;
	xmlStr += "route_admin='"+route_admin+"' " ;
	xmlStr += "admin_route_categ='"+admin_route_categ+"' " ;
	xmlStr += "from_time='"+from_time+"' " ;
	xmlStr += "to_time='"+to_time+"' " ;
	xmlStr += "callFrom='"+calledFrom+"' ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../ePH/jsp/MedicationAdministrationValidation.jsp?func_mode=addPRNDose", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	if(calledFrom!='Admin')
		parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
}

async function recordHoldDiscontinue(patient_id, order_id,  order_line_no,  colvalue, sch_date_time){
	var dialogHeight	= "50vh" ;
	var dialogWidth		= "30vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal = await window.showModalDialog("../../ePH/jsp/MARSchLevelHoldDiscontinue.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&callFor="+colvalue+"&sch_date_time="+sch_date_time,arguments,features);
	return retVal;
}

function getRemarks(reasonObj){
	document.MARSchLevelHoldReason.remarks.value = decodeURIComponent(reasonObj.options[reasonObj.selectedIndex].innerText,"UTF-8");
}

function checkRemarksMaxLimit(obj,maxLeng, label) {
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	}
	else
		return true;
}

function recordHoldDiscont(){
	var formObj = document.MARSchLevelHoldReason;
	var reason_code = formObj.reason.value;
	var remarks = encodeURIComponent( formObj.remarks.value,"UTF-8");
	var patient_id = formObj.patient_id.value;
	var callFor = formObj.callFor.value;
	var order_id = formObj.order_id.value;
	var order_line_no = formObj.order_line_no.value;
	var sch_date_time = formObj.sch_date_time.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "reason_code=\""+ reason_code +"\" " ;
	xmlStr += "remarks=\""+ remarks +"\" " ;
	xmlStr += "patient_id=\""+ patient_id +"\" " ;
	xmlStr += "callFor=\""+ callFor +"\" " ;
	xmlStr += "order_id=\""+ order_id +"\" " ;
	xmlStr += "order_line_no=\""+ order_line_no +"\" " ;
	xmlStr += "sch_date_time=\""+ sch_date_time +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=recordHoldDiscont", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	window.close();
}

function changeAdminbyType(selfAdminByTypeObj){
	document.MedicationAdministrationFTDrugDetails.adminByType.value=selfAdminByTypeObj.value;
	document.MedicationAdministrationFTDrugDetails.selfAdminBy.value="";
	if(selfAdminByTypeObj.value == 'R'){
		document.MedicationAdministrationFTDrugDetails.selfAdminBy.style.display='inline';
		document.getElementById('selfAdminByMand').style.display='inline';
		document.getElementById('selfAdminNamelbl').style.display='inline';
	}
	else{
		document.MedicationAdministrationFTDrugDetails.selfAdminBy.style.display='none';
		document.getElementById('selfAdminByMand').style.display='none';
		document.getElementById('selfAdminNamelbl').style.display='none';
		document.MedicationAdministrationFTDrugDetails.selfAdminBy.value="Patient";
	}
}

function callSchrecord(obj,adminOption, callFrom,recCount,iv_prep_yn,order_id,order_line_num,item_code,isSiteSpecMARPrint,patient_id,patient_class_ord,batch_id_size,patient_stock_yn,encounter_id,patient_brgt_medn){ // recCount,iv_prep_yn added for AAKH-CRF-0084 [IN060429] and order_id,order_line_num,item_code,isSiteSpecMARPrint,patient_id added for GHL-CRF-0458 and batch_id_size,patient_stock_yn added for GHL-CRF-0482
//patient_class_ord added for ICN66152

	var adminType = document.MedicationAdministrationFTDrugDetails.adminByType.value;
	var selfAdminType = document.MedicationAdministrationFTDrugDetails.selfAdminByType.value;
	var selfAdminBy = document.MedicationAdministrationFTDrugDetails.selfAdminBy.value;
	var admin_discontinue = document.MedicationAdministrationFTDrugDetails.admin_discontinue.value;
	var verify_adm_drug = document.MedicationAdministrationFTDrugDetails.verify_adm_drug.value; // added for AAKH-CRF-0084 [IN060429]

	if(isSiteSpecMARPrint && iv_prep_yn=="" ){//GHL-CRF-0458 //&& patient_class_ord=="IP" condition removed for alpha raised IN68336 GHL-CRF-0482
		 validateQtyAck(obj,recCount,order_id,order_line_num,item_code,isSiteSpecMARPrint,patient_id,iv_prep_yn,patient_class_ord,batch_id_size,patient_stock_yn,encounter_id,patient_brgt_medn);//batch_id_size,patient_stock_yn added for GHL-CRF-0482
		//patient_class_ord added for ICN66152

//		 var allow_admin_yn = document.MedicationAdministrationFTDrugDetails.allowed_yn.value;
		var allow_admin_yn = eval("document.MedicationAdministrationFTDrugDetails.allowed_yn_"+recCount).value;//recCount added for IN066062
		 if(allow_admin_yn=="N")
			 return false;

	} //GHL-CRF-0458 - end
	if(adminOption=='SAD' || adminType!='U'){
		if(adminType == 'R' && selfAdminBy==''){
			msg = getMessage("CAN_NOT_BE_BLANK",'Common');
			msg = msg.replace("$",getLabel("ePH.patientsRelative.label",'PH')+" "+getLabel("Common.name.label",'Common'));
			alert(msg);
			return false;
		}
	}

	if(verify_adm_drug=="true" && iv_prep_yn!="7" && iv_prep_yn!="8" ){ // Added for AAKH-CRF-0084 [IN060429] - Start and iv_prep_yn!="8" && iv_prep_yn!="0" && iv_prep_yn!="9" added for MMS-KH-CRF-0017 and && iv_prep_yn!="0" && iv_prep_yn!="9" removed for MMS-KH-CRF-0017.1
		if(iv_prep_yn=="" ){//MMS-KH-CRF-0017 and modified
		if(document.getElementById("pat_brought_med_"+recCount).checked || document.getElementById("non_iv_shared_drug_"+recCount).checked){
			if(document.getElementById("non_iv_batch_id_"+recCount).value==''||(document.getElementById("non_iv_expiry_date_"+recCount).value=='')){
				msg = getMessage("CAN_NOT_BE_BLANK",'Common');
				msg = msg.replace("$",getLabel("Common.BatchID.label",'Common')+"/"+getLabel("Common.expiryDate.label",'Common'));
				alert(msg);
				return false;
			}
		}
		}
		if(iv_prep_yn=="9") //MMS-KH-CRF-0017.1
			recCount = 1;
		//if condition added for MMS-DM-SCF-0447
		//document.getElementById("pat_brought_med_"+recCount)!=undefined added for MMS-KH-CRF-0017
		if(document.getElementById("pat_brought_med_"+recCount)!=undefined && document.getElementById("pat_brought_med_"+recCount).checked ==false && document.getElementById("non_iv_scanned_batch_yn_"+recCount)!=undefined && document.getElementById("non_iv_scanned_batch_yn_"+recCount).value !="Y"){

			alert(getMessage("MANDATORY_ADMIN_DETAILS","PH"));
		return false;
		}
	} // Added for AAKH-CRF-0084 [IN060429] - End
	if(adminOption=='AD' && callFrom=='adminIV'){
		var formObj = document.MedicationAdministrationFTDrugDetails;
		var order_id = formObj.order_id.value;
		var srl_no = formObj.iv_dosage_seq_no.value;
		var iv_admin_by = formObj.iv_admin_by.value;
		var iv_admin_date_time = formObj.iv_admin_date_time_audit.value;
		var iv_admin_remarks = formObj.iv_admin_remarks.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += "iv_sch_admin_date_time='"+iv_admin_date_time+"' " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../ePH/jsp/MedicationAdministrationValidation.jsp?bean_id=&bean_name=&func_mode=insertDetailsSCH&order_id="+order_id+"&srl_no="+srl_no+"&sfr_status="+adminOption+"&actionBy="+iv_admin_by+"&actionTime="+iv_admin_date_time+"&actionRemarks="+iv_admin_remarks+"&callFrom=SCH", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	callrecord();
}

function enableData(locale,current_date_time,sch_date,administered,admin_recorded_by,recCount,admin_from_date,admin_to_date, iv_prep_yn, order_line_num){ // , iv_prep_yn, order_line_num added for [IN:043702]
	var medn_admn_dtl_reqd = document.getElementById("medn_admn_dtl_reqd"+recCount+"").value;	//Added for  [IN:043193]
	if("Y"==admin_recorded_by && "N"==administered ){
		if(validateCanAdminister(admin_from_date,admin_to_date,current_date_time,locale,sch_date)){
			//document.getElementById("medAdmInd"+recCount+"").style.backgroundColor = 'white';
			document.getElementById("medAdmInd"+recCount+"").style.cursor="default";
			if(document.getElementById("drug_mast_det_"+recCount).style.display == 'inline')
				return;
			var bat_id_lookbutton_enabled = document.getElementById("bat_id_lookbutton_enabled"+recCount).value
			document.getElementById("drug_mast_det_"+recCount).style.display = 'inline';
			document.getElementById("drugDesc"+recCount).className = 'changeTextColor';
			document.getElementById("non_iv_admin_qty1_"+recCount).style.display = 'inline';
			document.getElementById("dosageDescription"+recCount).style.display = 'inline';
			document.getElementById("dosageDescriptionOld"+recCount).style.visibility = 'hidden';
			document.getElementById("non_iv_admin_qty1_old"+recCount).style.visibility = 'hidden';
			document.getElementById("sch_date_time"+recCount).className = 'datetimeFont';
			document.getElementById("recordeddatetime"+recCount).className = 'datetimeFont';
			document.getElementById("recordeddatetime"+recCount).style.display = 'none';
			document.getElementById("non_iv_time_"+recCount).style.display = 'inline';
			document.getElementById("non_iv_batch_id_"+recCount).style.display = 'inline';
			document.getElementById("non_iv_expiry_date_"+recCount).style.display = 'inline';
			if(iv_prep_yn=='0' || iv_prep_yn=='6' || iv_prep_yn=='8' || document.getElementById("non_iv_batch_id_"+recCount).value!=""){
				bat_id_lookbutton_enabled = 'NOT';
				document.getElementById("pat_brought_med_"+recCount).disabled = true;
				document.getElementById("non_iv_batch_id_"+recCount).disabled = true;
				document.getElementById("non_iv_batch_id_but_"+recCount).style.display = 'none';
			}
			else{
				document.getElementById("pat_brought_med_"+recCount).disabled = false;
				document.getElementById("non_iv_batch_id_but_"+recCount).style.display = 'inline';
				document.getElementById("non_iv_batch_id_but_"+recCount).disabled = false;
				if(document.getElementById("pat_brought_med_"+recCount).checked == true  || document.getElementById("non_iv_Auto_Admin_"+recCount).value=='N'){
					document.getElementById("non_iv_batch_id_but_"+recCount).disabled = true;
					document.getElementById("non_iv_batch_id_"+recCount).disabled = true;
				}
			}
			document.getElementById("adminDtls"+recCount).style.visibility = 'hidden';
			document.getElementById("non_iv_chk_"+recCount).style.display = 'inline';
			document.getElementById("non_iv_remarks_"+recCount).style.display = 'inline';
			if("Y" == medn_admn_dtl_reqd ){	//Added for  [IN:043193]
				document.getElementById("medn_admn_dtl_reqd"+recCount).value = 'Y';
				document.getElementById("drug_remarks_mand_id_"+recCount).style.display = 'inline';
			}
			else{
				document.getElementById("medn_admn_dtl_reqd"+recCount).value = 'N';
				document.getElementById("drug_remarks_mand_id_"+recCount).style.display = 'none';
			}
			document.getElementById("chk_non_iv_select_"+recCount).style.display = 'inline';
			document.getElementById("disp_batch_id"+recCount).style.visibility = 'hidden';
			document.getElementById("lbl_expiry_date"+recCount).style.visibility = 'hidden';
			document.getElementById("lbl_trade_name"+recCount).style.visibility = 'hidden';
			document.getElementById("non_iv_chk_"+recCount).disabled=true;
			enableDisableTextbox(recCount,medn_admn_dtl_reqd,bat_id_lookbutton_enabled,iv_prep_yn,order_line_num); //Added for [IN:043702]
		}
	}
}

function validateCanAdminister (fromDate,toDate,currDate,locale,sch_date_time){
	if(currDate!=""){
		if(!validDate(currDate, "DMYHM",locale)){
			alert(getMessage("INVALID_DATE_TIME",'PH'));
			return false;
		}
		if(!isBetween(fromDate, toDate, currDate, 'DMYHM', locale)){
			var timeMsg=getMessage("PH_ADMIN_DATE_TIME_BETWEEN_CURR_DATE_TIME",'PH');
			timeMsg=timeMsg.replace('$',fromDate);
			timeMsg=timeMsg.replace('#',toDate);
			alert(timeMsg);
			currDate = toDate;
			return false;
		}
		else{
			return true;
		}
	}
}

function enableIVAdmin(recCount,admin_recorded_by,administered,iv_no_of_drug_per_order){
	var loopCount = 1;
	var sch_date_time = document.getElementById("iv_admin_date_time_"+recCount+"").value;
	var admin_from_date = document.getElementById("admin_from_date").value;
	var admin_to_date = document.getElementById("admin_to_date").value;
	var locale = document.getElementById("locale").value;
	if(!isBetween(admin_from_date, admin_to_date, sch_date_time, 'DMYHM', locale)){
		var timeMsg=getMessage("PH_ADMIN_DATE_TIME_BETWEEN_CURR_DATE_TIME",'PH');
		timeMsg=timeMsg.replace('$',fromDate);
		timeMsg=timeMsg.replace('#',toDate);
		alert(timeMsg);

		return false;
	}
	if("Y"==admin_recorded_by && "N"==administered ){
		for(var i=recCount;loopCount<=iv_no_of_drug_per_order;){

			//document.getElementById("medAdminIV"+i).style.backgroundColor = 'white';
			document.getElementById("drug_mast_det_old"+i).style.display = 'none';
			document.getElementById("drug_mast_det_1"+i).style.display = 'inline';
			document.getElementById("drug_desc"+i).style.display = 'inline';
			document.getElementById("drug_desc"+i).className = 'changeTextColor';
			document.getElementById("qty_old"+i).style.display = 'none';
			document.getElementById("qty_uom_old"+i).style.display = 'none';
			document.getElementById("iv_admin_qty_"+i).style.display = 'inline';
			document.getElementById("qty_uom"+i).style.display = 'inline';
			document.getElementById("iv_infusion_st_time_"+i).style.display = 'inline';
			document.getElementById("admin_date_time_old"+i).style.display = 'none';
			document.getElementById("iv_flow_rate_old"+i).style.visibility = 'hidden';
			document.getElementById("iv_flow_rate_desc_old"+i).style.visibility = 'hidden';
			document.getElementById("iv_flow_rate_"+i).style.display = 'inline';
			document.getElementById("iv_flow_rate_desc"+i).style.display = 'inline';
			document.getElementById("iv_infusion_period_txt_old"+i).style.visibility = 'hidden';
			document.getElementById("sch_inf_per_old"+i).style.visibility = 'hidden';
			document.getElementById("iv_infusion_period_txt"+i).style.display = 'inline';
			document.getElementById("sch_inf_per_desc"+i).style.display = 'inline';
			document.getElementById("iv_batch_id_but_"+i).style.display = 'inline';
			document.getElementById("iv_batch_id_"+i).style.display = 'inline';
			document.getElementById("iv_batch_id_old"+i).style.visibility = 'hidden';
			document.getElementById("iv_expiry_date_old"+i).style.visibility = 'hidden';
			document.getElementById("iv_expiry_date_"+i).style.display = 'inline';

			if(i==recCount){
				document.getElementById("orderctllink"+i).style.display = 'inline';
				document.getElementById("iv_chk_complete_"+i).style.display = 'inline';
				document.getElementById("iv_lbl_dtls_"+i).style.display = 'inline';
				document.getElementById("iv_lb_dtls_old"+i).style.visibility = 'hidden';
				document.getElementById("iv_remarks_mand_id_"+i).style.display = 'inline';
				document.getElementById("iv_chk_complete_"+i).disabled = true;
			}
			document.getElementById("chk_iv_select_"+i).style.display = 'inline';
			document.getElementById("chk_iv_select_old"+i).style.visibility = 'hidden';
			loopCount++;
			i++;
		}
	}
}
function taperCurrRow(index,inc, encounter_id){  //Added for RUT-CRF-0088 [IN036978]  -- begin
	var proceed_yn =confirm(getMessage("PH_DISPENSE_DATA_MODIFIED", "PH"));
	if(!proceed_yn){
		return false;
	}
	var bean_id           = document.getElementById('bean_id').value;
	var bean_name         = document.getElementById('bean_name').value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "index=\""+ index +"\" " ;
	xmlStr += "inc=\""+ inc +"\" " ;
	xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=taperCurrRow", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function reloadTaper(val){

	var formObj= parent.parent.frames[1].document.MedicationAdministrationSearchForm;
	var dtlFormObj= parent.parent.f_query_add_mod.f_admin_chart.document.MedicationAdministrationFTDrugDetails;
	var disa            = formObj.disa.value;
	if(disa!='Y'){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	var nursing_unit	= formObj.nursing_unit.value;
	var admin_from_date	= formObj.admin_from_date.value;
	var admin_to_date	= formObj.admin_to_date.value;
	var order_type		= formObj.order_type.value;
	var to_time			= formObj.to_time.value;
	var from_time		= formObj.from_time.value;
	var called_from		= formObj.called_from.value;
	var from_bed_no		= formObj.from_bed_no.value;
	var to_bed_no		= formObj.to_bed_no.value;
	var display_order_by = formObj.display_order_by.value;
	var patient_class    = formObj.patient_class1.value
	var administration_status	= formObj.administration_status.value;
	var admin_route_categ    = formObj.admin_route_category.value;
	var route_admin    = formObj.route_of_admin.value;
	var call_from_ca   = formObj.call_from_ca.value;
	var option_id   = formObj.option_id.value;
	var allergic_yn="";
	var assign_bed_num="";
	var hold_discontinue_yn=formObj.hold_discontinue_yn.value;
	var selected_row=parseInt(val)+1
	var patient_id      = dtlFormObj.patient_id_selected.value;
	var bed_num      = dtlFormObj.assign_bed_num.value;
	var encounter_id    = dtlFormObj.encounter_id.value;
	
	parent.frames[0].frames[1].document.getElementById('pat_links').style.display="inline";
	if(allergic_yn=='Y')//getting allergy existence detail - SKR-CRF-010
		parent.frames[0].frames[1].document.getElementById('lblkwncaseAlgy').style.display="inline";
	else
		parent.frames[0].frames[1].document.getElementById('lblkwncaseAlgy').style.display="none";
	
	parent.frames[1].location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&admin_from_date="+admin_from_date+"&encounter_id="+encounter_id+"&from_time="+from_time+"&to_time="+to_time+"&assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&administration_status="+administration_status+"&admin_to_date="+admin_to_date+"&order_type="+order_type+"&patient_id="+patient_id+"&function_from="+called_from+"&display_order_by="+display_order_by+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ+"&callFrom=RELOADTAPER";

	parent.f_admin_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp?alternate_drug=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&nursing_unit="+nursing_unit+"&admin_to_date="+admin_to_date;
}  //Added for RUT-CRF-0088 [IN036978] -- end

async function callAlternateDrugWindow(drug_code,drug_desc,patient_id,order_id,order_line_num,store_code,qty,expiry_date,uom_code,recCount,freq_nature,old_MAR_yn){//Added for Bru-HIMS-CRF-399 [IN:043767] freq_nature,old_MAR_yn added for BRU-CRF-399.1
	var formObj= document.MedicationAdministrationFTDrugDetails;
	var mar_alt_drug_code = eval("formObj.non_iv_dispense_drug_code_"+recCount).value;
	if(eval("formObj.non_iv_dispense_drug_code_"+recCount).value == drug_code)//if Added for [IN:053183]
		mar_alt_drug_code = "";
	var dialogHeight= "500px" ;//20
	var dialogWidth	= "800px" ;//62
	var dialogTop = "10px" ;//150
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	if(uom_code == undefined){
		uom_code = "";
	}
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationAltDrugsFrames.jsp?drug_code="+drug_code+"&drug_desc="+ drug_desc+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_num+"&source=MAR&store_code="+store_code+"&qty_reqd="+qty+"&eff_expiry="+expiry_date+"&main_strength_uom="+uom_code+"&alt_drug_remarks_ind=N&mar_alt_drug_code="+mar_alt_drug_code,arguments,features);
	if(retVal != undefined && retVal != ''){
		eval("formObj.non_iv_batch_id_"+recCount).value = "";
		eval("formObj.non_iv_expiry_date_"+recCount).value = "";
		eval("formObj.non_iv_trade_id_"+recCount).value = "";
		eval("formObj.non_iv_bin_code_"+recCount).value = "";

		if(eval("formObj.chk_non_iv_select_"+recCount))//added for BRU-CRF-399.1
		eval("formObj.chk_non_iv_select_"+recCount).disabled = false;

		alt_drug = retVal.split("~")
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ alt_drug[0] +"\" " ;
		xmlStr += "store_code=\""+ store_code +"\" " ;
		xmlStr += "formObj=\""+ formObj +"\" " ;
//added for BRU-CRF-399.1 - start
		xmlStr += "recCount=\""+ recCount +"\" " ;
		xmlStr += "order_id=\""+ order_id +"\" " ;
		xmlStr += "order_line_num=\""+ order_line_num +"\" " ;
		xmlStr += "alt_drug_code=\""+ alt_drug[0] +"\" " ;
		xmlStr += "pres_drug_code=\""+ drug_code +"\" " ;
		xmlStr += "freq_nature=\""+ freq_nature +"\" " ;
		xmlStr += "old_MAR_yn=\""+ old_MAR_yn +"\" " ;
		xmlStr += "qty=\""+ qty +"\" " ;

		//added for BRU-CRF-399.1 - end

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?func_mode=selectBatch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(eval("formObj.non_iv_batch_id_"+recCount).value !=""){
			eval("formObj.non_iv_dispense_drug_code_"+recCount).value = alt_drug[0];
			eval("formObj.dispensed_drug_desc_"+recCount).value = decodeURIComponent(alt_drug[1],"UTF-8");
			//formObj.document.getElementById('id_dispdrugdesc_')+recCount.innerHTML = decodeURIComponent(alt_drug[1],"UTF-8");
			(document.getElementById('id_dispdrugdesc_' + recCount).innerHTML || {}).innerHTML = decodeURIComponent(alt_drug[1], "UTF-8");

		}
		else{
			alert(getMessage("PH_NO_STOCK_AVAIL_DRUG", "PH") +" / " +getMessage("PH_ITEM_UOM_DEF_NOT_FOUND", "PH"));
		}
	}
	else if(retVal == undefined){
		eval("formObj.non_iv_dispense_drug_code_"+recCount).value = drug_code;
		eval("formObj.dispensed_drug_desc_"+recCount).value = drug_desc;
		//formObj.document.getElementById('id_dispdrugdesc_')+recCount.innerHTML = '';
		document.getElementById('id_dispdrugdesc_' + recCount).innerHTML = '';
		eval("formObj.non_iv_batch_id_"+recCount).value = '';
		eval("formObj.non_iv_expiry_date_"+recCount).value = '';
		eval("formObj.non_iv_trade_id_"+recCount).value = '';
		eval("formObj.non_iv_bin_code_"+recCount).value = '';
	}
}

function assignBatch(batch_id,expiry_date,trade_id,bin_code,recCount,old_MAR_yn){ //Added for Bru-HIMS-CRF-399 [IN:043767]
	var formObj= document.MedicationAdministrationFTDrugDetails;
	eval("formObj.non_iv_batch_id_"+recCount).value = batch_id;
	eval("formObj.non_iv_expiry_date_"+recCount).value = expiry_date;
	eval("formObj.non_iv_trade_id_"+recCount).value = trade_id;
	eval("formObj.non_iv_bin_code_"+recCount).value = bin_code;
}
async function printReports(callFrom) { // Added for GHL-CRF-0458   - Start
	var formObj = document.MedicationAdministrationSearchForm;
    clearBean();
    if(callFrom==undefined){
    	callFrom ="";
    }
	if(callFrom=='MARSCH'){
    var nursing_unit	= formObj.nursing_unit.value;
    var admin_from_date	= formObj.fromDate.value;
	var admin_to_date	= formObj.to_date.value;
	var order_type		= formObj.order_type.value;
	var display_order_by = formObj.display_order_by.value;
	var patient_class    = formObj.patient_class.value;
	var admin_route_categ    = formObj.admin_route_category.value;
 	var route_admin    = formObj.route_of_admin.value;
	var facility_id = formObj.facility_id.value;
	var patient_id   = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var locale = formObj.locale.value;
	var user_name = formObj.user_name.value;
	var display_order_by = formObj.display_order_by.value;
    var report_id = "PHMEADRC";
    var hold_discontinue_yn="N";
    var bed_num = formObj.bed_num.value;
    var fm_bed_num = formObj.from_bed_no.value;
    var to_bed_num = formObj.to_bed_no.value;
    var administration_status	= "ALL";
	}
  else{
		var nursing_unit	= formObj.nursing_unit.value;
		var order_type		= formObj.order_type.value;
		var admin_to_date	= formObj.to_time.value;
		var admin_from_date	= formObj.from_time.value;
		var display_order_by = formObj.display_order_by.value;
		var patient_class    = formObj.patient_class.value
		if(patient_class==undefined || patient_class==""){
			patient_class    = formObj.patient_class1.value
		}
	       if(patient_class=="E")
			   patient_class    = "EM";
	       else if(patient_class=="A")
			   patient_class    = "OP";
		var administration_status	= formObj.administration_status.value;
		var admin_route_categ    = formObj.admin_route_category.value;
		var route_admin    = formObj.route_of_admin.value;
		var facility_id = formObj.facility_id.value;
		var encounter_id = formObj.encounter_id1.value;
		var patient_id   = formObj.patient_id1.value;
		var locale = formObj.locale.value;
		var user_name = formObj.user_name.value;
        var report_id = "PHMEADRC";
        var hold_discontinue_yn="N";
        var bed_num = formObj.bed_num.value;
        var fm_bed_num = formObj.from_bed_no.value;
        var to_bed_num = formObj.to_bed_no.value;

		if(nursing_unit!="" && admin_from_date!=""){
		  if(patient_id!=""){
			if(formObj.time_type[0].checked==true)
				time_type_val="M";
			if(formObj.time_type[1].checked==true)
				time_type_val="F";
			if(time_type_val=="F"){
				if(formObj.from_time.value!="" && formObj.to_time.value!=""){
					if(!isBetween(admin_from_date, admin_to_date, formObj.to_time.value, 'DMYHM', locale)){
						alert(getMessage("PH_TO_TIME_RANGE_ALERT",'PH'));
						return;
					}
					else if(!isBetween(admin_from_date, admin_to_date, formObj.from_time.value, 'DMYHM', locale)){
						if(formObj.administration_status.value!="ALL" && formObj.administration_status.value!="DOA"){
							alert(getMessage("PH_FROM_TIME_RANGE_ALERT",'PH'));
							return;
						}
					}
					var time_val=formObj.from_time.value;
					var hold_discontinue_yn="N";
					if(formObj.hold_discontinue_yn.checked==true){
						hold_discontinue_yn="Y";
					}
				}
				else{
					 var errormessage  = getMessage("PH_MANDATORY",'PH');
					 parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
					 enableSearchCriteria();
					 return;
				}
			}
			else{
				if(formObj.hold_discontinue_yn.checked==true){
					hold_discontinue_yn="Y";
				}
				else{
					hold_discontinue_yn="N";
				}
			}
		}
		  else{
				var errormessage  = getMessage("PH_MANDATORY",'PH');
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
				enableSearchCriteria();
				return;
			}
		}
		else{
			var errormessage  = getMessage("PH_MANDATORY",'PH');
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
			enableSearchCriteria();
			return;
		}
	}
    var url		= "../../eCommon/jsp/report_options_frameset.jsp?p_locn_code="+nursing_unit+"&p_admin_status="+administration_status+"&p_fm_date="+admin_from_date+"&p_to_date="+admin_to_date+"&p_admin_route_catg="+admin_route_categ+"&p_route_of_admin="+route_admin+"&p_include_type="+order_type+"&p_hold_disc_yn="+hold_discontinue_yn+"&p_patient_id="+patient_id+"&p_patient_class="+patient_class+"&p_module_id=PH&p_report_id="+report_id+"&p_facility_id="+facility_id+"&p_language_id="+locale+"&p_user_name="+user_name+"&p_bed_num="+bed_num+"&p_encounter_id="+encounter_id+"&p_fm_bed_num="+fm_bed_num+"&p_to_bed_num="+to_bed_num+"&p_disp_ord_type="+display_order_by+"&p_callFrom="+callFrom;
	var dialogHeight	= "11" ;
	var dialogWidth	= "25" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var reportURL 	= await window.showModalDialog( url, arguments, features ) ;
	if ( reportURL != null ) {

		reportURL		= "../../eCommon/jsp/report_process.jsp?" + reportURL ;
		var myBars 		= 'directories=no,location=no,menubar=no' ;
		var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
		var myFeatures 	= myBars + ', ' + myOptions ;

		var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;

		reportWindow.title= "Medicom Report Viewer" ;
		reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
		reportWindow.moveTo( 0,0 ) ;
		reportWindow.focus() ;
	}
 }   // Added for GHL-CRF-0458   - End
//added for BRU-CRF-399.1 - start
function assignDosage(dosage,uom_code,uom_desc,recCount,freq_nature,old_MAR_yn,alter_qty,drug_desc){ //drug_desc added for BRU-CRF-399.1
	var formObj= document.MedicationAdministrationFTDrugDetails;
	if(freq_nature=="P"){
		eval("formObj.non_iv_admin_qty1_"+recCount).value = dosage;
		eval("formObj.non_iv_admin_qty_uom1_"+recCount).value = uom_code;
		eval("formObj.non_iv_admin_qty_uom_"+recCount).value = uom_code;
		eval("formObj.bal_qty_"+recCount).innerHTML =alter_qty+" "+uom_desc;
	}else{
		eval("formObj.non_iv_admin_qty_"+recCount).value = dosage;
		eval("formObj.non_iv_admin_qty_uom_"+recCount).value = uom_code;
	}
		if(old_MAR_yn=="Y"){
			eval(document.getElementById("id_dosage_uom_"+recCount)).innerHTML = uom_desc;
			eval("formObj.alt_dosage_"+recCount).value = dosage;
			eval("formObj.alt_dosage_uom_"+recCount).value = uom_desc;
			eval("formObj.alt_MAR_YN_"+recCount).value = "Y";
		}
		else
			eval(document.getElementById('id_dosage_uom_new_MAR_')+recCount).innerHTML = uom_desc;

		document.getElementById('id_dispdrugdesc_'+recCount).innerHTML = drug_desc; //added for BRU-CRF-399.1



}//added for BRU-CRF-399.1 - end


//added for JD-CRF-0200 START

async function cancelAdminstration(drug_desc,admin_by_name,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq,administered_qty,patient_id,encounter_id,admin_date_time,strength_per_value_pres_uom){

	var dialogHeight	= "80vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "250" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:"+dialogHeight+"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal= await window.showModalDialog("../../ePH/jsp/MedicationAdminCancelRights.jsp?call_from=MAR&drug_desc="+drug_desc+"&admin_by_name="+admin_by_name+"&drug_code="+drug_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&iv_prep_yn="+iv_prep_yn+"&sch_date_time="+sch_date_time+"&dosage_seq="+dosage_seq+"&administered_qty="+administered_qty+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&admin_date_time="+admin_date_time+"&strength_per_value_pres_uom="+strength_per_value_pres_uom,"",features);

	//parent.document.f_query_add_mod.location.reload();
	if(retVal !='C')
	parent.frames[1].location.reload();
}

function validateUserRightsAuthPIN(call_from){
	var bean_id = "DispMedicationAllStages" ;
	var bean_name = "ePH.DispMedicationAllStages";
	var PIN			=	document.frmUserPINAuthorization.user_pin.value;
	var user_id		=	document.frmUserPINAuthorization.user_id.value;
	var reason_code		=	document.frmUserPINAuthorization.reason_code.value;
	var drug_code    =	document.frmUserPINAuthorization.drug_code.value;
	var order_id   =	document.frmUserPINAuthorization.order_id.value;
	var order_line_num =	document.frmUserPINAuthorization.order_line_num.value;
	var iv_prep_yn =	document.frmUserPINAuthorization.iv_prep_yn.value;
	var sch_date_time =	document.frmUserPINAuthorization.sch_date_time.value;
	var dosage_seq =	document.frmUserPINAuthorization.dosage_seq.value;
	var administered_qty=document.frmUserPINAuthorization.administered_qty.value;
	var patient_id=document.frmUserPINAuthorization.patient_id.value;
	var encounter_id=document.frmUserPINAuthorization.encounter_id.value;
	var admin_date_time=document.frmUserPINAuthorization.admin_date_time.value;
	var admin_by_name=document.frmUserPINAuthorization.admin_by_name.value;
	var strength_per_value_pres_uom=document.frmUserPINAuthorization.strength_per_value_pres_uom.value;

	if(reason_code=="" || PIN==""){
		alert(getMessage("CAN_NOT_BE_BLANK","COMMON").replace('$',"PIN / Cancel Med.Admin Reason"));
		return;
	}


		PIN         =encodeURIComponent(PIN,"UTF-8");

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "call_from =\"" + call_from + "\" " ;
	xmlStr+= "user_id =\"" + user_id + "\" " ;
	xmlStr+= "PIN =\"" + PIN + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=userPINAuthValidation";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	if(trimString(responseText)=="0"){
		alert("Invalid Pin");
		document.frmUserPINAuthorization.user_pin.focus();
		return false;
	}
	else{
		//alert(responseText);
		//window.returnValue=responseText;
		if(iv_prep_yn =="undefined"   || iv_prep_yn =="" || iv_prep_yn =="1" || iv_prep_yn =="3" || iv_prep_yn =="5" || iv_prep_yn =="9"){

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ drug_code +"\" " ;
	   xmlStr += "order_id=\""+ order_id +"\" " ;
		xmlStr += "order_line_num=\""+ order_line_num +"\" " ;
		xmlStr += "iv_prep_yn=\""+ iv_prep_yn +"\" " ;
		xmlStr += "sch_date_time=\""+ sch_date_time +"\" " ;
		xmlStr += "dosage_seq=\""+ dosage_seq +"\" " ;

		xmlStr += "administered_qty=\""+ administered_qty +"\" " ;
		xmlStr += "patient_id=\""+ patient_id +"\" " ;
		xmlStr += "encounter_id=\""+ encounter_id +"\" " ;

		xmlStr += "admin_date_time=\""+ admin_date_time +"\" " ;
		xmlStr += "admin_by_name=\""+ admin_by_name +"\" " ;
		xmlStr += "reasonCode=\""+ reason_code +"\" " ;
		xmlStr += "strength_per_value_pres_uom=\""+ strength_per_value_pres_uom +"\" " ;


		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?func_mode=cancelAdminDetails", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
		window.close();
	}
}

async function cancelHistory(drug_desc,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq_no,patient_id,encounter_id,admin_date_time){

	var dialogHeight	= "60vh" ;
	var dialogWidth		= "60vw";
	var dialogTop		= "250" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal = await window.showModalDialog("../../ePH/jsp/MARCancelHistory.jsp?drug_desc="+drug_desc+"&order_id="+order_id+"&order_line_num="+order_line_num+"&iv_prep_yn="+iv_prep_yn+"&sch_date_time="+sch_date_time+"&dosage_seq="+dosage_seq_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&admin_date_time="+admin_date_time,"",features);


}

//ADDED FOR JD-CRF-0200 END
