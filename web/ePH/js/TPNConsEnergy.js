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


function query(){
	mode=3;
	ConsEnergyModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsEnergyQueryResult.jsp?function_id=Reconstituent Fluid for drug" ;
}
//ADDED FOR ML-MMOH-CRF-1266 START
function create() {
	mode=1;
	ConsEnergyModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsEnergyModify.jsp?mode="+mode ;
}
//ADDED FOR ML-MMOH-CRF-1266 END

function apply(){
	//Nothing to validate..directly call insert method
	url=ConsEnergyModifyQueryFrame.location.href;
	var frmobj =ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy;
	var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
	//added for ml-mmoh-crf-1266 start
	if(url.indexOf("Insert")==-1){
	var gCode=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.gCode.value;
	if(gCode ==""){
	//message ="Select "+getLabel("ePH.ConstituentCode.label","PH");
	       message = getMessage("CAN_NOT_BE_BLANK","Common");
			message = message.replace('$', getLabel("ePH.ConstituentCode.label","PH"));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	return;
	}
	var name=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.gName.value;
	if(name ==""){
	//message =getLabel("ePH.EnergyValue.label","PH")+" Cannot be Blank";
	message = getMessage("CAN_NOT_BE_BLANK","Common");
	message = message.replace('$', getLabel("Common.ConstituentName.label","Common"));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.gName.focus();
	return;
	}
	var eRelval=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.erelval.value;
	if(eRelval ==""){
	//message =getLabel("ePH.EnergyValue.label","PH")+" Cannot be Blank";
	message = getMessage("CAN_NOT_BE_BLANK","Common");
	message = message.replace('$', getLabel("ePH.EnergyValue.label","PH"));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.erelval.focus();
	return;
	}
	}
	//added for ml-mmoh-crf-1266 end
	if (url.indexOf("Modify")!=-1){
		
		var fields=new Array();
		fields[0]=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.gName;

		var names=new Array();
		names[0]=getLabel("Common.ConstituentName.label","Common");
		if(frmobj.gCode.value == 'CHO'){
			fields[1]=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.erelval;
			names[1]=getLabel("ePH.EnergyValue.label","PH");
		}
				
		var blankObj 	= null ;
		blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
		if(blankObject==null){
			eval(formApply(frmobj, PH_CONTROLLER) ) ;
			//alert(formApply(frmobj, PH_CONTROLLER) ) ;
			if (result){
					onSuccess(frmobj); 
			}
		}
		else{
			blankObject.focus() ;
		}
	}
  //ADDED FOR ML-MMOH-CRF-1266 START
	else if(url.indexOf("Insert")==-1){
			
			var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
			var fields=new Array();
			fields[0]=ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy.gName;
			
			var names=new Array();
			
			names[0]=getLabel("Common.ConstituentName.label","Common");
	
			var blankObject 	= null ;
			
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
	}
	else{
		//this.commontoolbarFrame.location.reload();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
}

function modifyEnergy(gcode){
	mode=2;
	parent.ConsEnergyModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsEnergyModify.jsp?gcode="+gcode+"&mode="+mode ;
}

function onSuccess(frmobj){
	//alert("THIS IS THE MESSGE"+message);
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
 //added for ml-mmoh-scf-1266 start
		if (frmobj.mode.value=="1"){
			
		create();
		return false;
		}
		if (frmobj.mode.value=="2"){
		query();
		return false;
		}
		//added for ml-mmoh-scf-1266 end
	
}

function reset(){
	url=ConsEnergyModifyQueryFrame.location.href;
	if (url.indexOf("Modify")!=-1){
		var frmobj =ConsEnergyModifyQueryFrame.document.FrmTPNConsEnergy;
		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
		frmobj.reset();
	}
	else{
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


function validateEnergy(obj)
	{
		var gCode = document.forms[0].gCode.value;
	//if(gCode == 'CHO'||gCode == 'LIPID'||gCode == 'PROTEIN')//commented for ml-mmoh-crf-1266
		if(obj.value != "")
		{
			//CheckPositiveNumber(obj));
			var energy = parseFloat(obj.value);
			if(energy < 0.01 || energy>9.99){
				var msg = getMessage("PH_CARBOHYDRATE_ENERGY_LEVEL","PH");
				//msg = msg.substring(0, msg.length-1);
				//var msg = "Energy level should be between 0.1 and 9.99";
				alert(msg);
				obj.select();
				obj.focus();
			}
		}
		
}
//added for ml-mmoh-crf-1266
function selectName(sel){
	if(document.forms[0].gCode.value== ""){
	document.forms[0].gName.value="";
	}
	else
	{document.forms[0].gName.value=document.getElementById(document.forms[0].gCode.value).value;}
	
}
