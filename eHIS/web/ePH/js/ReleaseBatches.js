var function_id = "" ;
var message		= "" ;
var flag		= "" ;
var result		= false ;
var cntr		= 0;

function query()	{

	formObj = f_query_criteria.document.formReleasebatches;//code added for Bru-HIMS-CRF-416[IN045566]--start
	var patient_id = formObj.patientid.value;
	var frompage = formObj.fromPage.value;
	var disp_locn_code = formObj.disp_locn_code.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	f_query_criteria.location.href="../../ePH/jsp/ReleaseBatchesQueryCriteria.jsp?patient_id="+escape(patient_id)+"&frompage="+frompage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date;////code added for Bru-HIMS-CRF-416[IN045566]-- End 
	f_query_result.location.href="../../eCommon/html/blank.html";
}

function reset()	{

	if(f_query_criteria)	{
		f_query_criteria.document.formReleasebatches.reset();
		f_query_result.location.href="../../eCommon/html/blank.html";
		f_batch_result.location.href="../../eCommon/html/blank.html";
	}
}

function callResultPage()	{  
	var frm_obj		=	parent.f_query_criteria.document.formReleasebatches.dt_from;
	var to_obj		=	parent.f_query_criteria.document.formReleasebatches.dt_to;
	var disp_locn	=	parent.f_query_criteria.document.formReleasebatches.disp_locn;
	var patient_id	=	parent.f_query_criteria.document.formReleasebatches.patient_id.value;
	var batches		=	parent.f_query_criteria.document.formReleasebatches.batches.value;
	var drug_code	=	parent.f_query_criteria.document.formReleasebatches.drug_code.value;
	var drug_desc	=	parent.f_query_criteria.document.formReleasebatches.drug_desc.value;
	var language_id	=	parent.f_query_criteria.document.formReleasebatches.language_id.value;
	var paid_status	=	parent.f_query_criteria.document.formReleasebatches.paidstatus.value;
	var bl_installed_yn	=	parent.f_query_criteria.document.formReleasebatches.bl_installed_yn.value;
	if(drug_desc=="")
		 drug_code="";
	msg_frame		=	parent.messageFrame;
	var fields	= new Array ();
	var names = new Array ();
	fields[0]	=  frm_obj;
	names[0]	=  getLabel("ePH.AllocatedDateFrom.label","PH");
	fields[1]	=  to_obj;
	names[1]	=  getLabel("ePH.AllocatedDateTo.label","PH");
	fields[2]	=  disp_locn;
	names[2]	=  getLabel("ePH.DispenseLocation.label","PH");

	if(checkFields( fields, names,msg_frame)){
		if(doDateCheck(frm_obj,to_obj,msg_frame) )	{
			var dt_from				=	parent.f_query_criteria.document.formReleasebatches.dt_from.value;
			var dt_to				=	parent.f_query_criteria.document.formReleasebatches.dt_to.value;
			var disp_locn			=	parent.f_query_criteria.document.formReleasebatches.disp_locn.value;
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			parent.f_query_result.location.href="../../ePH/jsp/ReleaseBatchesQueryResult.jsp?dt_from="+convertDate(dt_from,"DMY",language_id,"en")+"&dt_to="+convertDate(dt_to,"DMY",language_id,"en")+"&disp_locn="+disp_locn+"&patient_id="+patient_id+"&drug_code="+drug_code+"&bl_installed_yn="+bl_installed_yn+"&paid_status="+paid_status+"&batches="+batches+"&called_from=search";
		}	else	{
			parent.f_query_result.location.href="../../eCommon/html/blank.html"
		}  
	}
}

function SubmitLink(from,to,prevnext){
	if(flag){ // if condition Added for SRR20056-SCF-7734 ICN 28022
		var obj				=	document.frmReleaseBatchesResult;
		obj.from.value		=	from;
		obj.to.value		=	to;
		obj.prevnext.value	=   prevnext;
		obj.submit();
	}
}
var flag = true; // moved to generic var for SRR20056-SCF-7734 ICN 28022

