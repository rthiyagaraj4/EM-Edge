 /*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
*/
function deleteRowCust(table_name,cellCount,index)
{
	var frameObj="";
	var packageCode		= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
	
	var mode			= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value;
	//var orderAssociated = parent.parent.PkgDefHeader.document.frmPkgDefHeader.orderAssociated.value;
	var updation=true;

	if(table_name=="cust_rate_based_tbl")
	{
			//frameObj=parent.frames[0]; changed frame ref ram
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('cust_rate_based_tbl');
			func_mode = "CUST_RATE_BASED";			
			del_func_mode = "delete_cust_rate_based";			
			formObj=frameObj.document.cust_rate_based_dtl;

			var packageCode = formObj.packageCode.value;
			var mode = formObj.mode.value;
			var orderAssociated = formObj.order_associated.value;
			var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
			var cust_grp_code = formObj.cust_grp_code.value;
			var cust_grp_desc = formObj.cust_grp_desc.value;
			var cust_code = formObj.cust_code.value;
			var cust_desc = formObj.cust_desc.value;
			var fromDate = formObj.fromDate.value;
			var parent_index = formObj.parent_index.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;
			var acrossEncounters = formObj.acrossEncounters.value;

			var tempJsp = "../../eBL/jsp/PkgDefCustRateBased.jsp?packageCode="+packageCode+"&mode="+mode+"&orderAssociated="+orderAssociated+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)+"&cust_desc="+encodeURIComponent(cust_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&acrossEncounters="+acrossEncounters;

/*			parent.frames[2].location.href="../../eCommon/html/blank.html";
			parent.frames[3].location.href="../../eCommon/html/blank.html";  changed frame ref ram and added new frame ref*/
			parent.frames[3].location.href="../../eCommon/html/blank.html";
			parent.frames[4].location.href="../../eCommon/html/blank.html";  
			parent.frames[5].location.href="../../eCommon/html/blank.html";  
			 
	}
	else if(table_name=="cust_srvLimit_rate_based_tbl")
	{
//			frameObj=parent.frames[2];  changed frame ref ram

			frameObj=parent.frames[4];
			table = frameObj.document.getElementById('cust_srvLimit_rate_based_tbl');
			func_mode = "CUST_SRVLIMIT_RATE_BASED";			
			del_func_mode = "";			
			formObj=frameObj.document.cust_srvLimit_rate_based_dtl

			var packageCode = formObj.packageCode.value;
			var type = formObj.type.value; 
			var mode = formObj.mode.value;
			var service_code = formObj.parent_service_code.value;
			var service_desc = formObj.service_desc.value;
//			var orderAssociated = formObj.order_associated.value;
			var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
			var cust_grp_code = formObj.cust_grp_code.value;
			var cust_grp_desc = formObj.cust_grp_desc.value;
			var cust_code = formObj.cust_code.value;
			var cust_desc = formObj.cust_desc.value;
			var fromDate = formObj.fromDate.value;
			var parent_index = formObj.parent_indx.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;
//			var acrossEncounters = formObj.acrossEncounters.value;
			
			var dailyLmtIndicator = eval("parent.frames[4].document.cust_srvLimit_rate_based_dtl.parDailyLmtInd").value;//Added V191001-Aravindh/MMS-DM-CRF-0129.1/IN071211

			var tempJsp = "../../eBL/jsp/PkgDefCustExclude.jsp?packageCode="+packageCode+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&type="+type+"&service_code="+service_code
						  +"&mode="+mode+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)
						  +"&cust_desc="+encodeURIComponent(cust_desc)+"&service_desc="+encodeURIComponent(service_desc)+"&fromDate="+fromDate
						  +"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN
						  + "&dailyLmtInd="+dailyLmtIndicator;//Added V191001-Aravindh/MMS-DM-CRF-0129.1/IN071211
		
			
	}
	else if(table_name=="cust_charge_based_tbl")
	{
//			frameObj=parent.frames[0]; changed frame ref ram
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('cust_charge_based_tbl');
			func_mode = "CUST_CHARGE_BASED";			
			del_func_mode = "delete_cust_charge_based";			
			formObj=frameObj.document.cust_charge_based_dtl				

			var packageCode = formObj.packageCode.value;
			var mode = formObj.mode.value;
			var copyFrm_pkgCode = formObj.copyFrm_pkgCode.value;
			var cust_grp_code = formObj.cust_grp_code.value;
			var cust_grp_desc = formObj.cust_grp_desc.value;
			var cust_code = formObj.cust_code.value;
			var cust_desc = formObj.cust_desc.value;
			var fromDate = formObj.fromDate.value;
			var parent_index = formObj.parent_index.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;

			var tempJsp = "../../eBL/jsp/PkgDefCustChargeBased.jsp?packageCode="+packageCode+"&mode="+mode+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)+"&cust_desc="+encodeURIComponent(cust_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;
				
			/*parent.frames[2].location.href="../../eCommon/html/blank.html";
			parent.frames[3].location.href="../../eCommon/html/blank.html";changed frame ref ram and added new frame ref*/
			parent.frames[3].location.href="../../eCommon/html/blank.html";
			parent.frames[4].location.href="../../eCommon/html/blank.html";  
			parent.frames[5].location.href="../../eCommon/html/blank.html";  
	}
	else if(table_name=="cust_charge_based_excl_tbl")
	{
//			frameObj=parent.frames[2]; commented and added new line
			frameObj=parent.frames[4];
			table = frameObj.document.getElementById('cust_charge_based_excl_tbl');
			func_mode = "CUST_CHARGE_BASED_ITEM";			
			del_func_mode = "";			
			formObj=frameObj.document.cust_charge_based_excl_dtl

			var packageCode = formObj.packageCode.value;
			var service_code = formObj.parent_service_code.value;
			var service_desc = formObj.service_desc.value;
			var mode = formObj.mode.value;
			var fromDate = formObj.fromDate.value;
			var cust_grp_code = formObj.cust_grp_code.value;
			var cust_grp_desc = formObj.cust_grp_desc.value;
			var cust_code = formObj.cust_code.value;
			var cust_desc = formObj.cust_desc.value;
			var parent_indx = formObj.parent_indx.value;
			var authorized = formObj.authorized.value;
			var pkgApprovedYN = formObj.pkgApprovedYN.value;

			var tempJsp = "../../eBL/jsp/PkgDefCustChargeBasedExclusion.jsp?packageCode="+packageCode+"&service_code="+service_code+"&mode="+mode+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)+"&cust_desc="+encodeURIComponent(cust_desc)+"&service_desc="+encodeURIComponent(service_desc)+"&fromDate="+fromDate+"&parent_index="+parent_index+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;
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
			if(table_name=="cust_rate_based_tbl")
			{
				fldVal=trimString(formObj.cust_grp_code.value)+"~~"+trimString(formObj.cust_code.value)+"~~"+trimString(formObj.fromDate.value)+"~~"+trimString(row.cells[1].childNodes[0].value)
			}
			else if(table_name=="cust_charge_based_tbl")
			{
				fldVal=trimString(formObj.cust_grp_code.value)+"~~"+trimString(formObj.cust_code.value)+"~~"+trimString(formObj.fromDate.value)+"~~"+trimString(row.cells[0].childNodes[0].value)
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
	updation=formValidation(formCustXMLStringMain(formObj),func_mode);	
	if(del_func_mode!="")
	{
		updation=formValidation(xmlStr,del_func_mode);	
	}

	if(table_name=="cust_rate_based_tbl")
	{
	//	frameObj.location.reload();
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="cust_charge_based_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="cust_charge_based_excl_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else if(table_name=="cust_srvLimit_rate_based_tbl")
	{
		frameObj.location.href=tempJsp;
	}
	else 
	{
		frameObj.location.reload();
	}
}

function formCustXMLStringMain(frmObj) {
	
	submitParamsMain	= "";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
	var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/						
					//submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
					//submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824
					//submitParamsMain	+= arrObj[i].name+"="+(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
				submitParamsMain	+= arrObj[i].name+"="+checkSpecl(val)+"\" ";//added by Nandhini against GHL-SCF-1635 //V220824-modified checkSpl(val) to checkSpecl(val)
				//submitParamsMain	+= arrObj[i].name+"="+checkSpldescrp(val)+"&";//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20
				//alert("submitParamsMain===>"+submitParamsMain);
				}
			}
		}
	}
		xmlStr += " /></root>";
	}
	return xmlStr;
}

function chkCustValidDays(obj)
{
	var flag=false
	if(obj.value<=0){
		flag= false;
	}else{
		flag=true;
	}
	return flag;
}
async function custGrpCodeLookUp(cust_grp_desc,cust_grp_code,index){	
	var formObj=document.cust_dtls;
	
	if(formObj!=null){

		if((eval("formObj.cust_grp_code_temp"+index+".value") != eval("formObj.cust_grp_code"+index+".value")) || eval("formObj.cust_grp_desc"+index+".value") =="" )
		{
			if(eval("formObj.cust_grp_code"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  
					" select code,description from ( "+
					" select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') " +
					")  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";				
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
				saveCustPeriodDtls(index)
			}
		}
	}
	
}
function custGrpDescLookUp(cust_grp_desc,cust_grp_code,index){
	var formObj=document.cust_dtls;
	if(formObj!=null){
		if(eval("formObj.cust_grp_desc_temp"+index+".value") != eval("formObj.cust_grp_desc"+index+".value") || eval("formObj.cust_grp_code"+index+".value") =="" )
		{	
			eval("formObj.cust_code"+index).value= "";			
			eval("formObj.cust_desc"+index).value= "";			
			eval("formObj.pkg_valid_days"+index).value= "";				
			if(eval("formObj.cust_grp_desc"+index).value != ""){			
				show_custGrpLookUp(cust_grp_desc,cust_grp_code,index);
			}else{
				saveCustPeriodDtls(index)
			}
		}
	}
}
function ruleCodeLookup_cust(obj,index){
	
	

	var formObj =document.cust_period_dtl;

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "VAT Percentage"
	var locale = formObj.locale.value;

	var facility_id = formObj.facilityId.value;
	

	/* commented against MMS-ME-SCF-0017
	argumentArray[0] = "select a.rule_code code, a.short_desc description from bl_addl_charge_rule_lang_vw a, bl_addl_charge_rule b where a.facility_id='"
		+facility_id
		+ "' and a.facility_id = b.facility_id and   a.language_id ='"
		+ locale
		+"' and a.rule_type_ind = 'M' AND a.rule_code = b.rule_code "
		+" AND (A.EFF_DATE_TO>=TRUNC(SYSDATE) OR A.EFF_DATE_TO IS NULL) AND (A.EFF_DATE_FROM<=SYSDATE) "
		+" and upper(a.rule_code) like upper(?) and upper(a.short_desc) like upper(?)";*/

	//Added against MMS-ME-SCF-0017 on 06-Jul-20 by MuthuN
	argumentArray[0] = "select a.rule_code code, a.short_desc description from bl_addl_charge_rule_lang_vw a, bl_addl_charge_rule b where a.facility_id='"
		+facility_id
		+ "' and a.facility_id = b.facility_id and   a.language_id ='"
		+ locale
		+"' and a.rule_type_ind = 'M' AND a.rule_code = b.rule_code "
		+" AND (A.EFF_DATE_TO>=TRUNC(SYSDATE) OR A.EFF_DATE_TO IS NULL) "
		+" and upper(a.rule_code) like upper(?) and upper(a.short_desc) like upper(?)";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argumentArray);
//	alert("gayu2"+retArray[0]);
	
	if (retArray != 'undefined' && retArray != undefined && retArray != null) {

		if (retArray[0] + "" != "undefined" && retArray[0] + "" != "") {
		
			//Modified against Incident No - ATE-BL-MMS-73588 for VAT Effective Date Validation  By Ram kumar S
			var fromDate=eval("formObj.fromDate_" + index).value;
			var newStatus=checkVATeffDate(retArray[0],facility_id,fromDate);
			var n1 = newStatus.indexOf("~");
			var res1 = newStatus.substr(n1+1);
			res1 = res1.split("~");
			if(res1[0]=="E"){
				alert("APP-BL6310 Date range should be between From and To date of Rule Code Defined in Addl Charge Rule");
				eval("document.forms[0].VATpercent" + index).value = ""; 
			}else if(res1[0]=="S"){
				eval("document.forms[0].VATpercent" + index).value = retArray[0]; 
			//eval("document.forms[0].glSmryDisc_temp" + index).value = retArray[0];
			}
			// Ends here Incident No - ATE-BL-MMS-73588 By Ram kumar S
		}
		else {
		eval("document.forms[0].VATpercent" + index).value = "";
		
	}
		

	} else {
		eval("document.forms[0].VATpercent" + index).value = "";
		
	}
	
	
	
	
	
	
}
function custGrpLookUp(cust_grp_desc,cust_grp_code,index){
	var formObj=document.cust_dtls;
		if(formObj!=null){
			if(eval("formObj.cust_grp_desc"+index).value == ""){
			show_custGrpLookUp(cust_grp_desc,cust_grp_code,index);
			}
		}
}
async function show_custGrpLookUp(cust_grp_desc,cust_grp_code,index){	
	var formObj=document.cust_dtls;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	var locale=formObj.locale.value;	
	argumentArray[0]	=  
		" select code,description from ("
		+" select '**'  code , 'All Groups'  description from dual union all select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') "
		+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";			
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
	saveCustPeriodDtls(index)
}
async function custCodeLookUp(cust_desc,cust_code,cust_grp_code,index){
	
	var formObj=document.cust_dtls;
	if(formObj!=null){
		if( (eval("formObj.cust_code_temp"+index+".value") != eval("formObj.cust_code"+index+".value")) || eval("formObj.cust_desc"+index).value == "")
		{
			if(eval("formObj.cust_code"+index).value != ""  ){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.Customers.label","BL");
				var locale=formObj.locale.value;				
				argumentArray[0]	= 
					" select code,description from (" 
					+"select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S') "
					+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";	
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = cust_code.value ;
				argumentArray[6]   = CODE_LINK ;
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
					eval("formObj.pkg_valid_days"+index).value="";
					
				}
			}
		}
	}
	if(cust_desc.value != null)
	{
		checkForDuplicate("CUSTOMER",eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value,index);
		
	}
	if(saveCustPeriodDtls(index)){
		eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+cust_code.value)
	}
}
function custDescLookUp(cust_desc,cust_code,cust_grp_code,index){
	var formObj=document.cust_dtls;
	if(formObj!=null){
		if(eval("formObj.cust_desc_temp"+index+".value") != eval("formObj.cust_desc"+index+".value")  || eval("formObj.cust_code"+index).value == "")
		{
			eval("formObj.pkg_valid_days"+index).value="";
			if(eval("formObj.cust_desc"+index).value != ""){
				show_custLookUp(cust_desc,cust_code,cust_grp_code,index);
			}else{
				saveCustPeriodDtls(index)
			}
		}
	}
}
function custLookUp(cust_desc,cust_code,cust_grp_code,index){
	var formObj=document.cust_dtls;
		if(formObj!=null){
			if(eval("formObj.cust_desc"+index).value == ""){
			show_custLookUp(cust_desc,cust_code,cust_grp_code,index);
			}
		}
}
async function show_custLookUp(cust_desc,cust_code,cust_grp_code,index){
	
	var formObj=document.cust_dtls;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.Customers.label","BL");
	var locale=formObj.locale.value;

	argumentArray[0]	= 
		" select code,description from (" 
		+"select '**' code , 'All Customers' description from dual  union all  select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code=decode('"+cust_grp_code.value+"','**', b.cust_group_code,'"+cust_grp_code.value+"')   and a.language_id='"+locale+"' and (status is null or status <> 'S') "
		+" )  where upper(code) like upper(?) and upper(description) like upper(?) order by 2 ";	
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
		eval("formObj.pkg_valid_days"+index).value="";
 	}
	if(cust_desc.value != null)
	{
		checkForDuplicate("CUSTOMER",eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value,index);
		
	}
	if(saveCustPeriodDtls(index)){

		eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+cust_code.value)
		}
}

