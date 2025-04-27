async function blngGrpCodeLookUp(blng_grp_desc,blng_grp_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_grp_code_temp"+index+".value") != eval("formObj.blng_grp_code"+index+".value"))
		{
			if(eval("formObj.blng_grp_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.BillingGroup.label","common");
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and SETTLEMENT_IND='C' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				argumentArray[0]	=  "select code, description from  ( select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and SETTLEMENT_IND='C' ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blng_grp_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.blng_class_code"+index).value= "";
				eval("formObj.blng_class_desc"+index).value="";	
				eval("formObj.blng_class_code_temp"+index).value= "";
				eval("formObj.blng_class_desc_temp"+index).value="";	
				eval("formObj.eff_from_date"+index).value="";	
				eval("formObj.eff_to_date"+index).value="";							
				eval("formObj.discount_type"+index).selectedIndex= 0;			
				eval("formObj.discount"+index).value= "";						
				if(retVal != null && retVal != ""){
					blng_grp_desc.value = retVal[1];
					blng_grp_code.value =retVal[0] ;
					eval("formObj.blng_grp_code_temp"+index).value= retVal[0];
					eval("formObj.blng_grp_desc_temp"+index).value= retVal[1];
				}else{
					blng_grp_desc.value = "";
					blng_grp_code.value = "" ;	
					eval("formObj.blng_grp_code_temp"+index).value= "";
					eval("formObj.blng_grp_desc_temp"+index).value="";					
				}
			}else{
				clearRow(formObj,index);	
			}
		}
		var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey;
	}
}

function blngGrpDescLookUp(blng_grp_desc,blng_grp_code,index){
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_grp_desc_temp"+index+".value") != eval("formObj.blng_grp_desc"+index+".value"))
		{
			eval("formObj.blng_class_code"+index).value="";	
			eval("formObj.blng_class_desc"+index).value="";	
			eval("formObj.blng_class_code_temp"+index).value="";	
			eval("formObj.blng_class_desc_temp"+index).value="";
			eval("formObj.eff_from_date"+index).value="";	
			eval("formObj.eff_to_date"+index).value="";	
			eval("formObj.discount_type"+index).selectedIndex= 0;					
			eval("formObj.discount"+index).value= "";		
			if(eval("formObj.blng_grp_desc"+index).value != ""){
				show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index);
			}else{
				var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
				
			}
		}
	}
}
function blngGrpLookUp(blng_grp_desc,blng_grp_code,index){
	var formObj=document.blng_grp_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.blng_grp_desc"+index).value == ""){
					show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index);
			}
		}
}
async function show_blngGrpLookUp(blng_grp_desc,blng_grp_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingGroup.label","common");
	var locale=formObj.locale.value;
	
//argumentArray[0]	= "select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and SETTLEMENT_IND='C' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	argumentArray[0]	= "select code, description from  ( select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and SETTLEMENT_IND='C' ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = blng_grp_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	eval("formObj.eff_from_date"+index).value="";	
	eval("formObj.eff_to_date"+index).value="";	
	eval("formObj.blng_class_code"+index).value="";
	eval("formObj.blng_class_desc"+index).value="";
	eval("formObj.blng_class_code_temp"+index).value="";
	eval("formObj.blng_class_desc_temp"+index).value="";
	eval("formObj.discount_type"+index).selectedIndex= 0;			
	eval("formObj.discount"+index).value= "";		
 	if(retVal != null && retVal != ""){
   		blng_grp_desc.value = retVal[1];
 		blng_grp_code.value =retVal[0] ;
		eval("formObj.blng_grp_code_temp"+index).value= retVal[0];
		eval("formObj.blng_grp_desc_temp"+index).value= retVal[1];			
 	}else{
   		clearRow(formObj,index);
		
 	}
	var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}

async function blngClassCodeLookUp(blng_class_desc,blng_class_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_class_code_temp"+index+".value") != eval("formObj.blng_class_code"+index+".value"))
		{
			if(eval("formObj.blng_class_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.BillingClass.label","common");
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				argumentArray[0]	=  "select code, description from  ( select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') ) where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blng_class_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.eff_from_date"+index).value="";	
				eval("formObj.eff_to_date"+index).value="";	
				eval("formObj.discount_type"+index).selectedIndex= 0;			
				eval("formObj.discount"+index).value= "";				
				if(retVal != null && retVal != ""){
					blng_class_desc.value = retVal[1];
					blng_class_code.value =retVal[0] ;
					eval("formObj.blng_class_code_temp"+index).value= retVal[0];
					eval("formObj.blng_class_desc_temp"+index).value= retVal[1];
				}else{
					blng_class_desc.value = "";
					blng_class_code.value = "" ;	
					eval("formObj.blng_class_code_temp"+index).value= "";
					eval("formObj.blng_class_desc_temp"+index).value="";	
					
				}
			}else{
				eval("formObj.blng_class_desc"+index).value= "";
				eval("formObj.blng_class_code"+index).value= "";
				eval("formObj.blng_class_code_temp"+index).value= "";
				eval("formObj.blng_class_desc_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value="";	
				eval("formObj.eff_to_date"+index).value="";	
				eval("formObj.discount_type"+index).selectedIndex= 0;			
				eval("formObj.discount"+index).value= "";		
			
			}
		}
		var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
		var oldKey=eval("formObj.oldKey"+index).value
		if( oldKey!="" && currKey !=oldKey){
			removeDiscountKey(formObj,oldKey,index);			
		}	
		eval("formObj.oldKey"+index).value=currKey
	}
	
}
function blngClassDescLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_class_desc_temp"+index+".value") != eval("formObj.blng_class_desc"+index+".value"))
		{
			eval("formObj.eff_from_date"+index).value="";	
			eval("formObj.eff_to_date"+index).value="";	
			eval("formObj.discount_type"+index).selectedIndex= 0;			
			eval("formObj.discount"+index).value= "";		
			if(eval("formObj.blng_class_desc"+index).value != ""){
				show_blngClassLookUp(blng_class_desc,blng_class_code,index);
			}else{
				var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function blngClassLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.blng_grp_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.blng_class_desc"+index).value == ""){
					show_blngClassLookUp(blng_class_desc,blng_class_code,index);
			}
		}
}
async function show_blngClassLookUp(blng_class_desc,blng_class_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingClass.label","common");
	var locale=formObj.locale.value;
	argumentArray[0]	="";
	argumentArray[4]	="";
	argumentArray[5]	="";
//argumentArray[0]	=  "select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	argumentArray[0]	=  "select code, description from  ( select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = blng_class_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	eval("formObj.eff_from_date"+index).value="";	
	eval("formObj.eff_to_date"+index).value="";	
	eval("formObj.discount_type"+index).selectedIndex= 0;			
	eval("formObj.discount"+index).value= "";		
	
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		blng_class_desc.value = retVal[1];
 		blng_class_code.value =retVal[0] ;
		eval("formObj.blng_class_code_temp"+index).value= retVal[0];
		eval("formObj.blng_class_desc_temp"+index).value= retVal[1];			
 	}else{
   		blng_class_desc.value = "";
   		blng_class_code.value = "" ;
		eval("formObj.blng_class_code_temp"+index).value= "";
		eval("formObj.blng_class_desc_temp"+index).value="";	
	
 	}
	var currKey=trimString(eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
	

}

