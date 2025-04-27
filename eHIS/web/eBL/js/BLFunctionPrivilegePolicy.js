/*Sr No       Version             Incident              SCF/CRF                        Developer Name
-----------------------------------------------------------------------------------------------------
1 			 V220704/V220714        32045            NMC-JD-SCF-0291         			MohanapriyaK
2			V230403					42216			MOHE-SCF-0198						MohanapriyaK
*/
async function callCommonValidation(sqlSelect,obj,code,code_desc,payerGrp_code,payer_code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var dialogHeight = "700px" ;
	 var dialogWidth  = "400px" ;
	 var dialogTop    = "50px";
	 var arguments       = "" ;
	 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
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
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
	
			title = 'Payer Group';
			break;
		}
		
		case 2:
		{
			var cust_code = payerGrp_code.value;
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
			var cust_group_code = payerGrp_code.value;
			var cust_code =  payer_code.value;
			sql=" Select description,code from (select a.short_desc description , a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+			
			" AND b.cust_group_code =  '"+cust_group_code+"'  AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
			" AND a.policy_type_code = b.policy_type_code "+
			" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
			"  union  Select 'All Policies','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 1 ";
			title = 'Policy';
			break;
		}
		
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(code_desc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}
	else if(code_desc == '3'){
		argumentArray[4] = "2,1";
		argumentArray[5] = code.value;
	}
	else{
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;		
	}		
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
//alert(argumentArray[4] +'-'+argumentArray[5])
	returnedValues = await BLCommonLookup(title, argumentArray );
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
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	} 


}

async function BLCommonLookup(title, pArgumentArray) {

    var retVal = new String();
    /*
    var dialogHeight= "30" ;
    var dialogWidth = "50" ;
    */
    
    var dialogTop   = "10px";
    var dialogHeight= "450px" ;
    var dialogWidth = "700px" ;
    
    var status = "no";
	//var fin_Val=pArgumentArray.split(",");
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

	firstCodeVal = "" ;
	firstDescVal = "" ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    
    // added for PE on 26th April 2010
    
    if (pArgumentArray[5] != "")
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		responseText = trimString(responseText);
		eval(responseText) ;
	}
    if(firstCodeVal == "")
    {

		var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
		
		pArgumentArray[9] = title;

		var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
        
		//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        var returnVal = "";  
        
        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
		
     }
	 
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
		 
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}


function fnClearCode(obj){
	obj.value = '';
}

function AddRow(){
	var parentDoc = parent.PolicyAdd.document;
	var tbl = parentDoc.getElementById('tblPayerDetails');

	var index = tbl.rows.length-1;
	var prevIndex = index - 1;
	
	if(prevIndex>0){
		var custGrp = parentDoc.getElementById("custGrpCode_"+prevIndex).value;
		var cust = parentDoc.getElementById("custCode_"+prevIndex).value;
		var policy = parentDoc.getElementById("policyCode_"+prevIndex).value;
		
		if(custGrp.length<1 || cust.length<1 || policy.length<1) {
			alert("Please enter all mandatory fields");
			return false;
		}
	}
	
	
	var newRow = tbl.insertRow();
	var newCell = newRow.insertCell(0);	
	newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
	"<input type='text' name='custGrpCode_"+index+"' id='custGrpCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custGrpDesc_"+index+"); }'>   "+
	"<input type='text' name='custGrpDesc_"+index+"' id='custGrpDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custGrpCode_"+index+"); }'>  &nbsp;  "+
	"<input type='button' class='button' id='custGrpBtn_"+index+"' value='?' onclick='callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='26%';
	
	newCell = newRow.insertCell(1);	
	newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
	"<input type='text' name='custCode_"+index+"' id='custCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(2,custDesc_"+index+",custCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custDesc_"+index+"); }'>   "+
	"<input type='text' name='custDesc_"+index+"' id='custDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(2,custDesc_"+index+",custCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custCode_"+index+"); }'>  &nbsp;  "+
	"<input type='button' class='button' id='custBtn_"+index+"' value='?' onclick='callCommonValidation(2,custDesc_"+index+",custCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='26%';
	
	newCell = newRow.insertCell(2);	
	newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
	"<input type='text' name='policyCode_"+index+"' id='policyCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(policyDesc_"+index+"); }'>  "+
	"<input type='text' name='policyDesc_"+index+"' id='policyDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(policyCode_"+index+"); }'>  &nbsp;  "+
	"<input type='button' class='button' id='policyBtn_"+index+"' value='?' onclick='callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='26%';
	
	newCell = newRow.insertCell(3);	
	newCell.innerHTML = "<td class='fields' width='9%' nowrap> "+
	"<input type='text' name='effFrom_"+index+"' id='effFrom_"+index+"' size='6' onblur='isValidDate(this);checkDates(this,effTo_"+index+");'> "+
	"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendar(\"effFrom_"+index+"\")' /> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='9%';
	
	newCell = newRow.insertCell(4);	
	newCell.innerHTML = "<td class='fields' width='9%' nowrap> "+
	"<input type='text' name='effTo_"+index+"' id='effTo_"+index+"' size='6' onblur='isValidDate(this);checkDates(effFrom_"+index+",this);'> "+
	"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendar(\"effTo_"+index+"\")' /> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='9%';
	
	newCell = newRow.insertCell(5);	
	newCell.innerHTML = "<td class='fields' width='4%' nowrap> "+
	"<input type='checkbox' name='allowableYn_"+index+"' id='allowableYn_"+index+"'> "+
	"<input type='hidden' name='status_"+index+"' id='status_"+index+"' value='I'> "+
	"</td> ";
	newCell.className =  'fields';
	newCell.nowrap = 'nowrap';
	newCell.width='4%'; 

}

