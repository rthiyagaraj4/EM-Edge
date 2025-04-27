
function loadInstruciotnsCheck(){
	
	var clinicInsYN=parent.patinsframe.document.patInsForm.clinicInsYN.value;
	var orderInsYN=parent.patinsframe.document.patInsForm.orderInsYN.value;
	var orderInsStandardYN=parent.patinsframe.document.patInsForm.orderInsStandardYN.value;
	var procInsCount=parent.patinsframe.document.patInsForm.procInsCount.value;
	if(clinicInsYN=="N" && orderInsYN=="Y"){
		if(orderInsStandardYN=="N" && !(procInsCount >0)){
			alert(getMessage("PRC_INSTRUCTIONS_NOT_AVAILABLE","OA"));
			//window.close();
			toCloseTopShowModal();
		}
	}
}

function ChangeTabs(TabName){
	selectTab(TabName);
	if(TabName=='patInsTab'){
		if(parent.patinsframe){
			var from_page=parent.patinsframe.document.patInsForm.from_page.value;
			parent.patinsframe.patInsForm.document.getElementById("patinsID").style.visibility="visible";
			parent.patinsframe.patInsForm.document.getElementById("patinsheaderID").style.display="";
			parent.patinsframe.patInsForm.document.getElementById("patinsID").style.display="";
			parent.patinsbuttonframe.document.getElementById("addID").style.display="";
			var procInsCount=parent.patinsframe.document.patInsForm.procInsCount.value;
			if(procInsCount> 0){
				parent.patinsframe.patInsForm.document.getElementById("procinsID").style.visibility="hidden";
				parent.patinsframe.patInsForm.document.getElementById("procinsID").style.display="none";
			}
		}else{
			//for view details
			parent.patinsresultframe.patInsForm.document.getElementById("patinsID").style.visibility="visible";
			parent.patinsresultframe.patInsForm.document.getElementById("patinsheaderID").style.display="";
			parent.patinsresultframe.patInsForm.document.getElementById("patinsID").style.display=""; 
		}
	}else if(TabName=='procInsTab'){
		if(parent.patinsframe){
			var procInsCount=parent.patinsframe.document.patInsForm.procInsCount.value;
			var orderInsStandardYN=parent.patinsframe.document.patInsForm.orderInsStandardYN.value;
			var patient_id=parent.patinsframe.document.patInsForm.patient_id.value;
			if(procInsCount> 0){
				parent.patinsframe.document.patInsForm.procinsID.style.display="inline";
				parent.patinsframe.document.patInsForm.procinsID.style.visibility="visible";
				parent.patinsbuttonframe.document.getElementById("addID").style.display="none";
				parent.patinsframe.document.patInsForm.patinsID.style.display="none";
			}else{
				parent.patinsframe.document.patInsForm.patinsheaderID.style.display="none";
				parent.patinsframe.document.patInsForm.patinsID.style.display="none";
				parent.patinsbuttonframe.document.getElementById("addID").style.display="none";
				
				// Modified against PMG20089-CRF-0885.3
				var rd_appt_yn = parent.patinstabframe.document.patInsTabForm.rd_appt_yn.value;
				//if(orderInsStandardYN=="N" && patient_id==""){
				if( ( (("Y" == rd_appt_yn) && (patient_id != "")) || (rd_appt_yn == "N") ) && (orderInsStandardYN=="N" && patient_id=="") )
				{
					alert(getMessage("PRC_INS_WITHOUT_PATIENTID","OA"));
				}else if(orderInsStandardYN=="N"){
					alert(getMessage("PRC_INSTRUCTIONS_NOT_AVAILABLE","OA"));
				}
				ChangeTabs('patInsTab');
				
			}
			/*if(parent.patinsframe.document.patInsForm.orderInsYN.value=="Y" && parent.patinsframe.document.patInsForm.orderInsStandardYN.value=="Y"){
				alert('standard Ins');
			}else{
				alert('age specific');
			}*/
		}else{
			//for view details
		}		
	}
}
function closeWindow(obj){
	var from_page=parent.patinsframe.document.patInsForm.from_page.value;
	if(from_page!="view_dtls"){//for book Appointment or transfer Appointment
		var recCount=parent.patinsframe.document.patInsForm.recCount.value;
		var clinicInsYN=parent.patinsframe.document.patInsForm.clinicInsYN.value;
		var orderInsYN=parent.patinsframe.document.patInsForm.orderInsYN.value;
		var clinicInsFlag=true;
		var checkedString="somestring";
		var loopValue=0;
		var instructionId="";
		var instructionDesc="";	
		var idvalue="id";
		var xmlDoc= "";
		var xmlHttp=new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		if(clinicInsYN=="Y"){
			for(var i=1;i<recCount;i++){
				var checkedYN="N";
				/*if(clinicInsFlag){
					clinicInsFlag=checkMaxLimit(eval("parent.patinsframe.document.patInsForm.descriptionID"+i),200);
				}*/
				if(eval("parent.patinsframe.document.patInsForm.check_BoxID"+i).checked){
					checkedYN="Y";
				}
				instructionId=eval("parent.patinsframe.document.patInsForm.instructionID_"+i).value;
				description = trimString(eval("parent.patinsframe.document.patInsForm.descriptionID"+i).value);
				if(description==""){
					description="*!*";
				}
				display_order = eval("parent.patinsframe.document.patInsForm.display_orderID_"+i).value;
				var idvalue1=idvalue+i;
				xmlStr +=idvalue1+"=\""+instructionId+"|~"+encodeURIComponent(description)+"|~"+ display_order+"|~"+checkedYN+"\" " ;
				//alert("idvalue1==>"+idvalue1);
				//alert("instructionId==>"+instructionId);
				//alert("description==>"+description);
				/*above line Commented by Senthil on 19-Oct-2011*/
			//xmlStr +=idvalue1+"=\""+instructionId+"==>"+encodeURIComponent(description)+"==>"+ display_order+"==>"+checkedYN+"\" " ;	
			}
		}
		/*if(clinicInsFlag!=undefined && clinicInsFlag=false){
			alert('one/more clinic instructions exceded the max 200 characters limit.');
		}*/
		xmlStr += "recCount=\""+recCount+"\" ";
		if(parent.patinsframe.document.patInsForm.procInsCount.value >0){
			if(parent.patinsframe.document.patInsForm.procCheck.checked){
				xmlStr += "prcInschecked=\"Y\" ";
			}else{
				xmlStr += "prcInschecked=\"N\" ";
			}
			/*var procFlag=checkMaxLimit(parent.patinsframe.document.patInsForm.or_standard_ins,'2000');
			if(procFlag==undefined){
			}else{
				alert('Procedure instructions exceded the max 2000 characters limit.');
			}*/
			
			//xmlStr += "prcIns=\""+parent.patinsframe.document.patInsForm.or_standard_ins.value+"\" ";
			xmlStr += "prcIns=\""+encodeURIComponent(trimString(parent.patinsframe.document.patInsForm.or_standard_ins.value))+"\" "; //modified by  munisekhar for [IN:044555]
	
		}
		xmlStr += "patient_id=\""+parent.patinsframe.document.patInsForm.patient_id.value+"\" ";
		//xmlStr += "clinicInsYN=\""+clinicInsYN+"\" ";
		//xmlStr += "orderInsYN=\""+orderInsYN+"\" ";
		xmlStr+="steps=\"inst_add_session\"";
		xmlStr +=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false );
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if(obj==1 && responseText==2){
			//window.close();
			toCloseTopShowModal();
		}
	}else{//View instrucitons close wiondow
		//window.close();
		toCloseTopShowModal();
	}
}
async function addInstruction(){
	var recCount=parent.patinsframe.document.patInsForm.recCount.value;
	var clinicInsYN=parent.patinsframe.document.patInsForm.clinicInsYN.value;
	var orderInsYN=parent.patinsframe.document.patInsForm.orderInsYN.value;
	var orderInsStandardYN=parent.patinsframe.document.patInsForm.orderInsStandardYN.value;
	var from_page=parent.patinsframe.document.patInsForm.from_page.value;
	var or_catalogue_code=parent.patinsframe.document.patInsForm.or_catalogue_code.value;
	var pending_order_catalog_code=parent.patinsframe.document.patInsForm.pending_order_catalog_code.value;
	var order_id=parent.patinsframe.document.patInsForm.order_id.value;
	var order_line_num=parent.patinsframe.document.patInsForm.order_line_num.value;
	if(recCount<=20){
		closeWindow("2");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("eAM.InstructionDescript.label","AM");
		var clinic_code=parent.patinsframe.document.patInsForm.clinic_code.value;
		var locale=parent.patinsframe.document.patInsForm.locale.value;
		var facilityId=parent.patinsframe.document.patInsForm.facilityId.value;
		var patient_id=parent.patinsframe.document.patInsForm.patient_id.value;
		var retVal				=  new String();
		//var sql = "SELECT  distinct(a.instruction_id) code, a.instruction_desc description    FROM am_pat_instructions_lang_vw a,OP_CLINIC_PAT_INSTRUCTIONS b   WHERE a.eff_status = 'E' AND UPPER (a.instruction_id) LIKE UPPER (?)  AND UPPER (a.instruction_desc) LIKE UPPER (?) AND a.LANGUAGE_ID ='"+locale+"' AND A.INSTRUCTION_ID = B.INSTRUCTION_ID AND b.CLINIC_CODE != '"+clinic_code+"' ORDER BY 2";	
		var sql = "SELECT a.instruction_id code, a.instruction_desc description  FROM am_pat_instructions_lang_vw a  WHERE a.eff_status = 'E'  AND a.language_id = '"+locale+"' AND (INSTRUCTION_ID) NOT IN (SELECT  INSTRUCTION_ID FROM op_clinic_pat_instructions WHERE facility_id = '"+facilityId+"' AND clinic_code = '"+clinic_code+"' ) and upper(a.instruction_id) like upper(?) and upper(a.instruction_desc) like upper(?) ORDER BY 2";	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = "";
		argumentArray[6] = CODE_LINK  ;
		argumentArray[7] = CODE_DESC ;
		retVal = await CommonLookup( tit, argumentArray );	
		var arr=new Array();
		if(retVal != null && retVal != "" ){
			 var retVal=unescape(retVal);
			 var insFlag=true;;
			 arr=retVal.split(",");				 
		    var instructions = "";
		
			if(arr.length >2){  
				for(var i=1;i<arr.length;i++){					 
					 if(i>1)instructions = instructions + ",";
					 instructions = instructions + arr[i];
				 }
				 if(instructions != "")
				   arr[1]= instructions;
			}
		
			for(var i=1;i<recCount;i++){
				var instructionId=eval("parent.patinsframe.document.patInsForm.instructionID_"+i).value;
				if(instructionId==arr[0]){
					insFlag=false;
				}
			}
			if(insFlag){				
				parent.patinsframe.location.href="../../eOA/jsp/OAPatientInstructions.jsp?addInstructionYN=Y&clinic_code="+clinic_code+"&addCode="+arr[0]+"&addDesc="+encodeURIComponent(arr[1])+"&patient_id="+patient_id+"&clinicInsYN="+clinicInsYN+"&orderInsYN="+orderInsYN+"&orderInsStandardYN="+orderInsStandardYN+"&from_page="+from_page+"&or_catalogue_code="+or_catalogue_code+"&pending_order_catalog_code="+pending_order_catalog_code+"&=order_id"+order_id+"&order_line_num="+order_line_num;
			}else{
				alert(getMessage("CODE_ALREADY_EXISTS","Common"));
			}
		}else{
		}
	}else{
		var msg=getMessage("MAX_INSTRUCTIONS","OA");
		alert(msg.replace("$","20"));
	}
}
//added by  munisekhar for[IN:044555]
function Allow(event){
		var strCheck ='|'
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return true;  
		return false ;
	}
	
function RemoveSpec(){
var recCount=parent.patinsframe.document.patInsForm.recCount.value;
for(var i=1;i<recCount;i++){
var str=document.getElementById("descriptionID"+i).value;
str=str.replace(/[|]/g,"");
document.getElementById("descriptionID"+i).value=str;
} 
}

function maxLengthPaste(field,maxChars)
{    event.returnValue=false;
     if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);  
	    return false;
     }
     event.returnValue=true; 
}
//End  of [IN:044555]
function checkMaxLimit1(obj,maxSize) {
        if ( obj.value.length >= maxSize )
        {
            event.returnValue = false;
        }
    }