function chkDiscountAmt(obj,index){
	var formObj=document.forms[0];
	if(obj.value!="" && obj.value>0 && eval("formObj.discount_type"+index).value=="R"){
		validPercentage(obj);
	}else if(obj.value!="" && obj.value>0 && eval("formObj.discount_type"+index).value=="A"){
		putdeci(obj,formObj.noofdecimal.value);
	}
}
function chkDisountType(obj,index){
	var formObj=document.forms[0];
	if(eval("formObj.discount"+index).value!="" && eval("formObj.discount"+index).value>0){
		if(obj.value=="R"){
			validPercentage(eval("formObj.discount"+index));
		}else if(obj.value=="A"){
			putdeci(eval("formObj.discount"+index),formObj.noofdecimal.value);
		}
		
	}
}
function chkDeleteDiscount(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}
function validateDiscountDate(obj,fromDate,toDate,index)
{
	
	var fromDate = eval(fromDate).value;
	var toDate	 = eval(toDate).value;
	var formObj=document.forms[0]
	var locale=formObj.locale.value;

	var	totalRecords=	 formObj.totalRecords.value;
	var pkgEffDate = parent.parent.PkgDefDiscountHeader.document.discount_hdr.effFromDate.value;

	var flag = true;
	if(obj.value!=""){
		if(!(pkgEffDate == null || pkgEffDate==""))
		{
			if(validDiscountDateChk(obj))
			{	 
				if(!(fromDate==null ||  fromDate=="" || toDate==null || toDate=="" ))
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
				
				if(flag && pkgEffDate!="" && obj.value !="" && (!(isAfter(obj.value,pkgEffDate,'DMY',locale))))
				{
					//alert("Date should be greater than or equal to than package effective from date")
					alert(getMessage("BL8512",'BL'));
					
					flag = false;
					obj.value="";
					obj.focus();

				} 
				pkgEffDate = parent.parent.PkgDefDiscountHeader.document.discount_hdr.effToDate.value; 
				//alert((!(isAfter(pakEffDate,obj.value,'DMY',locale))))
				if(flag && pkgEffDate !="" && obj.value !="" && (!(isAfter(pkgEffDate,obj.value,'DMY',locale))))
				{
					//alert("Date should be less than package effective to date")
					alert(getMessage("BL8517",'BL'));
					flag = false;
					obj.value="";
					obj.focus();
				}		  
				if(flag && obj.value !="" && (index>0 || totalRecords>1))
					chkOverLapDiscountDate(totalRecords,obj,index)
			}
		}
		else
		{	
			obj.value="";	
			alert(getMessage("BL8504",'BL'));
			
		}
	} 
	var currKey="";
	if(obj.value != null && obj==eval("formObj.eff_from_date"+index))
	{
		var dupChkStr=""
		if(formObj.name=="blng_grp_discount_dtl"){
			dupChkStr=eval("formObj.blng_grp_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value
			checkForDuplicate("blng_grp_discount",dupChkStr,index);
		
	}else if(formObj.name=="cust_discount_dtl"){
	
		dupChkStr= eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value
		checkForDuplicate("cust_discount",dupChkStr,index);
	}
		var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && dupChkStr !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=dupChkStr
		
	}	
	
	
}

function validDiscountDateChk(obj)
{
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
		if(validDate(obj.value,'DMY',locale))
		{
			var frmObj = ""	;
			if(parent.PkgDefDiscountFrame!= undefined)
				 frmObj = parent.PkgDefDiscountFrame.frames[0].document.forms[0];
			else
				 frmObj = parent.frames[1].document.forms[0];

			if(eval("frmObj.eff_from_date0.value==''"))
				eval("frmObj.eff_from_date0").value = obj.value; 		
		
			return true;
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkOverLapDiscountDate(totalRecords,obj,index)
{
	var formObj= document.forms[0];
	locale = formObj.locale.value;	
	
	var fromCurDate = eval("formObj.eff_from_date"+index).value;
	var toCurDate	=  eval("formObj.eff_to_date"+index).value;
	if (formObj.name!='cust_discount_dtl')
		var blng_grp_code	=  eval("formObj.blng_grp_code"+index).value;
	else
	{
		var cust_grp_code = eval("formObj.cust_grp_code"+index).value;
		var cust_code = eval("formObj.cust_code"+index).value;
	}
	var blng_class_code	=  eval("formObj.blng_class_code"+index).value;
	
	/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
	var siteAgeSpecialty = formObj.SiteAgeSpecialty.value;
	var ageGroupCode = "", specialityCode = "";
	
	if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
		ageGroupCode = eval("formObj.age_group_code"+index).value;
		specialityCode = eval("formObj.specialty_code"+index).value;
	}
	/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */

	for(var i=0;i<totalRecords; i++)
	{
		if(i!=index)
		{
			fromDate = eval("formObj.eff_from_date"+i).value;
			toDate=	 eval("formObj.eff_to_date"+i).value;
			if (formObj.name!='cust_discount_dtl')
				blng_grp_code_temp=	 eval("formObj.blng_grp_code"+i).value;
			else
			{
				cust_grp_code_temp = eval("formObj.cust_grp_code"+i).value;
				cust_code_temp = eval("formObj.cust_code"+i).value;
			}
			blng_class_code_temp=	 eval("formObj.blng_class_code"+i).value;
			
			/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
			var ageGroupCodeTemp = "", specialityCodeTemp = "";
			
			if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
				ageGroupCodeTemp = eval("formObj.age_group_code"+i).value;
				specialityCodeTemp = eval("formObj.specialty_code"+i).value;
			}
			/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */

			//alert(i+" fromCurDate: "+fromCurDate + "toCurDate  :"+toCurDate +" fromDate: "+fromDate + "toDate  :"+toDate)
			if(fromDate!=null && fromDate!="" && toDate!=null && toDate!="")
			{
				if(isBetween(fromDate, toDate, obj.value, 'DMY', locale))
				{	 //alert(1)
					if (formObj.name!='cust_discount_dtl')
					{
						/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
						if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
							if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
									&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
							{	
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */
						} else {
							if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code))
							{	
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
						}
					}
					else
					{
						/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
						if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
							if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
									&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */
						} else {
							if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code) )
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
						}
					}
				}
				else if(fromCurDate!=null && fromCurDate!="" && toCurDate!=null && toCurDate!="")
				{
					if(isBefore(fromCurDate,fromDate, 'DMY', locale) && isAfter(toCurDate,toDate, 'DMY', locale) )
					{	//alert(2)
						//alert(isBefore(fromCurDate,fromDate, 'DMY', locale))
						//alert(isAfter(toCurDate,toDate, 'DMY', locale))
						if (formObj.name!='cust_discount_dtl')
						{
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
							if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
								/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
								if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
										&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
								{
									alert(getMessage("BL8514",'BL'));
									obj.value= "";
									obj.focus();
								}
								/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */
							} else {
								if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code))
								{
									alert(getMessage("BL8514",'BL'));
									obj.value= "";
									obj.focus();
								}
							}
						}
						else
						{
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
							if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
								/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
								if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
										&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
								{
									alert(getMessage("BL8514",'BL'));
									obj.value= "";
									obj.focus();
								}
								/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */
							} else {
								if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code) )
								{
									alert(getMessage("BL8514",'BL'));
									obj.value= "";
									obj.focus();
								}
							}
						}
					}
				}
			}
			else if(fromDate!=null && fromDate!="" && fromCurDate!=null && fromCurDate!="" )
			{
				if(fromDate == fromCurDate )
				{
					if (formObj.name!='cust_discount_dtl')
					{
						/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
						if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
							if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
									&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Else */
						} else {
							if(trimString(blng_grp_code_temp) == trimString(blng_grp_code) && trimString(blng_class_code_temp) == trimString(blng_class_code))
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
						}
					}
					else
					{
						/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Added if-else */
						if(siteAgeSpecialty == "true" || siteAgeSpecialty == true) {
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Starts */
							if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code)
									&& trimString(ageGroupCodeTemp) == trimString(ageGroupCode) && trimString(specialityCodeTemp) == trimString(specialityCode))
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
							/* Added V190321-Aravindh/GHL-CRF-0502-IN70007/Ends */
						} else {
							if(trimString(cust_grp_code_temp) == trimString(cust_grp_code) && trimString(cust_code_temp) == trimString(cust_code) && trimString(blng_class_code_temp) == trimString(blng_class_code) )
							{
								alert(getMessage("BL8514",'BL'));
								obj.value= "";
								obj.focus();
							}
						}
					}
				}
			}
		}
	}
}

