/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
11/04/2019		ML-MMOH-CRF-1064	Kamalakannan G		11/04/2019		Ramesh Goli		IN066304
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			

---------------------------------------------------------------------------------------------------------------
*/

async function callPatientSearch()
{
	var pat_id = await PatientSearch();
	if(pat_id != null)
		document.getElementById("patient_id").value = pat_id;
}

async function showCalendarValidate(str)
{
	var flg = await showCalendar(str);
	//document.getElementById(str).focus();
	document.getElementById(str).focus();
	return flg;
}
function chkDateTime(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("p_date_from");
		var to_date = document.getElementById("p_date_to");
	
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
				//from.select();
				from.value="";
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
						//	to.select();
							to.value="";
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						//to.select();
						to.value="";
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
					//to.select();
					to.value="";
					to.focus();
					return false;
				}
			}
		}
}
function submitPage(){
		var patient_id	= CAPrintingEmrCriteriaForm.patient_id.value;
		var date_from 	= CAPrintingEmrCriteriaForm.p_date_from.value;
		var date_to   	= CAPrintingEmrCriteriaForm.p_date_to.value;
		var facility_id   	= CAPrintingEmrCriteriaForm.facility_id.value;
		var language_id   	= CAPrintingEmrCriteriaForm.language_id.value;
		var clinicianId   	= CAPrintingEmrCriteriaForm.clinicianId.value;//32902
		if(date_from=="")
		{
			var msg =getMessage("CAN_NOT_BE_BLANK","common");
			msg = msg.replace("$","From Date");	
			alert(msg);
			CAPrintingEmrCriteriaForm.p_date_from.focus();
			return;
		}
		if(date_to=="")
		{
			var msg =getMessage("CAN_NOT_BE_BLANK","common");
			msg = msg.replace("$","To Date");
			alert(msg);
			CAPrintingEmrCriteriaForm.p_date_to.focus();
			return;
		}
		 //start. 32902
		 var xmlStr ="<root><SEARCH ";
		 xmlStr += " p_action=\"IS_PAT_RESTRICTED\"";
		 xmlStr += " facility_id=\""+ facility_id + "\" ";
		 xmlStr += " patient_id=\""+ patient_id + "\" ";
		 xmlStr += " clinicianId=\""+ clinicianId + "\" ";
		 xmlStr +=" /></root>";
		 var temp_jsp="../../eCA/jsp/CAPrintingEmrPatientIntermediate.jsp";
		 var xmlDoc = "" ;
		 var xmlHttp = new XMLHttpRequest() ;
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		 xmlHttp.open("POST",temp_jsp,false);
		 xmlHttp.send(xmlDoc);
		 var responseText = xmlHttp.responseText;
		 var response = trimString(xmlHttp.responseText);
		 //end 32902.
		 //var params = '?date_from='+date_from+'&date_to='+date_to+'&patientId='+patient_id+'&facility_id='+facility_id+'&language_id='+language_id+'&flag=N'; //32902
		 var params = '?date_from='+date_from+'&date_to='+date_to+'&patientId='+patient_id+'&facility_id='+facility_id+'&language_id='+language_id+'&respAccess='+response+'&flag=N'; //32902
		parent.CAPrintingEmrPatientResult.location.href = '../../eCA/jsp/CAPrintingEmrPatientResult.jsp'+params;
		parent.CAPrintingEmrPatientSubRes.location.href = "../../eCommon/html/blank.html";
}
var clntArr = [];
var eventArr = [];
function displayToolTip1(orderctlHDR,imgObj,hist_type,eventList)
{
		var xmlStr ="<root><SEARCH ";
		xmlStr += " p_action=\"CLNT_CHILD_CHK\"";
		xmlStr += " hist_type=\""+ hist_type + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CAPrintingEmrPatientIntermediate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var clnt = responseText.replace("[","");
		clnt = clnt.replace("]","");
		eventArr = clnt.split(",");
		var rowArr = [];
		var keyArr = [];
		for(var index=0; index<eventArr.length; index++){
			var subString = eventArr[index].split("#");
			keyArr[index]=subString[0];
			rowArr[index]=subString[1];
		}
		var row = "";
		var rowKey = "";
		var flags = [];
		  for(var i=0;i<keyArr.length;i++){
			  if(i==0){
				  rowKey =rowKey+keyArr[i];
			  }else{
				  rowKey = rowKey+","+keyArr[i];
			  }
			  
		  }
		  for(var i=0;i<rowArr.length;i++){
			  rowArr[i] = rowArr[i].replace(/(\r\n|\n|\r)/gm,"");
			  var flagSubString = rowArr[i].split("%");
			  flags[i] = flagSubString[1];
			  if(i==0){
				  row =row+flagSubString[0];
			  }else{
				  row = row+","+flagSubString[0];
			  }
		  }
		row = row.replace(/(\r\n|\n|\r)/gm,"");
		rowKey = rowKey.replace(/(\r\n|\n|\r)/gm,"");
		rowval1      = row.split(",");
		rowKey1		 = rowKey.split(",");
		buildTable1 (row,rowKey,flags,eventList);
		resizeWindow(orderctlHDR,imgObj);
}