function chkDeleteCust(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

function showCustPeriod(obj,index){
	
	var cust_grp_code=eval("document.cust_dtls.cust_grp_code"+index).value;
	var cust_grp_desc=encodeURIComponent(eval("document.cust_dtls.cust_grp_desc"+index).value);
	var cust_code=eval("document.cust_dtls.cust_code"+index).value;
	var cust_desc=encodeURIComponent(eval("document.cust_dtls.cust_desc"+index).value);
	var fromDate=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.effFromDate.value;
	var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value;
	var packageCode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
	var authorized=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.authorized.value;
	var pkgApprovedYN=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.pkgApprovedYN.value;
  //Added V190325 Gayathri/KDAH-CRF-0503
	var isMasterPackageYN='N';
  isMasterPackageYN=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.isMasterPackYN.value;
	var allow_masterChild_package=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.allow_masterChild_package_map.value;//GHL-CRF-0520.1
	if(packageCode!="" && cust_grp_code!="" && cust_code!=""){
	saveCustPeriodDtls(index);
	parent.parent.PkgDefCustBaseDateMain.location.href="../../eBL/jsp/PkgDefCustBaseDateMain.jsp?packageCode="+packageCode+"&mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&fromDate="+fromDate+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&cust_grp_desc="+cust_grp_desc+"&cust_desc="+cust_desc+"&parent_index="+index+"&isMasterPackageYN="+isMasterPackageYN+"&parent_index="+index+"&allow_masterChild_package="+allow_masterChild_package;
	parent.parent.PkgDefCustTabFrame.location.href='../../eCommon/html/blank.html' 
	parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html' 

	}
}
function custValidateDate(obj,fromDate,toDate,index)
{	
	var fromDate = eval(fromDate).value;
	var toDate	 = eval(toDate).value;
	var locale=document.forms[0].locale.value;
	var	totRec=	 document.forms[0].totalRecords.value;
	var pakEffDate = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.effFromDate.value

	//alert("totRec:"+totRec)
	var flag = true;
	if(obj.value!=""){
	if(!(pakEffDate == null || pakEffDate==""))
	{
		if(validCustDateChk(obj))
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
			//alert("pakEffDate:"+pakEffDate)
			if(flag && pakEffDate!="" && obj.value !="" && (!(isAfter(obj.value,pakEffDate,'DMY',locale))))
			{
				//alert("Date should be greater than or equal to than package effective from date")
				alert(getMessage("BL8512",'BL'));
				
				flag = false;
				obj.value="";
				//Commented the below line for MMS-DM-SCF-0378
				//obj.focus(); //v10012018 MMS-DM-SCF-0378

			} 
			pakEffDate = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.effToDate.value	
			//alert((!(isAfter(pakEffDate,obj.value,'DMY',locale))))
			if(flag && pakEffDate!="" && obj.value !="" && (!(isAfter(pakEffDate,obj.value,'DMY',locale))))
			{
				//alert("Date should be less than package effective to date")
				alert(getMessage("BL8517",'BL'));
				flag = false;
				obj.value="";
				obj.focus();
			}		  
			if(flag && obj.value !="" && (index>0 || totRec>1)){
				overLapCheck(totRec,obj,index)
			
			}
		}
	}
	else
	{	
		obj.value="";
		//alert("Testing *** Obj.value 542* ");
		alert(getMessage("BL8504",'BL'));
	}
} 
	if(obj.name==("fromDate_"+index)){		
				if(saveCustPriceSrvDtls(index))
					eval("document.forms[0].oldPeriodKey"+index).value=document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+obj.value
	}
}

function validCustDateChk(obj)
{
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
		if(validDate(obj.value,'DMY',locale))
		{
			var frmObj = ""	;
			if(parent.PkgDefCustBaseDateMain!= undefined)
				 frmObj = parent.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl;
			else
				 frmObj = parent.cust_period_dtl.document.cust_period_dtl;

			if(eval("frmObj.fromDate_0.value==''"))
				eval("frmObj.fromDate_0").value = obj.value; 

			if(parent.PkgDefCustTabFrame!= undefined) 
				 frmObj = parent.PkgDefCustTabFrame.document.cust_tab;
			else
				 frmObj = parent.parent.PkgDefCustTabFrame.document.cust_tab;

		/*	if(eval("frmObj.fromDate.value==''"))
				eval("frmObj.fromDate").value = obj.value; */

			return true;
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			//obj.select();
			obj.value = '';
			return false;
		}
	}
	else
	{
		return true;
	}
}
 async function callCustPriceClass(obj,from,type,index)
{
	//savePeriodsToBean("custPeriod",document.forms[0],index);
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

function showCustBasePrice(obj,index)	// Include code for charge based and rate based
{		

	//savePeriodsToBean("custPeriod",document.forms[0],index);
	var value = eval("document.forms[0].fromDate_"+index).value;
	document.forms[0].fromDate.value =  value;
	parent.parent.PkgDefCustTabFrame.location.href="../../eBL/jsp/PkgDefCustTab.jsp?fromDate="+value+"&cust_grp_code="+document.forms[0].cust_grp_code.value+"&cust_grp_desc="+encodeURIComponent(document.forms[0].cust_grp_desc.value)+"&cust_code="+document.forms[0].cust_code.value+"&cust_desc="+encodeURIComponent(document.forms[0].cust_desc.value)+"&parent_index="+index+"&isMaterPackageYN="+document.forms[0].isMasterPackYN.value+"&allow_masterChild_package="+document.forms[0].allow_masterChild_package.value;
	
	
/*	if(parent.parent.PkgDefCustTabFrame.document.cust_tab!=null){
		parent.parent.PkgDefCustTabFrame.document.cust_tab.fromDate.value = value ;
		parent.parent.PkgDefCustTabFrame.document.cust_tab.cust_grp_code.value = document.forms[0].cust_grp_code.value ;
		parent.parent.PkgDefCustTabFrame.document.cust_tab.cust_grp_desc.value = encodeURIComponent(document.forms[0].cust_grp_desc.value) ;
		parent.parent.PkgDefCustTabFrame.document.cust_tab.cust_code.value = document.forms[0].cust_code.value ;
		parent.parent.PkgDefCustTabFrame.document.cust_tab.cust_desc.value = encodeURIComponent(document.forms[0].cust_desc.value) ;
		parent.parent.PkgDefCustTabFrame.document.cust_tab.parent_index.value = index ;
		}*/
		
	var packageCode= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value		
	var mode = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value

	if(parent.parent.PkgDefCustDetailFrame.cust_base_price_dtl!=null && parent.parent.PkgDefCustDetailFrame.cust_base_price_dtl != undefined)
	{
		
		
		var frmObj = parent.parent.PkgDefCustDetailFrame.cust_base_price_dtl.document.cust_base_price_dtl;
		
		if(frmObj!=null && frmObj!=undefined)
		{	
//				alert("formValidation 4");			
			var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_PRICE");
		}
	}
	else if(parent.parent.PkgDefCustDetailFrame.ChargeBasedDtl!=null  && parent.parent.PkgDefCustDetailFrame.ChargeBasedDtl != undefined)
	{
		
		
		var frmObj = parent.parent.PkgDefCustDetailFrame.ChargeBasedDtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{				
		//	var xmlString=formCustXMLString(frmObj,"CUST_CHARGE_BASED","tab",packageCode);				
//			alert("formValidation 5");			
			var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_CHARGE_BASED");
		}
		if(parent.parent.PkgDefCustDetailFrame.length>2)
		{
			
					
			if(parent.parent.PkgDefCustDetailFrame.ChargeBasedExCln != undefined)
			{
				var frmObj = parent.parent.PkgDefCustDetailFrame.ChargeBasedExCln.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{
					//alert('before xml')
					//var xmlString=formCustXMLString(frmObj,"CUST_CHARGE_BASED_ITEM","excln",packageCode);
					//alert("xmlString:"+xmlString)
//						alert("formValidation 6");			
					var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_CHARGE_BASED_ITEM");
				}
			}
		}
	}
	else if(parent.parent.PkgDefCustDetailFrame.rate_based_dtl !=null && parent.parent.PkgDefCustDetailFrame.rate_based_dtl != undefined)
	{
		
				
		var frmObj = parent.parent.PkgDefCustDetailFrame.rate_based_dtl.document.forms[0];
		if(frmObj!=null && frmObj!=undefined)
		{			
		//	var xmlString=formCustXMLString(frmObj,"CUST_RATE_BASED","tab",packageCode);
			//alert("xmlString:"+xmlString)			
			var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_RATE_BASED");
		}
		if(parent.parent.PkgDefCustDetailFrame.length>2)
		{
			
			if(parent.parent.PkgDefCustDetailFrame.srvLimit_rate_based_dtl != undefined)
			{
				var frmObj = parent.parent.PkgDefCustDetailFrame.srvLimit_rate_based_dtl.document.forms[0];
				if(frmObj!=null && frmObj!=undefined)
				{
					//alert('before xml')
					//var xmlString=formCustXMLString(frmObj,"CUST_SRVLIMIT_RATE_BASED","excln",packageCode);
					//alert("xmlString:"+xmlString)
//						alert("formValidation 9");			
					var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_SRVLIMIT_RATE_BASED");
				}
			}
		}
	}
	if(value == null || value== "" )
	{
	//	alert("Please enter from date"); 
		obj.checked = false;
		//parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html';
	}
	else  
	{
				
parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
		showCustTabDetail('CUST_PRICE',parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader,parent.parent.PkgDefCustDetailFrame,parent.parent.PkgDefCustTabFrame,document.forms[0].cust_grp_code.value,document.forms[0].cust_grp_desc.value,document.forms[0].cust_code.value,document.forms[0].cust_desc.value,index,value)
	}
	
}
function showCustTabDetail(key,hdrFormObj,destFrame,tabFrame,cust_grp_code,cust_grp_desc,cust_code,cust_desc,parent_index,fromDate)	
{
	
	//var hdrFormObj=parent.PkgDefCustHeader.document.frmPkgDefCustHeader
	var packageCode=hdrFormObj.packageCode.value
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
	//alert("dfdfdfdfdf :" +destFrame.frames[0].name);
	if(current_form1!="")					
		current_form=destFrame.frames[1].document.forms[0]				//frames ref chhanged 0 to 1 by ram		
	else
		current_form="";		
	var excln_form ;
	if(excln_form1!="" )
		//excln_form= destFrame.frames[2].document.forms[0] added new line by ram
		excln_form= destFrame.frames[4].document.forms[0] 
	 else
		excln_form="";

	var result  = true;
	var excln_link = "";

	if(last_link == "CUST_CHARGE_BASED")
	{
		excln_link="CUST_CHARGE_BASED_ITEM";
		current_form=destFrame.frames[1].document.forms[0] //frame ref changed frames[0] to frames[1] by ram		
		result =validateCustChargeBased(current_form,current_form.totalRecords.value)
			if(result)
		{
			if(excln_form != undefined && excln_form != "")
				result =validateCustChargeBasedItems(excln_form,excln_form.totalRecords.value)
		
		}
	}	
	if(last_link == "CUST_RATE_BASED")
	{
		

		excln_link="CUST_SRVLIMIT_RATE_BASED";

		result=validateCustRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
	}
	 if(last_link == "CUST_PRICE"){
		 
		// sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
			var totalRec = parent.frames[4].frames[1].cust_base_price_dtl.totalRecords.value;
			for ( var i = 0; i < totalRec; i++) {
				if (parent.frames[4].frames[1].cust_base_price_dtl.document
						.getElementById('blgClsCode_' + i).value == "") {
					alert('Atleast One Entry for Package Base Price Must be Provided');
					return false;
				}
				if (parent.frames[4].frames[1].cust_base_price_dtl.document
						.getElementById('price_' + i).value == "") {
					alert(getMessage("BL8527", 'BL'));
					return false;
				}
			}
			// sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
			
		result=validateCustPackagePrice(current_form,current_form.totalRecords.value);
	 }

	if(result)
	{
		
		if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
		var  frmObj	 = excln_form
			if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
			{	
//				alert("formValidation 10");			
				var updation=formValidation(formCustXMLStringMain(frmObj),excln_link);
			}
			
			 frmObj	 = current_form
			
			if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
			{				
//				alert("formValidation 11");			
				
				var updation=formValidation(formCustXMLStringMain(frmObj),last_link);
				
			}
		}
		//if(fromDate!=""){
		if(fromDate!=""){
			hdrFormObj.last_link.value="";
			hdrFormObj.current_form1.value="";
			hdrFormObj.current_form2.value="";
			if(key=="CUST_PRICE"){
				changeCustTabClass(key,tabFrame);

				//sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
				if (document.getElementById("CUST_PRICE_CHK") != null) {
					document.getElementById("CUST_PRICE_CHK").value = "Y";
				}
				//sarath added MMS-QF-SCF-0545 CustomerLevel Ending...
				
				destFrame.location.href='../../eBL/jsp/PkgDefCustBasePriceMain.jsp?packageCode='+packageCode+'&mode='+mode+'&cust_grp_code='+cust_grp_code+'&cust_code='+cust_code+'&cust_grp_desc='+encodeURIComponent(cust_grp_desc)+'&cust_desc='+encodeURIComponent(cust_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN;
			}else if(key=="CUST_CHARGE_BASED"){				
	
				if(orderAssociated == "Y")
				{
					alert(getMessage("BL8578",'BL'));
				}
				else
				{
					
					changeCustTabClass(key,tabFrame);

					var totRec = parent.frames[2].frames[0].document.forms[0].totalRecords.value;
					var fromDateVals = "";
					for(var i=0;i<totRec;i++)
					{
						fromDateVals = fromDateVals+eval("parent.frames[2].frames[0].document.forms[0].fromDate_"+i).value+"|";
					}
					document.getElementById("CUST_CHARGE_BASED_CHK").value = "Y"; //sarath added MMS-QF-SCF-0545 CustomerLevel
					destFrame.location.href='../../eBL/jsp/PkgDefCustChargeBasedMain.jsp?packageCode='+packageCode+'&mode='+mode+'&copyFrm_pkgCode='+copyFrm_pkgCode+'&cust_grp_code='+cust_grp_code+'&cust_code='+cust_code+'&cust_grp_desc='+encodeURIComponent(cust_grp_desc)+'&cust_desc='+encodeURIComponent(cust_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&fromDateVals="+encodeURIComponent(fromDateVals);
				}
			}
			else if(key=="CUST_RATE_BASED")
			{  
				
				changeCustTabClass(key,tabFrame);	

				var totRec = parent.frames[2].frames[0].document.forms[0].totalRecords.value;
				var fromDateVals = "";
				for(var i=0;i<totRec;i++)
				{
					fromDateVals = fromDateVals+eval("parent.frames[2].frames[0].document.forms[0].fromDate_"+i).value+"|";
				}
				document.getElementById("CUST_RATE_BASED_CHK").value = "Y"; //sarath added MMS-QF-SCF-0545 CustomerLevel
				destFrame.location.href='../../eBL/jsp/PkgDefCustRateFrame.jsp?packageCode='+packageCode+'&mode='+mode+'&orderAssociated='+orderAssociated+'&copyFrm_pkgCode='+copyFrm_pkgCode+'&cust_grp_code='+cust_grp_code+'&cust_code='+cust_code+'&cust_grp_desc='+encodeURIComponent(cust_grp_desc)+'&cust_desc='+encodeURIComponent(cust_desc)+'&fromDate='+encodeURIComponent(fromDate)+'&parent_index='+parent_index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&acrossEncounters="+acrossEncounters+"&fromDateVals="+encodeURIComponent(fromDateVals);
			}
						
		}else{
				//alert("Test 1234");
				alert(getMessage("BL8504",'BL')); 
		}
	}
}
function changeCustTabClass(tabObj,tabFrame){		
if(tabFrame.document.forms[0]!=null){
		prevTabObj= tabFrame.document.forms[0].prevTabObj.value;
		
		if(prevTabObj!=null && prevTabObj!=""){			
				tabFrame.document.getElementById('prevTabObj').className="tabA"
				tabFrame.document.getElementById(prevTabObj+"span").className="tabAspan"
			}
			tabFrame.document.getElementById('tabObj').className="tabClicked"
			tabFrame.document.getElementById(tabObj+"span").className="tabSpanclicked"
			tabFrame.document.forms[0].prevTabObj.value=tabObj
}			
}


async function callCustBlgCls(blDesc,blCode,index,from)
{
	if(from == "code"  && blCode.value=="" )
		clearRow(document.cust_base_price_dtl,index);
	else if(from == "desc"  && blDesc.value=="" ) 
		clearRow(document.cust_base_price_dtl,index);
	else if(blCode.value=="" || blDesc.value==""){

	var value = blCode.value;
	if(blDesc.value!=null && blDesc.value!="" )
		value = blDesc.value;
	var sql = "";
	var link = "DESC_LINK"
	var odr = "DESC_CODE"
	var episodeAssociated = "";

	var str = "";
	if(parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.IpYn.value=="Y")
	{
		str = " and ( B.PATIENT_CATEGORY_CODE = 'I'";
	}
	if(parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.DcYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'D'"
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'D' ";
	}
	if(parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.OpYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'O' "
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'O' ";
	}
	if(parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.EmYn.value=="Y")
	{
		if( str == "")
			str = "and ( B.PATIENT_CATEGORY_CODE = 'E' ";
		else
			str =str + " or B.PATIENT_CATEGORY_CODE = 'E' "
	}
	if( str != "")
		str = str +") ";
	//if(parent.parent.PkgDefHeader.document.frmPkgDefHeader.orderAssociated.value)
	var ordAsociated = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.orderAssociated.value;
	//sql ="select '**' code, 'All Billing Classes' description from dual union all  select A.BLNG_CLASS_CODE code, A.short_DESC description from BL_BLNG_CLASS_LANG_VW A, BL_BLNG_CLASS B where a.BLNG_CLASS_CODE = B.BLNG_CLASS_CODE "+str+" and A.LANGUAGE_ID = '"+document.forms[0].locale.value +"' and upper(A.BLNG_CLASS_CODE) like upper(?) and upper(A.SHORT_DESC) like upper(?)" ;
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
			checkForDuplicate("CUST_PRICE",retVal[0],index);
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

function custIndiValidation(obj,index)
{
	var flag = false;
	eval("document.forms[0].price_"+index).value = "";
	eval("document.forms[0].roundTo_"+index).value = "";
	eval("document.forms[0].roundInd_"+index).selectedIndex = 0;
	eval("document.forms[0].minDepAmt_"+index).value = "";
	//var	total_records = parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
	//var	total_records = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.totalRecords.value
	var	total_records = document.forms[0].totalRecords.value
	if(eval("document.forms[0].blgClsCode_"+index).value == "**")
		flag =  false;
	else
	{
		if(obj.value == "F")
		{
			if(index == 0 && total_records==1)
			{				
				alert(getMessage("BL8583",'BL'));	
				flag =  false;
			}
			else
			{
				for(var i=0; i<total_records; i++)
				{
					if(eval("document.forms[0].blgClsCode_"+i).value == "**" && i!=index)
					{
						flag =  true;
						break;
					}
				}			
			}
		}
		else
		  flag =  false;
	}

	if(flag == true)
		eval("document.forms[0].factorAppl_"+index).disabled = false;
	else
	{	 
		eval("document.forms[0].indicator_"+index).selectedIndex = 0;
		if(eval("document.forms[0].factorAppl_"+index) != undefined)
		eval("document.forms[0].factorAppl_"+index).disabled = true;
	}
	if(obj.value == "F"){
		eval("document.forms[0].roundTo_"+index).disabled = false;
		eval("document.forms[0].roundInd_"+index).disabled = false;
		}
		else{
		eval("document.forms[0].roundTo_"+index).disabled = true;
		eval("document.forms[0].roundInd_"+index).disabled = true;	
	}
}
function onCustServiceTypeChange(obj,index){	
    var result=true;
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
    var servGrpLimitSiteSpec = eval("document.cust_rate_based_dtl.servGrpLimitSiteSpec").value;
    var servGrpLmtBy  = eval("document.cust_rate_based_dtl.servGrpLmtBy").value;
    var servGrpLmtFldDisabled = eval("document.cust_rate_based_dtl.servGrpLmtFldDisabled").value;
    var order_associated = eval("document.cust_rate_based_dtl.order_associated").value;	//Added IN73730 by shikha on 19-Aug-2020
    var amt_limit_ind = eval("document.cust_rate_based_dtl.amt_limit_ind"+index).value;	//Added IN73662 by shikha on 21-Aug-2020
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
    //frame ref chanbged frames[2]  to frames[4] by RAM
	if(parent.frames[4].document.forms[0] != null ){		
		result=validateCustServiceLimitForm(parent.frames[4].document.cust_srvLimit_rate_based_dtl,parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value,index,'');			
	}
	if(result){
		clearRow(document.cust_rate_based_dtl,index);		
//		if(document.rate_based_dtl.acrossEncounters.value == "Y" && obj.value=="S") commented and added new line by ram
		if(document.cust_rate_based_dtl.value == "Y" && obj.value=="S") 
		{
			document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(20).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"+index+"')\"/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='' />";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)//MMS-QH-CRF-0170->cells(20)
		}
		else
		{	 
			document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(19).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg' onClick=\"assignClosePkgVal(this,'"+index+"')\" disabled/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='' />";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)//MMS-QH-CRF-0170->cells(19)
		}
		eval("document.cust_rate_based_dtl.service_code"+index).value="";	
		eval("document.cust_rate_based_dtl.service_desc"+index).value="";	
		eval("document.cust_rate_based_dtl.service_desc_temp"+index).value="";	
		if(obj.value=="G" || obj.value=="C"){		
			//eval("document.cust_rate_based_dtl.qty_limit"+index).value="";
			//eval("document.cust_rate_based_dtl.qty_limit"+index).disabled=true;
			document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(3).innerHTML="<SELECT name='ind"+index+"' id='ind"+index+"' onChange='onCustIndChange(this,\""+index+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";		
		//	document.cust_rate_based_dtl.closePkg.value="off";
		//	document.cust_rate_based_dtl.closePkg.disabled =  true;

		}else{
			document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(3).innerHTML="<SELECT name='ind"+index+"' id='ind"+index+"' onChange='onCustIndChange(this,\""+index+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='U'>"+getLabel('Common.UserDefined.label','Common')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
			//document.cust_rate_based_dtl.closePkg.disabled =  false;
		}	
		var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value
		var currKey=trimString(document.cust_rate_based_dtl.cust_grp_code.value+"~~"+document.cust_rate_based_dtl.cust_code.value+"~~"+document.cust_rate_based_dtl.fromDate.value+"~~"+eval("document.cust_rate_based_dtl.service_code"+index).value);
		var oldSrvKey=eval("document.cust_rate_based_dtl.oldSrvKey"+index).value
		//if(mode=='insert' && oldSrvKey!="" && oldSrvKey!=trimString(document.cust_rate_based_dtl.cust_grp_code.value+"~~"+document.cust_rate_based_dtl.cust_code.value+"~~"+document.cust_rate_based_dtl.fromDate.value+"~~") && currKey !=oldSrvKey){
		//alert("currKey :"+currKey);
		//alert("oldSrvKey :"+oldSrvKey);
		if(oldSrvKey!="" && oldSrvKey!=trimString(document.cust_rate_based_dtl.cust_grp_code.value+"~~"+document.cust_rate_based_dtl.cust_code.value+"~~"+document.cust_rate_based_dtl.fromDate.value+"~~") && currKey !=oldSrvKey){
			removeBeanKey(document.cust_rate_based_dtl,oldSrvKey,index);		
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";				
//			parent.frames[2].location.href='../../eCommon/html/blank.html' commented 2 lines and added new line3 by RAM
//			parent.frames[3].location.href='../../eCommon/html/blank.html'

			parent.frames[3].location.href='../../eCommon/html/blank.html'
			parent.frames[4].location.href='../../eCommon/html/blank.html'
			parent.frames[5].location.href='../../eCommon/html/blank.html'
		}	
		eval("document.cust_rate_based_dtl.oldSrvKey"+index).value=currKey;
		//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		if ((servGrpLimitSiteSpec == "true" && obj.value == "S") || order_associated=="Y" || amt_limit_ind == "U") {// servGrpLmtFldDisabled ==' disabled '){					//Modified IN73730 by shikha on 19-Aug-2020
			eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).disabled = true;//shikha
			eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
			
		}else if (servGrpLimitSiteSpec == "true" && obj.value != "S"){					
			eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).disabled = false;//shikha
			eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
			if (servGrpLmtBy != "*") {				
				if (servGrpLmtBy == "B") {
					document.getElementById('cust_rate_based_dtl').rows(parseInt(index))					
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'" 
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='G'>"
					+ getLabel('Common.Group.label', 'Common')
					+ "</option><option value='S'>"
					+ getLabel('eBL.Service.label', 'BL')
					+ "</option></select>";
				} else if (servGrpLmtBy == "G" ) {
					document.getElementById('cust_rate_based_dtl').rows(parseInt(index))
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'" 
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='G'>"
					+ getLabel('Common.Group.label', 'Common')
					+ "</option>"
					+ "</select>";
				} else if (servGrpLmtBy == "S" ) {
					document.getElementById('cust_rate_based_dtl').rows(parseInt(index))
					.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'" 
					+"><option value='*'>"
					+ getLabel('Common.defaultSelect.label', 'Common')
					+ "</option><option value='S'>"
					+ getLabel('eBL.Service.label', 'BL')
					+ "</option></select>";
				}
			}	
		}
		//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	}
}

function before_custServiceLookUp(service_desc,service_code,service_type,index){
	
	var result=true;
	//frame ref parent.frames[2] changed to parent.frames[4] by ram
	if(parent.frames[4].document.forms[0] != null ){
			
			//frame ref parent.frames[2] changed to parent.frames[4] by ram
				//alert("validateCustServiceLimitForm 3")
			result=validateCustServiceLimitForm(parent.frames[4].document.cust_srvLimit_rate_based_dtl,parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value,index,'');	
		
	}
	var formObj=document.cust_rate_based_dtl;
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
					
					show_custServiceLookUp(service_desc,service_code,service_type,index);
				 }else{
				 	var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value
					var currKey=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~"+"");
					var oldSrvKey=eval("formObj.oldSrvKey"+index).value
			
					//	if(mode=='insert' && oldSrvKey!="" && oldSrvKey!=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~") && currKey !=oldSrvKey){
					if(oldSrvKey!="" && oldSrvKey!=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~") && currKey !=oldSrvKey){
						removeBeanKey(formObj,oldSrvKey,index);
						parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
						parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
						parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";						
//						parent.frames[2].location.href='../../eCommon/html/blank.html'
//						parent.frames[3].location.href='../../eCommon/html/blank.html' commented 2 lines and added new 3 lines by RAM

						parent.frames[3].location.href='../../eCommon/html/blank.html'
						parent.frames[4].location.href='../../eCommon/html/blank.html'
						parent.frames[5].location.href='../../eCommon/html/blank.html'
					}	


					eval("formObj.oldSrvKey"+index).value=currKey
				 }
			}
			IncludeHomeMedicationCustGlobal(service_code,service_type,index);
			//dailyLmtChkBxClickPharmaCust(service_code,service_type,index); //Added V190404-Dhananjay/MMS-DM-CRF-0129
		}
	}else{
		return false;
	}
}

