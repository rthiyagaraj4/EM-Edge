/* 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210622            16777	      PMG2021-COMN-CRF-0076     palaniNarayanan
2	     V210730           16777	      PMG2021-COMN-CRF-0076      Mohana Priya
3			 V211118		   23078	        PMG2021-COMN-CRF-0076.1      Manivel Natarajan
4								30618	        PMG2021-COMN-CRF-0076.2      Manivel Natarajan
5		   V230106				36652	    	TH-KW-CRF-0145.1		 Mohanapriya
6			V230221				41203	BL-TAIBA-Manage Patient Packages	 Mohanapriya
*/



var adhocParams = "";
var patientID	= "";
var patientID1	= "";
//var hdrModified='N';
var selidx=0;
var submitParamsMain	= "";

function moveFrame() {
	var temp = document.body.scrollLeft;
	scrollValue = temp;

	if (parent.BLMaintaintreatmentPackage.location.href.indexOf(".jsp") != -1) {
		parent.BLMaintaintreatmentPackage.document.body.scrollLeft = temp;
	}
}


function fnClearCode(obj){
	obj.value = '';
}

function displayPline(patientId) {
	parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/jsp/pline.jsp?Patient_ID="
			+ patientId;
}

async function openDetails(selRow,pkgServLmtDtlsPrivYN) {
	var sel_package_code = document.getElementById("hdn_pack_code").value;
	var sel_package_seq_no = document.getElementById("hdn_pack_seq_no").value;
	
	var parent_pkg_serv_ind = document.getElementById("pkg_serv_ind" + selRow).value;
	var parent_pkg_serv_code = document.getElementById("pkg_serv_code" + selRow).value;
	
	var pkg_serv_lmt_YN = document.getElementById('pkg_serv_lmt_YN').value;
	var daily_pkg_lmt_yn = document.getElementById('daily_pkg_lmt_yn').value;
	var p_daily_pkg_serv_lmt = document.getElementById('p_daily_pkg_serv_lmt').value;
	var p_daily_pkg_serv_lmt_ind = document.getElementById('p_daily_pkg_serv_lmt_ind').value;
	var facility_id = document.getElementById('facility_id').value;
	var patientid1 = document.getElementById('patientid1').value;
	var is_excl_mod_YN = document.getElementById("is_excl_mod_YN_" + selRow).value;
	var excl_string = document.getElementById("excl_string_" + selRow).value;
	var noofdecimal = document.getElementById("noofdecimal").value;
	
	var params = "sel_package_code="+sel_package_code+"&sel_package_seq_no="+sel_package_seq_no+"&parent_pkg_serv_ind="+parent_pkg_serv_ind+"&parent_pkg_serv_code="+parent_pkg_serv_code+"&pkg_serv_lmt_YN="+pkg_serv_lmt_YN+"&daily_pkg_lmt_yn="+daily_pkg_lmt_yn+"&p_daily_pkg_serv_lmt="+p_daily_pkg_serv_lmt+"&p_daily_pkg_serv_lmt_ind="+p_daily_pkg_serv_lmt_ind+"&facility_id="+facility_id+"&patientid="+patientid1+"&is_excl_mod_YN="+is_excl_mod_YN+"&excl_string="+excl_string+"&noofdecimal="+noofdecimal+"&pkgServLmtDtlsPrivYN="+pkgServLmtDtlsPrivYN;
	
	if(parent_pkg_serv_ind == 'S'){
		alert("Exclusion is not allowed for Rate based Service");
		return false;
	}
	
	if(parent_pkg_serv_ind=='M'){
		alert(getMessage("BL0979","BLEXT"));
		return false;
	}//V230221
	
	var title="Package Exclusions"; //getLabel("eBL.PKG_EXCL.label","BL");
	var dialogUrl = "../../eBL/jsp/MainTreatmentPackageServiceDtls.jsp?title="+title+"&"+params;
	var dialogFeatures = "dialogHeight:" + "90vh" + "; dialogWidth:" + "90vw"
			+ " ; scroll=false; ";
	var returnVal = await top.window.showModalDialog(dialogUrl, null, dialogFeatures);
	//alert("returnVal:"+returnVal);
	var arr = new Array();
	if(returnVal != null && returnVal.length>0)
	{
		arr=returnVal.split("||");
		document.getElementById("is_excl_mod_YN_"+selRow).value=arr[0];
		document.getElementById("excl_string_"+selRow).value=arr[1];			
	}
}

async function openEncDetails(pkg_code, package_seq_no, eff_date, count) {
	
	var ass_deass_chk = document.getElementById("enc_checkbox_dtl" + count);
	var enc_assoc_yn_from_db = document.getElementById("enc_assoc_yn" + count);
	var assDeassEncPrivYN = document.getElementById('assDeassEncPrivYN').value;
	var privlege_code = "MODIFY_ASSOC_DEASSOC_MTPKG";	
	
	if(ass_deass_chk.checked){
		if(assDeassEncPrivYN == "Y"){
			document.getElementById('assDeassEncPrivYN').value = "Y";
			document.getElementById("hid_enc_checkbox_dtl" + count).value = "Y";
		} else {
			var retVal = await authPkgAccessForUser(privlege_code);
			if(retVal=="Y"){
				document.getElementById('assDeassEncPrivYN').value = "Y";
				document.getElementById("hid_enc_checkbox_dtl" + count).value = "Y";
			} else {
				document.getElementById('assDeassEncPrivYN').value = "N";
				ass_deass_chk.checked = false;
				document.getElementById("hid_enc_checkbox_dtl" + count).value = "N";
				document.getElementById("encAssString_" + count).value = "";
				alert("User do not have the privilege");
				return false;
			}			
		}
	} else {
		ass_deass_chk.checked = false;
		document.getElementById("hid_enc_checkbox_dtl" + count).value = "N";
		document.getElementById("encAssString_" + count).value = "";
		
		$.ajax({
			type : "POST",
			url : "../jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=clearSession",
			async : false,
			dataType : "text",
			success : function(data) {
				
			}
		});
		
		return false;
	}
	
	var eff_from_date = eff_date;
	//alert("eff_from_date:"+eff_from_date);
	var patientId = document.getElementById("patid").value;
	//alert("patientId:"+patientId);
	var packageEpisodeType = document.getElementById("episode_type" + count).value;
	//alert("packageEpisodeType:"+packageEpisodeType);
	var payerGrpCodeTemp = document.getElementById("cust_group_code" + count).value;
	//alert("payerGrpCodeTemp:"+payerGrpCodeTemp);
	var payerCodeTemp = document.getElementById("cust_code" + count).value;
	//alert("payerCodeTemp:"+payerCodeTemp);
	var function_id = document.getElementById("function_id").value;
	//alert("function_id:"+function_id);
	var packageCode = pkg_code;
	//alert("packageCode:"+packageCode);
	var pkg_seq_no = package_seq_no;
	//alert("pkg_seq_no:"+pkg_seq_no);
	var blng_class_code = document.getElementById("hid_blng_class_code_" + count).value;

	var URL = "../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=across_encounter_check&packageCodeList="
			+ packageCode;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", URL, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);
	//alert("responseText:"+responseText);
	var acrossEncounterParameter = "N";
	if (responseText.indexOf("SUCCESS_ACROSS_ENCOUNTER") != -1) {
		acrossEncounterParameter = "Y";
	} else {
		acrossEncounterParameter = "N";
	}
	//var title="Associate Encounter";
	var title=getLabel("eBL.Associate_Encounter.label","BL");
	title=encodeURIComponent(title);
	var dialogUrl = "../../eBL/jsp/PkgSubscriptionAssociationDtls.jsp?patientId="
			+ patientId
			+ "&acrossEncounterParameter="
			+ acrossEncounterParameter
			+ "&packageCodeList="
			+ packageCode
			+ "&packageEpisodeTypes="
			+ packageEpisodeType
			+ "&packageBlngClassCode="
			+ blng_class_code
			+ "&payerCodeTemp="
			+ payerCodeTemp
			+ "&payerGrpCodeTemp="
			+ payerGrpCodeTemp
			+ "&package_seq_no="
			+ pkg_seq_no
			+ "&function_id="
			+ function_id
			+ "&eff_from_date=" + eff_from_date
			+ "&title="
			+ title;

	var dialogFeatures = "dialogHeight:" + "60vh" + "; dialogWidth:" + "65vw"
			+ " ; scroll=auto; ";
			//alert("dialogUrl:"+dialogUrl);
	var returnVal = await window.showModalDialog(dialogUrl, null, dialogFeatures);
	var dataArr = $.trim(returnVal).split('::');
	//alert("dataArr:"+dataArr);
	if (dataArr[0] == 1) {	
		document.getElementById("encAssString_" + count).value = dataArr[3];
		var encAssString = dataArr[3];
		if(encAssString != null){
			
			var arr = encAssString.split("~~");
			document.getElementById("encounterDt" + count).value = arr[7];  //V240131
			var effFromDate=eval(document.getElementById("eff_from_date"+count)).value;
			var encounterDate = eval(document.getElementById("encounterDt" + count)).value;
			effFromDate=effFromDate.substring(0,10);
			encounterDate=encounterDate.substring(0,10);
			var effFrmDate = effFromDate.split("/");
			var encDate = encounterDate.split("/");
			var startdt = new Date();
			var enddt = new Date();
			startdt.setFullYear(effFrmDate[2], effFrmDate[1]-1, effFrmDate[0]);//subs date
			enddt.setFullYear(encDate[2], encDate[1]-1, encDate[0]);//encounter date 
			//if(isBefore(effFromDate,encounterDate, "DMY" , 'en') && isAfter(encounterDate, effFromDate, 'DMY', 'en')){ 
			if(startdt<enddt){//subs date<enc
				alert(getMessage("BL0768","BLEXT"));
				ass_deass_chk.checked = false;
				document.getElementById("hid_enc_checkbox_dtl" + count).value = "N";
				document.getElementById("encAssString_" + count).value = "";	
			}
				
		}
	} else {
		ass_deass_chk.checked = false;
		document.getElementById("hid_enc_checkbox_dtl" + count).value = "N";
		document.getElementById("encAssString_" + count).value = "";		
	}
	
	/* 
	if (dataArr[0] == 1) {	
		alert(getMessage("BL0942", "BLEXT"));
		
		$.ajax({
				type : "POST",
				url : "../../servlet/eBL.PkgSubscriptionServlet?site_spec=true&function_id=EBL_TRAN_PACKAGE_MAINTAIN&patientId="+patientId,
				date : "",
				dataType : "text",
				async : false,
				success : function(data) {

				alert("Operation Completed Sucessfully...");
				parent.BLMaintaintreatmentPackage.location.href = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
						+ patientId + "&function_id=" + function_id;

				},
				error : function(data) {
				}
			});
	}
	*/
}

function focusELement(){
	document.getElementById("patient_id").focus();
}

async function primaryPatValidation(obj, params) {
	var vparams = params
	var patient_id = obj;
	
//	var patient_id = obj.value;

	if (patient_id != "") {
		var patIfAnyJobRunningYN =await chkPatIfAnyJobRunning(patient_id);
		
		var arrStr = patIfAnyJobRunningYN.split("~~");
		
		if (arrStr[0] == "O" || arrStr[0] == "I") { // I - Inprogress, O - Open
			alert("Recalculation is in progress, please load patient after sometime");
			//obj.value = '';
			patient_id='';//V230106
			//obj.select();
			document.forms[0].patient_id.select();//V230106
			parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/html/blank.html";
			parent.BLMaintaintreatmentPackage.location.replace("../../eCommon/html/blank.html");
			parent.BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");				
		}
		else if(arrStr[0] == "F") { // F - Failed
			alert("Recalculation failed for one or more package(s), cannot load the patient");
			//obj.value = '';
			patient_id='';//V230106
			//obj.select();
			document.forms[0].patient_id.select();//V230106
			parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/html/blank.html";
			parent.BLMaintaintreatmentPackage.location.replace("../../eCommon/html/blank.html");
			parent.BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");
		}
		else { // C - Completed and hence can continue to load the patient
			var function_id = "PAT_CHK";
			var xmlStr = "<root><SEARCH ";
			xmlStr += "patient_id=\"" + patient_id + "\" ";
			xmlStr += " /></root>";
			var temp_jsp = "PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="
					+ function_id;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send(xmlDoc);
			var responseText = trimString(xmlHttp.responseText);
		
			if (responseText == "N") {
				alert(getMessage("INVALID_PATIENT", "MP"));
				//obj.select();
				document.forms[0].patient_id.select();//V230106
				parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/html/blank.html";
				parent.BLMaintaintreatmentPackage.location.replace("../../eCommon/html/blank.html");
				parent.BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");
			} else if (responseText == "Y") { 
				await displayPline(patient_id);
				parent.BLMaintaintreatmentPackage.location.replace("../../eBL/jsp/MainTreatmentPackage.jsp?patid=" + patient_id + "&vparams=" + vparams);
				parent.BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");
				//var val=parent.parent.parent.BLMaintaintreatmentPackage.document.getElementById("pkgDetailsCombinationString").value;
			/*	alert("val");
				parent.BLMaintaintreatmentPackageserv.location.replace = "../../eBL/jsp/MainTreatmentpkgserv.jsp?patid="
					+ patient_id + "&vparams=" + vparams; */
			}
		}
	}else{
		parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/html/blank.html";
		parent.BLMaintaintreatmentPackage.location.href = "../../eCommon/html/blank.html";
		parent.BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");
	}
	
/*	parent.BLMaintaintreatmentPackage.location.replace = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
			+ patient_id + "&vparams=" + vparams;  */
}

async function PatientIdLookup() {
	var pat_id = await PatientSearch();
	if (pat_id != null)
		document.getElementById('patient_id').value = pat_id;
	if (pat_id != undefined && pat_id != '') {
		document.getElementById('patientId').value = pat_id;
		displayPline(pat_id);
	//	parent.BLMaintaintreatmentPackage.location.replace = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
		//		+ pat_id;
	}
}

async function Prac_lkup(val,code) {
	var sql="select SHORT_NAME description,PRACTITIONER_ID code from am_practitioner where upper(PRACTITIONER_ID) like"+
	" upper(?) and upper(SHORT_NAME) like upper(?) order by 1";
	
		var title									= 	"Practitioner";
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		//var prac_name								=	document.getElementById('prac_name'); 
	    //var prac_code								=	document.getElementById('prac_code'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	val.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
		retVal 										= await   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			var str =unescape(retVal);
			var arr = str.split(",");
			val.value 						= 	arr[1];
			code.value 						= 	arr[0];
		}
		else
		{
			val.value 						=	"";
			code.value 						=	"";
		}
	//	document.getElementById("hdrModified").value='Y';
		//hdrModified='Y';
}


async function openDiscDetails() {

	var dialogUrl = "../../eBL/jsp/PkgAdhocDiscountMain.jsp?menu_id=EBL_DFLT&module_id=BL&function_id=EBL_PACKAGE_ADHOC_DISCOUNT&function_name=PackageAdhocDiscount&function_type=F&access=NYNNN";

	var dialogFeatures = "dialogHeight:" + "95vh" + "; dialogWidth:" + "95vw"
			+ " ; scroll=auto; ";
	var returnVal = await top.window.showModalDialog(dialogUrl, null, dialogFeatures);

}