function buildTable1(row,rowKey,flags,eventList) {
	
	rowval1      = row.split(",");
	var rowkey1	 = rowKey.split(",")
	var checked_yn =[];
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' border='2'width='100%' align='center'>"
	for(var j=0;j<flags.length;j++){
		if(flags[j]=="Y"){
			checked_yn[j] = "checked"
		}else{
			checked_yn[j] = ""
		}		
	}
	
	for( var i=0; i<rowval1.length; i++ ) 
	{
		var colval  = rowval1[i];
		var visibility = "none";
		var applicableEvent = eventList.split(",");
		var eventKeys = rowkey1[i].split("_");
		for(var j=0; j<applicableEvent.length; j++){
			if(eventKeys[1]==applicableEvent[j]){
				visibility="block"
			}
		}
		
		if (colval != "" )
		{
			tab_dat     += "<tr style='display:"+visibility+"'>";
			tab_dat     += "<td class = 'contextMenuItem' nowrap onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>"+rowval1[i]+"</td><td><input type='checkbox' name='"+rowkey1[i]+"' id='"+rowkey1[i]+"' value='"+flags+"' "+checked_yn[i]+" onClick='childchk(this)'>  </td>"; //IN061961
			tab_dat     += "</tr> ";
		}
	}
		tab_dat     += "</table> "
	document.getElementById('t').innerHTML = tab_dat;
		if(applicableEvent.length<=6){
			document.getElementById("t").style.overflowY='hidden';
		}else{
			
			document.getElementById("t").style.overflowY='scroll';
		}
}
function childchk(obj){
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var date_from = document.forms[0].date_from.value;
	var date_to = document.forms[0].date_to.value;
	var hiddenVal = obj.name
	if(obj.checked){
		eval("CAPrintingEmrPatientSubRes."+hiddenVal).value = 'Y';
	}
	else{
		eval("CAPrintingEmrPatientSubRes."+hiddenVal).value = 'N';
	}
	var key = eval("CAPrintingEmrPatientSubRes."+hiddenVal).value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_action=\"CLNT_CHILD_INNER_CHK\"";
	xmlStr += " patient_id=\""+patient_id+"\"";
	xmlStr += " encounter_id=\""+encounter_id+"\"";
	xmlStr += " date_from=\""+date_from+"\"";
	xmlStr += " date_to=\""+date_to+"\"";
	xmlStr += " hist_type=\""+hiddenVal+"\"";
	xmlStr += " key=\""+key+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CAPrintingEmrPatientIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText)
}
function resizeWindow(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;
	var wdth = document.getElementById(orderctlHDR1).offsetWidth;
	var hght1 = document.getElementById(orderctlHDR1).offsetHeight;		
	
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
	}

	document.getElementById("tooltiplayer").style.posLeft= x+"px";
	document.getElementById("tooltiplayer").style.posTop = y+"px";
	document.getElementById("tooltiplayer").style.visibility='visible'
}
function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        return coords;
    }
}
function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}

function hideToolTip(obj,imgObj,row)	
{
	dynamichide(obj, window.event,row);
}

function dynamichide(m, e,row)
{
	if (!this.isContained(m, e))
	{
		this.delayhidemenu(row)
	}
}

function isContained(m, e)
{

	var e=window.event || e
	var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
	while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
	if (c==m)
		return true
	else
		return false
}

