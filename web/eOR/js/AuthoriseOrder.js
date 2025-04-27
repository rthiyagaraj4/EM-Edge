/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
---------------------------------------------------------------------------------------------------------------
17/09/2014	IN051144		Nijitha S		?			?			Amend Reason Pop up Window is not displayed, when Amend Order while Authorization
19/09/2014	IN051237		Nijitha S		?			?			Amend Reason Window validation differed while Amend order During Authorization
23/11/2015	IN053846		Karthi L		-		Ramesh G		The prescription printing automatically
25/01/2019	IN068673		DineshT		25/01/2019	Ramesh G 		GML-MMOH-CRF-1263
25/01/2019	IN069765		DineshT		25/01/2019	Ramesh G 		GML-MMOH-CRF-1263
14/10/2019  IN071315	    Nijitha S   14/10/2019  Ramesh G		GHL-CRF-0607
---------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;
var qry_string = "";
var qry_string_fr_print = "";


function populateLocation(location_type){
	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else if(location_type.value == "W"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	} else if(location_type.value == "D"){
		document.getElementById("id_locn").innerHTML = getLabel("eCA.DayCareUnits.label","CA")
	} else if(location_type.value == "E"){
		document.getElementById("id_locn").innerHTML = getLabel("eCA.EmergencyUnits.label","CA")
	} else if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("eOR.referralunits.label","OR") 
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}



	var formObj = document.authorise_order;
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = document.authorise_order.bean_id.value ;
	var localeName=document.authorise_order.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AuthorizeOrdersValidate1.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )


}
async function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var auth_ord_priv_rule_only_yn = document.authorise_order.auth_ord_priv_rule_only_yn.value;//IN069765
	
	/*dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.authorise_order.practitioner_id.value;
	dataTypeArray[0] = STRING;
//alert(document.authorise_order.practitioner_id.value+"=="+document.authorise_order.location_type.value+"=="+document.authorise_order.facility_id.value);
	dataNameArray[1] = "PATIENT_CLASS";
	dataValueArray[1] = document.authorise_order.location_type.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.authorise_order.facility_id.value;
	dataTypeArray[2] = STRING;*/
	

/*	 dataNameArray[0] = "PRACTITIONER_ID";
	dataValueArray[0] = document.authorise_order.practitioner_id.value;
	dataTypeArray[0] = STRING;

	 dataNameArray[1] = "PRACTITIONER_ID";
	dataValueArray[1] = document.authorise_order.practitioner_id.value;
	dataTypeArray[1] = STRING;*/
	 
	location_type	  = document.authorise_order.location_type.value
	// Decode the value and then pass as a value to the query
	if(location_type!=null && location_type=="C")
	   location_type	= "OP";
	else if(location_type!=null && location_type=="D")
	   location_type	= "DC";
	else if(location_type!=null && location_type=="E")
	   location_type	= "EM";
	else if(location_type!=null && location_type=="W")
	   location_type	= "IP";

 	dataNameArray[0] = "PATIENT_CLASS";
	dataValueArray[0] = location_type;
	dataTypeArray[0] = STRING;

	 dataNameArray[1] = "FACILITY_ID";
	dataValueArray[1] = document.authorise_order.facility_id.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.authorise_order.facility_id.value;
	dataTypeArray[2] = STRING;  



	//if(document.consent_order.location_type.value !="")
	//	target.value='';

	//dataNameArray[0] = "R";
	//dataValueArray[0] = document.authorise_order.location_type.value;
	//dataTypeArray[0] = STRING;

	//argumentArray[0]   = "Select locn_code code,locn_short_desc description from ca_pract_by_locn_view where  practitioner_id like ? and patient_class like decode (?,'C','OP','D','DC','E','EM','N','IP',patient_class) and facility_id like ? union select referral_code code,short_desc description from am_referral where eff_Status = 'E' and nvl(APPLICABILITY_FOR_DIRECT_ORD,'N')  != 'N'  and 'R' = nvl('"+document.authorise_order.location_type.value+"','R') and referral_code like ? and short_desc like ?  order by 2";//document.authorise_order.practitioner_code_sql.value;
	var localeName=document.authorise_order.localeName.value;
	var sql=document.authorise_order.location_sql.value;

	for(var x=0;x<5;x++)
	{
		sql = sql.replace('?',"'"+localeName+"'");
	}

	if(auth_ord_priv_rule_only_yn == 'N')//IN069765
		sql=sql.replace('?',"'"+document.authorise_order.practitioner_id.value+"'");

	/*Added by Uma on 12/7/2010 for IN025361*/
	if(location_type!=null && location_type=="D")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='Y' ");
	}
	else if(location_type!=null && location_type=="E")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='E' ");
	}
	else if(location_type!=null && location_type=="C")
	{
		sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='A' ");
	}
	else
	{
		sql = sql.replace("##FILTER##"," ");
	}
	/*Ends Here*/

	argumentArray[0]=sql;
 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "4,5";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
 
   	retVal = await CommonLookup( getLabel("Common.Location.label","Common"),argumentArray ); 
