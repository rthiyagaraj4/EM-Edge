/*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
---------------------------------------------------------------------------------------
*/



function validateBillingGroups(formObj)
{ 
	var totalRec=parseInt(formObj.totalRecords.value);
	for(var i=0;i<totalRec; i++)
	{	
		if(eval("formObj.blng_grp_code"+i).value !="" && (eval("formObj.blng_grp_code"+i) ==undefined || (eval("formObj.blng_grp_code"+i).value) ==""))
		{
			alert ("Billing Group Cannot be Blank!");
			eval("formObj.blng_grp_code"+i).focus();
			return false;
		}
	}
	return true;	
}

 async function blngGrpCodeLookUp(blng_grp_desc,blng_grp_code,index){	
	var formObj=document.blng_grp_dtls;
	
	if(formObj!=null){
		if((eval("formObj.blng_grp_code_temp"+index+".value") != eval("formObj.blng_grp_code"+index+".value")) || eval("formObj.blng_grp_desc"+index+".value") =="" )
		{
			if(eval("formObj.blng_grp_code"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.BillingGroup.label","BL");				
				var locale=formObj.locale.value;								
				var facility_id=formObj.facility_id.value;	
				var applicalbaleTo=formObj.applicalbaleTo.value;	
				if (applicalbaleTo == 'R') {
					argumentArray[0]	=  
						" select code,description from ("
						+" select '**'  code , 'All Groups'  description from dual union all select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND SETTLEMENT_IND in('R','X') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) "
						+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";
				}else {	
				argumentArray[0]	=  
					" select code,description from ("
					+" select '**'  code , 'All Groups'  description from dual union all select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND SETTLEMENT_IND = DECODE('"+applicalbaleTo+"','A','C',SETTLEMENT_IND) AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) "
					+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";
				}
				
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blng_grp_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				if(retVal != null && retVal != ""){
					blng_grp_desc.value = retVal[1];
					blng_grp_code.value =retVal[0] ;
					eval("formObj.blng_grp_code_temp"+index).value= retVal[0];
					eval("formObj.blng_grp_desc_temp"+index).value= retVal[1];					
				}else{
					clearRow(formObj,index);
				}
				saveBlngGrpPeriodDtls(index)
			}
		}
	}	
}


function blngGrpDescLookUp(blng_grp_desc,blng_grp_code,index){	
	var formObj=document.blng_grp_dtls;
	if(formObj!=null){
		if(eval("formObj.blng_grp_desc_temp"+index+".value") != eval("formObj.blng_grp_desc"+index+".value") || eval("formObj.blng_grp_code"+index+".value") =="" )
		{	
			eval("formObj.blng_code"+index).value= "";			
			eval("formObj.blng_desc"+index).value= "";			
			eval("formObj.pkg_valid_days"+index).value= "";				
			if(eval("formObj.blng_grp_desc"+index).value != ""){			
				show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index);
			}else{
				saveBlngGrpPeriodDtls(index);
			}
		}
	}
}

function ruleCodeLookup_blng_grp(obj,index){
	
	var formObj = document.blng_grp_period_dtl;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "VAT Percentage";
	var locale = formObj.locale.value;

	var facility_id = formObj.facilityId.value;
	

	argumentArray[0] = "select a.rule_code code, a.short_desc description from bl_addl_charge_rule_lang_vw a, bl_addl_charge_rule b where a.facility_id='"
		+facility_id
		+ "' and a.facility_id = b.facility_id and   a.language_id ='"
		+ locale
		+"' and a.rule_type_ind = 'M' AND a.rule_code = b.rule_code "
		+" AND (A.EFF_DATE_TO>=TRUNC(SYSDATE) OR A.EFF_DATE_TO IS NULL) AND (A.EFF_DATE_FROM<=SYSDATE) "
		+" and upper(a.rule_code) like upper(?) and upper(a.short_desc) like upper(?)";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argumentArray);
	
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {
		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {
			eval("document.forms[0].VATpercent" + index).value = retArray[0];		
		}
		else {
		eval("document.forms[0].VATpercent" + index).value = "";	
		}
	} else {
		eval("document.forms[0].VATpercent" + index).value = "";		
	}	
}

function blngGrpLookUp(blng_grp_desc,blng_grp_code,index){	
	//alert('blngGrpLookUp');
  	var formObj=document.blng_grp_dtls;
    	//alert('blngGrpLookUp 1');
      		if(formObj!=null){
		if(eval("formObj.blng_grp_desc"+index).value == ""){
			show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index);
			}
		}
}

async function show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index){		
	var formObj=document.blng_grp_dtls;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.BillingGroup.label","BL");
	var locale=formObj.locale.value;	
	var facility_id=formObj.facility_id.value;	
	var applicalbaleTo=formObj.applicalbaleTo.value;	
	if (applicalbaleTo == 'R') {
		argumentArray[0]	=  
			" select code,description from ("
			+" select '**'  code , 'All Groups'  description from dual union all select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND SETTLEMENT_IND in('R','X') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) "
			+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";
	}else {	
	argumentArray[0]	=  
		" select code,description from ("
		+" select '**'  code , 'All Groups'  description from dual union all select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND SETTLEMENT_IND = DECODE('"+applicalbaleTo+"','A','C',SETTLEMENT_IND) AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) "
		+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";
	}
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = blng_grp_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		blng_grp_desc.value = retVal[1];
   		blng_grp_code.value =retVal[0] ; 		
		eval("formObj.blng_grp_code_temp"+index).value= retVal[0];
		eval("formObj.blng_grp_desc_temp"+index).value= retVal[1];		
 	}else{
		clearRow(formObj,index);	
 	} 	
 	saveBlngGrpPeriodDtls(index);	
}

function saveBlngGrpPeriodDtls(index){
	//alert('saveBlngPeriodDtls');
	var hdrFormObj=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader
	var destFrame=parent.parent.PkgDefBlngGrpDetailFrame;
	var packageCode=hdrFormObj.packageCode.value;
	var mode=hdrFormObj.mode.value;
	var copyFrm_pkgCode=hdrFormObj.copyFrm_pkgCode.value;
	var orderAssociated = hdrFormObj.orderAssociated.value;
	//alert('saveBlngPeriodDtls 1='+mode);
	if(parent.parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl!=null){
		formObj=parent.parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
		if(formObj!=null && formObj!="undefined"){			
			result=validateBlngGrpPackageDates(formObj,parseInt(formObj.totalRecords.value));
			var parent_index=formObj.parent_index.value;
			
			if(parent_index!=index){
				var last_link=hdrFormObj.last_link.value;
				var current_form1 = hdrFormObj.current_form1.value;				
				var excln_form1 = hdrFormObj.current_form2.value;
				var current_form ;
				if(current_form1!=""){
					current_form=destFrame.frames[1].document.forms[0];  //frame ref changed 0 to 1 by ram
//						alert("parent 1:"+destFrame.frames[1].name)
				}
				else
					current_form="";
				var excln_form ;
				if(excln_form1!="" ){
					excln_form= destFrame.frames[4].document.forms[0];  //frame ref changed 2 to 4 by ram
//						alert("destFrame.frames[2] wew :" +destFrame.frames[4].name);
				}
				 else
					excln_form="";
				var result  = true;
				var excln_link = "";
				if(last_link == "BLNG_GRP_CHARGE_BASED")
				{
					excln_link="BLNG_GRP_CHARGE_BASED_ITEM";
					current_form=parent.parent.PkgDefBlngGrpDetailFrame.frames[1].document.forms[0]; //frame  ref changed 0 to 1 by ram
					result =validateBlngGrpChargeBased(current_form,current_form.totalRecords.value);
					if(result)
					{
						if(excln_form != undefined && excln_form != "")
							result =validateBlngGrpChargeBasedItems(excln_form,excln_form.totalRecords.value);
					}
				}
				if(last_link == "BLNG_GRP_RATE_BASED")
				{
					
					excln_link="BLNG_GRP_SRVLIMIT_RATE_BASED";							
					result=validateBlngGrpRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
				}
				if(parent.parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl!=null){
					formObj=parent.parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
					if(formObj!=null && formObj!="undefined"){						
						result=validateBlngGrpPackageDates(formObj,parseInt(formObj.totalRecords.value));
					}
				}
				if(result)
				{
					if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
						var  frmObj	 = excln_form;
						if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
						{				
//							alert("formValidation 16");						
							updation=formValidation(formBlngGrpXMLStringMain(frmObj),excln_link);
						}
						frmObj	 = current_form;
						if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
						{			
							updation=formValidation(formBlngGrpXMLStringMain(frmObj),last_link);
						}
					}	
		
					update=formValidation(formBlngGrpXMLStringMain(formObj),"blngGrpPeriod");
					parent.parent.PkgDefBlngGrpBaseDateMain.location.href='../../eCommon/html/blank.html';
					parent.parent.PkgDefBlngGrpTabFrame.location.href='../../eCommon/html/blank.html';
					parent.parent.PkgDefBlngGrpDetailFrame.location.href='../../eCommon/html/blank.html';
					hdrFormObj.last_link.value="";
					hdrFormObj.current_form1.value="";					
					hdrFormObj.current_form2.value="";
				}
			}
		}
	}
	formObj=document.blng_grp_dtls;
	var currKey=trimString(eval("formObj.blng_grp_code"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value;
	if(mode=='insert' && oldKey!="" && currKey !=oldKey){
		removeBeanKey(formObj,oldKey,index);
		hdrFormObj.last_link.value="";
		hdrFormObj.current_form1.value="";		
		hdrFormObj.current_form2.value="";
		parent.parent.PkgDefBlngGrpBaseDateMain.location.href='../../eCommon/html/blank.html';
		parent.parent.PkgDefBlngGrpTabFrame.location.href='../../eCommon/html/blank.html';
		parent.parent.PkgDefBlngGrpDetailFrame.location.href='../../eCommon/html/blank.html';
	}
	return true;
}

function chkBlngGrpValidDays(obj)
{
	var flag=false;
	if(obj.value<=0){
		flag= false;
	}else{
		flag=true;
	}
	return flag;
}

function showBlngGrpPeriod(obj,index){		
	var pkg_valid_days = eval("document.blng_grp_dtls.pkg_valid_days"+index).value;
	
	if(pkg_valid_days =="")
	{
		alert(getMessage("BL8571",'BL'));		
		return false;
	}
	
	var blng_grp_code=eval("document.blng_grp_dtls.blng_grp_code"+index).value;	
	var blng_grp_desc=encodeURIComponent(eval("document.blng_grp_dtls.blng_grp_desc"+index).value);
	var fromDate=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.effFromDate.value;
	var mode=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var packageCode=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;
	var authorized=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.authorized.value;
	var pkgApprovedYN=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.pkgApprovedYN.value;
  //Added V190325 Gayathri/KDAH-CRF-0503
	var isMasterPackageYN='N';
  isMasterPackageYN=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.isMasterPackYN.value;
	var allow_masterChild_package=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.allow_masterChild_package_map.value;	
	if(packageCode!="" && blng_grp_code!="" ){
	saveBlngGrpPeriodDtls(index);
	parent.parent.PkgDefBlngGrpBaseDateMain.location.href="../../eBL/jsp/PkgDefBlngGrpBaseDateMain.jsp?packageCode="+packageCode+"&mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&fromDate="+fromDate+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+blng_grp_desc+"&parent_index="+index+"&isMasterPackageYN="+isMasterPackageYN+"&parent_index="+index+"&allow_masterChild_package="+allow_masterChild_package;
	parent.parent.PkgDefBlngGrpTabFrame.location.href='../../eCommon/html/blank.html';
	parent.parent.PkgDefBlngGrpDetailFrame.location.href='../../eCommon/html/blank.html';
	}
}

function blngGrpValidateDate(obj,fromDate,toDate,index)
{	
	var fromDate = eval(fromDate).value;
	var toDate	 = eval(toDate).value;
	var locale=document.forms[0].locale.value;
	var	totRec=	 document.forms[0].totalRecords.value;
	var pakEffDate = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.effFromDate.value;
	var flag = true;
	if(obj.value!=""){
		if(!(pakEffDate == null || pakEffDate==""))
		{
			if(validBlngGrpDateChk(obj))
			{	 
				if(!(fromDate==null || fromDate=="" || toDate==null || toDate=="" ))
				{	 
					if((!isBefore(fromDate,toDate,'DMY',locale)))
					{
						alert(getMessage("BL4115",'BL'));
						obj.value="";
						obj.focus();
						flag = false;
					}
					else
					{		
						//return false;
					}
				}
				if(flag && pakEffDate!="" && obj.value !="" && (!(isAfter(obj.value,pakEffDate,'DMY',locale))))
				{
					//alert("Date should be greater than or equal to than package effective from date")
					alert(getMessage("BL8512",'BL'));
					
					flag = false;
					obj.value="";
					//Commented the below line for MMS-DM-SCF-0378
					//obj.focus(); //v10012018 MMS-DM-SCF-0378
	
				} 	
				pakEffDate = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.effToDate.value;	
//				alert((!(isAfter(pakEffDate,obj.value,'DMY',locale))));
				if(flag && pakEffDate!="" && obj.value !="" && (!(isAfter(pakEffDate,obj.value,'DMY',locale))))
				{
					//alert("Date should be less than package effective to date")
					alert(getMessage("BL8517",'BL'));
					flag = false;
					obj.value="";
					obj.focus();
				}		  
				if(flag && obj.value !="" && (index>0 || totRec>1)){					
					overLapCheck(totRec,obj,index);
				
				}
			}
		}
		else
		{	
			obj.value="";
			alert(getMessage("BL8504",'BL'));
		}
	} 
	if(obj.name==("fromDate_"+index)){		
				if(saveBlngGrpPriceSrvDtls(index))
					eval("document.forms[0].oldPeriodKey"+index).value=document.forms[0].blng_grp_code.value+"~~"+obj.value;
	}
}

function validBlngGrpDateChk(obj)
{
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
		if(validDate(obj.value,'DMY',locale))
		{
			var frmObj = ""	;
			if(parent.PkgDefBlngGrpBaseDateMain!= undefined)
				 frmObj = parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
			else
				 frmObj = parent.blng_grp_period_dtl.document.blng_grp_period_dtl;

			if(eval("frmObj.fromDate_0.value==''"))
				eval("frmObj.fromDate_0").value = obj.value; 

			if(parent.PkgDefBlngGrpTabFrame!= undefined) 
				 frmObj = parent.PkgDefBlngGrpTabFrame.document.blng_grp_tab;
			else
				 frmObj = parent.parent.PkgDefBlngGrpTabFrame.document.blng_grp_tab;		

			return true;
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value = '';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function showBlngGrpBasePrice(obj,index)	// Include code for charge based and rate based
{		
	var value = eval("document.forms[0].fromDate_"+index).value;
	document.forms[0].fromDate.value =  value;
	parent.parent.PkgDefBlngGrpTabFrame.location.href="../../eBL/jsp/PkgDefBlngGrpTab.jsp?fromDate="+value+"&blng_grp_code="+document.forms[0].blng_grp_code.value+"&blng_grp_desc="+encodeURIComponent(document.forms[0].blng_grp_desc.value)+"&parent_index="+index+"&isMaterPackageYN="+document.forms[0].isMasterPackYN.value+"&allow_masterChild_package="+document.forms[0].allow_masterChild_package.value;
		
	var packageCode= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;	
	var mode = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;

	if(parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl!=null && parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl != undefined)
	{
		
		
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.blng_grp_base_price_dtl;
		
		if(frmObj!=null && frmObj!=undefined)
		{	
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_PRICE");
		}
	}
	else if(parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl!=null  && parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl != undefined)
	{
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{				
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_CHARGE_BASED");
		}
		if(parent.parent.PkgDefBlngGrpDetailFrame.length>2)
		{
			if(parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedExCln != undefined)
			{
				var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedExCln.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{	
					var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_CHARGE_BASED_ITEM");
				}
			}
		}
	}
	else if(parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl !=null && parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl != undefined)
	{
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_RATE_BASED");
		}
		if(parent.parent.PkgDefBlngGrpDetailFrame.length>2)
		{
			
			if(parent.parent.PkgDefBlngGrpDetailFrame.srvLimit_rate_based_dtl != undefined)
			{
				var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.srvLimit_rate_based_dtl.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{		
					var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_SRVLIMIT_RATE_BASED");
				}
			}
		}
	}
	if(value == null || value== "" )
	{ 
		obj.checked = false;
	}
	else  
	{
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
		showBlngGrpTabDetail('BLNG_GRP_PRICE',parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.parent.PkgDefBlngGrpDetailFrame,parent.parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,index,value);
	}
}

async function callBlngGrpPriceClass(obj,from,type,index)
{
	var str = "";
	var value  = "";
	if(obj!="" && obj.value!=null && obj.value!=undefined && obj.value!="")
	{
	   value	= obj.value;
	}
	if((from != "" && obj.value!="") || (from == ""))
	{
		var sql = "select price_class_code code, short_desc description from bl_price_class_lang_vw where language_id='"+document.forms[0].locale.value +"' and nvl(status,'X') <> 'S' and upper(price_class_code) like upper(?) and upper(short_desc) like upper(?)";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var pClsCode =eval("document.forms[0].pkgPriceClsCode_"+index);
		var pClsDesc =eval("document.forms[0].pkgPriceClsDesc_"+index);
		var title=getLabel("eBL.PACKAGE_PRICE_CLASS.label","BL");
		if(type == "OUT_PRICE_CLASS")
		{
			title=getLabel("eBL.OUTSIDE_PACKAGE_PRICE_CLASS.label","BL");
			pClsCode =eval("document.forms[0].oPkgPriceClsCode_"+index);
			pClsDesc =eval("document.forms[0].oPkgPriceClsDesc_"+index);
		}
		var local=document.forms[0].locale.value;
		argumentArray[0]	= sql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		retVal = await CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
   			pClsDesc.value = retVal[1];
			pClsCode.value =retVal[0] ;
	 	}
		else
		{
   			pClsDesc.value = "";
   			pClsCode.value = "" ;
		}
	}
}

function showBlngGrpBasePrice(obj,index)	// Include code for charge based and rate based
{		

	var value = eval("document.forms[0].fromDate_"+index).value;
	document.forms[0].fromDate.value =  value;
//alert('PkgDefBlngGrpTab.jsp 2='+document.forms[0].allow_masterChild_package.value);
	parent.parent.PkgDefBlngGrpTabFrame.location.href="../../eBL/jsp/PkgDefBlngGrpTab.jsp?fromDate="+value+"&blng_grp_code="+document.forms[0].blng_grp_code.value+"&blng_grp_desc="+encodeURIComponent(document.forms[0].blng_grp_desc.value)+"&parent_index="+index+"&isMaterPackageYN="+document.forms[0].isMasterPackYN.value+"&allow_masterChild_package="+document.forms[0].allow_masterChild_package.value;
		
	var packageCode= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;	
	var mode = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;

	if(parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl!=null && parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl != undefined)
	{
		
		
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.blng_grp_base_price_dtl;
		
		if(frmObj!=null && frmObj!=undefined)
		{	
//				alert("formValidation 4");			
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_PRICE");
		}
	}
	else if(parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl!=null  && parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl != undefined)
	{
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedDtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{				
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_CHARGE_BASED");
		}
		if(parent.parent.PkgDefBlngGrpDetailFrame.length>2)
		{
			if(parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedExCln != undefined)
			{
				var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.ChargeBasedExCln.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{	
					var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_CHARGE_BASED_ITEM");
				}
			}
		}
	}
	else if(parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl !=null && parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl != undefined)
	{
		var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.rate_based_dtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{
			var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_RATE_BASED");
		}
		if(parent.parent.PkgDefBlngGrpDetailFrame.length>2)
		{
			
			if(parent.parent.PkgDefBlngGrpDetailFrame.srvLimit_rate_based_dtl != undefined)
			{
				var frmObj = parent.parent.PkgDefBlngGrpDetailFrame.srvLimit_rate_based_dtl.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{		
					var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_SRVLIMIT_RATE_BASED");
				}
			}
		}
	}
	if(value == null || value== "" )
	{ 
		obj.checked = false;
	}
	else  
	{
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
		showBlngGrpTabDetail('BLNG_GRP_PRICE',parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.parent.PkgDefBlngGrpDetailFrame,parent.parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,index,value);
	}
}

function blngGrpGlSmryCodeLookUp(glSmryDesc,glSmry,index){
	var formObj=document.blng_grp_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmry_temp"+index+".value") != eval("formObj.glSmry"+index+".value"))
		{
			if(eval("formObj.glSmry"+index).value != ""){	
	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.AccountingCode.label","BL");
				var locale=formObj.locale.value;				
				var facility_id=formObj.facilityId.value;				
				argumentArray[0]	=  "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"+locale+"')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"+facility_id+"') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = glSmry.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retArray = CommonLookup( title, argumentArray );
				if(retArray!='undefined' && retArray!=undefined && retArray != null)
				{
					if(retArray[0]+"" != "undefined" && retArray[0]+"" !=""){
						eval("document.forms[0].glSmry"+index).value = retArray[0];
						eval("document.forms[0].glSmry_temp"+index).value = retArray[0];
					}
					if(retArray[1]+"" != "undefined" && retArray[1]+"" !=""){
						eval("document.forms[0].glSmryDesc"+index).value =  retArray[1];
						eval("document.forms[0].glSmryDesc_temp"+index).value =  retArray[1];
					}
							
				}else{
					eval("document.forms[0].glSmry"+index).value = "";
					eval("document.forms[0].glSmryDesc"+index).value =  "";
					eval("formObj.glSmry_temp"+index).value= "";
					eval("formObj.glSmryDesc_temp"+index).value="";										
				}
			}
		}
	}
}

