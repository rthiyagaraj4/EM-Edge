
// Page Added by Rajesh V. Policy Definition Related JS Functions
/*<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V211027			18595	      MMS-DM-CRF-0185			      Mohana Priya K
2			 V211202			26604	      MMS-ICN-00126-TF			      Mohana Priya K
3			 V211130			26231		    KDAH-SCF-0744-TF	        	Mohanapriya K
4			 V221017						MMS-DM-CRF-0209 			Namrata Charate
5             V221118/V230403                        37851         MOHE-SCF-0196  Mohanapriya
----------------------------------------------------------------------------------------------
-->*/

function create() {
    PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert";
}

function reset() {
    // PolicyDefinitionMainFrame.location.href =
    // "../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert";
    PolicyDefinitionMainFrame.location.reload();	
}

function query() {
    commontoolbarFrame.document.forms[0].apply.disabled = true;
    PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/PolicyDefinitionQueryCriteria.jsp";
}

function onSuccess() {
    PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=insert";
}

function cal_error(str_message, obj) {
	
    alert(str_message);
    //obj.select();
	obj.value="";
	obj.focus();
    return false;
}

function clearBill(obj) {
    var bgCode = 'bg_code_' + obj;
    var bgDesc = 'bg_desc_' + obj;
    document.getElementById(bgCode).value = '';
    document.getElementById(bgDesc).value = '';
   
    var acrossEnc = document.getElementById('acrossEncounter_' + obj);
    var sameEpsd = document.getElementById('encGrpIdSameEpsd_' + obj);
    var timeVal = document.getElementById('timeLimitValOP_' + obj);
    var timeType = document.getElementById('timeLimitTypeOP_' + obj);
    var groupRserviceInd = document.getElementById('GroupServiceInd_' + obj);//MMS-QH-CRF-0170-US-4 PALANINARAYANAN
    var page_info=document.getElementById('pageInfo').value;

    var SiteSpecGrpSer = document.getElementById('SiteSpecGroupServiceInd').value;//MMS-QH-CRF-0170-US-4 PALANINARAYANAN
    if(page_info=='inclExclCoverage'){
    var SiteSpec = document.getElementById('SiteSpecific').value;
    var criteria = document.getElementById('incExCriteria_' + obj).value;
    if (criteria == 'S' || criteria == 'ESGL' || criteria == 'M') {
		acrossEnc.disabled = false;
		sameEpsd.disabled = false;
		timeType.disabled = false;
		timeVal.readOnly = false;
		if(SiteSpec=='Y' && page_info == 'inclExclCoverage'){		
		var inclhomemedi = document.getElementById('inclhomeMedi_' + obj);
		inclhomemedi.checked = false;
		inclhomemedi.disabled = true;
        }   
	}
	else{
        acrossEnc.disabled = true;
        sameEpsd.disabled = true;
        timeType.disabled = true;
        timeVal.readOnly = true;
    
        acrossEnc.value = '';
        sameEpsd.value = '';
        timeType.value = 'D';
        timeVal.value = '';
        if(SiteSpec=='Y' && page_info == 'inclExclCoverage'){
        	  var inclhomemedi = document.getElementById('inclhomeMedi_' + obj);
        inclhomemedi.checked = false;
        inclhomemedi.disabled = true;
        }
    }
    //MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
    if(SiteSpecGrpSer=='Y')
    	{	
        if (criteria == 'S' || criteria == 'ESGL' || criteria == 'M' || criteria == 'P') 
        {
           	groupRserviceInd.disabled = true;	
            	groupRserviceInd.value = '';
            	groupRserviceInd = '';    	  
        }
        else		
        {
         	groupRserviceInd.disabled = false;
          	groupRserviceInd.value = 'G';
        }	
    	}
    //MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
    	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/starts
	var Site_PreappDur=document.getElementById('Site_PreappDur').value;
	if(page_info=='preApproval' && Site_PreappDur=='Y'){
		  var criteria = document.getElementById('type_' + obj).value;
		  var preAppDur = document.getElementById('preAppDur_' + obj);
		  var pregroupRserviceInd = document.getElementById('preGroupServiceInd_' + obj);//MMS-QH-CRF-0170-US-4  PALANINARAYANAN
		 if (criteria == 'PG' || criteria == 'M' || criteria == 'T') {		 
		  var code = document.getElementById('bg_code_' + obj);
		  if(code.value!=''){		 
			  preAppDur.value = '';
			  preAppDur.disabled = false;
		  }
		  else{			  
			  preAppDur.value = '';
			  preAppDur.disabled = true;  
		  }		
		}
		 else{			
			  preAppDur.value = '';
			  preAppDur.disabled = true;			 
		 }
		//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
		 if(SiteSpecGrpSer=='Y')
	    	{
		 if (criteria == 'S' || criteria == 'ESGL' || criteria == 'M' || criteria == 'P') 
	    	{	    
	    	    	pregroupRserviceInd.disabled = true;	
	    	    	pregroupRserviceInd.value = '';
	    	    	pregroupRserviceInd = '';	    	    	
	    	}
	    else		
	    	{
	    	 	pregroupRserviceInd.disabled = false;
	        	pregroupRserviceInd.value = 'G';
			  }
		//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
	    	}		 
}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
}

function clearClinic(obj) {
    var clinicCode = 'clinic_code_' + obj;
    var clinicDesc = 'clinic_desc_' + obj;
    var clinicNurs = 'clinic_' + obj;
    var clinNursVal = document.getElementById(clinicNurs);
    var clinicBut = 'clinic_but_' + obj;
    var specCode = 'spec_code_' + obj;
    var specDesc = 'spec_desc_' + obj;
    document.getElementById(clinicDesc).disabled = false;
    document.getElementById(clinicCode).readonly = false;
    document.getElementById(clinicCode).value = '';
    document.getElementById(clinicDesc).value = '';
    document.getElementById(clinicBut).disabled = false;
    document.getElementById(specCode).value = '';
    document.getElementById(specDesc).value = '';
    if (clinNursVal.value == 'A') {
        document.getElementById(clinicDesc).value = 'All Clinic/ Nursing Unit'; // Modified by Rajesh V
        document.getElementById(clinicCode).value = '**';
        document.getElementById(clinicDesc).disabled = true;
        document.getElementById(clinicCode).readonly = true;
        document.getElementById(clinicBut).disabled = true;
    }
}

function clearBillPop(obj) {
    var bgCode = 'pop_bg_code_' + obj;
    var bgDesc = 'pop_bg_desc_' + obj;
    document.getElementById(bgCode).value = '';
    document.getElementById(bgDesc).value = '';
}

function validate(obj) {
	var page_info=document.getElementById('pageInfo').value;
	if(page_info='inclExclCoverage'){
		var epsdEnc = document.getElementById('episode_' + obj).value;
		var patClass = document.getElementById('ptClass_' + obj).value;
		var clinicInd = document.getElementById('clinic_' + obj).value;
		var criteria = document.getElementById('incExCriteria_' + obj).value;
		var incExInd = document.getElementById('incExInd_'+obj).value;
		var SiteSpec = document.getElementById('SiteSpecific').value;

    if (SiteSpec == 'Y') {
        var inclhomemedi = document.getElementById('inclhomeMedi_' + obj);
	if((epsdEnc == 'N' || epsdEnc =='A')  && criteria== 'P' && incExInd== 'I' ){
            inclhomemedi.disabled = false;
		}
	else{  
			inclhomemedi.checked = false;
            inclhomemedi.disabled = true;
        }
    }
}
}

function changeEpsdEnc(obj) {
    var epsdEnc = document.getElementById('episode_' + obj).value;
    var patClass = document.getElementById('ptClass_' + obj);
    var clinicInd = document.getElementById('clinic_' + obj);
    var page_info=document.getElementById('pageInfo').value;

    if (epsdEnc == 'E') {
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
		if(page_info == 'inclExclCoverage'){
		validate(obj);
		}
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
        if(page_info == 'inclExclCoverage'){
		validate(obj);
		}
    } else if (epsdEnc == 'A') {
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
        if(page_info == 'inclExclCoverage'){
		validate(obj);
		}
    } else {
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

        /*
         * opt = document.createElement("option"); opt.value = ''; opt.innerText =
         * 'Select'; clinicInd.appendChild(opt);
         */

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
		if(page_info == 'inclExclCoverage'){
		validate(obj);
		}
    }
}

function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
    var startdt = new Date();
    var enddt = new Date();
    startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
    if (startDate.value.length > 0 && endDate.value.length > 0) {
        if (startdt > enddt) {
            alert(getMessage('BL1344', 'BL'));
            endDate.value = '';
        }
    }
}

function defaultDate(val, dateObj) {
    if (val == 'startDate') {
        var dateVal = parent.PolicyDetailsPage.document.getElementById('effFrom_1').value;
        if (dateVal.length < 1) {
            parent.PolicyDetailsPage.document.getElementById('effFrom_1').value = dateObj.value;
        }
	}
	else if (val == 'endDate') {
        var dateVal = parent.PolicyDetailsPage.document.getElementById('effTo_1').value;
        if (dateVal.length < 1) {
            parent.PolicyDetailsPage.document.getElementById('effTo_1').value = dateObj.value;
        }
    }
}