//alert(retVal[0]+"=="+retVal[1]);
	if(retVal != null && retVal != ""){
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.authorise_order.locn.value=arr[0];
		target.value = arr[1];
	}else{
		//alert('in');
		target.value=getLabel("Common.all.label","Common");
		document.authorise_order.locn.value = "";
	}
}
function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.authorise_order.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".authorise_order.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".authorise_order.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".authorise_order.locn.add(opt)") ;
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
	document.authorise_order.search_btn.disabled = false;
	document.authorise_order.reset();
	document.getElementById("id_locn").innerHTML = getLabel("Common.patientId.label","Common") 
	parent.AuthoriseOrderBottom.document.location.href="../../eCommon/html/blank.html"
}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll()
{
	//if(document.authorise_order_hdg.select_all.checked == true)
	if(document.getElementById("select_all").checked == true)
	{
		for(cnt=0; cnt<parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.total_recs.value; cnt++)
		{
			if(eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt).disabled==false)
			{
				
				val = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt);
				val.checked = true;
			}
			else
			{
				eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt).disabled=true
			}
		}
	}else
	{
		for(cnt=0; cnt<parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.total_recs.value; cnt++)
		{
			if(eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt).disabled==false)
			{
				val = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt);
				val.checked = false;
			}
			else
			{
				eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt).disabled=true
			}
		}
	}
}

function clearChecked(){
	parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.reset()
	//parent.AuthorizeOrdersBottomRight0.document.authorise_order_hdg.reset()
}
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.AuthoriseOrderTop.document.authorise_order;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.AuthoriseOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.AuthoriseOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
	if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.AuthoriseOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	/*
		Added by kishore kumar N on 02-05-2010,
		Validating date for better tuning.
	*/

	var ptID = formObj.patientId.value;
	var locale = formObj.localeName.value;

	if(ptID == '' && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		parent.AuthoriseOrderBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "OR"))
	}
	else
	{
		if(document.authorise_order.Inc_Force_Auths.value == "Y")
		{
			document.authorise_order.Inc_Force_Auth.value = "Y";
		}
		else if(document.authorise_order.Inc_Force_Auths.value == "N")
		{
			document.authorise_order.Inc_Force_Auth.value = "N";
		}
		document.authorise_order.auth_filter.value = document.authorise_order.auth_filters.value;
		if(document.authorise_order.Inc_Force_Auths.value == "N")
		{
			document.authorise_order.auth_filter.value = "";
		}
		document.authorise_order.search_btn.disabled = true;
		document.authorise_order.target="AuthoriseOrderBottom";
		document.authorise_order.action="AuthorizeOrdersBottom.jsp";
		document.authorise_order.submit();
	}

	/*
		ends here.
	*/
	
}
function checkDateRange(obj,from){
	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".localeName")
		
	//if(chckDate2(obj)){ // removed on 14/02/2007 while doing thai date validations
	if(validDateObj(obj,"DMY",localeName)){// function in DateUtils.js added for thai date validations
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}else{
		parent.AuthoriseOrderTop.document.authorise_order.period_to.value=parent.AuthoriseOrderTop.document.authorise_order.temp_last_week_date.value;
	
	}


}

