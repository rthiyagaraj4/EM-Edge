// created on 07/12/2009
var function_id = "PH_EXT_PROD_LINK" ;
var result1	= false ;
var message = "" ;
var flag = "" ;
var invalidCode	=  "";

var globalCode="";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/ExtProdLinkAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/ExtProdLinkQueryCriteria.jsp?function_id="+function_id ;
}

async function queryDrugSearch(drugDescObj, drugCodeObj, extDrugCodeObj,productIdObj){
		var formObj = document.frmExtProductLink;
//	if(drugCodeObj.value == ""){
		var retVal=await DrugSearch("D",drugDescObj);
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		if(retVal != null && retVal != "" )  {
			var drug_code = arr[0] ;
			var drug_desc = arr[1] ;
			drugCodeObj.value = drug_code;
			drugDescObj.value=drug_desc;
			

			var bean_id			= formObj.bean_id.value ;
			var bean_name	    = formObj.bean_name.value ;	
			var xmlStr ="";
			xmlStr ="<root><SEARCH " ;
			xmlStr			+= " bean_id=\""+ bean_id + "\" ";
			xmlStr			+= " bean_name=\""+ bean_name + "\" ";
			xmlStr			+= " drug_code=\""+ drug_code + "\" ";
			xmlStr			+= " product_id=\""+ productIdObj.value + "\" ";
			xmlStr +=" /></root>" ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					
			xmlHttp.open( "POST", "ExtProdLinkValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=asso_ext_drug_code", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			var result = eval(responseText);
			if(!result)
			{

				extDrugCodeObj.disabled = false;
				extDrugCodeObj.focus();
 
			}

			
		}
		else{
			drugCodeObj.value = "";
			drugDescObj.value="";
			extDrugCodeObj.value = "";
			extDrugCodeObj.disabled = true;
		}
		
//	}
}

function ModifyRow(obj) {
		
	var drug_code = obj.cells[0].innerText;
	var drug_desc = obj.cells[1].innerText;
	var product_id = obj.cells[2].innerText;
	var type = obj.cells[3].innerText;
	var ext_prod_drug_code = obj.cells[4].innerText;
	
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/ExtProdLinkAddModify.jsp?mode="+MODE_MODIFY+"&drug_code="+drug_code+"&drug_desc="+drug_desc+"&product_id="+product_id+"&ext_prod_drug_code="+ext_prod_drug_code+"&type="+type;
}



function CodeCheck(obj){
	  var str = obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++)
		{
            if (!(((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==123)||(str.charCodeAt(u)==125)))
			{
				specCharsExist =true;
				break;
			}
        }
        if(specCharsExist)
		{
			alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
			obj.focus();
		}
}

function CheckForAlphaNumeric(event)
{
	 var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-{}';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("extprodlinkquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("extprodlinkaddmodify")!=-1) ) {
			f_query_add_mod.document.frmExtProductLink.reset();
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("ExtProductLinkQuery")==-1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
}

function onSuccess() {
	var mode = f_query_add_mod.document.frmExtProductLink.mode.value;
	if( mode == MODE_INSERT ) {
		f_query_add_mod.document.frmExtProductLink.reset();
		f_query_add_mod.document.frmExtProductLink.product_id1.focus();
	}
	else if(mode == MODE_MODIFY ){
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}
}




function apply() {
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
	}

	var formObj	=	f_query_add_mod.document.frmExtProductLink;
	var repeated_msg = getMessage("RECORDS_HAVING_SAME_COMBINATION_OF_DRUG_AND_PRODUCT_ID","PH");
	var mode = formObj.mode.value;

	if( mode == MODE_INSERT )
	{
		var totalRecords = parseInt(formObj.totalRecords.value);
	
		var proceed = true;
		var entered_records = 0;
		//checking whether any combination of drug and product_id is repeated
		for(var m=1; m<totalRecords; m++)
		{
			var record1 = eval("formObj.drug_code"+m).value;
			if(record1!="")
			{
				for(var n=m+1; n<=totalRecords; n++)
				{
					var record2 = eval("formObj.drug_code"+n).value;
					if(record2!="" && record1==record2)
					{
						if(eval("formObj.product_id"+m).value==eval("formObj.product_id"+n).value)
						{
							repeated_msg =repeated_msg.replace("#",m);
							repeated_msg =repeated_msg.replace("$",n);
							alert(repeated_msg);
							proceed = false;
							break;
							
						}
					}
				}
				if(proceed == false)
					break;
			}
		}
		
		if(proceed == false)
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return;
		}
	   var fields = new Array ();
	    var names= new Array();
		//Checking whether external drug code is blank
		var j=0;
		for(var i=1; i<=totalRecords; i++)
		{
			
			if(eval("formObj.drug_code"+i).value!="")
			{
				entered_records++;
				fields[j] = eval("formObj.ext_drug_code"+i);	
				 names[j]= new Array(getLabel("ePH.ExternalDrugCode.label","PH")+" "+i);	
				j++;
			}
		}
		if(entered_records == 0)
		{
			alert(getMessage("ATLEAST_ONE_RECORD_ENTERED","COMMON"));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return;
		}
		 if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
		{
			eval(formApply( f_query_add_mod.document.frmExtProductLink,PH_CONTROLLER));
			 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			 if( result1 ) {
				 onSuccess();
			}							
		}								
	}
	if( mode == MODE_MODIFY ) {
		var fields = new Array ( formObj.ext_prod_drug_code );
		var names = new Array ( getLabel("ePH.ExternalDrugCode.label","PH"));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval(formApply( f_query_add_mod.document.frmExtProductLink,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) {
				onSuccess();
			}
		}
	}
}