async function fnShowLookup(){
	
	
	var frm = parent.PolicyAdd.document.frmPolicyAdd;
	var auth = '';
	var facility_id = frm.facility_id.value;
	var mode = frm.mode.value;
	var userType = frm.userType.value;
	var userCode = frm.userCode.value;
	var functionId = frm.functionId.value;
	var privilegeCode = frm.privilegeCode.value;
	var effectiveDate = frm.effectiveDate.value;
	var allowedYn = frm.allowedYn.value;

		
	var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Payer Details"+
		"&source=BLFunctionPrivilegePolicyLookup"+
		"&facility_id="+facility_id+
		"&userType="+userType+
		"&userCode="+userCode+
		"&functionId="+functionId+
		"&privilegeCode="+privilegeCode+
		"&allowedYn="+allowedYn+
		"&effectiveDate="+effectiveDate;

	var dialogFeatures  = "dialogHeight:" + "85vh" + "; dialogWidth:" + "75vw" +" ; scroll=auto; ";
	var returnArray = await top.window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);	
	var str =unescape(returnArray);
	var arr = str.split(",");
	if(returnArray != undefined || returnArray != null){
		if(returnArray.length>0){
			var payerGroupCode = trimString(arr[0]);
			var payerGroupDesc = trimString(arr[1]);
			var payerCode = trimString(arr[2]);
			var payerDesc = trimString(arr[3]);
			var policy = trimString(arr[4]);
			var policyDesc = trimString(arr[5]);
			var effFrom = trimString(arr[6]);
			var effTo = trimString(arr[7]);
			var allowable = trimString(arr[8]);
			
			var temp_jsp="../../eBL/jsp/BLFunctionPrivilegePolicyPersistence.jsp?func_mode=restriction"+
			'&payerGroupCode='+payerGroupCode+
			'&payerCode='+payerCode+
			'&policy='+policy+
			'&effFrom='+effFrom+
			'&userType='+userType+
			'&userCode='+userCode+
			'&functionId='+functionId+
			'&privilegeCode='+privilegeCode;
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
			}
			
			var parentDoc = parent.PolicyAdd.document;
			var tbl = parentDoc.getElementById('tblPayerDetails');
			
			var index = tbl.rows.length-1;
			
			var newRow = tbl.insertRow();
			var newCell = newRow.insertCell(0);	
			newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
			"<input type='text' name='custGrpCode_"+index+"' value='"+payerGroupCode+"' id='custGrpCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custGrpDesc_"+index+"); }'>   "+
			"<input type='text' name='custGrpDesc_"+index+"' value='"+payerGroupDesc+"' id='custGrpDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custGrpCode_"+index+"); }'>  &nbsp;  "+
			"<input type='button' class='button' id='custGrpBtn_"+index+"' value='?' onclick='callCommonValidation(1,custGrpDesc_"+index+",custGrpCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='26%';
			
			newCell = newRow.insertCell(1);	
			newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
			"<input type='text' name='custCode_"+index+"' value='"+payerCode+"' id='custCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(2,custDesc_"+index+",custCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custDesc_"+index+"); }'>   "+
			"<input type='text' name='custDesc_"+index+"' value='"+payerDesc+"' id='custDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(2,custDesc_"+index+",custCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(custCode_"+index+"); }'>  &nbsp;  "+
			"<input type='button' class='button' id='custBtn_"+index+"' value='?' onclick='callCommonValidation(2,custDesc_"+index+",custCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='26%';
			
			newCell = newRow.insertCell(2);	
			newCell.innerHTML = "<td class='fields' width='26%' nowrap> "+
			"<input type='text' name='policyCode_"+index+"' value='"+policy+"' id='policyCode_"+index+"' size='15' onblur='if(this.value.length>0){ callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",1,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(policyDesc_"+index+"); }'>  "+
			"<input type='text' name='policyDesc_"+index+"' value='"+policyDesc+"' id='policyDesc_"+index+"' size='30' onblur='if(this.value.length>0){ callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",2,custGrpCode_"+index+",custCode_"+index+"); } else{ fnClearCode(policyCode_"+index+"); }'>  &nbsp;  "+
			"<input type='button' class='button' id='policyBtn_"+index+"' value='?' onclick='callCommonValidation(3,policyDesc_"+index+",policyCode_"+index+",3,custGrpCode_"+index+",custCode_"+index+");' tabindex='2'> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='26%';
			
			newCell = newRow.insertCell(3);	
			newCell.innerHTML = "<td class='fields' width='9%' nowrap> "+
			"<input type='text' name='effFrom_"+index+"' id='effFrom_"+index+"' size='6' value='"+effFrom+"' onblur='isValidDate(this);checkDates(this,effTo_"+index+");'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_"+index+"' onClick='return showCalendar(\"effFrom_"+index+"\")' /> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='9%';
			
			newCell = newRow.insertCell(4);	
			newCell.innerHTML = "<td class='fields' width='9%' nowrap> "+
			"<input type='text' name='effTo_"+index+"' id='effTo_"+index+"' size='6' value='"+effTo+"' onblur='isValidDate(this);checkDates(effFrom_"+index+",this);'> "+
			"<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_"+index+"' onClick='return showCalendar(\"effTo_"+index+"\")' /> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='9%';
			
			newCell = newRow.insertCell(5);	
			newCell.innerHTML = "<td class='fields' width='4%' nowrap> "+
			"<input type='checkbox' name='allowableYn_"+index+"' id='allowableYn_"+index+"'> "+
			"<input type='hidden' name='status_"+index+"' id='status_"+index+"' value='U'> "+
			"</td> ";
			newCell.className =  'fields';
			newCell.nowrap = 'nowrap';
			newCell.width='4%'; 
			
			if(mode == 'modify'){
				makeFieldsDisable(index);
				if(allowable == 'Y'){
					parentDoc.getElementById('allowableYn_'+index).checked = 'checked';
				}
			}
		}
	}
	
}