function isValidDate(obj) {
    if (obj.value != "") {
        var flag = true;
        var RE_NUM = /^\/?\d+$/;
        var str_date = obj.value;
        var arr_date = str_date.split('/');
        if (arr_date.length != 3)
            return cal_error(getMessage('INVALID_DATE_FMT', 'SM'), obj); // flag=false;

        if (arr_date[0] != null) {
            if (arr_date[0].length != 2)
                flag = false;
        }
        if (arr_date[1] != null) {
            if (arr_date[1].length != 2)
                flag = false;
        }
        if (arr_date[2] != null) {
            if (arr_date[2].length != 4)
                flag = false;
        }
        if (!arr_date[0])
            flag = false;
        if (!RE_NUM.exec(arr_date[0]))
            flag = false;
        if (!arr_date[1])
            flag = false;
        if (!RE_NUM.exec(arr_date[1]))
            flag = false;
        if (!arr_date[2])
            flag = false;
        if (arr_date[2].length != 4)
            flag = false;
        var dt_date = new Date();
        dt_date.setDate(1);
        if (arr_date[1] < 1 || arr_date[1] > 12)
		flag = false;
		dt_date.setMonth(arr_date[1] - 1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
        if (dt_date.getMonth() != (arr_date[1] - 1))
            flag = false;

        if (flag == false) {
            return cal_error(getMessage('INVALID_DATE_FMT', 'SM'), obj);
        }
    }
    return true;
}

/*
 * Karthik added the below Function to prevent to check User Credentials Again
 * for AuthenticatedUser - Starts
 */

function createPolicyUserAuthenticationValidationMain(payerCode, payer, policy) {
    var frmObj = document.forms[0];
    var temp_jsp = "../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=POLICY_DEFN_CREATE";
    if (payerCode != null) {
        temp_jsp += "&payerCode=" + payerCode.value;
    }
    if (payer != null) {
        temp_jsp += "&payer=" + payer.value;
    }
    if (policy != null) {
        temp_jsp += "&policy=" + policy.value;
    }
    var xmlString = formXMLStringMain(frmObj);
    var updation = formPayerValidation(xmlString, temp_jsp);
    if(document.forms[0].siteSpecPolApprv.value == "true") {//Added V190517-Aravindh/NMC-JD-CRF-0010
    	doUserAuthenticationValidationPayerApprove();
    }
    return updation;
}

function doUserAuthenticationValidationMain(successfulUser) {
    var frmObj = document.forms[0];
    var temp_jsp = "../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=POLICY_DEFN_MODIFY";
    if (successfulUser != null) {
        temp_jsp += "&successfulUser=" + successfulUser;
    }
    var xmlString = formXMLStringMain(frmObj);
    var updation = formPayerValidation(xmlString, temp_jsp);
    if(document.forms[0].siteSpecPolApprv.value == "true") {//Added V190517-Aravindh/NMC-JD-CRF-0010
    	doUserAuthenticationValidationPayerApprove(successfulUser);
    }
    //Added V190701 MuthuN/NMC-JD-CRF-0002.1
    if(frmObj.siteSpecClaimExist.value == "true") {    	
    	claimAgreeReqYN();
    }
    return updation;
}

function formPayerValidation(xmlStr, temp_jsp) {
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = xmlHttp.responseText;
    /*
     * If the given users authentication returns true then string @@@SUCCESS@@@
     * will be present in the response HTML else string @@@FAILED@@@ will be
     * present
     */
    if (responseText.indexOf('@@@SUCCESS@@@') == -1) { // If success string is
        // not found return
        // false
        return false;
    } else {
        return true;
    }
}

/*
 * Karthik added the below Function to prevent to check User Credentials Again
 * for AuthenticatedUser - Ends
 */

async function authUser(obj) {

    var dialogHeight = "400px";//14
    var dialogWidth = "700px";//22
    var dialogTop = "10px";//225
    var center = "1";
    var status = "no";
    var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" +
        dialogWidth + "; center: " + center + "; status: " + status +
        "; dialogTop :" + dialogTop;
    var arguments = "";
    // var modPatientId = document.getElementById("hiddenPatientId").value;

    /*
     * Karthik added the below Function to prevent popup from asking User
     * Credentials Again The String AuthenticatedUser will be compared to
     * prevent popup - Starts
     */
    var checkAuthUserforPayer = false;
    var retVal = new Array();
    if (obj != '' && obj == "AuthenticatedUser") {
        retVal[0] = "Y";
        checkAuthUserforPayer = true;
    } /* Code to prevent popup for Authenticated User - Ends */
    else {
        retVal = await window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments, features);
        /*
         * Karthik added the below Code to prevent to check User Credentials for
         * Adding Payer even for Successfully Authenticated Newly provided User -
         * Starts
         */

        /*
         * Karthik added the below Code to prevent to check User Credentials for
         * Adding Payer even for Successfully Authenticated Newly provided User -
         * Ends
         */
    }
    if (retVal != undefined) {
	if (retVal.length > 0) {
		if (retVal[0] == "Y") {
			var successfulUser = retVal[3];
                if(document.forms[0].successfulUser != undefined) {//Added V190517-Aravindh/NMC-JD-CRF-0010
                	document.forms[0].successfulUser.value = successfulUser;
                }
			checkAuthUserforPayer = doUserAuthenticationValidationMain(successfulUser);
			if (checkAuthUserforPayer == null)
				checkAuthUserforPayer = false;

			if (checkAuthUserforPayer == false) {
				alert("User " + successfulUser +
					" dont have permissions to Add/Modify Policy");
			}
			if (checkAuthUserforPayer == true) {
				document.forms[0].add_mod.disabled = true;
				document.forms[0].screeningPolicy.disabled = false;
				document.forms[0].settlementApplicability.disabled = false;
				document.forms[0].startDate.disabled = false;
				document.forms[0].startDate_ctrl.disabled = false;
				document.forms[0].endDate.disabled = false;
				document.forms[0].endDate_ctrl.disabled = false;
				document.forms[0].percent.disabled = false;
				document.forms[0].startDateChk.disabled = false;
				if (document.getElementById("siteSpec").value == "false") {
					document.forms[0].expDays.disabled = false;
				}
				
        if(document.forms[0].siteSpecPolApprv.value == "true") {
        	document.forms[0].policyApprvdYN.disabled = false;
        }
        //Added V190701 MuthuN/NMC-JD-CRF-0002.1
				if(document.forms[0].siteSpecClaimExist.value == "true") {
					document.forms[0].ClaimsAgrmtExts.disabled = false;
				}
			//Added V190701 MuthuN/NMC-JD-CRF-0002.1
        document.forms[0].coverageRules.disabled = false;
				document.forms[0].coverageBasis.disabled = false;

				var start_dt = document.forms[0].startDate.value;
				if (start_dt.length > 0) {
					document.forms[0].startDate.readOnly = true;
					document.forms[0].startDate_ctrl.disabled = true;
				}
				
				//Added against NMC-JD-CRF-0045 by Priya Starts 26-08-2020
				var pageInfo=document.getElementById('pageInfo').value;
				if(pageInfo=="PolicyInfo"){
					  var siteSpecRmrk=document.getElementById('siteSpecPolDefIncExc').value;
					if((siteSpecRmrk=='true'|| siteSpecRmrk==true)&& document.getElementById('GroupPolicy').checked==true){
  					document.forms[0].screeningPolicy.disabled = true;
  					document.forms[0].settlementApplicability.disabled = true;
  					document.forms[0].percent.disabled = true;
					  document.forms[0].startDate_ctrl.disabled = false;//29-08-2020
  					document.forms[0].startDateChk.disabled = true;
  					document.forms[0].ClaimsAgrmtExts.disabled = true;
  					document.forms[0].coverageRules.disabled = true;
  					document.forms[0].coverageBasis.disabled = true;
  					document.forms[0].policyApprvdYN.disabled = true;
  					document.getElementById('remarks').innerHTML	= '<a href="#" id="remarks" onclick="return false;" >Remarks</a><img src="../../eCommon/images/mandatory.gif">';
					}
				}//Added against NMC-JD-CRF-0045 by Priya Ends 26-08-2020
				var auth = 'Y';
				document.forms[0].auth.value = auth;
				var payerGroupCode = document.forms[0].payerCode2.value;
				var payerCode = document.forms[0].payerCode.value;
				var policyCode = document.forms[0].policyTypeCode.value;
				var startDate = document.forms[0].startDate.value;
				var endDate = document.forms[0].endDate.value;

			// Modify
			//parent.document.getElementById('ContainerFrame').rows = "31%,39%,5%,19%,6%";
			parent.document.getElementById("PolicyInfoFrame").style.height="31vh";
	parent.document.getElementById("PolicyCoverageMain").style.height="39vh";
	parent.document.getElementById("PolicyDetailsTab").style.height="8vh";
	parent.document.getElementById("PolicyDetailsPage").style.height="45vh";
	parent.document.getElementById("PolicyDetailsAdd").style.height="10vh";
			parent.PolicyCoverageMain.document.location.href = '../../eBL/jsp/PolicyCoverageMain.jsp?mode=modify&payergroupCode=' +
				payerGroupCode +
				'&payerCode=' +
				payerCode +
				'&policyCode=' +
				policyCode +
				'&startDate=' +
				startDate +
				'&endDate=' +
				endDate +
				'&auth=' +
				auth;
			parent.PolicyDetailsTab.document.location.href = '../../eBL/jsp/PolicyDetailsTab.jsp';
			parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/PolicyDetailsInclExcl.jsp?mode=modify&payergroupCode=' +
			payerGroupCode +
			'&payerCode=' +
			payerCode +
			'&policyCode=' +
			policyCode +
			'&startDate=' +
			startDate +
			'&endDate=' +
			endDate +
			'&auth=' +
			auth;
			parent.PolicyDetailsAdd.document.location.href = '../../eBL/jsp/PolicyDetailsAdd.jsp?mode=modify&auth=' +
				auth;
			// Modify
			}
		}
	}
    }
}

function checkAlpha(event) {
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForPer(obj) {
    if (obj.value > 100) {
        alert(getMessage('BL9135', 'BL'));
        obj.value = '';
    }

    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    } else {
        if (obj.value.length > 0) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkForNumber(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    } else {
        if (obj.value.length > 0) {

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
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForNumberDecimal(obj) {
    var decArr = obj.value.split('.');
	//V221017
	if(isNaN(decArr[0]))
	{
		alert(getMessage('BL8532', 'BL'));
		obj.value = '';
		return false;
	}
    if (decArr.length > 2) {
        alert(getMessage("NUM_ALLOWED", "SM"));
        obj.value = '';
        return false;
    }

    if (decArr.length == 2) {
        if (decArr[0].length < 1 && decArr[1].length < 1) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
        if (decArr[1].length > 2) {
            alert('Only Two Numbers are allowed beyond Decimal');
            obj.value = '';
            return false;
        }
    }
}

function apply() {
	var calledForm = "";
	if(parent.PolicyInfoFrame != undefined) {
		calledForm = parent.PolicyInfoFrame.frmPolicyInfo.calledForm.value;//Added V191017-Aravindh/NMC-JD-CRF-0010.2
	}
	var mainfrmObj = "";
	if("policyApproval" == calledForm) {
		mainfrmObj = parent.PolicyInfoFrame.frmPolicyInfo;
	} else {
		mainfrmObj = PolicyDefinitionMainFrame.PolicyInfoFrame.frmPolicyInfo;
	}
    var siteSpec = mainfrmObj.siteSpec.value; // Added By Vijay For
    // MMS-QF-SCF-567

    var auth = mainfrmObj.auth.value;
    if (auth == 'N') {
        alert(getMessage('BL9136', 'BL'));
        commontoolbarFrame.location.reload();
        return;
    }
    var payerLbl = getLabel("eBL.PAYER.label", "bl");
    var policyLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
    var polRules = getLabel("eBL.PolicycoverageRules.label", "bl");
    var polBasis = getLabel("eBL.PolicycoverageBasis.label", "bl");
    var polExpry = getLabel("eBL.PolicyExpDays.label", "bl");
    var noOfDays = "No of Days"; // getLabel("Common.noofdays.label","common");
    var amtLimit = getLabel("eBL.LimitAmt.label", "bl");
    var polStartDate = getLabel("eBL.POLICY_START_DATE.label", "bl");
    var polEndDate = getLabel("eBL.PolicyEndDate.label", "bl");
    var remarkslbl = getLabel("Common.remarks.label", "bl");//NMC-JD-CRF-0010.1
        
    var dfltStartChk = mainfrmObj.startDateChk;
    var siteSpecPolEndDate = mainfrmObj.siteSpecPolEndDate.value; //Added V180529-Subha/AAKH-SCF-0358
    var siteSpecPolDefRemarks = mainfrmObj.siteSpecPolDefRemarks.value;//NMC-JD-CRF-0010.1
	var siteSpecPayrRefcode = mainfrmObj.siteSpecPayrRefcode.value;//V211027
	 var mode = mainfrmObj.mode.value;//19-08-2020
    if (dfltStartChk.checked == true) {
        // Added By Vijay For MMS-QF-SCF-567
        if (siteSpec == "false" || siteSpecPolEndDate == "true") { //Subha
            var fieldsTop = new Array(mainfrmObj.payerCode,
                mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
                mainfrmObj.coverageRules, mainfrmObj.coverageBasis,
                mainfrmObj.expDays, mainfrmObj.startDate);
            var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl,
                polRules, polBasis, polExpry, polStartDate);
        } else {
            var fieldsTop = new Array(mainfrmObj.payerCode,
                mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
                mainfrmObj.coverageRules, mainfrmObj.coverageBasis,
                mainfrmObj.startDate, mainfrmObj.endDate);
            var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl,
                polRules, polBasis, polStartDate, polEndDate);
        }
    } else if(siteSpecPolEndDate == "true" || siteSpecPolEndDate == true)		{
    	var fieldsTop = new Array(mainfrmObj.payerCode,
                mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
                mainfrmObj.coverageRules, mainfrmObj.coverageBasis,
                mainfrmObj.startDate);
            var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl, polRules,
                polBasis, polStartDate);
    }
    else {
        var fieldsTop = new Array(mainfrmObj.payerCode,
            mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
            mainfrmObj.coverageRules, mainfrmObj.coverageBasis,
            mainfrmObj.startDate, mainfrmObj.endDate);
        var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl, polRules,
            polBasis, polStartDate, polEndDate);
    }	
	//NMC-JD-CRF-0010.1    
  if(siteSpecPolDefRemarks == "true" || siteSpecPolDefRemarks == true)		{
		var GroupPolicyVal=mainfrmObj.GroupPolicy.value; //Added by Priya against NMC-JD-CRF-0045
	if(mode=="modify")
    {	//Added against NMC-JD-CRF-0010.1 28/08/2020
		if( mainfrmObj.blremarks.value=="" ||  mainfrmObj.blremarks.value==null){
			var  status	=chkBlremarks();
			if(status!="" && status!=null){
				mainfrmObj.blremarks.value=status;
			}
		}
    }
	if(GroupPolicyVal=="N"){//Added by Priya against NMC-JD-CRF-0045
		var fieldsTop = new Array(mainfrmObj.payerCode,
            mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
            mainfrmObj.coverageRules, mainfrmObj.coverageBasis,
            mainfrmObj.startDate,mainfrmObj.blremarks);
		var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl, polRules,
            polBasis, polStartDate, remarkslbl);		
	}else{
      var fieldsTop = new Array(mainfrmObj.payerCode,
              mainfrmObj.policyTypeCode, mainfrmObj.payerCode2,
			mainfrmObj.startDate);
      var namesTop = new Array(payerLbl, policyLbl, payerGrpLbl,polStartDate);
		}
    }
    //NMC-JD-CRF-0010.1    
	if(siteSpecPayrRefcode == "true" || siteSpecPayrRefcode == true)		{ 
		var ref_code=mainfrmObj.ref_code.value; 
	}
//V211027
    // Commented by Rajesh V - To make No of days & Amt Limt as non Mandatory
    // Field
    /*
     * var frmServ =
     * PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
     * if(frmServ.approvedDays.value == 'R'){ fieldsTop.push(frmServ.noOfDays);
     * namesTop.push(noOfDays) }
     * 
     * if(frmServ.approvedAmt.value == 'R'){ fieldsTop.push(frmServ.limitAmt);
     * namesTop.push(amtLimit) }
     */
    var msgFrame;//Added V191017-Aravindh/NMC-JD-CRF-0010.2
    if("policyApproval" == calledForm) {
    	msgFrame = parent.messageFrame;
    } else {
    	msgFrame = messageFrame;
    }
    //19-08-2020
		//19-08-2020
	//if (checkFieldsofMst(fieldsTop, namesTop, msgFrame)) 
	if (checkFieldsofMst(fieldsTop, namesTop, msgFrame)) 
	{//19-08-2020
    	//Added V182704-Subha/AAKH-SCF-0358/Starts
    	var policyEndDate = mainfrmObj.endDate; 
    	if(siteSpecPolEndDate == "true" && policyEndDate.value == "") {
    		policyEndDate.value = "31/12/2099";
    	}
    	//Added V182704-Subha/AAKH-SCF-0358/Ends

        var xmlString = formXMLStringMain(mainfrmObj);
        var updation = formValidation(xmlString, "infoFrame");

        var frmObj = "";
    	if("policyApproval" == calledForm) {
    		frmObj = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
    	} else {
    		frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
    	}
        var mode = mainfrmObj.mode.value;		
        xmlString = formXMLStringMain(frmObj);
        updation = formValidation(xmlString, "serviceCoverage");
        
        if("policyApproval" == calledForm) {
    		frmObj = parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
    	} else {
    		frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
    	}
        var prevtab = frmObj.prevTab.value;
        xmlString = formXMLStringMain(frmObj);
        updation = formValidation(xmlString, prevtab);

        if("policyApproval" == calledForm) {
    		frmObj = parent.PolicyDetailsPage.document.forms[0];
    	} else {
    		frmObj = PolicyDefinitionMainFrame.PolicyDetailsPage.document.forms[0];
    	}
        var pageInfo = frmObj.pageInfo.value;
        xmlString = formXMLStringMain(frmObj);
        updation = formValidation(xmlString, pageInfo);

        var temp_jsp = "../../eBL/jsp/PolicyDefinitionDeletePersistence.jsp?func_mode=MergeBeans";
        var xmlStr = "<root><SEARCH ";
        xmlStr += " /></root>";
        // var
        // temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=validatePolicy&payerGroup="+payerCode.value+"&payer="+payer.value+"&policy="+policy.value;
        var xmlDoc="";
        var xmlHttp = new XMLHttpRequest();
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        xmlHttp.open("POST", temp_jsp, false);
        xmlHttp.send(xmlDoc);
        var responseText = trimString(xmlHttp.responseText);
        mainfrmObj.target = 'messageFrame';
        mainfrmObj.method = "post";
        mainfrmObj.action = "../../servlet/eBL.PolicyDefinitionMasterServlet?mode=" + mode;
        mainfrmObj.submit();
    }
}