function validateDiscountForm(formObj){
	var totalRecords=eval("formObj.totalRecords").value;	
	var SiteAgeSpecialty=formObj.SiteAgeSpecialty.value;
  //Palani on 17-08-2020
	var siteAutoApplyPkgDiscYN=formObj.siteAutoApplyPkgDiscYN.value;	
	var PkgByPolicy=formObj.PkgByPolicy.value;
  //Palani on 17-08-2020
	
	if(formObj.name=="cust_discount_dtl"){
		for(var i=0;i<parseInt(totalRecords);i++){
			if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.cust_code"+i).value==""){
				alert(getMessage("BL8588",'BL'));				
				eval("formObj.cust_code"+i).focus();					
				return false;
			}
			//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 STARTS
			if(siteAutoApplyPkgDiscYN=="true" && PkgByPolicy=="Y"){			
			if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.poly_code"+i).value==""){
				alert(getMessage("BL0862",'BL'));
				eval("formObj.poly_code"+i).focus();					
				return false;
			}
			}			
			//MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 15/6/2020 Ends
			if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.blng_class_code"+i).value==""){
				alert(getMessage("BL8581",'BL'));
				eval("formObj.blng_class_code"+i).focus();					
				return false;
			}				
			//GHL-CRF-0502 Starts
			if(SiteAgeSpecialty=='true'){
				if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.age_group_code"+i).value==""){
					alert(getMessage("BL00228",'BL'));
					eval("formObj.age_group_code"+i).focus();					
					return false;
				}
				if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.specialty_code"+i).value==""){
					alert(getMessage("BL00248",'BL'));
					eval("formObj.specialty_code"+i).focus();					
					return false;
				}
			}
			//GHL-CRF-0502 Ends
			if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.eff_from_date"+i).value==""){
				alert(getMessage("BL8504",'BL'));
				eval("formObj.eff_from_date"+i).focus();					
				return false;
			}
			if(eval("formObj.cust_grp_code"+i).value!="" && eval("formObj.discount"+i).value==""){
				alert(getMessage("BL8589",'BL'));
				eval("formObj.discount"+i).focus();					
				return false;
			}
		}		
	}
	else	if(formObj.name=="blng_grp_discount_dtl"){
		totalRecords=formObj.totalRecords.value;
		for(var i=0;i<parseInt(totalRecords);i++){
			if(eval("formObj.blng_grp_code"+i).value!="" && eval("formObj.blng_class_code"+i).value==""){
				alert(getMessage("BL8581",'BL'));
				eval("formObj.blng_class_code"+i).focus();					
				return false;
			}
			//GHL-CRF-0502 Starts
			if(SiteAgeSpecialty=='true'){
				if(eval("formObj.blng_grp_code"+i).value!="" && eval("formObj.age_group_code"+i).value==""){
					alert(getMessage("BL00228",'BL'));
					eval("formObj.age_group_code"+i).focus();					
					return false;
				}
				if(eval("formObj.blng_grp_code"+i).value!="" && eval("formObj.specialty_code"+i).value==""){
					alert(getMessage("BL00248",'BL'));
					eval("formObj.specialty_code"+i).focus();					
					return false;
				}
			}
			//GHL-CRF-0502 Ends
			if(eval("formObj.blng_grp_code"+i).value!="" && eval("formObj.eff_from_date"+i).value==""){
				alert(getMessage("BL8504",'BL'));
				eval("formObj.eff_from_date"+i).focus();					
				return false
			}
			if(eval("formObj.blng_grp_code"+i).value!="" && eval("formObj.discount"+i).value==""){
				alert(getMessage("BL8589",'BL'));
				eval("formObj.discount"+i).focus();					
				return false;
			}
		}		
	}
	return true;
}