function onSuccess(){//V230106
	var calledFrom="";
	if(parent.frames[0].frames[1]!=undefined){
		calledFrom=parent.frames[0].frames[1].document.forms[0].calledFrom.value;
	}
	patientID = parent.frames[2].frames[3].document.forms[0].patid.value;
	
	var callRecalculationJob = recalcPkgJobCall(patientID); // will uncomment this call when the full functionality is implemented
	if(calledFrom=='managePatientPopup'){
		parent.window.returnValue="Y";
		alert("Operation Completed Successfully...");
		parent.window.close();
	}else{
		BLMaintaintreatmentPackagepat.location.href = "../../eBL/jsp/MainTreatmentPackageHdr.jsp?patid="+ patientID +"&mode=reloaded&calledFrom="+calledFrom;
		BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/jsp/pline.jsp?Patient_ID="
				+ patientID+"&calledFrom="+calledFrom;
		
		
		setTimeout(function(){  
			BLMaintaintreatmentPackage.location.replace("../../eBL/jsp/MainTreatmentPackage.jsp?patid="+ patientID +"&calledFrom="+calledFrom);
		},3000);
		BLMaintaintreatmentPackageserv.location.replace("../../eCommon/html/blank.html");
	}
}

function applyhdr(){
	var frmObj1="";
	var frmObj="";
	var err_mess1="";
	var result1=true;
	var msgFrame="";
	var calledFrom="";
	if(parent.frames[0].frames[1]!=undefined){
		calledFrom=parent.frames[0].frames[1].document.forms[0].calledFrom.value;
	}
	if(calledFrom=='managePatientPopup'){
		frmObj1=parent.frames[0].frames[3].document.forms[0];
		frmObj=parent.frames[0].frames[3];
		msgFrame=parent.frames[0].frames[5];
	}else{
		frmObj1=parent.frames[2].BLMaintaintreatmentPackage.document.forms[0];
		frmObj=parent.frames[2].BLMaintaintreatmentPackage;
		msgFrame=parent.frames[2].messageFrame;
	}//V230106
	
	patientID1=frmObj1.patid.value;
	
	var totcount=frmObj1.totcount.value; 
	for(var i=1;i<=totcount;i++){
		var efffrmdate=eval("frmObj1.eff_from_date" + i).value;
		if(efffrmdate=="" || efffrmdate==null ){
			err_mess1+=getMessage("BL8504", "BL") + "\n";
		}
	}
	
	
	for(var i=1;i<=totcount;i++){
		var cancel_chk = eval("frmObj1.cancel_chk" + i);
		
		if(cancel_chk.checked){
			var cancel_resn = eval("frmObj1.cancel_resn" + i);

			if(cancel_resn.value == null || cancel_resn.value == "") {
				alert("Cancellation reason cannot be blank");
				cancel_resn.focus();
				return false;
			}
		}	
	}
	
	var cancelPackageCount = 0;
	for(var i=1;i<=totcount;i++){
		if(eval("frmObj1.cancel_chk" + i).checked)
			cancelPackageCount ++;
	}
	
	if(cancelPackageCount > 0){
		var performTrxYN = confirm("One or more Packages selected for cancellation, do you want to continue cancellation and recalculate");
		if(!performTrxYN){
			return false;
		}
	} else {
		alert(getMessage("BL0943","BLEXT")); //recalculation alert
	}
	
	if (frmObj1 != "" && frmObj1 != null && frmObj1 != undefined) {	
		var xmlString1 = formXMLStringMain1(frmObj1);	
		var updation1 = formValidation1(xmlString1);
		var error_msg,success_msg;
		var retVal;
		if (err_mess1 == "" && result1) {
			patientID = trimString(frmObj.document.getElementById('patid').value);
			frmObj1.target = 'messageFrame';
			frmObj1.method = 'post';
			frmObj1.action = "../../servlet/eBL.BLMaintainTrtHdrServlet";
			frmObj1.submit();		
			$.ajax({
			type:"POST",
			url:"../../servlet/eBL.BLMaintainTrtHdrServlet?patid="+patientID,
			async: false,
			success: function(data){
				
				retVal = trimString(data).split("::");
				
				
				if (retVal[0]==1)
					success_msg = retVal[1];
				else 
					error_msg=retVal[0];
				
				
				},
				error: function(data){	
				}
			});
			
			if(error_msg != '' && error_msg != undefined && error_msg != null ){
					msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ error_msg;
					return false;
				}
				else{
					msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ success_msg+"&err_value="+retVal[0];
					return true;
				}
		} else {
				msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess1;
				return false;
		}	
	}	
	//hdr ends 
}

async function apply() {
	var frmObj="";
	var err_mess="";
	var result=true;
	var msgFrame='';
	var calledFrom="";
	var frmObj1="";
	var pkgServLmtDtlsPrivYN="";
	if(parent.frames[0].frames[1]!=undefined){
		calledFrom=parent.frames[0].frames[1].document.forms[0].calledFrom.value;
	}
	if(calledFrom=='managePatientPopup'){
		pkgServLmtDtlsPrivYN = parent.frames[0].frames[3].document.getElementById("pkgServLmtDtlsPrivYN").value; 
		frmObj1=parent.frames[0].frames[3].document.forms[0];
		frmObj=parent.frames[0].frames[4].document.forms[0];
		msgFrame=parent.frames[0].frames[5];
	}else{
		pkgServLmtDtlsPrivYN = parent.frames[2].BLMaintaintreatmentPackage.document.getElementById("pkgServLmtDtlsPrivYN").value; 
		frmObj1=parent.frames[2].BLMaintaintreatmentPackage.document.forms[0];
		frmObj=BLMaintaintreatmentPackageserv.document.forms[0];
		msgFrame=parent.frames[2].messageFrame;
	}
	
	if((frmObj1.rowClicked.value == '-1')){
		err_mess+=getMessage("BL9802", "BL") + "\n";
	}else{		
	
		var saveHdr = await applyhdr();	//Function for hdr updation
		if(saveHdr) {
			if(pkgServLmtDtlsPrivYN == "Y"){
				var rwsel = frmObj1.rowClicked.value;
				var seldate=eval("frmObj1.eff_from_date" + rwsel).value;
				var servdate=eval("frmObj.defaultEffFromDate").value;
				if(servdate != undefined){
					frmObj.defaultEffFromDate.value=seldate;
				}
				patientID=frmObj.patientid1.value;
				var dbcnt=frmObj.dbcnt.value;	
				if (frmObj != "" && frmObj != null && frmObj != undefined) {	
					var xmlString = formXMLStringMain(frmObj);	
					var updation = formValidation(xmlString,dbcnt);		
					if (err_mess == "" && result) {	
						frmObj.target = 'messageFrame';
						frmObj.method = 'post';
						frmObj.action = "../../servlet/eBL.BLMaintainTrtServlet";
						frmObj.submit();
					} else {
						msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
					}	
				}
			//If no rows selected ELSE ends
				if(err_mess != ""){
					msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
				}
			} else {
				var patinetId_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('patid').value);
				patientID = patinetId_new;
			}
		} else {
				
		}
	}
	if(err_mess != ""){
		msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
	}
	/*
	var pkgServLmtDtlsPrivYN = parent.frames[2].BLMaintaintreatmentPackage.document.getElementById("pkgServLmtDtlsPrivYN").value; 
	var frmObj1=parent.frames[2].BLMaintaintreatmentPackage.document.forms[0];

	if((frmObj1.rowClicked.value == '-1')){
		err_mess+=getMessage("BL9802", "BL") + "\n";
	}else{		
	
		var saveHdr = applyhdr();	//Function for hdr updation

		if(saveHdr) {
			if(pkgServLmtDtlsPrivYN == "Y"){
	
				//frmObj = parent.frames[2].BLMaintaintreatmentPackage.document.forms[0];
				frmObj=BLMaintaintreatmentPackageserv.document.forms[0];
				var rwsel = frmObj1.rowClicked.value;
				var seldate=eval("frmObj1.eff_from_date" + rwsel).value;
				var servdate=eval("frmObj.defaultEffFromDate").value;
				if(servdate != undefined){
					frmObj.defaultEffFromDate.value=seldate;
					//alert('serv date-'+frmObj.defaultEffFromDate.value);
				}
				patientID=frmObj.patientid1.value;
				var dbcnt=frmObj.dbcnt.value;	
			//	alert(dbcnt);
				if (frmObj != "" && frmObj != null && frmObj != undefined) {	
			//alert("FormObj ==> "+	frmObj);
					var xmlString = formXMLStringMain(frmObj);	
					var updation = formValidation(xmlString,dbcnt);		
					if (err_mess == "" && result) {	
						frmObj.target = 'messageFrame';
						frmObj.method = 'post';
						frmObj.action = "../../servlet/eBL.BLMaintainTrtServlet";
						//alert("Detail Submit");
						frmObj.submit();
					} else {
							parent.frames[2].messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
						
					}	
				}
			//If no rows selected ELSE ends
				if(err_mess != ""){
					parent.frames[2].messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
				}
			} else {
				var patinetId_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('patid').value);
				patientID = patinetId_new;
			}
		} else {
			
				//parent.frames[2].messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
			
		}
	}
	if(err_mess != ""){
		parent.frames[2].messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
	}
	*/
}

String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}
/*
function datevalid(idx){
	//alert("idx--"+idx);
	var locale = $('#locale').val();
	var eff_from=document.getElementById("eff_from_date"+idx).value;
	var efftodate=document.getElementById("eff_to_date"+idx).value;
//	eff_from=new Date(eff_from);
//	efftodate=new Date(efftodate);
	//alert("eff_from--"+isBefore(eff_from,efftodate,'DMYHMS',locale));
		if(eff_from!="" && efftodate!="" ){
		//	if(eff_from > efftodate){
			if(!isBefore(eff_from,efftodate,'DMYHMS',locale)){
				alert(getMessage("BL8508", "BL"));
				document.getElementById("eff_from_date"+idx).value="";
				document.getElementById("eff_from_date"+idx).focus();
				return false;
			}
		}
}
*/

/*
function apply() {
	var frmObj="";
	var err_mess="";
	var result=true;

	frmObj = parent.frames[2].BLMaintaintreatmentPackage.document.forms[0];
	if (frmObj != "" && frmObj != null && frmObj != undefined) {		
		var xmlString = formXMLStringMain(frmObj);	
		var updation = formValidation(xmlString);		
		if (err_mess == "" && result) {	
			frmObj.target = 'messageFrame';
			frmObj.method = 'post';
			frmObj.action = "../../servlet/eBL.BLMaintainTrtServlet";
			frmObj.submit();
		} else {
				parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='+ err_mess;
		}	
	}
}
*/
function formValidation(xmlStr,count) 
{
	var count="";
//	alert(xmlStr);
	var temp_jsp = "../../eBL/jsp/MaintainTreatValidation.jsp";

		$.ajax({
			type: 'POST',
			url: temp_jsp,
			data : { xmlStr: xmlStr,count: count},
			success: function(result) {
				eval(result);
                  },
			async:   false
			});
}

function formXMLStringMain(frmObj) {
	submitParamsMain	= "";
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
	var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";					
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";				
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			}
		}
	}
		xmlStr += " /></root>";
	}

	return xmlStr;
}


function formValidation1(xmlStr1) 
{
	var count="";
//	alert(xmlStr);
	var temp_jsp = "../../eBL/jsp/MaintainTreatHdrValidation.jsp";

		$.ajax({
			type: 'POST',
			url: temp_jsp,
			data : { xmlStr: xmlStr1},
			success: function(result1) {
				eval(result1);
                  },
			async:   false
			});
}

function formXMLStringMain1(frmObj1) {
	submitParamsMain	= "";
	if (frmObj1 != null && frmObj1 != "undefined" && frmObj1.length > 0) {
	var xmlStr1 = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj1.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";					
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";				
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			}
		}
	}
		xmlStr1 += " /></root>";
	}
	return xmlStr1;
}


function highlightRow(obj,qryClass){
	var frm =  document.frmMaintainTreat;
	//var rowClicked = frm.rowClicked.value;
	var rowClicked =document.getElementById("rowClicked").value;
//	alert(obj);
//	alert(rowClicked);
	if(rowClicked != obj){
		
		if(rowClicked.length>0){
			$('#row'+rowClicked+' td' ).each(function(){
				$(this).attr('class','fields');
			});	
			
			$('#row'+rowClicked+' td span' ).each(function(){
				$(this).attr('class','fields');
			});	
		}	
		
		$('#row'+obj+' td' ).each(function(){
			$(this).attr('class','LocalYellow');			
		});
		
		$('#row'+obj+' td span' ).each(function(){
			$(this).attr('class','SpanYellow');
		});		
		
	
	}	
	//frm.rowClicked.value = obj;
	document.getElementById("rowClicked").value=obj;
}
/*
//code for highlight in serv lvl 
function highlightRow1(obj,qryClass){
	var frm =  document.frmMaintainTreat;
	//var rowClicked = frm.rowClicked.value;
	var rowClicked =document.getElementById("rowClicked1").value;
//	alert("highlightRow1 "+obj);
//	alert(rowClicked.length);
	if(rowClicked != obj){
		
		if(rowClicked.length>0){
			$('#row1'+rowClicked+' td' ).each(function(){
				$(this).attr('class','fields');
			});	
			
			$('#row1'+rowClicked+' td span' ).each(function(){
				$(this).attr('class','fields');
			});	
		}	
		
		$('#row1'+obj+' td' ).each(function(){
			$(this).attr('class','LocalYellow');			
		});
		
		$('#row1'+obj+' td span' ).each(function(){
			$(this).attr('class','SpanYellow');
		});		
		
		
	}	
	//frm.rowClicked.value = obj;
	document.getElementById("rowClicked1").value=obj;
}
*/

async function closeEncDetails(chk, count, pkg_code, package_seq_no, eff_date,
		operating_facility_id, pat_id) {
	var function_id = document.getElementById('function_id').value;
	var ws_no = document.getElementById('ws_no').value;
	var user = document.getElementById('userid').value;
	var privilege_code = "MODIFY_ASSOC_DEASSOC_MTPKG";
	if (chk == 'Y') {
		if(document.getElementById("hid_enc_deass_chkb_" + count).value == "Y" && document.getElementById("enc_checkbox_dtl" + count).checked) {
			alert("Record already marked for De-Associate, cannot associate encounter now");
			document.getElementById("enc_checkbox_dtl" + count).checked = false;
			return false;
		}
		
		var msg = confirm("Do you want to De-Associate the Package and Recalculate");
		if (msg == true) {
			var assDeassEncPrivYN = document.getElementById('assDeassEncPrivYN').value;
			if(assDeassEncPrivYN == "Y") {
			
				document.getElementById("hid_enc_deass_chkb_" + count).value = "Y";
				
				/* 
				var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=PackageDeAssociate&operating_facility_id="
					+ operating_facility_id
					+ "&pkg_code="
					+ pkg_code
					+ "&package_seq_no="
					+ package_seq_no
					+ "&eff_date="
					+ eff_date
					+ "&pat_id="
					+ pat_id
					+ "&function_id="
					+ function_id + "&ws_no=" + ws_no + "&user=" + user;

				var xmlHttp = new XMLHttpRequest();
				xmlHttp.open("POST", temp_jsp, false);
				xmlHttp.send();
				var responseText = trimString(xmlHttp.responseText);

				if (responseText != "") {
				
				} else {
					alert("Operation Completed Successfully...");
					parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
						+ "APP-SM0070 Operation Completed Successfully ...."
						+ "&err_value=Error";
					parent.BLMaintaintreatmentPackage.location.replace = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
						+ pat_id;
				}
				*/
			} else {
				var retVal =await authPkgAccessForUser(privilege_code);
				
				if(retVal=="Y"){
					document.getElementById("hid_enc_deass_chkb_" + count).value = "Y";
					document.getElementById('assDeassEncPrivYN').value = "Y";
				} else {
					document.getElementById("enc_checkbox_dtl" + count).checked = true;
					document.getElementById("hid_enc_deass_chkb_" + count).value = "N";
					document.getElementById('assDeassEncPrivYN').value = "N";
					alert("User do not have the privileges");
					return false;
				}
			}	
		} else {
			document.getElementById("enc_checkbox_dtl" + count).checked = true;
			document.getElementById("hid_enc_deass_chkb_" + count).value = "N";
		}
	}
}
/*
function showPackageServiceDetails1(index){
	var frm =  document.frmMaintainTreat;
	var patinetId_new = trimString(document.getElementById('patid').value);
	var pkgDes=trimString(document.getElementById('pkg_short_desc'
			+ index).value);
	alert(pkgDes);
	document.getElementById('Package_Description').value=pkgDes;
	var val=document.getElementById('Package_Description').value;
	//frm.Package_Description.value=pkgDes;
	alert(val);
}
*/