function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
    }
    return xmlStr;
}

function formValidation(xmlStr, last_link, event) {
	//alert("function");
    var temp_jsp = "PolicyDefinitionPersistence.jsp?func_mode=" + last_link;
    if (event != null && event == "delete")
        temp_jsp = "PolicyDefinitionPersistence.jsp?func_mode=" + last_link +
        "&event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    /*
     * if (xmlDoc.parseError.errorCode != 0) { //alert("Error in line " +
     * xmlDoc.parseError.line + " position " + xmlDoc.parseError.linePos +
     * "\nError Code: " + xmlDoc.parseError.errorCode + "\nError Reason: " +
     * xmlDoc.parseError.reason + "Error Line: " + xmlDoc.parseError.srcText);
     * return(null); }
     */
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    /*
     * if (xmlDoc.parseError.errorCode != 0) { alert("Error in line " +
     * xmlDoc.parseError.line + " position " + xmlDoc.parseError.linePos +
     * "\nError Code: " + xmlDoc.parseError.errorCode + "\nError Reason: " +
     * xmlDoc.parseError.reason + "Error Line: " + xmlDoc.parseError.srcText);
     * return(null); }
     */
    var responseText = xmlHttp.responseText;
	//alert("responseText");
    //eval(responseText);
	//alert("responseText1");
    return responseText;
}

//Added against NMC-JD-CRF-0045 by Priya 28/08/2020
function groupPolicyChkd(){
			document.forms[0].coverageRules.selectedIndex=0;
			document.forms[0].coverageBasis.selectedIndex=0;
			document.forms[0].screeningPolicy.checked = false;
			document.forms[0].settlementApplicability.checked = false;
			document.forms[0].startDateChk.checked = false;
			document.forms[0].percent.value = '';
			document.forms[0].ClaimsAgrmtExts.checked = false;
			document.forms[0].policyApprvdYN.checked = false;
      //Added against NMC-JD-CRF-0045 by Priya 28/08/2020
			
			document.forms[0].screeningPolicy.disabled = true;
			document.forms[0].settlementApplicability.disabled = true;
			document.forms[0].percent.disabled = true;
			document.forms[0].startDateChk.disabled = true;
			document.forms[0].ClaimsAgrmtExts.disabled = true;
			document.forms[0].coverageRules.disabled = true;
			document.forms[0].coverageBasis.disabled = true;
			document.forms[0].policyApprvdYN.disabled = true;
			//document.getElementById('remarks').innerHTML	= '<a href="#" id="remarks" onclick="return false;" >Remarks</a><img src="../../eCommon/images/mandatory.gif">';
			document.getElementById('remarks').innerHTML	= '<a href="#" id="remarks" onclick="return false;" >Remarks</a>';
			document.getElementById("payerGroup2_btn").disabled = true;
			document.getElementById("payerGroup2").disabled = true;
			document.getElementById("facility").disabled = true;
			document.getElementById("policyType").disabled = true;
			document.getElementById("policyType_btn").disabled = true;
			document.getElementById("payerGroup1").disabled = true;
			document.getElementById("payerGroup1_btn").disabled = true;
			document.getElementById("copy_policy").disabled = true;
			document.getElementById("policyApprvdYN").disabled = true;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.defaultCriteria.selectedIndex=0;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.overrideInclExcl.checked=false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverageIclu.checked=false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.lastPayer.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthReq.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthMand.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.defaultCreditAuth.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patCopay.value="";
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitType.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.AmtMode.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.applicability.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patLimitAmt.value="";//31-08-2020
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkBillGen.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.encGrpIdSameEpsd.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.value="";
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.approvedDays.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.noOfDays.value="";
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.approvedAmt.selectedIndex=0;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitAmt.value="";//31-08-2020
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.approvedDays.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.noOfDays.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.approvedAmt.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitAmt.disabled=true;
			
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.defaultCriteria.disabled=true;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.overrideInclExcl.disabled=true;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverageIclu.disabled=true;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.lastPayer.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthReq.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthMand.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.defaultCreditAuth.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patCopay.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitType.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.AmtMode.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.applicability.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patLimitAmt.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkBillGen.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.encGrpIdSameEpsd.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.disabled=true;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered.disabled=true;//01-09-2020
}

function servTabGpPolicyChk(){
			document.forms[0].creditAuthReq.checked=false;
			document.forms[0].creditAuthMand.checked=false;
			document.forms[0].defaultCreditAuth.checked=false;
			document.forms[0].patCopay.value="";
			document.forms[0].limitType.selectedIndex=0;
			document.forms[0].AmtMode.selectedIndex=0;
			document.forms[0].applicability.checked=false;
			document.forms[0].patLimitAmt.value="";//31-08-2020
			document.forms[0].chkBillGen.selectedIndex=0;
			document.forms[0].encGrpIdSameEpsd.checked=false;
			document.forms[0].timeLimitValue.disabled=true;
			document.forms[0].timeLimitType.disabled=true;
			document.forms[0].chkInvoiceGen.disabled=true;
			document.forms[0].timeLimitValue.value="";
			document.forms[0].timeLimitType.selectedIndex=0;
			document.forms[0].chkInvoiceGen.selectedIndex=0;
			document.forms[0].approvedDays.selectedIndex=0;
			document.forms[0].noOfDays.value="";
			document.forms[0].approvedAmt.selectedIndex=0;
			document.forms[0].limitAmt.value="";//31-08-2020
			document.forms[0].approvedDays.disabled=true;
			document.forms[0].noOfDays.disabled=true;
			document.forms[0].approvedAmt.disabled=true;
			document.forms[0].limitAmt.disabled=true;
			document.forms[0].creditAuthReq.disabled=true;
			document.forms[0].creditAuthMand.disabled=true;
			document.forms[0].defaultCreditAuth.disabled=true;
			document.forms[0].patCopay.disabled=true;
			document.forms[0].limitType.disabled=true;
			document.forms[0].AmtMode.disabled=true;
			document.forms[0].applicability.disabled=true;
			document.forms[0].patLimitAmt.disabled=true;
			document.forms[0].chkBillGen.disabled=true;
			document.forms[0].encGrpIdSameEpsd.disabled=true;
			document.forms[0].timeLimitValue.disabled=true;
			document.forms[0].timeLimitType.disabled=true;
			document.forms[0].chkInvoiceGen.disabled=true;
			document.forms[0].timeLimitValue.disabled=true;
			document.forms[0].timeLimitType.disabled=true;
			document.forms[0].chkInvoiceGen.disabled=true;
			document.forms[0].covered.checked=false;//31-08-2020
			document.forms[0].covered.disabled=true;//01-09-2020
}

function servTabGpPolicyUnChk(){
			document.forms[0].creditAuthReq.disabled=false;
			document.forms[0].creditAuthMand.disabled=false;
			document.forms[0].defaultCreditAuth.disabled=false;
			document.forms[0].patCopay.disabled=false;
			document.forms[0].AmtMode.disabled=false;
			document.forms[0].applicability.disabled=false;
			document.forms[0].patLimitAmt.disabled=false;
			document.forms[0].chkBillGen.disabled=false;
			document.forms[0].encGrpIdSameEpsd.disabled=false;
			document.forms[0].timeLimitValue.disabled=false;
			document.forms[0].timeLimitType.disabled=false;
			document.forms[0].chkInvoiceGen.disabled=false;
			document.forms[0].timeLimitValue.disabled=false;
			document.forms[0].timeLimitType.disabled=false;
			document.forms[0].chkInvoiceGen.disabled=false;	
			var mode=document.forms[0].mode.value;//73839
			document.forms[0].covered.disabled=false;//01-09-2020
		/*	if(mode=='insert'){
				document.forms[0].covered.checked=false;
			}//73839   */
}

function groupPolicyUnChkd(){
			document.forms[0].screeningPolicy.disabled = false;
			document.forms[0].settlementApplicability.disabled = false;
			document.forms[0].percent.disabled = false;
			document.forms[0].startDateChk.disabled = false;
			document.forms[0].ClaimsAgrmtExts.disabled = false;
			document.forms[0].coverageRules.disabled = false;
			document.forms[0].coverageBasis.disabled = false;
			document.forms[0].policyApprvdYN.disabled = false;
			document.getElementById("remarks").innerHTML= '<a href="#" onclick="return Remarks();" >Remarks</a><img id="remarksImg" src="../../eCommon/images/mandatory.gif">';
			document.getElementById("payerGroup2_btn").disabled = false;
			document.getElementById("payerGroup2").disabled = false;
			document.getElementById("facility").disabled = false;
			document.getElementById("policyType").disabled = false;
			document.getElementById("policyType_btn").disabled = false;
			document.getElementById("payerGroup1").disabled = false;
			document.getElementById("payerGroup1_btn").disabled = false;
			document.getElementById("copy_policy").disabled = false;
			document.getElementById("policyApprvdYN").disabled = false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.defaultCriteria.disabled=false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.overrideInclExcl.disabled=false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverageIclu.disabled=false;
			parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.lastPayer.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthReq.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.creditAuthMand.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.defaultCreditAuth.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patCopay.disabled=false;
			//parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitType.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.AmtMode.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.applicability.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.patLimitAmt.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkBillGen.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.encGrpIdSameEpsd.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitValue.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.timeLimitType.disabled=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.chkInvoiceGen.disabled=false;	
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered.checked=false;
			parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered.disabled=false;//01-09-2020
			/*parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered.onclick=function() { fnEnableDisableLimit('chk','parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.covered','parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails.limitType'); };	*/		
        //this is unchecked now'
}

