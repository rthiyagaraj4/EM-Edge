<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Version     	Developer Name		Rev.Date		Rev.Name		SCF/CRF
-------------------------------------------------------------------------------------------------------------------------------------
17/06/2020 	  		         Ram kumar S									  AAKH-CRF-0122
15/10/2020 	 V201015	     Ram kumar S									  AAKH-SCF-0458
22/12/2020 	 V201222	     Ram kumar S									  AAKH-SCF-0479
29/09/2022                   Kamatchi S                                       TH-KW-CRF-0143
V230516						Mohanapriya										  AAKH-CRF-0153
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>

<%@ page contentType="text/html;charset=ISO-8859-1" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*,eCA.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
<html>
<head>
<%	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con	= null;//Modified by Kamatchi S for TH-KW-CRF-0143
	con = ConnectionManager.getConnection(request);//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	String siteSpecPatPayable=request.getParameter("siteSpecPatPayable");//V230222/AAKH-CRF-0172
	String siteSpecSearch=request.getParameter("siteSpecSearch");//V230222/AAKH-CRF-0153
	System.err.println("siteSpecPatPayable "+siteSpecPatPayable);
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--<link rel='stylesheet' type='text/css' href='../../eCommon/html/BLCoderServices.css'></link>-->
<link rel='stylesheet' type='text/css' href='../../eBL/images/BLCoderServices.css'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>	
<script language="javascript" src='../../eCommon/js/CommonCalendar.js'></script>
<script language ="javascript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language ="javascript" src ='../../eBL/js/cptLookup.js'></Script>
<script language="javascript">

//Global Declaration
var dataArr = [];
var addRowFlag;
var dupFlag;
var subFlag="Y";
//V201015 Starts
var visitAdmDatetime="";
var datetime="";
//V201015 Starts

//Function to find the Value is Numeric or Not
function isNo(e){
	if(!isNumber(e)){
		alert(getMessage('BL8532','BL'));
		document.getElementById(e.id).focus();
	}else{
		e.value = parseFloat(e.value).toFixed(2);
	}
}

// Function to get current date and Time
//V201015 Starts
function getCurrentDateTime()
{
	var currentdate = new Date(); 
	var minutes=currentdate.getMinutes();
	var month=("0" + (currentdate.getMonth() + 1)).slice(-2);
	if(minutes.length==1){
		minutes="0"+minutes;
	}
	datetime = currentdate.getDate() + "/"
			+  month  + "/" 
			+  currentdate.getFullYear()+ " "  
			+  currentdate.getHours() + ":"  
			+  minutes+ ":"
			+  currentdate.getSeconds();
			return datetime;
}
//V201015 Ends

//RRestricting alphabets in KeyPress
function restrictAlphabets(evt){
	var x = evt.which || evt.keyCode;
	if((x>47 && x<58) || x==46)
		return true;
	else
		return false;
}

//Is Number Function
function isNumber(n) {
	return !isNaN(parseFloat(n.value)) && isFinite(n.value);
}

//Date Format validation
function dateRegEx(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var pattern = new RegExp("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$");
	if (e.value.search(pattern)===0){
		return true;
	}
	else {
		alert("Please provide valid date in format dd/mm/yyyy hh:mm:ss, including leading zero. Exapmle: 01/02/2015 03:04:59");
		document.getElementById(e.id).focus();
		document.getElementById(e.id).value=getCurrentDateTime();	//V201015 Added
		return false; 
	} 
}

//Fucntion to Populate Service Type Description
function populateServTypeDesc(servCode,rIndex){
	if(servCode!="" && servCode!=null){
		var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?servCode="+servCode+"&CalledFor=servCode";
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var resText=xmlHttp.responseText;
		resText = trimString(resText);
		var nFin = resText.indexOf("~");
		var resFin = resText.substr(nFin+1);
		if(resFin=="" || resFin==null){
			alert("Error at server end..");
		}else{
			document.getElementById("serviceTypeDesc"+rIndex).value=resFin;
		}
	}
}

/*Three Column Look up Starts*/
function callCPTSearch(e)
{
	var formObj=document.BLCoderEditService;
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var servCodeVal=document.getElementById("serviceCode"+RowIndex).value;
	var cptCodeVal=document.getElementById("cptCode"+RowIndex).value;
	var serTypeInd=document.getElementById("servicetype"+RowIndex).value;
	var LangId=document.getElementById("locale").value;
	var Facility_Id=document.getElementById("FacilityId").value;
	if(formObj!=null){
		var argumentArray	= new Array();
		var dataNameArray	= new Array();
		var dataValueArray	= new Array();
		var dataTypeArray	= new Array();
		var target			= "";
		var sql				= ""; 
		//sql = "SELECT a.generic_id code, a.generic_name description, b.thirdparty_type thirdparty_type FROM ph_generic_name_lang_vw a, ph_generic_ext_prod_ref b WHERE a.generic_id = b.generic_id AND UPPER (a.generic_id) LIKE UPPER (?) AND UPPER (LTRIM (a.generic_name, '*')) LIKE UPPER (?) AND UPPER (b.thirdparty_type) LIKE UPPER (?) AND a.eff_status = 'E' AND b.eff_status = 'E' AND b.product_id = 'CIMS' AND a.language_id = '"+locale+"'";
		sql="SELECT cpt_code cptcode, service_code code, service_desc description FROM BL_CODER_CONV_CPT_SERV_CODE_VW where service_type='"+serTypeInd+"' AND UPPER (cpt_code) LIKE UPPER (?) AND UPPER (service_desc) LIKE UPPER (?) AND UPPER (service_code) LIKE UPPER (?)";
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = cptCodeVal;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC; 	
		var retVal = cptLookup("CPT Code", argumentArray);
		var arr = retVal.split("\"");
		if (retVal != null && retVal != '' && retVal != "null"){
			//To remove duplications While selecting in LOV
			document.getElementById("cptCode"+RowIndex).value=arr[0];
			document.getElementById("serviceCode"+RowIndex).value=arr[1];
			validateCPTCode(e);
		}
		else{
			document.getElementById("cptCode"+RowIndex).value="";
			document.getElementById("serviceCode"+RowIndex).value="";
			document.getElementById("serviceDesc"+RowIndex).value="";
			document.getElementById("ServPrice"+RowIndex).value="";
			document.getElementById("InsAmt"+RowIndex).value="";
			document.getElementById("serviceQty"+RowIndex).value="1";
		}
	}
}

//Validate CPT code
function validateCPTCode(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	if(e.value!="" && e.value!=null){
		var cptCode=document.getElementById("cptCode"+RowIndex).value;
		var servCode=document.getElementById("serviceCode"+RowIndex).value;
		var FacilityId = document.getElementById('FacilityId').value;
		var LangId=document.getElementById("locale").value;
		var serTypeInd=document.getElementById("servicetype"+RowIndex).value;
		var loginUser = document.getElementById('logInUserId').value;
		var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?servCode="+servCode+"&cptCode="+cptCode+"&CalledFor=cptCode&FacilityId="+FacilityId+"&LangId="+LangId+"&loginUser="+loginUser+"&serTypeInd="+serTypeInd;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var responseText=xmlHttp.responseText;
		if(responseText != null && responseText != ""){
			var n = responseText.indexOf("~");
			var res = responseText.substr(n+1);
			res = res.split("~");
			if(res[0]=="S"){
				document.getElementById("serviceCode"+RowIndex).value=res[1];
				document.getElementById("serviceDesc"+RowIndex).value=res[2];
				document.getElementById("serviceDesc"+RowIndex).title=res[2];//V230516-aakh-crf-0153
				validateServCode(e);
				var servType=document.getElementById('servicetype'+RowIndex).value;
				if(servType=="S")
					populateServTypeDesc(res[1],RowIndex);
			}else if(res[0]=="E"){	
				document.getElementById("cptCode"+RowIndex).value="";		 
				document.getElementById("serviceCode"+RowIndex).value="";
				document.getElementById("serviceDesc"+RowIndex).value="";
				document.getElementById("serviceDesc"+RowIndex).title="";//V230516-aakh-crf-0153
				document.getElementById("ServPrice"+RowIndex).value="";
				document.getElementById("InsAmt"+RowIndex).value="";
				document.getElementById("serviceQty"+RowIndex).value="1";
				alert(res[1]);
			}
			else{
				callCPTSearch(e);
			}
		}
	}else{
		for(var g=0;g<dupArr.length;g++){
			var m = dupArr[i].split("~");
			if(RowIndex==m[1]){
				dupArr.splice(g, 1);
			}
		}
		document.getElementById("cptCode"+RowIndex).value="";		 
		document.getElementById("serviceCode"+RowIndex).value="";
		document.getElementById("serviceTypeDesc"+RowIndex).value="";
		document.getElementById("serviceDesc"+RowIndex).value="";
		document.getElementById("serviceDesc"+RowIndex).title="";//V230516-aakh-crf-0153
		document.getElementById("ServPrice"+RowIndex).value="";
		document.getElementById("InsAmt"+RowIndex).value="";
		document.getElementById("serviceQty"+RowIndex).value="1";
	}
}

//Function to save Update flag
function billClick(e){
	var table = document.getElementById('serviceTable1');
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var addFlag=document.getElementById('serviceAddRow'+RowIndex).value;
	var canFlag=document.getElementById('serviceCancelRow'+RowIndex).value;
	var chkbox = table.rows[RowIndex].cells[14].getElementsByTagName('input')[0];
	var serviceModFlag=document.getElementById("serviceModAppNo"+RowIndex).value;
	var episodeFlag=document.getElementById('EpisodeType').value;
	if(episodeFlag=="I" || episodeFlag=="D"){
		alert(getMessage('BL9763','BL'));
		document.getElementById(e.id).checked = true;
	}else{
	if(canFlag!="Y" && addFlag!="Y"){
		//if(false == chkbox.checked && serviceModFlag!='Y'){
		if((false == chkbox.checked || true == chkbox.checked) && serviceModFlag!='Y'){ // Modifiied for AAKH-SCF-0506 BY PALANI NARAYANAN
			document.getElementById("modifyYN"+RowIndex).value="Y";
		}
	}
	}
}

function performClinicianBlur(e){
	//Validation
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var addFlag=document.getElementById('serviceAddRow'+RowIndex).value;
	var canFlag=document.getElementById('serviceCancelRow'+RowIndex).value;
	var serviceModFlag=document.getElementById("serviceModAppNo"+RowIndex).value;
	if(canFlag!="Y" && addFlag!="Y" && serviceModFlag!='Y'){
		document.getElementById("modifyYN"+RowIndex).value="Y";
	}
	else{
		document.getElementById("modifyYN"+RowIndex).value="N";
	}
}

//Function to save Update flag
function ModAppNo(e){
	//Validation
	var chngVal=e.value;
	var lastVal=document.getElementById(e.id).defaultValue;
	if(chngVal!=lastVal){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var addFlag=document.getElementById('serviceAddRow'+RowIndex).value;
	var canFlag=document.getElementById('serviceCancelRow'+RowIndex).value;
		if(canFlag!="Y" && addFlag!="Y"){
			document.getElementById("serviceModAppNo"+RowIndex).value="Y";
		}
		else{
			document.getElementById("serviceModAppNo"+RowIndex).value="N";
		}
		if(e.id=="ApproveDate"+RowIndex){
			if(e.value!=null && e.value!=""){
				if(dateRegEx(e)){
				//Future Date validation JS
				// function checkDate() {
				var selectedText = e.value;
				var selectedDate = new Date(selectedText);
				var now = new Date(getCurrentDateTime());//V201015 Modified
				if (selectedDate > now) {
					alert("Date cannot be greater than the System date");
					document.getElementById('ApproveDate'+RowIndex).value=getCurrentDateTime();	//V201015 Modified
				}				
				}
			}else{
				if(addFlag!="Y"){
					document.getElementById('ApproveDate'+RowIndex).value=document.getElementById('appDateHid'+RowIndex).value;
				}else{
					document.getElementById('ApproveDate'+RowIndex).value=getCurrentDateTime();//V201015 Modified
				}
			}
		}else if(e.id=="ApproveNum"+RowIndex){
			if(e.value!=null && e.value!=""){
				var AppDateVal=document.getElementById('ApproveDate'+RowIndex).value;
				if(AppDateVal=="" || AppDateVal==null){
					document.getElementById('ApproveDate'+RowIndex).value=getCurrentDateTime();//V201015 Modified
				}						
			}else{
				if(addFlag!="Y"){
					document.getElementById('ApproveNum'+RowIndex).value=document.getElementById('appNoHid'+RowIndex).value;
				}else{
					document.getElementById('ApproveNum'+RowIndex).value="";
				}
			}
		}
	}
}