function delayhidemenu(row)
{

	this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
	if(document.getElementById('orderctl'+row))
		document.getElementById('orderctl'+row).className='gridDataBlue';
	if(document.getElementById('imgArrow'+row))
		document.getElementById('imgArrow'+row).src = "../../eCommon/images/inactiveArrow.gif";
}
function clntParentCheckBox(obj,eventList,patient_id,encounter_id,date_from,date_to){
	var key = obj.name
	var flag = "N";
	if(obj.checked){
		flag = "Y";
	}
	
	//document.CAPrintingEmrPatientSubRes.select_all.checked = checkParent;
	
	obj.value = flag;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " p_action=\"PARENT_CHK\"";
		xmlStr += " key=\""+key+"\"";
		xmlStr += " flag=\""+flag+"\"";
		xmlStr += " eventList=\""+eventList+"\"";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " date_from=\""+date_from+"\"";
		xmlStr += " date_to=\""+date_to+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CAPrintingEmrPatientIntermediate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var clnt = responseText.replace("{","");
		clnt = clnt.replace("}","");
		clntArr = clnt.split(",");
		//return true;
		validateParentCheck();
}
function validateParentCheck(){
	//PARENT CHECKBOX VALIDATE BASED ON SELECT ALL
	var count = 0;
	var histRecTypes = document.CAPrintingEmrPatientSubRes.app_hist_types.value;
	var histRecArr = histRecTypes.split("_"); 
	for(var i =0; i<histRecArr.length; i++){
		if(eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").checked = true && eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").value == "Y"){
			count++;
		}
	}
	if(count==(histRecArr.length)){
		document.CAPrintingEmrPatientSubRes.select_all.checked = true;
		document.CAPrintingEmrPatientSubRes.select_all.value = "Y";
	}else{
		document.CAPrintingEmrPatientSubRes.select_all.checked = false;
		document.CAPrintingEmrPatientSubRes.select_all.value = "N";
	}
}
function chkRadiobutton(obj,date_from,date_to){
	var patient_id = obj.name;
	var encounter_id = obj.value;
	var params = '?patient_id='+patient_id+'&encounter_id='+encounter_id+'&date_from='+date_from+'&date_to='+date_to;
	parent.CAPrintingEmrPatientSubRes.location.href = '../../eCA/jsp/CAPrintingEmrPatientSubRes.jsp'+params;
}

function changeCheckBox(str,hist_rec,parentChkFlag){
	//alert(parentChkFlag)
	if(str == "Y"){
		eval("document.CAPrintingEmrPatientSubRes."+hist_rec+"_yn").checked = true
		eval("document.CAPrintingEmrPatientSubRes."+hist_rec+"_yn").value = "Y"
	}else if(str == "N"){
		eval("document.CAPrintingEmrPatientSubRes."+hist_rec+"_yn").checked = false
		eval("document.CAPrintingEmrPatientSubRes."+hist_rec+"_yn").value = "N"
	}
	if(parentChkFlag == "Y"){
		document.CAPrintingEmrPatientSubRes.select_all.checked = true;
		document.CAPrintingEmrPatientSubRes.select_all.value = "Y";
	}else{
		document.CAPrintingEmrPatientSubRes.select_all.checked = false;
		document.CAPrintingEmrPatientSubRes.select_all.value = "N";
	}
}

async function valsForPrint(navigator){
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_action=\"PRINTING_FINAL_LIST\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CAPrintingEmrPatientIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].encounter_id.value;
	var called_from = "";
	var dialogTop	= "60";
	var dialogHeight= "34" ;
	var dialogWidth	= "50" ;
	var arguments = "";
	var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"scrollbars=yes, resizable=yes,fullscreen=no;" ;
	var retVal = await window.open("../../eCA/jsp/EncountersPrint.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from="+called_from+"&action=PRINTING_PATIENT_WISE&navigator="+navigator,arguments,features);
}

function selectAll(obj,patient_id,encounter_id,date_from,date_to){
	var histRecTypes = document.CAPrintingEmrPatientSubRes.app_hist_types.value;
	var flag = "N";
	if(obj.checked == true){
		flag = "Y";
	}else{
		flag = "N";
	}
	validateHistTypeCheckbox(flag,histRecTypes);
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_action=\"SELECT_ALL\"";
	xmlStr += " flag=\""+flag+"\"";
	xmlStr += " patient_id=\""+patient_id+"\"";
	xmlStr += " encounter_id=\""+encounter_id+"\"";
	xmlStr += " date_from=\""+date_from+"\"";
	xmlStr += " date_to=\""+date_to+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CAPrintingEmrPatientIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
}
function validateHistTypeCheckbox(flag,histRecTypes){
	var histRecArr = histRecTypes.split("_"); 	
	for(var i =0; i<histRecArr.length; i++){
		if("Y"==flag){
			eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").checked = true
			eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").value = flag
		}else{
			eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").checked = false
			eval("document.CAPrintingEmrPatientSubRes."+histRecArr[i]+"_yn").value = flag
		}
	}
}

function clearAll(){
	parent.location.reload();
}