function custServiceLookUp(service_desc,service_code,service_type,index){
	
	var result=true;
	//frame ref changed parent.frames[2] to parent.frames[4] by ram
	if(parent.frames[4].document.forms[0] != null ){
	//alert("validateCustServiceLimitForm 4")
	result=validateCustServiceLimitForm(parent.frames[4].document.cust_srvLimit_rate_based_dtl,parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value,index,'');		
	}

	var formObj=document.cust_rate_based_dtl;
	
	if(result){		
		
		if(formObj!=null){
					
			clearRow(formObj,index);
			if(eval("formObj.service_desc"+index).value == ""){
			show_custServiceLookUp(service_desc,service_code,service_type,index);
			}
			IncludeHomeMedicationCustGlobal(service_code,service_type,index);
			//dailyLmtChkBxClickPharmaCust(service_code,service_type,index); //Added V190404-Dhananjay/MMS-DM-CRF-0129
		}
	}
}
async function show_custServiceLookUp(service_desc,service_code,service_type,index){
	
	var formObj=document.cust_rate_based_dtl;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingService.label","common");
	var local=formObj.locale.value;
	var facility_id=formObj.facility_id.value; //V211130
	if(service_type.value=="G"){
	argumentArray[0]	=  "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"+local+"' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
	title=getLabel("eBL.SERVICE_GROUP.label","BL");
	}else if(service_type.value=="C"){
		argumentArray[0]	=  "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+local+"' and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
	title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");
	}else if(service_type.value=="S"){
		argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+local+"' and status is null and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
	title=getLabel("Common.BillingService.label","common");		
	}
// Added By Muthukumar against KDAH-SCF-0057 on 27-4-12
	else{
		argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
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
			/*
			eval("formObj.amt_percentage"+index).disabled=true;
			eval("formObj.amt_limit"+index).disabled=true;
			eval("formObj.unlimited"+index).disabled=true;	*/
			
		}else{
						
			//eval("formObj.perAmt_limit"+index).disabled=true;
/*			eval("formObj.amt_percentage"+index).disabled=false;
			eval("formObj.amt_limit"+index).disabled=false;
			eval("formObj.unlimited"+index).disabled=false;	*/		
		}

		if(eval("formObj.factor_appl"+index)!= undefined)
		{
						
			eval("formObj.factor_appl"+index).value="";		
			eval("formObj.factor_appl"+index).checked=false;		
			eval("formObj.factor_appl"+index).disabled=true;	
		}
		/*if(eval("formObj.type"+index).value=="G" ||  eval("formObj.type"+index).value=="C"){
			eval("formObj.qty_limit"+index).disabled=true;
		}else{*/
			eval("formObj.qty_limit"+index).disabled=false;
		//}
	
		if(eval("formObj.type"+index).value=="G" ||  eval("formObj.type"+index).value=="C"){
		eval("formObj.replace"+index).disabled=true;
		eval("formObj.refund"+index).disabled=true;
		document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(19).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+index+"\")' disabled/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='N' />";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)//MMS-QH-CRF-0170->cells(19)
				
		}else{
						
		eval("formObj.replace"+index).disabled=false;
		eval("formObj.refund"+index).disabled=false;
			if(formObj.acrossEncounters.value=="Y"){
							
				document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(19).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+index+"\")'/><input type='hidden' name='closePkg"+index+"' id='closePkg"+index+"' value='N' />";
				//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)//MMS-QH-CRF-0170->cells(19)
			}
		}
	//	eval("formObj.service_limit"+index).checked=false;
		
		if(eval("formObj.type"+index).value=="S"){		
						
			//eval("formObj.service_limit"+index).disabled=true;
			//eval("formObj.service_limit_dtls"+index).disabled=true;
			document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(20).innerHTML="<a name='service_limit_dtls"+index+"' href='#' onClick='custServiceLimitDtls("+index+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)//MMS-QH-CRF-0170->cells(20)
		}else{
						
			//eval("formObj.service_limit"+index).disabled=false;
			//eval("formObj.service_limit_dtls"+index).disabled=false;
					document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(20).innerHTML="<a name='service_limit_dtls"+index+"' href='#' onClick='custServiceLimitDtls("+index+")'  >"+getLabel('eBL.Dtls.label','BL')+"</a>";
					//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)//MMS-QH-CRF-0170->cells(20)
			}
			
 	}else{
					
		eval("formObj.service_code"+index).value="";	
		eval("formObj.service_desc"+index).value="";	
		eval("formObj.service_desc_temp"+index).value="";	
		clearRow(formObj,index);
 	}
	//Added for duplicate check
	//if(service_desc.value != null)
	if(service_code.value  != null)
	{
			
		//checkForDuplicate("CUST_RATE_BASED",service_desc.value,index);
		checkForDuplicate("CUST_RATE_BASED",service_code.value,index);
		
	}
	var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value
