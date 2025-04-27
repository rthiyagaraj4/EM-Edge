//saved 0n 22/10/2005
//This array is used to store scheduledyn for frequency codes
schedulearr=new Array();
freqnaturearr=new Array();
function error(){
	//alert(getMessage("PH_ORDER_CATALOG"));
	//history.back();
}

function frequencySelect(obj){
	//called on change of frequency -list box
	schyn	=schedulearr[obj.value];
	freqtype=freqnaturearr[obj.value];
	
	frmobj=document.TpnAdmin;
	if (schyn=='Y'){   
		if(frmobj.schedulemed!=undefined)
		frmobj.schedulemed.disabled=false;
	}
	else{
		if(frmobj.schedulemed!=undefined)
		frmobj.schedulemed.disabled=true;
	}
	if (freqtype=='O'){
		frmobj.duration.disabled	=true;
		frmobj.duration.value		=1;
		CheckMaxDuration(frmobj.duration);
	}
	else{
		frmobj.duration.disabled=false;
	}
	if(frmobj.schedulemed!=undefined){
	frmobj.schedulemed.checked	=false;}
	frmobj.freqNature.value			=freqtype;
}

function enableAll(){
	// to enable all fields, after choosing a valid regimen
	frmobj	=document.TpnAdmin;
	frmobj.infroute.disabled			=false;
	frmobj.volume.disabled			=false;
	frmobj.infuseover.disabled		=false;
	frmobj.infuseoverdrn.disabled	=false;
	frmobj.frequency.disabled		=false;
	frmobj.duration.disabled			=false;
	document.getElementById("remarks").disabled=false;
	frmobj.startdate.disabled		=false;
}

function disableAll(frm,doc){
	//called if the user clears the value in the regimen name textbox and blurs out
	if (typeof(frm)=="object"){
		frmobj=frm;
	}
	else{
		frmobj	=document.TpnAdmin;
		doc		=document;
	}
	frmobj.infroute.disabled			=true;
	frmobj.volume.disabled				=true;
	frmobj.infuseover.disabled			=true;
	frmobj.infuseoverdrn.disabled		=true;
	frmobj.frequency.disabled			=true;
	frmobj.duration.disabled			=true;
	doc.remarks.disabled			=true;
	frmobj.schedulemed.disabled			=true;
	frmobj.startdate.disabled			=true;
	frmobj.enddate.disabled				=true;
}

function hideAllLinks(doc){
	// to hide links for cosign, auth etc..called from temporary jsp
	if (typeof(doc)=="object"){
		doc.AuthReqd.style.visibility		="hidden";
		doc.CosignReqd.style.visibility		="hidden";
		doc.SplAppReqd.style.visibility		="hidden";
		doc.ConsentReqd.style.visibility	="hidden";
	}
	else{
		document.getElementById("AuthReqd").style.visibility		="hidden";
		document.getElementById("CosignReqd").style.visibility	="hidden";
		document.getElementById("SplAppReqd").style.visibility	="hidden";
		document.getElementById("ConsentReqd").style.visibility	="hidden";
	}
}
function showLink(linkname){
	// to show  links for cosign, auth etc..called from temporary jsp
	document.getElementById(linkname).style.visibility		="visible";
}

function defaultFrequency(freqcode){
	frmobj=document.TpnAdmin;
	obj=frmobj.frequency;
	for (i=0;i<obj.options.length;i++ ){
		optobj=obj.options[i];
		if (optobj.value==freqcode){
			obj.selectedIndex=i;
		}
	}
	frequencySelect(obj);
}

function DateFormatCheck(obj,locale){
	/*res=doDateTimeChk(obj); // commented for [IN:031523] Start
	if (res==false){
		alert(getMessage("INVALID_DATE_TIME","PH"));
	}*///commented for INC: [31523] End

	if(obj.value != ""){ // Added for [IN:031523]- Start
		if(!validDate(obj.value,"DMYHM",locale)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.select();
			obj.focus();
			return false;
		}
	} // Added for [IN:031523] - end
}

function CheckMaxDuration(obj){
	frmobj			=document.TpnAdmin;
	maxdurn		=parseInt(frmobj.max_duration.value);
	durn				=parseInt(obj.value);
	document.getElementById("DurnApproval").style.visibility="hidden";
	if (durn>maxdurn){
		//Check for the msg type if error/warning/or approval reqd
		msgtype= frmobj.action_type.value;
		msg		= frmobj.action_msg.value;
		if (msgtype=='E'){
			alert(msg+getLabel("ePH.CannotProceed.label","PH"));
			obj.focus();
		}
		else if (msgtype=='W'){
			alert(getLabel("Common.Warning.label","Common")+"!! "+msg);
		}
		else if(msgtype=='A'){
			alert(msg);
			document.getElementById("DurnApproval").style.visibility="visible";
		}
	}
	//Calculate End date here
	 CalculateEndDate(frmobj);
}

