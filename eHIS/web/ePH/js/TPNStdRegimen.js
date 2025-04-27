//saved on 22/10/2005
var  result;
var  message;
var  flag;
//This array is used to store scheduledyn for frequency codes
schedulearr=new Array();
freqnaturearr=new Array();

async function stdLookup(target,params,tpn_std_reg_freq,act_patient_class){//tpn_std_reg_freq,act_patient_class added for ML-BRU-CRF-1126
	//called on click of lookup button for regimen
	var bean_id			= "TPNStandardRegimenBean";
	var bean_name		= "ePH.TPNStandardRegimenBean";    

	var dialogHeight		= "80vh" ;
	var dialogWidth		= "65vw" ;
	var dialogTop			= "170" ;
	var center				= "1" ;
	var status				="no";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		=new Array();
	

	retVal					=await top.window.showModalDialog("../../ePH/jsp/TPNRegStdRegLookupFrame.jsp?"+params+"&initialValue="+target.value,arguments,features);
	document.getElementById('constituent').disabled=false;
    if (typeof(retVal)=="object"){        
			target.value	=retVal[1];
			
			document.getElementById('Regimen_Code').value	=retVal[0];
		    callNPCval(retVal[0]);
			document.getElementById('ordertype_code').value	='OC';
			retrieveRegimenDetails(retVal[0],tpn_std_reg_freq,act_patient_class);//tpn_std_reg_freq,act_patient_class added for ML-BRU-CRF-1126
	}
}

