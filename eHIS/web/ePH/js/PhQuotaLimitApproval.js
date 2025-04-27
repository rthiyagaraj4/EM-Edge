var prevObjID;
var prevImgObj;
var qry_string = "";
function reset() {
	QuotaLimitApprovalCriteriaFrame.location.reload();
	QuotaLimitApprovalBottom.location.href='../../eCommon/html/blank.html';
}
function clearCriteria(){
	parent.QuotaLimitApprovalCriteriaFrame.document.location.reload();
	parent.QuotaLimitApprovalBottom.location.href='../../eCommon/html/blank.html';
}
function clearLocnDtls()
{
	document.getElementById("locn_desc").value = getLabel("Common.all.label","Common");
	document.getElementById("locn").value="";
}
/*
function populateLoaction1(target){
	if(document.quotaLimitApprovalCriteriaForm.locn_desc.value!=""){
		populateLoaction(target);
	}
}
*/
async function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	 
	var location_type	  = document.quotaLimitApprovalCriteriaForm.location_type.value
	// Decode the value and then pass as a value to the query
	if(location_type!=null && location_type=="C")
	   location_type	= "OP";
	else if(location_type!=null && location_type=="D")
	   location_type	= "DC";
	else if(location_type!=null && location_type=="E")
	   location_type	= "EM";
	else if(location_type!=null && location_type=="W")
	   location_type	= "IP";

	var parNameArray  = new Array() ;  
	var parValueArray  = new Array() ;	
	
 	parNameArray[0] = "~LANGUAGE_ID`";
	parNameArray[1] = "~LANGUAGE_ID`";
	parNameArray[2] = "~LANGUAGE_ID`";
	parNameArray[3] = "~LANGUAGE_ID`";
	parNameArray[4] = "~LANGUAGE_ID`";
	parNameArray[5] = "~PATIENT_CLASS`";
	parNameArray[6] = "~FACILITY_ID`";
	parNameArray[7] = "~FACILITY_ID`";
	
	var localName=document.quotaLimitApprovalCriteriaForm.locale.value;
	parValueArray[0] = localName;
	parValueArray[1] = localName;
	parValueArray[2] = localName;
	parValueArray[3] = localName;
	parValueArray[4] = localName;
	parValueArray[5] = location_type;
	parValueArray[6] = document.quotaLimitApprovalCriteriaForm.facility_id.value;
	parValueArray[7] = document.quotaLimitApprovalCriteriaForm.facility_id.value;
	
	argumentArray[0]   = ""; 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "4,5";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	
	location_type	  = document.quotaLimitApprovalCriteriaForm.location_type.value;
	var sql="";
	/*
	if(location_type!=null && location_type=="D")
	{
		sql = "SQL_QUOTALIMIT_APPROVAL_LOCATION_LOOKUP_DAYCARE";
	}
	else if(location_type!=null && location_type=="E")
	{
		sql = "SQL_QUOTALIMIT_APPROVAL_LOCATION_LOOKUP_EMERGENCY";
	}
	else if(location_type!=null && location_type=="C")
	{
		sql = "SQL_QUOTALIMIT_APPROVAL_LOCATION_LOOKUP_CLINIC";
	}
	else
	{
		*/
		sql = "SQL_QUOTALIMIT_APPROVAL_LOCATION_LOOKUP";
	//}
	
	argumentArray[12]  = sql;  
	argumentArray[13]  = "ePH.Common.PhRepository";  
	argumentArray[14]  = parNameArray;  
	argumentArray[15]  = parValueArray;   
	
 
   	retVal = await CommonLookup( getLabel("Common.Location.label","Common"),argumentArray ); 
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		document.quotaLimitApprovalCriteriaForm.locn.value=arr[0];
		target.value = arr[1];
	}else{
		//alert('in');
		target.value=getLabel("Common.all.label","Common");
		document.quotaLimitApprovalCriteriaForm.locn.value = "";
	}
}