async function authorise(){
	var locn_type = parent.parent.parent.frames[0].document.authorise_order.location_type.value
	var locn = parent.parent.parent.frames[0].document.authorise_order.locn.value
	var patientId=parent.parent.parent.frames[0].document.authorise_order.patientId.value
	var period_from=parent.parent.parent.frames[0].document.authorise_order.period_from.value
	var period_to=parent.parent.parent.frames[0].document.authorise_order.period_to.value

	qry_string = "../jsp/AuthorizeOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	var no_of_checked = 0;
	var formObj = parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl
	var localeName=parent.AuthorizeOrdersBottomRight2.document.ammend_order.localeName.value;
	var arguments = "";

	var bean_id = parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.bean_id.value ;

	//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttpp = new XMLHttpRequest();
	var xmlDocs = "";

			xmlStr ="<root><SEARCH " ;
	incr=0;
	flag = false
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.chk"+cnt);
		patient_class = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.patient_class"+cnt);
		priority = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.priority"+cnt);
		ord_id = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_id"+cnt);
		ord_typ_code = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_typ_code"+cnt);
		ord_catalog = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_catalog"+cnt);
		ord_consent_yn = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_consent_yn"+cnt);
		cont_order_ind = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.cont_order_ind"+cnt);
		ord_appr_by_user_id = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_appr_by_user_id"+cnt);
		ord_appr_reqd_yn = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_appr_reqd_yn"+cnt);
		order_category = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.order_category"+cnt);
		ord_consent_reqd_yn = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_consent_reqd_yn"+cnt);
		ord_consent_by_id = eval("parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.ord_consent_by_id"+cnt);


		if(val.checked == true){

			no_of_checked++;
//alert("no_of_checked:::"+no_of_checked);alert(flag);
			/*if((ord_consent_by_id.value == "null" && ord_consent_reqd_yn.value == "Y") || (ord_appr_by_user_id.value == "null" && ord_appr_reqd_yn.value == "Y")) {
				if(!flag)
					flag = true;
			}

			xmlStr += "ord_id"+incr+"=\""+ ord_id.value +"\" " ;
			xmlStr += "ord_catalog"+incr+"=\""+ ord_catalog.value +"\" " ;
			xmlStr += "ord_typ_code"+incr+"=\""+ ord_typ_code.value +"\" " ;
			xmlStr += "ord_consent_yn"+incr+"=\""+ ord_consent_yn.value +"\" " ;
			xmlStr += "cont_order_ind"+incr+"=\""+ cont_order_ind.value +"\" " ;
			xmlStr += "ord_appr_by_user_id"+incr+"=\""+ ord_appr_by_user_id.value +"\" " ;
			xmlStr += "ord_appr_reqd_yn"+incr+"=\""+ ord_appr_reqd_yn.value +"\" " ;
			xmlStr += "order_category"+incr+"=\""+ order_category.value +"\" " ;
			xmlStr += "ord_consent_by_id"+incr+"=\""+ ord_consent_by_id.value +"\" " ;
			xmlStr += "ord_consent_reqd_yn"+incr+"=\""+ ord_consent_reqd_yn.value +"\" " ;
			incr++;*/

		}
	}
			//xmlStr += "totalCount=\""+ (no_of_checked) +"\" " ;
			//xmlStr +=" /></root>" ;

		//arguments = arguments.substring(1,(arguments.length));

	//alert(xmlStr)
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}

		//==================== added to incorporate the specal approval = Begin
	if(flag) {
		//xmlDocs.loadXML( xmlStr ) ;
		xmlDocs = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttpp.open( "POST", "AuthorizeOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=set_values&localeName="+localeName, false ) ;

		xmlHttpp.send( xmlDocs ) ;

		//responseText=xmlHttpp.responseText ;
		//alert(responseText )

		var dialogHeight ='22.5vh' ;
		var dialogWidth = '30vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';


		var retVals = await window.showModalDialog("../../eOR/jsp/AuthorizeOrderVwSplOrderFrame.jsp",arguments,features);

		parent.parent.parent.frames[1].location.href=qry_string

		//==================== added to incorporate the specal approval = End
	}else{
		xmlStr = "";
		xmlStr ="<root><SEARCH " ;
        xmlStr +=" /></root>" ;
        //alert(xmlStr);
        //xmlDocs.loadXML( xmlStr ) ;
        xmlDocs = new DOMParser().parseFromString(xmlStr,"text/xml");
		xmlHttpp.open( "POST", "AuthorizeOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=fing_values", false ) ;

		xmlHttpp.send( xmlDocs ) ;
		responseText=xmlHttpp.responseText ;
        var fingurePrnYN = '';
		eval(responseText);
		
		if (fingurePrnYN == 'Y') {
			
		  var oledb_con_string = document.forms[0].oledb_con_string.value;
          //alert(oledb_con_string);
          if (verifyTheFinger(oledb_con_string)) {

    		//eval(responseText);
    		xmlStr = "";
    		eval(formApply( parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl,OR_CONTROLLER)) ;
    		//top.frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
    		if(top.content){
				if( invalidCode != "" && invalidCode !=null){ //"OR_STATUS_CHANGED"
					parent.AuthorizeOrdersBottomRight1.document.getElementById("status"+invalidCode).className="orcancel";
					alert(message);
					return false;
				}else
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
    		} else {
				/*if( getMessage(message,"OR") != "" )
					message = getMessage(message,"common");
				else{
					var index =0;
					index = message.lastIndexOf(".");
					message = message.substring(0,index);
    			}*/
				if(message!="" && message!=null)
				alert(message);
    			//window.close();
				const dialogTag = parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();
    		}
    		if( result ) {
    			onSuccess1();
    		}
    		}
		} else {
		  xmlStr = "";
    		eval(formApply( parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl,OR_CONTROLLER)) ;
    		//top.frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
    		if (top.content) {
				if( invalidCode != "" && invalidCode!=null){ //"OR_STATUS_CHANGED"
					parent.AuthorizeOrdersBottomRight1.document.getElementById('status'+invalidCode).className="orcancel";
					alert(message);
					//alert(getMessage(message,"OR"));
					return false;
				}else
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
            } else {
				/*if( getMessage(message,"OR") != "" )
					message = getMessage(message,"OR");
				else{
					var index =0;
					index = message.lastIndexOf(".");
					message = message.substring(0,index);
				}*/
				if(message!="" && message!=null)
    			alert(message);
                //window.close();
				const dialogTag = parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();
            }
    		if( result ) {
    			onSuccess1();
    		}
		}
	}
}