function storeCheckedRecords(mode,from){// from  added for Bru-HIMS-CRF-416[IN045566]-
	result = '' ;
	message  = '' ;
	flag = '' ;

	var formObj;
	if(mode=='apply'&& from=='release') // from added for Bru-HIMS-CRF-416[IN045566]-- 
		  formObj = f_query_result.document.frmReleaseBatchesResult;
	else if(mode=='apply' && from=='dispmed') // added for Bru-HIMS-CRF-416[IN045566]-- start
		  formObj = parent.f_query_result.document.frmReleaseBatchesResult;// added for Bru-HIMS-CRF-416[IN045566]-- End
	else
		 formObj	= document.frmReleaseBatchesResult;

	flag = true;

	var arrObj = formObj.elements;
	//if(mode=='apply'){	//Commented for SRR20056-SCF-7734 ICN 28022
		for(var i=0;i<arrObj.length;i++){
			if(arrObj[i].type == "checkbox" && arrObj[i].name!= 'Selcet_chk'){ //&& arrObj[i].name!= 'Selcet_chk' condition added for IN19077 --23-02-2010 -- priya
				if(arrObj[i].checked){
					cntr = cntr+1;
					var name_value = arrObj[i].name;
					if(name_value!='Selcet_chk'){
						if(arrObj[i-1].value == ''){
							alert(getMessage("PH_REASON_NOT_SELECTED","PH"));
							if(!arrObj[i-1].Disabled)
								arrObj[i-1].focus();
							flag = false;
							return false;
							break;
						}
					}
				} 		
			}
		}
	//}
	// Added for SRR20056-SCF-7734 ICN 28022  - start
	if(mode=='apply' && formObj.incompleteAdmixFound.value == 'Y'){
		alert(getMessage("PH_SELECT_ADMIXTURE_BATCH","PH"));
		flag = false;
	}
	// Added for SRR20056-SCF-7734 ICN 28022  - End
	if(flag){

		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";

		var from   =  formObj.from.value;
		var val	   = "";
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type == "checkbox") {
				//if(arrObj[i].checked)	{
				xmlStr+= arrObj[i].name+"=\"" + arrObj[i].value + "\" " ;
				//} 		
			}
			if(arrObj[i].type == "select-one") {
				xmlStr+= arrObj[i].name+"=\"" + arrObj[i].value + "\" " ;
			}
		}
		xmlStr += " from=\""+from+"\"";
		xmlStr += " incompleteAdmixFound=\""+formObj.incompleteAdmixFound.value+"\"";
		xmlStr += " incompleteAdmixORdID=\""+formObj.incompleteAdmixORdID.value+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReleaseBatchesValidate.jsp?called_from=release",false);
		xmlHttp.send( xmlDoc ) ;
		return true;
	}
}