function blngGrpGlSmryDescLookUp(glSmryDesc,glSmry,index){
	var formObj=document.blng_grp_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmryDesc_temp"+index+".value") != eval("formObj.glSmryDesc"+index+".value"))
		{
			if(eval("formObj.glSmryDesc"+index).value != "")
				show_blngGrpGlSmryLookUp(glSmryDesc,glSmry,index);
		}
	}
}

function blngGrpGlSmryLookUp(glSmryDesc,glSmry,index){
	var formObj=document.blng_grp_period_dtl;
		if(formObj!=null){
			if(eval("formObj.glSmryDesc"+index).value == ""){
				show_blngGrpGlSmryLookUp(glSmryDesc,glSmry,index);
			}
		}
}

function show_blngGrpGlSmryLookUp(glSmryDesc,glSmry,index){	
	var formObj=document.blng_grp_period_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.AccountingCode.label","BL");
	var locale=formObj.locale.value;
	var facility_id=formObj.facilityId.value;
	
argumentArray[0]	=  "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"+locale+"')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"+facility_id+"') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = glSmryDesc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retArray = CommonLookup( title, argumentArray );

	if(retArray!='undefined' && retArray!=undefined && retArray != null)
	{
		if(retArray[0]+"" != "undefined" && retArray[0]+"" !=""){
			eval("document.forms[0].glSmry"+index).value = retArray[0];
			eval("document.forms[0].glSmry_temp"+index).value = retArray[0];
		}
		if(retArray[1]+"" != "undefined" && retArray[1]+"" !=""){
			eval("document.forms[0].glSmryDesc"+index).value =  retArray[1];
			eval("document.forms[0].glSmryDesc_temp"+index).value =  retArray[1];
		}
			
	}else{
		eval("document.forms[0].glSmry"+index).value = "";
		eval("document.forms[0].glSmryDesc"+index).value =  "";
		eval("formObj.glSmry_temp"+index).value= "";
		eval("formObj.glSmryDesc_temp"+index).value="";			
	}
}

function blngGrpGlSmryDiscCodeLookUp(glSmryDiscDesc,glSmryDisc,index){

	var formObj=document.blng_grp_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmryDisc_temp"+index+".value") != eval("formObj.glSmryDisc"+index+".value"))
		{
			if(eval("formObj.glSmryDisc"+index).value != ""){	
	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.AccountingCode.label","BL");
				var locale=formObj.locale.value;				
				var facility_id=formObj.facilityId.value;				
				argumentArray[0]	=  "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"+locale+"')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"+facility_id+"') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = glSmryDisc.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retArray = CommonLookup( title, argumentArray );
				if(retArray!='undefined' && retArray!=undefined && retArray != null)
				{
					if(retArray[0]+"" != "undefined" && retArray[0]+"" !=""){
						eval("document.forms[0].glSmryDisc"+index).value = retArray[0];
						eval("document.forms[0].glSmryDisc_temp"+index).value = retArray[0];
					}
					if(retArray[1]+"" != "undefined" && retArray[1]+"" !=""){
						eval("document.forms[0].glSmryDiscDesc"+index).value =  retArray[1];
						eval("document.forms[0].glSmryDiscDesc_temp"+index).value =  retArray[1];
					}
							
				}else{
					eval("document.forms[0].glSmryDisc"+index).value = "";
					eval("document.forms[0].glSmryDiscDesc"+index).value =  "";
					eval("formObj.glSmryDisc_temp"+index).value= "";
					eval("formObj.glSmryDiscDesc_temp"+index).value="";										
				}
			}
		}
	}	
}

function blngGrpGlSmryDiscDescLookUp(glSmryDiscDesc,glSmryDisc,index){
	var formObj=document.blng_grp_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmryDiscDesc_temp"+index+".value") != eval("formObj.glSmryDiscDesc"+index+".value"))
		{
			if(eval("formObj.glSmryDiscDesc"+index).value != "")
				show_blngGrpGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index);
		}
	}
}

function blngGrpGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index){
	var formObj=document.blng_grp_period_dtl;
		if(formObj!=null){
			if(eval("formObj.glSmryDiscDesc"+index).value == ""){
				show_blngGrpGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index);
			}
		}
}
function show_blngGrpGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index){	
	var formObj=document.blng_grp_period_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.AccountingCode.label","BL");
	var locale=formObj.locale.value;
	var facility_id=formObj.facilityId.value;
	
argumentArray[0]	=  "SELECT a.acc_int_code code, a.acc_int_desc description   FROM bl_gl_account_lang_vw a  WHERE UPPER (a.language_id) = UPPER ('"+locale+"')   AND a.acc_entity_code in (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id ='"+facility_id+"') AND NVL (a.status, 'X') != 'S'  AND UPPER (a.acc_int_code) LIKE UPPER (?) AND UPPER (a.acc_int_desc) LIKE UPPER (?) ";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = glSmryDiscDesc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retArray = CommonLookup( title, argumentArray );

	if(retArray!='undefined' && retArray!=undefined && retArray != null)
	{
		if(retArray[0]+"" != "undefined" && retArray[0]+"" !=""){
			eval("document.forms[0].glSmryDisc"+index).value = retArray[0];
			eval("document.forms[0].glSmryDisc_temp"+index).value = retArray[0];
		}
		if(retArray[1]+"" != "undefined" && retArray[1]+"" !=""){
			eval("document.forms[0].glSmryDiscDesc"+index).value =  retArray[1];
			eval("document.forms[0].glSmryDiscDesc_temp"+index).value =  retArray[1];
		}
			
	}else{
		eval("document.forms[0].glSmryDisc"+index).value = "";
		eval("document.forms[0].glSmryDiscDesc"+index).value =  "";
		eval("formObj.glSmryDisc_temp"+index).value= "";
		eval("formObj.glSmryDiscDesc_temp"+index).value="";			
	}
}



function CopyBaseChk()
{
	var copyReplaceFlag ="";
	var packageCode		= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;
	var pakEffDate = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.effFromDate.value;
	var blng_grp_code = parent.frames[0].document.forms[0].blng_grp_code.value;
	var blng_grp_desc = parent.frames[0].document.forms[0].blng_grp_desc.value;	
	var fromDate = document.forms[0].fromDate.value;
	var copy_base = confirm(getMessage('BL9125','BL'));
		if(copy_base == true)
			copyReplaceFlag="C";
		else
			copyReplaceFlag="N";
		//alert("copyReplaceFlag Copy ==> "+copyReplaceFlag);
	var param = copyReplaceFlag;
	var param1 = packageCode;
	var param2 = pakEffDate;
	//alert('PkgDefBlngGrpTab.jsp 3');
	parent.parent.PkgDefBlngGrpTabFrame.location.href="../../eBL/jsp/PkgDefBlngGrpTab.jsp?param="+param+"&param1="+param1+"&param2="+param2+"&blng_grp_code="+blng_grp_code+"&fromDate="+fromDate+"&blng_grp_desc="+blng_grp_desc;
}

function ReplaceBaseChk()
{	
	var copyReplaceFlag ="";
	var packageCode		= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;
	var pakEffDate = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.effFromDate.value;
	var blng_grp_code = parent.frames[0].document.forms[0].blng_grp_code.value;
	var blng_grp_desc = parent.frames[0].document.forms[0].blng_grp_desc.value;
	var fromDate = document.forms[0].fromDate.value;
	//alert("fromDate ==> "+fromDate);
	var replace_base = confirm(getMessage('BL9126','BL'));
		if(replace_base == true)
			copyReplaceFlag="R";
		else
			copyReplaceFlag="N";
	//	alert("copyReplaceFlag Replace ==> "+copyReplaceFlag);
	var param = copyReplaceFlag;
	var param1 = packageCode;
	var param2 = pakEffDate;
	//alert('PkgDefBlngGrpTab.jsp 4');
		parent.parent.PkgDefBlngGrpTabFrame.location.href="../../eBL/jsp/PkgDefBlngGrpTab.jsp?param="+param+"&param1="+param1+"&param2="+param2+"&blng_grp_code="+blng_grp_code+"&fromDate="+fromDate+"&blng_grp_desc="+blng_grp_desc;
}
//Added by MuthukumarN against 31860 on 5/4/2012 - Ends Here