function makeFieldsDisable(index){
	var parentDoc = parent.PolicyAdd.document;
	$(parentDoc).find('#custGrpCode_'+index).attr('readonly','readonly');	
	$(parentDoc).find('#custGrpCode_'+index).removeAttr('onblur');
	$(parentDoc).find('#custGrpDesc_'+index).attr('disabled','disabled');
	$(parentDoc).find('#custGrpBtn_'+index).attr('disabled','disabled');
	
	$(parentDoc).find('#custCode_'+index).attr('readonly','readonly');	
	$(parentDoc).find('#custCode_'+index).removeAttr('onblur');
	$(parentDoc).find('#custDesc_'+index).attr('disabled','disabled');	
	$(parentDoc).find('#custBtn_'+index).attr('disabled','disabled');
	
	$(parentDoc).find('#policyCode_'+index).attr('readonly','readonly');	
	$(parentDoc).find('#policyCode_'+index).removeAttr('onblur');
	$(parentDoc).find('#policyDesc_'+index).attr('disabled','disabled');	
	$(parentDoc).find('#policyBtn_'+index).attr('disabled','disabled');
	
	$(parentDoc).find('#effFrom_'+index).attr('readonly','readonly');	
	$(parentDoc).find('#effFrom_ctrl_'+index).attr('disabled','disabled');
}

