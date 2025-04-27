function trim(myString) {
	return myString.replace(/^\s+|\s+$/g, '');
}
function submit_user_pwd() {

	xmlStr = "<root><SEARCH ";
	xmlStr += " name=\"" + document.forms[0].name.value + "\"";
	xmlStr += " password=\"" + document.forms[0].password.value + "\"";
	xmlStr += " level=\"" + document.forms[0].level.value + "\"";
	xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
	xmlStr += " compname=\"" + document.forms[0].compname.value + "\"";
	xmlStr += " domain=\"" + document.forms[0].domain.value + "\"";
	xmlStr += " ext_user_yn=\"Y\"";
	xmlStr += " /></root>";
	//alert(xmlStr);
	var xmlDoc;
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr,"text/xml");

	} else {

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	}
	
	xmlHttp.onreadystatechange=function(){
		//alert(xmlHttp2.readyState+' '+xmlHttp2.status);
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
		var responseText = xmlHttp.responseText;
	//alert(responseText);
	var rText = "";
	rText = responseText;
	//alert('rtext value='+rText+':');
	if (rText != null)
		rText = rText.replace(/^\s+|\s+$/g, '');

	if (rText != null && rText != "home.jsp") {
		var result = rText.split("||");
		var result0 = result[0];
		var result1 = result[1];
		var result2 = result[2];

		if (result0 == "error_num=1") {
			var result1plt = result2.split("=");
			alert(result1plt[1]);
		} else {
			var colval = result2.split("==");
			var respval = colval[0].split("$$");
			var respcount = respval[0];
			var respCode_desc = respval[1];
			var classvalue;
			var facresult = colval[1];
			var facilityval = facresult.split("$$");
			var facCount = facilityval[0];
			var facCode_desc = facilityval[1];
			var blogin = false;
			
			if( respcount == "0" || facCount == "0" ){
				alert("You do not have sufficient rights to Login");
			
			}
			else if (respcount == "1" && facCount == "1") { // checks whether the
				// user has only one
				// responsibity ID and
				// facilityID
				var responsibilities = respCode_desc.split("~");
				var facilities = facCode_desc.split("~");
				var respID = responsibilities[0];
				var respName = responsibilities[1];
				var facID = facilities[0];
				var facName = facilities[1];
				document.getElementById("responsibility_id").value = respID;
				document.getElementById("responsibility_name").value = respName;
				document.getElementById("facility_id").value = facID;
				document.getElementById("facility_name").value = facName;
				singleresp_faci(respID,respName);
				
			} 
			else 
			{ // IF there are morethan one responsibilityID

				var RespFaciHdnObj = document.getElementById("RespFaciList");
				var loginformObj = document.getElementById("login_form");
				if (RespFaciHdnObj) {
					RespFaciHdnObj.value = result2;
				}
				if (loginformObj) {
					loginformObj.action = contextPath+"/ipadlogin";
					loginformObj.submit();
				}

			}
		}

	}//end if 
		}
	}

	xmlHttp.open("POST", contextPath+"/servlet/eSM.LoginResponseServlet", false);
	xmlHttp.send(xmlDoc);
	

}
function singleresp_faci(obj,respName){
	document.getElementById("responsibility_id").value=obj;
	document.getElementById("responsibility_name").value=respName;

	// here comes the code which will validate
	// the responsibility id selected by the user
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	var xmlHttp;
	var xmlDoc;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}  
	
	xmlHttp.onreadystatechange=function(){
		//alert(xmlHttp.readyState+' '+xmlHttp.status);
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			var respText = xmlHttp.responseText;
			respText = respText.replace(/^\s+|\s+$/g, '');
			if(respText.length > 0){
				var facCount = 0;
				var facResult = respText.split("^");
				var facResultStr = facResult[0];
				var facCntStr = facResult[1];
				facCount = parseInt(facCntStr);
				var facilities = facResultStr.split("~");
				var respNum = parseInt(respText);
				var formFacilityID = document.getElementById("facility_id").value;
				if(facCount <= 0){
					alert("You do not have sufficient rights to Login");
					logout();
					
				}else if(formFacilityID == facilities[0])
				{
					singleresp_faci_clinicianchk();
				}
				else {
					alert("You do not have sufficient rights to Login");
					logout();
				}
			}
			else{
				alert('Could not validate the responsibility selected by the user');
				logout();
				
			}
		}
	}
	
	xmlHttp.open("POST", "eSM/jsp/FacilitySelect.jsp", false);
	xmlHttp.send(xmlDoc);
			
}

