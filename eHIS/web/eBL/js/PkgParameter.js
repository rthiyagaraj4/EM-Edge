
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201102            074099         NMC-JD-CRF-0011.1       Muthukumar N
-----------------------------------------------------------------------------------
*/
/*Function to change the status of all field in tha parameter when the package applicable changes  */
function changeAllStatus(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";
		document.forms[0].pkgBkDateD.disabled = false;
		document.forms[0].glSmryYN.disabled = false;
		//document.forms[0].glSmry.disabled = false;
		//document.forms[0].glSmryDesc.disabled = false;
		//document.forms[0].glSmryLookUp.disabled = false;
		document.forms[0].valdDForOrd.disabled = false;
		document.forms[0].unAvaldSrvCode.disabled = false;
		document.forms[0].autoRefundYN.disabled = false;
		document.forms[0].valdRefundD.disabled = false;
	}
	else
	{	
    if(obj.value  == "Y" && document.forms[0].pkgStatusFromTab.value == "Y")
		obj.checked = true;
		else
		{
			obj.value = "N";
			document.forms[0].pkgBkDateD.value			= document.forms[0].prevPkgBkDateD.value;
			document.forms[0].pkgBkDateD.disabled		= true;
			document.forms[0].glSmryYN.value			= document.forms[0].prevGlSmryYN.value;
			document.forms[0].glSmryYN.checked			= false;
			document.forms[0].glSmryYN.disabled			= true;
			//document.forms[0].glSmry.value			= document.forms[0].prevGlSmry.value;
			//document.forms[0].glSmryDesc.value		= document.forms[0].prevGlSmryDesc.value;
			document.forms[0].valdDForOrd.value			= document.forms[0].prevValdDForOrd.value;
			document.forms[0].valdDForOrd.disabled		= true;
			document.forms[0].unAvaldSrvCode.value		= document.forms[0].prevUnAvaldSrvCode.value;
			document.forms[0].unAvaldSrvCode.disabled	= true;
			document.forms[0].autoRefundYN.value		= document.forms[0].prevAutoRefundYN.value;
			document.forms[0].autoRefundYN.checked		= false;
			document.forms[0].autoRefundYN.disabled		= true;
			document.forms[0].valdRefundD.value			= document.forms[0].prevValdRefundD.value;
			document.forms[0].valdRefundD.disabled		= true;
			//document.forms[0].glSmry.disabled			= true;
			//document.forms[0].glSmryDesc.disabled		= true;
			//document.forms[0].glSmryLookUp.disabled	= true;

		}
	}
}

//MMS-QH-CRF-128.1-US001 & US004 Starts
function changeAllStatus_New(obj)
{	
  if(obj.checked)
  	{
  		obj.value = "Y";
  	}
  	else
  	{
  		if(obj.value  == "Y" && document.forms[0].prevpkgCustDiscNewPkgYN.value == "Y")
  		obj.checked = true;
  		else
  		obj.value = "N";
  	}	
}

function changeAllStatus_New1(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";
	}
	else
	{
		if(obj.value  == "Y" && document.forms[0].prevpkgCustDiscByPlcyYN.value == "Y")
		obj.checked = true;
		else
		obj.value = "N";
	}	
}
//MMS-QH-CRF-128.1-US001 & US004 Ends

