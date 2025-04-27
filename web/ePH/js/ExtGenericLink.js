
// created on 23/12/2009 -- Shyampriya
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
28/04/2020      IN071537        B Haribabu                                  	GHL-CRF-0614 
---------------------------------------------------------------------------------------------------------
*/ 
var function_id = "PH_EXT_GENERIC_LINK" ;
var result1	= false ;
var message = "" ;
var flag = "" ;
var invalidCode	=  "";

var globalCode="";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/ExtGenericLinkAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/ExtGenericLinkQueryCriteria.jsp?function_id="+function_id ;
}

function ModifyRow(obj) {
	//Added for IN:071537 start
	var formObj = document.ExtGenericLinkQueryResultForm;
	var type_appl_yn=formObj.type_appl_yn.value;
	//Added for IN:071537 end
	var generic_id = obj.cells[0].innerText;
	var generic_name = obj.cells[1].innerText;
	var product_id = obj.cells[2].innerText;
	//Added for IN:071537 start
	var type="";
	var ext_prod_generic_id="";
	if(type_appl_yn=="Y"){
		 type = obj.cells[3].innerText;
		 ext_prod_generic_id = obj.cells[4].innerText;
	}else{
		 type = "";
		 ext_prod_generic_id = obj.cells[3].innerText;
	}
	if(type=="Generic Item ")
		type="GenericItem";
	if(type=="Substance Class ")
		type="SubstanceClass";
	if(type=="Active Composition Group ")
		type="ActiveCompositionGroup";
	//Added for IN:071537 end
	
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/ExtGenericLinkAddModify.jsp?mode="+MODE_MODIFY+"&generic_id="+generic_id+"&generic_name="+generic_name+"&product_id="+product_id+"&ext_prod_generic_id="+ext_prod_generic_id+"&type="+type;//Modified for IN:071537
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

	if ( (url.indexOf("extgenericlinkquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("extgenericlinkaddmodify")!=-1) ) {
			f_query_add_mod.document.frmExtGenericLink.reset();
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("ExtGenericLinkQuery")==-1) )
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
	var mode = f_query_add_mod.document.frmExtGenericLink.mode.value;
	if( mode == MODE_INSERT ) {
		f_query_add_mod.document.frmExtGenericLink.reset();
		f_query_add_mod.document.frmExtGenericLink.product_id1.focus();
	}
	else if(mode == MODE_MODIFY ){
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}
}

async function searchGenericName(generic_name_obj,generic_id_obj,ext_generic_id_obj,product_id_obj){
	var formObj = document.frmExtGenericLink;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.sql_ph_generic_name_select.value+"'"+document.frmExtGenericLink.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = generic_name_obj.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	retVal = await CommonLookup( getLabel("Common.GenericName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		var generic_id =  arr[0];
		var generic_name = arr[1];
		generic_name_obj.value = generic_name ;
		generic_id_obj.value = generic_id;
	
			var bean_id			= formObj.bean_id.value ;
			var bean_name	    = formObj.bean_name.value ;	
			var xmlStr ="";
			xmlStr ="<root><SEARCH " ;
			xmlStr			+= " bean_id=\""+ bean_id + "\" ";
			xmlStr			+= " bean_name=\""+ bean_name + "\" ";
			xmlStr			+= " generic_id=\""+ generic_id + "\" ";
			xmlStr			+= " product_id=\""+ product_id_obj.value + "\" ";
			xmlStr +=" /></root>" ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					
			xmlHttp.open( "POST", "ExtGenericLinkValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=asso_ext_generic_id", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			var result = eval(responseText);
			if(!result)
			{

				ext_generic_id_obj.disabled = false;
				ext_generic_id_obj.focus();
				
			}
			else
			{
				generic_id_obj.value = "";
			generic_name_obj.value="";
			ext_generic_id_obj.value = "";
			ext_generic_id_obj.disabled = true;
		}
			
		}
		else{
			generic_id_obj.value = "";
			generic_name_obj.value="";
			ext_generic_id_obj.value = "";
			ext_generic_id_obj.disabled = true;
		}

}


/*function queryDrugSearch(drugDescObj, drugCodeObj, extDrugCodeObj,productIdObj){
		var formObj = document.frmExtProductLink;
//	if(drugCodeObj.value == ""){
		var retVal=DrugSearch("D",drugDescObj);
		if(retVal != null && retVal != "" )  {
			var drug_code = retVal[0] ;
			var drug_desc = retVal[1] ;
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
}*/

function showAlert(ext_generic_id, product_id)
{
	if(!(ext_generic_id == ""))
	{
		var msg =getMessage("GENERIC_NAME_ALREADY_MAPPED_WITH_PRODUCT_ID","PH");
		msg = msg.replace("#",product_id);
		msg = msg.replace("$",ext_generic_id);
		alert(msg);

		return true;
	}
	else
		return false;
}


function apply() {
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
	}

	var formObj	=	f_query_add_mod.document.frmExtGenericLink;
	var repeated_msg = getMessage("RECORDS_HAVING_SAME_COMBINATION_OF_GENERIC_NAME_AND_PRODUCT_ID","PH");
	var mode = "";
	if(formObj)
		mode = formObj.mode.value;

	if( mode == MODE_INSERT )
	{
		var totalRecords = parseInt(formObj.totalRecords.value);
	
		var proceed = true;
		var entered_records = 0;
		//checking whether any combination of drug and product_id is repeated
		for(var m=1; m<totalRecords; m++)
		{
			var record1 = eval("formObj.generic_id"+m).value;
			if(record1!="")
			{
				for(var n=m+1; n<=totalRecords; n++)
				{
					var record2 = eval("formObj.generic_id"+n).value;
					if(record2!="" && record1==record2)
					{
						if(eval("formObj.product_id"+m).value==eval("formObj.product_id"+n).value)
						{
							repeated_msg =repeated_msg.replace("#",m);
							repeated_msg =repeated_msg.replace("$",n);
							alert(repeated_msg);
							eval("formObj.generic_id"+n).value ="";
							eval("formObj.generic_name"+n).value ="";
							eval("formObj.ext_generic_id"+n).value ="";
							eval("formObj.ext_generic_id"+n).disabled=true;
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
			
			if(eval("formObj.generic_id"+i).value!="")
			{
				entered_records++;
				fields[j] = eval("formObj.ext_generic_id"+i);	
				 names[j]= new Array(getLabel("ePH.ExternalGenericID.label","PH")+" "+i);	
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
			 eval(formApply( f_query_add_mod.document.frmExtGenericLink,PH_CONTROLLER));
			 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			 if( result1 ) {
				 onSuccess();
			}							
		}								
	}
	if( mode == MODE_MODIFY ) {
		var fields = new Array ( formObj.ext_generic_id );
		var names = new Array ( getLabel("ePH.ExternalGenericID.label","PH"));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval(formApply( f_query_add_mod.document.frmExtGenericLink,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) {
				onSuccess();
			}
		}
	}
}

/*  CIMS LOOKUP  - Till here*/
async function queryCIMSCode(productIdObj,typeObj,codeObj,cims_searchObj)
{
	var formObj = document.frmExtGenericLink;
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
		    msg = msg.replace('$', "External Generic ID");
			alert(msg);
			return false;
		} // do not proceed.	


		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	

		var type_value		= "";
		if(typeObj!=null && typeObj!="")
			type_value = trimString(typeObj.value);
		else 
			type_value = "Molecule";// It will be Molecule, to link  the generic item with allergy
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
/*  CIMS LOOKUP  - Till here*/
//Added for IN:071537 start
function clearExtProductID(){
	 document.frmExtGenericLink.ext_generic_id.value="";
}
//Added for IN:071537 end