var currKey=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~"+eval("formObj.service_code"+index).value);	
	
	var oldSrvKey=eval("formObj.oldSrvKey"+index).value
		

	//if((mode=='insert') && (oldSrvKey!="") && oldSrvKey!=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~") && (currKey !=oldSrvKey)){
	if( (oldSrvKey!="") && oldSrvKey!=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+formObj.fromDate.value+"~~") && (currKey !=oldSrvKey)){
		removeBeanKey(formObj,oldSrvKey,index);	
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";				
//		parent.frames[2].location.href='../../eCommon/html/blank.html'
//		parent.frames[3].location.href='../../eCommon/html/blank.html'  commented 2 lined and added 3lines by RAM

		parent.frames[3].location.href='../../eCommon/html/blank.html'
		parent.frames[4].location.href='../../eCommon/html/blank.html'
		parent.frames[5].location.href='../../eCommon/html/blank.html'

	}	
	eval("formObj.oldSrvKey"+index).value=currKey

}
function before_custCatalogLookUp(catalog_desc,catalog_code,service_code,index){

var formObj=document.cust_rate_based_dtl;
	if(formObj!=null){
		if(eval("formObj.catalog_desc_temp"+index+".value") != eval("formObj.catalog_desc"+index+".value"))
		{
			if(eval("formObj.catalog_desc"+index).value != "")
			 show_custCatalogLookUp(catalog_desc,catalog_code,service_code,index);
		}
	}
	
}

function custCatalogLookUp(catalog_desc,catalog_code,service_code,index){

		var formObj=document.cust_rate_based_dtl;
		if(formObj!=null){
			if(eval("formObj.catalog_desc"+index).value == ""){
			show_custCatalogLookUp(catalog_desc,catalog_code,service_code,index);
			}
		}
	
}

async function show_custCatalogLookUp(catalog_desc,catalog_code,service_code,index){	
	var formObj=document.cust_rate_based_dtl;
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

function onCustIndChange(obj,index){


	}
function chkCustFactorRule(obj,ind){


	/*if(ind.value=="S" || ind.value=="R" ){
		if(obj.value !="" && obj.value<=0){
			alert(getMessage("BL6159","BL"));		
			obj.value="";
			return false;
		}
	
	}*/
}
function chkCustQtyLimit(obj,index){

	
	if(obj.value!="" && obj.value<1){
		alert(getMessage("BL8538","BL"));
		obj.value =  "";
		return false;
	}
}
function chkCustAmtPercent(obj,index){
	if(obj.value!=""){
		//eval("document.forms[0].amt_limit"+index).value="";
		//eval("document.forms[0].amt_limit"+index).disabled=true;
		eval("document.forms[0].factor_appl"+index).value="";
		eval("document.forms[0].factor_appl"+index).checked=false;
		eval("document.forms[0].factor_appl"+index).disabled=true;
	}else{ /*
		eval("document.forms[0].amt_limit"+index).disabled=false;
		if(eval("document.forms[0].amt_limit"+index).value==""){
			eval("document.forms[0].factor_appl"+index).value="";
			eval("document.forms[0].factor_appl"+index).checked=false;
			eval("document.forms[0].factor_appl"+index).disabled=true;
		} */
	}
	
}
function chkCustAmt(obj,index){
	if(eval("document.forms[0].factor_appl"+index) != undefined)
	{
		eval("document.forms[0].factor_appl"+index).value="";
		eval("document.forms[0].factor_appl"+index).checked=false;
		eval("document.forms[0].factor_appl"+index).disabled=true;
	}
	if(obj.value!=""){
		//eval("document.forms[0].amt_percentage"+index).value="";
		//eval("document.forms[0].amt_percentage"+index).disabled=true;			
		if(obj.value>0){
			if(eval("document.forms[0].factor_appl"+index) != undefined)
				eval("document.forms[0].factor_appl"+index).disabled=false;
		}
	}else{
		//eval("document.forms[0].amt_percentage"+index).disabled=false;		
	}
}
function chkCustUnlimited(obj,index){
if(eval("document.forms[0].service_code"+index).value!=""){
	if(obj.value="U"){
		//obj.value="Y";
		eval("document.forms[0].qty_limit"+index).value="";
		eval("document.forms[0].qty_limit"+index).disabled=true;
		eval("document.forms[0].perAmt_limit"+index).value="";
		eval("document.forms[0].perAmt_limit"+index).disabled=true;
		/*
		eval("document.forms[0].amt_percentage"+index).value="";
		eval("document.forms[0].amt_percentage"+index).disabled=true;
		eval("document.forms[0].amt_limit"+index).value="";
		eval("document.forms[0].amt_limit"+index).disabled=true;
		*/
		eval("document.forms[0].factor_appl"+index).value="";		
		eval("document.forms[0].factor_appl"+index).checked=false;		
		eval("document.forms[0].factor_appl"+index).disabled=true;	
		
	}else{
		//obj.value="N";
		eval("document.forms[0].qty_limit"+index).value="";
		eval("document.forms[0].qty_limit"+index).disabled=false;
		if(document.forms[0].order_associated.value=="N"){
			eval("document.forms[0].perAmt_limit"+index).value="";
			eval("document.forms[0].perAmt_limit"+index).disabled=false;
			
			/*eval("document.forms[0].amt_percentage"+index).value="";
			eval("document.forms[0].amt_percentage"+index).disabled=false;
			eval("document.forms[0].amt_limit"+index).value="";
			eval("document.forms[0].amt_limit"+index).disabled=false;
			*/
		}else if(document.forms[0].order_associated.value=="Y"){
			eval("document.forms[0].perAmt_limit"+index).disabled=true;
			/*
				eval("document.forms[0].amt_percentage"+index).disabled=true;
				eval("document.forms[0].amt_limit"+index).disabled=true;
				*/
		}
		eval("document.forms[0].factor_appl"+index).value="";		
		eval("document.forms[0].factor_appl"+index).checked=false;		
		eval("document.forms[0].factor_appl"+index).disabled=true;	
	}
	}
}

function chkCustReplace(obj,index){
	
	if(obj.checked){		
		document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(15).innerHTML ="<input type='checkbox'  checked name='replace"+index+"' id='replace"+index+"' value='Y' onClick='chkCustReplace(this,\""+index+"\")'/><a name='replace_dtls"+index+"' href='#' onClick='showCustReplaceDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a><input type='hidden' name='replaceSrv_code"+index+"' id='replaceSrv_code"+index+"' value=''><input type='hidden' name='replaceSrv_desc"+index+"' id='replaceSrv_desc"+index+"' value=''><input type='hidden' name='replaceSrv_cat_code"+index+"' id='replaceSrv_cat_code"+index+"' value=''><input type='hidden' name='replaceSrv_cat_desc"+index+"' id='replaceSrv_cat_desc"+index+"' value=''>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(13)->cells(14)//MMS-QH-CRF-0170->cells(15)
	showCustReplaceDtls(index);
	}else{
		document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(16).innerHTML ="<input type='checkbox'  name='replace"+index+"' id='replace"+index+"' value='N' onClick='chkCustReplace(this,\""+index+"\")'/><input type='hidden' name='replaceSrv_code"+index+"' id='replaceSrv_code"+index+"' value=''><input type='hidden' name='replaceSrv_desc"+index+"' id='replaceSrv_desc"+index+"' value=''><input type='hidden' name='replaceSrv_cat_code"+index+"' id='replaceSrv_cat_code"+index+"' value=''><input type='hidden' name='replaceSrv_cat_desc"+index+"' id='replaceSrv_cat_desc"+index+"' value=''>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(13)->cells(14)//MMS-QH-CRF-0170->cells(16)
	
	}
}
function showCustReplaceDtls(index){	
	var type=eval("document.cust_rate_based_dtl.type"+index).value;
	var service_code=eval("document.cust_rate_based_dtl.service_code"+index).value;
	var service_desc=eval("document.cust_rate_based_dtl.service_desc"+index).value;
	var order_associated=document.cust_rate_based_dtl.order_associated.value;
	var mode=document.cust_rate_based_dtl.mode.value;
	var authorized=document.cust_rate_based_dtl.authorized.value;
	var pkgApprovedYN=document.cust_rate_based_dtl.pkgApprovedYN.value;
	var catalog_code="";
	var catalog_desc="";
	if(order_associated=="Y"){
		var catalog_code=eval("document.cust_rate_based_dtl.catalog_code"+index).value;
		var catalog_desc=eval("document.cust_rate_based_dtl.catalog_desc"+index).value;
	}
	var replaceSrv_code=eval("document.cust_rate_based_dtl.replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.cust_rate_based_dtl.replaceSrv_desc"+index).value;	
	var replaceSrv_cat_code="";
	var replaceSrv_cat_desc="";
	if(order_associated=="Y"){
		var replaceSrv_cat_code=eval("document.cust_rate_based_dtl.replaceSrv_cat_code"+index).value;
		var replaceSrv_cat_desc=eval("document.cust_rate_based_dtl.replaceSrv_cat_desc"+index).value;
	}
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
	
		eval("document.cust_rate_based_dtl.replaceSrv_code"+index).value=retVal[0];
		eval("document.cust_rate_based_dtl.replaceSrv_desc"+index).value=retVal[1];
		eval("document.cust_rate_based_dtl.replaceSrv_cat_code"+index).value=retVal[2];
		eval("document.cust_rate_based_dtl.replaceSrv_cat_desc"+index).value=retVal[3];
	}	
	
}

function chkCustRefund(obj,index){	
	var noofdecimal=document.cust_rate_based_dtl.noofdecimal.value	
	if(obj.checked){	
		obj.value="Y";	
		document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(16).innerHTML ="<input type='checkbox' name='refund"+index+"' id='refund"+index+"' checked value='Y' onClick='chkCustRefund(this,\""+index+"\")'/><input type='text' name='refundAmt"+index+"' id='refundAmt"+index+"' value='' onBlur='validPercentageForRefundCust(this,\"autoRefund"+index+"\")' onkeypress='return allowValidNumber(this,event,\""+noofdecimal+"\")' size='2' maxlength='4'  >";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(14)->cells(15)//MMS-QH-CRF-0170->cells(17)
		eval("document.forms[0].autoRefund"+index).disabled = false;

	}else{
		obj.value="N";	
		document.getElementById('cust_rate_based_tbl').rows(parseInt(index)+2).cells(16).innerHTML ="<input type='checkbox' name='refund"+index+"' id='refund"+index+"'  value='N' onClick='chkCustRefund(this,\""+index+"\")'/>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(14)->cells(15)//MMS-QH-CRF-0170->cells(18)
		eval("document.forms[0].autoRefund"+index).value = "N";
		eval("document.forms[0].autoRefund"+index).checked = false;
		eval("document.forms[0].autoRefund"+index).disabled = true;

	
	}

}
function chkCustRefundAmt(obj,index){
	if(obj.value=="" || obj.value=="0" || obj.value==0){
		alert(getMessage("BL8545",'BL'));
		obj.value="";
		obj.focus();
	}
}
function custFactorAppl(obj,index){	
	if(obj.checked){	
		obj.value="Y";			
	}else{
		obj.value="N";		
}
}