function fnEnableDisableLimit(type, obj1, obj2) {
	//Modified against NMC-JD-CRF-0045 by Priya 28/08/2020 Starts
	var groupPolicyFlag=false;
	var siteSpecRmrk=true;
	var pageInfo=document.getElementById('pageInfo').value;
	if(pageInfo=="servtabdet"){
		siteSpecRmrk=document.getElementById('siteSpecPolDefservcov').value;
	if(siteSpecRmrk==true || siteSpecRmrk=="true")
	{	
		var mainfrmObj = "";
		if("BODY" == document.activeElement.tagName) {
			mainfrmObj = parent.PolicyInfoFrame.frmPolicyInfo;
		} else if("INPUT" == document.activeElement.tagName || "SELECT" == document.activeElement.tagName){
			mainfrmObj = parent.parent.PolicyInfoFrame.frmPolicyInfo;
		}
			groupPolicyFlag=mainfrmObj.GroupPolicy.checked;			
	}
	if((((groupPolicyFlag==false) || (groupPolicyFlag=="false")) && ((siteSpecRmrk==true) || (siteSpecRmrk=="true")))||((siteSpecRmrk==false) || (siteSpecRmrk=="false"))){
		if (type == 'chk') {
			var chkBox = document.getElementById(obj1);
			var dest = document.getElementById(obj2);
			var destBox1 = document.getElementById('approvedDays');
			var destBox2 = document.getElementById('approvedAmt');
			var noOfDays = document.forms[0].noOfDays;
			var limitAmt = document.forms[0].limitAmt;
	
			if (chkBox.checked) {
				dest.disabled = false;
			} else {
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
    } else if (type = 'sel') {
        var selBox = document.getElementById(obj1);
        var dest = document.getElementById(obj2);

        if (selBox.value == 'R') {
            dest.disabled = false;
        } else {
            dest.disabled = true;
            dest.value = '';
        }

        if (document.getElementById('approvedDays').value == 'U' &&
            document.getElementById('approvedAmt').value == 'U') {
            alert(getMessage('BL9137', 'BL'));
            selBox.value = '';
        }
    }
}
}
//Modified against NMC-JD-CRF-0045 by Priya 28/08/2020 Ends
}

function fnEnableDisableDays(obj, dest1, dest2) {
    var selBox = document.getElementById(obj);
    var destBox1 = document.getElementById(dest1);
    var destBox2 = document.getElementById(dest2);
    var noOfDays = document.forms[0].noOfDays;
    var limitAmt = document.forms[0].limitAmt;
    if (selBox.value == 'R') {
        destBox1.disabled = false;
        destBox2.disabled = false;
    } else {
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

function validatePolicy(payerCode, payer, policy) {
//salert("PolicyDefinition.js 1258 validatePolicy("+payerCode +payer +policy);
    /*
     * Karthik added the below change to check user previlage rights for each
     * Policy-Starts
     */
    var allowUser = false;
    /*
     * Karthik added the below change to check user previlage rights for each
     * Policy - Ends
     */

    if (payerCode.value.length > 0 && payer.value.length > 0 &&
        policy.value.length > 0) {
			//alert("PolicyDefinition.js 1273 inside 1st condition") ;
        allowUser = createPolicyUserAuthenticationValidationMain(payerCode,
            payer, policy);
        if (allowUser == false) {
            alert("User dont have permissions for Adding this Payer/Policy");
            payerCode.value = '';
            payer.value = '';
            policy.value = '';
            var qryFrm = document.forms[0];
            qryFrm.payerGroup2.value = '';
            qryFrm.payerGroup1.value = '';
            qryFrm.policyType.value = '';
        } else {
            var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
            var temp_jsp = "../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=validatePolicy&payerGroup=" +
                payerCode.value +
                "&payer=" +
                payer.value +
                "&policy=" +
                policy.value;
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
            xmlHttp.open("POST", temp_jsp, false);
            xmlHttp.send(xmlDoc);
            var responseText = trimString(xmlHttp.responseText);
            if (responseText == 'N') {
                alert(getMessage('BL9138', 'BL'));
  				//Added against NMC-JD-CRF-0045
  				if(document.getElementById('policyType_btn').disabled==true){
  					document.getElementById('policyType_btn').disabled=false;
  				}
            payerCode.value = '';
            payer.value = '';
            policy.value = '';

            var frm = document.forms[0];
            frm.payerGroup2.value = '';
            frm.payerGroup1.value = '';
            frm.policyType.value = '';
            }
        }
    }
}

// Copy Policy Functions
async function fnCopyPolicy(payerCode, payer, policy, startDate, endDate) {
    var frm = document.forms[0];
    var locale = frm.locale.value;
    var facility_id = frm.facility_id.value;
    var siteSpec = frm.siteSpec.value;

    if (payerCode.value.length > 0 && payer.value.length > 0 &&
        policy.value.length > 0) {
        if (siteSpec == 'true') {
            if (startDate.value.length == 0 || endDate.value.length == 0) {
                alert(getMessage('BL9122', 'BL'));
                return false;
            }
        } else {
            if (startDate.value.length == 0) {
                alert(getMessage('BL9324', 'BL'));
                return false;
            }
        }
        var dialogHeight = "45vh";
        var dialogWidth = "35vw";
        var dialogTop = "0vh";
        var center = "1";
        var status = "no";
        var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" +
            dialogWidth + "; center: " + center + "; status: " + status +
            "; dialogTop :" + dialogTop;
        var arguments = "";
        // var modPatientId = document.getElementById("hiddenPatientId").value;
        retVal =await window.showModalDialog(
            "../../eBL/jsp/PolicyDefinitionCopyPolicy.jsp?locale=" + locale +
            "&facility_id=" + facility_id + "&toPayerCode=" +
            payerCode.value + "&toPayer=" + payer.value +
            "&toPolicy=" + policy.value + "&startDate=" +
            startDate.value + "&endDate=" + endDate.value,
            arguments, features);
       if(retVal!=undefined && retVal!= null )
        	{
        var retValArr = retVal.split(":::###");
        if (retValArr[0] == "Y") {
            parent.parent.PolicyDefinitionMainFrame.document.location.href = "../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=modify&payergroupCode=" +
                payerCode.value +
                "&payerCode=" +
                payer.value +
                "&policyCode=" +
                policy.value +
                "&startDate=" +
                retValArr[1] + "&endDate=" + retValArr[2];
        }
        }
    } else {
        alert(getMessage('BL9139', 'BL'));
    }
}

function validateCopyPolicy(payerCode, payer, policy) {
    if (payerCode.value.length > 0 && payerCode.value.length > 0 &&
        policy.value.length > 0) {
        var xmlStr = "<root><SEARCH ";
        xmlStr += " /></root>";
        var temp_jsp = "../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=validatePolicy&payerGroup=" +
            payerCode.value +
            "&payer=" +
            payer.value +
            "&policy=" +
            policy.value;
        var xmlDoc="";
        var xmlHttp = new XMLHttpRequest();
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        xmlHttp.open("POST", temp_jsp, false);
        xmlHttp.send(xmlDoc);
        var responseText = trimString(xmlHttp.responseText);
        if (responseText == 'Y') {
            alert(getMessage('BL9140', 'BL'));
            payerCode.value = '';
            payer.value = '';
            policy.value = '';

            var frm = document.forms[0];
            frm.payerGroup2.value = '';
            frm.payerGroup1.value = '';
            frm.policyType.value = '';
        }
    }
}

function fnApplyCopyPolicy(payerCode, payer, policy) {
    var frm = document.forms[0];
    var toPayerCode = frm.toPayerCode.value;
    var toPayer = frm.toPayer.value;
    var toPolicy = frm.toPolicy.value;
    var startDate = frm.startDate.value;
    var endDate = frm.endDate.value;
    // var toPolicy = 'abcde';
    var locale = frm.locale.value;
    var facility_id = frm.facility_id.value;

    if (payerCode.value.length > 0 && payerCode.value.length > 0 &&
        policy.value.length > 0) {
        var xmlStr = "<root><SEARCH ";
        xmlStr += " /></root>";
        var temp_jsp = "../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=copyPolicy&fromPayerCode=" +
            payerCode.value +
            "&fromPayer=" +
            payer.value +
            "&fromPolicy=" +
            policy.value +
            "&fromFacility=" +
            facility_id +
            "&toPayerCode=" +
            toPayerCode +
            "&toPayer=" +
            toPayer +
            "&toPolicy=" +
            toPolicy +
            "&toFacility=" +
            facility_id +
            "&startDate=" +
            startDate +
            "&endDate=" +
            endDate;
        var xmlDoc="";
        var xmlHttp = new XMLHttpRequest();
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        xmlHttp.open("POST", temp_jsp, false);
        xmlHttp.send(xmlDoc);
        var responseText = trimString(xmlHttp.responseText);
        var responsetextArr = responseText.split(":::###");
        alert(responsetextArr[0]); // Completion Success Message
        if (responsetextArr[1] == "Y") {
            window.returnValue = "Y:::###" + responsetextArr[2] + ":::###" +
                responsetextArr[3];
            window.close();
        } else {
            window.returnValue = "N:::###" + responsetextArr[2] + ":::###" +
                responsetextArr[3];
            window.close();
        }
    } else {
        alert(getMessage('BL9139', 'BL'));
    }
}

function fnCancelCopyPolicy() {
    window.returnValue = "N";
    window.close();
}

// Copy Policy Functions
function changeInclExclInd(index) {
    var inclIndChk = document.getElementById('incExChk_' + index);
    var incBasis = document.getElementById('incBasis_' + index);
    var value = document.getElementById('value_' + index);
    var valueChk1 = document.getElementById('valueChk1_' + index);
    var valueChk3 = document.getElementById('valueChk3_' + index);
    var valueChk4 = document.getElementById('valueChk4_' + index);
    var servItemQty = document.getElementById('servItemQty_' + index);
    var amtPerVisit = document.getElementById('amtPerVisit_' + index);
    var amtPerIPDay = document.getElementById('amtPerIPDay_' + index);
    var noOfDays = document.getElementById('noOfDays_' + index);
    var serviceLmt = document.getElementById('serviceLmt_' + index);
    var amtMode = document.getElementById('AmtMode_' + index);
    var patCopay = document.getElementById('patCopay_' + index);
    var patLimitAmt = document.getElementById('patLimitAmt_' + index);
    var epsdEnc = document.getElementById('episode_'+index).value;
    var SiteSpec = document.getElementById('SiteSpecific').value;
    var page_info=document.getElementById('pageInfo').value;	
    //MMS-QH-CRF-0170-US-4  PALANINARAYANAN
     var groupRserviceInd = document.getElementById('GroupServiceInd_' + index);//
 
    if(SiteSpec =='Y' && page_info=='inclExclCoverage' ){
    var inclhomemedi = document.getElementById('inclhomeMedi_'+index);
    var validCheck='';
    var bgCode = 'bg_code_'+index;
    var criteria = document.getElementById('incExCriteria_'+index).value;
    if(criteria == 'P'){
    var policyParam = 'calledFrom=policyDefn'+
    	'&type=PKG'+
    	'&service_code='+document.getElementById(bgCode).value;

		$.ajax({
		type:"GET",
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
		data:policyParam,
		dataType:"json",
		async:false,
		success: function(data){
			validCheck=data.includeHomeMedicationAllYN;
		},
		 error: function(data){
			 alert(data)
		  }
		});
		}
	}
    var inclExcl = document.getElementById('incExInd_' + index);
    if (inclExcl.value == 'E') {
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

        patCopay.value = '';
        patCopay.disabled = 'disabled';

        patLimitAmt.value = '';
        patLimitAmt.disabled = 'disabled';

      	amtMode.value = 'G';
      	amtMode.disabled = 'disabled';
        //MMS-QH-CRF-0170-US-4  PALANINARAYANAN
      	groupRserviceInd.disabled = true;	
      	groupRserviceInd.value = '';
      	groupRserviceInd = '';
        //MMS-QH-CRF-0170-US-4  PALANINARAYANAN
	
	if(SiteSpec =='Y' && (epsdEnc == 'N' || epsdEnc =='A') && criteria == 'P' && page_info=='inclExclCoverage'){
		
	inclhomemedi.checked = false;
	inclhomemedi.disabled = 'disabled';
	}
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
	if(criteria == 'P' && validCheck == 'Y' && SiteSpec =='Y' && (epsdEnc == 'N' || epsdEnc =='A') && page_info=='inclExclCoverage'){		
		inclhomemedi.disabled = false;
	}
        // serviceLmt.disabled = false;
    }
}

function changeInclExclIndPop(index) {
    var incBasis = document.getElementById('pop_incBasis_' + index);
    var value = document.getElementById('pop_value_' + index);
    var servItemQty = document.getElementById('pop_servItemQty_' + index);
    var amtPerVisit = document.getElementById('pop_amtPerVisit_' + index);
    var amtPerIPDay = document.getElementById('pop_amtPerIPDay_' + index);
    var noOfDays = document.getElementById('pop_noOfDays_' + index);
    var amtMode = document.getElementById('AmtMode_' + index);
    var patCopay = document.getElementById('pop_patCopay_' + index);
    var patLimitAmt = document.getElementById('pop_patLimitAmt_' + index);
    var inclExcl = document.getElementById('pop_incExInd_' + index);
    if (inclExcl.value == 'E') {
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

        patCopay.value = '';
        patCopay.disabled = 'disabled';

        patLimitAmt.value = '';
        patLimitAmt.disabled = 'disabled';

        amtMode.value = 'G';
        amtMode.disabled = 'disabled';
    } else {
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

async function callCommonValidationQryCriteria(sqlSelect, obj, code) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    // alert(sqlSelect);
    switch (sqlSelect) {
        case 1:
            {
                var cust_code = document.forms[0].payerCode2.value;
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
		case 2:
		{
			sql ="select description,code from(select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '" +
						facility_id +
						"' and upper(language_id) = upper('" +
						locale +
						"') union  Select 'All Policy','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Policy';
                break;//19-08-2020
		}

    }

    // var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL'
    // CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE
    // CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE
    // A.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE )
    // WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?)
    // ORDER BY 2";
    
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues =await CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = '';
        code.value = '';
        // obj.value = returnedValues[1];
    }
}

async function callCommonValidation(sqlSelect, obj, code) {
	//alert("11");
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    //Added against NMC-JD-CRF-0045 26-08-2020
	var pageInfo=document.getElementById('pageInfo').value;
    if(pageInfo=="PolicyInfo"){
    	var siteSpecRmrk=document.getElementById('siteSpecPolDefIncExc').value;
    }  
    //Added against NMC-JD-CRF-0045 ends 26-08-2020
    var sql = '';
    var title = '';
    switch (sqlSelect) {
        case 1:
            {
                sql = "select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
                title = 'Speciality';
                break;
            }
        case 2:
            {
        		var cust_code = document.forms[0].payerCode2.value;
                // sql="Select long_name description,cust_code code from
                // ar_customer_lang_vw Where cust_group_code ='"+cust_code+"' and
                // ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_ID FROM
                // SM_ACC_ENTITY_PARAM_FACL where facility_id ='"+facility_id+"') and
                // language_id = '"+locale+"' and upper(long_name) like upper(?) and
                // upper(cust_code) like upper(?) order by 2";
                /*
                 * sql = "Select long_name description,cust_code code from
                 * ar_customer_lang_vw "+ "Where Cust_Code In (Select Cust_Code From
                 * Bl_Cust_By_Cust_Group "+ "Where Cust_Group_Code='"+cust_code+"' ) "+
                 * "and acc_entity_code In (Select Acc_Entity_Code From Sy_Acc_Entity
                 * Where Acc_Entity_Id = '"+facility_id+"') "+ "and
                 * nvl(patient_flag,'N') ='Y' "+ "and nvl(pat_com_flag,'N')='N' "+ "And
                 * Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+ "and
                 * upper(language_id) = upper('"+locale+"') and upper(long_name) like
                 * upper(?) and upper(cust_code) like upper(?) "+ "union "+ "Select
                 * Label_Value Long_Name,Label_Ref Cust_Code From
                 * Sm_Function_Legend_Lang "+ "Where Function_Id= 'BL' And "+
                 * "upper(language_id) = upper('"+locale+"') "+ "and label_type='DV' "+
                 * "and CANVAS_NAME='PAGE_1' "+ "And Label_Ref='**'";
                 */
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where Cust_Code In ( SELECT cust_code " +
                "FROM bl_cust_by_cust_group " +
                "WHERE cust_group_code = " +
                "DECODE ('" +
                cust_code +
                "', " +
                "'**', cust_group_code, '" +
                cust_code +
                "')) " +
                "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
        case 3:
            {
                // sql="select long_desc description, cust_group_code code from
                // ar_cust_group_lang_vw where status is null and ACC_ENTITY_CODE IN
                // (SELECT ACC_ENTITY_ID FROM SM_ACC_ENTITY_PARAM_FACL where facility_id
                // ='"+facility_id+"') and language_id = '"+locale+"' and
                // upper(long_desc) like upper(?) and upper(cust_group_code) like
                // upper(?) order by 2";
                /*
                 * sql="select long_desc description, cust_group_code code from
                 * ar_cust_group_lang_vw where status is null and "+ "cust_group_code in
                 * (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where
                 * Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+ "where
                 * acc_entity_code in (Select Acc_Entity_Code From Sy_Acc_Entity Where
                 * Acc_Entity_Id = '"+facility_id+"') and upper(language_id) =
                 * upper('"+locale+"') "+ "and nvl(patient_flag,'N') ='Y' And
                 * Nvl(Insurance_Yn, 'N') = 'Y' )) "+ "And Acc_Entity_Code In (Select
                 * Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id =
                 * '"+facility_id+"') and upper(language_id) = upper('"+locale+"') and
                 * upper(long_desc) like upper(?) and upper(cust_group_code) like
                 * upper(?) order by 2";
                 */
                sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                "cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                "where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                "And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";

                title = 'Payer Group';
                break;
            }
        case 4:
            {	//Added against NMC-JD-CRF-0045 26-08-2020 
				if((siteSpecRmrk=='true' || siteSpecRmrk==true)){//ADDED FOR MMS=QH-0170-US-4
					sql ="select description,code from(select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'E') !='D' and operating_facility_id = '"+ 
					facility_id+"' and upper(language_id) = upper('"+
					locale+"') union Select 'All Policy','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//Modified against nmc-jd-crf-0059/V201027
				}else{
					sql = "select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'E') !='D' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+
					locale+"') and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";  //Modified against nmc-jd-crf-0059
        					}//ADDED FOR MMS=QH-0170-US-4
					title = 'Policy';
                break;
            }
        case 5:
            {
                sql = "Select Description,Code from (Select Long_Desc Description, Age_Group_Code Code  From Bl_Ins_Age_Group where nvl(Status,'E') != 'D' Union Select 'All Age groups','**' From Dual) where  upper(Description) like upper(?) and upper(Code) like upper(?) ";
                title = 'Age Group';
                break;
            }

    }

    // var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL'
    // CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE
    // CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE
    // A.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE )
    // WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?)
    // ORDER BY 2";
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
	
	//retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    //ADDED FOR MMS=QH-0170-US-4
	//Added against NMC-JD-CRF-0045 26-08-2020
		if(sqlSelect=='2' && (siteSpecRmrk==true || siteSpecRmrk=="true" )){
			if(code.value=="**"){
				document.getElementById('policyType').value="All Policy";
				document.getElementById('policyTypeCode').value="**";
				}
		}
    //ADDED FOR MMS=QH-0170-US-4
    } else {
       // obj.value = '';
        //code.value = '';
		obj.value = arr[1];
        code.value = arr[0];
        // obj.value = returnedValues[1];
    }

}
//V221118
async function callCommonValidationSpec(obj, code, clinicNurs, clinicCode)
{
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;		
	var clinicVal = clinicCode.value;	
	var sqlSelect;
	if (clinicNurs.value == 'C') {
        if (clinicVal != '**') {
            sqlSelect = 1;
        } else {
            sqlSelect = 3;
        }

    } else if (clinicNurs.value == 'N') {
        if (clinicVal != '**') {
            sqlSelect = 2;
        } else {
            sqlSelect = 3;
        }

    } else {
        sqlSelect = 3;
    }
	//V230403
	var sql = "";
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var title = "Specialty";
	if(sqlSelect == '1'){
		sql="BLINTERNALREP_4::blsql::"+clinicVal+"::"+facility_id+"::"+locale+"::";
	}
	else if(sqlSelect == '2'){
		sql="BLINTERNALREP_5::blsql::"+clinicVal+"::"+facility_id+"::"+locale+"::";
	}
	else if(sqlSelect == '3'){
		sql="BLINTERNALREP_6::blsql::"+locale+"::";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1"; //V220714
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		obj.value = arr[1];
		code.value = arr[0];
	} else {
		code.value = "";
		obj.value = "";
	}
}

//V221118
async function callCommonValidationSpecCode(obj, code, clinicNurs, clinicCode)
{
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;		
	var clinicVal = clinicCode.value;	
	
	var sqlSelect;
	if (clinicNurs.value == 'C') {
        if (clinicVal != '**') {
            sqlSelect = 1;
        } else {
            sqlSelect = 3;
        }

    } else if (clinicNurs.value == 'N') {
        if (clinicVal != '**') {
            sqlSelect = 2;
        } else {
            sqlSelect = 3;
        }

    } else {
        sqlSelect = 3;
    }
	var locale = document.getElementById('locale').value;
	//V230403
	var sql = "";
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var title = "Specialty";
	if(sqlSelect == '1'){
		sql="BLINTERNALREP_4::blsql::"+clinicVal+"::"+facility_id+"::"+locale+"::";
	}
	else if(sqlSelect == '2'){
		sql="BLINTERNALREP_5::blsql::"+clinicVal+"::"+facility_id+"::"+locale+"::";
	}
	else if(sqlSelect == '3'){
		sql="BLINTERNALREP_6::blsql::"+locale+"::";
	}
	
	//sql=queryParameter;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1"; //V220714
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		obj.value = arr[1];
		code.value = arr[0];
	} else {
		code.value = "";
		obj.value = "";
	}
	
}

async function callBGDesc(sqlSelect, drop, obj, code, obj1) {
//	alert("po");
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	
	var page_info=document.getElementById('pageInfo').value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
    // alert(sqlSelect);
    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                // alert(cn);
                if (cn == 'C') {
                    sql = "Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '" +
                        locale +
                        "' AND FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic';
                } else if (cn == 'N') {
                    sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='" +
                        locale +
                        "' AND  FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Nursing Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Nursing Unit';
                }

                break;
            }

        case 2:
            {
                var criteria = drop.value;
                if (criteria == 'S') {
                    sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('" +
                        locale +
                        "')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Services';
                } else if (criteria == 'BSG') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Service Group';
                } else if (criteria == 'BSGC') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('" +
                        locale +
                        "')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Classification';
                } else if (criteria == 'ESG') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group';
                } else if (criteria == 'ESGL') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group Line';
                } else if (criteria == 'PG') {
                    sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
                    title = 'Package Group';
                } else if (criteria == 'M') {
                    sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                        locale +
                        "')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Material Item';
                } else if (criteria == 'T') {
                    sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Sale Category';
                } else if (criteria == 'P') {
                    sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') AND OPERATING_FACILITY_ID = '" +
                        facility_id +
                        "' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Package';
                }

                break;
            }

    }

    // alert(sql)
    // var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL'
    // CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE
    // CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE
    // A.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE )
    // WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?)
    // ORDER BY 2";
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
	//retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
      //  obj.value = '';
        //code.value = '';
		arr[0]="";	
		 		arr[1]="";	
        // obj.value = returnedValues[1];
    }