async function callCommonValidationQryCriteria(sqlSelect,obj,code,code_desc){
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
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
	
			title = 'Payer Group';
			break;
		}
		
		case 2:
		{
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'Payer';
			break;
		}		
		
		case 3:
		{
			sql="Select description,code from (select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') union  Select 'All Policies','**' From Dual) where  upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Policy';
			break;
		}
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(code_desc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}
	else{
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;		
	}	
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues =await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
 	arr=ret1.split(",");
	
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		code.value = arr[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
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
		if (!RE_NUM.exec(arr_date[2])) flag=false;
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

function fnLoadPayerData(index){
	var payerGroupCode = document.getElementById('payer_group_code'+index).innerText;
	var payerGroupDesc = document.getElementById('payer_group_desc'+index).innerText;
	var payerCode = document.getElementById('payer_code'+index).innerText;
	var payerDesc = document.getElementById('payer_desc'+index).innerText;
	var policy = document.getElementById('policy'+index).innerText;
	var policyDesc = document.getElementById('policy_desc'+index).innerText;
	var effFrom = document.getElementById('eff_from'+index).innerText;
	var effTo = document.getElementById('eff_to'+index).innerText;
	var allowable = document.getElementById('allowableYn'+index).innerText;
	
	var returnArray = new Array();
	returnArray[0] = payerGroupCode;
	returnArray[1] = payerGroupDesc;
	returnArray[2] = payerCode;
	returnArray[3] = payerDesc;
	returnArray[4] = policy;
	returnArray[5] = policyDesc;
	returnArray[6] = effFrom;
	returnArray[7] = effTo;
	returnArray[8] = allowable;
	
	parent.window.returnValue = returnArray;
	parent.window.close();
}

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

function persistData(){
	var frmObj = parent.PolicyAdd.document.frmPolicyAdd;
	var parentDoc = parent.PolicyAdd.document;
	var tbl = parentDoc.getElementById('tblPayerDetails');

	var index = tbl.rows.length-2;
	frmObj.rowCount.value = index;
	if(index>0){
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"PolicyPriv");
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
	var temp_jsp="../../eBL/jsp/BLFunctionPrivilegePolicyPersistence.jsp?func_mode="+last_link;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert(xmlStr)
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	//alert(responseText)
	//eval(responseText);
	return true;
}

function loadPrivilegePolicies(sNo){
	var index = sNo-1;
	var userType = $('#rightsType').val();
	var userCode= $('#rightsCode').val();
	var functionId = $('#function_type').val();
	var privilegeCode = $('#privilegeId'+index).val();
	var effPrivDate = $('#dateFrom'+index).val();
	var allowedYn = '';
	if($('#allowedYn'+index).is(':checked')){
		allowedYn = 'Y';
	}
	else{
		allowedYn = 'N';
	}
	var prevClicked = $('#prevClicked').val();
	if(prevClicked.length>0){
		$('#privTableRow'+prevClicked +' td').each(function(){
			$(this).attr('class','fields');
		});
	}

	$('#privTableRow'+sNo +' td').each(function(){
		$(this).attr('class','LocalYellow');
	});
	$('#prevClicked').val(sNo);
	
	if(prevClicked.length<1){
		parent.BLUserRightsLookupFrame.document.location.href = '../jsp/BLFunctionPrivilegePolicyFrame.jsp?userType='+userType+
		'&userCode='+userCode+'&functionId='+functionId+'&privilegeCode='+privilegeCode+'&allowedYn='+allowedYn+'&effectiveDate='+effPrivDate+'&mode=modify';

	}
	else{
		$(parent.BLUserRightsLookupFrame.PolicyBtn.document).find('#btnSave').click();
		parent.BLUserRightsLookupFrame.document.location.href = '../jsp/BLFunctionPrivilegePolicyFrame.jsp?userType='+userType+
		'&userCode='+userCode+'&functionId='+functionId+'&privilegeCode='+privilegeCode+'&allowedYn='+allowedYn+'&effectiveDate='+effPrivDate+'&mode=modify';

	}

}


//Copied from BLUserRights
function rightsTypeOnChange(){
	var rightsType=document.BLUserRightsAddModForm.rightsType.value;
	parent.frames[1].location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp?rightsType="+rightsType;
	parent.BLUserRightsLookupFrame.location.href = '../../eCommon/html/blank.html';
}

function GetLookupBlur(target) {
	if (target.value != "") {
		GetLookup(target);
	} else {
		document.forms[0].rightsCode.value = "";
		var rightCod = document.forms[0].rightsCode;
		var funId = document.forms[0].function_type.value;
		var rightTyp = document.forms[0].rightsType.value;
		var prevCode = $('#prevRights').val();

		if(rightCod.value != prevCode){
			$('#prevRights').val(rightCod.value); 
			parent.frames[1].location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp?&rightsType="+rightTyp+"&functionType="+funId+"&rightsCode="+rightCod.value;
			parent.BLUserRightsLookupFrame.location.href = '../../eCommon/html/blank.html';
		}
		//parent.frames[2].location.href = "../../eCommon/html/blank.html";
	}
}
//New change-V230403
async function GetLookup(target)
{
	var queryParameter = document.BLUserRightsAddModForm.queryString.value;
	var selType = document.BLUserRightsAddModForm.rightsType.value;
	var sql = "";
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = '';
	if(selType == 'U'){
		tit = getLabel("Common.user.label", 'Common');
		sql="BLINTERNALREP_0::blsql::";
	}
	else if(selType == 'G'){
		tit = getLabel("Common.Group.label", 'Common');
		sql="BLINTERNALREP_1::blsql::";
	}
	else if(selType == 'R'){
		tit = getLabel("Common.responsibility.label", 'Common');
		sql="BLINTERNALREP_2::blsql::";
	}
	else{
		tit = getLabel("Common.user.label", 'Common');
		sql="BLINTERNALREP_3::blsql::";
	}
	
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1"; //V220704
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		document.forms[0].rightsCode.value = arr[0];
	} else {
		target.value = "";
		document.forms[0].rightsCode.value = "";
	}
	
	var rightCod = document.forms[0].rightsCode;
	var funId = document.forms[0].function_type.value;
	var rightTyp = document.forms[0].rightsType.value;
	var prevCode = $('#prevRights').val();

	if(rightCod.value != prevCode){
		$('#prevRights').val(rightCod.value); 
		parent.frames[1].location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp?&rightsType="+rightTyp+"&functionType="+funId+"&rightsCode="+rightCod.value;
		parent.BLUserRightsLookupFrame.location.href = '../../eCommon/html/blank.html';
	}
}
//V230403