function showBlngGrpTabDetail(key,hdrFormObj,destFrame,tabFrame,blng_grp_code,blng_grp_desc,parent_index,fromDate)	
{//alert(1+hdrFormObj.name+"/"+destFrame.name+"/"+key+"/"+tabFrame);
	var packageCode=hdrFormObj.packageCode.value;
	var mode=hdrFormObj.mode.value;
	var copyFrm_pkgCode=hdrFormObj.copyFrm_pkgCode.value;
	var orderAssociated = hdrFormObj.orderAssociated.value;
	var acrossEncounters = hdrFormObj.acrossEncounters.value;
	var last_link=hdrFormObj.last_link.value;
	var current_form1 = hdrFormObj.current_form1.value;	
	var excln_form1 = hdrFormObj.current_form2.value;
	var authorized = hdrFormObj.authorized.value;
	var pkgApprovedYN = hdrFormObj.pkgApprovedYN.value;
	var current_form ;
	if(current_form1!="")					
		current_form=destFrame.frames[1].document.forms[0];				//frames ref chhanged 0 to 1 by ram		
	else
		current_form="";		
	var excln_form ;
	if(excln_form1!="" )
		excln_form= destFrame.frames[4].document.forms[0]; 
	 else
		excln_form="";

	var result  = true;
	var excln_link = "";
	//alert(last_link);
	if(last_link == "BLNG_GRP_CHARGE_BASED")
	{
		excln_link="BLNG_GRP_CHARGE_BASED_ITEM";
		current_form=destFrame.frames[1].document.forms[0]; //frame ref changed frames[0] to frames[1] by ram		
		result =validateBlngGrpChargeBased(current_form,current_form.totalRecords.value);
			if(result){
			if(excln_form != undefined && excln_form != "")
				result =validateBlngGrpChargeBasedItems(excln_form,excln_form.totalRecords.value);	
		}
	}
	if(last_link == "BLNG_GRP_RATE_BASED")
	{
		excln_link="BLNG_GRP_SRVLIMIT_RATE_BASED";
		result=validateBlngGrpRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
	}
	 if(last_link == "BLNG_GRP_PRICE"){
			var totalRec = parent.frames[4].frames[1].blng_grp_base_price_dtl.totalRecords.value;
			for ( var i = 0; i < totalRec; i++) {
				if (parent.frames[4].frames[1].blng_grp_base_price_dtl.document.getElementById('blgClsCode_' + i).value == "") {
					alert('Atleast One Entry for Package Base Price Must be Provided');
					return false;
				}
				if (parent.frames[4].frames[1].blng_grp_base_price_dtl.document.getElementById('price_' + i).value == "") {
					alert(getMessage("BL8527", 'BL'));
					return false;
				}
			}
		result=validateBlngGrpPackagePrice(current_form,current_form.totalRecords.value);
	 }

	if(result)
	{
		//alert(result);
		if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
		var  frmObj	 = excln_form;
			if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
			{	
			//	alert("formValidation 10");			
				var updation=formValidation(formBlngGrpXMLStringMain(frmObj),excln_link);
			}
			
			 frmObj	 = current_form;
			
			if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
			{				
				//alert("formValidation 11");			
				var updation=formValidation(formBlngGrpXMLStringMain(frmObj),last_link);
				
			}
		}
		//if(fromDate!=""){
		if(fromDate!=""){
			hdrFormObj.last_link.value="";
			hdrFormObj.current_form1.value="";
			hdrFormObj.current_form2.value="";
			if(key=="BLNG_GRP_PRICE"){
				changeBlngGrpTabClass(key,tabFrame);
				
				if (document.getElementById("BLNG_GRP_PRICE_CHK") != null) {
					document.getElementById("BLNG_GRP_PRICE_CHK").value = "Y";
				}
				
				destFrame.location.href='../../eBL/jsp/PkgDefBlngGrpBasePriceMain.jsp?packageCode='+packageCode+'&mode='+mode+'&blng_grp_code='+blng_grp_code+'&blng_grp_desc='+encodeURIComponent(blng_grp_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN;
			}else if(key=="BLNG_GRP_CHARGE_BASED"){				
	
				if(orderAssociated == "Y"){
					alert(getMessage("BL8578",'BL'));
				}
				else{
					changeBlngGrpTabClass(key,tabFrame);

					var totRec = parent.frames[2].frames[0].document.forms[0].totalRecords.value;
					var fromDateVals = "";
					for(var i=0;i<totRec;i++)
					{
						fromDateVals = fromDateVals+eval("parent.frames[2].frames[0].document.forms[0].fromDate_"+i).value+"|";
					}
					document.getElementById("BLNG_GRP_CHARGE_BASED_CHK").value = "Y";
					destFrame.location.href='../../eBL/jsp/PkgDefBlngGrpChargeBasedMain.jsp?packageCode='+packageCode+'&mode='+mode+'&copyFrm_pkgCode='+copyFrm_pkgCode+'&blng_grp_code='+blng_grp_code+'&blng_grp_desc='+encodeURIComponent(blng_grp_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&fromDateVals="+encodeURIComponent(fromDateVals);
				}
			}
			else if(key=="BLNG_GRP_RATE_BASED")
			{  
				
				changeBlngGrpTabClass(key,tabFrame);	

				var totRec = parent.frames[2].frames[0].document.forms[0].totalRecords.value;
				var fromDateVals = "";
				for(var i=0;i<totRec;i++)
				{
					fromDateVals = fromDateVals+eval("parent.frames[2].frames[0].document.forms[0].fromDate_"+i).value+"|";
				}
				document.getElementById("BLNG_GRP_RATE_BASED_CHK").value = "Y"; 
				destFrame.location.href='../../eBL/jsp/PkgDefBlngGrpRateFrame.jsp?packageCode='+packageCode+'&mode='+mode+'&orderAssociated='+orderAssociated+'&copyFrm_pkgCode='+copyFrm_pkgCode+'&blng_grp_code='+blng_grp_code+'&blng_grp_desc='+encodeURIComponent(blng_grp_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&acrossEncounters="+acrossEncounters+"&fromDateVals="+encodeURIComponent(fromDateVals);
			}
						
		}else{
				//alert("Test 1234");
				alert(getMessage("BL8504",'BL')); 
		}
	}
}

function validateBlngGrpPackagePrice(formObj,totalRec,calledFrom)
{//alert(90);
	var flag = true;
	for(var i=0;i<totalRec; i++)
	{	
		if (calledFrom == 'apply') {
			if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.getElementById('blgClsCode_' + i).value == "") {
				alert('Atleast One Entry for Package Base Price Must be Provided');
				return false;
			}
			if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefBlngGrpDetailFrame.blng_grp_base_price_dtl.document.getElementById('price_' + i).value == "") {
				alert(getMessage("BL8527", 'BL'));
				return false;
			}
		}
		
		//alert("eval(formObj+.cbCode_+i).value :"+eval(formObj+".cbCode_"+i).value)
		if((eval("formObj.blgClsCode_"+i) !=undefined  && eval("formObj.blgClsCode_"+i).value !="")  ||  (eval("formObj.price_"+i) !=undefined && eval("formObj.price_"+i).value!=""))
		{
			if(eval("formObj.blgClsCode_"+i) !=undefined  && eval("formObj.blgClsCode_"+i).value !="")
			{
				if(eval("formObj.price_"+i) !=undefined && eval("formObj.price_"+i).value!="")
					flag = true;
				else
				{
					alert (getMessage("BL8527",'BL'));
					eval("formObj.price_"+i).focus();
					return false;
				}
				var message="";
				if(eval("formObj.roundTo_"+i).value==null || eval("formObj.roundTo_"+i).value=="" || eval("formObj.roundTo_"+i).value=="10"  || eval("formObj.roundTo_"+i).value=="50"  || eval("formObj.roundTo_"+i).value=="100"  || eval("formObj.roundTo_"+i).value=="500" || eval("formObj.roundTo_"+i).value=="1000"  )
				{	
					message=""; 			
				}
				else{
					message=getMessage("BL8681",'BL'); 	
					obj=eval("formObj.roundTo_"+i);
					alert(message);
					obj.focus();
					return false;
				}
			}
			else
			{	
				alert (getMessage("BL9300",'BL'));
				eval("formObj.blgClsCode_"+i).focus();
				return false;
			}
		}
	}
	return flag;
}

//Mandatory Check for Charge based items
function validateBlngGrpChargeBasedItems(formObj,totalRec)
{ //alert(100);
	for(var i=0;i<totalRec; i++)
	{
		if((eval("formObj.cbCode_"+i)) !=undefined && (eval("formObj.cbCode_"+i).value) !="")
		{
			if((eval("formObj.inEx_"+i).value) == "N")
			{
				if((eval("formObj.quantityLimit_"+i).value) == "" &&  (eval("formObj.amountLimit_"+i).value) == "" )
				{
					alert(getMessage("BL8541","BL"));					
					eval("formObj.quantityLimit_"+i).focus();
					return false;
				}
			}
		}
	}
	return true;

} 

function changeBlngGrpTabClass(tabObj,tabFrame){		
	//alert('changeBlngGrpTabClass start='+tabObj.name+"/"+tabFrame.name);
	if(tabFrame.document.forms[0]!=null){
			prevTabObj= tabFrame.document.forms[0].prevTabObj.value;
			
			if(prevTabObj!=null && prevTabObj!=""){			
					tabFrame.document.getElementById('prevTabObj')).className="tabA";
					tabFrame.document.getElementById(prevTabObj+"span").className="tabAspan";
				}
				tabFrame.document.getElementById('tabObj').className="tabClicked";
				tabFrame.document.getElementById(tabObj+"span").className="tabSpanclicked";
				tabFrame.document.forms[0].prevTabObj.value=tabObj;
	}			
	//alert('end');
}


function saveBlngGrpPriceSrvDtls(index){	
	var hdrFormObj=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader;
	var destFrame=parent.parent.PkgDefBlngGrpDetailFrame;
	var packageCode=hdrFormObj.packageCode.value;
	var mode=hdrFormObj.mode.value;
	var copyFrm_pkgCode=hdrFormObj.copyFrm_pkgCode.value;
	var orderAssociated = hdrFormObj.orderAssociated.value;
	
	var last_link=hdrFormObj.last_link.value;
	var current_form1 = hdrFormObj.current_form1.value;	
	var excln_form1 = hdrFormObj.current_form2.value;
	var current_form ;
	var parent_index="";	
	if(current_form1!=""){
		current_form=destFrame.frames[1].document.forms[0]; //frame ref changed 0 to 1 by ram
		parent_index=current_form.parent_index.value; 
	}else
		current_form="";
	if(parent_index!=index){
		var excln_form ;
		if(excln_form1!="" )			
			excln_form= destFrame.frames[4].document.forms[0]; 		
		else
			excln_form="";
		var result  = true;
		var excln_link = "";
		if(last_link == "BLNG_GRP_CHARGE_BASED")
		{
			excln_link="BLNG_GRP_CHARGE_BASED_ITEM";
			current_form=destFrame.frames[1].document.forms[0];  //frame ref changed 0 to 1
				
			result =validateBlngGrpChargeBased(current_form,current_form.totalRecords.value);
			if(result)
			{
				if(excln_form != undefined && excln_form != "")
					result =validateBlngGrpChargeBasedItems(excln_form,excln_form.totalRecords.value);
			}
		}
		if(last_link == "BLNG_GRP_RATE_BASED")
		{
			
			excln_link="BLNG_GRP_SRVLIMIT_RATE_BASED";					
			
			result=validateBlngGrpRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
		}
		if(result)
		{
			if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
				var  frmObj	 = excln_form;
				if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
				{				
//				alert("formValidation 14");					
					 updation=formValidation(formBlngGrpXMLStringMain(frmObj),excln_link);
				}
				 frmObj	 = current_form;
				if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
				{			
//					alert("formValidation 15");				 
				
					updation=formValidation(formBlngGrpXMLStringMain(frmObj),last_link);
				}
				
				parent.parent.PkgDefBlngGrpTabFrame.location.href='../../eCommon/html/blank.html';
				parent.parent.PkgDefBlngGrpDetailFrame.location.href='../../eCommon/html/blank.html';
				
				hdrFormObj.last_link.value="";
				hdrFormObj.current_form1.value="";				
				hdrFormObj.current_form2.value="";
			}	
		}
	}
	formObj=parent.parent.PkgDefBlngGrpBaseDateMain.blng_grp_period_dtl.document.blng_grp_period_dtl;
	var currKey=trimString(formObj.blng_grp_code.value+"~~"+eval("formObj.fromDate_"+index).value);
	var oldPeriodKey=eval("formObj.oldPeriodKey"+index).value;
	if(mode=='insert' && oldPeriodKey!="" && oldPeriodKey!=trimString(formObj.blng_grp_code.value+"~~") && currKey !=oldPeriodKey){
		removeBeanKey(formObj,oldPeriodKey,index);
					  
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";	
		parent.parent.PkgDefBlngGrpTabFrame.location.href='../../eCommon/html/blank.html';
		parent.parent.PkgDefBlngGrpDetailFrame.location.href='../../eCommon/html/blank.html';
	}
	
	return true;
}

function validateBlngGrpChargeBased(formObj,totalRec)
{	
var message="";
	for(var i=0;i<totalRec; i++)
	{	
		if(eval("formObj.cbCode_"+i) !=undefined  && eval("formObj.cbCode_"+i).value !="")
		{		
			if((eval("formObj.amt_limit_ind"+i).value) != "U")
			{
				if(eval("formObj.perAmt_limit"+i).value == "" )
				{
					
					alert(getMessage("BL8541","BL"));
					eval("formObj.perAmt_limit"+i).focus();
					return false;
				}
			}
			if(eval("formObj.roundTo_"+i).value==null || eval("formObj.roundTo_"+i).value=="" || eval("formObj.roundTo_"+i).value=="10"  || eval("formObj.roundTo_"+i).value=="50"   || eval("formObj.roundTo_"+i).value=="100"  || eval("formObj.roundTo_"+i).value=="500"  || eval("formObj.roundTo_"+i).value=="1000"  )
			{	
				message=""; 			
			}
			else
			{
				message=getMessage("BL8681",'BL'); 	
				obj=eval("formObj.roundTo_"+i);
			}
			if(message!=""){
				//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				alert(message);
				obj.focus();
				return false;
			}	
		}
	}
	return true;
}  

function validateBlngGrpRateForm(formObj,srvLimitFormObj,packageCode){
	var totalRecords=formObj.totalRecords.value;
	//var messageFrame=parent.parent.frames[2];
	//alert(parent.parent.parent.frame(2))
	var obj;
	var message="";
	var order_associated=formObj.order_associated.value;
	var result=true;	
	var acrossEncounters=formObj.acrossEncounters.value;
	var closePkgChk=true;	
	var serviceExists=false;
	if(srvLimitFormObj != null  && srvLimitFormObj != ''){		
		result=validateBlngGrpServiceLimitForm(srvLimitFormObj,packageCode,"",'apply');	
	}
	
	if(result){
	if(order_associated=="Y"){
		for(var i=0;i<parseInt(totalRecords);i++){		
			//for(var i=0;i<parseInt(totalRecords);i++){
				if(eval("formObj.service_code"+i)!=null && eval("formObj.service_code"+i).value!=""  ){	
				if(eval("formObj.catalog_code"+i).value==""){
						message=getMessage("BL8562",'BL'); 	
						alert(message);
						return false;
						//obj=eval("formObj.catalog_code"+i);
				}
				if(eval("formObj.catalog_code"+i).value!="" && eval("formObj.qty_limit"+i).value=="" ){
					message=getMessage("BL8538",'BL'); 	
					alert(message);
					return false;
					//obj=eval("formObj.qty_limit"+i);
				}				
				}	
			//}				
		}		
	}
	message="";
	for(var i=0;i<parseInt(totalRecords);i++){
		if(eval("formObj.service_code"+i)!=null && eval("formObj.service_code"+i).value!=""  ){	
		if(eval("formObj.refund"+i)!=null && eval("formObj.refund"+i).checked  ){		
			if(eval("formObj.refundAmt"+i).value=="" || eval("formObj.refundAmt"+i).value=="Amt"	 )  	{			
				message=getMessage("BL8666",'BL'); 	
			}else if(parseInt(eval("formObj.refundAmt"+i).value)==0 || parseInt(eval("formObj.refundAmt"+i).value)<0)  	{	
				message=getMessage("BL8545",'BL'); 
			}else if(parseInt(eval("formObj.refundAmt"+i).value)<1 || parseInt(eval("formObj.refundAmt"+i).value)>100){
				message=getMessage("BL8653",'BL'); 
			}
			if(message!=""){
				alert(message);
				eval("formObj.refundAmt"+i).focus();
				return false;
			}
		}
		 if(eval("formObj.amt_limit_ind"+i)!=null && eval("formObj.amt_limit_ind"+i).value!="" && eval("formObj.amt_limit_ind"+i).value!="U" &&  (eval("formObj.perAmt_limit"+i).value=="")  )
		{	
			message=getMessage("BL8561",'BL'); 			
			alert(message);
			eval("formObj.perAmt_limit"+i).focus();
			return false;
		}
		message="";
		if(eval("formObj.roundTo"+i).value==null || eval("formObj.roundTo"+i).value=="" || eval("formObj.roundTo"+i).value=="10"  || eval("formObj.roundTo"+i).value=="50"   || eval("formObj.roundTo"+i).value=="100"  || eval("formObj.roundTo"+i).value=="500"  || eval("formObj.roundTo"+i).value=="1000"  )
		{	
			message=""; 			
		}
		else
		{
			message=getMessage("BL8681",'BL'); 	
			obj=eval("formObj.roundTo"+i);
		}
		if(message!=""){
			//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			alert(message);
			obj.focus();
			return false;
		}		
	}
	}

	message="";

	if(acrossEncounters=="Y"){
		closePkgChk=false;	

		for(var i=0;i<parseInt(totalRecords);i++){
			if(eval("formObj.service_code"+i)!=null && eval("formObj.service_code"+i).value!=""  ){
			
				serviceExists=true;			
				if(eval("formObj.closePkg"+i+".value")=="Y"){				
					closePkgChk=true;
					break;
				}
			}			
		}
	}

	if(serviceExists && !closePkgChk){
		alert(getMessage("BL8678",'BL')); 
		
		return false;
	}
	return true;
}else
	return false;
}