if(page_info=='inclExclCoverage'){
	 var SiteSpec = document.getElementById('SiteSpecific').value;
if(criteria == 'P' && SiteSpec =='Y' ){

        var policyParam = 'calledFrom=policyDefn' +
            '&type=PKG' +
            '&service_code=' + code.value;

var inclhomemedi = document.getElementById('inclhomeMedi_'+obj1);

        $.ajax({
            type: "GET",
            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
            data: policyParam,
            dataType: "json",
            async: false,
            success: function(data) {
            	validCheck=data.includeHomeMedicationAllYN ;

                if (data.includeHomeMedicationAllYN == 'Y') 
		{

                    validate(obj1);
                } else {
                    if (inclhomemedi != null && inclhomemedi != undefined) {
                        inclhomemedi.disabled = true;
                    }
                }

            },
            error: function(data) {
                alert(data)
            }
        });
        
        if(validCheck!='Y'){
    	var inclhomemedi = document.getElementById('inclhomeMedi_'+obj1);
    	inclhomemedi.checked = false;
    	inclhomemedi.disabled = 'disabled';
    	}

    }
}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
if(page_info=='preApproval'){
	 var rowCount = document.getElementById('inclRowCount').value;
	var preAppDur = document.getElementById('preAppDur_'+rowCount);
	 var Site_PreappDur = document.getElementById('Site_PreappDur').value;
	 
	 if((criteria == 'PG' || criteria == 'T' || criteria == 'M')&& Site_PreappDur=='Y'){

		   var policyParam = 'calledFrom=preApproval' +
           '&type=' +criteria+
           '&service_code=' + code.value;

	     $.ajax({
	            type: "GET",
	            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
	            data: policyParam,
	            dataType: "json",
	            async: false,
	            success: function(data) {
           	validCheck=data.preappDurCapping;
					if(data.preappDurCapping=='Y')
					{
                  // validate(obj1);
						preAppDur.disabled = false;
					}
					else
						{
						preAppDur.disabled = true;
               }

           },
           error: function(data) {
               alert(data)
           }
       });
       
      

   }
	


}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
}

// Policy Details Add
function addRowNew() {
    var frm = parent.PolicyDetailsPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'inclExclCoverage') {
        addRow('InclExcl')
    } else if (pageInfo == 'preApproval') {
        addRow('PreApproval')
    } else if (pageInfo == 'PreApprovalPopup') {
        addRow('PreApprovalPopup')
    }
}

function removeSelectedRow() {
    var frm = parent.PolicyDetailsPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'inclExclCoverage') {
        removeRow('InclExcl')
    } else if (pageInfo == 'preApproval') {
        removeRow('PreApproval')
    } else if (pageInfo == 'PreApprovalPopup') {
        removeRow('PreApprovalPopup')
    }
}
// Policy Details Add
// Policy Details Add Close
function addRowNewAddClose() {
    var frm = parent.PolicyDetailsPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'PreApprovalPopup') {
        addRow('PreApprovalPopup')
    }
    // alert(pageInfo);
}

function removeRowNewAddClose() {
    var frm = parent.PolicyDetailsPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'PreApprovalPopup') {
        removeRow('PreApprovalPopup')
    } else if(pageInfo == 'DiagCopayPopup') {
        removeRow('DiagCopayPopup')
    }
    // alert(pageInfo);
}

function saveAddClose() {
    var frmObj = parent.PolicyDetailsPage.document.forms[0];
    xmlString = formXMLStringMain(frmObj);
    // alert(xmlString);
    updation = formValidation(xmlString, "popup");
    window.close();
}
// Policy Details Add Close

// Policy Details Incl Excl
function checkDateFrom(obj) {
    var stdt = parent.PolicyInfoFrame.document.forms[0].startDate.value;
    var endt = parent.PolicyInfoFrame.document.forms[0].endDate.value;
    var startdtarr = stdt.split("/");
    var enddtarr = endt.split("/");
    var objarr = obj.value.split("/");
    var startdt = new Date();
    var enddt = new Date();
    var objdt = new Date();
    startdt.setFullYear(startdtarr[2], startdtarr[1] - 1, startdtarr[0]);
    enddt.setFullYear(enddtarr[2], enddtarr[1] - 1, enddtarr[0]);
    objdt.setFullYear(objarr[2], objarr[1] - 1, objarr[0]);
    if ((objdt < startdt) || (objdt > enddt)) {
        return cal_error("Please enter date in range between " + stdt + " and " +
            endt, obj);
        // obj.focus();
    }

    /*
     * if( startdt!= null && enddt != null ){ alert('test') if(startdt<enddt){
     * alert("Start Date cannot be greater than End date"); } }
     */
}

function enableDisableLink(indx) {
    var chk = 'serviceLmt_' + indx;
    var obj = 'serviceLink_' + indx;
    var serv = "incExCriteria_" + indx;
    var blng_code = 'bg_code_' + indx;
    var val = document.getElementById(serv).value;
    var chkBox = document.getElementById(chk);
    var link = document.getElementById(obj);
    var blng_code_val = document.getElementById(blng_code).value;
    if (chkBox.checked) {
        if (!(val == 'BSG' || val == 'BSGC' || val == 'ESG' || val == 'T' || val == 'PG')) {
            alert(getMessage("BL9134", "BL"));
            link.style.visibility = 'hidden';
            chkBox.checked = false;
        } else {
            if (blng_code_val.length > 0) {
                link.style.visibility = 'visible';
            } else {
                alert('Enter Billing Service details');
                link.style.visibility = 'hidden';
                chkBox.checked = false;
            }
        }

    } else {
        link.style.visibility = 'hidden';
    }

}

