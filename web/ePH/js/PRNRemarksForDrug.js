var message = "" ;
var result=false;

function create() 
 {
      f_query_add_mod.location.href="../../ePH/jsp/PRNRemarksForDrugFrames.jsp?mode="+MODE_INSERT;
      messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
 }
function query() 
 {
	f_query_add_mod.location.href="../../ePH/jsp/PRNRemarksForDrugFrames.jsp?mode="+MODE_MODIFY;
	 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
 }

function disableMainForm()	
	{
	var arrObj =document.PRNRemarksForDrugCriteria.elements;
    for(var i=0;i<arrObj.length;i++)
           arrObj[i].disabled=true;
    }
function noRecordsFound(flag)	
	{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH"));
		parent.f_prn_remarks_drug_criteria.location.reload();
    }
async function searchDrug(obj)
{
	var language_id=document.PRNRemarksForDrugCriteria.language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_order_type = document.PRNRemarksForDrugCriteria.sql_drug_lookup.value; 
    var language_id=document.PRNRemarksForDrugCriteria.language_id.value;
 
    sql_order_type=sql_order_type.replace("#","'"+language_id+"'");
   
		
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2,3";
	argumentArray[5]   = document.PRNRemarksForDrugCriteria.drugSearch.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != '' && retVal != undefined){

		document.PRNRemarksForDrugCriteria.drugSearch.value = arr[1] ;
		document.PRNRemarksForDrugCriteria.drug_code.value = arr[0];		
	}
	else{
		document.PRNRemarksForDrugCriteria.drugSearch.value = '';
		document.PRNRemarksForDrugCriteria.drug_code.value = '';	
	}
}

function reset()
{
		
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("prnremarksfordrug")!=-1) ) {	

			if (f_query_add_mod.f_prn_remarks_drug_criteria.PRNRemarksForDrugCriteria)
			{
				if (f_query_add_mod.f_prn_remarks_drug_criteria.PRNRemarksForDrugCriteria != undefined)
				{
					f_query_add_mod.f_prn_remarks_drug_criteria.location.reload();
				}	
			}
			if (f_query_add_mod.f_prn_remarks_drug_result.PRNRemarksForDrugResultForm)
			{
					
				if (f_query_add_mod.f_prn_remarks_drug_result.PRNRemarksForDrugResultForm != undefined)
				{		
					f_query_add_mod.f_prn_remarks_drug_result.location.href = '../../eCommon/html/blank.html';
				}
			}
	}	
		
}
 
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("remarkfordrugcriteria")==-1))
	{  
		return true;
	}	
	else{		
		return false;
	}  
}
function apply()
  {
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var formObj=f_query_add_mod.f_prn_remarks_drug_criteria.document.PRNRemarksForDrugCriteria;
	
	var fields = new Array (formObj.drugSearch);
	var names = new Array (getLabel("ePH.DrugSearchText.label","PH"));
   if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame))
	{ 
		 if (f_query_add_mod.f_prn_remarks_drug_result.document.PRNRemarksForDrugResultForm)
		 
		 {
		  var frmObj1=f_query_add_mod.f_prn_remarks_drug_result.document.PRNRemarksForDrugResultForm;
		  var mode  =  formObj.mode.value;
		  

		  var drug_code = f_query_add_mod.f_prn_remarks_drug_criteria.PRNRemarksForDrugCriteria.drug_code.value;
		  var drug_desc = f_query_add_mod.f_prn_remarks_drug_criteria.PRNRemarksForDrugCriteria.drugSearch.value;

		  if (mode == '1' || mode == '2')
		  {
			 
			var bean_id			=	f_query_add_mod.f_prn_remarks_drug_result.document.PRNRemarksForDrugResultForm.bean_id.value;
			var bean_name		=	f_query_add_mod.f_prn_remarks_drug_result.document.PRNRemarksForDrugResultForm.bean_name.value;
			
			
			var xmlDoc			= "" ;
			var xmlHttp			= new XMLHttpRequest();
			var xmlAppend		= "";	

			xmlAppend += "drug_code"+"=\""+drug_code+"\" " ;
			//Passed encodeuricomponent for drug desc regdng incident num:26241==By Sandhya==02/FEB/2011
			xmlAppend += "drug_desc"+"=\""+encodeURIComponent(drug_desc,"UTF-8")+"\" " ;  
			xmlStr ="<root><SEARCH " ;			
			xmlStr =xmlStr + xmlAppend ;
			xmlStr +=" /></root>" ;

			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//alert("xmlStr=======>" +xmlStr);
			xmlHttp.open( "POST", "PRNRemarksForDrugValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=onApply", false);		
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;		  
			  
			  
		 }		
		} 
		else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		   
			  
	 }	
}
 
 

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

 function charsCapsSpaceDotCamasOnly()
  {
	
	  if(event.keyCode >=65 && event.keyCode<=90)
		  event.keyCode = event.keyCode;
	  else if(event.keyCode >=97 && event.keyCode<=122)
		  event.keyCode = event.keyCode;
	  else if(event.keyCode >=48 && event.keyCode<=57)
		  event.keyCode = event.keyCode;
	   else 
		 event.keyCode=0;
  }