async function displaySchedule(obj) {
	if (obj.checked) {
		var formObj						= document.TpnAdmin;
		var split_qty						=formObj.volume.value;
	
		var code							= formObj.Regimen_Code.value;
		var bean_id						= formObj.bean_id.value;
		var bean_name					= formObj.bean_name.value;
		var freq_code					= formObj.frequency.value;
		var drug_code					= '';
		var fluid_frame_display_yn = "N";
		var facility_id						= parent.parent.parent.parent.f_header.document.prescription_header_form.facility_id.value;
		var max_qty						= 0;
		var  unit_qty						="" ;
		var  split_dose_yn				= "N";
		var qty_reqd_yn					= "N";
		var chk_max						= "N";
		var chk_unit						= "N";
		var uom_desc					=document.getElementById("volumeunit").innerText;
		uom_desc=encodeURIComponent(uom_desc,"UTF-8");
		var row_value					= "1";

		var dialogTop						= "";
		var dialogHeight					= "34vh";
		var dialogWidth					= "48vw";
		var features						= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments					= "";
		var retVal 							= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH",arguments,features);
		if (typeof(retVal)=="string"){
			document.TpnAdmin.frequency.disabled=true;
			makeLink(1);
		}
	}
	else{
		document.TpnAdmin.frequency.disabled=false;
		makeLink(0);
	}
} 
function makeLink(a){
	//this fucntion is used to toggle the link status of schedule medication 
	if (a==0){
		document.getElementById("scmed").innerText=getLabel("ePH.ScheduleMedication.label","PH");
	}
	else if (a==1){
		document.getElementById("scmed").innerHTML="<a href='javascript:displaySchedule(document.TpnAdmin.schedulemed)'>"+getLabel("ePH.ScheduleMedication.label","PH")+"</a>"
	}
}
function CalculateEndDate(frmobj){
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;

	sdate	=frmobj.startdate.value;
	durn	=frmobj.duration.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr				="<root><SEARCH " ;
	xmlStr			  +="tmp"+"=\""+ "tmp" +"\" " ;
	xmlStr			  +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?action=CALCULATEENDDATE&bean_id=" + bean_id + "&bean_name=" + bean_name +"&sdate="+sdate+"&duration="+durn, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
/* The functions are for calling the remarks */

function getFormatId(click_yn) {// click_yn added for [IN:039576]
	var formObj			= "";
	var drug_code		= "";
	
	formObj=document.TpnAdmin;

	var order_type		= formObj.ordertype_code.value;
	var drug_code		= formObj.Regimen_Code.value;
	var form_code		= "";
	var route_code		= "";
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var patient_id			= formObj.patient_id.value;
	var encounter_id	= formObj.encounter_id.value;
	var ordertypecode	= formObj.ordertype_code.value;
	
	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?order_type="+ordertypecode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=REMARKS&bean_id=" + bean_id + "&bean_name=" + bean_name +"&order_type="+order_type+"&drug_code="+drug_code+"&form_code="+form_code+"&route_code="+route_code+"&click_yn="+click_yn, false ) // click_yn added for [IN:039576]
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function validateRemarks(format_id,click_yn)	{// click_yn added for [IN:039576]
	var format	= format_id.split("~");
	formatId	= format[1];
	//added for [IN:039576]-start
	var mandatory	=	format[0];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
	document.TpnAdmin.DrugRemarksMandImg.style.display = 'none';
	document.TpnAdmin.DrugRemarksMandatory.value =mandatory;//added for [IN:039576]-end
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		document.TpnAdmin.remarks.style.display = 'none';
	else{
		document.TpnAdmin.remarks.style.display = 'inline';
		if(mandatory == 'Y'){//added for [IN:039576]
			document.TpnAdmin.DrugRemarksMandImg.style.display = 'inline';
		}
	}
	//added for SKR-SCF-0140 -end
	if(click_yn=='Y')//added for [IN:039576]
		callOrder();
}

function callOrder() {
	var vals = "";
	var drug_code = "";
	var frmObj = "";
	formObj=document.TpnAdmin;
	var drug_code		= formObj.Regimen_Code.value;
	callRemarks(formObj, formatId, drug_code, 'PH', '0', 'PH', vals);
}

async function callRemarks(frmObj, format_id, catalog_code, order_category, row_value, called_from, pres_vals) {
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	DrugRemarksEntered	=frmObj.DrugRemarksEntered.value; //added for [IN:039576]
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";
	var dialogHeight= "40vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "169";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&catalog_code="+catalog_code+"&order_category="+order_category+"&row_value=0&called_from=PH&ph_list_vals="+pres_vals,arguments,features);
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
			frmObj.DrugRemarksEntered.value = 'Y'
	}
}

/*End of function for calling remarks */
function Authorize(obj){
	str=obj.innerText;
	if (str.indexOf('Authorized')!=-1){
		return;
	}
	else{
		if(confirm(getMessage("PH_AUTHAPPROVE_1","PH"))){
			frmobj				=document.TpnAdmin;
			obj.innerHTML	="<img src='../../eOR/images/Authorized.gif'>"+getLabel("Common.Authorized.label","Common");
			obj.className	="label";
			frmobj.authorizedYN.value="Y";
		}
	}
}

function Cosign(obj){
	str=obj.innerText;
	if (str.indexOf('Cosigned')!=-1){
		return;
	}
	else{
		if (confirm(getMessage("PH_AUTHAPPROVE_3","PH"))){
			frmobj							=document.TpnAdmin;
			obj.innerHTML				="<img src='../../eOR/images/Cosign.gif'>"+getLabel("ePH.Cosigned.label","PH");
			obj.className				="label";
			frmobj.cosignedYN.value="Y";
		}
	}
}	

function SplApprove(obj){
	str=obj.innerText;
	if (str.indexOf('Approved')!=-1){
		return;
	}
	else{
		if (confirm(getMessage("PH_AUTHAPPROVE_2","PH"))){
			frmobj=document.TpnAdmin;
			obj.innerHTML				="<img src='../../eOR/images/SpecialApproval_click.gif'>"+getLabel("ePH.SpeciallyApproved.label","PH");
			obj.className				="label";
			frmobj.splappedYN.value="Y";
		}
	}
}	

function callCancel(){
	if(parent.parent.parent.parent.criteriaCategoryButtonFrame!= undefined){
		parent.parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
	}
	else{
		window.close();
	}
}
 
function standarRegimcheck(encounter_id){
	 
	var bean_id="TPNNonStandardRegimenBean";
	var bean_name="ePH.TPNNonStandardRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNRegNonStdRegTemporary.jsp?encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&action=NONACCESSIONNUMBER",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
 }

function CheckAccessionNumber(accession_num,tpn_screening_type){
	apply1(accession_num,tpn_screening_type)
}
function beforNonDiscrete(test_observ_dt_tm,tpn_screening_type){
	apply1(test_observ_dt_tm,tpn_screening_type)
}