function showPackageServiceDesc(index,servDes){
	//alert("servDes"+servDes);
	document.getElementById('pkg_service_long_desc').value=servDes;
	//alert(document.getElementById('pkg_service_long_desc').value);
}

//function showPackageServiceDetails(index,pkgDes,service_desc) {
function showPackageServiceDetails(index,pkgDes) {

	var functionid = document.getElementById('function_id').value;
	var order_catalog_yn = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('order_catalog_yn'+index).value);
	var enc_assoc_yn = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('enc_assoc_yn'+index).value);
	var across_enc_yn = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('across_enc_assoc_yn'+index).value);
	var patinetId_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('patid').value);
	var visit_id = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('visit_id'+index).value);
	var episode_id = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('episode_id'+index).value);
	var episode_type = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('episode_type'+index).value);
	//	alert(document.getElementById('package_code'+index).value);
	var package_code_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('package_code' + index).textContent);
	var package_seq_no_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('package_seq_no' + index).textContent);
	var operating_facility_id_new = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('operating_facility_id' + index).value);
	var pkgDetailsCombinationString =parent.BLMaintaintreatmentPackage.document.getElementById('pkgDetailsCombinationString1' + index).value;
	parent.BLMaintaintreatmentPackage.document.getElementById('Package_Description').value=pkgDes;
	var eff_from_date = trimString(parent.BLMaintaintreatmentPackage.document.getElementById('eff_from_date' + index).value);
	var pkgServLmtDtlsPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById("pkgServLmtDtlsPrivYN").value;
	var pkgServDtlsAuthStr = parent.BLMaintaintreatmentPackage.document.getElementById("pkgServDtlsAuthStr").value;
	
	if (functionid == "EBL_TRAN_PACKAGE_MAINTAIN") {
		parent.BLMaintaintreatmentPackageserv.location.href =  "../../eBL/jsp/MainTreatmentpkgserv.jsp?calledfrom=UPDATE&patinetId_new="
				+ patinetId_new +"&pkgDetailsCombinationString=" + pkgDetailsCombinationString+ "&package_code_new="
				+ package_code_new
				+ "&package_seq_no_new="
				+ package_seq_no_new+ "&operating_facility_id_new="
				+ operating_facility_id_new+"&order_catalog_yn="+order_catalog_yn+ "&episode_id="
				+ episode_id
				+ "&visit_id="
				+ visit_id
				+ "&episode_type=" + episode_type+"&enc_assoc_yn=" + enc_assoc_yn +"&across_enc_yn=" + across_enc_yn +"&eff_from_date="+eff_from_date+"&selectedItemIndex="+index
				+"&pkgServLmtDtlsPrivYN="+pkgServLmtDtlsPrivYN+"&pkgServDtlsAuthStr="+encodeURIComponent(pkgServDtlsAuthStr); 
				/* "calledfrom=UPDATE&patinetId_new="
				+ patinetId_new
				+ "&package_code_new="
				+ package_code_new
				+ "&package_seq_no_new="
				+ package_seq_no_new
				+ "&operating_facility_id_new="
				+ operating_facility_id_new
				+ "&patid=" + patinetId_new + "&function_id=" + functionid  + "&pkgDetailsCombinationString=" + pkgDetailsCombinationString; */
		//alert(document.getElementById('Package_Description').value);
	}		
}


async function funReasonId(count)
{
	var cancel_chk = document.getElementById("cancel_chk" + count).checked;
	if(!cancel_chk)
		return false;
	
	var dialogTop			= "10";
	var dialogHeight		= "55vh" ;
	var dialogWidth			= "60vw" ;
	var features			= "dialogTop:" + dialogTop + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ListOfRemarks.label","BL");  //CHANGED ON V200113 eBL.ListOfRemarks.label
	title=encodeURIComponent(title);
	var column_sizes = escape("70%,30%");               
	var remarks=getLabel("eBL.Remarks.label","common"); //CHANGED ON V200113
	cashcntrcode=encodeURIComponent(remarks);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var column_descriptions = desc+","+remarks;
	var locale = document.getElementById('locale').value;
	var sql = "" ; //escape("SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = 'CP' AND active_yn = 'Y' AND UPPER(language_id)='EN'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"&srch_by_clmn_index=2"+"&col_show_hide=YY"+"&called_for=CANCEL_PACKAGE_REASON_LKUP&locale="+locale+"&target="+document.getElementById("cancel_resn" + count).value;
	
	retVal= await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
		
	if (retVal != null || retVal!='')
	{	
		var retVal=  unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.getElementById("cancel_resn" + count).value=arr[0];
			document.getElementById("cancel_code" + count).value=arr[1];			
		} else {
			alert("Please select the cancel reason");
			document.getElementById("cancel_resn" + count).focus();	
		}
			
	} else {
		alert("Please select the cancel reason");
		document.getElementById("cancel_resn" + count).focus();		
	}
}

function funcancelpakg(count)
{	
	var cancel_chk = document.getElementById("cancel_chk" + count).checked;
	if(cancel_chk==true)
	{
	var cancel_resn = document.getElementById("cancel_resn" + count).value;
	var package_code = document.getElementById("package_code" + count).value;
	if(cancel_resn == '' || cancel_resn == undefined || cancel_resn == 'undefined' || cancel_resn == null || cancel_resn == 'null' )	
	{
		alert("Please select reason for cancellation");
		document.getElementById("cancel_chk" + count).checked=false;
	}
	else
	{
		var function_id = document.getElementById('function_id').value;
		var facility_id = document.getElementById('facility_id').value;
		var privlege_code = document.getElementById('privlege_code').value;
		var patientid = document.getElementById('patientid1').value;
		var package_code = document.getElementById("package_code" + count).value;
		var package_seq_no = document.getElementById("package_seq_no" + count).value;
		var cancel_code = document.getElementById("cancel_code" + count).value;
		var local = document.getElementById('locale').value;
		var user = document.getElementById('userid').value;
		var ws_no = document.getElementById('ws_no').value;
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=CommonAuthforMaintainTreatment&function_id="
						+ function_id
						+ "&privlege_code="
						+ privlege_code
						+ "&user="
						+ user
						+ "&facility_id="
						+ facility_id;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
				
		if (responseText == 'Y') {				
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=PkgCancelforMaintainTreatment&function_id="
			+ function_id
			+ "&privlege_code="
			+ privlege_code
			+ "&user="
			+ user
			+ "&facility_id="
			+ facility_id
			+ "&patientid="
			+ patientid
			+ "&package_code="
			+ package_code
			+ "&package_seq_no="
			+ package_seq_no
			+ "&cancel_code="
			+ cancel_code
			+ "&local="
			+ local
			+ "&ws_no="
			+ ws_no;
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send();
			var responseText = trimString(xmlHttp.responseText);
			if(responseText !='')
			{
					
			}
			else
				{
				alert("Operation Completed sucessfully...");
						
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
					+ "APP-SM0070 Operation Completed Successfully ...."
				parent.BLMaintaintreatmentPackage.location.href = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
						+ patientid + "&function_id=" + function_id;
				}						
				} else {
					alert("User don?t have the privileges");
					document.getElementById("cancel_chk" + count).checked=false;
				}
			} 
		}
}		

async function displayAdhocDiscountDtls(patientId,packageCode,packageSeqNo,packagelongDesc,packageAmount,episode_type,episode_id,visit_id, custGroupCode, custCode,function_id, index) //Added V171219-Gayathri/65499
{				
	var copayValidYN = "";
	var delimAdhocDiscStr = parent.BLMaintaintreatmentPackage.document.getElementById('delimAdhocDiscStr_'+index).value;
	var isAdhocDiscountMod = parent.BLMaintaintreatmentPackage.document.getElementById('isAdhocDiscountMod_'+index).value;
	var adhocDiscPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscPrivYN').value;
	var privlege_code = "ALLOW_ADHOC_DISC_ENTRY_MTPKG";
	
	if(episode_id == null || episode_id == "" || episode_id == "null") {
			alert("Adhoc Discount not applicable for Packages without Encounter Associated");
			return false;
	}	
	
	if(adhocDiscPrivYN == "N"){
		var retVal = await authPkgAccessForUser(privlege_code);
		
		if(retVal == "Y"){
			parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscPrivYN').value = "Y";
			adhocDiscPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscPrivYN').value;
		} else {
			alert("User do not have the privileges");
			return false;			
		}
	}
	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patientId=\"" + patientId + "\" " ;					
	xmlStr +=" /></root>";
	var temp_jsp="PkgAdhocDiscountValidation.jsp?func_mode=copay_disc_valid_yn" +
		"&packageSeqNo="+packageSeqNo+
		"&packageCode="+packageCode+
		"&episode_type="+episode_type+
		"&episode_id="+episode_id+
		"&visit_id="+visit_id+
		"&custGroupCode="+custGroupCode+
		"&custCode="+custCode;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	copayValidYN=trimString(xmlHttp.responseText);
	if(copayValidYN==null || copayValidYN=='null')
		copayValidYN='';
	if(copayValidYN == "Y") {
		alert(getMessage("BL0046","BL"));
		return false;
	} else {		
	adhocParams="&menu_id=EBL_DFLT&module_id=BL&function_id=EBL_TRAN_PACKAGE_MAINTAIN&function_name=ManagePatientPackages&function_type=F&access=YYYYY&patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc)+"&packageAmount="+packageAmount+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&function_id="+function_id+"&adhocDiscPrivYN="+adhocDiscPrivYN;

		var dialogUrl = "../../eBL/jsp/MaintainTreatmentAdhocDis.jsp?&menu_id=EBL_DFLT&module_id=BL&function_id=EBL_TRAN_PACKAGE_MAINTAIN&function_name=ManagePatientPackages&function_type=F&access=YYYYY&patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc)+"&packageAmount="+packageAmount+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&function_id="+function_id+"&adhocDiscPrivYN="+adhocDiscPrivYN+"&isAdhocDiscountMod="+isAdhocDiscountMod+"&delimAdhocDiscStr="+delimAdhocDiscStr;
		//alert(dialogUrl);

		var dialogFeatures = "dialogHeight:" + "58vh" + "; dialogWidth:" + "90vw"
				+ " ; scroll=auto; ";
		var returnVal = await top.window.showModalDialog(dialogUrl, null, dialogFeatures);
		returnVal = returnVal.split("^");
		if(returnVal[0] == "Y"){
			//parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscPrivYN').value = returnVal[1];
			parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscDisp_'+index).innerHTML = returnVal[2];
			parent.BLMaintaintreatmentPackage.document.getElementById('delimAdhocDiscStr_'+index).value = returnVal[3];
			parent.BLMaintaintreatmentPackage.document.getElementById('isAdhocDiscountMod_'+index).value = "Y";			
		}
		
	}
}

async function displayUtilizationDtls(patientId,packageCode,packageSeqNo,packagelongDesc) 
{
	var dialogUrl = "../../eBL/jsp/MainTrtPkgUtilizationDetailsMain.jsp?&menu_id=EBL_DFLT&module_id=BL&function_id=EBL_TRAN_PACKAGE_MAINTAIN&function_name=ManagePatientPackages&function_type=F&access=YYYYY&patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc);
	var dialogFeatures = "dialogHeight:" + "90vh" + "; dialogWidth:" + "90vw"
				+ " ; scroll=auto; ";
	var returnVal = await window.showModalDialog(dialogUrl, null, dialogFeatures);
}

function resetDisc(){
		parent.frames[0].parent.frames[2].document.location.href='../../eBL/jsp/ManiTrtPkgPkgAdhocDiscountDetails.jsp';
	}
		
function saveOnChange()
{  
	var frmObj = "";	
	if(parent.PkgAdhocDiscountDtlsFrame == undefined)
	{
		if(PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame !=undefined)
		frmObj = PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0];
	}
	else{
		frmObj = parent.PkgAdhocDiscountDtlsFrame.document.forms[0];
	}
	if(frmObj!=null && frmObj!="" && frmObj!=undefined)
	{
		var xmlString=formXMLString(frmObj);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc.loadXML(xmlString);
		xmlHttp.open("POST","PkgAdhocDiscountValidation.jsp?func_mode=SAVE_VALUES",false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText ;
		eval(responseText);
		return true;
	}
}

function DeletePkgServiceDetails()
{		
	var cancel_chk = document.getElementById("Delete").checked;
	if(cancel_chk==true)
	{
		var cancel_resn = document.getElementById("cancel_resn" + count).value;
		var package_code = document.getElementById("package_code" + count).value;
		if(cancel_resn == '' || cancel_resn == undefined || cancel_resn == 'undefined' || cancel_resn == null || cancel_resn == 'null' )	
		{
			alert("Please select reason for cancellation");
			document.getElementById("cancel_chk" + count).checked=false;
		}
		else
		{
			var function_id = document.getElementById('function_id').value;
			var facility_id = document.getElementById('facility_id').value;
			var user = document.getElementById('userid').value;
			var privlege_code = 'MODIFY_PKG_SERV_LMT_DTLS_MTPKG';
			var user = document.getElementById('userid').value;
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=CommonAuthforMaintainTreatment&function_id="
						+ function_id
						+ "&privlege_code="
						+ privlege_code
						+ "&user="
						+ user
						+ "&facility_id="
						+ facility_id;
				var xmlHttp = new XMLHttpRequest();
				xmlHttp.open("POST", temp_jsp, false);
				xmlHttp.send();
				var responseText = trimString(xmlHttp.responseText);
				
				if (responseText == 'Y') {				
					var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=PkgCancelforMaintainTreatment&function_id="
					+ function_id
					+ "&privlege_code="
					+ privlege_code
					+ "&user="
					+ user
					+ "&facility_id="
					+ facility_id
					+ "&patientid="
					+ patientid
					+ "&package_code="
					+ package_code
					+ "&package_seq_no="
					+ package_seq_no
					+ "&cancel_code="
					+ cancel_code
					+ "&local="
					+ local
					+ "&ws_no="
					+ ws_no;
					var xmlHttp = new XMLHttpRequest();
					xmlHttp.open("POST", temp_jsp, false);
					xmlHttp.send();
					var responseText = trimString(xmlHttp.responseText);
					if(responseText =='Y')
					{
						var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=DeleteServiceDetailMTP&function_id="
						+ function_id
						+ "&privlege_code="
						+ privlege_code
						+ "&user="
						+ user
						+ "&facility_id="
						+ facility_id
						+ "&patientid="
						+ patientid
						+ "&package_code="
						+ package_code
						+ "&package_seq_no="
						+ package_seq_no
						+ "&cancel_code="
						+ cancel_code
						+ "&local="
						+ local
						+ "&ws_no="
						+ ws_no;
						var xmlHttp = new XMLHttpRequest();
						xmlHttp.open("POST", temp_jsp, false);
						xmlHttp.send();
						var responseText = trimString(xmlHttp.responseText);
					}else{
							alert("Operation Completed sucessfully...");					
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
								+ "APP-SM0070 Operation Completed Successfully ...."
							parent.BLMaintaintreatmentPackage.location.href = "../../eBL/jsp/MainTreatmentPackage.jsp?patid="
									+ patientid + "&function_id=" + function_id;
						}						
				} else {
						alert("User don?t have the privileges");
						document.getElementById("cancel_chk" + count).checked=false;
					}
			} 
		}
}