function closeWindow(){
	//called for closing lookup window
	this.window.close();
}
function showAdditionalCriteria()
{
	//called for showing additional criteria
//	parent.LookupFrameSet.rows="32%,32%,*";
	parent.document.getElementById("f_queryCriteria").style.height="46vh";
	parent.document.getElementById("f_addqueryCriteria").style.height="19vh";
	parent.document.getElementById("f_resultframe").style.height="0vh";

}
function showLookupResult(frmobj)
{
	
	//called on click of search in the lookup
	//Get search values

	regname					=frmobj.name.value;
	searchpos				=frmobj.searchpos.value;
	chofrom					=frmobj.chofrom.value;
	choto					=frmobj.choto.value;
	proteinfrom				=frmobj.proteinfrom.value;
	proteinto				=frmobj.proteinto.value;
	lipidfrom				=frmobj.lipidfrom.value;
	lipidto					=frmobj.lipidto.value;
    eml_type                =frmobj.eml_type.value;
   
    cho_energy              =frmobj.cho_energy.value;
  	pro_energy              =frmobj.pro_energy.value;
	lipd_energy             =frmobj.lipd_energy.value;
	cho_qty                 =frmobj.cho_qty.value;
	pro_qty                 =frmobj.pro_qty.value;
	lipd_qty                =frmobj.lipd_qty.value;
	fluid                   =frmobj.fluid.value;
	fluidunit               =frmobj.fluidunit.value;
	unit                    =frmobj.unit.value;

	basedOnAssmntValues		= frmobj.bsdOnAssmntValues.value;
	displayRecords			= frmobj.displayRecords.value;
	CHO						= frmobj.CHO.value;
	PROTEIN					= frmobj.PROTEIN.value;
	LIPID					= frmobj.LIPID.value;
	CHO_PER					= frmobj.CHO_PER.value;
	PROTEIN_PER				= frmobj.PROTEIN_PER.value;
	LIPID_PER				= frmobj.LIPID_PER.value;
		if(displayRecords == ''){displayRecords = '0';}
		if(CHO == ''){CHO = '0';}
		if(PROTEIN == ''){PROTEIN = '0';}
		if(LIPID == ''){LIPID = '0';}
		if(CHO_PER == ''){CHO_PER = '0';}
		if(PROTEIN_PER == ''){PROTEIN_PER = '0';}
		if(LIPID_PER == ''){LIPID_PER = '0';}

	//get additional search values if any
	addformobj=parent.f_addqueryCriteria.StdRegLookupAddlCriteria;
	addstr	="";
	if (typeof(addformobj)=="object")
	{
		// add additional criteria
		for (i=0;i<addformobj.elements.length ; i++)
		{
			addstr=addstr+"&"+addformobj[i].id+"="+addformobj[i].value;
		}

	}
	//parent.LookupFrameSet.rows		 =	"32%,0%,*";
	parent.document.getElementById("f_queryCriteria").style.height="46vh";
	parent.document.getElementById("f_addqueryCriteria").style.height="0vh";
	parent.document.getElementById("f_resultframe").style.height="0vh";

	//parent.f_queryCriteria.document.StdRegLookupCriteria.bsdOnAssmntValues.disabled = true;
	parent.f_resultframe.location.href =	"../../ePH/jsp/TPNRegStdRegLookupResult.jsp?regname="+regname+"&searchpos="+searchpos+"&chofrom="+chofrom+"&choto="+choto+"&proteinfrom="+proteinfrom+"&proteinto="+proteinto+"&lipidfrom="+lipidfrom+"&lipidto="+lipidto+"&eml_type="+eml_type+"&cho_energy="+cho_energy+"&pro_energy="+pro_energy+"&lipd_energy="+lipd_energy+"&cho_qty="+cho_qty+"&pro_qty="+pro_qty+"&lipd_qty="+lipd_qty+"&fluid="+fluid+"&unit="+unit+"&fluidunit="+fluidunit+"&basedOnAssmntValues="+basedOnAssmntValues+"&displayRecords="+displayRecords+"&CHO="+CHO+"&PROTEIN="+PROTEIN+"&LIPID="+LIPID+"&CHO_PER="+CHO_PER+"&PROTEIN_PER="+PROTEIN_PER+"&LIPID_PER="+LIPID_PER+addstr;

}
//tpn_tab_reg added for ml-mmoh-crf-1290 ordertype REMOVED
function chooseRegimen(code,value,tpn_tab_reg)
{
	//called on click of regimen code in the lookup
	var res					=new Array();
	res[0]					=code;
	res[1]					=value;
	//res[2]					=ordertype;//commented for ml-mmoh-crf-1290
	window.returnValue=res;
	//alert(code);
	//if condtion added  ml-mmoh-crf-1290 ,'"+tpn_tab_reg+"'
	if(tpn_tab_reg=="true"){
	checkforpromptalertmsg(code);//added for ml-mmoh-crf-1290
	}
	window.close();
}
function frequencySelect(obj)
{
	//called on change of frequency -list box
	schyn	=schedulearr[obj.value];
	freqtype=freqnaturearr[obj.value];

	frmobj=document.tpnStandardRegimen;

	if (schyn=='Y')
	{
		frmobj.schedulemed.disabled=false;
	}
	else
	{
		frmobj.schedulemed.disabled=true;
	}
	if (freqtype=='O')
	{
		frmobj.duration.disabled	=true;
		frmobj.duration.value		=1;
		CheckMaxDuration(frmobj.duration);
	}
	else
	{
		frmobj.duration.disabled=false;
	}
	frmobj.schedulemed.checked	=false;
	frmobj.freqNature.value			=freqtype;
	
}
function enableAll()
{
	try
	{
		// to enable all fields, after choosing a valid regimen
		frmobj	=document.tpnStandardRegimen;
		//frmobj.infroute.disabled			=false;
		frmobj.volume.disabled				=false;
		frmobj.infuseover.disabled			=false;
		if(frmobj.infuseoverdrn != null && frmobj.infuseoverdrn != undefined){
		frmobj.infuseoverdrn.disabled		=false;	}
		frmobj.frequency.disabled			=false;
		frmobj.duration.disabled			=false;
		document.getElementById("remarks").disabled		=false;
		frmobj.startdate.disabled			=false;
		document.getElementById("constituent").disabled	=false;
		if(document.getElementById("Calendar") != null && document.getElementById("Calendar") != undefined){
			document.getElementById("Calendar").disabled	=false;
		}
		
	}
	catch (e)
	{
	}
}
function disableAll(frm,doc)
{
	
	//called if the user clears the value in the regimen name textbox and blurs out
	if (typeof(frm)=="object")
	{
		frmobj=frm;
	}
	else
	{
		frmobj	=document.tpnStandardRegimen;
		doc		=document;
	}
	frmobj.infroute.disabled			=true;
	frmobj.volume.disabled			=true;
	frmobj.infuseover.disabled		=true;
	if(frmobj.infuseoverdrn != null && frmobj.infuseoverdrn != undefined){
		frmobj.infuseoverdrn.disabled	=true;
	}
	frmobj.frequency.disabled			=true;
	frmobj.duration.disabled			=true;
	doc.remarks.disabled			=true;
	doc.constituent.disabled		=true;
	if(frmobj.schedulemed != null && frmobj.schedulemed != undefined){
		frmobj.schedulemed.disabled		=true;
	}
	frmobj.startdate.disabled			=true;
	frmobj.enddate.disabled				=true;
	if(document.getElementById("Calendar") != null && document.getElementById("Calendar") != undefined){
		document.getElementById("Calendar").disabled	=true;
	}
	hideAllLinks(doc);

}
function hideAllLinks(doc){
	// to hide links for cosign, auth etc..called from temporary jsp
	if (typeof(doc)=="object")
	{
		doc.AuthReqd.style.visibility		="hidden";
		doc.CosignReqd.style.visibility		="hidden";
		doc.SplAppReqd.style.visibility		="hidden";
		doc.ConsentReqd.style.visibility	="hidden";

	}
	else
	{
		document.getElementById("AuthReqd").style.visibility		="hidden";
		document.getElementById("CosignReqd").style.visibility	="hidden";
		document.getElementById("SplAppReqd").style.visibility	="hidden";
		document.getElementById("ConsentReqd").style.visibility	="hidden";

	}
}
function showLink(linkname)
{
	// to show  links for cosign, auth etc..called from temporary jsp
	document.getElementById(linkname).style.visibility		="visible";
}
function retrieveRegimenDetails(RegCode,tpn_std_reg_freq,act_patient_class) //tpn_std_reg_freq,act_patient_class added for ML-BRU-CRF-1126
{
	//called after the lookup returns a value
	//we use xml to call and populate the screen with relevant values for the regimen

	frmobj=document.tpnStandardRegimen;

	var startdate			= parent.parent.parent.f_header.document.prescription_header_form.sys_date.value;	
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;
	var weight				=frmobj.weight.value;
	var patient_id			=frmobj.patient_id.value; 
	
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="tmp"+"=\""+ "tmp" +"\" " ;
	xmlStr				  +=" /></root>" ;


	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?orderdate="+startdate+"&action=REGIMENSELECT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&regcode="+RegCode +"&weight="+weight+"&patient_id="+patient_id+"&tpn_std_reg_freq="+tpn_std_reg_freq+"&act_patient_class="+act_patient_class, false ) ;  //tpn_std_reg_freq,act_patient_class added for ML-BRU-CRF-1126
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

}
function defaultFrequency(freqcode){
	frmobj=document.tpnStandardRegimen;
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
	if (res==false)	{
		alert(getMessage("INVALID_DATE_TIME","PH"));
	}*/  // commented  for [IN:031523] End
	if(obj.value != ""){ //Added for [IN:031523]- Start
		if(!validDate(obj.value,"DMYHM",locale)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			//obj.select();
			obj.focus();
			return false;
		}
	} //Added for [IN:031523]- end
} 