function searchPRNRemarksForDrug(){
	var mode			=		document.PRNRemarksForDrugCriteria.mode.value;
	var drug_desc		=		document.PRNRemarksForDrugCriteria.drugSearch.value;
	var drug_code		=		document.PRNRemarksForDrugCriteria.drug_code.value;
	var PRNSearchText	=		document.PRNRemarksForDrugCriteria.PRNSearchText.value;
	var PRNSearchBy		=		document.PRNRemarksForDrugCriteria.PRNSearchBy.value;
	var bean_id			=		document.PRNRemarksForDrugCriteria.bean_id.value;
	var bean_name		=		document.PRNRemarksForDrugCriteria.bean_name.value;

	if (drug_code == '' || drug_desc == '')
	{
		alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		return false;
	}
	else{
	disableMainForm();
	parent.f_prn_remarks_drug_result.location.href="../../ePH/jsp/PRNRemarksForDrugResult.jsp?drug_code="+drug_code+"&PRNSearchText="+PRNSearchText+"&PRNSearchBy="+PRNSearchBy+"&bean_id="+bean_id+"&bean_name="+bean_name+"&mode="+mode+"&search=new&from=0&to=19";
	}
}

function callDefaultSelect(obj,checkedRowIndex,changedAtIndex,reason_code){
	
	var from		=	document.PRNRemarksForDrugResultForm.from.value;
	var to			=	document.PRNRemarksForDrugResultForm.to.value;
	if (obj.checked == true)
	{
		obj.value = 'Y';
		obj.checked = true;
		for (i = from; i<=to; i++ )
		{
			
			checkboxName = eval("document.PRNRemarksForDrugResultForm.default_prn_select_"+i).name
			if (!(obj.name == checkboxName))
			{
				eval("document.PRNRemarksForDrugResultForm.default_prn_select_"+i).value = 'N';
				eval("document.PRNRemarksForDrugResultForm.default_prn_select_"+i).checked = false;
			}
			
		}
	}else{
		obj.value = 'N';
		obj.checked = false;
	}		
	
	
	
	var bean_id			=	document.PRNRemarksForDrugResultForm.bean_id.value;
	var bean_name		=	document.PRNRemarksForDrugResultForm.bean_name.value;
	var drug_code		=	document.PRNRemarksForDrugResultForm.h_drug_code.value;

	
	
	var changedValue	=	obj.value;	
	var xmlDoc			= "" ;
	var xmlHttp			= new XMLHttpRequest();
	var xmlAppend		=	"";

	xmlAppend += "changedAtIndex"+"=\""+changedAtIndex+"\" " ;
	xmlAppend += "changedValue"+"=\""+changedValue+"\" " ;
	

	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
  	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "PRNRemarksForDrugValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=defaultSelectChecked", false);		
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	
}

function callSelect(obj,changedAtIndex){
	
	if (obj.checked == true)
	{
		obj.value = 'Y';
		obj.checked = true;
	}else{
		obj.value = 'N';
		obj.checked = false;
	}

	
	var bean_id			=	document.PRNRemarksForDrugResultForm.bean_id.value;
	var bean_name		=	document.PRNRemarksForDrugResultForm.bean_name.value;
	var changedValue	=	obj.value;	
	var xmlDoc			="";
	var xmlHttp			= new XMLHttpRequest();
	var xmlAppend		=	"";

	xmlAppend += "changedAtIndex"+"=\""+changedAtIndex+"\" " ;
	xmlAppend += "changedValue"+"=\""+changedValue+"\" " ;
	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
  	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "PRNRemarksForDrugValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=selectChecked", false);		
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
		
}

function submitPrevNext(from, to){
	document.PRNRemarksForDrugResultForm.from.value = from;
	document.PRNRemarksForDrugResultForm.to.value = to; 
	document.PRNRemarksForDrugResultForm.submit();		
}

function checkForm(flag,flag1){
	
	frmObj1 = f_query_add_mod.f_prn_remarks_drug_result.document.PRNRemarksForDrugResultForm;
	if (flag == '' || flag1 == 'false')
	{
		alert(getMessage("REMARKS_SELECT","PH"));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else{
	eval(formApply(frmObj1,PH_CONTROLLER ));			 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		f_query_add_mod.f_prn_remarks_drug_criteria.location.reload();
		f_query_add_mod.f_prn_remarks_drug_result.location.href="../../eCommon/html/blank.html";
	}
	}
}

