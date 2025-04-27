function create() {
	parent.frames[2].f_query_add_mod.location.href = "../../eBL/jsp/HealthCardMaster.jsp";
}

function reset() {
	f_query_add_mod.document.location.reload();
}

function query() {	
	parent.frames[2].f_query_add_mod.location.href ="../../eBL/jsp/HealthCardMasterQuery.jsp";
}

/*Added by karthik to include VisitValidation ATE-BL-AMS-CRF-0044-8-38400 */
function visitValidation(previlageCardForm){
	for(var i=0; i<previlageCardForm.elements.length; i++)
	{
	var fieldName=previlageCardForm.elements[i].name;
	var indexFound=fieldName.indexOf("visitCount");
		if(indexFound!=-1){
			if((!previlageCardForm.elements[i-3].value=='' || !previlageCardForm.elements[i-5].value=='') && previlageCardForm.elements[i].value==''){
				return "No of visits cannot be blank" +"<br>" ;
			}
		}
	}
	return "";
}

/*Added by karthik to include AgeValidation AMS-CRF-38398 */
function ageValidation(previlageCardForm){
	
	if((previlageCardForm.minAgeInDays0.value == "" && previlageCardForm.minAgeInMths0.value == ""  && previlageCardForm.minAgeInYrs0.value == "") ||
		(previlageCardForm.maxAgeInDays0.value == "" && previlageCardForm.maxAgeInMths0.value == ""  && previlageCardForm.maxAgeInYrs0.value == "")
		){
			return "Any one Age group needs to be specified" +"<br>" ;
	}
	
	for(var i=0; i<previlageCardForm.elements.length; i++)
	{
	var fieldName=previlageCardForm.elements[i].name;
	var indexFound=fieldName.indexOf("minAgeInDays");//clinicDesc visitTypeDesc visitCount
		if(indexFound!=-1){
			//alert(previlageCardForm.elements[i].value +previlageCardForm.elements[i+1].value +previlageCardForm.elements[i+2].value +previlageCardForm.elements[i+3].value+previlageCardForm.elements[i+4].value+previlageCardForm.elements[i+5].value);
			if( previlageCardForm.elements[i+7].value!="" || previlageCardForm.elements[i+9].value!="" ){
				if(previlageCardForm.elements[i].value == "" && previlageCardForm.elements[i+1].value == ""  && previlageCardForm.elements[i+2].value == ""){
					return "From Age group needs to be specified" +"<br>" ;
				}
				if(previlageCardForm.elements[i+3].value == "" && previlageCardForm.elements[i+4].value == ""  && previlageCardForm.elements[i+5].value == ""){
					return "To Age group needs to be specified"  +"<br>";
				}
			}

		}
	}
	return "";
}