/*
function chkServiceLimit(obj,index){
	var result=true;
	var from = document.forms[0].from.value;
	var fromDate = document.forms[0].fromDate.value;
	alert("from:"+from)
	if(parent.frames[2].document.forms[0] != null ){
		result=validateServiceLimitForm(parent.frames[2].document.srvLimit_rate_based_dtl,parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value,index,'');		
	}
	
	if(result){
		if(obj.checked){
			obj.value="Y";		
			document.getElementById('rate_based_tbl').rows(parseInt(index)+1).cells(15).innerHTML ="<input type='checkbox'  checked name='service_limit"+index+"' id='service_limit"+index+"' onClick='chkServiceLimit(this,\""+index+"\")' value='Y'/><a name='service_limit_dtls"+index+"' href='#' onClick='serviceLimitDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a>";
			type=eval("document.rate_based_dtl.type"+index).value;
			service_code=eval("document.rate_based_dtl.service_code"+index).value;
			
			mode=document.rate_based_dtl.mode.value;
			packageCode=parent.parent.PkgDefHeader.frmPkgDefHeader.packageCode.value;
			copyFrm_pkgCode ="";
			if(from=="PACKAGE")
			copyFrm_pkgCode=parent.parent.PkgDefHeader.frmPkgDefHeader.copyFrm_pkgCode.value;
	
			parent.frames[2].location.href="../../eBL/jsp/PkgDefExclude.jsp?mode="+mode+"&packageCode="+packageCode+"&type="+type+"&service_code="+service_code+"&parent_indx="+index+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&from="+from+"&fromDate="+fromDate;
			parent.frames[3].location.href="../../eBL/jsp/PkgDefRateBasedBtn.jsp?table_name=srvLimit_rate_based_tbl&from="+from ;
		}else{
			obj.value="N";
			document.getElementById('rate_based_tbl').rows(parseInt(index)+1).cells(15).innerHTML ="<input type='checkbox'   name='service_limit"+index+"' id='service_limit"+index+"' onClick='chkServiceLimit(this,\""+index+"\")' value='N'/>";
			// remove values from bean- chinju.
			parent.frames[2].location.href="../../eCommon/html/blank.html";
			parent.frames[3].location.href="../../eCommon/html/blank.html";
		}
	}
	
}*/
function custServiceLimitDtls(index){
	
//alert(" custServiceLimitDtls ");//muthu
	var result=true;
	
	var fromDate = document.forms[0].fromDate.value;
	var fromDateTemp = document.forms[0].fromDateTemp.value;
	var authorized = document.forms[0].authorized.value;
	var pkgApprovedYN = document.forms[0].pkgApprovedYN.value;
	var dailyLmtIndicator = eval("document.cust_rate_based_dtl.dailyLmtIndicator"+index).value;//Added V190731-Aravindh/MMS-DM-CRF-0129.1
	
	if(parent.frames[4].document.forms[0] != null ){
		result=validateCustServiceLimitForm(parent.frames[4].document.cust_srvLimit_rate_based_dtl,parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value,index,'');		
	}
	if(result){	
		type=eval("document.cust_rate_based_dtl.type"+index).value;
		service_code=eval("document.cust_rate_based_dtl.service_code"+index).value;
		service_desc=eval("document.cust_rate_based_dtl.service_desc"+index).value;
		cust_grp_code=document.cust_rate_based_dtl.cust_grp_code.value;
		cust_grp_desc=document.cust_rate_based_dtl.cust_grp_desc.value;
		cust_code=document.cust_rate_based_dtl.cust_code.value;
		cust_desc=document.cust_rate_based_dtl.cust_desc.value;		
		mode=document.cust_rate_based_dtl.mode.value;
		packageCode=parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.packageCode.value;
		copyFrm_pkgCode = "";
		copyFrm_pkgCode=parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.copyFrm_pkgCode.value;
		
		//added new frame for header by ram
		parent.frames[3].location.href="../../eBL/jsp/PkgDefCustExcludeHdr.jsp?mode="+mode+"&packageCode="+packageCode+"&type="+type+"&service_code="+service_code+"&service_desc="+encodeURIComponent(service_desc)+"&parent_indx="+index+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&fromDate="+fromDate+"&cust_grp_code="+cust_grp_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)+"&cust_code="+cust_code+"&cust_desc="+encodeURIComponent(cust_desc)+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN;	
		parent.frames[4].location.href="../../eBL/jsp/PkgDefCustExclude.jsp?mode="+mode+"&packageCode="+packageCode+"&type="+type+"&service_code="+service_code+"&service_desc="+encodeURIComponent(service_desc)+"&parent_indx="+index+"&copyFrm_pkgCode="+copyFrm_pkgCode+"&fromDate="+fromDate+"&cust_grp_code="+cust_grp_code+"&cust_grp_desc="+encodeURIComponent(cust_grp_desc)+"&cust_code="+cust_code+"&cust_desc="+encodeURIComponent(cust_desc)+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN+"&fromDateTemp="+fromDateTemp+"&dailyLmtInd="+dailyLmtIndicator;//Modified V190731-Aravindh/MMS-DM-CRF-0129.1/Added dailyLmtInd		
		parent.frames[5].location.href="../../eBL/jsp/PkgDefCustBtn.jsp?table_name=cust_srvLimit_rate_based_tbl&mode="+mode+"&authorized="+authorized+"&pkgApprovedYN="+pkgApprovedYN  ;
	}
}
function chkCustDeleteService(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

function onCustSrvLimitServiceTypeChange(obj,index){
	clearRow(document.cust_srvLimit_rate_based_dtl,index);
	/*if(obj.value=="C"){
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).value="";
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).disabled=true;
	}else{
		if(eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_code"+index).value !=""){
			eval("document.cust_srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).value="";
			eval("document.cust_srvLimit_rate_based_dtl.srvLimit_qty_limit"+index).disabled=false;
		}
}*/
	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_code"+index).value="";
	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_desc"+index).value="";
	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_desc_temp"+index).value="";	
	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replace"+index).disabled=true;
	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_refund"+index).disabled=true;

}
async function custSrvLimitCodeLookUp(service_desc,service_code,service_type,index){	
//alert("custSrvLimitCodeLookUp ");
	var formObj=document.cust_srvLimit_rate_based_dtl;
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
						argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
					}else if (parent_type=="C"){
						argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
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
					
				/*	if(eval("formObj.srvLimit_type"+index).value=="C"){
						eval("formObj.srvLimit_qty_limit"+index).disabled=true;
					}else{*/
						eval("formObj.srvLimit_qty_limit"+index).disabled=false;
					//}		
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
					checkForDuplicate("CUST_SRVLIMIT_RATE_BASED",service_code.value,index);		
				}
			}
		}
		IncludeHomeMedicationCustGlobal(service_code,service_type,index);
		//dailyLmtChkBxClickPharmaCust(service_code,service_type,index); //Added V190404-Dhananjay/MMS-DM-CRF-0129
	}
}
function before_custSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
var formObj=document.cust_srvLimit_rate_based_dtl;
	if(formObj!=null){
		if(eval("formObj.srvLimit_service_desc_temp"+index+".value") != eval("formObj.srvLimit_service_desc"+index+".value"))
		{
			clearRow(formObj,index);
			if(eval("formObj.srvLimit_service_desc"+index).value != "")
				show_custSrvLimitServiceLookUp(service_desc,service_code,service_type,index);
		}
		IncludeHomeMedicationCustGlobal(service_code,service_type,index);
		//dailyLmtChkBxClickPharmaCust(service_code,service_type,index); //Added V190404-Dhananjay/MMS-DM-CRF-0129
	}
}
function custSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
	var formObj=document.cust_srvLimit_rate_based_dtl;
		if(formObj!=null){
			clearRow(formObj,index);
			if(eval("formObj.srvLimit_service_desc"+index).value == ""){
			show_custSrvLimitServiceLookUp(service_desc,service_code,service_type,index);
			}
			IncludeHomeMedicationCustGlobal(service_code,service_type,index);
			//dailyLmtChkBxClickPharmaCust(service_code,service_type,index); //Added V190404-Dhananjay/MMS-DM-CRF-0129
		}
}
async function show_custSrvLimitServiceLookUp(service_desc,service_code,service_type,index){
	//alert("show_custSrvLimitServiceLookUp *** ");
	var formObj=document.cust_srvLimit_rate_based_dtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingService.label","common");
	var locale=formObj.locale.value;
	var facility_id=formObj.facility_id.value;//V211130
	var parent_type=formObj.parent_type.value;	
	var parent_service_code=formObj.parent_service_code.value;
	var parent_service_ind=formObj.parent_service_ind.value;
	if(service_type.value=="C"){		
		//alert("service_type in DefCust.js ==>"+service_type);
		//argumentArray[0]	=  "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+locale+"' and upper(substr(serv_classification_code,1,2)) = upper('"+parent_service_code+"') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";		

		//Above is commented by Muthu against the lookup issue and modified as below
		argumentArray[0] =   "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"+locale+"' and ((upper(substr(serv_classification_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2 " ;
		title=getLabel("eBL.SERVICE_CLASSIFICATION.label","BL");		
	}else{	
		if(parent_type=="G"){
			//alert("parent_type in DefCust.js ==>"+parent_type);
// Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Starts Here
			if(service_type.value=="S"){	
			//	alert("service_type S DefCust.js ==>"+service_type);
			//argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			
			//Above is commented by Muthu against the lookup issue and modified as below
			 argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
			 title=getLabel("Common.BillingService.label","common");
		 }else if(service_type.value=="M"){
			 //alert("service_type M DefCust.js ==>"+service_type);
			 argumentArray[0]	=  "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"+locale+"' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			 title=getLabel("Common.item.label","common");
		 }else if(service_type.value=="P"){
			 //alert("service_type P DefCust.js ==>"+service_type);
			 argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
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
			 argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"+parent_service_code+"')) or (upper('"+parent_service_ind+"') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
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
			argumentArray[0]	=  "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
		   title=getLabel("eBL.PackageGrouping.label","BL");
			}			
		}
//Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Ends Here
		else if (parent_type=="C"){
			argumentArray[0]	=  "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"+locale+"' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"+parent_service_code+"')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";//GHL-CRF-0520.1
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
		
	/*	if(eval("formObj.srvLimit_type"+index).value=="C"){
			eval("formObj.srvLimit_qty_limit"+index).disabled=true;
		}else{*/
			eval("formObj.srvLimit_qty_limit"+index).disabled=false;
		//}		
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
		checkForDuplicate("CUST_SRVLIMIT_RATE_BASED",service_code.value,index);
		
	}

}
function chkCustExludeService(obj,index){
var formObj=document.cust_srvLimit_rate_based_dtl;
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
			document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox'  disabled name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='N' onClick='custSrvLimitChkReplace(this,\""+index+"\")'/><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(11)->cells(12)//MMS-QH-CRF-0170->cells(13)
			document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(14).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"' disabled value='N' onClick='custSrvLimitChkRefund(this,\""+index+"\")'/>";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(12)->cells(13)//MMS-QH-CRF-0170->cells(14)
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
		if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
			eval("formObj.dailyLmtChkBx"+index).disabled = true;
			eval("formObj.dailyLmtChkBx"+index).checked = false;
			eval("formObj.dailyLmtChkBx"+index).value = "N";
			dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.cust_srvLimit_rate_based_dtl);
			eval("formObj.dailyLmtIndicator"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtIndicator"+index).value = "*";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtAmt"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtAmt"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtQty"+index).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			eval("formObj.dailyLmtQty"+index).value = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	}else{
		obj.value="N";
		//if(eval("formObj.srvLimit_type"+index).value=="S"){
		eval("formObj.srvLimit_qty_limit"+index).disabled=false;
		//}
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
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
		if(formObj.dailyLimitSiteSpec.value == "true" || formObj.dailyLimitSiteSpec.value == true) {
			eval("formObj.dailyLmtChkBx"+index).disabled = false;
			eval("formObj.dailyLmtChkBx"+index).checked = false;
			eval("formObj.dailyLmtChkBx"+index).value = "N";
			dailyLmtChkBxClick("formObj.dailyLmtChkBx"+index, index, document.cust_srvLimit_rate_based_dtl);
			/* Added V190626-Aravindh/MMS-DM-CRF-0129.1/Starts */
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
			/* Added V190626-Aravindh/MMS-DM-CRF-0129.1/Ends */
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	}
}
function chkCustSrvLimitQtyLimit(obj){
	if(obj.value!="" && obj.value<1){
		alert(getMessage("BL8538","BL"));
		obj.value =  "";
		return false;
	}
}

function chkCustSrvLimitAmtLimit(obj,index,noofdecimal){
var formObj=document.cust_srvLimit_rate_based_dtl;
   if(obj.value!="")
   {
	   if(eval("formObj.srvLimit_amt_limit_ind"+index).value == "A")
	   {
			checkForNegetiveNumber(obj,noofdecimal,"BL8540")
			if(obj.value>0){
				eval("formObj.srvLimit_factor_appl"+index).value="";	
				eval("formObj.srvLimit_factor_appl"+index).checked=false;	
				eval("formObj.srvLimit_factor_appl"+index).disabled=false;	
			}else{
				eval("formObj.srvLimit_factor_appl"+index).value="";	
				eval("formObj.srvLimit_factor_appl"+index).checked=false;	
				eval("formObj.srvLimit_factor_appl"+index).disabled=true;	
			}
	   }
	   else if(eval("formObj.srvLimit_amt_limit_ind"+index).value == "P")
	   {
			validPercentage(obj) ;
	   }
   }
}
function srvCustLimitFactorAppl(obj,index){	
	if(obj.checked){	
		obj.value="Y";			
	}else{
		obj.value="N";		
}
}

function custSrvLimitChkReplace(obj,index){
	if(obj.checked){
		obj.value = "Y";
		//eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replace_dtls"+index).style.display = 'inline';
		document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox'  checked name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='Y' onClick='custSrvLimitChkReplace(this,\""+index+"\")'/><a name='srvLimit_replace_dtls"+index+"' href='#' onClick='custSrvLimitShowReplaceDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(11)->cells(12)//MMS-QH-CRF-0170->cells(13)
		custSrvLimitShowReplaceDtls(index);
	}else{
		obj.value = "N";
		//eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replace_dtls"+index).style.display = 'none';
		document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox'  name='srvLimit_replace"+index+"' id='srvLimit_replace"+index+"' value='N' onClick='custSrvLimitChkReplace(this,\""+index+"\")'/><input type='hidden' name='srvLimit_replaceSrv_code"+index+"' id='srvLimit_replaceSrv_code"+index+"' value=''><input type='hidden' name='srvLimit_replaceSrv_desc"+index+"' id='srvLimit_replaceSrv_desc"+index+"' value=''>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(11)->cells(12)//MMS-QH-CRF-0170->cells(13)
	
	}
}
function custSrvLimitShowReplaceDtls(index){	
	var type=eval("document.cust_srvLimit_rate_based_dtl.srvLimit_type"+index).value;
	var service_code=eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_code"+index).value;
	var service_desc=eval("document.cust_srvLimit_rate_based_dtl.srvLimit_service_desc"+index).value;
	//var order_associated=document.rate_based_dtl.order_associated.value;
	var catalog_code="";
	var catalog_desc="";
	var order_associated = "N";
	var mode=document.forms[0].mode.value;
	var authorized=document.forms[0].authorized.value;
	var pkgApprovedYN=document.forms[0].pkgApprovedYN.value;
	/*
	if(order_associated=="Y"){
		var catalog_code=eval("document.rate_based_dtl.catalog_code"+index).value;
		var catalog_desc=eval("document.rate_based_dtl.catalog_desc"+index).value;
	}*/
	var replaceSrv_code=eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"+index).value;	
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
	
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"+index).value=retVal[0];
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"+index).value=retVal[1];
		//eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_cat_code"+index).value=retVal[2];
		//eval("document.cust_srvLimit_rate_based_dtl.srvLimit_replaceSrv_cat_desc"+index).value=retVal[3];
	}	
	
}

function custSrvLimitChkRefund(obj,index){
	var noofdecimal = document.forms[0].noofdecimal.value
	if(obj.checked){	
		obj.value="Y";
		//eval("document.cust_srvLimit_rate_based_dtl.srvLimit_refundAmt"+index).style.display = 'inline';
		

		document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"' checked value='Y' onClick='custSrvLimitChkRefund(this,\""+index+"\")'/><input type='text' name='srvLimit_refundAmt"+index+"' id='srvLimit_refundAmt"+index+"' value='' onBlur='validPercentageForRefundCust(this,\"srvLimit_autoRefund"+index+"\")' onkeypress='return allowValidNumber(this,event,\""+noofdecimal+"\")' size='3' maxlength='4' >";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(12)->cells(13)
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).disabled = false;
	}else{
		obj.value="N";
	//	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_refundAmt"+index).value="";		
	//	eval("document.cust_srvLimit_rate_based_dtl.srvLimit_refundAmt"+index).style.display = 'none';
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).value = "N";
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).checked = false;
		eval("document.cust_srvLimit_rate_based_dtl.srvLimit_autoRefund"+index).disabled = true;

		document.getElementById('cust_srvLimit_rate_based_tbl').rows(parseInt(index)+2).cells(13).innerHTML ="<input type='checkbox' name='srvLimit_refund"+index+"' id='srvLimit_refund"+index+"'  value='N' onClick='custSrvLimitChkRefund(this,\""+index+"\")'/>";
		//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(12)->cells(13)
	}

}

