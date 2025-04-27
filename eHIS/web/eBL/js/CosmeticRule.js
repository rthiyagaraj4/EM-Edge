/*Header Functions*/
function create()
{	
	CosmeticRuleFrame.location.href="../../eBL/jsp/CosmeticRuleMainFrame.jsp?mode=insert"; 
}


function reset() {
	CosmeticRuleFrame.location.reload();
}

function query()
{	
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	CosmeticRuleFrame.location.href="../../eBL/jsp/CosmeticRuleQueryCriteria.jsp"; 
}

function onSuccess()
{
	CosmeticRuleFrame.location.href="../../eBL/jsp/CosmeticRuleMainFrame.jsp?mode=insert";
}

function apply(){
	var doc = CosmeticRuleFrame.headerFrame.document;
	var ruleCode = $(doc).find('#ruleCode').val();
	var ruleCodeLbl  = 'Rule Code'//getLabel("eBL.ruleCode.label","bl");
	var fieldsTop  = new Array (doc.frmHeader.ruleCode);
	var namesTop = new Array (ruleCodeLbl);
	var mode =  $(doc).find('#insertUpdate').val();
	var effTo = $.trim($(doc).find('#effTo').val());
	if(mode == 'U' && effTo != '' && !isAfterNow(effTo,'DMY','en')){
		alert('Rule Code Expired. Modifications not Allowed');
		commontoolbarFrame.location.reload();
		return false;
	}
	if(checkFieldsofMst( fieldsTop, namesTop, messageFrame)) {
		var cLastRow = $(doc).find('#tblCriteria tr:last');	
		if(isNaN($(cLastRow).attr('rowValue'))){
			$(doc).find('#criteriaLastRow').val(0);
		}
		else{
			$(doc).find('#criteriaLastRow').val($(cLastRow).attr('rowValue'));		
		}
		var eLastRow = $(doc).find('#tblInclExcl tr:last');	
		if(isNaN($(eLastRow).attr('rowValue'))){
			$(doc).find('#exclLastRow').val(0);
		}
		else{
			$(doc).find('#exclLastRow').val($(eLastRow).attr('rowValue'));		
		}
		getXMLString("persistHeader");
		getXMLString("persistCriteria");
		getXMLString("persistExclusion");
		
		var hdrFrm = eval("CosmeticRuleFrame.headerFrame.document.frmHeader");
		hdrFrm.submit();
	}
}
/*Lookup Functions*/
function callCommonLookupCode(obj,code,sqlSelect,codeDesc,commonCode){
	var locale = $('#locale').val();
	var facility_id = $('#facilityId').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){
			
		case 1:
		{
			sql="Select description, code from (select short_desc description, rule_code code from BL_ADDL_CHARGE_RULE where facility_id = '"+facility_id+"' and Rule_type_ind = 'M' and Eff_date_to is null or trunc(Eff_date_to)>=trunc(sysdate) )   "+
				"  where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Rule Code';
			break;
		}

		case 2:
		{
			sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}

		case 3:
		{
			var cust_code = commonCode.value;
			sql = "Select description,code from (Select short_name description,cust_code code from ar_customer_lang_vw "+
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
		
		case 4:
		{
			var criteria = commonCode.value;
			
				if(criteria == 'S'){
					sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
					title = 'Billing Services';							
				}
				else if(criteria == 'BSG'){
					sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Groups','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
					title = 'Billing Service Group';
				}
				else if(criteria == 'BSGC'){
					sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Classifications' ,'**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
					title = 'Service Classification';
				}
				else{
					alert('Please choose Service type');
					obj.value = '';
					code.value = '';
					commonCode.focus();
					return false;
				}
			
			
			break;
		}
		
		case 5:
		{
			sql="select description, code  from (select short_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') "+
			"Union Select 'All Policies','**' From Dual ) Where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Policy';
			break;
		}
		
		
		case 6:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"' "+
			"Union Select 'All Billing Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
		}
		
		case 7:
		{
			sql="Select description, code from (select short_desc description, rule_code code from BL_ADDL_CHARGE_RULE where facility_id = '"+facility_id+"' and Rule_type_ind = 'M'  )   "+
				"  where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Rule Code';
			break;
		}
					
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}

	returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
		
		if(sqlSelect == 1){
			$.ajax({
				type:"POST",
				url:"../jsp/CosmeticRulePersistence.jsp",
				data:"func_mode=getRuleDates&ruleCode="+returnedValues[0],
				dataType:"text",
				async:false,
				success: function(data){
					//alert(data)
					var retVal = $.trim(data);
					var retValArr = retVal.split(":::");
					$('#effFrom').val(retValArr[0]);
					$('#effTo').val(retValArr[1]);
				},
				 error: function(data){
					 alert(data)
			     }
			});
		}
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