function rightsTypeOnChangeQuery(){
	var rightsType = document.query_form.rightsType.value;
	parent.frames[1].location.href = "../../eBL/jsp/BLFunctionPrivilegeQueryCriteria.jsp?rightsType="+rightsType;
}

function GetLookupBlurQuery(target) {
	if (target.value != "") {
		GetLookupQuery(target);
	} else {
		document.forms[0].rightsCode.value = "";
		//parent.frames[2].location.href = "../../eCommon/html/blank.html";
	}
}
//V230403
async  function GetLookupQuery(target) {

	var queryParameter = document.query_form.queryString.value;
	var sql = "";
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var rightsType = document.query_form.rightsType.value;
		var title = '';
	if(rightsType == 'U'){
		title = getLabel("Common.user.label", 'Common');
		sql="BLINTERNALREP_0::blsql::";
	}
	else if(rightsType == 'G'){
		title = getLabel("Common.Group.label", 'Common');
		sql="BLINTERNALREP_1::blsql::";
	}
	else if(rightsType == 'R'){
		title = getLabel("Common.responsibility.label", 'Common');
		sql="BLINTERNALREP_2::blsql::";
	}
	else{
		title = getLabel("Common.user.label", 'Common');
		sql="BLINTERNALREP_3::blsql::";
	}
	//sql=queryParameter;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1"; //V220714
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		document.forms[0].rightsCode.value = arr[0];
	} else {
		target.value = "";
		document.forms[0].rightsCode.value = "";
	}

}//V230403