function apply() {
	

	formObj = f_query_result.document.frmReleaseBatchesResult; //added for ML-BRU-SCF-0603 [IN036245] start - avoid script error click on apply without searched any record. 
	if(formObj == undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	} //added for ML-BRU-SCF-0603 [IN036245] end

	cntr = 0;
	if(storeCheckedRecords('apply',"release")){ //release added for Bru-HIMS-CRF-416[IN045566]
		if(!proceedOnApply())	{
        	var select_value = f_query_result.document.frmReleaseBatchesResult.select_value.value; // newly added for ML-BRU-SCF-0603 [IN:036245]
			if(cntr > 0 || select_value == "Y"){ // newly added for ML-BRU-SCF-0603 [IN:036245]	
				eval( formApply(f_query_result.document.frmReleaseBatchesResult,PH_CONTROLLER  ) ) ;
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				if( result ) {
					onSuccess();
				}
			}
			else{
				alert(getMessage("PH_REASON_ONE_SELECTED","PH"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}		
		}	
		else	{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			return false;
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	}
}

function proceedOnApply() {
    var url = f_query_result.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
    else
		result	=	false;
	return result;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function beforePost(xmlStr){
	//alert("Disp Medication(Verification)::"+xmlStr);
}

function onSuccess() {
	formObj = f_query_criteria.document.formReleasebatches;//Added for Bru-HIMS-CRF-416[IN045566]--start
	var patient_id = formObj.patientid.value;
	var frompage = formObj.fromPage.value;
	var disp_locn_code = formObj.disp_locn_code.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	var reccount = formObj.reccount.value;//Added for Bru-HIMS-CRF-416[IN045566] -end
	
	f_query_criteria.location.href="../../ePH/jsp/ReleaseBatchesQueryCriteria.jsp?patient_id="+escape(patient_id)+"&frompage="+frompage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date;//Modified for Release Batch
	f_batch_result.location.href="../../eCommon/html/blank.html";
	f_query_result.location.href="../../eCommon/html/blank.html";
	if(frompage!=null && frompage=="dispmed")//Added forBru-HIMS-CRF-416[IN045566]--start
		{
	window.returnValue=frompage+"~"+reccount;
	window.close();
		}//Added for Bru-HIMS-CRF-416[IN045566]--end
}

function loadBatchDetails(order_id,ord_line_no,disp_no,obj){
	parent.f_batch_result.location.href="../../ePH/jsp/ReleaseBatchesDetails.jsp?order_id="+order_id+"&ord_line_no="+ord_line_no+"&disp_no="+disp_no;
}

function chkValue(obj, iAdmixcount, index, curWorkSheetId, order_id, order_line_num, doc_srl_no) {

	var lst_name = "";
	 if(obj.checked==true)
		 obj.value = "Y";
	 else{
		 obj.value = "N";
		 document.frmReleaseBatchesResult.Selcet_chk.checked=false;
		 var arrObj = document.frmReleaseBatchesResult.elements;
	   
	     for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].name == obj.name) {
				lst_name = escape(arrObj[i-1].name);
				eval("document.frmReleaseBatchesResult."+lst_name).selectedIndex = 0;
			}
		}
	}
	 //Added for SRR20056-SCF-7734 ICN 28022 - Start
	if(parseInt(iAdmixcount)>1){
		for (i=1; i<iAdmixcount ;i++ ){
			if( (parseInt(index)+i) >10 ){
				var formObj	= document.frmReleaseBatchesResult;
				if(obj.checked==true){
					alert(getMessage("PH_SELECT_ADMIXTURE_BATCH","PH"));
					formObj.incompleteAdmixFound.value="Y";
				}
				else 
					formObj.incompleteAdmixFound.value="N";

				//obj.value = "N";
				//obj.checked= false;
				//document.frmReleaseBatchesResult.Selcet_chk.checked=false;
				var bean_id   = formObj.bean_id.value;
				var bean_name = formObj.bean_name.value;
				var xmlDoc  = "";
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr += " order_id=\""+order_id+"\"";
				xmlStr += " Nxtorder_line_num=\""+(parseInt(order_line_num)+i)+"\"";
				xmlStr += " WorkSheetId=\""+curWorkSheetId+"\"";
				xmlStr += " select_yn=\""+obj.value+"\"";
				xmlStr += " bean_id=\""+bean_id+"\"";
				xmlStr += " bean_name=\""+bean_name+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ReleaseBatchesValidate.jsp?called_from=AdmixtureGroup",false);
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				break;
			}
			var iv_prep_yn = eval("document.frmReleaseBatchesResult.iv_prep_yn"+(parseInt(index)+i)).value;
			var workSheetId = eval("document.frmReleaseBatchesResult.workSheetid"+(parseInt(index)+i)).value;
			if((iv_prep_yn=='0' || iv_prep_yn=='2' || iv_prep_yn=='4' || iv_prep_yn=='6' || iv_prep_yn=='8')&&curWorkSheetId == workSheetId){
				eval("document.frmReleaseBatchesResult.check_id"+(parseInt(index)+i)).value = obj.value;
				eval("document.frmReleaseBatchesResult.check_id"+(parseInt(index)+i)).checked = obj.checked;
			}
			if(obj.checked==false)
				selectRsnAdmix(order_id, order_line_num, doc_srl_no, iAdmixcount, index);
		 }
	 }
	 //Added for SRR20056-SCF-7734 ICN 28022 - End
}

/*=============================================10/19/2004=======================================*/
async function callPatientSearch(target){
    var patient_id = await PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}

async function searchCode(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
		
	var formObj		   = document.formReleasebatches;
	//added for mohe-scf-0202
	var language_id  =formObj.language_id.value;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id;
//	argumentArray[0]   = formObj.SQL_PH_DRUG_SEARCH_DRUG.value+"'"+formObj.language_id.value+"'";
	argumentArray[0]   ="";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	
	//added for mohe-scf-0202
	argumentArray[12]  = "SQL_PH_DRUG_SEARCH_DRUG";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray

	var retVal = await CommonLookup( getLabel("ePH.DrugNameLookup.label","PH"), argumentArray );
	if(retVal != null && retVal != "" ){
		formObj.drug_code.value = retVal[0];
		formObj.drug_desc.value = retVal[1];
	}
}

function SelectAll(obj){   
	var formObj	= document.frmReleaseBatchesResult;
	var recCount=formObj.chk_.value;
	var from=formObj.from.value	;
	var to=formObj.to.value	;
	var rec_count = parseInt(document.frmReleaseBatchesResult.rec_count.value);
	for(var i=1;i<=rec_count;i++){  
		var incompleteAdmixFoundPrev = document.frmReleaseBatchesResult.incompleteAdmixFoundPrev.value;
		var PrevAdmixOrderID = document.frmReleaseBatchesResult.PrevAdmixOrderID.value;
		if(obj.checked==true){   
			if(incompleteAdmixFoundPrev != 'Y' || PrevAdmixOrderID!=(eval("document.frmReleaseBatchesResult.order_id"+i).value)){
				if(eval("document.frmReleaseBatchesResult.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
					eval("document.frmReleaseBatchesResult.check_id"+i).click(); 
			}
			else if (eval("document.frmReleaseBatchesResult.check_id"+i).disabled == false)
				if(eval("document.frmReleaseBatchesResult.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
					eval("document.frmReleaseBatchesResult.check_id"+i).click(); 
		}
		else if(obj.checked==false){
			if(incompleteAdmixFoundPrev == "Y" && PrevAdmixOrderID != undefined && PrevAdmixOrderID !=''){
				if(PrevAdmixOrderID != (eval("document.frmReleaseBatchesResult.order_id"+i).value)){
					if(eval("document.frmReleaseBatchesResult.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
						eval("document.frmReleaseBatchesResult.check_id"+i).click(); 
				}
				else if (eval("document.frmReleaseBatchesResult.check_id"+i).disabled == false)
					if(eval("document.frmReleaseBatchesResult.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
						eval("document.frmReleaseBatchesResult.check_id"+i).click(); 
			}
			else{
				if(eval("document.frmReleaseBatchesResult.check_id"+i).checked != obj.checked)  //Added for IN032747 - end
					eval("document.frmReleaseBatchesResult.check_id"+i).click(); 
			}
		}
	}
}

function changebatches(obj){
    var frm_obj		=	parent.f_query_criteria.document.formReleasebatches;
	if(obj.value=="A")
		frm_obj.INFUSION_UOM.value	=	"H";
	else if(obj.value=="D")
		frm_obj.infuse_over_time.innerHTML	= "<b> "+getLabel("Common.Minute(s).label","Common")+"</b>";
}
/*==============================================================================================*/
// Added for SRR20056-SCF-7734 ICN 28022 - Start
function selectRsnAdmix(order_id, order_line_num, doc_srl_no,iAdmixcount, index){
	var formObj		   = document.frmReleaseBatchesResult;
	var iv_prep_yn = eval("document.frmReleaseBatchesResult.iv_prep_yn"+index).value;
	if((order_line_num == 1  || order_line_num == '1') && (iv_prep_yn=='0' || iv_prep_yn=='2' || iv_prep_yn=='4' || iv_prep_yn=='6' || iv_prep_yn=='8')){
		try{
			for(i=1; i<iAdmixcount; i++){
				if( (parseInt(index)+i) >10 ){
					//obj.value = "N";
					//obj.checked= false;
					//document.frmReleaseBatchesResult.Selcet_chk.checked=false;
					var bean_id   = formObj.bean_id.value;
					var bean_name = formObj.bean_name.value;
					var xmlDoc  ="";
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr += " reason_code=\""+eval("document.frmReleaseBatchesResult.rcode_"+order_id+order_line_num+doc_srl_no).value+"\"";
					xmlStr += " bean_id=\""+bean_id+"\"";
					xmlStr += " bean_name=\""+bean_name+"\"";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","ReleaseBatchesValidate.jsp?called_from=AdmixtureGroupReason",false);
					xmlHttp.send( xmlDoc ) ;
					eval(xmlHttp.responseText);
					break;
				}
				curr_doc_srl_no = eval("document.frmReleaseBatchesResult.doc_srl_no"+(parseInt(index)+i)).value ;
				sel_name = 'rcode_'+order_id+(parseInt(order_line_num)+i)+curr_doc_srl_no;
				eval("document.frmReleaseBatchesResult."+sel_name).selectedIndex =  eval("document.frmReleaseBatchesResult.rcode_"+order_id+order_line_num+doc_srl_no).selectedIndex
			}
		}
		catch(e){
		}
	}
}//Added for SRR20056-SCF-7734 ICN 28022 -End

function disponSuccess() {/*Added for Bru-HIMS-CRF-416[IN045566]--start*/
	formObj = parent.f_query_criteria.document.formReleasebatches;
	var patient_id = formObj.patientid.value;
	var frompage = formObj.fromPage.value;
	var disp_locn_code = formObj.disp_locn_code.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	var reccount = formObj.reccount.value;
	var refflag = formObj.refflag.value;
	
	parent.f_query_criteria.location.href="../../ePH/jsp/ReleaseBatchesQueryCriteria.jsp?patient_id="+patient_id+"&frompage="+frompage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date;//Modified for Release Batch
	parent.f_batch_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_result.location.href="../../eCommon/html/blank.html";
	if(frompage!=null && frompage=="dispmed"){
		window.returnValue=frompage+"~"+reccount+"~"+refflag;
		window.close();
	}
}

function dispapply(){
	formObj = parent.f_query_result.document.frmReleaseBatchesResult;
	if(formObj == undefined){
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_REASON_ONE_SELECTED","PH");	//code 'parent' added for IN048062	
		return false;
	} 
	cntr = 0;
	if(storeCheckedRecords('apply',"dispmed")){
		if(!dispproceedOnApply())	{
        		var select_value = parent.f_query_result.document.frmReleaseBatchesResult.select_value.value;
			if(cntr > 0 || select_value == "Y"){
				eval( formApply(parent.f_query_result.document.frmReleaseBatchesResult,PH_CONTROLLER  ) ) ;
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				if( result ) {
					disponSuccess();
				}
			}
			else{
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+  getMessage("PH_REASON_ONE_SELECTED","PH");
			}		
		}	
		else	{
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_ONE_SELECTED","PH");
			return false;
		}
	}
	else{
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_ONE_SELECTED","PH");
	}
}

function dispproceedOnApply() {
    var url = parent.f_query_result.location.href;
	var result;
    url = url.toLowerCase();
	if (url.indexOf("blank.html")!=-1)
		result	= true;
    else
		result	=	false;
	return result;
}//code added for Bru-HIMS-CRF-416[IN045566]-- End