//function checks if the user has clinician access
function singleresp_faci_clinicianchk(){
	
	var respId = document.getElementById("responsibility_id").value;
	// here comes the code which will validate
	// the responsibility id selected by the user
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + respId + "\"";
	xmlStr +=" /></root>" ;
	var xmlDoc;
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}  
	
	xmlHttp.onreadystatechange=function(){
		//alert(xmlHttp2.readyState+' '+xmlHttp2.status);
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			var respText = xmlHttp.responseText;
			var facilitymessage;
			if(respText.length > 0){
				var respNum = parseInt(respText);
				if(respNum <= 0){

					alert("You do not have sufficient rights to Login");
					logout();
					
				}else{
					document.getElementById("login_form").action = "eIPAD/jsp/IPad.jsp";
					document.getElementById("login_form").submit();
				}
			}
			else{

				alert('Could not validate the responsibility selected by the user');
				logout();
				
			}
		}
	}
	
	xmlHttp.open("POST", contextPath+"/eIPAD/jsp/Login-Validate.jsp", false);
	xmlHttp.send(xmlDoc);

}


function loginAppl(){

	//----------Mz changes modified code start---------------------
		  //  document.getElementById("errMSGID").innerHTML="";
	if((document.forms[0].responsibility_id.value!=null && document.forms[0].responsibility_id.value!="") && (document.forms[0].facility_id.value!=null && document.forms[0].facility_id.value!="")){
		document.forms[0].level.value='3';
		//document.forms[0].submit();	
		//var xmlDoc="";
		//var xmlHttp = new XMLHttpRequest();
		//alert(document.forms[0].facility_id.value);
		xmlStr	="<root><SEARCH " ;
		xmlStr += " name=\"" + document.forms[0].name.value + "\""	;
		xmlStr += " level=\"" + document.forms[0].level.value + "\"";
		xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
		xmlStr += " responsibility_id=\"" +encodeURIComponent(document.forms[0].responsibility_id.value)+ "\"";
		xmlStr += " responsibility_name=\"" +encodeURIComponent(document.forms[0].responsibility_name.value)+ "\"";
		xmlStr += " facility_id=\"" +encodeURIComponent(document.forms[0].facility_id.value)+ "\"";
		xmlStr += " facility_name=\"" +encodeURIComponent(document.forms[0].facility_name.value)+ "\"";
		xmlStr += " compname=\"" +document.forms[0].compname.value+ "\"";
		xmlStr += " domain=\"" +document.forms[0].domain.value+ "\"";
		xmlStr +=" /></root>" ;
			   // alert(xmlStr);
				var xmlDoc;
			 var xmlHttp;
			 if(navigator.appName.indexOf("Internet") ==-1)	
			 {	
			  xmlHttp = new XMLHttpRequest();
				  var oParser = new DOMParser();
				  xmlDoc = oParser.parseFromString(xmlStr, "text/xml"); 

			 }		
			else
			{

			 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			 xmlDoc	= new ActiveXObject( "Microsoft.XMLDom" ) ;
			 xmlDoc.loadXML( xmlStr );
		 
			}   
				
		//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST",contextPath+"/servlet/eSM.LoginResponseServlet", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//alert(responseText);
		//responseText = trimString(responseText);
		loginApplication(responseText);	
	}
}
		
function loginApplication(flagval){

	document.getElementById("login_form").submit();

}

function change_resp(obj,respName){
	document.getElementById("responsibility_id").value=obj;
	document.getElementById("responsibility_name").value=respName;

	// here comes the code which will validate
	// the responsibility id selected by the user
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	var xmlHttpObj;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttpObj = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {
		xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}  
	
	xmlHttpObj.onreadystatechange=function(){
		//alert(xmlHttp2.readyState+' '+xmlHttp2.status);
		if(xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
			var respText = xmlHttpObj.responseText;
			var facilitymessage="";
			if(respText.length > 0){
				var respNum = parseInt(respText);
				if(respNum <= 0){
					//facilitymessage='<div class="facilityNotAvailable">You do not have sufficient rights to Login</div>';
					showFacilites(obj,facilitymessage);
					alert("You do not have sufficient rights to Login");
					
				}else{
					calculateResponsibility(obj);
				}
			}
			else{
				//facilitymessage='<div class="facilityNotAvailable">Could not validate the responsibility selected by the user</div>';
				showFacilites(obj,facilitymessage);
				alert('Could not validate the responsibility selected by the user');
				
			}
		}
	}
	
	xmlHttpObj.open("POST", contextPath+"/eIPAD/jsp/Login-Validate.jsp", true);
	xmlHttpObj.send(xmlDoc);
			
}