function functionIdOnChange(){

	var rightsType	   = document.getElementById("rightsType").value;
	var functionType	   = document.getElementById("function_type").value;
	var rightsCode     = document.getElementById("rightsCode").value;
	//alert("===========rightsType=================="+rightsType);
	//alert("===========rightsCode=================="+rightsCode);
	//alert("===========functionType=================="+functionType);

		document.forms[0].rightsType.value    = rightsType;
		document.forms[0].function_type.value = functionType;
		document.forms[0].rightsCode.value    = rightsCode;

		parent.frames[1].location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp?&rightsType="+rightsType+"&functionType="+functionType+"&rightsCode="+rightsCode;
		parent.BLUserRightsLookupFrame.location.href = '../../eCommon/html/blank.html';
}


function functionIdOnChange_query(){

	var rightsType	   = document.getElementById("rightsType").value;
	var functionType	   = document.getElementById("function_type").value;
	var rightsCode     = document.getElementById("rightsCode").value;
	//alert("===========rightsType=================="+rightsType);
	//alert("===========rightsCode=================="+rightsCode);
	//alert("===========functionType=================="+functionType);

		document.forms[0].rightsType.value    = rightsType;
		document.forms[0].function_type.value = functionType;
		document.forms[0].rightsCode.value    = rightsCode;
}

function create(){
	BLUserRightsMainFrame.document.location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp";
	BLUserRightsLookupFrame.document.location.href = "../../eCommon/html/blank.html";
}

function apply(){	
	

	if(BLUserRightsLookupFrame.PolicyAdd == undefined  ){
		alert('Privileges cannot be empty');
		commontoolbarFrame.location.reload();
		return false;
	}
	var frmObj = BLUserRightsLookupFrame.PolicyAdd.document.frmPolicyAdd;
	var parentDoc = BLUserRightsLookupFrame.PolicyAdd.document;
	var tbl = parentDoc.getElementById('tblPayerDetails');

	var index = tbl.rows.length-2;
	frmObj.rowCount.value = index;
	var xmlString=formXMLStringMain(frmObj);
	var updation=formValidation(xmlString,"PolicyPriv");
	
	frmObj = BLUserRightsMainFrame.document.BLUserRightsAddModForm;
	xmlString=formXMLStringMain(frmObj);
	updation=formValidation(xmlString,"Privilege");
	
	frmObj.target='messageFrame';
	frmObj.method="post";
	frmObj.action="../../servlet/eBL.BLFunctionPrivilegeServlet"; //V230421

	frmObj.submit();
}

function query() {

	/*	parent.frames[2].BLUserRightsMainFrame.location.href ="../../eBL/jsp/PatSearchQueryUserRights.jsp";*/
		parent.frames[2].BLUserRightsMainFrame.location.href ="../../eBL/jsp/BLFunctionPrivilegeQueryCriteria.jsp?calledFrom=forPolicy";
		BLUserRightsLookupFrame.document.location.href = "../../eCommon/html/blank.html";
		}


function onSuccess()
{
	BLUserRightsMainFrame.document.location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp";
	BLUserRightsLookupFrame.document.location.href = "../../eCommon/html/blank.html";
}
	
function reset()
{
	BLUserRightsMainFrame.document.location.href = "../../eBL/jsp/BFunctionPrivilegeAddMod.jsp";
	BLUserRightsLookupFrame.document.location.href = "../../eCommon/html/blank.html";
}

	function checkSpl( val ) {

	    var result = "" ;
	    var ch = "" ;

	    var indVal = 0;
	    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
	    {
			// Changed by Muthu on 12/07/2010 against incident IN022478
	        // val = val.replace("\n","^")
	        val = val.replace("\n","\"");
	    }

	    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
	    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
	    for(i=0; i<val.length; i++) {
	        for(j=0; j<spChars.length; j++) {
	            if ( val.substring(i,i+1) == spChars[j] ) {
	                ch = chChars[j] ;
	                j=spChars.length ;
	            } else {
	                ch = val.substring(i,i+1) ;
	            }
	        }
	        result += ch ;
	    }
	    //alert(result)
	    return result ;
	}
	
	function checkDates(fromdate,todate){
		var locale = $('#locale').val();
		if(fromdate.value!='' && todate.value!=''){
			
			if(!isAfterNow(todate.value,'DMY',locale))
			 {
				 alert("Effective To Date Should be Greater than or equal to System Date");
				 todate.value="";
				 todate.select();				 
				 return false;
			 } 
			if(!isBefore(fromdate.value,todate.value,'DMY',locale))
			 {
				 alert(getMessage("BL8508","BL"));
				 todate.value="";
				 todate.select();
				 return false;
			 }
		}
	}

