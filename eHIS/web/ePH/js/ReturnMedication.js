var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var allow=true;	 

function switchLogin(val,patclass, homepage){
	parent.parent.location.replace("../../ePH/jsp/ReturnMedication.jsp?module_id=PH&function_id=PH_MED_RETURN&function_name=Return%20Medication&function_type=F&menu_id=PH_TRANSACTIONS&access=NNNNN&password="+val+"&patclass="+patclass+"&homepage="+homepage);
}
//This method is used to show the Login screen
async function showLoginWindow(disp_locn_details,function_id,val,pclass, homepage, store_code,userName, userId){
	HomePageYN = homepage;
	if(homepage!='Y'|| store_code == undefined  || store_code=='' || pclass == undefined  || pclass=='' ){ //if condition and else block Added for Bru-HIMS-CRF-073.1 [IN:047222]
		var dialogHeight= "220px" ;//12
		var dialogWidth	= "500px" ;//34
		var dialogTop = "10px" ;//180
		var center = "1" ;//1
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/ReturnMedicationLogin.jsp?password="+val+"&patclass="+pclass+"&homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal == undefined){
			//history.go(-1);
			window.location.href = '../../eCommon/jsp/dmenu.jsp';
		}
		else{
			//window.close();
			var str =unescape(retVal);
			var arr = str.split(",");   
			patcat=arr[0];
			displocn=arr[1];
			pwd=arr[2];
			f_query_add_mod.location.href="../../ePH/jsp/ReturnMedicationFrames.jsp?function_id="+function_id+"&patientcat="+patcat+"&dispLocn="+displocn+"&password="+pwd+"&homepage="+homepage;
			
		}
	}
	else{ //added for Bru-HIMS-CRF-073.1 [IN:047222]
		f_query_add_mod.location.href="../../ePH/jsp/ReturnMedicationFrames.jsp?function_id="+function_id+"&patientcat="+pclass+"&dispLocn="+store_code+"&homepage="+homepage+"&password="+val;
	}
}
//This funtion is called on clicking of okay from the login page

async function callDiscontinue(dis_cont_reason,DISC_DATE_TIME,pract_name){
    var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;	 
	var bean_id             = frmobj.bean_id.value;
    var bean_name           = frmobj.bean_name.value;
	
    var dialogHeight	= "15" ;
	var dialogWidth		= "35" ;
	var dialogTop		= "250" ;
	var dialogLeft		= "203" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
    var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:no" ;
    var arguments	= "";
    
	//var bean_id="ReturnMedicationBean" ; 
    //var bean_name="ePH.ReturnMedicationBean";
	var retVal = await window.showModalDialog("../../ePH/jsp/DiscontinueReason.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&dis_cont_reason="+dis_cont_reason+"&DISC_DATE_TIME="+DISC_DATE_TIME+"&pract_name="+pract_name,arguments,features);

}

async function Remarks(count1){
    var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;	 
	var obj=eval(parent.retmedicationactionframe.document.getElementById("remarks_desc"+count1));

	var dialogHeight	= "35vh" ;
	var dialogWidth		= "40vw" ;
	var dialogTop		= "20" ;
	var dialogLeft		= "20" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
   var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:no" ;
   var arguments	= "";
  
	var bean_id             = frmobj.bean_id.value;
    var bean_name           = frmobj.bean_name.value;
   //var bean_id="ReturnMedicationBean" ; 
   // var bean_name="ePH.ReturnMedicationBean";
   //alert("../../ePH/jsp/ReturnMedicationRemarks1.jsp?bean_id="+bean_id+"&remark_desc="+obj.value+"&bean_name="+bean_name,arguments,features);
   //var retVal = window.showModalDialog("../../ePH/jsp/ReturnMedicationRemarks1.jsp?bean_id="+bean_id+"&remark_desc="+escape(obj.value)+"&bean_name="+bean_name,arguments,features); 
   var retVal =await  window.showModalDialog("../../ePH/jsp/ReturnMedicationRemarks1.jsp?bean_id="+bean_id+"&remark_desc="+encodeURIComponent(obj.value,"UTF-8")+"&bean_name="+bean_name,arguments,features); //Added encode URIcomponent for remark_desc regarding incident num:25634 ==BY Sandhya
	if(retVal!=undefined && retVal!="")
	obj.value=retVal;
}

function ReturnRemarks(){		
	    formObj=document.Returnremarksform;
		var retunRemark=formObj.remarks_desc.value;
		//alert("retunRemark====>"+retunRemark);
		parent.document.getElementById('dialog-body').contentWindow.returnValue=retunRemark;
		//window.close();
		parent.document.getElementById('dialog_tag').close();
}

function ChangeResult(recordcount,statusvalue){
	var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;	  
	var index =0;
	if(statusvalue.value=="A"){
		index =1;
	}else if(statusvalue.value=="R"){
		index =2;
	}else if(statusvalue.value=="P"){
		index =3;
	}else{
		index =0;
	}
		
	for (i=1;i<=recordcount;i++){
	  //alert("===i===="+i);
	  obj=eval("frmobj.acknow_ledg"+i);
	  retQty=eval("frmobj.returnable"+i).value;
	 
	  obj.selectedIndex = index;
	  setFieldValue(retQty,statusvalue,i);
	 
	}//end for
}

function checkLogin(){
	formObj=document.FormReturnMedicationLogin;
	// check if dispense location and patient category is selected
	//checking for the password
	if (formObj.disp_locn.value==""){
		alert( getMessage("PH_DISPENSE_LOCATION","PH"));
		return;
	}
	if (formObj.orig_pwd.value!=formObj.password.value){
		alert(getMessage("PH_INVALID_PASSWORD","PH"));
		formObj.password.select();
		formObj.password.focus();
		return;
	}
	//else set the return value as "OK"
	var dispLocn=new Array();
	dispLocn[0]=formObj.Patient_Category.value;
	dispLocn[1]=formObj.disp_locn.value;
	dispLocn[2]=formObj.password.value;
	//window.returnValue=dispLocn;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = dispLocn;
	 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

//for populating dispense locations
function populateDispLocn ( ) {
	formObj=document.FormReturnMedicationLogin;
	patientcat=formObj.Patient_Category.value;
	formObj.disp_locn.innerText = "";
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH  /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReturnMedicationLoginTemporary.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&patientcat=" + patientcat+"&identity=DISPLOCN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval( responseText ) ;
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	//opt.value =	"";
	//opt.text = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--Select--";
	//obj.add(opt);
}

function addData(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function addDataDefault(code, desc, obj,sel) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	if(sel == "selected") 
		opt.selected = true; 
	obj.add(opt);
}


async function callPatientSearch(target){//for patient lookup
	var patient_id =await PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
		// populate the encounter id  AMS-CRF-0172
		populateEncounter(patient_id);
	}

}//for drug lookup

async function drugsearch(obj){
	var formObj = obj;
	retVal =await DrugSearch( "D", obj.Drug_Name,"ReturnMedication" );
	if( (retVal != null) && (retVal != "" ))  {
		formObj.Drug_Name.value = retVal[1] ;
		formObj.Drug_Code.value = retVal[0];
	}
	else{
		formObj.Drug_Name.value = '' ;
		formObj.Drug_Code.value = '';
	}
}