function CheckMaxDuration(obj){
	frmobj			=document.tpnStandardRegimen;
	maxdurn		=parseInt(frmobj.max_duration.value);
	durn				=parseInt(obj.value);
	document.getElementById("DurnApproval").style.visibility="hidden";
	if (durn>maxdurn){
		//Check for the msg type if error/warning/or approval reqd
		msgtype= frmobj.action_type.value;
		msg		= frmobj.action_msg.value;
		if (msgtype=='E'){
			alert(msg+getMessage("CANNOT_PROCEED","PH"));
			obj.focus();
		}
		else if (msgtype=='W'){
			alert(getMessage("WARNING","PH")+msg);
		}
		else if(msgtype=='A'){
			alert(msg);
			document.getElementById("DurnApproval").style.visibility="visible";
		}
	}
	//Calculate End date here
	 CalculateEndDate(frmobj);
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
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?action=CALCULATEENDDATE&bean_id=" + bean_id + "&bean_name=" + bean_name +"&sdate="+sdate+"&duration="+durn, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

}

async function displaySchedule(obj) {
	if (obj.checked) {
		var formObj						= document.tpnStandardRegimen;
		var split_qty						=formObj.volume.value;
	
		var code							= formObj.Regimen_Code.value;
		var bean_id						= formObj.bean_id.value;
		var bean_name					= formObj.bean_name.value;
		var freq_code					= formObj.frequency.value;
		var drug_code					= '';
		var fluid_frame_display_yn = "N";
		var facility_id						= parent.parent.parent.f_header.document.prescription_header_form.facility_id.value;
		var max_qty						= 0;
		var  unit_qty						="" ;
		var  split_dose_yn				= "N";
		var qty_reqd_yn					= "N";
		var chk_max						= "N";
		var chk_unit						= "N";
		var uom_desc					=document.getElementById("volumeunit").innerText;

		var row_value					= "1";

		var dialogTop						= "260";
		var dialogHeight					= "60vh";
		var dialogWidth					= "70vw";
		var features						= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments					= "";
		var retVal 							= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH",arguments,features);
		if (typeof(retVal)=="string"){
			document.tpnStandardRegimen.frequency.disabled=true;
			makeLink(1);
		}
	}
	else{
		document.tpnStandardRegimen.frequency.disabled=false;
		makeLink(0);
	}
}