function fnAddCriteria(){
	var lastRow = $('#tblCriteria tr:last');	
	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal = '';
	trVal = "<tr style='width: 100%' rowValue='"+rowVal+"' id='tr"+rowVal+"' > "+
				"<td style='width: 30%'> "+
					"<select name='servType"+rowVal+"' id='servType"+rowVal+"' id='servType"+rowVal+"' onchange='fnServTypeChange(this,servCode"+rowVal+",servDesc"+rowVal+")' > "+
					"<option value=''>Select</option> "+	
					"<option value='BSG'>Service Group</option> "+		
					"<option value='BSGC'>Service Classification</option> "+
					"<option value='S'>Billing Service</option> "+						
					"</select> "+
				"</td> "+
				"<td style='width: 45%'> "+
					"<input type='text' name='servCode"+rowVal+"' id='servCode"+rowVal+"' id='servCode"+rowVal+"' size='10' value='' onblur='if(this.value.length>0){ callCommonLookupCode(servDesc"+rowVal+",servCode"+rowVal+",4,1,servType"+rowVal+"); validateDuplicate(1,"+rowVal+"); } else{ fnClearCode(servDesc"+rowVal+"); }'>&nbsp; "+
					"<input type='text' name='servDesc"+rowVal+"' id='servDesc"+rowVal+"' id='servDesc"+rowVal+"' size='20' value='' onblur='if(this.value.length>0){ callCommonLookupCode(servDesc"+rowVal+",servCode"+rowVal+",4,2,servType"+rowVal+"); validateDuplicate(1,"+rowVal+"); } else{ fnClearCode(servCode"+rowVal+"); }'>&nbsp; "+
					"<input type='button' class='button' name='servBtn"+rowVal+"' id='servBtn"+rowVal+"' value='?' onClick='callCommonLookupCode(servDesc"+rowVal+",servCode"+rowVal+",4,2,servType"+rowVal+"); validateDuplicate(1,"+rowVal+"); ' tabindex='2'> "+									
				"</td> "+
				"<td style='width: 15%'> "+
					"<span style='color: blue; font-size: 15px; padding-left: 10px;' onclick='fnAddCriteria();'>+</span> "+
				"</td> "+
				"<td style='width: 10%'> "+
					"<input type='checkbox' id='criteriaRem"+rowVal+"' name='criteriaRem"+rowVal+"' id='criteriaRem"+rowVal+"'> "+
					"<input type='hidden' name='criteriaStatus"+rowVal+"' id='criteriaStatus"+rowVal+"' id='criteriaStatus"+rowVal+"' value='I'> "+
				"</td> "+
			"</tr>";
	$('#tblCriteria').append(trVal);
}

function fnAddInclExcl(){
	var lastRow = $('#tblInclExcl tr:last');	
	var rowVal = '';
	if(isNaN($(lastRow).attr('rowValue'))){
		rowVal = '1';
	}
	else{
		rowVal = $(lastRow).attr('rowValue');
		rowVal = parseInt(rowVal) + parseInt(1);
	}
	var trVal = '';
	trVal = "<tr style='width: 100%' rowValue='"+rowVal+"' id='tr"+rowVal+"' > "+
				"<td style='width: 25%'> "+
					"<select name='inclServType"+rowVal+"' id='inclServType"+rowVal+"' id='inclServType"+rowVal+"' onchange='fnServTypeChange(this,blngServCode"+rowVal+",blngServDesc"+rowVal+")' > "+
					"<option value=''>Select</option> "+	
					"<option value='BSG'>Service Group</option> "+		
					"<option value='BSGC'>Service Classification</option> "+
					"<option value='S'>Billing Service</option> "+						
					"</select> "+
				"</td> "+
				"<td style='width: 35%'> "+
					"<input type='text' name='blngServCode"+rowVal+"' id='blngServCode"+rowVal+"' id='blngServCode"+rowVal+"' size='10' value='' onblur='if(this.value.length>0){ callCommonLookupCode(blngServDesc"+rowVal+",blngServCode"+rowVal+",4,1,inclServType"+rowVal+"); validateDuplicate(2,"+rowVal+"); } else{ fnClearCode(blngServDesc"+rowVal+"); }'>&nbsp; "+
					"<input type='text' name='blngServDesc"+rowVal+"' id='blngServDesc"+rowVal+"' id='blngServDesc"+rowVal+"' size='20' value='' onblur='if(this.value.length>0){ callCommonLookupCode(blngServDesc"+rowVal+",blngServCode"+rowVal+",4,2,inclServType"+rowVal+"); validateDuplicate(2,"+rowVal+"); } else{ fnClearCode(blngServCode"+rowVal+"); }'>&nbsp; "+
					"<input type='button' class='button' name='blngServBtn"+rowVal+"' id='blngServBtn"+rowVal+"' value='?' onClick='callCommonLookupCode(blngServDesc"+rowVal+",blngServCode"+rowVal+",4,2,inclServType"+rowVal+"); validateDuplicate(2,"+rowVal+"); ' tabindex='2'> "+									
				"</td> "+
				"<td style='width: 20%'> "+
				"<select name='inclExcl"+rowVal+"' id='inclExcl"+rowVal+"' id='inclExcl"+rowVal+"'> "+				
				"<option value='I'>Include</option> "+
				"<option value='E'>Exclude</option> "+
				"</select> </td> "+
				"<td style='width: 10%'> "+
					"<span style='color: blue; font-size: 15px; padding-left: 10px;' onclick='fnAddInclExcl();'>+</span> "+
				"</td> "+
				"<td style='width: 10%'> "+
					"<input type='hidden' name='inclExclStatus"+rowVal+"' id='inclExclStatus"+rowVal+"' id='inclExclStatus"+rowVal+"' value='I'> "+
					"<input type='checkbox' id='inclExclRem"+rowVal+"' name='inclExclRem"+rowVal+"' id='inclExclRem"+rowVal+"'> "+
				"</td> "+
			"</tr>";
	$('#tblInclExcl').append(trVal);
}

