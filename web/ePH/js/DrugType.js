  //saved on 07/11/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_drug_type = "";

function query() 
{
	DrugTypeModifyQueryFrame.location.href="../../ePH/jsp/DrugTypeQueryCriteria.jsp" ;
}


function Modify(gcode)
{
mode=2;

parent.DrugTypeModifyQueryFrame.location.href="../../ePH/jsp/DrugTypeModify.jsp?gcode="+gcode+"&mode="+mode ;
}



function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}



function reset()
{
	var url = DrugTypeModifyQueryFrame.location.href;
 		  url = url.toLowerCase();
//alert(url.indexOf("drugtypequerycriteria"));
if ( (url.indexOf("drugtypequerycriteria")!=-1) )
	{
		DrugTypeModifyQueryFrame.document.query_form.reset();
	}
else if ( (url.indexOf("drugtypemodify")!=-1) )
	{
		DrugTypeModifyQueryFrame.document.DrugTypeModify.reset();
	}
}



function apply() 
{
	
	if(!checkIsValidForProceed())
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
var url = DrugTypeModifyQueryFrame.location.href;


		var formObj = DrugTypeModifyQueryFrame.document.DrugTypeModify ;
		var fields = new Array ( formObj.drug_type ,formObj.drug_desc);
		var names = new Array ( getLabel("ePH.DrugType.label","PH"),getLabel("ePH.DrugTypeDescription.label","PH"));
		if(DrugTypeModifyQueryFrame.checkFieldsofMst( fields, names, messageFrame)) 
		{ //  alert("messageFrame========>"+messageFrame)
			global_drug_type = formObj.drug_type.value;
			eval(formApply( DrugTypeModifyQueryFrame.document.DrugTypeModify,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		

			if( result ) {
				onSuccess();		
			}

	 }
 
}

 function onSuccess() {
	 mode=2;
//DrugTypeModifyQueryFrame.document.DrugTypeModify.drug_type.value="";
DrugTypeModifyQueryFrame.location.href="../../ePH/jsp/DrugTypeModify.jsp?gcode="+global_drug_type+"&mode="+mode 

//DrugTypeModifyQueryFrame.document.DrugTypeModify.eff_status.value=true;
 }

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	//alert("message-------->"+message)
	flag = _flag ;
}

function checkIsValidForProceed() {
	var url = DrugTypeModifyQueryFrame.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("reasoncodesquery")==-1) )
		return true;
	else
		return false;
}