function makeLink(a){
	//this fucntion is used to toggle the link status of schedule medication 

	if (a==0){
		document.getElementById("scmed").innerText=getLabel("ePH.ScheduleMedication.label","PH");
	}
	else if (a==1){
		document.getElementById("scmed").innerHTML="<a href='javascript:displaySchedule(document.tpnStandardRegimen.schedulemed)'>"+getLabel("ePH.ScheduleMedication.label","PH")+"</a>"
		//document.getElementById("scmed").innerHTML="<a href='javascript:displaySchedule(document.tpnStandardRegimen.schedulemed)'>Schedule Medication</a>"
	}
}

async function displayConst(regimenCode){  
    //formObj=document.tpnStandardRegimen;
	//var regcode		= formObj.Regimen_Code.value;
	var regcode =regimenCode;
	var dialogHeight	 = "30vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "199";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	await window.showModalDialog("../../ePH/jsp/TPNRegStdRegConsFrame.jsp?RegimenCode="+regcode,arguments,features);
}
/* The functions are for calling the remarks */

function getFormatId(click_yn) {// click_yn added for [IN:039576]
	
	var formObj			= "";
	var drug_code		= "";
	
	formObj=document.tpnStandardRegimen;
	var order_type		= formObj.ordertype_code.value;
	var drug_code		= formObj.Regimen_Code.value;
	var form_code		= "";
	var route_code		= "";
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var patient_id			= formObj.patient_id.value;
	var encounter_id	= formObj.encounter_id.value;
	
	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=REMARKS&bean_id=" + bean_id + "&bean_name=" + bean_name +"&order_type="+order_type+"&drug_code="+drug_code+"&form_code="+form_code+"&route_code="+route_code+"&click_yn="+click_yn, false ) // click_yn added for [IN:039576]
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

}

function validateRemarks(format_id,click_yn)	{
	var format	= format_id.split("~");
	formatId	= format[1];
	//added for [IN:039576]-start
	var mandatory	=	format[0];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
	document.tpnStandardRegimen.DrugRemarksMandImg.style.display = 'none';
	document.tpnStandardRegimen.DrugRemarksMandatory.value =mandatory;//added for [IN:039576]-end
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		document.tpnStandardRegimen.remarks.style.display = 'none';
	else{
		document.tpnStandardRegimen.remarks.style.display = 'inline';
	if(mandatory == 'Y'){
			document.tpnStandardRegimen.DrugRemarksMandImg.style.display = 'inline';
		}
	}
	//added for SKR-SCF-0140 -end
	if(click_yn=='Y')// click_yn added for [IN:039576]
	callOrder();
}

function callOrder() {
	var vals = "";
	var drug_code = "";
	var frmObj = "";
	formObj=document.tpnStandardRegimen;
	var drug_code		= formObj.Regimen_Code.value;
	callRemarks(formObj, formatId, drug_code, 'PH', '0', 'PH', vals);
}