function apply() {
	var previlageCardForm=parent.frames[2].f_query_add_mod.document.frmPrevilageCardMaster;
	var errMess="";

	if(previlageCardForm.dbOperation.value=='update' && previlageCardForm.modButton.disabled==false){
	errMess += "No changes to Update" +"<br>" ;
	}	
	errMess += ageValidation(previlageCardForm);
	errMess += visitValidation(previlageCardForm);	
	if(previlageCardForm.cardTypeCode.value == "")
	{
		errMess += "Card Type cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.longDescription.value == "")
	{
		errMess += "LongDescription cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.shortDescription.value == "")
	{
		errMess += "ShortDescription cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.validDays.value == "")
	{
		errMess += "Card Validity cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.noOfPat.value == "")
	{
		errMess += "No. Of. Patients cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.noOfVisits.value == "")
	{
		errMess += "No of OP Allotment cannot be blank" +"<br>" ;
	}
	if(previlageCardForm.effectiveFrom.value == "")
	{
		errMess += "Effective From Date cannot be blank" +"<br>" ;
	}
	if (errMess != "")
	{
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
	}
	else{		
		var actionURL="../../servlet/eBL.HealthCardMasterServlet";
		parent.frames[2].f_query_add_mod.document.frmPrevilageCardMaster.action=actionURL;
		parent.frames[2].f_query_add_mod.document.frmPrevilageCardMaster.target="messageFrame";
		parent.frames[2].f_query_add_mod.document.frmPrevilageCardMaster.submit();
		parent.frames[2].document.commontoolbarFrame.location.href ="../../eCommon/jsp/commonToolbar.jsp";
	}

	
}

function onSuccess()
{
	parent.frames[2].f_query_add_mod.location.href = "../../eBL/jsp/HealthCardMaster.jsp";
}


function billingGroupCodeDescRowAdd(billingGroupAddBtn){

		if(document.frmPrevilageCardMaster.dbOperation.value=='insert'){
			billingGroupAddBtn.disabled=true;
		}
		var table = document.getElementById('billingGroupCodeDescTable');
		var index=table.rows.length;
		document.frmPrevilageCardMaster.billingGroupCount.value=index;
		//alert(document.frmPrevilageCardMaster.billingGroupCount.value);
		var row=document.getElementById('billingGroupCodeDescTable').insertRow();
		var cell1=row.insertCell(0);
		var cell2=row.insertCell(1);
		var cell3=row.insertCell(2);		
		var cell4=row.insertCell(3);
		var cell5=row.insertCell(4);
		
		cell1.innerHTML="<DIV style='FONT-FAMILY: Verdana; FONT-SIZE: 8pt; color:#444444'>&nbsp;Billing Group Code</DIV>";			
		cell2.innerHTML="<input type='text' size='5'  name='billingGroupCode"+index+"' id='billingGroupCode"+index+"' onBlur='callBillingGroupCode(billingGroupCode"+index+",billingGroupDescription"+index+")'>&nbsp;<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callBillingGroupCode(billingGroupCode"+index+",billingGroupDescription"+index+")'>";
		cell3.innerHTML="<DIV style='FONT-FAMILY: Verdana; FONT-SIZE: 8pt; color:#444444'>&nbsp;Description</DIV>";
		cell4.innerHTML="<input type='text' name='billingGroupDescription"+index+"' id='billingGroupDescription"+index+"'>";
		cell5.innerHTML="<input type='button' name='billingGroupAddBtn"+index+"' id='billingGroupAddBtn"+index+"' value='Add' onClick='billingGroupCodeDescRowAdd(billingGroupAddBtn"+index+")'>";

		var objDiv = document.getElementById("billingGroupCodeDescTableDiv");
		objDiv.scrollTop = objDiv.scrollHeight;
		window.scrollTo(0, objDiv.scrollHeight);
	}
	
/*Added by karthik to include AgeValidation AMS-CRF-38398 */
function ageAddValidation(previlageCardForm){
	for(var i=0; i<previlageCardForm.elements.length; i++)
	{
	var fieldName=previlageCardForm.elements[i].name;
	var indexFound=fieldName.indexOf("minAgeInDays");//clinicDesc visitTypeDesc visitCount
		if(indexFound!=-1){
			//alert(previlageCardForm.elements[i].value +previlageCardForm.elements[i+1].value +previlageCardForm.elements[i+2].value +previlageCardForm.elements[i+3].value+previlageCardForm.elements[i+4].value+previlageCardForm.elements[i+5].value);			
			if(previlageCardForm.elements[i].value == "" && previlageCardForm.elements[i+1].value == ""  && previlageCardForm.elements[i+2].value == ""){
				return "From Age group needs to be specified" ;
			}
			if(previlageCardForm.elements[i+3].value == "" && previlageCardForm.elements[i+4].value == ""  && previlageCardForm.elements[i+5].value == ""){
				return "To Age group needs to be specified" ;
			}
		}
	}
	return "";
}

function ageGroupRowAdd(ageGroupRowAdd){
	
	var errMess = ageAddValidation(document.frmPrevilageCardMaster);
	
	if(errMess==""){	

	if(document.frmPrevilageCardMaster.dbOperation.value=='insert'){
		ageGroupRowAdd.disabled=true;
	}	
	var table = document.getElementById('ageGroupTable');
	var index=table.rows.length ;//-1
	document.frmPrevilageCardMaster.ageGroupCount.value=index ;
	var row=document.getElementById('ageGroupTable').insertRow();
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);		
	var cell4=row.insertCell(3);
	var cell5=row.insertCell(4);
		
	cell1.innerHTML="<DIV style='FONT-FAMILY: Verdana; FONT-SIZE: 8pt; color:#444444'><input type='text' name='minAgeInDays"+index+"' id='minAgeInDays"+index+"' size='2'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>D <input type='text' name='minAgeInMths"+index+"' id='minAgeInMths"+index+"' size='2'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>M <input type='text' name='minAgeInYrs"+index+"' id='minAgeInYrs"+index+"' size='3'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>Y <img src='../../eCommon/images/mandatory.gif'></DIV>";
	cell2.innerHTML="<DIV style='FONT-FAMILY: Verdana; FONT-SIZE: 8pt; color:#444444'><input type='text' name='maxAgeInDays"+index+"' id='maxAgeInDays"+index+"' size='2'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>D <input type='text' name='maxAgeInMths"+index+"' id='maxAgeInMths"+index+"' size='2'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>M <input type='text' name='maxAgeInYrs"+index+"' id='maxAgeInYrs"+index+"' size='3'  onKeyPress='return(ChkNumberInput(this,event,\"0\"))'>Y <img src='../../eCommon/images/mandatory.gif'></DIV>";
	cell3.innerHTML="<input type='hidden' name='priceClassCode"+index+"' id='priceClassCode"+index+"'><input type='text' name='priceClassDesc"+index+"' id='priceClassDesc"+index+"' size='30' onBlur='callPkgPriceClass(priceClassCode"+index+",priceClassDesc"+index+")'> <input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callPkgPriceClass(priceClassCode"+index+",priceClassDesc"+index+")'>";
	cell4.innerHTML="<input type='text' size='10' onBlur='callPkgPriceClassForCode(membershipFeesCode"+index+",membershipFeesDesc"+index+")'  name='membershipFeesCode"+index+"' id='membershipFeesCode"+index+"'>&nbsp;<input type='text' name='membershipFeesDesc"+index+"' id='membershipFeesDesc"+index+"' size='30' onBlur='callPkgPriceClass(membershipFeesCode"+index+",membershipFeesDesc"+index+")'> <input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callPkgPriceClass(membershipFeesCode"+index+",membershipFeesDesc"+index+")'>";
	cell5.innerHTML="<input type='button' name='ageGroupBtn"+index+"' id='ageGroupBtn"+index+"' value='&nbsp;Add &nbsp;' size='20' onClick='ageGroupRowAdd(ageGroupBtn"+index+");' >";
	
	var objDiv = document.getElementById("ageGroupTableDiv");
	objDiv.scrollTop = objDiv.scrollHeight;
	window.scrollTo(0, objDiv.scrollHeight);
	}else{
		alert(errMess);
	}
}

function callPkgPriceClass(targetTextfield1,targetTextfield2) {

	//alert(targetTextfield1.name);
	var sql = "";
	var tit = "";
	
	var priceCodeLookupButtonClicked= (targetTextfield1.name.indexOf("priceClassCode") != -1);
	var membershipLookupFeesButtonClicked= (targetTextfield1.name.indexOf("membershipFeesCode") != -1);

	
	if(priceCodeLookupButtonClicked){
	sql=PRICE_LOOKUP_QUERY;	
	tit = getLabel("eBL.HCMasterPriceClass.label", 'Common');
	}
	if(membershipLookupFeesButtonClicked){
	sql=SERVICE_LOOKUP_QUERY;
	tit = getLabel("eBL.MEMBER_SHIP_FEES.label", 'Common');
	}

		
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = targetTextfield2.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		targetTextfield1.value= arr[0];
		targetTextfield2.value= arr[1];
	} else {
		targetTextfield1.value = "";
		targetTextfield2.value ="";
	}

}


//Added For Code
function callPkgPriceClassForCode(targetTextfield1,targetTextfield2) {

	//alert(targetTextfield1.name);
	var sql = SERVICE_LOOKUP_QUERY_CODE;

		
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = getLabel("eBL.HCMasterPriceClass.label", 'Common');

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = targetTextfield1.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		targetTextfield1.value= arr[0];
		targetTextfield2.value= arr[1];
	} else {
		targetTextfield1.value = "";
		targetTextfield2.value ="";
	}

}
//Added for memebrship code
function callBillingGroupCode(targetTextfield1,targetTextfield2,inputSQL) {
	var sql = BLNGGRPCODE_LOOKUP_QUERY;
		
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = getLabel("eBL.HCMasterBGCode.label", 'Common');

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = targetTextfield1.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		targetTextfield1.value= arr[0];
		targetTextfield2.value= arr[1];
	} else {
		targetTextfield1.value = "";
		targetTextfield2.value = "";
	}

}


function callVisitTypeClass(targetTextfield1,targetTextfield2,targetTextfield3) {

	//alert(targetTextfield1.name + targetTextfield2.name + targetTextfield2.value );
	var sql="";
	var tit ="";
	
	var clinicLookupButtonClicked= (targetTextfield1.name.indexOf("clinic") != -1);
	var visitTypeLookupButtonClicked= (targetTextfield1.name.indexOf("visitType") != -1);
	
	if(clinicLookupButtonClicked){
	sql = CLINIC_LOOKUP_QUERY ;	
	tit = getLabel("eBL.BLClinic.label", 'Common');
	}
	if(visitTypeLookupButtonClicked){
	sql = VISIT_LOOKUP_QUERY +"'"+targetTextfield2.value+"'"+" ORDER BY 2";	
	tit = getLabel("eBL.BLVisitType.label", 'Common');
	}
			
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = targetTextfield3.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		targetTextfield1.value= arr[0];
		targetTextfield3.value= arr[1];
	} else {
		targetTextfield1.value = "";
		targetTextfield3.value = "";
	}

}


