
function loadBucNumsystem(){
	var formObj=document.forms[0];
	var perio_arch=formObj.perio_arch.value;
	var tns=formObj.tns.value;
	var objj="";
	if(tns=="UNI"){
		if(perio_arch=="U"){
			document.getElementById("fdibuc").style.display='inline';	
		}else{
			document.getElementById("fdilin").style.display='inline';	
			document.getElementById("BucNumber1").style.display='inline';	
			document.getElementById("BucNumber2").style.display='inline';	
		}
	}else if(tns=="FDI"){
		if(perio_arch=="U"){
			document.getElementById("unibuc").style.display='inline';	
		}else{
			document.getElementById("unilin").style.display='inline';	
			document.getElementById("BucNumber1").style.display='inline';	
			document.getElementById("BucNumber2").style.display='inline';	
		} 
	}

}


function loadLinNumsystem(){
	var formObj=document.forms[0];
	var perio_arch=formObj.perio_arch.value;
	var tns=formObj.tns.value;
	var objj="";
	if(tns=="UNI"){
		if(perio_arch=="U"){
			document.getElementById("fdibuc").style.display='inline';	
		}else{
			document.getElementById("fdilin").style.display='inline';	
			document.getElementById("LinNumber1").style.display='inline';	
			document.getElementById("LinNumber2").style.display='inline';	
			
		}
	}else if(tns=="FDI"){
		if(perio_arch=="U"){
			document.getElementById("unibuc").style.display='inline';	
		}else{
			document.getElementById("unilin").style.display='inline';	
			document.getElementById("LinNumber1").style.display='inline';	
			document.getElementById("LinNumber2").style.display='inline';	

		}
	}

}


function checkMissingTooth(){
	loadGraphNames()
	var formObj=document.forms[0];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var patient_id=formObj.patient_id.value;
	var perio_arch=formObj.perio_arch.value;
	var chart_code=formObj.chart_code1.value;
	var chart_num=formObj.chart_num.value;
	var chart_line_num=formObj.chart_line_num.value;
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=MissingToothCheck&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr=retVal.split("##");
	var min="";
	var max="";
	if(perio_arch=="U"){
		min=1;
		max=16;
	}else if(perio_arch=="L"){
		min=17;
		max=32;
	}
		for(j=0;j<=arr.length;j++){
			for(i=max;i>=min;i--){
			//for(i=max;i<=min;i++){
				if(arr[j]==i){
					var objj=document.getElementById("img" + i);
					objj.style.display='inline';
				}else{
					//document.getElementById("i").style.display='None'
				}
			}
		}
}

function loadGraphNames(){
	var formObj=document.forms[0];
	var sel_radio_val=formObj.sel_radio_val.value;
	if(sel_radio_val=="PD"){
		document.getElementById("PDGraph").style.display='inline';	
	}else if(sel_radio_val=="CAL"){
		document.getElementById("CALGraph").style.display='inline';	
	}else if(sel_radio_val=="CEJ"){
		document.getElementById("CEJGraph").style.display='inline';	
	}
}