async function callRemarks(frmObj, format_id, catalog_code, order_category, row_value, called_from, pres_vals) {
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	DrugRemarksEntered	=frmObj.DrugRemarksEntered.value;//added for [IN:039576]
	mode	= frmObj.mode.value;
	if(mode==2){
	order_id	    = frmObj.order_id.value;
	order_line_no	= "1";
	}else if(mode==1){
		order_id	    = "";
	    order_line_no	= "";
	}
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";
	var dialogHeight= "30vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "169";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&catalog_code="+catalog_code+"&order_category="+order_category+"&row_value=0&called_from=PH&ph_list_vals="+pres_vals+"&order_id="+order_id+"&order_line_num="+order_line_no,arguments,features);
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
			frmobj				=document.tpnStandardRegimen;
			obj.innerHTML	="<img src='../../eOR/images/Authorized.gif'>"+getLabel("Common.Authorized.label","Common");
			//obj.innerHTML	="<img src='../../eOR/images/Authorized.gif'>Authorized";
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
			frmobj							=document.tpnStandardRegimen;
			obj.innerHTML				="<img src='../../eOR/images/Cosign.gif'>"+getLabel("ePH.Cosigned.label","PH");
			//obj.innerHTML				="<img src='../../eOR/images/Cosign.gif'>Cosigned";
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
			frmobj=document.tpnStandardRegimen;
			obj.innerHTML				="<img src='../../eOR/images/SpecialApproval_click.gif'>"+getLabel("ePH.SpeciallyApproved.label","PH");
			//obj.innerHTML				="<img src='../../eOR/images/SpecialApproval_click.gif'>Specially Approved";
			obj.className				="label";
			frmobj.splappedYN.value="Y";
		}
	}
}	

function callCancel(){
	if(parent.parent.parent.criteriaCategoryButtonFrame!= undefined){
		window.close();
	}
	else{
		frmobj=parent.HeaderFrame.document.tpnStandardRegimen;
		frmobj.reset();
		disableAll(frmobj,parent.HeaderFrame.document); 
	}
}

 function standarRegimcheck(encounter_id){
	 
	var bean_id="TPNStandardRegimenBean";
	var bean_name="ePH.TPNStandardRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest()
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNRegStdRegTemporary.jsp?encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&action=ACCESSIONNUMBER",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
 }

 function standarRegimDiscrete(encounter_id){
	 
	var bean_id="TPNStandardRegimenBean";
	var bean_name="ePH.TPNStandardRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest()
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNRegStdRegTemporary.jsp?encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&action=DISCRETE1",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);

 }