/*  */
function changeAccontingCode(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";  /*
		document.forms[0].glSmry.disabled = false;
		document.forms[0].glSmryDesc.disabled = false;
		document.forms[0].glSmryLookUp.disabled = false;   */
	}
	else
	{
		obj.value = "N"; 	  /*
		document.forms[0].glSmry.value = "";
		document.forms[0].glSmryDesc.value = "";
		document.forms[0].glSmry.disabled = true;
		document.forms[0].glSmryDesc.disabled = true;
		document.forms[0].glSmryLookUp.disabled = true;	  */
	}
}
/*
function glSmryList()
{
    var locale = document.forms[0].locale.value
	var value = document.forms[0].glSmry.value
	var facilityId = document.forms[0].facilityId.value
	//var sql = "SELECT   acc_int_code code, acc_int_desc description  FROM bl_gl_account_lang_vw WHERE  UPPER (language_id) = UPPER ('"+locale+"')  AND acc_entity_code = (SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_code = '"+facilityId+"') AND NVL (status, 'X') != 'S' and upper(acc_int_code) like upper(?) and upper(acc_int_desc) like upper(?) ";	//lookup
	var sql = "SELECT   a.acc_int_code code, a.acc_int_desc description  FROM bl_gl_account_lang_vw a WHERE  UPPER (a.language_id) = UPPER ('"+locale+"')  AND a.acc_entity_code = (SELECT acc_entity_code FROM sy_acc_entity b WHERE a.acc_entity_code = b.acc_entity_code) AND NVL (a.status, 'X') != 'S' and upper(a.acc_int_code) like upper(?) and upper(a.acc_int_desc) like upper(?) ";	//lookup
	var title=encodeURIComponent(getLabel("eBL.AccountingCode.label","BL"))
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = CommonLookup( title, argArray );
	if(retArray!='undefined' && retArray!=undefined && retArray != null)
	{
		if(retArray[0]+"" != "undefined" && retArray[0]+"" !="")
			document.forms[0].glSmry.value = retArray[0];
		if(retArray[1]+"" != "undefined" && retArray[1]+"" !="")
			document.forms[0].glSmryDesc.value =  retArray[1];
	}

}  */


function chaneckAutoRefund(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";
	}
	else
	{
		obj.value = "N";
	}
} 


function unAvaldSrv()
{
	//lookup
}

/* Apply */
function apply()
{
	var err_mess="";
	var flag = true;
		
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pkgBkDateD.value != parent.frames[2].frames[1].document.forms[0].prevPkgBkDateD.value)	flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].glSmryYN.value != parent.frames[2].frames[1].document.forms[0].prevGlSmryYN.value) flag = false;
	//if(	flag == true && parent.frames[2].frames[1].document.forms[0].glSmry.value != parent.frames[2].frames[1].document.forms[0].prevGlSmry.value) flag = false;
	//if(	flag == true && parent.frames[2].frames[1].document.forms[0].glSmryDesc.value != parent.frames[2].frames[1].document.forms[0].prevGlSmryDesc.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].valdDForOrd.value != parent.frames[2].frames[1].document.forms[0].prevValdDForOrd.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].unAvaldSrvCode.value != parent.frames[2].frames[1].document.forms[0].prevUnAvaldSrvCode.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].autoRefundYN.value != parent.frames[2].frames[1].document.forms[0].prevAutoRefundYN.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].valdRefundD.value != parent.frames[2].frames[1].document.forms[0].prevValdRefundD.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].unAvaldSrvCode.value != parent.frames[2].frames[1].document.forms[0].prevUnAvaldSrvCode.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pat_dep_for_pkg_code.value != parent.frames[2].frames[1].document.forms[0].prevPat_dep_for_pkg_code.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pat_dep_for_pkg_desc.value != parent.frames[2].frames[1].document.forms[0].prevPat_dep_for_pkg_desc.value) flag = false;
	/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Starts */
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pkgServiceLimitBy.value != parent.frames[2].frames[1].document.forms[0].prevPkgServiceLimitBy.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].dailyPkgLimitChk.value != parent.frames[2].frames[1].document.forms[0].prevDailyPkgLimitChk.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].dailyPkgLimitSlct.value != parent.frames[2].frames[1].document.forms[0].prevDailyPkgLimitSlct.value) flag = false;
	/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Ends */

	//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Starts
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pkgCustDiscNewPkgYN.value != parent.frames[2].frames[1].document.forms[0].prevpkgCustDiscNewPkgYN.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].pkgCustDiscByPlcyYN.value != parent.frames[2].frames[1].document.forms[0].prevpkgCustDiscByPlcyYN.value) flag = false;
	//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Ends
  
  //28.08.2020 change  
  //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].PkgLimitIndSlct.value != parent.frames[2].frames[1].document.forms[0].prevPkgLimitIndSlct.value) flag = false;

	//V201102 Starts
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].autoDistPkgVarServiceOPYN.value != parent.frames[2].frames[1].document.forms[0].prevautoDistPkgVarServiceOPYN.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].autoDistPkgVarPharMedItemsOPYN.value != parent.frames[2].frames[1].document.forms[0].prevautoDistPkgVarPharMedItemsOPYN.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].autoDistPkgVarServiceIPYN.value != parent.frames[2].frames[1].document.forms[0].prevautoDistPkgVarServiceIPYN.value) flag = false;
	if(	flag == true && parent.frames[2].frames[1].document.forms[0].autoDistPkgVarPharMedItemsIPYN.value != parent.frames[2].frames[1].document.forms[0].prevautoDistPkgVarPharMedItemsIPYN.value) flag = false;
	//V201102 Ends
	//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
	if(flag == true && parent.frames[2].frames[1].document.forms[0].pkgDepositYN.value != parent.frames[2].frames[1].document.forms[0].prevpkgDepositYN.value) 
		flag = false;
	
	if(flag)
	{
		err_mess = getMessage("BL8634",'BL')+"<br>";
	}
	else
	{
		//if(parent.frames[2].frames[1].document.forms[0].glSmryYN.value == "Y" && parent.frames[2].frames[1].document.forms[0].glSmry.value == "")
		//err_mess = "Please enter GL Posting by Summary Accounting Code ."+"<br>";
	}
	if(err_mess=="")
	{
		parent.frames[2].frames[1].document.forms[0].target='messageFrame';
		parent.frames[2].frames[1].document.forms[0].method='post';
		parent.frames[2].frames[1].document.forms[0].action="../../servlet/eBL.PkgParametersServlet";
		parent.frames[2].frames[1].document.forms[0].submit();	
	}
	else
	{
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}

}
	