function chckDate(Object2, focusflag)
{
	var localeName = parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.locale.value
	if(!validDateObj(Object2,"DMY",localeName))
	{
		parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.period_from.value=parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.temp_frDate.value;
	}
}
function checkDateRange(obj,from){
	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".locale")
		
	if(validDateObj(obj,"DMY",localeName)){		
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			obj.focus()
			return false
		}
	}else{
		parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.period_to.value=parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm.temp_toDate.value;
	
	}
}
function getSpecialty1(obj){
	if (obj.value != "")
	{
		getSpecialty();
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}
async function getSpecialty(){
	
	var target			= document.forms[0].specialty;
	var stdval          = document.forms[0].specialty_code.value;
	var facilityid      = document.forms[0].facility_id.value;
	var locale			= document.forms[0].locale.value;
   
	var retVal			= "";
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Specialty.label","Common");
	
	var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"' and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	
	retVal = await CommonLookup( title, argArray )

	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].specialty.value = retVal[1];
		document.forms[0].specialty_code.value = retVal[0];
	}
	else
	{
		document.forms[0].specialty.value = "";
		document.forms[0].specialty_code.value = "";
	} 		
}

function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

function getdrugname(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].drug_name.value='';
	}else{	
		searchDrugName1()
	}	 
}
async function searchDrugName1(){	
	var formObj = document.forms[0];
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   = "";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ; 
	
	
	var parNameArray  = new Array() ;  
	var parValueArray  = new Array() ;	
	
 	parNameArray[0] = "~LANGUAGE_ID`";		
	parValueArray[0] = formObj.locale.value;
	
	argumentArray[12]  = "SQL_QUOTALIMIT_APPROVAL_DRUG_SEARCH_LOOKUP";  
	argumentArray[13]  = "ePH.Common.PhRepository";  ;  
	argumentArray[14]  = parNameArray;  
	argumentArray[15]  = parValueArray;

	retVal = await CommonLookup( getLabel("Common.DrugName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		formObj.drug_name.value			= retVal[1];
		formObj.drug_code.value			= retVal[0];
	}
}
function populateValues(){
	
	if (top.content & top.content.messageFrame!=undefined) {
		top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.QuotaLimitApprovalBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.QuotaLimitApprovalBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.locale.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.QuotaLimitApprovalBottom.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	var ptID = formObj.patientId.value;
	var locale = formObj.locale.value;

	if(ptID == '' && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		parent.QuotaLimitApprovalBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "PH"))
	}
	else
	{	
		
	//	document.quotaLimitApprovalCriteriaForm.search_btn.disabled = true;
		document.quotaLimitApprovalCriteriaForm.submit();
	}
}