function apply(encounter_id,accession_num,tpn_screening_type) {
	if(tpn_screening_type=="N"){
		standarRegimcheck(encounter_id);
	}
	else if(tpn_screening_type=="D"){
		standarRegimDiscrete(encounter_id);
	}
	else if(tpn_screening_type==""){
		var frmobj				=parent.HeaderFrame.document.tpnStandardRegimen;
		var patient_id		=frmobj.patient_id.value;
		var bean_id			=frmobj.bean_id.value;
		var bean_name		=frmobj.bean_name.value;
		var drug_code		=frmobj.Regimen_Code.value;
		var buildMAR_yn		= frmobj.buildMAR_yn.value;
		var mode		= frmobj.mode.value;
		var drugRemarksMandatory = frmobj.DrugRemarksMandatory.value;//added for [IN:039576]
		var drugRemarksEntered		 = frmobj.DrugRemarksEntered.value;//added for [IN:039576]

		// added for ML-MMOH-CRF-1012 - Start
		var tpn_standard_non_standard = "";
		if(frmobj.tpn_standard_non_standard!=undefined){
			tpn_standard_non_standard = frmobj.tpn_standard_non_standard.value;
		}
		// added for ML-MMOH-CRF-1012 - End
		if ( (frmobj.Regimen_Code.value=="")){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.stdregimen.focus();
			return;
		}
		if ( (frmobj.volume.value=="")||((frmobj.volume.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.volume.focus();
			return;
		}
		if ( (frmobj.duration.value=="")||((frmobj.duration.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.duration.focus();
			return;
		}
		//added for ML-MMOH-CRF-1012 start
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
		}// added for ML-MMOH-CRF-1012 end
		if ((frmobj.frequency.value == "") || ((frmobj.frequency.value == "0"))) {
			alert(getMessage("PH_MANDATORY", "PH"));
			if (mode == '2')
				frmobj.frequency.focus();
			return;
		}if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){//if block added for [IN:039576]
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			frmobj.remarks.click();
			return false;
		}
		if ( (frmobj.infuseover.value=="")||((frmobj.infuseover.value=="0"))){
			alert(getMessage("PH_MANDATORY","PH"));
			frmobj.infuseover.focus();
			return;
		}
		var doc				=parent.HeaderFrame.document;
		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code+"&buildMAR_yn="+buildMAR_yn, false ) 

		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		eval(formApply(frmobj, PH_CONTROLLER) ) ;
		if(result)
			onSuccess(frmobj,doc);
		else
			alert(message);
	  }
  }
  //before Note type screeing Details Recorded Release RX
 function CheckAccessionNumber(accession_num,tpn_screening_type){
       apply1(accession_num,tpn_screening_type)
  }
  //before Discrete panel screeing Details Recorded Release RX
 function beforDiscrete1(test_observ_dt_tm,tpn_screening_type){
       apply1(test_observ_dt_tm,tpn_screening_type)
  }
   
function apply1(accession_num,tpn_screening_type){   
	var frmobj				=parent.HeaderFrame.document.tpnStandardRegimen;
   	var encounter_id	=frmobj.encounter_id.value;
	
	if(tpn_screening_type!='')
	{
	if(accession_num!='')
	 {
	var patient_id		=frmobj.patient_id.value;
	
	var bean_id			=frmobj.bean_id.value;
	var bean_name		=frmobj.bean_name.value;
	var drug_code		=frmobj.Regimen_Code.value;
	var buildMAR_yn		= frmobj.buildMAR_yn.value;

	if ( (frmobj.Regimen_Code.value=="")){
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.stdregimen.focus();
		return;
	}
	if ( (frmobj.volume.value=="")||((frmobj.volume.value=="0"))){
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.volume.focus();
		return;
	}
	if ( (frmobj.duration.value=="")||((frmobj.duration.value=="0")))
	{
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.duration.focus();
		return;
	}
	if ( (frmobj.frequency.value=="")||((frmobj.frequency.value=="0"))){
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.frequency.focus();
		return;
	}
	var doc				=parent.HeaderFrame.document;
	var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code+"&buildMAR_yn="+buildMAR_yn, false ) 
	
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	
	eval(formApply(frmobj, PH_CONTROLLER) ) ;
	if(result)
		onSuccess(frmobj,doc);
	else
		alert(message);
	}
	else{
		  alert(getMessage('SCREENIN_GDETAILS','PH'));
	  }
	}else{
	var patient_id		=frmobj.patient_id.value;
	var encounter_id	=frmobj.encounter_id.value;
	var bean_id			=frmobj.bean_id.value;
	var bean_name		=frmobj.bean_name.value;
	var drug_code		=frmobj.Regimen_Code.value;
	var buildMAR_yn		= frmobj.buildMAR_yn.value;
	//alert('buildMAR_yn--else-->'+buildMAR_yn);

	if ( (frmobj.Regimen_Code.value=="")){
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.stdregimen.focus();
		return;
	}
	if ( (frmobj.volume.value=="")||((frmobj.volume.value=="0"))){
		alert(getMessage("PH_MANDATORY","PH"));
		frmobj.volume.focus();
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
	var doc				=parent.HeaderFrame.document;
	var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
	
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&action=SUBMIT&bean_id=" + bean_id + "&bean_name=" + bean_name +"&drug_code="+drug_code+"&buildMAR_yn="+buildMAR_yn, false ) 

	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(formApply(frmobj, PH_CONTROLLER) ) ;

	if (result)
		onSuccess(frmobj,doc);
	else
		alert(message);
	}
}

function assignResult( result1, message1, flag1 ,temp) {
	result		= result1 ;
    message	= message1 ;
    flag			= flag1 ;
}

function onSuccess(frmobj,doc){ 
	var obj;
	if(parent.parent.parent.f_header!= undefined){
		obj=parent.parent.parent.f_header.prescription_header_form;
		startdate					= obj.sys_date.value;
		frmobj.startdate.value=startdate;
		frmobj.enddate.value	=startdate;
		var print_ord_sht_rule_ind=frmobj.print_ord_sht_rule_ind.value;//Added for Bru-HIMS-CRF-393_1.0
	//	disableAll(frmobj,parent.HeaderFrame.document);
		re = /<br>/i;
		//message=message.replace(re,"");
		alert(message);
		//var print_confirm=confirm("Do you want to print the Prescription") //code moved from line 782 to line 763 for SKR-SCF-0915[IN046734] --code 
		var print_confirm=""; 	//Added for Bru-HIMS-CRF-393_1.0-Start
		if(print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='')//print_ord_sht_rule_ind=='' Added for Inc:049877
			print_confirm=confirm(getMessage("DO_WANT_PPRINT_PRESCRIPTION","PH"))
		else if(print_ord_sht_rule_ind=="S")
			print_confirm="true";//Added for Bru-HIMS-CRF-393_1.0-End
		if(print_confirm){
			callReport(frmobj);
		} //code added for SKR-SCF-0915[IN046734] --End
		var encounter_id	=frmobj.encounter_id.value;
		var patient_id		=frmobj.patient_id.value;
		var bean_id			=frmobj.bean_id.value;
		var bean_name		=frmobj.bean_name.value;
		var drug_code		=frmobj.Regimen_Code.value;

		// For Clearing Bean Values ========
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		
		//return;
		xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?Mode=ClearBean&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) 
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		// Clearing Bean end ===========		
		parent.parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		//frmobj.reset();
		//hideAllLinks(doc);
		//disableAll();
	}
	else{
		obj=parent.parent.f_header.prescription_header_form;
		startdate					= obj.sys_date.value;
		frmobj.startdate.value=startdate;
		frmobj.enddate.value	=startdate;
		var print_ord_sht_rule_ind=frmobj.print_ord_sht_rule_ind.value;//Added for Bru-HIMS-CRF-393_1.0
	//	disableAll(frmobj,parent.HeaderFrame.document);
		re = /<br>/i;
		//message=message.replace(re,"");
		alert(message);
		//var print_confirm=confirm("Do you want to print the Prescription")
		//var print_confirm=confirm(getMessage("DO_WANT_PPRINT_PRESCRIPTION","PH"))
		var print_confirm="";
		if(print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='')//print_ord_sht_rule_ind=='' Added for Inc:049877
			print_confirm=confirm(getMessage("DO_WANT_PPRINT_PRESCRIPTION","PH"))
		else if(print_ord_sht_rule_ind=="S")
			print_confirm="true"; //Added for Bru-HIMS-CRF-393_1.0-End
		if(print_confirm){
			callReport(frmobj); 
		}
		window.close();
		parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		//frmobj.reset();
		//hideAllLinks(doc);
	}
}