function custSrvLimitFactorAppl(obj,index){	
	if(obj.checked){	
		obj.value="Y";			
	}else{
		obj.value="N";		
}
}
function chkCustSrvLimitDeleteService(obj,index){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

function validateCustServiceLimitForm(srvLimitFormObj,packageCode,index,source){
//	var srvLimitFormObj=parent.frames[2].document.cust_srvLimit_rate_based_dtl;
	//var packageCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.packageCode.value;

	if(srvLimitFormObj.parent_indx.value!=index){
	var totalRecords=srvLimitFormObj.totalRecords.value;
	var obj;
	var message="";	
	for(var i=0;i<parseInt(totalRecords);i++){

		if(eval("srvLimitFormObj.srvLimit_service_code"+i).value!="" &&  (eval("srvLimitFormObj.exludeService"+i).value=="" || eval("srvLimitFormObj.exludeService"+i).value=="N") ){
//Added by Muthukumar against 31573 on 5/3/2012 Ends Here
			if(eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i)!=null && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value!="")
		{	
		if((eval("srvLimitFormObj.srvLimit_amt_limit"+i).value=="" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value!="") || (eval("srvLimitFormObj.srvLimit_amt_limit"+i).value!="" && eval("srvLimitFormObj.srvLimit_amt_limit_ind"+i).value=="") ){
			message=getMessage("BL8561",'BL'); 			
			alert(message);
			eval("formObj.perAmt_limit"+i).focus();
			return false;
		}
		}else
//Added by Muthukumar against 31573 on 5/3/2012 Ends Here

//(eval("srvLimitFormObj.srvLimit_type"+i).value=="C" ||eval("srvLimitFormObj.srvLimit_type"+i).value=="S") && - commented by Muthukumar against 3157 on 5/3/2012 

			if(eval("srvLimitFormObj.srvLimit_amt_limit"+i).value=="" && eval("srvLimitFormObj.srvLimit_qty_limit"+i).value==""){	
					message=getMessage("BL8555",'BL'); 
					if(eval("srvLimitFormObj.srvLimit_qty_limit"+i).disabled)
						obj=eval("srvLimitFormObj.srvLimit_amt_limit"+i);
					else
						obj=eval("srvLimitFormObj.srvLimit_qty_limit"+i);
					alert(message)
					obj.focus();					
					return false
				}
		
				/*if(message !=""){ 				
					alert(message)
					obj.focus();					
					return false
				}*/
	
			
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
						return false	
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
							alert(message)
							obj.focus();					
							return false
				}				


			}
		}
		if(source!="apply"){
			//var xmlString=formCustXMLString(srvLimitFormObj,"CUST_SRVLIMIT_RATE_BASED","excln",packageCode);	
//		alert("formValidation 12");					
			var updation=formValidation(formCustXMLStringMain(srvLimitFormObj),"CUST_SRVLIMIT_RATE_BASED");
		}
		return true;
	}else{
		return true;
	}
	
	
}
function validateCustRateForm(formObj,srvLimitFormObj,packageCode){
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
		result=validateCustServiceLimitForm(srvLimitFormObj,packageCode,"",'apply');	
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
				/*if(message!=""){
					alert(message);
					//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					//obj.focus();
					return false	
				}		*/			
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
				return false	
			}
		}
		 if(eval("formObj.amt_limit_ind"+i)!=null && eval("formObj.amt_limit_ind"+i).value!="" && eval("formObj.amt_limit_ind"+i).value!="U" &&  (eval("formObj.perAmt_limit"+i).value=="")  )
		{	
			message=getMessage("BL8561",'BL'); 			
			alert(message);
			eval("formObj.perAmt_limit"+i).focus();
			return false	
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
			return false	
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

function custValidForAmtPerUnltd(obj1,obj2,index,serv,noofdecimal)
{	 
	//var noOfDecimel = parent.PkgDefHeader.document.forms[0].noofdecimal.value;
	if(obj2.value !="")
	{
		if(obj1.value == "A")
		{
			checkForNegetiveNumber(obj2,noofdecimal,"BL8540");
			if(serv !="CUST_CHARGE_BASED" && serv !="CUST_PRICE" )
			chkCustAmt(obj2,index);
			else if(serv =="CUST_PRICE")
				custValidateWithPkgPrice(obj2,index);

		}
		else if(obj1.value == "P" || obj1.value == "R")
		{
			validPercentage(obj2);
			if(serv !="CUST_CHARGE_BASED" && serv !="CUST_PRICE")
			chkCustAmtPercent(obj2,index);
		}
		else if(obj1.value == "U")
		{
			obj2.value="";
			obj2.disabled = true;
			if(serv !="CUST_CHARGE_BASED")
				chkCustUnlimited(obj2,index)
		}

	}
	else
	{
	}
}
function chkCustAutoRefund(obj,refundAmtObj)
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
function custAssignClosePkgVal(obj,index)
{
	if(obj.checked)
	eval("document.forms[0].closePkg"+index).value=	"Y";
	else
	eval("document.forms[0].closePkg"+index).value=	"N";
}
function validateCustInd(obj,index)
{
    var formObj=document.forms[0];	
	if(formObj.name=="cust_srvLimit_rate_based_dtl"){
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
			if(obj.value == "U" && formObj.name == "cust_rate_based_dtl"){
				//This should get executed only for the form Cust Rate Based
				eval("formObj.qty_limit"+index).value="";
				eval("formObj.qty_limit"+index).disabled=true;
			}
		}
		else {			
			eval("formObj.perAmt_limit"+index).disabled=false;
			if(formObj.name == "cust_rate_based_dtl"){
				//This should get executed only for the form Cust Rate Based
				eval("formObj.qty_limit"+index).disabled=false;
			}			
			if(obj.value == "A") {
				if( eval("formObj.factor_appl"+index)!= undefined)
			   eval("formObj.factor_appl"+index).disabled=false;
			  } 
			else  {
				if( eval("formObj.factor_appl"+index)!= undefined)
			   eval("formObj.factor_appl"+index).disabled=true;
			}
		}
	}
	var formName=formObj.name;
	if(formName =="cust_rate_based_dtl"){
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
    var servGrpLimitSiteSpec  = eval("document.cust_rate_based_dtl.servGrpLimitSiteSpec").value;
    var servGrpLmtBy  = eval("document.cust_rate_based_dtl.servGrpLmtBy").value;
    var servGrpLmtFldDisabled = eval("document.cust_rate_based_dtl.servGrpLmtFldDisabled").value;	
    var order_associated = eval("document.cust_rate_based_dtl.order_associated").value;	 //Added IN73730 by shikha on 19-Aug-2020
    var type = eval("document.cust_rate_based_dtl.type"+index).value; //Added IN73662 by shikha on 21-Aug-2020
    //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	if ((servGrpLimitSiteSpec == "true" && obj.value == "U") || order_associated == "Y" ||type=="S") { //servGrpLmtFldDisabled ==' disabled '){				//Modified IN73730 by shikha on 19-Aug-2020
		eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).disabled = true;//shikha
		eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
		
	}else if (servGrpLimitSiteSpec == "true" && obj.value != "U"){					
		eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).disabled = false;//shikha
		eval("document.cust_rate_based_dtl.serv_grp_limit_ind" + index).value = "";//shikha
		
		if (servGrpLmtBy != "*") {			
			if (servGrpLmtBy == "B" ) {				
				document.getElementById('cust_rate_based_dtl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'"
				+"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='G'>"
				+ getLabel('Common.Group.label', 'Common')
				+ "</option><option value='S'>"
				+ getLabel('eBL.Service.label', 'BL')
				+ "</option></select>";
			} else if (servGrpLmtBy == "G" ) {
				document.getElementById('cust_rate_based_dtl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'" 
				+"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='G'>"
				+ getLabel('Common.Group.label', 'Common')
				+ "</option>"
				+ "</select>";
			} else if (servGrpLmtBy == "S" ) {
				document.getElementById('cust_rate_based_dtl').rows(parseInt(index) + 1)
				.cells(10).innerHTML = "<SELECT name='serv_grp_limit_ind"+ index+"' id='serv_grp_limit_ind"+ index+"'" 
				+"><option value='*'>"
				+ getLabel('Common.defaultSelect.label', 'Common')
				+ "</option><option value='S'>"
				+ getLabel('eBL.Service.label', 'BL')
				+ "</option></select>";
			}

		}	
	}
	//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	}
}
// forming XML String while switching tabs
/*
function formCustXMLString(curr_form,last_link,source,packageCode)
{
	var frmObj="";
	//var packageCode="";
	var total_records="";
	var facilityId ="";
	var locale ="";
	var mode = "";
	if(source=="apply")
	{
		total_records=parent.frames[2].PkgDefFrame.PkgDefCustDetailMainFrame.PkgDefCustHeader.document.frmPkgDefCustHeader.total_records.value;
		facilityId=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
		if(last_link=="CHARGE_BASED_ITEM" || last_link=="SRVLIMIT_RATE_BASED")
			total_records=parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;

	}
	else  if(source=="tab")
	{
		if(parent.PkgDefHeader == undefined)
		{
			total_records=parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
			facilityId=parent.parent.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
			//locale=parent.parent.PkgDefHeader.document.frmPkgDefHeader.locale.value;
			//mode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		}
		else
		{
			total_records=parent.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
			facilityId=parent.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;
			//locale=parent.PkgDefHeader.document.frmPkgDefHeader.locale.value;
			//mode=parent.PkgDefHeader.document.frmPkgDefHeader.mode.value;
		}

	}
	else  if(source=="excln")
	{
		if(parent.parent.PkgDefHeader == undefined)
			total_records=parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
		else
			total_records=parent.parent.PkgDefHeader.document.frmPkgDefHeader.total_records_excln.value;
		//alert("total_records excln :"+total_records)

	}
	else if(source=="maintab")
	{
		total_records=parent.parent.PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.total_records.value;
		facilityId=parent.parent.PkgDefFrame.PkgDefDetailMainFrame.PkgDefHeader.document.frmPkgDefHeader.facilityId.value;

	}

	frmObj =  curr_form;
	//var xmlDoc="";
   // var xmlHttp = new XMLHttpRequest();
  	
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0 )
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

		if(last_link=="CHARGE_BASED_ITEM" ) 
		{	
			var frmObject = "";
			if(source!="apply")
			{
				if(document.frmPkgDefChargeBased == undefined)
					frmObject = parent.frames[0].document.frmPkgDefChargeBased
				else
					frmObject = document.frmPkgDefChargeBased;
			}
			else   
				frmObject = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.ChargeBasedDtl.document.frmPkgDefChargeBased;
			xmlStr+= getServiceCodes(frmObject,last_link,source);
			 //alert("in getservicecode xmlStr:"+xmlStr)
		}
		if(last_link=="SRVLIMIT_RATE_BASED")
		{	
			var frmObject = "";
			//alert("last_link:"+last_link)
			//alert("source:"+source)
			if(source!="apply")
			{  
				if(document.rate_based_dtl == undefined)
					frmObject = parent.frames[0].document.rate_based_dtl
				else
					frmObject = document.rate_based_dtl;
			}
			else  frmObject = parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefDetailFrame.frames[0].document.rate_based_dtl;
			 			//alert("frmObject:"+frmObject) 

			 //  alert("last_link frmObject"+frmObject)
			 xmlStr+= getServiceCodes(frmObject,last_link,source);
			// alert("in getservicecode xmlStr:"+xmlStr)
		}

//	}


	xmlStr+= "total_records=\"" + total_records + "\" " ;
	xmlStr+= "packageCode=\"" + packageCode + "\" " ;
	xmlStr+= "facilityId=\"" + facilityId + "\" " ;
	//xmlStr+= "locale=\"" + locale + "\" " ;
	//xmlStr+= "mode=\"" + mode + "\" " ;
	
	xmlStr +=" /></root>";
	//alert("xmlStr from common :"+xmlStr)
	}

	return xmlStr;
}*/

function initializeCustRateForm(){
	formObj=document.cust_rate_based_dtl;
	table = document.getElementById('cust_rate_based_tbl');
	rowCount = table.rows.length;		
	index = rowCount-2;
	mode=formObj.mode.value;
	acrossEncounters=formObj.acrossEncounters.value;
	copyFrm_pkgCode = "";
		
	copyFrm_pkgCode=parent.parent.frames[0].document.frmPkgDefCustHeader.copyFrm_pkgCode.value;
	
	//if(mode!="modify" && copyFrm_pkgCode==""){
	if(mode=="insert" && copyFrm_pkgCode=="" && formObj.service_code0.value==""){

	for(var i=0;i<index;i++)
	{	
		if((eval("formObj.type"+i).value=="G") || (eval("formObj.type"+i).value=="C")){
			if(eval("formObj.service_code"+i).value==""){
				eval("formObj.qty_limit"+i).disabled=true;
			}
			document.getElementById('cust_rate_based_tbl').rows(parseInt(i)+2).cells(3).innerHTML="<SELECT name='ind"+i+"' id='ind"+i+"' onChange='onCustIndChange(this,\""+i+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
		}else{		
			eval("formObj.qty_limit"+i).disabled=false;
			document.getElementById('cust_rate_based_tbl').rows(parseInt(i)+2).cells(3).innerHTML="<SELECT name='ind"+i+"' id='ind"+i+"' onChange='onCustIndChange(this,\""+i+"\")'><option value='S'>"+getLabel('Common.Standard.label','Common')+"</option><option value='R'>"+getLabel('eBL.AsPerRule.label','BL')+"</option><option value='U'>"+getLabel('Common.UserDefined.label','Common')+"</option><option value='P'>"+getLabel('eBL.PRICE_CLASS.label','BL')+"</option></select>";
		if(acrossEncounters=="Y"){
				document.getElementById('cust_rate_based_tbl').rows(parseInt(i)+2).cells(20).innerHTML="<input type='radio' name='closePkg' id='closePkg' id='closePkg'   onClick='assignClosePkgVal(this,\""+i+"\")'/><input type='hidden' name='closePkg"+i+"' id='closePkg"+i+"' value='N' />";
				//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(17)->cells(18)//MMS-QH-CRF-0170->cells(20)
			}
		}			
	}
	}
	else{	
	for(var i=0;i<index;i++)
	{	
		//if((eval("formObj.type"+i).value=="G") || (eval("formObj.type"+i).value=="C")){//Commented by Muthu against KDAH-SCF-0057 [IN:031860] & Added new line below
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
			//eval("formObj.service_limit"+i).disabled=true;	
			//eval("formObj.service_limit_dtls"+i).disabled=true;			
			document.getElementById('cust_rate_based_tbl').rows(parseInt(i)+2).cells(20).innerHTML="<a name='service_limit_dtls"+i+"' href='#' onClick='custServiceLimitDtls("+i+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)//MMS-QH-CRF-0170->cells(20)
		}	
		if(formObj.order_associated.value=="Y"){
			eval("formObj.perAmt_limit"+i).disabled=true;
			/*eval("formObj.amt_percentage"+i).disabled=true;
			eval("formObj.amt_limit"+i).disabled=true;
			eval("formObj.unlimited"+i).disabled=true;	*/
			//eval("formObj.service_limit"+i).disabled=true;		
		//	eval("formObj.service_limit_dtls"+i).disabled=true;	
			document.getElementById('cust_rate_based_tbl').rows(parseInt(i)+2).cells(20).innerHTML="<a name='service_limit_dtls"+i+"' href='#' onClick='custServiceLimitDtls("+i+")'  disabled>"+getLabel('eBL.Dtls.label','BL')+"</a>";
			//Modified V190626-Aravindh/MMS-DM-CRF-0129.1/cells(18)->cells(19)//MMS-QH-CRF-0170->cells(20)
			
		}else{
			//eval("formObj.perAmt_limit"+i).disabled=false;
			/*eval("formObj.amt_percentage"+i).disabled=false;
			eval("formObj.amt_limit"+i).disabled=false;
			eval("formObj.unlimited"+i).disabled=false;	*/		
		}
	
		if(eval("formObj.amt_limit_ind"+i).value!="P"){
			//eval("formObj.amt_limit"+i).value="";
			//eval("formObj.amt_limit"+i).disabled=true;
			eval("formObj.factor_appl"+i).value="";
			eval("formObj.factor_appl"+i).checked=false;
			eval("formObj.factor_appl"+i).disabled=true;		
		}
		else if(eval("formObj.amt_limit_ind"+i).value!="A")
		{
	
			if(eval("formObj.perAmt_limit"+i).value>0){
				eval("formObj.factor_appl"+i).disabled=false;
			}else{
				//eval("formObj.factor_appl"+i).disabled=true;
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

	   /*
		if(eval("formObj.amt_percentage"+i).value!=""){
			eval("formObj.amt_limit"+i).value="";
			eval("formObj.amt_limit"+i).disabled=true;
			eval("formObj.factor_appl"+i).value="";
			eval("formObj.factor_appl"+i).checked=false;
			eval("formObj.factor_appl"+i).disabled=true;		
		}
		if(eval("formObj.amt_limit"+i).value!=""){
			eval("formObj.amt_percentage"+i).value="";
			eval("formObj.amt_percentage"+i).disabled=true;			
			if(eval("formObj.amt_limit"+i).value>0){
				eval("formObj.factor_appl"+i).disabled=false;
			}else{
				eval("formObj.factor_appl"+i).disabled=true;
			}
		}else{
				eval("formObj.factor_appl"+i).disabled=true;
		}
		if(eval("formObj.unlimited"+i).checked){
		
			eval("formObj.qty_limit"+i).value="";
			eval("formObj.qty_limit"+i).disabled=true;
			eval("formObj.amt_percentage"+i).value="";
			eval("formObj.amt_percentage"+i).disabled=true;
			eval("formObj.amt_limit"+i).value="";
			eval("formObj.amt_limit"+i).disabled=true;
			eval("formObj.factor_appl"+i).value="";		
			eval("formObj.factor_appl"+i).checked=false;		
			eval("formObj.factor_appl"+i).disabled=true;	
		
		}	*/
	}
	}
}