function callResultPage(patcat,facilityflag){ //facilityflag parameter added for FD-Bru-HIMS-CRF-091
	// Check for Mandatory Fields
	var formObj	=	document.FormReturnMedicationQueryCriteria;
	var homepage = formObj.homepage.value; //added for MMS-QH-CRF-0201 [IN:052255] 
	if(homepage!='dispmed' && homepage!='directDisp'){//if condition and else block added for MMS-QH-CRF-0201 [IN:052255] 
		parent.parent.f_query_add_mod.retmedicationdrugframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationremarksframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationplineframe.location.href="../../eCommon/html/blank.html";
	}
	else{
		parent.retmedicationdrugframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationremarksframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationplineframe.location.href="../../eCommon/html/blank.html";
		formObj.eff_status.disabled = true;
		formObj.Search1.disabled = true;
		formObj.Search.disabled = true;
	}
	//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	//var errorPage	= "../../eCommon/jsp/error.jsp" ;
	//var blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;
	verification();
	if (!allow){
		formObj.Patient_Id.focus();
		return;
	}
	//populate the drug frame
	patientId				= formObj.Patient_Id.value;
	drugCode				= formObj.Drug_Code.value;
	//nationalId=formObj.National_Id.value;
	//healthCard=formObj.Health_Card_No.value;
	orderId					= formObj.Order_Id.value;
	dispNo					= formObj.Dispense_No.value;
	cutoff					= formObj.CutOff.value;
	dispLocn				= formObj.dispLocn.value;
	medn_rtn_after_bill_gen				= formObj.medn_rtn_after_bill_gen.value;
	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
	if(facilityflag!="Y"){
		FormStore				= formObj.FromStore.options[formObj.FromStore.selectedIndex].value;
		ordering_facility_id	= formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].value;	
	}
	else{
		FormStore="";
		ordering_facility_id=formObj.facility_id.value;
	}
	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
	if(formObj.eff_status.checked){
		eff_status				= "E";
	}
	else{
		eff_status				= "D";
	 } 
	Ward_Date_From			= formObj.Ward_Date_From.value;
	ward_Date_To			= formObj.ward_Date_To.value;
	From_Location			= formObj.nursing_unit.value;
	encounter_id			= formObj.encounterId.value; //AMS-CRF-0172	
	var rej_qty				= formObj.rej_qty.value;	// Added for GHL-SCF-790 [IN:046481]
	var blDocType			= formObj.blDocType.value; // added for MMS-DM-CRF-0039 [IN:055958] -start
	var blDocNo				= formObj.blDocNo.value; // added for MMS-DM-CRF-0039 [IN:055958]
	var dispBillNoYN		= formObj.dispBillNoYN.value; // added for MMS-DM-CRF-0039 [IN:055958]
	var encounterIdLen = formObj.encounterId.options.length;
	if(dispBillNoYN =='Y' && (blDocType !='' && blDocNo =='') || (blDocType =='' && blDocNo !='')){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("ePH.BillNo.label", "PH"));
		alert(msg);
		return false;	
	} // added for MMS-DM-CRF-0039 [IN:055958] -end
	if(encounterIdLen>1 && encounter_id=="" && medn_rtn_after_bill_gen!='' && !(dispBillNoYN =='Y' && blDocType !='' && blDocNo !='')){ //code added for FD-JD-CRF-0178[IN039208]--Start  //encounterIdLen>1 && ,  && !(dispBillNoYN =='Y' && blDocType !='' && blDocNo !='') added for MMS-DM-CRF-0039 [IN:055958]
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		if(dispBillNoYN =='Y' && (blDocType =='' || blDocNo =='')) //if block and else condition  added for MMS-DM-CRF-0039 [IN:055958]
			msg = msg.replace('$', getLabel("Common.encounterid.label", "Common") + "/" + getLabel("ePH.BillNo.label", "PH"));
		else 
			msg = msg.replace('$', getLabel("Common.encounterid.label", "Common"));
		alert(msg);
		return false;	
	}	 //code added for FD-JD-CRF-0178[IN039208]--End 
	//code for setting ordering facility_id in bean.	
	var bean_id             = formObj.bean_id.value;
    var bean_name           = formObj.bean_name.value;
   /* var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");*/
    var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "ReturnMedicationLoginTemporary.jsp?identity=SET_ORDERING_FACILITY"+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&ordering_facility_id="+ordering_facility_id , false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);	
    if(patcat == "I" && medn_rtn_after_bill_gen=='N' ){
		var bill_gen_yn = 'N';
		var xmlDoc1		= "";
		var xmlHttp1		= new XMLHttpRequest();					
		xmlStr1	="<root><SEARCH " ;												
		xmlStr1 +=" /></root>" ;
		xmlDoc1.loadXML( xmlStr1 ) ;
		xmlHttp1.open( "POST", "ReturnMedicationLoginTemporary.jsp?identity=CHECK_BILL"+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&ordering_facility_id="+ordering_facility_id+"&patientId="+patientId+"&encounter_id="+encounter_id+"&dispLocn="+dispLocn, false ) ;		
		xmlHttp1.send( xmlDoc1 ) ;	
		eval(xmlHttp1.responseText);	
		bill_gen_yn = document.FormReturnMedicationQueryCriteria.bill_gen_yn.value;
		if(bill_gen_yn=='Y'){
			alert(getMessage("PH_RETURN_AFTER_BILL_GEN","PH"));  
			return false;
		}
	}
	if(eff_status=="D"){
		//parent.mainframeset.rows="24%,5%,*,5%,0%";
		parent.document.getElementById('retmedicationqueryframe').style.height = "25vh"; 
		parent.document.getElementById('retmedicationplineframe').style.height = "10vh";
		parent.document.getElementById('innerdiv').style.height = "60vh";
	    parent.document.getElementById('retmedicationdrugframe').style.height = "55%";
	    parent.document.getElementById('retmedicationremarksframe').style.height = "45%"; 
	    parent.document.getElementById('retmedicationactionframe').style.height = "0vh"; 
	    parent.document.getElementById('retmedicationbuttonframe').style.height = "5vh"; 
		parent.retmedicationdrugframe.location.href="../../ePH/jsp/ReturnMedicationDrug.jsp?patientid="+patientId+"&drugcode="+drugCode+"&From_Location="+From_Location+"&ward_Date_To="+ward_Date_To+"&Ward_Date_From="+Ward_Date_From+"&eff_status="+eff_status+"&FormStore="+FormStore+"&orderid="+orderId+"&dispno="+dispNo+"&cutoff="+cutoff+"&dispLocn="+dispLocn+"&encounter_id="+encounter_id+"&patcat="+patcat+"&medn_rtn_after_bill_gen="+medn_rtn_after_bill_gen+"&rej_qty="+rej_qty+"&blDocType="+blDocType+"&blDocNo="+blDocNo; // "&blDocType="+blDocType+"&blDocNo="+blDocNo added for MMS-DM-CRF-0039 [IN:055958]
	}
	else{
		
		//parent.mainframeset.rows="25%,10%,*,70%,10%";	
		parent.document.getElementById('retmedicationqueryframe').style.height = "25vh"; 
		parent.document.getElementById('retmedicationplineframe').style.height = "10vh";
		parent.document.getElementById('innerdiv').style.height = "0vh";
	   // parent.document.getElementById('retmedicationdrugframe').style.height = "55%";
	  //  parent.document.getElementById('retmedicationremarksframe').style.height = "45%"; 
	    parent.document.getElementById('retmedicationactionframe').style.height = "70vh"; 
	    parent.document.getElementById('retmedicationbuttonframe').style.height = "5vh"; 
		parent.retmedicationactionframe.location.href="../../ePH/jsp/ReturnMedicationAction.jsp?patientid="+patientId+"&drugcode="+drugCode+"&From_Location="+From_Location+"&ward_Date_To="+ward_Date_To+"&Ward_Date_From="+Ward_Date_From+"&eff_status="+eff_status+"&FormStore="+FormStore+"&orderid="+orderId+"&dispno="+dispNo+"&cutoff="+cutoff+"&dispLocn="+dispLocn+"&encounter_id="+encounter_id+"&patcat="+patcat+"&medn_rtn_after_bill_gen="+medn_rtn_after_bill_gen+"&rej_qty="+rej_qty;
	}
}

function FromStoreSelect(objval){
	document.frames.FormReturnMedicationQueryCriteria.FormStore.value=objval.value
}

function FromlocationSearch(obj1,login_user,patient_class){
	if(patient_class=="I"){
		locationSearchForIPandDC(login_user);
	}
	else{
		locationSearchForOPandEM(login_user);
	}
}

function locationSearchForOPandEM(login_user){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//var facility_id		=	document.frames.FormReturnMedicationQueryCriteria.facility_id.value;
	var ordering_facility_id = document.frames.FormReturnMedicationQueryCriteria.OrderingFacility.options[document.frames.FormReturnMedicationQueryCriteria.OrderingFacility.selectedIndex].value;
	var language_id		=	document.frames.FormReturnMedicationQueryCriteria.locale.value;
			 
	var sql	=document.frames.FormReturnMedicationQueryCriteria.SQL_PH_OP_LOCATION_SELECT.value;

	sql=sql.replace('#',ordering_facility_id);
	sql=sql.replace('#',login_user);
	sql=sql.replace('#',ordering_facility_id);
	//sql=sql.replace('#',patient_class);
	sql=sql.replace('#',language_id);
	argumentArray[0]   =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.frames.FormReturnMedicationQueryCriteria.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );

	if(retVal != null && retVal != "") {
	document.frames.FormReturnMedicationQueryCriteria.nursing_unit.value = retVal[0];
	document.frames.FormReturnMedicationQueryCriteria.nursing_unit_desc.value=retVal[1];

	}
}

function locationSearchForIPandDC(login_user){

	var argumentArray   = new Array() ;
	var dataNameArray   = new Array() ; 
	var dataValueArray  = new Array() ;
	var dataTypeArray   = new Array() ;
	
	//var facility_id		=	document.frames.FormReturnMedicationQueryCriteria.facility_id.value;
	var ordering_facility_id = document.FormReturnMedicationQueryCriteria.OrderingFacility.options[document.frames.FormReturnMedicationQueryCriteria.OrderingFacility.selectedIndex].value;
   
	var language_id		=	document.FormReturnMedicationQueryCriteria.locale.value;
	
	var sql	=document.FormReturnMedicationQueryCriteria.SQL_PH_IP_LOCATION_SELECT.value;

	
	sql=sql.replace('#',ordering_facility_id);
	sql=sql.replace('#',login_user);
	sql=sql.replace('#',ordering_facility_id);
	//sql=sql.replace('#',patient_class);
	sql=sql.replace('#',language_id);
  
	argumentArray[0]   =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.frames.FormReturnMedicationQueryCriteria.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	
	if(retVal != null && retVal != "") {
			document.frames.FormReturnMedicationQueryCriteria.nursing_unit.value = retVal[0];
			document.frames.FormReturnMedicationQueryCriteria.nursing_unit_desc.value=retVal[1];
			
	}
}


function check_Status(obj){
	if(obj.checked==true){
		document.FormReturnMedicationQueryCriteria.Ward_Date_From.value=document.FormReturnMedicationQueryCriteria.Ward_Date_From_hidden.value;
		document.FormReturnMedicationQueryCriteria.ward_Date_To.value=document.FormReturnMedicationQueryCriteria.Ward_Date_From_hidden.value;
		document.FormReturnMedicationQueryCriteria.Ward_Date_From.disabled=false;
		document.FormReturnMedicationQueryCriteria.ward_Date_To.disabled=false;
		document.FormReturnMedicationQueryCriteria.nursing_unit_desc.disabled=false;
		document.FormReturnMedicationQueryCriteria.location_search.disabled=false;
		document.getElementById("Calendar2").disabled=false;
		document.getElementById("Calendar3").disabled=false;
		document.FormReturnMedicationQueryCriteria.eff_status_value.value="E";
		document.FormReturnMedicationQueryCriteria.rej_qty.checked=false;	//Added for GHL-SCF-790 [IN:046481]
		document.FormReturnMedicationQueryCriteria.rej_qty.value='D';	//Added for GHL-SCF-790 [IN:046481]
		document.FormReturnMedicationQueryCriteria.rej_qty.disabled=false;	//Added for GHL-SCF-790 [IN:046481]
	 }
	 else{
		document.FormReturnMedicationQueryCriteria.Ward_Date_From.value="";
		document.FormReturnMedicationQueryCriteria.ward_Date_To.value="";
		document.FormReturnMedicationQueryCriteria.nursing_unit_desc.value="";
		document.FormReturnMedicationQueryCriteria.Ward_Date_From.disabled=true;
		document.FormReturnMedicationQueryCriteria.ward_Date_To.disabled=true;
		document.FormReturnMedicationQueryCriteria.nursing_unit_desc.disabled=true;
		document.FormReturnMedicationQueryCriteria.location_search.disabled=true;
		document.getElementById("Calendar2").disabled=true;
		document.getElementById("Calendar3").disabled=true;
		document.FormReturnMedicationQueryCriteria.eff_status_value.value="D";
		document.FormReturnMedicationQueryCriteria.rej_qty.checked=false;	//Added for GHL-SCF-790 [IN:046481]
		document.FormReturnMedicationQueryCriteria.rej_qty.value='D';	//Added for GHL-SCF-790 [IN:046481]
		document.FormReturnMedicationQueryCriteria.rej_qty.disabled=true;	//Added for GHL-SCF-790 [IN:046481]
	}
 }
 