function showAlert(ext_prod_drug_code, product_id)
{
	if(!(ext_prod_drug_code == ""))
	{
		var msg =getMessage("DRUG_ALREADY_MAPPED_WITH_PRODUCT_ID","PH");
		msg = msg.replace("#",product_id);
		msg = msg.replace("$",ext_prod_drug_code);
		alert(msg);

		return true;
	}
	else
		return false;
}

function AlertExtDrugCode(drugCodeObj,extDrugCodeObj,productIdObj,typeObj)
{
	var formObj = document.frmExtProductLink;
	if( productIdObj.value == "CIMS") { 
		typeObj.disabled = false;
		extDrugCodeObj.disabled = false;	  //CIMS - Lookup
	} else {
		typeObj.disabled = true;
		extDrugCodeObj.disabled = true;	  //CIMS - Lookup
	}
	if(drugCodeObj.value !="" && drugCodeObj.value != null){
		
			var bean_id			= formObj.bean_id.value ;
			var bean_name	    = formObj.bean_name.value ;	
			var xmlStr ="";
			xmlStr ="<root><SEARCH " ;
			xmlStr			+= " bean_id=\""+ bean_id + "\" ";
			xmlStr			+= " bean_name=\""+ bean_name + "\" ";
			xmlStr			+= " drug_code=\""+ drugCodeObj.value + "\" ";
			xmlStr			+= " product_id=\""+ productIdObj.value + "\" ";
			xmlStr +=" /></root>" ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					
			xmlHttp.open( "POST", "ExtProdLinkValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=asso_ext_drug_code", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			var result = eval(responseText);
			if(!result)
			{

				extDrugCodeObj.disabled = false;
				extDrugCodeObj.focus();
			}
			else
			{
				extDrugCodeObj.value="";
				if( productIdObj.value == "CIMS") { 
					extDrugCodeObj.disabled = false;
				}else{
					extDrugCodeObj.disabled = true;
				}
				
			}

	}	
		
}

/* Added for CIMS Lookup */
async function queryCIMSCode(productIdObj,typeObj,codeObj,cims_searchObj)
{
	var formObj = document.frmExtProductLink;
	if( trimString(productIdObj.value) == "CIMS")  {

		if(typeObj!=null && typeObj!="")
			typeObj.disabled = false;
		cims_searchObj.disabled = false;
	} else {
		if(typeObj!=null && typeObj!="")
			typeObj.disabled = true;
	
		cims_searchObj.disabled = true;
	}
	if( trimString(productIdObj.value) == "CIMS"){
		if(codeObj.value.length < 3) {
			var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
		    msg = msg.replace('$', "External Drug Code");
			alert(msg);
			return false;
		} // do not proceed.	
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	

		var type_value		= "";
		if(typeObj!=null && typeObj!="")
			type_value = trimString(typeObj.value);
		else 
			type_value = "GenericItem";// It will be generic	 

		var dialogHeight	= "400px" ;
		var dialogWidth		= "700px" ;
		var dialogTop		= "169" ;
		var center			= "1" ;
		var status			="no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "" ;
		retVal				= await window.showModalDialog("../../ePH/jsp/CIMSLookupFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&type="+type_value+"&code="+trimString(codeObj.value) ,arguments,features);
		if(retVal!=null)
		{
			codeObj.value = retVal;
		}
	 
	} 	
		
}
/* Added for CIMS Lookup - Till here*/