/*Persistence Helper*/
function getXMLString(last_link)	
{
	if(last_link == "persistHeader")
	{		
		var frmObj = eval("CosmeticRuleFrame.headerFrame.document.frmHeader");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"persistHeader");		
	}
	else if(last_link == "persistCriteria")
	{  
		var frmObj = eval("CosmeticRuleFrame.headerFrame.document.frmCriteria");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"persistCriteria");		
	}
	else if(last_link == "persistExclusion"){
		var frmObj = eval("CosmeticRuleFrame.headerFrame.document.frmInclExcl");		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"persistExclusion");
	}
	
}

function formXMLStringMain(frmObj)
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
	return xmlStr;
}

function formValidation(xmlStr,last_link)
{	

	var temp_jsp="../jsp/CosmeticRulePersistence.jsp?func_mode="+last_link;


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);

	if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

/*Persistence Helper*/

function disableHeaderFields(){
	//$('#patientClass').attr('disabled','disabled')
	$('#frmHeader').find("select").attr('disabled','disabled');
	$('#frmHeader').find("input[type='text']").attr('readonly','readonly');
	$('#frmHeader').find("input[type='text']").attr('onblur','');
	$('#frmHeader').find("input[type='button']").attr('disabled','disabled');
}

function disableCriteria(){
	//$('#patientClass').attr('disabled','disabled')
	$('#frmCriteria').find("select").attr('disabled','disabled');
	$('#frmCriteria').find("input[type='text']").attr('readonly','readonly');
	$('#frmCriteria').find("input[type='text']").attr('onblur','');
	$('#frmCriteria').find("input[type='button']").attr('disabled','disabled');
	$('#frmCriteria').find("span").attr('onclick','');
}

function disableInclExcl(){
	$('#frmInclExcl').find("select").attr('disabled','disabled');
	$('#frmInclExcl').find("input[type='text']").attr('readonly','readonly');
	$('#frmInclExcl').find("input[type='text']").attr('onblur','');
	$('#frmInclExcl').find("input[type='button']").attr('disabled','disabled');
	$('#frmInclExcl').find("span").attr('onclick','');
}

function fnServTypeChange(obj,code,desc){	
	code.value='';
	desc.value='';	
}

function validateDuplicate(type,cnt){
	if(type == 1){
		var lastRow = $('#tblCriteria tr:last');
		var	totalRecords=	 $(lastRow).attr('rowValue');
		var servType = $('#servType'+cnt).val();
		var servCode = $('#servCode'+cnt).val();
		for(var i=1; i<= totalRecords; i++){
			if(i != cnt && $.trim($('#servCode'+i).val()) != ''){
				if((servType == $('#servType'+i).val())  &&  (servCode == $('#servCode'+i).val())){
					alert('Duplicate Service Code');
					$('#servCode'+cnt).val('');
					$('#servDesc'+cnt).val('');
					
					return false;
				}
			}
		}
	}
	else if(type == 2){
		var lastRow = $('#tblInclExcl tr:last');
		var	totalRecords=	 $(lastRow).attr('rowValue');
		var servType = $('#inclServType'+cnt).val();
		var servCode = $('#blngServCode'+cnt).val();
		for(var i=1; i<= totalRecords; i++){
			if(i != cnt && $.trim($('#blngServCode'+i).val()) != ''){
				if((servType == $('#inclServType'+i).val())  &&  (servCode == $('#blngServCode'+i).val())){
					alert('Duplicate Service Code');
					$('#blngServCode'+cnt).val('');
					$('#blngServDesc'+cnt).val('');
					return false;
				}
			}
		}
	}
	
}