function reset()
{
	top.content.document.location.reload();
	//BLMaintaintreatmentPackageframeset.document.location.reload();
	
}

function resetPage(){
		//window.location.reload();
		parent.PkgAdhocDiscountDetails.location.href="../../eBL/jsp/ManiTrtPkgPkgAdhocDiscountDetails.jsp";
	}
	
function validatefactorlmt(rateind,val,index,called){

	if(rateind.value=='R'){
		if(called=="1"){
			if(val.value==''){
				alert(getMessage("BL8536", "BL"));
				document.getElementById("factor_rate"+index).onblur = null;
				document.getElementById("factor_rate"+index).focus();
				setTimeout(function() {
					document.getElementById("factor_rate" + index).onblur = function() {
						validatefactorlmt(eval("document.forms[0].rate_charge_ind" + index), this, index, 1);
					};
				}, 500);
				return false;
			}
		}
		else if(called=="2"){
			var facRate=document.getElementById("factor_rate"+index).value;
			//alert("facRate "+facRate);
			if(facRate==''){
				alert(getMessage("BL8536", "BL"));
				document.getElementById("factor_rate"+index).onblur = null;
				document.getElementById("factor_rate"+index).focus();
				setTimeout(function() {
					document.getElementById("factor_rate" + index).onblur = function() {
						validatefactorlmt(eval("document.forms[0].rate_charge_ind" + index), this, index, 1);
					};
				}, 500);
				return false;
			}else if(val.value==''){
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind    A P U ""
				var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
			//	alert(amt_limit_ind);
				if(amt_limit_ind=='A'){
					if(amt_limit==""){
						alert(getMessage("BL8541", "BL"));
						document.getElementById("amt_limit"+index).focus();
						return false;
					}
				}else if(amt_limit_ind=='P'){
					if(amt_limit==""){
						alert(getMessage("BL8541", "BL"));
						document.getElementById("amt_limit"+index).focus();
						return false;
					}else if(amt_limit<0 || amt_limit>100){ 
						alert(getMessage("BL8539", "BL"));
						document.getElementById("amt_limit"+index).value="";
						document.getElementById("amt_limit"+index).focus();
						return false;
					}
				}else if(amt_limit_ind=='U'){
					document.getElementById("qty_limit"+index).value="";
					document.getElementById("amt_limit"+index).value="";
					return false;
					//document.getElementById("amt_limit"+index).focus();
				}
				else if(amt_limit_ind==''){
					alert(getMessage("BL8541", "BL"));
					return false;
				}
				
			}
			else if(val.value!=''){
				return false;
			}
		}else if(called=="3"){ //amtlmtind 
			var facRate=document.getElementById("factor_rate"+index).value;
		//	alert("facRate "+facRate);
			if(facRate==''){
				alert(getMessage("BL8536", "BL"));
				document.getElementById("factor_rate"+index).onblur = null;
				document.getElementById("factor_rate"+index).focus();
				setTimeout(function() {
					document.getElementById("factor_rate" + index).onblur = function() {
						validatefactorlmt(eval("document.forms[0].rate_charge_ind" + index), this, index, 1);
					};
				}, 500);
				return false;
			}else if(val.value==''){
				var qty_limit=document.getElementById("qty_limit"+index).value;
				if(qty_limit==''){
					alert(getMessage("BL8541", "BL"));
					return false;
				}
			}else if(val.value!=''){
				
				var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind    A P U ""
				var qty_limit=document.getElementById("qty_limit"+index).value;
				if(amt_limit_ind!='U' && qty_limit=='' && amt_limit==''){
						alert(getMessage("BL8541", "BL"));
						return false;
				}
				if(amt_limit_ind=='U'){
					document.getElementById("qty_limit"+index).value="";
					document.getElementById("amt_limit"+index).value="";
					return false;
					//document.getElementById("amt_limit"+index).focus();
				}
				if(amt_limit_ind=='P'){
					if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
				}
			}
				//var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind    A P U ""
		/*		var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
				if(val.value=='A'){
					if(amt_limit==""){
						alert(getMessage("BL8541", "BL"));
						document.getElementById("amt_limit"+index).focus();
						return false;
					}
				}else if(val.value=='P'){
					if(amt_limit==""){
						alert(getMessage("BL8541", "BL"));
						document.getElementById("amt_limit"+index).focus();
						return false;
					}else if(amt_limit<0 || amt_limit>100){ 
						alert(getMessage("BL8539", "BL"));
						document.getElementById("amt_limit"+index).value="";
						document.getElementById("amt_limit"+index).focus();
						return false;
					}
				}else if(val.value=='U'){
					document.getElementById("qty_limit"+index).value="";
					document.getElementById("amt_limit"+index).value="";
					return false;
					//document.getElementById("amt_limit"+index).focus();
				}
			}
			}else if(called=="4"){
				var facRate=document.getElementById("factor_rate"+index).value;
			//	alert("facRate "+facRate);
				if(facRate==''){
					alert(getMessage("BL8536", "BL"));
					document.getElementById("factor_rate"+index).focus();
					return false;
				}
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind
				var qtylmt= document.getElementById("qty_limit"+index).value;
				if(amt_limit_ind!=''){
					var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
					if(amt_limit_ind=='A'){
						if(amt_limit=="" && qtylmt ==""){
							alert(getMessage("BL8541", "BL"));
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind=='P'){
						if(amt_limit=="" && qtylmt==""){
							alert(getMessage("BL8541", "BL"));
							document.getElementById("amt_limit"+index).focus();
							return false;
						}else if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind=='U'){
						document.getElementById("qty_limit"+index).value="";
						document.getElementById("amt_limit"+index).value="";
						return false;
						//document.getElementById("amt_limit"+index).focus();
					}
				}else{
					if(qtylmt==""){
					alert(getMessage("BL8541", "BL"));
					//document.getElementById("amt_limit"+index).focus();
					return false;
					}
				}
			/*	if(val.value==''){
					alert(getMessage("BL8541", "BL"));
					document.getElementById("amt_limit"+index).focus();
					return false;
				} */
			}
			else if(called=="4"){ //amtlmt 
				var facRate=document.getElementById("factor_rate"+index).value;
		//		alert("facRate "+facRate);
				if(facRate==''){
					alert(getMessage("BL8536", "BL"));
					document.getElementById("factor_rate"+index).onblur = null;
					document.getElementById("factor_rate"+index).focus();
					setTimeout(function() {
						document.getElementById("factor_rate" + index).onblur = function() {
							validatefactorlmt(eval("document.forms[0].rate_charge_ind" + index), this, index, 1);
						};
					}, 500);
					return false;
				}
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind
				var qtylmt= document.getElementById("qty_limit"+index).value;
				var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
			
				if(amt_limit_ind!='U' && qtylmt=='' && amt_limit==''){
					alert(getMessage("BL8541", "BL"));
					document.getElementById("qty_limit"+index).focus();
					return false;
				}
			}
	}
	else if(rateind.value=='C'){
		if(called=="4"){
		var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind
		if(amt_limit_ind!=''){
			var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
			if(amt_limit_ind=='A'){
				if(amt_limit==""){
					alert(getMessage("BL8541", "BL"));
					document.getElementById("amt_limit"+index).focus();
					return false;
				}
			}else if(amt_limit_ind=='P'){
				if(amt_limit==""){
					alert(getMessage("BL8541", "BL"));
					document.getElementById("amt_limit"+index).focus();
					return false;
				}else if(amt_limit<0 || amt_limit>100){ 
					alert(getMessage("BL8539", "BL"));
					document.getElementById("amt_limit"+index).value="";
					document.getElementById("amt_limit"+index).focus();
					return false;
				}
			}else if(amt_limit_ind=='U'){
				document.getElementById("amt_limit"+index).value="";
				return false;
				//document.getElementById("amt_limit"+index).focus();
			}
		}else{
			alert(getMessage("BL8541", "BL"));
			//document.getElementById("amt_limit"+index).focus();
			return false;
		}
		}
	}
}

function validateGrpservInd(val,indx){ 	
	var pkgLmtIndBy=document.getElementById("PKG_LIMIT_IND_BY").value;
	if(val.value=='S'){
		if(pkgLmtIndBy=='G'){
			alert(getMessage("BL0854", "BL"));
			document.getElementById("GrpsSrvind"+indx).value="B";
			//document.getElementById("amt_limit"+index).focus();
			return false;
		}
	}else if(val.value=='G'){
		if(pkgLmtIndBy=='S'){
			alert(getMessage("BL0853", "BL"));
			document.getElementById("GrpsSrvind"+indx).value="B";
			//document.getElementById("amt_limit"+index).focus();
			return false;
		}
	}
	
}

function onIndChange(rateind,val,idx){
	if(rateind.value=='C'){
		document.getElementById("factor_rate_ind"+idx).value='';
		//return false;
	}else{
		document.getElementById("factor_rate_ind"+idx).value=val.value;
	}
}

function autorefundchk(index){
	var refn_chk=document.getElementById("auto_refund_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("auto_refund_yn"+index).value='Y';
	}else{
		document.getElementById("auto_refund_yn"+index).value='N';
	}
	}
	
function applfactchk(index){
	var refn_chk=document.getElementById("apply_fact_for_srv_lmt_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("apply_fact_for_srv_lmt_yn"+index).value='Y';
	}else{
		document.getElementById("apply_fact_for_srv_lmt_yn"+index).value='N';
	}
}

function splitchk(index){
	var refn_chk=document.getElementById("split_allowed_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("split_allowed_yn"+index).value='Y';
	}else{
		document.getElementById("split_allowed_yn"+index).value='N';
	}
}

function refundchk(val,index){
	var refn_chk=document.getElementById("refund_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("refund_yn"+index).value='Y';
		document.getElementById("refund_rate"+index).disabled=false;
	}else{
		document.getElementById("refund_yn"+index).value='N';
		document.getElementById("refund_rate"+index).value='';
		document.getElementById("refund_rate"+index).disabled=true;
	}
/*	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;  //replaceable_serv_code
	alert(pkgservind);
	var ratechrgind=document.getElementById("rate_charge_ind"+index).value;
	alert(ratechrgind);
	if(refn_chk=='Y' && pkgservind!='S'){
		document.getElementById("replaceable_yn"+index).value='N';
		alert(getMessage("BL8546", "BL"));
		return false;
	}
	if(refn_chk=='Y' && ratechrgind!='R'){
		alert(getMessage("BL8654", "BLEXT"));
		return false;
	}
	*/
}

async function checkduplicate(index){   
	var facility_id=document.getElementById("facility_id").value;
	var locale=document.getElementById("locale").value;	
	var dbcnt=document.getElementById("dbcnt").value;	
//	alert("dbcnt-"+dbcnt);
//	alert(facility_id);
	var err_id="";
	//var hdn_package_code=document.getElementById("hdn_package_code"+index).value;
	//var hdn_package_seq_no=document.getElementById("hdn_package_seq_no"+index).value;
	var hdn_package_code=document.getElementById("hdn_pack_code").value;
	var hdn_package_seq_no=document.getElementById("hdn_pack_seq_no").value;
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	var pkg_serv_code=document.getElementById("pkg_serv_code"+index).value;
	var order_catalog_yn =document.getElementById("orderCatlogyn").value;
		
$.ajax({
	type : "POST",
	url : "../jsp/MaintainTreatServValidation.jsp?func_mode=chckdupl&facility_id="
			+ facility_id + "&hdn_package_code=" + hdn_package_code + "&hdn_package_seq_no="
			+ hdn_package_seq_no + "&pkgservind=" + pkgservind +"&pkg_serv_code="+pkg_serv_code+
			"&p_language_id="+ locale + "&order_catalog_yn=" + order_catalog_yn,
	async : false,
	dataType : "text",
	success : function(data) {
	 try{	
		var n=trimString(data);
		var e=n.indexOf("::");
		var e1=n.indexOf("::",e+1);
		if(e!='-1'){
			   var error_id=n.substring(e+2,e1);
			   //V230221
			   var err_txt=getMessage(error_id, "BL");
			   if(err_txt=="" ||err_txt==null || err_txt=="undefined"){
				  err_txt= getMessage(error_id, "BLEXT")
			   }
			   //the alert shown as empty 
			 //  alert(err_txt);
			    //V230221
			   err_id=error_id;
			 //  alert(getMessage(error_id, "BL"));  //V230221
			   	document.getElementById("pkg_service_long_desc").value='';	
				document.getElementById("pkg_serv_code"+index).value='';	
				document.getElementById("pkg_serv_code"+index).focus();
			   return false;
			}
			else{
				var error_id="";
				err_id="";
			}
		
		var n1 = n.indexOf("~");
		var n2 = n.indexOf("~",n1+1);
		var n3 = n.indexOf("~",n2+1);
		var n4 = n.indexOf("~",n3+1);
		var n5 = n.indexOf("~",n4+1);
		var n6 = n.indexOf("~",n5+1);
		var n7 = n.indexOf("~",n6+1);
		var n8 = n.indexOf("~",n7+1);
		var n9 = n.indexOf("~",n8+1);
		
		var p_pkg_serv_name     =n.substring(n1+1,n2);
		var p_pkg_serv_status   =n.substring(n2+1,n3);
		var p_rate_charge_ind   =n.substring(n3+1,n4);
		var p_factor_rate_ind   =n.substring(n4+1,n5);
		var p_factor_rate       =n.substring(n5+1,n6);
		var p_home_medication_yn=n.substring(n6+1,n7);
		var p_order_catalog_code=n.substring(n7+1,n8);
		var p_amt_limit_ind     =n.substring(n8+1,n9);

		document.getElementById("rate_charge_ind"+index).value=p_rate_charge_ind;
		if(p_rate_charge_ind=='C'){
			document.getElementById("factor_rate_ind"+index).value="";
			document.getElementById("factor_rate"+index).value="";
			document.getElementById("qty_limit"+index).value="";
			document.getElementById("factor_rate_ind"+index).disable=true;
			document.getElementById("factor_rate"+index).readOnly=true;
			document.getElementById("qty_limit"+index).readOnly=true;
		}else{
		/*	document.getElementById("factor_rate_ind"+index).value="S";
			document.getElementById("factor_rate"+index).value="";
			document.getElementById("qty_limit"+index).value="";
			*/
			document.getElementById("factor_rate_ind"+index).value="S";
			document.getElementById("factor_rate_ind"+index).disabled=false;
			document.getElementById("factor_rate"+index).readOnly=false;
			document.getElementById("qty_limit"+index).readOnly=false;
		}
		if(p_home_medication_yn=='Y'){ 
			document.getElementById("incl_home_medication_yn"+index).value="Y";
			
			//document.getElementById("incl_home_medication_yn"+index).readonly=false;
			document.getElementById("incl_home_medication_yn"+index).disabled=false;
		}else{
			//document.getElementById("qty_limit"+index).value="";
			document.getElementById("incl_home_medication_yn"+index).value="N";
			
			document.getElementById("incl_home_medication_yn"+index).disabled=true;
		}
	//	document.getElementById("order_catalog_code"+index).value=p_order_catalog_code;
		if(p_amt_limit_ind!="null" && p_amt_limit_ind!="")
			document.getElementById("amt_limit"+index).value=p_amt_limit_ind;
		
		if(p_order_catalog_code!="null" && p_order_catalog_code!="")
			document.getElementById("order_catalog_code"+index).value=p_order_catalog_code;
	 }catch(ex){
		 alert("exception in servDuplValidation "+ex.message);
	 }
	},
	 error: function(data){
		 alert("Error in servvalidation  "+String(data));
	 }
});
var dbct=dbcnt++;

if(err_id==""){
	if(index>dbct){
		await newRowDuplicatechck(dbcnt,index,pkg_serv_code);
	}
}

	
}