function validateBlngGrpServiceLimitForm(srvLimitFormObj,packageCode,index,source){
	//alert('in validate='+index+"/"+srvLimitFormObj.parent_indx.value);
	if(srvLimitFormObj.parent_indx.value!=index){
	var totalRecords=srvLimitFormObj.totalRecords.value;
	var obj;
	var message="";	
	for(var i=0;i<parseInt(totalRecords);i++){

		if(eval("srvLimitFormObj.srvLimit_service_code"+i).value!="" &&  (eval("srvLimitFormObj.exludeService"+i).value=="" || eval("srvLimitFormObj.exludeService"+i).value=="N") ){
			if(eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i)!=null && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value!=""){	
				if((eval("srvLimitFormObj.srvLimit_amt_limit"+i).value=="" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value!="") || (eval("srvLimitFormObj.srvLimit_amt_limit"+i).value!="" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value=="") ){
					message=getMessage("BL8561",'BL'); 			
					alert(message);
					eval("formObj.perAmt_limit"+i).focus();
					return false;
				}
			}else
				if(eval("srvLimitFormObj.srvLimit_amt_limit"+i).value=="" && eval("srvLimitFormObj.srvLimit_qty_limit"+i).value==""){	
						message=getMessage("BL8555",'BL'); 
						if(eval("srvLimitFormObj.srvLimit_qty_limit"+i).disabled)
							obj=eval("srvLimitFormObj.srvLimit_amt_limit"+i);
						else
							obj=eval("srvLimitFormObj.srvLimit_qty_limit"+i);
						alert(message);
						obj.focus();					
						return false;
					}
					
				message="";
				if(eval("srvLimitFormObj.srvLimit_refund"+i)!=null && eval("srvLimitFormObj.srvLimit_refund"+i).checked  ){		
					if(eval("srvLimitFormObj.srvLimit_refundAmt"+i).value=="" || eval("srvLimitFormObj.srvLimit_refundAmt"+i).value=="Amt"	 )  	{			
						message=getMessage("BL8666",'BL'); 	
					}else if(parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"+i).value)==0 || parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"+i).value)<0)  	{	
						message=getMessage("BL8545",'BL'); 
					}else if(parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"+i).value)<1 || parseInt(eval("srvLimitFormObj.srvLimit_refundAmt"+i).value)>100){
						message=getMessage("BL8653",'BL'); 
					}
					if(message !=""){ 		
						alert(message);
						eval("srvLimitFormObj.srvLimit_refundAmt"+i).focus();
						return false;
					}
				}
				message="";

				if(eval("srvLimitFormObj.srvLimit_roundTo"+i).value==null || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="" || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="10" || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="50"  || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="100" || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="500"    || eval("srvLimitFormObj.srvLimit_roundTo"+i).value=="1000"  )
				{	
					message=""; 			
				}
				else
				{
					message=getMessage("BL8681",'BL'); 	
					obj=eval("srvLimitFormObj.srvLimit_roundTo"+i);
				}
				if(message !=""){ 				
							alert(message);
							obj.focus();					
							return false;
				}				
			}
		}
		if(source!="apply"){		
			var updation=formValidation(formBlngGrpXMLStringMain(srvLimitFormObj),"BLNG_GRP_SRVLIMIT_RATE_BASED");
		}
		return true;
	}else{
		return true;
	}
}

function formBlngGrpXMLStringMain(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
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
						val+=arrObj[i].options[j].value +"~";
	            }
		        val= val.substring(0,val.lastIndexOf('~'));
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
	return xmlStr;
}

function blngGrpCallLookup(obj,code,desc,functionId,index)
{	
	var prevCode = eval("document.forms[0].cbCodePrev_"+index);
	var prevDesc = eval("document.forms[0].cbDescPrev_"+index);
	if(obj.value == "")
	{
		clearRow(document.forms[0],index);
		if(functionId=="BLNG_GRP_CHARGE_BASED"){
			var mode =parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
			var currKey=trimString(document.forms[0].blng_grp_code.value+"~~"+document.forms[0].fromDate.value+"~~"+eval("document.forms[0].cbCode_"+index).value);
			var oldSrvKey=eval("document.forms[0].oldSrvKey"+index).value;
			if( oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].blng_grp_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
				removeBeanKey(document.forms[0],oldSrvKey,index);	
				parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
				parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
				parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";
				parent.frames[3].location.href='../../eCommon/html/blank.html';
				parent.frames[4].location.href='../../eCommon/html/blank.html';
				parent.frames[5].location.href='../../eCommon/html/blank.html';
			}	
			eval("document.forms[0].oldSrvKey"+index).value=currKey;
		}
	}
	else 
	{		
		var flag	 = false;
		if(prevCode.value!="" && code.value !=prevCode.value)
		{
			desc.value="";
			prevCode.value = "";
			flag	 = true;
		}
		else if(prevDesc.value!="" && desc.value!=prevDesc.value)
		{
			code.value = "";
			prevDesc.value = "";
			flag	 = true;
		}	
		if(code.value !="" || desc.value!="" || flag)
		{			
			if(functionId=='BLNG_GRP_CHARGE_BASED_ITEM'){
				blngGrpCallServices(code,desc,functionId,'',index);
			}
			else
				{
					blngGrpCallServices(code,desc,functionId,document.getElementById("charge_type"+index),index);				
				}			
		}
	}
	IncludeHomeMedicationBlngGrpGlobal(code,document.getElementById("charge_type"+index),index);  
}

function blngGrpCallServices(code,desc,functionId,charge_type,index,sql)
{
		//alert('blngGrpCallServices');
	var prevCode = eval("document.forms[0].cbCodePrev_"+index);
	var prevDesc = eval("document.forms[0].cbDescPrev_"+index);
	if(code.value =="" || desc.value=="")
	{
		var locale = document.forms[0].locale.value;
		var value = code.value;
		if(desc.value != "")
			value = desc.value;
		var sql = "";

		if(charge_type.value=="S"){
		sql	=  "SELECT   blng_serv_code code, short_desc description FROM bl_blng_serv_lang_vw WHERE language_id = '" +locale +"' AND RATE_ENTRY_BY_USER_FLAG = 'C' and status is null AND UPPER (blng_serv_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY 2 ";
		title=getLabel("Common.BillingService.label","common");
		}
		else if(charge_type.value=="M")	{
		sql	=  "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"+locale+"' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title=getLabel("Common.item.label","common");	
		}
		else  if(functionId=="BLNG_GRP_CHARGE_BASED_ITEM"){
			sql="SELECT a.item_code code, c.long_desc description FROM bl_st_item a,  mm_item_lang_vw c WHERE a.sale_category_code in (select  sale_category_code  from  bl_st_item_sale_catg_dtl where blng_serv_code = '"+document.forms[0].parent_service_code.value+"') and a.item_code = c.item_code AND c.language_id = '"+locale+"' and upper(a.item_code) like upper(?) and upper(long_desc) like upper(?)";
		title =getLabel("Common.service.label","common");
		}
//Newly added by muthu against 28192
		//var title =getLabel("Common.service.label","common");
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
			if(retArray[0] != undefined && retArray[1] != undefined)
			{
				code.value= retArray[0];
				desc.value =  retArray[1];
				prevCode.value = retArray[0];
				prevDesc.value = retArray[1];
				//newly added
				if(functionId=='BLNG_GRP_CHARGE_BASED'){
					if(charge_type.value=="M"){
						//alert("2.3");
					eval("document.forms[0].srvLmt_"+index).disabled=true;
					}else{
						//alert("2.4");
					eval("document.forms[0].srvLmt_"+index).disabled=false;
					}	
				}
			//newly added
			}
			else
			{
				code.value= "";
				desc.value =  "";
				prevCode.value = "";
				prevDesc.value = "";

			}
		}
		else
		{
			clearRow(document.forms[0],index);
		}
		if(code.value != "")
			checkForDuplicate(functionId,code.value,index);
	}
	if(functionId=="BLNG_GRP_CHARGE_BASED"){
		var mode=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
		var currKey=trimString(document.forms[0].blng_grp_code.value+"~~"+document.forms[0].fromDate.value+"~~"+eval("document.forms[0].cbCode_"+index).value);
		var oldSrvKey=eval("document.forms[0].oldSrvKey"+index).value;

		if(oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].blng_grp_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
			removeBeanKey(document.forms[0],oldSrvKey,index);	
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";			
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			parent.frames[4].location.href='../../eCommon/html/blank.html';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
		}	
		eval("document.forms[0].oldSrvKey"+index).value=currKey;
	}
	IncludeHomeMedicationBlngGrpGlobal(code,charge_type,index); 
}

function blngGrpValidForAmtPerUnltd(obj1,obj2,index,serv,noofdecimal)
{	 
	if(obj2.value !="")
	{
		if(obj1.value == "A")
		{
			checkForNegetiveNumber(obj2,noofdecimal,"BL8540");
			if(serv !="BLNG_GRP_CHARGE_BASED" && serv !="BLNG_GRP_PRICE" )
			chkBlngGrpAmt(obj2,index);
			else if(serv =="BLNG_GRP_PRICE")
				blngGrpValidateWithPkgPrice(obj2,index);
		}
		else if(obj1.value == "P" || obj1.value == "R")
		{
			validPercentage(obj2);
			if(serv !="BLNG_GRP_CHARGE_BASED" && serv !="BLNG_GRP_PRICE")
			chkBlngGrpAmtPercent(obj2,index);
		}
		else if(obj1.value == "U")
		{
			obj2.value="";
			obj2.disabled = true;
			if(serv !="BLNG_GRP_CHARGE_BASED")
				chkBlngGrpUnlimited(obj2,index);
		}
	}
	else
	{
	}
}

function blngGrpValidateWithPkgPrice(obj,index)
{
	var pkgPrice	= eval("document.forms[0].price_"+index).value;
	var pkgPriceInd = eval("document.forms[0].indicator_"+index).value;
	var minDepAmt	= obj.value;
	if(pkgPriceInd=="R" && (parseFloat(minDepAmt)>parseFloat(pkgPrice)))
	{
		alert("Minimun deposit should be less than or equal to Package price");
		obj.value="";
		obj.focus();
		//alert(getMessage("BL9306","BL"));
	}
}

function chkBlngGrpAmt(obj,index){
	if(eval("document.forms[0].factor_appl"+index) != undefined)
	{
		eval("document.forms[0].factor_appl"+index).value="";
		eval("document.forms[0].factor_appl"+index).checked=false;
		eval("document.forms[0].factor_appl"+index).disabled=true;
	}
	if(obj.value!=""){			
		if(obj.value>0){
			if(eval("document.forms[0].factor_appl"+index) != undefined)
				eval("document.forms[0].factor_appl"+index).disabled=false;
		}
	}else{
		//eval("document.forms[0].amt_percentage"+index).disabled=false;		
	}
}


function chkBlngGrpAmtPercent(obj,index){
	if(obj.value!=""){
		eval("document.forms[0].factor_appl"+index).value="";
		eval("document.forms[0].factor_appl"+index).checked=false;
		eval("document.forms[0].factor_appl"+index).disabled=true;
	}else{ 
	}	
}

function chkBlngGrpUnlimited(obj,index){
	if(eval("document.forms[0].service_code"+index).value!=""){
		if(obj.value="U"){
			eval("document.forms[0].qty_limit"+index).value="";
			eval("document.forms[0].qty_limit"+index).disabled=true;
			eval("document.forms[0].perAmt_limit"+index).value="";
			eval("document.forms[0].perAmt_limit"+index).disabled=true;			
			eval("document.forms[0].factor_appl"+index).value="";		
			eval("document.forms[0].factor_appl"+index).checked=false;		
			eval("document.forms[0].factor_appl"+index).disabled=true;	
			
		}else{
			eval("document.forms[0].qty_limit"+index).value="";
			eval("document.forms[0].qty_limit"+index).disabled=false;
			if(document.forms[0].order_associated.value=="N"){
				eval("document.forms[0].perAmt_limit"+index).value="";
				eval("document.forms[0].perAmt_limit"+index).disabled=false;			
			}else if(document.forms[0].order_associated.value=="Y"){
				eval("document.forms[0].perAmt_limit"+index).disabled=true;				
			}
			eval("document.forms[0].factor_appl"+index).value="";		
			eval("document.forms[0].factor_appl"+index).checked=false;		
			eval("document.forms[0].factor_appl"+index).disabled=true;	
		}
	}
}

function validPercentageForRefundBlngGrp(obj,autoRefundAmtObj){
	var refundRate=parseFloat(obj.value);
	if(obj.value=="" || obj.value == '0' )
	{
		eval("document.forms[0]."+autoRefundAmtObj).value="N";
		eval("document.forms[0]."+autoRefundAmtObj).checked = false;
	}
	if(refundRate > 100.00 || refundRate<1)	
	{
		alert(getMessage("BL8653","BL"));
		obj.value =  "";
		eval("document.forms[0]."+autoRefundAmtObj).value="N";
		eval("document.forms[0]."+autoRefundAmtObj).checked = false;
		obj.focus();
		return false;
	}
}

function chkBlngGrpRefundCB(obj,index){	
	var noofdecimal=document.forms[0].noofdecimal.value;

	if(obj.checked){	
		obj.value="Y";
		document.getElementById('blng_grp_charge_based_tbl').rows(parseInt(index)+2).cells(7).innerHTML ="<input type='checkbox'  checked name='refund_"+index+"' id='refund_"+index+"' value='Y' onClick='chkBlngGrpRefundCB(this,\""+index+"\")'/><input type='text' name='refundAmt_"+index+"' id='refundAmt_"+index+"' id='refundAmt_"+index+"'  value='' onBlur='return validPercentageForRefundBlngGrp(this,\"autoRefund_"+index+"\")' onkeypress='return ChkNumberInput(this,event,\""+noofdecimal+"\")' size='2' maxlength='4'  >";	
		eval("document.forms[0].autoRefund_"+index).disabled = false;

	}else{
		obj.value="N";	
		
		eval("document.forms[0].autoRefund_"+index).value = "N";
		eval("document.forms[0].autoRefund_"+index).checked = false;
		document.getElementById('blng_grp_charge_based_tbl').rows(parseInt(index)+2).cells(7).innerHTML ="<input type='checkbox'   name='refund_"+index+"' id='refund_"+index+"' value='N' onClick='chkBlngGrpRefundCB(this,\""+index+"\")'/>";	
		eval("document.forms[0].autoRefund_"+index).disabled = true;	
	}
}

function chkBlngGrpAutoRefund(obj,refundAmtObj)
{
	if(eval("document.forms[0]."+refundAmtObj).value=="")
	{
		obj.checked=false;
		obj.value="N";
	}
	else if(obj.checked)
		obj.value="Y";
	else
	  obj.value="N";
}

function blngGrpFactorAppl(obj,index){	
	if(obj.checked){	
		obj.value="Y";			
	}else{
		obj.value="N";		
	}
}

