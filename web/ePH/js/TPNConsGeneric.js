//saved on 26/10/2005
var result		= false ;
var message		= "" ;
var flag		= "" ;
var mode=0;

var firstTime=true;
var pageNum=1;
var totalRows=0;
// contains the number of records per page
var pageSize=10;

function create(){ // Added for ML-MMOH-CRF-1126 - Start
	mode=1;
	ConsGenericModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGenericCreate.jsp?mode="+mode;
}  // Added for ML-MMOH-CRF-1126 - End

function query(){
	mode=3;
	ConsGenericModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGenericQueryResult.jsp?function_id=Reconstituent Fluid for drug" ;
}

function apply()
{ 
		//Nothing to validate..directly call insert method
		url=ConsGenericModifyQueryFrame.location.href;
		
		if(url.indexOf("Create")!=-1){  // Added for ML-MMOH-CRF-1126 -Start
			var frmobj =ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric;
			var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
			var fields=new Array();
			fields[0]=ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric.gCode;
			
			var names=new Array();
			
			names[0]=getLabel("ePH.ConstituentGenericCode.label","PH");
	
			var blankObject 	= null ;
			
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			if (blankObject!=null){
				blankObject.focus() ;
				return;
			}
			names[0]=getLabel("ePH.ConstituentGenericName.label","PH");
			fields[1]=ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric.gName;
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			 if (blankObject!=null){
				blankObject.focus() ;
				return;
			}
			else 
			{ 
				eval(formApply(frmobj, PH_CONTROLLER) ) ;
				if (result){
						onSuccess(frmobj);
				}
			}
			
		} // Added for ML-MMOH-CRF-1126 - End
		
		else if (url.indexOf("Modify")!=-1)
		{
				var frmobj =ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric;
				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

				//check for mandatory field
				var fields=new Array();
				fields[0]=ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric.gName;

				var names=new Array();
				names[0]=getLabel("ePH.ConstituentGenericName.label","PH");

						
				var blankObj 	= null ;
				blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;

				if(blankObject==null) 
				{
					eval(formApply(frmobj, PH_CONTROLLER) ) ;
					//alert(formApply(frmobj, PH_CONTROLLER) ) ;
					if (result){
							onSuccess(frmobj);
					}
				}
				else
				{
					blankObject.focus() ;
				}

		}
		else
		{
			//this.commontoolbarFrame.location.reload();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}

}
function modifyGeneric(gcode)
{
		mode=2;
		parent.ConsGenericModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGenericModify.jsp?gcode="+gcode+"&mode="+mode ;
}
function onSuccess(frmobj)
{
			//alert("THIS IS THE MESSGE"+message);
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		

}
function reset()
{
		url=ConsGenericModifyQueryFrame.location.href;
		
		if (url.indexOf("Create")!=-1){  // Added for ML-MMOH-CRF-1126 -Start
				var frmobj =ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric;
				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
				frmobj.reset();
				disableUomLevel(ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric);
		} // Added for ML-MMOH-CRF-1126 -End
		else if (url.indexOf("Modify")!=-1)
		{
				var frmobj =ConsGenericModifyQueryFrame.document.FrmTPNConsGeneric;
				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
				frmobj.reset();
			

		}
		else
		{
			//this.commontoolbarFrame.location.reload();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
		
	

}


function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}

function assignVal(obj)
{
	
	if(obj.checked==true)
		document.FrmTPNConsGeneric.itmfld_req_yn.value="Y";
	else 
		document.FrmTPNConsGeneric.itmfld_req_yn.value="N";
	
}

function clickEnable(obj) // Added for ML-MMOH-CRF-1126 - Start
{
	
	if(obj.checked==true)
		obj.value="E";
	else 
		obj.value="D";
	
} 

function getSrlNo(){
	
	var formObj = document.FrmTPNConsGeneric;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "constGrpCode=\"" + formObj.cons_group.value + "\" " ;	
	if(formObj.cons_group.value=="FL"){
		formObj.uom_level.value="I";
	}
	xmlStr+= "uomLevel=\"" + formObj.uom_level.value + "\" " ; ;
	xmlStr +=" /></root>";
	var temp_jsp="TPNConsGenericValidate.jsp?func_mode=get_srl_no";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
} 
function displaySrlNo(srl_no){
	var formObj = document.FrmTPNConsGeneric;
	
	if(srl_no!=""){
		formObj.srlno.value=srl_no;
	}
	
} 

function disableUomLevel(formObj){
	if(formObj.cons_group.value=="FL"){
		formObj.uom_level.value = "I";
		formObj.uom_level.disabled=true;
	}
	else{
		formObj.uom_level.disabled=false;
	}
}

function enableDisable(obj){
	if(obj.checked==true)
		document.FrmTPNConsGeneric.enabled_yn.value="E";
	else 
		document.FrmTPNConsGeneric.enabled_yn.value="D";
}// Added for ML-MMOH-CRF-1126 - End
function startWithAlphabets(which) { // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	fldval = which.value.substr(0,1);
	fldval = fldval.replace(/^\s+/,""); // strip leading spaces
	if (fldval!="" && !/[a-zA-Z][a-zA-Z0-9]*/.test(fldval)) { // only alphanumeric and space allowed	
	alert(getMessage("START_WITH_ALPHABETS","PH"));
	which.value = "";
	which.focus();
	return false;
	}
} // Added for ML-MMOH-CRF-1266 [IN:068728] - End