function newRowDuplicatechck(dbcnt,index,pkg_serv_code){
	if( pkg_serv_code!=""){
		for(var m=1;m<index;m++){
			var pkgservcode=document.getElementById("pkg_serv_code"+m).value;
			if(pkg_serv_code==pkgservcode){
				alert(getMessage("BL0931", "BLEXT"));
				document.getElementById("pkg_service_long_desc").value='';	
				document.getElementById("pkg_serv_code"+index).value='';	
				document.getElementById("pkg_serv_code"+index).focus();
				return false;
			}  
		}
	}
}

function enableReplc(val,index){
	var chcked=document.getElementById("replaceable_yn"+index).checked;
	if(chcked=='true' || chcked==true){
		chck='Y';
	}else{
		chck='N';
	}
	
//	alert(chck);
	//val.value;
	var ordercatcode=document.getElementById("order_catalog_code"+index).value; //order_catalog_code
//	alert("ordercatcode -"+ordercatcode);
	if(chck=='Y' && ordercatcode != ''){
	//	alert("1146 ");
		document.getElementById("replaceable_serv_code"+index).disabled=false;
		document.getElementById("rep_serv_ord_cat_code"+index).disabled=false;
		
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=false;
		document.getElementById("button_serv_orcat_code"+index).disabled=false;
	}else if(chck=='Y' && ordercatcode == ''){
	//		alert("1153 ");
		document.getElementById("rep_serv_ord_cat_code"+index).value="";
		document.getElementById("replaceable_serv_code"+index).disabled=false;  //button_rep_pkg_serv_code
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=false;
		document.getElementById("rep_serv_ord_cat_code"+index).disabled=true;	//button_serv_orcat_code
		document.getElementById("button_serv_orcat_code"+index).disabled=true;
	}else if(chck=='N'){
	//		alert("1160");
		document.getElementById("replaceable_serv_code"+index).value="";
		document.getElementById("rep_serv_ord_cat_code"+index).value="";
		document.getElementById("replaceable_serv_code"+index).disabled=true;
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=true;
		document.getElementById("rep_serv_ord_cat_code"+index).disabled=true;
		document.getElementById("button_serv_orcat_code"+index).disabled=true;
	}
//	var replaceable_serv_code=document.getElementById("replaceable_serv_code"+index).value;
//	var rep_serv_ord_cat_code=document.getElementById("rep_serv_ord_cat_code"+index).value;
}

function chkhomemed(index){
	var repl_chk=document.getElementById("incl_home_medication_yn"+index).checked;
	if(repl_chk==true){
		//repl_chk='Y';
		document.getElementById("incl_home_medication_yn"+index).value='Y';
	}else{
		//repl_chk='N';
		document.getElementById("incl_home_medication_yn"+index).value='N';
	}
}

function dailyLmtIndicatorOnChange(value,index){
	var daily_lmt_ind=document.getElementById("daily_limit_ind"+index).value;
	if(daily_lmt_ind==""){
		document.getElementById("daily_qty_limit"+index).disabled=true;
		document.getElementById("daily_amt_limit"+index).disabled=true;
	}else{
		document.getElementById("daily_qty_limit"+index).disabled=false;
		document.getElementById("daily_amt_limit"+index).disabled=false;
	}
}

function chkReplacable(val,index){
	//var repl_chk=val.value;
	var repl_chk=document.getElementById("replaceable_yn"+index).checked;
	if(repl_chk==true){
		repl_chk='Y';
	}else{
		repl_chk='N';
	}
//	alert(repl_chk);
	//alert(index);
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;  //replaceable_serv_code
//	alert(pkgservind);
	var ratechrgind=document.getElementById("rate_charge_ind"+index).value;
//	alert(ratechrgind);
	if(repl_chk=='Y' && pkgservind!='S'){
		document.getElementById("replaceable_yn"+index).value='N';
		document.getElementById("replaceable_yn"+index).checked=false;
		alert(getMessage("BL8546", "BL"));
		return false;
	}
	if(repl_chk=='Y' && ratechrgind!='R'){
		document.getElementById("replaceable_yn"+index).value='N';
		document.getElementById("replaceable_yn"+index).checked=false;
		
		alert(getMessage("BL8654", "BLEXT"));
		return false;
	}else{
		document.getElementById("replaceable_yn"+index).value='Y';
		
	}
}

async function repOrdCatLookup(index,code,obj){
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	//document.getElementById("pkg_service_long_desc").value='';
//	var pkgservdesc=document.getElementById("pkg_service_long_desc").value;
	var servcode=document.getElementById("replaceable_serv_code"+index).value;
	
//	alert(document.getElementById("pkg_service_long_desc").value);
	var locale  = document.forms[0].locale.value;	
	//alert("pkgservdesc--"+pkgservdesc);
	
	var title ="";
	 var argumentArray = new Array();
	 var dataNameArray = new Array();
	 var dataValueArray = new Array();
	 var dataTypeArray = new Array();
	 title = "List of Billing Services";
	 
	// alert(index);
	var sql="select description, code  from (select b.short_desc description,a.order_catalog_code code from bl_order_catalog a, or_order_catalog_lang_vw b "
	+" where a.order_catalog_code=b.order_catalog_code and a.blng_serv_code =  '"+servcode+"' "
	+" and b.language_id =  '"+locale+"') where upper(description) like upper(?) "
    +" and upper(code) like upper(?) order by 2";
	
		argumentArray[0] = sql;
	    argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "1,2";
	   // argumentArray[4] = "2,1";
	  //  argumentArray[5] = obj.value;
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;
	 //  alert(sql);
	    returnedValues = await  CommonLookup(title, argumentArray);
	    if ((returnedValues != null) && (returnedValues != "")) {
	    	var str =unescape(returnedValues);
	    	var arr = str.split(",");
	        obj.value = arr[1];
	        code.value = arr[0];
	    //    document.getElementById("pkg_service_long_desc").value=returnedValues[1];
	    //    rateindload(returnedValues[0],index);
	    } else {
	        obj.value = '';
	        code.value = '';
	    //    document.getElementById("pkg_service_long_desc").value='';
	        // obj.value = returnedValues[1];
	    }
}

async function servlookup(index,code,obj){
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	//document.getElementById("pkg_service_long_desc").value='';
	var pkgservdesc=document.getElementById("pkg_service_long_desc").value;
	
	if(pkgservdesc!=''){
		// alert("729");
		// pkgservdesc='';
		 document.getElementById("pkg_service_long_desc").value="";
		// obj.value = '';
	    // code.value = '';
	}
//	alert(document.getElementById("pkg_service_long_desc").value);
	var locale  = document.forms[0].locale.value;	
	//alert("pkgservdesc--"+pkgservdesc);
	
	var title ="";
	 var argumentArray = new Array();
	 var dataNameArray = new Array();
	 var dataValueArray = new Array();
	 var dataTypeArray = new Array();
	 if(pkgservind=='S'){
		 title = "List of Billing Services";
	 }else if(pkgservind=='C'){
		 title = "List of Service Classifications";
	 }else if(pkgservind=='G'){
		 title = "List of Service Groups";
	 }else if(pkgservind=='P'){
		 title = "List of Package Groups";
	 }else{
		 title = "List of Items";
	 }
	
//	 alert(index);
	var sql="select description, code  from (SELECT short_desc description,serv_code code FROM (SELECT a.short_desc short_desc,a.blng_serv_code serv_code,'S' pkg_serv_ind,a.language_id lang_id "+
    "FROM bl_blng_serv_lang_vw a, bl_blng_serv b WHERE a.blng_serv_code = b.blng_serv_code AND nvl(b.status,'X') != 'S' "+
     "AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_grp_code serv_code,'G' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_blng_serv_grp_lang_vw a, bl_blng_serv_grp b  WHERE a.serv_grp_code = b.serv_grp_code AND nvl(b.status,'X') != 'S'"+
     "  AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_classification_code serv_code,'C' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_serv_classification_lang_vw a, bl_serv_classification b WHERE a.serv_classification_code = b.serv_classification_code"+
      " AND nvl(b.status,'X') != 'S' AND a.language_id = '"+locale+"' UNION "+
    "SELECT SHORT_DESC short_desc,PACKAGE_SERV_GROUP_CODE serv_code,'P' pkg_serv_ind,'en' lang_id  FROM bl_package_serv_group_hdr"+
   " union SELECT b.SHORT_DESC SHORT_DESC,b.ITEM_CODE serv_code,'M' pkg_serv_ind, b.language_id lang_id FROM bl_st_item a, mm_item_lang_vw b"+
    " WHERE a.item_code = b.item_code AND b.language_id = '"+locale+"') WHERE pkg_serv_ind = '"+pkgservind+"') where upper(description) like upper(?) "+
    "and upper(code) like upper(?)  order by 2";
	
		argumentArray[0] = sql;
	    argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "2,1";
	   // argumentArray[4] = "2,1";
	  //  argumentArray[5] = obj.value;
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;
	//    alert(sql);
	    returnedValues = await CommonLookup(title, argumentArray);
	    if ((returnedValues != null) && (returnedValues != "")) {
	    	var str =unescape(returnedValues);
	    	var arr = str.split(",");
	        obj.value = arr[1];
	        code.value = arr[0];
	        document.getElementById("pkg_service_long_desc").value=arr[1];
	    } else {
	        obj.value = '';
	        code.value = '';
	        document.getElementById("pkg_service_long_desc").value='';
	        // obj.value = returnedValues[1];
	    }
	    await checkduplicate(index);
}


async function repservlookup(index,code,obj){
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	//document.getElementById("pkg_service_long_desc").value='';
	//var pkgservdesc=document.getElementById("pkg_service_long_desc").value;
	
	
//	alert(document.getElementById("pkg_service_long_desc").value);
	var locale  = document.forms[0].locale.value;	
	//alert("pkgservdesc--"+pkgservdesc);
	
	var title ="";
	 var argumentArray = new Array();
	 var dataNameArray = new Array();
	 var dataValueArray = new Array();
	 var dataTypeArray = new Array();
	 if(pkgservind=='S'){
		 title = "List of Billing Services";
	 }else if(pkgservind=='C'){
		 title = "List of Service Classifications";
	 }else if(pkgservind=='G'){
		 title = "List of Service Groups";
	 }else if(pkgservind=='P'){
		 title = "List of Package Groups";
	 }else{
		 title = "List of Items";
	 }
	
	// alert(index);
	var sql="select description, code  from (SELECT short_desc description,serv_code code FROM (SELECT a.short_desc short_desc,a.blng_serv_code serv_code,'S' pkg_serv_ind,a.language_id lang_id "+
    "FROM bl_blng_serv_lang_vw a, bl_blng_serv b WHERE a.blng_serv_code = b.blng_serv_code AND nvl(b.status,'X') != 'S' "+
     "AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_grp_code serv_code,'G' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_blng_serv_grp_lang_vw a, bl_blng_serv_grp b  WHERE a.serv_grp_code = b.serv_grp_code AND nvl(b.status,'X') != 'S'"+
     "  AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_classification_code serv_code,'C' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_serv_classification_lang_vw a, bl_serv_classification b WHERE a.serv_classification_code = b.serv_classification_code"+
      " AND nvl(b.status,'X') != 'S' AND a.language_id = '"+locale+"' UNION "+
    "SELECT SHORT_DESC short_desc,PACKAGE_SERV_GROUP_CODE serv_code,'P' pkg_serv_ind,'en' lang_id  FROM bl_package_serv_group_hdr"+
   " union SELECT b.SHORT_DESC SHORT_DESC,b.ITEM_CODE serv_code,'M' pkg_serv_ind, b.language_id lang_id FROM bl_st_item a, mm_item_lang_vw b"+
    " WHERE a.item_code = b.item_code AND b.language_id = '"+locale+"') WHERE pkg_serv_ind = '"+pkgservind+"') where upper(description) like upper(?) "+
    "and upper(code) like upper(?)  order by 2";
	
		argumentArray[0] = sql;
	    argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "1,2";
	   // argumentArray[4] = "2,1";
	  //  argumentArray[5] = obj.value;
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;
	//    alert(sql);
	    returnedValues = await CommonLookup(title, argumentArray);
	    if ((returnedValues != null) && (returnedValues != "")) {
	    	var str =unescape(returnedValues);
	    	var arr = str.split(",");
	        obj.value = arr[1];
	        code.value = arr[0];
	     //   document.getElementById("pkg_service_long_desc").value=returnedValues[1];
	    //    rateindload(returnedValues[0],index);
	    } else {
	        obj.value = '';
	        code.value = '';
	    //    document.getElementById("pkg_service_long_desc").value='';
	        // obj.value = returnedValues[1];
	    }
}

function checkForNegetiveNumber(obj, noofdecimal, msg) {
	//alert(obj.value);
	if (obj.value < 0) {
		alert(getMessage(msg, "BL"));
		obj.value = "";
		obj.focus();
	} 
	
}

