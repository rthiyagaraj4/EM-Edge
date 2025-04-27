var Col_A="EM_Col_A EM_Cell_height EM_TableACell_Width";
var Col_A_Select="EM_Col_A EM_Cell_height EM_TableACell_Width EM_Col_Select";
var Col_A_Select_P="EM_Col_A EM_Cell_height EM_TableACell_Width EM_Col_Select_P";
var Col_B="EM_Col_B EM_Cell_height EM_TableACell_Width";
var Col_B_Select="EM_Col_B EM_Cell_height EM_TableACell_Width EM_Col_Select";
var Col_B_Select_P="EM_Col_B EM_Cell_height EM_TableACell_Width EM_Col_Select_P";
var neArray=["PO","SQ","AR","PA","SS","HE"];
var pmArray=["SK","LA","PS","BR","EE","GM","GF"];
function calScore(pid,id,val,cssPos){
	if(document.forms[0].isAuditYN.value != 'Y'){//IN067564
		for(var i=-1;i<6;i++){	
			if(i==parseInt(val)&&cssPos=="Col_A"){
				document.getElementById(id+i).className=Col_A_Select;
				document.getElementById(id).value=i;
			}else if(i==parseInt(val)&&cssPos=="Col_B"){
				document.getElementById(id+i).className=Col_B_Select;
				document.getElementById(id).value=i;
			}else if(cssPos=="Col_A"){
			
				document.getElementById(id+i).className=Col_A;
			}
			else if(cssPos=="Col_B"){
				
				document.getElementById(id+i).className=Col_B;
			}
		}
		
		totalScore(pid);
		parent.BallardScoreButtonFrame.document.BallardScoreButtonForm.record.disabled="";
		parent.BallardScoreButtonFrame.document.BallardScoreButtonForm.print.disabled="disabled";
	}//IN067564
}
function totalScore(pid){
	
	var neScore=0;
	var pmScore=0;
	
	for (var i = 0; i < neArray.length; i++) {
		if(document.getElementById(neArray[i]).value!='')
			neScore = neScore+parseInt(document.getElementById(neArray[i]).value);
	}
	for (var j = 0; j < pmArray.length; j++) {
		if(document.getElementById(pmArray[j]).value!='')
			pmScore = pmScore+parseInt(document.getElementById(pmArray[j]).value);
	}
	if(pid=='NE'){
	document.getElementById('NE').value=neScore;
	document.getElementById('NESCORE').innerHTML=neScore;
	}
	if(pid=='PM'){
	document.getElementById('PM').value=pmScore;
	document.getElementById('PMSCORE').innerHTML=pmScore;
	}
	document.getElementById('TT').value=neScore+pmScore;
	document.getElementById('TOTALSCORE').innerHTML=neScore+pmScore;
	
}
//function displayRecordScore(patientId,calling){//commented for IN067564
function displayRecordScore(patientId,calling,isAuditYN,encounter_id,Recorded_date){//IN067564
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	//xmlStr += "patient_id=\""+ patientId +"\" " ;//commented for IN067564
	xmlStr += "patient_id=\""+ patientId +"\"  isAuditYN=\""+ isAuditYN +"\" encounter_id=\""+ encounter_id +"\" Recorded_date=\""+ Recorded_date +"\" " ;	//IN067564
	xmlStr +=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CABallardScoreIntermediate.jsp", false ) ;	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	var jsonObj = JSON.parse(responseText );
	
	for(var i=0;i<jsonObj.length;i++){
		
		var code = jsonObj[i]["B_CODE"];
		var value = jsonObj[i]["B_VALUE"];
		var parentId  =jsonObj[i]["PARENT_ID"];
		var css = jsonObj[i]["B_CSS"];
		displayRecordScoreDetails(parentId,code,value,css,calling);
	}
	
}