/*Added by karthik to include VisitValidation ATE-BL-AMS-CRF-0044-8-38400 */
function visitAddValidation(previlageCardForm){
	for(var i=0; i<previlageCardForm.elements.length; i++)
	{
	var fieldName=previlageCardForm.elements[i].name;
	var indexFound=fieldName.indexOf("clinicDesc");//clinicDesc visitTypeDesc visitCount
		if(indexFound!=-1){
			if(previlageCardForm.elements[i].value==''){
				return "Clinic cannot be blank" ;
			}
			if(previlageCardForm.elements[i+3].value==''){
				return "Visit Type cannot be blank" ;
			}
			if(previlageCardForm.elements[i+5].value==''){
				return "Visit Count cannot be blank" ;
			}
		}
	}
	return "";
}

function allotmentDetailsRowAdd(){
	
	var errMess = visitAddValidation(document.frmPrevilageCardMaster);
	
	if(errMess==""){	
	var table = document.getElementById('allotmentDetailsTable');
	var index=table.rows.length;//-1
	document.frmPrevilageCardMaster.clinicCount.value=index;
	//alert(document.frmPrevilageCardMaster.clinicCount.value);

	var row=document.getElementById('allotmentDetailsTable').insertRow();
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);		
	var cell4=row.insertCell(3);
	
	cell1.innerHTML="<input type='hidden' name='clinic"+index+"' id='clinic"+index+"'><input name='clinicDesc"+index+"' id='clinicDesc"+index+"' onblur='callVisitTypeClass(clinic"+index+",null,clinicDesc"+index+")' size='30'  type='text'>&nbsp;<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callVisitTypeClass(clinic"+index+",null,clinicDesc"+index+")'>	";
	cell2.innerHTML="<input type='hidden' name='visitType"+index+"' id='visitType"+index+"'><input name='visitTypeDesc"+index+"' id='visitTypeDesc"+index+"' size='30'  onblur='callVisitTypeClass(visitType"+index+",clinic"+index+",visitTypeDesc"+index+")' type='text'>&nbsp;<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callVisitTypeClass(visitType"+index+",clinic"+index+",visitTypeDesc"+index+")'>";
	cell3.innerHTML="<input name='visitCount"+index+"' id='visitCount"+index+"' size='30'  type='text' onKeyPress='return(ChkNumberInput(this,event,'0'))'>";
	cell4.innerHTML="";

	
	var objDiv = document.getElementById("allotmentDetailsTableDiv");
	objDiv.scrollTop = objDiv.scrollHeight;
	window.scrollTo(0, objDiv.scrollHeight);
	}
	else{
		alert(errMess);
	}

}