async function addRow(tableID) {

	var pkgServLmtDtlsPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value;
	var flag = true;
	if(pkgServLmtDtlsPrivYN != "Y") {
		var retVal = await authPkgAccessForUser("MODIFY_PKG_SERV_LMT_DTLS_MTPKG");
		if(retVal == "Y"){
			parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value = "Y";
			flag = true;
		} else {
			alert("User do not have the privilege");
			parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value = "N";
			flag = false;
			return false;
		}		
	}

	var mode = "";
	var table = "";
	var rowCount = "";
	var index = "";
	var row = "";
	var order_associated ="";	
	
	//formObj=parent.PayerDtls.document.PayerDtls;
	//table = parent.PayerDtls.document.getElementById('maintainTrtPkgDtls');	
	//rowCount = table.rows.length;	
	
	//index = rowCount-1;	
	//alert("tableid"+tableID);
	/*
	var formObj = 	parent.BLMaintaintreatmentPackage.document.forms[0];
	table = parent.BLMaintaintreatmentPackage.document.getElementById('maintainTrtPkgDtls');		*/
	var formObj = 	parent.BLMaintaintreatmentPackageserv.document.forms[0];
	table = parent.BLMaintaintreatmentPackageserv.document.getElementById('maintainTrtPkgDtls');
	rowCount = table.rows.length;	
	rowCount = parseInt(rowCount);
	document.getElementById('index').value=rowCount;	
	index=rowCount;
	
	var indicatorFldDisabled= formObj.indicatorFldDisabled.value;
	var amtFldDisabled 		= formObj.amtFldDisabled.value;
	var qtyFldDisabled 		= formObj.qtyFldDisabled.value; 
	var grossNetDisabled	= formObj.grossNetDisabled.value;
	//document.getElementById('hdn_group_service_ind'+index).value=Y";
	/*var totalRecords = formObj.totalRecords.value;
	alert(totalRecords)''
	rowCount = parseInt(totalRecords) + 1;
	index = parseInt(totalRecords);*/

	//var siteSpecf = formObj.siteSpecf.value; 
	/*var dailyLimitSiteSpec = formObj.dailyLimitSiteSpec.value;
	var amtFldDisabled = formObj.amtFldDisabled.value;
	var qtyFldDisabled = formObj.qtyFldDisabled.value;
	var indicatorFldDisabled = formObj.indicatorFldDisabled.value;
	var dailyPkgLmt = formObj.dailyPkgLmt.value;
	var dailyLmtChkYN = formObj.dailyLmtChkYN.value;
	var totalRecords = formObj.totalRecords.value;

	var servGrpLmtFldDisabled = formObj.servGrpLmtFldDisabled.value;
	var servGrpLmtBy = formObj.servGrpLmtBy.value;
	var servGrpLimitSiteSpec = formObj.servGrpLimitSiteSpec.value;

	var message = "";
	var obj;
	var order_associated = formObj.order_associated.value;
	if (order_associated == "Y") {
		if (eval("formObj.service_code" + (parseInt(index) - 1)) != null
				&& eval("formObj.service_code" + (parseInt(index) - 1)).value != "") {
			if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value == "") {
				message = getMessage("BL8562", 'BL');
				obj = eval("formObj.catalog_desc" + (parseInt(index) - 1));
			}
			if (eval("formObj.catalog_code" + (parseInt(index) - 1)).value != ""
					&& eval("formObj.qty_limit" + (parseInt(index) - 1)).value == "") {
				message = getMessage("BL8538", 'BL');
				obj = eval("formObj.qty_limit" + (parseInt(index) - 1));
			}
		
			if (message != "") {
				alert(message);
				obj.focus();
				return false
			}
		}
	}*/

	//row = eval(
			//"parent.BLMaintaintreatmentPackage.getElementById('" + tableID
				//	+ "')").insertRow();					
					
	row = parent.BLMaintaintreatmentPackageserv.document.getElementById('maintainTrtPkgDtls').insertRow(rowCount);
					
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
	var cell8 = row.insertCell(7);
	var cell9 = row.insertCell(8);
	var cell10 = row.insertCell(9);
	var cell11 = row.insertCell(10);
	var cell12 = row.insertCell(11);
	var cell13 = row.insertCell(12);
	var cell14 = row.insertCell(13);
	var cell15 = row.insertCell(14);
	var cell16 = row.insertCell(15);
	var cell17 = row.insertCell(16);
	var cell18 = row.insertCell(17);
	var cell19 = row.insertCell(18); 
	var cell20 = row.insertCell(19); 
	var cell21 = row.insertCell(20);
	var cell22 = row.insertCell(21); 
	var cell23 = row.insertCell(22); 
	var cell24 = row.insertCell(23); 
	var cell25 = row.insertCell(24);
	var cell26 = row.insertCell(25);
	var cell27 = row.insertCell(26);
	var typeHTML = "";
	var indHTML = "";
	var ordCatDisabled = "disabled";
	//noofdecimal = parent.parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value

	cell1.innerHTML = "<td class='fields' nowrap> "+
	"<select  NAME='pkg_serv_ind" + index
	+ "' id='pkg_serv_ind" + index
	+ "' onChange='onCustServiceTypeChange(this,\"" + index
	+ "\");grpServiceVal(this,\"" + index
	+ "\",1);'><option value='S'>"
	+ getLabel('Common.BillingService.label', 'Common')
	+ "</option><option value='G'>"
	+ getLabel('eBL.SERVICE_GROUP.label', 'BL')
	+ "</option><option value='C'>"
	+ getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')
	+ "</option><option value='P'>"
	+ getLabel('eBL.PackageGrouping.label', 'BL')
	+ "</option><option value='M'>"
	+ getLabel('eBL.Items.label', 'BL')
	+ "</option></select>"+
		"</td> ";
	cell1.className = 'fields'; 
	cell1.style.nowrap="nowrap"; 
	 
	cell2.innerHTML = "<td class='fields' nowrap> "
		+"<input type='text'  name='pkg_serv_code" + index  
		+ "' id='pkg_serv_code" + index  
		+ "'  maxlength='10'  value='' onblur='if(this.value.length>0){servlookup("+index+",pkg_serv_code"+index+",pkg_serv"+index+");checkduplicate("+index+");} else{ fnClearCode(pkg_serv_code"+index+"); }'> <input type='hidden' name='pkg_serv" + index  
		+ "' id='pkg_serv" + index + "' value='' ><input type='button' name='button_pkg_serv_code"
		+ index
		+ "' id='button_pkg_serv_code"
		+ index
		+ "' class='button' value='?' onClick='servlookup("+index+",pkg_serv_code"+index+",pkg_serv"+index+");checkduplicate("+index+");'>"+
		"</td> ";
	cell2.className = 'fields'; 
	//cell2.style.nowrap="nowrap"; 
	cell2.style.whiteSpace = "nowrap"; 
	
	cell3.innerHTML = "<td class='fields' nowrap> "
			+"<input type='text' style='text-align:center;'  name='rate_charge_ind"
			+ index
			+ "' id='rate_charge_ind"
			+ index
			+ "' onblur='ChangeUpperCase( this );' size='10' maxlength='13' readonly >"+
		"</td> ";
	cell3.className = 'fields'; 
	cell3.style.nowrap="nowrap"; 
	
	cell4.innerHTML = "<td class='fields' nowrap> "
			+ "<input type='text' name='order_catalog_code" + index
			+ "' id='order_catalog_code" + index
			+ "'  size='20' disabled>"+
			"</td>";	
	cell4.className = 'fields'; 
	cell4.style.nowrap="nowrap"; 
	

	cell5.innerHTML  = "<td class='fields' nowrap> "
		+"<SELECT  style='width:100px;' NAME='factor_rate_ind" + index
		+ "' id='factor_rate_ind" + index
		+ "' onChange='onIndChange(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,\"" + index
		+ "\")'><option value=''>"
		+ getLabel('Common.Select.label', 'Common')
		+ "</option><option value='S' selected>"
		+ getLabel('Common.Standard.label', 'Common')
		+ "</option><option value='R'>"
		+ getLabel('eBL.AsPerRule.label', 'BL')
		+ "</option><option value='U'>"
		+ getLabel('Common.UserDefined.label', 'Common')
		+ "</option><option value='P'>"
		+ getLabel('eBL.PRICE_CLASS.label', 'BL')
		+ "</option></select>"+
			"</td>";
	cell5.className = 'fields'; 
	cell5.style.nowrap="nowrap"; 

	cell6.innerHTML = "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name='factor_rate"
		+ index
		+ "' id='factor_rate"
		+ index
		+ "' size='10' maxlength='13' onBlur='validatefactorlmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",1)' onkeypress='return allowValidNumber(this,event,\"10\",\""
		//+ noofdecimal 
		+ "\")'; >"+
			"</td>";
	cell6.className = 'fields'; 
	cell6.style.nowrap="nowrap"; 
	/*
	cell7.innerHTML = "<input type='text' name='roundTo"
			+ index
			+ "' size='12'   onkeypress=\" return (allowValidNumber1(this,event));\"  value='' />";
	*/

	cell7.innerHTML = "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name='qty_limit" + index
		+ "' id='qty_limit" + index
		+ "'  size='10' onBlur='validatefactorlmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",2)' onkeypress='return ChkNumberInput(this,event,\""
		//+ noofdecimal 
		+ "\")'>"+
			"</td>";
	cell7.className = 'fields'; 
	cell7.style.nowrap="nowrap"; 
	
	cell8.innerHTML = "<td class='fields' nowrap> "
		+"<select style='width:100px;' name='amt_limit_ind"
		+ index
		+ "' id='amt_limit_ind"
		+ index
		+ "'  onChange='grpServiceVal(this,\""
		+ index
		+ "\",2);validatefactorlmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",3);'><option value='' selected>"  
		+ getLabel('Common.defaultSelect.label', 'Common')
		+ "</option><option value='A' >"
		+ getLabel('Common.amount.label', 'Common')
		+ "</option><option value='P' >"
		+ getLabel('Common.Percent.label', 'Common')
		+ "</option><option value='U' >"
		+ getLabel('eBL.UNLIMITED.label', 'BL') + "</option></select>"+
			"</td>";	
	cell8.className = 'fields'; 
	cell8.style.nowrap="nowrap"; 
	
	cell9.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name='amt_limit" + index
		+ "' id='amt_limit" + index
		+ "'  size='20' onBlur='validatefactorlmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",4)' onkeypress='return ChkNumberInput(this,event,\""
		//+ noofdecimal 
		+ "\")'>"+
			"</td>";	
	cell9.className = 'fields'; 
	cell9.style.nowrap="nowrap"; 		

	cell10.innerHTML  = "<td class='fields' nowrap> "
		+"<SELECT  style='width:100px;' NAME='GrpsSrvind" + index
		+ "' id='GrpsSrvind" + index
		+ "' onChange='validateGrpservInd(this,\"" + index
		+ "\")' disabled><option value='B'>"
		+ getLabel('Common.Select.label', 'Common')
		+ "</option><option value='G'>"
		+ getLabel('Common.Group.label', 'Common')
		+ "</option><option value='S'>"
		+ getLabel('Common.service.label', 'Common')
		+ "</option></select>"+
			"</td>";
	cell10.className = 'fields'; 
	cell10.style.nowrap="nowrap"; 
	
	cell11.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='incl_home_medication_yn"
		+ index + "' id='incl_home_medication_yn"
		+ index + "' onClick='chkhomemed(\"" + index
		+ "\")' value='' >"+
			"</td>";	
	cell11.className = 'fields'; 
	cell11.style.nowrap="nowrap"; 
		
	cell12.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='replaceable_yn"
		+ index + "' id='replaceable_yn"
		+ index + "' onClick='chkReplacable(this,\"" + index
		+ "\");enableReplc(this,\"" + index
		+ "\");' value='N' >"+
			"</td>";	
	cell12.className = 'fields'; 
	cell12.style.nowrap="nowrap"; 	
	
	cell13.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text'  name='replaceable_serv_code" + index  
		+ "' id='replaceable_serv_code" + index  
		+ "'  maxlength='10'  value='' onblur='if(this.value.length>0){repservlookup("+index+",replaceable_serv_code"+index+",rep_pkg_serv"+index+")} else{ fnClearCode(replaceable_serv_code"+index+"); }' disabled> <input type='hidden' name='rep_pkg_serv" + index  
		+ "' id='rep_pkg_serv" + index + "' value='' ><input type='button' name='button_rep_pkg_serv_code"
		+ index
		+ "' id='button_rep_pkg_serv_code"
		+ index
		+ "' class='button' value='?' onClick='repservlookup("+index+",replaceable_serv_code"+index+",rep_pkg_serv"+index+")' disabled>"+
		"</td> ";
	cell13.className = 'fields'; 
	//cell13.style.nowrap="nowrap";
	cell13.style.whiteSpace = "nowrap";
	
	cell14.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text'  name='rep_serv_ord_cat_code" + index  
		+ "' id='rep_serv_ord_cat_code" + index  
		+ "'  maxlength='10'  value='' onblur='if(this.value.length>0){repOrdCatLookup("+index+",rep_serv_ord_cat_code"+index+",rep_ord_"+index+")} else{ fnClearCode(rep_serv_ord_cat_code"+index+"); }' disabled> <input type='hidden' name='rep_ord_" + index  
		+ "' id='rep_ord_" + index + "' value='' ><input type='button' name='button_serv_orcat_code"
		+ index
		+ "' id='button_serv_orcat_code"
		+ index
		+ "' class='button' value='?' onClick='repOrdCatLookup("+index+",rep_serv_ord_cat_code"+index+",rep_ord_"+index+")' disabled>"+
		"</td> ";	
	cell14.className = 'fields'; 
	//cell14.style.nowrap="nowrap";
	cell14.style.whiteSpace = "nowrap";
	
	cell15.innerHTML =  "<td class='fields' nowrap> "
		+"<select style='width:150px;' name='daily_limit_ind"
		+ index
		+ "' id='daily_limit_ind"
		+ index
		+ "' onChange='dailyLmtIndicatorOnChange(this,\""
		+ index
		+ "\") ' "
		+ indicatorFldDisabled
		+ " ><option value='' selected >"
		+ getLabel('Common.defaultSelect.label', 'Common')
		+ "</option><option value='G' >"
		+ getLabel('Common.Group.label', 'Common')
		+ "</option><option value='I' >"
		+ getLabel('eBL.PIPD.label', 'bl')
		+ "</option></select>"+
			"</td>";	
	cell15.className = 'fields'; 
	cell15.style.nowrap="nowrap";

	/*
	 * <option value='A' >"
		+ getLabel('Common.amount.label', 'Common')
		+ "</option><option value='P' >"
		+ getLabel('Common.Percent.label', 'Common')
		+ "</option><option value='U' >"
		+ getLabel('eBL.UNLIMITED.label', 'BL') + "</option></select>"+
			"</td>";
	 * 
	var optionTxt1 = "";
	if (servGrpLmtBy != "*") {				
		if (servGrpLmtBy == "B" ) {				
			optionTxt1 += "<option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option><option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option></select>";
		} else if (servGrpLmtBy == "G" ) {
			optionTxt1 +="</option><option value='G'>"+ getLabel('Common.Group.label', 'Common')+ "</option>";
		} else if (servGrpLmtBy == "S" ) {
			optionTxt1 +="<option value='S'>"+ getLabel('eBL.Service.label', 'BL')+ "</option>";
		}
	}		
	if (servGrpLimitSiteSpec == "true" && order_associated=="N") {
		servGrpLmtFldDisabled = " enabled ";
	}
	cell11.innerHTML = "<select name='serv_grp_limit_ind" + index
	+ "' id='serv_grp_limit_ind" + index
	+ "' "+servGrpLmtFldDisabled
	+">"
	+" <option value='*'>"+getLabel('Common.Select.label', 'COMMON')+"</option>"+optionTxt1+"</select>";	
	*/
	
	cell16.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name = 'daily_qty_limit" + index
		+ "' id = 'daily_qty_limit" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value='' "
		+ qtyFldDisabled
		+ " >"+
			"</td>";	
	cell16.className = 'fields'; 
	cell16.style.nowrap="nowrap";
		
	cell17.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name = 'daily_amt_limit" + index
		+ "' id = 'daily_amt_limit" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''   "
		+ amtFldDisabled
		+ " >"
		+"<SELECT  style='width:100px;' NAME='GrossNet" + index
		+ "' id='GrossNet" + index
		+ "' onChange='validateGrossNetInd(this,\"" + index
		+ "\")' "+grossNetDisabled+"><option value='G'>"
		+ getLabel('eBL.Gross.label', 'bl')
		+ "</option><option value='S'>"
		+ getLabel('eBL.Net.label', 'bl')
		+ "</option></select>"+
			"</td>";	
	cell17.className = 'fields'; 
	cell17.style.nowrap="nowrap";

	cell18.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'    name='refund_yn"
		+ index + "' id='refund_yn"
		+ index + "' onClick='refundchk(this,\"" + index
		+ "\")' value=\"N\">"+
			"</td>";	
	cell18.className = 'fields'; 
	cell18.style.nowrap="nowrap";

	cell19.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' name = 'refund_rate" + index //tex
		+ "' id = 'refund_rate" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''  disabled >"+
			"</td>";	
	cell19.className = 'fields'; 
	cell19.style.nowrap="nowrap";
	
	/*
	cell19.innerHTML = "<input type='text' name = 'auto_refund_yn" + index//tex
	+ "' id = 'auto_refund_yn" + index
	+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
	+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''   />"; */
		
	cell20.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'    name='auto_refund_yn"
		+ index + "' id='auto_refund_yn"
		+ index + "' onClick='autorefundchk(\"" + index
		+ "\")' value=\"N\">"+
			"</td>";	
	cell20.className = 'fields'; 
	cell20.style.nowrap="nowrap";	

	cell21.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'  name='close_package_yn" + index
		+ "' id='close_package_yn" + index
		+ "' onClick='factorAppl(this,\"" + index
		+ "\")'  value='N' disabled>"+
			"</td>";	
	cell21.className = 'fields'; 
	cell21.style.nowrap="nowrap";
	
	cell22.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' name = 'utilized_serv_qty" + index//tex
		+ "' id = 'utilized_serv_qty" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''  disabled >"+
			"</td>";	
	cell22.className = 'fields'; 
	cell22.style.nowrap="nowrap";

	cell23.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' name = 'utilized_serv_amt" + index//tex
		+ "' id = 'utilized_serv_amt" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''  disabled >"+
			"</td>";	
	cell23.className = 'fields'; 
	cell23.style.nowrap="nowrap";

	cell24.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='apply_fact_for_srv_lmt_yn"
		+ index
		+ "' id='apply_fact_for_srv_lmt_yn"
		+ index
		+ "' onClick='applfactchk(\""
		+ index
		+ "\")' value='N' disabled >"+
			"</td>";	
	cell24.className = 'fields'; 
	cell24.style.nowrap="nowrap";

	cell25.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox' name='split_allowed_yn" + index
		+ "' id='split_allowed_yn" + index
		+ "'  checked  value='Y'  onclick='splitchk(\""
		+ index
		+ "\");'>"+
			"</td>";	
	cell25.className = 'fields'; 
	cell25.style.nowrap="nowrap";
	/*
	cell26.innerHTML =  "<td class='fields' nowrap> "
		+"<a id='service_limit_dtls" + index
		+ "' href='#' onClick='custServiceLimitDtls(\"" + index
		+ "\")' >" + getLabel('eBL.Dtls.label', 'BL') + "</a>"+
			"</td>";	
	cell26.className = 'fields'; 
	cell26.style.nowrap="nowrap";
	*/
	cell26.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox' name='radio" + index
		+ "' id='radio" + index
		+ "' value='' onclick='selRow(\""
		+ index
		+ "\",this);'>"
		+ "<input type='hidden' name='hdn_is_newly_added_row_YN_" + index+ "' id='hdn_is_newly_added_row_YN_" + index+ "' id='hdn_is_newly_added_row_YN_" + index + "' value='Y' >"
		+ "<input type='hidden' name='hdn_row_marked_for_del_" + index+ "' id='hdn_row_marked_for_del_" + index+ "' id='hdn_row_marked_for_del_" + index + "' value='N' >"
		+ "</td>";	
	cell26.className = 'fields'; 
	cell26.style.nowrap="nowrap";	
	
	 var temp = "<td class='fields' nowrap> "
		+"<a  href='#' onclick='openDetails(\""
		+ index
		+ "\");'>Dtls</a>"
		+ "<input type='hidden' name='is_excl_mod_YN_" + index+ "' id='is_excl_mod_YN_" + index+ "' id='is_excl_mod_YN_" + index + "' value='N' >"
		+ "<input type='hidden' name='excl_string_" + index+ "' id='excl_string_" + index+ "' id='excl_string_" + index + "' value='' >"
		+ "</td>";	

	cell27.innerHTML = temp;
	cell27.className = 'fields'; 
	cell27.style.nowrap="nowrap";	
	
	//formObj.totalRecords.value = parseInt(formObj.totalRecords.value) + 1;
	// added for common validation
	//parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value = rowCount;	
	formObj.rowcount.value=rowCount;	
}

