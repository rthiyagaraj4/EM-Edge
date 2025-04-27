/*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
---------------------------------------------------------------------------------------
*/

function create()
{	
	PolicyDefinitionMainFrame.location.href="../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert"; 
}

function query()
{	
	PolicyDefinitionMainFrame.location.href="../../eBL/jsp/PolicyDefinitionQueryCriteria.jsp"; 
}

function onSuccess()
{
	PolicyDefinitionMainFrame.location.href="../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert";
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

function clearBill(obj){
	var bgCode = 'bg_code_'+obj;
	var bgDesc = 'bg_desc_'+obj;
	document.getElementById(bgCode).value='';
	document.getElementById(bgDesc).value='';
}

function clearClinic(obj){
	var clinicCode = 'clinic_code_'+obj;
	var clinicDesc = 'clinic_desc_'+obj;
	var clinicNurs = 'clinic_'+obj;
	var clinNursVal = document.getElementById(clinicNurs);
	var clinicBut = 'clinic_but_'+obj;
	var specCode = 'spec_code_'+obj;
	var specDesc = 'spec_desc_'+obj;
	document.getElementById(clinicDesc).disabled = false;
	document.getElementById(clinicCode).readonly = false;
	document.getElementById(clinicCode).value='';
	document.getElementById(clinicDesc).value='';
	document.getElementById(clinicBut).disabled = false;
	document.getElementById(specCode).value='';
	document.getElementById(specDesc).value='';
	if(clinNursVal.value == 'A'){
		document.getElementById(clinicDesc).value = 'All Clinic/ Nursing Unit'; //Modified by Rajesh V
		document.getElementById(clinicCode).value = '**';
		document.getElementById(clinicDesc).disabled = true;
		document.getElementById(clinicCode).readonly = true;
		document.getElementById(clinicBut).disabled = true;
	}
}

function clearBillPop(obj){
	var bgCode = 'pop_bg_code_'+obj;
	var bgDesc = 'pop_bg_desc_'+obj;
	document.getElementById(bgCode).value='';
	document.getElementById(bgDesc).value='';
}

function changeEpsdEnc(obj){
	var epsdEnc = document.getElementById('episode_'+obj).value;
	var patClass = document.getElementById('ptClass_'+obj);
	var clinicInd = document.getElementById('clinic_'+obj);

	if(epsdEnc == 'E'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = 'OP';
		opt.innerText = 'OP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'EM';
		opt.innerText = 'EM';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'XT';
		opt.innerText = 'EX';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'C';
		opt.innerText = 'Clinic';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else if(epsdEnc == 'N'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = 'IP';
		opt.innerText = 'IP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'DC';
		opt.innerText = 'DC';
		patClass.appendChild(opt);


		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Nursing Unit';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else if(epsdEnc == 'A'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'A';
		opt.innerText = 'All';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else{
		patClass.length = 0;

		var opt = document.createElement("option");
		opt.value = '';
		opt.innerText = 'Select';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'OP';
		opt.innerText = 'OP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'IP';
		opt.innerText = 'IP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'DC';
		opt.innerText = 'DC';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'EM';
		opt.innerText = 'EM';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'XT';
		opt.innerText = 'EX';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;
		
		opt = document.createElement("option");
		opt.value = '';
		opt.innerText = 'Select';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'C';
		opt.innerText = 'Clinic';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Nursing Unit';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'A';
		opt.innerText = 'All';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
}

function compareDates(startDate,endDate){
	var starr = startDate.value.split("/");
	var enarr = endDate.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	if(startDate.value.length>0 && endDate.value.length>0){
		if(startdt>enddt){
			alert(getMessage('BL1344','BL'));
			endDate.value = '';
		}
	}
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function checkForPer(obj){
	if(obj.value>100){
		alert(getMessage('BL9135','BL'));
		obj.value = '';
	}
	
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkAlpha(event){
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkForSpecChars(event) {
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForNumberDecimal(obj) {
	var decArr = obj.value.split('.');
	if(decArr.length>2){
		alert(getMessage("NUM_ALLOWED", "SM"));
		obj.value = '';
		return false;
	}
   
	if(decArr.length == 2){
		if(decArr[0].length<1 && decArr[1].length<1){
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value = '';
			return false;

		}
		if(decArr[1].length>2){
			alert('Only Two Numbers are allowed beyond Decimal');
			obj.value = '';
			return false;

		}
	}
}

function apply()  
{	

	var mainfrmObj = PolicyDefinitionMainFrame.PolicyInfoFrame.frmPolicyInfo;
	var fieldsTop  = new Array (mainfrmObj.payerCode,mainfrmObj.policyTypeCode,mainfrmObj.payerCode2,mainfrmObj.coverageRules,mainfrmObj.coverageBasis);


	var payerLbl  = getLabel("eBL.PAYER.label","bl");
	var policyLbl  = getLabel("eBL.POLICY_TYPE.label","bl");
	var payerGrpLbl  = getLabel("eBL.PAYER_GROUP.label","bl");
	var polRules = getLabel("eBL.PolicycoverageRules.label","bl");
	var polBasis = getLabel("eBL.PolicycoverageBasis.label","bl");
	var namesTop = new Array ( payerLbl,policyLbl,payerGrpLbl,polRules,polBasis);
	if(checkFieldsofMst( fieldsTop, namesTop, messageFrame)) {
	
	var xmlString=formXMLStringMain(mainfrmObj);
	var updation=formValidation(xmlString,"infoFrame");
	
	var frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
	var mode = mainfrmObj.mode.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,"serviceCoverage");
	
	frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
	var prevtab = frmObj.prevTab.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,prevtab);
	
	frmObj = PolicyDefinitionMainFrame.PolicyDetailsPage.document.forms[0];
	var pageInfo = frmObj.pageInfo.value;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,pageInfo);
	
	mainfrmObj.target='messageFrame';
	mainfrmObj.method="post";
	mainfrmObj.action="../../servlet/eBL.PolicyDefinitionMasterServlet?mode="+mode;
	//alert('submit');
	mainfrmObj.submit();	
	}
	
	
}

function formXMLStringMain(frmObj)
{
	//alert('formXMLStringMain->'+frmObj);
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		//alert(arrObj.length);
		for(var i=0;i<arrObj.length;i++)
		{
			//alert(arrObj[i].name+'->'+arrObj[i].value);
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"Y" + "\" " ;
				}
				else{
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + "N" + "\" " ;
				}
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";	
	}
//alert("xmlStr :"+xmlStr);
	return xmlStr;
}

function formValidation(xmlStr,last_link,key)
{	
	//alert('key'+key)
	//last_link = 'BILL_PRINT_FMT';
	//alert('last_link->'+last_link);
	//alert('event->'+event);
	//alert('xmlStr->'+xmlStr);
	var temp_jsp="../../eBL/jsp/CommonPolicyPersistence.jsp?func_mode="+last_link+'&key='+key;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		//alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	//alert('before');
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	//alert('after');
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

function changeInclExclInd(index){
	
	var inclIndChk = document.getElementById('incExChk_'+index);
	var incBasis = document.getElementById('incBasis_'+index);
	var value = document.getElementById('value_'+index);
	var valueChk1 = document.getElementById('valueChk1_'+index);
	var valueChk3 = document.getElementById('valueChk3_'+index);
	var valueChk4 = document.getElementById('valueChk4_'+index);
	var servItemQty = document.getElementById('servItemQty_'+index);
	var amtPerVisit = document.getElementById('amtPerVisit_'+index);
	var amtPerIPDay = document.getElementById('amtPerIPDay_'+index);	
	var noOfDays = document.getElementById('noOfDays_'+index);
	var serviceLmt = document.getElementById('serviceLmt_'+index);
	var amtMode = document.getElementById('AmtMode_'+index);
	var patCopay =  document.getElementById('patCopay_'+index);
	var patLimitAmt =  document.getElementById('patLimitAmt_'+index);

	var inclExcl = document.getElementById('incExInd_'+index);
	if(inclExcl.value == 'E'){
		inclIndChk.checked = false;
		inclIndChk.disabled = 'disabled';
		
		incBasis.value = '';
		incBasis.disabled = 'disabled';
		
		value.value = '';
		value.disabled = 'disabled';
		
		valueChk1.checked = false;
		valueChk1.disabled = 'disabled';
		
		valueChk3.checked = false;
		valueChk3.disabled = 'disabled';
		
		valueChk4.checked = false;
		valueChk4.disabled = 'disabled';
		
		servItemQty.value = '';
		servItemQty.disabled = 'disabled';
		
		amtPerVisit.value = '';
		amtPerVisit.disabled = 'disabled';
		
		amtPerIPDay.value = '';
		amtPerIPDay.disabled = 'disabled';
		
		noOfDays.value = '';
		noOfDays.disabled = 'disabled';

		patCopay.value='';
		patCopay.disabled = 'disabled';

		patLimitAmt.value='';
		patLimitAmt.disabled = 'disabled';
		
		amtMode.value = 'G';
		amtMode.disabled = 'disabled';
		//serviceLmt.checked = false;
		//serviceLmt.disabled = 'disabled';
	}
	else{

		inclIndChk.disabled = false;

		incBasis.disabled = false;

		value.disabled = false;

		valueChk1.disabled = false;

		valueChk3.disabled = false;

		valueChk4.disabled = false;

		servItemQty.disabled = false;

		amtPerVisit.disabled = false;

		amtPerIPDay.disabled = false;

		noOfDays.disabled = false;

		patCopay.disabled = false;

		patLimitAmt.disabled = false;

		amtMode.disabled = false;
		//serviceLmt.disabled = false;
	}
	
}

function changeInclExclIndPop(index){
	
	var incBasis = document.getElementById('pop_incBasis_'+index);
	var value = document.getElementById('pop_value_'+index);
	var servItemQty = document.getElementById('pop_servItemQty_'+index);
	var amtPerVisit = document.getElementById('pop_amtPerVisit_'+index);
	var amtPerIPDay = document.getElementById('pop_amtPerIPDay_'+index);	
	var noOfDays = document.getElementById('pop_noOfDays_'+index);
	var amtMode = document.getElementById('AmtMode_'+index);
	var patCopay =  document.getElementById('pop_patCopay_'+index);
	var patLimitAmt =  document.getElementById('pop_patLimitAmt_'+index);

	var inclExcl = document.getElementById('pop_incExInd_'+index);
	if(inclExcl.value == 'E'){
		
		incBasis.value = '';
		incBasis.disabled = 'disabled';
		
		value.value = '';
		value.disabled = 'disabled';
		
		servItemQty.value = '';
		servItemQty.disabled = 'disabled';
		
		amtPerVisit.value = '';
		amtPerVisit.disabled = 'disabled';
		
		amtPerIPDay.value = '';
		amtPerIPDay.disabled = 'disabled';
		
		noOfDays.value = '';
		noOfDays.disabled = 'disabled';

		patCopay.value='';
		patCopay.disabled = 'disabled';

		patLimitAmt.value='';
		patLimitAmt.disabled = 'disabled';


		amtMode.value = 'G';
		amtMode.disabled = 'disabled';
	}
	else{

		incBasis.disabled = false;

		value.disabled = false;

		servItemQty.disabled = false;

		amtPerVisit.disabled = false;

		amtPerIPDay.disabled = false;

		noOfDays.disabled = false;

		patCopay.disabled = false;

		patLimitAmt.disabled = false;

		amtMode.disabled = false;
	}
	
}

function fnEnableDisableLimit(type,obj1,obj2){
	if(type =='chk'){
		var chkBox = document.getElementById(obj1);
		var dest = document.getElementById(obj2);

		var destBox1 = document.getElementById('approvedDays');
		var destBox2 = document.getElementById('approvedAmt');
		var noOfDays = document.forms[0].noOfDays;
		var limitAmt = document.forms[0].limitAmt;

		if(chkBox.checked){
			dest.disabled = false;
		}
		else{
			dest.disabled = true;
			dest.value = '';

			destBox1.disabled = true;
			destBox2.disabled = true;
			destBox1.value = '';
			destBox2.value = '';

			noOfDays.disabled = true;
			limitAmt.disabled = true;
			noOfDays.value = '';
			limitAmt.value = '';
		}
	}
	else if(type ='sel'){
		var selBox = document.getElementById(obj1);
		var dest = document.getElementById(obj2);
		
		if(selBox.value == 'R'){
			dest.disabled = false;
		}
		else{
			dest.disabled = true;
			dest.value = '';
		}
		
		if(document.getElementById('approvedDays').value == 'U' && document.getElementById('approvedAmt').value == 'U'){
			alert(getMessage('BL9137','BL'));
			selBox.value='';
		}
	}
}

function fnEnableDisableDays(obj,dest1,dest2)
{
	var selBox = document.getElementById(obj);
	var destBox1 = document.getElementById(dest1);
	var destBox2 = document.getElementById(dest2);
	var noOfDays = document.forms[0].noOfDays;
	var limitAmt = document.forms[0].limitAmt;
	if(selBox.value == 'R'){
		destBox1.disabled = false;
		destBox2.disabled = false;
	}
	else{
		destBox1.disabled = true;
		destBox2.disabled = true;
		destBox1.value = '';
		destBox2.value = '';

		noOfDays.disabled = true;
		limitAmt.disabled = true;
		noOfDays.value = '';
		limitAmt.value = '';
	}
}

async function callCommonValidation(sqlSelect,obj,code){
	//alert("7");
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	//alert(sqlSelect);
	switch(sqlSelect){
			
		case 1:
		{
			sql="select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}
		case 2:
		{
			var cust_code = document.forms[0].payerCode2.value;
			//sql="Select long_name description,cust_code code from ar_customer_lang_vw Where cust_group_code ='"+cust_code+"' and ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_ID  FROM SM_ACC_ENTITY_PARAM_FACL where facility_id ='"+facility_id+"') and language_id = '"+locale+"' and upper(long_name) like upper(?) and upper(cust_code) like upper(?) order by 2";
			/*sql = 	"Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where Cust_Code In (Select Cust_Code From Bl_Cust_By_Cust_Group "+
					"Where Cust_Group_Code='"+cust_code+"' ) "+
					"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"') and upper(long_name) like upper(?) and upper(cust_code) like upper(?) "+
					"union "+
					"Select Label_Value  Long_Name,Label_Ref Cust_Code From Sm_Function_Legend_Lang "+
					"Where Function_Id= 'BL' And "+
					"upper(language_id) = upper('"+locale+"') "+
					"and label_type='DV' "+
					"and CANVAS_NAME='PAGE_1' "+
					"And Label_Ref='**'";*/
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where Cust_Code In ( SELECT cust_code "+
                    "FROM bl_cust_by_cust_group "+
                    "WHERE cust_group_code = "+
                             "DECODE ('"+cust_code+"', "+
                                     "'**', cust_group_code, '"+ cust_code+
                                    "')) "+
					"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'Payer';
			break;
		}
		case 3:
		{
			//sql="select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_ID  FROM SM_ACC_ENTITY_PARAM_FACL where facility_id ='"+facility_id+"') and language_id = '"+locale+"' and upper(long_desc) like upper(?) and upper(cust_group_code) like upper(?) order by 2";
			/*sql="select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
				"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
				"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
				"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
				"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') and upper(long_desc) like upper(?) and upper(cust_group_code) like upper(?) order by 2";*/
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}
		case 4:
		{
			sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
			title = 'Policy';
			break;
		}
		case 5:
		{
			sql="Select Description,Code from (Select Long_Desc Description, Age_Group_Code Code  From Bl_Ins_Age_Group where nvl(Status,'E') != 'D' Union Select 'All Age groups','**' From Dual) where  upper(Description) like upper(?) and upper(Code) like upper(?) ";
			title = 'Age Group';
			break;
		}
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	} 


}

async function callCommonValidationSpec(obj,code,clinicNurs,clinicCode){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var sqlSelect = '';
	var clinicVal = clinicCode.value;
	if(clinicNurs.value == 'C'){
		if(clinicVal != '**'){
			sqlSelect = 1;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else if(clinicNurs.value == 'N'){
		if(clinicVal != '**'){
			sqlSelect = 2;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else{
		sqlSelect = 3;
	}
	//alert(sqlSelect);
	//alert(clinicNurs.value)
	switch(sqlSelect){
			
		case 1:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select speciality_code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' and clinic_code = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}

		case 2:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY WHERE  FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}

		case 3:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"'  Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}
					
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		code.value = arr[0];	
	}
	else
	{
	obj.value = arr[1];;
	code.value = arr[0];;		
		//obj.value = returnedValues[1];
	} 


}

function callBGDesc(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	//alert(sqlSelect);
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			//alert(cn);
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			else{
				alert('Please select Clinic / Nursing Unit');
				return false;
			}
			
			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			else{
				alert('Please select Inc / Exc Criteria');
				return false;
			}
			
			break;
		}
			
	}

	//alert(sql)
	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	} 


}

//Policy Details Add
function addRowNew(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	//alert('Befor Crash')
	if(pageInfo == 'inclExclCoverage'){
		//alert('InclExcl')
		addRow('InclExcl')
	}
	else if(pageInfo == 'preApproval'){
		//alert('PreApproval')
		addRow('PreApproval')
	}
	else if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}

function removeSelectedRow(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	//alert('Befor Crash')
	if(pageInfo == 'inclExclCoverage'){
		//alert('InclExcl')
		removeRow('InclExcl')
	}
	else if(pageInfo == 'preApproval'){
		//alert('PreApproval')
		removeRow('PreApproval')
	}
	else if(pageInfo == 'PreApprovalPopup'){
		removeRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
//Policy Details Add
//Policy Details Add Close
function addRowNewAddClose(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
function removeRowNewAddClose(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'PreApprovalPopup'){
		removeRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
function saveAddClose(){
	var frmObj = parent.PolicyDetailsPage.document.forms[0];
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup");
	window.close();	
}
//Policy Details Add Close

//Policy Details Incl Excl
function checkDateFrom(obj){
	var stdt = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].startDate.value;
	var endt = parent.PolicyCoverageMain.SercviceCoverage.document.forms[0].endDate.value;
	var startdtarr = stdt.split("/");
	var enddtarr = endt.split("/");
	var objarr = obj.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range between "+stdt+" and "+endt);
		obj.value = '';
	}
	
	/*if( startdt!= null && enddt != null ){
		alert('test')
	if(startdt<enddt){
		alert("Start Date cannot be greater than End date");
	}
	}*/
}
function enableDisableLink(indx){
	var chk = 'serviceLmt_'+indx;
	var obj = 'serviceLink_'+indx;
	var serv = "incExCriteria_"+indx;
	var val = document.getElementById(serv).value;
	var chkBox = document.getElementById(chk);
	var link = document.getElementById(obj);
	var blng_code = 'bg_code_'+indx;
	var blng_code_val = document.getElementById(blng_code).value;
	if(chkBox.checked){
		if(!(val == 'BSG' || val=='BSGC' || val=='ESG' || val=='T' || val=='PG')){
			alert(getMessage("BL9134","BL"));
			link.style.visibility = 'hidden';
			chkBox.checked = false;
		}
		else{
			if(blng_code_val.length>0){
				link.style.visibility = 'visible';
			}
			else{
				alert('Enter Billing Service details');
				link.style.visibility = 'hidden';
				chkBox.checked = false;
			}
		}
		
	}else{
		link.style.visibility = 'hidden';
	}
	
}
async function showService(obj){
	//alert(obj)
	var serv = "incExCriteria_"+obj;
	var val = document.getElementById(serv).value;
	/*if(!(val == 'S' || val=='C' || val=='G' || val=='L')){
		alert('Exclusions not available for selected Criteria');
		return false;
	}*/
	var patClass = document.getElementById("ptClass_"+obj).value;
	var blngCode = document.getElementById("bg_code_"+obj).value;
	var payerGroup = document.getElementById('payerGroup').value;
	var payer = document.getElementById('payer').value;
	var policy = document.getElementById('policy').value;
	var mode = document.getElementById('mode').value;
	var startDate = document.getElementById("effFrom_"+obj).value;
	var endDate = document.getElementById("effTo_"+obj).value;
	
	var encEpsd = document.getElementById("episode_"+obj).value;
	var gender = document.getElementById("gender_"+obj).value;
	var ageGroup = document.getElementById("hdn_age_group_"+obj).value;
	var clinicNursInd = document.getElementById("clinic_"+obj).value;
	var clinicNursCode = document.getElementById("clinic_code_"+obj).value;
	var spltyCode = document.getElementById("spec_code_"+obj).value;
	
	var priorityKey = document.forms[0].priorityKey.value;
	var patientId = document.forms[0].patientId.value;
	var visitId = document.forms[0].visitId.value;
	var acctSeq = document.forms[0].acctSeq.value;
	var priority = document.forms[0].priority.value;
	var episodeType = document.forms[0].episodeType.value;		
	var episodeId = document.forms[0].episodeId.value;
	var policyNo = document.forms[0].policyNo.value;
	var policyEncounter = document.forms[0].policyEncounter.value;
	var facility_id = document.forms[0].facility_id.value;
	//alert(val);
	var dialogUrl       = "../../eBL/jsp/CommonPolicyPreApprovalPopupFrame.jsp?title=Service&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+'&priorityKey='+priorityKey+
						'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;
	//pArgumentArray[9] = title;

	//var dialogArguments = pArgumentArray ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";

	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('effTo_'+obj)
	}
	
}

function showToolTip(obj){
	var tab_dat  = "<table id='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='contextMenu' width='100%' "+
					"height='100%' align='center'><tr><td class = 'contextMenuItem' nowrap>"+obj+"</td> </tr></table>";
	document.getElementById("menu_table").innerHTML = tab_dat;
	resizeWindow();
}

function hideToolTip(){
  document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function resizeWindow(){
//alert();
	bodwidth = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	var x =  event.x;
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x = event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight || event.y<30){
		y = event.y

	}else if(y>bodheight && event.y<100){
		if(event.y>60 && event.y<100){
			y = event.y-20
	}else if(y>bodheight && event.y<200){
		}else if(event.y>100 && event.y<120){
			y = 80
		}else if(event.y>120 && event.y<140){
			y = 100
		}else if(event.y>140 && event.y<160){
			y = 120
		}else if(event.y>160 && event.y<180){
			y = 140
		}else if(event.y>180 && event.y<200){
			y = 160
		}else if(event.y>180 && event.y<200){
			y = 160
		}else{
			y = event.y
		}
	}else if(y<bodheight || event.y>320){
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	}else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	}
	if(y<0)
		y=0;
	y+=document.body.scrollTop
	x+=document.body.scrollLeft

		//alert("x:=="+x)
		//alert("y:=="+y)
		//y=18;

	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}
//Policy Details Incl Excl

//Search tro Code

function callBGDescCode(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	//alert(sqlSelect);
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			//alert(cn);
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' description,'**' code From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			else{
				alert('Please select Clinic / Nursing Unit');
				return false;
			}

			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr  where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			else{
				alert('Please select Inc / Exc Criteria');
				return false;
			}
			break;
		}
			
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;

	/*if(!(sqlSelect == '1' && drop.value == 'A')){
	returnedValues = CommonLookup(title, argumentArray );
	}
	else{
		returnedValues = new Array();
		returnedValues[0] = '**'
		returnedValues[1] = 'All Clinic/ Nursing Unit';
	}*/
	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
	else
	{
		if(sqlSelect == '1' && drop.value == 'A'){
			obj.value = 'All Clinic/ Nursing Unit';
			code.value = '**';	
		}
		else{
			obj.value = '';
			code.value = '';	
		}
			
	} 


}

function callCommonValidationSpecCode(obj,code,clinicNurs,clinicCode){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var sqlSelect = '';
	var clinicVal = clinicCode.value;
	if(clinicNurs.value == 'C'){
		if(clinicVal != '**'){
			sqlSelect = 1;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else if(clinicNurs.value == 'N'){
		if(clinicVal != '**'){
			sqlSelect = 2;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else{
		sqlSelect = 3;
	}

	switch(sqlSelect){
			
		case 1:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select speciality_code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' and clinic_code = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}

		case 2:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY WHERE  FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}

		case 3:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"'  Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}
					
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
	else
	{
	obj.value = '';
	code.value = '';		
	} 


}

function fnClearCode(obj){
	obj.value = '';
}
//Search tro Code

//Lookup for Billing Service Popup
function callBlngServPopup(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';

	var criteria = drop.value;
	var parent = document.forms[0].criteria.value;
	var parent_blng_code = document.forms[0].blngCode.value;

	if(parent == 'BSG'){
		if(criteria == 'BSGC'){
			sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE upper(substr(serv_classification_code,1,2)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Classification';
		}
		else if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,2)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
		else if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
		else if(criteria == 'PG'){
			sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
			title = 'Package Group';
		}
	}
	else if(parent == 'BSGC'){
		if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,4)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
	}
	else if(parent == 'PG'){
		if(criteria == 'BSG'){
			sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Service Group';
		}
		else if(criteria == 'BSGC'){
			sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Classification';
		}
		else if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
		else if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
		else if(criteria == 'T'){
			sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Sale Category';
		}
		else if(criteria == 'ESG'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group';
		}
		else if(criteria == 'ESGL'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group Line';
		}
	}
	else if(parent == 'T'){
		if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
	}
	else if(parent == 'ESG'){
		if(criteria == 'ESGL'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group Line';
		}
	}

	
	/*if(criteria == 'S'){
		sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Services';							
	}
	else if(criteria == 'BSG'){
		sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Service Group';
	}
	else if(criteria == 'BSGC'){
		sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Classification';
	}
	else if(criteria == 'ESG'){
		sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Enterprise Service Group';
	}
	else if(criteria == 'ESGL'){
		sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Enterprise Service Group Line';
	}
	
	else if(criteria == 'PG'){
		sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Package Group';
	}
	else if(criteria == 'M'){
		sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Material Item';
	}
	else if(criteria == 'T'){
		sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Sale Category';
	}*/
	
//	alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(sqlSelect == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}
	else if(sqlSelect == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
	}
		
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
	else
	{
		obj.value = '';
		code.value = '';		
	} 


}
//Lookup for Billing Service Popup
function resizeFrames(){
	document.getElementById('resizeLink').style.visibility = 'hidden';
	document.getElementById('resizeBtn').style.visibility = 'hidden';
	document.getElementById('resetLink').style.visibility = 'visible';
	document.getElementById('resetBtn').style.visibility = 'visible';
	parent.document.getElementById('ContainerFrame').rows="0%,8%,86%,6%";
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="100%,0%,0%";
	
	
}

function resetFrames(){
	document.getElementById('resizeLink').style.visibility = 'visible';
	document.getElementById('resizeBtn').style.visibility = 'visible';
	document.getElementById('resetLink').style.visibility = 'hidden';
	document.getElementById('resetBtn').style.visibility = 'hidden';
	parent.document.getElementById('ContainerFrame').rows="56%,8%,30%,6%";
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";
	
	
}

function fnShowPolicyDetailReport(){
	
	
	var frm = parent.PolicyDetailsPage.document.forms[0];
	
	var mode = 'modify';
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policy = frm.policy.value;
	var priorityKey = frm.priorityKey.value;
	var patientId = frm.patientId.value;
	var visitId = frm.visitId.value;
	var acctSeq = frm.acctSeq.value;
	var priority = frm.priority.value;
	var episodeType = frm.episodeType.value;		
	var episodeId = frm.episodeId.value;
	var policyNo = frm.policyNo.value;
	var policyEncounter = frm.policyEncounter.value;
	var facility_id = frm.facility_id.value;
	var endDate = frm.endDate.value;
	var startDate = frm.startDate.value;
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'inclExclCoverage'){
		
		var frmObjSave = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
		var xmlStringSave=formXMLStringMain(frmObjSave);
		updation=formValidation(xmlStringSave,"serviceCoverage",priorityKey);
		
		getXMLStringPriority('lookup',priorityKey);
		
/*	var dialogUrl = "../../eBL/jsp/PolicyDetailsData.jsp?"+
		"title=Include Exclude Details"+				
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&patientId="+patientId+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		"&policyNo="+policyNo+
		"&policyEncounter="+policyEncounter+
		"&priorityKey="+priorityKey;
		*/

		
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Include Exclude Details"+
		"&source=PolicyDetailsData"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&patientId="+patientId+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		"&policyNo="+policyNo+
		"&policyEncounter="+policyEncounter+
		"&priorityKey="+priorityKey;

		var dialogFeatures  = "dialogHeight:" + "35" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
		
		
		window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
		parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/CommonPolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if(pageInfo == 'preApproval'){
		
		var frmObjSave = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
		var xmlStringSave=formXMLStringMain(frmObjSave);
		updation=formValidation(xmlStringSave,"serviceCoverage",priorityKey);
		
		getXMLStringPriority('lookupPreApproval',priorityKey);
		
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Pre Approval Details"+
		"&source=PreApprovalDetailsData"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&patientId="+patientId+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		"&policyNo="+policyNo+
		"&policyEncounter="+policyEncounter+
		"&priorityKey="+priorityKey;


		var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
		window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
		parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/CommonPolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id;
	}
	else if(pageInfo == 'PreApprovalPopup'){
		getXMLStringPriority('lookupPreApprovalPopup',priorityKey);
		var patClass = frm.patClass.value;
		var encEpsd = frm.encEpsd.value;
		var gender = frm.gender.value;
		var ageGroup = frm.ageGroup.value;
		var clinicNursInd = frm.clinicNursInd.value;
		var clinicNursCode = frm.clinicNursCode.value;
		var spltyCode = frm.spltyCode.value;
		var criteria = frm.criteria.value;
		var blngCode = frm.blngCode.value;
		var rowNumber = frm.rowNumber.value;
		
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Service Limit Details"+
		"&source=PolicyExclusionDetailsData"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payerGroup="+payerGroup+
		"&payer="+payer+
		"&policy="+policy+
		"&patientId="+patientId+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		"&policyNo="+policyNo+
		"&policyEncounter="+policyEncounter+
		"&priorityKey="+priorityKey+
		
		"&patClass="+patClass+
		"&encEpsd="+encEpsd+
		"&gender="+gender+
		"&ageGroup="+ageGroup+
		"&clinicNursInd="+clinicNursInd+
		"&clinicNursCode="+clinicNursCode+
		"&spltyCode="+spltyCode+
		"&criteria="+criteria+
		"&blngCode="+blngCode+
		"&rowNumber="+rowNumber;


		var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
		window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
		parent.PolicyDetailsPage.document.location.href = "../../eBL/jsp/CommonPolicyPreApprovalPopup.jsp?title=Service&rowNumber="+rowNumber+"&criteria="+criteria+"&patClass="+patClass+"&blngCode="+blngCode+
		"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+'&priorityKey='+priorityKey+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&policyNo='+policyNo+'&policyEncounter='+policyEncounter+'&facility_id='+facility_id+
		"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;

	}
	
}

function fnLoadSelectedCoverage(epsdEnc,patClass,ageGrp,gender,clinicNurs,clinicNursCode,specCode,criteria,billServCode,startDate,funcMode){

	var mode = document.forms[0].mode.value;
	var payerGroup = document.forms[0].payerGroup.value;
	var payer = document.forms[0].payer.value;
	var policy = document.forms[0].policy.value;
	var priorityKey = document.forms[0].priorityKey.value;
	var patientId = document.forms[0].patientId.value;
	var visitId = document.forms[0].visitId.value;
	var acctSeq = document.forms[0].acctSeq.value;
	var priority = document.forms[0].priority.value;
	var episodeType = document.forms[0].episodeType.value;		
	var episodeId = document.forms[0].episodeId.value;
	var policyNo = document.forms[0].policyNo.value;
	var policyEncounter = document.forms[0].policyEncounter.value;
	var facility_id = document.forms[0].facility_id.value;
	var endDate = document.forms[0].endDate.value;
	
	var temp_jsp="../../eBL/jsp/CommonPolicyInclExclPersistance.jsp?func_mode="+funcMode+'&key='+priorityKey+
	'&mode='+mode+
	'&payergroupCode='+payerGroup+
	'&payerCode='+payer+
	'&policyCode='+policy+
	'&priorityKey='+priorityKey+
	'&patientId='+patientId+
	'&visitId='+visitId+
	'&acctSeq='+acctSeq+
	'&priority='+priority+
	'&episodeType='+episodeType+
	'&episodeId='+episodeId+
	'&policyNo='+policyNo+
	'&policyEncounter='+policyEncounter+
	'&facility_id='+facility_id+
	'&epsdEnc='+epsdEnc+
	'&patClass='+patClass+
	'&ageGrp='+ageGrp+
	'&gender='+gender+
	'&clinicNurs='+clinicNurs+
	'&clinicNursCode='+clinicNursCode+
	'&specCode='+specCode+
	'&criteria='+criteria+
	'&billServCode='+billServCode+
	'&startDate='+startDate;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	if(responseText == 'No'){
		alert('Record already added');
		return false;
	}else{
		window.close();
	}

}

function fnLoadSelectedCoveragePopup(criteriaPop,billServCodePop,startDatePop){

	var rowNumber = document.forms[0].rowNumber.value;
	var criteria = document.forms[0].criteria.value;
	var startDate = document.forms[0].startDate.value;
	var endDate = document.forms[0].endDate.value;
	var priorityKey = document.forms[0].priorityKey.value;
	var blngCode = document.forms[0].blngCode.value;

	var mode = document.forms[0].mode.value;
	var payerGroup = document.forms[0].payerGroup.value;
	var payer = document.forms[0].payer.value;
	var policy = document.forms[0].policy.value;

	var patClass = document.forms[0].patClass.value;
	var encEpsd = document.forms[0].encEpsd.value;
	var gender = document.forms[0].gender.value;
	var ageGroup = document.forms[0].ageGroup.value;
	var clinicNursInd = document.forms[0].clinicNursInd.value;
	var clinicNursCode = document.forms[0].clinicNursCode.value;
	var patientId = document.forms[0].patientId.value;
	var spltyCode = document.forms[0].spltyCode.value;
	
	var visitId = document.forms[0].visitId.value;
	var acctSeq = document.forms[0].acctSeq.value;
	var priority = document.forms[0].priority.value;
	var episodeType = document.forms[0].episodeType.value;		
	var episodeId = document.forms[0].episodeId.value;
	var policyNo = document.forms[0].policyNo.value;
	var policyEncounter = document.forms[0].policyEncounter.value;
	
	var temp_jsp="../../eBL/jsp/CommonPolicyInclExclPersistance.jsp?func_mode="+"preApprovalPopup"+'&key='+priorityKey+
	'&mode='+mode+
	'&payergroupCode='+payerGroup+
	'&payerCode='+payer+
	'&policyCode='+policy+
	'&priorityKey='+priorityKey+
	'&patientId='+patientId+
	'&visitId='+visitId+
	'&acctSeq='+acctSeq+
	'&priority='+priority+
	'&episodeType='+episodeType+
	'&episodeId='+episodeId+
	'&policyNo='+policyNo+
	'&policyEncounter='+policyEncounter+
	'&epsdEnc='+encEpsd+
	'&patClass='+patClass+
	'&ageGrp='+ageGroup+
	'&gender='+gender+
	'&clinicNurs='+clinicNursInd+
	'&clinicNursCode='+clinicNursCode+
	'&specCode='+spltyCode+
	'&criteria='+criteria+
	'&billServCode='+blngCode+
	'&startDate='+startDate+
	
	'&rowNumber='+rowNumber+
	'&criteriaPop='+criteriaPop+
	'&billServCodePop='+billServCodePop+
	'&startDatePop='+startDatePop;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	if(responseText == 'No'){
		alert('Record already added');
		return false;
	}else{
		window.close();
	}

}

function getXMLStringPriority(last_link,priorityKey)	
{
	
	if(last_link == "Outpatient")
	{
		
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Outpatient",priorityKey);
		
		
		
	}
	else if(last_link == "Inpatient")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"Inpatient",priorityKey);
		
	}
	else if(last_link == "External")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"External",priorityKey);
	}
	else if(last_link == "inclExclCoverage")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"inclExclCoverage",priorityKey);	
	}
	
	else if(last_link == "lookup")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"lookup",priorityKey);	
	}
	
	else if(last_link == "lookupPreApproval")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"lookupPreApproval",priorityKey);	
	}
	
	else if(last_link == "preApproval")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"preApproval",priorityKey);	
	}

	else if(last_link == "lookupPreApprovalPopup"){
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"lookupPreApprovalPopup",priorityKey);	
	}

	var excln_form = "";
	
	
	
}

/* Added V181005-Aravindh/AAKH-CRF-0107/Starts */
function unCheckAllLineLvlRefChkBox(obj) {
	if(obj == 'hdr') {
		var formObj = parent.parent.PolicyDetailsPage;
		var inclRowCount = formObj.document.getElementById("inclRowCount").value;
		if(!(parent.parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverRefPriceHdr.checked)) {
			for(var i = 1; i<= inclRowCount; i++) {
				formObj.document.getElementById("coverRefPrice_"+i).checked = false;
			}
		}
	} else if(obj == 'line') {
		var formObj = parent.PolicyDetailsPage;
		var inclRowCount = formObj.document.getElementById("inclRowCount").value;
		if(!(parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverRefPriceHdr.checked)) {
			for(var i = 1; i<= inclRowCount; i++) {
				formObj.document.getElementById("coverRefPrice_"+i).checked = false;
			}
		}
	}
}