function custCallLookup(obj,code,desc,functionId,index)
{	
	var prevCode = eval("document.forms[0].cbCodePrev_"+index)
	var prevDesc = eval("document.forms[0].cbDescPrev_"+index)
	if(obj.value == "")
	{
		clearRow(document.forms[0],index);
		if(functionId=="CUST_CHARGE_BASED"){
			var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value
			var currKey=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~"+eval("document.forms[0].cbCode_"+index).value);
			var oldSrvKey=eval("document.forms[0].oldSrvKey"+index).value
			//if(mode=='insert' && oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
			if( oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
				removeBeanKey(document.forms[0],oldSrvKey,index);	
				parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
				parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
				parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";				
				//parent.frames[2].location.href='../../eCommon/html/blank.html' for testing purpose
				//parent.frames[3].location.href='../../eCommon/html/blank.html'   and added new frame for hdr
				parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[4].location.href='../../eCommon/html/blank.html'
				parent.frames[5].location.href='../../eCommon/html/blank.html'
			}	
			eval("document.forms[0].oldSrvKey"+index).value=currKey
		}
	}
	else 
	{		
		var flag	 = false;
		if(prevCode.value!="" && code.value !=prevCode.value)
		{
			desc.value=""
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
			
			if(functionId=='CUST_CHARGE_BASED_ITEM'){
				custCallServices(code,desc,functionId,'',index)
			}
			else
				{
				custCallServices(code,desc,functionId,document.getElementById("charge_type"+index),index)
				
				}
			
			//custCallServices(code,desc,functionId,index)
		}
	}
	IncludeHomeMedicationCustGlobal(code,document.getElementById("charge_type"+index),index);
}
function custCallServices(code,desc,functionId,charge_type,index,sql)
//function custCallServices(code,desc,functionId,index,sql)
{
		
	var prevCode = eval("document.forms[0].cbCodePrev_"+index)
	var prevDesc = eval("document.forms[0].cbDescPrev_"+index)
	if(code.value =="" || desc.value=="")
	{
		var locale = document.forms[0].locale.value;
		var value = code.value;
		if(desc.value != "")
			value = desc.value;
		var sql = "";
		/*if(functionId=="CUST_CHARGE_BASED")
			sql="select blng_serv_code code, short_desc description from bl_blng_serv_lang_vw where rate_entry_by_user_flag='C' and language_id= '"+locale+"' and status is null and upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?)";
		else  if(functionId=="CUST_CHARGE_BASED_ITEM")
			sql="SELECT a.item_code code, c.long_desc description FROM bl_st_item a,  mm_item_lang_vw c WHERE a.sale_category_code in (select  sale_category_code  from  bl_st_item_sale_catg_dtl where blng_serv_code = '"+document.forms[0].parent_service_code.value+"') and a.item_code = c.item_code AND c.language_id = '"+locale+"' and upper(a.item_code) like upper(?) and upper(long_desc) like upper(?)";*/
//Newly added by muthu against 28192 - above code is commented for testing
		if(charge_type.value=="S"){
		sql	=  "SELECT   blng_serv_code code, short_desc description FROM bl_blng_serv_lang_vw WHERE language_id = '" +locale +"' and status is null AND RATE_ENTRY_BY_USER_FLAG = 'C' AND UPPER (blng_serv_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY 2 ";//GHL-CRF-0520.1
		title=getLabel("Common.BillingService.label","common");
		}
		else if(charge_type.value=="M")	{
		sql	=  "select item_code code,short_Desc description from MM_ITem_lang_vw where  language_id='"+locale+"' and upper(item_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
		title=getLabel("Common.item.label","common");	
		}
		else  if(functionId=="CUST_CHARGE_BASED_ITEM"){
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
				if(functionId=='CUST_CHARGE_BASED'){
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
	if(functionId=="CUST_CHARGE_BASED"){
		var mode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value
		var currKey=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~"+eval("document.forms[0].cbCode_"+index).value);
		var oldSrvKey=eval("document.forms[0].oldSrvKey"+index).value
		//if(mode=='insert' && oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
		if(oldSrvKey!="" && oldSrvKey!=trimString(document.forms[0].cust_grp_code.value+"~~"+document.forms[0].cust_code.value+"~~"+document.forms[0].fromDate.value+"~~") && currKey !=oldSrvKey){
			removeBeanKey(document.forms[0],oldSrvKey,index);	
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
			parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";			
			//parent.frames[2].location.href='../../eCommon/html/blank.html'
			//parent.frames[3].location.href='../../eCommon/html/blank.html' commented to lines and addd new frame by ram
			parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[4].location.href='../../eCommon/html/blank.html'
				parent.frames[5].location.href='../../eCommon/html/blank.html'
		}	
		eval("document.forms[0].oldSrvKey"+index).value=currKey
	}
	IncludeHomeMedicationCustGlobal(code,charge_type,index);
}

function chkCustRefundCB(obj,index){	
	var noofdecimal=document.forms[0].noofdecimal.value	

	if(obj.checked){	
		obj.value="Y";	
		//eval("document.getElementById("refundAmt_")"+index).style.display="inline";
		
		document.getElementById('cust_charge_based_tbl').rows(parseInt(index)+2).cells(7).innerHTML ="<input type='checkbox'  checked name='refund_"+index+"' id='refund_"+index+"' value='Y' onClick='chkCustRefundCB(this,\""+index+"\")'/><input type='text' name='refundAmt_"+index+"' id='refundAmt_"+index+"' id='refundAmt_"+index+"'  value='' onBlur='return validPercentageForRefundCust(this,\"autoRefund_"+index+"\")' onkeypress='return ChkNumberInput(this,event,\""+noofdecimal+"\")' size='2' maxlength='4'  >";	
		eval("document.forms[0].autoRefund_"+index).disabled = false;

	}else{
		obj.value="N";	
		
		eval("document.forms[0].autoRefund_"+index).value = "N";
		eval("document.forms[0].autoRefund_"+index).checked = false;
		document.getElementById('cust_charge_based_tbl').rows(parseInt(index)+2).cells(7).innerHTML ="<input type='checkbox'   name='refund_"+index+"' id='refund_"+index+"' value='N' onClick='chkCustRefundCB(this,\""+index+"\")'/>";	
		eval("document.forms[0].autoRefund_"+index).disabled = true;
	
	}

}

function loadCustChargeBasedServiceLimit(value,index)
{	
	var frmObj = parent.cust_charge_based_excl.document.forms[0];
	var packageCode=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
	var authorized=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.authorized.value;
	var pkgApprovedYN=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.pkgApprovedYN.value;
	//var copyFrm_pkgCode=parent.parent.PkgDefHeader.document.frmPkgDefHeader.copyFrm_pkgCode.value;
	var fromDate=document.forms[0].fromDate.value;
	var fromDateTemp=document.forms[0].fromDateTemp.value;
	var cust_grp_code=document.forms[0].cust_grp_code.value;
	var cust_grp_desc=encodeURIComponent(document.forms[0].cust_grp_desc.value);
	var cust_code=document.forms[0].cust_code.value;
	var cust_desc=encodeURIComponent(document.forms[0].cust_desc.value);
	var service_desc=encodeURIComponent(eval("document.forms[0].cbDesc_"+index).value);

	var mode = parent.parent.PkgDefCustHeader.document.forms[0].mode.value
	if(frmObj!=null && frmObj!=undefined)
	{
		//alert('before xml')
		//var xmlString=formXMLString(frmObj,"CHARGE_BASED_ITEM","excln",packageCode);
		//alert("xmlString:"+xmlString)
		//var updation=formValidation(xmlString,"CHARGE_BASED_ITEM");
//			alert("formValidation 13");			
		
		var updation=formValidation(formCustXMLStringMain(frmObj),"CUST_CHARGE_BASED_ITEM");
	}	
	if(value == null || value== "" )
	{		alert(getMessage("BL8559",'BL'));
		parent.cust_charge_based_excl_hdr.location.href='../../eCommon/html/blank.html';	
		parent.cust_charge_based_excl.location.href='../../eCommon/html/blank.html';
		parent.cust_charge_based_excl_btn.location.href='../../eCommon/html/blank.html';		
	}else{		
		parent.cust_charge_based_excl_hdr.location.href='../../eCommon/html/blank.html';	
		parent.cust_charge_based_excl.location.href='../../eBL/jsp/PkgDefCustChargeBasedExclusion.jsp?packageCode='+packageCode+'&service_code='+value+'&mode='+mode+'&fromDate='+encodeURIComponent(fromDate)+'&cust_grp_code='+cust_grp_code+'&cust_grp_desc='+encodeURIComponent(cust_grp_desc)+'&cust_code='+cust_code+'&cust_desc='+encodeURIComponent(cust_desc)+'&service_desc='+service_desc+'&parent_indx='+index+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN+"&fromDateTemp="+encodeURIComponent(fromDateTemp);
		parent.cust_charge_based_excl_btn.location.href='../../eBL/jsp/PkgDefCustBtn.jsp?packageCode='+packageCode+'&table_name=cust_charge_based_excl_tbl&func_mode=CUST_CHARGE_BASED_ITEM&mode='+mode+'&authorized='+authorized+'&pkgApprovedYN='+pkgApprovedYN
	}

}
function validateCustPackagePrice(formObj,totalRec,calledFrom)
{
	var flag = true;
	for(var i=0;i<totalRec; i++)
	{	
		// sarath added MMS-QF-SCF-0545 CustomerLevel Begining..
		if (calledFrom == 'apply') {
			if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document
					.getElementById('blgClsCode_' + i).value == "") {
				alert('Atleast One Entry for Package Base Price Must be Provided');
				return false;
			}
			if (parent.frames[2].PkgDefFrame.PkgDefDetailMainFrame.PkgDefCustDetailFrame.cust_base_price_dtl.document
					.getElementById('price_' + i).value == "") {
				alert(getMessage("BL8527", 'BL'));
				return false;

			}
		}
		// sarath added MMS-QF-SCF-0545 CustomerLevel Ending..
		
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
					return false	
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
function validateCustChargeBased(formObj,totalRec)
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
				return false	
			}	
		}
	}
	return true;
}  

function custExcludeItem(obj,index)
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
	/*if(obj.value == "E")
	{
		eval("document.forms[0].amountLimit_"+index).readOnly=true;
		eval("document.forms[0].quantityLimit_"+index).readOnly=true;
		eval("document.forms[0].amountLimit_"+index).value="";
		eval("document.forms[0].quantityLimit_"+index).value="";

	}
	else
	{
		eval("document.forms[0].amountLimit_"+index).readOnly=false;
		eval("document.forms[0].quantityLimit_"+index).readOnly=false;
	} */
}

//Mandatory Check for Charge based items
function validateCustChargeBasedItems(formObj,totalRec)
{
	for(var i=0;i<totalRec; i++)
	{
		if((eval("formObj.cbCode_"+i)) !=undefined && (eval("formObj.cbCode_"+i).value) !="")
		{
			if((eval("formObj.inEx_"+i).value) == "N")
			{
				if((eval("formObj.quantityLimit_"+i).value) == "" &&  (eval("formObj.amountLimit_"+i).value) == "" )
				{
					//alert("Please enter amount");
					alert(getMessage("BL8541","BL"));					
					eval("formObj.quantityLimit_"+i).focus();
					return false;
				}
			}
		}
	}
	return true;

} 

function saveCustPriceSrvDtls(index){	
//alert();
	var hdrFormObj=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader
	var destFrame=parent.parent.PkgDefCustDetailFrame;
	var packageCode=hdrFormObj.packageCode.value
	var mode=hdrFormObj.mode.value;
	var copyFrm_pkgCode=hdrFormObj.copyFrm_pkgCode.value;
	var orderAssociated = hdrFormObj.orderAssociated.value;
	
	var last_link=hdrFormObj.last_link.value;
	var current_form1 = hdrFormObj.current_form1.value;	
	var excln_form1 = hdrFormObj.current_form2.value;
	var current_form ;
	var parent_index="";	
	if(current_form1!=""){
		current_form=destFrame.frames[1].document.forms[0] //frame ref changed 0 to 1 by ram
		parent_index=current_form.parent_index.value; 
	}else
		current_form="";
	if(parent_index!=index){
		var excln_form ;
		if(excln_form1!="" )			
			excln_form= destFrame.frames[4].document.forms[0] 		
		else
			excln_form="";
		var result  = true;
		var excln_link = "";
		if(last_link == "CUST_CHARGE_BASED")
		{
			excln_link="CUST_CHARGE_BASED_ITEM";
			current_form=destFrame.frames[1].document.forms[0]  //frame ref changed 0 to 1
				
			result =validateCustChargeBased(current_form,current_form.totalRecords.value)
			if(result)
			{
				if(excln_form != undefined && excln_form != "")
					result =validateCustChargeBasedItems(excln_form,excln_form.totalRecords.value)
			}
		}
		if(last_link == "CUST_RATE_BASED")
		{
			
			excln_link="CUST_SRVLIMIT_RATE_BASED";					
			
			result=validateCustRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
		}
		if(result)
		{
			if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
				var  frmObj	 = excln_form
				if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
				{				
									
					 updation=formValidation(formCustXMLStringMain(frmObj),excln_link);
					// parent.parent.PkgDefCustDetailFrame.frames[2].location.href='../../eCommon/html/blank.html'
				}
				 frmObj	 = current_form
				if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
				{										
				
					updation=formValidation(formCustXMLStringMain(frmObj),last_link);
					//parent.parent.PkgDefCustDetailFrame.frames[0].location.href='../../eCommon/html/blank.html'
				}
				
				parent.parent.PkgDefCustTabFrame.location.href='../../eCommon/html/blank.html'
				parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html'
				
				hdrFormObj.last_link.value="";
				hdrFormObj.current_form1.value="";				
				hdrFormObj.current_form2.value="";
			}	
		}
	}
	formObj=parent.parent.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl
	var currKey=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~"+eval("formObj.fromDate_"+index).value);
	var oldPeriodKey=eval("formObj.oldPeriodKey"+index).value
	if(mode=='insert' && oldPeriodKey!="" && oldPeriodKey!=trimString(formObj.cust_grp_code.value+"~~"+formObj.cust_code.value+"~~") && currKey !=oldPeriodKey){
		removeBeanKey(formObj,oldPeriodKey,index);
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.last_link.value="";
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form1.value="";
		parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.current_form2.value="";	
		parent.parent.PkgDefCustTabFrame.location.href='../../eCommon/html/blank.html'
		parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html'
	}
	
	return true;
}
function saveCustPeriodDtls(index){
	var hdrFormObj=parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader
	var destFrame=parent.parent.PkgDefCustDetailFrame;
	var packageCode=hdrFormObj.packageCode.value
	var mode=hdrFormObj.mode.value;
	var copyFrm_pkgCode=hdrFormObj.copyFrm_pkgCode.value;
	var orderAssociated = hdrFormObj.orderAssociated.value;
	if(parent.parent.PkgDefCustBaseDateMain.cust_period_dtl!=null){
		formObj=parent.parent.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl
		if(formObj!=null && formObj!="undefined"){
			
			result=validateCustPackageDates(formObj,parseInt(formObj.totalRecords.value))
			var parent_index=formObj.parent_index.value;
			
			if(parent_index!=index){
				var last_link=hdrFormObj.last_link.value;
				var current_form1 = hdrFormObj.current_form1.value;				
				var excln_form1 = hdrFormObj.current_form2.value;
				var current_form ;
				if(current_form1!=""){
					current_form=destFrame.frames[1].document.forms[0]  //frame ref changed 0 to 1 by ram
//						alert("parent 1:"+destFrame.frames[1].name)
				}
				else
					current_form="";
				var excln_form ;
				if(excln_form1!="" ){
					excln_form= destFrame.frames[4].document.forms[0]   //frame ref changed 2 to 4 by ram
//						alert("destFrame.frames[2] wew :" +destFrame.frames[4].name);
				}
				 else
					excln_form="";
				var result  = true;
				var excln_link = "";
				if(last_link == "CUST_CHARGE_BASED")
				{
					excln_link="CUST_CHARGE_BASED_ITEM";
					current_form=parent.parent.PkgDefCustDetailFrame.frames[1].document.forms[0] //frame  ref changed 0 to 1 by ram
						//alert("parent :"+parent.parent.PkgDefCustDetailFrame.frames[1].name)
						

					result =validateCustChargeBased(current_form,current_form.totalRecords.value)
					if(result)
					{
						if(excln_form != undefined && excln_form != "")
							result =validateCustChargeBasedItems(excln_form,excln_form.totalRecords.value)
					}
				} 
				if(last_link == "CUST_RATE_BASED")
				{
					
					excln_link="CUST_SRVLIMIT_RATE_BASED";							
					result=validateCustRateForm(current_form,excln_form,hdrFormObj.packageCode.value);
				}
				if(parent.parent.PkgDefCustBaseDateMain.cust_period_dtl!=null){
					formObj=parent.parent.PkgDefCustBaseDateMain.cust_period_dtl.document.cust_period_dtl
					if(formObj!=null && formObj!="undefined"){
						
						result=validateCustPackageDates(formObj,parseInt(formObj.totalRecords.value))
					}
				}
				if(result)
				{
					if(last_link!=null  && last_link != "undefined" && last_link!=""  ){
						var  frmObj	 = excln_form
						if(frmObj!=null && frmObj != "undefined" && frmObj!="" )
						{				
											
							updation=formValidation(formCustXMLStringMain(frmObj),excln_link);
						}
						frmObj	 = current_form
						if(frmObj!=null && frmObj!= "undefined" && frmObj!="")
						{			
									
							updation=formValidation(formCustXMLStringMain(frmObj),last_link);
							//parent.parent.PkgDefCustDetailFrame.frames[0].location.href='../../eCommon/html/blank.html'
						}
					}	
		
					update=formValidation(formCustXMLStringMain(formObj),"custPeriod");
					parent.parent.PkgDefCustBaseDateMain.location.href='../../eCommon/html/blank.html'
					parent.parent.PkgDefCustTabFrame.location.href='../../eCommon/html/blank.html'
					parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html'
					hdrFormObj.last_link.value="";
					hdrFormObj.current_form1.value="";					
					hdrFormObj.current_form2.value="";
				}
			}
		}
	}
	formObj=document.cust_dtls
	var currKey=trimString(eval("formObj.cust_grp_code"+index).value+"~~"+eval("formObj.cust_code"+index).value);
	var oldKey=eval("formObj.oldKey"+index).value
//alert("currKey : "+currKey);
//alert("oldKey : "+oldKey);
	if(mode=='insert' && oldKey!="" && currKey !=oldKey){
		removeBeanKey(formObj,oldKey,index)
		hdrFormObj.last_link.value="";
		hdrFormObj.current_form1.value="";		
		hdrFormObj.current_form2.value="";
		parent.parent.PkgDefCustBaseDateMain.location.href='../../eCommon/html/blank.html'
		parent.parent.PkgDefCustTabFrame.location.href='../../eCommon/html/blank.html'
		parent.parent.PkgDefCustDetailFrame.location.href='../../eCommon/html/blank.html'
	}
	
	return true;
}