async function selRow(index,r){

	var pkgServLmtDtlsPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value;
	var flag = true;
	
	if(pkgServLmtDtlsPrivYN != "Y") {
		var retVal = await authPkgAccessForUser("MODIFY_PKG_SERV_LMT_DTLS_MTPKG");
		if(retVal == "Y"){
			parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value = "Y";
			flag = true;
		} else {
			alert("User do not have the privilege");
			parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value = "N";
			parent.BLMaintaintreatmentPackageserv.document.getElementById('radio'+index).checked = false;
			flag = false;
			return false;
		}		
	}
	
	selidx=index;
	var table = parent.BLMaintaintreatmentPackageserv.document.getElementById('maintainTrtPkgDtls');
	var rowCount = table.rows.length;

	var i = r.parentNode.parentNode.rowIndex;

	var formObj = 	parent.BLMaintaintreatmentPackageserv.document.forms[0]; 

	if(parent.BLMaintaintreatmentPackageserv.document.getElementById('radio'+index).checked){

		parent.BLMaintaintreatmentPackageserv.document.getElementById('hdn_row_marked_for_del_'+index).value = "Y";
	} else {
		parent.BLMaintaintreatmentPackageserv.document.getElementById('hdn_row_marked_for_del_'+index).value = "N";
	}

	var hdn_is_newly_added_row_YN = parent.BLMaintaintreatmentPackageserv.document.getElementById("hdn_is_newly_added_row_YN_"+index).value;
	/* alert("hdn_is_newly_added_row_YN:"+hdn_is_newly_added_row_YN);
	if(hdn_is_newly_added_row_YN == "Y") {
		var userconfirm = confirm("Do you wish to remove the newly added row");
		if(userconfirm) {
			table.deleteRow(i);
		} else {
			parent.BLMaintaintreatmentPackageserv.document.getElementById('radio'+index).checked = false;
		}
	}*/
}

async function deleteRow()
{	
	var rwcount=document.getElementById('cnt').value;
	
	//alert(rwcount);
	var idxsel=0;

	idxsel=selidx;
//alert("idxsel--"+idxsel);
	
	if(idxsel!=0){
	/*	
	var val=confirm('Do you want to delete the record and recalculate', function() {
    // do work here if ok/yes selected...
    //console.info('Done!');
	alert("yes");
//var temp_jsp = "../jsp/MainTreatAlert.jsp";	
	
	}, {
    style: 'width:420px;font-size:0.8rem;',
    buttons: {
      ok: 'yes',
      cancel: 'No'
    },
    oncancel: function() {
     // console.warn('Cancelled!');
alert("No");
    }
  });
	*/
		var patientid=document.getElementById("patientid1").value;	
		var table = document.getElementById('maintainTrtPkgDtls');
		var dialogUrl = "../../eBL/jsp/MainTreatAlert.jsp";
		var dialogFeatures = "dialogHeight:" + "8" + "; dialogWidth:" + "35"
		+ " ; scroll=yes; center: "+"yes";
		var returnVal = await window.showModalDialog(dialogUrl, null, dialogFeatures);
		//alert("returnVal--"+returnVal);

		if(returnVal==true){
			deleterec(idxsel);
			//parent.frames[3].location.reload();
			var selectrow=parent.frames[3].document.forms[0].rowClicked.value;

			parent.frames[3].location.replace("../../eBL/jsp/MainTreatmentPackage.jsp?patid="
			+ patientid );
			window.location.replace("../../eCommon/html/blank.html");
			//	window.location.reload();

		}
	} else if(idxsel == 0){
		alert("Please select at least one record");
	}
/*	var table = document.getElementById('maintainTrtPkgDtls');
//	var idxsel=document.getElementById('radio'+index).value;
	rowCount = table.rows.length;
	var count=0;
	for(var i=0; i<rowCount; i++)
	{
		var row = table.rows[i];
		var delChekBox = row.cells[27].childNodes[0];
		var index = delChekBox.name;
		if(null != delChekBox && true == delChekBox.checked) 
		{
			table.deleteRow(i);
			rowCount--;
			i--;
			count++;
		}
	}
	if(count == 0)
	{
		alert("Please select at least one check box");
	}	
	*/
}

function deleterec(index){   
	var facility_id=document.getElementById("facility_id").value;
	var locale=document.getElementById("locale").value;	
	var patientid1=document.getElementById("patientid1").value;	
//	alert("dbcnt-"+dbcnt);
//	alert(facility_id);
	//var err_id="";
	var userid=document.getElementById("userid").value;
	var wsno=document.getElementById("ws_no").value;
	var hdn_package_code=document.getElementById("hdn_pack_code").value;
	var hdn_package_seq_no=document.getElementById("hdn_pack_seq_no").value;
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	var pkg_serv_code=document.getElementById("pkg_serv_code"+index).value;
	var visit_id=document.getElementById("visit_id").value;
	var episode_id=document.getElementById("episode_id").value;
	var episode_type=document.getElementById("episode_type").value;
//	var order_catalog_yn =document.getElementById("orderCatlogyn").value;
		
$.ajax({
	type : "POST",
	url : "../jsp/MaintainTreatServValidation.jsp?func_mode=deleteRecord&facility_id="
			+ facility_id + "&patientid1="
			+ patientid1 + "&hdn_package_code=" + hdn_package_code + "&hdn_package_seq_no="
			+ hdn_package_seq_no + "&pkgservind=" + pkgservind +"&pkg_serv_code="+pkg_serv_code+
			"&p_language_id="+ locale + "&userid=" + userid + "&wsno=" + wsno +"&p_visit_id="+visit_id+
			"&p_episode_id="+ episode_id +"&p_episode_type=" +episode_type,
			//p_episode_type  , p_episode_id ,   p_visit_id  
	async : false,
	dataType : "text",
	success : function(data) {
	 try{	
		var n=trimString(data);
		var e=n.indexOf("::");
		var e1=n.indexOf("::",e+1);
		if(e!='-1'){
			   var error_id=n.substring(e+2,e1);
		//	   alert("error_id-"+error_id);
			   err_id=error_id;
			   alert(getMessage(error_id, "BL"));
			   return false;
			}
			else{
				var error_id="";
				err_id="";
			}
		
		}catch(ex){
		 alert("exception in deleteValidation "+ex.message);
	 }
	},
	 error: function(data){
		 alert("Error in deleteValidation  "+String(data));
	 }
});

	
}


function grpServiceVal(optn,index,calledfrm){
	 var orderCatYN= document.getElementById("orderCatlogyn").value;
	 var pkgServLmtInd= document.getElementById("pkgServIndLmtYN").value;
	 //alert("calledfrm=="+calledfrm);
	 var amtLimitInd='';
	 var servInd='';
	 if(calledfrm=='1'){
		 amtLimitInd= document.getElementById("amt_limit_ind"+index).value;
		 servInd=optn.value;
	 }else{
		 servInd = document.getElementById("pkg_serv_ind"+index).value;
		 amtLimitInd=optn.value;
	 }
	
	
	 if(pkgServLmtInd=='Y' && orderCatYN=='N'){
		// if(orderCatYN=='N'){
			 if((servInd=='G' || servInd=="C" || servInd=="P") && (amtLimitInd != 'U')){
				// alert("1659 enable G/S");
				 document.getElementById("GrpsSrvind"+index).disabled=false;
			}else{
			//	 alert("1668 disable G/S");
				 document.getElementById("GrpsSrvind"+index).value="";
				 document.getElementById("GrpsSrvind"+index).disabled=true;
				}
		// }
	 }
	 else{
//alert("1679 disable G/S");
		 document.getElementById("GrpsSrvind"+index).value="";
		 document.getElementById("GrpsSrvind"+index).disabled=true;
		 //return false;
	 }
}

function onCustServiceTypeChange(opt,index){
//	alert(opt);
	 document.getElementById("pkg_serv_code"+index).value='';
	 document.getElementById("rate_charge_ind"+index).value='';
	 document.getElementById("pkg_service_long_desc").value='';
		 
}



function isValidDateTime(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var dateTimeObj = obj.value;
		var dateTimeArr = dateTimeObj.split(" ");
		if(dateTimeArr.length != 2)  flag=false;
		var str_date = dateTimeArr[0];
		var str_time = dateTimeArr[1];

		if(flag) {
			if(!(checkDt(str_date))){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}
			
			if(!(isValidTime(str_time))){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}
		} else {
			alert(getMessage('INVALID_DATE_FMT','SM'),obj);
			obj.value = '';
			obj.focus();
		}
	}

	return true;
}

function isValidTime(time1)
{
	if (time1.value != undefined)
	{
		time1 = time1.value;
	}
	else
	{
		time1=time1;
	}
   time1=trimString(time1); 
   var retval=true;
   var strCheck = ':0123456789';
    for(var i=0;i<=time1.length;i++) {
        if (strCheck.indexOf(time1.charAt(i)) == -1){
            retval = false;
            break;
        }
    }			
    if (retval)
    {		
       var time1arr=new Array()
       time1arr=time1.split(":")
			
            if(time1arr.length==3)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 retval=false;
				}

                time1hr=eval(time1hr)
                time1min=eval(time1min)
                time1sec = eval(time1sec)
                if(time1hr<=23)
                {
                    if(time1min>59)
                    {
                            retval=false;                      
                    }
                    if(time1sec>59){
                    	retval=false;
                    }
                }
                else
                        retval=false;
            }
            else{						
                retval=false;
			}
        
    }			
    return retval;
}

function checkDt(date1)
{
	if (date1.value != undefined)
	{
		date1 = date1.value;
	}
	else
	{
		date1=date1;
	}
    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]
        
        if(date1d.length != 2) return false;
        if(date1m.length != 2) return false;
        if(date1y.length != 4) return false;

		if (isNaN(date1d)==true) return false;
		if (isNaN(date1m)==true) return false;
		if (isNaN(date1y)==true) return false;

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1m<=12)
        {
            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {
                retval= false
            }

            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
            {
                retval= false
            }
            if ((date1y.length <4) || (date1y.length >4))
            {
                retval= false
            }
            if (date1m == 2) {
                if (date1d< 1) return false;

                if (LeapYear(date1yy) == true) {
                    if (date1d> 29) return false;
                }
                else {
                    if (date1d > 28) return false;
                }
            }

            if (isNaN(date1d)==true) retval = false;
            if (isNaN(date1m)==true) retval = false;
            if (isNaN(date1yy)==true) retval = false;
        }
        else
        {
            retval= false;
        }
    }
    else
    {
        retval= false;
    }
    return retval;
}
function applyAdhocDisc(){
	alert("2590")
//V211118
}
async function ModifyRecords(calledFor){
	var privlege_code = "MODIFY_PKG_SERV_LMT_DTLS_MTPKG";
	var pkgServLmtDtlsPrivYN = parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value;
	
	if(calledFor == 'pkgServDtls'){
		
		if(pkgServLmtDtlsPrivYN == 'Y') {
			// If logged in user is already having the privilege then we enable the fields for modification
							var selectedItemIndex = parent.BLMaintaintreatmentPackageserv.document.getElementById("selectedItemIndex").value;
				var pkgDes = parent.BLMaintaintreatmentPackage.document.getElementById('Package_Description').value;

				parent.BLMaintaintreatmentPackage.document.getElementById("pkgServLmtDtlsPrivYN").value = "Y";
				await showPackageServiceDetails(selectedItemIndex,pkgDes);
		}
		else{		
			var retVal = authPkgAccessForUser(privlege_code);
			
			if(retVal=="Y"){
				var selectedItemIndex = parent.BLMaintaintreatmentPackageserv.document.getElementById("selectedItemIndex").value;
				var pkgDes = parent.BLMaintaintreatmentPackage.document.getElementById('Package_Description').value;

				parent.BLMaintaintreatmentPackage.document.getElementById("pkgServLmtDtlsPrivYN").value = "Y";
				await showPackageServiceDetails(selectedItemIndex,pkgDes);				
			} else {
				alert("User do not have the privilege");
				return false;
			}		
		}
	}
}

function funToEnableDisablePkgServDtls(calledFor){
	if(calledFor == 'E'){
		// Logic to enable all the needed form fields
	} else {
		// Logic to disable all the form fields
	}
}

function disableForAuthorisation(pkgServLmtDtlsPrivYN){
	
	if(pkgServLmtDtlsPrivYN == "N") {
		var form = document.getElementById("frmMaintainTreatserv");
		var elements = form.elements;
		for (var i = 0, len = elements.length; i < len; ++i) {
			if(elements[i].id != 'Modify')
				elements[i].disabled = true;
		}
	}	
}

