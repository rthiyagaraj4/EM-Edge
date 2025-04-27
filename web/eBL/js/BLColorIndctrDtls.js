/* This JS created against NMC-JD-CRF-0042 [IN:071799] */

var finColorArr=[];

//Function Onload
function onLoadColorIndr(){
	for(var e=1;e<=6;e++){
		var timLimitVal=document.getElementById('timeLimit'+e).value;
		if(timLimitVal!="00:00"){
			var colVal=document.getElementById('colInd'+e).value;		
			document.getElementById('colInd'+e).style.backgroundColor = colVal;
			document.getElementById('colInd'+e).style.color = colVal;
			document.getElementById('colIndc'+e).value=colVal;
			document.getElementById('colInd'+e).style.cursor = "not-allowed";
			 var element = document.getElementById('colImg' + e);
				if (element)
				{
				  element.style.pointerEvents = 'visible';  
				 }
		}else{
			document.getElementById('colInd'+e).style.backgroundColor = "#FFFFFF";
			document.getElementById('colInd'+e).style.color = "#FFFFFF";
			document.getElementById('colIndc'+e).value="#FFFFFF";
			document.getElementById('colInd'+e).value="#FFFFFF";
			document.getElementById('colInd'+e).style.cursor = "not-allowed";
			
			/*document.getElementById('colImg'+e).disabled = true;
			*/
		      var element = document.getElementById('colImg' + e);
				if (element)
				{
				  element.style.pointerEvents = 'none';  
				 }
		      
		}
		document.getElementById('reqStatus'+e).style.cursor = "not-allowed";
	}
}

//Apply function to Save Values into DB
function apply() {	
	var checkVal=window.frames["BLColorIndctrDtlsFrame"].document.getElementById("finArrIds").value;
	var is_mul_fact_ded_rule_mod=window.frames["BLColorIndctrDtlsFrame"].document.getElementById("is_mul_fact_ded_rule_mod").value;
	//Frame Name - BLColorIndctrDtlsFrame
	if((checkVal!="" && checkVal!=null) || is_mul_fact_ded_rule_mod == "Y"){
		var formObj = BLColorIndctrDtlsFrame.document.forms[0];
		formObj.target = 'messageFrame';  //Setting target so that it prints the output message from servlet inside Message Frame Down
		formObj.method='post';
		formObj.action="../../servlet/eBL.BLColorIndctrServlet";
		formObj.submit();
	}else{
		alert(getMessage('BL0842','BL'));
		commontoolbarFrame.document.location.reload();
		return false;
	}
}

function reset() {
	
	var BLColorIndctrDtlsFrame = document.getElementById('BLColorIndctrDtlsFrame');
	BLColorIndctrDtlsFrame.contentWindow.location.reload();
	parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html';
}

async function getColor(e,e1){ //for color table
	var curColorVal=document.getElementById(e).value ;
	var retVal = "";
	var dialogHeight = "255px";
	var dialogWidth =	"255px";
	var dialogTop = "-156px";
	var dialogLeft = "20px";
	var dialogBorder = "1px solid";
	var status = "no";
	var arguments ="";
	var action_url = '../../eBL/jsp/BLColorTable.jsp';
	var features =	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop:" + dialogTop +" ;dialogLeft:" + dialogLeft+" ;dialogBorder:" + dialogBorder ; 
	retVal = await window.showModalDialog(action_url,arguments,features);
	document.getElementById(e).style.backgroundColor = retVal;
	document.getElementById(e).style.color = retVal;
	//document.getElementById(e).setAttribute("value",retVal);
	document.getElementById(e).value=retVal;//type color
	document.getElementById(e1).value=retVal;//hidden
	
	if(curColorVal!=retVal){
		var lastChar = e.substr(e.length - 1);
		finColorArr=removeItemAll(finColorArr,lastChar);
		finColorArr.push(lastChar);
		saveID(finColorArr);
	}
}

//Function to validate Time
function checkHHMM(e) 
{
    var lastChar1 = e.id.substr(e.id.length - 1);
    finColorArr=removeItemAll(finColorArr,lastChar1);
    finColorArr.push(lastChar1);
    saveID(finColorArr);
    var n=document.getElementById(e.id);
    var lastChar = e.id.substr(e.id.length - 1);
    var timeVal=e.value;
    var re=/\b(?!00:00)[0-9]{2}:[0-5][0-9]\b/;
    if(!re.test(timeVal) && timeVal!="00:00")
    {
      //alert(getMessage('BL0141','BL'));
    	alert('APP-BL0141 Invalid value in time (HHMM)');
      document.getElementById(e.id).value="00:00";
      window.setTimeout(function ()
      {
      document.getElementById(e.id).focus();
      }, 0);
      document.getElementById('colInd'+lastChar).style.backgroundColor = "#FFFFFF";
      document.getElementById('colInd'+lastChar).style.color = "#FFFFFF";
      document.getElementById('colInd'+lastChar).value="#FFFFFF";
      
     /* document.getElementById('colImg'+lastChar).disabled = true;*/
      var element = document.getElementById('colImg' + lastChar);
		if (element)
		{
		  element.style.pointerEvents = 'none';  
		 }
      
    }else{
		/*document.getElementById('colImg'+lastChar).disabled = false;*/
    	var element = document.getElementById('colImg' + lastChar);
		if (element)
		{
		  element.style.pointerEvents = 'visible';  
		 }
	}
	if(timeVal=="00:00"){
		document.getElementById('colInd'+lastChar).style.backgroundColor = "#FFFFFF";
		document.getElementById('colInd'+lastChar).style.color = "#FFFFFF";
		document.getElementById('colInd'+lastChar).value="#FFFFFF";
		
		/*document.getElementById('colImg'+lastChar).disabled = true;
*/		
		var element = document.getElementById('colImg' + lastChar);
		if (element)
		{
		  element.style.pointerEvents = 'none';  
		 }
			 
	}
}

//Function to remove element from JS array
function removeItemAll(arr, value) {
	var i = 0;
	while (i < arr.length) {
	if (arr[i] === value) {
		arr.splice(i, 1);
	} else {
		++i;
		}
	}
	return arr;
}

//Function to save value in Texbox
function saveID(finColorArr1){
	var finArrValue="";
	for(var z=0;z<finColorArr.length;z++){
		finArrValue=finArrValue+finColorArr[z]+"~~";
	}
	document.getElementById("finArrIds").value="";
	document.getElementById("finArrIds").value=finArrValue;
}

function onSuccess() {
	
		BLColorIndctrDtlsFrame.document.location.reload();
		
		var isMFDRApplicableForSite = BLColorIndctrDtlsFrame.document.forms[0].isMFDRApplicableForSite.value;
		if(isMFDRApplicableForSite == "Y") {		
			TabsFrame.document.location.reload();
		}
}

function onPageLoad(){
	var isMFDRApplicableForSite = document.forms[0].isMFDRApplicableForSite.value;
	
	if(isMFDRApplicableForSite == "Y") {
		var mul_fact_ded_rule_YN = document.forms[0].mul_fact_ded_rule_YN.value;
		var drug_cat_YN = document.forms[0].drug_cat_YN.value;
		var diag_cat_YN = document.forms[0].diag_cat_YN.value;
		var service_items_YN= document.forms[0].service_items_YN.value; //230210
		
		parent.TabsFrame.document.location.href = "../../eBL/jsp/BLParametersTabMain.jsp?mul_fact_ded_rule_YN="+mul_fact_ded_rule_YN+"&drug_cat_YN="+drug_cat_YN+"&diag_cat_YN="+diag_cat_YN+"&service_items_YN="+service_items_YN;  //230210
	}
}
