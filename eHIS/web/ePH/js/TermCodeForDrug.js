var message = "" ;
var result=false;
function create()
{
  f_query_add_mod.location.href="../../ePH/jsp/TermCodeForDrugFrame.jsp?";
}
async function searchCode(obj)
	{

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
	
	    var formObj		   = document.TermCodeAddModifyform;
		//alert("formObj--->"+formObj.name);
		argumentArray[0]   = formObj.SQL_PH_DRUG_SEARCH_DRUG.value+"'"+formObj.language_id.value+"'";
		//alert("argumentArray[0]--->"+argumentArray[0])
		
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = "";
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;

		var retVal = await CommonLookup( getLabel("ePH.DrugNameLookup.label","PH"), argumentArray );
		
		
		if(retVal != null && retVal != "" && retVal != undefined)
			{
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			//alert("check function");
			formObj.drug_code.value = arr[0];
			formObj.drug_desc.value = arr[1];
			
			
		
    
        var formObj				= document.TermCodeAddModifyform;
	    var modeVal=formObj.mode.value;
		//alert("modeVal--43-->" +modeVal);
		//Added Encode URI component for the retval[1] for the incident number:23113 in spira on Aug /5/2010

		
		parent.TermCodeResultFrame.location.href="../../ePH/jsp/TermCodeForDrugQueryResult.jsp?retVal[0]="+arr[0]+"&retVal[1]="+encodeURIComponent(arr[1],"UTF-8")+"&modeVal="+modeVal;
		
	   }
	
}

function reset()
	{

	var url = f_query_add_mod.TermCodeAddModifyFrame.location.href;
	url = url.toLowerCase();
f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform.reset();
 //  alert("url---->"+url)

	if ( (url.indexOf("termcodefordrugaddmodify")!=-1) ) {
		f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform.reset();
		//f_query_add_mod.TermCodeResultFrame.location.href="../../eCommon/html/blank.html";
	}
}
async function searchCode1(obj)
{
	
	var formObj				= document.TermCodeAddModifyform;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	
	dataNameArray[0]   = "TERM_SET_ID" ;
	dataValueArray[0]  = formObj.TermSetList.value;
	dataTypeArray[0]   = STRING ;
    
	dataNameArray[1]   = "DRUG_CODE" ;
	dataValueArray[1]  =formObj.drug_code.value;
	dataTypeArray[1]   = STRING ;

	dataNameArray[2]   = "TERM_SET_ID" ;
	dataValueArray[2]  = formObj.TermSetList.value;
	dataTypeArray[2]   = STRING ;

	//argumentArray[0]		= " SELECT TERM_CODE CODE, SHORT_DESC DESCRIPTION FROM MR_TERM_CODE WHERE UPPER(TERM_SET_ID) LIKE UPPER(?) AND EFF_STATUS = 'E' AND TERM_CODE NOT IN ( SELECT TERM_CODE FROM PH_DRUG_ELIGIBLE_TERM_CODE WHERE UPPER(DRUG_CODE)  LIKE UPPER(?) AND UPPER(TERM_SET_ID) LIKE (?))AND UPPER(TERM_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 2";
    argumentArray[0]=formObj.SQL_PH_TERM_CODE_SELECT_LOOKUP.value;	
   	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "4,5";
	argumentArray[5]		= formObj.Term_desc.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.TermCodeforDrug.label","Common"), argumentArray );
	if(retVal != null && retVal != "" && retVal != undefined )  {
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		formObj.Term_desc.value		=  arr[1] ;
		formObj.Term_code.value		=  arr[0];		
		
		
	}
}
function formReset(){
	
	var formObj				= document.TermCodeAddModifyform;
	alert(formObj.name)
	alert(formObj.TermSetList.value)
	
	
	
}

function apply() 
{   
  		var formObj = f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform;
		var mode=formObj.mode.value;
		
if( mode == "1" ) 
	{
		var fields = new Array ( formObj.drug_desc ,formObj.TermSetList,formObj.Term_desc);
		var names = new Array (getLabel("Common.Drug.label","Common"),getLabel("Common.TermSet.label","Common"),getLabel("Common.TermCode.label","Common"));
        var drug_code=formObj.drug_code.value;
        var drug_desc=formObj.drug_desc.value;
   if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame)) {
  eval(formApply(f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess(drug_code,drug_desc); 
				formObj.TermSetList.value="";
	            formObj.Term_desc.value="";
                
		}
	  }
	  
	}
	else if( mode == "2" ) 
	{
		
 //alert(formApply(f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform,PH_CONTROLLER ));
   var drug_code=formObj.drug_code.value;
   var drug_desc=formObj.drug_desc.value;
   //alert("drug_desc====142===>" +drug_desc);

   eval(formApply(f_query_add_mod.TermCodeAddModifyFrame.document.TermCodeAddModifyform,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if( result ) {
			//alert("result---->"+formObj.drug_code.value);
				onSuccess(drug_code,drug_desc);
				
		         
	  }
	}
	
}
function onSuccess(drug_code,drug_desc) {
	
	f_query_add_mod.TermCodeResultFrame.location.href="../../ePH/jsp/TermCodeForDrugQueryResult.jsp?drug_code="+drug_code+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8"); //Added encodeURIComponent for drug desc===23113 in spira
    //alert("onsuccess===157==drug_desc" +drug_desc);
}
function clearValues()
{
	//alert("on change")
 var formObj = document.TermCodeAddModifyform;
	//alert(formObj.name)
  formObj.Term_desc.value="";
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	//alert("message--->"+message)
	flag = _flag ;
}

function defaultDrug(term_code,term_code_desc,term_set_id,term_set_desc,eff_status,drug_desc,drug_code,retVal0,retVal1)
{
	//alert("drug_desc==176==>" +drug_desc);
	//alert("retVal1==177===>" +retVal1);
	

	var mode="2";
	if(retVal1=="" && retVal0=="")
	{
		
		retVal1=drug_desc;
		//alert("retVal1===185" +retVal1);
		retVal0=drug_code;
	}
	
parent.TermCodeAddModifyFrame.location.href="../../ePH/jsp/TermCodeForDrugAddModify.jsp?term_code="+term_code+"&term_code_desc="+term_code_desc+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&eff_status="+eff_status+"&mode="+mode+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&drug_code="+drug_code+"&retVal0="+retVal0+"&retVal1="+encodeURIComponent(retVal1,"UTF-8");  //Added encode URIComponent for RetVal1 & Drug_desc  regarding the incident num:23113 in spira
//alert("drug_desc=====190====>" +drug_desc);
//alert("retVal1=====191====>" +retVal1);
	
}