function onSuccess()
{	
	PkgParametersDtls.location.href="../../eBL/jsp/PkgParametersDtls.jsp";
}

function reset()
{
	PkgParametersDtls.location.href="../../eBL/jsp/PkgParametersDtls.jsp";
}


async function patDepForPkgCodeLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code){	

	var formObj=document.frmPkgParametersDtls;
	if(formObj!=null){
		if(formObj.pat_dep_for_pkg_code_temp.value != formObj.pat_dep_for_pkg_code.value)
		{
			if(formObj.pat_dep_for_pkg_code.value != ""){	
	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.PatientDepositForPackage.label","BL");
				var locale=formObj.locale.value;
				var facilityId=formObj.facilityId.value;				
				argumentArray[0]	=  "select RECEIPT_TYPE_CODE code, SHORT_DESC description  from BL_RECEIPT_TYPE_lang_vw a where a.acc_entity_code= (select ACC_ENTITY_CODE from sy_Acc_entity where ACC_ENTITY_ID='"+facilityId+"') and a.RECPT_NATURE_CODE='AD' and nvl(a.status,'$') <> 'S' and a.language_id='"+locale+"' AND UPPER (RECEIPT_TYPE_CODE) LIKE UPPER (?) AND UPPER (SHORT_DESC) LIKE UPPER (?) order by 2 ";
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = pat_dep_for_pkg_code.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );

				if(retVal != null && retVal != ""){
					pat_dep_for_pkg_desc.value = retVal[1];
					pat_dep_for_pkg_code.value =retVal[0] ;
					formObj.pat_dep_for_pkg_code_temp.value= retVal[0];
					formObj.pat_dep_for_pkg_desc_temp.value= retVal[1];
				}else{
					pat_dep_for_pkg_desc.value = "";
					pat_dep_for_pkg_code.value = "" ;	
					formObj.pat_dep_for_pkg_code_temp.value= "";
					formObj.pat_dep_for_pkg_desc_temp.value="";										
				}
						
			}
		}
	}	
}

function patDepForPkgDescLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code){
	var formObj=document.frmPkgParametersDtls;
	if(formObj!=null){
		if(formObj.pat_dep_for_pkg_desc_temp.value != formObj.pat_dep_for_pkg_desc.value)
		{
			if(formObj.pat_dep_for_pkg_desc.value != "")
				show_patDepForPkgLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code);
		}
	}
}

 async function patDepForPkgLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code){
	var formObj=document.frmPkgParametersDtls;
		if(formObj!=null){
			if(formObj.pat_dep_for_pkg_desc.value == ""){
				await 	 show_patDepForPkgLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code);
			}
		}
}

async function show_patDepForPkgLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code){	
	var formObj=document.frmPkgParametersDtls;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.PatientDepositForPackage.label","BL");
	var locale=formObj.locale.value;
	var facilityId=formObj.facilityId.value;

  argumentArray[0]	=   "select RECEIPT_TYPE_CODE code, SHORT_DESC description  from BL_RECEIPT_TYPE_lang_vw a where a.acc_entity_code= (select ACC_ENTITY_CODE from sy_Acc_entity where ACC_ENTITY_ID='QF') and a.RECPT_NATURE_CODE='AD' and nvl(a.status,'$') != 'S' and a.language_id='en' AND UPPER (RECEIPT_TYPE_CODE) LIKE UPPER (?) AND UPPER (SHORT_DESC) LIKE UPPER (?) order by 2 ";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = pat_dep_for_pkg_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
 	if(retVal != null && retVal != ""){
   		pat_dep_for_pkg_desc.value = arr[1];
 		pat_dep_for_pkg_code.value =arr[0] ;
		formObj.pat_dep_for_pkg_code_temp.value= arr[0];
		formObj.pat_dep_for_pkg_desc_temp.value= arr[1];			
 	}else{
   		pat_dep_for_pkg_desc.value = "";
   		pat_dep_for_pkg_code.value = "" ;
		formObj.pat_dep_for_pkg_code_temp.value= "";
		formObj.pat_dep_for_pkg_desc_temp.value="";				
 	}		
}

/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Starts */
function enableDailPkgLimitFn(obj) {
	var formObj = document.forms[0];
	if(obj.checked) {
		$("#dailyPkgLimitSlct option[value='*']").remove();
		$("#dailyPkgLimitSlct").val("B");
		$("#pkgServiceLimitBy option[value='*']").remove();
		$("#pkgServiceLimitBy").val("B");
		formObj.dailyPkgLimitSlct.disabled = false;
		formObj.pkgServiceLimitBy.disabled = false;
	} else {
		var dailyPkgLimitSlct = document.getElementById('dailyPkgLimitSlct');
	    var dailyPkgLimitSlctOpt = document.createElement('option');
	    dailyPkgLimitSlctOpt.value = "*";
	    dailyPkgLimitSlctOpt.innerHTML = "--Select--";
	    dailyPkgLimitSlct.appendChild(dailyPkgLimitSlctOpt);
	    
		formObj.dailyPkgLimitSlct.value = "*";
		formObj.dailyPkgLimitSlct.disabled = true;
		
		var pkgServiceLimitBy = document.getElementById('pkgServiceLimitBy');
	    var pkgServiceLimitByOpt = document.createElement('option');
	    pkgServiceLimitByOpt.value = "*";
	    pkgServiceLimitByOpt.innerHTML = "--Select--";
	    pkgServiceLimitBy.appendChild(pkgServiceLimitByOpt);
		
		formObj.pkgServiceLimitBy.value = "*";
		formObj.pkgServiceLimitBy.disabled = true;
	}
}
/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Ends */

//V201102 Starts
function AutoDistPkgServOP(obj) {
	if(obj.checked)
  	{
  		obj.value = "Y";
  	}  
}

function AutoDistPkgServIP(obj) {
	if(obj.checked)
  	{
  		obj.value = "Y";
  	}
}
//V201102 Starts
//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
function chkPkgDepositYN(obj)
{	
	if(obj.checked)
	{
		document.forms[0].prevpkgDepositYN.value="Y";
	}
	else
	{
		document.forms[0].prevpkgDepositYN.value="N";
	}
} 