function validateBlngGrpInd(obj,index)
{
	var formObj=document.forms[0];
	if(formObj.name=="blng_grp_srvLimit_rate_based_dtl"){
	 eval("formObj.srvLimit_amt_limit"+index).value="";
			if(obj.value == "A")
			{
			   eval("formObj.srvLimit_factor_appl"+index).disabled=false;
			   eval("formObj.srvLimit_amt_limit"+index).disabled=false;
			}
			else  {
				if( eval("formObj.srvLimit_factor_appl"+index)!= undefined)
					eval("formObj.srvLimit_factor_appl"+index).disabled=true;
				eval("formObj.srvLimit_amt_limit"+index).disabled=true;
				if(obj.value == "R" || obj.value == "P" )
				    eval("formObj.srvLimit_amt_limit"+index).disabled=false;
			}
	}else{
		eval("formObj.perAmt_limit"+index).value="";
		if(obj.value == "U" ||obj.value == "" )
		{
			eval("formObj.perAmt_limit"+index).value="";
			eval("formObj.perAmt_limit"+index).disabled=true;
			if(obj.value == "U" && formObj.name == "blng_grp_rate_based_dtl"){
				eval("formObj.qty_limit"+index).value="";
				eval("formObj.qty_limit"+index).disabled=true;
			}
		}
		else {			
			eval("formObj.perAmt_limit"+index).disabled=false;
			if(formObj.name == "blng_Grp_rate_based_dtl"){
				eval("formObj.qty_limit"+index).disabled=false;
			}			
			if(obj.value == "A")
			   eval("formObj.factor_appl"+index).disabled=false;
			else  {
				if( eval("formObj.factor_appl"+index)!= undefined)
			   eval("formObj.factor_appl"+index).disabled=true;
			}
		}
	}
}

function chkBlngGrpDeleteService(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

function before_blngGrpCatalogLookUp(catalog_desc,catalog_code,service_code,index){
	var formObj=document.blng_grp_rate_based_dtl;
	if(formObj!=null){
		if(eval("formObj.catalog_desc_temp"+index+".value") != eval("formObj.catalog_desc"+index+".value"))
		{
			if(eval("formObj.catalog_desc"+index).value != "")
			 show_blngGrpCatalogLookUp(catalog_desc,catalog_code,service_code,index);
		}
	}
	
}

function blngGrpCatalogLookUp(catalog_desc,catalog_code,service_code,index){

		var formObj=document.blng_grp_rate_based_dtl;
		if(formObj!=null){
			if(eval("formObj.catalog_desc"+index).value == ""){
				show_blngGrpCatalogLookUp(catalog_desc,catalog_code,service_code,index);
			}
		}
	
}

async function show_blngGrpCatalogLookUp(catalog_desc,catalog_code,service_code,index){	
	var formObj=document.blng_grp_rate_based_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.ordercatalog.label","common");
	var local=formObj.locale.value;
	argumentArray[0]	=  "select a.order_catalog_code code,b.short_desc description from bl_order_catalog a, or_order_catalog_lang_vw b where a.order_catalog_code=b.order_catalog_code and a.blng_serv_code='"+service_code.value+"' and b.language_id='"+local+"' and upper(a.order_catalog_code) like upper(?) and upper(b.long_desc) like upper(?)  order by 2  ";
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = catalog_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
 	if(retVal != null && retVal != ""){
   		catalog_desc.value = retVal[1];
 		catalog_code.value =retVal[0] ;
		eval("formObj.catalog_desc_temp"+index).value= retVal[1];
 	}else{
   		catalog_desc.value = "";
   		catalog_code.value = "" ;
		eval("formObj.catalog_desc_temp"+index).value="";
 	}
}

function chkBlngGrpReplace(obj,index){	
	if(obj.checked){		
		document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(14).innerHTML ="<input type='checkbox'  checked name='replace"+index+"' id='replace"+index+"' value='Y' onClick='chkBlngGrpReplace(this,\""+index+"\")'/><a name='replace_dtls"+index+"' href='#' onClick='showBlngGrpReplaceDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a><input type='hidden' name='replaceSrv_code"+index+"' id='replaceSrv_code"+index+"' value=''><input type='hidden' name='replaceSrv_desc"+index+"' id='replaceSrv_desc"+index+"' value=''><input type='hidden' name='replaceSrv_cat_code"+index+"' id='replaceSrv_cat_code"+index+"' value=''><input type='hidden' name='replaceSrv_cat_desc"+index+"' id='replaceSrv_cat_desc"+index+"' value=''>";
	showBlngGrpReplaceDtls(index);
	}else{
		document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(14).innerHTML ="<input type='checkbox'  name='replace"+index+"' id='replace"+index+"' value='N' onClick='chkBlngGrpReplace(this,\""+index+"\")'/><input type='hidden' name='replaceSrv_code"+index+"' id='replaceSrv_code"+index+"' value=''><input type='hidden' name='replaceSrv_desc"+index+"' id='replaceSrv_desc"+index+"' value=''><input type='hidden' name='replaceSrv_cat_code"+index+"' id='replaceSrv_cat_code"+index+"' value=''><input type='hidden' name='replaceSrv_cat_desc"+index+"' id='replaceSrv_cat_desc"+index+"' value=''>";
	}
}

function showBlngGrpReplaceDtls(index){	
	var type=eval("document.blng_grp_rate_based_dtl.type"+index).value;
	var service_code=eval("document.blng_grp_rate_based_dtl.service_code"+index).value;
	var service_desc=eval("document.blng_grp_rate_based_dtl.service_desc"+index).value;
	var order_associated=document.blng_grp_rate_based_dtl.order_associated.value;
	var mode=document.blng_grp_rate_based_dtl.mode.value;
	var authorized=document.blng_grp_rate_based_dtl.authorized.value;
	var pkgApprovedYN=document.blng_grp_rate_based_dtl.pkgApprovedYN.value;
	var catalog_code="";
	var catalog_desc="";
	if(order_associated=="Y"){
		var catalog_code=eval("document.blng_grp_rate_based_dtl.catalog_code"+index).value;
		var catalog_desc=eval("document.blng_grp_rate_based_dtl.catalog_desc"+index).value;
	}
	var replaceSrv_code=eval("document.blng_grp_rate_based_dtl.replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.blng_grp_rate_based_dtl.replaceSrv_desc"+index).value;	
	var replaceSrv_cat_code="";
	var replaceSrv_cat_desc="";
	if(order_associated=="Y"){
		var replaceSrv_cat_code=eval("document.blng_grp_rate_based_dtl.replaceSrv_cat_code"+index).value;
		var replaceSrv_cat_desc=eval("document.blng_grp_rate_based_dtl.replaceSrv_cat_desc"+index).value;
	}
	var queryString = "mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&order_associated="+order_associated+"&type="+type+"&service_code="+service_code+"&service_desc="+service_desc+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&replaceSrv_code="+replaceSrv_code+"&replaceSrv_desc="+replaceSrv_desc+"&replaceSrv_cat_code="+replaceSrv_cat_code+"&replaceSrv_cat_desc="+replaceSrv_cat_desc;
	var retVal = 	new String();
	var dialogHeight= "19" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var arguments	= "" ;
	var title =getLabel("eBL.replaceableService.label","BL");	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	retVal=window.showModalDialog("../../eBL/jsp/PkgDefReplaceableSrv.jsp?"+queryString,arguments,features);
	if(retVal!=null){
		eval("document.blng_grp_rate_based_dtl.replaceSrv_code"+index).value=retVal[0];
		eval("document.blng_grp_rate_based_dtl.replaceSrv_desc"+index).value=retVal[1];
		eval("document.blng_grp_rate_based_dtl.replaceSrv_cat_code"+index).value=retVal[2];
		eval("document.blng_grp_rate_based_dtl.replaceSrv_cat_desc"+index).value=retVal[3];
	}		
}


function loadBlngGrpChargeBasedServiceLimit(value,index)
{	
	var frmObj = parent.blng_grp_charge_based_excl.document.forms[0];
	var packageCode = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;
	var authorized = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.authorized.value;
	var pkgApprovedYN = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.pkgApprovedYN.value;
	var fromDate = document.forms[0].fromDate.value;
	var fromDateTemp = document.forms[0].fromDateTemp.value;
	var blng_grp_code = document.forms[0].blng_grp_code.value;
	var blng_grp_desc = encodeURIComponent(document.forms[0].blng_grp_desc.value);
	var service_desc = encodeURIComponent(eval("document.forms[0].cbDesc_"+index).value);
	var mode = parent.parent.PkgDefBlngGrpHeader.document.forms[0].mode.value;
	
	if(frmObj!=null && frmObj!=undefined)
	{
		var updation=formValidation(formBlngGrpXMLStringMain(frmObj),"BLNG_GRP_CHARGE_BASED_ITEM");
	}	
	if(value == null || value== "" )
	{		alert(getMessage("BL8559",'BL'));
		parent.blng_grp_charge_based_excl_hdr.location.href='../../eCommon/html/blank.html';	
		parent.blng_grp_charge_based_excl.location.href='../../eCommon/html/blank.html';
		parent.blng_grp_charge_based_excl_btn.location.href='../../eCommon/html/blank.html';		
	}else{		
		parent.blng_grp_charge_based_excl_hdr.location.href='../../eCommon/html/blank.html';	
		parent.blng_grp_charge_based_excl.location.href='../../eBL/jsp/PkgDefBlngGrpChargeBasedExclusion.jsp?packageCode='+packageCode+'&service_code='+value+'&mode='+mode+'&fromDate='+encodeURIComponent(fromDate)+'&blng_grp_code='+blng_grp_code+'&blng_grp_desc='+encodeURIComponent(blng_grp_desc)+'&service_desc='+service_desc+'&parent_indx='+index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&fromDateTemp="+encodeURIComponent(fromDateTemp);
		parent.blng_grp_charge_based_excl_btn.location.href='../../eBL/jsp/PkgDefBlngGrpBtn.jsp?packageCode='+packageCode+'&table_name=blng_grp_charge_based_excl_tbl&func_mode=BLNG_GRP_CHARGE_BASED_ITEM&mode='+mode+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN;
	}
}

function blngGrpExcludeItem(obj,index)
{
	if(obj.checked)
	{
		obj.value = "Y";
		eval("document.forms[0].amountLimit_"+index).disabled =true;
		eval("document.forms[0].quantityLimit_"+index).disabled=true;
		eval("document.forms[0].amountLimit_"+index).value="";
		eval("document.forms[0].quantityLimit_"+index).value="";
	}
	else
	{
		obj.value = "N";
  		eval("document.forms[0].amountLimit_"+index).disabled=false;
  		eval("document.forms[0].quantityLimit_"+index).disabled=false;
	}
}

function blngGrpServiceLimitDtls(index){
		var result=true;		
		var fromDate = document.forms[0].fromDate.value;
		var fromDateTemp = document.forms[0].fromDateTemp.value;
		var authorized = document.forms[0].authorized.value;
		var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
		var dailyLmtIndicator = eval("document.blng_grp_rate_based_dtl.dailyLmtIndicator"+index).value;//Added V190731-Aravindh/MMS-DM-CRF-0129.1
		
		if(parent.frames[4].document.forms[0] != null ){
			result=validateBlngGrpServiceLimitForm(parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl,parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value,index,'');		
		}
		if(result){	
			type=eval("document.blng_grp_rate_based_dtl.type"+index).value;
			service_code=eval("document.blng_grp_rate_based_dtl.service_code"+index).value;
			service_desc=eval("document.blng_grp_rate_based_dtl.service_desc"+index).value;
			blng_grp_code=document.blng_grp_rate_based_dtl.blng_grp_code.value;
			blng_grp_desc=document.blng_grp_rate_based_dtl.blng_grp_desc.value;		
			mode=document.blng_grp_rate_based_dtl.mode.value;
			packageCode=parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.packageCode.value;
			copyFrm_pkgCode = "";
			copyFrm_pkgCode=parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.copyFrm_pkgCode.value;			
			parent.frames[3].location.href="../../eBL/jsp/PkgDefBlngGrpExcludeHdr.jsp?mode="+mode+"&packageCode="+packageCode+"&type="+type+"&service_code="+service_code+"&service_desc="+encodeURIComponent(service_desc)+"&parent_indx="+index+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&fromDate="+fromDate+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;	
			parent.frames[4].location.href="../../eBL/jsp/PkgDefBlngGrpExclude.jsp?mode="+mode+"&packageCode="+packageCode+"&type="+type+"&service_code="+service_code+"&service_desc="+encodeURIComponent(service_desc)+"&parent_indx="+index+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&fromDate="+fromDate+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&fromDateTemp="+fromDateTemp+"&dailyLmtInd="+dailyLmtIndicator;//Modified V190731-Aravindh/MMS-DM-CRF-0129.1/Added dailyLmtInd		
			parent.frames[5].location.href="../../eBL/jsp/PkgDefBlngGrpBtn.jsp?table_name=blng_grp_srvLimit_rate_based_tbl&mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN  ;
		}
}

function onBlngGrpSrvLimitServiceTypeChange(obj,index){
	clearRow(document.blng_grp_srvLimit_rate_based_dtl,index);
	eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_service_code"+index).value="";
	eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_service_desc"+index).value="";
	eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_service_desc_temp"+index).value="";	
	eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_replace"+index).disabled=true;
	eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_refund"+index).disabled=true;
}

async function blngGrpSrvLimitCodeLookUp(service_desc,service_code,service_type,index){	
		var formObj=document.blng_grp_srvLimit_rate_based_dtl;
		if(formObj!=null){
			if(eval("formObj.srvLimit_service_code_temp"+index+".value") != eval("formObj.srvLimit_service_code"+index+".value"))
			{
				if(eval("formObj.srvLimit_service_code"+index).value != ""){		
					var argumentArray  = new Array() ;
					var dataNameArray  = new Array() ;
					var dataValueArray = new Array() ;
					var dataTypeArray  = new Array() ;
					var title=getLabel("Common.BillingService.label","common");
					var locale=formObj.locale.value;
					var parent_type=formObj.parent_type.value;
					var parent_service_code=formObj.parent_service_code.value;
					if(service_type.value=="C"){
						argumentArray[0]	=  "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+locale+"' and upper(substr(serv_classification_code,1,2)) = upper('"+parent_service_code+"') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
					title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");
					}else{	
						if(parent_type=="G"){
							argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
						}else if (parent_type=="C"){
							argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
						}
						title=getLabel("Common.BillingService.label","common");
					}
					argumentArray[1]   = dataNameArray ;
					argumentArray[2]   = dataValueArray ;
					argumentArray[3]   = dataTypeArray ;
					argumentArray[4]   = "1,2";
					argumentArray[5]   = service_code.value ;
					argumentArray[6]   = CODE_LINK ;
					argumentArray[7]   = CODE_DESC ;
					retVal = await CommonLookup( title, argumentArray );
					if(retVal != null && retVal != ""){
						service_desc.value = retVal[1];
						service_code.value =retVal[0] ;
						eval("formObj.srvLimit_service_code_temp"+index).value= retVal[0];
						eval("formObj.srvLimit_service_desc_temp"+index).value= retVal[1];		
						eval("formObj.srvLimit_amt_limit"+index).disabled=false;
						eval("formObj.srvLimit_factor_appl"+index).value="";		
						eval("formObj.srvLimit_factor_appl"+index).checked=false;		
						eval("formObj.srvLimit_factor_appl"+index).disabled=true;										
						eval("formObj.srvLimit_qty_limit"+index).disabled=false;								
						eval("formObj.exludeService"+index).disabled=false;
						if(eval("formObj.srvLimit_type"+index).value=="C")
						{
							eval("formObj.srvLimit_replace"+index).disabled=true;
							eval("formObj.srvLimit_refund"+index).disabled=true;
						}else{
							eval("formObj.srvLimit_replace"+index).disabled=false;
							eval("formObj.srvLimit_refund"+index).disabled=false;
						}

					}else{
						service_desc.value = "";
						service_code.value = "" ;
						eval("formObj.srvLimit_service_code_temp"+index).value= "";
						eval("formObj.srvLimit_service_desc_temp"+index).value="";		
						clearRow(formObj,index);
					}
					if(service_code.value != null)
					{
						checkForDuplicate("BLNG_GRP_SRVLIMIT_RATE_BASED",service_code.value,index);		
					}
				}
			}
			IncludeHomeMedicationBlngGrpGlobal(service_code,service_type,index);
		}
}

function before_blngGrpServiceLookUp(service_desc,service_code,service_type,index){
	//alert('before_blngGrpServiceLookUp 1');
	var result=true;
	if(parent.frames[4].document.forms[0] != null ){			
		result=validateBlngGrpServiceLimitForm(parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl,parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value,index,'');			
	}
	var formObj=document.blng_grp_rate_based_dtl;
	if(result){		
		if(formObj!=null){
			if(eval("formObj.service_desc"+index).value == ""){
				clearRow(formObj,index);
				eval("formObj.service_code"+index).value="";			
				eval("formObj.service_desc_temp"+index).value="";	
			}
			if(eval("formObj.service_desc_temp"+index+".value") != eval("formObj.service_desc"+index+".value"))
			{
				clearRow(formObj,index);				
				if(eval("formObj.service_desc"+index).value != ""){					
					show_blngGrpServiceLookUp(service_desc,service_code,service_type,index);
				 }else{
				 	var mode = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
					var currKey=trimString(formObj.blng_grp_code.value+"~~"+formObj.fromDate.value+"~~"+"");
					var oldSrvKey=eval("formObj.oldSrvKey"+index).value;
					if(oldSrvKey!="" && oldSrvKey!=trimString(formObj.blng_grp_code.value+"~~"+formObj.fromDate.value+"~~") && currKey !=oldSrvKey){
						removeBeanKey(formObj,oldSrvKey,index);
						parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
						parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
						parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";						
						parent.frames[3].location.href='../../eCommon/html/blank.html';
						parent.frames[4].location.href='../../eCommon/html/blank.html';
						parent.frames[5].location.href='../../eCommon/html/blank.html';
					}	
					eval("formObj.oldSrvKey"+index).value=currKey;
				 }
			}
			IncludeHomeMedicationBlngGrpGlobal(service_code,service_type,index);
		}
	}else{
		return false;
	}
}

async function show_blngGrpServiceLookUp(service_desc,service_code,service_type,index){
	//alert('blngGrpServiceLookUp 2');
	var formObj=document.blng_grp_rate_based_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingService.label","common");
	//alert('2.1');
	var local=formObj.locale.value;
	var facility_id=formObj.facility_id.value; //V211130
	//alert('2.2='+service_type);
	if(service_type.value=="G"){
	argumentArray[0]	=  "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"+local+"' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
	title=getLabel("eBL.SERVICE_GROUP.label","BL");
	}else if(service_type.value=="C"){
		argumentArray[0]	=  "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+local+"' and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
	title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");
	}else if(service_type.value=="S"){
		argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+local+"' and status is null and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
	title=getLabel("Common.BillingService.label","common");		
	}
// Added By Muthukumar against KDAH-SCF-0057 on 27-4-12
	else{
		argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
	title=getLabel("eBL.PackageGrouping.label","BL");		
	}
// Added By Muthukumar against KDAH-SCF-0057 on 27-4-12
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = service_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
 	if(retVal != null && retVal != ""){
   		service_desc.value = retVal[1];
 		service_code.value =retVal[0] ;
		eval("formObj.service_desc_temp"+index).value= retVal[1];		
		if(formObj.order_associated.value=="Y"){
			eval("formObj.perAmt_limit"+index).disabled=true;			
		}else{	
		}

		if(eval("formObj.factor_appl"+index)!= undefined)
		{
			eval("formObj.factor_appl"+index).value="";		
			eval("formObj.factor_appl"+index).checked=false;		
			eval("formObj.factor_appl"+index).disabled=true;	
		}
			eval("formObj.qty_limit"+index).disabled=false;
		
		if(eval("formObj.type"+index).value=="G" ||  eval("formObj.type"+index).value=="C"){
			eval("formObj.replace"+index).disabled=true;
			eval("formObj.refund"+index).disabled=true;
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(18).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+index+"\")' disabled/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='N' />";			
		}else{						
			eval("formObj.replace"+index).disabled=false;
			eval("formObj.refund"+index).disabled=false;
			if(formObj.acrossEncounters.value=="Y"){							
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(18).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+index+"\")'/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='N' />";
			}
		}

		if(eval("formObj.type"+index).value=="S"){		
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(19).innerHTML="<a name='service_limit_dtls"+index+"' href='#' onClick='blngGrpServiceLimitDtls("+index+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";
		}else{
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(19).innerHTML="<a name='service_limit_dtls"+index+"' href='#' onClick='blngGrpServiceLimitDtls("+index+")'  >"+getLabel('eBL.Dtls.label','BL')+"</a>";
			}			
 	}else{		
		eval("formObj.service_code"+index).value="";	
		eval("formObj.service_desc"+index).value="";	
		eval("formObj.service_desc_temp"+index).value="";	
		clearRow(formObj,index);
 	}

	if(service_code.value  != null)
	{
		checkForDuplicate("BLNG_GRP_RATE_BASED",service_code.value,index);
	}
	var mode=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var currKey=trimString(formObj.blng_grp_code.value+"~~"+formObj.fromDate.value+"~~"+eval("formObj.service_code"+index).value);		
	var oldSrvKey=eval("formObj.oldSrvKey"+index).value;
	if( (oldSrvKey!="") && oldSrvKey!=trimString(formObj.blng_grp_code.value+"~~"+formObj.fromDate.value+"~~") && (currKey !=oldSrvKey)){
		removeBeanKey(formObj,oldSrvKey,index);	
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
		parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";				
		parent.frames[3].location.href='../../eCommon/html/blank.html';
		parent.frames[4].location.href='../../eCommon/html/blank.html';
		parent.frames[5].location.href='../../eCommon/html/blank.html';
	}	
	eval("formObj.oldSrvKey"+index).value=currKey;
}

function blngGrpServiceLookUp(service_desc,service_code,service_type,index){	
	var result=true;
	if(parent.frames[4].document.forms[0] != null ){
		//alert('1');
		result=validateBlngGrpServiceLimitForm(parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl,parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value,index,'');		
	}
	//alert('2');
	var formObj=document.blng_grp_rate_based_dtl;
	//alert('3='+formObj.name);
	if(result){
		//alert('3.1');
		if(formObj!=null){
			//alert('3.2');
			clearRow(formObj,index);
			//alert('4');
			if(eval("formObj.service_desc"+index).value == ""){
				//alert('5');
				show_blngGrpServiceLookUp(service_desc,service_code,service_type,index);
				//alert('6');
			}
			//alert('7');
			IncludeHomeMedicationBlngGrpGlobal(service_code,service_type,index);
			//alert('8');
		}
	}
}

function onBlngGrpIndChange(obj,index){
}

function chkBlngGrpQtyLimit(obj,index){
	if(obj.value!="" && obj.value<1){
		alert(getMessage("BL8538","BL"));
		obj.value =  "";
		return false;
	}
}

async function callBlngGrpBlgCls(blDesc,blCode,index,from)
{
	if(from == "code"  && blCode.value=="" )
		clearRow(document.blng_grp_base_price_dtl,index);
	else if(from == "desc"  && blDesc.value=="" ) 
		clearRow(document.blng_grp_base_price_dtl,index);
	else if(blCode.value=="" || blDesc.value==""){

	var value = blCode.value;
	if(blDesc.value!=null && blDesc.value!="" )
		value = blDesc.value;
	var sql = "";
	var link = "DESC_LINK";
	var odr = "DESC_CODE";
	var episodeAssociated = "";

	var str = "";
	if(parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.IpYn.value=="Y")
	{
		str = " and ( B.PATIENT_CATEGORY_CODE = 'I'";
	}
	if(parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.DcYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'D'";
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'D' ";
	}
	if(parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.OpYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'O' ";
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'O' ";
	}
	if(parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.EmYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'E' ";
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'E' ";
	}
	if( str != "")
		str = str +") ";
	var ordAsociated = parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.orderAssociated.value;
	sql ="select code, description from (select '**' code, 'All Billing Classes' description from dual union all  select A.BLNG_CLASS_CODE code, A.short_DESC description from BL_BLNG_CLASS_LANG_VW A, BL_BLNG_CLASS B where a.BLNG_CLASS_CODE = B.BLNG_CLASS_CODE "+str+" and A.LANGUAGE_ID = '"+document.forms[0].locale.value +"' ) where  upper(code) like upper(?) and upper(description) like upper(?)" ;

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var title=getLabel("Common.BillingClass.label","common");
		var local=document.forms[0].locale.value;
		argumentArray[0]	= sql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ;
		retVal = await CommonLookup( title, argumentArray );
	 	if(retVal != null && retVal != "")
		{
   			blDesc.value = retVal[1];
	 		blCode.value =retVal[0] ;
			checkForDuplicate("BLNG_GRP_PRICE",retVal[0],index);
			if(blCode.value == "**")
				eval("document.forms[0].indicator_"+index).selectedIndex = 0;
 		}
		else
		{
   			blDesc.value = "";
   			blCode.value = "" ;
	 	}
	}
}

function IncludeHomeMedicationBlngGrpGlobal(codeObj,typeObj,index){   //saraa
	var service_code=codeObj.value;
	var type=typeObj.value;
	var includeHomeMedicationAllYN="";
	var IpYn= parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].IpYn.value;
	var DcYn= parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].DcYn.value;
	
	if(IpYn == 'Y' || DcYn == 'Y'){
		$.ajax({
			type:'POST',
			url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+service_code+"&type="+type,
			async:false,
			dataType:"json",
			success : function(data){
				includeHomeMedicationAllYN=$.trim(data.includeHomeMedicationAllYN);
			}
		});
		
		if(includeHomeMedicationAllYN == 'Y' ){
			$('#includeHomeMedication'+index).prop("disabled", false);
			$('#enableDisParam'+index).val('Y');
		}else if(includeHomeMedicationAllYN == 'N'){	
				$('#includeHomeMedication'+index).attr('checked',false);
			$('#includeHomeMedication'+index).prop("disabled", true);
					$('#enableDisParam'+index).val('N');	
		}
	}
	else{
		$('#includeHomeMedication'+index).attr('checked',false);
		$('#includeHomeMedication'+index).prop("disabled", true);
		$('#enableDisParam'+index).val('N');
	}	
}