function dateOnBlur(targetDate){	
 	var dateCorrect=false;

		if(targetDate.value==""){
			dateCorrect=true;
		}
		else{
		dateCorrect=checkDt(targetDate);
		}

	if(dateCorrect==false){
		alert(getMessage("INVALID_DATE_FMT","SM"));
		targetDate.value="";
	}
}


function call_pass_valid()
{
	var user = document.forms[0].user.value;
	var pass = document.forms[0].pass.value;
	pass=pass.toUpperCase();
	var pass_db = document.forms[0].pass_db.value;
	pass_db=pass_db.toUpperCase();
	var remarks = document.forms[0].remarks.value;
	var valid_user_rec_found_YN = document.forms[0].valid_user_rec_found_YN.value;
	if(valid_user_rec_found_YN == "N")
	{
		alert(getMessage('BL9539','BL'));
		return false;
	}
	else
	{
		if(pass != pass_db)
		{
			alert(getMessage('BL1232','BL'));
			return false;
		}
		else
		{	
			var returnArray = new Array ("Y","Y",remarks,user);
			parent.window.returnValue=returnArray;
			parent.window.close();
			return true;
		}			
	}
}	

function confirmPasswdchk(obj)
{
	var usr_id=document.forms[0].user_id;
	var pass_wd=document.forms[0].passwd;
	var rmks=document.forms[0].remarks;
	if(usr_id.value=="")
	{
		alert(getMessage("BL9112","BL"));
		usr_id.focus();
		return false;
	}
	if(pass_wd.value=="")  
	{
		alert(getMessage("BL9113","BL"));
		pass_wd.focus();
		return false;
	}
	if(rmks.value=="")
	{
		alert(getMessage("BL9306","BL"));
		rmks.focus();
		return false;
	}	
	var HTMLVal="<html><body><form name='PrevilageCardPasswrdForm' id='PrevilageCardPasswrdForm' method='post' action='../../eBL/jsp/PrevilageCardPasswrdCheck.jsp'>"+
				"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
				"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
				"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
                "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"+
				"</form></body></html>";
				parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.frames[1].document.PrevilageCardPasswrdForm.submit();	
			
}

async function authUser()
{	
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments,features);
	if(retVal!=undefined)
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")
			{
				var card_type_code = document.getElementById("hidden_card_type_code").value;
				parent.parent.frames[2].f_query_add_mod.location.href="../../eBL/jsp/HealthCardMaster.jsp?action_mode=update&auth_success=true&card_type_code="+card_type_code;
			}
		}
	}
}

function uppercase()
{
key = window.event.keyCode;
if ((key > 0x60) && (key < 0x7B))
window.event.keyCode = key-0x20;
}