async function custGrpCodeDisLookUp(cust_grp_desc,cust_grp_code,index){	
	var formObj=document.cust_discount_dtl;
	
	if(formObj!=null){
		if(eval("formObj.cust_grp_code_temp"+index+".value") != eval("formObj.cust_grp_code"+index+".value"))
		{
			if(eval("formObj.cust_grp_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";				
				argumentArray[0]	=  "select code, description from  ( select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936				
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = cust_grp_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				if(retVal != null && retVal != ""){
					cust_grp_desc.value = retVal[1];
					cust_grp_code.value =retVal[0] ;
					eval("formObj.cust_grp_code_temp"+index).value= retVal[0];
					eval("formObj.cust_grp_desc_temp"+index).value= retVal[1];					
				}else{
					clearRow(formObj,index);
				}
				
			}
			else{		
				clearRow(formObj,index);
			
			}
			
		}
		var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
		var oldKey=eval("formObj.oldKey"+index).value
		if( oldKey!="" && currKey !=oldKey){
			removeDiscountKey(formObj,oldKey,index);			
		}	
		eval("formObj.oldKey"+index).value=currKey
	
	}
	
}
function custGrpDescDisLookUp(cust_grp_desc,cust_grp_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.cust_grp_desc_temp"+index+".value") != eval("formObj.cust_grp_desc"+index+".value"))
		{	
			eval("formObj.cust_code"+index).value= "";			
			eval("formObj.cust_desc"+index).value= "";	
			eval("formObj.cust_code_temp"+index).value= "";			
			eval("formObj.cust_desc_temp"+index).value= "";			
			eval("formObj.blng_class_code"+index).value= "";				
			eval("formObj.blng_class_desc"+index).value= "";	
			eval("formObj.blng_class_code_temp"+index).value= "";			
			eval("formObj.blng_class_desc_temp"+index).value= "";			
			eval("formObj.eff_from_date"+index).value= "";				
			eval("formObj.eff_to_date"+index).value= "";				
			eval("formObj.discount_type"+index).selectedIndex= 0;				
			eval("formObj.discount"+index).value= "";
      	
      //MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
			eval("formObj.poly_code"+index).value= "";				
			eval("formObj.poly_desc"+index).value= "";
			eval("formObj.poly_code_temp"+index).value= "";				
			eval("formObj.poly_desc_temp"+index).value= "";
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
			if(eval("formObj.cust_grp_desc"+index).value != ""){			
				show_custGrpDisLookUp(cust_grp_desc,cust_grp_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function custGrpDisLookUp(cust_grp_desc,cust_grp_code,index){
	var formObj=document.cust_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.cust_grp_desc"+index).value == ""){
			show_custGrpDisLookUp(cust_grp_desc,cust_grp_code,index);
			}
		}
}
async function show_custGrpDisLookUp(cust_grp_desc,cust_grp_code,index){	
	
	var formObj=document.cust_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	var locale=formObj.locale.value;	
	//argumentArray[0]	=  "select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";	
	argumentArray[0]	=  "select code, description from  (  select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";	//changed for IN020936
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_grp_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
 	if(retVal != null && retVal != ""){
   		cust_grp_desc.value = retVal[1];
 		cust_grp_code.value =retVal[0] ;
		eval("formObj.cust_grp_code_temp"+index).value= retVal[0];
		eval("formObj.cust_grp_desc_temp"+index).value= retVal[1];		
 	}else{
		clearRow(formObj,index);	
 	}
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value)+"~~"+trimString(eval("formObj.cust_code"+index).value)+"~~"+trimString(eval("formObj.blng_class_code"+index).value)+"~~"+trimString(eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value

	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
async function custCodeDisLookUp(cust_desc,cust_code,cust_grp_code,index){
	
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.cust_code_temp"+index+".value") != eval("formObj.cust_code"+index+".value"))
		{
			if(eval("formObj.cust_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.Customers.label","BL");
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2"
				argumentArray[0]	=  "select code, description from  ( select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S')  ) where  upper(code) like upper(?)  and upper(description) like upper(?) order by 2"//changed for IN020936

				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = cust_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.blng_class_code"+index).value="";
				eval("formObj.blng_class_desc"+index).value="";
				eval("formObj.blng_class_code_temp"+index).value="";
				eval("formObj.blng_class_desc_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
				eval("formObj.poly_code"+index).value= "";			
				eval("formObj.poly_desc"+index).value= "";
				eval("formObj.poly_code_temp"+index).value= "";			
				eval("formObj.poly_desc_temp"+index).value= "";
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
				if(retVal != null && retVal != ""){
					cust_desc.value = retVal[1];
					cust_code.value =retVal[0] ;
					eval("formObj.cust_code_temp"+index).value= retVal[0];
					eval("formObj.cust_desc_temp"+index).value= retVal[1];
					//eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+retVal[0]);
				}else{
					cust_desc.value = "";
					cust_code.value = "" ;					
					eval("formObj.cust_code_temp"+index).value= "";
					eval("formObj.cust_desc_temp"+index).value="";
					//eval("formObj.oldKey"+index).value="";
					eval("formObj.blng_class_code"+index).value="";
					eval("formObj.blng_class_desc"+index).value="";
					eval("formObj.blng_class_code_temp"+index).value="";
					eval("formObj.blng_class_desc_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";
					
				}
			}else{
				eval("formObj.cust_code"+index).value= "";			
				eval("formObj.cust_desc"+index).value= "";	
				eval("formObj.cust_code_temp"+index).value= "";
				eval("formObj.cust_desc_temp"+index).value="";				
				eval("formObj.blng_class_code"+index).value= "";				
				eval("formObj.blng_class_desc"+index).value= "";	
				eval("formObj.blng_class_code_temp"+index).value= "";				
				eval("formObj.blng_class_desc_temp"+index).value= "";					
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
				eval("formObj.poly_code"+index).value= "";				
				eval("formObj.poly_desc"+index).value= "";
				eval("formObj.poly_code_temp"+index).value= "";				
				eval("formObj.poly_desc_temp"+index).value= "";
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
			}
		}
	}

	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
function custDescDisLookUp(cust_desc,cust_code,cust_grp_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.cust_desc_temp"+index+".value") != eval("formObj.cust_desc"+index+".value"))
		{
			eval("formObj.blng_class_code"+index).value="";
			eval("formObj.blng_class_desc"+index).value="";
			eval("formObj.blng_class_code_temp"+index).value="";
			eval("formObj.blng_class_desc_temp"+index).value="";
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
			eval("formObj.poly_code"+index).value= "";			
			eval("formObj.poly_desc"+index).value= "";
			eval("formObj.poly_code_temp"+index).value= "";				
			eval("formObj.poly_desc_temp"+index).value= "";
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
			if(eval("formObj.cust_desc"+index).value != ""){
				show_custDisLookUp(cust_desc,cust_code,cust_grp_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function custDisLookUp(cust_desc,cust_code,cust_grp_code,index){
	var formObj=document.cust_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.cust_desc"+index).value == ""){
			show_custDisLookUp(cust_desc,cust_code,cust_grp_code,index);
			}
		}
}
async function show_custDisLookUp(cust_desc,cust_code,cust_grp_code,index){
	
	var formObj=document.cust_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.Customers.label","BL");
	var locale=formObj.locale.value;

	//argumentArray[0]	= "select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2"
	argumentArray[0]	= "select code, description from  (  select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S')  ) where upper(code) like upper(?)  and upper(description) like upper(?) order by 2"//changed for IN020936
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		cust_desc.value = retVal[1];
 		cust_code.value =retVal[0] ;
		eval("formObj.cust_code_temp"+index).value= retVal[0];
		eval("formObj.cust_desc_temp"+index).value= retVal[1];		
		//eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+retVal[0]);		
 	}else{
   		cust_desc.value = "";
   		cust_code.value = "" ;
		eval("formObj.cust_code_temp"+index).value= "";
		eval("formObj.cust_desc_temp"+index).value="";		
		//eval("formObj.oldKey"+index).value="";
		eval("formObj.blng_class_code"+index).value="";
		eval("formObj.blng_class_desc"+index).value="";
		eval("formObj.blng_class_code_temp"+index).value="";
		eval("formObj.blng_class_desc_temp"+index).value="";
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
		//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
		eval("formObj.poly_code"+index).value= "";				
		eval("formObj.poly_desc"+index).value= "";
		eval("formObj.poly_code_temp"+index).value= "";				
		eval("formObj.poly_desc_temp"+index).value= "";
		//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
 	}
	
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 STARTS-->
async function polyCodeDisLookUp(poly_desc,poly_code,index){	
	var formObj=document.cust_discount_dtl;	
	if(formObj!=null){
		if(eval("formObj.poly_code_temp"+index+".value") != eval("formObj.poly_code"+index+".value"))
		{
			if(eval("formObj.poly_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.POLICY.label","BL");
				var facility_id=formObj.facility_id.value;
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";				
				//argumentArray[0]	=  "select code, description from  ( select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936				
				argumentArray[0]	="select description, code  from (select short_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') " + "Union Select 'All Policies','**' From Dual ) Where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = cust_grp_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				
				eval("formObj.blng_class_code"+index).value="";
				eval("formObj.blng_class_desc"+index).value="";
				eval("formObj.blng_class_code_temp"+index).value="";
				eval("formObj.blng_class_desc_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
				eval("formObj.poly_code"+index).value= "";
				eval("formObj.poly_desc"+index).value= "";
				eval("formObj.poly_code_temp"+index).value= "";
				eval("formObj.poly_desc_temp"+index).value= "";
				//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
		/*
    eval("formObj.pkg_code"+index).value= "";				
				eval("formObj.pkg_desc"+index).value= "";	
				eval("formObj.pkg_code_temp"+index).value= "";				
				eval("formObj.pkg_desc_temp"+index).value= "";	*/
				if(retVal != null && retVal != ""){
					poly_desc.value = retVal[1];
			 		poly_code.value = retVal[0] ;
					eval("formObj.poly_code_temp"+index).value= retVal[0];
					eval("formObj.poly_desc_temp"+index).value= retVal[1];	
									
				}
				else{
					poly_desc.value = "";
					poly_code.value = "" ;					
					eval("formObj.poly_code_temp"+index).value= "";
					eval("formObj.poly_desc_temp"+index).value="";
					//eval("formObj.oldKey"+index).value="";
					eval("formObj.blng_class_code"+index).value="";
					eval("formObj.blng_class_desc"+index).value="";
					eval("formObj.blng_class_code_temp"+index).value="";
					eval("formObj.blng_class_desc_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";
					//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->	
				  eval("formObj.poly_code"+index).value= "";	
					eval("formObj.poly_desc"+index).value= "";
					eval("formObj.poly_code_temp"+index).value= "";	
					eval("formObj.poly_desc_temp"+index).value= ""; 
					/*eval("formObj.pkg_code"+index).value= "";				
					eval("formObj.pkg_desc"+index).value= "";	
					eval("formObj.pkg_code_temp"+index).value= "";				
					eval("formObj.pkg_desc_temp"+index).value= "";*/
					//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
				}				
			}else{
				eval("formObj.poly_code"+index).value= "";
				eval("formObj.poly_desc"+index).value= "";
				eval("formObj.poly_code_temp"+index).value= "";	
				eval("formObj.poly_desc_temp"+index).value= "";				
				eval("formObj.blng_class_code"+index).value= "";				
				eval("formObj.blng_class_desc"+index).value= "";	
				eval("formObj.blng_class_code_temp"+index).value= "";				
				eval("formObj.blng_class_desc_temp"+index).value= "";					
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";	
				
			/*	
				eval("formObj.pkg_code"+index).value= "";				
				eval("formObj.pkg_desc"+index).value= "";	
				eval("formObj.pkg_code_temp"+index).value= "";				
				eval("formObj.pkg_desc_temp"+index).value= "";*/
			}
		}
	}
		var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
		var oldKey=eval("formObj.oldKey"+index).value
		if( oldKey!="" && currKey !=oldKey){
			removeDiscountKey(formObj,oldKey,index);			
		}	
		eval("formObj.oldKey"+index).value=currKey
	
	}
	

function polyDescDisLookUp(poly_desc,poly_code,cust_grp_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.poly_desc_temp"+index+".value") != eval("formObj.poly_desc"+index+".value"))
		{	
			
			
			eval("formObj.blng_class_code"+index).value="";
			eval("formObj.blng_class_desc"+index).value="";
			eval("formObj.blng_class_code_temp"+index).value="";
			eval("formObj.blng_class_desc_temp"+index).value="";
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS-->
			eval("formObj.poly_code"+index).value= "";		//		
			eval("formObj.poly_desc"+index).value= "";
			eval("formObj.poly_code_temp"+index).value= "";		//		
			eval("formObj.poly_desc_temp"+index).value= "";
			//MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS-->
			/*eval("formObj.pkg_code"+index).value= "";				
			eval("formObj.pkg_desc"+index).value= "";	
			eval("formObj.pkg_code_temp"+index).value= "";				
			eval("formObj.pkg_desc_temp"+index).value= "";*/
			
			
			if(eval("formObj.cust_grp_desc"+index).value != ""){			
				show_polyDisLookUp(poly_desc,poly_code,cust_grp_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}

function custpolyDisLookUp(poly_desc,poly_code,cust_grp_code,index){
	
	var formObj=document.cust_discount_dtl;

		if(formObj!=null){
			if(eval("formObj.poly_desc"+index).value == ""){
			show_custpolyDisLookUp(poly_desc,poly_code,cust_grp_code,index);
			}
		}
}
async function show_custpolyDisLookUp(poly_desc,poly_code,cust_grp_code,index){	
	

	
	var formObj=document.cust_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	var title=getLabel("eBL.POLICY.label","BL");
	
	var facility_id=formObj.facility_id.value;
	//Added for ICN-73440  14/7/2020 STRATS-->
	var cust_grp_code_temp=formObj.document.getElementById("cust_grp_code_temp"+index).value;
	var cust_code_temp=formObj.document.getElementById("cust_code_temp"+index).value;
	//Added for ICN-73440 ENDS-->
	var locale=formObj.locale.value;
	//argumentArray[0]	=  "select code, description from  (  select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";	//changed for IN020936
	
	//Added for ICN-73440 14/7/2020-->
	argumentArray[0]	="select code, description  from (select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, BL_INS_POLICY_TYPE_HDR b where nvl(a.status,'A') !='S' and a.operating_facility_id = '"+facility_id+"' and upper(a.language_id) = upper('"+locale+"') and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_group_code = '"+cust_grp_code_temp+"' and b.cust_code = '"+cust_code_temp+"' Union Select '**','All Policies' From Dual ) Where upper(code) like upper(?) and upper(description) like upper(?) order by 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	
	argumentArray[4]   = "1,2";
	argumentArray[5]   = poly_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	//alert("return poly 9541");
	retVal = await CommonLookup( title, argumentArray );

 	if(retVal != null && retVal != ""){

   		poly_desc.value = retVal[1];
 		poly_code.value = retVal[0] ;
		eval("formObj.poly_code_temp"+index).value= retVal[0];
		eval("formObj.poly_desc_temp"+index).value= retVal[1];		
 	}else{
 	
 		poly_desc.value = "";
   		poly_code.value = "" ;
		//eval("formObj.cust_code_temp"+index).value= "";
		//eval("formObj.cust_desc_temp"+index).value="";		
		//eval("formObj.oldKey"+index).value="";
   		eval("formObj.poly_code_temp"+index).value= "";		//		
		eval("formObj.poly_desc_temp"+index).value= "";
		eval("formObj.blng_class_code"+index).value="";
		eval("formObj.blng_class_desc"+index).value="";
		eval("formObj.blng_class_code_temp"+index).value="";
		eval("formObj.blng_class_desc_temp"+index).value="";
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
	
 	}
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value)+"~~"+trimString(eval("formObj.cust_code"+index).value)+"~~"+trimString(eval("formObj.blng_class_code"+index).value)+"~~"+trimString(eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value

	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}

//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 ENDS-->

async function custBlngClassCodeLookUp(blng_class_desc,blng_class_code,index){	
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_class_code_temp"+index+".value") != eval("formObj.blng_class_code"+index+".value"))
		{
			if(eval("formObj.blng_class_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.BillingClass.label","common");
				var locale=formObj.locale.value;				
				//argumentArray[0]	=  "select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				argumentArray[0]	=  "select code, description from  (  select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blng_class_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.eff_from_date"+index).value="";	
				eval("formObj.eff_to_date"+index).value="";	
				eval("formObj.discount_type"+index).selectedIndex= 0;			
				eval("formObj.discount"+index).value= "";
				if(retVal != null && retVal != ""){
					blng_class_desc.value = retVal[1];
					blng_class_code.value =retVal[0] ;
					eval("formObj.blng_class_code_temp"+index).value= retVal[0];
					eval("formObj.blng_class_desc_temp"+index).value= retVal[1];
				}else{
					blng_class_desc.value = "";
					blng_class_code.value = "" ;	
					eval("formObj.blng_class_code_temp"+index).value= "";
					eval("formObj.blng_class_desc_temp"+index).value="";	
					eval("formObj.eff_from_date"+index).value="";	
					eval("formObj.eff_to_date"+index).value="";	
					eval("formObj.discount_type"+index).selectedIndex= 0;			
					eval("formObj.discount"+index).value= "";						
				}
			}else{
				eval("formObj.blng_class_desc"+index).value= "";
				eval("formObj.blng_class_code"+index).value= "";
				eval("formObj.blng_class_code_temp"+index).value= "";
				eval("formObj.blng_class_desc_temp"+index).value="";	
				eval("formObj.eff_from_date"+index).value="";	
				eval("formObj.eff_to_date"+index).value="";	
				eval("formObj.discount_type"+index).selectedIndex= 0;			
				eval("formObj.discount"+index).value= "";		
			}
		}
		var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
		var oldKey=eval("formObj.oldKey"+index).value
		if( oldKey!="" && currKey !=oldKey){
			removeDiscountKey(formObj,oldKey,index);			
		}	
		eval("formObj.oldKey"+index).value=currKey
	}
	
}
function custBlngClassDescLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.blng_class_desc_temp"+index+".value") != eval("formObj.blng_class_desc"+index+".value"))
		{
			eval("formObj.eff_from_date"+index).value="";	
			eval("formObj.eff_to_date"+index).value="";	
			eval("formObj.discount_type"+index).selectedIndex= 0;			
			eval("formObj.discount"+index).value= "";		
			if(eval("formObj.blng_class_desc"+index).value != ""){
				show_custBlngClassLookUp(blng_class_desc,blng_class_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function custBlngClassLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.cust_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.blng_class_desc"+index).value == ""){
					show_custBlngClassLookUp(blng_class_desc,blng_class_code,index);
			}
		}
}
async function show_custBlngClassLookUp(blng_class_desc,blng_class_code,index){	
	var formObj=document.cust_discount_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingClass.label","common");
	var locale=formObj.locale.value;
	
//argumentArray[0]	=  "select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
argumentArray[0]	=  "select code, description from  (  select '**' code , 'All Billing Classes' description from dual union all  select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";//changed for IN020936
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = blng_class_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	eval("formObj.eff_from_date"+index).value="";	
	eval("formObj.eff_to_date"+index).value="";	
	eval("formObj.discount_type"+index).selectedIndex= 0;			
	eval("formObj.discount"+index).value= "";		
 	if(retVal != null && retVal != ""){
   		blng_class_desc.value = retVal[1];
 		blng_class_code.value =retVal[0] ;
		eval("formObj.blng_class_code_temp"+index).value= retVal[0];
		eval("formObj.blng_class_desc_temp"+index).value= retVal[1];			
 	}else{
   		blng_class_desc.value = "";
   		blng_class_code.value = "" ;
		eval("formObj.blng_class_code_temp"+index).value= "";
		eval("formObj.blng_class_desc_temp"+index).value="";	
		eval("formObj.eff_from_date"+index).value="";	
		eval("formObj.eff_to_date"+index).value="";	
		eval("formObj.discount_type"+index).selectedIndex= 0;			
		eval("formObj.discount"+index).value= "";				
 	}
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
	

}
function formDiscountXMLStringMain(frmObj)
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
	return xmlStr;
}

function deleteRowDiscount(table_name,cellCount,index){

	var frameObj="";
	
	var packageCode		= parent.parent.PkgDefDiscountHeader.document.discount_hdr.packageCode.value;
	
	var mode			= parent.parent.PkgDefDiscountHeader.document.discount_hdr.mode.value;
	
	var updation=true;
	
	var siteAgeSpecialty = parent.frames[1].document.forms[0].SiteAgeSpecialty.value;//Added V190424-Aravindh/GHL-CRF-0502/Starts
	
	if(table_name=="cust_discount_tbl"){		
//			frameObj=parent.frames[0]; frame rref changed by ram
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('cust_discount_tbl');
			func_mode = "cust_discount";			
			del_func_mode = "delete_cust_discount";			
			formObj=frameObj.document.cust_discount_dtl	;				 
	}
	else if(table_name=="blng_grp_discount_tbl"){		
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('blng_grp_discount_tbl');
			func_mode = "blng_grp_discount";			
			del_func_mode = "delete_blng_grp_discount";			
			formObj=frameObj.document.blng_grp_discount_dtl
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "packageCode=\"" +packageCode+ "\" " ;
	var fldName="";
	var fldVal="";
	rowCount        = table.rows.length;			
	var j=0;		

	for(var i=1; i<rowCount; i++) {

		var row = table.rows[i];
		var chkbox = row.cells[cellCount].childNodes[0];					
		if(chkbox != null && true == chkbox.checked){
			fldName="key"+j;
			if(table_name=="cust_discount_tbl"){
				if(siteAgeSpecialty == "true") {//Added V190424-Aravindh/GHL-CRF-0502/if-else Condition
					fldVal=trimString(row.cells[0].childNodes[0].value)+"~~"+trimString(row.cells[1].childNodes[0].value)+"~~"+trimString(row.cells[2].childNodes[0].value)+"~~"+trimString(row.cells[5].childNodes[0].value)+"~~"+trimString(row.cells[3].childNodes[0].value)+"~~"+trimString(row.cells[4].childNodes[0].value);
				} else {
					fldVal=trimString(row.cells[0].childNodes[0].value)+"~~"+trimString(row.cells[1].childNodes[0].value)+"~~"+trimString(row.cells[2].childNodes[0].value)+"~~"+trimString(row.cells[3].childNodes[0].value)+"~~**~~**";
				}
				
			}else if(table_name=="blng_grp_discount_tbl"){
				if(siteAgeSpecialty == "true") {//Added V190424-Aravindh/GHL-CRF-0502/if-else Condition
					fldVal=trimString(row.cells[0].childNodes[0].value)+"~~"+trimString(row.cells[1].childNodes[0].value)+"~~"+trimString(row.cells[4].childNodes[0].value)+"~~"+trimString(row.cells[2].childNodes[0].value)+"~~"+trimString(row.cells[3].childNodes[0].value);
				} else {
					fldVal=trimString(row.cells[0].childNodes[0].value)+"~~"+trimString(row.cells[1].childNodes[0].value)+"~~"+trimString(row.cells[2].childNodes[0].value)+"~~**~~**";
				}
			}
			xmlStr+= " "+fldName+"=\""+fldVal+"\"";
			j++;			
			
			table.deleteRow(i);
			rowCount--;
			i--;
		}
	}
	//formObj.totalRecords.value= rowCount-2;	
	xmlStr+= " total_records=\"" +j+ "\" " ;
	xmlStr +=" /></root>";	
	updation=formValidation(formDiscountXMLStringMain(formObj),func_mode);	
	if(del_func_mode!="")
		updation=formValidation(xmlStr,del_func_mode);	
	frameObj.location.reload();
}

function removeDiscountKey(formObj,oldKey,index){	
	var frameObj="";	
	var packageCode		= parent.parent.PkgDefDiscountHeader.document.discount_hdr.packageCode.value;	
	var mode			= parent.parent.PkgDefDiscountHeader.document.discount_hdr.mode.value;
	var result=true;
	var updation=true;
	var func_mode="";
	var del_func_mode="";
	if(formObj.name=="cust_discount_dtl"){
//			frameObj=parent.frames[0]; changed frames ref by ram
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('cust_discount_tbl');
			func_mode = "cust_discount";			
			del_func_mode = "delete_cust_discount";							
	}else if(formObj.name=="blng_grp_discount_dtl"){
//			frameObj=parent.frames[0]; changed frames ref by ram
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('blng_grp_discount_tbl');
			func_mode = "blng_grp_discount";			
			del_func_mode = "delete_blng_grp_discount";			
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "packageCode=\"" +packageCode+ "\" " ;
	var fldName="";
	var fldVal="";
	xmlStr+="key0=\""+oldKey+"\"";	
	xmlStr+= " total_records=\"1\"" ;
	xmlStr +=" /></root>";	
	//alert(xmlStr)
	updation=formValidation(formDiscountXMLStringMain(formObj),func_mode);	

	if(del_func_mode!=""){
		updation=formValidation(xmlStr,del_func_mode);	
		}

}

//GHL-CRF-0502 Starts for AgeGroup - Customer
async function AgeGroupCodeLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.cust_discount_dtl;
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	if(formObj!=null){
		if(eval("formObj.age_group_temp"+index+".value") != eval("formObj.age_group_code"+index+".value"))
		{
			if(eval("formObj.age_group_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.HCMasterAgeGroup.label","BL");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "SELECT code,description from (SELECT short_desc description, age_group_code code FROM bl_age_group WHERE operating_facility_id = '"+
				facility_id+"' AND trunc(NVL (eff_to_date, SYSDATE)) >= TRUNC (SYSDATE) UNION SELECT 'All Age Group' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)";

				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = age_group_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				if(retVal != null && retVal != ""){
					hdn_age_group.value = retVal[1];
					age_group_code.value =retVal[0] ;
					eval("formObj.age_group_temp"+index).value= retVal[0];
					eval("formObj.hdn_age_group_temp"+index).value= retVal[1];
				}else{
					hdn_age_group.value = "";
					age_group_code.value = "" ;					
					eval("formObj.age_group_temp"+index).value="";
					eval("formObj.hdn_age_group_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";					
				}
			}else{				
				eval("formObj.age_group_temp"+index).value="";
				eval("formObj.hdn_age_group_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";				
			}
		}
	}

	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
function AgeGroupDescLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.hdn_age_group_temp"+index+".value") != eval("formObj.hdn_age_group"+index+".value"))
		{			
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			if(eval("formObj.hdn_age_group"+index).value != ""){
				show_AgeGroupLookUp(hdn_age_group,age_group_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function AgeGroupLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.cust_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.hdn_age_group"+index).value == ""){
			show_AgeGroupLookUp(hdn_age_group,age_group_code,index);
			}
		}
}
async function show_AgeGroupLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.cust_discount_dtl;
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var title=getLabel("eBL.HCMasterAgeGroup.label","BL");
	var locale=formObj.locale.value;

	argumentArray[0]	= "SELECT code,description from (SELECT short_desc description, age_group_code code FROM bl_age_group WHERE operating_facility_id = '"+
	facility_id+"' AND NVL (eff_to_date, SYSDATE) >= TRUNC (SYSDATE) UNION SELECT 'All Age Group' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)"
	argumentArray[1]   = dataNameArray;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = hdn_age_group.value;
	argumentArray[6]   = DESC_LINK;
	argumentArray[7]   = CODE_DESC;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		hdn_age_group.value = retVal[1];
 		age_group_code.value =retVal[0];		
		eval("formObj.age_group_temp"+index).value= retVal[0];
		eval("formObj.hdn_age_group_temp"+index).value= retVal[1];
 	}else{
   		hdn_age_group.value = "";
   		age_group_code.value = "" ;		
		eval("formObj.hdn_age_group_temp"+index).value="";
		eval("formObj.specialty_code_temp"+index).value="";
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
 	}
	
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
//GHL-CRF-0502 Ends for AgeGroup - Customer

//GHL-CRF-0502 Starts for Specialty - Customer
async function specialtyCodeLookUp(specialty_desc,specialty_code,index){	
	var formObj=document.cust_discount_dtl;
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	if(formObj!=null){
		if(eval("formObj.specialty_code_temp"+index+".value") != eval("formObj.specialty_code"+index+".value"))
		{
			if(eval("formObj.specialty_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.speciality.label","Common");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "SELECT code, description from (SELECT short_desc description, speciality_code code FROM am_speciality UNION SELECT 'All Specialty' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)";

				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = specialty_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );				
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				if(retVal != null && retVal != ""){
					specialty_desc.value = retVal[1];
					specialty_code.value =retVal[0] ;
					eval("formObj.specialty_code_temp"+index).value= retVal[0];
					eval("formObj.specialty_desc_temp"+index).value= retVal[1];
				}else{
					specialty_desc.value = "";
					specialty_code.value = "";					
					eval("formObj.specialty_code_temp"+index).value="";
					eval("formObj.specialty_desc_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";					
				}
			}else{				
				eval("formObj.specialty_code_temp"+index).value="";
				eval("formObj.specialty_desc_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";				
			}
		}
	}

	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
function specialtyDescLookUp(specialty_desc,specialty_code,index){
	var formObj=document.cust_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.specialty_desc_temp"+index+".value") != eval("formObj.specialty_desc"+index+".value"))
		{
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			if(eval("formObj.specialty_desc"+index).value != ""){
				show_specialtyLookUp(specialty_desc,specialty_code,index);
			}else{
				var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function specialtyLookUp(specialty_desc,specialty_code,index){
	var formObj=document.cust_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.specialty_desc"+index).value == ""){
			show_specialtyLookUp(specialty_desc,specialty_code,index);
			}
		}
}
async function show_specialtyLookUp(specialty_desc,specialty_code,index){	
	var formObj=document.cust_discount_dtl;
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var title=getLabel("Common.speciality.label","Common");
	var locale=formObj.locale.value;

	argumentArray[0]	= "SELECT code, description from (SELECT short_desc description, speciality_code code FROM am_speciality UNION SELECT 'All Specialty' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)"
	argumentArray[1]   = dataNameArray;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = specialty_desc.value;
	argumentArray[6]   = DESC_LINK;
	argumentArray[7]   = CODE_DESC;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		specialty_desc.value = retVal[1];
 		specialty_code.value =retVal[0];
		eval("formObj.specialty_code_temp"+index).value= retVal[0];
		eval("formObj.specialty_desc_temp"+index).value= retVal[1];
 	}else{
   		specialty_desc.value = "";
   		specialty_code.value = "" ;
		eval("formObj.hdn_age_group_temp"+index).value="";
		eval("formObj.specialty_code_temp"+index).value="";		
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
 	}
	
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value+"~~"+eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
//GHL-CRF-0502 Ends for Specialty - Customer

//GHL-CRF-0502 Starts for AgeGroup - Billing Group
async function AgeGrpBLCodeLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.blng_grp_discount_dtl;
	var locale = document.forms[0].locale.value;
    	var facility_id = document.forms[0].facility_id.value;	
	if(formObj!=null){
		if(eval("formObj.age_group_temp"+index+".value") != eval("formObj.age_group_code"+index+".value"))
		{
			if(eval("formObj.age_group_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.HCMasterAgeGroup.label","BL");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "SELECT code,description from (SELECT short_desc description, age_group_code code FROM bl_age_group WHERE operating_facility_id = '"+
				facility_id+"' AND NVL (eff_to_date, SYSDATE) >= TRUNC (SYSDATE) UNION SELECT 'All Age Group' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)";

				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = age_group_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );				
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				if(retVal != null && retVal != ""){
					hdn_age_group.value = retVal[1];
					age_group_code.value =retVal[0] ;
					eval("formObj.age_group_temp"+index).value= retVal[0];
					eval("formObj.hdn_age_group_temp"+index).value= retVal[1];
				}else{
					hdn_age_group.value = "";
					age_group_code.value = "" ;					
					eval("formObj.age_group_temp"+index).value="";
					eval("formObj.hdn_age_group_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";					
				}
			}else{				
				eval("formObj.age_group_temp"+index).value="";
				eval("formObj.hdn_age_group_temp"+index).value="";
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";				
			}
		}
	}

	var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
function AgeGrpBLDescLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.hdn_age_group_temp"+index+".value") != eval("formObj.hdn_age_group"+index+".value"))
		{		
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			if(eval("formObj.hdn_age_group"+index).value != ""){
				show_AgeGrpBLLookUp(hdn_age_group,age_group_code,index);
			}else{
				var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}
function AgeGrpBLLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.blng_grp_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.hdn_age_group"+index).value == ""){
			show_AgeGrpBLLookUp(hdn_age_group,age_group_code,index);
			}
		}
}
async function show_AgeGrpBLLookUp(hdn_age_group,age_group_code,index){
	var formObj=document.blng_grp_discount_dtl;
	var locale = document.forms[0].locale.value;
    	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var title=getLabel("eBL.HCMasterAgeGroup.label","BL");
	var locale=formObj.locale.value;

	argumentArray[0]	= "SELECT code,description from (SELECT short_desc description, age_group_code code FROM bl_age_group WHERE operating_facility_id = '"+
	facility_id+"' AND trunc(NVL (eff_to_date, SYSDATE)) >= TRUNC (SYSDATE) UNION SELECT 'All Age Group' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)"
	argumentArray[1]   = dataNameArray;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = hdn_age_group.value;
	argumentArray[6]   = DESC_LINK;
	argumentArray[7]   = CODE_DESC;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		hdn_age_group.value = retVal[1];
 		age_group_code.value =retVal[0];		
		eval("formObj.age_group_temp"+index).value= retVal[0];
		eval("formObj.hdn_age_group_temp"+index).value= retVal[1];
 	}else{
   		hdn_age_group.value = "";
   		age_group_code.value = "";		
		eval("formObj.hdn_age_group_temp"+index).value="";
		eval("formObj.specialty_code_temp"+index).value="";
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
 	}
	
	var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
//GHL-CRF-0502 Ends for AgeGroup - Billing Group

//GHL-CRF-0502 Starts for Specialty - Billing Group
async function specialtyCodeBLLookUp(specialty_desc,specialty_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	if(formObj!=null){
		if(eval("formObj.specialty_code_temp"+index+".value") != eval("formObj.specialty_code"+index+".value"))
		{
			if(eval("formObj.specialty_code"+index).value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.speciality.label","Common");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "SELECT code, description from (SELECT short_desc description, speciality_code code FROM am_speciality UNION SELECT 'All Specialty' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)";

				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = specialty_code.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );				
				eval("formObj.eff_from_date"+index).value="";
				eval("formObj.eff_to_date"+index).value="";
				eval("formObj.discount_type"+index).selectedIndex=0;
				eval("formObj.discount"+index).value="";
				if(retVal != null && retVal != ""){
					specialty_desc.value = retVal[1];
					specialty_code.value =retVal[0] ;
					eval("formObj.specialty_code_temp"+index).value= retVal[0];
					eval("formObj.specialty_desc_temp"+index).value= retVal[1];
				}else{
					specialty_desc.value = "";
					specialty_code.value = "";					
					eval("formObj.specialty_code_temp"+index).value="";
					eval("formObj.specialty_desc_temp"+index).value="";
					eval("formObj.eff_from_date"+index).value="";
					eval("formObj.eff_to_date"+index).value="";
					eval("formObj.discount_type"+index).selectedIndex=0;
					eval("formObj.discount"+index).value="";					
				}
			}else{
				eval("formObj.specialty_code_temp"+index).value="";
				eval("formObj.specialty_desc_temp"+index).value="";			
				eval("formObj.eff_from_date"+index).value= "";				
				eval("formObj.eff_to_date"+index).value= "";				
				eval("formObj.discount_type"+index).selectedIndex= 0;				
				eval("formObj.discount"+index).value= "";				
			}
		}
	}

	var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
function specialtyDescBLLookUp(specialty_desc,specialty_code,index){
	var formObj=document.blng_grp_discount_dtl;
	if(formObj!=null){
		if(eval("formObj.specialty_desc_temp"+index+".value") != eval("formObj.specialty_desc"+index+".value"))
		{			
			eval("formObj.eff_from_date"+index).value="";
			eval("formObj.eff_to_date"+index).value="";
			eval("formObj.discount_type"+index).selectedIndex=0;
			eval("formObj.discount"+index).value="";
			if(eval("formObj.specialty_desc"+index).value != ""){
				show_specialtyBLLookUp(specialty_desc,specialty_code,index);
			}else{
				var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
				var oldKey=eval("formObj.oldKey"+index).value
				if( oldKey!="" && currKey !=oldKey){
					removeDiscountKey(formObj,oldKey,index);			
				}	
				eval("formObj.oldKey"+index).value=currKey
			}
		}
	}
}

function specialtyBLLookUp(specialty_desc,specialty_code,index){
	var formObj=document.blng_grp_discount_dtl;
		if(formObj!=null){
			if(eval("formObj.specialty_desc"+index).value == ""){
			show_specialtyBLLookUp(specialty_desc,specialty_code,index);
			}
		}
}

async function show_specialtyBLLookUp(specialty_desc,specialty_code,index){	
	var formObj=document.blng_grp_discount_dtl;
	var locale = document.forms[0].locale.value;
    	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var title=getLabel("Common.speciality.label","Common");
	var locale=formObj.locale.value;

	argumentArray[0]	= "SELECT code, description from (SELECT short_desc description, speciality_code code FROM am_speciality UNION SELECT 'All Specialty' description, '**' code FROM DUAL) WHERE upper(code) like upper(?) and upper(description) like upper(?)"
	argumentArray[1]   = dataNameArray;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = specialty_desc.value;
	argumentArray[6]   = DESC_LINK;
	argumentArray[7]   = CODE_DESC;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		specialty_desc.value = retVal[1];
 		specialty_code.value =retVal[0];		
		eval("formObj.specialty_code_temp"+index).value= retVal[0];
		eval("formObj.specialty_desc_temp"+index).value= retVal[1];
 	}else{
   		specialty_desc.value = "";
   		specialty_code.value = "" ;	
		eval("formObj.hdn_age_group_temp"+index).value="";
		eval("formObj.specialty_code_temp"+index).value="";
		eval("formObj.eff_from_date"+index).value="";
		eval("formObj.eff_to_date"+index).value="";
		eval("formObj.discount_type"+index).selectedIndex=0;
		eval("formObj.discount"+index).value="";
 	}	
	var currKey=trimString(eval("formObj.blng_class_code"+index).value+"~~"+eval("formObj.eff_from_date"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
	if( oldKey!="" && currKey !=oldKey){
		removeDiscountKey(formObj,oldKey,index);			
	}	
	eval("formObj.oldKey"+index).value=currKey
}
//GHL-CRF-0502 Ends for Specialty - Billing Group