async function showService(obj) {
    var serv = "incExCriteria_" + obj;
    var val = document.getElementById(serv).value;
    /*
     * if(!(val == 'S' || val=='C' || val=='G' || val=='L')){ alert('Exclusions
     * not available for selected Criteria'); return false; }
     */
    var patClass = document.getElementById("ptClass_" + obj).value;
    var blngCode = document.getElementById("bg_code_" + obj).value;
    var payerGroup = document.getElementById('payerGroup').value;
    var payer = document.getElementById('payer').value;
    var policy = document.getElementById('policy').value;
    var mode = document.getElementById('mode').value;
    var startDate = document.getElementById("effFrom_" + obj).value;
    var endDate = document.getElementById("effTo_" + obj).value;

    var encEpsd = document.getElementById("episode_" + obj).value;
    var gender = document.getElementById("gender_" + obj).value;
    var ageGroup = document.getElementById("hdn_age_group_" + obj).value;
    var clinicNursInd = document.getElementById("clinic_" + obj).value;
    var clinicNursCode = document.getElementById("clinic_code_" + obj).value;
    var spltyCode = document.getElementById("spec_code_" + obj).value;

    // alert(val);
    var dialogUrl = "../../eBL/jsp/PolicyDetailsPreApprovalPopupFrame.jsp?title=Service Limit&rowNumber=" +
        obj +
        "&criteria=" +
        val +
        "&patClass=" +
        patClass +
        "&blngCode=" +
        blngCode +
        "&payerGroup=" +
        payerGroup +
        "&payer=" +
        payer +
        "&policy=" +
        policy +
        "&mode=" +
        mode +
        "&startDate=" +
        startDate +
        "&endDate=" +
        endDate +
        "&encEpsd=" +
        encEpsd +
        "&gender=" +
        gender +
        "&ageGroup=" +
        ageGroup +
        "&clinicNursInd=" +
        clinicNursInd +
        "&clinicNursCode=" +
        clinicNursCode +
        "&spltyCode=" + spltyCode;
    // pArgumentArray[9] = title;

    // var dialogArguments = pArgumentArray ;
    var dialogFeatures = "dialogHeight:" + "20" + "; dialogWidth:" + "75" +
        " ; scroll=auto; ";

    var returnVal =await window.showModalDialog(dialogUrl, null, dialogFeatures);
}

function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }

}

function showToolTip(obj) {
    var tab_dat = "<table id='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='contextMenu' width='100%' " +
        "height='100%' align='center'><tr><td class = 'contextMenuItem' nowrap>" +
        obj + "</td> </tr></table>";
    document.getElementById('menu_table').innerHTML = tab_dat;
    resizeWindow();
}

function hideToolTip() {
    document.getElementById('tooltiplayer').style.visibility = 'hidden';
}

function resizeWindow() {
    // alert();
    bodwidth = document.body.offsetWidth
    bodheight = document.body.offsetHeight
    var x = event.x;
    var y = event.y;

    x = x + (document.getElementById('tooltiplayer').offsetWidth)
    y = y + (document.getElementById('tooltiplayer').offsetHeight)

    if (x < bodwidth)
        x = event.x
    else
        x = x - (document.getElementById('tooltiplayer').offsetWidth * 2)

    if (y < bodheight || event.y < 30) {
        y = event.y

    } else if (y > bodheight && event.y < 100) {
        if (event.y > 60 && event.y < 100) {
            y = event.y - 20
        } else if (y > bodheight && event.y < 200) {} else if (event.y > 100 && event.y < 120) {
            y = 80
        } else if (event.y > 120 && event.y < 140) {
            y = 100
        } else if (event.y > 140 && event.y < 160) {
            y = 120
        } else if (event.y > 160 && event.y < 180) {
            y = 140
        } else if (event.y > 180 && event.y < 200) {
            y = 160
        } else if (event.y > 180 && event.y < 200) {
            y = 160
        } else {
            y = event.y
        }
    } else if (y < bodheight || event.y > 320) {
        y = y - (document.getElementById('tooltiplayer').offsetHeight * 2)
    } else {
        y = y - (document.getElementById('tooltiplayer').offsetHeight * 2)
    }
    if (y < 0)
        y = 0;
    y += document.body.scrollTop
    x += document.body.scrollLeft

    // y=18;

    document.getElementById('tooltiplayer').style.posLeft = x
    document.getElementById('tooltiplayer').style.posTop = y
    document.getElementById('tooltiplayer').style.visibility = 'visible'
}
// Policy Details Incl Excl

// Search tro Code

async function callBGDescCode(sqlSelect, drop, obj, code, obj1) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
   
    var page_info=document.getElementById('pageInfo').value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
    // alert(sqlSelect);
    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                // alert(cn);
                if (cn == 'C') {
                    sql = "Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '" +
                        locale +
                        "' AND FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic';
                } else if (cn == 'N') {
                    sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='" +
                        locale +
                        "' AND  FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Nursing Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' description,'**' code From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Nursing Unit';
                }

                break;
            }

        case 2:
            {
                var criteria = drop.value;
                if (criteria == 'S') {
                    sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Services';
                } else if (criteria == 'BSG') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Service Group';
                } else if (criteria == 'BSGC') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Classification';
                } else if (criteria == 'ESG') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group';
                } else if (criteria == 'ESGL') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group Line';
                } else if (criteria == 'PG') {
                    sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
                    title = 'Package Group';
                } else if (criteria == 'M') {
                    sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Material Item';
                } else if (criteria == 'T') {
                    sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Sale Category';
                } else if (criteria == 'P') {
                    sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') AND OPERATING_FACILITY_ID = '" +
                        facility_id +
                        "' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Package';
                }

                break;
            }

    }

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "1,2";
    argumentArray[5] = code.value;
    argumentArray[6] = CODE_LINK;
    argumentArray[7] = DESC_CODE;

    /*
     * if(!(sqlSelect == '1' && drop.value == 'A')){ returnedValues =
     * CommonLookup(title, argumentArray ); } else{ returnedValues = new
     * Array(); returnedValues[0] = '**' returnedValues[1] = 'All Clinic/
     * Nursing Unit'; }
     */
    returnedValues =await  CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        if (sqlSelect == '1' && drop.value == 'A') {
            obj.value = 'All Clinic/ Nursing Unit';
            code.value = '**';
        } else {
            obj.value = '';
            code.value = '';
        }

    }
	if(page_info=='inclExclCoverage'){
	 var SiteSpec = document.getElementById('SiteSpecific').value;
	if(criteria == 'P' && SiteSpec =='Y'){

        var policyParam = 'calledFrom=policyDefn' +
            '&type=PKG' +
            '&service_code=' + code.value;

		var inclhomemedi = document.getElementById('inclhomeMedi_'+obj1);

        $.ajax({
            type: "GET",
            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
            data: policyParam,
            dataType: "json",
            async: false,
            success: function(data) {

            	validCheck=data.includeHomeMedicationAllYN;
					if(data.includeHomeMedicationAllYN=='Y')
					{
                    validate(obj1);
					}
					else
						{
                    inclhomemedi.disabled = true;
                }

            },
            error: function(data) {
                alert(data)
            }
        });
        
        if(validCheck!='Y'){
    	
    	var inclhomemedi = document.getElementById('inclhomeMedi_'+obj1);
    	inclhomemedi.checked = false;
    	inclhomemedi.disabled = 'disabled';
    	}

    }

}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	if(page_info=='preApproval'){
		 var Site_PreappDur = document.getElementById('Site_PreappDur').value;
		 var rowCount = document.getElementById('inclRowCount').value;
		if((criteria == 'PG' || criteria == 'T' || criteria == 'M' ) &&  Site_PreappDur =='Y'){

	        var policyParam = 'calledFrom=preApproval' +
	            '&type=' +criteria+
	            '&service_code=' + code.value;

			var preAppDur = document.getElementById('preAppDur_'+obj1);

	        $.ajax({
	            type: "GET",
	            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
	            data: policyParam,
	            dataType: "json",
	            async: false,
	            success: function(data) {

	            	validCheck=data.preappDurCapping;
						if(data.preappDurCapping=='Y')
						{
	                   // validate(obj1);
							preAppDur.disabled = false;
						}
						else
							{
							preAppDur.disabled = true;
	                }

	            },
	            error: function(data) {
	                alert(data)
	            }
	        });
	        
	       

	    }

	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
}
/* V221118
function callCommonValidationSpecCode(obj, code, clinicNurs, clinicCode) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var sqlSelect = '';
    var clinicVal = clinicCode.value;
    if (clinicNurs.value == 'C') {
        if (clinicVal != '**') {
            sqlSelect = 1;
        } else {
            sqlSelect = 3;
        }

    } else if (clinicNurs.value == 'N') {
        if (clinicVal != '**') {
            sqlSelect = 2;
        } else {
            sqlSelect = 3;
        }

    } else {
        sqlSelect = 3;
    }

    switch (sqlSelect) {

        case 1:
            {
                sql = "Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' " +
                " and speciality_code in (select speciality_code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '" +
                locale +
                "' AND FACILITY_ID = '" +
                facility_id +
                "' AND NVL(EFF_STATUS,'D') = 'E' and clinic_code = '" +
                clinicVal +
                "') " +
                " Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
                title = 'Speciality';
                break;
            }

        case 2:
            {
                sql = "Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' " +
                " and speciality_code in (select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY WHERE  FACILITY_ID = '" +
                facility_id +
                "' and NURSING_UNIT_CODE = '" +
                clinicVal +
                "') " +
                " Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                title = 'Speciality';
                break;
            }

        case 3:
            {
                sql = "Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "'  Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                title = 'Speciality';
                break;
            }

    }

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "1,2";
    argumentArray[5] = code.value;
    argumentArray[6] = CODE_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        obj.value = '';
        code.value = '';
    }

}
*/
function fnClearCode(obj,index){
var page_info=document.getElementById('pageInfo').value;
if(page_info=='inclExclCoverage'){
	var criteria = document.getElementById('incExCriteria_'+index).value;
	 var SiteSpec = document.getElementById('SiteSpecific').value;
	if(criteria=='P' && SiteSpec =='Y'){
	var inclhomemedi = document.getElementById('inclhomeMedi_'+index);
	inclhomemedi.checked = false;
	inclhomemedi.disabled = 'disabled';
	}
	}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
//var Site_PreappDur=document.getElementById('Site_PreappDur').value;
//Modified against NMC-JD-CRF-0045--14-08-2020
var Site_PreappDur="";
if(page_info=='preApproval'){
	Site_PreappDur=document.getElementById('Site_PreappDur').value;
}else{
	Site_PreappDur='';
}
if(page_info=='preApproval' && Site_PreappDur=='Y'){
	var rowCount = document.getElementById('inclRowCount').value;
	var criteria = document.getElementById('type_'+index).value;
	 var Site_PreappDur = document.getElementById('Site_PreappDur').value;
	 if ((criteria == 'PG' || criteria == 'M' || criteria == 'T')&& Site_PreappDur=='Y' ) {
	
		 var preAppDur = document.getElementById('preAppDur_' + index);
		 preAppDur.value = '';
	preAppDur.disabled = 'disabled';
	}
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
    obj.value = '';
}
// Search tro Code

// Lookup for Billing Service Popup
async function callBlngServPopup(sqlSelect, drop, obj, code) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';

    var criteria = drop.value;
    var parent = document.forms[0].criteria.value;
    var parent_blng_code = document.forms[0].blngCode.value;

    if (parent == 'BSG') {
        if (criteria == 'BSGC') {
            sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE upper(substr(serv_classification_code,1,2)) = upper('" +
                parent_blng_code +
                "') and upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Classification';
        } else if (criteria == 'S') {
            sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,2)) = upper('" +
                parent_blng_code +
                "') and upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Services';
        } else if (criteria == 'M') {
            sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Material Item';
        } else if (criteria == 'PG') {
            sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr  where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
            title = 'Package Group';
        }
    } else if (parent == 'BSGC') {
        if (criteria == 'S') {
            sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,4)) = upper('" +
                parent_blng_code +
                "') and upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Services';
        }
    } else if (parent == 'PG') {
        if (criteria == 'BSG') {
            sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Service Group';
        } else if (criteria == 'BSGC') {
            sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Classification';
        } else if (criteria == 'S') {
            sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Billing Services';
        } else if (criteria == 'M') {
            sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Material Item';
        } else if (criteria == 'T') {
            sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Sale Category';
        } else if (criteria == 'ESG') {
            sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Enterprise Service Group';
        } else if (criteria == 'ESGL') {
            sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Enterprise Service Group Line';
        }
    } else if (parent == 'T') {
        if (criteria == 'M') {
            sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Material Item';
        }
    } else if (parent == 'ESG') {
        if (criteria == 'ESGL') {
            sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                locale +
                "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
            title = 'Enterprise Service Group Line';
        }
    }

    /*
     * if(criteria == 'S'){ sql = "Select description, code from (select
     * short_desc description,blng_serv_code code from bl_blng_serv_lang_vw
     * where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"')
     * Union Select 'All Billing Services','**' From Dual ) where
     * upper(description) like upper(?) and upper(code) like upper(?) order by
     * 2"; title = 'Billing Services'; } else if(criteria == 'BSG'){ sql =
     * "Select description, code from (SELECT short_desc
     * description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE
     * upper(language_id) = upper('"+locale+"') Union Select 'All Billing
     * Services','**' From Dual ) where upper(description) like upper(?) and
     * upper(code) like upper(?) order by 2"; title = 'Billing Service Group'; }
     * else if(criteria == 'BSGC'){ sql = "Select description, code from (SELECT
     * short_desc description,SERV_CLASSIFICATION_CODE CODE FROM
     * BL_SERV_CLASSIFICATION_LANG_VW WHERE upper(language_id) =
     * upper('"+locale+"') Union Select 'All Billing Services','**' From Dual )
     * where upper(description) like upper(?) and upper(code) like upper(?)
     * order by 2"; title = 'Billing Classification'; } else if(criteria ==
     * 'ESG'){ sql = "Select description, code from (SELECT short_desc
     * description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE
     * upper(language_id) = upper('"+locale+"') Union Select 'All Billing
     * Services','**' From Dual ) where upper(description) like upper(?) and
     * upper(code) like upper(?) order by 2"; title = 'Enterprise Service
     * Group'; } else if(criteria == 'ESGL'){ sql = "Select description, code
     * from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE
     * CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) =
     * upper('"+locale+"') Union Select 'All Billing Services','**' From Dual )
     * where upper(description) like upper(?) and upper(code) like upper(?)
     * order by 2"; title = 'Enterprise Service Group Line'; }
     * 
     * else if(criteria == 'PG'){ sql = "Select description, code from (select
     * short_desc description,package_serv_group_code CODE from
     * bl_package_serv_group_hdr Union Select 'All Billing Services','**' From
     * Dual ) where upper(description) like upper(?) and upper(code) like
     * upper(?) order by 2"; title = 'Package Group'; } else if(criteria ==
     * 'M'){ sql = "Select description, code from (SELECT short_desc
     * description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) =
     * upper('"+locale+"') Union Select 'All Billing Services','**' From Dual )
     * where upper(description) like upper(?) and upper(code) like upper(?)
     * order by 2"; title = 'Material Item'; } else if(criteria == 'T'){ sql =
     * "Select description, code from (select short_desc
     * description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union
     * Select 'All Billing Services','**' From Dual ) where upper(description)
     * like upper(?) and upper(code) like upper(?) order by 2"; title = 'Sale
     * Category'; }
     */

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    if (sqlSelect == '1') {
        argumentArray[4] = "1,2";
        argumentArray[5] = code.value;
    } else if (sqlSelect == '2') {
        argumentArray[4] = "2,1";
        argumentArray[5] = obj.value;
    }

    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        obj.value = '';
        code.value = '';
    }

}
// Lookup for Billing Service Popup
function resizeFrames() {
    document.getElementById('resizeLink').style.visibility = 'hidden';
    document.getElementById('resizeBtn').style.visibility = 'hidden';
    document.getElementById('resetLink').style.visibility = 'visible';
    document.getElementById('resetBtn').style.visibility = 'visible';
    //parent.document.getElementById('ContainerFrame').rows = "28%,0%,5%,61%,6%";
    // parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="100%,0%,0%";
	parent.document.getElementById("PolicyInfoFrame").style.height="31vh";
	parent.document.getElementById("PolicyCoverageMain").style.height="39vh";
	parent.document.getElementById("PolicyDetailsTab").style.height="8vh";
	parent.document.getElementById("PolicyDetailsPage").style.height="45vh";
	parent.document.getElementById("PolicyDetailsAdd").style.height="10vh";
}