function authoriseSpecial(){

	eval(formApply( parent.SplApprvlTop.document.spl_auth,OR_CONTROLLER)) ;

	if( result ) {
		alert(getMessage("RECORD_MODIFIED","SM"))
		onSuccess();
	}
}


function assignResult(_result, _message, _flag, _invalidCode){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode;
}

function onSuccess() {
	//window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
	//parent.parent.parent.frames[1].location.href=qry_string
}

function onSuccess1() {
	callPrinting();
	parent.parent.parent.frames[1].location.href=qry_string
}
function callPrinting(){
	var bean_id = parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +="/></root>" ;
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AuthorizeOrdersValidate.jsp?bean_id=" + bean_id + "&validate=print_values", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

}

//onClick="callMenuFunctions('view','view','<%=register_details[2]%>')"
//function callMenuFunctions(colval1,ord_cat,colval,orderId,sex,patient_id,encounter_id,patient_class){
	async function callMenuFunctions(colval1,ord_cat,colval,orderId,sex,patient_id,encounter_id,patient_class,p_called_from_ca){//IN071315
//		alert('sf');
		var dialogHeight ='55vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		//var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&val1="+ ord_cat+"&sex="+encodeURIComponent(sex)+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;//Commented for IN071315
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&val1="+ ord_cat+"&sex="+encodeURIComponent(sex)+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class+"&p_called_from_ca="+ p_called_from_ca;//Added for IN071315
		//alert(finalString)
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

		if(colval1 == "Cancels" || colval == "Amend" ){
			reloadValues();
			//document.location.reload();
			//parent.parent.parent.frames[1].location.reload();
		}


}


//function getVisitAdmDate(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,bean_id){//IN051144
function getVisitAdmDate(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,bean_id,ord_cat){//IN051144
 		dob				= unescape(dob)
		location_type	= unescape(location_type)
		var finalString = "ammend_called_from=existing_order&bean_id="+bean_id+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&sex="+sex+"&age="+age+"&dob="+dob+"&validate=VISIT_ADM_DATE"+"&ord_cat="+ord_cat;//IN051144
		//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttpp = new XMLHttpRequest();
		//var xmlDocs = "";
		xmlStr ="<root><SEARCH " ;
        xmlStr +=" /></root>" ;
        //xmlDocs.loadXML( xmlStr ) ;
		var xmlDocs = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttpp.open( "POST", "AuthorizeOrdersValidate.jsp?"+finalString, false ) ;
		xmlHttpp.send( xmlDocs ) ;
		responseText=xmlHttpp.responseText ;
		eval(responseText)
 }