/* Tool Tip Player object */
function disasbleamendToolTipDataChange(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function buildamendTableDataChange(text){   
    var tab_dat  = text ;
    //alert('here');
    document.getElementById("t").innerHTML = tab_dat;

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
	//    document.getElementById("tooltiplayer").style.posLeft= x-25;
	 document.getElementById("tooltiplayer").style.posLeft= x;
	//   document.getElementById("tooltiplayer").style.posTop = y-50;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';
}

function checkInfuse(InfuseObj){
	if (eval(InfuseObj.value) < 0) {
		InfuseObj.focus();
		//alert(getMessage("INVALID_POSITIVE_NUMBER"));
		alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
		//alert("INVALID_POSITIVE_NUMBER");
		return true;
	}
	else if (eval(InfuseObj.value) > 24 && document.tpnStandardRegimen.infuseoverdrn.value == "H"){
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + getMessage("TWENTYFOUR_HOUR","PH"));
		InfuseObj.focus();
		return;
	}
	else if(eval(InfuseObj.value) > 60 && document.tpnStandardRegimen.infuseoverdrn.value == "M"){
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + getMessage("SIXTY_MINUTES","PH"));
		InfuseObj.focus();
		return;
	}
}

/**************************************************************/
function okayAddSearch(frmobj){
	//called on click of okay button in additional search. temporarily not used
	parent.LookupFrameSet.rows="32%,0%,*";
	chofrom			=frmobj.chofrom.value;
	choto				=frmobj.choto.value;
	proteinfrom	=frmobj.proteinfrom.value;
	proteinto		=frmobj.proteinto.value;
	lipidfrom		=frmobj.lipidfrom.value;
	lipidto			=frmobj.lipidto.value;
}

function cancelAddSearch(frmobj){
	//called on click of cancel of addtnl search..temporarilty not used
	parent.LookupFrameSet.rows="32%,0%,*";
/*	chofrom='';
	choto='';
	proteinfrom='';
	proteinto='';
	lipidfrom='';
	lipidto='';
	frmobj.chofrom.value='';
	frmobj.choto.value='';
	frmobj.proteinfrom.value='';
	frmobj.proteinto.value='';
	frmobj.lipidfrom.value='';
	frmobj.lipidto.value='';*/
}

