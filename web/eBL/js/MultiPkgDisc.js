 function pkgDefLoaded() {
	
	
}

function create() {
	
		
	MultiPkgDiscCreate.location.href = "../../eBL/jsp/MultiPkgDiscCreate.jsp?mode=insert&from=MULTIPKGDISC&level=1";
	commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?menu_id=EBL_DFLT&module_id=BL&function_id=EBL_MULTI_PKG_DISC&function_name=Multi Package Discount&function_type=F&access=YYYNN';
	
}

async function callCommonValidation(sqlSelect, obj, code) {
	//alert("9");
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';


	
    
    switch (sqlSelect) {

       
        case 1:
            {
                var cust_code = document.forms[0].payergrpCode.value;
                //Added V190603-Dhananjay/MMS-DM-CRF-130/70612 modified below query to add all
                sql = "  select  description, code from (Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
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
                "')) union select 'All' description, '**' code  from dual  WHERE '**' != nvl( '" + cust_code + "', '**') )  where  upper(description) like upper(?) and upper(code) like upper(?)  order by decode(description,'All','A')" ;

                title = 'Payer';
                break;
            }
        case 2:
            {
                
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
                "') ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";

                title = 'Payer Group';
                break;
            }
        case 3:
            {
				 //Added V190603-Dhananjay/MMS-DM-CRF-130/70612 modified below query to add all
        	var cust_grp_code = document.forms[0].payergrpCode.value;
			var cust_code = document.forms[0].payerCode.value;
                sql = " select description ,code from (select a.long_desc description,a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+            
            " AND b.cust_group_code =  '"+cust_grp_code+"' AND (b.cust_code = '"+cust_code+"' OR nvl( '" + cust_code + "', '**') = '**') "+
            " AND a.policy_type_code = b.policy_type_code "+
            " AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') union select 'All' description, '**' code  from dual     WHERE '****' != nvl( '" + cust_grp_code + "', '****') )"+
			" where  upper(description) like upper(?) and upper(code) like upper(?)  order by decode(description,'All','A')";
			
                title = 'Policy';
                break;
            }
			
			case 4:
		{
			sql="select description, code  from (select short_desc description, blng_grp_id code from BL_BLNG_GRP_LANG_VW where language_id='"+locale+"') where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Billing Group';
			break;
			
			
			
		}
       

    }

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
		
        obj.value = arr[1];
        code.value = arr[0];
		
		if(sqlSelect == 4)
	{
		
		var cnt=chkStatus(code);
		if(cnt>0){
			
		document.forms[0].payerGroup1.disabled=true;
		document.forms[0].payerGroup2_btn.disabled=true;
		document.forms[0].payerGroup1_btn.disabled=true;
		document.forms[0].policyType_btn.disabled=true;
		document.forms[0].policyType.disabled=true;
		document.forms[0].payerGroup2.disabled=true;
	
		}	
		else{
		document.forms[0].payerGroup1.disabled=false;
		document.forms[0].payerGroup2_btn.disabled=false;
		document.forms[0].payerGroup1_btn.disabled=false;
		document.forms[0].policyType_btn.disabled=false;
		document.forms[0].policyType.disabled=false;
		document.forms[0].payerGroup2.disabled=false;
			
		}
		
	}
		

    } else {
        obj.value = arr[1];
        code.value = arr[0];
        // obj.value = returnedValues[1];
    }
	
	

}


function onSuccess()
{

	if(MultiPkgDiscCreate.document.forms[0].mode.value=="insert") 	
	{
		MultiPkgDiscCreate.location.href='../../eBL/jsp/MultiPkgDiscCreate.jsp?mode=insert';
	}
	
			
commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?menu_id=EBL_DFLT&module_id=BL&function_id=EBL_MULTI_PKG_DISC&function_name=Multi Package Discount&function_type=F&access=YYYNN';
			
	

}