//function callAmmendFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_admn_date)//IN051144
async function callAmmendFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_admn_date,ord_cat){////IN051144
		dob				= unescape(dob)
		location_type	= unescape(location_type)
 		var dialogHeight ='90vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
		var finalString = "ammend_called_from=existing_order&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&sex="+sex+"&age="+age+"&dob="+dob+"&visit_admn_date="+visit_admn_date;
        finalString += "&function_from=AMEND_ORDER&iv_prep_yn=";
		//IN051144 Starts
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp = new XMLHttpRequest() ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc = "";
		var bean_id	 		= "@existingorderbean"+patient_id+encntr_id;
		var bean_name = "eOR.ExistingOrder";
		var retvalue ="";
		var validate = "AMMEND";
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+validate,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText = (xmlHttp.responseText).replace(/^\s+|\s+$/gm,'') ;
		var auditTrailDtls = responseText.split("|");
		if("Y"==auditTrailDtls[0] && "Y"==auditTrailDtls[1]){
			var dialogHeight1 ='18vh' ;
			var dialogWidth1 = '26vw' ;
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
		{
			var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		}
		reloadValues();
		//document.location.reload();
}

// patient ID search
async function callPatientSearch(){
	var pat_id =  await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

function verifyTheFinger(obj)
{
	var result;
	//alert('in');
	s1 = new String(document.forms[0].user_id.value);
	s2 = "";
	/*for(x=0; x<= s1.length; x++)
	{
		if(s1.charAt(x)!=" ")
			s2=s2+s1.charAt(x);
	}
	if(s2.length==0)
	{
		alert("Please enter User Id");
		document.forms[0].user_id.value="";
		document.forms[0].user_id.focus();
		return(false);
	}*/

	try
	{
		document.WebFp.DatabaseType=0
		document.WebFp.ConnectionType=1
		document.WebFp.ConnectionString = obj;
		document.WebFp.SecurityLevel=5
		document.WebFp.UserTableName="SM_APPL_USER"
		document.WebFp.FingerTableName="SM_APPL_USER_BIO"
		document.WebFp.AccountCodeField="APPL_USER_ID"
		document.WebFp.AccountCodeFieldType = 1
		document.WebFp.AccountCode = document.forms[0].user_id.value;
		//alert("Acc "+document.WebFp.AccountCode )
		result = document.WebFp.Verify();
		//result = document.WebFp.Enroll();
		//alert(result);
		if(result)
		{
			alert(getMessage("VERIFICATION_SUCCESS","OR"));
			return true;
			//login_form.submit();

			//alert("Enrollment Successful");
			//location.href = "regist.htm";
			//return(false);
		}
		else
		{
			alert(document.WebFp.ErrorString);
			//location.href = "regist.htm";
			return(false);
		}
	}
	catch(e)
	{
		alert(e.message);
		return(false);
	}

}
/*******/
function getNext(flagSelect){
var formObj= parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl
top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
formObj.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
formObj.action.value="nextPrev";//var late=applyupdate();
//if(late)
//	formObjDetail.submit();
}
/*******/
//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}
*/
async function callPatientHistory(patient_id){
		var dialogHeight ='95vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
 		var retVals = await top.window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&called_from=OR",arguments,features);
}
async function show_locn_window( target )
{
	var frmObj = parent.AuthoriseOrderTop.document.authorise_order;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array("pract_id","location_type","fact_id","location_type") ;
	var dataValueArray = new Array(frmObj.pract_id.value,target.value,frmObj.fact_id.value,target.value) ;
	var dataTypeArray  = new Array("String","String","String","String") ;
	
	argumentArray[0]   = parent.AuthoriseOrderTop.document.authorise_order.locn_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

//alert("argumentArray[1]::"+argumentArray[1]+"::argumentArray[2]-"+argumentArray[2]+"-argumentArray[3]-"+argumentArray[3]+"-argumentArray[4]-"+argumentArray[4]+"-argumentArray[5]-"+argumentArray[5]+"::argumentArray[5]-"+argumentArray[5]+"-argumentArray[6]-"+argumentArray[6]+"-argumentArray[7]-"+argumentArray[7]+"--");
	retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );

	if(retVal != null && retVal != ""){
		target.value = retVal[1];
		parent.AuthoriseOrderTop.document.authorise_order.locn_val.value=retVal[1];
		parent.AuthoriseOrderTop.document.authorise_order.locn.value=retVal[0];
	
	}

}

function reloadValues(){
 	var formObj = parent.parent.parent.AuthoriseOrderTop.document.authorise_order;
	qry_string = "../jsp/AuthorizeOrdersBottom.jsp?location_type="+formObj.location_type.value+"&locn="+formObj.locn.value+"&patientId="+formObj.patientId.value+"&period_from="+formObj.period_from.value+"&period_to="+formObj.period_to.value;
	parent.parent.parent.frames[1].location.href=qry_string;
}

function chckDate(Object2, focusflag)
{
	var localeName = parent.AuthoriseOrderTop.document.authorise_order.localeName.value
//if(CheckDate(Object2,focusflag)==false)// revomed while thai date validations

	if(!validDateObj(Object2,"DMY",localeName))// thai date validations 16/02/2007. function from DateUtils.js
	{
		parent.AuthoriseOrderTop.document.authorise_order.period_from.value=parent.AuthoriseOrderTop.document.authorise_order.temp_curr_week_date.value;
	}
}

/*removed on 14/02/2007 while doing Thai date validations

function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{	parent.AuthoriseOrderTop.document.authorise_order.period_to.value=parent.AuthoriseOrderTop.document.authorise_order.temp_last_week_date.value;
	}
}*/

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,order_category,sex,colval1,colval,order_set_id)
{

	var dialogTop   = "100";
	var dialogLeft   = "30";
	var dialogHeight= "92vh" ;
	var dialogWidth = "65vw" ;
	var features	= ' dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		//finalString += "&location_details=" + location_details;
		//finalString += "&priority=" + Priority;
		finalString += "&patient_class=" + patient_class;
		//finalString += "&order_type_code=" + order_type_code;
		//finalString += "&source_type=" + source_type;
		//finalString += "&source_code=" + source_code;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;
		//alert("final String="+finalString);
	var arguments	= "";
	var retVal 			= await top.window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function alignHeading()
{

	if(parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader")!=null)
	{
				parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				if(document.getElementById("tableresult").rows(1))
				{
					for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
					{
						var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
						
						if(parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j) != null)
						{
							parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader").rows(0).cells(j).width=wid;
						}
					}
				}
		}
		
	}

	function authFilter(obj)
	{
		if(obj.checked)
		{
			if(document.getElementById("auth_filter_id"))
			{
				document.getElementById("auth_filter_id").style.display = "inline";
			}
			obj.value="Y";
		}
		else
		{
			if(document.getElementById("auth_filter_id"))
			{
				document.getElementById("auth_filter_id").style.display = "none";
			}
			obj.value="N";
		}
	}

	/*function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	//if(parent.AuthorizeOrdersBottomRight0.location.href.indexOf(".jsp") != -1)
	//{
		//parent.AuthorizeOrdersBottomRight0.document.body.scrollLeft=temp;
	//}
}*/

	// IN053846 - Start
	async function confirmRoutinePrint()
	{
		
		var formObj = parent.frames[0].document.authorise_order_dtl;
		var bean_id = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		//var finalString 	= "count="+total_rows
		var finalString = '';
		var retVal 			= new String();
		var dialogHeight= "10" ;
		var dialogWidth	= "20" ;
		var dialogTop = "225" ;
		var center = "1" ;
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no; ";

		retVal1 	= await window.showModalDialog("../../eOR/jsp/OrderEntryPrintOption.jsp?"+finalString,arguments,features);
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc = "";
		xmlStr			= "<root><SEARCH " ;
		//xmlStr			+= "chk_yn=\"" + retVal1 + "\" " ;
		xmlStr 			+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eOR/jsp/AuthorizeOrdersValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name + "&chk_yn="+ retVal1 +"&validate=PRINT_CONFIRM_VALUES", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	 // IN053846 - End
	//IN068673, starts
	function clearLocnDtls()
	{
		document.getElementById("locn_desc").value = getLabel("Common.all.label","Common");
		document.getElementById("locn").value="";
	}
	//IN068673, ends