function IncludeHomeMedicationBlngGrpExclude(obj,code,type,indx){
	var siteSpecf = document.getElementById("siteId").value;
		if(siteSpecf== 'true'){
		if (obj.checked) {
			document.getElementById("includeHomeMedication" + indx).disabled = true;
			document.getElementById("includeHomeMedication" + indx).checked = false;
			document.getElementById("includeHomeMedication" + indx).value = "N";
			document.getElementById("enableDisParam"+indx).value = 'N';
		} else {
			document.getElementById("includeHomeMedication" + indx).disabled = false;
			document.getElementById("enableDisParam"+indx).value = 'Y';
			IncludeHomeMedicationBlngGrpGlobal(code, type, indx);
		}
		}
	}


function includeHomeMedicationEnableBlngGrp(){
	var AllYn=parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].AllYn.value;
	var IpYn= parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].IpYn.value;
	var DcYn= parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].DcYn.value;
	var OpYn= parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].OpYn.value;
	var EmYn=parent.parent.PkgDefBlngGrpHeader.frmPkgDefBlngGrpHeader.document.forms[0].EmYn.value;
	var totrec= document.forms[0].totalRecords.value;
	var i=0; 

	if(!(IpYn == 'Y' || DcYn == 'Y')){
		for(i=0; i<totrec; i++){		
			document.getElementById("includeHomeMedication"+i).disabled = true;
			document.getElementById("includeHomeMedication"+i).checked = false;
			document.getElementById("enableDisParam"+i).value = 'N';
		} 
    }		
}

function before_blngGrpSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
	var formObj=document.blng_grp_srvLimit_rate_based_dtl;
		if(formObj!=null){
			if(eval("formObj.srvLimit_service_desc_temp"+index+".value") != eval("formObj.srvLimit_service_desc"+index+".value"))
			{
				clearRow(formObj,index);
				if(eval("formObj.srvLimit_service_desc"+index).value != "")
					show_blngGrpSrvLimitServiceLookUp(service_desc,service_code,service_type,index);
			}
			IncludeHomeMedicationBlngGrpGlobal(service_code,service_type,index);
		}
	}

function blngGrpSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
		var formObj=document.blng_grp_srvLimit_rate_based_dtl;
			if(formObj!=null){
				clearRow(formObj,index);
				if(eval("formObj.srvLimit_service_desc"+index).value == ""){
					show_blngGrpSrvLimitServiceLookUp(service_desc,service_code,service_type,index);
				}
				IncludeHomeMedicationBlngGrpGlobal(service_code,service_type,index);
			}
}
	
async function show_blngGrpSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
		var formObj=document.blng_grp_srvLimit_rate_based_dtl;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var title=getLabel("Common.BillingService.label","common");
		var locale=formObj.locale.value;
		var facility_id=formObj.facility_id.value; //V211130
		var parent_type=formObj.parent_type.value;	
		var parent_service_code=formObj.parent_service_code.value;
		var parent_service_ind=formObj.parent_service_ind.value;
		if(service_type.value=="C"){		
			argumentArray[0] =   "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+locale+"' and ((upper(substr(serv_classification_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2 " ;
			title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");		
		}else{	
			if(parent_type=="G"){
				if(service_type.value=="S"){				
				 argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"'  and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				 title=getLabel("Common.BillingService.label","common");
			 }else if(service_type.value=="M"){
				 argumentArray[0]	=  "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"+locale+"' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				 title=getLabel("Common.item.label","common");
			 }else if(service_type.value=="P"){
				 argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
				 title=getLabel("eBL.PackageGrouping.label","BL");
			 }		 
			}else if(parent_type =="P"){
			if(service_type.value=="M"){
				 argumentArray[0]	=  "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"+locale+"' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				 title=getLabel("Common.item.label","common");
			 }
			 else if(service_type.value=="S"){			 
				 //argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and ((upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";			
				 //Above is commented by Muthu against the lookup issue and modified as below
				 argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				 title=getLabel("Common.BillingService.label","common");
				}
			else if(service_type.value=="C"){
			 argumentArray[0]	=  "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+locale+"' and upper(substr(serv_classification_code,1,2)) = upper('"+parent_service_code+"') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			 title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");
				}
			else if(service_type.value=='G'){
				argumentArray[0]="select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"+locale+"' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";	
			  title=getLabel("eBL.SERVICE_GROUP.label","BL");
				}
			else if(service_type.value=='T'){
			  argumentArray[0]="select SALE_CATEGORY_CODE code,short_desc description from BL_ST_ITEM_SALE_CATG_HDR where upper(SALE_CATEGORY_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";	
			  title=getLabel("eBL.SalesCategory.label","BL");
				}
			else if(service_type.value=="P"){
				argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
			   title=getLabel("eBL.PackageGrouping.label","BL");
				}			
			}
	//Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Ends Here
			else if (parent_type=="C"){
				argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
				title=getLabel("Common.BillingService.label","common");
				}		
		}
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = service_desc.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		retVal = await CommonLookup( title, argumentArray );
	 	if(retVal != null && retVal != ""){
	   		service_desc.value = retVal[1];
	 		service_code.value =retVal[0] ;
			eval("formObj.srvLimit_service_code_temp"+index).value= retVal[0];
			eval("formObj.srvLimit_service_desc_temp"+index).value= retVal[1];		
			eval("formObj.srvLimit_amt_limit"+index).disabled=false;
			eval("formObj.srvLimit_factor_appl"+index).value="";		
			eval("formObj.srvLimit_factor_appl"+index).checked=false;		
			eval("formObj.srvLimit_factor_appl"+index).disabled=true;				
			eval("formObj.srvLimit_qty_limit"+index).disabled=false;	
			eval("formObj.exludeService"+index).disabled=false;
			if(eval("formObj.srvLimit_type"+index).value=="C")
			{
				eval("formObj.srvLimit_replace"+index).disabled=true;
				eval("formObj.srvLimit_refund"+index).disabled=true;
			}else{
				eval("formObj.srvLimit_replace"+index).disabled=false;
				eval("formObj.srvLimit_refund"+index).disabled=false;
			}
	 	}else{
	   		service_desc.value = "";
	   		service_code.value = "" ;
			eval("formObj.srvLimit_service_code_temp"+index).value= "";
			eval("formObj.srvLimit_service_desc_temp"+index).value="";		
			clearRow(formObj,index);
	 	}
		// Added for duplicate check
		if(service_code.value != null)
		{
			checkForDuplicate("BLNG_GRP_SRVLIMIT_RATE_BASED",service_code.value,index);
		}
	}