//Deleting Row against Cancel service Check box
function deleteRow() {
	try{
		var table = document.getElementById('serviceTable1');
		var rowCount = table.rows.length;
		for(var i=1; i<rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[16].childNodes[0];
			if(null != chkbox && true == chkbox.checked) {
				if(rowCount <= 1) {
					alert("Cannot delete all the rows.");
					break;
				}
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	}catch(e){
		alert(e);
	}
}

// function to get Date and Time From DB
//V201015 Starts
function getVisitAdmDate(){
	var ServEncounterId = document.getElementById("+ServEncounterId+").value;
	var PatientID = document.getElementById('PatientID').value;
	//Getting Visit Admission Date
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=visitAdmDate&ServEncounterId="+ServEncounterId+"&PatientID="+PatientID;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;		
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send("");
	var responseText=xmlHttp.responseText;
	if(responseText!="" && responseText!=null){
	var strtIndex = responseText.indexOf("~");
	if(strtIndex!=-1){
		var finDateTime = responseText.substr(strtIndex+1);
		return finDateTime;
	}
	}
}	
//V201015 Ends

function addRow1(x) {
	addRowFlag="Y";
	var orderclinicianID;
	var orderclinicianName;
	var RowIndex=x.parentNode.parentNode.rowIndex;
	var table = document.getElementById('serviceTable1');
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	row.setAttribute("id","serviceRow"+rowCount);
	row.onclick = function() {RowChange(this);}; // for IE
	var colCount = table.rows[RowIndex].cells.length;
	for(var i=0; i<colCount; i++) {
		var newcell	= row.insertCell(i);
		
			datetime = getCurrentDateTime();//V201015 Modified
			visitAdmDatetime = getCurrentDateTime();//V201015 Modified
		if(i==0){	
			visitAdmDatetime=getVisitAdmDate();//V201015 Modified
			newcell.innerHTML ="<input type='text' class='gridDataInputMore' onblur='validateDateTime(this)' name='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' value='"+visitAdmDatetime+"' size='19' maxlength='19'><img src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('serviceDate"+rowCount+"',null,'hh:mm:ss');\"><input type='hidden' id='servDateHid"+rowCount+"'value='"+visitAdmDatetime+"'>"; //V201222 Modified
			//newcell.className = 'gridData';
		}
		else if(i==1){
		newcell.innerHTML="<select name='servicetype"+rowCount+"' id='servicetype"+rowCount+"' id='servicetype"+rowCount+"' onchange='DrugTypeChange(this)'>"    
			+"<option value='Select' >-Select-</option>"
			+"<option value='S' selected>Service</option>"
			+"<option value='I' >Drug</option>"
			+" </select>";
		}
		else if(i==17){
		newcell.innerHTML ="<input type='checkbox' name='Cancelcheck"+rowCount+"' id='Cancelcheck"+rowCount+"'  id='Cancelcheck"+rowCount+"' onclick='CancelClick(this)' value='' /><input style='display:none;' type='text' id='serviceCancelRow"+rowCount+"' value='' ><input style='display:none;' type='text' id='primKeyModuleID"+rowCount+"' value='' >";
		}
		else if(i==15){
			newcell.innerHTML="<input type='checkbox' name='checkboxBill"+rowCount+"' id='checkboxBill"+rowCount+"' value='checked' id='checkboxBill"+rowCount+"'  onclick='billClick(this)' checked/><input style='display:none;' type='text' id='serviceBillCheck"+rowCount+"'>";
		}
		else if(i==16){
			newcell.innerHTML = "<input type='button' name='AddBTn"+rowCount+"' id='AddBTn"+rowCount+"'  value='+' onclick='addRow1(this)' id='AddBTn"+rowCount+"'><input style='display:none;' type='text' id='serviceAddRow"+rowCount+"' value='Y' >";
		}
		
		else if(i==10){
			 newcell.innerHTML = "<input type='checkbox' name='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' onclick='zeroPriceClick(this)' />";
			//newcell.className = 'gridData';
		}
		else if(i==8){
			 newcell.innerHTML = "<input type='text' class='gridDataInputLess' style='width: 50px;' onkeypress='return restrictAlphabets(event);' onblur='validateServQty(this)' id='serviceQty"+rowCount+"' name='serviceQty"+rowCount+"' id='serviceQty"+rowCount+"' ><input type='text'  style='display:none;' id='serviceRateCharge"+rowCount+"' value='' >";
			//newcell.className = 'gridData';
		}
		else if(i==3){
			newcell.innerHTML="<input type='text' class='gridDataInput' onblur='validateCPTCode(this)' name='cptCode"+rowCount+"' id='cptCode"+rowCount+"' id='cptCode"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='callCPTSearch(this)' name = 'servCodeLovButton'> ";
			//newcell.className = 'gridData';
		}
		else if(i==4){
			newcell.innerHTML="<input class='gridDataInputMore' type='text' name='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' readonly>"; //V201222 Modified
		}
		else if(i==5){
			newcell.innerHTML="<input type='text' class='gridDataInput' onblur='validateServCode(this)' name='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' contenteditable> ";
			//newcell.className = 'gridData';
		}
		else if(i==6){
			//Getting Ordering Clinician
			var FacilityId = document.getElementById('FacilityId').value;
			var EncounterId = document.getElementById("+ServEncounterId+").value;
			var PatientID = document.getElementById('PatientID').value;
			var EpisodeId = document.getElementById('EpisodeId').value;
			var EpisodeType = document.getElementById('EpisodeType').value;
			var VisitID = document.getElementById('VisitID').value;
			var LangId=document.getElementById("locale").value;
			var params="&FacilityId="+FacilityId+"&EpisodeType="+EpisodeType+"&EncounterId="+EncounterId+"&VisitID="+VisitID+"&LangId="+LangId;
			var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician"+params;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;		
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send("");
			var responseText=xmlHttp.responseText;
			if(responseText!="" && responseText!=null){
			var strtIndex = responseText.indexOf("~");
			if(strtIndex!=-1){
				var res1 = responseText.substr(strtIndex+1);
				var res = res1.split("~");
				orderclinicianID = res[0];
				orderclinicianName=res[1];
			}else{
				orderclinicianID = "";
				orderclinicianName="";
			}
			}					
			newcell.innerHTML="<input type='text' class='gridDataInput' name='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='orderingClinicianLookUp(this)' name = 'OrderLovButton'><input style='display:none;' type='text' id='orderClinicID"+rowCount+"' value='' > ";
		}
		else if(i==7){
			newcell.innerHTML="<input type='text' class='gridDataInput' name='performClinic"+rowCount+"' id='performClinic"+rowCount+"' id='performClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='performingClinicianLookUp(this)'  id='PerformLovButton' name='PerformLovButton' id='PerformLovButton'><input style='display:none;' type='text' id='performClinicID"+rowCount+"' value=''><input style='display:none;' type='text' id='modifyYN"+rowCount+"' value='N' >";
		}
		else if(i==12){
			newcell.innerHTML="<input class='gridDataInput' style='width: 75px;' type='text' name='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' onblur='ModAppNo(this)' value='"+datetime+"' size='19' maxlength='19' ><img id='AppDateImg"+rowCount+"' src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('ApproveDate"+rowCount+"',null,'hh:mm:ss');\">";//V201222 Modified
		}
		else if(i==13){
			newcell.innerHTML="<input class='gridDataInput' type='text' name='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' onblur='isNo(this)' onkeypress='return restrictAlphabets(event);' value='' >";
		}
		else if(i==14){
			newcell.innerHTML="<input class='gridDataInput' type='text' name='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"' value='' disabled>";
		}
		else if(i==11){
			newcell.innerHTML="<input class='gridDataInput' type='text' name='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' maxlength='20' value='' ><input style='display:none;' type='text' id='serviceModAppNo"+rowCount+"' value='N' >";
		}
		else if(i>=18){
			newcell.innerHTML ="<input type='text' style='display:none;' hidden>";
			newcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style 
			//newcell.className = 'hideCol';
		}else if(i==9){
			newcell.innerHTML ="<input type='text' class='gridDataInputLess' maxlength='30' contenteditable>";
		}
		else if(i==2){
			newcell.innerHTML="<input class='gridDataInputLess' type='text' maxlength='100' name='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' value=\"\" ><input type='text' style='display:none;' id='preAppFlagID"+rowCount+"' value=\"N\" hidden>";
		}
		else{
			var classname;
			if(i==2){
				classname="gridDataInputLess";
				
			}else{
				classname="gridDataInput";
			}
			newcell.innerHTML ="<input type='text' class='"+classname+"'  contenteditable>";
		}
		
		switch(newcell.childNodes[0].type) {
			case "text":
					newcell.childNodes[0].value = "";
					if(i==8){
						newcell.childNodes[0].value = "1";
					}
					if(i==12){
						newcell.childNodes[0].value = getCurrentDateTime();//V201015 Modified
					}
					if(i==0){
						newcell.childNodes[0].value = visitAdmDatetime;
					document.getElementById('servDateHid'+rowCount).value=visitAdmDatetime;
					}
					if(i==6){
					newcell.childNodes[0].value = orderclinicianName;
					document.getElementById('orderClinicID'+rowCount).value=orderclinicianID;
					}
					if(i==7){
					newcell.childNodes[0].value = orderclinicianName;
					document.getElementById('performClinicID'+rowCount).value=orderclinicianID;
					}
					break;
			case "checkbox":
					newcell.childNodes[0].checked = false;
					if(i==15){
						newcell.childNodes[0].checked = true;
					}
					break;
			case "select-one":
					newcell.childNodes[0].selectedIndex = 1;
					break;
		}
	}
}
//Adding Row against Add row button Click
function addRow(x) {
	addRowFlag="Y";
	var orderclinicianID;
	var orderclinicianName;
	var siteSpecPatPayable=document.getElementById('siteSpecPatPayable').value;//V230222
	
	var RowIndex=x.parentNode.parentNode.rowIndex;
	var table = document.getElementById('serviceTable1');
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	row.setAttribute("id","serviceRow"+rowCount);
	row.onclick = function() {RowChange(this);}; // for IE
	var colCount = table.rows[RowIndex].cells.length;
	for(var i=0; i<colCount; i++) {
		var newcell	= row.insertCell(i);
		
			datetime = getCurrentDateTime();//V201015 Modified
			visitAdmDatetime = getCurrentDateTime();//V201015 Modified
		if(siteSpecPatPayable=="true" || siteSpecPatPayable==true){
				if(i==0){	
					visitAdmDatetime=getVisitAdmDate();//V201015 Modified
					newcell.innerHTML ="<input type='text' class='gridDataInputMore' onblur='validateDateTime(this)' name='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' value='"+visitAdmDatetime+"' size='19' maxlength='19'><img src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('serviceDate"+rowCount+"',null,'hh:mm:ss');\"><input type='hidden' id='servDateHid"+rowCount+"'value='"+visitAdmDatetime+"'>"; //V201222 Modified
					//newcell.className = 'gridData';
				}
				else if(i==1){
				newcell.innerHTML="<select name='servicetype"+rowCount+"' id='servicetype"+rowCount+"' id='servicetype"+rowCount+"' onchange='DrugTypeChange(this)'>"    
					+"<option value='Select' >-Select-</option>"
					+"<option value='S' selected>Service</option>"
					+"<option value='I' >Drug</option>"
					+" </select>";
				}
				else if(i==17){
				newcell.innerHTML ="<input type='checkbox' name='Cancelcheck"+rowCount+"' id='Cancelcheck"+rowCount+"'  id='Cancelcheck"+rowCount+"' onclick='CancelClick(this)' value='' /><input style='display:none;' type='text' id='serviceCancelRow"+rowCount+"' value='' ><input style='display:none;' type='text' id='primKeyModuleID"+rowCount+"' value='' >";
				}
				else if(i==15){
					newcell.innerHTML="<input type='checkbox' name='checkboxBill"+rowCount+"' id='checkboxBill"+rowCount+"' value='checked' id='checkboxBill"+rowCount+"'  onclick='billClick(this)' checked/><input style='display:none;' type='text' id='serviceBillCheck"+rowCount+"'>";
				}
				else if(i==16){
					newcell.innerHTML = "<input type='button' name='AddBTn"+rowCount+"' id='AddBTn"+rowCount+"'  value='+' onclick='addRow(this)' id='AddBTn"+rowCount+"'><input style='display:none;' type='text' id='serviceAddRow"+rowCount+"' value='Y' >";
				}
				
				else if(i==9){
					 newcell.innerHTML = "<input type='checkbox' name='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' onclick='zeroPriceClick(this)' />";
					//newcell.className = 'gridData';
				}
				else if(i==7){
					 newcell.innerHTML = "<input type='text' class='gridDataInputLess' style='width: 50px;' onkeypress='return restrictAlphabets(event);' onblur='validateServQty(this)' id='serviceQty"+rowCount+"' name='serviceQty"+rowCount+"' id='serviceQty"+rowCount+"' ><input type='text'  style='display:none;' id='serviceRateCharge"+rowCount+"' value='' >";
					//newcell.className = 'gridData';
				}
				else if(i==3){
					newcell.innerHTML="<input type='text' class='gridDataInput' onblur='validateCPTCode(this)' name='cptCode"+rowCount+"' id='cptCode"+rowCount+"' id='cptCode"+rowCount+"' contenteditable><input type='hidden' class='gridDataInput' onblur='validateServCode(this)' name='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='callCPTSearch(this)' name = 'servCodeLovButton'> ";
					//newcell.className = 'gridData';
				}
				else if(i==4){
					newcell.innerHTML="<input class='gridDataInputMore' type='text' name='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' readonly  value='' title=''>"; //V201222 Modified
				}
				else if(i==5){
					//Getting Ordering Clinician
					var FacilityId = document.getElementById('FacilityId').value;
					var EncounterId = document.getElementById("+ServEncounterId+").value;
					var PatientID = document.getElementById('PatientID').value;
					var EpisodeId = document.getElementById('EpisodeId').value;
					var EpisodeType = document.getElementById('EpisodeType').value;
					var VisitID = document.getElementById('VisitID').value;
					var LangId=document.getElementById("locale").value;
					var params="&FacilityId="+FacilityId+"&EpisodeType="+EpisodeType+"&EncounterId="+EncounterId+"&VisitID="+VisitID+"&LangId="+LangId;
					var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician"+params;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;		
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send("");
					var responseText=xmlHttp.responseText;
					if(responseText!="" && responseText!=null){
					var strtIndex = responseText.indexOf("~");
					if(strtIndex!=-1){
						var res1 = responseText.substr(strtIndex+1);
						var res = res1.split("~");
						orderclinicianID = res[0];
						orderclinicianName=res[1];
					}else{
						orderclinicianID = "";
						orderclinicianName="";
					}
					}					
					newcell.innerHTML="<input type='text' class='gridDataInput' name='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='orderingClinicianLookUp(this)' name = 'OrderLovButton'><input style='display:none;' type='text' id='orderClinicID"+rowCount+"' value='' > ";
				}
				else if(i==6){
					newcell.innerHTML="<input type='text' class='gridDataInput' name='performClinic"+rowCount+"' id='performClinic"+rowCount+"' id='performClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='performingClinicianLookUp(this)'  id='PerformLovButton' name='PerformLovButton' id='PerformLovButton'><input style='display:none;' type='text' id='performClinicID"+rowCount+"' value=''><input style='display:none;' type='text' id='modifyYN"+rowCount+"' value='N' >";
				}
				else if(i==11){
					newcell.innerHTML="<input class='gridDataInput' style='width: 75px;' type='text' name='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' onblur='ModAppNo(this)' value='"+datetime+"' size='19' maxlength='19' ><img id='AppDateImg"+rowCount+"' src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('ApproveDate"+rowCount+"',null,'hh:mm:ss');\">";//V201222 Modified
				}
				else if(i==12){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' onblur='isNo(this)' onkeypress='return restrictAlphabets(event);' value='' >";
				}
				else if(i==13){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"'  value='' disabled>";
					
				}else if(i==14){
					if(siteSpecPatPayable==true || siteSpecPatPayable=="true"){
						newcell.innerHTML="<input class='gridDataInput' type='text' name='patPay"+rowCount+"' id='patPay"+rowCount+"' id='patPay"+rowCount+"' value='0.0' disabled>";
					}
				}
				else if(i==10){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' maxlength='20' value='' ><input style='display:none;' type='text' id='serviceModAppNo"+rowCount+"' value='N' >";
				}
				else if(i>=18){
					newcell.innerHTML ="<input type='text' style='display:none;' hidden>";
					newcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style 
					//newcell.className = 'hideCol';
				}else if(i==8){
					newcell.innerHTML ="<input type='text' class='gridDataInputLess' maxlength='30' contenteditable>";
				}
				else if(i==2){
					newcell.innerHTML="<input class='gridDataInputLess' type='text' maxlength='100' name='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' value=\"\" ><input type='text' style='display:none;' id='preAppFlagID"+rowCount+"' value=\"N\" hidden>";
				}
				else{
					var classname;
					if(i==2){
						classname="gridDataInputLess";
						
					}else{
						classname="gridDataInput";
					}
					newcell.innerHTML ="<input type='text' class='"+classname+"'  contenteditable>";
				}
			}else{
				if(i==0){	
				visitAdmDatetime=getVisitAdmDate();//V201015 Modified
				newcell.innerHTML ="<input type='text' class='gridDataInputMore' onblur='validateDateTime(this)' name='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' id='serviceDate"+rowCount+"' value='"+visitAdmDatetime+"' size='19' maxlength='19'><img src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('serviceDate"+rowCount+"',null,'hh:mm:ss');\"><input type='hidden' id='servDateHid"+rowCount+"'value='"+visitAdmDatetime+"'>"; //V201222 Modified
					//newcell.className = 'gridData';
				}
				else if(i==1){
				newcell.innerHTML="<select name='servicetype"+rowCount+"' id='servicetype"+rowCount+"' id='servicetype"+rowCount+"' onchange='DrugTypeChange(this)'>"    
					+"<option value='Select' >-Select-</option>"
					+"<option value='S' selected>Service</option>"
					+"<option value='I' >Drug</option>"
					+" </select>";
				}
				else if(i==16+j){
				newcell.innerHTML ="<input type='checkbox' name='Cancelcheck"+rowCount+"' id='Cancelcheck"+rowCount+"'  id='Cancelcheck"+rowCount+"' onclick='CancelClick(this)' value='' /><input style='display:none;' type='text' id='serviceCancelRow"+rowCount+"' value='' ><input style='display:none;' type='text' id='primKeyModuleID"+rowCount+"' value='' >";
				}
				else if(i==14+j){
					newcell.innerHTML="<input type='checkbox' name='checkboxBill"+rowCount+"' id='checkboxBill"+rowCount+"' value='checked' id='checkboxBill"+rowCount+"'  onclick='billClick(this)' checked/><input style='display:none;' type='text' id='serviceBillCheck"+rowCount+"'>";
				}
				else if(i==15+j){
					newcell.innerHTML = "<input type='button' name='AddBTn"+rowCount+"' id='AddBTn"+rowCount+"'  value='+' onclick='addRow(this)' id='AddBTn"+rowCount+"'><input style='display:none;' type='text' id='serviceAddRow"+rowCount+"' value='Y' >";
				}
				
				else if(i==9){
					 newcell.innerHTML = "<input type='checkbox' name='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' id='checkboxZero"+rowCount+"' onclick='zeroPriceClick(this)' />";
					//newcell.className = 'gridData';
				}
				else if(i==7){
					 newcell.innerHTML = "<input type='text' class='gridDataInputLess' style='width: 50px;' onkeypress='return restrictAlphabets(event);' onblur='validateServQty(this)' id='serviceQty"+rowCount+"' name='serviceQty"+rowCount+"' id='serviceQty"+rowCount+"' ><input type='text'  style='display:none;' id='serviceRateCharge"+rowCount+"' value='' >";
					//newcell.className = 'gridData';
				}
				else if(i==3){
					newcell.innerHTML="<input type='text' class='gridDataInput' onblur='validateCPTCode(this)' name='cptCode"+rowCount+"' id='cptCode"+rowCount+"' id='cptCode"+rowCount+"' contenteditable><input type='hidden' class='gridDataInput' onblur='validateServCode(this)' name='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' id='serviceCode"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='callCPTSearch(this)' name = 'servCodeLovButton'> ";
					//newcell.className = 'gridData';
				}
				else if(i==4){
					newcell.innerHTML="<input class='gridDataInputMore' type='text' name='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' id='serviceDesc"+rowCount+"' readonly>"; //V201222 Modified
				}
				else if(i==5){
					//Getting Ordering Clinician
					var FacilityId = document.getElementById('FacilityId').value;
					var EncounterId = document.getElementById("+ServEncounterId+").value;
					var PatientID = document.getElementById('PatientID').value;
					var EpisodeId = document.getElementById('EpisodeId').value;
					var EpisodeType = document.getElementById('EpisodeType').value;
					var VisitID = document.getElementById('VisitID').value;
					var LangId=document.getElementById("locale").value;
					var params="&FacilityId="+FacilityId+"&EpisodeType="+EpisodeType+"&EncounterId="+EncounterId+"&VisitID="+VisitID+"&LangId="+LangId;
					var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician"+params;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;		
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send("");
					var responseText=xmlHttp.responseText;
					if(responseText!="" && responseText!=null){
					var strtIndex = responseText.indexOf("~");
					if(strtIndex!=-1){
						var res1 = responseText.substr(strtIndex+1);
						var res = res1.split("~");
						orderclinicianID = res[0];
						orderclinicianName=res[1];
					}else{
						orderclinicianID = "";
						orderclinicianName="";
					}
					}					
					newcell.innerHTML="<input type='text' class='gridDataInput' name='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' id='orderClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='orderingClinicianLookUp(this)' name = 'OrderLovButton'><input style='display:none;' type='text' id='orderClinicID"+rowCount+"' value='' > ";
				}
				else if(i==6){
					newcell.innerHTML="<input type='text' class='gridDataInput' name='performClinic"+rowCount+"' id='performClinic"+rowCount+"' id='performClinic"+rowCount+"' contenteditable><input type='button' class='button' value='?' onclick='performingClinicianLookUp(this)'  id='PerformLovButton' name='PerformLovButton' id='PerformLovButton'><input style='display:none;' type='text' id='performClinicID"+rowCount+"' value=''><input style='display:none;' type='text' id='modifyYN"+rowCount+"' value='N' >";
				}
				else if(i==11){
					newcell.innerHTML="<input class='gridDataInput' style='width: 75px;' type='text' name='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' id='ApproveDate"+rowCount+"' onblur='ModAppNo(this)' value='"+datetime+"' size='19' maxlength='19' ><img id='AppDateImg"+rowCount+"' src='../../eCommon/images/CommonCalendar.gif'  onclick=\"return showCalendar('ApproveDate"+rowCount+"',null,'hh:mm:ss');\">";//V201222 Modified
				}
				else if(i==12){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' id='ServPrice"+rowCount+"' onblur='isNo(this)' onkeypress='return restrictAlphabets(event);' value='' >";
				}
				else if(i==13){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"' id='InsAmt"+rowCount+"'  value='' disabled>";
					
				}else if(i==13+j){
					if(siteSpecPatPayable==true || siteSpecPatPayable=="true"){
						newcell.innerHTML="<input class='gridDataInput' type='text' name='patPay"+rowCount+"' id='patPay"+rowCount+"' id='patPay"+rowCount+"' value='0.0' disabled>";
					}
				}
				else if(i==10){
					newcell.innerHTML="<input class='gridDataInput' type='text' name='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' id='ApproveNum"+rowCount+"' maxlength='20' value='' ><input style='display:none;' type='text' id='serviceModAppNo"+rowCount+"' value='N' >";
				}
				else if(i>=17+j){
					newcell.innerHTML ="<input type='text' style='display:none;' hidden>";
					newcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style 
					//newcell.className = 'hideCol';
				}else if(i==8){
					newcell.innerHTML ="<input type='text' class='gridDataInputLess' maxlength='30' contenteditable>";
				}
				else if(i==2){
					newcell.innerHTML="<input class='gridDataInputLess' type='text' maxlength='100' name='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' id='serviceTypeDesc"+rowCount+"' value=\"\" ><input type='text' style='display:none;' id='preAppFlagID"+rowCount+"' value=\"N\" hidden>";
				}
				else{
					var classname;
					if(i==2){
						classname="gridDataInputLess";
						
					}else{
						classname="gridDataInput";
					}
					newcell.innerHTML ="<input type='text' class='"+classname+"'  contenteditable>";
				}
			}
		switch(newcell.childNodes[0].type) {
			case "text":
					newcell.childNodes[0].value = "";
					if(i==7){
						newcell.childNodes[0].value = "1";
					}
					if(i==11){
						newcell.childNodes[0].value = getCurrentDateTime();//V201015 Modified
					}
					if(i==0){
						newcell.childNodes[0].value = visitAdmDatetime;
					document.getElementById('servDateHid'+rowCount).value=visitAdmDatetime;
					}
					if(i==5){
					newcell.childNodes[0].value = orderclinicianName;
					document.getElementById('orderClinicID'+rowCount).value=orderclinicianID;
					}
					if(i==6){
					newcell.childNodes[0].value = orderclinicianName;
					document.getElementById('performClinicID'+rowCount).value=orderclinicianID;
					}
					break;
			case "checkbox":
					newcell.childNodes[0].checked = false;
					if(i==14){
						newcell.childNodes[0].checked = true;
					}
					break;
			case "select-one":
					newcell.childNodes[0].selectedIndex = 1;
					break;
		}
	}
}

//Drug/Non-Drug Change Event
function DrugTypeChange(x){
	var siteSpecPatPayable=document.getElementById('siteSpecPatPayable').value;//V230222
	var RowIndex=x.parentNode.parentNode.rowIndex;
	document.getElementById("cptCode"+RowIndex).value="";		 
	document.getElementById("serviceCode"+RowIndex).value="";
	document.getElementById("serviceDesc"+RowIndex).value="";
	document.getElementById("ServPrice"+RowIndex).value="";
	document.getElementById("InsAmt"+RowIndex).value="";
	document.getElementById("serviceQty"+RowIndex).value="1";
	if(x.value=="I"){
		document.getElementById('serviceTypeDesc'+RowIndex).value="Drug";
	}else{
		document.getElementById('serviceTypeDesc'+RowIndex).value="";
	}
	if(siteSpecPatPayable==true || siteSpecPatPayable=="true"){
		document.getElementById('patPay'+RowIndex).value="";
	}//V230222
}

//Function Formload event
function onLoadServiceEdit() {
		
	//Making Editable Functionlaity bas ed on billable check box
	try{
		var table = document.getElementById('serviceTable1');
		var serviceSize = document.getElementById('serviceSize').value;//V201015 Added
		var rowCount = table.rows.length;
		var siteSpecServiceCode=document.getElementById('siteSpecServiceCode').value;
		var siteSpecPatPayable=document.getElementById('siteSpecPatPayable').value;//V230222
		//V201015 Starts
		//New row Condition
		if(serviceSize==0){
			addRowFlag="Y";
			//Date Time Value From DB
			document.getElementById('serviceDate1').value=getVisitAdmDate();//V201015 Modified
			//Approval Date
			document.getElementById('ApproveDate1').value=getCurrentDateTime();//V201015 Modified
		}//V201015 Ends
		else{
		if(siteSpecServiceCode == "true"){
		// var i=1 to start after header
		for(var j=rowCount-1; j>0; j--) {
			var colCount = table.rows[j].cells.length;
			//Disabling based on cancel service
			var Cancelchkbox = table.rows[j].cells[17].getElementsByTagName('input')[0];
			if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked){
				for(var k=0; k<colCount; k++){
					if(k==13 || k==14){
						var colDecVal = table.rows[j].cells[k].childNodes[0].value;
						table.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
					if(k!=16){
					if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked) {
						var str=table.rows[j].cells[k].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='unselectable';
					}
					else{
						
						var str=table.rows[j].cells[k].innerHTML;
						var res;						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='selectable';						
					}
					}
				}
			}else{
				//var chkbox = table.rows[j].cells[14].getElementsByTagName('input')[0];
				var getBillVal=document.getElementById('serviceBillCheck'+j).value;
				for(var i=0; i<colCount; i++) {
					if(i==13 || i==14){
						var colDecVal = table.rows[j].cells[i].childNodes[0].value;
						table.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
				//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484
				if(i!=16){//Added against AAKH-SCF-0484
					if(getBillVal=="checked") {
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
					}
					else{
						//if(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13)
						if(i==1|| i==2|| i==3|| i==4|| i==5|| i==6 || i==8|| i==9|| i==13|| i==14){
							var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
						}else{
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='selectable';
					}	
					
					}
				}
			}
			}
			//Disabling Approve Numebr and Date based on Rate Charge Flag
			var preApFlag=document.getElementById('preAppFlagID'+j).value;
				if(preApFlag=="N"){
					document.getElementById("ApproveNum"+j).value = "";
					document.getElementById("ApproveDate"+j).value = "";
					document.getElementById("ApproveNum"+j).disabled = true;
					document.getElementById("ApproveDate"+j).disabled = true;
					document.getElementById("AppDateImg"+j).disabled = true;
				}
				else if(preApFlag=="Y"){
					var appDateValue=document.getElementById('ApproveDate'+j).value;
					var appNoValue=document.getElementById('ApproveNum'+j).value;
					if(appDateValue!=null && appDateValue!=""){
						document.getElementById('appDateHid'+j).value=appDateValue;
					}
					if(appNoValue!=null && appNoValue!=""){
						document.getElementById('appNoHid'+j).value=appNoValue;
					}
				}
			}
			}
			else if(siteSpecPatPayable==true || siteSpecPatPayable=="true"){
				for(var j=rowCount-1; j>0; j--) {
			var colCount = table.rows[j].cells.length;
			//Disabling based on cancel service
			var Cancelchkbox = table.rows[j].cells[17].getElementsByTagName('input')[0];
			if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked){
				for(var k=0; k<colCount; k++){
					if(k==12 || k==13 ||k==14){
						var colDecVal = table.rows[j].cells[k].childNodes[0].value;
						table.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
					if(k!=16){
					if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked) {
						var str=table.rows[j].cells[k].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='unselectable';
					}
					else{
						
						var str=table.rows[j].cells[k].innerHTML;
						var res;						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='selectable';						
					}
					}
				}
			}else{
				//var chkbox = table.rows[j].cells[14].getElementsByTagName('input')[0];
				var getBillVal=document.getElementById('serviceBillCheck'+j).value;
				for(var i=0; i<colCount; i++) {
					
					if(i==12 || i==13 || i==14){
						var colDecVal = table.rows[j].cells[i].childNodes[0].value;
						table.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
				//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484
				if(i!=16){//Added against AAKH-SCF-0484
					if(getBillVal=="checked") {
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
					}
					else{
						if(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13 || i==14){
							var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
						}else{
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='selectable';
					}	
					
					}
				}
			}
			}
			//Disabling Approve Numebr and Date based on Rate Charge Flag
			var preApFlag=document.getElementById('preAppFlagID'+j).value;
				if(preApFlag=="N"){
					document.getElementById("ApproveNum"+j).value = "";
					document.getElementById("ApproveDate"+j).value = "";
					document.getElementById("ApproveNum"+j).disabled = true;
					document.getElementById("ApproveDate"+j).disabled = true;
					document.getElementById("AppDateImg"+j).disabled = true;
				}
				else if(preApFlag=="Y"){
					var appDateValue=document.getElementById('ApproveDate'+j).value;
					var appNoValue=document.getElementById('ApproveNum'+j).value;
					if(appDateValue!=null && appDateValue!=""){
						document.getElementById('appDateHid'+j).value=appDateValue;
					}
					if(appNoValue!=null && appNoValue!=""){
						document.getElementById('appNoHid'+j).value=appNoValue;
					}
				}
			}
		  } //V230222
			else
			{
				for(var j=rowCount-1; j>0; j--) {
			var colCount = table.rows[j].cells.length;
			//Disabling based on cancel service
			var Cancelchkbox = table.rows[j].cells[16].getElementsByTagName('input')[0];
			if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked){
				for(var k=0; k<colCount; k++){
					if(k==12 || k==13){
						var colDecVal = table.rows[j].cells[k].childNodes[0].value;
						table.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
					if(k!=15){
					if('checkbox' == Cancelchkbox.type && true == Cancelchkbox.checked) {
						var str=table.rows[j].cells[k].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='unselectable';
					}
					else{
						
						var str=table.rows[j].cells[k].innerHTML;
						var res;						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[k].innerHTML=res;
						//table.rows[j].cells[k].className='selectable';						
					}
					}
				}
			}else{
				//var chkbox = table.rows[j].cells[14].getElementsByTagName('input')[0];
				var getBillVal=document.getElementById('serviceBillCheck'+j).value;
				for(var i=0; i<colCount; i++) {
					if(i==12 || i==13){
						var colDecVal = table.rows[j].cells[i].childNodes[0].value;
						table.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);
					}
				//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484
				if(i!=15){//Added against AAKH-SCF-0484
					if(getBillVal=="checked") {
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
					}
					else{
						if(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13){
							var str=table.rows[j].cells[i].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='unselectable';
						}else{
						var str=table.rows[j].cells[i].innerHTML;
						var res;
						
						if(str.indexOf("<INPUT")==0){
							res = str.replace("disabled", "");
							if(res.indexOf("<IMG")==0){
							res = str.replace("disabled", "");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("disabled", "");
						}
						table.rows[j].cells[i].innerHTML=res;
						//table.rows[j].cells[i].className='selectable';
					}	
					
					}
				}
			}
			}
			//Disabling Approve Numebr and Date based on Rate Charge Flag
			var preApFlag=document.getElementById('preAppFlagID'+j).value;
				if(preApFlag=="N"){
					document.getElementById("ApproveNum"+j).value = "";
					document.getElementById("ApproveDate"+j).value = "";
					document.getElementById("ApproveNum"+j).disabled = true;
					document.getElementById("ApproveDate"+j).disabled = true;
					document.getElementById("AppDateImg"+j).disabled = true;
				}
				else if(preApFlag=="Y"){
					var appDateValue=document.getElementById('ApproveDate'+j).value;
					var appNoValue=document.getElementById('ApproveNum'+j).value;
					if(appDateValue!=null && appDateValue!=""){
						document.getElementById('appDateHid'+j).value=appDateValue;
					}
					if(appNoValue!=null && appNoValue!=""){
						document.getElementById('appNoHid'+j).value=appNoValue;
					}
				}
			}
		  }
		}
	}catch(e){
			alert("Exception in Editable functionality against billable checkbox Row "+e);
		}
}
 
//Save Function
function SaveServices() {
try{
	//document.getElementById("Save3").disabled = true;//V201015
	var table = document.getElementById('serviceTable1');
	var SesId=document.getElementById('SessionId').value;
	var siteSpecServiceCode=document.getElementById('siteSpecServiceCode').value;
	var FacilityId = document.getElementById('FacilityId').value;
	var ServEncounterId = document.getElementById("+ServEncounterId+").value;
	var PatientID = document.getElementById('PatientID').value;
	var EpisodeId = document.getElementById('EpisodeId').value;
	var EpisodeType = document.getElementById('EpisodeType').value;
	var VisitID = document.getElementById('VisitID').value;
	var rowCount = table.rows.length;	
	var WS_NO = document.getElementById('logInWSno').value;		
	var loginUser = document.getElementById('logInUserId').value;
	dataArr=ArrNoDupe(dataArr);
	for (r = 0; r < dataArr.length; r++) {
		var dataArrId= document.getElementById(dataArr[r]);
		var appModFlag = document.getElementById('serviceModAppNo'+dataArrId.rowIndex).value;
		var addNewRowFlag = document.getElementById('serviceAddRow'+dataArrId.rowIndex).value;
		var preAppFlag= document.getElementById('preAppFlagID'+dataArrId.rowIndex).value;
		var appNumber= document.getElementById("ApproveNum"+dataArrId.rowIndex).value;
		var appDate= document.getElementById("ApproveDate"+dataArrId.rowIndex).value;
		var cptCodeVal=trimString(document.getElementById("cptCode"+dataArrId.rowIndex).value);
		var servCodeVal=document.getElementById("serviceCode"+dataArrId.rowIndex).value;
		if(appModFlag=="Y" || addNewRowFlag=="Y"){
			if(preAppFlag=="Y"){
				if(appNumber=="" || appNumber==null){
					if(cptCodeVal!="" && cptCodeVal!=null){
						alert("Approval Number required for the service "+cptCodeVal);
						document.getElementById("ApproveNum"+dataArrId.rowIndex).focus();
						document.getElementById("Save3").disabled = false;//V201015
						document.getElementById('Save3').style.opacity='0';
						return false;
					}else if((cptCodeVal=="" || cptCodeVal==null) && (servCodeVal!="" && servCodeVal!=null)){
						alert("Approval Number required for the service "+servCodeVal);
						document.getElementById("ApproveNum"+dataArrId.rowIndex).focus();
						document.getElementById("Save3").disabled = false;//V201015
						document.getElementById('Save3').style.opacity='0';
						return false;
					}
					
				}else if(appDate=="" || appDate==null){
					if(cptCodeVal!="" && cptCodeVal!=null){
						alert("Approval Date required for the service "+cptCodeVal);
						document.getElementById("ApproveDate"+dataArrId.rowIndex).focus();
						document.getElementById("Save3").disabled = false;//V201015
						document.getElementById('Save3').style.opacity='0';
						return false;
					}else if((cptCodeVal=="" || cptCodeVal==null) && (servCodeVal!="" && servCodeVal!=null)){
						alert("Approval Date required for the service "+servCodeVal);
						document.getElementById("ApproveDate"+dataArrId.rowIndex).focus();
						document.getElementById("Save3").disabled = false;//V201015
						document.getElementById('Save3').style.opacity='0';
						return false;
					}
				}
			}
		}
	}
	//Getting Row Values to JSON
	var serviceJSON=[];				//V201222 Modified
	for (index = 0; index < dataArr.length; index++) { 
	var dataArrayId= document.getElementById(dataArr[index]);
	var SaveColCount = table.rows[dataArrayId.rowIndex].cells.length;
	var FinalValues="";
	//Getting Cell value against each row
	
	var siteSpecPatPayable=document.getElementById('siteSpecPatPayable').value;//V230222
	var siteSpecSearch=document.getElementById('siteSpecSearch').value;//V230529
	try{
		if(siteSpecServiceCode == "true"){
		for(var k=0; k<SaveColCount; k++) {
			if(k==5) continue;
			var colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;
			if(k==1){
				if(colDelValues=="Service" || colDelValues=="Drug"){
					colDelValues="S";
				}
			}
			if(k==3){
				colDelValues=document.getElementById('serviceCode'+dataArrayId.rowIndex).value;
			}
			if(k==6){
				colDelValues=document.getElementById('orderClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==7){
				colDelValues=document.getElementById('performClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==4){
				colDelValues = colDelValues.replace(/,/g, ' ');
				colDelValues=encodeURIComponent(colDelValues);
			}
			if(k==17){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[17].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==16){
				if(document.getElementById('serviceAddRow'+dataArrayId.rowIndex).value=="Y"){
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==10 || k==15){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			FinalValues=FinalValues+colDelValues+"~";
		}
		}
		else if(siteSpecPatPayable=="true" || siteSpecPatPayable==true){ //V230222
			for(var k=0; k<SaveColCount; k++) {
			var colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;
			if(k==1){
				if(colDelValues=="Service" || colDelValues=="Drug"){
					colDelValues="S";
				}
			}
			if(k==3){
				colDelValues=document.getElementById('serviceCode'+dataArrayId.rowIndex).value;
			}
			if(k==5){
				colDelValues=document.getElementById('orderClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==6){
				colDelValues=document.getElementById('performClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==4){
				colDelValues = colDelValues.replace(/,/g, ' ');
				colDelValues=encodeURIComponent(colDelValues);
			}
			if(k==17){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[17].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==16){
				if(document.getElementById('serviceAddRow'+dataArrayId.rowIndex).value=="Y"){
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==9 || k==15){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			FinalValues=FinalValues+colDelValues+"~";
			}
			
			//16/11/2022 15:50:18~S~~ADHS_2~Home%20Visit-Specialist~DRJAMEEL~DRJAMEEL~1~~N~~~3675.00~0.00~N~checked~Y~N~~~~~~~~~~~~

		}
		else{
			for(var k=0; k<SaveColCount; k++) {
			var colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;
			if(k==1){
				if(colDelValues=="Service" || colDelValues=="Drug"){
					colDelValues="S";
				}
			}
			if(k==3){
				colDelValues=document.getElementById('serviceCode'+dataArrayId.rowIndex).value;
			}
			if(k==5){
				colDelValues=document.getElementById('orderClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==6){
				colDelValues=document.getElementById('performClinicID'+dataArrayId.rowIndex).value;
			}
			if(k==4){
				colDelValues = colDelValues.replace(/,/g, ' ');
				colDelValues=encodeURIComponent(colDelValues);
			}
			if(k==16){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[16].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==15){
				if(document.getElementById('serviceAddRow'+dataArrayId.rowIndex).value=="Y"){
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			if(k==9 || k==14){
				var chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName('input')[0];
				if('checkbox' == chkbox.type && true == chkbox.checked) {
					colDelValues="Y";
				}else{
					colDelValues="N";
				}
			}
			FinalValues=FinalValues+colDelValues+"~";
		}

		}
	}catch(e){
		alert("Exception in Getting values in SaveServices Row "+e);
	}		
		//Appending all other common values
		var ModifiedFlag=document.getElementById('serviceModAppNo'+dataArrayId.rowIndex).value;
		var cptCode=document.getElementById('cptCode'+dataArrayId.rowIndex).value;
		var modifyYN=document.getElementById('modifyYN'+dataArrayId.rowIndex).value;
		FinalValues=FinalValues+FacilityId+'~'+ServEncounterId+'~'+EpisodeId+'~'+EpisodeType+'~'+PatientID+'~'+VisitID+'~'+ModifiedFlag+'~'+WS_NO+'~'+loginUser+'~'+cptCode+'~'+modifyYN+'~';
		if(cptCode!="" && cptCode!=null){
			serviceJSON.push(FinalValues);
		}
	}
	if(serviceJSON.length!=0 && subFlag=="Y"){
		subFlag="N";
		/*var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceJSON="+serviceJSON+"&CalledFor=SaveData&SessionId="+SesId;
			var xmlDoc = new ActiveXObject( "Microsoft.XMLDom") ;
			var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP") ;		
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send("");
		var responseText=xmlHttp.responseText;
		document.getElementById("Save3").disabled = false;//V201015
		document.getElementById('Save3').style.opacity='0';
		*/
		$.ajax({
			url: "../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceJSON="+serviceJSON+"&CalledFor=SaveData&SessionId="+SesId+"&siteSpecPatPayable="+siteSpecPatPayable+"&siteSpecSearch="+siteSpecSearch, //V230222
			type: 'POST',
			success: function(result) {
				document.getElementById("Save3").disabled = false;//V201015
				document.getElementById('Save3').style.opacity='0';
                  },
			async:   false
			});
	}
	document.getElementById("Save3").disabled = false;//V201015
	document.getElementById('Save3').style.opacity='0';
	}catch(e){
		alert("Exception in SaveServices Row "+e);
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

// function that Closes the open Window 
function windowClose() { 
	window.opener.setValue(true);
	window.parent.close(); 
}

//Zero price Click Event
function zeroPriceClick(e){
try{
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var myTable = document.getElementById('serviceTable1');
	var primModId=document.getElementById('primKeyModuleID'+RowIndex).value;
	// var i=1 to start after header
	var chkbox = myTable.rows[RowIndex].cells[9].getElementsByTagName('input')[0];
		if('checkbox' == chkbox.type && true == chkbox.checked) {
			var str=myTable.rows[RowIndex].cells[16].innerHTML;
			var res;
				if(str.indexOf("<INPUT")==0){
					res = str.replace("<INPUT", "<INPUT disabled");
				}
				myTable.rows[RowIndex].cells[16].innerHTML=res;
		}
		else
		{
			var str=myTable.rows[RowIndex].cells[16].innerHTML;
			if(str.indexOf("<INPUT")==0){
				res = str.replace("disabled", "");
			}
			if(primModId!="PH" && primModId!="ST"){
				myTable.rows[RowIndex].cells[16].innerHTML=res;
			}
		}
	}
	catch(e){
			alert("Exception Zero Price Row "+e);
		}
}

//Cancel Service Click Function
function CancelClick(e){
	try{
		var RowIndex=e.parentNode.parentNode.rowIndex;
		var myTable = document.getElementById('serviceTable1');
		// var i=1 to start after header
		var chkbox = myTable.rows[RowIndex].cells[16].getElementsByTagName('input')[0];
		var getBillVal=document.getElementById('serviceBillCheck'+RowIndex).value;
			if('checkbox' == chkbox.type && true == chkbox.checked) {
				document.getElementById('serviceCancelRow'+RowIndex).value="Y";
				var str=myTable.rows[RowIndex].cells[9].innerHTML;
				var res;
					if(str.indexOf("<INPUT")==0){
						res = str.replace("<INPUT", "<INPUT disabled");
					}
					myTable.rows[RowIndex].cells[9].innerHTML=res;
			}
			else
			{
				document.getElementById('serviceCancelRow'+RowIndex).value="N";
				if(getBillVal!="checked"){
				var str=myTable.rows[RowIndex].cells[9].innerHTML;
					if(str.indexOf("<INPUT")==0){
						res = str.replace("disabled", "");
					}
				myTable.rows[RowIndex].cells[9].innerHTML=res;
				}
			}
		//Validation
		var addFlag=document.getElementById('serviceAddRow'+RowIndex).value;
		var modFlag=document.getElementById('serviceModAppNo'+RowIndex).value;
		var canFlag=document.getElementById('serviceCancelRow'+RowIndex).value;
		if(addFlag!="Y" && canFlag=="Y"){
			document.getElementById('serviceAddRow'+RowIndex).value="N";
			document.getElementById('serviceModAppNo'+RowIndex).value="N";
		}		
	}
	catch(e){
			alert("Exception Zero Price Row "+e);
		}
}

//RowClick Event Id Capture
function RowChange(e){	
	if(addRowFlag!='Y'){
		var RowIndex=e.rowIndex;
		dataArr.push(e.id);
		var returned=[];
		returned=ArrNoDupe(dataArr);
		dataArr=[];
		dataArr=returned;
	}
	else{
		addRowFlag='N';
	}
}

//To find duplication in array
function ArrNoDupe(a) {
    var temp = {};
    for (var i = 0; i < a.length; i++)
        temp[a[i]] = true;
    var r = [];
    for (var k in temp)
        r.push(k);
    return r;
}

//Validating Date Time for Inpatient and Out Patient
function validateDateTime(e){
	var DateTime=e.value;
	var RowIndex=e.parentNode.parentNode.rowIndex;
	if(DateTime!=null && DateTime!=""){
		if(dateRegEx(e)){
			//Validation
			var addFlag=document.getElementById('serviceAddRow'+RowIndex).value;
			var canFlag=document.getElementById('serviceCancelRow'+RowIndex).value;
			var serviceModFlag=document.getElementById("serviceModAppNo"+RowIndex).value;
				if(canFlag!="Y" && addFlag!="Y" && serviceModFlag!='Y'){
					document.getElementById("modifyYN"+RowIndex).value="Y";
				}
				else{
					document.getElementById("modifyYN"+RowIndex).value="N";
				}
			var FacId=document.getElementById("FacilityId").value;
			var EncounterId=document.getElementById("ServEncounterId").value;
			//var formObj=document.BLCoderEditService;
			var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?dateTime="+DateTime+"&FacilityId="+FacId+"&EncounterId="+EncounterId+"&CalledFor=DateValidation";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;		
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send("");
			var responseText=xmlHttp.responseText;
			responseText=trimString(responseText);
			var n1 = responseText.indexOf("~");
			var res1 =responseText.substr(n1+1);
			if(res1 != null && res1 != ""){
				alert(res1);
				document.getElementById(e.id).value=document.getElementById("servDateHid"+RowIndex).value;
			}
		}
	}
	else{
		alert("Service date cannot be empty");
		document.getElementById(e.id).value=document.getElementById("servDateHid"+RowIndex).value;
	}	
}	

//Validating Service Quantity
function validateServQty(e){
	if(e.value!=0){
		if(isNumber(e)){
			var serviceQty = e.value;
			var strtIndex = serviceQty.indexOf(".");
			if(strtIndex!=-1){
				document.getElementById(e.id).value=parseFloat(serviceQty).toFixed(3);
			}
			var RowIndex=e.parentNode.parentNode.rowIndex;
			var FacId=document.getElementById("FacilityId").value;
			var LangId=document.getElementById("locale").value;
			var loginUser=document.getElementById("loginUser").value;
			var ServEncounterId = document.getElementById("+ServEncounterId+").value;
			var ServDate = document.getElementById('serviceDate'+RowIndex).value;
			var ServTypeInd = document.getElementById('servicetype'+RowIndex).value;
			var cptCode=document.getElementById("cptCode"+RowIndex).value;
			var serviceCode = document.getElementById('serviceCode'+RowIndex).value;
			var serviceRateCharge = document.getElementById('serviceRateCharge'+RowIndex).value;
			var siteSpecPatPayable = document.getElementById('siteSpecPatPayable').value;//V230222
			var params="FacId="+FacId+"&LangId="+LangId+"&loginUser="+loginUser+"&ServEncounterId="+ServEncounterId+"&ServDate="+ServDate+"&ServTypeInd="+ServTypeInd+"&serviceCode="+serviceCode+"&serviceQty="+serviceQty+"&serviceRateCharge="+serviceRateCharge+"&cptCode="+cptCode+"&siteSpecPatPayable="+siteSpecPatPayable;//V230222
			//Ajax Call
			var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?"+params+"&CalledFor=servQtyCheck";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;		
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send("");
			var responseText1=xmlHttp.responseText;
			responseText1 = trimString(responseText1);
			var n1 = responseText1.indexOf("~");
			var res1 = responseText1.substr(n1+1);
			res1 = res1.split("~");
			if(res1[0]!="Error"){
			var serPrice=res1[0];
			var insPrice=res1[1];
			document.getElementById("ServPrice"+RowIndex).value = parseFloat(serPrice).toFixed(2);
			document.getElementById("InsAmt"+RowIndex).value=parseFloat(insPrice).toFixed(2);
			document.getElementById("preAppFlagID"+RowIndex).value=res1[2];
			if(siteSpecPatPayable=="true" || siteSpecPatPayable==true){
				var pat_pay=res1[3];
				document.getElementById("patPay"+RowIndex).value=pat_pay;
				
			}//V230222
				if(res1[2]=="Y"){
					document.getElementById("ApproveNum"+RowIndex).disabled = false;
					document.getElementById("ApproveDate"+RowIndex).disabled = false;
					document.getElementById("AppDateImg"+RowIndex).disabled = false;
					document.getElementById("ApproveNum"+RowIndex).value = "";
				}else{
					document.getElementById("ApproveNum"+RowIndex).value = "";
					document.getElementById("ApproveDate"+RowIndex).value = "";
					document.getElementById("ApproveNum"+RowIndex).disabled = true;
					document.getElementById("ApproveDate"+RowIndex).disabled = true;
					document.getElementById("AppDateImg"+RowIndex).disabled = true;
				}
			}
			else{
				alert(res1[1]);
			}
		}else{
			alert(getMessage('BL8532','BL'));
			document.getElementById(e.id).focus();
		}
	}else{
		alert("Quantity cannot be Zero");
		document.getElementById(e.id).focus();
	}
}	

//Populating Service COde realted values
function validateServCode(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var serviceCode=document.getElementById("serviceCode"+RowIndex).value;
	var FacId=document.getElementById("FacilityId").value;
	var LangId=document.getElementById("locale").value;
	var loginUser=document.getElementById("loginUser").value;
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceCode="+serviceCode+"&FacilityId="+FacId+"&LangId="+LangId+"&loginUser="+loginUser+"&CalledFor=ServiceCode";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;		
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send("");
	var responseText=xmlHttp.responseText;
	if(responseText != null && responseText != ""){
	var n = responseText.indexOf("~");
	var res = responseText.substr(n+1);
	res = res.split("~");
	if(res[0]!="Error"){
	//document.getElementById("serviceDesc"+RowIndex).value=res[0];
	document.getElementById("serviceRateCharge"+RowIndex).value=res[1];
	document.getElementById("serviceQty"+RowIndex).value=res[2];
	if(res[1]=="C"){
		document.getElementById("InsAmt"+RowIndex).disabled = true;
		document.getElementById("ServPrice"+RowIndex).disabled = false;
		document.getElementById("ServPrice"+RowIndex).focus();
	}else{
		document.getElementById("serviceQty"+RowIndex).disabled = false;
		document.getElementById("serviceQty"+RowIndex).focus();
		document.getElementById("InsAmt"+RowIndex).disabled = true;
	}
	//Populating Quantity
	var ServEncounterId = document.getElementById("+ServEncounterId+").value;
	var ServDate = document.getElementById('serviceDate'+RowIndex).value;
	var cptCode=document.getElementById("cptCode"+RowIndex).value;
	var ServTypeInd = document.getElementById('servicetype'+RowIndex).value;
	var serviceQty = document.getElementById("serviceQty"+RowIndex).value;
	var serviceRateCharge = document.getElementById('serviceRateCharge'+RowIndex).value;
	var siteSpecPatPayable = document.getElementById('siteSpecPatPayable').value;
	var params="FacId="+FacId+"&LangId="+LangId+"&loginUser="+loginUser+"&ServEncounterId="+ServEncounterId+"&ServDate="+ServDate+"&ServTypeInd="+ServTypeInd+"&serviceCode="+serviceCode+"&serviceQty="+serviceQty+"&serviceRateCharge="+serviceRateCharge+"&cptCode="+cptCode+"&siteSpecPatPayable="+siteSpecPatPayable;//V230222;
	//Ajax Call
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?"+params+"&CalledFor=servQtyCheck";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;		
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send("");
	var responseText1=xmlHttp.responseText;
	responseText1 = trimString(responseText1);
	var n1 = responseText1.indexOf("~");
	var res1 = responseText1.substr(n1+1);
	res1 = res1.split("~");
	if(res1[0]!="Error"){
		var serPrice=res1[0];
		var insPrice=res1[1];
		if(siteSpecPatPayable=="true" || siteSpecPatPayable==true){
			var patpay=res1[3];
			document.getElementById("patPay"+RowIndex).value =parseFloat(patpay).toFixed(2);
		}//V230222
		document.getElementById("ServPrice"+RowIndex).value =parseFloat(serPrice).toFixed(2);
		document.getElementById("InsAmt"+RowIndex).value=parseFloat(insPrice).toFixed(2);
		document.getElementById("preAppFlagID"+RowIndex).value=res1[2];
		if(res1[2]=="Y"){
				document.getElementById("ApproveNum"+RowIndex).disabled = false;
				document.getElementById("ApproveDate"+RowIndex).disabled = false;
				document.getElementById("AppDateImg"+RowIndex).disabled = false;
				document.getElementById("ApproveNum"+RowIndex).value = "";
			}else{
				document.getElementById("ApproveNum"+RowIndex).value = "";
				document.getElementById("ApproveDate"+RowIndex).value = "";
				document.getElementById("ApproveNum"+RowIndex).disabled = true;
				document.getElementById("ApproveDate"+RowIndex).disabled = true;
				document.getElementById("AppDateImg"+RowIndex).disabled = true;
			}
	}
	else{
		alert(res1[1]);
	}
	}
	else{
		alert(res1[1]);
	}	
}
}

//Populating service Code in LookUp
function serviceCodeLookUp(e){
	var formObj=document.BLCoderEditService;
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var servCodeVal=document.getElementById("serviceCode"+RowIndex).value;
	var LangId=document.getElementById("locale").value;
	var Facility_Id=document.getElementById("FacilityId").value;
	if(formObj!=null){	
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var title="Service Code";	
			argumentArray[0]	=  "SELECT blng_serv_code code, SHORT_DESC description FROM bl_blng_serv WHERE DIR_ENTRY_FLAG = 'Y' AND upper(blng_serv_code) like upper(?) and upper(SHORT_DESC) like upper(?)  order by 2 ";				
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = servCodeVal;
			argumentArray[6]   = CODE_LINK ;
			argumentArray[7]   = CODE_DESC ;	
			retVal = await CommonLookup( title, argumentArray );
			if(retVal != null && retVal != ""){
				document.getElementById("serviceCode"+RowIndex).value=retVal[0];
				validateServCode(e)	;				
			}else{
				document.getElementById("serviceCode"+RowIndex).value="";			
			}
		}
}

//Populating Values in Ordering Clinician LookUp
function performingClinicianLookUp(e){	
	var formObj=document.BLCoderEditService;
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var orderClinicVal=document.getElementById("performClinic"+RowIndex).value;
	var LangId=document.getElementById("locale").value;
	var Facility_Id=document.getElementById("FacilityId").value;
	if(formObj!=null){	
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var title="Performing Clinician";			
			argumentArray[0]	=  "SELECT practitioner_id code,NAME description  FROM bl_am_pract_staff_vw WHERE facility_id = '"+Facility_Id+"' AND UPPER (language_id) = UPPER ('"+LangId+"')  and upper(practitioner_id) like upper(?) and upper(NAME) like upper(?)  order by 2 ";				
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = orderClinicVal;
			argumentArray[6]   = CODE_LINK ;
			argumentArray[7]   = CODE_DESC ;	
			retVal = await CommonLookup( title, argumentArray );
			if(retVal != null && retVal != ""){
				document.getElementById("performClinicID"+RowIndex).value=retVal[0];
				document.getElementById("performClinic"+RowIndex).value=retVal[1];	
				document.getElementById("performClinic"+RowIndex).focus();		
			}else{
				document.getElementById("performClinicID"+RowIndex).value="";
				document.getElementById("performClinic"+RowIndex).value="";	
				document.getElementById("performClinic"+RowIndex).focus();			
			}
		}	
}

//Populating Values in Ordering Clinician LookUp
function orderingClinicianLookUp(e){	
	var formObj=document.BLCoderEditService;
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var orderClinicVal=document.getElementById("orderClinic"+RowIndex).value;
	var LangId=document.getElementById("locale").value;
	var Facility_Id=document.getElementById("FacilityId").value;
	if(formObj!=null){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title="Ordering Clinician";			
				argumentArray[0]	=  "SELECT practitioner_id code,NAME description  FROM bl_am_pract_staff_vw WHERE facility_id = '"+Facility_Id+"' AND UPPER (language_id) = UPPER ('"+LangId+"')  and upper(practitioner_id) like upper(?) and upper(NAME) like upper(?)  order by 2 ";				
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = orderClinicVal;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;	
				retVal = await CommonLookup( title, argumentArray );
				if(retVal != null && retVal != ""){
					document.getElementById("orderClinicID"+RowIndex).value=retVal[0];
					document.getElementById("orderClinic"+RowIndex).value=retVal[1];			
				}else{
					document.getElementById("orderClinicID"+RowIndex).value="";
					document.getElementById("orderClinic"+RowIndex).value="";		
				}
			}
}

//Trim String
function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="onLoadServiceEdit()" onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<form name='BLCoderEditService' id='BLCoderEditService' method='post'>
<center>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <table width="100%" border="0" cellspacing="0" cellpadding="2">
	      <tr >
	      	 <td class="BOLD">Services</td>
	      	  <td width="60%"></td>&nbsp;&nbsp;&nbsp;&nbsp;
			   <%if(siteSpecSearch.equals("true")){%>
	      	  <td style="align:center">
				<input type="text" name="searchCPT" id="searchCPT" id="searchCPT" placeholder="CPT Code Search" title="search CPT Code"> 
				<img alt="search" src="..\..\eBL\images\search.png" onclick="searchCptCode(searchCPT)">
				</td> 
			   <% } %>
				<td></td>
	      </tr>
      </table>
      <tr>
        <td><table width='100%' align="center" cellpadding="4" cellspacing="0" class='grid' id="serviceTable1" >
          <tr>
            <td class='COLUMNHEADER' >Date &amp; Time</td>
            <td class='COLUMNHEADER' >Drug/Non drug </td>
            <td class='COLUMNHEADER' >Service Type</td>
            <td class='COLUMNHEADER' >Service Code(CPT)</td>
            <td class='COLUMNHEADER' >Service Description</td>
			<!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<% if(siteSpecServiceCode){%>
			<td class='COLUMNHEADER' >Billing Service Code</td>
			<%}%>
            <td class='COLUMNHEADER' style="width: 90px;">Ordering Clinician </td>
            <td class='COLUMNHEADER' style="width: 90px;">Performing Clinician</td>
            <td class='COLUMNHEADER' style="width: 90px;">Quantity</td>  <!-- V201222 Modified -->
            <td class='COLUMNHEADER' >Modifier/ Adjuster</td>
            <td class='COLUMNHEADER' >Zero Price</td>
            <td class='COLUMNHEADER' >Approval No.</td>
            <td class='COLUMNHEADER' style="width: 70px;">Approval Date </td> <!-- V201222 Modified -->
            <td class='COLUMNHEADER' >Service Price</td>
            <% if(siteSpecServiceCode){%>
            <td class='COLUMNHEADER' >Ins/Cash Price</td>
			<%}else{%>
			<td class='COLUMNHEADER' >Ins.Price</td>	
			<%}
			 if(siteSpecPatPayable.equals("true")){%>
			<td class='COLUMNHEADER' >Patient Payable</td>
			<%} //V230222%>
			
            <td class='COLUMNHEADER' >Bill-able</td>
            <td class='COLUMNHEADER' >Add Row</td>
            <td class='COLUMNHEADER' >Cancel Services</td>
            <td style="display:none;">BillDocTypeCode</td>
            <td style="display:none;">BillDocNo</td>
            <td style="display:none;">CustGrpCode</td>
            <td style="display:none;">CustCode</td>
            <td style="display:none;">TrxDocRef</td>
            <td style="display:none;">TrxDocRefLineNo</td>
            <td style="display:none;">TrxDocRefSeqNoNo</td>
            <td style="display:none;">TrxDate</td>
            <td style="display:none;">SettlementInd</td>
            <td style="display:none;">PatientAmt</td>
            <td style="display:none;">Key Value</td>
            </tr>
			
<%	
	//Connection con	= null;//Commented for TH-KW-CRF-0143 by Kamatchi S
	Connection conSession = null;
	PreparedStatement pstmtSession = null ;
	ResultSet rsSession = null;
	String bean_id		=	"";
	String bean_name	=	"";
	String facilityId	= (String) session.getValue("facility_id");
	String encounter_id	= request.getParameter("ServiceEncounterId");
	String loginUser	= (String) session.getValue("login_user");
	String SessionId    = request.getParameter("ServiceSessionId");//session.getId();
	String PatientID=request.getParameter("patientId");//V201015 Added
	String episodeID=request.getParameter("episode_id");
	String visitID=request.getParameter("visit_Id");
	String episodeType=request.getParameter("episode_type");
	bean_id				= "CACoderFunction" ;
	bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	String coderClearanceStatus = "";
	coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,PatientID,episodeType,episodeID,visitID);
	DecimalFormat df = new DecimalFormat("0.00");//V230222
	String User			=	"";
	String Sys_Message_ID="";
	String Message_Text="";
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" );
	String WS_NO  = p.getProperty("client_ip_address");
	bean_id		= 	"BLCoderPatServiceBean" ;
	bean_name	= 	"eBL.BLCoderPatServiceBean"; 
	LinkedHashMap 	blCoderpatServices	=	null;
	BLCoderPatServiceBean blCoderPatServiceBean = 	null;
	BLCoderPatService	blCoderPatService = null;	
	blCoderpatServices	=	new LinkedHashMap();
	blCoderPatServiceBean	= 	(BLCoderPatServiceBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
	blCoderPatServiceBean.clearBean();
	
	String sessioStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String localeLang			= (String)session.getAttribute("LOCALE");

	//if(Transaction_Status.equals("S")){	//Loading DB Values from Temporary table to HasMap
			blCoderPatServiceBean.getDBValues(SessionId,facilityId,encounter_id);
		//}
	//Getting Loaded Hashmap with Services
	int limit=1;
	String KeyValue="";
	String EpisodeType=request.getParameter("episode_type");//V201015 Added
	String EpisodeID=request.getParameter("episode_id");//V201015 Added
	String logInUserId=loginUser;//V201015 Added
	String logInWSno=WS_NO;//V201015 Added
	String VisitID="";
	int serviceSize=0;
	//SimpleDateFormat serviceIPSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	//SimpleDateFormat serviceOPSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	blCoderpatServices	= 	(LinkedHashMap)blCoderPatServiceBean.getBLCoderPatSearchValues();

	serviceSize=blCoderpatServices.size();
	if(!blCoderpatServices.isEmpty()) {
         Iterator it = blCoderpatServices.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
           blCoderPatService=(BLCoderPatService)obj.getValue();
		   KeyValue=(String)obj.getKey();
		   if(blCoderPatService!=null){
			   //Login User ID
			   logInUserId= blCoderPatService.getlogInID();
				logInUserId=(logInUserId==null?"":logInUserId);
				//Login WS No ID
			   logInWSno= blCoderPatService.getlogInWSNo();
				logInWSno=(logInWSno==null?"":logInWSno);
			   //Bill Doc type code
			   String BillDocTypeCode= blCoderPatService.getBillDocTypeCode();
				BillDocTypeCode=(BillDocTypeCode==null?"":BillDocTypeCode);
			   //Bill Doc Number
			   String BillDocNo= blCoderPatService.getBillDocNum();
				BillDocNo=(BillDocNo==null?"":BillDocNo);
			   //Customer Group Code
			   String CustGrpCode= blCoderPatService.getCustGroupCode();
				CustGrpCode=(CustGrpCode==null?"":CustGrpCode);
			   //Customer Code
			   String CustCode= blCoderPatService.getCustCode();
				CustCode=(CustCode==null?"":CustCode);
			   //TRX Doc Ref
			   String TrxDocRef= blCoderPatService.getTrxDocRef();
				TrxDocRef=(TrxDocRef==null?"":TrxDocRef);
			   //TRX Doc Ref Line No
			   String TrxDocRefLineNo= blCoderPatService.getTrxDocRefLineNum();
				TrxDocRefLineNo=(TrxDocRefLineNo==null?"":TrxDocRefLineNo);
			   //TRX Doc Ref Seq No
			   String TrxDocRefSeqNo= blCoderPatService.getTrxDocRefSeqNum();
				TrxDocRefSeqNo=(TrxDocRefSeqNo==null?"":TrxDocRefSeqNo);
			   //TRX Date
			   String TrxDate= blCoderPatService.getTrxDate();
				TrxDate=(TrxDate==null?"":TrxDate);
				/*if(!TrxDate.equals("")){
				java.util.Date servdateTime3 = serviceIPSdf.parse(TrxDate);
				TrxDate = serviceOPSdf.format(servdateTime3);
				}*/
			   //Episode Type
			    EpisodeType= blCoderPatService.getEpisodeType();
				EpisodeType=(EpisodeType==null?"":EpisodeType);
			   //Episode Id
			    EpisodeID= blCoderPatService.getEpisodeId();
				EpisodeID=(EpisodeID==null?"":EpisodeID);
			   //Visit Id
			    VisitID= blCoderPatService.getVisitId();
				VisitID=(VisitID==null?"":VisitID);
			   //Settlement Ind
			   String SettlementInd= blCoderPatService.getSettlementInd();
				SettlementInd=(SettlementInd==null?"":SettlementInd);
			   //Patient Amount
			   String PatientAmt= blCoderPatService.getPatientAmount();
				PatientAmt=(PatientAmt==null?"":PatientAmt);
			   //Date and Time
				String Service_Date=  blCoderPatService.getServiceDate();
				Service_Date=(Service_Date==null?"":Service_Date);
				/*if(!Service_Date.equals("")){
				java.util.Date servdateTime2 = serviceIPSdf.parse(Service_Date);
				Service_Date = serviceOPSdf.format(servdateTime2);
				}*/
			   // Drug-NonDrug
				String Service_Type_Ind=  blCoderPatService.getServTypeInd();
				Service_Type_Ind=(Service_Type_Ind==null?"":Service_Type_Ind);
				String opt1="";
				String opt2="";
				String opt3="";
				if(Service_Type_Ind.equals("") || Service_Type_Ind.equals("S")){
					Service_Type_Ind="S";
					opt1="";
					opt2="selected";
					opt3="";
				}else if(Service_Type_Ind.equals("I")){
					Service_Type_Ind="I";
					opt1="";
					opt2="";
					opt3="selected";
				}else{
					Service_Type_Ind="I";
					opt1="selected";
					opt2="";
					opt3="";
				}
			   // Service Type
				String Service_Type=  blCoderPatService.getServTypeDesc();
				Service_Type=(Service_Type==null?"":Service_Type);
				//Pre Approval Flag
				String preAppFlag=  blCoderPatService.getPreAppFlag();
				preAppFlag=(preAppFlag==null?"":preAppFlag);
				// CPT Code
				String CPT_Code=  blCoderPatService.getcptCode();
				CPT_Code=(CPT_Code==null?"":CPT_Code);
			   // Service Code
				String Service_Code=  blCoderPatService.getServItemCode();
				Service_Code=(Service_Code==null?"":Service_Code);
			   // Service Description
				String Service_Desc=  blCoderPatService.getServItemDesc();
				Service_Desc=(Service_Desc==null?"":Service_Desc);
			   // Ordering Clinician Id
				String Ordering_Clinician=  blCoderPatService.getPhysicianId();
				Ordering_Clinician=(Ordering_Clinician==null?"":Ordering_Clinician);
				//ordering Physician Name
				String orderingClinicianName=  blCoderPatService.getOrderingPhysicianName();
				orderingClinicianName=(orderingClinicianName==null?"":orderingClinicianName);
			   // Performing Clinician Id
				String Perform_Clinician=  blCoderPatService.getPerformPhysicianId();
				Perform_Clinician=(Perform_Clinician==null?"":Perform_Clinician);
				//Perform Physician Name 
				String performClinicianName=  blCoderPatService.getPerformPhysicianName();
				performClinicianName=(performClinicianName==null?"":performClinicianName);
			   // Quantity
				String Quantity=  blCoderPatService.getServQty();
			   // Modifier/Adjuster
				String Mod_Adjus=  blCoderPatService.getModifierAdjusterId();
				Mod_Adjus=(Mod_Adjus==null?"":Mod_Adjus);
			   // Zero Price
				String Zero_Price=  blCoderPatService.getZeroPriceYN();
				String  disableCancelFlag="";
				Zero_Price=(Zero_Price==null?"":Zero_Price);
				if(Zero_Price.equals("Y")){
					Zero_Price="checked";
					disableCancelFlag="disabled";
				}else{
					Zero_Price="unchecked";
					disableCancelFlag="";
				}					
			   // Approval Number
				String Approval_No=  blCoderPatService.getCDRApprovalNo();
				Approval_No=(Approval_No==null?"":Approval_No);
			   // Approval Date
				String Approval_Date=  blCoderPatService.getCDRApprovalDate();
				Approval_Date=(Approval_Date==null?"":Approval_Date);
				/*if(!Approval_Date.equals("")){
				java.util.Date servdateTime4 = serviceIPSdf.parse(Approval_Date);
				Approval_Date = serviceOPSdf.format(servdateTime4);
				}*/
			   // Service Price
				String Service_Price=  blCoderPatService.getServiceAmount();
			   // Insurance Amount
				String Ins_Amt=  blCoderPatService.getInsuranceAmount();
				Float insAmt=Float.parseFloat(Ins_Amt);
				Ins_Amt = df.format(insAmt);System.err.println("Ins_Amt 2165 "+Ins_Amt);
				//V230222
				String pat_pay=  blCoderPatService.getPatientPayable();
				Float pat_payable=Float.parseFloat(pat_pay);
				pat_pay = df.format(pat_payable);
				
				System.err.println("Ins_Amt 2162 "+Ins_Amt);
				System.err.println("SettlementInd 2162 "+SettlementInd);
				System.err.println("pat_pay 2162 "+pat_pay);
				
				//V230222
			   // Billable CheckBox
				String Billable_Check=  blCoderPatService.getBillableYN();
				Billable_Check=(Billable_Check==null?"":Billable_Check);
				if(Billable_Check.equals("Y")){
					Billable_Check="checked";
				}else{
					Billable_Check="unchecked";
				}	
				//BillYN
				String	Bill_YN=blCoderPatService.getBillYN();
				String  disableBillFlag="";
				String  isbilled="";//V230516
				String boldYN="";//V230516
				System.out.println("Bill_YN "+Bill_YN);
				System.out.println("siteSpecPatPayable "+siteSpecPatPayable);
				
				if(Bill_YN.equals("Y")){
					Bill_YN="checked";
					disableBillFlag="disabled";
					 if(siteSpecSearch.equals("true")){
						isbilled="";//V230516-AAKH-CRF-0153
						boldYN="";
					 }
				}else{
					Bill_YN="unchecked";
					disableBillFlag="";
					 if(siteSpecSearch.equals("true")){
						isbilled="unbilled";//V230516-AAKH-CRF-0153
						boldYN="bolder";
					 }
				}			
			   // Add Row
				String AddRow=  blCoderPatService.getAddRowYN();
				AddRow=(AddRow==null?"":AddRow);
				if(AddRow.equals("Y")){
					AddRow="disabled";
				}else{
					AddRow="";
				}
			   // Cancel Services
				String Cancel_Services=  blCoderPatService.getCancelRowYN();
				String elemProp="";
				Cancel_Services=(Cancel_Services==null?"":Cancel_Services);
				if(Cancel_Services.equals("Y")){
					Cancel_Services="checked";
					elemProp="disabled";
				}else{
					Cancel_Services="unchecked";
					elemProp="";
				}
				//Primary Key Module
				String primKeyModFlag="";
				String primKeyModId=blCoderPatService.getprimaryKeyModID();
				primKeyModId=(primKeyModId==null?"":primKeyModId);
				if(primKeyModId.equals("PH") || primKeyModId.equals("ST")){
					primKeyModFlag="disabled";
				}				
%>
          <tr id="serviceRow<%=limit%>"  onclick="RowChange(this)"  >
            <td class="<%=isbilled%>"><input type="text" onblur="validateDateTime(this)" class="gridDataInputMore <%=boldYN%>" name="serviceDate<%=limit%>" id="serviceDate<%=limit%>" value="<%=Service_Date%>" size="19" maxlength="19"><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('serviceDate<%=limit%>',null,'hh:mm:ss');" <%=disableBillFlag%>><input type="hidden" id="servDateHid<%=limit%>" value="<%=Service_Date%>"></td>
            <td class="<%=isbilled%>"><select name="servicetype<%=limit%>" id="servicetype<%=limit%>" id="servicetype<%=limit%>" onchange="DrugTypeChange(this)">       
	    <option value="Select" <%=opt1%>>-Select-</option>
              <option value="S" <%=opt2%>>Service</option>
              <option value="I" <%=opt3%>>Drug</option>
              </select></td>
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" type="text" maxlength="100" name="serviceTypeDesc<%=limit%>" id="serviceTypeDesc<%=limit%>" value="<%=Service_Type%>"><input type="hidden" id="preAppFlagID<%=limit%>" value=<%=preAppFlag%>></td>
            <td class="<%=isbilled%>">
				<input class="gridDataInput <%=boldYN%>" style="width: 100px" type="text" name="cptCode<%=limit%>" onblur="validateCPTCode(this)" id="cptCode<%=limit%>" value="<%=CPT_Code%>" ><%if(!siteSpecServiceCode){%>
				<input class="gridDataInput <%=boldYN%>" type="hidden" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value="<%=Service_Code%>"><%}%>
			</td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->
            <td class="<%=isbilled%>"><input class="gridDataInputMore <%=boldYN%>" type="text" name="serviceDesc<%=limit%>" id="serviceDesc<%=limit%>" value="<%=Service_Desc%>" title="<%=Service_Desc%>"></td><!-- V201222 Modified -->
			<%if(siteSpecServiceCode){%><!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value="<%=Service_Code%>"></td>
			<%}%>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="orderClinic<%=limit%>" id="orderClinic<%=limit%>" value="<%=orderingClinicianName%>" ><input style="display:none;" type="text" id="orderClinicID<%=limit%>" value="<%=Ordering_Clinician%>"> </td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" onblur="performClinicianBlur(this);" name="performClinic<%=limit%>" id="performClinic<%=limit%>" value="<%=performClinicianName%>"><input type="button" class="button" value="?" onclick="performingClinicianLookUp(this)" id='PerformLovButton' name ="PerformLovButton" <%=elemProp%> <%=disableBillFlag%>><input style="display:none;" type="text" id="performClinicID<%=limit%>" value="<%=Perform_Clinician%>"><input style="display:none;" type="text" id="modifyYN<%=limit%>" value="N" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" style="width: 50px;" type="text" onkeypress="return restrictAlphabets(event);" name="serviceQty<%=limit%>" id="serviceQty<%=limit%>" onblur="validateServQty(this)" value="<%=Quantity%>" ><input style="display:none;" type="text" id="serviceRateCharge<%=limit%>" value="" ></td><!-- V201222 Modified -->
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" type="text" maxlength="30" value="<%=Mod_Adjus%>" ></td>
            <td class="<%=isbilled%>"><input type="checkbox" name="checkboxZero<%=limit%>" id="checkboxZero<%=limit%>"  <%=Zero_Price%> id="checkboxZero<%=limit%>" onclick="zeroPriceClick(this)"  value="<%=Zero_Price%>" /></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="ApproveNum<%=limit%>" id="ApproveNum<%=limit%>" maxlength="20" onblur="ModAppNo(this);" value="<%=Approval_No%>" ><input type="hidden" id="appNoHid<%=limit%>" value="<%=Approval_No%>"><input style="display:none;" type="text" id="serviceModAppNo<%=limit%>" value="N" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" style="width: 75px;" type="text" name="ApproveDate<%=limit%>" id="ApproveDate<%=limit%>" onblur="ModAppNo(this);"  value="<%=Approval_Date%>" size="19" maxlength="19" ><input type="hidden" id="appDateHid<%=limit%>" value="<%=Approval_Date%>"><img id="AppDateImg<%=limit%>" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('ApproveDate<%=limit%>',null,'hh:mm:ss');" <%=disableBillFlag%>></td> <!-- V201222 Modified -->
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="ServPrice<%=limit%>" onkeypress="return restrictAlphabets(event);" onblur="isNo(this)" id="ServPrice<%=limit%>"  value="<%=Service_Price%>"></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="InsAmt<%=limit%>"  id="InsAmt<%=limit%>" value="<%=Ins_Amt%>" disabled></td>
			<% if(siteSpecPatPayable.equals("true")){%>
			 <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="patPay<%=limit%>" id="patPay<%=limit%>" value="<%=pat_pay%>" disabled></td>
			<%} //V230222
			%>
            <td class="<%=isbilled%>">
			<input type="checkbox" name="checkboxBill<%=limit%>" id="checkboxBill<%=limit%>" value="<%=Billable_Check%>" id="checkboxBill<%=limit%>"  onclick="billClick(this)" <%=Billable_Check%>/><input style="display:none;" type="text" id="serviceBillCheck<%=limit%>" value="<%=Bill_YN%>" >
			</td>
            <td class="<%=isbilled%>"><input type="button" name="AddBTn<%=limit%>" id="AddBTn<%=limit%>"  value="+" onclick="<%if(siteSpecServiceCode){%>addRow1(this);<%}else{
			%>addRow(this)<%}%>" <%if(siteSpecServiceCode && coderClearanceStatus.equals("Y")){%> disabled <%}%> id="AddBTn<%=limit%>">
			<input style="display:none;" type="text" id="serviceAddRow<%=limit%>" value="" ></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->
            <td class="<%=isbilled%>"><input type="checkbox" name="Cancelcheck<%=limit%>" id="Cancelcheck<%=limit%>" value="" id="Cancelcheck<%=limit%>" onclick="CancelClick(this)" <%=Cancel_Services%> <%=disableCancelFlag%> <%=primKeyModFlag%> /><input style="display:none;" type="text" id="serviceCancelRow<%=limit%>" value="" ><input style="display:none;" type="text" id="primKeyModuleID<%=limit%>" value="<%=primKeyModId%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=BillDocTypeCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=BillDocNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=CustGrpCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=CustCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRef%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRefLineNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRefSeqNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDate%>"></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=SettlementInd%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=PatientAmt%>" ></td>
			<td style="display:none;"><input type="text" style="display:none;" id="keyValId<%=limit%>" value="<%=KeyValue%>" ></td>
			<% if(siteSpecSearch.equals("true") || siteSpecPatPayable.equals("true")){%>
			<td style="display:none;"><input type="hidden" name="isbilled<%=limit%>" id="isbilled<%=limit%>" id="isbilled<%=limit%>" value="<%=isbilled%>"></td>
			<td style="display:none;"><input type="hidden" name="boldYN<%=limit%>" id="boldYN<%=limit%>" id="boldYN<%=limit%>" value="<%=boldYN%>"></td>
			<% }%>
			</tr>
			<%				
			} 
			limit++;				
         }
      }//V201015 Starts
	  else{
		   %>
        <tr id="serviceRow<%=limit%>"  onclick="RowChange(this)">
            <td><input type="text" onblur="validateDateTime(this)" class="gridDataInputMore" name="serviceDate<%=limit%>" id="serviceDate<%=limit%>" id="serviceDate<%=limit%>" value="" size="19" maxlength="19"><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('serviceDate<%=limit%>',null,'hh:mm:ss');"><input type="hidden" id="servDateHid<%=limit%>" value=""></td>
            <td><select name="servicetype<%=limit%>" id="servicetype<%=limit%>" id="servicetype<%=limit%>" onchange="DrugTypeChange(this)">       
					<option value="Select" >-Select-</option>
              <option value="S" selected>Service</option>
              <option value="I" >Drug</option>
              </select></td>
            <td><input class="gridDataInputLess" type="text" maxlength="100" name="serviceTypeDesc<%=limit%>" id="serviceTypeDesc<%=limit%>" id="serviceTypeDesc<%=limit%>" value="" ><input type="hidden" id="preAppFlagID<%=limit%>" value="N"></td>
            <td><input class="gridDataInput" type="text" name="cptCode<%=limit%>" id="cptCode<%=limit%>" onblur="validateCPTCode(this)" id="cptCode<%=limit%>" value="" ><%if(!siteSpecServiceCode){%><input class="gridDataInput" type="hidden" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value=""><%}%><input type='button' class='button' value='?' onclick='callCPTSearch(this)' name = 'servCodeLovButton'></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->
            <td><input class="gridDataInputMore" type="text" name="serviceDesc<%=limit%>" id="serviceDesc<%=limit%>" id="serviceDesc<%=limit%>" value="" ></td><!-- V201222 Modified -->
			<%if(siteSpecServiceCode){%><!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<td><input class="gridDataInput" type="text" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value=""></td>
			<%}%>
            <td><input class="gridDataInput" type="text" name="orderClinic<%=limit%>" id="orderClinic<%=limit%>" id="orderClinic<%=limit%>" value="" ><input style="display:none;" type="text" id="orderClinicID<%=limit%>" value=""><input type='button' class='button' value='?' onclick='orderingClinicianLookUp(this)' name = 'OrderLovButton'> </td>
            <td><input class="gridDataInput" type="text" onblur="performClinicianBlur(this);" name="performClinic<%=limit%>" id="performClinic<%=limit%>" id="performClinic<%=limit%>" value=""><input type="button" class="button" value="?" onclick="performingClinicianLookUp(this)" id='PerformLovButton' name ="PerformLovButton"><input style="display:none;" type="text" id="performClinicID<%=limit%>" value=""><input style="display:none;" type="text" id="modifyYN<%=limit%>" value="N" ></td>
            <td><input class="gridDataInputLess" style="width: 50px;" type="text" onkeypress="return restrictAlphabets(event);" name="serviceQty<%=limit%>" id="serviceQty<%=limit%>" id="serviceQty<%=limit%>" onblur="validateServQty(this)" value="1" ><input style="display:none;" type="text" id="serviceRateCharge<%=limit%>" value="" ></td><!-- V201222 Modified -->
            <td><input class="gridDataInputLess" type="text" maxlength="30" value="" ></td>
            <td><input type="checkbox" name="checkboxZero<%=limit%>" id="checkboxZero<%=limit%>"  id="checkboxZero<%=limit%>" onclick="zeroPriceClick(this)"  value="" /></td>
            <td><input class="gridDataInput" type="text" name="ApproveNum<%=limit%>" id="ApproveNum<%=limit%>" id="ApproveNum<%=limit%>" maxlength="20" onblur="ModAppNo(this);" value="" ><input style="display:none;" type="text" id="serviceModAppNo<%=limit%>" value="N" ></td>
            <td><input class="gridDataInput" style="width: 75px;" type="text" name="ApproveDate<%=limit%>" id="ApproveDate<%=limit%>" id="ApproveDate<%=limit%>" onblur="ModAppNo(this);"  value="" size="19" maxlength="19" ><img id="AppDateImg<%=limit%>" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('ApproveDate<%=limit%>',null,'hh:mm:ss');"></td><!-- V201222 Modified -->
            <td><input class="gridDataInput" type="text" name="ServPrice<%=limit%>" id="ServPrice<%=limit%>" onkeypress="return restrictAlphabets(event);" onblur="isNo(this)" id="ServPrice<%=limit%>"  value=''></td>
            <td><input class="gridDataInput" type="text" name="InsAmt<%=limit%>" id="InsAmt<%=limit%>"  id="InsAmt<%=limit%>" value='' disabled></td>
			<% if(siteSpecPatPayable.equals("true")){%>
			 <td><input class="gridDataInput" type="text" name="patPay<%=limit%>" id="patPay<%=limit%>" id="patPay<%=limit%>" value="" disabled></td>
			<%} //V230222
			%>
            <td><input type="checkbox" name="checkboxBill<%=limit%>" id="checkboxBill<%=limit%>" value="checked" id="checkboxBill<%=limit%>"  onclick="billClick(this)" checked/><input style="display:none;" type="text" id="serviceBillCheck<%=limit%>" value="" ></td>
            <td><input type="button" name="AddBTn<%=limit%>" id="AddBTn<%=limit%>"  value="+" onclick="<%	if(siteSpecServiceCode){%>addRow1(this);<%}else{
			%>addRow(this)<%}%>"  id="AddBTn<%=limit%>"><input style="display:none;" type="text" id="serviceAddRow<%=limit%>" value="Y" ></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->
            <td><input type="checkbox" name="Cancelcheck<%=limit%>" id="Cancelcheck<%=limit%>" value="" id="Cancelcheck<%=limit%>" onclick="CancelClick(this)"/><input style="display:none;" type="text" id="serviceCancelRow<%=limit%>" value="N" ><input style="display:none;" type="text" id="primKeyModuleID<%=limit%>" value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value=""></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="" ></td>
			<td style="display:none;"><input type="text" style="display:none;" id="keyValId<%=limit%>" value="" ></td>
			<% if(siteSpecSearch.equals("true") || siteSpecPatPayable.equals("true")){%>
			<td style="display:none;"><input type="hidden" name="isbilled<%=limit%>" id="isbilled<%=limit%>" id="isbilled<%=limit%>" value=""></td>
			<td style="display:none;"><input type="hidden" name="boldYN<%=limit%>" id="boldYN<%=limit%>" id="boldYN<%=limit%>" value=""></td>
			<% }%>
			</tr>
		<%
	  }	
		//V201015 Ends	  
%>
          </table></td>
        </tr>
      <tr>        
          <td style="text-align:left">
          <input type="submit" name="Save3" id="Save3" id="Save3" value="Save" onclick="document.getElementById('Save3').disabled = true; document.getElementById('Save3').style.opacity='0.5'; return SaveServices();"/>
          <input type="button" name="Close1" id="Close1" id="Close1" value="Close" onclick="windowClose()"/></td>
        </tr>
      </table></td>
  </tr>
</table>
</center>
		  
<input type="hidden" name="locale" id="locale" id="locale" value="<%=localeLang%>">
<input type="hidden" name="FacilityId" id="FacilityId" id="FacilityId" value="<%=facilityId%>">
<input type="hidden" name="ServEncounterId" id="ServEncounterId" id="ServEncounterId" value="<%=encounter_id%>"> 
<input type="hidden" name="EpisodeId" id="EpisodeId" id="EpisodeId" value="<%=EpisodeID%>">
<input type="hidden" name="EpisodeType" id="EpisodeType" id="EpisodeType" value="<%=EpisodeType%>"> 
<input type="hidden" name="PatientId" id="PatientId" id="PatientId" value="<%=PatientID%>">
<input type="hidden" name="VisitId" id="VisitId" id="VisitId" value="<%=VisitID%>"> 
<input type="hidden" name="loginUser" id="loginUser" id="loginUser" value="<%=loginUser%>"> 
<input type="hidden" name="logInWSno" id="logInWSno" id="logInWSno" value="<%=logInWSno%>"> 
<input type="hidden" name="logInUserId" id="logInUserId" id="logInUserId" value="<%=logInUserId%>"> 
<input type="hidden" name="SessionId" id="SessionId" id="SessionId" value="<%=SessionId%>">
<input type="hidden" name="siteSpecPatPayable" id="siteSpecPatPayable" id="siteSpecPatPayable" value="<%=siteSpecPatPayable%>"> <!--V230222-->
<input type="hidden" name="serviceSize" id="serviceSize" id="serviceSize" value="<%=serviceSize%>"><!--V201015 Added-->
<input type="hidden" name="siteSpecServiceCode" id="siteSpecServiceCode" id="siteSpecServiceCode" value="<%=siteSpecServiceCode%>"><!--V201015 Added-->
<input type="hidden" name="siteSpecSearch" id="siteSpecSearch" id="siteSpecSearch" value="<%=siteSpecSearch%>"><!--V230529 Added-->
<input type="hidden" name="limit" id="limit" id="limit" value="<%=limit%>">

  </form>
  <div class='COLUMNHEADER' name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden; background-color:blue;'>
	 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border-collapse=collapse  style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>
  </body>
</html>