function displayToolTip(discount_string,obj)
{			
	buildTable(discount_string);
	resizeWindow(obj);
}

function buildTable(discount_string)
{
	var Header1_label='Cust Code/Blng Group';
	var Header2_label='Predefined Discount';
	var Header3_label='Adhoc Discount';

	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='1'   class='columnHeader' width='100%' height='100%' align='center'>"
	
	tab_dat		+= "<tr><td class='columnHeader' width='50%'>"+Header1_label+"</td>";
	tab_dat		+= "<td class='columnHeader' width='25%'>"+Header2_label+"</td>";
	tab_dat		+= "<td class='columnHeader' width='25%'>"+Header3_label+"</td></tr>";
	
	
	//discount_string = discount_string + "$";
	//alert(discount_string);
	var discount_string_arr=new Array();
    discount_string_arr=discount_string.split("$~$");
	//alert(discount_string_arr.length);
	for(var i=0;i<discount_string_arr.length-1;i++){
		var discount_string_lcl = discount_string_arr[i].split("~~");
		if(discount_string_lcl[0] != null) {
			var blngGrpCustID=discount_string_lcl[0];
			var preDefinedDisc=discount_string_lcl[1];
			var adhodDisc=discount_string_lcl[2]	;
			//alert(blngGrpCustID+"/"+preDefinedDisc+"/"+adhodDisc);	
			tab_dat     += "<tr>";
			tab_dat     += "<td class='fields' width='20%'>"+blngGrpCustID+"</td>";
			tab_dat     += "<td class='fields' width='20%'>"+preDefinedDisc+"</td>";
			tab_dat     += "<td class='fields' width='20%'>"+adhodDisc+"</td></tr>";		
		}
	}

	
	/* tab_dat     += "<tr>";
	
	//tab_dat     += "<td class='fields' width='20%'>"+strDepAdjust+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strDepAdjust+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strDisAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strBillTotExmtAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strBillTotAdjAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strRoundAmt+"</td>";*/
	//tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
	
	document.getElementById('t').innerHTML = tab_dat;
}


function hideToolTip()	{
	  document.getElementById('tooltiplayer1').style.visibility = 'hidden';
}

async function callAuthForAdhocDiscount()
{	
   if(document.forms[0].patientId.value == "")
	{
	   return;
	}
	var retVal=new Array();
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal = await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);
	document.forms[0].auth_discount.value=retVal;
	if(parent.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		parent.PkgAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;
	}
	if(retVal=="Y"){
	document.forms[0].auth_btn.disabled=true;
	}
}

async function cancelSelectedPackage(count)
{	
	var cancel_chk = document.getElementById("cancel_chk" + count);
	//document.getElementById("cancel_resn" + count).focus();
	var cancel_resn = document.getElementById("cancel_resn" + count);
	var cancel_code = document.getElementById("cancel_code" + count);
	var package_code = document.getElementById("package_code" + count).value;
	var cancelPkgPrivYN = document.getElementById('cancelPkgPrivYN').value;
	var privlege_code = "ALLOW_CANCEL_PACKAGE_MTPKG";
	var hidOPYN = document.getElementById("hidOPYN_" + count).value;	
	var order_catalog_yn = document.getElementById('order_catalog_yn'+count).value;	
	//alert("hid_blng_class_code:"+hidOPYN + "/" + order_catalog_yn);
	if(cancel_chk.checked){
		if(cancelPkgPrivYN == "Y"){
			document.getElementById('cancelPkgPrivYN').value = "Y";
			document.getElementById("hid_cancel_pkg_YN_" + count).value = "Y";
			document.getElementById("button_" + count).disabled = false;
			if(hidOPYN == "Y" && order_catalog_yn == 'Y') {
				document.getElementById("chb_cncl_unprocess_ord_" + count).disabled = false;
				document.getElementById("hid_cncl_unprocess_ord_" + count).value = "N";
			}
			cancel_resn.focus();
		} else {
			var retVal =await authPkgAccessForUser(privlege_code);
			if(retVal=="Y"){
				document.getElementById('cancelPkgPrivYN').value = "Y";
				document.getElementById("hid_cancel_pkg_YN_" + count).value = "Y";
				document.getElementById("button_" + count).disabled = false;
				if(hidOPYN == "Y" && order_catalog_yn == 'Y') {
					document.getElementById("chb_cncl_unprocess_ord_" + count).disabled = false;
					document.getElementById("hid_cncl_unprocess_ord_" + count).value = "N";
				}
				cancel_resn.focus();
			} else {
				alert("User do not have the privilege");
				document.getElementById('cancelPkgPrivYN').value = "N";
				cancel_chk.checked = false;
				document.getElementById("hid_cancel_pkg_YN_" + count).value = "N";
				document.getElementById("button_" + count).disabled = true;
				
				document.getElementById("chb_cncl_unprocess_ord_" + count).checked = false;
				document.getElementById("chb_cncl_unprocess_ord_" + count).disabled = true;
				document.getElementById("hid_cncl_unprocess_ord_" + count).value = "N";
			}			
		}
	} else {
		cancel_chk.checked = false;
		document.getElementById("hid_cancel_pkg_YN_" + count).value = "N";
		document.getElementById("button_" + count).disabled = true;
		
		document.getElementById("chb_cncl_unprocess_ord_" + count).checked = false;
		document.getElementById("chb_cncl_unprocess_ord_" + count).disabled = true;
		document.getElementById("hid_cncl_unprocess_ord_" + count).value = "N";
		cancel_resn.value = "";
		cancel_code.value = "";		
	}
}

async function authPkgAccessForUser(priv_code)
{	
	var retVal='';
	var dialogHeight= "25vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "10" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal = await window.showModalDialog("../../eBL/jsp/PkgAuthoriseMain.jsp?mode=s&priv_code="+priv_code,arguments,features);
	retVal = retVal.split("~");

	if(retVal[0] == "Y") {		
		var usrPrivListForManagePatPack = retVal[1];
		usrPrivListForManagePatPack = usrPrivListForManagePatPack.split("/");
		var authUserID = retVal[2];
		var authReasonCode = retVal[3];
		parent.BLMaintaintreatmentPackage.document.getElementById('calenderPrivileageYN').value = usrPrivListForManagePatPack[0];
		parent.BLMaintaintreatmentPackage.document.getElementById('modifyPractPrivYN').value = usrPrivListForManagePatPack[1];
		parent.BLMaintaintreatmentPackage.document.getElementById('assDeassEncPrivYN').value = usrPrivListForManagePatPack[2];		
		parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscPrivYN').value = usrPrivListForManagePatPack[3];
		parent.BLMaintaintreatmentPackage.document.getElementById('cancelPkgPrivYN').value = usrPrivListForManagePatPack[4];
		parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value = usrPrivListForManagePatPack[5];

		if(parent.BLMaintaintreatmentPackage.document.getElementById('pkgServLmtDtlsPrivYN').value == "Y" && parent.BLMaintaintreatmentPackageserv != null) {
			//alert(parent.BLMaintaintreatmentPackageserv.document.getElementById('Modify').disabled);
			if(parent.BLMaintaintreatmentPackageserv.document.getElementById('Modify') != null && !parent.BLMaintaintreatmentPackageserv.document.getElementById('Modify').disabled)
				parent.BLMaintaintreatmentPackageserv.document.getElementById('Modify').click();
		}
		handleAuthAudit(priv_code, authUserID, authReasonCode, usrPrivListForManagePatPack,"N");		
	}
	return retVal[0];
}

function handleAuthAudit(priv_code, authUserID, authReasonCode, usrPrivListForManagePatPack, isDirectAuth){
	var effDateAuthAllowYN, modPractAuthAllowYN, assDeassEncAuthAllowYN, adhocDiscAuthAllowYN, canPkgAuthAllowYN, modPkgServDtlsAuthAllowYN;
	
	effDateAuthAllowYN = usrPrivListForManagePatPack[0];
	modPractAuthAllowYN = usrPrivListForManagePatPack[1];
	assDeassEncAuthAllowYN = usrPrivListForManagePatPack[2];
	adhocDiscAuthAllowYN = usrPrivListForManagePatPack[3];
	canPkgAuthAllowYN = usrPrivListForManagePatPack[4];
	modPkgServDtlsAuthAllowYN = usrPrivListForManagePatPack[5];

	if(effDateAuthAllowYN == "Y"){
		parent.BLMaintaintreatmentPackage.document.getElementById('effDateAuthStr').value = authUserID + "##" + authReasonCode + "##" + isDirectAuth;
	}
	if(assDeassEncAuthAllowYN == "Y"){
		parent.BLMaintaintreatmentPackage.document.getElementById('assDeassAuthStr').value = authUserID + "##" + authReasonCode + "##" + isDirectAuth;
	}
	if(adhocDiscAuthAllowYN == "Y"){
		parent.BLMaintaintreatmentPackage.document.getElementById('adhocDiscAuthStr').value = authUserID + "##" + authReasonCode + "##" + isDirectAuth;
	}
	if(canPkgAuthAllowYN == "Y"){
		parent.BLMaintaintreatmentPackage.document.getElementById('cnclPackAuthStr').value = authUserID + "##" + authReasonCode + "##" + isDirectAuth;
	}
	if(modPkgServDtlsAuthAllowYN == "Y"){
		parent.BLMaintaintreatmentPackage.document.getElementById('pkgServDtlsAuthStr').value = authUserID + "##" + authReasonCode + "##" + isDirectAuth;
	}		
}

function cancelUnprocessOrd(count)
{
	var cancel_chk = document.getElementById("cancel_chk" + count).checked;
	var chb_cncl_unprocess_ord = document.getElementById("chb_cncl_unprocess_ord_" + count).checked;	
	
	if(chb_cncl_unprocess_ord){
		document.getElementById("hid_cncl_unprocess_ord_" + count).value = "Y";
	} else {
		document.getElementById("hid_cncl_unprocess_ord_" + count).value = "N";
	}

}

async function chkPrivForEffDateChange(obj,format1, format2){

	var calenderPrivileageYN = document.getElementById('calenderPrivileageYN').value;
	var flag = true;
	
	if(calenderPrivileageYN != "Y") {
		var retVal = await authPkgAccessForUser("MODIFY_EFF_FROM_MTPKG");
		if(retVal == "Y"){
			document.getElementById('calenderPrivileageYN').value = "Y";
			flag = true;
		} else {
			alert("User do not have the privilege");
			flag = false;
			return false;
		}		
	}
	
	if(flag == true) {
		var cal_ret_value =await showCalendar(obj,format1, format2);
		//return showCalendar('eff_from_date<%=count%>','dd/mm/yyyy','hh:mm:ss')
	}
}

async function funAuthReasonLkup()
{
	var dialogTop			= "10";
	var dialogHeight		= "60vh" ;
	var dialogWidth			= "50vw" ;
	var features			= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ListOfRemarks.label","BL"); 
	title=encodeURIComponent(title);
	var column_sizes = escape("70%,30%");               
	var remarks=getLabel("eBL.Remarks.label","common");
	cashcntrcode=encodeURIComponent(remarks);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var column_descriptions = desc+","+remarks;
	var locale = document.getElementById('locale').value;
	var sql = "" ; 
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"&srch_by_clmn_index=2"+"&col_show_hide=YY"+"&called_for=PACKAGE_AUTH_REASON_LKUP&locale="+locale+"&target="+document.getElementById("auth_resn").value;
	
	retVal= await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
		
	if (retVal != null || retVal!='')
	{	
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.getElementById("auth_resn").value=arr[0];
			document.getElementById("auth_resn_code").value=arr[1];			
		} else {
			alert("Please select the authorisation reason");
			document.getElementById("auth_resn").focus();	
		}
			
	} else {
		alert("Please select the authorisation reason");
		document.getElementById("auth_resn").focus();	
	}
}

function chkPatIfAnyJobRunning(patid){   
	var facility_id=document.getElementById("facility_id").value;
	var userid=document.getElementById("userid").value;
	var wsno=document.getElementById("ws_no").value;

	var URL = "../../eBL/jsp/MaintainTreatServValidation.jsp?func_mode=PAT_RECAL_JOB_CHK&facility_id="	+ facility_id + "&patid=" + patid + "&userid=" + userid + "&wsno=" + wsno;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", URL, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);

	return responseText;
}


function recalcPkgJobCall(patientID) {
	var URL = "../../eBL/jsp/MaintainTreatServValidation.jsp?func_mode=POST_JOB_FOR_PACK_RECALC&patid="+patientID ;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", URL, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);
	
	return responseText;
}

function resizeWindow(obj)
{
    var obj1 = obj.id;
	
	var wdth = parent.BLMaintaintreatmentPackage.document.getElementById(obj1).offsetWidth;
	var hght1 = parent.BLMaintaintreatmentPackage.document.getElementById(obj1).offsetHeight;		
	var wdth1 = getPos(obj).x +wdth;
	var hght = getPos(obj).y ;	
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById('tooltiplayer1').offsetWidth);
	y 	  = hght + (document.getElementById('tooltiplayer1').offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(obj).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById('tooltiplayer1').offsetHeight*2) + hght1 ;	
	}

	document.getElementById('tooltiplayer1').style.posLeft= x;
	document.getElementById('tooltiplayer1').style.posTop = hght;
	document.getElementById('tooltiplayer1').style.visibility='visible';
}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
		
        if(targetElement.x && targetElement.y){
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                // alert("Could not find any reference for coordinate
				// positioning.");
            }
        }
        return coords;
    } catch(error) {
        // alert(error.msg);
        return coords;
    }
}

//V240131
function isValidEffFromDtChange(count){
	
	var effFromDate=eval(document.getElementById("eff_from_date"+count)).value;
	var encounterDate = eval(document.getElementById("encounterDt"+count)).value;
	effFromDate=effFromDate.substring(0,10);
	encounterDate=encounterDate.substring(0,10);
	var effFrmDate = effFromDate.split("/");
	var encDate = encounterDate.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(effFrmDate[2], effFrmDate[1]-1, effFrmDate[0]);//subs date
	enddt.setFullYear(encDate[2], encDate[1]-1, encDate[0]);//encounter date 
	//if(isBefore(effFromDate,encounterDate, "DMY" , 'en') && isAfter(encounterDate, effFromDate, 'DMY', 'en')){ 
	if(enddt>startdt){//subs date<enc
		alert(getMessage("BL0768","BLEXT"));
		eval(document.getElementById("eff_from_date"+count)).value='';
		return false;
    }else{
    	return true;
    }
	
}

//V240131
function dateDisplay(rec_count,effToDate)
{
	document.getElementById("eff_to_date" + rec_count).value=effToDate;
}

//V240131
function callEffToDtChange(rec_count,function_id){
	

	var pkg_valid_days = document.getElementById("pkg_valid_days" + rec_count).value;
	var  selDate=eval(document.getElementById("eff_from_date"+rec_count)).value;
	selDate=selDate.substring(0,19);

	var result=isValidDateTime(eval(document.getElementById("eff_from_date"+rec_count)));
	if(result==false){
		eval(document.getElementById("eff_from_date"+rec_count)).value='';
		return false;
	}
	
	if(function_id=="EBL_TRAN_PACKAGE_MAINTAIN")
	{	
		var temp_jsp="MaintainTreatHdrValidation.jsp?function_id="+function_id+"&rec_count="+rec_count+"&subsFromDate="+selDate+"&pkg_valid_days="+pkg_valid_days;	
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var retVal = trimString(xmlHttp.responseText);
		
		dateDisplay(rec_count,retVal);
		return true;	
		
	}
}

//V240131
function callEffFrmDtValidation(obj,rec_count)
{
	if(obj.value == "")
		document.getElementById("eff_from"+rec_count).click();
}