function chkBlngGrpExludeService(obj,index){
	var formObj=document.blng_grp_srvLimit_rate_based_dtl;
		if(obj.checked){
			obj.value="Y";
			eval("formObj.srvLimit_qty_limit"+index).value="";
			eval("formObj.srvLimit_qty_limit"+index).disabled=true;
			eval("formObj.srvLimit_amt_limit"+index).value="";	
			eval("formObj.srvLimit_amt_limit"+index).disabled=true;	
			eval("formObj.srvLimit_factor_appl"+index).value="";		
			eval("formObj.srvLimit_factor_appl"+index).checked=false;		
			eval("formObj.srvLimit_factor_appl"+index).disabled=true;
			eval("formObj.srvLimit_roundTo"+index).value="";		
			eval("formObj.srvLimit_roundTo"+index).disabled=true;	
			eval("formObj.srvLimit_roundInd"+index).selectedIndex=0;
			eval("formObj.srvLimit_roundInd"+index).disabled=true;
			eval("formObj.srvLimit_amt_limit_ind"+index).selectedIndex=0;
			eval("formObj.srvLimit_amt_limit_ind"+index).disabled=true;
			if(eval("formObj.srvLimit_type"+index).value=="S")
			{
				document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(12).innerHTML ="<input type='checkbox'  disabled name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='N' onClick='blngGrpSrvLimitChkReplace(this,\""+index+"\")'/><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";
				document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"' disabled value='N' onClick='blngGrpSrvLimitChkRefund(this,\""+index+"\")'/>";
			}
			if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
				eval("formObj.dailyLmtChkBx"+index).disabled = true;
				eval("formObj.dailyLmtChkBx"+index).checked = false;
				eval("formObj.dailyLmtChkBx"+index).value = "N";
				dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.blng_grp_srvLimit_rate_based_dtl);
				eval("formObj.dailyLmtIndicator"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				eval("formObj.dailyLmtIndicator"+index).value = "*";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				eval("formObj.dailyLmtAmt"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				eval("formObj.dailyLmtAmt"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				eval("formObj.dailyLmtQty"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				eval("formObj.dailyLmtQty"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			}
		}else{
			obj.value="N";
			eval("formObj.srvLimit_qty_limit"+index).disabled=false;
			eval("formObj.srvLimit_amt_limit"+index).disabled=false;
			eval("formObj.srvLimit_factor_appl"+index).value="";		
			eval("formObj.srvLimit_factor_appl"+index).checked=false;		
			eval("formObj.srvLimit_factor_appl"+index).disabled=true;	
			eval("formObj.srvLimit_roundTo"+index).value="";
			eval("formObj.srvLimit_roundTo"+index).disabled=false;
			eval("formObj.srvLimit_roundInd"+index).selectedIndex=0;
			eval("formObj.srvLimit_roundInd"+index).disabled=false;
			eval("formObj.srvLimit_amt_limit_ind"+index).selectedIndex=0;
			eval("formObj.srvLimit_amt_limit_ind"+index).disabled=false;
			if(eval("formObj.srvLimit_type"+index).value=="S")
			{
				eval("formObj.srvLimit_replace"+index).disabled=false;
				eval("formObj.srvLimit_refund"+index).disabled=false;
			}
			if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
				eval("formObj.dailyLmtChkBx"+index).disabled = false;
				eval("formObj.dailyLmtChkBx"+index).checked = false;
				eval("formObj.dailyLmtChkBx"+index).value = "N";
				dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.blng_grp_srvLimit_rate_based_dtl);
				eval("formObj.dailyLmtIndicator"+index).disabled = false;
				eval("formObj.dailyLmtIndicator"+index).value = "*";
				if(eval("formObj.amtFldDisabled").value != " disabled ") {
					eval("formObj.dailyLmtAmt"+index).disabled = false;
					eval("formObj.dailyLmtAmt"+index).value = "";
				} 
				if(eval("formObj.qtyFldDisabled").value != " disabled ") {
					eval("formObj.dailyLmtQty"+index).disabled = false;
					eval("formObj.dailyLmtQty"+index).value = "";
				}
			}
		}
	}

function blngGrpSrvLimitChkReplace(obj,index){
	if(obj.checked){
		obj.value = "Y";
		document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(12).innerHTML ="<input type='checkbox'  checked name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='Y' onClick='blngGrpSrvLimitChkReplace(this,\""+index+"\")'/><a name='srvLimit_replace_dtls"+index+"' href='#' onClick='blngGrpSrvLimitShowReplaceDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";
		blngGrpSrvLimitShowReplaceDtls(index);
	}else{
		obj.value = "N";		
		document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(12).innerHTML ="<input type='checkbox'  name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='N' onClick='blngGrpSrvLimitChkReplace(this,\""+index+"\")'/><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";	
	}
}

function blngGrpSrvLimitShowReplaceDtls(index){	
	var type=eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_type"+index).value;
	var service_code=eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_service_code"+index).value;
	var service_desc=eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_service_desc"+index).value;
	var catalog_code="";
	var catalog_desc="";
	var order_associated = "N";
	var mode=document.forms[0].mode.value;
	var authorized=document.forms[0].authorized.value;
	var pkgApprovedYN=document.forms[0].pkgApprovedYN.value;
	var replaceSrv_code=eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"+index).value;	
	var replaceSrv_cat_code="";
	var replaceSrv_cat_desc="";
	var queryString = "mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&order_associated="+order_associated+"&type="+type+"&service_code="+service_code+"&service_desc="+service_desc+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&replaceSrv_code="+replaceSrv_code+"&replaceSrv_desc="+replaceSrv_desc+"&replaceSrv_cat_code="+replaceSrv_cat_code+"&replaceSrv_cat_desc="+replaceSrv_cat_desc;
	var retVal = 	new String();
	var dialogHeight= "19" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var arguments	= "" ;
	var title=getLabel("eBL.replaceableService.label","BL");	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	retVal=window.showModalDialog("../../eBL/jsp/PkgDefReplaceableSrv.jsp?"+queryString,arguments,features);
	if(retVal!=null){	
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"+index).value=retVal[0];
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"+index).value=retVal[1];
	}		
}

function blngGrpSrvLimitChkRefund(obj,index){
	var noofdecimal = document.forms[0].noofdecimal.value;
	if(obj.checked){	
		obj.value="Y";
		document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"' checked value='Y' onClick='blngGrpSrvLimitChkRefund(this,\""+index+"\")'/><input type='text' name='srvLimit_refundAmt"+index+"' id='srvLimit_refundAmt"+index+"' value='' onBlur='validPercentageForRefundBlngGrp(this,\"srvLimit_autoRefund"+index+"\")' onkeypress='return allowValidNumber(this,event,\""+noofdecimal+"\")' size='3' maxlength='4' >";
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).disabled = false;
	}else{
		obj.value="N";
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).value = "N";
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).checked = false;
		eval("document.blng_grp_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).disabled = true;

		document.getElementById('blng_grp_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"'  value='N' onClick='blngGrpSrvLimitChkRefund(this,\""+index+"\")'/>";	
	}
}

function blngGrpSrvLimitFactorAppl(obj,index){	
	if(obj.checked){	
		obj.value="Y";			
	}else{
		obj.value="N";		
	}
}

function chkBlngGrpSrvLimitDeleteService(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

function IncludeHomeMedicationCheckBlngGrpChargeExclude(code,index){
	
	frameObj=parent.frames[1];
	table = frameObj.document.getElementById('blng_grp_charge_based_tbl');
	formObj=frameObj.document.blng_grp_charge_based_dtl;
	var code=document.getElementById("cbCode_"+index).value;
	var type="M";
	var includeHomeMedicationAllYN="";

	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?code="+code+"&type="+"M",
		async:false,
		dataType:"json",
		success : function(data){
			alert(data);
			includeHomeMedicationAllYN=$.trim(data.includeHomeMedicationAllYN);
		}
	});

	if(includeHomeMedicationAllYN == 'Y' &&( OpYn=='N' && EmYn=='N')){
			$('#includeHomeMedication'+index).prop("disabled", false);
			$('#enableDisParam'+index).val('Y');
		}else if(includeHomeMedicationAllYN == 'N'){
			$('#includeHomeMedication'+index).prop("disabled", true);
			$('#enableDisParam'+index).val('N');	
	}
}

function IncludeHomeMedicationCheckBlngGrpCharge(code,index){   
	
	frameObj=parent.frames[1];
	table = frameObj.document.getElementById('blng_grp_charge_based_tbl');
	formObj=frameObj.document.blng_grp_charge_based_dtl;
	var code=document.getElementById("cbCode_"+index).value;
	var type=document.getElementById("charge_type"+index).value;
	var includeHomeMedicationAllYN="";

	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?code="+code+"&type="+type,
		async:false,
		dataType:"json",
		success : function(data){
			alert(data);
			includeHomeMedicationAllYN=$.trim(data.includeHomeMedicationAllYN);
		}
	});
	
		if(includeHomeMedicationAllYN == 'Y' &&( OpYn=='N' && EmYn=='N')){
			$('#includeHomeMedication'+index).prop("disabled", false);
			$('#enableDisParam'+index).val('Y');
		}else if(includeHomeMedicationAllYN == 'N'){
			$('#includeHomeMedication'+index).prop("disabled", true);
			$('#enableDisParam'+index).val('N');
		}
}

function IncludeHomeMedicationCheckBlngGrp(service_desc,index){   //saraa
	
	var formObj=document.blng_grp_rate_based_dtl;
	var service_code=document.getElementById("service_code"+index).value;
	var type=document.getElementById("type"+index).value;
	var includeHomeMedicationAllYN="";
	
	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+service_code+"&type="+type,
		async:false,
		dataType:"json",
		success : function(data){
			includeHomeMedicationAllYN=$.trim(data.includeHomeMedicationAllYN);
		}
	});

	alert("reqId"+includeHomeMedicationAllYN);
			if(includeHomeMedicationAllYN == 'Y' ){
				alert("reqId enabled");
			$('#includeHomeMedication'+index).prop("disabled", false);
			$('#enableDisParam'+index).val('Y');

		}else if(includeHomeMedicationAllYN == 'N'){	
			alert("reqId disabled");
			$('#includeHomeMedication'+index).prop("disabled", true);
			$('#enableDisParam'+index).val('N');		
		}
}

