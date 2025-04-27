var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/PrescribingUomDecimalAddModify.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/PrescribingUomDecimalQueryCriteria.jsp?mode="+MODE_MODIFY;
}

function apply(){
	message="";
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		return false;
	}
	
	var mode = f_query_add_mod.document.frmPrescribingUomDecimalAddModify.mode.value;
	if( mode == MODE_INSERT )
	{
		formObj	=	f_query_add_mod.document.frmPrescribingUomDecimalAddModify;
		var arrFieldName		=	new Array();
		var arrLegends			=	new Array();
		var arrPKFieldNames		=	new Array();
		
		arrFieldName[0]			=	"PrescribeUomCode_";
		arrFieldName[1]			=	"DecimalValue_";
		arrFieldName[2]			=	"FractionalValue_";
		arrFieldName[3]			=	"FractionalDesc_";

		arrLegends[0]			=	getLabel("ePH.PrescribeUomCode.label","PH");
		arrLegends[1]			=	getLabel("ePH.DecimalValue.label","PH");
		arrLegends[2]			=	getLabel("ePH.FractionalValue.label","PH");
		arrLegends[3]			=	getLabel("ePH.FractionalDescription.label","PH");
		
		arrPKFieldNames[0]		=	"PrescribeUomCode_";
		arrPKFieldNames[1]		=	"DecimalValue_";
		if (validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,'0')){
			eval(formApply(formObj,PH_CONTROLLER));
			if( result ) {
				onSuccess();
			}
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		}
	}
	else if( mode == MODE_MODIFY ) {
		formObj	=	f_query_add_mod.document.frmPrescribingUomDecimalAddModify;
		var fields = new Array (formObj.FractionalValue ,formObj.FractionalDesc);
		var names = new Array (getLabel("ePH.FractionalValue.label","PH"),getLabel("ePH.FractionalDescription.label","PH"));
		if(checkFieldsofMst( fields, names, messageFrame)){
			eval(formApply(formObj,PH_CONTROLLER));
			if( result ) {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				onSuccess();
			}
		}
	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
}

function onSuccess() {
	formObj	=	f_query_add_mod.document.frmPrescribingUomDecimalAddModify;
	var mode = formObj.mode.value;
	if( mode == MODE_INSERT ) {
		formObj.reset();
		formObj.PrescribeUomCode_0.focus();
	}
	else if(mode == MODE_MODIFY ){
		PrescribeUomCode = formObj.PrescribeUomCode.value;
		DecimalValue = formObj.DecimalValue.value;
		f_query_add_mod.location.href="../../ePH/jsp/PrescribingUomDecimalAddModify.jsp?PrescribeUomCode="+PrescribeUomCode+"&DecimalValue="+DecimalValue+"&mode="+mode;
	}
}

function Modify(uom_code,decimal)
{
	parent.f_query_add_mod.location.href="../../ePH/jsp/PrescribingUomDecimalAddModify.jsp?PrescribeUomCode="+uom_code+"&DecimalValue="+decimal+"&mode="+MODE_MODIFY;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if (url.indexOf("querycriteria")!=-1) {
		f_query_add_mod.document.query_form.reset();
	}
	else if (url.indexOf("addmodify")!=-1) {
		f_query_add_mod.document.frmPrescribingUomDecimalAddModify.reset();
	}
}

function selectRec(checkObj){
	if(checkObj.checked==true)
		checkObj.value = 'E';
	else
		checkObj.value='D';
}

async function searchUomCode(index){
	var language_id  = document.frmPrescribingUomDecimalAddModify.Language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql = "SELECT UOM_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_UOM_LANG_VW WHERE UPPER(UOM_CODE) LIKE UPPER (?) AND UPPER (SHORT_DESC) LIKE UPPER (?) AND EFF_STATUS='E' AND LANGUAGE_ID='"+language_id+"' ORDER BY 2";
	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = eval("document.frmPrescribingUomDecimalAddModify.PrescribeUomCode_"+index).value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	var retVal = await CommonLookup(getLabel("ePH.PrescribeUomCode.label","PH"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		eval("document.frmPrescribingUomDecimalAddModify.PrescribeUomCode_"+index).value = arr[0];
		eval("document.frmPrescribingUomDecimalAddModify.ShortDesc_"+index).value = arr[1];
		setLongDesc(arr[0],index);
	}
	else{
		eval("document.frmPrescribingUomDecimalAddModify.PrescribeUomCode_"+index).value = "";
		eval("document.frmPrescribingUomDecimalAddModify.ShortDesc_"+index).value = "";
		eval("document.frmPrescribingUomDecimalAddModify.LongDesc_"+index).value = "";
	}
}

function setLongDesc(uom_code,index)
{
	if(trimString(uom_code) != ""){
		var language_id  = document.frmPrescribingUomDecimalAddModify.Language_id.value;
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"PrescribingUomDecimalBean\" " ;
		xmlStr+= " bean_name=\"ePH.PrescribingUomDecimalBean\" " ;
		xmlStr+= " frmObj=\"frmPrescribingUomDecimalAddModify\" " ;
		xmlStr+= "index  =\""+index+"\" " ;
		xmlStr+= "LANG_ID  =\""+language_id+"\" " ;
		xmlStr+= "UOM_CODE  =\""+uom_code+"\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescribingUomDecimalValidate.jsp?validate=SETLONGDESC";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);	
	}
}

function allowValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45)//-
	{
		return false;
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	var strCheck = '.0123456789-';
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false;
	}
    return true;
}

function isZero(obj,index)
{
	if(trimString(obj.value)!=""&&trimString(obj.value)==0)
		{
			alert(getMessage("PH_PRESUOM_DECIMAL","PH"));
			eval("document.frmPrescribingUomDecimalAddModify.DecimalValue_"+index).value = "";
			eval("document.frmPrescribingUomDecimalAddModify.DecimalValue_"+index).focus();
		}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
		return true;
	else
		return false;
}