function NonstandarRegimDiscrete(encounter_id){
	var bean_id="TPNNonStandardRegimenBean";
	var bean_name="ePH.TPNNonStandardRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNRegNonStdRegTemporary.jsp?encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&action=NONDISCRETE",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
 }

 function apply(encounter_id,tpn_screening_type){	 
	   	  
	if(tpn_screening_type=="N"){
		standarRegimcheck(encounter_id);
	}
	else if(tpn_screening_type=="D"){
		NonstandarRegimDiscrete(encounter_id);
	}
	else if(tpn_screening_type==""){
	   
		var frmobj				=parent.ShowDetailFrame.RightFrame.document.TpnAdmin;
		var patient_id			=frmobj.patient_id.value;
		var encounter_id	=frmobj.encounter_id.value;
		var bean_id			=frmobj.bean_id.value;
		var bean_name		=frmobj.bean_name.value;
		var drug_code		=frmobj.Regimen_Code.value;
		var high_carbo_concentration=frmobj.high_carbo_concentration.value;
		var infusion_line=frmobj.infroute.value;
		var carbohydrate_value				=parent.ShowDetailFrame.LeftFrame.document.TpnShowDetails.carbohydrate_value.value;
		var doc				=parent.HeaderFrame.document; 
		var drugRemarksMandatory = frmobj.DrugRemarksMandatory.value;//added for [IN:039576]
		var drugRemarksEntered		 = frmobj.DrugRemarksEntered.value;//added for [IN:039576]
		var tpn_standard_non_standard = "";// added for ML-MMOH-CRF-1012 - Start
		if(frmobj.tpn_standard_non_standard!=undefined){
			tpn_standard_non_standard = frmobj.tpn_standard_non_standard.value;
		}// added for ML-MMOH-CRF-1012 - End
		frmobj.Regimen_Desc.value = doc.TpnNonStandardRegimen.stdregimen.value;

		if ( (carbohydrate_value=="")||((carbohydrate_value=="0"))){
			carbohydrate_value="";
		}

		if ( (doc.TpnNonStandardRegimen.volume.value=="")||((doc.TpnNonStandardRegimen.volume.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.volume.focus();
			return;
		}
		if ( (frmobj.duration.value=="")||((frmobj.duration.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.duration.focus();
			return;
		}
		if ( (frmobj.frequency.value=="")||((frmobj.frequency.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.frequency.focus();
			return;
		}
		//added for ML-MMOH-CRF-1012 strat
		if (tpn_standard_non_standard=="true") {
			if (frmobj.total_daily_fluid.value == "") {
				alert(getMessage("PH_MANDATORY", "PH"));
				frmobj.total_daily_fluid.focus();
				return;
			}
			if (frmobj.enteral_feeding.value == "") {
				alert(getMessage("PH_MANDATORY", "PH"));
				frmobj.enteral_feeding.focus();
				return;
			}
		}
		//added for ML-MMOH-CRF-1012 end
		if (doc.TpnNonStandardRegimen.stdregimen.value==""){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.stdregimen.focus();
			return;
		}

		if (doc.TpnNonStandardRegimen.stdregimen.value==""){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.stdregimen.focus();
			return;
		}
		if(infusion_line=="P"){
			var concenVal=parseFloat(((parseFloat(carbohydrate_value) * 100))/ parseFloat(doc.TpnNonStandardRegimen.volume.value));
			if (concenVal > parseFloat(high_carbo_concentration)){
				if(!confirm(getMessage("PH_TPN_ORDER_CARBO_HIGH","PH"))){
					return;
				}
			}
		}
		if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){//if block added for [IN:039576]
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			frmobj.remarks.click();
			return false;
		}
		frmobj.volume.value=doc.TpnNonStandardRegimen.volume.value;
		frmobj.volumeunit.value= doc.TpnNonStandardRegimen.volumeunit1.value;
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code, false ) 
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	   
		//eval(responseText);
		eval(formApply(frmobj, PH_CONTROLLER) ) ;
		if(result)
			onSuccess(frmobj,doc);
		else
			alert(message);
	}//end else
}	

function apply1(accession_num,tpn_screening_type){
	
	var frmobj				=parent.ShowDetailFrame.RightFrame.document.TpnAdmin;
	if(tpn_screening_type!=''){
		if(accession_num!=''){
			var patient_id			=frmobj.patient_id.value;
			var encounter_id	=frmobj.encounter_id.value;
			var bean_id			=frmobj.bean_id.value;
			var bean_name		=frmobj.bean_name.value;
			var drug_code		=frmobj.Regimen_Code.value;
			var high_carbo_concentration=frmobj.high_carbo_concentration.value;
			var infusion_line=frmobj.infroute.value;
			var carbohydrate_value				=parent.ShowDetailFrame.LeftFrame.document.TpnShowDetails.carbohydrate_value.value;
			var doc				=parent.HeaderFrame.document; 
			frmobj.Regimen_Desc.value = doc.TpnNonStandardRegimen.stdregimen.value;

			if ( (carbohydrate_value=="")||((carbohydrate_value=="0"))){
				carbohydrate_value="";
			}

			if ( (doc.TpnNonStandardRegimen.volume.value=="")||((doc.TpnNonStandardRegimen.volume.value=="0"))){
				alert(getMessage("PH_MANDATORY","PH"));
				doc.TpnNonStandardRegimen.volume.focus();
				return;
			}
			if ( (frmobj.duration.value=="")||((frmobj.duration.value=="0"))){
				alert(getMessage("PH_MANDATORY","PH"));
				frmobj.duration.focus();
				return;
			}
			if ( (frmobj.frequency.value=="")||((frmobj.frequency.value=="0"))){
				alert(getMessage("PH_MANDATORY","PH"));
				frmobj.frequency.focus();
				return;
			}
			
			if (doc.TpnNonStandardRegimen.stdregimen.value==""){
				alert(getMessage("PH_MANDATORY","PH"));
				doc.TpnNonStandardRegimen.stdregimen.focus();
				return;
			}

			if (doc.TpnNonStandardRegimen.stdregimen.value==""){
				alert(getMessage("PH_MANDATORY","PH"));
				doc.TpnNonStandardRegimen.stdregimen.focus();
				return;
			}
			if(infusion_line=="P"){
				var concenVal=parseFloat(((parseFloat(carbohydrate_value) * 100))/ parseFloat(doc.TpnNonStandardRegimen.volume.value));

				if (concenVal > parseFloat(high_carbo_concentration)){
					if(!confirm(getMessage("PH_TPN_ORDER_CARBO_HIGH","PH"))){
						return;
					}
				}
			}
			frmobj.volume.value=doc.TpnNonStandardRegimen.volume.value;
			frmobj.volumeunit.value= doc.TpnNonStandardRegimen.volumeunit1.value;
			var xmlDoc	= "";
			var xmlHttp	= new XMLHttpRequest();
			xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code, false ) 
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			eval(formApply(frmobj, PH_CONTROLLER) ) ;
			if(result)
				onSuccess(frmobj,doc);
			else
				alert(message);
		}
		else{
			 alert(getMessage('SCREENIN_GDETAILS','PH'));
		   }
    }
	else{
		var patient_id			=frmobj.patient_id.value;
		var encounter_id	=frmobj.encounter_id.value;
		var bean_id			=frmobj.bean_id.value;
		var bean_name		=frmobj.bean_name.value;
		var drug_code		=frmobj.Regimen_Code.value;
		var high_carbo_concentration=frmobj.high_carbo_concentration.value;
		var infusion_line=frmobj.infroute.value;
		var carbohydrate_value				=parent.ShowDetailFrame.LeftFrame.document.TpnShowDetails.carbohydrate_value.value;
		var doc				=parent.HeaderFrame.document; 
		frmobj.Regimen_Desc.value = doc.TpnNonStandardRegimen.stdregimen.value;

		if ( (carbohydrate_value=="")||((carbohydrate_value=="0"))){
			carbohydrate_value="";
		}

		if ( (doc.TpnNonStandardRegimen.volume.value=="")||((doc.TpnNonStandardRegimen.volume.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.volume.focus();
			return;
		}
		if ( (frmobj.duration.value=="")||((frmobj.duration.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.duration.focus();
			return;
		}
		if ( (frmobj.frequency.value=="")||((frmobj.frequency.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.frequency.focus();
			return;
		}
		
		if (doc.TpnNonStandardRegimen.stdregimen.value==""){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.stdregimen.focus();
			return;
		}

		if (doc.TpnNonStandardRegimen.stdregimen.value==""){
			alert(getMessage("PH_MANDATORY","PH"));
			doc.TpnNonStandardRegimen.stdregimen.focus();
			return;
		}
		if(infusion_line=="P"){
			var concenVal=parseFloat(((parseFloat(carbohydrate_value) * 100))/ parseFloat(doc.TpnNonStandardRegimen.volume.value));
			if (concenVal > parseFloat(high_carbo_concentration)){
				if(!confirm(getMessage("PH_TPN_ORDER_CARBO_HIGH","PH"))){
					return;
				}
			}
		}
		frmobj.volume.value=doc.TpnNonStandardRegimen.volume.value;
		frmobj.volumeunit.value= doc.TpnNonStandardRegimen.volumeunit1.value;
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code, false ) 
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		eval(formApply(frmobj, PH_CONTROLLER) ) ;
		if(result)
			onSuccess(frmobj,doc);
		else
			alert(message);
   }//end else
}

function assignResult( result1, message1, flag1 ,temp) {
	result		= result1 ;
    message	= message1 ;
    flag			= flag1 ;
}

function onSuccess(frmobj,doc){
	re = /<br>/i;
	message=message.replace(re,"");
	alert(message);

   	var encounter_id	=frmobj.encounter_id.value;
	var patient_id		=frmobj.patient_id.value;
	var bean_id			=frmobj.bean_id.value;
	var bean_name		=frmobj.bean_name.value;
	var drug_code		=frmobj.Regimen_Code.value;
	var print_ord_sht_rule_ind=frmobj.print_ord_sht_rule_ind.value;//Added for Bru-HIMS-CRF-393_1.0
	// For Clearing Bean Values ========

	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
	
	//return;
	xmlHttp.open( "POST", "TPNNonRegStdRegTemporary.jsp?Mode=ClearBean&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) 

	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	// Clearing Bean end ===========
	//var print_confirm=confirm(getMessage("DO_WANT_PPRINT_PRESCRIPTION","PH"))//Commented for Bru-HIMS-CRF-393_1.0
	//Added for Bru-HIMS-CRF-393_1.0-Start
	var print_confirm="";
	if(print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='')//print_ord_sht_rule_ind=='' Added for Inc:049877
		print_confirm=confirm(getMessage("DO_WANT_PPRINT_PRESCRIPTION","PH"))
	else if(print_ord_sht_rule_ind=="S")
		print_confirm="true"; //Added for Bru-HIMS-CRF-393_1.0-End
//	var print_confirm=confirm("Do you want to print the Prescription")
	if(print_confirm){
		callReport(frmobj);
	}
	callCancel();
}

function hideAllDivs(docobj){
	docobj.MN.style.display	="none";
	docobj.EL.style.display	="none";
	docobj.TR.style.display	="none";
	docobj.VT.style.display	="none";
	docobj.OT.style.display	="none";
}

function showDiv(divid,doc){ 
	hideAllDivs(eval(doc));
	parent.ButtonFrame.document.TpnButtons.Cancel.disabled=true;
	parent.ButtonFrame.document.TpnButtons.Release.disabled=true;
	parent.FrmSet.rows							='46,*,0%,12%';
    doc.divid.style.display		="inline";
//	ChangeReleaseButtonStatus(parent.ButtonFrame.document.TpnButtons,true);
}

function adminDetails(docstring,params){      	
	doc=eval(docstring)
	//we have to first populate all the values entered in the bean and then call the admindetails frame page
	populatebean(doc);
	parent.ButtonFrame.document.TpnButtons.Cancel.disabled=false;
	parent.ButtonFrame.document.TpnButtons.Release.disabled=false;
	parent.FrmSet.rows						   ='45,0%,*,12%';
	
	infroute1=document.TpnNonStandardRegimen.infroute1.value;
	infusevalue1=document.TpnNonStandardRegimen.infusevalue1.value;
	durnvalue1=document.TpnNonStandardRegimen.durnvalue1.value;
	startdate1=document.TpnNonStandardRegimen.startdate1.value;
	end_date1=document.TpnNonStandardRegimen.end_date1.value;
	
	params=params+"&infroute1="+infroute1+"&infusevalue1="+infusevalue1+"&durnvalue1="+durnvalue1+"&startdate1="+startdate1+"&end_date1="+end_date1;
	if(document.TpnNonStandardRegimen.order_id != null)
		orderid=document.TpnNonStandardRegimen.order_id.value;
	else
		orderid="";
	parent.ShowDetailFrame.location.href ="../../ePH/jsp/TPNRegNonStdRegAdminFrame.jsp?orderid="+orderid+"&"+params;
}
 
function changeInfusion(obj){
	parent.parent.HeaderFrame.document.TpnNonStandardRegimen.infroute1.value=obj.value;
}

function checkInfuseValue(infusevalue){
	parent.parent.HeaderFrame.document.TpnNonStandardRegimen.infusevalue1.value=infusevalue.value;
}

function checkDuration1(duration,enddate){
	parent.parent.HeaderFrame.document.TpnNonStandardRegimen.durnvalue1.value=duration.value;
	parent.parent.HeaderFrame.document.TpnNonStandardRegimen.end_date1.value=enddate.value;
 }

 function checkTpnDate(startdate,enddate){
	 parent.parent.HeaderFrame.document.TpnNonStandardRegimen.startdate1.value=startdate.value;
	 parent.parent.HeaderFrame.document.TpnNonStandardRegimen.end_date1.value=enddate.value;
 }

function populatebean(doc){	
	frmobj					=doc.TpnNonStandardRegimen;  
	
	var bean_id			= frmobj.bean_id.value; 
	var bean_name		= frmobj.bean_name.value ;
	var ncp_n_val       = frmobj.NPC_N_val.value;
	
	var genarray			=new Array();
	var qtyarray			=new Array();
	var unitarray			=new Array();
	var calcarray			=new Array();
	var descarray		=new Array();
	var groupcodearray=new Array();
	var ovrridereasonarray=new Array();
	var prefdrugarray=new Array();
	
	//create the array of generics,quantity,uom and calculated value
	totalrows				=frmobj.totalrows.value;

	for (i=1;i<=totalrows;i++ ){ 
		codeobj			=eval("frmobj.CODE_"+i);
		descobj			=eval("frmobj.DESC_"+i);
		groupcodeobj	=eval("frmobj.GROUPCODE_"+i);
		qtyobj			=eval("frmobj.QVALUE_"+i);
		unitobj			=eval("doc.QUNIT_"+i);
		calcobj			=eval("doc.QCALC_"+i);
		reasonobj			=eval("doc.OVERRIDE_"+i);
		
		if((eval("doc.ITEMFLUID_"+i)))
		prefdrugobj			=eval("doc.ITEMFLUID_"+i);
        //alert(codeobj.value);
		genarray[i-1]				=codeobj.value;
		descarray[i-1]			    =descobj.value;
		qtyarray[i-1]				=qtyobj.value==""?0:qtyobj.value;
		unitarray[i-1]				=unitobj.value==""?'tmp':unitobj.value;
		calcarray[i-1]				=calcobj.value==""?"":calcobj.value;
		groupcodearray[i-1]			=groupcodeobj.value;
		ovrridereasonarray[i-1]		=reasonobj.value==""?"N":reasonobj.value;
		
		if((eval("doc.ITEMFLUID_"+i))){
		    prefdrugarray[i-1]			=prefdrugobj.value;
		    if(prefdrugarray[i-1]=="")
				prefdrugarray[i-1]=" ";
		}
		else
            prefdrugarray[i-1]			=" ";
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr				="<root><SEARCH " ;
	xmlStr			  +="tmp"+"=\""+ "tmp" +"\" " ;
	xmlStr			  +=" /></root>" ;
   
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?action=STOREVALUES&bean_id=" + bean_id +  "&bean_name=" + bean_name +"&genarray="+genarray+"&qtyarray="+qtyarray+"&unitarray="+unitarray+"&calcarray="+calcarray+"&descarray="+descarray+"&groupcodearray="+groupcodearray+"&ovrridereasonarray="+ovrridereasonarray+"&prefdrugarray="+prefdrugarray+"&ncp_n_val="+ncp_n_val, false ) ; 
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function decolorTabs(){
	cellref=document.getElementById("tabs").rows[0].cells
	for (i=0;i<cellref.length ;i++ ){
		cellref[i].style.backgroundColor="#FFD7D7"
	}
}

function colorTabs(objstr){
	obj	=eval(objstr);
	decolorTabs();
	obj.style.backgroundColor	="#FFA6A6";
}

async function CheckRange(obj,no,aborwt,wt){
  
	frmobj	=document.TpnNonStandardRegimen;
	if ( (obj.value==0)||(obj.value=="")){
		obj.value='';
		calcobj=document.getElementById("QCALC_"+no);
		calcobj.value="";
		return;
	}
	
	min		=eval("frmobj.QMIN_"+no).value;
	max		=eval("frmobj.QMAX_"+no).value;
	ceil    =eval("frmobj.CEIL_"+no).value;
	group   =eval("frmobj.CODE_"+no).value;
	
	if(aborwt=="W" || aborwt=="w" ){
	
		min = roundTwoDigits(min * wt);
		max = roundTwoDigits(max * wt);
		if(ceil!=""){
			ceil = roundTwoDigits(ceil * wt);
		}
	}
	var volm =parent.HeaderFrame.document.TpnNonStandardRegimen.volume.value
	if(aborwt=="P" || aborwt=="p" ){
		min = roundTwoDigits((min * volm )/1000);
		max = roundTwoDigits((max * volm)/1000);
		if(ceil!=""){
			ceil = roundTwoDigits((ceil * volm)/1000);
		}
	}
	
	if (min==""){
		min	=0;
	}
	if (max==""){
		max	=100;
	}
	// check for values between range
	
	if(ceil!=""){
	
    if ( (parseFloat(obj.value)>max)&&(parseFloat(obj.value)<=ceil)){ 
		mode=document.TpnNonStandardRegimen.mode.value;
		//var res="The value should be in the range of "+min+" and "+max+" !!!";
		var res=getLabel("ePH.TheValueshouldbeintherangeof.label","PH")+min+getLabel("Common.and.label","Common")+max+" !!!";

		var dialogHeight	= '40vh' ;
		var dialogWidth 	= '50vw' ;
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		hdg_name			= "";
		if(mode=='amend')
			var reason=eval("document.TpnNonStandardRegimen.OVERRIDE_"+no).value;
		else
			reason="";
		var retVal 				= await window.showModalDialog("../../ePH/jsp/TPNConstGenericOverrideReason.jsp?hdg_name="+hdg_name+"&rowno="+no+"&override=override"+"&group="+group+"&alert="+res+"&reason="+reason,arguments,features);
			
		if(retVal!=undefined){
			var  retValArr					= retVal.split("||");
			retValue						= retValArr[1];
			eval("document.TpnNonStandardRegimen.OVERRIDE_"+no).value = retValue;
			cmts_value_entered_yn  = retValArr[0]; 
			calculateValue(frmobj,no,obj.value);
		}
		else{
			retValue=""
			//window.close();
		}
		if(trimCheck(retValue)!=""){
			eval("document.getElementById("overrid")"+no).style.visibility ="visible";
		}
	 }
	 else if ( (parseFloat(obj.value)>ceil) || (parseFloat(obj.value)< min)){
		alert(getLabel("ePH.TheValueshouldbeintherangeof.label","PH")+min+getLabel("Common.and.label","Common")+ceil+" !!!");
	    //alert("The Value should be in the range of "+min+" and "+ceil+" !!!");
		obj.value="";
		obj.focus();
		return false;
	 }
	 else{  
		eval("document.getElementById("overrid")"+no).style.visibility ="hidden";
		eval("document.getElementById("OVERRIDE_")"+no).value="";
		calculateValue(frmobj,no,obj.value);
	}
	}
	 else if ( (parseFloat(obj.value)>max)||(parseFloat(obj.value)<min)){
		obj.focus();
		alert(getLabel("ePH.TheValueshouldbeintherangeof.label","PH")+min+getLabel("Common.and.label","Common")+max+" !!!");
	}
	else{
		calculateValue(frmobj,no,obj.value);
	}
}

function calculateValue(frmobj,no,qtyvalue){  
	weight				= parseFloat(frmobj.weight.value);
	calcobj				= eval("document.getElementById("QCALC_")"+no);
//	str					= new String();
    var volm =parent.HeaderFrame.document.TpnNonStandardRegimen.volume.value
   if(eval("document.getElementById("ABORWT_")"+no).value=="P")
		val=qtyvalue*1000/volm;
	else
	    val	= qtyvalue/weight;
//	str					= val.toString();
//	calcobj.innerText=str.substring(0,4);
	calcobj.value=roundTwoDigits(val);
	energy              =eval("document.getElementById("STRENGTH_")"+no);
	qty_value = 0;
	ener_val  = 0;
	if(energy != undefined){
		if(no == 1){
			ener_val  = frmobj.carbo_ener.value;
			qty_value = qtyvalue*ener_val;
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		}
		else if(no == 2){
			ener_val  = frmobj.lipid_ener.value;
			qty_value = qtyvalue*ener_val; 
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		} 
		else if(no == 3){
			ener_val  = frmobj.prot_ener.value;
			qty_value = qtyvalue*ener_val;
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		}
    }
	var tot=eval(document.getElementById("STRENGTH_1").innerText)+eval(document.getElementById("STRENGTH_2").innerText)+eval(document.getElementById("STRENGTH_3").innerText);
	
	document.getElementById("tot_label").innerText=roundTwoDigits(tot);
	var n=document.getElementById("QVALUE_3").value;
	n1=eval(n*(16.0/100.0));
	n2=eval(document.getElementById("STRENGTH_1").innerText)+eval(document.getElementById("STRENGTH_2").innerText);
	var npc=eval(n2/n1);
	var t=Math.round(npc);
	document.getElementById("npc_label").innerText=t;
	frmobj.NPC.value=npc;
	frmobj.total.value=t;

	parent.frames[0].document.getElementById("npc_la").innerText=getLabel("ePH.NPCNRatio.label","PH")+t+" :1  "+getLabel("ePH.TotalEnergy.label","PH")+roundTwoDigits(tot)+getLabel("ePH.KCAL.label","PH");
	frmobj.NPC_N_val.value=getLabel("ePH.NPCNRatio.label","PH")+t+" :1 "+getLabel("ePH.TotalEnergy.label","PH")+roundTwoDigits(tot)+getLabel("ePH.KCAL.label","PH");

	//parent.frames[0].document.getElementById("npc_la").innerText="     NPC:N     Ratio    "+t+" :1       Total Energy: "+roundTwoDigits(tot)+" KCAL";
	//frmobj.NPC_N_val.value="     NPC:N   Ratio "+t+" :1   Total Energy:"+roundTwoDigits(tot)+" KCAL";
}

function calculateFrmStrngth(frmobj,no,qtyvalue){  
	weight				= parseFloat(frmobj.weight.value);
	quntyvalobj			= eval("document.getElementById("QVALUE_")"+no);
//	str					= new String();
    var volm =parent.HeaderFrame.document.TpnNonStandardRegimen.volume.value
	
    if(eval("document.getElementById("ABORWT_")"+no).value=="P"){
		val=(qtyvalue*volm)/1000;
	}
	else
	    val= qtyvalue*weight;
//	str					= val.toString();
//	calcobj.innerText=str.substring(0,4);
   
	quntyvalobj.value=roundTwoDigits(val);
	energy              =eval("document.getElementById("STRENGTH_")"+no);
	qty_value = 0;
	ener_val  = 0;
	if(energy != undefined){
		if(no == 1){
			ener_val  = frmobj.carbo_ener.value;
			qty_value = val*ener_val;
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		}
		else if(no == 2){
			ener_val  = frmobj.lipid_ener.value;
			qty_value = val*ener_val; 
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		}
		else if(no == 3){
			ener_val  = frmobj.prot_ener.value;
			qty_value = val*ener_val;
			qty_value = roundTwoDigits(qty_value);
			energy .innerText = qty_value;    
		}
    }

	var tot=eval(document.getElementById("STRENGTH_1").innerText)+eval(document.getElementById("STRENGTH_2").innerText)+eval(document.getElementById("STRENGTH_3").innerText);
	document.getElementById("tot_label").innerText=roundTwoDigits(tot);
	var n=document.getElementById("QVALUE_3").value;
	n1=eval(n*(16.0/100.0));
	n2=eval(document.getElementById("STRENGTH_1").innerText)+eval(document.getElementById("STRENGTH_2").innerText);
	var npc=eval(n2/n1);
	var t=Math.round(npc);
	document.getElementById("npc_label").innerText=t;
	frmobj.NPC.value=npc;
	frmobj.total.value=t;
	parent.frames[0].document.getElementById("npc_la").innerText=getLabel("ePH.NPCNRatio.label","PH")+t+" :1 "+getLabel("ePH.TotalEnergy.label","PH")+roundTwoDigits(tot)+getLabel("ePH.KCAL.label","PH");
	frmobj.NPC_N_val.value=getLabel("ePH.NPCNRatio.label","PH")+t+getLabel("ePH.TotalEnergy.label","PH")+tot+getLabel("ePH.KCAL.label","PH");

//	parent.frames[0].document.getElementById("npc_la").innerText="     NPC:N     Ratio    "+t+" :1       Total Energy: "+roundTwoDigits(tot)+" KCAL";
//	frmobj.NPC_N_val.value="     NPC:N   Ratio "+t+" :1   Total Energy:"+roundTwoDigits(tot)+" KCAL";
}

function ChangeReleaseButtonStatus(frm,disabledstatus){
//	frm.Release.disabled=disabledstatus;
}

/* Tool Tip Player object */
function disasbleamendToolTipDataChange(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function buildamendTableDataChange(text){   
    var tab_dat  = text ;
    document.getElementById("t").innerHTML = tab_dat;
}

function checkInfuse(InfuseObj){
	if (eval(InfuseObj.value) < 0) {
		InfuseObj.select();
		//alert(getMessage("INVALID_POSITIVE_NUMBER"));
//		alert("INVALID_POSITIVE_NUMBER");
		alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
		return true;
	}
	else if (eval(InfuseObj.value) > 24 && document.TpnAdmin.infuseoverdrn.value == "H"){
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "24"+getLabel("Common.hours.label","Common"));
		InfuseObj.focus();
		return;
	}
	else if(eval(InfuseObj.value) > 60 && document.TpnAdmin.infuseoverdrn.value == "M")	{
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "60"+getLabel("Common.Minutes.label","Common"));
		InfuseObj.focus();
		return;
	}
}

function displayamendToolTipDataChange(text){
    buildamendTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.x
    var y     = event.y;
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)
	
	
    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
    if(y<bodheight)
       y = event.y
    else
      y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
    y+=document.body.scrollTop
    x+=document.body.scrollLeft
	//for the time being x and y are hardcoded coz otherwise the div moves below the frequency combo
	//alert(x);
	//alert(y);
//	x=23;
//	y=7;
//	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posLeft= 0;
//    document.getElementById("tooltiplayer").style.posTop = y+100;
    document.getElementById("tooltiplayer").style.posTop = 50;
    document.getElementById("tooltiplayer").style.visibility='visible';

    }
function checkInfuse1(InfuseObj){
	if (eval(InfuseObj.value) < 0) {
		InfuseObj.focus();
		alert(getMessage("INVALID_POSITIVE_NUMBER","PH"));
		return true;
	}
	else if (eval(InfuseObj.value) > 24 ){
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "24"+getLabel("Common.hours.label","Common"));
		InfuseObj.focus();
		return;
	}
}

function roundTwoDigits(a){
	var a=a+"";
	
	if (a.indexOf(".")==-1){
		bb=a.substr(0,a.length);
	}
	else{
		bb=a.substr(a.indexOf("."),a.length);
		if (bb.length>3){
			bb=a.substr(0,a.indexOf(".")+4);
		}
		else{
			bb=a;
		}
	}
	if (bb.indexOf(".")==-1){
		bb=bb+'.0';
	}
	return bb;
}

function checkadmixture(frmobj){
	var time_flag=frmobj.time_flag.value;
	var alert_practitioner_yn=frmobj.alert_practitioner_yn.value;
	if(time_flag!='X'  ){
	   if(alert_practitioner_yn=='Y'){
		alert(getMessage("PREPARATION_ALERT","PH"));
	   }
	}
}
function callReport(frmobj){
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;
	var patient_class   = frmobj.patient_class.value ; 
	var patient_id  	= frmobj.patient_id.value ; //code added for SKR-SCF-0915[IN046734]
	var order_id ="";
    if(frmobj.order_id != undefined ){
		order_id=frmobj.order_id.value;
	}
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="patient_class"+"=\""+ patient_class+"\" " ;
	xmlStr				  +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?action=OnlineReport&bean_id=" + bean_id + "&bean_name=" + bean_name+ "&patient_class=" + patient_class+ "&order_id=" + order_id+ "&patient_id=" + patient_id, false ) ; //code '"&patient_id=" + patient_id'  added for SKR-SCF-0915[IN046734]   
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
}

function checkMaxLimit(obj,maxSize) {
	var key = window.event.keyCode;

	if( !(( key>=48 ) && ( key<=58 ) || (key == 46)) ) {
	   event.returnValue = false;
	}
	if ( obj.value.length >= maxSize  ){
		event.returnValue = false;
	}
	if( (obj.value.length == 4 && key != 46) || ((obj.value.length >= 5  || obj.value.length <4 )&& key == 46)){
		event.returnValue = false;
	}
	else{
		return false;
	}
}


function searchNonStandardRegimen(target){
	var formObj = document.TpnNonStandardRegimen;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//dataNameArray[0]   = "" ;
	//dataValueArray[0]  = "";
	//alert(dataValueArray[0]);
	//dataTypeArray[0]   = STRING ;
	if(document.TpnNonStandardRegimen.paed_regmn){
		if(document.TpnNonStandardRegimen.paed_regmn.checked==true)
		  document.TpnNonStandardRegimen.ped_regmn.value="Y";
	    else
           document.TpnNonStandardRegimen.ped_regmn.value="N";
	}
	else
          document.TpnNonStandardRegimen.ped_regmn.value="";

	dataNameArray[0]   = "PEAD_TPN_REGIMEN_YN" ;
	dataValueArray[0]  = document.TpnNonStandardRegimen.ped_regmn.value;
	dataTypeArray[0]   = STRING ;

	dataNameArray[1]   = "patient_id" ;
	dataValueArray[1]  = document.TpnNonStandardRegimen.patient_id.value;
	dataTypeArray[1]   = STRING ;

	dataNameArray[2]   = "patient_id" ;
	dataValueArray[2]  = document.TpnNonStandardRegimen.patient_id.value;
	dataTypeArray[2]   = STRING ;

	dataNameArray[3]   = "patient_id" ;
	dataValueArray[3]  = document.TpnNonStandardRegimen.patient_id.value;
	dataTypeArray[3]   = STRING ;

	argumentArray[0]   = document.getElementById("SQL_PH_TPN_NON_STD_REGIMEN_SELECT1AA").value;
		   
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "5,6";
	
	argumentArray[5]   = "" ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("ePH.NonStandardRegimen.label","PH"), argumentArray );
	if(retVal!=""){
	     res=confirm(getMessage("PH_CALCULATED_DATA_LOST","PH"));
		if (!res){
			return false;
		}
		if(retVal != null && retVal != "" )  {
			if(target.name=="stdregimen") {
				formObj.stdregimen.value = retVal[0];
				formObj.stdregimen_hidden.value = retVal[0];
				var reg_code=retVal[0];
			}
			//if condtion added  ml-mmoh-crf-1290 ,'"+tpn_tab_reg+"'
			var tpn_tab_reg=document.TpnNonStandardRegimen.tpn_tab_reg.value;
			if(tpn_tab_reg=="true"){
			checkforpromptalertmsg(reg_code);
			}
			target.value = retVal[1] ;
			change_tab_buttons("nonstdregimen",reg_code);
        }
	}
}

function change_tab_buttons(str,reg_code){
	
	var patient_id		= document.TpnNonStandardRegimen.patient_id.value;
	var weight		= document.TpnNonStandardRegimen.patient_weight.value;
	//alert(weight);
	var height		= document.TpnNonStandardRegimen.patient_height.value;
	var encounter_id = document.TpnNonStandardRegimen.encounter_id.value;
	var start_date = document.TpnNonStandardRegimen.start_date.value;
	var bean_id = document.TpnNonStandardRegimen.bean_id.value;
	var bean_name = document.TpnNonStandardRegimen.bean_name.value;
	var priority		= document.TpnNonStandardRegimen.priority.value;
	var location_code		= document.TpnNonStandardRegimen.location_code.value;
	var location_type		= document.TpnNonStandardRegimen.location_type.value;
	var pract_id = document.TpnNonStandardRegimen.pract_id.value;
	var act_patient_class = document.TpnNonStandardRegimen.act_patient_class.value;
	var mode = document.TpnNonStandardRegimen.mode.value;
	var problem_ind = document.TpnNonStandardRegimen.problem_ind.value;
	var qs			 = document.TpnNonStandardRegimen.QueryString.value;
		
	qs= qs+"&code="+document.TpnNonStandardRegimen.stdregimen_hidden.value;
	
	if ((weight=="") || (height=="") || parseFloat(weight) <= 0){
		alert(getMessage("PH_WEIGHT_REQUIRED","PH"));
		return;
	}
	
   	if(str=="tpnregimenassesment"){
		parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegimenAssesmentFrame.jsp?patient_id="+patient_id+"&weight="+weight+"&height="+height+"&encounter_id="+encounter_id;
	}
	else if(str=="stdregimen"){
		parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegStdRegFrames.jsp?"+qs; 
	}
	else if(str=="nonstdregimen"){
		parent.parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegNonStdRegFrames.jsp?patient_id="+patient_id+"&weight="+weight+"&height="+height+"&encounter_id="+encounter_id+"&start_date="+start_date+"&code="+reg_code+"&priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&act_patient_class="+act_patient_class+"&mode="+mode+"&problem_ind="+problem_ind; 
		
	}
	else if(str=="tpn_regimen"){
		alert("Under Construction");
	}
}

/*function callresult(regmncode){
	var patient_id		= document.TpnNonStandardRegimen.patient_id.value;
	var weight		= document.TpnNonStandardRegimen.patient_weight.value;
	//alert(weight);
	var height		= document.TpnNonStandardRegimen.patient_height.value;
	var encounter_id = document.TpnNonStandardRegimen.encounter_id.value;
	var start_date = document.TpnNonStandardRegimen.start_date.value;
	var priority		= document.TpnNonStandardRegimen.priority.value;
	var location_code		= document.TpnNonStandardRegimen.location_code.value;
	var location_type		= document.TpnNonStandardRegimen.location_type.value;
	var pract_id = document.TpnNonStandardRegimen.pract_id.value;
	var act_patient_class = document.TpnNonStandardRegimen.act_patient_class.value;
	var mode = document.TpnNonStandardRegimen.mode.value;
	var problem_ind = document.TpnNonStandardRegimen.problem_ind.value;

if(document.TpnNonStandardRegimen.regimen_code!="NON_STANDARD")
    alert(parent.DetailFrame.location.href ="../../ePH/jsp/TPNRegNonStdRegDetails.jsp?patient_id="+patient_id+"&weight="+weight+"&height="+height+"&encounter_id="+encounter_id+"&start_date="+start_date+"&code="+regmncode+"&priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&act_patient_class="+act_patient_class+"&mode="+mode+"&problem_ind="+problem_ind); 
  else
	parent.DetailFrame.location.href ="../../ePH/jsp/TPNRegNonStdRegDetails.jsp?<%=params%>"; 
}*/

function checkMand(obj,desc,no){  
	//alert(eval("document.getElementById("return_mandate")"+no).id);
	var mandatory=eval("document.getElementById("return_mandate")"+no).style.visibility;
	if (mandatory=="visible"){   
		if(obj.value=="0" || obj.value=="0.0" || obj.value==""){
			obj.focus();
			var msg="APP-PH0228 "
	         alert(msg+desc+" should not be zero or blank");
	        // obj.value="";
			 return false;
	      }
	 }
}

function displayToolTip(text){
	buildTableDataChange(text);
	bodwidth  = parent.parent.frames[1].document.body.offsetWidth
	bodheight = parent.parent.frames[1].document.body.offsetHeight
	var x     = event.x;
	var y     = event.y;
	x     = x + (document.getElementById("tooltiplayer").offsetWidth)
	y     = y + (document.getElementById("tooltiplayer").offsetHeight)
	if(x<bodwidth)
		x = event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight)
		y = event.y
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer").style.posLeft= x-60;

	if(x > 600 )
		document.getElementById("tooltiplayer").style.posTop = y+15;
	else
		document.getElementById("tooltiplayer").style.posTop = y-5;
	// document.getElementById("t").innerHTML=text;
	document.getElementById("tooltiplayer").style.visibility='visible';
}
		
function hideToolTip(){
	if(top.content != null){
		document.body.innerHTML = "";
	}
	else if(parent.parent.mesasgeFrame!=null){
		document.body.innerHTML = "";
	}
	else{
		document.body.innerHTML = "";
	}
}

function buildTableDataChange(text){   
	var tab_dat  = text ;
	document.getElementById("t").innerHTML = tab_dat;
}

async function showRemarks(remarks){
	var retVal;
	var dialogHeight	= '30vh' ;
	var dialogWidth 	= '40vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/TPNConstGenericRemarks.jsp?hdg_name="+hdg_name+ "&remarks=" +remarks,arguments,features);
}

function saveRemarksForDrug(group,row_no){     
	if(document.TpnConsGenericOvrrideReason.tpncons_remarks.value==""){
		alert(getMessage("PH_TPN_OVRRDE_RSN_CANT_BLNK","PH"));
		document.TpnConsGenericOvrrideReason.tpncons_remarks.focus();
		return false;
	}
	// eval("document.TpnNonStandardRegimen.OVERRIDE_"+i).value=document.getElementById("tpncons_remarks").value;
	var bean_id 	= document.TpnConsGenericOvrrideReason.bean_id.value ;
	var bean_name 	= document.TpnConsGenericOvrrideReason.bean_name.value ;
	var remarks     = document.TpnConsGenericOvrrideReason.tpncons_remarks.value ;
	var xmlDoc 		= ""
	var xmlHttp 	= new XMLHttpRequest();

	xmlStr			= "<root><SEARCH " ;
	xmlStr += "remarks=\""+ document.TpnConsGenericOvrrideReason.tpncons_remarks.value +"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&group=" + group + "&row_no=" + row_no +"&remarks=" + remarks +"&action=storeovrridereason", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
 }

function doAmendClose(obj){
	if(obj.value=="    Cancel    "){
		window.close();
	}
	 if(trimCheck(document.getElementById("tpncons_remarks").value)!=""){	
		window.returnValue = "Y"+"||"+document.getElementById("tpncons_remarks").value; // since comments is entered
		window.close();
	}
}

function enableRemarks(){
	var row_no=document.getElementById("row_no").value;
	if(trimCheck(document.getElementById("tpncons_remarks").value)!=""){
	   //eval("document.TpnNonStandardRegimen.overrid"+row_no).style.visibility ="visible";
   }
}

async function showreason(counter){ 
	group   =eval("document.TpnNonStandardRegimen.CODE_"+counter).value;
	var dialogHeight	= '50vh' ;
	var dialogWidth 	= '60vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	hdg_name			= "";
    var reason=eval("document.TpnNonStandardRegimen.OVERRIDE_"+counter).value;
	retVal 				= await window.showModalDialog("../../ePH/jsp/TPNConstGenericOverrideReason.jsp?hdg_name="+hdg_name+"&rowno="+counter+"&override="+"&group="+group+"&reason="+reason,arguments,features);
	if(retVal!=undefined){
		var retValArr					= retVal.split("||");
		retValue						= retValArr[1];
		eval("document.TpnNonStandardRegimen.OVERRIDE_"+counter).value = retValue;
       	//window.close();
	}
}

function populateVolume(obj,counter){
	var bean_id 	= document.TpnNonStandardRegimen.bean_id.value ;
	var bean_name 	= document.TpnNonStandardRegimen.bean_name.value ;
	var fluid       = obj.value;
	
	var genrc_code  = eval("document.TpnNonStandardRegimen.CODE_"+counter).value;
	var quantity    = eval("document.TpnNonStandardRegimen.QVALUE_"+counter).value;
	var xmlDoc 		= "";
	var xmlHttp 	= new XMLHttpRequest();

	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	mode=document.TpnNonStandardRegimen.mode.value;
	
	if(mode=="amend"){	
		if(eval("document.TpnNonStandardRegimen.ITEMFLUID_"+counter))
			fluid=eval("document.TpnNonStandardRegimen.ITEMFLUID_"+counter).value;
	 }
		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "TPNRegNonStdRegTemporary.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&genrc_code=" + genrc_code + "&quantity=" + quantity +"&fluid=" + fluid +"&action=populatevolume"+"&row_no="+counter, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
}

function assignVolume(volume,cnt){
	var vol              =eval("document.getElementById("VOLUME_")"+cnt);
	if(vol != undefined){
	vol.innerText=volume;
	}
}

function reload(mode){ 
	if(mode=='amend'){
		var patient_id		= parent.parent.frames[1].document.forms[0].patient_id.value;
		var weight		= parent.parent.frames[1].document.forms[0].patient_weight.value;
		var height		= parent.parent.frames[1].document.forms[0].patient_height.value;
		var encounter_id = parent.parent.frames[1].document.forms[0].encounter_id.value;
		var bean_id = parent.parent.frames[1].document.forms[0].bean_id.value;
		var bean_name = parent.parent.frames[1].document.forms[0].bean_name.value;
		var qs			 = parent.parent.frames[1].document.forms[0].QueryString.value;
		var ordered_volume=document.TpnNonStandardRegimen.volume.value;
		qs=qs+"&volm="+ordered_volume;
		if ((weight=="") || (height=="") || parseFloat(weight) <= 0){
			alert(getMessage("PH_WEIGHT_REQUIRED","PH"));
			return;
		}
 		parent.parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegNonStdRegFrames.jsp?"+qs;
	}
	else{
	    var queryString=document.TpnNonStandardRegimen.QueryString.value;
		var ordered_volume=document.TpnNonStandardRegimen.volume.value;
		var priority=document.TpnNonStandardRegimen.priority.value;
		queryString=queryString+"&volm="+ordered_volume+"&priority="+priority;
		params=queryString;
		parent.DetailFrame.location.href ="../../ePH/jsp/TPNRegNonStdRegDetails.jsp?params="+params;
	}
}
//added for ml-mmoh-crf-1290 start
function checkforpromptalertmsg(drug_code){

	frmobj=document.tpnStandardRegimen;
	var bean_id			= "TPNStandardRegimenBean";
	var bean_name		= "ePH.TPNStandardRegimenBean";    
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="drug_code"+"=\""+ drug_code+"\" " ;
	xmlStr				  +=" /></root>" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?action=PROMTALERT&bean_id="+ bean_id +"&bean_name="+ bean_name+"&drug_code="+drug_code, false ) ;  //tpn_std_reg_freq,act_patient_class added for ML-BRU-CRF-1126
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
function returncheckforpromptalertmsg(promptalertmsg){   
	msg=confirm(decodeURIComponent(promptalertmsg));
}
//added for ml-mmoh-crf-1290 end