function resetFrames() {
    document.getElementById('resizeLink').style.visibility = 'visible';
    document.getElementById('resizeBtn').style.visibility = 'visible';
    document.getElementById('resetLink').style.visibility = 'hidden';
    document.getElementById('resetBtn').style.visibility = 'hidden';
    //parent.document.getElementById('ContainerFrame').rows = "31%,39%,5%,19%,6%";
    // parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";
	parent.document.getElementById("PolicyInfoFrame").style.height="31vh";
	parent.document.getElementById("PolicyCoverageMain").style.height="39vh";
	parent.document.getElementById("PolicyDetailsTab").style.height="8vh";
	parent.document.getElementById("PolicyDetailsPage").style.height="19vh";
	parent.document.getElementById("PolicyDetailsAdd").style.height="10vh";
	 
		 

}

// Lookup related fns
async function fnShowPolicyDetailReport() {

    var frm = parent.PolicyDetailsPage.document.forms[0];
    var auth = '';
    var mode = 'modify';
    var payerGroup = frm.payerGroup.value;
    var payer = frm.payer.value;
    var policy = frm.policy.value;
    var facility_id = frm.facility_id.value;
    var endDate = frm.endDate.value;
    var startDate = frm.startDate.value;
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'inclExclCoverage') {
        auth = document.forms[0].auth.value;
        getXMLString('inclExclCoverage');

        var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?" +
            "title=Include Exclude Details" +
            "&source=PolicyInclExclLookup" + "&startDate=" + startDate +
            "&endDate=" + endDate + "&mode=modify" + "&payergroupCode=" +
            payerGroup + "&payerCode=" + payer + "&policyCode=" + policy;

        var dialogFeatures = "dialogHeight:" + "900vh" + "; dialogWidth:" + "800vw" +
            " ; scroll=auto; ";

       await window.showModalDialog(dialogUrl, 'Policy Details', dialogFeatures);

        parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/PolicyDetailsInclExcl.jsp?mode=' +
            mode +
            '&payergroupCode=' +
            payerGroup +
            '&payerCode=' +
            payer +
            '&policyCode=' +
            policy +
            '&startDate=' +
            startDate +
            '&endDate=' +
            endDate +
            '&facility_id=' +
            facility_id +
            '&auth=' + auth;
    } else if (pageInfo == 'preApproval') {
        auth = document.forms[0].auth.value;
        getXMLString('preApproval');

        var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?" +
            "title=Pre Approval Details" +
            "&source=PolicyPreapprovalLookup" + "&startDate=" + startDate +
            "&endDate=" + endDate + "&mode=modify" + "&payergroupCode=" +
            payerGroup + "&payerCode=" + payer + "&policyCode=" + policy

        var dialogFeatures = "dialogHeight:" + "900vh" + "; dialogWidth:" + "800vw" +
            " ; scroll=auto; ";
       await window.showModalDialog(dialogUrl, 'Policy Details', dialogFeatures);
        parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/PolicyDetailsPreApproval.jsp?mode=' +
            mode +
            '&payergroupCode=' +
            payerGroup +
            '&payerCode=' +
            payer +
            '&policyCode=' +
            policy +
            '&startDate=' +
            startDate +
            '&endDate=' +
            endDate +
            '&facility_id=' +
            facility_id +
            '&auth=' + auth;
    } else if (pageInfo == 'PreApprovalPopup') {
        getXMLString('PreApprovalPopup');
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

        var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?" +
            "title=Service Limit Details" +
            "&source=PolicyServiceLmtLookup" + "&startDate=" +
            startDate +
            "&endDate=" +
            endDate +
            "&mode=modify" +
            "&payerGroup=" +
            payerGroup +
            "&payer=" +
            payer +
            "&policy=" +
            policy +

            "&patClass=" +
            patClass +
            "&encEpsd=" +
            encEpsd +
            "&gender=" +
            gender +
            "&ageGroup=" +
            ageGroup +
            "&clinicNursInd=" +
            clinicNursInd +
            "&clinicNursCode=" +
            clinicNursCode +
            "&spltyCode=" +
            spltyCode +
            "&criteria=" +
            criteria +
            "&blngCode=" + blngCode + "&rowNumber=" + rowNumber;

        var dialogFeatures = "dialogHeight:" + "900vh" + "; dialogWidth:" + "800vw" +
            " ; scroll=auto; ";
       await window.showModalDialog(dialogUrl, 'Policy Details', dialogFeatures);
        parent.PolicyDetailsPage.document.location.href = "../../eBL/jsp/PolicyDetailsPreApprovalPopup.jsp?title=Service&rowNumber=" +
            rowNumber +
            "&criteria=" +
            criteria +
            "&patClass=" +
            patClass +
            "&blngCode=" +
            blngCode +
            "&payerGroup=" +
            payerGroup +
            "&payer=" +
            payer +
            "&policy=" +
            policy +
            "&mode=" +
            mode +
            "&startDate=" +
            startDate +
            "&endDate=" +
            endDate +
            '&facility_id=' +
            facility_id +
            "&encEpsd=" +
            encEpsd +
            "&gender=" +
            gender +
            "&ageGroup=" +
            ageGroup +
            "&clinicNursInd=" +
            clinicNursInd +
            "&clinicNursCode=" +
            clinicNursCode + "&spltyCode=" + spltyCode + '&auth=' + auth;

    }

}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
function zeroCheck(obj){
	var Site_PreappDur=document.getElementById('Site_PreappDur').value;
  if(Site_PreappDur =='Y'){
	var rowCount = document.getElementById('inclRowCount').value;
	 var preAppDur = document.getElementById('preAppDur_' + rowCount);
	 var varray;
	  
	  
	
	 varray=obj.value/1;
	
	  if(varray>0){
		  
		
		  return true;
	  }
	  else{
		 
		  preAppDur.value='';
	
		  
	  }
	
	
	}
	
}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
function fnLoadSelectedCoverage(epsdEnc, patClass, ageGrp, gender, clinicNurs,
    clinicNursCode, specCode, criteria, billServCode, startDate, funcMode) {

    var mode = document.forms[0].mode.value;
    var payerGroup = document.forms[0].payerGroup.value;
    var payer = document.forms[0].payer.value;
    var policy = document.forms[0].policy.value;
    var facility_id = document.forms[0].facility_id.value;

    var temp_jsp = "../../eBL/jsp/PolicyDefinitionPersistence.jsp?func_mode=" +
        funcMode + '&mode=' + mode + '&payergroupCode=' + payerGroup +
        '&payerCode=' + payer + '&policyCode=' + policy +

        '&facility_id=' + facility_id + '&epsdEnc=' + epsdEnc +
        '&patClass=' + patClass + '&ageGrp=' + ageGrp + '&gender=' +
        gender + '&clinicNurs=' + clinicNurs + '&clinicNursCode=' +
        clinicNursCode + '&specCode=' + specCode + '&criteria=' +
        criteria + '&billServCode=' + billServCode + '&startDate=' +
        startDate;
    // alert(temp_jsp)
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = "<root><SEARCH ";
    xmlStr += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = trimString(xmlHttp.responseText);
    if (responseText == 'No') {
        alert('Record already added');
        return false;
    } else {
        window.close();
    }

}

function fnLoadSelectedCoveragePopup(criteriaPop, billServCodePop, startDatePop) {

    var rowNumber = document.forms[0].rowNumber.value;
    var criteria = document.forms[0].criteria.value;
    var startDate = document.forms[0].startDate.value;
    var endDate = document.forms[0].endDate.value;
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
    var spltyCode = document.forms[0].spltyCode.value;

    var temp_jsp = "../../eBL/jsp/PolicyDefinitionPersistence.jsp?func_mode=" +
        "preApprovalPopupLookup" + '&mode=' +
        mode +
        '&payergroupCode=' +
        payerGroup +
        '&payerCode=' +
        payer +
        '&policyCode=' +
        policy +

        '&epsdEnc=' +
        encEpsd +
        '&patClass=' +
        patClass +
        '&ageGrp=' +
        ageGroup +
        '&gender=' +
        gender +
        '&clinicNurs=' +
        clinicNursInd +
        '&clinicNursCode=' +
        clinicNursCode +
        '&specCode=' +
        spltyCode +
        '&criteria=' +
        criteria +
        '&billServCode=' +
        blngCode +
        '&startDate=' +
        startDate +

        '&rowNumber=' +
        rowNumber +
        '&criteriaPop=' +
        criteriaPop +
        '&billServCodePop=' +
        billServCodePop +
        '&startDatePop=' +
        startDatePop;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = "<root><SEARCH ";
    xmlStr += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = trimString(xmlHttp.responseText);
    if (responseText == 'No') {
        alert('Record already added');
        return false;
    } else {
        window.close();
    }

}

function getXMLString(last_link) {
	//alert("1");
    if (last_link == "Outpatient") {
//alert("2");
        var frmObj = parent.ServiceCoverageTabDetails.document.forms[0];
	//	alert("frmObj vale :"+frmObj);

        var xmlString = formXMLStringMain(frmObj);
	//	alert("xmlString"+xmlString);
        var updation = formValidation(xmlString, "Outpatient");
		//alert("updation"+updation);
//alert("2o");
    } else if (last_link == "Inpatient") {
		//alert("3");
        var frmObj = parent.ServiceCoverageTabDetails.document.forms[0];

        var xmlString = formXMLStringMain(frmObj);
        var updation = formValidation(xmlString, "Inpatient");

    } else if (last_link == "External") {
		//alert("4");
        var frmObj = parent.ServiceCoverageTabDetails.document.forms[0];

        var xmlString = formXMLStringMain(frmObj);
        var updation = formValidation(xmlString, "External");
    } else if (last_link == "inclExclCoverage") {
		//alert("5");
        var frmObj = parent.PolicyDetailsPage.document.forms[0];

        var xmlString = formXMLStringMain(frmObj);
        // alert(xmlString)
        var updation = formValidation(xmlString, "inclExclCoverage");
    } else if (last_link == "preApproval") {
		//alert("6");
        var frmObj = parent.PolicyDetailsPage.document.forms[0];

        var xmlString = formXMLStringMain(frmObj);
        // alert(xmlString)
        var updation = formValidation(xmlString, "preApproval");
    } else if (last_link == "PreApprovalPopup") {
		//alert("7");
        var frmObj = parent.PolicyDetailsPage.document.forms[0];

        var xmlString = formXMLStringMain(frmObj);
        // alert(xmlString)
        var updation = formValidation(xmlString, "popup");
    }

    var excln_form = "";
	//alert("8");

}
// Lookup related fns

/* Added V181005-Aravindh/AAKH-CRF-0107/Starts */
function unCheckAllLineLvlRefChkBox() {
	var formObj = parent.PolicyDetailsPage;
	var inclRowCount = formObj.document.getElementById("inclRowCount").value;
	if(!(parent.PolicyInfoFrame.document.getElementById("coverRefPriceHdr").checked)) {
		for(var i = 1; i<= inclRowCount; i++) {
			formObj.document.getElementById("coverRefPrice_"+i).checked = false;
		}
	}
}
/* Added V181005-Aravindh/AAKH-CRF-0107/Ends */
/* Added V190517-Aravindh/NMC-JD-CRF-0010/Starts */
function doUserAuthenticationValidationPayerApprove(successfulUser) {
	var frmObj = document.forms[0];
	//var successfulUser = frmObj.successfulUser;
	var payerCode = frmObj.payerCode2;
	var payer = frmObj.payerCode;
	var policy = frmObj.policyTypeCode;
	
    var temp_jsp = "../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=POLICY_DEFN_APPROVE";
    if (successfulUser != undefined && successfulUser != 'undefined' && successfulUser != null && successfulUser != "") {
        temp_jsp += "&successfulUser=" + successfulUser;
    }
    if (payerCode != undefined && payerCode != null) {
        temp_jsp += "&payerCode=" + payerCode.value;
    }
    if (payer != undefined && payer != null) {
        temp_jsp += "&payer=" + payer.value;
    }
    if (policy != undefined && policy != null) {
        temp_jsp += "&policy=" + policy.value;
    }
    
    var xmlString = formXMLStringMain(frmObj);
    var updation = formPayerValidation(xmlString, temp_jsp);
    if(updation == true) {
    	document.forms[0].validUserApprvUnApprv.value = "true";
    } else {
    	document.forms[0].validUserApprvUnApprv.value = "false";
    }
}