function setCheckValue()
{
	
	if(document.forms[0].MultiPkgDiscYN.checked==true)			document.forms[0].MultiPkgDiscYN.value="Y";
	else			document.forms[0].MultiPkgDiscYN.value="N";
	if(document.forms[0].PkgCustDiscYN.checked==true)			document.forms[0].PkgCustDiscYN.value="Y";
	else			document.forms[0].PkgCustDiscYN.value="N";
	if(document.forms[0].PkgAdDiscYN.checked==true)			document.forms[0].PkgAdDiscYN.value="Y";
	else			document.forms[0].PkgAdDiscYN.value="N";
	
}

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MultiPkgDiscCreate.jsp") != -1){


				 if(MultiPkgDiscCreate.document.location.href.indexOf("MultiPkgDiscMain.jsp") != -1)
					  return false;
				 else
					 	 MultiPkgDiscCreate.document.forms[0].reset();
					 
					 
		MultiPkgDiscCreate.document.forms[0].multipkgdisc.value="0";
	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MultiPkgDiscQueryCriteria.jsp") != -1)
	{
		 MultiPkgDiscCreate.document.forms[0].reset();
	}
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	MultiPkgDiscCreate.location.href='../../eBL/jsp/MultiPkgDiscQueryCriteria.jsp';
}
function apply(){
	
	
	
		
	var frm=MultiPkgDiscCreate.document.forms[0];
	

	

if(frm.name=='query_form' || frm.name=='QueryResult'){
	commontoolbarFrame.location.reload();
}
else{
	
	
	
	
	var facility=getLabel("Common.facility.label" ,"Common");
	var billingGrp= getLabel("eBL.BillingGroup.label","BL");
	var payerGrp= getLabel("eBL.PAYER_GROUP.label","BL");
	var payer= getLabel("Common.Payer.label","BL");
	var policy=  getLabel("eBL.POLICY.label","BL");
	var validFrom=  getLabel("eBL.VALID_FROM.label","BL");
	
	
	
	var cnt=chkStatus(MultiPkgDiscCreate.document.forms[0].billingGrpCode);
	
	

if(cnt>0){
	
	var fields = new Array (MultiPkgDiscCreate.document.forms[0].facility,MultiPkgDiscCreate.document.forms[0].blngGrpDesc,MultiPkgDiscCreate.document.forms[0].fromDate_);
	var names = new Array (facility,billingGrp,validFrom);
	
	MultiPkgDiscCreate.document.forms[0].payergrpCode.value="**";
	MultiPkgDiscCreate.document.forms[0].payerCode.value="**";
	MultiPkgDiscCreate.document.forms[0].policyTypeCode.value="**";
}

else{
	
	var fields = new Array (MultiPkgDiscCreate.document.forms[0].facility,MultiPkgDiscCreate.document.forms[0].blngGrpDesc,MultiPkgDiscCreate.document.forms[0].payerGroup2,MultiPkgDiscCreate.document.forms[0].payerGroup1,MultiPkgDiscCreate.document.forms[0].policyType,MultiPkgDiscCreate.document.forms[0].fromDate_);
	
	//var names = new Array (facility,billingGrp,payerGrp,policy,validFrom,payer); //Commented V190603-Dhananjay/MMS-DM-CRF-130/70612
	var names = new Array (facility,billingGrp,payerGrp,payer,policy,validFrom); //Added V190603-Dhananjay/MMS-DM-CRF-130/70612
	

	
	}
	
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			
			if(MultiPkgDiscCreate.document.forms[0].MultiPkgDiscYN.checked==true)			MultiPkgDiscCreate.document.forms[0].MultiPkgDiscYN.value="Y";
	else			MultiPkgDiscCreate.document.forms[0].MultiPkgDiscYN.value="N";
	if(MultiPkgDiscCreate.document.forms[0].PkgCustDiscYN.checked==true)			MultiPkgDiscCreate.document.forms[0].PkgCustDiscYN.value="Y";
	else			MultiPkgDiscCreate.document.forms[0].PkgCustDiscYN.value="N";
	if(MultiPkgDiscCreate.document.forms[0].PkgAdDiscYN.checked==true)			MultiPkgDiscCreate.document.forms[0].PkgAdDiscYN.value="Y";
	else			MultiPkgDiscCreate.document.forms[0].PkgAdDiscYN.value="N";
			
			
			MultiPkgDiscCreate.document.forms[0].submit();
			
		}
		
		
		
		
	}


}


