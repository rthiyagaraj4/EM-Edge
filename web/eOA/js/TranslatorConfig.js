function create() {	
	f_query_add_mod.location.href = "../../eOA/jsp/TranslatorConfig.jsp" ;
}
function query() {
   f_query_add_mod.location.href ="../../eOA/jsp/TranslatorConfigQueryPage.jsp";
}

function apply(){
	var fields=new Array(f_query_add_mod.document.forms[0].language_desc,
								f_query_add_mod.document.forms[0].date_range_from,
								f_query_add_mod.document.forms[0].date_range_to,
								f_query_add_mod.document.forms[0].no_of_translator,
								f_query_add_mod.document.forms[0].factor);
	var names=new Array(getLabel("Common.Language.label","Common"),
								  getLabel("Common.DateRange.label","Common")+" "+getLabel("Common.from.label","Common"),
								  getLabel("Common.DateRange.label","Common")+" "+getLabel("Common.to.label","Common"),
								  getLabel("eOA.NoofTranslators.label","OA"),
								  getLabel("eOA.NoofPatperTranslator.label","OA"));
	if(checkFields( fields, names, messageFrame)){
		 if(chkGrtr(f_query_add_mod.document.forms[0].date_range_from,f_query_add_mod.document.forms[0].date_range_to)==true){	
				 var date_from_prev=f_query_add_mod.document.forms[0].date_from.value;
				 var date_to_prev=f_query_add_mod.document.forms[0].date_to.value;
				 var date_from=f_query_add_mod.document.forms[0].date_range_from.value;
				 var date_to=f_query_add_mod.document.forms[0].date_range_to.value;
				 
				 if(date_from_prev != "" && date_to_prev !=""){
					 if((date_from != date_from_prev) || (date_to != date_to_prev))
							f_query_add_mod.document.forms[0].change_flag.value=true;
					 else
							f_query_add_mod.document.forms[0].change_flag.value=false;
				 }	 				 
				 f_query_add_mod.document.forms[0].submit() ;
		 }		
	}
}

function reset() {
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function searchLanguage(target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	var tit=getLabel("Common.Language.label","Common");

	sql="Select LANG_ID code,LONG_NAME description from MP_LANGUAGE where  eff_status='E' and  upper(LONG_NAME) like upper(?) and upper(LANG_ID) like upper(?) order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].language_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].language_desc.value=arr[1];
		document.forms[0].language_code.value=arr[0];	
		parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
		 
	}
	else{
		document.forms[0].language_desc.value='';
		document.forms[0].language_code.value='';
	}
}
function checkValue(obj){
	if(obj.value <= 0){		
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
		obj.value="";
		obj.focus();
	}
}
function chkGrtr(obj1,obj2){
		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function check_eff(obj){
	if(obj.checked == true){
		obj.value='E';
	}
	else{
		obj.value='D';
	}
}

function allowPositiveNumber() 
{
	var key = window.event.keyCode;
	if((key < 48 ) || (key >= 58)) 	
		return false;		
}

function checkDateAlert(obj)
{	
			var obj1=obj.value;		
			if(obj1 != "")
			{	
				if(!isAfterNow(obj1,"DMY", localeName))
				{
				  alert(getMessage("DATE_GT_EQ_SYS_DATE",'FM'));
				  obj.focus();
				  obj.value="";
				}
			}	
  }