function showFacilites(id,message){
	
	//close all other shown facility boxes
	$(".loginFacilityBox").hide();
	$(".loginFaciImageBox").show();
	$(".btn3-theme").addClass('btn2-theme').removeClass('btn3-theme');
	
	var FacilityListBox =  document.getElementById('FacilityBox_'+id);
	FacilityListBox.innerHTML = message;
	$("#RespSelectImage_"+id).hide();//"slide", {}, 2000 );
	$("#FacilityBox_"+id).show();//"slide", {}, 2000 );
	$("#RespSelectRespButton_"+id).removeClass('btn2-theme').addClass('btn3-theme');
	
	//$("#RespSelectImage_"+id).animate({height:"0px"},'slow');
	//$("#FacilityBox_"+id).animate({height:"157px"},'slow');
	
	if ($('#WrapperNestedFaci_'+id).is(':visible')) {
		var wrapperId = 'WrapperNestedFaci_' +id;
		var FacilitesScroll;
		FacilitesScroll = new iScroll(wrapperId, {
			useTransform : true,
			zoom : false,

			onBeforeScrollStart : function(e) {
				var target = e.target;
				while (target.nodeType != 1) target = target.parentNode;

				if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
				e.preventDefault();

				e.stopPropagation();
			}
		});
		if(FacilitesScroll!=null){
			FacilitesScroll.refresh();
		}
	}
	
	
}
function calculateResponsibility(obj){
	
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	}  
	
	xmlHttp.open( "POST","eSM/jsp/FacilitySelect.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	addfacility(responseText,obj);
	
}

function addfacility(valueText,respId){
	
	if(valueText.length == 0){
		alert('Facility could not be obtained for the Responsibility '+respId);
		return false;
	}
	
	var facCount = 0;
	var facResult = valueText.split("^");
	var facResultStr = facResult[0];
	var facCntStr = facResult[1];
	facCount = parseInt(facCntStr);
	
	
	var facilities = facResultStr.split("$");
	var facilitiesLen = facilities.length;
	var facilityAppend = '<div id="WrapperNestedFaci_' +respId+ '" class="loginFaciWrapperNested">';
	facilityAppend = facilityAppend+ '<div id="ScrollerNestedFaci" class="loginFaciScrollerNested"><div style="display:table;width:100%;height:100%">';

		for (var i=0; i<facCount; i++){
				var	fac;
				
				fac=(facilities[i]).split("~");
				var facID=trim(fac[0]);
				var facName=trim(fac[1]);
				
				//alert(facID);
				//var facilityAppend = '<table width="100%" border="0" cellpadding="0" cellspacing="0" class="itemborder"><tr><td align="left" valign="middle" class="radiocontent"><input type="radio" name="facradio" id="facradio" id="facradio'+i+'" value="'+facID+'" onclick = showfacility(\'' + facID + '\', \'' + facName + '\')>' + facName + '</td></tr></table>';
				
				 facilityAppend =  facilityAppend + '<div style="display:table-row;"><div class="loginFacilityItemRow btn4-theme normText3-theme" id="RespSelectFacilityItemRow_'+respId+'" onclick ="setfacility(\'' +facID+ '\',\'' +facName+ '\');">' + facName + '</div></div>';
			
				
				//document.login_form.level.value="3";
				login_fac_flag=true;
			}
		facilityAppend = facilityAppend + '</div></div></div>';
		
		showFacilites(respId,facilityAppend)
}
	
function setfacility(facID,facName){
	
	document.getElementById("facility_id").value=facID;
	document.getElementById("facility_name").value=facName; 	
	loginAppl();
	
}
function logout()
{
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				window.location = contextPath+"/ipadlogin";
			}
		}
		xmlhttp.open("POST", contextPath+"/eIPAD/jsp/Logoff.jsp", true);
		xmlhttp.send();
}