function chkStatus(obj) {
	
	var xmlStr = "<root><SEARCH ";
	xmlStr += " /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "BLCommonAjax.jsp?functionMode=blngGrpChk&blngGrp="+obj.value, false);
	xmlHttp.send(xmlDoc);
	var cnt = trimString(xmlHttp.responseText);
	
	return (cnt);
}

function validPercentage(obj, type) {
	var discPer = parseFloat(obj.value);
	//Commented for  V190528-Dhananjay/MMS-DM-CRF-130/070585
	/*if (discPer > 100.00 || discPer <= 0) {
		if (type == 'P')
			alert(getMessage("BL6159", "BL"));
		
		obj.value = "";
		obj.focus();
		return false;
	}*/
	//Added V190528-Dhananjay/MMS-DM-CRF-130/070585 - Start
	if (discPer < 0) {
		if (type == 'P')
			alert(getMessage("BL6155", "BL"));
		
		obj.value = "";
		obj.focus();
		return false;
	}
	
	if (discPer > 100.00) {
		if (type == 'P')
			alert(getMessage("BL6154", "BL"));
		
		obj.value = "";
		obj.focus();
		return false;
	}
	//Added V190528-Dhananjay/MMS-DM-CRF-130/070585 - End
	if(obj.value == ''){

	document.forms[0].multipkgdisc.value=0;
	
	}
}


function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}

function validateFromDate() {
	var bool = checkDateBL(document.forms[0].fromDate_);

	
	if (!bool) {
		$('#fromDate_').val($('#todaysDate').val());
		return false;
	}

	if ($("#fromDate_").val() != '') {
		var fromLesserThanCurrentDt = true;
		var lesserThanCurrentDt = true;
		var toGrtThanFromDt = true;

		fromLesserThanCurrentDt = isBeforeNow($("#fromDate_").val(),
				'DMY', $("#locale").val());
		if ($("#toDate_").val() != '') {
			lesserThanCurrentDt = isBeforeNow($("#toDate_").val(), 'DMY',
					$("#locale").val());
					
			toGrtThanFromDt = isAfter($("#toDate_").val(), $(
					"#fromDate_").val(), 'DMY', $("#locale").val());

		}
		if (fromLesserThanCurrentDt == true) {
			//alert(" From should be greater than Current Date"); //commented V190528-Dhananjay/MMS-DM-CRF-130/70574
			alert(getMessage('BL8106', 'BL')); //Added V190528-Dhananjay/MMS-DM-CRF-130/70574
			$("#fromDate_").val($('#todaysDate').val());
		} else if (toGrtThanFromDt == false) {
			if ($("#fromDate_").val() != '') {
				alert(getMessage('BL4115', 'BL'));
				$("#fromDate_").val($("#toDate_").val());
			}
		}

	}
}

function validateToDate() {
	var bool = checkDateBL(document.forms[0].toDate_);

	
	if (!bool) {
		$('#toDate_').val($('#todaysDate').val());
		return false;
	}
	if ($("#toDate_").val() != '') {

		

				
		var toGrtThanFromDt = isAfter($("#toDate_").val(), $(
				"#fromDate_").val(), 'DMY', $("#locale").val());

		 if (toGrtThanFromDt == false) {
			if ($("#toDate_").val() != '') {
				alert(getMessage('BL4115', 'BL'));
				$("#toDate_").val($('#fromDate_').val());
			}
		}

	}
}

function checkDateBL(entered_date) {
	var locale = document.forms[0].locale.value;
	if (entered_date.value != "") {
		if (validDate(entered_date.value, 'DMY', locale)) {
			return true;
		} else {
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			entered_date.select();
			return false;
		}
	} else {
		return true;
	}
}