function displayRecordScoreDetails(parentId,code,value,css,calling){
	
	if(parentId!=""){
		if(css=="Col_A"){
			if(calling=='Print')
				document.getElementById(code+value).className=Col_A_Select_P;
			else
				document.getElementById(code+value).className=Col_A_Select;
		}else if(css=="Col_B"){
			if(calling=='Print')
				document.getElementById(code+value).className=Col_B_Select_P;
			else
				document.getElementById(code+value).className=Col_B_Select;
		}
		document.getElementById(code).value=value;
		totalScore(parentId);
	}
}
function apply()
{
	parent.BallardScoreFrame.document.BallardScoreForm.submit();
}
function reSet(){
	parent.BallardScoreFrame.location.reload();
}
async function printBallardScore(){
	
	var patient_id  = parent.BallardScoreFrame.document.BallardScoreForm.patientId.value;
	var encounter_id = parent.BallardScoreFrame.document.BallardScoreForm.encounterId.value;
	var url ='../../eCA/jsp/CABallardScorePrint.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;
	var dialogTop		= "10" ;	
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "95vw" ;
	var status			= "no";
	var arguments		= "" ;
	var features		=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=yes; status:" + status;
	var retval = await window.showModalDialog(url,arguments,features);
}
 //IN067564 starts
async function ShowHistory1(){
	
			var returnVal = new String();
		var patient_id  = parent.BallardScoreFrame.document.BallardScoreForm.patientId.value;
		
			var encounter_id = parent.BallardScoreFrame.document.BallardScoreForm.encounterId.value;
			
		var dialogHeight ='90vh' ;
		var dialogWidth = '95vw' ;
		var scroll = 'yes';
		var status = 'no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';scroll=yes; status:' + status;
		var arguments = "";
		var url = '../../eCA/jsp/CABallardScoreFrameset.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'';
	
		returnVal = await top.window.showModalDialog(url,arguments,features);
	

} 
 

function ShowResult(Recorded_date,enc_id){

	var patient_id  = document.BallardScoreForm1.patientId.value;
	
	parent.BallardScoreAuditResultFrm.location.href='../../eCA/jsp/CABallardScore.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+Recorded_date+'&recordedScoreYN=Y&isAuditYN=Y' ;
	//parent.BallardScoreAuditPrintFrm.location.href='../../eCA/jsp/CABallardScoreAuditPrint.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+Recorded_date+'&isAuditYN=Y' ;
	parent.BallardScoreAuditPrintFrm.location.href='../../eCA/jsp/CABallardScoreAuditPrint.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+Recorded_date+'&isAuditYN=Y&isPrintEnableYn=Y' ;
	//parent.BallardScoreAuditPrintFrm.document.forms[0].print.disabled = false;

} 
async function printBallardScoreRecord(){
	
	var patient_id  = document.BallardScoreForm1.patientId.value;
	var encounter_id = document.BallardScoreForm1.encounterId.value;
	var Recorded_date = "";
	var isAuditYN = "";
	if(parent.frames[1].document.forms[0].Recorded_date)
		Recorded_date = parent.frames[1].document.forms[0].Recorded_date.value;
	else
		Recorded_date = parent.frames[2].document.forms[0].Recorded_date.value;
	if(parent.frames[1].document.forms[0].isAuditYN)
		isAuditYN = parent.frames[1].document.forms[0].isAuditYN.value;
	else
		isAuditYN = parent.frames[2].document.forms[0].isAuditYN.value;
	
	var url ='../../eCA/jsp/CABallardScorePrint.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&Recorded_date='+Recorded_date+'&isAuditYN='+isAuditYN;
	
	var dialogTop		= "10" ;	
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "76vw" ;
	var status			= "no";
	var arguments		= "" ;
	var features		=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=yes; status:" + status;
	var retval = await window.showModalDialog(url,arguments,features);
}
function chkDateTime(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("date_from");
		var to_date = document.getElementById("date_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				ftDateCheck(from_date,to_date,format,locale);
			}
		}
	}
}

function ftDateCheck(from,to,format,locale)
{
	
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.value = "";
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.value="";
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						to.value="";
						to.select();
						to.focus();
						return false;
				   }
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.value="";
					to.select();
					to.focus();
					return false;
				}
			}
		}
}

//IN067564 ends	