function setRej_Qty(obj){//Added for GHL-SCF-790 [IN:046481]

	if(document.frames.FormReturnMedicationQueryCriteria.eff_status.checked==true && obj.checked==true){
		document.frames.FormReturnMedicationQueryCriteria.rej_qty.value='E';	}
	else{
		document.frames.FormReturnMedicationQueryCriteria.rej_qty.value='D';
		obj.checked= false;
	}
}

function validateDate(obj){
	CheckDate(obj);
}

function StoreCheck(StoreCount){
	frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	totalrows=frmobj.totalrows.value;
	if(StoreCount=="0"){
	for (i=1;i<=totalrows ;i++ ){
		obj=eval("frmobj.actualReturn"+i);
		if ((obj.value!="0")&&(obj.value!="")&&(obj.disabled==false)){
			//alert("actualReturn----->"+obj.value);	
			alert(getMessage("ITEM_IS_NOT_ASSIGNED","PH"));
			obj.disabled=true;
			
		} //end if
				
	  }//end for
	} //end if
 }

function callBatchDetails(querystring,FacilityFlag){ // ,FacilityFlag added for FD-Bru-HIMS-CRF-091
// Check for Mandatory Fields
	var formObj	=	document.FormReturnMedicationRemarks;
	var formObj1	=	parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria;//added for MMS-QH-CRF-0201 [IN:052255] 
	var fields=new Array();
	var barcode="";
	fields[0]=formObj.ReturnRemarks;
	var names=new Array();
	names[0]=getLabel("Common.remarks.label","Common");
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;
	if (blankObject!=null){
		return;
	}
	var homepage = formObj1.homepage.value;//added for MMS-QH-CRF-0201 [IN:052255] - start
	if(homepage!='dispmed' && homepage!='directDisp'){
		parent.parent.f_query_add_mod.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	else{ //if condition and else block added for MMS-QH-CRF-0201 [IN:052255] - end
		parent.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	//we have to refer 2 forms here
	formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug
	formObjremarks=document.FormReturnMedicationRemarks;
	var barcode_applicable=formObjremarks.barcode_applicable.value;

	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
	if(homepage!='dispmed' && homepage!='directDisp'){ //if condition and else block added for MMS-QH-CRF-0201 [IN:052255] 
		if(FacilityFlag!="Y")
			FormStore=parent.parent.f_query_add_mod.retmedicationqueryframe.FormReturnMedicationQueryCriteria.FromStore.options[parent.parent.f_query_add_mod.retmedicationqueryframe.FormReturnMedicationQueryCriteria.FromStore.selectedIndex].value;
		else
			FormStore="";
	}
	else{
		if(FacilityFlag!="Y")
			FormStore=parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.FromStore.options[parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.FromStore.selectedIndex].value;
		else
			FormStore="";
	}
	//FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
	//loop through the check boxes and get value of selected check boxes...value is nothing but drug code
	check=formObjdrug.DrugSelect;
	drugid=formObjdrug.drugid;
	
	if(barcode_applicable == "Y"){

		var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
		  checkcount=formObjdrug.total_count.value;
		var formObj	=	document.FormReturnMedicationRemarks;
		check=formObjdrug.DrugSelect;
		drugid=formObjdrug.drugid;
		
		var checkstring="";
		for (var i=1;i<=checkcount;i++ ){
			
			if(eval("formObjdrug.check_id"+i).checked == true){
			if(eval("formObjdrug.barcode_id"+i).value == "")  //Added for IN032747 - end
			{      if(i == checkcount){
				//alert(i+""+eval("formObjdrug.drug_id"+i).value);
				 checkstring+="'"+eval("formObjdrug.drug_id"+i).value+"'";
			} 
			else{
				
				checkstring+="'"+eval("formObjdrug.drug_id"+i).value+"'"+",";
			}
				  
			      
			}
			else{
				 barcode=eval("formObjdrug.barcode_id"+i).value;
			}
		}
			
		}
		
		if(checkstring == "" && barcode== "" ){
			alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
			formObj.barCodeId.focus();
			return false;
		}
		else{
			for (var i=1;i<=checkcount;i++ ){
				
				eval("formObjdrug.check_id"+i).disabled=true;
				}
		}
		remarks=formObjremarks.ReturnRemarks.value;
		//disable both drug and remarks frame
		formObjremarks.ReturnRemarks.disabled=true;
		formObjremarks.proceed.disabled=true;
		
		formObjdrug.SelectAll.disabled=true;
		
		//populate the action frame
		//---reference ===parent.mainframeset.rows="24%,5%,*,5%,0%"
		//parent.mainframeset.rows="20%,5%,20%,*,7%";
		parent.document.getElementById('retmedicationqueryframe').style.height = "24vh"; 
		parent.document.getElementById('retmedicationplineframe').style.height = "10vh";
		parent.document.getElementById('innerdiv').style.height = "60vh";
	    parent.document.getElementById('retmedicationdrugframe').style.height = "55%";
	    parent.document.getElementById('retmedicationremarksframe').style.height = "60%"; 
	    parent.document.getElementById('retmedicationactionframe').style.height = "60vh"; 
	    parent.document.getElementById('retmedicationbuttonframe').style.height = "5vh"; 
		if(barcode_applicable == "Y"){
			parent.retmedicationactionframe.location.href="../../ePH/jsp/ReturnMedicationAction.jsp?"+querystring+"&remarks="+remarks+"&drugcodes="+checkstring+"&FormStore="+FormStore+"barcode"+barcode;
		}
		else
			parent.retmedicationactionframe.location.href="../../ePH/jsp/ReturnMedicationAction.jsp?"+querystring+"&remarks="+remarks+"&drugcodes="+checkstring+"&FormStore="+FormStore;
		
	}
		else{
		var checkstring="";
	
	if (isNaN(check.length)){
		if (check.checked){	
			checkstring="'"+drugid.value+"'";
			//disabling all select boxes
			check.disabled=true;
		}
	}
	else{
		for (i=0;i<check.length ;i++ ){
			if (check[i].checked){
				if (i==check.length-1){
					checkstring+="'"+drugid[i].value+"'";
				}
				else{
					checkstring+="'"+drugid[i].value+"'"+",";
				}
			}
			check[i].disabled=true;
		}
	}	
	remarks=formObjremarks.ReturnRemarks.value;
	//disable both drug and remarks frame
	formObjremarks.ReturnRemarks.disabled=true;
	formObjremarks.proceed.disabled=true;
	
	formObjdrug.SelectAll.disabled=true;
	//populate the action frame
	
	
	//parent.mainframeset.rows="20%,5%,20%,*,7%";
		parent.document.getElementById('retmedicationqueryframe').style.height = "25vh"; 
		parent.document.getElementById('retmedicationplineframe').style.height = "10vh";
		parent.document.getElementById('innerdiv').style.height = "60vh";
	    parent.document.getElementById('retmedicationdrugframe').style.height = "55%";
	    parent.document.getElementById('retmedicationremarksframe').style.height = "45%"; 
	    parent.document.getElementById('retmedicationactionframe').style.height = "0vh"; 
	    parent.document.getElementById('retmedicationbuttonframe').style.height = "5vh"; 

		parent.retmedicationactionframe.location.href="../../ePH/jsp/ReturnMedicationAction.jsp?"+querystring+"&remarks="+remarks+"&drugcodes="+checkstring+"&FormStore="+FormStore;

		}	
		}

function validateDate1(){

	var formObj = document.FormReturnMedicationQueryCriteria;
	if (formObj.Ward_Date_From.value!="" && formObj.ward_Date_To.value!=""){
		if(!doDateCheck(formObj.Ward_Date_From,formObj.ward_Date_To,parent.parent.messageFrame)){
			formObj.ward_Date_To.select();
		}else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}


function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

 if ((url.indexOf("returnmedicationframes")!=-1) ){
		//f_query_add_mod.retmedicationqueryframe.FormReturnMedicationQueryCriteria.reset();
		f_query_add_mod.retmedicationqueryframe.location.reload();
		f_query_add_mod.retmedicationdrugframe.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.retmedicationremarksframe.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.retmedicationplineframe.location.href="../../eCommon/html/blank.html";
		messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
}


function apply(){
	frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	eff_status=frmobj.eff_status.value;
/*	//Added for MMS-MD-SCF-0006 (billing issue)  starts
	var bl_interface_yn      = parent.retmedicationactionframe.document.FormReturnMedicationAction.bl_interface_yn.value;
	var disp_cash_coll_stage = parent.retmedicationactionframe.document.FormReturnMedicationAction.disp_cash_coll_stage.value;
	var patient_class        = parent.retmedicationactionframe.document.FormReturnMedicationAction.patient_class.value;
	//alert("bl_interface_yn :"+bl_interface_yn+":"+disp_cash_coll_stage+":"+patient_class);
	var val_billing="";
	/*if(bl_interface_yn=='Y'&& disp_cash_coll_stage =='D'&& patient_class!='I'){
	    $.ajax({
	        url:"../../eBL/jsp/BLCashCounterReceiptRefundValidation.jsp",
	        type:'post',
	        async : false,
	        data: {
	              episodeType:patient_class, // "I","O","D","E"..
	              receiptRefundIndicator:"REFUND"  // "REFUND" , "RECEIPT"
	          },
	        success: function(data) {
	           var obj_billing = jQuery.parseJSON(data);
	            if(obj_billing.flag=="N"){//Y - Success  , N - Failure
	            	alert(getMessage(obj_billing.messageid,"BL"));
	            	val_billing = obj_billing.flag;
	            	return false;
	            }
	        }
	});
	}
	 if(val_billing=="N"){
		 return false;
	 }
	//Added for MMS-MD-SCF-0006 (billing issue)  end*///commented for MMS-MD-SCF-0006.1 (billing issue)
	if(eff_status=="D"){
	//Added for GHL-CRF-0413.8 start
	
		//Added for GHL-CRF-0413.8 end
		totalrows=frmobj.totalrows.value;
		count=0;
		srlnobatcharray=new Array();
		srlnoarray=new Array();
		dispnoarray=new Array();
		patientid=frmobj.patientid.value;
		arrcount=0;
		arrcount1=0;		//added for AAKH-SCF-0195 [IN:054909] start
		dispnoarray1=new Array();	
		var actValue = 0;
		var count_D=totalrows;//Added for GHL-CRF-0413.8
		var base_to_disp_uom_equl = 0;
		var final_conv_factor = 0;    //added for AAKH-SCF-0195 [IN:054909] end
		if(frmobj.barcodeFlag.value=="Y"){ // if and else condition Added for GHL-CRF-0413.8[IN063028] - if condition Added for GHL-CRF-0413.8[IN063028] and else for existing fucntionality - Start
			
			for (i=1;i<=totalrows ;i++ ){
				if(eval("frmobj.check_return_name"+i).checked==true){
					count_D--;	
				obj=eval("frmobj.actualReturn"+i);
				if(dispnoarray1.length>0){ //added for AAKH-SCF-0195 [IN:054909] start
					var actValue1 = 0;
					for(var j=0;j<dispnoarray1.length;j++){
						if(dispnoarray1[j]!=undefined){
							var splitarray = dispnoarray1[j].split("_");
							if(splitarray[0] == eval("frmobj.dispno"+i).value && obj.value!="" && splitarray[5] == eval("frmobj.srlno"+i).value && splitarray[4] == eval("frmobj.item_code"+i).value){
								dispnoarray1.splice(j,1);
								actValue1 = Number(actValue)+Number(obj.value);
								if(arrcount1>0)
								arrcount1--;
							}
						}
					}
					if(actValue1!=0)
						actValue = actValue1;
					else
						actValue = obj.value;
				}
				base_to_disp_uom_equl=eval("frmobj.base_to_disp_uom_equl"+i).value;
				final_conv_factor=eval("frmobj.final_conv_factor"+i).value;
				if(actValue==0)
					actValue = obj.value;	//added for AAKH-SCF-0195 [IN:054909] end
				if ((eval(obj.value)!=0)&&(obj.value!="")&&(obj.disabled==false)){
					if(eval("frmobj.bin_location_code"+j) && eval("frmobj.bin_location_code"+j).value==""){
						//alert(getMessage("PH_ACK_REQ_NOT_SELECTED","PH"));
						alert(getMessage("PH_BIN_LOCATION","PH"));	
						return;
					}
					count=1;
					srlnoarray[arrcount]=eval("frmobj.srlno"+i).value;
					srlnobatcharray[arrcount]=eval("frmobj.srlnobatch"+i).value;
					dispnoarray[arrcount++]=eval("frmobj.dispno"+i).value;
				}
				dispnoarray1[arrcount1++]=eval("frmobj.dispno"+i).value+"_"+base_to_disp_uom_equl+"_"+final_conv_factor+"_"+actValue+"_"+eval("frmobj.item_code"+i).value+"_"+eval("frmobj.srlno"+i).value;	//added for AAKH-SCF-0195 [IN:054909] start
			}
		}
			
			
			if(count_D==totalrows){
				alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
				   return;
			}	
	}
		//Added for GHL-CRF-0413.8 end
	else{
		for (i=1;i<=totalrows ;i++ ){
			obj=eval("frmobj.actualReturn"+i);
			if(dispnoarray1.length>0){ //added for AAKH-SCF-0195 [IN:054909] start
				var actValue1 = 0;
				for(var j=0;j<dispnoarray1.length;j++){
					if(dispnoarray1[j]!=undefined){
						var splitarray = dispnoarray1[j].split("_");
						if(splitarray[0] == eval("frmobj.dispno"+i).value && obj.value!="" && splitarray[5] == eval("frmobj.srlno"+i).value && splitarray[4] == eval("frmobj.item_code"+i).value){
							dispnoarray1.splice(j,1);
							actValue1 = Number(actValue)+Number(obj.value);
							if(arrcount1>0)
							arrcount1--;
						}
					}
				}
				if(actValue1!=0)
					actValue = actValue1;
				else
					actValue = obj.value;
			}
			base_to_disp_uom_equl=eval("frmobj.base_to_disp_uom_equl"+i).value;
			final_conv_factor=eval("frmobj.final_conv_factor"+i).value;
			if(actValue==0)
				actValue = obj.value;	//added for AAKH-SCF-0195 [IN:054909] end
			if ((eval(obj.value)!=0)&&(obj.value!="")&&(obj.disabled==false)){
				if(eval("frmobj.bin_location_code"+j) && eval("frmobj.bin_location_code"+j).value==""){
					//alert(getMessage("PH_ACK_REQ_NOT_SELECTED","PH"));
					alert(getMessage("PH_BIN_LOCATION","PH"));	
					return;
				}
				count=1;
				srlnoarray[arrcount]=eval("frmobj.srlno"+i).value;
				srlnobatcharray[arrcount]=eval("frmobj.srlnobatch"+i).value;
				dispnoarray[arrcount++]=eval("frmobj.dispno"+i).value;
			}
			dispnoarray1[arrcount1++]=eval("frmobj.dispno"+i).value+"_"+base_to_disp_uom_equl+"_"+final_conv_factor+"_"+actValue+"_"+eval("frmobj.item_code"+i).value+"_"+eval("frmobj.srlno"+i).value;	//added for AAKH-SCF-0195 [IN:054909] start
		}
	}
		if(dispnoarray1.length>0){ 	//added for AAKH-SCF-0195 [IN:054909] start
			for(var i=0;i<dispnoarray1.length;i++){
				var str = dispnoarray1[i];
				if(str != undefined){
					var detail  = str.split("_");
					if(((detail[3]*detail[1])%detail[2]) != '0'){
						alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(detail[2]/detail[1])+" for dispno "+detail[0]);
						obj.focus();
						return false;
					}
				}
			}
		}//added for AAKH_SCF_0195 end
		if (count==0){
			alert(getMessage("PH_NO_RET_QTY","PH"));
			return;
		}
		eval( formApply(frmobj, PH_CONTROLLER) ) ;
		if (result){
			onSuccess(frmobj,srlnoarray,srlnobatcharray,dispnoarray,patientid);
		}
		else{
			if(message==getMessage("CANNOT_RETURN","PH"))  // Added for GHL-CRF-0412.3 - Start
			{
				alert(message);
				return;
			} // Added for GHL-CRF-0412.3 - End
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			/*if(flag!=0){
				  parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message + getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18'><b>"+flag+"</b></label>";
			}else{
				 parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message ;
			}*/
		}
	}
	else if(eff_status=="E"){
		totalRows1=frmobj.totalRows1.value;
		var flag = false ;
		var count = totalRows1; // Added for GHL-CRF-0413.8[IN063028]
		if(frmobj.barcodeFlag.value=="Y"){ // if and else condition Added for GHL-CRF-0413.8[IN063028] - if condition Added for GHL-CRF-0413.8[IN063028] and else for existing fucntionality - Start
			for (var j=1;j<=totalRows1 ;j++ ){
				var AcceptedQty = parseInt(eval("frmobj.AcceptedQty"+j).value);
				var RejectedQty = parseInt(eval("frmobj.RejectedQty"+j).value);
				var BalanceQty = parseInt(eval("frmobj.BalanceQty"+j).value);
				var returnQty   = parseInt(eval("frmobj.returnable"+j).value);
			if(eval("frmobj.check_name"+j).checked==true){
				count--;
				if(eval("frmobj.bin_location_code"+j) && eval("frmobj.bin_location_code"+j).value==""){
					alert(getMessage("PH_BIN_LOCATION","PH"));
					return;
				}
				if(eval("frmobj.acknow_ledg"+j).value==""){
					alert(getMessage("PH_ACK_REQ_NOT_SELECTED","PH"));
					return;
				}
				if(eval("frmobj.acknow_ledg"+j).value!=""){
					if(BalanceQty >= 0 && (AcceptedQty >0 || RejectedQty >0)){
						if(eval("frmobj.acknow_ledg"+j).value=="P"){
							if(eval("frmobj.remarks_desc"+j).value==""){
								alert(getMessage("RET_MED_REMARKS_PAR_ACC_REJ","PH"));
								return;
							}
							eval("frmobj.actualReturn"+j).value = AcceptedQty ;
							flag= true;
						}
						else if(eval("frmobj.acknow_ledg"+j).value=="A"){
							if(eval("frmobj.bin_location_code"+j).value==""){
								alert(getMessage("BIN_MAND_FOR_ACC_ITEMS","PH"));
								eval("frmobj.bin_location_code"+j).focus();
							}//END IF
							if(AcceptedQty<returnQty)
								{
								alert(getMessage("ACPT_QTY_SAME_AS_RET_QTY","PH"));
 								return;
								}
							flag= true;
						}
						else if(eval("frmobj.acknow_ledg"+j).value=="R"){	
							if(eval("frmobj.bin_location_code"+j).value==""){
								alert(getMessage("BIN_MAND_FOR_ACC_ITEMS","PH"));
								eval("frmobj.bin_location_code"+j).focus();
							}//END IF
							flag= true;
						}
					}//END IF 
					else{
						if(eval("frmobj.acknow_ledg"+j).value != ''  && (AcceptedQty <=0 || isNaN(AcceptedQty)) && RejectedQty <=0){
							alert(getMessage("TOT_ACC_REJ_QTY_RET_QTY_CHK1","PH"));
							return false;
						}
					}
				}
				else{
					eval("frmobj.actualReturn"+j).value = "0";
					if(AcceptedQty != 0 || RejectedQty != 0 ){
						alert(getMessage("RET_MED_TOTAL_QTY_EXC","PH"));
					}
					eval("frmobj.AcceptedQty"+j).value = "0";
					eval("frmobj.RejectedQty"+j).value = "0";
					eval("frmobj.BalanceQty"+j).value = "0";
				}
			}
			}//end for loop
			if(count==totalRows1){
				alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
				   return;
			}		
		}
		else{
		for (var j=1;j<=totalRows1 ;j++ ){
			var AcceptedQty = parseInt(eval("frmobj.AcceptedQty"+j).value);
			var RejectedQty = parseInt(eval("frmobj.RejectedQty"+j).value);
			var BalanceQty = parseInt(eval("frmobj.BalanceQty"+j).value);
			var returnQty   = parseInt(eval("frmobj.returnable"+j).value);
			if(eval("frmobj.bin_location_code"+j) && eval("frmobj.bin_location_code"+j).value==""){
				alert(getMessage("PH_BIN_LOCATION","PH"));
				return;
			}
			if(eval("frmobj.acknow_ledg"+j).value==""){
				alert(getMessage("PH_ACK_REQ_NOT_SELECTED","PH"));
				return;
			}
			if(eval("frmobj.acknow_ledg"+j).value!=""){
				if(BalanceQty >= 0 && (AcceptedQty >0 || RejectedQty >0)){
					if(eval("frmobj.acknow_ledg"+j).value=="P"){
						if(eval("frmobj.remarks_desc"+j).value==""){
							alert(getMessage("RET_MED_REMARKS_PAR_ACC_REJ","PH"));
							return;
						}
						eval("frmobj.actualReturn"+j).value = AcceptedQty ;
						//eval("frmobj.AcceptedQty"+j).value = AcceptedQty + RejectedQty ;
						flag= true;
					}
					else if(eval("frmobj.acknow_ledg"+j).value=="A"){
						if(eval("frmobj.bin_location_code"+j).value==""){
							alert(getMessage("BIN_MAND_FOR_ACC_ITEMS","PH"));
							eval("frmobj.bin_location_code"+j).focus();
						}//END IF
						flag= true;
					}
					else if(eval("frmobj.acknow_ledg"+j).value=="R"){	  /** @Name - Surendra reddy  @Date - 22/12/2009  @Inc# - IN017528 * @Desc -added rejected condition code. */
						if(eval("frmobj.bin_location_code"+j).value==""){
							alert(getMessage("BIN_MAND_FOR_ACC_ITEMS","PH"));
							eval("frmobj.bin_location_code"+j).focus();
						}//END IF
						flag= true;
					}
				}//END IF 
				else{ //else block added for IN056493
					if(eval("frmobj.acknow_ledg"+j).value != ''  && AcceptedQty <=0 && RejectedQty <=0){
						alert(getMessage("TOT_ACC_REJ_QTY_RET_QTY_CHK1","PH"));
						return false;
					}
				}
			}
			else{
				eval("frmobj.actualReturn"+j).value = "0";
				if(AcceptedQty != 0 || RejectedQty != 0 ){
					alert(getMessage("RET_MED_TOTAL_QTY_EXC","PH"));
				}
				eval("frmobj.AcceptedQty"+j).value = "0";
				eval("frmobj.RejectedQty"+j).value = "0";
				eval("frmobj.BalanceQty"+j).value = "0";
				//eval("frmobj.AcceptedQty"+j).focus();
				//eval("frmobj.AcceptedQty"+j).select();
				//return false;
			}
		}//end for loop
		}	// if and else condition Added for GHL-CRF-0413.8[IN063028] - if condition Added for GHL-CRF-0413.8[IN063028] and else for existing fucntionality - End
		if(flag){
			srlnobatcharray=new Array();
			srlnoarray=new Array();
			dispnoarray=new Array();
			patientid=frmobj.patientid.value;
			count=0;
			arrcount=0;
			for (i=1;i<=totalRows1 ;i++ ){
				count=1;
				if(eval("frmobj.acknow_ledg"+i).value=="A" ){
					srlnoarray[arrcount]=eval("frmobj.srlno"+i).value;
					srlnobatcharray[arrcount]=eval("frmobj.srlnobatch"+i).value;
					dispnoarray[arrcount++]=eval("frmobj.dispno"+i).value;
				 }
				if(eval("frmobj.acknow_ledg"+i).value=="P" && parseInt(eval("frmobj.AcceptedQty"+i).value)>0){
					srlnoarray[arrcount]=eval("frmobj.srlno"+i).value;
					srlnobatcharray[arrcount]=eval("frmobj.srlnobatch"+i).value;
					dispnoarray[arrcount++]=eval("frmobj.dispno"+i).value;
				}
			}
			eval( formApply(frmobj, PH_CONTROLLER) );
			if (result){
				onSuccess(frmobj,srlnoarray,srlnobatcharray,dispnoarray,patientid);
			}
			else{
				alert(message); // code added by rawther
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			}
		}
		else{
			alert(getMessage("PH_NO_CHANGE","PH"));
		}
    }//END ELSE
} //END APPLY 

function onSuccess(frm,srlnoarray,srlnobatcharray,dispnoarray,patientid){
	
	var bean_id=parent.retmedicationactionframe.document.FormReturnMedicationAction.bean_id.value;
	var bean_name=parent.retmedicationactionframe.document.FormReturnMedicationAction.bean_name.value;

	var bl_interface_yn      = parent.retmedicationactionframe.document.FormReturnMedicationAction.bl_interface_yn.value;
	var disp_cash_coll_stage = parent.retmedicationactionframe.document.FormReturnMedicationAction.disp_cash_coll_stage.value;
	var patient_class        = parent.retmedicationactionframe.document.FormReturnMedicationAction.patient_class.value;
	var disp_locn_code       = parent.retmedicationactionframe.document.FormReturnMedicationAction.disp_locn_code.value;
	var homepage = ''; //added for MMS-QH-CRF-0201 [IN:052255]  -start
	if(parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.homepage.value != null)
		homepage = parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.homepage.value;  //added for MMS-QH-CRF-0201 [IN:052255]  -end
	
	var call_printReport =false;
	if(dispnoarray.length!=0){
	   call_printReport=true;
	}
	var responseText         = "";
	//ask for printing of online report
	var printReport = false;
	if(call_printReport)  {
		printReport = confirm(getMessage("PRINT_RET_MED_VOUCHER","PH"));
	}
	
	if (printReport) { 
		if(homepage!='dispmed' && homepage!='directDisp') //if block added for MMS-QH-CRF-0201 [IN:052255] 
		  	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;	 // changed to err_num=message from err_num=Processing Report... for KAUH-SCF-035[In:33236] 					
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH  /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReturnMedicationPrintReport.jsp?func_mode=PrintReport"+"&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&srlno=" + srlnoarray+"&srlnobatch="+srlnobatcharray+"&dispno="+dispnoarray+"&patientid="+patientid, true ) ;
		xmlHttp.send( xmlDoc ) ;
		//responseText=xmlHttp.responseText ;
	} 
	if((bl_interface_yn=='Y'&& disp_cash_coll_stage =='D'&& patient_class!='I')&& (call_printReport)){
		getbillingdetails(bean_id,bean_name,disp_locn_code);
	}
	else{
		clearframes();
	}
}
	
function getbillingdetails(bean_id,bean_name,disp_locn_code){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "ReturnMedicationLoginTemporary.jsp?identity=GETBLDETAILS"+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code , false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

async function callbillingwindow(doc_det_for_bl,disp_locn_code){
	
	detail = doc_det_for_bl.split(",");
	/*var doc_no   =  detail[0];
	var doc_type =  detail[1];
	var bill_group_code =  detail[2];
	var error_text =  detail[3];
	*/
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
	var episode_id="";
	var visit_id ="";
	
	if(error_text==''){
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
		var dialogHeight = "40vh" ;
		var dialogWidth = "70vw" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";		
		//var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+doc_type+"&"+"billdocnum="+doc_no+"&"+"storecode="+disp_locn_code+"&"+"blnggrp="+bill_group_code+"&"+"module_id=PH";	
		//retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);
		 var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_no + "&store_code=" + disp_locn_code + "&blng_grp=" + bill_group_code + "&module_id=PH&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+patient_class;
		 retVal=await window.showModalDialog(url,arguments,features);
		 
		 if(retVal==undefined){
			callbillingwindow(doc_det_for_bl,disp_locn_code);
		}
		 else{
			clearframes();
		 }
	}
	else{
		
		if(error_text!=undefined){
			alert(error_text);
		}
		clearframes();
	}	
}

function clearframes(){
	var homepage = ""; //added for MMS-QH-CRF-0201 [IN:052255] -start
	if(parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.homepage.value != null)
		homepage			 = parent.retmedicationqueryframe.FormReturnMedicationQueryCriteria.homepage.value; //added for MMS-QH-CRF-0201 [IN:052255]  -end
	if(homepage!='dispmed' && homepage!='directDisp'){ //if condition and else block added for MMS-QH-CRF-0201 [IN:052255] 
		if(flag!=0){
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message + getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18'><b>"+flag+"</b></label>";
			var print_yn="N";
			var patient_id=	parent.retmedicationactionframe.document.FormReturnMedicationAction.patientid.value;
			var print_confirm=confirm(getMessage("PH_PRINT_TOKEN", "PH"));
			if(print_confirm){
				print_yn="Y";
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH  /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "ReturnMedicationPrintReport.jsp?func_mode=onLinePrinting"+"&patient_id=" + patient_id + "&flag=" + flag, true);
				xmlHttp.send( xmlDoc ) ;
			}
		}
		else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message ;
		}
	   	// parent.parent.f_query_add_mod.retmedicationqueryframe.FormReturnMedicationQueryCriteria.reset();
		parent.parent.f_query_add_mod.retmedicationqueryframe.location.reload();
		parent.parent.f_query_add_mod.retmedicationdrugframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationremarksframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		parent.parent.f_query_add_mod.retmedicationplineframe.location.href="../../eCommon/html/blank.html";
	}
	else{
		window.close();
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function  enableProceed(obj){
	formObj=document.FormReturnMedicationDrug;
	if (obj.checked==false){
		formObj.SelectAll.checked=false;
	}
	check=formObj.DrugSelect;
	vcheck=false;
	if (isNaN(check.length)){
		if (check.checked){
			parent.retmedicationremarksframe.FormReturnMedicationRemarks.proceed.disabled=false;		
		}
		else{
			parent.retmedicationremarksframe.FormReturnMedicationRemarks.proceed.disabled=true;		
		}
		return;
	}
	for (i=0;i<check.length ;i++ ){
		if (check[i].checked){
			parent.retmedicationremarksframe.FormReturnMedicationRemarks.proceed.disabled=false;		
			return;
		}
	}
	parent.retmedicationremarksframe.FormReturnMedicationRemarks.proceed.disabled=true;	
}

function checkQty(obj,conv_factor,base_to_disp_uom_equl,base_to_def_uom_equl,dflt_issue_uom,DetailsUom,count){//count added for ICN 63722

	var str="";
	if(base_to_disp_uom_equl==0||base_to_disp_uom_equl==null||base_to_disp_uom_equl==''){
	    if(DetailsUom==null||DetailsUom=="null")
		   DetailsUom="";
		str= DetailsUom;
	}
	if(base_to_def_uom_equl==0||base_to_def_uom_equl==null||base_to_def_uom_equl==''){
		
		if(dflt_issue_uom==null||dflt_issue_uom=="null")
		  dflt_issue_uom="";
		str=str+" , "+dflt_issue_uom;
	}
		 
	if(str!=''){
		 alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND_FOR","PH")+" "+str)    ;
		 obj.value="";
		 return;
	  }
	
	obj.value	=	trimString(obj.value);
	actual		=	obj.value;
	formObj		=	document.FormReturnMedicationAction;
	id			=	obj.id;
	//find the no in the row-actualReturn contains 12 chars and so
	no			=	id.substr(12,id.length);
	//find the corresponding returnable qty
	returnable=eval("formObj.returnable"+no+".value");
	if(parseInt(conv_factor)!=0){
		if((actual%conv_factor) != 0){  //commented for AAKH-SCF-0195 [IN:054909]  // comment removed for ML-BRU-SCF-1880
			alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);
			obj.focus();
		}
		if (parseFloat(returnable)<parseFloat(actual) )	{
			//alert("The returnable Quantity is only "+returnable+"!!!");
			alert(getMessage("PH_EXCEED_BALANCE_QTY","PH"));
			obj.select();
			obj.value="";
			obj.focus();
		}
	}
	else{
		//alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND_FOR","PH"));
		
		alert((getMessage("PH_ITEM_UOM_DEF_NOT_FOUND_FOR","PH"))+" "+DetailsUom+" , "+dflt_issue_uom);
		obj.value="";
		return;
	}
	//Added for GHL-CRF-0413.8 ICN 63722 START
	var barcodeFlag = formObj.barcodeFlag.value;
	if(barcodeFlag == "Y"){
	var new_ret_qty=obj.value;
	var ct=count;
	
	var bean_id             = formObj.bean_id.value;
    var bean_name           = formObj.bean_name.value;
    
   // if(barcodeFlag == "Y"){
		//var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
		// var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc	='';
	
		xmlHttp.open("POST", "ReturnMedicationLoginTemporary.jsp?identity=INCREMENTACTION"+"&bean_id=" + bean_id + "&bean_name=" + bean_name +"&count="+ct+"&new_ret_qty="+new_ret_qty, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		
	}
	
    //Added for GHL-CRF-0413.8 ICN 63722 START

	
}
//
function cancelAction(){
	var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	//Added for GHL-CRF-0413.8 START
	var bean_id             = frmobj.bean_id.value;
    var bean_name           = frmobj.bean_name.value;
    var barcodeFlag = frmobj.barcodeFlag.value;
    //Added for GHL-CRF-0413.8 end
	if(frmobj.eff_status.value == "D" )	{
		document.location.href="../../eCommon/html/blank.html";
		parent.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		//parent.mainframeset.rows="17%,5%,*,0%,0%";
		parent.document.getElementById('retmedicationqueryframe').style.height = "25vh"; 
		parent.document.getElementById('retmedicationplineframe').style.height = "10vh";
		parent.document.getElementById('innerdiv').style.height = "60vh";
	    parent.document.getElementById('retmedicationdrugframe').style.height = "55%";
	    parent.document.getElementById('retmedicationremarksframe').style.height = "45%"; 
	    parent.document.getElementById('retmedicationactionframe').style.height = "0vh"; 
	    parent.document.getElementById('retmedicationbuttonframe').style.height = "5vh"; 
		//also enable the top frame
		formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug
		formObjremarks=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
		//loop through the check boxes and get value of selected check boxes...value is nothing but drug code
		check=formObjdrug.DrugSelect;
		if (isNaN(check.length)){
			check.disabled=false;

		}
		else{
			for (i=0;i<check.length ;i++ ){
				check[i].disabled=false;
			}
		}	
       //Added for GHL-CRF-0413.8 START
		if(barcodeFlag == "Y"){
		// var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
		//  var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
    	var xmlDoc ="";
		xmlHttp.open("POST", "ReturnMedicationLoginTemporary.jsp?identity=CANCELACTION"+"&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		 xmlHttp.send(xmlDoc);
		// xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	// xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval(responseText);
		}
		//Added for GHL-CRF-0413.8 end
		//disable both drug and remarks frame
		formObjremarks.ReturnRemarks.disabled=false;
		formObjremarks.proceed.disabled=false;
		formObjdrug.SelectAll.disabled=false;
	}
	else{
		parent.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationplineframe.location.href="../../eCommon/html/blank.html";
		parent.retmedicationbuttonframe.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
}

function  selectAll(obj){
	var flag ="";
	if (obj.checked==false){
		//return;
		flag="false";
	}
	else{
		flag="true";
	}
	formObj=document.FormReturnMedicationDrug;
	check=formObj.DrugSelect;

	if (isNaN(check.length)){
		check.checked=true;
		//alert("single checked box");
		formObjremarks=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
		formObjremarks.proceed.disabled=false;
		return;
	}
	for (i=0;i<check.length ;i++ ){
		if(flag=='true'){
		   check[i].checked=true;
		}else{
			check[i].checked=false;
		}
	}
	formObjremarks=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
	if(flag=='true'){
	   formObjremarks.proceed.disabled=false;
	}
	else{
		formObjremarks.proceed.disabled=true;
	}
}

function verification(){

	var formObj1=document.FormReturnMedicationQueryCriteria;
	//var message=" Patient ID or Dispense No must be Entered"
	var message=getMessage("PATIENT_ID_OR_DISPENSE_NO_MANDATORY","PH");
	if((formObj1.Patient_Id.value=="")&&(formObj1.Dispense_No.value=="")){
		//alert("Patient ID or Dispense No must be entered");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		allow=false;
	}
	else{
		allow=true;
	}
}

function uppercase() {
	key = window.event.keyCode;
	 if((key>0x60) && (key< 0x7B))
	   window.event.keyCode=key-0x20;
}

function getBalance(returnQty,accept,reject,balance,cnt,fieldFlag){
	var value1 = accept.value ;
	var value2 = reject.value ;
	var balanceQty = "0";
	var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
		
	if(fieldFlag == "A" && (value2 == null || value2 == "") ){
		//eval("frmobj.AcceptedQty"+cnt).value= "0";
		accept.value = 0;
	}
	if(fieldFlag == "R" && (value2 == null || value2 == "")){
		//eval("frmobj.RejectedQty"+cnt).value= "0";
		reject.value = 0;
	}
	
	acceptQty = parseInt(value1);
	rejectQty = parseInt(value2);
	retQty	  = parseInt(returnQty);
	if(acceptQty>0 || rejectQty>0 || ((acceptQty<=0||isNaN(acceptQty)) && frmobj.barcodeFlag.value=="Y")){ // || ((acceptQty==0||acceptQty=="") && frmobj.barcodeFlag.value=="Y") added for GHL-CRF-0413.8
		if(!isNaN(acceptQty) && !isNaN(rejectQty)){
			var AccorRej=acceptQty + rejectQty;
			if((eval("frmobj.acknow_ledg"+cnt).value=="A" || eval("frmobj.acknow_ledg"+cnt).value=="P") && frmobj.barcodeFlag.value=="Y"){ // if condition added for GHL-CRF-0413.8 - Start
				if(acceptQty>0){
					eval("frmobj.check_name"+cnt).checked=true;	
					eval("frmobj.check_name"+cnt).value="Y";
				}
				else{
					eval("frmobj.check_name"+cnt).value="N";
					eval("frmobj.check_name"+cnt).checked=false;	
				}
			} // if condition added for GHL-CRF-0413.8 - End
			if(AccorRej<=retQty){
			    balanceQty = (retQty - (acceptQty + rejectQty));
				if((acceptQty>=retQty||rejectQty>=retQty) && (eval("frmobj.acknow_ledg"+cnt).value!="A")){ // && eval("frmobj.acknow_ledg"+cnt).value!="A" Added for GHL-CRF-0413.8[IN063028]
					alert(getMessage("TOT_ACXCEPT_REJECT_QTY_NOT_ALLOWED","PH"));
					if(fieldFlag=='A'){	 				    
						 eval("frmobj.AcceptedQty"+cnt).value= "0";
					}
					else if(fieldFlag=='R'){
						eval("frmobj.RejectedQty"+cnt).value= "0";
					}
					return;
				}
			}
			else{
				if(frmobj.barcodeFlag.value=="Y"){ // if else condition added for GHL-CRF-0413.8 - Start
					if(eval("frmobj.acknow_ledg"+cnt).value=='A'){
						eval("frmobj.AcceptedQty"+cnt).value= "0";
                        eval("frmobj.BalanceQty"+cnt).value= retQty;
                        eval("frmobj.check_name"+cnt).checked= false;
						eval("frmobj.check_name"+cnt).value= "N";
				        alert(getMessage("ACPT_QTY_SAME_AS_RET_QTY","PH"));
					    return;
				    }
				 else if(eval("frmobj.acknow_ledg"+cnt).value=='R'){
				   eval("frmobj.RejectedQty"+cnt).value= "0";
				    alert(getMessage("TOT_ACC_REJ_QTY_RET_QTY_CHK","PH"));
				    return;
				 }
				 if(acceptQty>=retQty||rejectQty>=retQty){
					alert(getMessage("TOT_ACXCEPT_REJECT_QTY_NOT_ALLOWED","PH"));
					return;
				}
				}
				else{
				 if(fieldFlag=='A'){
				     eval("frmobj.AcceptedQty"+cnt).value= "0";
				 }
				 else if(fieldFlag=='R'){
				   eval("frmobj.RejectedQty"+cnt).value= "0";
				 }
				 alert(getMessage("TOT_ACC_REJ_QTY_RET_QTY_CHK","PH"));
				 return;
				 if(acceptQty>=retQty||rejectQty>=retQty){
					alert(getMessage("TOT_ACXCEPT_REJECT_QTY_NOT_ALLOWED","PH"));
					return;
				}
				}  // if else condition added for GHL-CRF-0413.8  - End
			}//eval("frmobj.BalanceQty"+cnt).value= balanceQty;
			if(parseInt(balanceQty)<0){
				alert(getMessage("TOT_ACC_REJ_QTY_RET_QTY_CHK","PH"));
				if(fieldFlag=='R'){
					//eval("frmobj.RejectedQty"+cnt).value=0;
					reject.value = 0;
					balance.value = retQty - (parseInt(accept.value) + parseInt(reject.value));
				}
				else{
					//eval("frmobj.AcceptedQty"+cnt).value=0;
					accept.value = 0;
					balance.value = retQty - (parseInt(accept.value) + parseInt(reject.value));
				}
				return;
			}
			 eval("frmobj.BalanceQty"+cnt).value= balanceQty;
			//balance.value = 0;
		}
		else{	 
			//eval("frmobj.AcceptedQty"+cnt).value= "0";
			accept.value = 0;
			//eval("frmobj.RejectedQty"+cnt).value= "0";
			reject.value = 0;
		}
	}
	else{
	   eval("frmobj.BalanceQty"+cnt).value= balanceQty;
	}
}

function setFieldValue(returnQty,ackType,cnt){
	var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	
	if(ackType.value=="A" && frmobj.barcodeFlag.value=="Y"){ // if condition added for GHL-CRF-0413.8[IN063028]
		//eval("frmobj.AcceptedQty"+cnt).value= returnQty;
		eval("frmobj.RejectedQty"+cnt).value= "0";
		eval("frmobj.BalanceQty"+cnt).value= returnQty;
		eval("frmobj.AcceptedQty"+cnt).disabled = false;
		eval("frmobj.RejectedQty"+cnt).disabled = true;
		//eval("frmobj.mandatory"+cnt).style.visibility = 'hidden';
	}
	else if(ackType.value=="A"){
		eval("frmobj.AcceptedQty"+cnt).value= returnQty;
		eval("frmobj.RejectedQty"+cnt).value= "0";
		eval("frmobj.BalanceQty"+cnt).value= "0";
		eval("frmobj.AcceptedQty"+cnt).disabled = true;
		eval("frmobj.RejectedQty"+cnt).disabled = true;
		eval("frmobj.mandatory"+cnt).style.visibility = 'hidden';
	}
	else if(ackType.value=="R"){
		eval("frmobj.AcceptedQty"+cnt).value= "0";
		eval("frmobj.RejectedQty"+cnt).value= returnQty;
		eval("frmobj.BalanceQty"+cnt).value= "0";
		eval("frmobj.AcceptedQty"+cnt).disabled = true;
		eval("frmobj.RejectedQty"+cnt).disabled = true;
		eval("frmobj.mandatory"+cnt).style.visibility = 'hidden';
	}
	else if(ackType.value=="P"){
		eval("frmobj.AcceptedQty"+cnt).value= "0";
		eval("frmobj.RejectedQty"+cnt).value= "0";
		eval("frmobj.BalanceQty"+cnt).value= "0";
		eval("frmobj.AcceptedQty"+cnt).disabled = false;
		eval("frmobj.RejectedQty"+cnt).disabled = false;
		eval("frmobj.mandatory"+cnt).style.visibility = 'visible';
	}
	else{
		eval("frmobj.AcceptedQty"+cnt).value= "0";
		eval("frmobj.RejectedQty"+cnt).value= "0";
		eval("frmobj.BalanceQty"+cnt).value= "0";
		eval("frmobj.AcceptedQty"+cnt).disabled = false;
		eval("frmobj.RejectedQty"+cnt).disabled = false;
		eval("frmobj.mandatory"+cnt).style.visibility = 'hidden';
	}
}

function clearDrug(Drug_Name){
	if (Drug_Name.value == '')
		document.FormReturnMedicationQueryCriteria.Drug_Code.value = '';
	else
   		drugsearch(document.FormReturnMedicationQueryCriteria);
}

function populateEncounter(patient_id) {//	 AMS-CRF-0172
	frmObj=document.FormReturnMedicationQueryCriteria;
	patientClass = frmObj.patientClass.value;
	medn_rtn_after_bill_gen = frmObj.medn_rtn_after_bill_gen.value;
	if(patientClass=='O' && medn_rtn_after_bill_gen=='')
		return false;
	frmObj.encounterId.selectedIndex= 0 ;//code modified added for FD-JD-CRF-0178[IN039208]	
	if( frmObj.CurrentEncounter.checked == true)  
		currentEncounter ="Y"
	else
		currentEncounter ="N"
	 				
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(patientClass=="I"){	  
		xmlHttp.open( "POST", "ReturnMedicationLoginTemporary.jsp?bean_id=" +frmObj.bean_id.value + "&bean_name=" + frmObj.bean_name.value +  "&patient_id=" + patient_id+ "&patientClass=" + patientClass+"&identity=POPULATEENCOUNTER&currentEncounter="+currentEncounter, false ) ;		
	}
	else{ //code added for FD-JD-CRF-0178[IN039208]
		xmlHttp.open( "POST", "ReturnMedicationLoginTemporary.jsp?bean_id=" +frmObj.bean_id.value + "&bean_name=" + frmObj.bean_name.value +  "&patient_id=" + patient_id+ "&patientClass=" + patientClass+"&identity=POPULATEENCOUNTERFOROP", false ) ;
	}
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
}

function assignBillGenValue(bill_gen_yn){
	document.FormReturnMedicationQueryCriteria.bill_gen_yn.value = bill_gen_yn;
}

function checkValidNum(textObj){//added for MMS-DM-CRF-0039 [IN:055958]
	var textVal = textObj.value;
	if(textVal!='' &&( isNaN(textVal) || parseInt(textVal)<0)){
		alert(getMessage("ENTER_VALID_NUMBER","PH"));
		textObj.value="";
		textObj.focus();
	}
}

function callBarcodeflg(barcode_id){ //Added for GHL-CRF-0413.8[IN063028]  - Start		
	var frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	if(barcode_id==undefined || barcode_id==""){
		alert(getMessage('NOT_A_VALID_BARCODE','PH'));
		parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
		return false;
	}
	else{
		totalrows=frmobj.totalRows1.value;
		var count=0,preScanned = 1;
		for(var i=1;i<=totalrows;i++){
			if(eval("frmobj.barcode_id"+i).value == barcode_id.value){ 
			count=2;//added for 63761 
			if(eval("frmobj.acknow_ledg"+i).value=="A"){
				eval("frmobj.AcceptedQty"+i).disabled = false;
				var avilqty=eval("frmobj.AcceptedQty"+i).value;//added for 63761 
				var retqty=parseInt(eval("frmobj.returnable"+i).value);//added for 63761 
				if(avilqty=="")//added for 63761 start
					{
					avilqty=0;
					}//added for 63761 end
				//if(eval("frmobj.AcceptedQty"+i).value<eval("frmobj.returnable"+i).value){//commented for 63761 
				if(avilqty<retqty){//Modified condition for 63761 
				   eval("frmobj.AcceptedQty"+i).value++;
				   eval("frmobj.BalanceQty"+i).value--;
				   eval("frmobj.check_name"+i).checked = true;
				   eval("frmobj.check_name"+i).value = "Y";
				   parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
				   count=1;
				  break;
				}
				else{
					count=2;//added for 63761 
				//Removed for 63761 start
					/*if(i==totalrows){//if contition added for 63761
					alert(getMessage('ACPT_QTY_SAME_AS_RET_QTY', 'PH'));
					parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
					return;
					}//end curlybarce 63761*/
					//Removed for 63761 end
				}
			}
			else if(eval("frmobj.acknow_ledg"+i).value=="P"){
				eval("frmobj.AcceptedQty"+i).disabled = false;
				if(eval("frmobj.AcceptedQty"+i).value<(eval("frmobj.returnable"+i).value)-1){
				   eval("frmobj.AcceptedQty"+i).value++;
				   eval("frmobj.BalanceQty"+i).value--;
				   eval("frmobj.check_name"+i).checked = true;
				   parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
				   count=1;
				   break;
				}
				else{
					alert(getMessage('TOT_ACXCEPT_REJECT_QTY_NOT_ALLOWED','PH'));
					parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
					return;
				}
			}
			}	
		}
		//added for 63761 start
		if(count==2)
					{
					alert(getMessage('ACPT_QTY_SAME_AS_RET_QTY', 'PH'));
					parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
					return;
					}//Added for 63761 end
		if(count!=1 && count!=2){// modified for ICN 63761
    	alert(getMessage('NOT_A_VALID_BARCODE','PH'));
		parent.retmedicationplineframe.frmPatientDetails.barcode_id.value="";
		return false;
		}
		
	}	
} 

function SelectAll(selected,totalrows){
	frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	if(selected.checked==true){
		for(var cnt=1;cnt<=totalrows;cnt++){
			eval("frmobj.check_name"+cnt).checked =true;
			eval("frmobj.check_name"+cnt).value = "Y";
		}
	}
	else{
		for(var cnt=1;cnt<=totalrows;cnt++){
			eval("frmobj.check_name"+cnt).checked =false;
			eval("frmobj.check_name"+cnt).value = "N";
		}
	}
}

function selectCheck(cnt){
	frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	
	if(eval("frmobj.check_name"+cnt).checked ==true)
		 eval("frmobj.check_name"+cnt).value = "Y";
	else
		 eval("frmobj.check_name"+cnt).value = "N";
}

function callBarcodeflg_1(querystring,FacilityFlag){
	parent.mainframeset.rows="20%,5%,20%,*,7%";
		var formObj	=	document.FormReturnMedicationRemarks;
		remarks=formObj.ReturnRemarks.value;
	var fields=new Array();
	fields[0]=formObj.ReturnRemarks;
	var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
	  checkcount=formObjdrug.total_count.value;
	var formObj	=	document.FormReturnMedicationRemarks;
	check=formObjdrug.DrugSelect;
	drugid=formObjdrug.drugid;
	var FormStore="";
	var checkstring="";
	var barcode=formObj.barCodeId.value;
	if(barcode=="" || barcode == null ){
		alert(getMessage("NOT_A_VALID_BARCODE","PH"));
		formObj.barCodeId.focus();
		
		parent.retmedicationactionframe.location.href="../../eCommon/html/blank.html";
		parent.mainframeset.rows="17%,5%,*,0%,0%";
		return false;
		
	}
	for (var i=1;i<=checkcount;i++ ){
		if(eval("formObjdrug.check_id"+i).checked == true){
		if(eval("formObjdrug.barcode_id"+i).value == "")  //Added for IN032747 - end
		{      if(i == checkcount){
			 checkstring+="'"+eval("formObjdrug.drug_id"+i).value+"'";
		} 
		else{
			
			checkstring+="'"+eval("formObjdrug.drug_id"+i).value+"'"+",";
			
		}
			  
		      
		}
		else{
			if(eval("formObjdrug.barcode_id"+i).value==barcode)
			   barcode=eval("formObjdrug.barcode_id"+i).value;
		}
	}
		
	}
	
	if(checkstring == "" && barcode== "" ){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
		formObj.barCodeId.focus();
		return false;
	}
	else{
		for (var i=1;i<=checkcount;i++ ){
			
			eval("formObjdrug.check_id"+i).disabled=true;
			}
	}
	var names=new Array();
	names[0]=getLabel("Common.remarks.label","Common");
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;
	if (blankObject!=null){
		return;
	}
	parent.retmedicationactionframe.location.href="../../ePH/jsp/ReturnMedicationAction.jsp?"+querystring+"&remarks="+remarks+"&drugcodes="+checkstring+"&FormStore="+FormStore+"&barcode="+barcode;
		
}

	
//Added for GHLCRF-0413.8 start
function AssignValueWithOutWardReturn(obj,i){
	var total_count = document.FormReturnMedicationAction.total_count.value;
	
	var c=0;
	if(obj.checked==true){
		eval("document.FormReturnMedicationAction.check_return_id"+i).value = "Y";
		
	}
	else{
		eval("document.FormReturnMedicationAction.check_return_id"+i).value = "N";
		document.FormReturnMedicationAction.SelectAll.checked=false;
	}
	for (var j=1;j<=total_count;j++ ){
	if(eval("document.FormReturnMedicationAction.check_return_name"+j).checked)
		c++;
}
	if((parseInt(total_count))==c)
		document.FormReturnMedicationAction.SelectAll.checked=true;
}
function selectAllWithOutWardReturn(obj) {

	var total_count = document.FormReturnMedicationAction.total_count.value;
	if (obj.checked) {
		for ( var i = 1; i <= total_count; i++) {

			if(!eval("document.FormReturnMedicationAction.check_return_name"+i).checked)
				eval("document.FormReturnMedicationAction.check_return_name" + i).click();

		}
	} else {
		for ( var i = 1; i <= total_count; i++) {

			eval("document.FormReturnMedicationAction.check_return_name" + i).click();

		}
	}
}
function IncreseQTY(barcode){
	frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	var totalrows=frmobj.totalrows.value;
	var enter_to_inc_flag="N";
	var bean_id             = frmobj.bean_id.value;
    var bean_name           = frmobj.bean_name.value;
	var next_barcode="";
	var count=0;//added for MMS-DM-CRF-0174.4
	frmobj.SelectAll.checked=true;//end 
	for (i=1;i<=totalrows ;i++ ){
		//count++;
		 var temp_barcode =eval("frmobj.barcode"+i);
		 var ret_qty =eval("frmobj.ret_qty"+i).value;
		 var returnable =eval("frmobj.returnable"+i).value;
		 var new_ret_qty="";
		 var old_ret_qty="";
		// alert("barcode==="+barcode+"temp_barcode.value==="+temp_barcode.value+"enter_to_inc_flag==="+enter_to_inc_flag);
		 if(barcode==temp_barcode.value && enter_to_inc_flag=="N"){
			
			 count++;//added for MMS-DM-CRF-0174.4
			 old_ret_qty= eval("frmobj.actualReturn"+i).value;
			  if(eval("frmobj.actualReturn"+i).value!="")
			     { eval("frmobj.check_return_name"+i).checked=true;
		    	eval("document.FormReturnMedicationAction.check_return_id"+i).value = "Y";
				 }
			 
			 if(old_ret_qty<returnable){
				  enter_to_inc_flag="Y";
			 if(ret_qty=="")
			   eval("frmobj.actualReturn"+i).value = 1 ;
			 else
               eval("frmobj.actualReturn"+i).value = parseInt(ret_qty)+1 ;
              new_ret_qty=eval("frmobj.actualReturn"+i).value;
			   eval("frmobj.check_return_name"+i).checked=true;
			   eval("document.FormReturnMedicationAction.check_return_id"+i).value = "Y";
			 

			 var xmlDoc			= "";
			 var xmlHttp			= new XMLHttpRequest();
			xmlHttp.open("POST", "ReturnMedicationLoginTemporary.jsp?identity=INCREASEQTY"+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&barcode="+barcode+"&new_ret_qty="+new_ret_qty+"&count="+(i-1)+"&returnable="+returnable , false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			eval(responseText);
			 }else{
			 if(eval("frmobj.barcode"+(i+1))!=undefined){
			   next_barcode=eval("frmobj.barcode"+(i+1)).value;
			 if(next_barcode!=temp_barcode.value){
				 old_ret_qty= eval("frmobj.actualReturn"+i).value;
			 
					alert(getMessage("PH_EXCEED_BALANCE_QTY","PH"));
			    }
			  }else{
				   old_ret_qty= eval("frmobj.actualReturn"+i).value;
			 
				 if(old_ret_qty==returnable){
					alert(getMessage("PH_EXCEED_BALANCE_QTY","PH"));
				 }
			  }
			 }
			 
		   }else{
			   if(eval("frmobj.barcode"+(i))!=undefined){
				   if(eval("frmobj.actualReturn"+i).value!="")

			         eval("frmobj.check_return_name"+i).checked=true;
				   eval("frmobj.check_return_id"+i).value="Y";//Added for ICN-54236
			   }
		   }

		 }
	if(count!=totalrows){//added for MMS-DM-CRF-0174.4
		frmobj.SelectAll.checked=false; 
	}
		 //alert("temp_barcode===="+temp_barcode.value+"barcode==="+barcode)
	}
	function focusBarcode(){
	if(parent.retmedicationactionframe.document.FormReturnMedicationAction!=undefined){
	 frmobj=parent.retmedicationactionframe.document.FormReturnMedicationAction;
	 if(frmobj.barcodeFlag!=undefined && parent.retmedicationplineframe.frmPatientDetails.barcode_id!=undefined && frmobj.barcodeFlag.value=="Y"){
		 parent.retmedicationplineframe.frmPatientDetails.barcode_id.focus();
	 }
	}
	}