function changePolicyApprovalStatus(obj) {
	var formObj = document.forms[0];
	var validUserApprvUnApprv = formObj.validUserApprvUnApprv.value;
	var payerCode = formObj.payerCode2.value;
	var payer = formObj.payerCode.value;
	var policy = formObj.policyTypeCode.value;
	
	if(payerCode.length > 0 && payer.length > 0 && policy.length > 0) {
		if(validUserApprvUnApprv != "true") {
			obj.checked = !obj.checked;
			alert(getMessage('BL0838', 'BL'));
		}
	} else {
		obj.checked  = false;
	}
}
/* Added V190517-Aravindh/NMC-JD-CRF-0010/Ends */
/* Added V190704 MuthuN/NMC-JD-CRF-0002.1 */
function claimAgreeReqYN(){
	var payerGrpCode = document.forms[0].payerCode2.value;
	var payerCode = document.forms[0].payerCode.value;
	var policyTypeCode = document.forms[0].policyTypeCode.value;
	var facility_id = document.forms[0].facility_id.value;
	//if (payerGrpCode.length > 0) {		
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ClaimAgreeReqYN&payerGrpCode="+payerGrpCode
					+ "&payerCode="+payerCode+"&policyTypeCode="+policyTypeCode+"&facility_id="+facility_id;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	
	var retVal = trimString(xmlHttp.responseText);
	
	if (retVal == 'Y'){
		document.forms[0].ClaimsAgrmtExts.checked = true;
	} else {			
		document.forms[0].ClaimsAgrmtExts.checked = false;
	}
	//}	
}
/* Added V190704 MuthuN/NMC-JD-CRF-0002.1 */
/* Added V191021-Aravindh/NMC-JD-CRF-0010.2/closeWindow */
function closeWindow() {
	window.returnValue=1;
	window.close();
}

//NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->
var remarks = "";
async function Remarks(){	
    var remarkHdr = "";
    var mode=document.getElementById("mode").value;
    var payerGroup=document.getElementById("payerGroup").value;
    var payer=document.getElementById("payer").value;
    var policy=document.getElementById("policy").value;
	
    if(document.getElementById("remarks").value != "null" &&  document.getElementById("remarks").value != "" && remarks == ""){
    	remarkHdr = document.getElementById("remarks").value;
    }

    if(remarks != null || remarks == undefined)
    {
    	if(remarkHdr != ""){
    	 remarks = remarkHdr;
    	}
    	else{
    	 remarkHdr = remarks;
    	}
    }else{
    	remarkHdr = "";
    }

    var dialogUrl1 = "../../eBL/jsp/BLRemarks.jsp?patview=N&remarkHdr="+encodeURIComponent(remarkHdr)+"&mode="+mode+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy;
    var dialogArguments = remarks;
    var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
    returnRemarks =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
    if(returnRemarks != null){
    	remarks = returnRemarks;
    	document.getElementById('blremarks').value = remarks;
    }
    if(returnRemarks == undefined){
    	returnRemarks = dialogArguments;
    }
}

/*function textAreaLimit1(field, maxlen) {
	if (field.value.length > maxlen + 1)
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}*/
//ADDED AGAINST INC 73090  5/29/2020
	function textAreaLimit1(field, maxlen) {
	if (field.value.length > maxlen + 1)
	if (field.value.length > maxlen)
  {
	  field.value = field.value.substring(0, maxlen);
    alert(getMessage("BL0908","BL"));//01-06-2020 MuthuN
  }
}

function restrictSpecialChars(event){
	//var strCheck = '~!@#$%^&*()+=`{}|[];:_-,?<>"\'';
	var strCheck = '*.~!@$^*()+=`{}|[];:_-,/\\?<>"\'';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) != -1) 
	{
		window.event.keyCode = 27;
		return false;  
	}
	return true;
}

function getRemarks(val) {
	if(val == ""){
		alert(getMessage("DS_REM_NOT_BLANK","DS")); 
		document.getElementById('REMARKS').focus();
	}else{
		remarks = val;
		document.getElementById("remarks").value = remarks;
		window.returnValue = remarks;
		window.close();
	}
}

function clearTextArea()
{
	document.getElementById("remarks").value = "";
}
//NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends --->

function chkBlremarks() {
  var mainfrmObj =PolicyDefinitionMainFrame.PolicyInfoFrame.frmPolicyInfo;
  var mode=mainfrmObj.document.getElementById("mode").value;
  //alert("mode"+mode);
  var payerGroup = mainfrmObj.document.getElementById("payerGroup").value;
  //alert("payerGroup"+payerGroup);
  var payer = mainfrmObj.document.getElementById("payer").value;
  //alert("payer"+payer);
  var policy = mainfrmObj.document.getElementById("policy").value;
 // alert("policy"+policy);
	
  var xmlStr = "<root><SEARCH ";
  xmlStr += " /></root>";
  var xmlDoc="";
  var xmlHttp = new XMLHttpRequest();
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
  xmlHttp.open("POST", "../jsp/BLCommonAjax.jsp?functionMode=chk_Bl_Remarks&mode="+mode+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy, false);
  xmlHttp.send(xmlDoc);
  var status = trimString(xmlHttp.responseText);
  return (status);	
}

// MOHE-CRF-0114 Changes by Manivel N

function chkDiagBasedCopayYN(indx) {
    var chk = 'chkDiagBasedCopayYN_' + indx;
    var obj = 'diagBasedCopayLink_' + indx;
    var serv = "incExCriteria_" + indx;
    var blng_code = 'bg_code_' + indx;
    var val = document.getElementById(serv).value;
    var chkBox = document.getElementById(chk);
    var link = document.getElementById(obj);
    var blng_code_val = document.getElementById(blng_code).value;
    if (chkBox.checked) {
        if (!(val == 'BSG' || val == 'BSGC' || val == 'ESG' || val == 'T' || val == 'PG')) {
            alert(getMessage("BL9134", "BL"));
            link.style.visibility = 'hidden';
            chkBox.checked = false;
        } else {
            if (blng_code_val.length > 0) {
                link.style.visibility = 'visible';
            } else {
                alert('Enter Billing Service details');
                link.style.visibility = 'hidden';
                chkBox.checked = false;
            }
        }

    } else {
        link.style.visibility = 'hidden';
    }	
}

async function openDiagBasedCopay(obj) {
    var serv = "incExCriteria_" + obj;
    var val = document.getElementById(serv).value;
    var patClass = document.getElementById("ptClass_" + obj).value;
    var blngCode = document.getElementById("bg_code_" + obj).value;
    var payerGroup = document.getElementById('payerGroup').value;
    var payer = document.getElementById('payer').value;
    var policy = document.getElementById('policy').value;
    var mode = document.getElementById('mode').value;
    var startDate = document.getElementById("effFrom_" + obj).value;
    var endDate = document.getElementById("effTo_" + obj).value;

    var encEpsd = document.getElementById("episode_" + obj).value;
    var gender = document.getElementById("gender_" + obj).value;
    var ageGroup = document.getElementById("hdn_age_group_" + obj).value;
    var clinicNursInd = document.getElementById("clinic_" + obj).value;
    var clinicNursCode = document.getElementById("clinic_code_" + obj).value;
    var spltyCode = document.getElementById("spec_code_" + obj).value;
	var title = getLabel("Common.DiagnosisType.label","common");
	
    var rowNumber = document.getElementById("rowNumber" + obj).value;

	var criteriaPop = "";
	var startDatePop = "";

    var temp_jsp = "../../eBL/jsp/PolicyDefinitionPersistence.jsp?func_mode=" +
        "diagCopayPopupLoad" + '&mode=' +
        mode +
        '&payergroupCode=' +
        payerGroup +
        '&payerCode=' +
        payer +
        '&policyCode=' +
        policy +

        '&epsdEnc=' +
        encEpsd +
        '&patClass=' +
        patClass +
        '&ageGrp=' +
        ageGroup +
        '&gender=' +
        gender +
        '&clinicNurs=' +
        clinicNursInd +
        '&clinicNursCode=' +
        clinicNursCode +
        '&specCode=' +
        spltyCode +
        '&criteria=' +
        val +
        '&billServCode=' +
        blngCode +
        '&startDate=' +
        startDate +
        '&rowNumber=' +
        rowNumber +
        '&criteriaPop=' +
        criteriaPop +
        '&billServCodePop=' +
        blngCode +
        '&startDatePop=' +
        startDatePop;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = "<root><SEARCH ";
    xmlStr += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = trimString(xmlHttp.responseText);

    if (responseText == 'No') {
        alert('Record already added');
        return false;
    } else {
        window.close();
    }	

    var dialogUrl = "../../eBL/jsp/PolicyDetailsDiagCopayPopupFrame.jsp?title="+title+"&rowNumber=" +
        obj +
        "&criteria=" +
        val +
        "&patClass=" +
        patClass +
        "&blngCode=" +
        blngCode +
        "&payerGroup=" +
        payerGroup +
        "&payer=" +
        payer +
        "&policy=" +
        policy +
        "&mode=" +
        mode +
        "&startDate=" +
        startDate +
        "&endDate=" +
        endDate +
        "&encEpsd=" +
        encEpsd +
        "&gender=" +
        gender +
        "&ageGroup=" +
        ageGroup +
        "&clinicNursInd=" +
        clinicNursInd +
        "&clinicNursCode=" +
        clinicNursCode +
        "&spltyCode=" + spltyCode;

    var dialogFeatures = "dialogHeight:" + "20" + "; dialogWidth:" + "50" +
        " ; scroll=auto; ";

    var returnVal = await window.showModalDialog(dialogUrl, null, dialogFeatures);
}

function addRowDiag() {
    var frm = parent.PolicyDetailsDiagCopayPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'DiagCopayPopup') {
        addRow('DiagCopayPopup')
    }
    // alert(pageInfo);
}

function removeRowDiagClose() {
    var frm = parent.PolicyDetailsDiagCopayPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'PreApprovalPopup') {
        removeRow('PreApprovalPopup')
    } else if(pageInfo == 'DiagCopayPopup') {
        removeRow('DiagCopayPopup')
    }
    // alert(pageInfo);
}

function saveDiagCopay(){
    var frmObj = parent.PolicyDetailsDiagCopayPage.document.forms[0];
	var frmValidation = validateDiagCopayForm(frmObj);
	//frmValidation = false;
	if(frmValidation == true){
		xmlString = formXMLStringMain(frmObj);
		// alert(xmlString);
		updation = formValidation(xmlString, "diagpopup");
		window.close();
	}
}

function validateDiagCopayForm(formObj){
	var totRec = formObj.inclRowCount.value;
	
	for(var i=1;i<=totRec;i++){
		var diagType = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_diagType_'+i).value;
		var diagCopay = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_copay_'+i);
		var diagEffFrom = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_effFrom_'+i);
		var diagEffTo = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_effTo_'+i);
		var copaycheck = checkCopayValue(diagCopay);

		if(copaycheck == true){
			var effFrmDateCheck = checkDiagEffDateFrom(diagEffFrom);

			if(effFrmDateCheck == false)
				return false;
			else{
				var PolicyAndDiagDatesCheck = callPolicyAndDiagDatesCheck(diagEffFrom,diagEffTo);

				if(PolicyAndDiagDatesCheck == false)
					return false;
			}
		} else{
			return false;
		}
	}
	return true;
}

function checkCopayValue(obj){
	if(obj.value != ""){
		if(obj.value < 0 || obj.value > 100){
			alert(getMessage("BL00254","BL"));
			obj.value = "";
			obj.focus();
			return false;
		}
	} else {
		alert(getMessage("BL9901","BL"));
			obj.value = "";
			obj.focus();
			return false;
	}
	return true;
}

function checkDiagEffDateFrom(obj){

	if(obj.value == ""){
		alert(getMessage("BL8504","BL"));
		obj.focus();
		return false;
	}

	return true;
}

function callPolicyAndDiagDatesCheck(diagEffFrom,diagEffTo){
	
	var status_chk = checkDateFromDiag(diagEffFrom);
	
	if(status_chk == true)
		status_chk = checkDateFromDiag(diagEffTo);
	
	if(status_chk == true)
		return true;
	else
		return false;
}

function checkDateFromDiag(obj){
	
	var stdt = parent.PolicyDetailsDiagCopayPage.document.getElementById('startDate').value;
	var endt = parent.PolicyDetailsDiagCopayPage.document.getElementById('endDate').value;
	var startdtarr =stdt.split("/");//alert("startdtarr:"+startdtarr);
	var enddtarr = endt.split("/");//alert("enddtarr:"+enddtarr);
	var objarr = obj.value.split("/");//alert("objarr:"+objarr);
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range "+stdt+" and "+endt);
		obj.value = '';
		obj.focus();
		return false;
	}
	return true;
}


//V221017
function fnCheckMFDREnableDisable(type, obj1, obj2){
	if (type == 'chk') {
		var chkBox = document.getElementById(obj1);
		var dest = document.getElementById(obj2);
		
		if (chkBox.checked) {
				dest.disabled = false;
		}else {
				dest.disabled = true;
				dest.value = '';
		}
	}
}