function deleteRowBlngGrp(table_name,cellCount,index)
{	
	var frameObj="";
	var packageCode		= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;	
	var mode			= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var updation=true;

	if(table_name=="blng_grp_rate_based_tbl")
	{
		 frameObj=parent.frames[1];
		table = frameObj.document.getElementById('blng_grp_rate_based_tbl');
		func_mode = "BLNG_GRP_RATE_BASED";			
		del_func_mode = "delete_blng_grp_rate_based";			
		formObj=frameObj.document.blng_grp_rate_based_dtl;

		var packageCode = formObj.packageCode.value;
		var mode = formObj.mode.value;
		var orderAssociated = formObj.order_associated.value;
		var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
		var blng_grp_code = formObj.blng_grp_code.value;
		var blng_grp_desc = formObj.blng_grp_desc.value;			
		var fromDate = formObj.fromDate.value;
		var parent_index = formObj.parent_index.value;
		var authorized = formObj.authorized.value;
		var pkgApprovedYN = formObj.pkgApprovedYN.value;
		var acrossEncounters = formObj.acrossEncounters.value;

		var tempJsp = "../../eBL/jsp/PkgDefBlngGrpRateBased.jsp?packageCode="+packageCode+"&mode="+mode+"&orderAssociated="+orderAssociated+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&acrossEncounters="+acrossEncounters;        
		parent.frames[3].location.href="../../eCommon/html/blank.html";
		parent.frames[4].location.href="../../eCommon/html/blank.html";  
		parent.frames[5].location.href="../../eCommon/html/blank.html";	 
		
	} else if(table_name=="blng_grp_srvLimit_rate_based_tbl") {
			frameObj=parent.frames[4];
			table = frameObj.document.getElementById('blng_grp_srvLimit_rate_based_tbl');
			func_mode = "BLNG_GRP_SRVLIMIT_RATE_BASED";			
			del_func_mode = "";			
			formObj=frameObj.document.blng_grp_srvLimit_rate_based_dtl;

			var packageCode = formObj.packageCode.value;
			var type = formObj.type.value; 
			var mode = formObj.mode.value;
			var service_code = formObj.parent_service_code.value;
			var service_desc = formObj.service_desc.value;
			var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
			var blng_grp_code = formObj.blng_grp_code.value;
			var blng_grp_desc = formObj.blng_grp_desc.value;			
			var fromDate = formObj.fromDate.value;
			var parent_index = formObj.parent_indx.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;
			
			var dailyLmtIndicator = eval("parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl.parDailyLmtInd").value;//Added V191001-Aravindh/MMS-DM-CRF-0129.1/IN071211

			var tempJsp = "../../eBL/jsp/PkgDefBlngGrpExclude.jsp?packageCode="+packageCode+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&type="+type+"&service_code="+service_code
						  +"&mode="+mode+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)
						  +"&service_desc="+encodeURIComponent(service_desc)+"&fromDate="+fromDate
						  +"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN
						  + "&dailyLmtInd="+dailyLmtIndicator;		
	}
	else if(table_name=="blng_grp_charge_based_tbl")
	{
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('blng_grp_charge_based_tbl');
			func_mode = "BLNG_GRP_CHARGE_BASED";			
			del_func_mode = "delete_blng_grp_charge_based";			
			formObj=frameObj.document.blng_grp_charge_based_dtl;				

			var packageCode = formObj.packageCode.value;
			var mode = formObj.mode.value;
			var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
			var blng_grp_code = formObj.blng_grp_code.value;
			var blng_grp_desc = formObj.blng_grp_desc.value;			
			var fromDate = formObj.fromDate.value;
			var parent_index = formObj.parent_index.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;

			var tempJsp = "../../eBL/jsp/PkgDefBlngGrpChargeBased.jsp?packageCode="+packageCode+"&mode="+mode+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;
				
			parent.frames[3].location.href="../../eCommon/html/blank.html";
			parent.frames[4].location.href="../../eCommon/html/blank.html";  
			parent.frames[5].location.href="../../eCommon/html/blank.html";
	}
	else if(table_name=="blng_grp_charge_based_excl_tbl")
	{
			frameObj=parent.frames[4];
			table = frameObj.document.getElementById('blng_grp_charge_based_excl_tbl');
			func_mode = "BLNG_GRP_CHARGE_BASED_ITEM";			
			del_func_mode = "";			
			formObj=frameObj.document.blng_grp_charge_based_excl_dtl;

			var packageCode = formObj.packageCode.value;
			var service_code = formObj.parent_service_code.value;
			var service_desc = formObj.service_desc.value;
			var mode = formObj.mode.value;
			var fromDate = formObj.fromDate.value;
			var blng_grp_code = formObj.blng_grp_code.value;
			var blng_grp_desc = formObj.blng_grp_desc.value;			
			var parent_indx = formObj.parent_indx.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;

			var tempJsp = "../../eBL/jsp/PkgDefBlngGrpChargeBasedExclusion.jsp?packageCode="+packageCode+"&service_code="+service_code+"&mode="+mode+"&blng_grp_code="+blng_grp_code+"&blng_grp_desc="+encodeURIComponent(blng_grp_desc)+"&service_desc="+encodeURIComponent(service_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "packageCode=\"" +packageCode+ "\" " ;
	var fldName="";
	var fldVal="";
	rowCount        = table.rows.length;			
	var j=0;		
	for(var i=2; i<rowCount; i++) 
	{
		var row = table.rows[i];
		var chkbox = row.cells[cellCount].childNodes[0];					
		if(null != chkbox && true == chkbox.checked)
		{
			fldName="key"+j;
			if(table_name=="blng_grp_rate_based_tbl")
			{
				fldVal=trimString(formObj.blng_grp_code.value)+"~~"+trimString(formObj.fromDate.value)+"~~"+trimString(row.cells[1].childNodes[0].value);
			}
			else if(table_name=="blng_grp_charge_based_tbl")
			{
				fldVal=trimString(formObj.blng_grp_code.value)+"~~"+trimString(formObj.fromDate.value)+"~~"+trimString(row.cells[0].childNodes[0].value);
			}
			xmlStr+= " "+fldName+"=\""+fldVal+"\"";
			j++;			
			table.deleteRow(i);
			rowCount--;
			i--;
		}
	}
	xmlStr+= " total_records=\"" +j+ "\" " ;
	xmlStr +=" /></root>";				
	updation=formValidation(formBlngGrpXMLStringMain(formObj),func_mode);	
	if(del_func_mode!="")
	{
		updation=formValidation(xmlStr,del_func_mode);	
	}

	if(table_name=="blng_grp_rate_based_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="blng_grp_charge_based_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="blng_grp_charge_based_excl_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="blng_grp_srvLimit_rate_based_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else 
	{
		frameObj.location.reload();
	}
}


function validateBlngGrpPackageDates(formObj,totalRec)
{ 
	
	var VATappl=eval("formObj.VATapplicable").value;
	for(var i=0;i<totalRec; i++)
	{	
		if(eval("formObj.fromDate_"+i) ==undefined || (eval("formObj.fromDate_"+i).value) =="")
		{
			alert (getMessage("BL8643",'BL'));
			eval("formObj.fromDate_"+i).focus();
			return false;
		}
	
		if(eval("formObj.glSmryYN").value !=undefined && eval("formObj.glSmryYN").value=="Y" && (eval("formObj.glSmry"+i).value==""  || eval("formObj.glSmryDesc"+i).value==""))
		{
			alert (getMessage("BL8636",'BL'));
			eval("formObj.glSmry"+i).value="";
			eval("formObj.glSmry"+i).focus();
			return false;
		}

		if(eval("formObj.glSmryYN").value !=undefined && eval("formObj.glSmryYN").value=="Y" && (eval("formObj.glSmry"+i).value!=""  && eval("formObj.glSmryDesc"+i).value!="") && (eval("formObj.glSmryDisc"+i).value=="" || eval("formObj.glSmryDiscDesc"+i).value==""))
		{
			alert (getMessage("BL8636",'BL'));
			eval("formObj.glSmryDisc"+i).value="";
			eval("formObj.glSmryDisc"+i).focus();
			return false;
		}
		
		if(VATappl=="Y"){
			if( (eval("formObj.VATapp"+i).value=="Y"  && eval("formObj.VATpercent"+i).value==""))
			{
				alert(getMessage("BLSS0072", 'BL'));
				return false;
			}
			if( (eval("formObj.VATapp"+i).value=="Y"  && eval("formObj.ruleCoverageInd"+i).value=="D"))
			{
				alert(getMessage("BLSS0073", 'BL'));
				return false;
			}
		}
	}
	return true;	
}


function validateBlngGrpBaePrice(obj,noofdecimal,msg,index)
{
	checkForNegetiveNumber(obj,noofdecimal,msg);
	if(obj!=null && obj.value !="")
	{
		if(eval("document.forms[0].minDepAmtind_"+index).value=="A")
		blngGrpValidateWithPkgPrice(eval("document.forms[0].minDepAmt_"+index),index);
	}
	else
	{
		eval("document.forms[0].roundTo_"+index).value = "";
		eval("document.forms[0].roundInd_"+index).selectedIndex = 0;
		eval("document.forms[0].minDepAmt_"+index).value = "";
	}
}

function checkBlngGrpDeposit(obj,index)
{
	if(obj.checked)
	{
		eval("document.forms[0].partialDeposit_"+index).disabled = false;
		obj.value = "Y";
	}
	else
	{
		obj.value = "N";
		eval("document.forms[0].partialDeposit_"+index).value = "N";
		eval("document.forms[0].partialDeposit_"+index).checked = false;
		eval("document.forms[0].partialDeposit_"+index).disabled = true;
		eval("document.forms[0].minDepAmt_"+index).value = "";
		eval("document.forms[0].minDepAmt_"+index).disabled = true;
		eval("document.forms[0].minDepAmtind_"+index).value = "";
		eval("document.forms[0].minDepAmtind_"+index).selectedIndex = 0;
		eval("document.forms[0].minDepAmtind_"+index).disabled = true;
	}
}

function initializeBlngGrpRateForm(){
	formObj=document.blng_grp_rate_based_dtl;
	table = document.getElementById('blng_grp_rate_based_tbl');
	rowCount = table.rows.length;		
	index = rowCount-2;
	mode=formObj.mode.value;
	acrossEncounters=formObj.acrossEncounters.value;
	copyFrm_pkgCode = "";
		
	copyFrm_pkgCode=parent.parent.frames[0].document.frmPkgDefBlngGrpHeader.copyFrm_pkgCode.value;
	
	if(mode=="insert" && copyFrm_pkgCode=="" && formObj.service_code0.value==""){
		for(var i=0;i<index;i++)
		{	
			if((eval("formObj.type"+i).value=="G") || (eval("formObj.type"+i).value=="C")){
				if(eval("formObj.service_code"+i).value==""){
					eval("formObj.qty_limit"+i).disabled=true;
				}
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(i)+2).cells(3).innerHTML="<SELECT name='ind"+i+"' id='ind"+i+"' onChange='onBlngGrpIndChange(this,\""+i+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
			}else{		
				eval("formObj.qty_limit"+i).disabled=false;
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(i)+2).cells(3).innerHTML="<SELECT name='ind"+i+"' id='ind"+i+"' onChange='onBlngGrpIndChange(this,\""+i+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='U'>"+getLabel('Common.UserDefined.label','Common')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
			if(acrossEncounters=="Y"){
					document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(i)+2).cells(18).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+i+"\")'/><input type='hidden' name='closePkg"+i+"' id='closePkg"+i+"' value='N' />";
				}
			}			
		}
	}
	else{	
		for(var i=0;i<index;i++)
		{	
			if((eval("formObj.type"+i).value=="G")||(eval("formObj.type"+i).value=="C")||(eval("formObj.type"+i).value=="P")){
				eval("formObj.replace"+i).value="N";
				eval("formObj.replace"+i).checked=false;
				eval("formObj.replace"+i).disabled=true;
				eval("formObj.refund"+i).value="N";
				eval("formObj.refund"+i).checked=false;
				eval("formObj.refund"+i).disabled=true;
				eval("formObj.autoRefund"+i).value="N";
				eval("formObj.autoRefund"+i).checked=false;
				eval("formObj.autoRefund"+i).disabled=true;
			}else{		
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(i)+2).cells(19).innerHTML="<a name='service_limit_dtls"+i+"' href='#' onClick='blngGrpServiceLimitDtls("+i+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";		
			}	
			if(formObj.order_associated.value=="Y"){
				eval("formObj.perAmt_limit"+i).disabled=true;			
				document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(i)+2).cells(19).innerHTML="<a name='service_limit_dtls"+i+"' href='#' onClick='blngGrpServiceLimitDtls("+i+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";
				//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)
				
			}else{		
			}
		
			if(eval("formObj.amt_limit_ind"+i).value!="P"){
				eval("formObj.factor_appl"+i).value="";
				eval("formObj.factor_appl"+i).checked=false;
				eval("formObj.factor_appl"+i).disabled=true;		
			}
			else if(eval("formObj.amt_limit_ind"+i).value!="A")
			{
				if(eval("formObj.perAmt_limit"+i).value>0){
					eval("formObj.factor_appl"+i).disabled=false;
				}else{
				}
			}
			else
			{		
				eval("formObj.factor_appl"+i).disabled=true;
				eval("formObj.qty_limit"+i).value="";
				eval("formObj.qty_limit"+i).disabled=true;
				eval("formObj.factor_appl"+i).value="";		
				eval("formObj.factor_appl"+i).checked=false;		
				eval("formObj.factor_appl"+i).disabled=true;	
	
			}
		}
	}
}

function onBlngGrpServiceTypeChange(obj,index){	
	var result=true;
	if(parent.frames[4].document.forms[0] != null ){		
		result=validateBlngGrpServiceLimitForm(parent.frames[4].document.blng_grp_srvLimit_rate_based_dtl,parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value,index,'');			
	}
	if(result){
		clearRow(document.blng_grp_rate_based_dtl,index);		
		if(document.blng_grp_rate_based_dtl.value == "Y" && obj.value=="S") 
		{
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(18).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"+index+"')\"/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='' />";
		}
		else
		{	 
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(18).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"+index+"')\" disabled/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='' />";
		}
		eval("document.blng_grp_rate_based_dtl.service_code"+index).value="";	
		eval("document.blng_grp_rate_based_dtl.service_desc"+index).value="";	
		eval("document.blng_grp_rate_based_dtl.service_desc_temp"+index).value="";	
		if(obj.value=="G" || obj.value=="C"){		
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(3).innerHTML="<SELECT name='ind"+index+"' id='ind"+index+"' onChange='onBlngGrpIndChange(this,\""+index+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";		
		}else{
			document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(3).innerHTML="<SELECT name='ind"+index+"' id='ind"+index+"' onChange='onBlngGrpIndChange(this,\""+index+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='U'>"+getLabel('Common.UserDefined.label','Common')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
		}	
		var mode=parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
		var currKey=trimString(document.blng_grp_rate_based_dtl.blng_grp_code.value+"~~"+document.blng_grp_rate_based_dtl.fromDate.value+"~~"+eval("document.blng_grp_rate_based_dtl.service_code"+index).value);
		var oldSrvKey=eval("document.blng_grp_rate_based_dtl.oldSrvKey"+index).value;
		if(oldSrvKey!="" && oldSrvKey!=trimString(document.blng_grp_rate_based_dtl.blng_grp_code.value+"~~"+document.blng_grp_rate_based_dtl.fromDate.value+"~~") && currKey !=oldSrvKey){
			removeBeanKey(document.blng_grp_rate_based_dtl,oldSrvKey,index);		
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.last_link.value="";
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form1.value="";
			parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.current_form2.value="";				
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			parent.frames[4].location.href='../../eCommon/html/blank.html';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
		}	
		eval("document.blng_grp_rate_based_dtl.oldSrvKey"+index).value=currKey;
	}	
}


function checkBlngGrpPartialDeposit(obj,index)
{
	if(obj.checked)
	{
		eval("document.forms[0].minDepAmtind_"+index).disabled = false;
		obj.value = "Y";
	}
	else
	{
		eval("document.forms[0].minDepAmt_"+index).value = "";
		eval("document.forms[0].minDepAmtind_"+index).value = "";
		eval("document.forms[0].minDepAmtind_"+index).selectedIndex = 0;
		eval("document.forms[0].minDepAmt_"+index).disabled = true;
		eval("document.forms[0].minDepAmtind_"+index).disabled = true;
		obj.value = "N";
	}
}

function chkBlngGrpRefund(obj,index){	
	var noofdecimal=document.blng_grp_rate_based_dtl.noofdecimal.value	

	if(obj.checked){	
		obj.value="Y";	
		document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(15).innerHTML ="<input type='checkbox' name='refund"+index+"' id='refund"+index+"' checked value='Y' onClick='chklngGrpRefund(this,\""+index+"\")'/><input type='text' name='refundAmt"+index+"' id='refundAmt"+index+"' value='' onBlur='validPercentageForRefundBlngGrp(this,\"autoRefund"+index+"\")' onkeypress='return allowValidNumber(this,event,\""+noofdecimal+"\")' size='2' maxlength='4'  >";
		eval("document.forms[0].autoRefund"+index).disabled = false;

	}else{
		obj.value="N";	
		document.getElementById('blng_grp_rate_based_tbl').rows(parseInt(index)+2).cells(15).innerHTML ="<input type='checkbox' name='refund"+index+"' id='refund"+index+"'  value='N' onClick='chkBlngGrpRefund(this,\""+index+"\")'/>";
		eval("document.forms[0].autoRefund"+index).value = "N";
		eval("document.forms[0].autoRefund"+index).checked = false;
		eval("document.forms[0].autoRefund"+index).disabled = true;
	}
}

function chkBlngGrpExludeServiceonload(){
	var formObj=document.bln_grp_srvLimit_rate_based_dtl;
	var mode			= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var totrec= document.forms[0].totalRecords.value;
	var i=0; 
	if(mode=='modify'){
				for(i=0; i<totrec; i++){
			if(document.getElementById("exludeService" + i).checked == true){
			eval("formObj.includeHomeMedication"+i).disabled=true;
		}else{
			eval("formObj.includeHomeMedication"+i).disabled=false;
		}
		}
	}
}

function removeBeanKey(formObj,oldKey,index){
	var frameObj="";	
	var packageCode		= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.packageCode.value;	
	var mode			= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var result=true;
	var updation=true;
	var func_mode="";
	var del_func_mode="";
	if(formObj.name=="blng_grp_dtls"){
			frameObj=parent.frames[0];
			table = frameObj.document.getElementById('blng_grp_tbl');
			func_mode = "BILLINGGROUP";			
			del_func_mode = "delete_blng_grp";							
	}else if(formObj.name=="blng_grp_period_dtl"){
			frameObj=parent.frames[0];
			table = frameObj.document.getElementById('blng_grp_period_tbl');
			func_mode = "blngGrpPeriod";			
			del_func_mode = "delete_blng_grp_period";			
	}else if(formObj.name=="blng_grp_rate_based_dtl"){
//			frameObj=parent.frames[0]; frame ref changed frames[0] to frames[1]
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('blng_grp_rate_based_tbl');
			func_mode = "BLNG_GRP_RATE_BASED";			
			del_func_mode = "delete_blng_grp_rate_based";				
			//parent.frames[2].location.href="../../eCommon/html/blank.html"; commented and added new lines
			//parent.frames[3].location.href="../../eCommon/html/blank.html";		
			parent.frames[3].location.href="../../eCommon/html/blank.html"; 
			parent.frames[4].location.href="../../eCommon/html/blank.html";
			parent.frames[5].location.href="../../eCommon/html/blank.html";
	}else if(formObj.name=="blng_grp_charge_based_dtl"){				
			frameObj=parent.frames[1]; //frame ref changed to frames[0] to frames[1]
			table = frameObj.document.getElementById('blng_grp_charge_based_tbl');
			func_mode = "BLNG_GRP_CHARGE_BASED";			
			del_func_mode = "delete_blng_grp_charge_based";			
//			parent.frames[2].location.href="../../eCommon/html/blank.html";commented and added new line
//			parent.frames[3].location.href="../../eCommon/html/blank.html";
			
			parent.frames[3].location.href="../../eCommon/html/blank.html"; 
			parent.frames[4].location.href="../../eCommon/html/blank.html";
			parent.frames[5].location.href="../../eCommon/html/blank.html";
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "packageCode=\"" +packageCode+ "\" " ;
	var fldName="";
	var fldVal="";
	xmlStr+="key0=\""+oldKey+"\"";	
	xmlStr+= " total_records=\"1\"" ;
	xmlStr +=" /></root>";	
	//alert(xmlStr)
	//	alert("formValidation 2");			
	updation=formValidation(formBlngGrpXMLStringMain(formObj),func_mode);	
	//alert('del_func_mode='+del_func_mode);
	if(del_func_mode!=""){		
		updation=formValidation(xmlStr,del_func_mode);	
		}
}

function chkBlngGrpChargeExludeServiceonload(){
	var formObj=document.blng_grp_charge_based_excl_dtl;
	var mode			= parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader.mode.value;
	var totrec= document.forms[0].totalRecords.value;
	var i=0; 
	if(mode=='modify'){
				for(i=0; i<totrec; i++){
			if(document.getElementById("inEx_" + i).checked == true){
			eval("formObj.includeHomeMedication"+i).disabled=true;
		}else{
			eval("formObj.includeHomeMedication"+i).disabled=false;
		}
		}
	}
}

