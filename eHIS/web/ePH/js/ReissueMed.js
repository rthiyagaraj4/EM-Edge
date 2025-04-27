var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var DispLocnDesc="";
var toolbar = "";
var QueryStr = "";
var pswd_flag="N";
function storeDesc(obj){
	DispLocnDesc = obj.options[obj.selectedIndex].text;
}
async function showLoginWindow(disp_locn_details,function_id,toolbar, homepage, store_code, patient_class){
	toolbar = toolbar;
	if(homepage!='Y' || store_code == undefined || store_code=='' || patient_class == undefined || patient_class==''){ // if condition and else block added for Bru-HIMS-CRF-073.1 [IN:047222]
		var dialogHeight= "12" ;
		var dialogWidth	= "33" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/ReissueMedLogin.jsp?disp_locn_details="+encodeURIComponent(disp_locn_details,'UTF-8')+"&function_id="+function_id+"&homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal=="GOHOME" || retVal == undefined){
			//history.go(-1);
			window.location.href = '../../eCommon/jsp/dmenu.jsp';
		}
		else{
			//window.close();
			var x = retVal.split("!");
			document.location.href ="../../ePH/jsp/ReissueMedFrameset.jsp?disp_locn="+x[0]+"&disp_locn_desc="+x[1]+"&source="+toolbar ;
		}
	}
	else{ // added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		var retVal ="";
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr	="<root><SEARCH " ;
		xmlStr += " disp_locn_code=\"" + store_code + "\"";
		xmlStr += " Patient_Class=\"" + patient_class + "\"";	
		xmlStr += " homepage=\"" + homepage + "\"";	
		xmlStr +=" /></root>" ;
		var temp_jsp="ReissueMedValidation.jsp?func_mode=ShowQueryCrieteria";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		if(retVal != 'ACCESS_DENIED'){
			document.location.href ="../../ePH/jsp/ReissueMedFrameset.jsp?disp_locn="+store_code+"&disp_locn_desc="+encodeURIComponent(retVal,"UTF-8")+"&source="+toolbar ;
		}
		else{
			alert(getMessage('ACCESS_DENIED',"PH"));
			parent.CommonToolbar.ShowMenu.click();
			parent.CommonToolbar.unLoadTitleName();
		}

	} //added for Bru-HIMS-CRF-073.1 [IN:047222] - end
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}

function focusInToPassword(yn){
	if(yn == "Y")
		document.frmReissueMedLogin.password.focus();
}

function showQueryCriteria(obj){
	var fields  = new Array() ;
	var names   = new Array() ;
	password = obj.password;
	disp_locn = obj.disp_locn;
	patient_class =obj.Patient_Category.value;
    if(patient_class=='O') 
		patient_class ='OP';
	else  if(patient_class=='I') 
		patient_class ='IP';
	fields[0]   = password;
	names[0]   = getLabel("Common.password.label","Common");
	fields[1]   = disp_locn;
	names[1]   = getLabel("ePH.DispenseLocation.label","PH");
	if(checkFlds(fields,names)){
	xmlStr	="<root><SEARCH " ;
	xmlStr += " password=\"" + password.value + "\"";
	xmlStr += " disp_locn_code=\"" + disp_locn.value + "\"";
	xmlStr += " DispLocnDesc=\"" + encodeURIComponent(DispLocnDesc,"UTF-8") + "\"";
	xmlStr += " Patient_Class=\"" + patient_class + "\"";	
	xmlStr +=" /></root>" ;
	var temp_jsp="ReissueMedValidation.jsp?func_mode=ShowQueryCrieteria";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(pswd_flag =="N"){
			//window.returnValue=disp_locn.value + "!" + DispLocnDesc;
			//window.close();
			
			let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = disp_locn.value + "!" + DispLocnDesc;;
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			dialogTag.close();  
		}
		else{
			document.getElementById("password").focus();
		}
    }
}


function focusOnPasswordField(obj){
	pswd_flag= obj;
}

function goHome(){
	//window.returnValue="GOHOME";
	//window.close();
			let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = disp_locn.value + "!" + DispLocnDesc;;
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			dialogTag.close(); 
}


function enableDispNo(frmobj){
	if(frmobj.Patient_Id.value != ""){
	//frmobj.Dispense_No.disabled=false;
	//frmobj.Disp_No_Button.disabled=false;
	//frmobj.Dispense_No.focus();
	}
	else {
		frmobj.Patient_Id.focus(); 
	}

}

//for drug lookup
function drugsearch(obj){
	var formObj = obj;
	retVal =DrugSearch( "D", obj.Drug_Name,"ReturnMedication" );
	if( (retVal != null) && (retVal != "" ))  {
		formObj.Drug_Name.value = retVal[1] ;
		formObj.Drug_Code.value = retVal[0];
	}
}

//for dispense no. lookup
async function dispensesearch(target){
	    var patientid = document.FormReissueMedicationQueryCriteria.Patient_Id.value;
		var disp_locn = document.FormReissueMedicationQueryCriteria.disp_locn.value;
		var disp_locn_desc = document.FormReissueMedicationQueryCriteria.disp_locn_desc.value;
        var url     = "../../ePH/jsp/ReissueMedDispLookupFrame.jsp?PatientId=" + patientid +"&disp_locn="+disp_locn+"&disp_locn_desc="+escape(disp_locn_desc);
        var dialogTop   = "100";
        var dialogHeight    = "29" ;
        var dialogWidth = "50" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await window.showModalDialog( url, arguments, features ) ;
//	    var returnval = window.open( url, arguments, features ) ;
		if (returnval != "" && returnval != undefined)
		{
		var Arr =returnval.split("!");
		var dispno = Arr[0];
		var patientid = Arr[1];
		var Locncode = Arr[2];
		var patientclass = Arr[3];
		document.FormReissueMedicationQueryCriteria.Dispense_No.value=dispno;
		document.FormReissueMedicationQueryCriteria.Patient_Id.value=patientid;
		document.FormReissueMedicationQueryCriteria.Locn_Code.value=Locncode;
		document.FormReissueMedicationQueryCriteria.Patient_Class.value=patientclass;

		}
}

function callResultPageDisp(frmobj){

	var DispCode		= frmobj.Disp_Location.value;
	var DispDate		= frmobj.Disp_Date.value;
	var DrugCode		= frmobj.Drug_Code.value;
	var OrderId			= frmobj.Order_Id.value;
	var OrderDate		= frmobj.Order_Date.value;
	var PatientClass	= frmobj.Patient_Class.value;
	var bean_id			= frmobj.bean_id.value;
	var bean_name	= frmobj.bean_name.value;
	var OrderLocation	= frmobj.Order_Code.value;
	var PatientId		=	frmobj.Patient_Id.value;
	parent.Disp_Result_Frame.location.href="../../ePH/jsp/ReissueMedDispLookupResult.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&DispCode="+DispCode+"&DispDate="+DispDate+"&DrugCode="+DrugCode+"&OrderId="+OrderId+"&OrderDate="+OrderDate+"&PatientClass="+PatientClass+"&PatientId="+PatientId+ "&OrderLocation="+OrderLocation;
}


function CloseResult(dispno,patientid,locationcode){
window.returnValue=dispno+"!"+patientid+"!"+locationcode+"!"+parent.Disp_Lookup_Frame.document.FormReissueMedDispLookup.Patient_Class.value;
window.close();

}
function CloseOrdResult(ordid,ordloc){
window.returnValue=ordloc;
window.close();
}