function populateAddSearch(frmobj){
//temporarily not used
	frmobj.chofrom.value		=chofrom;
	frmobj.choto.value			=choto;
	frmobj.proteinfrom.value=proteinfrom;
	frmobj.proteinto.value	=proteinto;
	frmobj.lipidfrom.value		=lipidfrom;
	frmobj.lipidto.value			=lipidto;
}

function checkInfuse1(InfuseObj){  
	if (eval(InfuseObj.value) < 0) {
		InfuseObj.focus();
		//alert(getMessage("INVALID_POSITIVE_NUMBER"));
		//alert("INVALID_POSITIVE_NUMBER");
		alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
		return true;
	}
	else if (eval(InfuseObj.value) > 24 ){
		//alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "24 hr");
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") +getMessage("TWENTYFOUR_HOUR","PH"));
		InfuseObj.focus();
		return;
	}
}

function callNPCval(RegCode){
	
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;

	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest()

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="RegCode"+"=\""+ RegCode+"\" " ;
	xmlStr				  +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?action=NPCVal&bean_id=" + bean_id + "&bean_name=" + bean_name +"&regcode="+RegCode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText); 
}

function callReport(frmobj){
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;
	var patient_class   = frmobj.patient_class.value ; 
	var patient_id   = frmobj.patient_id.value ; //code added for SKR-SCF-0915[IN046734]
	var order_id ="";
    if(frmobj.order_id != undefined ){
		order_id=frmobj.order_id.value;
	}
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest()

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="patient_class"+"=\""+ patient_class+"\" " ;
	xmlStr				  +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TPNRegStdRegTemporary.jsp?action=OnlineReport&bean_id=" + bean_id + "&bean_name=" + bean_name+ "&patient_class=" + patient_class+ "&order_id=" + order_id+ "&patient_id=" + patient_id, false ) ;//code '"&patient_id=" + patient_id'  added for SKR-SCF-0915[IN046734]  
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
}


function clearAll(){
	document.StdRegLookupCriteria.chofrom.value = '';
	document.StdRegLookupCriteria.choto.value = '';
	document.StdRegLookupCriteria.proteinfrom.value = '';
	document.StdRegLookupCriteria.proteinto.value = '';
	document.StdRegLookupCriteria.lipidfrom.value = '';
	document.StdRegLookupCriteria.lipidto.value = '';
	document.StdRegLookupCriteria.CHO.value = '';
	document.StdRegLookupCriteria.PROTEIN.value = '';
	document.StdRegLookupCriteria.LIPID.value = '';
}

function basedOnAssmntValuesSet(obj){
		if(obj.checked == false){
		clearAll();
		obj.value = "N";
	}else if(obj.checked == true){
		obj.value = "Y";
	}
}

function displyRange(obj){
	
	if((obj.value != '') && (obj.value <= 0 || obj.value >14)){
		alert("Enter any value between 1 and 14");
		obj.value = '5';
		obj.focus();
	}
}

function checkConsRange(obj){
	if((obj.value != '') && (obj.value <= 0 || obj.value >100)){
		alert("Enter any value between 1 and 100");
		obj.value = '';
		obj.focus();
	}
}

function unCheck(){
	
	document.StdRegLookupCriteria.bsdOnAssmntValues.checked = false;
	document.StdRegLookupCriteria.bsdOnAssmntValues.value   = "N";
}

function assignValue(obj) {
	if(obj.checked==true){
		obj.value="Y";
	}
	else{
		obj.value="N";
	}
}
//added for ML-MMOH-CRF-1126- start
function addFrequencyList(freq_code,freq_desc,default_val){
	
	var element = document.createElement('OPTION') ;
	element.value		=  freq_code ;
	element.text		= decodeURIComponent(freq_desc,"UTF-8") ;
	if(default_val!='' ){
		if(freq_code==default_val ){
			element.selected	=	true;
		}
	}
	document.tpnStandardRegimen.frequency.add(element); 
}
//added for ML-MMOH-CRF-1126- end
//ADDED FOR ML-MMOH-CRF-1290 START
function checkforpromptalertmsg(drug_code){

	frmobj=document.tpnStandardRegimen;
	var bean_id			= "TPNStandardRegimenBean";
	var bean_name		= "ePH.TPNStandardRegimenBean";    
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest()

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
//ADDED FOR ML-MMOH-CRF-1290 end