function dynamichide(m, e,row)
	{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
	}

	function isContained(m, e)
	{

		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
	}

	function delayhidemenu(row)
	{

		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(document.getElementById('orderctl' + row))
			// Set className
			document.getElementById('orderctl' + row).className = 'gridDataBlue';

			// Check if the imgArrow element exists
			if (document.getElementById('imgArrow' + row)) {
				document.getElementById('imgArrow' + row).src = "../../eCommon/images/inactiveArrow.gif";
			}

	}

	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}
	function AllowDateFormat(){
	   var key = window.event.keyCode;   
	   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
		   return false;
	   }

	}
	function callMouseOverOnTD(obj,imgObj){
		
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		document.getElementById(mgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}
	async function callMenuFunctions(colval1,ord_cat,colval,orderId,sex,patient_id,encounter_id,patient_class,p_called_from_ca){//IN071315

		var dialogHeight ='37.5vh' ;
		var dialogWidth = '50vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		//var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&val1="+ ord_cat+"&sex="+encodeURIComponent(sex)+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;//Commented for IN071315
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&val1="+ ord_cat+"&sex="+encodeURIComponent(sex)+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class+"&p_called_from_ca="+ p_called_from_ca;//Added for IN071315
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

		if(colval1 == "Cancels" || colval == "Amend" ){
			reloadValues();			
		}
	}
	function reloadValues(){
		var formObj = parent.parent.parent.QuotaLimitApprovalCriteriaFrame.document.quotaLimitApprovalCriteriaForm;
		qry_string = "../jsp/PhQuotaLimitApprovalBottom.jsp?location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&patientId="+formObj.patientId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value;
		parent.parent.parent.frames[1].location.href=qry_string;
	}
	function getVisitAdmDate(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,bean_id,ord_cat){//IN051144
 		dob				= unescape(dob)
		location_type	= unescape(location_type)
		var finalString = "ammend_called_from=existing_order&bean_id=Or_AuthoriseOrder&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&sex="+sex+"&age="+age+"&dob="+dob+"&validate=VISIT_ADM_DATE"+"&ord_cat="+ord_cat;//IN051144
		var xmlDocs = "";
		var xmlHttpp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH " ;
        xmlStr +=" /></root>" ;
        xmlDocs.loadXML( xmlStr ) ;
		xmlHttpp.open( "POST", "../../eOR/jsp/AuthorizeOrdersValidate.jsp?"+finalString, false ) ;
		xmlHttpp.send( xmlDocs ) ;
		responseText=xmlHttpp.responseText ;
		eval(responseText)
 }

async function callAmmendFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_admn_date,ord_cat){////IN051144
 		dob				= unescape(dob)
		location_type	= unescape(location_type)
 		var dialogHeight ='45vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
		var finalString = "ammend_called_from=existing_order&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&sex="+sex+"&age="+age+"&dob="+dob+"&visit_admn_date="+visit_admn_date;
        finalString += "&function_from=AMEND_ORDER&iv_prep_yn=";
		//IN051144 Starts
		var xmlDoc  = "";
		var xmlHttp = new XMLHttpRequest() ;
		var bean_id	 		= "@existingorderbean"+patient_id+encntr_id;
		var bean_name = "eOR.ExistingOrder";
		var retvalue ="";
		var validate = "AMMEND";
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eOR/jsp/ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+validate,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText = (xmlHttp.responseText).replace(/^\s+|\s+$/gm,'') ;
		var auditTrailDtls = responseText.split("|");
		if("Y"==auditTrailDtls[0] && "Y"==auditTrailDtls[1]){
			var dialogHeight1 ='38vh' ;
			var dialogWidth1 = '56vw' ;
			var dialogTop1	= '100';
			var dialogLeft1 = '200' ;

			var title1 = 'rewe'
			var features1 = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth1 +';dialogTop:'+dialogTop1+';dialogLeft:'+dialogLeft1+';dialogTitle:'+title+'; scroll=yes; status=no';
			var finalString1 ="ord_cat="+ord_cat+"&amendReasonMandYN="+auditTrailDtls[2]+"&bean_id="+bean_id+"&bean_name="+bean_name;
			
			retvalue=await top.window.showModalDialog("../../eOR/jsp/OrderAmendReason.jsp?"+finalString1,arguments,features1);				
			finalString +="&amendDesc="+retvalue;				
		}
		//IN051144 Ends
		if(retvalue!="WindowClose" && retvalue!=undefined)//IN051237
			var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		reloadValues();
		//document.location.reload();
}
async function callPatientHistory(patient_id){
		var dialogHeight ='45vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
 		var retVals = await top.window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&called_from=OR",arguments,features);
}
function updateChkValue(obj,val){	
	if(obj.checked == true){
		eval("document.QuotaLimitApprovalBottomRightDtlFrm.chkval"+val).value='Y';
	}else{
		document.getElementsByName("chkval"+val).value="N";
	}
}
function clearChecked(){
	parent.QuotaLimitApprovalBottomRight1.document.QuotaLimitApprovalBottomRightDtlFrm.reset();
}
function authorise(){
	
	var formObj = parent.QuotaLimitApprovalBottomRight1.document.QuotaLimitApprovalBottomRightDtlFrm;	
	
	var locn_type ="";
	var locn = "";
	var patientId="";
	var period_from="";
	var period_to="";
	if(parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm==undefined){
		locn_type = parent.parent.parent.frames[1].document.quotaLimitApprovalCriteriaForm.location_type.value;
		locn = parent.parent.parent.frames[1].document.quotaLimitApprovalCriteriaForm.locn.value;
		patientId=parent.parent.parent.frames[1].document.quotaLimitApprovalCriteriaForm.patientId.value;
		period_from=parent.parent.parent.frames[1].document.quotaLimitApprovalCriteriaForm.period_from.value;
		period_to=parent.parent.parent.frames[1].document.quotaLimitApprovalCriteriaForm.period_to.value;
	}else{
		locn_type = parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm.location_type.value;
		locn = parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm.locn.value;
		patientId=parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm.patientId.value;
		period_from=parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm.period_from.value;
		period_to=parent.parent.parent.frames[0].document.quotaLimitApprovalCriteriaForm.period_to.value;
	}
	
	qry_string = "../jsp/AuthorizeOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	
	var no_of_checked = 0;
	var formObj = parent.QuotaLimitApprovalBottomRight1.document.QuotaLimitApprovalBottomRightDtlFrm;	
	for(var cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.QuotaLimitApprovalBottomRight1.document.QuotaLimitApprovalBottomRightDtlFrm.chk"+cnt);
		if(val.checked == true){
			no_of_checked++;
		}
	}
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}

	formObj.action="../../servlet/ePH.QuotaaLimitApprovalServlet";
	formObj.method='post';
	formObj.submit();
	
}