async function OrderSearch(frmObj){

	var formObj = document.frames.FormReissueMedDispLookup;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = 'C1';
	dataTypeArray[0]   = STRING ;

//	argumentArray[0]   = "SQL_PH_REISSUE_MEDICATION_SELECT7";
	if(frmObj.Patient_Class.value == "IP")
		argumentArray[0]   =frmObj.SQL_PH_REISSUE_MEDICATION_SELECT7.value;
	else
		argumentArray[0]   =frmObj.SQL_PH_REISSUE_MEDICATION_SELECT8.value;

	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK  ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		formObj.Order_Location.value = retVal[1] ;
		formObj.Order_Code.value = retVal[0] ;
	}
}

function callReissueResultPage(frmObj){

// Check for Mandatory Fields
	var fields=new Array();
	fields[0]=frmObj.Patient_Id;
	fields[1]=frmObj.Disp_date_from;
	fields[2]=frmObj.Disp_date_to;
	
	var names=new Array();
	names[0]=getLabel("Common.patientId.label","Common");
	names[1]=getLabel("ePH.DispenseDateFrom.label","PH");
	names[2]=getLabel("ePH.DispensedDateTo.label","PH");
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = checkFields( fields, names, parent.messageFrame, errorPage) ;
	if (blankObject!=true)
	{
		return;
	}
	parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	parent.f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

	var bean_id				= frmObj.Bean_Id.value;	
	var bean_name			= frmObj.Bean_Name.value;
	var PatientId			= frmObj.Patient_Id.value;
	var DrugCode			= frmObj.drug_code.value;
    var ordering_facility_id = frmObj.facility_id.value;// added for FD-BRU-CRF-092
	var language_id			= frmObj.language_id.value;
	var Disp_date_from		= convertDate(frmObj.Disp_date_from.value,"DMY",language_id,"en");
	var Disp_date_to		= convertDate(frmObj.Disp_date_to.value,"DMY",language_id,"en");
	//var ordering_facility_id= frmObj.OrderingFacility.options[frmObj.OrderingFacility.selectedIndex].value; // commented for FD-BRU-CRF-092
	 if(frmObj.drug_desc.value==""){	//Added if condition for MMS ADHOC Testing
		DrugCode="";
	 }
	var disp_locn		= frmObj.disp_locn.value;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");*/
	xmlHttp.open("POST", "ReissueMedValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=ClearData", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	
	parent.f_query_add_mod_result.location.href="../../ePH/jsp/ReissueMedResult.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&PatientId="+PatientId+"&DrugCode="+DrugCode+"&Disp_date_from="+Disp_date_from+"&Disp_date_to="+Disp_date_to+"&disp_locn="+disp_locn+"&ordering_facility_id="+ordering_facility_id;	
}

async function stockdialog(itemcode,storecode,recno,qty,uom, Disp_facility_id){

	var bl_interface_yn         = parent.f_query_add_mod.document.FormReissueMedicationQueryCriteria.bl_interface_yn.value;
	var tot_groos_pat_payable_str   = parent.f_query_add_mod_result.document.FormReissueMedicationResult.tot_gross_charge_amount.value ;
    var tot_gross_charge_amount_str = parent.f_query_add_mod_result.document.FormReissueMedicationResult.tot_groos_pat_payable.value;

	var disp_uom    =    eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.Uom_"+recno).value ;
	var includeZeroStockBatches = "N";
	var includeExpiredBatches   = "N";
	var includeSuspendedBatches = "N";
	var searchFunction          = "Y";
	var multipleSelect          = "Y"; 
	var dialogHeight	        = "90vh" ;
	var dialogWidth		        = "90vw";
	var dialogTop		        = "10" ;
	var dialogLeft		        = "20" ;
	var center			        = "0" ;
	var status			        = "no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal= await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+itemcode+"&store_code="+storecode+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect,arguments,features);
	if (retVal != "undefined" && retVal != null){
		parent.f_query_add_mod_result_det.location.href="../../ePH/jsp/ReissueMedBatchLookup.jsp?retval="+escape(retVal) + "&calledfrom=modelwin"+"&no="+recno+"&item_code="+itemcode+"&store_code="+storecode+"&disp_uom="+disp_uom+"&Disp_facility_id="+Disp_facility_id+"&qty="+qty; //Disp_facility_id added for FD-BRU-CRF-092 AND qty,issued_qty Added for MMS InternalTesting;
		parent.buttonFrame1.location.href="../../ePH/jsp/ReissueMedButtons.jsp?rec_no="+ recno+"&qty="+qty+"&qty_uom="+uom+"&bl_interface_yn="+bl_interface_yn+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str+"&Disp_facility_id="+Disp_facility_id;
	}
}

function callBatchDetails(storecode,itemcode,issueqty,recCount,patientid,orderid,orderlineno,drugcode,enddate,recno,disp_no,Disp_facility_id,drug_name)//Disp_facility_id added for FD-BRU-CRF-092
{
	var bl_interface_yn =parent.f_query_add_mod.document.FormReissueMedicationQueryCriteria.bl_interface_yn.value;
    dispdetailform = parent.f_query_add_mod_result.document;
    var tot_groos_pat_payable_str   = dispdetailform.FormReissueMedicationResult.tot_gross_charge_amount.value ;
    var tot_gross_charge_amount_str = dispdetailform.FormReissueMedicationResult.tot_groos_pat_payable.value;


	var k;
	if(bl_interface_yn=="N")
		k=4;
	else
		k=7;
	num = parseInt(recno) +2;
	var Tdispensingdetails=parent.f_query_add_mod_result.document.getElementById('Tdispensingdetails');
	if(Tdispensingdetails.rows.length > num){
		for(var i=2;i<Tdispensingdetails.rows.length;i++){
			for (var j=0;j<k ; j++){
				 //dispdetailform.Tdispensingdetails.rows(i).cells(j).style.backgroundColor="";//Commented for MMSAdhoc-INC-PH001 [IN:047542]
				Tdispensingdetails.rows[num].cells[j].style.backgroundColor="#fde6d0";//Added for MMSAdhoc-INC-PH001 [IN:047542]
			}
		}
		for (var i=0;i<k ; i++){
			//		if(dispdetailform.Tdispensingdetails.rows(recno+1).cells(i).style.backgroundColor=="#fde6d0"){
			Tdispensingdetails.rows[num].cells[i].style.backgroundColor="#fde6d0";
		}
	}
	var patient_class = dispdetailform.FormReissueMedicationResult.loc_code.value;
	var fill_period = dispdetailform.FormReissueMedicationResult.fill_period.value;
	var fill_unit = dispdetailform.FormReissueMedicationResult.fill_unit.value;
	var issueqtytemp = issueqty.split(" ");
	var unit="";
	 for (i=1; i< issueqtytemp.length; i++ )
    {
		unit= unit + " " + issueqtytemp[i];		
    }
	var qty = issueqtytemp[0];

	
	//added for ML-BRU-SCF-1073 by Ganga
	var	reissue_drug_name="";
	if(drug_name!=undefined)
		reissue_drug_name = drug_name.value;
	//added ended
     if(bl_interface_yn=='Y'){	  	
         parent.f_query_add_mod_detail.location.href="../../ePH/jsp/ReissueMedIssuedResult.jsp?orderid="+orderid+"&orderlineno="+orderlineno+"&drug_code="+ drugcode+"&item_code="+itemcode+ "&patient_id="+patientid+ "&order_id="+orderid+ "&order_line_no=" +orderlineno+"&qty="+qty+ "&qty_uom="+unit+ "&no="+recCount+ "&store_code="+storecode+ "&end_date="+enddate+"&calledfrom='' &patient_class="+patient_class+"&fill_period="+fill_period+"&fill_unit="+fill_unit+"&rec_no="+recno+"&disp_no="+disp_no+"&bl_interface_yn="+bl_interface_yn+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str+"&Disp_facility_id="+Disp_facility_id+"&reissue_drug_name="+encodeURIComponent(reissue_drug_name,'UTF-8'); //Disp_facility_id added for FD-BRU-CRF-092 //added reissue_drug_name for ML-BRU-SCF-1073
	 }else{
		 parent.f_query_add_mod_detail.location.href="../../ePH/jsp/ReissueMedIssuedResult.jsp?orderid="+orderid+"&orderlineno="+orderlineno+"&drug_code="+ drugcode+"&item_code="+itemcode+ "&patient_id="+patientid+ "&order_id="+orderid+ "&order_line_no=" +orderlineno+"&qty="+qty+ "&qty_uom="+unit+ "&no="+recCount+ "&store_code="+storecode+ "&end_date="+enddate+"&calledfrom='' &patient_class="+patient_class+"&fill_period="+fill_period+"&fill_unit="+fill_unit+"&rec_no="+recno+"&disp_no="+disp_no+"&bl_interface_yn="+bl_interface_yn+"&Disp_facility_id="+Disp_facility_id+"&reissue_drug_name="+encodeURIComponent(reissue_drug_name,'UTF-8'); //Disp_facility_id added for ML-BRU-SCF-1073 //added reissue_drug_name for ML-BRU-SCF-1073
	 }
	
}

function loadStockDetails(drugcode,itemcode,patientid,orderid,orderlineno,qty,unit,recCount,storecode,enddate,patient_class,fill_period,fill_unit,recno,Disp_facility_id,drug_name){ //Disp_facility_id added for FD-BRU-CRF-092 //added reissue_drug_name for ML-BRU-SCF-1073

	var bl_interface_yn =parent.f_query_add_mod.document.FormReissueMedicationQueryCriteria.bl_interface_yn.value;
	var tot_groos_pat_payable_str   = parent.f_query_add_mod_result.document.FormReissueMedicationResult.tot_gross_charge_amount.value ;
    var tot_gross_charge_amount_str = parent.f_query_add_mod_result.document.FormReissueMedicationResult.tot_groos_pat_payable.value;


    var batchId    = eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.batch_ids_"+recno).value ;
	var binLocCode = eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.binlocation_codes_"+recno).value;
	var expiryDate = eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.expiary_dates_"+recno).value ;
    var issued_qty = eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.issued_qty_"+recno).value ;


   var disp_uom    =eval("parent.f_query_add_mod_result.document.FormReissueMedicationResult.Uom_"+recno).value ;

   //added for ML-BRU-SCF-1073 by Ganga
	var	reissue_drug_name="";
	if(drug_name!=undefined)
		reissue_drug_name = drug_name.value;
	//added ended
	parent.f_query_add_mod_result_det.location.href="../../ePH/jsp/ReissueMedBatchLookup.jsp?drug_code="+ drugcode+"&item_code="+itemcode+ "&patient_id="+patientid+ "&order_id="+orderid+ "&order_line_no=" +orderlineno+"&qty="+qty+ "&qty_uom="+unit+ "&no="+recCount+ "&store_code="+storecode+ "&end_date="+enddate+"&calledfrom='' &patient_class="+patient_class+"&fill_period="+fill_period+"&=fill_unit"+fill_unit+"&batchId="+batchId+"&binLocCode="+binLocCode+"&expiryDate="+expiryDate+"&issued_qty="+issued_qty+"&disp_uom="+disp_uom+"&Disp_facility_id="+Disp_facility_id+"&reissue_drug_name="+encodeURIComponent(reissue_drug_name,'UTF-8'); //Disp_facility_id added for FD-BRU-CRF-092 //added reissue_drug_name for ML-BRU-SCF-1073 by ganga
	parent.buttonFrame1.location.href="../../ePH/jsp/ReissueMedButtons.jsp?drug_code="+ drugcode+"&item_code="+itemcode+ "&patient_id="+patientid+ "&order_id="+orderid+ "&order_line_no=" +orderlineno+"&qty="+qty+ "&qty_uom="+unit+ "&no="+recCount+ "&store_code="+storecode+ "&end_date="+enddate+"&rec_no="+recno+"&bl_interface_yn="+bl_interface_yn+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str+"&Disp_facility_id="+Disp_facility_id;
}

function shiftFocus(){
	if(document.ReissueMedBatchLookup.issue_qty0)
	document.ReissueMedBatchLookup.issue_qty0.focus();
}

function ReissueAllocate(recno,qty,uom,end_date,Disp_facility_id){ // //Disp_facility_id added for FD-BRU-CRF-092
	dispdetailform = parent.f_query_add_mod_result.document;
	frmobj = parent.f_query_add_mod_result_det.document.all;
	sysdate =parent.f_query_add_mod.document.FormReissueMedicationQueryCriteria.sysdate.value;
	bl_interface_yn =parent.f_query_add_mod.document.FormReissueMedicationQueryCriteria.bl_interface_yn.value;
	if(end_date == null || end_date=='null'){
		end_date = "";
	}

	var fields=new Array();
	fields[0]=eval("dispdetailform.FormReissueMedicationResult.reasons"+recno);
	var names=new Array();
	names[0]=getLabel("ePH.ReissueReason.label","PH");
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = checkFields( fields, names, parent.messageFrame, errorPage) ;
	if (blankObject!=true){
		return;
	}
	var batchId		= "";
	var expiryDate	="";
	var binLocCode	="";
	var tradeId		="";
	var qty			="";
	var totqty		= 0;
	var batch_str	="";
	var tot_sum_qty="";//Added for Bru-HIMS-CRF-405[IN 044830]
	var multi_batch_qty ="";//Added for ICN : 30812 
	dispNo			= eval("dispdetailform.FormReissueMedicationResult.disp_no"+recno).value;
	reissueReason	= eval("dispdetailform.FormReissueMedicationResult.reasons"+recno).value;
	unitCost		= eval("dispdetailform.FormReissueMedicationResult.UnitCost_"+recno).value;
	encounter_id    =eval("dispdetailform.FormReissueMedicationResult.encounter_id_"+recno).value; 
	discharge_ind    =eval("dispdetailform.FormReissueMedicationResult.discharge_ind"+recno).value; 
	reissue_type_ind =eval("dispdetailform.FormReissueMedicationResult.reissue_type_ind"+recno).value; //Added for Bru-HIMS-CRF-405[IN 044830]
	reissue_count_by_ind=eval("dispdetailform.FormReissueMedicationResult.reissue_count_by_ind"+recno).value;//Added for Bru-HIMS-CRF-405[IN 044830]
	reissue_count   =eval("dispdetailform.FormReissueMedicationResult.reissue_count"+recno).value;//Added for Bru-HIMS-CRF-405[IN 044830]
	tot_trans_qty	= parent.f_query_add_mod_detail.FormReissueMedicationIssuedResult.tot_qty.value;//Added for Bru-HIMS-CRF-405[IN 044830]
	tot_count		=parent.f_query_add_mod_detail.FormReissueMedicationIssuedResult.tot_count.value;//Added for Bru-HIMS-CRF-405[IN 044830]
	reissueQtyUom =parent.f_query_add_mod_result.document.getElementById('Tdispensingdetails').rows[parseInt(recno) + 2].cells[1].innerText;

//trade;batchid,exp_date,bin_loc,req_qty

	var x = (reissueQtyUom).split(" ");
	for(j=1; j<reissueQtyUom.length; j++){
		if (!( reissueQtyUom[j] == undefined))
			uom = uom + reissueQtyUom[j];
	}
	if(parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup!=undefined){//[IN035994] - checking script error.  
	var conv_factor = parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.conv_factor.value;
	var baseUOM = parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.baseUOM.value; //Added for HSA-SCF-0221

	if(parseFloat(conv_factor)==0){
	  alert(getMessage("PH_ITEMS_UOM_DEF_NOT_FOUND","PH"));
	  // obj.focus();
	   return false;
	}

	for(i=1; i< parent.f_query_add_mod_result_det.document.getElementById("batchtable").rows.length; i++){
		if( eval("parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.select"+(i-1)) != undefined && eval("parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.select"+(i-1)).checked == true){
			batchId=batchId +  "~" + eval("frmobj.batch_id"+(i-1)).value;
			expiryDate=expiryDate + "~" +eval("frmobj.expiry_date"+(i-1)).value;

			binLocCode=binLocCode + "~" + eval("frmobj.bin_locn_code"+(i-1)).value;
			tradeId=tradeId + "~" + eval("frmobj.trade_id"+(i-1)).value;
			//qty= qty+ "~" + eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).value; 
			qty = qty + "~" + parent.f_query_add_mod_result_det.document.getElementById('issue_qty' + (i - 1)).value;
			//batch_str  =batch_str + eval("frmobj.trade_id"+(i-1)).value +";"+eval("frmobj.batch_id"+(i-1)).value+";"+eval("frmobj.expiry_date"+(i-1)).value+";"+eval("frmobj.bin_locn_code"+(i-1)).value+";"+eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).value+";";
			batch_str = batch_str + frmobj["trade_id" + (i - 1)].value + ";" + frmobj["batch_id" + (i - 1)].value + ";" + frmobj["expiry_date" + (i - 1)].value + ";" + frmobj["bin_locn_code" + (i - 1)].value + ";" + parent.f_query_add_mod_result_det.document.getElementById('issue_qty' + (i - 1)).value + ";";
			//totqty = parseInt(totqty) + parseInt(eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).value);
			totqty = parseInt(totqty) + parseInt(parent.f_query_add_mod_result_det.document.getElementById('issue_qty' + (i - 1)).value);
			tot_sum_qty=parseInt(totqty)+parseInt(tot_trans_qty);//Added for Bru-HIMS-CRF-405[IN 044830]
			//multi_batch_qty=parseInt(eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).value);//Added for ICN : 30812
			multi_batch_qty = parseInt(parent.f_query_add_mod_result_det.document.getElementById('issue_qty' + (i - 1)).value);
			if(multi_batch_qty==0){//Added for  ICN : 30812 if any batch quantity is zero while allocation
				alert(getMessage("ALLOC_QTY_CANNOT_ZERO","PH"));				
				return false;
			}
			if(reissue_type_ind=="F" && reissue_count_by_ind=="Q" && (parseInt(tot_sum_qty)>parseInt(reissue_count))){//Added if and else if for Bru-HIMS-CRF-405[IN 044830]
				var msg = getMessage("PH_REISSUE_QUANTITY","PH");
				msg = msg.replace("$",reissue_count);
				alert(msg);
				eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).focus();
				return false;
			 }
			else if(reissue_type_ind=="F" && reissue_count_by_ind=="C" && (parseInt(tot_count)>=parseInt(reissue_count))){
				alert(getMessage("PH_REISSUE_QUANTITY_TIME","PH"));
				eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty')"+(i-1)).focus();
				return false;
			}
		}
	}
	if (isNaN(totqty) == true) {
		alert(getMessage("ALLOC_QTY_CANNOT_BLANK","PH"));
		return false;
	}
/* commented for ICN : 30812 no need to display this Message */	
	/*if(totqty<=0){
		alert(getMessage("NO_BATCHES_FOR_ALLOC","PH"));				
		return false;
	}*/
	eval("dispdetailform.FormReissueMedicationResult.batch_ids_"+recno).value =batchId;
	eval("dispdetailform.FormReissueMedicationResult.binlocation_codes_"+recno).value=binLocCode;
	eval("dispdetailform.FormReissueMedicationResult.expiary_dates_"+recno).value =expiryDate;
	eval("dispdetailform.FormReissueMedicationResult.issued_qty_"+recno).value =qty;

	drugCode			=	eval("dispdetailform.FormReissueMedicationResult.drugcode_"+recno).value;
	OrderLineNo			=	eval("dispdetailform.FormReissueMedicationResult.OrderLine_"+recno).value;
	DispLocCode			=	eval("dispdetailform.FormReissueMedicationResult.DispLocCode_"+recno).value;
	Uom					=	eval("dispdetailform.FormReissueMedicationResult.Uom_"+recno).value;
	var reissuableqty	=	eval("dispdetailform.FormReissueMedicationResult.reissuableqty"+recno).value;
	//var reissue_qty = parseInt(eval("parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.issue_qty"+recno).value);
	ItemCode	=	frmobj.item_code.value;
	StoreCode	=	frmobj.store_code.value;
	patientId	=	dispdetailform.FormReissueMedicationResult.patient_id.value;
	order_id	=	eval("dispdetailform.FormReissueMedicationResult.OrderId"+recno).value; //Modified for ICN_ADHOC_016
	num			=	parseInt(recno) +3;
	if(reissue_type_ind=="V" && parseInt(tot_sum_qty)>parseInt(reissuableqty)){ //Added below if condition for Bru-HIMS-CRF-405[IN 044830] 
		alert(getMessage("RE_ISSUE_QTY_CANNOT_GRT_ISS_QTY","PH"));
		return;
	}

	if( eval("parent.f_query_add_mod_result_det.document.getElementById('issue_qty0')")){	
		var fromval = parseInt(reissuableqty);
		var conv_factor = parent.f_query_add_mod_result_det.document.ReissueMedBatchLookup.conv_factor.value;
		var fromval_equl			=  Math.ceil(parseInt(fromval)/parseInt(conv_factor));
		var totqty_equl	    =  Math.ceil(parseInt(totqty)/parseInt(conv_factor));
		if( totqty > 0 &&  totqty_equl <= fromval_equl){
			
			if(bl_interface_yn=='Y'){				

				xmlStr	="<root><SEARCH " ;
				xmlStr += " patientId=\"" + patientId + "\"";
				xmlStr += " encounter_id=\"" + encounter_id + "\"";
				xmlStr += " discharge_ind=\"" + discharge_ind + "\"";
				xmlStr += " sysdate=\"" + sysdate + "\"";
				xmlStr += " ItemCode=\"" + ItemCode + "\"";
				xmlStr += " StoreCode=\"" + StoreCode + "\"";
				xmlStr += " Disp_facility_id=\"" + Disp_facility_id + "\""; // //Disp_facility_id added for FD-BRU-CRF-092
				xmlStr += " totqty=\"" + totqty + "\"";
				xmlStr += " batch_str=\"" + batch_str + "\"";
				xmlStr += " order_id=\"" + order_id + "\"";
				xmlStr += " OrderLineNo=\"" + OrderLineNo + "\"";
				xmlStr += " recno=\"" + recno + "\"";
				xmlStr += " gross_charge_amount=\"" + eval("dispdetailform.FormReissueMedicationResult.gross_charge_amount_"+recno).value + "\"";
				xmlStr += " groos_pat_payable=\"" + eval("dispdetailform.FormReissueMedicationResult.groos_pat_payable_"+recno).value + "\"";
				xmlStr += " tot_groos_pat_payable=\"" + dispdetailform.FormReissueMedicationResult.tot_gross_charge_amount.value + "\"";
				xmlStr += " tot_gross_charge_amount=\"" +  dispdetailform.FormReissueMedicationResult.tot_groos_pat_payable.value + "\"";
				xmlStr += " dispNo=\"" +  dispNo + "\"";//[IN035994] Added new parameter DispNo
				xmlStr +=" /></root>" ;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ReissueMedValidation.jsp?func_mode=CalculateBillDetails",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				eval(responseText);
			}
			var toval=eval(parent.f_query_add_mod_result.document.getElementById('reissueqty_'+recno));
			toval.innerText = totqty;
			var chk=eval(parent.f_query_add_mod_result.document.getElementById('reissue_vis_'+recno));
			chk.checked="true";
			bean_id = dispdetailform.FormReissueMedicationResult.bean_id.value;
			bean_name = dispdetailform.FormReissueMedicationResult.bean_name.value;
			QueryStr = "ReissueMedValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&dispNo="+dispNo+"&batchId="+batchId+"&expiryDate="+expiryDate+"&binLocCode="+binLocCode+"&tradeId="+tradeId+"&totqty="+totqty+"&uom="+baseUOM+"&drugCode="+drugCode+"&ItemCode="+ItemCode+"&StoreCode="+StoreCode+"&patientId="+patientId +"&OrderLineNo="+OrderLineNo+"&DispLocCode="+DispLocCode+"&Uom="+Uom+"&unitCost="+unitCost+"&func_mode=StoreData"+"&qty="+qty+"&Disp_facility_id="+Disp_facility_id; //uom changed to baseUOM for  HSA-SCF-0221
			
			dispdetailform.FormReissueMedicationResult.querytext.value = QueryStr;
			eval("dispdetailform.FormReissueMedicationResult.reasons"+recno).focus();
			
			bean_id = dispdetailform.FormReissueMedicationResult.bean_id.value;
			bean_name = dispdetailform.FormReissueMedicationResult.bean_name.value;
			label_cau_instrn1_eng = eval("dispdetailform.FormReissueMedicationResult.label_cau_instrn1_eng"+recno).value;//Added for [IN:052983] start
			label_cau_instrn2_eng = eval("dispdetailform.FormReissueMedicationResult.label_cau_instrn2_eng"+recno).value;
			label_spl_instrn1_eng = eval("dispdetailform.FormReissueMedicationResult.label_spl_instrn1_eng"+recno).value;
			label_spl_instrn2_eng = eval("dispdetailform.FormReissueMedicationResult.label_spl_instrn2_eng"+recno).value;
			label_pat_instrn1_eng = eval("dispdetailform.FormReissueMedicationResult.label_pat_instrn1_eng"+recno).value;
			label_cau_instrn1_loc = eval("dispdetailform.FormReissueMedicationResult.label_cau_instrn1_loc"+recno).value;
			label_cau_instrn2_loc = eval("dispdetailform.FormReissueMedicationResult.label_cau_instrn2_loc"+recno).value;
			label_spl_instrn1_loc = eval("dispdetailform.FormReissueMedicationResult.label_spl_instrn1_loc"+recno).value;
			label_spl_instrn2_loc = eval("dispdetailform.FormReissueMedicationResult.label_spl_instrn2_loc"+recno).value;
			label_pat_instrn1_loc = eval("dispdetailform.FormReissueMedicationResult.label_pat_instrn1_loc"+recno).value;//Added for [IN:052983] end
			label_cau_instrn1_eng = encodeURIComponent(label_cau_instrn1_eng,'UTF-8');
			label_cau_instrn2_eng =encodeURIComponent(label_cau_instrn2_eng,'UTF-8');
			label_spl_instrn1_eng =encodeURIComponent(label_spl_instrn1_eng,'UTF-8');
			label_spl_instrn2_eng =encodeURIComponent(label_spl_instrn2_eng,'UTF-8');
			label_cau_instrn1_loc =encodeURIComponent(label_cau_instrn1_loc,'UTF-8');
			label_cau_instrn2_loc = encodeURIComponent(label_cau_instrn2_loc,'UTF-8');
			label_spl_instrn1_loc =encodeURIComponent(label_spl_instrn1_loc,'UTF-8');
			label_spl_instrn2_loc =encodeURIComponent(label_spl_instrn2_loc,'UTF-8');
			
			label_pat_instrn1_eng=encodeURIComponent(label_pat_instrn1_eng,'UTF-8'); //Added for ML-MMOH-SCF-1951
			label_pat_instrn1_loc=encodeURIComponent(label_pat_instrn1_loc,'UTF-8'); //Added for ML-MMOH-SCF-1951
			
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			//var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
			var xmlStr ="<root><SEARCH ";//Added for [IN:052983] start
			xmlStr += " label_cau_instrn1_eng=\"" + label_cau_instrn1_eng + "\"";
			xmlStr += " label_cau_instrn2_eng=\"" + label_cau_instrn2_eng + "\"";
			xmlStr += " label_spl_instrn1_eng=\"" + label_spl_instrn1_eng + "\"";
			xmlStr += " label_spl_instrn2_eng=\"" + label_spl_instrn2_eng + "\"";
			xmlStr += " label_pat_instrn1_eng=\"" + label_pat_instrn1_eng + "\"";
			xmlStr += " label_cau_instrn1_loc=\"" + label_cau_instrn1_loc + "\"";
			xmlStr += " label_cau_instrn2_loc=\"" + label_cau_instrn2_loc + "\"";
			xmlStr += " label_spl_instrn1_loc=\"" + label_spl_instrn1_loc + "\"";
			xmlStr += " label_spl_instrn2_loc=\"" + label_spl_instrn2_loc + "\"";
			xmlStr += " label_pat_instrn1_loc=\"" + label_pat_instrn1_loc + "\"";
			xmlStr +=" /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	//Added for [IN:052983] end
			xmlHttp.open("POST", "ReissueMedValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&dispNo="+dispNo+"&batchId="+batchId+"&expiryDate="+expiryDate+"&binLocCode="+binLocCode+"&tradeId="+tradeId+"&reissueReason="+reissueReason+"&totqty="+totqty+"&uom="+baseUOM+"&drugCode="+drugCode+"&ItemCode="+ItemCode+"&StoreCode="+StoreCode+"&patientId="+patientId +"&OrderID="+order_id+"&OrderLineNo="+OrderLineNo+"&DispLocCode="+DispLocCode+"&endDate="+end_date+"&unitCost="+unitCost+"&Uom="+Uom+"&func_mode=StoreData"+"&qty="+qty+"&Disp_facility_id="+Disp_facility_id, false);//Added OrderID for Bru-HIMS-CRF-405[IN:044830] //uom changed to baseUOM for  HSA-SCF-0221
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
	
		}
		else if(reissue_type_ind=="V"){//Added for Bru-HIMS-CRF-405[IN044830]
			//alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
			alert(getMessage("RE_ISSUE_QTY_CANNOT_GRT_ISS_QTY","PH"));
			return;
		}
		else{
			alert(getMessage("RE_ISSUE_QTY_CANNOT_GRT_ISS_QTY","PH"));
			return;
		}
	}

	if(dispdetailform.Tdispensingdetails.rows.length > num){
		var cellclick = eval("dispdetailform.drug_name"+(parseInt(recno)+1));

		if(cellclick!=undefined) {
			cellclick.click()	;
		} else {
			parent.f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html"
			//parent.buttonFrame1.location.href="../../eCommon/html/blank.html"
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp"
		}
	}
	else {
		parent.f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html"
		//parent.buttonFrame1.location.href="../../eCommon/html/blank.html"
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp"
	}
	}//[IN035994] - checking script error.
}