function validateCustPackageDates(formObj,totalRec)
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
		//	eval(formObj + ".VATpercent" + i).value = "";
			return false;
		}
		if( (eval("formObj.VATapp"+i).value=="Y"  && eval("formObj.ruleCoverageInd"+i).value=="D"))
		{
		
			alert(getMessage("BLSS0073", 'BL'));
		//	eval(frmObj + ".VATpercent" + i).value = "";
			return false;
		}
		
		}
	}
return true;	
}
function validateCustomers(formObj)
{ 
	var totalRec=parseInt(formObj.totalRecords.value);
	for(var i=0;i<totalRec; i++)
	{		
		/*	if(eval("formObj.cust_grp_code"+i) ==undefined || (eval("formObj.cust_grp_code"+i).value) =="")
			{
				alert ("Customer Group Cannot be Blank!");
				eval("formObj.cust_grp_code"+i).focus();
				return false;
			}*/
			
			if(eval("formObj.cust_grp_code"+i).value !="" && (eval("formObj.cust_code"+i) ==undefined || (eval("formObj.cust_code"+i).value) ==""))
			{
				alert ("Customer Cannot be Blank!");
				eval("formObj.cust_code"+i).focus();
				return false;
			}
		
	}
return true;	
}

/*function renameBeanKey(formObj,currKey,oldKey,index){

	var xmlStr ="<root><SEARCH ";
	if(formObj.name=="cust_dtls"){			
		rename_func_mode = "rename_cust";
		func_mode=	"CUSTOMER";	
	}
	xmlStr+= "currKey=\"" +currKey+ "\" " ;
	xmlStr+= "oldKey=\"" +oldKey+ "\" " ;
	xmlStr +=" /></root>";
	alert('in renameBeanKey(), save current form='+formObj.name)
	var updation=formValidation(formCustXMLStringMain(formObj),func_mode);	
	if(rename_func_mode!=""){
		alert('in renameBeanKey(),rename form='+formObj.name)
		 updation=formValidation(xmlStr,rename_func_mode);	
		}
	
}*/

function removeBeanKey(formObj,oldKey,index){

	var frameObj="";	
	var packageCode		= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;	
	var mode			= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value;
	var result=true;
	var updation=true;
	var func_mode="";
	var del_func_mode="";
	if(formObj.name=="cust_dtls"){
			frameObj=parent.frames[0];
			table = frameObj.document.getElementById('cust_tbl');
			func_mode = "CUSTOMER";			
			del_func_mode = "delete_cust";							
	}else if(formObj.name=="cust_period_dtl"){
			frameObj=parent.frames[0];
			table = frameObj.document.getElementById('cust_period_tbl');
			func_mode = "custPeriod";			
			del_func_mode = "delete_cust_period";			
	}else if(formObj.name=="cust_rate_based_dtl"){
//			frameObj=parent.frames[0]; frame ref changed frames[0] to frames[1]
			frameObj=parent.frames[1];
			table = frameObj.document.getElementById('cust_rate_based_tbl');
			func_mode = "CUST_RATE_BASED";			
			del_func_mode = "delete_cust_rate_based";				
			//parent.frames[2].location.href="../../eCommon/html/blank.html"; commented and added new lines
			//parent.frames[3].location.href="../../eCommon/html/blank.html";		
			parent.frames[3].location.href="../../eCommon/html/blank.html"; 
			parent.frames[4].location.href="../../eCommon/html/blank.html";
			parent.frames[5].location.href="../../eCommon/html/blank.html";
	}else if(formObj.name=="cust_charge_based_dtl"){				
			frameObj=parent.frames[1]; //frame ref changed to frames[0] to frames[1]
			table = frameObj.document.getElementById('cust_charge_based_tbl');
			func_mode = "CUST_CHARGE_BASED";			
			del_func_mode = "delete_cust_charge_based";			
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
	updation=formValidation(formCustXMLStringMain(formObj),func_mode);	
	//alert('del_func_mode='+del_func_mode);
	if(del_func_mode!=""){		
		updation=formValidation(xmlStr,del_func_mode);	
		}

}
function custGlSmryCodeLookUp(glSmryDesc,glSmry,index){

	var formObj=document.cust_period_dtl;
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
					eval("document.forms[0].glSmryDesc"+index).value =  ""
					eval("formObj.glSmry_temp"+index).value= "";
					eval("formObj.glSmryDesc_temp"+index).value="";										
				}
			}
		}
	}	
}
function custGlSmryDescLookUp(glSmryDesc,glSmry,index){
	var formObj=document.cust_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmryDesc_temp"+index+".value") != eval("formObj.glSmryDesc"+index+".value"))
		{
			if(eval("formObj.glSmryDesc"+index).value != "")
				show_custGlSmryLookUp(glSmryDesc,glSmry,index);
		}
	}
}
function custGlSmryLookUp(glSmryDesc,glSmry,index){
	var formObj=document.cust_period_dtl;
		if(formObj!=null){
			if(eval("formObj.glSmryDesc"+index).value == ""){
					show_custGlSmryLookUp(glSmryDesc,glSmry,index);
			}
		}
}
function show_custGlSmryLookUp(glSmryDesc,glSmry,index){	
	var formObj=document.cust_period_dtl;
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
		eval("document.forms[0].glSmryDesc"+index).value =  ""
		eval("formObj.glSmry_temp"+index).value= "";
		eval("formObj.glSmryDesc_temp"+index).value="";			
	}
}

function validPercentageForRefundCust(obj,autoRefundAmtObj){
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


function checkCustPartialDeposit(obj,index)
{
	if(obj.checked)
	{
		eval("document.forms[0].minDepAmtind_"+index).disabled = false;
		//eval("document.forms[0].minDepAmt_"+index).disabled = false;

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


function checkCustDeposit(obj,index)
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
function custValidateWithPkgPrice(obj,index)
{
	var pkgPrice	= eval("document.forms[0].price_"+index).value
	var pkgPriceInd = eval("document.forms[0].indicator_"+index).value
	var minDepAmt	= obj.value;
	if(pkgPriceInd=="R" && (parseFloat(minDepAmt)>parseFloat(pkgPrice)))
	{
		alert("Minimun deposit should be less than or equal to Package price");
		obj.value="";
		obj.focus();
		//alert(getMessage("BL9306","BL"));
	}
}

function validateCustBaePrice(obj,noofdecimal,msg,index)
{
	checkForNegetiveNumber(obj,noofdecimal,msg)
	if(obj!=null && obj.value !="")
	{
		if(eval("document.forms[0].minDepAmtind_"+index).value=="A")
		custValidateWithPkgPrice(eval("document.forms[0].minDepAmt_"+index),index)
	}
	else
	{
		eval("document.forms[0].roundTo_"+index).value = "";
		eval("document.forms[0].roundInd_"+index).selectedIndex = 0;
		eval("document.forms[0].minDepAmt_"+index).value = "";
	}
}

function custGlSmryDiscCodeLookUp(glSmryDiscDesc,glSmryDisc,index){

	var formObj=document.cust_period_dtl;
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
					eval("document.forms[0].glSmryDiscDesc"+index).value =  ""
					eval("formObj.glSmryDisc_temp"+index).value= "";
					eval("formObj.glSmryDiscDesc_temp"+index).value="";										
				}
			}
		}
	}	
}
function custGlSmryDiscDescLookUp(glSmryDiscDesc,glSmryDisc,index){
	var formObj=document.cust_period_dtl;
	if(formObj!=null){
		if(eval("formObj.glSmryDiscDesc_temp"+index+".value") != eval("formObj.glSmryDiscDesc"+index+".value"))
		{
			if(eval("formObj.glSmryDiscDesc"+index).value != "")
				show_custGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index);
		}
	}
}
function custGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index){
	var formObj=document.cust_period_dtl;
		if(formObj!=null){
			if(eval("formObj.glSmryDiscDesc"+index).value == ""){
					show_custGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index);
			}
		}
}
function show_custGlSmryDiscLookUp(glSmryDiscDesc,glSmryDisc,index){	
	var formObj=document.cust_period_dtl;
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
		eval("document.forms[0].glSmryDiscDesc"+index).value =  ""
		eval("formObj.glSmryDisc_temp"+index).value= "";
		eval("formObj.glSmryDiscDesc_temp"+index).value="";			
	}
}

//Added by MuthukumarN against 31860 on 5/4/2012 - Starts Here

function CopyBaseChk()
{
	var copyReplaceFlag ="";
	var packageCode		= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
	var pakEffDate = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.effFromDate.value;
	var cust_grp_code = parent.frames[0].document.forms[0].cust_grp_code.value;
	var cust_grp_desc = parent.frames[0].document.forms[0].cust_grp_desc.value;
	var cust_code = parent.frames[0].document.forms[0].cust_code.value;				
	var cust_desc = parent.frames[0].document.forms[0].cust_desc.value;
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
	//parent.parent.PkgDefCustTabFrame.location.href="../../eBL/jsp/PkgDefCustTab.jsp?param="+param+"&packageCode="+packageCode+"&pakEffDate="+pakEffDate+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&fromDate="+fromDate;
	parent.parent.PkgDefCustTabFrame.location.href="../../eBL/jsp/PkgDefCustTab.jsp?param="+param+"&param1="+param1+"&param2="+param2+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&fromDate="+fromDate+"&cust_grp_desc="+cust_grp_desc+"&cust_desc="+cust_desc;
}
function ReplaceBaseChk()
{	
	var copyReplaceFlag ="";
	var packageCode		= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.packageCode.value;
	var pakEffDate = parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.effFromDate.value;
	var cust_grp_code = parent.frames[0].document.forms[0].cust_grp_code.value;
	var cust_grp_desc = parent.frames[0].document.forms[0].cust_grp_desc.value;
	var cust_code = parent.frames[0].document.forms[0].cust_code.value;
	var cust_desc = parent.frames[0].document.forms[0].cust_desc.value;
	var fromDate = document.forms[0].fromDate.value;
	//alert("fromDate ==> "+fromDate);
	var replace_base = confirm(getMessage('BL9126','BL'))
		if(replace_base == true)
			copyReplaceFlag="R";
		else
			copyReplaceFlag="N";
	//	alert("copyReplaceFlag Replace ==> "+copyReplaceFlag);
	var param = copyReplaceFlag;
	var param1 = packageCode;
	var param2 = pakEffDate;
	/*var param = "copyReplaceFlag="+copyReplaceFlag;
	var param1 = "packageCode="+packageCode;
	var param2 = "pakEffDate="+pakEffDate;*/
		parent.parent.PkgDefCustTabFrame.location.href="../../eBL/jsp/PkgDefCustTab.jsp?param="+param+"&param1="+param1+"&param2="+param2+"&cust_grp_code="+cust_grp_code+"&cust_code="+cust_code+"&fromDate="+fromDate+"&cust_grp_desc="+cust_grp_desc+"&cust_desc="+cust_desc;
}
//Added by MuthukumarN against 31860 on 5/4/2012 - Ends Here





function includeHomeMedicationEnableCust(){ 	
//alert("inside includehomemedication enable cust")
		var AllYn=parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].AllYn.value;
		var IpYn= parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].IpYn.value;
		var DcYn= parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].DcYn.value;
		var OpYn= parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].OpYn.value;
		var EmYn=parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].EmYn.value;
		
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

function IncludeHomeMedicationCustGlobal(codeObj,typeObj,index){   //saraa
	

	var service_code=codeObj.value;
	var type=typeObj.value;
	var includeHomeMedicationAllYN="";
	
	var IpYn= parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].IpYn.value;
	var DcYn= parent.parent.PkgDefCustHeader.frmPkgDefCustHeader.document.forms[0].DcYn.value;
	
	
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



//sarathkumar InclHmeMedi 
function IncludeHomeMedicationcustExclude(obj,code,type,indx){
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
		IncludeHomeMedicationCustGlobal(code, type, indx);
	}
	}
}















function IncludeHomeMedicationCheckCust(service_desc,index){   //saraa
	
	var formObj=document.cust_rate_based_dtl;
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

	//alert("reqId"+includeHomeMedicationAllYN);
			if(includeHomeMedicationAllYN == 'Y' ){
				//alert("reqId enabled");
			$('#includeHomeMedication'+index).prop("disabled", false);
			$('#enableDisParam'+index).val('Y');

		}else if(includeHomeMedicationAllYN == 'N'){	
			//alert("reqId disabled")
			$('#includeHomeMedication'+index).prop("disabled", true);
			$('#enableDisParam'+index).val('N');
		
		}
}
function IncludeHomeMedicationCheckCustCharge(code,index){   

	
	frameObj=parent.frames[1];
	table = frameObj.document.getElementById('cust_charge_based_tbl');
	formObj=frameObj.document.cust_charge_based_dtl;
	var code=document.getElementById("cbCode_"+index).value;
	var type=document.getElementById("charge_type"+index).value;
	var includeHomeMedicationAllYN="";
	

	
	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?code="+code+"&type="+type,
		async:false,
		dataType:"json",
		success : function(data){
			alert(data)
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
function IncludeHomeMedicationCheckCustChargeExclude(code,index){
	
	frameObj=parent.frames[1];
	table = frameObj.document.getElementById('cust_charge_based_tbl');
	formObj=frameObj.document.cust_charge_based_dtl;
	var code=document.getElementById("cbCode_"+index).value;
	var type="M";
	var includeHomeMedicationAllYN="";

	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?code="+code+"&type="+"M",
		async:false,
		dataType:"json",
		success : function(data){
			alert(data)
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
function chkCustExludeServiceonload(){
	var formObj=document.cust_srvLimit_rate_based_dtl;
	var mode			= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value;
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

function chkCustChargeExludeServiceonload(){
	var formObj=document.cust_charge_based_excl_dtl;
	var mode			= parent.parent.PkgDefCustHeader.document.frmPkgDefCustHeader.mode.value;
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
//Added V190404-Dhananjay/MMS-DM-CRF-0129
function dailyLmtChkBxClickPharmaCust(code, type, index) {
	var service_code = code.value;
	var type = type.value
	var reqId = "N";
	var order_associated = document.getElementById("order_associated").value;
	var policyParam = 'calledFrom=rate_based_dtl' +'&type=' +type+'&service_code=' + service_code;
	$.ajax({
		type:'GET',
		url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
    data: policyParam,
    dataType: "json",
    async: false,
		success : function(data){
			reqId=$.trim(data.dailyLimitYN);
		}
	});
	if(reqId != 'R') { 
		if(reqId == 'N' || order_associated  == 'Y'){
			document.getElementById("dailyLmtChkBx"+index).disabled = true;
			document.getElementById("dailyLmtChkBx"+index).value = 'N';
			document.getElementById("dailyLmtChkBx"+index).checked=false; 
			document.getElementById("dailyLmtAmt"+index).disabled = true;
			document.getElementById("dailyLmtAmt"+index).value = "";
			document.getElementById("dailyLmtGrossNetList"+index).disabled = true;
			document.getElementById("dailyLmtGrossNetList"+index).value = "G";
			
		} else {
			document.getElementById("dailyLmtChkBx"+index).disabled = false;
			//document.getElementById("dailyLmtAmt"+index).disabled = false;
			//document.getElementById("dailyLmtGrossNetList"+index).disabled = false;
			
		}
	}
}