function storeInBean(obj,recno){
	if(obj.value != ""){
		bean_id = document.FormReissueMedicationResult.bean_id.value;
		bean_name = document.FormReissueMedicationResult.bean_name.value;
		var xmlDoc			= "";
		var xmlHttp			= new XMLHttpRequest();
		QueryStr=document.FormReissueMedicationResult.querytext.value;
		var enddate = eval("document.FormReissueMedicationResult.end_date_"+recno).value;
		var str = QueryStr + "&reissueReason="+obj.value + "&endDate="+enddate;
		xmlHttp.open("POST", str, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
	}
}

function validateCheck(obj,no) {
	if(obj.checked==false) {
	obj	=	eval("document.ReissueMedBatchLookup.issue_qty"+no);
	obj.value	=	"";
	}
}

function apply() {
	if(f_query_add_mod_result.document.FormReissueMedicationResult == undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	var bl_interface_yn      = f_query_add_mod_result.document.FormReissueMedicationResult.bl_interface_yn.value;	
	var patient_class        = f_query_add_mod_result.document.FormReissueMedicationResult.patient_class.value;
	var disp_cash_coll_stage = f_query_add_mod_result.document.FormReissueMedicationResult.disp_cash_coll_stage.value;
	var tot_rec				 = f_query_add_mod_result.document.FormReissueMedicationResult.tot_rec.value;
	var found				 = false;
	var approval_no_flag	 = f_query_add_mod_result.document.FormReissueMedicationResult.approval_no_flag.value;//AAKH-CRF-0117

	 for(i=0; i<tot_rec; i++) {
		if(eval(f_query_add_mod_result.document.getElementById('reissue_vis_'+i))!=undefined) {			 
			if(eval(f_query_add_mod_result.document.getElementById('reissue_vis_'+i)).checked==true && eval(f_query_add_mod_result.document.getElementById('reissueqty_'+i)).innerText!=''){//Changed as reissueqty_ for Bru-HIMS-CRF-405[IN:044830]
				found=true; 
				break
			}					 
		}
	}
	//AAKH-CRF-0117 - start
	var approval_flag = true;
	if(approval_no_flag=="true"){
	  for(i=0; i<tot_rec; i++) {
		if(eval(f_query_add_mod_result.document.getElementById("reissue_vis_"+i))!=undefined) {	
			if(eval(f_query_add_mod_result.document.getElementById("reissue_vis_"+i)).checked==true && eval(f_query_add_mod_result.document.getElementById("reissueqty_"+i)).innerText!=""){
				if(eval("f_query_add_mod_result.document.FormReissueMedicationResult.approval_no_"+i)!=undefined) {			 
					if(eval("f_query_add_mod_result.document.FormReissueMedicationResult.approval_no_"+i).disabled==false && eval("f_query_add_mod_result.document.FormReissueMedicationResult.approval_no_"+i).value=="" && eval("f_query_add_mod_result.document.FormReissueMedicationResult.approval_no_app_for_patient_class_"+i).value=="Y"){ //modified for AAKH-CRF-0117
						approval_flag=false; 
						break
					}					 
				}
			}
		}
	   } 
	}
	
	if(approval_flag==false){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH");
			return false;
	}
	//AAKH-CRF-0117 - end
	if(found){
		var returnd   = formApply(f_query_add_mod_result.document.FormReissueMedicationResult,PH_CONTROLLER  );
		eval(returnd);
		if( result ) {
			onSuccess(bl_interface_yn,patient_class,disp_cash_coll_stage);
		}
		else{
			clearframes();
		 }
	}
	else{
        alert(getMessage("NO_ORDER_FOR_ALLOC_REISSUE", "PH") );
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
		//clearframes(); //Commented for 27743 to stop clearing frames.
	}
}

function assignResult( _result, _message, _flag, x ) {
	result = _result ;
    message  = _message ;
    flag = _flag ;
}

async function onSuccess(bl_interface_yn,patient_class,disp_cash_coll_stage) {
	var dialogHeight= "6" ;
	var dialogWidth	= "33" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/ReissueMedPrintDialog.jsp?",arguments,features);
	if(bl_interface_yn=='Y' && patient_class!='IP' && patient_class!='DC'&& disp_cash_coll_stage=='D'){
		getbillingdetails();
	}
	else{
		clearframes();
	}

}
function getbillingdetails(){
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();
	xmlHttp.open("POST", "ReissueMedValidation.jsp?func_mode=GETBLDETAILS", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

/*function callbillingwindow(doc_det_for_bl,disp_locn_code)
{	
	var retVal = new Array();		
	var center='1';
	var dialogTop = "100";
	var dialogHeight = "40" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";		

	var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"storecode="+disp_locn_code+"&"+"blnggrp="+blnggrpid+"&"+"module_id=PH";	
	retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);
}*/

async function callbillingwindow(doc_det_for_bl,disp_locn_code){
	detail = doc_det_for_bl.split(",");
	/*var doc_no   =  detail[0];
	var doc_type =  detail[1];
	var bill_group_code =  detail[2];
	var error_text =  detail[3];
	*/
	if(detail!= null && detail != ''){//ifcondition added for IN028200 - Reopen
		var bill_doc_no			    =  detail[0];
		var bill_doc_type			=  detail[1];
		var bill_group_code			=  detail[2];
		var call_disc_function_yn	=  detail[3];
		var l_slmt_reqd_yn			=  detail[4];
		var doc_no					=  detail[5];
		var patient_id				=  detail[6];
		var encounter_id			=  detail[7];
		var patient_class			=  detail[8];
		var error_text				=  detail[9];
		if(error_text==undefined || error_text==''){
			if(patient_class=="E"||patient_class=="O"){
				episode_id = (encounter_id).substring(0,encounter_id.length-4);
				visit_id = (encounter_id).substring(encounter_id.length-4,encounter_id.length);
			}
			else if(patient_class=="I"||patient_class=="D"){
				episode_id = formObj.encounter_id.value;
				visit_id   = "1";
			}

			var retVal = new Array();		
			var center='1';
			var dialogTop = "100";
			var dialogHeight = "40" ;
			var dialogWidth = "70" ;
			var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
			var arguments = "" ;
			var column_sizes = escape("");               
			var column_descriptions ="";		

		//	var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+doc_type+"&"+"billdocnum="+doc_no+"&"+"storecode="+disp_locn_code+"&"+"blnggrp="+bill_group_code+"&"+"module_id=PH";	
			//retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);
			var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_no + "&store_code=" + disp_locn_code + "&blng_grp=" + bill_group_code + "&module_id=PH&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+patient_class;
			 retVal=await window.showModalDialog(url,arguments,features);
			 if(retVal==undefined){
				callbillingwindow(doc_det_for_bl,disp_locn_code);
			 }
		}
		else{
			alert(error_text);			
		}	
	}
	clearframes();
}

function clearframes(){
	         
	if(flag!=0 && flag!="null"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message + getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18'><b>"+flag+"</b></label>";
		var print_confirm=confirm(getMessage("PH_PRINT_TOKEN", "PH"));
		var patient_id=f_query_add_mod.FormReissueMedicationQueryCriteria.Patient_Id.value;
	
		if(print_confirm){ 					
			print_yn="Y"; 					
			
			var xmlHttp			= new XMLHttpRequest();
			xmlStr ="<root><SEARCH  /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "ReissueMedValidation.jsp?func_mode=onLinePrinting"+"&patient_id=" + patient_id + "&flag=" + flag, true);
			xmlHttp.send( xmlDoc ) ;
		} 				 
	}
	else{
		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message ;
	}
	f_query_add_mod.location.href = "../../ePH/jsp/ReissueMedQuery.jsp";
	f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html";
	buttonFrame1.location.href="../../eCommon/html/blank.html";
}

function printOnlineDispense(frmObj) {	
	if(frmObj.disp_label.checked ){		
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "language_id=\"" + frmObj.language_id.value + "\" " ;				
		xmlStr +=" /></root>" ;
		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReissueMedValidation.jsp?func_mode=PrintReissue",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//eval(responseText);
		//window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
	else{
        // window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
}

function beforePost(str){
//	alert("Reissue Medication::"+str);
}
function query(){
	reset();
}

function reset(){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	f_query_add_mod.location.href = "../../ePH/jsp/ReissueMedQuery.jsp";
	f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html";
	buttonFrame1.location.href="../../eCommon/html/blank.html";
}

function cancel(formObj){
	formObj.reset();
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] + "'"+ getLabel("Common.Cannotbeblank.label","Common")+"'" + "\n" ;
			if(fields[i].disabled==false){
				fields[i].focus();
			}
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function uppercase() {
	key = window.event.keyCode;
 if((key>0x60) && (key< 0x7B))
   window.event.keyCode=key-0x20;
}

function updateRecords(obj,drug_code,disp_no,no){
	if(obj.checked !=true){
		value="N";
	}
	else{
		value="Y";
	}
	var OrderLineNo = eval("dispdetailform.FormReissueMedicationResult.OrderLine_"+no).value;//Added for Bru-HIMS-CRF-405[IN:044830]
	var OrderID = eval("dispdetailform.FormReissueMedicationResult.OrderId"+no).value;//Added for Bru-HIMS-CRF-405[IN:044830]
	var bl_interface_yn =document.FormReissueMedicationResult.bl_interface_yn.value;//Added for Bru-HIMS-CRF-405[IN:044830]
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");*/
	xmlHttp.open("POST", "ReissueMedValidation.jsp?drug_code="+drug_code+"&disp_no="+disp_no+"&value="+value+"&OrderID="+OrderID+"&OrderLineNo="+OrderLineNo+"&recno="+no+"&bl_interface_yn="+bl_interface_yn+"&func_mode=updateRecords", false);//Added OrderID,OrderLineno,recno,bl_interface_yn for Bru-HIMS-CRF-405[IN:044830]
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
}

async function searchDrugName(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.FormReissueMedicationQueryCriteria.sql_ph_reissue_medication_select12.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = document.FormReissueMedicationQueryCriteria.drug_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.DrugName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		document.FormReissueMedicationQueryCriteria.drug_desc.value = retVal[1] ;
		document.FormReissueMedicationQueryCriteria.drug_code.value = retVal[0];
		}
}

function loadorders(){
	var frmObj=parent.f_query_criteria.document.formPendingOrderCriteria;
	var fields=new Array();
	fields[0]=frmObj.patient_id;
	fields[1]=frmObj.disp_location;
	
	
	var names=new Array();
	names[0]	= getLabel("Common.patientId.label","Common");
	names[1]	= getLabel("ePH.DispenseLocation.label","PH");
	
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = checkFields( fields, names, parent.messageFrame, errorPage) ;
	if (blankObject!=true){
		return;
	}
	else{
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}

	var disp_locn_code	    =	parent.f_query_criteria.document.formPendingOrderCriteria.disp_location.value;
	var patient_id		    =	parent.f_query_criteria.document.formPendingOrderCriteria.patient_id.value;
  	parent.f_order_detail.location.href="../../ePH/jsp/PendingMedicationOrderStatusOrderDetails.jsp?patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&called_from=pendingorders";
}

function DisplayBillingDetails (flag,recno,gross_charge_amount_str,groos_pat_payable_str,tot_gross_charge_amount_str,tot_groos_pat_payable_str,err_msg,excl_incl_ind,approval_reqd_yn,override_allowed_yn,order_id,order_line_no){
	var k; //Added for MMSAdhoc-INC-PH001 [IN:047542]-start
	if(flag=="N")
		k=4;
	else
		k=7;
	num = parseInt(recno) +2;

	dispdetailform = parent.f_query_add_mod_result.document;
   //AAKH-CRF-0117 - start
	var approval_no_flag = dispdetailform.FormReissueMedicationResult.approval_no_flag.value;

	if(approval_no_flag=="true"){
		eval("dispdetailform.FormReissueMedicationResult.approval_no_"+recno).style.display="inline";
		if(gross_charge_amount_str!="" && groos_pat_payable_str!="" && groos_pat_payable_str!=gross_charge_amount_str){
			
			eval("dispdetailform.FormReissueMedicationResult.approval_no_"+recno).disabled=false;
 
				 
		}else{
			eval("dispdetailform.approval_no_"+recno).disabled=true;
		}
	}
//AAKH-CRF-0117 - end
   	if(flag=="Y"){	
	  	//if(dispdetailform.Tdispensingdetails.rows.length > num){
			for(var i=0;i<eval("dispdetailform.row_"+recno).cells.length;i++){
				parent.f_query_add_mod_result.document.getElementById('row_' + recno).cells[i].style.backgroundColor = "#fde6d0";
			}
		//}
  	}//Added for MMSAdhoc-INC-PH001 [IN:047542]-End
	if(flag=='Y'){
		eval("dispdetailform.gross_charge_amount_display_"+recno).innerText             = gross_charge_amount_str;
		eval("dispdetailform.groos_pat_payable_display_"+recno).innerText               = groos_pat_payable_str;
		eval("dispdetailform.FormReissueMedicationResult.gross_charge_amount_"+recno).value = gross_charge_amount_str;
		eval("dispdetailform.FormReissueMedicationResult.groos_pat_payable_"+recno).value   = groos_pat_payable_str;
		eval("dispdetailform.inc_exec_"+recno).innerHTML   = "<a  style ='font-size:9' href=\"javascript:callIncludeExclude('"+order_id+"'"+","+"'"+order_line_no+"'"+","+"'"+excl_incl_ind+"'"+","+"'"+approval_reqd_yn+"'"+","+"'"+override_allowed_yn+"'"+")\">"+ getLabel("Common.Include.label","common_labels")+"?</a>";	
		document.getElementById('total_payable').innerText              =getLabel("ePH.TotalChargeAmount.label","PH") +" : "+tot_gross_charge_amount_str ;
		document.getElementById('patient_payable').innerText            =getLabel("ePH.TotalPayableAmount.label","PH") +" : "+tot_groos_pat_payable_str  ;
		dispdetailform.FormReissueMedicationResult.tot_gross_charge_amount.value =tot_gross_charge_amount_str ;
		dispdetailform.FormReissueMedicationResult.tot_groos_pat_payable.value  =tot_groos_pat_payable_str ;
	 }
	 else{
		  eval("dispdetailform.gross_charge_amount_display_"+recno).innerHTML   = "      <label style='font-size:9;color:red' title='"+err_msg+"'>"+getLabel("Common.Error.label","Common")+"</label>";
		  eval("dispdetailform.groos_pat_payable_display_"+recno).innerHTML     = "      <label style='font-size:9;color:red' title='"+err_msg+"'>"+getLabel("Common.Error.label","Common")+"</label>";
		  eval("dispdetailform.FormReissueMedicationResult.gross_charge_amount_"+recno).value = "";
		  eval("dispdetailform.FormReissueMedicationResult.groos_pat_payable_"+recno).value   = "";
	 }
}


async function callIncludeExclude(order_id,order_line_no,excl_incl_ind,approval_reqd_yn,override_allowed_yn){
	var dialogHeight	= "5" ;
	var dialogWidth	    = "50";
	var dialogTop	    = "10" ;
	var dialogLeft	    = "30" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await window.showModalDialog("../../ePH/jsp/BillingIncludeExclude.jsp?override_allowed_yn="+override_allowed_yn+"&approval_reqd_yn="+approval_reqd_yn+"&excl_incl_ind_default="+excl_incl_ind+"&order_id="+order_id+"&order_line_no="+order_line_no ,arguments,features);
}

function populateDispLocn (homepage, store_code) {
	
	formObj    = document.frmReissueMedLogin;
	patientcat = formObj.Patient_Category.value;

	formObj.disp_locn.innerText = "";

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;

	
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH  /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReissueMedValidation.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&patientcat=" + patientcat+"&func_mode=DISPLOCN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval( responseText ) ;
	if(homepage=='Y'){
		document.frmReissueMedLogin.disp_locn.value=store_code;
	}
}
function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
}

function addData(code, desc, obj) {
	if(desc!="")
		desc = decodeURIComponent(desc,"UTF-8");
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function checkstock(obj,avail_qty,conv_factor){
	 if(obj.value!=""){
		if(parseInt(obj.value)>parseInt(avail_qty))	{
			alert(getMessage('PH_ALLOC_QTY_LESS_AVAIL_QTY','PH'));
			obj.value="";
		}
	}
	if(parseFloat(conv_factor)==0){
	  alert(getMessage("PH_ITEMS_UOM_DEF_NOT_FOUND","PH"));
	  // obj.focus();
	   return false;
	}
	if((parseFloat(obj.value)%parseFloat(conv_factor))!=0 && obj.value>0){
		alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);
		obj.focus();
		return false;
	}
 }

 //function added for IN23375 for updating changed reissue reason after allocating -- 26/08/2010-- priya

 function updateReason(reason_obj,record_num){
	var frmobj = document.FormReissueMedicationResult;
	var arrObj		= frmobj.elements;
	var reissue_obj_name  = "issued_qty_"+record_num;
	var drugcode_obj_name = "drugcode_"+record_num;
	var dispno_obj_name = "disp_no"+record_num;
	var OrderID			= eval("frmobj.OrderId"+record_num).value;//Added for Bru-HIMS-CRF-405[IN:044830]
	var OrderLineNo		= eval("frmobj.OrderLine_"+record_num).value;//Added for Bru-HIMS-CRF-405[IN:044830]
	var drug_code = "";
	var disp_no = "";
	var reissue_reason = reason_obj.value;
	var store = false;
	
	for(i=0;i<arrObj.length;i++) {
		if(arrObj[i].type=="hidden"){	
			if(arrObj[i].name == drugcode_obj_name)
					drug_code = arrObj[i].value;
			if(arrObj[i].name == dispno_obj_name)
				disp_no = arrObj[i].value;
			if(arrObj[i].name == reissue_obj_name){
				if(arrObj[i].value!=""){
					store = true;	
				}
			}
		}
	}
	if(store == true) {
		var xmlStr = "";
		xmlStr	="<root><SEARCH " ;
		xmlStr += " disp_no=\"" + disp_no + "\"";
		xmlStr += " drug_code=\"" + drug_code + "\"";
		xmlStr += " recno=\"" + record_num + "\"";
		xmlStr += " reissue_reason=\"" + reissue_reason + "\"";
		xmlStr += " OrderID=\"" + OrderID + "\"";//Added for Bru-HIMS-CRF-405[IN:044830]
		xmlStr += " OrderLineNo=\"" + OrderLineNo + "\"";//Added for Bru-HIMS-CRF-405[IN:044830]
		xmlStr +=" /></root>" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReissueMedValidation.jsp?func_mode=updateReason",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	 }
 }
 function DateCheck(from,to) { //code added for ICN_ADHOC_030 -- Start 
	if(from.value=="" || to.value==""){ 
		return false;
	}  
	else{
		if(!isBefore(to.value,from.value,"DMY",document.FormReissueMedicationQueryCriteria.language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.select();
			return false;
		}
	}
    return true;
}

function validate_date(Obj,ref) {
	var formObj = document.FormReissueMedicationQueryCriteria;
	if(formObj.Disp_date_from.value=='' || formObj.Disp_date_to.value==''){ 
		return false;
	}
	else{
		if(!isBefore(formObj.Disp_date_from.value,formObj.Disp_date_to.value,"DMY",formObj.language_id.value)) {
			
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			formObj.Disp_date_from.select();
			return false;
		}
	}
	return true;
} 

function CheckDateT(obj){ 
	var locale=document.FormReissueMedicationQueryCriteria.language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	return true;
}
//code added for ICN_ADHOC_030  -- End
	//added for AAKH-CRF-0117 - start
function KeyPressSpecCharsForApprovalNo(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%^*()';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
  
}
function CheckForSpecCharApprovalno(Obj,stage,recCount){
		
        var str = Obj.value;
        var strvalidate = "";
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==33)||(str.charCodeAt(u)==64)||(str.charCodeAt(u)==35)||(str.charCodeAt(u)==37)||(str.charCodeAt(u)==94)||(str.charCodeAt(u)==42)||(str.charCodeAt(u)==40)||(str.charCodeAt(u)==41)){//To allow only !,@,#,%,^,*,(,) special characters
            	 
            	strvalidate=strvalidate+str.charAt(u);
            }
		}
		 if(stage=="R")
			 eval("document.FormReissueMedicationResult.approval_no_"+recCount).value = strvalidate;
		 
 }
 function getApprovalNumForDrug(obj,rec_count){
	  var approval_no=obj.value;
	var formObj			= document.FormReissueMedicationResult;
   	 var bean_id		=  formObj.bean_id.value;  
	 var bean_name		=  formObj.bean_name.value; 
	  
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " order_id=\""+eval("formObj.order_id_"+rec_count).value+"\"";
		xmlStr += " order_line_num=\""+eval("formObj.order_line_no_"+rec_count).value+"\"";
		xmlStr += " disp_no=\""+eval("formObj.disp_no"+rec_count).value+"\"";
		xmlStr += " approval_no=\""+approval_no+"\"";
		
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReissueMedValidation.jsp?func_mode=ApprovalNoForDrug&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
}
 //added for AAKH-CRF-0117 - end
